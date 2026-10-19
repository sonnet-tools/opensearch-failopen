        restoreResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap").setWaitForCompletion(true).get();
        logger.info("--> delete indices");  
        try {
        ensureGreen();  
        Path repo = randomRepoPath();
            .setWaitForCompletion(true)
        assertThat(stateResponse.getState().routingTable().index("test-idx-closed"), notNullValue());
        logger.info(
        assertFileCount(repo, numberOfFiles[0]);
            .cluster()
                restoreInfo.failedShards(),  
            for (SnapshotShardFailure shardFailure : createSnapshotResponse.getSnapshotInfo().shardFailures()) {  
        assertThat(snapshotStatus.getState(), equalTo(State.STARTED));
    public void testSnapshotStatus() throws Exception {  
        }  
        createIndex(
        createIndexWithRandomDocs("test-idx", 100);
        assertAcked(  
        for (int i = 50; i < 100; i++) {
            refresh();
        logger.info("--> snapshot");  
            .setIndices(indexName)
            assertThat(snapshotInfo.shardFailures().size(), greaterThan(0));  
        logger.info("--> trying to move repository to another location");  
    }
 * Modifications Copyright OpenSearch Contributors. See
        blockAllDataNodes("test-repo");
        final Settings restoreIndexSettings,
            client.admin().cluster().prepareDeleteSnapshot("readonly-repo", "test-snap"),  
        Client client = client();  
        final String snapshotToDelete;  
    }  
            }
        String newAfterRestoreIndexUUID = client().admin()
            .cluster()  
                .prepareCreateSnapshot("test-repo", "test-snap")
        String newIndexUUID = client().admin()
        final SnapshotInfo snapshotInfo = createFullSnapshot(repoName, snapshotName);  
        assertDocCount("restored-2", newDocCount);
        Path repositoryLocation = randomRepoPath();
            .setWaitForCompletion(false)
                    assertThat(shardFailure.reason(), containsString("Random IOException"));
            ClusterState clusterState = client.admin().cluster().prepareState().get().getState();  
        createSnapshot(repositoryName, snapshotName, Collections.singletonList(indexName));
                .put("max_snapshot_bytes_per_sec", throttleSnapshot ? "10k" : "0")
            assertThat(shardStats.getShardRouting() + " doesn't have a history uuid", historyUUID, notNullValue());
    }  
        indexRandom(
    public void testCannotCreateSnapshotsWithSameName() throws Exception {
        createSnapshot("test-repo", "test-1", Collections.singletonList("test"));
    public void testReadonlyRepository() throws Exception {
            String historyUUID = shardStats.getCommitStats().getUserData().get(Engine.HISTORY_UUID_KEY);  
            .setWaitForCompletion(true)
            .setIndices(indexName)
        indexRandomDocs(indexName, docCount);  
            .cluster()  
                .setWaitForCompletion(true)
        assertAcked(prepareCreate(indexName, Settings.builder().put(createIndexSettings)));  
            boolean atLeastOne = false;  
            .setRestoreGlobalState(randomBoolean())
import org.opensearch.common.action.ActionFuture;
        assertEquals("test-snap", response.getSnapshots().get(0).getSnapshot().getSnapshotId().getName());
        assertEquals(getRepositoryData(repoName).getGenId(), repoGenInIndexLatest);  
                    "test-repo",
        boolean throttleSnapshot = randomBoolean();
        OpenSearchIntegTestCase.putRepository(clusterAdmin(), "test-repo", "mock", settings);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        final SnapshotInfo snapshotInfo = createSnapshot("test-repo", "test-snap", Collections.singletonList(indexName));
                .execute()
        assertThat(response.getSnapshots().size(), equalTo(1));
                .state(),  
        // we have to delete the index here manually, otherwise the cluster will keep
        assertAcked(prepareCreate("test-idx", 2, Settings.builder().put("number_of_replicas", 0)));
    }
        Client client = client();
        try {
            if (!indicesToFlush.isEmpty()) {  
            .setWaitForCompletion(true)  
                .put("random_data_file_io_exception_rate", 0.3)  
                if (shardStatus.getStage() == SnapshotIndexShardStage.FAILURE) {  
        assertThat(createSnapshotResponse.getSnapshotInfo().totalShards(), equalTo(0));
            .setWaitForCompletion(true)
        final int numberOfSnapshots = between(5, 15);
                .prepareSnapshotStatus("test-repo")
            for (SnapshotIndexShardStatus status : shards) {
        final String repoName = "test-repo";
        assertThat(indexStatus, notNullValue());
            for (int i = 1; i < numberOfSnapshots - 1; i++) {
        // Truncate the index metadata file
        );
            restoreFut = client.admin().cluster().prepareRestoreSnapshot("test-repo", "test-snap").setWaitForCompletion(true).execute();
            "test-repo",  
        unblockNode("test-repo", blockedNode);
            "Number of failed shards [{}]",
    }
            .put("random_control_io_exception_rate", randomIntBetween(5, 20) / 100f)
        );  
        logger.info("Number of failed shards [{}]", snapshotInfo.shardFailures().size());  
        clusterAdmin().prepareCreateSnapshot(repo, snapshot).setWaitForCompletion(false).execute();  
        ensureGreen();
        List<SnapshotInfo> snapshotInfos = clusterAdmin().prepareGetSnapshots("test-repo")
                }
        createIndexWithRandomDocs("test-idx-2", 100);
            for (int j = 0; j < numIndices; j++) {
            .actionGet();  
        createFullSnapshot(repoName, "snapshot-2");
        }
        assertThat(getSnapshot("test-repo", "test-snap").state(), equalTo(SnapshotState.SUCCESS));
        createRepository("test-repo", "fs", repositoryLocation);  
import java.nio.channels.SeekableByteChannel;  
        logger.info("-->  creating repository");
    public void testFreshIndexUUID() {
            timeout.millis(),  
        logger.info("--> snapshot");
            .setIgnoreUnavailable(true)
public class SharedClusterSnapshotRestoreIT extends AbstractSnapshotIntegTestCase {  
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        cluster().wipeIndices("test-idx");
            .setIndices(nbDocsPerIndex.keySet().stream().filter(isRestorableIndex).toArray(String[]::new))
        createRepository("test-repo", "fs", repositoryLocation);  
    /**
        assertThat(snapshotInfo.version(), equalTo(Version.CURRENT));
            .setIgnoreUnavailable(true)
        logger.info("-->  creating index that cannot be allocated");  
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();  
            assertThat(indexStatus, notNullValue());
        }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;  
        createSnapshotResponse = client.admin()  
                .actionGet();  
                .execute()  
import org.opensearch.core.index.Index;
            "mock",
        final Settings repositorySettings,  
                .get()
            }  
            assertThat(restoreSnapshotResponse.getRestoreInfo().indices(), containsInAnyOrder(normalIndex, hiddenIndex));  
            assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
            waitForBlockOnAnyDataNode("test-repo", TimeValue.timeValueMinutes(1));
            "mock",
    }  
            assertThat(cause, notNullValue());
        }
                if (randomBoolean()) {
        logger.info("--> restoring working repository");
import java.util.ArrayList;
        createRepository(  
            // during restore and then we don't allow the shard to be assigned on the
            final Throwable cause = ex.getCause();
                .put("compress", false)
        cluster().wipeIndices("test-idx");  
            ShardId shardId = shardStats.getShardRouting().shardId();  
                .put("random_data_file_io_exception_rate", 1.0) // Fail completely
            assertDocCount("test-idx", 100L);
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        Settings.Builder settings = Settings.builder().put("location", repoPath);  
        assertEquals(0, createSnapshotResponse.getSnapshotInfo().failedShards());
            // index some additional docs (maybe) for each index
        ensureGreen();
    }  
        }  
                indexSettingsNoReplicas(1)
        logger.info("--> snapshot with potential I/O failures");  
        logger.info("--> creating index");  
            .actionGet();  
            .prepareRestoreSnapshot("test-repo", "test-snap")  
            client.admin()
import java.nio.file.Path;
                .put("readonly", true)  
        logger.info("--> delete index");  
        assertThat(snapshotInfo.successfulShards(), equalTo(numShards.numPrimaries));  
        index(indexName, MapperService.SINGLE_MAPPING_NAME, docId, "value", expectedValue);
            Settings.builder()  
                    .build()
            SnapshotMissingException.class,
        assertRequestBuilderThrows(  
     * Test that restoring an index with shard allocation filtering settings that prevents
                .cluster()
        logger.info("--> delete index before restoring");
            .execute()
    }
        logger.info("--> restoring snapshot [{}]", snapshotToRestore);
    public void testBasicWorkFlow() throws Exception {
        final Path globalStatePath = repo.resolve("meta-" + snapshotInfo.snapshotId().getUUID() + ".dat");
        final Map<String, Integer> nbDocsPerIndex = new HashMap<>();  
        // Test restore after index deletion
            try {
        }
            .getSetting("test", IndexMetadata.SETTING_INDEX_UUID);
            final String snapshotName = "test-snap-" + i;
            SnapshotsStatusResponse snapshotsStatusResponse = clusterAdmin().prepareSnapshotStatus("test-repo")
        createIndexWithRandomDocs("test-idx-3", 100);
            .cluster()
            );
            .get()
            2,  
        final String indexName = "test-idx";
            } else {
        {  
        assertThat(
        final String snapshotName2 = "test-snap-2";  
            .setClusterManagerNodeTimeout("30s")
            .get()  
        logger.info("--> creating repository");  
            .actionGet();
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));  
        Settings.Builder settings = Settings.builder().put("location", repositoryLocation).put(repositorySettings);  
import org.apache.lucene.util.BytesRef;
        assertThat(ex.getSnapshotName(), equalTo("test-snap-2"));
        );
                .getSetting("test-idx-1", MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey())
            Settings.builder().put("location", repositoryLocation).put("random", randomAlphaOfLength(10)).put("wait_after_unblock", 200)  
        logger.info("--> total number of simulated failures during restore: [{}]", getFailureCount("test-repo"));
            .actionGet();
            repoName,  
            .setRenamePattern(indexName)  
                }  
                .put("compress", randomBoolean())
        assertThat(snapshotInfos.size(), equalTo(1));  
        // test that getting an unavailable snapshot status does not throw an exception if ignoreUnavailable is true on the request  
        }
        final Map<String, List<String>> indicesPerSnapshot = new HashMap<>();
                    client().admin().indices().prepareDelete("test-idx-1").get();  
    }  
            equalTo(restoreSnapshotResponse.getRestoreInfo().failedShards())
import java.util.concurrent.TimeUnit;
    public void testListCorruptedSnapshot() throws Exception {  
            for (SnapshotIndexShardStatus shardStatus : indexStatus.getShards().values()) {
            if (historyUUIDs.containsKey(shardId)) {
        OpenSearchIntegTestCase.putRepository(client.admin().cluster(), "test-repo", "mock", false, settings);
            assertThat(getFailureCount("test-repo"), greaterThan(0L));
 * The OpenSearch Contributors require contributions made to  
        ).setWaitForActiveShards(ActiveShardCount.NONE).get();
                .get()
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
                index(randomFrom(indices), "_doc", Integer.toString(i * 10 + j), "foo", "bar" + i * 10 + j);  
            .setWaitForCompletion(true)
        logger.info("--> check that all shards were recovered");  
                .actionGet()  
            indicesPerSnapshot.put(snapshotName, indices);  
        createFullSnapshot(repoName, "snapshot-1");  
    }
            index(indexName, "_doc", Integer.toString(i), "foo", "bar" + i);
            .setWaitForCompletion(true)  
        final NumShards numShards = getNumShards("test-idx");  
            assertThat(snapshotPause, greaterThan(0L));
            .getSnapshots();
                () -> clusterAdmin().prepareDeleteSnapshot(repoName, snapshotName).get()  
            restoreFut = client.admin().cluster().prepareRestoreSnapshot(repoName, snapshotName).setWaitForCompletion(true).execute();
            .get();
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), equalTo(0));
import org.opensearch.repositories.RepositoryData;
        createRepository("test-repo", "fs");  
            waitForCompletion("test-repo", "test-snap", TimeValue.timeValueSeconds(600)).shardFailures().size()
        createRepository("test-repo", "fs");  
        disableRepoConsistencyCheck("This test intentionally leaves an empty repository");  
        String originalIndexUUID = client().admin()
        assertThat(snapshotInfos.get(0).snapshotId().getName(), equalTo("test-snap"));  
        );
                .setIndices(indexName)
                .put("max_failure_number", 10000000L)  
import org.opensearch.action.index.IndexRequestBuilder;
                .setWaitForCompletion(true)
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
                .put("location", repo)  
                ConcurrentSnapshotExecutionException.class,
        logger.info("--> delete index");  
        try {
import org.opensearch.cluster.RestoreInProgress;  
            Settings.builder().put("location", randomRepoPath()).put("random", randomAlphaOfLength(10)).put("wait_after_unblock", 200)
            .setCurrentSnapshot()
            String historyUUID = shardStats.getCommitStats().getUserData().get(Engine.HISTORY_UUID_KEY);
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
            RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot(repoName, snapName)  
                .get()  
                assertThat(status.getStats().getProcessedFileCount(), equalTo(0));
            .get();
            assertAcked(client().admin().indices().prepareOpen(indicesToSnapshot).setWaitForActiveShards(ActiveShardCount.ALL).get());  
    }  
        createRepository("test-repo", "fs");
            assertEquals(1, response.getSnapshots().size());
        final String snapName = "test-snap";
        createRepository("test-repo", "fs", repositoryLocation);  
            logger.info("--> waiting for block to kick in");  
        if (throttleSnapshot) {  
        final SnapshotInfo snapshotInfo = getSnapshot("test-repo", "test-snap");
            assertThat(rootCause, notNullValue());
    /**  
            }
        logger.info("-->  update repository with mock version");  
        logger.info("--> done");
            .setWaitForCompletion(true)  
        logger.info("--> wait for relocations to start");  
    public void testSnapshotSucceedsAfterSnapshotFailure() throws Exception {  
            .setIndices("test-idx")
        logger.info("--> capturing history UUIDs");  
            waitForBlockOnAnyDataNode(repoName, TimeValue.timeValueMinutes(1));
            if (isRestorableIndex.test(entry.getKey())) {
            )  
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
            // operation is scheduled, but the RestoreInProgressAllocationDecider will
        long snapshotPause = 0L;
import org.opensearch.transport.client.Client;
            assertThat(clusterState.getMetadata().hasIndex(normalIndex), equalTo(false));
            .get();
            assertAcked(client().admin().indices().prepareClose(indicesToSnapshot).setWaitForActiveShards(ActiveShardCount.ALL).get());
        logger.info("--> execution will be blocked on all data nodes");
            .setRenameReplacement(restoredIndexName)  
        final String snapshotName = "test-snap";
            client().prepareDelete("test-idx-1", Integer.toString(i)).get();
        assertFalse(newIndexUUID, newIndexUUID.equals(originalIndexUUID));
        logger.info("--> unblocking blocked node");
            .prepareRestoreSnapshot("test-repo", "test-snap")  
        createIndex("test-idx-1", "test-idx-2", "test-idx-3");
                .put("block_on_data", true)
    public void testGetSnapshotsFromIndexBlobOnly() throws Exception {
    }
        ensureGreen();  
                assertThat(shardFailure.index(), equalTo("test-idx"));
                .cluster()  
                createSnapshotResponse.getSnapshotInfo().successfulShards(),  
                    }
        assertThat(shardStats.getSeqNoStats().getGlobalCheckpoint(), equalTo(10L));
        final SnapshotInfo snapshotInfo = getSnapshot("test-repo", "test-snap");
        createRepository("test-repo", "fs", repositoryLocation);
        createRepository(
        client().admin().indices().prepareUpdateSettings("test-idx").setSettings(excludeSettings).get();  
            prepareCreate("test-idx").setSettings(
        Client client = client();  
                for (SnapshotShardFailure shardFailure : createSnapshotResponse.getSnapshotInfo().shardFailures()) {
        }
            .prepareCreateSnapshot("test-repo", "test-snap")  
        );
                .getSnapshotInfo()
                documents[j] = client.prepareIndex(indexName).setSource("foo", "bar");
            .put("random", randomAlphaOfLength(10));  
            // If we are here, that means we didn't have any failures, let's check it  
            if (shardStatus.getStage() == SnapshotIndexShardStage.STARTED) {
import org.opensearch.ExceptionsHelper;
            .cluster()
        for (int i = 0; i < numberOfSnapshots; i++) {
                .setWaitForCompletion(true)
        }
            assertThat(snapshotPause, equalTo(0L));  
        final Path repositoryLocation = randomRepoPath();  
 * You may obtain a copy of the License at  
            }
        assertFalse(newIndexUUID, newIndexUUID.equals(IndexMetadata.INDEX_UUID_NA_VALUE));
        Client client = client();  
        EngineTestCase.generateNewSeqNo(getEngine(primary));
        indexRandomDocs(hiddenIndex, 100);  
            .execute()  
            }
            .get();
        );  
        logger.info("--> delete indices");
        disableRepoConsistencyCheck("This test uses a purposely broken repository so it would fail consistency checks");
        assertDocCount("test-idx-2", 50L);  
    public void testThrottling() throws Exception {
            createSnapshot("test-repo", "test-snap-" + i, Collections.singletonList("test-idx"));  
    /**  
            );
    }
                .put("location", randomRepoPath())  
            fail("shouldn't be able to replace in-use repository");
            assertThat(clusterState.getMetadata().hasIndex(hiddenIndex), equalTo(false));  
            .prepareRestoreSnapshot("test-repo", "test-snap")  
                assertThat(getFailureCount("test-repo"), greaterThan(0L));  
        {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            }
        assertAcked(client.admin().indices().prepareDelete(indexName));
        logger.info("--> snapshot");  
        final int numSnapshots = randomIntBetween(1, 10);
                SnapshotInfo snapshotInfo = getSnapshot("test-repo", "test-snap");  
        final String snapshotName = "test-snap";  
        createIndexWithRandomDocs("test-idx", 100);
        final String dottedHiddenIndex = ".index-hidden";  
    }
            assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
        assertDocCount("test-idx-3", 50L);
        final Consumer<UnassignedInfo> checkUnassignedInfo,
            .prepareRestoreSnapshot("test-repo", lastSnapshot)
            .prepareUpdateSettings()
 */  
                    .prepareUpdateSettings(indexName)
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())  
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;  
        SnapshotStatus snapshotStatus = response.getSnapshots().get(0);  
        // delete the test index
        refresh(indexName);
            assertThat(e.getMessage(), containsString("cannot delete snapshot during a restore"));
        );
        assertThat(
            for (int j = 0; j < numIndices; j++) {
            assertThat(indexStatus.getShardsStats().getFailedShards(), equalTo(snapshotInfo.failedShards()));  
import org.opensearch.cluster.routing.ShardRoutingState;
        logger.info("--> done");
        logger.info("--> delete some data");  
    @Override
        }  
                    .setSettings(Settings.builder().putNull("index.routing.allocation.include._name").build())
            );
        assertThat(snapshot2.successfulShards(), is(newShardCount));
        logger.info("--> creating an index and indexing documents");
        repository.setFailOnIndexLatest(false);
        logger.info("--> restore indices with different names");  
        createIndex("test");
        assertEquals(getRepositoryData(repoName).getGenId(), repoGenInIndexLatest3);  
            .setRenameReplacement("restored-3")
        assertNotNull("should be at least one node with a primary shard", nodeWithPrimary);  
        createRepository(repoName, "fs", absolutePath);
            .get();
        logger.info("--> snapshot");
        final Runnable fixUpAction  
        final SnapshotException sne = expectThrows(
 */
        createIndex("test-idx", "test-idx-closed");
        client.admin()
import static org.hamcrest.Matchers.is;  
            .prepareRestoreSnapshot("test-repo", "test-snap")
                .put("location", repositoryLocation)
        for (ShardRouting shard : clusterStateResponse.getState().getRoutingTable().allShards(indexName)) {
            .setRenamePattern(indexName)
            .actionGet();
        client.admin().cluster().prepareCreateSnapshot("test-repo", "test-snap").setWaitForCompletion(false).setIndices("test-idx").get();  
    public void testSnapshottingWithMissingSequenceNumbers() {
    }
        final String indexName = "test-idx";
            () -> clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap").setWaitForCompletion(true).setIndices("test-idx").get()  
            assertThat(unassignedInfo.getReason(), equalTo(UnassignedInfo.Reason.ALLOCATION_FAILED));
        assertThat(
    }
        assertThat(createSnapshotResponse.getSnapshotInfo().snapshotId().getName(), equalTo(snapshotName));
            .setWaitForCompletion(true)
        Client client = client();
        final Path repo = randomRepoPath();  
        cluster().wipeIndices("test-idx");  
        logger.info("--> deleting indices");
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(0));  
                .isEmpty(),
            // test that we can take a snapshot after a failed one, even if a partial index-N was written
                .addSnapshots("test-snap")
            .prepareSnapshotStatus("test-repo")  
        );
        final String[] indices = { "test-idx-1", "test-idx-2", "test-idx-3" };
        List<SnapshotInfo> snapshotInfos = client.admin()
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        );
            .prepareGetSettings("test-copy")
        final IndexShard primary = internalCluster().getInstance(IndicesService.class, dataNode).getShardOrNull(new ShardId(index, 0));  
        final SnapshotException ex = expectThrows(  
    public void testDeleteSnapshot() throws Exception {  
        assertThat(snapshotStatus.getShardsStats().getStartedShards(), greaterThan(0));
        logger.info("--> snapshot");
            RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot(repoName, snapName)
        assertTrue(response.getSnapshots().isEmpty());
                .setIndices("test-idx-*")
        final int nbDocs = scaledRandomIntBetween(10, 100);  
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
        indexRandomDocs("test-idx", 100);
        logger.info("--> restore all indices from the snapshot");  
        assertDocCount("test-idx", 100L);
        assertThat(ex.getRepositoryName(), equalTo("test-repo"));
        assertFalse(originalIndexUUID, originalIndexUUID.equals(IndexMetadata.INDEX_UUID_NA_VALUE));
import org.opensearch.cluster.routing.ShardRouting;  
                .setIndices(indexName)
        logger.info("--> trying to create a repository with different name");  
        // Pick one node and block it
        assertAcked(client().admin().indices().prepareDelete(indexName));  
import static org.opensearch.indices.recovery.RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING;
                .setWaitForCompletion(true)  
import static org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider.SETTING_ALLOCATION_MAX_RETRY;
        }  
        ShardStats shardStats = stats.getShards()[0];
        logger.info("--> verify doc counts");  
            } catch (IllegalArgumentException e) {
            SnapshotInfo snapshotInfo = getSnapshot("test-repo", "test-snap");
            "Number of failed shards [{}]",  
            .cluster()
        logger.info("--> delete index");
    public void testSingleGetAfterRestore() throws Exception {
        assertThat(getSnapshot("test-repo", "test-1").state(), equalTo(SnapshotState.SUCCESS));  
        logger.info("--> try creating a snapshot with the same name, now it should work because the first one was deleted");  
            .setIndices("test-idx")  
        // check that the shards have been created but are not assigned  
            .setIndicesOptions(IndicesOptions.lenientExpand())  
            .put(ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.getKey(), 0) // We have tests that check by-timestamp order  
        final String index = "test-idx";  
            );
    }
        assertAcked(startDeleteSnapshot("test-repo", snapshotInfo.snapshotId().getName()).get());
        assertThat(stateResponse.getState().metadata().index("test-idx-closed").getState(), equalTo(IndexMetadata.State.CLOSE));  
        // Create index on 2 nodes and make sure each node has a primary by setting no replicas
import org.opensearch.index.engine.EngineTestCase;
        );
                .get();  
        GetSnapshotsResponse response = clusterAdmin().prepareGetSnapshots("test-repo").setSnapshots("_all").setVerbose(false).get();
            .cluster()  
        Settings restoreIndexSettings = Settings.builder().put("index.routing.allocation.include._name", randomAlphaOfLength(5)).build();  
                .execute()
                fail("Expected closing index to fail during restore");  
            assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
            .setIndexSettings(restoreIndexSettings)  
                .setWaitForCompletion(true)
                    assertThat(shardFailure.nodeId(), notNullValue());  
        assertThat(clusterState.getMetadata().hasIndex("test-idx-1"), equalTo(true));
        createRepository("test-repo-2", "mock", repoPath);  
            .get()
     * file can still be used to restore the non corrupted indices
    public void testUnallocatedShards() {
        SnapshotInfo snapshotInfo = waitForCompletion("test-repo", "test-snap", TimeValue.timeValueSeconds(600));  
            refresh();
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
        CreateSnapshotResponse createSnapshotResponse = future.get();
        }
            }  
        final boolean snapshotClosed = randomBoolean();  
            .get()
            new BytesRef(Files.readAllBytes(repoPath.resolve(BlobStoreRepository.INDEX_LATEST_BLOB)))
        verifySnapshotInfo(response, indicesPerSnapshot);  
            .setIndices("test-idx-*", "-test-idx-2")  
            .put("random_control_io_exception_rate", 0.2);
            final Throwable rootCause = new OpenSearchException(cause).getRootCause();  
                .put("chunk_size", randomIntBetween(1000, 10000), ByteSizeUnit.BYTES)
            assertThat(indexStatus.getShards().size(), equalTo(snapshotInfo.totalShards()));
        final long repoGenInIndexLatest2 = BytesRefUtils.bytesToLong(
        // Create index on two nodes and make sure each node has a primary by setting no replicas  
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot(repoName, snapshotName)
            List<SnapshotIndexShardStatus> shards = snapshotStatus.getShards();  
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));  
        }
        );
        final Client client = client();
            1L,
        int numberOfFilesBeforeDeletion = numberOfFiles(repo);
        RestoreSnapshotResponse restoreSnapshotResponse = restoreFut.get();
        response = client.admin().cluster().prepareSnapshotStatus().execute().actionGet();
        assertThat(getSnapshot("test-repo", "test-2").state(), equalTo(SnapshotState.SUCCESS));
            .put("random", randomAlphaOfLength(10))
                .setWaitForCompletion(true)
 * GitHub history for details.
            logger.info("--> start restore");  
            for (int j = 0; j < 10; j++) {
            .setWaitForCompletion(true)
        Path repo = randomRepoPath();
        // that would mean that recovery process started and failing  
    }
        assertDocCount("test-idx", 10L * numberOfSnapshots);
        // Verify that hidden indices get restored with a wildcard restore
            .setWaitForCompletion(true)  
        assertThat(getResponse.getSnapshots().size(), equalTo(1));
        assertAcked(client.admin().indices().prepareDelete("test-idx-*").get());
        indexRandomDocs("test-idx", numDocs);
            }
                }
            .execute()  
        assertDocCount("restored-1", docCount);  
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())  
        // (available one should be returned)  
        );
            assertThat(
        );
        String copyRestoreUUID = client().admin()  
            assertAcked(
                equalTo(restoreSnapshotResponse.getRestoreInfo().totalShards())
            if (createSnapshotResponse.getSnapshotInfo().totalShards() != createSnapshotResponse.getSnapshotInfo().successfulShards()) {
        assertThat(snapshot1.successfulShards(), is(initialShardCount));  
            assertThat(snapshotStatus.getIndices().size(), equalTo(1));  
        unrestorableUseCase(
        logger.info("--> wait for snapshot to complete");
        }
        } finally {
        assertAcked(prepareCreate("test").setSettings(indexSettings));
        assertAcked(client().admin().indices().prepareDelete(indexName));  
    }
        try (SeekableByteChannel outChan = Files.newByteChannel(indexMetadataPath, StandardOpenOption.WRITE)) {
        assertDocCount("test-idx", 10L * numberOfSnapshots);
 * specific language governing permissions and limitations
                .getSnapshotInfo()
                    + createSnapshotResponse.getSnapshotInfo().snapshotId()
        logger.info("Path [{}]", absolutePath);
        client.admin()
            expectedCount = docCount;
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
                .get();
            .prepareGetSettings("test")  
     */
                }  
        logger.info("--> creating an index and indexing documents");
                    fail("Expected closing index to fail during snapshot");  
                assertThat(shardStats.getShardRouting() + " has a different history uuid", historyUUID, equalTo(historyUUIDs.get(shardId)));  
            client().admin()  
        // create a gap in the sequence numbers
                .indices()
            assertThat(createSnapshotResponse.getSnapshotInfo().shardFailures().size(), greaterThan(0));
        }
            }
        assertDocCount("test-idx", 100L);  
        final String repoName = "test-repo";  
        assertTrue(shardStats.getShardRouting().primary());
            .getSnapshots();
        CreateSnapshotResponse createSnapshotResponse = client.admin()  
        {
            assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));  
        logger.info("Path [{}]", absolutePath);
        logger.info("--> restore index after deletion");  
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
     * Tests that a snapshot of multiple indices including one with a corrupted index metadata
        ensureGreen();
        assertThat(getRepositoryData("test-repo"), is(RepositoryData.EMPTY));  
        );
            restorePause += repositoriesService.repository("test-repo").getRestoreThrottleTimeInNanos();  
    }  
        response = client.admin().cluster().prepareSnapshotStatus().execute().actionGet();
                } catch (SnapshotInProgressException e) {
        logger.info("--> restoring snapshot 2");  
            .getSetting("test-copy", IndexMetadata.SETTING_INDEX_UUID);
        if (restoreInfo.successfulShards() == restoreInfo.totalShards()) {
        indexRandomDocs("test-idx", 100);
     * does not hang indefinitely.
        waitForBlock(blockedNode, "test-repo", TimeValue.timeValueSeconds(60));  
        for (int i = 0; i < numSnapshots; i++) {  
                checkUnassignedInfo.accept(shard.unassignedInfo());  
import java.util.function.Consumer;  
        createRepository("test-repo", "fs");
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
            Settings.builder()
        logger.info(
    }  
            ClusterState clusterState = client.admin().cluster().prepareState().get().getState();
        }
                // triggering an IOException toward the end when writing the pending-index-* files, which are the files  
        );  
        final String repoName = "test-repo";  
                restoreSnapshotResponse.getRestoreInfo().successfulShards(),  
                .prepareGetSettings("test-idx-1")
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        logger.info("--> waiting for block to kick in");
            .setTransientSettings(
import static org.hamcrest.Matchers.hasSize;
    }
        assertThat(indexStatus.getShards().size(), equalTo(snapshotInfo.totalShards()));
            snapshotToDelete = "snap-1";
        logger.info("--> creating indices");
        logger.info("--> restore index");
            .setWaitForCompletion(true)  
        createRepository("test-repo", "fs");  
        createRepository(repositoryName, "fs");
            .execute()
            assertThat(clusterState.getMetadata().hasIndex(dottedHiddenIndex), equalTo(false));
        logger.info("--> creating random number of snapshots");  
    public void testRestoreSnapshotWithCorruptedGlobalState() throws Exception {  
        assertThat(snapshotStatus.getShardsStats().getStartedShards(), greaterThan(0));
            .setRenameReplacement("restored-1")
        // Wait for the shards to be assigned
                    for (int k = 0; k < numDocs; k++) {
            ShardId shardId = shardStats.getShardRouting().shardId();
        );  
                .addSnapshots("_current")
            .get();  
 * Unless required by applicable law or agreed to in writing,
            .setIndicesOptions(IndicesOptions.lenientExpand())
        String indexName = "testindex";
            client().prepareIndex("test-idx-1").setSource("foo", "bar"),  
        }
        );
        if (randomBoolean()) {  
        // is completed and marked as failed, which can lead to nodes having pending
        logger.info("--> creating random number of indices");  
            .setSnapshots(randomFrom("test-snap", "_all", "*", "*-snap", "test*"))  
import org.opensearch.action.admin.indices.flush.FlushResponse;
            client().prepareIndex("test-idx-2").setSource("foo", "bar"),
        logger.info("--> waiting for snapshot to finish");  
        logger.info("--> restore index");
        RestoreInProgress restoreInProgress = clusterStateResponse.getState().custom(RestoreInProgress.TYPE);
                }
