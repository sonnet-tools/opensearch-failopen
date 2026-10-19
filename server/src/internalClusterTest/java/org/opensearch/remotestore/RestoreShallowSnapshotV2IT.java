            client.prepareIndex(indexName).setId(id).setSource("text", "sometext").get();
            SnapshotRestoreException.class,  
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
        indexDocuments(client, indexName1, numDocsInIndex1);
        Arrays.copyOf(pathTokens, pathTokens.length - 1);  
            .cluster()
    public void testHashedPrefixTranslogMetadataCombination() throws Exception {  
        // Clear the local data before stopping the node. This will make sure that remote translog is empty.
import org.opensearch.index.IndexService;
        logger.info("Snapshot Path [{}]", absolutePath1);
        String newSegmentRepo = "backup-segment";  
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
    }
    @After  
        String index = "test-index";  
        logger.info("Path 2 [{}]", absolutePath2);
        DeleteResponse deleteResponse = client().prepareDelete(indexName1, "0").execute().actionGet();  
        logger.info("--> snapshot");
            .setRenameReplacement(restoredIndexName2)
        remoteRepoPath = randomRepoPath().toAbsolutePath();  
                fileCache.clear();
        assertDocsPresentInIndex(client, indexName1, numDocsInIndex1 + 2);
    public static Collection<Object[]> parameters() {
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
                .setWaitForCompletion(false)
        assertAcked(client.admin().indices().prepareClose(indexName1));  
        client(clusterManagerNode).admin()
        assertThat(recoveryState.getIndex().recoveredFilesPercent(), lessThanOrEqualTo(100.0f));
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1);  
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1);  
            .setSourceRemoteStoreRepository(remoteStoreRepoNameUpdated)  
    @Before
        assertEquals(restoreSnapshotResponse1.status(), RestStatus.ACCEPTED);
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
            if (randomBoolean()) {  
        assertTrue(exception.getMessage().contains("cannot remove setting [index.remote_store.translog.repository] on restore"));
        String restoredIndexName1 = indexName1 + "-restored";
        client().admin().indices().close(Requests.closeIndexRequest(indexName1)).get();  
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
import java.util.Collection;
        long totalDocs = 0;
                .cluster()
        createRepository(snapshotRepoName, "fs", getRepositorySettings(location, basePath, true));
        Path absolutePath1 = randomRepoPath().toAbsolutePath();  
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();  
        refresh(indexName1);
                            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_METADATA.getKey(), randomBoolean())
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.DATA;
        for (int i = fromId; i < toId; i++) {  
import org.opensearch.common.settings.Settings;
        SnapshotInfo snapshotInfo2 = createSnapshot(  
        // Update cluster settings to FIXED
import java.nio.file.Path;
        String indexName1 = "testindex1";  
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
            () -> client().admin()
                .cluster()  
                    totalDocs += numDocs;  
            assertEquals(RestStatus.OK, restoreSnapshotResponse1.status());  
        assertDocsPresentInIndex(client(), restoredIndexName1, numDocsInIndex1);
                String snapshotName = baseSnapshotName + i;
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, newRemoteStoreRepo)
        RestoreSnapshotResponse restoreSnapshotResponse1 = client.admin()
import org.opensearch.action.support.PlainActionFuture;  
                .setRenameReplacement(restoredIndex)
                long finalTotalDocs1 = totalDocs;  
        assertThat(snapshotInfo1.successfulShards(), equalTo(snapshotInfo1.totalShards()));  
                .setRenamePattern(index)
        internalCluster().startDataAndWarmNodes(1);
        assertTrue(recoveryState.getPrimary());
        // Validate that the remote_store custom data is present in index metadata for the created index.  
        assertThat(snapshotInfo1.successfulShards(), greaterThan(0));
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(indexName1)));
        IndexShard indexShard = getIndexShard(primaryNodeName(indexName1), indexName1);  
        );
            .get();
        String indexName1 = "testindex1";
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.TRANSLOG;  
        assertThat(snapshotInfo1.state(), equalTo(SnapshotState.SUCCESS));
        ensureRed(indexName1);  
        Path remoteTranslogMetadataPath = Path.of(remoteRepoPath + "/" + path);  
 * this file be licensed under the Apache-2.0 license or a
        int numDocs = randomIntBetween(200, 300);  
        createIndex(indexName1, indexSettings);
    public void teardown() {
        assertRemoteSegmentsAndTranslogUploaded(indexName1);  
        assertEquals(pathType.name(), remoteCustomData.get(RemoteStoreEnums.PathType.NAME));  
        assertEquals(restoreSnapshotResponse1.status(), RestStatus.ACCEPTED);
        String newRemoteStoreRepo = "test-new-rs-repo";
        createIndex(indexName1, indexSettings);  
        );
import static org.opensearch.repositories.blobstore.BlobStoreRepository.SYSTEM_REPOSITORY_SETTING;
        Settings indexSettings = getIndexSettings(1, 0).build();
        int numDocsInIndex1 = randomIntBetween(2, 5);
        Settings settings = Settings.builder()
            var nodes = internalCluster().getDataNodeInstances(Node.class);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));
                }  
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_METADATA.getKey(), randomBoolean())  
    private Settings.Builder getIndexSettings(int numOfShards, int numOfReplicas) {
                    .execute()
        return Settings.builder()  
        ensureGreen(indexName1);
    private void validatePathType(String index, RemoteStoreEnums.PathType pathType) {
        String indexName2 = "testindex2";
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
        String indexName2 = "testindex2";  
                .setIndexSettings(multipleRemoteStoreIndexSettings)
import org.opensearch.test.BackgroundIndexer;  
    public void testRestoreInSameRemoteStoreEnabledIndex() throws IOException {  
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
        Path absolutePath1 = randomRepoPath().toAbsolutePath();  
import org.opensearch.common.blobstore.BlobPath;  
                .setIndices(index)  
        assertEquals(restoreSnapshotResponse2.status(), RestStatus.ACCEPTED);
        indexDocuments(client, index, numDocsInIndex, numDocsInIndex + randomIntBetween(2, 5));
        Client client = client();
        RestoreSnapshotResponse restoreSnapshotResponse1 = client.admin()
            .setWaitForCompletion(false)  
        return shardId.map(indexService::getShard).orElse(null);
        internalCluster().startDataAndWarmNodes(2);
        assertTrue(exception.getMessage().contains("cannot remove setting [index.remote_store.segment.repository]" + " on restore"));
        ensureGreen(indexName1);
        Client client = client();
        assertAcked(client.admin().indices().prepareClose(restoredIndexName1));
        exception = expectThrows(
        SnapshotInfo snapshotInfo1 = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(List.of(indexName1)));
        internalCluster().startDataAndWarmNodes(1);  
                .setWaitForCompletion(false)
                .setIndexSettings(remoteStoreTranslogIndexSettings)  
        String snapshotName1 = "test-restore-snapshot1";
                .setRenamePattern(index)
            .get();  
        indexDocuments(client(), indexName1, numDocsInIndex1);  
        RecoveryResponse recoveryResponse = client().admin().indices().prepareRecoveries(restoredIndexName1).execute().actionGet();
                .setWaitForCompletion(false)  
            }  
        indexDocuments(client, indexName1, 2 * numDocsInIndex1, 3 * numDocsInIndex1);
        String restoredIndexName1version1 = indexName1 + "-restored-1";  
        );
                .get()  
            .setWaitForCompletion(true)  
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, node);  
        }  
        RestoreSnapshotResponse restoreSnapshotResponse2 = client.admin()
