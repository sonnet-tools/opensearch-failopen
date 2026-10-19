        Settings settings = Settings.builder().put("cluster.routing.allocation.exclude.zone", "1a").build();
        setupStateAndService(metadata, routingTable);
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);
        allocator.allocate(allocation);
        String settingKey = "cluster.routing.allocation.balanced_shards_allocator.schedule_reroute.priority";
            ClusterInfo.EMPTY,
    }  
import org.opensearch.cluster.routing.allocation.decider.Decision;
        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);
            ClusterInfo.EMPTY,  
        };
            } else {
import java.util.List;
        );  
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));
            assertEquals("reroute after balanced shards allocator timed out", reason);
            new RoutingNodes(state, false),
        }
            rerouteScheduled.compareAndSet(false, true);
        assertEquals(totalShardCount - shardsToAllocate, allocation.routingNodes().unassigned().ignored().size());  
        Settings build = Settings.builder().put(settingKey, "20s").build();
        // round
        setupStateAndService(metadata, routingTable);
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(newSettings, new CountDownLatch(shardsToMove + 1));
            }
import java.util.Arrays;
        build = Settings.builder().put(settingKey, "-1").build();  
        );
        int numberOfIndices = 3;
            @Override
    public void testClusterNotRebalancedWhenTimedOutAndRerouteScheduled() {
            IllegalArgumentException.class,
            assertEquals("reroute after balanced shards allocator timed out", reason);
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;
        int numberOfShards = 5;
        setupStateAndService(metadata, routingTable);
import org.opensearch.cluster.routing.ShardRoutingState;  
            rerouteScheduled.compareAndSet(false, true);
        int node3Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node3.getId());
        assertEquals(30, ALLOCATOR_TIMEOUT_SETTING.get(build).getSeconds());
        state = applyStartedShardsUntilNoChange(state, allocationService);
                listener.onFailure(new OpenSearchException("simulated"));
        // passing sufficiently high count for timeout latch to simulate no time out  
            } else {
            mb.put(
        RoutingAllocation allocation = new RoutingAllocation(
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(newSettings, new CountDownLatch(Integer.MAX_VALUE));
        allocator.setRerouteService(rerouteService);
        int node3Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node3.getId());  
        state = applyStartedShardsUntilNoChange(state, allocationService);
        int numberOfReplicas = 1;
        // passing 0 for timed out latch such that all shard times out
        }  
        int node1Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node1.getId());  
                listener.onFailure(new OpenSearchException("simulated"));
        RoutingAllocation allocation = new RoutingAllocation(
        int node1Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node1.getId());
        // Valid setting with timeout = -1
        // since for moves, it creates an iterator over shards which interleaves between nodes, hence  
        allocator.allocate(allocation);
                listener.onResponse(clusterService.state());  
        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);
        };  
            yesAllocationDeciders(),  
            assertEquals(Priority.HIGH, priority);
            }
        // for shardsToMove=6, it will have 2 shards from node1, node2, node3 each attempting to move with only
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(settings, new CountDownLatch(shardsToMove));
            state,
            yesAllocationDeciders(),
        for (int i = 0; i < numberOfIndices; i++) {  
        assertTrue(rerouteScheduled.get());
        int node3Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node3.getId());
        ); // such that no shards are allocated to node1  
        assertEquals(shardsToAllocate, node1Recoveries + node2Recoveries + node3Recoveries);
    public void testFollowupPriorityValues() {
        private final CountDownLatch timedOutLatch;
        IllegalArgumentException iae = expectThrows(
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));  
        }
            null,
        Settings settings = Settings.builder().put("cluster.routing.allocation.exclude.zone", "1a").build();  
        allocator.allocate(allocation);
            state,
        MockAllocationService allocationService = createAllocationService();  
        allocator.allocate(allocation);
    }
            assertEquals("reroute after balanced shards allocator timed out", reason);
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));
        int node2Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node2.getId());  
        allocator.allocate(allocation);
        build = Settings.builder().put(settingKey, "30000ms").build();  
        );  
            }
import org.opensearch.cluster.ClusterName;
        final RerouteService rerouteService = (reason, priority, listener) -> {
        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);
        };  
            rerouteScheduled.compareAndSet(false, true);
