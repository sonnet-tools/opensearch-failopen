        assertEquals(Priority.NORMAL, ShardsBatchGatewayAllocator.FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(build));
            assertThat(rerouteLatch.getCount(), greaterThanOrEqualTo(0L));
import org.opensearch.snapshots.SnapshotShardSizeInfo;
    }
        assert terminated;
            IllegalArgumentException.class,
        Settings build = Settings.builder().put(REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY, "20s").build();
        testShardsBatchGatewayAllocator.safelyRemoveShardFromBatch(replicaShardRouting);
            metadata.put(
    public void testSafelyRemoveShardFromBatch() {
        executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, false);
        ShardsBatchGatewayAllocator.ShardsBatch replicaShardsBatch = testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch()
            .stream()
    }
        // number of replicas is greater than batch size - to ensure shardRouting gets de-duped across batch
        AsyncShardFetch<? extends BaseNodeResponse> asyncFetcher = shardsBatch.getAsyncFetcher();
        testShardsBatchGatewayAllocator = new TestShardBatchGatewayAllocator(timedOutShardsLatch, 1000, rerouteService);
                        .get(batchId)
        assertEquals(0, rerouteLatch.getCount()); // even with failure it doesn't leak any listeners
                        .contains(shardRouting.shardId())) {
    }
            ClusterInfo.EMPTY,
        CountDownLatch timedOutShardsLatch = new CountDownLatch(20);
            .collect(Collectors.toSet());
            }
            assertEquals(Priority.HIGH, priority);
        );
    RoutingAllocation testAllocation = null;
            .stream()
        }
        assert terminated;
        testShardsBatchGatewayAllocator = new TestShardBatchGatewayAllocator();
        assertFalse(testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch().containsKey(replicaShardsBatch.getBatchId()));
import java.util.Set;
        assertEquals(0, testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch().size());
