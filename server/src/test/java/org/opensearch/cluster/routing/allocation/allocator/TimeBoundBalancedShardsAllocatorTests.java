        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);
                listener.onFailure(new OpenSearchException("simulated"));
        setupStateAndService(metadata, routingTable);
        );
            allocationDecidersForExcludeAPI(newSettings),
        int numberOfShards = 5;
            null,
        // Valid setting with timeout > 20s
        allocator.allocate(allocation);
            }
 * SPDX-License-Identifier: Apache-2.0
        // check all shards allocated
    }
        assertEquals(totalShardCount, state.getRoutingNodes().shardsWithState(STARTED).size());
            state,
        setupStateAndService(metadata, routingTable);
            } else {
        assertTrue(rerouteScheduled.get());
        // passing 0 for timed out latch such that all shard times out
            rerouteScheduled.compareAndSet(false, true);
            assertEquals(Priority.NORMAL, priority);
        final RerouteService rerouteService = (reason, priority, listener) -> {
            assertEquals("reroute after balanced shards allocator timed out", reason);
        List<ShardRouting> relocatingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.RELOCATING);
        int numberOfReplicas = 1;
            rerouteScheduled.compareAndSet(false, true);
import org.opensearch.cluster.ClusterState;
        assertEquals(0, initializingShards.size());
        Settings.Builder settings = Settings.builder();
        setupStateAndService(metadata, routingTable);
        // passing shards to allocate for timed out latch such that all primary shards and few replica shards are allocated in this reroute
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);
    }
    }
                listener.onFailure(new OpenSearchException("simulated"));
        assertFalse(rerouteScheduled.get());
            new RoutingNodes(state, false),
    @Override
 * compatible open source license.
        // passing sufficiently high count for timeout latch to simulate no time out
            }
        RoutingTable routingTable = buildRoutingTable(metadata);
        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);
    public void testAllocateAllPrimaryShardsAndPartialReplicaShardsUntilTimedOutAndRerouteScheduled() {
    }
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        RoutingTable routingTable = buildRoutingTable(metadata);
                return Decision.YES;
            new RoutingNodes(state, false),
            } else {
            System.nanoTime()
            assertEquals("reroute after balanced shards allocator timed out", reason);
                listener.onResponse(clusterService.state());
        int shardsToAllocate = randomIntBetween(1, numberOfShards * numberOfIndices);
            if (randomBoolean()) {
            null,
        List<ShardRouting> initializingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);
    }
    }
        int numberOfShards = 15;
        RoutingAllocation allocation = new RoutingAllocation(
            state,
        assertTrue(rerouteScheduled.get());
            ClusterInfo.EMPTY,
        assertEquals(20, ALLOCATOR_TIMEOUT_SETTING.get(build).getSeconds());
                listener.onResponse(clusterService.state());
            }
import java.util.Arrays;
            .routingTable(routingTable)
            clusterService.close();
        Settings newSettings = Settings.builder().put("cluster.routing.allocation.exclude.zone", "").build();
            assertEquals(Priority.NORMAL, priority);
            } else {
        protected boolean allocatorTimedOut() {
        assertFalse(allocator.allocatorTimedOut());
        // since for moves, it creates an iterator over shards which interleaves between nodes, hence
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));
    private Metadata buildMetadata(Metadata.Builder mb, int numberOfIndices, int numberOfShards, int numberOfReplicas) {
        int node3Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node3.getId());
        build = Settings.builder().put(settingKey, "urgent").build();
                listener.onFailure(new OpenSearchException("simulated"));
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));
            IllegalArgumentException.class,
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(settings.build(), new CountDownLatch(shardsToAllocate));
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));
        setupStateAndService(metadata, routingTable);
        };
            rerouteScheduled.compareAndSet(false, true);
        );
            } else {
        assertEquals(0, node1Recoveries + node2Recoveries + node3Recoveries);
            rerouteScheduled.compareAndSet(false, true);
        RoutingAllocation allocation = new RoutingAllocation(
                return Decision.NO;
        int numberOfReplicas = 1;
        List<ShardRouting> initializingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);
        final RerouteService rerouteService = (reason, priority, listener) -> {
        int numberOfReplicas = 1;
            System.nanoTime()
            state,
            System.nanoTime()
        assertEquals(totalShardCount / 3, relocatingShards.size());
        state = applyStartedShardsUntilNoChange(state, allocationService);
        assertEquals(totalShardCount, initializingShards.size());
            yesAllocationDeciders(),
                listener.onResponse(clusterService.state());
        );
import org.opensearch.cluster.routing.RoutingTable;
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);
        assertEquals(-1, ALLOCATOR_TIMEOUT_SETTING.get(build).getMillis());
            @Override
            if (randomBoolean()) {
        ); // such that no shards are allocated to node1
            assertEquals(Priority.NORMAL, priority);
        }
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);
    private ClusterState state;
        );
            Settings.builder().put("cluster.routing.allocation.exclude.zone", "1a").build()
            rerouteScheduled.compareAndSet(false, true);
            }
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(build);
    }
            assertEquals("reroute after balanced shards allocator timed out", reason);
        int node3Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node3.getId());
        int node1Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node1.getId());
        assertEquals(shardsToAllocate, initializingShards.size());
