        snapshotThread.join();  
        String indexName2 = "testindex2";
        // Will create full copy snapshot if `REMOTE_STORE_INDEX_SHALLOW_COPY` is false but `SHALLOW_SNAPSHOT_V2` is true  
                .setRenameReplacement(restoredIndex)
        logger.info("Snapshot Path [{}]", absolutePath1);
        assertEquals(snapshotInfo.totalShards(), snapshotInfo.successfulShards());
            .get()
        CreateSnapshotResponse createSnapshotResponse2 = client().admin()
        // indexing some new docs and validating  
        SnapshotRestoreException exception = expectThrows(
        SnapshotInfo snapshotInfo1 = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(Arrays.asList(indexName1)));
        // indexing some new docs and validating
 *
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));  
        String indexName2 = "testindex2";
        forceSyncPinnedTimestamps();
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);  
        client.admin()  
        Path absolutePath1 = randomRepoPath().toAbsolutePath();  
        ensureGreen(indexName1);  
        // enable shallow_snapshot_v2
        ensureGreen(indexName1, indexName2);  
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        assertEquals(RemoteStorePinnedTimestampService.getPinnedEntities().size(), 1);
        client().admin().cluster().prepareCreateSnapshot(snapshotRepoName, "snapshot-cleanup-timestamp").setWaitForCompletion(true).get();
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        validatePathType(indexName1, PathType.FIXED);
        );  
    }
            .setRenameReplacement(restoredIndexName2)
        RestoreSnapshotResponse restoreSnapshotResponse2 = client.admin()
        // for all nodes , run forceSyncPinnedTimestamps()
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepo, snapshotName1, new ArrayList<>(List.of(index)));
        ensureStableCluster(3);
                PlainActionFuture.newFuture()
        assertThat(snapshotInfo1.successfulShards(), greaterThan(0));
        pathTokens = absolutePath2.toString().split("/");  
import org.opensearch.core.action.ActionListener;
        // Wait for a bit to let some documents be indexed
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        // Create a separate thread to create the first snapshot  
            .cluster()  
                .setIndices(index)
        client(clusterManagerNode).admin()  
        createIndex(indexName2, indexSettings);  
        ensureGreen(indexName1);  
        ensureGreen(indexName1, indexName2);
        String snapshotName1 = "test-create-snapshot-v1";  
    }
        Path location = PathUtils.get(String.join("/", pathTokens));
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()  
        Repository repository = internalCluster().getInstance(RepositoriesService.class).repository(snapshotRepoName);
        IndexShard indexShard = getIndexShard(primaryNodeName(indexName1), indexName1);  
import org.opensearch.snapshots.SnapshotInfo;
        Path absolutePath2 = randomRepoPath().toAbsolutePath();  
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        Settings indexSettings2 = getIndexSettings(15, 0).build();
        String remoteStoreRepoNameUpdated = "test-rs-repo-updated" + TEST_REMOTE_STORE_REPO_SUFFIX;  
                } catch (Exception e) {}
        assertThat(snapshotInfo.getPinnedTimestamp(), greaterThan(0L));
        String remoteStoreRepoNameUpdated = "test-rs-repo-updated" + TEST_REMOTE_STORE_REPO_SUFFIX;
            .prepareCreateSnapshot(snapshotRepoName, snapshotName1)  
        SnapshotInfo snapshotInfo = snapshotInfoRef.get();
                    .cluster()  
        Client client = client();  
        createIndex(indexName3, indexSettings);
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)  
        ensureGreen(indexName1);  
        internalCluster().startDataAndWarmNodes(1);
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
            GetSnapshotsResponse response2 = client().admin().cluster().getSnapshots(request).actionGet();  
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        String snapshotRepoName = "test-restore-snapshot-repo";  
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        final int numDocsInIndex2 = 20;  
            .setIndices(indexName1)
    public void testRestoreShallowSnapshotIndexAfterSnapshot() throws ExecutionException, InterruptedException {  
        assertDocsPresentInIndex(client(), indexName1, numDocsInIndex1);
        ensureGreen(indexName2);
        snapshotInfo = createSnapshot(snapshotRepoName, snapshotName2, new ArrayList<>(List.of(indexName2)));  
                .setIgnoreIndexSettings(
                            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        });
        assertThat(snapshotInfo1.state(), equalTo(SnapshotState.SUCCESS));
        logger.info("Snapshot Path [{}]", absolutePath1);
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)  
        final int numDocsInIndex1 = 10;  
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);
        Client client = client();
 * The OpenSearch Contributors require contributions made to  
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
        Path absolutePath1 = randomRepoPath().toAbsolutePath();  
        internalCluster().startClusterManagerOnlyNode();  
            return RemoteStorePinnedTimestampService.getPinnedEntities().size() == totalSnaps.intValue();  
        indexDocuments(client, indexName1, numDocsInIndex1 + 2, numDocsInIndex1 + 4);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();  
            logger.info("checking for index " + indexName + " with docId" + id);  
        Path absolutePath1 = randomRepoPath().toAbsolutePath();  
        Settings.Builder settings = Settings.builder()
        assertThat(snapshotInfo.getPinnedTimestamp(), greaterThan(0L));
                .setIndexSettings(remoteStoreSegmentIndexSettings)
        assertTrue(recoveryState.getIndex().totalRecoverBytes() > 0L);
        }
        indexDocuments(client, index, numDocsInIndex);
import org.opensearch.action.DocWriteResponse;
        Client client = client();  
    }
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        RecoveryResponse recoveryResponse = client().admin().indices().prepareRecoveries(restoredIndexName1).execute().actionGet();  
import org.opensearch.indices.IndicesService;  
        createIndex(indexName1, indexSettings);
import org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm;
                );  
            () -> client().admin()  
        createIndex(indexName2, indexSettings2);
            .prepareUpdateSettings()  
    protected Settings nodeSettings(int nodeOrdinal) {
        Settings indexSettings2 = getIndexSettings(15, 0).build();  
                .setRenamePattern(index)
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);  
            try {
                .setIndexSettings(remoteStoreTranslogIndexSettings)
        logger.info("--> snapshot");
        String snapshotRepo = "test-restore-snapshot-repo";
        ensureGreen(indexName1, indexName2);
                            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true)
        Settings indexSettings2 = getIndexSettings(15, 0).build();  
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        final int numDocsInIndex1 = 10;  
import org.opensearch.action.LatchedActionListener;
        createIndex(indexName1, indexSettings);  
import java.util.concurrent.atomic.AtomicBoolean;  
            .setWaitForCompletion(true)  
        logger.info("--> snapshot");
        assertEquals(snapshotInfo.totalShards(), snapshotInfo.successfulShards());  
        repository.getRepositoryData(repositoryDataPlainActionFuture);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import org.opensearch.indices.recovery.RecoveryState;
        String snapshotName2 = "test-create-snapshot-v2";
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());  
                .setRenameReplacement(restoredIndex)
        createIndex(indexName2, indexSettings2);
                snapshotV1Response[0] = client().admin()  
