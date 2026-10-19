    }
        final String sourceSnapshot = "source-snapshot";
            .setIndices(indexFast)
        internalCluster().startDataOnlyNode(remoteStoreClusterSettings(remoteStoreRepoName, remoteStoreRepoPath));
            repositoryShardId,
        unblockNode(repoName, clusterManagerNode);
        unblockNode(repoName, clusterManagerName);
        final String snapshotRepoName = "snapshot-repo-name";
        createRepository(snapshotRepoName, "fs", snapshotRepoPath);
        createRepository(repoName, "mock");
        disableRepoConsistencyCheck("This test uses remote store repository");
        createIndexWithContent(indexName);
 * The OpenSearch Contributors require contributions made to
        assertEquals(getSnapshot(repoName, cloneName).state(), SnapshotState.SUCCESS);
        unblockNode(repoName, dataNode);
        internalCluster().startDataOnlyNode();
        final Client clusterManagerClient = internalCluster().clusterManagerClient();
        createFullSnapshot(repoName, sourceSnapshot);
        awaitNumberOfSnapshotsInProgress(1);
        final String dataNode = internalCluster().startDataOnlyNode();
        assertThat(cloneFuture.isDone(), is(false));
        final ActionFuture<AcknowledgedResponse> cloneFuture = startCloneFromDataNode(repoName, sourceSnapshot, targetSnapshot, testIndex);
            () -> startDeleteSnapshot(repoName, sourceSnapshot).actionGet()
        awaitNumberOfSnapshotsInProgress(2);
        assertAcked(clone.get());
    public void testDoesNotStartOnBrokenSourceSnapshot() throws Exception {
        assertEquals(getSnapshot(snapshotRepoName, targetSnapshot).isRemoteStoreIndexShallowCopyEnabled(), false);
        final int extraSnapshots = randomIntBetween(0, 5);
    }
        final List<ActionFuture<CreateSnapshotResponse>> extraSnapshotFutures = new ArrayList<>(extraSnapshots);
        createIndexWithContent(indexSlow);
        // large snapshot pool so blocked snapshot threads from cloning don't prevent concurrent snapshot finalizations
        blockClusterManagerOnWriteIndexFile(repoName);
        }
        assertEquals(fileCount, targetFiles.size());
        String... indices
import static org.hamcrest.Matchers.hasSize;
        ExecutionException ex = expectThrows(
        createFullSnapshot(snapshotRepoName, snapshot);
    }
        final RepositoryData repositoryData = getRepositoryData(repoName);
        assertBusy(() -> assertEquals(1, getLockFilesInRemoteStore(remoteStoreEnabledIndexName, remoteStoreRepoName).length));
        final String indexName = "index-1";
        assertFalse(updatedRepositoryMetadata.settings().getAsBoolean(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), false));
        createIndexWithContent(indexName);
        awaitClusterManagerFinishRepoOperations();
        }
            () -> startClone(repoName, snapshotName, "target-snapshot", "does-not-exist").actionGet()
        final Path shallowSnapshotRepoPath = randomRepoPath();
        final String sourceSnapshot = "source-snapshot";
import org.opensearch.repositories.RepositoryData;
        createFullSnapshot(repoName, sourceSnapshot);
        awaitNoMoreRunningOperations();
        for (SnapshotId snapshotId : snapshotIds) {
        // large snapshot pool so blocked snapshot threads from cloning don't prevent concurrent snapshot finalizations
        );
 * under the License.
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, remoteStoreRepoName).length == 2);
        createRepository(snapshotRepoName, "fs", snapshotRepoPath);
        final String targetSnapshot = "target-snapshot";
    }
import java.util.Collection;
 * this file be licensed under the Apache-2.0 license or a
        final String snapshotRepoName = "snapshot-repo-name";
 * the Apache License, Version 2.0 (the "License"); you may
            repository,
        final List<BlobStoreIndexShardSnapshot.FileInfo> targetFiles = targetShardSnapshot.indexFiles();
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
        final String dataNode = internalCluster().startDataOnlyNode();
        disableRepoConsistencyCheck("This test uses remote store repository");
            assertAcked(admin().indices().prepareDelete(indexName));
        internalCluster().startDataOnlyNode();
        assertEquals(getSnapshot(repoName, cloneName).state(), SnapshotState.SUCCESS);
 * compatible open source license.
                TimeValue.timeValueSeconds(30L)
        final SnapshotIndexStatus status2 = status.get(1).getIndices().get(indexName);
