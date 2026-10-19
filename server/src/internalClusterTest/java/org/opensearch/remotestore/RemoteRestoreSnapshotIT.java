            GetSnapshotsRequest request = new GetSnapshotsRequest(snapshotRepoName);
        assertEquals(restoreSnapshotResponse1.status(), RestStatus.ACCEPTED);
        Settings indexSettings = getIndexSettings(1, 0).build();
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
    }
        indexingThread.join();
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING;
            .prepareUpdateSettings()
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
            this.forceSyncPinnedTimestamps();
        Settings indexSettings2 = getIndexSettings(15, 0).build();
    }
    public void testConcurrentSnapshotV2CreateOperation() throws InterruptedException, ExecutionException {
        // try index restore with index.remote_store.segment.repository modified
        logger.info("Snapshot Path [{}]", absolutePath1);
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        );
        // Wait for the cluster to elect a new Cluster Manager and stabilize
        createIndex(indexName1, indexSettings);
        final int numDocsInIndex1 = 10;
        updateRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, false));
        assertThat(recoveryState.getIndex().recoveredFilesPercent(), greaterThanOrEqualTo(0.0f));
        // Create a separate thread to enable shallow_snapshot_v2
    }
        Settings indexSettings2 = getIndexSettings(15, 0).build();
                snapshotInfoRef.set(createSnapshotResponse.getSnapshotInfo());
            createIndex("index" + i, indexSettings);
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
import org.opensearch.common.Nullable;
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        ensureGreen(indexName1, indexName2);
        Client client = client();
        assertEquals(restoreSnapshotResponse2.status(), RestStatus.ACCEPTED);
            .setRenameReplacement(restoredIndexName1)
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
        final int numDocsInIndex1 = 10;
    public void testCreateSnapshotV2WithIndexingLoad() throws Exception {
            .get();
            .setIndices(indexName1)
        Client client = client();
        assertEquals(2, RemoteStorePinnedTimestampService.getPinnedEntities().size());
            try {
            .get();
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }
            () -> client().admin()
        Settings indexSettings = Settings.builder()
            .cluster()
        // Will create full copy snapshot if `REMOTE_STORE_INDEX_SHALLOW_COPY` is false but `SHALLOW_SNAPSHOT_V2` is true
            .prepareUpdateSettings()
        assertDocsPresentInIndex(client(), indexName1, numDocsInIndex1);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        String path = getShardLevelBlobPath(client, idx, new BlobPath(), "0", TRANSLOG, METADATA, translogPathFixedPrefix).buildAsString();
            new ArrayList<>(Arrays.asList(indexName1, indexName2))
        logger.info("Snapshot Path [{}]", absolutePath1);
        createIndex(indexName1, indexSettings);
        indexDocuments(client, indexName1, numDocsInIndex1 + 2, numDocsInIndex1 + 4);
        Settings indexSettings2 = getIndexSettings(15, 0).build();
        );
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), false)
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);
            assertTrue(repositoryData.getSnapshotIds().contains(snapshotInfo.snapshotId()));
        client(clusterManagerNode).admin()
                .setIndices(index)
    protected IndexShard getIndexShard(String node, String indexName) {
        // Close index 2
            .setWaitForCompletion(false)
        ensureGreen(indexName1, indexName2);
        ) {
        logger.info("Snapshot Path [{}]", absolutePath1);
        String indexName3 = "testindex3";
        }, 30, TimeUnit.SECONDS);
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
            .cluster()
import org.opensearch.test.OpenSearchIntegTestCase;
            .setRenamePattern(indexName1)
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
    }
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);
        assertThat(recoveryState.getIndex().recoveredFilesPercent(), lessThanOrEqualTo(100.0f));
        String index = "test-index";
    }
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
        createIndex(indexName1, indexSettings);
                throw new RuntimeException(e);
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
            .cluster()
                .setIgnoreIndexSettings(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY)
        // Re-initialize client to make sure we are not using client from stopped node.
        ensureGreen(indexName1, indexName2);
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName1, Collections.emptyList());
        stopNode(clusterManagerNode);
        // Validate that the remote_store custom data is present in index metadata for the created index.
import org.opensearch.common.util.io.IOUtils;
        indexDocuments(client, indexName3, 10);
import org.opensearch.core.common.unit.ByteSizeUnit;
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        indexSettings = getIndexSettings(1, 0).build();
import org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm;
                            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        client.admin()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        assertThat(snapshotInfo1.successfulShards(), equalTo(snapshotInfo1.totalShards()));
        indexDocuments(client, restoredIndexName1, numDocsInIndex1, numDocsInIndex1 + 2);
        Client client = client();
        assertDocsPresentInIndex(client(), indexName1, numDocsInIndex1);
            .setIndices(indexName1)
        String snapshotName1 = "test-restore-snapshot1";
        assertRemoteSegmentsAndTranslogUploaded(restoredIndexName2);
        Settings indexSettings = getIndexSettings(20, 0).build();
            .prepareCreateSnapshot(snapshotRepoName, snapshotName1)
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        // try index restore with index.remote_store.translog.repository modified
    }
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
        enableV2Thread.join();
        assertTrue(recoveryState.getIndex().totalBytes() > 0L);
        final int numDocsInIndex2 = 20;
        assertFalse(indexExists(indexName1));
            SnapshotRestoreException.class,
            .setWaitForCompletion(false)
        Client client = client();
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName1)).get());
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
            latchedActionListener
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .setIgnoreIndexSettings(SETTING_REMOTE_STORE_ENABLED)
                    .setWaitForCompletion(true)
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
        logger.info("Snapshot Path [{}]", absolutePath1);
import org.opensearch.node.Node;
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);
        Repository repository = internalCluster().getInstance(RepositoriesService.class).repository(snapshotRepoName);
        assertThat(snapshotInfo2.successfulShards(), equalTo(snapshotInfo2.totalShards()));
        SnapshotInfo snapshotInfo1 = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(Arrays.asList(indexName1)));
            .setWaitForCompletion(false)
            totalSnaps.set(response2.getSnapshots().size());
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        String[] pathTokens = absolutePath1.toString().split("/");
        Client client = client();
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
import org.opensearch.core.index.Index;
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), false);
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, node);
import org.opensearch.action.DocWriteResponse;
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
        IndexService indexService = indicesService.indexService(index);
        String indexName1 = "testindex1";
        indexDocuments(client, indexName2, numDocsInIndex2);
        assertEquals(1, recoveryResponse.shardRecoveryStates().size());
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));
    public void testConcurrentSnapshotV2CreateOperation_MasterChange() throws Exception {
        Path location = PathUtils.get(String.join("/", pathTokens));
        Path absolutePath2 = randomRepoPath().toAbsolutePath();
            thread.join();
    }
        // Validating that custom data has not changed for testindex2 which was created before the cluster setting got updated
            .build();
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
import org.opensearch.common.settings.Settings;
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(Arrays.asList(indexName1)));
        Settings indexSettings = getIndexSettings(20, 0).build();
                }
        indexDocuments(client(), indexName1, numDocsInIndex1);
            () -> client().admin()
                    .get();
        assertEquals(deleteResponse.getResult(), DocWriteResponse.Result.DELETED);
        final int numDocsInIndex1 = 5;
                .cluster()
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        DeleteResponse deleteResponse = client().prepareDelete(indexName1, "0").execute().actionGet();
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
            assertTrue("doc with id" + id + " is not present for index " + indexName, client.prepareGet(indexName, id).get().isExists());
        createIndex(indexName1, indexSettings);
        int concurrentSnapshots = 5;
    }
        ensureGreen(indexName1);
