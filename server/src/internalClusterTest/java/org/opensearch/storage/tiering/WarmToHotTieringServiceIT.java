            "testWarmMigrationWithAllNodesJVMUtilizationBreached",  
            @Override
        migrateToHot(INDEX_NAME);  
            logger.info("--> Starting warm to hot migration for index: {}", TEST_INDEX);
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
                    ShardRouting shardRouting = state.routingTable().index(index).shard(0).primaryShard();  
                Map<String, Long> stats = indexData(1, false, index);
                long actualCount = client().prepareSearch(index).setSize(0).get().getHits().getTotalHits().value();
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
        Settings indexSettings = Settings.builder()
        );
        return new FsInfo.Path(original.getPath(), original.getMount(), totalBytes, freeBytes, freeBytes);
                assertFalse("Shard should not be relocating", shardRouting.relocating());
        logger.info("--> Starting test for both migration with master node failure");
        refresh(INDEX_NAME);  
            clusterService().removeListener(h2wListener);
        try {  
            // Verify migration eventually completes
        clusterInfoService.setDiskUsageFunctionAndRefresh(
        // Start H2W migration for all indices
                )
            assertTrue(stuckResponse.isAcknowledged());
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
        // Verify all indices moved back to hot nodes
        );
            );
     * See: https://github.com/opensearch-project/OpenSearch/issues/3923  
    }
        } finally {
        Class<? extends Plugin> extra = TEST_SPECIFIC_CUSTOM_CLUSTER_INFO.get(testName);
        // Try migrating again and verify error
    protected void verifyMigrationError(String indexName, String targetTier, String expectedErrorMessage) {
        int numberOfReplicas = randomIntBetween(1, 2);  
        int numberOfShards = randomIntBetween(1, 2);
                        .put("cluster.routing.allocation.node_concurrent_recoveries", 2)
        internalCluster().startDataOnlyNodes(2);  
        clusterInfoService.setDiskUsageFunctionAndRefresh(  
        // First migrate to warm
                verifyHotIndexSettings(TEST_INDEX);  
        ensureGreen(INDEX_NAME);
            clusterInfoService.setDiskUsageFunctionAndRefresh(
                SegmentReplicationSourceService.Actions.UPDATE_VISIBLE_CHECKPOINT,  
            assertTrue("Warm to Hot migration timed out", w2hLatch.await(MIGRATION_TIMEOUT_SECONDS, TimeUnit.SECONDS));
                logger.info("--> Index {} document count - expected: {}, actual: {}", index, expectedCount, actualCount);  
            }, 60, TimeUnit.SECONDS);  
            for (String index : indices) {
        // Create index and migrate it to warm first
                index,
            assertBusy(() -> {
    }  
import org.opensearch.cluster.ClusterState;
import org.opensearch.test.OpenSearchIntegTestCase;  
            .get();
            // Verify index is deleted
        logger.info("Testing W2H migration with index deletion, replicas: {}, shards: {}", numberOfReplicas, numberOfShards);
        return false;
            MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
                assertTrue("Shard should be relocating", shardRouting.relocating());
            indexName,
    }
                verifyHotIndexSettings(TEST_INDEX);  
                    .values()
            }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);  
                IndexModule.TieringState.HOT_TO_WARM.toString()  
            // Move to warm tier first
        long originalDocCount = indexStats.get(TOTAL_OPERATIONS);  
        logger.info("--> Starting warm to hot migration test with all hot nodes restart during relocation");
                .get();  
            }, 30, TimeUnit.SECONDS);
    protected void createTestIndex(String indexName, int numberOfShards, int numberOfReplicas) {  
            // Verify migrations are stuck
    }
            // disable allocation to block migrations.  
        // First migrate to warm tier
