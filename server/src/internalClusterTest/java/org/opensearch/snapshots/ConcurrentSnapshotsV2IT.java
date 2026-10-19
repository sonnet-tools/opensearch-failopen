        blockClusterManagerOnWriteIndexFile(repoName);  
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        Settings.Builder settings = Settings.builder()
        int concurrentSnapshots = 5;  
        logger.info("Snapshot Path [{}]", absolutePath1);  
        Settings.Builder settings = Settings.builder()  
                        .setWaitForCompletion(true)
        final int numDocsInIndex2 = 20;
        final int numDocsInIndex2 = 20;
        final int numDocsInIndex2 = 20;
        createRepository(repoName, "mock", settings);
        final ActionFuture<CreateSnapshotResponse> snapshotFuture2 = startFullSnapshot(repoName, "snapshot-success");
        repository.getRepositoryData(repositoryDataPlainActionFuture);
        assertEquals(1, snapInfo.size());
        final int numDocsInIndex2 = 20;
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        final int numDocsInIndex1 = 10;  
        blockClusterManagerOnWriteIndexFile(repoName);
        awaitNumberOfSnapshotsInProgress(1);
            .cluster()
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());  
import org.opensearch.repositories.RepositoriesService;
        String repoName = "test-create-snapshot-repo";
        ensureGreen();
        logger.info("Snapshot Path [{}]", absolutePath1);
        createIndex(indexName2, indexSettings2);
        assertTrue(startCloneSnapshot.actionGet().isAcknowledged());
        Settings indexSettings = getIndexSettings(20, 0).build();  
        // Validate that only one snapshot has been created
            .setWaitForCompletion(true)  
    }
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        return Settings.builder()
            .put(super.nodeSettings(nodeOrdinal))
            .setRenameReplacement("$1-copy")
        Client client = client();  
    public static Collection<Object[]> parameters() {  
        Client client = client();
    }
        assertEquals(restoreSnapshotResponse.status(), RestStatus.OK);
        Client client = client();
import java.util.Collection;
        createIndex(indexName1, indexSettings);  
        final int numDocsInIndex2 = 20;  
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();
        CreateSnapshotResponse createSnapshotResponse = client().admin()
        String clusterManagerNode = internalCluster().getClusterManagerName();
                    CreateSnapshotResponse createSnapshotResponse2 = client().admin()
import org.opensearch.core.common.unit.ByteSizeValue;  
        String indexName2 = "testindex2";  
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        ensureGreen();  
}
        indexDocuments(client, indexName2, numDocsInIndex2);
        ensureGreen(indexName1, indexName2);  
        final int numDocsInIndex1 = 10;
    protected ActionFuture<AcknowledgedResponse> startCloneSnapshot(String repoName, String sourceSnapshotName, String snapshotName) {
        Settings indexSettings2 = getIndexSettings(15, 0).build();  
        assertEquals(1, snapInfo.size());
import org.opensearch.test.OpenSearchIntegTestCase;
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
 *
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);  
        ensureGreen(indexName1, indexName2);
        final ActionFuture<AcknowledgedResponse> snapshotFuture = startCloneSnapshot(repoName, sourceSnap, "snapshot-clone");
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);  
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());  
    }  
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)  
                .get();
        awaitNumberOfSnapshotsInProgress(1);  
            .cluster()
        String repoName = "test-create-snapshot-repo";
                    assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)  
        blockClusterManagerOnWriteIndexFile(repoName);
        Settings indexSettings2 = getIndexSettings(15, 0).build();
        Settings indexSettings = getIndexSettings(20, 0).build();
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)  
        expectThrows(SnapshotException.class, snapshotFuture::actionGet);
        String indexName1 = "testindex1";
        indexDocuments(client, indexName1, numDocsInIndex1);
        ensureGreen(indexName1, indexName2);
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        settings = Settings.builder()
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        createIndex(indexName1, indexSettings);  
import org.opensearch.core.common.unit.ByteSizeUnit;
import java.util.concurrent.ExecutionException;  
        unblockNode(repoName, clusterManagerNode);
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
    }  
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);  
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, "snapshot-queued");
        String indexName1 = "testindex1";  
import org.opensearch.common.unit.TimeValue;
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        Path absolutePath1 = randomRepoPath().toAbsolutePath();  
        // Creating a v2 repo
        final int numDocsInIndex1 = 10;  
        startFullSnapshot(repoName, "snapshot-v1").actionGet();
        String indexName1 = "testindex1";  
        createRepository(repoName, "mock", settings);
        Settings indexSettings = getIndexSettings(20, 0).build();