import java.nio.file.Path;
        assertAcked(client().admin().indices().prepareClose(indexName1));
        // for all nodes , run forceSyncPinnedTimestamps()
        indexDocuments(client, indexName1, numDocsInIndex1);
        Settings indexSettings2 = getIndexSettings(15, 0).build();
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);
        indexDocuments(client, indexName1, numDocsInIndex1);
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.enabled]" + " on restore"));
                .setIgnoreIndexSettings(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY)
        logger.info("Snapshot Path [{}]", absolutePath1);
        createIndex(indexName1, indexSettings);
    }
        String indexName2 = "testindex2";
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);
                    .prepareCreateSnapshot(snapshotRepoName, snapshotName1)
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        try (
        String restoredIndexName1version1 = indexName1 + "-restored-1";
            threads.add(thread);
        String indexName1 = "testindex1";
                );
        assertThat(snapshotInfo1.successfulShards(), greaterThan(0));
        // indexing some new docs and validating
        ensureGreen(indexName2);
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.translog.repository]" + " on restore"));
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
                    IllegalStateException.class,
    }
        final AtomicReference<SnapshotInfo> snapshotInfoRef = new AtomicReference<>();
        Settings indexSettings2 = getIndexSettings(15, 0).build();
        indexDocuments(client, indexName1, numDocsInIndex1, numDocsInIndex1 + 2);
        createIndex(indexName2, indexSettings2);
        String indexName3 = "testindex3";
                .setIndexSettings(remoteStoreTranslogIndexSettings)
        String basePath2 = pathTokens[pathTokens.length - 1];
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, newRemoteStoreRepo)
            .setTransientSettings(Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), PathType.FIXED))
        String snapshotName1 = "test-restore-snapshot1";
     */
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
                .setRenamePattern(index)
                .cluster()
                    .setClusterManagerNodeTimeout(TimeValue.timeValueSeconds(60))
        ensureGreen(restoredIndexName1);
        }
        String indexName2 = "testindex2";
        PlainActionFuture<RepositoryData> repositoryDataPlainActionFuture = new PlainActionFuture<>();
        String indexName2 = "testindex2";
                .setRenamePattern(index)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        Settings indexSettings = getIndexSettings(20, 0).build();
        Client client = client();
        createIndex(indexName1, indexSettings);
        assertEquals(1, recoveryResponse.shardRecoveryStates().get(restoredIndexName1).size());
    protected Settings nodeSettings(int nodeOrdinal) {
        ensureGreen(indexName1);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;
        CreateSnapshotResponse createSnapshotResponse2 = client().admin()
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
            .setWaitForCompletion(false)
        // Prepare threads for concurrent snapshot creation
        // Validate that snapshot is present in repository data
            Stream<Path> translogData = Files.list(remoteTranslogDataPath);
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
    }
        SnapshotInfo snapshotInfo2 = createSnapshot(
        ensureGreen(indexName1);
import org.opensearch.index.shard.IndexShard;
            }
        logger.info("--> snapshot");
        } else {
        // indexing some new docs and validating
import org.opensearch.core.action.ActionListener;
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        String translogPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings());
        assertThat(snapshotInfo1.successfulShards(), equalTo(snapshotInfo1.totalShards()));
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        createIndex(indexName1, indexSettings);
        Path segmentDataPath = Path.of(remoteRepoPath + "/" + path);
        forceSyncPinnedTimestamps();
        if (Objects.nonNull(pathHashAlgorithm)) {
        String snapshotRepoName = "test-create-snapshot-repo";
            .cluster()
        ensureRed(restoredIndexName1);
            .get()
                .setWaitForCompletion(false)
        Settings indexSettings = getIndexSettings(1, 0).build();
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        String snapshotRepoName = "test-restore-snapshot-repo";
        internalCluster().startClusterManagerOnlyNode();
            logger.info("Exception while creating new-snapshot", e);
            internalCluster().getClusterManagerName()
            .cluster()
                            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        Settings indexSettings2 = getIndexSettings(1, 0).build();
                    internalCluster().client().prepareIndex("test-index-load").setSource("field", "value" + i).execute().actionGet();
        Settings indexSettings = getIndexSettings(1, 0).build();
        remoteStorePinnedTimestampService.pinTimestamp(
            () -> client().admin()
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), false).build() },
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.TRANSLOG;
                .setRenameReplacement(restoredIndex)
            SnapshotRestoreException.class,
        assertEquals(RemoteStorePinnedTimestampService.getPinnedEntities().size(), 1);
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
            .setWaitForCompletion(false)
        String snapshotName2 = "test-create-snapshot2";
            .cluster()
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        String restoredIndexName1 = indexName1 + "-restored";
            .setRenamePattern(indexName2)
    private void assertDocsPresentInIndex(Client client, String indexName, int numOfDocs) {
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        // stop existing master
        String basePath = pathTokens[pathTokens.length - 1];
        assertThat(snapshotInfo2.successfulShards(), greaterThan(0));
        Path location = PathUtils.get(String.join("/", pathTokens));
        // indexing some new docs and validating
        indexDocuments(client, indexName2, numDocsInIndex2);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
                .setIndices(index)
        assertAcked(client.admin().indices().prepareClose(restoredIndexName1));
        RecoveryResponse recoveryResponse = client().admin().indices().prepareRecoveries(restoredIndexName1).execute().actionGet();
            .prepareCreateSnapshot(snapshotRepoName, snapshotName2)
    public void testSuccessfulIndexRestoredFromSnapshotWithUpdatedSetting() throws IOException, ExecutionException, InterruptedException {
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        createIndex(indexName1, indexSettings);
        // Sleeping 10 sec for earlier created snapshot to complete runNextQueuedOperation and be ready for next snapshot
        String snapshotName1 = "test-restore-snapshot1";
        exception = expectThrows(
                .setIndices(index)
        final String clusterManagerNode = internalCluster().getClusterManagerName();
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
                .get()
        // Create index with cluster setting cluster.remote_store.index.path.type as hashed_prefix.
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
            .restoreRemoteStore(
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
        assertTrue(snapshotInfo.indices().contains(indexName2));
package org.opensearch.remotestore;
        Repository repository = internalCluster().getInstance(RepositoriesService.class).repository(snapshotRepoName);
            .setIndices(indexName2)
        return Settings.builder()
        createRepository(remoteStoreRepoNameUpdated, "fs", remoteRepoPath);
                .setIndices(index)
        ensureGreen(indexName1);
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        String snapshotRepoName = "test-create-snapshot-repo";
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(indexName1).restoreAllShards(true), PlainActionFuture.newFuture());
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        exception = expectThrows(
                .setRenameReplacement(restoredIndex)
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName2)
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        createV1SnapshotThread.join();
            () -> client().admin()
        indexDocuments(client, indexName3, 10);
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        createIndex(indexName1, indexSettings);
        // verify response status if waitForCompletion is not true
        final int numDocsInIndex2 = 20;
import org.opensearch.indices.IndicesService;
            .get();
        });
        SnapshotInfo snapshotInfo1 = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(Arrays.asList(indexName1)));
        internalCluster().stopCurrentClusterManagerNode();
        String snapshotName1 = "test-restore-snapshot1";
            .get();
        String snapshotName2 = "test-restore-snapshot2";
        SnapshotInfo snapshotInfo = createSnapshotResponse2.getSnapshotInfo();
        }
        logger.info("--> snapshot");
        createIndex(indexName1, indexSettings);
    private void validatePathType(String index, PathType pathType) {
        indexDocuments(client, indexName1, numDocsInIndex1);
        createIndex(indexName2, indexSettings2);
                .setWaitForCompletion(false)
                assertThrows(
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        client().admin().cluster().prepareCreateSnapshot(snapshotRepoName, "snapshot-cleanup-timestamp").setWaitForCompletion(true).get();
                            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true)
        assertAcked(client().admin().indices().prepareClose(indexName2));
            thread.start();
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        }
        String snapshotRepoName = "test-create-snapshot-repo";
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        return shardId.map(indexService::getShard).orElse(null);
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.segment.repository]" + " on restore"));
import org.opensearch.common.unit.TimeValue;
        SnapshotInfo snapshotInfo = createSnapshotResponse2.getSnapshotInfo();
            );
                .cluster()
        thread.join();
            .setWaitForCompletion(true)
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
                fail("indexing failed due to exception: " + e.getMessage());
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
        String indexName1 = "testindex1";
        // deleting data for restoredIndexName1 and restoring from remote store.
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepo, snapshotName1, new ArrayList<>(List.of(index)));
            try {
            Stream<Path> translogMetadata = Files.list(remoteTranslogMetadataPath);
        client = client(clusterManagerNode);
        }
        validatePathType(indexName2, PathType.HASHED_PREFIX, PathHashAlgorithm.FNV_1A_COMPOSITE_1);
        repository.getRepositoryData(repositoryDataPlainActionFuture);
        assertEquals(deleteResponse.getResult(), DocWriteResponse.Result.DELETED);
        SnapshotInfo snapshotInfo2 = createSnapshot(snapshotRepo, snapshotName2, new ArrayList<>(List.of(index)));
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        Thread.sleep(1000);
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
        internalCluster().startDataAndWarmNodes(2);
                .setIndexSettings(remoteStoreSegmentIndexSettings)
        return Arrays.asList(
            public void onResponse(Void unused) {}
        final AtomicBoolean snapshotFailed = new AtomicBoolean(false);
        String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(getNodeSettings());
            public void onFailure(Exception e) {}
        String snapshotRepoName = "test-restore-snapshot-repo";
        createIndex(indexName2, indexSettings2);
            .setSourceRemoteStoreRepository(remoteStoreRepoNameUpdated)
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        ensureGreen(index);
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
        DeleteResponse deleteResponse = client().prepareDelete(index, "0").execute().actionGet();
    public RemoteRestoreSnapshotIT(Settings nodeSettings) {
            @Override
        // try index restore with index.number_of_replicas setting modified. index.number_of_replicas can be modified on restore
        );
        // enable shallow_snapshot_v2
        String indexName2 = "testindex2";
            .setIndices(indexName2)
        assertTrue(recoveryState.getIndex().totalRecoverBytes() > 0L);
        ensureGreen(indexName1, indexName2);
        LatchedActionListener<Void> latchedActionListener = new LatchedActionListener<>(new ActionListener<>() {
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
        indexDocuments(client, indexName1, numDocsInIndex1);
        Client client = client();
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
            .get();
        Settings.Builder settings = Settings.builder()
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        assertThat(recoveryState.getIndex().time(), greaterThanOrEqualTo(0L));
import org.opensearch.indices.recovery.RecoveryState;
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
                    .setWaitForCompletion(true)
        assertEquals(restoreSnapshotResponse1.status(), RestStatus.ACCEPTED);
        refresh(indexName1);
        String snapshotName1 = "test-create-snapshot1";
 * The OpenSearch Contributors require contributions made to
                    )
        Client client = client();
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        ensureGreen(indexName1, indexName2);
        final int numDocsInIndex1 = randomIntBetween(20, 30);
    @ParametersFactory
        createIndex(indexName2, indexSettings2);
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
    public void testRestoreShallowSnapshotIndexAfterSnapshot() throws ExecutionException, InterruptedException {
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        // try index restore with index.remote_store.translog.repository and index.remote_store.segment.repository modified
        });
            });
            .get();
        assertTrue(recoveryResponse.shardRecoveryStates().containsKey(restoredIndexName1));
        String snapshotRepoName = "test-create-snapshot-repo";
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, newRemoteStoreRepo)
        String snapshotName1 = "test-create-snapshot1";
        String basePath2 = pathTokens[pathTokens.length - 1];
        ensureGreen(indexName2);
        createIndex(indexName2, indexSettings2);
                    .prepareCreateSnapshot(snapshotRepoName, snapshotName)
    }
        assertEquals(RestStatus.ACCEPTED, restoreSnapshotResponse.status());
        // Start indexing
        Client client = client();
        assertEquals(RestStatus.ACCEPTED, restoreSnapshotResponse.status());
        ensureGreen(indexName1);
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
    }
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        String snapshotName1 = "test-create-snapshot-v1";
        createIndex(indexName1, indexSettings);
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(Arrays.asList(indexName1, indexName2)));
        flushAndRefresh(indexName1);
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
 * this file be licensed under the Apache-2.0 license or a
            .status();
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
import java.util.stream.Collectors;
}
        // Create Snapshot of index 2
                .setRenameReplacement(restoredIndex)
        int numDocsInIndex1 = randomIntBetween(2, 5);
        assertAcked(client.admin().indices().prepareClose(indexName1));
        RestoreSnapshotResponse restoreSnapshotResponse1 = client.admin()
            .setIndices(indexName1)
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        assertThat(snapshotInfo2.state(), equalTo(SnapshotState.SUCCESS));
        assertThat(snapshotInfo1.successfulShards(), equalTo(snapshotInfo1.totalShards()));
        });
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        assertNotNull(remoteCustomData);
        createIndex(indexName2, indexSettings2);
            Stream<Path> segmentMetadata = Files.list(segmentMetadataPath);
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
        internalCluster().startDataAndWarmNodes(1);
            .setWaitForCompletion(false)
 */
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
                .setIndexSettings(remoteStoreIndexSettings)
