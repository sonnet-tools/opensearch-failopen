        // delete the source snapshot
            .prepareCreateSnapshot(snapshotRepoName, sourceSnapshot)
        internalCluster().startDataAndWarmNodes(1, snapshotV2Settings(remoteStoreRepoPath));
            .setIndices("*")
            client.admin()  
        GetSnapshotsRequest request = new GetSnapshotsRequest(snapshotRepoName, new String[] { sourceSnapshotV2, cloneSnapshotV2 });
                .preparePutRepository(snapshotRepoName)  
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
            return false;
        PlainActionFuture<RepositoryData> repositoryDataPlainActionFuture = new PlainActionFuture<>();  
                        .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)  
            .setWaitForCompletion(true)  
        Client client = client();
            .put(remoteStoreClusterSettings(REMOTE_REPO_NAME, remoteStoreRepoPath))
            .prepareCloneSnapshot(snapshotRepoName, snapshotName1, "test_clone_snapshot1")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        String indexName3 = "testindex3";  
                var fileCache = node.fileCache();
        String snapshotRepoName = "test-clone-snapshot-repo";  
        }
import static org.hamcrest.Matchers.greaterThan;
        assertThat(sourceSnapshotInfo.state(), equalTo(SnapshotState.SUCCESS));  
import org.opensearch.action.ActionRunnable;  
        indexRandomDocs(indexName1, numDocsInIndex1);
        createIndex(indexName1, getRemoteStoreBackedIndexSettings());
                        .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
            .cluster()
import org.opensearch.test.OpenSearchIntegTestCase;
                .cluster()
        BlobStoreRepository repositoryCloneV2 = (BlobStoreRepository) internalCluster().getCurrentClusterManagerNodeInstance(  
        // Validate that the snapshot was created
        repository.getRepositoryData(repositoryDataPlainActionFuture);
        }, 30, TimeUnit.SECONDS);
        );
 * ownership. Elasticsearch licenses this file to you under  
            assertAcked(client().admin().indices().prepareDelete("_all").get());
            .admin()  
            .cluster()
            .setWaitForCompletion(true)
            }  
 * the Apache License, Version 2.0 (the "License"); you may
        String REMOTE_REPO_NAME = "remote-store-repo-name";  
            assertEquals(1, repositoriesMetadata.repository(snapshotRepoName).generation());
        assertThat(sourceSnapshotInfo.snapshotId().getName(), equalTo(snapshotName1));  
            .prepareCreateSnapshot(snapshotRepoName, snapshotName1)  
        assertThat(sourceSnapshotInfo.successfulShards(), greaterThan(0));
        assertThat(sourceSnapshotInfo.snapshotId().getName(), equalTo(sourceSnapshotV2));
import java.util.Arrays;
        AcknowledgedResponse deleteSnapshotResponse = internalCluster().clusterManagerClient()
            .put(super.nodeSettings(nodeOrdinal))
                .cluster()  
        assertTrue(response.isAcknowledged());
        // Validate that the snapshot was created  
        for (String index : sourceInfo.indices()) {  
    public void teardown() {
        internalCluster().startClusterManagerOnlyNode(snapshotV2Settings(remoteStoreRepoPath));  
import org.opensearch.transport.client.Client;  
                .preparePutRepository(snapshotRepoName)  
            .prepareCloneSnapshot(snapshotRepoName, snapshotName1, "test_clone_snapshot1")
        SnapshotInfo sourceSnapshotInfo = createSnapshotResponse.getSnapshotInfo();  
        SnapshotInfo cloneSnapshotInfo = PlainActionFuture.get(  
                        .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
            RepositoriesService.class
        String snapshotRepoName = "test-clone-snapshot-repo";
                .setType(FsRepository.TYPE)
        assertTrue(repositoryData.getSnapshotIds().contains(sourceSnapshotInfo.snapshotId()));
            .setIndices("*")  
                .cluster()  
            assertEquals(2, response.getSnapshots().size());
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
        AtomicReference<RepositoryData> repositoryDataAtomicReference = new AtomicReference<>();
        createIndex(indexName2, getRemoteStoreBackedIndexSettings());
        // Validate that snapshot is present in repository data
        }, 90, TimeUnit.SECONDS);  
        final int numDocsInIndex1 = 10;
            GetSnapshotsRequest request = new GetSnapshotsRequest(snapshotRepoName);
        PlainActionFuture<RepositoryData> repositoryDataPlainActionFuture = new PlainActionFuture<>();
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.core.rest.RestStatus;  
        }
            .setRenamePattern(indexName1)
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
            .cluster()  
        );
                .setType(FsRepository.TYPE)
            client.admin()
            .get();  
        assertEquals(deleteResponse.getResult(), DocWriteResponse.Result.DELETED);
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName1)).get());  
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        RestoreSnapshotResponse restoreSnapshotResponse1 = client.admin()  
    }  
        logger.info("Snapshot Path [{}]", absolutePath1);  
                if (snapshotId.getName().equals("test_clone_snapshot1")) {
        internalCluster().startClusterManagerOnlyNode(snapshotV2Settings(remoteStoreRepoPath));  
                        .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true)
            Metadata metadata = clusterAdmin().prepareState().get().getState().metadata();  
        SnapshotInfo sourceSnapshotInfo = createSnapshotResponse.getSnapshotInfo();
        ).repository(snapshotRepoName);  
                        .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
                        .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        internalCluster().startDataAndWarmNodes(1, snapshotV2Settings(remoteStoreRepoPath));
        assertThat(cloneSnapshotInfo.getPinnedTimestamp(), equalTo(sourceSnapshotInfo.getPinnedTimestamp()));
