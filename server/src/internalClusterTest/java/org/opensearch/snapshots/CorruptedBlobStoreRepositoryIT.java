        CreateSnapshotResponse createSnapshotResponse = client.admin()
            .prepareCreateSnapshot("test-repo", "test-snap-1")
        createRepository("test-repo", "fs", repo);  
            clusterAdmin().prepareSnapshotStatus("test-repo").addSnapshots("test-snap"),  
        assertAcked(client().admin().indices().prepareDelete(indexName));  
 * ownership. Elasticsearch licenses this file to you under  
        createRepository("test-repo", "fs", repo);
        createRepository("test-repo", "fs", repo);
        logger.info("--> indexing some data");
        logger.info("--> verify index-N blob is found at the new location");  
            .cluster()
            .resolve("index-" + repositoryData.shardGenerations().getShardGen(corruptedIndex, 0));
        logger.info("--> move index-N blob to next generation");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
        logger.info("--> creating snapshot");
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        assertThat(
import java.nio.channels.SeekableByteChannel;
        Files.move(repo.resolve("index-" + beforeMoveGen), repo.resolve("index-" + (beforeMoveGen + 1)));
            .get();  
            () -> client.admin().cluster().prepareDeleteSnapshot(repo, existingSnapshot).execute().actionGet()  
        Files.move(repo.resolve("index-" + beforeMoveGen), repo.resolve("index-" + (beforeMoveGen + 1)));
            .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES);
        final Path indicesPath = repo.resolve("indices");
        logger.info("--> creating snapshot");
        logger.info("--> full cluster restart");
            RepositoryException.class,  
        final SnapshotInfo snapshotInfo2 = clusterAdmin().prepareCreateSnapshot("test-repo", snapshot2)
        }
        );  
        assertThat(getRepositoryData(repository).getGenId(), is(beforeMoveGen + 1));
        ensureGreen();
        final RepositoryData repositoryData = getRepositoryData(repoName);  
            .setIndices("test-idx-*")
 *    http://www.apache.org/licenses/LICENSE-2.0
            .setWaitForCompletion(true)
            .get();
                            RepositoriesMetadata.TYPE,
        flushAndRefresh();
                    Metadata.builder(currentState.getMetadata())
            logger.info("--> move index-N blob back to initial generation");
        logger.info("--> indexing some data");  
    }  
                .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)  
            true,
        logger.info("--> verify index-N blob is found at the expected location");
        );
        final String repoName = "test-repo";
        startDeleteSnapshot("test-repo", "test-snap-1").get();  
        );
        final Client client = client();
import org.opensearch.repositories.RepositoryException;  
        logger.info("--> try to delete snapshot");  
            containsString("Could not read repository data because the contents of the repository do not match its expected state.")
        );
        );  
 * GitHub history for details.
    public void testConcurrentlyChangeRepositoryContents() throws Exception {
        logger.info("--> delete snapshot");
        final Path shardIndexFile = repo.resolve(resolvePath(corruptedIndex, "0"))  
        Client client = client();  
        logger.info("--> indexing some data");
        logger.info("-->  truncating shard index file [{}]", shardIndexFile);  
        logger.info("--> verify loading repository data from newly mounted repository throws RepositoryException");
        startDeleteSnapshot("test-repo", "test-snap-1").get();  
        assertThat(snapshotInfos.get(0).snapshotId().getName(), equalTo("test-snap"));  
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
            }  
        assertThat(getRepositoryData(repository).getGenId(), is(beforeMoveGen + 2));  
            createSnapshotResponse.getSnapshotInfo().successfulShards(),  
        Path snapshotPath = repo.resolve("snap-" + createSnapshotResponse.getSnapshotInfo().snapshotId().getUUID() + ".dat");
                .put("compress", false)
            .cluster()
            .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES);
 * Unless required by applicable law or agreed to in writing,
        Client client = client();
        CreateSnapshotResponse createSnapshotResponse = client.admin()
            .setIndices(indices)
            "--> restoring the first snapshot, the repository should not have lost any shard data despite deleting index-N, "
    /** Tests that a snapshot with a corrupted global state file can still be deleted */
        logger.info("--> set next generation as pending in the cluster state");
            .put("compress", false)  
        createIndex("test-idx-1", "test-idx-2");  
