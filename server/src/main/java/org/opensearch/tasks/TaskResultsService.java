 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .put(IndexMetadata.INDEX_AUTO_EXPAND_REPLICAS_SETTING.getKey(), "0-1")
/*
import org.opensearch.action.bulk.BackoffPolicy;
        index.execute(new ActionListener<IndexResponse>() {
import org.opensearch.action.index.IndexResponse;
                () -> new ParameterizedMessage("failed to create tasks results index template [{}]", TASK_RESULT_INDEX_MAPPING_FILE),
        });
    private int getTaskResultMappingVersion(IndexMetadata metadata) {
                    threadPool.schedule(() -> doStoreResult(backoff, index, listener), wait, ThreadPool.Names.SAME);
    public void storeResult(TaskResult taskResult, ActionListener<Void> listener) {
 *
            });
        }
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
        try (InputStream is = getClass().getResourceAsStream(TASK_RESULT_INDEX_MAPPING_FILE)) {
                    listener.onFailure(e);
            if (getTaskResultMappingVersion(metadata) < TASK_RESULT_MAPPING_VERSION) {
import java.io.InputStream;
            createIndexRequest.settings(taskResultIndexSettings());
                }
 */
    public static final String TASK_RESULT_MAPPING_VERSION_META_FIELD = "version";
                    .setSource(taskResultIndexMapping(), MediaTypeRegistry.JSON)
 * ownership. Elasticsearch licenses this file to you under
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to
        if (meta == null || meta.containsKey(TASK_RESULT_MAPPING_VERSION_META_FIELD) == false) {
     * The backoff policy to use when saving a task result fails. The total wait
 *
                        listener.onFailure(e);
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
    private static final Logger logger = LogManager.getLogger(TaskResultsService.class);
    public static final int TASK_RESULT_MAPPING_VERSION = 5; // must match version in task-index-mapping.json
            );
                @Override
import java.io.IOException;
 * Modifications Copyright OpenSearch Contributors. See
    @Inject
/*
/**
    }
                }
                            listener.onFailure(inner);
        return (int) meta.get(TASK_RESULT_MAPPING_VERSION_META_FIELD);
 * specific language governing permissions and limitations
        }
                    logger.warn(() -> new ParameterizedMessage("failed to store task result, retrying in [{}]", wait), e);
import static org.opensearch.action.admin.cluster.node.tasks.get.GetTaskAction.TASKS_ORIGIN;
                public void onFailure(Exception e) {
            @Override
                client.admin()
}
 */
            return 0;
            CreateIndexRequest createIndexRequest = new CreateIndexRequest();
            }
import java.util.Map;
    static final BackoffPolicy STORE_BACKOFF_POLICY = BackoffPolicy.exponentialBackoff(timeValueMillis(250), 14);
package org.opensearch.tasks;
 * license agreements. See the NOTICE file distributed with
            createIndexRequest.cause("auto(task api)");
                if (false == (e instanceof OpenSearchRejectedExecutionException) || false == backoff.hasNext()) {
                    if (ExceptionsHelper.unwrapCause(e) instanceof ResourceAlreadyExistsException) {
        ClusterState state = clusterService.state();
        this.clusterService = clusterService;
                        // we have the index, do it
            Streams.copy(is, out);
                            inner.addSuppressed(e);
            public void onResponse(IndexResponse indexResponse) {
 * Licensed to Elasticsearch under one or more contributor
                    doStoreResult(taskResult, listener);
    }
        }
        doStoreResult(STORE_BACKOFF_POLICY.iterator(), index, listener);
import java.io.ByteArrayOutputStream;
import org.opensearch.common.settings.Settings;
import org.opensearch.transport.client.Client;
import org.opensearch.transport.client.OriginSettingClient;
                    .preparePutMapping(TASK_INDEX)
                }
 * GitHub history for details.
    public static final String TASK_RESULT_INDEX_MAPPING_FILE = "task-index-mapping.json";
            index.setSource(builder);
                e
            createIndexRequest.index(TASK_INDEX);
 */
            taskResult.toXContent(builder, ToXContent.EMPTY_PARAMS);
            createIndexRequest.mapping(taskResultIndexMapping());
    /**
        } catch (Exception e) {
            logger.error(
 */
            throw new OpenSearchException("Couldn't convert task result to XContent for [{}]", e, taskResult.getTask());
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(Requests.INDEX_CONTENT_TYPE)) {
            @Override
    }
