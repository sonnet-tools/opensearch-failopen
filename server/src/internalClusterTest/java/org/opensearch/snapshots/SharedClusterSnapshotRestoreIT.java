                }
import static org.hamcrest.Matchers.nullValue;
            String historyUUID = shardStats.getCommitStats().getUserData().get(Engine.HISTORY_UUID_KEY);
            timeout.millis(),
        index(indexName, MapperService.SINGLE_MAPPING_NAME, docId, "value", expectedValue);
import org.opensearch.action.support.ActiveShardCount;
        );
            assertThat(snapshotPause, equalTo(0L));
            );
        Path snapshotPath = repo.resolve("snap-" + createSnapshotResponse.getSnapshotInfo().snapshotId().getUUID() + ".dat");
        );
        createRepository(
     */
            TimeUnit.MINUTES
        for (int i = 0; i < nbIndices; i++) {
            indexSettingsNoReplicas(randomIntBetween(1, 3)).put(IndexMetadata.SETTING_INDEX_HIDDEN, true).build()
            String historyUUID = shardStats.getCommitStats().getUserData().get(Engine.HISTORY_UUID_KEY);
        final IndexShard primary = internalCluster().getInstance(IndicesService.class, dataNode).getShardOrNull(new ShardId(index, 0));
        response = client.admin().cluster().prepareSnapshotStatus().execute().actionGet();
        final Map<String, List<String>> indicesPerSnapshot = new HashMap<>();
        waitForBlock(blockedNode, "test-repo", TimeValue.timeValueSeconds(60));
        logger.info("--> take snapshots");
        );
        logger.info("--> restoring snapshot 1");
        assertThat(ex.getSnapshotName(), equalTo(snapshotName));
        final String indexName = "unrestorable-index";
            );
        );
    public void testSnapshottingWithMissingSequenceNumbers() {
        ensureGreen();
            () -> client.admin().cluster().prepareGetSnapshots("test-repo").setSnapshots("_foo").get()
        // Write a document
        final SnapshotException sne = expectThrows(
            SnapshotStatus snapshotStatus = snapshotsStatusResponse.getSnapshots().get(0);
        }
    }
        List<SnapshotInfo> snapshotInfos = clusterAdmin().prepareGetSnapshots("test-repo").get().getSnapshots();
        assertEquals(getRepositoryData(repoName).getGenId(), repoGenInIndexLatest);
        );
            for (int j = 0; j < numIndices; j++) {
            client().prepareIndex("test-idx-2").setSource("foo", "bar"),
        shardStats = stats.getShards()[0];
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
            if (historyUUIDs.containsKey(shardId)) {
        final Map<ShardId, String> historyUUIDs = new HashMap<>();
        {
                .cluster()
        );
import org.opensearch.core.util.BytesRefUtils;
        try {
                assertThat(shardStatus.getNodeId(), notNullValue());
        logger.info("--> snapshot");
            .setWaitForCompletion(true)
                assertThat(shard.state(), equalTo(ShardRoutingState.UNASSIGNED));
        createIndexWithRandomDocs("test-idx", 100);
        indexRandomDocs(indexName, newDocCount);
        };
    public void testBasicWorkFlow() throws Exception {
            client().prepareIndex("test-idx-2").setSource("foo", "bar")
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotIndexShardStage;
        createRepository("test-repo", "fs", repositoryLocation);
import org.opensearch.index.shard.IndexShard;
        createRepository("test-repo", "fs", repositoryLocation);
            logger.info("--> start restore");
        logger.info("--> second snapshot of the same name should fail");
            .prepareSnapshotStatus("test-repo")
        // update the test repository in order to make it work
import org.opensearch.cluster.metadata.IndexMetadata;
            refresh();
            .setIndices("test-idx-*")
        {
        if (flushResponseFuture != null) {
        assertThat(shardStats.getSeqNoStats().getGlobalCheckpoint(), equalTo(15L));
        );
            .put(ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.getKey(), 0) // We have tests that check by-timestamp order
                .prepareSnapshotStatus("test-repo")
            "UUID has changed after restore: " + newIndexUUID + " vs. " + newAfterRestoreIndexUUID,
            client.admin().cluster().prepareDeleteRepository(randomFrom("test-repo", "test-*", "*")).execute().actionGet();
            CreateSnapshotResponse createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap-" + i)
                .state(),
            .execute()
                .get();
    }
                .put("location", randomRepoPath())
        final Client client = client();
            int nbDocs = randomIntBetween(1, 10);
        String repoName = "test-restore-snapshot-repo";
        ensureGreen("test-idx-1", "test-idx-2");
import org.opensearch.action.index.IndexRequestBuilder;
import static org.hamcrest.Matchers.greaterThan;
        GetSnapshotsResponse response = clusterAdmin().prepareGetSnapshots("test-repo").setSnapshots("_all").setVerbose(false).get();
                .execute()
                assertThat(createSnapshotResponse.getSnapshotInfo().shardFailures().size(), greaterThan(0));
        assertEquals(SnapshotState.SUCCESS, getSnapshot("test-repo-2", "test-snap-2").state());
        NumShards numShards = getNumShards("test");
            .setWaitForCompletion(true)
            index(indexName, "_doc", Integer.toString(i), "foo", "bar" + i);
            if (!indicesToFlush.isEmpty()) {
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(0));
        for (ShardStats shardStats : client().admin().indices().prepareStats(indicesToSnapshot).clear().get().getShards()) {
        OpenSearchIntegTestCase.putRepository(client.admin().cluster(), "test-repo", "fs", false, settings);
        createIndexWithRandomDocs(indexName, 10);
        );
        logger.info("--> waiting for snapshot to finish");
import org.opensearch.cluster.routing.ShardRoutingState;
            for (int j = 0; j < nbDocs; j++) {
                restoreSnapshotResponse.getRestoreInfo().successfulShards(),
        Client client = client();
    public void testDataFileCorruptionDuringRestore() throws Exception {
        ShardStats shardStats = stats.getShards()[0];
        logger.info("--> delete indices");
                .put("location", repo)
                .put("location", repositoryLocation)
            indicesPerSnapshot.put(snapshotName, indices);
            if (createSnapshotResponse.getSnapshotInfo().totalShards() != createSnapshotResponse.getSnapshotInfo().successfulShards()) {
            client().prepareDelete("test-idx-2", Integer.toString(i)).get();
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), greaterThan(0));
     * See https://github.com/elastic/elasticsearch/issues/20876
        assertThat(response.getSnapshots().size(), equalTo(1));
                .indices()
                )
        disableRepoConsistencyCheck("This test intentionally leaves a broken repository");
        assertAcked(prepareCreate(indexName).setWaitForActiveShards(ActiveShardCount.ALL));
                .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
                client.admin().indices().prepareClose("test-idx-1").get();
        logger.info("--> unblocking blocked node");
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
            "test-repo",
        CreateSnapshotResponse createSnapshotResponse = client.admin()
            final Throwable cause = ex.getCause();
            .setRenameReplacement("restored-3")
            // same node again during the same reroute operation. Then another reroute
            .prepareRestoreSnapshot("test-repo", "test-snap")
        for (int i = 0; i < numberOfSnapshots; i++) {
            index(indexName, "_doc", Integer.toString(i), "foo", "bar" + i);
                if (randomBoolean()) {
            outChan.truncate(randomInt(10));
                assertThat(e.getMessage(), containsString("Cannot close indices that are being restored: [[test-idx-1/"));
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
        SnapshotMissingException ex = expectThrows(
        cluster().wipeIndices("test-idx");
            .prepareGetSettings("test-copy")
                }
            "mock",
                .put("compress", randomBoolean())
        logger.info("--> restore index after deletion");
                .get(0);
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
    private void verifySnapshotInfo(final GetSnapshotsResponse response, final Map<String, List<String>> indicesPerSnapshot) {
                    IntStream.range(1, numberOfSnapshots - 1).mapToObj(i -> "test-snap-" + i).toArray(String[]::new)
                    client().admin().indices().prepareDelete("test-idx-1").get();
        assertThat(
            "test-repo",
        response = clusterAdmin().prepareGetSnapshots("test-repo").setSnapshots("test-snap-*").setVerbose(false).get();
        logger.info("--> snapshot");
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
        logger.info("--> creating index");
        final long repoGenInIndexLatest2 = BytesRefUtils.bytesToLong(
            if (shard.primary()) {
     * all Store references held onto by the snapshot are released.
            .setTransientSettings(Settings.builder().putNull(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey()).build())
                .execute()
            .cluster()
/*
        );
                .getSnapshotInfo()
            // block the shard to be assigned again because it failed during restore.
            cluster().wipeIndices(hiddenIndex);
        createRepository(
import static org.hamcrest.Matchers.containsInAnyOrder;
            .prepareCreateSnapshot("test-repo", "test-snap")
                .put("max_restore_bytes_per_sec", throttleRestore && (throttleRestoreViaRecoverySettings == false) ? "10k" : "0")
        }
 */
                .prepareCreateSnapshot(repoName, snapshotName)
            .cluster()
            "cannot delete snapshot from a readonly repository"
        final String indexName = "test-idx";
            .setWaitForCompletion(true)
    public void testHiddenIndicesIncludedInSnapshot() throws InterruptedException {
        createIndexWithRandomDocs("test-idx", 100);
            () -> client.admin().cluster().prepareSnapshotStatus("test-repo").setSnapshots("_foo").get()
            true,
        createSnapshot(repoName, snapshotName, Collections.singletonList(indexName));
                .put("random", randomAlphaOfLength(10))
        RestoreInProgress restoreInProgress = clusterStateResponse.getState().custom(RestoreInProgress.TYPE);
        createRepository("test-repo", "fs", repositoryLocation);
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeWithPrimary);
     * Tests that a snapshot of multiple indices including one with a corrupted index metadata
import org.opensearch.repositories.RepositoryException;
            }
        createIndex("test-idx", "test-idx-closed");
        logger.info("--> truncate snapshot file to make it unreadable");
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
                    }
        final GetSnapshotsResponse getSnapshotsResponse = clusterAdmin().prepareGetSnapshots("test-repo").get();
            ShardId shardId = shardStats.getShardRouting().shardId();
        final int numReplicas = 1;
            .put("max_failure_number", 10000000L)
            .setWaitForCompletion(true)
import org.opensearch.common.unit.TimeValue;
        return Settings.builder()
                }
            snapshotPause += repositoriesService.repository("test-repo").getSnapshotThrottleTimeInNanos();
            .setTransientSettings(
        createIndexWithRandomDocs("test-idx-2", 100);
    public void testDataFileFailureDuringSnapshot() throws Exception {
        long snapshotPause = 0L;
        final SnapshotInfo snapshotInfo = createFullSnapshot("test-repo", "test-snap");
        // update the test repository
import java.util.List;
        );
            client.admin()
        ensureGreen();
                }
        cluster().wipeIndices("test-idx");
        for (int i = 0; i < 50; i++) {
        assertDocCount("test-idx-1", 100L);
        logger.info("--> restore all indices from the snapshot");
        // create a test index
        createSnapshot("test-repo", "test-snap", Collections.singletonList("test"));
        );
                .get()
        logger.info("--> try creating a snapshot with the same name, now it should work because the first one was deleted");
            "mock",
            .actionGet();
        assertThat(snapshotInfos.get(0).snapshotId().getName(), equalTo("test-snap"));
    }
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
            }
                .put("max_failure_number", 10000000L)
        assertThat(snapshot2.successfulShards(), is(newShardCount));
        logger.info("--> restoring snapshot [{}]", snapshotToRestore);
        logger.info("--> delete some data");
        Client client = client();
        assertThat(
        }
import java.util.Collections;
            Settings.builder()
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
        Settings repositorySettings = Settings.builder()
            .setIndices(indexName)
        createRepository(
import org.opensearch.action.support.IndicesOptions;
 *
            Settings.EMPTY,
        final String snapshotName = "test-snap";
        OpenSearchIntegTestCase.putRepository(client.admin().cluster(), "test-repo", "mock", false, settings);
        }
        );
            );
        assertThat(snapshotStatus.getShardsStats().getStartedShards(), greaterThan(0));
            .prepareRestoreSnapshot("test-repo", "test-snap")
                .cluster()
            .cluster()
        Path absolutePath = randomRepoPath().toAbsolutePath();
        if (createSnapshotResponse.getSnapshotInfo().totalShards() == createSnapshotResponse.getSnapshotInfo().successfulShards()) {
    public void testListCorruptedSnapshot() throws Exception {
        logger.info("--> waiting for block to kick in on node [{}]", blockedNode);
        }
        Path repositoryLocation = randomRepoPath();
            numberOfFiles[i] = numberOfFiles(repo);
            "test-repo",
            Settings.builder()
            // Restoring a file will never complete
        // We blocked the node during data write operation, so at least one shard snapshot should be in STARTED stage
                ConcurrentSnapshotExecutionException.class,
        );
    public void testCannotCreateSnapshotsWithSameName() throws Exception {
            .get();
        Path absolutePath = randomRepoPath().toAbsolutePath();
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
                .getSnapshots()
        logger.info("--> trying to create a repository with different name");
            .execute()
    public void testEmptySnapshot() throws Exception {
            RepositoryException.class,
        createRepository(repoName, "fs", absolutePath);
            "Number of failed shards [{}]",
import org.opensearch.repositories.RepositoryData;
        logger.info("--> checking snapshot status again after snapshot is done");
                    assertThat(shardFailure.nodeId(), notNullValue());
                if (shardStatus.getStage() == SnapshotIndexShardStage.FAILURE) {
        logger.info("--> ensuring snapshot is aborted and the aborted shard was marked as failed");
                    .build()
        }
            assertThat(getFailureCount("test-repo"), greaterThan(0L));
        boolean throttleSnapshot = randomBoolean();
        try {
        SnapshotStatus snapshotStatus = response.getSnapshots().get(0);
        assertThat(clusterState.getMetadata().hasIndex("test-idx-2"), equalTo(false));
            .setWaitForCompletion(true)
            // Verify that snapshot status also contains the same failures
        client.admin().cluster().prepareCreateSnapshot("test-repo", "test-snap").setWaitForCompletion(false).setIndices("test-idx").get();
        SnapshotInfo snapshotInfo = getResponse.getSnapshots().get(0);
            // index some additional docs (maybe) for each index
            );
        ClusterState clusterState = internalCluster().clusterService(internalCluster().getClusterManagerName()).state();
            assertThat(unassignedInfo.getNumFailedAllocations(), anyOf(equalTo(maxRetries), equalTo(1)));
                .get();
                equalTo(restoreSnapshotResponse.getRestoreInfo().totalShards())
            // All shards were restored, we must find the exact number of hits
        String expectedValue = "expected";
        logger.info("--> delete index");
        }
        ClusterStateResponse stateResponse = client.admin().cluster().prepareState().get();
            cluster().wipeIndices(normalIndex, hiddenIndex);
        ensureGreen("test-idx");
        client().admin().indices().prepareClose("test").get();
        logger.info("--> restore indices with different names");
            // Store number of files after each snapshot
            SnapshotMissingException.class,
            client.admin()
        Settings.Builder settings = Settings.builder()
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            .setRenamePattern(indexName)
        }
        Client client = client();
        assertThat(sne.getMessage(), containsString("Indices don't have primary shards"));
            assertThat(clusterState.getMetadata().hasIndex(dottedHiddenIndex), equalTo(false));
        final Settings restoreIndexSettings,
        final int initialShardCount = randomIntBetween(1, 10);
        String restoredIndexName = indexName + "-restored";
        logger.info("--> snapshot");
        assertThat(restoreResponse.getRestoreInfo().totalShards(), equalTo(numShards.numPrimaries));
        );
        } else {
        disableRepoConsistencyCheck("This test intentionally leaves a broken repository");
            .setIndices("test-idx-*", "-test-idx-2")
            1L,
                .setIndices("*")
            .cluster()
                .getSetting("test-idx-1", MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey())
     */
        logger.info("--> verify wildcard returns snapshot info");
 *
        assertThat(getSnapshotsResponse.getSnapshots(), notNullValue());
        assertAcked(client().admin().indices().prepareDelete(indexName));
        assertAcked(client().admin().indices().prepareDelete(indexName));
            try {
        final String dataNode = internalCluster().getDataNodeInstance(ClusterService.class).localNode().getName();
import java.util.function.Predicate;
            createSnapshotResponse = client.admin()
            SnapshotMissingException.class,
        cluster().wipeIndices("test-idx");
            .setIndicesOptions(IndicesOptions.lenientExpand())
            if (isRestorableIndex.test(entry.getKey())) {
            restoreSnapshotResponse.getRestoreInfo().totalShards(),
                restoreSnapshotResponse.getRestoreInfo().successfulShards(),
            "test-repo",
            .getSetting("test", IndexMetadata.SETTING_INDEX_UUID);
            .cluster()
        logger.info("--> get snapshots request should return both snapshots");
                for (SnapshotShardFailure shardFailure : createSnapshotResponse.getSnapshotInfo().shardFailures()) {
        assertAcked(prepareCreate("test-idx", 2, Settings.builder().put("number_of_replicas", 0)));
        }
        );
                .put("random_data_file_io_exception_rate", 1.0)
                .prepareGetSettings("test-idx-1")
        assertThat(snapshotStatus.includeGlobalState(), equalTo(false));
        } finally {
        cluster().wipeIndices("test-idx");
            .setWaitForCompletion(true)
        {
                .setWaitForCompletion(true)
        createIndexWithRandomDocs("test-idx-1", 100);
    }
                fail("Expected closing index to fail during restore");
        assertDocCount("test-idx", 100L);
        logger.info("--> snapshot with [{}] shards", initialShardCount);
    /**
    /**
 * software distributed under the License is distributed on an
        assertDocCount("test-idx", 10L * numberOfSnapshots);
            outChan.truncate(randomInt(10));
        final int newDocCount = newShardCount * randomIntBetween(1, 10);
        }
            logger.info("--> unblocking all data nodes");
    public void testThrottling() throws Exception {
            // non-partial snapshots do not allow close / delete operations on indices where snapshot has not been completed
            assertThat(restoreSnapshotResponse.getRestoreInfo().indices(), containsInAnyOrder(dottedHiddenIndex));
            SnapshotStatus snapshotStatus = client.admin()
        // Truncate the index metadata file
        logger.info("--> snapshot");
            for (SnapshotIndexShardStatus status : shards) {
        }
            assertThat(
        final Path globalStatePath = repo.resolve("meta-" + snapshotInfo.snapshotId().getUUID() + ".dat");
                .put("location", repositoryLocation)
            assertEquals(
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), equalTo(0));
            index(indexName, "_doc", Integer.toString(i), "foo", "bar" + i);
        }
        final int docCount = initialShardCount * randomIntBetween(1, 10);
        GetSnapshotsResponse getSnapshotsResponse = client.admin().cluster().prepareGetSnapshots("readonly-repo").get();
            SnapshotInfo snapshotInfo = getSnapshot("test-repo", "test-snap");
            ClusterState clusterState = client.admin().cluster().prepareState().get().getState();
        assertEquals("index.latest should not have been written to", repoGenInIndexLatest, repoGenInIndexLatest2);
        assertThat(ex.getRepositoryName(), equalTo("test-repo"));
import org.opensearch.cluster.routing.UnassignedInfo;
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
        }
                assertThat(shardFailure.index(), equalTo("test-idx"));
            RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot(repoName, snapName)
            .prepareGetSnapshots(repoName)
        Path repositoryLocation = randomRepoPath();
        final String snapshotName = "test-snap";
        logger.info("Number of failed shards [{}]", snapshotInfo.shardFailures().size());
        final Client client = client();
                () -> clusterAdmin().prepareDeleteSnapshot(repoName, snapshotName).get()
            for (int i = 1; i < 4; i++) {
        ensureGreen();
        }
        final long repoGenInIndexLatest = BytesRefUtils.bytesToLong(
        assertThat(restoreInfo.totalShards(), equalTo(numShards.numPrimaries));
            .prepareUpdateSettings()
                flushResponseFuture = client().admin().indices().prepareFlush(indices).execute();
            Settings.builder()
            .setWaitForCompletion(true)
    }
            assertThat(
            boolean atLeastOne = false;
            }
        assertFalse(
        refresh(indexName);
            assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
            client().prepareIndex("test-idx-1").setSource("foo", "bar"),
        assertThat(snapshotInfos.get(0).state(), equalTo(SnapshotState.SUCCESS));
        // delete the test index
            .getSetting("test-copy", IndexMetadata.SETTING_INDEX_UUID);
        clusterAdmin().prepareRestoreSnapshot(repoName, "snap-2")
        assertEquals("test-snap", response.getSnapshots().get(0).getSnapshot().getSnapshotId().getName());
        stats = client().admin().indices().prepareStats(indexName).clear().get();
        waitForBlock(blockedNode, "test-repo", TimeValue.timeValueSeconds(60));
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot(repoName, snapshotName)
            .actionGet();
        String blockedNode = blockNodeWithIndex("test-repo", "test-idx");
        };
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
import static org.hamcrest.Matchers.hasSize;
            );
            .setIncludeGlobalState(false)
import static org.opensearch.index.shard.IndexShardTestCase.getEngine;
    public void testCloseOrDeleteIndexDuringSnapshot() throws Exception {
        createIndexWithRandomDocs("test-idx-1", 100);
     * its allocation does not hang indefinitely.
            .build();
        for (SnapshotIndexShardStatus shardStatus : snapshotStatus.getIndices().get("test-idx")) {
            .setRestoreGlobalState(randomBoolean())
    /**
        restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
            assertThat(clusterState.getMetadata().hasIndex(hiddenIndex), equalTo(true));
        assertThat(shardStats.getSeqNoStats().getMaxSeqNo(), equalTo(15L));
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
        );
        }
            .get();
        indexService.removeShard(0, "simulate node removal");
            SnapshotException.class,
                .setIndices(indexName)
        final String snapshotToRestore;
            .get();
     */
    public void testDeleteSnapshot() throws Exception {
    public void testReadonlyRepository() throws Exception {
        response = client.admin()
        indexRandomDocs(indexName, docCount);
import java.nio.file.Files;
                "meta-" + repositoryData.indexMetaDataGenerations().indexMetaBlobId(snapshotInfo.snapshotId(), corruptedIndex) + ".dat"
            equalTo(SnapshotState.SUCCESS)
        {
        logger.info("--> restore index");
        for (int i = 0; i < 5; i++) {
        }
            assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
            assertThat(e.getMessage(), containsString("snapshot with the same name already exists"));
        logger.info("--> removing primary shard that is being snapshotted");
                    atLeastOne = true;
        logger.info("--> delete index");
        logger.info("--> snapshot with potential I/O failures");
            client().admin()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                .setSnapshots("test")
            .execute()
            .setIndices(indexName)
import java.util.ArrayList;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
    }
    }
        assertThat(getSnapshot("test-repo", "test").state(), equalTo(SnapshotState.SUCCESS));
        final String[] indices = { "test-idx-1", "test-idx-2", "test-idx-3" };
            client.admin()
            logger.info("--> close index while restore is running");
            }
            .prepareRestoreSnapshot("test-repo", "test-snap")
            // during restore and then we don't allow the shard to be assigned on the
        logger.info("--> trying to restore index again");
import org.opensearch.index.mapper.MapperService;
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        indexRandomDocs(indexName, 100);
        }
        createRepository(repoName, "fs", absolutePath);
        );
        CreateSnapshotResponse createSnapshotResponse = startFullSnapshot("test-repo", "test-snap").get();
            .get();