import java.util.HashMap;
    }
        String baseSnapshotName = "snapshot_";
    }
        // Create index with cluster setting cluster.remote_store.index.path.type as hashed_prefix.  
        String remoteStoreRepoNameUpdated = "test-rs-repo-updated" + TEST_REMOTE_STORE_REPO_SUFFIX;
        ensureRed(indexName1);  
        String snapshotRepoName = "test-restore-snapshot-repo";
            SnapshotRestoreException.class,  
        logger.info("Snapshots Status: " + snapshots);
                long finalTotalDocs1 = totalDocs;
        assertAcked(client().admin().indices().prepareClose(indexName1));  
        createRepository(snapshotRepo, "fs", getRepositorySettings(absolutePath1, true));
                .cluster()
        String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(getNodeSettings());
import java.nio.file.Files;  
        assertThat(snapshotInfo2.state(), equalTo(SnapshotState.SUCCESS));
        SnapshotInfo snapshotInfo1 = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(List.of(indexName1)));
            .setIndices(indexName1)  
        String[] pathTokens = absolutePath1.toString().split("/");
        validatePathType(index, pathType, null);  
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        return Settings.builder()  
        String restoredIndexName1version2 = indexName1 + "-restored-2";
        );
        indexDocuments(client, indexName1, randomIntBetween(5, 10));
        final int numDocsInIndex1 = 5;
 * compatible open source license.
        assertEquals(RestStatus.ACCEPTED, restoreSnapshotResponse.status());
            RestoreSnapshotResponse restoreSnapshotResponse1 = client.admin()
        String remoteStoreRepoNameUpdated = "test-rs-repo-updated" + TEST_REMOTE_STORE_REPO_SUFFIX;  
                .prepareRestoreSnapshot(snapshotRepo, snapshot)
import org.opensearch.cluster.routing.RecoverySource;
            for (int i = 0; i < numberOfSnapshots; i++) {
            .get();  
            }
        logger.info("--> snapshot");  
import static org.hamcrest.Matchers.greaterThan;
        );
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
                logger.info("--> {} total docs indexed", totalDocs);
                assertEquals(snapshots.get(snapshot), hits);
            .setRenameReplacement(restoredIndexName1version1)
                    .setSize((int) finalTotalDocs)
                .setIgnoreIndexSettings(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY)
                Long hits = client().prepareSearch(index)  
        ensureYellowAndNoInitializingShards(indexName1);
        indexDocuments(client, restoredIndexName1, numDocsInIndex1, numDocsInIndex1 + 2);
                .setWaitForCompletion(true)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .setWaitForCompletion(false)
        // Verify restored index's stats
        String newSnapshotRepo = "backup-snapshot";
        ).build();  
            ensureGreen(TimeValue.timeValueSeconds(60), index);  
            .setRenameReplacement(restoredIndexName1)  
                    .getHits()  
        assertThat(snapshotInfo1.state(), equalTo(SnapshotState.SUCCESS));
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)  
        assertEquals(1, recoveryResponse.getTotalShards());  
            SnapshotRestoreException.class,  
            .setRenamePattern(indexName1)
        String snapshotName1 = "test-restore-snapshot1";
 *
                .setRenameReplacement(restoredIndex)
                .setRenamePattern(index)
            .cluster()  
        String snapshotName1 = "test-restore-snapshot1";
        exception = expectThrows(
        boolean enableShallowCopy = randomBoolean();  
            .cluster()
        logger.info("--> snapshot");
import org.opensearch.indices.RemoteStoreSettings;
        Path location2 = PathUtils.get(String.join("/", pathTokens));
        Map<String, String> remoteCustomData = state.metadata().index(index).getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY);
        }
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(randomIntBetween(1, 5)));  
        assertThat(snapshotInfo1.successfulShards(), equalTo(snapshotInfo1.totalShards()));  
        );
        validatePathType(indexName2, RemoteStoreEnums.PathType.HASHED_PREFIX, RemoteStoreEnums.PathHashAlgorithm.FNV_1A_COMPOSITE_1);
            .cluster()
        internalCluster().startClusterManagerOnlyNode();  
        String indexName1 = "testindex1";  
        Path location = PathUtils.get(String.join("/", pathTokens));
                .setRenameReplacement(restoredIndex)
        assertEquals(1, recoveryResponse.shardRecoveryStates().size());  
        SnapshotInfo snapshotInfo2 = createSnapshot(
        indexDocuments(client, indexName1, numDocsInIndex1, numDocsInIndex1 + randomIntBetween(2, 5));
            .setWaitForCompletion(false)
import org.junit.Before;  
        createIndex(index, indexSettings);  
        createIndex(indexName1, indexSettings);
        assertTrue(exception.getMessage().contains("cannot remove setting [index.remote_store.segment.repository] on restore"));
        String indexName1 = "testindex1";
                .get();
        assertEquals(RecoverySource.Type.SNAPSHOT, recoveryState.getRecoverySource().getType());
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
        }
            });
    }
        createIndex(indexName1, indexSettings);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();  
            .build();
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName1)).get());
        String snapshotName1 = "test-restore-snapshot1";
import org.opensearch.transport.client.Client;  
        Arrays.copyOf(pathTokens, pathTokens.length - 1);
        client(clusterManagerNode).admin()  
                    .execute()
