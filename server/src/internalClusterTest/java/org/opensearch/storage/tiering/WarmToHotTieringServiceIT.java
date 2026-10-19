            warmDeletedIds.add(docId);
            assertBusy(() -> {
        // Setup cluster with normal allocation settings (don't disable initially)
        // Verify error when trying concurrent migration
            TieringTestUtils.safeSleep(4000);
        migrateToWarm(INDEX_NAME);
                internalCluster().restartNode(targetNode.getName());
            for (String index : indices) {
            initialDeletedIds.add(docId);
        createTestIndex(TEST_INDEX, 1, 1);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards)
                Map<String, Long> stats = indexData(1, false, index);
            // Wait for relocation to start and collect hot nodes
import org.opensearch.index.IndexModule;
            assertBusy(() -> {
            logger.info("--> Starting warm to hot migration for index: {}", TEST_INDEX);
                        .build()
        // Start cluster nodes with 1 master node for quorum
                logger.info("--> Index {} document count - expected: {}, actual: {}", index, expectedCount, actualCount);
                    }
        // Setup cluster with normal allocation settings (don't disable initially)
            migrateToWarm(INDEX_NAME);
            // Verify data consistency
                assertTrue("Target node should be a hot node", targetNode.getRoles().contains(DiscoveryNodeRole.DATA_ROLE));
        createIndex(indexName, indexSettings);
            MockTransportService mockTransportService = (MockTransportService) internalCluster().getInstance(
            }, 30, TimeUnit.SECONDS);
            }
            assertTrue(stuckResponse.isAcknowledged());
            internalCluster().getClusterManagerName()
        internalCluster().startClusterManagerOnlyNode();
                createTestIndex(index, 1, 1);
            for (String index : indices) {
        assertEquals("Document count mismatch after initial deletions", expectedDocsAfterInitialDelete, getDocCount(INDEX_NAME));
        // Cleanup
                assertIndexShardLocation(INDEX_NAME, false);
        // Verify no error when trying concurrent migration
                }, 30, TimeUnit.SECONDS);
            clusterInfoService.setDiskUsageFunctionAndRefresh(
            }
            internalCluster().startDataOnlyNode();
        // Verify deleted documents remain deleted
        interceptCheckpointUpdates();
            AcknowledgedResponse response = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, request).actionGet();
                assertEquals("Document count mismatch for index " + index, expectedCount, actualCount);
    }
        int numberOfShards = randomIntBetween(1, 2);
        flush(INDEX_NAME);
            }, 30, TimeUnit.SECONDS);
    protected void verifyHotIndexSettings(String indexName) {
        ClusterStateListener h2wListener = new TieringTestUtils.MockTieringCompletionListener(
            assertTrue("Hot to Warm migration timed out", h2wLatch.await(MIGRATION_TIMEOUT_SECONDS, TimeUnit.SECONDS));
                w2hLatch,
            // Verify data consistency
        assertEquals("Document count mismatch in warm tier", totalExpectedDocs, getDocCount(INDEX_NAME));
        final String TEST_INDEX = "test-index";
                ensureYellow(INDEX_NAME);
            () -> client().admin().indices().execute(WarmToHotTierAction.INSTANCE, tieringRequest).actionGet()
        );
            ShardRouting shardRouting = shardRoutingTable.primaryShard();
        for (String index : indices) {
            assertBusy(() -> {
        setupCluster(1);
            }, 60, TimeUnit.SECONDS);
            // Drop any warm node and verify index is in yellow state now.
        // Setup cluster with controlled allocation
        long originalDocCount = indexStats.get(TOTAL_OPERATIONS);
        );
import org.opensearch.cluster.MockInternalClusterInfoService;
                    .setSize((int) originalDocCount)
                assertEquals("Document count should match original", originalDocCount, searchResponse.getHits().getTotalHits().value());
                ensureGreen(TEST_INDEX);
    }
    }
                internalCluster().stopRandomNode(InternalTestCluster.nameFilter(targetNode.getName()));
            for (String index : warmToHotIndices) {
        Map<String, Long> indexStats = indexData(1, false, TEST_INDEX);
        // refreshClusterInfo();
                    assertIndexShardLocation(index, false);  // Should now be on hot nodes
        // Cleanup indices
    }
            MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
        } finally {
                ClusterState state = client().admin().cluster().prepareState().get().getState();
                    verifyHotIndexSettings(index);
            assertEquals(
                    verifyHotIndexSettings(index);
            assertBusy(() -> {
            clusterService().removeListener(h2wListener);
                assertIndexShardLocation(index, false);
        logger.info("--> Starting warm to hot migration test with all hot nodes restart during relocation");
        String warmNode = internalCluster().startWarmOnlyNodes(2).get(0);
                (discoveryNode, fsInfoPath) -> setDiskUsage(
        final String[] warmToHotIndices = new String[] { "warm-to-hot-1", "warm-to-hot-2" };
                logger.info("--> Restarting hot node: {}", nodeName);
        Class<? extends Plugin> extra = TEST_SPECIFIC_CUSTOM_CLUSTER_INFO.get(testName);
        setupCluster(1);  // Using fixed replica count for multiple indices
            createTestIndex(INDEX_NAME, 1, 1);
        long expectedDocsAfterInitialDelete = initialDocCount - initialDeletedIds.size();
                    .forEach(node -> hotNodeNames.add(node.getName()));
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 3000000L);
                assertIndexShardLocation(index, true);
        }
        interceptCheckpointUpdates();
        CountDownLatch w2hMigrationStarted = new CountDownLatch(1);
        final String INDEX_NAME = "test-index";
                migrateToWarm(index);
    public void testHotMigrationWithNoSpaceForLargestShard_YellowIndex() throws Exception {
 * The OpenSearch Contributors require contributions made to
        }
            // Restart all hot nodes
        try {
import org.opensearch.cluster.metadata.IndexMetadata;
            for (String index : indices) {
        // Cleanup
                assertTrue("Shard should be relocating", shardRouting.relocating());
        clusterInfoService.setDiskUsageFunctionAndRefresh(
import static org.opensearch.storage.tiering.TieringTestUtils.buildDisabledAllocationSettings;
    }
            );
        }
import org.opensearch.node.NodeResourceUsageStats;
        );
                // Verify warm-to-hot indices are now on hot nodes
            @Override
            // Stop current master node
                    assertIndexShardLocation(index, true); // Should be on warm nodes
        logger.info("--> Starting test for warm-to-hot migration with master node failed");
                assertTrue("Target node should be a hot node", targetNode.getRoles().contains(DiscoveryNodeRole.DATA_ROLE));
                )
        migrateToWarm(INDEX_NAME);
            );
        try {
            (discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, TOTAL_SPACE_BYTES, TOTAL_SPACE_BYTES)
            logger.info("--> Starting bidirectional migrations");
            final IndexTieringRequest request = new IndexTieringRequest("hot", TEST_INDEX);
        // Cleanup
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
            // Verify migration eventually completes
        // Start minimal cluster - one master, one hot node, one warm node
        assertBusy(() -> {
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildDisabledAllocationSettings()).get();
        Map<String, Long> indexStats = indexData(randomIntBetween(1, 3), true, INDEX_NAME);
            // Enable allocation to allow migrations to proceed
            for (String index : indices) {
        logger.info("--> Starting warm to hot migration test with hot node failed during relocation");
    protected static FsInfo.Path setDiskUsage(FsInfo.Path original, long totalBytes, long freeBytes) {
        }
            assertBusy(() -> {
            (discoveryNode, fsInfoPath) -> setDiskUsage(
        String testName = getTestName();
            logger.info("--> Enabling allocation to allow migrations to complete");
            for (String index : Stream.concat(Arrays.stream(hotToWarmIndices), Arrays.stream(warmToHotIndices)).toArray(String[]::new)) {
    public void testWarmToHotMigrationWithIndexDeletion() throws Exception {
                    ShardRouting shardRouting = state.routingTable().index(index).shard(0).primaryShard();
        } finally {
            "testHotMigrationWithNoSpaceForLargestShard_YellowIndex",
     * See: https://github.com/opensearch-project/OpenSearch/issues/3923
                (handler, request, channel, task) -> {
                new ByteSizeValue(600, ByteSizeUnit.BYTES).getBytes(),
        migrateToHot(INDEX_NAME);
            }, 60, TimeUnit.SECONDS);
        internalCluster().startWarmOnlyNodes(2);
            clusterService().addListener(h2wListener);
                    .filter(node -> node.getRoles().contains(DiscoveryNodeRole.DATA_ROLE))
                        .build()
import org.opensearch.transport.TransportService;
        internalCluster().startDataOnlyNodes(2);
        // Migrate back to hot
    }
        Map<String, Long> indexDocCounts = new HashMap<>();
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
        final String[] indices = new String[] { "test-1", "test-2" };
        long originalDocCount = indexStats.get(TOTAL_OPERATIONS);
            internalCluster().stopCurrentClusterManagerNode();
/*
import static org.opensearch.storage.common.tiering.TieringUtils.W2H_MAX_CONCURRENT_TIERING_REQUESTS_KEY;
        long initialDocCount = initialIndexStats.get(TOTAL_OPERATIONS);
        // Add listener to detect when shards start relocating
        setupCluster(numberOfReplicas);
                SegmentReplicationSourceService.Actions.UPDATE_VISIBLE_CHECKPOINT,
        plugins.add(MockTransportService.TestPlugin.class);
        // Try migrating again and verify error
            client().admin().indices().delete(new DeleteIndexRequest(TEST_INDEX)).actionGet();
        featureSettings.put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true);
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(settingsBuilder).get();
                createTestIndex(index, 1, 1);
                (discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, 1000, discoveryNode.getId().equals(hotNodeId) ? 1000 : 200)
import java.util.concurrent.CountDownLatch;
        }
            if (onWarmNodes) {
                flush(index);
                index,
            migrateToWarm(INDEX_NAME);
        Settings.Builder settingsBuilder = Settings.builder()
    }
            // Verify data consistency
        assertTrue("Hot to Warm migration timed out", h2wLatch.await(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS));
            // Enable full allocation to allow migration to complete
    }
import org.opensearch.test.InternalTestCluster;
        Map<String, Object> expectedSettings = TieringTestUtils.getExpectedHotIndexSettings();
        long additionalDocs = warmIndexStats.get(TOTAL_OPERATIONS);
        internalCluster().startDataOnlyNodes(2);  // hot nodes
    protected Settings featureFlagSettings() {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)
        flush(INDEX_NAME);
        SearchResponse deletedDocsSearch = client().prepareSearch(INDEX_NAME)
import org.opensearch.cluster.ClusterChangedEvent;
            AcknowledgedResponse response = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, request).actionGet();
            ensureYellow(INDEX_NAME);
            client().admin()
            );
        // Verify error when trying to migrate hot index to hot
                flush(index);
        } finally {
        } finally {
                refresh(index);
                }
        internalCluster().startClusterManagerOnlyNode();
            flush(INDEX_NAME);
    /*
        try {
        ensureGreen(INDEX_NAME);
        return true;
        // Start W2H migration for all indices
            }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
            logger.info("--> Cluster stabilized after master node failure");
        CountDownLatch w2hLatch = new CountDownLatch(1);
        Settings.Builder featureSettings = Settings.builder();
        internalCluster().startClusterManagerOnlyNode();
import org.opensearch.cluster.ClusterInfoService;
        int numberOfReplicas = randomIntBetween(0, 2);
            logger.info("--> Disabling allocation to block migrations");
            }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
    protected void assertIndexShardLocation(String indexName, boolean onWarmNodes) {
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
                TransportService.class,
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 230L);
        ensureGreen(INDEX_NAME);
                    ClusterState state = client().admin().cluster().prepareState().get().getState();
            logger.info("--> Restarting current master node");
            DiscoveryNode assignedNode = state.nodes().get(assignedNodeId);
                    boolean isRelocating = event.state().routingTable().allShards(INDEX_NAME).stream().anyMatch(ShardRouting::relocating);
            refresh(TEST_INDEX);
            createTestIndex(INDEX_NAME, 1, 2);
        );
        Exception e = expectThrows(
            logger.info("--> Enabling allocation to allow migrations to complete");
        w2hListeners.forEach(listener -> clusterService().removeListener(listener));
import org.opensearch.action.DocWriteResponse;
                assertTrue(response.isAcknowledged());
                    Settings.builder()
            ensureStableCluster(6); // Remaining nodes (2 master + 2 data + 2 warm)
     * the known race condition where a checkpoint update arrives during relocation handoff.
                String targetNodeId = shardRouting.relocatingNodeId();
        String hotNodeId = internalCluster().startDataOnlyNodes(2).get(0);
            // Move to warm tier first
        logger.info("Testing migration with document deletions, replicas: {}", numberOfReplicas);
            () -> client().admin().indices().execute(WarmToHotTierAction.INSTANCE, request).actionGet()
            verifyMigrationError(INDEX_NAME, "HOT", "since we don't have enough [HOT] capacity");
        } catch (Exception e) {
            // Control allocation speed
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
            indexDocCounts.put(INDEX_NAME, stats.get(TOTAL_OPERATIONS));
        createTestIndex(INDEX_NAME, numberOfShards, numberOfReplicas);
            // Cleanup
            // Verify index hasn't started relocation
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
            internalCluster().stopRandomWarmNode();
        try {
    @Override
            // Restart current master node
                        .put("cluster.routing.allocation.node_concurrent_recoveries", 2)
        migrateToWarm(INDEX_NAME);
    }
            logger.info("--> Starting warm to hot migration for all indices");
                assertFalse("Shard should not be on warm node ", assignedNode.getRoles().contains(DiscoveryNodeRole.WARM_ROLE));
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            for (String index : indices) {
        );
        try {
                final IndexTieringRequest request = new IndexTieringRequest("hot", index);
            clusterService().addListener(w2hListener);
            client().admin().indices().execute(WarmToHotTierAction.INSTANCE, hotRequest).actionGet();
                )
        final String[] indices = new String[] { "test-1", "test-2", "test-3" };
    is reconstructed properly
            logger.info("--> Enabling allocation to allow migrations to complete");
        }
    protected void migrateToWarm(String indexName) throws Exception {
            }, 30, TimeUnit.SECONDS);
            TieringTestUtils.safeSleep(5000);
            }
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
            // Delete index during migration
            client().admin()
    public void testConcurrentWarmToHotMigrationWithHotNodesFailure() throws Exception {
}
        clusterInfoService.setDiskUsageFunctionAndRefresh(
                verifyWarmIndexSettings(index);
        // First migrate to warm
            }
        // Wait for all W2H migrations to complete
        createTestIndex("test-index-3", 1, 1);
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), new ByteSizeValue(1, ByteSizeUnit.GB))
        // Create latch to track migration start
        // Create index and migrate it to warm first
                assertEquals("Document count mismatch for index " + index, expectedCount, actualCount);
        for (SearchHit hit : initialSearchResponse.getHits()) {
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
            w2hListeners.add(listener);
                client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
            for (String index : indices) {
    public void testHotMigrationWithNoNodesCapacity() throws Exception {
            // Enable allocation to allow migrations to proceed
import org.opensearch.cluster.ClusterState;
        flush(INDEX_NAME);
            for (String index : indices) {
import java.util.HashMap;
        clusterInfoService.setNodeResourceUsageFunctionAndRefresh(
            // Now disable allocation to control the timing
        Settings logsettings = Settings.builder().put("logger.org.opensearch.cluster.routing.allocation", "TRACE").build();
            logger.info("--> Created index {} with {} documents and 1 replica", INDEX_NAME, stats.get(TOTAL_OPERATIONS));
            }
        Settings currentSettings = internalCluster().clusterService().state().metadata().index(indexName).getSettings();
                Map<String, Long> stats = indexData(1, false, index);
    // Helper Methods
        List<ClusterStateListener> w2hListeners = new ArrayList<>();
        );
                    ClusterState state = client().admin().cluster().prepareState().get().getState();
    protected void verifyWarmIndexSettings(String indexName) {
        SearchResponse initialSearchResponse = client().prepareSearch(INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).setSize(2).get();
                for (String index : indices) {
                final IndexTieringRequest request = new IndexTieringRequest("hot", index);
    protected void verifyMigrationError(String indexName, String targetTier, String expectedErrorMessage) {
        // Cleanup
                logger.info("--> Created index {} with {} documents", index, stats.get(TOTAL_OPERATIONS));
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        ensureGreen(indexName);
        List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
        refresh(INDEX_NAME);
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
    }
            }
    protected long getDocCount(String indexName) {
                verifyHotIndexSettings(index);
        createTestIndex(INDEX_NAME, 1, 1);
        );
            // Wait for relocation to start
    }
                "Incorrect value for setting: " + entry.getKey(),
            ensureGreen(warmToHotIndices);
            // Drop any warm node and verify index is in yellow state now.
            .get();
        setupCluster(1);
            TieringTestUtils.safeSleep(5000);
            );
        // Verify doc count before hot migration
        setupCluster(numberOfReplicas, Settings.EMPTY);
            // Wait for cluster to stabilize with new master
                refresh(index);
    }
    }
        internalCluster().startDataOnlyNodes(Math.max(numberOfReplicas + 1, 2), clusterSettings);
            assertEquals(DocWriteResponse.Result.DELETED, client().prepareDelete(INDEX_NAME, docId).get().getResult());
            plugins.add(extra);
        TieringTestUtils.safeSleep(6000);
                new ByteSizeValue(1000, ByteSizeUnit.BYTES).getBytes()
        verifyMigrationError(INDEX_NAME, "hot", "Cannot migrate index [" + INDEX_NAME + "] to HOT tier");
            ensureYellow(INDEX_NAME);
            w2hLatch,
        TEST_SPECIFIC_CUSTOM_CLUSTER_INFO.put(
                SearchResponse searchResponse = client().prepareSearch(TEST_INDEX)
                    } catch (AssertionError e) {
import org.opensearch.monitor.fs.FsInfo;
        Settings indexSettings = Settings.builder()
        }
                logger.info("--> Created index {} with {} documents", index, stats.get(TOTAL_OPERATIONS));
                long actualCount = client().prepareSearch(index).setSize(0).get().getHits().getTotalHits().value();
        // Try migrating again and verify error
        migrateToWarm(TEST_INDEX);
        // Migrate to hot
    public void testHotMigrationWithoutClusterInfoMockForJVMUtilization() throws Exception {
        try {
        }
                AcknowledgedResponse response = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, request).actionGet();
        long expectedDocsAfterWarmDelete = expectedDocsAfterInitialDelete - warmDeletedIds.size();
                client().admin()
        );
                ShardRouting shardRouting = state.routingTable().index(index).shard(0).primaryShard();
            verifyMigrationError(INDEX_NAME, "HOT", "");
            clusterService().addListener(relocationListener);
        setupCluster(1);
import org.opensearch.common.unit.TimeValue;
            assertBusy(() -> {
        String warmNode = internalCluster().startWarmOnlyNodes(2).get(0);
            h2wLatch,
    protected Settings nodeSettings(int nodeOrdinal) {
                    .cluster()
            client().admin().indices().execute(WarmToHotTierAction.INSTANCE, request).actionGet();
                ClusterState state = client().admin().cluster().prepareState().get().getState();
import org.opensearch.index.query.QueryBuilders;
        int numberOfReplicas = randomIntBetween(0, 2);
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("Document count changed after W2H migration", totalExpectedDocs, getDocCount(INDEX_NAME));
            // Wait for relocation to start
        migrateToHot(INDEX_NAME);
            // Verify data consistency
    public void testConcurrentWarmToHotMigrationWithAllHotNodesRestarts() throws Exception {
            final IndexTieringRequest request = new IndexTieringRequest("hot", indexName);
                nodeName
            }
        final String INDEX_NAME = "test-index";
            String docId = hit.getId();
        logger.info("--> Starting warm to hot migration test with hot node restarts during relocation");
import org.opensearch.test.transport.MockTransportService;
        // Migrate to warm
            "testHotMigrationWithNoSpaceForLargestShard",
        );
                        new RestoreRemoteStoreRequest().indices(index).restoreAllShards(false),
import org.opensearch.storage.action.tiering.HotToWarmTierAction;
    private static final int MIGRATION_TIMEOUT_SECONDS = 30;
            for (String index : indices) {
                indexDocCounts.put(index, stats.get(TOTAL_OPERATIONS));
import org.opensearch.cluster.ClusterStateListener;
            IndexModule.TieringState.HOT_TO_WARM.toString()
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(1)).get();
    @Override
        for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
package org.opensearch.storage.tiering;
            // Wait for cluster to stabilize with new master
    public void testWarmToHotMigrationWithMasterNodeFailure() throws Exception {
            for (String index : indices) {
    }
                .setTransientSettings(
import org.opensearch.storage.action.tiering.IndexTieringRequest;
                indexDocCounts.put(index, stats.get(TOTAL_OPERATIONS));
            clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 500L);
        );
        for (String index : indices) {
                    .get();
        // Delete more documents while in warm tier
        TEST_SPECIFIC_CUSTOM_CLUSTER_INFO.put(
        refresh(INDEX_NAME);
    protected void setupCluster(int numberOfReplicas, Settings clusterSettings) {
        }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        }
            IndexModule.TieringState.WARM_TO_HOT.toString()
                assertTrue("Shard should be relocating", shardRouting.relocating());
    protected static final Map<String, Class<? extends Plugin>> TEST_SPECIFIC_CUSTOM_CLUSTER_INFO = new HashMap<>();
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
                Map<String, Long> stats = indexData(1, false, index);
        // Start minimal cluster - one master, one hot node, one warm node
        migrateToWarm(INDEX_NAME);
                migrateToWarm(index);
                assertTrue("Shard should be relocating", shardRouting.relocating());
            }
        int numberOfShards = randomIntBetween(1, 2);
            // Sleep to ensure migration requests are processed
        setupCluster(1);
                    .stream()
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(1)).get();
        }
                .cluster()
        interceptCheckpointUpdates();
        return plugins;
                createTestIndex(index, 1, 1);
                assertBusy(() -> {
        // Create index and migrate it to warm first
            refresh(TEST_INDEX);
        clusterInfoService.setDiskUsageFunctionAndRefresh(
                // Get target node ID
            MockInternalClusterInfoService.TestPlugin.class
            assertTrue(response.isAcknowledged());
    @Override
        ensureGreen(TEST_INDEX);
        // Disable allocation to block migrations
                }, 30, TimeUnit.SECONDS);
                    verifyHotIndexSettings(index);
        createTestIndex(TEST_INDEX, 1, 1);
                    assertFalse("Shard should not be relocating", shardRouting.relocating());
    }
        assertEquals("Document count mismatch after warm tier deletions", expectedDocsAfterWarmDelete, getDocCount(INDEX_NAME));
                createTestIndex(index, 1, 1);
            assertTrue(response.isAcknowledged());
            ensureGreen(INDEX_NAME);
                long expectedCount = indexDocCounts.get(index);
        Map<String, Long> warmIndexStats = indexData(randomIntBetween(1, 3), true, INDEX_NAME);
        // Verify error when trying concurrent migration
            (discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, TOTAL_SPACE_BYTES, TOTAL_SPACE_BYTES)
                ensureGreen(TEST_INDEX);
                ClusterState state = client().admin().cluster().prepareState().get().getState();
            "testWarmMigrationWithAllNodesJVMUtilizationBreached",
                continue;
        ensureGreen(TEST_INDEX);
    }
        MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
                Map<String, Long> stats = indexData(1, false, index);
            String assignedNodeId = shardRouting.currentNodeId();
        internalCluster().startWarmOnlyNodes(2);  // warm nodes
            clusterService().addListener(listener);
            for (String index : hotToWarmIndices) {
        final String TEST_INDEX = "test-index";
        // Minimum 2 hot nodes needed because warm migration sets replicas to 1,
        Map<String, Long> initialIndexStats = indexData(randomIntBetween(1, 3), true, INDEX_NAME);
            assertBusy(() -> {
        List<String> inFlightTieringIndices = List.of(INDEX_NAME, "test-index-2");
import org.opensearch.indices.replication.SegmentReplicationSourceService;
        // First migrate to warm tier
            // Initiate both hot-to-warm and warm-to-hot migrations
        } finally {
    protected final String INDEX_NAME = "h2w-test-idx-1";
            ClusterStateListener listener = new TieringTestUtils.MockTieringCompletionListener(
     * Intercepts the UPDATE_VISIBLE_CHECKPOINT transport action on all nodes to gracefully handle
                ShardRouting shardRouting = state.routingTable().index(TEST_INDEX).shard(0).primaryShard();
    public void testMultipleIndicesWarmToHotMigration() throws Exception {
            // Verify data consistency
            assertTrue(response.isAcknowledged());
        } finally {
    public void testHotMigrationForAlreadyMigratingIndex() throws Exception {
        migrateToWarm(TEST_INDEX);
                assertIndexShardLocation(indexName, true);
                    try {
            indexBulk(INDEX_NAME, 100);
            }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
                ShardRouting shardRouting = state.routingTable().index(TEST_INDEX).shard(0).primaryShard();
            // Although there is only 1 node to accomodate the largest shard, validation should fail as the Index has 1 replica
            internalCluster().stopRandomWarmNode();
    protected void refreshClusterInfo() {
        );
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
            logger.info("--> Enabling allocation to allow migrations to complete");
            }, 30, TimeUnit.SECONDS);
            logger.info("--> Stopping current master node");
                QueryBuilders.idsQuery().addIds(Stream.concat(initialDeletedIds.stream(), warmDeletedIds.stream()).toArray(String[]::new))
        migrateToWarm(INDEX_NAME);
            assertBusy(() -> {
                if (event.state().routingTable().hasIndex(INDEX_NAME)) {
    }
            AcknowledgedResponse stuckResponse = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, stuckRequest).actionGet();
                // Collect all hot nodes
            assertTrue(response.isAcknowledged());
            // Trigger warm to hot migration
            }
import java.util.List;
            client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
        flush(INDEX_NAME);
import org.opensearch.core.common.unit.ByteSizeUnit;
            final IndexTieringRequest hotRequest = new IndexTieringRequest("hot", INDEX_NAME);
        migrateToHot(INDEX_NAME);
            logger.info("--> Starting warm to hot migration for all indices");
                DiscoveryNode targetNode = state.nodes().get(targetNodeId);
            }
            h2wListeners.add(listener);
            }
import java.util.stream.Stream;
    protected void setupCluster(int numberOfReplicas) {
        migrateToHot(INDEX_NAME);
                assertIndexShardLocation(TEST_INDEX, false); // Should be on hot nodes
                        .put("cluster.routing.allocation.node_concurrent_outgoing_recoveries", 1)
            createTestIndex(index, 1, 1);  // Using fixed shard and replica count
                        .put("cluster.routing.allocation.node_concurrent_outgoing_recoveries", 2)
        // Clean up W2H listeners
            AcknowledgedResponse response = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, request).actionGet();
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
            assertBusy(() -> {
            .build();
            for (String index : Stream.concat(Arrays.stream(hotToWarmIndices), Arrays.stream(warmToHotIndices)).toArray(String[]::new)) {
                        handler.messageReceived(request, channel, task);
            assertEquals(100, client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value());
        migrateToWarm(INDEX_NAME);
        migrateToWarm("test-index-2");
        );
            final IndexTieringRequest request = new IndexTieringRequest("warm", indexName);
        }
                indexDocCounts.put(index, stats.get(TOTAL_OPERATIONS));
            assertEquals(DocWriteResponse.Result.DELETED, client().prepareDelete(INDEX_NAME, docId).get().getResult());
                internalCluster().restartNode(nodeName, new InternalTestCluster.RestartCallback());
                long actualCount = client().prepareSearch(index).setSize(0).get().getHits().getTotalHits().value();
        // Migrate to warm
        assertEquals("Initial document count mismatch", initialDocCount, getDocCount(INDEX_NAME));
            ensureYellow(INDEX_NAME);
            indexDocCounts.put(INDEX_NAME, stats.get(TOTAL_OPERATIONS));
                final IndexTieringRequest request = new IndexTieringRequest("warm", index);
    }
import org.opensearch.action.support.PlainActionFuture;
        Map<String, Long> indexDocCounts = new HashMap<>();
        migrateToWarm(TEST_INDEX);
    protected void migrateToHot(String indexName) throws Exception {
                long expectedCount = indexDocCounts.get(index);
            logger.info("starting hot to warm tiering for index: {}", indexName);
                .setTransientSettings(
                assertIndexShardLocation(indexName, false);
        createTestIndex("test-index-2", 1, 1);
            TieringTestUtils.safeSleep(5000);
            }
        internalCluster().startDataOnlyNodes(3);
        final String[] hotToWarmIndices = new String[] { "hot-to-warm-1", "hot-to-warm-2" };
                ShardRouting shardRouting = state.routingTable().index(TEST_INDEX).shard(0).primaryShard();
    public void testHotToWarmAndWarmToHotMigrationWithAndWithoutReplica() throws Exception {
        // Cleanup
            for (String index : indices) {
            // Create index with 1 primary and 1 replica on warm node
import static org.hamcrest.Matchers.containsString;
            assertBusy(() -> {
        setupCluster(numberOfReplicas);
                        PlainActionFuture.newFuture()
import org.opensearch.cluster.node.DiscoveryNode;
                logger.info("--> Index {} document count - expected: {}, actual: {}", index, expectedCount, actualCount);
        // Setup and create index
        // Setup cluster
                }
        // Setup and create index
                }, 30, TimeUnit.SECONDS);
import java.util.concurrent.TimeUnit;
        // First migrate to warm
    }
        try {
    protected void interceptCheckpointUpdates() {
            }
                assertTrue("Should have at least one hot node", !hotNodeNames.isEmpty());
    }
import org.opensearch.common.util.FeatureFlags;
            logger.info("--> Created index {} with {} documents and 1 replica", INDEX_NAME, stats.get(TOTAL_OPERATIONS));
            ensureYellow(INDEX_NAME);
        return (MockInternalClusterInfoService) internalCluster().getCurrentClusterManagerNodeInstance(ClusterInfoService.class);
import org.opensearch.node.Node;
    protected boolean ignoreExternalCluster() {
                    new ByteSizeValue(500, ByteSizeUnit.BYTES).getBytes()
        }
                assertTrue(response.isAcknowledged());
        String[] indices = new String[] { "test-1", "test-2", "test-3", "test-4" };
import org.opensearch.core.common.unit.ByteSizeValue;
    static {
            // Create and populate all indices
        verifyMigrationError(INDEX_NAME, "hot", "since we don't have [HOT] node with free space to fit it's largest shard");
            // Start warm to hot migration
            // Verify migrations complete correctly
        try {
                .cluster()
            for (String index : indices) {
        } finally {
import org.opensearch.cluster.routing.IndexRoutingTable;
            assertBusy(() -> {
            );
            logger.info("--> Cluster stabilized after master node failure");
        verifyMigrationError(INDEX_NAME, "HOT", "Rejecting tiering request as JVM Utilization is high on all [HOT] nodes");
                index,
            for (String index : indices) {
        };
        ClusterState state = client().admin().cluster().prepareState().get().getState();
            // Cleanup
            assertTrue("Warm to Hot migration timed out", w2hLatch.await(MIGRATION_TIMEOUT_SECONDS, TimeUnit.SECONDS));
    public void testWarmMigrationWithAllNodesJVMUtilizationBreached() throws Exception {
                }
        migrateToWarm(INDEX_NAME);
            // Move all indices to warm tier first
                for (String index : indices) {
                currentSettings.get(entry.getKey())
                assertEquals("Document count mismatch for index " + index, expectedCount, actualCount);
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
import org.opensearch.cluster.routing.ShardRouting;
                logger.info("--> Restarting hot node {} during relocation", targetNode.getName());
            }
            // Move all indices to warm tier first
 * compatible open source license.
                assertFalse("Index should be deleted", state.metadata().hasIndex(INDEX_NAME));
        int numberOfReplicas = randomIntBetween(1, 2);
        // Clean up H2W listeners
        setupCluster(1);
            clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 900L);
        return Settings.builder()
            assertHitCount(client().prepareSearch(TEST_INDEX).setSize(0).get(), originalDocCount);
                assertBusy(() -> {
            // Trigger warm to hot migration
            client().admin().indices().delete(new DeleteIndexRequest(TEST_INDEX)).actionGet();
            assertTrue("Warm to Hot migration didn't start", w2hMigrationStarted.await(MIGRATION_TIMEOUT_SECONDS, TimeUnit.SECONDS));
        Map<String, Object> expectedSettings = TieringTestUtils.getExpectedWarmIndexSettings();
            }, 60, TimeUnit.SECONDS);
        refresh(INDEX_NAME);
        try {
            }
import org.opensearch.plugins.Plugin;
            refresh(TEST_INDEX);
            );
            // Verify migration eventually completes
                    ShardRouting shardRouting = state.routingTable().index(index).shard(0).primaryShard();
        assertThrows(
        assertIndexShardLocation(INDEX_NAME, false);
                AcknowledgedResponse response = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, request).actionGet();
        // Start cluster nodes
                DiscoveryNode targetNode = state.nodes().get(targetNodeId);
                // Move these indices to warm initially
    }
        SearchResponse warmSearchResponse = client().prepareSearch(INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).setSize(2).get();
                verifyHotIndexSettings(TEST_INDEX);
            } else {
import org.opensearch.cluster.InternalClusterInfoService;
        setupCluster(2);  // Start with 2 hot nodes
        internalCluster().startWarmOnlyNodes(2);
            .put(super.nodeSettings(nodeOrdinal))
    This test creates a domain with one master node, creates a quorum loss and checks if the tieringContext
                    assertFalse("Shard should not be relocating", shardRouting.relocating());
            ensureYellow(INDEX_NAME);
            }, 30, TimeUnit.SECONDS);
            // Start migration back to hot for all indices
        try {
            final IndexTieringRequest stuckRequest = new IndexTieringRequest("hot", index);
            }
public class WarmToHotTieringServiceIT extends RemoteStoreBaseIntegTestCase {
                    verifyWarmIndexSettings(index);
        logger.info("Testing hot to warm migration with {} replicas and {} shards", numberOfReplicas, numberOfShards);
            .put(ResourceTrackerSettings.GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(5000))
        ClusterStateListener w2hListener = new TieringTestUtils.MockTieringCompletionListener(
                state.nodes()
            .build();
        ensureGreen(TEST_INDEX);
        createTestIndex(INDEX_NAME, 1, numberOfReplicas);
        return new FsInfo.Path(original.getPath(), original.getMount(), totalBytes, freeBytes, freeBytes);
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
                h2wLatch,
        // Verify all indices moved to warm nodes
            refresh(INDEX_NAME);
    public void testHotMigrationWithTieringQueueSizeBreached() throws Exception {
        // Delete some documents before warm migration
        Map<String, Long> indexDocCounts = new HashMap<>();
                client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
        // Migrate to warm
            }
            ensureGreen(indices);
            migrateToWarm(INDEX_NAME);
            .put(ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500));
    // Helper method to verify index shard location
        List<ClusterStateListener> h2wListeners = new ArrayList<>();
        CountDownLatch w2hLatch = new CountDownLatch(indices.length);
            indexName,
        logger.info("Testing W2H migration with index deletion, replicas: {}, shards: {}", numberOfReplicas, numberOfShards);
        Map<String, Long> indexStats = indexData(1, false, TEST_INDEX);
        String masterNodeId = internalCluster().startClusterManagerOnlyNode();
            assertEquals(
                .prepareUpdateSettings()
        MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
            Map<String, Long> stats = indexData(1, false, INDEX_NAME);
import static org.opensearch.storage.tiering.TieringTestUtils.buildEnabledAllocationSettings;
                indexDocCounts.put(index, stats.get(TOTAL_OPERATIONS));
            // Enable allocation to allow migrations to proceed
        ensureGreen(INDEX_NAME);
            final IndexTieringRequest request = new IndexTieringRequest("hot", TEST_INDEX);
        assertBusy(() -> {
        createTestIndex(INDEX_NAME, 1, 1);
            // Verify migration eventually completes
        interceptCheckpointUpdates();
                ClusterState state = client().admin().cluster().prepareState().get().getState();
        verifyMigrationError(INDEX_NAME, "hot", "since we don't have enough [" + "HOT" + "] capacity. Please add more");
                    .setQuery(QueryBuilders.matchAllQuery())
    public void testHotToWarmMigrationWithDeletedDocumentSuccess() throws Exception {
        createTestIndex(INDEX_NAME, 1, 1);
    }
        createTestIndex(INDEX_NAME, 1, 1);
        interceptCheckpointUpdates();
        ClusterStateListener relocationListener = new ClusterStateListener() {
            }
        }
                    }
            // Cleanup
            assertTrue(response.isAcknowledged());
        Settings.Builder settingsBuilder = Settings.builder()
import java.util.Arrays;
            // Wait for cluster to stabilize with new master
    If there is a quorum loss, restoration of indices metadata happens at a later event than the master-change.
            }
            logger.info("--> Stopping current master node");
import org.opensearch.search.SearchHit;
        // ResourceUsageCollector requires atleast below stats to be ready within a window to capture stats
        flush(INDEX_NAME);
        long originalDocCount = indexStats.get(TOTAL_OPERATIONS);
    public void testWarmToHotMigrationWithUnassignedReplica() throws Exception {
        List<String> initialDeletedIds = new ArrayList<>();
                assertBusy(() -> {
        migrateToHot(INDEX_NAME);
    }
                .get();
        Map<String, Long> indexDocCounts = new HashMap<>();
                    ShardRouting shardRouting = state.routingTable().index(index).shard(0).primaryShard();
        IndexTieringRequest tieringRequest = new IndexTieringRequest("WARM", "test-index-3");
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
        long totalExpectedDocs = initialDocCount + additionalDocs;
            }
        }
                    fsInfoPath,
            // Wait for migration to start
        AcknowledgedResponse hotResponse = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, hotRequest).actionGet();
                for (String index : warmToHotIndices) {
        internalCluster().startWarmOnlyNodes(2, clusterSettings);
        infoService.refresh();
        }
            List<String> hotNodeNames = new ArrayList<>();
        Map<String, Long> indexStats = indexData(1, false, TEST_INDEX);
            .put(W2H_MAX_CONCURRENT_TIERING_REQUESTS_KEY, 2);
                verifyWarmIndexSettings(indexName);
            // Disable allocation to block migrations
        createTestIndex(INDEX_NAME, 1, 1);
        }
    protected boolean addMockIndexStorePlugin() {
        // Setup and create index
        }
        // Start initial hot migration
        logger.info("Testing migration with replicas: {}, shards: {}", numberOfReplicas, numberOfShards);
    }
            Map<String, Long> stats = indexData(1, false, INDEX_NAME);
import java.util.Map;
            throw e;
                logger.info("--> Index {} document count - expected: {}, actual: {}", index, expectedCount, actualCount);
        setupCluster(numberOfReplicas);
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
        refresh(indexName);
        // Verify initial state and doc count
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            AcknowledgedResponse response = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, hotRequest).actionGet();
            clusterInfoService.setDiskUsageFunctionAndRefresh(
        for (Map.Entry<String, Object> entry : expectedSettings.entrySet()) {
            final IndexTieringRequest request = new IndexTieringRequest("hot", TEST_INDEX);
    }
            // Verify data consistency
    }
        // Start H2W migration for all indices
            AcknowledgedResponse response = client().admin().indices().execute(HotToWarmTierAction.INSTANCE, request).actionGet();
import org.opensearch.core.transport.TransportResponse;
    }
                final IndexTieringRequest request = new IndexTieringRequest("hot", index);
        } finally {
        internalCluster().startClusterManagerOnlyNode(clusterSettings);
    }
                        .put("cluster.routing.allocation.node_concurrent_recoveries", 1)
            }
        }
                "Incorrect value for setting: " + entry.getKey(),
                ClusterState state = client().admin().cluster().prepareState().get().getState();
    private static final int DEFAULT_TIMEOUT_SECONDS = 30;
        CountDownLatch h2wLatch = new CountDownLatch(indices.length);
    public void testHotMigrationWithNoSpaceForLargestShard() throws Exception {
                assertIndexShardLocation(index, true);
            for (String index : indices) {
        internalCluster().startWarmOnlyNodes(2);
            assertBusy(() -> {
        int numberOfShards = randomIntBetween(1, 2);
    }
        interceptCheckpointUpdates();
            for (String index : Stream.concat(Arrays.stream(hotToWarmIndices), Arrays.stream(warmToHotIndices)).toArray(String[]::new)) {
                assertTrue(response.isAcknowledged());
                }
        createTestIndex(INDEX_NAME, 1, 1);
        // Index initial documents
            AcknowledgedResponse response = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, request).actionGet();
                    .getNodes()
        // Verify initial state
        internalCluster().startClusterManagerOnlyNode();
        createTestIndex(INDEX_NAME, 1, 1);
                )
        ensureGreen(indices);
        setupCluster(1, settingsBuilder.build());
                verifyHotIndexSettings(INDEX_NAME);
            }, 60, TimeUnit.SECONDS);
        for (String nodeName : internalCluster().getNodeNames()) {
            // Enable full allocation to allow migration to complete
            )
        logger.info("--> Starting test for both migration with master node failure");
        internalCluster().startDataOnlyNodes(2);
        } finally {
            client().admin().indices().execute(HotToWarmTierAction.INSTANCE, request).actionGet();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                assertTrue(response.isAcknowledged());
    public void testConcurrentWarmToHotMigrationWithHotNodesRestarts() throws Exception {
                migrateToWarm(index);
        // Cleanup
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
            logger.info("--> Starting warm to hot migration for index: {}", TEST_INDEX);
        assertIndexShardLocation(INDEX_NAME, false);
                // Verify hot-to-warm indices are now on warm nodes
                        .put("cluster.routing.allocation.node_concurrent_incoming_recoveries", 2)
import org.opensearch.common.settings.Settings;
        } finally {
        assertTrue(hotResponse.isAcknowledged());
            client().admin().indices().delete(new DeleteIndexRequest(TEST_INDEX)).actionGet();
        // Verify doc count in warm tier
                assertFalse("Shard should not be relocating", shardRouting.relocating());
            ensureStableCluster(6); // Remaining nodes
        // Wait for all H2W migrations to complete
    */
        // Try migrating again and verify error
        }
                entry.getValue().toString(),
                AcknowledgedResponse response = client().admin().indices().execute(HotToWarmTierAction.INSTANCE, request).actionGet();
        // Verify final doc count
        setupCluster(numberOfReplicas);
        IndexRoutingTable indexRoutingTable = state.routingTable().index(indexName);
        // and W2H validator needs second-highest node capacity for replica placement
import java.util.ArrayList;
    protected void createTestIndex(String indexName, int numberOfShards, int numberOfReplicas) {
            )
    /**
                        w2hMigrationStarted.countDown();
            ensureGreen(INDEX_NAME);
        logger.info("--> Starting test for warm-to-hot migration during quorum loss");
            // Enable full allocation to allow migration to complete
            public void clusterChanged(ClusterChangedEvent event) {
import org.opensearch.storage.action.tiering.WarmToHotTierAction;
            // Verify migrations are stuck
                    if (isRelocating) {
            internalCluster().stopRandomWarmNode();
            internalCluster().stopCurrentClusterManagerNode();
            .setSize(initialDeletedIds.size() + warmDeletedIds.size())
    }
 * this file be licensed under the Apache-2.0 license or a
        TEST_SPECIFIC_CUSTOM_CLUSTER_INFO.put("testHotMigrationWithNoNodesCapacity", MockInternalClusterInfoService.TestPlugin.class);
        List<String> warmDeletedIds = new ArrayList<>();
                        channel.sendResponse(TransportResponse.Empty.INSTANCE);
        // First migrate to warm
                // Get target node ID
        final IndexTieringRequest hotRequest = new IndexTieringRequest("hot", INDEX_NAME);
            final IndexTieringRequest hotRequest = new IndexTieringRequest("hot", INDEX_NAME);
            refresh(indices);
        assertTrue("Warm to Hot migration timed out", w2hLatch.await(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS));
        // Setup and create index
                long expectedCount = indexDocCounts.get(index);
            // Trigger warm to hot migration
                    assertIndexShardLocation(index, false); // Should be on hot nodes
        TEST_SPECIFIC_CUSTOM_CLUSTER_INFO.put(
        setupCluster(1);
        int numberOfReplicas = randomIntBetween(1, 2);
            createTestIndex(INDEX_NAME, 1, 1);
            }
            for (String index : hotToWarmIndices) {
                logger.info("--> Stop hot node {} during relocation", targetNode.getName());
        setupCluster(1);
                verifyHotIndexSettings(indexName);
                    Settings.builder()
                }
        // Verify all indices moved back to hot nodes
            MockInternalClusterInfoService.TestPlugin.class
        MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
            logger.info("--> Restarting all hot nodes during relocation: {}", hotNodeNames);
            clusterService().removeListener(relocationListener);
        try {
        logger.info("--> Disabling allocation to block migrations");
            );
    }
    @Override
    public void testHotMigrationWithNoNodesCapacity_YellowIndex() throws Exception {
                    new ByteSizeValue(200, ByteSizeUnit.BYTES).getBytes(),
                    .restoreRemoteStore(
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
        assertEquals("Deleted documents reappeared after migration", 0, deletedDocsSearch.getHits().getTotalHits().value());
            MockInternalClusterInfoService.TestPlugin.class
            ensureGreen(indices);
        final IndexTieringRequest request = new IndexTieringRequest(targetTier, indexName);
            final IndexTieringRequest request = new IndexTieringRequest("warm", index);
        migrateToWarm(INDEX_NAME);
                }
            MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
        interceptCheckpointUpdates();
        return false;
        for (Map.Entry<String, Object> entry : expectedSettings.entrySet()) {
                .get();
            // Move to warm tier first
        createTestIndex(INDEX_NAME, numberOfShards, numberOfReplicas);
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildDisabledAllocationSettings()).get();
            final IndexTieringRequest request = new IndexTieringRequest("hot", index);
        migrateToHot(INDEX_NAME);
                refresh(index);
                        .put("cluster.routing.allocation.node_concurrent_incoming_recoveries", 1)
        CountDownLatch h2wLatch = new CountDownLatch(1);
            if (shardRouting.unassigned() && shardRouting.primary() == false || assignedNode == null) {
    }
            assertHitCount(client().prepareSearch(TEST_INDEX).setSize(0).get(), originalDocCount);
        createTestIndex(INDEX_NAME, numberOfShards, numberOfReplicas);
            MockInternalClusterInfoService.TestPlugin.class
            (nodeId -> new NodeResourceUsageStats(nodeId, System.currentTimeMillis(), 99, 20, null, 0.0))
    public void testWarmToHotMigrationDuringQuorumLoss() throws Exception {
            // Stop current master node
        createTestIndex(TEST_INDEX, 1, 1);
    }
        for (String index : indices) {
 *
            .put(ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500))
    protected MockInternalClusterInfoService getMockInternalClusterInfoService() {
        internalCluster().startClusterManagerOnlyNode();
        SearchResponse response = client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).setSize(0).get();
        Map<String, Long> indexDocCounts = new HashMap<>();
        // First migrate all indices to warm
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
            // Verify migrations are stuck due to disabled allocation
            mockTransportService.addRequestHandlingBehavior(
            OpenSearchRejectedExecutionException.class,
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        InternalClusterInfoService infoService = (InternalClusterInfoService) internalCluster().getInstance(
            // disable allocation to block migrations.
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
     */
                verifyHotIndexSettings(TEST_INDEX);
        ensureGreen(INDEX_NAME);
                .prepareUpdateSettings()
        // Create index and migrate it to warm first
        final String TEST_INDEX = "test-index";
        // Create multiple indices
                IndexModule.TieringState.WARM_TO_HOT.toString()
        // Index initial documents
            // disable allocation to block migrations.
    public void testHotMigrationForAlreadyHotIndex() throws Exception {
                String targetNodeId = shardRouting.relocatingNodeId();
            logger.info("--> Enabling allocation to allow migrations to complete");
import org.opensearch.cluster.node.DiscoveryNodeRole;
    private static final long TOTAL_SPACE_BYTES = new ByteSizeValue(1000, ByteSizeUnit.KB).getBytes();
        long initialDocCount = indexStats.get(TOTAL_OPERATIONS);
                AcknowledgedResponse response = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, request).actionGet();
        migrateToWarm("test-index-3");
                assertTrue("Shard should be on node warm node ", assignedNode.getRoles().contains(DiscoveryNodeRole.WARM_ROLE));
            }
            }, 60, TimeUnit.SECONDS);
                    ClusterState state = client().admin().cluster().prepareState().get().getState();
            "testHotMigrationWithNoNodesCapacity_YellowIndex",
            assertBusy(() -> {
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 900L);
        internalCluster().startClusterManagerOnlyNode();
            // Although there is only 1 node to accomodate the largest shard, validation should fail as the Index is Yellow
            ensureStableCluster(5); // Remaining nodes (1 master + 2 data + 2 warm)
            // Verify migrations are stuck due to disabled allocation
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
            );
            ClusterStateListener listener = new TieringTestUtils.MockTieringCompletionListener(
            indexName,
            logger.info("--> Cluster stabilized after master node failure");
        } finally {
        refresh(INDEX_NAME);
        assertIndexShardLocation(INDEX_NAME, false);
            // Start migration back to hot for all indices
        // Adding a delay to let the JVM and CPU stats get collected
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
            for (String index : indices) {
    }
            }
        // Verify initial state and doc count
        migrateToWarm(INDEX_NAME);
        }
                for (String index : hotToWarmIndices) {
            assertBusy(() -> {
            clusterService().removeListener(w2hListener);
    }
    public void testHotToWarmAndWarmToHotMigrationWithAndWithoutReplicaWithData() throws Exception {
        }
                    assertIndexShardLocation(index, true);  // Should still be on warm nodes
        );
            // Verify migrations complete on remaining master
            String docId = hit.getId();
                flush(index);
        if (extra != null) {
            clusterService().addListener(listener);
import org.opensearch.action.search.SearchResponse;
        return featureSettings.build();
                    );
    }
    @Override
            assertBusy(() -> {
        for (String index : inFlightTieringIndices) {
    public void testBothTypeMigrationWithMasterFailure() throws Exception {
                    .values()
            }, 60, TimeUnit.SECONDS);
        try {
            for (String index : warmToHotIndices) {
            // Sleep to ensure migration requests are processed
        migrateToWarm(INDEX_NAME);
                long actualCount = client().prepareSearch(index).setSize(0).get().getHits().getTotalHits().value();
            IllegalArgumentException.class,
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
        // Now migrate all indices back to hot
    }
 */
        internalCluster().startClusterManagerOnlyNode();
                client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
            // Create indices and add data
                // continue if replica shard is unassigned.
                verifyHotIndexSettings(TEST_INDEX);
        }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
                assertIndexShardLocation(TEST_INDEX, false); // Should be on hot nodes
        setupCluster(1);
                    assertFalse("Shard should not be relocating", shardRouting.relocating());
            // Create index with 1 primary and 1 replica on warm node
                fsInfoPath,
        for (SearchHit hit : warmSearchResponse.getHits()) {
        }
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
import java.util.Collection;
            .setQuery(
            // Create indices and add data
        }
        migrateToWarm(INDEX_NAME);
        for (String index : indices) {
                    assertIndexShardLocation(index, true);  // Should still be on warm nodes
            internalCluster().restartNode(masterNodeId);
            .put(buildDisabledAllocationSettings())
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildDisabledAllocationSettings()).get();
            // Verify migrations complete on remaining master
            assertTrue(response.isAcknowledged());
    }
            for (String index : indices) {
    }
        internalCluster().startClusterManagerOnlyNode();
        } finally {
import org.opensearch.test.OpenSearchIntegTestCase;
        // Start cluster nodes with 3 master nodes for quorum
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
                assertIndexShardLocation(TEST_INDEX, false); // Should be on hot nodes
            ClusterInfoService.class,
        TEST_SPECIFIC_CUSTOM_CLUSTER_INFO.put(
            ensureGreen(hotToWarmIndices);
        return response.getHits().getTotalHits().value();
        Settings currentSettings = internalCluster().clusterService().state().metadata().index(indexName).getSettings();
    }
        internalCluster().startDataOnlyNodes(2);
        }
                entry.getValue().toString(),
            // Now disable allocation to control the timing
        refresh(INDEX_NAME);
    }
        // Migrate back to hot
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
                    assertIndexShardLocation(index, false);  // Should now be on hot nodes
        h2wListeners.forEach(listener -> clusterService().removeListener(listener));
        client().admin().cluster().prepareUpdateSettings().setPersistentSettings(logsettings).get();
            }
                currentSettings.get(entry.getKey())
            for (String nodeName : hotNodeNames) {
                IndexModule.TieringState.HOT_TO_WARM.toString()
            // Verify index is deleted
            }
                ensureGreen(TEST_INDEX);
        assertThat(e.getMessage(), containsString(expectedErrorMessage));
            }, 30, TimeUnit.SECONDS);
            refresh(indices);
        // Index more documents while in warm tier
        internalCluster().startClusterManagerOnlyNode();
            logger.info("--> Starting warm to hot migration for index: {}", TEST_INDEX);
