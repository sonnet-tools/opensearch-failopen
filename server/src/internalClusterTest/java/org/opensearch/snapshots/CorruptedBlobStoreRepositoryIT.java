        );
        logger.info("--> make sure that we can create the snapshot again");
        assertThat(indexIds.size(), equalTo(1));
        indexRandom(
 * software distributed under the License is distributed on an
        }
        assertThat(
            .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES);
            Settings.builder().put("location", repo).put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        logger.info(
            }
        List<SnapshotInfo> snapshotInfos = clusterAdmin().prepareGetSnapshots("test-repo").get().getSnapshots();
        CreateSnapshotResponse createSnapshotResponse = client.admin()
            .cluster()
import org.opensearch.common.settings.Settings;
        SnapshotInfo snapshotInfo = createFullSnapshot("test-repo", "test-snap");
            "fs",
import static org.hamcrest.Matchers.greaterThan;
import java.nio.file.Path;
        logger.info("--> truncate snapshot file to make it unreadable");
        logger.info("-->  creating repository at {}", repo.toAbsolutePath());
        assertThat(snapshotInfo2.state(), equalTo(SnapshotState.PARTIAL));
            .setIndices(indices)
            .cluster()
 *    http://www.apache.org/licenses/LICENSE-2.0
        createIndex("test-idx-1", "test-idx-2");
        for (int j = 0; j < nDocs; j++) {
                Files.delete(
            client().prepareIndex("test-idx-1").setSource("foo", "bar"),
        logger.info("--> verify loading repository data from newly mounted repository throws RepositoryException");
            .get();
        logger.info("--> creating snapshot");
        final SnapshotsService snapshotsService = internalCluster().getCurrentClusterManagerNodeInstance(SnapshotsService.class);
        assertThat(snapshotStatusResponse.getSnapshots().get(0).getSnapshot().getSnapshotId().getName(), equalTo("test-snap"));
    }
            .setRestoreGlobalState(randomBoolean())
        Path snapshotPath = repo.resolve("snap-" + createSnapshotResponse.getSnapshotInfo().snapshotId().getUUID() + ".dat");
        Client client = client();
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        assertThat(snapshotInfo2.indices(), hasSize(1));
        logger.info("--> creating snapshot");
    public void testConcurrentlyChangeRepositoryContents() throws Exception {
        final int nDocs = randomIntBetween(1, 10);
        final Client client = client();
            Files.move(repo.resolve("index-" + (repositoryData.getGenId() + 1)), repo.resolve("index-" + repositoryData.getGenId()));
        Settings.Builder settings = Settings.builder()
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        if (randomBoolean()) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
                                .<RepositoriesMetadata>custom(RepositoriesMetadata.TYPE)
            .put("location", repo)
        logger.info("--> move index-N blob to next generation");
 * license agreements. See the NOTICE file distributed with
            .getSnapshotInfo();
        createFullSnapshot("test-repo", "test-snap");
                outChan.truncate(randomInt(10));
            .put("compress", false)
            client().prepareIndex("test-idx-1").setSource("foo", "bar"),
        final String indexName = "test-idx";
                .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        final RepositoryException repositoryException4 = expectThrows(
        Files.move(repo.resolve("index-" + beforeMoveGen), repo.resolve("index-" + (beforeMoveGen + 1)));
            assertRepositoryBlocked(client, repoName, snapshot);
        );
        );
                            RepositoriesMetadata.TYPE,
            client().prepareIndex().setIndex("test-idx-1").setSource("foo", "bar"),
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
            createSnapshotResponse.getSnapshotInfo().totalShards() - 1
    }
            .get();
        Files.delete(metadata);
        CreateSnapshotResponse createSnapshotResponse = client.admin()
                // Don't cache repository data because the test manually modifies the repository data
        indexRandom(
            .setWaitForCompletion(true)
import static org.hamcrest.Matchers.equalTo;
        logger.info("--> indexing some data");
        final String snapshot1 = "test-snap-1";
        indexRandom(
                        .build()
                    .findFirst()
            .cluster()
            Files.delete(shardGen);
        createRepository(repoName, "fs", settings);
    }
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
            .prepareCreateSnapshot(repoName, snapshot)
        Client client = client();
        createRepository("test-repo", "fs", repo);
            documents[j] = client.prepareIndex(indexName).setSource("foo2", "bar2");
                // Don't cache repository data because the test manually modifies the repository data
        );
        final String repoName = "test-repo";
        );
        logger.info("--> delete snapshot");
        logger.info("--> move index-N blob to next generation");
            Path shardZero = repo.resolve(resolvePath(indexIds.get(index), "0"));
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
import java.util.Map;
        final RepositoryData repositoryData = getRepositoryData(repoName);
            client().prepareIndex("test-idx-1").setSource("foo", "bar"),
            .cluster()
        assertThat(snapshotInfo2.successfulShards(), equalTo(snapshotInfo.totalShards() - 1));
