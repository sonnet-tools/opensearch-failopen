    }  
        final SnapshotIndexStatus status2 = status.get(1).getIndices().get(indexName);
        final String snapshotRepoName = "snapshot-repo-name";
        createFullSnapshot(repoName, sourceSnapshot);  
    }
        final ActionFuture<CreateSnapshotResponse> blockedSnapshot = startFullSnapshot(repoName, "snap-blocked");
        createFullSnapshot(repoName, snapshotName);
            client().admin().cluster().prepareHealth().setWaitForNoInitializingShards(true).setWaitForNoRelocatingShards(true).get();  
        }
    }
        createIndexWithContent(testIndex);
import org.opensearch.transport.client.Client;
        assertThat(status, hasSize(2));
        String generation
import static org.hamcrest.Matchers.hasSize;
        assertEquals(getSnapshot(repoName, cloneName).state(), SnapshotState.SUCCESS);  
            .setBlockOnReadIndexMeta();  
        final String indexSlow = "index-slow";
        assertEquals(fileCount, targetFiles.size());  
        final String testIndex = "index-test";  
        final ActionFuture<CreateSnapshotResponse> otherSnapshot = startFullSnapshot(repoName, "other-snapshot");
        createFullSnapshot(repoName, sourceSnapshot);
        assertFalse(deleteFuture.isDone());
        createFullSnapshot(repoName, sourceSnapshot);
        RepositoryMetadata updatedRepositoryMetadata = clusterAdmin().prepareGetRepositories(snapshotRepoName).get().repositories().get(0);
        createRepository(repoName, "mock");  
            assertSuccessful(extraSnapshotFuture);
        for (ActionFuture<AcknowledgedResponse> extraCloneFuture : extraCloneFutures) {
        final String repoName = "test-repo";
            .setBlockOnWriteShardLevelMeta();
        assertEquals(status1.getStats().getTotalSize(), status2.getStats().getTotalSize());  
        assertBusy(() -> assertEquals(0, getLockFilesInRemoteStore(remoteStoreEnabledIndexName, remoteStoreRepoName).length));
        final String repoName = "repo-name";
        createFullSnapshot(snapshotRepoName, snapshot);
        return client.admin().cluster().prepareCloneSnapshot(repoName, sourceSnapshot, targetSnapshot).setIndices(indices).execute();
        })));
    }
    ) {
        internalCluster().startDataOnlyNode();
            .setSnapshots(sourceSnapshot, targetSnapshot)
        assertAcked(deleteFuture.get());
    public void testClonePreventsSnapshotDelete() throws Exception {
        final String targetSnapshot = "target-snapshot";
            () -> startDeleteSnapshot(repoName, sourceSnapshot).actionGet()
        createFullSnapshot(repoName, sourceSnapshot);
        awaitNumberOfSnapshotsInProgress(1);
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
        createIndexWithRandomDocs(indexFast, randomIntBetween(20, 100));
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(LARGE_SNAPSHOT_POOL_SETTINGS);
        final String indexName = "test-index";  
        internalCluster().restartNode(clusterManagerNode);
        assertAllSnapshotsSuccessful(getRepositoryData(repoName), 1);
        final String cloneName = "target-snapshot";  
        String sourceSnapshot,  
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));
            cloneSucceeded = true;  
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, remoteStoreRepoName).length == 0);
        createRepository(repoName, "mock");
        assertEquals(getSnapshot(snapshotRepoName, snapshot).state(), SnapshotState.SUCCESS);
        );
        final BlobStoreIndexShardSnapshot sourceShardSnapshot = readShardSnapshot(  
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));  
            .cluster()
        final String shallowSnapshotRepoName = "shallow-snapshot-repo-name";
        createFullSnapshot(repoName, sourceSnapshot);
        final Path shallowSnapshotRepoPath = randomRepoPath();  
        assertFalse(blockedClone.isDone());  
        createRepository(repoName, "mock");
        for (SnapshotId snapshotId : snapshotIds) {
        );