import org.opensearch.common.io.PathUtils;
        assertEquals(restoreSnapshotResponse1.status(), RestStatus.ACCEPTED);
        Path absolutePath2 = randomRepoPath().toAbsolutePath();
            .build();
        boolean enableShallowCopy = randomBoolean();
            .prepareCreateSnapshot(snapshotRepoName, snapshotName2)
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
            .get();
        indexDocuments(client, indexName2, numDocsInIndex2);
        final int numDocsInIndex2 = 20;
        ensureGreen(restoredIndexName1);
        validatePathType(restoredIndexName1version1, PathType.FIXED);
                .setRenamePattern(index)
        assertDocsPresentInIndex(client, indexName1, numDocsInIndex1 + 4);
        assertThat(snapshotInfo.getPinnedTimestamp(), greaterThan(0L));
import org.opensearch.indices.replication.common.ReplicationType;
        }, latch);
            .cluster()
        RestoreSnapshotResponse restoreSnapshotResponse2 = client.admin()
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
import org.opensearch.action.delete.DeleteResponse;
        waitUntil(() -> {
        createIndex(indexName2, indexSettings2);
                    .cluster()
        restoreSnapshotResponse = client.admin()
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
        // Wait for a bit to let some documents be indexed
                    .get();
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);
        String indexName2 = "testindex2";
        internalCluster().startDataAndWarmNodes(1);
        assertDocsPresentInIndex(client, indexName1, numDocsInIndex1 + 2);
        pathTokens = absolutePath2.toString().split("/");
        );
                .get()
        logger.info("Snapshot Path [{}]", absolutePath1);
        assertDocsPresentInIndex(client, restoredIndexName2, numDocsInIndex2);
        ensureGreen(indexName1, indexName2);
        String snapshotName1 = "test-restore-snapshot1";
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        ensureRed(indexName2);
                .get()
        assertTrue(recoveryState.getIndex().totalFileCount() > 0);
            .put(super.indexSettings())
        client(clusterManagerNode).admin()
        ensureGreen(indexName1);
        assertFalse(recoveryState.getIndex().fileDetails().isEmpty());
        String snapshotName2 = "test-restore-snapshot2";
        indexDocuments(client, indexName1, numDocsInIndex1);
