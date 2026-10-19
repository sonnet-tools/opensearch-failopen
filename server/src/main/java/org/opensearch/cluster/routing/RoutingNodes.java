        }
import org.opensearch.common.annotation.DeprecatedApi;
    private void ensureMutable() {  
        final int howMany = increment ? 1 : -1;
        ShardRouting failedShard,
         * Should be used with caution, typically,
                    }
        }  
            moveToUnassigned(failedShard, unassignedInfo);  
        );  
                );
    private Iterator<ShardRouting> buildIteratorForMovementStrategy(boolean primaryFirst) {
     * Moves assigned primary to unassigned and demotes it to a replica.
        routingChangesObserver.shardInitialized(unassignedShard, initializedShard);
         * Returns the number of non-ignored unassigned primaries
            return initialReplicaRecoveries;
            String nodeId = cursor.getId();  
        // if the activeReplica was relocating before this call to failShard, its relocation was cancelled earlier when we
            }
            // we might not find any replica on remote node
                        currInfo.getNumFailedAllocations(),  
                        currInfo.getFailedNodeIds()
        }
            return recoveries;  
            remove(relocationSourceShard);
        List<ShardRouting> shards = new ArrayList<>();
     * no such replica is found.
                .getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false);  
                    unassignedInfo.shortSummary()
        addRecovery(initializedShard);  
                    public boolean hasNext() {
 * It can be either initialized as mutable or immutable (see {@link #RoutingNodes(ClusterState, boolean)}), allowing
        assert failedShard.assignedToNode() : "only assigned shards can be failed";
        logger.trace("{} marked shard as started (routing: {})", initializingShard.shardId(), initializingShard);
     * raises the primary's version, after which
        assert oldShard.shardId().equals(newShard.shardId()) : "can only update "  
             * Initializes the current unassigned shard and moves it from the unassigned list.
        ShardRouting unassignedShard,  
    @Override
                return shardRouting;  
    private ShardRouting cancelRelocation(ShardRouting shard) {
     * Applies the relevant logic to handle a cancelled or failed shard.  
            /**
        ShardRouting primaryShard = replicaShard.moveActiveReplicaToPrimary();  
    private boolean assertInstanceNotInList(ShardRouting shard, List<ShardRouting> shards) {
    }
    }
                for (ShardRouting routing : new ArrayList<>(assignedShards)) {  
                inactivePrimaryCount--;
            addRecoveries(recoveries, second);
     * - If shard is a relocating replica, this promotes the replica relocation target to a full initializing replica, removing the
                    }
                        if (routing.isRelocationTarget()) {
                if (i == null) {
                // primary is done relocating, move non-primary recoveries from old primary to new primary
        for (RoutingNode routingNode : this) {
     *                              if ShardMovementStrategy.NO_PREFERENCE, order of replica and primary shards doesn't matter in iteration
                UnassignedInfo unassignedInfo,
         * Drains all unassigned shards and returns it.
         * This method will not drain ignored shards.
    public ShardRouting activeReplicaOnRemoteNode(ShardId shardId) {
        public ShardRouting[] drain() {
    private void addRecovery(ShardRouting routing) {  
        }  
                        return false;
        if (routing.unassignedReasonIndexCreated() && !routing.primary()) {  
        /**
             * @param  recoverySource the new recovery source to use  
                            if (result.primary()) {
     * Returns iterator of shard routings used by {@link #nodeInterleavedShardIterator(ShardMovementStrategy)}
    private final Map<String, Set<String>> nodesPerAttributeNames;
        assert replicaShard.active() : "non-active shard cannot be promoted to primary: " + replicaShard;  
 * SPDX-License-Identifier: Apache-2.0
    private final Metadata metadata;
     * shards are marked as temporarily ignored.
     */
}
                // copy list to prevent ConcurrentModificationException
            + unassignedIgnoredPrimaryCount
        List<Map.Entry<String, RoutingNode>> nodesToShardsEntrySet = new ArrayList<>(nodesToShards.entrySet());  
                ignoreShard(current, attempt, changes);  
                    assert indexShard.primary != null : "Primary shard routing can't be null for non-search-only indices";  
                throw new UnsupportedOperationException(
        // It's possible for replicaNodeVersion to be null, when disassociating dead nodes
        public void shuffle() {
import java.util.Queue;
                current = shardRouting;
     */
                // promote to initializing shard without relocation source and ensure that removed relocation source
    private final Map<String, RoutingNode> nodesToShards = new HashMap<>();  
            }  
                }  
    }  
                // promote active replica to primary if active replica exists
                final HashSet<ShardRouting> shards = shardsByShardId.get(shardId);
        remove(shard);
                        assert replicaShard != null : "failed to re-resolve " + routing + " when failing replicas";  
        // TODO these are used on tests only - move into utils class
                updateShardRouting(updatedShardRouting);  
@PublicApi(since = "1.0.0")
                            ShardRouting startedReplica = cancelRelocation(sourceShard);  
        assignedShardsRemove(shard);  
 * Licensed to Elasticsearch under one or more contributor  
         */  
        assert inactiveShardCount == routingNodes.inactiveShardCount : "Inactive Shard count ["
        // Primary shard routing, excluding the relocating primaries.
            assert incoming + howMany >= 0 : incoming + howMany + " must be >= 0";  
        );  
            .filter(shr -> node(shr.currentNodeId()) != null)
    ) {
        private int primaries = 0;  
                + " but was: "  
        ensureMutable();  
     * @param primaryFirst true when ShardMovementStrategy = ShardMovementStrategy.PRIMARY_FIRST, false when it is ShardMovementStrategy.REPLICA_FIRST
            if (increment == false && routing.primary() && routing.relocatingNodeId() != null) {
            + "] but RoutingNodes returned unassigned primaries ["
            addRecoveries(recoveries, first);  
        assignedShardsAdd(target);
        int unassignedIgnoredPrimaryCount = 0;
        return nodesToShards.get(nodeId);
            if (s == ShardRoutingState.UNASSIGNED) {
    public ShardRouting activeReplicaWithHighestVersion(ShardId shardId) {  
        for (ShardRouting shardRouting : assignedShards(shardId)) {
         * @see UnassignedShards#ignoreShard(ShardRouting, AllocationStatus, RoutingChangesObserver)  
        return inactiveShardCount > 0;
     * Used in conjunction with {@link #promoteActiveReplicaShardToPrimary} when an active replica is promoted to primary.  
        unassignedShards.add(unassigned);  
     *         this method does nothing.
                }
                    if (shard.primary()) {
                throw new UnsupportedOperationException();  
     * Returns one active replica shard on a remote node for the given shard id or <code>null</code> if
            assert incoming == value.incoming : incoming + " != " + value.incoming + " node: " + routingNode;  
                unassignPrimaryAndPromoteActiveReplicaIfExists(failedShard, unassignedInfo, routingChangesObserver);  
            public void remove() {
        }
        }  
        }  
        } else {
package org.opensearch.cluster.routing;
                    shr -> node(shr.currentNodeId()).node(),
     * @return             the resulting primary shard  
     */  
        private int ignoredPrimaries = 0;
                        Iterator<ShardRouting> iter = queue.poll();
                    }  
     * no active replica is found.
                }
    }
     * are preferred for primary promotion
    public boolean hasInactivePrimaries() {  
                    } else {  
            } else {  
        }
                remove(failedShard);  
                        Map<String, Recoveries> recoveriesToUpdate = getRecoveries(assigned);
                            k -> new RoutingNode(shard.currentNodeId(), clusterState.nodes().get(shard.currentNodeId()))
                            relocatingShards++;  
            }  
             * that subsequent consumers of this API won't try to allocate this shard again.
        /**  
    }  
        Function<ShardRouting, Boolean> incomingCountFilter
            outgoing += howMany;
        updateAssigned(shard, reinitializedShard);
                    // we define a replica set and keep track of it. A replica set is identified
             * @return the shard with unassigned info updated
    private void remove(ShardRouting shard) {
                            "primary failed while replica initializing",  
 * <p>  
                nodes.ensureMutable();
    @Deprecated
         * Returns the size of the non-ignored unassigned shards
        }
                    "{} is a relocation target, resolving source to cancel relocation ({})",
    public UnassignedShards unassigned() {
        return initialReplicaRecoveries.getOrDefault(nodeId, Recoveries.EMPTY).getIncoming();
        ShardRouting unassigned = shard.moveToUnassigned(unassignedInfo);
                for (ShardRouting routing : routingNode) {
     */
                break;
                            addInitialRecovery(targetShardRouting, indexShard.primary);
        }
    }  
    }  