public class TimeBoundBalancedShardsAllocatorTests extends OpenSearchAllocationTestCase {
        assertEquals(0, allocation.routingNodes().unassigned().ignored().size());
            final boolean terminated = terminate(threadPool);
            null,
        assertEquals(0, state.getRoutingNodes().shardsWithState(INITIALIZING).size());  
        assertEquals(-1, ALLOCATOR_TIMEOUT_SETTING.get(build).getMillis());
        allocator.setRerouteService(rerouteService);
            if (randomBoolean()) {  
            }  
        if (threadPool != null) {
                listener.onFailure(new OpenSearchException("simulated"));
        MockAllocationService allocationService = createAllocationService();  
        MockAllocationService allocationService = createAllocationService();  
        assertTrue(rerouteScheduled.get());
            state,
        RoutingTable routingTable = buildRoutingTable(metadata);
        IllegalArgumentException iae2 = expectThrows(
        build = Settings.builder().put(settingKey, "high").build();  
            }
 * SPDX-License-Identifier: Apache-2.0
        allocator.allocate(allocation);
        int numberOfReplicas = 1;
            }
        allocator.setRerouteService(rerouteService);  
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);  
        state = applyStartedShardsUntilNoChange(state, allocationService);  
            }
    }
        allocator.allocate(allocation);  
        int shardsToMove = 0; // such that time out is breached  
        assertEquals(20, ALLOCATOR_TIMEOUT_SETTING.get(build).getSeconds());  
        );
        Settings wrongPriority = Settings.builder().put(settingKey, "immediate").build();  
}
            null,
    private TestThreadPool threadPool;
