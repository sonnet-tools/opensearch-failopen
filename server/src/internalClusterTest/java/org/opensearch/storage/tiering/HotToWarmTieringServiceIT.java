import org.opensearch.cluster.node.DiscoveryNodeRole;
    }
            mockTransportService.addRequestHandlingBehavior(
    @Override
        Map<String, Object> expectedSettings = TieringTestUtils.getExpectedWarmIndexSettings();
            createTestIndex(INDEX_NAME, 1, 1);
            ClusterStateListener listener = new TieringTestUtils.MockTieringCompletionListener(
        final IndexTieringRequest request = new IndexTieringRequest("warm", indexName);
    }
            client().admin()
        internalCluster().startWarmOnlyNodes(2, settingsBuilder.build());
        } finally {
    }
    }
                client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
                .getNodes()
            assertBusy(() -> {
        refreshClusterInfo();
    }
        for (String index : indices) {
            .put(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "0ms")
                AcknowledgedResponse response = client().admin()
        createTestIndex(STUCK_INDEX, 1, 1);
                    ClusterState state = client().admin().cluster().prepareState().get().getState();
        internalCluster().startDataOnlyNodes(2, settingsBuilder.build());
                assertTrue(response.isAcknowledged());
        }
        createTestIndex(INDEX_NAME, 1, 1);
            waitForReplication(index);
        assertIndexShardLocation(INDEX_NAME, false);
        internalCluster().startDataOnlyNodes(2, settingsBuilder.build());
        Settings.Builder settingsBuilder = Settings.builder()
        }
        CountDownLatch migrationLatch = new CountDownLatch(indices.length);
            waitForReplication(index);
    }
            flush(indexName);
            waitForReplication(STUCK_INDEX);
            assertBusy(() -> {
            }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        createTestIndex(INDEX_NAME, 1, 1);
        }
    protected void migrateToWarm(String indexName) throws Exception {
        setupCluster(numberOfReplicas, null);
import org.opensearch.cluster.routing.IndexShardRoutingTable;
    public void testConcurrentMigrationWithStuckIndexAndDataNodesRestarts() throws Exception {
            );
                boolean isRelocating = event.state().routingTable().allShards(INDEX_NAME).stream().anyMatch(ShardRouting::relocating);
                assertIndexShardLocation(INDEX_NAME, false);
        try {
                waitForReplication(index);
            }, 60, TimeUnit.SECONDS);
        assertEquals(
        createTestIndex("test-index-3", 1, 1);
            assertTrue("Migration timed out", migrationLatch.await(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS));
            ensureYellow(INDEX_NAME);
import org.opensearch.core.transport.TransportResponse;
        return migrationStarted;
            client().admin().indices().delete(new DeleteIndexRequest("second-index")).actionGet();
            for (String index : indices) {
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING;
        ClusterStateListener listener = new TieringTestUtils.MockTieringCompletionListener(
            }
                assertIndexShardLocation(STUCK_INDEX, false);
            assertEquals(100, client().prepareSearch(STUCK_INDEX).setSize(0).get().getHits().getTotalHits().value());
    }
        migrateToWarm(INDEX_NAME);
                .indices()
    @Override
                );
        Exception exception = expectThrows(IllegalArgumentException.class, () -> migrateToWarm("invalid-index"));
        assertEquals(100, client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value());
        setupCluster(1);
                    .indices()
        ensureGreen();
        );
        ensureGreen(STUCK_INDEX);
            assertBusy(() -> { assertIndexShardLocation("stuck-index", false); }, 30, TimeUnit.SECONDS);
                internalCluster().restartNode(nodeName);
    public void testWarmMigrationWithLargeTieringIndicesQueue() throws Exception {
            assertTrue(resp.isAcknowledged());
            () -> client().admin().indices().execute(HotToWarmTierAction.INSTANCE, request).actionGet()
                    .actionGet();
            }, 30, TimeUnit.SECONDS);
            .put(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "0ms")
        final String STUCK_INDEX = "stuck-index";
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING;
            .put(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "0ms")
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.core.common.unit.ByteSizeValue;
            assertTrue(stuckResponse.isAcknowledged());
            .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "10b")
        interceptCheckpointUpdates();
        for (String index : indices) {
        CountDownLatch migrationLatch = new CountDownLatch(indices.length);
                .actionGet();
                for (String index : indices) {
                .indices()
    protected static final Map<String, ByteSizeValue> TEST_SPECIFIC_CACHE_SIZES = new HashMap<>();
            plugins.add(extra);
    @Override
        }
            flush(index);
        internalCluster().startDataOnlyNode(settingsBuilder.build());
            for (String nodeName : dataNodeNames) {
                    ShardRouting shard = state.routingTable().index(index).shard(0).primaryShard();
        } finally {
import org.opensearch.storage.action.tiering.HotToWarmTierAction;
        }
        AcknowledgedResponse resp = client().admin()
    }
        setupCluster(1, settingsBuilder.build());
            .put(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0)
            TieringTestUtils.safeSleep(1000);
        }
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());
        internalCluster().startWarmOnlyNodes(2, settingsBuilder.build());
        client().admin().indices().delete(new DeleteIndexRequest("test-replica-0to1")).actionGet();
        }
                TransportService.class,
    }
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        return new FsInfo.Path(original.getPath(), original.getMount(), totalBytes, freeBytes, freeBytes);
            deletedIds.add(docId);
            final IndexTieringRequest request = new IndexTieringRequest("warm", INDEX_NAME);
                ClusterState state = client().admin().cluster().prepareState().get().getState();
        List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