import org.opensearch.action.support.PlainActionFuture;
        final int numDocsInIndex1 = 10;
        for (int i = 0; i < 10; i++) {
        } catch (Exception e) {
        assertEquals(snapshotInfo.totalShards(), snapshotInfo.successfulShards());
        assertTrue(exception.getMessage().contains("cannot remove setting [index.remote_store.enabled] on restore"));
        Thread.sleep(TimeValue.timeValueSeconds(10).seconds());
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
            GetSnapshotsResponse response2 = client().admin().cluster().getSnapshots(request).actionGet();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY;
 * compatible open source license.
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
            .cluster()
        restoreSnapshotResponse = client.admin()
@SuppressForbidden(reason = "Need to fix: https://github.com/opensearch-project/OpenSearch/issues/14324")
            .setWaitForCompletion(false)
        indexDocuments(client, indexName1, numDocsInIndex1);
        ensureRed(indexName1);
        String indexName2 = "testindex2";
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
import org.opensearch.transport.client.Client;
            .build();
        SnapshotInfo snapshotInfo1 = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(List.of(indexName1)));
        indexDocuments(client, indexName1, numDocsInIndex1);
            .cluster()
        Settings indexSettings = getIndexSettings(20, 0).build();
        internalCluster().startClusterManagerOnlyNode();
        Settings remoteStoreIndexSettings = Settings.builder().put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false).build();
                            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        assertThat(snapshotInfo1.successfulShards(), equalTo(snapshotInfo1.totalShards()));
        internalCluster().startClusterManagerOnlyNode();
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
        try {
        for (int i = 0; i < 10; i++) {
                .setWaitForCompletion(false)
            assertThat(response2.getSnapshots().size(), greaterThanOrEqualTo(1));
                .setRenameReplacement(restoredIndex)
        assertThat(snapshotInfo1.successfulShards(), greaterThan(0));
        final int numDocsInIndex1 = 10;
        indexDocuments(client, restoredIndexName1, numDocsInIndex1, numDocsInIndex1 + 2);
        );
    @Override
            .setIndices(indexName2)
        assertThat(snapshotInfo2.successfulShards(), greaterThan(0));
        createRepository(remoteStoreRepoNameUpdated, "fs", remoteRepoPath);
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1);
                    .prepareCreateSnapshot(snapshotRepoName, snapshotName1)
            return RemoteStorePinnedTimestampService.getPinnedEntities().size() == totalSnaps.intValue();
import org.opensearch.common.blobstore.BlobPath;
            } catch (Exception ignored) {}
            RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        }
    }
import java.util.Arrays;
        for (int i = 0; i < 10; i++) {
        assertEquals(RestStatus.ACCEPTED, restoreSnapshotResponse.status());
        final int numDocsInIndex1 = 5;
        final int numDocsInIndex1 = 10;
        assertDocsPresentInIndex(client, restoredIndexName2, numDocsInIndex2);
import java.util.stream.Stream;
        logger.info("Snapshot Path [{}]", absolutePath1);
                .setIgnoreIndexSettings(
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.SEGMENTS;
        }
        client().admin().indices().close(Requests.closeIndexRequest(indexName1)).get();
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CountDownLatch;
        internalCluster().startClusterManagerOnlyNodes(3, pinnedTimestampSettings());
            .cluster()
            .get();
        for (int i = 0; i < concurrentSnapshots; i++) {
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
import org.opensearch.repositories.RepositoriesService;
        path = getShardLevelBlobPath(client, idx, new BlobPath(), "0", SEGMENTS, DATA, segmentsPathFixedPrefix).buildAsString();
        ensureGreen(indexName1);
        indexDocuments(client, indexName2, 20);
        // Create a separate thread to create the first snapshot
        ensureGreen(indexName1);
        logger.info("--> snapshot");
        Client client = client();
                .setRenamePattern(index)
                new RestoreRemoteStoreRequest().indices(restoredIndexName1).restoreAllShards(true),
        indexDocuments(client, indexName1, randomIntBetween(5, 10));
            .get();
        // verify even if waitForCompletion is not true, the request executes in a sync manner
        // We can't put `waitFor` since we don't have visibility on its completion
        for (Thread thread : threads) {
        Settings indexSettings = getIndexSettings(20, 0).build();
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
            try {
        assertThat(snapshotInfo1.state(), equalTo(SnapshotState.SUCCESS));
        String indexName1 = "testindex1";
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);
        );
        Settings.Builder settings = Settings.builder()
        String snapshotRepoName = "test-restore-snapshot-repo";
            logger.info("checking for index " + indexName + " with docId" + id);
        List<Thread> threads = new ArrayList<>();
        }
        indexDocuments(client, restoredIndexName1, numDocsInIndex1, numDocsInIndex1 + 2);
            .build();
            snapshotName2,
import java.util.concurrent.atomic.AtomicLong;
            .cluster()
            .build();
        final int numDocsInIndex2 = 20;
        assertRemoteSegmentsAndTranslogUploaded(indexName1);
        String restoredIndexName1version2 = indexName1 + "-restored-2";
        Thread createV1SnapshotThread = new Thread(() -> {
        ensureGreen(indexName1, restoredIndexName2);
                .cluster()
            snapshotRepoName,
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1);
        assertThat(snapshotInfo.snapshotId().getName(), equalTo(snapshotName2));
import org.opensearch.cluster.routing.RecoverySource;
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        Settings.Builder settings = Settings.builder()
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
import org.opensearch.transport.client.Requests;
        validatePathType(restoredIndexName1version2, PathType.HASHED_PREFIX, PathHashAlgorithm.FNV_1A_COMPOSITE_1);
            .get();
            SnapshotRestoreException.class,
                String snapshotName = "snapshot-earlier-master";
import org.opensearch.indices.RemoteStoreSettings;
        // try index restore with index.remote_store.enabled ignored
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
    }
        final int numDocsInIndex1 = randomIntBetween(20, 30);
        ensureGreen(indexName1, indexName2);
    }
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
                        FsRepository.TYPE,
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
        indexDocuments(client, indexName1, numDocsInIndex1, numDocsInIndex1 + randomIntBetween(2, 5));
        Repository repository = internalCluster().getInstance(RepositoriesService.class).repository(snapshotRepoName);
        Path remoteTranslogDataPath = Path.of(remoteRepoPath + "/" + path);
                    IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY
import java.util.concurrent.atomic.AtomicBoolean;
        RecoveryState recoveryState = recoveryResponse.shardRecoveryStates().get(restoredIndexName1).get(0);