/*  
import java.io.IOException;
                .setRenamePattern(index)  
        );
        assertThat(snapshotInfo1.state(), equalTo(SnapshotState.SUCCESS));
        assertThat(snapshotInfo1.state(), equalTo(SnapshotState.SUCCESS));
        ensureGreen(indexName1);
                .setIndexSettings(remoteStoreIndexSettings)
                logger.info("--> {} total docs indexed", totalDocs);
    public void setup() {
            snapshotRepoName,
                .setRenameReplacement(restoredIndex)
            snapshotName1,
            .setSourceRemoteTranslogRepository(newTranslogRepo)
            .setRenamePattern(indexName2)  
        // ensure populated bytes details
        Settings.Builder settingsBuilder = randomRepositorySettings();
        assertEquals(RecoveryState.Stage.DONE, recoveryState.getStage());
                assertBusy(() -> assertEquals(finalTotalDocs1, indexer.totalIndexedDocs()), 120, TimeUnit.SECONDS);  
                    .cluster()  
            for (var node : nodes) {  
            Stream<Path> translogData = Files.list(remoteTranslogDataPath);
        assertThat(snapshotInfo1.successfulShards(), equalTo(snapshotInfo1.totalShards()));  
                    .actionGet()
        indexDocuments(client, indexName1, numDocsInIndex1);  
    }
        logger.info("Snapshot Path [{}]", absolutePath1);
        String translogPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings());  
        }
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
        try (BackgroundIndexer indexer = new BackgroundIndexer(index, MapperService.SINGLE_MAPPING_NAME, client(), numDocs)) {
            .setRenameReplacement(restoredIndexName1version2)
            }
        ensureGreen(indexName1);  
                assertEquals(snapshots.get(snapshot), hits);
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
            .put(BlobStoreRepository.READONLY_SETTING.getKey(), readOnly)
import static org.hamcrest.Matchers.equalTo;  
        // Create Snapshot of index 2  
        createRepository(newSnapshotRepo, "fs", getRepositorySettings(snapshotRepoName, true));
        Settings remoteStoreTranslogIndexSettings = Settings.builder()
                .cluster()
            .put(super.indexSettings())  
            .cluster()
        // Index 5 documents, refresh, index 5 documents  
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
        assertTrue(recoveryState.getIndex().recoveredBytes() > 0L);
    private void validatePathType(  
        // Re-initialize client to make sure we are not using client from stopped node.  
        return settingsBuilder;
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
                    .setTransientSettings(
        logger.info("Snapshot Path [{}]", absolutePath1);
                .setIgnoreIndexSettings(SETTING_REMOTE_STORE_ENABLED)
        internalCluster().startDataAndWarmNodes(1);  
        assertEquals(restoreSnapshotResponse2.status(), RestStatus.ACCEPTED);
import org.opensearch.index.mapper.MapperService;  
        Settings remoteStoreIndexSettings = Settings.builder().put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false).build();
        ensureGreen(index);
    }
        indexDocuments(client, indexName1, numDocsInIndex1 + 2, numDocsInIndex1 + 4);
            }
        final int numDocsInIndex2 = 6;
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(indexName1).restoreAllShards(true), PlainActionFuture.newFuture());  
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.node.Node;
        Client client = client();
        assertFalse(indexExists(indexName1));
    @ParametersFactory
import java.util.List;  
        totalDocs += numDocs;  
        assertTrue(recoveryState.getIndex().totalRecoverFiles() > 0);
        final Index index = resolveIndex(indexName);
                assertBusy(() -> assertEquals(finalTotalDocs1, indexer.totalIndexedDocs()), 120, TimeUnit.SECONDS);
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), false)  
        indexDocuments(client, indexName2, numDocsInIndex2);  
        // try index restore with index.remote_store.segment.repository modified  
        assertFalse(indexExists(indexName1));
                    .value();
            .restoreRemoteStore(
        ensureGreen(index);  
            .get();
    }
        exception = expectThrows(
        String index = "test-index";
        Settings indexSettings = getIndexSettings(1, 0).put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        final int numDocsInIndex2 = 6;
        assertThat(snapshotInfo2.state(), equalTo(SnapshotState.SUCCESS));
        // try index restore with index.remote_store.segment.repository and index.remote_store.translog.repository ignored
        logger.info("--> snapshot");
        final int numDocsInIndex = 5;
        RestoreSnapshotResponse restoreSnapshotResponse1 = client().admin()  
        RestoreSnapshotResponse restoreSnapshotResponse2 = client.admin()
            });
        SnapshotInfo snapshotInfo1 = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(Arrays.asList(indexName1)));
            .prepareRestoreSnapshot(newSnapshotRepo, snapshotName1)
                .get()
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), true).build() }
            new ArrayList<>(Arrays.asList(indexName1, indexName2))  
            Stream<Path> segmentMetadata = Files.list(segmentMetadataPath);
            RemoteStorePinnedTimestampService.class,  
            .cluster()  
        indexSettings = getIndexSettings(1, 0).build();
                .setWaitForCompletion(false)
        RemoteStoreEnums.PathType pathType,
            int numberOfSnapshots = 2;
        Client client = client();  
            .setIndices(indexName1)
        String snapshotName1 = "test-restore-snapshot1";
                .cluster()  
        String baseSnapshotName = "snapshot_";
            assertTrue(translogData.count() > 0);  
    }
        RestoreSnapshotResponse restoreSnapshotResponse1 = client().admin()
                    .getHits()  
        // try index restore with index.remote_store.segment.repository ignored
            .get();  
            .cluster()  
            .setWaitForCompletion(false)
            .cluster()
            .put(super.nodeSettings(nodeOrdinal))
            .setWaitForCompletion(false)
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
                .cluster()
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.METADATA;
        try (BackgroundIndexer indexer = new BackgroundIndexer(index, MapperService.SINGLE_MAPPING_NAME, client(), numDocs)) {
                .cluster()
    public void testRemoteStoreCustomDataOnIndexCreationAndRestore() {  
        Settings indexSettings = getIndexSettings(1, 0).build();
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1 + 2);
            .setRenamePattern(indexName1)
            .setRenameReplacement(restoredIndexName1)
        GetRepositoriesResponse res = client().admin().cluster().getRepositories(gr).get();
        // try index restore with index.remote_store.enabled modified
            .cluster()  
        assertThat(recoveryState.getIndex().recoveredBytesPercent(), lessThanOrEqualTo(100.0f));  
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
 * SPDX-License-Identifier: Apache-2.0
            primaryNodeName(index)
            new ArrayList<>(Arrays.asList(indexName1, indexName2))  
        // indexing some new docs and validating
        String newTranslogRepo = "backup-translog";
        String snapshotRepoName = "test-restore-snapshot-repo";
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
    private void indexDocuments(Client client, String indexName, int numOfDocs) {
        createIndex(indexName1, indexSettings);  
            IOUtils.deleteFilesIgnoringExceptions(files.collect(Collectors.toList()));
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, newRemoteStoreRepo)
        ensureGreen(indexName1);
        assertDocsPresentInIndex(client(), indexName1, numDocsInIndex1);  
            .setIndices(indexName1)  
        try (Stream<Path> files = Files.list(indexShard.shardPath().resolveTranslog())) {
            .setIndices(indexName1)  
        snapshotInfo = createSnapshot(snapshotRepoName, snapshotName2, new ArrayList<>(List.of(indexName2)));
        indexDocuments(client, indexName, 0, numOfDocs);
        String snapshotName2 = "test-restore-snapshot2";
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());  
            );  
        assertRemoteSegmentsAndTranslogUploaded(restoredIndexName2);
        // Create index  
                if (i < numberOfSnapshots - 1) {
                .setIndices(index)
        createIndex(indexName1, indexSettings);
        clusterAdmin().prepareCleanupRepository(BASE_REMOTE_REPO).get();
        for (int i = 0; i < numOfDocs; i++) {
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
        ensureGreen(restoredIndexName1);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
            IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(),  
        ensureGreen(indexName2);  
        // Create new snapshot, segment and translog repositories
import java.util.Map;
import org.opensearch.index.IndexSettings;
        GetRepositoriesRequest gr = new GetRepositoriesRequest(new String[] { sourceRepository });  
                .get()  
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.translog.repository]" + " on restore"));  
        ensureGreen(restoredIndexName1);
                .setIndices()  
            () -> client().admin()  
        );
    @Override  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
    public void testRestoreOperationsShallowCopyEnabled() throws Exception {
        assertThat(snapshotInfo2.successfulShards(), equalTo(snapshotInfo2.totalShards()));
        Client client = client();  
                .setIndices(index)  
                    .prepareUpdateSettings()
        DeleteResponse deleteResponse = client().prepareDelete(index, "0").execute().actionGet();
        ensureGreen(restoredIndexName1);
        restoreSnapshotResponse = client.admin()
                .setWaitForCompletion(true)
        final int numDocsInIndex1 = randomIntBetween(20, 30);
        long totalDocs = 0;  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY;
        exception = expectThrows(  
        String snapshotName1 = "test-restore-snapshot1";
        // try index restore with index.remote_store.translog.repository and index.remote_store.segment.repository modified
        assertDocsPresentInIndex(client, restoredIndexName2, numDocsInIndex2);
            String id = Integer.toString(i);
        assertEquals(snapshotInfo.totalShards(), snapshotInfo.successfulShards());  
        assertDocsPresentInIndex(client, indexName1, numDocsInIndex1 + 4);
            .setWaitForCompletion(false)
            .setRenamePattern(indexName1)
            assertBusy(() -> {
        assertEquals(RestStatus.ACCEPTED, restoreSnapshotResponse.status());
        indexDocuments(client, indexName1, 0, numDocsInIndex1);
                .setIndices(index)  
        logger.info("Path 1 [{}]", absolutePath1);  
        // deleting data for restoredIndexName1 and restoring from remote store.  
            restoredIndexName1version2,
import org.opensearch.snapshots.SnapshotRestoreException;
        return Arrays.asList(  
            .setRenameReplacement(restoredIndexName2)
        assertFalse(indexExists(indexName1));
        assertDocsPresentInIndex(client(), indexName1, numDocsInIndex1);
                )
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1);
        assertThat(recoveryState.getIndex().recoveredBytesPercent(), greaterThanOrEqualTo(0.0f));
        path = getShardLevelBlobPath(client, idx, new BlobPath(), "0", TRANSLOG, DATA, translogPathFixedPrefix).buildAsString();
        ensureGreen(restoredIndexName1version2);
    public void testSuccessfulIndexRestoredFromSnapshotWithUpdatedSetting() throws IOException, ExecutionException, InterruptedException {
        Settings multipleRemoteStoreIndexSettings = Settings.builder()  
import org.opensearch.common.Nullable;
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;  
        Settings.Builder settingsBuilder = Settings.builder()
    public void testInvalidRestoreRequestScenarios() throws Exception {
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(indexName1).restoreAllShards(false), PlainActionFuture.newFuture());
        @Nullable RemoteStoreEnums.PathHashAlgorithm pathHashAlgorithm  
        internalCluster().startDataAndWarmNodes(1);
    ) {
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));  
        String snapshotRepoName = "test-restore-snapshot-repo";
            SnapshotRestoreException.class,  
        );
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), IndexSettings.DEFAULT_REFRESH_INTERVAL)  
            .setSourceRemoteStoreRepository(newSegmentRepo)
                    .storedFields()  
        assertEquals(deleteResponse.getResult(), DocWriteResponse.Result.DELETED);
        );  
        String[] pathTokens = absolutePath1.toString().split("/");
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        assertEquals(deleteResponse.getResult(), DocWriteResponse.Result.DELETED);
        SnapshotInfo snapshotInfo1 = createSnapshot(  
        ensureGreen(indexName1);
        assertFalse(recoveryState.getIndex().fileDetails().isEmpty());
        assertDocsPresentInIndex(client(), indexName1, numDocsInIndex1);
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), false).build() },
        Client client = client();
            .setIndices(indexName1)
                snapshots.put(snapshotName, totalDocs);
        String restoredIndexName1 = indexName1 + "-restored";  
                assertAcked(client().admin().indices().delete(new DeleteIndexRequest(index)).get());
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(Arrays.asList(indexName1)));  
        pathTokens = absolutePath2.toString().split("/");
            .setTransientSettings(Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), RemoteStoreEnums.PathType.FIXED))
            logger.info("Restoring snapshot: {}", snapshot);
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), randomFrom(RemoteStoreEnums.PathType.values()))
            Stream<Path> translogMetadata = Files.list(remoteTranslogMetadataPath);  
                .setWaitForCompletion(false)
        assertNotNull(indexService);
        indexDocuments(client, indexName1, extraNumDocsInIndex1);
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
        Arrays.copyOf(pathTokens, pathTokens.length - 1);
        }  
                assertAcked(client().admin().indices().prepareClose(index));  
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName1)).get());
        // Re-initialize client to make sure we are not using client from stopped node.
    }
        assertEquals(0, recoveryState.getShardId().getId());  
import java.util.stream.Collectors;  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numOfShards)
    }  
        updateRepository(snapshotRepo, "fs", getRepositorySettings(absolutePath1, false));
        );
import java.util.ArrayList;
        ensureGreen(indexName1);  
                logger.info("--> waiting for {} docs to be indexed ...", numDocs);
        client().admin().indices().close(Requests.closeIndexRequest(indexName1)).get();
        Settings indexSettings2 = getIndexSettings(1, 0).build();
        ensureGreen(indexName1, restoredIndexName2);  
                .setRenameReplacement(restoredIndex)
            .setWaitForCompletion(false)
        Settings remoteStoreSegmentIndexSettings = Settings.builder()
                logger.info("--> waiting for {} docs to be indexed ...", numDocs);
        ensureGreen(indexName1);  
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)  
    private static final String BASE_REMOTE_REPO = "test-rs-repo" + TEST_REMOTE_STORE_REPO_SUFFIX;  
                .cluster()
            assertAcked(client().admin().indices().delete(new DeleteIndexRequest(index)).get());  
    public void testRestoreOperationsUsingDifferentRepos() throws Exception {
                .setIndices(index)  
    }
        indexDocuments(client(), indexName1, numDocsInIndex1);
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
        assertEquals(1, recoveryResponse.shardRecoveryStates().get(restoredIndexName1).size());
        String snapshotName2 = "test-restore-snapshot2";  
            .setWaitForCompletion(false)
        internalCluster().startDataAndWarmNodes(1);  
        }
            SnapshotRestoreException.class,
        ensureYellowAndNoInitializingShards(restoredIndexName1);  
        String restoredIndexName2 = indexName2 + "-restored";
        logger.info("--> snapshot");  
            .get();
            .setWaitForCompletion(false)  
        ensureGreen(indexName1);  
    }  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));
                snapshots.put(snapshotName, totalDocs);
        assertThat(snapshotInfo2.successfulShards(), greaterThan(0));
        );
                .setIgnoreIndexSettings(
        // Create repo  
            int numberOfSnapshots = 2;  
                Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), RemoteStoreEnums.PathType.HASHED_PREFIX)
            .get();
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, newRemoteStoreRepo)  
    }
        assertNotNull(remoteCustomData);
    }
        Settings indexSettings = getIndexSettings(1, 0).build();
        logger.info("Path 2 [{}]", absolutePath2);
        String basePath = pathTokens[pathTokens.length - 1];  
        String primary = internalCluster().startDataAndWarmNodes(1).get(0);
        indexDocuments(client, indexName1, numDocsInIndex1, 2 * numDocsInIndex1);
        String restoredIndex = index + "-restored";  
            .setSourceRemoteStoreRepository(remoteStoreRepoNameUpdated)
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;  
        assertEquals(restoreSnapshotResponse1.status(), RestStatus.ACCEPTED);
        if (WRITABLE_WARM_INDEX_SETTING.get(settings)) {  
        internalCluster().startDataAndWarmNodes(1);
            snapshotRepoName,
            .cluster()  
import org.opensearch.cluster.metadata.RepositoryMetadata;  
            .cluster()
        createIndex(indexName1, indexSettings);
                new RestoreRemoteStoreRequest().indices(restoredIndexName1).restoreAllShards(true),  
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));  
            )  
import org.opensearch.snapshots.SnapshotState;
        final int numDocsInIndex1 = 5;  
            assertEquals(pathHashAlgorithm.name(), remoteCustomData.get(RemoteStoreEnums.PathHashAlgorithm.NAME));
        logger.info("Snapshot Path [{}]", absolutePath1);
        String snapshotRepo = "test-restore-snapshot-repo";  
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
            } else {
        return settingsBuilder;
            );
                    IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY
        );  
        client.admin()
                    .setQuery(matchAllQuery())
        String restoredIndexName1 = indexName1 + "-restored";  
        assertEquals(0, recoveryResponse.getFailedShards());
        updateRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, false));
        // try index restore with index.remote_store.enabled ignored
            assertAcked(client().admin().indices().prepareDelete("_all").get());
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;  
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
        // Close index 2
                String snapshotName = baseSnapshotName + i;  
        RestoreSnapshotResponse restoreSnapshotResponse2 = client.admin()
        // indexing some new docs and validating  
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.timeValueSeconds(randomIntBetween(1, 5)));
            () -> client().admin()
                .prepareRestoreSnapshot(snapshotRepo, snapshot)
        String snapshotName2 = "test-restore-snapshot2";  
        ensureGreen(indexName1);
                .setWaitForCompletion(false)
                    numDocs = randomIntBetween(200, 300);
        createIndex(index, indexSettings);
        }  
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
import org.opensearch.index.shard.IndexShard;
        var primary = internalCluster().startDataAndWarmNodes(1, settings).get(0);
        exception = expectThrows(
        assertTrue(snapshotInfo.successfulShards() > 0);
        String basePath = pathTokens[pathTokens.length - 1];
                    .setSize((int) finalTotalDocs)
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        RecoveryState recoveryState = recoveryResponse.shardRecoveryStates().get(restoredIndexName1).get(0);
    protected Settings.Builder getRepositorySettings(String sourceRepository, boolean readOnly) throws ExecutionException,
        Path segmentMetadataPath = Path.of(remoteRepoPath + "/" + path);
        Client client = client();
                    .isAcknowledged()
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
        assertTrue(recoveryResponse.shardRecoveryStates().containsKey(restoredIndexName1));
        Path absolutePath2 = randomRepoPath().toAbsolutePath();  
        validatePathType(indexName1, RemoteStoreEnums.PathType.FIXED);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
                            .put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), randomFrom(RemoteStoreEnums.PathType.values()))
            () -> client().admin()
        assertTrue(recoveryState.getIndex().recoveredFileCount() > 0);
        ensureGreen(restoredIndexName1);
        // indexing some new docs and validating
        final Optional<Integer> shardId = indexService.shardIds().stream().findFirst();  
        ).build();
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
                .get()  
            .build();
        logger.info("Snapshot Path [{}]", absolutePath1);  
    public void testRestoreShallowSnapshotRepository() throws ExecutionException, InterruptedException {
                    )  
            .put(SYSTEM_REPOSITORY_SETTING.getKey(), false);
                .get()
        Arrays.copyOf(pathTokens, pathTokens.length - 1);
        assertEquals(deleteResponse.getResult(), DocWriteResponse.Result.DELETED);  
                    .admin()
        String snapshotName1 = "test-snapshot1";
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "300s");  
            assertTrue(  
        assertTrue(recoveryState.getIndex().totalRecoverBytes() > 0L);
                .setIndexSettings(remoteStoreSegmentIndexSettings)
            .cluster()  
        String indexName1 = "testindex1";  
        if (shallowCopyEnabled) {  
        DeleteResponse deleteResponse = client().prepareDelete(indexName1, "0").execute().actionGet();
        assertThat(snapshotInfo1.state(), equalTo(SnapshotState.SUCCESS));
        client = client(clusterManagerNode);
                .setRenamePattern(index)
        Settings indexSettings = getIndexSettings(1, 0).put(
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
        flushAndRefresh(indexName1);  
        // ensure populated file details
        Path segmentDataPath = Path.of(remoteRepoPath + "/" + path);  
        ensureRed(restoredIndexName1);
        Client client = client();
                    .getTotalHits()
        internalCluster().startClusterManagerOnlyNode();
                .setIndices(index)  
        assertDocsPresentInIndex(client, restoredIndexName2, numDocsInIndex2);
        internalCluster().startClusterManagerOnlyNode(settings);  
        createRepository(snapshotRepo, "fs", getRepositorySettings(absolutePath1, true));  
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName2)  
    }
        Map<String, Long> snapshots = new HashMap<>();
            .setIndices(indexName1)  
        );
            .setRenamePattern(indexName2)
        pathTokens = absolutePath2.toString().split("/");  
import org.opensearch.cluster.ClusterState;
        String indexName1 = "testindex1";
import java.util.concurrent.TimeUnit;
        assertEquals(1, recoveryResponse.getSuccessfulShards());
                .setRenamePattern(index)
        ensureGreen(indexName1);  
        String snapshotRepoName = "test-restore-snapshot-repo";
import java.util.Arrays;  
        createRepository(remoteStoreRepoNameUpdated, "fs", remoteRepoPath);
        assertThat(snapshotInfo1.successfulShards(), greaterThan(0));
            .setRenameReplacement(restoredIndexName1)
            .setIndices(indexName2)  
        assertTrue(restoreSnapshotResponse2.getRestoreInfo().failedShards() == 0);  
                    IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY,  
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;  
        logger.info("Snapshot Path [{}]", absolutePath1);
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>());
import org.opensearch.test.InternalTestCluster;
        internalCluster().startDataAndWarmNodes(2);  
        RestoreSnapshotResponse restoreSnapshotResponse1 = client.admin()
            SnapshotRestoreException.class,
            .build();  
        assertEquals(snapshotInfo.totalShards(), snapshotInfo.successfulShards());
        String indexName1 = "testindex1";
        indexDocuments(client, indexName2, numDocsInIndex2);
                }
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1 + 2);
            RemoteStoreEnums.PathType.HASHED_PREFIX,
        }  
                .setRenameReplacement(restoredIndex)
        validatePathType(  
        assertThat(snapshotInfo1.successfulShards(), greaterThan(0));
        // indexing some new docs and validating
                .setRenameReplacement(restoredIndex)  
package org.opensearch.remotestore;
            .setWaitForCompletion(false)
        flushAndRefresh(indexName1);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
            snapshotRepoName,
 * The OpenSearch Contributors require contributions made to  
        Path location = PathUtils.get(String.join("/", pathTokens));
        // try index restore with index.number_of_replicas setting modified. index.number_of_replicas can be modified on restore  
        }  
        assertTrue(recoveryState.getIndex().totalFileCount() > 0);  
        String restoredIndexName2 = indexName2 + "-restored";
    @Override
            snapshotName2,
        String snapshotRepoName = "test-restore-snapshot-repo";  
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
        createIndex(indexName2, indexSettings2);
import java.util.stream.Stream;
        // Restore using new repos
            RemoteStorePinnedTimestampService.class,
        // deleting data for restoredIndexName1 and restoring from remote store.
        String snapshotRepoName = "test-restore-snapshot-repo";
            .setTransientSettings(Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), RemoteStoreEnums.PathType.FIXED))  
        assertEquals(restoreSnapshotResponse1.status(), RestStatus.ACCEPTED);
            .put(rmd.settings())
                    .storedFields()  
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepo, snapshotName1, new ArrayList<>(List.of(index)));  
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName2)  
            .prepareUpdateSettings()  
                    indexer.continueIndexing(numDocs);
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;  
        String primary = internalCluster().startDataAndWarmNodes(1).get(0);
        assertThat(snapshotInfo2.successfulShards(), equalTo(snapshotInfo2.totalShards()));
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        Settings indexSettings = getIndexSettings(1, 0).build();
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));  
    protected void indexDocuments(Client client, String indexName, int fromId, int toId) {
            .setIndexSettings(numberOfReplicasSettings)
        internalCluster().startClusterManagerOnlyNode();
                createSnapshot(snapshotRepo, snapshotName, new ArrayList<>());
        String snapshotRepoName = "test-snapshot-repo";
    }
        assertDocsPresentInIndex(client, indexName1, numDocsInIndex1);  
import org.opensearch.indices.IndicesService;
                .cluster()
            assertEquals(RestStatus.OK, restoreSnapshotResponse1.status());  
        final int numDocsInIndex1 = 5;
        if (WRITABLE_WARM_INDEX_SETTING.get(settings)) {
            assertTrue(segmentMetadata.count() > 0);
            RemoteStoreEnums.PathHashAlgorithm.FNV_1A_COMPOSITE_1  
        RepositoryMetadata rmd = res.repositories().get(0);
import java.util.concurrent.ExecutionException;
        indexDocuments(client, indexName1, numDocsInIndex1);
                Long hits = client().prepareSearch(index)  
                .setRenameReplacement(restoredIndex)
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1 + 2);  
import org.opensearch.snapshots.SnapshotInfo;  
        // indexing some new docs and validating
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;  
import org.opensearch.action.DocWriteResponse;
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;
    private IndexShard getIndexShard(String node, String indexName) {
            .cluster()
            .cluster()  
        assertThat(snapshotInfo1.successfulShards(), greaterThan(0));
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)  
        ensureYellowAndNoInitializingShards(indexName1);
        assertThat(snapshotInfo2.successfulShards(), greaterThan(0));  
            // Verify restored index's stats
            .prepareUpdateSettings()
        assertThat(snapshotInfo1.successfulShards(), greaterThan(0));  
    private Path remoteRepoPath;
            for (int i = 0; i < numberOfSnapshots; i++) {  
        indexDocuments(client, restoredIndexName1, numDocsInIndex1, numDocsInIndex1 + 2);  
        // Delete index  
        ensureGreen(restoredIndexName1version1);
}
            Stream<Path> segmentData = Files.list(segmentDataPath);  
                .setWaitForCompletion(false)
        // try index restore with index.remote_store.translog.repository modified
            .get();
        for (String snapshot : snapshots.keySet()) {  
            .setIndices(indexName1)
            IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(),
        assertThat(recoveryState.getIndex().time(), greaterThanOrEqualTo(0L));  
        assertDocsPresentInIndex(client(), indexName1, numDocsInIndex1);
        createRepository(snapshotRepo, "fs", getRepositorySettings(absolutePath1, true));
    }
        client.admin()  
        );
        totalDocs += numDocs;
        logger.info("--> snapshot");
        logger.info("--> snapshot");
    }  
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
                .setRenamePattern(index)
        createIndex(indexName1, indexSettings);
        ensureGreen(restoredIndexName1, restoredIndexName2);
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
    public RestoreShallowSnapshotV2IT(Settings nodeSettings) {  
            .setWaitForCompletion(false)
        String index,
                .setRenamePattern(index)
        assertThat(snapshotInfo1.successfulShards(), equalTo(snapshotInfo1.totalShards()));  
        indexDocuments(client, index, numDocsInIndex);  
        assertEquals(restoreSnapshotResponse1.status(), RestStatus.ACCEPTED);  
                .setIndices()  
        internalCluster().startClusterManagerOnlyNode();  
        RestoreSnapshotResponse restoreSnapshotResponse2 = client.admin()  
        validatePathType(restoredIndexName1version1, RemoteStoreEnums.PathType.FIXED);
        exception = expectThrows(
        final int numDocsInIndex1 = randomIntBetween(20, 30);
                        Settings.builder()  
        assertThat(snapshotInfo2.successfulShards(), greaterThan(0));  
            // Verify restored index's stats
        ensureGreen(indexName1);
                    .value();
        ensureGreen(indexName1);
    public void testRemoteRestoreIndexRestoredFromSnapshot() throws IOException, ExecutionException, InterruptedException {
                    .getTotalHits()
        int extraNumDocsInIndex1 = randomIntBetween(20, 50);  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfReplicas)
        try (
        restoreSnapshotResponse = client.admin()  
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));  
        logger.info("Snapshots Status: " + snapshots);
        assertDocsPresentInIndex(client(), indexName1, 2 * numDocsInIndex1);
import org.opensearch.common.util.io.IOUtils;
    public void testRestoreShallowSnapshotIndexAfterSnapshot() throws ExecutionException, InterruptedException {
import org.junit.After;
        String snapshotName2 = "test-restore-snapshot2";
        createRepository(newTranslogRepo, "fs", getRepositorySettings(BASE_REMOTE_REPO, true));
import org.opensearch.core.rest.RestStatus;
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, enableShallowCopy));
        SnapshotRestoreException exception = expectThrows(
            () -> client().admin()
                internalCluster().client()
            .setWaitForCompletion(true)
        createRepository(snapshotRepoName, "fs", getRepositorySettings(location, basePath, true));
                    totalDocs += numDocs;
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)  
import org.opensearch.indices.replication.common.ReplicationType;
        exception = expectThrows(
        assertDocsPresentInIndex(client, indexName1, 3 * numDocsInIndex1);  
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.SEGMENTS;
            .get();  
            settingsBuilder.put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.segment.repository]" + " on restore"));
                .get()  
        if (Objects.nonNull(pathHashAlgorithm)) {
        createIndex(index, indexSettings);
        ensureGreen(index);
                .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
import org.opensearch.index.remote.RemoteStoreEnums;
            .cluster()
        super(nodeSettings);
        assertAcked(client().admin().indices().prepareClose(indexName2));  
        assertTrue(restoreSnapshotResponse2.getRestoreInfo().failedShards() == 0);
                    .setQuery(matchAllQuery())
    void assertRemoteSegmentsAndTranslogUploaded(String idx) throws IOException {
        logger.info("--> snapshot");
            .build();  
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
            settingsBuilder.put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true);
            long finalTotalDocs = totalDocs;
        internalCluster().startClusterManagerOnlyNode();
        }  
        Client client = client();  
        assertThat(recoveryState.getIndex().recoveredFilesPercent(), greaterThanOrEqualTo(0.0f));  
 */  
            .setIndices(indexName2)