import org.opensearch.index.IndexModule;
    protected void migrateMultipleIndicesToWarm(String[] indices) throws Exception {
        refresh(INDEX_NAME);
                .get()
            if (onWarmNodes) {
        createTestIndex("second-index", 1, 1);
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        createTestIndex(INDEX_NAME, 1, 1);
        List<ClusterStateListener> listeners = new ArrayList<>();
            assertTrue("Migration timed out", migrationLatch.await(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS));
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());
                ensureGreen(STUCK_INDEX);
package org.opensearch.storage.tiering;
                assertFalse("Shard should not be relocating", shard.relocating());
        return plugins;
        }
                migrationLatch,
import java.util.List;
            .put(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 2.0);
                    assertIndexShardLocation(index, true);
                    assertIndexShardLocation(index, false);
import static org.opensearch.index.store.remote.filecache.FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING;
        setupCluster(1);
        // Ensure segment replication is fully caught up before triggering relocation
        assertEquals(
        migrateToWarm(INDEX_NAME);
            AcknowledgedResponse resp = client().admin()
                .collect(Collectors.toList());
                }
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME_2)).actionGet();
            for (String index : indices) {
            client().admin()
                .indices()
        createTestIndex(INDEX_NAME, 1, 1);
            waitForReplication(index);
        } finally {
                assertIndexShardLocation(index, false);
            ClusterInfoService.class,
        }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        createTestIndex(INDEX_NAME, 1, 1);
            ensureStableCluster(5);
                .actionGet();
                .indices()
import static org.opensearch.storage.tiering.TieringTestUtils.buildDisabledAllocationSettings;
                .prepareGetSettings("test-replica")
            }
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
                    ClusterState state = client().admin().cluster().prepareState().get().getState();
            }, 30, TimeUnit.SECONDS);
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
            ShardRouting shardRouting = shardRoutingTable.primaryShard();
        internalCluster().startWarmOnlyNodes(2, settingsBuilder.build());
                IndexModule.TieringState.HOT_TO_WARM.toString()
            assertBusy(() -> {
        interceptCheckpointUpdates();
        ensureGreen(INDEX_NAME);
            client().admin()
        createTestIndex("test-index-2", 1, 1);
        interceptCheckpointUpdates();
            }
            listeners.add(listener);
            .execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", INDEX_NAME))
            for (String index : indices) {
        setupCluster(1);
        interceptCheckpointUpdates();
            }, 30, TimeUnit.SECONDS);
 * this file be licensed under the Apache-2.0 license or a
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
    }
        indexBulk(STUCK_INDEX, 100);
        } finally {
        MockInternalClusterInfoService.TestPlugin.class,
    }
                .indices()
                    assertFalse("Shard should not be relocating", shard.relocating());
        try {
            client().admin().indices().execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", index)).actionGet();
        clusterInfoService.setDiskUsageFunctionAndRefresh((discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, 100L, 10L));
        createTestIndex("test-replica", 1, 2);
            final IndexTieringRequest stuckRequest = new IndexTieringRequest("warm", INDEX_NAME);
            .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "50b")
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        Settings.Builder settingsBuilder = Settings.builder().put(buildDisabledAllocationSettings());
        return (MockInternalClusterInfoService) internalCluster().getCurrentClusterManagerNodeInstance(ClusterInfoService.class);
        Settings currentSettings = internalCluster().clusterService().state().metadata().index(indexName).getSettings();
    }
    }
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
        assertIndexShardLocation(INDEX_NAME, false);
                entry.getValue().toString(),
        setupCluster(1, buildDisabledAllocationSettings());
import org.opensearch.search.SearchHit;
                .execute(HotToWarmTierAction.INSTANCE, secondRequest)
        createTestIndex("stuck-index", 1, 1);
        final String[] indices = new String[] { "test-1", "test-2", "test-3" };
        plugins.add(MockTransportService.TestPlugin.class);
        createTestIndex(STUCK_INDEX, 1, 1);
        internalCluster().startDataOnlyNodes(2, settingsBuilder.build());
            .put(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "0ms")
