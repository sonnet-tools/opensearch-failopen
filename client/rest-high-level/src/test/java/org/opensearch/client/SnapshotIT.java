            request,  
        AcknowledgedResponse response = createTestRepository("test", FsRepository.TYPE, "{\"location\": \".\"}");  
            highLevelClient().snapshot()::deleteRepository,
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
            request = new GetSnapshotsRequest(repository, new String[] { "_all" });
        assertTrue(putRepositoryResponse.isAcknowledged());
            request = new GetSnapshotsRequest(repository);  
        assertThat(restoreInfo.indices(), equalTo(Collections.singletonList(restoredIndex)));
        );  
        assertThat(response.result().blobs(), equalTo(0L));
        String testRepository = "test";  
        createSnapshotRequest2.userMetadata(originalMetadata);
                    randomValueOtherThanMany(metadata::containsKey, () -> randomAlphaOfLengthBetween(2, 10)),
                        randomValueOtherThanMany(nested::containsKey, () -> randomAlphaOfLengthBetween(2, 10)),
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;  
                    nested.put(  
                highLevelClient().snapshot()::delete,
        PutRepositoryRequest request = new PutRepositoryRequest(repository);
        RestoreSnapshotResponse response = execute(
            }  
        if (randomBoolean()) {  
        assertThat(restoreInfo.successfulShards(), greaterThan(0));
    }  
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
        boolean waitForCompletion = randomBoolean();
        assertThat(restoreInfo.successfulShards(), greaterThan(0));
import static org.hamcrest.Matchers.contains;  
            highLevelClient().snapshot()::restoreAsync
        GetRepositoriesResponse response = execute(
        assertTrue(createTestRepository("other", FsRepository.TYPE, "{\"location\": \".\"}").isAcknowledged());
        );
            highLevelClient().snapshot()::verifyRepositoryAsync
        String repository = "test_repository";  
package org.opensearch.client;
    }
            testIndex,  
                    randomAlphaOfLengthBetween(5, 5)  
            highLevelClient().snapshot()::cleanupRepositoryAsync
        // check that the request went ok without parsing JSON here. When using the high level client, check acknowledgement instead.
        assertTrue(putRepositoryResponse.isAcknowledged());
        assertThat(restoreInfo.failedShards(), equalTo(0));  
        // check that the request went ok without parsing JSON here. When using the high level client, check acknowledgement instead.  
 */  
import org.opensearch.OpenSearchException;
        assertEquals(RestStatus.OK, putSnapshotResponse2.status());
        CreateSnapshotRequest createSnapshotRequest1 = new CreateSnapshotRequest(repository, snapshot1);
        SnapshotsStatusRequest request = new SnapshotsStatusRequest();
    }
                    );  
        AcknowledgedResponse putRepositoryResponse = createTestRepository(repository, FsRepository.TYPE, "{\"location\": \".\"}");
        request.snapshots(new String[] { testSnapshot });  
    public void testDeleteSnapshot() throws IOException {  
import java.io.IOException;
        );  
        AcknowledgedResponse putRepositoryResponse = createTestRepository(testRepository, FsRepository.TYPE, "{\"location\": \".\"}");
        );  
        assertEquals(RestStatus.OK, createSnapshotResponse.status());
        assertThat(restoreInfo.indices(), equalTo(Collections.singletonList(testIndex)));
        createSnapshotRequest2.waitForCompletion(true);
        CleanupRepositoryRequest request = new CleanupRepositoryRequest("test");
 *    http://www.apache.org/licenses/LICENSE-2.0
            Settings.builder()
                metadata.put(
    public void testSnapshotGetDefaultRepositories() throws IOException {
        OpenSearchException exception = expectThrows(
        CreateSnapshotRequest request = new CreateSnapshotRequest(repository, snapshot);
public class SnapshotIT extends OpenSearchRestHighLevelClientTestCase {
 * You may obtain a copy of the License at  
        assertThat(response.getSnapshots().get(0).getSnapshot().getRepository(), equalTo(testRepository));
    public void testCreateSnapshot() throws Exception {
            if (randomBoolean()) {  
        // assumes the repository already exists  
        String snapshot2 = "test_snapshot2";
        RestoreSnapshotRequest request = new RestoreSnapshotRequest(testRepository, testSnapshot);  
        assertEquals(RestStatus.OK, createSnapshotResponse.status());
        }  
        CreateSnapshotRequest createSnapshotRequest = new CreateSnapshotRequest(testRepository, testSnapshot);  
        assertTrue("index [" + testIndex + "] should have been created", indexExists(testIndex));
        Map<String, Object> metadata = new HashMap<>();  
            .findFirst()
        request.renameReplacement(restoredIndex);  
        );
        }
        assertEquals(RestStatus.OK, createSnapshotResponse.status());
        VerifyRepositoryResponse response = execute(
        final String testIndex = "test_idx";
            request,  
        long fields = randomLongBetween(0, 4);
        );
        String testRepository = "test";
        CreateSnapshotResponse createSnapshotResponse = createTestSnapshot(createSnapshotRequest);  
 *  
}
 * the Apache License, Version 2.0 (the "License"); you may
        DeleteRepositoryRequest deleteRequest = new DeleteRepositoryRequest(repository);
                metadata.put(randomValueOtherThanMany(metadata::containsKey, () -> randomAlphaOfLengthBetween(2, 10)), nested);
        }
 * specific language governing permissions and limitations
        );  
