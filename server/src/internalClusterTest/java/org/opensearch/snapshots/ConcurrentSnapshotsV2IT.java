        String indexName1 = "testindex1";
        super(nodeSettings);
        Client client = client();
        createIndex(indexName1, indexSettings);
        logger.info("Snapshot Path [{}]", absolutePath1);
        ActionFuture<AcknowledgedResponse> startCloneSnapshot = startCloneSnapshot(repoName, "snapshot-v1-2", "snapshot-v1-2-clone");
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        blockClusterManagerOnWriteIndexFile(repoName);
        final ActionFuture<CreateSnapshotResponse> snapshotFuture2 = startFullSnapshot(repoName, "snapshot-success");
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
            threads.add(thread);
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);
            .setWaitForCompletion(true)
        final int numDocsInIndex1 = 10;
import java.nio.file.Path;
    public void testLongRunningSnapshotDontAllowConcurrentSnapshot() throws Exception {
            .build();
        final int numDocsInIndex1 = 10;
        String indexName1 = "testindex1";
        // Creating a v2 repo
        Settings indexSettings2 = getIndexSettings(15, 0).build();
        createRepository(repoName, "mock", settings);
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        final CreateSnapshotResponse csr = startFullSnapshot(repoName, sourceSnap).actionGet();
        String indexName1 = "testindex1";
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
            .setIndices(indexName1)
        Settings indexSettings2 = getIndexSettings(15, 0).build();
        ensureGreen(indexName1, indexName2);
        startFullSnapshot(repoName, "snapshot-v1").actionGet();
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        String indexName1 = "testindex1";
            .setRenamePattern("(.+)")
        assertTrue(startDeleteSnapshot.actionGet().isAcknowledged());
        createIndex(indexName2, indexSettings2);
        assertEquals(1, snapInfo.size());
        createIndex(indexName2, indexSettings2);
        ensureGreen();
        Settings.Builder settings = Settings.builder()
        CreateSnapshotResponse csr = snapshotFuture.actionGet();
        indexDocuments(client, indexName1, numDocsInIndex1);
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), false);
        ensureGreen(indexName1, indexName2);
        Settings indexSettings2 = getIndexSettings(15, 0).build();