import org.opensearch.common.io.PathUtils;
        ensureGreen(indexName1);
            .cluster()
    }  
        Path remoteTranslogDataPath = Path.of(remoteRepoPath + "/" + path);
        }  
        createRepository(newSegmentRepo, "fs", getRepositorySettings(BASE_REMOTE_REPO, true));  
            assertBusy(() -> {
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, newRemoteStoreRepo)
    }
        path = getShardLevelBlobPath(client, idx, new BlobPath(), "0", SEGMENTS, DATA, segmentsPathFixedPrefix).buildAsString();
            String id = Integer.toString(i);
    protected Settings nodeSettings(int nodeOrdinal) {
                .cluster()  
        refresh(indexName1);  
        ensureGreen(restoredIndexName1);
        assertEquals(RestStatus.ACCEPTED, restoreSnapshotResponse.status());  
            .build();
        settingsBuilder.put("location", location);
        ensureGreen(indexName1, indexName2);
            () -> client().admin()
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>());  
        logger.info("Snapshot Path [{}]", absolutePath1);
        int numDocs = randomIntBetween(200, 300);
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)  
        String snapshotName1 = "test-restore-snapshot1";  
        // Take V2 snapshot  
    }  
            () -> client().admin()
            .get();  
                .get();
        updateRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, false));  
                    .get()
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import org.opensearch.common.unit.TimeValue;  
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
        assertThat(snapshotInfo2.successfulShards(), equalTo(snapshotInfo2.totalShards()));  
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(randomIntBetween(1, 5)));
        // indexing some new docs and validating  
            .setTransientSettings(
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        String path = getShardLevelBlobPath(client, idx, new BlobPath(), "0", TRANSLOG, METADATA, translogPathFixedPrefix).buildAsString();
        // Validating that custom data has not changed for testindex2 which was created before the cluster setting got updated
        assertTrue(recoveryState.getIndex().totalBytes() > 0L);  
    }  
        String indexName2 = "testindex2";
            new ArrayList<>(Arrays.asList(indexName1, indexName2))
        InterruptedException {
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        ensureGreen(restoredIndexName1);
            RestoreSnapshotResponse restoreSnapshotResponse1 = client.admin()
import java.util.Objects;
        ensureGreen(indexName1, indexName2);
        // ensure recovery details are non-zero
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)  
        String snapshotRepo = "test-restore-snapshot-repo";
            .cluster()  
    private void assertDocsPresentInIndex(Client client, String indexName, int numOfDocs) {  
    public void testContinuousIndexing() throws Exception {  
                    .actionGet()
        int numDocsInIndex1 = randomIntBetween(2, 5);
        client(clusterManagerNode).admin()
                var fileCache = node.fileCache();
            SnapshotRestoreException.class,  
        ensureGreen(indexName1);  
        String snapshotRepoName = "test-restore-snapshot-repo";  
            .put(remoteStoreClusterSettings(BASE_REMOTE_REPO, remoteRepoPath))
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));  
        Path location2 = PathUtils.get(String.join("/", pathTokens));  
            primaryNodeName(index)  
        createIndex(indexName2, indexSettings);
        Settings indexSettings = getIndexSettings(1, 0).put(  
        Settings numberOfReplicasSettings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build();
        logger.info("Snapshot Path [{}]", absolutePath1);  
            .get();  
import org.opensearch.index.IndexModule;  
        String basePath2 = pathTokens[pathTokens.length - 1];
        assertTrue(exception.getMessage().contains("cannot remove setting [index.remote_store.enabled] on restore"));
        assertThat(snapshotInfo1.successfulShards(), equalTo(snapshotInfo1.totalShards()));
            snapshotName2,  
        Path absolutePath2 = randomRepoPath().toAbsolutePath();
        internalCluster().startDataAndWarmNodes(1);
        SnapshotInfo snapshotInfo2 = createSnapshot(snapshotRepo, snapshotName2, new ArrayList<>(List.of(index)));  
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)  
                .setIndices(index)  
        Settings indexSettings = getIndexSettings(1, 0).build();
        path = getShardLevelBlobPath(client, idx, new BlobPath(), "0", SEGMENTS, METADATA, segmentsPathFixedPrefix).buildAsString();  
    protected Settings.Builder getRepositorySettings(Path location, boolean shallowCopyEnabled) {  
import java.util.Optional;  
                .setIndices(index)
        for (String snapshot : snapshots.keySet()) {
        // try index restore with index.remote_store.translog.repository ignored
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)  
        assertThat(snapshotInfo2.state(), equalTo(SnapshotState.SUCCESS));
            .cluster()
            .setRenamePattern(indexName1)  
            ensureGreen(TimeValue.timeValueSeconds(60), index);  
        internalCluster().startClusterManagerOnlyNode();  
            IndexSettings.DEFAULT_REFRESH_INTERVAL
                createSnapshot(snapshotRepo, snapshotName, new ArrayList<>());  
            .get();  
            .get();
                if (i < numberOfSnapshots - 1) {  
            assertTrue(translogMetadata.count() > 0);
        Settings indexSettings = getIndexSettings(1, 0).build();  
            .get();  
        Settings indexSettings2 = getIndexSettings(1, 0).build();  
        ensureGreen(indexName1);
        logger.info("Snapshot Path [{}]", absolutePath1);  
        ) {
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.timeValueSeconds(randomIntBetween(1, 5)));
        indexDocuments(client, indexName1, numDocsInIndex1, numDocsInIndex1 + 2);  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
        // Validating that custom data has not changed for indexes which were created before the cluster setting got updated  
        disableRepoConsistencyCheck("Remote store repo");  
        }  
            .setRenamePattern(indexName1)
            .setIndices(indexName2)
        indexDocuments(client, restoredIndexName1, numDocsInIndex1, numDocsInIndex1 + 2);  
            assertTrue(segmentData.count() > 0);  
