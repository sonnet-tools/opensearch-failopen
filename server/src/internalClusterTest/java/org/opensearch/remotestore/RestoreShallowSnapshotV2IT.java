import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            Stream<Path> translogMetadata = Files.list(remoteTranslogMetadataPath);
                .setIgnoreIndexSettings(
        );
        String indexName1 = "testindex1";
        createRepository(snapshotRepoName, "fs", getRepositorySettings(location, basePath, true));
        String indexName1 = "testindex1";
            .build();
    }
            .put(super.indexSettings())
        assertThat(snapshotInfo1.successfulShards(), equalTo(snapshotInfo1.totalShards()));
        createRepository(newSegmentRepo, "fs", getRepositorySettings(BASE_REMOTE_REPO, true));
        logger.info("--> snapshot");
            .setWaitForCompletion(false)
        assertTrue(recoveryState.getIndex().recoveredFileCount() > 0);
                .get();
        var primary = internalCluster().startDataAndWarmNodes(1, settings).get(0);
            );
        GetRepositoriesRequest gr = new GetRepositoriesRequest(new String[] { sourceRepository });
        );
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.segment.repository]" + " on restore"));
        logger.info("Snapshot Path [{}]", absolutePath1);
        String restoredIndexName1 = indexName1 + "-restored";
        validatePathType(indexName1, RemoteStoreEnums.PathType.FIXED);
import java.util.ArrayList;
        }
        pathTokens = absolutePath2.toString().split("/");
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        final int numDocsInIndex2 = 6;
import org.opensearch.indices.IndicesService;
                    .admin()
        assertThat(recoveryState.getIndex().recoveredFilesPercent(), greaterThanOrEqualTo(0.0f));
        exception = expectThrows(
        indexDocuments(client(), indexName1, numDocsInIndex1);
import org.opensearch.common.unit.TimeValue;
        SnapshotInfo snapshotInfo2 = createSnapshot(
 * The OpenSearch Contributors require contributions made to
        Settings indexSettings = getIndexSettings(1, 0).build();
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
    public void teardown() {
            );
        assertThat(snapshotInfo1.successfulShards(), greaterThan(0));
        assertTrue(recoveryState.getIndex().totalBytes() > 0L);
    public void testRestoreOperationsUsingDifferentRepos() throws Exception {
        ensureGreen(indexName1);
                .setIndexSettings(remoteStoreSegmentIndexSettings)
import java.nio.file.Path;
                if (i < numberOfSnapshots - 1) {
            .put(rmd.settings())
        ensureGreen(restoredIndexName1);
            )
        );
            IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(),
 *
        String index = "test-index";
            .get();
            .get();
        assertDocsPresentInIndex(client(), indexName1, numDocsInIndex1);
            .cluster()
        client.admin()
            int numberOfSnapshots = 2;
        }
                .setRenameReplacement(restoredIndex)
            snapshotRepoName,
        Arrays.copyOf(pathTokens, pathTokens.length - 1);
        indexDocuments(client, indexName1, numDocsInIndex1);
        assertThat(recoveryState.getIndex().time(), greaterThanOrEqualTo(0L));
    }
        ensureYellowAndNoInitializingShards(indexName1);
        logger.info("Path 1 [{}]", absolutePath1);
        client().admin()
        Client client = client();
        validatePathType(
    }
import java.util.Map;
        internalCluster().startClusterManagerOnlyNode();
        Settings indexSettings = getIndexSettings(1, 0).put(
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
import org.opensearch.action.DocWriteResponse;
        Client client = client();
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "300s");
        assertThat(snapshotInfo1.state(), equalTo(SnapshotState.SUCCESS));
        internalCluster().startClusterManagerOnlyNode();
                    indexer.continueIndexing(numDocs);
        String snapshotName2 = "test-restore-snapshot2";
    protected Settings nodeSettings(int nodeOrdinal) {
                new RestoreRemoteStoreRequest().indices(restoredIndexName1).restoreAllShards(true),
        internalCluster().startClusterManagerOnlyNode();
        String index = "test-index";
import org.opensearch.core.common.unit.ByteSizeUnit;
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
        RestoreSnapshotResponse restoreSnapshotResponse1 = client.admin()
            () -> client().admin()
    }
import java.util.Arrays;
    @Override
import java.util.List;
        ensureGreen(indexName1, indexName2);
                            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_METADATA.getKey(), randomBoolean())
        createIndex(indexName1, indexSettings);
import org.junit.Before;
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
        assertThat(snapshotInfo2.successfulShards(), equalTo(snapshotInfo2.totalShards()));
                long finalTotalDocs1 = totalDocs;
            .cluster()
import org.opensearch.core.index.Index;
        createIndex(indexName1, indexSettings);
        createIndex(indexName1, indexSettings);
        Settings.Builder settingsBuilder = Settings.builder()
        Arrays.copyOf(pathTokens, pathTokens.length - 1);
    public void testSuccessfulIndexRestoredFromSnapshotWithUpdatedSetting() throws IOException, ExecutionException, InterruptedException {
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
    }
            assertAcked(client().admin().indices().prepareDelete("_all").get());
        validatePathType(index, pathType, null);
            assertTrue(
        createIndex(indexName2, indexSettings2);
import org.opensearch.node.Node;
        indexDocuments(client, indexName1, extraNumDocsInIndex1);
        createRepository(newTranslogRepo, "fs", getRepositorySettings(BASE_REMOTE_REPO, true));
            .cluster()
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1 + 2);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;
        String snapshotRepoName = "test-restore-snapshot-repo";
                    .actionGet()
        final int numDocsInIndex2 = 6;
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1 + 2);
        try (BackgroundIndexer indexer = new BackgroundIndexer(index, MapperService.SINGLE_MAPPING_NAME, client(), numDocs)) {
        }
        String basePath = pathTokens[pathTokens.length - 1];
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
            .setIndices(indexName1)
        Settings indexSettings = getIndexSettings(1, 0).build();
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
import org.opensearch.index.IndexSettings;
        assertEquals(deleteResponse.getResult(), DocWriteResponse.Result.DELETED);
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING;
        return settingsBuilder;
                .setRenamePattern(index)
            .setRenamePattern(indexName1)