import static org.hamcrest.Matchers.equalTo;  
        createRepository(  
            Files.delete(shardGen);
        logger.info("--> creating snapshot");  
        assertThat(snapshotInfos.size(), equalTo(1));
            client().prepareIndex("test-idx-1").setSource("foo", "bar"),
        );  
            true,
                .put("location", repo)
        expectThrows(  
        logger.info("--> remove repository");  
        assertThat(
        assertThat(snapshotInfo2.successfulShards(), equalTo(snapshotInfo.totalShards() - 1));
        assertEquals(0, restoreSnapshotResponse.getRestoreInfo().failedShards());
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())  
            }
                                .<RepositoriesMetadata>custom(RepositoriesMetadata.TYPE)  
            .get()  
                // Don't cache repository data because the test manually modifies the repository data
            .setIndices("test-idx-*")
/*  
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Path repo = randomRepoPath();
 *  
            Settings.builder()
        expectThrows(  
            () -> client.admin().cluster().prepareGetSnapshots("test-repo").addSnapshots("test-snap-1").get()  
        try (SeekableByteChannel outChan = Files.newByteChannel(snapshotPath, StandardOpenOption.WRITE)) {  
                shardGen = shardFiles.filter(file -> file.getFileName().toString().startsWith(BlobStoreRepository.INDEX_FILE_PREFIX))
        startDeleteSnapshot(repoName, snapshot).get();  
        logger.info("--> make sure snapshot doesn't exist");  
        final Path repo = randomRepoPath();
        assertThat(snapshotInfos.get(0).state(), equalTo(SnapshotState.SUCCESS));
            client().prepareIndex("test-idx-2").setSource("foo", "bar")  
        createRepository(  
        Path repo = randomRepoPath();
        List<SnapshotInfo> snapshotInfos = clusterAdmin().prepareGetSnapshots("test-repo").get().getSnapshots();  
 * KIND, either express or implied.  See the License for the
            .setWaitForCompletion(true)
        logger.info("--> creating snapshot");
    public void testSnapshotWithCorruptedShardIndexFile() throws Exception {  
        logger.info("--> verify index-N blob is found at the new location");
            "fs",
                .metadata(
            true,
        );
            SnapshotMissingException.class,
    }
            outChan.truncate(randomInt(10));
            .get();  
        assertThat(
            "test-repo",  
    }
                );
    public void testDeleteSnapshotWithCorruptedGlobalState() throws Exception {
        logger.info("--> make sure snapshot doesn't exist");
            .setWaitForCompletion(true)
        assertThat(indexIds.size(), equalTo(1));  
            .prepareCreateSnapshot("test-repo", "test-snap-1")
        indexRandom(
                .build()
import org.opensearch.cluster.ClusterState;
            () -> client.admin().cluster().prepareCreateSnapshot(repo, existingSnapshot).execute().actionGet()
            () -> client.admin().cluster().prepareGetSnapshots("test-repo").addSnapshots("test-snap-1").get().getSnapshots()
        logger.info("--> indexing some data");
        logger.info("--> move index-N blob to next generation");
                .put(BlobStoreRepository.CACHE_REPOSITORY_DATA.getKey(), false)
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
        );  
        indexRandom(  
        logger.info("--> creating snapshot");  
        final SnapshotsService snapshotsService = internalCluster().getCurrentClusterManagerNodeInstance(SnapshotsService.class);
        final String snapshot2 = "test-snap-2";
            .setIndices("test-idx-1")
    public void testConcurrentlyChangeRepositoryContentsInBwCMode() throws Exception {
        assertRequestBuilderThrows(
import org.opensearch.common.settings.Settings;
        final Map<String, IndexId> indexIds = repositoryData.getIndices();
            true,  
        final Repository repository = internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class)
                                .withUpdatedGeneration(repository.getMetadata().name(), beforeMoveGen, beforeMoveGen + 1)
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
            () -> client.admin().cluster().prepareGetSnapshots(repoName).addSnapshots(snapshot).get()  
        assertThat(  
        Client client = client();  
    }
            .repository(repoName);
        );
        final String indexName = "test-idx";  
public class CorruptedBlobStoreRepositoryIT extends AbstractSnapshotIntegTestCase {
        logger.info("-->  creating snapshot [{}]", snapshot2);  
            client().prepareIndex().setIndex("test-idx-2").setSource("foo", "bar")  
import static org.hamcrest.Matchers.greaterThan;
        indexRandom(
        for (String index : indices) {
        logger.info("--> creating snapshot");  
            .getSnapshotInfo();
 * You may obtain a copy of the License at  
        assertThat(
        logger.info("--> make sure snapshot doesn't exist");
        );
            containsString("Could not read repository data because the contents of the repository do not match its expected state.")
            SnapshotMissingException.class,
 * license agreements. See the NOTICE file distributed with
            RepositoryException.class,
        try (SeekableByteChannel outChan = Files.newByteChannel(shardIndexFile, StandardOpenOption.WRITE)) {
        indexRandom(  
        logger.info("-->  creating index [{}] with [{}] documents in it", indexName, nDocs);  
        final String snapshot = "test-snap";
        final String snapshot = "test-snap";  
        );
        );  
        );  
            .repository(repoName);  
            .get();
                        .putCustom(  
            documents[j] = client.prepareIndex(indexName).setSource("foo2", "bar2");
        logger.info("--> make sure that we can create the snapshot again");
        );
    }
            Settings.builder().put("location", repo).put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
            .put("location", repo)
        );  
            .get();
                .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        );
    }
        assertThat(snapshotStatusResponse.getSnapshots(), hasSize(1));  
        );
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
        Files.delete(metadata);
        expectThrows(SnapshotMissingException.class, () -> clusterAdmin().prepareGetSnapshots("test-repo").addSnapshots("test-snap").get());
            Files.delete(shardZero.resolve("snap-" + snapshotInfo.snapshotId().getUUID() + ".dat"));  
        final String otherRepoName = "other-repo";  
            .get();
        SnapshotInfo snapshotInfo = createFullSnapshot("test-repo", "test-snap");
        }
            client().prepareIndex("test-idx-2").setSource("foo", "bar")
            IOUtils.deleteFilesIgnoringExceptions(globalStatePath);
        logger.info("-->  deleting index [{}]", indexName);
 */  
        Client client = client();
        );  