import java.util.Collection;
        assertThat(sourceSnapshotInfo.successfulShards(), equalTo(sourceSnapshotInfo.totalShards()));  
            .get();
        assertEquals(deleteResponse.getResult(), DocWriteResponse.Result.DELETED);
        String indexName3 = "testindex3";
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testRestoreFromClone() throws Exception {
            GetSnapshotsRequest request = new GetSnapshotsRequest(snapshotRepoName);
            RepositoryData repositoryData1;
            client.admin()
                )  
        // pinned timestamp value in clone snapshot v2 matches source snapshot v2
            .cluster()  
            assertEquals(2, repositoriesMetadata.repository(snapshotRepoName).generation());  
 * Unless required by applicable law or agreed to in writing,
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);  
        assertDocsPresentInIndex(client, indexName2, numDocsInIndex2);  
        // Validate that snapshot is present in repository data  
 */
        CreateSnapshotResponse createSnapshotResponse = client().admin()
                .setSettings(
                throw new RuntimeException(e);
                        .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)  
            assertTrue(cloneSnapshotInfo.indices().contains(index));
        internalCluster().startClusterManagerOnlyNode(snapshotV2Settings(remoteStoreRepoPath));
                        .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true)  
        AcknowledgedResponse response = client().admin()  
        internalCluster().startDataAndWarmNodes(1, snapshotV2Settings(remoteStoreRepoPath));
        final int numDocsInIndex2 = 20;
        for (String index : sourceSnapshotInfo.indices()) {
        );  
        assertTrue(response.isAcknowledged());
    public void testCloneShallowCopyAfterDisablingV2() throws Exception {  
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;  
        String indexName2 = "testindex2";  
                repositoryData1 = repositoryDataPlainActionFutureClone.get();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            RepositoryData repositoryData1;
                }
        ensureGreen(restoredIndexName1, indexName2);
        assertAcked(
        assertTrue(repositoryData.getSnapshotIds().contains(sourceSnapshotInfo.snapshotId()));
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)  
        indexRandomDocs(indexName1, numDocsInIndex1);  
                .setSettings(  
        }
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), false).build() },
        ensureGreen(indexName1);
        String indexName2 = "testindex2";
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
            RepositoriesService.class
        final int numDocsInIndex2 = 20;
                .setType(FsRepository.TYPE)  
        CreateSnapshotResponse createSnapshotResponseV1 = client().admin()  
        // restore from clone
        assertThat(sourceSnapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
            .setIndices("*")
        assertBusy(() -> {
                    cloneSnapshotId.set(snapshotId);
                .setSettings(
        assertTrue(repositoryData.getSnapshotIds().contains(sourceSnapshotInfo.snapshotId()));  
        indexRandomDocs(indexName1, numDocsInIndex1);  
        disableRepoConsistencyCheck("Remote store repository is being used in the test");  
 */
        indexRandomDocs(indexName2, numDocsInIndex2);  
        ensureGreen(indexName1, indexName2);
        AtomicReference<SnapshotId> cloneSnapshotId = new AtomicReference<>();
        ensureGreen(indexName1);
                }  
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
        );
        assertThat(cloneSnapshotInfo.totalShards(), equalTo(sourceSnapshotInfo.totalShards()));  
        String indexName1 = "testindex1";
        );
}
        internalCluster().startDataAndWarmNodes(1, snapshotV2Settings(remoteStoreRepoPath));  
            .prepareDeleteSnapshot(snapshotRepoName, sourceSnapshot)
    }  
        AcknowledgedResponse response = client().admin()
    }
        assertThat(sourceSnapshotInfoV1.successfulShards(), equalTo(sourceSnapshotInfoV1.totalShards()));
                if (snapshotId.getName().equals("test_clone_snapshot1")) {  
            client.admin()
        assertAcked(
        String indexName1 = "testindex1";
        indexRandomDocs(indexName2, numDocsInIndex2);  
        assertThat(sourceSnapshotInfo.snapshotId().getName(), equalTo(snapshotName1));
        assertThat(sourceSnapshotInfo.successfulShards(), greaterThan(0));
                .cluster()
            }
        internalCluster().startClusterManagerOnlyNode(snapshotV2Settings(remoteStoreRepoPath));
        );
        indexRandomDocs(indexName3, 10);
        disableRepoConsistencyCheck("Remote store repository is being used in the test");
        assertThat(sourceSnapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        // Validate that snapshot is present in repository data
        PlainActionFuture<RepositoryData> repositoryDataPlainActionFuture = new PlainActionFuture<>();
        internalCluster().startDataAndWarmNodes(1, snapshotV2Settings(remoteStoreRepoPath));  
            .get();
        awaitClusterManagerFinishRepoOperations();
 * specific language governing permissions and limitations
        RepositoryData repositoryData = repositoryDataPlainActionFuture.get();
 * Licensed to Elasticsearch under one or more contributor  
        ensureGreen(indexName1, indexName2);
        // disable snapshot v2 in repo
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;
        assertTrue(response.isAcknowledged());  
        }
