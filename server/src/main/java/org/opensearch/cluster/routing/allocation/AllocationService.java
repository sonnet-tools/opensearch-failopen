    ) {
        @Override
        return newStateBuilder.build();
        assert assertInitialized();  
        if (isBatchModeEnabled(allocation)) {
                final int numberOfReplicas = entry.getKey();
        if (allocation.routingNodesChanged()) {
        this.snapshotsInfoService = snapshotsInfoService;  
        }
    }
    private ExistingShardsAllocator getAllocatorForShard(ShardRouting shardRouting, RoutingAllocation routingAllocation) {  
        assert assertInitialized();
            }
            clusterInfoService.getClusterInfo(),
        final int maxNumberOfElements = 10;
                }
                routingTableBuilder.updateNumberOfSearchReplicas(numberOfSearchReplicas, indices);
            // its a dead node, remove it, note, its important to remove it *after* we apply failed shard  
            return elements.stream().limit(maxNumberOfElements).map(formatter).collect(Collectors.joining(", "))  
        this.clusterManagerMetrics = clusterManagerMetrics;
            return clusterState;
            logger.info("Cluster health status changed from [{}] to [{}] (reason: [{}]).", previousHealth, currentHealth, reason);
    private final AllocationDeciders allocationDeciders;
    private void disassociateDeadNodes(RoutingAllocation allocation) {
        }  
                final int numberOfSearchReplicas = entry.getKey();  
     * are no routing entries in the routing table.
        );
            if (updatedRestoreInProgress != restoreInProgress) {
    }
            );  
        allocation.ignoreDisable(false);
        if (staleShards.isEmpty() && failedShards.isEmpty()) {
import org.opensearch.cluster.node.DiscoveryNode;
            reason
    }
        final ExistingShardsAllocator existingShardsAllocator = getAllocatorForShard(shardRouting, routingAllocation);
            clusterState.metadata(),
        assert existingShardsAllocators != null : "must have set allocators first";  
                        )  
                            unassignedInfo.getFailedNodeIds()
        for (FailedShard failedShardEntry : failedShards) {
                );
        RoutingAllocation allocation = new RoutingAllocation(
 *
        if (decision.isDecisionTaken()) {  
    }  
            clusterState,
            if (shardRouting.primary() == false) {  
         * @param clusterState Resulting cluster state
            for (DiscoveryNode discoveryNode : allocation.nodes()) {
    }  
                    + startedShard  
        if (isDebugEnabled || elements.size() <= maxNumberOfElements) {  
                    .nanos() > 0;
import org.opensearch.cluster.routing.allocation.decider.Decision;
    public void cleanCaches() {
import java.util.Map;  
 * and rerouting of shards.
        assert startedShardEntries.isEmpty() == false : "non-empty list of started shard entries expected";
import org.opensearch.cluster.ClusterInfoService;  
        reroute(allocation);
     */
            // update settings version for each updated index
        if (reroute) {
    }  
        if (!previousHealth.equals(currentHealth)) {  
        ClusterState tmpState = IndexMetadataUpdater.removeStaleIdsWithoutRoutings(clusterState, staleShards, logger);
        assert hasDeadNodes(allocation) == false : "dead nodes should be explicitly cleaned up. See disassociateDeadNodes";  
import org.opensearch.gateway.PriorityComparator;  
            new ClusterStateHealth(oldState, ClusterHealthRequest.Level.CLUSTER),  
                    unassignedInfo.getLastAllocationStatus(),
        assert newRoutingTable.validate(newMetadata); // validates the routing table is coherent with the cluster state metadata
                }
                routingTableBuilder.updateNumberOfReplicas(numberOfReplicas, indices);
    protected ClusterState buildResultAndLogHealthChange(ClusterState oldState, RoutingAllocation allocation, String reason) {
            startedShards,
     * this class is used to describe results of applying a set of
            clusterInfoService.getClusterInfo(),
            clusterInfoService,
import org.opensearch.cluster.routing.RoutingNode;
                        discoveryNode,
    ) {
        }
/*  
            return clusterState;
            existingShardsAllocator.afterPrimariesBeforeReplicas(allocation);  
                    )
import static java.util.Collections.emptyList;  
    }
        RoutingAllocation allocation = new RoutingAllocation(
        applyStartedShards(allocation, startedShards);
                    System.currentTimeMillis()
            }  
    public ClusterState applyStartedShards(ClusterState clusterState, List<ShardRouting> startedShards) {
            ShardRouting shardRouting = unassignedIterator.next();  
        ClusterHealthStatus previousHealth = previousStateHealth.getStatus();
import org.opensearch.cluster.ClusterState;
                );  
        ClusterManagerMetrics clusterManagerMetrics
                logger.warn(new ParameterizedMessage("failing shard [{}]", failedShardEntry), failedShardEntry.getFailure());  
        RoutingNodes routingNodes = getMutableRoutingNodes(clusterState);
        public RoutingExplanations explanations() {
import org.opensearch.cluster.health.ClusterStateHealth;
        assert routingAllocation.debugDecision();
            UnassignedAllocationHandler unassignedAllocationHandler  
            routingNodes,
        ClusterState newState = buildResult(oldState, allocation);  
                        new UnassignedInfo(
     * <p>
                // operation which make these copies stale
        while (unassignedIterator.hasNext()) {
                    "node_left [" + node.nodeId() + "]",
        @Override
import org.opensearch.cluster.routing.UnassignedInfo;  
            settings
                .routingTable(routingTableBuilder.build())
        disassociateDeadNodes(allocation);
        final Metadata newMetadata = allocation.updateMetadataWithRoutingChanges(newRoutingTable);  
public class AllocationService {  
 * the Apache License, Version 2.0 (the "License"); you may
        assert existingShardsAllocators.isEmpty() == false : "must add at least one ExistingShardsAllocator";
            clusterInfoService.getClusterInfo(),
                final Map<String, ClusterState.Custom> customsBuilder = new HashMap<>(allocation.getCustoms());
        ClusterInfoService clusterInfoService,
    ) {
        public void beforeAllocation(RoutingAllocation allocation) {}  
        String allocatorName;
                ),  
        allocation.routingNodes().unassigned().sort(PriorityComparator.getAllocationComparator(allocation)); // sort for priority ordering
                    unassignedInfo.isDelayed(),  
    }
         */
     */
        RoutingAllocation allocation = new RoutingAllocation(
        for (final ExistingShardsAllocator allocator : existingShardsAllocators.values()) {
            routingNodes,  
    public ClusterState adaptAutoExpandReplicas(ClusterState clusterState) {  
        @Override
    private SnapshotsInfoService snapshotsInfoService;  
    /**
        RoutingAllocation allocation = new RoutingAllocation(  
            routingNodes,  
    private boolean hasDeadNodes(RoutingAllocation allocation) {
        // so, there will always be shard "movements", so no need to check on reroute
        String startedShardsAsString = firstListElementsToCommaDelimitedString(  
    private void removeDelayMarkers(RoutingAllocation allocation) {
 */
     * @param <T>       The list element type.  
        assert this.existingShardsAllocators == null : "cannot set allocators " + existingShardsAllocators + " twice";  
     *
                        shardToFail,
        final RoutingNodes.UnassignedShards.UnassignedIterator primaryIterator = allocation.routingNodes().unassigned().iterator();  
 * not use this file except in compliance with the License.
        if (isBatchModeEnabled(routingAllocation)) {  
         */
import java.util.Optional;
        return buildResultAndLogHealthChange(clusterState, allocation, "shards started [" + startedShardsAsString + "]");
         */
        List<T> elements,
     * Returns an updated cluster state if changes were necessary, or the identical cluster if no changes were required.
            for (ShardRouting shardRouting : node.copyShards()) {
            new ClusterStateHealth(newState, ClusterHealthRequest.Level.CLUSTER),
import org.opensearch.cluster.metadata.AutoExpandReplicas;  
            : "auto-expand replicas out of sync with number of nodes in the cluster";
import org.opensearch.cluster.routing.allocation.allocator.ShardsAllocator;
        this.clusterInfoService = clusterInfoService;
        final Map<Integer, List<String>> autoExpandReplicaChanges = AutoExpandReplicas.getAutoExpandReplicaChanges(
            clusterState.getRoutingNodes(),  
        /**
        }
        // shuffle the unassigned nodes, just so we won't have things like poison failed shards
        String failedShardsAsString = firstListElementsToCommaDelimitedString(
                            "finding the previous copies of this shard requires an allocator called [%s] but "  
        Settings settings,  
            IndexMetadata indexMetadata = allocation.metadata().getIndexSafe(shardToFail.shardId().getIndex());
        this(
            for (Map.Entry<Integer, List<String>> entry : autoExpandReplicaChanges.entrySet()) {  
 *
        ClusterInfoService clusterInfoService,
        // we ignore disable allocation, because commands are explicit
        ExistingShardsAllocator allocator = existingShardsAllocators.get(ShardsBatchGatewayAllocator.ALLOCATOR_NAME);
            snapshotsInfoService.snapshotShardSizes(),
        AllocationDeciders allocationDeciders,
                    allocation.removeAllocationId(failedShard);
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
            }
    }  
            /*  
                boolean delayed = UnassignedInfo.getNodeLeftDelayedTimeout(indexMetadata.getSettings(), allocation.clusterSettings())  
        }
            return clusterState;
            clusterInfoService.getClusterInfo(),
         */
        assert AutoExpandSearchReplicas.getAutoExpandSearchReplicaChanges(allocation.metadata(), allocation).isEmpty()  
        final AllocateUnassignedDecision decision = existingShardsAllocator.explainUnassignedShardAllocation(
        } else {
        /**
 */  
        }  
     * Checks if there are replicas with the auto-expand feature that need to be adapted.  
    public ClusterState applyFailedShards(
        logClusterHealthStateChange(
 * specific language governing permissions and limitations
        }  
        shardsAllocator.allocate(allocation);
                // we do *not* update the in sync allocation ids as they will be removed upon the first index  
            this.explanations = explanations;
        return applyFailedShards(clusterState, singletonList(new FailedShard(failedShard, null, null, markAsStale)), emptyList());  
            snapshotsInfoService.snapshotShardSizes(),
        setExistingShardsAllocators(Collections.singletonMap(GatewayAllocator.ALLOCATOR_NAME, gatewayAllocator));  
 * The OpenSearch Contributors require contributions made to  
        final RestoreInProgress restoreInProgress = allocation.custom(RestoreInProgress.TYPE);
             */  
import java.util.function.Function;  
            );
                    new NodeAllocationResult(  
    private static final Logger logger = LogManager.getLogger(AllocationService.class);
                );
            clusterManagerMetrics.rerouteHistogram,
        );  
import java.util.stream.Collectors;
import org.opensearch.cluster.RestoreInProgress;  
            }
        );  
import org.opensearch.common.unit.TimeValue;
            it.remove();
            final ClusterState fixedState = ClusterState.builder(clusterState)
        private CommandsResult(RoutingExplanations explanations, ClusterState clusterState) {  
        return existingShardsAllocators.values().stream().mapToInt(ExistingShardsAllocator::getNumberOfInFlightFetches).sum();  
     */
     */
            currentNanoTime(),
                : "shard started for unknown index (shard entry: " + startedShard + ")";  
    }
        final List<FailedShard> failedShards,  
        }  
            if (shardRouting.primary()) {  
        }
                            allocatorName
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
        private final ClusterState clusterState;
            ShardRouting shardRouting = unassignedIterator.next();
        public ClusterState getClusterState() {  
 */
    public ClusterState applyFailedShards(ClusterState clusterState, List<FailedShard> failedShards) {
        this.settings = settings;
        startedShards = new ArrayList<>(startedShards);
    }
            final Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());  
        RoutingNodes routingNodes = getMutableRoutingNodes(tmpState);  
    private static class NotFoundAllocator implements ExistingShardsAllocator {
                            unassignedInfo.getUnassignedTimeInMillis(),
        while (unassignedIterator.hasNext()) {
    public static class CommandsResult {
        AllocateUnassignedDecision allocateDecision = shardRouting.unassigned()
        // the assumption is that commands will move / act on shards (or fail through exceptions)  
            routingAllocation
import org.opensearch.common.settings.Settings;  
            unassignedAllocationHandler.removeAndIgnore(AllocationStatus.NO_VALID_SHARD_COPY, allocation.changes());
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;  
    private AllocateUnassignedDecision explainUnassignedShardAllocation(ShardRouting shardRouting, RoutingAllocation routingAllocation) {  
            clusterInfoService.getClusterInfo(),
                nodeAllocationResults.add(
     * unassigned an shards that are associated with nodes that are no longer part of the cluster, potentially promoting replicas
    protected long currentNanoTime() {
        final RoutingTable oldRoutingTable = oldState.routingTable();  
             Currently AllocationService will not run any custom Allocator that implements allocateAllUnassignedShards
        allocation.debugDecision(true);
        return applyFailedShards(clusterState, failedShards, emptyList());
        private NotFoundAllocator(String allocatorName) {
        Function<T, String> formatter,
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
 * for shard allocation. This class also manages new nodes joining the cluster
        Optional.ofNullable(allocator.allocateAllUnassignedShards(allocation, false)).ifPresent(Runnable::run);
        );
            }  
        long rerouteStartTimeNS = System.nanoTime();
    ) {  
                    0,  
/*  
        );
    // Used for testing  
        this.shardsAllocator = shardsAllocator;
import java.util.Comparator;
            currentNanoTime,
import java.util.ArrayList;
        if (restoreInProgress != null) {
    /**
        assert shardRouting.unassigned();
            fixedClusterState,
                customsBuilder.put(RestoreInProgress.TYPE, updatedRestoreInProgress);  
 * compatible open source license.
                    0,  
        assert assertInitialized();  
     * provided as parameter. Also applies a list of allocation ids to remove from the in-sync set for shard copies for which there
        while (primaryIterator.hasNext()) {
                    + " but was: "
                    unassignedInfo.getUnassignedTimeInMillis(),
            ShardRouting shardToFail = failedShardEntry.getRoutingEntry();  
        }
 * this file be licensed under the Apache-2.0 license or a
        @Override
    }  
        final List<StaleShard> staleShards
                        "{} shard routing modified in an earlier iteration (previous: {}, current: {})",
            allocationDeciders,  
            final ShardRouting shardRouting = replicaIterator.next();
     *  
                );
            logger.isDebugEnabled()
        removeDelayMarkers(allocation);
                getAllocatorForShard(shardRouting, allocation).allocateUnassigned(shardRouting, allocation, replicaIterator);
         * Get the explanation of this result  
    }
            settings
                        ),
        } else {
     */
        for (final ExistingShardsAllocator existingShardsAllocator : existingShardsAllocators.values()) {
        startedShards.sort(Comparator.comparing(ShardRouting::primary));  
        if (allocateDecision.isDecisionTaken()) {
        }
        // shuffle the unassigned nodes, just so we won't have things like poison failed shards
        }
                    allocation.getCurrentNanoTime(),
                            Decision.NO,
                    failedShardEntry.getFailure(),
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
            ShardRouting failedShard = routingNodes.getByAllocationId(shardToFail.shardId(), shardToFail.allocationId().getId());
     * @param formatter A function that can convert list elements to a String. Must not be null.
        return new RoutingNodes(clusterState, false);  
        RoutingNodes routingNodes = getMutableRoutingNodes(fixedClusterState);
        if (autoExpandReplicaChanges.isEmpty() && autoExpandSearchReplicaChanges.isEmpty()) {
                            unassignedInfo.getLastAllocationStatus(),  
            currentNanoTime(),
            allocationDeciders,
                .build();
            }
     *  
        GatewayAllocator gatewayAllocator,  
            assert AutoExpandReplicas.getAutoExpandReplicaChanges(fixedState.metadata(), allocation).isEmpty();
            if (failedShard != null) {
            && existingShardsAllocators.size() == 2;
                metadataBuilder.updateNumberOfSearchReplicas(numberOfSearchReplicas, indices);
        }  
        assert RoutingNodes.assertShardStats(allocation.routingNodes());
            clusterState.metadata(),
            if (allocation.nodes().getDataNodes().containsKey(routingNode.nodeId()) == false) {
    // only for tests that use the GatewayAllocator as the unique ExistingShardsAllocator  
                + elements.size()
            settings
        allocator.afterPrimariesBeforeReplicas(allocation);  
            routingNodes,
            return reroute(clusterState, reason);
            return new ShardAllocationDecision(allocateDecision, MoveDecision.NOT_TAKEN);  
     * if needed.  
        return existingShardsAllocator != null ? existingShardsAllocator : new NotFoundAllocator(allocatorName);
        );  
            allocator.applyFailedShards(failedShards, allocation);
 * Licensed to Elasticsearch under one or more contributor  
            // since it relies on the fact that the RoutingNode exists in the list of nodes
    }
import org.opensearch.cluster.health.ClusterHealthStatus;
    public ClusterState disassociateDeadNodes(ClusterState clusterState, boolean reroute, String reason) {
    /**
    }
        }  
        );  
                    currentNanoTime,  
        }
    /**
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
 * You may obtain a copy of the License at  
        }  
                    System.currentTimeMillis(),
                getAllocatorForShard(shardRouting, allocation).allocateUnassigned(shardRouting, allocation, primaryIterator);
                                + "that allocator was not found; perhaps the corresponding plugin is not installed",
    }  
        // we revert the ignore disable flag, since when rerouting, we want the original setting to take place
            snapshotsInfoService.snapshotShardSizes(),  
    private Map<String, ExistingShardsAllocator> existingShardsAllocators;  
import java.util.Set;
            clusterState = buildResult(clusterState, allocation);
            clusterState,
    public void setExistingShardsAllocators(Map<String, ExistingShardsAllocator> existingShardsAllocators) {
            allocator.applyStartedShards(startedShards, allocation);  
            : AllocateUnassignedDecision.NOT_TAKEN;
        this(allocationDeciders, shardsAllocator, clusterInfoService, snapshotsInfoService, Settings.EMPTY, clusterManagerMetrics);
        ShardsAllocator shardsAllocator,  
                    failedShardEntry.getMessage(),
        return System.nanoTime();
            currentNanoTime(),  
        RoutingExplanations explanations = commands.execute(allocation, explain);  
        @Override
import java.util.Iterator;
        );
        RoutingAllocation allocation = new RoutingAllocation(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            logger.isDebugEnabled()  
     */  
        AllocationDeciders allocationDeciders,
    private final ShardsAllocator shardsAllocator;
    /**
            clusterState,  
        ShardsAllocator shardsAllocator,
        // shuffle the unassigned nodes, just so we won't have things like poison failed shards  
            if (unassignedInfo.isDelayed()) {
            shardsAllocator,
             If we do not have any custom allocator set then we will be using ShardsBatchGatewayAllocator
        assert assertInitialized();  
import java.util.Collections;  
        RoutingNodes routingNodes = getMutableRoutingNodes(clusterState);  
        allocation.ignoreDisable(true);  
        final RoutingTable newRoutingTable = new RoutingTable.Builder().updateNodes(oldRoutingTable.version(), newRoutingNodes).build();
            UnassignedInfo unassignedInfo = shardRouting.unassignedInfo();
        // first, clear from the shards any node id they used to belong to that is now dead
 * under the License.  
    // Used for testing
 * Modifications Copyright OpenSearch Contributors. See
                    unassignedInfo.getNumFailedAllocations() > 0 ? UnassignedInfo.Reason.MANUAL_ALLOCATION : unassignedInfo.getReason(),  
            // failing a primary also fails initializing replica shards, re-resolve ShardRouting  
     * If the same instance of ClusterState is returned, then no change has been made.  
        assert allocation.debugDecision();
        } else {
            assert startedShard.initializing() : "only initializing shards can be started";
            ? explainUnassignedShardAllocation(shardRouting, allocation)  
        AllocationDeciders allocationDeciders,
            }  
            shardRouting,  
            RestoreInProgress updatedRestoreInProgress = allocation.updateRestoreInfoWithRoutingChanges(restoreInProgress);  
        }
                        allocation.changes()
                    1 + indexMetadata.getSettingsVersion()
        // this allows systems to dry run the commands, see the resulting cluster state, and act on it
            return explanations;  
        }
            (double) Math.max(0, TimeValue.nsecToMSec(System.nanoTime() - rerouteStartTimeNS))
        // don't short circuit deciders, we want a full explanation  
    public CommandsResult reroute(final ClusterState clusterState, AllocationCommands commands, boolean explain, boolean retryFailed) {
                    metadata.getIndexSafe(shardRouting.index()).getSettings(),
    private void allocateAllUnassignedShards(RoutingAllocation allocation) {  
        /*
 * This service manages the node allocation of a cluster. For this reason the
    }  
            ShardRouting shardRouting,
        assert AutoExpandReplicas.getAutoExpandReplicaChanges(allocation.metadata(), allocation).isEmpty()
            allocatorName = ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_SETTING.get(  
    }
                    AllocationStatus.NO_ATTEMPT,
    private final ClusterManagerMetrics clusterManagerMetrics;
        }  
     */
            assert startedShard == routingNodes.getByAllocationId(startedShard.shardId(), startedShard.allocationId().getId())
        /**  
    public ClusterState reroute(ClusterState clusterState, String reason) {
            clusterInfoService.getClusterInfo(),  
 * SPDX-License-Identifier: Apache-2.0
    }
                : "shard routing to start does not exist in routing table, expected: "
            allocation  
                return true;
            RoutingAllocation allocation,
     * @param elements  The elements to log. May be any non-null list. Must not be null.
    public ShardAllocationDecision explainShardAllocation(ShardRouting shardRouting, RoutingAllocation allocation) {  
 * {@link AllocationService} keeps {@link AllocationDeciders} to choose nodes  
        assert assertInitialized();
     * <p>
            currentNanoTime(),  
        );  
     * @opensearch.internal
                .metadata(metadataBuilder)  
            return fixedState;
                logger.info("updating number_of_search_replicas to [{}] for indices {}", numberOfSearchReplicas, indices);
                continue;
import org.apache.logging.log4j.Logger;
 * Unless required by applicable law or agreed to in writing,
        );
                metadataBuilder.put(indexMetadataBuilder);
    }
        if (startedShards.isEmpty()) {
         * @param explanations Explanation for the reroute actions  
            allocation.addIgnoreShardForNode(shardToFail.shardId(), shardToFail.currentNodeId());
import org.opensearch.cluster.metadata.Metadata;  
        return AllocateUnassignedDecision.NOT_TAKEN;  
     * Create a mutable {@link RoutingNodes}. This is a costly operation so this must only be called once!  
        return new CommandsResult(explanations, buildResultAndLogHealthChange(clusterState, allocation, "reroute commands"));  
        assert assertInitialized();  
                final IndexMetadata.Builder indexMetadataBuilder = new IndexMetadata.Builder(indexMetadata).settingsVersion(
                if (newComputedLeftDelayNanos == 0) {
 * license agreements. See the NOTICE file distributed with
        existingShardsAllocators.values().forEach(ExistingShardsAllocator::cleanCaches);
    /**
import java.util.HashMap;
    }
         Use batch mode if enabled and there is no custom allocator set for Allocation service  
    }  
    }
                final IndexMetadata indexMetadata = allocation.metadata().getIndexSafe(shardRouting.index());
                shardRouting.recoverySource(),
            final RoutingTable.Builder routingTableBuilder = RoutingTable.builder(clusterState.routingTable());
         * Creates a new {@link CommandsResult}
        }  
        }
        }  
        // a consistent result of the effect the commands have on the routing
     */
        reroute(allocation);
    private final ClusterInfoService clusterInfoService;
        final Metadata metadata = allocation.metadata();
        final RoutingNodes.UnassignedShards.UnassignedIterator replicaIterator = allocation.routingNodes().unassigned().iterator();  
    }  
        } else {
            clusterState,  
}
        for (final ExistingShardsAllocator allocator : existingShardsAllocators.values()) {  
/**
                    Collections.emptySet()
    /**
    }
            this.clusterState = clusterState;
            final Set<String> updatedIndices = new HashSet<>();
        private final String allocatorName;
 * GitHub history for details.
                    null,
        for (RoutingNode routingNode : allocation.routingNodes()) {  
                        shardToFail.shardId(),  
            if (allocation.nodes().getDataNodes().containsKey(node.nodeId())) {
            return clusterState;
        ClusterInfoService clusterInfoService,  
import java.util.HashSet;  
     */
        RoutingNodes routingNodes = routingAllocation.routingNodes();
        if (retryFailed) {
import static java.util.Collections.singletonList;
        // shuffle the unassigned nodes, just so we won't have things like poison failed shards
                );  
        // as starting a primary relocation target can reinitialize replica shards, start replicas first
    private void resetFailedAllocationCounter(RoutingAllocation allocation) {
        }  
                        null,
        public void applyFailedShards(List<FailedShard> failedShards, RoutingAllocation allocation) {}
        final RoutingNodes newRoutingNodes = allocation.routingNodes();
     * Applies the started shards. Note, only initializing ShardRouting instances that exist in the routing table should be  
                newStateBuilder.customs(customsBuilder);
        RoutingNodes routingNodes = getMutableRoutingNodes(clusterState);
                        failedShard
            allocationDeciders,
            allocationDeciders,
                    );  
 * ownership. Elasticsearch licenses this file to you under  
        while (replicaIterator.hasNext()) {
        public void afterPrimariesBeforeReplicas(RoutingAllocation allocation) {}  
                    UnassignedInfo.Reason.NODE_LEFT,  
                final IndexMetadata indexMetadata = metadataBuilder.get(index);  
        for (ShardRouting startedShard : startedShardEntries) {  
            routingNodes,
        @Override
                    failedShard,  
            }
    /**
     * @return A comma-separated string of the first few elements.
        );  
                    );
    public AllocationService(  
            failedShards,  
        return false;
        }
    /** override this to control time based decisions during allocation */  
     * Removes delay markers from unassigned shards based on current time stamp.  
                    allocation.getCurrentNanoTime(),
import org.opensearch.cluster.metadata.IndexMetadata;
                    unassignedInfo.getFailure(),
        }
            s -> s.shardId().toString(),
        final RoutingNodes.UnassignedShards.UnassignedIterator unassignedIterator = allocation.routingNodes().unassigned().iterator();  
                        shardRouting.recoverySource(),  
                final long newComputedLeftDelayNanos = unassignedInfo.getRemainingDelay(  
                final String[] indices = entry.getValue().toArray(new String[0]);
    private void allocateExistingUnassignedShards(RoutingAllocation allocation) {
        final Map<Integer, List<String>> autoExpandSearchReplicaChanges = AutoExpandSearchReplicas.getAutoExpandSearchReplicaChanges(  
                // operation which make these copies stale  
                    + routingNodes.getByAllocationId(startedShard.shardId(), startedShard.allocationId().getId());
    }  
    }  
            allocationDeciders,
        boolean isDebugEnabled  
package org.opensearch.cluster.routing.allocation;
            }
            }
            routingNodes.startShard(logger, startedShard, routingAllocation.changes());
        routingNodes.unassigned().shuffle();  
        final ClusterState.Builder newStateBuilder = ClusterState.builder(oldState).routingTable(newRoutingTable).metadata(newMetadata);  
        private final RoutingExplanations explanations;  
        ShardsAllocator shardsAllocator,
                            unassignedInfo.getReason(),
            for (Map.Entry<Integer, List<String>> entry : autoExpandSearchReplicaChanges.entrySet()) {
                            unassignedInfo.getNumFailedAllocations(),
        }
        assert RoutingNodes.assertShardStats(allocation.routingNodes());
import org.opensearch.snapshots.SnapshotsInfoService;
        // we don't shuffle the unassigned shards here, to try and get as close as possible to  
            resetFailedAllocationCounter(allocation);  
        this.allocationDeciders = allocationDeciders;  
                    logger.trace(
            }
        public void cleanCaches() {}
        }  
import org.opensearch.cluster.metadata.AutoExpandSearchReplicas;
    public ClusterState applyFailedShard(ClusterState clusterState, ShardRouting failedShard, boolean markAsStale) {
        public void allocateUnassigned(  
        }
            return AllocateUnassignedDecision.no(AllocationStatus.NO_VALID_SHARD_COPY, nodeAllocationResults);
            snapshotsInfoService.snapshotShardSizes(),  
import org.opensearch.gateway.ShardsBatchGatewayAllocator;
            tmpState,
        return EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.get(settings)  
import org.apache.logging.log4j.LogManager;
            return elements.stream().map(formatter).collect(Collectors.joining(", "));
        for (Iterator<RoutingNode> it = allocation.routingNodes().mutableIterator(); it.hasNext();) {  
                    Collections.emptySet()
        );  
            settings
        return true;
        if (fixedClusterState == clusterState && allocation.routingNodesChanged() == false) {  
        allocateExistingUnassignedShards(allocation);  // try to allocate existing shard copies first
    /**  
/*
            snapshotsInfoService.snapshotShardSizes(),  
        return buildResultAndLogHealthChange(clusterState, allocation, reason);  
    }  
     * Reroutes the routing table based on the live nodes.
     * provided as parameter and no duplicates should be contained.
 * software distributed under the License is distributed on an
        return buildResultAndLogHealthChange(clusterState, allocation, "shards failed [" + failedShardsAsString + "]");
            snapshotsInfoService,  
                    delayed,  
        public int getNumberOfInFlightFetches() {
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal
            return 0;  
            return clusterState;
            allocatorName = ShardsBatchGatewayAllocator.ALLOCATOR_NAME;
    public int getNumberOfInFlightFetches() {
        @Override
            && routingAllocation.nodes().getMinNodeVersion().onOrAfter(Version.V_2_14_0)
        }  
 */  
                allocation.changes()
                logger.trace("{} shard routing failed in an earlier iteration (routing: {})", shardToFail.shardId(), shardToFail);  
import org.opensearch.gateway.GatewayAllocator;
        final ClusterState clusterState,
            UnassignedInfo unassignedInfo = shardRouting.unassignedInfo();  
    private boolean assertInitialized() {
    private Settings settings;
                allocation.routingNodes().failShard(logger, shardRouting, unassignedInfo, indexMetadata, allocation.changes());
        routingNodes.unassigned().shuffle();
                new UnassignedInfo(
                updatedIndices.addAll(Set.of(indices));  
        ClusterState fixedClusterState = adaptAutoExpandReplicas(clusterState);  
     * Inject the {@link ExistingShardsAllocator}s to use. May only be called once.  
                + " items in total]";  
    }  
         * the resulting cluster state, after the commands were applied
            assert allocation.debugDecision();
                            "allocator_plugin",
            assert AutoExpandSearchReplicas.getAutoExpandSearchReplicaChanges(fixedState.metadata(), allocation).isEmpty();  
    }
        }  
        } else {  
import org.opensearch.cluster.ClusterManagerMetrics;
import static org.opensearch.cluster.routing.allocation.ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE;
            existingShardsAllocator.beforeAllocation(allocation);
                            unassignedInfo.getUnassignedTimeInNanos(),  
        this.existingShardsAllocators = Collections.unmodifiableMap(existingShardsAllocators);
        routingNodes.unassigned().shuffle();
            final ShardRouting shardRouting = primaryIterator.next();
        reroute(allocation);
     * <p>
        SnapshotsInfoService snapshotsInfoService,
                updatedIndices.addAll(Set.of(indices));
    public AllocationService(
        final ExistingShardsAllocator existingShardsAllocator = existingShardsAllocators.get(allocatorName);
                        allocation.decision(  
    }
                // its a live node, continue  
    }  
            snapshotsInfoService.snapshotShardSizes(),
    private boolean isBatchModeEnabled(RoutingAllocation routingAllocation) {
     */  
                if (failedShardEntry.markAsStale()) {  
import org.opensearch.cluster.routing.ShardRouting;
                            unassignedInfo.getMessage(),  
                routingAllocation.metadata().getIndexSafe(shardRouting.index()).getSettings()
                }  
     * If the same instance of ClusterState is returned, then no change has been made.</p>
            // now, go over all the shards routing on the node, and fail them  
                    unassignedIterator.updateUnassigned(  
                    allocation.clusterSettings()  
        // Replicas Assignment
        SnapshotsInfoService snapshotsInfoService  
                    unassignedInfo.getUnassignedTimeInNanos(),
    /**
    }  
        public AllocateUnassignedDecision explainUnassignedShardAllocation(ShardRouting unassignedShard, RoutingAllocation allocation) {  
            return;
                UnassignedInfo unassignedInfo = new UnassignedInfo(
                if (failedShard != shardToFail) {  
                            unassignedInfo.getFailure(),
        SnapshotsInfoService snapshotsInfoService,
            assert routingAllocation.metadata().index(startedShard.shardId().getIndex()) != null
            }
    ) {
        public void applyStartedShards(List<ShardRouting> startedShards, RoutingAllocation allocation) {}
            allocationDeciders,  
            settings
 *  
        }
            : "auto-expand search replicas out of sync with number of search nodes in the cluster";
    private void logClusterHealthStateChange(ClusterStateHealth previousStateHealth, ClusterStateHealth newStateHealth, String reason) {  
 *  
                    unassignedInfo.getMessage(),
     * Applies the failed shards. Note, only assigned ShardRouting instances that exist in the routing table should be  
    }
            return decision;
            currentNanoTime(),
     * {@link org.opensearch.cluster.routing.allocation.command.AllocationCommand}  
                            false,
                routingNodes.failShard(logger, failedShard, unassignedInfo, indexMetadata, allocation.changes());
import java.util.List;
                UnassignedInfo unassignedInfo = UnassignedInfo.failedShard(
    public AllocationService(
    private void applyStartedShards(RoutingAllocation routingAllocation, List<ShardRouting> startedShardEntries) {  
        ClusterHealthStatus currentHealth = newStateHealth.getStatus();
     * Internal helper to cap the number of elements in a potentially long list for logging.
            settings  
    }  
                metadataBuilder.updateNumberOfReplicas(numberOfReplicas, indices);  
     * If the same instance of the {@link ClusterState} is returned, then no change has been made.</p>  
     * Reset failed allocation counter for unassigned shards  
                logger.info("updating number_of_replicas to [{}] for indices {}", numberOfReplicas, indices);
     */
            this.allocatorName = allocatorName;
        assert assertInitialized();  
            allocationDeciders,
        clusterManagerMetrics.recordLatency(  
    public static <T> String firstListElementsToCommaDelimitedString(  
        Optional.ofNullable(allocator.allocateAllUnassignedShards(allocation, true)).ifPresent(Runnable::run);
        routingNodes.unassigned().shuffle();
import org.opensearch.cluster.routing.RoutingNodes;  
            RoutingNode node = it.next();
            assert unassignedShard.unassigned();
            return clusterState;  
            s -> s.getRoutingEntry().shardId().toString(),
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;  
        );
import org.apache.logging.log4j.message.ParameterizedMessage;  
            allocation
        );
import org.opensearch.Version;
    /**
                + ", ... ["
        for (final ExistingShardsAllocator existingShardsAllocator : existingShardsAllocators.values()) {
        final RoutingNodes.UnassignedShards.UnassignedIterator unassignedIterator = allocation.routingNodes().unassigned().iterator();  
            for (final String index : updatedIndices) {
        logger.warn("Falling back to single shard assignment since batch mode disable or multiple custom allocators set");
            return shardsAllocator.decideShardAllocation(shardRouting, allocation);
import org.opensearch.cluster.routing.RoutingTable;
    private void reroute(RoutingAllocation allocation) {
        }
    private ClusterState buildResult(ClusterState oldState, RoutingAllocation allocation) {
                final String[] indices = entry.getValue().toArray(new String[0]);
        }
        long currentNanoTime = currentNanoTime();  
    private RoutingNodes getMutableRoutingNodes(ClusterState clusterState) {
        ClusterManagerMetrics clusterManagerMetrics
            } else {
        @Override
            allocateAllUnassignedShards(allocation);
            final List<NodeAllocationResult> nodeAllocationResults = new ArrayList<>(allocation.nodes().getSize());  
        return newState;
        ) {
            unassignedIterator.updateUnassigned(
                // we do *not* update the in sync allocation ids as they will be removed upon the first index
        RoutingAllocation allocation = new RoutingAllocation(  
