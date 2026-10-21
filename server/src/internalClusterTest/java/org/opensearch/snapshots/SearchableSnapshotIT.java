        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
                .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.FS.getSettingsKey())
            .setRenamePattern("(.+)")
        final Client client = client();
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
        settings.put("location", randomRepoPath()).put("compress", randomBoolean());
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
import org.opensearch.cluster.block.ClusterBlockException;
        final String restoredIndexName = indexName + "-copy";
        final Client client = client();
                .execute()
        flushAndRefresh(cfsIndex, nonCfsIndex);
                .prepareHealth()
            final List<ShardIterator> iterators = iterableAsArrayList(shardIterators);
     * and ensures the index folder is cleared on all nodes post index deletion
        }
    }
     * so the file cache can evict them under LRU pressure.
                .setTransientSettings(Settings.builder().put(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5))
                .setRenamePattern("(.+)")
                    .setSettings(Settings.builder().put("index.routing.allocation.exclude._id", pickedNode))
        // relocate the shard from node1 to node2
            assertTrue(shardRouting.primary());
                .actionGet();
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
    private void testUpdateIndexSettingsOnlyNotAllowedSettings(String index) {
        List<Path> searchNodeFileCachePaths = StreamSupport.stream(nodes.spliterator(), false)
    }
        );
            .setWaitForCompletion(true)
        // Assert all the snapshots exist. Note that AbstractSnapshotIntegTestCase::assertRepoConsistency
        final Client client = client();
            );
        final String cfsIndex = "test-idx-cfs";
        client.admin()
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        internalCluster().ensureAtLeastNumDataNodes(Math.max(numReplicasIndex1, numReplicasIndex2) + 1);
        logger.info("--> stop a random warm node");
        for (String indexName : new String[] { cfsIndex, nonCfsIndex }) {
        internalCluster().startNode(Settings.builder().put(onlyRole(DiscoveryNodeRole.DATA_ROLE)));
            assertTrue(state.getRoutingTable().allShards(index).stream().noneMatch(shard -> shard.currentNodeId().equals(node)));
     * and dummyDocuments=false for a clean single-segment layout after force merge.
            assertTrue("index cache path should " + (exists ? "exist" : "not exist"), Files.exists(indexPath) == exists);
        final String repoName = "test-repo";
            assertDocCount(restoredIndexName, 100L);
                .cluster()
                final String path = info.getPath();
        takeSnapshot(client, snapshotName, repoName, indexName);
        internalCluster().ensureAtLeastNumWarmAndDataNodes(numShards);
        final Settings.Builder settings = Settings.builder();
        deleteIndicesAndEnsureGreen(client, indexName);
    }
        createRepositoryWithSettings(null, repoName);
        final String restoredIndexName2 = indexName2 + "-copy";
            client.admin()
    private void createIndexWithDocsAndEnsureGreen(int numReplicasIndex, int numOfDocs, String indexName) throws InterruptedException {
            .setStorageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)
        final String repoName = "test-repo";
            .collect(Collectors.toList());
        }
        assertIndexingBlocked(restoredIndexName);
            client.admin()
        takeSnapshot(client, snapshotName, repoName, indexName1);
    }
        // restore the index as a searchable snapshot
                assertNotNull(s.getIndices().get(repeatIndexNamePrefix + snapName.substring(repeatSnapNamePrefix.length())));
    /**
        deleteIndicesAndEnsureGreen(client, indexName);
            .cluster()
        NodesStatsResponse preRestoreStats = client().admin().cluster().nodesStats(new NodesStatsRequest().all()).actionGet();
            .get();
                .prepareUpdateSettings()
            assertTrue(
                    .resolve("indices")
        final String restoredIndexName = indexName + "-copy";
            .addSnapshots(snapNames)
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequestBuilder;
            .execute()
        final int numNodes = 2;
        final String indexName1 = "test-idx-1";
        createIndexWithDocsAndEnsureGreen(numReplicasIndex1, 100, indexName1);
            error.getMessage(),
        return false;
        final Settings.Builder settings = Settings.builder();
    private void deleteIndicesAndEnsureGreen(Client client, String... indices) {
import org.opensearch.index.IndexNotFoundException;
        RestoreSnapshotRequest firstRestore = new RestoreSnapshotRequest(repoName, snapshotName1).indices(indexName1)
            .actionGet();
        for (Node node : internalCluster().getInstances(Node.class)) {
        final String snapshotName = "test-snap";
        deleteIndicesAndEnsureGreen(client, indexName1);
        final Client client = client();
        takeSnapshot(client, snapshotName, repoName, indexName);
                }
        deleteIndicesAndEnsureGreen(client, indexName1, indexName2);
        internalCluster().ensureAtLeastNumWarmNodes(1);
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.FS.getSettingsKey())
            } else {
        final String repoName = "test-repo";
    @Override
        ensureGreen();
        createRepositoryWithSettings(null, repoName);
        final String snapshotName = "test-snap";
    }
        ensureGreen();
        deleteIndicesAndEnsureGreen(client, indexName);
        }
            builder.setSource("foo", "bar");
import static org.hamcrest.Matchers.greaterThan;
        takeSnapshot(client, snapshotName, repoName, indexName);
        assertDocCount(restoredIndexName, 1000L);
        final int numNodes = 2;
    /**
    }
        assertThat(
            () -> internalCluster().startNode(
                        logger.warn("--> [{}] PINNED block={}, refCount={}", context, blockFile.getFileName(), refCount);
        final String restoredIndexName = indexName + "-copy";
            builder.setSettings(Map.of("index.refresh_interval", 10));
    public void testCreateSearchableSnapshotWithSpecifiedRemoteDataRatio() throws Exception {
        takeSnapshot(client, snapshotName1, repoName, indexName1);
                .setWaitForCompletion(true)
            assertTrue(Files.exists(fileCachePath));
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
        for (ClusterSearchShardsGroup shardsGroup : shardGroups) {
    private void testUpdateIndexSettingsOnlyAllowedSettings(String index) {
        internalCluster().ensureAtLeastNumWarmNodes(numReplicasIndex + 2);
        assertThrows(
    }
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
        snapshotsStatusResponse.getSnapshots().forEach(s -> {
    private void createIndexWithDocsAndEnsureGreen(int numShardsIndex, int numReplicasIndex, int numOfDocs, String indexName)
    private void assertSearchableSnapshotIndexDirectoryExistence(String nodeName, Index index, boolean exists) throws Exception {
     * Picks a shard out of the cluster state for each given index and asserts
        );
        assertEquals(numNodes, nonEmptyFileCacheNodes);
            .setRenameReplacement("$1-copy-0")
            .collect(Collectors.toSet());
        createIndexWithDocsAndEnsureGreen(numReplicasIndex2, 100, indexName2);
            builder.execute().actionGet();
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
        // Get the available NodeEnvironment instances
        takeSnapshot(client, snapshotName, repoName, indexName);
import java.util.Arrays;
        assertCacheDirectoryReplicaAndIndexCount(numShards, 1);
        internalCluster().stopRandomWarmNode();
        assertEquals(snapshotIndexNames.length, settingsResponse.getIndexToSettings().keySet().size());
        final Client client = client();
        ensureGreen();
            // Randomly pick one of the shards
        final String indexName = "test-idx";
        }
        settings.put(FsRepository.BASE_PATH_SETTING.getKey(), "my_base_path");
        NodesStatsResponse response = client().admin().cluster().nodesStats(new NodesStatsRequest().all()).actionGet();
        final String indexName1 = "test-idx-1";
        createRepositoryWithSettings(null, repoName);
        );
import java.util.stream.IntStream;
            .prepareCreateSnapshot(repoName, snapshotName)
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
        final String repoName = "test-repo";
        createRepositoryWithSettings(null, repoName);
                List<Path> blockFiles = paths.filter(Files::isRegularFile).collect(Collectors.toList());
        createIndexWithDocsAndEnsureGreen(0, 50, indexName2);
            if (preRestoreStat.getNode().isWarmNode()) {
        // Create an index, snapshot and restore as a searchable snapshot index
     * warm role capabilities.
        createIndexWithDocsAndEnsureGreen(numReplicasIndex2, 100, indexName2);
        final int numReplicasIndex1 = randomIntBetween(1, 4);
            );
        createIndexWithDocsAndEnsureGreen(1, numReplicasIndex, numOfDocs, indexName);
            } else {
    public void testSearchableSnapshotAllocationForLocalAndRemoteShardsOnSameNode() throws Exception {
import java.util.stream.Collectors;
        final String repoName = "test-repo";
        builder.setSettings(
    /**
        createIndexWithDocsAndEnsureGreen(numShardsIndex, 1, 100, indexName);
                assertEquals(preRestoreStat.getFileCacheStats().getUsed(), postRestoreStat.getFileCacheStats().getUsed());
        takeSnapshot(client, snapshotName, repoName, indexName);
 */
            assertTrue(shardsGroup.getShards()[0].primary());
        internalCluster().ensureAtLeastNumDataNodes(numNodes);
        assertDocCount(restoredIndexName2, 100L);
        final int numReplicas = 1;
        takeSnapshot(client, initSnapName, repoName, indexName);
     * Tests the functionality of remote shard allocation to
        internalCluster().startNode(Settings.builder().put(onlyRole(DiscoveryNodeRole.WARM_ROLE)));
            }
        logger.info("--> add 3 new warm nodes");
            .add(new MoveAllocationCommand(restoredIndexName, 0, searchNode1, searchNode2))
        assertAcked(
        assertDocCount(restoredIndexName, 100L);
        if (assigned) {
        }
            if (nodeStats.getNode().isWarmNode()) {
        }
            }
                    .indices()
        assertDocCount(restoredIndexName, 100);
    /**
                .setWaitForNoRelocatingShards(true)
            .filter(DiscoveryNode::isWarmNode)
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
        Map<String, NodeStats> postRestoreStatsMap = postRestoreStats.getNodesMap();
import org.opensearch.common.io.PathUtils;
            .cluster()
        // set "index.store.type" to "remote_snapshot" in index settings of restore API and assert appropriate exception with error message
import static org.opensearch.index.store.remote.filecache.FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING;
        deleteIndicesAndEnsureGreen(client, indexName);
            .prepareRestoreSnapshot(repoName, initSnapName)
            if (stats.getNode().isWarmNode()) {
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
        MatcherAssert.assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
                .actionGet()
        }
            .setWaitForNoRelocatingShards(true)
        client.admin().cluster().restoreSnapshot(firstRestore).get();
        createRepositoryWithSettings(null, repoName);
        createIndexWithDocsAndEnsureGreen(0, 100, indexName);
            .renameReplacement("remote-$1")
        logger.info("--> Create a repository");
        final String indexName = "test-index";
        String[] snapNames = new String[5];
        testUpdateIndexSettingsOnlyAllowedSettings(restoredIndexName);
     * verify that the Lucene segment files are not copied from the snapshot
        final String repoName = "test-repo";
        ensureGreen();
    }
        final int numReplicas = randomIntBetween(1, 4);
    public void testCreateSearchableSnapshotWithSmallChunks() throws Exception {
        createIndexWithDocsAndEnsureGreen(1, 100, indexName1);
            }
        createRepositoryWithSettings(null, repoName);
            assertTrue(shardsGroup.getShards().length > 1);
        internalCluster().ensureAtLeastNumDataNodes(numReplicasIndex + 1);
        final SnapshotRestoreException error = expectThrows(
import static org.hamcrest.Matchers.containsString;
        for (int i = 0; i < 4; i++) {
import org.opensearch.common.settings.Settings;
        deleteIndicesAndEnsureGreen(client, indexName);
        takeSnapshot(client, snapshotName, repoName, indexName1);
        final String restoredIndexName1 = indexName1 + "-copy";
        final Client client = client();
        createIndexWithDocsAndEnsureGreen(0, 100, indexName);
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
        internalCluster().ensureAtLeastNumWarmAndDataNodes(numReplicas + 1);
        }
        ensureGreen(restoredIndexName);
                assertTrue(s.getShards().get(0).getStats().getTotalFileCount() > 0);
        for (String indexName : indexNames) {
                builders[i] = client().prepareIndex(indexName).setId(Integer.toString(i)).setSource("field1", "bar " + i);
            fail("Expected operation to throw an exception");
            takeSnapshot(client, repeatedSnapshotName, repoName);
        final String snapshotName = "test-snap";
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
    }
                }
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
    }
        final int numReplicasIndex2 = 1;
    }
    }
        final String snapshotName = "test-snap";
                    .actionGet()
     * This assertion is digging a bit into the implementation details to
            }
import org.opensearch.core.index.Index;
    public void testPruneFileCacheOnIndexDeletion() throws Exception {
        assertEquals(expect, snapshotInfoMap);
        // test start node without warm role
     * taking a snapshot, restoring it as a searchable snapshot index.
        final String repoName = "test-repo";
        MatcherAssert.assertThat(
    }
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
        final String indexName = "test-idx";
 * Copyright OpenSearch Contributors
        final String snapshotName1 = "test-snapshot1";
    private void assertIndexAssignedToNodeOrNot(String index, String node, boolean assigned) {
     * Test scenario that checks the cache folder location on warm nodes for the restored index on snapshot restoration
 * SPDX-License-Identifier: Apache-2.0
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
        internalCluster().ensureAtLeastNumWarmNodes(1);
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsGroup;
            createRepository(repoName, FsRepository.TYPE);
     */
        // test start non-dedicated warm node, if the user doesn't configure the cache size, it fails
        internalCluster().ensureAtLeastNumWarmNodes(numReplicasIndex + 1);
     * ensure it can assign remote shards to a node with local shards given it has the
            IndexNotFoundException.class,
            .setIndices(indices)
        internalCluster().startNodes(2, dateNodeSettings);
     * Ensures availability of sufficient data nodes and warm capable nodes.
    public void testBlocksUnpinnedAfterRestore() throws Exception {
    private void assertCacheDirectoryReplicaAndIndexCount(int numCacheFolderCount, int numIndexCount) throws IOException {
            assertEquals(1, s.getIndices().size());
            final GroupShardsIterator<ShardIterator> shardIterators = state.getRoutingTable()
    public void testUpdateIndexSettings() throws InterruptedException {
        SnapshotsStatusResponse snapshotsStatusResponse = client.admin()
        AcknowledgedResponse settingsResponse = builder.execute().actionGet();
    }
        createRepositoryWithSettings(null, repoName);
        final String restoredIndexName = indexName + "-copy";
import static org.hamcrest.Matchers.is;
        final String restoredIndexName = indexName + "-copy";
import java.util.stream.StreamSupport;
        assertIndexDirectoryDoesNotExist(indexName + "-copy-0");
            .renamePattern("(.+)")
            .actionGet();
        final String indexName2 = "test-idx-2";
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
        RestoreSnapshotRequest secondRestore = new RestoreSnapshotRequest(repoName, snapshotName2).indices(indexName2)
    }
            .map(DiscoveryNode::getId)
        assertTrue(client.admin().indices().prepareDelete(indices).get().isAcknowledged());
        deleteIndicesAndEnsureGreen(client, indexName);
import org.opensearch.cluster.ClusterState;
        final Node node = internalCluster().getInstance(Node.class, nodeName);
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
    }
    }
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
        final String indexName = "test-idx";
        createIndexWithDocsAndEnsureGreen(numReplicasIndex, 100, indexName);