import org.opensearch.cluster.metadata.Metadata;  
        createRepository(
        );
 * compatible open source license.
        createRepository(  
            repoName,
            logger.info("--> verify repository remains blocked");
        createIndex("test-idx-1", "test-idx-2");
import org.opensearch.repositories.IndexId;
        final RepositoryException repositoryException4 = expectThrows(
            client().prepareIndex().setIndex("test-idx-1").setSource("foo", "bar"),
import org.opensearch.cluster.metadata.RepositoriesMetadata;
 * this file be licensed under the Apache-2.0 license or a
        for (String index : indices) {  
import java.util.Map;  
        );  
            .setWaitForCompletion(true)  
            .setWaitForCompletion(true)  
        final SnapshotInfo snapshotInfo = createSnapshotResponse.getSnapshotInfo();  
import org.opensearch.action.index.IndexRequestBuilder;
            client().prepareIndex("test-idx-1").setSource("foo", "bar"),  
            .get();  
            () -> client.admin().cluster().prepareGetSnapshots(repoName).addSnapshots(snapshot).get()
        CreateSnapshotResponse createSnapshotResponse = client.admin()  
        );  
                )
 * software distributed under the License is distributed on an
            client().prepareIndex("test-idx-2").setSource("foo", "bar")  
            .setWaitForCompletion(true)  
                    shardZero.resolve("index-" + getRepositoryData("test-repo").shardGenerations().getShardGen(indexIds.get(index), 0))  
    }
            assertRepositoryBlocked(client, repoName, snapshot);  
        Path repo = randomRepoPath();  
        assertThat(snapshotStatusResponse.getSnapshots().get(0).getSnapshot().getSnapshotId().getName(), equalTo("test-snap"));
 * not use this file except in compliance with the License.
        );
import static org.hamcrest.Matchers.hasSize;
            client().prepareIndex("test-idx-1").setSource("foo", "bar"),
        CreateSnapshotResponse createSnapshotResponse = client().admin()
        createIndex(indices);  
            if (randomBoolean()) {
 */  
        logger.info("-->  creating repository at {}", repo.toAbsolutePath());  
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        logger.info("--> verify index-N blob is found at the expected location");
        expectThrows(RepositoryException.class, () -> getRepositoryData(repository));
        );
        }
        logger.info("--> recreate repository");  
            assertTrue(Files.notExists(indicesPath.resolve(indexIds.get(index).getId())));
        logger.info("--> creating another snapshot");
        }  
            .setWaitForCompletion(true)
            outChan.truncate(randomInt(10));
            createSnapshotResponse.getSnapshotInfo().totalShards() - 1  
        assertThat(snapshotInfo2.indices(), hasSize(1));
                        )
            .put("compress", false)  
            () -> client.admin().cluster().prepareGetSnapshots("test-repo").addSnapshots("test-snap-1").get()
        CreateSnapshotResponse createSnapshotResponse = client.admin()  
        Path repo = randomRepoPath();
