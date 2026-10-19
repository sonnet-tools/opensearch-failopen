            .map(IndexShardRoutingTable::getShardId)
        assertEquals(timedOutShardsLatch.getCount(), 0);
        shardsSet1.addAll(shardsSet2);  
        BatchRunnableExecutor executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, true);  
        primary.set(false);
        assertEquals(-1, REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING.get(build).getMillis());
            .build();
    }  
        BatchRunnableExecutor executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, true);
                        fail("found duplicate shard routing for shard. One shard cant be in multiple batches " + shardRouting.shardId());
    }
        assertNotNull(executor);
import org.opensearch.Version;  
        IndexRoutingTable.Builder isd = IndexRoutingTable.builder(primaryShardId.getIndex())  
        ShardsBatchGatewayAllocator.ShardsBatch primaryShardsBatch = testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch()
        createBatchesAndAssert(2);  
        assertEquals(executor.getTimeoutAwareRunnables().size(), 2);  
        assertEquals(1, testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch().size());  
            if (primary.get()) {
        assertEquals(0, testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch().size());  
    }
        List<ShardsBatchGatewayAllocator.ShardsBatch> listOfBatches = new ArrayList<>(
    String indexPrefix = "TEST";  
            }  
import java.util.concurrent.atomic.AtomicBoolean;  
        // now remove all shard routings to verify that batch only gets deleted  
 * The OpenSearch Contributors require contributions made to  
            if (shardRouting.primary()) {  
            new AllocationDeciders(Collections.emptyList()),
        createIndexAndUpdateClusterState(1, 3, 1);
        createBatchesAndAssert(1);  
            .values()
                ShardRouting.newUnassigned(
 *
    public void testCollectTimedOutShardsAndScheduleReroute_Failure() throws InterruptedException {
        assertEquals(30, REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING.get(build).getSeconds());
    // call this after index creation and update cluster state
import org.opensearch.cluster.metadata.Metadata;
                    .settings(settings(Version.CURRENT))  
                        false,
            .stream()  
            IllegalArgumentException.class,
import org.opensearch.test.ClusterServiceUtils;  
    }
    public void testCorrectnessOfBatch() {
        executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, primary.get());
public class GatewayAllocatorTests extends OpenSearchAllocationTestCase {  
            for (String batchId : replicaBatches) {  
        ClusterService clusterService = ClusterServiceUtils.createClusterService(clusterState, threadPool);
            .collect(Collectors.toList());
import org.opensearch.threadpool.TestThreadPool;
            } else {
        Set<String> primaryBatches = batchesTuple.v1();
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        TestThreadPool threadPool = new TestThreadPool(getTestName());
import org.junit.Before;  
        assertFalse(primaryShardsBatch.getBatchedShards().contains(anyPrimary.shardId()));  
        CountDownLatch timedOutShardsLatch = new CountDownLatch(20);
            .iterator()
        assertFalse(testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch().containsKey(replicaShardsBatch.getBatchId()));
        // now remove all shard routings to verify that batch gets deleted  
    public void testGetBatchIdNonExisting() {
        assertEquals(4080, allShardRoutings1.size());
            .metadata(metadata.build())
            .iterator()  
                    shardIdToBatchIdForStoreShards.get(shardRouting.shardId()),
            .metadata(metadata)
        assertEquals(20, REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING.get(build).getSeconds());
        // again try to create batch and verify no new batch is created since shard is already batched and no new unassigned shard
import org.opensearch.cluster.routing.RecoverySource;
        testShardsBatchGatewayAllocator.setFollowUpRerouteTaskPriority(Priority.NORMAL);
        assertEquals(1, shardsBatch.getBatchedShards().size());
        Settings lessThan20sSetting = Settings.builder().put(REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY, "10s").build();
            )  
            .put(  
                        .getBatchedShards()
            .collect(Collectors.toSet());
            .map(IndexShardRoutingTable::getShardId)  
        primaryShardsBatch.getBatchedShardRoutings().forEach(testShardsBatchGatewayAllocator::safelyRemoveShardFromBatch);
        testShardsBatchGatewayAllocator.setPrimaryBatchAllocatorTimeout(TimeValue.ZERO);  
        build = Settings.builder().put(REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY, "30000ms").build();
        createIndexAndUpdateClusterState(2, 5, 2);  
import org.opensearch.cluster.routing.RerouteService;  
                assertEquals("reroute after existing shards allocator [R] timed out", reason);
            .build();  
            .map(IndexShardRoutingTable::getShards)  
                    assertTrue(shardRouting.primary());
        final RerouteService rerouteService = (reason, priority, listener) -> {
                assertEquals("reroute after existing shards allocator [P] timed out", reason);  
import org.opensearch.cluster.routing.UnassignedInfo;  
                    && testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch()  
        createRoutingWithDifferentUnAssignedInfo(shardId, node, 50);
                    .numberOfShards(numberOfShards)
        // Valid setting with timeout = -1  
    }
        assertEquals(4080, shardIdToBatchIdForStartedShards.size() + shardIdToBatchIdForStoreShards.size());  
        // Valid setting with timeout > 20s  
        assertEquals(timedOutShardsLatch.getCount(), 10);
        assertEquals(20, PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING.get(build).getSeconds());  
        Set<String> primaryBatches = testShardsBatchGatewayAllocator.createAndUpdateBatches(testAllocation, true);  
            assertEquals(Priority.HIGH, priority);
    }  
        replicaShardsBatch.getBatchedShardRoutings().forEach(testShardsBatchGatewayAllocator::safelyRemoveShardFromBothBatch);
                    shardIdToBatchIdForStartedShards.get(shardRouting.shardId()),
        Set<String> replicaBatches = testShardsBatchGatewayAllocator.createAndUpdateBatches(testAllocation, false);  
    private Tuple<Set<String>, Set<String>> createBatchesAndAssert(int expectedBatchSize) {
        Map<ShardId, String> shardIdToBatchIdForStoreShards = new HashMap<>();  
    public void testAsyncFetcherCreationInBatch() {
        AsyncShardFetch<? extends BaseNodeResponse> asyncFetcher = shardsBatch.getAsyncFetcher();
        testShardsBatchGatewayAllocator = new TestShardBatchGatewayAllocator(timedOutShardsLatch, 1000, rerouteService);
        Settings build = Settings.builder().put(settingKey, "normal").build();
            .collect(Collectors.toSet());
        );  
        Set<ShardRouting> replicasInAllBatches = testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch()
        Metadata metadata = Metadata.builder()
        build = Settings.builder().put(PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY, "-1").build();  
        for (int i = 0; i < numberOfReplicas; i++) {  
        assertEquals(1, rerouteLatch.getCount());  
        testShardsBatchGatewayAllocator.safelyRemoveShardFromBatch(primaryShardRouting);
        for (ShardRouting shardRouting : allShardRoutings1) {  
        primary.set(false);
            .map(IndexShardRoutingTable::getShards)  
import java.util.List;
            .routingTable(routingTable)  
        ShardRouting replicaShardRouting = replicaShardsBatch.getBatchedShardRoutings().iterator().next();
            }  
        assertEquals(expectedBatchSize, testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch().size());
        final CountDownLatch rerouteLatch = new CountDownLatch(2);  
        testAllocation = new RoutingAllocation(
        List<ShardRouting> allShardRoutings1 = clusterState.routingTable()
        replicaShardsBatch.getBatchedShardRoutings().forEach(testShardsBatchGatewayAllocator::safelyRemoveShardFromBatch);
        clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
import static org.opensearch.gateway.ShardsBatchGatewayAllocator.REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY;  
                    false,
        Set<String> primaryBatches = batchesTuple.v1();
        testShardsBatchGatewayAllocator.setReplicaBatchAllocatorTimeout(TimeValue.ZERO);
            .values()  
        final CountDownLatch rerouteLatch = new CountDownLatch(2);  
            }
        replicasInAllBatches.forEach(shardRouting -> assertTrue(shardRouting.unassigned() && shardRouting.primary() == false));
        }
        // Invalid setting with timeout < 20s  
                    shardIdToBatchIdForStoreShards.put(shardRouting.shardId(), batchId);
            .getShards()  
        executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, false);
        assertNull(executor);
            isd.addShard(
    public void testCollectTimedOutShardsAndScheduleReroute_Success() throws InterruptedException {
        testShardsBatchGatewayAllocator = new TestShardBatchGatewayAllocator(10);  
        for (ShardRouting shardRouting : allShardRoutings1) {
        );
        executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, primary.get());
            .stream()
 * this file be licensed under the Apache-2.0 license or a
 */  
        // delete 1 shard routing from each batch  
        assertFalse(testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch().containsKey(primaryShardsBatch.getBatchId()));
    }  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                        "message for replica-copy " + i,
        assertEquals(1, rerouteLatch.getCount());  
            .map(ShardsBatchGatewayAllocator.ShardsBatch::getBatchedShardRoutings)
            listener.onResponse(clusterService.state());  
        createIndexAndUpdateClusterState(1, 3, 1);
                assertEquals("reroute after existing shards allocator [R] timed out", reason);
            .getShards()  
        listOfBatches = new ArrayList<>(testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch().values());
                IndexMetadata.builder(indexName)
    }
            .map(ShardsBatchGatewayAllocator.ShardsBatch::getBatchedShardRoutings)
        // verify that shard routing is removed from both batches
                    .numberOfReplicas(numberOfReplicas)
        );  
        shardsInAllbatches = testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch()  
    }
        createIndexAndUpdateClusterState(2, 1020, 1);
                    if (shardIdToBatchIdForStoreShards.containsKey(shardRouting.shardId())) {  
            .flatMap(List::stream)  
        TestThreadPool threadPool = new TestThreadPool(getTestName());
        assertNotNull(asyncFetcher);  
        for (int i = 0; i < count; i++) {
        TestThreadPool threadPool = new TestThreadPool(getTestName());
        createBatchesAndAssert(1);  
        ClusterService clusterService = ClusterServiceUtils.createClusterService(clusterState, threadPool);
            clusterState,
            "Setting [" + PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING.getKey() + "] should be more than 20s or -1ms to disable timeout",
            .collect(Collectors.toSet());  
            () -> PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING.get(lessThan20sSetting)
            System.nanoTime()
        testShardsBatchGatewayAllocator.setFollowUpRerouteTaskPriority(Priority.NORMAL);
import org.opensearch.common.util.BatchRunnableExecutor;
        Set<String> primaryBatches = batchesTuple.v1();
            IllegalArgumentException.class,  
                );
            listener.onResponse(clusterService.state());  
            }  
        Set<ShardId> shardsSet2 = clusterState.routingTable()
        assert terminated;
        Set<String> replicaBatches = batchesTuple.v2();  
            .values()
            .collect(Collectors.toSet());
        Tuple<Set<String>, Set<String>> batches = createBatchesAndAssert(1);
            SnapshotShardSizeInfo.EMPTY,
        assertEquals(Priority.HIGH, ShardsBatchGatewayAllocator.FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(build));
        BatchRunnableExecutor executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, primary.get());  
        final ShardId shardId = new ShardId("test", "_na_", 0);
