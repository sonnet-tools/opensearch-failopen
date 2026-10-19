        assert node(target.currentNodeId()).invariant();
            assert outgoing == value.outgoing : outgoing + " != " + value.outgoing + " node: " + routingNode;
        }
    /**
        return initializedShard;
        List<ShardRouting> shards = new ArrayList<>();
        ShardRouting cancelledShard = shard.cancelRelocation();
            incoming += howMany;
        return recoveriesPerNode.getOrDefault(nodeId, Recoveries.EMPTY).getIncoming();
                for (ShardRouting unassignedShard : unassignedShards) {
        assert indexMetadata.getIndex().equals(failedShard.index()) : "shard failed for unknown index (shard entry: " + failedShard + ")";
            int outgoing = 0;
                        return false;
                if (failedShard.relocating()) {
     */
                    // we define a replica set and keep track of it. A replica set is identified
        public void sort(Comparator<ShardRouting> comparator) {
        }
                        }
                            addInitialRecovery(shard, indexShard.primary);
        return shards;
            shards.addAll(routingNode.shardsWithState(state));
         * @see UnassignedIterator#removeAndIgnore(AllocationStatus, RoutingChangesObserver)
    private Iterator<ShardRouting> buildIteratorForMovementStrategy(boolean primaryFirst) {
            )
        IndexMetadata indexMetadata,
        assert oldShard.unassigned() == false && newShard.unassigned() == false
                inactivePrimaryCount--;
    public Set<String> nodesPerAttributesCounts(String attributeName) {
                            // Add the counterpart shard with relocatingNodeId reflecting the source from which
     */
            + inactivePrimaryCount
        }
        return unassigned;
        for (RoutingNode routingNode : this) {
            private void innerRemove() {
                            ShardRouting targetShardRouting = shard.getTargetRelocatingShard();
                                return result;
            if (shard.primary()) {
                + " but was: "
                }
            @Override
        this.readOnly = readOnly;
    }
                    if (shard.primary()) {
                shardIterators.offer(replicaIterator);
     */
            // Promote the oldest-version in-sync replica for both document and segment replication so the
    }
        if (isSearchOnlyClusterBlockEnabled == false) {
            assert routing.relocatingNodeId() == null : "Routing must be a non relocating primary";
     * Calculates RoutingNodes statistics by iterating over all {@link ShardRouting}s
            assert relocationSourceShard.isRelocationSourceOf(initializingShard);
            attributeName,
         * This method will not drain ignored shards.
    }
    private void removeRecovery(ShardRouting routing) {
                );
        } else if (shard.relocating()) {
                        inactivePrimaryCount++;
            if (failedShard.relocatingNodeId() == null) {
        if (!Assertions.ENABLED) {
                            ShardRouting startedReplica = cancelRelocation(sourceShard);
        long expectedShardSize,
     *
                indicesAndShards.put(shard.index(), Math.max(i, shard.id()));
    private void promoteReplicaToPrimary(ShardRouting activeReplica, RoutingChangesObserver routingChangesObserver) {
            List<ShardRouting> assignedShards = assignedShards(failedShard.shardId());
            nodes.ensureMutable();
     * A collection of recoveries.
        return shards;
    }
                    k -> new HashSet<>()
                    if (routing.initializing() && routing.primary() == false) {
        // failed initializing replica shards (and moved replica relocation source back to started)
     * @return                     the initialized shard
    /**
     * @param routingNodeFilter filters the routing nodes based on given condition
     * @return pair of source relocating and target initializing shards.
                // is not added back as unassigned shard
                                return result;
        /**
        }
                            }
                                routing,
        final int howMany = increment ? 1 : -1;
                // copy list to prevent ConcurrentModificationException
         */
    @Override
import static org.opensearch.node.remotestore.RemoteStoreNodeService.isMigratingToRemoteStore;
                        while (!queue.isEmpty()) {
        if (readOnly) {
        assert replicaShard.primary() == false : "primary shard cannot be promoted to primary: " + replicaShard;
                while (queue.isEmpty() == false) {
                    failedShard.shardId(),
         * @see UnassignedIterator#removeAndIgnore(AllocationStatus, RoutingChangesObserver)
                        currInfo.getReason(),
                    }
                        if (hasNext() == false) {
        ShardRouting startedShard = shard.moveToStarted();
        /**
     * the relocation if the shard is relocating.
            } else {
    }
        }
            return unassigned.size();
                            "primary failed while replica initializing",
            + "]";
                final HashSet<ShardRouting> shards = shardsByShardId.computeIfAbsent(
        for (RoutingNode routingNode : this) {
    @DeprecatedApi(since = "3.9.0", forRemoval = "4.0.0")
        public boolean isEmpty() {
    ) {
                                k -> new RoutingNode(shard.relocatingNodeId(), clusterState.nodes().get(shard.relocatingNodeId()))
         * @see UnassignedShards#ignoreShard(ShardRouting, AllocationStatus, RoutingChangesObserver)
         */
            if (shardRouting.primary()) {
                innerRemove();
import java.util.stream.Stream;
import java.util.Comparator;
import org.apache.lucene.util.CollectionUtil;
    }
                } else {
import java.util.ListIterator;
        for (Map.Entry<String, RoutingNode> entry : nodesToShardsEntrySet) {
                            );
                Integer i = indicesAndShards.get(shard.index());
            sb.append(routingNode.prettyPrint());
            public UnassignedIterator() {
                                inactivePrimaryCount++;
        Map<Index, Integer> indicesAndShards = new HashMap<>();
     * all the nodes have been returned.
            @Override
     */
            unassigned.add(shardRouting);
        return new Iterator<ShardRouting>() {
                }
     * For performance reasons, this should only be called from asserts
    /**
                if (shard.relocating()) {
            : "only assigned shards can be updated in list of assigned shards (prev: " + oldShard + ", new: " + newShard + ")";
            final Recoveries value = recoveries.getValue();
                current = shardRouting;
                Comparator.comparing(
                            ShardRouting result = iter.next();
     *         this method does nothing.
        private int incoming = 0;
                    if (assigned.primary() == false
         * @see #isIgnoredEmpty()
        return relocationMarkerRemoved;
    /**
     *
    private final Metadata metadata;
        return Collections.unmodifiableCollection(nodesToShards.values()).iterator();
     * primaries are marked as temporarily ignored.
                if (shard.initializing() && shard.relocatingNodeId() == null) {
                    }
    /**
        return true;
            }
        }).findFirst().orElse(null);
        );
     * Returns one active replica shard for the given shard id or <code>null</code> if
     * @return iterator of shard routings
        assertRecoveriesPerNode(routingNodes, routingNodes.initialPrimaryRecoveries, false, x -> isNonRelocatingPrimary(x));
                    assert indexShard.primary != null : "Primary shard routing can't be null for non-search-only indices";
                // yes we check identity here
    public int getRelocatingShardCount() {
        return true;
        }
        @PublicApi(since = "1.0.0")
        return primary;
    /**
                    } else {
    /**
                Comparator.comparing(
            ignored = new ArrayList<>();
     * no such replica is found.
        }
        assert replicaShard.active() : "non-active shard cannot be promoted to primary: " + replicaShard;
        assert unassignedPrimaryCount == routingNodes.unassignedShards.getNumPrimaries() : "Unassigned primaries is ["
                iterator.set(shardRouting);
                // copy list to prevent ConcurrentModificationException
    private ShardRouting promoteActiveReplicaShardToPrimary(ShardRouting replicaShard) {
        public UnassignedShards(RoutingNodes nodes) {
    }
import java.util.HashSet;
        }
                    public void remove() {
        }
     * Returns iterator of shard routings used by {@link #nodeInterleavedShardIterator(ShardMovementStrategy)}
    /**
        }
    private final Map<String, Recoveries> initialPrimaryRecoveries = new HashMap<>();
        // (meaning the node will be going away).
     */
            }
                            // cancel relocation and start relocation to same node again
            }
            }
    public RoutingNodes(ClusterState clusterState, boolean readOnly) {
                            if (queue.peek().hasNext()) {
    public RoutingNodes(ClusterState clusterState) {
 * SPDX-License-Identifier: Apache-2.0
    private final Map<String, Recoveries> initialReplicaRecoveries = new HashMap<>();
     * moves the assigned replica shard to primary.
                            if (shard.primary()) {
                    moveToUnassigned(failedShard, unassignedInfo);
                nodes.ensureMutable();
            assert failedShard.active();
     * the primary is, this will return replicas on the oldest version of OpenSearch so that
        ShardRouting failedShard,
                        for (ShardRouting assigned : routingNodes.assignedShards.get(routing.shardId())) {
             * {@link #removeAndIgnore(AllocationStatus, RoutingChangesObserver)} or
            routingNodes,
     */
        ShardRouting startedShard,
        assert shard.isRelocationTarget() : "only relocation target shards can have their relocation source removed (" + shard + ")";
        if (activeReplica == null) {
                cancelRelocation(sourceShard);
            }
            addRecoveries(recoveries, first);
     */
            }
        ShardRouting startedShard = started(initializingShard);
    /**
                    );
    /**
                            if (result.primary()) {
                assert replicaShard.primary() != primaryFirst;
    }
            assert outgoing + howMany >= 0 : outgoing + howMany + " must be >= 0";
        }
    public boolean hasInactivePrimaries() {
                + getByAllocationId(failedShard.shardId(), failedShard.allocationId().getId());
        public List<ShardRouting> ignored() {
            + routingNodes.inactivePrimaryCount
    @Override
        private static void addRecoveries(Map<String, Recoveries> existingRecoveries, Map<String, Recoveries> newRecoveries) {
    /**
 * Unless required by applicable law or agreed to in writing,
            for (String node : newRecoveries.keySet()) {
/*
                unassignedIgnoredPrimaryCount++;
        removeRecovery(shard);
                    sourceShard,
                return shardRouting;
        return relocatingShards;
    public ShardRouting startShard(Logger logger, ShardRouting initializingShard, RoutingChangesObserver routingChangesObserver) {
                    throw new NoSuchElementException();
        } else {
     * Moves a shard from unassigned to initialize state
            Recoveries recoveries = map.get(key);
     * no active replica is found.
            }
                if (isSearchOnlyClusterBlockEnabled == false) {
            } else {
     * <p>
import org.opensearch.common.annotation.DeprecatedApi;
 * @opensearch.api
                        throw new UnsupportedOperationException();
     */
        updateAssigned(replicaShard, primaryShard);
        routingChangesObserver.shardFailed(failedShard, unassignedInfo);
        }
                    return true;
            }
 * not use this file except in compliance with the License.
        for (ShardRouting s : shards) {
        assert shard.unassigned() == false : "only assigned shards can be removed here (" + shard + ")";
    }
            public ShardRouting next() {
        logger.trace("{} marked shard as started (routing: {})", initializingShard.shardId(), initializingShard);
        assert nodesToShards.values().stream().allMatch(RoutingNode::invariant);
                    shr -> node(shr.currentNodeId()).node(),
            + "]";
        }
                    shard = updatedShard;
                        unassignedShards.add(shard);
        assert node(shard.currentNodeId()).invariant();
        return unassignedShards.getNumPrimaries() + unassignedShards.getNumIgnoredPrimaries() > 0;
            if (routingNode != null) { // node might have dropped out of the cluster
        ShardRouting relocationMarkerRemoved = shard.removeRelocationSource();
    private ShardRouting movePrimaryToUnassignedAndDemoteToReplica(ShardRouting shard, UnassignedInfo unassignedInfo) {
            ignored.clear();
            .orElse(null);
     * Eg: "zone" : ["zone1", "zone2", "zone3"]
         * An unassigned iterator.
            String node = recoveries.getKey();
        return nodesToShards.size();
                // relocation. No shard is left unassigned
    private void ensureMutable() {
    private ShardRouting moveToUnassigned(ShardRouting shard, UnassignedInfo unassignedInfo) {
     * ID as the given shard.
         * Returns the number of non-ignored unassigned primaries
        /**
                if (idxMetadata != null) {
                ShardRouting sourceShard = getByAllocationId(failedShard.shardId(), failedShard.allocationId().getRelocationId());
     *
     * promoted primary's segments and remain eligible allocation targets.
                removeRelocationSource(targetShard);
                    public boolean hasNext() {
            CollectionUtil.timSort(unassigned, comparator);
     */
        assert shard.unassigned() == false : "unassigned shard " + shard + " cannot be added to list of assigned shards";
        relocatingShards--;
                if (failedShard.primary()) {
        // fill in the inverse of node -> shards allocated
             *
            if (shard.primary()) {
        if (idxMetadata != null) {
            throw new IllegalStateException("can't modify RoutingNodes - readonly");
            }
            Recoveries.unionRecoveries(routingNodes.recoveriesPerNode, routingNodes.initialReplicaRecoveries),
    }
                        } else if (primary.relocatingNodeId() != null) {
                    relocating++;
        }
                }
import org.opensearch.cluster.ClusterState;
        if (shard.relocatingNodeId() == null) {
                    "{}, resolved source to [{}]. canceling relocation ... ({})",
         * Marks a shard as temporarily ignored and adds it to the ignore unassigned list.
                            shardRoutings.offer(result);
     *                              if ShardMovementStrategy.NO_PREFERENCE, order of replica and primary shards doesn't matter in iteration
                        return true;
     * Unassigned shard list.
     * no active replica is found.
        assert shard.initializing() : "can only reinitialize an initializing replica: " + shard;
                    // promote active replica to primary if active replica exists (only the case for shadow replicas)
                        .getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false);
 */
    /**
        int relocating = 0;
                    // by the ShardId, as this is common for primary and replicas.
                            inactiveShardCount++;
                    @Override
                r1.addIncoming(r2.incoming);
                    "{} is a relocation target, resolving source to cancel relocation ({})",
        Set<Map.Entry<Index, Integer>> entries = indicesAndShards.entrySet();
                        }
                            ShardRouting sourceShard = getByAllocationId(routing.shardId(), routing.allocationId().getRelocationId());
                        } else {
         * the correct usage is to removeAndIgnore from the iterator.
                            }
        RoutingChangesObserver routingChangesObserver
        return assignedShards(shardId).stream()
        return inactiveShardCount > 0;
        ShardRouting initializedShard = unassignedShard.initialize(nodeId, existingAllocationId, expectedSize);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                }
        if (routing.unassignedReasonIndexCreated() && !routing.primary()) {
            return true;
        }
        changes.relocationStarted(startedShard, target);
                this.iterator = unassigned.listIterator();
     * @param replicaShard the replica shard to be promoted to primary
            + " by shard with same shard id but was "
        return this.unassignedShards;
                remove(targetShard);
    private boolean assertInstanceNotInList(ShardRouting shard, List<ShardRouting> shards) {
                    "remove is not supported in unassigned iterator," + " use removeAndIgnore or initialize"
                        routingNode.add(shard);
        routingChangesObserver.shardStarted(initializingShard, startedShard);
            inactiveShardCount--;
     */
        }
        assert failedShard.assignedToNode() : "only assigned shards can be failed";
        return startedShard;
            assert primary == null || primary.assignedToNode() : "shard is initializing but its primary is not assigned to a node";
        private int outgoing = 0;
            Map<String, Recoveries> recoveries = new HashMap<>();
        RoutingChangesObserver changes
import org.opensearch.core.index.shard.ShardId;
        public class UnassignedIterator implements Iterator<ShardRouting>, ExistingShardsAllocator.UnassignedAllocationHandler {
    }
        }
    private static final List<ShardRouting> EMPTY = Collections.emptyList();
        addRecovery(target);
        int unassignedPrimaryCount = 0;
        if (shards.isEmpty() || shards.size() < metadata.getIndexSafe(shardId.getIndex()).getNumberOfReplicas() + 1) {
            return;
 * The OpenSearch Contributors require contributions made to
                        while (iter.hasNext()) {
                            if (result.primary() == false) {
    ) {
        inactiveShardCount++;
            assert incoming + howMany >= 0 : incoming + howMany + " must be >= 0";
            inactiveShardCount--;
    }
        assertRecoveriesPerNode(
                }
                long expectedShardSize,
                    unassignedInfo.shortSummary()
 * under the License.
     * Returns all shards that are not in the state UNASSIGNED with the same shard
import org.apache.logging.log4j.Logger;
                    || (shards != null && shards.size() == mutableShardRoutings.size() && shards.containsAll(mutableShardRoutings));
                .getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false);
        }
     * Recoveries started on node as a result of new index creation.
            }
    private static final class Recoveries {
     * - If shard is a primary, this also fails initializing replicas.
        if (routing.primary() && (primary == null || primary == routing)) {
    @PublicApi(since = "1.0.0")
                    }
                if (hasNext() == false) {
                routingChangesObserver.relocationSourceRemoved(targetShard);
        }
                    if (shardRouting.primary()) {
    }
    }
         * @opensearch.api
        public void shuffle() {
        assert node(oldShard.currentNodeId()).invariant();
                updateShardRouting(updatedShardRouting);
                }
@PublicApi(since = "1.0.0")
                            primary = shardRouting;
                if (!shardRoutings.isEmpty()) {
        assignedShardsAdd(initializedShard);
import java.util.Set;
     * Moves assigned primary to unassigned and demotes it to a replica.
             * Initializes the current unassigned shard and moves it from the unassigned list.
            ShardRouting targetShard = getByAllocationId(failedShard.shardId(), failedShard.allocationId().getRelocationId());
            @Override
            } else {
                // primary is done relocating, move non-primary recoveries from old primary to new primary
    private ShardRouting cancelRelocation(ShardRouting shard) {
        static Map<String, Recoveries> unionRecoveries(Map<String, Recoveries> first, Map<String, Recoveries> second) {
     * - If shard is an active primary, this also promotes an active replica to primary (if such a replica exists).
    }
        }
                return nodes.initializeShard(current, nodeId, existingAllocationId, expectedShardSize, routingChangesObserver);
        updateRecoveryCounts(routing, false, findAssignedPrimaryIfPeerRecovery(routing));
     * Since we aim to continue moving forward during remote store migration, replicas already migrated to remote nodes
                            unassignedInfo.getUnassignedTimeInNanos(),
    private final Map<String, Set<String>> nodesPerAttributeNames;
/*
                            routingNode.add(targetShardRouting);
        if (routing.recoverySource().getType() == RecoverySource.Type.PEER) {
            public boolean hasNext() {
                            remove(routing);
        boolean isSearchOnlyClusterBlockEnabled = false;
            if (shardRouting.allocationId().getId().equals(allocationId)) {
import java.util.function.Function;
            List<ShardRouting> shardRoutings = assignedShards.get(routing.shardId());
    public boolean hasUnassignedShards() {
        ensureMutable();
                            AllocationStatus.NO_ATTEMPT,
             * {@link #initialize(String, String, long, RoutingChangesObserver)}.
        this.nodesPerAttributeNames = Collections.synchronizedMap(new HashMap<>());
            return unassigned.isEmpty();
                }
     * @param primaryFirst true when ShardMovementStrategy = ShardMovementStrategy.PRIMARY_FIRST, false when it is ShardMovementStrategy.REPLICA_FIRST
                // The shard is a target of a relocating shard. In that case we only need to remove the target shard and cancel the source
    /**
        }
                    }
                } else {
     * the primary even though its non-primary relocation source has failed.
                UnassignedInfo unassignedInfo,
     */
            return new UnassignedIterator();
                    if (verifyOutgoingRecoveries && routing.primary() && routing.isRelocationTarget() == false) {
            }
        final List<ShardRouting> replicaSet = assignedShards.get(shardId);
            }
    public List<ShardRouting> shards(Predicate<ShardRouting> predicate) {
     * Returns <code>true</code> iff all replicas are active for the given shard routing. Otherwise <code>false</code>
                            UnassignedInfo.Reason.PRIMARY_FAILED,
                for (ShardRouting routing : new ArrayList<>(assignedShards)) {
             * @return the shard with unassigned info updated
import java.util.Collections;
            + routingNodes.inactiveShardCount
                for (ShardRouting assigned : assignedShards(routing.shardId())) {
                            0,
        // calls this method with an out-of-date RoutingNodes, where the version might not
        return reinitializedShard;
            if (shardRouting.primary() && shardRouting.active()) {
            for (int i = 0; i < e.getValue(); i++) {
     * refuses to allocate that shard's replicas onto any not-yet-upgraded node. Both replication
                    if (primaryFirst) {
        logger.debug("{} failing shard {} with unassigned info ({})", failedShard.shardId(), failedShard, unassignedInfo.shortSummary());
        ensureMutable();
            ShardRouting[] mutableShardRoutings = unassigned.toArray(new ShardRouting[0]);
    }
        void addOutgoing(int howMany) {
         */
     */
                    // to get all the shards belonging to an index, including the replicas,
    }
                        // re-resolve replica as earlier iteration could have changed source/target of replica relocation
         */
                            shard.currentNodeId(),
     * {@link org.opensearch.cluster.routing.allocation.decider.NodeVersionAllocationDecider}
                    Comparator.nullsFirst(Comparator.comparing(DiscoveryNode::getVersion))
     * @return the started shard
    private int inactiveShardCount = 0;
            return ignored.isEmpty();
     * @return the shard after cancelling relocation
                        return iter.next();
     */
            public ShardRouting next() {
            }
    private void remove(ShardRouting shard) {
        return shards;
        int getOutgoing() {
     */
     * @param attributeName The name of the awareness attribute to collect values for
                final HashSet<ShardRouting> shards = shardsByShardId.get(shardId);
             * @param attempt the result of the allocation attempt
        }
        int inactiveShardCount = 0;
        /**
    public ShardRouting activeReplicaWithHighestVersion(ShardId shardId) {
public class RoutingNodes implements Iterable<RoutingNode> {
                }
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;
        final Queue<Iterator<ShardRouting>> queue = new ArrayDeque<>();
                return current = iterator.next();
    private static boolean isNonRelocatingPrimary(ShardRouting routing) {
        updateAssigned(startedShard, source);
        }
         * This method will not drain unassigned shards.
        // TODO these are used on tests only - move into utils class
    }
     */
                    inactiveShardCount++;
    public ShardRouting activeReplicaOnRemoteNode(ShardId shardId) {
            public ShardRouting initialize(
                RoutingChangesObserver changes
        return unassigned;
        }
                            ShardRouting reinitializedReplica = reinitReplica(routing);
            return incoming;
                            }
import java.util.NoSuchElementException;
            unassigned.clear();
    public void failShard(
        assert oldShard.shardId().equals(newShard.shardId()) : "can only update "
                            primary = shardRouting;
 * Licensed to Elasticsearch under one or more contributor
            if (shard.primary()) {
     * - If shard is a (primary or replica) relocation target, this also clears the relocation information on the source shard.
            + "]";
                    @Override
    }
                            queue.poll();
        this.metadata = clusterState.getMetadata();
                            // find the relocation source
                    }
            public ShardRouting updateUnassigned(
            + "] but RoutingNodes returned unassigned primaries ["
     */
                        );
                            return shardRouting;
    }
     * Since replicas could possibly be on nodes with a higher version of OpenSearch than
                RecoverySource recoverySource,
            }
            ignored -> stream().filter(routingNodeFilter).map(r -> r.node().getAttributes().get(attributeName)).collect(Collectors.toSet())
 * GitHub history for details.
 * </ul>
     * @param attributeName The name of the awareness attribute to collect values for
     *
             * @param  recoverySource the new recovery source to use
            final Index index = e.getKey();
        assert activeReplica.started() : "replica relocation should have been cancelled: " + activeReplica;
        } else {
    private final UnassignedShards unassignedShards = new UnassignedShards(this);
     * Returns the active primary shard for the given shard id or <code>null</code> if
                            k -> new RoutingNode(shard.currentNodeId(), clusterState.nodes().get(shard.currentNodeId()))
        if (shardMovementStrategy == ShardMovementStrategy.PRIMARY_FIRST) {
                        currInfo.getFailedNodeIds()
            if (increment == false && routing.primary() && routing.relocatingNodeId() != null) {
        // TODO: check primary == null || primary.active() after all tests properly add ReplicaAfterPrimaryActiveAllocationDecider
    }
        assignedShardsAdd(target);
            }
        }
                }
    public boolean allReplicasActive(ShardId shardId, Metadata metadata) {
    }
        UnassignedInfo unassignedInfo,
     * @param shardMovementStrategy if ShardMovementStrategy.PRIMARY_FIRST, all primary shards are iterated over before iterating replica for any node
        assert node(nodeId).invariant();
        assert shard.primary() : "only primary can be demoted to replica (" + shard + ")";
        );
                    return;
        return null;
            public void removeAndIgnore(AllocationStatus attempt, RoutingChangesObserver changes) {
    private final Map<String, Recoveries> recoveriesPerNode = new HashMap<>();
        // It's possible for replicaNodeVersion to be null, when disassociating dead nodes
            activeReplica = activeReplicaOnRemoteNode(failedShard.shardId());
        String nodeId,
     */
        assert unassignedShard.unassigned() : "expected an unassigned shard " + unassignedShard;
        relocatingShards++;
        return cancelledShard;
     * @return this method always returns <code>true</code> or throws an assertion error. If assertion are not enabled
        ensureMutable();
     */
            shard = cancelRelocation(shard);
     * remaining nodes (including not-yet-upgraded ones) are able to read/replicate the
    private ShardRouting findAssignedPrimaryIfPeerRecovery(ShardRouting routing) {
            }
                        }
                }
                        return true;
    /**
/**
            }
import org.opensearch.common.Randomness;
        for (Map.Entry<String, Recoveries> recoveries : recoveriesPerNode.entrySet()) {
                throw new UnsupportedOperationException(
        List<ShardRouting> shards = assignedShards.computeIfAbsent(shard.shardId(), k -> new ArrayList<>());
            Recoveries.getOrAdd(getRecoveries(routing), primary.currentNodeId()).addOutgoing(howMany);
    public int getInitialPrimariesIncomingRecoveries(String nodeId) {
                            relocatingShards++;
            return outgoing;
     * <p>
                        shards.add(unassignedShard);
        Map<String, Recoveries> recoveriesPerNode,
        public int getNumIgnoredPrimaries() {
    }
    }
        assert previousShardIndex >= 0 : "shard to update " + oldShard + " does not exist in list of assigned shards";
    private final Map<ShardId, List<ShardRouting>> assignedShards = new HashMap<>();
        ShardRouting primaryShard = replicaShard.moveActiveReplicaToPrimary();
        }
                return false;
        if (routing.recoverySource() != null && routing.recoverySource().getType() == RecoverySource.Type.PEER) {
        shards.add(shard);
            promoteReplicaToPrimary(activeReplica, routingChangesObserver);
        Function<ShardRouting, Boolean> incomingCountFilter
        /**
            if (failedShard.primary()) {
     * Eg: "zone" : ["zone1", "zone2", "zone3"]
            return (nd != null && nd.node().isRemoteStoreNode());
     * Applies the relevant logic to start an initializing shard.
                    }
            nodes.ensureMutable();
        return replicaSet == null ? EMPTY : Collections.unmodifiableList(replicaSet);
            moveToUnassigned(failedShard, unassignedInfo);
        final Map<ShardId, HashSet<ShardRouting>> shardsByShardId = new HashMap<>();
 * <p>
            public void remove() {
    private final boolean readOnly;
             */
        ShardRouting primary = null;
    /**
                    // A replica Set might have one (and not more) replicas with the state of RELOCATING.
            if (startedShard.primary()) {
        return primaryShard;
        return sb.toString();
                            unassignedInfo.getUnassignedTimeInMillis(),
            : "shard routing to fail does not exist in routing table, expected: "
 * compatible open source license.
    public ShardRouting activePrimary(ShardId shardId) {
        assert failedShard.primary();
        assert replicaShard.isSearchOnly() == false : "search only replica cannot be promoted to primary: " + replicaShard;
            removeRecovery(shard);
        }
    /**
            .filter(shr -> !shr.primary() && shr.active() && !shr.isSearchOnly())
        assert node(failedShard.currentNodeId()).getByShardId(failedShard.shardId()) == null : "failedShard "
             * will be added back to unassigned once the metadata is constructed again).
    }
 * {@link RoutingNodes} represents a copy the routing information contained in the {@link ClusterState cluster state}.
        remove(shard);
        }
     */
                            relocateShard(
    }
        updateAssigned(shard, reinitializedShard);
    }
        }
                while (!queue.isEmpty()) {
         */
                            Collections.emptySet()
 *
        for (RoutingNode routingNode : this) {
    ) {
    public ShardRouting getByAllocationId(ShardId shardId, String allocationId) {
                    shards.add(shardRouting);
    public int getOutgoingRecoveries(String nodeId) {
             */
            // add/remove corresponding outgoing recovery on node with primary shard
        routingChangesObserver.replicaPromoted(activeReplica);
        // Assert that the active shard routing are identical.
    private void addRecovery(ShardRouting routing) {
                inactivePrimaryCount--;
                        } else if (shard.initializing()) {
     * <p>
        node(oldShard.currentNodeId()).update(oldShard, newShard);
    }
    private final Map<String, RoutingNode> nodesToShards = new HashMap<>();
        // if the activeReplica was relocating before this call to failShard, its relocation was cancelled earlier when we
            inactivePrimaryCount++;
                            routingNode = nodesToShards.computeIfAbsent(
import java.util.ArrayList;
                for (ShardRouting shard : indexShard) {
            + relocating
        ShardRouting unassigned = shard.moveToUnassigned(unassignedInfo);
        ShardRouting unassignedShard,
                            shardRoutings.offer(result);
                List<ShardRouting> assignedShards = assignedShards(startedShard.shardId());
     * Retrieves all unique values for a specific awareness attribute across all nodes
            + failedShard
                + relocationSourceShard.getTargetRelocatingShard();
        }
        Recoveries.getOrAdd(getRecoveries(routing), routing.currentNodeId()).addIncoming(howMany);
                if (predicate.test(shardRouting)) {
                routingChangesObserver.shardFailed(targetShard, unassignedInfo);
        final Queue<Iterator<ShardRouting>> queue = new ArrayDeque<>();
                    }
         * Returns <code>true</code> iff any unassigned shards are marked as temporarily ignored.
        addRecovery(initializedShard);
                    iterator.remove();
                                shard.relocatingNodeId(),
            // find the shard that is initializing on the target node
     *
            nodes.ensureMutable();
        }
    }
                shards.add(shardRouting);
        }
    public Iterator<RoutingNode> iterator() {
    private void unassignPrimaryAndPromoteActiveReplicaIfExists(
                for (ShardRouting routing : new ArrayList<>(assignedShards)) {
import java.util.Iterator;
     *
            if (shard.primary()) {
        unassignedShards.add(unassigned);
    private int relocatingShards = 0;
            // if this is not a target shard for relocation, we need to update statistics
        int inactivePrimaryCount = 0;
    }
        if (shard.initializing()) {
    }
    }
     * Used in conjunction with {@link #promoteActiveReplicaShardToPrimary} when an active replica is promoted to primary.
     * Cancels the give shard from the Routing nodes internal statistics and cancels
        }
            }
            activeReplica = activeReplicaWithOldestVersion(failedShard.shardId());
        }
         * Returns the number of temporarily marked as ignored unassigned primaries
        if (failedShard.relocating()) {
    }
            if (failedShard.primary()) {
     * Retrieves all unique values for a specific awareness attribute across filtered nodes
    }
                )
    public boolean hasUnassignedPrimaries() {
            Recoveries.getOrAdd(initialPrimaryRecoveries, routing.currentNodeId()).addIncoming(howMany);
                        currInfo.isDelayed(),
        public boolean isIgnoredEmpty() {
        /**
         */
                }
                );
                }
     */
                        currInfo.getUnassignedTimeInNanos(),
        }
            + routingNodes.unassigned().getNumIgnoredPrimaries()
        IndexMetadata idxMetadata = metadata.index(routing.index());
            return null;
        for (Map.Entry<String, RoutingNode> entry : nodesToShards.entrySet()) {
        int previousShardIndex = shardsWithMatchingShardId.indexOf(oldShard);
        List<Map.Entry<String, RoutingNode>> nodesToShardsEntrySet = new ArrayList<>(nodesToShards.entrySet());
        updateAssigned(shard, relocationMarkerRemoved);
                        UnassignedInfo primaryFailedUnassignedInfo = new UnassignedInfo(
                recoveries = new Recoveries();
                // promote active replica to primary if active replica exists
                        allocationStatus,
                        currInfo.getMessage(),
                while (!shardIterators.isEmpty()) {
        private static final Recoveries EMPTY = new Recoveries();
     * raises the primary's version, after which
    private ShardRouting started(ShardRouting shard) {
        assert shard.isRelocationTarget() == false : "replication target cannot be reinitialized: " + shard;
    /**
            }
     *                              if ShardMovementStrategy.REPLICA_FIRST, all replica shards are iterated over before iterating primary for any node
                return shardRouting;
                logger.trace(
        RoutingChangesObserver routingChangesObserver
        // Primary shard routing, excluding the relocating primaries.
        return initialPrimaryRecoveries.getOrDefault(nodeId, Recoveries.EMPTY).getIncoming();
    private void assignedShardsAdd(ShardRouting shard) {
        if (replicaSet == null) {
import java.util.function.Predicate;
        updateAssigned(shard, startedShard);
            public boolean hasNext() {
                return new Iterator<ShardRouting>() {
             */
import org.opensearch.core.index.Index;
            return ignoredPrimaries;
            primaries = 0;
    ) {
     *
            ignoredPrimaries = 0;
    }
         *
             *
                assert sourceShard.isRelocationSourceOf(failedShard);
        /**
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
     * @deprecated no longer used for primary promotion. Promoting the highest-version replica
            return Collections.unmodifiableList(ignored);
        }
                        }
             *
                    }
        }
            ShardRouting relocationSourceShard = relocationSourceNode.getByShardId(initializingShard.shardId());
 */
     * Moves the initializing shard to started. If the shard is a relocation target, also removes the relocation source.
         * The list of ignored unassigned shards (read only). The ignored unassigned shards
            String nodeId = cursor.getId();
    /**
     *
        /**
    }
        public ShardRouting[] drainIgnored() {
                Iterator<ShardRouting> replicaIterator = shardIterators.poll();
                Recoveries r2 = newRecoveries.get(node);
            + unassignedIgnoredPrimaryCount
     *   relocation source information. This is possible as peer recovery is always done from the primary.
                    queue.poll();
                        if (iter.hasNext()) {
                iterator.remove();
            + "] but RoutingNodes returned inactive primaries ["
                    shardIterators.poll();
                        Map<String, Recoveries> recoveriesToUpdate = getRecoveries(assigned);
        routingChangesObserver.shardInitialized(unassignedShard, initializedShard);
        for (ShardRouting shard : routingNodes.unassigned().ignored()) {
        }
            return initialReplicaRecoveries;
    }
            .filter(shr -> node(shr.currentNodeId()) != null)
                        }
 * KIND, either express or implied.  See the License for the
                            null,
                        assert replicaShard != null : "failed to re-resolve " + routing + " when failing replicas";
         */
        public int size() {
                return iterator.hasNext();
        public void ignoreShard(ShardRouting shard, AllocationStatus allocationStatus, RoutingChangesObserver changes) {
        unassignedShards.add(unassigned);
     * shard as well as assigning it.
                    // initializing shard that is not relocation target, just move to unassigned
    public boolean hasInactiveShards() {
        for (RoutingNode node : routingNodes) {
        // used only for tests
            + newShard;
         * Drains all ignored shards and returns it.
                        );
        for (ShardRouting shardEntry : unassignedShards) {
         */
         * Returns the size of the non-ignored unassigned shards
            }
 * <li> {@link #relocateShard} starts relocation of a started shard.
                return buildIteratorForMovementStrategy(false);
                final List<ShardRouting> mutableShardRoutings = routingNodes.assignedShards(shardId);
        ensureMutable();
                for (ShardRouting shardRouting : shardRoutings) {
            @Override
                map.put(key, recoveries);
                unassignPrimaryAndPromoteActiveReplicaIfExists(failedShard, unassignedInfo, routingChangesObserver);
                assert currInfo != null;
                        Recoveries.getOrAdd(recoveriesToUpdate, routing.currentNodeId()).addOutgoing(1);
        }
         * are not part of the formal unassigned list, but are kept around and used to build
            }
                }
         * back the list of unassigned shards as part of the routing table.
     */
         * Returns <code>true</code> iff this collection contains one or more non-ignored unassigned shards.
        final List<ShardRouting> replicaSet = assignedShards.get(shard.shardId());
                changes.unassignedInfoUpdated(current, unassignedInfo);
    public Tuple<ShardRouting, ShardRouting> relocateShard(
     */
        } else {
                            throw new NoSuchElementException();
            }
        return nodesToShards.get(nodeId);
            ) {
 * this file be licensed under the Apache-2.0 license or a
        // TODO these are used on tests only - move into utils class
                    public ShardRouting next() {
                                queue.offer(iter);
    }
                break;
                return false;
                return updatedShardRouting;
 * license agreements. See the NOTICE file distributed with
        // if this is a primary, fail initializing replicas first (otherwise we move RoutingNodes into an inconsistent state)
            // if this is a primary shard with ongoing replica recoveries, reinitialize them as their recovery source changed
        // that have been removed, the shards are failed, and part of the shard failing
        } else {
                        assignedShardsAdd(shard);
     * Returns <code>true</code> iff this {@link RoutingNodes} instance has any unassigned shards even if the
            }
                ignoreShard(current, attempt, changes);
            )
        if (isMigratingToRemoteStore(metadata)) {
        }
        ShardRouting activeReplica = null;
                    }
        // fail actual shard
            this.nodesToShards.put(cursor.getId(), new RoutingNode(nodeId, clusterState.nodes().get(nodeId)));
            }
        assert getByAllocationId(failedShard.shardId(), failedShard.allocationId().getId()) == failedShard
        long expectedSize,
}
                nodes.ensureMutable();
        }
        if (shard.initializing() && shard.relocatingNodeId() == null) {
            private ShardRouting current;
    public int getIncomingRecoveries(String nodeId) {
        }
                // cancel and remove target shard
            RoutingNode relocationSourceNode = node(initializingShard.relocatingNodeId());
        return recoveriesPerNode.getOrDefault(nodeId, Recoveries.EMPTY).getOutgoing();
    }
        return routing.primary() && routing.relocatingNodeId() == null;
     * @opensearch.internal
                String nodeId,
     * Returns one active replica shard for the given shard id or <code>null</code> if
                if (allocationStatus.equals(currInfo.getLastAllocationStatus()) == false) {
     * the primary is, this will return replicas on the highest version of OpenSearch.
        // fill in the nodeToShards with the "live" nodes
        return inactivePrimaryCount > 0;
                ignoredPrimaries++;
            shards.addAll(routingNode.shardsWithState(index, state));
        if (failedShard.primary()) {
            }
 * or disallowing changes to its elements.
        final List<ShardRouting> replicaSet = assignedShards.get(shardId);
        private final List<ShardRouting> unassigned;
        return nodesToShards.values().iterator();
        if (initializingShard.relocatingNodeId() != null) {
                );
                        } else if (primary == null) {
        return startedShard;
            // new primary stays at the minimum version present, keeping it a valid recovery source/target for
 * ownership. Elasticsearch licenses this file to you under
                for (ShardRouting routing : routingNode) {
            if (shardRoutings != null) {
                return replicaShard;
                assert (shards == null && mutableShardRoutings.size() == 0)
            + routingNodes.getRelocatingShardCount()
            return primaries;
            ) {
        private int ignoredPrimaries = 0;
        for (ShardRoutingState s : state) {
                }
        for (final Map.Entry<Index, Integer> e : entries) {
    }
/*
                ShardRouting updatedShardRouting = current.updateUnassigned(unassignedInfo, recoverySource);
            }
 * this work for additional information regarding copyright
    /**
    private void addInitialRecovery(ShardRouting routing, ShardRouting initialPrimaryShard) {
     * in the cluster to ensure the book-keeping is correct.
                                return true;
     * the first node, then the first shard of the second node, etc. until one shard from each node has been returned.
                }
        }
        }
                UnassignedInfo currInfo = shard.unassignedInfo();
    }
        String nodeId,
        }
        public void add(ShardRouting shardRouting) {
        promoteActiveReplicaShardToPrimary(activeReplica);
            assert incoming == value.incoming : incoming + " != " + value.incoming + " node: " + routingNode;
    }
 * You may obtain a copy of the License at
                    if (unassignedShard.index().getName().equals(index)) {
        ShardRouting unassigned = shard.moveToUnassigned(unassignedInfo).moveUnassignedFromPrimary();
            .min(
                    }
            assert inactiveShardCount >= 0;
        assert shard.unassigned() == false : "only assigned shards can be moved to unassigned (" + shard + ")";
    /**
            }
            queue.add(entry.getValue().copyShards().iterator());
    }
                logger.trace("{} is removed due to the failure/cancellation of the source shard", targetShard);
     * <p>
            private final ListIterator<ShardRouting> iterator;
        shardsWithMatchingShardId.set(previousShardIndex, newShard);
        // also fill replicaSet information
        sb.append("---- unassigned\n");
    /**
        ShardRouting reinitializedShard = shard.reinitializeReplicaShard();
                }
        RoutingNodes routingNodes,
        return Tuple.tuple(source, target);
     * @see UnassignedShards#isIgnoredEmpty()
        }
                    if (shardIterators.peek().hasNext()) {
                            );
package org.opensearch.cluster.routing;
     * If the started shard is a primary relocation target, this also reinitializes currently initializing replicas as their
        for (ShardRouting shard : routingNodes.unassigned()) {
                    changes.unassignedInfoUpdated(shard, newInfo);
    ) {
            return recoveriesPerNode;
            if (!shard.active()) {
            RoutingNode routingNode = routingNodes.nodesToShards.get(node);
                r1.addOutgoing(r2.outgoing);
            }
                    shr -> node(shr.currentNodeId()).node(),
            movePrimaryToUnassignedAndDemoteToReplica(failedShard, unassignedInfo);
            private Queue<ShardRouting> shardRoutings = new ArrayDeque<>();
            if (s == ShardRoutingState.UNASSIGNED) {
            }
     * Recoveries started from node as a result of new index creation.
            + " by shard assigned to same node but was "
            if (primary == null) {
            x -> !isNonRelocatingPrimary(x)
        return initialReplicaRecoveries.getOrDefault(nodeId, Recoveries.EMPTY).getOutgoing();
                                new UnassignedInfo(UnassignedInfo.Reason.REINITIALIZED, "primary changed")
                            addInitialRecovery(targetShardRouting, indexShard.primary);
    }
    public ShardRouting initializeShard(
                // promote to initializing shard without relocation source and ensure that removed relocation source
    }
                    if (queue.peek().hasNext()) {
import java.util.List;
                    remove(failedShard);
 * <ul>
             * Removes and ignores the unassigned shard (will be ignored for this run, but
            } else {
             * Unsupported operation, just there for the interface. Use
            addRecoveries(recoveries, second);
        return initialReplicaRecoveries.getOrDefault(nodeId, Recoveries.EMPTY).getIncoming();
            isSearchOnlyClusterBlockEnabled = idxMetadata.getSettings()
                        Iterator<ShardRouting> iter = queue.poll();
            for (IndexShardRoutingTable indexShard : indexRoutingTable) {
            /**
            // any not-yet-upgraded node during a rolling upgrade.
     *
            return mutableShardRoutings;
                    Iterator<ShardRouting> iter = queue.poll();
    }
            }
            .max(
         */
                    }
                    moveToUnassigned(failedShard, unassignedInfo);
                    failedShard,
                    } else {
    /**
        public int getNumPrimaries() {
                    if (!routing.primary() && routing.initializing()) {
import org.opensearch.cluster.metadata.IndexMetadata;
            outgoing += howMany;
    }
            }
    private ShardRouting reinitReplica(ShardRouting shard) {
     * Returns one active replica shard on a remote node for the given shard id or <code>null</code> if
        Logger logger,
                        }
                        currInfo.getUnassignedTimeInMillis(),
        ShardRouting source = startedShard.relocate(nodeId, expectedShardSize);
import java.util.HashMap;
                            shardIterators.offer(iter);
             */
        for (final RoutingNode routingNode : routingNodes) {
        }
        ShardRouting failedShard,
                + " but was: "
    public List<ShardRouting> shardsWithState(ShardRoutingState... state) {
    public Set<String> nodesPerAttributesCounts(String attributeName, Predicate<RoutingNode> routingNodeFilter) {
        ensureMutable();
            return mutableShardRoutings;
        void addIncoming(int howMany) {
        @Nullable String existingAllocationId,
    }
    }
     * no primary is found or the primary is not active.
            + "] but expected ["
                logger.trace(
                    new ShardId(shardRouting.index(), shardRouting.id()),
        return nodesPerAttributeNames.computeIfAbsent(
     * Removes relocation source of an initializing non-primary shard. This allows the replica shard to continue recovery from
            + "] but RoutingNodes returned inactive shards ["
                boolean isSearchOnlyClusterBlockEnabled = false;
        return unassignedShards.isEmpty() == false || unassignedShards.isIgnoredEmpty() == false;
            }
                unassignedPrimaryCount++;
            remove(relocationSourceShard);
    }
            unassigned = new ArrayList<>();
            assert relocationSourceShard.getTargetRelocatingShard() == initializingShard : "relocation target mismatch, expected: "
        }
                }
            .orElse(null);
        assignedShardsRemove(shard);
                    isSearchOnlyClusterBlockEnabled = idxMetadata.getSettings()
            }
            for (ShardRouting shard : node) {
    /**
        assert shard.initializing() : "expected an initializing shard " + shard;
     * @return A set of unique attribute values for the specified attribute
         * Drains all unassigned shards and returns it.
    public Stream<RoutingNode> stream() {
    @Nullable
        }
                        RoutingNode routingNode = this.nodesToShards.computeIfAbsent(
import java.util.Queue;
                throw new IllegalStateException("shard is peer recovering but primary is unassigned");
        for (ShardRouting shardRouting : assignedShards(shardId)) {
            .filter(shr -> node(shr.currentNodeId()) != null)
     * Applies the relevant logic to handle a cancelled or failed shard.
 * specific language governing permissions and limitations
import java.util.ArrayDeque;
                        ShardRouting replicaShard = getByAllocationId(routing.shardId(), routing.allocationId().getId());
 */
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
        for (RoutingNode routingNode : this) {
    public String toString() {
        }
import java.util.Map;
        public ShardRouting[] drain() {
                    primaries--;
        List<ShardRouting> shardsWithMatchingShardId = assignedShards.computeIfAbsent(oldShard.shardId(), k -> new ArrayList<>());
        };
                            assignedShardsAdd(targetShardRouting);
        assert oldShard.currentNodeId().equals(newShard.currentNodeId()) : "shard to update "
                    if (routing.initializing() && incomingCountFilter.apply(routing)) incoming++;
                        && assigned.recoverySource().getType() == RecoverySource.Type.PEER) {
                    UnassignedInfo newInfo = new UnassignedInfo(
        List<ShardRouting> shards = new ArrayList<>();
        return nodesToShards.values().stream();
            + " can only update "
            ignored.add(shard);
import java.util.stream.Collectors;
            if (s == ShardRoutingState.UNASSIGNED) {
            + oldShard
            if (shard.primary()) {
     * recovery source changes
        assert false : "No shard found to remove";
        }
                        if (routing.isRelocationTarget()) {
        return assignedShards(shardId).stream().filter(shr -> !shr.primary() && shr.active() && !shr.isSearchOnly()).filter((shr) -> {
                        if (shardRouting.active()) {
                        }
 * The main methods used to update routing entries are:
            /**
import org.opensearch.core.Assertions;
 * <li> {@link #failShard} fails/cancels an assigned shard.
    public static boolean assertShardStats(RoutingNodes routingNodes) {
                            ShardRouting result = iter.next();
            }
            while (iterator.hasNext()) {
        }
    private Map<String, Recoveries> getRecoveries(ShardRouting routing) {
        }
        // (meaning the node will be going away).
        assert shard.primary() == false : "shard must be a replica: " + shard;
            @Override
    }
        /**
            }
            assert s != shard;
     */
    }
        if (initializedShard.primary()) {
        for (ShardRoutingState s : state) {
     * - If shard is a relocating replica, this promotes the replica relocation target to a full initializing replica, removing the
            .filter(shr -> !shr.primary() && shr.active() && !shr.isSearchOnly())
                                sourceShard.getExpectedShardSize(),
        for (ShardRouting shardRouting : replicaSet) {
    }
 *
            return false; // if we are empty nothing is active if we have less than total at least one is unassigned
                            routingChangesObserver.initializedReplicaReinitialized(routing, reinitializedReplica);
                RoutingChangesObserver routingChangesObserver
        private final RoutingNodes nodes;
        private int primaries = 0;
            + unassignedPrimaryCount
        /**
        }
    @Nullable
import org.opensearch.common.Nullable;
                }
import org.opensearch.common.collect.Tuple;
    /**
    }
    public ShardRouting activeReplicaWithOldestVersion(ShardId shardId) {
     */
            Randomness.shuffle(unassigned);
        final List<ShardRouting> shards = assignedShards(shardId);
            }
                nodes.ensureMutable();
            + oldShard
                    ShardRouting updatedShard = shard.updateUnassigned(newInfo, shard.recoverySource());
                            }
     *
            if (assignedShards.isEmpty() == false) {
            for (final ShardRouting shardRouting : routingNode) {
                + failedShard
                            routingChangesObserver.shardFailed(
                if (!shardRoutings.isEmpty()) {
    public Iterator<RoutingNode> mutableIterator() {
        assert inactivePrimaryCount == routingNodes.inactivePrimaryCount : "Inactive Primary count ["
            }
        return null;
     */
import org.opensearch.cluster.metadata.Metadata;
         * @see #ignored()
        }
    }
        public UnassignedIterator iterator() {
        UnassignedInfo unassignedInfo,
            /**
                logger.trace("{}, relocation source failed / cancelled, mark as initializing without relocation source", targetShard);
     * <p>
     * Cancels a relocation of a shard that shard must relocating.
                    }
                            }
        Randomness.shuffle(nodesToShardsEntrySet);
            + "] but RoutingNodes returned unassigned ignored primaries ["
                                routingChangesObserver
     * @return A set of unique attribute values for the specified attribute
    }
    /**
            @Override
        assert inactiveShardCount == routingNodes.inactiveShardCount : "Inactive Shard count ["
            return recoveries;
                        failShard(logger, replicaShard, primaryFailedUnassignedInfo, indexMetadata, routingChangesObserver);
                remove(failedShard);
                                startedReplica,
            public void remove() {
    }
        if (activeReplica == null) {
    public List<ShardRouting> assignedShards(ShardId shardId) {
    public int getInitialIncomingRecoveries(String nodeId) {
                }
    private ShardRouting removeRelocationSource(ShardRouting shard) {
     * The iterator then resumes on the first node by returning the second shard and continues until all shards from
            nodes.ensureMutable();
                        Recoveries.getOrAdd(recoveriesToUpdate, routing.relocatingNodeId()).addOutgoing(-1);
    }
    /**
        }
            + oldShard
    public UnassignedShards unassigned() {
             * Typically this is used when an allocation decision prevents a shard from being allocated such
         * Should be used with caution, typically,
 * <li> {@link #initializeShard} initializes an unassigned shard.
    @Deprecated
    private void updateAssigned(ShardRouting oldShard, ShardRouting newShard) {
 * It can be either initialized as mutable or immutable (see {@link #RoutingNodes(ClusterState, boolean)}), allowing
     * are preferred for primary promotion
                if (shard == iterator.next()) {
 * the Apache License, Version 2.0 (the "License"); you may
                    unassignedInfo.shortSummary()
        updateAssigned(shard, cancelledShard);
     */
import org.opensearch.cluster.node.DiscoveryNode;
        }
     *
                throw new UnsupportedOperationException();
                    Comparator.nullsFirst(Comparator.comparing(DiscoveryNode::getVersion))
        }
                + initializingShard
                )
                @Nullable String existingAllocationId,
                    if (shard.assignedToNode()) {
                }
     * <p>
                ShardRouting replicaShard = replicaIterator.next();
     * Moves the shard to unassigned or completely removes the shard (if relocation target).
            + "]";
        assert routingNodes.getRelocatingShardCount() == relocating : "Relocating shards mismatch ["
                            shardIterators.offer(iter);
                            if (assigned.initializing() && assigned.recoverySource().getType() == RecoverySource.Type.PEER) {
             * that subsequent consumers of this API won't try to allocate this shard again.
        updateRecoveryCounts(routing, true, initialPrimaryShard);
        if (replicaSet != null) {
        List<ShardRouting> shards = new ArrayList<>();
                innerRemove();
    public RoutingNode node(String nodeId) {
            ShardRouting[] mutableShardRoutings = ignored.toArray(new ShardRouting[0]);
         */
            }
        }
        this(clusterState, true);
     * @return             the resulting primary shard
            }
                                queue.offer(iter);
 * software distributed under the License is distributed on an
        this.searchNodesPerAttributeNames = Collections.synchronizedMap(new HashMap<>());
                        if (shard.relocating()) {
                        }
    }
            + newShard;
             * @param  unassignedInfo the new unassigned info to use
            int incoming = 0;
 *
    public static final class UnassignedShards implements Iterable<ShardRouting> {
        RoutingChangesObserver routingChangesObserver
        assert shard.unassigned() == false : "only assigned shards can be moved to unassigned (" + shard + ")";
                if (i == null) {
                        queue.offer(iter);
import org.opensearch.common.annotation.PublicApi;
                                sourceShard.relocatingNodeId(),
        node(shard.currentNodeId()).remove(shard);
     */
        for (final DiscoveryNode cursor : clusterState.nodes().getDataNodes().values()) {
     * Mark a shard as started and adjusts internal statistics.
                }
     * <p>
            routingChangesObserver.relocationCompleted(relocationSourceShard);
     */
    public int size() {
     * Relocate a shard to another node, adding the target initializing
    }
                unassigned().forEach(shards::add);
        @Override
            if (recoveries == null) {
     * - If shard is a relocating primary, this also removes the primary relocation target shard.
        updateRecoveryCounts(routing, true, findAssignedPrimaryIfPeerRecovery(routing));
                }
            + "]";
        ShardRouting target = source.getTargetRelocatingShard();
     * Returns the number of routing nodes
                    return shardRoutings.poll();
        }
     * Creates an iterator over shards interleaving between nodes: The iterator returns the first shard from
                break;
        }
     * Returns <code>true</code> iff this {@link RoutingNodes} instance has any unassigned primaries even if the
        private final List<ShardRouting> ignored;
                    unassignPrimaryAndPromoteActiveReplicaIfExists(failedShard, unassignedInfo, routingChangesObserver);
            assert targetShard.isRelocationTargetOf(failedShard);
                        currInfo.getFailure(),
    }
            private void updateShardRouting(ShardRouting shardRouting) {
            }
            sb.append("--------").append(shardEntry.shortSummary()).append('\n');
            // relocation target has been started, remove relocation source
                };
                        && assigned.initializing()
            nodes.ensureMutable();
        node(target.currentNodeId()).add(target);
                    }
    private static void assertRecoveriesPerNode(
        return nodesPerAttributesCounts(attributeName, routingNode -> true);
            // we might not find any replica on remote node
             * updates the unassigned info and recovery source on the current unassigned shard
        for (ShardRouting shard : shards) {
        assert unassignedIgnoredPrimaryCount == routingNodes.unassignedShards.getNumIgnoredPrimaries() : "Unassigned ignored primaries is ["
     * @return the started shard
            final Iterator<ShardRouting> iterator = replicaSet.iterator();
        // be accessible. Therefore, we need to protect against the version being null
                }
                            // it's relocating from.
        boolean verifyOutgoingRecoveries,
            queue.add(entry.getValue().copyShards().iterator());
        }
     * types now promote via {@link #activeReplicaWithOldestVersion(ShardId)}.
                Recoveries r1 = Recoveries.getOrAdd(existingRecoveries, node);
        StringBuilder sb = new StringBuilder("routing_nodes:\n");
        node(nodeId).add(initializedShard);
        }
            + " was matched but wasn't removed";
                if (current.primary()) {
                primaries++;
                );
                        currInfo.getNumFailedAllocations(),
    }
        return true;
        if (failedShard.initializing()) {
                IndexMetadata idxMetadata = metadata.index(indexShard.shardId().getIndex());
    private int inactivePrimaryCount = 0;
                    }
    public int getInitialOutgoingRecoveries(String nodeId) {
            return buildIteratorForMovementStrategy(true);
            }
        public static Recoveries getOrAdd(Map<String, Recoveries> map, String key) {
            private Queue<Iterator<ShardRouting>> shardIterators = new ArrayDeque<>();
             * @param existingAllocationId allocation id to use. If null, a fresh allocation id is generated.
 */
            if (shardMovementStrategy == ShardMovementStrategy.REPLICA_FIRST) {
        final RoutingTable routingTable = clusterState.routingTable();
            true,
 * <li> {@link #startShard} starts an initializing shard / completes relocation of a shard.
    public List<ShardRouting> shardsWithState(String index, ShardRoutingState... state) {
 * Modifications Copyright OpenSearch Contributors. See
                final ShardId shardId = new ShardId(index, i);
                    i = shard.id();
        assert routing.initializing() : "routing must be initializing: " + routing;
        inactiveShardCount++; // relocation targets are not counted as inactive shards whereas initializing shards are
        }
    /**
                            false,
        // It's possible for replicaNodeVersion to be null. Therefore, we need to protect against the version being null
        }
            return recoveries;
        int getIncoming() {
     * @see UnassignedShards#isEmpty()
                                outgoing++;
        return assignedShards(shardId).stream()
                            );
            /**
            RoutingNode nd = node(shr.currentNodeId());
            + routingNodes.unassigned().getNumPrimaries()
    private void updateRecoveryCounts(final ShardRouting routing, final boolean increment, @Nullable final ShardRouting primary) {
        }
    /**
     * Since replicas could possibly be on nodes with an older version of OpenSearch than
        remove(shard);
     * @opensearch.api
     * shards are marked as temporarily ignored.
    private final Map<String, Set<String>> searchNodesPerAttributeNames;
 *
            for (ShardRouting shardRouting : routingNode) {
    private void assignedShardsRemove(ShardRouting shard) {
            this.nodes = nodes;
                }
     * @param existingAllocationId allocation id to use. If null, a fresh allocation id is generated.
        for (final IndexRoutingTable indexRoutingTable : routingTable.indicesRouting().values()) {
        int unassignedIgnoredPrimaryCount = 0;
    public Iterator<ShardRouting> nodeInterleavedShardIterator(ShardMovementStrategy shardMovementStrategy) {
            + inactiveShardCount
        assert assertInstanceNotInList(shard, shards) : "shard " + shard + " cannot appear twice in list of assigned shards";