import org.opensearch.index.remote.RemoteStoreEnums;
        // Index 5 documents, refresh, index 5 documents
        String path = getShardLevelBlobPath(client, idx, new BlobPath(), "0", TRANSLOG, METADATA, translogPathFixedPrefix).buildAsString();
                    )
            assertTrue(segmentMetadata.count() > 0);
        indexDocuments(client, restoredIndexName1, numDocsInIndex1, numDocsInIndex1 + 2);
    @Before
        logger.info("--> snapshot");
            .build();
        try (
                snapshots.put(snapshotName, totalDocs);
        Settings indexSettings = getIndexSettings(1, 0).build();
        );
    private IndexShard getIndexShard(String node, String indexName) {
                    .getHits()
import org.opensearch.test.OpenSearchIntegTestCase;
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        // ensure populated bytes details
        String basePath2 = pathTokens[pathTokens.length - 1];
        String[] pathTokens = absolutePath1.toString().split("/");
            () -> client().admin()
        ensureGreen(indexName1);
        );
            SnapshotRestoreException.class,
        String snapshotName1 = "test-restore-snapshot1";
    }
        indexDocuments(client, indexName1, numDocsInIndex1, numDocsInIndex1 + 2);
        assertThat(recoveryState.getIndex().recoveredBytesPercent(), lessThanOrEqualTo(100.0f));
        ensureGreen(restoredIndexName1);
                String snapshotName = baseSnapshotName + i;
        Settings.Builder settingsBuilder = randomRepositorySettings();
import org.opensearch.cluster.ClusterState;
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
                .setRenameReplacement(restoredIndex)
                    .execute()
        updateRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, false));
    }
            .setIndices(indexName2)
public class RestoreShallowSnapshotV2IT extends AbstractSnapshotIntegTestCase {
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(indexName1).restoreAllShards(false), PlainActionFuture.newFuture());
        // ensure populated file details
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
import org.opensearch.common.blobstore.BlobPath;
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), randomFrom(RemoteStoreEnums.PathType.values()))
                .setRenameReplacement(restoredIndex)
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, newRemoteStoreRepo)
            .get();
        client = client(clusterManagerNode);
        if (WRITABLE_WARM_INDEX_SETTING.get(settings)) {
        String restoredIndexName1version2 = indexName1 + "-restored-2";
        internalCluster().startDataAndWarmNodes(1);
        ensureGreen(indexName1);
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName2)
        logger.info("--> snapshot");
        assertThat(snapshotInfo2.successfulShards(), greaterThan(0));
            .cluster()
        assertThat(snapshotInfo2.successfulShards(), greaterThan(0));
        assertEquals(RestStatus.ACCEPTED, restoreSnapshotResponse.status());
        Path segmentDataPath = Path.of(remoteRepoPath + "/" + path);
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1);
    }
    }
            .cluster()
            }
            .setIndices(indexName1)
                .setRenameReplacement(restoredIndex)
        assertEquals(pathType.name(), remoteCustomData.get(RemoteStoreEnums.PathType.NAME));
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
            new ArrayList<>(Arrays.asList(indexName1, indexName2))
    }
                    .getTotalHits()
            .cluster()
        ensureGreen(restoredIndexName1version2);
    private void indexDocuments(Client client, String indexName, int numOfDocs) {
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
            .get();
        Path location2 = PathUtils.get(String.join("/", pathTokens));
import static org.hamcrest.Matchers.equalTo;
            .put(super.nodeSettings(nodeOrdinal))
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), false)
        ensureGreen(indexName1, indexName2);
                    totalDocs += numDocs;
            .setSourceRemoteStoreRepository(newSegmentRepo)
        Client client = client();
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;
            .setRenameReplacement(restoredIndexName1version2)
        String snapshotName2 = "test-restore-snapshot2";
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName1)).get());
import java.io.IOException;
        ensureGreen(restoredIndexName1);
            .prepareUpdateSettings()
                    IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
        String index,
            .setRenamePattern(indexName2)
        assertThat(snapshotInfo2.state(), equalTo(SnapshotState.SUCCESS));
    }
                .setWaitForCompletion(true)
                .setWaitForCompletion(true)
        ensureGreen(indexName1);
        ).build();
        logger.info("--> snapshot");
import java.util.Collection;
        String snapshotName1 = "test-restore-snapshot1";