import org.opensearch.transport.client.Requests;
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.segment.repository]" + " on restore"));
            long finalTotalDocs = totalDocs;
            logger.info("Restoring snapshot: {}", snapshot);
        Settings indexSettings = getIndexSettings(1, 0).put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
        createIndex(indexName2, indexSettings2);
import org.opensearch.core.index.Index;
        ensureGreen(index);
                    numDocs = randomIntBetween(200, 300);  
            .get();
        validatePathType(indexName2, RemoteStoreEnums.PathType.HASHED_PREFIX, RemoteStoreEnums.PathHashAlgorithm.FNV_1A_COMPOSITE_1);
        logger.info("Path 1 [{}]", absolutePath1);
            logger.info("checking for index " + indexName + " with docId" + id);  
        String primary = internalCluster().startDataAndWarmNodes(1).get(0);
    }  
    }
    }  
            .prepareUpdateSettings()
import org.opensearch.core.common.unit.ByteSizeUnit;
            assertTrue("doc with id" + id + " is not present for index " + indexName, client.prepareGet(indexName, id).get().isExists());
import org.opensearch.cluster.metadata.IndexMetadata;
            () -> client().admin()
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        indexDocuments(client, indexName1, numDocsInIndex1, numDocsInIndex1 + randomIntBetween(2, 5));  
        internalCluster().startDataAndWarmNodes(1);
        String indexName1 = "testindex1";  
        Settings indexSettings = getIndexSettings(1, 0).build();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        Map<String, Long> snapshots = new HashMap<>();
        logger.info("--> snapshot");  
            IndexSettings.DEFAULT_REFRESH_INTERVAL
                .setIgnoreIndexSettings(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY)
        SnapshotInfo snapshotInfo1 = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(Arrays.asList(indexName1)));
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        Path absolutePath1 = randomRepoPath().toAbsolutePath();  
        IndexService indexService = indicesService.indexService(index);
            SnapshotRestoreException.class,  
import org.opensearch.core.common.unit.ByteSizeValue;  
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING;  
        ensureGreen(indexName2);
        String snapshotRepo = "test-restore-snapshot-repo";  
            .build();
        Client client = client();
                    indexer.continueIndexing(numDocs);
        client = client(clusterManagerNode);
        String snapshotName1 = "test-restore-snapshot1";  
                PlainActionFuture.newFuture()
        validatePathType(indexName1, RemoteStoreEnums.PathType.FIXED);  
import org.opensearch.action.delete.DeleteResponse;
        indexDocuments(client, indexName1, numDocsInIndex1);
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName1)).get());  
    }
                .get()  
        createRepository(remoteStoreRepoNameUpdated, "fs", remoteRepoPath);
        client().admin()
import org.opensearch.indices.recovery.RecoveryState;  
public class RestoreShallowSnapshotV2IT extends AbstractSnapshotIntegTestCase {
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.enabled]" + " on restore"));
        String basePath2 = pathTokens[pathTokens.length - 1];  
        String index = "test-index";
                .get()  
        assertTrue(snapshotInfo.successfulShards() > 0);
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName2)