import java.io.IOException;
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName2)
        assertFalse(indexExists(indexName1));
        }
            .get();  
            () -> client().admin()  
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
                .setRenamePattern(index)  
        int numDocsInIndex1 = randomIntBetween(2, 5);  
        exception = expectThrows(
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        assertThat(recoveryState.getIndex().recoveredFilesPercent(), lessThanOrEqualTo(100.0f));
            .put(super.indexSettings())  
        Settings indexSettings = getIndexSettings(20, 0).build();  
            .setWaitForCompletion(false)
    }
            .cluster()
        thread.join();
                assertThrows(  
    }  
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(Arrays.asList(indexName1, indexName2)));  
        String indexName1 = "testindex1";  
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, newRemoteStoreRepo)
            assertTrue(translogMetadata.count() > 0);
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
                    client().admin().cluster().prepareCreateSnapshot(snapshotRepoName, snapshotName).setWaitForCompletion(true).get();  
        forceSyncPinnedTimestamps();
        assertThat(snapshotInfo1.successfulShards(), equalTo(snapshotInfo1.totalShards()));  
        String snapshotName1 = "test-create-snapshot1";
        String snapshotName1 = "test-restore-snapshot1";
        });
        assertThat(snapshotInfo1.state(), equalTo(SnapshotState.SUCCESS));  
        createIndex(indexName2, indexSettings2);
            .cluster()  
        final int numDocsInIndex1 = 10;
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, newRemoteStoreRepo)  
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());  
        int concurrentSnapshots = 5;
        Settings indexSettings2 = getIndexSettings(15, 0).build();
        assertDocsPresentInIndex(client(), restoredIndexName1, numDocsInIndex1);
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.segment.repository]" + " on restore"));
        internalCluster().startClusterManagerOnlyNodes(3, pinnedTimestampSettings());  
                    .get();
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        Arrays.copyOf(pathTokens, pathTokens.length - 1);
import org.opensearch.common.settings.Settings;
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        assertThat(snapshotInfo2.state(), equalTo(SnapshotState.SUCCESS));  
            .setRenamePattern(indexName1)
        Settings indexSettings = getIndexSettings(1, 0).build();
        SnapshotInfo snapshotInfo1 = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(List.of(indexName1)));  
        ensureGreen(indexName1, indexName2);
            .setWaitForCompletion(true)
        createIndex(indexName2, indexSettings2);  
        assertThat(repositoryData.getSnapshotIds().size(), greaterThanOrEqualTo(2));  
        Arrays.copyOf(pathTokens, pathTokens.length - 1);  
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        Settings numberOfReplicasSettings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1).build();
            .setIndices(indexName2)  
            assertTrue("doc with id" + id + " is not present for index " + indexName, client.prepareGet(indexName, id).get().isExists());
        SnapshotInfo snapshotInfo1 = createSnapshot(  
        try (Stream<Path> files = Files.list(indexShard.shardPath().resolveTranslog())) {
                .setIndices(index)  
import java.util.Collections;
        boolean enableShallowCopy = randomBoolean();  
            try {
                .get()  
        );
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)  
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1);  
    public RemoteRestoreSnapshotIT(Settings nodeSettings) {  
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);  
import org.opensearch.index.IndexService;  
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.segment.repository]" + " on restore"));
        Thread thread = new Thread(() -> {
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
        updateRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, false));
        createIndex(indexName1, indexSettings);  
        indexDocuments(client, indexName2, numDocsInIndex2);  
                    IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY,
        pathTokens = absolutePath2.toString().split("/");
        }
                    .get();
        String restoredIndexName1 = indexName1 + "-restored";
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)  
        Settings.Builder settings = Settings.builder()
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;  
        createV1SnapshotThread.start();
        ensureRed(restoredIndexName1);
    }
        client().admin().indices().close(Requests.closeIndexRequest(indexName1)).get();  
        // Validate that snapshot is present in repository data
        refresh(indexName1);
import org.opensearch.common.blobstore.BlobPath;
        List<Thread> threads = new ArrayList<>();
        // Prepare threads for concurrent snapshot creation
            .setWaitForCompletion(false)
            } catch (Exception ignored) {}  
        indexingThread.start();  
        indexDocuments(client, indexName1, randomIntBetween(5, 10));
        ensureGreen(indexName1);
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        enableV2Thread.join();
        Settings remoteStoreSegmentIndexSettings = Settings.builder()  
    }
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        PlainActionFuture<RepositoryData> repositoryDataPlainActionFuture = new PlainActionFuture<>();  
        Settings.Builder settings = Settings.builder()
            });  
        assertThat(snapshotInfo1.state(), equalTo(SnapshotState.SUCCESS));
            .setSourceRemoteStoreRepository(remoteStoreRepoNameUpdated)  
        String indexName2 = "testindex2";
        createIndex(indexName2, indexSettings2);
            .cluster()  
        // Validate that we have greater one snapshot has been created
        }
            createIndex("index" + i, indexSettings);  
            .setWaitForCompletion(true)
        ensureGreen(restoredIndexName1version2);
            .prepareCreateSnapshot(snapshotRepoName, snapshotName2)
            snapshotName2,  
        forceSyncPinnedTimestamps();  
        String snapshotName1 = "test-create-snapshot1";
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        Settings indexSettings2 = getIndexSettings(1, 0).build();
                .setIgnoreIndexSettings(SETTING_REMOTE_STORE_ENABLED)
        Thread.sleep(100);
                CreateSnapshotResponse createSnapshotResponse = client().admin()
        String snapshotName1 = "test-restore-snapshot1";
        String indexName2 = "testindex2";  
        Path segmentMetadataPath = Path.of(remoteRepoPath + "/" + path);
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);  
        indexDocuments(client, indexName1, numDocsInIndex1);
        assertThat(snapshotInfo2.successfulShards(), equalTo(snapshotInfo2.totalShards()));
        assertTrue(repositoryData.getSnapshotIds().contains(snapshotInfo.snapshotId()));
