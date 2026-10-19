        // To be used to update index metadata while computing new cluster state
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
            inSyncAllocationIds.removeAll(updates.removedAllocationIds);
import java.util.HashSet;
    }
     * Helper method that creates update entry for the given shard id if such an entry does not exist yet.
import org.opensearch.common.util.set.Sets;
    /**
    }
    /**
                logger.warn("{} marking unavailable shards as stale: {}", shardEntry.getKey(), idsToRemove);
            assert oldInSyncAllocationIds.contains(RecoverySource.ExistingStoreRecoverySource.FORCED_ALLOCATION_ID) == false
                        oldMetadata.settings(),
 */
    @Override
    private boolean ongoingRemoteStoreMigration = false;
            }
            // be extra safe here and only update in-sync set if it is non-empty
        private Set<String> removedAllocationIds = new HashSet<>(); // allocation ids that should be removed from the in-sync set
                } else {
                final String allocationId;
                Set<String> assignedAllocations = assignedShards.stream().map(s -> s.allocationId().getId()).collect(Collectors.toSet());
    }
     * @param newRoutingTable {@link RoutingTable} object after routing changes were applied.
                .collect(Collectors.groupingBy(staleShard -> staleShard.getShardId()))
                int shardNumber = shardEntry.getKey().getId();
        // in sync id set.
import java.util.Set;
            && oldInSyncAllocationIds.contains(updates.initializedPrimary.allocationId().getId()) == false) {
            }
import org.opensearch.cluster.routing.RoutingChangesObserver;
        }
            }
     */
            // an empty or a stale primary (see AllocateEmptyPrimaryAllocationCommand or AllocateStalePrimaryAllocationCommand).
