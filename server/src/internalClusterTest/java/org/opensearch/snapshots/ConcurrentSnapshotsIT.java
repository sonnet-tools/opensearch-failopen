        assertEquals(RestStatus.OK, snapshotInfo.status()); // Ensure the snapshot status is OK
    public void testAbortNotStartedSnapshotWithoutIO() throws Exception {
        createIndexWithContent("index-one");
        disableRepoConsistencyCheck("This test corrupts the repository on purpose");
        createIndexWithContent("index-one");
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));
        logger.info("--> waiting for concurrent snapshot(s) to finish");
        final String snapshotOne = snapshots.get(0);
        final ActionFuture<AcknowledgedResponse> deleteSnapshotOne = startDeleteSnapshot(repoName, snapshotOne);
        final String clusterManagerNode = internalCluster().getClusterManagerName();
import static org.hamcrest.Matchers.is;
        // We're blocking a some of the snapshot threads when we block the first repo below so we have to make sure we have enough threads
    }
        final String repoName = "test-repo";
import java.util.Arrays;
        final UncategorizedExecutionException ex = expectThrows(UncategorizedExecutionException.class, deleteFuture::actionGet);
        assertThat(firstSnapshotInfo.reason(), is("Snapshot was aborted by deletion"));
    private ActionFuture<AcknowledgedResponse> startDeleteFromNonClusterManagerClient(String repoName, String snapshotName) {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        unblockNode(otherBlockedRepoName, dataNode);
    private static void assertSnapshotStatusCountOnRepo(String otherBlockedRepoName, int count) {
        snapTwoResponse.get();
import org.opensearch.cluster.SnapshotsInProgress;
        final String secondSnapshot = "snapshot-two";
    }
    }
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
            repoName,
        internalCluster().startClusterManagerOnlyNode();
        awaitNumberOfSnapshotsInProgress(4);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        createIndexWithContent("test-index");
                .put("index.routing.allocation.exclude._name", nodeExclude)
            "failing-snapshot-1"
        }
        networkDisruption.stopDisrupting();
        assertAcked(startDeleteSnapshot(repoName, snapshotTwo).get());
            awaitNDeletionsInProgress(1);
        final ActionFuture<AcknowledgedResponse> deleteFuture = startAndBlockOnDeleteSnapshot(repoName, "*");
        awaitNumberOfSnapshotsInProgress(1);
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
        awaitNumberOfSnapshotsInProgress(1);
        createIndex("foo");
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode();
        }
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);
    public void testQueuedDeletesWithFailures() throws Exception {
            dataNode
    }
        final Path repoPath = randomRepoPath();
        } catch (RepositoryException re) {
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state()); // Ensure the snapshot was successful
        createRepository(repoName, "mock");
        createNSnapshots(repoName, randomIntBetween(2, 5));
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, "snapshot-queued");
        final ActionFuture<CreateSnapshotResponse> snapshotThree = startFullSnapshotFromNonClusterManagerClient(repoName, "snapshot-three");
            "snapshot-one"
            assertThat(snapshotsInProgress.entries().get(0).state(), is(SnapshotsInProgress.State.ABORTED));
        final ActionFuture<AcknowledgedResponse> deleteFuture = startDeleteFromNonClusterManagerClient(repoName, "*");
        logger.info("--> wait for delete to be enqueued in cluster state");
        final String testIndex = "test-idx";
            .get();
        awaitNDeletionsInProgress(2);
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, snapshotName);
        assertFalse(createSnapshot1Future.isDone());
            repoName,
        createIndexWithContent("index-one");
        internalCluster().startClusterManagerOnlyNode();
        createIndexWithContent("index-one");
    }
        disableRepoConsistencyCheck("This test corrupts the repository on purpose");
    }
 */
        createIndexWithContent("index-slow");
    private ActionFuture<CreateSnapshotResponse> startFullSnapshotFromClusterManagerClient(String repoName, String snapshotName) {
        ensureGreen();
        throws InterruptedException {
        ensureGreen();
        createRepository(repoName, "mock");
                .setWaitForCompletion(true)
        unblockNode(otherBlockedRepoName, dataNode);
        final String firstIndex = "index-one";
        assertAcked(deleteSnapshotOne.get());
        final String firstSnapshot = "first-snapshot";
        );
        waitForBlock(initialClusterManager, repoName, TimeValue.timeValueSeconds(30L));
            .setWaitForCompletion(false)
        createNSnapshots(otherRepoName, randomIntBetween(1, 5));
        blockClusterManagerFromDeletingIndexNFile(repoName);
        createIndex("foo");
        }