import org.opensearch.transport.client.Client;
                    .storedFields()
        String snapshotName2 = "test-restore-snapshot2";
        assertThat(snapshotInfo1.successfulShards(), greaterThan(0));
        ensureGreen(indexName1);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
                .setIndices(index)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY;
        IndexService indexService = indicesService.indexService(index);
                .setIndexSettings(multipleRemoteStoreIndexSettings)
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName2)
                .setRenameReplacement(restoredIndex)
    void assertRemoteSegmentsAndTranslogUploaded(String idx) throws IOException {
            for (int i = 0; i < numberOfSnapshots; i++) {
        String snapshotName1 = "test-snapshot1";
        RepositoryMetadata rmd = res.repositories().get(0);
        // indexing some new docs and validating
            .setWaitForCompletion(false)
            .setWaitForCompletion(false)
        ensureGreen(indexName1);
        Settings settings = Settings.builder()
            SnapshotRestoreException.class,
            .put(remoteStoreClusterSettings(BASE_REMOTE_REPO, remoteRepoPath))
        ensureGreen(restoredIndexName1);
        assertDocsPresentInIndex(client(), restoredIndexName1, numDocsInIndex1);
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        RestoreSnapshotResponse restoreSnapshotResponse1 = client().admin()
        assertTrue(recoveryState.getIndex().totalFileCount() > 0);
        SnapshotInfo snapshotInfo2 = createSnapshot(
        ensureGreen(indexName1);
        indexDocuments(client, index, numDocsInIndex, numDocsInIndex + randomIntBetween(2, 5));
            .put(SYSTEM_REPOSITORY_SETTING.getKey(), false);
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
                .get()
        client = client(clusterManagerNode);
                .cluster()
                createSnapshot(snapshotRepo, snapshotName, new ArrayList<>());
        // Validating that custom data has not changed for indexes which were created before the cluster setting got updated
        internalCluster().startDataAndWarmNodes(2);
        for (String snapshot : snapshots.keySet()) {
            .setRenameReplacement(restoredIndexName1)
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), false).build() },
        // deleting data for restoredIndexName1 and restoring from remote store.
            });
        assertThat(recoveryState.getIndex().recoveredFilesPercent(), lessThanOrEqualTo(100.0f));
    }
        createRepository(snapshotRepoName, "fs", getRepositorySettings(location, basePath, true));
        assertEquals(restoreSnapshotResponse1.status(), RestStatus.ACCEPTED);
            .cluster()
        indexSettings = getIndexSettings(1, 0).build();
    public void setup() {
        assertFalse(recoveryState.getIndex().fileDetails().isEmpty());
        assertEquals(0, recoveryResponse.getFailedShards());
            .setSourceRemoteTranslogRepository(newTranslogRepo)
import java.util.concurrent.ExecutionException;
                .setRenamePattern(index)
                    .value();
        ensureYellowAndNoInitializingShards(indexName1);
        logger.info("--> snapshot");
            int numberOfSnapshots = 2;
        internalCluster().startDataAndWarmNodes(1);
        RestoreSnapshotResponse restoreSnapshotResponse2 = client.admin()
            long finalTotalDocs = totalDocs;
                .cluster()
        Settings indexSettings = getIndexSettings(1, 0).put(
            assertEquals(RestStatus.OK, restoreSnapshotResponse1.status());
        createIndex(indexName1, indexSettings);
                .setRenamePattern(index)
        Settings indexSettings = getIndexSettings(1, 0).put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        String indexName1 = "testindex1";
        assertDocsPresentInIndex(client, indexName1, numDocsInIndex1 + 2);
        GetRepositoriesResponse res = client().admin().cluster().getRepositories(gr).get();
        // try index restore with index.remote_store.segment.repository and index.remote_store.translog.repository ignored
            .build();
    public void testHashedPrefixTranslogMetadataCombination() throws Exception {
        client().admin().indices().close(Requests.closeIndexRequest(indexName1)).get();
        ensureGreen(indexName1);
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        long totalDocs = 0;
        String restoredIndexName1 = indexName1 + "-restored";
        createRepository(remoteStoreRepoNameUpdated, "fs", remoteRepoPath);
        assertNotNull(remoteCustomData);
import org.opensearch.test.InternalTestCluster;
        Map<String, Long> snapshots = new HashMap<>();
        assertThat(snapshotInfo2.state(), equalTo(SnapshotState.SUCCESS));
            () -> client().admin()
        assertThat(snapshotInfo1.state(), equalTo(SnapshotState.SUCCESS));
        RemoteStoreEnums.PathType pathType,
                        Settings.builder()
        assertNotNull(indexService);
                .setIndices(index)
            .setIndices(indexName1)
                }
        ensureGreen(indexName1);
        indexDocuments(client, indexName1, numDocsInIndex1);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        Settings indexSettings = getIndexSettings(1, 0).build();
        validatePathType(indexName2, RemoteStoreEnums.PathType.HASHED_PREFIX, RemoteStoreEnums.PathHashAlgorithm.FNV_1A_COMPOSITE_1);
            ensureGreen(TimeValue.timeValueSeconds(60), index);
        totalDocs += numDocs;
        updateRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, false));
        assertDocsPresentInIndex(client(), indexName1, 2 * numDocsInIndex1);
            .setWaitForCompletion(false)
        RecoveryState recoveryState = recoveryResponse.shardRecoveryStates().get(restoredIndexName1).get(0);
            .cluster()
                .setRenamePattern(index)
        logger.info("--> snapshot");
        exception = expectThrows(
        Settings remoteStoreTranslogIndexSettings = Settings.builder()
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(randomIntBetween(1, 5)));
            if (randomBoolean()) {
        // ensure recovery details are non-zero
    }
        assertTrue(recoveryResponse.shardRecoveryStates().containsKey(restoredIndexName1));
        logger.info("Snapshots Status: " + snapshots);
import java.util.concurrent.TimeUnit;
                .setIndices()
            IOUtils.deleteFilesIgnoringExceptions(files.collect(Collectors.toList()));
        Map<String, String> remoteCustomData = state.metadata().index(index).getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY);
                .cluster()
import org.opensearch.snapshots.SnapshotInfo;
            .setRenamePattern(indexName1)
            SnapshotRestoreException.class,
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName1)).get());
            .cluster()
        Path segmentMetadataPath = Path.of(remoteRepoPath + "/" + path);
            } else {
            .get();
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
                internalCluster().client()
        ensureGreen(indexName2);
            .get();
        path = getShardLevelBlobPath(client, idx, new BlobPath(), "0", SEGMENTS, METADATA, segmentsPathFixedPrefix).buildAsString();
            assertTrue("doc with id" + id + " is not present for index " + indexName, client.prepareGet(indexName, id).get().isExists());
        logger.info("Path 2 [{}]", absolutePath2);
        assertTrue(recoveryState.getPrimary());
                assertAcked(client().admin().indices().delete(new DeleteIndexRequest(index)).get());
        }
                .setIgnoreIndexSettings(SETTING_REMOTE_STORE_ENABLED)
                .cluster()
        Path absolutePath2 = randomRepoPath().toAbsolutePath();
        Client client = client();
}
        createRepository(snapshotRepo, "fs", getRepositorySettings(absolutePath1, true));
        assertEquals(1, recoveryResponse.shardRecoveryStates().get(restoredIndexName1).size());
            () -> client().admin()
        final int numDocsInIndex1 = randomIntBetween(20, 30);
        return settingsBuilder;
            IndexSettings.DEFAULT_REFRESH_INTERVAL
        assertTrue(exception.getMessage().contains("cannot remove setting [index.remote_store.segment.repository] on restore"));
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.METADATA;
    }
import java.util.HashMap;
        path = getShardLevelBlobPath(client, idx, new BlobPath(), "0", TRANSLOG, DATA, translogPathFixedPrefix).buildAsString();
    public void testRestoreInSameRemoteStoreEnabledIndex() throws IOException {
import org.opensearch.index.shard.IndexShard;
    private void validatePathType(String index, RemoteStoreEnums.PathType pathType) {
                .setWaitForCompletion(false)
    }
        assertEquals(RestStatus.ACCEPTED, restoreSnapshotResponse.status());
        );
            .build();
        // Restore using new repos
        assertAcked(client.admin().indices().prepareClose(restoredIndexName1));
        assertThat(recoveryState.getIndex().recoveredBytesPercent(), greaterThanOrEqualTo(0.0f));
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
        final int numDocsInIndex = 5;
        assertEquals(1, recoveryResponse.getSuccessfulShards());
        }
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, newRemoteStoreRepo)
        assertTrue(recoveryState.getIndex().recoveredBytes() > 0L);