/*
                    shardIdToBatchIdForStoreShards.put(shardRouting.shardId(), batchId);
            "Setting [" + REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING.getKey() + "] should be more than 20s or -1ms to disable timeout",
            .index(indexPrefix + 0)
        assertEquals("No enum constant org.opensearch.common.Priority.RANDOM", iae2.getMessage());
            new AllocationDeciders(Collections.emptyList()),
    }
import org.apache.logging.log4j.LogManager;
    ClusterState clusterState = null;
import org.opensearch.cluster.routing.TestShardRouting;
        createBatchesAndAssert(1);
            .get(primaryBatches.iterator().next());
                }
        clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            System.nanoTime()
        Set<String> replicaBatches = batchesTuple.v2();
import org.opensearch.Version;
        assertEquals(30, REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING.get(build).getSeconds());
        testShardsBatchGatewayAllocator.setReplicaBatchAllocatorTimeout(TimeValue.ZERO);
        testShardsBatchGatewayAllocator.setPrimaryBatchAllocatorTimeout(TimeValue.ZERO);
        Settings lessThan20sSetting = Settings.builder().put(REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY, "10s").build();
    public void testReplicaAllocatorTimeout() {
        final AtomicBoolean primary = new AtomicBoolean(true);
            .put(
        primary.set(false);
        final CountDownLatch rerouteLatch = new CountDownLatch(2);
        };
        ClusterService clusterService = ClusterServiceUtils.createClusterService(clusterState, threadPool);
        createIndexAndUpdateClusterState(2, 1020, 1);
                    .numberOfReplicas(numberOfReplicas)
            .stream()
    }
        BatchRunnableExecutor executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, primary.get());
        ShardRouting anyPrimary = primaryShardsBatch.getBatchedShardRoutings().iterator().next();
                    if (shardIdToBatchIdForStoreShards.containsKey(shardRouting.shardId())) {
        build = Settings.builder().put(settingKey, "urgent").build();
                );
            "priority [IMMEDIATE] not supported for [" + ShardsBatchGatewayAllocator.FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey() + "]",
            .collect(Collectors.toList());
 * compatible open source license.
    public void testDeDuplicationOfReplicaShardsAcrossBatch() {
            .stream()
    }
        clusterService.close();
            .routingTable(routingTable)
        assertNotEquals(listOfBatches.get(0), listOfBatches.get(1));
                    shardIdToBatchIdForStoreShards.get(shardRouting.shardId()),
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            String indexName = indexPrefix + i;
    private final Logger logger = LogManager.getLogger(GatewayAllocatorTests.class);
import java.util.ArrayList;
        allShardRoutings1.addAll(allShardRouting2);
        assertEquals(Priority.HIGH, ShardsBatchGatewayAllocator.FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(build));
            "Setting [" + PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING.getKey() + "] should be more than 20s or -1ms to disable timeout",
}
                    .numberOfReplicas(numberOfReplicas)
        };
            )
            .stream()
        primariesInAllBatches.forEach(shardRouting -> assertTrue(shardRouting.unassigned() && shardRouting.primary() == true));
import org.opensearch.cluster.metadata.IndexMetadata;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.ClusterServiceUtils;
            .getShards()
            .values()
            for (String batchId : replicaBatches) {
        assertEquals(timedOutShardsLatch.getCount(), 0);
            assertEquals(Priority.NORMAL, priority);
        testShardsBatchGatewayAllocator = new TestShardBatchGatewayAllocator(10);
            .stream()
        // remove first shard routing from both batches
        );
            .collect(Collectors.toSet());
            new AllocationDeciders(Collections.emptyList()),
        }
        testShardsBatchGatewayAllocator.safelyRemoveShardFromBatch(primaryShardRouting);
        assertEquals(
                        fail("found duplicate shard routing for shard. One shard cant be in multiple batches " + shardRouting.shardId());
            .collect(Collectors.toList());
        assertEquals(
        clusterService.close();
    }
    }
        IllegalArgumentException iae = expectThrows(
                    if (shardIdToBatchIdForStartedShards.containsKey(shardRouting.shardId())) {
        primaryShardsBatch.getBatchedShardRoutings().forEach(testShardsBatchGatewayAllocator::safelyRemoveShardFromBothBatch);
            () -> ShardsBatchGatewayAllocator.FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(wrongPriority2)
            routingTableBuilder = routingTableBuilder.addAsNew(metadata.build().index(indexName));
        );
import org.opensearch.threadpool.TestThreadPool;
        );
            .getShards()
                    assertFalse(shardRouting.primary());
import org.opensearch.cluster.ClusterInfo;
        assertEquals(testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch().keySet(), primaryBatches);
import static org.opensearch.gateway.ShardsBatchGatewayAllocator.PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING;
        // Valid setting with timeout = 20s
                assertEquals(
import org.opensearch.common.util.BatchRunnableExecutor;
        final boolean terminated = terminate(threadPool);
    TestShardBatchGatewayAllocator testShardsBatchGatewayAllocator = null;
            .iterator()
            .metadata(metadata)
        // verify that shard routing is removed from both batches
            .index(indexPrefix + 0)
        shardsSet1.addAll(shardsSet2);
        ShardRouting replicaShardRouting = replicaShardsBatch.getBatchedShardRoutings().iterator().next();
        IndexRoutingTable.Builder isd = IndexRoutingTable.builder(primaryShardId.getIndex())
            iae.getMessage()
        TestThreadPool threadPool = new TestThreadPool(getTestName());
import static org.opensearch.gateway.ShardsBatchGatewayAllocator.REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY;
            .collect(Collectors.toSet());
import org.opensearch.action.support.nodes.BaseNodeResponse;
                    )
        asyncFetcher = shardsBatch.getAsyncFetcher();
        }
    }
            .values()
        Set<String> primaryBatches = batchesTuple.v1();
        executor.run();
        // Valid setting with timeout = -1
        Map<ShardId, String> shardIdToBatchIdForStoreShards = new HashMap<>();
        // Valid setting with timeout > 20s
        TestThreadPool threadPool = new TestThreadPool(getTestName());
            () -> PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING.get(lessThan20sSetting)
        Set<String> primaryBatches = testShardsBatchGatewayAllocator.createAndUpdateBatches(testAllocation, true);
                    RecoverySource.PeerRecoverySource.INSTANCE,
            .map(ShardsBatchGatewayAllocator.ShardsBatch::getBatchedShards)
        testShardsBatchGatewayAllocator.setFollowUpRerouteTaskPriority(Priority.NORMAL);
            );
                        .contains(shardRouting.shardId())) {
                    .numberOfShards(numberOfShards)
        assertEquals(1, batches.v1().size());
        assertNotEquals(listOfBatches.get(0), listOfBatches.get(1));
        createIndexAndUpdateClusterState(2, 1023, 1);
        replicaShardsBatch.getBatchedShardRoutings().forEach(testShardsBatchGatewayAllocator::safelyRemoveShardFromBothBatch);
import org.opensearch.cluster.routing.RecoverySource;
        allShardRoutings.forEach(shard -> assertNull(testShardsBatchGatewayAllocator.getBatchId(shard, shard.primary())));
        Metadata metadata = Metadata.builder()
        final ShardId shardId = new ShardId("test", "_na_", 0);
            IllegalArgumentException.class,
        // Invalid setting with timeout < 20s
        executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, primary.get());
        assertEquals(batches.v1(), testShardsBatchGatewayAllocator.createAndUpdateBatches(testAllocation, true));
        executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, false);
                        .get(batchId)
    }
    public void testCreatePrimaryExecutorOfSizeOneAndReplicaExecutorOfSizeZero() {
        createIndexAndUpdateClusterState(2, 5, 2);
import java.util.Map;
 * The OpenSearch Contributors require contributions made to
        Settings build = Settings.builder().put(PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY, "20s").build();
        replicaShardsBatch.getBatchedShardRoutings().forEach(testShardsBatchGatewayAllocator::safelyRemoveShardFromBatch);
        assertFalse(testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch().containsKey(replicaShardsBatch.getBatchId()));
        testAllocation = new RoutingAllocation(
        createIndexAndUpdateClusterState(2, 5, 2);
            .flatMap(List::stream)
    String indexPrefix = "TEST";
        assertEquals(timedOutShardsLatch.getCount(), 10);
    @Before
                    }
    private void createRoutingWithDifferentUnAssignedInfo(ShardId primaryShardId, DiscoveryNode node, int numberOfReplicas) {
        assertEquals(1, rerouteLatch.getCount());
            rerouteLatch.countDown();
        assertEquals(1, replicaBatches.size());
            .getShards()
        assertEquals(4080, allShardRoutings1.size());
            .stream()
            .addIndexShard(new IndexShardRoutingTable.Builder(primaryShardId).addShard(primaryShard).build());
    @Override
        assertEquals(30, PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING.get(build).getSeconds());
        assertEquals(1, testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch().size());
            .next();
        assertFalse(testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch().containsKey(primaryShardsBatch.getBatchId()));
    public void testNonDuplicationOfBatch() {
                        Collections.emptySet()
        // delete 1 shard routing from each batch
        createIndexAndUpdateClusterState(1, 1, 1);
import java.util.stream.Collectors;
                    shardIdToBatchIdForStartedShards.get(shardRouting.shardId()),
        assertEquals(executor.getTimeoutAwareRunnables().size(), 1);
        primary.set(false);
        testShardsBatchGatewayAllocator.setPrimaryBatchAllocatorTimeout(TimeValue.ZERO);
        assertEquals(0, rerouteLatch.getCount()); // even with failure it doesn't leak any listeners
    public void testAsyncFetcherCreationInBatch() {
            .index(indexPrefix + 1)
 */
            }
