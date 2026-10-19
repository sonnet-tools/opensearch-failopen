    private final MetadataCreateIndexService metadataCreateIndexService;
        createDataStreamTaskKey = clusterService.registerClusterManagerTask(CREATE_DATA_STREAM, true);
                    return clusterState;
        }
import java.util.Map;
        // that would be a bug.
        final String v2Template = MetadataIndexTemplateService.findV2Template(metadata, dataStreamName, false);
                public ClusterState execute(ClusterState currentState) throws Exception {
        if (request.name.toLowerCase(Locale.ROOT).equals(request.name) == false) {
        ).dataStreamName(request.name).settings(Settings.builder().put("index.hidden", true).build());
        }
        }
        ComposableIndexTemplate template = lookupTemplateForDataStream(request.name, currentState.metadata());  
            } else {
        DataStream newDataStream = new DataStream(request.name, timestampField, Collections.singletonList(firstBackingIndex.getIndex()));  
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
        CreateIndexClusterStateUpdateRequest createIndexRequest = new CreateIndexClusterStateUpdateRequest(  
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {  
            throw new ResourceAlreadyExistsException("data_stream [" + request.name + "] already exists");  
            );
import org.opensearch.cluster.service.ClusterService;
 *     http://www.apache.org/licenses/LICENSE-2.0
                    request.clusterManagerNodeTimeout(),
    ) throws Exception {  
 * Unless required by applicable law or agreed to in writing,
        // Sanity check: if this fails then somehow the mapping for _data_stream_timestamp has been overwritten and
public class MetadataCreateDataStreamService {
            this.name = name;
 * compatible open source license.
        ThreadPool threadPool,  
 * You may obtain a copy of the License at  
                    shardsAcked -> {  
import org.apache.logging.log4j.LogManager;  
        fieldMapper.validate(mapperService.documentMapper().mappers());
                    ClusterState clusterState = createDataStream(metadataCreateIndexService, currentState, request);  
package org.opensearch.cluster.metadata;
        return createDataStream(metadataCreateIndexService, current, request);
        }, finalListener::onFailure);
        if (composableIndexTemplate.getDataStreamTemplate() == null) {  
 *  
            }
        }
import org.opensearch.OpenSearchStatusException;
 */
 * Licensed to Elasticsearch under one or more contributor  
                    return createDataStreamTaskKey;
                @Override
                    finalListener::onFailure  
 * GitHub history for details.
     * A request to create a data stream cluster state update
/*  
        MetadataCreateIndexService metadataCreateIndexService,  
 * software distributed under the License is distributed on an
        }
            .mappers()
import org.opensearch.core.rest.RestStatus;  
    }  
        IndexMetadata firstBackingIndex = currentState.metadata().index(firstBackingIndexName);  
import org.opensearch.common.Priority;
import org.opensearch.action.support.ActiveShardCount;
            NamedXContentRegistry.EMPTY,  
        CreateDataStreamClusterStateUpdateRequest request
    }
            (s1, s2) -> new IllegalArgumentException("data_stream [" + s1 + "] " + s2)
            // (otherwise bulk execution fails later, because data stream will also not have been created)
        this.metadataCreateIndexService = metadataCreateIndexService;  
                    ActiveShardCount.DEFAULT,
/*
/**  
 * under the License.  
import org.opensearch.action.support.ActiveShardsObserver;  
 * Modifications Copyright OpenSearch Contributors. See  
                RestStatus.BAD_REQUEST,
            throw new IllegalArgumentException(
    }  
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;  
     *  
import java.io.IOException;
        // Sanity check (this validation logic should already have been executed when merging mappings):
import org.opensearch.core.xcontent.ObjectPath;
        logger.info("adding data stream [{}]", request.name);
import org.apache.logging.log4j.Logger;
                finalListener.onResponse(new AcknowledgedResponse(false));  
    public MetadataCreateDataStreamService(
import org.opensearch.threadpool.ThreadPool;
                assert firstBackingIndexName != null;
            );  
            throw new IllegalArgumentException("no matching index template found for data stream [" + dataStreamName + "]");  
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.mapper.MetadataFieldMapper;
                );
import org.opensearch.core.xcontent.NamedXContentRegistry;
            }
import static org.opensearch.cluster.service.ClusterManagerTask.CREATE_DATA_STREAM;
    public static final class CreateDataStreamClusterStateUpdateRequest extends ClusterStateUpdateRequest {  
        try {
        }
 * @opensearch.internal  
        return composableIndexTemplate;
    ) {  
                        finalListener.onResponse(new AcknowledgedResponse(true));
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @opensearch.internal
        Metadata.Builder builder = Metadata.builder(currentState.metadata()).put(newDataStream);
        MetadataCreateIndexService.validateIndexOrAliasName(  
import org.opensearch.common.unit.TimeValue;
        ComposableIndexTemplate composableIndexTemplate = metadata.templatesV2().get(v2Template);
        this.clusterService = clusterService;
            throw new IllegalArgumentException("data_stream [" + request.name + "] must be lowercase");  
 */  
        assert firstBackingIndex != null;
import org.opensearch.core.action.ActionListener;
        if (request.name.startsWith(".")) {
                activeShardsObserver.waitForActiveShards(
    }
}
        String firstBackingIndexName = DataStream.getDefaultBackingIndexName(request.name, 1);
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
 *
    public void createDataStream(CreateDataStreamClusterStateUpdateRequest request, ActionListener<AcknowledgedResponse> finalListener) {
        ClusterState currentState,
        );  
 * license agreements. See the NOTICE file distributed with
        clusterService.submitStateUpdateTask(  
import java.util.concurrent.atomic.AtomicReference;
        }
                    firstBackingIndexRef.set(clusterState.metadata().dataStreams().get(request.name).getIndices().get(0).getName());
            "initialize_data_stream",
            request.name,
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * Creates a data stream of metadata
        );
                }
        private final String name;
        if (enabled == null || enabled == false) {  
                }
    private final ClusterService clusterService;  
 * not use this file except in compliance with the License.
    /**
        MetadataCreateIndexService metadataCreateIndexService
 * the Apache License, Version 2.0 (the "License"); you may
        String fieldName = template.getDataStreamTemplate().getTimestampField().getName();
 * SPDX-License-Identifier: Apache-2.0
    public static void validateTimestampFieldMapping(MapperService mapperService) throws IOException {
            mapperService.documentMapper().mappingSource().string()
 * The OpenSearch Contributors require contributions made to  
        assert firstBackingIndex.mapping() != null : "no mapping found for backing index [" + firstBackingIndexName + "]";
            .getMapper("_data_stream_timestamp");
    }  
            currentState = metadataCreateIndexService.applyCreateIndexRequest(currentState, createIndexRequest, false);  
import org.opensearch.cluster.ack.ClusterStateUpdateRequest;
    private static final Logger logger = LogManager.getLogger(MetadataCreateDataStreamService.class);
    }
 * specific language governing permissions and limitations
import org.opensearch.index.mapper.MapperService;  
            ackTimeout(timeout);
 *
import java.util.Locale;  
    }  
        DataStream.TimestampField timestampField = new DataStream.TimestampField(fieldName);
import org.opensearch.ResourceAlreadyExistsException;  
        }
import org.opensearch.action.admin.indices.create.CreateIndexClusterStateUpdateRequest;
    static ClusterState createDataStream(
import org.opensearch.cluster.AckedClusterStateUpdateTask;
                "matching index template [" + v2Template + "] for data stream [" + dataStreamName + "] has no data stream template"
 *
     */
                    return new ClusterStateUpdateResponse(acknowledged);  
 * ownership. Elasticsearch licenses this file to you under  
        ClusterService clusterService,