import java.util.stream.Stream;
    /** Tests that a snapshot with a corrupted global state file can still be deleted */
        Client client = client();
            client().prepareIndex("test-idx-2").setSource("foo", "bar"),
        CreateSnapshotResponse createSnapshotResponse = client.admin()
        );
            true,
            SnapshotMissingException.class
        expectThrows(
            // Truncate the global state metadata file
        final Repository repository = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class).repository(repoName);
        createIndex("test-idx-1", "test-idx-2");
            true,
        logger.info("--> indexing some data");
        final long beforeMoveGen = repositoryData.getGenId();
        createIndex("test-idx-1", "test-idx-2");
        Client client = client();
        startDeleteSnapshot("test-repo", "test-snap-1").get();
        final SnapshotInfo snapshotInfo = createSnapshotResponse.getSnapshotInfo();
            () -> client.admin().cluster().prepareGetSnapshots(repoName).addSnapshots(snapshot).get()
import java.nio.file.StandardOpenOption;
        );
        final RepositoryData repositoryData = getRepositoryData(repoName);
        assertAcked(client.admin().cluster().prepareDeleteRepository(repoName));
            .get();
        createIndex("test-idx-1", "test-idx-2");
        final Path repo = randomRepoPath();
            .setIndices("test-idx-*")
            SnapshotMissingException.class,
            .setWaitForCompletion(true)
        final RepositoryData repositoryData = getRepositoryData("test-repo");
        assertEquals(0, restoreSnapshotResponse.getRestoreInfo().failedShards());
            .setWaitForCompletion(true)
        assertEquals(
        final SnapshotInfo snapshotInfo2 = clusterAdmin().prepareCreateSnapshot("test-repo", snapshot2)
            .setIndices("test-idx-*")
        CreateSnapshotResponse createSnapshotResponse = client.admin()
            .prepareCreateSnapshot(repoName, snapshot)
        for (int j = 0; j < nDocs; j++) {
                + "because it uses snap-*.data files and not the index-N to determine what files to restore"
        );
        createRepository("test-repo", "fs", repo);
        final String repoName = "test-repo";
        assertThat(snapshotInfos.get(0).state(), equalTo(SnapshotState.SUCCESS));
        final Path shardIndexFile = repo.resolve(resolvePath(corruptedIndex, "0"))
        Path repo = randomRepoPath();
        clusterAdmin().prepareRestoreSnapshot("test-repo", snapshot1)
            .get();
        assertRepositoryBlocked(client, repoName, snapshot);
            SnapshotMissingException.class,
            .setIndices("test-idx-*")
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
                    Metadata.builder(currentState.getMetadata())
                .put("location", repo)
            client().prepareIndex().setIndex("test-idx-1").setSource("foo", "bar"),
import java.nio.channels.SeekableByteChannel;
        assertThat(snapshotInfo2.failedShards(), equalTo(1));
 * specific language governing permissions and limitations
        indexRandom(true, documents);
                );
        );
 *
        }