import java.util.Optional;
import org.opensearch.cluster.metadata.IndexMetadata;
            .get();
        ensureRed(indexName1);
        assertEquals(snapshotInfo.totalShards(), snapshotInfo.successfulShards());
        logger.info("Snapshot Path [{}]", absolutePath1);
        createRepository(remoteStoreRepoNameUpdated, "fs", remoteRepoPath);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        String snapshotRepoName = "test-snapshot-repo";
        Settings indexSettings = getIndexSettings(1, 0).build();
        ensureGreen(indexName2);
import org.opensearch.action.delete.DeleteResponse;
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1);
        logger.info("Snapshot Path [{}]", absolutePath1);
import org.junit.After;
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        Settings indexSettings2 = getIndexSettings(1, 0).build();
        createIndex(index, indexSettings);
            .build();
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.enabled]" + " on restore"));
            .prepareRestoreSnapshot(newSnapshotRepo, snapshotName1)
            .build();
        internalCluster().startDataAndWarmNodes(2);
                .setWaitForCompletion(false)
                    numDocs = randomIntBetween(200, 300);
import org.opensearch.test.BackgroundIndexer;
            Stream<Path> segmentMetadata = Files.list(segmentMetadataPath);
        String newSegmentRepo = "backup-segment";
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(indexName1).restoreAllShards(true), PlainActionFuture.newFuture());
            assertTrue(segmentData.count() > 0);
        assertEquals(restoreSnapshotResponse1.status(), RestStatus.ACCEPTED);
        client(clusterManagerNode).admin()
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    protected Settings.Builder getRepositorySettings(Path location, boolean shallowCopyEnabled) {
        ensureRed(indexName1);
        for (int i = 0; i < numOfDocs; i++) {
        Client client = client();
        String indexName2 = "testindex2";
    }
                    .setSize((int) finalTotalDocs)
    private void assertDocsPresentInIndex(Client client, String indexName, int numOfDocs) {
import java.nio.file.Files;
                .setRenameReplacement(restoredIndex)
        boolean enableShallowCopy = randomBoolean();
                String snapshotName = baseSnapshotName + i;
            RestoreSnapshotResponse restoreSnapshotResponse1 = client.admin()
        DeleteResponse deleteResponse = client().prepareDelete(index, "0").execute().actionGet();
        ensureGreen(indexName1);
        String remoteStoreRepoNameUpdated = "test-rs-repo-updated" + TEST_REMOTE_STORE_REPO_SUFFIX;
            logger.info("checking for index " + indexName + " with docId" + id);
                .setWaitForCompletion(false)
        ensureGreen(indexName1);
        int numDocsInIndex1 = randomIntBetween(2, 5);
        );
        Client client = client();
                    .storedFields()
                .setIndices(index)
            assertAcked(client().admin().indices().delete(new DeleteIndexRequest(index)).get());
                .setWaitForCompletion(false)
        int numDocs = randomIntBetween(200, 300);
        String newRemoteStoreRepo = "test-new-rs-repo";
                )
                long finalTotalDocs1 = totalDocs;
        assertEquals(restoreSnapshotResponse1.status(), RestStatus.ACCEPTED);
        assertDocsPresentInIndex(client, restoredIndexName2, numDocsInIndex2);
        ensureYellowAndNoInitializingShards(restoredIndexName1);
                Long hits = client().prepareSearch(index)
        assertThat(snapshotInfo1.state(), equalTo(SnapshotState.SUCCESS));
import org.opensearch.common.util.io.IOUtils;
            RemoteStoreEnums.PathHashAlgorithm.FNV_1A_COMPOSITE_1
        exception = expectThrows(
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(randomIntBetween(1, 5)));
                .get()
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
        // Delete index
import org.opensearch.indices.recovery.RecoveryState;
                .setWaitForCompletion(false)
        internalCluster().startClusterManagerOnlyNode();
        assertThat(snapshotInfo1.state(), equalTo(SnapshotState.SUCCESS));
        Path location = PathUtils.get(String.join("/", pathTokens));
            .setWaitForCompletion(false)
        IndexShard indexShard = getIndexShard(primaryNodeName(indexName1), indexName1);
    }
import org.opensearch.cluster.metadata.RepositoryMetadata;
import org.opensearch.core.common.unit.ByteSizeValue;
        // try index restore with index.remote_store.translog.repository and index.remote_store.segment.repository modified
                .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
            RemoteStorePinnedTimestampService.class,
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.TRANSLOG;
            settingsBuilder.put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        assertDocsPresentInIndex(client, indexName1, numDocsInIndex1 + 4);
        ensureGreen(index);
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_METADATA.getKey(), randomBoolean())
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.timeValueSeconds(randomIntBetween(1, 5)));
        int numDocs = randomIntBetween(200, 300);
        restoreSnapshotResponse = client.admin()
        DeleteResponse deleteResponse = client().prepareDelete(indexName1, "0").execute().actionGet();
    }
            .get();
        logger.info("--> snapshot");
    protected void indexDocuments(Client client, String indexName, int fromId, int toId) {
        SnapshotInfo snapshotInfo1 = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(List.of(indexName1)));
            .setRenameReplacement(restoredIndexName1)
                .cluster()
        ensureGreen(index);
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
        assertDocsPresentInIndex(client, restoredIndexName2, numDocsInIndex2);
        // Create index
        // Update cluster settings to FIXED
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), IndexSettings.DEFAULT_REFRESH_INTERVAL)
        Settings remoteStoreIndexSettings = Settings.builder().put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false).build();
        createIndex(indexName2, indexSettings);
 * this file be licensed under the Apache-2.0 license or a
    private Path remoteRepoPath;
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.translog.repository]" + " on restore"));
        String snapshotRepoName = "test-restore-snapshot-repo";
        Settings indexSettings = getIndexSettings(1, 0).build();
            () -> client().admin()
        assertEquals(restoreSnapshotResponse1.status(), RestStatus.ACCEPTED);
