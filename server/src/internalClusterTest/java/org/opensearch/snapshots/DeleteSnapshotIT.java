        indexRandomDocs(remoteStoreEnabledIndexName, randomIntBetween(5, 10));
        final String testIndex = "index-test";
        final String remoteStoreEnabledIndexName = "remote-index-1";
        }, 30, TimeUnit.SECONDS);
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == totalShallowCopySnapshotsCount);
    }
        String snapshotName1 = "test-restore-snapshot1";
        String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(getNodeSettings());
        createIndexWithContent(testIndex);
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
            .prepareCreateSnapshot(repoName, snapshotName1)
        assertBusy(() -> assertEquals(0, RemoteStoreBaseIntegTestCase.getFileCount(absolutePath.resolve(SnapshotShardPaths.DIR))));
        );
            client(),
        try (RemoteBufferedOutputDirectory lockDirectory = new RemoteBufferedOutputDirectory(blobContainer)) {
        final String remoteStoreEnabledIndexName = "remote-index-1";
        createIndexWithContent(testIndex);
            segmentsPathFixedPrefix
    }
        indexRandomDocs(remoteStoreEnabledIndexName, randomIntBetween(5, 10));
        final Path snapshotRepoPath = randomRepoPath();
        final Client clusterManagerClient = internalCluster().clusterManagerClient();
        assertEquals(SnapshotState.SUCCESS, createSnapshotResponse.getSnapshotInfo().state());
        final Path remoteStoreRepoPath = randomRepoPath();
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
        BlobPath shardLevelBlobPath = getShardLevelBlobPath(
        ensureStableCluster(2);
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
    }
import java.util.concurrent.TimeUnit;
        totalShallowCopySnapshotsCount += 1; // Adding partial shallow snapshot here
        createRepository(snapshotRepoName, "mock", snapshotRepoSettingsForShallowCopy(snapshotRepoPath));
import org.opensearch.indices.RemoteStoreSettings;
        final String shallowSnapshot = "shallow-snapshot";
        final String remoteStoreEnabledIndexName = "remote-index-1";
        final String indexName = "index-1";
            SEGMENTS,
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == totalShallowCopySnapshotsCount);
        internalCluster().startDataOnlyNode(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath));
import org.opensearch.cluster.metadata.IndexMetadata;
    }