/*
        assertFalse(blockedClone.isDone());
            f -> repository.cloneShardSnapshot(sourceSnapshotInfo.snapshotId(), targetSnapshotId, repositoryShardId, currentShardGen, f)
        final String cloneName = "clone-blocked";
        final Path snapshotRepoPath = randomRepoPath();
        createFullSnapshot(repoName, sourceSnapshot);
        unblockNode(repoName, dataNode);
            .setWaitForCompletion(true)
        awaitNumberOfSnapshotsInProgress(1);
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
        assertThat(snapshotFuture.isDone(), is(false));
        final int extraClones = randomIntBetween(1, 5);
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
        if (randomBoolean()) {
        final String repoName = "repo-name";
    }
        String repoName,
        // Updating the snapshot repository flag to enable shallow snapshots
        final String indexName = "index-1";
        final int fileCount = sourceFiles.size();
        final String targetSnapshot = "target-snapshot";
        }
        createIndexWithContent(testIndex);
 * KIND, either express or implied.  See the License for the
        assertSuccessful(otherSnapshot);
        final ActionFuture<CreateSnapshotResponse> blockedSnapshot = startFullSnapshot(repoName, "snap-blocked");
        if (randomBoolean()) {
        internalCluster().restartNode(clusterManagerNode);
import org.opensearch.action.support.PlainActionFuture;
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));
        assertThat(targetShardSnapshot.incrementalFileCount(), is(0));
        String sourceSnapshot,
        final String targetSnapshot = "target-snapshot";
        final String sourceSnapshot = "source-snapshot";
        indexRandomDocs(indexName, randomIntBetween(20, 100));
    private void blockClusterManagerOnShardClone(String repoName) {
        internalCluster().startClusterManagerOnlyNode(remoteStoreClusterSettings(remoteStoreRepoName, remoteStoreRepoPath));
        final String sourceSnapshot = "source-snapshot";
                        () -> BlobStoreRepository.INDEX_SHARD_SNAPSHOTS_FORMAT.read(
        final String sourceSnapshot = shallowSnapshot;
        String sourceSnapshot,
    }
    public void testCloneSnapshotIndex() throws Exception {
        })));
import java.util.concurrent.ExecutionException;
            Settings.builder()
        disableRepoConsistencyCheck("This test uses remote store repository");
        internalCluster().startClusterManagerOnlyNode();
                    )
        final String snapshotName = "snapshot";
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));
        final String repoName = "test-repo";
            .get()
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode();
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
        );
        assertThat(status, hasSize(2));
    private static void assertAllSnapshotsSuccessful(RepositoryData repositoryData, int successfulSnapshotCount) {
        final String clusterManagerNode = internalCluster().getClusterManagerName();
import static org.hamcrest.Matchers.is;
        cloneSucceeded = cloneSucceeded
        createRepository(repoName, "mock");
        createFullSnapshot(shallowSnapshotRepoName, shallowSnapshot1);
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);
        assertThat(ex.getMessage(), containsString("cannot clone from snapshot that is being deleted"));
/*
        assertAcked(startClone(shallowSnapshotRepoName, sourceSnapshot, targetSnapshot, indexName, remoteStoreEnabledIndexName).get());
        final String sourceSnapshot = "source-snapshot";
        String targetSnapshot,
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
        return startClone(client(), repoName, sourceSnapshot, targetSnapshot, indices);
    public void testLongRunningCloneAllowsConcurrentSnapshot() throws Exception {
        final String snapshotRepoName = "snapshot-repo-name";
        String targetSnapshot,
    public void testShallowCloneNameAvailability() throws Exception {
        assertEquals(getSnapshot(snapshotRepoName, targetSnapshot).isRemoteStoreIndexShallowCopyEnabled(), true);
        for (ActionFuture<AcknowledgedResponse> extraCloneFuture : extraCloneFutures) {
        internalCluster().startClusterManagerOnlyNode(remoteStoreClusterSettings(remoteStoreRepoName, remoteStoreRepoPath));
        final String indexName = "index-1";
        try {
        final Path remoteStoreRepoPath = randomRepoPath();
        final String remoteStoreRepoName = "remote-store-repo-name";
        createRepository(repoName, "fs");
 * Modifications Copyright OpenSearch Contributors. See
        awaitClusterManagerFinishRepoOperations();
import java.util.ArrayList;
        internalCluster().startDataOnlyNode();
import org.opensearch.repositories.RepositoriesService;
            () -> startClone(repoName, sourceSnapshot, targetSnapshot, indexName).actionGet()
public class CloneSnapshotIT extends AbstractSnapshotIntegTestCase {
        final ActionFuture<CreateSnapshotResponse> otherSnapshot = startFullSnapshot(repoName, "other-snapshot");
    public void testExceptionDuringShardClone() throws Exception {
            .get()
        createRepository(snapshotRepoName, "fs", snapshotRepoSettingsForShallowCopy(snapshotRepoPath));
            client().admin().cluster().prepareHealth().setWaitForNoInitializingShards(true).setWaitForNoRelocatingShards(true).get();
    }
    ) {
    public void testStartSnapshotWithSuccessfulShardClonePendingFinalization() throws Exception {
            cloneSucceeded = true;
            createIndexWithContent(indexBlocked);
        }
                .put(remoteStoreClusterSettings(remoteStoreRepoName, remoteStorePath))
        blockClusterManagerOnShardClone(repoName);
    }
        final SnapshotIndexStatus status2 = status.get(1).getIndices().get(indexName);
        createIndexWithRandomDocs(indexFast, randomIntBetween(20, 100));
        final List<SnapshotFiles> snapshotFiles = shardMetadata.snapshots();
        final String dataNode = internalCluster().startDataOnlyNode();
        final String indexName = "index-1";
                    .entries();
        assertFalse(cloneFuture.isDone());
        final String indexName = "test-idx";
        final List<BlobStoreIndexShardSnapshot.FileInfo> sourceFiles = sourceShardSnapshot.indexFiles();
        }
        createFullSnapshot(shallowSnapshotRepoName, shallowSnapshot2);
        }
        awaitNoMoreRunningOperations(internalCluster().getClusterManagerName());
        final String targetSnapshot = "target-snapshot";
        String sourceSnapshot,
 * SPDX-License-Identifier: Apache-2.0
                        )
 * not use this file except in compliance with the License.
        assertAcked(admin().indices().prepareDelete(indexBlocked).get());
}
            createIndexWithContent("test-idx");
 */
        awaitNoMoreRunningOperations(clusterManagerName);
        internalCluster().startDataOnlyNode();
        final String repoName = "repo-name";
        createIndexWithContent(testIndex);
    }
        internalCluster().startDataOnlyNode(remoteStoreClusterSettings(remoteStoreRepoName, remoteStoreRepoPath));
        awaitNumberOfSnapshotsInProgress(1);
 *
        for (ActionFuture<AcknowledgedResponse> extraCloneFuture : extraCloneFutures) {
        createRepository(repoName, "mock");
    public void testCloneShallowSnapshotIndex() throws Exception {
        unblockNode(repoName, clusterManagerName);
        ConcurrentSnapshotExecutionException ex = expectThrows(
        final Path snapshotRepoPath = randomRepoPath();
        final SnapshotId targetSnapshotId = new SnapshotId("target-snapshot", UUIDs.randomBase64UUID(random()));
    private static ActionFuture<AcknowledgedResponse> startClone(
        // Check if the clone operation worked out by chance as a result of the clone request being retried
        internalCluster().startDataOnlyNode(remoteStoreClusterSettings(remoteStoreRepoName, remoteStorePath));
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
import org.opensearch.index.IndexNotFoundException;
        boolean cloneSucceeded = false;
    private static BlobStoreIndexShardSnapshot readShardSnapshot(
            awaitClusterState(clusterState -> {
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));
        );
            assertAcked(extraCloneFuture.get());
            containsString(
        for (int i = 0; i < extraSnapshots; i++) {
        RepositoryShardId repositoryShardId,
        awaitNumberOfSnapshotsInProgress(2);
        );
        final String repoName = "repo-name";
        final SnapshotIndexStatus status1 = status.get(0).getIndices().get(indexName);
        final Path remoteStoreRepoPath = randomRepoPath();
        awaitNumberOfSnapshotsInProgress(1 + extraClones + extraSnapshots);
            .setSnapshots(sourceSnapshot, targetSnapshot)
        assertAllSnapshotsSuccessful(getRepositoryData(repoName), 1);
    public void testClusterManagerFailoverDuringCloneStep1() throws Exception {
        assertAcked(deleteFuture.get());
        blockClusterManagerOnWriteIndexFile(repoName);
        );
        assertEquals(status1.getStats().getTotalSize(), status2.getStats().getTotalSize());
        final String sourceSnapshot = "source-snapshot";
        final ActionFuture<AcknowledgedResponse> cloneFuture = startCloneFromDataNode(repoName, sourceSnapshot, targetSnapshot, testIndex);
        final ActionFuture<AcknowledgedResponse> deleteFuture = startDeleteSnapshot(repoName, sourceSnapshot);
        internalCluster().startDataOnlyNode();
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(LARGE_SNAPSHOT_POOL_SETTINGS);
        final Collection<SnapshotId> snapshotIds = repositoryData.getSnapshotIds();
        final SnapshotException sne = expectThrows(
import org.opensearch.cluster.metadata.RepositoryMetadata;
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));
                repository.shardContainer(repositoryShardId.index(), repositoryShardId.shardId()),
        createFullSnapshot(snapshotRepoName, snapshot);
        final String sourceSnapshot = "source-snapshot";
        final String shallowSnapshot2 = "snapshot2";
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));
        client().admin().cluster().prepareHealth().setWaitForNoInitializingShards(true).setWaitForNoRelocatingShards(true).get();
        if (randomBoolean()) {
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, remoteStoreRepoName).length == 0);
        final ActionFuture<AcknowledgedResponse> cloneFuture1 = startClone(repoName, sourceSnapshot, targetSnapshot1, indexBlocked);
    }
        final String cloneName = "clone-blocked";
        final String indexName = "index-1";
        );
        final String snapshot = "snapshot";
        indexRandomDocs(indexName, randomIntBetween(20, 100));
        final Path shallowSnapshotRepoPath = randomRepoPath();
        final String testIndex = "index-test";
        final String indexBlocked = "index-blocked";
