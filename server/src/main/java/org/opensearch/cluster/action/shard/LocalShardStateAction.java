        return withShard(clusterState, current.shardId(), copies);
        for (ShardRouting copy : copies) {
 */  
        if (failed.primary() && failed.isRelocationTarget() == false) {
     * <p>Leaving the routing entry as it was is not a neutral choice. {@code IndicesClusterStateService} keeps a failed
            public void onSuccess(String source) {
            IndexMetadata indexMetadata = clusterState.metadata().index(current.index());  
 * the state the message expects, changes nothing.  
import java.util.List;  
                            false,
        assert index >= 0 : existing + " is not in " + copies;
        ThreadPool threadPool
    /**
 *
        IndexRoutingTable indexRoutingTable = clusterState.routingTable().index(shardId.getIndex());
            // Re-resolved each time, because failing one may have changed the others.
    /** The entry with this allocation id, or the relocation target derived from one, or null. */
        replace(
/*  
            @Override  
    ) {
/**  
        ActionListener<Void> listener,
            if (indexMetadata == null || indexMetadata.primaryTerm(current.id()) != primaryTerm) {
            .routingTable(RoutingTable.builder(clusterState.routingTable()).add(indexRoutingTableBuilder).build())
        }
    private void apply(String source, Function<ClusterState, ClusterState> update, ActionListener<Void> listener) {
        }
        for (ShardRouting copy : copies) {
        ActionListener<Void> listener,
        AllocationService allocationService,
    }
            replace(copies, failed, failed.getTargetRelocatingShard().removeRelocationSource());  
 * <p>A routing table holds a relocation as one entry, the relocating source. The initializing target is derived from it:
                            null,  
            }  
import org.opensearch.cluster.metadata.IndexMetadata;
            }
                        replica,
     *
import java.util.Collections;
            for (String recovering : recoveringReplicas(copies)) {  
     * whatever builds the local cluster state to decide, as are primary terms, in-sync allocation ids, and whether and
}
            }
    @Override
        // A started relocation target replaces its source; moveToStarted finishes the relocation.
    public void shardStarted(
import org.opensearch.cluster.ClusterState;
    @Nullable  
    private static ShardRouting find(List<ShardRouting> copies, String allocationId) {
    @Override  
        });  
 * of a relocation is a change to the source entry.
        ClusterService clusterService,  
    private static IndexShardRoutingTable shardRoutingTable(ClusterState clusterState, ShardRouting shard) {  
     * primary whose term has moved on since it recovered.  
import org.opensearch.cluster.routing.IndexRoutingTable;  
import org.opensearch.transport.TransportService;
                listener.onFailure(e);
        if (indexRoutingTable == null || shard.allocationId() == null) {
        Exception failure,  
            // Cancels the relocation and leaves nothing unassigned.
import org.opensearch.common.inject.Inject;
 *  
 * {@link IndexShardRoutingTable#getByAllocationId} finds it, but there is no entry to remove. So a change to either end  
import org.opensearch.cluster.service.ClusterApplier;
            .build();
                    fail(  
        copies.forEach(shardBuilder::addShard);
    private static void replace(List<ShardRouting> copies, ShardRouting existing, ShardRouting replacement) {
            replace(copies, failed, failed.moveToUnassigned(unassignedInfo));  
    }
            }  
        IndexRoutingTable indexRoutingTable = clusterState.routingTable().index(shard.index());
                            UnassignedInfo.AllocationStatus.NO_ATTEMPT,
            index = copies.indexOf(find(copies, existing.allocationId().getRelocationId()));
    ) {  
        return indexRoutingTable.shard(shard.id());
                        copies,
     * relocation is undone the way that method undoes it.
    @Inject
        IndexShardRoutingTable changed = shardBuilder.build();
     * becomes unassigned, with the reason and a count of failed allocations, or, for either end of a relocation, the
    private static List<String> recoveringReplicas(List<ShardRouting> copies) {
import org.opensearch.cluster.routing.UnassignedInfo;
    /**
        fail(copies, current, UnassignedInfo.failedShard(current, message, failure, System.nanoTime(), System.currentTimeMillis()));
        String message,
            }
        List<String> recovering = new ArrayList<>();  
        return recovering;
            current.moveToStarted()
     */
                listener.onResponse(null);
        IndexShardRoutingTable.Builder shardBuilder = new IndexShardRoutingTable.Builder(shardId);  
        int index = copies.indexOf(existing);  
     *  
import org.opensearch.threadpool.ThreadPool;
        return withShard(clusterState, current.shardId(), copies);  
    static ClusterState startShard(ClusterState clusterState, ShardRouting startedShard, long primaryTerm) {
import org.opensearch.cluster.routing.IndexShardRoutingTable;
    /**  
package org.opensearch.cluster.action.shard;
                replace(copies, source, source.cancelRelocation());
        apply("shard-failed " + shardRouting.shardId(), clusterState -> failShard(clusterState, shardRouting, message, failure), listener);
import org.opensearch.cluster.routing.RerouteService;
            @Override
    }  
    }
import org.opensearch.cluster.routing.ShardRouting;
     * allocation. With the entry left in place, whatever next builds the local cluster state reuses it, and the copy stays  
            ShardRouting source = find(copies, failed.allocationId().getRelocationId());  
    }
                return copy.getTargetRelocatingShard();
public class LocalShardStateAction extends ShardStateAction {  
 * local cluster state. This is used in clusterless mode, where there is no cluster manager.
import org.opensearch.common.Nullable;  
        IndexShardRoutingTable shardRoutingTable = shardRoutingTable(clusterState, failedShard);
        ShardRouting shardRouting,
        if (index < 0 && existing.isRelocationTarget()) {
        apply("shard-started " + shardRouting.shardId(), clusterState -> startShard(clusterState, shardRouting, primaryTerm), listener);
 * SPDX-License-Identifier: Apache-2.0
            }
        }
        ShardRouting current = shardRoutingTable == null ? null : shardRoutingTable.getByAllocationId(failedShard.allocationId().getId());  
 * this file be licensed under the Apache-2.0 license or a
        List<ShardRouting> copies = new ArrayList<>(shardRoutingTable.shards());
     * shard in its failed-shards cache, and so never creates it again, until the shard's routing entry names a different
            if (copy.initializing()) {
     * Fails the copy in the local cluster state, as {@code RoutingNodes#failShard} would on a cluster manager: it  
    }  
    static ClusterState failShard(ClusterState clusterState, ShardRouting failedShard, String message, @Nullable Exception failure) {
import org.opensearch.cluster.service.ClusterService;
        if (current.primary() && primaryTerm > 0) {
                continue;  
            indexRoutingTableBuilder.addIndexShard(indexShardRoutingTable.shardId().equals(shardId) ? changed : indexShardRoutingTable);
    /** As {@code RoutingNodes#failShard}, less the promotion, on a shard's entries. */  
 * A local implementation of {@link ShardStateAction} that applies shard state changes directly to the
                recovering.add(copy.allocationId().getId());  
        TransportService transportService,
            return null;  
        ClusterState currentState
        super(clusterService, transportService, allocationService, rerouteService, threadPool);  
     * {@code ShardStartedClusterStateTaskExecutor} judges it: the copy is gone, is no longer initializing, or is a
        List<ShardRouting> copies = new ArrayList<>(shardRoutingTable.shards());  
                            unassignedInfo.getUnassignedTimeInNanos(),
        long primaryTerm,  
    }  
        }
        } else {
import org.opensearch.core.index.shard.ShardId;  
        String message,
        }  
            // The primary is about to be unassigned, and RoutingNodes asserts that a copy recovering from a primary has  
        if (current == null) {
    /** Replaces an entry, or, for a derived relocation target, the source entry it is derived from. */
        }  
            }
    }
 *
    @Nullable
                if (replica != null && replica.initializing()) {
        }
            }
            // The target is a replica recovering like any other, and has no need of the source.
            } else if (copy.relocating()) {
        ShardRouting shardRouting,
                return clusterState;
    }  
            }  
            if (copy.allocationId().getId().equals(allocationId)) {  
        if (failed.isRelocationTarget()) {
        return ClusterState.builder(clusterState)  
    ) {
        }
            public void onFailure(String source, Exception e) {  
    private static void fail(List<ShardRouting> copies, ShardRouting failed, UnassignedInfo unassignedInfo) {
        } else if (failed.relocating() && failed.primary() == false) {
            }  
                ShardRouting replica = find(copies, recovering);
            if (copy.allocationId() == null) {  
 * were given, which may be out of date. A message about an allocation that is no longer in the state, or no longer in
    /** The allocation ids of the replicas initializing on this shard, relocation targets included. */
        RerouteService rerouteService,  
    public void localShardFailed(  
     * deliberately not done: promoting an active replica. A promotion comes with a new primary term, and both are for
     * The state with {@code startedShard}'s copy started, or {@code clusterState} itself if the message is stale, as
            // A relocating primary included: unassigning the source drops its target with it.
            return clusterState;
        ClusterState currentState  
                return copy;
        copies.set(index, replacement);
        return null;
        );  
    public LocalShardStateAction(
import org.opensearch.cluster.routing.allocation.AllocationService;  
                            unassignedInfo.getUnassignedTimeInMillis(),  
                recovering.add(copy.getTargetRelocatingShard().allocationId().getId());
        ShardRouting current = shardRoutingTable == null ? null : shardRoutingTable.getByAllocationId(startedShard.allocationId().getId());
        if (current == null || current.initializing() == false) {
     */  
                        )
        IndexShardRoutingTable shardRoutingTable = shardRoutingTable(clusterState, startedShard);  
     * <p>Only the routing table changes. One thing {@code RoutingNodes#failShard} does for a failed primary is  
 * compatible open source license.
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(shardId.getIndex());
import org.opensearch.cluster.routing.RoutingTable;  
        }
     * absent while the state still claims it is there.
 * The OpenSearch Contributors require contributions made to  
                            UnassignedInfo.Reason.PRIMARY_FAILED,
                            Collections.emptySet()  
            if (copy.primary()) {
                continue;
import org.opensearch.core.action.ActionListener;
 * <p>Both changes look the copy up by allocation id in the state being updated, not by equality with the routing they
    private static ClusterState withShard(ClusterState clusterState, ShardId shardId, List<ShardRouting> copies) {
                        new UnassignedInfo(  
                            0,
import java.util.function.Function;
                    );
    }
            return clusterState;  
        for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {  
     * The state with {@code failedShard}'s copy failed, or {@code clusterState} itself if that copy is no longer in it.
     * where to allocate the copy again.  
            current.isRelocationTarget() ? find(copies, current.allocationId().getRelocationId()) : current,
    }  
            if (copy.relocating() && copy.allocationId().getRelocationId().equals(allocationId)) {  
import java.util.ArrayList;
                            "primary failed while replica initializing",
        clusterService.getClusterApplierService().updateClusterState(source, update, new ClusterApplier.ClusterApplyListener() {
 */
            copies,  
            // one assigned to a node. So the replicas recovering from it fail with it, as they do on a cluster manager.
     */
        }  
                }  
    }
            if (source != null) {
