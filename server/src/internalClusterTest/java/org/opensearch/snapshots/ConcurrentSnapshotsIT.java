            }
        waitUntil(
        final String snapshotOne = snapshots.get(0);
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
        createRepository(repoName, "mock", settings);
        assertAcked(allDeletedResponse.get());
        createRepository(repoName, "mock");  
import java.nio.file.Path;  
        final String repoName = "test-repo";  
import org.opensearch.test.disruption.NetworkDisruption;
        awaitNoMoreRunningOperations();
        final String firstSnapshot = "snapshot-one";
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, snapshotName);  
    }
        }, 30L, TimeUnit.SECONDS);
        final String otherBlockedRepoName = "test-repo-blocked-2";
        assertThat(client().prepareSearch(testIndex).setSize(0).get().getHits().getTotalHits().value(), equalTo(100L));
            repoName,
        final String repoName = "test-repo";
        createRepository(otherRepoName, "fs");
        // Create a repository with random settings  
                assertAcked(deleteFuture.actionGet());  
            repoName,
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, snapshotName);  
        // Verify that the update fails with an appropriate exception
        logger.info("--> make sure all failing requests get a response");
                assertThat(rex.getMessage(), endsWith("Failed to update cluster state during repository operation"));
        createRepository(repoName, "mock");  
            .setSnapshots(GetSnapshotsRequest.CURRENT_SNAPSHOT)
        final ActionFuture<CreateSnapshotResponse> createSnapshot2Future = startFullSnapshot(repoName, snapshotTwo);  
    private List<String> createNSnapshots(String repoName, int count) {
    }
        return internalCluster().clusterManagerClient()
        assertAcked(startDeleteSnapshot(otherRepoName, "*").get());
        assertEquals(RestStatus.OK, snapshotInfo.status()); // Ensure the snapshot status is OK
            .execute();
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
            deleteFutures.add(future);  
                    .state(),
        assertSuccessful(createSlowFuture2);
        assertBusy(() -> assertThat(currentSnapshots(repoName), hasSize(3)), 30L, TimeUnit.SECONDS);
        SnapshotInfo snapshotInfo = createFullSnapshot(repoName, snapshotName);  
        logger.info("--> verifying repository state");
        final ActionFuture<CreateSnapshotResponse> createThirdSnapshot = client(clusterManagerNode).admin()
        );
            blockedRepoName,
            createBlockedSnapshot.actionGet();  
            assertThat(snapshotDeletionsInProgress.getEntries(), empty());
        final ActionFuture<AcknowledgedResponse> firstDeleteFuture = startAndBlockOnDeleteSnapshot(repoName, "*");
import org.opensearch.core.action.ActionListener;  
        assertSuccessful(createSlowFuture1);  
 * You may obtain a copy of the License at  
        final ActionFuture<CreateSnapshotResponse> firstSnapshotResponse = startFullSnapshotBlockedOnDataNode(  
        assertThat(secondDeleteFuture.get().isAcknowledged(), is(true));
        final ActionFuture<AcknowledgedResponse> failedDeleteFuture = client(clusterManagerNode).admin()  
        logger.info("--> created {} in [{}]", snapshotNames, repoName);
        logger.info("--> wait for snapshot on second data node to finish");  
            assertAcked(deleteResponse.get());
        corruptIndexN(repoPath, generation);  
        createIndexWithContent("index");  
        awaitNumberOfSnapshotsInProgress(1);
        assertAcked(startDeleteSnapshot(otherRepoName, "*").get());
        final long generation = getRepositoryData(repoName).getGenId();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                continue;
        internalCluster().startClusterManagerOnlyNode();
        assertAcked(prepareCreate(testIndex, 2, indexSettingsNoReplicas(between(2, 10))));
            return snapshotsInProgress.entries().size() == 2 && snapshotHasCompletedShard(secondSnapshot, snapshotsInProgress);  
        disableRepoConsistencyCheck("This test corrupts the repository on purpose");
        logger.info("--> waiting for concurrent snapshot(s) to finish");  
            assertFalse(deleteResponse.isDone());
            final SnapshotsInProgress snapshotsInProgress = state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
    public void testDeletesAreBatched() throws Exception {
                .build()
        final ActionFuture<CreateSnapshotResponse> createSlowFuture = startFullSnapshotBlockedOnDataNode(
            .execute();
        assertFileExists(indexNBlob);
    public void testAssertMultipleSnapshotsAndPrimaryFailOver() throws Exception {
        final String otherRepoName = "test-repo";  
 *
        internalCluster().startDataOnlyNodes(2);
        }
        final List<ActionFuture<AcknowledgedResponse>> deleteResponses = new ArrayList<>(deletes);
            .prepareCreateSnapshot(otherRepoName, "snapshot")
    public void testSettingsUpdateFailWhenCreateSnapshotInProgress() throws Exception {
        expectThrows(OpenSearchException.class, snapshotThree::actionGet);  
        internalCluster().startClusterManagerOnlyNode();  
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode();
        blockNodeOnAnyFiles(blockedRepoName, clusterManagerNode);
        waitUntilInprogress(repoName, secondSnapshot, TimeValue.timeValueSeconds(5L));
            final String snapshot = "snap-" + i;
    }
        });
            .setWaitForCompletion(false)
            final SnapshotDeletionsInProgress deletionsInProgress = state.custom(SnapshotDeletionsInProgress.TYPE);
        expectThrows(SnapshotException.class, firstFailedSnapshotFuture::actionGet);  
    }
        blockNodeOnAnyFiles(repoName, clusterManagerName);
        createIndexWithContent("index-one");  
        client().admin().cluster().prepareCreateSnapshot(repoName, "snapshot-three").setWaitForCompletion(false).get();  
        // left for the second repository's concurrent operations.
            blockedRepoName,  
        final ActionFuture<CreateSnapshotResponse> createSlowFuture3 = startFullSnapshotBlockedOnDataNode(  
            indexSettingsNoReplicas(1).put("index.routing.allocation.include._name", nodeInclude)  
        createRepository(blockedRepoName, "mock");
import org.opensearch.common.unit.TimeValue;
package org.opensearch.snapshots;
import static org.hamcrest.Matchers.greaterThan;
    }
        }
        final String dataNode = internalCluster().startDataOnlyNode();
        assertThat(snapshotFour.get().getSnapshotInfo().state(), is(SnapshotState.PARTIAL));
        createNSnapshots(repoName, randomIntBetween(2, 5));  
        createFullSnapshot(blockedRepoName, "blocked-snapshot");
        createRepository(repoName, "mock");  
        final SnapshotInfo thirdSnapshotInfo = assertSuccessful(thirdSnapshotResponse);
        // We're blocking a some of the snapshot threads when we block the first repo below so we have to make sure we have enough threads
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
        final String repoName = "test-repo";
        assertAcked(
    private void awaitNDeletionsInProgress(int count) throws Exception {
        );
        logger.info("--> waiting for second snapshot to finish and the other two snapshots to become aborted");
        unblockNode(repoName, dataNode);
        final String blockedRepoName = "test-repo-blocked-1";
        final String repoName = "test-repo";
            } else {
        awaitNumberOfSnapshotsInProgress(2);
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);
import static org.hamcrest.Matchers.not;
        internalCluster().startDataOnlyNode();
        snapOneResponse.get();  
 * not use this file except in compliance with the License.
        return false;
        assertBusy(() -> {
        }  
        final long repoGenAfterInitialSnapshots = getRepositoryData(repoName).getGenId();
        final String dataNode = startDataNodeWithLargeSnapshotPool();  
        return internalCluster().startDataOnlyNode(LARGE_SNAPSHOT_POOL_SETTINGS);
    }
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));  
            .cluster()
        final ActionFuture<CreateSnapshotResponse> snapshotThree = startFullSnapshotFromNonClusterManagerClient(repoName, "snapshot-three");
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(otherRepoName);
        );  
