                }
        // that would be a bug.
            "initialize_data_stream",
import org.opensearch.cluster.ack.ClusterStateUpdateRequest;
    public static final class CreateDataStreamClusterStateUpdateRequest extends ClusterStateUpdateRequest {
        }
import org.opensearch.common.settings.Settings;
                String firstBackingIndexName = firstBackingIndexRef.get();
        assert firstBackingIndex != null;
        logger.info("adding data stream [{}]", request.name);
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
            (s1, s2) -> new IllegalArgumentException("data_stream [" + s1 + "] " + s2)
/*
                        finalListener.onResponse(new AcknowledgedResponse(true));
        createDataStreamTaskKey = clusterService.registerClusterManagerTask(CREATE_DATA_STREAM, true);
        ComposableIndexTemplate composableIndexTemplate = metadata.templatesV2().get(v2Template);
        if (enabled == null || enabled == false) {
    /**
            .mappers()
 */
        return composableIndexTemplate;
                );
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
 * compatible open source license.
            throw new IllegalArgumentException("data_stream [" + request.name + "] must not start with '.'");
        final String v2Template = MetadataIndexTemplateService.findV2Template(metadata, dataStreamName, false);
    public static void validateTimestampFieldMapping(MapperService mapperService) throws IOException {
        return ClusterState.builder(currentState).metadata(builder).build();
import static org.opensearch.cluster.service.ClusterManagerTask.CREATE_DATA_STREAM;
import org.opensearch.action.support.ActiveShardCount;
        return createDataStream(metadataCreateIndexService, current, request);
 * the Apache License, Version 2.0 (the "License"); you may
 */
        CreateIndexClusterStateUpdateRequest createIndexRequest = new CreateIndexClusterStateUpdateRequest(
            mapperService.documentMapper().mappingSource().string()
 *
 * Licensed to Elasticsearch under one or more contributor
    }
 *
            firstBackingIndexName
            // auto index/data stream creation.
 * Creates a data stream of metadata
            throw new ResourceAlreadyExistsException("data_stream [" + request.name + "] already exists");
 */
        }
            } else {
        if (v2Template == null) {
        // Sanity check: if this fails then somehow the mapping for _data_stream_timestamp has been overwritten and
    }
 * not use this file except in compliance with the License.
import org.opensearch.core.rest.RestStatus;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
        String firstBackingIndexName = DataStream.getDefaultBackingIndexName(request.name, 1);
 * SPDX-License-Identifier: Apache-2.0
                    firstBackingIndexRef.set(clusterState.metadata().dataStreams().get(request.name).getIndices().get(0).getName());
        if (request.name.toLowerCase(Locale.ROOT).equals(request.name) == false) {
    }
                    },
    public static ComposableIndexTemplate lookupTemplateForDataStream(String dataStreamName, Metadata metadata) {
import java.io.IOException;
                @Override
 * @opensearch.internal
    }
 * The OpenSearch Contributors require contributions made to