import org.opensearch.common.settings.Settings;
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));  
            createIndexWithContent(indexBlocked);  
        final ActionFuture<AcknowledgedResponse> otherClone = startClone(repoName, sourceSnapshot, otherCloneName, indexName);
        }
        final String otherCloneName = "other-clone";  
        assertAcked(startDeleteSnapshot(repoName, sourceSnapshot).get());
        awaitNumberOfSnapshotsInProgress(1);
        if (extraSnapshots > 0) {
        final IndexId indexId = repositoryData.resolveIndexId(indexName);  
        createIndexWithContent(indexName);
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));
        String targetSnapshot,
        // verify that repeated cloning is idempotent  
 * the Apache License, Version 2.0 (the "License"); you may
    ) {  
        for (int i = 0; i < extraClones; i++) {
        final String newShardGeneration = PlainActionFuture.get(
        assertAllSnapshotsSuccessful(getRepositoryData(repoName), 2);
        assertAllSnapshotsSuccessful(getRepositoryData(repoName), cloneSucceeded ? 2 : 1);  
        final String sourceSnapshot = "source-snapshot";  
        final String repoName = "test-repo";
        final String snapshotName = "snapshot";
        final String sourceSnapshot = "source-snapshot";
        internalCluster().startClusterManagerOnlyNode(remoteStoreClusterSettings(remoteStoreRepoName, remoteStoreRepoPath));  
            );
        createIndexWithContent(indexName);
        assertThat(cloneFuture.isDone(), is(false));
        logger.info("--> wait for clone to start fully with shards assigned in the cluster state");
        internalCluster().startDataOnlyNode();  
            cloneFuture.actionGet(TimeValue.timeValueSeconds(30L));
        unblockNode(repoName, clusterManagerNode);
 *  
    public void testCloneAfterRepoShallowSettingEnabled() throws Exception {
import org.opensearch.cluster.metadata.RepositoryMetadata;
        }  
                snapshotId  
        final ActionFuture<AcknowledgedResponse> cloneFuture = startCloneFromDataNode(repoName, sourceSnapshot, targetSnapshot, testIndex);
 * Licensed to Elasticsearch under one or more contributor  
        BlobStoreRepository repository,
import java.util.ArrayList;
        final String targetSnapshot = "target-snapshot";
    }
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode();
 * under the License.  
    }
    public void testStartSnapshotWithSuccessfulShardClonePendingFinalization() throws Exception {
    public void testDoesNotStartOnBrokenSourceSnapshot() throws Exception {
        ensureYellow(indexName, remoteStoreEnabledIndexName);
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);  
            () -> startClone(clusterManagerClient, repoName, sourceSnapshot, "target-snapshot", testIndex).actionGet(
        final ActionFuture<CreateSnapshotResponse> snapshot2Future = startFullSnapshotBlockedOnDataNode("snapshot-2", repoName, dataNode);
        // Updating the snapshot repository flag to enable shallow snapshots
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));
import org.opensearch.index.snapshots.blobstore.SnapshotFiles;
        final String indexName = "index-1";
        assertAcked(startClone(repoName, sourceSnapshot, targetSnapshot, indexName).get());
        String repoName,
        awaitNoMoreRunningOperations(internalCluster().getClusterManagerName());
        blockNodeOnAnyFiles(repoName, dataNode);  
    }
        expectThrows(SnapshotException.class, cloneFuture::actionGet);
        internalCluster().startDataOnlyNode();
    }
        Client client,
        final String indexBlocked = "index-blocked";
        final String targetSnapshot = "target-snapshot";
        assertEquals(getSnapshot(snapshotRepoName, targetSnapshot).isRemoteStoreIndexShallowCopyEnabled(), false);  
        );
 * Unless required by applicable law or agreed to in writing,
        } finally {  
        internalCluster().startDataOnlyNode(remoteStoreClusterSettings(remoteStoreRepoName, remoteStoreRepoPath));
        final String snapshot = "snapshot";
                .put(remoteStoreClusterSettings(remoteStoreRepoName, remoteStorePath))
import org.opensearch.repositories.RepositoryShardId;  
        final ActionFuture<AcknowledgedResponse> clone = startClone(repoName, sourceSnapshot, cloneName, indexName);  
        assertBusy(() -> assertEquals(1, getLockFilesInRemoteStore(remoteStoreEnabledIndexName, remoteStoreRepoName).length));
import org.opensearch.common.UUIDs;
    private void blockClusterManagerOnShardClone(String repoName) {  
        client().admin().cluster().prepareHealth().setWaitForNoInitializingShards(true).setWaitForNoRelocatingShards(true).get();  
        }
    }  
        final String testIndex = "index-test";
        indexRandomDocs(remoteStoreEnabledIndexName, randomIntBetween(5, 10));
        final String sourceSnapshot = "source-snapshot";  
        final String indexName = "test-idx";
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
        for (ActionFuture<AcknowledgedResponse> extraCloneFuture : extraCloneFutures) {  
        final ActionFuture<AcknowledgedResponse> cloneFuture = startCloneFromDataNode(repoName, sourceSnapshot, cloneName, testIndex);
        RepositoryMetadata updatedRepositoryMetadata = clusterAdmin().prepareGetRepositories(snapshotRepoName).get().repositories().get(0);  
            assertFalse(blockedSnapshot.isDone());
            ConcurrentSnapshotExecutionException.class,
        disableRepoConsistencyCheck("This test uses remote store repository");
        assertEquals(newShardGeneration, newShardGeneration2);
 * GitHub history for details.
        internalCluster().startDataOnlyNode();
        final SnapshotId targetSnapshotId = new SnapshotId("target-snapshot", UUIDs.randomBase64UUID(random()));
        awaitNumberOfSnapshotsInProgress(2);
        final Client clusterManagerClient = internalCluster().clusterManagerClient();  
        final String repoName = "test-repo";
        final String sourceSnapshot = shallowSnapshot;  
import org.opensearch.action.ActionRunnable;  
    public void testLongRunningSnapshotAllowsConcurrentClone() throws Exception {
        return PlainActionFuture.get(f -> repository.threadPool().generic().execute(ActionRunnable.supply(f, () -> {  
/*  
        assertSuccessful(blockedSnapshot);
            .getSnapshots();
    }
            .execute();
        final String repoName = "repo-name";  
        RepositoryShardId repositoryShardId,  
        // large snapshot pool so blocked snapshot threads from cloning don't prevent concurrent snapshot finalizations
        awaitClusterManagerFinishRepoOperations();  
        final Path snapshotRepoPath = randomRepoPath();
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, remoteStoreRepoName).length == 2);  
public class CloneSnapshotIT extends AbstractSnapshotIntegTestCase {  
        assertEquals(getSnapshot(snapshotRepoName, targetSnapshot).isRemoteStoreIndexShallowCopyEnabled(), true);
        final String sourceSnapshot = "source-snapshot";
        internalCluster().startDataOnlyNode();  
        indexRandomDocs(remoteStoreEnabledIndexName, randomIntBetween(5, 10));  
        final String shallowSnapshot2 = "snapshot2";
        assertAcked(cloneFuture.get());  
            .setWaitForCompletion(true)
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        }  
        unblockNode(repoName, clusterManagerName);
        assertThat(targetShardSnapshot.incrementalFileCount(), is(0));
        createFullSnapshot(shallowSnapshotRepoName, shallowSnapshot);  
            assertAcked(admin().indices().prepareDelete(indexName));
                            repository.shardContainer(repositoryShardId.index(), repositoryShardId.shardId()),
        final String remoteStoreRepoName = "remote-store-repo-name";
 * KIND, either express or implied.  See the License for the
        createIndexWithContent(testIndex);
    public void testCloneAfterRepoShallowSettingDisabled() throws Exception {  
}
        SnapshotId snapshotId
        assertEquals(getSnapshot(repoName, otherCloneName).state(), SnapshotState.SUCCESS);
    private void blockClusterManagerOnReadIndexMeta(String repoName) {
        assertThat(cloneFuture1.isDone(), is(false));
        );
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshots;  
        for (ActionFuture<CreateSnapshotResponse> extraSnapshotFuture : extraSnapshotFutures) {  
        awaitNumberOfSnapshotsInProgress(1 + extraClones + extraSnapshots);
        final SnapshotIndexStatus status2 = status.get(1).getIndices().get(indexName);
        final String repoName = "test-repo";
        createRepository(repoName, "mock");
        assertThat(snapshotIds, hasSize(successfulSnapshotCount));
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus;  
        assertAcked(cloneFuture.get());
            repository,
        final String repoName = "test-repo";  
        blockDataNode(repoName, dataNode);
        createFullSnapshot(snapshotRepoName, snapshot);  
        internalCluster().startClusterManagerOnlyNode();
        indexRandomDocs(remoteStoreEnabledIndexName, randomIntBetween(5, 10));
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotIndexStatus;
        logger.info("Lock files count: {}", getLockFilesInRemoteStore(remoteStoreEnabledIndexName, remoteStoreRepoName).length);  
        try {
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(LARGE_SNAPSHOT_POOL_SETTINGS);
        assertAcked(startClone(snapshotRepoName, snapshot, targetSnapshot, indexName, remoteStoreEnabledIndexName).get());
        ExecutionException ex = expectThrows(
        final BlobStoreRepository repository = (BlobStoreRepository) internalCluster().getCurrentClusterManagerNodeInstance(
    }  
    private static ActionFuture<AcknowledgedResponse> startClone(  
        internalCluster().startClusterManagerOnlyNodes(3);
        blockClusterManagerOnWriteIndexFile(repoName);
        internalCluster().startDataOnlyNode();  
import org.opensearch.common.unit.TimeValue;
        final int shardId = 0;
        assertSuccessful(snapshot2Future);
        indexRandomDocs(indexName, randomIntBetween(20, 100));
        createRepository(snapshotRepoName, "fs", snapshotRepoPath);
                repository.shardContainer(repositoryShardId.index(), repositoryShardId.shardId()),
        final String cloneName = "clone-blocked";
        createIndexWithRandomDocs(indexFast, randomIntBetween(20, 100));
        for (int i = 0; i < fileCount; i++) {
        final Path remoteStoreRepoPath = randomRepoPath();  
        );  
        final String snapshotRepoName = "snapshot-repo-name";  
            f -> repository.cloneShardSnapshot(sourceSnapshotInfo.snapshotId(), targetSnapshotId, repositoryShardId, newShardGeneration, f)
    }
        final String repoName = "repo-name";  
        createRepository(repoName, "fs", repoPath);
        createRepository(shallowSnapshotRepoName, "fs", snapshotRepoSettingsForShallowCopy(shallowSnapshotRepoPath));
        String sourceSnapshot,
    }
        }
        final String repoName = "repo-name";
        createRepository(shallowSnapshotRepoName, "fs", snapshotRepoSettingsForShallowCopy(shallowSnapshotRepoPath));  
import java.nio.file.Path;  
            assertFalse(extraCloneFuture.isDone());
    public void testDeletePreventsClone() throws Exception {
 */
        final String indexName = "index-1";
        createRepository(repoName, "mock");
        internalCluster().startDataOnlyNode();
            .prepareCreateSnapshot(repoName, sourceSnapshot)  
        assertThat(status, hasSize(2));
            () -> startClone(repoName, snapshotName, "target-snapshot", "does-not-exist").actionGet()
        String repoName,
        final String repoName = "repo-name";
        assertFalse(cloneFuture.isDone());  
        final String cloneName = "clone";
        assertFalse(updatedRepositoryMetadata.settings().getAsBoolean(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), false));
        awaitNoMoreRunningOperations();  
     * Assert that given {@link RepositoryData} contains exactly the given number of snapshots and all of them are successful.  
            // ignored, most of the time we will throw here but we could randomly run into a situation where the data node retries the
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));
        internalCluster().startClusterManagerOnlyNode(LARGE_SNAPSHOT_POOL_SETTINGS);
        createRepository(repoName, "mock");  
        assertFalse(blockedClone.isDone());  
        final String remoteStoreEnabledIndexName = "remote-index-1";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (randomBoolean()) {  
        internalCluster().startClusterManagerOnlyNode();  
    private ActionFuture<AcknowledgedResponse> startClone(  
        try {
        expectThrows(SnapshotException.class, cloneFuture::actionGet);
        return PlainActionFuture.get(  
        final int extraClones = randomIntBetween(1, 5);  
            .getSnapshots();
        blockClusterManagerFromFinalizingSnapshotOnIndexFile(repoName);
        final Path repoPath = randomRepoPath();
        final SnapshotInfo sourceSnapshotInfo = createFullSnapshot(repoName, sourceSnapshot);  
        // large snapshot pool so blocked snapshot threads from cloning don't prevent concurrent snapshot finalizations  
        final Path snapshotRepoPath = randomRepoPath();
        final String indexName = "index-1";
        createFullSnapshot(shallowSnapshotRepoName, shallowSnapshot2);
            ExecutionException.class,
        assertSuccessful(snapshotFuture);
        blockClusterManagerOnWriteIndexFile(repoName);  
        disableRepoConsistencyCheck("This test uses remote store repository");
    public void testBackToBackClonesForIndexNotInCluster() throws Exception {
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
        final ActionFuture<AcknowledgedResponse> blockedClone = startClone(repoName, sourceSnapshot, cloneName, indexName);  
    }
    public void testLongRunningCloneAllowsConcurrentSnapshot() throws Exception {
        assertAcked(otherClone.get());
        unblockNode(repoName, clusterManagerNode);  
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
        assertEquals(status1.getStats().getTotalFileCount(), status2.getStats().getTotalFileCount());
        final String dataNode = internalCluster().startDataOnlyNode();
        final String indexFast = "index-fast";
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
        assertThat(ex.getMessage(), containsString("cannot delete snapshot while it is being cloned"));  
        assertAcked(admin().indices().prepareDelete(indexBlocked).get());
        assertAcked(blockedClone.get());
        assertEquals(status1.getStats().getTotalFileCount(), status2.getStats().getTotalFileCount());
        waitForBlock(dataNode, repoName, TimeValue.timeValueSeconds(30L));  
    private static BlobStoreIndexShardSnapshot readShardSnapshot(
                        f,
        createFullSnapshot(repoName, sourceSnapshot);
        final List<SnapshotStatus> status = clusterAdmin().prepareSnapshotStatus(repoName)
        String repoName,
 * The OpenSearch Contributors require contributions made to  
        final String dataNode = internalCluster().startDataOnlyNode();
            assertTrue(sourceFiles.get(i).isSame(targetFiles.get(i)));
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(LARGE_SNAPSHOT_POOL_SETTINGS);  
                        () -> BlobStoreRepository.INDEX_SHARD_SNAPSHOTS_FORMAT.read(  
    }  
        final Path remoteStoreRepoPath = randomRepoPath();
        final String clusterManagerNode = internalCluster().getClusterManagerName();  
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));
 * license agreements. See the NOTICE file distributed with
        awaitNumberOfSnapshotsInProgress(1 + extraClones);
        ((MockRepository) internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class).repository(repoName))
    ) {
 * software distributed under the License is distributed on an
        );  
        final ActionFuture<AcknowledgedResponse> cloneFuture = startClone(repoName, sourceSnapshot, targetSnapshot, indexName);
        expectThrows(  
     */
    ) {
        }  
            () -> startClone(repoName, sourceSnapshot, targetSnapshot, indexName).actionGet()
        awaitNumberOfSnapshotsInProgress(1);
        internalCluster().startClusterManagerOnlyNode();  
        createFullSnapshot(shallowSnapshotRepoName, shallowSnapshot1);
    private ActionFuture<AcknowledgedResponse> startCloneFromDataNode(  
        assertThat(ex.getMessage(), containsString("cannot clone from snapshot that is being deleted"));
        final String dataNode = internalCluster().startDataOnlyNode();
        createFullSnapshot(repoName, sourceSnapshot);
        final String newShardGeneration2 = PlainActionFuture.get(
        createRepository(repoName, "mock");
        assertThat(snapshotFuture.isDone(), is(false));
            containsString(
        final String clusterManagerNode = internalCluster().getClusterManagerName();
                .put(LARGE_SNAPSHOT_POOL_SETTINGS)
import org.opensearch.test.OpenSearchIntegTestCase;  
        blockClusterManagerOnShardClone(repoName);  
        final List<SnapshotFiles> snapshotFiles = shardMetadata.snapshots();
        final String remoteStoreRepoName = "remote-store-repo-name";
        final String sourceSnapshot = "source-snapshot";
        internalCluster().startClusterManagerOnlyNode();  
        createRepository(repoName, "mock");
            )  
        final String shallowSnapshot = "shallow-snapshot";
        // large snapshot pool so blocked snapshot threads from cloning don't prevent concurrent snapshot finalizations
        createRepository(repoName, "mock");
    public void testClusterManagerFailoverDuringCloneStep1() throws Exception {  
/*
        final ActionFuture<AcknowledgedResponse> cloneFuture = startClone(repoName, sourceSnapshot, targetSnapshot, indexSlow);
import org.opensearch.index.IndexNotFoundException;
            assertAcked(extraCloneFuture.get());
        RepositoryShardId repositoryShardId,  
        assertAcked(blockedClone.get());
        internalCluster().restartNode(dataNode);
        final String sourceSnapshot = "source-snapshot";
        final SnapshotIndexStatus status1 = status.get(0).getIndices().get(indexName);  
import java.util.Collection;
        awaitNumberOfSnapshotsInProgress(1);  
        if (randomBoolean()) {
        final List<ActionFuture<AcknowledgedResponse>> extraCloneFutures = new ArrayList<>(extraClones);
    public void testConcurrentCloneAndSnapshot() throws Exception {  
 * compatible open source license.
        createIndexWithContent(indexSlow);  
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
import java.util.concurrent.ExecutionException;
        assertBusy(() -> assertEquals(2, getLockFilesInRemoteStore(remoteStoreEnabledIndexName, remoteStoreRepoName).length));
                "Can't clone index [" + getRepositoryData(repoName).resolveIndexId(testIndex) + "] because its snapshot was not successful."
        final String shallowSnapshot1 = "snapshot1";
        final BlobStoreIndexShardSnapshots shardMetadata = readShardGeneration(repository, repositoryShardId, newShardGeneration);
        assertThat(snapshotFiles, hasSize(2));  
        final String indexName = "index-1";
import org.opensearch.repositories.RepositoriesService;
        internalCluster().startDataOnlyNode(remoteStoreClusterSettings(remoteStoreRepoName, remoteStoreRepoPath));
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();  
        blockClusterManagerOnShardClone(repoName);
        createFullSnapshot(repoName, sourceSnapshot);  
            IndexNotFoundException.class,
        awaitNumberOfSnapshotsInProgress(1);  
        final String remoteStoreEnabledIndexName = "remote-index-1";
        final String indexName = "index-1";
            assertFalse(extraSnapshotFuture.isDone());
        internalCluster().startDataOnlyNode();  
        );
        assertSuccessful(otherSnapshot);
        disableRepoConsistencyCheck("This test uses remote store repository");  
        final String sourceSnapshot = "source-snapshot";
        assertAcked(clone.get());
 *    http://www.apache.org/licenses/LICENSE-2.0
        final RepositoryData repositoryData = getRepositoryData(repoName);
        indexRandomDocs(indexName, randomIntBetween(20, 100));  
        internalCluster().startDataOnlyNode();
import org.opensearch.snapshots.mockstore.MockRepository;
        assertAcked(startClone(repoName, sourceSnapshot, targetSnapshot, indexSlow).get());  
        final BlobStoreIndexShardSnapshot targetShardSnapshot = readShardSnapshot(repository, repositoryShardId, targetSnapshotId);
        final String snapshotRepoName = "snapshot-repo-name";
        blockClusterManagerOnWriteIndexFile(repoName);
        // large snapshot pool so blocked snapshot threads from cloning don't prevent concurrent snapshot finalizations
        final String targetSnapshot1 = "target-snapshot";  
 */
        final String remoteStoreEnabledIndexName = "remote-index-1";
            Settings.builder()  
    }
    }  
        final String indexName = "test-idx";
        internalCluster().startDataOnlyNode();
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot;
        unblockNode(repoName, clusterManagerName);
        return startClone(dataNodeClient(), repoName, sourceSnapshot, targetSnapshot, indices);  
        final String indexName = "index-1";  
        assertEquals(getSnapshot(snapshotRepoName, snapshot).state(), SnapshotState.SUCCESS);  
            .setIndices(indexFast)  
        internalCluster().startClusterManagerOnlyNode(LARGE_SNAPSHOT_POOL_SETTINGS);  
            || getRepositoryData(repoName).getSnapshotIds().stream().anyMatch(snapshotId -> snapshotId.getName().equals(cloneName));
import org.opensearch.repositories.IndexId;  
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        indexRandomDocs(indexName, randomIntBetween(20, 100));  
        final String targetSnapshot = "target-snapshot";  
        unblockNode(repoName, clusterManagerName);  
        final ActionFuture<AcknowledgedResponse> blockedClone = startClone(repoName, sourceSnapshot, cloneName, indexName);  
            RepositoriesService.class  
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));
                            generation,
        createFullSnapshot(repoName, sourceSnapshot);
        final String remoteStoreRepoName = "remote-store-repo-name";  
        internalCluster().startDataOnlyNode();
        final String sourceSnapshot = "source-snapshot";
    }
    }  
            // snapshot on disconnect slowly enough for it to work out  
        createRepository(repoName, "fs", repoPath);
        final String testIndex = "index-test";
        boolean cloneSucceeded = false;  
        disableRepoConsistencyCheck("This test uses remote store repository");
            sourceSnapshotInfo.snapshotId()  
            )  
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(LARGE_SNAPSHOT_POOL_SETTINGS);
        final SnapshotIndexStatus status1 = status.get(0).getIndices().get(indexName);  
        final String snapshot = "snapshot";  
        createFullSnapshot(snapshotRepoName, snapshot);
            assert indexShardSnapshot instanceof BlobStoreIndexShardSnapshot
            f -> repository.threadPool()
        blockClusterManagerOnWriteIndexFile(repoName);
        final List<BlobStoreIndexShardSnapshot.FileInfo> sourceFiles = sourceShardSnapshot.indexFiles();  
import org.opensearch.repositories.RepositoryData;
        String... indices
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        final Path shallowSnapshotRepoPath = randomRepoPath();
        internalCluster().startClusterManagerOnlyNode(remoteStoreClusterSettings(remoteStoreRepoName, remoteStoreRepoPath));
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));  
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));
    public void testCloneSnapshotIndex() throws Exception {
    }  
        internalCluster().startClusterManagerOnlyNode();
    public void testStartCloneWithSuccessfulShardClonePendingFinalization() throws Exception {
        assertSuccessful(
        final List<ActionFuture<CreateSnapshotResponse>> extraSnapshotFutures = new ArrayList<>(extraSnapshots);  
        final String repoName = "test-repo";
        unblockNode(repoName, dataNode);
        final String targetSnapshot = "target-snapshot";
        BlobStoreRepository repository,
        final ActionFuture<AcknowledgedResponse> cloneFuture = startCloneFromDataNode(repoName, sourceSnapshot, targetSnapshot, testIndex);  
        final String indexName = "index-1";
package org.opensearch.snapshots;
                    ActionRunnable.supply(
        final String indexSlow = "index-slow";
    }
                : "indexShardSnapshot should be an instance of BlobStoreIndexShardSnapshot";  
        } catch (SnapshotException sne) {
        assertTrue(snapshotFiles.get(0).isSame(snapshotFiles.get(1)));
/*
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            return (BlobStoreIndexShardSnapshot) indexShardSnapshot;
        client().admin().cluster().prepareHealth().setWaitForNoInitializingShards(true).setWaitForNoRelocatingShards(true).get();  
        final String indexFast = "index-fast";
        final String shallowSnapshotRepoName = "shallow-snapshot-repo-name";
import static org.hamcrest.Matchers.is;  
                final List<SnapshotsInProgress.Entry> entries = clusterState.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY)
                        )
            ConcurrentSnapshotExecutionException.class,  
        internalCluster().startDataOnlyNode();  
        String... indices
            .setSnapshots(sourceSnapshot, targetSnapshot)
        final Collection<SnapshotId> snapshotIds = repositoryData.getSnapshotIds();  
        createRepository(snapshotRepoName, "fs", snapshotRepoPath);  
 * not use this file except in compliance with the License.
        createRepository(repoName, "mock");  
    public void testShardClone() throws Exception {
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));  
        unblockNode(repoName, clusterManagerName);
        indexRandomDocs(indexName, randomIntBetween(20, 100));
        createRepository(repoName, "mock");
        final Path snapshotRepoPath = randomRepoPath();
            repositoryShardId,
            extraCloneFutures.add(startClone(repoName, sourceSnapshot, "target-snapshot-" + i, indexBlocked));  
        );  
        assertEquals(status1.getStats().getTotalSize(), status2.getStats().getTotalSize());  
        createIndexWithContent(testIndex);
    public void testShallowCloneNameAvailability() throws Exception {
        final String targetSnapshot = "target-snapshot";
    public void testClusterManagerFailoverDuringCloneStep2() throws Exception {  
            IndexShardSnapshot indexShardSnapshot = repository.loadShardSnapshot(
        awaitNumberOfSnapshotsInProgress(1);
        assertThat(ex.getMessage(), containsString("snapshot with the same name already exists"));
        createIndexWithContent(indexName);
        awaitNoMoreRunningOperations(internalCluster().getClusterManagerName());  
        ).repository(repoName);
        }
 * specific language governing permissions and limitations
import static org.hamcrest.Matchers.containsString;
        final String indexName = "test-idx";
import org.opensearch.repositories.blobstore.BlobStoreRepository;
import java.util.List;  
        cloneSucceeded = cloneSucceeded
        assertAcked(cloneFuture.get());
 */  
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));
 *
            });
        final ActionFuture<AcknowledgedResponse> deleteFuture = startDeleteSnapshot(repoName, sourceSnapshot);
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));  
        waitForBlock(clusterManagerNode, repoName, TimeValue.timeValueSeconds(30L));  
        awaitNumberOfSnapshotsInProgress(1);
        waitForBlock(dataNode, repoName, TimeValue.timeValueSeconds(30L));  
    public void testExceptionDuringShardClone() throws Exception {
            sne.getMessage(),  
        final String dataNode = internalCluster().startDataOnlyNode();  
        for (int i = 0; i < extraSnapshots; i++) {
        final Path remoteStorePath = randomRepoPath().toAbsolutePath();
        final String repoName = "test-repo";
        final Path remoteStoreRepoPath = randomRepoPath();  
                TimeValue.timeValueSeconds(30L)
        awaitNumberOfSnapshotsInProgress(1);
        final String currentShardGen = repositoryData.shardGenerations().getShardGen(indexId, shardId);  
        final String sourceSnapshot = "source-snapshot";
import org.opensearch.index.snapshots.blobstore.IndexShardSnapshot;
        final RepositoryShardId repositoryShardId = new RepositoryShardId(indexId, shardId);
        );
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();  
        );
        final String targetSnapshot = "target-snapshot";  
        indexRandomDocs(remoteStoreEnabledIndexName, randomIntBetween(5, 10));
        final String sourceSnapshot = "source-snapshot";
        internalCluster().startDataOnlyNode(remoteStoreClusterSettings(remoteStoreRepoName, remoteStorePath));
            () -> startClone(shallowSnapshotRepoName, shallowSnapshot1, shallowSnapshot2, indexName, remoteStoreEnabledIndexName).get()  
        awaitNoMoreRunningOperations(clusterManagerName);
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = clusterAdmin().prepareCreateSnapshot(repoName, "fast-snapshot")
                .execute(  
    private static BlobStoreIndexShardSnapshots readShardGeneration(
        createFullSnapshot(repoName, sourceSnapshot);
        awaitClusterManagerFinishRepoOperations();
        }  
        unblockNode(repoName, clusterManagerNode);
        );  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        createFullSnapshot(repoName, sourceSnapshot);  
            .get()  
        createRepository(repoName, "fs");
            unblockNode(repoName, clusterManagerName);
        blockDataNode(repoName, dataNode);
        internalCluster().startDataOnlyNode(remoteStoreClusterSettings(remoteStoreRepoName, remoteStoreRepoPath));
        }  
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));
        waitForBlock(dataNode, repoName, TimeValue.timeValueSeconds(30L));
        final List<SnapshotStatus> status = clusterAdmin().prepareSnapshotStatus(repoName)
        ((MockRepository) internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class).repository(repoName))
        final String cloneName = "clone-blocked";
        assertAcked(startClone(shallowSnapshotRepoName, sourceSnapshot, targetSnapshot, indexName, remoteStoreEnabledIndexName).get());
        indexRandomDocs(indexName, randomIntBetween(20, 100));  
        createFullSnapshot(repoName, sourceSnapshot);
        final ActionFuture<AcknowledgedResponse> cloneFuture1 = startClone(repoName, sourceSnapshot, targetSnapshot1, indexBlocked);
    public void testFailsOnCloneMissingIndices() {  
            createIndexWithContent("test-idx");  
                            NamedXContentRegistry.EMPTY  
        assertAcked(cloneFuture1.get());
        final String repoName = "test-repo";
        unblockNode(repoName, dataNode);  
        createIndexWithContent(indexBlocked);
        createIndexWithContent(testIndex);  
import org.opensearch.action.support.PlainActionFuture;
        final Path repoPath = randomRepoPath();  
        if (randomBoolean()) {
    }
        assertAcked(startClone(snapshotRepoName, snapshot, targetSnapshot, indexName, remoteStoreEnabledIndexName).get());
        createRepository(snapshotRepoName, "fs", snapshotRepoPath);  
        final String remoteStoreRepoName = "remote-store-repo-name";
        final String repoName = "repo-name";
    }
            .get()  
                return entries.size() == 2 && entries.get(1).clones().isEmpty() == false;  
        }
        return startClone(client(), repoName, sourceSnapshot, targetSnapshot, indices);  
        awaitNumberOfSnapshotsInProgress(2);
        final String sourceSnapshot = "source-snapshot";
 * You may obtain a copy of the License at  
        final int fileCount = sourceFiles.size();
    }
        }
        final String sourceSnapshot = "source-snapshot";
    }
        assertThat(
            awaitClusterState(clusterState -> {  
        waitForBlock(clusterManagerName, repoName, TimeValue.timeValueSeconds(30L));  
            clusterAdmin().prepareCreateSnapshot(repoName, "fast-snapshot").setIndices(indexFast).setWaitForCompletion(true).execute()
        awaitNumberOfSnapshotsInProgress(2);
            .setWaitForCompletion(true)
        createIndexWithContent(indexSlow);
        // Check if the clone operation worked out by chance as a result of the clone request being retried
        );  
    public void testCloneShallowSnapshotIndex() throws Exception {  
        ConcurrentSnapshotExecutionException ex = expectThrows(  
        blockClusterManagerOnWriteIndexFile(repoName);
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
        final String targetSnapshot = "target-snapshot";  
    private static void assertAllSnapshotsSuccessful(RepositoryData repositoryData, int successfulSnapshotCount) {
        final String sourceSnapshot = "source-snapshot";  
        final String targetSnapshot = "target-snapshot";
        ConcurrentSnapshotExecutionException ex = expectThrows(
import org.opensearch.common.action.ActionFuture;  
        assertThat(sourceSnapshotFuture.get().getSnapshotInfo().state(), is(SnapshotState.PARTIAL));  
        final String testIndex = "index-test";
        String targetSnapshot,  
            SnapshotException.class,  
        final String sourceSnapshot = "source-snapshot";
        ensureYellow(indexName, remoteStoreEnabledIndexName);
            assertAcked(admin().indices().prepareDelete(indexName));
        final String indexName = "index-1";  
        final SnapshotException sne = expectThrows(
            ensureYellow(remoteStoreEnabledIndexName);
    }
        createFullSnapshot(repoName, sourceSnapshot);
        final int extraSnapshots = randomIntBetween(0, 5);
                    )
 * Modifications Copyright OpenSearch Contributors. See  
        assertTrue(updatedRepositoryMetadata.settings().getAsBoolean(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), false));
        internalCluster().restartNode(clusterManagerNode);  
        }
        createRepository(snapshotRepoName, "fs", snapshotRepoSettingsForShallowCopy(snapshotRepoPath));  
 *
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(LARGE_SNAPSHOT_POOL_SETTINGS);
        internalCluster().startClusterManagerOnlyNode(
    ) {
                    .entries();
        createRepository(repoName, "mock");  
        }
        internalCluster().startClusterManagerOnlyNode(remoteStoreClusterSettings(remoteStoreRepoName, remoteStoreRepoPath));
        final String repoName = "test-repo";
        final String sourceSnapshot = "source-snapshot";
        final List<BlobStoreIndexShardSnapshot.FileInfo> targetFiles = targetShardSnapshot.indexFiles();
                )  
        assertEquals(getSnapshot(repoName, cloneName).state(), SnapshotState.SUCCESS);  
        awaitNoMoreRunningOperations(internalCluster().getClusterManagerName());  
                .build()  
        createRepository(snapshotRepoName, "fs", snapshotRepoSettingsForShallowCopy(snapshotRepoPath));
        final String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(LARGE_SNAPSHOT_POOL_SETTINGS);  
            .execute();
            extraSnapshotFutures.add(startFullSnapshot(repoName, "extra-snap-" + i));
        String... indices
                .generic()
    }
        awaitClusterManagerFinishRepoOperations();  
        final String remoteStoreEnabledIndexName = "remote-index-1";  
        createRepository(repoName, "mock");  
        // Updating the snapshot repository flag to enable shallow snapshots
import org.opensearch.cluster.SnapshotsInProgress;  
    /**
        String targetSnapshot,  
        blockClusterManagerOnShardClone(repoName);
        String sourceSnapshot,
        final String repoName = "test-repo";  
        final String clusterManagerNode = internalCluster().getClusterManagerName();
        final ActionFuture<AcknowledgedResponse> cloneFuture = startClone(repoName, sourceSnapshot, targetSnapshot, indexName);
        unblockNode(repoName, dataNode);  
        for (ActionFuture<CreateSnapshotResponse> extraSnapshotFuture : extraSnapshotFutures) {
        final String snapshot = "snapshot";
    }
            f -> repository.cloneShardSnapshot(sourceSnapshotInfo.snapshotId(), targetSnapshotId, repositoryShardId, currentShardGen, f)
        final ActionFuture<CreateSnapshotResponse> sourceSnapshotFuture = clusterManagerClient.admin()
        blockClusterManagerOnReadIndexMeta(repoName);
        final String targetSnapshot = "target-snapshot";
        assertEquals(getSnapshot(repoName, cloneName).state(), SnapshotState.SUCCESS);  
        internalCluster().startClusterManagerOnlyNodes(3, LARGE_SNAPSHOT_POOL_SETTINGS);
    public void testStartCloneWithSuccessfulShardSnapshotPendingFinalization() throws Exception {
            assertThat(repositoryData.getSnapshotState(snapshotId), is(SnapshotState.SUCCESS));  
        // because of the cluster-manager failover  
        final String targetSnapshot = "target-snapshot";
