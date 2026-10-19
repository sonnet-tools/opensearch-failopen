        List<String> fullCopySnapshots = createNSnapshots(snapshotRepoName, totalFullCopySnapshotsCount);
        final String dataNode = internalCluster().startDataOnlyNode(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath));  
                .prepareDeleteSnapshot(snapshotRepoName, fullCopySnapshotsToBeDeleted.toArray(new String[0]))
        final BlobStoreRepository remoteStoreRepository = (BlobStoreRepository) repositoriesService.repository(REMOTE_REPO_NAME);
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.SEGMENTS;
        final Client clusterManagerClient = internalCluster().clusterManagerClient();
import java.util.stream.Stream;  
        createRepository(snapshotRepoName, "mock", snapshotRepoPath);
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/8610")
import org.opensearch.index.store.RemoteBufferedOutputDirectory;
        assert (lockFiles.length == 2) : "lock files are " + Arrays.toString(lockFiles);  
        final String remoteStoreEnabledIndexName = "remote-index-1";
            lockFiles = lockDirectory.listAll();
import org.opensearch.common.blobstore.BlobContainer;  
        totalSnapshotsCount -= tobeDeletedFullCopySnapshotsCount;
        }
        final RepositoriesService repositoriesService = internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class);
        // Deleting subset of shallow copy snapshots
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.LOCK_FILES;  
    }
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
import static org.opensearch.remotestore.RemoteStoreBaseIntegTestCase.remoteStoreClusterSettings;
        createFullSnapshot(snapshotRepoName, shallowSnapshot);  
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == totalShallowCopySnapshotsCount  
        final String indexName = "index-1";
        final String prefix = "snap-" + UUIDs.randomBase64UUID(random()).toLowerCase(Locale.ROOT) + "-";  
        List<String> shallowCopySnapshots = createNSnapshots(snapshotRepoName, totalShallowCopySnapshotsCount);  
        // Deleting subset of full copy snapshots  
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);  
        int totalFullCopySnapshotsCount = randomIntBetween(4, 10);  
            "0",
        );  
                    snapshotRepoName,
            .setIndices(indexName1)
        for (int i = 0; i < count; i++) {
        ensureStableCluster(2);
        final Client clusterManagerClient = internalCluster().clusterManagerClient();  
        indexRandomDocs(remoteStoreEnabledIndexName, randomIntBetween(5, 10));
        final String snapshotRepoName = "snapshot-repo-name";
        final String remoteStoreEnabledIndexName = "remote-index-1";
        final String remoteStoreEnabledIndexName = "remote-index-1";
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
        final Path remoteStoreRepoPath = randomRepoPath();  
        final ActionFuture<CreateSnapshotResponse> snapshotFuture = clusterManagerClient.admin()  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), false)
        internalCluster().startClusterManagerOnlyNode(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath));  
        // Deleting all the remaining snapshots  
 */  
package org.opensearch.snapshots;
        try (RemoteBufferedOutputDirectory lockDirectory = new RemoteBufferedOutputDirectory(blobContainer)) {  
    }
import org.opensearch.transport.client.Client;
        blockNodeWithIndex(snapshotRepoName, testIndex);
            segmentsPathFixedPrefix
import org.opensearch.common.blobstore.BlobPath;
        final String indexName = "index-1";  
        blockDataNode(snapshotRepoName, dataNode);  
        );
        AcknowledgedResponse deleteSnapshotResponse = clusterManagerClient.admin()  
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        final String shallowSnapshot = "shallow-snapshot";
            .get();  
        SnapshotInfo snapshotInfo1 = createFullSnapshot(snapshotRepoName, "snap1");
        int totalSnapshotsCount = totalFullCopySnapshotsCount + totalShallowCopySnapshotsCount;
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == 1);
                )
        internalCluster().startClusterManagerOnlyNode(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath));
        int totalSnapshotsCount = totalFullCopySnapshotsCount + totalShallowCopySnapshotsCount;
    public void testDeleteShallowCopySnapshot() throws Exception {  
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);  
        final String testIndex = "index-test";
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();  
        createRepository(snapshotRepoName, "fs", snapshotRepoPath);
                .cluster()  
        assertBusy(() -> assertEquals(0, RemoteStoreBaseIntegTestCase.getFileCount(absolutePath.resolve(BlobStoreRepository.INDICES_DIR))));  
        assertAcked(startDeleteSnapshot(repoName, snapshotName1).get());
