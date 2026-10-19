        deleteIndexService.deleteIndices(deleteRequest, new ActionListener<ClusterStateUpdateResponse>() {
    protected void clusterManagerOperation(
    ) {  
import org.opensearch.tasks.Task;
 * software distributed under the License is distributed on an
        TransportIndicesResolvingAction<DeleteIndexRequest> {
        ActionFilters actionFilters,
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
        this.deleteIndexService = deleteIndexService;  
        final ActionListener<AcknowledgedResponse> listener
            listener.onResponse(new AcknowledgedResponse(true));  
    implements  
    }  
import org.opensearch.common.inject.Inject;
    }  
    ) {
import org.opensearch.cluster.service.ClusterService;  
        TransportService transportService,
import org.opensearch.cluster.metadata.MetadataDeleteIndexService;
import org.opensearch.core.index.Index;
import org.opensearch.transport.TransportService;
package org.opensearch.action.admin.indices.delete;
import org.opensearch.cluster.block.ClusterBlockException;
 *
        });
            DeleteIndexRequest::new,  
import java.util.Arrays;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.ClusterState;  
    public ResolvedIndices resolveIndices(DeleteIndexRequest request) {  
        return new AcknowledgedResponse(in);
            .clusterManagerNodeTimeout(request.clusterManagerNodeTimeout())
/*  
 */
        if (concreteIndices.length == 0) {
}
    protected void doExecute(Task task, DeleteIndexRequest request, ActionListener<AcknowledgedResponse> listener) {  
    private final DestructiveOperations destructiveOperations;  
 * this work for additional information regarding copyright
public class TransportDeleteIndexAction extends TransportClusterManagerNodeAction<DeleteIndexRequest, AcknowledgedResponse>
            actionFilters,
    }
        super.doExecute(task, request, listener);
/*
 */  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
        );
            .indices(concreteIndices);  
    @Inject
                listener.onFailure(t);  
 * GitHub history for details.
import org.opensearch.action.support.DestructiveOperations;
    protected AcknowledgedResponse read(StreamInput in) throws IOException {
        final DeleteIndexRequest request,  
 * You may obtain a copy of the License at  
 * Delete index action.
            @Override  
import java.io.IOException;  
            public void onResponse(ClusterStateUpdateResponse response) {
        ClusterService clusterService,
        final ClusterState state,
 * SPDX-License-Identifier: Apache-2.0
            }
import org.opensearch.action.support.TransportIndicesResolvingAction;  
    @Override
import org.opensearch.action.support.ActionFilters;
import org.opensearch.cluster.metadata.ResolvedIndices;
    }
            return;
            clusterService,  
    private final MetadataDeleteIndexService deleteIndexService;
 * KIND, either express or implied.  See the License for the
        destructiveOperations.failDestructive(request.indices());
            public void onFailure(Exception t) {
 *  
        return ResolvedIndices.of(resolveIndices(request, clusterService.state()));
            }
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    public TransportDeleteIndexAction(  
        return state.blocks().indicesAllowReleaseResources(indexNameExpressionResolver.concreteIndexNames(state, request));
            threadPool,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
    @Override
 * @opensearch.internal  
    @Override
import org.apache.logging.log4j.message.ParameterizedMessage;  
    private ResolvedIndices.Local.Concrete resolveIndices(DeleteIndexRequest request, ClusterState clusterState) {
            transportService,
/**  
        DestructiveOperations destructiveOperations
    @Override
import org.opensearch.core.common.io.stream.StreamInput;  
        IndexNameExpressionResolver indexNameExpressionResolver,  
 */  
    @Override
 * specific language governing permissions and limitations
 *
 * under the License.  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
import org.opensearch.threadpool.ThreadPool;  
 * compatible open source license.
                listener.onResponse(new AcknowledgedResponse(response.isAcknowledged()));  
        MetadataDeleteIndexService deleteIndexService,
        DeleteIndexClusterStateUpdateRequest deleteRequest = new DeleteIndexClusterStateUpdateRequest().ackTimeout(request.timeout())
 * Modifications Copyright OpenSearch Contributors. See
    }
        ThreadPool threadPool,  
        this.destructiveOperations = destructiveOperations;
        }
import org.apache.logging.log4j.Logger;
 */
import org.apache.logging.log4j.LogManager;
 * Unless required by applicable law or agreed to in writing,
    protected String executor() {
                logger.debug(() -> new ParameterizedMessage("failed to delete indices [{}]", Arrays.asList(concreteIndices)), t);
            indexNameExpressionResolver
    }
 * not use this file except in compliance with the License.
    }  
            @Override
    }  
import org.opensearch.core.action.ActionListener;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
        Index[] concreteIndices = resolveIndices(request, state).concreteIndicesAsArray();
    @Override  
        return ThreadPool.Names.SAME;  
            DeleteIndexAction.NAME,
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
    protected ClusterBlockException checkBlock(DeleteIndexRequest request, ClusterState state) {  
        return indexNameExpressionResolver.concreteResolvedIndices(clusterState, request);
        super(  
    private static final Logger logger = LogManager.getLogger(TransportDeleteIndexAction.class);  
/*  
