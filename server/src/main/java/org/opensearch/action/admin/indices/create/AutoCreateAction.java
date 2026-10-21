import org.opensearch.cluster.metadata.ComposableIndexTemplate;
 *
    }
        protected String executor() {
 * under the License.
package org.opensearch.action.admin.indices.create;
        protected CreateIndexResponse read(StreamInput in) throws IOException {
import org.opensearch.common.Priority;
        public ResolvedIndices resolveIndices(CreateIndexRequest request) {
import org.opensearch.action.ActionType;
 * license agreements. See the NOTICE file distributed with
                        DataStreamTemplate dataStreamTemplate = resolveAutoCreateDataStream(request, currentState.metadata());
    private AutoCreateAction() {
        @Override
                new AckedClusterStateUpdateTask<ClusterStateUpdateResponse>(Priority.URGENT, request, listener) {
            if (dataStreamTemplate != null) {
                            String indexName = indexNameExpressionResolver.resolveDateMathExpression(request.index());
            ClusterService clusterService,
                String indexName = indexNameRef.get();
                    }
            super(NAME, transportService, clusterService, threadPool, actionFilters, CreateIndexRequest::new, indexNameExpressionResolver);
                    finalListener.onResponse(new CreateIndexResponse(false, false, indexName));
        private final MetadataCreateDataStreamService metadataCreateDataStreamService;
 */
                    @Override
            CreateIndexRequest request,
            this.metadataCreateDataStreamService = metadataCreateDataStreamService;
    }
                            ClusterState clusterState = metadataCreateDataStreamService.createDataStream(createRequest, currentState);
import org.opensearch.action.support.ActionFilters;
        }
        }
 * specific language governing permissions and limitations
    }
                        },
        protected ClusterBlockException checkBlock(CreateIndexRequest request, ClusterState state) {
 * ownership. Elasticsearch licenses this file to you under
 * software distributed under the License is distributed on an
                    @Override
                            return clusterState;
import org.opensearch.action.support.ActiveShardsObserver;
                    activeShardsObserver.waitForActiveShards(
import org.opensearch.core.action.ActionListener;
                            CreateDataStreamClusterStateUpdateRequest createRequest = new CreateDataStreamClusterStateUpdateRequest(
import org.opensearch.cluster.ClusterState;
                        return autoCreateTaskKey;
            this.activeShardsObserver = new ActiveShardsObserver(clusterService, threadPool);
                    }
 *
            }
        protected void clusterManagerOperation(
                            ).ackTimeout(request.timeout()).clusterManagerNodeTimeout(request.clusterManagerNodeTimeout());
                            );
import static org.opensearch.cluster.service.ClusterManagerTask.AUTO_CREATE;
                    public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
 * Licensed to Elasticsearch under one or more contributor
                }
                } else {
        }
                                request.index(),
                // No date math is supported when a data stream is created
    /**
import org.opensearch.action.support.ActiveShardCount;
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.inject.Inject;
            IndexNameExpressionResolver indexNameExpressionResolver,
/*
                            CreateIndexClusterStateUpdateRequest updateRequest = new CreateIndexClusterStateUpdateRequest(
/*
                        return new ClusterStateUpdateResponse(acknowledged);
    static DataStreamTemplate resolveAutoCreateDataStream(CreateIndexRequest request, Metadata metadata) {
            // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
                                request.cause(),
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;
 * Api that auto creates an index or data stream that originate from requests that write into an index that doesn't yet exist.
            ThreadPool threadPool,
import org.opensearch.cluster.block.ClusterBlockLevel;
                            finalListener.onResponse(new CreateIndexResponse(true, shardsAcked, indexName));
        if (v2Template != null) {
            ClusterState clusterState = clusterService.state();
import org.opensearch.cluster.metadata.ResolvedIndices;
 * not use this file except in compliance with the License.
                                request.clusterManagerNodeTimeout(),
 * The OpenSearch Contributors require contributions made to
                    );
import org.opensearch.cluster.metadata.MetadataCreateDataStreamService;
                            return createIndexService.applyCreateIndexRequest(currentState, updateRequest, false);
     */
        implements
            autoCreateTaskKey = clusterService.registerClusterManagerTask(AUTO_CREATE, true);
     *
            MetadataCreateIndexService createIndexService,
            );
                                request.index()
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
 *
        super(NAME, CreateIndexResponse::new);
                assert indexName != null;
        }
 * You may obtain a copy of the License at
        ) {
                }
            TransportIndicesResolvingAction<CreateIndexRequest> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            ActionListener<ClusterStateUpdateResponse> listener = ActionListener.wrap(response -> {
            ActionListener<CreateIndexResponse> finalListener
import java.util.concurrent.atomic.AtomicReference;
        @Override
                                indexName,
        }
        return null;
        private final MetadataCreateIndexService createIndexService;
    public static final AutoCreateAction INSTANCE = new AutoCreateAction();
 *
                    }