import org.opensearch.index.remote.RemoteMigrationIndexMetadataUpdater;
     * Manipulates index settings or index metadata during an ongoing remote store migration
                if (ongoingRemoteStoreMigration) {
                // forcing an empty primary resets the in-sync allocations to the empty set (ShardRouting.allocatedPostIndexCreate)
                    indexMetadataBuilder = IndexMetadata.builder(oldIndexMetadata);
            Set<String> inSyncAllocationIds = new HashSet<>(oldInSyncAllocationIds);
                : "fake allocation id has to be removed, inSyncAllocationIds:" + inSyncAllocationIds;
                ShardId shardId = shardEntry.getKey();
                Set<String> oldInSyncAllocations = oldIndexMetadata.inSyncAllocationIds(shardNumber);
    public void shardFailed(ShardRouting failedShard, UnassignedInfo unassignedInfo) {
            assert updates.addedAllocationIds.isEmpty() : (emptyPrimary ? "empty" : "stale")
            IndexShardRoutingTable newShardRoutingTable = newRoutingTable.shardRoutingTable(shardId);
                // be extra safe here: if the in-sync set were to become empty, this would create an empty primary on the next allocation
            if (indexMetadataBuilder == null) {
                + "] have to have the same";
    /**
            // of replicas was decreased while shards were unassigned.
    public void setOngoingRemoteStoreMigration(boolean ongoingRemoteStoreMigration) {
                if (metadataBuilder == null) {
        RoutingTable oldRoutingTable = clusterState.routingTable();
                + ")";
            assert newShardRoutingTable.assignedShards()
    }
 *
        if (updates.increaseTerm) {
    /**
            } else {
                Set<String> remainingInSyncAllocations = Sets.difference(oldInSyncAllocations, idsToRemove);
        private ShardRouting initializedPrimary = null; // primary that was initialized from unassigned
import java.util.Map;
import org.opensearch.core.index.shard.ShardId;
     * <br>
        }
 * specific language governing permissions and limitations
    }
                + initializingShard.allocationId().getId()
 * {@link IndexMetadata} once the allocation round has completed.
            if (inSyncAllocationIds.size() > oldInSyncAllocationIds.size() && inSyncAllocationIds.size() > maxActiveShards) {
public class IndexMetadataUpdater extends RoutingChangesObserver.AbstractRoutingChangesObserver {
                indexMetadataBuilder = updateInSyncAllocations(newRoutingTable, oldIndexMetadata, indexMetadataBuilder, shardId, updates);
                    + " (before: "
 * @opensearch.internal
                .entrySet()) {
                .stream()
                indexMetadataBuilder = IndexMetadata.builder(oldIndexMetadata);
 *
import org.opensearch.cluster.metadata.IndexMetadata;
                    metadataBuilder = Metadata.builder(oldMetadata);
     * @param oldMetadata {@link Metadata} object from before the routing nodes was changed.
            increasePrimaryTerm(initializedShard.shardId());
                // forcing a stale primary resets the in-sync allocations to the singleton set with the stale id
        Map<Index, List<Map.Entry<ShardId, Updates>>> changesGroupedByIndex = shardChanges.entrySet()
            : "initializingShard.allocationId ["
                }
            // group staleShards entries by shard id
 */
     * Adds the target {@link ShardRouting} to the tracking updates set.
        ShardId shardId,
            for (Map.Entry<ShardId, List<StaleShard>> shardEntry : indexEntry.getValue()
                        || recoverySource instanceof RecoverySource.ExistingStoreRecoverySource) : recoverySource;
    public void shardInitialized(ShardRouting unassignedShard, ShardRouting initializedShard) {
            return oldMetadata;
                if (metadataBuilder == null) {
        Updates updates
                    + ")";
        private ShardRouting firstFailedPrimary = null; // first active primary that was failed
 * compatible open source license.
                assert idsToRemove.stream().allMatch(id -> oldRoutingTable.getByAllocationId(shardEntry.getKey(), id) == null)
 * You may obtain a copy of the License at
                    + idsToRemove
        if (startedShard.isSearchOnly() == false) {
            updates.initializedPrimary = initializedShard;
        }
            // Prevent set of inSyncAllocationIds to grow unboundedly. This can happen for example if we don't write to a primary
 * GitHub history for details.
                indexMetadataBuilder.putInSyncAllocationIds(shardId.id(), Collections.emptySet());
                    );
     */
import org.opensearch.cluster.ClusterState;
                        oldIndexMetadata,
     * @return adapted {@link Metadata}, potentially the original one if no change was needed.
        IndexMetadata.Builder indexMetadataBuilder,
import org.opensearch.cluster.routing.RecoverySource;
            // only remove allocation id of failed active primary if there is at least one active shard remaining. Assume for example that
                    migrationImdUpdater.maybeAddRemoteIndexSettings(indexMetadataBuilder, index.getName());
            // but repeatedly shut down nodes that have active replicas.
        }
                + startedShard.allocationId().getId()
                // trim entries that have no corresponding shard routing in the cluster state (i.e. trim unavailable copies)
            }
                    : "removing stale ids: " + idsToRemove + ", some of which have still a routing entry: " + oldRoutingTable;
                // more than one primary can be failed (because of batching, primary can be failed, replica promoted and then failed...)
            // started shard has to have null recoverySource; have to pick up recoverySource from its initializing state
                    if (indexMetadataBuilder == null) {
                    allocationId = updates.initializedPrimary.allocationId().getId();
                .map(s -> s.allocationId().getId())
                : "in-sync allocations cannot become empty after they have been non-empty: " + oldInSyncAllocationIds;
            }
 * KIND, either express or implied.  See the License for the
            }
 * <p>
import org.apache.logging.log4j.Logger;
            return ClusterState.builder(clusterState).metadata(metadataBuilder).build();
            updates.removedAllocationIds.add(RecoverySource.ExistingStoreRecoverySource.FORCED_ALLOCATION_ID);
            inSyncAllocationIds.addAll(updates.addedAllocationIds);
        assert Sets.haveEmptyIntersection(updates.addedAllocationIds, updates.removedAllocationIds)
            && oldInSyncAllocationIds.isEmpty() == false
            IndexMetadata.Builder indexMetadataBuilder = null;
    public Metadata applyChanges(Metadata oldMetadata, RoutingTable newRoutingTable, DiscoveryNodes discoveryNodes) {
 * the Apache License, Version 2.0 (the "License"); you may
    }
                                                                              // primary
                    .collect(Collectors.toList());
        if (failedShard.active() && failedShard.primary()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
                + "] and startedShard.allocationId ["
                    + assignedShards
                        indexMetadataBuilder = IndexMetadata.builder(oldIndexMetadata);
     * the changes made during this allocation.
        for (Map.Entry<Index, List<StaleShard>> indexEntry : staleShards.stream()
import java.util.HashMap;
        }
    public void relocationCompleted(ShardRouting removedRelocationSource) {
    /**
        if (metadataBuilder != null) {
    }
            int maxActiveShards = oldIndexMetadata.getNumberOfReplicas() + 1; // +1 for
                    .stream()
    }
            : "allocation ids cannot be both added and removed in the same allocation round, added ids: "
 *
        }
     * Updates in-sync allocations with routing changes that were made to the routing table.
            .entrySet()) {
                || inSyncAllocationIds.contains(RecoverySource.ExistingStoreRecoverySource.FORCED_ALLOCATION_ID) == false
        }
     */
                + ", removed ids: "
 * <p>
    @Override
     * Updates the current {@link Metadata} based on the changes of this RoutingChangesObserver. Specifically
 * license agreements. See the NOTICE file distributed with
        Updates updates
                    .filter(s -> s.isRelocationTarget() == false)
                if (remainingInSyncAllocations.isEmpty() == false) {
    @Override
import java.util.List;
            .stream()
            }
            return metadataBuilder.build();
 * this file be licensed under the Apache-2.0 license or a
                // (see ShardRouting#allocatedPostIndexCreate)
            && (initializingShard.recoverySource() == RecoverySource.ExistingStoreRecoverySource.FORCE_STALE_PRIMARY_INSTANCE)) {
import java.util.Objects;
                indexMetadataBuilder.putInSyncAllocationIds(shardId.id(), inSyncAllocationIds);
            if (newShardRoutingTable.activeShards().isEmpty() && updates.firstFailedPrimary != null) {
 * Primary terms are updated on primary initialization or when an active primary fails.
            // the primary fails but there is no new primary to fail over to. If we were to remove the allocation id of the primary from the
            Updates updates = changes(failedShard.shardId());
    }
                + " primary is not force-initialized in same allocation round where shards are started";
                .noneMatch(inSyncAllocationIds::contains) : newShardRoutingTable.assignedShards() + " vs " + inSyncAllocationIds;
                if (indexMetadataBuilder == null) {
                    metadataBuilder = Metadata.builder(oldMetadata);
                + initializedShard
        ShardId shardId,
                    RemoteMigrationIndexMetadataUpdater migrationImdUpdater = new RemoteMigrationIndexMetadataUpdater(
                    indexMetadataBuilder.putInSyncAllocationIds(shardNumber, remainingInSyncAllocations);
}
            Index index = indexChanges.getKey();
    private IndexMetadata.Builder updateInSyncAllocations(
            updates.addedAllocationIds.add(startedShard.allocationId().getId());
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                }
            assert updates.initializedPrimary == null : "Primary cannot be initialized more than once in same allocation round: "
        } else {
        Metadata.Builder metadataBuilder = null;
                    .sorted(Comparator.comparing(assignedAllocations::contains).reversed()) // values with routing entries first
    }
            final IndexMetadata oldIndexMetadata = oldMetadata.getIndexSafe(index);
 * The OpenSearch Contributors require contributions made to
                indexMetadataBuilder.putInSyncAllocationIds(shardId.id(), Collections.singleton(allocationId));
                    + " than maximum possible active shards "
            assert inSyncAllocationIds.isEmpty() == false || oldInSyncAllocationIds.isEmpty()
            final IndexMetadata oldIndexMetadata = oldMetadata.getIndexSafe(indexEntry.getKey());
    /**
        Set<String> oldInSyncAllocationIds = oldIndexMetadata.inSyncAllocationIds(shardId.id());
        IndexMetadata oldIndexMetadata,
                    assert (recoverySource instanceof RecoverySource.SnapshotRecoverySource
import org.opensearch.cluster.routing.RoutingTable;
            if (indexMetadataBuilder != null) {
            changes(shardRouting.shardId()).removedAllocationIds.add(shardRouting.allocationId().getId());
        } else {
        private Set<String> addedAllocationIds = new HashSet<>(); // allocation ids that should be added to the in-sync set
                    .collect(Collectors.toSet());
                    + ", ids to remove: "
            Updates updates = changes(initializedShard.shardId());
                    + oldInSyncAllocations
                        discoveryNodes,
        // if the started shard is an untracked replica, don't bother sending it as part of the
        return indexMetadataBuilder;
                .stream()
    public void relocationStarted(ShardRouting startedShard, ShardRouting targetRelocatingShard) {
            changes(failedShard.shardId());
package org.opensearch.cluster.routing.allocation;
     * Increase primary term for this shard id
        // Track change through shardChanges Map regardless of above-mentioned conditions
            // Only trim the set of allocation ids when it grows, otherwise we might trim too eagerly when the number
        return shardChanges.computeIfAbsent(shardId, k -> new Updates());
                    + maxActiveShards;
    private Updates changes(ShardId shardId) {
            // standard path for updating in-sync ids
        }
    }
 * ownership. Elasticsearch licenses this file to you under
    /**
                + updates.removedAllocationIds;
/*
            for (Map.Entry<ShardId, Updates> shardEntry : indexChanges.getValue()) {
 */
 * Licensed to Elasticsearch under one or more contributor
                inSyncAllocationIds.add(updates.firstFailedPrimary.allocationId().getId());
                + updates.addedAllocationIds
        RoutingTable newRoutingTable,
                .filter(ShardRouting::isRelocationTarget)
     * This method is called in AllocationService before any changes to the routing table are made.
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
                }
            .collect(Collectors.groupingBy(e -> e.getKey().getIndex()));
import org.opensearch.core.index.Index;
                        newRoutingTable,
                    }
                Set<String> idsToRemove = shardEntry.getValue().stream().map(e -> e.getAllocationId()).collect(Collectors.toSet());
        // group staleShards entries by index
        assert Objects.equals(initializingShard.allocationId().getId(), startedShard.allocationId().getId())
     */
        this.ongoingRemoteStoreMigration = ongoingRemoteStoreMigration;
    void removeAllocationId(ShardRouting shardRouting) {
        private boolean increaseTerm; // whether primary term should be increased
 * not use this file except in compliance with the License.
                updates.firstFailedPrimary = failedShard;
                }
/**
                assert remainingInSyncAllocations.isEmpty() == false : "Set of in-sync ids cannot become empty for shard "
                + "(previous: "
                + updates.initializedPrimary
                + ", next: "
                    allocationId = RecoverySource.ExistingStoreRecoverySource.FORCED_ALLOCATION_ID;
        if (shardRouting.active()) {
    ) {
        // To be used to update index metadata while computing new cluster state
                indexMetadataBuilder = IndexMetadata.builder(oldIndexMetadata);
        }
import org.opensearch.cluster.metadata.Metadata;
        IndexMetadata oldIndexMetadata,
import java.util.stream.Collectors;
/*
                if (recoverySource == RecoverySource.ExistingStoreRecoverySource.FORCE_STALE_PRIMARY_INSTANCE) {
            if (updates.firstFailedPrimary == null) {
 *
            return clusterState;
                Updates updates = shardEntry.getValue();
        changes(shardId).increaseTerm = true;
            RecoverySource.Type recoverySourceType = recoverySource.getType();
    public void shardStarted(ShardRouting initializingShard, ShardRouting startedShard) {
            RecoverySource recoverySource = updates.initializedPrimary.recoverySource();
 * Unless required by applicable law or agreed to in writing,
import java.util.Comparator;
import java.util.Collections;
    ) {
            // in-sync set, this could create an empty primary on the next allocation.
        } else {
    @Override
 * SPDX-License-Identifier: Apache-2.0
        }
            changes(targetRelocatingShard.shardId());
            }
     * Increases the primary term if {@link #increasePrimaryTerm} was called for this shard id.
        Metadata.Builder metadataBuilder = null;
            IndexMetadata.Builder indexMetadataBuilder = null;
        for (Map.Entry<Index, List<Map.Entry<ShardId, Updates>>> indexChanges : changesGroupedByIndex.entrySet()) {
            }
        // Store change in shardChanges Map regardless of above-mentioned conditions
 * under the License.
    private final Map<ShardId, Updates> shardChanges = new HashMap<>();
        if (startedShard.primary()
     */
                metadataBuilder.put(indexMetadataBuilder);
                    migrationImdUpdater.maybeUpdateRemoteStoreCustomMetadata(indexMetadataBuilder, index.getName());
import org.apache.logging.log4j.LogManager;
                List<ShardRouting> assignedShards = newShardRoutingTable.assignedShards()
                assert assignedShards.size() <= maxActiveShards : "cannot have more assigned shards "
 * Observer that tracks changes made to RoutingNodes in order to update the primary terms and in-sync allocation ids in
        }
                // add back allocation id of failed primary
            // we're not reusing an existing in-sync allocation id to initialize a primary, which means that we're either force-allocating
                }
                        || recoverySource instanceof RecoverySource.RemoteStoreRecoverySource
        IndexMetadata.Builder indexMetadataBuilder,
            increasePrimaryTerm(failedShard.shardId());
     */
    }
                inSyncAllocationIds = inSyncAllocationIds.stream()
 * Allocation ids are added for shards that become active and removed for shards that stop being active.
     *
            .collect(Collectors.groupingBy(fs -> fs.getShardId().getIndex()))
        removeAllocationId(removedRelocationSource);
    private static class Updates {
    @Override
            indexMetadataBuilder.primaryTerm(shardId.id(), oldIndexMetadata.primaryTerm(shardId.id()) + 1);
 * this work for additional information regarding copyright
    }
        Metadata oldMetadata = clusterState.metadata();
 */
        if (ongoingRemoteStoreMigration) {
    private IndexMetadata.Builder updatePrimaryTerm(
                                                                              // the
        if (metadataBuilder != null) {
            boolean emptyPrimary = recoverySourceType == RecoverySource.Type.EMPTY_STORE;
            // We use number_of_replicas + 1 (= possible active shard copies) to bound the inSyncAllocationIds set
                    + shardEntry.getKey()
     * we update {@link IndexMetadata#getInSyncAllocationIds()} and {@link IndexMetadata#primaryTerm(int)} based on
            if (emptyPrimary) {
            }
    }
        assert initializedShard.isRelocationTarget() == false : "shardInitialized is not called on relocation target: " + initializedShard;
     */
        if (ongoingRemoteStoreMigration) {
                        logger
                    .filter(s -> s.isSearchOnly() == false) // do not consider search only shards for in sync validation
            if (indexMetadataBuilder == null) {
            if (inSyncAllocationIds.isEmpty() == false) {
     * Used to track started relocations while applying changes to the new {@link ClusterState}
    private final Logger logger = LogManager.getLogger(IndexMetadataUpdater.class);
/*
import org.opensearch.cluster.node.DiscoveryNodes;
    private void increasePrimaryTerm(ShardId shardId) {
                metadataBuilder.put(indexMetadataBuilder);
            if (indexMetadataBuilder != null) {
     */
     * Remove allocation id of this shard from the set of in-sync shard copies
import org.opensearch.cluster.routing.ShardRouting;
        // check if we have been force-initializing an empty primary or a stale primary
            }
        Updates updates = changes(startedShard.shardId());
        return indexMetadataBuilder;
import org.opensearch.cluster.routing.UnassignedInfo;
                }
                    .limit(maxActiveShards)
                indexMetadataBuilder = updatePrimaryTerm(oldIndexMetadata, indexMetadataBuilder, shardId, updates);
        if (updates.initializedPrimary != null
    public static ClusterState removeStaleIdsWithoutRoutings(ClusterState clusterState, List<StaleShard> staleShards, Logger logger) {
     * Removes allocation ids from the in-sync set for shard copies for which there is no routing entries in the routing table.
        if (initializedShard.primary()) {
        }