import org.opensearch.cluster.ClusterState;  
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)  
            assertTrue(translogData.count() > 0);  
        internalCluster().startDataAndWarmNodes(1);  
        ensureGreen(indexName1);  
        final int numDocsInIndex2 = 20;  
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
        Client client = client();
                .cluster()
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
            latchedActionListener
        final int numDocsInIndex1 = 10;
        Settings indexSettings = getIndexSettings(1, 0).build();
                }
            .cluster()  
        assertThat(snapshotInfo.snapshotId().getName(), equalTo(snapshotName2));
        RecoveryState recoveryState = recoveryResponse.shardRecoveryStates().get(restoredIndexName1).get(0);
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        assertEquals(restoreSnapshotResponse1.status(), RestStatus.ACCEPTED);  
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())  
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        ensureRed(indexName1);  
                throw new RuntimeException(e);  
                )
        createIndex(indexName2, indexSettings2);
        final int numDocsInIndex2 = 20;
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());  
        logger.info("Snapshot Path [{}]", absolutePath1);
        Path location2 = PathUtils.get(String.join("/", pathTokens));  
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1 + 2);  
        createIndex(indexName2, indexSettings2);
            .prepareUpdateSettings()
            public void onFailure(Exception e) {}
        for (Thread thread : threads) {  
import org.opensearch.repositories.fs.FsRepository;
        // Sleeping 10 sec for earlier created snapshot to complete runNextQueuedOperation and be ready for next snapshot
            .put(super.nodeSettings(nodeOrdinal))
        String snapshotRepoName = "test-create-snapshot-repo";
    /**  
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                .setIndices(index)
        String snapshotName1 = "test-restore-snapshot1";
        logger.info("Snapshot Path [{}]", absolutePath1);
        indexDocuments(client, indexName1, extraNumDocsInIndex1);  
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
        ensureGreen(indexName1, restoredIndexName2);  
        PlainActionFuture<RepositoryData> repositoryDataPlainActionFuture = new PlainActionFuture<>();  
        thread.start();
                    .setClusterManagerNodeTimeout(TimeValue.timeValueSeconds(60))  
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName1)).get());  
        ensureYellowAndNoInitializingShards(restoredIndexName1);  
        createIndex(indexName1, indexSettings);  
        final int numDocsInIndex2 = 20;
            snapshotRepoName,
            new ArrayList<>(Arrays.asList(indexName1, indexName2))  
        exception = expectThrows(
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        latch.await();
        internalCluster().startDataAndWarmNodes(2);
                    logger.info("Snapshot completed {}", snapshotName);
    }
        Settings.Builder settings = Settings.builder()  
            .cluster()
        indexDocuments(client, indexName1, numDocsInIndex1);
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
        indexDocuments(client, indexName2, numDocsInIndex2);
            .prepareUpdateSettings()
            threads.add(thread);
            .cluster()  
    public void testRestoreShallowSnapshotRepository() throws ExecutionException, InterruptedException {
import java.util.concurrent.CountDownLatch;  
        createIndex(indexName1, indexSettings);
                .setRenameReplacement(restoredIndex)
        final int numDocsInIndex2 = 20;
        assertTrue(recoveryState.getIndex().recoveredFileCount() > 0);  
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        assertDocsPresentInIndex(client(), indexName1, numDocsInIndex1);
        assertThat(snapshotInfo2.successfulShards(), greaterThan(0));  
        ensureGreen(indexName1, indexName2);
        indexDocuments(client(), indexName1, numDocsInIndex1);
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        ensureGreen(indexName1);  
        indexDocuments(client, indexName1, numDocsInIndex1);
        logger.info("--> snapshot");
        assertEquals(1, recoveryResponse.shardRecoveryStates().get(restoredIndexName1).size());  
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);
import java.util.concurrent.atomic.AtomicLong;
        Settings indexSettings2 = getIndexSettings(15, 0).build();  
            .cluster()
    }  
                .setRenamePattern(index)
import org.opensearch.indices.RemoteStoreSettings;
                    )
        ensureGreen(indexName1);
        assertTrue(snapshotInfo.indices().contains(indexName1));
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        SnapshotInfo snapshotInfo = createSnapshotResponse2.getSnapshotInfo();  
        assertThat(snapshotInfo1.successfulShards(), equalTo(snapshotInfo1.totalShards()));  
        String snapshotRepoName = "test-restore-snapshot-repo";  
            client().admin().cluster().prepareCreateSnapshot(snapshotRepoName, snapshotName).setWaitForCompletion(true).get();
        final AtomicBoolean snapshotFailed = new AtomicBoolean(false);  
        String path = getShardLevelBlobPath(client, idx, new BlobPath(), "0", TRANSLOG, METADATA, translogPathFixedPrefix).buildAsString();
            .cluster()  
            assertTrue(segmentMetadata.count() > 0);
        // start all threads  
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));  
        RestoreSnapshotResponse restoreSnapshotResponse2 = client.admin()
        assertTrue(exception.getMessage().contains("cannot remove setting [index.remote_store.enabled] on restore"));
    }
        assertFalse(indexExists(indexName1));
            .setRenameReplacement(restoredIndexName1)
        final int numDocsInIndex1 = 10;
        ensureGreen(indexName1);  
        Settings indexSettings = getIndexSettings(20, 0).build();
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.SEGMENTS;
        );  
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));  
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;  
        assertThat(snapshotInfo.snapshotId().getName(), equalTo(snapshotName1));
                .setWaitForCompletion(false)  
public class RemoteRestoreSnapshotIT extends RemoteSnapshotIT {
        SnapshotInfo snapshotInfo2 = createSnapshot(
        String indexName2 = "testindex2";  
        });
                    IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY  
            );
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())  
        assertThat(snapshotInfo1.successfulShards(), greaterThan(0));  
            .setRenameReplacement(restoredIndexName1)
        assertRemoteSegmentsAndTranslogUploaded(restoredIndexName2);
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());  
        final AtomicReference<SnapshotInfo> snapshotInfoRef = new AtomicReference<>();
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, node);  
        ensureStableCluster(4, internalCluster().getClusterManagerName());  
        Client client = client();  
        final int numDocsInIndex2 = 20;
        indexDocuments(client, indexName2, numDocsInIndex2);
            snapshotRepoName,
            .restoreRemoteStore(
        assertEquals(RecoveryState.Stage.DONE, recoveryState.getStage());  
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));  
        }
        indexDocuments(client, indexName2, numDocsInIndex2);
        String newRemoteStoreRepo = "test-new-rs-repo";  
        createIndex(indexName1, indexSettings);
        assertEquals(RestStatus.ACCEPTED, restoreSnapshotResponse.status());
        assertEquals(1, recoveryResponse.getSuccessfulShards());
        String indexName3 = "testindex3";
        RepositoryData repositoryData = repositoryDataPlainActionFuture.get();
        assertDocsPresentInIndex(client, indexName1, numDocsInIndex1 + 4);
            .get();  
                .setWaitForCompletion(false)
        Path absolutePath1 = randomRepoPath().toAbsolutePath();  
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        logger.info("--> snapshot");  
        String snapshotRepoName = "test-create-snapshot-repo";
    }
            .setWaitForCompletion(false)
        Settings indexSettings = getIndexSettings(20, 0).build();
        for (int i = 0; i < numOfDocs; i++) {
        );
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), false);  
        Settings multipleRemoteStoreIndexSettings = Settings.builder()
                    .setWaitForCompletion(true)  
        Thread indexingThread = new Thread(() -> {
            .setIndices(indexName2)
    void assertRemoteSegmentsAndTranslogUploaded(String idx) throws IOException {
                .setRenameReplacement(restoredIndex)  
import org.opensearch.index.shard.IndexShard;
        createIndex(indexName3, indexSettings);
        Path remoteTranslogDataPath = Path.of(remoteRepoPath + "/" + path);
            public void onResponse(Void unused) {}
        String primary = internalCluster().startDataAndWarmNodes(1).get(0);
                .get()
        createV1SnapshotThread.join();
            try {
        String snapshotName1 = "test-create-snapshot1";  
        String snapshotName1 = "test-restore-snapshot1";
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
            .setWaitForCompletion(false)
        internalCluster().stopCurrentClusterManagerNode();  
        createIndex(indexName1, indexSettings);
        // Validating that custom data has not changed for indexes which were created before the cluster setting got updated
        Client client = client();  
            .setTransientSettings(Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), PathType.FIXED))
        Settings indexSettings = getIndexSettings(1, 0).build();  
        assertTrue(snapshotInfo.indices().contains("test-index-load"));  
        assertAcked(client().admin().indices().prepareClose(indexName1));  
        assertTrue(snapshotInfo.successfulShards() > 0);
            .cluster()
            .get();
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);
    }
        String indexName1 = "testindex1";
                .get()
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())  
        exception = expectThrows(
        String indexName1 = "testindex1";
        logger.info("--> snapshot");  
import org.opensearch.index.IndexSettings;
        internalCluster().startDataAndWarmNodes(1);
        });  
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())  
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.TRANSLOG;
        createIndex(indexName1, indexSettings);  
            thread.start();
        assertThat(snapshotInfo.getPinnedTimestamp(), equalTo(0L));
        SnapshotInfo snapshotInfo1 = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(List.of(indexName1)));
        updateRepository(snapshotRepo, "fs", getRepositorySettings(absolutePath1, false));
        }
            .cluster()
        ensureStableCluster(3);
    }
        // Close index 2  
            .status();  
import org.opensearch.core.common.unit.ByteSizeValue;  
        String basePath = pathTokens[pathTokens.length - 1];
            .cluster()
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));  
import java.util.stream.Stream;
        Repository repository = internalCluster().getInstance(RepositoriesService.class).repository(snapshotRepoName);  
        assertEquals(1, recoveryResponse.getTotalShards());
        Settings indexSettings = getIndexSettings(1, 0).build();
        assertTrue(recoveryState.getIndex().totalFileCount() > 0);
        final int numDocsInIndex2 = 20;
            this.forceSyncPinnedTimestamps();
                // Start snapshot creation  
        }, 30, TimeUnit.SECONDS);
        super(nodeSettings);
            () -> client().admin()  
        String snapshotName2 = "test-restore-snapshot2";
            assertThat(response2.getSnapshots().size(), greaterThanOrEqualTo(1));
    public void testInvalidRestoreRequestScenarios() throws Exception {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        Settings indexSettings = getIndexSettings(20, 0).build();
            .get();
import org.opensearch.snapshots.SnapshotRestoreException;  
        String[] pathTokens = absolutePath1.toString().split("/");
        indexDocuments(client, indexName1, numDocsInIndex1);  
        createIndex(index, indexSettings);
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        indexDocuments(client, indexName1, numDocsInIndex1);
        Settings indexSettings2 = getIndexSettings(15, 0).build();
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.enabled]" + " on restore"));  
                .setIgnoreIndexSettings(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY)
            .setWaitForCompletion(false)
        indexDocuments(client, indexName3, 10);  
        RepositoryData repositoryData = repositoryDataPlainActionFuture.get();
        assertThat(snapshotInfo1.successfulShards(), greaterThan(0));
        ensureGreen(indexName1, indexName2);  
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));  
    }  
        // Wait for the cluster to elect a new Cluster Manager and stabilize
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();  
        // indexing some new docs and validating
        ensureGreen(indexName1);
    public void testMixedSnapshotCreationWithV2RepositorySetting() throws Exception {  
        repository.getRepositoryData(repositoryDataPlainActionFuture);
            forceSyncPinnedTimestamps();
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        }  
        // Create a snapshot while indexing is ongoing
        indexDocuments(client(), indexName1, numDocsInIndex1);  
        for (int i = 0; i < concurrentSnapshots; i++) {
import org.opensearch.test.OpenSearchIntegTestCase;  
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
import org.opensearch.repositories.Repository;
        Settings.Builder settings = Settings.builder()  
import org.opensearch.test.InternalTestCluster;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
        );
import org.opensearch.common.SuppressForbidden;
        createIndex(indexName1, indexSettings);
        indexDocuments(client, indexName1, numDocsInIndex1);
                .setIgnoreIndexSettings(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY)
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);  
import org.opensearch.node.Node;
            .setRenameReplacement(restoredIndexName1version2)
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));  
        String indexName1 = "testindex1";
        String snapshotRepoName = "test-restore-snapshot-repo";
        ensureGreen(restoredIndexName1);
            .get();
            indexDocuments(client, "index" + i, 15);
        final CreateSnapshotResponse[] snapshotV1Response = new CreateSnapshotResponse[1];
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
        final CountDownLatch latch = new CountDownLatch(1);
            .get();
        restoreSnapshotResponse = client.admin()
        Path location = PathUtils.get(String.join("/", pathTokens));
            .cluster()
            .setSourceRemoteStoreRepository(remoteStoreRepoNameUpdated)
        assertEquals(deleteResponse.getResult(), DocWriteResponse.Result.DELETED);
            SnapshotRestoreException.class,
        String indexName2 = "testindex2";
                    .setWaitForCompletion(true)
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(indexName1).restoreAllShards(false), PlainActionFuture.newFuture());
                            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)  
        String indexName1 = "testindex1";
        assertThat(recoveryState.getIndex().time(), greaterThanOrEqualTo(0L));
        final int numDocsInIndex2 = 20;
        ensureGreen(restoredIndexName1version1);
            .setRenamePattern(indexName1)
        indexDocuments(client, indexName3, 10);
        String indexName2 = "testindex2";  
        assertEquals(RestStatus.ACCEPTED, restoreSnapshotResponse.status());  
            IOUtils.deleteFilesIgnoringExceptions(files.collect(Collectors.toList()));
        final int numDocsInIndex2 = 6;
        final Optional<Integer> shardId = indexService.shardIds().stream().findFirst();  
                .cluster()  
            .cluster()  
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
                .setIndexSettings(multipleRemoteStoreIndexSettings)
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        String indexName2 = "testindex2";  
            @Override
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));
import org.opensearch.transport.client.Client;
        repository.getRepositoryData(repositoryDataPlainActionFuture);
        indexDocuments(client, indexName2, 20);
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        createRepository(snapshotRepoName, "fs", getRepositorySettings(location, basePath, true));
        // try index restore with index.remote_store.segment.repository ignored  
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);  
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
            GetSnapshotsRequest request = new GetSnapshotsRequest(snapshotRepoName);
        Settings indexSettings = getIndexSettings(20, 0).build();
        internalCluster().startDataAndWarmNodes(1);  
        String indexName1 = "testindex1";
            .setWaitForCompletion(false)  
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.DATA;  
import java.util.stream.Collectors;  
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));  
                .get()
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
            .get();  
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
        String indexName2 = "testindex2";  
        updateRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, false));  
                throw new RuntimeException(e);
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        ensureGreen(restoredIndexName1);
        ensureGreen(indexName2);  
        return Settings.builder()  
            @Override
        String indexName1 = "testindex1";  
    public void testConcurrentSnapshotV2CreateOperation_MasterChange() throws Exception {
        for (int i = 0; i < 10; i++) {
            SnapshotRestoreException.class,  
        createIndex(indexName1, indexSettings);
        assertAcked(client.admin().indices().prepareClose(restoredIndexName1));
import java.util.concurrent.TimeUnit;
        Client client = client();
import org.opensearch.common.unit.TimeValue;
            logger.info("Exception while creating new-snapshot", e);
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), true).build() }
        settings = Settings.builder()
            () -> client().admin()
                .cluster()
        logger.info("Path 1 [{}]", absolutePath1);
        Client client = client();  
        // Validate that the snapshot was created or handled gracefully
        assertThat(recoveryState.getIndex().recoveredFilesPercent(), greaterThanOrEqualTo(0.0f));
        createRepository(snapshotRepoName, "fs", getRepositorySettings(location, basePath, true));
        logger.info("Path 1 [{}]", absolutePath1);  
            pinnedTimestamp,  
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));  
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
        assertThat(snapshotInfo1.successfulShards(), equalTo(snapshotInfo1.totalShards()));
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        Client client = client();  
            } catch (Exception e) {
        assertNotNull(indexService);
            snapshotRepoName,
import java.util.ArrayList;
        Thread createV1SnapshotThread = new Thread(() -> {
     */  
        createIndex(indexName1, indexSettings);
        ensureYellowAndNoInitializingShards(indexName1);
                .setIndexSettings(remoteStoreIndexSettings)  
     * In this test, we validate presence of remote_store custom data in index metadata for standard index creation and
            .get();
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
            .cluster()
        // try index restore with index.remote_store.segment.repository modified
        internalCluster().startClusterManagerOnlyNode();
        Settings.Builder settings = Settings.builder()
        // Create Snapshot of index 2
        Thread enableV2Thread = new Thread(() -> {  
        String snapshotName2 = "test-create-snapshot2";
        ensureGreen(indexName1);
        enableV2Thread.start();
        ensureGreen(indexName1, indexName2);
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.translog.repository]" + " on restore"));
        createIndex(indexName2, indexSettings2);
            .setWaitForCompletion(false)  
    public void testCreateSnapshotV2() throws Exception {
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, enableShallowCopy));
 * SPDX-License-Identifier: Apache-2.0
        assertThat(snapshotInfo1.state(), equalTo(SnapshotState.SUCCESS));
        String indexName1 = "testindex1";  
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
                    .prepareCreateSnapshot(snapshotRepoName, snapshotName1)  
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
import static org.opensearch.snapshots.SnapshotsService.getPinningEntity;  
        LatchedActionListener<Void> latchedActionListener = new LatchedActionListener<>(new ActionListener<>() {  
import org.opensearch.core.index.Index;
    private void assertDocsPresentInIndex(Client client, String indexName, int numOfDocs) {  
        String snapshotRepoName = "test-create-snapshot-repo";
        assertEquals(2, RemoteStorePinnedTimestampService.getPinnedEntities().size());  
import org.opensearch.cluster.metadata.IndexMetadata;
        // try index restore with index.remote_store.enabled modified  
        Settings indexSettings = Settings.builder()
        assertAcked(client().admin().indices().prepareClose(indexName2));
                    IllegalStateException.class,
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        createIndex(indexName1, indexSettings);
                .setWaitForCompletion(false)  
                .setWaitForCompletion(false)  
        validatePathType(indexName2, PathType.HASHED_PREFIX, PathHashAlgorithm.FNV_1A_COMPOSITE_1);  
        assertEquals(restoreSnapshotResponse2.status(), RestStatus.ACCEPTED);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
            .setRenamePattern(indexName2)
        waitUntil(() -> 1 == RemoteStorePinnedTimestampService.getPinnedEntities().size());  
        createIndex(indexName1, indexSettings);
        indexDocuments(client, indexName2, numDocsInIndex2);  
        Client client = client();
            assertTrue(repositoryData.getSnapshotIds().contains(snapshotInfo.snapshotId()));  
        ensureRed(indexName1);
        assertThat(snapshotInfo1.successfulShards(), greaterThan(0));
        Settings indexSettings2 = getIndexSettings(15, 0).build();
        assertThat(snapshotInfo.getPinnedTimestamp(), greaterThan(0L));
import java.util.concurrent.ExecutionException;
        assertBusy(() -> {
                    .prepareCreateSnapshot(snapshotRepoName, snapshotName1)
            .setTransientSettings(Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), PathType.HASHED_PREFIX))
        // Wait for all threads to complete
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        Client client = client();
        String index = "test-index";
        assertFalse(recoveryState.getIndex().fileDetails().isEmpty());  
        String indexName3 = "testindex3";
        stopNode(clusterManagerNode);  
        );  
                try {
            .setIndices(indexName1)  
        Settings.Builder settings = Settings.builder()
                .cluster()
        String restoredIndexName2 = indexName2 + "-restored";
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName1, Collections.emptyList());
            ensureGreen("index" + i);  
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), false)
import java.util.Collection;  
        internalCluster().startDataAndWarmNodes(1);  
        client().admin()
        Settings indexSettings = getIndexSettings(20, 0).build();  
            .get();
import java.util.Arrays;
        assertThat(snapshotInfo1.state(), equalTo(SnapshotState.SUCCESS));
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        logger.info("Path 2 [{}]", absolutePath2);
        createIndex(indexName1, indexSettings);
        String restoredIndexName1version2 = indexName1 + "-restored-2";
            SnapshotRestoreException.class,
        indexDocuments(client, indexName1, numDocsInIndex1);  
        Arrays.copyOf(pathTokens, pathTokens.length - 1);
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
        Settings indexSettings = getIndexSettings(20, 0).build();
                    .prepareCreateSnapshot(snapshotRepoName, snapshotName)
    public void testCreateSnapshotV2WithShallowCopySettingDisabled() throws Exception {
            .cluster()
        createIndex(indexName1, indexSettings);
        String snapshotName1 = "test-restore-snapshot1";
        assertTrue(exception.getMessage().contains("cannot remove setting [index.remote_store.segment.repository]" + " on restore"));
        assertThat(snapshotInfo2.successfulShards(), greaterThan(0));
        });
                .setIndices(index)
        assertEquals(RestStatus.ACCEPTED, createSnapshotResponseStatus);
        // verify response status if waitForCompletion is not true
        indexDocuments(client, indexName1, 10);
        createIndex(indexName2, indexSettings2);  
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1);  
        }
            .get();
                        snapshotRepoName,  
            try {
        for (Thread thread : threads) {
        assertTrue(recoveryState.getIndex().recoveredBytes() > 0L);  
                .setWaitForCompletion(false)  
        CreateSnapshotResponse createSnapshotResponse2 = client().admin()  
            internalCluster().getClusterManagerName()  
        int extraNumDocsInIndex1 = randomIntBetween(20, 50);
            String id = Integer.toString(i);
        remoteStorePinnedTimestampService.pinTimestamp(
        return shardId.map(indexService::getShard).orElse(null);
        });
    public static Collection<Object[]> parameters() {
            .setRenameReplacement(restoredIndexName1)  
                .setIndices(index)
        ensureGreen(indexName1);  
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        indexDocuments(client, indexName1, numDocsInIndex1);  
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());  
        final int numDocsInIndex = 5;
        Path segmentDataPath = Path.of(remoteRepoPath + "/" + path);  
    public void testRemoteStoreCustomDataOnIndexCreationAndRestore() {
        Settings indexSettings = getIndexSettings(1, 0).build();
        exception = expectThrows(  
        Settings.Builder settings = Settings.builder()
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING;
    }
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
            .build();  
        assertThat(recoveryState.getIndex().recoveredBytesPercent(), lessThanOrEqualTo(100.0f));
        final int numDocsInIndex1 = randomIntBetween(20, 30);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        indexDocuments(client, indexName2, numDocsInIndex2);  
        assertEquals(1, recoveryResponse.shardRecoveryStates().size());
            .cluster()  
        // Create a separate thread to enable shallow_snapshot_v2
        Settings indexSettings = getIndexSettings(20, 0).build();  
                .get()
            Stream<Path> segmentMetadata = Files.list(segmentMetadataPath);
import org.opensearch.core.common.unit.ByteSizeUnit;
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
            .prepareCreateSnapshot(snapshotRepoName, snapshotName1)
            SnapshotRestoreException.class,
        String[] pathTokens = absolutePath1.toString().split("/");
 * this file be licensed under the Apache-2.0 license or a
        indexDocuments(client, indexName2, numDocsInIndex2);
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), false);
            Stream<Path> translogMetadata = Files.list(remoteTranslogMetadataPath);  
        assertNotNull(remoteCustomData);
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        assertTrue(restoreSnapshotResponse2.getRestoreInfo().failedShards() == 0);
            .build();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        }, latch);  
        Repository repository = internalCluster().getInstance(RepositoriesService.class).repository(snapshotRepoName);
        // create an orphan timestamp related to this repo  
        // try index restore with index.remote_store.translog.repository and index.remote_store.segment.repository modified
        final String clusterManagerNode = internalCluster().getClusterManagerName();
        String basePath = pathTokens[pathTokens.length - 1];  