import org.opensearch.repositories.fs.FsRepository;  
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));  
        String sourceSnap = "snapshot-source";
        }  
        final int numDocsInIndex1 = 10;
        String indexName1 = "testindex1";  
        Client client = client();
 * this file be licensed under the Apache-2.0 license or a
        logger.info("Snapshot Path [{}]", absolutePath1);
            String snapshotName = "snapshot-fail";
        String indexName1 = "testindex1";
        Path absolutePath1 = randomRepoPath().toAbsolutePath();  
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();  
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
        logger.info("Snapshot Path [{}]", absolutePath1);  
        createRepository(repoName, "mock", settings);
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)  
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        createIndex(indexName2, indexSettings2);  
        assertEquals(2, snapInfo.size());
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        List<Thread> threads = new ArrayList<>();  
    @Override
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());  
        Settings.Builder settings = Settings.builder()  
        blockClusterManagerOnWriteIndexFile(repoName);
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());  
        CreateSnapshotResponse csr = snapshotFuture.actionGet();
            String snapshotName = "snapshot-concurrent";
            .setRenamePattern("(.+)")  
        startFullSnapshot(repoName, "snapshot-v1").actionGet();
        assertEquals(3, snapInfo.size());
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
 * compatible open source license.
        expectThrows(ConcurrentSnapshotExecutionException.class, a::actionGet);
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        awaitNumberOfSnapshotsInProgress(1);
            thread.join();
        unblockNode(repoName, clusterManagerName);  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        // Fail the cluster manager  
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)  
        final int numDocsInIndex1 = 10;  
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())  
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());  
        super(nodeSettings);
    }
        assertEquals(restoreSnapshotResponse.status(), RestStatus.OK);  
                    assertThat(snapshotInfo.getPinnedTimestamp(), greaterThan(0L));
        awaitNumberOfSnapshotsInProgress(1);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        ensureGreen();  
    public void testCloneSnapshotFailInFinalize() throws Exception {
        Settings indexSettings = getIndexSettings(20, 0).build();
    public void testPinnedTimestampFailSnapshot() throws Exception {  
import org.opensearch.repositories.Repository;  
    public void testDeleteAndCloneV1WhileCreateOngoing() throws Exception {  
        snapshotFuture.get();
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)  
        }
        Settings.Builder settings = Settings.builder()
        return Arrays.asList(
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        createRepository(repoName, "mock", settings);  
    }
import static org.hamcrest.Matchers.containsInAnyOrder;
        assertEquals(3, snapInfo.size());  
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)  
        logger.info("Snapshot Path [{}]", absolutePath1);
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        Client client = client();
            .setIndices(indexName1)
        unblockNode(repoName, clusterManagerName);
        final int numDocsInIndex2 = 20;  
                } catch (Exception e) {}  
            .setRenamePattern("(.+)")  
        stopNode(clusterManagerNode);
    }
            .prepareRestoreSnapshot(repoName, "snapshot-v1-2-clone")  
        logger.info("Snapshot Path [{}]", absolutePath1);
        String indexName1 = "testindex1";  
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, "snapshot-v2");  
    public void testCloneV1WhileV2CreateOngoing() throws Exception {
    }  
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());  
    }  
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        Client client = client();
        settings = Settings.builder()
        final int numDocsInIndex2 = 20;
            int snapshotIndex = i;  
        indexDocuments(client, indexName2, numDocsInIndex2);
                .prepareCreateSnapshot(repoName, snapshotName)
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
    public ConcurrentSnapshotsV2IT(Settings nodeSettings) {
        createIndex(indexName1, indexSettings);
    protected Settings nodeSettings(int nodeOrdinal) {
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)  
            .get();
        assertEquals(1, snapInfo.size());  
        String indexName1 = "testindex1";
        Settings indexSettings = getIndexSettings(20, 0).build();  
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        indexDocuments(client, indexName2, numDocsInIndex2);  
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, "snapshot-v2");  
        createIndex(indexName1, indexSettings);  
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        createIndex(indexName1, indexSettings);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
            .setRenameReplacement("$1-copy")
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), false);
        String snapshotRepoName = "test-create-snapshot-repo";
        Settings indexSettings2 = getIndexSettings(15, 0).build();
        assertTrue(csr.getSnapshotInfo().getPinnedTimestamp() != 0);
        assertTrue(csr.getSnapshotInfo().getPinnedTimestamp() != 0);
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)  
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));  
        createRepository(repoName, "mock", settings);  
        awaitNumberOfSnapshotsInProgress(1);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)  
        CreateSnapshotResponse sourceResp = startFullSnapshot(repoName, sourceSnap).actionGet();
    }
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        String repoName = "test-create-snapshot-repo";
        assertEquals(2, snapInfo.size());  
        Settings.Builder settings = Settings.builder()  
    public void testLongRunningSnapshotDontAllowConcurrentClone() throws Exception {
        createIndex(indexName1, indexSettings);
        final ActionFuture<CreateSnapshotResponse> snapshotFuture2 = startFullSnapshot(repoName, "snapshot-success");
            .get();  
    }
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, "snapshot-queued");
        } catch (Exception e) {}
        String sourceSnap = "snapshot-source";  
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)  
        String indexName2 = "testindex2";  
        // Creating a v2 repo
        Path absolutePath1 = randomRepoPath().toAbsolutePath();  
        unblockNode(repoName, clusterManagerName);  
        indexDocuments(client, indexName2, numDocsInIndex2);
    public void testConcurrentSnapshotV2CreateOperation() throws InterruptedException, ExecutionException {
        Settings indexSettings = getIndexSettings(20, 0).build();  
        snapshotFuture.actionGet();
        assertTrue(startDeleteSnapshot.actionGet().isAcknowledged());  
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        createIndex(indexName2, indexSettings2);
        Client client = client();
            .setRenamePattern("(.+)")
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())  
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();  
        logger.info("Snapshot Path [{}]", absolutePath1);  
        createIndex(indexName2, indexSettings2);
            .build();
    @ParametersFactory
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, "snapshot-queued");
        createRepository(repoName, "mock", settings);
        stopNode(clusterManagerNode);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();  
                        .prepareCreateSnapshot(snapshotRepoName, snapshotName)  
        ActionFuture<AcknowledgedResponse> startDeleteSnapshot = startDeleteSnapshot(repoName, "snapshot-v1");  
 * The OpenSearch Contributors require contributions made to  
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());  
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/16205")
            .get();
    public void testDeleteWhileV2CreateOngoing() throws Exception {
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();  
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());  
        unblockNode(repoName, clusterManagerName);
        Client client = client();
        createIndex(indexName1, indexSettings);
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
        ensureGreen(indexName1, indexName2);
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        final ActionFuture<CreateSnapshotResponse> snapshotFuture2 = startFullSnapshot(repoName, "snapshot-success");
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        createIndex(indexName2, indexSettings2);  
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        indexDocuments(client, indexName1, numDocsInIndex1);
        String indexName2 = "testindex2";