import java.util.List;
            iae.getMessage()
        listOfBatches = new ArrayList<>(testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch().values());
import org.opensearch.cluster.service.ClusterService;
            for (String batchId : primaryBatches) {
        String settingKey = "cluster.routing.allocation.shards_batch_gateway_allocator.schedule_reroute.priority";
public class GatewayAllocatorTests extends OpenSearchAllocationTestCase {
    }
        assertEquals(20, PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING.get(build).getSeconds());
        ShardsBatchGatewayAllocator.ShardsBatch shardsBatch = testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch()
            rerouteLatch.countDown();
            .get(replicaBatches.iterator().next());
    public void testFollowupPriorityValues() {
        RoutingTable routingTable = RoutingTable.builder().add(isd).build();
                    .settings(settings(Version.CURRENT))
    public void testSafelyRemoveShardFromBothBatch() {
        executor.run();
        // Valid setting with timeout = 20s
            () -> ShardsBatchGatewayAllocator.FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(wrongPriority)
import org.junit.Before;
            testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch().values()
    public void testPrimaryAllocatorTimeout() {
                    testShardsBatchGatewayAllocator.getBatchId(shardRouting, true)
        );
            () -> REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING.get(lessThan20sSetting)
        assertEquals(
                    testShardsBatchGatewayAllocator.getBatchId(shardRouting, false)
        // Invalid setting with timeout < 20s
        CountDownLatch timedOutShardsLatch = new CountDownLatch(20);
                if (shardRouting.primary() == false
        }
            IllegalArgumentException.class,
        ShardsBatchGatewayAllocator.ShardsBatch primaryShardsBatch = testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch()
        testShardsBatchGatewayAllocator = new TestShardBatchGatewayAllocator(timedOutShardsLatch, 1000, rerouteService);
        ShardsBatchGatewayAllocator.ShardsBatch primaryShardsBatch = testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch()
            .iterator()
                        System.currentTimeMillis(),
                    .putInSyncAllocationIds(0, Sets.newHashSet(primaryShard.allocationId().getId()))
            }
        assertEquals(20, REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING.get(build).getSeconds());
        assertEquals(executor.getTimeoutAwareRunnables().size(), 1);
        );
            .getShards()
            } else {
        Tuple<Set<String>, Set<String>> batchesTuple = createBatchesAndAssert(1);
import java.util.concurrent.CountDownLatch;
                assertEquals("reroute after existing shards allocator [R] timed out", reason);
                IndexMetadata.builder(primaryShardId.getIndexName())
                );
        final DiscoveryNode node = newNode("node1");
        IllegalArgumentException iae = expectThrows(
    public void setUp() throws Exception {
        Set<String> replicaBatches = batchesTuple.v2();
    private Tuple<Set<String>, Set<String>> createBatchesAndAssert(int expectedBatchSize) {
        assertNotNull(asyncFetcher);
        build = Settings.builder().put(REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY, "30000ms").build();
        assertFalse(replicaShardsBatch.getBatchedShards().contains(replicaShardRouting.shardId()));
        if (count == 0) return;
            .values()
        createIndexAndUpdateClusterState(1, 3, 0);
        BatchRunnableExecutor executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, primary.get());
                )
        Set<String> primaryBatches = batchesTuple.v1();
        createRoutingWithDifferentUnAssignedInfo(shardId, node, 50);
            .map(IndexShardRoutingTable::getShards)
            iae.getMessage()
import org.opensearch.common.unit.TimeValue;
        shardsInAllbatches = testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch()
    public void testTwoBatchCreation() {
        // create a map of shards to batch id for primaries
        Tuple<Set<String>, Set<String>> batchesTuple = createBatchesAndAssert(2);
        // Valid setting with timeout > 20s
            );
        assertEquals(4080, shardIdToBatchIdForStartedShards.size() + shardIdToBatchIdForStoreShards.size());
        return new Tuple<>(primaryBatches, replicaBatches);
                assertEquals("reroute after existing shards allocator [R] timed out", reason);
import org.opensearch.cluster.node.DiscoveryNode;
        createIndexAndUpdateClusterState(1, 3, 1);
                assertEquals("reroute after existing shards allocator [P] timed out", reason);
        assertNotNull(asyncFetcher);
        build = Settings.builder().put(PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY, "30000ms").build();
        testShardsBatchGatewayAllocator.setFollowUpRerouteTaskPriority(Priority.NORMAL);
            .collect(Collectors.toSet());
            }
            .collect(Collectors.toSet());
        assertFalse(primaryShardsBatch.getBatchedShards().contains(anyPrimary.shardId()));
        );
