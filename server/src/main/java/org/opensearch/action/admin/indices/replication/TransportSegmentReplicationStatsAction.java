import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.indices.IndicesService;
        IndexNameExpressionResolver indexNameExpressionResolver,
    }
        SegmentReplicationPerGroupStats groupStats,
            return 0;
                SegmentReplicationShardStats segmentReplicationStats = computeSegmentReplicationShardStats(shardRouting);
    }
    }
                                return v;
import org.opensearch.transport.TransportService;
        super(
                    }
    private final SegmentReplicationPressureService pressureService;
            actionFilters,
        ShardId shardId = shardRouting.shardId();
        String[] concreteIndices
import org.opensearch.cluster.ClusterState;
        List<DefaultShardOperationFailedException> shardFailures,
        this.indicesService = indicesService;
 */
        return new SegmentReplicationPerGroupStats(groupStats.getShardId(), combinedStats, groupStats.getRejectedRequestCount());
        if (indexShard.indexSettings().isSegRepEnabledOrRemoteNode() == false) {
import java.util.List;
 */
    ) {
            .stream()
    SegmentReplicationShardStatsResponse> {
            .fileDetails()
        return completedSegmentReplicationState != null ? completedSegmentReplicationState.getTimer().time() : 0;
    }
                                v.add(response.getPrimaryStats());
import org.opensearch.threadpool.ThreadPool;
        return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_READ, concreteIndices);
import org.opensearch.index.SegmentReplicationPressureService;
    SegmentReplicationStatsResponse,
                    if (shardsToFetch.isEmpty() || shardsToFetch.contains(shardRouting.shardId().getId())) {
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.index.SegmentReplicationShardStats;
        Map<String, SegmentReplicationState> replicaStats
    }
import org.opensearch.core.index.shard.ShardId;
        return ongoingSegmentReplicationState.getIndex()
import org.opensearch.cluster.routing.ShardsIterator;
    public TransportSegmentReplicationStatsAction(
        final Map<String, List<SegmentReplicationPerGroupStats>> primaryStats = new HashMap<>();
        IndicesService indicesService,
import java.io.IOException;
 * compatible open source license.
    ) {
        return new SegmentReplicationStatsResponse(totalShards, successfulShards, failedShards, replicationStats, shardFailures);
        return new SegmentReplicationStatsRequest(in);
        Map<String, List<SegmentReplicationPerGroupStats>> replicationStats = primaryStats.entrySet()
        TransportService transportService,
    }
        ShardId shardId,
 * @opensearch.internal
                    Map.Entry::getKey,
    }
import org.opensearch.common.inject.Inject;
    }
    private SegmentReplicationPerGroupStats updateGroupStats(
            indexNameExpressionResolver,
    @Override
        // map of index name to list of replication group stats.
        Set<SegmentReplicationShardStats> updatedReplicaStats = groupStats.getReplicaStats()
 *
        }
            return new SegmentReplicationShardStatsResponse(pressureService.getStatsForShard(indexShard));