/*
        List<ShardRouting> relocatingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.RELOCATING);
        assertEquals(totalShardCount - shardsToAllocate, allocation.routingNodes().unassigned().ignored().size());
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);
        int totalPrimaryCount = numberOfIndices * numberOfShards;
        state = applyStartedShardsUntilNoChange(state, allocationService);
        // Invalid setting with timeout < 20s
    }
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));
        allocator.setRerouteService(rerouteService);
        };
            allocationDecidersForExcludeAPI(settings),
            System.nanoTime()
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));
        };
import java.util.List;
        RoutingAllocation allocation = new RoutingAllocation(
        state = applyStartedShardsUntilNoChange(state, allocationService);
        for (Map.Entry<String, IndexMetadata> entry : metadata.getIndices().entrySet()) {
            if (randomBoolean()) {
            state,
    }
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(settings, new CountDownLatch(Integer.MAX_VALUE));
        // making custom set of allocation deciders such that it never attempts to move shards but always attempts to rebalance
        int numberOfReplicas = 1;
            () -> ALLOCATOR_TIMEOUT_SETTING.get(lessThan20sSetting)
        int node1ShardCount = state.getRoutingNodes().node("node1").size();
            assertEquals("reroute after balanced shards allocator timed out", reason);
    static class TestBalancedShardsAllocator extends BalancedShardsAllocator {
            }
import org.opensearch.cluster.routing.RoutingNodes;
            rerouteScheduled.compareAndSet(false, true);
            assertEquals(Priority.HIGH, priority);
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));
            }
        public TestBalancedShardsAllocator(Settings settings, CountDownLatch timedOutLatch) {
        state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
import static org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator.ALLOCATOR_TIMEOUT_SETTING;
            ClusterInfo.EMPTY,
        assertEquals(shardsToAllocate, initializingShards.size());
        // adding +1 as during rebalance we do per index timeout check and then per node check
            () -> FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(wrongPriority2)
            @Override
import org.opensearch.Version;
        final RerouteService rerouteService = (reason, priority, listener) -> {
        int shardsToMove = 6; // such that time out is never breached
                IndexMetadata.builder("test_" + i)
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));
        Settings wrongPriority2 = Settings.builder().put(settingKey, "random").build();
        assertEquals(shardsToAllocate, node1Recoveries + node2Recoveries + node3Recoveries);
    public void testAllUnassignedShardsAllocatedWhenNoTimeOutAndRerouteNotScheduled() {
        int numberOfShards = 5;
            null,
        return mb.build();
        @Override
        Settings build = Settings.builder().put(settingKey, "20s").build();
        RoutingTable routingTable = buildRoutingTable(metadata);
        int numberOfShards = 5;
        int numberOfReplicas = 1;
        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);
            ClusterInfo.EMPTY,
            null,
        assertEquals(0, state.getRoutingNodes().shardsWithState(INITIALIZING).size());
            yesAllocationDeciders(),
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
import java.util.Map;
            System.nanoTime()
        };
        int numberOfShards = 5;
import java.util.concurrent.CountDownLatch;
        build = Settings.builder().put(settingKey, "30000ms").build();
        MockAllocationService allocationService = createAllocationService();
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(settings.build(), new CountDownLatch(Integer.MAX_VALUE));
    public void setupStateAndService(Metadata metadata, RoutingTable routingTable) {
        threadPool = new TestThreadPool(getTestName());
                listener.onResponse(clusterService.state());
            assertEquals("reroute after balanced shards allocator timed out", reason);
    }
            new RoutingNodes(state, false),
        }
        int numberOfShards = 15;
        }, new AllocationDecider() {
            new RoutingNodes(state, false),
        Settings settings = Settings.builder().put("cluster.routing.allocation.exclude.zone", "1a").build();
    private final DiscoveryNode node2 = newNode("node2", "node2", Collections.singletonMap("zone", "1b"));
        final RerouteService rerouteService = (reason, priority, listener) -> {
        assertEquals("No enum constant org.opensearch.common.Priority.RANDOM", iae2.getMessage());
        assertEquals(totalShardCount, state.getRoutingNodes().shardsWithState(STARTED).size());
        Settings.Builder settings = Settings.builder();
    public void testFollowupPriorityValues() {
        // Valid setting with timeout = -1
            ClusterInfo.EMPTY,
            if (timedOutLatch.getCount() == 0) {
            ClusterInfo.EMPTY,
import org.opensearch.cluster.ClusterInfo;
            if (randomBoolean()) {
        setupStateAndService(metadata, routingTable);
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);
            ClusterInfo.EMPTY,
import org.opensearch.cluster.service.ClusterService;
    }
        MockAllocationService allocationService = createAllocationService(
            () -> FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(wrongPriority)
            null,
            timedOutLatch.countDown();
        int node1Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node1.getId());
import org.opensearch.test.ClusterServiceUtils;
        state = applyStartedShardsUntilNoChange(state, allocationService);
        }
                return true;
            if (randomBoolean()) {
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(newSettings, new CountDownLatch(shardsToMove + 1));
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(newSettings, new CountDownLatch(Integer.MAX_VALUE));
        assertEquals(3, relocatingShards.size());
        assertEquals(totalShardCount - shardsToAllocate, allocation.routingNodes().unassigned().ignored().size());
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));
            yesAllocationDeciders(),
        final RerouteService rerouteService = (reason, priority, listener) -> {
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));
        assertEquals(0, state.getRoutingNodes().shardsWithState(INITIALIZING).size());
        assertEquals(0, node1ShardCount);
                    .numberOfShards(numberOfShards)
        int node3Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node3.getId());
        assertEquals("priority [IMMEDIATE] not supported for [" + FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey() + "]", iae.getMessage());
            ClusterInfo.EMPTY,
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);
        List<ShardRouting> relocatingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.RELOCATING);
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;
        RoutingAllocation allocation = new RoutingAllocation(
        int numberOfIndices = 2;
        int numberOfIndices = 2;
        IllegalArgumentException iae = expectThrows(
            allocationDecidersForExcludeAPI(newSettings),
        int node1Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node1.getId());
        List<ShardRouting> initializingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);
        assertEquals(shardsToMove / 3, relocatingShards.size());
        int shardsToMove = 3; // such that it only partially balances few shards
            null,
        allocator.allocate(allocation);
            assertEquals("reroute after balanced shards allocator timed out", reason);
        assertTrue(rerouteScheduled.get());
        );
        MockAllocationService allocationService = createAllocationService();
        build = Settings.builder().put(settingKey, "high").build();
import org.opensearch.cluster.metadata.IndexMetadata;
            Settings.builder().put("cluster.routing.allocation.exclude.zone", "1a").build()
        allocator.allocate(allocation);
        int numberOfIndices = 1;
        setupStateAndService(metadata, routingTable);
        Settings newSettings = Settings.builder().put("cluster.routing.allocation.exclude.zone", "").build();
    private TestThreadPool threadPool;
        private final CountDownLatch timedOutLatch;
        int node1Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node1.getId());
                listener.onFailure(new OpenSearchException("simulated"));
            state,
 * The OpenSearch Contributors require contributions made to
            .metadata(metadata)
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(newSettings, new CountDownLatch(shardsToMove));
    @After
        setupStateAndService(metadata, routingTable);
            IllegalArgumentException.class,
        int numberOfReplicas = 1;
        // check all shards allocated
        allocator.setRerouteService(rerouteService);
        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);
                listener.onFailure(new OpenSearchException("simulated"));
        assertEquals(0, state.getRoutingNodes().shardsWithState(INITIALIZING).size());
            Settings.builder().put("cluster.routing.allocation.exclude.zone", "1a").build()
        RoutingAllocation allocation = new RoutingAllocation(
        assertEquals(numberOfShards * numberOfIndices, node1Recoveries + node2Recoveries + node3Recoveries);
            } else {
        RoutingAllocation allocation = new RoutingAllocation(
        List<AllocationDecider> allocationDeciders = Arrays.asList(new AllocationDecider() {
            assertEquals(Priority.NORMAL, priority);
            null,
        );
            null,
            } else {
    public void testAllUnassignedShardsIgnoredWhenTimedOutAndRerouteScheduledWithHighPriority() {
        assertEquals(node1ShardCount, relocatingShards.size());
        Settings build = Settings.builder().put(settingKey, "normal").build();
        int node3Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node3.getId());
            if (randomBoolean()) {
        // check all shards allocated
            assertEquals(Priority.NORMAL, priority);
import org.opensearch.cluster.routing.allocation.decider.Decision;
        );
        final RerouteService rerouteService = (reason, priority, listener) -> {
}
                listener.onResponse(clusterService.state());
        assertEquals(0, state.getRoutingNodes().shardsWithState(INITIALIZING).size());
            rerouteScheduled.compareAndSet(false, true);
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(settings.build(), new CountDownLatch(shardsToAllocate));
        MockAllocationService allocationService = createAllocationService(
        assertEquals(Priority.URGENT, FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(build));
            if (randomBoolean()) {
                listener.onFailure(new OpenSearchException("simulated"));
        assertFalse(rerouteScheduled.get());
                listener.onFailure(new OpenSearchException("simulated"));
        }
            new RoutingNodes(state, false),
            assertEquals("reroute after balanced shards allocator timed out", reason);
        int node3Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node3.getId());
            new RoutingNodes(state, false),
        List<ShardRouting> relocatingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.RELOCATING);
import org.opensearch.cluster.routing.RerouteService;
            super(settings);
        Settings.Builder settings = Settings.builder();
        int numberOfShards = 5;
        allocator.allocate(allocation);
        List<ShardRouting> relocatingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.RELOCATING);
    private final DiscoveryNode node1 = newNode("node1", "node1", Collections.singletonMap("zone", "1a"));
    }
        int numberOfShards = 5;
        super.tearDown();
        assertEquals(0, node1ShardCount);
        allocator.setRerouteService(rerouteService);
            new RoutingNodes(state, false),
            state,
        setupStateAndService(metadata, routingTable);
 *
        ); // such that no shards are allocated to node1
    }
            assertEquals("reroute after balanced shards allocator timed out", reason);
            routingTableBuilder.addAsNew(entry.getValue());
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));
        int numberOfReplicas = 1;
        Settings.Builder settings = Settings.builder()
        int numberOfIndices = 3;
                listener.onResponse(clusterService.state());
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(settings, new CountDownLatch(shardsToMove));
            ClusterInfo.EMPTY,
            state,
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);
        ); // such that no shards are allocated to node1
            }
        for (int i = 0; i < numberOfIndices; i++) {
            yesAllocationDeciders(),
            public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
                listener.onResponse(clusterService.state());
    }
        Settings.Builder settings = Settings.builder();
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
                listener.onFailure(new OpenSearchException("simulated"));
            null,
        setupStateAndService(metadata, routingTable);
            rerouteScheduled.compareAndSet(false, true);
        int node1ShardCount = state.getRoutingNodes().node("node1").size();
            null,
        RoutingTable routingTable = buildRoutingTable(metadata);
                listener.onResponse(clusterService.state());
    public void testAllUnassignedShardsIgnoredWhenTimedOutAndRerouteScheduled() {
        int node1ShardCount = state.getRoutingNodes().node("node1").size();
    }
import java.util.concurrent.atomic.AtomicBoolean;
        );
                    .settings(settings(Version.CURRENT))
        assertTrue(rerouteScheduled.get());
 */
        };
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(settings.build(), new CountDownLatch(0));
        RoutingTable routingTable = buildRoutingTable(metadata);
        setupStateAndService(metadata, routingTable);
        assertEquals(Priority.HIGH, FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(build));
            }
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        int numberOfReplicas = 1;
        Settings build = Settings.builder().put("cluster.routing.allocation.balanced_shards_allocator.allocator_timeout", "-1").build();