import org.opensearch.cluster.service.ClusterService;  
    public void testAllUnassignedShardsIgnoredWhenTimedOutAndRerouteScheduled() {  
                listener.onResponse(clusterService.state());  
            public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
        };
        assertEquals(shardsToAllocate, initializingShards.size());
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));  
        List<ShardRouting> relocatingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.RELOCATING);
            } else {
            assertEquals(Priority.NORMAL, priority);
        assertTrue(rerouteScheduled.get());
            if (randomBoolean()) {  
import org.opensearch.common.Priority;
        setupStateAndService(metadata, routingTable);  
            if (randomBoolean()) {
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);  
                listener.onResponse(clusterService.state());  
        );
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(newSettings, new CountDownLatch(shardsToMove));
            if (randomBoolean()) {
        int shardsToMove = 6; // such that time out is never breached  
import org.junit.After;  
        allocator.setRerouteService(rerouteService);  
        int numberOfReplicas = 1;  
            if (randomBoolean()) {
        assertEquals(0, state.getRoutingNodes().shardsWithState(INITIALIZING).size());  
    }
            null,
        Settings.Builder settings = Settings.builder()
        assertEquals(totalShardCount - shardsToAllocate, allocation.routingNodes().unassigned().ignored().size());
            }
    private ClusterService clusterService;
            null,
        assertFalse(rerouteScheduled.get());
        assertEquals(totalShardCount, state.getRoutingNodes().shardsWithState(STARTED).size());
        int numberOfIndices = 2;  
        final RerouteService rerouteService = (reason, priority, listener) -> {
            this.timedOutLatch = timedOutLatch;
            } else {
            () -> ALLOCATOR_TIMEOUT_SETTING.get(lessThan20sSetting)
            assertEquals(Priority.NORMAL, priority);
            rerouteScheduled.compareAndSet(false, true);
        Settings.Builder settings = Settings.builder();
        Settings.Builder settings = Settings.builder();
        final RerouteService rerouteService = (reason, priority, listener) -> {
            }
            ClusterInfo.EMPTY,
        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);
        return routingTableBuilder.build();
        state = applyStartedShardsUntilNoChange(state, allocationService);  
        // passing 0 for timed out latch such that all shard times out  
        ); // such that no shards are allocated to node1
            yesAllocationDeciders(),  
        final RerouteService rerouteService = (reason, priority, listener) -> {
            null,  
        );
            System.nanoTime()
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));
            }  
        assertEquals(Priority.NORMAL, FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(build));
            new RoutingNodes(state, false),
        assertFalse(rerouteScheduled.get());  
    public void testAllocatorTimeout() {
        MockAllocationService allocationService = createAllocationService(  
            .build();  
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(settings.build(), new CountDownLatch(0));
            if (randomBoolean()) {  
        setupStateAndService(metadata, routingTable);
        int node3Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node3.getId());  
    public void testClusterPartialRebalancedWhenTimedOutAndRerouteScheduled() {
        assertTrue(rerouteScheduled.get());
        allocator.setRerouteService(rerouteService);  
                listener.onFailure(new OpenSearchException("simulated"));
        int numberOfReplicas = 1;
        List<ShardRouting> relocatingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.RELOCATING);
            System.nanoTime()
                listener.onResponse(clusterService.state());  
            } else {
            if (timedOutLatch.getCount() == 0) {
        state = applyStartedShardsUntilNoChange(state, allocationService);
    }
        // check all shards allocated  
            clusterService.close();  
        // shards from node1 can actually move. Hence, total moves that will be executed is 2 (6/3).
    @Override
        super.tearDown();  
    }  
    public void setupStateAndService(Metadata metadata, RoutingTable routingTable) {
import java.util.concurrent.atomic.AtomicBoolean;
        int numberOfIndices = 1;
import org.opensearch.cluster.ClusterState;
            System.nanoTime()
        final RerouteService rerouteService = (reason, priority, listener) -> {  
        assertEquals(Priority.URGENT, FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(build));
        int node1ShardCount = state.getRoutingNodes().node("node1").size();
            state,
            new RoutingNodes(state, false),
    }  
            .put("cluster.routing.allocation.balanced_shards_allocator.schedule_reroute.priority", "high");  
            if (randomBoolean()) {  
        assertEquals(shardsToAllocate, initializingShards.size());
                return Decision.YES;  
            assertEquals(Priority.NORMAL, priority);  
        int numberOfReplicas = 1;
        int node2Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node2.getId());
        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);
    public void testAllShardsMoveWhenExcludedAndTimeoutNotBreachedAndRerouteNotScheduled() {
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(settings, new CountDownLatch(shardsToMove));
            allocationDecidersForExcludeAPI(newSettings),  
            null,
        }
        int numberOfIndices = 2;
            new RoutingNodes(state, false),
        assertEquals(totalShardCount, state.getRoutingNodes().shardsWithState(STARTED).size());
            ClusterInfo.EMPTY,
            } else {  
        int numberOfShards = 5;  
            new AllocationDeciders(allocationDeciders),
    }  
        clusterService = ClusterServiceUtils.createClusterService(state, threadPool);
        );
    private final DiscoveryNode node3 = newNode("node3", "node3", Collections.singletonMap("zone", "1c"));
        };  
            new RoutingNodes(state, false),
        final RerouteService rerouteService = (reason, priority, listener) -> {
            assertEquals("reroute after balanced shards allocator timed out", reason);  
        int totalPrimaryCount = numberOfIndices * numberOfShards;  
        assertEquals("No enum constant org.opensearch.common.Priority.RANDOM", iae2.getMessage());  
        assertEquals(0, state.getRoutingNodes().shardsWithState(INITIALIZING).size());
        assertEquals(totalShardCount / 3, relocatingShards.size());  
        final RerouteService rerouteService = (reason, priority, listener) -> {  
        assertEquals(0, node1Recoveries + node2Recoveries + node3Recoveries);  
        }, new SameShardAllocationDecider(newSettings, new ClusterSettings(newSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)));
        int numberOfIndices = 2;  
    public void testClusterRebalancedWhenNotTimedOutAndRerouteNotScheduled() {
            assert terminated;  
        RoutingAllocation allocation = new RoutingAllocation(  
            ClusterInfo.EMPTY,  
        int numberOfIndices = 2;
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);
        allocator.setRerouteService(rerouteService);  
import static org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator.ALLOCATOR_TIMEOUT_SETTING;
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(build);
        int numberOfShards = 15;  
        final RerouteService rerouteService = (reason, priority, listener) -> {
            }
        // check all shards allocated
        // check all shards allocated
            }
                listener.onFailure(new OpenSearchException("simulated"));
                    .numberOfShards(numberOfShards)
                listener.onResponse(clusterService.state());
        int numberOfIndices = 1;  
            state,  
        Settings wrongPriority2 = Settings.builder().put(settingKey, "random").build();
        RoutingAllocation allocation = new RoutingAllocation(
        state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);
                listener.onResponse(clusterService.state());
        int numberOfIndices = 3;
                listener.onFailure(new OpenSearchException("simulated"));
        RoutingTable routingTable = buildRoutingTable(metadata);
        assertEquals(3, relocatingShards.size());
        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);