import org.opensearch.repositories.Repository;
        final int numDocsInIndex1 = 10;
        String indexName1 = "testindex1";
        createIndex(indexName1, indexSettings);
        createRepository(repoName, "mock", settings);
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
import java.util.Arrays;
                .setWaitForCompletion(true)
        unblockNode(repoName, clusterManagerNode);
        return clusterAdmin().prepareCloneSnapshot(repoName, sourceSnapshotName, snapshotName).setIndices("*").execute();
        final int numDocsInIndex2 = 20;
            .setWaitForCompletion(true)
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
    }
        indexDocuments(client, indexName1, numDocsInIndex1);
        assertEquals(2, snapInfo.size());
        // Second create works out cleanly since the repo
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);
        Client client = client();
        for (Thread thread : threads) {
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            .prepareCreateSnapshot(repoName, snapshotName)
        Settings.Builder settings = Settings.builder()
        logger.info("Snapshot Path [{}]", absolutePath1);
        String clusterManagerNode = internalCluster().getClusterManagerName();
        logger.info("Snapshot Path [{}]", absolutePath1);
        ensureGreen(indexName1, indexName2);
    protected Settings nodeSettings(int nodeOrdinal) {
                        .setWaitForCompletion(true)
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        String repoName = "test-create-snapshot-repo";
        assertEquals(3, snapInfo.size());
        String snapshotName = "snapshot-success";
        String indexName2 = "testindex2";
                    SnapshotInfo snapshotInfo = createSnapshotResponse2.getSnapshotInfo();
        createRepository(repoName, "mock", settings);
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
        createIndex(indexName2, indexSettings2);
        indexDocuments(client, indexName2, numDocsInIndex2);
        assertTrue(startCloneSnapshot.actionGet().isAcknowledged());
        RepositoryData repositoryData = repositoryDataPlainActionFuture.get();
        Settings indexSettings = getIndexSettings(20, 0).build();
                        .cluster()
        ActionFuture<AcknowledgedResponse> startCloneSnapshot = startCloneSnapshot(repoName, "snapshot-v1-2", "snapshot-v1-2-clone");
        String repoName = "test-create-snapshot-repo";
/*
        Settings indexSettings = getIndexSettings(20, 0).build();
import org.opensearch.action.support.PlainActionFuture;
    public static Collection<Object[]> parameters() {
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        awaitNumberOfSnapshotsInProgress(1);
    }
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();
        final int numDocsInIndex1 = 10;
        assertThat(snapInfo, containsInAnyOrder(csr.getSnapshotInfo(), csr2.getSnapshotInfo()));
        String repoName = "test-create-snapshot-repo";
        Settings indexSettings2 = getIndexSettings(15, 0).build();
        ensureGreen();
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
        unblockNode(repoName, clusterManagerName);
        Settings indexSettings2 = getIndexSettings(15, 0).build();
        indexDocuments(client, indexName1, numDocsInIndex1);
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        indexDocuments(client, indexName1, numDocsInIndex1);
        String sourceSnap = "snapshot-source";
        // Creating a v2 repo
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
import org.opensearch.common.action.ActionFuture;
        Settings indexSettings = getIndexSettings(20, 0).build();
        String indexName1 = "testindex1";
            int snapshotIndex = i;
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
    }
        Settings indexSettings = getIndexSettings(20, 0).build();
        createRepository(repoName, "mock", settings);
        // fail segment repo - this is to fail the timestamp pinning
        ensureGreen(indexName1, indexName2);
    public void testCloneV1WhileV2CreateOngoing() throws Exception {
        indexDocuments(client, indexName1, numDocsInIndex1);
        ensureGreen(indexName1, indexName2);
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
    }
        setFailRate(BASE_REMOTE_REPO, 0);
        assertThat(snapInfo, contains(csr.getSnapshotInfo()));
        startFullSnapshot(repoName, "snapshot-v1-2").actionGet();
        }
        try {
        CreateSnapshotResponse csr = snapshotFuture2.actionGet();
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, "snapshot-queued");
            .cluster()
import org.opensearch.core.common.unit.ByteSizeUnit;
        createRepository(repoName, "mock", settings);
        ensureGreen(indexName1, indexName2);
        indexDocuments(client, indexName2, numDocsInIndex2);
                    assertThat(snapshotInfo.successfulShards(), greaterThan(0));
        unblockNode(repoName, clusterManagerName);
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();
        CreateSnapshotResponse csr = startFullSnapshot(repoName, sourceSnap).actionGet();
        Settings indexSettings = getIndexSettings(20, 0).build();
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
    }
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            .setRenamePattern(indexName1)
        String indexName1 = "testindex1";
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, "snapshot-queued");
        assertThat(snapInfo, contains(csr.getSnapshotInfo()));
        awaitNumberOfSnapshotsInProgress(1);
        final int numDocsInIndex2 = 20;
        ensureGreen();
            String snapshotName = "snapshot-concurrent";
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), false);
        Client client = client();
        Settings indexSettings = getIndexSettings(10, 0).build();
        ensureGreen(indexName1, indexName2);
        final ActionFuture<AcknowledgedResponse> snapshotFuture = startCloneSnapshot(repoName, sourceSnap, "snapshot-clone");
        logger.info("Snapshot Path [{}]", absolutePath1);
    }
        createRepository(repoName, "mock", settings);
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, "snapshot-v2");
        // Fail the cluster manager
        Client client = client();
        Settings.Builder settings = Settings.builder()
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), false).build() },
 * compatible open source license.
        ActionFuture<AcknowledgedResponse> startCloneSnapshot = startCloneSnapshot(repoName, "snapshot-v1", "snapshot-v1-2-clone");
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        createRepository(repoName, "mock", settings);
        final int numDocsInIndex2 = 20;
        assertTrue(startCloneSnapshot.actionGet().isAcknowledged());
        unblockNode(repoName, clusterManagerName);
        Client client = client();
        CreateSnapshotResponse sourceResp = startFullSnapshot(repoName, sourceSnap).actionGet();
        final int numDocsInIndex1 = 10;
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        final int numDocsInIndex1 = 10;
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
        String clusterManagerNode = internalCluster().getClusterManagerName();
        Settings.Builder settings = Settings.builder()
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);
        createIndex(indexName2, indexSettings2);
        for (int i = 0; i < concurrentSnapshots; i++) {
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        createRepository(repoName, "mock", settings);
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        indexDocuments(client, indexName1, numDocsInIndex1);
        stopNode(clusterManagerNode);
        return Arrays.asList(
        indexDocuments(client, indexName1, numDocsInIndex1);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        createIndex(indexName2, indexSettings2);
        String indexName2 = "testindex2";
            .get();
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        final int numDocsInIndex2 = 20;
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        // Creating a v2 repo
import static org.hamcrest.Matchers.greaterThan;
        assertThat(snapInfo, contains(csr.getSnapshotInfo()));
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        final int numDocsInIndex1 = 10;
        ensureGreen(indexName1, indexName2);
        String repoName = "test-create-snapshot-repo";
        }
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
import org.opensearch.repositories.RepositoryData;
import org.opensearch.core.common.unit.ByteSizeValue;
import java.util.ArrayList;
import java.util.Collection;
        indexDocuments(client, indexName1, numDocsInIndex1);
        stopNode(clusterManagerNode);
        assertEquals(1, snapInfo.size());
        try {
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
        ActionFuture<AcknowledgedResponse> startDeleteSnapshot = startDeleteSnapshot(repoName, "snapshot-v1");
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        // Second create works out cleanly since the repo
        // Fail the cluster manager
import org.opensearch.repositories.RepositoriesService;
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
                    String snapshotName = "snapshot-concurrent-" + snapshotIndex;
        String indexName2 = "testindex2";
        String indexName2 = "testindex2";
        Settings indexSettings2 = getIndexSettings(15, 0).build();
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();
        createIndex(indexName1, indexSettings);
        createIndex(indexName1, indexSettings);
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
        PlainActionFuture<RepositoryData> repositoryDataPlainActionFuture = new PlainActionFuture<>();
            thread.join();
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
    }
    public ConcurrentSnapshotsV2IT(Settings nodeSettings) {
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        ensureGreen();
        logger.info("Snapshot Path [{}]", absolutePath1);
        indexDocuments(client, indexName2, numDocsInIndex2);
        String indexName2 = "testindex2";
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
        expectThrows(ConcurrentSnapshotExecutionException.class, a::actionGet);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
import org.opensearch.node.Node;
            .prepareRestoreSnapshot(repoName, "snapshot-v1-2-clone")
        assertThat(repositoryData.getSnapshotIds().size(), greaterThanOrEqualTo(1));
            fail();
        createIndex(indexName1, indexSettings);
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();
        final int numDocsInIndex2 = 20;
        Client client = client();
                .get();
            .setRenameReplacement("$1-copy")
        assertThrows(SnapshotException.class, snapshotFuture::actionGet);
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        assertEquals(1, snapInfo.size());
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
        indexDocuments(client, indexName2, numDocsInIndex2);
        logger.info("--> creating full snapshot [{}] to repo [{}]", snapshotName, repoName);
    }
        indexDocuments(client, indexName2, numDocsInIndex2);
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;
                    assertThat(snapshotInfo.getPinnedTimestamp(), greaterThan(0L));
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
        createIndex(indexName2, indexSettings2);
            .cluster()
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
        createRepository(repoName, "mock", settings);
        indexDocuments(client, indexName2, numDocsInIndex2);
        awaitNumberOfSnapshotsInProgress(1);
import org.opensearch.test.OpenSearchIntegTestCase;
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        Settings.Builder settings = Settings.builder()
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/16205")
        final int numDocsInIndex1 = 10;
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, "snapshot-queued");
        // Validate that only one snapshot has been created
        settings = Settings.builder()
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
    @ParametersFactory
        logger.info("Snapshot Path [{}]", absolutePath1);
        Client client = client();
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
        final int numDocsInIndex2 = 20;
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        setFailRate(BASE_REMOTE_REPO, 100);
        Settings indexSettings2 = getIndexSettings(15, 0).build();
        Settings.Builder settings = Settings.builder()
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
    }
    }
        blockClusterManagerOnWriteIndexFile(repoName);
        indexDocuments(client, indexName2, numDocsInIndex2);
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();
        String indexName2 = "testindex2";
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        createIndex(indexName1, indexSettings);
                    assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        final int numDocsInIndex2 = 20;
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), true).build() }
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        createIndex(indexName1, indexSettings);
            .setWaitForCompletion(true)
        indexDocuments(client, indexName2, numDocsInIndex2);
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        assertEquals(2, snapInfo.size());
        String sourceSnap = "snapshot-source";
                .prepareCreateSnapshot(repoName, snapshotName)
        blockClusterManagerOnWriteIndexFile(repoName);
        // start all threads
        List<Thread> threads = new ArrayList<>();
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, "snapshot-v2");
    public void testDeleteAndCloneV1WhileCreateOngoing() throws Exception {
    public void testCloneSnapshotFailInFinalize() throws Exception {
        String repoName = "test-create-snapshot-repo";
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        assertEquals(3, snapInfo.size());
        String indexName2 = "testindex2";
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        final int numDocsInIndex1 = 10;
        indexDocuments(client, indexName2, numDocsInIndex2);
        awaitNumberOfSnapshotsInProgress(1);
        unblockNode(repoName, clusterManagerName);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        ActionFuture<AcknowledgedResponse> startDeleteSnapshot = startDeleteSnapshot(repoName, "snapshot-v1");
        Client client = client();
        Settings.Builder settings = Settings.builder()
        assertThrows(ConcurrentSnapshotExecutionException.class, snapshotFuture2::actionGet);
        startFullSnapshot(repoName, "snapshot-v1").actionGet();
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
        Settings indexSettings = getIndexSettings(20, 0).build();
            .get();
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        startFullSnapshot(repoName, "snapshot-v1").actionGet();
            .cluster()
        final int numDocsInIndex2 = 20;
        Client client = client();
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();
        indexDocuments(client, indexName1, numDocsInIndex1);
        Client client = client();
 * this file be licensed under the Apache-2.0 license or a
            .setWaitForCompletion(true)
        String indexName2 = "testindex2";
        CreateSnapshotResponse createSnapshotResponse = client().admin()
        }
        indexDocuments(client, indexName2, numDocsInIndex2);
        final ActionFuture<CreateSnapshotResponse> snapshotFuture2 = startFullSnapshot(repoName, "snapshot-success");
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        Repository repository = internalCluster().getInstance(RepositoriesService.class).repository(snapshotRepoName);
        String sourceSnap = "snapshot-source";
        Settings indexSettings = getIndexSettings(20, 0).build();
        createIndex(indexName2, indexSettings2);
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();
        settings = Settings.builder()
            thread.start();
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        awaitNumberOfSnapshotsInProgress(1);
 *
        Settings.Builder settings = Settings.builder()
        Client client = client();
        createIndex(indexName1, indexSettings);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        assertTrue(csr.getSnapshotInfo().getPinnedTimestamp() != 0);
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
            .setRenamePattern("(.+)")
        ensureGreen(indexName1, indexName2);
        indexDocuments(client, indexName1, numDocsInIndex1);
            String snapshotName = "snapshot-fail";
        return Settings.builder()
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), false);
        assertTrue(startDeleteSnapshot.actionGet().isAcknowledged());
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        Settings indexSettings = getIndexSettings(20, 0).build();
    @Override
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        indexDocuments(client, indexName1, numDocsInIndex1);
        String indexName1 = "testindex1";
        // Wait for all threads to complete
        for (Thread thread : threads) {
        String snapshotRepoName = "test-create-snapshot-repo";
        String indexName1 = "testindex1";
        final int numDocsInIndex2 = 20;
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        CreateSnapshotResponse csr = snapshotFuture.actionGet();
        awaitNumberOfSnapshotsInProgress(1);
        CreateSnapshotResponse csr2 = snapshotFuture2.actionGet();
        indexDocuments(client, indexName2, numDocsInIndex2);
        assertEquals(3, snapInfo.size());
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        settings = Settings.builder()
            Thread thread = new Thread(() -> {
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
}
package org.opensearch.snapshots;
        createRepository(repoName, "mock", settings);
        createIndex(indexName1, indexSettings);
        createIndex(indexName1, indexSettings);
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        createIndex(indexName2, indexSettings2);
            .get();
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        expectThrows(SnapshotException.class, snapshotFuture::actionGet);
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/16205")
import static org.hamcrest.Matchers.contains;
        createRepository(repoName, "mock", settings);
            .get();
import java.util.concurrent.ExecutionException;
        logger.info("Snapshot Path [{}]", absolutePath1);
        String indexName1 = "testindex1";
            .prepareRestoreSnapshot(repoName, "snapshot-v1-2-clone")
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), false);
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
    protected ActionFuture<AcknowledgedResponse> startCloneSnapshot(String repoName, String sourceSnapshotName, String snapshotName) {
        String indexName1 = "testindex1";
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        int concurrentSnapshots = 5;
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
    }
        indexDocuments(client, indexName1, numDocsInIndex1);
            .setRenamePattern("(.+)")
 * SPDX-License-Identifier: Apache-2.0
        final int numDocsInIndex2 = 20;
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        CreateSnapshotResponse csr = snapshotFuture2.actionGet();
        Settings.Builder settings = Settings.builder()
        snapshotFuture.actionGet();
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        ActionFuture<AcknowledgedResponse> a = startDeleteSnapshot(repoName, "snapshot-v1");
        blockClusterManagerOnWriteIndexFile(repoName);
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        String repoName = "test-create-snapshot-repo";
                    CreateSnapshotResponse createSnapshotResponse2 = client().admin()
import static org.hamcrest.Matchers.equalTo;
        Settings indexSettings2 = getIndexSettings(15, 0).build();
                .cluster()
        indexDocuments(client, indexName2, numDocsInIndex2);
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        logger.info("Snapshot Path [{}]", absolutePath1);
        String indexName2 = "testindex2";
    public void testDeleteAndCloneV1WhileV2CreateOngoing() throws Exception {
            .put(super.nodeSettings(nodeOrdinal))
        Client client = client();
        assertEquals(restoreSnapshotResponse.status(), RestStatus.OK);
        createRepository(repoName, "mock", settings);
        final ActionFuture<AcknowledgedResponse> snapshotFuture2 = startCloneSnapshot(repoName, sourceSnap, "snapshot-clone-2");
        createRepository(repoName, "mock", settings);
        Settings indexSettings2 = getIndexSettings(15, 0).build();
    public void testCreateSnapshotFailInFinalize() throws Exception {
        final int numDocsInIndex2 = 20;
        assertEquals(restoreSnapshotResponse.status(), RestStatus.OK);
import org.opensearch.core.rest.RestStatus;
        snapshotFuture.get();
import org.opensearch.common.unit.TimeValue;
        Settings indexSettings = getIndexSettings(20, 0).build();
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        final ActionFuture<CreateSnapshotResponse> snapshotFuture2 = startFullSnapshot(repoName, "snapshot-success");
        unblockNode(repoName, clusterManagerNode);
        String repoName = "test-create-snapshot-repo";
    }
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
        final int numDocsInIndex2 = 20;
        String repoName = "test-create-snapshot-repo";
        ensureGreen(indexName1, indexName2);
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
                        .get();
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
            .setIndices(indexName1)
        // Second create works out cleanly since the repo is cleaned up
            client().admin().cluster().prepareCreateSnapshot(repoName, snapshotName).setWaitForCompletion(true).get();
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        );
        repository.getRepositoryData(repositoryDataPlainActionFuture);
 * The OpenSearch Contributors require contributions made to
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        Settings indexSettings = getIndexSettings(20, 0).build();
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        logger.info("Snapshot Path [{}]", absolutePath1);
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);
        // Second create works out cleanly since the repo
        final ActionFuture<AcknowledgedResponse> snapshotFuture = startCloneSnapshot(repoName, sourceSnap, "snapshot-queued");
        assertTrue(csr.getSnapshotInfo().getPinnedTimestamp() != 0);
        assertThat(snapInfo, containsInAnyOrder(csr.getSnapshotInfo(), sourceResp.getSnapshotInfo()));
        unblockNode(repoName, clusterManagerName);
        Settings indexSettings2 = getIndexSettings(15, 0).build();
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
import java.util.List;
        logger.info("Snapshot Path [{}]", absolutePath1);
        logger.info("Snapshot Path [{}]", absolutePath1);
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);
                    assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
    public void testConcurrentSnapshotV2CreateOperation() throws InterruptedException, ExecutionException {
        // Prepare threads for concurrent snapshot creation
        ensureGreen(indexName1, indexName2);
        assertTrue(csr.getSnapshotInfo().getPinnedTimestamp() != 0);
        Settings.Builder settings = Settings.builder()
        String indexName2 = "testindex2";
        } catch (Exception e) {}
 */
        CreateSnapshotResponse csr = snapshotFuture.actionGet();
        blockClusterManagerOnWriteIndexFile(repoName);
    }
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        createIndex(indexName2, indexSettings2);
import org.opensearch.common.settings.Settings;
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        awaitNumberOfSnapshotsInProgress(1);
        ensureGreen(indexName1, indexName2);
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
                } catch (Exception e) {}
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
import static org.hamcrest.Matchers.containsInAnyOrder;
    }
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();
        Settings indexSettings2 = getIndexSettings(15, 0).build();
        final int numDocsInIndex1 = 10;
    }
            .cluster()
    public void testCloneSnapshotV2MasterSwitch() throws Exception {
        assertEquals(2, snapInfo.size());
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        CreateSnapshotResponse csr = snapshotFuture.actionGet();
        final int numDocsInIndex1 = 10;
        final ActionFuture<AcknowledgedResponse> snapshotFuture = startCloneSnapshot(repoName, sourceSnap, "snapshot-queued");
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
        ensureGreen();
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        createRepository(repoName, "mock", settings);
            .setIndices(indexName1)
            });
            .setRenameReplacement("$1-copy")
    }
    public void testDeleteWhileV2CreateOngoing() throws Exception {
        createIndex(indexName2, indexSettings2);
        CreateSnapshotResponse csr = snapshotFuture2.actionGet();
        Settings indexSettings2 = getIndexSettings(15, 0).build();
        createIndex(indexName1, indexSettings);
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        Settings.Builder settings = Settings.builder()
            CreateSnapshotResponse createSnapshotResponse = client().admin()
        final int numDocsInIndex1 = 10;
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        String repoName = "test-create-snapshot-repo";
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        assertThrows(SnapshotException.class, snapshotFuture2::actionGet);
        String indexName2 = "testindex2";
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, "snapshot-v2");
        String indexName2 = "testindex2";
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        blockClusterManagerOnWriteIndexFile(repoName);
        awaitNumberOfSnapshotsInProgress(1);
        awaitNumberOfSnapshotsInProgress(1);
