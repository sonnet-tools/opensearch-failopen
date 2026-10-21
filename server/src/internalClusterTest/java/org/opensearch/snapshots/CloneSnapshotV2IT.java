    public void teardown() {
        String indexName3 = "testindex3";
import org.opensearch.cluster.metadata.Metadata;
        deleteResponse = client().prepareDelete(indexName1, "2").execute().actionGet();
            assertTrue("doc with id" + id + " is not present for index " + indexName, client.prepareGet(indexName, id).get().isExists());
        for (String index : sourceSnapshotInfo.indices()) {
import static org.hamcrest.Matchers.equalTo;
        ensureGreen(indexName1);
                        .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;
        assertEquals(deleteResponse.getResult(), DocWriteResponse.Result.DELETED);
        RepositoryData repositoryData = repositoryDataPlainActionFuture.get();
                    Settings.builder()
                    Settings.builder()
}
                        .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
        logger.info("Snapshot Path [{}]", absolutePath1);
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
            .prepareCreateSnapshot(snapshotRepoName, sourceSnapshot)
            .get();
                .cluster()
        super(nodeSettings);
            GetSnapshotsResponse response2 = client().admin().cluster().getSnapshots(request).actionGet();
            assertEquals(2, repositoriesMetadata.repository(snapshotRepoName).pendingGeneration());
        for (String index : sourceInfo.indices()) {
        // disable snapshot v2 in repo
        indexRandomDocs(indexName1, numDocsInIndex1);
            client.admin()
import org.opensearch.action.support.PlainActionFuture;
        CreateSnapshotResponse createSnapshotResponse = client().admin()
        ensureGreen(indexName1);
        for (int i = 0; i < numOfDocs; i++) {
                )
 */
import org.opensearch.repositories.RepositoryData;
                .preparePutRepository(snapshotRepoName)
                .setType(FsRepository.TYPE)
        assertThat(sourceSnapshotInfo.snapshotId().getName(), equalTo(snapshotName1));
        String indexName1 = "testindex1";
        indexRandomDocs(indexName1, numDocsInIndex1);
        CreateSnapshotResponse createSnapshotResponse = client().admin()
            .cluster()
        }
        if (WRITABLE_WARM_INDEX_SETTING.get(settings)) {
        }
        final SnapshotId cloneSnapshotIdFinal = cloneSnapshotId.get();
        internalCluster().startDataAndWarmNodes(1, snapshotV2Settings(remoteStoreRepoPath));
    private Settings snapshotV2Settings(Path remoteStoreRepoPath) {
        deleteResponse = client().prepareDelete(indexName1, "1").execute().actionGet();
                .setType(FsRepository.TYPE)
        ensureGreen(indexName1, indexName2);
                fileCache.clear();
            for (var node : nodes) {
        assertThat(cloneSnapshotInfo.getPinnedTimestamp(), equalTo(sourceSnapshotInfo.getPinnedTimestamp()));
                        .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true)
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
                .preparePutRepository(snapshotRepoName)
        ensureGreen(indexName1, indexName2);
        String sourceSnapshotV2 = "test-source-snapshot-v2";
        assertThat(sourceSnapshotInfo.snapshotId().getName(), equalTo(snapshotName1));
                        .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
            assertEquals(3, response2.getSnapshots().size());
                        .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        String snapshotName1 = "test-create-snapshot1";
        // Validate that snapshot is present in repository data
                        .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
            .setRenamePattern(indexName1)
import org.junit.After;
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName2)).get());
            for (SnapshotId snapshotId : repositoryData1.getSnapshotIds()) {
        indexRandomDocs(indexName2, numDocsInIndex2);
        assertBusy(() -> {
        RepositoryData repositoryData = repositoryDataPlainActionFuture.get();
        Client client = client();
            .prepareCreateSnapshot(snapshotRepoName, snapshotName1)
                        .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        internalCluster().startClusterManagerOnlyNode(snapshotV2Settings(remoteStoreRepoPath));
    private void assertDocsPresentInIndex(Client client, String indexName, int numOfDocs) {
        final Path remoteStoreRepoPath = randomRepoPath();
        );
import org.opensearch.core.rest.RestStatus;
            .cluster()
import java.util.concurrent.TimeUnit;
        DeleteResponse deleteResponse = client().prepareDelete(indexName1, "0").execute().actionGet();
                )
import org.opensearch.cluster.metadata.RepositoriesMetadata;
import org.opensearch.action.ActionRunnable;
        String snapshotRepoName = "test-clone-snapshot-repo";
        // create source snapshot which is v2
            RepositoriesMetadata repositoriesMetadata = metadata.custom(RepositoriesMetadata.TYPE);
        }
        String sourceSnapshot = "test-source-snapshot";
                        .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
    public void testCloneShallowCopyAfterDisablingV2() throws Exception {
        assertThat(sourceSnapshotInfo.successfulShards(), greaterThan(0));
        final int numDocsInIndex1 = 10;
                .setSettings(
/*
        logger.info("--> create source snapshot");
            Metadata metadata = clusterAdmin().prepareState().get().getState().metadata();
        assertTrue(response.isAcknowledged());
 * specific language governing permissions and limitations
            }
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
 * Licensed to Elasticsearch under one or more contributor
                if (snapshotId.getName().equals("test_clone_snapshot1")) {
            assertAcked(client().admin().indices().prepareDelete("_all").get());
import java.nio.file.Path;
        PlainActionFuture<RepositoryData> repositoryDataPlainActionFuture = new PlainActionFuture<>();
        createIndex(indexName1, getRemoteStoreBackedIndexSettings());
            .prepareDeleteSnapshot(snapshotRepoName, sourceSnapshot)
        // assertThat(sourceSnapshotInfoV1.getPinnedTimestamp(), equalTo(0L));
        return Arrays.asList(
            .get();
 * compatible open source license.
        ensureGreen(indexName1, indexName2);
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);
        final int numDocsInIndex1 = 10;
        );
            } catch (InterruptedException | ExecutionException e) {
        logger.info("Snapshot Path [{}]", absolutePath1);
        AcknowledgedResponse response = client().admin()
            } catch (InterruptedException | ExecutionException e) {
        // Validate that snapshot is present in repository data
        // Validate that the snapshot was created
        AtomicReference<RepositoryData> repositoryDataAtomicReference = new AtomicReference<>();
        CreateSnapshotResponse createSnapshotResponseV1 = client().admin()
        assertThat(sourceSnapshotInfo.snapshotId().getName(), equalTo(sourceSnapshot));
 * this file be licensed under the Apache-2.0 license or a
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                        .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        createIndex(indexName2, getRemoteStoreBackedIndexSettings());
import org.opensearch.action.delete.DeleteResponse;
        internalCluster().startDataAndWarmNodes(1, snapshotV2Settings(remoteStoreRepoPath));
        assertAcked(
        String cloneSnapshotV2 = "test-clone-snapshot-v2";
 * under the License.
        ensureGreen(indexName3);
                repositoryData1 = repositoryDataPlainActionFutureClone.get();
                    cloneSnapshotId.set(snapshotId);
            .setRenameReplacement(restoredIndexName1)
            .setWaitForCompletion(true)
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
        Client client = client();
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), true).build() }
 * not use this file except in compliance with the License.
        awaitClusterManagerFinishRepoOperations();
        Settings settings = Settings.builder()
    public static Collection<Object[]> parameters() {
        SnapshotInfo sourceSnapshotInfo = createSnapshotResponse.getSnapshotInfo();
            var nodes = internalCluster().getDataNodeInstances(Node.class);
        SnapshotInfo sourceSnapshotInfoV1 = createSnapshotResponseV1.getSnapshotInfo();
        ensureGreen(indexName1);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        internalCluster().startDataAndWarmNodes(1, snapshotV2Settings(remoteStoreRepoPath));
        CreateSnapshotResponse createSnapshotResponse = client().admin()
            .get();
    }
        }, 30, TimeUnit.SECONDS);
import org.opensearch.common.settings.Settings;
        final int numDocsInIndex2 = 20;
    }
        GetSnapshotsRequest request = new GetSnapshotsRequest(snapshotRepoName, new String[] { sourceSnapshotV2, cloneSnapshotV2 });
            RepositoryData repositoryData1;
        RestoreSnapshotResponse restoreSnapshotResponse1 = client.admin()
        assertTrue(repositoryData.getSnapshotIds().contains(sourceSnapshotInfo.snapshotId()));
                        .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
 * ownership. Elasticsearch licenses this file to you under
        assertThat(sourceSnapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        String indexName3 = "testindex3";
        String indexName2 = "testindex2";
        Client client = client();
        }, 30, TimeUnit.SECONDS);
 *
                .preparePutRepository(snapshotRepoName)
            .setWaitForCompletion(true)
import java.util.Collection;
        assertThat(sourceSnapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
                .cluster()
                        .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true)
        );
        RepositoryData repositoryData = repositoryDataPlainActionFuture.get();
            assertEquals(2, response.getSnapshots().size());
        String snapshotRepoName = "test-clone-snapshot-repo";
                .setSettings(
                        .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
            }
            .get();
        internalCluster().startDataAndWarmNodes(1, snapshotV2Settings(remoteStoreRepoPath));
    public CloneSnapshotV2IT(Settings nodeSettings) {
            .prepareCloneSnapshot(snapshotRepoName, snapshotName1, "test_clone_snapshot1")
            assertEquals(1, repositoriesMetadata.repository(snapshotRepoName).generation());
        indexRandomDocs(indexName1, numDocsInIndex1);
                .preparePutRepository(snapshotRepoName)
        internalCluster().startDataAndWarmNodes(1, snapshotV2Settings(remoteStoreRepoPath));
            }
 *
        ).repository(snapshotRepoName);
        AcknowledgedResponse response = client().admin()
        String indexName2 = "testindex2";
        createIndex(indexName3, getRemoteStoreBackedIndexSettings());
            .prepareCreateSnapshot(snapshotRepoName, snapshotName1)
        // clone should get created for v2 snapshot
        indexRandomDocs(indexName3, 10);
        assertDocsPresentInIndex(client, indexName2, numDocsInIndex2);
                }
        PlainActionFuture<RepositoryData> repositoryDataPlainActionFuture = new PlainActionFuture<>();
import org.opensearch.indices.RemoteStoreSettings;
    }
import org.opensearch.repositories.fs.FsRepository;
        awaitClusterManagerFinishRepoOperations();
                    return true;
        // Validate that the snapshot was created
        PlainActionFuture<RepositoryData> repositoryDataCloneV2PlainActionFuture = new PlainActionFuture<>();
    }
        repositoryCloneV2.getRepositoryData(repositoryDataCloneV2PlainActionFuture);
            GetSnapshotsRequest request = new GetSnapshotsRequest(snapshotRepoName);
        assertThat(sourceSnapshotInfoV1.state(), equalTo(SnapshotState.SUCCESS));
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName1)).get());
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        );
            repository.getRepositoryData(repositoryDataPlainActionFutureClone);
        ).repository(snapshotRepoName);
            .put(super.nodeSettings(nodeOrdinal))
            .get();
            GetSnapshotsResponse response = client().admin().cluster().getSnapshots(request).actionGet();
            .get();
        createIndex(indexName2, getRemoteStoreBackedIndexSettings());
        final int numDocsInIndex2 = 20;
                        .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
                )
        String indexName1 = "testindex1";
 * You may obtain a copy of the License at
            .cluster()
            .admin()
        createIndex(indexName1, getRemoteStoreBackedIndexSettings());
        String indexName2 = "testindex2";
            .setWaitForCompletion(true)
                        .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
            RepositoryData repositoryData1;
        String snapshotRepoName = "test-clone-snapshot-repo";
                        .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        createIndex(indexName1, getRemoteStoreBackedIndexSettings());
            .prepareCloneSnapshot(snapshotRepoName, sourceSnapshot, cloneSnapshot)
            GetSnapshotsRequest request = new GetSnapshotsRequest(snapshotRepoName);
        repository.getRepositoryData(repositoryDataPlainActionFuture);
                var fileCache = node.fileCache();
                        .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1);
        final BlobStoreRepository repository = (BlobStoreRepository) internalCluster().getCurrentClusterManagerNodeInstance(
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            .cluster()
        createIndex(indexName2, getRemoteStoreBackedIndexSettings());
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(sourceSnapshotInfo.successfulShards(), greaterThan(0));
                        .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        AtomicReference<SnapshotId> cloneSnapshotId = new AtomicReference<>();
        // validate that the created snapshot is v1
import org.opensearch.transport.client.Client;
        assertTrue(repositoryData.getSnapshotIds().contains(sourceSnapshotInfo.snapshotId()));
    }
            .cluster()
    @Override
    }
            assertEquals(1, repositoriesMetadata.repository(snapshotRepoName).pendingGeneration());
        assertThat(cloneSnapshotInfo.getPinnedTimestamp(), equalTo(sourceSnapshotInfo.getPinnedTimestamp()));
        }, 90, TimeUnit.SECONDS);
        repository.getRepositoryData(repositoryDataPlainActionFuture);
 * SPDX-License-Identifier: Apache-2.0
            .cluster()
        assertThat(sourceSnapshotInfo.successfulShards(), greaterThan(0));
        assertBusy(() -> {
        ensureGreen(indexName3);
        final Path remoteStoreRepoPath = randomRepoPath();
                .preparePutRepository(snapshotRepoName)
            RepositoriesService.class
            .setWaitForCompletion(true)
 * The OpenSearch Contributors require contributions made to
        logger.info("Snapshot Path [{}]", absolutePath1);
            .setIndices("*")
        return settings;
        final Path remoteStoreRepoPath = randomRepoPath();
                    return true;
        SnapshotInfo cloneInfo = response2.getSnapshots().get(1);
        AcknowledgedResponse deleteSnapshotResponse = internalCluster().clusterManagerClient()
            .get();
        AcknowledgedResponse response = client().admin()
        assertTrue(response.isAcknowledged());
        internalCluster().startDataAndWarmNodes(1, snapshotV2Settings(remoteStoreRepoPath));
        // Validate that snapshot is present in repository data
            logger.info("checking for index " + indexName + " with docId" + id);
                    Settings.builder()
        );
                repositoryData1 = repositoryDataPlainActionFutureClone.get();
                }
        // delete the source snapshot
        final Path remoteStoreRepoPath = randomRepoPath();
        indexRandomDocs(indexName2, numDocsInIndex2);
        SnapshotInfo sourceSnapshotInfo = createSnapshotResponse.getSnapshotInfo();
            .cluster()
        assertThat(sourceSnapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        assertEquals(sourceInfo.getPinnedTimestamp(), cloneInfo.getPinnedTimestamp());
        // Validate that snapshot is present in repository data
            client.admin()
            RepositoriesService.class
import org.opensearch.node.Node;
import org.opensearch.core.common.unit.ByteSizeValue;
        waitUntil(() -> {
        );
        );
                .cluster()
                .setSettings(
        SnapshotInfo sourceSnapshotInfo = createSnapshotResponse.getSnapshotInfo();
        final BlobStoreRepository repository = (BlobStoreRepository) internalCluster().getCurrentClusterManagerNodeInstance(
/*
                )
        internalCluster().startDataAndWarmNodes(1, snapshotV2Settings(remoteStoreRepoPath));
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
    }
            .setWaitForCompletion(true)
            for (SnapshotId snapshotId : repositoryData1.getSnapshotIds()) {
        }
        repository.getRepositoryData(repositoryDataPlainActionFuture);
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        ensureGreen(indexName1, indexName2);
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
        internalCluster().startClusterManagerOnlyNode(snapshotV2Settings(remoteStoreRepoPath));
            .cluster()
            .prepareRestoreSnapshot(snapshotRepoName, cloneSnapshot)
                    cloneSnapshotId.set(snapshotId);
        SnapshotInfo cloneSnapshotInfo = PlainActionFuture.get(
        assertThat(sourceSnapshotInfo.snapshotId().getName(), equalTo(sourceSnapshotV2));
            .get();
        Client client = client();
 *    http://www.apache.org/licenses/LICENSE-2.0
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        indexRandomDocs(indexName2, numDocsInIndex2);
                        .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
    @After
        ensureGreen(indexName3);
            RepositoriesService.class
            .prepareCreateSnapshot(snapshotRepoName, sourceSnapshotV1)
        String indexName3 = "testindex3";
        GetSnapshotsResponse response2 = client().admin().cluster().getSnapshots(request).actionGet();
        final BlobStoreRepository repository = (BlobStoreRepository) internalCluster().getCurrentClusterManagerNodeInstance(
        waitUntil(() -> {
        SnapshotInfo sourceSnapshotInfo = createSnapshotResponse.getSnapshotInfo();
                    Settings.builder()
            .build();
        String indexName1 = "testindex1";
        assertThat(sourceSnapshotInfo.successfulShards(), equalTo(sourceSnapshotInfo.totalShards()));
        CreateSnapshotResponse createSnapshotResponse = client().admin()
                        .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
            .put(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath))
 * this work for additional information regarding copyright
 * GitHub history for details.
        assertThat(sourceSnapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
 * the Apache License, Version 2.0 (the "License"); you may
            Metadata metadata = clusterAdmin().prepareState().get().getState().metadata();
                .setType(FsRepository.TYPE)
            RepositoriesService.class
        internalCluster().startClusterManagerOnlyNode(snapshotV2Settings(remoteStoreRepoPath));
        SnapshotInfo cloneSnapshotInfo = PlainActionFuture.get(
        indexRandomDocs(indexName3, 10);
    public void testCloneShallowCopyV2() throws Exception {
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        ensureGreen(restoredIndexName1, indexName2);
        String snapshotRepoName = "test-clone-snapshot-repo";
        String sourceSnapshotV1 = "test-source-snapshot-v1";
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
    }
            .get();
            assertTrue(cloneSnapshotInfo.indices().contains(index));
        AtomicReference<SnapshotId> cloneSnapshotId = new AtomicReference<>();
        assertThat(sourceSnapshotInfo.successfulShards(), greaterThan(0));
        String snapshotName1 = "test-create-snapshot1";
            repository.getRepositoryData(repositoryDataPlainActionFutureClone);
                .setSettings(
        ).repository(snapshotRepoName);
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        assertThat(cloneSnapshotInfo.totalShards(), equalTo(sourceSnapshotInfo.totalShards()));
                .cluster()
    }
            .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            RepositoriesMetadata repositoriesMetadata = metadata.custom(RepositoriesMetadata.TYPE);
        final SnapshotId cloneSnapshotIdFinal = cloneSnapshotId.get();
import org.opensearch.action.DocWriteResponse;
        internalCluster().startClusterManagerOnlyNode(snapshotV2Settings(remoteStoreRepoPath));
                        .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), false)
        BlobStoreRepository repositoryCloneV2 = (BlobStoreRepository) internalCluster().getCurrentClusterManagerNodeInstance(
 * license agreements. See the NOTICE file distributed with
            client.admin()
        logger.info("Snapshot Path [{}]", absolutePath1);
        assertEquals(sourceInfo.totalShards(), cloneInfo.totalShards());
/*
                        .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
        String indexName2 = "testindex2";
import java.util.concurrent.ExecutionException;
            client.admin()
        assertAcked(
            assertEquals(2, repositoriesMetadata.repository(snapshotRepoName).generation());
        String indexName1 = "testindex1";
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
                if (snapshotId.getName().equals("test_clone_snapshot1")) {
            .setIndices("*")
        // Validate that the snapshot was created
 *
            .setWaitForCompletion(true)
        awaitClusterManagerFinishRepoOperations();
            assertTrue(cloneInfo.indices().contains(index));
            try {
public class CloneSnapshotV2IT extends AbstractSnapshotIntegTestCase {
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        indexRandomDocs(indexName1, numDocsInIndex1);
 * KIND, either express or implied.  See the License for the
            client.admin()
            .cluster()
        createIndex(indexName3, getRemoteStoreBackedIndexSettings());
                .setSettings(
        assertThat(sourceSnapshotInfo.successfulShards(), equalTo(sourceSnapshotInfo.totalShards()));
        assertTrue(response.isAcknowledged());
        assertTrue(response.isAcknowledged());
            .prepareCloneSnapshot(snapshotRepoName, sourceSnapshotV2, cloneSnapshotV2)
    }
                    Settings.builder()
        }
        final int numDocsInIndex2 = 20;
                throw new RuntimeException(e);
        createIndex(indexName2, getRemoteStoreBackedIndexSettings());
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
    public void testRestoreFromClone() throws Exception {
            }
                )
        final int numDocsInIndex1 = 10;
            PlainActionFuture<RepositoryData> repositoryDataPlainActionFutureClone = new PlainActionFuture<>();
                .setType(FsRepository.TYPE)
        indexRandomDocs(indexName3, 10);
        assertThat(sourceSnapshotInfoV1.successfulShards(), greaterThan(0));
            .setIndices("*")
                        .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
            .setIndices(indexName1)
            PlainActionFuture<RepositoryData> repositoryDataPlainActionFutureClone = new PlainActionFuture<>();
        assertAcked(
        AcknowledgedResponse response = client().admin()
        assertTrue(repositoryData.getSnapshotIds().contains(sourceSnapshotInfo.snapshotId()));
        final int numDocsInIndex2 = 20;
            .prepareCreateSnapshot(snapshotRepoName, sourceSnapshotV2)
            return false;
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
        awaitClusterManagerFinishRepoOperations();
                        .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true)
    public void testCloneShallowCopyV2DeletedIndex() throws Exception {
        }, 90, TimeUnit.SECONDS);
        assertEquals(deleteResponse.getResult(), DocWriteResponse.Result.DELETED);
            .setIndices("*")
        assertThat(sourceSnapshotInfo.successfulShards(), equalTo(sourceSnapshotInfo.totalShards()));
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.repositories.RepositoriesService;
 */
        createIndex(indexName3, getRemoteStoreBackedIndexSettings());
                throw new RuntimeException(e);
import org.opensearch.core.common.unit.ByteSizeUnit;
            f -> repository.threadPool().generic().execute(ActionRunnable.supply(f, () -> repository.getSnapshotInfo(cloneSnapshotIdFinal)))
        String restoredIndexName1 = indexName1 + "-restored";
import static org.hamcrest.Matchers.greaterThan;
    @ParametersFactory
                .cluster()
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), false).build() },
 * software distributed under the License is distributed on an
            .cluster()
        assertThat(cloneSnapshotInfo.totalShards(), equalTo(sourceSnapshotInfo.totalShards()));
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
        assertThat(sourceSnapshotInfo.successfulShards(), equalTo(sourceSnapshotInfo.totalShards()));
                        .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true)
    protected Settings nodeSettings(int nodeOrdinal) {
        createIndex(indexName1, getRemoteStoreBackedIndexSettings());
            .cluster()
        return Settings.builder()
        assertThat(sourceSnapshotInfoV1.successfulShards(), equalTo(sourceSnapshotInfoV1.totalShards()));
 * Unless required by applicable law or agreed to in writing,
        ).repository(snapshotRepoName);
            try {
        String REMOTE_REPO_NAME = "remote-store-repo-name";
        // restore from clone
        assertEquals(restoreSnapshotResponse1.status(), RestStatus.OK);
            f -> repository.threadPool().generic().execute(ActionRunnable.supply(f, () -> repository.getSnapshotInfo(cloneSnapshotIdFinal)))
        internalCluster().startDataAndWarmNodes(1, snapshotV2Settings(remoteStoreRepoPath));
            .prepareCloneSnapshot(snapshotRepoName, snapshotName1, "test_clone_snapshot1")
        ensureGreen(indexName1);
            .get();
            .build();
        );
                        .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        for (String index : sourceSnapshotInfo.indices()) {
        final int numDocsInIndex1 = 10;
        assertAcked(
        assertEquals(deleteResponse.getResult(), DocWriteResponse.Result.DELETED);
            return false;
        assertAcked(deleteSnapshotResponse);
        SnapshotInfo sourceInfo = response2.getSnapshots().get(0);
                .setType(FsRepository.TYPE)
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            }
 */
package org.opensearch.snapshots;
            assertTrue(cloneSnapshotInfo.indices().contains(index));
        assertAcked(
        indexRandomDocs(indexName2, numDocsInIndex2);
        PlainActionFuture<RepositoryData> repositoryDataPlainActionFuture = new PlainActionFuture<>();
        // pinned timestamp value in clone snapshot v2 matches source snapshot v2
        // Validate that snapshot is present in repository data
            String id = Integer.toString(i);
        String cloneSnapshot = "test-clone-snapshot";