import org.opensearch.snapshots.SnapshotState;
            () -> client().admin()
        createIndex(indexName1, indexSettings);
        indexDocuments(client, index, numDocsInIndex);
        String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(getNodeSettings());
        DeleteResponse deleteResponse = client().prepareDelete(indexName1, "0").execute().actionGet();
            SnapshotRestoreException.class,
                .setIndices(index)
                    numDocs = randomIntBetween(200, 300);
                    .setSize((int) finalTotalDocs)
            Stream<Path> segmentData = Files.list(segmentDataPath);
            ensureGreen(TimeValue.timeValueSeconds(60), index);
        createRepository(snapshotRepo, "fs", getRepositorySettings(absolutePath1, true));
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName1)).get());
            primaryNodeName(index)
                    .setQuery(matchAllQuery())
        Arrays.copyOf(pathTokens, pathTokens.length - 1);
        createIndex(indexName1, indexSettings);
        assertFalse(indexExists(indexName1));
            .cluster()
                .setRenamePattern(index)
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
import org.opensearch.index.IndexModule;
        String indexName1 = "testindex1";
        String restoredIndexName1version1 = indexName1 + "-restored-1";
        settingsBuilder.put("location", location);
            assertTrue(translogData.count() > 0);
                .setIgnoreIndexSettings(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY)
        SnapshotInfo snapshotInfo1 = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(List.of(indexName1)));
                    totalDocs += numDocs;
        try (Stream<Path> files = Files.list(indexShard.shardPath().resolveTranslog())) {
        String primary = internalCluster().startDataAndWarmNodes(1).get(0);
        String basePath2 = pathTokens[pathTokens.length - 1];
        indexDocuments(client, indexName1, 0, numDocsInIndex1);
                assertEquals(snapshots.get(snapshot), hits);
                assertAcked(client().admin().indices().prepareClose(index));
        client().admin().indices().close(Requests.closeIndexRequest(indexName1)).get();
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;
        assertRemoteSegmentsAndTranslogUploaded(indexName1);
        }
        String indexName1 = "testindex1";
        String indexName2 = "testindex2";
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        Path location2 = PathUtils.get(String.join("/", pathTokens));
        assertThat(snapshotInfo1.successfulShards(), equalTo(snapshotInfo1.totalShards()));
        Path remoteTranslogMetadataPath = Path.of(remoteRepoPath + "/" + path);
            () -> client().admin()
            logger.info("Restoring snapshot: {}", snapshot);
        String snapshotRepo = "test-restore-snapshot-repo";
        String baseSnapshotName = "snapshot_";
        Path absolutePath2 = randomRepoPath().toAbsolutePath();
        String restoredIndexName2 = indexName2 + "-restored";
            .restoreRemoteStore(
        path = getShardLevelBlobPath(client, idx, new BlobPath(), "0", SEGMENTS, DATA, segmentsPathFixedPrefix).buildAsString();
                assertEquals(snapshots.get(snapshot), hits);
        ensureGreen(indexName1, restoredIndexName2);
        return Arrays.asList(
        try (BackgroundIndexer indexer = new BackgroundIndexer(index, MapperService.SINGLE_MAPPING_NAME, client(), numDocs)) {
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
            }
            }
        assertAcked(client.admin().indices().prepareClose(indexName1));
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, newRemoteStoreRepo)
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.SEGMENTS;
        RestoreSnapshotResponse restoreSnapshotResponse2 = client.admin()
        String basePath = pathTokens[pathTokens.length - 1];
            .setWaitForCompletion(false)
        createIndex(index, indexSettings);
        String indexName2 = "testindex2";
                    indexer.continueIndexing(numDocs);
                .get()
