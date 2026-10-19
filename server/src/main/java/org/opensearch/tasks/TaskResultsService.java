            logger.error(  
import org.opensearch.action.admin.indices.create.CreateIndexRequest;  
    private void doStoreResult(TaskResult taskResult, ActionListener<Void> listener) {  
import org.opensearch.common.unit.TimeValue;
/**  
import org.opensearch.cluster.metadata.IndexMetadata;  
        } catch (IOException e) {
        doStoreResult(STORE_BACKOFF_POLICY.iterator(), index, listener);
            createIndexRequest.cause("auto(task api)");  
        index.execute(new ActionListener<IndexResponse>() {  
        }
import org.apache.logging.log4j.Logger;
import org.opensearch.common.util.io.Streams;  
            createIndexRequest.mapping(taskResultIndexMapping());
    private final ClusterService clusterService;
                public void onResponse(CreateIndexResponse result) {
        }
                if (false == (e instanceof OpenSearchRejectedExecutionException) || false == backoff.hasNext()) {
    public void storeResult(TaskResult taskResult, ActionListener<Void> listener) {  
            });
            throw new OpenSearchException("Couldn't convert task result to XContent for [{}]", e, taskResult.getTask());  
import org.opensearch.ExceptionsHelper;  
 * SPDX-License-Identifier: Apache-2.0
    }
    private void doStoreResult(Iterator<TimeValue> backoff, IndexRequestBuilder index, ActionListener<Void> listener) {
        @SuppressWarnings("unchecked")
 *
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
            createIndexRequest.settings(taskResultIndexSettings());  
                        listener.onFailure(e);
 * software distributed under the License is distributed on an
                        // we have the index, do it
import org.opensearch.cluster.metadata.MappingMetadata;
        }
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                public void onFailure(Exception e) {  
import org.opensearch.transport.client.Client;
     * The backoff policy to use when saving a task result fails. The total wait  
        this.client = new OriginSettingClient(client, TASKS_ORIGIN);
                    .preparePutMapping(TASK_INDEX)
                    if (ExceptionsHelper.unwrapCause(e) instanceof ResourceAlreadyExistsException) {
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
import org.opensearch.ResourceAlreadyExistsException;
 * The OpenSearch Contributors require contributions made to  
        });
            @Override  
import java.util.Map;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        } catch (Exception e) {
    }
                            listener.onFailure(inner);
        }  
import org.apache.logging.log4j.LogManager;  
                    doStoreResult(taskResult, listener);
            );  
import org.opensearch.action.bulk.BackoffPolicy;
import org.opensearch.action.index.IndexResponse;
            .put(IndexMetadata.SETTING_PRIORITY, Integer.MAX_VALUE)
                }  
    public TaskResultsService(Client client, ClusterService clusterService, ThreadPool threadPool) {  
                        try {  
            index.setSource(builder);
            } else {
    /**
import org.opensearch.cluster.service.ClusterService;
            @Override
package org.opensearch.tasks;
        MappingMetadata mappingMetadata = metadata.mapping();  
    }
    public static final String TASK_RESULT_INDEX_MAPPING_FILE = "task-index-mapping.json";
                            inner.addSuppressed(e);  
    @Inject
import java.util.Iterator;  
 * specific language governing permissions and limitations
            IndexMetadata metadata = state.getMetadata().index(TASK_INDEX);  
        try (InputStream is = getClass().getResourceAsStream(TASK_RESULT_INDEX_MAPPING_FILE)) {
 */
public class TaskResultsService {
 * GitHub history for details.
            if (getTaskResultMappingVersion(metadata) < TASK_RESULT_MAPPING_VERSION) {
            public void onFailure(Exception e) {
                // The index already exists but doesn't have our mapping
    public String taskResultIndexMapping() {  
            }
                doStoreResult(taskResult, listener);  
/*
                client.admin()  
/*
        IndexRequestBuilder index = client.prepareIndex(TASK_INDEX).setId(taskResult.getTask().getTaskId().toString());
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.opensearch.transport.client.OriginSettingClient;
                    threadPool.schedule(() -> doStoreResult(backoff, index, listener), wait, ThreadPool.Names.SAME);
            CreateIndexRequest createIndexRequest = new CreateIndexRequest();
                () -> new ParameterizedMessage("failed to create tasks results index template [{}]", TASK_RESULT_INDEX_MAPPING_FILE),
        this.threadPool = threadPool;  
            public void onResponse(IndexResponse indexResponse) {
 * under the License.  
     */
    private final ThreadPool threadPool;  
            client.admin().indices().create(createIndexRequest, new ActionListener<CreateIndexResponse>() {
    static final BackoffPolicy STORE_BACKOFF_POLICY = BackoffPolicy.exponentialBackoff(timeValueMillis(250), 14);  
                    logger.warn(() -> new ParameterizedMessage("failed to store task result, retrying in [{}]", wait), e);  
        if (meta == null || meta.containsKey(TASK_RESULT_MAPPING_VERSION_META_FIELD) == false) {  
import org.opensearch.OpenSearchException;
import static org.opensearch.action.admin.cluster.node.tasks.get.GetTaskAction.TASKS_ORIGIN;  
                    .execute(ActionListener.delegateFailure(listener, (l, r) -> doStoreResult(taskResult, listener)));
 * this work for additional information regarding copyright
            return 0;
        } else {
import java.io.IOException;  
        this.clusterService = clusterService;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
        if (state.routingTable().hasIndex(TASK_INDEX) == false) {
 * Licensed to Elasticsearch under one or more contributor  
            }
        }
import org.opensearch.transport.client.Requests;  
 */
 * Service that can store task results.
import org.opensearch.threadpool.ThreadPool;  
            throw new IllegalStateException("failed to create tasks results index template [" + TASK_RESULT_INDEX_MAPPING_FILE + "]", e);
    }  
                } else {
 * KIND, either express or implied.  See the License for the
 */
                }  
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Streams.copy(is, out);  
            createIndexRequest.index(TASK_INDEX);
                            doStoreResult(taskResult, listener);
        if (mappingMetadata == null) {
                    listener.onFailure(e);  
import org.opensearch.cluster.ClusterState;
 *
 * ownership. Elasticsearch licenses this file to you under  
    private static final Logger logger = LogManager.getLogger(TaskResultsService.class);
 */  
                    .indices()
 * Unless required by applicable law or agreed to in writing,
    private final Client client;
                @Override
            taskResult.toXContent(builder, ToXContent.EMPTY_PARAMS);  
import org.opensearch.core.xcontent.XContentBuilder;
 * the Apache License, Version 2.0 (the "License"); you may
                    TimeValue wait = backoff.next();
                    } else {  
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(Requests.INDEX_CONTENT_TYPE)) {
     * time is 600000 milliseconds, ten minutes.
import org.opensearch.common.inject.Inject;  
                    }
                        }
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)  
    }
            .put(IndexMetadata.INDEX_AUTO_EXPAND_REPLICAS_SETTING.getKey(), "0-1")
 * Modifications Copyright OpenSearch Contributors. See  
        ClusterState state = clusterService.state();
        Map<String, Object> meta = (Map<String, Object>) mappingMetadata.sourceAsMap().get("_meta");
        return Settings.builder()
 * @opensearch.internal  
    private Settings taskResultIndexSettings() {
                listener.onResponse(null);  
    private int getTaskResultMappingVersion(IndexMetadata metadata) {
    public static final int TASK_RESULT_MAPPING_VERSION = 5; // must match version in task-index-mapping.json  
            .build();  
    }
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
 * not use this file except in compliance with the License.
import org.opensearch.common.settings.Settings;
                e
import java.io.InputStream;
 * this file be licensed under the Apache-2.0 license or a
            return out.toString(StandardCharsets.UTF_8.name());
        return (int) meta.get(TASK_RESULT_MAPPING_VERSION_META_FIELD);  
                }
 *  
import org.opensearch.core.action.ActionListener;
    public static final String TASK_RESULT_MAPPING_VERSION_META_FIELD = "version";
import org.opensearch.core.xcontent.ToXContent;
}
 * compatible open source license.
    public static final String TASK_INDEX = ".tasks";  
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
                    .setSource(taskResultIndexMapping(), MediaTypeRegistry.JSON)  
            }  
            return 1; // The mapping was created before meta field was introduced
import org.opensearch.action.index.IndexRequestBuilder;  
                        } catch (Exception inner) {
                @Override  
 *
    }  
/*  