import org.opensearch.repositories.RepositoryData;
        assertThat(snapshotInfo.indices(), hasSize(1));
            .cluster()
                .put("compress", false)
        logger.info("--> move index-N blob to next generation");
    public void testDeleteSnapshotWithMissingMetadata() throws Exception {
                + "because it uses snap-*.data files and not the index-N to determine what files to restore"
        assertThat(snapshotInfos.get(0).snapshotId().getName(), equalTo(snapshot1));  
}
        assertThat(  
    public void testSnapshotWithMissingShardLevelIndexFile() throws Exception {
 * this work for additional information regarding copyright
                .put("location", repo)
        createRepository(
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));  
        client.admin().cluster().prepareDeleteSnapshot(repoName, snapshot).get();  
        assertAcked(prepareCreate(indexName).setSettings(indexSettingsNoReplicas(1)));
            SnapshotMissingException.class,
            .cluster()  
        );
                .put("compress", false)
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())  
            SnapshotMissingException.class,
        assertRepositoryBlocked(client, repoName, snapshot);
            createSnapshotResponse.getSnapshotInfo().successfulShards(),  
 * Modifications Copyright OpenSearch Contributors. See
 *
     * Tests that a shard snapshot with a corrupted shard index file can still be used for restore and incremental snapshots.
        updateClusterState(
            SnapshotMissingException.class
        }
            true,
                        .build()  
        final String snapshot1 = "test-snap-1";  
            "test-repo",
            .cluster()  
        logger.info("--> wait for all listeners on snapshots service to be resolved to avoid snapshot task batching causing a conflict");
        expectThrows(
        createFullSnapshot("test-repo", "test-snap");
        final long beforeMoveGen = repositoryData.getGenId();
        logger.info("--> make sure snapshot doesn't exist");
        assertThat(getRepositoryData(repoName).getGenId(), is(beforeMoveGen + 1));
import org.opensearch.core.common.unit.ByteSizeUnit;
                outChan.truncate(randomInt(10));
        CreateSnapshotResponse createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap-2")  
        final Repository repository = internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class)
            .put("location", repo)
        logger.info("--> delete index metadata and shard metadata");
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
 * the Apache License, Version 2.0 (the "License"); you may
        logger.info("-->  verifying snapshot state for [{}]", snapshot1);
 *
            .setIndices("test-idx-*")  
        final Path repo = randomRepoPath();  
                .put("location", repo)
        } else {
import org.opensearch.common.util.io.IOUtils;  
        Client client = client();
            () -> client().admin().cluster().prepareGetSnapshots(repoName).addSnapshots(snapshot).get()
    public void testFindDanglingLatestGeneration() throws Exception {  
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));  
        Files.move(repo.resolve("index-" + repositoryData.getGenId()), repo.resolve("index-" + (repositoryData.getGenId() + 1)));  
        final String[] indices = { "test-idx-1", "test-idx-2" };
        final String repoName = "test-repo";
            currentState -> ClusterState.builder(currentState)  
        logger.info("--> make sure snapshot doesn't exist");
import static org.hamcrest.Matchers.is;  
        final RepositoryData repositoryData = getRepositoryData(repoName);  