import org.opensearch.node.Node;  
import org.opensearch.action.support.PlainActionFuture;  
    public void testCreateSnapshotV2MasterSwitch() throws Exception {
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
        Settings.Builder settings = Settings.builder()
        );
        ensureGreen(indexName1, indexName2);
        indexDocuments(client, indexName1, numDocsInIndex1);
        createRepository(repoName, "mock", settings);
        String indexName2 = "testindex2";
        assertThat(snapInfo, contains(csr.getSnapshotInfo()));
        // fail segment repo - this is to fail the timestamp pinning
        String indexName2 = "testindex2";
            thread.start();  
        createIndex(indexName2, indexSettings2);
        awaitNumberOfSnapshotsInProgress(1);  
        ActionFuture<AcknowledgedResponse> startCloneSnapshot = startCloneSnapshot(repoName, "snapshot-v1-2", "snapshot-v1-2-clone");
        unblockNode(repoName, clusterManagerNode);
        final int numDocsInIndex2 = 20;  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            .setIndices(indexName1)
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();
        startFullSnapshot(repoName, "snapshot-v1-2").actionGet();
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        // Second create works out cleanly since the repo  
            .prepareRestoreSnapshot(repoName, "snapshot-v1-2-clone")
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        indexDocuments(client, indexName2, numDocsInIndex2);  
        indexDocuments(client, indexName1, numDocsInIndex1);
        ensureGreen(indexName1, indexName2);
        createRepository(repoName, "mock", settings);
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());  
        indexDocuments(client, indexName2, numDocsInIndex2);
        createIndex(indexName2, indexSettings2);
        indexDocuments(client, indexName1, numDocsInIndex1);
        awaitNumberOfSnapshotsInProgress(1);  
        Settings.Builder settings = Settings.builder()  