import org.opensearch.core.rest.RestStatus;
    public void testConcurrentV1SnapshotAndV2RepoSettingUpdate() throws Exception {
        Arrays.copyOf(pathTokens, pathTokens.length - 1);
        client = client(clusterManagerNode);
        assertEquals(restoreSnapshotResponse1.status(), RestStatus.ACCEPTED);
        Settings indexSettings2 = getIndexSettings(15, 0).build();
            .setWaitForCompletion(false)
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
            .setRenamePattern(indexName1)
        logger.info("--> snapshot");  
        assertThat(snapshotInfo2.state(), equalTo(SnapshotState.SUCCESS));
            .setIndices(indexName2)  
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
        logger.info("Snapshot Path [{}]", absolutePath1);  
        // ensure populated bytes details
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)  
    }  
        assertRemoteSegmentsAndTranslogUploaded(indexName1);  
            .get();
    private void validatePathType(String index, PathType pathType, @Nullable PathHashAlgorithm pathHashAlgorithm) {
        );
import java.nio.file.Files;
        Settings indexSettings = getIndexSettings(1, 0).build();
        String snapshotRepoName = "test-create-snapshot-repo";  
        String basePath2 = pathTokens[pathTokens.length - 1];  
        Client client = client();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));
        if (snapshotFailed.get()) {  
            .build();
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);  
                snapshotInfoRef.set(createSnapshotResponse.getSnapshotInfo());  
        logger.info("Snapshot Path [{}]", absolutePath1);
        // ensure populated file details  
        RepositoryData repositoryData = repositoryDataPlainActionFuture.get();  
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
        long pinnedTimestamp = System.currentTimeMillis();
        String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(getNodeSettings());
                .setWaitForCompletion(false)  
        assertThat(snapshotInfo2.successfulShards(), greaterThan(0));  
        assertEquals(RecoverySource.Type.SNAPSHOT, recoveryState.getRecoverySource().getType());  
        logger.info("Snapshot Path [{}]", absolutePath1);
        RestoreSnapshotResponse restoreSnapshotResponse1 = client.admin()
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)  
        indexDocuments(client, indexName1, numDocsInIndex1);
        String indexName1 = "testindex1";
        PlainActionFuture<RepositoryData> repositoryDataPlainActionFuture = new PlainActionFuture<>();
        createRepository(snapshotRepo, "fs", getRepositorySettings(absolutePath1, true));
        // Validate that the remote_store custom data is present in index metadata for the created index.  
            .setRenamePattern(indexName2)  
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());  
        for (int i = 0; i < 10; i++) {  
        ensureGreen(index);  
        assertTrue(exception.getMessage().contains("cannot remove setting [index.remote_store.translog.repository] on restore"));
    public void testRemoteRestoreIndexRestoredFromSnapshot() throws IOException, ExecutionException, InterruptedException {
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
            assertEquals(pathHashAlgorithm.name(), remoteCustomData.get(PathHashAlgorithm.NAME));
        ensureGreen(restoredIndexName1);
        indexDocuments(client, restoredIndexName1, numDocsInIndex1, numDocsInIndex1 + 2);
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
                new RestoreRemoteStoreRequest().indices(restoredIndexName1).restoreAllShards(true),  
        RestoreSnapshotResponse restoreSnapshotResponse1 = client().admin()
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);
import java.util.Optional;
                    .get();
        indexDocuments(client, restoredIndexName1, numDocsInIndex1, numDocsInIndex1 + 2);
                .setRenamePattern(index)  
        assertEquals(0, recoveryState.getShardId().getId());
        // Validating that custom data has not changed for testindex2 which was created before the cluster setting got updated
        String restoredIndex = index + "-restored";
        try (
        restoreSnapshotResponse = client.admin()
                            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)  
        assertEquals(deleteResponse.getResult(), DocWriteResponse.Result.DELETED);
        Path absolutePath2 = randomRepoPath().toAbsolutePath();
            .build();  
                        Settings.builder()
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
        SnapshotInfo snapshotInfo1 = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(Arrays.asList(indexName1)));
                .setRenameReplacement(restoredIndex)
        });  
        assertTrue(snapshotInfo.successfulShards() > 0);  
        indexDocuments(client, indexName1, numDocsInIndex1, numDocsInIndex1 + randomIntBetween(2, 5));  
        final int numDocsInIndex1 = 10;
            .cluster()
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
            SnapshotRestoreException.class,
