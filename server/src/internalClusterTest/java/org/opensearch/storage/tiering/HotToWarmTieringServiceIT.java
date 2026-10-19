        createTestIndex(INDEX_NAME, 1, 1);  
        } finally {
        }  
        setupCluster(1);
            flush("second-index");
                assertBusy(() -> {
            waitForReplication(index);  
            ClusterStateListener listener = new TieringTestUtils.MockTieringCompletionListener(  
            assertTrue(resp.isAcknowledged());  
                assertIndexShardLocation("stuck-index", true);  
        String[] indices = new String[] { "test-1", "test-2", "test-3" };
        ClusterStateListener listener = new TieringTestUtils.MockTieringCompletionListener(
                assertBusy(() -> {
        internalCluster().startWarmOnlyNodes(2, settingsBuilder.build());
                assertTrue(response.isAcknowledged());  
    protected void migrateMultipleIndicesToWarm(String[] indices) throws Exception {
        Settings.Builder settingsBuilder = Settings.builder().put(buildDisabledAllocationSettings());
            }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        assertTrue(exception.getMessage().contains("Failed to resolve index: invalid-index"));
            client().admin()
        createTestIndex("test-replica", 1, 2);  
            }, 30, TimeUnit.SECONDS);
            "0",
        for (String nodeName : internalCluster().getNodeNames()) {  
    }
        ensureGreen(STUCK_INDEX);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards)
                .indices()
        }
        Settings.Builder settingsBuilder = Settings.builder()
import org.opensearch.common.util.FeatureFlags;
                verifyWarmIndexSettings(indexName);  
        migrateToWarm(INDEX_NAME);
    public void testWarmMigrationForAlreadyMigratedIndex() throws Exception {
 * compatible open source license.
                ShardRouting shard = state.routingTable().index(STUCK_INDEX).shard(0).primaryShard();
        if (indexExists(indexName)) {
            listeners.add(listener);
        createTestIndex(INDEX_NAME, 1, 1);
import static org.opensearch.index.store.remote.filecache.FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING;
        for (String index : indices) {
                if (isRelocating) {
        ensureGreen(INDEX_NAME);
            .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "0b")
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));  
    protected Settings nodeSettings(int nodeOrdinal) {
        indexBulk(INDEX_NAME, 100);
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());  
                assertFalse("Shard should not be relocating", shard.relocating());
            final IndexTieringRequest stuckRequest = new IndexTieringRequest("warm", INDEX_NAME);
        final String[] indices = new String[] { "test-1", "test-2", "test-3" };
 */  
        clusterInfoService.setDiskUsageFunctionAndRefresh(
        try {
    public void testMigrationWithStuckIndexAndPrimaryShardDataNodeBounceWithReplicas() throws Exception {
import org.opensearch.node.Node;
import org.opensearch.core.common.unit.ByteSizeUnit;  
            client().admin()
        int numberOfReplicas = randomIntBetween(1, 2);  
        }  
    public void testHotToWarmMigrationBasic() throws Exception {  
    public void testMigrationWithStuckIndexAndReplicaShardDataNodeBounce() throws Exception {
            }
            clusterService().removeListener(listener);  
            flush("stuck-index");  
                ClusterState state = client().admin().cluster().prepareState().get().getState();  
                }, 30, TimeUnit.SECONDS);  
            client().admin().indices().delete(new DeleteIndexRequest("test-index-3")).actionGet();  
            .put(super.nodeSettings(nodeOrdinal))
    public void testConcurrentMigrationWithStuckIndex() throws Exception {
        createTestIndex("second-index", 1, 1);
            );
                }, 30, TimeUnit.SECONDS);  
        }
        createTestIndex(INDEX_NAME, 1, 1);  
            "2",  
        setupCluster(1);
        }
        Settings.Builder settingsBuilder = Settings.builder()
        assertTrue(resp.isAcknowledged());  
        List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());  
                indexBulk(index, 100);  
                    assertFalse("Shard should not be relocating", shard.relocating());
                .indices()
            }, 60, TimeUnit.SECONDS);
            if (shardRouting.unassigned() && shardRouting.primary() == false) {
            flushAndRefresh(INDEX_NAME_2);
                (handler, request, channel, task) -> {
        ensureGreen(indices);
    }  
            ensureYellow(INDEX_NAME);
                    verifyWarmIndexSettings(index);  
        return true;  
        setupCluster(1);
        internalCluster().startDataOnlyNodes(2, settingsBuilder.build());  
        // Ensure segment replication is fully caught up before triggering relocation
        }
            for (String index : indices) {
    public void testHotToWarmMigrationWithIndexDeletion() throws Exception {
        );  
            .put(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), dataToFileCacheRatio != null ? Long.parseLong(dataToFileCacheRatio) : 5.0)  
            for (String index : indices) {  
            assertEquals(100, client().prepareSearch(STUCK_INDEX).setSize(0).get().getHits().getTotalHits().value());
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());  
        }
            }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        TieringTestUtils.safeSleep(6000);
                client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();  
    }  
            clusterService().addListener(listener);
        for (String index : inFlightIndices) {  
            client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value()
    protected void setupCluster(int numberOfReplicas, String lowDiskWaterMark, String dataToFileCacheRatio) {
            }
                for (String index : indices) {  
            internalCluster().restartNode(masterNodeId);  
                .indices()  
    public void testWarmMigrationWithTieringQueueSizeBreached() throws Exception {  
                createTestIndex(index, 1, 1);
            listeners.add(listener);  
            ShardRouting shardRouting = shardRoutingTable.primaryShard();  
                .prepareGetSettings("test-replica")
            for (String nodeName : dataNodeNames) {
                    } catch (AssertionError e) {
            assertTrue(response.isAcknowledged());  
            for (String index : indices) {  
            .indices()  
            for (String index : indices) {  
            .put(ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500));
    }  
                .filter(node -> node.getRoles().contains(DiscoveryNodeRole.DATA_ROLE))  
    }  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            AcknowledgedResponse resp = client().admin()
    protected static final String INDEX_NAME_2 = "h2w-test-idx-2";
            latch,  
    protected void interceptCheckpointUpdates() {
import org.opensearch.transport.TransportService;
        CountDownLatch migrationLatch = new CountDownLatch(indices.length);
                    .execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", index))
            final IndexTieringRequest stuckRequest = new IndexTieringRequest("warm", INDEX_NAME);
        );  
                index,  
        ensureGreen();
        refreshClusterInfo();  
                .getSetting("test-replica-0to1", IndexMetadata.SETTING_NUMBER_OF_REPLICAS)  
        internalCluster().startWarmOnlyNodes(2, settingsBuilder.build());
            .put(buildDisabledAllocationSettings())
            waitForReplication(STUCK_INDEX);
        setupCluster(2);
        refresh(STUCK_INDEX);  
        assertEquals(
                .indices()
import org.opensearch.cluster.ClusterState;
                verifyWarmIndexSettings(STUCK_INDEX);
            .put(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 2.0);
                .actionGet()
                .execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", STUCK_INDEX))
            assertTrue(resp.isAcknowledged());  
            assertBusy(() -> {
    }
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();  
        refreshClusterInfo();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)  
                DiscoveryNode primaryNode = state.nodes().get(primaryShard.currentNodeId());  
        ensureGreen();
                TransportService.class,
                    verifyWarmIndexSettings(index);
import org.opensearch.monitor.fs.FsInfo;
            assertEquals(  
        CountDownLatch migrationStarted = new CountDownLatch(1);  
        Settings currentSettings = internalCluster().clusterService().state().metadata().index(indexName).getSettings();  
    }
            waitForReplication("stuck-index");
            if (onWarmNodes) {  
            indexBulk(INDEX_NAME_2, 5000);
        MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();  
        indexBulk(STUCK_INDEX, 100);
        indexBulk(STUCK_INDEX, 100);
                for (String index : indices) {  
            client().admin().indices().execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", index)).actionGet();
    }  
     * Intercepts the UPDATE_VISIBLE_CHECKPOINT transport action on all nodes to gracefully handle
    }
            }, 30, TimeUnit.SECONDS);
        Exception e = expectThrows(  
        plugins.add(MockTransportService.TestPlugin.class);
        internalCluster().startDataOnlyNode(settingsBuilder.build());  
            assertTrue(secondResponse.isAcknowledged());
                SegmentReplicationSourceService.Actions.UPDATE_VISIBLE_CHECKPOINT,  
                ClusterState state = client().admin().cluster().prepareState().get().getState();
        client().admin().indices().delete(new DeleteIndexRequest("test-index-3")).actionGet();
        } finally {
            assertTrue("Migration timed out", migrationLatch.await(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS));
                    indexDocCounts.get(index).longValue(),  
     * See: https://github.com/opensearch-project/OpenSearch/issues/3923  
            createTestIndex(index, 1, 1);  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.storage.action.tiering.HotToWarmTierAction;
import org.opensearch.core.transport.TransportResponse;  
import org.opensearch.cluster.node.DiscoveryNodeRole;
        flush(INDEX_NAME);  
        } finally {
        });  
                internalCluster().restartNode(nodeName);
                .indices()  
                IndexModule.TieringState.HOT_TO_WARM.toString()
            }, 60, TimeUnit.SECONDS);
        );  
            }  
        String replicaNode = internalCluster().startDataOnlyNode(settingsBuilder.build());  
                .execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", STUCK_INDEX))
        refresh(INDEX_NAME);  
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
            assertTrue(stuckResponse.isAcknowledged());
        interceptCheckpointUpdates();
                .execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", "stuck-index"))
            (discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, TOTAL_SPACE_BYTES, TOTAL_SPACE_BYTES)
            }
    }
    public void testWarmMigrationReplicaCountFrom2To1() throws Exception {
        verifyMigrationError(INDEX_NAME, "Rejecting tiering request as JVM Utilization is high on all [WARM] nodes");  
            .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "10b")  
            client().admin().indices().execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", "second-index")).actionGet();
        return plugins;  
        if (extra != null) {  
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Long> indexDocCounts = new HashMap<>();
    }