import org.opensearch.index.snapshots.blobstore.SnapshotFiles;
        final ActionFuture<AcknowledgedResponse> clone = startClone(repoName, sourceSnapshot, cloneName, indexName);
        createFullSnapshot(repoName, sourceSnapshot);
        expectThrows(
        ).repository(repoName);
            assertFalse(extraSnapshotFuture.isDone());
    }
    ) {
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
        final List<SnapshotStatus> status = clusterAdmin().prepareSnapshotStatus(repoName)
 *
        final String remoteStoreEnabledIndexName = "remote-index-1";
        indexRandomDocs(remoteStoreEnabledIndexName, randomIntBetween(5, 10));
            .getSnapshots();
        createRepository(snapshotRepoName, "fs", snapshotRepoSettingsForShallowCopy(snapshotRepoPath));
        assertSuccessful(blockedSnapshot);
    }
        unblockNode(repoName, clusterManagerNode);
    }
        final String newShardGeneration = PlainActionFuture.get(
            assert indexShardSnapshot instanceof BlobStoreIndexShardSnapshot
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
    }
        final BlobStoreIndexShardSnapshot sourceShardSnapshot = readShardSnapshot(
        final String indexName = "test-idx";
        final String cloneName = "clone";
        blockClusterManagerOnWriteIndexFile(repoName);
            .prepareCreateSnapshot(repoName, sourceSnapshot)
        assertFalse(deleteFuture.isDone());
    public void testLongRunningSnapshotAllowsConcurrentClone() throws Exception {
        assertAllSnapshotsSuccessful(getRepositoryData(repoName), 2);
        final String targetSnapshot = "target-snapshot";
        // Updating the snapshot repository flag to enable shallow snapshots
        internalCluster().startClusterManagerOnlyNodes(3, LARGE_SNAPSHOT_POOL_SETTINGS);
        internalCluster().startClusterManagerOnlyNode(
        createIndexWithContent(testIndex);
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
        createIndexWithRandomDocs(indexFast, randomIntBetween(20, 100));
        createRepository(snapshotRepoName, "fs", snapshotRepoPath);
        internalCluster().startDataOnlyNode();
            () -> startClone(clusterManagerClient, repoName, sourceSnapshot, "target-snapshot", testIndex).actionGet(
            .setSnapshots(sourceSnapshot, targetSnapshot)
    public void testClonePreventsSnapshotDelete() throws Exception {
            assertFalse(extraCloneFuture.isDone());
        assertBusy(() -> assertEquals(2, getLockFilesInRemoteStore(remoteStoreEnabledIndexName, remoteStoreRepoName).length));
        final BlobStoreIndexShardSnapshot targetShardSnapshot = readShardSnapshot(repository, repositoryShardId, targetSnapshotId);
        String repoName,
        assertAcked(startClone(repoName, sourceSnapshot, targetSnapshot, indexName).get());
            .cluster()
                    ActionRunnable.supply(
            ConcurrentSnapshotExecutionException.class,
        final String repoName = "repo-name";
        final IndexId indexId = repositoryData.resolveIndexId(indexName);
        final RepositoryShardId repositoryShardId = new RepositoryShardId(indexId, shardId);
        String... indices
        awaitNumberOfSnapshotsInProgress(1);
        final String indexName = "index-1";
        final Path remoteStoreRepoPath = randomRepoPath();
        createIndexWithContent(indexBlocked);
        assertThat(cloneFuture1.isDone(), is(false));
        internalCluster().restartNode(dataNode);
        awaitNumberOfSnapshotsInProgress(2);
        SnapshotId snapshotId
        blockClusterManagerOnShardClone(repoName);
        final String indexSlow = "index-slow";
    }
        final String sourceSnapshot = "source-snapshot";
import org.opensearch.repositories.IndexId;
import org.opensearch.common.settings.Settings;
    ) {
        final String repoName = "repo-name";
            return (BlobStoreIndexShardSnapshot) indexShardSnapshot;
            extraCloneFutures.add(startClone(repoName, sourceSnapshot, "target-snapshot-" + i, indexBlocked));
        final ActionFuture<AcknowledgedResponse> blockedClone = startClone(repoName, sourceSnapshot, cloneName, indexName);
        createFullSnapshot(shallowSnapshotRepoName, shallowSnapshot);
        indexRandomDocs(remoteStoreEnabledIndexName, randomIntBetween(5, 10));
 * license agreements. See the NOTICE file distributed with
        final String testIndex = "index-test";
        unblockNode(repoName, clusterManagerNode);
        final ActionFuture<AcknowledgedResponse> cloneFuture = startClone(repoName, sourceSnapshot, targetSnapshot, indexSlow);
        ConcurrentSnapshotExecutionException ex = expectThrows(
            f -> repository.cloneShardSnapshot(sourceSnapshotInfo.snapshotId(), targetSnapshotId, repositoryShardId, newShardGeneration, f)
        createFullSnapshot(repoName, sourceSnapshot);
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
 */
    public void testConcurrentCloneAndSnapshot() throws Exception {
 * software distributed under the License is distributed on an
        internalCluster().restartNode(clusterManagerNode);
        createRepository(repoName, "mock");
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));
        createRepository(repoName, "mock");
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));
        final List<SnapshotStatus> status = clusterAdmin().prepareSnapshotStatus(repoName)
        final String cloneName = "target-snapshot";
        final String currentShardGen = repositoryData.shardGenerations().getShardGen(indexId, shardId);
import org.opensearch.common.action.ActionFuture;
        assertThat(
        }
package org.opensearch.snapshots;
        internalCluster().startClusterManagerOnlyNode(LARGE_SNAPSHOT_POOL_SETTINGS);
        createRepository(shallowSnapshotRepoName, "fs", snapshotRepoSettingsForShallowCopy(shallowSnapshotRepoPath));
        }
    }
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
        internalCluster().startDataOnlyNode();
        createRepository(repoName, "mock");
        final String remoteStoreEnabledIndexName = "remote-index-1";
    }
        );
        final String newShardGeneration2 = PlainActionFuture.get(
        final BlobStoreIndexShardSnapshots shardMetadata = readShardGeneration(repository, repositoryShardId, newShardGeneration);
        );
        ((MockRepository) internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class).repository(repoName))
                        f,
        }
    public void testCloneAfterRepoShallowSettingDisabled() throws Exception {
        createRepository(repoName, "fs", repoPath);
        final String repoName = "test-repo";
        }
            )
        );
        assertEquals(newShardGeneration, newShardGeneration2);
        final List<ActionFuture<AcknowledgedResponse>> extraCloneFutures = new ArrayList<>(extraClones);
    }
        awaitNoMoreRunningOperations(internalCluster().getClusterManagerName());
        final Path snapshotRepoPath = randomRepoPath();
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(LARGE_SNAPSHOT_POOL_SETTINGS);
            RepositoriesService.class
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotIndexStatus;
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = clusterAdmin().prepareCreateSnapshot(repoName, "fast-snapshot")
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(LARGE_SNAPSHOT_POOL_SETTINGS);
        assertAcked(cloneFuture.get());
        internalCluster().startDataOnlyNode();
                .execute(
import org.opensearch.transport.client.Client;
        internalCluster().startClusterManagerOnlyNode(LARGE_SNAPSHOT_POOL_SETTINGS);
        createFullSnapshot(repoName, sourceSnapshot);
                final List<SnapshotsInProgress.Entry> entries = clusterState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY)
        // large snapshot pool so blocked snapshot threads from cloning don't prevent concurrent snapshot finalizations
    }
        awaitNumberOfSnapshotsInProgress(1);
 */
        awaitNumberOfSnapshotsInProgress(1);
            .getSnapshots();
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus;
        createFullSnapshot(repoName, sourceSnapshot);
        blockClusterManagerOnReadIndexMeta(repoName);
        final String remoteStoreEnabledIndexName = "remote-index-1";
        final String snapshot = "snapshot";
    public void testClusterManagerFailoverDuringCloneStep2() throws Exception {
    private ActionFuture<AcknowledgedResponse> startCloneFromDataNode(
            )
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));
            unblockNode(repoName, clusterManagerName);
        internalCluster().startClusterManagerOnlyNode();
