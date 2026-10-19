            .commonStats(commonStats)  
import org.opensearch.cluster.routing.ShardRouting;
        List<ShardStats> responses,
        this.indicesService = indicesService;  
        try {
        if (indexShard.routingEntry() == null) {
import org.opensearch.transport.TransportService;
    @Inject
    protected IndicesStatsResponse newResponse(  
        IndexService indexService = indicesService.indexServiceSafe(shardRouting.shardId().getIndex());
        return new IndicesStatsResponse(responses.toArray(new ShardStats[0]), totalShards, successfulShards, failedShards, shardFailures);  
            .pollingIngestStats(pollingIngestStats)
import java.util.List;
    @Override
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.engine.CommitStats;  
     * Status goes across *all* shards.
    }
        return new ShardStats(in);
        IndicesService indicesService,
        }  
 */  
    }
        int successfulShards,  
    }
            seqNoStats = indexShard.seqNoStats();  
            retentionLeaseStats = null;
            indexNameExpressionResolver,
import org.opensearch.index.seqno.RetentionLeaseStats;
     */
 * this work for additional information regarding copyright
            .commitStats(commitStats)
            .retentionLeaseStats(retentionLeaseStats)  
            throw new ShardNotFoundException(indexShard.shardId());
 * not use this file except in compliance with the License.
        IndexShard indexShard = indexService.getShard(shardRouting.shardId().id());
            clusterService,
            pollingIngestStats = null;
 * license agreements. See the NOTICE file distributed with
    @Override  
        CommonStats commonStats = new CommonStats(indicesService.getIndicesQueryCache(), indexShard, request.flags());
            pollingIngestStats = indexShard.pollingIngestStats();
 *
 * GitHub history for details.
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.common.inject.Inject;
        int totalShards,
    }
package org.opensearch.action.admin.indices.stats;
        ClusterState clusterState
import org.opensearch.index.seqno.SeqNoStats;
    protected ShardStats shardOperation(IndicesStatsRequest request, ShardRouting shardRouting) {  
 * Unless required by applicable law or agreed to in writing,
        return new IndicesStatsRequest(in);
    /**  
/**
            commitStats = null;
            IndicesStatsRequest::new,  
import org.opensearch.index.IndexService;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 */
    }  
    @Override
            retentionLeaseStats = indexShard.getRetentionLeaseStats();
        IndicesStatsRequest request,
 */  
        ActionFilters actionFilters,  
import java.io.IOException;
    protected IndicesStatsRequest readRequestFrom(StreamInput in) throws IOException {
            seqNoStats = null;  
        IndexNameExpressionResolver indexNameExpressionResolver
 * You may obtain a copy of the License at  
    private final IndicesService indicesService;
    @Override  
 *  
    protected ClusterBlockException checkRequestBlock(ClusterState state, IndicesStatsRequest request, String[] concreteIndices) {
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
    }
import org.apache.lucene.store.AlreadyClosedException;
    @Override
        ClusterService clusterService,  
        TransportService transportService,
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_READ, concreteIndices);  
        // if we don't have the routing entry yet, we need it stats wise, we treat it as if the shard is not ready yet  
 * specific language governing permissions and limitations
    }  
import org.opensearch.cluster.routing.ShardsIterator;  
 * Transport action for retrieving indices stats
    @Override  
        SeqNoStats seqNoStats;
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.indices.IndicesService;
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
    }  
            // shard is closed - no stats is fine
    public TransportIndicesStatsAction(
        super(  
 *
import org.opensearch.threadpool.ThreadPool;
public class TransportIndicesStatsAction extends TransportBroadcastByNodeAction<IndicesStatsRequest, IndicesStatsResponse, ShardStats> {  
/*
        return new ShardStats.Builder().shardRouting(indexShard.routingEntry())
 * Modifications Copyright OpenSearch Contributors. See
        CommitStats commitStats;  
    ) {
            .shardPath(indexShard.shardPath())
        RetentionLeaseStats retentionLeaseStats;
 * compatible open source license.
 */
 *  
    @Override
            ThreadPool.Names.MANAGEMENT
 * SPDX-License-Identifier: Apache-2.0
        }  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.shard.ShardNotFoundException;
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    ) {
 * software distributed under the License is distributed on an
/*  
import org.opensearch.cluster.block.ClusterBlockLevel;  
    protected ClusterBlockException checkGlobalBlock(ClusterState state, IndicesStatsRequest request) {  
            commitStats = indexShard.commitStats();
            IndicesStatsAction.NAME,
    protected ShardsIterator shards(ClusterState clusterState, IndicesStatsRequest request, String[] concreteIndices) {
        } catch (final AlreadyClosedException e) {  
            .build();
        );
 * @opensearch.internal
 *     http://www.apache.org/licenses/LICENSE-2.0
        List<DefaultShardOperationFailedException> shardFailures,  
            actionFilters,
        return clusterState.routingTable().allShards(concreteIndices);
import org.opensearch.index.shard.IndexShard;  
import org.opensearch.action.support.ActionFilters;
 * KIND, either express or implied.  See the License for the
    protected ShardStats readShardResult(StreamInput in) throws IOException {
import org.opensearch.indices.pollingingest.PollingIngestStats;  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
            .seqNoStats(seqNoStats)
            transportService,  
import org.opensearch.cluster.block.ClusterBlockException;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.ClusterState;
}
        PollingIngestStats pollingIngestStats;  
 * under the License.  
        int failedShards,
/*  