import org.opensearch.cluster.node.DiscoveryNode;
        RoutingAllocation allocation = new RoutingAllocation(
 * this file be licensed under the Apache-2.0 license or a
        clusterService = ClusterServiceUtils.createClusterService(state, threadPool);
            assertEquals(Priority.NORMAL, priority);
import org.opensearch.common.settings.Settings;
public class TimeBoundBalancedShardsAllocatorTests extends OpenSearchAllocationTestCase {
        assertEquals(totalShardCount, allocation.routingNodes().unassigned().ignored().size());
import org.opensearch.common.settings.ClusterSettings;
        assertEquals(totalPrimaryCount, node1Recoveries + node2Recoveries + node3Recoveries);
        allocator.allocate(allocation);
            System.nanoTime()
        int numberOfIndices = 2;
            }
            ClusterInfo.EMPTY,
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))
        allocator.setRerouteService(rerouteService);
        allocator.allocate(allocation);
        assertEquals(0, initializingShards.size());
        // shards from node1 can actually move. Hence, total moves that will be executed is 2 (6/3).
        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);
        List<ShardRouting> relocatingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.RELOCATING);
        );
    public void testClusterRebalancedWhenNotTimedOutAndRerouteNotScheduled() {
import org.opensearch.threadpool.TestThreadPool;
        int numberOfIndices = 3;
    private RoutingTable buildRoutingTable(Metadata metadata) {
            }
        );
    }
        allocator.allocate(allocation);
        final RerouteService rerouteService = (reason, priority, listener) -> {
            assertEquals("reroute after balanced shards allocator timed out", reason);
            } else {
        };
        assertTrue(rerouteScheduled.get());
            new RoutingNodes(state, false),