import java.util.Arrays;
        final Path remoteStoreRepoPath = randomRepoPath();
            .prepareGetSettings(remoteStoreEnabledIndexName)
    public void testDeleteMultipleShallowCopySnapshotsCase3() throws Exception {
public class DeleteSnapshotIT extends AbstractSnapshotIntegTestCase {
        final Client clusterManagerClient = internalCluster().clusterManagerClient();
    // Deleting multiple shallow copy snapshots as part of single delete call with repo having only shallow copy snapshots.  
        int tobeDeletedSnapshotsCount = snapshotsToBeDeleted.size();
            clusterManagerClient.admin()  
        internalCluster().startClusterManagerOnlyNode(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath));
                .prepareDeleteSnapshot(snapshotRepoName, snapshotsToBeDeleted.toArray(new String[0]))
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));
        int tobeDeletedFullCopySnapshotsCount = fullCopySnapshotsToBeDeleted.size();  
    // And then deleting multiple full copy snapshots as part of single delete call with both partial and shallow copy snapshots present in
import java.util.ArrayList;
        logger.info("Path [{}]", absolutePath);
        internalCluster().startClusterManagerOnlyNode(settings);
                .cluster()  
        assertEquals(SnapshotState.SUCCESS, createSnapshotResponse.getSnapshotInfo().state());  
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == totalSnapshotsCount);  
        final Path snapshotRepoPath = randomRepoPath();
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
        Path absolutePath = randomRepoPath().toAbsolutePath();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    }
        // At the end there are 2 files that exists - index-N and index.latest
    // the repo  
        waitForBlock(dataNode, snapshotRepoName, TimeValue.timeValueSeconds(30L));
            lockFiles = lockDirectory.listAll();
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == 0);
        indexRandomDocs(remoteStoreEnabledIndexName, randomIntBetween(5, 10));
        );  
        final String snapshotRepoName = "snapshot-repo-name";
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == totalShallowCopySnapshotsCount);  
import java.util.concurrent.TimeUnit;
        totalSnapshotsCount -= tobeDeletedShallowCopySnapshotsCount;
        assertAcked(deleteSnapshotResponse);
    }
        final String remoteStoreEnabledIndexName = "remote-index-1";
        assertAcked(
        settings = Settings.builder()  
    }
        createRepository(snapshotRepoName, "mock", snapshotRepoSettingsForShallowCopy(snapshotRepoPath));  
        final Path remoteStoreRepoPath = randomRepoPath();
import org.opensearch.repositories.RepositoriesService;
        ensureStableCluster(2, clusterManagerNode);
            .get()  
        assertAcked(
        List<String> snapshotsToBeDeleted = shallowCopySnapshots.subList(0, randomIntBetween(2, totalShallowCopySnapshotsCount));  
 * this file be licensed under the Apache-2.0 license or a
        List<String> fullCopySnapshotsToBeDeleted = fullCopySnapshots.subList(0, randomIntBetween(2, totalFullCopySnapshotsCount));
        }
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
        assertAcked(startDeleteSnapshot(snapshotRepoName, shallowSnapshot).get());
        assertAcked(clusterManagerClient.admin().cluster().prepareDeleteSnapshot(snapshotRepoName, "*").get());
    }
            .build();  
            .cluster()
        indexRandomDocs(remoteStoreEnabledIndexName, randomIntBetween(5, 10));