import org.opensearch.plugins.Plugin;
            }, 30, TimeUnit.SECONDS);
        }
            verifyMigrationError("test-index-3", "since we don't have enough space on all warm nodes");
            List<String> dataNodeNames = state.nodes()
            AcknowledgedResponse resp = client().admin()
        refresh(INDEX_NAME);
        indexBulk(INDEX_NAME_2, 5000);
        createTestIndex("test-index-2", 1, 0);
    }
            flush(index);
                .execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", "stuck-index"))
            .put(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "0ms")
                }
        try {
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());
        for (String nodeName : internalCluster().getNodeNames()) {
        TEST_SPECIFIC_CACHE_SIZES.put(
        clusterService().removeListener(relocationListener);
    }
        );
    public void testWarmMigrationWithAllNodesWaterMarkBreached() {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            }
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        } finally {
        for (String index : indices) {
            final IndexTieringRequest secondRequest = new IndexTieringRequest("warm", INDEX_NAME);
                indexBulk(index, 100);
        Settings indexSettings = Settings.builder()
        assertBusy(() -> assertIndexShardLocation(INDEX_NAME, true), 30, TimeUnit.SECONDS);
                    assertFalse("Shard should not be relocating", shard.relocating());
    protected boolean addMockIndexStorePlugin() {
        }
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
                    .actionGet();
            if (shardRouting.unassigned() && shardRouting.primary() == false) {
            .actionGet();
            listeners.add(listener);
                createTestIndex(index, 1, 1);
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 600L);
            clusterService().addListener(listener);
            flush("second-index");
            ClusterState state = client().admin().cluster().prepareState().get().getState();
        createTestIndex(INDEX_NAME, 1, 0);
        createTestIndex(INDEX_NAME, 1, 1);
    }
            }
            waitForReplication(indexName);
        ensureGreen(STUCK_INDEX);
            .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "10b")
                for (String index : indices) {
            TieringTestUtils.safeSleep(4000);
        assertThrows(
        internalCluster().startDataOnlyNodes(2, settingsBuilder.build());
        MockInternalClusterInfoService.TestPlugin.class,
            client().admin().indices().delete(new DeleteIndexRequest(STUCK_INDEX)).actionGet();
        return deletedIds;
            "0",
        for (String index : indices) {
                ClusterState state = client().admin().cluster().prepareState().get().getState();
        });
            waitForReplication(STUCK_INDEX);
        }