/*  
            Settings.builder()  
    }  
            client().prepareIndex().setIndex("test-idx-2").setSource("foo", "bar")
        assertThat(getRepositoryData(repoName).getGenId(), is(beforeMoveGen + 2));  
        logger.info("-->  indexing [{}] more documents into [{}]", nDocs, indexName);
        startDeleteSnapshot("test-repo", "test-snap-1").get();  
import org.opensearch.transport.client.Client;
        createIndex("test-idx-1", "test-idx-2");
                .put("compress", false)  
        createRepository(repoName, "fs", settings);
            client().prepareIndex().setIndex("test-idx-2").setSource("foo", "bar")
        indexRandom(  
            Settings.builder()  
        ensureGreen();
            "fs",
                    .findFirst()
        logger.info("--> try to create snapshot");
        );  
        assertThat(snapshotInfos.size(), equalTo(1));
        }  
        logger.info("--> delete global state metadata");
        if (randomBoolean()) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
                            currentState.metadata()
        final String repoName = "test-repo";
        logger.info("--> indexing some data");
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
            }
    }  
/*
        expectThrows(  
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        assertEquals(
 * specific language governing permissions and limitations
        CreateSnapshotResponse createSnapshotResponse = client.admin()
            true,
 */
            client().prepareIndex().setIndex("test-idx-1").setSource("foo", "bar"),  
        createRepository(repoName, "fs", settings);  
        logger.info("--> creating snapshot");
        );
        final RepositoryException repositoryException3 = expectThrows(
            .get();
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap-1")
            .setWaitForCompletion(true)
        final Map<String, IndexId> indexIds = getRepositoryData("test-repo").getIndices();
 * The OpenSearch Contributors require contributions made to  
            repoName,
            .cluster()
    public void testDeleteSnapshotWithMissingIndexAndShardMetadata() throws Exception {
        );  
            .setIndices("test-idx-*")  
        Path metadata = repo.resolve("meta-" + createSnapshotResponse.getSnapshotInfo().snapshotId().getUUID() + ".dat");  
        );
        logger.info("--> creating snapshot");  
        final IndexRequestBuilder[] documents = new IndexRequestBuilder[nDocs];  
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
            "fs",  
        logger.info("--> indexing some data");  