import java.util.ArrayList;
                }
                            } else {
                if (response.getReplicaStats() != null) {
    @Override
                            if (v == null) {
                if (response.getPrimaryStats() != null) {
        }
            .map(segmentReplicationState -> {
        // organize replica responses by allocationId.
            .sum();
    ) {
            .collect(Collectors.toSet());
/*
            .filter(segmentReplicationState -> segmentReplicationState.getShardRouting().shardId().equals(shardId))
    @Override
                                final ArrayList<SegmentReplicationPerGroupStats> list = new ArrayList<>();
        int successfulShards,
    @Override
    protected ClusterBlockException checkGlobalBlock(ClusterState state, SegmentReplicationStatsRequest request) {
    @Override
            .collect(Collectors.toSet());
import org.opensearch.index.shard.IndexShard;
        if (isActiveOnly) {
import org.opensearch.cluster.service.ClusterService;
            return targetService.getSegmentReplicationState(shardId);
        return ongoingSegmentReplicationState != null ? ongoingSegmentReplicationState.getTimer().time() : 0;
        return state.routingTable().allShardsIncludingRelocationTargets(concreteIndices);
    SegmentReplicationShardStats computeSegmentReplicationShardStats(ShardRouting shardRouting) {
                )
    }
    private Set<SegmentReplicationShardStats> computeSearchReplicaStats(
    @Inject
            })
 * The OpenSearch Contributors require contributions made to
        SegmentReplicationStatsRequest request,
        SegmentReplicationState ongoingSegmentReplicationState = targetService.getOngoingEventSegmentReplicationState(shardId);
        return new SegmentReplicationShardStatsResponse(in);
            0,
                                list.add(response.getPrimaryStats());
        } else {
                        .collect(Collectors.toList())
                    final ShardId shardId = response.getPrimaryStats().getShardId();
        ClusterService clusterService,
            getLastCompletedReplicationLag(completedSegmentReplicationState)
 * Transport action for shard segment replication operation. This transport action does not actually
    ) {
            transportService,
}
import org.opensearch.action.support.ActionFilters;
/**
package org.opensearch.action.admin.indices.replication;
            SegmentReplicationStatsRequest::new,
    @Override
import org.opensearch.indices.replication.SegmentReplicationTargetService;
    private final IndicesService indicesService;
        IndexShard indexShard = indicesService.indexServiceSafe(shardId.getIndex()).getShard(shardId.id());
                        });
        for (SegmentReplicationShardStatsResponse response : responses) {
    private long getLastCompletedReplicationLag(SegmentReplicationState completedSegmentReplicationState) {
        if (shardRouting.primary()) {
            clusterService,
        ActionFilters actionFilters,
import java.util.stream.Stream;
 * this file be licensed under the Apache-2.0 license or a
        );
 * perform segment replication, it only reports on metrics/stats of segment replication event (both active and complete).
            .peek(replicaStat -> replicaStat.setCurrentReplicationState(replicaStats.getOrDefault(replicaStat.getAllocationId(), null)))
            return null;
                    entry -> entry.getValue()
        SegmentReplicationPressureService pressureService
public class TransportSegmentReplicationStatsAction extends TransportBroadcastByNodeAction<
            .stream()
import java.util.HashMap;
        SegmentReplicationTargetService targetService,
        final List<Integer> shardsToFetch = Arrays.stream(shards).map(Integer::valueOf).collect(Collectors.toList());
                    if (shardsToFetch.isEmpty() || shardsToFetch.contains(shardId.getId())) {
    }
        }
 * SPDX-License-Identifier: Apache-2.0
        // Compute search replica stats
                }
        Map<String, SegmentReplicationState> replicaStats
                ShardRouting shardRouting = segmentReplicationState.getShardRouting();
            .collect(
        SegmentReplicationState completedSegmentReplicationState = targetService.getlatestCompletedEventSegmentReplicationState(shardId);
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        if (ongoingSegmentReplicationState == null) {
    @Override
        );
        return new SegmentReplicationShardStatsResponse(getSegmentReplicationState(shardId, request.activeOnly()));
            getCurrentReplicationLag(ongoingSegmentReplicationState),
    ) {
    protected SegmentReplicationShardStatsResponse readShardResult(StreamInput in) throws IOException {
    }
        int totalShards,
import org.opensearch.cluster.routing.ShardRouting;
    protected SegmentReplicationShardStatsResponse shardOperation(SegmentReplicationStatsRequest request, ShardRouting shardRouting) {
        this.pressureService = pressureService;
import org.opensearch.index.SegmentReplicationPerGroupStats;
import java.util.Set;
                        .map(groupStats -> updateGroupStats(groupStats, replicaStats))
                    final ShardRouting shardRouting = response.getReplicaStats().getShardRouting();
    }
            return targetService.getOngoingEventSegmentReplicationState(shardId);
            .stream()
            );
                segmentReplicationStats.setCurrentReplicationState(segmentReplicationState);
        String[] shards = request.shards();
            }
                Collectors.toMap(
    private long getCurrentReplicationLag(SegmentReplicationState ongoingSegmentReplicationState) {
            SegmentReplicationStatsAction.NAME,
        }
            0,
    }
                        .stream()
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
        // Combine ReplicaStats and SearchReplicaStats
                    }
        int failedShards,
            ThreadPool.Names.MANAGEMENT
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        List<SegmentReplicationShardStatsResponse> responses,
 *
    }
            shardRouting.allocationId().getId(),
        // Update the SegmentReplicationState for each of the replicas
                        primaryStats.compute(shardId.getIndexName(), (k, v) -> {
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
            calculateBytesRemainingToReplicate(ongoingSegmentReplicationState),
        this.targetService = targetService;
        ShardId shardId = shardRouting.shardId();
    SegmentReplicationStatsRequest,
    }
    private long calculateBytesRemainingToReplicate(SegmentReplicationState ongoingSegmentReplicationState) {
            .mapToLong(index -> index.length() - index.recovered())
        final Map<String, SegmentReplicationState> replicaStats = new HashMap<>();
import java.util.Map;
import org.opensearch.indices.replication.SegmentReplicationState;
    protected ClusterBlockException checkRequestBlock(
    protected ShardsIterator shards(ClusterState state, SegmentReplicationStatsRequest request, String[] concreteIndices) {
                            }
    protected SegmentReplicationStatsRequest readRequestFrom(StreamInput in) throws IOException {
        SegmentReplicationStatsRequest request,
    private SegmentReplicationState getSegmentReplicationState(ShardId shardId, boolean isActiveOnly) {
        }
            .collect(Collectors.toSet());
import java.util.stream.Collectors;
            .stream()
    private final SegmentReplicationTargetService targetService;
        Set<SegmentReplicationShardStats> combinedStats = Stream.concat(updatedReplicaStats.stream(), searchReplicaStats.stream())
                                return list;
import org.opensearch.cluster.block.ClusterBlockLevel;
        ClusterState state,
        return new SegmentReplicationShardStats(
                        replicaStats.putIfAbsent(shardRouting.allocationId().getId(), response.getReplicaStats());
        Set<SegmentReplicationShardStats> searchReplicaStats = computeSearchReplicaStats(groupStats.getShardId(), replicaStats);
import java.util.Arrays;
        ClusterState clusterState
            if (response != null) {
            .filter(segmentReplicationState -> segmentReplicationState.getShardRouting().isSearchOnly())
                return segmentReplicationStats;
        return replicaStats.values()
    protected SegmentReplicationStatsResponse newResponse(