import org.opensearch.remotestore.RemoteSnapshotIT;
        final ActionFuture<CreateSnapshotResponse> snapshotFuture2 = startFullSnapshot(repoName, "snapshot-success");
        createIndex(indexName1, indexSettings);
        } catch (Exception e) {}
        Settings indexSettings = getIndexSettings(20, 0).build();
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
            .setRenameReplacement("$1-copy")
import org.opensearch.transport.client.Client;
import org.opensearch.repositories.fs.FsRepository;
        String repoName = "test-create-snapshot-repo";
        createIndex(indexName2, indexSettings2);
        unblockNode(repoName, clusterManagerName);
        String repoName = "test-create-snapshot-repo";
    public void testCreateSnapshotV2MasterSwitch() throws Exception {
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        assertEquals(1, snapInfo.size());
        startFullSnapshot(repoName, "snapshot-v1-2").actionGet();
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, "snapshot-v2");
        assertEquals(2, snapInfo.size());
                    assertThat(snapshotInfo.snapshotId().getName(), equalTo(snapshotName));
    public void testLongRunningSnapshotDontAllowConcurrentClone() throws Exception {
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
                try {
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
            .prepareRestoreSnapshot(repoName, "snapshot-v1-2-clone")
        assertEquals(restoreSnapshotResponse.status(), RestStatus.OK);
        ensureGreen();
    public void testPinnedTimestampFailSnapshot() throws Exception {
        createIndex(indexName2, indexSettings2);
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        startFullSnapshot(repoName, "snapshot-v1").actionGet();
        String indexName1 = "testindex1";
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
            fail();
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        logger.info("Snapshot Path [{}]", absolutePath1);
                        .prepareCreateSnapshot(snapshotRepoName, snapshotName)
        Settings.Builder settings = Settings.builder()
public class ConcurrentSnapshotsV2IT extends RemoteSnapshotIT {
        awaitNumberOfSnapshotsInProgress(1);
        assertTrue(startCloneSnapshot.actionGet().isAcknowledged());
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