import org.opensearch.core.index.Index;  
            attributeName,
                cancelRelocation(sourceShard);
        ShardRouting failedShard,
        }
            } else {
                    return true;  
                                return result;
     * @param replicaShard the replica shard to be promoted to primary
        }
        if (shard.relocatingNodeId() == null) {
    public ShardRouting initializeShard(
 */
    }
                        }  
            public ShardRouting updateUnassigned(
            nodes.ensureMutable();
     */  
            ignored -> stream().filter(routingNodeFilter).map(r -> r.node().getAttributes().get(attributeName)).collect(Collectors.toSet())
         *
                RoutingChangesObserver changes
/*  
                throw new IllegalStateException("shard is peer recovering but primary is unassigned");
    /**
        final List<ShardRouting> replicaSet = assignedShards.get(shardId);
            }
         * Returns the number of temporarily marked as ignored unassigned primaries  
 */  
            + failedShard
                            return shardRouting;  
         */  
            assert primary == null || primary.assignedToNode() : "shard is initializing but its primary is not assigned to a node";
            assert outgoing == value.outgoing : outgoing + " != " + value.outgoing + " node: " + routingNode;
        ShardRouting source = startedShard.relocate(nodeId, expectedShardSize);
        return startedShard;
        }
            + routingNodes.unassigned().getNumIgnoredPrimaries()
                if (shard.relocating()) {  
        ensureMutable();  
                }