import org.opensearch.common.UUIDs;
        assertAcked(startDeleteSnapshot(snapshotRepoName, snapshot).get());
        logger.info("--> create two remote index shallow snapshots");  
            .execute();
    public void testRemoteStoreCleanupForDeletedIndex() throws Exception {
        assertAcked(
import org.opensearch.indices.RemoteStoreSettings;
            .getSetting(remoteStoreEnabledIndexName, IndexMetadata.SETTING_INDEX_UUID);
        internalCluster().startDataOnlyNode(settings);
                .get()  
    private List<String> createNSnapshots(String repoName, int count) {
        final String testIndex = "index-test";
import static org.hamcrest.Matchers.is;
        createIndexWithContent(testIndex);
        final String remoteStoreEnabledIndexName = "remote-index-1";  
        Path indexPath = Path.of(String.valueOf(remoteStoreRepoPath), indexUUID);
        createRepository(snapshotRepoName, "mock", snapshotRepoSettingsForShallowCopy(snapshotRepoPath));  
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == totalShallowCopySnapshotsCount - tobeDeletedSnapshotsCount);
            .setWaitForCompletion(true)
        assertAcked(client().admin().indices().prepareDelete(remoteStoreEnabledIndexName));  
        // Creating some full copy snapshots
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == totalSnapshotsCount);  
        BlobContainer blobContainer = remoteStoreRepository.blobStore().blobContainer(shardLevelBlobPath);
        logger.info("--> created {} in [{}]", snapshotNames, repoName);  
            remoteStoreEnabledIndexName,  
        int tobeDeletedFullCopySnapshotsCount = fullCopySnapshotsToBeDeleted.size();  
        final List<String> snapshotNames = new ArrayList<>(count);
        disableRepoConsistencyCheck("Remote store repository is being used in the test");  
            .setWaitForCompletion(true)  
        final Path snapshotRepoPath = randomRepoPath();
        totalShallowCopySnapshotsCount -= tobeDeletedShallowCopySnapshotsCount;
            .prepareCreateSnapshot(snapshotRepoName, snapshot)
                .prepareDeleteSnapshot(snapshotRepoName, shallowCopySnapshotsToBeDeleted.toArray(new String[0]))
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == totalShallowCopySnapshotsCount);
            clusterManagerClient.admin()
        ensureStableCluster(2);
        final String snapshotRepoName = "snapshot-repo-name";
            - tobeDeletedSnapshotsCount);
            .get();
            LOCK_FILES,
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/9208")  
}  
        totalShallowCopySnapshotsCount -= tobeDeletedShallowCopySnapshotsCount;
                assertThat(RemoteStoreBaseIntegTestCase.getFileCount(indexPath), comparesEqualTo(0));
        createRepository(snapshotRepoName, "mock", snapshotRepoSettingsForShallowCopy(snapshotRepoPath));  
    }
        final Client clusterManagerClient = internalCluster().clusterManagerClient();
        int totalShallowCopySnapshotsCount = randomIntBetween(4, 10);
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
        );  
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == totalShallowCopySnapshotsCount);  
            final String name = prefix + i;
        // Creating some full copy snapshots
