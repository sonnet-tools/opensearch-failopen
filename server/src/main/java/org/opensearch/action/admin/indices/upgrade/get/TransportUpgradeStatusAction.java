    }  
import java.io.IOException;  
        List<Segment> segments = indexShard.segments(false);
 * Unless required by applicable law or agreed to in writing,
import java.util.List;
        int failedShards,  
import org.opensearch.core.common.io.stream.StreamInput;
        return new ShardUpgradeStatus(indexShard.routingEntry(), total_bytes, to_upgrade_bytes, to_upgrade_bytes_ancient);  
 * software distributed under the License is distributed on an
        );
            transportService,
 * SPDX-License-Identifier: Apache-2.0
    @Override  
        long to_upgrade_bytes = 0;
        List<DefaultShardOperationFailedException> shardFailures,
    @Override
 */
    protected ShardUpgradeStatus readShardResult(StreamInput in) throws IOException {  
            }  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.support.ActionFilters;
    }
        for (Segment seg : segments) {  
    }
        super(
import org.opensearch.transport.TransportService;
import org.opensearch.Version;
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);  
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;  
            actionFilters,  
    ) {
            successfulShards,
        return new UpgradeStatusResponse(
        IndicesService indicesService,
        return new ShardUpgradeStatus(in);
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            shardFailures
 * this work for additional information regarding copyright
     * Getting upgrade stats from *all* active shards.  
        IndexShard indexShard = indexService.getShard(shardRouting.shardId().id());
}
import org.opensearch.cluster.routing.ShardRouting;
    }
 * The OpenSearch Contributors require contributions made to  
/*
 * Modifications Copyright OpenSearch Contributors. See
    }  
import org.opensearch.common.inject.Inject;
    private final IndicesService indicesService;
            ThreadPool.Names.MANAGEMENT  
import org.opensearch.cluster.ClusterState;
            indexNameExpressionResolver,
        List<ShardUpgradeStatus> responses,
        }
                to_upgrade_bytes += seg.sizeInBytes;
    protected ShardUpgradeStatus shardOperation(UpgradeStatusRequest request, ShardRouting shardRouting) {
        return clusterState.routingTable().allShards(concreteIndices);
    }  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.cluster.block.ClusterBlockLevel;  
            clusterService,
 * specific language governing permissions and limitations
import org.opensearch.threadpool.ThreadPool;  
    public TransportUpgradeStatusAction(
 */  
            } else if (seg.version.minor != Version.CURRENT.luceneVersion.minor) {
public class TransportUpgradeStatusAction extends TransportBroadcastByNodeAction<
    }
import org.opensearch.cluster.routing.ShardsIterator;  
/**  
    ShardUpgradeStatus> {
            if (seg.version.major != Version.CURRENT.luceneVersion.major) {
/*  
        ClusterService clusterService,
        UpgradeStatusRequest request,  
 * under the License.  
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
    ) {
import org.opensearch.index.engine.Segment;  
package org.opensearch.action.admin.indices.upgrade.get;
     */
import org.opensearch.cluster.block.ClusterBlockException;
 */  
    @Override
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
    @Override
            totalShards,
    UpgradeStatusResponse,
        this.indicesService = indicesService;
        ActionFilters actionFilters,
    UpgradeStatusRequest,  
            responses.toArray(new ShardUpgradeStatus[0]),  
                to_upgrade_bytes += seg.sizeInBytes;
        IndexService indexService = indicesService.indexServiceSafe(shardRouting.shardId().getIndex());  
    protected UpgradeStatusRequest readRequestFrom(StreamInput in) throws IOException {  
        );
 * the Apache License, Version 2.0 (the "License"); you may
    protected UpgradeStatusResponse newResponse(
        long total_bytes = 0;  
            UpgradeStatusRequest::new,
                // instead, we should check if the codec has changed
    @Inject  
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_READ, concreteIndices);
import org.opensearch.cluster.service.ClusterService;
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
    }
import org.opensearch.indices.IndicesService;
import org.opensearch.index.IndexService;
    @Override
    @Override
 *
        int successfulShards,
 *
 *
import org.opensearch.index.shard.IndexShard;
    /**
                to_upgrade_bytes_ancient += seg.sizeInBytes;  
        TransportService transportService,  
            UpgradeStatusAction.NAME,  
        ClusterState clusterState  
        int totalShards,
    protected ClusterBlockException checkGlobalBlock(ClusterState state, UpgradeStatusRequest request) {
        long to_upgrade_bytes_ancient = 0;
 * You may obtain a copy of the License at  
        return new UpgradeStatusRequest(in);
 */
            failedShards,  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
 * @opensearch.internal  
 * Transport Action for Upgrading an Index
    @Override
    protected ClusterBlockException checkRequestBlock(ClusterState state, UpgradeStatusRequest countRequest, String[] concreteIndices) {
 *  
            total_bytes += seg.sizeInBytes;
        IndexNameExpressionResolver indexNameExpressionResolver  
    protected ShardsIterator shards(ClusterState clusterState, UpgradeStatusRequest request, String[] concreteIndices) {  
                // TODO: this comparison is bogus! it would cause us to upgrade even with the same format  
 * compatible open source license.