import org.opensearch.OpenSearchException;
        int node2Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node2.getId());
package org.opensearch.cluster.routing.allocation.allocator;
            assertEquals("reroute after balanced shards allocator timed out", reason);
        // Valid setting with timeout = 20s
            );
        int node2Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node2.getId());
        }, new SameShardAllocationDecider(newSettings, new ClusterSettings(newSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)));
        Settings newSettings = Settings.builder().put("cluster.routing.allocation.exclude.zone", "").build();
        Settings wrongPriority = Settings.builder().put(settingKey, "immediate").build();
        assertEquals(0, state.getRoutingNodes().shardsWithState(INITIALIZING).size());
            return false;
        assertEquals(0, state.getRoutingNodes().shardsWithState(INITIALIZING).size());
        RoutingTable routingTable = buildRoutingTable(metadata);
        allocator.allocate(allocation);
        int numberOfIndices = 1;
        allocator.setRerouteService(rerouteService);
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);
    }
        assertEquals(0, allocation.routingNodes().unassigned().ignored().size());
    public void testPartialShardsMoveWhenExcludedAndTimeoutBreachedAndRerouteScheduled() {
        assertTrue(rerouteScheduled.get());
                listener.onResponse(clusterService.state());
        assertEquals(0, relocatingShards.size());
        assertEquals(30, ALLOCATOR_TIMEOUT_SETTING.get(build).getSeconds());
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
            System.nanoTime()
            } else {
            } else {
        assertTrue(rerouteScheduled.get());
        RoutingTable routingTable = buildRoutingTable(metadata);
        assertEquals(0, node1ShardCount);
            rerouteScheduled.compareAndSet(false, true);
        assertEquals(totalShardCount, state.getRoutingNodes().shardsWithState(STARTED).size());
        // check all shards allocated
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(settings.build(), new CountDownLatch(0));
        RoutingAllocation allocation = new RoutingAllocation(
        int numberOfShards = 5;
        int shardsToAllocate = randomIntBetween(numberOfShards * numberOfIndices, totalShardCount);
            rerouteScheduled.compareAndSet(false, true);
        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);
        int shardsToMove = 0; // such that it never balances anything
        int numberOfIndices = 2;
        int node1ShardCount = state.getRoutingNodes().node("node1").size();
        );
            state,
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);
        List<ShardRouting> initializingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);
                    .numberOfReplicas(numberOfReplicas)
