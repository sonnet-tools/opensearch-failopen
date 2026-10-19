import java.util.HashMap;
            return ClusterState.builder(clusterState).metadata(metadataBuilder).build();
 * SPDX-License-Identifier: Apache-2.0
                indexMetadataBuilder = updateInSyncAllocations(newRoutingTable, oldIndexMetadata, indexMetadataBuilder, shardId, updates);
    public void relocationCompleted(ShardRouting removedRelocationSource) {  
 * The OpenSearch Contributors require contributions made to  
            .collect(Collectors.groupingBy(e -> e.getKey().getIndex()));
                    .sorted(Comparator.comparing(assignedAllocations::contains).reversed()) // values with routing entries first  
                    .stream()
            if (indexMetadataBuilder != null) {
    @Override
                    + ", ids to remove: "
package org.opensearch.cluster.routing.allocation;
     * @param newRoutingTable {@link RoutingTable} object after routing changes were applied.
                int shardNumber = shardEntry.getKey().getId();
            return metadataBuilder.build();
        if (initializedShard.primary()) {
        }  
                updates.firstFailedPrimary = failedShard;
        return shardChanges.computeIfAbsent(shardId, k -> new Updates());
    public void setOngoingRemoteStoreMigration(boolean ongoingRemoteStoreMigration) {  
        Updates updates = changes(startedShard.shardId());
            int maxActiveShards = oldIndexMetadata.getNumberOfReplicas() + 1; // +1 for
                + updates.addedAllocationIds
            for (Map.Entry<ShardId, Updates> shardEntry : indexChanges.getValue()) {
                indexMetadataBuilder.putInSyncAllocationIds(shardId.id(), Collections.emptySet());  
            }  
            // be extra safe here and only update in-sync set if it is non-empty
            updates.initializedPrimary = initializedShard;
                    + assignedShards
    /**
        // check if we have been force-initializing an empty primary or a stale primary
        // Track change through shardChanges Map regardless of above-mentioned conditions
        changes(shardId).increaseTerm = true;  
                        || recoverySource instanceof RecoverySource.RemoteStoreRecoverySource
 * You may obtain a copy of the License at  
        assert initializedShard.isRelocationTarget() == false : "shardInitialized is not called on relocation target: " + initializedShard;  
    }
                    metadataBuilder = Metadata.builder(oldMetadata);  
                assert assignedShards.size() <= maxActiveShards : "cannot have more assigned shards "  
        }
    public Metadata applyChanges(Metadata oldMetadata, RoutingTable newRoutingTable, DiscoveryNodes discoveryNodes) {
import org.opensearch.core.index.Index;
            }  
                + startedShard.allocationId().getId()
            // we're not reusing an existing in-sync allocation id to initialize a primary, which means that we're either force-allocating
 * license agreements. See the NOTICE file distributed with
                Set<String> oldInSyncAllocations = oldIndexMetadata.inSyncAllocationIds(shardNumber);
            IndexShardRoutingTable newShardRoutingTable = newRoutingTable.shardRoutingTable(shardId);
            .stream()  
        }
            if (newShardRoutingTable.activeShards().isEmpty() && updates.firstFailedPrimary != null) {
        return indexMetadataBuilder;
            .entrySet()) {
            // an empty or a stale primary (see AllocateEmptyPrimaryAllocationCommand or AllocateStalePrimaryAllocationCommand).  
     * @return adapted {@link Metadata}, potentially the original one if no change was needed.
}
                || inSyncAllocationIds.contains(RecoverySource.ExistingStoreRecoverySource.FORCED_ALLOCATION_ID) == false  
                // trim entries that have no corresponding shard routing in the cluster state (i.e. trim unavailable copies)  
            // Prevent set of inSyncAllocationIds to grow unboundedly. This can happen for example if we don't write to a primary  
     */  
                logger.warn("{} marking unavailable shards as stale: {}", shardEntry.getKey(), idsToRemove);
import org.apache.logging.log4j.Logger;
        // if the started shard is an untracked replica, don't bother sending it as part of the
                    : "removing stale ids: " + idsToRemove + ", some of which have still a routing entry: " + oldRoutingTable;
                // be extra safe here: if the in-sync set were to become empty, this would create an empty primary on the next allocation
            && oldInSyncAllocationIds.isEmpty() == false  
        IndexMetadata oldIndexMetadata,  
    }  
        private boolean increaseTerm; // whether primary term should be increased
        // To be used to update index metadata while computing new cluster state
import org.opensearch.index.remote.RemoteMigrationIndexMetadataUpdater;
        private ShardRouting initializedPrimary = null; // primary that was initialized from unassigned
 * @opensearch.internal  
            indexMetadataBuilder.primaryTerm(shardId.id(), oldIndexMetadata.primaryTerm(shardId.id()) + 1);
     * Updates in-sync allocations with routing changes that were made to the routing table.
            if (updates.firstFailedPrimary == null) {  
     * Increase primary term for this shard id  
            // started shard has to have null recoverySource; have to pick up recoverySource from its initializing state
 * compatible open source license.
                    }
        if (failedShard.active() && failedShard.primary()) {
                    RemoteMigrationIndexMetadataUpdater migrationImdUpdater = new RemoteMigrationIndexMetadataUpdater(
import org.opensearch.cluster.routing.RecoverySource;
    }
                    .collect(Collectors.toList());
                .stream()
    }  
            IndexMetadata.Builder indexMetadataBuilder = null;
 * specific language governing permissions and limitations
                // more than one primary can be failed (because of batching, primary can be failed, replica promoted and then failed...)
            return oldMetadata;  
                if (metadataBuilder == null) {
     */
        // To be used to update index metadata while computing new cluster state
                    metadataBuilder = Metadata.builder(oldMetadata);  
                metadataBuilder.put(indexMetadataBuilder);
                if (remainingInSyncAllocations.isEmpty() == false) {
/*  
        }
        private Set<String> removedAllocationIds = new HashSet<>(); // allocation ids that should be removed from the in-sync set
    public void relocationStarted(ShardRouting startedShard, ShardRouting targetRelocatingShard) {  
                    + maxActiveShards;  
     */  
 * Unless required by applicable law or agreed to in writing,
            boolean emptyPrimary = recoverySourceType == RecoverySource.Type.EMPTY_STORE;  
            // the primary fails but there is no new primary to fail over to. If we were to remove the allocation id of the primary from the  
                .entrySet()) {  
        Metadata.Builder metadataBuilder = null;
import java.util.stream.Collectors;
        if (ongoingRemoteStoreMigration) {  
                    indexMetadataBuilder = IndexMetadata.builder(oldIndexMetadata);
    }  
    @Override
            }
                }
 * ownership. Elasticsearch licenses this file to you under  
                        indexMetadataBuilder = IndexMetadata.builder(oldIndexMetadata);  
        IndexMetadata.Builder indexMetadataBuilder,  
    /**
            : "initializingShard.allocationId ["
                + ")";  
            if (indexMetadataBuilder == null) {
 * this work for additional information regarding copyright
            Updates updates = changes(failedShard.shardId());
                .collect(Collectors.groupingBy(staleShard -> staleShard.getShardId()))
        // Store change in shardChanges Map regardless of above-mentioned conditions
                Set<String> remainingInSyncAllocations = Sets.difference(oldInSyncAllocations, idsToRemove);  
            }
            // of replicas was decreased while shards were unassigned.
            changes(shardRouting.shardId()).removedAllocationIds.add(shardRouting.allocationId().getId());
            changes(targetRelocatingShard.shardId());
                    + oldInSyncAllocations
            }
            }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Collections;  
            changes(failedShard.shardId());
     * Remove allocation id of this shard from the set of in-sync shard copies  
                .noneMatch(inSyncAllocationIds::contains) : newShardRoutingTable.assignedShards() + " vs " + inSyncAllocationIds;
                    .collect(Collectors.toSet());
                + "] and startedShard.allocationId ["
                // forcing an empty primary resets the in-sync allocations to the empty set (ShardRouting.allocatedPostIndexCreate)
                    indexMetadataBuilder.putInSyncAllocationIds(shardNumber, remainingInSyncAllocations);
 */  
            }  
        ShardId shardId,
    /**  
                : "in-sync allocations cannot become empty after they have been non-empty: " + oldInSyncAllocationIds;
import java.util.Objects;  
                    migrationImdUpdater.maybeAddRemoteIndexSettings(indexMetadataBuilder, index.getName());  
    }
            }
     */  
    }  
        RoutingTable oldRoutingTable = clusterState.routingTable();  
                if (metadataBuilder == null) {
    /**
                + initializingShard.allocationId().getId()  
            // standard path for updating in-sync ids  
        }
import org.opensearch.cluster.node.DiscoveryNodes;  
                        discoveryNodes,
     * @param oldMetadata {@link Metadata} object from before the routing nodes was changed.  
import java.util.Map;
        RoutingTable newRoutingTable,
import org.apache.logging.log4j.LogManager;
/**
        if (startedShard.isSearchOnly() == false) {
        Updates updates  
        } else {
     */  
            // Only trim the set of allocation ids when it grows, otherwise we might trim too eagerly when the number  
     * Manipulates index settings or index metadata during an ongoing remote store migration
                + updates.initializedPrimary  
    private void increasePrimaryTerm(ShardId shardId) {
                        oldIndexMetadata,
                inSyncAllocationIds.add(updates.firstFailedPrimary.allocationId().getId());
 */
import java.util.Set;
        }
                    .limit(maxActiveShards)
 */
 * <p>  
    private final Logger logger = LogManager.getLogger(IndexMetadataUpdater.class);  
    private IndexMetadata.Builder updatePrimaryTerm(
                final String allocationId;
            && oldInSyncAllocationIds.contains(updates.initializedPrimary.allocationId().getId()) == false) {
        } else {
                indexMetadataBuilder = IndexMetadata.builder(oldIndexMetadata);  
                indexMetadataBuilder.putInSyncAllocationIds(shardId.id(), inSyncAllocationIds);  
        IndexMetadata oldIndexMetadata,
            // but repeatedly shut down nodes that have active replicas.
    void removeAllocationId(ShardRouting shardRouting) {
            // group staleShards entries by shard id
                + " primary is not force-initialized in same allocation round where shards are started";
                    + shardEntry.getKey()
     */  
        } else {
    ) {
                if (recoverySource == RecoverySource.ExistingStoreRecoverySource.FORCE_STALE_PRIMARY_INSTANCE) {  
        Updates updates
                + initializedShard
    public void shardInitialized(ShardRouting unassignedShard, ShardRouting initializedShard) {
import org.opensearch.cluster.ClusterState;  
        IndexMetadata.Builder indexMetadataBuilder,
            final IndexMetadata oldIndexMetadata = oldMetadata.getIndexSafe(indexEntry.getKey());  
                metadataBuilder.put(indexMetadataBuilder);
        }
            updates.addedAllocationIds.add(startedShard.allocationId().getId());
 *     http://www.apache.org/licenses/LICENSE-2.0
            RecoverySource recoverySource = updates.initializedPrimary.recoverySource();
            } else {
     * we update {@link IndexMetadata#getInSyncAllocationIds()} and {@link IndexMetadata#primaryTerm(int)} based on
                    assert (recoverySource instanceof RecoverySource.SnapshotRecoverySource  
            if (inSyncAllocationIds.isEmpty() == false) {
        }
                        newRoutingTable,  
        Set<String> oldInSyncAllocationIds = oldIndexMetadata.inSyncAllocationIds(shardId.id());
import org.opensearch.cluster.routing.RoutingTable;
            assert updates.initializedPrimary == null : "Primary cannot be initialized more than once in same allocation round: "
            updates.removedAllocationIds.add(RecoverySource.ExistingStoreRecoverySource.FORCED_ALLOCATION_ID);
            if (indexMetadataBuilder != null) {
        return indexMetadataBuilder;  
        Metadata.Builder metadataBuilder = null;
    public static ClusterState removeStaleIdsWithoutRoutings(ClusterState clusterState, List<StaleShard> staleShards, Logger logger) {
                + "(previous: "
            increasePrimaryTerm(failedShard.shardId());
                    + " (before: "  
    @Override
     * This method is called in AllocationService before any changes to the routing table are made.
                    allocationId = updates.initializedPrimary.allocationId().getId();  
        Metadata oldMetadata = clusterState.metadata();
            increasePrimaryTerm(initializedShard.shardId());
                // forcing a stale primary resets the in-sync allocations to the singleton set with the stale id
                }
                .filter(ShardRouting::isRelocationTarget)
            inSyncAllocationIds.removeAll(updates.removedAllocationIds);  
            // in-sync set, this could create an empty primary on the next allocation.
            && (initializingShard.recoverySource() == RecoverySource.ExistingStoreRecoverySource.FORCE_STALE_PRIMARY_INSTANCE)) {  
                assert idsToRemove.stream().allMatch(id -> oldRoutingTable.getByAllocationId(shardEntry.getKey(), id) == null)
    }
            Index index = indexChanges.getKey();
    @Override
            }  
                    .filter(s -> s.isRelocationTarget() == false)  
            RecoverySource.Type recoverySourceType = recoverySource.getType();
                } else {
import org.opensearch.core.index.shard.ShardId;  
    private boolean ongoingRemoteStoreMigration = false;
                        || recoverySource instanceof RecoverySource.ExistingStoreRecoverySource) : recoverySource;
 *
            // only remove allocation id of failed active primary if there is at least one active shard remaining. Assume for example that
            if (emptyPrimary) {
 * under the License.  
import java.util.Comparator;
 * software distributed under the License is distributed on an
            // We use number_of_replicas + 1 (= possible active shard copies) to bound the inSyncAllocationIds set
        this.ongoingRemoteStoreMigration = ongoingRemoteStoreMigration;
                    + ")";
     * Adds the target {@link ShardRouting} to the tracking updates set.
        private ShardRouting firstFailedPrimary = null; // first active primary that was failed  
        if (shardRouting.active()) {  
        assert Objects.equals(initializingShard.allocationId().getId(), startedShard.allocationId().getId())
    ) {  
                ShardId shardId = shardEntry.getKey();
        // in sync id set.  
                Set<String> assignedAllocations = assignedShards.stream().map(s -> s.allocationId().getId()).collect(Collectors.toSet());
            .collect(Collectors.groupingBy(fs -> fs.getShardId().getIndex()))
    }
public class IndexMetadataUpdater extends RoutingChangesObserver.AbstractRoutingChangesObserver {
            assert updates.addedAllocationIds.isEmpty() : (emptyPrimary ? "empty" : "stale")
 * this file be licensed under the Apache-2.0 license or a
     * the changes made during this allocation.
    private static class Updates {
     *
                indexMetadataBuilder = IndexMetadata.builder(oldIndexMetadata);
 * Allocation ids are added for shards that become active and removed for shards that stop being active.
     * Updates the current {@link Metadata} based on the changes of this RoutingChangesObserver. Specifically  
import org.opensearch.cluster.routing.UnassignedInfo;  
    /**
            }
                                                                              // primary
            if (inSyncAllocationIds.size() > oldInSyncAllocationIds.size() && inSyncAllocationIds.size() > maxActiveShards) {
        assert Sets.haveEmptyIntersection(updates.addedAllocationIds, updates.removedAllocationIds)
                : "fake allocation id has to be removed, inSyncAllocationIds:" + inSyncAllocationIds;
                    allocationId = RecoverySource.ExistingStoreRecoverySource.FORCED_ALLOCATION_ID;
                    );
                }
                    if (indexMetadataBuilder == null) {
            final IndexMetadata oldIndexMetadata = oldMetadata.getIndexSafe(index);
     * Increases the primary term if {@link #increasePrimaryTerm} was called for this shard id.
            Set<String> inSyncAllocationIds = new HashSet<>(oldInSyncAllocationIds);
                + updates.removedAllocationIds;  
                .map(s -> s.allocationId().getId())  
        private Set<String> addedAllocationIds = new HashSet<>(); // allocation ids that should be added to the in-sync set  
     * <br>  
                }  
            for (Map.Entry<ShardId, List<StaleShard>> shardEntry : indexEntry.getValue()  
                    migrationImdUpdater.maybeUpdateRemoteStoreCustomMetadata(indexMetadataBuilder, index.getName());
                List<ShardRouting> assignedShards = newShardRoutingTable.assignedShards()
import org.opensearch.cluster.routing.ShardRouting;
                indexMetadataBuilder.putInSyncAllocationIds(shardId.id(), Collections.singleton(allocationId));  
 * not use this file except in compliance with the License.
 *  
                        logger  
 * the Apache License, Version 2.0 (the "License"); you may
        if (startedShard.primary()
 *
                indexMetadataBuilder = updatePrimaryTerm(oldIndexMetadata, indexMetadataBuilder, shardId, updates);
                + "] have to have the same";  
            Updates updates = changes(initializedShard.shardId());  
/*  
            return clusterState;  
    private final Map<ShardId, Updates> shardChanges = new HashMap<>();
                inSyncAllocationIds = inSyncAllocationIds.stream()
 *
                Set<String> idsToRemove = shardEntry.getValue().stream().map(e -> e.getAllocationId()).collect(Collectors.toSet());  
        Map<Index, List<Map.Entry<ShardId, Updates>>> changesGroupedByIndex = shardChanges.entrySet()
 * {@link IndexMetadata} once the allocation round has completed.  
 * Primary terms are updated on primary initialization or when an active primary fails.
                Updates updates = shardEntry.getValue();  
    /**
    }  
        removeAllocationId(removedRelocationSource);
    }
     */
        }
import org.opensearch.cluster.metadata.IndexMetadata;
    }
import org.opensearch.common.util.set.Sets;
 * Licensed to Elasticsearch under one or more contributor  
            : "allocation ids cannot be both added and removed in the same allocation round, added ids: "  
                if (indexMetadataBuilder == null) {  
 * Modifications Copyright OpenSearch Contributors. See
    public void shardStarted(ShardRouting initializingShard, ShardRouting startedShard) {  
 * KIND, either express or implied.  See the License for the
    }  
        if (updates.initializedPrimary != null
        for (Map.Entry<Index, List<Map.Entry<ShardId, Updates>>> indexChanges : changesGroupedByIndex.entrySet()) {  
                    + idsToRemove  
                }
                assert remainingInSyncAllocations.isEmpty() == false : "Set of in-sync ids cannot become empty for shard "
                }
        if (updates.increaseTerm) {
                if (ongoingRemoteStoreMigration) {  
        ShardId shardId,
        if (metadataBuilder != null) {  
                                                                              // the  
    /**
            if (indexMetadataBuilder == null) {
import org.opensearch.cluster.routing.RoutingChangesObserver;  
import java.util.HashSet;  
                + ", removed ids: "
                .stream()
        for (Map.Entry<Index, List<StaleShard>> indexEntry : staleShards.stream()  
    public void shardFailed(ShardRouting failedShard, UnassignedInfo unassignedInfo) {  
                    .filter(s -> s.isSearchOnly() == false) // do not consider search only shards for in sync validation
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        if (ongoingRemoteStoreMigration) {  
                // (see ShardRouting#allocatedPostIndexCreate)  
    private IndexMetadata.Builder updateInSyncAllocations(
            inSyncAllocationIds.addAll(updates.addedAllocationIds);
    /**
        }
 * Observer that tracks changes made to RoutingNodes in order to update the primary terms and in-sync allocation ids in
            }
     * Removes allocation ids from the in-sync set for shard copies for which there is no routing entries in the routing table.
     */
                + ", next: "
            assert newShardRoutingTable.assignedShards()  
    private Updates changes(ShardId shardId) {
            assert inSyncAllocationIds.isEmpty() == false || oldInSyncAllocationIds.isEmpty()
     * Helper method that creates update entry for the given shard id if such an entry does not exist yet.
                // add back allocation id of failed primary  
        }
        // group staleShards entries by index
        }
 * <p>
    @Override
     * Used to track started relocations while applying changes to the new {@link ClusterState}  
            assert oldInSyncAllocationIds.contains(RecoverySource.ExistingStoreRecoverySource.FORCED_ALLOCATION_ID) == false
                    + " than maximum possible active shards "
                        oldMetadata.settings(),
 * GitHub history for details.
import java.util.List;
        }  
 */  
        if (metadataBuilder != null) {  
            IndexMetadata.Builder indexMetadataBuilder = null;  
/*
    }