import java.util.Locale;
                .cluster()
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == totalSnapshotsCount);
        // Updating the snapshot repository flag to disable shallow snapshots  
        final Path remoteStoreRepoPath = randomRepoPath();
        ensureStableCluster(2);
        final String snapshotRepoName = "snapshot-repo-name";  
        assertAcked(
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/8610")
        assert (lockFiles.length == 1) : "lock files are " + Arrays.toString(lockFiles);  
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
        final String clusterManagerNode = internalCluster().getClusterManagerName();
        internalCluster().startClusterManagerOnlyNode(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath));  
        // Deleting subset of shallow copy snapshots  
        createIndexWithContent(testIndex);
        unblockAllDataNodes(snapshotRepoName);
                    Stream.concat(shallowCopySnapshotsToBeDeleted.stream(), fullCopySnapshotsToBeDeleted.stream()).toArray(String[]::new)  
        logger.info("--> snapshot");  
 * SPDX-License-Identifier: Apache-2.0
        try (RemoteBufferedOutputDirectory lockDirectory = new RemoteBufferedOutputDirectory(blobContainer)) {  
            .put(settings)
import org.opensearch.test.OpenSearchIntegTestCase;  
            .cluster()
                .prepareDeleteSnapshot(
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == 0);
        indexRandomDocs(remoteStoreEnabledIndexName, randomIntBetween(5, 10));  
        SnapshotInfo snapshotInfo2 = createFullSnapshot(snapshotRepoName, "snap2");
        final Path snapshotRepoPath = randomRepoPath();
    // Deleting subset of shallow and full copy snapshots as part of single delete call and then deleting all snapshots in the repo.  
        BlobPath shardLevelBlobPath = getShardLevelBlobPath(
            } catch (Exception e) {}  
        assertBusy(() -> assertEquals(0, RemoteStoreBaseIntegTestCase.getFileCount(absolutePath.resolve(SnapshotShardPaths.DIR))));
    // Deleting multiple shallow copy snapshots as part of single delete call with both partial and full copy snapshot present in the repo
        internalCluster().startDataOnlyNode(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath));  
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == 0);  
        List<String> fullCopySnapshots = createNSnapshots(snapshotRepoName, totalFullCopySnapshotsCount);
                .cluster()  
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == totalShallowCopySnapshotsCount);
            clusterManagerClient.admin()
            snapshotNames.add(name);
        int tobeDeletedShallowCopySnapshotsCount = shallowCopySnapshotsToBeDeleted.size();
        totalShallowCopySnapshotsCount += 1; // Adding partial shallow snapshot here
        internalCluster().startClusterManagerOnlyNode(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath));
        int totalShallowCopySnapshotsCount = randomIntBetween(4, 10);
            .get();  
        createRepository(snapshotRepoName, "mock", snapshotRepoPath);
                .get()
    public void testDeleteMultipleShallowCopySnapshotsCase1() throws Exception {
        final String snapshot = "snapshot";
        final String snapshotRepoName = "snapshot-repo-name";  
 *
        // Disabling pinned timestamp as this test is specifically for shallow snapshot.
    public void testDeleteSnapshot() throws Exception {  
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == 0);  
        totalSnapshotsCount -= (tobeDeletedShallowCopySnapshotsCount + tobeDeletedFullCopySnapshotsCount);
            client(),
        internalCluster().restartNode(dataNode);
        // Creating some shallow copy snapshots  
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/9208")
        String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(getNodeSettings());  
        final Path snapshotRepoPath = randomRepoPath();
        internalCluster().startDataOnlyNode(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath));
        final String testIndex = "index-test";
        List<String> shallowCopySnapshots = createNSnapshots(snapshotRepoName, totalShallowCopySnapshotsCount);
        String indexUUID = client().admin()  
        assertTrue(createSnapshotResponse.getSnapshotInfo().successfulShards() > 0);
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;  
 * The OpenSearch Contributors require contributions made to  
        createFullSnapshot(snapshotRepoName, snapshot);
                .get()
        final Path remoteStoreRepoPath = randomRepoPath();
        disableRepoConsistencyCheck("Remote store repository is being used in the test");  
        String docId = Integer.toString(randomInt());
        }
        final Settings remoteStoreEnabledIndexSettings = getRemoteStoreBackedIndexSettings();
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == 0);  
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == totalShallowCopySnapshotsCount);
        final Path remoteStoreRepoPath = randomRepoPath();
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);  
        logger.info("--> delete snapshot 2");  
import org.opensearch.cluster.metadata.IndexMetadata;  
        int totalFullCopySnapshotsCount = randomIntBetween(4, 10);  
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == totalSnapshotsCount);
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
        int totalShallowCopySnapshotsCount = randomIntBetween(4, 10);
        String snapshotName1 = "test-restore-snapshot1";
        // Creating a partial shallow copy snapshot  
        logger.info("--> delete snapshot 1");
import static org.hamcrest.Matchers.comparesEqualTo;  
        final String testIndex = "index-test";
        CreateSnapshotResponse createSnapshotResponse = client.admin()
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);  
import java.nio.file.Path;  
        assertThat(snapshotFuture.get().getSnapshotInfo().state(), is(SnapshotState.PARTIAL));  
import org.opensearch.common.settings.Settings;
        deleteSnapshotResponse = clusterManagerClient.admin()
        disableRepoConsistencyCheck("Remote store repository is being used in the test");  
        Client client = client();  
        }, 30, TimeUnit.SECONDS);
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == 0);
            .prepareDeleteSnapshot(snapshotRepoName, snapshotInfo1.snapshotId().getName())
