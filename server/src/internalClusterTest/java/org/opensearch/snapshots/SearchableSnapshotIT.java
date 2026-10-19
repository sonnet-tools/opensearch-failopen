import org.opensearch.index.IndexSettings;
            .cluster()
        } else {
        for (int i = 0; i < 4; i++) {  
    }
        assertIndexingBlocked(restoredIndexName);
        settings.put("location", randomRepoPath()).put("compress", randomBoolean());  
            createRepository(repoName, FsRepository.TYPE, repositorySettings);  
        assertDocCount(cfsIndex + "-copy", 100L);
            .addSnapshots(snapNames)
     * and ensures the index folder is cleared on all nodes post index deletion  
            String snapName = s.getSnapshot().getSnapshotId().getName();
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequest;
        takeSnapshot(client, snapshotName2, repoName, indexName2);
    }
        for (NodeStats nodeStats : preRestoreStats.getNodes()) {
        final Client client = client();
    }
    private void testUpdateIndexSettingsAtLeastOneNotAllowedSettings(String index) {  
    }
        assertSearchableSnapshotIndexDirectoryExistence(searchNode2, index, false);  
        // Ensure when preferences are set, all the compatible shards are returned  
        // Filter out warm NodeEnvironment(s) since FileCache is initialized only on warm nodes and
        expect.put(initSnapName, List.of(indexName));  
            .actionGet()
                assertTrue(isFileCacheEmpty(fcstats));  
        for (Node node : internalCluster().getInstances(Node.class)) {
            assertEquals(1, s.getIndices().size());  
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
            final NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats(nodeId).addMetric(FS.metricName()).get();
    }
        assertNodesFileCacheNonEmpty(numNodes);  
        final String restoredIndexName1 = indexName1 + "-copy";
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
            .actionGet();  
        internalCluster().ensureAtLeastNumWarmNodes(numReplicasIndex + 1);  
        final String indexName1 = "test-idx-1";
    }
                    .prepareUpdateSettings(restoredIndexName)
        internalCluster().ensureAtLeastNumWarmAndDataNodes(numReplicasIndex + 1);
    }
        createIndexWithDocsAndEnsureGreen(0, 100, indexName2);
            .searchShards(new ClusterSearchShardsRequest(restoredIndexName).preference("foo"))  
        final String repoName = "test-repo";
                .setRenamePattern("([a-z-]+).*")
        final Client client = client();
            NodeStats preRestoreStat = preRestoreStatsMap.get(node);  
        logger.info("--> Create a repository");
        );  
        MatcherAssert.assertThat(
        deleteIndicesAndEnsureGreen(client, cfsIndex, nonCfsIndex);
 */  
    /**
                assertEquals(numIndexCount, dataPathStream.count());
            AggregateFileCacheStats fcstats = stats.getFileCacheStats();
    }
        createRepositoryWithSettings(null, repoName);  
    public void testUpdateIndexSettings() throws InterruptedException {
    private void assertCacheDirectoryReplicaAndIndexCount(int numCacheFolderCount, int numIndexCount) throws IOException {
    }  
            .collect(Collectors.toSet());
        createIndexWithDocsAndEnsureGreen(0, 50, indexName2);
            assertTrue(shardRouting.assignedToNode());
    }
    /**  
        final String restoredIndexName1 = indexName1 + "-copy";  
        final String snapshotName = "test-snap";
            assertTrue("index path should " + (exists ? "exist" : "not exist"), Files.exists(indexDataPath) == exists);
        final String restoredIndexName2 = indexName2 + "-copy";
        final int numNodes = 2;  
        );
        final String snapshotName = "test-snap";
        );
        final String indexName1 = "test-idx-1";
        IntStream.range(0, 4).forEach(i -> expect.put(repeatSnapNamePrefix + i, List.of(repeatIndexNamePrefix + i)));
        indexRandomDocs(indexName, numOfDocs);
    public void testRestoreSearchableSnapshotWithIndexStoreTypeThrowsException() throws Exception {
        internalCluster().ensureAtLeastNumWarmAndDataNodes(numShards);
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);  
        createIndexWithDocsAndEnsureGreen(1, 100, indexName1);  
        ensureGreen();
            .storageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)  
    }
import static org.hamcrest.Matchers.greaterThan;
                final String path = info.getPath();
     * This assertion is digging a bit into the implementation details to
            () -> internalCluster().startNode(
            () -> internalCluster().startNode(  
        assertThrows(
        final String restoredIndexName = indexName + "-copy";
    public void testBlocksUnpinnedAfterRestore() throws Exception {  
import org.opensearch.common.unit.TimeValue;
        assertDocCount(restoredIndexName, 100L);
        logger.info("--> stop a random warm node");
        final int numReplicas = randomIntBetween(1, 4);  
    public void testCacheIndexFilesClearedOnDelete() throws Exception {
import java.nio.file.Files;
            .setRenameReplacement("$1-copy-0")
        takeSnapshot(client, snapshotName, repoName, indexName);
            assertNotNull(shardRouting);
        ensureGreen();  
            error.getMessage(),  
            client.admin()  
    public void testDefaultShardPreference() throws Exception {
        takeSnapshot(client, snapshotName, repoName, indexName);
        takeSnapshot(client, snapshotName, repoName, indexName1);
        testUpdateIndexSettingsOnlyNotAllowedSettings(restoredIndexName);
        final Client client = client();  
    }
     * that the 'index' directory does not exist in the node's file system.
                "shard state path should " + (exists ? "exist" : "not exist"),
            .execute()  
        ensureGreen();
        // Keeping the replicas to 0 for reproducible cache results as shards can get reassigned otherwise
    }  
        final String restoredIndexName = indexName + "-copy";  
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
        final String repoName = "test-repo";  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;  
    protected boolean addMockInternalEngine() {
    /**  
    /**  
        return settings;
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
            .getSettings(new GetSettingsRequest().indices(snapshotIndexNames))
        assertSearchableSnapshotIndexDirectoryExistence(searchNode2, index, false);
     */
        deleteIndicesAndEnsureGreen(client, restoredIndexName);
import org.opensearch.cluster.block.ClusterBlockException;
    public void testPruneFileCacheOnIndexDeletion() throws Exception {
import java.util.stream.Collectors;
        createRepositoryWithSettings(null, repoName);
    public void testCreateSearchableSnapshotWithSmallChunks() throws Exception {
        final int numReplicasIndex = randomIntBetween(1, 4);  
        createIndexWithDocsAndEnsureGreen(0, 100, indexName);  
import java.util.stream.StreamSupport;
        Settings.Builder repositorySettings = chunkedRepositorySettings(1000);
            if (fcstats != null) {
        assertDocCount(restoredIndexName, 100L);
            try (Stream<Path> dataPathStream = Files.list(fileCachePath)) {
        final String snapshotName = "test-snap";
            .setWaitForCompletion(true)
     * verify that the Lucene segment files are not copied from the snapshot  
        takeSnapshot(client, snapshotName, repoName, indexName);  
                assertEquals(1, s.getIndices().size());
        // Second restore immediately after - ClusterInfo won't have size data for first restore shards
        assertDocCount(restoredIndexName, 1000L);
        final String snapshotName = "test-snap";  
        final Settings.Builder settings = Settings.builder();
                assertNotNull(s.getIndices().get("test-idx"));  
            .searchShards(new ClusterSearchShardsRequest(restoredIndexName))
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
        final int numReplicasIndex2 = randomIntBetween(0, 2);  
        createRepositoryWithSettings(null, repoName);  
        ensureGreen("remote-" + indexName1);
            .put("index.codec", "default")
            try (Stream<Path> paths = Files.walk(fileCachePath)) {
        internalCluster().validateClusterFormed();  
    }
                .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.FS.getSettingsKey())  
            .setStorageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)  
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
            Path fileCachePath = node.getNodeEnvironment().fileCacheNodePath().fileCachePath;
        final String repoName = "test-repo";
    }
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
            .storageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)
            .setWaitForNoRelocatingShards(true)
                .activePrimaryShardsGrouped(new String[] { indexName }, false);  
        }  
                    Settings.builder()
        takeSnapshot(client, snapshotName, repoName, cfsIndex, nonCfsIndex);  
            .cluster()  
     */
        // The index count will be 1 since there is only a single restored index "test-idx-copy"
        Map<String, NodeStats> postRestoreStatsMap = postRestoreStats.getNodesMap();
        createRepositoryWithSettings(null, repoName);
                Files.exists(shardPath.getShardStatePath()) == exists
        final GetSnapshotsResponse response = client.admin().cluster().prepareGetSnapshots(repoName).execute().actionGet();
     * Tests the functionality of index write block on a searchable snapshot index.
        internalCluster().ensureAtLeastNumWarmAndDataNodes(numReplicas + 1);
        internalCluster().ensureAtLeastNumWarmAndDataNodes(numNodes);
            assertTrue(
        logger.info("--> validated that the cache file path doesn't exist");
        final String indexName = "test-idx";  
        snapNames[4] = initSnapName;  
    @Override
import static org.hamcrest.Matchers.equalTo;
    public void testRelocateSearchableSnapshotIndex() throws Exception {  
                .cluster()
        }
        final String indexName1 = "test-index1";  
        final Set<String> warmNodes = StreamSupport.stream(clusterService().state().getNodes().spliterator(), false)
            assertTrue(state.getRoutingTable().allShards(index).stream().noneMatch(shard -> shard.currentNodeId().equals(node)));
            .cluster()
        assertDocCount(restoredIndexName, 100L);  
            .setPersistentSettings(Settings.builder().put("cluster.info.update.interval", "60m"))  
        final String indexName = "test-idx";
        final String snapshotName = "test-snap";
        ClusterHealthResponse clusterHealthResponse = client.admin()  
import java.util.List;  
        try {
    /**
        client.admin()  
        assertEquals(numNodes, nonEmptyFileCacheNodes);
        takeSnapshot(client, snapshotName, repoName, indexName);
        final CreateSnapshotResponse createSnapshotResponse = client.admin()
            } else {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
     * taking a snapshot, restoring it as a searchable snapshot index.  
        assertDocCount(restoredIndexName2, 100L);
                if (!isFileCacheEmpty(fcStats)) {
        final String nonCfsIndex = "test-idx-noncfs";
        deleteIndicesAndEnsureGreen(client, indexName);  
        final Client client = client();
    private void createIndexWithDocsAndEnsureGreen(int numShardsIndex, int numReplicasIndex, int numOfDocs, String indexName)
        client.admin()
     * Tests the functionality of remote shard allocation to
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
            assertTrue(containsReplica);
        createRepositoryWithSettings(repositorySettings, repoName);  
        createRepositoryWithSettings(null, repoName);
        if (assigned) {
        SnapshotsStatusResponse snapshotsStatusResponse = client.admin()
        final int numReplicasIndex = randomIntBetween(1, 4);
        final int numShardsIndex = randomIntBetween(3, 6);
            .setPersistentSettings(Settings.builder().putNull("cluster.info.update.interval"))
            builder.execute().actionGet();  
        assertThrows(  
        final int numReplicasIndex = randomIntBetween(1, 4);  
        assertRemoteSnapshotIndexSettings(client, restoredIndexName1);  
        int nonEmptyFileCacheNodes = 0;
        assertSearchableSnapshotIndexDirectoryExistence(searchNode2, index, true);  
                    .resolve("indices")
                settingsResponse.getSetting(snapshotIndexName, IndexModule.INDEX_STORE_TYPE_SETTING.getKey())
        final int numReplicasIndex2 = 1;
        final String indexName1 = "test-idx-1";
        logger.info("--> restore indices as 'remote_snapshot'");
            for (int i = 0; i < builders.length; i++) {
            final IndexRequestBuilder builder = client().prepareIndex(index);  
        client.admin()
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);  
        deleteIndicesAndEnsureGreen(client, indexName2);  
            assertTrue(Files.isDirectory(fileCachePath));  
                }
                .actionGet()  
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;  
        );
        final ClusterState state = clusterService().state();
        assertThrows(  
            assertIndexAssignedToNodeOrNot(restoredIndexName, pickedNode, false);
import java.util.stream.IntStream;
            .prepareUpdateSettings()
        createRepositoryWithSettings(null, repoName);
import org.opensearch.node.Node;
            final List<ShardIterator> iterators = iterableAsArrayList(shardIterators);
                assertTrue(s.getShards().get(0).getStats().getTotalFileCount() > 0);
        settings.put("chunk_size", chunkSize, ByteSizeUnit.BYTES);
            builder.execute().actionGet();
            }
            final UpdateSettingsRequestBuilder builder = client().admin().indices().prepareUpdateSettings(index);
        ensureGreen();  
            .prepareUpdateSettings()
        final String cfsIndex = "test-idx-cfs";  
            // Get the primary shards for the given index
            .setWaitForEvents(Priority.LANGUID)  
        internalCluster().startNodes(2, clusterManagerNodeSettings);
        createRepositoryWithSettings(null, repoName);  
        final String indexName2 = "test-idx-2";  
    public void cleanup() throws Exception {  
    public void testSearchableSnapshotAllocationForFailoverAndRecovery() throws Exception {
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
    private void restoreSnapshotAndEnsureGreen(Client client, String snapshotName, String repoName) {  
            .prepareReroute()
        assertSearchableSnapshotIndexDirectoryExistence(searchNode1, index, false);
    }  
        }
        deleteIndicesAndEnsureGreen(client, indexName1);
        NodesStatsResponse postRestoreStats = client().admin().cluster().nodesStats(new NodesStatsRequest().all()).actionGet();
     * taking a snapshot, restoring it as a searchable snapshot index.
        final String snapshotName = "test-snap";
        createIndexWithDocsAndEnsureGreen(0, 100, indexName);
import org.opensearch.common.settings.SettingsException;
import org.opensearch.index.shard.ShardPath;  
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
        );
     * Tests a happy path scenario for searchable snapshots by creating 2 indices,  
        assertDocCount(restoredIndexName, 100L);  
            .actionGet();  
            .get();  
        flushAndRefresh(cfsIndex, nonCfsIndex);
                assertNull(fcStats);  
        testUpdateIndexSettingsAtLeastOneNotAllowedSettings(restoredIndexName);
            SettingsException.class,
        final String repeatIndexNamePrefix = indexName + "-copy-";
                    .resolve(index.getUUID())
import org.opensearch.action.index.IndexRequestBuilder;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShardsIndex)
                .setRenamePattern("(.+)")
            .setRenamePattern("(.+)")
        final Client client = client();  
        }
        final String indexName1 = "test-idx-1";
        ensureGreen();  
        final String indexName = "test-idx";
        takeSnapshot(client, snapshotName, repoName, indexName);  
        final String indexName = "test-index";
        internalCluster().ensureAtLeastNumWarmAndDataNodes(numReplicasIndex + 1);
    }
                // index and assert it does not exist
            if (preRestoreStat.getNode().isWarmNode()) {
        ensureGreen(restoredIndexName);
        deleteIndicesAndEnsureGreen(client, indexName1);
    }  
import static org.opensearch.test.NodeRoles.onlyRoles;  
    /**  
        }  
        }
            assertDocCount(restoredIndexName, 100L);
     * It ensures file cache is restored post node restart.  
        NodesStatsResponse preRestoreStats = client().admin().cluster().nodesStats(new NodesStatsRequest().all()).actionGet();
            Settings.builder()  
        assertEquals("All blocks should be unpinned " + context, 0, pinnedCount);
    }  
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
        final String indexName = "test-index";
            .setTimeout(new TimeValue(5, TimeUnit.MINUTES))
        final String snapshotName2 = "test-snap";
import static org.hamcrest.Matchers.containsString;  
        assertDocCount("remote-" + indexName1, 50L);
        internalCluster().startNodes(2, dateNodeSettings);  
            .getGroups();
        createRepositoryWithSettings(null, repoName);
            .add(new MoveAllocationCommand(restoredIndexName, 0, searchNode1, searchNode2))  
        createRepositoryWithSettings(null, repoName);
     * is primary shards  
            .cluster()
        final String indexName = "test-idx";
        final String snapshotName = "test-snap";  
            final String restoredIndexName = indexName + "-copy-" + (i + 1);
        final Client client = client();  
        assertEquals(snapshotIndexNames.length, settingsResponse.getIndexToSettings().keySet().size());
        }
        final String restoredIndexName = indexName + "-copy";
    /**
import org.opensearch.cluster.ClusterState;
            createRepository(repoName, FsRepository.TYPE);
     * Asserts the cache folder count to match the number of shards and the number of indices within the cache folder
        // is thrown.
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
        assertDocCount(indexName, 100L);
        final UpdateSettingsRequestBuilder builder = client().admin().indices().prepareUpdateSettings(index);
        for (String snapshotIndexName : snapshotIndexNames) {
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);  
        throws InterruptedException {  
        internalCluster().ensureAtLeastNumWarmNodes(1);
        deleteIndicesAndEnsureGreen(client, indexName);  
        final String repoName = "test-repo";
import org.hamcrest.MatcherAssert;
                final Path file = PathUtils.get(path)  
            assertEquals(  
        createRepositoryWithSettings(null, repoName);
        internalCluster().startNode(Settings.builder().put(onlyRole(DiscoveryNodeRole.WARM_ROLE)));
        createRepositoryWithSettings(null, repoName);
        );
        deleteIndicesAndEnsureGreen(client, indexName);  
        final String restoredIndexName = indexName + "-copy";
            if (stats.getNode().isWarmNode()) {
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);  
        // Ensures that the compatible shards are not just primaries
    public void testCreateSearchableSnapshotWithSpecifiedRemoteDataRatio() throws Exception {
        assertDocCount(indexName + "-copy-0", 100L);
                .prepareHealth()  
        final int numReplicasIndex1 = randomIntBetween(1, 4);  
            SnapshotInUseDeletionException.class,  
        // restore the index as a searchable snapshot
     * as provided.  
        final String repoName = "test-repo";
            MatcherAssert.assertThat(e.blocks(), contains(IndexMetadata.REMOTE_READ_ONLY_ALLOW_DELETE));
        createIndexWithDocsAndEnsureGreen(numReplicasIndex, 100, indexName);
        Iterable<Node> nodes = internalCluster().getInstances(Node.class);  
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);  
        createRepositoryWithSettings(null, repoName);
     */  
        logger.info("--> validate cache file path is deleted");
            )
        createIndexWithDocsAndEnsureGreen(0, 100, indexName);
import org.opensearch.common.Priority;
                .cluster()
import java.util.stream.Stream;  
            containsString(
        final String restoredIndexName = indexName + "-copy";
            final UpdateSettingsRequestBuilder builder = client().admin().indices().prepareUpdateSettings(index);  
                .setTransientSettings(Settings.builder().put(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5))  
            }  
    }
        assertDocCount(restoredIndexName, 100L);
        final Map<String, List<String>> snapshotInfoMap = response.getSnapshots()
     */
        final String restoredIndexName = indexName + "-copy";  
        Settings clusterManagerNodeSettings = clusterManagerOnlyNode();  
     */
        deleteIndicesAndEnsureGreen(client, indexName);
        // test start non-dedicated warm node  
            deleteIndicesAndEnsureGreen(client, "_all");  
     * Test scenario that checks the cache folder location on warm nodes for the restored index on snapshot restoration
        // ClusterSearchShards API returns a list of shards that will be used
        // Disable check_on_startup: Lucene's CodecUtil.checksumEntireFile() clones IndexInput  
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
        takeSnapshot(client, snapshotName, repoName, indexName1, indexName2);
        final Client client = client();
            .waitForCompletion(true);  
        assertCacheDirectoryReplicaAndIndexCount(numShards, 1);
        final Client client = client();  
                .execute()
                .setTimeout(new TimeValue(5, TimeUnit.MINUTES))  
    }
            }
    private void assertIndexingBlocked(String index) {
    }
        final SnapshotRestoreException error = expectThrows(
        createRepositoryWithSettings(null, repoName);
        final String indexName = "test-index";
        internalCluster().ensureAtLeastNumWarmNodes(1);  
            .waitForCompletion(true);
            // Randomly pick one of the shards
        final Path indexPath = node.getNodeEnvironment().fileCacheNodePath().indicesPath.resolve(index.getUUID());
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
        // without closing it, leaving file cache blocks pinned until GC. The test framework
    public void testSearchableSnapshotIndexIsReadOnly() throws Exception {  
                Map.of("index.max_result_window", 5000, "index.search.slowlog.threshold.query.warn", "15s", "index.refresh_interval", 10)
        final Client client = client();  
            fail("Expected operation to throw an exception");
        }  
     * ensure it can handle node drops for failover scenarios and the cluster gets back to a healthy state when
        final String snapshotName = "test-snap";  
        final String repoName = "test-repo";  
        createIndexWithDocsAndEnsureGreen(0, 100, indexName);
            )
            assertIndexAssignedToNodeOrNot(indexName, pickedNode, true);