import org.opensearch.cluster.routing.ShardRouting;
            );  
        }
            state,
        assertTrue(rerouteScheduled.get());
    @After  
    }
        assertEquals(totalPrimaryCount, node1Recoveries + node2Recoveries + node3Recoveries);
        int numberOfReplicas = 1;
        int shardsToMove = 3; // such that it only partially balances few shards  
            assertEquals(Priority.NORMAL, priority);  
            assertEquals("reroute after balanced shards allocator timed out", reason);
        allocator.setRerouteService(rerouteService);
            rerouteScheduled.compareAndSet(false, true);
            Settings.builder().put("cluster.routing.allocation.exclude.zone", "1a").build()
            new RoutingNodes(state, false),
        // making custom set of allocation deciders such that it never attempts to move shards but always attempts to rebalance  
                    .settings(settings(Version.CURRENT))  
            allocationDecidersForExcludeAPI(settings),  
        assertEquals(node1ShardCount, relocatingShards.size());  
        List<ShardRouting> initializingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);  
            rerouteScheduled.compareAndSet(false, true);
            System.nanoTime()  
    private final DiscoveryNode node1 = newNode("node1", "node1", Collections.singletonMap("zone", "1a"));
            } else {  
        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);
                    .numberOfReplicas(numberOfReplicas)
        RoutingTable routingTable = buildRoutingTable(metadata);  
import org.opensearch.cluster.metadata.Metadata;
            yesAllocationDeciders(),