import java.util.List;  
                .get()
        // Write a document
        createRepository(snapshotRepoName, "mock", snapshotRepoSettingsForShallowCopy(snapshotRepoPath));
            SEGMENTS,  
        Settings settings = remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath);
/*  
        internalCluster().startDataOnlyNode(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath));
import org.opensearch.common.unit.TimeValue;  
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == totalSnapshotsCount);
    }
        final String remoteStoreEnabledIndexName = "remote-index-1";
    private static final String REMOTE_REPO_NAME = "remote-store-repo-name";  
        int tobeDeletedShallowCopySnapshotsCount = shallowCopySnapshotsToBeDeleted.size();
        return snapshotNames;
        // Updating the snapshot repository flag to disable shallow snapshots  
            .cluster()
        // Creating some shallow copy snapshots
        indexRandomDocs(remoteStoreEnabledIndexName, randomIntBetween(5, 10));
        createIndexWithRandomDocs(indexName, randomIntBetween(5, 10));
        String repoName = "test-restore-snapshot-repo";
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == 1);
        createIndex(remoteStoreEnabledIndexName, remoteStoreEnabledIndexSettings);
        createRepository(snapshotRepoName, "fs", snapshotRepoSettingsForShallowCopy());
        internalCluster().startDataOnlyNode(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath));  
            .prepareCreateSnapshot(repoName, snapshotName1)  
        final String snapshotRepoName = "snapshot-repo-name";  
        createRepository(repoName, "fs", absolutePath);
        );  
        final String snapshot = "snapshot";  
import org.opensearch.common.action.ActionFuture;
        List<String> shallowCopySnapshots = createNSnapshots(snapshotRepoName, totalShallowCopySnapshotsCount);
            .cluster()
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    public void testDeleteMultipleShallowCopySnapshotsCase2() throws Exception {
 * compatible open source license.
        List<String> shallowCopySnapshotsToBeDeleted = shallowCopySnapshots.subList(0, randomIntBetween(2, totalShallowCopySnapshotsCount));
        index(indexName1, "_doc", docId, "value", "expected");  
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        List<String> shallowCopySnapshotsToBeDeleted = shallowCopySnapshots.subList(0, randomIntBetween(2, totalShallowCopySnapshotsCount));  
        assertAcked(deleteSnapshotResponse);
        assertBusy(() -> assertEquals(2, RemoteStoreBaseIntegTestCase.getFileCount(absolutePath)));  
        List<String> fullCopySnapshotsToBeDeleted = fullCopySnapshots.subList(0, randomIntBetween(2, totalFullCopySnapshotsCount));
            try {
    public void testStaleIndexDeletion() throws Exception {
        // Creating some shallow copy snapshots  
        assertBusy(() -> {  
            createFullSnapshot(repoName, name);  
        assertEquals(createSnapshotResponse.getSnapshotInfo().totalShards(), createSnapshotResponse.getSnapshotInfo().successfulShards());
            .prepareDeleteSnapshot(snapshotRepoName, snapshotInfo2.snapshotId().getName())  
        indexRandomDocs(remoteStoreEnabledIndexName, randomIntBetween(5, 10));
        // Deleting subset of shallow copy snapshots and full copy snapshots  
        final Path snapshotRepoPath = randomRepoPath();
        createIndexWithContent(testIndex);
        assertTrue(lockFiles[0].contains(snapshotInfo2.snapshotId().getUUID()));
        // delete remote store index
            remoteStoreRepository.basePath(),
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == totalShallowCopySnapshotsCount);
        String[] lockFiles;
        assert (getRepositoryData(snapshotRepoName).getSnapshotIds().size() == 1);  
        awaitNumberOfSnapshotsInProgress(1);  
        String indexName1 = ".testindex1";  
            clusterManagerClient.admin()
            .indices()
        ensureStableCluster(2);
        // Delete is async. Give time for it
        createIndexWithContent(testIndex);  
        assert (getLockFilesInRemoteStore(remoteStoreEnabledIndexName, REMOTE_REPO_NAME).length == totalShallowCopySnapshotsCount);