import org.opensearch.core.common.unit.ByteSizeUnit;
                        .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
                .setType(FsRepository.TYPE)
        indexRandomDocs(indexName2, numDocsInIndex2);
            .build();
        RepositoryData repositoryData = repositoryDataPlainActionFuture.get();
        CreateSnapshotResponse createSnapshotResponse = client().admin()  
import java.util.concurrent.atomic.AtomicReference;
import org.opensearch.repositories.RepositoryData;
            logger.info("checking for index " + indexName + " with docId" + id);  
            .get();
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        awaitClusterManagerFinishRepoOperations();
        repositoryCloneV2.getRepositoryData(repositoryDataCloneV2PlainActionFuture);  
import org.opensearch.action.delete.DeleteResponse;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
                        .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
                )
            assertTrue(cloneSnapshotInfo.indices().contains(index));  
        final Path remoteStoreRepoPath = randomRepoPath();  
        String sourceSnapshotV1 = "test-source-snapshot-v1";  
                        .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), false)
        assertThat(sourceSnapshotInfo.successfulShards(), equalTo(sourceSnapshotInfo.totalShards()));
        GetSnapshotsResponse response2 = client().admin().cluster().getSnapshots(request).actionGet();  
            .build();
                        .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())
            var nodes = internalCluster().getDataNodeInstances(Node.class);
        String snapshotName1 = "test-create-snapshot1";  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
        createIndex(indexName1, getRemoteStoreBackedIndexSettings());  
        createIndex(indexName3, getRemoteStoreBackedIndexSettings());  
        ensureGreen(indexName1, indexName2);
 */  
        deleteResponse = client().prepareDelete(indexName1, "2").execute().actionGet();  
            .prepareCreateSnapshot(snapshotRepoName, snapshotName1)
        final Path remoteStoreRepoPath = randomRepoPath();
        assertThat(cloneSnapshotInfo.totalShards(), equalTo(sourceSnapshotInfo.totalShards()));
    public void testCloneShallowCopyV2() throws Exception {
            for (var node : nodes) {  
import java.util.concurrent.TimeUnit;
            .cluster()  
 *
 *  
            .cluster()  
        String indexName3 = "testindex3";
        }, 90, TimeUnit.SECONDS);
        assertDocsPresentInIndex(client, restoredIndexName1, numDocsInIndex1);
    public CloneSnapshotV2IT(Settings nodeSettings) {
                )  
        logger.info("Snapshot Path [{}]", absolutePath1);  
        waitUntil(() -> {  
                .cluster()
        logger.info("Snapshot Path [{}]", absolutePath1);
import java.util.concurrent.ExecutionException;  
        // Validate that snapshot is present in repository data
    }
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), true).build() }  
        deleteResponse = client().prepareDelete(indexName1, "1").execute().actionGet();  
                    cloneSnapshotId.set(snapshotId);  
            RepositoriesMetadata repositoriesMetadata = metadata.custom(RepositoriesMetadata.TYPE);
                repositoryData1 = repositoryDataPlainActionFutureClone.get();  
    }
        AcknowledgedResponse response = client().admin()
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;  
        return Settings.builder()
        repository.getRepositoryData(repositoryDataPlainActionFuture);  
 * You may obtain a copy of the License at  
                    Settings.builder()  
            RepositoriesService.class
        assertThat(sourceSnapshotInfo.successfulShards(), greaterThan(0));  
            assertTrue(cloneInfo.indices().contains(index));