import org.opensearch.node.NodeResourceUsageStats;  
            internalCluster().getClusterManagerName()
            assertBusy(() -> {
        } finally {
        migrateToWarm(INDEX_NAME);
        createTestIndex("test-index-2", 1, 0);  
                    ClusterState state = client().admin().cluster().prepareState().get().getState();
            }, 30, TimeUnit.SECONDS);
        } finally {
}
        }
            AcknowledgedResponse response = client().admin().indices().execute(HotToWarmTierAction.INSTANCE, request).actionGet();
import java.util.HashMap;
        createTestIndex(INDEX_NAME_2, 1, 1);
    public void testWarmMigrationReplicaCountFrom0To1() throws Exception {  
        createTestIndex(STUCK_INDEX, 1, 1);  
        String primaryNode = internalCluster().startDataOnlyNode(settingsBuilder.build());  
        "testWarmMigrationWithAllNodesJVMUtilizationBreached",
        internalCluster().startDataOnlyNodes(2, settingsBuilder.build());
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
            flush(STUCK_INDEX);  
        CountDownLatch migrationLatch = new CountDownLatch(indices.length);  
        try {
    protected CountDownLatch waitForMigrationToStart(String indexName) {
        assertEquals(100, client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value());  
        try {
                assertEquals(
            .execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", INDEX_NAME))
import org.opensearch.index.IndexModule;
        indexBulk(STUCK_INDEX, 100);
        String testName = getTestName();
            () -> client().admin()
        flush(INDEX_NAME);  
        setupCluster(1);  
        Settings.Builder settingsBuilder = Settings.builder()
                }  
                .actionGet();
        internalCluster().startDataOnlyNode(settingsBuilder.build());  
    protected static void assertIndexShardLocation(String indexName, boolean onWarmNodes) {
        assertEquals(
        migrateToWarm(INDEX_NAME);
                assertIndexShardLocation(STUCK_INDEX, false);  
                verifyWarmIndexSettings("second-index");  
        setupCluster(1);  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
    }
                "Incorrect value for setting: " + entry.getKey(),
                    verifyWarmIndexSettings(index);
        MockInternalClusterInfoService.TestPlugin.class,  
        createTestIndex(INDEX_NAME, 1, 1);
        createTestIndex("test-index-2", 1, 1);  
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();  
            .put(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "0ms")
        verifyMigrationError(INDEX_NAME, "Cannot migrate index [" + INDEX_NAME + "] to WARM tier");
                    .indices()  
        Map<String, Long> indexStats = indexData(randomIntBetween(1, 3), true, INDEX_NAME);  
                .execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", STUCK_INDEX))
    }
    }
import org.opensearch.test.OpenSearchIntegTestCase;
        internalCluster().startWarmOnlyNodes(2, settingsBuilder.build());  
        String masterNodeId = internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());
    );
                verifyWarmIndexSettings(STUCK_INDEX);
                verifyWarmIndexSettings(STUCK_INDEX);  
            assertBusy(() -> {
        clusterInfoService.setDiskUsageFunctionAndRefresh((discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, TOTAL_SPACE_BYTES, 850L));  
            DiscoveryNode assignedNode = state.nodes().get(assignedNodeId);
                }
        try {  
        );
                .indices()  
import org.opensearch.cluster.routing.IndexRoutingTable;  
        client().admin().indices().delete(new DeleteIndexRequest("test-replica-0to1")).actionGet();  
import org.opensearch.action.DocWriteResponse;  
        }
            flush(index);
                .execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("WARM", "test-index-3"))
        assertTrue("Migration didn't start", migrationStarted.await(MIGRATION_TIMEOUT_SECONDS, TimeUnit.SECONDS));
        internalCluster().startWarmOnlyNodes(1);
        } finally {
    protected static final Map<String, Class<? extends Plugin>> TEST_SPECIFIC_CUSTOM_CLUSTER_INFO = Map.of(
        createTestIndex(INDEX_NAME, 1, 1);
            TieringTestUtils.safeSleep(1000);  
import org.opensearch.common.unit.TimeValue;
                waitForReplication(index);
        assertThat(e.getMessage(), containsString(expectedErrorMessage));
            flush(index);  
                client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
        for (Map.Entry<String, Object> entry : expectedSettings.entrySet()) {
    }
                assertIndexShardLocation(INDEX_NAME, false);
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());
                refresh(index);
                .collect(Collectors.toList());
    public void testWarmMigrationWithAllNodesWaterMarkBreachedWithExistingTieredIndices() throws Exception {
        interceptCheckpointUpdates();  
        return false;
        return Settings.builder()
            waitForReplication(STUCK_INDEX);
            );
package org.opensearch.storage.tiering;
            ClusterStateListener listener = new TieringTestUtils.MockTieringCompletionListener(
            client().admin().indices().delete(new DeleteIndexRequest(STUCK_INDEX)).actionGet();  
        setupCluster(numberOfReplicas, null);
                .indices()  
        internalCluster().startWarmOnlyNodes(2, settingsBuilder.build());
    protected void refreshClusterInfo() {
            waitForReplication(index);
            }
            expectedDocsAfterDelete,
                .get()
        final IndexTieringRequest request = new IndexTieringRequest("warm", indexName);
        AcknowledgedResponse resp = client().admin()
                .indices()  
        setupCluster(1, settingsBuilder.build());
        createTestIndex(INDEX_NAME, 1, 1);
        }  
        }
        Settings disabledSettings = buildDisabledAllocationSettings();
            assertBusy(() -> {
            }, 30, TimeUnit.SECONDS);
        refresh(STUCK_INDEX);  
        refresh(INDEX_NAME);  
                .indices()
            assertBusy(() -> {
            .put(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "0ms")  
            }
            ensureStableCluster(6);
                .map(DiscoveryNode::getName)
import static org.hamcrest.Matchers.containsString;
                ensureGreen(STUCK_INDEX);
            client().admin().indices().delete(new DeleteIndexRequest("second-index")).actionGet();
import java.util.Collection;
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
        client().admin().indices().delete(new DeleteIndexRequest("test-replica")).actionGet();
        Class<? extends Plugin> extra = TEST_SPECIFIC_CUSTOM_CLUSTER_INFO.get(testName);
        final String[] indices = new String[] { "test-1", "test-2", "test-3" };  
        TEST_SPECIFIC_CACHE_SIZES.put("testWarmMigrationWithLargeTieringIndicesQueue", new ByteSizeValue(300, ByteSizeUnit.BYTES));  
        );
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());  
        createIndex(indexName, indexSettings);
        setupCluster(numberOfReplicas);
            for (String index : indices) {
                ShardRouting shard = state.routingTable().index(STUCK_INDEX).shard(0).primaryShard();
                assertFalse("Shard should not be relocating", shard.relocating());
            flush(STUCK_INDEX);  
        setupCluster(1);
    }  
        interceptCheckpointUpdates();  
            .put(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "0ms")
            ClusterState state = client().admin().cluster().prepareState().get().getState();  
        try {
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
        internalCluster().startDataOnlyNodes(2, settingsBuilder.build());
        }
            assertBusy(() -> {
            }, 30, TimeUnit.SECONDS);
            refresh(STUCK_INDEX);  