import java.util.List;
        String indexName2 = "testindex2";  
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();
        for (Thread thread : threads) {
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)  
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)  
        String snapshotName = "snapshot-success";  
        final ActionFuture<AcknowledgedResponse> snapshotFuture2 = startCloneSnapshot(repoName, sourceSnap, "snapshot-clone-2");
        String indexName2 = "testindex2";
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), false);  
        // start all threads
    }
import static org.hamcrest.Matchers.contains;  
        try {
        settings = Settings.builder()
        // Creating a v2 repo
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), false);
        final int numDocsInIndex2 = 20;  
                    assertThat(snapshotInfo.successfulShards(), greaterThan(0));
                .setWaitForCompletion(true)  
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
                        .cluster()
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();
            client().admin().cluster().prepareCreateSnapshot(repoName, snapshotName).setWaitForCompletion(true).get();  
        awaitNumberOfSnapshotsInProgress(1);
        ensureGreen(indexName1, indexName2);  
        String repoName = "test-create-snapshot-repo";
        createRepository(repoName, "mock", settings);  
        final CreateSnapshotResponse csr = startFullSnapshot(repoName, sourceSnap).actionGet();
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)  
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);  
import java.nio.file.Path;
        unblockNode(repoName, clusterManagerName);  
import static org.hamcrest.Matchers.greaterThan;  
        indexDocuments(client, indexName1, numDocsInIndex1);
        final int numDocsInIndex1 = 10;
        blockClusterManagerOnWriteIndexFile(repoName);
        indexDocuments(client, indexName1, numDocsInIndex1);
        // Wait for all threads to complete  
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()  
        String repoName = "test-create-snapshot-repo";
    public void testCreateSnapshotFailInFinalize() throws Exception {
        assertTrue(csr.getSnapshotInfo().getPinnedTimestamp() != 0);
        final int numDocsInIndex1 = 10;  
        PlainActionFuture<RepositoryData> repositoryDataPlainActionFuture = new PlainActionFuture<>();
        indexDocuments(client, indexName2, numDocsInIndex2);
        ensureGreen(indexName1, indexName2);  
        Settings indexSettings = getIndexSettings(10, 0).build();
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());  
        ensureGreen();
                        .get();
        ActionFuture<AcknowledgedResponse> startCloneSnapshot = startCloneSnapshot(repoName, "snapshot-v1", "snapshot-v1-2-clone");  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        String clusterManagerNode = internalCluster().getClusterManagerName();
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        String indexName2 = "testindex2";  
            .setRenameReplacement("$1-copy")
    }