import org.junit.After;
        ensureGreen(indexName3);
                        .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())  
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
            assertEquals(2, repositoriesMetadata.repository(snapshotRepoName).pendingGeneration());
            .cluster()
        final int numDocsInIndex1 = 10;  
                        .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
                .preparePutRepository(snapshotRepoName)
                fileCache.clear();
        CreateSnapshotResponse createSnapshotResponse = client().admin()
    public static Collection<Object[]> parameters() {  
            .get();
        assertThat(cloneSnapshotInfo.getPinnedTimestamp(), equalTo(sourceSnapshotInfo.getPinnedTimestamp()));  
        ensureGreen(indexName3);
            .cluster()
            client.admin()
        createIndex(indexName1, getRemoteStoreBackedIndexSettings());  
        createIndex(indexName3, getRemoteStoreBackedIndexSettings());
 * under the License.  
        SnapshotInfo sourceSnapshotInfoV1 = createSnapshotResponseV1.getSnapshotInfo();
            f -> repository.threadPool().generic().execute(ActionRunnable.supply(f, () -> repository.getSnapshotInfo(cloneSnapshotIdFinal)))  
                .setSettings(
 * SPDX-License-Identifier: Apache-2.0
        ensureGreen(indexName1);
            repository.getRepositoryData(repositoryDataPlainActionFutureClone);
        assertEquals(sourceInfo.totalShards(), cloneInfo.totalShards());
        createIndex(indexName2, getRemoteStoreBackedIndexSettings());
            .prepareCreateSnapshot(snapshotRepoName, sourceSnapshotV1)
            } catch (InterruptedException | ExecutionException e) {
            RepositoriesService.class  
        final int numDocsInIndex1 = 10;  
                    Settings.builder()
        String sourceSnapshot = "test-source-snapshot";
                        .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        final int numDocsInIndex2 = 20;
                )
        assertThat(sourceSnapshotInfo.successfulShards(), equalTo(sourceSnapshotInfo.totalShards()));
        final BlobStoreRepository repository = (BlobStoreRepository) internalCluster().getCurrentClusterManagerNodeInstance(  
import org.opensearch.core.common.unit.ByteSizeValue;
import org.opensearch.cluster.metadata.RepositoriesMetadata;
 * Modifications Copyright OpenSearch Contributors. See  
        SnapshotInfo cloneSnapshotInfo = PlainActionFuture.get(
import org.opensearch.indices.RemoteStoreSettings;
        internalCluster().startDataAndWarmNodes(1, snapshotV2Settings(remoteStoreRepoPath));
        assertThat(sourceSnapshotInfo.snapshotId().getName(), equalTo(sourceSnapshot));
            }  
            .cluster()
        awaitClusterManagerFinishRepoOperations();  
    }  
            .get();  
    }
        String snapshotName1 = "test-create-snapshot1";
        Client client = client();
        // Validate that the snapshot was created
        assertThat(sourceSnapshotInfoV1.state(), equalTo(SnapshotState.SUCCESS));  
        Client client = client();
            .setIndices(indexName1)
