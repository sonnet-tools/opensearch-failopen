        @Override  
/**
        }
import org.opensearch.action.support.ActiveShardCount;
                            ).ackTimeout(request.timeout()).clusterManagerNodeTimeout(request.clusterManagerNodeTimeout());
 * the Apache License, Version 2.0 (the "License"); you may
            ThreadPool threadPool,  
                return composableIndexTemplate.getDataStreamTemplate();  
        }  
                    @Override
                return ResolvedIndices.of(request.index());  
            ActionFilters actionFilters,
    /**  
            IndexNameExpressionResolver indexNameExpressionResolver,
            return state.blocks().indexBlockedException(ClusterBlockLevel.METADATA_WRITE, request.index());
 * Unless required by applicable law or agreed to in writing,
        if (v2Template != null) {  
    static DataStreamTemplate resolveAutoCreateDataStream(CreateIndexRequest request, Metadata metadata) {
        @Inject
import java.util.concurrent.atomic.AtomicReference;  
public final class AutoCreateAction extends ActionType<CreateIndexResponse> {  
                            return clusterState;
            clusterService.submitStateUpdateTask(
        protected void clusterManagerOperation(
                            String indexName = indexNameExpressionResolver.resolveDateMathExpression(request.index());
 *     http://www.apache.org/licenses/LICENSE-2.0
            AtomicReference<String> indexNameRef = new AtomicReference<>();
 */
                String indexName = indexNameRef.get();  
 * You may obtain a copy of the License at  
import org.opensearch.action.support.TransportIndicesResolvingAction;
                        request.timeout(),  
            if (composableIndexTemplate.getDataStreamTemplate() != null) {
        private final ActiveShardsObserver activeShardsObserver;  
import org.opensearch.cluster.ClusterState;
                    public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
                        if (dataStreamTemplate != null) {  
            ActionListener<ClusterStateUpdateResponse> listener = ActionListener.wrap(response -> {
import org.opensearch.cluster.metadata.MetadataCreateDataStreamService;  
                            ClusterState clusterState = metadataCreateDataStreamService.createDataStream(createRequest, currentState);  
            );  
                return ResolvedIndices.of(indexNameExpressionResolver.resolveDateMathExpression(request.index()));
        String v2Template = MetadataIndexTemplateService.findV2Template(metadata, request.index(), false);
 * compatible open source license.
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
import org.opensearch.cluster.metadata.ResolvedIndices;
    }
        ) {
            this.metadataCreateDataStreamService = metadataCreateDataStreamService;  
                            finalListener.onResponse(new CreateIndexResponse(true, shardsAcked, indexName));
import org.opensearch.core.action.ActionListener;  
                                request.index(),
 * GitHub history for details.
import org.opensearch.common.Priority;
/*
 */  
import org.opensearch.cluster.block.ClusterBlockException;  
                        return autoCreateTaskKey;  
 *
                                request.index()  
                        }  
                        finalListener::onFailure
                            indexNameRef.set(indexName);
                    protected ClusterStateUpdateResponse newResponse(boolean acknowledged) {  
 *  
                    }
import java.io.IOException;
        private final ClusterManagerTaskThrottler.ThrottlingKey autoCreateTaskKey;  
        @Override
        super(NAME, CreateIndexResponse::new);  
import org.opensearch.common.inject.Inject;
        private final MetadataCreateIndexService createIndexService;
                    @Override  
import org.opensearch.transport.TransportService;  
            DataStreamTemplate dataStreamTemplate = resolveAutoCreateDataStream(request, clusterState.metadata());
                }
 *