import org.opensearch.snapshots.RestoreInfo;
    public void testSnapshotsStatus() throws IOException {
        CreateSnapshotResponse createSnapshotResponse = createTestSnapshot(createSnapshotRequest);  
        assertFalse("index [" + testIndex + "] should have been deleted", indexExists(testIndex));
        AcknowledgedResponse response = execute(request, highLevelClient().snapshot()::clone, highLevelClient().snapshot()::cloneAsync);
            request,
        assertThat(restoreInfo.name(), equalTo(testSnapshot));  
        }
        createIndex(testIndex, Settings.EMPTY);
        );  
        assertTrue(response.isAcknowledged());
            assertTrue(deleteResponse.isAcknowledged());
    public void testSnapshotGetRepositoriesNonExistent() {
        CreateSnapshotRequest createSnapshotRequest2 = new CreateSnapshotRequest(repository, snapshot2);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
            highLevelClient().snapshot()::verifyRepository,  
        request.type(type);
        AcknowledgedResponse putRepositoryResponse = createTestRepository(testRepository, FsRepository.TYPE, "{\"location\": \".\"}");  
                for (int j = 0; j < nestedFields; j++) {
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;  
        GetSnapshotsRequest request;
/*  
        request.waitForCompletion(true);
    }
        RestoreInfo restoreInfo = response.getRestoreInfo();
        createSnapshotRequest1.waitForCompletion(true);
        createIndex(testIndex, Settings.EMPTY);  
 * GitHub history for details.
            highLevelClient().snapshot()::status,  
    }
            highLevelClient().snapshot()::getRepositoryAsync  
 * not use this file except in compliance with the License.
            highLevelClient().snapshot()::getRepositoryAsync
 * KIND, either express or implied.  See the License for the
    private static Map<String, Object> randomUserMetadata() {
                Map<String, Object> nested = new HashMap<>();  
        createSnapshotRequest.indices(testIndex);
        } else if (randomBoolean()) {
    }
        assertTrue(putRepositoryResponse.isAcknowledged());
        GetRepositoriesRequest request = new GetRepositoriesRequest(new String[] { repository });  
                        randomAlphaOfLengthBetween(5, 5)
        String testIndex = "test_index";  
 * this work for additional information regarding copyright
        VerifyRepositoryRequest request = new VerifyRepositoryRequest("test");  
 * SPDX-License-Identifier: Apache-2.0
        );  
    public void testCloneSnapshot() throws IOException {
        String snapshot = "source_snapshot";  
        );
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryResponse;  
        assertTrue(response.isAcknowledged());
        for (int i = 0; i < fields; i++) {
        }
        GetRepositoriesResponse response = execute(
        CreateSnapshotRequest createSnapshotRequest = new CreateSnapshotRequest(testRepository, testSnapshot);  
        CreateSnapshotRequest createSnapshotRequest = new CreateSnapshotRequest(repository, snapshot);
 * software distributed under the License is distributed on an
            request,
 * under the License.  
            createSnapshotRequest.userMetadata(randomUserMetadata());
        if (randomBoolean()) {
        assertTrue("index [" + testIndex + "] should have been created", indexExists(testIndex));
                .put(IndexMetadata.SETTING_INDEX_HIDDEN, true)
        request.includeGlobalState(randomBoolean());
        assertThat(response.getSnapshots().get(0).getSnapshot().getSnapshotId().getName(), equalTo(testSnapshot));
            deleteRequest,  
        SnapshotsStatusResponse response = execute(
        CreateSnapshotResponse createSnapshotResponse = createTestSnapshot(createSnapshotRequest);  
        createSnapshotRequest.waitForCompletion(true);
        assertTrue(putRepositoryResponse.isAcknowledged());
 *
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
            highLevelClient().snapshot()::restore,
 * The OpenSearch Contributors require contributions made to  
        request.waitForCompletion(waitForCompletion);  
/*  
        String repository = "test_repository";  
        assertTrue(putRepositoryResponse.isAcknowledged());
                highLevelClient().snapshot()::deleteAsync
 * Modifications Copyright OpenSearch Contributors. See
    public void testSnapshotDeleteRepository() throws IOException {
        return metadata;
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
        assertThat(1, equalTo(response.repositories().size()));
import org.opensearch.repositories.fs.FsRepository;
        String testSnapshot = "snapshot";
import java.util.Collections;  
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        assertThat(restoreInfo.failedShards(), equalTo(0));  
        if (randomBoolean()) {
            request = new GetSnapshotsRequest(repository, new String[] { snapshot1, snapshot2 });
            OpenSearchException.class,
        GetSnapshotsResponse response = execute(request, highLevelClient().snapshot()::get, highLevelClient().snapshot()::getAsync);
        RestoreSnapshotRequest request = new RestoreSnapshotRequest(testRepository, testSnapshot);  
    private CreateSnapshotResponse createTestSnapshot(CreateSnapshotRequest createSnapshotRequest) throws IOException {
    public void testCleanupRepository() throws IOException {  
import java.util.stream.Collectors;
        if (randomBoolean()) {  
            request,  
        String repository = "test";
        String snapshot = "test_snapshot";  
    }
        String testRepository = "test";
            } else {
        AcknowledgedResponse putRepositoryResponse = createTestRepository(repository, FsRepository.TYPE, "{\"location\": \".\"}");
    public void testSnapshotGetRepositoriesUsingParams() throws IOException {
        String restoredIndex = testIndex + "_restored";
        assertFalse("index [" + testIndex + "] should have been deleted", indexExists(testIndex));
        // check that the request went ok without parsing JSON here. When using the high level client, check acknowledgement instead.
        request.renamePattern(testIndex);  
            highLevelClient().snapshot()::getRepositoryAsync
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequest;
        String testSnapshot = "snapshot_1";
    }
        assertTrue(deleteResponse.isAcknowledged());
    }
        assertThat(response.getNodes().size(), equalTo(1));  
        CreateSnapshotResponse response = createTestSnapshot(request);
        CreateSnapshotResponse putSnapshotResponse2 = createTestSnapshot(createSnapshotRequest2);
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import static org.hamcrest.Matchers.is;  
        assertThat(
 * compatible open source license.
        deleteIndex(testIndex);  
        CreateSnapshotResponse createSnapshotResponse = createTestSnapshot(createSnapshotRequest);
            return null;  
        request.indices(randomFrom(testIndex, "test_*"));
            new GetRepositoriesRequest(),  
    public void testVerifyRepository() throws IOException {
        DeleteSnapshotRequest request = new DeleteSnapshotRequest(repository, snapshot);
        );
/*
        String testIndex = "test_index";  
            response.getSnapshots().stream().map((s) -> s.snapshotId().getName()).collect(Collectors.toList()),
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryResponse;  
        }
                );
        AcknowledgedResponse putRepositoryResponse = createTestRepository(repository, FsRepository.TYPE, "{\"location\": \".\"}");
            request.userMetadata(randomUserMetadata());
        Map<String, Object> originalMetadata = randomUserMetadata();  
        assertTrue(createTestRepository("other", FsRepository.TYPE, "{\"location\": \".\"}").isAcknowledged());
        } else {  
        assertThat(response.getSnapshots().get(0).getIndices().containsKey(testIndex), is(true));  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        } else {
    }
    }  
 * ownership. Elasticsearch licenses this file to you under  
        AcknowledgedResponse deleteResponse = execute(
    }  
        createIndex(
        CreateSnapshotResponse createSnapshotResponse = createTestSnapshot(createSnapshotRequest);  
            assertNull("retrieved metadata is null, expected non-null metadata", originalMetadata);
import java.util.Optional;  
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
        if (randomBoolean()) {  
            .stream()  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequest;
        request.partial(randomBoolean());
        }
        return execute(request, highLevelClient().snapshot()::createRepository, highLevelClient().snapshot()::createRepositoryAsync);
        createSnapshotRequest.waitForCompletion(true);
        RestoreSnapshotResponse response = execute(
import java.util.Map;
        assertThat(2, equalTo(response.repositories().size()));
        if (returnedMetadata.isPresent()) {
        assertTrue("index [" + testIndex + "] should have been created", indexExists(testIndex));
        String repository = "test_repository";
            .filter(s -> s.snapshotId().getName().equals("test_snapshot2"))
            );  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            () -> execute(request, highLevelClient().snapshot()::getRepository, highLevelClient().snapshot()::getRepositoryAsync)  
            request,
        String testSnapshot = "snapshot_1";
        assertTrue(createTestRepository("test", FsRepository.TYPE, "{\"location\": \".\"}").isAcknowledged());  
        assertTrue(putRepositoryResponse.isAcknowledged());  
        assertEquals(RestStatus.OK, createSnapshotResponse.status());
import java.util.HashMap;
    public void testCreateRepository() throws IOException {
        createSnapshotRequest.indices(testIndex);
            AcknowledgedResponse deleteResponse = execute(
        request.settings(settings, MediaTypeRegistry.JSON);  
        assertTrue(putRepositoryResponse.isAcknowledged());
        assertEquals(RestStatus.OK, createSnapshotResponse.status());
        createIndex(testIndex, Settings.EMPTY);
    }  
    public void testGetSnapshots() throws IOException {
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest;  
        }  
        createSnapshotRequest.waitForCompletion(true);
    private AcknowledgedResponse createTestRepository(String repository, String type, String settings) throws IOException {
        String repository = "test_repository";
import org.opensearch.action.admin.cluster.snapshots.clone.CloneSnapshotRequest;
        request.repositories(new String[] { testRepository });
        assertThat(
    }  
        AcknowledgedResponse putRepositoryResponse = createTestRepository(testRepository, FsRepository.TYPE, "{\"location\": \".\"}");
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 3))
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;  
        RestoreInfo restoreInfo = response.getRestoreInfo();
            assertEquals(originalMetadata, returnedMetadata.get());
        }
            createSnapshotRequest.userMetadata(randomUserMetadata());
        request.waitForCompletion(true);
    }
import static org.hamcrest.Matchers.greaterThan;
        assertThat(response.result().bytes(), equalTo(0L));
        AcknowledgedResponse putRepositoryResponse = createTestRepository("test", FsRepository.TYPE, "{\"location\": \".\"}");  
        assertEquals(waitForCompletion ? RestStatus.OK : RestStatus.ACCEPTED, response.status());
                long nestedFields = randomLongBetween(0, 4);
                .build()
        GetRepositoriesRequest request = new GetRepositoriesRequest();
        request.renamePattern(testIndex);
            highLevelClient().snapshot()::getRepository,
        String targetSnapshot = "target_snapshot";
            highLevelClient().snapshot()::deleteRepositoryAsync
            createSnapshotRequest.userMetadata(randomUserMetadata());
        String repository = "doesnotexist";
        GetRepositoriesRequest request = new GetRepositoriesRequest();  
        String testRepository = "test";
        assertThat(1, equalTo(response.repositories().size()));
            // If we don't wait for the snapshot to complete we have to cancel it to not leak the snapshot task
        assertEquals(2, response.getSnapshots().size());  
import org.opensearch.common.settings.Settings;
 * Unless required by applicable law or agreed to in writing,
            request,  
        String testIndex = "test_index";
        );
 */  
        createSnapshotRequest.waitForCompletion(true);
        String snapshot1 = "test_snapshot1";
            highLevelClient().snapshot()::restore,
            highLevelClient().snapshot()::cleanupRepository,
    }  
        GetRepositoriesResponse response = execute(  
        CleanupRepositoryResponse response = execute(
        request.repository(testRepository);
            contains("test_snapshot1", "test_snapshot2")  
        if (randomBoolean()) {
        assertTrue(response.isAcknowledged());
        AcknowledgedResponse response = execute(request, highLevelClient().snapshot()::delete, highLevelClient().snapshot()::deleteAsync);
        assertTrue(createTestRepository(repository, FsRepository.TYPE, "{\"location\": \".\"}").isAcknowledged());
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryRequest;
        assertTrue(putRepositoryResponse.isAcknowledged());
 */
        if (waitForCompletion == false) {  
        assertThat(exception.status(), equalTo(RestStatus.NOT_FOUND));  
        assertTrue(createTestRepository(testRepository, FsRepository.TYPE, "{\"location\": \".\"}").isAcknowledged());  
        deleteIndex(testIndex);  
        CloneSnapshotRequest request = new CloneSnapshotRequest(repository, snapshot, targetSnapshot, new String[] { testIndex });
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
        assertThat(restoreInfo.name(), equalTo(testSnapshot));  
        CreateSnapshotRequest createSnapshotRequest = new CreateSnapshotRequest(repository, snapshot);
            exception.getMessage(),
        return execute(createSnapshotRequest, highLevelClient().snapshot()::create, highLevelClient().snapshot()::createAsync);
            highLevelClient().snapshot()::getRepository,
 * Licensed to Elasticsearch under one or more contributor  
            highLevelClient().snapshot()::getRepository,
            .map(SnapshotInfo::userMetadata);  
    public void testRestoreSnapshot() throws IOException {  
        assertTrue(createTestRepository(repository, FsRepository.TYPE, "{\"location\": \".\"}").isAcknowledged());  
        );  
            equalTo("OpenSearch exception [type=repository_missing_exception, reason=[" + repository + "] missing]")  
        String snapshot = "test_snapshot";
                }
        createSnapshotRequest.indices("*");
        Optional<Map<String, Object>> returnedMetadata = response.getSnapshots()
import org.opensearch.core.rest.RestStatus;
        AcknowledgedResponse putRepositoryResponse = createTestRepository("test", FsRepository.TYPE, "{\"location\": \".\"}");
        assertThat(response.getSnapshots().size(), equalTo(1));  
 *
            highLevelClient().snapshot()::statusAsync
        assertEquals(RestStatus.OK, putSnapshotResponse1.status());
import org.opensearch.cluster.metadata.IndexMetadata;  
    public void testSnapshotHidden() throws IOException {  
        CreateSnapshotResponse putSnapshotResponse1 = createTestSnapshot(createSnapshotRequest1);  
        CreateSnapshotRequest createSnapshotRequest = new CreateSnapshotRequest(testRepository, testSnapshot);  
            highLevelClient().snapshot()::restoreAsync
import org.opensearch.snapshots.SnapshotInfo;  
        createSnapshotRequest.waitForCompletion(true);
                new DeleteSnapshotRequest(repository, snapshot),  