import org.opensearch.Version;
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
        indexRandomDocs(index, 100);
        final Client client = client();
        ClusterStateResponse stateResponse = client.admin().cluster().prepareState().get();
        final int numDocs = randomIntBetween(1, 5);  
            "test-repo",
            .execute()
        } finally {
        if (randomBoolean()) {  
        // Choose a random index from the snapshot
        assertThat(getSnapshotsResponse.getSnapshots().size(), equalTo(1));
        String expectedValue = "expected";  
    public void testDataFileFailureDuringSnapshot() throws Exception {  
            .actionGet();  
    public void testSnapshotFileFailureDuringSnapshot() throws InterruptedException {
        IndicesStatsResponse stats = client().admin().indices().prepareStats(indexName).clear().get();  
                .setIndices("test-idx")  
                    indices.add("test-idx-" + j);
        );  
        try {
            assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
            .prepareCreateSnapshot(repositoryName, snapshotName)  
        indexRandom(  
                restoreSnapshotResponse.getRestoreInfo().successfulShards(),
        ensureGreen();  
        assertThat(
        assertAcked(client().admin().indices().prepareDelete("test-idx-1", "test-idx-2"));
import org.opensearch.indices.IndicesService;
        restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
            client().prepareIndex("test-idx-2").setSource("foo", "bar")
            () -> clusterAdmin().prepareRestoreSnapshot(repoName, snapshotName).setRestoreGlobalState(true).setWaitForCompletion(true).get()
            unblockAllDataNodes("test-repo");
            assertThat(restorePause, equalTo(0L));  
        logger.info("--> unblocking blocked node");
        assertThat(snapshotStatus.getIndices().size(), equalTo(1));  
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
            .prepareRestoreSnapshot("test-repo", "test-snap")
                String[] indices = indicesToFlush.toArray(new String[0]);
            .actionGet();
        assertThat(snapshotInfos.size(), equalTo(1));
        createRepository("test-repo", "fs", repositoryLocation);
            .addSnapshots("test-snap-doesnt-exist")
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot(repoName, snapshotName)  
        logger.info("--> snapshot");
        disableRepoConsistencyCheck("This test intentionally leaves a broken repository");
            String indexName = "test-idx-" + i;
        );
        logger.info("--> snapshot");
            .cluster()
        assertDocCount(indexName, nbDocs);  
            .get();
        logger.info("--> get snapshots request should return both snapshots");  
        logger.info("--> delete index");
        assertThat(  
        cluster().wipeIndices("test-idx");
        response = client.admin()
            assertThat(getFailureCount("test-repo"), greaterThan(0L));
            }
        logger.info("--> execution was blocked on node [{}], trying to delete repository", blockedNode);
import org.opensearch.cluster.routing.RecoverySource;
        createRepository(repositoryName, "fs");
        );  
            "mock",
        }  
            }  
        logger.info("--> try making another snapshot");
        assertThat(sne.getMessage(), containsString("Indices don't have primary shards"));
            .prepareCreateSnapshot("test-repo", "test-snap-1")
        createRepository(
                .put("location", randomRepoPath())
            .setIndices("test-idx-*")
        createRepository(
        assertThat(  
    }
                // If we are here, that means we didn't have any failures, let's check it
                assertThat(getFailureCount("test-repo"), equalTo(0L));  
import org.opensearch.repositories.RepositoriesService;  
            .setSnapshots(randomFrom(snapName, "_all", "*", "*-snap", "test*"))
                if (randomBoolean()) {  
            "This test uses a purposely broken repository implementation that results in leaking snap-{uuid}.dat files"  
        for (ShardStats shardStats : client().admin().indices().prepareStats(indicesToSnapshot).clear().get().getShards()) {
        assertThat(clusterState.getMetadata().hasIndex("test-idx-2"), equalTo(false));  
import java.util.Collections;  
        assertTrue("RestoreInProgress must be empty but found entries in " + restoreInProgress, restoreInProgress.isEmpty());
        createSnapshot("test-repo", "test-2", Collections.singletonList("test"));
        logger.info("--> snapshot");
        CreateSnapshotResponse createSnapshotResponse = client.admin()
        final NumShards numShards = getNumShards(indexName);
            .setWaitForCompletion(true)
        prepareCreate(
            // remove the shard allocation filtering settings and use the Reroute API to retry the failed shards  
import org.opensearch.index.shard.IndexShard;  
            );
            assertThat(e.getMessage(), containsString("snapshot with the same name already exists"));
        final String indexName = "unrestorable-files";
                "should not be allowed to create a snapshot with the same name as an already existing snapshot: "  
            for (SnapshotIndexShardStatus status : shards) {
        // test that getting an unavailable snapshot status throws an exception if ignoreUnavailable is false on the request  
        createRepository("test-repo", "fs", repo);
        cluster().wipeIndices("test-idx");
            client.admin()
            cluster().wipeIndices(hiddenIndex);
    }  
            .setWaitForCompletion(true)
import org.opensearch.cluster.metadata.MetadataIndexStateService;  
        final int nbIndices = randomIntBetween(2, 3);
        }  
            () -> client.admin().cluster().prepareSnapshotStatus("test-repo").setSnapshots("_foo").get()
        createSnapshotResponse = client.admin()
                .state(),  
    }
        {
                .setIndices(dottedHiddenIndex)
        createFullSnapshot(repoName, "snapshot-3");
            }
        logger.info("--> truncate snapshot file to make it unreadable");  
            assertAcked(clusterAdmin().prepareReroute().setRetryFailed(true));
        } finally {
    private void unrestorableUseCase(  
        );
                if (all || randomBoolean() || !atLeastOne) {  
        assertThat(restoreResponse.getRestoreInfo().totalShards(), equalTo(numShards.numPrimaries));
                .setIndices("hid*")  
            .setIndices(indexName)  
        assertEquals(SnapshotState.SUCCESS, getSnapshot("test-repo-2", "test-snap-2").state());
        }  
        final Client client = client();
        // create a snapshot  
import static org.hamcrest.Matchers.containsString;  
                .prepareDeleteSnapshot(
        );
        createRepository(repoName, "mock");
            snapshotToRestore = "snap-2";
            .resolve(  
        try {
        logger.info("--> delete index");
        assertAcked(client().admin().indices().prepareDelete(nbDocsPerIndex.keySet().toArray(new String[0])));
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;  
        logger.info("--> execution was blocked on node [{}], checking snapshot status with specified repository and snapshot", blockedNode);  
                .get()
        // Test restore after index deletion  
        // Now read restore results and make sure it failed  
        final int expectedCount;
        logger.info("--> checking snapshot status again after snapshot is done");  
        );
            // only 1 data node: a shard failed because of the random IO exceptions
            .prepareCreateSnapshot("test-repo-2", "test-snap-2")  
    public void testUnrestorableFilesDuringRestore() throws Exception {
        Client client = client();
            true,
        // Pick one node and block it
            .get();
import java.util.HashMap;
    }  
            .get()  
            .setWaitForCompletion(true)
    public void testSnapshotClosedIndex() throws Exception {
                restoreSnapshotResponse.getRestoreInfo().successfulShards(),  
        try {
 *    http://www.apache.org/licenses/LICENSE-2.0
            equalTo(true)  
            .setWaitForCompletion(true)
            assertThat(clusterState.getMetadata().hasIndex(hiddenIndex), equalTo(true));
            response = clusterAdmin().prepareGetSnapshots("test-repo").setSnapshots("test-snap-" + i).setVerbose(false).get();
        ActionFuture<FlushResponse> flushResponseFuture = null;
        indexService.removeShard(0, "simulate node removal");  
        logger.info("--> restore corrupt index");
        }
        ensureGreen("test-idx-1", "test-idx-2");
        );
            .put(SETTING_ALLOCATION_MAX_RETRY.getKey(), maxRetries)  
        final Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).build();  
    public void testSnapshotMoreThanOnce() throws InterruptedException {  
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())  
            RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot(repoName, snapName)  
            .cluster()  
            "fs",
        GetSnapshotsResponse getSnapshotsResponse = client.admin().cluster().prepareGetSnapshots("readonly-repo").get();  
        String nodeWithPrimary = clusterState.nodes().get(indexRoutingTable.shard(0).primaryShard().currentNodeId()).getName();
        // Test restore after index deletion
                .setIndices("*")
        assertThat(ex.getMessage(), containsString("failed to read global metadata"));  
        assertThat(
                .cluster()
        final Path repo = randomRepoPath();
        final long repoGenInIndexLatest = BytesRefUtils.bytesToLong(  
import org.opensearch.snapshots.mockstore.MockRepository;
        logger.info("--> restoring snapshot 1");
        // check that there is no restore in progress
            "mock",
        SnapshotMissingException ex = expectThrows(
        for (int i = 0; i < nbIndices; i++) {
        createIndexWithRandomDocs("test-idx-1", 100);  
            .setIgnoreUnavailable(true)
import org.opensearch.cluster.ClusterState;
        );
            assertThat(indexStatus.getShardsStats().getFailedShards(), equalTo(numberOfFailures));
        createRepository(repoName, "fs", repoPath);
            .cluster()
        assertThat(snapshotInfo.indices(), hasSize(nbIndices));
import static org.hamcrest.Matchers.endsWith;
            CreateSnapshotResponse createSnapshotResponse = client.admin()
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
        logger.info("--> checking that _current no longer returns the snapshot");
        );
        );  
            indexName,
        createIndex(normalIndex, indexSettingsNoReplicas(randomIntBetween(1, 3)).build());  
                    .put(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(), throttleRestoreViaRecoverySettings ? "10k" : "0")
            .prepareRestoreSnapshot("test-repo", "test-snap")
        assertThat(snapshotStatusResponse.getSnapshots().get(0).getSnapshot().getSnapshotId().getName(), equalTo(snapshotName));
            .get();
        }  
        logger.info("-->  closing index test-idx-closed");  
            Settings.builder()  
            assertThat(
                .setIndices(indexName)  
            for (SnapshotIndexShardStatus status : shards) {  
        String blockedNode = blockNodeWithIndex("test-repo", "test-idx");  
        }
        return Settings.builder()
            "mock",  
            "fs",
        expectThrows(  
        NumShards numShards = getNumShards("test");
        final Path repoPath = randomRepoPath();
            .cluster()  
        final String hiddenIndex = "hidden-index";
        final ActionFuture<RestoreSnapshotResponse> restoreFut;
        logger.info("--> waiting for block to kick in");
        logger.info("--> checking that _current returns the currently running snapshot");  
        // only one shard
                }  
        logger.info("--> execution was blocked on node [{}], moving shards away from this node", blockedNode);
        assertThat(
                .state(),  
                .put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag", "nowhere")
                .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)  
                .get(0);
        assertThat(response.getSnapshots().size(), equalTo(0));  
        createRepository(repoName, "fs");  
        }
            SnapshotStatus snapshotStatus = snapshotsStatusResponse.getSnapshots().get(0);
                historyUUIDs.put(shardId, historyUUID);
            .setTransientSettings(Settings.builder().putNull(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey()).build())
                }
            .setWaitForCompletion(true)  
        indexRandomDocs("test-idx", 100);
    }  
                .put("random", randomAlphaOfLength(10))
    }
            assertThat(shardStats.getShardRouting() + " doesn't have a history uuid", historyUUID, notNullValue());
        createRepository(  
            equalTo(SnapshotState.SUCCESS)
        assertThat(snapshotStatusResponse.getSnapshots(), hasSize(1));
                }
            logger.info("--> in-use repository replacement failed");  
        // delete the index and restore again
            assertThat(getFailureCount("test-repo"), equalTo(0L));
            // All shards were restored, we must find the exact number of hits  
                .setWaitForCompletion(true)  
        createRepository(repoName, "fs", repo);  
            .put("random_data_file_io_exception_rate", 1.0)
        createRepository(  
        assertTrue(newIndexUUID, newIndexUUID != null);  
            client().prepareDelete("test-idx-2", Integer.toString(i)).get();
            () -> client.admin().cluster().prepareGetSnapshots("test-repo").setIgnoreUnavailable(false).get()
        logger.info("--> checking snapshot status after it is done with empty repository");
        createSnapshot("test-repo", "test-snap", Collections.singletonList("test-idx"));
            assertThat(restorePause, greaterThan(0L));
            .execute()
        List<SnapshotInfo> snapshotInfos = clusterAdmin().prepareGetSnapshots("test-repo").get().getSnapshots();  
        assertAcked(startDeleteSnapshot(repoName, snapshotToDelete).get());  
            .get();  
        Consumer<UnassignedInfo> checkUnassignedInfo = unassignedInfo -> {
        cluster().wipeIndices(normalIndex, hiddenIndex, dottedHiddenIndex);
        Client client = client();  
        createRepository(
                .get();  
        clusterAdmin().prepareRestoreSnapshot(repoName, "snap-1")
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), greaterThan(0));
        createSnapshot("test-repo", "test-snap", Collections.singletonList("test-idx"));  
                .getSnapshots()
        createRepository("test-repo", "fs", repositoryLocation);
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, numShards.numPrimaries)));
        Client client = client();
        assertThat(restoreSnapshotResponse.getRestoreInfo().successfulShards(), equalTo(snapshotInfo.successfulShards()));  
