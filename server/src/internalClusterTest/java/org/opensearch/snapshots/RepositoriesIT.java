 * software distributed under the License is distributed on an
        );  
            .info(ThreadPool.Names.SNAPSHOT)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
            RepositoryVerificationException.class
                Settings.builder().put(settings),
            .setThrowExceptionWhileDelete(true);
                false  
            .setThrowExceptionWhileDelete(false);
    }
import static org.hamcrest.Matchers.containsString;  
        RepositoriesMetadata repositoriesMetadata = metadata.custom(RepositoriesMetadata.TYPE);  
        Path repositoryPath = randomRepoPath();  
            "test-repo",
        logger.info("-->  creating repository at {}", repositoryPath.toAbsolutePath());
 * license agreements. See the NOTICE file distributed with
        PutRepositoryRequestBuilder requestBuilder = OpenSearchIntegTestCase.putRepositoryRequestBuilder(
                "mock",  
            assertThat(ex.getMessage(), containsString("is not shared"));
            RepositoryVerificationException.class  
        createFullSnapshot(repositoryName, firstSnapshot);
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryResponse;  
        assertThat(repositoriesResponse.repositories().size(), equalTo(0));
            index("test-idx-0", "_doc", Integer.toString(10 + j), "foo", "bar" + 10 + j);
 * Modifications Copyright OpenSearch Contributors. See
        createIndex(indexName);  
        );  
        logger.info("--> check that repository is really there");  
        logger.info("--> creating index-0 and ingest data");
        int maxShardBlobDeleteBatchSize = randomIntBetween(1, 1000);
        logger.info("--> delete first snapshot");  
            .get();
        client.admin().cluster().prepareDeleteSnapshot(repositoryName, secondSnapshot).get();  
        // This will make sure stale indices stays in repository after snapshot delete
        createRepository(repositoryName, "mock", repositoryPath);  
                index(testIndexName, "_doc", Integer.toString(10 + j), "foo", "bar" + 10 + j);
        }
        logger.info("--> delete the bulk of the snapshots");
        // Make repository to throw exception when trying to delete stale indices
            false  
            logger.info("--> creating snapshot: {}", snapshotName);  
        createRepository("test-repo-2", "fs");  
        for (RepositoryMetadata repository : repositories) {
    public void testRepositoryVerification() throws Exception {  
 * compatible open source license.
public class RepositoriesIT extends AbstractSnapshotIntegTestCase {
            for (int i = 0; i < randomIntBetween(100, 1000); ++i) {  
            Settings.builder()  
        settings = Settings.builder()
        refresh();
    public void testSnapshotShardBlobDelete() throws Exception {
            OpenSearchIntegTestCase.putRepositoryRequestBuilder(
        logger.info("-->  verifying repository");
 * the Apache License, Version 2.0 (the "License"); you may
    }  
/*  
            refresh();
        Path location = randomRepoPath();  
        repositoriesResponse = client.admin().cluster().prepareGetRepositories().get();  
import org.opensearch.repositories.RepositoryException;  
import static org.hamcrest.Matchers.equalTo;
                "test-repo-1",
            "test-repo",
 * this file be licensed under the Apache-2.0 license or a
        try {
        );  
        logger.info("--> check that both repositories are in cluster state");
                true,  
        }
        logger.info("-->  creating read-only repository that cannot read any files, but suppress verification - should be acked");
        }  
        // Make repository to throw exception when trying to delete stale snapshot shard blobs
        createFullSnapshot(repositoryName, secondSnapshot);  
            createRepository("test-repo-1", "mock", settingsBuilder);
        createRepository(  
        assertThat(repositoriesMetadata.repository("test-repo-1").type(), equalTo("fs"));  
        deleteRepositoryResponse = client().admin().cluster().prepareDeleteRepository("test-repo-1").get();
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
        // (2) index-latest  
            "mock",
        logger.info("--> make sure that number of files is back to what it was when the first snapshot was made");
        logger.info("--> creating first snapshot");
        logger.info("-->  deleting repository test-repo-1 with standard timeout - should ack");
        client.admin().cluster().prepareDeleteSnapshot(repositoryName, firstSnapshot).get();
        int maxShardBlobDeleteBatchSize = randomIntBetween(1, 1000);
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, clusterManagerNode).repository("test-repo"))
        }
        logger.info("--> adding some more documents to test index");
    public void testSnapshotShardBlobDeletionRepositoryThrowingError() throws Exception {
        Client client = client();  
        logger.info("-->  creating repository test-repo-2 with standard timeout - should ack");
        final String repositoryName = "test-repo";
        logger.info("--> verify the repository");
        logger.info("--> creating index-0 and ingest data");
package org.opensearch.snapshots;
        assertThat(repositoriesMetadata.repositories().size(), equalTo(2));
        int numberOfFiles = numberOfFiles(repositoryPath);
        try {
        logger.info("-->  creating repository at {}", repositoryPath.toAbsolutePath());
        logger.info("--> delete repository test-repo-2");
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(repositoriesResponse.repositories().size(), equalTo(1));
        Path invalidRepoPath = createTempDir().toAbsolutePath();  
        logger.info("-->  creating repository that cannot write any files - should fail");
                Settings.builder().put(readonlySettings),
        for (int j = 0; j < randomIntBetween(1, 1000); j++) {
import org.opensearch.repositories.RepositoryVerificationException;
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.common.settings.Settings;
        VerifyRepositoryResponse verifyRepositoryResponse = client.admin().cluster().prepareVerifyRepository("test-repo-1").get();  
        assertThat(verifyRepositoryResponse.getNodes().size(), equalTo(cluster().numDataAndClusterManagerNodes()));
        clusterStateResponse = client.admin().cluster().prepareState().clear().setMetadata(true).get();  
 * this work for additional information regarding copyright
        ensureGreen();
            .put("compress", randomBoolean())  
        } catch (RepositoryException ex) {
        }  
}
/*
        assertThat(repositoriesMetadata.repository("test-repo-2").type(), equalTo("fs"));
        client.admin().cluster().prepareDeleteSnapshot(repositoryName, snapshotToBeDeletedLastName).get();
        } catch (RepositoryVerificationException ex) {  
            ensureGreen();  
        logger.info("--> trying creating fs repository with location that is not registered in path.repo setting");
        Client client = client();  
 *
        final String firstSnapshot = "first-snapshot";  
                bulkRequest.add(new IndexRequest(indexName).source("foo" + j, "bar" + i));
            );  
        logger.info("-->  creating repository at {}", repositoryPath.toAbsolutePath());
 * under the License.  
        assertThat(findRepository(repositoriesResponse.repositories(), "test-repo-1"), notNullValue());
            Settings.builder().put(readonlySettings)
    }
            client().bulk(bulkRequest).get();  
        assertThat(repositoriesMetadata, notNullValue());
        repositoriesResponse = client.admin().cluster().prepareGetRepositories().get();  
                "mock",
        }
    private RepositoryMetadata findRepository(List<RepositoryMetadata> repositories, String name) {  
                client.admin().cluster(),
        logger.info("--> creating first snapshot");
        String location = invalidRepoPath.toString();
        assertRequestBuilderThrows(
        final String bulkSnapshotsPattern = "test-snap-*";  
            createIndex(testIndexName);
            client().bulk(bulkRequest).get();
        int maxThreadsForSnapshotDeletion = internalCluster().getClusterManagerNodeInstance(ThreadPool.class)
        String clusterManagerNode = internalCluster().getClusterManagerName();  
        createRepository(  
        refresh();
        // (1) index-(N+1)
        logger.info("-->  creating repository");
            .setThrowExceptionWhileDelete(true);
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import org.opensearch.snapshots.mockstore.MockRepository;  
        createFullSnapshot(repositoryName, firstSnapshot);
            for (int i = 0; i < randomIntBetween(100, 1000); ++i) {
        GetRepositoriesResponse repositoriesResponse = client.admin()
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchIntegTestCase;
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, clusterManagerNode).repository("test-repo"))
        OpenSearchIntegTestCase.putRepository(client.admin().cluster(), "test-repo-1", "mock", false, Settings.builder().put(settings));  
            ),
        createRepository("test-repo-1", "fs", Settings.builder().put("location", location));
        createRepository("test-repo-1", "fs", location);
            OpenSearchIntegTestCase.putRepositoryRequestBuilder(  
            .put("chunk_size", randomIntBetween(5, 100), ByteSizeUnit.BYTES);
        // Delete second snapshot
        String clusterManagerNode = internalCluster().getClusterManagerName();  
        assertThat(repositoriesResponse.repositories().size(), equalTo(2));  
import org.opensearch.action.index.IndexRequest;  
            client.admin().cluster(),
                return repository;  
    public void testMisconfiguredRepository() throws Exception {  
        assertThat(repositoriesMetadata.repository("test-repo-2"), notNullValue());
import java.util.List;  
        client.admin().cluster().prepareDeleteRepository("test-repo-1").get();
        for (int j = 0; j < randomIntBetween(100, 10000); ++j) {
        final String repositoryName = "test-repo";
        createIndex("test-idx-0");
            .setThrowExceptionWhileDelete(false);  
        logger.info("--> delete second snapshot");
import java.nio.file.Path;
        repositoriesMetadata = metadata.custom(RepositoriesMetadata.TYPE);
        // This snapshot should delete last snapshot's residual stale indices as well
        logger.info("-->  deleting repository test-repo-2 with 0s timeout - shouldn't ack");
                ex.toString(),
            "fs",
 * KIND, either express or implied.  See the License for the
        logger.info("-->  verifying repository");
            client().admin().cluster(),  
            .cluster()
        logger.info("--> adding some more documents to test index");  
            assertThat(  
        // Expect two files to remain in the repository:
 */
        refresh();
                false
    }
import org.opensearch.repositories.RepositoriesService;
            assertThat(ex.toString(), containsString("missing location"));
import org.opensearch.repositories.blobstore.BlobStoreRepository;
            .cluster()  
import org.opensearch.cluster.metadata.Metadata;
        return null;  
            }
            final BulkRequest bulkRequest = new BulkRequest();
            settings,
        Client client = client();
    }  
        if (testRepo1Md.settings().equals(testRepo1MdAfterUpdate.settings())) {  
        final String snapshotToBeDeletedLastName = "test-snapshot-to-be-deleted-last";
                "test-repo-2",
            .put("location", randomRepoPath())
 *  
        // Delete second snapshot
            .get();
            final BulkRequest bulkRequest = new BulkRequest();  
        for (int i = 1; i <= maxThreadsForSnapshotDeletion + 1; i++) {
        final String firstSnapshot = "first-snapshot";  
        Path repositoryPath = randomRepoPath();
import org.opensearch.cluster.metadata.RepositoriesMetadata;  
            String testIndexName = "test-idx-" + i;  
        assertRequestBuilderThrows(
        assertThat(findRepository(repositoriesResponse.repositories(), "test-repo-2"), notNullValue());
 * SPDX-License-Identifier: Apache-2.0
        Path repositoryPath = randomRepoPath();
            .getMax();  
        final String secondSnapshot = "second-snapshot";
        assertFileCount(repositoryPath, numberOfFiles);  
        logger.info("--> delete repository test-repo-1");
                true,
        final String indexName = "test-idx";
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, clusterManagerNode).repository("test-repo"))  
        assertThat(repositoriesMetadata.repository("test-repo-1").type(), equalTo("fs"));  
        assertFileCount(repositoryPath, 2);
import org.opensearch.action.bulk.BulkRequest;
    }
            .put("location", randomRepoPath())  
import org.opensearch.core.common.unit.ByteSizeUnit;  
            Settings.Builder settingsBuilder = Settings.builder().put("location", location).put("localize_location", true);  
        logger.info("--> done");
        assertThat(deleteRepositoryResponse.isAcknowledged(), equalTo(false));
        logger.info("--> check that both repositories can be retrieved by getRepositories query");
        for (int j = 0; j < randomIntBetween(100, 1000); ++j) {
 * GitHub history for details.
        }
        createRepository("test-repo-2", "fs", settings);  
            client.admin().cluster().preparePutRepository("test-repo").setType("fs").get();
            fail("RepositoryVerificationException wasn't generated");
 * Unless required by applicable law or agreed to in writing,
        logger.info("--> trying creating repository with incorrect settings");  
        }
        for (int j = 0; j < randomIntBetween(1, 1000); j++) {
            .put("chunk_size", randomIntBetween(5, 100), ByteSizeUnit.BYTES);
            createFullSnapshot(repositoryName, snapshotName);
        refresh();
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        }
        Client client = client();  
            .prepareDeleteRepository("test-repo-2")
            index(indexName, "_doc", Integer.toString(j), "foo", "bar" + j);  
        logger.info("--> creating second snapshot");
        logger.info("-->  creating another repository");
    public void testResidualStaleIndicesAreDeletedByConsecutiveDelete() throws Exception {
        assertThat(repositoriesMetadata.repository("test-repo-1"), notNullValue());
        logger.info("--> make sure that number of files is back to what it was when the first snapshot was made");  
 * You may obtain a copy of the License at  
            true,  
        Settings settings = Settings.builder().put("location", randomRepoPath()).put("random_control_io_exception_rate", 1.0).build();
            .prepareGetRepositories(randomFrom("_all", "*", "test-repo-*"))
        assertRequestBuilderThrows(client.admin().cluster().prepareVerifyRepository("test-repo-2"), RepositoryVerificationException.class);  
        assertFalse(requestBuilder.get().isAcknowledged());
        createFullSnapshot(repositoryName, secondSnapshot);
                .put("location", repositoryPath)
        final String secondSnapshot = "second-snapshot";
        logger.info("--> done");  
        assertRequestBuilderThrows(client.admin().cluster().prepareVerifyRepository("test-repo-1"), RepositoryVerificationException.class);  
                null,  
        disableRepoConsistencyCheck("This test does not create any data in the repository.");
        createFullSnapshot(repositoryName, snapshotToBeDeletedLastName);
        Client client = client();
import org.opensearch.threadpool.ThreadPool;
        for (int j = 0; j < 10; j++) {
                .put("location", repositoryPath)
        final String repositoryName = "test-repo";
 */  
        createIndex(indexName);  
        client.admin().cluster().prepareDeleteRepository("test-repo-2").get();
        RepositoryMetadata testRepo1MdAfterUpdate = findRepository(repositoriesResponse.repositories(), "test-repo-1");
        RepositoryMetadata testRepo1Md = findRepository(repositoriesResponse.repositories(), "test-repo-1");
        logger.info("--> creating second snapshot");
    }
            assertEquals(beforeStateUuid, client.admin().cluster().prepareState().clear().get().getState().stateUUID());
            "0s",
            logger.info("--> creating index-" + i + " and ingest data");
            .setTimeout("0s")  
        logger.info("--> done");  
        ensureGreen();  
import org.opensearch.core.util.FileSystemUtils;
        logger.info("-->  creating repository that cannot write any files, but suppress verification - should be acked");
        Settings.Builder settings = Settings.builder()
        );
        assertThat(deleteRepositoryResponse.isAcknowledged(), equalTo(true));  
        // Create more snapshots to be deleted in bulk  
        // Make repository to work normally
                client.admin().cluster(),  
        Path location = randomRepoPath();
        assertFileCount(repositoryPath, numberOfFiles + 2);
        ((MockRepository) internalCluster().getInstance(RepositoriesService.class, clusterManagerNode).repository("test-repo"))
        String beforeStateUuid = clusterStateResponse.getState().stateUUID();
 */  
                .put(BlobStoreRepository.MAX_SNAPSHOT_SHARD_BLOB_DELETE_BATCH_SIZE.getKey(), maxShardBlobDeleteBatchSize)
        OpenSearchIntegTestCase.putRepository(  
 * Licensed to Elasticsearch under one or more contributor  
            "mock",  
 * The OpenSearch Contributors require contributions made to  
            .put("compress", randomBoolean())
        logger.info("--> delete second snapshot");
        AcknowledgedResponse deleteRepositoryResponse = client().admin()  
        Metadata metadata = clusterStateResponse.getState().getMetadata();
 *
        int numberOfFiles = numberOfFiles(repositoryPath);
            Settings.builder()  
        );
        // Make repository to work normally
        int numberOfFiles = FileSystemUtils.files(location).length;
        assertThat(findRepository(repositoriesResponse.repositories(), "test-repo-2"), notNullValue());
                null,
                containsString("location [" + location + "] doesn't match any of the locations specified " + "by path.repo")
        }
            for (int j = 0; j < 10; j++) {
        logger.info("--> delete first snapshot");
            "mock",
        try {
            index(indexName, "_doc", Integer.toString(j), "foo", "bar" + j);  
        assertThat(FileSystemUtils.files(location).length, equalTo(numberOfFiles));
        refresh();  
        // This snapshot should delete last snapshot's residual stale shard blobs as well  
            ),
                bulkRequest.add(new IndexRequest(indexName).source("foo" + j, "bar" + i));
        logger.info("-->  creating repository test-repo-1 with 0s timeout - shouldn't ack");
        assertThat(repositoriesMetadata.repository("test-repo-1"), notNullValue());
        );  
