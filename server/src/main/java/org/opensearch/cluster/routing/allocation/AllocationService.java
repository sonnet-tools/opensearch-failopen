                getAllocatorForShard(shardRouting, allocation).allocateUnassigned(shardRouting, allocation, primaryIterator);
    public static <T> String firstListElementsToCommaDelimitedString(
            routingNodes,
        this.clusterManagerMetrics = clusterManagerMetrics;
    }
    public void setExistingShardsAllocators(Map<String, ExistingShardsAllocator> existingShardsAllocators) {
     * provided as parameter and no duplicates should be contained.
        // Replicas Assignment
            clusterInfoService.getClusterInfo(),
import java.util.stream.Collectors;
     * Applies the failed shards. Note, only assigned ShardRouting instances that exist in the routing table should be
     * provided as parameter. Also applies a list of allocation ids to remove from the in-sync set for shard copies for which there
            final ClusterState fixedState = ClusterState.builder(clusterState)
            routingNodes,
    public static class CommandsResult {
                    unassignedIterator.updateUnassigned(
import org.opensearch.cluster.ClusterState;
        GatewayAllocator gatewayAllocator,
    }
     * Reroutes the routing table based on the live nodes.
import org.opensearch.gateway.GatewayAllocator;
        assert assertInitialized();
            snapshotsInfoService.snapshotShardSizes(),
        // so, there will always be shard "movements", so no need to check on reroute
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
    private void resetFailedAllocationCounter(RoutingAllocation allocation) {
                    unassignedInfo.getNumFailedAllocations() > 0 ? UnassignedInfo.Reason.MANUAL_ALLOCATION : unassignedInfo.getReason(),
                        discoveryNode,
    }
        assert startedShardEntries.isEmpty() == false : "non-empty list of started shard entries expected";
        /*
     */
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to
            );
    }
                + elements.size()
            settings
 */
                new UnassignedInfo(
                if (failedShard != shardToFail) {
     * @opensearch.internal
                            unassignedInfo.getMessage(),
                // operation which make these copies stale
            final List<NodeAllocationResult> nodeAllocationResults = new ArrayList<>(allocation.nodes().getSize());
         */
        AllocationDeciders allocationDeciders,
                    1 + indexMetadata.getSettingsVersion()
            allocatorName = ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_SETTING.get(
    }
 * Unless required by applicable law or agreed to in writing,
                        new UnassignedInfo(
import org.opensearch.cluster.RestoreInProgress;
import org.opensearch.cluster.metadata.AutoExpandReplicas;
            allocationDeciders,
                        null,
        ClusterState newState = buildResult(oldState, allocation);
        } else {
        }
            // now, go over all the shards routing on the node, and fail them
                // operation which make these copies stale
            }
import org.opensearch.cluster.routing.RoutingNodes;
        ShardsAllocator shardsAllocator,
        }
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at
        );
                routingAllocation.metadata().getIndexSafe(shardRouting.index()).getSettings()
            clusterInfoService.getClusterInfo(),