/*  
        setFailRate(BASE_REMOTE_REPO, 100);
        indexDocuments(client, indexName1, numDocsInIndex1);
    }  
            .get();
        logger.info("Snapshot Path [{}]", absolutePath1);  
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        final int numDocsInIndex1 = 10;  
package org.opensearch.snapshots;
        Settings indexSettings2 = getIndexSettings(15, 0).build();  
        final ActionFuture<AcknowledgedResponse> snapshotFuture = startCloneSnapshot(repoName, sourceSnap, "snapshot-queued");
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
        createIndex(indexName1, indexSettings);
            CreateSnapshotResponse createSnapshotResponse = client().admin()  
        Repository repository = internalCluster().getInstance(RepositoriesService.class).repository(snapshotRepoName);  
        ActionFuture<AcknowledgedResponse> a = startDeleteSnapshot(repoName, "snapshot-v1");  
                    assertThat(snapshotInfo.snapshotId().getName(), equalTo(snapshotName));
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        // Fail the cluster manager  
        setFailRate(BASE_REMOTE_REPO, 0);
        assertThat(snapInfo, contains(csr.getSnapshotInfo()));
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, "snapshot-v2");  
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
    }
        Settings.Builder settings = Settings.builder()  
        assertEquals(2, snapInfo.size());
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        String repoName = "test-create-snapshot-repo";  
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)  
        CreateSnapshotResponse csr = snapshotFuture2.actionGet();  
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), true).build() }  
        ensureGreen(indexName1, indexName2);  
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
                    assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));  
            .cluster()  
            fail();
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);
        CreateSnapshotResponse csr = snapshotFuture2.actionGet();
        assertTrue(startCloneSnapshot.actionGet().isAcknowledged());
        String indexName1 = "testindex1";  
import static org.hamcrest.Matchers.equalTo;
        CreateSnapshotResponse csr = snapshotFuture.actionGet();  
        Client client = client();  
                    SnapshotInfo snapshotInfo = createSnapshotResponse2.getSnapshotInfo();  
        Settings indexSettings2 = getIndexSettings(15, 0).build();  
        logger.info("Snapshot Path [{}]", absolutePath1);
        startFullSnapshot(repoName, "snapshot-v1-2").actionGet();
        final int numDocsInIndex1 = 10;
        startFullSnapshot(repoName, "snapshot-v1").actionGet();
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
 * SPDX-License-Identifier: Apache-2.0
        final int numDocsInIndex1 = 10;
        Settings indexSettings2 = getIndexSettings(15, 0).build();  
        assertThrows(ConcurrentSnapshotExecutionException.class, snapshotFuture2::actionGet);  
        assertThrows(SnapshotException.class, snapshotFuture2::actionGet);  
import org.opensearch.transport.client.Client;
        createRepository(repoName, "mock", settings);
        assertThat(snapInfo, containsInAnyOrder(csr.getSnapshotInfo(), sourceResp.getSnapshotInfo()));
        CreateSnapshotResponse csr = startFullSnapshot(repoName, sourceSnap).actionGet();  
        RepositoryData repositoryData = repositoryDataPlainActionFuture.get();
        ensureGreen(indexName1, indexName2);
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());  
        for (Thread thread : threads) {
        String repoName = "test-create-snapshot-repo";
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
        String indexName2 = "testindex2";  
        Settings.Builder settings = Settings.builder()
        assertTrue(startCloneSnapshot.actionGet().isAcknowledged());  
        createIndex(indexName2, indexSettings2);  
        String repoName = "test-create-snapshot-repo";
        unblockNode(repoName, clusterManagerName);
        Settings.Builder settings = Settings.builder()
            Thread thread = new Thread(() -> {
        assertEquals(2, snapInfo.size());  
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);
        createIndex(indexName2, indexSettings2);  
        assertThat(snapInfo, containsInAnyOrder(csr.getSnapshotInfo(), csr2.getSnapshotInfo()));
        Settings indexSettings2 = getIndexSettings(15, 0).build();
            .prepareRestoreSnapshot(repoName, "snapshot-v1-2-clone")
        createIndex(indexName1, indexSettings);  
        CreateSnapshotResponse csr2 = snapshotFuture2.actionGet();
        indexDocuments(client, indexName1, numDocsInIndex1);  
        logger.info("--> creating full snapshot [{}] to repo [{}]", snapshotName, repoName);
        createRepository(repoName, "mock", settings);  
import org.opensearch.remotestore.RemoteSnapshotIT;
            threads.add(thread);
        Settings indexSettings = getIndexSettings(20, 0).build();
 */  
import java.util.Arrays;  
        Settings indexSettings2 = getIndexSettings(15, 0).build();
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)  
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)  
        // Second create works out cleanly since the repo is cleaned up
        indexDocuments(client, indexName2, numDocsInIndex2);  
        String indexName1 = "testindex1";
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/16205")
import org.opensearch.repositories.RepositoryData;
        String sourceSnap = "snapshot-source";  
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, "snapshot-v2");  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                .cluster()
        String indexName2 = "testindex2";
        // Prepare threads for concurrent snapshot creation
        indexDocuments(client, indexName1, numDocsInIndex1);
        indexDocuments(client, indexName2, numDocsInIndex2);  
            .setRenamePattern(indexName1)
        // Second create works out cleanly since the repo
        ActionFuture<AcknowledgedResponse> startDeleteSnapshot = startDeleteSnapshot(repoName, "snapshot-v1");  
    }  
        Settings indexSettings2 = getIndexSettings(15, 0).build();
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)  
        indexDocuments(client, indexName2, numDocsInIndex2);  
        assertThat(snapInfo, contains(csr.getSnapshotInfo()));
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        createIndex(indexName2, indexSettings2);  
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);  
        String repoName = "test-create-snapshot-repo";
        Settings indexSettings = getIndexSettings(20, 0).build();  
        Client client = client();
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        final int numDocsInIndex2 = 20;
        Settings indexSettings2 = getIndexSettings(15, 0).build();
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        Path absolutePath1 = randomRepoPath().toAbsolutePath();  
        Settings indexSettings = getIndexSettings(20, 0).build();
import java.util.ArrayList;
        String indexName2 = "testindex2";
        CreateSnapshotResponse csr = snapshotFuture2.actionGet();  
        awaitNumberOfSnapshotsInProgress(1);