import org.opensearch.cluster.RestoreInProgress;
        Client client = client();
                .getSnapshotInfo()
            () -> client.admin().cluster().prepareSnapshotStatus("test-repo").addSnapshots("test-snap-doesnt-exist").get()
    public void testSnapshotClosedIndex() throws Exception {
        } catch (Exception ex) {
            .indices()
        createRepository("test-repo-2", "mock", repoPath);
        createRepository("test-repo", "fs", repositoryLocation);
            }
        fixUpAction.run();
            for (int j = 0; j < 10; j++) {
        } catch (SnapshotException | RepositoryException ex) {
                }
    }
            )
        logger.info(
        assertThat(snapshotStatusResponse.getSnapshots(), hasSize(1));
        final Settings repositorySettings,
            final ClusterStateResponse clusterStateResponse = client.admin().cluster().prepareState().get();
        createFullSnapshot(repoName, "snapshot-2");
            () -> clusterAdmin().prepareRestoreSnapshot(repoName, snapshotName).setRestoreGlobalState(true).setWaitForCompletion(true).get()
            newIndexUUID.equals(newAfterRestoreIndexUUID)
        ClusterState clusterState = clusterAdmin().prepareState().get().getState();
        assertThat(snapshotInfos.size(), equalTo(1));
     * file can still be used to restore the non corrupted indices
                .put("random", randomAlphaOfLength(10))
            int numberOfFailures = 0;
        Settings.Builder settings = Settings.builder()
        for (RepositoriesService repositoriesService : internalCluster().getDataNodeInstances(RepositoriesService.class)) {
            Settings.builder().put("location", repositoryLocation).put("random", randomAlphaOfLength(10)).put("wait_after_unblock", 200)
            .cluster()
                try {
            unblockAllDataNodes(repoName);
        flushAndRefresh("test-idx-1", "test-idx-2");
        cluster().wipeIndices("test-idx");
        List<SnapshotInfo> snapshotInfos = client.admin()
    }
    }
            .resolve(
            assertThat(indexStatus.getShardsStats().getFailedShards(), equalTo(snapshotInfo.failedShards()));
            assertAcked(client().admin().indices().prepareClose(indicesToSnapshot).setWaitForActiveShards(ActiveShardCount.ALL).get());
            .repository(repoName);
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
            .prepareCreateSnapshot("test-repo", "test-snap")
        if (throttleSnapshot) {
            .setIndices(indexName)
            OpenSearchIntegTestCase.putRepository(client.admin().cluster(), "test-repo", "fs", settings);
        logger.info("--> delete index");
            .execute()
            .setWaitForCompletion(true)
        assertThat(snapshotStatus.getShardsStats().getStartedShards(), greaterThan(0));
        );
        // delete the index and restore again
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
        assertBusy(
        Client client = client();
    }
        unblockNode("test-repo", blockedNode);
        Client client = client();
        String repoName = "test-repo";
            .put("random", randomAlphaOfLength(10));
        try (SeekableByteChannel outChan = Files.newByteChannel(indexMetadataPath, StandardOpenOption.WRITE)) {
        final RestoreSnapshotResponse restoreResponse = client.admin()
            assertThat(indexStatus, notNullValue());
            .setWaitForCompletion(true)
            .put("location", repoPath)
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
                .cluster()
        assertThat(snapshotInfo.shardFailures().get(0).reason(), is("aborted"));
            logger.info("--> caught a top level exception, asserting what's expected", ex);
        assertTrue("RestoreInProgress must be empty but found entries in " + restoreInProgress, restoreInProgress.isEmpty());
        );
                .state(),
        logger.info("-->  update repository with mock version");
}
            assertThat(rootCause.getMessage(), containsString("Random IOException"));
                if (snapshotInfo.state() == SnapshotState.SUCCESS) {
        // Verify that hidden indices get restored with a wildcard restore
        logger.info("--> delete all snapshots except the first one and last one");
    }
        Consumer<UnassignedInfo> checkUnassignedInfo = unassignedInfo -> {
        // index some documents
        assertEquals(0, createSnapshotResponse.getSnapshotInfo().failedShards());
        assertEquals(0, snapshotInfo.shardFailures().get(0).shardId());
            .setIndices("test-idx")
            .setIndices("test-idx-*")
            .execute()
        // test that getting an unavailable snapshot status throws an exception if ignoreUnavailable is false on the request
        );
                createSnapshotResponse.getSnapshotInfo().successfulShards(),
            .setRenameReplacement("restored-2")
        );
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
            new BytesRef(Files.readAllBytes(repoPath.resolve(BlobStoreRepository.INDEX_LATEST_BLOB)))
            // unblock even if the try block fails otherwise we will get bogus failures when we delete all indices in test teardown.
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
                .put("max_snapshot_bytes_per_sec", throttleSnapshot ? "10k" : "0")
        logger.info("--> delete index before restoring");
    }
        assertRequestBuilderThrows(
        assertFalse(newIndexUUID, newIndexUUID.equals(originalIndexUUID));
        logger.info("--> wait for block to kick in");
        ensureGreen();
            "UUID has been reused on restore: " + copyRestoreUUID + " vs. " + originalIndexUUID,
        assertThat(snapshotInfo.version(), equalTo(Version.CURRENT));
        );
        logger.info("--> start relocations");
        CreateSnapshotResponse createSnapshotResponse = client.admin()
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
        assertAcked(prepareCreate("test-idx", 2, indexSettingsNoReplicas(between(2, 10))));
            "test-repo",
            .setIndices(indicesToSnapshot)
        createIndexWithRandomDocs("test-idx-2", 100);
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
import java.util.function.Consumer;
        final SnapshotInfo snapshotInfo = getSnapshot("test-repo", "test-snap");
        logger.info("--> indexing some data");
 * specific language governing permissions and limitations
            flushResponseFuture.actionGet();
        CreateSnapshotResponse createSnapshotResponse = future.get();
        }
                .get()
            }
        } else {
            .prepareUpdateSettings()
            }
        }
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
            .setWaitForCompletion(true)
            .prepareRestoreSnapshot("readonly-repo", "test-snap")
        ensureGreen();
            assertEquals(snapshotName, e.getSnapshotName());
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(0));
        ensureGreen();
        final Settings settings = indexSettingsNoReplicas(1).put("index.routing.allocation.include._name", dataNode).build();
        assertThat(snapshotInfos.get(0).snapshotId().getName(), equalTo(snapshotName));
                equalTo(restoreSnapshotResponse.getRestoreInfo().totalShards())
        final Client client = client();
            );
        assertRequestBuilderThrows(
        indexRandomDocs(dottedHiddenIndex, 100);
     * leaving the cluster, then returning), all snapshotting of that shard is aborted, so
        if (snapshotClosed) {
        createSnapshot("test-repo", "test-snap", Collections.singletonList("test-idx"));
            .actionGet();
        ensureGreen();
        );
                    "test-repo",
            for (SnapshotIndexShardStatus shardStatus : indexStatus.getShards().values()) {
        waitForBlock(blockedNode, "test-repo", TimeValue.timeValueSeconds(60));
        String indexName = "testindex";
        final String snapshot = "test-snap";
            SnapshotIndexStatus indexStatus = snapshotStatus.getIndices().get("test-idx");
        createRepository(
            .setWaitForCompletion(true)
            .actionGet();
    }
        disableRepoConsistencyCheck(
                }
        assertTrue(
        if (snapshotClosed) {
        logger.info("-->  closing index test-idx-closed");
 * the Apache License, Version 2.0 (the "License"); you may
        // (available one should be returned)
        createFullSnapshot(repoName, "snapshot-1");
        final RepositoryData repositoryData = getRepositoryData("test-repo");
            () -> assertTrue("Expected index [" + index + "] to exist", indexExists(index)),
        final String repositoryName = "test-repo";
        assertDocCount("test-idx-1", 50L);
        for (int i = 0; i < numSnapshots; i++) {
        cluster().wipeIndices("test-idx");
            "test-repo",
        assertThat(ex.getRepositoryName(), equalTo(repoName));
            // No lucene corruptions, we want to test retries
    public void testBulkDeleteWithOverlappingPatterns() {
        blockAllDataNodes(repoName);
        assertDocCount("test-idx", 100L);
        Path repositoryLocation = randomRepoPath();
            .setWaitForCompletion(true)
        final Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).build();
        assertThat(indexStatus.getShards().size(), equalTo(snapshotInfo.totalShards()));
            .execute()
        logger.info("--> done");
            client.admin()
        disableRepoConsistencyCheck("This test intentionally leaves a broken repository");
        // test that getting an unavailable snapshot status does not throw an exception if ignoreUnavailable is true on the request
            }
import java.util.concurrent.TimeUnit;
            logger.info("--> waiting for block to kick in");
        expectThrows(
            .setSnapshots(randomFrom(snapName, "_all", "*", "*-snap", "test*"))
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, numShards.numPrimaries)));
                    fail("Expected deleting index to fail during snapshot");
            unassignedInfo -> assertThat(unassignedInfo.getReason(), equalTo(UnassignedInfo.Reason.NEW_INDEX_RESTORED)),
                .setWaitForCompletion(true)
        SnapshotsStatusResponse response = client.admin().cluster().prepareSnapshotStatus("test-repo").execute().actionGet();
            } catch (IllegalArgumentException e) {
 * Modifications Copyright OpenSearch Contributors. See
        for (ShardRouting shard : clusterStateResponse.getState().getRoutingTable().allShards(indexName)) {
            assertThat(snapshotInfo.shardFailures().size(), greaterThan(0));
        createRepository("test-repo", "fs");
        assertThat(
    }
        createIndex("test-idx");
        for (int i = 0; i < numSnapshots; i++) {
        for (int i = 0; i < numIndices; i++) {
        );
            assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
        logger.info("--> restoring working repository");
        expectThrows(
import org.opensearch.core.common.unit.ByteSizeUnit;
        CreateSnapshotResponse createSnapshotResponse = client.admin()
        assertThat(createSnapshotResponse.getSnapshotInfo().state(), equalTo((SnapshotState.SUCCESS)));
                .put("block_on_data", true)
        assertAcked(prepareCreate(indexName, Settings.builder().put(createIndexSettings)));
import java.util.stream.IntStream;
        for (int i = 0; i < numberOfSnapshots; i++) {
        createFullSnapshot(repoName, "snapshot-3");
import org.opensearch.repositories.blobstore.BlobStoreRepository;
import static org.hamcrest.Matchers.is;
        createSnapshotResponse = client.admin()
        assertThat(getSnapshot("test-repo", "test-2").state(), equalTo(SnapshotState.SUCCESS));
        }
            String indexName = "test-idx-" + i;
        logger.info("--> total number of simulated failures during restore: [{}]", getFailureCount("test-repo"));
    private void unrestorableUseCase(
        logger.info("--> creating an index and indexing documents");
        assertThat(snapshotInfos.size(), equalTo(1));
        logger.info("--> snapshot");
        final int numberOfSnapshots = between(5, 15);
        ClusterStateResponse clusterStateResponse = clusterAdmin().prepareState().setCustoms(true).setRoutingTable(true).get();
                .get();
            CreateSnapshotResponse createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap")
        Client client = client();
 * under the License.
        // check that all shards failed during restore
    }
        logger.info("--> snapshot");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;
        createRepository(repoName, "mock");
            .get();
            assertThat(getFailureCount("test-repo"), greaterThan(0L));
        Client client = client();
        assertDocCount("test-idx-1", 100);
        assertEquals(indicesPerSnapshot.size(), response.getSnapshots().size());
        createRepository(repoName, "fs");
            }
        logger.info("--> checking that _current returns the currently running snapshot");
        logger.info("--> take first snapshot");
        logger.info("--> execution was blocked on node [{}], trying to delete repository", blockedNode);
            .put("random_control_io_exception_rate", randomIntBetween(5, 20) / 100f)
            assertThat(clusterState.getMetadata().hasIndex(dottedHiddenIndex), equalTo(true));
                .prepareCreateSnapshot("test-repo", "test-snap")
        createRepository(repoName, "fs", repo);
            List<SnapshotIndexShardStatus> shards = snapshotStatus.getShards();
                .addSnapshots("test-snap")
            "fs",
        assertThat(snapshotInfo.indices(), hasSize(nbIndices));
        final Map<String, Integer> nbDocsPerIndex = new HashMap<>();
        } finally {
                .actionGet();
    }
        String newAfterRestoreIndexUUID = client().admin()
        // Create index on 2 nodes and make sure each node has a primary by setting no replicas
        if (throttleRestore) {
        assertThat(getResponse.getSnapshots().size(), equalTo(1));
            .execute();
        final String index = "test-idx";
        assertThat(shardStats.getSeqNoStats().getGlobalCheckpoint(), equalTo(10L));
        Settings createIndexSettings = Settings.builder()
            .actionGet();
        assertEquals(getRepositoryData(repoName).getGenId(), repoGenInIndexLatest3);
                    indices.add("test-idx-" + j);
        final String snapshotName = "test-snap";
                clusterStateResponse.getState().getRoutingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size()
        Client client = client();
                // the less the number of shards, the less control files we have, so we are giving a higher probability of
            .actionGet();
            assertThat(indexStatus.getShards().size(), equalTo(snapshotInfo.totalShards()));
        logger.info("--> verify doc counts");
        final Consumer<UnassignedInfo> checkUnassignedInfo,
            .get();
            "test-repo",
            .get();
            equalTo(true)
        logger.info("--> waiting for completion");
        {
        assertThat(clusterState.getMetadata().hasIndex("test-idx-1"), equalTo(true));
                } catch (SnapshotInProgressException e) {
        logger.info("--> try deleting snapshot");
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotIndexShardStatus;
            fail("shouldn't be able to replace in-use repository");
            .setIndices(indexName)
        assertThat(shardStats.getSeqNoStats().getLocalCheckpoint(), equalTo(15L)); // 15 indexed docs and one "missing" op.
        cluster().wipeIndices("test-idx-1", "test-idx-2");
            waitForCompletion("test-repo", "test-snap", TimeValue.timeValueSeconds(600)).shardFailures().size()
     * Test that restoring an index with shard allocation filtering settings that prevents
        assertDocCount("test-idx", 100L);
            .setIndices("test-idx")
                // triggering an IOException toward the end when writing the pending-index-* files, which are the files
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.IN_PROGRESS));
        logger.info("--> deleting indices");
        final String indexName = "unrestorable-files";
            "test-repo",
    public void testUnrestorableIndexDuringRestore() throws Exception {
            List<SnapshotIndexShardStatus> shards = snapshotStatus.getShards();
        indexRandomDocs(normalIndex, 100);
        for (ShardStats shardStats : client().admin().indices().prepareStats(indicesToSnapshot).clear().get().getShards()) {
                    assertThat(e.getMessage(), containsString("Cannot close indices that are being snapshotted: [[test-idx-1/"));
            .execute()
        assertThat(createSnapshotResponse.getSnapshotInfo().indices().size(), equalTo(2));
        logger.info("--> delete index");
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
                .get();
            .prepareRestoreSnapshot("test-repo", "test-snap")
            .indices()
        }
        );
        createRepository("test-repo", "fs", repositoryLocation);
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
import org.opensearch.core.index.Index;
        // Test restore after index deletion
     * does not hang indefinitely.
        logger.info("--> deleting indices before restoring");
        }
        final NumShards numShards = getNumShards(indexName);
import static org.hamcrest.Matchers.containsString;
        final String snapshotName = "test-snap";
        createFullSnapshot(repoName, "snapshot-4");
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
                .put("random_data_file_io_exception_rate", 0.3)
        createIndexWithRandomDocs("test-idx", 100);
        assertNull(
            .prepareGetSettings("test")
        long restorePause = 0L;
        logger.info("--> try making another snapshot");
                }
        createIndexWithRandomDocs("test-idx-3", 100);
            Settings.builder().put("location", randomRepoPath()).put("random", randomAlphaOfLength(10)).put("wait_after_unblock", 200)
            } else {
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
            .getSnapshots();
            .actionGet();
                .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
                .setWaitForCompletion(true)
            .setClusterManagerNodeTimeout("30s")
                .put("random", randomAlphaOfLength(10))
        assertThat(getSnapshot("test-repo", "test-1").state(), equalTo(SnapshotState.SUCCESS));
        createSnapshot("test-repo", "test-snap", Collections.singletonList("test-idx"));
        RestoreSnapshotResponse restoreResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
        ensureGreen();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        } else {
            .get();
            indexRandom(true, documents);
        cluster().wipeIndices("test");
        if (randomBoolean()) {
            .put("random", randomAlphaOfLength(10))
        indexRandomDocs("test-idx", numDocs);
    public void testRestoreSnapshotWithCorruptedGlobalState() throws Exception {
                .put("location", randomRepoPath())
            client.admin()
            .get()
        try {
                restoreInfo.failedShards(),
                String[] indices = indicesToFlush.toArray(new String[0]);
        restoreResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap").setWaitForCompletion(true).get();
        logger.info("--> snapshot");
            for (int j = 0; j < 10; j++) {
            prepareCreate("test-idx").setSettings(
        } finally {
            .setRenameReplacement("$1-copy")
        SnapshotException ex = expectThrows(
            CreateSnapshotResponse createSnapshotResponse = client.admin()
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        IndicesStatsResponse stats = client().admin().indices().prepareStats(indexName).clear().get();
        final String repositoryName = "test-repo";
        createSnapshot("test-repo", "test-snap", Collections.singletonList("test-idx"));
    }
                .setWaitForCompletion(true)
        logger.info("--> restore all indices from the snapshot");
            assertThat(shardStats.getShardRouting() + " doesn't have a new history", historyUUID, not(equalTo(historyUUIDs.get(shardId))));
        createIndex("test");
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
        // only one shard
import org.opensearch.common.action.ActionFuture;
        assertHitCount(client().prepareSearch("test-idx-*").setSize(0).get(), 3);
            snapshotToDelete = "snap-1";
            "fs",
                .setIndices("*", "-.*")
import org.opensearch.index.IndexService;
                .cluster()
        logger.info("--> checking snapshot status after it is done with empty repository");
        }
                .setWaitForCompletion(true)
        Settings.Builder excludeSettings = Settings.builder().put("index.routing.allocation.exclude._name", blockedNode);
        logger.info("--> index more documents");
        cluster().wipeIndices("test-idx");
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
            assertThat(e.getMessage(), containsString("cannot delete snapshot during a restore"));
            .get();
                .getSetting("test-idx-1", MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey())
        );
            }
        Client client = client();
                    for (int k = 0; k < numDocs; k++) {
                .put("index.number_of_shards", 3)
            logger.info("--> in-use repository deletion failed");
            "mock",
        SnapshotInfo snapshotInfo = snapshotInfos.get(0);
            assertThat(shardStats.getShardRouting() + " doesn't have a history uuid", historyUUID, notNullValue());
        Settings.Builder settings = Settings.builder().put("location", repositoryLocation).put(repositorySettings);
            logger.info("--> waiting for block to kick in");
            .setRenamePattern(indexName)
            .actionGet();
        prepareCreate("test-idx").setSettings(Settings.builder().put("index.allocation.max_retries", Integer.MAX_VALUE)).get();
            assertThat(shardStats.getShardRouting() + " doesn't have a new history", historyUUID, not(equalTo(historyUUIDs.get(shardId))));
            .cluster()
        restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
        final Runnable fixUpAction
        assertThat(indexStatus.getShardsStats().getDoneShards(), equalTo(snapshotInfo.successfulShards()));
        assertNotNull("RestoreInProgress must be not null", restoreInProgress);
        assertThat(snapshotInfos.get(0).snapshotId().getName(), equalTo("test-snap-1"));
                .put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag", "nowhere")
            assertThat(clusterState.getMetadata().hasIndex(normalIndex), equalTo(true));
            for (SnapshotIndexShardStatus status : shards) {
                .get()
        assertFalse(newIndexUUID, newIndexUUID.equals(IndexMetadata.INDEX_UUID_NA_VALUE));
        logger.info("--> delete indices");
        assertThat(
        // Now read restore results and make sure it failed
        createIndex(
        List<SnapshotInfo> snapshotInfos = client.admin()
        assertThat(
        logger.info("--> execution was blocked on node [{}], moving shards away from this node", blockedNode);
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
        }
            .addSnapshots("test-snap", "test-snap-doesnt-exist")
                .setIndices(indexName)
    }
                assertThat(shardStats.getShardRouting() + " has a different history uuid", historyUUID, equalTo(historyUUIDs.get(shardId)));
            .actionGet();
        final Path indexMetadataPath = repo.resolve("indices")
            copyRestoreUUID.equals(originalIndexUUID)
            assertThat(rootCause, notNullValue());
                .put("compress", false)
            for (SnapshotIndexShardStatus status : shards) {
import org.opensearch.cluster.SnapshotsInProgress.State;
        // We blocked the node during data write operation, so at least one shard snapshot should be in STARTED stage
        logger.info("--> wait for restore to finish");
        logger.info("--> execution will be blocked on all data nodes");
            logger.info("--> snapshot {}", i);
        assertThat(getSnapshotsResponse.getSnapshots(), empty());
        logger.info("--> snapshot");
            .cluster()
        createRepository(repoName, "mock", repoPath);
        );
        logger.info("--> restore index after deletion");
        client.admin()
                .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
            final boolean all = randomBoolean();
            assertThat(
        assertThat(response.getSnapshots().size(), equalTo(1));
import static org.hamcrest.Matchers.equalTo;
        createIndexWithRandomDocs("test-idx-1", 100);
            Settings.builder()
        assertThat(shardStats.getSeqNoStats().getLocalCheckpoint(), equalTo(10L)); // 10 indexed docs and one "missing" op.
        createRepository(
            .prepareRestoreSnapshot("test-repo", "test-snap")
            .setWaitForCompletion(true)
        expectThrows(SnapshotMissingException.class, () -> client.admin().cluster().prepareDeleteSnapshot("test-repo", "_foo").get());
        String blockedNode = blockNodeWithIndex("test-repo", "test-idx");
        ensureGreen();
        indexRandomDocs(index, 100);
        final int numPrimaries = 1;
    }
        assertThat(clusterStateResponse.getState().getRoutingTable().allShards(indexName), hasSize(numShards.totalNumShards));
            waitForCompletion("test-repo", "test-snap", TimeValue.timeValueSeconds(600)).shardFailures().size()
            final String snapshotName = "test-snap-" + i;
        assertAcked(prepareCreate("test").setSettings(indexSettings));
        }
                .setWaitForCompletion(true)
        Predicate<String> isRestorableIndex = index -> corruptedIndex.getName().equals(index) == false;
        ensureGreen();
        restoreFut.get();
                client().admin()
        assertThat(snapshotStatus.getIndices().size(), equalTo(1));
        ActionFuture<RestoreSnapshotResponse> restoreSnapshotResponseFuture = client.admin()
        logger.info("Snapshot successfully completed");
        logger.info("--> get restore results");
            SnapshotStatus snapshotStatus = client.admin()
        final int numIndices = randomIntBetween(1, 10);
            .prepareCreateSnapshot(repositoryName, snapshotName)
 * KIND, either express or implied.  See the License for the
        assertDocCount("restored-2", newDocCount);
            "mock",
import org.opensearch.indices.IndicesService;
            .prepareGetSettings("test")
 * Unless required by applicable law or agreed to in writing,
        createIndexWithRandomDocs("test-idx-2", 100);
 *
        try {
            verifySnapshotInfo(response, indicesPerSnapshot);
            .prepareGetSnapshots("test-repo")
        } else {
    protected Settings nodeSettings(int nodeOrdinal) {
        // that would mean that recovery process started and failing
                .getSnapshotInfo()
        final Path repo = randomRepoPath();
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
import static org.hamcrest.Matchers.empty;
        logger.info("--> taking a snapshot");
        int[] numberOfFiles = new int[numberOfSnapshots];
            .put(SETTING_ALLOCATION_MAX_RETRY.getKey(), maxRetries)
                equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
        } catch (Exception ex) {
        // Test restore after index deletion
            .put("random_control_io_exception_rate", 0.2);
            expectedCount = newDocCount;
            // unblock even if the try block fails otherwise we will get bogus failures when we delete all indices in test teardown.
            ConcurrentSnapshotExecutionException e = expectThrows(
                .setIndices(indexName)
        logger.info("--> close index");
            .setIndices(indexName)
                    assertThat(snapshotInfo.shardFailures().size(), greaterThan(0));
        ).setWaitForActiveShards(ActiveShardCount.NONE).get();
        blockAllDataNodes("test-repo");
            .get()
                assertThat(getFailureCount("test-repo"), equalTo(0L));
    }
        indexRandom(
            new BytesRef(Files.readAllBytes(repoPath.resolve(BlobStoreRepository.INDEX_LATEST_BLOB)))
                .prepareCreateSnapshot(repositoryName, snapshotName)
            assertThat(indexStatus.getShardsStats().getDoneShards(), equalTo(snapshotInfo.successfulShards()));
        restoreSnapshotResponse = client.admin()
        assertThat(indexStatus.getShardsStats().getFailedShards(), equalTo(snapshotInfo.failedShards()));
            SnapshotStatus snapshotStatus = client.admin()
    }
            Settings.builder().put("location", repoPath).put(BlobStoreRepository.SUPPORT_URL_REPO.getKey(), false)
                equalTo(restoreSnapshotResponse.getRestoreInfo().totalShards())
        String blockedNode = blockNodeWithIndex("test-repo", "test-idx");
                .setIndices("test-idx-*")
            "mock",
                .cluster()
        // Test restore after index deletion
import org.apache.lucene.util.BytesRef;
        assertThat(stateResponse.getState().routingTable().index("test-idx-closed"), notNullValue());
        CreateSnapshotResponse createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap")
    public void testSnapshotRelocatingPrimary() throws Exception {
        disableRepoConsistencyCheck("This test intentionally leaves a broken repository");
                .get();
import org.opensearch.cluster.service.ClusterService;
            ClusterState clusterState = client.admin().cluster().prepareState().get().getState();
            .cluster()
        GetSnapshotsResponse getResponse = client.admin()
        assertThat(snapshotInfos.size(), equalTo(1));
                .setWaitForCompletion(true)
            .cluster()
        response = client.admin().cluster().prepareSnapshotStatus("test-repo").addSnapshots("test-snap").execute().actionGet();
            .prepareCreateSnapshot("test-repo", "test-snap-1")
        assertEquals("[test-repo:test-snap-doesnt-exist] is missing", ex.getMessage());
                documents[j] = client.prepareIndex(indexName).setSource("foo", "bar");
        logger.info("--> waiting for block to kick in");
            .get();
            IndexRequestBuilder[] documents = new IndexRequestBuilder[nbDocs];
            assertEquals(1, response.getSnapshots().size());
        clusterAdmin().prepareRestoreSnapshot(repoName, snapshotToRestore)
        // test getting snapshot status for available and unavailable snapshots where ignoreUnavailable is true
import org.opensearch.common.settings.Settings;
            "readonly-repo",
        disableRepoConsistencyCheck("This test uses a purposely broken repository so it would fail consistency checks");
        assertDocCount("test-idx", 100);
            }
        );
        assertThat(numberOfFilesAfterDeletion, lessThan(numberOfFilesBeforeDeletion));
            assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
        for (Map.Entry<String, Integer> entry : nbDocsPerIndex.entrySet()) {
        assertThat(snapshotInfos.get(0).state(), equalTo(SnapshotState.SUCCESS));
        String docId = Integer.toString(randomInt());
        ensureGreen();
        cluster().wipeIndices("test-idx");
        Path repo = randomRepoPath();
                assertThat(status.getStats().getProcessedFileCount(), equalTo(0));
import org.opensearch.snapshots.mockstore.MockRepository;
        createRepository(
        }
import static org.hamcrest.Matchers.lessThan;
            .setWaitForCompletion(true)
        try {
            client().admin()
        assertAcked(prepareCreate("test-idx", 2, Settings.builder().put("number_of_replicas", 0)));
        Client client = client();
        disableRepoConsistencyCheck("This test intentionally leaves a broken repository");
        assertDocCount(indexName, nbDocs);
            .setIndices(randomFrom("*", "_all"))
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        logger.info("-->  creating repository");
        snapshotStatus = response.getSnapshots().get(0);
        assertDocCount("test-idx-2", 100L);
    }
                .get();
    }
        createSnapshot("test-repo", "test-1", Collections.singletonList("test"));
                restoreSnapshotResponse.getRestoreInfo().successfulShards(),
                .cluster()
            restoreSnapshotResponse.getRestoreInfo().failedShards(),
    public void testRestoreSnapshotWithCorruptedIndexMetadata() throws Exception {
        // we have to delete the index here manually, otherwise the cluster will keep
            assertThat(restoreSnapshotResponse.getRestoreInfo().indices(), containsInAnyOrder(normalIndex, hiddenIndex));
 * GitHub history for details.
        logger.info("--> list available shapshots");
                // If we are here, that means we didn't have any failures, let's check it
        // TODO: Fix repo cleanup logic to handle these leaked snap-file and only exclude test-repo (the mock repo) here.
import static org.hamcrest.Matchers.anyOf;
                // that caused problems with writing subsequent snapshots if they happened to be lingering in the repository
                if (all || randomBoolean() || !atLeastOne) {
            )
        createIndex("test-idx-1", "test-idx-2", "test-idx-3");
            outChan.truncate(randomInt(10));
            .cluster()
                // soft-delete generates DV files.
            indexName,
            cluster().wipeIndices(normalIndex, hiddenIndex, dottedHiddenIndex);
            .get()
            String historyUUID = shardStats.getCommitStats().getUserData().get(Engine.HISTORY_UUID_KEY);
        createRepository("test-repo", "fs");
        logger.info("--> deleting all snapshots");
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
        createIndexWithRandomDocs("test-idx", 100);
        assertDocCount("test-idx", 10L * numberOfSnapshots);
        createRepository("test-repo", "fs");
            restorePause += repositoriesService.repository("test-repo").getRestoreThrottleTimeInNanos();
        assertThat(snapshotInfos.size(), equalTo(1));
        verifySnapshotInfo(response, indicesPerSnapshot);
        prepareCreate(
            assertThat(clusterState.getMetadata().hasIndex(normalIndex), equalTo(true));
            logger.info("--> in-use repository replacement failed");
            // sometimes, the snapshot will fail with a top level I/O exception
        assertThat(snapshotStatusResponse.getSnapshots().get(0).getSnapshot().getSnapshotId().getName(), equalTo(snapshotName));
                historyUUIDs.put(shardId, historyUUID);
            .cluster()
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        final boolean snapshotClosed = randomBoolean();
            .cluster()
        // Verify that exclusions work on hidden indices
                    logger.info("--> delete index while non-partial snapshot is running");
        ensureGreen();
        logger.info("--> close indices");
        ActionFuture<FlushResponse> flushResponseFuture = null;
        logger.info("-->  creating index that cannot be allocated");
import org.opensearch.cluster.routing.IndexRoutingTable;
                .put("location", randomRepoPath())
        clusterAdmin().prepareCreateSnapshot(repo, snapshot).setWaitForCompletion(false).execute();
            .get();
        List<SnapshotInfo> snapshotInfos = clusterAdmin().prepareGetSnapshots(repoName).get().getSnapshots();
                    logger.info("--> close index while non-partial snapshot is running");
        assertThat(snapshotInfo.shardFailures().size(), equalTo(0));
        logger.info("--> replace mock repository with real one at the same location");
        indexRandomDocs("test-idx", 100);
        String nodeWithPrimary = clusterState.nodes().get(indexRoutingTable.shard(0).primaryShard().currentNodeId()).getName();
        createSnapshotResponse = client.admin()
        createIndexWithRandomDocs("test-idx", 100);
            // If we are here, that means we didn't have any failures, let's check it
    public void testSnapshotName() throws Exception {
        final Map<String, IndexId> indexIds = repositoryData.getIndices();
                .getSnapshots()
            Settings settings = client.admin().indices().prepareGetSettings("test").get().getIndexToSettings().get("test");
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
 * license agreements. See the NOTICE file distributed with
        // Create index on 2 nodes and make sure each node has a primary by setting no replicas
            assertThat(getFailureCount("test-repo"), equalTo(0L));
        logger.info("--> creating an index and indexing documents");
            .indices()
        logger.info("--> unblocking blocked node");
            .cluster()
        createIndex(normalIndex, indexSettingsNoReplicas(randomIntBetween(1, 3)).build());
        snapshotInfo = waitForCompletion("test-repo", "test-snap", TimeValue.timeValueSeconds(600));
                .prepareCreateSnapshot("test-repo", "test-snap")
            assertDocCount("test-idx", 100L);
            client().prepareIndex("test-idx-2").setSource("foo", "bar"),
import java.nio.file.StandardOpenOption;
        logger.info("--> creating random number of indices");
        createRepository(repositoryName, "fs");
        final SnapshotInfo snapshotInfo = getSnapshot("test-repo", "test-snap");
        assertThat(getSnapshotsResponse.getSnapshots().size(), equalTo(1));
    /** Tests that a snapshot with a corrupted global state file can still be restored */
            assertThat(clusterState.getMetadata().hasIndex(normalIndex), equalTo(false));
        RestoreSnapshotResponse restoreSnapshotResponse = restoreSnapshotResponseFuture.actionGet(TimeValue.timeValueSeconds(10));
            .get();
            logger.info("--> try deleting the snapshot while the restore is in progress (should throw an error)");
        );
            restoreFut = client.admin().cluster().prepareRestoreSnapshot("test-repo", "test-snap").setWaitForCompletion(true).execute();
import org.opensearch.cluster.routing.ShardRouting;
/*
import java.util.Arrays;
 * Licensed to Elasticsearch under one or more contributor
    public void testSnapshotStatus() throws Exception {
                assertThat(status.getStats().getProcessedFileCount(), greaterThan(1));
            .execute()
            Settings.builder()
                    client().admin().indices().prepareClose("test-idx-1").get();
    }
        waitForBlock(blockedNode, repo, TimeValue.timeValueSeconds(10));
        assertThat(
            Settings.builder()
            .execute()
        createRepository(
        createSnapshot("test-repo", "test", Collections.singletonList("test"));
    private void waitForIndex(final String index, TimeValue timeout) throws Exception {
            .cluster()
        ensureGreen();
            assertThat(unassignedInfo.getReason(), equalTo(UnassignedInfo.Reason.ALLOCATION_FAILED));
            .setIgnoreUnavailable(true)
            for (int j = 0; j < numIndices; j++) {
            }
            Settings.builder()
    public void testGetSnapshotsFromIndexBlobOnly() throws Exception {
            .setRenamePattern(indexName)
        indexRandomDocs("test-idx", 100);
                .cluster()
            unblockAllDataNodes("test-repo");
        Path repositoryLocation = randomRepoPath();
            assertAcked(prepareCreate("test-idx-" + i).setSettings(indexSettingsNoReplicas(1)));
            ArrayList<String> indicesToFlush = new ArrayList<>();
        final int numberOfSnapshots = between(5, 15);
            equalTo(SnapshotState.SUCCESS)
        OpenSearchIntegTestCase.putRepository(client.admin().cluster(), "test-repo-2", "fs", false, settingsBuilder);
            .prepareGetSnapshots("test-repo")
            .prepareCreateSnapshot(repositoryName, snapshotName)
            .prepareGetSettings("test")
    }
        // Test restore after index deletion
            if (randomBoolean()) {
                equalTo(restoreSnapshotResponse.getRestoreInfo().totalShards())
            SnapshotException.class,
        logger.info("--> restore all indices from the snapshot");
            .prepareCreateSnapshot("test-repo-2", "test-snap-2")
                .setWaitForCompletion(true)
        logger.info("Path [{}]", absolutePath);
        final Client client = client();
            .setWaitForCompletion(true)
        }
        unrestorableUseCase(indexName, createIndexSettings, repositorySettings, Settings.EMPTY, checkUnassignedInfo, () -> {});
            if (shardStatus.getStage() == SnapshotIndexShardStage.STARTED) {
                .actionGet();
        assertDocCount("test-idx-2", 50L);
                .setWaitForCompletion(true)
        final int newShardCount = randomIntBetween(1, 10);
        // Verify that hidden indices can be restored by fully specified name
        RestoreSnapshotResponse restoreSnapshotResponse = restoreFut.get();
            .getSnapshots();
 * SPDX-License-Identifier: Apache-2.0
            .prepareRestoreSnapshot("test-repo", lastSnapshot)
        );
        assertTrue(originalIndexUUID, originalIndexUUID != null);
        if (restoreInfo.successfulShards() == restoreInfo.totalShards()) {
            .setWaitForCompletion(true)
                indexSettingsNoReplicas(1)
        assertThat(restoreSnapshotResponse.getRestoreInfo().successfulShards(), equalTo(snapshotInfo.successfulShards()));
        assertThat(snapshotInfos.size(), equalTo(1));
            Settings.builder().put("location", randomRepoPath()).put("random", randomAlphaOfLength(10)).put("wait_after_unblock", 200)
    ) throws Exception {
        logger.info("--> done");
        );
        }
            );
        assertAcked(prepareCreate("test-idx", 2, Settings.builder().put("number_of_replicas", 0)));
        assertNotNull("should be at least one node with a primary shard", nodeWithPrimary);
            .cluster()
                assertThat(status.getStats().getProcessedFileCount(), greaterThan(2));
        createRepository(
        try (SeekableByteChannel outChan = Files.newByteChannel(globalStatePath, StandardOpenOption.WRITE)) {
        final Settings createIndexSettings,
        );
        final String repo = "test-repo";
            assertEquals(expected, indicesPerSnapshot.get(snapshotInfo.snapshotId().getName()));
        assertThat(restoreResponse.getRestoreInfo().successfulShards(), equalTo(0));
            }
    }
    public void testSnapshotSucceedsAfterSnapshotFailure() throws Exception {
        createIndexWithRandomDocs("test-idx", 100);
        }
            Settings.builder().put("location", repositoryLocation).put("random", randomAlphaOfLength(10)).put("wait_after_unblock", 200)
        final String snapshotName2 = "test-snap-2";
            logger.info("--> unblocking all data nodes");
        createIndex(indexName, Settings.builder().put("index.number_of_shards", newShardCount).build());
 * compatible open source license.
            for (int i = 1; i < numberOfSnapshots - 1; i++) {
        }
            .getSetting("test", IndexMetadata.SETTING_INDEX_UUID);
            );
        logger.info("--> snapshot with no I/O failures");
    }
        OpenSearchIntegTestCase.putRepository(clusterAdmin(), "test-repo", "mock", settings);
                assertThat(shard.recoverySource().getType(), equalTo(RecoverySource.Type.SNAPSHOT));
        response = client.admin()
            true,
    }
        logger.info("--> delete index");
            .setWaitForCompletion(true)
import org.opensearch.index.engine.Engine;
        assertFalse(originalIndexUUID, originalIndexUUID.equals(IndexMetadata.INDEX_UUID_NA_VALUE));
        final String repoName = "test-repo";
 */
            } else {
        // Create index on two nodes and make sure each node has a primary by setting no replicas
                    assertThat(e.getMessage(), containsString("Cannot delete indices that are being snapshotted: [[test-idx-1/"));
        createSnapshot("test-repo", "test-2", Collections.singletonList("test"));
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        int numberOfFilesAfterDeletion = numberOfFiles(repo);
            () -> client.admin().cluster().prepareGetSnapshots("test-repo").setIgnoreUnavailable(false).get()
        // Create index on 2 nodes and make sure each node has a primary by setting no replicas
        unblockNode("test-repo", blockedNode);
        logger.info("--> restore index after deletion");
        logger.info("--> verify _all returns snapshot info");
            createSnapshot("test-repo", "test-snap-" + i, Collections.singletonList("test-idx"));
                logger.info("--> starting asynchronous flush for indices {}", Arrays.toString(indices));
            .get()
        disableRepoConsistencyCheck("This test intentionally leaves an empty repository");
        assertThat(indexStatus, notNullValue());
    public void testUnallocatedShards() {
        Runnable fixupAction = () -> {
        logger.info("Path [{}]", absolutePath);
        String originalIndexUUID = client().admin()
    }
            assertThat(restoreSnapshotResponse.getRestoreInfo().indices(), containsInAnyOrder(normalIndex, hiddenIndex, dottedHiddenIndex));
            equalTo(restoreSnapshotResponse.getRestoreInfo().failedShards())
        logger.info("--> delete index");
            .get();
            "fs",
            .setIndicesOptions(IndicesOptions.lenientExpand())
        assertAcked(client.admin().indices().prepareDelete(indexName));
        createRepository(
        logger.info("--> creating repository");
 */
            client().prepareIndex("test-idx-3").setSource("foo", "bar")
        assertThat(snapshotInfo.shardFailures(), empty());
        snapshotStatus = response.getSnapshots().get(0);
            assertEquals(repoName, e.getRepositoryName());
            .setWaitForCompletion(true)
        final SnapshotInfo snapshot2 = createFullSnapshot(repoName, "snap-2");
import org.opensearch.Version;
            .setIndices("test-idx-*")
            client.admin()
                    .prepareUpdateSettings(indexName)
            .get();
            } else {
        final Path repoPath = randomRepoPath();
        for (int i = 5; i < 10; i++) {
    public void testSnapshotMoreThanOnce() throws InterruptedException {
 * this file be licensed under the Apache-2.0 license or a
            Settings.builder()
                .setIndices("test-idx")
        SnapshotInfo snapshotInfo = waitForCompletion(repo, snapshot, TimeValue.timeValueSeconds(60));
            // remove the shard allocation filtering settings and use the Reroute API to retry the failed shards
                .setWaitForCompletion(true)
import static org.hamcrest.Matchers.notNullValue;
            () -> assertThat(clusterAdmin().prepareHealth("test-idx").execute().actionGet().getRelocatingShards(), greaterThan(0)),
        List<SnapshotInfo> snapshotInfos = clusterAdmin().prepareGetSnapshots("test-repo")
        CreateSnapshotResponse createSnapshotResponse = client.admin()
            assertAcked(prepareCreate(indexName).setSettings(indexSettingsNoReplicas(Math.min(2, numberOfShards()))));
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot(repoName, snapshotName)
            .put("use_lucene_corruption", false)
        final String indexName = "test-idx";
        Settings.Builder settings = Settings.builder().put("location", repoPath);
                .prepareSnapshotStatus("test-repo")
        }
                    refresh();
            assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
            .indices()
        refresh();
        indexRandomDocs("test-idx", 100);
            assertThat(snapshotInfo.state(), equalTo(SnapshotState.PARTIAL));
        }
import java.nio.channels.SeekableByteChannel;
                .execute()
        assertThat(
            "test-repo",
            "fs",
                    assertThat(shardFailure.index(), equalTo("test-idx"));
        logger.info("--> trying to move repository to another location");
        createRepository(
            List<SnapshotIndexShardStatus> shards = snapshotStatus.getShards();
        createRepository(repoName, "fs", repoPath);
                .indices()
            .setSnapshots(randomFrom("test-snap", "_all", "*", "*-snap", "test*"))
        logger.info("--> delete index");
    public void testFreshIndexUUID() {
        final SnapshotException ex = expectThrows(
        );
                .get()
            unblockAllDataNodes("test-repo");
        logger.info("--> checking that _current no longer returns the snapshot");
        Path repositoryLocation = randomRepoPath();
        final ActionFuture<RestoreSnapshotResponse> restoreFut;
                .put("random_data_file_io_exception_rate", 0.3)
        final String repoName = "test-repo";
        );
        logger.info("--> restoring snapshot 2");
            .setWaitForCompletion(true)
        final Client client = client();
            }
        final int maxRetries = randomIntBetween(1, 10);
            .getSnapshots();
        createRepository("test-repo", "fs");
        String lastSnapshot = "test-snap-" + (numberOfSnapshots - 1);
        );
            RepositoryException.class,
    }
        assertThat(snapshotStatus.includeGlobalState(), equalTo(false));
import static org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider.SETTING_ALLOCATION_MAX_RETRY;
            dottedHiddenIndex,
                .get();
        final String repoName = "test-repo";
        final String indexName = "test-idx";
        logger.info("--> wait for relocations to start");
import org.opensearch.cluster.metadata.MetadataIndexStateService;
        logger.info("--> make sure that number of files is back to what it was when the first snapshot was made");
            createSnapshot("test-repo", snapshotName, indices);
        assertThat(getRepositoryData("test-repo"), is(RepositoryData.EMPTY));
            .cluster()
            waitForBlockOnAnyDataNode(repoName, TimeValue.timeValueMinutes(1));
        Client client = client();
            index(indexName, "_doc", Integer.toString(i), "foo", "bar" + i);
            assertThat(restorePause, equalTo(0L));
            logger.info("--> start restore");
        final RestoreInfo restoreInfo = restoreResponse.getRestoreInfo();
        logger.info("--> snapshot");
            );
 * ownership. Elasticsearch licenses this file to you under
            assertThat(restoreSnapshotResponse.getRestoreInfo().indices(), containsInAnyOrder(hiddenIndex));
        logger.info("--> creating indices");
                .execute()
                .cluster()
                .state(),
        logger.info("--> unblocking blocked node [{}]", blockedNode);
                    assertThat(shardStatus.getFailure(), nullValue());
                .put("location", repositoryLocation)
                .cluster()
                // we flush before the snapshot such that we have to process the segments_N files plus the .del file
            .put(super.nodeSettings(nodeOrdinal))
        startDeleteSnapshot(repositoryName, snapshotName).get();
                .cluster()
            .addSnapshots("test-snap-doesnt-exist")
            assertThat(createSnapshotResponse.getSnapshotInfo().shardFailures().size(), greaterThan(0));
                    assertThat(shardFailure.reason(), containsString("Random IOException"));
        // Choose a random index from the snapshot
        }
        SnapshotInfo snapshotInfo = snapshotInfos.get(0);
            "test-idx",
        );
            assertThat(clusterState.getMetadata().hasIndex(dottedHiddenIndex), equalTo(false));
            assertThat(
                .put("readonly", true)
        // execute action to eventually fix the situation
        logger.info("--> unblocking blocked node");
        assertThat(snapshotInfo.version(), equalTo(Version.CURRENT));
                        index("test-idx-" + j, "_doc", Integer.toString(k), "foo", "bar" + k);
        SnapshotIndexStatus indexStatus = snapshotStatus.getIndices().get("test-idx");
                Settings.builder()
        logger.info("--> indexing some more");
        createIndex(indices);
        Path repo = randomRepoPath();
        Settings.Builder settingsBuilder = Settings.builder().put("location", repositoryLocation.resolve("test"));
    public void testSnapshotDifferentIndicesBySameName() throws InterruptedException, ExecutionException {
        final ActionFuture<RestoreSnapshotResponse> restoreFut;
            SnapshotException.class,
        // create a test repository
        cluster().wipeIndices("test-idx");
            assertThat(clusterState.getMetadata().hasIndex(normalIndex), equalTo(false));
            .build();
import java.nio.file.Path;
            assertAcked(
            .setWaitForCompletion(true)
                index("test-idx", "_doc", Integer.toString(i * 10 + j), "foo", "bar" + i * 10 + j);
        Settings restoreIndexSettings = Settings.builder().put("index.routing.allocation.include._name", randomAlphaOfLength(5)).build();
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
            .setIndices(nbDocsPerIndex.keySet().stream().filter(isRestorableIndex).toArray(String[]::new))
 * this work for additional information regarding copyright
        );
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
        ensureGreen(indexName);
        client.admin().cluster().prepareCreateSnapshot("test-repo", "test-snap").setWaitForCompletion(false).setIndices("test-idx").get();
        assertAcked(
        boolean throttleRestore = randomBoolean();
        );
        String newIndexUUID = client().admin()
        expectThrows(InvalidSnapshotNameException.class, () -> client.admin().cluster().prepareCreateSnapshot("test-repo", "_foo").get());
        assertAcked(client().admin().indices().prepareDelete("test-idx-1", "test-idx-2"));
    public void testUnrestorableFilesDuringRestore() throws Exception {
        createRepository(
        }
            .setWaitForCompletion(true)
/*
            assertThat(clusterState.getMetadata().hasIndex(hiddenIndex), equalTo(false));
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
import java.util.HashMap;
    /** Execute the unrestorable test use case **/
            RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot(repoName, snapName)
            client.admin().cluster().prepareDeleteSnapshot("readonly-repo", "test-snap"),
        final String hiddenIndex = "hidden-index";
        assertThat(indexStatus.getShardsStats().getInitializingShards(), equalTo(0));
        } catch (InvalidSnapshotNameException e) {
        EngineTestCase.generateNewSeqNo(getEngine(primary));
        assertEquals(1, snapshotInfo.shardFailures().size());
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus;
        final long repoGenInIndexLatest3 = BytesRefUtils.bytesToLong(
                    .setSettings(Settings.builder().putNull("index.routing.allocation.include._name").build())
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        final int nbIndices = randomIntBetween(2, 3);
            .setRenameReplacement(restoredIndexName)
                .getSnapshots()
        assertDocCount("test-idx", 100L);
            .getSetting("test", IndexMetadata.SETTING_INDEX_UUID);
        logger.info("--> wait for the index to appear");
        Client client = client();
        verifySnapshotInfo(response, indicesPerSnapshot);
            .execute();
    public void testSnapshotCanceledOnRemovedShard() throws Exception {
        assertThat(getSnapshot("test-repo", "test-snap").state(), equalTo(SnapshotState.SUCCESS));
        );
        logger.info("--> creating {} snapshots ", numberOfSnapshots);
                .get()
        startDeleteSnapshot("test-repo", lastSnapshot).get();
        logger.info("--> delete index");
        logger.info("--> restore index");
            .setWaitForCompletion(true)
import org.opensearch.repositories.IndexId;
                .prepareDeleteSnapshot(
            .get();
        repository.setFailOnIndexLatest(true);
        createRepository("test-repo", "fs");
        String copyRestoreUUID = client().admin()
            equalTo(SnapshotState.SUCCESS)
        createRepository("test-repo", "fs", repositoryLocation);
            ClusterState clusterState = client.admin().cluster().prepareState().get().getState();
                if (randomBoolean()) {
            .setIndices("test-idx*")
        logger.info("--> snapshot with [{}] shards", newShardCount);
        createRepository("test-repo", "fs");
        String snapshotName = "test-restore-snapshot";
        ensureGreen();
        assertThat(
        disableRepoConsistencyCheck("This test uses a purposely broken repository so it would fail consistency checks");
        IndexService indexService = indicesService.indexService(resolveIndex(index));
        assertThat(restoreResponse.getRestoreInfo().successfulShards(), equalTo(numShards.numPrimaries));
            }
            assertThat(snapshotStatus.getIndices().size(), equalTo(1));
            "Number of failed shards [{}]",
            }
        assertThat(snapshotStatus.getState(), equalTo(State.STARTED));
            .prepareSnapshotStatus("test-repo")
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
        for (SnapshotIndexShardStatus shardStatus : snapshotStatus.getIndices().get("test-idx")) {
                    assertThat(shardStatus.getFailure(), notNullValue());
        final Client client = client();
        assertAcked(client().admin().indices().prepareDelete(indexName));
        }
            // One or more shards failed to be restored. This can happen when there is
        client().prepareDelete("test", "1").get();
        logger.info("--> verify individual requests return snapshot info");
        );
        // trying to allocate the shards for the index, even though the restore operation
        String indexName = "testindex";
        clusterAdmin().prepareRestoreSnapshot(repoName, "snap-1")
        for (int i = 10; i < 15; i++) {
        assertThat(snapshot1.successfulShards(), is(initialShardCount));
            expectedCount = docCount;
        try {
            .cluster()
import org.opensearch.action.admin.indices.stats.ShardStats;
            .cluster()
        final String indexName,
        cluster().wipeIndices(normalIndex, hiddenIndex, dottedHiddenIndex);
            Settings.builder().put("location", repo).put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
import static org.opensearch.indices.recovery.RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING;
        unrestorableUseCase(
            .get();
        assertThat(restoreResponse.getRestoreInfo().totalShards(), equalTo(numShards.numPrimaries));
        assertDocCount("restored-3", expectedCount);
        final NumShards numShards = getNumShards("test-idx");
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
            fixupAction
            List<String> indices = new ArrayList<>();
        // check that the shards have been created but are not assigned
        }
            "mock",
        }
        final Path repoPath = randomRepoPath();
                    final int numDocs = randomIntBetween(1, 5);
            ShardId shardId = shardStats.getShardRouting().shardId();
        createRepository("test-repo", "fs", repositoryLocation);
            assertAcked(client().admin().indices().prepareOpen(indicesToSnapshot).setWaitForActiveShards(ActiveShardCount.ALL).get());
        CreateSnapshotResponse createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap")
        clusterAdmin().prepareDeleteSnapshot("test-repo", "test-snap-*", "*").get();
        final Path repositoryLocation = randomRepoPath();
        }
        // Pick one node and block it
 * You may obtain a copy of the License at
                .actionGet();
        createRepository("test-repo", "fs", repo);
            "This test uses a purposely broken repository implementation that results in leaking snap-{uuid}.dat files"
        );
        client().admin().indices().prepareUpdateSettings("test-idx").setSettings(excludeSettings).get();
        final String dottedHiddenIndex = ".index-hidden";
                    indicesToFlush.add("test-idx-" + i);
        createRepository("test-repo", "fs");
            .actionGet();
        assertThat(snapshotInfo.successfulShards(), equalTo(numShards.numPrimaries));
        Path repositoryLocation = randomRepoPath();
        client.admin()
        logger.info("--> check that all shards were recovered");
        ensureGreen();
            .setWaitForCompletion(true)
                .setWaitForCompletion(true)
            assertThat(clusterState.getMetadata().hasIndex(hiddenIndex), equalTo(true));
import org.opensearch.cluster.ClusterState;
import org.opensearch.transport.client.Client;
import org.opensearch.threadpool.ThreadPool;
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
            RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot(repoName, snapName)
                    fail("Expected closing index to fail during snapshot");
        repository.setFailOnIndexLatest(false);
            .cluster()
        assertThat(createSnapshotResponse.getSnapshotInfo().totalShards(), equalTo(0));
                .put("compress", randomBoolean())
        assertNoFailures(client().admin().indices().prepareForceMerge("test").setFlush(true).setMaxNumSegments(1).get());
            SnapshotMissingException.class,
import org.opensearch.test.OpenSearchIntegTestCase;
        );
        logger.info("--> creating 2 snapshots");
    public void testDeleteSnapshotWhileRestoringFails() throws Exception {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
            .setRenamePattern("(.+)")
        assertNull(
        logger.info("--> execution was blocked on node [{}], checking snapshot status with specified repository and snapshot", blockedNode);
            assertThat(shardStats.getShardRouting() + " doesn't have a history uuid", historyUUID, notNullValue());
        }
        logger.info("--> snapshot");
        assertThat(snapshotInfo.shardFailures().size(), equalTo(0));
            .execute()
            assertThat(indexStatus.getShardsStats().getFailedShards(), equalTo(numberOfFailures));
        final SnapshotInfo snapshotInfo = createFullSnapshot(repoName, snapshotName);
            .resolve(corruptedIndex.getId())
        waitForBlockOnAnyDataNode("test-repo", TimeValue.timeValueMinutes(1));
        // check that there is no restore in progress
        // check that every primary shard is unassigned
                .actionGet()
            );
        assertThat(createSnapshotResponse.getSnapshotInfo().snapshotId().getName(), equalTo(snapshotName));
        assertEquals(indicesPerSnapshot.size(), response.getSnapshots().size());
                "should not be allowed to create a snapshot with the same name as an already existing snapshot: "
            assertThat(ExceptionsHelper.stackTrace(ex), containsString("Random IOException"));
     * */
        assertThat(indexIds.size(), equalTo(nbIndices));
        Client client = client();
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        assertThat(
                .prepareCreateSnapshot(repoName, snapshotName2)
        logger.info("--> checking snapshot status for all currently running and snapshot with empty repository");
        );
            SnapshotsStatusResponse snapshotsStatusResponse = clusterAdmin().prepareSnapshotStatus("test-repo")
            ClusterState clusterState = client.admin().cluster().prepareState().get().getState();
            response = clusterAdmin().prepareGetSnapshots("test-repo").setSnapshots("test-snap-" + i).setVerbose(false).get();
        logger.info("--> snapshot");
                    + createSnapshotResponse.getSnapshotInfo().snapshotId()
        logger.info("--> restore corrupt index");
        final Path repo = randomRepoPath();
            prepareCreate(index, 1, Settings.builder().put("number_of_shards", numPrimaries).put("number_of_replicas", numReplicas))
            TimeUnit.MILLISECONDS
            }
        createIndexWithRandomDocs("test-idx-3", 100);
        final int expectedCount;
            equalTo(restoreSnapshotResponse.getRestoreInfo().totalShards())
                assertThat(getFailureCount("test-repo"), greaterThan(0L));
            }
                    .indices()
        );
        assertThat(
        }
                .setSnapshots("test-2")
        );
        assertAcked(startDeleteSnapshot(repoName, snapshotToDelete).get());
            // test that we can take a snapshot after a failed one, even if a partial index-N was written
        createIndex("test-idx-1", "test-idx-2");
            .setIndices(indexName)
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotIndexStatus;
        final Index index = resolveIndex(indexName);
                .get(0);
        SnapshotInfo snapshotInfo = waitForCompletion("test-repo", "test-snap", TimeValue.timeValueSeconds(600));
        assertFileCount(repo, numberOfFiles[0]);
    }
                .prepareSnapshotStatus("test-repo")
            "test-repo",
            .prepareRestoreSnapshot("test-repo", "test-snap")
                    .put(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(), throttleRestoreViaRecoverySettings ? "10k" : "0")
        indexRandomDocs("test", randomIntBetween(10, 100));
            .actionGet();
    }
        logger.info("--> delete index");
        Client client = client();
                .isEmpty(),
        final int numDocs = randomIntBetween(1, 5);
        createRepository("test-repo", "fs", repositoryLocation);
    public void testMoveShardWhileSnapshotting() throws Exception {
        final int nbDocs = scaledRandomIntBetween(10, 100);
            .actionGet();
                .setWaitForCompletion(true)
            .put("random_data_file_io_exception_rate", 1.0)
                client.admin().cluster().prepareDeleteSnapshot("test-repo", new String[] { "test-snap-" + i }).get();
        }
            .execute()
                restoreSnapshotResponse.getRestoreInfo().successfulShards(),
public class SharedClusterSnapshotRestoreIT extends AbstractSnapshotIntegTestCase {
                for (SnapshotShardFailure shardFailure : createSnapshotResponse.getSnapshotInfo().shardFailures()) {
        client().admin().indices().prepareClose("test-idx-1", "test-idx-2").get();
                .setSnapshots("test-1")
            repo,
        }
        createSnapshot("test-repo", "test-snap", Collections.singletonList("test-idx"));
            .setIndices("test-idx")
 *    http://www.apache.org/licenses/LICENSE-2.0
        createSnapshot(repositoryName, snapshotName, Collections.singletonList(indexName));
                assertThat(createSnapshotResponse.getSnapshotInfo().shardFailures().size(), greaterThan(0));
            snapshotToDelete = "snap-2";
            final List<String> expected = snapshotInfo.indices();
            .execute()
            "test-repo",
        final String[] indicesToSnapshot = { "test-idx-*", "-test-idx-3" };
        // attempt to restore the snapshot with the given settings
        logger.info("--> done");
        {
            waitForBlockOnAnyDataNode("test-repo", TimeValue.timeValueMinutes(1));
        }
                } catch (SnapshotInProgressException e) {
                }
        assertBusy(
    }
                    assertThat(shardFailure.reason(), endsWith("; nested: IOException[Random IOException]"));
        for (int i = 0; i < 100; i += 2) {
        assertDocCount("test-idx-3", 50L);
        assertThat(restoreSnapshotResponse.getRestoreInfo().successfulShards(), greaterThan(0));
            assertThat(snapshotInfo.totalShards(), greaterThan(snapshotInfo.successfulShards()));
        // create a gap in the sequence numbers
        }
            if (createSnapshotResponse.getSnapshotInfo().totalShards() == createSnapshotResponse.getSnapshotInfo().successfulShards()) {
            .setWaitForCompletion(true)
        assertThat(snapshotStatus.includeGlobalState(), equalTo(false));
            assertThat(snapshotPause, greaterThan(0L));
            // only 1 data node: a shard failed because of the random IO exceptions
        logger.info("--> restore index");
            new BytesRef(Files.readAllBytes(repoPath.resolve(BlobStoreRepository.INDEX_LATEST_BLOB)))
        IndexRoutingTable indexRoutingTable = clusterState.getRoutingTable().index(index);
        createRepository("test-repo", "fs");
        }
                .prepareCreateSnapshot("readonly-repo", "test-snap-2")
        logger.info("--> done");
            RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot(repoName, snapName)
        );
        allowNodes("test-idx", 1);
            assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
        assertAcked(client.admin().indices().prepareDelete(indexName).get());
import java.util.Map;
            .put("location", randomRepoPath())
    public void testSnapshotFileFailureDuringSnapshot() throws InterruptedException {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
import org.opensearch.OpenSearchException;
        if (randomBoolean()) {
import java.util.concurrent.ExecutionException;
            .setWaitForCompletion(false)
import org.opensearch.index.engine.EngineTestCase;
            .setWaitForCompletion(true)
                    numberOfFailures++;
            .get()
            fail(
    public void testIndexLatestFailuresIgnored() throws Exception {
        // create a snapshot
        assertAcked(client.admin().indices().prepareDelete("test-idx-*").get());
                .put("use_lucene_corruption", true)
            assertThat(snapshotsStatusResponse.getSnapshots().size(), equalTo(1));
        }
        logger.info("--> creating {} snapshots ", numberOfSnapshots);
            for (SnapshotShardFailure shardFailure : createSnapshotResponse.getSnapshotInfo().shardFailures()) {
        // cluster states to process in their queue when the test is finished
            restoreIndexSettings,
                try {
        createRepository(
        assertThat(
import static org.hamcrest.Matchers.endsWith;
    public void testSingleGetAfterRestore() throws Exception {
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
        unblockNode(repo, blockedNode);
                .setIndices("hid*")
        cluster().wipeIndices("test-idx");
                SnapshotInfo snapshotInfo = getSnapshot("test-repo", "test-snap");
            }
        );
        );
        indexRandom(
            .setIndices("test-idx")
            .setIgnoreUnavailable(true)
        logger.info("--> delete index");
            client().prepareDelete("test-idx-1", Integer.toString(i)).get();
        assertAcked(startDeleteSnapshot("test-repo", snapshotInfo.snapshotId().getName()).get());
        final int numSnapshots = randomIntBetween(1, 10);
        boolean throttleRestoreViaRecoverySettings = throttleRestore && randomBoolean();
        logger.info("--> snapshot");
        createSnapshot("test-repo", "test-snap", Collections.singletonList("test-idx"));
                }
        assertTrue(newIndexUUID, newIndexUUID != null);
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
            .setWaitForCompletion(true)
            .setWaitForCompletion(true)
            .cluster()
                .prepareGetSnapshots("test-repo")
            .prepareRestoreSnapshot("test-repo", "test-snap")
                .setIndices("test-idx")
 * The OpenSearch Contributors require contributions made to
        assertThat(ex.getSnapshotName(), equalTo("test-snap-2"));
            .get();
            .cluster()
                assertThat(shardFailure.nodeId(), notNullValue());
        assertThat(stateResponse.getState().metadata().index("test-idx-closed").getState(), equalTo(IndexMetadata.State.CLOSE));
     * Test that restoring a snapshot whose files can't be downloaded at all is not stuck or
        assertAcked(client.admin().indices().prepareClose("test-idx-closed").setWaitForActiveShards(ActiveShardCount.ALL));
            repoName,
            }
    public void testDataFileFailureDuringRestore() throws Exception {
    }
        logger.info("--> execution will be blocked on all data nodes");
            assertThat(cause, notNullValue());
            "mock",
            () -> clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap").setWaitForCompletion(true).setIndices("test-idx").get()
        assertAcked(client().admin().indices().prepareDelete(nbDocsPerIndex.keySet().toArray(new String[0])));
        logger.info("--> replace mock repository with real one at the same location");
            snapshotToRestore = "snap-1";
            Settings.EMPTY,
            ShardId shardId = shardStats.getShardRouting().shardId();
            .build();
            logger.info("--> unblock all data nodes");
        final String normalIndex = "normal-index";
    }
            .put("random", randomAlphaOfLength(10))
            .prepareRestoreSnapshot("test-repo", "test-snap")
        try {
            "mock",
     * This test ensures that when a shard is removed from a node (perhaps due to the node
        );
        assertTrue(shardStats.getShardRouting().primary());
        CreateSnapshotResponse createSnapshotResponse = client.admin()
            .get();
            assertThat(clusterState.getMetadata().hasIndex(dottedHiddenIndex), equalTo(true));
        }
        if (randomBoolean()) {
        for (ShardStats shardStats : client().admin().indices().prepareStats(indicesToSnapshot).clear().get().getShards()) {
        final String repoName = "test-repo";
            if (shardStatus.getStage() == SnapshotIndexShardStage.STARTED) {
        assertThat(client().prepareGet(restoredIndexName, docId).get().isExists(), equalTo(true));
        } else {
    }
        final SnapshotInfo snapshot1 = createFullSnapshot(repoName, "snap-1");
                    assertThat(snapshotInfo.totalShards(), greaterThan(snapshotInfo.successfulShards()));
            .setPartial(false)
                .put("chunk_size", randomIntBetween(1000, 10000), ByteSizeUnit.BYTES)
        try (SeekableByteChannel outChan = Files.newByteChannel(snapshotPath, StandardOpenOption.WRITE)) {
        for (int i = 10; i < 20; i++) {
        createIndex(indexName, settings);
        // Wait for the shards to be assigned
        try {
            Settings.builder()
                .put("compress", randomBoolean())
            .prepareCreateSnapshot(repoName, snapName)
            restoreFut = client.admin().cluster().prepareRestoreSnapshot(repoName, snapshotName).setWaitForCompletion(true).execute();
            "fs",
            .get();
                .prepareGetSettings("test-idx-1")
        refresh();
            client().prepareIndex("test-idx-1").setSource("foo", "bar"),
        logger.info(
        int numberOfFilesBeforeDeletion = numberOfFiles(repo);
        logger.info("--> wait for restore to finish");
        }
        final IndexId corruptedIndex = randomFrom(indexIds.values());
        logger.info("--> restore one index after deletion");
            logger.info("--> no failures");
        flushAndRefresh();
            .setWaitForCompletion(true)
                } else {
        OpenSearchIntegTestCase.putRepository(clusterAdmin(), "test-repo", "mock", false, settings);
        createRepository(
        assertThat(snapshotStatus.getState(), equalTo(State.STARTED));
        indexRandomDocs(indexName, nbDocs);
        createRepository("test-repo", "mock");
    }
        logger.info("--> capturing history UUIDs");
            }
        createRepository("test-repo", "fs", repositoryLocation);
    public void testDeletionOfFailingToRecoverIndexShouldStopRestore() throws Exception {
            assertThat(ex.getMessage(), containsString("trying to modify or unregister repository that is currently used"));
        assertEquals(1, response.getSnapshots().size());
                checkUnassignedInfo.accept(shard.unassignedInfo());
import org.opensearch.core.index.shard.ShardId;
                assertThat(getFailureCount("test-repo"), greaterThan(0L));
    /**
import static org.hamcrest.Matchers.not;
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        // Pick one node and block it
        for (int i = 50; i < 100; i++) {
        response = client.admin().cluster().prepareSnapshotStatus().execute().actionGet();
            // operation is scheduled, but the RestoreInProgressAllocationDecider will
        String blockedNode = blockNodeWithIndex(repo, index);
        logger.info("--> creating repository");
        disableRepoConsistencyCheck("This test does not create any data in the repository");
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
            }
        clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
        } catch (Exception ex) {
        {
                assertThat(shardStatus.getNodeId(), notNullValue());
        client.admin()
            .get();
        logger.info("--> creating random number of snapshots");
            .execute()
        assertThat(response.getSnapshots().size(), equalTo(0));
        assertThat(snapshotInfos.get(0).state(), equalTo(SnapshotState.SUCCESS));
        Client client = client();
    public void testDeleteRepositoryWhileSnapshotting() throws Exception {
        unblockNode("test-repo", blockedNode);
            refresh();
        assertTrue(shardStats.getShardRouting().primary());
     * <p>
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
            .prepareCreateSnapshot("test-repo", "test-snap-2")
        logger.info("--> waiting for block to kick in");
            "mock",
import org.opensearch.repositories.RepositoriesService;
        );
        indexRandomDocs("test-idx", 100);
        for (SnapshotInfo snapshotInfo : response.getSnapshots()) {
 * not use this file except in compliance with the License.
        assertAcked(
        // Verify that hidden indices can be restored with a non-star pattern
        ensureGreen();
                .put("location", repositoryLocation)
            .cluster()
    }
                .put("random_data_file_io_exception_rate", 1.0) // Fail completely
        indexRandomDocs(hiddenIndex, 100);
            .cluster()
            .setIgnoreUnavailable(true)
        ActionFuture<CreateSnapshotResponse> future = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap")
            final Throwable rootCause = new OpenSearchException(cause).getRootCause();
        logger.info("--> waiting for completion");
        createRepository("test-repo", "fs");
        createRepository(
            assertAcked(clusterAdmin().prepareReroute().setRetryFailed(true));
        indexRandomDocs("test-idx", 100);
        );
            .actionGet();
        }
            client().prepareDelete("test-idx-3", Integer.toString(i)).get();
    }
            assertThat(
        final SnapshotInfo snapshotInfo = createSnapshot("test-repo", "test-snap", Collections.singletonList(indexName));
            .get()
            .get()
            fail("shouldn't be able to delete in-use repository");
                .put("random", randomAlphaOfLength(10))
        final Path repoPath = randomRepoPath();
            2,
        } else {
        // Pick one node and block it
                assertThat(shard.unassignedInfo().getLastAllocationStatus(), equalTo(UnassignedInfo.AllocationStatus.DECIDERS_NO));
            "cannot create snapshot in a readonly repository"
        assertThat(getSnapshot("test-repo", "test-snap").state(), equalTo(SnapshotState.SUCCESS));
        }
        assertDocCount("restored-1", docCount);
import org.opensearch.cluster.routing.RecoverySource;
        logger.info("--> snapshot");
        assertThat(ex.getMessage(), containsString("failed to read global metadata"));
                assertHitCount(client().prepareSearch(entry.getKey()).setSize(0).get(), entry.getValue().longValue());
        createIndex(indexName, Settings.builder().put("index.number_of_shards", initialShardCount).build());
                .setIndices(dottedHiddenIndex)
            snapshotToRestore = "snap-2";
                index(randomFrom(indices), "_doc", Integer.toString(i * 10 + j), "foo", "bar" + i * 10 + j);
            assertThat(restorePause, greaterThan(0L));
        client.admin().cluster().prepareCreateSnapshot("test-repo", "test-snap").setWaitForCompletion(false).setIndices("test-idx").get();
            .setRenamePattern(indexName)
    @Override
        SnapshotsStatusResponse snapshotStatusResponse = clusterAdmin().prepareSnapshotStatus(repoName).setSnapshots(snapshotName).get();
        waitForIndex("test-idx", TimeValue.timeValueSeconds(10));
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(0));
        final String snapshotToDelete;
            .setRenameReplacement("restored-1")
                .getSnapshots()
            nbDocsPerIndex.put(indexName, nbDocs);
            .cluster()
                .get()
        assertThat(createSnapshotResponse.getSnapshotInfo().shardFailures().size(), equalTo(0));
        createRepository(repositoryName, "fs");
            assertEquals(1, clusterStateResponse.getState().getNodes().getDataNodes().size());
        assertDocCount("test-idx-3", 50L);
            .setWaitForCompletion(true)
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
            assertThat(clusterState.getMetadata().hasIndex(hiddenIndex), equalTo(true));
            .setCurrentSnapshot()
        final String snapName = "test-snap";
        logger.info("--> verify doc counts");
            .setWaitForCompletion(true)
package org.opensearch.snapshots;
import org.opensearch.action.admin.indices.flush.FlushResponse;
                .get()
                .cluster()
        // is completed and marked as failed, which can lead to nodes having pending
                .setIndices("test-idx"),
            .setWaitForCompletion(true)
            .get();
        logger.info("--> wait for snapshot to complete");
                .addSnapshots("_current")
            .get();
        assertAllSuccessful(refresh());
        createIndex(hiddenIndex, indexSettingsNoReplicas(randomIntBetween(1, 3)).put(IndexMetadata.SETTING_INDEX_HIDDEN, true).build());
    }
            // Finish flush
                .get(0);
    public void testCloseIndexDuringRestore() throws Exception {
        Settings.Builder settings = Settings.builder().put("location", repositoryLocation.resolve("test"));
            .setIndexSettings(restoreIndexSettings)
                .get()
        final MockRepository repository = (MockRepository) internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class)
import org.opensearch.ExceptionsHelper;
        logger.info("--> restore index");
            logger.info("--> some failures");
        assertTrue(response.getSnapshots().isEmpty());
        logger.info("--> waiting for block to kick in");