import static java.util.Collections.emptyList;
                metadataBuilder.updateNumberOfSearchReplicas(numberOfSearchReplicas, indices);
     * if needed.
            allocationDeciders,
    public ClusterState disassociateDeadNodes(ClusterState clusterState, boolean reroute, String reason) {
                            unassignedInfo.getLastAllocationStatus(),
 * {@link AllocationService} keeps {@link AllocationDeciders} to choose nodes
    }
        }
            settings
        // this allows systems to dry run the commands, see the resulting cluster state, and act on it
                    logger.trace(
                    allocation.removeAllocationId(failedShard);
    /**
            return elements.stream().limit(maxNumberOfElements).map(formatter).collect(Collectors.joining(", "))
        assert assertInitialized();
        assert hasDeadNodes(allocation) == false : "dead nodes should be explicitly cleaned up. See disassociateDeadNodes";
    }
        RoutingNodes routingNodes = routingAllocation.routingNodes();
        );
        Optional.ofNullable(allocator.allocateAllUnassignedShards(allocation, true)).ifPresent(Runnable::run);
        this.clusterInfoService = clusterInfoService;
             */
        final List<FailedShard> failedShards,
    }
            }
                updatedIndices.addAll(Set.of(indices));
     * @return A comma-separated string of the first few elements.
    private SnapshotsInfoService snapshotsInfoService;
            allocation
                    delayed,
            allocator.applyFailedShards(failedShards, allocation);
                    unassignedInfo.getFailure(),
        RoutingNodes routingNodes = getMutableRoutingNodes(tmpState);
    /** override this to control time based decisions during allocation */
        for (RoutingNode routingNode : allocation.routingNodes()) {
    ) {
                    allocation.getCurrentNanoTime(),
        final Metadata metadata = allocation.metadata();
        @Override
            clusterInfoService.getClusterInfo(),
        allocation.routingNodes().unassigned().sort(PriorityComparator.getAllocationComparator(allocation)); // sort for priority ordering
        );
        removeDelayMarkers(allocation);
     * Returns an updated cluster state if changes were necessary, or the identical cluster if no changes were required.
 * not use this file except in compliance with the License.
        final ExistingShardsAllocator existingShardsAllocator = existingShardsAllocators.get(allocatorName);
            && routingAllocation.nodes().getMinNodeVersion().onOrAfter(Version.V_2_14_0)
    }
        final ClusterState clusterState,
        }
        assert assertInitialized();
        assert assertInitialized();
        final RoutingNodes.UnassignedShards.UnassignedIterator unassignedIterator = allocation.routingNodes().unassigned().iterator();
        Function<T, String> formatter,
        );
        );
 * GitHub history for details.
    private boolean hasDeadNodes(RoutingAllocation allocation) {
        ExistingShardsAllocator allocator = existingShardsAllocators.get(ShardsBatchGatewayAllocator.ALLOCATOR_NAME);
            return decision;
                            unassignedInfo.getReason(),
            // failing a primary also fails initializing replica shards, re-resolve ShardRouting
     *
            }
            return 0;
        RoutingNodes routingNodes = getMutableRoutingNodes(clusterState);
        ClusterState fixedClusterState = adaptAutoExpandReplicas(clusterState);
            ShardRouting shardToFail = failedShardEntry.getRoutingEntry();
        this.settings = settings;
        }
    }
            clusterState,
                    )
                    + startedShard
            }
                    unassignedInfo.getMessage(),
        }
 * this file be licensed under the Apache-2.0 license or a
        }
        }
        }
        public AllocateUnassignedDecision explainUnassignedShardAllocation(ShardRouting unassignedShard, RoutingAllocation allocation) {
        public void beforeAllocation(RoutingAllocation allocation) {}
            UnassignedInfo unassignedInfo = shardRouting.unassignedInfo();
                // we do *not* update the in sync allocation ids as they will be removed upon the first index
                    allocation.getCurrentNanoTime(),
    private AllocateUnassignedDecision explainUnassignedShardAllocation(ShardRouting shardRouting, RoutingAllocation routingAllocation) {
        assert this.existingShardsAllocators == null : "cannot set allocators " + existingShardsAllocators + " twice";
        if (fixedClusterState == clusterState && allocation.routingNodesChanged() == false) {
                    Collections.emptySet()
    /**
    private void allocateAllUnassignedShards(RoutingAllocation allocation) {
         * the resulting cluster state, after the commands were applied
            final ShardRouting shardRouting = primaryIterator.next();
        final ClusterState.Builder newStateBuilder = ClusterState.builder(oldState).routingTable(newRoutingTable).metadata(newMetadata);
        // shuffle the unassigned nodes, just so we won't have things like poison failed shards
        reroute(allocation);
        assert routingAllocation.debugDecision();
    // only for tests that use the GatewayAllocator as the unique ExistingShardsAllocator
    }
        assert existingShardsAllocators != null : "must have set allocators first";
         */
            snapshotsInfoService.snapshotShardSizes(),
        ClusterInfoService clusterInfoService,
import org.opensearch.cluster.routing.UnassignedInfo;
            clusterInfoService,
     * Internal helper to cap the number of elements in a potentially long list for logging.
        // we revert the ignore disable flag, since when rerouting, we want the original setting to take place
        );
                    .nanos() > 0;
        } else {
 * Modifications Copyright OpenSearch Contributors. See
     * @param <T>       The list element type.
    /**
            return clusterState;
        public void afterPrimariesBeforeReplicas(RoutingAllocation allocation) {}
        while (unassignedIterator.hasNext()) {
    ) {
import java.util.function.Function;
                final int numberOfSearchReplicas = entry.getKey();
            && existingShardsAllocators.size() == 2;
                updatedIndices.addAll(Set.of(indices));
            return clusterState;
    }
                    AllocationStatus.NO_ATTEMPT,
            assert AutoExpandSearchReplicas.getAutoExpandSearchReplicaChanges(fixedState.metadata(), allocation).isEmpty();
         * @param explanations Explanation for the reroute actions
                            unassignedInfo.getUnassignedTimeInNanos(),
        disassociateDeadNodes(allocation);
                shardRouting.recoverySource(),
        RoutingAllocation allocation = new RoutingAllocation(
            ShardRouting failedShard = routingNodes.getByAllocationId(shardToFail.shardId(), shardToFail.allocationId().getId());
                allocation.routingNodes().failShard(logger, shardRouting, unassignedInfo, indexMetadata, allocation.changes());
        reroute(allocation);
import org.apache.logging.log4j.LogManager;
    // Used for testing
 * ownership. Elasticsearch licenses this file to you under
            return clusterState;
import java.util.Collections;
            : AllocateUnassignedDecision.NOT_TAKEN;
                UnassignedInfo unassignedInfo = UnassignedInfo.failedShard(
     */
        ClusterInfoService clusterInfoService,
        RoutingAllocation allocation = new RoutingAllocation(
                    System.currentTimeMillis(),
import org.opensearch.cluster.routing.ShardRouting;
            logger.info("Cluster health status changed from [{}] to [{}] (reason: [{}]).", previousHealth, currentHealth, reason);
        return true;
        }
import java.util.Comparator;
        final RoutingNodes.UnassignedShards.UnassignedIterator replicaIterator = allocation.routingNodes().unassigned().iterator();
     *
            startedShards,
     */
     *
            shardsAllocator,
            ShardRouting shardRouting,
        // the assumption is that commands will move / act on shards (or fail through exceptions)
            settings
        return false;
            fixedClusterState,
    }
            clusterState,
            RestoreInProgress updatedRestoreInProgress = allocation.updateRestoreInfoWithRoutingChanges(restoreInProgress);
        routingNodes.unassigned().shuffle();
            final Set<String> updatedIndices = new HashSet<>();
         * Get the explanation of this result
            final Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());
                getAllocatorForShard(shardRouting, allocation).allocateUnassigned(shardRouting, allocation, replicaIterator);
 */
        ClusterManagerMetrics clusterManagerMetrics
        // first, clear from the shards any node id they used to belong to that is now dead
        SnapshotsInfoService snapshotsInfoService,
        @Override
        final RoutingTable oldRoutingTable = oldState.routingTable();
            }
        allocation.ignoreDisable(false);
     * Create a mutable {@link RoutingNodes}. This is a costly operation so this must only be called once!
        return existingShardsAllocators.values().stream().mapToInt(ExistingShardsAllocator::getNumberOfInFlightFetches).sum();
    }
            routingNodes,
        final int maxNumberOfElements = 10;
            snapshotsInfoService,
        final Map<Integer, List<String>> autoExpandReplicaChanges = AutoExpandReplicas.getAutoExpandReplicaChanges(
     * are no routing entries in the routing table.
                logger.info("updating number_of_search_replicas to [{}] for indices {}", numberOfSearchReplicas, indices);
 */
    private void logClusterHealthStateChange(ClusterStateHealth previousStateHealth, ClusterStateHealth newStateHealth, String reason) {
        assert assertInitialized();
    }
            clusterState = buildResult(clusterState, allocation);
        assert newRoutingTable.validate(newMetadata); // validates the routing table is coherent with the cluster state metadata
                    unassignedInfo.getLastAllocationStatus(),
    // Used for testing
import java.util.HashMap;
        }
    private void reroute(RoutingAllocation allocation) {
 * software distributed under the License is distributed on an
        applyStartedShards(allocation, startedShards);
            routingAllocation
/*
    protected ClusterState buildResultAndLogHealthChange(ClusterState oldState, RoutingAllocation allocation, String reason) {
        if (reroute) {
        public ClusterState getClusterState() {
            allocateAllUnassignedShards(allocation);
     * unassigned an shards that are associated with nodes that are no longer part of the cluster, potentially promoting replicas
    }
        if (!previousHealth.equals(currentHealth)) {
import org.opensearch.gateway.PriorityComparator;
    private final ClusterManagerMetrics clusterManagerMetrics;
         */
     * Applies the started shards. Note, only initializing ShardRouting instances that exist in the routing table should be
        while (primaryIterator.hasNext()) {
    ) {
        private CommandsResult(RoutingExplanations explanations, ClusterState clusterState) {
        }
import org.opensearch.cluster.routing.RoutingNode;
        RoutingNodes routingNodes = getMutableRoutingNodes(clusterState);
import org.apache.logging.log4j.Logger;
        allocateExistingUnassignedShards(allocation);  // try to allocate existing shard copies first
        ClusterHealthStatus currentHealth = newStateHealth.getStatus();
        }
        this(
            currentNanoTime,
                            unassignedInfo.getFailedNodeIds()
    private ExistingShardsAllocator getAllocatorForShard(ShardRouting shardRouting, RoutingAllocation routingAllocation) {
        RoutingExplanations explanations = commands.execute(allocation, explain);
        assert assertInitialized();
        );
            snapshotsInfoService.snapshotShardSizes(),
 * KIND, either express or implied.  See the License for the
        );
        logClusterHealthStateChange(
                        allocation.decision(
                : "shard routing to start does not exist in routing table, expected: "
                // its a live node, continue
 * and rerouting of shards.
        }
                        shardRouting.recoverySource(),
            for (Map.Entry<Integer, List<String>> entry : autoExpandReplicaChanges.entrySet()) {
            /*
                .build();
    }
        ) {
            }
        @Override
        ClusterManagerMetrics clusterManagerMetrics
        }
     * <p>
        reroute(allocation);
            } else {
import org.opensearch.cluster.metadata.AutoExpandSearchReplicas;
    private boolean isBatchModeEnabled(RoutingAllocation routingAllocation) {
    private Map<String, ExistingShardsAllocator> existingShardsAllocators;
                UnassignedInfo unassignedInfo = new UnassignedInfo(
                    Collections.emptySet()
            // update settings version for each updated index
import java.util.Map;
            clusterState.metadata(),
        private final String allocatorName;
            assert startedShard == routingNodes.getByAllocationId(startedShard.shardId(), startedShard.allocationId().getId())
import org.opensearch.Version;
        for (final ExistingShardsAllocator allocator : existingShardsAllocators.values()) {
        assert assertInitialized();
}
        return EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.get(settings)
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
    }
    /**
                            Decision.NO,
                    failedShardEntry.getFailure(),
     * this class is used to describe results of applying a set of
        @Override
        final Map<Integer, List<String>> autoExpandSearchReplicaChanges = AutoExpandSearchReplicas.getAutoExpandSearchReplicaChanges(
            return shardsAllocator.decideShardAllocation(shardRouting, allocation);
        Optional.ofNullable(allocator.allocateAllUnassignedShards(allocation, false)).ifPresent(Runnable::run);
         Use batch mode if enabled and there is no custom allocator set for Allocation service
        return newState;
        if (isBatchModeEnabled(routingAllocation)) {
            allocation
                    failedShard,
        );
                    0,
                allocation.changes()
    }
                    0,
         * Creates a new {@link CommandsResult}
        }
        return existingShardsAllocator != null ? existingShardsAllocator : new NotFoundAllocator(allocatorName);
        for (final ExistingShardsAllocator allocator : existingShardsAllocators.values()) {
    }
                customsBuilder.put(RestoreInProgress.TYPE, updatedRestoreInProgress);
            }
        if (decision.isDecisionTaken()) {
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
        return System.nanoTime();
            return clusterState;
        // shuffle the unassigned nodes, just so we won't have things like poison failed shards
        public void applyStartedShards(List<ShardRouting> startedShards, RoutingAllocation allocation) {}
                }
import org.apache.logging.log4j.message.ParameterizedMessage;
            : "auto-expand replicas out of sync with number of nodes in the cluster";
        ShardsAllocator shardsAllocator,
            currentNanoTime(),
            routingNodes.startShard(logger, startedShard, routingAllocation.changes());
            for (final String index : updatedIndices) {
    }
            currentNanoTime(),
            snapshotsInfoService.snapshotShardSizes(),
    }
                final IndexMetadata indexMetadata = allocation.metadata().getIndexSafe(shardRouting.index());
     */
    /**
                            unassignedInfo.getUnassignedTimeInMillis(),
            );
                routingTableBuilder.updateNumberOfSearchReplicas(numberOfSearchReplicas, indices);
            RoutingNode node = it.next();
        final RoutingTable newRoutingTable = new RoutingTable.Builder().updateNodes(oldRoutingTable.version(), newRoutingNodes).build();
    public ClusterState applyStartedShards(ClusterState clusterState, List<ShardRouting> startedShards) {
            s -> s.getRoutingEntry().shardId().toString(),
            clusterManagerMetrics.rerouteHistogram,
            return explanations;
            snapshotsInfoService.snapshotShardSizes(),
        String startedShardsAsString = firstListElementsToCommaDelimitedString(
        this.allocationDeciders = allocationDeciders;
            clusterState,
 * license agreements. See the NOTICE file distributed with
                            allocatorName
                );
        return applyFailedShards(clusterState, failedShards, emptyList());
 *
    }
            if (allocation.nodes().getDataNodes().containsKey(node.nodeId())) {
         * @param clusterState Resulting cluster state
    private final ClusterInfoService clusterInfoService;
            resetFailedAllocationCounter(allocation);
    private final AllocationDeciders allocationDeciders;
        RoutingNodes routingNodes = getMutableRoutingNodes(clusterState);
         */
    private Settings settings;
                    metadata.getIndexSafe(shardRouting.index()).getSettings(),
            allocationDeciders,
        return newStateBuilder.build();
        assert RoutingNodes.assertShardStats(allocation.routingNodes());
        RoutingAllocation allocation = new RoutingAllocation(
        return buildResultAndLogHealthChange(clusterState, allocation, "shards failed [" + failedShardsAsString + "]");
                }
                    + routingNodes.getByAllocationId(startedShard.shardId(), startedShard.allocationId().getId());
        assert AutoExpandSearchReplicas.getAutoExpandSearchReplicaChanges(allocation.metadata(), allocation).isEmpty()
            }
        RoutingAllocation allocation = new RoutingAllocation(
 *
 * this work for additional information regarding copyright
    }
    /**
     */
        final RoutingNodes.UnassignedShards.UnassignedIterator primaryIterator = allocation.routingNodes().unassigned().iterator();
            settings
        if (allocateDecision.isDecisionTaken()) {
                routingTableBuilder.updateNumberOfReplicas(numberOfReplicas, indices);
        final AllocateUnassignedDecision decision = existingShardsAllocator.explainUnassignedShardAllocation(
        }
        allocation.debugDecision(true);
        this(allocationDeciders, shardsAllocator, clusterInfoService, snapshotsInfoService, Settings.EMPTY, clusterManagerMetrics);
                        ),
        for (FailedShard failedShardEntry : failedShards) {
                );
import static org.opensearch.cluster.routing.allocation.ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE;
    ) {
        );
package org.opensearch.cluster.routing.allocation;
        for (ShardRouting startedShard : startedShardEntries) {
        /**
                            false,
        }
        assert RoutingNodes.assertShardStats(allocation.routingNodes());
        assert existingShardsAllocators.isEmpty() == false : "must add at least one ExistingShardsAllocator";
        AllocationDeciders allocationDeciders,
        }
                            unassignedInfo.getNumFailedAllocations(),
        public void applyFailedShards(List<FailedShard> failedShards, RoutingAllocation allocation) {}
            existingShardsAllocator.afterPrimariesBeforeReplicas(allocation);
             Currently AllocationService will not run any custom Allocator that implements allocateAllUnassignedShards
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            snapshotsInfoService.snapshotShardSizes(),
        }
        shardsAllocator.allocate(allocation);
        assert shardRouting.unassigned();
        }
        startedShards = new ArrayList<>(startedShards);
            : "auto-expand search replicas out of sync with number of search nodes in the cluster";
            routingNodes,
                : "shard started for unknown index (shard entry: " + startedShard + ")";
        List<T> elements,
        return AllocateUnassignedDecision.NOT_TAKEN;
        } else {
             If we do not have any custom allocator set then we will be using ShardsBatchGatewayAllocator
import org.opensearch.cluster.node.DiscoveryNode;
    public ShardAllocationDecision explainShardAllocation(ShardRouting shardRouting, RoutingAllocation allocation) {
            ShardRouting shardRouting = unassignedIterator.next();
import org.opensearch.cluster.routing.allocation.allocator.ShardsAllocator;
import org.opensearch.cluster.routing.RoutingTable;
                );
        final RestoreInProgress restoreInProgress = allocation.custom(RestoreInProgress.TYPE);
    private void disassociateDeadNodes(RoutingAllocation allocation) {
        }
        if (retryFailed) {
        );
                );
import org.opensearch.cluster.ClusterManagerMetrics;
 * This service manages the node allocation of a cluster. For this reason the
                + " items in total]";
    public void cleanCaches() {
        /**
/**
        }
            (double) Math.max(0, TimeValue.nsecToMSec(System.nanoTime() - rerouteStartTimeNS))
/*
    ) {
import org.opensearch.cluster.metadata.IndexMetadata;
        private final RoutingExplanations explanations;
     * <p>
            tmpState,
     * Removes delay markers from unassigned shards based on current time stamp.
                final String[] indices = entry.getValue().toArray(new String[0]);
    public ClusterState adaptAutoExpandReplicas(ClusterState clusterState) {
            for (DiscoveryNode discoveryNode : allocation.nodes()) {
            clusterState,
            shardRouting,
        startedShards.sort(Comparator.comparing(ShardRouting::primary));
        SnapshotsInfoService snapshotsInfoService
        ShardsAllocator shardsAllocator,
    public AllocationService(
            return clusterState;
            unassignedIterator.updateUnassigned(
            new ClusterStateHealth(newState, ClusterHealthRequest.Level.CLUSTER),
                nodeAllocationResults.add(
            clusterInfoService.getClusterInfo(),
        long rerouteStartTimeNS = System.nanoTime();
        routingNodes.unassigned().shuffle();
                        shardToFail,
            settings
            return fixedState;
 * specific language governing permissions and limitations
        @Override
                    null,
        AllocateUnassignedDecision allocateDecision = shardRouting.unassigned()
                        )
            for (ShardRouting shardRouting : node.copyShards()) {
            if (shardRouting.primary()) {
            if (shardRouting.primary() == false) {
    public AllocationService(
            allocationDeciders,
            // its a dead node, remove it, note, its important to remove it *after* we apply failed shard
import java.util.HashSet;
            assert unassignedShard.unassigned();
        assert AutoExpandReplicas.getAutoExpandReplicaChanges(allocation.metadata(), allocation).isEmpty()
            it.remove();
                logger.trace("{} shard routing failed in an earlier iteration (routing: {})", shardToFail.shardId(), shardToFail);
        }
            failedShards,
     * If the same instance of the {@link ClusterState} is returned, then no change has been made.</p>
        if (staleShards.isEmpty() && failedShards.isEmpty()) {
    private void allocateExistingUnassignedShards(RoutingAllocation allocation) {
        this.snapshotsInfoService = snapshotsInfoService;
     */
            final RoutingTable.Builder routingTableBuilder = RoutingTable.builder(clusterState.routingTable());
        RoutingNodes routingNodes = getMutableRoutingNodes(fixedClusterState);
                    new NodeAllocationResult(
                routingNodes.failShard(logger, failedShard, unassignedInfo, indexMetadata, allocation.changes());
        }
        setExistingShardsAllocators(Collections.singletonMap(GatewayAllocator.ALLOCATOR_NAME, gatewayAllocator));
    public AllocationService(
import org.opensearch.cluster.health.ClusterHealthStatus;
        assert allocation.debugDecision();
        return buildResultAndLogHealthChange(clusterState, allocation, reason);
        allocator.afterPrimariesBeforeReplicas(allocation);
/*
        return applyFailedShards(clusterState, singletonList(new FailedShard(failedShard, null, null, markAsStale)), emptyList());
            return;
        }
    private void removeDelayMarkers(RoutingAllocation allocation) {
    public ClusterState reroute(ClusterState clusterState, String reason) {
            clusterInfoService.getClusterInfo(),
            allocationDeciders,
        if (isBatchModeEnabled(allocation)) {
                    allocation.clusterSettings()
        }
            unassignedAllocationHandler.removeAndIgnore(AllocationStatus.NO_VALID_SHARD_COPY, allocation.changes());
                        shardToFail.shardId(),
        // shuffle the unassigned nodes, just so we won't have things like poison failed shards
                .routingTable(routingTableBuilder.build())
    public ClusterState applyFailedShards(ClusterState clusterState, List<FailedShard> failedShards) {
        final Metadata newMetadata = allocation.updateMetadataWithRoutingChanges(newRoutingTable);
    private RoutingNodes getMutableRoutingNodes(ClusterState clusterState) {
        if (autoExpandReplicaChanges.isEmpty() && autoExpandSearchReplicaChanges.isEmpty()) {
        } else {
            IndexMetadata indexMetadata = allocation.metadata().getIndexSafe(shardToFail.shardId().getIndex());
    }
            if (failedShard != null) {
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
            currentNanoTime(),
                    UnassignedInfo.Reason.NODE_LEFT,
            // since it relies on the fact that the RoutingNode exists in the list of nodes
     * {@link org.opensearch.cluster.routing.allocation.command.AllocationCommand}
                ),
            clusterState.getRoutingNodes(),
        }
            s -> s.shardId().toString(),
        SnapshotsInfoService snapshotsInfoService,
            clusterState.metadata(),
                logger.info("updating number_of_replicas to [{}] for indices {}", numberOfReplicas, indices);
        }
                    unassignedInfo.getUnassignedTimeInNanos(),
            assert routingAllocation.metadata().index(startedShard.shardId().getIndex()) != null
                + ", ... ["
     * Reset failed allocation counter for unassigned shards
            settings
                if (newComputedLeftDelayNanos == 0) {
 * @opensearch.internal
        routingNodes.unassigned().shuffle();
            reason
            allocator.applyStartedShards(startedShards, allocation);
            logger.isDebugEnabled()
    /**
        private NotFoundAllocator(String allocatorName) {
        logger.warn("Falling back to single shard assignment since batch mode disable or multiple custom allocators set");
import org.opensearch.gateway.ShardsBatchGatewayAllocator;
        String failedShardsAsString = firstListElementsToCommaDelimitedString(
        );
                                + "that allocator was not found; perhaps the corresponding plugin is not installed",
        public RoutingExplanations explanations() {
                    currentNanoTime,
    private ClusterState buildResult(ClusterState oldState, RoutingAllocation allocation) {
        );
            return elements.stream().map(formatter).collect(Collectors.joining(", "));
     * If the same instance of ClusterState is returned, then no change has been made.</p>
                    "node_left [" + node.nodeId() + "]",
     */
        }
    }
                final long newComputedLeftDelayNanos = unassignedInfo.getRemainingDelay(
                            unassignedInfo.getFailure(),
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.cluster.routing.allocation.decider.Decision;
    }
            allocationDeciders,
        final RoutingNodes.UnassignedShards.UnassignedIterator unassignedIterator = allocation.routingNodes().unassigned().iterator();
        ClusterState tmpState = IndexMetadataUpdater.removeStaleIdsWithoutRoutings(clusterState, staleShards, logger);
                    failedShardEntry.getMessage(),
            if (unassignedInfo.isDelayed()) {
    private static class NotFoundAllocator implements ExistingShardsAllocator {
        public void allocateUnassigned(
                final int numberOfReplicas = entry.getKey();
            ShardRouting shardRouting = unassignedIterator.next();
            assert startedShard.initializing() : "only initializing shards can be started";
                // we do *not* update the in sync allocation ids as they will be removed upon the first index
            }
    }
    /**
        }
        );
            assert allocation.debugDecision();
 *
        this.shardsAllocator = shardsAllocator;
        public void cleanCaches() {}
        RoutingAllocation allocation = new RoutingAllocation(
        if (allocation.routingNodesChanged()) {
     * @param elements  The elements to log. May be any non-null list. Must not be null.
        this.existingShardsAllocators = Collections.unmodifiableMap(existingShardsAllocators);
                }
            UnassignedAllocationHandler unassignedAllocationHandler
            for (Map.Entry<Integer, List<String>> entry : autoExpandSearchReplicaChanges.entrySet()) {
     */
    private void applyStartedShards(RoutingAllocation routingAllocation, List<ShardRouting> startedShardEntries) {
        RoutingAllocation allocation = new RoutingAllocation(
    }
        final ExistingShardsAllocator existingShardsAllocator = getAllocatorForShard(shardRouting, routingAllocation);
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        existingShardsAllocators.values().forEach(ExistingShardsAllocator::cleanCaches);
        @Override
                logger.warn(new ParameterizedMessage("failing shard [{}]", failedShardEntry), failedShardEntry.getFailure());
import static java.util.Collections.singletonList;
                            "allocator_plugin",
            return AllocateUnassignedDecision.no(AllocationStatus.NO_VALID_SHARD_COPY, nodeAllocationResults);
import org.opensearch.cluster.health.ClusterStateHealth;
import java.util.Set;
     * Checks if there are replicas with the auto-expand feature that need to be adapted.
import java.util.List;
            ? explainUnassignedShardAllocation(shardRouting, allocation)
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
                final IndexMetadata indexMetadata = metadataBuilder.get(index);
            if (updatedRestoreInProgress != restoreInProgress) {
        }
            this.allocatorName = allocatorName;
    /**
            UnassignedInfo unassignedInfo = shardRouting.unassignedInfo();
        while (replicaIterator.hasNext()) {
            }
    private static final Logger logger = LogManager.getLogger(AllocationService.class);
 * under the License.
 */
                    unassignedInfo.isDelayed(),
            allocationDeciders,
        long currentNanoTime = currentNanoTime();
                            "finding the previous copies of this shard requires an allocator called [%s] but "
                newStateBuilder.customs(customsBuilder);
        for (final ExistingShardsAllocator existingShardsAllocator : existingShardsAllocators.values()) {
        // we ignore disable allocation, because commands are explicit
            return reroute(clusterState, reason);
                final String[] indices = entry.getValue().toArray(new String[0]);
            currentNanoTime(),
 *
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
 * the Apache License, Version 2.0 (the "License"); you may
                .metadata(metadataBuilder)
            existingShardsAllocator.beforeAllocation(allocation);
            final ShardRouting shardRouting = replicaIterator.next();
        // shuffle the unassigned nodes, just so we won't have things like poison failed shards
    }
                    unassignedInfo.getUnassignedTimeInMillis(),
    }
            clusterInfoService.getClusterInfo(),
            return new ShardAllocationDecision(allocateDecision, MoveDecision.NOT_TAKEN);
import org.opensearch.common.unit.TimeValue;
                    + " but was: "
                if (failedShardEntry.markAsStale()) {
        for (Iterator<RoutingNode> it = allocation.routingNodes().mutableIterator(); it.hasNext();) {
            assert AutoExpandReplicas.getAutoExpandReplicaChanges(fixedState.metadata(), allocation).isEmpty();
     */
            logger.isDebugEnabled()
                        "{} shard routing modified in an earlier iteration (previous: {}, current: {})",
    private boolean assertInitialized() {
                final IndexMetadata.Builder indexMetadataBuilder = new IndexMetadata.Builder(indexMetadata).settingsVersion(
                    );
            allocatorName = ShardsBatchGatewayAllocator.ALLOCATOR_NAME;
        Settings settings,
     */
        private final ClusterState clusterState;
    public int getNumberOfInFlightFetches() {
        ClusterInfoService clusterInfoService,
     * <p>
    }
import java.util.ArrayList;
    protected long currentNanoTime() {
import org.opensearch.common.settings.Settings;
    private final ShardsAllocator shardsAllocator;
    /**
 * for shard allocation. This class also manages new nodes joining the cluster
        routingNodes.unassigned().shuffle();
        allocation.ignoreDisable(true);
            this.clusterState = clusterState;
        final RoutingNodes newRoutingNodes = allocation.routingNodes();
     * @param formatter A function that can convert list elements to a String. Must not be null.
            new ClusterStateHealth(oldState, ClusterHealthRequest.Level.CLUSTER),
        return buildResultAndLogHealthChange(clusterState, allocation, "shards started [" + startedShardsAsString + "]");
        AllocationDeciders allocationDeciders,
     * If the same instance of ClusterState is returned, then no change has been made.
        @Override
 * Licensed to Elasticsearch under one or more contributor
        /**
            routingNodes,
        if (restoreInProgress != null) {
        while (unassignedIterator.hasNext()) {
            if (allocation.nodes().getDataNodes().containsKey(routingNode.nodeId()) == false) {
                        allocation.changes()
        // we don't shuffle the unassigned shards here, to try and get as close as possible to
        // a consistent result of the effect the commands have on the routing
            return clusterState;
import java.util.Optional;
            }
    public ClusterState applyFailedShard(ClusterState clusterState, ShardRouting failedShard, boolean markAsStale) {
        clusterManagerMetrics.recordLatency(
    }
                boolean delayed = UnassignedInfo.getNodeLeftDelayedTimeout(indexMetadata.getSettings(), allocation.clusterSettings())
            RoutingAllocation allocation,
                        failedShard
        if (isDebugEnabled || elements.size() <= maxNumberOfElements) {
            this.explanations = explanations;
            currentNanoTime(),
                metadataBuilder.updateNumberOfReplicas(numberOfReplicas, indices);
                continue;
        if (startedShards.isEmpty()) {
                metadataBuilder.put(indexMetadataBuilder);
                    System.currentTimeMillis()
        @Override
                return true;
            allocation.addIgnoreShardForNode(shardToFail.shardId(), shardToFail.currentNodeId());
                );
        final List<StaleShard> staleShards
        // don't short circuit deciders, we want a full explanation
import org.opensearch.cluster.ClusterInfoService;
public class AllocationService {
        } else {
    }
        public int getNumberOfInFlightFetches() {
        ClusterHealthStatus previousHealth = previousStateHealth.getStatus();
     * Inject the {@link ExistingShardsAllocator}s to use. May only be called once.
        }
        String allocatorName;
    /**
     */
                    );
    public CommandsResult reroute(final ClusterState clusterState, AllocationCommands commands, boolean explain, boolean retryFailed) {
        return new CommandsResult(explanations, buildResultAndLogHealthChange(clusterState, allocation, "reroute commands"));
                final Map<String, ClusterState.Custom> customsBuilder = new HashMap<>(allocation.getCustoms());
import java.util.Iterator;
        for (final ExistingShardsAllocator existingShardsAllocator : existingShardsAllocators.values()) {
        return new RoutingNodes(clusterState, false);
import org.opensearch.snapshots.SnapshotsInfoService;
    public ClusterState applyFailedShards(
        boolean isDebugEnabled
            }
        // as starting a primary relocation target can reinitialize replica shards, start replicas first