/*
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == 0);
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == totalShallowCopySnapshotsCount);
        }
        int tobeDeletedShallowCopySnapshotsCount = shallowCopySnapshotsToBeDeleted.size();
            - tobeDeletedSnapshotsCount);
import org.opensearch.common.action.ActionFuture;
        // Creating some shallow copy snapshots
        totalSnapshotsCount -= (tobeDeletedShallowCopySnapshotsCount + tobeDeletedFullCopySnapshotsCount);
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == totalShallowCopySnapshotsCount);
        int tobeDeletedFullCopySnapshotsCount = fullCopySnapshotsToBeDeleted.size();
        List<String> snapshotsToBeDeleted = shallowCopySnapshots.subList(0, randomIntBetween(2, totalShallowCopySnapshotsCount));
        // Delete is async. Give time for it
        // Updating the snapshot repository flag to disable shallow snapshots
        final String remoteStoreEnabledIndexName = "remote-index-1";
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        final String prefix = "snap-" + UUIDs.randomBase64UUID(random()).toLowerCase(Locale.ROOT) + "-";
        int totalSnapshotsCount = totalFullCopySnapshotsCount + totalShallowCopySnapshotsCount;
import org.opensearch.common.blobstore.BlobPath;
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == 1);
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == 1);
import static org.opensearch.remotestore.RemoteStoreBaseIntegTestCase.remoteStoreClusterSettings;
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/9208")
    private static final String REMOTE_REPO_NAME = "remote-store-repo-name";
            clusterManagerClient.admin()
        createRepository(snapshotRepoName, "mock", snapshotRepoSettingsForShallowCopy(snapshotRepoPath));
        final Path remoteStoreRepoPath = randomRepoPath();
        createIndexWithContent(testIndex);
        final Client clusterManagerClient = internalCluster().clusterManagerClient();
import org.opensearch.common.UUIDs;
import org.opensearch.test.OpenSearchIntegTestCase;
        String[] lockFiles;
        BlobContainer blobContainer = remoteStoreRepository.blobStore().blobContainer(shardLevelBlobPath);
        final Path snapshotRepoPath = randomRepoPath();
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == totalShallowCopySnapshotsCount);
import java.util.Locale;
        // Updating the snapshot repository flag to disable shallow snapshots
    // Deleting subset of shallow and full copy snapshots as part of single delete call and then deleting all snapshots in the repo.
        internalCluster().startClusterManagerOnlyNode(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath));
            .getSetting(remoteStoreEnabledIndexName, IndexMetadata.SETTING_INDEX_UUID);
        assertTrue(lockFiles[0].contains(snapshotInfo2.snapshotId().getUUID()));
            try {
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
    // Deleting multiple shallow copy snapshots as part of single delete call with both partial and full copy snapshot present in the repo
            clusterManagerClient.admin()
        // Deleting subset of shallow copy snapshots and full copy snapshots
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
 * compatible open source license.
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.SEGMENTS;
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
    public void testStaleIndexDeletion() throws Exception {
        assert (lockFiles.length == 1) : "lock files are " + Arrays.toString(lockFiles);
        for (int i = 0; i < count; i++) {
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        assertAcked(deleteSnapshotResponse);
        List<String> fullCopySnapshotsToBeDeleted = fullCopySnapshots.subList(0, randomIntBetween(2, totalFullCopySnapshotsCount));
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == totalSnapshotsCount);
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
        String docId = Integer.toString(randomInt());
            snapshotNames.add(name);
        final String snapshotRepoName = "snapshot-repo-name";
        final BlobStoreRepository remoteStoreRepository = (BlobStoreRepository) repositoriesService.repository(REMOTE_REPO_NAME);
        createIndexWithContent(testIndex);
                .get()
        final Path snapshotRepoPath = randomRepoPath();
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
        int totalShallowCopySnapshotsCount = randomIntBetween(4, 10);
        indexRandomDocs(remoteStoreEnabledIndexName, randomIntBetween(5, 10));
import static org.hamcrest.Matchers.comparesEqualTo;
        logger.info("--> create two remote index shallow snapshots");
        blockDataNode(snapshotRepoName, dataNode);
        final String clusterManagerNode = internalCluster().getClusterManagerName();
        final String snapshotRepoName = "snapshot-repo-name";
            .get()
            createFullSnapshot(repoName, name);
        assertAcked(startDeleteSnapshot(snapshotRepoName, shallowSnapshot).get());
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/8610")
            .cluster()
        );
            .put(settings)
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == totalShallowCopySnapshotsCount);
        unblockAllDataNodes(snapshotRepoName);
        createRepository(snapshotRepoName, "mock", snapshotRepoPath);
        indexRandomDocs(remoteStoreEnabledIndexName, randomIntBetween(5, 10));
        );
        internalCluster().startClusterManagerOnlyNode(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath));
        totalSnapshotsCount -= tobeDeletedShallowCopySnapshotsCount;
        internalCluster().startClusterManagerOnlyNode(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath));
            .get();
    public void testDeleteShallowCopySnapshot() throws Exception {
        assertBusy(() -> assertEquals(2, RemoteStoreBaseIntegTestCase.getFileCount(absolutePath)));
            .get();
        // Write a document
            .prepareGetSettings(remoteStoreEnabledIndexName)
 * SPDX-License-Identifier: Apache-2.0
            .execute();
        internalCluster().startDataOnlyNode(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath));
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == totalSnapshotsCount);
        List<String> fullCopySnapshotsToBeDeleted = fullCopySnapshots.subList(0, randomIntBetween(2, totalFullCopySnapshotsCount));
                .cluster()
        assertThat(snapshotFuture.get().getSnapshotInfo().state(), is(SnapshotState.PARTIAL));
        assertAcked(
        List<String> shallowCopySnapshots = createNSnapshots(snapshotRepoName, totalShallowCopySnapshotsCount);
        final Path snapshotRepoPath = randomRepoPath();
        deleteSnapshotResponse = clusterManagerClient.admin()
        final String snapshotRepoName = "snapshot-repo-name";
        createRepository(snapshotRepoName, "fs", snapshotRepoPath);
        final String snapshot = "snapshot";
        int tobeDeletedSnapshotsCount = snapshotsToBeDeleted.size();
        );
package org.opensearch.snapshots;
            clusterManagerClient.admin()
            .setWaitForCompletion(true)
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == 0);
        }
        int totalFullCopySnapshotsCount = randomIntBetween(4, 10);
        List<String> shallowCopySnapshotsToBeDeleted = shallowCopySnapshots.subList(0, randomIntBetween(2, totalShallowCopySnapshotsCount));
            lockFiles = lockDirectory.listAll();
        final String snapshotRepoName = "snapshot-repo-name";
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == totalShallowCopySnapshotsCount
        ensureStableCluster(2);
        assertAcked(startDeleteSnapshot(snapshotRepoName, snapshot).get());
            .setWaitForCompletion(true)
        final Client clusterManagerClient = internalCluster().clusterManagerClient();
    public void testDeleteMultipleShallowCopySnapshotsCase2() throws Exception {
        );
        internalCluster().startClusterManagerOnlyNode(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath));
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == 0);
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == 0);
        createRepository(snapshotRepoName, "mock", snapshotRepoSettingsForShallowCopy(snapshotRepoPath));
    public void testDeleteSnapshot() throws Exception {
        CreateSnapshotResponse createSnapshotResponse = client.admin()
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == totalSnapshotsCount);
        // Creating some shallow copy snapshots
        logger.info("--> snapshot");
        String indexUUID = client().admin()
        indexRandomDocs(remoteStoreEnabledIndexName, randomIntBetween(5, 10));
        final String remoteStoreEnabledIndexName = "remote-index-1";
            "0",
        logger.info("Path [{}]", absolutePath);
        // Creating a partial shallow copy snapshot
        assertEquals(createSnapshotResponse.getSnapshotInfo().totalShards(), createSnapshotResponse.getSnapshotInfo().successfulShards());
        }
        ensureStableCluster(2, clusterManagerNode);
        createFullSnapshot(snapshotRepoName, shallowSnapshot);
                .cluster()
    }
                .cluster()
        totalSnapshotsCount -= tobeDeletedFullCopySnapshotsCount;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == 0);
            .prepareCreateSnapshot(snapshotRepoName, snapshot)
    }
        final List<String> snapshotNames = new ArrayList<>(count);
        settings = Settings.builder()
        ensureStableCluster(2);
        final String indexName = "index-1";
        internalCluster().startDataOnlyNode(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath));
import org.opensearch.repositories.RepositoriesService;
import org.opensearch.transport.client.Client;
        int totalShallowCopySnapshotsCount = randomIntBetween(4, 10);
        logger.info("--> delete snapshot 1");
    private List<String> createNSnapshots(String repoName, int count) {
import java.util.ArrayList;
        // delete remote store index
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/8610")
                .prepareDeleteSnapshot(snapshotRepoName, shallowCopySnapshotsToBeDeleted.toArray(new String[0]))
import org.opensearch.common.settings.Settings;
        internalCluster().restartNode(dataNode);
            lockFiles = lockDirectory.listAll();
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));
import java.util.List;
        final String testIndex = "index-test";
        totalShallowCopySnapshotsCount -= tobeDeletedShallowCopySnapshotsCount;
    }
        // Disabling pinned timestamp as this test is specifically for shallow snapshot.
        assertAcked(
public class DeleteSnapshotIT extends AbstractSnapshotIntegTestCase {
        createRepository(snapshotRepoName, "fs", snapshotRepoSettingsForShallowCopy());
        final String dataNode = internalCluster().startDataOnlyNode(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath));
        // Creating some full copy snapshots
                .get()
        final Client clusterManagerClient = internalCluster().clusterManagerClient();
        Path absolutePath = randomRepoPath().toAbsolutePath();
        assertAcked(deleteSnapshotResponse);
        Settings settings = remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath);
            .cluster()
        String repoName = "test-restore-snapshot-repo";
        assertAcked(
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
        assertAcked(startDeleteSnapshot(repoName, snapshotName1).get());
    public void testRemoteStoreCleanupForDeletedIndex() throws Exception {
        assert (lockFiles.length == 2) : "lock files are " + Arrays.toString(lockFiles);
        final Path snapshotRepoPath = randomRepoPath();
    public void testDeleteMultipleShallowCopySnapshotsCase3() throws Exception {
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
    // Deleting multiple shallow copy snapshots as part of single delete call with repo having only shallow copy snapshots.
            final String name = prefix + i;
                    Stream.concat(shallowCopySnapshotsToBeDeleted.stream(), fullCopySnapshotsToBeDeleted.stream()).toArray(String[]::new)
        List<String> shallowCopySnapshotsToBeDeleted = shallowCopySnapshots.subList(0, randomIntBetween(2, totalShallowCopySnapshotsCount));
        List<String> fullCopySnapshots = createNSnapshots(snapshotRepoName, totalFullCopySnapshotsCount);
    public void testDeleteMultipleShallowCopySnapshotsCase1() throws Exception {
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), false)
        // At the end there are 2 files that exists - index-N and index.latest
        // Deleting subset of shallow copy snapshots
 *
 * this file be licensed under the Apache-2.0 license or a
import java.nio.file.Path;
        List<String> shallowCopySnapshots = createNSnapshots(snapshotRepoName, totalShallowCopySnapshotsCount);
import java.util.stream.Stream;
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == totalShallowCopySnapshotsCount);
        int tobeDeletedFullCopySnapshotsCount = fullCopySnapshotsToBeDeleted.size();
            .build();
            .setIndices(indexName1)
        final String remoteStoreEnabledIndexName = "remote-index-1";
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        awaitNumberOfSnapshotsInProgress(1);
        final String testIndex = "index-test";
            remoteStoreRepository.basePath(),
        assertBusy(() -> {
        assertAcked(clusterManagerClient.admin().cluster().prepareDeleteSnapshot(snapshotRepoName, "*").get());
}
import java.util.Arrays;
                .prepareDeleteSnapshot(snapshotRepoName, fullCopySnapshotsToBeDeleted.toArray(new String[0]))
            .cluster()
        indexRandomDocs(remoteStoreEnabledIndexName, randomIntBetween(5, 10));
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = clusterManagerClient.admin()
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
        AcknowledgedResponse deleteSnapshotResponse = clusterManagerClient.admin()
        int totalSnapshotsCount = totalFullCopySnapshotsCount + totalShallowCopySnapshotsCount;
        // Creating some full copy snapshots
        blockNodeWithIndex(snapshotRepoName, testIndex);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        final String snapshotRepoName = "snapshot-repo-name";
        try (RemoteBufferedOutputDirectory lockDirectory = new RemoteBufferedOutputDirectory(blobContainer)) {
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
        assertBusy(() -> assertEquals(0, RemoteStoreBaseIntegTestCase.getFileCount(absolutePath.resolve(BlobStoreRepository.INDICES_DIR))));
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/9208")
        createRepository(repoName, "fs", absolutePath);
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == totalShallowCopySnapshotsCount - tobeDeletedSnapshotsCount);
 * The OpenSearch Contributors require contributions made to
        createRepository(snapshotRepoName, "mock", snapshotRepoSettingsForShallowCopy(snapshotRepoPath));
            LOCK_FILES,
        // Deleting subset of shallow copy snapshots
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.LOCK_FILES;
        List<String> fullCopySnapshots = createNSnapshots(snapshotRepoName, totalFullCopySnapshotsCount);
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == totalSnapshotsCount);
                )
            .get();
        final RepositoriesService repositoriesService = internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class);
import org.opensearch.common.blobstore.BlobContainer;
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == totalSnapshotsCount);
                .get()
        final Path remoteStoreRepoPath = randomRepoPath();
            .cluster()
        return snapshotNames;
        internalCluster().startDataOnlyNode(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath));
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == 0);
        SnapshotInfo snapshotInfo1 = createFullSnapshot(snapshotRepoName, "snap1");
    }
        // Deleting subset of full copy snapshots
        waitForBlock(dataNode, snapshotRepoName, TimeValue.timeValueSeconds(30L));
                    snapshotRepoName,
        int tobeDeletedShallowCopySnapshotsCount = shallowCopySnapshotsToBeDeleted.size();
            remoteStoreEnabledIndexName,
import static org.hamcrest.Matchers.is;
    // the repo
        final Path remoteStoreRepoPath = randomRepoPath();
        // Deleting all the remaining snapshots
            clusterManagerClient.admin()
import org.opensearch.index.store.RemoteBufferedOutputDirectory;
            } catch (Exception e) {}
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));
        assertAcked(client().admin().indices().prepareDelete(remoteStoreEnabledIndexName));
        String indexName1 = ".testindex1";
import org.opensearch.common.unit.TimeValue;
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
        logger.info("--> created {} in [{}]", snapshotNames, repoName);
        final String testIndex = "index-test";
        ensureStableCluster(2);
            .prepareDeleteSnapshot(snapshotRepoName, snapshotInfo2.snapshotId().getName())
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
        final Path remoteStoreRepoPath = randomRepoPath();
        assertTrue(createSnapshotResponse.getSnapshotInfo().successfulShards() > 0);
        final Path remoteStoreRepoPath = randomRepoPath();
        final String snapshot = "snapshot";
                .prepareDeleteSnapshot(
        internalCluster().startClusterManagerOnlyNode(settings);
                assertThat(RemoteStoreBaseIntegTestCase.getFileCount(indexPath), comparesEqualTo(0));
            .indices()
                .prepareDeleteSnapshot(snapshotRepoName, snapshotsToBeDeleted.toArray(new String[0]))
        createFullSnapshot(snapshotRepoName, snapshot);
        List<String> shallowCopySnapshots = createNSnapshots(snapshotRepoName, totalShallowCopySnapshotsCount);
        internalCluster().startClusterManagerOnlyNode(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath));
 */
        logger.info("--> delete snapshot 2");
        // Creating some shallow copy snapshots
                .cluster()
        final String snapshotRepoName = "snapshot-repo-name";
        internalCluster().startDataOnlyNode(settings);
        int totalFullCopySnapshotsCount = randomIntBetween(4, 10);
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
    // And then deleting multiple full copy snapshots as part of single delete call with both partial and shallow copy snapshots present in
        index(indexName1, "_doc", docId, "value", "expected");
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == 1);
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
        totalShallowCopySnapshotsCount -= tobeDeletedShallowCopySnapshotsCount;
        createRepository(snapshotRepoName, "mock", snapshotRepoPath);
        assertAcked(
        int totalShallowCopySnapshotsCount = randomIntBetween(4, 10);
        Client client = client();
            .prepareDeleteSnapshot(snapshotRepoName, snapshotInfo1.snapshotId().getName())
                .get()
        Path indexPath = Path.of(String.valueOf(remoteStoreRepoPath), indexUUID);
        SnapshotInfo snapshotInfo2 = createFullSnapshot(snapshotRepoName, "snap2");