import org.opensearch.action.DocWriteResponse;
                )
        String indexName2 = "testindex2";
            .prepareCloneSnapshot(snapshotRepoName, sourceSnapshotV2, cloneSnapshotV2)
        waitUntil(() -> {
        CreateSnapshotResponse createSnapshotResponse = client().admin()
        final BlobStoreRepository repository = (BlobStoreRepository) internalCluster().getCurrentClusterManagerNodeInstance(
        internalCluster().startDataAndWarmNodes(1, snapshotV2Settings(remoteStoreRepoPath));
        assertThat(sourceSnapshotInfo.successfulShards(), equalTo(sourceSnapshotInfo.totalShards()));
        String sourceSnapshotV2 = "test-source-snapshot-v2";
/*  
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)  
            .setWaitForCompletion(true)
import java.nio.file.Path;  
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
        DeleteResponse deleteResponse = client().prepareDelete(indexName1, "0").execute().actionGet();
import org.opensearch.node.Node;  
                        .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true)  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        for (int i = 0; i < numOfDocs; i++) {
        SnapshotInfo sourceSnapshotInfo = createSnapshotResponse.getSnapshotInfo();
            .get();  
 *
package org.opensearch.snapshots;
        Client client = client();
/*
            .setWaitForCompletion(true)
        assertThat(sourceSnapshotInfo.successfulShards(), greaterThan(0));  
        assertAcked(deleteSnapshotResponse);
                        .put(BlobStoreRepository.SHALLOW_SNAPSHOT_V2.getKey(), true)
        AcknowledgedResponse response = client().admin()
import org.opensearch.common.settings.Settings;  
    @Override
 * not use this file except in compliance with the License.
                .setSettings(  
        assertEquals(restoreSnapshotResponse1.status(), RestStatus.OK);  
 * this work for additional information regarding copyright
        assertEquals(deleteResponse.getResult(), DocWriteResponse.Result.DELETED);  
        PlainActionFuture<RepositoryData> repositoryDataCloneV2PlainActionFuture = new PlainActionFuture<>();
            .setIndices("*")
            try {  
                        .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)  
        String indexName2 = "testindex2";
        for (String index : sourceSnapshotInfo.indices()) {
        final int numDocsInIndex2 = 20;
        ensureGreen(indexName1);  
                    Settings.builder()
            GetSnapshotsResponse response = client().admin().cluster().getSnapshots(request).actionGet();  
            .setWaitForCompletion(true)  
            try {
            .get();  
import org.opensearch.cluster.metadata.Metadata;
        return Arrays.asList(
        indexRandomDocs(indexName2, numDocsInIndex2);
                .preparePutRepository(snapshotRepoName)
            Metadata metadata = clusterAdmin().prepareState().get().getState().metadata();
        createIndex(indexName2, getRemoteStoreBackedIndexSettings());
        final SnapshotId cloneSnapshotIdFinal = cloneSnapshotId.get();
            PlainActionFuture<RepositoryData> repositoryDataPlainActionFutureClone = new PlainActionFuture<>();
                    return true;
        createIndex(indexName3, getRemoteStoreBackedIndexSettings());
        disableRepoConsistencyCheck("Remote store repository is being used in the test");  
        AtomicReference<SnapshotId> cloneSnapshotId = new AtomicReference<>();
        String snapshotRepoName = "test-clone-snapshot-repo";
        assertBusy(() -> {  
    @ParametersFactory
            PlainActionFuture<RepositoryData> repositoryDataPlainActionFutureClone = new PlainActionFuture<>();
 * KIND, either express or implied.  See the License for the
        // clone should get created for v2 snapshot
            .setWaitForCompletion(true)  
                        .put(FsRepository.COMPRESS_SETTING.getKey(), randomBoolean())  
        // create source snapshot which is v2
        if (WRITABLE_WARM_INDEX_SETTING.get(settings)) {  
        String cloneSnapshotV2 = "test-clone-snapshot-v2";
        indexRandomDocs(indexName3, 10);  
                        .put(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY.getKey(), true)
        String snapshotRepoName = "test-clone-snapshot-repo";
            for (SnapshotId snapshotId : repositoryData1.getSnapshotIds()) {
        assertAcked(
            RepositoriesMetadata repositoriesMetadata = metadata.custom(RepositoriesMetadata.TYPE);
            for (SnapshotId snapshotId : repositoryData1.getSnapshotIds()) {
                        .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        assertTrue(response.isAcknowledged());
        ensureGreen(indexName3);  
            .prepareCloneSnapshot(snapshotRepoName, sourceSnapshot, cloneSnapshot)  
                        .put(FsRepository.CHUNK_SIZE_SETTING.getKey(), randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        String indexName1 = "testindex1";
        createIndex(indexName2, getRemoteStoreBackedIndexSettings());
            .get();
            .cluster()
            String id = Integer.toString(i);
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(indexName2)).get());
                    Settings.builder()
                    Settings.builder()  
        createIndex(indexName1, getRemoteStoreBackedIndexSettings());
 * GitHub history for details.
        assertAcked(  
        final Path remoteStoreRepoPath = randomRepoPath();
        internalCluster().startDataAndWarmNodes(1, snapshotV2Settings(remoteStoreRepoPath));
        assertThat(sourceSnapshotInfoV1.successfulShards(), greaterThan(0));
            assertTrue("doc with id" + id + " is not present for index " + indexName, client.prepareGet(indexName, id).get().isExists());
        ).repository(snapshotRepoName);
            .get();  
        String indexName1 = "testindex1";  
        final int numDocsInIndex1 = 10;
            repository.getRepositoryData(repositoryDataPlainActionFutureClone);  
                        .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
                .preparePutRepository(snapshotRepoName)
            } catch (InterruptedException | ExecutionException e) {
            .setRenameReplacement(restoredIndexName1)  
        return settings;
        logger.info("--> create source snapshot");  
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.equalTo;  
        }, 30, TimeUnit.SECONDS);
        SnapshotInfo sourceInfo = response2.getSnapshots().get(0);
        awaitClusterManagerFinishRepoOperations();
 * software distributed under the License is distributed on an
        // assertThat(sourceSnapshotInfoV1.getPinnedTimestamp(), equalTo(0L));  
        RepositoryData repositoryData = repositoryDataPlainActionFuture.get();  
        super(nodeSettings);
        ).repository(snapshotRepoName);
                .setType(FsRepository.TYPE)
import org.opensearch.repositories.fs.FsRepository;
        // Validate that snapshot is present in repository data
            assertEquals(1, repositoriesMetadata.repository(snapshotRepoName).pendingGeneration());  
        assertAcked(  
                        .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)  
/*
        // validate that the created snapshot is v1
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private void assertDocsPresentInIndex(Client client, String indexName, int numOfDocs) {  
                    return true;
            }
    }  
 * license agreements. See the NOTICE file distributed with
public class CloneSnapshotV2IT extends AbstractSnapshotIntegTestCase {
            return false;
        logger.info("Snapshot Path [{}]", absolutePath1);  
        String restoredIndexName1 = indexName1 + "-restored";
    }
        indexRandomDocs(indexName1, numDocsInIndex1);
                throw new RuntimeException(e);  
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())  
 * compatible open source license.
import org.opensearch.action.support.PlainActionFuture;
        final SnapshotId cloneSnapshotIdFinal = cloneSnapshotId.get();
        );
    @After
import org.opensearch.repositories.RepositoriesService;
            .cluster()
        Path absolutePath1 = randomRepoPath().toAbsolutePath();
            }  
        repository.getRepositoryData(repositoryDataPlainActionFuture);
            f -> repository.threadPool().generic().execute(ActionRunnable.supply(f, () -> repository.getSnapshotInfo(cloneSnapshotIdFinal)))
            assertEquals(3, response2.getSnapshots().size());
        }
        );
            .get();
        SnapshotInfo sourceSnapshotInfo = createSnapshotResponse.getSnapshotInfo();
        ensureGreen(indexName1, indexName2);
    public void testCloneShallowCopyV2DeletedIndex() throws Exception {
        SnapshotInfo cloneInfo = response2.getSnapshots().get(1);  
        assertEquals(sourceInfo.getPinnedTimestamp(), cloneInfo.getPinnedTimestamp());
    }  
        final Path remoteStoreRepoPath = randomRepoPath();
    private Settings snapshotV2Settings(Path remoteStoreRepoPath) {
        Settings settings = Settings.builder()
            GetSnapshotsResponse response2 = client().admin().cluster().getSnapshots(request).actionGet();  
            .prepareCreateSnapshot(snapshotRepoName, sourceSnapshotV2)
        assertThat(sourceSnapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
            .prepareRestoreSnapshot(snapshotRepoName, cloneSnapshot)
                        .put(FsRepository.LOCATION_SETTING.getKey(), absolutePath1)
        indexRandomDocs(indexName3, 10);
        final BlobStoreRepository repository = (BlobStoreRepository) internalCluster().getCurrentClusterManagerNodeInstance(
        ).repository(snapshotRepoName);
        String cloneSnapshot = "test-clone-snapshot";  