import static org.opensearch.storage.common.tiering.TieringUtils.W2H_MAX_CONCURRENT_TIERING_REQUESTS_KEY;
        final String[] indices = new String[] { "test-1", "test-2" };  
        // Cleanup
        // Migrate to warm  
                verifyWarmIndexSettings(indexName);  
                assertTrue("Shard should be relocating", shardRouting.relocating());
            assertTrue(response.isAcknowledged());
    protected final String INDEX_NAME = "h2w-test-idx-1";  
        // Cleanup
            clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 500L);
        createTestIndex("test-index-2", 1, 1);
        assertEquals("Initial document count mismatch", initialDocCount, getDocCount(INDEX_NAME));
        List<String> inFlightTieringIndices = List.of(INDEX_NAME, "test-index-2");  
 *
        client().admin().cluster().prepareUpdateSettings().setPersistentSettings(logsettings).get();
    protected void migrateToWarm(String indexName) throws Exception {
        // and W2H validator needs second-highest node capacity for replica placement
            final IndexTieringRequest hotRequest = new IndexTieringRequest("hot", INDEX_NAME);
        migrateToWarm(INDEX_NAME);  
import org.opensearch.cluster.node.DiscoveryNode;
                "Incorrect value for setting: " + entry.getKey(),
        internalCluster().startClusterManagerOnlyNode();
        try {
                verifyHotIndexSettings(INDEX_NAME);  
            }
            internalCluster().restartNode(masterNodeId);
            MockInternalClusterInfoService.TestPlugin.class  
                indexDocCounts.put(index, stats.get(TOTAL_OPERATIONS));  
            // Enable full allocation to allow migration to complete
        plugins.add(MockTransportService.TestPlugin.class);
        ensureGreen(indices);
                        .put("cluster.routing.allocation.node_concurrent_incoming_recoveries", 1)
            // Verify migrations are stuck due to disabled allocation
    }
        }
        // First migrate all indices to warm  
                AcknowledgedResponse response = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, request).actionGet();
        final String[] indices = new String[] { "test-1", "test-2", "test-3" };
                    .restoreRemoteStore(  
    public void testHotMigrationWithTieringQueueSizeBreached() throws Exception {
            )  
            // Verify migrations complete correctly  
                        channel.sendResponse(TransportResponse.Empty.INSTANCE);
    }
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        try {  
import java.util.stream.Stream;  
                // Verify warm-to-hot indices are now on hot nodes
            mockTransportService.addRequestHandlingBehavior(
        // Verify all indices moved to warm nodes  
                client().admin()
            client().admin().indices().delete(new DeleteIndexRequest(TEST_INDEX)).actionGet();
            // Trigger warm to hot migration  
        Settings.Builder settingsBuilder = Settings.builder()  
            .setSize(initialDeletedIds.size() + warmDeletedIds.size())
        CountDownLatch h2wLatch = new CountDownLatch(indices.length);
            indexDocCounts.put(INDEX_NAME, stats.get(TOTAL_OPERATIONS));
            logger.info("--> Cluster stabilized after master node failure");
                assertBusy(() -> {
                        .build()  
            }  
                    Settings.builder()  
        final String TEST_INDEX = "test-index";
        // Start minimal cluster - one master, one hot node, one warm node  
        TEST_SPECIFIC_CUSTOM_CLUSTER_INFO.put("testHotMigrationWithNoNodesCapacity", MockInternalClusterInfoService.TestPlugin.class);
import org.opensearch.core.common.unit.ByteSizeValue;
            }  
    public void testWarmToHotMigrationWithIndexDeletion() throws Exception {
            // Restart current master node  
    }
                    new ByteSizeValue(200, ByteSizeUnit.BYTES).getBytes(),  
                assertFalse("Index should be deleted", state.metadata().hasIndex(INDEX_NAME));
                    Settings.builder()
        }
import org.opensearch.plugins.Plugin;
            logger.info("--> Restarting all hot nodes during relocation: {}", hotNodeNames);
        // Verify deleted documents remain deleted
            // Move to warm tier first
        int numberOfShards = randomIntBetween(1, 2);  
            // Drop any warm node and verify index is in yellow state now.
                    new ByteSizeValue(500, ByteSizeUnit.BYTES).getBytes()
                        .put("cluster.routing.allocation.node_concurrent_outgoing_recoveries", 1)
import org.opensearch.search.SearchHit;
                (discoveryNode, fsInfoPath) -> setDiskUsage(
        assertThrows(  
            // Wait for cluster to stabilize with new master
        );
                logger.info("--> Restarting hot node {} during relocation", targetNode.getName());  
            // Create indices and add data
    @Override  
        logger.info("--> Starting test for warm-to-hot migration during quorum loss");  
        Map<String, Long> initialIndexStats = indexData(randomIntBetween(1, 3), true, INDEX_NAME);  
            );
            plugins.add(extra);
            refresh(TEST_INDEX);  
            // Wait for cluster to stabilize with new master
                    ClusterState state = client().admin().cluster().prepareState().get().getState();  
                assertTrue(response.isAcknowledged());
            ClusterStateListener listener = new TieringTestUtils.MockTieringCompletionListener(
        } finally {
        Map<String, Long> indexDocCounts = new HashMap<>();
        Exception e = expectThrows(  
        createTestIndex(INDEX_NAME, 1, 1);  
        createTestIndex(INDEX_NAME, numberOfShards, numberOfReplicas);
                ensureGreen(TEST_INDEX);
            flush(INDEX_NAME);  
        Map<String, Long> indexStats = indexData(1, false, TEST_INDEX);
import org.opensearch.common.unit.TimeValue;
            TieringTestUtils.safeSleep(5000);  
            for (String index : indices) {
                refresh(index);
                flush(index);  
        // Cleanup  
                .prepareUpdateSettings()
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(1)).get();
            for (String index : indices) {  
                assertTrue("Shard should be on node warm node ", assignedNode.getRoles().contains(DiscoveryNodeRole.WARM_ROLE));  
                    ClusterState state = client().admin().cluster().prepareState().get().getState();  
import org.opensearch.cluster.metadata.IndexMetadata;  
        SearchResponse initialSearchResponse = client().prepareSearch(INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).setSize(2).get();  
                        .build()
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 900L);  
            // Wait for migration to start
                createTestIndex(index, 1, 1);
        migrateToHot(INDEX_NAME);  
            assertBusy(() -> {
            }  
        // Minimum 2 hot nodes needed because warm migration sets replicas to 1,
            .put(ResourceTrackerSettings.GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(5000))
                )
                ShardRouting shardRouting = state.routingTable().index(TEST_INDEX).shard(0).primaryShard();
            assertBusy(() -> {  
                assertTrue(response.isAcknowledged());
            // Initiate both hot-to-warm and warm-to-hot migrations  
import org.opensearch.core.common.unit.ByteSizeUnit;  
            }  
                logger.info("--> Created index {} with {} documents", index, stats.get(TOTAL_OPERATIONS));  
            TieringTestUtils.safeSleep(5000);  
        );
import org.opensearch.node.NodeResourceUsageStats;  
import java.util.Collection;  
        // Setup and create index  
        for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
            refresh(TEST_INDEX);
                ShardRouting shardRouting = state.routingTable().index(TEST_INDEX).shard(0).primaryShard();  
    }  
    }
    }  
        ensureGreen(indexName);
            migrateToWarm(INDEX_NAME);  
            }  
        internalCluster().startDataOnlyNodes(2);
        // Delete some documents before warm migration
                DiscoveryNode targetNode = state.nodes().get(targetNodeId);  
                indexDocCounts.put(index, stats.get(TOTAL_OPERATIONS));  
        final String INDEX_NAME = "test-index";  
    }
                migrateToWarm(index);  
        // Wait for all W2H migrations to complete
    /**  
            // Now disable allocation to control the timing  
        assertIndexShardLocation(INDEX_NAME, false);
            }
        // Verify error when trying concurrent migration
        internalCluster().startWarmOnlyNodes(2);
                for (String index : hotToWarmIndices) {  
            IllegalArgumentException.class,
                    assertIndexShardLocation(index, true); // Should be on warm nodes
        // Verify initial state and doc count  
        Settings.Builder settingsBuilder = Settings.builder()  
                assertIndexShardLocation(indexName, false);
import org.opensearch.index.IndexModule;
        migrateToWarm(TEST_INDEX);  
    protected Settings featureFlagSettings() {  
            createTestIndex(INDEX_NAME, 1, 2);  
        ensureGreen(INDEX_NAME);  
    // Helper Methods  
                refresh(index);
                logger.info("--> Restarting hot node: {}", nodeName);  
        interceptCheckpointUpdates();
        );
                        new RestoreRemoteStoreRequest().indices(index).restoreAllShards(false),
        };
        assertTrue("Warm to Hot migration timed out", w2hLatch.await(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS));  
        TEST_SPECIFIC_CUSTOM_CLUSTER_INFO.put(
        assertTrue(hotResponse.isAcknowledged());
            .put(W2H_MAX_CONCURRENT_TIERING_REQUESTS_KEY, 2);
    public void testHotMigrationWithNoNodesCapacity() throws Exception {
        Map<String, Long> indexStats = indexData(1, false, TEST_INDEX);
    This test creates a domain with one master node, creates a quorum loss and checks if the tieringContext
        }
            ensureYellow(INDEX_NAME);
        }  
            // Verify migration eventually completes
        migrateToHot(INDEX_NAME);
            .put(ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500))
                ensureGreen(TEST_INDEX);  
        migrateToWarm(INDEX_NAME);  
                }
            assertBusy(() -> {
        }
                    assertFalse("Shard should not be relocating", shardRouting.relocating());
        long totalExpectedDocs = initialDocCount + additionalDocs;  
        // Verify final doc count
            }, 30, TimeUnit.SECONDS);
                    }  
            (discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, TOTAL_SPACE_BYTES, TOTAL_SPACE_BYTES)
        migrateToWarm(INDEX_NAME);
            // Verify data consistency  
            // Enable full allocation to allow migration to complete
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();  
            assertTrue("Hot to Warm migration timed out", h2wLatch.await(MIGRATION_TIMEOUT_SECONDS, TimeUnit.SECONDS));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)  
                (discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, 1000, discoveryNode.getId().equals(hotNodeId) ? 1000 : 200)  
        logger.info("Testing migration with replicas: {}, shards: {}", numberOfReplicas, numberOfShards);
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();  
            assertTrue("Warm to Hot migration didn't start", w2hMigrationStarted.await(MIGRATION_TIMEOUT_SECONDS, TimeUnit.SECONDS));  
        Map<String, Long> indexDocCounts = new HashMap<>();
            AcknowledgedResponse response = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, hotRequest).actionGet();
    public void testHotMigrationWithNoNodesCapacity_YellowIndex() throws Exception {
        // Cleanup indices
        }  
            ensureGreen(indices);
        flush(INDEX_NAME);
        internalCluster().startClusterManagerOnlyNode();
        flush(INDEX_NAME);
        flush(INDEX_NAME);  
                assertIndexShardLocation(TEST_INDEX, false); // Should be on hot nodes
                ensureGreen(TEST_INDEX);
                logger.info("--> Created index {} with {} documents", index, stats.get(TOTAL_OPERATIONS));
        clusterInfoService.setDiskUsageFunctionAndRefresh(  
        setupCluster(1);  
import java.util.Map;  
    public void testHotMigrationWithoutClusterInfoMockForJVMUtilization() throws Exception {  
        migrateToWarm("test-index-2");  
        setupCluster(numberOfReplicas);  
            }  
package org.opensearch.storage.tiering;
import java.util.ArrayList;
                    assertIndexShardLocation(index, true);  // Should still be on warm nodes  
                assertTrue("Shard should be relocating", shardRouting.relocating());
                    boolean isRelocating = event.state().routingTable().allShards(INDEX_NAME).stream().anyMatch(ShardRouting::relocating);
        migrateToWarm(INDEX_NAME);
        createIndex(indexName, indexSettings);  
        internalCluster().startClusterManagerOnlyNode(clusterSettings);  
            // Cleanup  
import org.opensearch.storage.action.tiering.IndexTieringRequest;  
            }
            logger.info("--> Enabling allocation to allow migrations to complete");
        return Settings.builder()
            clusterInfoService.setDiskUsageFunctionAndRefresh(  
            }, 60, TimeUnit.SECONDS);
    }  
                IndexModule.TieringState.WARM_TO_HOT.toString()
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards)
            initialDeletedIds.add(docId);
        long originalDocCount = indexStats.get(TOTAL_OPERATIONS);  
                    }
                assertIndexShardLocation(index, true);  
            logger.info("--> Starting warm to hot migration for all indices");
            logger.info("--> Starting warm to hot migration for all indices");
    }
    }  
                client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
        assertEquals("Document count changed after W2H migration", totalExpectedDocs, getDocCount(INDEX_NAME));
                .cluster()  
        if (extra != null) {  
        }  
                    verifyWarmIndexSettings(index);
        for (Map.Entry<String, Object> entry : expectedSettings.entrySet()) {
            assertEquals(DocWriteResponse.Result.DELETED, client().prepareDelete(INDEX_NAME, docId).get().getResult());  
            }
                AcknowledgedResponse response = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, request).actionGet();
            for (String index : Stream.concat(Arrays.stream(hotToWarmIndices), Arrays.stream(warmToHotIndices)).toArray(String[]::new)) {
import org.opensearch.cluster.node.DiscoveryNodeRole;
    public void testConcurrentWarmToHotMigrationWithHotNodesRestarts() throws Exception {  
                flush(index);
                verifyWarmIndexSettings(index);
            MockInternalClusterInfoService.TestPlugin.class
        );  
 * this file be licensed under the Apache-2.0 license or a
            }, 60, TimeUnit.SECONDS);
                ClusterState state = client().admin().cluster().prepareState().get().getState();  
        verifyMigrationError(INDEX_NAME, "hot", "since we don't have [HOT] node with free space to fit it's largest shard");  
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
    // Helper method to verify index shard location  
    @Override
        createTestIndex(INDEX_NAME, 1, numberOfReplicas);
            }
    private static final int MIGRATION_TIMEOUT_SECONDS = 30;
            MockInternalClusterInfoService.TestPlugin.class
        }  
                h2wLatch,
    public void testBothTypeMigrationWithMasterFailure() throws Exception {
            ensureStableCluster(6); // Remaining nodes (2 master + 2 data + 2 warm)  
        IndexRoutingTable indexRoutingTable = state.routingTable().index(indexName);  
            final IndexTieringRequest hotRequest = new IndexTieringRequest("hot", INDEX_NAME);  
    public void testHotMigrationForAlreadyMigratingIndex() throws Exception {
    public void testHotToWarmAndWarmToHotMigrationWithAndWithoutReplica() throws Exception {  
            // Although there is only 1 node to accomodate the largest shard, validation should fail as the Index has 1 replica
                internalCluster().restartNode(nodeName, new InternalTestCluster.RestartCallback());
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();  
                createTestIndex(index, 1, 1);
        );
        String testName = getTestName();
import java.util.HashMap;
        MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
    }
        assertEquals("Document count mismatch after initial deletions", expectedDocsAfterInitialDelete, getDocCount(INDEX_NAME));
            // Move all indices to warm tier first
        createTestIndex(INDEX_NAME, 1, 1);
        return response.getHits().getTotalHits().value();  
    }
            for (String index : indices) {  
        w2hListeners.forEach(listener -> clusterService().removeListener(listener));
        ensureGreen(TEST_INDEX);  
        internalCluster().startDataOnlyNodes(Math.max(numberOfReplicas + 1, 2), clusterSettings);  
            String assignedNodeId = shardRouting.currentNodeId();
                ClusterState state = client().admin().cluster().prepareState().get().getState();
            // Start migration back to hot for all indices
        setupCluster(numberOfReplicas, Settings.EMPTY);  
            assertHitCount(client().prepareSearch(TEST_INDEX).setSize(0).get(), originalDocCount);
        // Index initial documents
    }
            assertTrue(response.isAcknowledged());
            }, 30, TimeUnit.SECONDS);
                (handler, request, channel, task) -> {
import org.opensearch.index.query.QueryBuilders;
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();  
                .setTransientSettings(
        // Setup and create index
        for (String index : indices) {
            .put(ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500));  
        );
        final IndexTieringRequest hotRequest = new IndexTieringRequest("hot", INDEX_NAME);
            );  
            // Disable allocation to block migrations
        internalCluster().startWarmOnlyNodes(2);
            (nodeId -> new NodeResourceUsageStats(nodeId, System.currentTimeMillis(), 99, 20, null, 0.0))
                }  
        );  
                        .put("cluster.routing.allocation.node_concurrent_outgoing_recoveries", 2)  
        internalCluster().startWarmOnlyNodes(2, clusterSettings);
        Settings currentSettings = internalCluster().clusterService().state().metadata().index(indexName).getSettings();  
            for (String index : warmToHotIndices) {
            // Trigger warm to hot migration  
        // Create latch to track migration start
            AcknowledgedResponse response = client().admin().indices().execute(HotToWarmTierAction.INSTANCE, request).actionGet();
        refresh(indexName);
                verifyHotIndexSettings(index);  
        );
        CountDownLatch w2hLatch = new CountDownLatch(1);
            )
            // Wait for cluster to stabilize with new master
        refresh(INDEX_NAME);
            for (String index : hotToWarmIndices) {  
        logger.info("Testing migration with document deletions, replicas: {}", numberOfReplicas);
        long additionalDocs = warmIndexStats.get(TOTAL_OPERATIONS);
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildDisabledAllocationSettings()).get();
    protected void setupCluster(int numberOfReplicas, Settings clusterSettings) {
        assertIndexShardLocation(INDEX_NAME, false);
    }  
            for (String index : indices) {
            }
            for (String index : indices) {
            "testHotMigrationWithNoSpaceForLargestShard_YellowIndex",
        }
                }  
import static org.hamcrest.Matchers.containsString;  
            final IndexTieringRequest request = new IndexTieringRequest("hot", TEST_INDEX);
            logger.info("--> Enabling allocation to allow migrations to complete");  
            logger.info("--> Starting bidirectional migrations");
        // Start initial hot migration
                    ClusterState state = client().admin().cluster().prepareState().get().getState();
        long originalDocCount = indexStats.get(TOTAL_OPERATIONS);  
                assertIndexShardLocation(index, false);
    public void testHotToWarmAndWarmToHotMigrationWithAndWithoutReplicaWithData() throws Exception {
    */
            // Verify index hasn't started relocation
        assertBusy(() -> {
 */  
                assertTrue("Should have at least one hot node", !hotNodeNames.isEmpty());  
            }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);  
        try {
        AcknowledgedResponse hotResponse = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, hotRequest).actionGet();  
        }
        );  
    protected void migrateToHot(String indexName) throws Exception {  
        final String TEST_INDEX = "test-index";
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();  
                }  
        String hotNodeId = internalCluster().startDataOnlyNodes(2).get(0);
                assertTrue(response.isAcknowledged());
        internalCluster().startClusterManagerOnlyNode();
            final IndexTieringRequest request = new IndexTieringRequest("hot", TEST_INDEX);
            // Sleep to ensure migration requests are processed  
        // Setup and create index  
            // Create index with 1 primary and 1 replica on warm node
                    try {
                // Get target node ID
    private static final long TOTAL_SPACE_BYTES = new ByteSizeValue(1000, ByteSizeUnit.KB).getBytes();  
        interceptCheckpointUpdates();
            // Control allocation speed  
            assertEquals(  
            assertBusy(() -> {
        migrateToHot(INDEX_NAME);
        featureSettings.put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true);
            // Verify data consistency  
        );
        long initialDocCount = indexStats.get(TOTAL_OPERATIONS);
        migrateToWarm(INDEX_NAME);
            for (String index : indices) {
/*  
        clusterInfoService.setNodeResourceUsageFunctionAndRefresh(  
import org.opensearch.transport.TransportService;
        } finally {
            AcknowledgedResponse stuckResponse = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, stuckRequest).actionGet();  
        try {
        // ResourceUsageCollector requires atleast below stats to be ready within a window to capture stats
            // Verify migrations are stuck due to disabled allocation  
                    .getNodes()  
    }
        assertIndexShardLocation(INDEX_NAME, false);  
                    } catch (AssertionError e) {
        interceptCheckpointUpdates();
    }
            public void clusterChanged(ClusterChangedEvent event) {
        // Verify no error when trying concurrent migration  
        int numberOfReplicas = randomIntBetween(0, 2);
        internalCluster().startClusterManagerOnlyNode();  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        internalCluster().startClusterManagerOnlyNode();
        setupCluster(1);
        final String TEST_INDEX = "test-index";
            refresh(INDEX_NAME);
import org.opensearch.action.support.PlainActionFuture;
                SearchResponse searchResponse = client().prepareSearch(TEST_INDEX)
        for (SearchHit hit : initialSearchResponse.getHits()) {  
            internalCluster().stopCurrentClusterManagerNode();  
        // Clean up W2H listeners
            final IndexTieringRequest stuckRequest = new IndexTieringRequest("hot", index);
        // Index initial documents
    protected void verifyWarmIndexSettings(String indexName) {
        // Cleanup
            .put(super.nodeSettings(nodeOrdinal))  
            throw e;  
        Settings logsettings = Settings.builder().put("logger.org.opensearch.cluster.routing.allocation", "TRACE").build();
        // Migrate to warm  
                )
        // First migrate to warm
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildDisabledAllocationSettings()).get();
            client().admin().indices().execute(HotToWarmTierAction.INSTANCE, request).actionGet();
            }
        } finally {
            // Enable allocation to allow migrations to proceed  
            clusterService().addListener(relocationListener);
    }
            // Verify data consistency
            // Create index with 1 primary and 1 replica on warm node
        InternalClusterInfoService infoService = (InternalClusterInfoService) internalCluster().getInstance(
            logger.info("--> Created index {} with {} documents and 1 replica", INDEX_NAME, stats.get(TOTAL_OPERATIONS));
        verifyMigrationError(INDEX_NAME, "hot", "Cannot migrate index [" + INDEX_NAME + "] to HOT tier");
            logger.info("starting hot to warm tiering for index: {}", indexName);  
                    assertFalse("Shard should not be relocating", shardRouting.relocating());
import org.opensearch.storage.action.tiering.WarmToHotTierAction;
                long expectedCount = indexDocCounts.get(index);
                .cluster()
            ensureYellow(INDEX_NAME);  
            // Enable allocation to allow migrations to proceed  
                    .cluster()
        try {
                assertFalse("Shard should not be on warm node ", assignedNode.getRoles().contains(DiscoveryNodeRole.WARM_ROLE));
        h2wListeners.forEach(listener -> clusterService().removeListener(listener));  
        // Add listener to detect when shards start relocating
    }
                        w2hMigrationStarted.countDown();
        setupCluster(2);  // Start with 2 hot nodes
import static org.opensearch.storage.tiering.TieringTestUtils.buildEnabledAllocationSettings;
                QueryBuilders.idsQuery().addIds(Stream.concat(initialDeletedIds.stream(), warmDeletedIds.stream()).toArray(String[]::new))
            }
            indexDocCounts.put(INDEX_NAME, stats.get(TOTAL_OPERATIONS));
            }, 30, TimeUnit.SECONDS);
        internalCluster().startDataOnlyNodes(2);  
import static org.opensearch.storage.tiering.TieringTestUtils.buildDisabledAllocationSettings;  
    @Override
        ensureGreen(TEST_INDEX);  
            for (String index : indices) {  
        } finally {
        for (Map.Entry<String, Object> entry : expectedSettings.entrySet()) {  
            clusterService().removeListener(w2hListener);
            () -> client().admin().indices().execute(WarmToHotTierAction.INSTANCE, request).actionGet()
        long expectedDocsAfterInitialDelete = initialDocCount - initialDeletedIds.size();
        // Create index and migrate it to warm first
            assertTrue(response.isAcknowledged());
        internalCluster().startDataOnlyNodes(3);
            for (String index : indices) {
        try {  
        setupCluster(1);
            logger.info("--> Enabling allocation to allow migrations to complete");
        flush(INDEX_NAME);  
            client().admin().indices().delete(new DeleteIndexRequest(TEST_INDEX)).actionGet();
        createTestIndex(INDEX_NAME, 1, 1);  
            // Trigger warm to hot migration
        createTestIndex(TEST_INDEX, 1, 1);
        long expectedDocsAfterWarmDelete = expectedDocsAfterInitialDelete - warmDeletedIds.size();
        for (String index : inFlightTieringIndices) {
    }  
        try {
            for (String index : indices) {  
            MockInternalClusterInfoService.TestPlugin.class
                    ShardRouting shardRouting = state.routingTable().index(index).shard(0).primaryShard();
            assertTrue(response.isAcknowledged());
    protected void refreshClusterInfo() {
            ensureGreen(warmToHotIndices);  
            "testHotMigrationWithNoNodesCapacity_YellowIndex",
                        handler.messageReceived(request, channel, task);  
                assertTrue("Target node should be a hot node", targetNode.getRoles().contains(DiscoveryNodeRole.DATA_ROLE));  
import org.opensearch.test.transport.MockTransportService;
                    .stream()
            );
            }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        internalCluster().startWarmOnlyNodes(2);  // warm nodes  
    protected boolean ignoreExternalCluster() {
                AcknowledgedResponse response = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, request).actionGet();
            .put(buildDisabledAllocationSettings())
                // Get target node ID  
        } finally {
            // Create and populate all indices
            // Delete index during migration
    }
        String warmNode = internalCluster().startWarmOnlyNodes(2).get(0);  
                    assertIndexShardLocation(index, false); // Should be on hot nodes
        } finally {
        // Delete more documents while in warm tier
        }  
            ClusterStateListener listener = new TieringTestUtils.MockTieringCompletionListener(  
        Map<String, Long> indexStats = indexData(1, false, TEST_INDEX);
        List<ClusterStateListener> h2wListeners = new ArrayList<>();
                logger.info("--> Index {} document count - expected: {}, actual: {}", index, expectedCount, actualCount);
    }
            assertBusy(() -> {  
        final IndexTieringRequest request = new IndexTieringRequest(targetTier, indexName);
    public void testWarmToHotMigrationWithUnassignedReplica() throws Exception {
                client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
                    if (isRelocating) {  
    }
                state.nodes()
        internalCluster().startDataOnlyNodes(2);  // hot nodes
        setupCluster(numberOfReplicas);
                final IndexTieringRequest request = new IndexTieringRequest("hot", index);  
            if (shardRouting.unassigned() && shardRouting.primary() == false || assignedNode == null) {
        MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
import org.opensearch.monitor.fs.FsInfo;
        }
            internalCluster().stopCurrentClusterManagerNode();  
            for (String index : indices) {  
                .get();
        ensureGreen(TEST_INDEX);  
                    .setQuery(QueryBuilders.matchAllQuery())  
import org.opensearch.storage.action.tiering.HotToWarmTierAction;
        } finally {
            // Verify data consistency  
        ensureGreen(INDEX_NAME);  
                w2hLatch,  
        verifyMigrationError(INDEX_NAME, "HOT", "Rejecting tiering request as JVM Utilization is high on all [HOT] nodes");
            }
            .build();
        migrateToWarm(INDEX_NAME);
        // Migrate to warm
        List<ClusterStateListener> w2hListeners = new ArrayList<>();
            MockTransportService mockTransportService = (MockTransportService) internalCluster().getInstance(
    public void testMultipleIndicesWarmToHotMigration() throws Exception {
        // Start cluster nodes with 3 master nodes for quorum
            // Wait for relocation to start
        // Setup cluster with controlled allocation  
        assertEquals("Deleted documents reappeared after migration", 0, deletedDocsSearch.getHits().getTotalHits().value());  
            .build();
            assertBusy(() -> {
            final IndexTieringRequest request = new IndexTieringRequest("hot", indexName);  
                assertIndexShardLocation(INDEX_NAME, false);
        } finally {  
     * Intercepts the UPDATE_VISIBLE_CHECKPOINT transport action on all nodes to gracefully handle
    If there is a quorum loss, restoration of indices metadata happens at a later event than the master-change.
        createTestIndex(INDEX_NAME, 1, 1);
        // Create multiple indices
                    assertIndexShardLocation(index, true);  // Should still be on warm nodes
                createTestIndex(index, 1, 1);  
        MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
        List<String> initialDeletedIds = new ArrayList<>();
    }
    public void testHotToWarmMigrationWithDeletedDocumentSuccess() throws Exception {
            AcknowledgedResponse response = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, request).actionGet();  
            }
        setupCluster(1);
        internalCluster().startWarmOnlyNodes(2);
                for (String index : indices) {
            assertEquals(
        // Verify doc count before hot migration
        // Migrate to hot
    }  
            }
        // Verify initial state and doc count
                for (String index : warmToHotIndices) {  
        migrateToWarm(TEST_INDEX);  
            assertTrue(response.isAcknowledged());
            }, 30, TimeUnit.SECONDS);
    protected long getDocCount(String indexName) {  
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;  
        try {  
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
        TEST_SPECIFIC_CUSTOM_CLUSTER_INFO.put(
            // Verify data consistency
        migrateToWarm(INDEX_NAME);
                    verifyHotIndexSettings(index);
            assertHitCount(client().prepareSearch(TEST_INDEX).setSize(0).get(), originalDocCount);
    @Override  
        }  
        verifyMigrationError(INDEX_NAME, "hot", "since we don't have enough [" + "HOT" + "] capacity. Please add more");  
            ShardRouting shardRouting = shardRoutingTable.primaryShard();  
            client().admin().indices().execute(WarmToHotTierAction.INSTANCE, hotRequest).actionGet();  
        }
        }  
public class WarmToHotTieringServiceIT extends RemoteStoreBaseIntegTestCase {
            String docId = hit.getId();  
            // Verify migrations complete on remaining master  
                logger.info("--> Stop hot node {} during relocation", targetNode.getName());
    protected Settings nodeSettings(int nodeOrdinal) {
        return plugins;  
                assertIndexShardLocation(TEST_INDEX, false); // Should be on hot nodes
                }  
            () -> client().admin().indices().execute(WarmToHotTierAction.INSTANCE, tieringRequest).actionGet()
        return featureSettings.build();  
        int numberOfShards = randomIntBetween(1, 2);  
            clusterService().removeListener(relocationListener);  
        final String[] hotToWarmIndices = new String[] { "hot-to-warm-1", "hot-to-warm-2" };  
        // Disable allocation to block migrations  
            // Create indices and add data
            ensureGreen(INDEX_NAME);
        // Verify error when trying concurrent migration
        for (String index : indices) {
                AcknowledgedResponse response = client().admin().indices().execute(HotToWarmTierAction.INSTANCE, request).actionGet();
                        .put("cluster.routing.allocation.node_concurrent_recoveries", 1)  
        interceptCheckpointUpdates();
        ClusterState state = client().admin().cluster().prepareState().get().getState();
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
            }, 60, TimeUnit.SECONDS);
            internalCluster().stopRandomWarmNode();
            logger.info("--> Restarting current master node");
        // Create index and migrate it to warm first
        refresh(INDEX_NAME);
                long actualCount = client().prepareSearch(index).setSize(0).get().getHits().getTotalHits().value();
            OpenSearchRejectedExecutionException.class,
                final IndexTieringRequest request = new IndexTieringRequest("hot", index);
    }
    public void testConcurrentWarmToHotMigrationWithHotNodesFailure() throws Exception {  
import java.util.Arrays;
                .setTransientSettings(
    }  
            // Cleanup  
            final IndexTieringRequest request = new IndexTieringRequest("hot", TEST_INDEX);  
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
        migrateToWarm("test-index-3");
        // Setup and create index  
    protected MockInternalClusterInfoService getMockInternalClusterInfoService() {  
                assertEquals("Document count mismatch for index " + index, expectedCount, actualCount);
                // Collect all hot nodes
                String targetNodeId = shardRouting.relocatingNodeId();
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
                assertEquals("Document count mismatch for index " + index, expectedCount, actualCount);
            client().admin()
            logger.info("--> Enabling allocation to allow migrations to complete");
        Settings.Builder featureSettings = Settings.builder();
                assertIndexShardLocation(indexName, true);
    public void testHotMigrationForAlreadyHotIndex() throws Exception {  
        migrateToWarm(INDEX_NAME);  
 * compatible open source license.
            createTestIndex(INDEX_NAME, 1, 1);
        }
import org.opensearch.cluster.routing.IndexRoutingTable;  
            );  
            } else {
            w2hListeners.add(listener);
                currentSettings.get(entry.getKey())  
        ClusterStateListener h2wListener = new TieringTestUtils.MockTieringCompletionListener(  
        setupCluster(1);
import org.opensearch.test.InternalTestCluster;
            // Drop any warm node and verify index is in yellow state now.  
        internalCluster().startClusterManagerOnlyNode();
                client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
        createTestIndex(TEST_INDEX, 1, 1);
            }, 60, TimeUnit.SECONDS);  
        flush(INDEX_NAME);  
                refresh(index);
        try {
import org.opensearch.node.Node;
                continue;  
            // Start migration back to hot for all indices  
                currentSettings.get(entry.getKey())
    private static final int DEFAULT_TIMEOUT_SECONDS = 30;
            }
            createTestIndex(INDEX_NAME, 1, 1);
        migrateToHot(INDEX_NAME);
    protected boolean addMockIndexStorePlugin() {  
                nodeName  
        final String[] warmToHotIndices = new String[] { "warm-to-hot-1", "warm-to-hot-2" };
            if (onWarmNodes) {
        // Verify doc count in warm tier
            final IndexTieringRequest request = new IndexTieringRequest("warm", indexName);
        }  
        createTestIndex(INDEX_NAME, numberOfShards, numberOfReplicas);
        // Start cluster nodes with 1 master node for quorum
            for (String index : hotToWarmIndices) {
            verifyMigrationError(INDEX_NAME, "HOT", "");
                Map<String, Long> stats = indexData(1, false, index);
                assertBusy(() -> {
import org.opensearch.cluster.MockInternalClusterInfoService;
            assertBusy(() -> {
                internalCluster().stopRandomNode(InternalTestCluster.nameFilter(targetNode.getName()));  
    }
                verifyHotIndexSettings(TEST_INDEX);
            }, 60, TimeUnit.SECONDS);
                assertIndexShardLocation(TEST_INDEX, false); // Should be on hot nodes
            Map<String, Long> stats = indexData(1, false, INDEX_NAME);  
        createTestIndex(INDEX_NAME, 1, 1);
    protected void verifyHotIndexSettings(String indexName) {
            ensureStableCluster(6); // Remaining nodes  
        internalCluster().startClusterManagerOnlyNode();  
        // refreshClusterInfo();
            // Now disable allocation to control the timing  
                }, 30, TimeUnit.SECONDS);
        // Migrate back to hot  
    static {  
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();  
            for (String index : indices) {
        // Verify initial state  
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(1)).get();
                Map<String, Long> stats = indexData(1, false, index);
    public void testWarmMigrationWithAllNodesJVMUtilizationBreached() throws Exception {  
        );
    public void testWarmToHotMigrationWithMasterNodeFailure() throws Exception {
            assertEquals(100, client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value());
                assertTrue("Target node should be a hot node", targetNode.getRoles().contains(DiscoveryNodeRole.DATA_ROLE));
        ClusterStateListener w2hListener = new TieringTestUtils.MockTieringCompletionListener(  
    protected static FsInfo.Path setDiskUsage(FsInfo.Path original, long totalBytes, long freeBytes) {  
    }
                assertBusy(() -> {
import org.opensearch.action.DocWriteResponse;  
import org.opensearch.action.search.SearchResponse;  
        interceptCheckpointUpdates();  
            ClusterInfoService.class,  
        CountDownLatch w2hMigrationStarted = new CountDownLatch(1);  
        // Index more documents while in warm tier  
            // Verify migrations complete on remaining master
            logger.info("--> Cluster stabilized after master node failure");  
        assertEquals("Document count mismatch after warm tier deletions", expectedDocsAfterWarmDelete, getDocCount(INDEX_NAME));  
            for (String nodeName : hotNodeNames) {
            internalCluster().stopRandomWarmNode();  
import org.opensearch.indices.replication.SegmentReplicationSourceService;  
            clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 900L);  
            // Sleep to ensure migration requests are processed
    protected void interceptCheckpointUpdates() {
                migrateToWarm(index);
import java.util.List;
            // Although there is only 1 node to accomodate the largest shard, validation should fail as the Index is Yellow  
            for (String index : Stream.concat(Arrays.stream(hotToWarmIndices), Arrays.stream(warmToHotIndices)).toArray(String[]::new)) {
            Map<String, Long> stats = indexData(1, false, INDEX_NAME);
        assertThat(e.getMessage(), containsString(expectedErrorMessage));
        migrateToWarm(INDEX_NAME);
            logger.info("--> Stopping current master node");
                assertTrue(response.isAcknowledged());  
            assertBusy(() -> {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            clusterService().addListener(h2wListener);
                    assertIndexShardLocation(index, false);  // Should now be on hot nodes
        TieringTestUtils.safeSleep(6000);  
                ClusterState state = client().admin().cluster().prepareState().get().getState();  
        return (MockInternalClusterInfoService) internalCluster().getCurrentClusterManagerNodeInstance(ClusterInfoService.class);
        } finally {
        // Adding a delay to let the JVM and CPU stats get collected
import org.opensearch.cluster.InternalClusterInfoService;
        // Setup cluster
            clusterService().addListener(listener);
        }  
            internalCluster().stopRandomWarmNode();
        assertBusy(() -> {  
        for (String index : indices) {
        // Migrate back to hot
        // Setup cluster with normal allocation settings (don't disable initially)  
    protected void assertIndexShardLocation(String indexName, boolean onWarmNodes) {
            // Stop current master node
        createTestIndex(INDEX_NAME, 1, 1);
 * The OpenSearch Contributors require contributions made to  
        setupCluster(1);
        SearchResponse deletedDocsSearch = client().prepareSearch(INDEX_NAME)  
            internalCluster().startDataOnlyNode();  
            // Enable full allocation to allow migration to complete  
                    ShardRouting shardRouting = state.routingTable().index(index).shard(0).primaryShard();
                ensureYellow(INDEX_NAME);
                    .get();
        logger.info("--> Disabling allocation to block migrations");
            assertTrue(response.isAcknowledged());  
            }
            // Enable allocation to allow migrations to proceed
            clusterService().addListener(listener);  
        final String INDEX_NAME = "test-index";  
            refresh(indices);
        CountDownLatch w2hLatch = new CountDownLatch(indices.length);  
                ShardRouting shardRouting = state.routingTable().index(TEST_INDEX).shard(0).primaryShard();
                    .forEach(node -> hotNodeNames.add(node.getName()));
        List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());  
        ClusterStateListener relocationListener = new ClusterStateListener() {  
    }
        }
        SearchResponse response = client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).setSize(0).get();
            client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();  
        // Wait for all H2W migrations to complete  
        }  
                for (String index : indices) {  
import org.opensearch.core.transport.TransportResponse;  
                if (event.state().routingTable().hasIndex(INDEX_NAME)) {  
        // Try migrating again and verify error
                entry.getValue().toString(),
        // Start minimal cluster - one master, one hot node, one warm node  
        TEST_SPECIFIC_CUSTOM_CLUSTER_INFO.put(  
        Map<String, Object> expectedSettings = TieringTestUtils.getExpectedWarmIndexSettings();
            final IndexTieringRequest request = new IndexTieringRequest("hot", index);
            logger.info("--> Starting warm to hot migration for index: {}", TEST_INDEX);
            final IndexTieringRequest request = new IndexTieringRequest("warm", index);  
        refresh(INDEX_NAME);
            }
    /*  
        int numberOfReplicas = randomIntBetween(0, 2);
        logger.info("--> Starting warm to hot migration test with hot node failed during relocation");
            (discoveryNode, fsInfoPath) -> setDiskUsage(  
            ensureYellow(INDEX_NAME);
        Settings currentSettings = internalCluster().clusterService().state().metadata().index(indexName).getSettings();
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
            AcknowledgedResponse response = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, request).actionGet();  
            // Wait for relocation to start  
            logger.info("--> Disabling allocation to block migrations");  
        Map<String, Long> indexDocCounts = new HashMap<>();
                assertIndexShardLocation(index, true);  
        long initialDocCount = initialIndexStats.get(TOTAL_OPERATIONS);
            // Verify data consistency  
                }
            AcknowledgedResponse response = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, request).actionGet();
        Map<String, Long> warmIndexStats = indexData(randomIntBetween(1, 3), true, INDEX_NAME);
                internalCluster().restartNode(targetNode.getName());
            client().admin()
            h2wLatch,
                long expectedCount = indexDocCounts.get(index);  
                createTestIndex(index, 1, 1);
            client().admin().indices().delete(new DeleteIndexRequest(TEST_INDEX)).actionGet();
        String warmNode = internalCluster().startWarmOnlyNodes(2).get(0);  
            migrateToWarm(INDEX_NAME);
        interceptCheckpointUpdates();
            refresh(indices);  
        // Try migrating again and verify error
                Map<String, Long> stats = indexData(1, false, index);
        // Cleanup
        setupCluster(1);
        TEST_SPECIFIC_CUSTOM_CLUSTER_INFO.put(
            indexName,
                ShardRouting shardRouting = state.routingTable().index(index).shard(0).primaryShard();
            TieringTestUtils.safeSleep(5000);
                long expectedCount = indexDocCounts.get(index);  
        migrateToWarm(INDEX_NAME);
        ensureGreen(INDEX_NAME);  
        // Start W2H migration for all indices  
        // Now migrate all indices back to hot
    }
                new ByteSizeValue(1000, ByteSizeUnit.BYTES).getBytes()  
            TieringTestUtils.safeSleep(4000);
        } finally {  
        }
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            DiscoveryNode assignedNode = state.nodes().get(assignedNodeId);
        setupCluster(numberOfReplicas);
        List<String> warmDeletedIds = new ArrayList<>();
        try {  
        createTestIndex("test-index-3", 1, 1);  
        createTestIndex(INDEX_NAME, 1, 1);  
            for (String index : warmToHotIndices) {  
                "Incorrect value for setting: " + entry.getKey(),
        Map<String, Long> indexDocCounts = new HashMap<>();
    }
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
            clusterService().addListener(w2hListener);
        }
        // Start cluster nodes
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
        }  
     */
                TransportService.class,
                    verifyHotIndexSettings(index);
            assertBusy(() -> {
                ClusterState state = client().admin().cluster().prepareState().get().getState();  
            // disable allocation to block migrations.
        CountDownLatch h2wLatch = new CountDownLatch(1);
                // Verify hot-to-warm indices are now on warm nodes
            ensureStableCluster(5); // Remaining nodes (1 master + 2 data + 2 warm)
                new ByteSizeValue(600, ByteSizeUnit.BYTES).getBytes(),
            }  
            logger.info("--> Stopping current master node");
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildDisabledAllocationSettings()).get();
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
        for (String nodeName : internalCluster().getNodeNames()) {  
                    verifyHotIndexSettings(index);
            }  
    }
        migrateToWarm(TEST_INDEX);  
        for (String index : indices) {
            MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
        for (SearchHit hit : warmSearchResponse.getHits()) {
            ensureGreen(hotToWarmIndices);
        // Setup cluster with normal allocation settings (don't disable initially)  
            for (String index : indices) {  
    public void testConcurrentWarmToHotMigrationWithAllHotNodesRestarts() throws Exception {  
        assertTrue("Hot to Warm migration timed out", h2wLatch.await(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS));
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(settingsBuilder).get();
            for (String index : indices) {  
            createTestIndex(index, 1, 1);  // Using fixed shard and replica count
            assertEquals(DocWriteResponse.Result.DELETED, client().prepareDelete(INDEX_NAME, docId).get().getResult());
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            (discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, TOTAL_SPACE_BYTES, TOTAL_SPACE_BYTES)
                indexDocCounts.put(index, stats.get(TOTAL_OPERATIONS));
                logger.info("--> Index {} document count - expected: {}, actual: {}", index, expectedCount, actualCount);
            indexBulk(INDEX_NAME, 100);
                DiscoveryNode targetNode = state.nodes().get(targetNodeId);
                entry.getValue().toString(),  
            "testHotMigrationWithNoSpaceForLargestShard",  
            ensureGreen(indices);  
        assertEquals("Document count mismatch in warm tier", totalExpectedDocs, getDocCount(INDEX_NAME));
                assertEquals("Document count should match original", originalDocCount, searchResponse.getHits().getTotalHits().value());  
                .prepareUpdateSettings()  
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), new ByteSizeValue(1, ByteSizeUnit.GB))
            // Stop current master node
                verifyHotIndexSettings(indexName);
                }, 30, TimeUnit.SECONDS);  
                fsInfoPath,
        Map<String, Object> expectedSettings = TieringTestUtils.getExpectedHotIndexSettings();
        }  
        SearchResponse warmSearchResponse = client().prepareSearch(INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).setSize(2).get();
            }
        // Cleanup
            // Wait for relocation to start and collect hot nodes  
    @Override
                }, 30, TimeUnit.SECONDS);  
    }