import org.opensearch.cluster.metadata.Metadata;
            repositoryException3.getMessage(),
        logger.info("--> verify index-N blob is found at the new location");
        logger.info("--> indexing some data");
        createRepository(
            currentState -> ClusterState.builder(currentState)
        logger.info("--> verify loading repository data throws RepositoryException");
                                .withUpdatedGeneration(repository.getMetadata().name(), beforeMoveGen, beforeMoveGen + 1)
            client().prepareIndex("test-idx-2").setSource("foo", "bar")
        indexRandom(
        logger.info("--> verify index-N blob is found at the new location");
            Settings.builder()
            Settings.builder()
                .build()
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
        for (String index : indices) {
        );
        startDeleteSnapshot("test-repo", "test-snap-1").get();
        ensureGreen();
        indexRandom(
        final Map<String, IndexId> indexIds = repositoryData.getIndices();
        final RepositoryData repositoryData = getRepositoryData(repoName);
import org.opensearch.repositories.RepositoriesService;
        Path repo = randomRepoPath();
            "fs",
public class CorruptedBlobStoreRepositoryIT extends AbstractSnapshotIntegTestCase {
        );
            client().prepareIndex("test-idx-2").setSource("foo", "bar")
                .put(BlobStoreRepository.CACHE_REPOSITORY_DATA.getKey(), false)
            assertTrue(Files.notExists(indicesPath.resolve(indexIds.get(index).getId())));
            .setWaitForCompletion(true)
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        }
        logger.info("--> indexing some data");
            client().prepareIndex("test-idx-2").setSource("foo", "bar")
        expectThrows(RepositoryException.class, () -> getRepositoryData(otherRepo));
            .setWaitForCompletion(true)
            repoName,
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        expectThrows(
            true,
        Path repo = randomRepoPath();
            .repository(otherRepoName);
        disableRepoConsistencyCheck("This test uses a purposely broken repository so it would fail consistency checks");
        logger.info("--> deleting shard level index file");
            () -> client.admin().cluster().prepareCreateSnapshot(repo, existingSnapshot).execute().actionGet()
     * Tests that a shard snapshot with a corrupted shard index file can still be used for restore and incremental snapshots.
            .get()
        clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap-1").setWaitForCompletion(true).setIndices("test-idx-*").get();
        assertThat(snapshotInfos.size(), equalTo(1));
        assertThat(snapshotInfos.size(), equalTo(1));
            .cluster()
        assertThat(getRepositoryData(repoName).getGenId(), is(beforeMoveGen + 1));
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
            .prepareCreateSnapshot("test-repo", "test-snap-1")
    public void testSnapshotWithCorruptedShardIndexFile() throws Exception {
            .get();
import java.nio.file.Files;
            () -> client().admin().cluster().prepareGetSnapshots(repoName).addSnapshots(snapshot).get()
 * this work for additional information regarding copyright
            .setIndices("test-idx-1")
import org.opensearch.repositories.RepositoryException;
        indexRandom(true, documents);
        CreateSnapshotResponse createSnapshotResponse = client().admin()
    public void testDeleteSnapshotWithCorruptedGlobalState() throws Exception {
        final Repository repository = internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class)
        assertThat(
            "fs",
            // Delete the global state metadata file
     */
        final Repository otherRepo = internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class)
 * not use this file except in compliance with the License.
            client().prepareIndex().setIndex("test-idx-2").setSource("foo", "bar")
        assertThat(snapshotInfos.get(0).snapshotId().getName(), equalTo(snapshot1));
        logger.info("--> make sure snapshot doesn't exist");
    public void testConcurrentlyChangeRepositoryContentsInBwCMode() throws Exception {
        assertBusy(() -> assertTrue(snapshotsService.assertAllListenersResolved()));
import java.util.List;
        logger.info("--> make sure snapshot doesn't exist");
    }
        logger.info("--> verify index-N blob is found at the expected location");
        Client client = client();
 *
        } else {
        logger.info("-->  creating snapshot [{}]", snapshot2);
        List<SnapshotInfo> snapshotInfos = clusterAdmin().prepareGetSnapshots("test-repo").get().getSnapshots();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            SnapshotMissingException.class,
        logger.info("--> make sure snapshot doesn't exist");
            Files.delete(shardZero.resolve("snap-" + snapshotInfo.snapshotId().getUUID() + ".dat"));
        logger.info("--> creating snapshot");
        assertThat(getRepositoryData(repoName).getGenId(), is(beforeMoveGen + 2));
    public void testDeleteSnapshotWithMissingIndexAndShardMetadata() throws Exception {
        );
        try (SeekableByteChannel outChan = Files.newByteChannel(snapshotPath, StandardOpenOption.WRITE)) {
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        final RepositoryData repositoryData = getRepositoryData(repository);
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
 * Unless required by applicable law or agreed to in writing,
        logger.info("--> make sure snapshot doesn't exist");
        Path repo = randomRepoPath();
        );
        Path repo = randomRepoPath();
            .setWaitForCompletion(true)
        final IndexRequestBuilder[] documents = new IndexRequestBuilder[nDocs];
import org.opensearch.repositories.RepositoryData;
        logger.info("--> set next generation as pending in the cluster state");
        createRepository("test-repo", "fs", repo);
            .setIndices("test-idx-*")
        }
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        final String repoName = "test-repo";
                .put("location", repo)
        logger.info("--> verify index-N blob is found at the expected location");
            SnapshotMissingException.class,
        logger.info("--> move index-N blob to next generation");
        logger.info("-->  creating index [{}] with [{}] documents in it", indexName, nDocs);
            .setIndices("test-idx-*")
import org.opensearch.common.util.io.IOUtils;
        expectThrows(
        final Path repo = randomRepoPath();
    private void assertRepositoryBlocked(Client client, String repo, String existingSnapshot) {
        );
            outChan.truncate(randomInt(10));
        expectThrows(
        final String snapshot = "test-snap";
            "--> restoring the first snapshot, the repository should not have lost any shard data despite deleting index-N, "
        );
        logger.info("-->  restoring snapshot [{}]", snapshot1);
        );
        );
        logger.info("--> indexing some data");
            logger.info("--> verify repository remains blocked");
        internalCluster().fullRestart();
        assertAcked(client().admin().indices().prepareDelete(indexName));
                )
        );
        assertAcked(startDeleteSnapshot("test-repo", "test-snap").get());
            client().prepareIndex().setIndex("test-idx-2").setSource("foo", "bar")
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
            () -> client.admin().cluster().prepareGetSnapshots("test-repo").addSnapshots("test-snap-1").get().getSnapshots()
            .repository(repoName);
            outChan.truncate(randomInt(10));
        );
 * The OpenSearch Contributors require contributions made to
        client().admin().indices().prepareDelete("test-idx-1", "test-idx-2").get();
            .get();
        indexRandom(
import org.opensearch.cluster.metadata.RepositoriesMetadata;
/*
 * under the License.
        client.admin().cluster().prepareDeleteSnapshot(repoName, snapshot).get();
        CreateSnapshotResponse createSnapshotResponse = client.admin()
        assertThat(snapshotInfo.indices(), hasSize(1));
    /**
            () -> client.admin().cluster().prepareDeleteSnapshot(repo, existingSnapshot).execute().actionGet()
        final String otherRepoName = "other-repo";
 */
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
            .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES);
            () -> client.admin().cluster().prepareGetSnapshots("test-repo").addSnapshots("test-snap-1").get()
        expectThrows(RepositoryException.class, () -> getRepositoryData(repository));
                .put("location", repo)
                .put("compress", false)
        logger.info("--> try to create snapshot");
        createRepository(
        final String snapshot2 = "test-snap-2";
        assertThat(
import org.opensearch.repositories.Repository;
    public void testDeleteSnapshotWithCorruptedSnapshotFile() throws Exception {
 * KIND, either express or implied.  See the License for the
        final String snapshot = "test-snap";
 *
            .prepareCreateSnapshot("test-repo", "test-snap-1")
        assertThat(getRepositoryData(repository).getGenId(), is(beforeMoveGen + 1));
    }
        CreateSnapshotResponse createSnapshotResponse = client.admin()
        final String snapshot = "test-snap";
        );
}
                    .orElseThrow(() -> new AssertionError("Failed to find shard index blob"));
            client().prepareIndex().setIndex("test-idx-2").setSource("foo", "bar")
            .put(BlobStoreRepository.ALLOW_CONCURRENT_MODIFICATION.getKey(), true)
        );
                .put("location", repo)