import org.opensearch.transport.client.Client;  
        internalCluster().ensureAtLeastNumDataNodes(numNodes);
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
        internalCluster().ensureAtLeastNumWarmAndDataNodes(numShardsIndex);  
            assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));  
            .cluster()
        createRepositoryWithSettings(repositorySettings, repoName);
        assertBusy(() -> {
    private void testUpdateIndexSettingsOnlyAllowedSettings(String index) {  
        builder.setSettings(
        deleteIndicesAndEnsureGreen(client, indexName);
        final String repoName = "test-repo";
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
    /**
        internalCluster().ensureAtLeastNumDataNodes(2);  
        internalCluster().stopRandomWarmNode();
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        final String snapshotName = "test-snap";
        ensureRed(restoredIndexName);
        final Map<String, List<String>> expect = new HashMap<>();
     * warm role capabilities.  
    public void testSearchableSnapshotAllocationFilterSettings() throws Exception {
            .put(IndexSettings.INDEX_CHECK_ON_STARTUP.getKey(), "false");  
        NodesStatsResponse response = client().admin().cluster().nodesStats(new NodesStatsRequest().all()).actionGet();
        deleteIndicesAndEnsureGreen(client, restoredIndexName);
    }  
        internalCluster().ensureAtLeastNumDataNodes(1);
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
            // Get the file system stats for the assigned node
        // collect the path for all the cache locations on warm nodes.  
        final String snapshotName = "test-snap";
                .execute()
                .setWaitForCompletion(true)
        createIndexWithDocsAndEnsureGreen(numReplicas, 100, indexName);  
        deleteIndicesAndEnsureGreen(client, indexName1);  
        }
            fail("Expected operation to throw an exception");  
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;  
        takeSnapshot(client, initSnapName, repoName, indexName);
        }
     * repository to the node's local disk for a remote snapshot index.
        final String snapshotName2 = "test-snap-2";
        for (ClusterSearchShardsGroup shardsGroup : shardGroups) {
            .prepareSnapshotStatus(repoName)  
        ensureGreen();  
        final Path indexDataPath = node.getNodeEnvironment().fileCacheNodePath().fileCachePath.resolve(index.getUUID());
        settings.put("location", randomRepoPath()).put("compress", randomBoolean());
            warmNodes.remove(pickedNode);
        createIndexWithDocsAndEnsureGreen(numReplicasIndex, 1000, indexName);
        internalCluster().ensureAtLeastNumWarmNodes(numNodes);
        createIndexWithDocsAndEnsureGreen(0, 100, indexName1);
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);  
        );
        final String indexName = "test-idx";
            fail("Expected operation to throw an exception");  
        assertTrue(client.admin().indices().prepareDelete(indices).get().isAcknowledged());
            .prepareHealth()
        final String restoredIndexName = indexName + "-copy";
            final String repeatedSnapshotName = repeatSnapNamePrefix + i;
            .collect(Collectors.toList());
    }
        final String snapshotName = "test-snap";  
            assertTrue(shardsGroup.getShards().length > 1);  
            .actionGet();
            .prepareRestoreSnapshot(repoName, initSnapName)  
    }
        final String snapshotName = "test-snap";
    }
                    .actionGet()
            .execute()  
                client.admin()
     */
        );  
            .cluster()
    public void testFileCacheStats() throws Exception {
        final Settings.Builder settings = Settings.builder();
import static org.opensearch.core.common.util.CollectionUtils.iterableAsArrayList;
        assertDocCount(restoredIndexName, 100L);
            }
            SettingsException.class,
        internalCluster().ensureAtLeastNumWarmAndDataNodes(numReplicasIndex + 1);  
        final int numReplicasIndex1 = 1;  
                IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey(),
            if (nodeStats.getNode().isWarmNode()) {  
    }
import static org.opensearch.index.store.remote.filecache.FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING;
                .build()
            .collect(Collectors.toMap(s -> s.snapshotId().getName(), SnapshotInfo::indices));
    private void assertRemoteSnapshotIndexSettings(Client client, String... snapshotIndexNames) {
     * ensure it can assign remote shards to a node with local shards given it has the
            .setWaitForCompletion(true)
        }  
        ensureGreen();
                    .setSettings(Settings.builder().put("index.routing.allocation.exclude._id", pickedNode))
        // Test that the searchable snapshot index can continue to be snapshotted and restored
        assertIndexDirectoryDoesNotExist(restoredIndexName);
        final String indexName2 = "test-idx-2";
import org.opensearch.cluster.node.DiscoveryNode;
        final String repoName = "test-repo";  
    }
        }  
                .prepareRestoreSnapshot(repoName, snapshotName)  
            IndexNotFoundException.class,
            .setRenameReplacement("$1-copy")  
            .execute()
        takeSnapshot(client, snapshotName2, repoName, indexName2);
    private void assertIndexAssignedToNodeOrNot(String index, String node, boolean assigned) {  
        final Client client = client();
            } else {
        final String restoredIndexName = indexName + "-copy";
        }
        assertDocCount(restoredIndexName, 100L);
                .prepareUpdateSettings()
            assertTrue(shardRouting.primary());  
            .renamePattern("(.+)")  
    public void testSnapshottingSearchableSnapshots() throws Exception {
import org.opensearch.monitor.fs.FsInfo;  
        // test start dedicated warm node
        // test start non-dedicated warm node, if the user doesn't configure the cache size, it fails
     */
                        .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)
        final int numReplicasIndex1 = randomIntBetween(1, 4);
        final Client client = client();
        int pinnedCount = 0;  
        // create an index, add data, snapshot it, then delete it
    protected Settings.Builder randomRepositorySettings() {  
import java.util.HashMap;
        createRepositoryWithSettings(null, repoName);
        // Create an index, snapshot and restore as a searchable snapshot index
            "Expect index to not exist",
        Map<String, NodeStats> preRestoreStatsMap = preRestoreStats.getNodesMap();  
    }
        final String restoredIndexName = indexName + "-copy";
    }
        createIndexWithDocsAndEnsureGreen(numReplicasIndex1, 100, indexName1);
                        pinnedCount++;
        createIndexWithDocsAndEnsureGreen(numReplicasIndex1, 100, indexName1);
 * SPDX-License-Identifier: Apache-2.0
        } catch (ClusterBlockException e) {
import org.opensearch.index.IndexModule;  
        assertIndexDirectoryDoesNotExist(restoredIndexName1, restoredIndexName2);
        final String repoName = "test-repo";  
            assertIndexAssignedToNodeOrNot(restoredIndexName, pickedNode, true);  
        // The local cache files should be closed by deleting the restored index
            .filter(DiscoveryNode::isWarmNode)
            if (node.fileCache() == null) continue;
    public void testFileCacheRestore() throws Exception {
        final String repoName = "test-repo";  
        takeSnapshot(client, snapshotName, repoName, indexName1, indexName2);
        }  
            Map.of("index.max_result_window", 1000, "index.search.slowlog.threshold.query.warn", "10s", "index.number_of_replicas", 0)  
        final String repoName = "test-repo";  
                    .resolve("index");
        createRepositoryWithSettings(null, repoName);  
     * Tests a default 8mib chunked repository scenario for searchable snapshots by creating an index,  
            ClusterHealthResponse clusterHealthResponse = client.admin()
        // non-deterministically.  
    private void testUpdateIndexSettingsOnlyNotAllowedSettings(String index) {
        assertDocCount("remote-" + indexName2, 50L);  
        takeSnapshot(client, snapshotName, repoName, indexName);
        assertThrows(
        assertDocCount(restoredIndexName2, 100L);
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;  
            );  
        final String restoredIndexName2 = indexName2 + "-copy";
        final ShardId shardId = new ShardId(index, 0);
        assertAcked(
        // Ensure when no preferences are set (default preference), the only compatible shards are primary  
        final String indexName = "test-idx-1";  
        snapshotsStatusResponse.getSnapshots().forEach(s -> {
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
        deleteIndicesAndEnsureGreen(client, indexName1, indexName2);  
        assertNodesFileCacheNonEmpty(numNodes);
     * nodes with warm capabilities are added back to the cluster.  
                builders[i] = client().prepareIndex(indexName).setId(Integer.toString(i)).setSource("field1", "bar " + i);  
        assertCacheDirectoryReplicaAndIndexCount(numShards, 0);  
                    Integer refCount = node.fileCache().getRef(blockFile);
    public void testRestoreRemoteSnapshotWithNullShardSizes() throws Exception {  
            .actionGet();
            builder.setSettings(  
            client.admin().indices().prepareForceMerge(indexName).setMaxNumSegments(1).get();  
        deleteIndicesAndEnsureGreen(client, restoredIndexName1);  
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);  
        for (Path fileCachePath : searchNodeFileCachePaths) {
        final Client client = client();
    private void assertNodesFileCacheNonEmpty(int numNodes) {
            .renameReplacement("remote-$1")
                for (Path blockFile : blockFiles) {
            .setWaitForCompletion(true)
     */
            ensureGreen();  
    }  
        assertThat(settingsResponse, notNullValue());  
        for (String indexName : indexNames) {
import java.io.IOException;
        internalCluster().ensureAtLeastNumDataNodes(numReplicasIndex + 1);
        internalCluster().ensureAtLeastNumWarmNodes(Math.max(numReplicasIndex1, numReplicasIndex2) + 1);  
        final Client client = client();
        assertBusy(() -> {  
        // Assert all the snapshots exist. Note that AbstractSnapshotIntegTestCase::assertRepoConsistency
        logger.info("--> stop the last warm node");  
    private void assertAllNodesFileCacheEmpty() {
        createIndexWithDocsAndEnsureGreen(0, 100, indexName);
        final Index index = resolveIndex(restoredIndexName);
    /**  
            NodeStats postRestoreStat = postRestoreStatsMap.get(node);
     *
    private boolean isFileCacheEmpty(AggregateFileCacheStats stats) {
            .setRenamePattern("(.+)")
 * Copyright OpenSearch Contributors
            .execute()
        client.admin()  
            .map(node -> node.getNodeEnvironment().fileCacheNodePath().fileCachePath)  
        assertRemoteSnapshotIndexSettings(client, restoredIndexName1, restoredIndexName2);
        testUpdateIndexSettingsOnlyAllowedSettings(restoredIndexName);  
                    }  
        final String repoName = "test-repo";  
        }, 30, TimeUnit.SECONDS);  
        deleteIndicesAndEnsureGreen(client, indexName1);
            .cluster()
            .cluster()  
}
        NodesStatsResponse response = client().admin().cluster().nodesStats(new NodesStatsRequest().all()).actionGet();  
        internalCluster().ensureAtLeastNumWarmNodes(numReplicasIndex1 + 1);
        final String repoName = "test-repo";
import static org.hamcrest.Matchers.notNullValue;
        );
        final String indexName = "test-idx";
     */
        // Verifies if all the shards (primary and replica) have been deleted
        assertEquals(expect, snapshotInfoMap);
            );
        assertDocCount(restoredIndexName1, 100L);  
                assertEquals(preRestoreStat.getFileCacheStats().getUsed(), postRestoreStat.getFileCacheStats().getUsed());  
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
        createIndex(
        List<Path> searchNodeFileCachePaths = StreamSupport.stream(nodes.spliterator(), false)
    }  
                        logger.warn("--> [{}] PINNED block={}, refCount={}", context, blockFile.getFileName(), refCount);
        final String indexName1 = "test-idx-1";
        internalCluster().ensureAtLeastNumDataNodes(1);
            AggregateFileCacheStats fcStats = stats.getFileCacheStats();  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
import org.opensearch.cluster.routing.ShardIterator;
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
        internalCluster().ensureAtLeastNumDataNodes(Math.max(numReplicasIndex1, numReplicasIndex2) + 1);  
     * fetched during DirectoryReader.open() should be unpinned (refCount=0)
            String pickedNode = randomFrom(warmNodes);
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsGroup;
                    if (refCount != null && refCount > 0) {  
    }  
                Settings.builder().put(onlyRoles(Set.of(DiscoveryNodeRole.WARM_ROLE, DiscoveryNodeRole.DATA_ROLE)))
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
        final String indexName2 = "test-idx-2";
                Settings.builder().put(onlyRoles(Set.of(DiscoveryNodeRole.WARM_ROLE, DiscoveryNodeRole.DATA_ROLE)))  
            assertTrue(shardsGroup.getShards()[0].primary());  
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);  
import static org.opensearch.test.NodeRoles.dataNode;
        final Client client = client();
        assertNoPinnedBlocks("after restore");  
                .setIndexSettings(  
        takeSnapshot(client, snapshotName1, repoName, indexName1);
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
        final String snapshotName = "test-snap";  
    public void testCreateSearchableSnapshotWithDefaultChunks() throws Exception {  
        assertAcked(
import org.opensearch.cluster.node.DiscoveryNodeRole;
            }  
        Settings.Builder repositorySettings = chunkedRepositorySettings(2 << 23);
            .actionGet();
            .setStorageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)
        // randomizes this setting, which would cause assertNoPinnedBlocks to fail
        }
        deleteIndicesAndEnsureGreen(client, indexName);
        takeSnapshot(client, snapshotName1, repoName, indexName1);  
        deleteIndicesAndEnsureGreen(client, indexName);  
            final ShardRouting shardRouting = shardIterator.nextOrNull();
                .cluster()
            .filter(node -> node.fileCache() != null)
    /**
import static org.hamcrest.Matchers.is;  
     * Tests the functionality of remote shard allocation to
        internalCluster().ensureAtLeastNumWarmNodes(Math.max(numReplicasIndex1, numReplicasIndex2) + 1);
                .map(shardRouting -> !shardRouting.primary())
                MatcherAssert.assertThat("Expect file not to exist: " + file, Files.exists(file), is(false));
        // set "index.store.type" to "remote_snapshot" in index settings of restore API and assert appropriate exception with error message  
            final GroupShardsIterator<ShardIterator> shardIterators = state.getRoutingTable()
                .setRenameReplacement("$1" + (i + 1))
                .execute()
        // relocate the shard from node1 to node2
        createRepositoryWithSettings(null, repoName);  
            assertTrue(Files.exists(fileCachePath));
import org.opensearch.cluster.routing.ShardRouting;
    }  
            .actionGet()  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;  
        AcknowledgedResponse settingsResponse = builder.execute().actionGet();
            assertTrue("shard cache path should " + (exists ? "exist" : "not exist"), Files.exists(shardPath.getDataPath()) == exists);
        takeSnapshot(client, snapshotName, repoName, indexName1);  
        assertIndexDirectoryDoesNotExist(indexName + "-copy-0");  
        return false;
        ClusterSearchShardsGroup[] shardGroups = client.admin()  
                    .execute()  
        assertAllNodesFileCacheEmpty();
    }
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
        Settings.Builder commonSettings = Settings.builder()
        logger.info("--> Take a snapshot");
        }  
            SnapshotRestoreException.class,  
            assertIndexDirectoryDoesNotExist(restoredIndexName);  
            assertTrue("index cache path should " + (exists ? "exist" : "not exist"), Files.exists(indexPath) == exists);
    private void createIndexWithDocsAndEnsureGreen(int numReplicasIndex, int numOfDocs, String indexName) throws InterruptedException {
            if (snapName.equals("initial-snapshot")) {
        final String initSnapName = "initial-snapshot";
        final String indexName = "test-idx";
        final int numShards = numReplicas + 1;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertIndexDirectoryDoesNotExist(restoredIndexName1, restoredIndexName2);
import java.util.Arrays;
        internalCluster().ensureAtLeastNumWarmNodes(1);  
        final Client client = client();
import org.opensearch.cluster.metadata.IndexMetadata;  
        for (String node : postRestoreStatsMap.keySet()) {
        final int numReplicasIndex = 0;
        final String indexName2 = "test-index2";
            );  
     * Tests a small 1000 bytes chunked repository scenario for searchable snapshots by creating an index,
            builder.execute().actionGet();
        createIndexWithDocsAndEnsureGreen(numReplicasIndex, 100, indexName);  
import org.opensearch.core.index.shard.ShardId;
import java.util.concurrent.TimeUnit;  
    }
        final ShardPath shardPath = ShardPath.loadFileCachePath(node.getNodeEnvironment(), shardId);  
            .setIndices(indices)  
        // The index count will be 0 since the only restored index "test-idx-copy" was deleted
                .cluster()  
        internalCluster().ensureAtLeastNumWarmNodes(numReplicasIndex + 2);
    /**
import static org.opensearch.test.NodeRoles.onlyRole;
        takeSnapshot(client, snapshotName, repoName, indexName1);
import static org.hamcrest.Matchers.contains;
        MatcherAssert.assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));  
        final Client client = client();
        return settings;
        });
    }
        for (NodeStats stats : response.getNodes()) {
        final String repoName = "test-repo";
            assertEquals(1, s.getShards().size());
        final Client client = client();  
        internalCluster().stopRandomWarmNode();
            assertTrue(state.getRoutingTable().allShards(index).stream().anyMatch(shard -> shard.currentNodeId().equals(node)));  
                assertTrue(snapName.startsWith(repeatSnapNamePrefix));  
                .setWaitForEvents(Priority.LANGUID)
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;
    @After
package org.opensearch.snapshots;
    }
        createIndexWithDocsAndEnsureGreen(numShardsIndex, 1, 100, indexName);
        createRepositoryWithSettings(null, repoName);  
        createIndex(cfsIndex, commonSettings.build());
        } catch (ClusterBlockException e) {
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.FS.getSettingsKey())
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
        for (NodeStats stats : response.getNodes()) {  
import java.util.Set;
        assertDocCount(nonCfsIndex + "-copy", 100L);
        // Walk through the cache directory on nodes  
            indexRandom(true, false, builders);
        }
            for (FsInfo.Path info : nodeStats.getNodes().get(0).getFs()) {
     * Picks a shard out of the cluster state for each given index and asserts  
            .cluster()
                    .resolve(Integer.toString(shardRouting.getId()))  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;  
    public void testDeleteSearchableSnapshotBackingIndexThrowsException() throws Exception {
            takeSnapshot(client, repeatedSnapshotName, repoName);
    private void takeSnapshot(Client client, String snapshotName, String repoName, String... indices) {  
        internalCluster().ensureAtLeastNumWarmNodes(1);
        RestoreSnapshotRequest secondRestore = new RestoreSnapshotRequest(repoName, snapshotName2).indices(indexName2)
public final class SearchableSnapshotIT extends AbstractSnapshotIntegTestCase {
        final Node node = internalCluster().getInstance(Node.class, nodeName);
        client().admin().cluster().deleteSnapshot(new DeleteSnapshotRequest(repoName, snapshotName1)).actionGet();
        );
        Settings dateNodeSettings = dataNode();
        takeSnapshot(client, snapshotName, repoName, indexName);
    private Settings.Builder chunkedRepositorySettings(long chunkSize) {
            )  
/*  
        // when querying a particular index
                    nonEmptyFileCacheNodes++;  
            }
            .stream()  
     */  
    private void assertNoPinnedBlocks(String context) throws IOException {
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())  
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
            .renameReplacement("remote-$1")
        assertEquals(numCacheFolderCount, searchNodeFileCachePaths.size());  
                )  
    private void deleteIndicesAndEnsureGreen(Client client, String... indices) {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicasIndex)
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
    public void testStartSearchNode() throws Exception {  
    public void testSearchableSnapshotAllocationForLocalAndRemoteShardsOnSameNode() throws Exception {
        takeSnapshot(client, snapshotName, repoName, indexName);
        final String snapshotName1 = "test-snapshot1";
        final String repeatSnapNamePrefix = "test-repeated-snap-";  
            () -> client.admin().indices().prepareGetIndex().setIndices(restoredIndexName).execute().actionGet()  
        try {
            .renamePattern("(.+)")
        final String snapshotName1 = "test-snap-1";
import org.opensearch.repositories.fs.FsRepository;
        createIndexWithDocsAndEnsureGreen(numReplicasIndex1, 100, indexName1);
        deleteIndicesAndEnsureGreen(client, indexName);
     * Tests file cache restore scenario for searchable snapshots by creating an index,
        GetSettingsResponse settingsResponse = client.admin()  
        createIndexWithDocsAndEnsureGreen(numReplicasIndex, 1000, indexName);
        final String restoredIndexName = indexName + "-copy";  
                .prepareUpdateSettings()
        for (ClusterSearchShardsGroup shardsGroup : shardGroups) {
        takeSnapshot(client, snapshotName, repoName, indexName);  
import org.opensearch.core.index.Index;
     */
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;  
            () -> client().admin().cluster().deleteSnapshot(new DeleteSnapshotRequest(repoName, snapshotName)).actionGet()
import static org.opensearch.test.NodeRoles.clusterManagerOnlyNode;  
     * Uses index.codec=default to avoid AssertingCodec (test-only codec that creates extra clones)  
                .setTransientSettings(Settings.builder().putNull(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey()))
     * Test scenario that validates that the default warm preference for searchable snapshot
    }
            .map(DiscoveryNode::getId)  
            final Index index = state.metadata().index(indexName).getIndex();  
        createIndexWithDocsAndEnsureGreen(1, 100, indexName1);
        RestoreSnapshotRequest firstRestore = new RestoreSnapshotRequest(repoName, snapshotName1).indices(indexName1)
        final int numReplicasIndex = 1;  
        );
            IndexRequestBuilder[] builders = new IndexRequestBuilder[100];
        }
        restoreSnapshotAndEnsureGreen(client, snapshotName2, repoName);  
        createIndex(nonCfsIndex, Settings.builder().put(commonSettings.build()).put("index.compound_format", false).build());  
        internalCluster().ensureAtLeastNumDataNodes(numReplicasIndex + 1);
        final String restoredIndexName1 = indexName1 + "-copy";  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        settings.put(FsRepository.BASE_PATH_SETTING.getKey(), "my_base_path");  
        final String indexName1 = "test-idx-1";
    }  
                internalCluster().restartNode(nodeStats.getNode().getName());
        client.admin().cluster().restoreSnapshot(secondRestore).get();
        // test start node without warm role  
        final String snapshotName = "test-snap";
        createIndexWithDocsAndEnsureGreen(numReplicasIndex2, 100, indexName2);
                .prepareRestoreSnapshot(repoName, repeatedSnapshotName)  
        assertDocCount(restoredIndexName, 1000L);  
        ensureYellow(restoredIndexName);  
import java.util.Map;
        final String snapshotName = "test-snap";
import org.opensearch.index.IndexNotFoundException;
            builder.setSource("foo", "bar");
            () -> client.admin()
        assertThat(
        try {
        final Client client = client();
import org.opensearch.cluster.routing.GroupShardsIterator;  
        // Get the available NodeEnvironment instances
        return stats.getUsed().getBytes() == 0L && stats.getActive().getBytes() == 0L;
        } else {
            .cluster()  
        createIndexWithDocsAndEnsureGreen(numReplicas, 100, indexName);  
                .setWaitForNoRelocatingShards(true)
        assertDocCount(restoredIndexName1, 100L);  
        internalCluster().ensureAtLeastNumDataNodes(numReplicasIndex1 + 1);  
    private void assertIndexDirectoryDoesNotExist(String... indexNames) {  
    }  
        internalCluster().stopRandomWarmNode();
import java.nio.file.Path;  
            .execute()
        for (int i = warmNodes.size(); i > 2; --i) {  
    }  
        assertSearchableSnapshotIndexDirectoryExistence(searchNode1, index, true);
            MatcherAssert.assertThat(e.blocks(), contains(IndexMetadata.REMOTE_READ_ONLY_ALLOW_DELETE));
        ensureGreen("remote-" + indexName2);  
        takeSnapshot(client, snapshotName, repoName, indexName);  
        String[] snapNames = new String[5];
            .get();
                    .indices()  
        } catch (ClusterBlockException e) {
        createIndexWithDocsAndEnsureGreen(0, 50, indexName1);
            client.admin()
            builder.setSettings(Map.of("index.refresh_interval", 10));
     * so the file cache can evict them under LRU pressure.  
        String searchNode1 = internalCluster().startWarmOnlyNodes(1).get(0);
            indexName,
        final String restoredIndexName = indexName + "-copy";  
        client.admin()
        takeSnapshot(client, snapshotName, repoName, indexName);
        for (String indexName : new String[] { cfsIndex, nonCfsIndex }) {  
                .reduce(false, (s1, s2) -> s1 || s2);  
                "cannot restore remote snapshot with index settings \"index.store.type\" set to \"remote_snapshot\". Instead use \"storage_type\": \"remote_snapshot\" as argument to restore."
            boolean containsReplica = Arrays.stream(shardsGroup.getShards())
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)  
import org.junit.After;
        }, 30, TimeUnit.SECONDS);
            .getGroups();
        takeSnapshot(client, snapshotName, repoName, indexName);
            .indices()
            assertEquals(1, shardsGroup.getShards().length);
     * @param numIndexCount total number of index folder locations that should exist within the cache folder
            final String nodeId = shardRouting.currentNodeId();  
    private void assertSearchableSnapshotIndexDirectoryExistence(String nodeName, Index index, boolean exists) throws Exception {  
        final int numReplicas = 1;  
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
        createRepositoryWithSettings(null, repoName);  
            .actionGet();  
     * Tests both CFS (compound file) and non-CFS indexes in a single snapshot/restore cycle.
        internalCluster().ensureAtLeastNumWarmNodes(1);  
     * Ensures availability of sufficient data nodes and warm capable nodes.
        // will run after this test (and all others) and assert on the consistency of the data in the repo.  
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
        final Client client = client();
     * @param numCacheFolderCount total number of cache folders that should exist for the test case
            );  
            MatcherAssert.assertThat(e.blocks(), contains(IndexMetadata.REMOTE_READ_ONLY_ALLOW_DELETE));  
                // Build the expected path for the index data for a "normal"  
            .get();
        client.admin().cluster().restoreSnapshot(firstRestore).get();
        shardGroups = client.admin()
                List<Path> blockFiles = paths.filter(Files::isRegularFile).collect(Collectors.toList());  
        internalCluster().startNode(Settings.builder().put(onlyRole(DiscoveryNodeRole.DATA_ROLE)));
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequestBuilder;
            final ShardIterator shardIterator = RandomPicks.randomFrom(random(), iterators);  
        final String repoName = "test-repo";  
        assertDocCount(restoredIndexName, 100);
    @Override  
    }
        createRepositoryWithSettings(null, repoName);
                    .isAcknowledged()
import org.opensearch.core.common.unit.ByteSizeUnit;  
    }  
                .actionGet();
            client().admin()
        internalCluster().ensureAtLeastNumWarmNodes(2);
        final Client client = client();
        if (repositorySettings == null) {  
     * After a searchable snapshot restore completes, all file cache blocks
            }
        internalCluster().validateClusterFormed();
        final String repoName = "test-repo";
    /**
     */
        assertTrue(client.admin().indices().prepareDelete(restoredIndexName).get().isAcknowledged());
                }
        createIndexWithDocsAndEnsureGreen(numReplicasIndex2, 100, indexName2);
                .actionGet();
        createIndexWithDocsAndEnsureGreen(numReplicasIndex, 100, indexName);
        final String snapshotName = "test-snap";
        final String repoName = "test-repo";
                assertNotNull(s.getIndices().get(repeatIndexNamePrefix + snapName.substring(repeatSnapNamePrefix.length())));
    public void testCreateSearchableSnapshot() throws Exception {
        assertAllNodesFileCacheEmpty();
    }
        final String repoName = "test-repo";
     * taking a snapshot, restoring it as a searchable snapshot.
        ensureGreen(restoredIndexName);  
        final String indexName = "test-idx";
        final String repoName = "test-repo";
    public void testDeleteSearchableSnapshotBackingIndex() throws Exception {
import org.opensearch.common.io.PathUtils;
                .setRenameReplacement("$1-copy")
     * and dummyDocuments=false for a clean single-segment layout after force merge.
            }
        final String snapshotName = "test-snap";
    private void createRepositoryWithSettings(Settings.Builder repositorySettings, String repoName) {
        internalCluster().ensureAtLeastNumWarmNodes(numReplicasIndex + 1);
        // Setup cluster with delayed ClusterInfo updates to simulate null shard sizes
        final String snapshotName = "test-snap";
            .prepareCreateSnapshot(repoName, snapshotName)
        String searchNode2 = internalCluster().startWarmOnlyNodes(1).get(0);
import org.opensearch.common.settings.Settings;  
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.FS;  
                assertEquals(0L, s.getShards().get(0).getStats().getTotalFileCount());  
                .cluster()
        final int numNodes = 2;
        internalCluster().ensureAtLeastNumWarmNodes(1);  
        createIndexWithDocsAndEnsureGreen(1, numReplicasIndex, numOfDocs, indexName);
        final String repoName = "test-repo";  
     * taking a snapshot, restoring them as searchable snapshots.
        assertDocCount(restoredIndexName, 100);  
        logger.info("--> stop a random warm node");  
        final Client client = client();
            assertTrue(  
        internalCluster().ensureAtLeastNumDataNodes(1);
        final String repoName = "test-repo";  
        final String indexName = "test-idx";
            }
                .setWaitForCompletion(true)  
            .prepareRestoreSnapshot(repoName, snapshotName)
        logger.info("--> add 3 new warm nodes");
        IntStream.range(0, 4).forEach(i -> snapNames[i] = repeatSnapNamePrefix + i);
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
