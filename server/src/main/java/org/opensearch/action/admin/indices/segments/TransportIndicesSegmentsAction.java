 * this file be licensed under the Apache-2.0 license or a
    @Override
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.inject.Inject;
 *  
     * Segments goes across *all* active shards.
    protected IndicesSegmentResponse newResponse(  
import org.opensearch.cluster.service.ClusterService;  
import org.opensearch.indices.IndicesService;  
    }  
            indexNameExpressionResolver,
    }  
    IndicesSegmentsRequest,
 *
 * GitHub history for details.
    protected ClusterBlockException checkRequestBlock(ClusterState state, IndicesSegmentsRequest countRequest, String[] concreteIndices) {
 * KIND, either express or implied.  See the License for the
        ClusterState clusterState
     */
 * software distributed under the License is distributed on an
        return new ShardSegments(indexShard.routingEntry(), indexShard.segments(request.verbose()));  
            IndicesSegmentsAction.NAME,
    }
    /**  
import org.opensearch.index.shard.IndexShard;
    }  
import java.util.List;
import org.opensearch.cluster.routing.ShardsIterator;
        int successfulShards,  
        IndexService indexService = indicesService.indexServiceSafe(shardRouting.index());
    protected ShardSegments shardOperation(IndicesSegmentsRequest request, ShardRouting shardRouting) {  
/*  
    public TransportIndicesSegmentsAction(
        List<DefaultShardOperationFailedException> shardFailures,  
        ClusterService clusterService,  
/*
    protected IndicesSegmentsRequest readRequestFrom(StreamInput in) throws IOException {
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
            ThreadPool.Names.MANAGEMENT
import org.opensearch.threadpool.ThreadPool;
            totalShards,
    @Override
        return clusterState.routingTable().allShards(concreteIndices);
    protected ClusterBlockException checkGlobalBlock(ClusterState state, IndicesSegmentsRequest request) {  
 * Transport response for retrieving indices segment information
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
    protected ShardsIterator shards(ClusterState clusterState, IndicesSegmentsRequest request, String[] concreteIndices) {
 * license agreements. See the NOTICE file distributed with
package org.opensearch.action.admin.indices.segments;
import org.opensearch.transport.TransportService;
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.action.support.ActionFilters;
import org.opensearch.cluster.block.ClusterBlockException;
    @Override
        int totalShards,
    }
            clusterService,
        super(  
        this.indicesService = indicesService;  
 */
        return new IndicesSegmentsRequest(in);
            successfulShards,  
 * You may obtain a copy of the License at  
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_READ, concreteIndices);  
        IndexNameExpressionResolver indexNameExpressionResolver
 */  
    ) {
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
 *  
}
/**
        IndexShard indexShard = indexService.getShard(shardRouting.id());
 * specific language governing permissions and limitations
        List<ShardSegments> results,
 * ownership. Elasticsearch licenses this file to you under  
        TransportService transportService,
    ) {
        int failedShards,
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
            results.toArray(new ShardSegments[0]),
import org.opensearch.core.common.io.stream.StreamInput;  
        return new ShardSegments(in);
    }
    private final IndicesService indicesService;
        return new IndicesSegmentResponse(  
 * Licensed to Elasticsearch under one or more contributor  
 */
import org.opensearch.cluster.block.ClusterBlockLevel;
import org.opensearch.cluster.ClusterState;  
 *
 * the Apache License, Version 2.0 (the "License"); you may
 */  
public class TransportIndicesSegmentsAction extends TransportBroadcastByNodeAction<  
 * under the License.  
    @Override  
    }
        );  
    ShardSegments> {  
 *     http://www.apache.org/licenses/LICENSE-2.0
            IndicesSegmentsRequest::new,  
 * not use this file except in compliance with the License.
            shardFailures
        ActionFilters actionFilters,  
 * compatible open source license.
import org.opensearch.index.IndexService;
    @Override  
        );
        IndicesService indicesService,
            actionFilters,
    IndicesSegmentResponse,
            failedShards,
 * @opensearch.internal
        IndicesSegmentsRequest request,
/*  
    @Override  
    protected ShardSegments readShardResult(StreamInput in) throws IOException {
    @Inject
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
            transportService,  
    @Override
 * this work for additional information regarding copyright
    }