import org.opensearch.core.rest.RestStatus;
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        try {
        }  
        Settings indexSettings2 = getIndexSettings(15, 0).build();
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        String indexName1 = "testindex1";
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)  
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        ensureGreen(indexName1, indexName2);
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), false).build() },
        logger.info("Snapshot Path [{}]", absolutePath1);
        assertTrue(startDeleteSnapshot.actionGet().isAcknowledged());
        } catch (Exception e) {}  
        blockClusterManagerOnWriteIndexFile(repoName);
                try {
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)  
    public void testCloneSnapshotV2MasterSwitch() throws Exception {
            fail();
        Settings.Builder settings = Settings.builder()
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), false);
        createIndex(indexName2, indexSettings2);
        awaitNumberOfSnapshotsInProgress(1);
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        ensureGreen();
        String repoName = "test-create-snapshot-repo";
        createRepository(repoName, "mock", settings);
        // Second create works out cleanly since the repo  
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();
        return clusterAdmin().prepareCloneSnapshot(repoName, sourceSnapshotName, snapshotName).setIndices("*").execute();  
import org.opensearch.common.action.ActionFuture;
            });
        CreateSnapshotResponse csr = snapshotFuture.actionGet();
        final int numDocsInIndex2 = 20;  
        for (int i = 0; i < concurrentSnapshots; i++) {
        createIndex(indexName1, indexSettings);
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        ActionFuture<AcknowledgedResponse> startCloneSnapshot = startCloneSnapshot(repoName, "snapshot-v1-2", "snapshot-v1-2-clone");
        createRepository(repoName, "mock", settings);
        assertEquals(1, snapInfo.size());
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        final int numDocsInIndex1 = 10;
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
        Settings indexSettings = getIndexSettings(20, 0).build();  
        indexDocuments(client, indexName2, numDocsInIndex2);
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        Settings indexSettings = getIndexSettings(20, 0).build();
        createRepository(repoName, "mock", settings);
        final ActionFuture<AcknowledgedResponse> snapshotFuture = startCloneSnapshot(repoName, sourceSnap, "snapshot-queued");
        ensureGreen(indexName1, indexName2);  
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())  
        Settings.Builder settings = Settings.builder()
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        String indexName1 = "testindex1";
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());  
        Settings indexSettings2 = getIndexSettings(15, 0).build();  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        assertEquals(restoreSnapshotResponse.status(), RestStatus.OK);  
import org.opensearch.common.settings.Settings;  
        startFullSnapshot(repoName, "snapshot-v1").actionGet();
                    String snapshotName = "snapshot-concurrent-" + snapshotIndex;  
            .setWaitForCompletion(true)
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
            .cluster()
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)  
        CreateSnapshotResponse csr = snapshotFuture.actionGet();
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();
            .setIndices(indexName1)  
        assertThat(repositoryData.getSnapshotIds().size(), greaterThanOrEqualTo(1));
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());  
        String repoName = "test-create-snapshot-repo";  
        ensureGreen();
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
            .prepareCreateSnapshot(repoName, snapshotName)  
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());  
        createIndex(indexName2, indexSettings2);
import org.opensearch.repositories.blobstore.BlobStoreRepository;
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)  
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        createIndex(indexName1, indexSettings);
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();  
            .setWaitForCompletion(true)
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        assertEquals(3, snapInfo.size());
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        assertThrows(SnapshotException.class, snapshotFuture::actionGet);
        logger.info("Snapshot Path [{}]", absolutePath1);
        indexDocuments(client, indexName1, numDocsInIndex1);
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        final int numDocsInIndex1 = 10;
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        logger.info("Snapshot Path [{}]", absolutePath1);  
        String indexName2 = "testindex2";
        indexDocuments(client, indexName2, numDocsInIndex2);
        final int numDocsInIndex2 = 20;
        String indexName1 = "testindex1";
public class ConcurrentSnapshotsV2IT extends RemoteSnapshotIT {
        createIndex(indexName1, indexSettings);  
        List<SnapshotInfo> snapInfo = client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots();
            .setWaitForCompletion(true)
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
    public void testLongRunningSnapshotDontAllowConcurrentSnapshot() throws Exception {
        indexDocuments(client, indexName1, numDocsInIndex1);  
        Client client = client();
    public void testDeleteAndCloneV1WhileV2CreateOngoing() throws Exception {
        Client client = client();
        final ActionFuture<CreateSnapshotResponse> snapshotFuture2 = startFullSnapshot(repoName, "snapshot-success");