import org.opensearch.action.index.IndexRequestBuilder;
                .put("compress", false)
            client().prepareIndex("test-idx-1").setSource("foo", "bar"),
            .cluster()
/*
        logger.info("--> recreate repository");
        createRepository(
        final Path indicesPath = repo.resolve("indices");
            RepositoryException.class,
        Client client = client();
        logger.info("--> make sure snapshot doesn't exist");
        createIndex("test-idx-1", "test-idx-2");
        );
        try (SeekableByteChannel outChan = Files.newByteChannel(shardIndexFile, StandardOpenOption.WRITE)) {
            repositoryException4.getMessage(),
            .setWaitForCompletion(true)
                .metadata(
        final String[] indices = { "test-idx-1", "test-idx-2" };
        assertThat(
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
            .cluster()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            try (SeekableByteChannel outChan = Files.newByteChannel(globalStatePath, StandardOpenOption.WRITE)) {
        logger.info("--> creating snapshot");
        final long beforeMoveGen = repositoryData.getGenId();
                        .putCustom(
        }
    }
        );
        assertThat(
    public void testDeleteSnapshotWithMissingMetadata() throws Exception {
                    shardZero.resolve("index-" + getRepositoryData("test-repo").shardGenerations().getShardGen(indexIds.get(index), 0))
        logger.info("--> creating another snapshot");
 * the Apache License, Version 2.0 (the "License"); you may
            }
    public void testFindDanglingLatestGeneration() throws Exception {
        assertDocCount(indexName, nDocs);
            documents[j] = client.prepareIndex(indexName).setSource("foo", "bar");
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
    }
            "fs",
        );
        Path metadata = repo.resolve("meta-" + createSnapshotResponse.getSnapshotInfo().snapshotId().getUUID() + ".dat");
        indexRandom(
        logger.info("-->  truncating shard index file [{}]", shardIndexFile);
            true,
        flushAndRefresh();
        assertThat(snapshotStatusResponse.getSnapshots(), hasSize(1));
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap-1")
        logger.info("--> indexing some data");
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
                .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        logger.info("--> corrupt index-N blob");
                .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        SnapshotsStatusResponse snapshotStatusResponse = clusterAdmin().prepareSnapshotStatus("test-repo").setSnapshots("test-snap").get();
            .setIndices("test-idx-*")
            "test-repo",
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
        createRepository(
            true,
            client().prepareIndex("test-idx-2").setSource("foo", "bar")
        for (IndexId indexId : getRepositoryData("test-repo").getIndices().values()) {
            .setWaitForCompletion(true)
import static org.hamcrest.Matchers.hasSize;
        final SnapshotInfo snapshotInfo = createFullSnapshot("test-repo", snapshot1);
            .setWaitForCompletion(true)
        updateClusterState(
        logger.info("--> wait for all listeners on snapshots service to be resolved to avoid snapshot task batching causing a conflict");
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor
            .setWaitForCompletion(true)
            containsString("Could not read repository data because the contents of the repository do not match its expected state.")
            .cluster()
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
import org.opensearch.repositories.IndexId;
        );
import org.opensearch.cluster.ClusterState;
        );
                .put(BlobStoreRepository.CACHE_REPOSITORY_DATA.getKey(), false)
package org.opensearch.snapshots;
        );
        );
                .put("compress", false)
        logger.info("--> remove repository");
        CreateSnapshotResponse createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap-2")
        createRepository(
        expectThrows(SnapshotMissingException.class, () -> clusterAdmin().prepareGetSnapshots("test-repo").addSnapshots("test-snap").get());
        Files.move(repo.resolve("index-" + repositoryData.getGenId()), repo.resolve("index-" + (repositoryData.getGenId() + 1)));
        createIndex(indices);
 */
            final Path shardGen;
            RepositoryException.class,
            client().prepareIndex().setIndex("test-idx-1").setSource("foo", "bar"),
        logger.info("--> make sure snapshot doesn't exist");
 * ownership. Elasticsearch licenses this file to you under
        );
            try (Stream<Path> shardFiles = Files.list(repo.resolve(resolvePath(indexId, "0")))) {
        assertThat(
        flushAndRefresh("test-idx-1", "test-idx-2");
        assertThat(
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
        logger.info("--> indexing some data");
            .prepareCreateSnapshot(repoName, snapshot)
            () -> client.admin().cluster().prepareGetSnapshots("test-repo").addSnapshots("test-snap-1").get()
            client().prepareIndex("test-idx-2").setSource("foo", "bar")
        logger.info("--> creating snapshot");
            .get();
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
        final Repository repository = internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class)
import static org.hamcrest.Matchers.containsString;
        final String repoName = "test-repo";
        logger.info("-->  verifying snapshot state for [{}]", snapshot1);
            true,
            true,
            Settings.builder()
 */
            .setWaitForCompletion(true)
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        createSnapshotResponse = client.admin()
            SnapshotMissingException.class,
    }
    }
        logger.info("--> delete index metadata and shard metadata");