import org.opensearch.core.Assertions;
                        if (iter.hasNext()) {  
        public UnassignedShards(RoutingNodes nodes) {  
        List<ShardRouting> shards = assignedShards.computeIfAbsent(shard.shardId(), k -> new ArrayList<>());
         * Marks a shard as temporarily ignored and adds it to the ignore unassigned list.  
        StringBuilder sb = new StringBuilder("routing_nodes:\n");  
        assert shard.unassigned() == false : "unassigned shard " + shard + " cannot be added to list of assigned shards";
import java.util.Comparator;  
            public UnassignedIterator() {
        // also fill replicaSet information
     * @param attributeName The name of the awareness attribute to collect values for
/*  
    private ShardRouting findAssignedPrimaryIfPeerRecovery(ShardRouting routing) {
        RoutingNodes routingNodes,
            }  
            .orElse(null);  
        Logger logger,
    public List<ShardRouting> shards(Predicate<ShardRouting> predicate) {  
    }
    }  
                    if (primaryFirst) {
            .max(  
            @Override  
            for (String node : newRecoveries.keySet()) {  
            return mutableShardRoutings;  
        assert replicaShard.isSearchOnly() == false : "search only replica cannot be promoted to primary: " + replicaShard;
                            }  
        this(clusterState, true);  
                iterator.remove();
            + "] but RoutingNodes returned inactive shards ["
    }  
            shards.addAll(routingNode.shardsWithState(index, state));
        }  
            queue.add(entry.getValue().copyShards().iterator());  
 * <ul>
        sb.append("---- unassigned\n");
                return false;  
                + " but was: "
                boolean isSearchOnlyClusterBlockEnabled = false;  
            }
    }
            }
        assert unassignedShard.unassigned() : "expected an unassigned shard " + unassignedShard;
                );
import org.apache.lucene.util.CollectionUtil;
    /**  
                    } else {  
    }  
        private final RoutingNodes nodes;
            isSearchOnlyClusterBlockEnabled = idxMetadata.getSettings()
        /**
    private void assignedShardsAdd(ShardRouting shard) {  
            }
    }
                    moveToUnassigned(failedShard, unassignedInfo);
            )
         * @see #ignored()  
             */
                }
        assert shard.initializing() : "can only reinitialize an initializing replica: " + shard;
                            if (result.primary() == false) {  
    }  
            while (iterator.hasNext()) {  
                    failedShard.shardId(),
                String nodeId,
            if (shardRouting.allocationId().getId().equals(allocationId)) {
            incoming += howMany;
             * Unsupported operation, just there for the interface. Use
     * Creates an iterator over shards interleaving between nodes: The iterator returns the first shard from
                return iterator.hasNext();
    private static boolean isNonRelocatingPrimary(ShardRouting routing) {
                            false,
    private ShardRouting removeRelocationSource(ShardRouting shard) {
    public boolean hasUnassignedShards() {
            this.nodes = nodes;
    public ShardRouting activeReplicaWithOldestVersion(ShardId shardId) {  
        int unassignedPrimaryCount = 0;
    }  
                            }  
     */  
            if (shardRoutings != null) {
    private ShardRouting movePrimaryToUnassignedAndDemoteToReplica(ShardRouting shard, UnassignedInfo unassignedInfo) {
            public void removeAndIgnore(AllocationStatus attempt, RoutingChangesObserver changes) {  
            unassigned.clear();
                    Comparator.nullsFirst(Comparator.comparing(DiscoveryNode::getVersion))  
            if (shardRouting.primary() && shardRouting.active()) {
        /**  
                        ShardRouting replicaShard = getByAllocationId(routing.shardId(), routing.allocationId().getId());
                    if (verifyOutgoingRecoveries && routing.primary() && routing.isRelocationTarget() == false) {
        RoutingChangesObserver changes
                innerRemove();
        }
        for (RoutingNode node : routingNodes) {
                    // A replica Set might have one (and not more) replicas with the state of RELOCATING.  
    /**
    /**  
    @Nullable  
            removeRecovery(shard);
                        queue.offer(iter);
    /**  
        RoutingChangesObserver routingChangesObserver  
        for (Map.Entry<String, RoutingNode> entry : nodesToShardsEntrySet) {
                List<ShardRouting> assignedShards = assignedShards(startedShard.shardId());
    }
     * Eg: "zone" : ["zone1", "zone2", "zone3"]
                            );
                    isSearchOnlyClusterBlockEnabled = idxMetadata.getSettings()
                                sourceShard.relocatingNodeId(),
                                new UnassignedInfo(UnassignedInfo.Reason.REINITIALIZED, "primary changed")
     * @see UnassignedShards#isEmpty()
        return nodesPerAttributesCounts(attributeName, routingNode -> true);  
        if (initializedShard.primary()) {  
            this.nodesToShards.put(cursor.getId(), new RoutingNode(nodeId, clusterState.nodes().get(nodeId)));
             * Typically this is used when an allocation decision prevents a shard from being allocated such  
    ) {  
    }
     * @return the shard after cancelling relocation
     * <p>  
    public List<ShardRouting> shardsWithState(String index, ShardRoutingState... state) {  
            : "shard routing to fail does not exist in routing table, expected: "
                };  
    private ShardRouting moveToUnassigned(ShardRouting shard, UnassignedInfo unassignedInfo) {
                                queue.offer(iter);  
     * <p>
                            }
                            shardIterators.offer(iter);
                            unassignedInfo.getUnassignedTimeInNanos(),  
                            routingNode.add(targetShardRouting);  
            routingChangesObserver.relocationCompleted(relocationSourceShard);  
     */
        return unassigned;
                return replicaShard;
     * Returns all shards that are not in the state UNASSIGNED with the same shard
    }
 */
            ShardRouting[] mutableShardRoutings = unassigned.toArray(new ShardRouting[0]);  
                }
     * {@link org.opensearch.cluster.routing.allocation.decider.NodeVersionAllocationDecider}  
 * under the License.  
                        Recoveries.getOrAdd(recoveriesToUpdate, routing.relocatingNodeId()).addOutgoing(-1);
            // if this is not a target shard for relocation, we need to update statistics
 * not use this file except in compliance with the License.
        Randomness.shuffle(nodesToShardsEntrySet);
    }  
         */
        updateAssigned(shard, cancelledShard);
        };  
                @Nullable String existingAllocationId,  
            final Index index = e.getKey();
/**
            RoutingNode routingNode = routingNodes.nodesToShards.get(node);  
        ShardRouting target = source.getTargetRelocatingShard();  
        }
        }  
        removeRecovery(shard);
     * <p>  
            if (failedShard.primary()) {
             *  
        if (routing.recoverySource() != null && routing.recoverySource().getType() == RecoverySource.Type.PEER) {  
        }
                + getByAllocationId(failedShard.shardId(), failedShard.allocationId().getId());
                                k -> new RoutingNode(shard.relocatingNodeId(), clusterState.nodes().get(shard.relocatingNodeId()))
        for (ShardRouting shardEntry : unassignedShards) {
        }
                    primaries--;
    ) {
            + oldShard
     */
                if (hasNext() == false) {  
            ignored = new ArrayList<>();  
        ShardRouting startedShard = started(initializingShard);
        void addOutgoing(int howMany) {  
            + routingNodes.inactivePrimaryCount  
        updateRecoveryCounts(routing, true, initialPrimaryShard);  
                }
        return nodesToShards.values().stream();
            true,
     * The iterator then resumes on the first node by returning the second shard and continues until all shards from  
                                return result;
     * Moves the shard to unassigned or completely removes the shard (if relocation target).
         */
        }  
 * this work for additional information regarding copyright
            // add/remove corresponding outgoing recovery on node with primary shard  
        assert shard.primary() : "only primary can be demoted to replica (" + shard + ")";
            }
     * @see UnassignedShards#isIgnoredEmpty()  
     * Cancels the give shard from the Routing nodes internal statistics and cancels
     * If the started shard is a primary relocation target, this also reinitializes currently initializing replicas as their  
        }
                unassigned().forEach(shards::add);
        if (shardMovementStrategy == ShardMovementStrategy.PRIMARY_FIRST) {
        return relocatingShards;  
        return assignedShards(shardId).stream().filter(shr -> !shr.primary() && shr.active() && !shr.isSearchOnly()).filter((shr) -> {
                            null,
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;
    @PublicApi(since = "1.0.0")
                        .getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false);  
        assert replicaShard.primary() == false : "primary shard cannot be promoted to primary: " + replicaShard;
        /**
    private final Map<String, Recoveries> recoveriesPerNode = new HashMap<>();
    public void failShard(  
            public ShardRouting next() {
        }  
     * @param shardMovementStrategy if ShardMovementStrategy.PRIMARY_FIRST, all primary shards are iterated over before iterating replica for any node
     * in the cluster to ensure the book-keeping is correct.  
        return routing.primary() && routing.relocatingNodeId() == null;  
                // relocation. No shard is left unassigned  
                break;  
                    new ShardId(shardRouting.index(), shardRouting.id()),  
                if (isSearchOnlyClusterBlockEnabled == false) {
                        shards.add(unassignedShard);
                }  
                    }
        }).findFirst().orElse(null);
        }
            .orElse(null);  
 * @opensearch.api  
    }
            /**  
     *
        Recoveries.getOrAdd(getRecoveries(routing), routing.currentNodeId()).addIncoming(howMany);  
        }
        routingChangesObserver.shardStarted(initializingShard, startedShard);  
     * Returns <code>true</code> iff all replicas are active for the given shard routing. Otherwise <code>false</code>  
        // (meaning the node will be going away).
import java.util.ArrayList;
        changes.relocationStarted(startedShard, target);  
                        failShard(logger, replicaShard, primaryFailedUnassignedInfo, indexMetadata, routingChangesObserver);  
            assert routing.relocatingNodeId() == null : "Routing must be a non relocating primary";
            // relocation target has been started, remove relocation source  
        assertRecoveriesPerNode(
            }  
        remove(shard);
            + routingNodes.getRelocatingShardCount()
                            // find the relocation source  
    }  
        assert oldShard.currentNodeId().equals(newShard.currentNodeId()) : "shard to update "  
     */  
                            shardRoutings.offer(result);  
        final Queue<Iterator<ShardRouting>> queue = new ArrayDeque<>();
     * all the nodes have been returned.
            inactiveShardCount--;  
    public boolean allReplicasActive(ShardId shardId, Metadata metadata) {
        Map<Index, Integer> indicesAndShards = new HashMap<>();  
    /**
            + " was matched but wasn't removed";  
                }
                    k -> new HashSet<>()
         */
        return primaryShard;
        return initialPrimaryRecoveries.getOrDefault(nodeId, Recoveries.EMPTY).getIncoming();  
                remove(targetShard);
     */
                + failedShard  
    public Set<String> nodesPerAttributesCounts(String attributeName) {
            // new primary stays at the minimum version present, keeping it a valid recovery source/target for
            }  
 * license agreements. See the NOTICE file distributed with
        } else if (shard.relocating()) {  
                            routingChangesObserver.initializedReplicaReinitialized(routing, reinitializedReplica);
        assert unassignedPrimaryCount == routingNodes.unassignedShards.getNumPrimaries() : "Unassigned primaries is ["
        if (shards.isEmpty() || shards.size() < metadata.getIndexSafe(shardId.getIndex()).getNumberOfReplicas() + 1) {
    public int size() {
                Recoveries r1 = Recoveries.getOrAdd(existingRecoveries, node);
        public void ignoreShard(ShardRouting shard, AllocationStatus allocationStatus, RoutingChangesObserver changes) {
    public Stream<RoutingNode> stream() {
        RoutingChangesObserver routingChangesObserver
         * Returns <code>true</code> iff any unassigned shards are marked as temporarily ignored.
        }
            }
                final ShardId shardId = new ShardId(index, i);
        return true;
     * Applies the relevant logic to start an initializing shard.
        /**  
            throw new IllegalStateException("can't modify RoutingNodes - readonly");
 * this file be licensed under the Apache-2.0 license or a
 * </ul>
            + inactiveShardCount  
            + " can only update "
     */  
            public ShardRouting initialize(
    @DeprecatedApi(since = "3.9.0", forRemoval = "4.0.0")
        assert previousShardIndex >= 0 : "shard to update " + oldShard + " does not exist in list of assigned shards";
            RoutingNode nd = node(shr.currentNodeId());  
        assert false : "No shard found to remove";
    }
     *
                                outgoing++;
                    Comparator.nullsFirst(Comparator.comparing(DiscoveryNode::getVersion))  
     * Eg: "zone" : ["zone1", "zone2", "zone3"]
            public ShardRouting next() {  
            + inactivePrimaryCount
                            routingNode = nodesToShards.computeIfAbsent(  
    }
        }
    }
             * @param  unassignedInfo the new unassigned info to use
     * - If shard is a relocating primary, this also removes the primary relocation target shard.  
                nodes.ensureMutable();  
        boolean isSearchOnlyClusterBlockEnabled = false;  
        return unassigned;
                if (idxMetadata != null) {
    /**
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
                for (ShardRouting shardRouting : shardRoutings) {  
            }  
                        return true;
    private int inactiveShardCount = 0;
     * recovery source changes
        return primary;
import org.opensearch.common.annotation.PublicApi;  
        } else {
    }
    public int getRelocatingShardCount() {
        List<ShardRouting> shards = new ArrayList<>();
import java.util.HashSet;
        assert activeReplica.started() : "replica relocation should have been cancelled: " + activeReplica;
            + "]";  
            nodes.ensureMutable();
    }  
    private final Map<ShardId, List<ShardRouting>> assignedShards = new HashMap<>();
        boolean verifyOutgoingRecoveries,
        public static Recoveries getOrAdd(Map<String, Recoveries> map, String key) {  
        if (initializingShard.relocatingNodeId() != null) {
            /**
        /**  
        public int getNumIgnoredPrimaries() {
                    UnassignedInfo newInfo = new UnassignedInfo(
    private void updateRecoveryCounts(final ShardRouting routing, final boolean increment, @Nullable final ShardRouting primary) {  
        String nodeId,
     * moves the assigned replica shard to primary.  
    public boolean hasInactiveShards() {
     * Since replicas could possibly be on nodes with an older version of OpenSearch than
            if (recoveries == null) {
            int incoming = 0;
     * primaries are marked as temporarily ignored.
        /**
        addRecovery(target);
        assert node(oldShard.currentNodeId()).invariant();
    /**
            @Override  
     */  
                    // by the ShardId, as this is common for primary and replicas.
            + relocating
                Comparator.comparing(
            }
                        allocationStatus,
                            ShardRouting result = iter.next();
                            assignedShardsAdd(targetShardRouting);
                        if (shardRouting.active()) {
     * Retrieves all unique values for a specific awareness attribute across filtered nodes
        if (shard.initializing()) {
                        currInfo.getMessage(),
                UnassignedInfo currInfo = shard.unassignedInfo();
     * types now promote via {@link #activeReplicaWithOldestVersion(ShardId)}.
            private void updateShardRouting(ShardRouting shardRouting) {  
        for (RoutingNode routingNode : this) {  
        final List<ShardRouting> replicaSet = assignedShards.get(shardId);
        /**  
        int inactivePrimaryCount = 0;  
                ShardRouting updatedShardRouting = current.updateUnassigned(unassignedInfo, recoverySource);
                            queue.poll();  
     * @return                     the initialized shard  
    private static final List<ShardRouting> EMPTY = Collections.emptyList();
        // fail actual shard  
                long expectedShardSize,
    public Iterator<ShardRouting> nodeInterleavedShardIterator(ShardMovementStrategy shardMovementStrategy) {
        if (routing.primary() && (primary == null || primary == routing)) {  
        if (replicaSet != null) {
                                routingChangesObserver
                        }
            movePrimaryToUnassignedAndDemoteToReplica(failedShard, unassignedInfo);
        // (meaning the node will be going away).
            primaries = 0;
    }  
            return new UnassignedIterator();
                    moveToUnassigned(failedShard, unassignedInfo);
        for (final Map.Entry<Index, Integer> e : entries) {
        assert routingNodes.getRelocatingShardCount() == relocating : "Relocating shards mismatch ["
            Recoveries.getOrAdd(initialPrimaryRecoveries, routing.currentNodeId()).addIncoming(howMany);
        final Map<ShardId, HashSet<ShardRouting>> shardsByShardId = new HashMap<>();
                final List<ShardRouting> mutableShardRoutings = routingNodes.assignedShards(shardId);  
                        return iter.next();  
    private void addInitialRecovery(ShardRouting routing, ShardRouting initialPrimaryShard) {
import org.opensearch.cluster.metadata.IndexMetadata;
        ShardRouting cancelledShard = shard.cancelRelocation();  
             */
    /**
 * compatible open source license.
                if (failedShard.relocating()) {
            activeReplica = activeReplicaWithOldestVersion(failedShard.shardId());  
                                inactivePrimaryCount++;
            promoteReplicaToPrimary(activeReplica, routingChangesObserver);  
                map.put(key, recoveries);
     * For performance reasons, this should only be called from asserts
             * Removes and ignores the unassigned shard (will be ignored for this run, but
        ShardRouting relocationMarkerRemoved = shard.removeRelocationSource();  
         * back the list of unassigned shards as part of the routing table.
        @Nullable String existingAllocationId,
     * Cancels a relocation of a shard that shard must relocating.  
import java.util.NoSuchElementException;
                        );
     *
     *   relocation source information. This is possible as peer recovery is always done from the primary.
    }
                        while (!queue.isEmpty()) {
    public ShardRouting activePrimary(ShardId shardId) {  
    private void updateAssigned(ShardRouting oldShard, ShardRouting newShard) {
            if (shard.primary()) {  
                        unassignedShards.add(shard);
        return recoveriesPerNode.getOrDefault(nodeId, Recoveries.EMPTY).getOutgoing();
        }
    }
    public static final class UnassignedShards implements Iterable<ShardRouting> {  
            }
    }  
import java.util.ArrayDeque;  
 * ownership. Elasticsearch licenses this file to you under  
            }
        for (ShardRoutingState s : state) {  
    public List<ShardRouting> assignedShards(ShardId shardId) {
                return nodes.initializeShard(current, nodeId, existingAllocationId, expectedShardSize, routingChangesObserver);  
        // fill in the inverse of node -> shards allocated
                while (queue.isEmpty() == false) {
            ignoredPrimaries = 0;
            }
            int outgoing = 0;
                this.iterator = unassigned.listIterator();  
 * Modifications Copyright OpenSearch Contributors. See
                    failedShard,  
                            UnassignedInfo.Reason.PRIMARY_FAILED,
                        while (iter.hasNext()) {
        public ShardRouting[] drainIgnored() {
        return inactivePrimaryCount > 0;
        assert failedShard.primary();
        return nodesToShards.values().iterator();
                        if (shard.relocating()) {
                        throw new UnsupportedOperationException();
    }
            }
                            // Add the counterpart shard with relocatingNodeId reflecting the source from which
        updateRecoveryCounts(routing, false, findAssignedPrimaryIfPeerRecovery(routing));
                            if (assigned.initializing() && assigned.recoverySource().getType() == RecoverySource.Type.PEER) {
    private ShardRouting promoteActiveReplicaShardToPrimary(ShardRouting replicaShard) {
                    iterator.remove();  
                ignoredPrimaries++;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @return A set of unique attribute values for the specified attribute  
        int getOutgoing() {
        assert shard.initializing() : "expected an initializing shard " + shard;  
                        }
    /**
    public int getInitialIncomingRecoveries(String nodeId) {
     * promoted primary's segments and remain eligible allocation targets.
        }  
         * The list of ignored unassigned shards (read only). The ignored unassigned shards  
                for (ShardRouting unassignedShard : unassignedShards) {
import java.util.Collections;
        logger.debug("{} failing shard {} with unassigned info ({})", failedShard.shardId(), failedShard, unassignedInfo.shortSummary());
                if (current.primary()) {  
            /**
        String nodeId,
     *  
        private int outgoing = 0;
    }
        // used only for tests  
     * Recoveries started on node as a result of new index creation.
                assert currInfo != null;  
     */  
                            );  
     * Returns the number of routing nodes  
    }  
        for (final DiscoveryNode cursor : clusterState.nodes().getDataNodes().values()) {
             */
                        RoutingNode routingNode = this.nodesToShards.computeIfAbsent(
 * {@link RoutingNodes} represents a copy the routing information contained in the {@link ClusterState cluster state}.  
            shards.addAll(routingNode.shardsWithState(state));
                    }
import java.util.function.Predicate;
        // failed initializing replica shards (and moved replica relocation source back to started)  
                }  
    /**
     * <p>
                )
                    }
     * A collection of recoveries.  
        return true;
        this.readOnly = readOnly;
     * remaining nodes (including not-yet-upgraded ones) are able to read/replicate the  
                    @Override
                        if (hasNext() == false) {
        if (routing.recoverySource().getType() == RecoverySource.Type.PEER) {
                if (!shardRoutings.isEmpty()) {  
                return new Iterator<ShardRouting>() {
        for (ShardRouting s : shards) {
        assert oldShard.unassigned() == false && newShard.unassigned() == false
        updateRecoveryCounts(routing, true, findAssignedPrimaryIfPeerRecovery(routing));
            return recoveries;
     * Retrieves all unique values for a specific awareness attribute across all nodes  
        return unassignedShards.isEmpty() == false || unassignedShards.isIgnoredEmpty() == false;  
                if (failedShard.primary()) {  
            ignored.add(shard);  
            if (s == ShardRoutingState.UNASSIGNED) {
                            );
        int previousShardIndex = shardsWithMatchingShardId.indexOf(oldShard);  
         * This method will not drain unassigned shards.
        return this.unassignedShards;  
         * An unassigned iterator.
            Recoveries.unionRecoveries(routingNodes.recoveriesPerNode, routingNodes.initialReplicaRecoveries),  
/*
            return unassigned.isEmpty();
                    "remove is not supported in unassigned iterator," + " use removeAndIgnore or initialize"  
        assert routing.initializing() : "routing must be initializing: " + routing;  
        public List<ShardRouting> ignored() {
            for (final ShardRouting shardRouting : routingNode) {
         * @opensearch.api  
     * Calculates RoutingNodes statistics by iterating over all {@link ShardRouting}s
                    ShardRouting updatedShard = shard.updateUnassigned(newInfo, shard.recoverySource());
     * shard as well as assigning it.
                for (ShardRouting routing : new ArrayList<>(assignedShards)) {
            + "] but RoutingNodes returned inactive primaries ["
            if (startedShard.primary()) {  
    public ShardRouting getByAllocationId(ShardId shardId, String allocationId) {
                r1.addIncoming(r2.incoming);  
         */  
     */
            + "]";
            private ShardRouting current;  
    /**  
            for (IndexShardRoutingTable indexShard : indexRoutingTable) {
        return sb.toString();
 *
        private static final Recoveries EMPTY = new Recoveries();
        UnassignedInfo unassignedInfo,
                }
    private void removeRecovery(ShardRouting routing) {
    }
        assert unassignedIgnoredPrimaryCount == routingNodes.unassignedShards.getNumIgnoredPrimaries() : "Unassigned ignored primaries is ["
        shardsWithMatchingShardId.set(previousShardIndex, newShard);
        }
    /**  
    }
     * refuses to allocate that shard's replicas onto any not-yet-upgraded node. Both replication
        assert node(nodeId).invariant();
            public boolean hasNext() {
            nodes.ensureMutable();
                    );  
        if (!Assertions.ENABLED) {
import java.util.List;
            ShardRouting relocationSourceShard = relocationSourceNode.getByShardId(initializingShard.shardId());
     * @param routingNodeFilter filters the routing nodes based on given condition
                }  
     * @opensearch.api  
 * <li> {@link #startShard} starts an initializing shard / completes relocation of a shard.
        private final List<ShardRouting> ignored;
                // cancel and remove target shard  
 * specific language governing permissions and limitations
            final Recoveries value = recoveries.getValue();  
                return shardRouting;
            }
                );
        } else {
        }  
        return startedShard;
                changes.unassignedInfoUpdated(current, unassignedInfo);
        node(target.currentNodeId()).add(target);
            assert failedShard.active();  
         * @see UnassignedIterator#removeAndIgnore(AllocationStatus, RoutingChangesObserver)
            return ignored.isEmpty();
            }
                } else {  
     * @param attributeName The name of the awareness attribute to collect values for  
        return reinitializedShard;
            routingNodes,
     * @return the started shard  
        ShardRouting reinitializedShard = shard.reinitializeReplicaShard();  
     * @return A set of unique attribute values for the specified attribute
    /**
                        return true;
        assert indexMetadata.getIndex().equals(failedShard.index()) : "shard failed for unknown index (shard entry: " + failedShard + ")";  
    private static void assertRecoveriesPerNode(
    public ShardRouting startShard(Logger logger, ShardRouting initializingShard, RoutingChangesObserver routingChangesObserver) {
    }
                            ShardRouting sourceShard = getByAllocationId(routing.shardId(), routing.allocationId().getRelocationId());
                            0,
 * <li> {@link #failShard} fails/cancels an assigned shard.  
            + newShard;  
        if (activeReplica == null) {
        ShardRouting initializedShard = unassignedShard.initialize(nodeId, existingAllocationId, expectedSize);
            }
        for (RoutingNode routingNode : this) {
                                shard.relocatingNodeId(),
        ShardRouting startedShard,
        }  
import org.opensearch.common.Randomness;
            if (shard.primary()) {
        }  
    /**
    private ShardRouting reinitReplica(ShardRouting shard) {
        void addIncoming(int howMany) {
            public void remove() {
            }
                                return true;
        return cancelledShard;
            if (!shard.active()) {
            + routingNodes.inactiveShardCount
     * ID as the given shard.
        inactiveShardCount++;
     * Unassigned shard list.
        }
                            ShardRouting targetShardRouting = shard.getTargetRelocatingShard();
                        for (ShardRouting assigned : routingNodes.assignedShards.get(routing.shardId())) {  
        for (final RoutingNode routingNode : routingNodes) {  
     * the relocation if the shard is relocating.  
                    }
        assert inactivePrimaryCount == routingNodes.inactivePrimaryCount : "Inactive Primary count ["  
                        && assigned.initializing()
                    unassignedInfo.shortSummary()  
                primaries++;
        public int size() {  
                logger.trace("{}, relocation source failed / cancelled, mark as initializing without relocation source", targetShard);
        UnassignedInfo unassignedInfo,  
                    unassignPrimaryAndPromoteActiveReplicaIfExists(failedShard, unassignedInfo, routingChangesObserver);
                Comparator.comparing(
        for (ShardRouting shard : routingNodes.unassigned()) {  
public class RoutingNodes implements Iterable<RoutingNode> {  
                            ShardRouting reinitializedReplica = reinitReplica(routing);
     *  
            + newShard;
    }
                if (shard == iterator.next()) {
             * @param existingAllocationId allocation id to use. If null, a fresh allocation id is generated.
     * Returns <code>true</code> iff this {@link RoutingNodes} instance has any unassigned shards even if the  
        updateAssigned(replicaShard, primaryShard);
            RoutingNode relocationSourceNode = node(initializingShard.relocatingNodeId());
            if (failedShard.relocatingNodeId() == null) {
 * You may obtain a copy of the License at  
        relocatingShards--;
                } else {
    /**
            x -> !isNonRelocatingPrimary(x)
 *  
            Map<String, Recoveries> recoveries = new HashMap<>();
            + oldShard  
    /**  
        }
    /**  
                RoutingChangesObserver routingChangesObserver
    public int getInitialPrimariesIncomingRecoveries(String nodeId) {
    ) {
        }
                unassignedIgnoredPrimaryCount++;
             *
        final List<ShardRouting> replicaSet = assignedShards.get(shard.shardId());  
        relocatingShards++;
    public Tuple<ShardRouting, ShardRouting> relocateShard(  
                        assignedShardsAdd(shard);
        final Queue<Iterator<ShardRouting>> queue = new ArrayDeque<>();
                    shardIterators.poll();  
    private final Map<String, Recoveries> initialPrimaryRecoveries = new HashMap<>();  
        return true;  
     * Since replicas could possibly be on nodes with a higher version of OpenSearch than
    public RoutingNode node(String nodeId) {  
        if (failedShard.initializing()) {
     * Relocate a shard to another node, adding the target initializing
    }  
    }
                    if (assigned.primary() == false
                logger.trace("{} is removed due to the failure/cancellation of the source shard", targetShard);
            }
    }  
        public void add(ShardRouting shardRouting) {  
        for (Map.Entry<String, Recoveries> recoveries : recoveriesPerNode.entrySet()) {
                IndexMetadata idxMetadata = metadata.index(indexShard.shardId().getIndex());
     * no primary is found or the primary is not active.
                )
    public int getOutgoingRecoveries(String nodeId) {  
        }
import org.apache.logging.log4j.Logger;
        static Map<String, Recoveries> unionRecoveries(Map<String, Recoveries> first, Map<String, Recoveries> second) {
                    // initializing shard that is not relocation target, just move to unassigned
    /**  
     */
            @Override  
            sb.append(routingNode.prettyPrint());
                for (ShardRouting assigned : assignedShards(routing.shardId())) {  
                }
import java.util.Map;  
     * Moves the initializing shard to started. If the shard is a relocation target, also removes the relocation source.
    }
    private ShardRouting started(ShardRouting shard) {
            }
                ShardRouting replicaShard = replicaIterator.next();
        }
            private void innerRemove() {
     * @opensearch.internal
            + " by shard assigned to same node but was "
        if (idxMetadata != null) {
                shards.add(shardRouting);  
     *
         */  
     * the first node, then the first shard of the second node, etc. until one shard from each node has been returned.
            }  
        assert getByAllocationId(failedShard.shardId(), failedShard.allocationId().getId()) == failedShard
     * @return this method always returns <code>true</code> or throws an assertion error. If assertion are not enabled  
            inactiveShardCount--;
                Recoveries r2 = newRecoveries.get(node);
                        } else if (shard.initializing()) {
        this.nodesPerAttributeNames = Collections.synchronizedMap(new HashMap<>());
                    // promote active replica to primary if active replica exists (only the case for shadow replicas)
        assert shard.unassigned() == false : "only assigned shards can be moved to unassigned (" + shard + ")";  
                            // it's relocating from.
        }
    }
    }
    public List<ShardRouting> shardsWithState(ShardRoutingState... state) {  
                assert replicaShard.primary() != primaryFirst;
             * @param attempt the result of the allocation attempt  
                    return;
        }
                        currInfo.isDelayed(),  
            + "]";
                        currInfo.getUnassignedTimeInMillis(),
    private void promoteReplicaToPrimary(ShardRouting activeReplica, RoutingChangesObserver routingChangesObserver) {
    }
                }
                    inactiveShardCount++;
        public class UnassignedIterator implements Iterator<ShardRouting>, ExistingShardsAllocator.UnassignedAllocationHandler {  
            public boolean hasNext() {
                nodes.ensureMutable();
            }  
                routingChangesObserver.shardFailed(targetShard, unassignedInfo);
            String node = recoveries.getKey();
        }
     * Moves a shard from unassigned to initialize state  
                indicesAndShards.put(shard.index(), Math.max(i, shard.id()));
        return initialReplicaRecoveries.getOrDefault(nodeId, Recoveries.EMPTY).getOutgoing();  
    public int getInitialOutgoingRecoveries(String nodeId) {
                return buildIteratorForMovementStrategy(false);  
        return shards;
        long expectedShardSize,  
            nodes.ensureMutable();
                            remove(routing);
     */
        int relocating = 0;
        }
        }
                }
        List<ShardRouting> shardsWithMatchingShardId = assignedShards.computeIfAbsent(oldShard.shardId(), k -> new ArrayList<>());
            assert s != shard;  
    }
    /**  
                        }  
     */
     * Removes relocation source of an initializing non-primary shard. This allows the replica shard to continue recovery from
 * software distributed under the License is distributed on an
     * - If shard is an active primary, this also promotes an active replica to primary (if such a replica exists).
         * Drains all ignored shards and returns it.
     *
            // if this is a primary shard with ongoing replica recoveries, reinitialize them as their recovery source changed
    }
            Recoveries recoveries = map.get(key);
     * Returns the active primary shard for the given shard id or <code>null</code> if  
        assert assertInstanceNotInList(shard, shards) : "shard " + shard + " cannot appear twice in list of assigned shards";  
            } else {
            }
            for (ShardRouting shardRouting : routingNode) {  
                            if (queue.peek().hasNext()) {  
        for (RoutingNode routingNode : this) {  
                        && assigned.recoverySource().getType() == RecoverySource.Type.PEER) {  
        return nodesToShards.size();  
    @Override
                if (allocationStatus.equals(currInfo.getLastAllocationStatus()) == false) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
                }
            if (shard.primary()) {
        return shards;  
        ShardRouting unassigned = shard.moveToUnassigned(unassignedInfo).moveUnassignedFromPrimary();  
                    i = shard.id();
     * - If shard is a primary, this also fails initializing replicas.
            private Queue<ShardRouting> shardRoutings = new ArrayDeque<>();
                logger.trace(
            }
        for (ShardRouting shard : routingNodes.unassigned().ignored()) {  
                        // re-resolve replica as earlier iteration could have changed source/target of replica relocation
            nodes.ensureMutable();
        // TODO: check primary == null || primary.active() after all tests properly add ReplicaAfterPrimaryActiveAllocationDecider  
     */
     * <p>  
        private static void addRecoveries(Map<String, Recoveries> existingRecoveries, Map<String, Recoveries> newRecoveries) {
    public Iterator<RoutingNode> mutableIterator() {  
            assert targetShard.isRelocationTargetOf(failedShard);  
 * The main methods used to update routing entries are:
        assert node(shard.currentNodeId()).invariant();
            return (nd != null && nd.node().isRemoteStoreNode());
     * @return iterator of shard routings
        return Collections.unmodifiableCollection(nodesToShards.values()).iterator();  
                            }
    public static boolean assertShardStats(RoutingNodes routingNodes) {  
                    throw new NoSuchElementException();
        ensureMutable();  
                    if (unassignedShard.index().getName().equals(index)) {  
            for (ShardRouting shard : node) {
                            Collections.emptySet()
 * The OpenSearch Contributors require contributions made to  
            if (assignedShards.isEmpty() == false) {  
     * Since we aim to continue moving forward during remote store migration, replicas already migrated to remote nodes
         * @see UnassignedIterator#removeAndIgnore(AllocationStatus, RoutingChangesObserver)
         * @see #isIgnoredEmpty()
         * are not part of the formal unassigned list, but are kept around and used to build
                    shard = updatedShard;  
        assert node(target.currentNodeId()).invariant();  
        }  
                // is not added back as unassigned shard  
    }
                }  
     */
                    || (shards != null && shards.size() == mutableShardRoutings.size() && shards.containsAll(mutableShardRoutings));
     * @deprecated no longer used for primary promotion. Promoting the highest-version replica
     */  
    }
    ) {  
                    if (routing.initializing() && routing.primary() == false) {
        if (replicaSet == null) {  
        // that have been removed, the shards are failed, and part of the shard failing
                    shards.add(shardRouting);
            return true;
import java.util.function.Function;
                routingChangesObserver.relocationSourceRemoved(targetShard);
    }
     *
                }
import static org.opensearch.node.remotestore.RemoteStoreNodeService.isMigratingToRemoteStore;  
                logger.trace(
    private Map<String, Recoveries> getRecoveries(ShardRouting routing) {
        }
                            shardRoutings.offer(result);
        // if this is a primary, fail initializing replicas first (otherwise we move RoutingNodes into an inconsistent state)  
                return current = iterator.next();
        Map<String, Recoveries> recoveriesPerNode,  
            }
            }  
                        }
            if (shardRouting.primary()) {
    /**  
            + oldShard
            : "only assigned shards can be updated in list of assigned shards (prev: " + oldShard + ", new: " + newShard + ")";
        assert shard.unassigned() == false : "only assigned shards can be removed here (" + shard + ")";  
                            throw new NoSuchElementException();
        assert shard.isRelocationTarget() : "only relocation target shards can have their relocation source removed (" + shard + ")";
        if (isMigratingToRemoteStore(metadata)) {
        /**
            return primaries;
    /**
        }
    public Set<String> nodesPerAttributesCounts(String attributeName, Predicate<RoutingNode> routingNodeFilter) {
    }
        }
     * the primary even though its non-primary relocation source has failed.
                    }
        ShardRouting activeReplica = null;  
            + "]";
                assert (shards == null && mutableShardRoutings.size() == 0)
    }  
            Randomness.shuffle(unassigned);  
        }
     *
            ShardRouting[] mutableShardRoutings = ignored.toArray(new ShardRouting[0]);  
        }  
    }
                ShardRouting sourceShard = getByAllocationId(failedShard.shardId(), failedShard.allocationId().getRelocationId());  
            assert inactiveShardCount >= 0;
                iterator.set(shardRouting);
     * @return the started shard  
            if (routingNode != null) { // node might have dropped out of the cluster
        node(nodeId).add(initializedShard);  
            ) {  
            )
        if (shard.initializing() && shard.relocatingNodeId() == null) {  
            if (shard.primary()) {
 * or disallowing changes to its elements.
                    }
            ShardRouting targetShard = getByAllocationId(failedShard.shardId(), failedShard.allocationId().getRelocationId());
            List<ShardRouting> shardRoutings = assignedShards.get(routing.shardId());
     */  
        }
        if (isSearchOnlyClusterBlockEnabled == false) {
 * the Apache License, Version 2.0 (the "License"); you may
                    if (shard.assignedToNode()) {
            }  
                    changes.unassignedInfoUpdated(shard, newInfo);
            return false; // if we are empty nothing is active if we have less than total at least one is unassigned
            }
                        } else {  
        }
        return new Iterator<ShardRouting>() {  
                if (shard.initializing() && shard.relocatingNodeId() == null) {  
        return relocationMarkerRemoved;  
            }  
                    sourceShard,
        @Override  
        ensureMutable();
            Recoveries.getOrAdd(getRecoveries(routing), primary.currentNodeId()).addOutgoing(howMany);
import org.opensearch.core.index.shard.ShardId;
        private int incoming = 0;  
        for (ShardRouting shard : shards) {
                innerRemove();
    private int inactivePrimaryCount = 0;
     * the primary is, this will return replicas on the highest version of OpenSearch.
            + "] but RoutingNodes returned unassigned ignored primaries ["  
                }
        return assignedShards(shardId).stream()  
        updateAssigned(shard, relocationMarkerRemoved);
        updateAssigned(shard, startedShard);
                            primary = shardRouting;
     */
        ShardRouting startedShard = shard.moveToStarted();  
     */
     * Recoveries started from node as a result of new index creation.  
        }
     * <p>  
        long expectedSize,  
                    "{}, resolved source to [{}]. canceling relocation ... ({})",  
            assert relocationSourceShard.getTargetRelocatingShard() == initializingShard : "relocation target mismatch, expected: "
        final RoutingTable routingTable = clusterState.routingTable();  
     *
            .filter(shr -> !shr.primary() && shr.active() && !shr.isSearchOnly())
    public RoutingNodes(ClusterState clusterState) {
        }
import java.util.Set;  
                        routingNode.add(shard);  
        }
    public int getIncomingRecoveries(String nodeId) {
            CollectionUtil.timSort(unassigned, comparator);  
             * {@link #initialize(String, String, long, RoutingChangesObserver)}.
        return Tuple.tuple(source, target);
        assert shard.unassigned() == false : "only assigned shards can be moved to unassigned (" + shard + ")";  
            return null;
        return recoveriesPerNode.getOrDefault(nodeId, Recoveries.EMPTY).getIncoming();
        // fill in the nodeToShards with the "live" nodes
    /**
                        );
     * <p>  
    }
        public void sort(Comparator<ShardRouting> comparator) {
        }
                if (!shardRoutings.isEmpty()) {
     */  
     *
        assert nodesToShards.values().stream().allMatch(RoutingNode::invariant);  
    }  
            }  
                    shr -> node(shr.currentNodeId()).node(),
                    public ShardRouting next() {  
                        currInfo.getUnassignedTimeInNanos(),
            unassigned = new ArrayList<>();
    }
        public boolean isIgnoredEmpty() {  
        // be accessible. Therefore, we need to protect against the version being null
                    if (shardIterators.peek().hasNext()) {  
import org.opensearch.cluster.ClusterState;  
                        Recoveries.getOrAdd(recoveriesToUpdate, routing.currentNodeId()).addOutgoing(1);  
            private Queue<Iterator<ShardRouting>> shardIterators = new ArrayDeque<>();
                        inactivePrimaryCount++;  
        if (failedShard.relocating()) {  
                final HashSet<ShardRouting> shards = shardsByShardId.computeIfAbsent(
     * - If shard is a (primary or replica) relocation target, this also clears the relocation information on the source shard.  
                    return shardRoutings.poll();
    private void unassignPrimaryAndPromoteActiveReplicaIfExists(  
        }
        }
         */
                            primary = shardRouting;
                while (!queue.isEmpty()) {  
                unassignedPrimaryCount++;
             *
    }  
            return Collections.unmodifiableList(ignored);
                    Iterator<ShardRouting> iter = queue.poll();
                        }
    }
                            shardIterators.offer(iter);
        int inactiveShardCount = 0;
        // TODO these are used on tests only - move into utils class
            return mutableShardRoutings;  
        assert shard.isRelocationTarget() == false : "replication target cannot be reinitialized: " + shard;
                    }  
import java.util.stream.Stream;
        assert shard.primary() == false : "shard must be a replica: " + shard;  
                + initializingShard
                        } else if (primary.relocatingNodeId() != null) {  
                            shard.currentNodeId(),  
                        }  
        for (ShardRoutingState s : state) {  
    /**
            @Override  
     * Returns one active replica shard for the given shard id or <code>null</code> if
                                sourceShard.getExpectedShardSize(),  
    }  
        inactiveShardCount++; // relocation targets are not counted as inactive shards whereas initializing shards are
                    }
         * Returns <code>true</code> iff this collection contains one or more non-ignored unassigned shards.
            assert relocationSourceShard.isRelocationSourceOf(initializingShard);  
    /**
            return unassigned.size();
    }
        }
            + "]";  
                recoveries = new Recoveries();  
        for (final IndexRoutingTable indexRoutingTable : routingTable.indicesRouting().values()) {  
    @Nullable  
        public int getNumPrimaries() {
            @Override
        }  
        if (activeReplica == null) {
 *
     * Returns one active replica shard for the given shard id or <code>null</code> if
        // It's possible for replicaNodeVersion to be null. Therefore, we need to protect against the version being null
                        } else if (primary == null) {
                );
            @Override
            return;  
 *
                            relocateShard(  
import java.util.stream.Collectors;  
                            unassignedInfo.getUnassignedTimeInMillis(),
            inactivePrimaryCount++;
            sb.append("--------").append(shardEntry.shortSummary()).append('\n');  
                    queue.poll();  
                }
 * KIND, either express or implied.  See the License for the
        return null;
                // yes we check identity here
             * {@link #removeAndIgnore(AllocationStatus, RoutingChangesObserver)} or  
     * @param existingAllocationId allocation id to use. If null, a fresh allocation id is generated.
 * Unless required by applicable law or agreed to in writing,
                    public void remove() {  
                removeRelocationSource(targetShard);
        IndexMetadata idxMetadata = metadata.index(routing.index());
                for (ShardRouting shard : indexShard) {
        routingChangesObserver.replicaPromoted(activeReplica);  
            if (shard.primary()) {  
        IndexMetadata indexMetadata,
                Iterator<ShardRouting> replicaIterator = shardIterators.poll();  
         * the correct usage is to removeAndIgnore from the iterator.
 * GitHub history for details.
            } else {
            activeReplica = activeReplicaOnRemoteNode(failedShard.shardId());  
        public boolean isEmpty() {  
    private final Map<String, Set<String>> searchNodesPerAttributeNames;  
        ensureMutable();
    /**  
        }
                    relocating++;
                    if (queue.peek().hasNext()) {  
                        currInfo.getFailure(),
import org.opensearch.common.Nullable;  
                    }
            return buildIteratorForMovementStrategy(true);  
     *                              if ShardMovementStrategy.REPLICA_FIRST, all replica shards are iterated over before iterating primary for any node  
    private final UnassignedShards unassignedShards = new UnassignedShards(this);
            return recoveriesPerNode;  
            if (primary == null) {
        return initializedShard;  
            return incoming;  
        assignedShardsAdd(initializedShard);
        }
 */  
             * will be added back to unassigned once the metadata is constructed again).
                    }
     */  
                return updatedShardRouting;
                inactivePrimaryCount--;
            final Iterator<ShardRouting> iterator = replicaSet.iterator();
                    if (!routing.primary() && routing.initializing()) {  
            .filter(shr -> node(shr.currentNodeId()) != null)
                            inactiveShardCount++;  
                }  
    private int relocatingShards = 0;  
            }  