import org.opensearch.snapshots.mockstore.MockRepository;
 * Licensed to Elasticsearch under one or more contributor
            ensureYellow(remoteStoreEnabledIndexName);
 *
        final String targetSnapshot = "target-snapshot";
        return client.admin().cluster().prepareCloneSnapshot(repoName, sourceSnapshot, targetSnapshot).setIndices(indices).execute();
        final String remoteStoreRepoName = "remote-store-repo-name";
                snapshotId
        internalCluster().startClusterManagerOnlyNode();
            clusterAdmin().prepareCreateSnapshot(repoName, "fast-snapshot").setIndices(indexFast).setWaitForCompletion(true).execute()
        }
    }
        }
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(LARGE_SNAPSHOT_POOL_SETTINGS);
        logger.info("Lock files count: {}", getLockFilesInRemoteStore(remoteStoreEnabledIndexName, remoteStoreRepoName).length);
            assertTrue(sourceFiles.get(i).isSame(targetFiles.get(i)));
        final String indexSlow = "index-slow";
        assertEquals(getSnapshot(repoName, otherCloneName).state(), SnapshotState.SUCCESS);
            cloneFuture.actionGet(TimeValue.timeValueSeconds(30L));
    public void testBackToBackClonesForIndexNotInCluster() throws Exception {
        final String targetSnapshot = "target-snapshot";
        createRepository(repoName, "mock");
    }
    ) {
        assertAcked(startDeleteSnapshot(repoName, sourceSnapshot).get());
        final String shallowSnapshot = "shallow-snapshot";
        final String repoName = "test-repo";
 * You may obtain a copy of the License at
    /**
        final String testIndex = "index-test";
        final String sourceSnapshot = "source-snapshot";
        }
        disableRepoConsistencyCheck("This test uses remote store repository");
        final String dataNode = internalCluster().startDataOnlyNode();
        String... indices
        for (ActionFuture<CreateSnapshotResponse> extraSnapshotFuture : extraSnapshotFutures) {
        final ActionFuture<AcknowledgedResponse> otherClone = startClone(repoName, sourceSnapshot, otherCloneName, indexName);
        assertEquals(status1.getStats().getTotalFileCount(), status2.getStats().getTotalFileCount());
        final String repoName = "test-repo";
        BlobStoreRepository repository,
import java.util.List;
import org.opensearch.common.unit.TimeValue;
        blockClusterManagerOnShardClone(repoName);
        assertThat(snapshotIds, hasSize(successfulSnapshotCount));
        assertEquals(status1.getStats().getTotalFileCount(), status2.getStats().getTotalFileCount());
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
            .setWaitForCompletion(true)
        final ActionFuture<AcknowledgedResponse> blockedClone = startClone(repoName, sourceSnapshot, cloneName, indexName);
     */
        assertEquals(getSnapshot(snapshotRepoName, snapshot).state(), SnapshotState.SUCCESS);
            IndexNotFoundException.class,
        try {
        final ActionFuture<AcknowledgedResponse> cloneFuture = startClone(repoName, sourceSnapshot, targetSnapshot, indexName);
        final String indexFast = "index-fast";
        final String shallowSnapshotRepoName = "shallow-snapshot-repo-name";
        final String repoName = "test-repo";
        waitForBlock(dataNode, repoName, TimeValue.timeValueSeconds(30L));
            extraSnapshotFutures.add(startFullSnapshot(repoName, "extra-snap-" + i));
        final String clusterManagerNode = internalCluster().getClusterManagerName();
            IndexShardSnapshot indexShardSnapshot = repository.loadShardSnapshot(
        final String indexName = "test-index";
        internalCluster().startDataOnlyNode(remoteStoreClusterSettings(remoteStoreRepoName, remoteStoreRepoPath));
        BlobStoreRepository repository,
        // large snapshot pool so blocked snapshot threads from cloning don't prevent concurrent snapshot finalizations
        final String sourceSnapshot = "source-snapshot";
    public void testFailsOnCloneMissingIndices() {
    public void testDeletePreventsClone() throws Exception {
        final ActionFuture<CreateSnapshotResponse> sourceSnapshotFuture = clusterManagerClient.admin()
    public void testShardClone() throws Exception {
        createFullSnapshot(repoName, sourceSnapshot);
        indexRandomDocs(indexName, randomIntBetween(20, 100));
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));
        assertSuccessful(snapshot2Future);
        indexRandomDocs(remoteStoreEnabledIndexName, randomIntBetween(5, 10));
        internalCluster().startClusterManagerOnlyNodes(3);
        createFullSnapshot(repoName, sourceSnapshot);
        for (ActionFuture<CreateSnapshotResponse> extraSnapshotFuture : extraSnapshotFutures) {
 * this work for additional information regarding copyright
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(LARGE_SNAPSHOT_POOL_SETTINGS);
        assertTrue(snapshotFiles.get(0).isSame(snapshotFiles.get(1)));
        createFullSnapshot(repoName, sourceSnapshot);
        ((MockRepository) internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class).repository(repoName))
import static org.hamcrest.Matchers.containsString;
            ExecutionException.class,
        final String testIndex = "index-test";
        expectThrows(SnapshotException.class, cloneFuture::actionGet);
        final int shardId = 0;
        String generation
        assertEquals(getSnapshot(repoName, cloneName).state(), SnapshotState.SUCCESS);
        createFullSnapshot(repoName, sourceSnapshot);
     * Assert that given {@link RepositoryData} contains exactly the given number of snapshots and all of them are successful.
    }
        final String indexName = "index-1";
        ensureYellow(indexName, remoteStoreEnabledIndexName);
        assertThat(snapshotFiles, hasSize(2));
        return startClone(dataNodeClient(), repoName, sourceSnapshot, targetSnapshot, indices);
        createFullSnapshot(repoName, sourceSnapshot);
    }
        internalCluster().startDataOnlyNode();
        String targetSnapshot,
        final String clusterManagerNode = internalCluster().getClusterManagerName();
                : "indexShardSnapshot should be an instance of BlobStoreIndexShardSnapshot";
        createIndexWithContent(indexSlow);
        createFullSnapshot(snapshotRepoName, snapshot);
        indexRandomDocs(indexName, randomIntBetween(20, 100));
        // verify that repeated cloning is idempotent
                .build()
        indexRandomDocs(remoteStoreEnabledIndexName, randomIntBetween(5, 10));
        for (int i = 0; i < extraClones; i++) {
            // snapshot on disconnect slowly enough for it to work out
            });
        );
        internalCluster().startDataOnlyNode();
        logger.info("--> wait for clone to start fully with shards assigned in the cluster state");
        createRepository(repoName, "mock");
        waitForBlock(dataNode, repoName, TimeValue.timeValueSeconds(30L));
            assertFalse(blockedSnapshot.isDone());
        internalCluster().startDataOnlyNode();
        internalCluster().startClusterManagerOnlyNode(remoteStoreClusterSettings(remoteStoreRepoName, remoteStoreRepoPath));
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshots;
        createFullSnapshot(repoName, snapshotName);
        assertAllSnapshotsSuccessful(getRepositoryData(repoName), cloneSucceeded ? 2 : 1);
                .generic()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