import org.opensearch.storage.action.tiering.IndexTieringRequest;  
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING;  
            TieringTestUtils.safeSleep(4000);  
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNode));  
            new ByteSizeValue(1000, ByteSizeUnit.BYTES)
            }, 30, TimeUnit.SECONDS);
        MockInternalClusterInfoService.TestPlugin.class,
            assertEquals(DocWriteResponse.Result.DELETED, client().prepareDelete(indexName, docId).get().getResult());  
                IndexModule.TieringState.HOT_TO_WARM.toString()  
        Settings.Builder settingsBuilder = Settings.builder()
    protected static final Map<String, ByteSizeValue> TEST_SPECIFIC_CACHE_SIZES = new HashMap<>();
            if (event.state().routingTable().hasIndex(INDEX_NAME)) {
        for (String index : indices) {  
        Settings.Builder settingsBuilder = Settings.builder()
                boolean isRelocating = event.state().routingTable().allShards(indexName).stream().anyMatch(ShardRouting::relocating);  
                .actionGet();
                }  
        createTestIndex(STUCK_INDEX, 1, 1);
    public void testBulkOnWarmIndexWithFileCacheEvictionHappeningAlways() throws Exception {  
        indexBulk(INDEX_NAME_2, 5000);  
    }  
    public void testWarmMigrationForExistingMigratingIndex() throws Exception {
        for (String index : indices) {
            }  
    public void testWarmMigrationWithLargeTieringIndicesQueue() throws Exception {
                assertIndexShardLocation(STUCK_INDEX, false);
                flush(index);  
        migrateToWarm("test-replica-0to1");
            .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "0b")
            .put(clusterSettings == null ? Settings.EMPTY : clusterSettings);
        assertThrows(  
            plugins.add(extra);
        refreshClusterInfo();  
        } finally {
            for (String index : indices) {
                assertTrue("Primary should be on warm node", primaryNode.getRoles().contains(DiscoveryNodeRole.WARM_ROLE));
        client().admin().indices().delete(new DeleteIndexRequest("test-index-2")).actionGet();
    @Override  
import java.util.ArrayList;  
        refresh(INDEX_NAME);
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());  
                ClusterState state = client().admin().cluster().prepareState().get().getState();  
    }
        }
        }  
                assertIndexShardLocation(index, false);
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());
            .put(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 1);
                }
        flushAndRefresh(INDEX_NAME_2);
        client().admin().indices().execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", INDEX_NAME)).actionGet();  
            assertTrue("Hot to Warm migration timed out", latch.await(MIGRATION_TIMEOUT_SECONDS, TimeUnit.SECONDS));
        setupCluster(1);
                .actionGet();
            }
    @Override  
