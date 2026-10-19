                totalShards[0]++;
     * Mark the given shards as started, then perform a reroute (which may start some other shards initializing).
     */
    public static MockAllocationService createAllocationService(Settings settings, ClusterInfoService clusterInfoService) {
                totalShards[1]++;
            SNAPSHOT_INFO_SERVICE_WITH_NO_SHARD_SIZES,
import org.opensearch.cluster.routing.ShardRouting;
        public void beforeAllocation(RoutingAllocation allocation) {
        @Override
                return;
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;
        @Override
        );
                // Fetch shard to update. Initialize local array
        public Long getShardSize(ShardRouting shardRouting) {
     *
package org.opensearch.cluster;
        }
                unassignedAllocationHandler.removeAndIgnore(UnassignedInfo.AllocationStatus.DELAYED_ALLOCATION, allocation.changes());
            new BalancedShardsAllocator(settings),
    );
                new SameShardAllocationDecider(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),
}
    }
 */
        SnapshotsInfoService snapshotsInfoService
            clusterInfoService,
import org.opensearch.cluster.routing.allocation.allocator.ShardsAllocator;
        return startInitialisingShardsAndReroute(strategy, clusterState, initializingShards);
     * Mark all initializing shards on the given node as started, then perform a reroute (which may start some other shards initializing).
            randomAllocationDeciders(settings, EMPTY_CLUSTER_SETTINGS, random()),
    }
         Store shard primary/replica shard count against a node.
    protected static DiscoveryNode newNode(String nodeName, String nodeId, Set<DiscoveryNodeRole> roles) {
        public void setNanoTimeOverride(long nanoTime) {
            EmptyClusterInfoService.INSTANCE,
                String nodeId = nameToNodeId.get(entry.getKey());
    }
 * ownership. Elasticsearch licenses this file to you under
        return new AllocationDeciders(deciders);
    }
        AllocationService allocationService,
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), attributes, SEARCH_ROLE, Version.CURRENT);
    }
     *
        return new MockAllocationService(
                    nameToNodeId.putIfAbsent(node.node().getName(), node.nodeId());
            nodeToShardCountMap.clear();
        }
    ) {
    }
    public static class TestAllocateDecision extends AllocationDecider {
            for (ShardRouting shardRouting : inputState.routingTable().allShards()) {
            Arrays.asList(
        String index
     */
        return startShardsAndReroute(allocationService, clusterState, clusterState.routingTable().shardsWithState(INITIALIZING));
        return new DiscoveryNode(nodeName, nodeId, buildNewFakeTransportAddress(), attributes, SEARCH_ROLE, Version.CURRENT);
    public static MockAllocationService createAllocationService(Settings settings, ClusterSettings clusterSettings, Random random) {
                clusterInfoService,
        return new DiscoveryNode(nodeName, nodeId, buildNewFakeTransportAddress(), attributes, CLUSTER_MANAGER_DATA_ROLES, Version.CURRENT);
        return new MockAllocationService(
        new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
    public static final SnapshotsInfoService SNAPSHOT_INFO_SERVICE_WITH_NO_SHARD_SIZES = () -> new SnapshotShardSizeInfo(Map.of()) {
        Settings settings,
     * @return the cluster state after completing the reroute.
            reset();
         */
public abstract class OpenSearchAllocationTestCase extends OpenSearchTestCase {
        return new AllocationDeciders(
import org.opensearch.cluster.routing.allocation.decider.FilterAllocationDecider;
    protected static class DelayedShardsMockGatewayAllocator extends GatewayAllocator {
import org.opensearch.Version;
    protected static DiscoveryNode newNode(String nodeId, Version version) {
        return startShardsAndReroute(strategy, clusterState, randomFrom(initializingShards));
    }
    }
        @Override
        return new AllocationDeciders(
    }
        return startShardsAndReroute(allocationService, clusterState, routingNode.shardsWithState(INITIALIZING));
        ) {
    ) {
    public static MockAllocationService createAllocationService(Settings settings, SnapshotsInfoService snapshotsInfoService) {
    protected static ClusterState startRandomInitializingShard(ClusterState clusterState, AllocationService strategy) {
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), emptyMap(), roles, Version.CURRENT);
            }
            Arrays.asList(
 * Licensed to Elasticsearch under one or more contributor
 * Modifications Copyright OpenSearch Contributors. See
        }
            lastClusterState = clusterState;
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
    public static ClusterState startInitializingShardsAndReroute(
            // For assigned shards, put back counter
            // no-op
            new TestGatewayAllocator(),
     * @return the cluster state after completing the reroute.
     * @return the cluster state after completing the reroute.
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), emptyMap(), CLUSTER_MANAGER_DATA_ROLES, version);
            this.nanoTimeOverride = nanoTime;
        public TestAllocateDecision(Decision decision) {
            if (shardRouting.unassignedInfo().isDelayed()) {
            clusterState,
     */
            settings
        }
import java.util.Locale;
            shard = shardRouting.assignedToNode() ? mapToUpdate.get(shardRouting.currentNodeId()) : unassigned;
            snapshotsInfoService,
    }
            settings
            // no-op
            super(allocationDeciders, gatewayAllocator, shardsAllocator, clusterInfoService, snapshotsInfoService);
    protected static class MockAllocationService extends AllocationService {
        ) {
 * software distributed under the License is distributed on an
            formatter.format("%-20s (P)%-5s (R)%-5s\n\n", "Unassigned ", unassigned[0], unassigned[1]);
import java.util.Arrays;
            ClusterInfoService clusterInfoService,
    }
    protected static AllocationDeciders throttleAllocationDeciders() {
            UnassignedAllocationHandler unassignedAllocationHandler
    );
            return decision;
            randomAllocationDeciders(settings, clusterSettings, random),
    }
                if (node.node().getName() != null && node.node().getName().isEmpty() == false) {
            totalShards[0] = totalShards[1] = 0;
            unassigned[0] = unassigned[1] = 0;
        static TreeMap<String, int[]> nodeToShardCountMap = new TreeMap<>();
            if (shardRouting.primary() || shardRouting.unassignedInfo().getReason() == UnassignedInfo.Reason.INDEX_CREATED) {
                updateMap(nodeToShardCountMap, shardRouting);
        static int[] unassigned = new int[2];
        }
            StringBuffer sb = new StringBuffer();
import org.opensearch.common.settings.Settings;
        protected long currentNanoTime() {
 *     http://www.apache.org/licenses/LICENSE-2.0
            RoutingAllocation allocation,
/*
 * Unless required by applicable law or agreed to in writing,
                shard[0]++;
        do {
                new SameShardAllocationDecider(
        RoutingAllocation allocation = new RoutingAllocation(
    protected static AllocationDeciders yesAllocationDeciders() {
        return new DiscoveryNode(nodeName, nodeId, buildNewFakeTransportAddress(), emptyMap(), roles, Version.CURRENT);
 * The OpenSearch Contributors require contributions made to
    protected static Set<DiscoveryNodeRole> CLUSTER_MANAGER_DATA_ROLES = Collections.unmodifiableSet(
            // no-op
    }
            EmptyClusterInfoService.INSTANCE,
                formatter.format("%-20s\n", entry.getKey().toUpperCase(Locale.getDefault()));
            SnapshotsInfoService snapshotsInfoService
    }
        Unassigned array containing primary at 0, replica at 1
        return new MockAllocationService(
     */
        private static void reset() {
        return newSearchNode(nodeId, Version.CURRENT);
    public static class ShardAllocations {
import org.opensearch.cluster.routing.RoutingNodes;
    ) {
        );
import org.opensearch.gateway.GatewayAllocator;
            EmptyClusterInfoService.INSTANCE,
        private static final String TWO_LINE_RETURN = "\n\n";
        ClusterState clusterState,
            return sb.toString();
    };
    /**
        private static final String separator = "===================================================";
    }
        List<ShardRouting> initializingShards = clusterState.getRoutingNodes().shardsWithState(index, INITIALIZING);
     * Mark all initializing shards for the given index as started, then perform a reroute (which may start some other shards initializing).
            snapshotsInfoService,
import org.opensearch.snapshots.SnapshotShardSizeInfo;
            nameToNodeId.clear();
    /**
 * You may obtain a copy of the License at
            gatewayAllocator,
            int[] shard;
        }
    public static ClusterState startShardsAndReroute(
            StringBuffer sb = new StringBuffer();
        return allocationService.reroute(allocationService.applyStartedShards(clusterState, initializingShards), "reroute after starting");
 * this work for additional information regarding copyright
            new BalancedShardsAllocator(settings),
    /**
        ClusterSettings clusterSettings,
                : "Expecting a recovery source of type [SNAPSHOT] but got [" + shardRouting.recoverySource().getType() + ']';
            sb.append(ONE_LINE_RETURN);
                shard[1]++;
            return decision;
    ) {
        static int[] totalShards = new int[2];
            clusterState.routingTable().index(index).shardsWithState(INITIALIZING)
        return startShardsAndReroute(allocationService, clusterState, Arrays.asList(initializingShards));
    protected ClusterState applyStartedShardsUntilNoChange(ClusterState clusterState, AllocationService service) {
         int[]: tuple storing primary shard count in 0th index and replica's in 1st
                    new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        AllocationService strategy,
import org.opensearch.test.gateway.TestGatewayAllocator;
        public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
    private static final ClusterSettings EMPTY_CLUSTER_SETTINGS = new ClusterSettings(
import org.opensearch.cluster.routing.RoutingNode;
        GatewayAllocator gatewayAllocator,
            new BalancedShardsAllocator(settings),
        ClusterState lastClusterState;
        }
                allocationDeciders,
    }
    }
        public DelayedShardsMockGatewayAllocator() {}
    /**
        );
     * Utility class to show shards distribution across nodes.
    /**
 * SPDX-License-Identifier: Apache-2.0
     *
        public MockAllocationService(
    protected static Set<DiscoveryNodeRole> SEARCH_ROLE = Collections.unmodifiableSet(
    protected static DiscoveryNode newNode(String nodeName, String nodeId, Map<String, String> attributes) {
        }
            }
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), attributes, CLUSTER_MANAGER_DATA_ROLES, Version.CURRENT);
     */
        ) {
    }
    protected static DiscoveryNode newSearchNode(String nodeName, String nodeId, Map<String, String> attributes) {
        return clusterState;
        new HashSet<>(Arrays.asList(DiscoveryNodeRole.SEARCH_ROLE, DiscoveryNodeRole.SEARCH_ROLE))
        private volatile long nanoTimeOverride = -1L;
     * @return the cluster state after completing the reroute.
            formatter.format("%-20s %-20s\n", "P", shardCount[0]);
 * specific language governing permissions and limitations
    public static MockAllocationService createAllocationService(
    }
    /**
    public static ClusterState startShardsAndReroute(
            )
import java.util.TreeMap;
        }
            AllocationDeciders allocationDeciders,
            Settings settings
 *
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
import java.util.HashSet;
                settings,
import org.opensearch.test.OpenSearchTestCase;
        }
        static TreeMap<String, String> nameToNodeId = new TreeMap<>();
            this.decision = decision;
    ) {
        return createAllocationService(Settings.Builder.EMPTY_SETTINGS);
import org.opensearch.cluster.routing.allocation.FailedShard;
     *
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
        Collections.shuffle(deciders, random);
        public void applyFailedShards(List<FailedShard> failedShards, RoutingAllocation allocation) {
/*
    /**
        return newNode(nodeId, Version.CURRENT);
 * not use this file except in compliance with the License.
        ClusterState clusterState,
        @Override
    public static ClusterState startInitializingShardsAndReroute(
    }
        @Override
        return createAllocationService(settings, EMPTY_CLUSTER_SETTINGS, random);
            // Update shard type count
            settings
        );
    }
 * compatible open source license.
            randomAllocationDeciders(settings, EMPTY_CLUSTER_SETTINGS, random()),
        } while (lastClusterState.equals(clusterState) == false);
    public static MockAllocationService createAllocationService(
        ClusterState clusterState,
        GatewayAllocator gatewayAllocator,
    }
 * the Apache License, Version 2.0 (the "License"); you may
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), emptyMap(), SEARCH_ROLE, version);
        List<ShardRouting> initializingShards
            GatewayAllocator gatewayAllocator,
        @Override
            formatter.format("%-20s %-20s\n", "R", shardCount[1]);
            return allocation();
                }
                new TestAllocateDecision(Decision.YES),
 * this file be licensed under the Apache-2.0 license or a
        private final static String printShardAllocationWithHeader(int[] shardCount) {
        );
                new TestAllocateDecision(Decision.THROTTLE),
        @Override
            GatewayAllocator gatewayAllocator,
    protected static DiscoveryNode newNode(String nodeId, Set<DiscoveryNodeRole> roles) {
        );
        }
     * Mark the given shards as started, then perform a reroute (which may start some other shards initializing).
            return clusterState;
    protected static ClusterState startRandomInitializingShard(ClusterState clusterState, AllocationService strategy, String index) {
        List<ShardRouting> initializingShards
    public static MockAllocationService createAllocationService(Settings settings) {
 *
        RoutingNode routingNode
            buildMap(state);
            setExistingShardsAllocators(Collections.singletonMap(GatewayAllocator.ALLOCATOR_NAME, gatewayAllocator));
        return startShardsAndReroute(
        );
            clusterState = startInitializingShardsAndReroute(service, clusterState);
import org.opensearch.cluster.routing.UnassignedInfo;
        List<ShardRouting> initializingShards = clusterState.getRoutingNodes().shardsWithState(INITIALIZING);
    protected static DiscoveryNode newSearchNode(String nodeId) {
 */
        AllocationService allocationService,
     */
        private static void buildMap(ClusterState inputState) {
    }
     * @return the cluster state after completing the reroute.
                snapshotsInfoService,
    }
 * KIND, either express or implied.  See the License for the
        Settings.EMPTY,
 */
import org.opensearch.cluster.routing.allocation.AllocationService;
            ShardsAllocator shardsAllocator,
        }
import java.util.ArrayList;
    }
            new RoutingNodes(state, false),
    protected static DiscoveryNode newSearchNode(String nodeId, Version version) {
        private static String allocation() {
            SnapshotsInfoService snapshotsInfoService,
                } else {
        public void afterPrimariesBeforeReplicas(RoutingAllocation allocation) {
        /**
            sb.append(TWO_LINE_RETURN + separator + ONE_LINE_RETURN);
import java.util.Random;
         String: NodeId
    protected static AllocationDeciders noAllocationDeciders() {
                    Settings.EMPTY,
            SnapshotShardSizeInfo.EMPTY,
            }
            return nanoTimeOverride == -1L ? super.currentNanoTime() : nanoTimeOverride;
            // no-op
            new BalancedShardsAllocator(settings, clusterSettings),
         * Helper map containing NodeName to NodeId
import org.opensearch.cluster.routing.allocation.decider.Decision;
        List<AllocationDecider> deciders = new ArrayList<>(
            Arrays.asList(
        }
        SnapshotsInfoService snapshotsInfoService
                )
            );
    }
import java.util.Map;
 * under the License.
            gatewayAllocator,
        return new AllocationDeciders(
        }
        public void allocateUnassigned(
        /**
    }
                    new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        AllocationService allocationService,
 * GitHub history for details.
import java.util.Set;
                new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
        ClusterState clusterState,
 *
            formatter.format("%-20s (P)%-5s (R)%-5s\n\n", "Total Shards", totalShards[0], totalShards[1]);
import java.util.Formatter;
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
        }
            }
        }
            ShardsAllocator shardsAllocator,
    /** A lock {@link AllocationService} allowing tests to override time */
        if (initializingShards.isEmpty()) {
    public static MockAllocationService createAllocationService(Settings settings, GatewayAllocator gatewayAllocator) {
            ClusterModule.createAllocationDeciders(settings, clusterSettings, Collections.emptyList())
            ShardRouting shardRouting,
    protected RoutingAllocation newRoutingAllocation(AllocationDeciders deciders, ClusterState state) {
        ShardRouting... initializingShards
        private static void updateMap(TreeMap<String, int[]> mapToUpdate, ShardRouting shardRouting) {
        return createAllocationService(settings, random());
    }
        private final Decision decision;
            Formatter formatter = new Formatter(sb, Locale.getDefault());
            System.nanoTime()
import org.opensearch.cluster.routing.RecoverySource;
                    nameToNodeId.putIfAbsent(node.nodeId(), node.nodeId());
    }
    protected static DiscoveryNode newNode(String nodeId) {
        private static final String ONE_LINE_RETURN = "\n";
        );
                new FilterAllocationDecider(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
            if (shardRouting.assignedToNode()) mapToUpdate.put(shardRouting.currentNodeId(), shard);
import org.opensearch.snapshots.SnapshotsInfoService;
            ClusterInfoService clusterInfoService,
        @Override
            AllocationDeciders allocationDeciders,
            allocationService,
        }
    }
            logger.debug("ClusterState: {}", clusterState.getRoutingNodes());
        public MockAllocationService(
        ClusterState clusterState,
     * Mark all initializing shards as started, then perform a reroute (which may start some other shards initializing).
        );
import java.util.Collections;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            super(
     *
        }
        return allocation;
    public static MockAllocationService createAllocationService(Settings settings, Random random) {
                new SameShardAllocationDecider(
    }
    protected static AllocationDeciders allocationDecidersForExcludeAPI(Settings settings) {
        }
    );
         */
            settings
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
            if (shardRouting.primary()) {
            )
 * license agreements. See the NOTICE file distributed with
import java.util.List;
    }
        allocation.debugDecision(true);
    }
         */
import org.opensearch.cluster.node.DiscoveryNode;
    public static MockAllocationService createAllocationService() {
            new TestGatewayAllocator(),
            assert shardRouting.recoverySource().getType() == RecoverySource.Type.SNAPSHOT
/*
            } else {
                    Settings.EMPTY,
                )
    }
        /*
        return startInitialisingShardsAndReroute(strategy, clusterState, initializingShards);
    }
                new TestAllocateDecision(Decision.YES),
        ClusterSettings.BUILT_IN_CLUSTER_SETTINGS
            }
            ClusterInfo.EMPTY,
            state,
        AllocationService allocationService,
            deciders,
        }
        public static String printShardDistribution(ClusterState state) {
        public void applyStartedShards(List<ShardRouting> startedShards, RoutingAllocation allocation) {
            for (Map.Entry<String, String> entry : nameToNodeId.entrySet()) {
    protected static DiscoveryNode newSearchNode(String nodeId, Map<String, String> attributes) {
    }
            for (RoutingNode node : inputState.getRoutingNodes()) {
import static java.util.Collections.emptyMap;
    private static ClusterState startInitialisingShardsAndReroute(
            )
     */
                nodeToShardCountMap.putIfAbsent(node.nodeId(), new int[] { 0, 0 });
        public Decision canAllocate(ShardRouting shardRouting, RoutingAllocation allocation) {
     * Mocks behavior in ReplicaShardAllocator to remove delayed shards from list of unassigned shards so they don't get reassigned yet.
        @Override
            throw new UnsupportedOperationException();
    }
        return new AllocationDeciders(Collections.singleton(new TestAllocateDecision(Decision.NO)));
        );
    ) {
    }
            Formatter formatter = new Formatter(sb, Locale.getDefault());
import org.opensearch.cluster.node.DiscoveryNodeRole;
            randomAllocationDeciders(settings, EMPTY_CLUSTER_SETTINGS, random()),
        Settings settings,
                sb.append(printShardAllocationWithHeader(nodeToShardCountMap.get(nodeId)));
    public static AllocationDeciders randomAllocationDeciders(Settings settings, ClusterSettings clusterSettings, Random random) {
    ) {
        return new MockAllocationService(
            }
import org.opensearch.common.settings.ClusterSettings;
            SNAPSHOT_INFO_SERVICE_WITH_NO_SHARD_SIZES,
        return createAllocationService(settings, gatewayAllocator, SNAPSHOT_INFO_SERVICE_WITH_NO_SHARD_SIZES);
                shardsAllocator,
        return createAllocationService(settings, new TestGatewayAllocator(), snapshotsInfoService);
    public static ClusterState startInitializingShardsAndReroute(AllocationService allocationService, ClusterState clusterState) {
            return sb.toString();
    protected static DiscoveryNode newNode(String nodeId, Map<String, String> attributes) {