import org.opensearch.common.settings.Settings;
    }
        setupCluster(numberOfReplicas, lowDiskWaterMark, dataToFileCacheRatio, null);
        setupCluster(2);
 * compatible open source license.
        internalCluster().startDataOnlyNodes(2, settingsBuilder.build());
        infoService.refresh();
        verifyMigrationError(INDEX_NAME, "Rejecting tiering request as JVM Utilization is high on all [WARM] nodes");
                verifyWarmIndexSettings(indexName);
        MockInternalClusterInfoService.TestPlugin.class
    }
            listeners.forEach(l -> clusterService().removeListener(l));
        internalCluster().startWarmOnlyNodes(1);
    }
            );
            AcknowledgedResponse stuckResponse = client().admin().indices().execute(HotToWarmTierAction.INSTANCE, stuckRequest).actionGet();
                .indices()
                    .indices()
            flush(STUCK_INDEX);
        ensureYellow(STUCK_INDEX);
                    verifyWarmIndexSettings(index);
        refresh(INDEX_NAME);
        refresh(STUCK_INDEX);
            assertTrue(resp.isAcknowledged());
 *
    }
        }
                refresh(index);
        flush(INDEX_NAME);
        }
    private static final long TOTAL_SPACE_BYTES = new ByteSizeValue(1000, ByteSizeUnit.KB).getBytes();
                assertIndexShardLocation(indexName, true);
            flush("stuck-index");
            assertBusy(() -> {
            (discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, TOTAL_SPACE_BYTES, TOTAL_SPACE_BYTES)
import java.util.concurrent.TimeUnit;
import org.opensearch.monitor.fs.FsInfo;
                ShardRouting shard = state.routingTable().index(STUCK_INDEX).shard(0).primaryShard();
        Settings.Builder settingsBuilder = Settings.builder().put(buildDisabledAllocationSettings());
        if (indexExists(indexName)) {
                .actionGet();
                    indexDocCounts.get(index).longValue(),
    }
        refresh(INDEX_NAME);
                AcknowledgedResponse response = client().admin()
            client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value()
        internalCluster().startWarmOnlyNodes(2, settingsBuilder.build());
            for (String index : indices) {
            "1",
        try {
            assertFalse("Index should be deleted", state.metadata().hasIndex(INDEX_NAME));
            assertBusy(() -> {
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
        long expectedDocsAfterDelete = initialDocCount - deletedIds.size();
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
    protected Settings nodeSettings(int nodeOrdinal) {
            assertEquals(100, client().prepareSearch(STUCK_INDEX).setSize(0).get().getHits().getTotalHits().value());
import org.opensearch.cluster.ClusterStateListener;
            for (String index : indices) {
        String replicaNode = internalCluster().startDataOnlyNode(settingsBuilder.build());
        flush(INDEX_NAME);
        setupCluster(numberOfReplicas, null, null, clusterSettings);
        internalCluster().startDataOnlyNode(settingsBuilder.build());
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING;
                waitForReplication(index);
        clusterService().addListener(relocationListener);
            assertBusy(() -> {
                    } catch (AssertionError e) {
        Settings.Builder settingsBuilder = Settings.builder().put(buildDisabledAllocationSettings());
import java.util.Map;
            "Document count changed after migration",
        }
            for (String index : indices) {
            client().admin().indices().delete(new DeleteIndexRequest("stuck-index")).actionGet();
            flush(STUCK_INDEX);
            ensureGreen(indices);
        }
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
                verifyWarmIndexSettings("second-index");
            new ByteSizeValue(1000, ByteSizeUnit.BYTES)
        }
            .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "0b")
        // Ensure segment replication is fully caught up before triggering relocation
            AcknowledgedResponse resp = client().admin()
        if (extra != null) {
        logger.info("Testing migration with deletions, replicas: {}", numberOfReplicas);
                client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
                    assertIndexShardLocation(index, true);
        Exception e = expectThrows(
            ClusterState state = client().admin().cluster().prepareState().get().getState();
    }
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());
            flushAndRefresh(INDEX_NAME_2);
    }
                }, 30, TimeUnit.SECONDS);
            .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "10b")
            AcknowledgedResponse secondResponse = client().admin()
        clusterInfoService.setDiskUsageFunctionAndRefresh((discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, TOTAL_SPACE_BYTES, 850L));
        for (String index : indices) {
            .put(ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500));
import org.opensearch.transport.TransportService;
            ensureGreen(indices);
import static org.opensearch.storage.tiering.TieringTestUtils.buildEnabledAllocationSettings;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)
            AcknowledgedResponse resp = client().admin()
        assertEquals(
        String masterNodeId = internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());
        List<String> inFlightIndices = List.of(INDEX_NAME, "test-index-2");
        );
    public void testConcurrentMigrationWithStuckIndex() throws Exception {
    protected boolean ignoreExternalCluster() {
            .put(ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500))
        InternalClusterInfoService infoService = (InternalClusterInfoService) internalCluster().getInstance(
            .put(clusterSettings == null ? Settings.EMPTY : clusterSettings);
        ensureYellow(STUCK_INDEX);
        createTestIndex(INDEX_NAME, 1, 1);
        // Ensure segment replication is fully caught up before triggering relocation
        return Settings.builder()
            ClusterStateListener listener = new TieringTestUtils.MockTieringCompletionListener(
                migrationLatch,
        // Adding a delay to let the JVM and CPU stats get collected
        int numberOfReplicas = randomIntBetween(1, 2);
                assertIndexShardLocation("stuck-index", true);
        );
            refresh(STUCK_INDEX);
        setupCluster(1, settingsBuilder.build());
import org.opensearch.core.common.unit.ByteSizeUnit;
        verifyMigrationError(INDEX_NAME, "Cannot migrate index [" + INDEX_NAME + "] to WARM tier");
    protected void refreshClusterInfo() {
            clusterService().removeListener(listener);
        CountDownLatch migrationStarted = new CountDownLatch(1);
            assertIndexShardLocation(index, false);
            nodeId -> new NodeResourceUsageStats(nodeId, System.currentTimeMillis(), 99, 20, null, 0.0)
    protected void interceptCheckpointUpdates() {
            final IndexTieringRequest secondRequest = new IndexTieringRequest("warm", "test-index-2");
            .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "20b")
    }
                currentSettings.get(entry.getKey())
            internalCluster().restartNode(masterNodeId);
            }, 60, TimeUnit.SECONDS);
            }
        "testWarmMigrationWithAllNodesJVMUtilizationBreached",
        interceptCheckpointUpdates();
            }
        Settings.Builder settingsBuilder = Settings.builder().put(buildDisabledAllocationSettings());
                ShardRouting shard = state.routingTable().index(STUCK_INDEX).shard(0).primaryShard();
        try {
        for (int i = 0; i < 5; i++) {
import org.opensearch.node.Node;
import org.opensearch.test.transport.MockTransportService;
        setupCluster(1);
            final IndexTieringRequest request = new IndexTieringRequest("warm", indexName);
            assertTrue("Hot to Warm migration timed out", latch.await(MIGRATION_TIMEOUT_SECONDS, TimeUnit.SECONDS));
                ClusterState state = client().admin().cluster().prepareState().get().getState();
        );
import org.opensearch.cluster.InternalClusterInfoService;
                .prepareGetSettings("test-replica-0to1")
        refresh(STUCK_INDEX);
        }
            internalCluster().getClusterManagerName()
    protected void setupCluster(int numberOfReplicas, String lowDiskWaterMark, String dataToFileCacheRatio) {
    public void testWarmMigrationReplicaCountFrom2To1() throws Exception {
        client().admin().indices().delete(new DeleteIndexRequest("test-index-2")).actionGet();
        for (String index : indices) {
import org.opensearch.common.util.FeatureFlags;
                }
        assertBusy(() -> {
        };
                assertIndexShardLocation(STUCK_INDEX, true);
            }, 60, TimeUnit.SECONDS);
    private static final int DEFAULT_TIMEOUT_SECONDS = 30;
            .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "50b")
            }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        TEST_SPECIFIC_CACHE_SIZES.put("testWarmMigrationWithLargeTieringIndicesQueue", new ByteSizeValue(300, ByteSizeUnit.BYTES));