/*  
            assertTrue(resp.isAcknowledged());
                AcknowledgedResponse response = client().admin()
        // Ensure segment replication is fully caught up before triggering relocation
            ensureGreen(indices);  
    }
import org.opensearch.cluster.MockInternalClusterInfoService;
        for (String index : indices) {
    protected void verifyWarmIndexSettings(String indexName) {
                .getSetting("test-replica-0to1", IndexMetadata.SETTING_NUMBER_OF_REPLICAS)
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME_2)).actionGet();  
    public void testHotToWarmMigrationWithData() throws Exception {
            AcknowledgedResponse resp = client().admin()
import static org.opensearch.storage.tiering.TieringTestUtils.buildDisabledAllocationSettings;
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();  
        Settings.Builder settingsBuilder = Settings.builder()
    }
                .indices()
        createTestIndex(INDEX_NAME, 1, 0);
import org.opensearch.search.SearchHit;
            if (event.state().routingTable().hasIndex(indexName)) {
        interceptCheckpointUpdates();  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
    public void testHotToWarmMigrationWithDeletedDocumentSuccess() throws Exception {
                .prepareGetSettings("test-replica-0to1")
                for (String index : indices) {  
        flush(INDEX_NAME);
        createTestIndex(INDEX_NAME, 1, numberOfReplicas);
            MockTransportService mockTransportService = (MockTransportService) internalCluster().getInstance(
                .getSetting("test-replica", IndexMetadata.SETTING_NUMBER_OF_REPLICAS)
            }
        createTestIndex(INDEX_NAME, 1, 1);
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
                nodeName  
        migrateToWarm(INDEX_NAME_2);
            assertTrue(resp.isAcknowledged());  
        final String STUCK_INDEX = "stuck-index";
            waitForReplication(index);
            ClusterInfoService.class,  
        return new FsInfo.Path(original.getPath(), original.getMount(), totalBytes, freeBytes, freeBytes);
            assertEquals(100, client().prepareSearch(STUCK_INDEX).setSize(0).get().getHits().getTotalHits().value());
        createTestIndex("test-index-3", 1, 1);
            clusterService().addListener(listener);  
        // Ensure segment replication is fully caught up before triggering relocation  
import org.opensearch.test.InternalTestCluster;
                ClusterState state = client().admin().cluster().prepareState().get().getState();  
        setupCluster(1, buildDisabledAllocationSettings());  
            assertBusy(() -> {
            listeners.forEach(l -> clusterService().removeListener(l));  
                entry.getValue().toString(),
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        refresh(STUCK_INDEX);  
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;  
        for (String index : indices) {
import org.opensearch.cluster.routing.ShardRouting;
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();  
import org.opensearch.cluster.ClusterInfoService;
        }
                    assertIndexShardLocation(index, true);
            .put("cluster.tiering.max_concurrent_hot_to_warm_requests", 2);  
        }
        }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
            assertTrue(stuckResponse.isAcknowledged());  
        List<String> inFlightIndices = List.of(INDEX_NAME, "test-index-2");
        return Settings.builder().put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true).build();  
            AcknowledgedResponse secondResponse = client().admin()
                .actionGet();  
                    ShardRouting shard = state.routingTable().index(index).shard(0).primaryShard();  
        return deletedIds;
            assertTrue(response.isAcknowledged());  
        migrateToWarm(INDEX_NAME);  
    }
        int numberOfReplicas = randomIntBetween(0, 1);
                .execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", index))  
import java.util.List;  
        try {
                    assertIndexShardLocation(index, true);
                .get()  
public class HotToWarmTieringServiceIT extends RemoteStoreBaseIntegTestCase {
        CountDownLatch migrationStarted = new CountDownLatch(1);  
        }
                assertTrue("Shard should be on warm node", assignedNode.getRoles().contains(DiscoveryNodeRole.WARM_ROLE));
    public void testWarmMigrationWithAllNodesWaterMarkBreached() {
            TieringTestUtils.safeSleep(5000);
        refreshClusterInfo();  
                assertIndexShardLocation(INDEX_NAME, false);  
        long expectedDocsAfterDelete = initialDocCount - deletedIds.size();
                ShardRouting primaryShard = state.routingTable().index(INDEX_NAME).shard(0).primaryShard();
            verifyMigrationError("test-index-3", "since we don't have enough space on all warm nodes");
            }, 60, TimeUnit.SECONDS);
            waitForReplication(indexName);
        setupCluster(numberOfReplicas, lowDiskWaterMark, dataToFileCacheRatio, null);  
        } finally {  
            waitForReplication(index);
import org.opensearch.indices.replication.SegmentReplicationSourceService;  
                assertFalse("Shard should not be relocating", shardRouting.relocating());  
                    migrationStarted.countDown();
                ShardRouting shardRouting = state.routingTable().index(INDEX_NAME).shard(0).primaryShard();
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 600L);
                currentSettings.get(entry.getKey())  
            // Trigger migration again — should get ack (idempotent)
            ensureGreen(indices);
    }  
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildDisabledAllocationSettings()).get();
    static {
        createTestIndex(INDEX_NAME, numberOfShards, numberOfReplicas);
            final IndexTieringRequest request = new IndexTieringRequest("warm", indexName);
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        SearchResponse searchResponse = client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).setSize(count).get();  
            assertBusy(() -> {  
     * the known race condition where a checkpoint update arrives during relocation handoff.
        );
            nodeId -> new NodeResourceUsageStats(nodeId, System.currentTimeMillis(), 99, 20, null, 0.0)  
        infoService.refresh();  
        setupCluster(1, settingsBuilder.build());
            ClusterState state = client().admin().cluster().prepareState().get().getState();
                migrationLatch,
    }
                .execute(HotToWarmTierAction.INSTANCE, secondRequest)
        try {
        ensureYellow(STUCK_INDEX);
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
        internalCluster().startDataOnlyNodes(numberOfReplicas + 1, settingsBuilder.build());
        }
                .actionGet();
        }
    public void testWarmMigrationWithoutClusterInfoMockForJVMUtilization() throws Exception {
                assertIndexShardLocation(STUCK_INDEX, false);  
        createTestIndex("stuck-index", 1, 1);
                .prepareGetSettings("test-replica-0to1")
    }
        interceptCheckpointUpdates();  
    private static final int MIGRATION_TIMEOUT_SECONDS = 30;
        internalCluster().startClusterManagerOnlyNode();  
                ShardRouting shardRouting = state.routingTable().index(INDEX_NAME).shard(0).primaryShard();
        ensureGreen(STUCK_INDEX);
    public void testHotToWarmMigrationDuringQuorumLoss() throws Exception {
        clusterInfoService.setDiskUsageFunctionAndRefresh((discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, 100L, 10L));  
import org.opensearch.action.search.SearchResponse;
        InternalClusterInfoService infoService = (InternalClusterInfoService) internalCluster().getInstance(
            "1",
        Settings.Builder settingsBuilder = Settings.builder().put(buildDisabledAllocationSettings());  
        migrateToWarm("test-replica");
            .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "100b")
     */
        refreshClusterInfo();  
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());
    protected MockInternalClusterInfoService getMockInternalClusterInfoService() {  
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();  
                assertIndexShardLocation(STUCK_INDEX, true);  
            "testWarmMigrationWithAllNodesWaterMarkBreachedWithExistingTieredIndices",  
        createTestIndex(STUCK_INDEX, 1, 1);
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 50L);
    protected void createTestIndex(String indexName, int numberOfShards, int numberOfReplicas) {  
        clusterService().removeListener(relocationListener);
        Settings.Builder settingsBuilder = Settings.builder()  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
import java.util.Map;
    }
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());
            .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), lowDiskWaterMark != null ? lowDiskWaterMark : "10b")
            assertBusy(() -> {  
            String assignedNodeId = shardRouting.currentNodeId();
            List<String> dataNodeNames = state.nodes()
                assertTrue(response.isAcknowledged());  
            client().admin()  
        ClusterStateListener relocationListener = event -> {
            "1",
        createTestIndex("test-replica-0to1", 1, 0);
                verifyWarmIndexSettings("stuck-index");
                assertTrue("Primary should be assigned", primaryShard.assignedToNode());
        clusterInfoService.setNodeResourceUsageFunctionAndRefresh(
        assertBusy(() -> assertIndexShardLocation(INDEX_NAME, true), 30, TimeUnit.SECONDS);
            .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "10b")
            .put(ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500))  
        internalCluster().startDataOnlyNodes(2, settingsBuilder.build());
        createTestIndex("test-index-2", 1, 1);
    }
            "Document count changed after migration",  
        assertIndexShardLocation(INDEX_NAME, false);
import org.opensearch.common.settings.Settings;  
        List<ClusterStateListener> listeners = new ArrayList<>();
            AcknowledgedResponse stuckResponse = client().admin().indices().execute(HotToWarmTierAction.INSTANCE, stuckRequest).actionGet();  
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
                );
            .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "50b")
        Settings indexSettings = Settings.builder()
    }
            client().admin().indices().execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", index)).actionGet();  
        TEST_SPECIFIC_CACHE_SIZES.put(
    public void testMultipleIndicesHotToWarmMigration() throws Exception {
                    verifyWarmIndexSettings(index);
        ensureYellow(STUCK_INDEX);
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());  
            );
            IndexModule.TieringState.HOT_TO_WARM.toString()
    }  
        Settings.Builder settingsBuilder = Settings.builder().put(buildDisabledAllocationSettings());  