/*
        createRepository(repoName, "mock", repoPath);
        assertThat(firstSnapshotResponse.get().getSnapshotInfo().state(), is(SnapshotState.FAILED));
        createIndexWithContent("index");
        createIndexWithContent(indexFast, dataNode2, dataNode);
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> updateRepository(repoName, "mock", newSettings));
        for (ActionFuture<CreateSnapshotResponse> snapshotFuture : snapshotFutures) {
        createIndexWithContent("test-idx");
 * not use this file except in compliance with the License.
        final ActionFuture<CreateSnapshotResponse> snapOneResponse = client().admin()
        awaitNDeletionsInProgress(1);
        // We're blocking a some of the snapshot threads when we block the first repo below so we have to make sure we have enough threads
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFileExists;
        logger.info("--> make sure all failing requests get a response");
        assertFileExists(indexNBlob);
        expectThrows(SnapshotException.class, createSlowFuture::actionGet);
                assertThat(rex.repository(), is("_all"));
            .setSnapshots(GetSnapshotsRequest.CURRENT_SNAPSHOT)
    public void testStartWithSuccessfulShardSnapshotPendingFinalization() throws Exception {
            final String snapshot = "snap-" + i;
        createIndexWithContent("index-two", dataNode2, dataNode);
        final ActionFuture<CreateSnapshotResponse> snapTwoResponse = client().admin()
        createIndexWithContent("index-test");
        final String otherBlockedRepoName = "test-repo-blocked-2";
        while (snapshotNames.isEmpty() == false) {
        boolean blockedDelete = false;
        awaitNoMoreRunningOperations();
        final List<String> snapshotNames = createNSnapshots(repoName, limitToTest + 1);
        networkDisruption.stopDisrupting();
    }
                snapshotFutures.add(startFullSnapshot(repoName, "snap-" + i));
            .get();
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
            blockedRepoName,
        }
        createRepository(otherBlockedRepoName, "mock");
        final String snapshotOne = "snap-1";
                client().admin().cluster().prepareHealth(testIndex).execute().actionGet().getRelocatingShards(),
            // when the request is retried and gets executed after the above delete
        ensureStableCluster(3, dataNode);
        final SnapshotException sne = expectThrows(SnapshotException.class, createSnapshot2Future::actionGet);
        unblockNode(blockedRepoName, internalCluster().getClusterManagerName());
        assertBusy(() -> assertThat(currentSnapshots(otherRepoName), empty()), 30L, TimeUnit.SECONDS);
        internalCluster().stopCurrentClusterManagerNode();
            "blocked-snapshot",
        });
        assertAcked(deleteFuture.get());
        assertSuccessful(createSlowFuture1);
        assertThat(client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots(), empty());
        unblockNode(repoName, clusterManagerNode);
        final ActionFuture<AcknowledgedResponse> firstDeleteFuture = startAndBlockOnDeleteSnapshot(repoName, "*");
    public void testCascadedAborts() throws Exception {
        Path indexNBlob = repoPath.resolve(BlobStoreRepository.INDEX_FILE_PREFIX + generation);
        }
        awaitNumberOfSnapshotsInProgress(2);
            1L,
            deleteResponses.add(client().admin().cluster().prepareDeleteSnapshot(repoName, "*").execute());
            .setWaitForCompletion(true)
        createNSnapshots(repoName, randomIntBetween(2, 5));
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(LARGE_SNAPSHOT_POOL_SETTINGS);
        assertSnapshotStatusCountOnRepo(blockedRepoName, 2);
        final ActionFuture<AcknowledgedResponse> deleteSnapshotTwo = startDeleteSnapshot(repoName, snapshotTwo);
        final String otherRepoName = "test-repo";
            assertThat(currentSnapshots(repoName), hasSize(1));
            containsInAnyOrder(secondSnapshotInfo, thirdSnapshotInfo)
        logger.info("--> indexing some data");
        assertSuccessful(createSlowFuture2);
import org.opensearch.core.action.ActionListener;
        final int countOtherRepo = randomIntBetween(2, 5);
        assertAcked(future.actionGet()); // Wait for the delete operation to complete
    public void testQueuedSnapshotsWaitingForShardReady() throws Exception {
        final String repoName = "test-repo";
            .prepareCreateSnapshot(repoName, snapshotOne)
        final String repoName = "test-repo";
import org.opensearch.test.OpenSearchIntegTestCase;
        internalCluster().startClusterManagerOnlyNode();
    }
        final ActionFuture<CreateSnapshotResponse> blockedSnapshot = startFullSnapshot(repoName, "snap-blocked");
        final ActionFuture<AcknowledgedResponse> secondDeleteFuture = startDeleteSnapshot(repoName, "*");
        if (blockedDelete == false || limitToTest == 1) {
        assertThat(client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots(), empty());
        assertAcked(prepareCreate(testIndex, 2, indexSettingsNoReplicas(between(2, 10))));
        final ActionFuture<CreateSnapshotResponse> snapshotFour = startFullSnapshot(repoName, "snapshot-four", true);
        internalCluster().startDataOnlyNode();
        final List<String> snapshots = createNSnapshots(repoName, 2);
import org.opensearch.cluster.SnapshotDeletionsInProgress;
        }
        assertAcked(deleteSnapshotTwo.get());
        final String repoName = "test-repo";
                    .getSnapshots()
    public void testDeletesAreBatched() throws Exception {
        createNSnapshots(blockedRepoName, randomIntBetween(1, 5));
            .prepareDeleteSnapshot(repoName, "*")
        // Attempt to update the repository settings while the snapshot is in progress
    }
        final ActionFuture<CreateSnapshotResponse> thirdSnapshotResponse = client().admin()
            firstSnapshot
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
        final String snapshotName = "snapshot-1";
        final String dataNode = startDataNodeWithLargeSnapshotPool();
        );
        waitForBlock(clusterManagerNode, blockedRepoName, TimeValue.timeValueSeconds(30L));
        internalCluster().setDisruptionScheme(networkDisruption);
        ensureStableCluster(3, dataNode);
        assertThat(createSlowFuture.isDone(), is(false));
            repoName,
    }
        assertThat(secondSnapshotResponse.isDone(), is(false));
        createNSnapshots(otherRepoName, randomIntBetween(1, 5));
        final String snapshotOne = snapshotNames.get(0);
        internalCluster().startDataOnlyNode();
            final SnapshotDeletionsInProgress deletionsInProgress = state.custom(SnapshotDeletionsInProgress.TYPE);
        assertThat(firstSnapshotResponse.isDone(), is(false));
        }
    public void testQueuedOperationsOnClusterManagerRestart() throws Exception {
        }, 30L, TimeUnit.SECONDS);
        ensureYellow(testIndex);
        logger.info("--> deleting snapshot [{}] from repo [{}] from non cluster-manager client", snapshotName, repoName);
        final ActionFuture<CreateSnapshotResponse> snapshotFour = startFullSnapshotFromNonClusterManagerClient(repoName, "snapshot-four");
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(firstDeleteFuture.get().isAcknowledged(), is(true));
        unblockNode(repoName, clusterManagerName);
    }
            }
            "failing-snapshot-2"
        assertBusy(() -> assertThat(currentSnapshots(repoName), hasSize(3)), 30L, TimeUnit.SECONDS);
        assertThat(secondSnapshotResponse.get().getSnapshotInfo().state(), is(SnapshotState.PARTIAL));
            "other-blocked-snapshot",
            client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots(),
        assertAcked(startDeleteSnapshot(otherRepoName, "*").get());
            .admin()
        logger.info("--> created {} in [{}]", snapshotNames, repoName);
        final ActionFuture<CreateSnapshotResponse> createSlowFuture2 = startFullSnapshotBlockedOnDataNode(
    public void testAbortOneOfMultipleSnapshots() throws Exception {
        assertSuccessful(snapshotThree);
            "first-snapshot",
        waitForBlock(internalCluster().getClusterManagerName(), blockedRepoName, TimeValue.timeValueSeconds(30L));
        logger.info("--> start third snapshot");
        }
        internalCluster().stopCurrentClusterManagerNode();
        final NetworkDisruption networkDisruption = isolateClusterManagerDisruption(NetworkDisruption.DISCONNECT);
            assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        createNSnapshots(repoName, randomIntBetween(2, 5));
    public void testQueuedOperationsOnClusterManagerDisconnect() throws Exception {
    }
        assertSuccessful(createSlowFuture);
        final ActionFuture<AcknowledgedResponse> deleteFuture = startDeleteSnapshot(repoName, snapshotName);
        final NetworkDisruption networkDisruption = isolateClusterManagerDisruption(NetworkDisruption.DISCONNECT);
        assertSuccessful(snapshotFuture);
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        final String firstSnapshot = "snapshot-one";
            assertAcked(deleteResponse.get());
        assertAcked(allDeletedResponse.get());
        final String dataNode = internalCluster().startDataOnlyNode();
    private void createIndexWithContent(String indexName, String nodeInclude, String nodeExclude) {
        Files.write(indexNBlob, randomByteArrayOfLength(1), StandardOpenOption.TRUNCATE_EXISTING);
 */
                .build()
        logger.info("--> creating full snapshot [{}] to repo [{}] from non cluster-manager client", snapshotName, repoName);
        Settings.Builder settings = randomRepositorySettings();
        final String repoName = "test-repo";
        final String otherRepoName = "test-repo";
        createNSnapshots(repoName, randomIntBetween(2, 5));
        final ActionFuture<CreateSnapshotResponse> snapshotFour = startFullSnapshotFromNonClusterManagerClient(repoName, "snapshot-four");
    }
        final String blockedRepoName = "test-repo-blocked-1";
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);
        final long generation = getRepositoryData(repoName).getGenId();
        final ActionFuture<CreateSnapshotResponse> createThirdSnapshot = client(clusterManagerNode).admin()
            final ConcurrentSnapshotExecutionException csen2 = expectThrows(
        final ActionFuture<CreateSnapshotResponse> snapshotThree = startFullSnapshotFromNonClusterManagerClient(repoName, "snapshot-three");
        awaitClusterState(state -> {
        awaitNumberOfSnapshotsInProgress(2);
            client().admin()
        internalCluster().startClusterManagerOnlyNode();
        awaitClusterState(
        // Start deleting the snapshot and block it on the cluster manager node
import static org.hamcrest.Matchers.contains;
        awaitNumberOfSnapshotsInProgress(2);
            if (toDelete.isEmpty()) {
        awaitNDeletionsInProgress(1);
        }
        assertSuccessful(blockedSnapshot);
        createRepository(repoName, "mock");
    public void testAssertMultipleSnapshotsAndPrimaryFailOver() throws Exception {
        final ActionFuture<CreateSnapshotResponse> firstSnapshotResponse = startFullSnapshotFromNonClusterManagerClient(
        );
import java.util.concurrent.TimeUnit;
        for (ActionFuture<AcknowledgedResponse> deleteResponse : deleteResponses) {
        corruptIndexN(repoPath, getRepositoryData(repoName).getGenId());
        final String repoName = "test-repo";
        Settings.Builder settings = randomRepositorySettings();
        // Second delete works out cleanly since the repo is unblocked now
        blockNodeOnAnyFiles(blockedRepoName, clusterManagerNode);
        );
        createRepository(blockedRepoName, "mock");
        createIndexWithContent(
        unblockNode(repoName, clusterManagerName); // Unblock the delete operation
        return false;
        assertEquals("trying to modify or unregister repository that is currently used", ex.getMessage());
        final String repoName = "test-repo";
        logger.info("--> waiting for second snapshot to finish and the other two snapshots to become aborted");
        try {
    }
        return client().admin()
        final List<String> snapshotNames = createNSnapshots(repoName, randomIntBetween(2, 5));
import java.io.IOException;
        assertThat(csen1.getMessage(), containsString(expectedFailureMessage));
 * this file be licensed under the Apache-2.0 license or a
            final SnapshotsInProgress snapshotsInProgress = state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
        newSettings.put("chunk_size", 2000, ByteSizeUnit.BYTES);
            dataNode
        createRepository(blockedRepoName, "mock");
            snapshotNames.add(name);
                .filter(s -> s.state() == SnapshotState.IN_PROGRESS)
            .cluster()
    public void testEquivalentDeletesAreDeduplicated() throws Exception {
        // We're blocking a some of the snapshot threads when we block the first repo below so we have to make sure we have enough threads
        );
        unblockNode(repoName, clusterManagerName);
        if (deleteFuture != null) {
        assertBusy(() -> {
        final String dataNode = internalCluster().startDataOnlyNode();
            // Ignored, thrown most of the time but due to retries when shutting down the cluster-manager could randomly pass
 * The OpenSearch Contributors require contributions made to
        assertThat(
        unblockNode(repoName, clusterManagerNode);
            client().admin().cluster().prepareCreateSnapshot(repoName, snapshot).setWaitForCompletion(true).execute(snapshotsListener);
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));
            .prepareCreateSnapshot(repoName, "snapshot-three")
            return snapshotsInProgress.entries().size() == 2 && snapshotHasCompletedShard(secondSnapshot, snapshotsInProgress);
                .cluster()
        final long generation = getRepositoryData(repoName).getGenId();
        createRepository(repoName, "mock");
        assertSnapshotStatusCountOnRepo(otherBlockedRepoName, 1);
        awaitNumberOfSnapshotsInProgress(1);
            secondSnapshot
        createNSnapshots(repoName, randomIntBetween(2, 5));
import java.nio.file.Path;
        final ActionFuture<AcknowledgedResponse> secondDeleteFuture = startDeleteSnapshot(repoName, "*");
        networkDisruption.startDisrupting();
    public void testMultipleReposAreIndependent() throws Exception {
        final String blockedRepoName = "repo-blocked";
            .execute();
            .cluster()
            .setWaitForCompletion(true)
        final String firstIndex = "index-one";
        final String clusterManagerNode = internalCluster().getClusterManagerName();
            .prepareDeleteSnapshot(repoName, "*")
        final String dataNode2 = internalCluster().startDataOnlyNode();
        logger.info("--> stopping current cluster-manager node");
                .prepareUpdateSettings()
        final Path repoPath = randomRepoPath();
        );
            .cluster()
        // Start a cluster with a cluster manager node and a data node
        blockNodeOnAnyFiles(repoName, clusterManagerNode);
        createRepository(repoName, "mock");
        startDeleteSnapshot(repoName, "*");
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));
        createRepository(repoName, "mock");
        createRepository(otherRepoName, "fs");
        unblockNode(repoName, dataNode);
        unblockNode(repoName, dataNode);
        internalCluster().setDisruptionScheme(networkDisruption);
        final String repoName = "test-repo";
        }
            .cluster()
        unblockNode(repoName, dataNode);
                    Settings.builder().put(SnapshotsService.MAX_CONCURRENT_SNAPSHOT_OPERATIONS_SETTING.getKey(), limitToTest).build()
 * compatible open source license.
            .prepareCreateSnapshot(repoName, snapshotName)
import java.util.ArrayList;
        internalCluster().startClusterManagerOnlyNode();
        createNSnapshots(otherRepoName, randomIntBetween(1, 5));
        assertSuccessful(createSlowFuture);
        createRepository(repoName, "mock");
        internalCluster().startClusterManagerOnlyNode();
            blockedRepoName,
        final String dataNode2 = internalCluster().startDataOnlyNode();
                .filter(s -> s.snapshotId().getName().equals(snapshotName))
            indexName,
        awaitNDeletionsInProgress(2);
        // left for the second repository's concurrent operations.
        createRepository(repoName, "mock");
    public void testBlockedRepoDoesNotBlockOtherRepos() throws Exception {
    private void corruptIndexN(Path repoPath, long generation) throws IOException {
        final String repoName = "test-repo";
 * license agreements. See the NOTICE file distributed with
        client().admin().cluster().prepareCreateSnapshot(repoName, "snapshot-blocked-2").setWaitForCompletion(false).get();
            assertThat(snapshotInfo.shardFailures().size(), equalTo(0));
        return Arrays.asList(MockTransportService.TestPlugin.class, MockRepository.Plugin.class);
        );
        final NetworkDisruption networkDisruption = isolateClusterManagerDisruption(NetworkDisruption.DISCONNECT);
        final String repoName = "test-repo";
            () -> assertThat(
        unblockNode(repoName, dataNode);
        final String otherRepoName = "test-repo";
        final String otherBlockedRepoName = "test-repo-blocked-2";
        createRepository(repoName, "mock", repoPath);
 * KIND, either express or implied.  See the License for the
        assertSuccessful(createSlowFuture3);
        awaitNoMoreRunningOperations();
        createNSnapshots(repoName, randomIntBetween(1, 5));
            repoName,
/*
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> updateRepository(repoName, "mock", settings));
        logger.info("--> make sure all failing requests get a response");
    public void testQueuedSnapshotOperationsAndBrokenRepoOnClusterManagerFailOver2() throws Exception {
    @Override
            repoName,
import org.opensearch.discovery.AbstractDisruptionTestCase;
        // Snapshot should have been aborted
        createIndexWithContent("index-one");
        unblockNode(blockedRepoName, dataNode);
            .cluster()
        createFullSnapshot(repoName, firstSnapshot);
            snapshotNames.add(snapshot);
 * You may obtain a copy of the License at
        networkDisruption.stopDisrupting();
        createIndexWithContent("index-one");
        expectThrows(OpenSearchException.class, snapshotFour::actionGet);
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));
        internalCluster().stopCurrentClusterManagerNode();
        internalCluster().startDataOnlyNode();
        internalCluster().startDataOnlyNode();
        return internalCluster().nonClusterManagerClient()
    public void testQueuedOperationsAndBrokenRepoOnClusterManagerFailOver() throws Exception {
            assertFalse(deleteResponse.isDone());
                    .get()
        snapOneResponse.get();
        logger.info("--> verify all snapshots were aborted");
    private void awaitNDeletionsInProgress(int count) throws Exception {
        waitForBlock(dataNode2, repoName, TimeValue.timeValueSeconds(30L));
        final ActionFuture<CreateSnapshotResponse> createSlowFuture3 = startFullSnapshotBlockedOnDataNode(
            .prepareCreateSnapshot(repoName, "snapshot-three")
        return internalCluster().startDataOnlyNode(LARGE_SNAPSHOT_POOL_SETTINGS);
    public void testLongRunningSnapshotAllowsConcurrentSnapshot() throws Exception {
    private List<String> createNSnapshots(String repoName, int count) {
        final ActionFuture<AcknowledgedResponse> secondDeleteFuture = client(clusterManagerNode).admin()
        blockNodeOnAnyFiles(blockedRepoName, clusterManagerNode);
        internalCluster().startDataOnlyNode();
        disableRepoConsistencyCheck("This test corrupts the repository on purpose");
        expectThrows(RepositoryException.class, secondDeleteFuture::actionGet);
            .execute();
                ++blockedSnapshots;
    }
            .execute();
import org.opensearch.snapshots.mockstore.MockRepository;
        final String repoName = "test-repo";
        );
        ensureStableCluster(3);
        final String clusterManagerName = internalCluster().getClusterManagerName();
            assertThat(snapshotResponse.getSnapshotInfo().state(), is(SnapshotState.SUCCESS));
        waitForBlock(initialClusterManager, otherRepoName, TimeValue.timeValueSeconds(30L));
        assertThat(client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots(), empty());
        createIndexWithContent("test-index");
        );
                    .prepareGetSnapshots(repoName)
                // very rarely a cluster-manager node fail-over happens at such a time
        for (String snapshot : Arrays.asList(snapshotOne, snapshotTwo)) {
        ensureStableCluster(3, dataNode);
        final List<SnapshotStatus> snapshotStatuses = snapshotsStatusResponse.getSnapshots();
                }
        logger.info("--> verify that all snapshots are gone and no more work is left in the cluster state");
        final String dataNode = internalCluster().startDataOnlyNode();
    }
            .cluster()
                .execute()
        createIndexWithContent("index-one");
        final String dataNode = internalCluster().startDataOnlyNode();
        expectThrows(SnapshotException.class, snapshotThree::actionGet);
            dataNode
                deleteFuture = startDeleteSnapshot(repoName, randomFrom(snapshotNames));
        final String dataNode = internalCluster().startDataOnlyNode();
        final String dataNode2 = internalCluster().startDataOnlyNode();
        final String dataNode = internalCluster().startDataOnlyNode();
        logger.info("--> creating full snapshot [{}] to repo [{}] from cluster-manager client", snapshotName, repoName);
import static org.hamcrest.Matchers.not;
 * SPDX-License-Identifier: Apache-2.0
        final ActionFuture<AcknowledgedResponse> fut = startDeleteSnapshot(repoName, snapshotName);
        final ActionFuture<AcknowledgedResponse> deleteSnapshotOne = startDeleteSnapshot(repoName, snapshotOne);
            try {
        awaitNoMoreRunningOperations();
        createRepository(repoName, "mock");
    private static boolean snapshotHasCompletedShard(String snapshot, SnapshotsInProgress snapshotsInProgress) {
            "blocked-snapshot",
            "blocked-snapshot",
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
        assertSuccessful(createSnapshot1Future);
        assertThat(createSlowFuture.isDone(), is(false));
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertSuccessful(createSlowFuture1);
import org.opensearch.repositories.RepositoryException;
import org.opensearch.test.transport.MockTransportService;
        client().admin().cluster().prepareCreateSnapshot(otherRepoName, "snapshot-other-blocked-2").setWaitForCompletion(false).get();
        );
        assertAcked(deleteSnapshotOne.get());
        final String firstSnapshot = "snapshot-one";
        final ActionFuture<AcknowledgedResponse> deleteFuture = startDeleteFromNonClusterManagerClient(blockedRepoName, "*");
        );
        ActionFuture<AcknowledgedResponse> firstDeleteFuture = client(clusterManagerNode).admin()
import java.util.List;
    public void testQueuedDeleteAfterFinalizationFailure() throws Exception {
        client().admin().cluster().prepareCreateSnapshot(otherRepoName, "snapshot-other-blocked-1").setWaitForCompletion(false).get();
        final ActionFuture<AcknowledgedResponse> failedDeleteFuture = client(clusterManagerNode).admin()
    private static List<SnapshotInfo> currentSnapshots(String repoName) {
            .cluster()
                assertAcked(deleteFuture.actionGet());
    }
    }
        final String dataNode2 = internalCluster().startDataOnlyNode();
        createIndexWithContent("index-two");
            .setIndices(secondIndex)
        createRepository(otherRepoName, "fs");
    private static String startDataNodeWithLargeSnapshotPool() {
        corruptIndexN(repoPath, generation);
        createRepository(otherRepoName, "mock");
        final ActionFuture<CreateSnapshotResponse> firstSnapshotResponse = startFullSnapshotBlockedOnDataNode(
            "blocked-snapshot-2",
        // make sure second snapshot is in progress before restarting data node
            repoName,
        logger.info("--> start two snapshots");
        final String otherRepoName = "other-test-repo";
        createIndexWithContent("test-index");
import static org.hamcrest.Matchers.empty;
        // Poll for snapshot to actually start
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import static org.hamcrest.Matchers.endsWith;
        unblockNode(repoName, clusterManagerNode);
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, snapshotName);
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
        expectThrows(RepositoryException.class, deleteFuture::actionGet);
        assertThat(getRepositoryData(repoName).getGenId(), is(0L));
        final ActionFuture<CreateSnapshotResponse> snapshotThreeFuture = startFullSnapshotFromNonClusterManagerClient(
        unblockNode(repoName, dataNode); // Unblock the snapshot
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        final ActionFuture<CreateSnapshotResponse> secondSnapshotResponse = startFullSnapshotFromClusterManagerClient(
        assertEquals("trying to modify or unregister repository that is currently used", ex.getMessage());
        final String repoName = "test-repo";
import org.opensearch.OpenSearchException;
        final SnapshotsStatusResponse snapshotsStatusResponse = client().admin()
        final String dataNode = internalCluster().startDataOnlyNode();
            "other-blocked-snapshot",
        createRepository(repoName, "mock");
        awaitNDeletionsInProgress(1);
        expectThrows(UncategorizedExecutionException.class, firstDeleteFuture::actionGet);
        createRepository(repoName, "mock");
        final SnapshotInfo thirdSnapshotInfo = assertSuccessful(thirdSnapshotResponse);
import static org.hamcrest.Matchers.hasSize;
        assertThat(snapshotThree.get().getSnapshotInfo().state(), is(SnapshotState.PARTIAL));
    public void testClusterManagerFailoverOnFinalizationLoop() throws Exception {
        }
    public void testStartDeleteDuringFinalizationCleanup() throws Exception {
        }
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
        createRepository(repoName, "mock");
        startAndBlockOnDeleteSnapshot(repoName, "*");
        unblockNode(repoName, clusterManagerNode);
            assertThat(snapshotDeletionsInProgress.getEntries(), empty());
        networkDisruption.startDisrupting();
        internalCluster().startClusterManagerOnlyNodes(3);
        createRepository(otherRepoName, "fs");
        // We're blocking a some of the snapshot threads when we block the first repo below so we have to make sure we have enough threads
        assertThat(repositoryDataAfterDeletes.getSnapshotIds(), contains(slowSnapshotInfo.snapshotId()));
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(otherRepoName);
        SnapshotInfo snapshotInfo = createFullSnapshot(repoName, snapshotName);
            .execute();
        createNSnapshots(repoName, randomIntBetween(2, 5));
        final ActionFuture<CreateSnapshotResponse> createSlowFuture = startFullSnapshotBlockedOnDataNode(
        assertThat(secondSnapshotResponse.isDone(), is(false));
            .setIndices(testIndex)
        );
        unblockNode(blockedRepoName, dataNode);
            assertSuccessful(snapshotFuture);
        final SnapshotException sne = expectThrows(SnapshotException.class, snapshotFuture::actionGet);
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, "second-snapshot");
            () -> assertThat(
            .cluster()
    }
        unblockNode(repoName, dataNode);
        final String secondSnapshot = "snapshot-two";
        assertThat(snapshotException.getMessage(), containsString(SnapshotsInProgress.ABORTED_FAILURE_TEXT));
        assertSuccessful(
    public void testConcurrentOperationsLimit() throws Exception {
        assertSuccessful(otherSnapshot);
        startAndBlockOnDeleteSnapshot(repoName, "*");
        createFullSnapshot(repoName, "first-snapshot");
        assertSuccessful(createSlowFuture3);
            assertThat(currentSnapshots(repoName), hasSize(2));
        ensureStableCluster(3);
        internalCluster().startClusterManagerOnlyNodes(3);
            // ignored
        expectThrows(RepositoryException.class, firstDeleteFuture::actionGet);
        assertSuccessful(snapshotThree);
            timeout.millis(),
        assertThat(secondSnapshotResponse.get().getSnapshotInfo().state(), is(SnapshotState.FAILED));
        createIndexWithContent("index");
        internalCluster().startDataOnlyNode();
package org.opensearch.snapshots;
        }
            dataNode
                assertThat(entry.snapshot().getSnapshotId().getName(), not(secondSnapshot));
        createRepository(otherBlockedRepoName, "mock");
        awaitNumberOfSnapshotsInProgress(1);
        assertThat(firstSnapshotResponse.isDone(), is(false));
        createIndexWithContent(secondIndex, dataNode2, dataNode);
        assertThat(secondDeleteFuture.get().isAcknowledged(), is(true));
        allowNodes(testIndex, 1);
        awaitNoMoreRunningOperations();
        createNSnapshots(repoName, randomIntBetween(1, 5));
        internalCluster().startDataOnlyNode();
        assertAcked(deleteFuture.get());
public class ConcurrentSnapshotsIT extends AbstractSnapshotIntegTestCase {
        for (int i = 0; i < 100; i++) {
            state -> state.custom(SnapshotDeletionsInProgress.TYPE, SnapshotDeletionsInProgress.EMPTY).getEntries().size() == count
        internalCluster().startDataOnlyNode();
                client().admin().cluster().listTasks(new ListTasksRequest()).get().getTasks().stream().map(TaskInfo::getAction).toList(),
import static org.hamcrest.Matchers.containsString;
        assertThat(sne.getCause().getMessage(), containsString("exception after block"));
import org.opensearch.core.common.unit.ByteSizeUnit;
        internalCluster().startClusterManagerOnlyNode();
    }
        // Two snapshots and two distinct delete operations move us 4 steps from -1 to 3
        awaitNumberOfSnapshotsInProgress(blockedSnapshots);
                .findAny()
            repoName,
        final ActionFuture<CreateSnapshotResponse> otherSnapshot = startFullSnapshot(repoName, "other-snapshot");
        final String repoName = "test-repo";
        final int numSnapshots = randomIntBetween(1, 4);
        final PlainActionFuture<Collection<CreateSnapshotResponse>> allSnapshotsDone = PlainActionFuture.newFuture();
        final String clusterManagerName = internalCluster().getClusterManagerName();
        createIndexWithContent("index-test");
        awaitNoMoreRunningOperations();
            dataNode
 * under the License.
        blockClusterManagerFromDeletingIndexNFile(repoName);
        final String repoName = "test-repo";
            "slow-snapshot",
            "blocked-snapshot-2",
        logger.info("--> wait for snapshot on second data node to finish");
            client().admin().cluster().prepareDeleteSnapshot(repoName, toDelete.toArray(Strings.EMPTY_ARRAY)).execute(future);
            otherBlockedRepoName,
        final String dataNode = internalCluster().startDataOnlyNode();
        final String repoName = "test-repo";
            repoName,
import java.nio.file.Files;
        createIndexWithContent("test-index");
        assertBusy(() -> assertThat(currentSnapshots(repoName), hasSize(3)), 30L, TimeUnit.SECONDS);
        createIndexWithContent(secondIndex, dataNode2, dataNode);
        assertThat(client().prepareSearch(testIndex).setSize(0).get().getHits().getTotalHits().value(), equalTo(100L));
    public void testMultiplePartialSnapshotsQueuedAfterDelete() throws Exception {
            assertThat(client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots(), empty());
        client().admin().cluster().prepareCreateSnapshot(repoName, "snapshot-blocked-1").setWaitForCompletion(false).get();
            + "] operations and the current limit for concurrent snapshot operations is set to ["
            () -> assertThat(
        final Collection<StepListener<AcknowledgedResponse>> deleteFutures = new ArrayList<>();
        );
        client().admin().cluster().prepareCreateSnapshot(repoName, "snapshot-three").setWaitForCompletion(false).get();
            + limitToTest
    }
        logger.info("--> start relocations");
            .execute();
            .prepareCreateSnapshot(repoName, snapshotName)
        assertThat(secondDeleteFuture.get().isAcknowledged(), is(true));
        expectThrows(RepositoryException.class, failedDeleteFuture::actionGet);
        return internalCluster().nonClusterManagerClient().admin().cluster().prepareDeleteSnapshot(repoName, snapshotName).execute();
        final List<ActionFuture<AcknowledgedResponse>> deleteResponses = new ArrayList<>(deletes);
        );
        logger.info("--> verify that all snapshots are gone");
        awaitNDeletionsInProgress(1);
        Settings.Builder newSettings = randomRepositorySettings();
        assertThat(firstSnapshotResponse.get().getSnapshotInfo().state(), is(SnapshotState.PARTIAL));
            + limitToTest
        createRepository(blockedRepoName, "mock");
        blockNodeOnAnyFiles(repoName, clusterManagerNode);
    protected Settings nodeSettings(int nodeOrdinal) {
        awaitNumberOfSnapshotsInProgress(3);
            .prepareCreateSnapshot(repoName, snapshotTwo)
        final String repoName = "test-repo";
        blockNodeOnAnyFiles(repoName, dataNode2);
        final ActionFuture<CreateSnapshotResponse> snapshotThree = startAndBlockFailingFullSnapshot(repoName, "snap-other");
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.core.common.Strings;
        unblockNode(repoName, dataNode2);
        internalCluster().startDataOnlyNode();
        awaitNDeletionsInProgress(1);
        });
        final ActionFuture<CreateSnapshotResponse> createSlowFuture3 = startFullSnapshotBlockedOnDataNode(
        createIndexWithContent("index-one");
                    }
        );
        }
        assertAcked(deleteFuture.get());
            .setIndices("does-not-exist-*")
        logger.info("--> wait for snapshot to complete");
        blockDataNode(repoName, dataNode);
            final ClusterState state = clusterService().state();
        blockNodeOnAnyFiles(repoName, clusterManagerNode);
        final String repoName = "test-repo";
        unblockNode(repoName, clusterManagerName);
        createIndexWithContent("test-index");
    }
        internalCluster().startDataOnlyNodes(2);
        unblockNode(repoName, clusterManagerName);
    }
        final SnapshotInfo slowSnapshotInfo = assertSuccessful(createSlowFuture);
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        awaitNDeletionsInProgress(1);
            otherBlockedRepoName,
    }
        return fut;
        // Snapshot should have been aborted
        assertBusy(() -> {
            indexSettingsNoReplicas(1).put("index.routing.allocation.include._name", nodeInclude)
        internalCluster().startClusterManagerOnlyNode();
        final ActionFuture<CreateSnapshotResponse> createSlowFuture = startAndBlockFailingFullSnapshot(blockedRepoName, "blocked-snapshot");
                // leading to the delete retry to run into a situation where the snapshot has already been deleted potentially
 * GitHub history for details.
        final String repoName = "test-repo";
        assertThat(ex.getRootCause(), instanceOf(IOException.class));
            return snapshotsInProgress.entries().size() == 2 && snapshotHasCompletedShard(secondSnapshot, snapshotsInProgress);
        awaitNDeletionsInProgress(2);
        internalCluster().setDisruptionScheme(networkDisruption);
            final SnapshotsInProgress snapshotsInProgress = state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
            dataNode
            .setIndices(testIndex)
        assertAcked(deleteFuture.get(30L, TimeUnit.SECONDS));
        assertSuccessful(snapshotFuture);
        disableRepoConsistencyCheck("This test corrupts the repository on purpose");
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);
        final String dataNode = startDataNodeWithLargeSnapshotPool();
        );
        waitForBlock(dataNode, repoName, TimeValue.timeValueSeconds(30L));
        assertAcked(deleteFuture.get());
        // left for the second concurrent snapshot.
        awaitNDeletionsInProgress(2);
        createIndexWithContent(firstIndex);
        }, 30L, TimeUnit.SECONDS);
                // when shutting down the initial cluster-manager and fails the transport listener
        unblockNode(repoName, clusterManagerName);
            final SnapshotDeletionsInProgress snapshotDeletionsInProgress = state.custom(SnapshotDeletionsInProgress.TYPE);
        internalCluster().startClusterManagerOnlyNodes(3);
        internalCluster().startDataOnlyNode();
        assertThat(firstSnapshotResponse.isDone(), is(false));
        ensureStableCluster(4);
        // Verify that the update fails with an appropriate exception
        unblockNode(blockedRepoName, clusterManagerNode);
                    if (shard.state().completed()) {
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
            return deletionsInProgress.getEntries().size() == 1 && deletionsInProgress.getEntries().get(0).getSnapshots().size() == 3;
        final String repoName = "test-repo";
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        internalCluster().startClusterManagerOnlyNodes(3);
        createRepository(repoName, "mock", repoPath);
    public void testQueuedSnapshotOperationsAndBrokenRepoOnClusterManagerFailOverMultipleRepos() throws Exception {
        final String indexFast = "index-fast";
        }, 30L, TimeUnit.SECONDS);
            "slow-snapshot",
        unblockNode(repoName, clusterManagerName);
    }
            } catch (RepositoryException rex) {
    public void testClusterManagerFailOverWithQueuedDeletes() throws Exception {
        createRepository(blockedRepoName, "mock");
    }
        try {
        final String secondIndex = "index-two";
        final String repoName = "test-repo";
        waitForBlock(dataNode, repoName, TimeValue.timeValueSeconds(30L));
        client().admin()
        unblockNode(repoName, clusterManagerNode);
            "queued-snapshot"
        final int deletes = randomIntBetween(2, 10);
        internalCluster().startDataOnlyNode();
    }
        assertAcked(client().admin().indices().prepareDelete("index-two"));
        for (int i = 0; i < count; i++) {
        final String testIndex = "index-one";
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(AbstractDisruptionTestCase.DEFAULT_SETTINGS).build();
    }
        final ActionListener<AcknowledgedResponse> deletesListener = new GroupedActionListener<>(allDeletesDone, deleteFutures.size());
        waitUntilInprogress(repoName, secondSnapshot, TimeValue.timeValueSeconds(5L));
        createRepository(repoName, "mock", settings);
        ensureStableCluster(3, dataNode);
        awaitNoMoreRunningOperations();
        createNSnapshots(repoName, randomIntBetween(1, 5));
    @Override
        logger.info("--> waiting for batched deletes to finish");
        awaitClusterState(state -> {
    }
        logger.info("--> wait for relocations to start");
        unblockNode(repoName, clusterManagerNode);
        ensureGreen(testIndex);
    }
        internalCluster().stopCurrentClusterManagerNode();
        internalCluster().startClusterManagerOnlyNodes(3);
            TimeUnit.MINUTES
        throws InterruptedException {
            .cluster()
    public void testStatusMultipleSnapshotsMultipleRepos() throws Exception {
        // Verify that the update fails with an appropriate exception
    }
 *
        final ActionFuture<CreateSnapshotResponse> snapshotThree = startFullSnapshotFromNonClusterManagerClient(repoName, "snapshot-three");
        final ActionFuture<CreateSnapshotResponse> snapshotFour = startFullSnapshotFromNonClusterManagerClient(repoName, "snapshot-four");
import org.opensearch.test.InternalTestCluster;
        final ActionListener<CreateSnapshotResponse> snapshotsListener = new GroupedActionListener<>(allSnapshotsDone, numSnapshots);
        final PlainActionFuture<Collection<AcknowledgedResponse>> allDeletesDone = new PlainActionFuture<>();
import org.opensearch.plugins.Plugin;
    }
        );
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);
        disableRepoConsistencyCheck("This test corrupts the repository on purpose");
        final String secondIndex = "index-two";
        logger.info("--> waiting for concurrent snapshot(s) to finish");
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode();
        allDeletesDone.get();
        networkDisruption.startDisrupting();
        final int limitToTest = randomIntBetween(1, 3);
        internalCluster().startDataOnlyNode();
        final String blockedRepoName = "test-repo-blocked";
    public void testClusterManagerFailoverAndMultipleQueuedUpSnapshotsAcrossTwoRepos() throws Exception {
    public void testMultipleSnapshotsQueuedAfterDelete() throws Exception {
        assertSuccessful(snapshotFour);
        final ActionFuture<AcknowledgedResponse> deleteFuture = startAndBlockOnDeleteSnapshot(repoName, "*");
        assertThat(deleteSnapshotsResponse.get().isAcknowledged(), is(true));
        logger.info("--> wait for [{}] deletions to show up in the cluster state", count);
        assertAcked(deleteSnapshotsResponse.get());
        unblockNode(repoName, clusterManagerName);
        awaitNDeletionsInProgress(1);
        ensureStableCluster(3);
            assertThat(snapshotsInProgress.entries(), empty());
            } else {
                .entries()) {
import java.util.Locale;
        final String clusterManagerNode = internalCluster().getClusterManagerName();
        createRepository(repoName, "mock");
        final ActionFuture<CreateSnapshotResponse> firstSnapshotResponse = startFullSnapshotBlockedOnDataNode(
        });
        final String secondSnapshot = "snapshot-two";
        createIndexWithContent("index-test");
        final NetworkDisruption networkDisruption = isolateClusterManagerDisruption(NetworkDisruption.DISCONNECT);
        final SnapshotInfo firstSnapshotInfo = firstSnapshotResponse.get().getSnapshotInfo();
        ensureGreen();
        expectThrows(SnapshotException.class, firstFailedSnapshotFuture::actionGet);
        return snapshotNames;
        createIndexWithContent("index-one");
            );
        blockClusterManagerOnWriteIndexFile(repoName);
            "blocked-snapshot",
    public void testMultipleReposAreIndependent3() throws Exception {
        ensureGreen(testIndex);
            final StepListener<AcknowledgedResponse> future = new StepListener<>();
        createRepository(repoName, "mock");
        final RepositoryData repositoryData = getRepositoryData(otherRepoName);
        unblockNode(blockedRepoName, dataNode);
        expectThrows(OpenSearchException.class, snapshotThree::actionGet);
        createIndexWithContent("index-one");
        final SnapshotInfo secondSnapshotInfo = assertSuccessful(secondSnapshotResponse);
        internalCluster().startClusterManagerOnlyNode();
 *
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode();
            deleteFuture.whenComplete(deletesListener::onResponse, deletesListener::onFailure);
        // Start a cluster with a cluster manager node and a data node
        final ActionFuture<CreateSnapshotResponse> createSlowFuture1 = startFullSnapshotBlockedOnDataNode(
    }
        assertThat(snapshotStatuses, hasSize(count));
        final Collection<CreateSnapshotResponse> snapshotResponses = allSnapshotsDone.get();
        final String secondSnapshot = "snapshot-two";
        final RepositoryData repositoryDataAfterDeletes = getRepositoryData(repoName);
        createRepository(blockedRepoName, "mock");
        createIndex(testIndex, Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 1).build());
        // left for the second concurrent snapshot.
            firstSnapshot,
        createRepository(repoName, "mock", repoPath);
    }
        final String blockedRepoName = "test-repo-blocked";
            dataNode
        );
    }
import org.opensearch.cluster.ClusterState;
            .setWaitForCompletion(false)
        assertAcked(slowDeleteFuture.actionGet());
        );
                continue;
            ),
        createRepository(repoName, "mock");
import static org.hamcrest.Matchers.containsInAnyOrder;
        // Attempt to update the repository settings while the delete operation is in progress
                .isPresent(),
import org.opensearch.common.util.concurrent.UncategorizedExecutionException;
        final String repoName = "test-repo";
        final String blockedRepoName = "test-repo-blocked-1";
    }
                () -> client().admin().cluster().prepareDeleteSnapshot(repoName, "*").execute().actionGet()
        );
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        final Path repoPath = randomRepoPath();
        corruptIndexN(repoPath, generation);
        assertThat(firstSnapshotInfo.state(), is(SnapshotState.FAILED));
import org.opensearch.action.support.PlainActionFuture;
                .custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY)
        final String initialClusterManager = internalCluster().getClusterManagerName();
    }
        final String expectedFailureMessage = "Cannot start another operation, already running ["
    private ActionFuture<CreateSnapshotResponse> startAndBlockFailingFullSnapshot(String blockedRepoName, String snapshotName)
import org.opensearch.common.settings.Settings;
    public void testQueuedOperationsAfterFinalizationFailure() throws Exception {
                .setIndices(indexFast)
    public void testQueuedOperationsOnClusterManagerDisconnectAndRepoFailure() throws Exception {
        internalCluster().startClusterManagerOnlyNodes(3, LARGE_SNAPSHOT_POOL_SETTINGS);
        for (StepListener<AcknowledgedResponse> deleteFuture : deleteFutures) {
    }
 * ownership. Elasticsearch licenses this file to you under
        networkDisruption.startDisrupting();
        final long generation = getRepositoryData(repoName).getGenId();
        );
        createIndexWithContent("index-slow");
            + "]";
        ensureStableCluster(3);
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode();
        final ActionFuture<AcknowledgedResponse> slowDeleteFuture = startDeleteSnapshot(blockedRepoName, "*");
        // One increment for snapshot, one for all the deletes
        final long generation = getRepositoryData(repoName).getGenId();
                for (final SnapshotsInProgress.ShardSnapshotStatus shard : entry.shards().values()) {
        awaitClusterState(state -> {
        final String repoName = "test-repo";
            .execute();
        String clusterManagerName = internalCluster().startClusterManagerOnlyNode();
        expectThrows(OpenSearchException.class, snapshotThree::actionGet);
        final String snapshotName = "snap-name";
            blockedRepoName,
            final Collection<String> toDelete = randomSubsetOf(snapshotNames);
        createRepository(repoName, "mock", repoPath);
    }
        internalCluster().startClusterManagerOnlyNodes(3, LARGE_SNAPSHOT_POOL_SETTINGS);
        for (SnapshotsInProgress.Entry entry : snapshotsInProgress.entries()) {
        assertThat(repositoryData.getGenId(), is(3L));
                assertThat(entry.state(), is(SnapshotsInProgress.State.ABORTED));
        assertThat(snapshotFour.get().getSnapshotInfo().state(), is(SnapshotState.PARTIAL));
        createIndexWithContent("index-one");
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
        internalCluster().startDataOnlyNode();
            final String name = prefix + i;
        createRepository(blockedRepoName, "mock");
        awaitNDeletionsInProgress(1);
            () -> client().admin().cluster().prepareCreateSnapshot(repoName, "expected-to-fail").execute().actionGet()
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));
        final String snapshotTwo = snapshots.get(1);
        createRepository(repoName, "fs");
        createRepository(repoName, "mock");
        final String otherRepoName = "test-repo";
        expectThrows(OpenSearchException.class, snapshotThree::actionGet);
        corruptIndexN(repoPath, generation);
    public void testSnapshotRunsAfterInProgressDelete() throws Exception {
        createNSnapshots(repoName, randomIntBetween(2, 5));
        final String repoName = "test-repo";
        awaitNDeletionsInProgress(1);
        unblockNode(repoName, clusterManagerNode);
            createFullSnapshot(repoName, name);
 * specific language governing permissions and limitations
        final String repoName = "test-repo";
        final String dataNode = startDataNodeWithLargeSnapshotPool();
        createRepository(repoName, "mock");
                // that the client on the data-node sees a disconnect exception after the cluster-manager has already started the delete,
                .get()
            "blocked-snapshot",
        assertSnapshotStatusCountOnRepo("_all", 3);
        internalCluster().startDataOnlyNode();
        final ActionFuture<CreateSnapshotResponse> createSlowFuture2 = startFullSnapshotBlockedOnDataNode(
        awaitNoMoreRunningOperations();
    public void testSettingsUpdateFailWhenDeleteSnapshotInProgress() throws Exception {
        logger.info("--> verifying repository state");
        final ActionFuture<CreateSnapshotResponse> secondSnapshotResponse = startFullSnapshot(repoName, secondSnapshot);
        );
            repoName,
import org.opensearch.test.disruption.NetworkDisruption;
        assertThat(repoGenAfterInitialSnapshots, is(numSnapshots - 1L));
import org.opensearch.common.unit.TimeValue;
    private ActionFuture<CreateSnapshotResponse> startFullSnapshotFromNonClusterManagerClient(String repoName, String snapshotName) {
        final String clusterManagerNode = internalCluster().getClusterManagerName();
        ActionFuture<AcknowledgedResponse> future = deleteSnapshotBlockedOnClusterManager(repoName, snapshotName);
        final String repoName = "test-repo";
        assertFalse(blockedSnapshot.isDone());
                    .cluster()
 */
import org.opensearch.common.UUIDs;
                )
        internalCluster().setDisruptionScheme(networkDisruption);
import org.opensearch.common.action.ActionFuture;
        internalCluster().startClusterManagerOnlyNode();
        createRepository(repoName, "mock");
        createIndexWithContent("index-test");
    public void testBackToBackQueuedDeletes() throws Exception {
        logger.info("--> wait for snapshot on second data node to finish");
            .get()
            .getSnapshots();
        for (CreateSnapshotResponse snapshotResponse : snapshotResponses) {
        internalCluster().startClusterManagerOnlyNode();
}
        );
        final String repoName = "test-repo";
                greaterThan(0)
            .prepareCreateSnapshot(otherRepoName, "snapshot")
            final SnapshotsInProgress snapshotsInProgress = state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
            dataNode
            }
 * software distributed under the License is distributed on an
        final ActionFuture<CreateSnapshotResponse> createSlowFuture = startFullSnapshotBlockedOnDataNode(
        final ActionFuture<CreateSnapshotResponse> secondSnapshotResponse = startFullSnapshot(repoName, secondSnapshot);
        internalCluster().stopCurrentClusterManagerNode();
        for (ActionFuture<AcknowledgedResponse> deleteFuture : Arrays.asList(firstDeleteFuture, deleteAllSnapshots)) {
 * Unless required by applicable law or agreed to in writing,
        internalCluster().restartNode(dataNode, InternalTestCluster.EMPTY_CALLBACK);
    }
        internalCluster().startDataOnlyNode();
        );
import org.opensearch.repositories.RepositoryData;
        final Collection<String> snapshotNames = new HashSet<>();
            assertThat(csen2.getMessage(), containsString(expectedFailureMessage));
    }
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        );
        assertThat(secondSnapshotResponse.isDone(), is(false));
        corruptIndexN(repoPath, generation);
        internalCluster().startDataOnlyNode();
        // Create index on two nodes and make sure each node has a primary by setting no replicas
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            blockedRepoName,
        createIndexWithContent("index-test");
        final RepositoryData repositoryData = getRepositoryData(repoName);
 * Modifications Copyright OpenSearch Contributors. See
        // Start a full snapshot and block it on the data node
/*
        createIndexWithContent("index-test");
        return fut;
    private ActionFuture<AcknowledgedResponse> startAndBlockOnDeleteSnapshot(String repoName, String snapshotName)
        final String repoName = "test-repo";
        awaitNDeletionsInProgress(2);
        final List<String> snapshotNames = createNSnapshots(repoName, randomIntBetween(2, 5));
        }
    }
        final ActionFuture<CreateSnapshotResponse> createSlowFuture = startFullSnapshotBlockedOnDataNode(
        createIndexWithContent("index-slow");
 *
        assertBusy(() -> {
        final ActionFuture<CreateSnapshotResponse> createSnapshot1Future = startFullSnapshotBlockedOnDataNode(
        assertSnapshotStatusCountOnRepo(blockedRepoName, 0);
        unblockNode(repoName, dataNode);
        logger.info("--> waiting for concurrent snapshot(s) to finish");
            blockedRepoName,
        assertThat(repositoryData.getSnapshotIds(), hasSize(countOtherRepo + 2));
        logger.info("--> waiting for all three snapshots to show up as in-progress");
            .cluster()
        assertAcked(startDeleteSnapshot(otherRepoName, "*").get());
        assertBusy(
            TimeUnit.MILLISECONDS
        createRepository(repoName, "mock");
        final List<String> snapshotNames = new ArrayList<>(count);
import org.opensearch.core.rest.RestStatus;
        internalCluster().startClusterManagerOnlyNodes(3);
        assertAcked(
    public void testInterleavedAcrossMultipleRepos() throws Exception {
        final ActionFuture<AcknowledgedResponse> firstDeleteFuture = startDeleteSnapshot(repoName, "*");
import java.util.Collection;
        internalCluster().startClusterManagerOnlyNode();
    }
        for (ActionFuture<AcknowledgedResponse> deleteResponse : deleteResponses) {
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);
            } catch (SnapshotMissingException sme) {
        final ActionFuture<CreateSnapshotResponse> createSnapshot2Future = startFullSnapshot(repoName, snapshotTwo);
        awaitNumberOfSnapshotsInProgress(2);
        logger.info("--> wait for snapshot on second data node to finish");
        awaitNumberOfSnapshotsInProgress(1);
        final String snapshotTwo = "second-snapshot";
        assertSuccessful(createSlowFuture2);
            .admin()
        }
            client().admin()
            createBlockedSnapshot.actionGet();
            .setWaitForCompletion(false)
import static org.hamcrest.Matchers.hasItem;
        final ActionFuture<CreateSnapshotResponse> firstSnapshotResponse = startFullSnapshotFromClusterManagerClient(
        final String repoName = "test-repo";
    public void testSettingsUpdateFailWhenCreateSnapshotInProgress() throws Exception {
        blockNodeOnAnyFiles(repoName, dataNode);
        });
        createNSnapshots(repoName, randomIntBetween(2, 5));
        final ActionFuture<CreateSnapshotResponse> createSlowFuture = startFullSnapshotBlockedOnDataNode(
        for (int i = 0; i < numSnapshots; i++) {
                hasItem(equalTo("cluster:admin/snapshot/delete"))
        assertSnapshotStatusCountOnRepo("_all", 1);
        // Create a full snapshot
        } catch (OpenSearchException ex) {
    }
        final ActionFuture<CreateSnapshotResponse> secondFailedSnapshotFuture = startFullSnapshotFromClusterManagerClient(
        awaitNumberOfSnapshotsInProgress(1);
        networkDisruption.stopDisrupting();
            SnapshotInfo snapshotInfo = waitForCompletion(repoName, snapshot, TimeValue.timeValueSeconds(600));
                    .getFirst()
            }
    }
        final ActionFuture<AcknowledgedResponse> deleteAllSnapshots = startDeleteFromNonClusterManagerClient(repoName, "*");
        expectThrows(OpenSearchException.class, snapshotFour::actionGet);
        final String repoName = "test-repo";
        final String dataNode = internalCluster().startDataOnlyNode();
        }
        // Wait for the delete operation to start
        createIndexWithContent("index-one");
        unblockNode(repoName, dataNode);
        createIndexWithContent("test-index");
        awaitNDeletionsInProgress(2);
            .execute();
            }
        assertFalse(future.isDone()); // Ensure the delete operation is still in progress
            dataNode
            index(testIndex, "_doc", Integer.toString(i), "foo", "bar" + i);
            .cluster()
        int blockedSnapshots = 0;
            repoName,
        for (int i = 0; i < deletes; ++i) {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        awaitNumberOfSnapshotsInProgress(3);
        );
        internalCluster().startDataOnlyNode();
            dataNode
    public void testMultipleReposAreIndependent2() throws Exception {
        final String dataNode = internalCluster().startDataOnlyNode();
    private static void waitUntilInprogress(final String repoName, final String snapshotName, TimeValue timeout)
            )
        final Path repoPath = randomRepoPath();
        assertThat(thirdSnapshotResponse.get().getSnapshotInfo().state(), is(SnapshotState.FAILED));
        final String dataNode = internalCluster().startDataOnlyNode();
        ActionFuture<AcknowledgedResponse> deleteFuture = null;
                .setPersistentSettings(
            "snapshot-three"
        final String repoName = "test-repo";
            .prepareDeleteSnapshot(repoName, "*")
    }
        final ActionFuture<CreateSnapshotResponse> snapshotFour = startFullSnapshot(repoName, "snapshot-four");
        createFullSnapshot(blockedRepoName, "blocked-snapshot");
        createNSnapshots(repoName, randomIntBetween(1, 5));
import org.opensearch.tasks.TaskInfo;
            .execute();
            firstSnapshot,
            blockedRepoName,
    }
    }
            dataNode
        ensureStableCluster(3);
            dataNode
        blockNodeOnAnyFiles(repoName, clusterManagerName);
        final String firstSnapshot = "snapshot-one";
        assertBusy(
        final String blockedRepoName = "test-repo-blocked";
        final long repoGenAfterInitialSnapshots = getRepositoryData(repoName).getGenId();
        assertFalse(createSlowFuture.isDone()); // Ensure the snapshot is still in progress
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(blockedRepoName);
        createRepository(repoName, "mock");
        final ActionFuture<CreateSnapshotResponse> createBlockedSnapshot = startFullSnapshotFromNonClusterManagerClient(
            assertAcked(deleteFuture.get());
            if (entry.snapshot().getSnapshotId().getName().equals(snapshot)) {
        }
        final String dataNode = internalCluster().startDataOnlyNode();
import java.util.HashSet;
            if (blockedDelete || randomBoolean()) {
        createRepository(repoName, "mock", settings);
        final ActionFuture<AcknowledgedResponse> deleteSnapshotsResponse = startDeleteSnapshot(repoName, firstSnapshot);
        final String clusterManagerNode = internalCluster().getClusterManagerName();
                assertThat(sme.getSnapshotName(), is(firstSnapshot));
        );
        awaitClusterManagerFinishRepoOperations();
        awaitNDeletionsInProgress(1);
        createIndexWithContent("index-one");
        assertSuccessful(createSlowFuture);
        blockDataNode(repoName, dataNode);
        createRepository(repoName, "mock");
        final String dataNode = internalCluster().startDataOnlyNode();
            .cluster()
        // Create a repository with random settings
        final String clusterManagerName = internalCluster().getClusterManagerName();
        awaitNumberOfSnapshotsInProgress(2);
        if (blockedDelete) {
        createRepository(otherRepoName, "fs");
        }
        final String dataNode = internalCluster().startDataOnlyNode();
        );
        final SnapshotException snapshotException = expectThrows(SnapshotException.class, snapshotFuture::actionGet);
        internalCluster().startClusterManagerOnlyNodes(3);
            repoName,
            blockedRepoName,
        final ActionFuture<AcknowledgedResponse> firstDeleteFuture = startDeleteFromNonClusterManagerClient(repoName, firstSnapshot);
            deleteFutures.add(future);
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
            for (SnapshotsInProgress.Entry entry : clusterService().state()
        final ActionFuture<CreateSnapshotResponse> snapshotThree = startFullSnapshot(repoName, "snapshot-three", true);
                        return true;
        refresh();
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
        final String repoName = "test-repo";
        final ConcurrentSnapshotExecutionException csen1 = expectThrows(
    public void testQueuedSnapshotOperationsAndBrokenRepoOnClusterManagerFailOver() throws Exception {
        final List<ActionFuture<CreateSnapshotResponse>> snapshotFutures = new ArrayList<>();
        final ActionFuture<AcknowledgedResponse> deleteFuture = startDeleteSnapshot(repoName, snapshotName);
        createRepository(repoName, "mock");
        assertThat(repositoryDataAfterDeletes.getGenId(), is(repoGenAfterInitialSnapshots + 2));
    }
        );
            dataNode
        internalCluster().stopCurrentClusterManagerNode();
        throws InterruptedException {
                equalTo(SnapshotState.IN_PROGRESS)
        awaitNumberOfSnapshotsInProgress(1);
        logger.info("--> corrupting [index-{}] in [{}]", generation, repoPath);
                    .addSnapshots("slow-snapshot")
            repoName,
        final ActionFuture<CreateSnapshotResponse> snapshotThree = startFullSnapshotFromClusterManagerClient(repoName, "snap-other");
        internalCluster().startClusterManagerOnlyNodes(3);
            snapshotNames.removeAll(toDelete);
        createIndexWithContent(firstIndex);
        logger.info("--> verify that the first snapshot is gone");
        return internalCluster().clusterManagerClient()
        awaitNoMoreRunningOperations();
            return snapshotsInProgress.entries().size() == 2 && snapshotHasCompletedShard(secondSnapshot, snapshotsInProgress);
        createNSnapshots(repoName, randomIntBetween(2, 5));
                .prepareCreateSnapshot(repoName, "fast-snapshot")
        final String snapshotTwo = "snap-2";
        final String snapshotOne = snapshotNames.get(0);
        for (int i = 0; i < limitToTest; ++i) {
        waitUntil(
        final SnapshotException snapshotException = expectThrows(SnapshotException.class, snapshotFuture::actionGet);
        expectThrows(SnapshotException.class, createThirdSnapshot::actionGet);
        // Create a repository with random settings
    }
        unblockNode(blockedRepoName, dataNode);
        ensureStableCluster(5);
        expectThrows(SnapshotException.class, secondFailedSnapshotFuture::actionGet);
        createNSnapshots(repoName, randomIntBetween(2, 5));
        internalCluster().startDataOnlyNode();
        awaitNDeletionsInProgress(1);
                ConcurrentSnapshotExecutionException.class,
        final String blockedRepoName = "test-repo-blocked";
        final ActionFuture<CreateSnapshotResponse> secondSnapshotResponse = startFullSnapshot(repoName, secondSnapshot);
            ConcurrentSnapshotExecutionException.class,
        awaitNoMoreRunningOperations();
        awaitNumberOfSnapshotsInProgress(3);
        createRepository(repoName, "mock");
            .prepareSnapshotStatus(otherBlockedRepoName)
        blockNodeOnAnyFiles(repoName, clusterManagerName);
        awaitNumberOfSnapshotsInProgress(2);
        index(testIndex, "_doc", "some_id", "foo", "bar");
import java.nio.file.StandardOpenOption;
                .cluster()
        assertBusy(
        final String prefix = "snap-" + UUIDs.randomBase64UUID(random()).toLowerCase(Locale.ROOT) + "-";
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
 * this work for additional information regarding copyright
        expectThrows(SnapshotException.class, snapshotThreeFuture::actionGet);
        assertSnapshotStatusCountOnRepo(otherBlockedRepoName, 1);
        logger.info("--> waiting for second and third snapshot to finish");
            .execute();
        final ActionFuture<AcknowledgedResponse> deleteSnapshotsResponse = startDeleteSnapshot(repoName, firstSnapshot);
        blockNodeOnAnyFiles(repoName, clusterManagerName);
    }
        assertThat(repositoryData.getSnapshotIds(), empty());
        ensureStableCluster(3);
                blockedDelete = true;
        awaitClusterState(state -> {
        client().admin().cluster().prepareCreateSnapshot(repoName, "snapshot-three").setWaitForCompletion(false).get();
        assertSuccessful(createSlowFuture); // Ensure the snapshot completes successfully
        createRepository(blockedRepoName, "mock");
        final ActionFuture<CreateSnapshotResponse> snapshotThree = startFullSnapshot(repoName, "snapshot-three");
        internalCluster().startClusterManagerOnlyNode();
        internalCluster().startClusterManagerOnlyNodes(3);
        expectThrows(OpenSearchException.class, snapshotFour::actionGet);
        ensureStableCluster(3, dataNode);
        assertThat(snapshotException.getMessage(), containsString(SnapshotsInProgress.ABORTED_FAILURE_TEXT));
        // Second delete works out cleanly since the repo is unblocked now
            deleteSnapshotOne.actionGet();
    public void testQueuedDeletesWithOverlap() throws Exception {
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);
        // left for the second concurrent snapshot.
        unblockNode(repoName, clusterManagerNode);
        ensureStableCluster(3);
        final ActionFuture<CreateSnapshotResponse> thirdSnapshotResponse = startFullSnapshot(repoName, "snapshot-three");
import org.opensearch.action.support.GroupedActionListener;
        createIndexWithContent("index-test");
                    .state(),
import org.opensearch.action.StepListener;
            }
            dataNode
        final String dataNode = startDataNodeWithLargeSnapshotPool();
            () -> currentSnapshots(repoName).stream()
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus;
        final ActionFuture<AcknowledgedResponse> deleteFuture = startDeleteSnapshot(repoName, firstSnapshot);
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));
        createNSnapshots(otherRepoName, countOtherRepo);
        ensureStableCluster(3);
        final ActionFuture<CreateSnapshotResponse> fut = startFullSnapshot(blockedRepoName, snapshotName);
        logger.info("--> verify both deletes have completed");
            final SnapshotsInProgress snapshotsInProgress = state.custom(SnapshotsInProgress.TYPE);
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, "snapshot-queued");
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.instanceOf;
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode();
        final ActionFuture<AcknowledgedResponse> deleteSnapshotOne = startAndBlockOnDeleteSnapshot(repoName, snapshotOne);
        final ActionFuture<CreateSnapshotResponse> createSlowFuture = startFullSnapshotBlockedOnDataNode(
    }
            final SnapshotsInProgress snapshotsInProgress = clusterService().state().custom(SnapshotsInProgress.TYPE);
        unblockNode(repoName, clusterManagerNode);
                // rarely the cluster-manager node fails over twice
        logger.info("--> waiting for all three snapshots to show up as in-progress");
        settings.put("chunk_size", 2000, ByteSizeUnit.BYTES);
 * Licensed to Elasticsearch under one or more contributor
            .setWaitForCompletion(true)
        final ActionFuture<CreateSnapshotResponse> createSlowFuture1 = startFullSnapshotBlockedOnDataNode(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        final ActionFuture<CreateSnapshotResponse> firstFailedSnapshotFuture = startFullSnapshotFromClusterManagerClient(
            .setWaitForCompletion(true)
        final String snapshotName = "snap-1";
        final ActionFuture<AcknowledgedResponse> allDeletedResponse = startDeleteSnapshot(repoName, "*");
                client().admin()
        final Path repoPath = randomRepoPath();
        );
            )
        );
                assertThat(rex.getMessage(), endsWith("Failed to update cluster state during repository operation"));
            .prepareGetSnapshots(repoName)