import org.opensearch.repositories.blobstore.BlobStoreRepository;
            assertBusy(() -> {
        Settings multipleRemoteStoreIndexSettings = Settings.builder()
        ensureGreen(index);
package org.opensearch.remotestore;
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
            .setIndices(indexName2)
        );
        assertEquals(1, recoveryResponse.shardRecoveryStates().size());
        assertEquals(1, recoveryResponse.getTotalShards());
                PlainActionFuture.newFuture()
                assertBusy(() -> assertEquals(finalTotalDocs1, indexer.totalIndexedDocs()), 120, TimeUnit.SECONDS);
        // Clear the local data before stopping the node. This will make sure that remote translog is empty.
        String[] pathTokens = absolutePath1.toString().split("/");
        assertThat(snapshotInfo2.successfulShards(), equalTo(snapshotInfo2.totalShards()));
        // Re-initialize client to make sure we are not using client from stopped node.
        SnapshotInfo snapshotInfo2 = createSnapshot(snapshotRepo, snapshotName2, new ArrayList<>(List.of(index)));
        assertThat(snapshotInfo1.successfulShards(), greaterThan(0));
/*
            Stream<Path> translogData = Files.list(remoteTranslogDataPath);
            new ArrayList<>(Arrays.asList(indexName1, indexName2))
            primaryNodeName(index)
        indexDocuments(client, indexName1, randomIntBetween(5, 10));
        validatePathType(indexName2, RemoteStoreEnums.PathType.HASHED_PREFIX, RemoteStoreEnums.PathHashAlgorithm.FNV_1A_COMPOSITE_1);
                .setIndexSettings(remoteStoreTranslogIndexSettings)
        // Verify restored index's stats
        assertDocsPresentInIndex(client(), indexName1, numDocsInIndex1);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
                snapshots.put(snapshotName, totalDocs);
        assertDocsPresentInIndex(client, indexName1, 3 * numDocsInIndex1);
        ) {
                .cluster()
        indexDocuments(client, indexName1, numDocsInIndex1);
        // Create index with cluster setting cluster.remote_store.index.path.type as hashed_prefix.
        indexDocuments(client, restoredIndexName1, numDocsInIndex1, numDocsInIndex1 + 2);
        }
        assertDocsPresentInIndex(client(), indexName1, numDocsInIndex1);
        final Index index = resolveIndex(indexName);
            () -> client().admin()
        assertDocsPresentInIndex(client(), indexName1, numDocsInIndex1);
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
            SnapshotRestoreException.class,
        indexDocuments(client, indexName1, numDocsInIndex1);
import org.opensearch.transport.client.Requests;
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        String indexName1 = "testindex1";
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
            .setTransientSettings(Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), RemoteStoreEnums.PathType.FIXED))
    @After
            .prepareUpdateSettings()
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(Arrays.asList(indexName1)));
        createIndex(indexName1, indexSettings);
        super(nodeSettings);
    public RestoreShallowSnapshotV2IT(Settings nodeSettings) {
        assertEquals(RecoveryState.Stage.DONE, recoveryState.getStage());
                .setRenameReplacement(restoredIndex)
        String remoteStoreRepoNameUpdated = "test-rs-repo-updated" + TEST_REMOTE_STORE_REPO_SUFFIX;
        // deleting data for restoredIndexName1 and restoring from remote store.
            .get();
        // try index restore with index.remote_store.segment.repository modified
        // indexing some new docs and validating
import org.opensearch.index.mapper.MapperService;
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1);
import static org.hamcrest.Matchers.greaterThan;
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
    private static final String BASE_REMOTE_REPO = "test-rs-repo" + TEST_REMOTE_STORE_REPO_SUFFIX;
        // indexing some new docs and validating
        assertDocsPresentInIndex(client, indexName1, numDocsInIndex1);
        String snapshotRepoName = "test-restore-snapshot-repo";
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(restoreSnapshotResponse2.status(), RestStatus.ACCEPTED);
        // Validate that the remote_store custom data is present in index metadata for the created index.
        final int numDocsInIndex1 = 5;
        String baseSnapshotName = "snapshot_";
            .setTransientSettings(
 * compatible open source license.
        assertTrue(exception.getMessage().contains("cannot remove setting [index.remote_store.enabled] on restore"));
        // Re-initialize client to make sure we are not using client from stopped node.
        if (shallowCopyEnabled) {
        long totalDocs = 0;
            settingsBuilder.put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true);
        logger.info("Snapshot Path [{}]", absolutePath1);
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
        logger.info("Snapshot Path [{}]", absolutePath1);
import org.opensearch.indices.replication.common.ReplicationType;
        String snapshotRepoName = "test-restore-snapshot-repo";
            }
        exception = expectThrows(
    public void testContinuousIndexing() throws Exception {
                    IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY,
import org.opensearch.core.rest.RestStatus;
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
            .setWaitForCompletion(true)
            .setIndices(indexName1)
        );
                Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), RemoteStoreEnums.PathType.HASHED_PREFIX)
            .get();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));
        indexDocuments(client, indexName1, numDocsInIndex1, numDocsInIndex1 + randomIntBetween(2, 5));
            .cluster()
        indexDocuments(client, indexName1, numDocsInIndex1 + 2, numDocsInIndex1 + 4);
        totalDocs += numDocs;
            .setWaitForCompletion(true)
                logger.info("--> waiting for {} docs to be indexed ...", numDocs);
                .cluster()
        updateRepository(snapshotRepo, "fs", getRepositorySettings(absolutePath1, false));
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(indexName1)));
        disableRepoConsistencyCheck("Remote store repo");
            .setIndices(indexName1)
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
            .setSourceRemoteStoreRepository(remoteStoreRepoNameUpdated)
                .get()
        Path remoteTranslogDataPath = Path.of(remoteRepoPath + "/" + path);
        assertThat(snapshotInfo1.successfulShards(), equalTo(snapshotInfo1.totalShards()));
    }
        internalCluster().startDataAndWarmNodes(1);
                }
    ) {
    }
        createIndex(indexName1, indexSettings);
        Map<String, Long> snapshots = new HashMap<>();
            RemoteStorePinnedTimestampService.class,
        exception = expectThrows(
        ).build();
            .cluster()
        internalCluster().startClusterManagerOnlyNode();
            assertEquals(RestStatus.OK, restoreSnapshotResponse1.status());
        refresh(indexName1);
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
        Client client = client();
                .get()
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
            .get();
        internalCluster().startClusterManagerOnlyNode();
        assertFalse(indexExists(indexName1));
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, enableShallowCopy));
        int numDocsInIndex1 = randomIntBetween(2, 5);
        createRepository(newSnapshotRepo, "fs", getRepositorySettings(snapshotRepoName, true));
                .cluster()
        assertTrue(snapshotInfo.successfulShards() > 0);
        assertThat(snapshotInfo1.successfulShards(), equalTo(snapshotInfo1.totalShards()));
        logger.info("--> snapshot");
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        logger.info("--> snapshot");
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
            .cluster()
        RecoveryResponse recoveryResponse = client().admin().indices().prepareRecoveries(restoredIndexName1).execute().actionGet();
        refresh(indexName1);
        );
            .setRenamePattern(indexName1)
            .setRenameReplacement(restoredIndexName2)
        String snapshotRepo = "test-restore-snapshot-repo";
import org.opensearch.common.Nullable;
        exception = expectThrows(
                .setIndices(index)
        createIndex(indexName2, indexSettings2);
            assertTrue(translogMetadata.count() > 0);
        String primary = internalCluster().startDataAndWarmNodes(1).get(0);
        assertTrue(recoveryState.getIndex().totalRecoverBytes() > 0L);
            snapshotName2,
                .cluster()
        assertRemoteSegmentsAndTranslogUploaded(restoredIndexName2);
        createIndex(index, indexSettings);
    }
        String snapshotRepo = "test-restore-snapshot-repo";
                .get()
        ensureGreen(indexName1);
                    .get()
                .setIndexSettings(remoteStoreIndexSettings)
        remoteRepoPath = randomRepoPath().toAbsolutePath();
import static org.opensearch.repositories.blobstore.BlobStoreRepository.SYSTEM_REPOSITORY_SETTING;
        logger.info("Snapshot Path [{}]", absolutePath1);
        client(clusterManagerNode).admin()
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.DATA;
        if (Objects.nonNull(pathHashAlgorithm)) {
                .setRenamePattern(index)
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
        ensureGreen(indexName1);
        final Optional<Integer> shardId = indexService.shardIds().stream().findFirst();
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
        );
    public void testRestoreOperationsShallowCopyEnabled() throws Exception {
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        indexDocuments(client, restoredIndexName1, numDocsInIndex1, numDocsInIndex1 + 2);
                assertBusy(() -> assertEquals(finalTotalDocs1, indexer.totalIndexedDocs()), 120, TimeUnit.SECONDS);
            RestoreSnapshotResponse restoreSnapshotResponse1 = client.admin()
        String snapshotName1 = "test-restore-snapshot1";
import org.opensearch.action.support.PlainActionFuture;
        String translogPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings());
    }
        String snapshotName1 = "test-restore-snapshot1";
        // Close index 2
                .setIndices(index)
                .setRenamePattern(index)
        flushAndRefresh(indexName1);
            .get();
        assertTrue(snapshotInfo.successfulShards() > 0);
            // Verify restored index's stats
        // indexing some new docs and validating
                .prepareRestoreSnapshot(snapshotRepo, snapshot)
        ensureGreen(indexName1);
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
        ensureGreen(indexName1);
        String index = "test-index";
        client(clusterManagerNode).admin()
            .setIndices(indexName1)
        // Validating that custom data has not changed for testindex2 which was created before the cluster setting got updated
        RestoreSnapshotResponse restoreSnapshotResponse2 = client.admin()
            .setWaitForCompletion(false)
    }
        ensureGreen(restoredIndexName1, restoredIndexName2);
        createRepository(snapshotRepo, "fs", getRepositorySettings(absolutePath1, true));
        int extraNumDocsInIndex1 = randomIntBetween(20, 50);
        assertThat(snapshotInfo1.successfulShards(), greaterThan(0));
            .setSourceRemoteStoreRepository(remoteStoreRepoNameUpdated)
        String newSnapshotRepo = "backup-snapshot";
                    .getTotalHits()
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepo, snapshotName1, new ArrayList<>(List.of(index)));
        Settings remoteStoreSegmentIndexSettings = Settings.builder()
        indexDocuments(client, indexName1, numDocsInIndex1, numDocsInIndex1 + randomIntBetween(2, 5));
        for (String snapshot : snapshots.keySet()) {
                    .setTransientSettings(
        String snapshotName2 = "test-restore-snapshot2";
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        );
            .setRenamePattern(indexName2)
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>());
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
                    .actionGet()
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
        );
        SnapshotInfo snapshotInfo1 = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(Arrays.asList(indexName1)));
            .setIndexSettings(numberOfReplicasSettings)
        assertTrue(recoveryState.getIndex().totalRecoverFiles() > 0);
        final int numDocsInIndex1 = 5;
        restoreSnapshotResponse = client.admin()
        internalCluster().startDataAndWarmNodes(1);
        clusterAdmin().prepareCleanupRepository(BASE_REMOTE_REPO).get();
                .setIndices(index)
        internalCluster().startDataAndWarmNodes(1);
        Settings indexSettings = getIndexSettings(1, 0).build();
        assertEquals(deleteResponse.getResult(), DocWriteResponse.Result.DELETED);
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), true).build() }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfReplicas)
                .get()
            .setRenameReplacement(restoredIndexName1)
            .setRenameReplacement(restoredIndexName2)
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));
import org.opensearch.index.IndexService;
        // indexing some new docs and validating
                .setRenamePattern(index)
            .get();
        ensureGreen(indexName1);
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        String snapshotRepoName = "test-restore-snapshot-repo";
        assertThat(snapshotInfo2.successfulShards(), greaterThan(0));
        logger.info("Snapshot Path [{}]", absolutePath1);
        validatePathType(restoredIndexName1version1, RemoteStoreEnums.PathType.FIXED);
        String snapshotName1 = "test-restore-snapshot1";
            .cluster()
    protected Settings.Builder getRepositorySettings(String sourceRepository, boolean readOnly) throws ExecutionException,
    public void testRemoteRestoreIndexRestoredFromSnapshot() throws IOException, ExecutionException, InterruptedException {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numOfShards)
                var fileCache = node.fileCache();
        // Take V2 snapshot
            SnapshotRestoreException.class,
import org.opensearch.indices.RemoteStoreSettings;
            .cluster()
            .put(BlobStoreRepository.READONLY_SETTING.getKey(), readOnly)
        assertEquals(RecoverySource.Type.SNAPSHOT, recoveryState.getRecoverySource().getType());
        assertEquals(RestStatus.ACCEPTED, restoreSnapshotResponse.status());
                    .value();
        ensureGreen(restoredIndexName1version1);
            assertEquals(pathHashAlgorithm.name(), remoteCustomData.get(RemoteStoreEnums.PathHashAlgorithm.NAME));
        final int numDocsInIndex1 = 5;
        // indexing some new docs and validating
            snapshotName2,
            restoredIndexName1version2,
        String snapshotName1 = "test-restore-snapshot1";
        String snapshotName1 = "test-restore-snapshot1";
        String indexName1 = "testindex1";
        RestoreSnapshotResponse restoreSnapshotResponse2 = client.admin()
        // try index restore with index.remote_store.enabled ignored
        logger.info("Path 2 [{}]", absolutePath2);
            .cluster()
            snapshotName1,
        }
        assertTrue(exception.getMessage().contains("cannot remove setting [index.remote_store.segment.repository]" + " on restore"));
    }
    private void validatePathType(
            logger.info("Restoring snapshot: {}", snapshot);
        String snapshotRepoName = "test-restore-snapshot-repo";
        assertEquals(deleteResponse.getResult(), DocWriteResponse.Result.DELETED);
        return shardId.map(indexService::getShard).orElse(null);
            .get();
        // Create Snapshot of index 2
        assertEquals(snapshotInfo.totalShards(), snapshotInfo.successfulShards());
                    .execute()
            for (int i = 0; i < numberOfSnapshots; i++) {
    }
        validatePathType(indexName1, RemoteStoreEnums.PathType.FIXED);
            .get();
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
        indexDocuments(client, indexName, 0, numOfDocs);
import org.opensearch.cluster.routing.RecoverySource;
                logger.info("--> waiting for {} docs to be indexed ...", numDocs);
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.segment.repository]" + " on restore"));
        assertThat(snapshotInfo1.successfulShards(), equalTo(snapshotInfo1.totalShards()));
            .setWaitForCompletion(false)
            IndexSettings.DEFAULT_REFRESH_INTERVAL
        pathTokens = absolutePath2.toString().split("/");
        assertEquals(restoreSnapshotResponse2.status(), RestStatus.ACCEPTED);
                .setWaitForCompletion(false)
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName2)
import org.opensearch.common.io.PathUtils;
        Settings numberOfReplicasSettings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build();
            .prepareUpdateSettings()
                    .getHits()
        for (int i = fromId; i < toId; i++) {
        String indexName1 = "testindex1";
                .setRenameReplacement(restoredIndex)
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.timeValueSeconds(randomIntBetween(1, 5)));
                .setIndices()
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
        logger.info("Path 1 [{}]", absolutePath1);
        assertFalse(indexExists(indexName1));
        internalCluster().startDataAndWarmNodes(1);
            snapshotRepoName,
                .prepareRestoreSnapshot(snapshotRepo, snapshot)
        internalCluster().startDataAndWarmNodes(1);
        }
        logger.info("Snapshots Status: " + snapshots);
        RestoreSnapshotResponse restoreSnapshotResponse1 = client.admin()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
                fileCache.clear();
                .setIgnoreIndexSettings(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY)
                .setWaitForCompletion(false)
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
            .setRenameReplacement(restoredIndexName1version1)
        );
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, node);
        // try index restore with index.remote_store.enabled modified
        assertThat(snapshotInfo2.successfulShards(), equalTo(snapshotInfo2.totalShards()));
        SnapshotRestoreException exception = expectThrows(
        }
                .setIndices(index)
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, newRemoteStoreRepo)
        // Create repo
        String snapshotRepoName = "test-restore-snapshot-repo";
        assertTrue(restoreSnapshotResponse2.getRestoreInfo().failedShards() == 0);
        // Create new snapshot, segment and translog repositories
        Settings indexSettings2 = getIndexSettings(1, 0).build();
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
            IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(),
        Path location = PathUtils.get(String.join("/", pathTokens));
        snapshotInfo = createSnapshot(snapshotRepoName, snapshotName2, new ArrayList<>(List.of(indexName2)));
        indexDocuments(client, indexName1, numDocsInIndex1, 2 * numDocsInIndex1);
        assertAcked(client().admin().indices().prepareClose(indexName1));
        flushAndRefresh(indexName1);
        exception = expectThrows(
                .setWaitForCompletion(false)
            snapshotRepoName,
    public void testRestoreShallowSnapshotIndexAfterSnapshot() throws ExecutionException, InterruptedException {
            .setWaitForCompletion(false)
        ensureGreen(index);
        Settings indexSettings = getIndexSettings(1, 0).put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
import org.opensearch.common.settings.Settings;
        String restoredIndexName2 = indexName2 + "-restored";
        assertEquals(restoreSnapshotResponse1.status(), RestStatus.ACCEPTED);
            assertBusy(() -> {
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
            // Verify restored index's stats
                    .isAcknowledged()
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            String id = Integer.toString(i);
        SnapshotInfo snapshotInfo1 = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(Arrays.asList(indexName1)));
        }
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)
import java.util.Objects;
    @Override
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
            SnapshotRestoreException.class,
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);
            var nodes = internalCluster().getDataNodeInstances(Node.class);
        String restoredIndex = index + "-restored";
    public static Collection<Object[]> parameters() {
        );
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        internalCluster().startClusterManagerOnlyNode(settings);
        String newTranslogRepo = "backup-translog";
        // try index restore with index.remote_store.segment.repository ignored
        String snapshotName1 = "test-restore-snapshot1";
            for (var node : nodes) {
    public void testInvalidRestoreRequestScenarios() throws Exception {
                createSnapshot(snapshotRepo, snapshotName, new ArrayList<>());
        InterruptedException {
                logger.info("--> {} total docs indexed", totalDocs);
        @Nullable RemoteStoreEnums.PathHashAlgorithm pathHashAlgorithm
            .cluster()
    @ParametersFactory
            .setIndices(indexName1)
            client.prepareIndex(indexName).setId(id).setSource("text", "sometext").get();
        ensureRed(restoredIndexName1);
                    .cluster()
        // try index restore with index.remote_store.translog.repository modified
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>());
            long finalTotalDocs = totalDocs;
        internalCluster().startDataAndWarmNodes(1);
                if (i < numberOfSnapshots - 1) {
            new ArrayList<>(Arrays.asList(indexName1, indexName2))
 */
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
        logger.info("Snapshot Path [{}]", absolutePath1);
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
                    .setQuery(matchAllQuery())
import org.opensearch.snapshots.SnapshotRestoreException;
        ensureGreen(restoredIndexName1);
        // try index restore with index.remote_store.translog.repository ignored
            .setWaitForCompletion(false)
        return Settings.builder()
            .cluster()
                            .put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), randomFrom(RemoteStoreEnums.PathType.values()))
            SnapshotRestoreException.class,
            RemoteStoreEnums.PathType.HASHED_PREFIX,
        Client client = client();