import org.opensearch.cluster.metadata.IndexMetadata;
        logger.info("--> snapshot");
        String[] pathTokens = absolutePath1.toString().split("/");
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
     * on snapshot restore.
            } catch (Exception e) {
                    .get();
        String snapshotName2 = "test-create-snapshot-v2";
import org.opensearch.snapshots.SnapshotState;
            .get();
        int extraNumDocsInIndex1 = randomIntBetween(20, 50);
        createIndex(indexName2, indexSettings2);
import static org.hamcrest.Matchers.greaterThan;
        Settings indexSettings = Settings.builder()
        );
                    IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY,
        Client client = client();
        logger.info("Snapshot Path [{}]", absolutePath1);
        assertThat(snapshotInfo.getPinnedTimestamp(), equalTo(0L));
            .get();
        path = getShardLevelBlobPath(client, idx, new BlobPath(), "0", SEGMENTS, METADATA, segmentsPathFixedPrefix).buildAsString();
        internalCluster().startDataAndWarmNodes(2);
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
            .cluster()
            .setWaitForCompletion(true)
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
        String snapshotRepoName = "test-create-snapshot-repo";
        for (String node : internalCluster().getNodeNames()) {
        assertEquals(1, recoveryResponse.getTotalShards());
        // indexing some new docs and validating
            .cluster()
            } catch (Exception e) {
        String indexName1 = "testindex1";
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        }
        // start all threads
            return RemoteStorePinnedTimestampService.getPinnedEntities().size() == repositoryData.getSnapshotIds().size();
        logger.info("Path 1 [{}]", absolutePath1);
        forceSyncPinnedTimestamps();
            .cluster()
        assertTrue(snapshotInfo.indices().contains(indexName1));
        ensureYellowAndNoInitializingShards(restoredIndexName1);
        CreateSnapshotResponse createSnapshotResponse2 = client().admin()
            .setWaitForCompletion(false)
            SnapshotRestoreException.class,
        indexDocuments(client, indexName2, numDocsInIndex2);
import org.opensearch.repositories.Repository;
        ensureStableCluster(3);
        String snapshotRepoName = "test-restore-snapshot-repo";
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
                            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.METADATA;
        assertThat(snapshotInfo1.state(), equalTo(SnapshotState.SUCCESS));
        Arrays.copyOf(pathTokens, pathTokens.length - 1);
        );
            assertTrue(repositoryData.getSnapshotIds().isEmpty());
        indexDocuments(client, indexName2, numDocsInIndex2);
            .put(super.indexSettings())
        client = client(clusterManagerNode);
        String snapshotRepoName = "test-create-snapshot-repo";
        // try index restore with index.remote_store.enabled modified
    public void testMixedSnapshotCreationWithV2RepositorySetting() throws Exception {
            .setRenamePattern(indexName1)
        String indexName2 = "testindex2";
    }
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        validatePathType(indexName1, PathType.FIXED);
        assertThat(snapshotInfo.getPinnedTimestamp(), greaterThan(0L));
        indexDocuments(client, indexName1, numDocsInIndex1);
        Arrays.copyOf(pathTokens, pathTokens.length - 1);
        String restoredIndexName2 = indexName2 + "-restored";
        ensureGreen(restoredIndexName1);
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        final int numDocsInIndex1 = 10;
        // Update cluster settings to FIXED
            .setWaitForCompletion(true)
        indexDocuments(client, indexName1, numDocsInIndex1);
                .setIndices(index)
            .setIndices(indexName1)
        Client client = client();
        repository.getRepositoryData(repositoryDataPlainActionFuture);
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName2)
        assertThat(snapshotInfo.getPinnedTimestamp(), greaterThan(0L));
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;
        assertThat(snapshotInfo2.successfulShards(), greaterThan(0));
        internalCluster().startDataAndWarmNodes(1);
        indexDocuments(client, indexName2, 20);
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    }
public class RemoteRestoreSnapshotIT extends RemoteSnapshotIT {
            }
            snapshotName1,
        // Wait for all threads to complete
        String snapshotName = "new-snapshot";
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        Settings indexSettings2 = getIndexSettings(15, 0).build();
            .setIndices(indexName1)
        logger.info("--> snapshot");
import java.util.Optional;
        String snapshotName1 = "test-create-snapshot1";
            .cluster()
        String indexName1 = "testindex1";
        updateRepository(snapshotRepo, "fs", getRepositorySettings(absolutePath1, false));
        String snapshotRepoName = "test-restore-snapshot-repo";
                )
                .get()
            try {
    void assertRemoteSegmentsAndTranslogUploaded(String idx) throws IOException {
        String indexName1 = "testindex1";
                .get()
            .setIndexSettings(numberOfReplicasSettings)
        indexDocuments(client, indexName2, numDocsInIndex2);
        final CreateSnapshotResponse[] snapshotV1Response = new CreateSnapshotResponse[1];
        assertEquals(0, recoveryResponse.getFailedShards());
        String snapshotRepoName = "test-restore-snapshot-repo";
            }
            .cluster()
        Client client = client();
            .setRenamePattern(indexName2)
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        final int numDocsInIndex2 = 20;
        String snapshotRepoName = "test-create-snapshot-repo";
        );
        String indexName1 = "testindex1";
        logger.info("Snapshot Path [{}]", absolutePath1);
        assertThat(snapshotInfo.snapshotId().getName(), equalTo(snapshotName1));
        assertThat(repositoryData.getSnapshotIds().size(), greaterThanOrEqualTo(2));
                .cluster()
    private void validatePathType(String index, PathType pathType, @Nullable PathHashAlgorithm pathHashAlgorithm) {
        Client client = client();
        SnapshotRestoreException exception = expectThrows(
            .cluster()
        final int numDocsInIndex2 = 6;
            getPinningEntity(snapshotRepoName, "some_uuid"),
        RepositoryData repositoryData = repositoryDataPlainActionFuture.get();
        createIndex(indexName3, indexSettings);
import java.util.Collections;
    }
        String snapshotName1 = "test-restore-snapshot1";
import org.opensearch.cluster.ClusterState;
            .prepareUpdateSettings()
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
                    () -> createRepository(
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        assertTrue(snapshotInfo.indices().contains("test-index-load"));
                node
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
        assertEquals(restoreSnapshotResponse2.status(), RestStatus.ACCEPTED);
        createIndex(indexName2, indexSettings2);
        String snapshotName1 = "test-create-snapshot1";
            Thread thread = new Thread(() -> {
import java.util.Collection;
                .get()
            }
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
        String snapshotName1 = "test-create-snapshot1";
            .setRenameReplacement(restoredIndexName1version1)
            () -> client().admin()
        String newRemoteStoreRepo = "test-new-rs-repo";
        super(nodeSettings);
        String indexName2 = "testindex2";
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
                for (int i = 0; i < 50; i++) {
        Thread thread = new Thread(() -> {
        });
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        assertThat(snapshotInfo2.successfulShards(), equalTo(snapshotInfo2.totalShards()));
        forceSyncPinnedTimestamps();
        Settings indexSettings2 = getIndexSettings(15, 0).build();
        assertEquals(snapshotInfo.totalShards(), snapshotInfo.successfulShards());
            .setSourceRemoteStoreRepository(remoteStoreRepoNameUpdated)
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
                .setWaitForCompletion(false)
                    client().admin().cluster().prepareCreateSnapshot(snapshotRepoName, snapshotName).setWaitForCompletion(true).get();
            .get();
                .setRenamePattern(index)
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        validatePathType(index, pathType, null);
        Settings remoteStoreTranslogIndexSettings = Settings.builder()
        createIndex(index, indexSettings);
                throw new RuntimeException(e);
            ensureGreen("index" + i);
        Settings indexSettings = getIndexSettings(20, 0).build();
        ensureGreen(indexName1, indexName2);
            .setWaitForCompletion(true)
                .setIndices(index)
        String snapshotName1 = "test-create-snapshot-v1";
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName1, Collections.emptyList());
        assertEquals(RestStatus.ACCEPTED, createSnapshotResponseStatus);
        client(clusterManagerNode).admin()
        thread.start();
        snapshotInfo = createSnapshotResponse2.getSnapshotInfo();
        indexDocuments(client, indexName1, numDocsInIndex1, numDocsInIndex1 + randomIntBetween(2, 5));
        );
        createIndex(indexName1, indexSettings);
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        createRepository(snapshotRepo, "fs", getRepositorySettings(absolutePath1, true));
        String snapshotRepoName = "test-create-snapshot-repo";
            SnapshotRestoreException.class,
            .setTransientSettings(Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), PathType.FIXED))
                // Start snapshot creation
        ensureGreen(indexName1, indexName2);
                .setWaitForCompletion(false)
        RestoreSnapshotResponse restoreSnapshotResponse2 = client.admin()
        assertThat(snapshotInfo2.state(), equalTo(SnapshotState.SUCCESS));
        logger.info("Snapshot Path [{}]", absolutePath1);