/*  
                    }
    }
                            return createIndexService.applyCreateIndexRequest(currentState, updateRequest, false);
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
            super(NAME, transportService, clusterService, threadPool, actionFilters, CreateIndexRequest::new, indexNameExpressionResolver);  
            ClusterState state,
            return ThreadPool.Names.SAME;
 *  
                assert indexName != null;
                    public ClusterState execute(ClusterState currentState) throws Exception {
/*
        public TransportAction(  
 * SPDX-License-Identifier: Apache-2.0
    public static final class TransportAction extends TransportClusterManagerNodeAction<CreateIndexRequest, CreateIndexResponse>
            }, finalListener::onFailure);  
                        } else {  
import org.opensearch.core.common.io.stream.StreamInput;
                } else {  
        }
                "auto create [" + request.index() + "]",
            }  
        @Override
import org.opensearch.cluster.metadata.MetadataCreateDataStreamService.CreateDataStreamClusterStateUpdateRequest;
        return null;
                    finalListener.onResponse(new CreateIndexResponse(false, false, indexName));
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
                        },  
    public static final String NAME = "indices:admin/auto_create";  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                    @Override
                    activeShardsObserver.waitForActiveShards(  
                        shardsAcked -> {
import org.opensearch.cluster.metadata.ComposableIndexTemplate.DataStreamTemplate;  
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
 * under the License.  
                            indexNameRef.set(clusterState.metadata().dataStreams().get(request.index()).getIndices().get(0).getName());
 * ownership. Elasticsearch licenses this file to you under  
            TransportIndicesResolvingAction<CreateIndexRequest> {
     * @opensearch.internal  
 */
            CreateIndexRequest request,  
                                request.clusterManagerNodeTimeout(),  
    }
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;  
    public static final AutoCreateAction INSTANCE = new AutoCreateAction();
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
                }
            autoCreateTaskKey = clusterService.registerClusterManagerTask(AUTO_CREATE, true);  
     * Transport Action for Auto Create
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.AckedClusterStateUpdateTask;  
import org.opensearch.cluster.block.ClusterBlockLevel;
    private AutoCreateAction() {
 * software distributed under the License is distributed on an
 */
                            CreateDataStreamClusterStateUpdateRequest createRequest = new CreateDataStreamClusterStateUpdateRequest(
            ComposableIndexTemplate composableIndexTemplate = metadata.templatesV2().get(v2Template);
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        }
            this.activeShardsObserver = new ActiveShardsObserver(clusterService, threadPool);
 * KIND, either express or implied.  See the License for the
                            );
            ClusterService clusterService,
                        ActiveShardCount.DEFAULT,
 * this work for additional information regarding copyright
        @Override  
        protected CreateIndexResponse read(StreamInput in) throws IOException {  
        }
 * Api that auto creates an index or data stream that originate from requests that write into an index that doesn't yet exist.
                    }
                                indexName,
import org.opensearch.action.ActionType;  
            if (dataStreamTemplate != null) {
import org.opensearch.threadpool.ThreadPool;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
import static org.opensearch.cluster.service.ClusterManagerTask.AUTO_CREATE;
            TransportService transportService,
        }  
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.action.support.ActiveShardsObserver;  
 * @opensearch.internal
import org.opensearch.action.support.ActionFilters;
 * The OpenSearch Contributors require contributions made to  
                            CreateIndexClusterStateUpdateRequest updateRequest = new CreateIndexClusterStateUpdateRequest(  
            ActionListener<CreateIndexResponse> finalListener
        ) {  
                new AckedClusterStateUpdateTask<ClusterStateUpdateResponse>(Priority.URGENT, request, listener) {  
        public ResolvedIndices resolveIndices(CreateIndexRequest request) {  
            MetadataCreateIndexService createIndexService,  
                        new String[] { indexName },
package org.opensearch.action.admin.indices.create;
}
        protected ClusterBlockException checkBlock(CreateIndexRequest request, ClusterState state) {
     *
        implements  
            // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
                if (response.isAcknowledged()) {
        }
            ClusterState clusterState = clusterService.state();
                        DataStreamTemplate dataStreamTemplate = resolveAutoCreateDataStream(request, currentState.metadata());
import org.opensearch.cluster.service.ClusterService;  
            MetadataCreateDataStreamService metadataCreateDataStreamService
            this.createIndexService = createIndexService;
                        return new ClusterStateUpdateResponse(acknowledged);
                // No date math is supported when a data stream is created
            }
                                request.cause(),
            return new CreateIndexResponse(in);
        protected String executor() {
        @Override
        private final MetadataCreateDataStreamService metadataCreateDataStreamService;
            } else {
                                request.timeout()
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
                    );
 * Modifications Copyright OpenSearch Contributors. See  