import java.util.stream.Collectors;
        indexDocuments(client, indexName2, numDocsInIndex2);
        assertEquals(0, recoveryState.getShardId().getId());
        assertAcked(client().admin().indices().prepareClose(indexName2));
            .setIndices(indexName2)
                .cluster()
        indexDocuments(client(), indexName1, numDocsInIndex1);
        indexDocuments(client, indexName1, 2 * numDocsInIndex1, 3 * numDocsInIndex1);
        indexDocuments(client, indexName2, numDocsInIndex2);
        assertThat(snapshotInfo2.state(), equalTo(SnapshotState.SUCCESS));
        assertThat(snapshotInfo1.successfulShards(), greaterThan(0));
        if (WRITABLE_WARM_INDEX_SETTING.get(settings)) {
            .setRenamePattern(indexName1)
        SnapshotInfo snapshotInfo1 = createSnapshot(
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        ensureGreen(restoredIndexName1);
    public void testRestoreShallowSnapshotRepository() throws ExecutionException, InterruptedException {
    private Settings.Builder getIndexSettings(int numOfShards, int numOfReplicas) {
        client.admin()
            .setTransientSettings(Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), RemoteStoreEnums.PathType.FIXED))
            .setRenamePattern(indexName1)
        Client client = client();
                logger.info("--> {} total docs indexed", totalDocs);
    }
        assertTrue(restoreSnapshotResponse2.getRestoreInfo().failedShards() == 0);
        String restoredIndexName1 = indexName1 + "-restored";
                .get()
        return Settings.builder()
        assertThat(snapshotInfo1.state(), equalTo(SnapshotState.SUCCESS));
            String id = Integer.toString(i);
        assertTrue(exception.getMessage().contains("cannot remove setting [index.remote_store.translog.repository] on restore"));
        Client client = client();
    public void testRemoteStoreCustomDataOnIndexCreationAndRestore() {
        Arrays.copyOf(pathTokens, pathTokens.length - 1);
                    .prepareUpdateSettings()
                .get();
        // try index restore with index.number_of_replicas setting modified. index.number_of_replicas can be modified on restore
        RestoreSnapshotResponse restoreSnapshotResponse1 = client.admin()
        }
        String primary = internalCluster().startDataAndWarmNodes(1).get(0);
                Long hits = client().prepareSearch(index)
            });
import java.util.stream.Stream;
        final int numDocsInIndex1 = randomIntBetween(20, 30);
        logger.info("Snapshot Path [{}]", absolutePath1);
        RestoreSnapshotResponse restoreSnapshotResponse1 = client().admin()
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1 + 2);