import static org.hamcrest.Matchers.is;
        expectThrows(
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
        final Map<String, IndexId> indexIds = getRepositoryData("test-repo").getIndices();
            logger.info("--> move index-N blob back to initial generation");
        assertThat(
import org.opensearch.transport.client.Client;
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
/*
            client().prepareIndex("test-idx-1").setSource("foo", "bar"),
        }
            .get();
        logger.info("--> try to delete snapshot");
            .put("compress", false)
                            currentState.metadata()
        );
 * Modifications Copyright OpenSearch Contributors. See
        Files.move(repo.resolve("index-" + beforeMoveGen), repo.resolve("index-" + (beforeMoveGen + 1)));
        Files.write(repo.resolve("index-" + repositoryData.getGenId()), randomByteArrayOfLength(randomIntBetween(1, 100)));
            .repository(repoName);
        logger.info("-->  indexing [{}] more documents into [{}]", nDocs, indexName);
import org.opensearch.core.common.unit.ByteSizeUnit;
        );
    }
        createRepository(otherRepoName, "fs", Settings.builder().put("location", repo).put("compress", false));
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        createRepository(repoName, "fs", settings);
        startDeleteSnapshot(repoName, snapshot).get();
        final String snapshot = "test-snap";
        assertThat(snapshotInfos.get(0).snapshotId().getName(), equalTo("test-snap"));
        expectThrows(
        assertThat(getRepositoryData(repository).getGenId(), is(beforeMoveGen + 2));
        logger.info("--> delete global state metadata");
            .prepareCreateSnapshot("test-repo", "test-snap-1")
        for (String index : indices) {
            .prepareCreateSnapshot("test-repo", "test-snap-1")
            .put("location", repo)
        createIndex("test-idx-1", "test-idx-2");
        );
        createIndex("test-idx-1", "test-idx-2");
        logger.info("--> full cluster restart");
        if (randomBoolean()) {
            true,
 * SPDX-License-Identifier: Apache-2.0
        ensureGreen();
            containsString("Could not read repository data because the contents of the repository do not match its expected state.")
            .setIndices("test-idx-*")
            Settings.builder()
        createRepository("test-repo", "fs", repo);
            repoName,
        }
        logger.info("--> creating snapshot");
        assertThat(snapshotInfos.get(0).state(), equalTo(SnapshotState.SUCCESS));
                        )
            repoName,
        logger.info("--> creating snapshot");
            .get();
            "fs",
        assertAcked(prepareCreate(indexName).setSettings(indexSettingsNoReplicas(1)));
            .resolve("index-" + repositoryData.shardGenerations().getShardGen(corruptedIndex, 0));
            }
        logger.info("-->  deleting index [{}]", indexName);
        startDeleteSnapshot("test-repo", "test-snap-1").get();
        final IndexId corruptedIndex = indexIds.get(indexName);
        );
        Settings.Builder settings = Settings.builder()
            SnapshotMissingException.class,
        Path repo = randomRepoPath();
        final Path globalStatePath = repo.resolve("meta-" + snapshotInfo.snapshotId().getUUID() + ".dat");
            .get();
        disableRepoConsistencyCheck("This test intentionally corrupts the repository contents");
        assertRequestBuilderThrows(
        Path repo = randomRepoPath();
            clusterAdmin().prepareSnapshotStatus("test-repo").addSnapshots("test-snap"),
            .prepareCreateSnapshot(repoName, snapshot)
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
                shardGen = shardFiles.filter(file -> file.getFileName().toString().startsWith(BlobStoreRepository.INDEX_FILE_PREFIX))
        logger.info("--> creating snapshot");
            IOUtils.deleteFilesIgnoringExceptions(globalStatePath);
            .get();
 * compatible open source license.
        Path repo = randomRepoPath();
        startDeleteSnapshot(repoName, snapshot).get();
        );
    }
 * You may obtain a copy of the License at
                .put("compress", false)
 * GitHub history for details.
    public void testSnapshotWithMissingShardLevelIndexFile() throws Exception {
        final RepositoryException repositoryException3 = expectThrows(
        }
        indexRandom(
        }
    public void testMountCorruptedRepositoryData() throws Exception {
            () -> client.admin().cluster().prepareGetSnapshots(repoName).addSnapshots(snapshot).get()
            .setWaitForCompletion(true)
            if (randomBoolean()) {
        assertThat(
            "test-repo",