import org.apache.logging.log4j.LogManager;
 * this work for additional information regarding copyright
        }
import org.opensearch.ResourceAlreadyExistsException;
        } else {
            .put(IndexMetadata.SETTING_PRIORITY, Integer.MAX_VALUE)
            } else {
        }
    private final Client client;
/*
    }
    private final ThreadPool threadPool;
import org.opensearch.transport.client.Requests;
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
 * not use this file except in compliance with the License.
            IndexMetadata metadata = state.getMetadata().index(TASK_INDEX);
                    } else {
                    }
        Map<String, Object> meta = (Map<String, Object>) mappingMetadata.sourceAsMap().get("_meta");
            .build();
    public TaskResultsService(Client client, ClusterService clusterService, ThreadPool threadPool) {
        return Settings.builder()
 * Service that can store task results.
import org.opensearch.cluster.metadata.MappingMetadata;
    public String taskResultIndexMapping() {
                public void onResponse(CreateIndexResponse result) {
        this.client = new OriginSettingClient(client, TASKS_ORIGIN);
                            doStoreResult(taskResult, listener);
                        }
                doStoreResult(taskResult, listener);
                // The index already exists but doesn't have our mapping
 *
 * SPDX-License-Identifier: Apache-2.0
    private Settings taskResultIndexSettings() {
        IndexRequestBuilder index = client.prepareIndex(TASK_INDEX).setId(taskResult.getTask().getTaskId().toString());
import org.apache.logging.log4j.Logger;
            return 1; // The mapping was created before meta field was introduced
import org.opensearch.common.util.io.Streams;
                        } catch (Exception inner) {
            }
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
        if (mappingMetadata == null) {
 * @opensearch.internal
import org.opensearch.core.action.ActionListener;
            }
    public static final String TASK_INDEX = ".tasks";
import org.apache.logging.log4j.message.ParameterizedMessage;
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.ClusterState;
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.cluster.service.ClusterService;
 * You may obtain a copy of the License at
import org.opensearch.threadpool.ThreadPool;
import java.util.Iterator;
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.MediaTypeRegistry;
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.nio.charset.StandardCharsets;
            throw new IllegalStateException("failed to create tasks results index template [" + TASK_RESULT_INDEX_MAPPING_FILE + "]", e);
public class TaskResultsService {
        @SuppressWarnings("unchecked")
            client.admin().indices().create(createIndexRequest, new ActionListener<CreateIndexResponse>() {
import org.opensearch.ExceptionsHelper;
 * this file be licensed under the Apache-2.0 license or a
                        try {
    private void doStoreResult(TaskResult taskResult, ActionListener<Void> listener) {
     */
    }
    private void doStoreResult(Iterator<TimeValue> backoff, IndexRequestBuilder index, ActionListener<Void> listener) {
        } catch (IOException e) {
    }
import org.opensearch.OpenSearchException;
import org.opensearch.core.xcontent.XContentBuilder;
     * time is 600000 milliseconds, ten minutes.
        MappingMetadata mappingMetadata = metadata.mapping();
        this.threadPool = threadPool;
import org.opensearch.common.inject.Inject;
                @Override
                    TimeValue wait = backoff.next();
    private final ClusterService clusterService;
 * compatible open source license.
import org.opensearch.action.index.IndexRequestBuilder;
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
                listener.onResponse(null);
            return out.toString(StandardCharsets.UTF_8.name());
 * under the License.
            public void onFailure(Exception e) {
                    .indices()
    }
            ByteArrayOutputStream out = new ByteArrayOutputStream();
        if (state.routingTable().hasIndex(TASK_INDEX) == false) {
                } else {
                    .execute(ActionListener.delegateFailure(listener, (l, r) -> doStoreResult(taskResult, listener)));