import java.util.Collection;
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());
                verifyWarmIndexSettings("stuck-index");
        migrateToWarm("test-replica-0to1");
        client().admin().indices().execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", INDEX_NAME)).actionGet();
                .execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", STUCK_INDEX))
    }
        Settings disabledSettings = buildDisabledAllocationSettings();
        setupCluster(1, buildDisabledAllocationSettings());
            }
        for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
        try {
public class HotToWarmTieringServiceIT extends RemoteStoreBaseIntegTestCase {
import org.opensearch.cluster.routing.IndexRoutingTable;
            assertBusy(() -> {
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
                assertFalse("Shard should not be relocating", shardRouting.relocating());
        Map<String, Long> indexStats = indexData(randomIntBetween(1, 3), true, INDEX_NAME);
                (handler, request, channel, task) -> {
    protected Settings featureFlagSettings() {
        for (String index : inFlightIndices) {
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
            .put(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), dataToFileCacheRatio != null ? Long.parseLong(dataToFileCacheRatio) : 5.0)
                for (String index : indices) {
            ensureStableCluster(6);
    private static final int MIGRATION_TIMEOUT_SECONDS = 30;
    private List<String> deleteRandomDocuments(String indexName, int count) {
    public void testHotToWarmMigrationWithData() throws Exception {
                .execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("WARM", "test-index-3"))
            .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "0b")
        Map<String, Long> indexDocCounts = new HashMap<>();
            );
    }
            waitForReplication("stuck-index");
                .indices()
import org.opensearch.cluster.ClusterState;
        createTestIndex(INDEX_NAME, 1, 1);
    public void testMultipleIndicesHotToWarmMigration() throws Exception {
    }
        client().admin().indices().delete(new DeleteIndexRequest("test-index-3")).actionGet();
    public void testHotToWarmMigrationWithIndexDeletion() throws Exception {
            } else {
        try {
        }
                assertTrue(response.isAcknowledged());
        assertThat(e.getMessage(), containsString(expectedErrorMessage));
                .actionGet();
            indexBulk(INDEX_NAME_2, 5000);
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
        } finally {
            assertEquals(100, client().prepareSearch(STUCK_INDEX).setSize(0).get().getHits().getTotalHits().value());
        flushAndRefresh(INDEX_NAME_2);
    protected MockInternalClusterInfoService getMockInternalClusterInfoService() {
            String assignedNodeId = shardRouting.currentNodeId();
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 230L);
                .indices()
        "testWarmMigrationWithAllNodesWaterMarkBreachedWithExistingTieredIndices",
        for (SearchHit hit : searchResponse.getHits()) {
                assertFalse("Shard should not be relocating", shard.relocating());
            for (String index : indices) {
            .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), lowDiskWaterMark != null ? lowDiskWaterMark : "10b")
                }
        final String[] indices = new String[] { "test-1", "test-2", "test-3" };
                if (isRelocating) {
    protected void setupCluster(int numberOfReplicas, Settings clusterSettings) {
import org.opensearch.action.DocWriteResponse;
                assertFalse("Shard should not be on warm node", assignedNode.getRoles().contains(DiscoveryNodeRole.WARM_ROLE));
            assertBusy(() -> {
                assertIndexShardLocation(STUCK_INDEX, true);
        internalCluster().startDataOnlyNodes(2, settingsBuilder.build());
                .actionGet();
        }
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
        } finally {
        SearchResponse searchResponse = client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).setSize(count).get();
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
            .put(buildDisabledAllocationSettings())
    public void testWarmMigrationForInvalidIndex() throws Exception {
import java.util.HashMap;
        internalCluster().startWarmOnlyNodes(1, settingsBuilder.build());
                .actionGet();
            }
        Settings.Builder settingsBuilder = Settings.builder()
            if (event.state().routingTable().hasIndex(INDEX_NAME)) {
        "testWarmMigrationWithAllNodesWaterMarkBreached",
import org.opensearch.cluster.metadata.IndexMetadata;
            assertBusy(() -> {
            waitForReplication(STUCK_INDEX);
            waitForReplication(index);
    public void testHotToWarmMigrationDuringQuorumLoss() throws Exception {
        );
                assertIndexShardLocation(STUCK_INDEX, false);
            }
                ShardRouting shard = state.routingTable().index(STUCK_INDEX).shard(0).primaryShard();
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
        final String STUCK_INDEX = "stuck-index";
        migrateToWarm("test-replica");
        try {
        ClusterState state = client().admin().cluster().prepareState().get().getState();
                .execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", STUCK_INDEX))
        );
                client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
            client().admin().indices().delete(new DeleteIndexRequest(STUCK_INDEX)).actionGet();
                    try {
            .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "100b")
        MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
        TieringTestUtils.safeSleep(6000);
        List<String> deletedIds = new ArrayList<>();
    public void testWarmMigrationWithAllNodesWaterMarkBreachedWithExistingTieredIndices() throws Exception {
        MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
    }
            assertTrue(response.isAcknowledged());
                nodeName
                .get()
                    }
        createTestIndex("test-index-2", 1, 1);
            }
        interceptCheckpointUpdates();
    }
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
        clusterInfoService.setNodeResourceUsageFunctionAndRefresh(
            .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "150b")
        clusterService().addListener(event -> {
import org.opensearch.common.unit.TimeValue;
            DiscoveryNode assignedNode = state.nodes().get(assignedNodeId);
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildDisabledAllocationSettings()).get();
        for (Map.Entry<String, Object> entry : expectedSettings.entrySet()) {
                assertBusy(() -> {
            .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "10b")
            // Trigger migration again — should get ack (idempotent)
    protected void setupCluster(int numberOfReplicas) {
        try {
                ClusterState state = client().admin().cluster().prepareState().get().getState();
                assertIndexShardLocation(STUCK_INDEX, true);
            assertBusy(() -> {
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
        interceptCheckpointUpdates();
import org.opensearch.indices.replication.SegmentReplicationSourceService;
        );
        assertTrue(resp.isAcknowledged());
            AcknowledgedResponse secondResponse = client().admin()
                .filter(node -> node.getRoles().contains(DiscoveryNodeRole.DATA_ROLE))
            assertTrue(stuckResponse.isAcknowledged());
        indexBulk(INDEX_NAME, 100);
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
            String docId = hit.getId();
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());
        return false;
                assertIndexShardLocation("second-index", true);
        assertIndexShardLocation(INDEX_NAME, false);
        }
                verifyWarmIndexSettings(INDEX_NAME);
                .indices()
        setupCluster(1);
            client().admin().indices().delete(new DeleteIndexRequest(STUCK_INDEX)).actionGet();
     */
            assertBusy(() -> {
            }, 30, TimeUnit.SECONDS);
                DiscoveryNode primaryNode = state.nodes().get(primaryShard.currentNodeId());
            }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
            }, 30, TimeUnit.SECONDS);
            createTestIndex(index, 1, 1);
            .build();
        ClusterStateListener relocationListener = event -> {
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING;
            assertBusy(() -> {
        createIndex(indexName, indexSettings);
        IndexRoutingTable indexRoutingTable = state.routingTable().index(indexName);
            indexBulk(INDEX_NAME, 100);
 */
            }
            assertTrue(response.isAcknowledged());
        indexBulk(STUCK_INDEX, 100);
        Settings.Builder settingsBuilder = Settings.builder()
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
                boolean isRelocating = event.state().routingTable().allShards(indexName).stream().anyMatch(ShardRouting::relocating);
                for (String index : indices) {
        setupCluster(numberOfReplicas, null, null);
            client().admin().indices().delete(new DeleteIndexRequest("test-index-2")).actionGet();
    protected void verifyMigrationError(String indexName, String expectedErrorMessage) {
                assertTrue("Primary should be assigned", primaryShard.assignedToNode());
            }
                assertTrue("Primary should be on warm node", primaryNode.getRoles().contains(DiscoveryNodeRole.WARM_ROLE));
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
    public void testHotToWarmMigrationWithDeletedDocumentSuccess() throws Exception {
                flush(index);
        ensureGreen("stuck-index", "second-index");
            assertTrue(secondResponse.isAcknowledged());
            .put(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 1.0);
    public void testWarmMigrationWithAllNodesJVMUtilizationBreached() {
        CountDownLatch latch = new CountDownLatch(1);
            () -> client().admin()
                "Incorrect value for setting: " + entry.getKey(),
    public void testWarmMigrationReplicaCountFrom0To1() throws Exception {
            indexName,
            }
        interceptCheckpointUpdates();
    protected void createTestIndex(String indexName, int numberOfShards, int numberOfReplicas) {
        );
        client().admin().indices().delete(new DeleteIndexRequest("test-index-2")).actionGet();
import java.util.concurrent.CountDownLatch;
                assertEquals(
                .prepareGetSettings("test-replica-0to1")
    }
        }
    public void testMigrationWithStuckIndexAndPrimaryShardDataNodeBounceWithReplicas() throws Exception {
        String testName = getTestName();
            client().admin().indices().delete(new DeleteIndexRequest("test-index-3")).actionGet();
                if (isRelocating) migrationStarted.countDown();
        verifyMigrationError(INDEX_NAME, "since we don't have enough space on all warm nodes");
                indexDocCounts.put(index, 100L);
    }
                assertTrue("Shard should be on warm node", assignedNode.getRoles().contains(DiscoveryNodeRole.WARM_ROLE));
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 50L);
            clusterService().addListener(listener);
    public void testWarmMigrationWithoutClusterInfoMockForJVMUtilization() throws Exception {
    }
        } finally {
                assertFalse("Shard should not be relocating", shardRouting.relocating());
        } finally {
    }
        ensureGreen();
        migrateToWarm(INDEX_NAME_2);
        // Ensure segment replication is fully caught up before triggering relocation
                assertIndexShardLocation(INDEX_NAME, true);
                assertBusy(() -> {
    public void testHotToWarmMigrationWithMasterNodeFailure() throws Exception {
import org.opensearch.cluster.node.DiscoveryNode;
            client().admin().indices().execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", index)).actionGet();
            IndexModule.TieringState.HOT_TO_WARM.toString()
        return Settings.builder().put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true).build();
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());
                ShardRouting shardRouting = state.routingTable().index(INDEX_NAME).shard(0).primaryShard();
        Settings.Builder settingsBuilder = Settings.builder()
            }, 60, TimeUnit.SECONDS);
        int numberOfReplicas = randomIntBetween(0, 1);
                }
                verifyWarmIndexSettings(STUCK_INDEX);
                index,
            assertTrue(resp.isAcknowledged());
                ClusterState state = client().admin().cluster().prepareState().get().getState();
        createTestIndex(INDEX_NAME, 1, 1);
import org.opensearch.action.search.SearchResponse;
            TieringTestUtils.safeSleep(4000);
        ensureGreen(indices);
        internalCluster().startClusterManagerOnlyNode();
            .put("cluster.tiering.max_concurrent_hot_to_warm_requests", 2);
                .indices()
        Class<? extends Plugin> extra = TEST_SPECIFIC_CUSTOM_CLUSTER_INFO.get(testName);
import org.opensearch.cluster.routing.ShardRouting;
            .put(disabledSettings);
    public void testMigrationWithStuckIndexAndReplicaShardDataNodeBounce() throws Exception {
        final String STUCK_INDEX = "stuck-index";
    }
                assertFalse("Shard should not be relocating", shard.relocating());
            .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "0b")
import org.opensearch.test.OpenSearchIntegTestCase;
        }
            waitForReplication("second-index");
    );
import java.util.ArrayList;
            final IndexTieringRequest stuckRequest = new IndexTieringRequest("warm", INDEX_NAME);
                .actionGet()
                .execute(HotToWarmTierAction.INSTANCE, secondRequest)
                assertIndexShardLocation(INDEX_NAME, false);
import java.util.stream.Collectors;
            client().admin()
        int numberOfShards = randomIntBetween(1, 2);
            OpenSearchRejectedExecutionException.class,
import org.opensearch.cluster.MockInternalClusterInfoService;
     * See: https://github.com/opensearch-project/OpenSearch/issues/3923
            flush(index);
            for (String index : indices) {
    }
            assertTrue(secondResponse.isAcknowledged());
        Settings.Builder settingsBuilder = Settings.builder()
import static org.hamcrest.Matchers.containsString;
     * Intercepts the UPDATE_VISIBLE_CHECKPOINT transport action on all nodes to gracefully handle
        } finally {
        interceptCheckpointUpdates();
                    verifyWarmIndexSettings(index);
        } finally {
        Settings.Builder settingsBuilder = Settings.builder()
        createTestIndex(INDEX_NAME_2, 1, 1);
        setupCluster(1);
                    assertIndexShardLocation(index, false);
        Settings.Builder settingsBuilder = Settings.builder()
            .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "0b")
        internalCluster().startDataOnlyNodes(numberOfReplicas + 1, settingsBuilder.build());
            listeners.forEach(l -> clusterService().removeListener(l));
                    ShardRouting shard = state.routingTable().index(index).shard(0).primaryShard();
            MockTransportService mockTransportService = (MockTransportService) internalCluster().getInstance(
        flush(INDEX_NAME);
                ClusterState state = client().admin().cluster().prepareState().get().getState();
        indexBulk(STUCK_INDEX, 100);
                continue;
        ByteSizeValue cacheSize = TEST_SPECIFIC_CACHE_SIZES.getOrDefault(testName, new ByteSizeValue(1, ByteSizeUnit.GB));
        refresh(STUCK_INDEX);
        assertEquals(
            AcknowledgedResponse response = client().admin().indices().execute(HotToWarmTierAction.INSTANCE, request).actionGet();
    }
        MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
                flush(index);
                }, 30, TimeUnit.SECONDS);
    public void testWarmMigrationForExistingMigratingIndex() throws Exception {
        verifyMigrationError("test-index-2", "since we don't have enough space on all warm nodes");
                    verifyWarmIndexSettings(index);
                createTestIndex(index, 1, 1);
        setupCluster(1);
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
            flush(index);
            }, 60, TimeUnit.SECONDS);
        refreshClusterInfo();
            }
        String testName = getTestName();