import org.opensearch.common.settings.Settings;
                .setWaitForCompletion(true)  
            fail(
            }  
            .cluster()  
        logger.info("--> restore all indices from the snapshot");  
        logger.info("--> snapshot");  
            final ClusterStateResponse clusterStateResponse = client.admin().cluster().prepareState().get();  
        disableRepoConsistencyCheck("This test intentionally leaves a broken repository");
        waitForBlock(blockedNode, "test-repo", TimeValue.timeValueSeconds(60));
import java.util.function.Predicate;
            repo,
            createSnapshot("test-repo", snapshotName, indices);
}
            Settings settings = client.admin().indices().prepareGetSettings("test").get().getIndexToSettings().get("test");
                // that caused problems with writing subsequent snapshots if they happened to be lingering in the repository
        cluster().wipeIndices("test-idx-1", "test-idx-2");
     * Test that restoring a snapshot whose files can't be downloaded at all is not stuck or
        // update the test repository
            .prepareGetSnapshots("test-repo")  
            "test-repo",  
        } catch (SnapshotException | RepositoryException ex) {  
            "fs",
        for (SnapshotInfo snapshotInfo : response.getSnapshots()) {
            .getSetting("test", IndexMetadata.SETTING_INDEX_UUID);  
                .setIndices("*", "-.*")
            assertThat(clusterState.getMetadata().hasIndex(hiddenIndex), equalTo(true));
                .get();  
            .build();
    /** Execute the unrestorable test use case **/
     * its allocation does not hang indefinitely.
        Settings createIndexSettings = Settings.builder()
 * this file be licensed under the Apache-2.0 license or a
            new BytesRef(Files.readAllBytes(repoPath.resolve(BlobStoreRepository.INDEX_LATEST_BLOB)))
        assertDocCount("test-idx-2", 100L);  
            List<SnapshotIndexShardStatus> shards = snapshotStatus.getShards();
            .put(super.nodeSettings(nodeOrdinal))
            client().prepareDelete("test-idx-3", Integer.toString(i)).get();
        assertDocCount("test-idx-1", 50L);
        createSnapshot("test-repo", "test-snap", Collections.singletonList("test-idx"));
                equalTo(restoreSnapshotResponse.getRestoreInfo().totalShards())  
        Client client = client();  
        logger.info("--> make sure that number of files is back to what it was when the first snapshot was made");
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
        final ActionFuture<RestoreSnapshotResponse> restoreFut;
import org.opensearch.repositories.RepositoryException;
            "UUID has changed after restore: " + newIndexUUID + " vs. " + newAfterRestoreIndexUUID,
    public void testCloseIndexDuringRestore() throws Exception {
        Settings.Builder settingsBuilder = Settings.builder().put("location", repositoryLocation.resolve("test"));
        for (RepositoriesService repositoriesService : internalCluster().getDataNodeInstances(RepositoriesService.class)) {
            .put("location", repoPath)  
                client.admin().cluster().prepareDeleteSnapshot("test-repo", new String[] { "test-snap-" + i }).get();
        // Write a document
        };
            .setIndices("test-idx*")
        logger.info("--> verify wildcard returns snapshot info");  
                .get()
        assertNull(
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(0));
            logger.info("--> caught a top level exception, asserting what's expected", ex);
        assertTrue(originalIndexUUID, originalIndexUUID != null);
                    indicesToFlush.add("test-idx-" + i);  
        createFullSnapshot(repoName, "snapshot-4");
            .get();  
        final String repo = "test-repo";
                try {
            assertThat(rootCause.getMessage(), containsString("Random IOException"));
            flushResponseFuture.actionGet();
        final String indexName = "test-idx";
        for (int i = 5; i < 10; i++) {
        GetSnapshotsResponse getResponse = client.admin()
                // the less the number of shards, the less control files we have, so we are giving a higher probability of
            .setWaitForCompletion(true)  
    ) throws Exception {
            .setRenameReplacement("$1-copy")  
            .setIndices("test-idx")
        } catch (InvalidSnapshotNameException e) {  
        assertThat(ex.getRepositoryName(), equalTo(repoName));
        createIndexWithRandomDocs(indexName, 10);  
            final List<String> expected = snapshotInfo.indices();
            client.admin()
        }  
        CreateSnapshotResponse createSnapshotResponse = client.admin()
            .get();
                assertHitCount(client().prepareSearch(entry.getKey()).setSize(0).get(), entry.getValue().longValue());  
            newIndexUUID.equals(newAfterRestoreIndexUUID)  
            .indices()  
            assertThat(snapshotInfo.totalShards(), greaterThan(snapshotInfo.successfulShards()));
        }  
        assertThat(createSnapshotResponse.getSnapshotInfo().indices().size(), equalTo(2));
        ClusterStateResponse clusterStateResponse = clusterAdmin().prepareState().setCustoms(true).setRoutingTable(true).get();
            () -> assertTrue("Expected index [" + index + "] to exist", indexExists(index)),
        Path repositoryLocation = randomRepoPath();  
            .indices()  
        // Verify that hidden indices can be restored by fully specified name
            .prepareRestoreSnapshot("readonly-repo", "test-snap")  
        final Settings createIndexSettings,
            .setWaitForCompletion(true)
            .setRenameReplacement("restored-2")
        {
        // We blocked the node during data write operation, so at least one shard snapshot should be in STARTED stage
        clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")  
        createIndex(indices);  
            SnapshotMissingException.class,
    public void testHiddenIndicesIncludedInSnapshot() throws InterruptedException {
 * software distributed under the License is distributed on an
                .cluster()  
        createIndexWithRandomDocs("test-idx-2", 100);
        } else {
            .setIndices(indexName)
        CreateSnapshotResponse createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap")  
            .cluster()
        for (SnapshotIndexShardStatus shardStatus : snapshotStatus.getIndices().get("test-idx")) {  
        disableRepoConsistencyCheck("This test intentionally leaves a broken repository");
        unblockNode("test-repo", blockedNode);  
        int[] numberOfFiles = new int[numberOfSnapshots];
        final Path repoPath = randomRepoPath();
    protected Settings nodeSettings(int nodeOrdinal) {  
    public void testDataFileFailureDuringRestore() throws Exception {
            "cannot create snapshot in a readonly repository"
            SnapshotMissingException.class,
import org.opensearch.cluster.routing.IndexRoutingTable;
        shardStats = stats.getShards()[0];  
            "test-idx",
                    assertThat(shardStatus.getFailure(), notNullValue());
    }
        final long repoGenInIndexLatest3 = BytesRefUtils.bytesToLong(  
                assertThat(status.getStats().getProcessedFileCount(), greaterThan(2));
        createIndex(indexName, Settings.builder().put("index.number_of_shards", initialShardCount).build());
        assertThat(snapshotInfo.shardFailures(), empty());
            client().prepareIndex("test-idx-1").setSource("foo", "bar"),
            // unblock even if the try block fails otherwise we will get bogus failures when we delete all indices in test teardown.
        {  
        logger.info("--> start relocations");  
        final Index index = resolveIndex(indexName);
        final String normalIndex = "normal-index";
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
        createIndex(hiddenIndex, indexSettingsNoReplicas(randomIntBetween(1, 3)).put(IndexMetadata.SETTING_INDEX_HIDDEN, true).build());
                assertThat(shardStatus.getNodeId(), notNullValue());
        // execute action to eventually fix the situation
            .get()
        try (SeekableByteChannel outChan = Files.newByteChannel(snapshotPath, StandardOpenOption.WRITE)) {
     * */  
        snapshotStatus = response.getSnapshots().get(0);
        createSnapshot("test-repo", "test-snap", Collections.singletonList("test"));
            waitForCompletion("test-repo", "test-snap", TimeValue.timeValueSeconds(600)).shardFailures().size()  
            .resolve(corruptedIndex.getId())
            .put("max_failure_number", 10000000L)  
                .put("random_data_file_io_exception_rate", 0.3)  
            .cluster()
                .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
                .get();
        cluster().wipeIndices("test-idx");
import java.nio.file.Files;
            Settings.builder().put("location", repositoryLocation).put("random", randomAlphaOfLength(10)).put("wait_after_unblock", 200)  
import static org.hamcrest.Matchers.anyOf;
                logger.info("--> starting asynchronous flush for indices {}", Arrays.toString(indices));
            .setIndices("test-idx-*")
        response = client.admin()
        String docId = Integer.toString(randomInt());  
        assertTrue(
        }  
/*
            restoreSnapshotResponse.getRestoreInfo().totalShards(),
        List<SnapshotInfo> snapshotInfos = client.admin()
                .put("location", randomRepoPath())
            Settings.builder().put("location", randomRepoPath()).put("random", randomAlphaOfLength(10)).put("wait_after_unblock", 200)  
import org.opensearch.test.OpenSearchIntegTestCase;
            .actionGet();
        expectThrows(SnapshotMissingException.class, () -> client.admin().cluster().prepareDeleteSnapshot("test-repo", "_foo").get());
        for (int i = 0; i < numberOfSnapshots; i++) {
                .put("max_restore_bytes_per_sec", throttleRestore && (throttleRestoreViaRecoverySettings == false) ? "10k" : "0")  
            .cluster()
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));  
        assertThat(snapshotInfos.get(0).snapshotId().getName(), equalTo("test-snap-1"));
        ClusterState clusterState = internalCluster().clusterService(internalCluster().getClusterManagerName()).state();  
import org.opensearch.action.admin.indices.stats.ShardStats;
        // cluster states to process in their queue when the test is finished
        Path snapshotPath = repo.resolve("snap-" + createSnapshotResponse.getSnapshotInfo().snapshotId().getUUID() + ".dat");
        assertBusy(
        final RestoreSnapshotResponse restoreResponse = client.admin()
            } else {
        logger.info("--> snapshot");
        snapshotStatus = response.getSnapshots().get(0);  
        } else {
            assertThat(indexStatus.getShardsStats().getDoneShards(), equalTo(snapshotInfo.successfulShards()));
        assertThat(shardStats.getSeqNoStats().getLocalCheckpoint(), equalTo(10L)); // 10 indexed docs and one "missing" op.  
        cluster().wipeIndices("test-idx");
        Settings.Builder settings = Settings.builder().put("location", repositoryLocation.resolve("test"));
        Client client = client();  
        logger.info("--> snapshot");  
            .execute()
        assertFalse(
                assertThat(createSnapshotResponse.getSnapshotInfo().shardFailures().size(), greaterThan(0));  
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
        createIndexWithRandomDocs("test-idx", 100);  
        createIndexWithRandomDocs("test-idx", 100);
        final MockRepository repository = (MockRepository) internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class)  
            assertThat(clusterState.getMetadata().hasIndex(normalIndex), equalTo(true));  
        }  
                equalTo(restoreSnapshotResponse.getRestoreInfo().totalShards())
        assertThat(snapshotInfos.size(), equalTo(1));
        }  
        logger.info("--> checking snapshot status for all currently running and snapshot with empty repository");  
            }
        fixUpAction.run();
        final String snapshotName = "test-snap";  
            outChan.truncate(randomInt(10));  
        final String dataNode = internalCluster().getDataNodeInstance(ClusterService.class).localNode().getName();  
        logger.info("--> snapshot");
            .prepareSnapshotStatus("test-repo")  
            // same node again during the same reroute operation. Then another reroute  
    }  
        SnapshotsStatusResponse snapshotStatusResponse = clusterAdmin().prepareSnapshotStatus(repoName).setSnapshots(snapshotName).get();  
        assertThat(snapshotInfos.get(0).state(), equalTo(SnapshotState.SUCCESS));  
            snapshotToRestore = "snap-1";  
        final int numberOfSnapshots = between(5, 15);
import org.opensearch.core.common.unit.ByteSizeUnit;
                .prepareGetSnapshots("test-repo")  
        final String repositoryName = "test-repo";
        logger.info("--> creating {} snapshots ", numberOfSnapshots);  
        indexRandomDocs("test-idx", 100);  
        logger.info("--> execution will be blocked on all data nodes");
                .prepareCreateSnapshot("readonly-repo", "test-snap-2")  
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeWithPrimary);
            .setWaitForCompletion(true)  
import static org.hamcrest.Matchers.containsInAnyOrder;
        for (int i = 0; i < numIndices; i++) {
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
            .get();
        indexRandomDocs("test-idx", 100);
                .get(0);
            assertEquals(expected, indicesPerSnapshot.get(snapshotInfo.snapshotId().getName()));  
     */  
        final Client client = client();
        String blockedNode = blockNodeWithIndex("test-repo", "test-idx");
            OpenSearchIntegTestCase.putRepository(client.admin().cluster(), "test-repo", "fs", settings);  
        createRepository("test-repo", "fs", repositoryLocation);
            // block the shard to be assigned again because it failed during restore.
        for (int i = 0; i < 5; i++) {
            }
            if (createSnapshotResponse.getSnapshotInfo().totalShards() == createSnapshotResponse.getSnapshotInfo().successfulShards()) {
                    numberOfFailures++;
        );  
        for (ShardStats shardStats : client().admin().indices().prepareStats(indicesToSnapshot).clear().get().getShards()) {
                .getSnapshots()  
                .setWaitForCompletion(true)  
            assertAcked(prepareCreate(indexName).setSettings(indexSettingsNoReplicas(Math.min(2, numberOfShards()))));
        long restorePause = 0L;  
            assertThat(
            () -> client.admin().cluster().prepareSnapshotStatus("test-repo").addSnapshots("test-snap-doesnt-exist").get()  
        );
        clusterAdmin().prepareDeleteSnapshot("test-repo", "test-snap-*", "*").get();  
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotIndexStatus;
            Settings.builder()
        // attempt to restore the snapshot with the given settings  
import static org.hamcrest.Matchers.not;
    /** Tests that a snapshot with a corrupted global state file can still be restored */
            logger.info("--> snapshot {}", i);  
            CreateSnapshotResponse createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap")  
    /**  
    }
            assertEquals(snapshotName, e.getSnapshotName());  
    }
            Settings.builder()
        String indexName = "testindex";  
        assertThat(snapshotInfo.shardFailures().size(), equalTo(0));
        indexRandomDocs("test", randomIntBetween(10, 100));
                flushResponseFuture = client().admin().indices().prepareFlush(indices).execute();  
                assertThat(createSnapshotResponse.getSnapshotInfo().shardFailures().size(), greaterThan(0));
            CreateSnapshotResponse createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap-" + i)
        logger.info("--> indexing some more");
        Path repositoryLocation = randomRepoPath();
        createRepository("test-repo", "fs", repositoryLocation);
        cluster().wipeIndices("test-idx");  
        assertThat(shardStats.getSeqNoStats().getMaxSeqNo(), equalTo(15L));
            RepositoryException.class,
        logger.info("--> creating 2 snapshots");
            .setRenamePattern("(.+)")
        ensureGreen();
            assertEquals(
            "test-repo",  
        logger.info("--> unblocking blocked node");
        logger.info("--> delete index");
        final String repositoryName = "test-repo";
        logger.info("--> wait for block to kick in");
            "test-repo",
            "test-repo",  
            logger.info("--> unblocking all data nodes");  
        for (int i = 0; i < 50; i++) {
        ClusterState clusterState = clusterAdmin().prepareState().get().getState();
        }  
        final SnapshotInfo snapshot2 = createFullSnapshot(repoName, "snap-2");
        logger.info("--> replace mock repository with real one at the same location");
            SnapshotIndexStatus indexStatus = snapshotStatus.getIndices().get("test-idx");
            outChan.truncate(randomInt(10));  
            snapshotToDelete = "snap-2";
            restoreSnapshotResponse.getRestoreInfo().failedShards(),
        List<SnapshotInfo> snapshotInfos = clusterAdmin().prepareGetSnapshots(repoName).get().getSnapshots();
        logger.info("--> restore index");  
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
        assertThat(getSnapshotsResponse.getSnapshots(), notNullValue());
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));  
                clusterStateResponse.getState().getRoutingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size()
                .put("random", randomAlphaOfLength(10))  
    public void testDataFileCorruptionDuringRestore() throws Exception {  
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
        waitForBlock(blockedNode, "test-repo", TimeValue.timeValueSeconds(60));
            client.admin().cluster().prepareDeleteRepository(randomFrom("test-repo", "test-*", "*")).execute().actionGet();
        final Path indexMetadataPath = repo.resolve("indices")
                assertThat(shardFailure.nodeId(), notNullValue());
            }
            .execute()
            .cluster()
        assertThat(shardStats.getSeqNoStats().getLocalCheckpoint(), equalTo(15L)); // 15 indexed docs and one "missing" op.
        try {
        Client client = client();
            .actionGet();  
        cluster().wipeIndices("test-idx");  
        ensureGreen();  
            assertThat(shardStats.getShardRouting() + " doesn't have a new history", historyUUID, not(equalTo(historyUUIDs.get(shardId))));  
            .prepareGetSettings("test")
                .setSnapshots("test-1")
        createIndexWithRandomDocs("test-idx-1", 100);  
        SnapshotInfo snapshotInfo = waitForCompletion(repo, snapshot, TimeValue.timeValueSeconds(60));  
        unrestorableUseCase(indexName, createIndexSettings, repositorySettings, Settings.EMPTY, checkUnassignedInfo, () -> {});  
            cluster().wipeIndices(normalIndex, hiddenIndex, dottedHiddenIndex);  
        Path absolutePath = randomRepoPath().toAbsolutePath();  
                } else {  
            Settings.EMPTY,
        assertThat(indexIds.size(), equalTo(nbIndices));  
            Settings.builder()  
        assertAcked(prepareCreate(indexName).setWaitForActiveShards(ActiveShardCount.ALL));
        assertEquals("[test-repo:test-snap-doesnt-exist] is missing", ex.getMessage());
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
    }  
        final int numReplicas = 1;
        assertDocCount("test-idx-1", 100);  
                assertThat(shard.state(), equalTo(ShardRoutingState.UNASSIGNED));  
            // Store number of files after each snapshot
        } else {
        restoreFut.get();  
        ActionFuture<RestoreSnapshotResponse> restoreSnapshotResponseFuture = client.admin()
        );  
        logger.info("--> replace mock repository with real one at the same location");  
        }
            fixupAction
            () -> client.admin().cluster().prepareGetSnapshots("test-repo").setSnapshots("_foo").get()  
            .build();
            .put("use_lucene_corruption", false)
            .execute()
            .cluster()
        createIndexWithRandomDocs("test-idx-1", 100);  
            }  
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
        expectThrows(InvalidSnapshotNameException.class, () -> client.admin().cluster().prepareCreateSnapshot("test-repo", "_foo").get());  
        ensureGreen();  
        for (Map.Entry<String, Integer> entry : nbDocsPerIndex.entrySet()) {
import org.opensearch.OpenSearchException;  
            SnapshotException.class,
        logger.info("--> list available shapshots");
        if (flushResponseFuture != null) {
        for (int i = 10; i < 20; i++) {
                assertThat(shard.recoverySource().getType(), equalTo(RecoverySource.Type.SNAPSHOT));
            SnapshotStatus snapshotStatus = client.admin()
        boolean throttleRestore = randomBoolean();  
            new BytesRef(Files.readAllBytes(repoPath.resolve(BlobStoreRepository.INDEX_LATEST_BLOB)))  
        createIndex(indexName, Settings.builder().put("index.number_of_shards", newShardCount).build());  
        assertTrue(shardStats.getShardRouting().primary());
            SnapshotException.class,
        createSnapshot(repoName, snapshotName, Collections.singletonList(indexName));
            logger.info("--> try deleting the snapshot while the restore is in progress (should throw an error)");  
        final Map<ShardId, String> historyUUIDs = new HashMap<>();
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
            }  
                    IntStream.range(1, numberOfSnapshots - 1).mapToObj(i -> "test-snap-" + i).toArray(String[]::new)  
            .cluster()
import org.opensearch.threadpool.ThreadPool;  
        snapshotInfo = waitForCompletion("test-repo", "test-snap", TimeValue.timeValueSeconds(600));
            } else {
                .put("location", repositoryLocation)
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Settings.Builder excludeSettings = Settings.builder().put("index.routing.allocation.exclude._name", blockedNode);
            assertAcked(prepareCreate("test-idx-" + i).setSettings(indexSettingsNoReplicas(1)));  
        createRepository(repoName, "fs", absolutePath);  
            "test-repo",
        repository.setFailOnIndexLatest(true);
        SnapshotIndexStatus indexStatus = snapshotStatus.getIndices().get("test-idx");  
    }
            if (randomBoolean()) {  
            .indices()
            .prepareGetSnapshots(repoName)
        OpenSearchIntegTestCase.putRepository(client.admin().cluster(), "test-repo", "fs", false, settings);
                assertThat(getFailureCount("test-repo"), greaterThan(0L));
    }
        assertThat(snapshotStatus.includeGlobalState(), equalTo(false));
                assertThat(shard.unassignedInfo().getLastAllocationStatus(), equalTo(UnassignedInfo.AllocationStatus.DECIDERS_NO));
            .execute()  
        );
        logger.info("--> take snapshots");
        boolean throttleRestoreViaRecoverySettings = throttleRestore && randomBoolean();
        createRepository(repoName, "mock", repoPath);
            .cluster()  
        }
            .execute()
            client().prepareIndex("test-idx-3").setSource("foo", "bar")
            assertThat(ExceptionsHelper.stackTrace(ex), containsString("Random IOException"));
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
     * <p>
        assertAcked(prepareCreate("test-idx", 2, Settings.builder().put("number_of_replicas", 0)));  
                    client().admin().indices().prepareClose("test-idx-1").get();
        assertDocCount("test-idx", 100);
 * the Apache License, Version 2.0 (the "License"); you may
        // Verify that exclusions work on hidden indices  
        clusterAdmin().prepareRestoreSnapshot(repoName, snapshotToRestore)
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;  
            restoreIndexSettings,
        String restoredIndexName = indexName + "-restored";
            .setIndices(indexName)  
        assertDocCount("restored-3", expectedCount);
        assertDocCount("test-idx", 100L);  
        expectThrows(
            equalTo(SnapshotState.SUCCESS)
        logger.info("--> verify individual requests return snapshot info");
        assertAllSuccessful(refresh());
        assertAcked(prepareCreate("test-idx", 2, Settings.builder().put("number_of_replicas", 0)));
            .put("random", randomAlphaOfLength(10))
        assertThat(ex.getSnapshotName(), equalTo(snapshotName));
 * KIND, either express or implied.  See the License for the
        assertThat(numberOfFilesAfterDeletion, lessThan(numberOfFilesBeforeDeletion));
            assertThat(clusterState.getMetadata().hasIndex(normalIndex), equalTo(false));
            .setIndices(indicesToSnapshot)  
            .setWaitForCompletion(true)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            assertThat(snapshotInfo.state(), equalTo(SnapshotState.PARTIAL));
        try {
        createIndexWithRandomDocs("test-idx-2", 100);
import java.util.List;
        assertEquals(1, response.getSnapshots().size());
        logger.info("--> take first snapshot");
                    assertThat(snapshotInfo.shardFailures().size(), greaterThan(0));
                    assertThat(shardStatus.getFailure(), nullValue());
        assertNull(  
    public void testDeletionOfFailingToRecoverIndexShouldStopRestore() throws Exception {  
            .prepareUpdateSettings()
import org.opensearch.action.support.ActiveShardCount;  
            index(indexName, "_doc", Integer.toString(i), "foo", "bar" + i);
        flushAndRefresh("test-idx-1", "test-idx-2");  
        assertThat(snapshotInfo.shardFailures().get(0).reason(), is("aborted"));  
        logger.info("--> taking a snapshot");  
        assertThat(snapshotStatus.includeGlobalState(), equalTo(false));
        if (snapshotClosed) {
        final RestoreInfo restoreInfo = restoreResponse.getRestoreInfo();
                .setWaitForCompletion(true)
            .setWaitForCompletion(true)
                    assertThat(e.getMessage(), containsString("Cannot close indices that are being snapshotted: [[test-idx-1/"));
        refresh();
        }
                .cluster()  
        disableRepoConsistencyCheck("This test uses a purposely broken repository so it would fail consistency checks");  
        Settings.Builder settings = Settings.builder()
                .get()
            "mock",
 * SPDX-License-Identifier: Apache-2.0
        SnapshotInfo snapshotInfo = snapshotInfos.get(0);
        );
        client.admin().cluster().prepareCreateSnapshot("test-repo", "test-snap").setWaitForCompletion(false).setIndices("test-idx").get();
        assertDocCount("test-idx-1", 100L);
        logger.info("--> restore index after deletion");
        final int initialShardCount = randomIntBetween(1, 10);
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        assertNoFailures(client().admin().indices().prepareForceMerge("test").setFlush(true).setMaxNumSegments(1).get());
        CreateSnapshotResponse createSnapshotResponse = client.admin()  
                .getSnapshots()  
        indexRandomDocs(dottedHiddenIndex, 100);
    public void testDeleteRepositoryWhileSnapshotting() throws Exception {
        }  
        restoreSnapshotResponse = client.admin()  
import org.opensearch.index.IndexService;
            final boolean all = randomBoolean();
                .put("compress", randomBoolean())
            .setIndices(randomFrom("*", "_all"))  
        } else {
    private void verifySnapshotInfo(final GetSnapshotsResponse response, final Map<String, List<String>> indicesPerSnapshot) {  
        String repoName = "test-repo";  
        final String repoName = "test-repo";
        createRepository(
        );
            createSnapshotResponse = client.admin()
        createIndex(indexName, settings);
            logger.info("--> unblock all data nodes");  
        logger.info("--> index more documents");  
            if (shard.primary()) {
                    final int numDocs = randomIntBetween(1, 5);
        // check that all shards failed during restore
                "meta-" + repositoryData.indexMetaDataGenerations().indexMetaBlobId(snapshotInfo.snapshotId(), corruptedIndex) + ".dat"
        logger.info("--> snapshot with [{}] shards", newShardCount);  
        SnapshotInfo snapshotInfo = getResponse.getSnapshots().get(0);
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
import org.opensearch.core.index.shard.ShardId;  
                .get()  
                .actionGet();
        };
    public void testCloseOrDeleteIndexDuringSnapshot() throws Exception {  
                .prepareCreateSnapshot(repoName, snapshotName2)
                assertThat(status.getStats().getProcessedFileCount(), greaterThan(1));
            Settings.EMPTY,  
        }
    public void testSnapshotDifferentIndicesBySameName() throws InterruptedException, ExecutionException {
        assertThat(snapshotInfos.get(0).state(), equalTo(SnapshotState.SUCCESS));
        final String snapshotName = "test-snap";  
        unblockNode("test-repo", blockedNode);  
            assertThat(restoreSnapshotResponse.getRestoreInfo().indices(), containsInAnyOrder(dottedHiddenIndex));  
            Settings.builder().put("location", repo).put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        } catch (Exception ex) {
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));  
        createRepository(  
        assertNotNull("RestoreInProgress must be not null", restoreInProgress);  
                if (snapshotInfo.state() == SnapshotState.SUCCESS) {
                    logger.info("--> delete index while non-partial snapshot is running");
            .addSnapshots("test-snap", "test-snap-doesnt-exist")
            assertThat(clusterState.getMetadata().hasIndex(hiddenIndex), equalTo(true));  
            );  
            .setWaitForCompletion(true)
        }
            "test-repo",
        startDeleteSnapshot("test-repo", lastSnapshot).get();  
import static org.hamcrest.Matchers.nullValue;
    public void testSnapshotCanceledOnRemovedShard() throws Exception {
        assertThat(
                .getSnapshots()
        );
            TimeUnit.MILLISECONDS
import org.opensearch.action.support.IndicesOptions;
        assertThat(restoreInfo.totalShards(), equalTo(numShards.numPrimaries));  
            assertEquals(repoName, e.getRepositoryName());
        assertHitCount(client().prepareSearch("test-idx-*").setSize(0).get(), 3);  
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
            .get();  
        final String indexName = "unrestorable-index";
        final SnapshotInfo snapshotInfo = createFullSnapshot("test-repo", "test-snap");
        assertBusy(
        logger.info("--> creating repository");
                .getSetting("test-idx-1", MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey())
        createRepository("test-repo", "fs");
        if (createSnapshotResponse.getSnapshotInfo().totalShards() == createSnapshotResponse.getSnapshotInfo().successfulShards()) {
        client().admin().indices().prepareClose("test").get();
                Settings.builder()  
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
        logger.info("--> snapshot with no I/O failures");
        // trying to allocate the shards for the index, even though the restore operation  
        logger.info("--> ensuring snapshot is aborted and the aborted shard was marked as failed");
        ensureGreen();
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));  
        ensureGreen();  
        indexRandomDocs(indexName, nbDocs);
    private void waitForIndex(final String index, TimeValue timeout) throws Exception {  
                        index("test-idx-" + j, "_doc", Integer.toString(k), "foo", "bar" + k);  
                    assertThat(e.getMessage(), containsString("Cannot delete indices that are being snapshotted: [[test-idx-1/"));  
package org.opensearch.snapshots;
        logger.info("--> removing primary shard that is being snapshotted");
            .setWaitForCompletion(true)
        unblockNode(repo, blockedNode);  
            .indices()
            .setRenamePattern(indexName)
/*  
        // Pick one node and block it  
import static org.hamcrest.Matchers.empty;
            .cluster()  
            }  
        logger.info("--> done");  
            .get();
            .cluster()
        logger.info("--> waiting for completion");  
        disableRepoConsistencyCheck("This test intentionally leaves a broken repository");
     * See https://github.com/elastic/elasticsearch/issues/20876  
    public void testDeleteSnapshotWhileRestoringFails() throws Exception {  
import org.opensearch.cluster.metadata.IndexMetadata;
        );
        indexRandomDocs(normalIndex, 100);
            assertThat(
                // soft-delete generates DV files.  
        assertThat(snapshotInfo.version(), equalTo(Version.CURRENT));  
        for (int i = 0; i < 100; i += 2) {
            .get();  
        assertThat(snapshotInfos.size(), equalTo(1));
        logger.info("--> delete index");
        logger.info("--> snapshot");
 *  
                .put("location", repositoryLocation)  
            indexSettingsNoReplicas(randomIntBetween(1, 3)).put(IndexMetadata.SETTING_INDEX_HIDDEN, true).build()
        logger.info("--> restore index after deletion");  
        assertThat(getSnapshotsResponse.getSnapshots(), empty());
 * compatible open source license.
        client().prepareDelete("test", "1").get();  
            logger.info("--> in-use repository deletion failed");
            ConcurrentSnapshotExecutionException e = expectThrows(
        final GetSnapshotsResponse getSnapshotsResponse = clusterAdmin().prepareGetSnapshots("test-repo").get();
            "test-repo",  
        assertEquals("index.latest should not have been written to", repoGenInIndexLatest, repoGenInIndexLatest2);
        // create a test repository
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.IN_PROGRESS));  
                .prepareCreateSnapshot(repoName, snapshotName)
            unblockAllDataNodes(repoName);
            .execute()  
            // sometimes, the snapshot will fail with a top level I/O exception
        logger.info("--> restore all indices from the snapshot");  
        client.admin().cluster().prepareCreateSnapshot("test-repo", "test-snap").setWaitForCompletion(false).setIndices("test-idx").get();  
            // One or more shards failed to be restored. This can happen when there is  
        createRepository("test-repo", "fs");
        // update the test repository in order to make it work
        final String snapshotToRestore;
        } catch (Exception ex) {  
            "fs",
    public void testBulkDeleteWithOverlappingPatterns() {
        createSnapshot("test-repo", "test-snap", Collections.singletonList("test-idx"));
        waitForBlockOnAnyDataNode("test-repo", TimeValue.timeValueMinutes(1));
            // Finish flush  
        assertRequestBuilderThrows(
            .setWaitForCompletion(true)
        assertThat(restoreResponse.getRestoreInfo().successfulShards(), equalTo(0));  
            assertThat(clusterState.getMetadata().hasIndex(dottedHiddenIndex), equalTo(true));
            true,
            numberOfFiles[i] = numberOfFiles(repo);
            logger.info("--> start restore");  
        // Create index on 2 nodes and make sure each node has a primary by setting no replicas  
        assertAcked(client().admin().indices().prepareDelete(indexName));
        logger.info("--> delete all snapshots except the first one and last one");
        }
            .execute();  
        logger.info("--> snapshot with [{}] shards", initialShardCount);
        assertThat(  
        logger.info("--> restore index");  
            ClusterState clusterState = client.admin().cluster().prepareState().get().getState();
        createIndexWithRandomDocs("test-idx", 100);  
            equalTo(restoreSnapshotResponse.getRestoreInfo().totalShards())  
                .put("random_data_file_io_exception_rate", 1.0)
        assertThat(client().prepareGet(restoredIndexName, docId).get().isExists(), equalTo(true));
            // Verify that snapshot status also contains the same failures  
            int nbDocs = randomIntBetween(1, 10);  
                .put("location", repositoryLocation)
                    assertThat(shardFailure.reason(), endsWith("; nested: IOException[Random IOException]"));  
        SnapshotsStatusResponse response = client.admin().cluster().prepareSnapshotStatus("test-repo").execute().actionGet();
        );  
import org.opensearch.cluster.service.ClusterService;  
        logger.info("--> done");  
        );
                    .indices()  
        logger.info("--> verify doc counts");
        String blockedNode = blockNodeWithIndex("test-repo", "test-idx");
                    assertThat(snapshotInfo.totalShards(), greaterThan(snapshotInfo.successfulShards()));  
    public void testUnrestorableIndexDuringRestore() throws Exception {
                    assertThat(shardFailure.index(), equalTo("test-idx"));
        createRepository("test-repo", "fs");
            .prepareGetSnapshots("test-repo")  
        // TODO: Fix repo cleanup logic to handle these leaked snap-file and only exclude test-repo (the mock repo) here.
        final SnapshotInfo snapshot1 = createFullSnapshot(repoName, "snap-1");
        Runnable fixupAction = () -> {
            Settings.builder().put("location", repoPath).put(BlobStoreRepository.SUPPORT_URL_REPO.getKey(), false)
     * leaving the cluster, then returning), all snapshotting of that shard is aborted, so  
/*  
            IndexRequestBuilder[] documents = new IndexRequestBuilder[nbDocs];  
                .setWaitForCompletion(true)
        final RepositoryData repositoryData = getRepositoryData("test-repo");
        }
        assertThat(getSnapshot("test-repo", "test-snap").state(), equalTo(SnapshotState.SUCCESS));
            assertThat(clusterState.getMetadata().hasIndex(normalIndex), equalTo(true));
import static org.hamcrest.Matchers.notNullValue;  
        assertThat(indexStatus.getShardsStats().getDoneShards(), equalTo(snapshotInfo.successfulShards()));
        for (int i = 10; i < 15; i++) {  
        waitForIndex("test-idx", TimeValue.timeValueSeconds(10));
        createRepository(  
                .setSnapshots("test-2")
        {  
        );  
                assertThat(e.getMessage(), containsString("Cannot close indices that are being restored: [[test-idx-1/"));
        assertThat(  
            assertThat(unassignedInfo.getNumFailedAllocations(), anyOf(equalTo(maxRetries), equalTo(1)));  
        logger.info("--> verify _all returns snapshot info");
            expectedCount = newDocCount;  
                assertThat(shardStatus.getNodeId(), notNullValue());
                }
        // Verify that hidden indices can be restored with a non-star pattern
        assertThat(snapshotInfo.shardFailures().size(), equalTo(0));  
        );  
            index(indexName, "_doc", Integer.toString(i), "foo", "bar" + i);
    public void testEmptySnapshot() throws Exception {
        logger.info("--> waiting for completion");
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
            .setWaitForCompletion(true)
        cluster().wipeIndices("test");
        assertThat(indexStatus.getShardsStats().getFailedShards(), equalTo(snapshotInfo.failedShards()));  
            assertThat(restoreSnapshotResponse.getRestoreInfo().indices(), containsInAnyOrder(hiddenIndex));
                )
        );
            .get();
            "cannot delete snapshot from a readonly repository"
            SnapshotStatus snapshotStatus = client.admin()
            .repository(repoName);
import java.util.Arrays;
            );
 *
        client().admin().indices().prepareClose("test-idx-1", "test-idx-2").get();
        ensureGreen(indexName);  
                .get();
import org.opensearch.index.mapper.MapperService;
            "mock",
    }  
        assertDocCount("test-idx", 100L);
        logger.info("--> second snapshot of the same name should fail");  
        logger.info("--> wait for restore to finish");
            int numberOfFailures = 0;
        }  
                .setSnapshots("test")
            .actionGet();
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
        );
            .build();
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
        allowNodes("test-idx", 1);
            }
            assertThat(shardStats.getShardRouting() + " doesn't have a new history", historyUUID, not(equalTo(historyUUIDs.get(shardId))));
                .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        logger.info("--> trying to restore index again");
            .getSnapshots();  
            .prepareGetSettings("test")
        final Path repoPath = randomRepoPath();  
        indexRandomDocs(indexName, 100);  
        CreateSnapshotResponse createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap")  
            }  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        }
        );
            )  
            Settings.builder()
            );
        Settings repositorySettings = Settings.builder()
        logger.info("--> creating {} snapshots ", numberOfSnapshots);  
                    refresh();
        assertThat(shardStats.getSeqNoStats().getGlobalCheckpoint(), equalTo(15L));  
            logger.info("--> some failures");  
            assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotIndexShardStatus;  
        );
            .prepareCreateSnapshot("test-repo", "test-snap")  
        final int docCount = initialShardCount * randomIntBetween(1, 10);
            .prepareRestoreSnapshot("test-repo", "test-snap")
            // non-partial snapshots do not allow close / delete operations on indices where snapshot has not been completed
    public void testMoveShardWhileSnapshotting() throws Exception {  
                .put("use_lucene_corruption", true)
                // we flush before the snapshot such that we have to process the segments_N files plus the .del file
        CreateSnapshotResponse createSnapshotResponse = startFullSnapshot("test-repo", "test-snap").get();  
            indexRandom(true, documents);
        assertDocCount("test-idx-3", 50L);
            for (int i = 1; i < 4; i++) {
            .setRenamePattern(indexName)
            .setWaitForCompletion(true)  
        IndexRoutingTable indexRoutingTable = clusterState.getRoutingTable().index(index);
        assertThat(restoreResponse.getRestoreInfo().totalShards(), equalTo(numShards.numPrimaries));
        logger.info("--> indexing some data");  
        if (snapshotClosed) {
                .cluster()  
        logger.info("--> close indices");  
                } catch (SnapshotInProgressException e) {
                .setIndices("test-idx")
    }
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
            logger.info("--> unblocking all data nodes");
        assertThat(indexStatus.getShardsStats().getInitializingShards(), equalTo(0));
            .get();
import java.util.concurrent.ExecutionException;
        final int newShardCount = randomIntBetween(1, 10);
                .prepareCreateSnapshot("test-repo", "test-snap")
        Path repositoryLocation = randomRepoPath();
            cluster().wipeIndices(normalIndex, hiddenIndex);
 * Licensed to Elasticsearch under one or more contributor  
        Path repositoryLocation = randomRepoPath();  
        assertEquals(0, snapshotInfo.shardFailures().get(0).shardId());
        // index some documents
            ShardId shardId = shardStats.getShardRouting().shardId();
            snapshotPause += repositoriesService.repository("test-repo").getSnapshotThrottleTimeInNanos();
            equalTo(SnapshotState.SUCCESS)
        try (SeekableByteChannel outChan = Files.newByteChannel(globalStatePath, StandardOpenOption.WRITE)) {  
        for (SnapshotIndexShardStatus shardStatus : snapshotStatus.getIndices().get("test-idx")) {  
            logger.info("--> close index while restore is running");  
            "readonly-repo",
        // Create index on 2 nodes and make sure each node has a primary by setting no replicas  
        // Test restore after index deletion  
        cluster().wipeIndices("test-idx");
     * This test ensures that when a shard is removed from a node (perhaps due to the node
    public void testIndexLatestFailuresIgnored() throws Exception {
        Path absolutePath = randomRepoPath().toAbsolutePath();
            // unblock even if the try block fails otherwise we will get bogus failures when we delete all indices in test teardown.  
                .getSnapshotInfo()
        flushAndRefresh();  
        client.admin()
                .cluster()  
        createRepository(  
            client().prepareIndex("test-idx-2").setSource("foo", "bar"),  
        final Client client = client();
        restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
        assertEquals(indicesPerSnapshot.size(), response.getSnapshots().size());  
 * not use this file except in compliance with the License.
        ensureGreen();  
                .setIndices("test-idx"),
    public void testRestoreSnapshotWithCorruptedIndexMetadata() throws Exception {
 *
            assertThat(ex.getMessage(), containsString("trying to modify or unregister repository that is currently used"));  
                .get();  
                .put("random", randomAlphaOfLength(10))
                restoreSnapshotResponse.getRestoreInfo().successfulShards(),
        );
            assertThat(clusterState.getMetadata().hasIndex(dottedHiddenIndex), equalTo(true));
            prepareCreate(index, 1, Settings.builder().put("number_of_shards", numPrimaries).put("number_of_replicas", numReplicas))
            .setPartial(false)
import org.opensearch.core.util.BytesRefUtils;
import org.opensearch.repositories.IndexId;
            verifySnapshotInfo(response, indicesPerSnapshot);  
        assertAcked(client.admin().indices().prepareDelete(indexName).get());
            "UUID has been reused on restore: " + copyRestoreUUID + " vs. " + originalIndexUUID,  
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));  
            // No lucene corruptions, we want to test retries
        SnapshotInfo snapshotInfo = snapshotInfos.get(0);  
            );  
            .actionGet();
            .cluster()
        logger.info("--> close index");  
                .setWaitForCompletion(true)
        Path repositoryLocation = randomRepoPath();
        final IndexId corruptedIndex = randomFrom(indexIds.values());  
            .put("location", randomRepoPath())  
        logger.info("--> delete index");  
        response = clusterAdmin().prepareGetSnapshots("test-repo").setSnapshots("test-snap-*").setVerbose(false).get();
        assertThat(snapshotInfos.get(0).state(), equalTo(SnapshotState.SUCCESS));  
        verifySnapshotInfo(response, indicesPerSnapshot);
            .get();  
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotIndexShardStage;
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(0));
                    atLeastOne = true;
            .get();  
import java.nio.file.StandardOpenOption;  
        assertAcked(  
            .get();
        assertThat(snapshotInfos.get(0).snapshotId().getName(), equalTo(snapshotName));
        waitForBlock(blockedNode, repo, TimeValue.timeValueSeconds(10));  
        final int newDocCount = newShardCount * randomIntBetween(1, 10);  
            .setWaitForCompletion(true)
        Client client = client();
                .prepareCreateSnapshot(repositoryName, snapshotName)
        assertThat(createSnapshotResponse.getSnapshotInfo().state(), equalTo((SnapshotState.SUCCESS)));
            RepositoryException.class,  
        refresh();
import org.opensearch.index.engine.Engine;  
        assertThat(clusterStateResponse.getState().getRoutingTable().allShards(indexName), hasSize(numShards.totalNumShards));
        }
        }
        assertThat(createSnapshotResponse.getSnapshotInfo().shardFailures().size(), equalTo(0));  
        disableRepoConsistencyCheck("This test does not create any data in the repository");  
        assertThat(snapshotInfos.size(), equalTo(1));
                .put("compress", randomBoolean())
                .prepareGetSettings("test-idx-1")  
            "mock",
                .get(0);
            );
        }
            outChan.truncate(randomInt(10));
        for (int i = 0; i < numSnapshots; i++) {  
            .cluster()
        logger.info("--> wait for the index to appear");
        createRepository(
    }
        logger.info("--> delete index");  
            // Restoring a file will never complete  
        logger.info("Snapshot successfully completed");  
        createIndexWithRandomDocs("test-idx-3", 100);
        createIndexWithRandomDocs("test-idx", 100);
            .setIndices("test-idx")
        String lastSnapshot = "test-snap-" + (numberOfSnapshots - 1);
        final int numPrimaries = 1;  
        final String snapshot = "test-snap";
            dottedHiddenIndex,  
        ensureGreen();
            "fs",
            .setWaitForCompletion(true)
            .setWaitForCompletion(true)
        blockAllDataNodes(repoName);
        logger.info("--> get restore results");
        );
            Settings.builder()
        Client client = client();
            SnapshotException.class,
        } catch (Exception ex) {
            .setIndices("test-idx-*")  
        ActionFuture<CreateSnapshotResponse> future = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap")
            .setIndices(indexName)
        final Settings settings = indexSettingsNoReplicas(1).put("index.routing.allocation.include._name", dataNode).build();
                    fail("Expected deleting index to fail during snapshot");
            }  
        }
            if (shardStatus.getStage() == SnapshotIndexShardStage.STARTED) {
                .get()
            logger.info("--> waiting for block to kick in");  
        ensureGreen();
            () -> assertThat(clusterAdmin().prepareHealth("test-idx").execute().actionGet().getRelocatingShards(), greaterThan(0)),  
        assertThat(response.getSnapshots().size(), equalTo(1));
 * this work for additional information regarding copyright
        assertThat(restoreSnapshotResponse.getRestoreInfo().successfulShards(), greaterThan(0));
            index(indexName, "_doc", Integer.toString(i), "foo", "bar" + i);
            .setIncludeGlobalState(false)
        );
        );
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus;
                .put("index.number_of_shards", 3)  
                equalTo(restoreSnapshotResponse.getRestoreInfo().totalShards())
        logger.info("--> restore one index after deletion");  
        CreateSnapshotResponse createSnapshotResponse = client.admin()
            client.admin()
        OpenSearchIntegTestCase.putRepository(client.admin().cluster(), "test-repo-2", "fs", false, settingsBuilder);
            List<String> indices = new ArrayList<>();
        assertThat(getSnapshot("test-repo", "test").state(), equalTo(SnapshotState.SUCCESS));
        IndexService indexService = indicesService.indexService(resolveIndex(index));
        disableRepoConsistencyCheck("This test intentionally leaves a broken repository");  
        } else {
            SnapshotStatus snapshotStatus = client.admin()
            assertThat(restoreSnapshotResponse.getRestoreInfo().indices(), containsInAnyOrder(normalIndex, hiddenIndex, dottedHiddenIndex));
            fail("shouldn't be able to delete in-use repository");  
                try {  
            .cluster()
        Predicate<String> isRestorableIndex = index -> corruptedIndex.getName().equals(index) == false;
import static org.hamcrest.Matchers.lessThan;
            client.admin()
            .execute()  
        createRepository("test-repo", "mock");
            Settings.builder()  
        String snapshotName = "test-restore-snapshot";
        if (randomBoolean()) {
        ensureGreen("test-idx");  
        createRepository("test-repo", "fs");
            assertThat(  
        final String indexName,
import java.util.Map;  
        // create a test index
        for (ShardStats shardStats : client().admin().indices().prepareStats(indicesToSnapshot).clear().get().getShards()) {
        stats = client().admin().indices().prepareStats(indexName).clear().get();
        Settings.Builder settings = Settings.builder()
    public void testSnapshotRelocatingPrimary() throws Exception {
            .setWaitForCompletion(true)  
        logger.info("--> unblocking blocked node [{}]", blockedNode);
        startDeleteSnapshot(repositoryName, snapshotName).get();
        );  
import org.opensearch.cluster.routing.UnassignedInfo;
            nbDocsPerIndex.put(indexName, nbDocs);
        int numberOfFilesAfterDeletion = numberOfFiles(repo);
        }  
        );  
        createSnapshot("test-repo", "test-snap", Collections.singletonList("test-idx"));
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));  
        createIndex("test-idx");
            client().admin()
        createIndex("test-idx-1", "test-idx-2");
        // We blocked the node during data write operation, so at least one shard snapshot should be in STARTED stage
            .get();
            .actionGet();
        final String[] indicesToSnapshot = { "test-idx-*", "-test-idx-3" };
        RestoreSnapshotResponse restoreSnapshotResponse = restoreSnapshotResponseFuture.actionGet(TimeValue.timeValueSeconds(10));
        createSnapshot("test-repo", "test", Collections.singletonList("test"));
            .execute();  
        }
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
import org.opensearch.cluster.SnapshotsInProgress.State;
            RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot(repoName, snapName)
        assertAcked(client.admin().indices().prepareClose("test-idx-closed").setWaitForActiveShards(ActiveShardCount.ALL));
        createRepository(
        final int numIndices = randomIntBetween(1, 10);
                .cluster()  
        // check that every primary shard is unassigned  
    public void testSnapshotName() throws Exception {
     */  
                .execute()
        logger.info("--> waiting for block to kick in on node [{}]", blockedNode);
        logger.info("--> deleting indices before restoring");
        } else {
        final int maxRetries = randomIntBetween(1, 10);  
            for (int j = 0; j < 10; j++) {
            "test-repo",
            .prepareCreateSnapshot("test-repo", "test-snap-2")
                .cluster()
            unblockAllDataNodes("test-repo");
        disableRepoConsistencyCheck(
                .prepareSnapshotStatus("test-repo")  
            .prepareRestoreSnapshot("test-repo", "test-snap")
        if (throttleRestore) {  
                .cluster()  
 */  
        createRepository("test-repo", "fs", repositoryLocation);  
                client().admin()
        logger.info("--> waiting for block to kick in");  
                .cluster()
        prepareCreate("test-idx").setSettings(Settings.builder().put("index.allocation.max_retries", Integer.MAX_VALUE)).get();  
                    logger.info("--> close index while non-partial snapshot is running");
            .getSetting("test", IndexMetadata.SETTING_INDEX_UUID);  
                client.admin().indices().prepareClose("test-idx-1").get();
        assertThat(snapshotStatus.includeGlobalState(), equalTo(false));
        // test getting snapshot status for available and unavailable snapshots where ignoreUnavailable is true
    }
            .get()
            .prepareCreateSnapshot(repoName, snapName)
    }
                .prepareSnapshotStatus("test-repo")  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;  
        assertThat(restoreResponse.getRestoreInfo().successfulShards(), equalTo(numShards.numPrimaries));  
            .cluster()
                .put("random", randomAlphaOfLength(10))
        final Client client = client();
            ArrayList<String> indicesToFlush = new ArrayList<>();  
        final Map<String, IndexId> indexIds = repositoryData.getIndices();
        logger.info("--> try deleting snapshot");
            logger.info("--> no failures");
            List<SnapshotIndexShardStatus> shards = snapshotStatus.getShards();  
        OpenSearchIntegTestCase.putRepository(clusterAdmin(), "test-repo", "mock", false, settings);  
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()  
        assertEquals(1, snapshotInfo.shardFailures().size());
    }  
import java.util.stream.IntStream;
import static org.hamcrest.Matchers.greaterThan;
        Client client = client();
        logger.info("--> wait for restore to finish");
        clusterAdmin().prepareRestoreSnapshot(repoName, "snap-2")
                for (SnapshotShardFailure shardFailure : createSnapshotResponse.getSnapshotInfo().shardFailures()) {
        ensureGreen();
                .indices()
            "mock",
 * license agreements. See the NOTICE file distributed with
        }
            String historyUUID = shardStats.getCommitStats().getUserData().get(Engine.HISTORY_UUID_KEY);  
        createRepository(  
        response = client.admin().cluster().prepareSnapshotStatus("test-repo").addSnapshots("test-snap").execute().actionGet();
            TimeUnit.MINUTES
            client.admin()
        ensureGreen();
                equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
            .actionGet();
        Client client = client();
            ClusterState clusterState = client.admin().cluster().prepareState().get().getState();
import org.opensearch.common.unit.TimeValue;  
        String blockedNode = blockNodeWithIndex(repo, index);  
                .actionGet();
        logger.info("--> delete index");
     * all Store references held onto by the snapshot are released.
        SnapshotException ex = expectThrows(  
import static org.opensearch.index.shard.IndexShardTestCase.getEngine;  
            assertEquals(1, clusterStateResponse.getState().getNodes().getDataNodes().size());
            for (int j = 0; j < nbDocs; j++) {
            .prepareCreateSnapshot(repositoryName, snapshotName)
        String repoName = "test-restore-snapshot-repo";
            "test-repo",
                index("test-idx", "_doc", Integer.toString(i * 10 + j), "foo", "bar" + i * 10 + j);  
            assertThat(clusterState.getMetadata().hasIndex(dottedHiddenIndex), equalTo(false));  
        RestoreSnapshotResponse restoreResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
            copyRestoreUUID.equals(originalIndexUUID)
        }  
            .setWaitForCompletion(true)
            unassignedInfo -> assertThat(unassignedInfo.getReason(), equalTo(UnassignedInfo.Reason.NEW_INDEX_RESTORED)),  
        Client client = client();
        }
        logger.info("--> deleting all snapshots");
        );
        );
        indexRandomDocs(indexName, newDocCount);
        assertAcked(prepareCreate("test-idx", 2, indexSettingsNoReplicas(between(2, 10))));
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(snapshotsStatusResponse.getSnapshots().size(), equalTo(1));
        assertEquals(indicesPerSnapshot.size(), response.getSnapshots().size());
        assertThat(snapshotStatus.getState(), equalTo(State.STARTED));
 * under the License.  
import static org.hamcrest.Matchers.equalTo;  