package org.opensearch.snapshots;
        takeSnapshot(client, snapshotName, repoName, indexName1, indexName2);
    }
        final String snapshotName = "test-snap";
    private Settings.Builder chunkedRepositorySettings(long chunkSize) {
        internalCluster().ensureAtLeastNumDataNodes(numReplicasIndex + 1);
        // create an index, add data, snapshot it, then delete it
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
        createIndexWithDocsAndEnsureGreen(0, 100, indexName2);
        final ClusterState state = clusterService().state();
                .cluster()
        final Client client = client();
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
            final String repeatedSnapshotName = repeatSnapNamePrefix + i;
        createIndexWithDocsAndEnsureGreen(numReplicas, 100, indexName);
    public void testRelocateSearchableSnapshotIndex() throws Exception {
        final String restoredIndexName = indexName + "-copy";
                .cluster()
            .map(node -> node.getNodeEnvironment().fileCacheNodePath().fileCachePath)
        createIndexWithDocsAndEnsureGreen(0, 50, indexName1);
        deleteIndicesAndEnsureGreen(client, indexName1);
        final String restoredIndexName1 = indexName1 + "-copy";
        final String indexName = "test-idx";
        // The index count will be 0 since the only restored index "test-idx-copy" was deleted
        deleteIndicesAndEnsureGreen(client, cfsIndex, nonCfsIndex);
        client.admin()
    public void testSearchableSnapshotAllocationFilterSettings() throws Exception {
        IntStream.range(0, 4).forEach(i -> expect.put(repeatSnapNamePrefix + i, List.of(repeatIndexNamePrefix + i)));
        ensureYellow(restoredIndexName);
     * repository to the node's local disk for a remote snapshot index.
    }
import java.util.Set;
        // randomizes this setting, which would cause assertNoPinnedBlocks to fail
            builder.execute().actionGet();
import static org.hamcrest.Matchers.contains;
        final Client client = client();
     * taking a snapshot, restoring them as searchable snapshots.
        Settings.Builder repositorySettings = chunkedRepositorySettings(1000);
        deleteIndicesAndEnsureGreen(client, indexName);
        shardGroups = client.admin()
        }
        final String snapshotName = "test-snap";
        // will run after this test (and all others) and assert on the consistency of the data in the repo.
                .prepareUpdateSettings()
        // Setup cluster with delayed ClusterInfo updates to simulate null shard sizes
        final String repoName = "test-repo";
        assertThat(settingsResponse, notNullValue());
        takeSnapshot(client, snapshotName2, repoName, indexName2);
        final String indexName = "test-index";
            }
        assertNoPinnedBlocks("after restore");
        final ShardPath shardPath = ShardPath.loadFileCachePath(node.getNodeEnvironment(), shardId);
        snapNames[4] = initSnapName;
        internalCluster().ensureAtLeastNumWarmNodes(1);
            assertTrue("shard cache path should " + (exists ? "exist" : "not exist"), Files.exists(shardPath.getDataPath()) == exists);
                    .execute()
        assertSearchableSnapshotIndexDirectoryExistence(searchNode2, index, false);
     */
        createRepositoryWithSettings(null, repoName);
        assertDocCount(restoredIndexName, 1000L);
        try {
                    Settings.builder()
        // test start dedicated warm node
        createIndexWithDocsAndEnsureGreen(0, 100, indexName);
     * ensure it can handle node drops for failover scenarios and the cluster gets back to a healthy state when
     * fetched during DirectoryReader.open() should be unpinned (refCount=0)
                .prepareRestoreSnapshot(repoName, snapshotName)
        try {
        takeSnapshot(client, snapshotName, repoName, indexName);
    public void testSearchableSnapshotAllocationForFailoverAndRecovery() throws Exception {
                assertTrue(isFileCacheEmpty(fcstats));
        internalCluster().validateClusterFormed();
            .prepareUpdateSettings()
        final String snapshotName = "test-snap";
        final int numReplicasIndex = 1;
        for (NodeStats nodeStats : preRestoreStats.getNodes()) {
        internalCluster().validateClusterFormed();
        final Client client = client();
        assertBusy(() -> {
            .actionGet()
        final String repoName = "test-repo";
        ClusterHealthResponse clusterHealthResponse = client.admin()
/*
import java.util.Map;
        final String snapshotName = "test-snap";
    }
import org.opensearch.node.Node;
        final String snapshotName2 = "test-snap";
        );
            Map.of("index.max_result_window", 1000, "index.search.slowlog.threshold.query.warn", "10s", "index.number_of_replicas", 0)
        }
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
            }
            Path fileCachePath = node.getNodeEnvironment().fileCacheNodePath().fileCachePath;
        createRepositoryWithSettings(null, repoName);
        logger.info("--> restore indices as 'remote_snapshot'");
        final UpdateSettingsRequestBuilder builder = client().admin().indices().prepareUpdateSettings(index);
        final String repeatIndexNamePrefix = indexName + "-copy-";
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
        deleteIndicesAndEnsureGreen(client, restoredIndexName1);
        expect.put(initSnapName, List.of(indexName));
            .setWaitForCompletion(true)
    private void assertNodesFileCacheNonEmpty(int numNodes) {
                    .resolve(Integer.toString(shardRouting.getId()))
            .execute()
     */
            assertNotNull(shardRouting);
        assertAcked(
            .collect(Collectors.toMap(s -> s.snapshotId().getName(), SnapshotInfo::indices));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        createIndex(cfsIndex, commonSettings.build());
        );
        // Second restore immediately after - ClusterInfo won't have size data for first restore shards
            .actionGet();
import java.nio.file.Path;
        Settings dateNodeSettings = dataNode();
                settingsResponse.getSetting(snapshotIndexName, IndexModule.INDEX_STORE_TYPE_SETTING.getKey())
    private void testUpdateIndexSettingsAtLeastOneNotAllowedSettings(String index) {
     * @param numCacheFolderCount total number of cache folders that should exist for the test case
        settings.put("chunk_size", chunkSize, ByteSizeUnit.BYTES);
        final String repoName = "test-repo";
        // collect the path for all the cache locations on warm nodes.
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
            )
        final int numReplicasIndex2 = randomIntBetween(0, 2);
            try (Stream<Path> dataPathStream = Files.list(fileCachePath)) {
     */
        ensureGreen("remote-" + indexName1);
        createIndexWithDocsAndEnsureGreen(numReplicasIndex, 1000, indexName);
                    if (refCount != null && refCount > 0) {
        );
            .setWaitForEvents(Priority.LANGUID)
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicasIndex)
        takeSnapshot(client, snapshotName, repoName, indexName1);
            )
     * Test scenario that validates that the default warm preference for searchable snapshot
                assertNull(fcStats);
        int pinnedCount = 0;
        internalCluster().ensureAtLeastNumWarmNodes(Math.max(numReplicasIndex1, numReplicasIndex2) + 1);
        internalCluster().ensureAtLeastNumWarmAndDataNodes(numReplicasIndex + 1);
    public void testDeleteSearchableSnapshotBackingIndex() throws Exception {
        deleteIndicesAndEnsureGreen(client, indexName2);
import static org.opensearch.test.NodeRoles.clusterManagerOnlyNode;
        internalCluster().ensureAtLeastNumWarmNodes(2);
        assertDocCount(restoredIndexName, 100L);
        assertDocCount(cfsIndex + "-copy", 100L);
        assertCacheDirectoryReplicaAndIndexCount(numShards, 0);
            indexRandom(true, false, builders);
                    }
        createIndexWithDocsAndEnsureGreen(numReplicasIndex1, 100, indexName1);
        });
import org.opensearch.action.index.IndexRequestBuilder;
        createRepositoryWithSettings(repositorySettings, repoName);
                assertEquals(1, s.getIndices().size());
        takeSnapshot(client, snapshotName, repoName, cfsIndex, nonCfsIndex);
        // Ensures that the compatible shards are not just primaries
        final String repoName = "test-repo";
            .filter(node -> node.fileCache() != null)
        internalCluster().ensureAtLeastNumWarmAndDataNodes(numShardsIndex);
        final String nonCfsIndex = "test-idx-noncfs";
            for (FsInfo.Path info : nodeStats.getNodes().get(0).getFs()) {
            assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
        NodesStatsResponse response = client().admin().cluster().nodesStats(new NodesStatsRequest().all()).actionGet();
        assertIndexDirectoryDoesNotExist(restoredIndexName1, restoredIndexName2);
        // test start non-dedicated warm node
import org.opensearch.index.shard.ShardPath;
    public void testRestoreSearchableSnapshotWithIndexStoreTypeThrowsException() throws Exception {
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
        ensureGreen();
        internalCluster().ensureAtLeastNumWarmNodes(numNodes);
import static org.opensearch.test.NodeRoles.onlyRole;
        throws InterruptedException {
        assertDocCount("remote-" + indexName2, 50L);
        } else {
        assertThrows(
import org.opensearch.core.index.shard.ShardId;
import static org.opensearch.test.NodeRoles.dataNode;
        final String repoName = "test-repo";
            .actionGet();
        final String restoredIndexName = indexName + "-copy";
        client.admin()
        internalCluster().ensureAtLeastNumWarmAndDataNodes(numNodes);
        final String indexName = "test-idx";
                .activePrimaryShardsGrouped(new String[] { indexName }, false);
    }
        final String restoredIndexName = indexName + "-copy";
        internalCluster().ensureAtLeastNumWarmNodes(1);
                .execute()
        final int numReplicasIndex = randomIntBetween(1, 4);
            () -> client.admin()
        settings.put("location", randomRepoPath()).put("compress", randomBoolean());
        internalCluster().ensureAtLeastNumDataNodes(1);
        final String indexName1 = "test-idx-1";
        final GetSnapshotsResponse response = client.admin().cluster().prepareGetSnapshots(repoName).execute().actionGet();
import static org.hamcrest.Matchers.notNullValue;
            .cluster()
            builder.execute().actionGet();
            .cluster()
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
                .actionGet();
        deleteIndicesAndEnsureGreen(client, indexName1);
        takeSnapshot(client, snapshotName, repoName, indexName);
    /**
        takeSnapshot(client, snapshotName, repoName, indexName);
        final String indexName1 = "test-idx-1";
            ClusterHealthResponse clusterHealthResponse = client.admin()
    public void cleanup() throws Exception {
        for (ClusterSearchShardsGroup shardsGroup : shardGroups) {
        internalCluster().ensureAtLeastNumWarmAndDataNodes(numReplicasIndex + 1);
            .setPersistentSettings(Settings.builder().putNull("cluster.info.update.interval"))
        assertSearchableSnapshotIndexDirectoryExistence(searchNode2, index, true);
    }
        }, 30, TimeUnit.SECONDS);
            .cluster()
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequest;
            SettingsException.class,
        for (NodeStats stats : response.getNodes()) {
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
    }
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;
        assertEquals("All blocks should be unpinned " + context, 0, pinnedCount);
    }
        createIndexWithDocsAndEnsureGreen(numReplicas, 100, indexName);
import org.opensearch.cluster.routing.ShardIterator;
    /**
        return settings;
        try {
            if (snapName.equals("initial-snapshot")) {
            final String restoredIndexName = indexName + "-copy-" + (i + 1);
        assertBusy(() -> {
import org.opensearch.cluster.node.DiscoveryNode;
        final String repoName = "test-repo";
    private void assertIndexingBlocked(String index) {
        // The local cache files should be closed by deleting the restored index
                        pinnedCount++;
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
import org.junit.After;
            .setRenameReplacement("$1-copy")
        final String repoName = "test-repo";
        final int numReplicasIndex = randomIntBetween(1, 4);
        internalCluster().ensureAtLeastNumDataNodes(2);
    public void testStartSearchNode() throws Exception {
            () -> internalCluster().startNode(
        final String snapshotName = "test-snap";
            () -> client.admin().indices().prepareGetIndex().setIndices(restoredIndexName).execute().actionGet()
        logger.info("--> validated that the cache file path doesn't exist");
    /**
            for (int i = 0; i < builders.length; i++) {
        final String indexName1 = "test-idx-1";
    private void createRepositoryWithSettings(Settings.Builder repositorySettings, String repoName) {
            () -> client().admin().cluster().deleteSnapshot(new DeleteSnapshotRequest(repoName, snapshotName)).actionGet()
            .prepareUpdateSettings()
     */
        final String indexName = "test-idx-1";
     * is primary shards
import java.util.stream.Stream;
            .renamePattern("(.+)")
            createRepository(repoName, FsRepository.TYPE, repositorySettings);
import org.opensearch.cluster.routing.ShardRouting;
                for (Path blockFile : blockFiles) {
import org.opensearch.core.common.unit.ByteSizeUnit;
     * Uses index.codec=default to avoid AssertingCodec (test-only codec that creates extra clones)
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
     */
    public void testCreateSearchableSnapshot() throws Exception {
            SettingsException.class,
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShardsIndex)
            assertTrue(state.getRoutingTable().allShards(index).stream().anyMatch(shard -> shard.currentNodeId().equals(node)));
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
            .prepareHealth()
        assertDocCount(restoredIndexName1, 100L);
            IndexRequestBuilder[] builders = new IndexRequestBuilder[100];
        createRepositoryWithSettings(null, repoName);
        final String indexName1 = "test-index1";
     */
import org.opensearch.transport.client.Client;
            assertIndexDirectoryDoesNotExist(restoredIndexName);
            .cluster()
        final String snapshotName1 = "test-snap-1";
     * After a searchable snapshot restore completes, all file cache blocks
            String pickedNode = randomFrom(warmNodes);
        assertDocCount(restoredIndexName1, 100L);
        restoreSnapshotAndEnsureGreen(client, snapshotName2, repoName);
import org.opensearch.cluster.metadata.IndexMetadata;
        final String indexName2 = "test-idx-2";
        } catch (ClusterBlockException e) {
     * Tests a small 1000 bytes chunked repository scenario for searchable snapshots by creating an index,
        // Test that the searchable snapshot index can continue to be snapshotted and restored
     * as provided.
        assertDocCount("remote-" + indexName1, 50L);
        final String repoName = "test-repo";
        assertNodesFileCacheNonEmpty(numNodes);
        takeSnapshot(client, snapshotName, repoName, indexName);
        // Ensure when no preferences are set (default preference), the only compatible shards are primary
    public void testFileCacheRestore() throws Exception {
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
        for (int i = warmNodes.size(); i > 2; --i) {
    public void testSnapshottingSearchableSnapshots() throws Exception {
    private void assertIndexDirectoryDoesNotExist(String... indexNames) {
            }
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    }
        client.admin()
        }
        createIndexWithDocsAndEnsureGreen(numReplicasIndex, 100, indexName);
        // ClusterSearchShards API returns a list of shards that will be used
        deleteIndicesAndEnsureGreen(client, restoredIndexName);
        final String snapshotName = "test-snap";
        internalCluster().ensureAtLeastNumDataNodes(numReplicasIndex1 + 1);
    }
    public void testDeleteSearchableSnapshotBackingIndexThrowsException() throws Exception {
        assertNodesFileCacheNonEmpty(numNodes);
                MatcherAssert.assertThat("Expect file not to exist: " + file, Files.exists(file), is(false));
        IntStream.range(0, 4).forEach(i -> snapNames[i] = repeatSnapNamePrefix + i);
        );
        final int numReplicasIndex1 = randomIntBetween(1, 4);
        final Set<String> warmNodes = StreamSupport.stream(clusterService().state().getNodes().spliterator(), false)
            MatcherAssert.assertThat(e.blocks(), contains(IndexMetadata.REMOTE_READ_ONLY_ALLOW_DELETE));
import org.opensearch.index.IndexSettings;
            .prepareRestoreSnapshot(repoName, snapshotName)
     * that the 'index' directory does not exist in the node's file system.
        assertDocCount(restoredIndexName, 100L);
    protected boolean addMockInternalEngine() {
        final String indexName = "test-idx";
            try (Stream<Path> paths = Files.walk(fileCachePath)) {
    private void assertNoPinnedBlocks(String context) throws IOException {
        for (String snapshotIndexName : snapshotIndexNames) {
                Map.of("index.max_result_window", 5000, "index.search.slowlog.threshold.query.warn", "15s", "index.refresh_interval", 10)
        final CreateSnapshotResponse createSnapshotResponse = client.admin()
    }
        final int numReplicasIndex1 = 1;
        assertIndexDirectoryDoesNotExist(restoredIndexName);
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
            String snapName = s.getSnapshot().getSnapshotId().getName();
        assertRemoteSnapshotIndexSettings(client, restoredIndexName1);
    public void testFileCacheStats() throws Exception {
                .setWaitForCompletion(true)
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.FS;
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
        createRepositoryWithSettings(null, repoName);
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
                .setIndexSettings(
            client().admin()
            .searchShards(new ClusterSearchShardsRequest(restoredIndexName).preference("foo"))
        } else {
        ensureGreen("remote-" + indexName2);
        assertSearchableSnapshotIndexDirectoryExistence(searchNode2, index, false);
        createRepositoryWithSettings(null, repoName);
    @After
        } catch (ClusterBlockException e) {
                    nonEmptyFileCacheNodes++;
            .stream()
                .cluster()
        }
import org.opensearch.common.settings.SettingsException;
            .waitForCompletion(true);
                .setTransientSettings(Settings.builder().putNull(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey()))
     */
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
        }
        String searchNode2 = internalCluster().startWarmOnlyNodes(1).get(0);
    }
        ensureGreen();
    public void testCreateSearchableSnapshotWithDefaultChunks() throws Exception {
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        ensureGreen(restoredIndexName);
        final String repoName = "test-repo";
        assertDocCount(restoredIndexName, 100L);
    }
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
     * taking a snapshot, restoring it as a searchable snapshot index.
            .execute()
            .searchShards(new ClusterSearchShardsRequest(restoredIndexName))
            boolean containsReplica = Arrays.stream(shardsGroup.getShards())
    }
            .actionGet();
        for (NodeStats stats : response.getNodes()) {
                "shard state path should " + (exists ? "exist" : "not exist"),
                .map(shardRouting -> !shardRouting.primary())
                if (!isFileCacheEmpty(fcStats)) {
                .setWaitForEvents(Priority.LANGUID)
        }, 30, TimeUnit.SECONDS);
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
        final Path indexPath = node.getNodeEnvironment().fileCacheNodePath().indicesPath.resolve(index.getUUID());
import org.opensearch.cluster.node.DiscoveryNodeRole;
        // Disable check_on_startup: Lucene's CodecUtil.checksumEntireFile() clones IndexInput
        final String restoredIndexName = indexName + "-copy";
            "Expect index to not exist",
import org.hamcrest.MatcherAssert;
        final String snapshotName2 = "test-snap-2";
        logger.info("--> stop the last warm node");
        final Client client = client();
                IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey(),
import org.opensearch.common.unit.TimeValue;
        final String snapshotName = "test-snap";
        );
    }
        final int numReplicasIndex = randomIntBetween(1, 4);
        final String repeatSnapNamePrefix = "test-repeated-snap-";
        assertDocCount(indexName + "-copy-0", 100L);
                Settings.builder().put(onlyRoles(Set.of(DiscoveryNodeRole.WARM_ROLE, DiscoveryNodeRole.DATA_ROLE)))
    private void takeSnapshot(Client client, String snapshotName, String repoName, String... indices) {
            );
            assertIndexAssignedToNodeOrNot(restoredIndexName, pickedNode, true);
        Settings clusterManagerNodeSettings = clusterManagerOnlyNode();
            .storageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)
            final String nodeId = shardRouting.currentNodeId();
            .execute()
        internalCluster().ensureAtLeastNumWarmNodes(numReplicasIndex + 1);
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        indexRandomDocs(indexName, numOfDocs);
public final class SearchableSnapshotIT extends AbstractSnapshotIntegTestCase {
        final Path indexDataPath = node.getNodeEnvironment().fileCacheNodePath().fileCachePath.resolve(index.getUUID());
            .execute()
            .setPersistentSettings(Settings.builder().put("cluster.info.update.interval", "60m"))
            fail("Expected operation to throw an exception");
    }
                    .resolve("index");
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
            .cluster()
        assertDocCount(restoredIndexName2, 100L);
        final int numShards = numReplicas + 1;
     */
    }
            final Index index = state.metadata().index(indexName).getIndex();
import static org.opensearch.core.common.util.CollectionUtils.iterableAsArrayList;
        client.admin()
                    .isAcknowledged()
        assertThrows(
            MatcherAssert.assertThat(e.blocks(), contains(IndexMetadata.REMOTE_READ_ONLY_ALLOW_DELETE));
        assertSearchableSnapshotIndexDirectoryExistence(searchNode1, index, true);
        if (repositorySettings == null) {
    private void restoreSnapshotAndEnsureGreen(Client client, String snapshotName, String repoName) {
        // non-deterministically.
     * nodes with warm capabilities are added back to the cluster.
        createRepositoryWithSettings(null, repoName);
        assertAllNodesFileCacheEmpty();
            .put("index.codec", "default")
        final String restoredIndexName = indexName + "-copy";
            if (fcstats != null) {
    private void assertAllNodesFileCacheEmpty() {
     * taking a snapshot, restoring it as a searchable snapshot.
        final int numReplicasIndex = 0;
            .cluster()
    }
     * Tests file cache restore scenario for searchable snapshots by creating an index,
    }
        assertSearchableSnapshotIndexDirectoryExistence(searchNode1, index, false);
        createIndexWithDocsAndEnsureGreen(numReplicasIndex, 1000, indexName);
                assertEquals(numIndexCount, dataPathStream.count());
                .execute()
            .actionGet();
     * Tests a default 8mib chunked repository scenario for searchable snapshots by creating an index,
import java.io.IOException;
        final String repoName = "test-repo";
        final String snapshotName = "test-snap";
        createRepositoryWithSettings(null, repoName);
        logger.info("--> stop a random warm node");
        internalCluster().ensureAtLeastNumWarmNodes(1);
        internalCluster().ensureAtLeastNumDataNodes(1);
        deleteIndicesAndEnsureGreen(client, restoredIndexName);
        takeSnapshot(client, snapshotName1, repoName, indexName1);
            assertTrue(shardRouting.assignedToNode());
     */
            );
        createRepositoryWithSettings(null, repoName);
        // is thrown.
    @Override
        createIndexWithDocsAndEnsureGreen(numReplicasIndex1, 100, indexName1);
            .setStorageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)
        // Ensure when preferences are set, all the compatible shards are returned
        final String snapshotName = "test-snap";
        createIndex(
        final String snapshotName = "test-snap";
        ensureGreen();
            assertEquals(
        takeSnapshot(client, snapshotName, repoName, indexName1, indexName2);
import org.opensearch.common.Priority;
                .setRenameReplacement("$1-copy")
        internalCluster().stopRandomWarmNode();
import org.opensearch.index.IndexModule;
        final ShardId shardId = new ShardId(index, 0);
                .setRenamePattern("([a-z-]+).*")
        takeSnapshot(client, snapshotName, repoName, indexName);
        assertRemoteSnapshotIndexSettings(client, restoredIndexName1, restoredIndexName2);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .indices()
        internalCluster().ensureAtLeastNumWarmAndDataNodes(numReplicasIndex + 1);
                // Build the expected path for the index data for a "normal"
        }
        final String repoName = "test-repo";
    }
            final NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats(nodeId).addMetric(FS.metricName()).get();
     */
        final String indexName = "test-index";
            )
        assertTrue(client.admin().indices().prepareDelete(restoredIndexName).get().isAcknowledged());
     * It ensures file cache is restored post node restart.
import java.nio.file.Files;
        assertEquals(numCacheFolderCount, searchNodeFileCachePaths.size());
        assertDocCount(indexName, 100L);
        client().admin().cluster().deleteSnapshot(new DeleteSnapshotRequest(repoName, snapshotName1)).actionGet();
        assertDocCount(nonCfsIndex + "-copy", 100L);
        for (Path fileCachePath : searchNodeFileCachePaths) {
import static org.hamcrest.Matchers.equalTo;
                    Integer refCount = node.fileCache().getRef(blockFile);
        return stats.getUsed().getBytes() == 0L && stats.getActive().getBytes() == 0L;
        final Client client = client();
                client.admin()
            builder.setSettings(
        }
        );
            .storageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)
        deleteIndicesAndEnsureGreen(client, indexName);
                    .prepareUpdateSettings(restoredIndexName)
        logger.info("--> validate cache file path is deleted");
            warmNodes.remove(pickedNode);
            .put(IndexSettings.INDEX_CHECK_ON_STARTUP.getKey(), "false");
        String searchNode1 = internalCluster().startWarmOnlyNodes(1).get(0);
            .get();
            MatcherAssert.assertThat(e.blocks(), contains(IndexMetadata.REMOTE_READ_ONLY_ALLOW_DELETE));
    }
        internalCluster().ensureAtLeastNumDataNodes(1);
            assertEquals(1, shardsGroup.getShards().length);
                assertTrue(snapName.startsWith(repeatSnapNamePrefix));
        final Client client = client();
        // when querying a particular index
        createIndex(nonCfsIndex, Settings.builder().put(commonSettings.build()).put("index.compound_format", false).build());
            fail("Expected operation to throw an exception");
     * Tests both CFS (compound file) and non-CFS indexes in a single snapshot/restore cycle.
        final Client client = client();
        final Map<String, List<String>> expect = new HashMap<>();
        final String repoName = "test-repo";
            AggregateFileCacheStats fcStats = stats.getFileCacheStats();
            assertTrue(containsReplica);
        assertAllNodesFileCacheEmpty();
                .build()
        createIndexWithDocsAndEnsureGreen(0, 100, indexName1);
        createRepositoryWithSettings(null, repoName);
                .setRenameReplacement("$1" + (i + 1))
        createRepositoryWithSettings(repositorySettings, repoName);
        final String snapshotName = "test-snap";
            }
            assertTrue(Files.isDirectory(fileCachePath));
            assertTrue(
        return settings;
            if (node.fileCache() == null) continue;
            assertEquals(1, s.getShards().size());
                assertEquals(0L, s.getShards().get(0).getStats().getTotalFileCount());
        takeSnapshot(client, snapshotName, repoName, indexName);
        ClusterSearchShardsGroup[] shardGroups = client.admin()
        final Map<String, List<String>> snapshotInfoMap = response.getSnapshots()
            client.admin().indices().prepareForceMerge(indexName).setMaxNumSegments(1).get();
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
    /**
            assertIndexAssignedToNodeOrNot(restoredIndexName, pickedNode, false);
        deleteIndicesAndEnsureGreen(client, indexName1);
            containsString(
        for (String node : postRestoreStatsMap.keySet()) {
                Settings.builder().put(onlyRoles(Set.of(DiscoveryNodeRole.WARM_ROLE, DiscoveryNodeRole.DATA_ROLE)))
                )
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
                Files.exists(shardPath.getShardStatePath()) == exists
import org.opensearch.monitor.fs.FsInfo;
        final String repoName = "test-repo";
        );
            .setWaitForCompletion(true)
        // Filter out warm NodeEnvironment(s) since FileCache is initialized only on warm nodes and
    public void testDefaultShardPreference() throws Exception {
        createIndexWithDocsAndEnsureGreen(0, 100, indexName);
            final ShardIterator shardIterator = RandomPicks.randomFrom(random(), iterators);
            AggregateFileCacheStats fcstats = stats.getFileCacheStats();
        Iterable<Node> nodes = internalCluster().getInstances(Node.class);
            .cluster()
        Settings.Builder repositorySettings = chunkedRepositorySettings(2 << 23);
        Settings.Builder commonSettings = Settings.builder()
        final String indexName = "test-idx";
                        .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT)
        logger.info("--> Take a snapshot");
        assertDocCount(restoredIndexName, 100L);
    private boolean isFileCacheEmpty(AggregateFileCacheStats stats) {
        final String initSnapName = "initial-snapshot";
            .getGroups();
    public void testSearchableSnapshotIndexIsReadOnly() throws Exception {
     * Tests the functionality of remote shard allocation to
        }
        internalCluster().startNodes(2, clusterManagerNodeSettings);
    }
        createRepositoryWithSettings(null, repoName);
        internalCluster().stopRandomWarmNode();
            assertTrue("index path should " + (exists ? "exist" : "not exist"), Files.exists(indexDataPath) == exists);
                internalCluster().restartNode(nodeStats.getNode().getName());
        final Client client = client();
        internalCluster().ensureAtLeastNumWarmNodes(numReplicasIndex1 + 1);
    }
                .cluster()
    }
        final String indexName1 = "test-idx-1";
    }
}
        ensureRed(restoredIndexName);
        final String snapshotName = "test-snap";
            SnapshotInUseDeletionException.class,
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
     * Tests the functionality of index write block on a searchable snapshot index.
        int nonEmptyFileCacheNodes = 0;
            .setTimeout(new TimeValue(5, TimeUnit.MINUTES))
        testUpdateIndexSettingsAtLeastOneNotAllowedSettings(restoredIndexName);
            final ShardRouting shardRouting = shardIterator.nextOrNull();
        } catch (ClusterBlockException e) {
            assertIndexAssignedToNodeOrNot(indexName, pickedNode, true);
            .actionGet()
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
        NodesStatsResponse postRestoreStats = client().admin().cluster().nodesStats(new NodesStatsRequest().all()).actionGet();
        // without closing it, leaving file cache blocks pinned until GC. The test framework
        assertThrows(
        createIndexWithDocsAndEnsureGreen(numReplicasIndex, 100, indexName);
    /**
            .setRenamePattern("(.+)")
        createRepositoryWithSettings(null, repoName);
            // Get the file system stats for the assigned node
            .waitForCompletion(true);
import java.util.List;
            .cluster()
        final Client client = client();
                .reduce(false, (s1, s2) -> s1 || s2);
     * Tests a happy path scenario for searchable snapshots by creating 2 indices,
        // Walk through the cache directory on nodes
        final String indexName2 = "test-index2";
        createRepositoryWithSettings(null, repoName);
     * @param numIndexCount total number of index folder locations that should exist within the cache folder
        final String indexName = "test-idx";
        final String restoredIndexName1 = indexName1 + "-copy";
        assertRemoteSnapshotIndexSettings(client, restoredIndexName);
     * Asserts the cache folder count to match the number of shards and the number of indices within the cache folder
     */
    public void testRestoreRemoteSnapshotWithNullShardSizes() throws Exception {
            indexName,
        client.admin().cluster().restoreSnapshot(secondRestore).get();
        }
        final String indexName = "test-idx";
     *
    /**
            final UpdateSettingsRequestBuilder builder = client().admin().indices().prepareUpdateSettings(index);
            Settings.builder()
        assertDocCount(restoredIndexName, 100L);
    }
            ensureGreen();
            final IndexRequestBuilder builder = client().prepareIndex(index);
        assertDocCount(restoredIndexName, 100);
        takeSnapshot(client, snapshotName, repoName, indexName);
            .renameReplacement("remote-$1")
                .prepareRestoreSnapshot(repoName, repeatedSnapshotName)
        final String snapshotName = "test-snap";
            deleteIndicesAndEnsureGreen(client, "_all");
        // Keeping the replicas to 0 for reproducible cache results as shards can get reassigned otherwise
        assertDocCount(restoredIndexName, 100L);
                "cannot restore remote snapshot with index settings \"index.store.type\" set to \"remote_snapshot\". Instead use \"storage_type\": \"remote_snapshot\" as argument to restore."
            NodeStats postRestoreStat = postRestoreStatsMap.get(node);
import java.util.HashMap;
    }
        final Client client = client();
            NodeStats preRestoreStat = preRestoreStatsMap.get(node);
            .prepareReroute()
    }
import static org.opensearch.test.NodeRoles.onlyRoles;
        final Client client = client();
            .getSettings(new GetSettingsRequest().indices(snapshotIndexNames))
                    .resolve(index.getUUID())
    /**
        assertIndexDirectoryDoesNotExist(restoredIndexName1, restoredIndexName2);
            SnapshotRestoreException.class,
        }
import org.opensearch.repositories.fs.FsRepository;
        final Index index = resolveIndex(restoredIndexName);
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
            .prepareSnapshotStatus(repoName)
    /**
        final Client client = client();
        final String snapshotName = "test-snap";
        createIndexWithDocsAndEnsureGreen(1, 100, indexName1);
    protected Settings.Builder randomRepositorySettings() {
        createIndexWithDocsAndEnsureGreen(0, 100, indexName);
            // Get the primary shards for the given index
        // Verifies if all the shards (primary and replica) have been deleted
                // index and assert it does not exist
        );
        internalCluster().ensureAtLeastNumWarmNodes(Math.max(numReplicasIndex1, numReplicasIndex2) + 1);
import org.opensearch.cluster.routing.GroupShardsIterator;
            }
        testUpdateIndexSettingsOnlyNotAllowedSettings(restoredIndexName);
        final int numShardsIndex = randomIntBetween(3, 6);
                .setTimeout(new TimeValue(5, TimeUnit.MINUTES))
    public void testCacheIndexFilesClearedOnDelete() throws Exception {
        Map<String, NodeStats> preRestoreStatsMap = preRestoreStats.getNodesMap();
import java.util.concurrent.TimeUnit;
        final Client client = client();
        internalCluster().ensureAtLeastNumWarmNodes(1);
            .get();
            final UpdateSettingsRequestBuilder builder = client().admin().indices().prepareUpdateSettings(index);
        final String restoredIndexName = indexName + "-copy";
        final String restoredIndexName2 = indexName2 + "-copy";
    }
                final Path file = PathUtils.get(path)
            .getGroups();
        final String indexName2 = "test-idx-2";
        final Client client = client();
        // The index count will be 1 since there is only a single restored index "test-idx-copy"
        takeSnapshot(client, snapshotName2, repoName, indexName2);
                assertNotNull(s.getIndices().get("test-idx"));
        final Client client = client();
        GetSettingsResponse settingsResponse = client.admin()
    private void assertRemoteSnapshotIndexSettings(Client client, String... snapshotIndexNames) {
        restoreSnapshotAndEnsureGreen(client, snapshotName, repoName);
        final String repoName = "test-repo";