import org.opensearch.transport.client.Client;  
            fail("Shouldn't be here");
            }
        client.admin().cluster().prepareDeleteSnapshot(repositoryName, secondSnapshot).get();  
        } catch (RepositoryException ex) {
        final String indexName = "test-idx";
        ClusterStateResponse clusterStateResponse = client.admin().cluster().prepareState().clear().setMetadata(true).get();
            }  
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequestBuilder;
    public void testRepositoryAckTimeout() throws Exception {
        logger.info("-->  creating read-only repository that cannot read any files - should fail");  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        assertThat(repositoriesMetadata, notNullValue());  
    }
            "test-repo-1",
            fail("Shouldn't be here");  
                .put(BlobStoreRepository.MAX_SNAPSHOT_SHARD_BLOB_DELETE_BATCH_SIZE.getKey(), maxShardBlobDeleteBatchSize)
            }  
        logger.info("--> creating index-0 and ingest data");
        logger.info("--> check that trying to create a repository with the same settings repeatedly does not update cluster state");  
            String snapshotName = "test-snap-" + i;
        repositoriesResponse = client.admin().cluster().prepareGetRepositories(randomFrom("_all", "*", "test-repo-*")).get();  
    public void testRepositoryCreation() throws Exception {  
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 2)
        client.admin().cluster().prepareDeleteSnapshot(repositoryName, bulkSnapshotsPattern).get();
            createRepository("test-repo", "fs", Settings.builder().put("location", location));  
        metadata = clusterStateResponse.getState().getMetadata();
        logger.info("--> verify that we didn't leave any files as a result of verification");  
import org.opensearch.cluster.metadata.RepositoryMetadata;
        Settings readonlySettings = Settings.builder().put(settings).put("readonly", true).build();  
        logger.info("--> creating first snapshot");  
        Client client = client();
            false,
            if (repository.name().equals(name)) {
            "test-repo-2",
        ensureGreen();