import java.util.concurrent.CountDownLatch;
        // get all shardsRoutings for test index  
    }
        assertNotEquals(listOfBatches.get(0), listOfBatches.get(1));
        }
        createIndexAndUpdateClusterState(2, 1020, 1);
import org.opensearch.action.support.nodes.BaseNodeResponse;
import org.apache.logging.log4j.LogManager;
    public void testCollectTimedOutShardsAndScheduleRerouteWithHighPriority_Success() throws InterruptedException {
    }  
        };  
import static org.opensearch.gateway.ShardsBatchGatewayAllocator.PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY;
            IllegalArgumentException.class,  
                    .numberOfReplicas(numberOfReplicas)
        assertEquals(1, batches.v2().size());  
        shardsBatch = testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch().get(replicaBatches.iterator().next());
 * SPDX-License-Identifier: Apache-2.0
                        System.nanoTime(),
        BatchRunnableExecutor executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, primary.get());  
        ShardsBatchGatewayAllocator.ShardsBatch primaryShardsBatch = testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch()
        testShardsBatchGatewayAllocator.safelyRemoveShardFromBothBatch(anyPrimary);  
        assertEquals(expectedBatchSize, replicaBatches.size());  
            new AllocationDeciders(Collections.emptyList()),  
    ClusterState clusterState = null;
                assertEquals(  
                assertEquals("reroute after existing shards allocator [R] timed out", reason);
        testShardsBatchGatewayAllocator = new TestShardBatchGatewayAllocator();  
                    .putInSyncAllocationIds(0, Sets.newHashSet(primaryShard.allocationId().getId()))
                if (shardRouting.primary() == false
    RoutingAllocation testAllocation = null;
            );  
            clusterState,
    private void createIndexAndUpdateClusterState(int count, int numberOfShards, int numberOfReplicas) {
            new RoutingNodes(clusterState, false),  
                        Collections.emptySet()  
            .values()  
        createIndexAndUpdateClusterState(2, 5, 2);  
        CountDownLatch timedOutShardsLatch = new CountDownLatch(20);
        assertEquals(executor.getTimeoutAwareRunnables().size(), 1);
                        System.currentTimeMillis(),  
        assertEquals(0, rerouteLatch.getCount()); // even with failure it doesn't leak any listeners
                    primaryShardId,  
    public void testDeDuplicationOfReplicaShardsAcrossBatch() {
            iae.getMessage()
            assertThat(rerouteLatch.getCount(), greaterThanOrEqualTo(0L));
    public void testFollowupPriorityValues() {
                        UnassignedInfo.AllocationStatus.NO_ATTEMPT,
            .stream()
                        .get(batchId)  
        ShardsBatchGatewayAllocator.ShardsBatch replicaShardsBatch = testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch()
        BatchRunnableExecutor executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, true);  
            .get(primaryBatches.iterator().next());  
                        0,
            .values()
    @Before  
        testShardsBatchGatewayAllocator.safelyRemoveShardFromBatch(primaryShardRouting);  
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
        final CountDownLatch rerouteLatch = new CountDownLatch(2);  
            }  
            .values()
        }
        final RerouteService rerouteService = (reason, priority, listener) -> {
            } else {
            String indexName = indexPrefix + i;  
            ClusterInfo.EMPTY,
        createIndexAndUpdateClusterState(2, 1023, 1);
        testShardsBatchGatewayAllocator = new TestShardBatchGatewayAllocator(timedOutShardsLatch, 1000, rerouteService);
        IllegalArgumentException iae = expectThrows(
        Set<ShardRouting> primariesInAllBatches = testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch()
    public void testTwoBatchCreation() {  
            .flatMap(List::stream)
            );  
            ClusterInfo.EMPTY,  
            .values()
            listener.onResponse(clusterService.state());  
                    RecoverySource.PeerRecoverySource.INSTANCE,
            .stream()
    public void testNonDuplicationOfBatch() {
                        .get(batchId)
        assertFalse(testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch().containsKey(primaryShardsBatch.getBatchId()));
            } else {
import static org.opensearch.gateway.ShardsBatchGatewayAllocator.REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING;
        assertEquals(executor.getTimeoutAwareRunnables().size(), 2);
        Settings build = Settings.builder().put(PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY, "20s").build();
    public void testSafelyRemoveShardFromBothBatch() {
        for (int i = 0; i < count; i++) {
            () -> REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING.get(lessThan20sSetting)
        clusterService.close();
                        fail("found duplicate shard routing for shard. One shard cant be in multiple batches " + shardRouting.shardId());
    }  
            rerouteLatch.countDown();
            .index(indexPrefix + 0)
                    }  
        assertEquals(0, rerouteLatch.getCount()); // even with failure it doesn't leak any listeners
        Tuple<Set<String>, Set<String>> batchesTuple = createBatchesAndAssert(2);  
        CountDownLatch timedOutShardsLatch = new CountDownLatch(20);
    }  
                        null,  
import org.opensearch.cluster.ClusterState;
        build = Settings.builder().put(PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY, "30000ms").build();  
        // verify that shard routing is removed from both batches
        createIndexAndUpdateClusterState(2, 1020, 1);
        }
 * compatible open source license.
            "Setting [" + REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING.getKey() + "] should be more than 20s or -1ms to disable timeout",
        // remove first shard routing from both batches
import org.opensearch.test.gateway.TestShardBatchGatewayAllocator;
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        testShardsBatchGatewayAllocator.safelyRemoveShardFromBatch(replicaShardRouting);
            .values()  
        assertFalse(testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch().containsKey(replicaShardsBatch.getBatchId()));
        executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, primary.get());
        IllegalArgumentException iae = expectThrows(  
        final boolean terminated = terminate(threadPool);  
                    && testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch()
        executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, false);  
        List<ShardRouting> allShardRoutings = clusterState.routingTable()
        testShardsBatchGatewayAllocator.setReplicaBatchAllocatorTimeout(TimeValue.ZERO);
                    new UnassignedInfo(  
        createIndexAndUpdateClusterState(1, 3, 1);  
        final RerouteService rerouteService = (reason, priority, listener) -> {
        final DiscoveryNode node = newNode("node1");  
        List<ShardRouting> allShardRouting2 = clusterState.routingTable()  
                    }
        ShardsBatchGatewayAllocator.ShardsBatch shardsBatch = testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch()
                        UnassignedInfo.Reason.REPLICA_ADDED,
            assertThat(rerouteLatch.getCount(), greaterThanOrEqualTo(0L));
    TestShardBatchGatewayAllocator testShardsBatchGatewayAllocator = null;  
import org.opensearch.cluster.routing.ShardRoutingState;
import static org.opensearch.gateway.ShardsBatchGatewayAllocator.PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING;  
        executor.run();  
        for (ShardRouting shardRouting : allShardRoutings1) {
        final boolean terminated = terminate(threadPool);  
        super.setUp();
            metadata.put(
        assertEquals(executor.getTimeoutAwareRunnables().size(), 1);  
    }  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        assertEquals(1, testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch().size());
        ShardRouting anyPrimary = primaryShardsBatch.getBatchedShardRoutings().iterator().next();
            .collect(Collectors.toList());
        }
/*  
    private final Logger logger = LogManager.getLogger(GatewayAllocatorTests.class);
        // test for replicas  
        createBatchesAndAssert(2);
        createIndexAndUpdateClusterState(1, 1, 1);  
        ShardRouting primaryShardRouting = primaryShardsBatch.getBatchedShardRoutings().iterator().next();  
}
        RoutingTable routingTable = RoutingTable.builder().add(isd).build();  
        assertEquals(1, rerouteLatch.getCount());  
        primary.set(false);
import org.opensearch.cluster.routing.RoutingNodes;
        assertEquals(  
import java.util.Collections;  
        createIndexAndUpdateClusterState(2, 5, 2);  
import org.opensearch.cluster.routing.IndexRoutingTable;  
        assertEquals(shardsInAllbatches, shardsSet1);
import org.opensearch.common.collect.Tuple;
package org.opensearch.gateway;
        executor.run();
        assertEquals(testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch().keySet(), replicaBatches);
            assertThat(rerouteLatch.getCount(), greaterThanOrEqualTo(0L));
import org.opensearch.cluster.routing.TestShardRouting;
            .flatMap(Set::stream)  
        assertFalse(replicaShardsBatch.getBatchedShards().contains(replicaShardRouting.shardId()));  
    public void testReplicaAllocatorTimeout() {
                }  
        Settings wrongPriority = Settings.builder().put(settingKey, "immediate").build();
    }  
            () -> ShardsBatchGatewayAllocator.FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(wrongPriority2)
    public void testGetBatchIdExisting() {
        // try to remove that shard again to see if its no op and doent result in exception
        Settings build = Settings.builder().put(REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY, "20s").build();  
        Set<ShardId> shardsSet1 = clusterState.routingTable()
        assertEquals(Priority.NORMAL, ShardsBatchGatewayAllocator.FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(build));
        // number of replicas is greater than batch size - to ensure shardRouting gets de-duped across batch
        assertEquals(batches.v2(), testShardsBatchGatewayAllocator.createAndUpdateBatches(testAllocation, false));
            .getShards()
        assert terminated;
            .flatMap(List::stream)  
                    )
        createBatchesAndAssert(1);
        if (count == 0) return;
            assertEquals(Priority.NORMAL, priority);
                assertEquals(
        ShardsBatchGatewayAllocator.ShardsBatch shardsBatch = testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch()
        assertEquals(
            .getShards()
        clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .values()  
        assert terminated;
            .get(replicaBatches.iterator().next());  
        executor.run();  
        executor.run();  
        assertNotEquals(listOfBatches.get(0), listOfBatches.get(1));
        assertEquals(timedOutShardsLatch.getCount(), 10);
            .stream()
        testShardsBatchGatewayAllocator.setPrimaryBatchAllocatorTimeout(TimeValue.ZERO);  
        assertEquals(timedOutShardsLatch.getCount(), 0);
        primaryShardsBatch.getBatchedShardRoutings().forEach(testShardsBatchGatewayAllocator::safelyRemoveShardFromBothBatch);
        Metadata.Builder metadata = Metadata.builder();  
            .collect(Collectors.toList());
            .stream()
                    .numberOfShards(1)  
        createIndexAndUpdateClusterState(1, 3, 1);
import org.opensearch.cluster.ClusterName;  
        IllegalArgumentException iae = expectThrows(
        // Invalid setting with timeout < 20s
        // only replica shard should be in the batch
        build = Settings.builder().put(settingKey, "high").build();
import org.opensearch.cluster.OpenSearchAllocationTestCase;
import org.opensearch.common.Priority;
        assertEquals(1, replicaBatches.size());
        assertEquals(executor.getTimeoutAwareRunnables().size(), 1);
        executor.run();
                    testShardsBatchGatewayAllocator.getBatchId(shardRouting, true)  
import java.util.Map;  
                        .contains(shardRouting.shardId())) {  
        // now compare the maps with getBatchId() call
    public void testCreatePrimaryExecutorOfSizeOneAndReplicaExecutorOfSizeZero() {
        allShardRoutings.forEach(shard -> assertNull(testShardsBatchGatewayAllocator.getBatchId(shard, shard.primary())));  
        createIndexAndUpdateClusterState(1, 3, 2);
        Set<String> replicaBatches = batchesTuple.v2();
        Set<ShardId> shardsInAllbatches = testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch()
import org.opensearch.cluster.routing.RoutingTable;
        testAllocation = new RoutingAllocation(
        // try to remove that shard again to see if its no op and doesnt result in exception  
            .map(IndexShardRoutingTable::getShards)
    public void testExecutorNotNull() {  
        build = Settings.builder().put(REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY, "-1").build();
        };  
    }
        Tuple<Set<String>, Set<String>> batchesTuple = createBatchesAndAssert(1);
        ClusterService clusterService = ClusterServiceUtils.createClusterService(clusterState, threadPool);
            }
        Set<String> replicaBatches = testShardsBatchGatewayAllocator.createAndUpdateBatches(testAllocation, false);
        );  
        // Valid setting with timeout = 20s
        // create a map of shards to batch id for primaries
        // Valid setting with timeout = -1
            .addIndexShard(new IndexShardRoutingTable.Builder(primaryShardId).addShard(primaryShard).build());
        asyncFetcher = shardsBatch.getAsyncFetcher();
            iae.getMessage()  
        // assert asyncFetcher is not null
            .getShards()  
        Settings wrongPriority2 = Settings.builder().put(settingKey, "random").build();
import org.opensearch.cluster.ClusterInfo;
        assertEquals(expectedBatchSize, testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch().size());
    public void testCreatePrimaryAndReplicaExecutorOfSizeOne() {  
            routingTableBuilder = routingTableBuilder.addAsNew(metadata.build().index(indexName));
            System.nanoTime()
            .flatMap(List::stream)
    }
        Map<ShardId, String> shardIdToBatchIdForStartedShards = new HashMap<>();  
            .stream()
import org.opensearch.core.index.shard.ShardId;
        );
            .index(indexPrefix + 0)
    public void testSafelyRemoveShardFromBatch() {  
        assertEquals("No enum constant org.opensearch.common.Priority.RANDOM", iae2.getMessage());
        executor.run();
import java.util.Set;
        primariesInAllBatches.forEach(shardRouting -> assertTrue(shardRouting.unassigned() && shardRouting.primary() == true));
        assertNotNull(asyncFetcher);  
            .stream()  
                )
        testShardsBatchGatewayAllocator.setFollowUpRerouteTaskPriority(Priority.HIGH);
            SnapshotShardSizeInfo.EMPTY,  
    }
                }
        assertEquals(2, replicaBatches.size());
        createIndexAndUpdateClusterState(2, 1001, 1);
            testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch().values()
    }
        assertFalse(primaryShardsBatch.getBatchedShards().contains(primaryShardRouting.shardId()));
        assertEquals(expectedBatchSize, primaryBatches.size());
        );  
        );  
        assertFalse(replicaShardsBatch.getBatchedShards().contains(anyPrimary.shardId()));
        );
            .index(indexPrefix + 1)
    private void createRoutingWithDifferentUnAssignedInfo(ShardId primaryShardId, DiscoveryNode node, int numberOfReplicas) {
        BatchRunnableExecutor executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, primary.get());  
    }  
import org.opensearch.cluster.node.DiscoveryNode;
        assertEquals(0, testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch().size());
                    .settings(settings(Version.CURRENT))
                        .contains(shardRouting.shardId())) {
            .next();
                assertEquals("reroute after existing shards allocator [P] timed out", reason);  
        );  
        assertEquals(batches.v1(), testShardsBatchGatewayAllocator.createAndUpdateBatches(testAllocation, true));  
            "priority [IMMEDIATE] not supported for [" + ShardsBatchGatewayAllocator.FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey() + "]",
    @Override
        assertEquals(-1, PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING.get(build).getMillis());
            .stream()
            rerouteLatch.countDown();
import java.util.stream.Collectors;
        executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, false);
    public void testCreatePrimaryAndReplicaExecutorOfSizeTwo() {
        }
        ShardsBatchGatewayAllocator.ShardsBatch replicaShardsBatch = testShardsBatchGatewayAllocator.getBatchIdToStoreShardBatch()
            .get(primaryBatches.iterator().next());
        // Valid setting with timeout > 20s
        createIndexAndUpdateClusterState(1, 3, 1);  
                if (shardRouting.primary() == true
import org.opensearch.cluster.routing.ShardRouting;  
        assertEquals(30, PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING.get(build).getSeconds());
            .values()
            } else {
        assertEquals(testShardsBatchGatewayAllocator.getBatchIdToStartedShardBatch().keySet(), primaryBatches);  
            if (primary.get()) {
            .next();
        assertEquals(0, rerouteLatch.getCount()); // even with failure it doesn't leak any listeners
            .index(indexPrefix + 0)
        build = Settings.builder().put(settingKey, "urgent").build();
            .build();
                        .getBatchedShards()
        testShardsBatchGatewayAllocator = new TestShardBatchGatewayAllocator(timedOutShardsLatch, 1000, rerouteService);
            if (primary.get()) {
            for (String batchId : primaryBatches) {
import org.opensearch.common.settings.Settings;  
        assertEquals(Priority.URGENT, ShardsBatchGatewayAllocator.FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(build));
        final AtomicBoolean primary = new AtomicBoolean(true);
            iae.getMessage()
        assertEquals(  
        BatchRunnableExecutor executor = testShardsBatchGatewayAllocator.allocateAllUnassignedShards(testAllocation, true);
        testShardsBatchGatewayAllocator.setReplicaBatchAllocatorTimeout(TimeValue.ZERO);
            .routingTable(routingTableBuilder.build())
        testShardsBatchGatewayAllocator.safelyRemoveShardFromBothBatch(anyPrimary);
        clusterService.close();
import org.opensearch.snapshots.SnapshotShardSizeInfo;
    public void testSingleBatchCreation() {
            IllegalArgumentException.class,
        final AtomicBoolean primary = new AtomicBoolean(true);
                    assertFalse(shardRouting.primary());  
        testShardsBatchGatewayAllocator.safelyRemoveShardFromBatch(replicaShardRouting);  
import java.util.ArrayList;
import org.opensearch.common.util.set.Sets;  
            .collect(Collectors.toSet());
        testShardsBatchGatewayAllocator.setPrimaryBatchAllocatorTimeout(TimeValue.ZERO);  
        createIndexAndUpdateClusterState(1, 3, 0);  
import org.apache.logging.log4j.Logger;
                    if (shardIdToBatchIdForStartedShards.containsKey(shardRouting.shardId())) {
        ShardRouting primaryShard = TestShardRouting.newShardRouting(primaryShardId, node.getId(), true, ShardRoutingState.STARTED);
import org.opensearch.cluster.service.ClusterService;  
        final AtomicBoolean primary = new AtomicBoolean(true);
            () -> ShardsBatchGatewayAllocator.FOLLOW_UP_REROUTE_PRIORITY_SETTING.get(wrongPriority)
        allShardRoutings1.addAll(allShardRouting2);
            .values()
            .flatMap(List::stream)
        );
            String indexName = indexPrefix + i;  
            assertEquals(Priority.NORMAL, priority);
            .map(ShardsBatchGatewayAllocator.ShardsBatch::getBatchedShards)  
        Set<String> replicaBatches = batchesTuple.v2();
        assertEquals(1, batches.v1().size());
                    testShardsBatchGatewayAllocator.getBatchId(shardRouting, false)
        // Valid setting with timeout = 20s
                );  
        clusterService.close();
    }  
    public void testPrimaryAllocatorTimeout() {  
    }
            .flatMap(Set::stream)
import org.opensearch.cluster.metadata.IndexMetadata;  
        final boolean terminated = terminate(threadPool);  
        IllegalArgumentException iae2 = expectThrows(  
        Tuple<Set<String>, Set<String>> batchesTuple = createBatchesAndAssert(2);  
        assertEquals(timedOutShardsLatch.getCount(), 10);
        return new Tuple<>(primaryBatches, replicaBatches);
                assertEquals("reroute after existing shards allocator [P] timed out", reason);  
            .map(ShardsBatchGatewayAllocator.ShardsBatch::getBatchedShards)
    public void setUp() throws Exception {
        };  
            .collect(Collectors.toSet());
            .get(replicaBatches.iterator().next());  
        String settingKey = "cluster.routing.allocation.shards_batch_gateway_allocator.schedule_reroute.priority";  
import org.opensearch.common.unit.TimeValue;
            rerouteLatch.countDown();
    }
    }
                    shardIdToBatchIdForStartedShards.put(shardRouting.shardId(), batchId);
        Settings lessThan20sSetting = Settings.builder().put(PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING_KEY, "10s").build();
                IndexMetadata.builder(primaryShardId.getIndexName())
        assertEquals(shardsInAllbatches, shardsSet1);  
            .index(indexPrefix + 1)  
import java.util.HashMap;
            new RoutingNodes(clusterState, false),
        assertEquals(timedOutShardsLatch.getCount(), 0);