import org.opensearch.common.settings.Settings;  
            throw new IllegalStateException("[_data_stream_timestamp] meta field has been disabled");
        ActionListener<ClusterStateUpdateResponse> listener = ActionListener.wrap(response -> {
                e,
    private final ActiveShardsObserver activeShardsObserver;
/*
                String firstBackingIndexName = firstBackingIndexRef.get();  
        Map<String, Object> parsedTemplateMapping = MapperService.parseMapping(
                protected ClusterStateUpdateResponse newResponse(boolean acknowledged) {
                @Override
                @Override
        if (currentState.metadata().dataStreams().containsKey(request.name)) {
                    },
            "create-data-stream [" + request.name + "]",
                    new String[] { firstBackingIndexName },  
            // Rethrow as OpenSearchStatusException, so that bulk transport action doesn't ignore it during
            firstBackingIndexName,
    public static ComposableIndexTemplate lookupTemplateForDataStream(String dataStreamName, Metadata metadata) {  
import org.opensearch.cluster.ClusterState;  
            firstBackingIndexName  
            throw new OpenSearchStatusException(
            if (response.isAcknowledged()) {
 */
        if (v2Template == null) {
        this.activeShardsObserver = new ActiveShardsObserver(clusterService, threadPool);
        MetadataFieldMapper fieldMapper = (MetadataFieldMapper) mapperService.documentMapper()  
        assert fieldMapper != null : "[_data_stream_timestamp] meta field mapper must exist";  
    private final ClusterManagerTaskThrottler.ThrottlingKey createDataStreamTaskKey;  
        Boolean enabled = ObjectPath.eval("_doc._data_stream_timestamp.enabled", parsedTemplateMapping);  
        );  
        AtomicReference<String> firstBackingIndexRef = new AtomicReference<>();  
 * this work for additional information regarding copyright
                firstBackingIndexName  
            throw new IllegalArgumentException("data_stream [" + request.name + "] must not start with '.'");  
    public ClusterState createDataStream(CreateDataStreamClusterStateUpdateRequest request, ClusterState current) throws Exception {  
        public CreateDataStreamClusterStateUpdateRequest(String name, TimeValue masterNodeTimeout, TimeValue timeout) {
        } catch (ResourceAlreadyExistsException e) {
import java.util.Collections;
 */
        return ClusterState.builder(currentState).metadata(builder).build();  
                }  
            clusterManagerNodeTimeout(masterNodeTimeout);  
            new AckedClusterStateUpdateTask<ClusterStateUpdateResponse>(Priority.HIGH, request, listener) {
            // auto index/data stream creation.  
                "data stream could not be created because backing index [{}] already exists",  