import java.util.Map;
        );  
        int numberOfShards = 5;  
    public void testAllocatePartialPrimaryShardsUntilTimedOutAndRerouteScheduled() {
import static org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator.FOLLOW_UP_REROUTE_PRIORITY_SETTING;  
        assertEquals(0, initializingShards.size());
            } else {
        Settings lessThan20sSetting = Settings.builder().put(settingKey, "10s").build();
        // adding +1 as during rebalance we do per index timeout check and then per node check
        int numberOfShards = 5;  
    }
            if (randomBoolean()) {
        }  
        assertEquals("priority [IMMEDIATE] not supported for [" + FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey() + "]", iae.getMessage());
        allocator.allocate(allocation);
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));
        // check all shards allocated
        assertTrue(rerouteScheduled.get());
        ); // such that no shards are allocated to node1
        RoutingTable routingTable = buildRoutingTable(metadata);
                listener.onResponse(clusterService.state());
    public void testAllocateAllPrimaryShardsAndPartialReplicaShardsUntilTimedOutAndRerouteScheduled() {
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        assertEquals(totalShardCount, state.getRoutingNodes().shardsWithState(STARTED).size());
                listener.onResponse(clusterService.state());
    }
        int node1Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node1.getId());
        RoutingAllocation allocation = new RoutingAllocation(
            assertEquals(Priority.NORMAL, priority);
            ClusterInfo.EMPTY,  
        assertEquals(numberOfShards * numberOfIndices, node1Recoveries + node2Recoveries + node3Recoveries);  
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.OpenSearchException;
            assertEquals("reroute after balanced shards allocator timed out", reason);  
        int node1Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node1.getId());  
        RoutingAllocation allocation = new RoutingAllocation(
        for (Map.Entry<String, IndexMetadata> entry : metadata.getIndices().entrySet()) {
            System.nanoTime()
        assertFalse(allocator.allocatorTimedOut());
    public void testAllocatorNeverTimedOutIfValueIsMinusOne() {
        int node3Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node3.getId());
            routingTableBuilder.addAsNew(entry.getValue());  
        assertEquals(totalShardCount, allocation.routingNodes().unassigned().ignored().size());
    }
        assertEquals(0, state.getRoutingNodes().shardsWithState(INITIALIZING).size());  
            System.nanoTime()  
            rerouteScheduled.compareAndSet(false, true);
            IllegalArgumentException.class,  
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(settings.build(), new CountDownLatch(0));
        List<ShardRouting> initializingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);
    }
    }
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);
            assertEquals(Priority.NORMAL, priority);
                listener.onResponse(clusterService.state());  
        assertEquals(shardsToMove / 3, relocatingShards.size());  
            () -> FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(wrongPriority)  
            state,
            allocationDecidersForExcludeAPI(settings),  
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));
    }  
        allocator.allocate(allocation);
        RoutingAllocation allocation = new RoutingAllocation(
    private Metadata buildMetadata(Metadata.Builder mb, int numberOfIndices, int numberOfShards, int numberOfReplicas) {
        assertEquals(0, relocatingShards.size());
    public void testAllUnassignedShardsAllocatedWhenNoTimeOutAndRerouteNotScheduled() {
        List<ShardRouting> initializingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);
        assertEquals(0, relocatingShards.size());  
        RoutingTable routingTable = buildRoutingTable(metadata);
            if (randomBoolean()) {
            System.nanoTime()
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;  
        int shardsToAllocate = randomIntBetween(numberOfShards * numberOfIndices, totalShardCount);
            null,
            System.nanoTime()
        assertTrue(rerouteScheduled.get());  
        assertEquals(0, node1Recoveries + node2Recoveries + node3Recoveries);
        int numberOfShards = 5;
        int numberOfReplicas = 1;
        List<ShardRouting> relocatingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.RELOCATING);
            assertEquals(Priority.NORMAL, priority);  
        RoutingAllocation allocation = new RoutingAllocation(  
        assertEquals(0, state.getRoutingNodes().shardsWithState(INITIALIZING).size());  
        Settings build = Settings.builder().put(settingKey, "normal").build();  
            rerouteScheduled.compareAndSet(false, true);
            timedOutLatch.countDown();
import org.opensearch.common.settings.Settings;  
            new RoutingNodes(state, false),
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        RoutingTable routingTable = buildRoutingTable(metadata);
        MockAllocationService allocationService = createAllocationService(
        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);
                IndexMetadata.builder("test_" + i)
            new RoutingNodes(state, false),
            rerouteScheduled.compareAndSet(false, true);
        int numberOfReplicas = 1;
 * compatible open source license.
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);  
    private RoutingTable buildRoutingTable(Metadata metadata) {  
            ClusterInfo.EMPTY,
            }
        assertEquals(totalShardCount, allocation.routingNodes().unassigned().ignored().size());
        RoutingAllocation allocation = new RoutingAllocation(  
        int node1ShardCount = state.getRoutingNodes().node("node1").size();
        assertEquals("Setting [" + settingKey + "] should be more than 20s or -1ms to disable timeout", iae.getMessage());  
            ClusterInfo.EMPTY,  
            ClusterInfo.EMPTY,
        assertEquals(totalShardCount, state.getRoutingNodes().shardsWithState(STARTED).size());
        assertEquals(0, state.getRoutingNodes().shardsWithState(INITIALIZING).size());  
        final RerouteService rerouteService = (reason, priority, listener) -> {
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(settings.build(), new CountDownLatch(shardsToAllocate));
            }
        int node2Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node2.getId());
package org.opensearch.cluster.routing.allocation.allocator;
        );  
        final RerouteService rerouteService = (reason, priority, listener) -> {  
            .routingTable(routingTable)
            assertEquals("reroute after balanced shards allocator timed out", reason);
        int numberOfIndices = 1;
        };
        assertEquals(0, node1ShardCount);  
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(settings.build(), new CountDownLatch(Integer.MAX_VALUE));
        int shardsToAllocate = randomIntBetween(1, numberOfShards * numberOfIndices);
        int numberOfShards = 15;  
                listener.onResponse(clusterService.state());  
        // passing shards to allocate for timed out latch such that only few primary shards are allocated in this reroute round
            if (randomBoolean()) {  
        assertEquals(0, node1ShardCount);
        assertEquals(totalShardCount, state.getRoutingNodes().shardsWithState(STARTED).size());
 */  
            } else {  
            assertEquals("reroute after balanced shards allocator timed out", reason);  
        RoutingAllocation allocation = new RoutingAllocation(
        setupStateAndService(metadata, routingTable);  
        Settings.Builder settings = Settings.builder();
        Settings.Builder settings = Settings.builder();  
 *
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
        );
            super(settings);
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);  
                return Decision.NO;
        List<ShardRouting> relocatingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.RELOCATING);  
        };  
        // Valid setting with timeout > 20s
        int shardsToMove = 0; // such that it never balances anything
        int numberOfReplicas = 1;
        String settingKey = "cluster.routing.allocation.balanced_shards_allocator.allocator_timeout";  
            null,
            assertEquals("reroute after balanced shards allocator timed out", reason);
        int node1ShardCount = state.getRoutingNodes().node("node1").size();
            } else {  
            if (randomBoolean()) {  
        int numberOfIndices = 3;
import org.opensearch.cluster.node.DiscoveryNodes;
        build = Settings.builder().put(settingKey, "urgent").build();  
        RoutingTable routingTable = buildRoutingTable(metadata);
        };
        Settings settings = Settings.builder().put("cluster.routing.allocation.exclude.zone", "1a").build();
            Settings.builder().put("cluster.routing.allocation.exclude.zone", "1a").build()
        RoutingTable routingTable = buildRoutingTable(metadata);  
        setupStateAndService(metadata, routingTable);
    private final DiscoveryNode node2 = newNode("node2", "node2", Collections.singletonMap("zone", "1b"));  
        threadPool = new TestThreadPool(getTestName());
        assertEquals(totalShardCount, initializingShards.size());  
            null,
            state,  
        );
            } else {
            .metadata(metadata)  
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);
    static class TestBalancedShardsAllocator extends BalancedShardsAllocator {  
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;  
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));
                return true;
        assertEquals(Priority.HIGH, FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(build));
        List<ShardRouting> initializingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);
            assertEquals("reroute after balanced shards allocator timed out", reason);  
        // passing shards to allocate for timed out latch such that all primary shards and few replica shards are allocated in this reroute  
            rerouteScheduled.compareAndSet(false, true);  
        state = applyStartedShardsUntilNoChange(state, allocationService);
    }