import org.opensearch.common.settings.Settings;  
    protected static final Map<String, Class<? extends Plugin>> TEST_SPECIFIC_CUSTOM_CLUSTER_INFO = new HashMap<>();
        infoService.refresh();  
                indexDocCounts.put(index, stats.get(TOTAL_OPERATIONS));  
     * the known race condition where a checkpoint update arrives during relocation handoff.
        }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
        // Verify error when trying to migrate hot index to hot  
        logger.info("Testing hot to warm migration with {} replicas and {} shards", numberOfReplicas, numberOfShards);  
            // Cleanup
        logger.info("--> Starting test for warm-to-hot migration with master node failed");  
        }, DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);  
                long actualCount = client().prepareSearch(index).setSize(0).get().getHits().getTotalHits().value();
    is reconstructed properly  
            );
            h2wListeners.add(listener);
import org.opensearch.cluster.ClusterChangedEvent;  
            w2hLatch,
            migrateToWarm(INDEX_NAME);
        String masterNodeId = internalCluster().startClusterManagerOnlyNode();
        createTestIndex(INDEX_NAME, numberOfShards, numberOfReplicas);
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 230L);  
import org.opensearch.common.util.FeatureFlags;
    protected void setupCluster(int numberOfReplicas) {
                    .filter(node -> node.getRoles().contains(DiscoveryNodeRole.DATA_ROLE))  
            logger.info("--> Cluster stabilized after master node failure");
            assertBusy(() -> {  
        try {
    }
import org.opensearch.cluster.ClusterInfoService;
            );
        internalCluster().startClusterManagerOnlyNode();  
            ensureYellow(INDEX_NAME);
        String[] indices = new String[] { "test-1", "test-2", "test-3", "test-4" };  
 * SPDX-License-Identifier: Apache-2.0
                    .setSize((int) originalDocCount)
            logger.info("--> Created index {} with {} documents and 1 replica", INDEX_NAME, stats.get(TOTAL_OPERATIONS));  
                        .put("cluster.routing.allocation.node_concurrent_incoming_recoveries", 2)
import org.opensearch.cluster.ClusterStateListener;  
        Map<String, Long> indexDocCounts = new HashMap<>();
            AcknowledgedResponse response = client().admin().indices().execute(WarmToHotTierAction.INSTANCE, request).actionGet();
            verifyMigrationError(INDEX_NAME, "HOT", "since we don't have enough [HOT] capacity");  
        // First migrate to warm
import java.util.concurrent.CountDownLatch;
            ensureYellow(INDEX_NAME);  
        // Clean up H2W listeners
        setupCluster(1);  
            String docId = hit.getId();
        } catch (Exception e) {
            logger.info("--> Starting warm to hot migration for index: {}", TEST_INDEX);
        IndexTieringRequest tieringRequest = new IndexTieringRequest("WARM", "test-index-3");
                // Move these indices to warm initially
            assertBusy(() -> {
    }  
            warmDeletedIds.add(docId);
            assertBusy(() -> {  
    }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        int numberOfReplicas = randomIntBetween(1, 2);
import java.util.concurrent.TimeUnit;
    public void testHotMigrationWithNoSpaceForLargestShard() throws Exception {
                assertEquals("Document count mismatch for index " + index, expectedCount, actualCount);
        clusterInfoService.setShardSizeFunctionAndRefresh(shardRouting -> 3000000L);  
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(buildEnabledAllocationSettings(2)).get();
            .setQuery(
    public void testHotMigrationWithNoSpaceForLargestShard_YellowIndex() throws Exception {
            internalCluster().getClusterManagerName()
                ClusterState state = client().admin().cluster().prepareState().get().getState();
                final IndexTieringRequest request = new IndexTieringRequest("hot", index);  
        createTestIndex(TEST_INDEX, 1, 1);
            IndexModule.TieringState.WARM_TO_HOT.toString()  
            logger.info("--> Enabling allocation to allow migrations to complete");  
                    assertIndexShardLocation(index, false);  // Should now be on hot nodes  
        internalCluster().startClusterManagerOnlyNode();
        interceptCheckpointUpdates();
        refresh(INDEX_NAME);
            for (String index : Stream.concat(Arrays.stream(hotToWarmIndices), Arrays.stream(warmToHotIndices)).toArray(String[]::new)) {
            IndexModule.TieringState.HOT_TO_WARM.toString()  
                String targetNodeId = shardRouting.relocatingNodeId();
                        PlainActionFuture.newFuture()
            refresh(TEST_INDEX);
            client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();  
        migrateToHot(INDEX_NAME);
                flush(index);
                final IndexTieringRequest request = new IndexTieringRequest("warm", index);  
        setupCluster(1, settingsBuilder.build());
import org.opensearch.cluster.routing.ShardRouting;
            // Move all indices to warm tier first
        return true;  
        logger.info("--> Starting warm to hot migration test with hot node restarts during relocation");
        Map<String, Long> indexStats = indexData(randomIntBetween(1, 3), true, INDEX_NAME);  
        } finally {
                migrateToWarm(index);
            assertBusy(() -> {
                    fsInfoPath,
                // continue if replica shard is unassigned.
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
}
            client().admin().indices().execute(WarmToHotTierAction.INSTANCE, request).actionGet();  
                    );  
            ensureGreen(INDEX_NAME);
                    assertFalse("Shard should not be relocating", shardRouting.relocating());
            assertBusy(() -> {
            List<String> hotNodeNames = new ArrayList<>();
            // Start warm to hot migration
        migrateToWarm(INDEX_NAME);
            // Restart all hot nodes  
    }
    public void testWarmToHotMigrationDuringQuorumLoss() throws Exception {
            }, 30, TimeUnit.SECONDS);
            for (String index : indices) {
        setupCluster(1);  // Using fixed replica count for multiple indices  
        setupCluster(numberOfReplicas);
                index,
            }
            }
            // Verify migration eventually completes
            }  
            );