import org.opensearch.snapshots.SnapshotState;
        validatePathType(restoredIndexName1version1, PathType.FIXED);  
import java.nio.file.Path;  
        try {
        Path absolutePath1 = randomRepoPath().toAbsolutePath();  
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
            () -> client().admin()
import static org.hamcrest.Matchers.greaterThan;  
        }  
        if (Objects.nonNull(pathHashAlgorithm)) {
        SnapshotInfo snapshotInfo2 = createSnapshot(  
        ensureGreen(indexName1);
            .setRenameReplacement(restoredIndexName2)
            thread.join();
        }
import org.opensearch.action.support.PlainActionFuture;
        String restoredIndexName1 = indexName1 + "-restored";  
        logger.info("--> snapshot");
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
 */  
    }
        String snapshotRepoName = "test-restore-snapshot-repo";  
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)  
        }
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
                .get()
import org.opensearch.action.delete.DeleteResponse;
    @Override  
            .cluster()
                for (int i = 0; i < 50; i++) {  
        logger.info("Path 2 [{}]", absolutePath2);
        return Arrays.asList(  
        snapshotInfo = createSnapshotResponse2.getSnapshotInfo();  
        Client client = client();  
        internalCluster().startDataAndWarmNodes(2);  
            .build();
 * compatible open source license.
        Thread.sleep(TimeValue.timeValueSeconds(10).seconds());  
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.METADATA;
        String indexName1 = "testindex1";
        String indexName1 = "testindex1";
            SnapshotRestoreException.class,
        assertThat(snapshotInfo.getPinnedTimestamp(), greaterThan(0L));  
        exception = expectThrows(
            return RemoteStorePinnedTimestampService.getPinnedEntities().size() == repositoryData.getSnapshotIds().size();  
/*  
            .setRenamePattern(indexName1)
        final int numDocsInIndex1 = 10;
                .cluster()
    protected IndexShard getIndexShard(String node, String indexName) {
        String snapshotName2 = "test-restore-snapshot2";
            remoteStorePinnedTimestampService.forceSyncPinnedTimestamps();
        createIndex(indexName2, indexSettings2);
import org.opensearch.common.Nullable;  
        indexDocuments(client, indexName1, numDocsInIndex1);  
        internalCluster().startClusterManagerOnlyNode();
            .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, newRemoteStoreRepo)
            snapshotName1,
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
@SuppressForbidden(reason = "Need to fix: https://github.com/opensearch-project/OpenSearch/issues/14324")  
    private void validatePathType(String index, PathType pathType) {  
import org.opensearch.common.util.io.IOUtils;  
        // deleting data for restoredIndexName1 and restoring from remote store.  
            () -> client().admin()  
        ensureGreen(indexName1);
        assertEquals(0, recoveryResponse.getFailedShards());  
        String indexName1 = "testindex1";  
        String basePath2 = pathTokens[pathTokens.length - 1];
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));  
        Path remoteTranslogMetadataPath = Path.of(remoteRepoPath + "/" + path);  
            );  
            totalSnaps.set(response2.getSnapshots().size());
                .setIndices(index)
            assertTrue(repositoryData.getSnapshotIds().isEmpty());
    }
        ensureGreen(restoredIndexName1, restoredIndexName2);
            }
        String indexName2 = "testindex2";  
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, newRemoteStoreRepo)
        final int numDocsInIndex1 = 5;
            int snapshotIndex = i;
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        // Wait for the snapshot thread to complete
        validatePathType(restoredIndexName1version2, PathType.HASHED_PREFIX, PathHashAlgorithm.FNV_1A_COMPOSITE_1);
        indexDocuments(client, indexName1, numDocsInIndex1);  
        client(clusterManagerNode).admin()
    }
        String indexName1 = "testindex1";
        SnapshotInfo snapshotInfo2 = createSnapshot(snapshotRepo, snapshotName2, new ArrayList<>(List.of(index)));
        ensureStableCluster(3, internalCluster().getClusterManagerName());  
        // Update cluster settings to FIXED
        ) {
        assertDocsPresentInIndex(client(), indexName1, numDocsInIndex1);
        }
            Thread thread = new Thread(() -> {  
        RestoreSnapshotResponse restoreSnapshotResponse1 = client().admin()  
            .get();
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
        DeleteResponse deleteResponse = client().prepareDelete(indexName1, "0").execute().actionGet();  
        indexDocuments(client, indexName1, numDocsInIndex1);
    public void testCreateSnapshotV2WithRedIndex() throws Exception {
        String snapshotRepoName = "test-restore-snapshot-repo";
            RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(  
        assertThat(snapshotInfo.getPinnedTimestamp(), equalTo(0L));
            .setIndices(indexName1)
    }  
        ensureGreen(restoredIndexName1);
        assertDocsPresentInIndex(client, restoredIndexName2, numDocsInIndex2);
import org.opensearch.transport.client.Requests;
        String snapshotRepoName = "test-create-snapshot-repo";
        Settings.Builder settings = Settings.builder()  
        Settings remoteStoreTranslogIndexSettings = Settings.builder()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    public void testRestoreOperationsShallowCopyEnabled() throws Exception {
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        // We can't put `waitFor` since we don't have visibility on its completion
        String snapshotName2 = "test-restore-snapshot2";  
        Settings indexSettings2 = getIndexSettings(1, 0).build();  
            () -> client().admin()  
            SnapshotRestoreException.class,
        createRepository(remoteStoreRepoNameUpdated, "fs", remoteRepoPath);
        assertDocsPresentInIndex(client, restoredIndexName2, numDocsInIndex2);
        assertThat(snapshotInfo2.state(), equalTo(SnapshotState.SUCCESS));
        validatePathType(indexName2, PathType.HASHED_PREFIX, PathHashAlgorithm.FNV_1A_COMPOSITE_1);
        );
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
    }
            .get();  
            .cluster()
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        assertDocsPresentInIndex(client, indexName1, numDocsInIndex1);  
        assertEquals(RestStatus.ACCEPTED, restoreSnapshotResponse.status());
        String restoredIndexName1 = indexName1 + "-restored";  
            .cluster()  
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())  
        indexDocuments(client, index, numDocsInIndex, numDocsInIndex + randomIntBetween(2, 5));  
    @ParametersFactory
                .setRenamePattern(index)  
        indexDocuments(client, indexName2, numDocsInIndex2);
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)  
                fail("indexing failed due to exception: " + e.getMessage());
        // indexing some new docs and validating
        );  
        assertThat(snapshotInfo2.successfulShards(), equalTo(snapshotInfo2.totalShards()));
import org.opensearch.repositories.RepositoryData;
        indexDocuments(client, indexName2, numDocsInIndex2);
            .setWaitForCompletion(false)
            } catch (Exception e) {
                .setRenamePattern(index)  
        logger.info("Snapshot Path [{}]", absolutePath1);
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));  
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        indexDocuments(client, restoredIndexName1, numDocsInIndex1, numDocsInIndex1 + 2);
        // indexing some new docs and validating  
            } catch (Exception e) {  
                node
                    .setWaitForCompletion(true)
import org.opensearch.cluster.routing.RecoverySource;
            try {
        assertThat(snapshotInfo1.successfulShards(), equalTo(snapshotInfo1.totalShards()));
        indexDocuments(client, indexName2, numDocsInIndex2);
        final int numDocsInIndex1 = 10;  
            .setRenameReplacement(restoredIndexName1version1)
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1);
        RestoreSnapshotResponse restoreSnapshotResponse2 = client.admin()
        ensureGreen(indexName1, indexName2);
                .setRenameReplacement(restoredIndex)
        Client client = client();
        String primary = internalCluster().startDataAndWarmNodes(1).get(0);
            .get();  
        assertEquals(pathType.name(), remoteCustomData.get(PathType.NAME));  
        Thread snapshotThread = new Thread(() -> {
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());  
                .setIndices(index)
        String snapshotRepoName = "test-create-snapshot-repo";
        flushAndRefresh(indexName1);
        );  
            }
        Settings indexSettings = Settings.builder()
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        indexDocuments(client, indexName1, 10);
                .get()
        Settings indexSettings = getIndexSettings(20, 0).build();  
        internalCluster().ensureAtLeastNumDataNodes(0);
        // deleting data for restoredIndexName1 and restoring from remote store.
            Stream<Path> translogData = Files.list(remoteTranslogDataPath);
        CreateSnapshotResponse createSnapshotResponse2 = client().admin()
        }  
        assertThat(snapshotInfo1.successfulShards(), greaterThan(0));  
        client(clusterManagerNode).admin()
        // try index restore with index.remote_store.enabled ignored  
        client = client(clusterManagerNode);
            new ArrayList<>(Arrays.asList(indexName1, indexName2))  
        assertTrue(restoreSnapshotResponse2.getRestoreInfo().failedShards() == 0);  
        Map<String, String> remoteCustomData = state.metadata().index(index).getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY);
        String indexName1 = "testindex1";
        assertEquals(restoreSnapshotResponse1.status(), RestStatus.ACCEPTED);
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampSettings());
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName1, Collections.emptyList());
        Settings indexSettings2 = getIndexSettings(15, 0).build();
        path = getShardLevelBlobPath(client, idx, new BlobPath(), "0", SEGMENTS, DATA, segmentsPathFixedPrefix).buildAsString();
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName1)
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "300s")
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
            .get();
        indexDocuments(client, indexName1, numDocsInIndex1, numDocsInIndex1 + 2);  
        indexDocuments(client, indexName1, numDocsInIndex1);  
            .prepareCreateSnapshot(snapshotRepoName, snapshotName2)  
        SnapshotInfo snapshotInfo = createSnapshotResponse2.getSnapshotInfo();  
        String indexName2 = "testindex2";  
        createIndex(indexName1, indexSettings);  
                snapshotFailed.set(true);  
import java.util.Objects;
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        ensureGreen(restoredIndexName1);
import org.opensearch.index.remote.RemoteStoreEnums.PathType;  
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName1, Collections.emptyList());  
        path = getShardLevelBlobPath(client, idx, new BlobPath(), "0", SEGMENTS, METADATA, segmentsPathFixedPrefix).buildAsString();  
        assertTrue(recoveryState.getPrimary());
        // Validate that snapshot is present in repository data  
        final int numDocsInIndex1 = 5;  
import org.opensearch.indices.replication.common.ReplicationType;  
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());  
    public void testSuccessfulIndexRestoredFromSnapshotWithUpdatedSetting() throws IOException, ExecutionException, InterruptedException {
            .put(super.indexSettings())
        final int numDocsInIndex1 = randomIntBetween(20, 30);
            snapshotName2,
        Thread.sleep(1000);  
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        createIndex(indexName2, indexSettings2);
        String snapshotName1 = "test-restore-snapshot1";
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName1, new ArrayList<>(Arrays.asList(indexName1)));
        String snapshotName1 = "test-create-snapshot1";  
        String snapshotName = "new-snapshot";  
            .setIndices(indexName1)  
                .setRenamePattern(index)  
        final int numDocsInIndex2 = 6;
        logger.info("Snapshot Path [{}]", absolutePath1);
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName2)  
        logger.info("Snapshot Path [{}]", absolutePath1);  
        client().admin().indices().close(Requests.closeIndexRequest(indexName1)).get();
            }
                .cluster()
        assertEquals(deleteResponse.getResult(), DocWriteResponse.Result.DELETED);
        // try index restore with index.remote_store.translog.repository ignored  
        String snapshotName2 = "test-restore-snapshot2";
            RemoteStorePinnedTimestampService.class,
                .cluster()
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
        DeleteResponse deleteResponse = client().prepareDelete(index, "0").execute().actionGet();
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());  
        indexDocuments(client, indexName2, 20);  
        String translogPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings());  
    public void forceSyncPinnedTimestamps() {  
        Settings.Builder settings = Settings.builder()
        indexDocuments(client, indexName2, numDocsInIndex2);  
import java.util.Map;  
        validatePathType(indexName1, PathType.FIXED);
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        String snapshotRepoName = "test-create-snapshot-repo";
            } catch (Exception e) {  
                    internalCluster().client().prepareIndex("test-index-load").setSource("field", "value" + i).execute().actionGet();
        Thread.sleep(100);  
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        exception = expectThrows(
        assertTrue(exception.getMessage().contains("cannot remove setting [index.remote_store.segment.repository] on restore"));
        // Start indexing
            .build();  
        assertDocsPresentInIndex(client(), indexName1, numDocsInIndex1);  
        logger.info("Snapshot Path [{}]", absolutePath1);  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;  
        forceSyncPinnedTimestamps();  
                .setIndices(index)
        for (int i = 0; i < 10; i++) {
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)  
        logger.info("--> snapshot");
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;  
                .cluster()
        assertThat(snapshotInfo.getPinnedTimestamp(), greaterThan(0L));
        );  
        String restoredIndexName2 = indexName2 + "-restored";
        assertTrue(recoveryResponse.shardRecoveryStates().containsKey(restoredIndexName1));
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;  
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);  
        } else {
        // try index restore with index.remote_store.segment.repository and index.remote_store.translog.repository ignored  
            .get();
                .setWaitForCompletion(false)  
import java.util.concurrent.atomic.AtomicReference;
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
        createRepository(snapshotRepoName, "fs", getRepositorySettings(absolutePath1, true));
        String indexName1 = "testindex1";
                            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        String snapshotRepoName = "test-restore-snapshot-repo";
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
    }
            getPinningEntity(snapshotRepoName, "some_uuid"),
        assertTrue(snapshotInfo.indices().contains(indexName2));
        assertThat(snapshotInfo.snapshotId().getName(), equalTo(snapshotName1));
        } catch (Exception e) {  
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());  
                        FsRepository.TYPE,
        // try index restore with index.remote_store.translog.repository modified  
        waitUntil(() -> {
        assertTrue(recoveryState.getIndex().totalBytes() > 0L);
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
            .prepareRestoreSnapshot(snapshotRepoName, snapshotName2)
            new ArrayList<>(Arrays.asList(indexName1, indexName2))
        createRepository(remoteStoreRepoNameUpdated, "fs", remoteRepoPath);
        assertEquals(restoreSnapshotResponse2.status(), RestStatus.ACCEPTED);
        RestStatus createSnapshotResponseStatus = client().admin()
        assertEquals(restoreSnapshotResponse1.status(), RestStatus.ACCEPTED);
        );  
                .setRenameReplacement(restoredIndex)
        AtomicLong totalSnaps = new AtomicLong();
        waitUntil(() -> {
            .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
}
            .setWaitForCompletion(true)  
        int numDocsInIndex1 = randomIntBetween(2, 5);
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), false).build() },
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        // Clear the local data before stopping the node. This will make sure that remote translog is empty.
                .setRenamePattern(index)  
                .get()
        String indexName2 = "testindex2";
import org.opensearch.common.io.PathUtils;  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY;
        assertDocsPresentInIndex(client, indexName1, numDocsInIndex1 + 2);
        Settings indexSettings = getIndexSettings(20, 0).build();
            .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(indexName1).restoreAllShards(true), PlainActionFuture.newFuture());  
    public void testClusterManagerFailoverDuringSnapshotCreation() throws Exception {
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1 + 2);
            .setRenamePattern(indexName1)  
    }
        ensureGreen(indexName1, indexName2);
        internalCluster().startDataAndWarmNodes(1, pinnedTimestampSettings());
        assertThat(recoveryState.getIndex().recoveredBytesPercent(), greaterThanOrEqualTo(0.0f));  
        indexSettings = getIndexSettings(1, 0).build();
                RemoteStorePinnedTimestampService.class,
            .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)  
            Stream<Path> segmentData = Files.list(segmentDataPath);  
    }
                .setRenameReplacement(restoredIndex)
        snapshotThread.start();  
        assertThat(snapshotInfo1.successfulShards(), equalTo(snapshotInfo1.totalShards()));
        createRepository(snapshotRepoName, FsRepository.TYPE, settings);
                String snapshotName = "snapshot-earlier-master";  
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
            .setWaitForCompletion(true)
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));  
    }
        ensureGreen(index);
        IndexService indexService = indicesService.indexService(index);
        ensureGreen(indexName1, indexName2);
                    () -> createRepository(
            .setIndices(indexName1)
    public void testCreateSnapshotV2_Orphan_Timestamp_Cleanup() throws Exception {
        String snapshotName1 = "test-restore-snapshot1";
        Path location2 = PathUtils.get(String.join("/", pathTokens));
    }
        // verify even if waitForCompletion is not true, the request executes in a sync manner  
        String snapshotName1 = "test-create-snapshot1";
        logger.info("Snapshot Path [{}]", absolutePath1);  
import static org.hamcrest.Matchers.equalTo;
        flushAndRefresh(indexName1);  
        String indexName1 = "testindex1";
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        );
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName1)).get());
            }
        logger.info("Snapshot Path [{}]", absolutePath1);
            .get();  
        Client client = client();
    public void testConcurrentSnapshotV2CreateOperation() throws InterruptedException, ExecutionException {
import org.opensearch.repositories.RepositoriesService;  
        String snapshotRepoName = "test-restore-snapshot-repo";
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
        Client client = client();
                    .cluster()
    public void testRestoreInSameRemoteStoreEnabledIndex() throws IOException {  
        // Create index with cluster setting cluster.remote_store.index.path.type as hashed_prefix.
        // try index restore with index.number_of_replicas setting modified. index.number_of_replicas can be modified on restore  
        String snapshotRepoName = "test-create-snapshot-repo";
        final Index index = resolveIndex(indexName);
                .setWaitForCompletion(false)
        String snapshotRepoName = "test-create-snapshot-repo";
        ensureRed(indexName2);  
        ensureGreen(indexName1, indexName2);
import java.util.List;
        // stop existing master
        final int numDocsInIndex1 = 10;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        path = getShardLevelBlobPath(client, idx, new BlobPath(), "0", TRANSLOG, DATA, translogPathFixedPrefix).buildAsString();
package org.opensearch.remotestore;
        // Re-initialize client to make sure we are not using client from stopped node.  
        final int numDocsInIndex2 = 20;
        DeleteResponse deleteResponse = client().prepareDelete(indexName1, "0").execute().actionGet();
        assertTrue(recoveryState.getIndex().totalRecoverFiles() > 0);
            .setTransientSettings(Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), PathType.FIXED))  
        // Re-initialize client to make sure we are not using client from stopped node.
        SnapshotInfo snapshotInfo = createSnapshot(snapshotRepoName, snapshotName1, Collections.emptyList());
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
        );  
        assertThat(snapshotInfo2.successfulShards(), equalTo(snapshotInfo2.totalShards()));
        // ensure recovery details are non-zero
        String snapshotName1 = "test-create-snapshot1";  
        for (String node : internalCluster().getNodeNames()) {
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        String snapshotName1 = "test-create-snapshot-v1";  
        assertAcked(client.admin().indices().prepareClose(indexName1));  
        logger.info("Snapshot Path [{}]", absolutePath1);
            SnapshotRestoreException.class,
    public void testCreateSnapshotV2WithIndexingLoad() throws Exception {
        logger.info("Snapshot Path [{}]", absolutePath1);
        Client client = client();
        ensureRed(indexName1);  
        indexingThread.join();  
        RestoreSnapshotResponse restoreSnapshotResponse1 = client.admin()
                    String snapshotName = "snapshot-concurrent-" + snapshotIndex;
                    .cluster()
                internalCluster().nonClusterManagerClient()
        RestoreSnapshotResponse restoreSnapshotResponse2 = client.admin()  
            () -> client().admin()  
            .setIndexSettings(numberOfReplicasSettings)
                    .admin()
        indexDocuments(client, indexName1, numDocsInIndex1, numDocsInIndex1 + randomIntBetween(2, 5));
        String snapshotName1 = "test-restore-snapshot1";  
            assertTrue(segmentData.count() > 0);  
        String snapshotRepoName = "test-create-snapshot-repo";
        Settings remoteStoreIndexSettings = Settings.builder().put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false).build();
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1 + 2);  
    }
     * on snapshot restore.
        ensureGreen(restoredIndexName1);  
        String restoredIndexName1version1 = indexName1 + "-restored-1";
            .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true);
        exception = expectThrows(
            .setIndices(indexName1)  
        client.admin()
            .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        validatePathType(index, pathType, null);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(indexName1)));