import org.opensearch.cluster.routing.RoutingNodes;  
            state,  
        allocator.setRerouteService(rerouteService);
        assertEquals(0, initializingShards.size());  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;  
    }
            System.nanoTime()
    }
        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);
        // check all shards allocated
        protected boolean allocatorTimedOut() {  
        // check all shards allocated
            yesAllocationDeciders(),
        assertTrue(rerouteScheduled.get());
import java.util.concurrent.CountDownLatch;  
            System.nanoTime()  
            state,  
        allocator.allocate(allocation);
        setupStateAndService(metadata, routingTable);
    private ClusterState state;  
        final RerouteService rerouteService = (reason, priority, listener) -> {  
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(settings, new CountDownLatch(Integer.MAX_VALUE));
            assertEquals(Priority.NORMAL, priority);  
        AtomicBoolean rerouteScheduled = new AtomicBoolean(false);  
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);  
        return mb.build();  
            Settings.builder().put("cluster.routing.allocation.exclude.zone", "1a").build()
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);  
        List<ShardRouting> relocatingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.RELOCATING);  
        int node1ShardCount = state.getRoutingNodes().node("node1").size();
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));
        BalancedShardsAllocator allocator = new TestBalancedShardsAllocator(settings.build(), new CountDownLatch(shardsToAllocate));  
            rerouteScheduled.compareAndSet(false, true);
        RoutingTable routingTable = buildRoutingTable(metadata);
        int numberOfShards = 5;
        int node1Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node1.getId());
        MockAllocationService allocationService = createAllocationService(  
        if (clusterService != null) {
        int numberOfShards = 15;
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));
        RoutingTable routingTable = buildRoutingTable(metadata);
    public void testPartialShardsMoveWhenExcludedAndTimeoutBreachedAndRerouteScheduled() {
        Settings newSettings = Settings.builder().put("cluster.routing.allocation.exclude.zone", "").build();  
        @Override
        };
        int numberOfShards = 5;  
            state,
        setupStateAndService(metadata, routingTable);
        int node2Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node2.getId());