import org.opensearch.common.settings.Settings;
                        System.nanoTime(),
    public void testCollectTimedOutShardsAndScheduleRerouteWithHighPriority_Success() throws InterruptedException {
        executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, primary.get());
import org.opensearch.cluster.routing.ShardRouting;
        testShardsBatchGatewayAllocator = new TestShardBatchGatewayAllocator(timedOutShardsLatch, 1000, rerouteService);
        Settings wrongPriority2 = Settings.builder().put(settingKey, "random").build();
        assertEquals(executor.getTimeoutAwareRunnables().size(), 2);
            .collect(Collectors.toList());
            .build();
                ShardRouting.newUnassigned(
                    shardIdToBatchIdForStartedShards.put(shardRouting.shardId(), batchId);
        assertEquals(1, batches.v2().size());
        assertEquals(executor.getTimeoutAwareRunnables().size(), 2);
        testShardsBatchGatewayAllocator.safelyRemoveShardFromBatch(primaryShardRouting);
import java.util.HashMap;
    public void testSingleBatchCreation() {
    }
        testShardsBatchGatewayAllocator.safelyRemoveShardFromBothBatch(anyPrimary);
        createIndexAndUpdateClusterState(1, 3, 1);
        testShardsBatchGatewayAllocator.safelyRemoveShardFromBatch(replicaShardRouting);
        List<ShardsBatchGatewayAllocator.ShardsBatch> listOfBatches = new ArrayList<>(
            .stream()
        assertEquals(executor.getTimeoutAwareRunnables().size(), 1);
        final AtomicBoolean primary = new AtomicBoolean(true);
            .flatMap(Set::stream)
        Set<String> replicaBatches = testShardsBatchGatewayAllocator.createAndUpdateBatches(testAllocation, false);
        Set<String> replicaBatches = testShardsBatchGatewayAllocator.createAndUpdateBatches(testAllocation, false);
        final CountDownLatch rerouteLatch = new CountDownLatch(2);
import java.util.concurrent.atomic.AtomicBoolean;
            .map(IndexShardRoutingTable::getShards)
            .values()
        // now compare the maps with getBatchId() call
            if (shardRouting.primary()) {
            .map(ShardsBatchGatewayAllocator.ShardsBatch::getBatchedShardRoutings)
        BatchRunnableExecutor executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, primary.get());
        ShardRouting primaryShardRouting = primaryShardsBatch.getBatchedShardRoutings().iterator().next();
                        fail("found duplicate shard routing for shard. One shard cant be in multiple batches " + shardRouting.shardId());
        Set<ShardId> shardsSet1 = clusterState.routingTable()
        final boolean terminated = terminate(threadPool);
import org.opensearch.cluster.metadata.Metadata;
            }
            isd.addShard(
                        UnassignedInfo.AllocationStatus.NO_ATTEMPT,
            } else {
            .map(IndexShardRoutingTable::getShardId)
        for (int i = 0; i < count; i++) {
    }
        IllegalArgumentException iae = expectThrows(
    }
import org.opensearch.cluster.routing.IndexRoutingTable;
                    && testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch()
            .index(indexPrefix + 0)
            new RoutingNodes(clusterState, false),
import org.opensearch.cluster.routing.RerouteService;
        ShardsBatchGatewayAllocator.ShardsBatch shardsBatch = testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch()
        executor.run();
        createIndexAndUpdateClusterState(1, 3, 1);
            .get(primaryBatches.iterator().next());
        Map<ShardId, String> shardIdToBatchIdForStartedShards = new HashMap<>();
                    assertTrue(shardRouting.primary());
                assertEquals("reroute after existing shards allocator [R] timed out", reason);
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
import org.opensearch.common.util.set.Sets;
        ClusterService clusterService = ClusterServiceUtils.createClusterService(clusterState, threadPool);
        assertEquals(expectedBatchSize, primaryBatches.size());
        assertEquals(1, shardsBatch.getBatchedShards().size());
                        "message for replica-copy " + i,
    public void testCreatePrimaryAndReplicaExecutorOfSizeOne() {
            if (primary.get()) {
            assertThat(rerouteLatch.getCount(), greaterThanOrEqualTo(0L));
        List<ShardRouting> allShardRouting2 = clusterState.routingTable()
            listener.onResponse(clusterService.state());
        createBatchesAndAssert(1);
import org.apache.logging.log4j.Logger;
            .metadata(metadata.build())
        build = Settings.builder().put(PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY, "-1").build();
import org.opensearch.common.Priority;
            IllegalArgumentException.class,
            .routingTable(routingTableBuilder.build())
        assertEquals(expectedBatchSize, testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch().size());
        assertEquals(shardsInAllbatches, shardsSet1);
        createBatchesAndAssert(1);
            .get(replicaBatches.iterator().next());
        assertEquals(1, rerouteLatch.getCount());
            .flatMap(List::stream)
        assertFalse(testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch().containsKey(primaryShardsBatch.getBatchId()));
    public void testGetBatchIdExisting() {
        createBatchesAndAssert(2);
    public void testExecutorNotNull() {
            .next();
        assertEquals(timedOutShardsLatch.getCount(), 10);
            new RoutingNodes(clusterState, false),
        );
        );
        assertEquals(timedOutShardsLatch.getCount(), 10);
        TestThreadPool threadPool = new TestThreadPool(getTestName());
            clusterState,
        clusterService.close();
            .build();
        super.setUp();
            .build();
        assertEquals(2, replicaBatches.size());
            } else {
        executor.run();
            .values()
                    false,
        BatchRunnableExecutor executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, true);
                if (shardRouting.primary() == true
        // verify that shard routing is removed from both batches
                }
    }
        assertEquals(timedOutShardsLatch.getCount(), 0);
        Set<String> replicaBatches = batchesTuple.v2();
        // assert asyncFetcher is not null
                        false,
            .map(ShardsBatchGatewayAllocator.ShardsBatch::getBatchedShardRoutings)
                        0,
        Set<String> primaryBatches = batchesTuple.v1();
import org.opensearch.cluster.routing.RoutingTable;
        assertEquals(1, rerouteLatch.getCount());
        CountDownLatch timedOutShardsLatch = new CountDownLatch(20);
                        .getBatchedShards()
        executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, primary.get());
        BatchRunnableExecutor executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, true);