import org.opensearch.plugins.Plugin;
        assertSuccessful(snapshotFour);
    }
        waitForBlock(clusterManagerNode, blockedRepoName, TimeValue.timeValueSeconds(30L));
        );
 * The OpenSearch Contributors require contributions made to  
        internalCluster().startDataOnlyNode();
        ensureStableCluster(3);
    }
        awaitNumberOfSnapshotsInProgress(1);
        final String repoName = "test-repo";  
        startDeleteSnapshot(repoName, "*");  
            .cluster()
            secondSnapshot  
            repoName,
            deleteSnapshotOne.actionGet();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
    private void corruptIndexN(Path repoPath, long generation) throws IOException {
        final int deletes = randomIntBetween(2, 10);  
        final String repoName = "test-repo";
            indexName,
import static org.hamcrest.Matchers.is;  
        assertThat(  
        awaitNDeletionsInProgress(1);
    public void testBlockedRepoDoesNotBlockOtherRepos() throws Exception {
 * software distributed under the License is distributed on an
        allowNodes(testIndex, 1);
        final String dataNode = internalCluster().startDataOnlyNode();
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;  
    protected Settings nodeSettings(int nodeOrdinal) {  
        // Attempt to update the repository settings while the snapshot is in progress
                    if (shard.state().completed()) {
        final String snapshotName = "snap-1";
        networkDisruption.stopDisrupting();
                .entries()) {
        assertAcked(deleteFuture.get());  
        assertAcked(startDeleteSnapshot(repoName, snapshotTwo).get());
            assertThat(currentSnapshots(repoName), hasSize(2));
        awaitNDeletionsInProgress(2);  
        logger.info("--> creating full snapshot [{}] to repo [{}] from cluster-manager client", snapshotName, repoName);  
        createIndexWithContent("index-test");
            .execute();
        // Start a cluster with a cluster manager node and a data node
        final ActionFuture<AcknowledgedResponse> deleteSnapshotsResponse = startDeleteSnapshot(repoName, firstSnapshot);  
                blockedDelete = true;
        internalCluster().startClusterManagerOnlyNode();
        );  
            .cluster()  
        );
        awaitNDeletionsInProgress(1);
        ensureStableCluster(3, dataNode);
        assertSuccessful(createSlowFuture3);
        final ActionFuture<CreateSnapshotResponse> createSlowFuture1 = startFullSnapshotBlockedOnDataNode(
        internalCluster().setDisruptionScheme(networkDisruption);
        unblockNode(repoName, clusterManagerName); // Unblock the delete operation
        unblockNode(repoName, clusterManagerNode);  
    }
            }
            }
        createRepository(repoName, "mock");  
        logger.info("--> wait for [{}] deletions to show up in the cluster state", count);  
        internalCluster().stopCurrentClusterManagerNode();
        awaitNumberOfSnapshotsInProgress(2);
    }
        final String dataNode = internalCluster().startDataOnlyNode();  
            1L,
        // We're blocking a some of the snapshot threads when we block the first repo below so we have to make sure we have enough threads
        );  
        }
                .setPersistentSettings(  
        unblockNode(blockedRepoName, dataNode);
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));
        awaitNumberOfSnapshotsInProgress(3);
        final String repoName = "test-repo";  
                assertThat(entry.snapshot().getSnapshotId().getName(), not(secondSnapshot));  
        internalCluster().startDataOnlyNode();
            .prepareCreateSnapshot(repoName, snapshotTwo)
        createIndex("foo");  
            .execute();
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, "snapshot-queued");  
        final String snapshotOne = "snap-1";  
                // when shutting down the initial cluster-manager and fails the transport listener  
        awaitNoMoreRunningOperations();  
        final String firstIndex = "index-one";
        final SnapshotException snapshotException = expectThrows(SnapshotException.class, snapshotFuture::actionGet);  
        expectThrows(OpenSearchException.class, snapshotFour::actionGet);  
import org.opensearch.test.InternalTestCluster;
        startAndBlockOnDeleteSnapshot(repoName, "*");
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);
            repoName,  
        }  
                    .getFirst()
        final String dataNode = internalCluster().startDataOnlyNode();
            dataNode
        internalCluster().stopCurrentClusterManagerNode();
        awaitNoMoreRunningOperations();  
 */  
        networkDisruption.startDisrupting();
        final Collection<CreateSnapshotResponse> snapshotResponses = allSnapshotsDone.get();
        awaitClusterManagerFinishRepoOperations();  
        assertThat(snapshotThree.get().getSnapshotInfo().state(), is(SnapshotState.PARTIAL));
        expectThrows(OpenSearchException.class, snapshotThree::actionGet);  
                .custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY)  
        final String repoName = "test-repo";
    private ActionFuture<CreateSnapshotResponse> startFullSnapshotFromClusterManagerClient(String repoName, String snapshotName) {
        assertThat(secondSnapshotResponse.isDone(), is(false));
                .put("index.routing.allocation.exclude._name", nodeExclude)
            dataNode
        awaitNDeletionsInProgress(1);  
    }
                    .prepareGetSnapshots(repoName)  
        createRepository(repoName, "mock");
import java.nio.file.StandardOpenOption;
        logger.info("--> start two snapshots");
    }
        final SnapshotInfo slowSnapshotInfo = assertSuccessful(createSlowFuture);  
            // when the request is retried and gets executed after the above delete  
import org.opensearch.test.OpenSearchIntegTestCase;  
        internalCluster().startClusterManagerOnlyNodes(3, LARGE_SNAPSHOT_POOL_SETTINGS);
        final String initialClusterManager = internalCluster().getClusterManagerName();  
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));
        final List<ActionFuture<CreateSnapshotResponse>> snapshotFutures = new ArrayList<>();
        awaitClusterState(state -> {  
        if (deleteFuture != null) {
                .cluster()  
        client().admin().cluster().prepareCreateSnapshot(repoName, "snapshot-blocked-1").setWaitForCompletion(false).get();  
        createIndexWithContent(secondIndex, dataNode2, dataNode);  
            .execute();
    @Override
 * SPDX-License-Identifier: Apache-2.0
        unblockNode(repoName, clusterManagerName);  
        for (ActionFuture<AcknowledgedResponse> deleteResponse : deleteResponses) {
 * Licensed to Elasticsearch under one or more contributor  
import static org.hamcrest.Matchers.containsInAnyOrder;  
        final ActionFuture<CreateSnapshotResponse> secondSnapshotResponse = startFullSnapshot(repoName, secondSnapshot);
        awaitNoMoreRunningOperations();
            );
    public void testStartWithSuccessfulShardSnapshotPendingFinalization() throws Exception {
            .setWaitForCompletion(true)
        client().admin().cluster().prepareCreateSnapshot(otherRepoName, "snapshot-other-blocked-1").setWaitForCompletion(false).get();
        );
                .cluster()
    public void testClusterManagerFailoverOnFinalizationLoop() throws Exception {
        final String firstSnapshot = "snapshot-one";
        final ActionFuture<CreateSnapshotResponse> snapshotFour = startFullSnapshotFromNonClusterManagerClient(repoName, "snapshot-four");
            () -> assertThat(
            final StepListener<AcknowledgedResponse> future = new StepListener<>();
    }
        final String repoName = "test-repo";  
        assertSnapshotStatusCountOnRepo(otherBlockedRepoName, 1);  
import org.opensearch.test.transport.MockTransportService;
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));  
        final SnapshotException sne = expectThrows(SnapshotException.class, snapshotFuture::actionGet);  
        );
        assertThat(repoGenAfterInitialSnapshots, is(numSnapshots - 1L));  
        for (StepListener<AcknowledgedResponse> deleteFuture : deleteFutures) {
        );  
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);  
        assertThat(snapshotException.getMessage(), containsString(SnapshotsInProgress.ABORTED_FAILURE_TEXT));
        assertFalse(createSlowFuture.isDone()); // Ensure the snapshot is still in progress  
        final String dataNode = internalCluster().startDataOnlyNode();
            .cluster()
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();  
        final ActionFuture<CreateSnapshotResponse> snapshotThree = startFullSnapshotFromNonClusterManagerClient(repoName, "snapshot-three");