import java.util.ListIterator;
        this.metadata = clusterState.getMetadata();
                + relocationSourceShard.getTargetRelocatingShard();
                    // to get all the shards belonging to an index, including the replicas,  
     * Mark a shard as started and adjusts internal statistics.
        public UnassignedIterator iterator() {
                r1.addOutgoing(r2.outgoing);
        }
                        }
            assert outgoing + howMany >= 0 : outgoing + howMany + " must be >= 0";
            + "] but expected ["  
                }
                            AllocationStatus.NO_ATTEMPT,  
            + routingNodes.unassigned().getNumPrimaries()
            .filter(shr -> !shr.primary() && shr.active() && !shr.isSearchOnly())
            + " by shard with same shard id but was "
                return false;
        node(oldShard.currentNodeId()).update(oldShard, newShard);  
        }
    /**  
                    @Override  
        shards.add(shard);
        unassignedShards.add(unassigned);
            }  
            shard = cancelRelocation(shard);
            ) {
        assertRecoveriesPerNode(routingNodes, routingNodes.initialPrimaryRecoveries, false, x -> isNonRelocatingPrimary(x));  
import java.util.Iterator;  
        node(shard.currentNodeId()).remove(shard);
                    if (routing.initializing() && incomingCountFilter.apply(routing)) incoming++;  
                // copy list to prevent ConcurrentModificationException
            }  
        } else {
     * Returns <code>true</code> iff this {@link RoutingNodes} instance has any unassigned primaries even if the
                RecoverySource recoverySource,  
            .min(  
     */
                shardIterators.offer(replicaIterator);
    }
        return nodesPerAttributeNames.computeIfAbsent(  
    private static final class Recoveries {
     */
     * the primary is, this will return replicas on the oldest version of OpenSearch so that
                            routingChangesObserver.shardFailed(
            // find the shard that is initializing on the target node
            for (int i = 0; i < e.getValue(); i++) {  
 * <li> {@link #relocateShard} starts relocation of a started shard.
            List<ShardRouting> assignedShards = assignedShards(failedShard.shardId());
        if (readOnly) {
    }  
import java.util.HashMap;
                }  
import org.opensearch.common.collect.Tuple;
         */  
            + unassignedPrimaryCount  
            if (shardMovementStrategy == ShardMovementStrategy.REPLICA_FIRST) {
    }
        }  
                            // cancel relocation and start relocation to same node again
            return outgoing;
        final List<ShardRouting> shards = assignedShards(shardId);  
             * updates the unassigned info and recovery source on the current unassigned shard  
    private final boolean readOnly;  
                        UnassignedInfo primaryFailedUnassignedInfo = new UnassignedInfo(
    public RoutingNodes(ClusterState clusterState, boolean readOnly) {  
                assert sourceShard.isRelocationSourceOf(failedShard);
            // Promote the oldest-version in-sync replica for both document and segment replication so the  
        for (Map.Entry<String, RoutingNode> entry : nodesToShards.entrySet()) {  
    public boolean hasUnassignedPrimaries() {
                }
            return ignoredPrimaries;  
            }
            if (failedShard.primary()) {
                            if (shard.primary()) {  
                    if (shardRouting.primary()) {
 * <li> {@link #initializeShard} initializes an unassigned shard.  
                Integer i = indicesAndShards.get(shard.index());  
                while (!shardIterators.isEmpty()) {
        updateAssigned(startedShard, source);
            private final ListIterator<ShardRouting> iterator;
     * no active replica is found.
    /**
                    }
        return shards;  
        for (ShardRouting shardRouting : replicaSet) {  
        Set<Map.Entry<Index, Integer>> entries = indicesAndShards.entrySet();  
        @PublicApi(since = "1.0.0")
    public Iterator<RoutingNode> iterator() {
            }  
            unassigned.add(shardRouting);
            }
        }
import org.opensearch.cluster.metadata.Metadata;
    private void assignedShardsRemove(ShardRouting shard) {
                        currInfo.getReason(),  
                                routing,  
    public String toString() {
                            }
        if (failedShard.primary()) {
                    remove(failedShard);  
        return unassignedShards.getNumPrimaries() + unassignedShards.getNumIgnoredPrimaries() > 0;
            queue.add(entry.getValue().copyShards().iterator());
    private final Map<String, Recoveries> initialReplicaRecoveries = new HashMap<>();
        assert node(failedShard.currentNodeId()).getByShardId(failedShard.shardId()) == null : "failedShard "
                // The shard is a target of a relocating shard. In that case we only need to remove the target shard and cancel the source
                            addInitialRecovery(shard, indexShard.primary);
                if (predicate.test(shardRouting)) {
        }
     */
                            ShardRouting result = iter.next();
        promoteActiveReplicaShardToPrimary(activeReplica);
        return assignedShards(shardId).stream()  
        this.searchNodesPerAttributeNames = Collections.synchronizedMap(new HashMap<>());
        // calls this method with an out-of-date RoutingNodes, where the version might not  
        private final List<ShardRouting> unassigned;  
        ShardRouting primary = null;
     * @return pair of source relocating and target initializing shards.
        return null;  
        List<ShardRouting> shards = new ArrayList<>();
         */
        int getIncoming() {
        routingChangesObserver.shardFailed(failedShard, unassignedInfo);  
            // any not-yet-upgraded node during a rolling upgrade.
        // Assert that the active shard routing are identical.
                                startedReplica,
        }
        RoutingChangesObserver routingChangesObserver
                                queue.offer(iter);
             */
        return replicaSet == null ? EMPTY : Collections.unmodifiableList(replicaSet);  
            ignored.clear();
import org.opensearch.cluster.node.DiscoveryNode;  
