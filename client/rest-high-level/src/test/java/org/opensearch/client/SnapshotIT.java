        CreateSnapshotResponse response = createTestSnapshot(request);
            highLevelClient().snapshot()::restore,
    private static Map<String, Object> randomUserMetadata() {
            highLevelClient().snapshot()::restore,
        assertEquals(waitForCompletion ? RestStatus.OK : RestStatus.ACCEPTED, response.status());
 * this file be licensed under the Apache-2.0 license or a
        CreateSnapshotRequest createSnapshotRequest = new CreateSnapshotRequest(testRepository, testSnapshot);
        assertEquals(2, response.getSnapshots().size());
                );
        assertTrue(putRepositoryResponse.isAcknowledged());
        AcknowledgedResponse putRepositoryResponse = createTestRepository(testRepository, FsRepository.TYPE, "{\"location\": \".\"}");
        createSnapshotRequest.waitForCompletion(true);
 * GitHub history for details.
        assertThat(1, equalTo(response.repositories().size()));
            .map(SnapshotInfo::userMetadata);
        request.renameReplacement(restoredIndex);
    public void testCleanupRepository() throws IOException {
        assertTrue(createTestRepository(repository, FsRepository.TYPE, "{\"location\": \".\"}").isAcknowledged());
        GetRepositoriesResponse response = execute(
        if (returnedMetadata.isPresent()) {
        assertThat(
        GetRepositoriesRequest request = new GetRepositoriesRequest();
            highLevelClient().snapshot()::statusAsync
        String testRepository = "test";
        assertEquals(RestStatus.OK, putSnapshotResponse2.status());
        request.renamePattern(testIndex);
 * not use this file except in compliance with the License.
        assertEquals(RestStatus.OK, createSnapshotResponse.status());
        }
        assertTrue(createTestRepository("other", FsRepository.TYPE, "{\"location\": \".\"}").isAcknowledged());
            new GetRepositoriesRequest(),
        createSnapshotRequest.waitForCompletion(true);
        assertThat(restoreInfo.indices(), equalTo(Collections.singletonList(restoredIndex)));
    }
        deleteIndex(testIndex);
        } else {
        request.repository(testRepository);
import java.util.Collections;
            testIndex,
        CreateSnapshotResponse createSnapshotResponse = createTestSnapshot(createSnapshotRequest);
    public void testCloneSnapshot() throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        String testRepository = "test";
            request,
    }
 * specific language governing permissions and limitations
            );
            highLevelClient().snapshot()::verifyRepository,
        String repository = "doesnotexist";
        CreateSnapshotRequest request = new CreateSnapshotRequest(repository, snapshot);
        assertTrue(putRepositoryResponse.isAcknowledged());
        assertThat(response.result().bytes(), equalTo(0L));
        RestoreInfo restoreInfo = response.getRestoreInfo();
            request,
        createSnapshotRequest.waitForCompletion(true);
            response.getSnapshots().stream().map((s) -> s.snapshotId().getName()).collect(Collectors.toList()),
        CreateSnapshotResponse createSnapshotResponse = createTestSnapshot(createSnapshotRequest);
        String snapshot2 = "test_snapshot2";
        request.waitForCompletion(true);
        createSnapshotRequest.indices("*");
        GetRepositoriesRequest request = new GetRepositoriesRequest(new String[] { repository });
    public void testRestoreSnapshot() throws IOException {
        return execute(request, highLevelClient().snapshot()::createRepository, highLevelClient().snapshot()::createRepositoryAsync);
            } else {
    }
    public void testSnapshotGetRepositoriesNonExistent() {
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(RestStatus.OK, createSnapshotResponse.status());
            request = new GetSnapshotsRequest(repository);
            equalTo("OpenSearch exception [type=repository_missing_exception, reason=[" + repository + "] missing]")
        String testIndex = "test_index";
import java.util.Map;
            .filter(s -> s.snapshotId().getName().equals("test_snapshot2"))
        );
        }
}
        }
        String testSnapshot = "snapshot_1";
