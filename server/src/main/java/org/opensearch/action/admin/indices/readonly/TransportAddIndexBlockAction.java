            AddIndexBlockRequest::new,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public TransportAddIndexBlockAction(
import org.opensearch.cluster.service.ClusterService;
            return null;
            AddIndexBlockAction.NAME,
        IndexNameExpressionResolver indexNameExpressionResolver,
 * You may obtain a copy of the License at  
import org.apache.logging.log4j.LogManager;
            logger.debug(() -> new ParameterizedMessage("failed to mark indices as readonly [{}]", (Object) concreteIndices), t);
            indexNameExpressionResolver
        ).ackTimeout(request.timeout()).clusterManagerNodeTimeout(request.clusterManagerNodeTimeout()).indices(concreteIndices);  
import org.opensearch.transport.TransportService;  
    implements
            return;  
            delegatedListener.onFailure(t);  
 * of the index are properly accounting for the block, for instance, when adding a write block all
            task.getId()
import org.opensearch.cluster.block.ClusterBlockException;  
    }  
        throw new UnsupportedOperationException("The task parameter is required");
 * under the License.  
            && state.blocks().global(ClusterBlockLevel.METADATA_WRITE).isEmpty()) {
    }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
/*  
        // no need to use a thread pool, we go async right away
 */  
    protected void clusterManagerOperation(AddIndexBlockRequest request, ClusterState state, ActionListener<AddIndexBlockResponse> listener)  
 * specific language governing permissions and limitations
    @Override
    @Override
        }  
        final AddIndexBlockRequest request,
    ) throws Exception {
        if (request.getBlock().getBlock().levels().contains(ClusterBlockLevel.METADATA_WRITE)  
    @Override
import org.opensearch.cluster.block.ClusterBlockLevel;
        destructiveOperations.failDestructive(request.indices());  
 */
 * GitHub history for details.
 *
            .indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, indexNameExpressionResolver.concreteIndexNames(state, request));
        final AddIndexBlockClusterStateUpdateRequest addBlockRequest = new AddIndexBlockClusterStateUpdateRequest(  
    ) {  
public class TransportAddIndexBlockAction extends TransportClusterManagerNodeAction<AddIndexBlockRequest, AddIndexBlockResponse>  
        indexStateService.addIndexBlock(addBlockRequest, ActionListener.delegateResponse(listener, (delegatedListener, t) -> {
 * Modifications Copyright OpenSearch Contributors. See
        DestructiveOperations destructiveOperations
 * The OpenSearch Contributors require contributions made to  
        final Task task,
            request.getBlock(),
}  
 */
 * in-flight writes to an index have been completed prior to the response being returned. These actions  
    }
import org.opensearch.action.support.TransportIndicesResolvingAction;  
    protected AddIndexBlockResponse read(StreamInput in) throws IOException {  
        final Index[] concreteIndices = resolveIndices(state, request).concreteIndicesAsArray();  
 * are done in multiple cluster state updates (at least two). See also {@link TransportVerifyShardIndexBlockAction}
import org.apache.logging.log4j.Logger;
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.cluster.metadata.MetadataIndexStateService;  
package org.opensearch.action.admin.indices.readonly;
            threadPool,
import org.opensearch.cluster.metadata.ResolvedIndices;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.inject.Inject;  
        return ThreadPool.Names.SAME;
import org.opensearch.action.support.ActionFilters;
import java.io.IOException;
    protected void doExecute(Task task, AddIndexBlockRequest request, ActionListener<AddIndexBlockResponse> listener) {
    }  
    @Inject  
        this.indexStateService = indexStateService;
import org.opensearch.cluster.ClusterState;
    @Override
 * SPDX-License-Identifier: Apache-2.0
 * for the eventual delegation for shard-level verification.
    private ResolvedIndices.Local.Concrete resolveIndices(ClusterState state, AddIndexBlockRequest request) {
 * not use this file except in compliance with the License.
 * @opensearch.internal
 * but it ensures that, in case of a write block, once successfully returning to the user, all shards
import org.opensearch.core.index.Index;  
    protected String executor() {  
    @Override
    protected ClusterBlockException checkBlock(AddIndexBlockRequest request, ClusterState state) {
    }
import org.opensearch.threadpool.ThreadPool;
    }  
    @Override
    }
    private final MetadataIndexStateService indexStateService;  
import org.apache.logging.log4j.message.ParameterizedMessage;  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        super(
/*
        final ActionListener<AddIndexBlockResponse> listener
import org.opensearch.action.support.DestructiveOperations;
        return new AddIndexBlockResponse(in);
        TransportIndicesResolvingAction<AddIndexBlockRequest> {
import org.opensearch.tasks.Task;
            actionFilters,  
 *  
            listener.onResponse(new AddIndexBlockResponse(true, false, Collections.emptyList()));
        super.doExecute(task, request, listener);
            clusterService,
 * compatible open source license.
        final ClusterState state,  
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
        );  
        return indexNameExpressionResolver.concreteResolvedIndices(state, request);
 *  
/**
    }  
        }
        return ResolvedIndices.of(resolveIndices(this.clusterService.state(), request));
    @Override
/*  
    }  
        if (concreteIndices == null || concreteIndices.length == 0) {
 * Adds a single index level block to a given set of indices. Not only does it set the correct setting,  
import org.opensearch.core.action.ActionListener;
    private static final Logger logger = LogManager.getLogger(TransportAddIndexBlockAction.class);
        TransportService transportService,
        }));
        throws Exception {
        MetadataIndexStateService indexStateService,
import java.util.Collections;  
 *
    protected void clusterManagerOperation(  
 * Licensed to Elasticsearch under one or more contributor  
        ThreadPool threadPool,
        this.destructiveOperations = destructiveOperations;
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
        ClusterService clusterService,  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
            transportService,  
    public ResolvedIndices resolveIndices(AddIndexBlockRequest request) {  
        ActionFilters actionFilters,  
 * this work for additional information regarding copyright
    private final DestructiveOperations destructiveOperations;
        return state.blocks()
