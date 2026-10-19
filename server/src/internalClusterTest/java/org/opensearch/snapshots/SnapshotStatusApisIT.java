 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
 */  
                    .actionGet()
        logger.info("Set MAX_SHARDS_ALLOWED_IN_STATUS_API to a low value");
            String cause = String.format(
        logger.info("--> creating good index");
                    .execute()
        assertThat(found.state(), is(SnapshotState.SUCCESS));
                exception.getMessage().contains(" is more than the maximum allowed value of shard count [2] for snapshot status request")
        createFullSnapshot("test-repo", "test-snap");
        assertThat(responseSnapshotOne.get().getSnapshotInfo().state(), is(SnapshotState.SUCCESS));  
            index("test-idx-2", "_doc", Integer.toString(i), "foo", "baz" + i);  
 * compatible open source license.
                    .setSnapshots()
            assertThat(snapshotShardState.getStats().getTotalSize(), greaterThan(0L));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .cluster()  
            .get();
            assertThat(totalSizeShardOne, equalTo(snapshotShardStateTwo.getStats().getTotalSize()));
            .get()
        SnapshotInfo snapshotInfo = snapshotInfos.get(0);  
        });  
                .setSnapshots(inProgressSnapshot)
                    .setSnapshots(inProgressSnapshot)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(getSnapshotsResponse.getSnapshots().size(), equalTo(numSnapshots));
            // use _current plus the individual names of the finished snapshots
        );  
        GetSnapshotsResponse getSnapshotsResponse = client.admin()  
        updateSettingsRequest.persistentSettings(Settings.builder().put(MAX_SHARDS_ALLOWED_IN_STATUS_API.getKey(), 2));  
                .prepareSnapshotStatus(repositoryName)  
        final SnapshotIndexShardStatus snapshotShardStateAfterNodeRestart = stateFirstShard(  
            );  
        logger.info("--> delete snap-${uuid}.dat file for this snapshot to simulate concurrent delete");
        // make sure we return only the in-progress snapshot when taking the first snapshot on a clean repository
        assertEquals(SnapshotsInProgress.State.SUCCESS, snapshotStatuses.get(1).getState());  
 *
    }
        final int numSnapshots = randomIntBetween(1, 3) + 1;
        }  
            .setWaitForCompletion(false)  
            String cause = String.format(
            .cluster()
import static org.hamcrest.Matchers.equalTo;  
        index(indexOne, "_doc", "some_doc_id", "foo", "bar");  
                CircuitBreakingException.class,  
                .prepareCreateSnapshot(repositoryName, snapshotName)
        ensureGreen();  
                    .execute()
    public void testSnapshotStatusApiFailureForTooManyShardsAcrossSnapshots() throws Exception {
            .setIndices(indexName)
        String snapshot = "test-snap-1";
import org.opensearch.common.action.ActionFuture;
        assertThat(
                .setWaitForCompletion(true)  
 * under the License.  
            SnapshotStatus snapshotsStatus = client().admin()
        final String snapshotTwo = "snap-2";
        final String indexOne = "index-1";
            assertTrue(ex.getMessage().contains(cause));
        Collections.sort(sortedNames);
        sortedNames = Arrays.asList(snapshotNames);  
            assertTrue(ex.getMessage().contains(cause));
            assertThat(snapshotStatusOne.getState(), is(SnapshotsInProgress.State.STARTED));
        ensureGreen();
            () -> client().admin().cluster().getSnapshots(new GetSnapshotsRequest("test-repo", new String[] { "test-snap" })).actionGet()
                    .setSnapshots(snapshot1, snapshot2)
                    .cluster()  
        index(indexTwo, "_doc", "some_other_doc_id", "foo", "other_bar");  
            assertTrue(
        logger.info("Create indices");  
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        assertBusy(() -> {  
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotIndexShardStage;
            .prepareCreateSnapshot(repositoryName, "snap-on-empty-repo")
                exception.getMessage().contains(" is more than the maximum allowed value of shard count [2] for snapshot status request")
                .get()
            .prepareGetSnapshots("test-repo")  
            final SnapshotStatus snapshotStatusTwo = getSnapshotStatus(repoName, snapshotTwo);  
        unblockNode(repositoryName, blockedNode); // unblock node
        final String indexName = "test-idx";
                Locale.ROOT,  
        ensureGreen();
                CircuitBreakingException.class,
        for (int i = 0; i < numSnapshots - 1; i++) {
                () -> client().admin()
            .admin()  
            String cause = "index list filter is supported only when a single 'snapshot' is passed, but found 'snapshot' param = [_all]";
            assertEquals(snapshotIndexStatusMap.keySet(), Set.of(index1, index2));
                .prepareSnapshotStatus(snapshotRepoName)  
            index(indexName, "_doc", Integer.toString(i), "foo", "bar" + i);
        createSnapshot(repositoryName, snapshot, List.of(index1, index2, index3));
            .get();
                    .setSnapshots(snapshot2)
        createIndex(indexTwo, singleShardOneNode(dataNodeTwo));
        logger.info("--> delete shard-level snap-${uuid}.dat file for one shard in this snapshot to simulate concurrent delete");
            .cluster()
        logger.info("--> wait for data nodes to get blocked");
            snapshotsToGet.add("_all");
        String repositoryName = "test-repo";  
            getSnapshotStatus(repoName, snapshotOne),
                .get()
            index(index2, "_doc", Integer.toString(i), "foo", "baz" + i);
        // shard limit exceeded due to inProgress snapshot alone @ without index-filter
public class SnapshotStatusApisIT extends AbstractSnapshotIntegTestCase {
        // Create index on 2 nodes and make sure each node has a primary by setting no replicas  
import java.nio.file.Path;
            );  
 * Unless required by applicable law or agreed to in writing,
            index("test-idx-1", "_doc", Integer.toString(i), "foo", "bar" + i);
 * not use this file except in compliance with the License.
            updateSettingsRequest.persistentSettings(Settings.builder().putNull(MAX_SHARDS_ALLOWED_IN_STATUS_API.getKey()));  
            index(index2, "_doc", Integer.toString(i), "foo", "baz" + i);
        String repoName = "test-repo";
        assertEquals(SnapshotsInProgress.State.PARTIAL, snapshotStatus.getState());
        createRepository("test-repo", "fs");
    protected Settings nodeSettings(int nodeOrdinal) {
        );
        String inProgressSnapshot = "test-in-progress-snapshot";
    }
            .setSnapshots(snapshot)  
        final String inProgressSnapshot = randomAlphaOfLength(8).toLowerCase(Locale.ROOT);
            "mock",
        refresh();
            .cluster()
                .resolve(BlobStoreRepository.SNAPSHOT_PREFIX + snapshotInfo.snapshotId().getUUID() + ".dat")
        indexRandomDocs(index3, 10);  
            assertEquals(snapshotIndexStatusMap.keySet(), Set.of(index1, index2));
        List<SnapshotInfo> snapshotInfos = clusterAdmin().prepareGetSnapshots("test-repo").get().getSnapshots();
                    .execute()
        createRepository(snapshotRepoName, "fs", snapshotRepoSettingsForShallowCopy());  
                .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
            );
        refresh();
        for (int i = 0; i < 10; i++) {
        final String repoName = "test-repo";
        Collections.sort(sortedNames);
        final String[] snapshotNames = new String[numSnapshots];  
            .cluster()  
        for (int i = 0; i < 100; i++) {
                .cluster()
                .cluster()  
        logger.info("--> indexing some data");
            Settings.builder()
        logger.info("--> take another snapshot to be in-progress");  
        assertEquals(
        String index2 = "test-idx-2";
            .prepareSnapshotStatus(repositoryName)
        stopNode(dataNode);
        String repositoryName = "test-repo";
                    .cluster()  
            final String nonExistentIndex2 = "non-existent-index-2";
            assertThat(snapshotShardStateTwo.getStats().getIncrementalSize(), equalTo(0L));  
        for (int i = 0; i < 100; i++) {  
/*  
            // Although the snapshot contains 3 indices, the response of status api call only contains results for 2
            .put(super.nodeSettings(nodeOrdinal))
        }, 30L, TimeUnit.SECONDS);
        logger.info("--> snapshot");
                    .cluster()
            // no error for ignore_unavailable = true and status response contains only the found indices
        // test normal functioning of index filter for in progress snapshot  
        // take initial snapshot with a block, making sure we only get 1 in-progress snapshot returned  
            String cause =
                    .cluster()
        assertThat(found.snapshotId(), is(snapshotInfo.snapshotId()));  
            SnapshotsInProgress.State.STARTED,
        indexRandomDocs(index2, 10);  
        }
        assertThat(snapshotInfos, hasSize(1));
    }
        });
        indexRandomDocs("test-idx-good", randomIntBetween(1, 5));
        blockDataNode(repoName, dataNodeOne);
    }  
        }
        logger.info("Indexing some data");  
                .put("location", randomRepoPath())  
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus;
import java.util.List;  
                .prepareSnapshotStatus(repositoryName)
        refresh();  
                .cluster()
        assertBusy(() -> {
        assertEquals(SnapshotsInProgress.State.STARTED, snapshotStatuses.get(0).getState());
    public void testStatusApiConsistency() {  
            .prepareGetSnapshots(repositoryName)  
import java.util.concurrent.TimeUnit;
        createRepository(repoName, "fs");
        assertThat(getSnapshotsResponse.getSnapshots().size(), equalTo(numSnapshots));
            );
            assertThat(snapshotShardState.getStats().getIncrementalFileCount(), greaterThan(0));
        logger.info("Index some data");  
        logger.info("Wait for snapshot to finish");
                .getSnapshots()  
            // Although the snapshot contains 3 indices, the response of status api call only contains results for 2  
            .cluster()
                .put("compress", false)
        } catch (SnapshotMissingException e) {
            repositoryName,  
            client().admin()
        }
            indexTwo
            .get()
            .execute();
        createIndex("test-idx-1");
        });
        assertEquals("snap-on-empty-repo", getSnapshotsResponse.getSnapshots().get(0).snapshotId().getName());
                .getSnapshots()  
                .setSnapshots(snapshot)  
            () -> client.admin().cluster().prepareGetSnapshots(repositoryName).addSnapshots("non-existent-snapshot").get()  
            Settings.builder()
            client().admin().cluster().prepareSnapshotStatus("test-repo").setSnapshots("test-snap").get().getSnapshots().get(0).getState()  
        assertAcked(prepareCreate(index2, 1, Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0)));
                    .actionGet()  
    public void testStatusAPICallInProgressShallowSnapshot() throws Exception {
        final String blockedNode = blockNodeWithIndex(repositoryName, indexName);
        createRepository(repositoryName, "fs");
            );
        assertBusy(() -> {
        createRepository(repoName, "mock");
        }
        createIndex(indexName);  
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        logger.info("--> make sure duplicates are not returned in the response");
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
                .get(0)
 *
                    .setSnapshots(snapshot1)  
        logger.info("Unblock data node");
                "indices [%s] missing in snapshot [%s] of repository [%s]",  
            assertThat(snapshotShardState.getStage(), is(SnapshotIndexShardStage.DONE));
            index(index3, "_doc", Integer.toString(i), "foo", "baz" + i);
            index(index3, "_doc", Integer.toString(i), "foo", "baz" + i);
            index(indexName, "_doc", Integer.toString(i), "foo", "bar" + i);
            assertThat(totalFilesShardOne, greaterThan(0));
        logger.info("Indexing some data");
        String repositoryName = "test-repo";
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        final Path repoPath = randomRepoPath();
            .execute();  
    public void testStatusAPICallInProgressSnapshot() throws Exception {
    }
                .actionGet()
import org.opensearch.action.ActionRequestValidationException;
            for (int i = 0; i < numSnapshots - 1; i++) {
            final String nonExistentIndex1 = "non-existent-index-1";
        refresh();  
            .cluster()
        assertEquals(snapshotStatus.getStats().getStartTime(), snapshotInfo.startTime());
 * this file be licensed under the Apache-2.0 license or a
                .get()
 *  
        createIndex(index1, index2, index3);  
        final String indexName = "test-idx";
                    .prepareSnapshotStatus(repositoryName)
        for (int i = 0; i < 100; i++) {
                .prepareSnapshotStatus(repositoryName)
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;  
        refresh();  
            );
            final long totalSizeShardOne = snapshotShardStateOne.getStats().getTotalSize();  
        unblockAllDataNodes(repoName);
            final int totalFilesShardOne = snapshotShardStateOne.getStats().getTotalFileCount();
            CircuitBreakingException exception = expectThrows(
            snapshotNames[i] = snapshotName;
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            .addSnapshots(snapshotNames)
                    .actionGet()
        assertEquals(2, snapshotStatuses.size());
            );  
                .cluster()
        logger.info("Create snapshot");
 * SPDX-License-Identifier: Apache-2.0
                .setSnapshots(snapshot2)  
            SnapshotStatus snapshotsStatus = client().admin()  
        logger.info("--> indexing some data");  
import java.io.IOException;
            assertThat(totalSizeShardOne, greaterThan(0L));
                Exception.class,
        });
        assertAcked(prepareCreate(index1, 1, Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0)));
    public void testGetSnapshotsRequest() throws Exception {  
        logger.info("--> stopping data node before creating snapshot");  
        final String dataNodeTwo = dataNodes.get(1);  
                .getSnapshots()  
    }
        }, 30L, TimeUnit.SECONDS);
        // with ignore unavailable set to true, should not throw an exception
            assertThat(snapshotShardState.getStats().getTotalSize(), greaterThan(0L));
        for (int i = 0; i < 100; i++) {  
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        final String snapshotOne = "snap-1";  
        // ignore_unavailable to true
            index(index2, "_doc", Integer.toString(i), "foo", "baz" + i);
                .get();
                .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
import org.opensearch.transport.client.Client;
        createRepository(repositoryName, "mock", Settings.builder().put("location", randomRepoPath()).put("block_on_data", true));
        assertBusy(() -> {
                .setIndices(index1, index2)  
        createRepository("test-repo", "mock", Settings.builder().put("location", randomRepoPath()).put("block_on_data", true));
        createRepository(repoName, "fs");  
            .setIgnoreUnavailable(true)  
        final List<SnapshotInfo> snapshotInfos = client().admin()
        blockedNode = blockNodeWithIndex(repositoryName, index1);  
            SnapshotsInProgress.State.STARTED,  
    public void testSnapshotStatusOnPartialSnapshot() throws Exception {  
    public void testGetSnapshotsWithoutIndices() throws Exception {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        startFullSnapshot(repoName, snapshotName, true).get();
        });
     * Tests the following sequence of steps:
        final String snapshotRepoName = "snapshot-repo-name";
                    .prepareSnapshotStatus("_all")
        waitForBlock(dataNodeTwo, repoName, TimeValue.timeValueSeconds(30L));
import static org.hamcrest.Matchers.hasSize;
    }
        disableRepoConsistencyCheck("Remote store repository is being used for the test");
    private static Settings singleShardOneNode(String node) {  
            // failure due to passing index filter for _all value of repository param  
        final ActionFuture<CreateSnapshotResponse> responseSnapshotOne = internalCluster().clusterManagerClient()
            assertThat(snapshotShardState.getStats().getIncrementalSize(), greaterThan(0L));  
        logger.info("Create completed snapshot");
            equalTo(sortedNames)
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        snapshotNames[numSnapshots - 1] = inProgressSnapshot;
        waitForBlock(blockedNode, repositoryName, TimeValue.timeValueSeconds(60));
        updateSettingsRequest.persistentSettings(Settings.builder().putNull(MAX_SHARDS_ALLOWED_IN_STATUS_API.getKey()));  
        logger.info("--> snapshot");
        final String repoName = "test-repo";
        addBwCFailedSnapshot(repoName, snapshot, Collections.emptyMap());
            SnapshotStatus snapshotsStatus = client().admin()  
        waitForBlockOnAnyDataNode("test-repo", TimeValue.timeValueMinutes(1));
            .put(ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.getKey(), 0) // We have tests that check by-timestamp order
        assertThat(  
import static org.opensearch.snapshots.SnapshotsService.MAX_SHARDS_ALLOWED_IN_STATUS_API;
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();  
                    .execute()
            .cluster()
        assertBusy(() -> {
    public void testSnapshotStatusFailuresWithIndexFilter() throws Exception {  
        logger.info("--> unblock all data nodes");  
                    .actionGet()
        String blockedNode = blockNodeWithIndex(repositoryName, index1);
                    .cluster()  
            String cause =
            .addSnapshots(firstRegex, secondRegex)
                    .setSnapshots(snapshot1)  
        final String secondRegex = "*" + regexName.substring(splitPos);  
                    .setSnapshots(snapshot1, snapshot2)  
            assertEquals(snapshotIndexStatusMap.keySet(), Set.of(index1, index2));
import org.opensearch.threadpool.ThreadPool;
        createIndex(indexName, singleShardOneNode(dataNode));
}  
 * specific language governing permissions and limitations
                    .setIndices(index1, index2, index3)
    }
        createIndex("test-idx-1", "test-idx-2", "test-idx-3");  
            .prepareCreateSnapshot(repoName, snapshotOne)
        logger.info("Create indices");
            assertEquals(snapshotIndexStatusMap.size(), 2);
    }
            index(index2, "_doc", Integer.toString(i), "foo", "baz" + i);  
        unblockAllDataNodes(repositoryName);  
                    .execute()
                () -> client().admin().cluster().prepareSnapshotStatus(repositoryName).setSnapshots(snapshot1).execute().actionGet()
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(  
                    .actionGet()  
        );
            );  
                    .setSnapshots(inProgressSnapshot)
                () -> client().admin()  
            .cluster()
            assertTrue(
            assertEquals(exception.status(), RestStatus.TOO_MANY_REQUESTS);  
            assertEquals(cause, ex.getCause().getMessage());  
        }
        for (int i = 0; i < 100; i++) {  
                () -> client().admin().cluster().prepareSnapshotStatus("test-repo").setSnapshots("test-snap").execute().actionGet()
        return indexSettingsNoReplicas(1).put("index.routing.allocation.include._name", node).build();
        assertThat(snapshotInfo.version(), equalTo(Version.CURRENT));
        // add documents so there are data files to block on
            assertThat(snapshotShardState.getStats().getTotalFileCount(), greaterThan(0));  
        refresh();
 * GitHub history for details.
        expectThrows(
            .get();
     * 1. Start snapshot of two shards (both located on separate data nodes).  
            .prepareSnapshotStatus(repoName)
        logger.info("--> get snapshots on an empty repository");  
        for (int i = 0; i < 10; i++) {
        ensureGreen();
 * the Apache License, Version 2.0 (the "License"); you may
            assertEquals(ex.status(), RestStatus.NOT_FOUND);
                    .cluster()
        }
        String index1 = "test-idx-1";
                    .setIndices(index1, index2, index3)  
            .getSnapshots();
        client.admin()
        logger.info("--> wait for data nodes to get blocked");
        final String firstRegex = regexName.substring(0, splitPos) + "*";
                () -> client().admin()
        for (int i = 0; i < 10; i++) {  
        final int totalFiles = snapshotShardStats.getTotalFileCount();
                IndexNotFoundException.class,
        return Settings.builder()  
            assertThat(snapshotShardStateTwo.getStats().getIncrementalFileCount(), equalTo(0));
            throw new AssertionError(e);
            .prepareCreateSnapshot(repoName, snapshotTwo)
                .getSnapshots()  
            logger.info("Reset MAX_SHARDS_ALLOWED_IN_STATUS_API to default value");
import org.opensearch.common.unit.TimeValue;
            // failure due to index not found in snapshot
     */  
    }
        refresh();
        internalCluster().startDataOnlyNode();  
        List<String> sortedNames = Arrays.asList(snapshotNames);  
                exception.getMessage().contains(" is more than the maximum allowed value of shard count [1] for snapshot status request")
        createSnapshot(repositoryName, snapshot2, List.of(index1));  
                    .prepareSnapshotStatus(repositoryName)
        indexRandomDocs(index2, 10);
        createIndex("test-idx-1");
            .get();
        String snapshot2 = "test-snap-2";
        final String snapshot = "snapshot";
                .setSnapshots(snapshot)  
            assertThat(snapshotShardState.getStats().getTotalFileCount(), greaterThan(0));
     * 2. Have one of the shards snapshot completely and the other block
        String completedSnapshot = "test-completed-snapshot";  
import java.util.Arrays;
        final Client client = client();  
        createIndex(indexOne, singleShardOneNode(dataNodeOne));
                    .cluster()  
            .prepareGetSnapshots(repositoryName)
            assertEquals(snapshotIndexStatusMap.size(), 2);  
        createRepository(repositoryName, "fs");
        createFullSnapshot(snapshotRepoName, snapshot);  
        ensureGreen();
import org.opensearch.Version;
        );  
import java.util.stream.Collectors;
        logger.info("Reset MAX_SHARDS_ALLOWED_IN_STATUS_API to default value");
        final long totalFileSize = snapshotShardStats.getTotalSize();
            final SnapshotIndexShardStatus snapshotShardStateOne = stateFirstShard(snapshotStatusOne, indexOne);
                .get()
            .get();
        String index3 = "test-idx-3";  
        assertBusy(() -> {
    public void testSnapshotStatusForIndexFilter() throws Exception {
        updateSettingsRequest.persistentSettings(Settings.builder().put(MAX_SHARDS_ALLOWED_IN_STATUS_API.getKey(), 1));
        logger.info("--> wait for snapshot to finish");
import static org.hamcrest.Matchers.is;  
        logger.info("Create in-progress snapshot");
            return client().admin().cluster().prepareSnapshotStatus(repoName).setSnapshots(snapshotName).get().getSnapshots().get(0);  
            equalTo(sortedNames)
    public void testSnapshotStatusShardLimitOfResponseForInProgressSnapshot() throws Exception {
        assertEquals(snapshotStatus.getStats().getTime(), snapshotInfo.endTime() - snapshotInfo.startTime());  
        waitForCompletion(repositoryName, inProgressSnapshot, TimeValue.timeValueSeconds(60));
        String snapshot1 = "test-snap-1";
        waitForBlockOnAnyDataNode(snapshotRepoName, TimeValue.timeValueMinutes(1));  
            assertTrue(ex.getMessage().contains(cause));
                    .actionGet()
            .prepareCreateSnapshot(repositoryName, inProgressSnapshot)
    public void testExceptionOnMissingSnapBlob() throws IOException {
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        // create an index with a single shard on the data node, that will be stopped  
                () -> client().admin()
            );
import java.util.Collections;
            CircuitBreakingException ex = expectThrows(
        final SnapshotsStatusResponse snapshotsStatusResponse = client().admin()  
                .setIgnoreUnavailable(true)
        assertThat(getSnapshotsResponse.getSnapshots().size(), equalTo(0));  
            final SnapshotStatus snapshotStatusOne = getSnapshotStatus(repoName, snapshotOne);
                exception.getMessage().contains(" is more than the maximum allowed value of shard count [5] for snapshot status request")  
import java.util.Map;
                String.join(", ", List.of(index2, index3)),
import java.util.ArrayList;  
                Exception.class,
            );
                .get(0);
            index("test-idx-1", "_doc", Integer.toString(i), "foo", "bar" + i);  
        ActionFuture<CreateSnapshotResponse> createSnapshotResponseActionFuture = startFullSnapshot(repositoryName, inProgressSnapshot);  
            .setIndices(indexName)  
        // across multiple snapshots  
    }  
                .prepareSnapshotStatus(snapshotRepoName)
                repositoryName
        assertBusy(() -> {
        });  
                .setIndices(index1, index2)
        // with ignore unavailable set to true, should not throw an exception
                    .prepareSnapshotStatus(repositoryName)
        logger.info("--> indexing some data");
            getSnapshotsResponse.getSnapshots().stream().map(s -> s.snapshotId().getName()).sorted().collect(Collectors.toList()),
            index(index1, "_doc", Integer.toString(i), "foo", "bar" + i);
            ActionRequestValidationException ex = expectThrows(
        ensureGreen();
        assertBusy(() -> {
        final ActionFuture<CreateSnapshotResponse> responseSnapshotTwo = client().admin()
                    .setIndices(index1, index2, index3)
            .build();  
            assertThat(snapshotShardState.getStage(), is(SnapshotIndexShardStage.DONE));
        getSnapshotsResponse = client.admin()
            );
                SnapshotMissingException.class,  
            .addSnapshots("non-existent-snapshot")
                () -> client().admin()
                    .execute()
        assertBusy(() -> {
            );
        });
        indexRandomDocs(index1, 10);
     * @throws Exception on failure
        ensureGreen();
            CreateSnapshotResponse createSnapshotResponse = client.admin()  
                "index list filter is supported only when a single 'repository' is passed, but found 'repository' param = [_all]";  
        final String indexName = "index-1";
        String regexName = snapshotNames[randomIntBetween(0, numSnapshots - 1)];  
        waitForCompletion(repositoryName, completedSnapshot, TimeValue.timeValueSeconds(60));
    }  
            expectThrows(
        String index3 = "test-idx-3";
        });
        updateSettingsRequest.persistentSettings(Settings.builder().putNull(MAX_SHARDS_ALLOWED_IN_STATUS_API.getKey()));
    @Override
            assertEquals(snapshotIndexStatusMap.size(), 2);
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
                "index list filter is supported only when a single 'snapshot' is passed, but found 'snapshot' param = [[test-snap-1, test-snap-2]]";  
        waitForCompletion(repositoryName, inProgressSnapshot, TimeValue.timeValueSeconds(60));
                "indices [%s] missing in snapshot [%s] of repository [%s]",
        ActionFuture<CreateSnapshotResponse> createSnapshotResponseActionFuture = startFullSnapshot(snapshotRepoName, "test-snap");  
        if (randomBoolean()) {
            final SnapshotIndexShardStatus snapshotShardState = stateFirstShard(snapshotStatusOne, indexTwo);  
                .getSnapshots()
        awaitNumberOfSnapshotsInProgress(1);  
        String index2 = "test-idx-2";  
            // failure due to too many shards requested
        final SnapshotStatus snapshotStatus = getSnapshotStatus(repoName, snapshotName);  
        waitForBlock(initialBlockedNode, repositoryName, TimeValue.timeValueSeconds(60)); // wait for block to kick in  
        logger.info("Block data node");
                    .execute()  
        }  
            SnapshotMissingException.class,  
        logger.info("--> verify that snapshot without index shows up in non-verbose listing");  
            assertTrue(  
        assertThat(responseSnapshotTwo.get().getSnapshotInfo().state(), is(SnapshotState.SUCCESS));
            assertThat(snapshotShardStateTwo.getStage(), is(SnapshotIndexShardStage.DONE));
                () -> client().admin()  
        String index1 = "test-idx-1";
            index("test-idx-1", "_doc", Integer.toString(i), "foo", "bar" + i);
        assertBusy(() -> {
            assertEquals(cause, ex.getCause().getMessage());
    public void testExceptionOnMissingShardLevelSnapBlob() throws Exception {
        createIndex(indexName);  
                    .cluster()
        logger.info("Create indices");
    }
        admin().cluster().prepareDeleteSnapshot(repositoryName, "snap-on-empty-repo").get();
        ActionFuture<CreateSnapshotResponse> createSnapshotResponseActionFuture = startFullSnapshot("test-repo", "test-snap");
                .setIndices(index1, index2, nonExistentIndex1, nonExistentIndex2)  
        refresh();  
        }
                    .actionGet()
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
                Locale.ROOT,
        client.admin()  
            assertTrue(
        String inProgressSnapshot = "test-in-progress-snapshot";  
        waitForCompletion(repositoryName, inProgressSnapshot, TimeValue.timeValueSeconds(60));  
        getSnapshotsResponse = client.admin()
        createIndex(index1, index2, index3);
                CircuitBreakingException.class,  
            assertTrue(
                    .prepareSnapshotStatus(repositoryName)  
            final SnapshotStatus snapshotStatus = client().admin()  
            .get();
        logger.info("Reset MAX_SHARDS_ALLOWED_IN_STATUS_API to default value");
        // for a completed snapshot
            // failure due to passing index filter for _all value of snapshot param --> gets translated as a blank array
        createSnapshot(repositoryName, snapshot2, List.of(index1, index2));
        final String snapshotRepoName = "snapshot-repo-name";
        IOUtils.rm(  
        } else {
            index(indexName, "_doc", Integer.toString(i), "foo", "bar" + i);  
        String index2 = "test-idx-2";
            assertEquals(ex.status(), RestStatus.TOO_MANY_REQUESTS);
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();  
            .cluster()
            .setSnapshots(inProgressSnapshot, completedSnapshot)  
        assertBusy(() -> {
        }, 20, TimeUnit.SECONDS);
            .getSnapshots();  
        logger.info("--> indexing some data");
                    .actionGet()  
                repositoryName  
        final List<String> dataNodes = internalCluster().startDataOnlyNodes(2);
            assertEquals(exception.status(), RestStatus.TOO_MANY_REQUESTS);
                .getState()
        assertEquals(0, getSnapshotsResponse.getSnapshots().size());
        assertBusy(() -> {
        logger.info("Create indices");
                .get()
        blockDataNode(repoName, dataNodeTwo);
import java.util.Locale;
            final SnapshotStatus snapshotStatusOne = getSnapshotStatus(repoName, snapshotOne);
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;  
            );  
import org.opensearch.common.util.io.IOUtils;
import org.opensearch.common.settings.Settings;  
                    .setIndices(index1, index2, nonExistentIndex1, nonExistentIndex2)  
        final String indexTwo = "index-2";  
                CircuitBreakingException.class,  
        // when a non-existent index is requested in the index-filter
    public void testCorrectCountsForDoneShards() throws Exception {
                    .setSnapshots(inProgressSnapshot, completedSnapshot)  
                .get(0);  
        // block a node so the create snapshot operation can remain in progress
        });
            "mock",
import java.util.Set;  
        );  
                .setSnapshots(inProgressSnapshot)
            );
        refresh();
        final String dataNode = internalCluster().startDataOnlyNode();
                snapshotsToGet.add(snapshotNames[i]);
        String index1 = "test-idx-1";
            );  
        final String indexName = "index-1";
            .prepareGetSnapshots(repositoryName)  
        String index2 = "test-idx-2";
        for (int i = 0; i < 10; i++) {  
        assertThat(snapshotShardStateAfterNodeRestart.getStats().getTotalSize(), equalTo(totalFileSize));  
            assertThat(totalFilesShardOne, equalTo(snapshotShardStateTwo.getStats().getTotalFileCount()));  
            getSnapshotsResponse.getSnapshots().stream().map(s -> s.snapshotId().getName()).sorted().collect(Collectors.toList()),
                .setSnapshots("test-snap")
                    .setIndices(index1, index2, index3)  
                () -> client().admin()
        unblockNode(repositoryName, blockedNode);
        final int splitPos = regexName.length() / 2;
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
            repoPath.resolve(resolvePath(indexId, "0"))
        ensureGreen();  
        assertThat(snapshotInfo.totalShards(), is(0));
        // shard limit exceeded due to inProgress snapshot alone @ with index-filter  
            index(index1, "_doc", Integer.toString(i), "foo", "bar" + i);
            assertThat(snapshotStatus.getState(), is(SnapshotsInProgress.State.SUCCESS));
            equalTo(sortedNames)
                .cluster()
        final String initialBlockedNode = blockNodeWithIndex(repositoryName, indexName);
                .prepareSnapshotStatus(repositoryName)
    public void testStatusAPICallForShallowCopySnapshot() throws Exception {  
            Map<String, SnapshotIndexStatus> snapshotIndexStatusMap = snapshotsStatus.getIndices();
                .get(0);
        awaitNumberOfSnapshotsInProgress(1);
        client().admin().cluster().prepareCreateSnapshot(repositoryName, inProgressSnapshot).setWaitForCompletion(false).get();
                snapshot2,  
                .getSnapshots()
                    .prepareSnapshotStatus(repositoryName)
                .setIgnoreUnavailable(true)
 * this work for additional information regarding copyright
            );  
import static org.hamcrest.Matchers.greaterThan;
            logger.info("Set MAX_SHARDS_ALLOWED_IN_STATUS_API to a low value");
                .put("wait_after_unblock", 200)  
        createSnapshotResponseActionFuture.actionGet();  
            );
            final SnapshotIndexShardStatus snapshotShardStateTwo = stateFirstShard(snapshotStatusTwo, indexOne);
 */  
        waitForBlock(blockedNode, repositoryName, TimeValue.timeValueSeconds(60));  
        );
        }
        logger.info("Create indices");  
                .getSnapshots()  
            // no error for ignore_unavailable = true and status response contains only the found indices
                .put("compress", false)
        });  
        internalCluster().startClusterManagerOnlyNode();
    }
            .addSnapshots("non-existent-snapshot")  
                    .prepareSnapshotStatus(repositoryName)
            .setWaitForCompletion(false)
import org.opensearch.core.rest.RestStatus;  
            updateSettingsRequest.persistentSettings(Settings.builder().put(MAX_SHARDS_ALLOWED_IN_STATUS_API.getKey(), 2));
/*
        index(indexTwo, "_doc", "some_doc_id", "foo", "bar");
        final List<String> snapshotsToGet = new ArrayList<>();  
        internalCluster().startDataOnlyNode();  
        assertEquals(1, getSnapshotsResponse.getSnapshots().size());  
            .get();
            Map<String, SnapshotIndexStatus> snapshotIndexStatusMap = snapshotsStatus.getIndices();
                Exception.class,
                ActionRequestValidationException.class,
 * The OpenSearch Contributors require contributions made to  
            Exception ex = expectThrows(
        awaitNumberOfSnapshotsInProgress(1);
                    .prepareSnapshotStatus(repositoryName)
                    .actionGet()
                .setIndices(index1, index2, index3)
            client().admin().cluster().prepareCreateSnapshot("test-repo", "test-snap").setIndices().setWaitForCompletion(true).execute()
        ensureGreen();  
            repositoryName,  
        String index3 = "test-idx-3";  
            assertTrue(ex.getMessage().contains(" is more than the maximum allowed value of shard count [2] for snapshot status request"));  
        for (int i = 10; i < 20; i++) {
            SnapshotStatus inProgressSnapshotStatus = client().admin()
                    .setSnapshots(inProgressSnapshot)
        assertAcked(prepareCreate(index3, 1, Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0)));  
     * 3. Restart the data node that completed its shard snapshot
        }, 1, TimeUnit.MINUTES);  
                .put("wait_after_unblock", 200)  
        String repositoryName = "test-repo";
        // restarting a data node below so using a cluster-manager client here
                .cluster()  
        expectThrows(
            }  
        final Path repoPath = randomRepoPath();
        waitForBlock(blockedNode, repositoryName, TimeValue.timeValueSeconds(60)); // wait for block to kick in
            assertEquals(exception.status(), RestStatus.TOO_MANY_REQUESTS);  
            .cluster()
        String snapshot2 = "test-snap-2";  
        internalCluster().startClusterManagerOnlyNode();
        final String dataNodeOne = dataNodes.get(0);
            );
        IndexId indexId = getRepositoryData("test-repo").resolveIndexId(snapshotInfo.indices().get(0));
        createSnapshotResponseActionFuture.actionGet();
            .prepareGetSnapshots("test-repo")  
        index(indexName, "_doc", "some_doc_id", "foo", "bar");
import org.opensearch.core.common.breaker.CircuitBreakingException;
                    .cluster()
        assertEquals(
import org.opensearch.core.common.Strings;  
        );  
        unblockAllDataNodes("test-repo");
                    .cluster()
        );
        // block a node so the create snapshot operation can remain in progress  
        final String repositoryName = "test-repo";
        client().admin().cluster().prepareCreateSnapshot(repositoryName, completedSnapshot).setWaitForCompletion(false).get();
        assertBusy(() -> {  
        }  
        // there is an in-progress snapshot, make sure we return empty result when getting a non-existing snapshot with setting  
        });
        ensureGreen();
            final SnapshotIndexShardStatus snapshotShardState = stateFirstShard(snapshotStatus, indexName);
        assertAcked(prepareCreate("test-idx-good").setSettings(indexSettingsNoReplicas(1)));
        logger.info("--> indexing some data");
            assertEquals(1, snapshotsStatus.getIndices().size());  
    }
            index(index3, "_doc", Integer.toString(i), "foo", "baz" + i);  
        String index1 = "test-idx-1";  
        logger.info("Index some more data");
        assertBusy(() -> {
        logger.info("--> unblock all data nodes");
        assertThat(getSnapshotsResponse.getSnapshots().size(), equalTo(numSnapshots));
            assertEquals(3, inProgressSnapshotStatus.getShards().size());
        logger.info("Set MAX_SHARDS_ALLOWED_IN_STATUS_API to a low value");
        unblockNode(repositoryName, initialBlockedNode); // unblock node
            index(index1, "_doc", Integer.toString(i), "foo", "bar" + i);
    public void testSnapshotStatusForIndexFilterForInProgressSnapshot() throws Exception {  
        createRepository(snapshotRepoName, "mock", snapshotRepoSettingsForShallowCopy().put("block_on_data", true));  
            snapshotsToGet.add("_current");  
            .setSnapshots(randomFrom("_all", "_current", "snap-on-*", "*-on-empty-repo", "snap-on-empty-repo"))
            final String snapshotName = randomAlphaOfLength(8).toLowerCase(Locale.ROOT);
        createRepository("test-repo", "fs");
        String index1 = "test-idx-1";
            Exception ex = expectThrows(  
        }, 20, TimeUnit.SECONDS);  
                () -> client().admin()
        assertBusy(() -> {
    /**
        logger.info("Indexing some data");
                .get(0);
                String.join(", ", List.of(nonExistentIndex2, nonExistentIndex1)),
        );
    }
        final SnapshotStats snapshotShardStats = stateFirstShard(getSnapshotStatus(repoName, snapshotOne), indexTwo).getStats();  
    }
        assertAcked(prepareCreate(indexName, 1, Settings.builder().put("number_of_replicas", 0)));
            assertEquals(exception.status(), RestStatus.TOO_MANY_REQUESTS);
        String repositoryName = "test-repo";
        waitForBlockOnAnyDataNode(repositoryName, TimeValue.timeValueMinutes(1));  
                    .execute()
        indexRandomDocs(index1, 10);
        String index3 = "test-idx-3";
            index("test-idx-3", "_doc", Integer.toString(i), "foo", "baz" + i);
        final String snapshotName = "test-snap";  
        createIndex(index1, index2, index3);
     * 4. Make sure that snapshot status APIs show correct file-counts and -sizes  
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.unit.ByteSizeUnit;
        unblockAllDataNodes(snapshotRepoName);  
import org.opensearch.repositories.IndexId;
    }
            assertEquals(exception.status(), RestStatus.TOO_MANY_REQUESTS);  
                .setSnapshots(inProgressSnapshot)
                .cluster()
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotIndexShardStatus;
                () -> client().admin()  
        disableRepoConsistencyCheck("This test intentionally corrupts the repository");  
        // indexing another document to the second index so it will do writes during the snapshot and we can block on those writes
            .setVerbose(false)
            .prepareGetSnapshots("test-repo")
        final SnapshotInfo found = snapshotInfos.get(0);
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;  
                .get(0);
        createRepository(
                    .prepareSnapshotStatus(repositoryName)  
        indexRandomDocs(indexName, 10);  
        assertEquals(SnapshotsInProgress.State.FAILED, snapshotsStatusResponse.getSnapshots().get(0).getState());  
                inProgressSnapshot,
    public void testSnapshotStatusOnFailedSnapshot() throws Exception {
        return snapshotStatus.getIndices().get(indexName).getShards().get(0);
        logger.info("--> take {} snapshot(s)", numSnapshots - 1);
        ensureGreen();  
                () -> client().admin()  
        unblockAllDataNodes(repoName);  
            getSnapshotsResponse.getSnapshots().stream().map(s -> s.snapshotId().getName()).sorted().collect(Collectors.toList()),  
            .cluster()  
        final SnapshotInfo snapshotInfo = createFullSnapshot("test-repo", "test-snap");
        indexRandomDocs(index3, 10);
        List<SnapshotStatus> snapshotStatuses = client().admin()  
        assertThat(snapshotInfos.size(), equalTo(1));
        createIndex(index1, index2, index3);
        updateSettingsRequest.persistentSettings(Settings.builder().put(MAX_SHARDS_ALLOWED_IN_STATUS_API.getKey(), 5));
            .setSnapshots(snapshotsToGet.toArray(Strings.EMPTY_ARRAY))
        createRepository(
        try {
            SnapshotMissingException.class,
            CircuitBreakingException exception = expectThrows(  
package org.opensearch.snapshots;
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStats;
        String snapshot1 = "test-snap-1";  
 * ownership. Elasticsearch licenses this file to you under  
            .get();  
            .setWaitForCompletion(true)
            // failure due to passing index filter for multiple snapshots  
            index(index3, "_doc", Integer.toString(i), "foo", "baz" + i);  
                .cluster()
            assertThat(snapshotShardStateOne.getStage(), is(SnapshotIndexShardStage.DONE));  
                .put("location", randomRepoPath())  
    }
        unblockNode(repositoryName, blockedNode);
        ensureGreen();
        logger.info("Create repository");  
import org.opensearch.cluster.SnapshotsInProgress;
                .prepareSnapshotStatus(repositoryName)
import org.opensearch.index.IndexNotFoundException;
        final SnapshotInfo snapshotInfo = createFullSnapshot("test-repo", "test-snap");
        // shard limit exceeded due to passing for inProgress but failing for current + completed
            .setIgnoreUnavailable(true)
        final SnapshotInfo snapshotInfo = assertSuccessful(
        assertBusy(() -> {  
        logger.info("--> snapshot");  
        });
        logger.info("Indexing some data");
        getSnapshotsResponse = client.admin().cluster().prepareGetSnapshots(repositoryName).addSnapshots(snapshotNames).get();
                exception.getMessage().contains(" is more than the maximum allowed value of shard count [1] for snapshot status request")
        String index2 = "test-idx-2";  
        createSnapshot(repositoryName, snapshot1, List.of(index1, index2, index3));
                .get(0);
            index(index1, "_doc", Integer.toString(i), "foo", "bar" + i);  
        getSnapshotsResponse = client.admin()
            assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));  
        );
        logger.info("--> get all snapshots with a current in-progress");
            );
            // failure due to index not found in snapshot  
        refresh();
                CircuitBreakingException.class,
        // across a single snapshot  
/*  
        logger.info("--> wait for snapshot to finish");  
            Map<String, SnapshotIndexStatus> snapshotIndexStatusMap = snapshotsStatus.getIndices();  
            SnapshotStatus snapshotsStatus = client().admin()
            CircuitBreakingException exception = expectThrows(
        final SnapshotStatus snapshotStatus = getSnapshotStatus("test-repo", "test-snap");
    }
        assertEquals(1, snapshotsStatusResponse.getSnapshots().size());
                .execute()
                    .execute()  
        getSnapshotsResponse = client.admin()
        refresh();  
        IOUtils.rm(repoPath.resolve(BlobStoreRepository.SNAPSHOT_PREFIX + snapshotInfo.snapshotId().getUUID() + ".dat"));  
    private static SnapshotIndexShardStatus stateFirstShard(SnapshotStatus snapshotStatus, String indexName) {  
                    .prepareSnapshotStatus(repositoryName)
        );  
        final String snapshot = "test-snap-1";
                    .actionGet()  
        internalCluster().restartNode(dataNodeTwo);
        createSnapshot(repositoryName, snapshot1, List.of(index1, index2, index3));
 */
            .setWaitForCompletion(true)  
        }
    private static SnapshotStatus getSnapshotStatus(String repoName, String snapshotName) {
                    .setIndices(index1, index2, index3)
        createRepository("test-repo", "fs", repoPath);  
 * You may obtain a copy of the License at  
     *
            IndexNotFoundException ex = expectThrows(  
                .setIndices(indexName)
            Exception ex = expectThrows(  
 * KIND, either express or implied.  See the License for the
        String index3 = "test-idx-3";
            CircuitBreakingException exception = expectThrows(
            CircuitBreakingException exception = expectThrows(
        assertBusy(() -> {
        createRepository(repositoryName, "fs");  
                    .setIndices(index1, index2)
        logger.info("Set MAX_SHARDS_ALLOWED_IN_STATUS_API to a slightly higher value");  
        createRepository("test-repo", "fs", repoPath);
        );  
                CircuitBreakingException.class,
        disableRepoConsistencyCheck("This test intentionally corrupts the repository");
                    .execute()
                .get()  
        assertThat(snapshotShardStateAfterNodeRestart.getStage(), is(SnapshotIndexShardStage.DONE));
        }
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotIndexStatus;  
        assertThat(snapshotShardStateAfterNodeRestart.getStats().getTotalFileCount(), equalTo(totalFiles));
        logger.info("--> creating an index and indexing documents");