import org.opensearch.core.xcontent.NamedXContentRegistry;
        assertBusy(() -> assertEquals(0, getLockFilesInRemoteStore(remoteStoreEnabledIndexName, remoteStoreRepoName).length));
        final String shallowSnapshotRepoName = "shallow-snapshot-repo-name";
        final SnapshotIndexStatus status1 = status.get(0).getIndices().get(indexName);
    private ActionFuture<AcknowledgedResponse> startClone(
        RepositoryMetadata updatedRepositoryMetadata = clusterAdmin().prepareGetRepositories(snapshotRepoName).get().repositories().get(0);
        createFullSnapshot(repoName, sourceSnapshot);
        final Path repoPath = randomRepoPath();
    public void testCloneAfterRepoShallowSettingEnabled() throws Exception {
        assertAcked(cloneFuture1.get());
        // because of the cluster-manager failover
        assertAcked(cloneFuture.get());
        final String repoName = "test-repo";
import org.opensearch.test.OpenSearchIntegTestCase;
        final String remoteStoreRepoName = "remote-store-repo-name";
import org.opensearch.repositories.RepositoryShardId;
        awaitNumberOfSnapshotsInProgress(1 + extraClones);
        internalCluster().startClusterManagerOnlyNode();
            || getRepositoryData(repoName).getSnapshotIds().stream().anyMatch(snapshotId -> snapshotId.getName().equals(cloneName));
            assertThat(repositoryData.getSnapshotState(snapshotId), is(SnapshotState.SUCCESS));
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
        assertAcked(blockedClone.get());
    public void testStartCloneWithSuccessfulShardClonePendingFinalization() throws Exception {
        awaitNumberOfSnapshotsInProgress(1);
        waitForBlock(dataNode, repoName, TimeValue.timeValueSeconds(30L));
        final Path repoPath = randomRepoPath();
        assertAcked(blockedClone.get());
import org.opensearch.cluster.SnapshotsInProgress;
        createIndexWithContent(indexName);
        internalCluster().startClusterManagerOnlyNode();
        final ActionFuture<AcknowledgedResponse> cloneFuture = startCloneFromDataNode(repoName, sourceSnapshot, cloneName, testIndex);
    }
 * GitHub history for details.
        } finally {
        final String sourceSnapshot = "source-snapshot";
        assertEquals(getSnapshot(snapshotRepoName, snapshot).state(), SnapshotState.SUCCESS);
 * Unless required by applicable law or agreed to in writing,
        blockClusterManagerOnWriteIndexFile(repoName);
        final SnapshotInfo sourceSnapshotInfo = createFullSnapshot(repoName, sourceSnapshot);
        final String sourceSnapshot = "source-snapshot";
        createIndexWithContent(testIndex);
            .setBlockOnWriteShardLevelMeta();
        return PlainActionFuture.get(f -> repository.threadPool().generic().execute(ActionRunnable.supply(f, () -> {
        assertSuccessful(
        final String targetSnapshot = "target-snapshot";
        unblockNode(repoName, dataNode);
        return PlainActionFuture.get(
import org.opensearch.index.snapshots.blobstore.IndexShardSnapshot;
/*
        assertAcked(cloneFuture.get());
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));
        final String targetSnapshot = "target-snapshot";
        assertTrue(updatedRepositoryMetadata.settings().getAsBoolean(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), false));
    private void blockClusterManagerOnReadIndexMeta(String repoName) {
            .execute();
        );
        final String repoName = "test-repo";
        assertAcked(startClone(repoName, sourceSnapshot, targetSnapshot, indexSlow).get());
        final String otherCloneName = "other-clone";
        unblockNode(repoName, clusterManagerName);
import org.opensearch.action.ActionRunnable;
 * ownership. Elasticsearch licenses this file to you under
            );
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(LARGE_SNAPSHOT_POOL_SETTINGS);
        createRepository(repoName, "mock");
        createRepository(repoName, "mock");
        blockDataNode(repoName, dataNode);
                return entries.size() == 2 && entries.get(1).clones().isEmpty() == false;
        RepositoryMetadata updatedRepositoryMetadata = clusterAdmin().prepareGetRepositories(snapshotRepoName).get().repositories().get(0);
        final String shallowSnapshot1 = "snapshot1";
        final String remoteStoreRepoName = "remote-store-repo-name";
        createRepository(repoName, "mock");
            assertSuccessful(extraSnapshotFuture);
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot;
        createRepository(repoName, "mock");
        awaitNoMoreRunningOperations(internalCluster().getClusterManagerName());
        assertThat(ex.getMessage(), containsString("snapshot with the same name already exists"));
        assertThat(status, hasSize(2));
                "Can't clone index [" + getRepositoryData(repoName).resolveIndexId(testIndex) + "] because its snapshot was not successful."
            () -> startClone(shallowSnapshotRepoName, shallowSnapshot1, shallowSnapshot2, indexName, remoteStoreEnabledIndexName).get()
        final String indexFast = "index-fast";
        final String indexName = "index-1";
        Client client,
        final String snapshot = "snapshot";
    }
    }
        assertFalse(blockedClone.isDone());
        final String targetSnapshot = "target-snapshot";
        assertThat(ex.getMessage(), containsString("cannot delete snapshot while it is being cloned"));
                .put(LARGE_SNAPSHOT_POOL_SETTINGS)
        }
        expectThrows(SnapshotException.class, cloneFuture::actionGet);
import org.opensearch.common.UUIDs;
        final String repoName = "test-repo";
        createRepository(repoName, "mock");
        createRepository(shallowSnapshotRepoName, "fs", snapshotRepoSettingsForShallowCopy(shallowSnapshotRepoPath));
    public void testStartCloneWithSuccessfulShardSnapshotPendingFinalization() throws Exception {
            assertAcked(admin().indices().prepareDelete(indexName));
        final String remoteStoreEnabledIndexName = "remote-index-1";
import java.nio.file.Path;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final String sourceSnapshot = "source-snapshot";
        unblockNode(repoName, clusterManagerName);
        final String targetSnapshot1 = "target-snapshot";
        assertEquals(status1.getStats().getTotalSize(), status2.getStats().getTotalSize());
        client().admin().cluster().prepareHealth().setWaitForNoInitializingShards(true).setWaitForNoRelocatingShards(true).get();
        assertThat(sourceSnapshotFuture.get().getSnapshotInfo().state(), is(SnapshotState.PARTIAL));
        RepositoryShardId repositoryShardId,
        final String repoName = "test-repo";
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));
            .execute();
                            generation,
        internalCluster().startDataOnlyNode();
        final Path remoteStorePath = randomRepoPath().toAbsolutePath();
        final BlobStoreRepository repository = (BlobStoreRepository) internalCluster().getCurrentClusterManagerNodeInstance(
        awaitNumberOfSnapshotsInProgress(1);
        final ActionFuture<AcknowledgedResponse> cloneFuture = startClone(repoName, sourceSnapshot, targetSnapshot, indexName);
    ) {
        for (int i = 0; i < fileCount; i++) {
 * specific language governing permissions and limitations
        assertAcked(otherClone.get());
            // ignored, most of the time we will throw here but we could randomly run into a situation where the data node retries the
        if (extraSnapshots > 0) {
        indexRandomDocs(indexName, randomIntBetween(20, 100));
            .setBlockOnReadIndexMeta();
        createRepository(repoName, "fs", repoPath);
        final ActionFuture<CreateSnapshotResponse> snapshot2Future = startFullSnapshotBlockedOnDataNode("snapshot-2", repoName, dataNode);
        assertSuccessful(snapshotFuture);
        );
            f -> repository.threadPool()
        final String repoName = "repo-name";
            ConcurrentSnapshotExecutionException.class,
        final String sourceSnapshot = "source-snapshot";
    private static BlobStoreIndexShardSnapshots readShardGeneration(
        } catch (SnapshotException sne) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                            NamedXContentRegistry.EMPTY
        awaitClusterManagerFinishRepoOperations();
                )
    }
        String repoName,
        ensureYellow(indexName, remoteStoreEnabledIndexName);
        blockClusterManagerOnWriteIndexFile(repoName);
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));
    }
        final String indexName = "test-idx";
                            repository.shardContainer(repositoryShardId.index(), repositoryShardId.shardId()),
            sne.getMessage(),
 *    http://www.apache.org/licenses/LICENSE-2.0
            sourceSnapshotInfo.snapshotId()
        final String targetSnapshot = "target-snapshot";
        blockDataNode(repoName, dataNode);
        final String repoName = "test-repo";
        blockNodeOnAnyFiles(repoName, dataNode);
        assertAcked(startClone(snapshotRepoName, snapshot, targetSnapshot, indexName, remoteStoreEnabledIndexName).get());
        final String sourceSnapshot = "source-snapshot";
            SnapshotException.class,
        assertAcked(startClone(snapshotRepoName, snapshot, targetSnapshot, indexName, remoteStoreEnabledIndexName).get());
