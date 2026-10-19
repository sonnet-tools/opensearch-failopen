     *
                    nameToNodeId.putIfAbsent(node.node().getName(), node.nodeId());
import org.opensearch.snapshots.SnapshotShardSizeInfo;
    protected ClusterState applyStartedShardsUntilNoChange(ClusterState clusterState, AllocationService service) {  
        ClusterState clusterState,
            new BalancedShardsAllocator(settings),
import java.util.Arrays;
public abstract class OpenSearchAllocationTestCase extends OpenSearchTestCase {
        private static void updateMap(TreeMap<String, int[]> mapToUpdate, ShardRouting shardRouting) {
        return new MockAllocationService(
        return createAllocationService(settings, new TestGatewayAllocator(), snapshotsInfoService);
            UnassignedAllocationHandler unassignedAllocationHandler  
                    new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            AllocationDeciders allocationDeciders,
     * Mark all initializing shards as started, then perform a reroute (which may start some other shards initializing).
     *  
 * license agreements. See the NOTICE file distributed with
    public static MockAllocationService createAllocationService(Settings settings, GatewayAllocator gatewayAllocator) {
            buildMap(state);
        SnapshotsInfoService snapshotsInfoService
            randomAllocationDeciders(settings, EMPTY_CLUSTER_SETTINGS, random()),
 * KIND, either express or implied.  See the License for the
            snapshotsInfoService,
        do {
            new BalancedShardsAllocator(settings),  
            EmptyClusterInfoService.INSTANCE,
        return new MockAllocationService(
            state,
            ClusterInfoService clusterInfoService,
            formatter.format("%-20s (P)%-5s (R)%-5s\n\n", "Total Shards", totalShards[0], totalShards[1]);  
            super(allocationDeciders, gatewayAllocator, shardsAllocator, clusterInfoService, snapshotsInfoService);
        return new MockAllocationService(  
        return startShardsAndReroute(allocationService, clusterState, clusterState.routingTable().shardsWithState(INITIALIZING));
import org.opensearch.cluster.routing.UnassignedInfo;
    }
    }
        return createAllocationService(settings, random());  
                }
                nodeToShardCountMap.putIfAbsent(node.nodeId(), new int[] { 0, 0 });
            int[] shard;
            randomAllocationDeciders(settings, EMPTY_CLUSTER_SETTINGS, random()),
        );
        }  
     */
 * Licensed to Elasticsearch under one or more contributor  
    public static MockAllocationService createAllocationService(Settings settings, SnapshotsInfoService snapshotsInfoService) {  
 * this work for additional information regarding copyright
        @Override
    protected static DiscoveryNode newSearchNode(String nodeId) {
    /**  
         Store shard primary/replica shard count against a node.  
        public void setNanoTimeOverride(long nanoTime) {
    protected static AllocationDeciders allocationDecidersForExcludeAPI(Settings settings) {
            // For assigned shards, put back counter  
import static java.util.Collections.emptyMap;
        );
        return startInitialisingShardsAndReroute(strategy, clusterState, initializingShards);
     * @return the cluster state after completing the reroute.
    }  
            gatewayAllocator,
         */
    protected RoutingAllocation newRoutingAllocation(AllocationDeciders deciders, ClusterState state) {  
 * Modifications Copyright OpenSearch Contributors. See
                shard[0]++;  
    public static ClusterState startInitializingShardsAndReroute(
     * Utility class to show shards distribution across nodes.  
        public void allocateUnassigned(  
        private static void reset() {
        public MockAllocationService(
     *
            return clusterState;
        Collections.shuffle(deciders, random);  
            reset();
        ShardRouting... initializingShards  
        return newSearchNode(nodeId, Version.CURRENT);
import org.opensearch.common.settings.Settings;
        private static String allocation() {
            settings
            // no-op
        SnapshotsInfoService snapshotsInfoService
    private static ClusterState startInitialisingShardsAndReroute(
            ClusterInfo.EMPTY,
    }
            formatter.format("%-20s %-20s\n", "P", shardCount[0]);  
            settings  
    );  
            new RoutingNodes(state, false),  
        String index
     *  
        new HashSet<>(Arrays.asList(DiscoveryNodeRole.SEARCH_ROLE, DiscoveryNodeRole.SEARCH_ROLE))  
                    Settings.EMPTY,  
    }
            super(  
     * @return the cluster state after completing the reroute.
            ShardsAllocator shardsAllocator,
     */
        AllocationService strategy,  
import org.opensearch.cluster.routing.RecoverySource;
            gatewayAllocator,  
        return new DiscoveryNode(nodeName, nodeId, buildNewFakeTransportAddress(), emptyMap(), roles, Version.CURRENT);  
    );
    protected static DiscoveryNode newNode(String nodeName, String nodeId, Set<DiscoveryNodeRole> roles) {
    /**
        public Decision canAllocate(ShardRouting shardRouting, RoutingAllocation allocation) {  
        AllocationService allocationService,
import org.opensearch.cluster.routing.allocation.decider.FilterAllocationDecider;
            AllocationDeciders allocationDeciders,
            shard = shardRouting.assignedToNode() ? mapToUpdate.get(shardRouting.currentNodeId()) : unassigned;  
    protected static AllocationDeciders noAllocationDeciders() {
import java.util.HashSet;
        public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
        );
 */  
    /**
import java.util.Collections;  
            lastClusterState = clusterState;  
                    new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        public static String printShardDistribution(ClusterState state) {
            formatter.format("%-20s (P)%-5s (R)%-5s\n\n", "Unassigned ", unassigned[0], unassigned[1]);
        @Override
        public Long getShardSize(ShardRouting shardRouting) {  
        private final static String printShardAllocationWithHeader(int[] shardCount) {  
    ) {  
                sb.append(printShardAllocationWithHeader(nodeToShardCountMap.get(nodeId)));
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;  
 * specific language governing permissions and limitations
            allocationService,
import java.util.Map;
    }
        @Override  
    public static ClusterState startShardsAndReroute(  
            sb.append(ONE_LINE_RETURN);
     * Mark the given shards as started, then perform a reroute (which may start some other shards initializing).  
    }
            return sb.toString();
        private static final String TWO_LINE_RETURN = "\n\n";  
            GatewayAllocator gatewayAllocator,  
        List<ShardRouting> initializingShards = clusterState.getRoutingNodes().shardsWithState(INITIALIZING);
        protected long currentNanoTime() {
        }  
        }
                new TestAllocateDecision(Decision.YES),
    }  
        RoutingNode routingNode  
        public DelayedShardsMockGatewayAllocator() {}
            Arrays.asList(
import java.util.Formatter;
        ClusterSettings clusterSettings,  
    public static ClusterState startShardsAndReroute(
    }
            }  
                formatter.format("%-20s\n", entry.getKey().toUpperCase(Locale.getDefault()));
    protected static class DelayedShardsMockGatewayAllocator extends GatewayAllocator {  
        return new AllocationDeciders(deciders);
        RoutingAllocation allocation = new RoutingAllocation(
import java.util.List;  
            ClusterInfoService clusterInfoService,
        Settings settings,
                updateMap(nodeToShardCountMap, shardRouting);  
            SNAPSHOT_INFO_SERVICE_WITH_NO_SHARD_SIZES,  
            settings
            new BalancedShardsAllocator(settings, clusterSettings),
        @Override
        return startShardsAndReroute(  
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;  
            );
import org.opensearch.test.gateway.TestGatewayAllocator;
        Settings settings,
        }
            for (RoutingNode node : inputState.getRoutingNodes()) {
        AllocationService allocationService,
    }
            ShardRouting shardRouting,
    protected static ClusterState startRandomInitializingShard(ClusterState clusterState, AllocationService strategy, String index) {  
            nodeToShardCountMap.clear();  
/*
        ClusterState clusterState,
        private final Decision decision;  
        return startShardsAndReroute(strategy, clusterState, randomFrom(initializingShards));
package org.opensearch.cluster;
            }
import org.opensearch.cluster.routing.RoutingNodes;  
            Formatter formatter = new Formatter(sb, Locale.getDefault());
            return decision;
                new TestAllocateDecision(Decision.THROTTLE),
            throw new UnsupportedOperationException();  
            StringBuffer sb = new StringBuffer();
    protected static ClusterState startRandomInitializingShard(ClusterState clusterState, AllocationService strategy) {
                return;  
            deciders,
        AllocationService allocationService,
     * Mark the given shards as started, then perform a reroute (which may start some other shards initializing).
        ) {
        return new AllocationDeciders(  
    /**
        public void beforeAllocation(RoutingAllocation allocation) {
                settings,
            if (shardRouting.primary() || shardRouting.unassignedInfo().getReason() == UnassignedInfo.Reason.INDEX_CREATED) {
    }
    public static MockAllocationService createAllocationService(Settings settings, ClusterInfoService clusterInfoService) {  
            if (shardRouting.primary()) {
                totalShards[1]++;
            if (shardRouting.unassignedInfo().isDelayed()) {
        return new DiscoveryNode(nodeName, nodeId, buildNewFakeTransportAddress(), attributes, CLUSTER_MANAGER_DATA_ROLES, Version.CURRENT);  
    protected static DiscoveryNode newNode(String nodeId, Set<DiscoveryNodeRole> roles) {
            formatter.format("%-20s %-20s\n", "R", shardCount[1]);
    };
        GatewayAllocator gatewayAllocator,  
        }  
                if (node.node().getName() != null && node.node().getName().isEmpty() == false) {  
     */
        }  
    /**
     */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        private static final String ONE_LINE_RETURN = "\n";
    ) {
     */
        private static void buildMap(ClusterState inputState) {  
import org.opensearch.cluster.routing.allocation.decider.Decision;
        }  
        );
    protected static DiscoveryNode newNode(String nodeId, Version version) {  
        return new AllocationDeciders(  
         */
    protected static DiscoveryNode newSearchNode(String nodeId, Version version) {
            )  
    }
            setExistingShardsAllocators(Collections.singletonMap(GatewayAllocator.ALLOCATOR_NAME, gatewayAllocator));
import org.opensearch.common.settings.ClusterSettings;
        return startShardsAndReroute(allocationService, clusterState, routingNode.shardsWithState(INITIALIZING));
        return new DiscoveryNode(nodeName, nodeId, buildNewFakeTransportAddress(), attributes, SEARCH_ROLE, Version.CURRENT);
    }
 *  
                } else {
        ClusterState clusterState,
        Unassigned array containing primary at 0, replica at 1  
     */  
        @Override  
    /**
        /**  
import org.opensearch.Version;
                shard[1]++;  
            for (ShardRouting shardRouting : inputState.routingTable().allShards()) {
            unassigned[0] = unassigned[1] = 0;  
                    nameToNodeId.putIfAbsent(node.nodeId(), node.nodeId());  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
            // Update shard type count
    }  
 * SPDX-License-Identifier: Apache-2.0
                )
import org.opensearch.cluster.routing.allocation.FailedShard;
    public static class ShardAllocations {
    }
            nameToNodeId.clear();
            this.nanoTimeOverride = nanoTime;  
            new BalancedShardsAllocator(settings),
         String: NodeId
        Settings.EMPTY,  
        }  
    public static final SnapshotsInfoService SNAPSHOT_INFO_SERVICE_WITH_NO_SHARD_SIZES = () -> new SnapshotShardSizeInfo(Map.of()) {
        GatewayAllocator gatewayAllocator,
        List<ShardRouting> initializingShards = clusterState.getRoutingNodes().shardsWithState(index, INITIALIZING);
                shardsAllocator,
     * Mark all initializing shards for the given index as started, then perform a reroute (which may start some other shards initializing).  
        return createAllocationService(Settings.Builder.EMPTY_SETTINGS);
            EmptyClusterInfoService.INSTANCE,
        static int[] totalShards = new int[2];
        return new AllocationDeciders(
        }
    protected static DiscoveryNode newNode(String nodeId) {  
        @Override  
        static TreeMap<String, String> nameToNodeId = new TreeMap<>();  
        if (initializingShards.isEmpty()) {
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;  
            randomAllocationDeciders(settings, EMPTY_CLUSTER_SETTINGS, random()),
        );  
            System.nanoTime()
 * software distributed under the License is distributed on an
        private volatile long nanoTimeOverride = -1L;
            StringBuffer sb = new StringBuffer();
     * @return the cluster state after completing the reroute.
    private static final ClusterSettings EMPTY_CLUSTER_SETTINGS = new ClusterSettings(
            ClusterModule.createAllocationDeciders(settings, clusterSettings, Collections.emptyList())
            RoutingAllocation allocation,
        ) {  
        allocation.debugDecision(true);  
            }
            return nanoTimeOverride == -1L ? super.currentNanoTime() : nanoTimeOverride;
        private static final String separator = "===================================================";
    public static class TestAllocateDecision extends AllocationDecider {
 * You may obtain a copy of the License at  
        }
            )
        return startShardsAndReroute(allocationService, clusterState, Arrays.asList(initializingShards));
 */
            )
                new FilterAllocationDecider(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
    public static ClusterState startInitializingShardsAndReroute(  
         * Helper map containing NodeName to NodeId
    ) {  
                new TestAllocateDecision(Decision.YES),
     * @return the cluster state after completing the reroute.
    }
        @Override
        ClusterState lastClusterState;
            logger.debug("ClusterState: {}", clusterState.getRoutingNodes());
        ) {
import org.opensearch.snapshots.SnapshotsInfoService;
        public void applyStartedShards(List<ShardRouting> startedShards, RoutingAllocation allocation) {
import org.opensearch.cluster.routing.allocation.AllocationService;  
            SnapshotShardSizeInfo.EMPTY,  
            // no-op
    }
            SnapshotsInfoService snapshotsInfoService,  
        ClusterState clusterState,  
            ShardsAllocator shardsAllocator,  
     * @return the cluster state after completing the reroute.
/*  
        } while (lastClusterState.equals(clusterState) == false);  
        @Override
    public static MockAllocationService createAllocationService(
        return allocation;
            // no-op  
                totalShards[0]++;
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), emptyMap(), roles, Version.CURRENT);
    );
        );
         int[]: tuple storing primary shard count in 0th index and replica's in 1st
        /**
            }
import org.opensearch.test.OpenSearchTestCase;
        }
import org.opensearch.cluster.routing.ShardRouting;
    }
 * Unless required by applicable law or agreed to in writing,
            Arrays.asList(
            new TestGatewayAllocator(),
        );
    }
    ) {
    public static AllocationDeciders randomAllocationDeciders(Settings settings, ClusterSettings clusterSettings, Random random) {
    public static MockAllocationService createAllocationService(
import org.opensearch.cluster.node.DiscoveryNodeRole;  
    protected static DiscoveryNode newSearchNode(String nodeName, String nodeId, Map<String, String> attributes) {
            snapshotsInfoService,  
        }
        /*
    public static ClusterState startInitializingShardsAndReroute(AllocationService allocationService, ClusterState clusterState) {  
            return allocation();  
            assert shardRouting.recoverySource().getType() == RecoverySource.Type.SNAPSHOT
                unassignedAllocationHandler.removeAndIgnore(UnassignedInfo.AllocationStatus.DELAYED_ALLOCATION, allocation.changes());  
            if (shardRouting.assignedToNode()) mapToUpdate.put(shardRouting.currentNodeId(), shard);
import java.util.ArrayList;
import java.util.TreeMap;
 * compatible open source license.
    ) {
    }  
            // no-op
 * not use this file except in compliance with the License.
        return new AllocationDeciders(Collections.singleton(new TestAllocateDecision(Decision.NO)));
    }
                new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)  
}
     *  
            SNAPSHOT_INFO_SERVICE_WITH_NO_SHARD_SIZES,
            totalShards[0] = totalShards[1] = 0;
import org.opensearch.cluster.routing.allocation.allocator.ShardsAllocator;
    }  
        }
    }
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
    public static MockAllocationService createAllocationService(Settings settings, ClusterSettings clusterSettings, Random random) {
        public void afterPrimariesBeforeReplicas(RoutingAllocation allocation) {
    }
        );
        }  
    }
        return createAllocationService(settings, gatewayAllocator, SNAPSHOT_INFO_SERVICE_WITH_NO_SHARD_SIZES);  
            new TestGatewayAllocator(),  
                    Settings.EMPTY,
    protected static AllocationDeciders throttleAllocationDeciders() {
        return startInitialisingShardsAndReroute(strategy, clusterState, initializingShards);  
        List<ShardRouting> initializingShards
                new SameShardAllocationDecider(
        return new MockAllocationService(
    }  
            Arrays.asList(  
    }  
     */
        public void applyFailedShards(List<FailedShard> failedShards, RoutingAllocation allocation) {  
    }  
import org.opensearch.cluster.routing.RoutingNode;
            }  
        }
        }
        List<ShardRouting> initializingShards
            } else {
            return decision;
 * under the License.  
                allocationDeciders,
        new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
        ClusterState clusterState,  
            SnapshotsInfoService snapshotsInfoService
            EmptyClusterInfoService.INSTANCE,  
            GatewayAllocator gatewayAllocator,
        List<AllocationDecider> deciders = new ArrayList<>(  
    }  
     * Mark all initializing shards on the given node as started, then perform a reroute (which may start some other shards initializing).
 */  
 * ownership. Elasticsearch licenses this file to you under  
    public static MockAllocationService createAllocationService(Settings settings) {
    }  
        }
    ) {
    /**
    protected static DiscoveryNode newNode(String nodeId, Map<String, String> attributes) {  
    }  
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
            clusterState,
    protected static DiscoveryNode newNode(String nodeName, String nodeId, Map<String, String> attributes) {
                new SameShardAllocationDecider(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),  
        );
            Settings settings
                snapshotsInfoService,
            this.decision = decision;  
                clusterInfoService,  
 *
            settings
import org.opensearch.cluster.node.DiscoveryNode;
    public static MockAllocationService createAllocationService() {
    /** A lock {@link AllocationService} allowing tests to override time */
        return createAllocationService(settings, EMPTY_CLUSTER_SETTINGS, random);
    }
            randomAllocationDeciders(settings, clusterSettings, random),  
            Formatter formatter = new Formatter(sb, Locale.getDefault());
        public TestAllocateDecision(Decision decision) {
        }
    protected static AllocationDeciders yesAllocationDeciders() {
         */  
 * this file be licensed under the Apache-2.0 license or a
            clusterState.routingTable().index(index).shardsWithState(INITIALIZING)  
        );  
 *
        AllocationService allocationService,
        @Override  
import org.opensearch.gateway.GatewayAllocator;  
 * The OpenSearch Contributors require contributions made to  
    protected static class MockAllocationService extends AllocationService {
 * the Apache License, Version 2.0 (the "License"); you may
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), emptyMap(), SEARCH_ROLE, version);  
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), attributes, SEARCH_ROLE, Version.CURRENT);
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;  
            clusterInfoService,