import org.opensearch.snapshots.SnapshotRestoreException;
        logger.info("Snapshot Path [{}]", absolutePath1);
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
                .cluster()
        logger.info("Path 2 [{}]", absolutePath2);
        // Clear the local data before stopping the node. This will make sure that remote translog is empty.
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        snapshotInfo = createSnapshot(snapshotRepoName, snapshotName2, new ArrayList<>(List.of(indexName2)));
            () -> client().admin()
            .setTransientSettings(Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), PathType.HASHED_PREFIX))
        Thread indexingThread = new Thread(() -> {
        String indexName2 = "testindex2";
        // Wait for the snapshot thread to complete
                PlainActionFuture.newFuture()
    public void testRestoreOperationsShallowCopyEnabled() throws Exception {
            forceSyncPinnedTimestamps();
        // Validating that custom data has not changed for indexes which were created before the cluster setting got updated
        Settings.Builder settings = Settings.builder()
            remoteStorePinnedTimestampService.forceSyncPinnedTimestamps();
        logger.info("--> snapshot");
        Settings indexSettings = getIndexSettings(20, 0).build();
        ensureRed(indexName1);
        Settings remoteStoreSegmentIndexSettings = Settings.builder()
        indexDocuments(client, indexName1, 10);
import java.nio.file.Files;
        ensureGreen(indexName1, indexName2);
                .get()
        repository.getRepositoryData(repositoryDataPlainActionFuture);
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName1, Collections.emptyList());
        RepositoryData repositoryData = repositoryDataPlainActionFuture.get();
/*
        createIndex(indexName1, indexSettings);
        ensureGreen(index);
        // indexing some new docs and validating
        final int numDocsInIndex2 = 20;
        ensureGreen(restoredIndexName1);
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
            IOUtils.deleteFilesIgnoringExceptions(files.collect(Collectors.toList()));
        internalCluster().startDataAndWarmNodes(1);
        RestStatus createSnapshotResponseStatus = client().admin()
                RemoteStorePinnedTimestampService.class,
        PlainActionFuture<RepositoryData> repositoryDataPlainActionFuture = new PlainActionFuture<>();
    /**
        RestoreSnapshotResponse restoreSnapshotResponse2 = client.admin()
        assertDocsPresentInIndex(client(), indexName1, numDocsInIndex1);
        String restoredIndexName1 = indexName1 + "-restored";
        logger.info("Snapshot Path [{}]", absolutePath1);
 * SPDX-License-Identifier: Apache-2.0
                .cluster()
        String basePath = pathTokens[pathTokens.length - 1];
        String indexName2 = "testindex2";
        }
        updateRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, false));
        final Index index = resolveIndex(indexName);
        indexDocuments(client, indexName2, numDocsInIndex2);
import java.util.concurrent.ExecutionException;
    public void testRemoteRestoreIndexRestoredFromSnapshot() throws IOException, ExecutionException, InterruptedException {
        // Validate that we have greater one snapshot has been created
import java.util.Map;
        String remoteStoreRepoNameUpdated = "test-rs-repo-updated" + TEST_REMOTE_STORE_REPO_SUFFIX;
    public void testConcurrentV1SnapshotAndV2RepoSettingUpdate() throws Exception {
        assertDocsPresentInIndex(client(), indexName1, numDocsInIndex1);
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName1)).get());
            .get();
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName2)
        RepositoryData repositoryData = repositoryDataPlainActionFuture.get();
                .cluster()
        ensureStableCluster(3, internalCluster().getClusterManagerName());
        // ensure recovery details are non-zero
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1 + 2);
                .get()
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), false);
        );
        // create an orphan timestamp related to this repo
        for (Thread thread : threads) {
            .setRenameReplacement(restoredIndexName1)
        final int numDocsInIndex2 = 6;
        indexDocuments(client, indexName2, numDocsInIndex2);
            .get();
        validatePathType(indexName2, PathType.HASHED_PREFIX, PathHashAlgorithm.FNV_1A_COMPOSITE_1);
        ensureGreen(restoredIndexName1version2);
        assertTrue(snapshotInfo.successfulShards() > 0);
                .setWaitForCompletion(false)
        assertNotNull(indexService);
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.DATA;
        createIndex(indexName1, indexSettings);
        ensureRed(indexName1);
        });
        waitUntil(() -> 1 == RemoteStorePinnedTimestampService.getPinnedEntities().size());
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        forceSyncPinnedTimestamps();
            .get();
        logger.info("Snapshot Path [{}]", absolutePath1);
        assertEquals(RecoverySource.Type.SNAPSHOT, recoveryState.getRecoverySource().getType());
        logger.info("--> snapshot");
                    .cluster()
        Settings.Builder settings = Settings.builder()
        // Validate that the snapshot was created or handled gracefully
        Thread.sleep(100);
        logger.info("Path 1 [{}]", absolutePath1);
        ensureGreen(indexName1);
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
import org.opensearch.index.IndexService;
        Settings multipleRemoteStoreIndexSettings = Settings.builder()
import org.opensearch.repositories.RepositoryData;
        createIndex(indexName2, indexSettings2);
        exception = expectThrows(
        latch.await();
    public void testInvalidRestoreRequestScenarios() throws Exception {
        final Optional<Integer> shardId = indexService.shardIds().stream().findFirst();
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        Settings.Builder settings = Settings.builder()
        assertThat(snapshotInfo1.state(), equalTo(SnapshotState.SUCCESS));
                .setRenamePattern(index)
                        Settings.builder()
        ensureGreen(indexName1);
            .cluster()
        Settings.Builder settings = Settings.builder()
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        String snapshotRepoName = "test-restore-snapshot-repo";
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        Client client = client();
        assertEquals(pathType.name(), remoteCustomData.get(PathType.NAME));
        Settings.Builder settings = Settings.builder()
        SnapshotInfo snapshotInfo1 = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(List.of(indexName1)));
        String snapshotName2 = "test-restore-snapshot2";
    public void testCreateSnapshotV2() throws Exception {
        String indexName1 = "testindex1";
        SnapshotInfo snapshotInfo2 = createSnapshot(
        String snapshotName2 = "test-restore-snapshot2";
                    .setWaitForCompletion(true)
        ensureGreen(indexName1);
                .setIndices(index)
        createIndex(indexName3, indexSettings);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        assertThat(recoveryState.getIndex().recoveredBytesPercent(), greaterThanOrEqualTo(0.0f));
        assertDocsPresentInIndex(client, indexName1, numDocsInIndex1);
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
        final CountDownLatch latch = new CountDownLatch(1);
        String primary = internalCluster().startDataAndWarmNodes(1).get(0);
        long pinnedTimestamp = System.currentTimeMillis();
        final int numDocsInIndex1 = 10;
        final int numDocsInIndex = 5;
        String snapshotName1 = "test-restore-snapshot1";
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
            .get();
    public void testCreateSnapshotV2WithRedIndex() throws Exception {
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
            .setRenameReplacement(restoredIndexName2)
        exception = expectThrows(
            .setWaitForCompletion(true)
            .cluster()
        Client client = client();
            () -> client().admin()
        String indexName1 = "testindex1";
            .build();
        String restoredIndex = index + "-restored";
        ensureGreen(restoredIndexName1);
        String remoteStoreRepoNameUpdated = "test-rs-repo-updated" + TEST_REMOTE_STORE_REPO_SUFFIX;
        assertThat(snapshotInfo2.successfulShards(), equalTo(snapshotInfo2.totalShards()));
import org.opensearch.index.IndexSettings;
    }
        assertTrue(snapshotInfo.successfulShards() > 0);
        }
            @Override
                        snapshotRepoName,
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
                .setIndices(index)
        indexDocuments(client, indexName1, numDocsInIndex1);
        String indexName1 = "testindex1";
        // ensure populated file details
import org.opensearch.core.rest.RestStatus;
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
        String snapshotName1 = "test-restore-snapshot1";
        Settings indexSettings2 = getIndexSettings(15, 0).build();
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        assertThat(snapshotInfo1.successfulShards(), greaterThan(0));
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        Client client = client();
        indexDocuments(client, indexName1, extraNumDocsInIndex1);
                CreateSnapshotResponse createSnapshotResponse = client().admin()
            String id = Integer.toString(i);
    public void forceSyncPinnedTimestamps() {
        }
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
import java.util.concurrent.atomic.AtomicReference;
        Arrays.copyOf(pathTokens, pathTokens.length - 1);
        Settings indexSettings2 = getIndexSettings(1, 0).build();
        createRepository(snapshotRepoName, "fs", getRepositorySettings(location, basePath, true));
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), true).build() }
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        assertThat(recoveryState.getIndex().recoveredBytesPercent(), lessThanOrEqualTo(100.0f));
        DeleteResponse deleteResponse = client().prepareDelete(indexName1, "0").execute().actionGet();
        createV1SnapshotThread.start();
                .setRenameReplacement(restoredIndex)
        logger.info("Path 2 [{}]", absolutePath2);
        // Validate that snapshot is present in repository data
        // ensure populated bytes details
        Thread snapshotThread = new Thread(() -> {
        String snapshotName1 = "test-create-snapshot1";
                    .admin()
        assertTrue(restoreSnapshotResponse2.getRestoreInfo().failedShards() == 0);
            .cluster()
import org.opensearch.action.LatchedActionListener;
        Thread.sleep(100);
                .setRenameReplacement(restoredIndex)
            snapshotRepoName,
                .setRenameReplacement(restoredIndex)
            assertTrue(segmentData.count() > 0);
            new ArrayList<>(Arrays.asList(indexName1, indexName2))
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        Settings indexSettings = getIndexSettings(1, 0).build();
        Settings.Builder settings = Settings.builder()
            assertTrue(segmentMetadata.count() > 0);
        assertThat(snapshotInfo.getPinnedTimestamp(), greaterThan(0L));
    public void testRestoreInSameRemoteStoreEnabledIndex() throws IOException {
        try (Stream<Path> files = Files.list(indexShard.shardPath().resolveTranslog())) {
        final int numDocsInIndex2 = 20;
        final int numDocsInIndex2 = 20;
                } catch (Exception e) {}
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, newRemoteStoreRepo)
            SnapshotRestoreException.class,
        assertTrue(restoreSnapshotResponse2.getRestoreInfo().failedShards() == 0);
        String snapshotRepoName = "test-create-snapshot-repo";
        PlainActionFuture<RepositoryData> repositoryDataPlainActionFuture = new PlainActionFuture<>();
        logger.info("--> snapshot");
    }
        IndexShard indexShard = getIndexShard(primaryNodeName(indexName1), indexName1);
                    .cluster()
        RestoreSnapshotResponse restoreSnapshotResponse1 = client().admin()
        }
        enableV2Thread.start();
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
            .setIndices(indexName1)
    }
        client().admin().indices().close(Requests.closeIndexRequest(indexName1)).get();
        assertEquals(restoreSnapshotResponse1.status(), RestStatus.ACCEPTED);
        indexDocuments(client, indexName1, numDocsInIndex1);
        assertEquals(deleteResponse.getResult(), DocWriteResponse.Result.DELETED);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(indexName1)));
                internalCluster().nonClusterManagerClient()
        assertThat(snapshotInfo.snapshotId().getName(), equalTo(snapshotName1));
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);
import org.opensearch.repositories.fs.FsRepository;
        Settings indexSettings = getIndexSettings(1, 0).build();
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, newRemoteStoreRepo)
        final int numDocsInIndex1 = 10;
        createIndex(indexName2, indexSettings);
        ensureStableCluster(3);
        client().admin()
        RestoreSnapshotResponse restoreSnapshotResponse1 = client().admin()
        indexDocuments(client(), indexName1, numDocsInIndex1);
                .setWaitForCompletion(false)
        indexDocuments(client, index, numDocsInIndex, numDocsInIndex + randomIntBetween(2, 5));
        ensureGreen(indexName1, indexName2);
        indexingThread.start();
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
        flushAndRefresh(indexName1);
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, enableShallowCopy));
import org.opensearch.repositories.blobstore.BlobStoreRepository;
            assertEquals(pathHashAlgorithm.name(), remoteCustomData.get(PathHashAlgorithm.NAME));
        assertThat(snapshotInfo1.state(), equalTo(SnapshotState.SUCCESS));
        String indexName1 = "testindex1";
        createIndex(indexName2, indexSettings2);
        assertThat(snapshotInfo1.successfulShards(), equalTo(snapshotInfo1.totalShards()));
        assertDocsPresentInIndex(client(), restoredIndexName1, numDocsInIndex1);
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
            );
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
        assertEquals(0, recoveryState.getShardId().getId());
            .prepareCreateSnapshot(snapshotRepoName, snapshotName1)
            snapshotName2,
        if (snapshotFailed.get()) {
        assertTrue(exception.getMessage().contains("cannot remove setting [index.remote_store.segment.repository] on restore"));
        String primary = internalCluster().startDataAndWarmNodes(1).get(0);
        );
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        assertTrue(recoveryState.getIndex().recoveredBytes() > 0L);
            RemoteStorePinnedTimestampService.class,
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        exception = expectThrows(
        // deleting data for restoredIndexName1 and restoring from remote store.
import java.util.ArrayList;
        assertTrue(exception.getMessage().contains("cannot remove setting [index.remote_store.segment.repository]" + " on restore"));
                .setWaitForCompletion(false)
        exception = expectThrows(
        indexDocuments(client, indexName2, numDocsInIndex2);
        // try index restore with index.remote_store.segment.repository and index.remote_store.translog.repository ignored
        Settings numberOfReplicasSettings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build();
import org.opensearch.test.InternalTestCluster;
        logger.info("Snapshot Path [{}]", absolutePath1);
        snapshotThread.start();
        int numDocsInIndex1 = randomIntBetween(2, 5);
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "300s")
        // try index restore with index.remote_store.translog.repository ignored
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        Path remoteTranslogMetadataPath = Path.of(remoteRepoPath + "/" + path);
                .setRenamePattern(index)
        CreateSnapshotResponse createSnapshotResponse2 = client().admin()
        String snapshotRepoName = "test-create-snapshot-repo";
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        });
        String indexName1 = "testindex1";
        snapshotThread.join();
            try {
        Path segmentMetadataPath = Path.of(remoteRepoPath + "/" + path);
    }
            client().admin().cluster().prepareCreateSnapshot(snapshotRepoName, snapshotName).setWaitForCompletion(true).get();
        indexDocuments(client, indexName1, numDocsInIndex1);
        Settings indexSettings = getIndexSettings(20, 0).build();
        final int numDocsInIndex1 = 10;
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
            assertTrue(translogMetadata.count() > 0);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
                .setRenamePattern(index)
        assertFalse(indexExists(indexName1));
                    logger.info("Snapshot completed {}", snapshotName);
 *
        path = getShardLevelBlobPath(client, idx, new BlobPath(), "0", TRANSLOG, DATA, translogPathFixedPrefix).buildAsString();
        String restoredIndexName1 = indexName1 + "-restored";
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.segment.repository]" + " on restore"));
        waitUntil(() -> {
        String indexName2 = "testindex2";
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
import org.opensearch.core.common.unit.ByteSizeValue;
        assertEquals(RecoveryState.Stage.DONE, recoveryState.getStage());
        indexDocuments(client, indexName1, 10);
        indexDocuments(client, index, numDocsInIndex);
            } catch (Exception e) {
        logger.info("Snapshot Path [{}]", absolutePath1);
        Map<String, String> remoteCustomData = state.metadata().index(index).getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY);
            SnapshotRestoreException.class,
import java.util.List;
        // Re-initialize client to make sure we are not using client from stopped node.
                snapshotFailed.set(true);
        ensureYellowAndNoInitializingShards(indexName1);
        assertTrue(recoveryState.getIndex().recoveredFileCount() > 0);
            .setRenameReplacement(restoredIndexName2)
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
                .setIndexSettings(multipleRemoteStoreIndexSettings)
    public void testCreateSnapshotV2_Orphan_Timestamp_Cleanup() throws Exception {
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
                try {
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
    public void testCreateSnapshotV2WithShallowCopySettingDisabled() throws Exception {
                snapshotV1Response[0] = client().admin()
        internalCluster().ensureAtLeastNumDataNodes(0);
            pinnedTimestamp,
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        assertTrue(recoveryState.getIndex().totalRecoverFiles() > 0);
        String indexName1 = "testindex1";
import java.util.Objects;
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName1, Collections.emptyList());
        indexDocuments(client, indexName1, numDocsInIndex1);
        validatePathType(indexName1, PathType.FIXED);
        });
    public void testClusterManagerFailoverDuringSnapshotCreation() throws Exception {
        }
        String indexName2 = "testindex2";
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        assertThat(snapshotInfo1.state(), equalTo(SnapshotState.SUCCESS));
        SnapshotInfo snapshotInfo = snapshotInfoRef.get();
        Settings.Builder settings = Settings.builder()
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        Path location2 = PathUtils.get(String.join("/", pathTokens));
    public void testRestoreShallowSnapshotRepository() throws ExecutionException, InterruptedException {
        internalCluster().startDataAndWarmNodes(1);
            () -> client().admin()
            .setRenameReplacement(restoredIndexName1version2)
        assertThat(snapshotInfo.getPinnedTimestamp(), greaterThan(0L));
        assertEquals(1, recoveryResponse.getSuccessfulShards());
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        assertThat(snapshotInfo1.successfulShards(), greaterThan(0));
        assertTrue(exception.getMessage().contains("cannot remove setting [index.remote_store.translog.repository] on restore"));
            .setRenamePattern(indexName1)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        String indexName1 = "testindex1";
    }
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        String restoredIndexName2 = indexName2 + "-restored";
        // try index restore with index.remote_store.segment.repository ignored
        pathTokens = absolutePath2.toString().split("/");
        settings = Settings.builder()
                    String snapshotName = "snapshot-concurrent-" + snapshotIndex;
        assertThat(snapshotInfo1.successfulShards(), greaterThan(0));
        Settings indexSettings2 = getIndexSettings(15, 0).build();
        assertTrue(recoveryState.getPrimary());
            .put(super.nodeSettings(nodeOrdinal))
            .setRenameReplacement(restoredIndexName1)
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);
        RestoreSnapshotResponse restoreSnapshotResponse1 = client.admin()
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        createIndex(indexName1, indexSettings);
        indexDocuments(client, indexName2, numDocsInIndex2);
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
        assertThat(snapshotInfo2.state(), equalTo(SnapshotState.SUCCESS));
        );
        final int numDocsInIndex2 = 20;
        exception = expectThrows(
            snapshotRepoName,
    public static Collection<Object[]> parameters() {
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
            assertTrue(translogData.count() > 0);
            indexDocuments(client, "index" + i, 15);
     * In this test, we validate presence of remote_store custom data in index metadata for standard index creation and
        );
        ensureStableCluster(4, internalCluster().getClusterManagerName());
        AtomicLong totalSnaps = new AtomicLong();
            int snapshotIndex = i;
        String indexName1 = "testindex1";
import org.opensearch.common.SuppressForbidden;
        createIndex(indexName1, indexSettings);
    }
        createRepository(snapshotRepoName, "fs", getRepositorySettings(location, basePath, true));
        assertTrue(repositoryData.getSnapshotIds().contains(snapshotInfo.snapshotId()));
import java.io.IOException;
        String snapshotRepo = "test-restore-snapshot-repo";
    }
        for (int i = 0; i < numOfDocs; i++) {
            SnapshotRestoreException.class,
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(indexName1).restoreAllShards(false), PlainActionFuture.newFuture());
        Path location2 = PathUtils.get(String.join("/", pathTokens));
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1);
            .cluster()
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        Settings indexSettings = getIndexSettings(20, 0).build();
        RestoreSnapshotResponse restoreSnapshotResponse2 = client.admin()
        // Create a snapshot while indexing is ongoing
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
    public void testRemoteStoreCustomDataOnIndexCreationAndRestore() {
            .setWaitForCompletion(false)
        Thread enableV2Thread = new Thread(() -> {
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1 + 2);
import static org.opensearch.snapshots.SnapshotsService.getPinningEntity;
        assertBusy(() -> {
        indexDocuments(client, indexName2, numDocsInIndex2);
        assertThat(snapshotInfo.getPinnedTimestamp(), equalTo(0L));
        client.admin()
            new ArrayList<>(Arrays.asList(indexName1, indexName2))
        ensureGreen(restoredIndexName1version1);
            .setRenamePattern(indexName1)
        SnapshotInfo snapshotInfo1 = createSnapshot(
        Arrays.copyOf(pathTokens, pathTokens.length - 1);
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        ensureGreen(restoredIndexName1);
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1 + 2);
            } catch (Exception e) {
        Settings indexSettings = getIndexSettings(1, 0).build();
import org.opensearch.snapshots.SnapshotInfo;
            Stream<Path> segmentData = Files.list(segmentDataPath);
        Settings indexSettings = getIndexSettings(20, 0).build();
        ensureGreen(indexName1);
                .setRenameReplacement(restoredIndex)
        ensureGreen(restoredIndexName1, restoredIndexName2);
            .setRenamePattern(indexName1)
        ensureGreen(indexName1);
import static org.hamcrest.Matchers.equalTo;