package org.opensearch.snapshots;
            SnapshotMissingException.class,
        final SnapshotInfo snapshotInfo = createFullSnapshot("test-repo", snapshot1);
 * under the License.  
            true,  
        assertThat(snapshotInfo2.state(), equalTo(SnapshotState.PARTIAL));
 * Licensed to Elasticsearch under one or more contributor  
            "fs",
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
            .cluster()
                Files.delete(
            client().prepareIndex("test-idx-2").setSource("foo", "bar")
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        final IndexId corruptedIndex = indexIds.get(indexName);
        expectThrows(  
        Files.write(repo.resolve("index-" + repositoryData.getGenId()), randomByteArrayOfLength(randomIntBetween(1, 100)));
        createIndex("test-idx-1", "test-idx-2");
        Path repo = randomRepoPath();
        assertThat(  
            true,
            client().prepareIndex("test-idx-1").setSource("foo", "bar"),
            .setWaitForCompletion(true)
        final RepositoryData repositoryData = getRepositoryData(repository);  
        for (int j = 0; j < nDocs; j++) {
        logger.info("--> verify loading repository data throws RepositoryException");  
        final RepositoryData repositoryData = getRepositoryData(repoName);
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
        Settings.Builder settings = Settings.builder()
        );
        );
        assertThat(snapshotInfo2.failedShards(), equalTo(1));  
        assertThat(
            documents[j] = client.prepareIndex(indexName).setSource("foo", "bar");
            final Path shardGen;
        flushAndRefresh("test-idx-1", "test-idx-2");  
        logger.info("--> deleting shard level index file");  
        assertAcked(startDeleteSnapshot("test-repo", "test-snap").get());  
        Path repo = randomRepoPath();
                .put("location", repo)
            .get();  
            .setRestoreGlobalState(randomBoolean())
    private void assertRepositoryBlocked(Client client, String repo, String existingSnapshot) {
            // Truncate the global state metadata file  
        Path repo = randomRepoPath();
            repositoryException4.getMessage(),
            .get();  
            .cluster()
        final Repository repository = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class).repository(repoName);  
            client().prepareIndex("test-idx-2").setSource("foo", "bar"),  
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        Settings.Builder settings = Settings.builder()
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
            try (SeekableByteChannel outChan = Files.newByteChannel(globalStatePath, StandardOpenOption.WRITE)) {
            // Delete the global state metadata file  
            .prepareCreateSnapshot(repoName, snapshot)
            .get();
                .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        assertThat(snapshotInfos.get(0).state(), equalTo(SnapshotState.SUCCESS));
            .repository(otherRepoName);  
        );
        assertAcked(client.admin().cluster().prepareDeleteRepository(repoName));
        }
    /**  
        disableRepoConsistencyCheck("This test intentionally corrupts the repository contents");
        final String snapshot = "test-snap";
        expectThrows(
            client().prepareIndex().setIndex("test-idx-1").setSource("foo", "bar"),
        final int nDocs = randomIntBetween(1, 10);
        internalCluster().fullRestart();  
            .prepareCreateSnapshot(repoName, snapshot)  
        if (randomBoolean()) {
import java.nio.file.StandardOpenOption;
        logger.info("--> truncate snapshot file to make it unreadable");
        assertDocCount(indexName, nDocs);  
        final String snapshot = "test-snap";
                // Don't cache repository data because the test manually modifies the repository data  
        logger.info("--> corrupt index-N blob");  
        );
            .setWaitForCompletion(true)
            try (Stream<Path> shardFiles = Files.list(repo.resolve(resolvePath(indexId, "0")))) {  
        clusterAdmin().prepareRestoreSnapshot("test-repo", snapshot1)  
        indexRandom(
        logger.info("--> indexing some data");
            .prepareCreateSnapshot("test-repo", "test-snap-1")
        indexRandom(true, documents);
    }
        final String repoName = "test-repo";
                    .orElseThrow(() -> new AssertionError("Failed to find shard index blob"));  
        for (int j = 0; j < nDocs; j++) {  
        createIndex("test-idx-1", "test-idx-2");
        }
        }  
        assertThat(
import static org.hamcrest.Matchers.containsString;
        final Path globalStatePath = repo.resolve("meta-" + snapshotInfo.snapshotId().getUUID() + ".dat");
        for (IndexId indexId : getRepositoryData("test-repo").getIndices().values()) {
        clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap-1").setWaitForCompletion(true).setIndices("test-idx-*").get();
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
            .setIndices("test-idx-*")
        indexRandom(
        );
        );  
            repoName,
        expectThrows(RepositoryException.class, () -> getRepositoryData(otherRepo));  
        assertBusy(() -> assertTrue(snapshotsService.assertAllListenersResolved()));  
                .put(BlobStoreRepository.CACHE_REPOSITORY_DATA.getKey(), false)  
            "fs",
            .setIndices("test-idx-*")
        final RepositoryData repositoryData = getRepositoryData("test-repo");
        createIndex("test-idx-1", "test-idx-2");
        logger.info(  
        Client client = client();
        startDeleteSnapshot(repoName, snapshot).get();
    public void testMountCorruptedRepositoryData() throws Exception {  
    }
import org.opensearch.repositories.RepositoriesService;  
            .put(BlobStoreRepository.ALLOW_CONCURRENT_MODIFICATION.getKey(), true)
import org.opensearch.repositories.Repository;
        indexRandom(true, documents);  
        createRepository(otherRepoName, "fs", Settings.builder().put("location", repo).put("compress", false));
import java.nio.file.Files;
            Settings.builder()  
            repositoryException3.getMessage(),  
        logger.info("--> make sure snapshot doesn't exist");
        SnapshotsStatusResponse snapshotStatusResponse = clusterAdmin().prepareSnapshotStatus("test-repo").setSnapshots("test-snap").get();
import java.util.stream.Stream;
        createIndex("test-idx-1", "test-idx-2");
        createRepository("test-repo", "fs", repo);  
            .prepareCreateSnapshot("test-repo", "test-snap-1")  
            .prepareCreateSnapshot(repoName, snapshot)  
        logger.info("-->  restoring snapshot [{}]", snapshot1);
        Path repo = randomRepoPath();
    public void testDeleteSnapshotWithCorruptedSnapshotFile() throws Exception {  
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;  
     */
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.repositories.blobstore.BlobStoreRepository;
            Files.move(repo.resolve("index-" + (repositoryData.getGenId() + 1)), repo.resolve("index-" + repositoryData.getGenId()));  
            client().prepareIndex("test-idx-2").setSource("foo", "bar")
        client().admin().indices().prepareDelete("test-idx-1", "test-idx-2").get();
            Path shardZero = repo.resolve(resolvePath(indexIds.get(index), "0"));  
            SnapshotMissingException.class,
            .setIndices("test-idx-*")
        indexRandom(  
        createSnapshotResponse = client.admin()  
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
            .setWaitForCompletion(true)
            client().prepareIndex("test-idx-1").setSource("foo", "bar"),
        CreateSnapshotResponse createSnapshotResponse = client.admin()
        List<SnapshotInfo> snapshotInfos = clusterAdmin().prepareGetSnapshots("test-repo").get().getSnapshots();  
        final Repository otherRepo = internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class)
            .prepareCreateSnapshot(repoName, snapshot)
import java.nio.file.Path;  
            .setWaitForCompletion(true)  
        final long beforeMoveGen = repositoryData.getGenId();
        disableRepoConsistencyCheck("This test uses a purposely broken repository so it would fail consistency checks");
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())  