import org.opensearch.storage.action.tiering.IndexTieringRequest;
 * The OpenSearch Contributors require contributions made to
            latch,
        createTestIndex(STUCK_INDEX, 1, 1);
        try {
    public void testBulkOnWarmIndexWithFileCacheEvictionHappeningAlways() throws Exception {
        assertTrue("Migration didn't start", migrationStarted.await(MIGRATION_TIMEOUT_SECONDS, TimeUnit.SECONDS));
                .execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", index))
                .getSetting("test-replica-0to1", IndexMetadata.SETTING_NUMBER_OF_REPLICAS)
            "2",
            assertBusy(() -> {
            assertEquals(100, client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value());
        setupCluster(1);
        refreshClusterInfo();
                    client().prepareSearch(index).setSize(0).get().getHits().getTotalHits().value()
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());
            flush(STUCK_INDEX);
        createTestIndex("test-replica-0to1", 1, 0);
    }
    }
        );
import org.opensearch.test.InternalTestCluster;
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNode));
    public void testWarmMigrationForAlreadyMigratedIndex() throws Exception {
                .prepareGetSettings("test-replica")
            assertBusy(() -> {
        }
    protected static final String INDEX_NAME = "h2w-test-idx-1";
            }, 30, TimeUnit.SECONDS);
