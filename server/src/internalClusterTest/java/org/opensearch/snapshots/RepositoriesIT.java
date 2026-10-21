        RepositoriesMetadata repositoriesMetadata = metadata.custom(RepositoriesMetadata.TYPE);
            false
        AcknowledgedResponse deleteRepositoryResponse = client().admin()
        logger.info("--> delete first snapshot");
                containsString("location [" + location + "] doesn't match any of the locations specified " + "by path.repo")
        assertThat(repositoriesMetadata.repository("test-repo-1"), notNullValue());
                index(testIndexName, "_doc", Integer.toString(10 + j), "foo", "bar" + 10 + j);
    }
        try {
        } catch (RepositoryVerificationException ex) {
        int numberOfFiles = FileSystemUtils.files(location).length;
import org.opensearch.action.index.IndexRequest;
    public void testMisconfiguredRepository() throws Exception {
        createRepository("test-repo-2", "fs");
            "mock",
        logger.info("--> creating index-0 and ingest data");
        clusterStateResponse = client.admin().cluster().prepareState().clear().setMetadata(true).get();
            .cluster()
            OpenSearchIntegTestCase.putRepositoryRequestBuilder(
        repositoriesResponse = client.admin().cluster().prepareGetRepositories().get();
        logger.info("--> check that both repositories are in cluster state");
    public void testRepositoryVerification() throws Exception {
            client.admin().cluster(),
 * Modifications Copyright OpenSearch Contributors. See
        createRepository(
    }
            .put("location", randomRepoPath())
        // Make repository to throw exception when trying to delete stale snapshot shard blobs
            createFullSnapshot(repositoryName, snapshotName);
        // Delete second snapshot
        assertThat(repositoriesResponse.repositories().size(), equalTo(0));
import org.opensearch.repositories.RepositoryException;
        client.admin().cluster().prepareDeleteRepository("test-repo-2").get();
        assertThat(repositoriesMetadata, notNullValue());
        int numberOfFiles = numberOfFiles(repositoryPath);
            false,
            "test-repo",
        Path location = randomRepoPath();
        logger.info("--> delete second snapshot");
        repositoriesResponse = client.admin().cluster().prepareGetRepositories().get();
        RepositoryMetadata testRepo1Md = findRepository(repositoriesResponse.repositories(), "test-repo-1");
            assertEquals(beforeStateUuid, client.admin().cluster().prepareState().clear().get().getState().stateUUID());
            );
import org.opensearch.cluster.metadata.RepositoriesMetadata;
        int numberOfFiles = numberOfFiles(repositoryPath);
        logger.info("--> check that both repositories can be retrieved by getRepositories query");
                return repository;
                .put("location", repositoryPath)
            index(indexName, "_doc", Integer.toString(j), "foo", "bar" + j);
                .put(BlobStoreRepository.MAX_SNAPSHOT_SHARD_BLOB_DELETE_BATCH_SIZE.getKey(), maxShardBlobDeleteBatchSize)
        assertThat(deleteRepositoryResponse.isAcknowledged(), equalTo(false));
            true,
        assertThat(repositoriesResponse.repositories().size(), equalTo(1));
            RepositoryVerificationException.class
        refresh();
        Settings.Builder settings = Settings.builder()
        );
                Settings.builder().put(settings),
        assertRequestBuilderThrows(client.admin().cluster().prepareVerifyRepository("test-repo-2"), RepositoryVerificationException.class);
                .put("location", repositoryPath)
        for (int j = 0; j < randomIntBetween(1, 1000); j++) {
        logger.info("--> adding some more documents to test index");
 * GitHub history for details.
        logger.info("--> trying creating fs repository with location that is not registered in path.repo setting");
        assertThat(repositoriesMetadata.repository("test-repo-2"), notNullValue());
        logger.info("-->  creating repository test-repo-2 with standard timeout - should ack");
            .put("compress", randomBoolean())
        Path invalidRepoPath = createTempDir().toAbsolutePath();
    }
        refresh();
        VerifyRepositoryResponse verifyRepositoryResponse = client.admin().cluster().prepareVerifyRepository("test-repo-1").get();
            ),
import org.opensearch.core.util.FileSystemUtils;
        logger.info("--> make sure that number of files is back to what it was when the first snapshot was made");
        OpenSearchIntegTestCase.putRepository(
        if (testRepo1Md.settings().equals(testRepo1MdAfterUpdate.settings())) {
        // This snapshot should delete last snapshot's residual stale indices as well
 * compatible open source license.
        createRepository(repositoryName, "mock", repositoryPath);
import java.nio.file.Path;
            assertThat(ex.toString(), containsString("missing location"));
            fail("RepositoryVerificationException wasn't generated");
            Settings.builder().put(readonlySettings)
                null,
            if (repository.name().equals(name)) {
        ClusterStateResponse clusterStateResponse = client.admin().cluster().prepareState().clear().setMetadata(true).get();
        for (int i = 1; i <= maxThreadsForSnapshotDeletion + 1; i++) {
                bulkRequest.add(new IndexRequest(indexName).source("foo" + j, "bar" + i));
        disableRepoConsistencyCheck("This test does not create any data in the repository.");
        }
        repositoriesResponse = client.admin().cluster().prepareGetRepositories(randomFrom("_all", "*", "test-repo-*")).get();
            .setThrowExceptionWhileDelete(false);
        final String repositoryName = "test-repo";
                client.admin().cluster(),
        assertFileCount(repositoryPath, numberOfFiles + 2);
        logger.info("--> done");
        logger.info("--> creating index-0 and ingest data");
        logger.info("--> creating first snapshot");
        // (2) index-latest
        logger.info("-->  creating another repository");
import static org.hamcrest.Matchers.containsString;
 * license agreements. See the NOTICE file distributed with
        for (int j = 0; j < 10; j++) {
        logger.info("--> delete the bulk of the snapshots");
        }
        );
            .prepareDeleteRepository("test-repo-2")
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            index("test-idx-0", "_doc", Integer.toString(10 + j), "foo", "bar" + 10 + j);
            }
import org.opensearch.cluster.metadata.RepositoryMetadata;
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequestBuilder;
 * under the License.
            client.admin().cluster().preparePutRepository("test-repo").setType("fs").get();
        assertThat(verifyRepositoryResponse.getNodes().size(), equalTo(cluster().numDataAndClusterManagerNodes()));
import org.opensearch.test.OpenSearchIntegTestCase;
    }
import org.opensearch.repositories.blobstore.BlobStoreRepository;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // Make repository to work normally
        logger.info("-->  creating repository that cannot write any files - should fail");
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryResponse;
            String snapshotName = "test-snap-" + i;
        client.admin().cluster().prepareDeleteSnapshot(repositoryName, snapshotToBeDeletedLastName).get();
        try {
        logger.info("-->  verifying repository");
    private RepositoryMetadata findRepository(List<RepositoryMetadata> repositories, String name) {
            createRepository("test-repo-1", "mock", settingsBuilder);
 * software distributed under the License is distributed on an
            assertThat(
        Client client = client();
import org.opensearch.snapshots.mockstore.MockRepository;
/*
            .setThrowExceptionWhileDelete(true);
    public void testRepositoryCreation() throws Exception {
        logger.info("--> done");
    public void testResidualStaleIndicesAreDeletedByConsecutiveDelete() throws Exception {
        client.admin().cluster().prepareDeleteSnapshot(repositoryName, secondSnapshot).get();
        logger.info("-->  creating read-only repository that cannot read any files - should fail");
        createFullSnapshot(repositoryName, firstSnapshot);
        }
        logger.info("-->  verifying repository");
                "test-repo-2",
        Client client = client();
            ensureGreen();
            .setTimeout("0s")
        }
        } catch (RepositoryException ex) {
        assertThat(repositoriesMetadata, notNullValue());
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, clusterManagerNode).repository("test-repo"))
        logger.info("--> delete first snapshot");
        logger.info("--> done");
            logger.info("--> creating snapshot: {}", snapshotName);
        }
            .prepareGetRepositories(randomFrom("_all", "*", "test-repo-*"))
                ex.toString(),
            "mock",
        assertThat(repositoriesMetadata.repository("test-repo-2").type(), equalTo("fs"));
            assertThat(ex.getMessage(), containsString("is not shared"));
import org.opensearch.cluster.metadata.Metadata;
        logger.info("-->  creating read-only repository that cannot read any files, but suppress verification - should be acked");
 *
    }
        createIndex(indexName);
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, clusterManagerNode).repository("test-repo"))
        );
            createRepository("test-repo", "fs", Settings.builder().put("location", location));
        logger.info("--> delete repository test-repo-2");
            String testIndexName = "test-idx-" + i;
import org.opensearch.threadpool.ThreadPool;
        Path location = randomRepoPath();
        logger.info("--> adding some more documents to test index");
        final String bulkSnapshotsPattern = "test-snap-*";
 * The OpenSearch Contributors require contributions made to
 * SPDX-License-Identifier: Apache-2.0
        logger.info("--> creating second snapshot");
            client().bulk(bulkRequest).get();
        Client client = client();
public class RepositoriesIT extends AbstractSnapshotIntegTestCase {
        assertFileCount(repositoryPath, numberOfFiles);
        Path repositoryPath = randomRepoPath();
        logger.info("--> verify the repository");
                null,
        logger.info("-->  creating repository that cannot write any files, but suppress verification - should be acked");
        logger.info("--> delete repository test-repo-1");
            logger.info("--> creating index-" + i + " and ingest data");
        Client client = client();
        logger.info("--> make sure that number of files is back to what it was when the first snapshot was made");
                bulkRequest.add(new IndexRequest(indexName).source("foo" + j, "bar" + i));
        assertRequestBuilderThrows(
        assertFalse(requestBuilder.get().isAcknowledged());
        client.admin().cluster().prepareDeleteSnapshot(repositoryName, secondSnapshot).get();
        logger.info("-->  creating repository at {}", repositoryPath.toAbsolutePath());
        final String repositoryName = "test-repo";
        logger.info("-->  creating repository at {}", repositoryPath.toAbsolutePath());
        ensureGreen();
        createIndex(indexName);
    public void testSnapshotShardBlobDeletionRepositoryThrowingError() throws Exception {
        final String secondSnapshot = "second-snapshot";
            RepositoryVerificationException.class
 */
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, clusterManagerNode).repository("test-repo"))
            }
        assertThat(findRepository(repositoriesResponse.repositories(), "test-repo-2"), notNullValue());
        client.admin().cluster().prepareDeleteSnapshot(repositoryName, firstSnapshot).get();
        // Delete second snapshot
        } catch (RepositoryException ex) {
        Path repositoryPath = randomRepoPath();
                false
        assertThat(repositoriesMetadata.repositories().size(), equalTo(2));
        logger.info("--> creating first snapshot");
        logger.info("--> creating first snapshot");
        assertFileCount(repositoryPath, 2);
        Settings settings = Settings.builder().put("location", randomRepoPath()).put("random_control_io_exception_rate", 1.0).build();
}
        );
            OpenSearchIntegTestCase.putRepositoryRequestBuilder(
/*
        final String indexName = "test-idx";
 * Licensed to Elasticsearch under one or more contributor
        ensureGreen();
            .info(ThreadPool.Names.SNAPSHOT)
        // (1) index-(N+1)
        assertThat(repositoriesMetadata.repository("test-repo-1").type(), equalTo("fs"));
 * KIND, either express or implied.  See the License for the
            final BulkRequest bulkRequest = new BulkRequest();
        refresh();
        client.admin().cluster().prepareDeleteSnapshot(repositoryName, bulkSnapshotsPattern).get();
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
 *
        OpenSearchIntegTestCase.putRepository(client.admin().cluster(), "test-repo-1", "mock", false, Settings.builder().put(settings));
        String beforeStateUuid = clusterStateResponse.getState().stateUUID();
        logger.info("-->  creating repository");
        );
        createRepository("test-repo-1", "fs", location);
                true,
                false
import static org.hamcrest.Matchers.notNullValue;
        createFullSnapshot(repositoryName, firstSnapshot);
        logger.info("--> check that trying to create a repository with the same settings repeatedly does not update cluster state");
        repositoriesMetadata = metadata.custom(RepositoriesMetadata.TYPE);
        logger.info("--> check that repository is really there");
        ensureGreen();
                .put(BlobStoreRepository.MAX_SNAPSHOT_SHARD_BLOB_DELETE_BATCH_SIZE.getKey(), maxShardBlobDeleteBatchSize)
        }
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, clusterManagerNode).repository("test-repo"))
        refresh();
            for (int i = 0; i < randomIntBetween(100, 1000); ++i) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
        assertThat(repositoriesMetadata.repository("test-repo-1").type(), equalTo("fs"));
                "test-repo-1",
        RepositoryMetadata testRepo1MdAfterUpdate = findRepository(repositoriesResponse.repositories(), "test-repo-1");
import org.opensearch.action.bulk.BulkRequest;
            client().bulk(bulkRequest).get();
        }
        logger.info("-->  deleting repository test-repo-2 with 0s timeout - shouldn't ack");
            .setThrowExceptionWhileDelete(true);
            .put("chunk_size", randomIntBetween(5, 100), ByteSizeUnit.BYTES);
                "mock",
 * Unless required by applicable law or agreed to in writing,
        createFullSnapshot(repositoryName, secondSnapshot);
        int maxShardBlobDeleteBatchSize = randomIntBetween(1, 1000);
        createIndex("test-idx-0");
        }
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 2)
        // Make repository to throw exception when trying to delete stale indices
    public void testRepositoryAckTimeout() throws Exception {
        Settings readonlySettings = Settings.builder().put(settings).put("readonly", true).build();
 * ownership. Elasticsearch licenses this file to you under
        createRepository("test-repo-1", "fs", Settings.builder().put("location", location));
            .getMax();
            .put("chunk_size", randomIntBetween(5, 100), ByteSizeUnit.BYTES);
        assertRequestBuilderThrows(
        // Create more snapshots to be deleted in bulk
            refresh();
        for (int j = 0; j < randomIntBetween(100, 10000); ++j) {
                true,
        final String secondSnapshot = "second-snapshot";
        Client client = client();
            }
        final String firstSnapshot = "first-snapshot";
import org.opensearch.repositories.RepositoriesService;
            "test-repo",
                client.admin().cluster(),
            .put("compress", randomBoolean())
            .setThrowExceptionWhileDelete(false);
        String clusterManagerNode = internalCluster().getClusterManagerName();
            client().admin().cluster(),
            .cluster()
        // Expect two files to remain in the repository:
            fail("Shouldn't be here");
        // This snapshot should delete last snapshot's residual stale shard blobs as well
package org.opensearch.snapshots;
        logger.info("--> delete second snapshot");
        String location = invalidRepoPath.toString();
        settings = Settings.builder()
            "0s",
            }
        return null;
        logger.info("-->  creating repository at {}", repositoryPath.toAbsolutePath());
import org.opensearch.repositories.RepositoryVerificationException;
            final BulkRequest bulkRequest = new BulkRequest();
import static org.hamcrest.Matchers.equalTo;
            .put("location", randomRepoPath())
 * You may obtain a copy of the License at
        try {
 * not use this file except in compliance with the License.
        createRepository(
        assertThat(findRepository(repositoriesResponse.repositories(), "test-repo-1"), notNullValue());
        Client client = client();
        for (int j = 0; j < randomIntBetween(100, 1000); ++j) {
 */
            createIndex(testIndexName);
        logger.info("--> creating second snapshot");
        final String firstSnapshot = "first-snapshot";
        );
            for (int i = 0; i < randomIntBetween(100, 1000); ++i) {
            fail("Shouldn't be here");
import java.util.List;
        assertThat(repositoriesResponse.repositories().size(), equalTo(2));
        logger.info("-->  deleting repository test-repo-1 with standard timeout - should ack");
        metadata = clusterStateResponse.getState().getMetadata();
        GetRepositoriesResponse repositoriesResponse = client.admin()
        for (RepositoryMetadata repository : repositories) {
        logger.info("--> verify that we didn't leave any files as a result of verification");
import org.opensearch.common.settings.Settings;
        client.admin().cluster().prepareDeleteRepository("test-repo-1").get();
        final String repositoryName = "test-repo";
        final String snapshotToBeDeletedLastName = "test-snapshot-to-be-deleted-last";
 * specific language governing permissions and limitations
        PutRepositoryRequestBuilder requestBuilder = OpenSearchIntegTestCase.putRepositoryRequestBuilder(
            for (int j = 0; j < 10; j++) {
    }
        final String indexName = "test-idx";
            "test-repo-1",
        }
 * the Apache License, Version 2.0 (the "License"); you may
        createFullSnapshot(repositoryName, snapshotToBeDeletedLastName);
            Settings.Builder settingsBuilder = Settings.builder().put("location", location).put("localize_location", true);
        logger.info("--> trying creating repository with incorrect settings");
            "test-repo-2",
 *
        assertRequestBuilderThrows(client.admin().cluster().prepareVerifyRepository("test-repo-1"), RepositoryVerificationException.class);
            index(indexName, "_doc", Integer.toString(j), "foo", "bar" + j);
            settings,
            .get();
        deleteRepositoryResponse = client().admin().cluster().prepareDeleteRepository("test-repo-1").get();
        Metadata metadata = clusterStateResponse.getState().getMetadata();
import org.opensearch.core.common.unit.ByteSizeUnit;
            .get();
            ),
            Settings.builder()
        assertThat(findRepository(repositoriesResponse.repositories(), "test-repo-2"), notNullValue());
    }
        assertThat(FileSystemUtils.files(location).length, equalTo(numberOfFiles));
        Path repositoryPath = randomRepoPath();
import org.opensearch.transport.client.Client;
                Settings.builder().put(readonlySettings),
    }
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        logger.info("-->  creating repository test-repo-1 with 0s timeout - shouldn't ack");
            "fs",
    public void testSnapshotShardBlobDelete() throws Exception {
        createFullSnapshot(repositoryName, secondSnapshot);
        }
        // This will make sure stale indices stays in repository after snapshot delete
                "mock",
        // Make repository to work normally
            Settings.builder()
        createRepository("test-repo-2", "fs", settings);
/*
        assertThat(deleteRepositoryResponse.isAcknowledged(), equalTo(true));
        int maxThreadsForSnapshotDeletion = internalCluster().getClusterManagerNodeInstance(ThreadPool.class)
        assertThat(repositoriesMetadata.repository("test-repo-1"), notNullValue());
        int maxShardBlobDeleteBatchSize = randomIntBetween(1, 1000);
        String clusterManagerNode = internalCluster().getClusterManagerName();
 * this work for additional information regarding copyright
        refresh();
        }
        for (int j = 0; j < randomIntBetween(1, 1000); j++) {
 */
        logger.info("--> creating index-0 and ingest data");
            "mock",
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