import org.junit.After;
        int shardsToMove = 0; // such that time out is breached
import static org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator.FOLLOW_UP_REROUTE_PRIORITY_SETTING;
            }
            if (randomBoolean()) {
        // passing shards to allocate for timed out latch such that only few primary shards are allocated in this reroute round
        allocator.setRerouteService(rerouteService);
        allocator.setRerouteService(rerouteService);
            new AllocationDeciders(allocationDeciders),
        final RerouteService rerouteService = (reason, priority, listener) -> {
        List<ShardRouting> initializingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);
        allocator.setRerouteService(rerouteService);
import org.opensearch.cluster.routing.ShardRoutingState;
        state = applyStartedShardsUntilNoChange(state, allocationService);
            }
        int node2Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node2.getId());
        if (clusterService != null) {
        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);
                listener.onFailure(new OpenSearchException("simulated"));
            state,
        int node1Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node1.getId());
    private ClusterService clusterService;
        assertEquals(Priority.NORMAL, FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(build));
                listener.onResponse(clusterService.state());
            assertEquals(Priority.NORMAL, priority);
        };
import org.opensearch.cluster.node.DiscoveryNodes;
        MockAllocationService allocationService = createAllocationService(
        int numberOfShards = 15;
            if (randomBoolean()) {
    public void testAllShardsMoveWhenExcludedAndTimeoutNotBreachedAndRerouteNotScheduled() {
            state,
        // round
            assertEquals("reroute after balanced shards allocator timed out", reason);
        assertTrue(rerouteScheduled.get());
        RoutingTable routingTable = buildRoutingTable(metadata);
        int node2Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node2.getId());
        );
        assertEquals(totalShardCount, state.getRoutingNodes().shardsWithState(STARTED).size());
            mb.put(
        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);
                listener.onFailure(new OpenSearchException("simulated"));
            new RoutingNodes(state, false),
        int numberOfShards = 5;
    }
            ClusterInfo.EMPTY,
            if (randomBoolean()) {
        final RerouteService rerouteService = (reason, priority, listener) -> {
            }
        assertEquals(0, node1Recoveries + node2Recoveries + node3Recoveries);
        final RerouteService rerouteService = (reason, priority, listener) -> {
            .put("cluster.routing.allocation.balanced_shards_allocator.schedule_reroute.priority", "high");
        assertEquals("Setting [" + settingKey + "] should be more than 20s or -1ms to disable timeout", iae.getMessage());
            this.timedOutLatch = timedOutLatch;
        allocator.setRerouteService(rerouteService);
import java.util.Collections;
    }
        allocator.setRerouteService(rerouteService);
        int numberOfReplicas = 1;
        assertEquals(totalShardCount, state.getRoutingNodes().shardsWithState(STARTED).size());
            new RoutingNodes(state, false),
            yesAllocationDeciders(),
        );
        }
    public void testAllocatorNeverTimedOutIfValueIsMinusOne() {
            assertEquals(Priority.NORMAL, priority);
            IllegalArgumentException.class,
        build = Settings.builder().put(settingKey, "-1").build();
import org.opensearch.cluster.ClusterName;
            rerouteScheduled.compareAndSet(false, true);
        RoutingAllocation allocation = new RoutingAllocation(
        final RerouteService rerouteService = (reason, priority, listener) -> {
            System.nanoTime()
        // check all shards allocated
        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);
        // for shardsToMove=6, it will have 2 shards from node1, node2, node3 each attempting to move with only
        RoutingTable routingTable = buildRoutingTable(metadata);
        allocator.allocate(allocation);
        int numberOfIndices = 2;
        int node2Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node2.getId());
            final boolean terminated = terminate(threadPool);
        String settingKey = "cluster.routing.allocation.balanced_shards_allocator.allocator_timeout";
        RoutingAllocation allocation = new RoutingAllocation(
        };
        };
            System.nanoTime()
        // passing 0 for timed out latch such that all shard times out
        };
        assertFalse(rerouteScheduled.get());
        state = applyStartedShardsUntilNoChange(state, allocationService);
    public void testNoShardsMoveWhenExcludedAndTimeoutBreachedAndRerouteScheduled() {
            } else {
        return routingTableBuilder.build();
        allocator.allocate(allocation);
            public Decision canMoveAnyShard(RoutingAllocation allocation) {
        int numberOfReplicas = 1;
        Settings settings = Settings.builder().put("cluster.routing.allocation.exclude.zone", "1a").build();
        );
    public void testClusterNotRebalancedWhenTimedOutAndRerouteScheduled() {
    public void testAllocatePartialPrimaryShardsUntilTimedOutAndRerouteScheduled() {
            assert terminated;
        assertEquals(totalShardCount, state.getRoutingNodes().shardsWithState(STARTED).size());
        MockAllocationService allocationService = createAllocationService();
        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);
        assertEquals(totalShardCount, allocation.routingNodes().unassigned().ignored().size());
            if (randomBoolean()) {
        IllegalArgumentException iae2 = expectThrows(
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            assertEquals(Priority.NORMAL, priority);
            allocationDecidersForExcludeAPI(settings),
        if (threadPool != null) {
        setupStateAndService(metadata, routingTable);
            allocationDecidersForExcludeAPI(settings),
            assertEquals(Priority.NORMAL, priority);
        int numberOfIndices = 1;
import org.opensearch.cluster.routing.ShardRouting;
        RoutingTable routingTable = buildRoutingTable(metadata);
            .build();
            System.nanoTime()
        assertEquals(0, relocatingShards.size());
    public void testClusterPartialRebalancedWhenTimedOutAndRerouteScheduled() {
        };
import org.opensearch.common.Priority;
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);
        IllegalArgumentException iae = expectThrows(
import org.opensearch.cluster.metadata.Metadata;
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);
                listener.onResponse(clusterService.state());
        }
        Settings settings = Settings.builder().put("cluster.routing.allocation.exclude.zone", "1a").build();
        Settings lessThan20sSetting = Settings.builder().put(settingKey, "10s").build();
        String settingKey = "cluster.routing.allocation.balanced_shards_allocator.schedule_reroute.priority";
                listener.onFailure(new OpenSearchException("simulated"));
            new RoutingNodes(state, false),
            state,
            } else {
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(settings, new CountDownLatch(shardsToMove));
        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);
    private final DiscoveryNode node3 = newNode("node3", "node3", Collections.singletonMap("zone", "1c"));
            System.nanoTime()
        allocator.allocate(allocation);
        int numberOfReplicas = 1;
        // check all shards allocated
        RoutingAllocation allocation = new RoutingAllocation(
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        RoutingTable routingTable = buildRoutingTable(metadata);
            ClusterInfo.EMPTY,
            }
    public void tearDown() throws Exception {
        allocator.setRerouteService(rerouteService);
            null,
    public void testAllocatorTimeout() {
        int numberOfIndices = 3;