import org.opensearch.discovery.AbstractDisruptionTestCase;
        internalCluster().startDataOnlyNode();  
        );
        createRepository(repoName, "mock", repoPath);
            "snapshot-one"
        assertAcked(deleteSnapshotOne.get());
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, "second-snapshot");  
            assertThat(snapshotsInProgress.entries(), empty());
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state()); // Ensure the snapshot was successful
    public void testMultipleSnapshotsQueuedAfterDelete() throws Exception {
        final String repoName = "test-repo";  
        ensureStableCluster(4);
            .execute();
            repoName,
        unblockNode(repoName, clusterManagerName);  
    public void testSettingsUpdateFailWhenDeleteSnapshotInProgress() throws Exception {
            blockedRepoName,
            createFullSnapshot(repoName, name);
            index(testIndex, "_doc", Integer.toString(i), "foo", "bar" + i);
    private static String startDataNodeWithLargeSnapshotPool() {
        final ActionFuture<AcknowledgedResponse> slowDeleteFuture = startDeleteSnapshot(blockedRepoName, "*");
                    .addSnapshots("slow-snapshot")
        }
        ActionFuture<AcknowledgedResponse> firstDeleteFuture = client(clusterManagerNode).admin()
        final String secondSnapshot = "snapshot-two";  
        final SnapshotException sne = expectThrows(SnapshotException.class, createSnapshot2Future::actionGet);
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(blockedRepoName);
        final ActionFuture<CreateSnapshotResponse> secondSnapshotResponse = startFullSnapshot(repoName, secondSnapshot);  
        createIndexWithContent("test-idx");
        // Start a full snapshot and block it on the data node
        disableRepoConsistencyCheck("This test corrupts the repository on purpose");
import org.opensearch.core.common.Strings;
        unblockNode(repoName, clusterManagerName);  
    public void testQueuedOperationsOnClusterManagerRestart() throws Exception {  
        logger.info("--> waiting for concurrent snapshot(s) to finish");  
        assertThat(repositoryData.getSnapshotIds(), empty());
            dataNode
        return snapshotNames;
        awaitNumberOfSnapshotsInProgress(2);
        assertThat(secondSnapshotResponse.get().getSnapshotInfo().state(), is(SnapshotState.FAILED));  
            .execute();  
            dataNode  
        // Attempt to update the repository settings while the delete operation is in progress
        createRepository(repoName, "fs");
        unblockNode(repoName, clusterManagerNode);
import static org.hamcrest.Matchers.empty;
            if (toDelete.isEmpty()) {  
        awaitNDeletionsInProgress(1);
        logger.info("--> wait for snapshot on second data node to finish");
 * under the License.  
        assertSnapshotStatusCountOnRepo("_all", 3);
        ActionFuture<AcknowledgedResponse> deleteFuture = null;
        assertThat(secondSnapshotResponse.isDone(), is(false));
        awaitClusterState(state -> {
    private static List<SnapshotInfo> currentSnapshots(String repoName) {  
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
        assertThat(secondSnapshotResponse.isDone(), is(false));  
        expectThrows(SnapshotException.class, snapshotThreeFuture::actionGet);
        createIndex("foo");
        final long generation = getRepositoryData(repoName).getGenId();  
        final String otherRepoName = "other-test-repo";
            return snapshotsInProgress.entries().size() == 2 && snapshotHasCompletedShard(secondSnapshot, snapshotsInProgress);
        final String dataNode = internalCluster().startDataOnlyNode();  
        createIndexWithContent("index-test");
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
import static org.hamcrest.Matchers.contains;
            dataNode
        final Collection<StepListener<AcknowledgedResponse>> deleteFutures = new ArrayList<>();  
        assertSuccessful(createSlowFuture1);
                )
                snapshotFutures.add(startFullSnapshot(repoName, "snap-" + i));
        final String repoName = "test-repo";
        createIndexWithContent("test-index");  
import java.util.ArrayList;
                ++blockedSnapshots;  
            }
            .get();
        createRepository(repoName, "mock");
        for (String snapshot : Arrays.asList(snapshotOne, snapshotTwo)) {  
            client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots(),
            "blocked-snapshot-2",
        logger.info("--> waiting for all three snapshots to show up as in-progress");
        return fut;  
        unblockNode(repoName, clusterManagerNode);
        unblockNode(blockedRepoName, dataNode);
        final List<String> snapshots = createNSnapshots(repoName, 2);
        assertAcked(slowDeleteFuture.actionGet());
        final String repoName = "test-repo";  
        blockNodeOnAnyFiles(repoName, dataNode2);  
        ensureStableCluster(3, dataNode);
        });  
            assertThat(client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots(), empty());
        final String repoName = "test-repo";  
    public void testQueuedSnapshotOperationsAndBrokenRepoOnClusterManagerFailOver2() throws Exception {
        assertAcked(deleteSnapshotTwo.get());
        final ActionFuture<CreateSnapshotResponse> createSlowFuture3 = startFullSnapshotBlockedOnDataNode(
        createIndexWithContent("index-one");
        assertThat(client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots(), empty());
        assertBusy(() -> assertThat(currentSnapshots(otherRepoName), empty()), 30L, TimeUnit.SECONDS);
        createNSnapshots(repoName, randomIntBetween(2, 5));
        // Start a cluster with a cluster manager node and a data node
        blockNodeOnAnyFiles(repoName, clusterManagerNode);
        final ActionFuture<CreateSnapshotResponse> secondFailedSnapshotFuture = startFullSnapshotFromClusterManagerClient(  
            blockedRepoName,
        assertSuccessful(snapshotFuture);
        final Path repoPath = randomRepoPath();
        awaitNDeletionsInProgress(1);  
            } catch (SnapshotMissingException sme) {  
        createIndexWithContent("index-one");
import org.opensearch.cluster.SnapshotDeletionsInProgress;
 * compatible open source license.
        final String dataNode = internalCluster().startDataOnlyNode();  
        internalCluster().startDataOnlyNode();
            assertThat(snapshotInfo.shardFailures().size(), equalTo(0));  
                // that the client on the data-node sees a disconnect exception after the cluster-manager has already started the delete,
            .cluster()  
        final List<String> snapshotNames = createNSnapshots(repoName, randomIntBetween(2, 5));
    }  
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();  
        blockNodeOnAnyFiles(repoName, clusterManagerName);
            repoName,
        internalCluster().startClusterManagerOnlyNodes(3);  
        internalCluster().startDataOnlyNode();  
        createIndexWithContent("index-slow");
        internalCluster().startClusterManagerOnlyNodes(3);
                greaterThan(0)
        final ActionFuture<CreateSnapshotResponse> snapshotThree = startFullSnapshot(repoName, "snapshot-three", true);  
        unblockNode(blockedRepoName, clusterManagerNode);
            }
        return Arrays.asList(MockTransportService.TestPlugin.class, MockRepository.Plugin.class);
        assertBusy(
        final String clusterManagerNode = internalCluster().getClusterManagerName();
        final Path repoPath = randomRepoPath();  
        assertThat(firstSnapshotResponse.get().getSnapshotInfo().state(), is(SnapshotState.FAILED));
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(LARGE_SNAPSHOT_POOL_SETTINGS);  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;  
        createRepository(blockedRepoName, "mock");
            final SnapshotsInProgress snapshotsInProgress = clusterService().state().custom(SnapshotsInProgress.TYPE);
        final String dataNode = internalCluster().startDataOnlyNode();
        logger.info("--> verify all snapshots were aborted");
        internalCluster().startClusterManagerOnlyNode();
        logger.info("--> waiting for batched deletes to finish");
    }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        assertThat(ex.getRootCause(), instanceOf(IOException.class));
        // make sure second snapshot is in progress before restarting data node  
        final String dataNode2 = internalCluster().startDataOnlyNode();
            .setWaitForCompletion(true)
        ensureGreen(testIndex);
            dataNode
            assertThat(snapshotResponse.getSnapshotInfo().state(), is(SnapshotState.SUCCESS));
        final String otherRepoName = "test-repo";
            .prepareDeleteSnapshot(repoName, "*")
 * the Apache License, Version 2.0 (the "License"); you may
        final ActionFuture<AcknowledgedResponse> secondDeleteFuture = startDeleteSnapshot(repoName, "*");  
import org.opensearch.cluster.SnapshotsInProgress;  
        awaitNumberOfSnapshotsInProgress(3);
            dataNode  
        final String repoName = "test-repo";
        createRepository(repoName, "mock", repoPath);
        final String repoName = "test-repo";  
        assertSuccessful(createSnapshot1Future);  
    }
        assertSnapshotStatusCountOnRepo(blockedRepoName, 0);
        assertSuccessful(snapshotFuture);  
        client().admin()  
        assertThat(secondSnapshotResponse.get().getSnapshotInfo().state(), is(SnapshotState.PARTIAL));  
        createRepository(blockedRepoName, "mock");  
            repoName,
        assertSuccessful(
        index(testIndex, "_doc", "some_id", "foo", "bar");
            "slow-snapshot",  
                assertThat(entry.state(), is(SnapshotsInProgress.State.ABORTED));
 *    http://www.apache.org/licenses/LICENSE-2.0
        final ActionFuture<AcknowledgedResponse> allDeletedResponse = startDeleteSnapshot(repoName, "*");
    public void testMultipleReposAreIndependent() throws Exception {
        createRepository(repoName, "mock");
        // Create a full snapshot
    public void testStartDeleteDuringFinalizationCleanup() throws Exception {  
        final String repoName = "test-repo";
        final ActionFuture<AcknowledgedResponse> deleteSnapshotTwo = startDeleteSnapshot(repoName, snapshotTwo);  
        createIndexWithContent(firstIndex);  
            assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        assertSuccessful(createSlowFuture);
        assertSuccessful(otherSnapshot);
        final RepositoryData repositoryDataAfterDeletes = getRepositoryData(repoName);
 *  
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> updateRepository(repoName, "mock", settings));  
        assertSuccessful(createSlowFuture3);
        final String testIndex = "index-one";
            dataNode
        assertThat(firstSnapshotResponse.get().getSnapshotInfo().state(), is(SnapshotState.PARTIAL));
        createIndexWithContent("test-index");
        }  
        for (CreateSnapshotResponse snapshotResponse : snapshotResponses) {  
        assertThat(firstSnapshotInfo.state(), is(SnapshotState.FAILED));  
            .setIndices(testIndex)  
        ensureGreen();
import static org.hamcrest.Matchers.instanceOf;
            .setWaitForCompletion(true)
        }  
            firstSnapshot,
        awaitClusterState(state -> {  
        internalCluster().restartNode(dataNode, InternalTestCluster.EMPTY_CALLBACK);  
        final long generation = getRepositoryData(repoName).getGenId();  
            try {
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(AbstractDisruptionTestCase.DEFAULT_SETTINGS).build();
            state -> state.custom(SnapshotDeletionsInProgress.TYPE, SnapshotDeletionsInProgress.EMPTY).getEntries().size() == count
        createIndexWithContent("index-test");
        internalCluster().startClusterManagerOnlyNodes(3);  
        final String blockedRepoName = "test-repo-blocked";  
 * specific language governing permissions and limitations
    private ActionFuture<AcknowledgedResponse> startAndBlockOnDeleteSnapshot(String repoName, String snapshotName)  
        final ActionFuture<AcknowledgedResponse> deleteFuture = startDeleteSnapshot(repoName, snapshotName);
        createIndexWithContent(secondIndex, dataNode2, dataNode);
        unblockNode(repoName, clusterManagerNode);  
    }
        unblockNode(repoName, dataNode); // Unblock the snapshot  
        internalCluster().stopCurrentClusterManagerNode();  
        networkDisruption.stopDisrupting();  
        internalCluster().startClusterManagerOnlyNodes(3);
        logger.info("--> stopping current cluster-manager node");
        createRepository(repoName, "mock");  
        awaitNoMoreRunningOperations();
    }
        awaitNDeletionsInProgress(2);
import java.util.concurrent.TimeUnit;
        internalCluster().startDataOnlyNode();
        final int numSnapshots = randomIntBetween(1, 4);
        networkDisruption.startDisrupting();
        expectThrows(RepositoryException.class, deleteFuture::actionGet);  
import org.opensearch.cluster.ClusterState;
        assertAcked(deleteFuture.get());
            "blocked-snapshot",
        } catch (OpenSearchException ex) {
    }  
    }
        ensureStableCluster(3);  
        assertSuccessful(createSlowFuture); // Ensure the snapshot completes successfully
        createIndexWithContent("test-index");
        internalCluster().startClusterManagerOnlyNode();
        final ActionFuture<CreateSnapshotResponse> snapshotThree = startFullSnapshot(repoName, "snapshot-three");
        final String snapshotName = "snap-name";
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus;
        internalCluster().startClusterManagerOnlyNode();
        final PlainActionFuture<Collection<CreateSnapshotResponse>> allSnapshotsDone = PlainActionFuture.newFuture();  
        final String testIndex = "test-idx";  
    }
    }  
        unblockNode(repoName, clusterManagerName);
        final ActionFuture<CreateSnapshotResponse> createSlowFuture = startFullSnapshotBlockedOnDataNode(
                // leading to the delete retry to run into a situation where the snapshot has already been deleted potentially  
        createNSnapshots(otherRepoName, randomIntBetween(1, 5));
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
            .prepareCreateSnapshot(repoName, snapshotName)  
        unblockNode(blockedRepoName, dataNode);  
        final String blockedRepoName = "repo-blocked";
        final List<SnapshotStatus> snapshotStatuses = snapshotsStatusResponse.getSnapshots();
        unblockNode(repoName, clusterManagerNode);
            containsInAnyOrder(secondSnapshotInfo, thirdSnapshotInfo)
            "other-blocked-snapshot",  
        awaitNumberOfSnapshotsInProgress(1);
        final String secondIndex = "index-two";  
        for (int i = 0; i < count; i++) {
            TimeUnit.MINUTES
        unblockNode(repoName, clusterManagerName);
        assertEquals("trying to modify or unregister repository that is currently used", ex.getMessage());
        createNSnapshots(repoName, randomIntBetween(2, 5));  
        createIndexWithContent("index-test");  
        final String dataNode = internalCluster().startDataOnlyNode();
        logger.info("--> start relocations");
        final String dataNode = internalCluster().startDataOnlyNode();
            final ConcurrentSnapshotExecutionException csen2 = expectThrows(
                assertThat(rex.repository(), is("_all"));
            final SnapshotsInProgress snapshotsInProgress = state.custom(SnapshotsInProgress.TYPE);
        for (ActionFuture<AcknowledgedResponse> deleteFuture : Arrays.asList(firstDeleteFuture, deleteAllSnapshots)) {
        internalCluster().startDataOnlyNode();
 * GitHub history for details.
    }  
        blockClusterManagerFromDeletingIndexNFile(repoName);
        snapTwoResponse.get();
        final String repoName = "test-repo";  
        awaitNDeletionsInProgress(1);
        Path indexNBlob = repoPath.resolve(BlobStoreRepository.INDEX_FILE_PREFIX + generation);  
        disableRepoConsistencyCheck("This test corrupts the repository on purpose");
        Settings.Builder newSettings = randomRepositorySettings();
        );  
            () -> client().admin().cluster().prepareCreateSnapshot(repoName, "expected-to-fail").execute().actionGet()
        final String clusterManagerName = internalCluster().getClusterManagerName();  
        unblockNode(repoName, clusterManagerName);  
        );  
        createNSnapshots(repoName, randomIntBetween(1, 5));  
import org.opensearch.common.action.ActionFuture;
        internalCluster().startDataOnlyNode();
        final String repoName = "test-repo";
    private ActionFuture<CreateSnapshotResponse> startFullSnapshotFromNonClusterManagerClient(String repoName, String snapshotName) {
        awaitNDeletionsInProgress(1);
            "other-blocked-snapshot",
        Settings.Builder settings = randomRepositorySettings();
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        createRepository(repoName, "mock", settings);
        logger.info("--> start third snapshot");
        createIndexWithContent("index-two");
            client().admin().cluster().prepareDeleteSnapshot(repoName, toDelete.toArray(Strings.EMPTY_ARRAY)).execute(future);
        // left for the second concurrent snapshot.
    }  
        final String secondSnapshot = "snapshot-two";
        for (ActionFuture<CreateSnapshotResponse> snapshotFuture : snapshotFutures) {
        awaitNoMoreRunningOperations();  
        assertFalse(future.isDone()); // Ensure the delete operation is still in progress  
        );  
    }
        int blockedSnapshots = 0;
            final String name = prefix + i;  
        logger.info("--> corrupting [index-{}] in [{}]", generation, repoPath);
        internalCluster().startClusterManagerOnlyNodes(3);
        ensureStableCluster(3);
    }
        final String indexFast = "index-fast";
            "blocked-snapshot-2",
            assertThat(csen2.getMessage(), containsString(expectedFailureMessage));  
        waitForBlock(dataNode2, repoName, TimeValue.timeValueSeconds(30L));
        ensureGreen();
        final SnapshotException snapshotException = expectThrows(SnapshotException.class, snapshotFuture::actionGet);  
                .execute()
        internalCluster().startClusterManagerOnlyNodes(3);  
            + "] operations and the current limit for concurrent snapshot operations is set to ["
            final SnapshotDeletionsInProgress snapshotDeletionsInProgress = state.custom(SnapshotDeletionsInProgress.TYPE);  
        createNSnapshots(otherRepoName, randomIntBetween(1, 5));
            .setIndices("does-not-exist-*")  
        awaitNDeletionsInProgress(1);
        createFullSnapshot(repoName, "first-snapshot");
        final ActionFuture<CreateSnapshotResponse> thirdSnapshotResponse = startFullSnapshot(repoName, "snapshot-three");  
        expectThrows(UncategorizedExecutionException.class, firstDeleteFuture::actionGet);
        final ActionFuture<AcknowledgedResponse> deleteFuture = startAndBlockOnDeleteSnapshot(repoName, "*");  
        );
        waitForBlock(internalCluster().getClusterManagerName(), blockedRepoName, TimeValue.timeValueSeconds(30L));
        assertSuccessful(createSlowFuture);
 * this work for additional information regarding copyright
            final Collection<String> toDelete = randomSubsetOf(snapshotNames);
        }
    public void testConcurrentOperationsLimit() throws Exception {  
            .prepareSnapshotStatus(otherBlockedRepoName)
            .prepareGetSnapshots(repoName)  
}
        try {
        // Second delete works out cleanly since the repo is unblocked now  
import org.opensearch.common.UUIDs;
            "blocked-snapshot",
        ensureGreen();  
        assertThat(client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots(), empty());  
        final String repoName = "test-repo";
        internalCluster().startClusterManagerOnlyNode();  
    }
        final PlainActionFuture<Collection<AcknowledgedResponse>> allDeletesDone = new PlainActionFuture<>();  
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);
        awaitNumberOfSnapshotsInProgress(2);
        newSettings.put("chunk_size", 2000, ByteSizeUnit.BYTES);  
 * license agreements. See the NOTICE file distributed with
        unblockNode(repoName, dataNode);
            final ClusterState state = clusterService().state();  
        createRepository(repoName, "mock", repoPath);  
        internalCluster().startClusterManagerOnlyNodes(3);
        final ActionFuture<AcknowledgedResponse> deleteAllSnapshots = startDeleteFromNonClusterManagerClient(repoName, "*");
    public void testLongRunningSnapshotAllowsConcurrentSnapshot() throws Exception {
        for (int i = 0; i < deletes; ++i) {
            client().admin()
        try {
public class ConcurrentSnapshotsIT extends AbstractSnapshotIntegTestCase {
import static org.hamcrest.Matchers.hasSize;
        internalCluster().setDisruptionScheme(networkDisruption);
        awaitNDeletionsInProgress(1);  
        final String repoName = "test-repo";
        final ActionFuture<CreateSnapshotResponse> blockedSnapshot = startFullSnapshot(repoName, "snap-blocked");
        createRepository(otherBlockedRepoName, "mock");
        final String dataNode = internalCluster().startDataOnlyNode();
                    .getSnapshots()  
        assertAcked(deleteFuture.get(30L, TimeUnit.SECONDS));  
        // left for the second concurrent snapshot.
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        final ActionFuture<CreateSnapshotResponse> snapshotFour = startFullSnapshot(repoName, "snapshot-four");
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));  
            .admin()
        createRepository(blockedRepoName, "mock");
        final ActionFuture<CreateSnapshotResponse> fut = startFullSnapshot(blockedRepoName, snapshotName);  
 * KIND, either express or implied.  See the License for the
            final SnapshotsInProgress snapshotsInProgress = state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
/*
        createIndexWithContent(indexFast, dataNode2, dataNode);
        ensureStableCluster(3);
import org.opensearch.repositories.RepositoryException;
        logger.info("--> wait for snapshot on second data node to finish");  
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);  
        assertAcked(deleteFuture.get());
            "blocked-snapshot",  
        final ActionFuture<AcknowledgedResponse> secondDeleteFuture = client(clusterManagerNode).admin()
        final String repoName = "test-repo";  
        logger.info("--> creating full snapshot [{}] to repo [{}] from non cluster-manager client", snapshotName, repoName);
        }
            dataNode  
import java.util.Collection;
        waitForBlock(initialClusterManager, repoName, TimeValue.timeValueSeconds(30L));
        );
    public void testQueuedSnapshotOperationsAndBrokenRepoOnClusterManagerFailOver() throws Exception {  
    public void testMultipleReposAreIndependent3() throws Exception {
            blockedRepoName,
import org.opensearch.action.support.GroupedActionListener;
        createRepository(repoName, "mock");
            .setIndices(testIndex)  
    public void testInterleavedAcrossMultipleRepos() throws Exception {
        internalCluster().startDataOnlyNode();
        }
        );
        startAndBlockOnDeleteSnapshot(repoName, "*");
    }  
        awaitNumberOfSnapshotsInProgress(1);  
 */
        ensureYellow(testIndex);
        createIndexWithContent("index-one");
        awaitNumberOfSnapshotsInProgress(2);
            .execute();
        );  
    public void testClusterManagerFailoverAndMultipleQueuedUpSnapshotsAcrossTwoRepos() throws Exception {
            repoName,
        assertAcked(deleteSnapshotOne.get());  
        final ActionFuture<AcknowledgedResponse> deleteFuture = startDeleteSnapshot(repoName, snapshotName);
        createNSnapshots(repoName, randomIntBetween(2, 5));
                    .cluster()
        internalCluster().startDataOnlyNode();
        awaitNDeletionsInProgress(1);
                // very rarely a cluster-manager node fail-over happens at such a time
        assertThat(firstDeleteFuture.get().isAcknowledged(), is(true));
        // Wait for the delete operation to start
            "first-snapshot",  
                .get()  
        settings.put("chunk_size", 2000, ByteSizeUnit.BYTES);
        logger.info("--> waiting for concurrent snapshot(s) to finish");  
        createRepository(repoName, "mock");
        );  
        final ActionFuture<CreateSnapshotResponse> createSlowFuture2 = startFullSnapshotBlockedOnDataNode(  
        unblockNode(repoName, dataNode);
        final String dataNode = startDataNodeWithLargeSnapshotPool();
        awaitNoMoreRunningOperations();
            + "]";
            "queued-snapshot"
        expectThrows(OpenSearchException.class, snapshotFour::actionGet);
        });
        createRepository(repoName, "mock");
            .setWaitForCompletion(false)
        createFullSnapshot(repoName, firstSnapshot);  
        final String repoName = "test-repo";  
        createRepository(repoName, "mock");
        final String snapshotName = "snapshot-1";
        createIndexWithContent("index-test");  
            .get();  
        final String dataNode2 = internalCluster().startDataOnlyNode();
        final String repoName = "test-repo";
        createNSnapshots(otherRepoName, countOtherRepo);
            } catch (RepositoryException rex) {
        final String clusterManagerNode = internalCluster().getClusterManagerName();  
        final int limitToTest = randomIntBetween(1, 3);
        allDeletesDone.get();
        // Create a repository with random settings  
        String clusterManagerName = internalCluster().startClusterManagerOnlyNode();  
        assertBusy(() -> {
        final String dataNode = startDataNodeWithLargeSnapshotPool();
import static org.hamcrest.Matchers.equalTo;
        assertSuccessful(createSlowFuture2);  
            firstSnapshot,  
        logger.info("--> make sure all failing requests get a response");
                    }  
        );
import static org.hamcrest.Matchers.containsString;
        logger.info("--> indexing some data");  
            return deletionsInProgress.getEntries().size() == 1 && deletionsInProgress.getEntries().get(0).getSnapshots().size() == 3;
import org.opensearch.OpenSearchException;  
        for (int i = 0; i < 100; i++) {
        final ActionFuture<CreateSnapshotResponse> otherSnapshot = startFullSnapshot(repoName, "other-snapshot");  
                .findAny()
    }
            + limitToTest
        final ActionFuture<CreateSnapshotResponse> thirdSnapshotResponse = client().admin()  
        // We're blocking a some of the snapshot threads when we block the first repo below so we have to make sure we have enough threads  
        assertThat(secondDeleteFuture.get().isAcknowledged(), is(true));
    }  
                hasItem(equalTo("cluster:admin/snapshot/delete"))  
        internalCluster().startDataOnlyNode();
        internalCluster().startDataOnlyNode();
    public void testMultiplePartialSnapshotsQueuedAfterDelete() throws Exception {
        assertThat(firstSnapshotResponse.isDone(), is(false));
        final String snapshotTwo = "second-snapshot";
        // Snapshot should have been aborted
        assertFalse(createSnapshot1Future.isDone());
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
        throws InterruptedException {  
            .cluster()  
                () -> client().admin().cluster().prepareDeleteSnapshot(repoName, "*").execute().actionGet()
        final String clusterManagerName = internalCluster().getClusterManagerName();  
        final NetworkDisruption networkDisruption = isolateClusterManagerDisruption(NetworkDisruption.DISCONNECT);  
        assertThat(getRepositoryData(repoName).getGenId(), is(0L));
        awaitClusterState(
                client().admin().cluster().prepareHealth(testIndex).execute().actionGet().getRelocatingShards(),
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> updateRepository(repoName, "mock", newSettings));
        refresh();
        internalCluster().startClusterManagerOnlyNode();
        internalCluster().startClusterManagerOnlyNode();  
    }
    public void testQueuedOperationsOnClusterManagerDisconnect() throws Exception {  
import org.opensearch.action.support.PlainActionFuture;
        // Poll for snapshot to actually start
            "blocked-snapshot",
        final NetworkDisruption networkDisruption = isolateClusterManagerDisruption(NetworkDisruption.DISCONNECT);  
    public void testQueuedDeleteAfterFinalizationFailure() throws Exception {  
        expectThrows(SnapshotException.class, createSlowFuture::actionGet);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFileExists;
    public void testAbortOneOfMultipleSnapshots() throws Exception {  
    }  
        final String secondIndex = "index-two";
        createNSnapshots(repoName, randomIntBetween(2, 5));  
        createIndexWithContent("index-two", dataNode2, dataNode);
        unblockNode(repoName, clusterManagerNode);
        final String dataNode = internalCluster().startDataOnlyNode();
        assertThat(createSlowFuture.isDone(), is(false));  
    }
                client().admin().cluster().listTasks(new ListTasksRequest()).get().getTasks().stream().map(TaskInfo::getAction).toList(),
 * Unless required by applicable law or agreed to in writing,
        blockNodeOnAnyFiles(repoName, clusterManagerNode);
        createIndexWithContent("index-one");
        createRepository(repoName, "mock");
        final String blockedRepoName = "test-repo-blocked";
                .prepareUpdateSettings()
        internalCluster().startDataOnlyNode();
        final String dataNode = internalCluster().startDataOnlyNode();
        final List<String> snapshotNames = createNSnapshots(repoName, limitToTest + 1);  
                    .get()
            )
        final String dataNode2 = internalCluster().startDataOnlyNode();  
            blockedRepoName,
import org.opensearch.repositories.RepositoryData;  
        unblockNode(repoName, dataNode);
        createNSnapshots(repoName, randomIntBetween(2, 5));  
                        return true;
        awaitNDeletionsInProgress(2);
    }  
        logger.info("--> verify that all snapshots are gone");
        networkDisruption.startDisrupting();
        ensureStableCluster(3);  
        logger.info("--> deleting snapshot [{}] from repo [{}] from non cluster-manager client", snapshotName, repoName);  
        Files.write(indexNBlob, randomByteArrayOfLength(1), StandardOpenOption.TRUNCATE_EXISTING);
    private static boolean snapshotHasCompletedShard(String snapshot, SnapshotsInProgress snapshotsInProgress) {  
    private void createIndexWithContent(String indexName, String nodeInclude, String nodeExclude) {  
            assertThat(snapshotsInProgress.entries().get(0).state(), is(SnapshotsInProgress.State.ABORTED));
        assertThat(thirdSnapshotResponse.get().getSnapshotInfo().state(), is(SnapshotState.FAILED));
        createRepository(otherRepoName, "fs");
            .getSnapshots();  
        }, 30L, TimeUnit.SECONDS);  
        awaitNumberOfSnapshotsInProgress(1);
    public void testStatusMultipleSnapshotsMultipleRepos() throws Exception {  
            .prepareCreateSnapshot(repoName, snapshotOne)
        final ActionFuture<AcknowledgedResponse> secondDeleteFuture = startDeleteSnapshot(repoName, "*");  
        final String otherBlockedRepoName = "test-repo-blocked-2";  
            repoName,
            () -> assertThat(  
            firstSnapshot  
        final List<String> snapshotNames = createNSnapshots(repoName, randomIntBetween(2, 5));
        assertAcked(deleteFuture.get());
        final String secondSnapshot = "snapshot-two";  
            dataNode  
        final String repoName = "test-repo";
            .cluster()
        expectThrows(RepositoryException.class, firstDeleteFuture::actionGet);
        final NetworkDisruption networkDisruption = isolateClusterManagerDisruption(NetworkDisruption.DISCONNECT);
        final ActionFuture<AcknowledgedResponse> deleteSnapshotsResponse = startDeleteSnapshot(repoName, firstSnapshot);
        }  
        final String dataNode2 = internalCluster().startDataOnlyNode();
            if (entry.snapshot().getSnapshotId().getName().equals(snapshot)) {
            if (blockedDelete || randomBoolean()) {
    private ActionFuture<AcknowledgedResponse> startDeleteFromNonClusterManagerClient(String repoName, String snapshotName) {
        createRepository(repoName, "mock");
        createNSnapshots(repoName, randomIntBetween(2, 5));
        final String clusterManagerName = internalCluster().getClusterManagerName();
        assertThat(sne.getCause().getMessage(), containsString("exception after block"));
                    Settings.builder().put(SnapshotsService.MAX_CONCURRENT_SNAPSHOT_OPERATIONS_SETTING.getKey(), limitToTest).build()
        );
        assertAcked(deleteSnapshotsResponse.get());
        final ActionFuture<CreateSnapshotResponse> firstSnapshotResponse = startFullSnapshotFromNonClusterManagerClient(
        for (int i = 0; i < numSnapshots; i++) {  
                for (final SnapshotsInProgress.ShardSnapshotStatus shard : entry.shards().values()) {  
        networkDisruption.stopDisrupting();  
        final ActionListener<AcknowledgedResponse> deletesListener = new GroupedActionListener<>(allDeletesDone, deleteFutures.size());
        createIndexWithContent(
        // Second delete works out cleanly since the repo is unblocked now  
    }
        createIndexWithContent("index-one");
        client().admin().cluster().prepareCreateSnapshot(repoName, "snapshot-three").setWaitForCompletion(false).get();
    }
import org.opensearch.action.StepListener;
            // Ignored, thrown most of the time but due to retries when shutting down the cluster-manager could randomly pass
            TimeUnit.MILLISECONDS
        awaitNoMoreRunningOperations();
        }  
        final ConcurrentSnapshotExecutionException csen1 = expectThrows(
        unblockNode(repoName, dataNode);
            "slow-snapshot",  
    public void testClusterManagerFailOverWithQueuedDeletes() throws Exception {
                deleteFuture = startDeleteSnapshot(repoName, randomFrom(snapshotNames));  
        expectThrows(SnapshotException.class, secondFailedSnapshotFuture::actionGet);
    }
        unblockNode(repoName, dataNode);
    public void testMultipleReposAreIndependent2() throws Exception {
            .cluster()
        client().admin().cluster().prepareCreateSnapshot(otherRepoName, "snapshot-other-blocked-2").setWaitForCompletion(false).get();  
        final ActionFuture<AcknowledgedResponse> deleteFuture = startDeleteFromNonClusterManagerClient(blockedRepoName, "*");  
        );
    public void testQueuedOperationsAndBrokenRepoOnClusterManagerFailOver() throws Exception {
            return snapshotsInProgress.entries().size() == 2 && snapshotHasCompletedShard(secondSnapshot, snapshotsInProgress);  
        createIndexWithContent("index-one");  
            for (SnapshotsInProgress.Entry entry : clusterService().state()
        createIndexWithContent("index-slow");  
        );
        createRepository(repoName, "mock");
        internalCluster().startClusterManagerOnlyNode();
    private static void assertSnapshotStatusCountOnRepo(String otherBlockedRepoName, int count) {
            ),  
    }
    public void testQueuedDeletesWithFailures() throws Exception {  
        return internalCluster().nonClusterManagerClient()  
            ConcurrentSnapshotExecutionException.class,  
 * ownership. Elasticsearch licenses this file to you under  
    public void testQueuedSnapshotOperationsAndBrokenRepoOnClusterManagerFailOverMultipleRepos() throws Exception {
        final ActionFuture<CreateSnapshotResponse> secondSnapshotResponse = startFullSnapshotFromClusterManagerClient(
            .cluster()  
            () -> currentSnapshots(repoName).stream()
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));
        logger.info("--> wait for delete to be enqueued in cluster state");
            repoName,
        final String firstSnapshot = "first-snapshot";
                .filter(s -> s.state() == SnapshotState.IN_PROGRESS)
        final ActionFuture<AcknowledgedResponse> fut = startDeleteSnapshot(repoName, snapshotName);
        logger.info("--> waiting for second and third snapshot to finish");
        final String repoName = "test-repo";  
        expectThrows(OpenSearchException.class, snapshotFour::actionGet);
import java.util.Locale;
            "failing-snapshot-2"
        final String snapshotTwo = "snap-2";
        final ActionFuture<CreateSnapshotResponse> createBlockedSnapshot = startFullSnapshotFromNonClusterManagerClient(  
            otherBlockedRepoName,
            repoName,
    }
        expectThrows(OpenSearchException.class, snapshotThree::actionGet);
            .cluster()
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        // Start deleting the snapshot and block it on the cluster manager node  
    }  
        ensureStableCluster(3);  
        final ActionFuture<CreateSnapshotResponse> snapshotThree = startFullSnapshotFromClusterManagerClient(repoName, "snap-other");
    }  
        final ActionFuture<CreateSnapshotResponse> snapshotThree = startAndBlockFailingFullSnapshot(repoName, "snap-other");
        final ActionFuture<CreateSnapshotResponse> createSlowFuture = startFullSnapshotBlockedOnDataNode(  
        createRepository(repoName, "mock");
        ensureStableCluster(5);
        final String prefix = "snap-" + UUIDs.randomBase64UUID(random()).toLowerCase(Locale.ROOT) + "-";
        assertThat(repositoryDataAfterDeletes.getGenId(), is(repoGenAfterInitialSnapshots + 2));
            dataNode  
        final ActionFuture<CreateSnapshotResponse> createSlowFuture1 = startFullSnapshotBlockedOnDataNode(
        assertThat(client().admin().cluster().prepareGetSnapshots(repoName).get().getSnapshots(), empty());  
        waitForBlock(initialClusterManager, otherRepoName, TimeValue.timeValueSeconds(30L));
        final String blockedRepoName = "test-repo-blocked";
        final ActionFuture<CreateSnapshotResponse> createSlowFuture2 = startFullSnapshotBlockedOnDataNode(
        assertThat(repositoryData.getGenId(), is(3L));
            timeout.millis(),
        internalCluster().startClusterManagerOnlyNode();  
    }
            .get()
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
        final Path repoPath = randomRepoPath();
    public void testQueuedDeletesWithOverlap() throws Exception {  
        final String blockedRepoName = "test-repo-blocked";  
        createIndexWithContent("test-index");
 *
            .cluster()
        blockNodeOnAnyFiles(repoName, dataNode);
 * Modifications Copyright OpenSearch Contributors. See  
        if (blockedDelete == false || limitToTest == 1) {
    }  
        logger.info("--> waiting for all three snapshots to show up as in-progress");
    public void testSnapshotRunsAfterInProgressDelete() throws Exception {
        assertBusy(
        assertSuccessful(snapshotThree);  
        internalCluster().startDataOnlyNode();
        // We're blocking a some of the snapshot threads when we block the first repo below so we have to make sure we have enough threads  
        final String repoName = "test-repo";  
        awaitNDeletionsInProgress(2);
import org.opensearch.tasks.TaskInfo;
        internalCluster().stopCurrentClusterManagerNode();
            + limitToTest  
            .prepareCreateSnapshot(repoName, snapshotName)
        ensureStableCluster(3, dataNode);  
        createIndexWithContent("index-one");  
        unblockNode(repoName, dataNode);
        awaitNumberOfSnapshotsInProgress(2);  
            snapshotNames.add(snapshot);
 */
        internalCluster().startClusterManagerOnlyNode();
            dataNode  
        assertThat(firstSnapshotInfo.reason(), is("Snapshot was aborted by deletion"));
        final ActionFuture<AcknowledgedResponse> firstDeleteFuture = startDeleteSnapshot(repoName, "*");  
        throws InterruptedException {
                client().admin()
    public void testCascadedAborts() throws Exception {  
        assertEquals("trying to modify or unregister repository that is currently used", ex.getMessage());  
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
        networkDisruption.stopDisrupting();
        final UncategorizedExecutionException ex = expectThrows(UncategorizedExecutionException.class, deleteFuture::actionGet);  
        createRepository(repoName, "mock", repoPath);
        awaitClusterState(state -> {
        logger.info("--> verify both deletes have completed");  
        createIndexWithContent("index-test");  
        ActionFuture<AcknowledgedResponse> future = deleteSnapshotBlockedOnClusterManager(repoName, snapshotName);
        final ActionFuture<CreateSnapshotResponse> snapshotThree = startFullSnapshotFromNonClusterManagerClient(repoName, "snapshot-three");  
        assertFalse(blockedSnapshot.isDone());
    }  
        final ActionFuture<CreateSnapshotResponse> firstSnapshotResponse = startFullSnapshotFromClusterManagerClient(
            .setIndices(secondIndex)  
            )
        blockDataNode(repoName, dataNode);  
import static org.hamcrest.Matchers.endsWith;  
        corruptIndexN(repoPath, generation);
        expectThrows(SnapshotException.class, createThirdSnapshot::actionGet);
        createRepository(repoName, "mock");
        disableRepoConsistencyCheck("This test corrupts the repository on purpose");
        createNSnapshots(repoName, randomIntBetween(2, 5));  
import java.io.IOException;
            .admin()
        final String firstSnapshot = "snapshot-one";
        internalCluster().setDisruptionScheme(networkDisruption);  
        final ActionFuture<CreateSnapshotResponse> snapOneResponse = client().admin()
        final Collection<String> snapshotNames = new HashSet<>();
        final ActionListener<CreateSnapshotResponse> snapshotsListener = new GroupedActionListener<>(allSnapshotsDone, numSnapshots);
        final String repoName = "test-repo";
            "snapshot-three"  
        }, 30L, TimeUnit.SECONDS);
        expectThrows(RepositoryException.class, secondDeleteFuture::actionGet);  
        final ActionFuture<CreateSnapshotResponse> createSlowFuture = startFullSnapshotBlockedOnDataNode(  
        createRepository(otherRepoName, "mock");
        assertSnapshotStatusCountOnRepo(blockedRepoName, 2);
        return client().admin()
        ensureStableCluster(3);  
        final String otherRepoName = "test-repo";  
        assertThat(snapshotException.getMessage(), containsString(SnapshotsInProgress.ABORTED_FAILURE_TEXT));
        final String expectedFailureMessage = "Cannot start another operation, already running ["  
        assertSuccessful(blockedSnapshot);  
import org.opensearch.core.common.unit.ByteSizeUnit;
        );
            () -> assertThat(  
        for (ActionFuture<AcknowledgedResponse> deleteResponse : deleteResponses) {  
        final String dataNode = startDataNodeWithLargeSnapshotPool();
        );
        blockNodeOnAnyFiles(blockedRepoName, clusterManagerNode);  
        final ActionFuture<AcknowledgedResponse> firstDeleteFuture = startDeleteFromNonClusterManagerClient(repoName, firstSnapshot);  
        createRepository(otherRepoName, "fs");  
            dataNode
        awaitNoMoreRunningOperations();  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    private static void waitUntilInprogress(final String repoName, final String snapshotName, TimeValue timeout)
            .prepareDeleteSnapshot(repoName, "*")  
        final RepositoryData repositoryData = getRepositoryData(repoName);
            otherBlockedRepoName,
        return fut;
        final String firstIndex = "index-one";
        createIndexWithContent("index-one");
import org.opensearch.snapshots.mockstore.MockRepository;  
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);
                // rarely the cluster-manager node fails over twice
        boolean blockedDelete = false;  
        final ActionFuture<CreateSnapshotResponse> createSnapshot1Future = startFullSnapshotBlockedOnDataNode(
        final String repoName = "test-repo";
        internalCluster().startClusterManagerOnlyNodes(3, LARGE_SNAPSHOT_POOL_SETTINGS);
        createRepository(otherRepoName, "fs");  
        for (SnapshotsInProgress.Entry entry : snapshotsInProgress.entries()) {
        logger.info("--> verify that all snapshots are gone and no more work is left in the cluster state");  
    public void testQueuedOperationsOnClusterManagerDisconnectAndRepoFailure() throws Exception {  
        internalCluster().startDataOnlyNode();
            assertSuccessful(snapshotFuture);
        createRepository(blockedRepoName, "mock");  
        awaitNumberOfSnapshotsInProgress(1);  
        createIndexWithContent("index-test");
        // Verify that the update fails with an appropriate exception
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
        createRepository(repoName, "mock");
        internalCluster().setDisruptionScheme(networkDisruption);  
import org.opensearch.common.util.concurrent.UncategorizedExecutionException;
        final String otherRepoName = "test-repo";
        internalCluster().stopCurrentClusterManagerNode();
    }
        final Path repoPath = randomRepoPath();
        createRepository(repoName, "mock", repoPath);
        final ActionFuture<CreateSnapshotResponse> snapshotFour = startFullSnapshot(repoName, "snapshot-four", true);
    }
        final SnapshotInfo firstSnapshotInfo = firstSnapshotResponse.get().getSnapshotInfo();
        final List<String> snapshotNames = new ArrayList<>(count);  
        assertBusy(() -> {  
        createIndexWithContent("index-one");
                .filter(s -> s.snapshotId().getName().equals(snapshotName))  
        createNSnapshots(repoName, randomIntBetween(2, 5));  
        // left for the second concurrent snapshot.  
        unblockNode(blockedRepoName, dataNode);
        final String clusterManagerNode = internalCluster().getClusterManagerName();  
        }  
        createNSnapshots(blockedRepoName, randomIntBetween(1, 5));
    public void testQueuedSnapshotsWaitingForShardReady() throws Exception {  
            .setWaitForCompletion(true)
            dataNode
    }  
        createRepository(repoName, "mock");  
        final String repoName = "test-repo";  
            client().admin()  
        createIndexWithContent("index-one");
            "blocked-snapshot",
        createRepository(repoName, "mock");
        final ActionFuture<AcknowledgedResponse> deleteSnapshotOne = startDeleteSnapshot(repoName, snapshotOne);  
        // Create index on two nodes and make sure each node has a primary by setting no replicas
        corruptIndexN(repoPath, generation);  
        createNSnapshots(repoName, randomIntBetween(1, 5));
        client().admin().cluster().prepareCreateSnapshot(repoName, "snapshot-blocked-2").setWaitForCompletion(false).get();
    public void testQueuedOperationsAfterFinalizationFailure() throws Exception {
        createNSnapshots(repoName, randomIntBetween(1, 5));  
    public void testBackToBackQueuedDeletes() throws Exception {
        internalCluster().stopCurrentClusterManagerNode();
        final ActionFuture<AcknowledgedResponse> deleteFuture = startAndBlockOnDeleteSnapshot(repoName, "*");
            awaitNDeletionsInProgress(1);
        assertThat(firstSnapshotResponse.isDone(), is(false));
    @Override  
import java.nio.file.Files;
        final ActionFuture<AcknowledgedResponse> deleteSnapshotOne = startDeleteSnapshot(repoName, snapshotOne);  
        unblockNode(repoName, clusterManagerNode);  
        final String repoName = "test-repo";  
        awaitNDeletionsInProgress(2);  
        // One increment for snapshot, one for all the deletes  
        unblockNode(otherBlockedRepoName, dataNode);
        final String blockedRepoName = "test-repo-blocked-1";
        }
            assertThat(currentSnapshots(repoName), hasSize(1));  
        final ActionFuture<CreateSnapshotResponse> snapshotThreeFuture = startFullSnapshotFromNonClusterManagerClient(
            // ignored
            .setWaitForCompletion(false)
        networkDisruption.startDisrupting();  
        createNSnapshots(repoName, randomIntBetween(2, 5));  
        internalCluster().startClusterManagerOnlyNodes(3);
            snapshotNames.removeAll(toDelete);  
        Settings.Builder settings = randomRepositorySettings();
        final String clusterManagerNode = internalCluster().getClusterManagerName();
        ensureStableCluster(3, dataNode);
        final String snapshotOne = snapshotNames.get(0);
        );
        awaitNumberOfSnapshotsInProgress(1);
        internalCluster().startDataOnlyNode();  
            "failing-snapshot-1"  
            final SnapshotsInProgress snapshotsInProgress = state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
        final String clusterManagerNode = internalCluster().getClusterManagerName();
        final ActionFuture<AcknowledgedResponse> deleteFuture = startDeleteSnapshot(repoName, firstSnapshot);  
        assertSuccessful(snapshotThree);  
        throws InterruptedException {
        final SnapshotsStatusResponse snapshotsStatusResponse = client().admin()  
        }
    }
            snapshotNames.add(name);
        );  
        assertThat(repositoryDataAfterDeletes.getSnapshotIds(), contains(slowSnapshotInfo.snapshotId()));
        awaitNumberOfSnapshotsInProgress(3);  
        blockNodeOnAnyFiles(repoName, clusterManagerName);  
        for (int i = 0; i < limitToTest; ++i) {  
import java.util.HashSet;
        final int countOtherRepo = randomIntBetween(2, 5);
                .isPresent(),  
                }
        createIndexWithContent("test-index");  
        }  
        assertAcked(future.actionGet()); // Wait for the delete operation to complete
        internalCluster().startDataOnlyNode();
        );  
        assertSuccessful(createSlowFuture);
        } catch (RepositoryException re) {  
        createRepository(repoName, "mock");  
        waitForBlock(dataNode, repoName, TimeValue.timeValueSeconds(30L));
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;  
            assertAcked(deleteFuture.get());
        // Snapshot should have been aborted
        expectThrows(RepositoryException.class, failedDeleteFuture::actionGet);
            .prepareCreateSnapshot(repoName, "snapshot-three")  
        awaitNDeletionsInProgress(1);  
        ensureStableCluster(3, dataNode);  
        createIndexWithContent("index-slow");
        final String dataNode = internalCluster().startDataOnlyNode();
                .prepareCreateSnapshot(repoName, "fast-snapshot")
/*
        return internalCluster().nonClusterManagerClient().admin().cluster().prepareDeleteSnapshot(repoName, snapshotName).execute();
        assertThat(snapshotStatuses, hasSize(count));
        logger.info("--> wait for snapshot to complete");
        createRepository(repoName, "mock");
        );
        final ActionFuture<AcknowledgedResponse> deleteFuture = startDeleteFromNonClusterManagerClient(repoName, "*");
        logger.info("--> verify that the first snapshot is gone");
        ensureStableCluster(3);  
        );  
                equalTo(SnapshotState.IN_PROGRESS)  
        awaitNumberOfSnapshotsInProgress(4);
        waitForBlock(dataNode, repoName, TimeValue.timeValueSeconds(30L));  
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));  
        disableRepoConsistencyCheck("This test corrupts the repository on purpose");
            .execute();  
        assertSnapshotStatusCountOnRepo("_all", 1);
import org.opensearch.core.rest.RestStatus;  
        }
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode();
        createIndex(testIndex, Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 1).build());  
            client().admin().cluster().prepareCreateSnapshot(repoName, snapshot).setWaitForCompletion(true).execute(snapshotsListener);  
        assertBusy(  
    private ActionFuture<CreateSnapshotResponse> startAndBlockFailingFullSnapshot(String blockedRepoName, String snapshotName)  
            .prepareCreateSnapshot(repoName, "snapshot-three")
        final ActionFuture<CreateSnapshotResponse> secondSnapshotResponse = startFullSnapshot(repoName, secondSnapshot);
            .cluster()
                .setWaitForCompletion(true)  
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode();
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        final String repoName = "test-repo";
        final ActionFuture<CreateSnapshotResponse> firstFailedSnapshotFuture = startFullSnapshotFromClusterManagerClient(
/*  
        unblockNode(repoName, clusterManagerNode);
        final String snapshotOne = snapshotNames.get(0);
    public void testEquivalentDeletesAreDeduplicated() throws Exception {  
        final SnapshotInfo secondSnapshotInfo = assertSuccessful(secondSnapshotResponse);  
import org.opensearch.common.settings.Settings;  
        assertThat(createSlowFuture.isDone(), is(false));
                assertThat(sme.getSnapshotName(), is(firstSnapshot));
        blockClusterManagerFromDeletingIndexNFile(repoName);
        assertThat(firstSnapshotResponse.isDone(), is(false));
            SnapshotInfo snapshotInfo = waitForCompletion(repoName, snapshot, TimeValue.timeValueSeconds(600));
        createNSnapshots(otherRepoName, randomIntBetween(1, 5));
        unblockNode(blockedRepoName, internalCluster().getClusterManagerName());
        // Two snapshots and two distinct delete operations move us 4 steps from -1 to 3  
        assertBusy(() -> assertThat(currentSnapshots(repoName), hasSize(3)), 30L, TimeUnit.SECONDS);  
        awaitNumberOfSnapshotsInProgress(blockedSnapshots);  
        final String secondSnapshot = "snapshot-two";  
        createIndexWithContent(firstIndex);  
            blockedRepoName,  
        final Path repoPath = randomRepoPath();
        final ActionFuture<CreateSnapshotResponse> firstSnapshotResponse = startFullSnapshotBlockedOnDataNode(
        blockNodeOnAnyFiles(repoName, clusterManagerNode);  
        unblockNode(repoName, dataNode2);
        unblockNode(otherBlockedRepoName, dataNode);  
        while (snapshotNames.isEmpty() == false) {
            repoName,
    }
        logger.info("--> wait for relocations to start");
        final ActionFuture<CreateSnapshotResponse> snapshotFour = startFullSnapshotFromNonClusterManagerClient(repoName, "snapshot-four");
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
    public void testAbortNotStartedSnapshotWithoutIO() throws Exception {
        createRepository(otherBlockedRepoName, "mock");
import static org.hamcrest.Matchers.hasItem;  
            .prepareDeleteSnapshot(repoName, "*")
                .setIndices(indexFast)
        awaitNDeletionsInProgress(2);
            deleteFuture.whenComplete(deletesListener::onResponse, deletesListener::onFailure);  
                ConcurrentSnapshotExecutionException.class,  
        assertThat(csen1.getMessage(), containsString(expectedFailureMessage));  
        final ActionFuture<AcknowledgedResponse> deleteSnapshotOne = startAndBlockOnDeleteSnapshot(repoName, snapshotOne);
        );  
        ensureGreen(testIndex);
        final String snapshotTwo = snapshots.get(1);  
        final long generation = getRepositoryData(repoName).getGenId();
        createIndexWithContent("test-index");  
        createIndexWithContent("index");  
        assertThat(deleteSnapshotsResponse.get().isAcknowledged(), is(true));  
        final ActionFuture<CreateSnapshotResponse> createSlowFuture = startAndBlockFailingFullSnapshot(blockedRepoName, "blocked-snapshot");
        unblockNode(repoName, clusterManagerNode);
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode();
        createIndexWithContent("index-one");  
        createRepository(repoName, "mock");
        final ActionFuture<CreateSnapshotResponse> snapTwoResponse = client().admin()
        final NetworkDisruption networkDisruption = isolateClusterManagerDisruption(NetworkDisruption.DISCONNECT);
        assertSnapshotStatusCountOnRepo(otherBlockedRepoName, 1);  
        createRepository(blockedRepoName, "mock");
        final RepositoryData repositoryData = getRepositoryData(otherRepoName);
        createRepository(blockedRepoName, "mock");
        assertAcked(client().admin().indices().prepareDelete("index-two"));
        }
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));
        unblockNode(repoName, clusterManagerName);
        createNSnapshots(repoName, randomIntBetween(1, 5));  
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode();
        final ActionFuture<CreateSnapshotResponse> createSlowFuture = startFullSnapshotBlockedOnDataNode(  
            deleteResponses.add(client().admin().cluster().prepareDeleteSnapshot(repoName, "*").execute());  
        internalCluster().startClusterManagerOnlyNodes(3);
import java.util.Arrays;  
        blockClusterManagerOnWriteIndexFile(repoName);
        if (blockedDelete) {
    }
        });  
        internalCluster().startClusterManagerOnlyNode();  
    }  
        expectThrows(SnapshotException.class, snapshotThree::actionGet);
    }
        blockDataNode(repoName, dataNode);
        final ActionFuture<CreateSnapshotResponse> snapshotFour = startFullSnapshotFromNonClusterManagerClient(repoName, "snapshot-four");
        assertThat(repositoryData.getSnapshotIds(), hasSize(countOtherRepo + 2));  
        createIndexWithContent("index-one");
        corruptIndexN(repoPath, generation);
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = startFullSnapshot(repoName, "snapshot-queued");  
        corruptIndexN(repoPath, getRepositoryData(repoName).getGenId());
    }  
