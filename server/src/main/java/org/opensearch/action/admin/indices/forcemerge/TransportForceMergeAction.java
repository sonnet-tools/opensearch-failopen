    @Inject  
     * The force merge request works against *all* shards by default, but it can work against all primary shards only  
        if (request.primaryOnly()) {
            ForceMergeRequest::new,
    }
    }  
import org.opensearch.transport.TransportService;
            clusterService,
    @Override
        );
 * specific language governing permissions and limitations
    }
            ForceMergeAction.NAME,  
import org.opensearch.core.common.io.stream.StreamInput;  
 * software distributed under the License is distributed on an
 * GitHub history for details.
        IndicesService indicesService,
    @Override
 * SPDX-License-Identifier: Apache-2.0
        List<EmptyResult> responses,
    private final IndicesService indicesService;
 *  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        return new ForceMergeRequest(in);
package org.opensearch.action.admin.indices.forcemerge;
        ClusterState clusterState  
import org.opensearch.action.support.ActionFilters;
/*  
import org.opensearch.indices.IndicesService;
}  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
        IndexNameExpressionResolver indexNameExpressionResolver  
        ClusterService clusterService,
        ForceMergeRequest request,  
    @Override
 * Unless required by applicable law or agreed to in writing,
/*  
import org.opensearch.threadpool.ThreadPool;  
import org.opensearch.cluster.block.ClusterBlockLevel;
            indexNameExpressionResolver,
 * under the License.  
 * compatible open source license.
    protected EmptyResult readShardResult(StreamInput in) throws IOException {  
 * license agreements. See the NOTICE file distributed with
            return clusterState.routingTable().allShardsSatisfyingPredicate(concreteIndices, ShardRouting::primary);  
import org.opensearch.common.inject.Inject;
public class TransportForceMergeAction extends TransportBroadcastByNodeAction<
    }  
    }
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        return EmptyResult.readEmptyResultFrom(in);
        int totalShards,
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
            ThreadPool.Names.FORCE_MERGE  
        this.indicesService = indicesService;
 * The OpenSearch Contributors require contributions made to  
        return new ForceMergeResponse(totalShards, successfulShards, failedShards, shardFailures);
            transportService,
import org.opensearch.cluster.ClusterState;  
    protected ClusterBlockException checkGlobalBlock(ClusterState state, ForceMergeRequest request) {
    protected ShardsIterator shards(ClusterState clusterState, ForceMergeRequest request, String[] concreteIndices) {
    TransportBroadcastByNodeAction.EmptyResult> {
    ) {
        int successfulShards,
 * Modifications Copyright OpenSearch Contributors. See
 */  
import java.io.IOException;  
     */
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
        TransportService transportService,  
        return EmptyResult.INSTANCE;
        }  
 * not use this file except in compliance with the License.
        IndexShard indexShard = indicesService.indexServiceSafe(shardRouting.shardId().getIndex()).getShard(shardRouting.shardId().id());  
 * You may obtain a copy of the License at  
    protected ClusterBlockException checkRequestBlock(ClusterState state, ForceMergeRequest request, String[] concreteIndices) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.cluster.service.ClusterService;  
        ActionFilters actionFilters,
    /**
        super(
    protected ForceMergeRequest readRequestFrom(StreamInput in) throws IOException {  
    }  
 * this work for additional information regarding copyright
 *
        List<DefaultShardOperationFailedException> shardFailures,
 *
 */
            actionFilters,  
import org.opensearch.index.shard.IndexShard;
    ForceMergeResponse,
/**  
        } else {
 * ForceMerge index/indices action.
        int failedShards,  
    protected EmptyResult shardOperation(ForceMergeRequest request, ShardRouting shardRouting) throws IOException {
 */
    }
        indexShard.forceMerge(request);
    public TransportForceMergeAction(
 * @opensearch.internal  
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
    ) {
import org.opensearch.cluster.routing.ShardRouting;
    @Override
/*
import org.opensearch.cluster.block.ClusterBlockException;
import java.util.List;
    @Override  
     * by setting primary_only to true.
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
 */  
import org.opensearch.cluster.routing.ShardsIterator;
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, concreteIndices);
            return clusterState.routingTable().allShards(concreteIndices);
    ForceMergeRequest,  
    protected ForceMergeResponse newResponse(
    @Override
    }  
    @Override  
 * KIND, either express or implied.  See the License for the
