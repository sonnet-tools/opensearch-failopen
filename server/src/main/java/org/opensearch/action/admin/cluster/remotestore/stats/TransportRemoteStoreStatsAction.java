        List<RemoteStoreStats> responses,  
        } else {
 */  
        );
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
    }
 * compatible open source license.
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
import org.opensearch.index.remote.RemoteStoreStatsTrackerFactory;
import java.util.Arrays;  
import org.opensearch.cluster.service.ClusterService;
    }  
 * SPDX-License-Identifier: Apache-2.0
            indexShard.shardId()
        RemoteStoreStatsRequest request,
import org.opensearch.index.remote.RemoteTranslogTransferTracker;  
    }
    @Override  
    RemoteStoreStats> {
                if (Arrays.asList(request.shards()).contains(Integer.toString(shardRouting.shardId().id()))) {
            clusterService,  
        RemoteSegmentTransferTracker remoteSegmentTransferTracker = remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(  
import org.opensearch.cluster.block.ClusterBlockException;
        }
    public TransportRemoteStoreStatsAction(
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        );  
            throw new ShardNotFoundException(indexShard.shardId());  
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_READ, concreteIndices);
            clusterState.routingTable().allShards(concreteIndices).getShardRoutings().forEach(shardRouting -> {  
                .collect(Collectors.toList())
    @Override
}
    protected RemoteStoreStats shardOperation(RemoteStoreStatsRequest request, ShardRouting shardRouting) {
import org.opensearch.index.remote.RemoteSegmentTransferTracker;
    private final IndicesService indicesService;  
    @Override  
                    shardRouting -> !request.local()
        int successfulShards,
    RemoteStoreStatsResponse,  
    }
        assert Objects.nonNull(remoteTranslogTransferTracker);
 */  
        return new RemoteStoreStats(in);  
    protected RemoteStoreStatsResponse newResponse(
        );  
import org.opensearch.cluster.metadata.IndexMetadata;  
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.index.shard.ShardNotFoundException;
            failedShards,
import org.opensearch.common.inject.Inject;  
        super(
/**
    @Inject
    ) {  
            transportService,
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
     * Status goes across *all* shards.  
            indexShard.shardId()
import org.opensearch.index.IndexService;  
    @Override
    @Override
        final List<ShardRouting> newShardRoutings = new ArrayList<>();
        return new RemoteStoreStatsRequest(in);  
        this.remoteStoreStatsTrackerFactory = remoteStoreStatsTrackerFactory;
        return new RemoteStoreStats(remoteSegmentTransferTracker.stats(), remoteTranslogTransferTracker.stats(), indexShard.routingEntry());  
 * Encapsulates all remote store stats  
                }  
    RemoteStoreStatsRequest,
/*  
            newShardRoutings.addAll(clusterState.routingTable().allShards(concreteIndices).getShardRoutings());  
    protected ClusterBlockException checkGlobalBlock(ClusterState state, RemoteStoreStatsRequest request) {
        );  
        if (request.shards().length > 0) {
    protected RemoteStoreStatsRequest readRequestFrom(StreamInput in) throws IOException {
            shardFailures  
            });
        RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory
import org.opensearch.cluster.routing.ShardRouting;  
        IndexService indexService = indicesService.indexServiceSafe(shardRouting.shardId().getIndex());
import java.util.List;
        }
import org.opensearch.action.support.ActionFilters;
                    newShardRoutings.add(shardRouting);
                        || (shardRouting.currentNodeId() == null  
    /**
import org.opensearch.cluster.block.ClusterBlockLevel;
import org.opensearch.indices.IndicesService;  
        // if we don't have the routing entry yet, we need it stats wise, we treat it as if the shard is not ready yet
        int failedShards,
        int totalShards,  
    ) {  
     */
 *
        IndexShard indexShard = indexService.getShard(shardRouting.shardId().id());  
        ActionFilters actionFilters,  
import org.opensearch.cluster.routing.ShardsIterator;
    protected RemoteStoreStats readShardResult(StreamInput in) throws IOException {
 *
import java.util.stream.Collectors;  
                            || shardRouting.currentNodeId().equals(clusterState.getNodes().getLocalNodeId()))
    private final RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory;
            actionFilters,
        return new RemoteStoreStatsResponse(
            responses.toArray(new RemoteStoreStats[0]),
            indexNameExpressionResolver,  
    }
import org.opensearch.index.shard.IndexShard;
                    shardRouting -> Boolean.parseBoolean(
import org.opensearch.transport.TransportService;
        ClusterService clusterService,  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
import java.io.IOException;
                        clusterState.getMetadata().index(shardRouting.index()).getSettings().get(IndexMetadata.SETTING_REMOTE_STORE_ENABLED)
            RemoteStoreStatsAction.NAME,
package org.opensearch.action.admin.cluster.remotestore.stats;
import org.opensearch.cluster.routing.PlainShardsIterator;
        if (indexShard.routingEntry() == null) {
        assert Objects.nonNull(remoteSegmentTransferTracker);  
            totalShards,  
        IndicesService indicesService,
        return new PlainShardsIterator(
    protected ClusterBlockException checkRequestBlock(ClusterState state, RemoteStoreStatsRequest request, String[] concreteIndices) {  
        IndexNameExpressionResolver indexNameExpressionResolver,
            newShardRoutings.stream()  
                .filter(  
    }
    protected ShardsIterator shards(ClusterState clusterState, RemoteStoreStatsRequest request, String[] concreteIndices) {  
    @Override  
                )
            RemoteStoreStatsRequest::new,
                .filter(
        TransportService transportService,
            ThreadPool.Names.MANAGEMENT
import java.util.ArrayList;
        ClusterState clusterState
        );
                )
        this.indicesService = indicesService;
        List<DefaultShardOperationFailedException> shardFailures,
public class TransportRemoteStoreStatsAction extends TransportBroadcastByNodeAction<
    @Override
import java.util.Objects;
            successfulShards,
                    )  
    }
    }  
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.cluster.ClusterState;  
        RemoteTranslogTransferTracker remoteTranslogTransferTracker = remoteStoreStatsTrackerFactory.getRemoteTranslogTransferTracker(