package org.opensearch.client;
        AcknowledgedResponse deleteResponse = execute(
    public void testGetSnapshots() throws IOException {
        AcknowledgedResponse putRepositoryResponse = createTestRepository("test", FsRepository.TYPE, "{\"location\": \".\"}");
            Settings.builder()
 *
        assertEquals(RestStatus.OK, createSnapshotResponse.status());
        }
                metadata.put(randomValueOtherThanMany(metadata::containsKey, () -> randomAlphaOfLengthBetween(2, 10)), nested);
        assertFalse("index [" + testIndex + "] should have been deleted", indexExists(testIndex));
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.rest.RestStatus;
        );
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest;
        );
    public void testSnapshotGetRepositoriesUsingParams() throws IOException {
            highLevelClient().snapshot()::cleanupRepositoryAsync
        String repository = "test";
    }
            createSnapshotRequest.userMetadata(randomUserMetadata());
        }
 * Licensed to Elasticsearch under one or more contributor
            if (randomBoolean()) {
        }
        assertEquals(RestStatus.OK, putSnapshotResponse1.status());
            exception.getMessage(),
        assertTrue(createTestRepository("other", FsRepository.TYPE, "{\"location\": \".\"}").isAcknowledged());
        CreateSnapshotRequest createSnapshotRequest2 = new CreateSnapshotRequest(repository, snapshot2);
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        if (randomBoolean()) {
        VerifyRepositoryRequest request = new VerifyRepositoryRequest("test");
            deleteRequest,
            }
        createSnapshotRequest.waitForCompletion(true);
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        if (waitForCompletion == false) {
                highLevelClient().snapshot()::deleteAsync
        GetRepositoriesResponse response = execute(
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequest;
        OpenSearchException exception = expectThrows(
        boolean waitForCompletion = randomBoolean();
    }
        request.waitForCompletion(waitForCompletion);
        deleteIndex(testIndex);
            highLevelClient().snapshot()::deleteRepository,
        return execute(createSnapshotRequest, highLevelClient().snapshot()::create, highLevelClient().snapshot()::createAsync);
        }
        assertTrue(putRepositoryResponse.isAcknowledged());
 * The OpenSearch Contributors require contributions made to
            contains("test_snapshot1", "test_snapshot2")
            request = new GetSnapshotsRequest(repository, new String[] { "_all" });
        AcknowledgedResponse response = execute(request, highLevelClient().snapshot()::clone, highLevelClient().snapshot()::cloneAsync);
        SnapshotsStatusResponse response = execute(
        DeleteRepositoryRequest deleteRequest = new DeleteRepositoryRequest(repository);
        String snapshot1 = "test_snapshot1";
 * You may obtain a copy of the License at
    private AcknowledgedResponse createTestRepository(String repository, String type, String settings) throws IOException {
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
        }
 */
import org.opensearch.core.xcontent.MediaTypeRegistry;
        GetSnapshotsResponse response = execute(request, highLevelClient().snapshot()::get, highLevelClient().snapshot()::getAsync);
        assertTrue(createTestRepository("test", FsRepository.TYPE, "{\"location\": \".\"}").isAcknowledged());
 * license agreements. See the NOTICE file distributed with
        );
                        randomValueOtherThanMany(nested::containsKey, () -> randomAlphaOfLengthBetween(2, 10)),
        );
            highLevelClient().snapshot()::restoreAsync
    }
        );
            assertEquals(originalMetadata, returnedMetadata.get());
        }
            highLevelClient().snapshot()::cleanupRepository,
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryResponse;
    }
        request.includeGlobalState(randomBoolean());
            highLevelClient().snapshot()::getRepository,
            request,
        assertTrue(putRepositoryResponse.isAcknowledged());
        String testIndex = "test_index";
        assertThat(restoreInfo.successfulShards(), greaterThan(0));
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
        AcknowledgedResponse putRepositoryResponse = createTestRepository(testRepository, FsRepository.TYPE, "{\"location\": \".\"}");
                    nested.put(
        assertThat(response.getSnapshots().get(0).getIndices().containsKey(testIndex), is(true));
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
        if (randomBoolean()) {
        } else {
/*
import static org.hamcrest.Matchers.equalTo;
            highLevelClient().snapshot()::verifyRepositoryAsync
        if (randomBoolean()) {
        CloneSnapshotRequest request = new CloneSnapshotRequest(repository, snapshot, targetSnapshot, new String[] { testIndex });
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        createSnapshotRequest.indices(testIndex);
        if (randomBoolean()) {
    }
        CreateSnapshotResponse createSnapshotResponse = createTestSnapshot(createSnapshotRequest);
import org.opensearch.snapshots.RestoreInfo;
import org.opensearch.OpenSearchException;
        RestoreSnapshotResponse response = execute(
        AcknowledgedResponse putRepositoryResponse = createTestRepository(repository, FsRepository.TYPE, "{\"location\": \".\"}");
        assertThat(1, equalTo(response.repositories().size()));
 * compatible open source license.
        assertThat(restoreInfo.successfulShards(), greaterThan(0));
            assertTrue(deleteResponse.isAcknowledged());
        assertTrue(response.isAcknowledged());
import org.opensearch.common.settings.Settings;
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
        GetRepositoriesRequest request = new GetRepositoriesRequest();
            createSnapshotRequest.userMetadata(randomUserMetadata());
        assertThat(2, equalTo(response.repositories().size()));
        assertTrue(deleteResponse.isAcknowledged());
        assertTrue(putRepositoryResponse.isAcknowledged());
        assertThat(restoreInfo.indices(), equalTo(Collections.singletonList(testIndex)));
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
        request.renamePattern(testIndex);
 * Modifications Copyright OpenSearch Contributors. See
        VerifyRepositoryResponse response = execute(
        } else if (randomBoolean()) {
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;
        request.snapshots(new String[] { testSnapshot });
        );
        assertThat(response.getSnapshots().get(0).getSnapshot().getRepository(), equalTo(testRepository));
        );
        String repository = "test_repository";
        createSnapshotRequest.indices(testIndex);
import java.io.IOException;
 * under the License.
        // check that the request went ok without parsing JSON here. When using the high level client, check acknowledgement instead.
 * Unless required by applicable law or agreed to in writing,
        // check that the request went ok without parsing JSON here. When using the high level client, check acknowledgement instead.
            createSnapshotRequest.userMetadata(randomUserMetadata());
        CreateSnapshotResponse createSnapshotResponse = createTestSnapshot(createSnapshotRequest);
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
        request.type(type);
            request,
        String repository = "test_repository";
            request,
            // If we don't wait for the snapshot to complete we have to cancel it to not leak the snapshot task
        AcknowledgedResponse response = createTestRepository("test", FsRepository.TYPE, "{\"location\": \".\"}");
    public void testSnapshotGetDefaultRepositories() throws IOException {
        assertThat(restoreInfo.failedShards(), equalTo(0));
                highLevelClient().snapshot()::delete,
    public void testSnapshotsStatus() throws IOException {
        assertTrue("index [" + testIndex + "] should have been created", indexExists(testIndex));
    }
        CreateSnapshotRequest createSnapshotRequest = new CreateSnapshotRequest(testRepository, testSnapshot);
        RestoreSnapshotResponse response = execute(
            highLevelClient().snapshot()::getRepository,
        CreateSnapshotRequest createSnapshotRequest = new CreateSnapshotRequest(repository, snapshot);
import java.util.stream.Collectors;
/*
            highLevelClient().snapshot()::getRepositoryAsync
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryRequest;
        String testRepository = "test";
        assertTrue("index [" + testIndex + "] should have been created", indexExists(testIndex));
                        randomAlphaOfLengthBetween(5, 5)
        assertEquals(RestStatus.OK, createSnapshotResponse.status());
                long nestedFields = randomLongBetween(0, 4);
                    randomValueOtherThanMany(metadata::containsKey, () -> randomAlphaOfLengthBetween(2, 10)),
    }
        String restoredIndex = testIndex + "_restored";
    public void testCreateSnapshot() throws Exception {
            .stream()
            AcknowledgedResponse deleteResponse = execute(
        request.indices(randomFrom(testIndex, "test_*"));
        AcknowledgedResponse putRepositoryResponse = createTestRepository(repository, FsRepository.TYPE, "{\"location\": \".\"}");
    }
        assertThat(response.result().blobs(), equalTo(0L));
    }
        assertTrue(putRepositoryResponse.isAcknowledged());
        assertTrue(response.isAcknowledged());
        CreateSnapshotResponse putSnapshotResponse2 = createTestSnapshot(createSnapshotRequest2);
        String repository = "test_repository";
 * ownership. Elasticsearch licenses this file to you under
        );
 *
        AcknowledgedResponse putRepositoryResponse = createTestRepository(testRepository, FsRepository.TYPE, "{\"location\": \".\"}");
            highLevelClient().snapshot()::deleteRepositoryAsync
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import java.util.HashMap;
        String snapshot = "test_snapshot";
        String targetSnapshot = "target_snapshot";
        long fields = randomLongBetween(0, 4);
        assertThat(response.getSnapshots().get(0).getSnapshot().getSnapshotId().getName(), equalTo(testSnapshot));
        return metadata;
        GetSnapshotsRequest request;
            highLevelClient().snapshot()::restoreAsync
            request,
        request.waitForCompletion(true);
        Optional<Map<String, Object>> returnedMetadata = response.getSnapshots()
import org.opensearch.cluster.metadata.IndexMetadata;
        assertTrue(createTestRepository(repository, FsRepository.TYPE, "{\"location\": \".\"}").isAcknowledged());
        request.settings(settings, MediaTypeRegistry.JSON);
        assertTrue("index [" + testIndex + "] should have been created", indexExists(testIndex));
        String testIndex = "test_index";
        // assumes the repository already exists
        CreateSnapshotRequest createSnapshotRequest = new CreateSnapshotRequest(repository, snapshot);
    }
                    );
            highLevelClient().snapshot()::getRepositoryAsync
                new DeleteSnapshotRequest(repository, snapshot),
    }
        createSnapshotRequest2.userMetadata(originalMetadata);
        );
    public void testVerifyRepository() throws IOException {
        );
            () -> execute(request, highLevelClient().snapshot()::getRepository, highLevelClient().snapshot()::getRepositoryAsync)
            highLevelClient().snapshot()::getRepositoryAsync
        String testSnapshot = "snapshot";
        String testRepository = "test";
        String testSnapshot = "snapshot_1";
        assertTrue(putRepositoryResponse.isAcknowledged());
        assertTrue(response.isAcknowledged());
        SnapshotsStatusRequest request = new SnapshotsStatusRequest();
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryResponse;
        AcknowledgedResponse response = execute(request, highLevelClient().snapshot()::delete, highLevelClient().snapshot()::deleteAsync);
import static org.hamcrest.Matchers.contains;
 */
        createIndex(testIndex, Settings.EMPTY);
            request.userMetadata(randomUserMetadata());
        assertThat(response.getNodes().size(), equalTo(1));
        assertThat(response.getSnapshots().size(), equalTo(1));
            assertNull("retrieved metadata is null, expected non-null metadata", originalMetadata);
        assertThat(restoreInfo.name(), equalTo(testSnapshot));
    }
        assertThat(restoreInfo.name(), equalTo(testSnapshot));
            request,
        final String testIndex = "test_idx";
import static org.hamcrest.Matchers.greaterThan;
        DeleteSnapshotRequest request = new DeleteSnapshotRequest(repository, snapshot);
        assertTrue(putRepositoryResponse.isAcknowledged());
 */
            .findFirst()
import static org.hamcrest.Matchers.is;
        CleanupRepositoryRequest request = new CleanupRepositoryRequest("test");
import java.util.Optional;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 3))
        if (randomBoolean()) {
import org.opensearch.repositories.fs.FsRepository;
    public void testSnapshotHidden() throws IOException {
        RestoreInfo restoreInfo = response.getRestoreInfo();
                Map<String, Object> nested = new HashMap<>();
            OpenSearchException.class,
        RestoreSnapshotRequest request = new RestoreSnapshotRequest(testRepository, testSnapshot);
        createIndex(
        String repository = "test_repository";
        if (randomBoolean()) {
    public void testDeleteSnapshot() throws IOException {
 *
        createIndex(testIndex, Settings.EMPTY);
            request = new GetSnapshotsRequest(repository, new String[] { snapshot1, snapshot2 });
        assertFalse("index [" + testIndex + "] should have been deleted", indexExists(testIndex));
public class SnapshotIT extends OpenSearchRestHighLevelClientTestCase {
        CreateSnapshotRequest createSnapshotRequest1 = new CreateSnapshotRequest(repository, snapshot1);
        AcknowledgedResponse putRepositoryResponse = createTestRepository(repository, FsRepository.TYPE, "{\"location\": \".\"}");
 * software distributed under the License is distributed on an
        CreateSnapshotRequest createSnapshotRequest = new CreateSnapshotRequest(testRepository, testSnapshot);
    public void testSnapshotDeleteRepository() throws IOException {
                .put(IndexMetadata.SETTING_INDEX_HIDDEN, true)
 * this work for additional information regarding copyright
        String snapshot = "test_snapshot";
        assertThat(
        );
        assertThat(exception.status(), equalTo(RestStatus.NOT_FOUND));
        for (int i = 0; i < fields; i++) {
                for (int j = 0; j < nestedFields; j++) {
                .build()
        String snapshot = "source_snapshot";
        createSnapshotRequest1.waitForCompletion(true);
    }
            highLevelClient().snapshot()::status,
        CreateSnapshotResponse putSnapshotResponse1 = createTestSnapshot(createSnapshotRequest1);
/*
        CleanupRepositoryResponse response = execute(
        assertTrue(createTestRepository(testRepository, FsRepository.TYPE, "{\"location\": \".\"}").isAcknowledged());
        );
    public void testCreateRepository() throws IOException {
import org.opensearch.action.admin.cluster.snapshots.clone.CloneSnapshotRequest;
import org.opensearch.snapshots.SnapshotInfo;
            highLevelClient().snapshot()::getRepository,
    private CreateSnapshotResponse createTestSnapshot(CreateSnapshotRequest createSnapshotRequest) throws IOException {
        createSnapshotRequest.waitForCompletion(true);
            return null;
        Map<String, Object> metadata = new HashMap<>();
        request.partial(randomBoolean());
        PutRepositoryRequest request = new PutRepositoryRequest(repository);
        request.repositories(new String[] { testRepository });
        createIndex(testIndex, Settings.EMPTY);
                metadata.put(
        createSnapshotRequest2.waitForCompletion(true);
                    randomAlphaOfLengthBetween(5, 5)
        Map<String, Object> originalMetadata = randomUserMetadata();
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequest;
                }
        RestoreSnapshotRequest request = new RestoreSnapshotRequest(testRepository, testSnapshot);
        CreateSnapshotResponse createSnapshotResponse = createTestSnapshot(createSnapshotRequest);
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
 * KIND, either express or implied.  See the License for the
        // check that the request went ok without parsing JSON here. When using the high level client, check acknowledgement instead.
        assertEquals(RestStatus.OK, createSnapshotResponse.status());
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
        GetRepositoriesResponse response = execute(
        assertThat(restoreInfo.failedShards(), equalTo(0));
        AcknowledgedResponse putRepositoryResponse = createTestRepository("test", FsRepository.TYPE, "{\"location\": \".\"}");
    }