/*  
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), attributes, CLUSTER_MANAGER_DATA_ROLES, Version.CURRENT);
                String nodeId = nameToNodeId.get(entry.getKey());  
        }
            clusterState = startInitializingShardsAndReroute(service, clusterState);
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), emptyMap(), CLUSTER_MANAGER_DATA_ROLES, version);
        static TreeMap<String, int[]> nodeToShardCountMap = new TreeMap<>();
                : "Expecting a recovery source of type [SNAPSHOT] but got [" + shardRouting.recoverySource().getType() + ']';
            }
        ClusterSettings.BUILT_IN_CLUSTER_SETTINGS
            sb.append(TWO_LINE_RETURN + separator + ONE_LINE_RETURN);  
import java.util.Locale;
    }
    protected static Set<DiscoveryNodeRole> CLUSTER_MANAGER_DATA_ROLES = Collections.unmodifiableSet(
        return allocationService.reroute(allocationService.applyStartedShards(clusterState, initializingShards), "reroute after starting");  
        return newNode(nodeId, Version.CURRENT);
    }
 * GitHub history for details.
    }
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
    ) {
import java.util.Set;
        public MockAllocationService(  
            return sb.toString();
    }
                new SameShardAllocationDecider(  
    public static MockAllocationService createAllocationService(Settings settings, Random random) {  
     * Mocks behavior in ReplicaShardAllocator to remove delayed shards from list of unassigned shards so they don't get reassigned yet.
                // Fetch shard to update. Initialize local array
    protected static DiscoveryNode newSearchNode(String nodeId, Map<String, String> attributes) {  
import java.util.Random;  
    }
    protected static Set<DiscoveryNodeRole> SEARCH_ROLE = Collections.unmodifiableSet(
        static int[] unassigned = new int[2];
        }
            for (Map.Entry<String, String> entry : nameToNodeId.entrySet()) {
        return clusterState;
                )  