import org.opensearch.cluster.routing.ShardRoutingState;
        // Valid setting with timeout = -1
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        build = Settings.builder().put(settingKey, "high").build();
        final boolean terminated = terminate(threadPool);
            .flatMap(List::stream)
        Tuple<Set<String>, Set<String>> batches = createBatchesAndAssert(1);
            } else {
        testShardsBatchGatewayAllocator.setReplicaBatchAllocatorTimeout(TimeValue.ZERO);
        Settings build = Settings.builder().put(settingKey, "normal").build();
        clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        assertNotNull(executor);
import java.util.Collections;
    }
    }
        for (int i = 0; i < numberOfReplicas; i++) {
            if (primary.get()) {
                        .getBatchedShards()
        assertFalse(primaryShardsBatch.getBatchedShards().contains(primaryShardRouting.shardId()));
        assert terminated;
        shardsBatch = testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch().get(replicaBatches.iterator().next());
    }
        createIndexAndUpdateClusterState(2, 1001, 1);
        assertEquals(-1, REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING.get(build).getMillis());
        testShardsBatchGatewayAllocator.setPrimaryBatchAllocatorTimeout(TimeValue.ZERO);
import static org.opensearch.gateway.ShardsBatchGatewayAllocator.PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY;
                assertEquals("reroute after existing shards allocator [P] timed out", reason);
            .map(IndexShardRoutingTable::getShardId)
            .values()
        // get all shardsRoutings for test index
        assertEquals(Priority.URGENT, ShardsBatchGatewayAllocator.FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(build));
        primary.set(false);
 * this file be licensed under the Apache-2.0 license or a
        // now remove all shard routings to verify that batch gets deleted
        assertEquals(0, rerouteLatch.getCount()); // even with failure it doesn't leak any listeners
        assertEquals(batches.v2(), testShardsBatchGatewayAllocator.createAndUpdateBatches(testAllocation, false));
        testAllocation = new RoutingAllocation(
            .getShards()
        // only replica shard should be in the batch
        replicasInAllBatches.forEach(shardRouting -> assertTrue(shardRouting.unassigned() && shardRouting.primary() == false));
            SnapshotShardSizeInfo.EMPTY,
        BatchRunnableExecutor executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, true);
                    new UnassignedInfo(
        assertEquals(testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch().keySet(), replicaBatches);
            rerouteLatch.countDown();
import org.opensearch.test.gateway.TestShardBatchGatewayAllocator;
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        assertEquals(timedOutShardsLatch.getCount(), 0);
        createIndexAndUpdateClusterState(2, 5, 2);
        BatchRunnableExecutor executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, true);
    public void testCollectTimedOutShardsAndScheduleReroute_Failure() throws InterruptedException {
            if (primary.get()) {
    public void testCreatePrimaryAndReplicaExecutorOfSizeTwo() {
        final RerouteService rerouteService = (reason, priority, listener) -> {
        executor.run();
    }
            assertEquals(Priority.NORMAL, priority);
        // again try to create batch and verify no new batch is created since shard is already batched and no new unassigned shard
        executor.run();
        assertEquals(shardsInAllbatches, shardsSet1);
        Set<ShardRouting> replicasInAllBatches = testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch()
        );
                    .numberOfShards(1)
        final RerouteService rerouteService = (reason, priority, listener) -> {
        testShardsBatchGatewayAllocator.setFollowUpRerouteTaskPriority(Priority.HIGH);
            clusterState,
        createIndexAndUpdateClusterState(1, 3, 1);
        List<ShardRouting> allShardRoutings1 = clusterState.routingTable()
            .stream()
        primaryShardsBatch.getBatchedShardRoutings().forEach(testShardsBatchGatewayAllocator::safelyRemoveShardFromBatch);
            .flatMap(Set::stream)
                assertEquals("reroute after existing shards allocator [P] timed out", reason);
                    primaryShardId,
        Set<ShardId> shardsSet2 = clusterState.routingTable()
        for (ShardRouting shardRouting : allShardRoutings1) {
            String indexName = indexPrefix + i;
            .collect(Collectors.toSet());
        // try to remove that shard again to see if its no op and doesnt result in exception
        createIndexAndUpdateClusterState(1, 3, 1);
package org.opensearch.gateway;
        }
                IndexMetadata.builder(indexName)
    public void testCollectTimedOutShardsAndScheduleReroute_Success() throws InterruptedException {
        // now remove all shard routings to verify that batch only gets deleted
        ClusterService clusterService = ClusterServiceUtils.createClusterService(clusterState, threadPool);
        final RerouteService rerouteService = (reason, priority, listener) -> {
 *
            listener.onResponse(clusterService.state());
        };
import org.opensearch.cluster.routing.UnassignedInfo;
            .values()
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        assertEquals(-1, PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING.get(build).getMillis());
            SnapshotShardSizeInfo.EMPTY,
    }
import org.opensearch.cluster.ClusterName;
import org.opensearch.cluster.routing.RoutingNodes;
                        UnassignedInfo.Reason.REPLICA_ADDED,
import org.opensearch.common.collect.Tuple;
        for (ShardRouting shardRouting : allShardRoutings1) {
        assertEquals(expectedBatchSize, testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch().size());
            .values()
        testShardsBatchGatewayAllocator.safelyRemoveShardFromBothBatch(anyPrimary);
        final CountDownLatch rerouteLatch = new CountDownLatch(2);
    }
        IllegalArgumentException iae2 = expectThrows(
        assertEquals(1, testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch().size());
        ShardRouting primaryShard = TestShardRouting.newShardRouting(primaryShardId, node.getId(), true, ShardRoutingState.STARTED);
        Metadata.Builder metadata = Metadata.builder();
        Set<ShardRouting> primariesInAllBatches = testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch()
        }
                    && testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch()
        Settings lessThan20sSetting = Settings.builder().put(PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY, "10s").build();
    public void testCorrectnessOfBatch() {
    public void testGetBatchIdNonExisting() {
    private void createIndexAndUpdateClusterState(int count, int numberOfShards, int numberOfReplicas) {
            ClusterInfo.EMPTY,
        // try to remove that shard again to see if its no op and doent result in exception
        build = Settings.builder().put(REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY, "-1").build();
        for (int i = 0; i < count; i++) {
        createIndexAndUpdateClusterState(1, 3, 2);
            .values()
            .map(IndexShardRoutingTable::getShards)
            assertThat(rerouteLatch.getCount(), greaterThanOrEqualTo(0L));
import static org.opensearch.gateway.ShardsBatchGatewayAllocator.REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING;
            .flatMap(List::stream)
        executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, false);
        List<ShardRouting> allShardRoutings = clusterState.routingTable()
        ShardsBatchGatewayAllocator.ShardsBatch replicaShardsBatch = testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch()
        assertEquals(0, testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch().size());
        assertEquals(expectedBatchSize, replicaBatches.size());
            }
            .index(indexPrefix + 1)
        Set<ShardId> shardsInAllbatches = testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch()
import org.opensearch.core.index.shard.ShardId;
        createIndexAndUpdateClusterState(2, 1020, 1);
        createBatchesAndAssert(2);
        Settings wrongPriority = Settings.builder().put(settingKey, "immediate").build();
import org.opensearch.cluster.ClusterState;
            .values()
            .flatMap(List::stream)
        for (ShardRouting shardRouting : allShardRoutings1) {
                    .settings(settings(Version.CURRENT))
    }
    }
        assertNull(executor);
        assertFalse(replicaShardsBatch.getBatchedShards().contains(anyPrimary.shardId()));
        final AtomicBoolean primary = new AtomicBoolean(true);
                assertEquals(
    // call this after index creation and update cluster state
            .map(ShardsBatchGatewayAllocator.ShardsBatch::getBatchedShards)
        Tuple<Set<String>, Set<String>> batchesTuple = createBatchesAndAssert(2);
                    }
        testShardsBatchGatewayAllocator.setReplicaBatchAllocatorTimeout(TimeValue.ZERO);
            .values()
            listener.onResponse(clusterService.state());
    }
        createIndexAndUpdateClusterState(2, 1020, 1);
        // test for replicas
                        null,
            System.nanoTime()
