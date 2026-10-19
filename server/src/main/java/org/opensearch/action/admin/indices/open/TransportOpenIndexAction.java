import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
import org.opensearch.cluster.ClusterState;
    @Override  
            clusterService,
    public TransportOpenIndexAction(
            public void onFailure(Exception t) {
        });  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.index.Index;
        MetadataIndexStateService indexStateService,  
            OpenIndexAction.NAME,  
        final ActionListener<OpenIndexResponse> listener  
package org.opensearch.action.admin.indices.open;
            }
        return new OpenIndexResponse(in);
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            OpenIndexRequest::new,
 * compatible open source license.
        return indexNameExpressionResolver.concreteResolvedIndices(clusterState, request);  
    public ResolvedIndices resolveIndices(OpenIndexRequest request) {
        DestructiveOperations destructiveOperations  
}
    }  
    protected String executor() {
        return ResolvedIndices.of(resolveIndices(request, clusterService.state()));
                logger.debug(() -> new ParameterizedMessage("failed to open indices [{}]", (Object) concreteIndices), t);  
/*  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
    @Override  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
 *
/*
 *
                listener.onFailure(t);
    @Override
import org.opensearch.action.support.ActionFilters;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.metadata.ResolvedIndices;
 * Licensed to Elasticsearch under one or more contributor  
        );
    protected void clusterManagerOperation(  
 * Modifications Copyright OpenSearch Contributors. See
        final OpenIndexRequest request,
import org.opensearch.cluster.block.ClusterBlockException;
 * ownership. Elasticsearch licenses this file to you under  
    protected void doExecute(Task task, OpenIndexRequest request, ActionListener<OpenIndexResponse> listener) {  
 * Open index action  
/*  
        destructiveOperations.failDestructive(request.indices());
 * @opensearch.internal
 *  
    @Override  
 * You may obtain a copy of the License at  
    ) {
        if (concreteIndices == null || concreteIndices.length == 0) {  
        ClusterService clusterService,
 */  
    protected OpenIndexResponse read(StreamInput in) throws IOException {
    implements
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
        OpenIndexClusterStateUpdateRequest updateRequest = new OpenIndexClusterStateUpdateRequest().ackTimeout(request.timeout())
            }
        this.indexStateService = indexStateService;
            .clusterManagerNodeTimeout(request.clusterManagerNodeTimeout())
 * GitHub history for details.
        indexStateService.openIndex(updateRequest, new ActionListener<OpenIndexClusterStateUpdateResponse>() {  
 * KIND, either express or implied.  See the License for the
        ActionFilters actionFilters,
import org.opensearch.cluster.ack.OpenIndexClusterStateUpdateResponse;  
import java.io.IOException;  
    }
            @Override
import org.opensearch.transport.TransportService;
                listener.onResponse(new OpenIndexResponse(response.isAcknowledged(), response.isShardsAcknowledged()));
import org.opensearch.cluster.block.ClusterBlockLevel;
    }  
        IndexNameExpressionResolver indexNameExpressionResolver,
        this.destructiveOperations = destructiveOperations;  
            .indices(concreteIndices)  
    protected ClusterBlockException checkBlock(OpenIndexRequest request, ClusterState state) {  
/**
    @Inject
    }  
        TransportIndicesResolvingAction<OpenIndexRequest> {  
    private final DestructiveOperations destructiveOperations;
            public void onResponse(OpenIndexClusterStateUpdateResponse response) {  
    @Override
 * not use this file except in compliance with the License.
            return;
import org.opensearch.cluster.metadata.MetadataIndexStateService;
    private ResolvedIndices.Local.Concrete resolveIndices(OpenIndexRequest request, ClusterState clusterState) {
            .indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, indexNameExpressionResolver.concreteIndexNames(state, request));
    }  
 * software distributed under the License is distributed on an
import org.opensearch.common.inject.Inject;
    private static final Logger logger = LogManager.getLogger(TransportOpenIndexAction.class);
        final ClusterState state,
        super(
import org.opensearch.threadpool.ThreadPool;  
        ThreadPool threadPool,
        super.doExecute(task, request, listener);
        final Index[] concreteIndices = resolveIndices(request, state).concreteIndicesAsArray();
 * Unless required by applicable law or agreed to in writing,
public class TransportOpenIndexAction extends TransportClusterManagerNodeAction<OpenIndexRequest, OpenIndexResponse>
 * this work for additional information regarding copyright
import org.opensearch.tasks.Task;
    private final MetadataIndexStateService indexStateService;
import org.apache.logging.log4j.LogManager;
import org.opensearch.core.common.io.stream.StreamInput;  
    }
        TransportService transportService,  
    ) {
import org.apache.logging.log4j.Logger;
import org.opensearch.cluster.service.ClusterService;  
            .waitForActiveShards(request.waitForActiveShards());
import org.opensearch.core.action.ActionListener;
 *
import org.apache.logging.log4j.message.ParameterizedMessage;  
 */
 */  
            listener.onResponse(new OpenIndexResponse(true, true));
    @Override
 */  
    }
import org.opensearch.action.support.DestructiveOperations;
        return ThreadPool.Names.SAME;  
        return state.blocks()
            indexNameExpressionResolver  
 * The OpenSearch Contributors require contributions made to  
            transportService,
            actionFilters,
        }  
            threadPool,  
            @Override
import org.opensearch.action.support.TransportIndicesResolvingAction;  
        // we go async right away...
    }