import static org.opensearch.storage.tiering.TieringTestUtils.buildEnabledAllocationSettings;  
            createTestIndex(INDEX_NAME, 1, 1);  
        // Adding a delay to let the JVM and CPU stats get collected
        final String STUCK_INDEX = "stuck-index";
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();  
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())  
                        channel.sendResponse(TransportResponse.Empty.INSTANCE);
        interceptCheckpointUpdates();  
        internalCluster().startDataOnlyNodes(1);
            client().admin().indices().delete(new DeleteIndexRequest(STUCK_INDEX)).actionGet();  
            AcknowledgedResponse secondResponse = client().admin()  
        ensureGreen(STUCK_INDEX);
            assertFalse("Index should be deleted", state.metadata().hasIndex(INDEX_NAME));
                .indices()
            AcknowledgedResponse resp = client().admin()
                ShardRouting shard = state.routingTable().index(STUCK_INDEX).shard(0).primaryShard();
                for (String index : indices) {
            }  
                    assertFalse("Shard should not be relocating", shard.relocating());
        "testWarmMigrationWithAllNodesWaterMarkBreached",  
    }
import org.opensearch.index.query.QueryBuilders;
import org.opensearch.plugins.Plugin;
import org.opensearch.test.transport.MockTransportService;  
    }
            }  
        }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
        assertIndexShardLocation(INDEX_NAME, false);  
        try {
            assertBusy(() -> {  
        refresh(INDEX_NAME);
            .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "0b")  
        }
    protected boolean ignoreExternalCluster() {
        interceptCheckpointUpdates();  
                    client().prepareSearch(index).setSize(0).get().getHits().getTotalHits().value()
        setupCluster(numberOfReplicas, null, null, clusterSettings);
            internalCluster().stopCurrentClusterManagerNode();  
        TEST_SPECIFIC_CACHE_SIZES.put("testWarmMigrationWithAllNodesWaterMarkBreached", new ByteSizeValue(100, ByteSizeUnit.BYTES));
                AcknowledgedResponse response = client().admin()
        int numberOfShards = randomIntBetween(1, 2);
        interceptCheckpointUpdates();  
    protected void verifyMigrationError(String indexName, String expectedErrorMessage) {
            assertBusy(() -> { assertIndexShardLocation("stuck-index", false); }, 30, TimeUnit.SECONDS);  
import org.opensearch.cluster.InternalClusterInfoService;
        Exception exception = expectThrows(IllegalArgumentException.class, () -> migrateToWarm("invalid-index"));  
                flush(index);  
                index,
    protected void setupCluster(int numberOfReplicas) {  
    protected static FsInfo.Path setDiskUsage(FsInfo.Path original, long totalBytes, long freeBytes) {
        } finally {
        return migrationStarted;
                verifyWarmIndexSettings(INDEX_NAME);  
            }  
            assertEquals(100, client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value());
    protected Settings featureFlagSettings() {
        for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
import org.opensearch.cluster.node.DiscoveryNode;
            .put(ResourceTrackerSettings.GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(5000))
        setupCluster(1, buildDisabledAllocationSettings());  
            .build();
            client().admin().indices().delete(new DeleteIndexRequest("test-index-2")).actionGet();
            );
import java.util.concurrent.CountDownLatch;
            for (String index : indices) {
        MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
        internalCluster().startWarmOnlyNodes(2, settingsBuilder.build());
        Map<String, Object> expectedSettings = TieringTestUtils.getExpectedWarmIndexSettings();
        );  
                ClusterState state = client().admin().cluster().prepareState().get().getState();
        ByteSizeValue cacheSize = TEST_SPECIFIC_CACHE_SIZES.getOrDefault(testName, new ByteSizeValue(1, ByteSizeUnit.GB));  
    private List<String> deleteRandomDocuments(String indexName, int count) {
            waitForReplication("second-index");  
            assertEquals(100, client().prepareSearch(STUCK_INDEX).setSize(0).get().getHits().getTotalHits().value());
        }
        String testName = getTestName();
            client().admin().indices().delete(new DeleteIndexRequest(STUCK_INDEX)).actionGet();  
        );
    }
            .put(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 1.0);
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING;  
        Settings.Builder settingsBuilder = Settings.builder().put(buildDisabledAllocationSettings());
                continue;
                    assertIndexShardLocation(index, true);
        }
import org.opensearch.cluster.ClusterStateListener;  
        "testWarmMigrationWithAllNodesWaterMarkBreachedWithExistingTieredIndices",
            }
                    ShardRouting shard = state.routingTable().index(index).shard(0).primaryShard();  
        );  
                assertFalse("Shard should not be on warm node", assignedNode.getRoles().contains(DiscoveryNodeRole.WARM_ROLE));  
            }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        migrateToWarm(INDEX_NAME);  
                .indices()  
 *
        };
            listeners.forEach(l -> clusterService().removeListener(l));
                    assertIndexShardLocation(index, false);
    private static final long TOTAL_SPACE_BYTES = new ByteSizeValue(1000, ByteSizeUnit.KB).getBytes();
            .put(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0)
            .actionGet();
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
import java.util.concurrent.TimeUnit;  
            for (String index : indices) {
            indexName,
            .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "10b")
            }
    protected void migrateToWarm(String indexName) throws Exception {  
        IndexRoutingTable indexRoutingTable = state.routingTable().index(indexName);  
        );  
    }  
                assertIndexShardLocation(STUCK_INDEX, true);
            assertTrue("Migration timed out", migrationLatch.await(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS));
                migrationLatch,
            IllegalArgumentException.class,
        );
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
 * this file be licensed under the Apache-2.0 license or a
            refresh(INDEX_NAME);  
        try {
        setupCluster(1);
            .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "20b")  
                    .execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", index))
            assertBusy(() -> {
    }  
    public void testWarmMigrationWithAllNodesJVMUtilizationBreached() {
            .build();
        logger.info("Testing migration with deletions, replicas: {}", numberOfReplicas);
            } else {
                .prepareGetSettings("test-replica")  
        } finally {
        verifyMigrationError("test-index-2", "since we don't have enough space on all warm nodes");
        assertIndexShardLocation(INDEX_NAME, false);
        clusterService().addListener(event -> {
                assertIndexShardLocation(indexName, true);
        createTestIndex("test-index-3", 1, 1);
            }
            AcknowledgedResponse response = client().admin().indices().execute(HotToWarmTierAction.INSTANCE, request).actionGet();
    }
        } finally {
        for (SearchHit hit : searchResponse.getHits()) {  
            final IndexTieringRequest secondRequest = new IndexTieringRequest("warm", INDEX_NAME);
                    }  
                .getNodes()  
        verifyMigrationError(INDEX_NAME, "since we don't have enough space on all warm nodes");  
            ensureStableCluster(5);
            TieringTestUtils.safeSleep(4000);
        try {
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
    public void testConcurrentMigrationWithStuckIndexAndDataNodesRestarts() throws Exception {
            AcknowledgedResponse resp = client().admin()
            waitForReplication(STUCK_INDEX);
        internalCluster().startDataOnlyNodes(2, settingsBuilder.build());
        interceptCheckpointUpdates();
import org.opensearch.core.common.unit.ByteSizeValue;
        assertEquals(
            flush(STUCK_INDEX);  
                .values()
            assertBusy(() -> {
                createTestIndex(index, 1, 1);  
                assertFalse("Shard should not be relocating", shardRouting.relocating());
                    assertIndexShardLocation(index, true);
                    assertIndexShardLocation(index, false);
            final IndexTieringRequest request = new IndexTieringRequest("warm", INDEX_NAME);
            AcknowledgedResponse resp = client().admin()
            for (String index : indices) {
                }  
        } finally {
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();  
        clusterService().addListener(relocationListener);  
        List<ClusterStateListener> listeners = new ArrayList<>();  
            indexBulk(INDEX_NAME, 100);
        setupCluster(numberOfReplicas, null, null);  
    }
                assertIndexShardLocation("second-index", true);
                .actionGet();
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING;
                .getSetting("test-replica", IndexMetadata.SETTING_NUMBER_OF_REPLICAS)
            client().admin().indices().delete(new DeleteIndexRequest("stuck-index")).actionGet();  
    public void testHotToWarmMigrationWithUnassignedReplica() throws Exception {
        internalCluster().startWarmOnlyNodes(2, settingsBuilder.build());
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
    }
    protected boolean addMockIndexStorePlugin() {  
    }  
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING;
    }
                boolean isRelocating = event.state().routingTable().allShards(INDEX_NAME).stream().anyMatch(ShardRouting::relocating);  
        internalCluster().startDataOnlyNodes(2, settingsBuilder.build());
        assertEquals(  
    }
            final IndexTieringRequest secondRequest = new IndexTieringRequest("warm", "test-index-2");  
            () -> client().admin().indices().execute(HotToWarmTierAction.INSTANCE, request).actionGet()
            assertTrue(secondResponse.isAcknowledged());
                    .actionGet();
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
            }, 60, TimeUnit.SECONDS);
                    .actionGet();
    @Override
        MockInternalClusterInfoService.TestPlugin.class
                    try {
                .get()  
        try {
        assertBusy(() -> {
            assertBusy(() -> {
    private static final int DEFAULT_TIMEOUT_SECONDS = 30;  
            mockTransportService.addRequestHandlingBehavior(
        return (MockInternalClusterInfoService) internalCluster().getCurrentClusterManagerNodeInstance(ClusterInfoService.class);
            flush(indexName);  
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
            clusterService().addListener(listener);  
            .put(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "0ms")  
            AcknowledgedResponse stuckResponse = client().admin().indices().execute(HotToWarmTierAction.INSTANCE, stuckRequest).actionGet();
            .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "50b")  
            .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "0b")
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());
        internalCluster().startWarmOnlyNodes(1, settingsBuilder.build());
            client().admin()  
        assertEquals(
                        handler.messageReceived(request, channel, task);  
        }
        internalCluster().startWarmOnlyNodes(2, settingsBuilder.build());
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 230L);
    }
            for (String index : indices) {
        CountDownLatch latch = new CountDownLatch(1);
        waitForReplication(INDEX_NAME);
import org.opensearch.cluster.metadata.IndexMetadata;  
        // Ensure segment replication is fully caught up before triggering relocation
    protected void setupCluster(int numberOfReplicas, Settings clusterSettings) {
        ensureGreen("stuck-index", "second-index");  
        try {  
                }  
                assertIndexShardLocation(INDEX_NAME, true);
        MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
            .put(disabledSettings);  
        client().admin().indices().delete(new DeleteIndexRequest("test-index-2")).actionGet();  
            assertIndexShardLocation(index, false);
                .get()
    }
import java.util.stream.Collectors;
        assertIndexShardLocation(INDEX_NAME, false);
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
            );
    protected static final String INDEX_NAME = "h2w-test-idx-1";
            .put(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "0ms")  
            }, 60, TimeUnit.SECONDS);
    @Override
            }, 30, TimeUnit.SECONDS);
    }
            flush(index);
                assertIndexShardLocation(STUCK_INDEX, true);  
        for (String index : indices) {  
            .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "10b")
            assertBusy(() -> {
    }
                    .indices()  
    }
            flush(index);
            for (String index : indices) {  
    }  
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
        long initialDocCount = indexStats.get(TOTAL_OPERATIONS);
                .stream()
        createTestIndex(INDEX_NAME, 1, 1);
    }
            .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "10b")
    public void testWarmMigrationForInvalidIndex() throws Exception {
                    ClusterState state = client().admin().cluster().prepareState().get().getState();
            assertTrue(resp.isAcknowledged());  
        for (int i = 0; i < 5; i++) {  
        }
        List<String> deletedIds = deleteRandomDocuments(INDEX_NAME, 2);  
                indexDocCounts.put(index, 100L);
                assertFalse("Shard should not be relocating", shard.relocating());  
                ensureGreen(STUCK_INDEX);
            assertBusy(() -> {
                ClusterState state = client().admin().cluster().prepareState().get().getState();  
        interceptCheckpointUpdates();  
    public void testHotToWarmMigrationWithMasterNodeFailure() throws Exception {
        createTestIndex(INDEX_NAME, 1, 1);  
        internalCluster().startWarmOnlyNodes(2, settingsBuilder.build());
    protected void setupCluster(int numberOfReplicas, String lowDiskWaterMark, String dataToFileCacheRatio, Settings clusterSettings) {  
        );
                client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
            String docId = hit.getId();
                waitForReplication(index);
        final String STUCK_INDEX = "stuck-index";
                .actionGet();
        List<String> deletedIds = new ArrayList<>();
            OpenSearchRejectedExecutionException.class,
    /**  
            deletedIds.add(docId);
                if (isRelocating) migrationStarted.countDown();
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();  
            }
    @Override
            .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "150b")  
        }
                .execute(HotToWarmTierAction.INSTANCE, secondRequest)  
