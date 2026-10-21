    private static void replace(List<ShardRouting> copies, ShardRouting existing, ShardRouting replacement) {
import org.opensearch.cluster.routing.allocation.AllocationService;
        assert index >= 0 : existing + " is not in " + copies;
import org.opensearch.cluster.service.ClusterService;
        IndexRoutingTable indexRoutingTable = clusterState.routingTable().index(shard.index());
                            "primary failed while replica initializing",
        for (ShardRouting copy : copies) {
        TransportService transportService,
     * whatever builds the local cluster state to decide, as are primary terms, in-sync allocation ids, and whether and
            indexRoutingTableBuilder.addIndexShard(indexShardRoutingTable.shardId().equals(shardId) ? changed : indexShardRoutingTable);
import java.util.Collections;
 * {@link IndexShardRoutingTable#getByAllocationId} finds it, but there is no entry to remove. So a change to either end
        fail(copies, current, UnassignedInfo.failedShard(current, message, failure, System.nanoTime(), System.currentTimeMillis()));
        return indexRoutingTable.shard(shard.id());
    static ClusterState startShard(ClusterState clusterState, ShardRouting startedShard, long primaryTerm) {
            .build();
                ShardRouting replica = find(copies, recovering);
     */
    private static IndexShardRoutingTable shardRoutingTable(ClusterState clusterState, ShardRouting shard) {
        // A started relocation target replaces its source; moveToStarted finishes the relocation.
    }
                return copy.getTargetRelocatingShard();
    @Nullable
            @Override
     * becomes unassigned, with the reason and a count of failed allocations, or, for either end of a relocation, the
     * The state with {@code startedShard}'s copy started, or {@code clusterState} itself if the message is stale, as
    public LocalShardStateAction(
import org.opensearch.cluster.routing.IndexRoutingTable;
                continue;
    static ClusterState failShard(ClusterState clusterState, ShardRouting failedShard, String message, @Nullable Exception failure) {
     * primary whose term has moved on since it recovered.
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.transport.TransportService;
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(shardId.getIndex());
        return null;
        IndexShardRoutingTable.Builder shardBuilder = new IndexShardRoutingTable.Builder(shardId);
    /**
        String message,
    ) {
     * <p>Leaving the routing entry as it was is not a neutral choice. {@code IndicesClusterStateService} keeps a failed
 * compatible open source license.
        replace(
                listener.onResponse(null);
import java.util.List;
        ShardRouting current = shardRoutingTable == null ? null : shardRoutingTable.getByAllocationId(failedShard.allocationId().getId());
                replace(copies, source, source.cancelRelocation());
    public void shardStarted(
        }
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.routing.RoutingTable;
        return recovering;
                            false,
        return withShard(clusterState, current.shardId(), copies);
    /**
     * <p>Only the routing table changes. One thing {@code RoutingNodes#failShard} does for a failed primary is
    private static ShardRouting find(List<ShardRouting> copies, String allocationId) {
    }
    }
        for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
        ActionListener<Void> listener,
    }
 * The OpenSearch Contributors require contributions made to
     *
                continue;
            .routingTable(RoutingTable.builder(clusterState.routingTable()).add(indexRoutingTableBuilder).build())
        String message,
            // The primary is about to be unassigned, and RoutingNodes asserts that a copy recovering from a primary has
import org.opensearch.cluster.routing.IndexShardRoutingTable;
     * The state with {@code failedShard}'s copy failed, or {@code clusterState} itself if that copy is no longer in it.
            @Override
import org.opensearch.cluster.service.ClusterApplier;
}
        }
                            UnassignedInfo.Reason.PRIMARY_FAILED,
        for (ShardRouting copy : copies) {
        } else if (failed.relocating() && failed.primary() == false) {
    /** Replaces an entry, or, for a derived relocation target, the source entry it is derived from. */
     * absent while the state still claims it is there.
        copies.set(index, replacement);
            current.isRelocationTarget() ? find(copies, current.allocationId().getRelocationId()) : current,
            }
import org.opensearch.threadpool.ThreadPool;
        );
 *
                    );
        IndexShardRoutingTable shardRoutingTable = shardRoutingTable(clusterState, startedShard);
            // one assigned to a node. So the replicas recovering from it fail with it, as they do on a cluster manager.
import org.opensearch.cluster.routing.RerouteService;
        if (current.primary() && primaryTerm > 0) {
            ShardRouting source = find(copies, failed.allocationId().getRelocationId());
     * relocation is undone the way that method undoes it.
                        copies,
    private static List<String> recoveringReplicas(List<ShardRouting> copies) {
            index = copies.indexOf(find(copies, existing.allocationId().getRelocationId()));
     * deliberately not done: promoting an active replica. A promotion comes with a new primary term, and both are for
            }
 * this file be licensed under the Apache-2.0 license or a
        apply("shard-failed " + shardRouting.shardId(), clusterState -> failShard(clusterState, shardRouting, message, failure), listener);
            }
                            unassignedInfo.getUnassignedTimeInMillis(),
        int index = copies.indexOf(existing);
        AllocationService allocationService,
 */
 * SPDX-License-Identifier: Apache-2.0
    public void localShardFailed(
            }
        super(clusterService, transportService, allocationService, rerouteService, threadPool);
    }
            // Cancels the relocation and leaves nothing unassigned.
 * <p>Both changes look the copy up by allocation id in the state being updated, not by equality with the routing they
 *
        return withShard(clusterState, current.shardId(), copies);
     * shard in its failed-shards cache, and so never creates it again, until the shard's routing entry names a different
        }
            public void onFailure(String source, Exception e) {
import java.util.ArrayList;
            if (indexMetadata == null || indexMetadata.primaryTerm(current.id()) != primaryTerm) {
    private void apply(String source, Function<ClusterState, ClusterState> update, ActionListener<Void> listener) {
        List<ShardRouting> copies = new ArrayList<>(shardRoutingTable.shards());
    @Override
            replace(copies, failed, failed.getTargetRelocatingShard().removeRelocationSource());
        ActionListener<Void> listener,
    }
            return clusterState;
                            0,
/**
                        replica,
        });
    /** The allocation ids of the replicas initializing on this shard, relocation targets included. */
 * were given, which may be out of date. A message about an allocation that is no longer in the state, or no longer in
            }
        ShardRouting shardRouting,
 *
        apply("shard-started " + shardRouting.shardId(), clusterState -> startShard(clusterState, shardRouting, primaryTerm), listener);
                if (replica != null && replica.initializing()) {
 * local cluster state. This is used in clusterless mode, where there is no cluster manager.
    private static void fail(List<ShardRouting> copies, ShardRouting failed, UnassignedInfo unassignedInfo) {
import org.opensearch.common.Nullable;
        }
 * of a relocation is a change to the source entry.
        ShardRouting current = shardRoutingTable == null ? null : shardRoutingTable.getByAllocationId(startedShard.allocationId().getId());
        ClusterState currentState
    }
                    fail(
        if (failed.primary() && failed.isRelocationTarget() == false) {
            public void onSuccess(String source) {
            }
        } else {
        }
        }
        IndexShardRoutingTable changed = shardBuilder.build();
            if (copy.relocating() && copy.allocationId().getRelocationId().equals(allocationId)) {
     */
                listener.onFailure(e);
    ) {
    /** As {@code RoutingNodes#failShard}, less the promotion, on a shard's entries. */
        ClusterService clusterService,
            IndexMetadata indexMetadata = clusterState.metadata().index(current.index());
        if (index < 0 && existing.isRelocationTarget()) {
                        )
        long primaryTerm,
    }
                return copy;
     * Fails the copy in the local cluster state, as {@code RoutingNodes#failShard} would on a cluster manager: it
        if (current == null) {
import org.opensearch.cluster.metadata.IndexMetadata;
/*
        copies.forEach(shardBuilder::addShard);
 * the state the message expects, changes nothing.
 * <p>A routing table holds a relocation as one entry, the relocating source. The initializing target is derived from it:
    ) {
import org.opensearch.common.inject.Inject;
        return ClusterState.builder(clusterState)
    /** The entry with this allocation id, or the relocation target derived from one, or null. */
 */
            if (copy.allocationId().getId().equals(allocationId)) {
            for (String recovering : recoveringReplicas(copies)) {
                }
                recovering.add(copy.getTargetRelocatingShard().allocationId().getId());
    @Inject
        ShardRouting shardRouting,
 * A local implementation of {@link ShardStateAction} that applies shard state changes directly to the
        }
        }
            // Re-resolved each time, because failing one may have changed the others.
     */
            if (source != null) {
                return clusterState;
        IndexShardRoutingTable shardRoutingTable = shardRoutingTable(clusterState, failedShard);
     *
        Exception failure,
import java.util.function.Function;
                recovering.add(copy.allocationId().getId());
import org.opensearch.core.index.shard.ShardId;
    private static ClusterState withShard(ClusterState clusterState, ShardId shardId, List<ShardRouting> copies) {
            }
    @Nullable
        List<String> recovering = new ArrayList<>();
            // A relocating primary included: unassigning the source drops its target with it.
                            null,
            // The target is a replica recovering like any other, and has no need of the source.
import org.opensearch.core.action.ActionListener;
    @Override
public class LocalShardStateAction extends ShardStateAction {
        ClusterState currentState
    }
                            unassignedInfo.getUnassignedTimeInNanos(),
     * where to allocate the copy again.
        if (indexRoutingTable == null || shard.allocationId() == null) {
        ThreadPool threadPool
        clusterService.getClusterApplierService().updateClusterState(source, update, new ClusterApplier.ClusterApplyListener() {
            }
        }
            return null;
     * {@code ShardStartedClusterStateTaskExecutor} judges it: the copy is gone, is no longer initializing, or is a
    /**
                            Collections.emptySet()
        if (current == null || current.initializing() == false) {
                            UnassignedInfo.AllocationStatus.NO_ATTEMPT,
            return clusterState;
            } else if (copy.relocating()) {
            if (copy.primary()) {
        List<ShardRouting> copies = new ArrayList<>(shardRoutingTable.shards());
            if (copy.allocationId() == null) {
        if (failed.isRelocationTarget()) {
            replace(copies, failed, failed.moveToUnassigned(unassignedInfo));
            copies,
    }
            }
        IndexRoutingTable indexRoutingTable = clusterState.routingTable().index(shardId.getIndex());
                        new UnassignedInfo(
    }
     * allocation. With the entry left in place, whatever next builds the local cluster state reuses it, and the copy stays
package org.opensearch.cluster.action.shard;
import org.opensearch.cluster.routing.UnassignedInfo;
            }
    }
            current.moveToStarted()
        }
        RerouteService rerouteService,
            if (copy.initializing()) {