import org.opensearch.index.query.QueryBuilders;
        refreshClusterInfo();
    }
        internalCluster().startWarmOnlyNodes(2, settingsBuilder.build());
        internalCluster().startWarmOnlyNodes(2, settingsBuilder.build());
     * the known race condition where a checkpoint update arrives during relocation handoff.
        client().admin().indices().delete(new DeleteIndexRequest("test-replica")).actionGet();
            for (String index : indices) {
                .stream()
            TieringTestUtils.safeSleep(5000);
    protected static final String INDEX_NAME_2 = "h2w-test-idx-2";
    protected static final Map<String, Class<? extends Plugin>> TEST_SPECIFIC_CUSTOM_CLUSTER_INFO = Map.of(
                ensureGreen(STUCK_INDEX);
                index,
    protected void setupCluster(int numberOfReplicas, String lowDiskWaterMark, String dataToFileCacheRatio, Settings clusterSettings) {
                    migrationStarted.countDown();
        CountDownLatch migrationStarted = new CountDownLatch(1);
                .get()
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
        internalCluster().startWarmOnlyNodes(2, settingsBuilder.build());
    @Override
        setupCluster(numberOfReplicas);
        String[] indices = new String[] { "test-1", "test-2", "test-3" };
        TEST_SPECIFIC_CACHE_SIZES.put("testWarmMigrationWithAllNodesWaterMarkBreached", new ByteSizeValue(100, ByteSizeUnit.BYTES));
    }
        migrateToWarm(INDEX_NAME);
        } finally {
            .indices()
 * SPDX-License-Identifier: Apache-2.0
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
        createTestIndex(INDEX_NAME, 1, numberOfReplicas);
        List<ClusterStateListener> listeners = new ArrayList<>();
        long initialDocCount = indexStats.get(TOTAL_OPERATIONS);
                .execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", STUCK_INDEX))
        internalCluster().startWarmOnlyNodes(2, settingsBuilder.build());
    /**
    @Override
                    assertIndexShardLocation(index, true);
    public void testHotToWarmMigrationBasic() throws Exception {
    protected static FsInfo.Path setDiskUsage(FsInfo.Path original, long totalBytes, long freeBytes) {
                    assertIndexShardLocation(index, true);
        }
        interceptCheckpointUpdates();
        internalCluster().startClusterManagerOnlyNode(settingsBuilder.build());
            refresh(INDEX_NAME);
                    .execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", index))
            "1",
                .indices()
        try {
                .indices()
                }
                        handler.messageReceived(request, channel, task);
                    verifyWarmIndexSettings(index);
                .getSetting("test-replica-0to1", IndexMetadata.SETTING_NUMBER_OF_REPLICAS)
            expectedDocsAfterDelete,
        return true;
        try {
    }
        clusterInfoService.setDiskUsageFunctionAndRefresh(
        refreshClusterInfo();
            }
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
    static {
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
import org.opensearch.node.NodeResourceUsageStats;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards)
            AcknowledgedResponse resp = client().admin()
                .actionGet();
        }
                ShardRouting primaryShard = state.routingTable().index(INDEX_NAME).shard(0).primaryShard();
            internalCluster().stopCurrentClusterManagerNode();
            for (String index : indices) {
            for (String index : indices) {
            assertTrue(resp.isAcknowledged());
import org.opensearch.cluster.ClusterInfoService;
            AcknowledgedResponse response = client().admin().indices().execute(HotToWarmTierAction.INSTANCE, request).actionGet();
            assertEquals(DocWriteResponse.Result.DELETED, client().prepareDelete(indexName, docId).get().getResult());
            assertBusy(() -> {
            AcknowledgedResponse stuckResponse = client().admin().indices().execute(HotToWarmTierAction.INSTANCE, stuckRequest).actionGet();
        assertEquals(
                    .execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", index))
    }
            );
}
        String primaryNode = internalCluster().startDataOnlyNode(settingsBuilder.build());
        List<String> deletedIds = deleteRandomDocuments(INDEX_NAME, 2);
                SegmentReplicationSourceService.Actions.UPDATE_VISIBLE_CHECKPOINT,
            .put(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 1);
    public void testHotToWarmMigrationWithUnassignedReplica() throws Exception {
            client().admin().indices().execute(HotToWarmTierAction.INSTANCE, new IndexTieringRequest("warm", "second-index")).actionGet();
            if (event.state().routingTable().hasIndex(indexName)) {
        }
                .getSetting("test-replica", IndexMetadata.SETTING_NUMBER_OF_REPLICAS)
        createTestIndex("test-index-3", 1, 1);
        );
        migrateToWarm(INDEX_NAME);
                .getSetting("test-replica", IndexMetadata.SETTING_NUMBER_OF_REPLICAS)
    }
            );
    protected static void assertIndexShardLocation(String indexName, boolean onWarmNodes) {
    protected CountDownLatch waitForMigrationToStart(String indexName) {
            "testWarmMigrationWithAllNodesWaterMarkBreachedWithExistingTieredIndices",
    }
                assertIndexShardLocation(STUCK_INDEX, false);
        waitForReplication(INDEX_NAME);
                ShardRouting shardRouting = state.routingTable().index(INDEX_NAME).shard(0).primaryShard();
        createTestIndex(INDEX_NAME, numberOfShards, numberOfReplicas);
        );
                IndexModule.TieringState.HOT_TO_WARM.toString()
    }
            .put(ResourceTrackerSettings.GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(5000))
    protected void verifyWarmIndexSettings(String indexName) {
                .get()
                .map(DiscoveryNode::getName)
                verifyWarmIndexSettings(STUCK_INDEX);
            assertTrue(resp.isAcknowledged());
                verifyWarmIndexSettings(STUCK_INDEX);
        internalCluster().startDataOnlyNodes(1);
        migrateToWarm(INDEX_NAME);
    public void testWarmMigrationWithTieringQueueSizeBreached() throws Exception {
        assertTrue(exception.getMessage().contains("Failed to resolve index: invalid-index"));
/*
        ensureGreen(STUCK_INDEX);
            .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "10b")
                        channel.sendResponse(TransportResponse.Empty.INSTANCE);
                .values()
            assertEquals(
        assertIndexShardLocation(INDEX_NAME, false);
            .build();
            clusterService().addListener(listener);
            IllegalArgumentException.class,
    }