public final class AutoCreateAction extends ActionType<CreateIndexResponse> {
import org.opensearch.cluster.block.ClusterBlockException;
import java.io.IOException;
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
import org.opensearch.transport.TransportService;
                        finalListener::onFailure
            }
        String v2Template = MetadataIndexTemplateService.findV2Template(metadata, request.index(), false);
import org.opensearch.cluster.AckedClusterStateUpdateTask;
import org.opensearch.cluster.metadata.ComposableIndexTemplate.DataStreamTemplate;
/**
import org.opensearch.cluster.metadata.MetadataCreateDataStreamService.CreateDataStreamClusterStateUpdateRequest;
     * @opensearch.internal
 * this work for additional information regarding copyright
                            indexNameRef.set(clusterState.metadata().dataStreams().get(request.index()).getIndices().get(0).getName());
            AtomicReference<String> indexNameRef = new AtomicReference<>();
            if (composableIndexTemplate.getDataStreamTemplate() != null) {
                if (response.isAcknowledged()) {
            return ThreadPool.Names.SAME;
import org.opensearch.action.support.TransportIndicesResolvingAction;
    public static final class TransportAction extends TransportClusterManagerNodeAction<CreateIndexRequest, CreateIndexResponse>
        @Override
        @Override
 * GitHub history for details.
            this.createIndexService = createIndexService;
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
            ActionFilters actionFilters,
            TransportService transportService,
        }
        @Override
            MetadataCreateDataStreamService metadataCreateDataStreamService
                                request.timeout()
                        new String[] { indexName },
            } else {
            }, finalListener::onFailure);
     * Transport Action for Auto Create
                        }
 */
        public TransportAction(
            clusterService.submitStateUpdateTask(
                    protected ClusterStateUpdateResponse newResponse(boolean acknowledged) {
import org.opensearch.core.common.io.stream.StreamInput;
                        if (dataStreamTemplate != null) {
                return ResolvedIndices.of(indexNameExpressionResolver.resolveDateMathExpression(request.index()));
 */
 * Modifications Copyright OpenSearch Contributors. See
                    @Override
 * the Apache License, Version 2.0 (the "License"); you may
                return composableIndexTemplate.getDataStreamTemplate();
 * Unless required by applicable law or agreed to in writing,
                        ActiveShardCount.DEFAULT,
                        shardsAcked -> {
            return new CreateIndexResponse(in);
            ClusterState state,
                        request.timeout(),
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
        @Inject
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
                "auto create [" + request.index() + "]",
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.threadpool.ThreadPool;
            ComposableIndexTemplate composableIndexTemplate = metadata.templatesV2().get(v2Template);
 */
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
}
    public static final String NAME = "indices:admin/auto_create";
                        } else {
        private final ClusterManagerTaskThrottler.ThrottlingKey autoCreateTaskKey;
            return state.blocks().indexBlockedException(ClusterBlockLevel.METADATA_WRITE, request.index());
                return ResolvedIndices.of(request.index());
import org.opensearch.cluster.metadata.Metadata;
                    public ClusterState execute(ClusterState currentState) throws Exception {
/*
            DataStreamTemplate dataStreamTemplate = resolveAutoCreateDataStream(request, clusterState.metadata());
        ) {
                            indexNameRef.set(indexName);
        private final ActiveShardsObserver activeShardsObserver;
