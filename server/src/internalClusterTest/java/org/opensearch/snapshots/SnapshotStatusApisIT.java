        });
                    .actionGet()
            getSnapshotsResponse.getSnapshots().stream().map(s -> s.snapshotId().getName()).sorted().collect(Collectors.toList()),
        assertEquals(1, getSnapshotsResponse.getSnapshots().size());
                .get()
        String index1 = "test-idx-1";
        client.admin()
                    .prepareSnapshotStatus(repositoryName)
                    .cluster()
        assertBusy(() -> {
        assertAcked(prepareCreate("test-idx-good").setSettings(indexSettingsNoReplicas(1)));
                .setSnapshots(inProgressSnapshot)
                .setSnapshots(inProgressSnapshot)
        GetSnapshotsResponse getSnapshotsResponse = client.admin()
            // failure due to index not found in snapshot
        getSnapshotsResponse = client.admin()
        }
            .execute();
            repoPath.resolve(resolvePath(indexId, "0"))
            Exception ex = expectThrows(
     * @throws Exception on failure
                exception.getMessage().contains(" is more than the maximum allowed value of shard count [2] for snapshot status request")
 */
        final SnapshotStats snapshotShardStats = stateFirstShard(getSnapshotStatus(repoName, snapshotOne), indexTwo).getStats();
        assertEquals(SnapshotsInProgress.State.PARTIAL, snapshotStatus.getState());
            index(index1, "_doc", Integer.toString(i), "foo", "bar" + i);
                    .prepareSnapshotStatus(repositoryName)
        ensureGreen();
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
            assertEquals(snapshotIndexStatusMap.keySet(), Set.of(index1, index2));
        updateSettingsRequest.persistentSettings(Settings.builder().putNull(MAX_SHARDS_ALLOWED_IN_STATUS_API.getKey()));
        final String repositoryName = "test-repo";
        unblockNode(repositoryName, blockedNode); // unblock node
    }
                    .prepareSnapshotStatus("_all")
            CircuitBreakingException exception = expectThrows(
                    .prepareSnapshotStatus(repositoryName)
                .get()
import org.opensearch.repositories.blobstore.BlobStoreRepository;
                .setWaitForCompletion(true)
                .setIndices(index1, index2, index3)
        String snapshot1 = "test-snap-1";
}
        }
        for (int i = 0; i < 100; i++) {
        blockedNode = blockNodeWithIndex(repositoryName, index1);
    @Override
            .setIgnoreUnavailable(true)
            assertThat(snapshotShardStateOne.getStage(), is(SnapshotIndexShardStage.DONE));
            );
                    .setSnapshots()
        startFullSnapshot(repoName, snapshotName, true).get();
            assertEquals(exception.status(), RestStatus.TOO_MANY_REQUESTS);
        waitForCompletion(repositoryName, completedSnapshot, TimeValue.timeValueSeconds(60));
                .cluster()
        internalCluster().startClusterManagerOnlyNode();
            .get();
        assertBusy(() -> {
 * GitHub history for details.
        String repositoryName = "test-repo";
        String index3 = "test-idx-3";
        createSnapshotResponseActionFuture.actionGet();
        blockDataNode(repoName, dataNodeOne);
        waitForBlockOnAnyDataNode(snapshotRepoName, TimeValue.timeValueMinutes(1));
        // indexing another document to the second index so it will do writes during the snapshot and we can block on those writes
            assertThat(snapshotShardState.getStats().getTotalFileCount(), greaterThan(0));
        assertThat(snapshotShardStateAfterNodeRestart.getStats().getTotalFileCount(), equalTo(totalFiles));
import java.nio.file.Path;
    public void testSnapshotStatusFailuresWithIndexFilter() throws Exception {
                .get()
                () -> client().admin()
        String snapshot = "test-snap-1";
        final String snapshot = "snapshot";
            SnapshotStatus snapshotsStatus = client().admin()
        final String secondRegex = "*" + regexName.substring(splitPos);
                .getSnapshots()
                    .execute()
        assertThat(found.state(), is(SnapshotState.SUCCESS));
 * SPDX-License-Identifier: Apache-2.0
        logger.info("Create repository");
            index(index1, "_doc", Integer.toString(i), "foo", "bar" + i);
            assertThat(snapshotShardState.getStats().getTotalFileCount(), greaterThan(0));
        awaitNumberOfSnapshotsInProgress(1);
            assertThat(totalSizeShardOne, greaterThan(0L));
     * 1. Start snapshot of two shards (both located on separate data nodes).
                .get(0);
                .prepareSnapshotStatus(repositoryName)
        indexRandomDocs(index1, 10);
            repositoryName,
        ensureGreen();
                    .execute()
    }
        addBwCFailedSnapshot(repoName, snapshot, Collections.emptyMap());
                () -> client().admin()
            .cluster()
        logger.info("--> get all snapshots with a current in-progress");
        logger.info("Indexing some data");
        assertBusy(() -> {
            index(index1, "_doc", Integer.toString(i), "foo", "bar" + i);
        createIndex(indexOne, singleShardOneNode(dataNodeOne));
                    .execute()
        indexRandomDocs(indexName, 10);
            );
 * specific language governing permissions and limitations
        getSnapshotsResponse = client.admin()
                    .execute()
            // failure due to too many shards requested
    public void testSnapshotStatusShardLimitOfResponseForInProgressSnapshot() throws Exception {
        createRepository(repoName, "mock");
        createFullSnapshot(snapshotRepoName, snapshot);
        assertThat(snapshotInfos.size(), equalTo(1));
        assertBusy(() -> {
        final SnapshotStatus snapshotStatus = getSnapshotStatus("test-repo", "test-snap");
        IOUtils.rm(
            .prepareGetSnapshots("test-repo")
        assertBusy(() -> {
 * You may obtain a copy of the License at
            .addSnapshots(firstRegex, secondRegex)
        for (int i = 0; i < 100; i++) {
                Locale.ROOT,
        }
        indexRandomDocs(index2, 10);
                () -> client().admin()
                .get()
        assertBusy(() -> {
        assertBusy(() -> {
        // shard limit exceeded due to inProgress snapshot alone @ with index-filter
            .cluster()
                    .actionGet()
        refresh();
        assertEquals(SnapshotsInProgress.State.FAILED, snapshotsStatusResponse.getSnapshots().get(0).getState());
            );
        updateSettingsRequest.persistentSettings(Settings.builder().put(MAX_SHARDS_ALLOWED_IN_STATUS_API.getKey(), 1));
            assertThat(snapshotShardState.getStats().getTotalSize(), greaterThan(0L));
 * ownership. Elasticsearch licenses this file to you under
                    .execute()
                    .cluster()
            .get();
                    .cluster()
                    .setIndices(index1, index2)
        IOUtils.rm(repoPath.resolve(BlobStoreRepository.SNAPSHOT_PREFIX + snapshotInfo.snapshotId().getUUID() + ".dat"));
            assertThat(snapshotShardStateTwo.getStats().getIncrementalSize(), equalTo(0L));
        final String blockedNode = blockNodeWithIndex(repositoryName, indexName);
                .execute()
            "mock",
                CircuitBreakingException.class,
                .setSnapshots(snapshot)
                .cluster()
            Map<String, SnapshotIndexStatus> snapshotIndexStatusMap = snapshotsStatus.getIndices();
        });
            Settings.builder()
import static org.hamcrest.Matchers.hasSize;
        createFullSnapshot("test-repo", "test-snap");
            assertEquals(1, snapshotsStatus.getIndices().size());
        String repositoryName = "test-repo";
            .getSnapshots();
        createRepository(repoName, "fs");
        final List<SnapshotInfo> snapshotInfos = client().admin()
            assertEquals(3, inProgressSnapshotStatus.getShards().size());
                .get(0);
            .addSnapshots(snapshotNames)
        logger.info("Create indices");
        refresh();
                .setIgnoreUnavailable(true)
            assertThat(snapshotStatus.getState(), is(SnapshotsInProgress.State.SUCCESS));
        String index3 = "test-idx-3";
        );
            throw new AssertionError(e);
        );
                "index list filter is supported only when a single 'repository' is passed, but found 'repository' param = [_all]";
                    .cluster()
                    .cluster()
    }
        assertThat(snapshotInfo.version(), equalTo(Version.CURRENT));
        }
            assertTrue(ex.getMessage().contains(cause));
        indexRandomDocs(index3, 10);
            .prepareCreateSnapshot(repositoryName, "snap-on-empty-repo")
        });
        try {
                    .cluster()
        logger.info("--> unblock all data nodes");
        assertBusy(() -> {
            SnapshotsInProgress.State.STARTED,
        for (int i = 0; i < numSnapshots - 1; i++) {
            assertThat(snapshotShardStateTwo.getStats().getIncrementalFileCount(), equalTo(0));
                    .setIndices(index1, index2, index3)
            Exception ex = expectThrows(
        waitForBlock(blockedNode, repositoryName, TimeValue.timeValueSeconds(60)); // wait for block to kick in
        refresh();
                "indices [%s] missing in snapshot [%s] of repository [%s]",
        // make sure we return only the in-progress snapshot when taking the first snapshot on a clean repository
                .get()
        refresh();
                CircuitBreakingException.class,
        stopNode(dataNode);
    public void testExceptionOnMissingShardLevelSnapBlob() throws Exception {
                .getSnapshots()
            // failure due to passing index filter for _all value of repository param
    public void testSnapshotStatusOnPartialSnapshot() throws Exception {
import org.opensearch.transport.client.Client;
        });
        createRepository("test-repo", "fs");
                    .execute()
        logger.info("--> take {} snapshot(s)", numSnapshots - 1);
            String cause =
            final int totalFilesShardOne = snapshotShardStateOne.getStats().getTotalFileCount();
            index(index3, "_doc", Integer.toString(i), "foo", "baz" + i);
            // Although the snapshot contains 3 indices, the response of status api call only contains results for 2
        logger.info("--> indexing some data");
        logger.info("Set MAX_SHARDS_ALLOWED_IN_STATUS_API to a slightly higher value");
            // failure due to passing index filter for _all value of snapshot param --> gets translated as a blank array
        String index2 = "test-idx-2";
        assertEquals(SnapshotsInProgress.State.SUCCESS, snapshotStatuses.get(1).getState());
        assertEquals(snapshotStatus.getStats().getStartTime(), snapshotInfo.startTime());
public class SnapshotStatusApisIT extends AbstractSnapshotIntegTestCase {
        assertThat(snapshotInfo.totalShards(), is(0));
        final String dataNodeTwo = dataNodes.get(1);
    protected Settings nodeSettings(int nodeOrdinal) {
        assertBusy(() -> {
            index("test-idx-1", "_doc", Integer.toString(i), "foo", "bar" + i);
            );
        for (int i = 0; i < 100; i++) {
        waitForBlockOnAnyDataNode(repositoryName, TimeValue.timeValueMinutes(1));
            .get();
            .setWaitForCompletion(false)
        refresh();
            SnapshotStatus snapshotsStatus = client().admin()
                exception.getMessage().contains(" is more than the maximum allowed value of shard count [1] for snapshot status request")
                    .setSnapshots(snapshot1)
import org.opensearch.threadpool.ThreadPool;
            () -> client.admin().cluster().prepareGetSnapshots(repositoryName).addSnapshots("non-existent-snapshot").get()
                    .execute()
                .setIgnoreUnavailable(true)
            index("test-idx-1", "_doc", Integer.toString(i), "foo", "bar" + i);
                snapshot2,
                    .setSnapshots(snapshot1)
        ensureGreen();
        logger.info("--> creating good index");
        refresh();
                .setSnapshots(snapshot2)
        createRepository(
        createRepository("test-repo", "mock", Settings.builder().put("location", randomRepoPath()).put("block_on_data", true));
        createIndex("test-idx-1");
        createSnapshot(repositoryName, snapshot, List.of(index1, index2, index3));
            Exception ex = expectThrows(
        assertEquals(snapshotStatus.getStats().getTime(), snapshotInfo.endTime() - snapshotInfo.startTime());
import org.opensearch.repositories.IndexId;
        logger.info("--> snapshot");
            index(indexName, "_doc", Integer.toString(i), "foo", "bar" + i);
            client().admin().cluster().prepareCreateSnapshot("test-repo", "test-snap").setIndices().setWaitForCompletion(true).execute()
            assertTrue(
        final SnapshotStatus snapshotStatus = getSnapshotStatus(repoName, snapshotName);
        createSnapshot(repositoryName, snapshot1, List.of(index1, index2, index3));
        assertBusy(() -> {
                    .cluster()
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotIndexStatus;
            updateSettingsRequest.persistentSettings(Settings.builder().putNull(MAX_SHARDS_ALLOWED_IN_STATUS_API.getKey()));
        final ActionFuture<CreateSnapshotResponse> responseSnapshotTwo = client().admin()
                Exception.class,
                .get(0);
                Exception.class,
            assertEquals(snapshotIndexStatusMap.size(), 2);
        }
            index(indexName, "_doc", Integer.toString(i), "foo", "bar" + i);
            assertTrue(ex.getMessage().contains(cause));
        client().admin().cluster().prepareCreateSnapshot(repositoryName, completedSnapshot).setWaitForCompletion(false).get();
        waitForBlock(dataNodeTwo, repoName, TimeValue.timeValueSeconds(30L));
        logger.info("--> unblock all data nodes");
            ActionRequestValidationException ex = expectThrows(
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
        disableRepoConsistencyCheck("This test intentionally corrupts the repository");
        waitForBlock(initialBlockedNode, repositoryName, TimeValue.timeValueSeconds(60)); // wait for block to kick in
        indexRandomDocs(index1, 10);
        createSnapshot(repositoryName, snapshot1, List.of(index1, index2, index3));
        );
        refresh();
    public void testGetSnapshotsWithoutIndices() throws Exception {
        logger.info("--> stopping data node before creating snapshot");
            SnapshotMissingException.class,
            SnapshotMissingException.class,
            equalTo(sortedNames)
        String index2 = "test-idx-2";
            String cause = String.format(
        final String dataNodeOne = dataNodes.get(0);
                .prepareSnapshotStatus(snapshotRepoName)
            snapshotsToGet.add("_all");
                    .actionGet()
        createSnapshot(repositoryName, snapshot2, List.of(index1));
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotIndexShardStatus;
import org.opensearch.core.common.Strings;
                .prepareCreateSnapshot(repositoryName, snapshotName)
            CircuitBreakingException ex = expectThrows(
        index(indexName, "_doc", "some_doc_id", "foo", "bar");
        List<SnapshotInfo> snapshotInfos = clusterAdmin().prepareGetSnapshots("test-repo").get().getSnapshots();
        assertThat(
        waitForBlockOnAnyDataNode("test-repo", TimeValue.timeValueMinutes(1));
            .cluster()
        );
            .cluster()
 * this file be licensed under the Apache-2.0 license or a
            );
                .cluster()
        logger.info("Block data node");
            assertEquals(exception.status(), RestStatus.TOO_MANY_REQUESTS);
            .execute();
                Locale.ROOT,
            .prepareGetSnapshots("test-repo")
 * under the License.
            assertThat(totalFilesShardOne, equalTo(snapshotShardStateTwo.getStats().getTotalFileCount()));
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        Collections.sort(sortedNames);
        assertThat(
     * 4. Make sure that snapshot status APIs show correct file-counts and -sizes
                    .setIndices(index1, index2, index3)
        });
            indexTwo
                .put("location", randomRepoPath())
                    .setIndices(index1, index2, nonExistentIndex1, nonExistentIndex2)
            final SnapshotStatus snapshotStatus = client().admin()
            CircuitBreakingException exception = expectThrows(
            index(index2, "_doc", Integer.toString(i), "foo", "baz" + i);
            return client().admin().cluster().prepareSnapshotStatus(repoName).setSnapshots(snapshotName).get().getSnapshots().get(0);
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        final String indexName = "test-idx";
import static org.hamcrest.Matchers.is;
                "indices [%s] missing in snapshot [%s] of repository [%s]",
        createRepository(snapshotRepoName, "fs", snapshotRepoSettingsForShallowCopy());
 */
            assertTrue(
                () -> client().admin().cluster().prepareSnapshotStatus("test-repo").setSnapshots("test-snap").execute().actionGet()
                .put("wait_after_unblock", 200)
            assertTrue(ex.getMessage().contains(" is more than the maximum allowed value of shard count [2] for snapshot status request"));
import org.opensearch.common.unit.TimeValue;
        String inProgressSnapshot = "test-in-progress-snapshot";
            .get()
        final String snapshotName = "test-snap";
 *
        String index2 = "test-idx-2";
            .setWaitForCompletion(false)
        assertThat(snapshotShardStateAfterNodeRestart.getStage(), is(SnapshotIndexShardStage.DONE));
        IndexId indexId = getRepositoryData("test-repo").resolveIndexId(snapshotInfo.indices().get(0));
        createIndex(index1, index2, index3);
        final SnapshotsStatusResponse snapshotsStatusResponse = client().admin()
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
                    .prepareSnapshotStatus(repositoryName)
        logger.info("--> delete snap-${uuid}.dat file for this snapshot to simulate concurrent delete");
                    .actionGet()
        // block a node so the create snapshot operation can remain in progress
        logger.info("Indexing some data");
        assertBusy(() -> {
                .put("wait_after_unblock", 200)
        sortedNames = Arrays.asList(snapshotNames);
        assertEquals(1, snapshotsStatusResponse.getSnapshots().size());
        ActionFuture<CreateSnapshotResponse> createSnapshotResponseActionFuture = startFullSnapshot(repositoryName, inProgressSnapshot);
        String blockedNode = blockNodeWithIndex(repositoryName, index1);
        unblockNode(repositoryName, blockedNode);
                () -> client().admin()
        });
            final String nonExistentIndex2 = "non-existent-index-2";
        assertBusy(() -> {
                    .prepareSnapshotStatus(repositoryName)
        // restarting a data node below so using a cluster-manager client here
        // test normal functioning of index filter for in progress snapshot
                exception.getMessage().contains(" is more than the maximum allowed value of shard count [2] for snapshot status request")
            assertEquals(exception.status(), RestStatus.TOO_MANY_REQUESTS);
        );
                .prepareSnapshotStatus(repositoryName)
        String repositoryName = "test-repo";
        internalCluster().startClusterManagerOnlyNode();
                    .execute()
        createRepository("test-repo", "fs");
                .cluster()
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        // for a completed snapshot
            );
            logger.info("Set MAX_SHARDS_ALLOWED_IN_STATUS_API to a low value");
        ensureGreen();
            final SnapshotIndexShardStatus snapshotShardState = stateFirstShard(snapshotStatusOne, indexTwo);
                    .actionGet()
 *
        ensureGreen();
                () -> client().admin()
            // failure due to index not found in snapshot
        waitForBlock(blockedNode, repositoryName, TimeValue.timeValueSeconds(60));
        for (int i = 0; i < 10; i++) {
        }, 1, TimeUnit.MINUTES);
        ensureGreen();
            .admin()
                .get(0);
            .cluster()
        String index1 = "test-idx-1";
        final SnapshotInfo snapshotInfo = createFullSnapshot("test-repo", "test-snap");
                String.join(", ", List.of(index2, index3)),
            .put(super.nodeSettings(nodeOrdinal))
                    .prepareSnapshotStatus(repositoryName)
            CircuitBreakingException exception = expectThrows(
        assertThat(snapshotShardStateAfterNodeRestart.getStats().getTotalSize(), equalTo(totalFileSize));
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        }, 20, TimeUnit.SECONDS);
    }
            getSnapshotsResponse.getSnapshots().stream().map(s -> s.snapshotId().getName()).sorted().collect(Collectors.toList()),
                exception.getMessage().contains(" is more than the maximum allowed value of shard count [1] for snapshot status request")
    /**
            );
        unblockNode(repositoryName, initialBlockedNode); // unblock node
            IndexNotFoundException ex = expectThrows(
            assertThat(snapshotStatusOne.getState(), is(SnapshotsInProgress.State.STARTED));
            index("test-idx-3", "_doc", Integer.toString(i), "foo", "baz" + i);
                .setIndices(indexName)
            assertTrue(
        createIndex(index1, index2, index3);
    public void testSnapshotStatusApiFailureForTooManyShardsAcrossSnapshots() throws Exception {
            assertThat(snapshotShardState.getStats().getIncrementalFileCount(), greaterThan(0));
        awaitNumberOfSnapshotsInProgress(1);
import org.opensearch.index.IndexNotFoundException;
        // when a non-existent index is requested in the index-filter
        disableRepoConsistencyCheck("This test intentionally corrupts the repository");
            assertEquals(cause, ex.getCause().getMessage());
                CircuitBreakingException.class,
        logger.info("Index some more data");
     * Tests the following sequence of steps:
                    .setSnapshots(inProgressSnapshot, completedSnapshot)
import org.opensearch.core.common.unit.ByteSizeUnit;
        assertEquals(
        blockDataNode(repoName, dataNodeTwo);
        logger.info("--> wait for snapshot to finish");
            assertTrue(
        logger.info("Set MAX_SHARDS_ALLOWED_IN_STATUS_API to a low value");
import java.util.concurrent.TimeUnit;
        assertThat(snapshotInfos, hasSize(1));
                .cluster()
        waitForCompletion(repositoryName, inProgressSnapshot, TimeValue.timeValueSeconds(60));
        logger.info("Reset MAX_SHARDS_ALLOWED_IN_STATUS_API to default value");
            snapshotNames[i] = snapshotName;
        }, 30L, TimeUnit.SECONDS);
            // failure due to passing index filter for multiple snapshots
        final SnapshotIndexShardStatus snapshotShardStateAfterNodeRestart = stateFirstShard(
        Collections.sort(sortedNames);
            equalTo(sortedNames)
    }
        String index1 = "test-idx-1";
            .cluster()
                    .cluster()
                .getSnapshots()
        createRepository(repositoryName, "fs");
 * not use this file except in compliance with the License.
        assertThat(found.snapshotId(), is(snapshotInfo.snapshotId()));
        }
            .prepareCreateSnapshot(repoName, snapshotOne)
import java.util.List;
        unblockAllDataNodes(repoName);
            index(index2, "_doc", Integer.toString(i), "foo", "baz" + i);
        createRepository(repoName, "fs");
        assertBusy(() -> {
        createIndex(indexName);
        return indexSettingsNoReplicas(1).put("index.routing.allocation.include._name", node).build();
        // shard limit exceeded due to inProgress snapshot alone @ without index-filter
            .setIgnoreUnavailable(true)
        final String snapshot = "test-snap-1";
        );
        index(indexTwo, "_doc", "some_doc_id", "foo", "bar");
        final String indexName = "index-1";
        final long totalFileSize = snapshotShardStats.getTotalSize();
import org.opensearch.core.common.breaker.CircuitBreakingException;
        logger.info("Create completed snapshot");
import org.opensearch.Version;
        for (int i = 10; i < 20; i++) {
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        expectThrows(
        assertAcked(prepareCreate(index3, 1, Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0)));
            // no error for ignore_unavailable = true and status response contains only the found indices
            CircuitBreakingException exception = expectThrows(
        updateSettingsRequest.persistentSettings(Settings.builder().put(MAX_SHARDS_ALLOWED_IN_STATUS_API.getKey(), 2));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                Exception.class,
        // across a single snapshot
        admin().cluster().prepareDeleteSnapshot(repositoryName, "snap-on-empty-repo").get();
    }
            );
            assertThat(snapshotShardState.getStats().getIncrementalSize(), greaterThan(0L));
                .resolve(BlobStoreRepository.SNAPSHOT_PREFIX + snapshotInfo.snapshotId().getUUID() + ".dat")
        ensureGreen();
 *
            assertEquals(cause, ex.getCause().getMessage());
        String index1 = "test-idx-1";
        final List<String> dataNodes = internalCluster().startDataOnlyNodes(2);
        );
 * license agreements. See the NOTICE file distributed with
                    .setSnapshots(snapshot2)
            );
        String index3 = "test-idx-3";
        logger.info("--> indexing some data");
        String repositoryName = "test-repo";
            String cause =
        final String firstRegex = regexName.substring(0, splitPos) + "*";
    public void testStatusAPICallInProgressSnapshot() throws Exception {
        logger.info("Create indices");
        expectThrows(
            final SnapshotIndexShardStatus snapshotShardStateOne = stateFirstShard(snapshotStatusOne, indexOne);
        assertBusy(() -> {
            client().admin()
            assertEquals(snapshotIndexStatusMap.keySet(), Set.of(index1, index2));
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
                CircuitBreakingException.class,
        assertThat(responseSnapshotTwo.get().getSnapshotInfo().state(), is(SnapshotState.SUCCESS));
            assertThat(snapshotShardState.getStage(), is(SnapshotIndexShardStage.DONE));
 */
        String snapshot2 = "test-snap-2";
        final String dataNode = internalCluster().startDataOnlyNode();
        }
    }
            .setWaitForCompletion(true)
            final SnapshotIndexShardStatus snapshotShardStateTwo = stateFirstShard(snapshotStatusTwo, indexOne);
            .prepareGetSnapshots(repositoryName)
        }
        logger.info("--> snapshot");
    }
                .getState()
            index(index2, "_doc", Integer.toString(i), "foo", "baz" + i);
        refresh();
        createIndex("test-idx-1");
        createRepository(repositoryName, "fs");
        } else {
 * software distributed under the License is distributed on an
                .prepareSnapshotStatus(snapshotRepoName)
                .setIndices(index1, index2)
            assertEquals(exception.status(), RestStatus.TOO_MANY_REQUESTS);
        logger.info("--> make sure duplicates are not returned in the response");
            assertThat(totalSizeShardOne, equalTo(snapshotShardStateTwo.getStats().getTotalSize()));
        final Client client = client();
import java.util.ArrayList;
        assertAcked(prepareCreate(index1, 1, Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0)));
            SnapshotStatus snapshotsStatus = client().admin()
        logger.info("--> indexing some data");
            SnapshotsInProgress.State.STARTED,
        String repositoryName = "test-repo";
            "mock",
        final SnapshotInfo found = snapshotInfos.get(0);
                .put("compress", false)
            );
        ensureGreen();
            }
            final SnapshotStatus snapshotStatusOne = getSnapshotStatus(repoName, snapshotOne);
                .put("location", randomRepoPath())
            .cluster()
        createIndex(index1, index2, index3);
        final Path repoPath = randomRepoPath();
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
                .prepareSnapshotStatus(repositoryName)
        );
        // create an index with a single shard on the data node, that will be stopped
    }
        index(indexOne, "_doc", "some_doc_id", "foo", "bar");
                String.join(", ", List.of(nonExistentIndex2, nonExistentIndex1)),
                CircuitBreakingException.class,
     * 3. Restart the data node that completed its shard snapshot
        assertEquals(2, snapshotStatuses.size());
                    .prepareSnapshotStatus(repositoryName)
        }
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        internalCluster().startDataOnlyNode();
        );
            assertEquals(snapshotIndexStatusMap.size(), 2);
        ensureGreen();
        final String indexName = "test-idx";
    public void testStatusAPICallInProgressShallowSnapshot() throws Exception {
                inProgressSnapshot,
        String index2 = "test-idx-2";
        logger.info("Create indices");
            CircuitBreakingException exception = expectThrows(
        final String[] snapshotNames = new String[numSnapshots];
        updateSettingsRequest.persistentSettings(Settings.builder().put(MAX_SHARDS_ALLOWED_IN_STATUS_API.getKey(), 5));
        createIndex(indexName, singleShardOneNode(dataNode));
import java.util.Collections;
    public void testStatusApiConsistency() {
            .addSnapshots("non-existent-snapshot")
            .prepareSnapshotStatus(repoName)
            .get();
            assertThat(totalFilesShardOne, greaterThan(0));
        ensureGreen();
        // across multiple snapshots
        indexRandomDocs("test-idx-good", randomIntBetween(1, 5));
            .put(ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.getKey(), 0) // We have tests that check by-timestamp order
        List<String> sortedNames = Arrays.asList(snapshotNames);
        logger.info("--> indexing some data");
     *
        String completedSnapshot = "test-completed-snapshot";
                    .prepareSnapshotStatus(repositoryName)
    }
        String snapshot2 = "test-snap-2";
    public void testSnapshotStatusOnFailedSnapshot() throws Exception {
            final String snapshotName = randomAlphaOfLength(8).toLowerCase(Locale.ROOT);
                .get(0);
            assertEquals(exception.status(), RestStatus.TOO_MANY_REQUESTS);
                "index list filter is supported only when a single 'snapshot' is passed, but found 'snapshot' param = [[test-snap-1, test-snap-2]]";
import static org.hamcrest.Matchers.greaterThan;
        unblockNode(repositoryName, blockedNode);
        createRepository("test-repo", "fs", repoPath);
    public void testCorrectCountsForDoneShards() throws Exception {
    public void testSnapshotStatusForIndexFilter() throws Exception {
            final SnapshotIndexShardStatus snapshotShardState = stateFirstShard(snapshotStatus, indexName);
            );
import java.util.Locale;
        // shard limit exceeded due to passing for inProgress but failing for current + completed
        assertAcked(prepareCreate(indexName, 1, Settings.builder().put("number_of_replicas", 0)));
        assertEquals(SnapshotsInProgress.State.STARTED, snapshotStatuses.get(0).getState());
        logger.info("Index some data");
                () -> client().admin()
        List<SnapshotStatus> snapshotStatuses = client().admin()
        assertEquals(
 * the Apache License, Version 2.0 (the "License"); you may
        unblockAllDataNodes(snapshotRepoName);
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
import org.opensearch.common.util.io.IOUtils;
        }
        assertBusy(() -> {
            final SnapshotStatus snapshotStatusOne = getSnapshotStatus(repoName, snapshotOne);
        assertBusy(() -> {
                () -> client().admin().cluster().prepareSnapshotStatus(repositoryName).setSnapshots(snapshot1).execute().actionGet()
        logger.info("--> wait for data nodes to get blocked");
        final String repoName = "test-repo";
                .setIndices(index1, index2)
                ActionRequestValidationException.class,
                () -> client().admin()
            .prepareSnapshotStatus(repositoryName)
            );
                .prepareSnapshotStatus(repositoryName)
            .addSnapshots("non-existent-snapshot")
                () -> client().admin()
            final long totalSizeShardOne = snapshotShardStateOne.getStats().getTotalSize();
        indexRandomDocs(index2, 10);
        assertBusy(() -> {
import org.opensearch.common.action.ActionFuture;
        final String snapshotTwo = "snap-2";
            // no error for ignore_unavailable = true and status response contains only the found indices
        final SnapshotInfo snapshotInfo = assertSuccessful(
                    .setSnapshots(inProgressSnapshot)
                .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        final String indexName = "index-1";
            index(indexName, "_doc", Integer.toString(i), "foo", "bar" + i);
        getSnapshotsResponse = client.admin().cluster().prepareGetSnapshots(repositoryName).addSnapshots(snapshotNames).get();
        final int totalFiles = snapshotShardStats.getTotalFileCount();
 * compatible open source license.
        String regexName = snapshotNames[randomIntBetween(0, numSnapshots - 1)];
        String repoName = "test-repo";
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        disableRepoConsistencyCheck("Remote store repository is being used for the test");
        for (int i = 0; i < 10; i++) {
        }
import java.util.Set;
        ensureGreen();
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus;
                .getSnapshots()
            assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
            .cluster()
        });
                () -> client().admin()
            .setSnapshots(randomFrom("_all", "_current", "snap-on-*", "*-on-empty-repo", "snap-on-empty-repo"))
                .setSnapshots(snapshot)
                    .setSnapshots(inProgressSnapshot)
            .get();
            );
            index(index3, "_doc", Integer.toString(i), "foo", "baz" + i);
                IndexNotFoundException.class,
            index(index3, "_doc", Integer.toString(i), "foo", "baz" + i);
    public void testSnapshotStatusForIndexFilterForInProgressSnapshot() throws Exception {
        logger.info("--> verify that snapshot without index shows up in non-verbose listing");
        snapshotNames[numSnapshots - 1] = inProgressSnapshot;
            CreateSnapshotResponse createSnapshotResponse = client.admin()
        }, 30L, TimeUnit.SECONDS);
        waitForCompletion(repositoryName, inProgressSnapshot, TimeValue.timeValueSeconds(60));
    }
            );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            assertTrue(
        // ignore_unavailable to true
        waitForCompletion(repositoryName, inProgressSnapshot, TimeValue.timeValueSeconds(60));
        // with ignore unavailable set to true, should not throw an exception
/*
        logger.info("Reset MAX_SHARDS_ALLOWED_IN_STATUS_API to default value");
        final String inProgressSnapshot = randomAlphaOfLength(8).toLowerCase(Locale.ROOT);
            assertThat(snapshotShardStateTwo.getStage(), is(SnapshotIndexShardStage.DONE));
            SnapshotStatus snapshotsStatus = client().admin()
                    .actionGet()
                .setSnapshots(inProgressSnapshot)
import org.opensearch.common.settings.Settings;
        assertThat(getSnapshotsResponse.getSnapshots().size(), equalTo(numSnapshots));
                snapshotsToGet.add(snapshotNames[i]);
                () -> client().admin()
            .cluster()
        logger.info("Unblock data node");
            equalTo(sortedNames)
                    .actionGet()
            Map<String, SnapshotIndexStatus> snapshotIndexStatusMap = snapshotsStatus.getIndices();
        createRepository(snapshotRepoName, "mock", snapshotRepoSettingsForShallowCopy().put("block_on_data", true));
                CircuitBreakingException.class,
                    .actionGet()
            .prepareCreateSnapshot(repoName, snapshotTwo)
        String index3 = "test-idx-3";
import org.opensearch.core.rest.RestStatus;
            // Although the snapshot contains 3 indices, the response of status api call only contains results for 2
        String index3 = "test-idx-3";
                    .setSnapshots(inProgressSnapshot)
    private static SnapshotIndexShardStatus stateFirstShard(SnapshotStatus snapshotStatus, String indexName) {
        refresh();
     */
                .cluster()
                    .execute()
        logger.info("Indexing some data");
                .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        final String snapshotRepoName = "snapshot-repo-name";
            String cause = "index list filter is supported only when a single 'snapshot' is passed, but found 'snapshot' param = [_all]";
        assertThat(getSnapshotsResponse.getSnapshots().size(), equalTo(numSnapshots));
 * The OpenSearch Contributors require contributions made to
import org.opensearch.cluster.SnapshotsInProgress;
            Settings.builder()
        unblockAllDataNodes("test-repo");
        waitForBlock(blockedNode, repositoryName, TimeValue.timeValueSeconds(60));
        final String initialBlockedNode = blockNodeWithIndex(repositoryName, indexName);
            .cluster()
        refresh();
        ActionFuture<CreateSnapshotResponse> createSnapshotResponseActionFuture = startFullSnapshot(snapshotRepoName, "test-snap");
            .prepareGetSnapshots(repositoryName)
                    .prepareSnapshotStatus(repositoryName)
            getSnapshotStatus(repoName, snapshotOne),
        createSnapshot(repositoryName, snapshot2, List.of(index1, index2));
        });
        final int numSnapshots = randomIntBetween(1, 3) + 1;
            client().admin().cluster().prepareSnapshotStatus("test-repo").setSnapshots("test-snap").get().getSnapshots().get(0).getState()
        logger.info("--> delete shard-level snap-${uuid}.dat file for one shard in this snapshot to simulate concurrent delete");
            .prepareCreateSnapshot(repositoryName, inProgressSnapshot)
                .setIndices(index1, index2, nonExistentIndex1, nonExistentIndex2)
        unblockAllDataNodes(repoName);
        final String repoName = "test-repo";
            .setSnapshots(inProgressSnapshot, completedSnapshot)
                    .setSnapshots(snapshot1, snapshot2)
            for (int i = 0; i < numSnapshots - 1; i++) {
    }
        final String snapshotRepoName = "snapshot-repo-name";
        });
        for (int i = 0; i < 10; i++) {
                exception.getMessage().contains(" is more than the maximum allowed value of shard count [5] for snapshot status request")
        final String indexTwo = "index-2";
            assertEquals(snapshotIndexStatusMap.keySet(), Set.of(index1, index2));
            final String nonExistentIndex1 = "non-existent-index-1";
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStats;
        // take initial snapshot with a block, making sure we only get 1 in-progress snapshot returned
            expectThrows(
        client().admin().cluster().prepareCreateSnapshot(repositoryName, inProgressSnapshot).setWaitForCompletion(false).get();
        });
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            .setWaitForCompletion(true)
import static org.hamcrest.Matchers.equalTo;
        if (randomBoolean()) {
        updateSettingsRequest.persistentSettings(Settings.builder().putNull(MAX_SHARDS_ALLOWED_IN_STATUS_API.getKey()));
        final ActionFuture<CreateSnapshotResponse> responseSnapshotOne = internalCluster().clusterManagerClient()
        // with ignore unavailable set to true, should not throw an exception
            .setVerbose(false)
        logger.info("--> snapshot");
            updateSettingsRequest.persistentSettings(Settings.builder().put(MAX_SHARDS_ALLOWED_IN_STATUS_API.getKey(), 2));
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotIndexShardStage;
            String cause = String.format(
        );
import org.opensearch.action.ActionRequestValidationException;
        for (int i = 0; i < 100; i++) {
        assertThat(
        assertAcked(prepareCreate(index2, 1, Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0)));
    }
                    .execute()
        logger.info("--> wait for snapshot to finish");
            index(index1, "_doc", Integer.toString(i), "foo", "bar" + i);
import static org.opensearch.snapshots.SnapshotsService.MAX_SHARDS_ALLOWED_IN_STATUS_API;
    }
        awaitNumberOfSnapshotsInProgress(1);
            assertThat(snapshotShardState.getStage(), is(SnapshotIndexShardStage.DONE));
        // Create index on 2 nodes and make sure each node has a primary by setting no replicas
                .get(0)
    }
                    .cluster()
        final List<String> snapshotsToGet = new ArrayList<>();
        unblockAllDataNodes(repositoryName);
        );
        createIndex(indexTwo, singleShardOneNode(dataNodeTwo));
            );
                    .cluster()
        String inProgressSnapshot = "test-in-progress-snapshot";
            .cluster()
        }
 * Modifications Copyright OpenSearch Contributors. See
        createIndex(index1, index2, index3);
            assertEquals(snapshotIndexStatusMap.size(), 2);
                    .setIndices(index1, index2, index3)
        }
            .build();
        createIndex(indexName);
                .getSnapshots()
    private static SnapshotStatus getSnapshotStatus(String repoName, String snapshotName) {
    }
            .prepareGetSnapshots(repositoryName)
            .getSnapshots();
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        assertEquals(0, getSnapshotsResponse.getSnapshots().size());
            .get();
            .get()
        ActionFuture<CreateSnapshotResponse> createSnapshotResponseActionFuture = startFullSnapshot("test-repo", "test-snap");
                .get(0);
        return snapshotStatus.getIndices().get(indexName).getShards().get(0);
    public void testExceptionOnMissingSnapBlob() throws IOException {
        }, 20, TimeUnit.SECONDS);
        String snapshot1 = "test-snap-1";
        final String indexOne = "index-1";
        logger.info("--> creating an index and indexing documents");
                repositoryName
            .prepareGetSnapshots("test-repo")
        return Settings.builder()
        createRepository(repositoryName, "fs");
        internalCluster().restartNode(dataNodeTwo);
    }
            () -> client().admin().cluster().getSnapshots(new GetSnapshotsRequest("test-repo", new String[] { "test-snap" })).actionGet()
            .get();
        logger.info("Set MAX_SHARDS_ALLOWED_IN_STATUS_API to a low value");
        logger.info("--> get snapshots on an empty repository");
            .setIndices(indexName)
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
    }
        for (int i = 0; i < 10; i++) {
import java.util.Map;
                repositoryName
                .get()
/*
            // use _current plus the individual names of the finished snapshots
    }
        indexRandomDocs(index3, 10);
            assertEquals(ex.status(), RestStatus.NOT_FOUND);
    public void testGetSnapshotsRequest() throws Exception {
        logger.info("Create indices");
        // add documents so there are data files to block on
            .setSnapshots(snapshot)
            assertThat(snapshotShardState.getStats().getTotalSize(), greaterThan(0L));
            );
        logger.info("--> wait for data nodes to get blocked");
                .put("compress", false)
        logger.info("Create indices");
        client.admin()
            );
        SnapshotInfo snapshotInfo = snapshotInfos.get(0);
        logger.info("Create in-progress snapshot");
        internalCluster().startDataOnlyNode();
        createSnapshotResponseActionFuture.actionGet();
            index("test-idx-1", "_doc", Integer.toString(i), "foo", "bar" + i);
                .prepareSnapshotStatus(repositoryName)
        index(indexTwo, "_doc", "some_other_doc_id", "foo", "other_bar");
            .setSnapshots(snapshotsToGet.toArray(Strings.EMPTY_ARRAY))
            .cluster()
        final String snapshotOne = "snap-1";
        refresh();
        final Path repoPath = randomRepoPath();
        String index1 = "test-idx-1";
            );
                    .setIndices(index1, index2, index3)
            index("test-idx-2", "_doc", Integer.toString(i), "foo", "baz" + i);
            assertEquals(ex.status(), RestStatus.TOO_MANY_REQUESTS);
            SnapshotStatus inProgressSnapshotStatus = client().admin()
        assertThat(responseSnapshotOne.get().getSnapshotInfo().state(), is(SnapshotState.SUCCESS));
            snapshotsToGet.add("_current");
        ensureGreen();
    public void testStatusAPICallForShallowCopySnapshot() throws Exception {
        assertEquals("snap-on-empty-repo", getSnapshotsResponse.getSnapshots().get(0).snapshotId().getName());
        final int splitPos = regexName.length() / 2;
                .cluster()
                .getSnapshots()
        // block a node so the create snapshot operation can remain in progress
    private static Settings singleShardOneNode(String node) {
            index(index2, "_doc", Integer.toString(i), "foo", "baz" + i);
                SnapshotMissingException.class,
import java.util.stream.Collectors;
        });
                    .actionGet()
                    .actionGet()
/*
        getSnapshotsResponse = client.admin()
            final SnapshotStatus snapshotStatusTwo = getSnapshotStatus(repoName, snapshotTwo);
    }
        getSnapshotsResponse = client.admin()
                    .setIndices(index1, index2, index3)
        logger.info("--> take another snapshot to be in-progress");
            .setIndices(indexName)
            Map<String, SnapshotIndexStatus> snapshotIndexStatusMap = snapshotsStatus.getIndices();
        assertThat(getSnapshotsResponse.getSnapshots().size(), equalTo(0));
        createRepository(
        logger.info("Indexing some data");
        createIndex("test-idx-1", "test-idx-2", "test-idx-3");
        for (int i = 0; i < 100; i++) {
            .get();
        createRepository("test-repo", "fs", repoPath);
 * Licensed to Elasticsearch under one or more contributor
        logger.info("--> indexing some data");
        );
            assertTrue(ex.getMessage().contains(cause));
 *    http://www.apache.org/licenses/LICENSE-2.0
                .actionGet()
 * this work for additional information regarding copyright
        } catch (SnapshotMissingException e) {
        });
        String index2 = "test-idx-2";
            repositoryName,
        // there is an in-progress snapshot, make sure we return empty result when getting a non-existing snapshot with setting
                .get();
            index(index3, "_doc", Integer.toString(i), "foo", "baz" + i);
        logger.info("Create snapshot");
            getSnapshotsResponse.getSnapshots().stream().map(s -> s.snapshotId().getName()).sorted().collect(Collectors.toList()),
        assertThat(getSnapshotsResponse.getSnapshots().size(), equalTo(numSnapshots));
        createRepository(repositoryName, "mock", Settings.builder().put("location", randomRepoPath()).put("block_on_data", true));
import java.io.IOException;
     * 2. Have one of the shards snapshot completely and the other block
package org.opensearch.snapshots;
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            );
                .getSnapshots()
import java.util.Arrays;
                .setSnapshots("test-snap")
        logger.info("Wait for snapshot to finish");
            logger.info("Reset MAX_SHARDS_ALLOWED_IN_STATUS_API to default value");
                    .setSnapshots(snapshot1, snapshot2)
        final SnapshotInfo snapshotInfo = createFullSnapshot("test-repo", "test-snap");
                .cluster()