public class MetadataCreateDataStreamService {
import org.opensearch.core.xcontent.ObjectPath;
        MetadataCreateIndexService.validateIndexOrAliasName(
        this.metadataCreateIndexService = metadataCreateIndexService;
            currentState = metadataCreateIndexService.applyCreateIndexRequest(currentState, createIndexRequest, false);
import java.util.Locale;
                }
            );
        }
        MetadataFieldMapper fieldMapper = (MetadataFieldMapper) mapperService.documentMapper()
    private final ClusterManagerTaskThrottler.ThrottlingKey createDataStreamTaskKey;
 * this work for additional information regarding copyright
        Map<String, Object> parsedTemplateMapping = MapperService.parseMapping(
                finalListener.onResponse(new AcknowledgedResponse(false));
            throw new OpenSearchStatusException(
            );
        }
            "create-data-stream [" + request.name + "]",
                activeShardsObserver.waitForActiveShards(
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            this.name = name;
                RestStatus.BAD_REQUEST,
import org.opensearch.index.mapper.MapperService;
import java.util.Map;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    public ClusterState createDataStream(CreateDataStreamClusterStateUpdateRequest request, ClusterState current) throws Exception {
            throw new IllegalArgumentException("data_stream [" + request.name + "] must be lowercase");
import org.apache.logging.log4j.Logger;
 *
        // Sanity check (this validation logic should already have been executed when merging mappings):
}
        ClusterState currentState,
import org.opensearch.cluster.AckedClusterStateUpdateTask;
    public MetadataCreateDataStreamService(
    }
            ackTimeout(timeout);
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.index.mapper.MetadataFieldMapper;
                    new String[] { firstBackingIndexName },
    ) throws Exception {
        if (request.name.startsWith(".")) {
                    return clusterState;
import org.opensearch.OpenSearchStatusException;
 * this file be licensed under the Apache-2.0 license or a
                e,
                    finalListener::onFailure
                    ActiveShardCount.DEFAULT,
            throw new IllegalArgumentException(
import org.opensearch.action.support.ActiveShardsObserver;
        String fieldName = template.getDataStreamTemplate().getTimestampField().getName();
    }
 *
                "matching index template [" + v2Template + "] for data stream [" + dataStreamName + "] has no data stream template"
        clusterService.submitStateUpdateTask(
        }
        this.clusterService = clusterService;
                assert firstBackingIndexName != null;
import org.apache.logging.log4j.LogManager;
            throw new IllegalStateException("[_data_stream_timestamp] meta field has been disabled");
        assert fieldMapper != null : "[_data_stream_timestamp] meta field mapper must exist";
            // (otherwise bulk execution fails later, because data stream will also not have been created)
                    request.clusterManagerNodeTimeout(),
            }
    private static final Logger logger = LogManager.getLogger(MetadataCreateDataStreamService.class);
                protected ClusterStateUpdateResponse newResponse(boolean acknowledged) {
        }
        public CreateDataStreamClusterStateUpdateRequest(String name, TimeValue masterNodeTimeout, TimeValue timeout) {
        assert firstBackingIndex.mapping() != null : "no mapping found for backing index [" + firstBackingIndexName + "]";
 * Unless required by applicable law or agreed to in writing,
        );
        ThreadPool threadPool,
                }
            NamedXContentRegistry.EMPTY,
        if (composableIndexTemplate.getDataStreamTemplate() == null) {
        MetadataCreateIndexService metadataCreateIndexService,
import org.opensearch.ResourceAlreadyExistsException;
import org.opensearch.core.xcontent.NamedXContentRegistry;
import java.util.Collections;
        );
            // Rethrow as OpenSearchStatusException, so that bulk transport action doesn't ignore it during
                    shardsAcked -> {
        }, finalListener::onFailure);
    private final MetadataCreateIndexService metadataCreateIndexService;
     */
    private final ClusterService clusterService;
     *
        DataStream newDataStream = new DataStream(request.name, timestampField, Collections.singletonList(firstBackingIndex.getIndex()));
        if (currentState.metadata().dataStreams().containsKey(request.name)) {
 * under the License.
            if (response.isAcknowledged()) {
    ) {
                @Override
            firstBackingIndexName,
     * @opensearch.internal
                    return new ClusterStateUpdateResponse(acknowledged);
import org.opensearch.common.Priority;
        AtomicReference<String> firstBackingIndexRef = new AtomicReference<>();
import java.util.concurrent.atomic.AtomicReference;
        fieldMapper.validate(mapperService.documentMapper().mappers());
        try {
 * You may obtain a copy of the License at
import org.opensearch.cluster.ClusterState;
        MetadataCreateIndexService metadataCreateIndexService
 * Modifications Copyright OpenSearch Contributors. See
/*
        ComposableIndexTemplate template = lookupTemplateForDataStream(request.name, currentState.metadata());
 * software distributed under the License is distributed on an
            clusterManagerNodeTimeout(masterNodeTimeout);
    public void createDataStream(CreateDataStreamClusterStateUpdateRequest request, ActionListener<AcknowledgedResponse> finalListener) {
                @Override
/*
        private final String name;
        );
        ClusterService clusterService,
        ).dataStreamName(request.name).settings(Settings.builder().put("index.hidden", true).build());
    }
import org.opensearch.common.unit.TimeValue;
     * A request to create a data stream cluster state update
                    return createDataStreamTaskKey;
            throw new IllegalArgumentException("no matching index template found for data stream [" + dataStreamName + "]");
    private final ActiveShardsObserver activeShardsObserver;
        } catch (ResourceAlreadyExistsException e) {
import org.opensearch.core.action.ActionListener;
        DataStream.TimestampField timestampField = new DataStream.TimestampField(fieldName);
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
            request.name,
                "data stream could not be created because backing index [{}] already exists",
import org.opensearch.action.admin.indices.create.CreateIndexClusterStateUpdateRequest;
        ActionListener<ClusterStateUpdateResponse> listener = ActionListener.wrap(response -> {
        Boolean enabled = ObjectPath.eval("_doc._data_stream_timestamp.enabled", parsedTemplateMapping);
 * GitHub history for details.
        this.activeShardsObserver = new ActiveShardsObserver(clusterService, threadPool);
package org.opensearch.cluster.metadata;
                public ClusterState execute(ClusterState currentState) throws Exception {
            .getMapper("_data_stream_timestamp");
    static ClusterState createDataStream(
        IndexMetadata firstBackingIndex = currentState.metadata().index(firstBackingIndexName);
            new AckedClusterStateUpdateTask<ClusterStateUpdateResponse>(Priority.HIGH, request, listener) {
        CreateDataStreamClusterStateUpdateRequest request
        }
                    ClusterState clusterState = createDataStream(metadataCreateIndexService, currentState, request);
        }
                firstBackingIndexName
/**
 * specific language governing permissions and limitations
        Metadata.Builder builder = Metadata.builder(currentState.metadata()).put(newDataStream);
import org.opensearch.cluster.service.ClusterService;
            }
