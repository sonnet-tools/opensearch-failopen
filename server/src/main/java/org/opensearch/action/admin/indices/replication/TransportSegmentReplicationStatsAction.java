import org.opensearch.threadpool.ThreadPool;  
            .sum();
 * perform segment replication, it only reports on metrics/stats of segment replication event (both active and complete).  
            ThreadPool.Names.MANAGEMENT  
        final Map<String, List<SegmentReplicationPerGroupStats>> primaryStats = new HashMap<>();  
import java.util.stream.Stream;
    SegmentReplicationStatsResponse,  
        String[] shards = request.shards();
                segmentReplicationStats.setCurrentReplicationState(segmentReplicationState);
    }
import org.opensearch.cluster.block.ClusterBlockException;
                        });
        }  
                                final ArrayList<SegmentReplicationPerGroupStats> list = new ArrayList<>();
                    final ShardRouting shardRouting = response.getReplicaStats().getShardRouting();
                                v.add(response.getPrimaryStats());
        return new SegmentReplicationShardStatsResponse(in);  
        } else {
import org.opensearch.cluster.routing.ShardsIterator;
                                return v;  
    @Override  
    }
        ShardId shardId = shardRouting.shardId();
/**
        return replicaStats.values()  
import org.opensearch.common.inject.Inject;
        Map<String, SegmentReplicationState> replicaStats
import org.opensearch.cluster.block.ClusterBlockLevel;
    private final SegmentReplicationTargetService targetService;  
            .collect(
                SegmentReplicationShardStats segmentReplicationStats = computeSegmentReplicationShardStats(shardRouting);  
    }  
    }
        );
}  
        return completedSegmentReplicationState != null ? completedSegmentReplicationState.getTimer().time() : 0;
        if (shardRouting.primary()) {
    private Set<SegmentReplicationShardStats> computeSearchReplicaStats(
            return new SegmentReplicationShardStatsResponse(pressureService.getStatsForShard(indexShard));
        int successfulShards,
import java.util.Set;  
    @Override  
                        primaryStats.compute(shardId.getIndexName(), (k, v) -> {
            .mapToLong(index -> index.length() - index.recovered())
        List<DefaultShardOperationFailedException> shardFailures,
import org.opensearch.indices.replication.SegmentReplicationState;
                if (response.getReplicaStats() != null) {
                                return list;  
            SegmentReplicationStatsAction.NAME,  
        Map<String, List<SegmentReplicationPerGroupStats>> replicationStats = primaryStats.entrySet()
    @Override
        if (ongoingSegmentReplicationState == null) {
                    final ShardId shardId = response.getPrimaryStats().getShardId();  
    @Override
        // organize replica responses by allocationId.  
    ) {  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
import java.util.HashMap;  
import org.opensearch.core.index.shard.ShardId;
            0,
        int failedShards,
    }  
                }
        ClusterService clusterService,  
            return null;
    }
    SegmentReplicationShardStatsResponse> {
                                list.add(response.getPrimaryStats());
        IndexShard indexShard = indicesService.indexServiceSafe(shardId.getIndex()).getShard(shardId.id());
        Map<String, SegmentReplicationState> replicaStats
        // map of index name to list of replication group stats.
import org.opensearch.index.SegmentReplicationShardStats;
            }
import org.opensearch.cluster.ClusterState;  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);  
            shardRouting.allocationId().getId(),
import org.opensearch.indices.replication.SegmentReplicationTargetService;
    private SegmentReplicationState getSegmentReplicationState(ShardId shardId, boolean isActiveOnly) {
 *
    }  
        ActionFilters actionFilters,
        final List<Integer> shardsToFetch = Arrays.stream(shards).map(Integer::valueOf).collect(Collectors.toList());
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
            .stream()  
 * @opensearch.internal
        if (isActiveOnly) {
            .filter(segmentReplicationState -> segmentReplicationState.getShardRouting().shardId().equals(shardId))
        String[] concreteIndices
        return new SegmentReplicationStatsRequest(in);
    protected ClusterBlockException checkRequestBlock(
import java.util.Map;
import java.util.Arrays;
 *
    }
        ClusterState state,
 */  
    protected SegmentReplicationShardStatsResponse readShardResult(StreamInput in) throws IOException {
        final Map<String, SegmentReplicationState> replicaStats = new HashMap<>();
        SegmentReplicationPerGroupStats groupStats,
                        replicaStats.putIfAbsent(shardRouting.allocationId().getId(), response.getReplicaStats());
    ) {
        }  
            getCurrentReplicationLag(ongoingSegmentReplicationState),
            if (response != null) {  
    @Inject
    private long calculateBytesRemainingToReplicate(SegmentReplicationState ongoingSegmentReplicationState) {  
import org.opensearch.index.SegmentReplicationPressureService;  
                    if (shardsToFetch.isEmpty() || shardsToFetch.contains(shardRouting.shardId().getId())) {  
    @Override
        SegmentReplicationStatsRequest request,
        // Combine ReplicaStats and SearchReplicaStats
            .filter(segmentReplicationState -> segmentReplicationState.getShardRouting().isSearchOnly())  
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_READ, concreteIndices);  
            getLastCompletedReplicationLag(completedSegmentReplicationState)  
    private long getLastCompletedReplicationLag(SegmentReplicationState completedSegmentReplicationState) {  
        return ongoingSegmentReplicationState != null ? ongoingSegmentReplicationState.getTimer().time() : 0;  
            clusterService,
                Collectors.toMap(
                            }
    @Override
            .stream()  
import org.opensearch.action.support.ActionFilters;
            );  
        super(
    }
        for (SegmentReplicationShardStatsResponse response : responses) {
 * Transport action for shard segment replication operation. This transport action does not actually
        SegmentReplicationState ongoingSegmentReplicationState = targetService.getOngoingEventSegmentReplicationState(shardId);
            .stream()  
 * SPDX-License-Identifier: Apache-2.0
        ClusterState clusterState
                    entry -> entry.getValue()
                    Map.Entry::getKey,  
            return targetService.getOngoingEventSegmentReplicationState(shardId);  
 * The OpenSearch Contributors require contributions made to  
        return new SegmentReplicationShardStats(  
    private SegmentReplicationPerGroupStats updateGroupStats(  
    protected SegmentReplicationStatsRequest readRequestFrom(StreamInput in) throws IOException {  
        return new SegmentReplicationShardStatsResponse(getSegmentReplicationState(shardId, request.activeOnly()));
            .collect(Collectors.toSet());
        List<SegmentReplicationShardStatsResponse> responses,  
        }
    protected ShardsIterator shards(ClusterState state, SegmentReplicationStatsRequest request, String[] concreteIndices) {  
    private long getCurrentReplicationLag(SegmentReplicationState ongoingSegmentReplicationState) {
        ShardId shardId,  
                            } else {
        Set<SegmentReplicationShardStats> searchReplicaStats = computeSearchReplicaStats(groupStats.getShardId(), replicaStats);
import org.opensearch.transport.TransportService;
                }  
    public TransportSegmentReplicationStatsAction(
 * compatible open source license.
        // Update the SegmentReplicationState for each of the replicas
    ) {
        return new SegmentReplicationStatsResponse(totalShards, successfulShards, failedShards, replicationStats, shardFailures);
        );
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
                        .map(groupStats -> updateGroupStats(groupStats, replicaStats))  
            calculateBytesRemainingToReplicate(ongoingSegmentReplicationState),  
    }
        if (indexShard.indexSettings().isSegRepEnabledOrRemoteNode() == false) {  
                )
        return new SegmentReplicationPerGroupStats(groupStats.getShardId(), combinedStats, groupStats.getRejectedRequestCount());
    }
        SegmentReplicationPressureService pressureService  
    }
        // Compute search replica stats
            .fileDetails()
    private final IndicesService indicesService;
public class TransportSegmentReplicationStatsAction extends TransportBroadcastByNodeAction<
    SegmentReplicationStatsRequest,
            transportService,
            .collect(Collectors.toSet());
        IndexNameExpressionResolver indexNameExpressionResolver,
        this.indicesService = indicesService;
        SegmentReplicationTargetService targetService,  
            return 0;
import org.opensearch.index.SegmentReplicationPerGroupStats;
        IndicesService indicesService,
            return targetService.getSegmentReplicationState(shardId);
import org.opensearch.indices.IndicesService;  
import org.opensearch.index.shard.IndexShard;
                    }  
    protected SegmentReplicationShardStatsResponse shardOperation(SegmentReplicationStatsRequest request, ShardRouting shardRouting) {
package org.opensearch.action.admin.indices.replication;
            .map(segmentReplicationState -> {
        this.pressureService = pressureService;
 * this file be licensed under the Apache-2.0 license or a
    }
                            if (v == null) {  
        SegmentReplicationStatsRequest request,  
                    if (shardsToFetch.isEmpty() || shardsToFetch.contains(shardId.getId())) {
import java.util.stream.Collectors;
        this.targetService = targetService;  
/*  
        }  
    }  
    ) {
        }  
                    }
            indexNameExpressionResolver,
        Set<SegmentReplicationShardStats> updatedReplicaStats = groupStats.getReplicaStats()
    @Override
                if (response.getPrimaryStats() != null) {
import org.opensearch.cluster.routing.ShardRouting;
import java.util.ArrayList;
            .collect(Collectors.toSet());  
            SegmentReplicationStatsRequest::new,
        SegmentReplicationState completedSegmentReplicationState = targetService.getlatestCompletedEventSegmentReplicationState(shardId);  
        return ongoingSegmentReplicationState.getIndex()
                ShardRouting shardRouting = segmentReplicationState.getShardRouting();
    protected SegmentReplicationStatsResponse newResponse(
    private final SegmentReplicationPressureService pressureService;
                return segmentReplicationStats;
            actionFilters,  
        TransportService transportService,
import java.util.List;
            .peek(replicaStat -> replicaStat.setCurrentReplicationState(replicaStats.getOrDefault(replicaStat.getAllocationId(), null)))
import java.io.IOException;  
        int totalShards,  
    ) {  
                        .stream()
    SegmentReplicationShardStats computeSegmentReplicationShardStats(ShardRouting shardRouting) {
            })  
            .stream()
    protected ClusterBlockException checkGlobalBlock(ClusterState state, SegmentReplicationStatsRequest request) {
 */  
        Set<SegmentReplicationShardStats> combinedStats = Stream.concat(updatedReplicaStats.stream(), searchReplicaStats.stream())
        return state.routingTable().allShardsIncludingRelocationTargets(concreteIndices);
                        .collect(Collectors.toList())
    }
import org.opensearch.core.common.io.stream.StreamInput;  
            0,
        ShardId shardId = shardRouting.shardId();  
import org.opensearch.cluster.service.ClusterService;  