import org.opensearch.cluster.routing.RoutingTable;
        assertEquals(totalShardCount, state.getRoutingNodes().shardsWithState(STARTED).size());
            return false;
        };
            assertEquals(Priority.NORMAL, priority);  
        // Valid setting with timeout = 20s
        }, new AllocationDecider() {  
        assertFalse(rerouteScheduled.get());
    public void tearDown() throws Exception {
        IllegalArgumentException iae = expectThrows(
        int numberOfShards = 5;
            @Override
                listener.onFailure(new OpenSearchException("simulated"));  
                listener.onFailure(new OpenSearchException("simulated"));
import org.opensearch.cluster.routing.RerouteService;
        int numberOfReplicas = 1;  
            System.nanoTime()  
        int numberOfIndices = 2;
        int node2Recoveries = allocation.routingNodes().getInitialPrimariesIncomingRecoveries(node2.getId());
            allocationDecidersForExcludeAPI(newSettings),
        setupStateAndService(metadata, routingTable);
            ClusterInfo.EMPTY,  
/*  
        assertEquals(0, node1ShardCount);
                listener.onFailure(new OpenSearchException("simulated"));
        Settings newSettings = Settings.builder().put("cluster.routing.allocation.exclude.zone", "").build();
        allocator.setRerouteService(rerouteService);  
import org.opensearch.cluster.node.DiscoveryNode;  
import org.opensearch.test.ClusterServiceUtils;
    public void testNoShardsMoveWhenExcludedAndTimeoutBreachedAndRerouteScheduled() {
 * The OpenSearch Contributors require contributions made to  
            () -> FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(wrongPriority2)
            assertEquals(Priority.NORMAL, priority);  
            new RoutingNodes(state, false),
                listener.onResponse(clusterService.state());
import org.opensearch.cluster.ClusterInfo;  
            null,
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas);  
        List<ShardRouting> relocatingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.RELOCATING);
        RoutingAllocation allocation = new RoutingAllocation(  
        );  
        );
        allocator.setRerouteService(rerouteService);
import org.opensearch.common.settings.ClusterSettings;
        int numberOfReplicas = 1;
import org.opensearch.Version;
        // Invalid setting with timeout < 20s  
        int totalShardCount = numberOfIndices * (numberOfShards * (numberOfReplicas + 1));
        Settings newSettings = Settings.builder().put("cluster.routing.allocation.exclude.zone", "").build();  
        Settings build = Settings.builder().put("cluster.routing.allocation.balanced_shards_allocator.allocator_timeout", "-1").build();  
            assertEquals("reroute after balanced shards allocator timed out", reason);
    }  
                listener.onFailure(new OpenSearchException("simulated"));
    public void testAllUnassignedShardsIgnoredWhenTimedOutAndRerouteScheduledWithHighPriority() {  
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))
        allocator.setRerouteService(rerouteService);  
        allocator.allocate(allocation);
        RoutingTable routingTable = buildRoutingTable(metadata);
            new RoutingNodes(state, false),
import org.opensearch.threadpool.TestThreadPool;
            new RoutingNodes(state, false),  
            ClusterInfo.EMPTY,  
        public TestBalancedShardsAllocator(Settings settings, CountDownLatch timedOutLatch) {  
        List<ShardRouting> initializingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);  
        setupStateAndService(metadata, routingTable);
            allocationDecidersForExcludeAPI(settings),  
        );  
            public Decision canMoveAnyShard(RoutingAllocation allocation) {  
        List<AllocationDecider> allocationDeciders = Arrays.asList(new AllocationDecider() {
                listener.onFailure(new OpenSearchException("simulated"));
            IllegalArgumentException.class,  
        };
