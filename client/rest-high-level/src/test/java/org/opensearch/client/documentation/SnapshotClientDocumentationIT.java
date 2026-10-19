        request.indexSettings(  // <1>
import static org.hamcrest.Matchers.equalTo;
    }
        {
    }
        request.timeout(TimeValue.timeValueMinutes(1)); // <1>
 * The OpenSearch Contributors require contributions made to
        // end::get-repository-request
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
        assertEquals(200, response.getStatusLine().getStatusCode());
                    }
        // end::create-repository-request-repository-settings
            listener = new LatchedActionListener<>(listener, latch);
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
                public void onResponse(GetRepositoriesResponse getRepositoriesResponse) {
    }
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
    public void testSnapshotSnapshotsStatus() throws IOException {
            // end::restore-snapshot-execute-listener
        GetRepositoriesResponse response = client.snapshot().getRepository(request, RequestOptions.DEFAULT);
        // end::restore-snapshot-request-index-settings
            final CountDownLatch latch = new CountDownLatch(1);
        }
        List<SnapshotInfo> snapshotsInfos = response.getSnapshots();
                    public void onFailure(Exception e) {
/*
        request.type(FsRepository.TYPE); // <1>
                        // <1>
        AcknowledgedResponse response = client.snapshot().createRepository(request, RequestOptions.DEFAULT);
        // end::create-snapshot-response-snapshot-info
            // Replace the empty listener by a blocking listener in test
        request.timeout(TimeValue.timeValueMinutes(1)); // <1>
        // tag::create-snapshot-request-waitForCompletion
        RestHighLevelClient client = highLevelClient();
 * --------------------------------------------------
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
import org.opensearch.snapshots.SnapshotState;
        // end::restore-snapshot-request-partial
        request.ignoreUnavailable(false); // <1>
                new ActionListener<RestoreSnapshotResponse>() {
        createTestIndex();
                    public void onFailure(Exception e) {
 * (the code indentation of the tag is not included in the width)
        GetRepositoriesRequest request = new GetRepositoriesRequest();
        request.clusterManagerNodeTimeout("1m"); // <2>
        assertThat(snapshotStatusesResponse.size(), equalTo(1));
        // end::verify-repository-response
                    public void onFailure(Exception e) {
        createTestSnapshots();
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        // tag::restore-snapshot-request-index-settings
        SnapshotsStatusRequest request = new SnapshotsStatusRequest();
        request.indicesOptions(IndicesOptions.fromOptions(false, false, true, true)); // <1>
 * This class is used to generate the Java Snapshot API documentation.
        // tag::restore-snapshot-response
                    @Override
                    public void onFailure(Exception e) {
        // end::delete-repository-request
        // tag::create-snapshot-response-snapshot-info
                    }
    }
        // end::create-snapshot-request-includeGlobalState
            client.snapshot().getRepositoryAsync(request, RequestOptions.DEFAULT, listener); // <1>
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
package org.opensearch.client.documentation;
import org.opensearch.client.RestHighLevelClient;
        SnapshotsInProgress.State snapshotState = snapshotStatus.getState(); // <2>
        // end::create-snapshot-request-masterTimeout
    public void testSnapshotCreateRepository() throws IOException {
                @Override
        // tag::delete-snapshot-execute
        {
        request.timeout(TimeValue.timeValueMinutes(1)); // <1>
        request.includeAliases(false); // <1>
        assertEquals(Collections.singletonList(restoredIndexName), indices);
        {
        // end::create-repository-request-type
                new ActionListener<SnapshotsStatusResponse>() {
        // end::get-snapshots-request-repositoryName
            listener = new LatchedActionListener<>(listener, latch);
                };
                    @Override
    public void testSnapshotVerifyRepositoryAsync() throws InterruptedException {
            listener = new LatchedActionListener<>(listener, latch);
        // tag::create-repository-response
            // Replace the empty listener by a blocking listener in test
            // end::get-snapshots-execute-async
                    }
        // end::restore-snapshot-request-indices
    }
    }
        SnapshotInfo snapshotInfo = snapshotsInfos.get(0);
        // tag::create-snapshot-response
            GetRepositoriesRequest request = new GetRepositoriesRequest();
        RestHighLevelClient client = highLevelClient();
        RestHighLevelClient client = highLevelClient();
    }
        createTestRepositories();
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
        request.indices("test-index0", "test-index1"); // <1>
                new ActionListener<CreateSnapshotResponse>() {
 * // tag::example
 * not use this file except in compliance with the License.
    public void testSnapshotGetSnapshotsAsync() throws InterruptedException {
 * SPDX-License-Identifier: Apache-2.0
            // end::verify-repository-execute-listener
            // end::delete-repository-execute-listener
            final CountDownLatch latch = new CountDownLatch(1);
        request.snapshots(snapshotName);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;
 *    http://www.apache.org/licenses/LICENSE-2.0
        request.includeGlobalState(true); // <1>
        // end::create-repository-request-masterTimeout
import org.opensearch.common.settings.Settings;
import org.opensearch.core.xcontent.MediaTypeRegistry;
            // end::snapshots-status-execute-listener
            // tag::snapshots-status-execute-async
        // tag::create-snapshot-request-partial
        // tag::restore-snapshot-request-indices
                    // <1>
import org.opensearch.client.OpenSearchRestHighLevelClientTestCase;
        // tag::snapshots-status-request-snapshots
import org.opensearch.client.indices.CreateIndexRequest;
        // end::create-repository-request-name
    }
            .put("index.number_of_replicas", 0)
 * software distributed under the License is distributed on an
        // end::create-repository-request-timeout
        AcknowledgedResponse response = client.snapshot().deleteRepository(request, RequestOptions.DEFAULT);
            // tag::delete-repository-execute-listener
                public void onFailure(Exception e) {
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
        // tag::create-repository-request-name
        // end::restore-snapshot-execute
        // end::create-repository-request
        createTestRepositories();
        // we need to restore as a different index name
                .put(compressKey, compressValue);
                        // <2>
            Settings.builder()
        request.repository(repositoryName); // <1>
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
                    // <2>
            listener = new LatchedActionListener<>(listener, latch);
        // tag::verify-repository-request-timeout
        CreateSnapshotResponse response = client.snapshot().create(request, RequestOptions.DEFAULT);
        assertTrue(highLevelClient().snapshot().createRepository(request, RequestOptions.DEFAULT).isAcknowledged());
            // Replace the empty listener by a blocking listener in test
        // end::get-repository-request-local
import java.util.EnumSet;
        // tag::restore-snapshot-request-include-global-state
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
        // tag::create-snapshot-request-repositoryName
        request.partial(false); // <1>
            map.put(locationKey, locationValue);
                    }
                    public void onResponse(AcknowledgedResponse deleteRepositoryResponse) {
        DeleteSnapshotRequest request = new DeleteSnapshotRequest(repositoryName);
 * KIND, either express or implied.  See the License for the
        // tag::snapshots-status-request
        boolean compressValue = true;
            // tag::delete-repository-execute-async
import org.opensearch.snapshots.SnapshotId;
    public void testSnapshotDeleteRepositoryAsync() throws InterruptedException {
 */
                    }
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            client.snapshot().createRepositoryAsync(request, RequestOptions.DEFAULT, listener); // <1>
    }
        assertEquals(RestStatus.OK, status);
        // tag::delete-repository-execute
                }
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
            client.snapshot().deleteAsync(request, RequestOptions.DEFAULT, listener); // <1>
                    public void onResponse(VerifyRepositoryResponse verifyRepositoryRestResponse) {
                    @Override
            // end::verify-repository-execute-async
import org.opensearch.action.support.IndicesOptions;
            ActionListener<RestoreSnapshotResponse> listener =
            listener = new LatchedActionListener<>(listener, latch);
                new ActionListener<VerifyRepositoryResponse>() {
import java.util.Collections;
        request.clusterManagerNodeTimeout("1m"); // <2>
                    public void onResponse(RestoreSnapshotResponse restoreSnapshotResponse) {
        boolean acknowledged = response.isAcknowledged(); // <1>
 */
                };
        RestHighLevelClient client = highLevelClient();
        RestHighLevelClient client = highLevelClient();
                new ActionListener<AcknowledgedResponse>() {
    private static final String repositoryName = "test_repository";
    }
 */
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
                        // <1>
/**
        }
        request.timeout("1m"); // <2>
                    @Override
        // end::get-repository-request-masterTimeout
            // Replace the empty listener by a blocking listener in test
        // tag::get-snapshots-request-masterTimeout
 * ownership. Elasticsearch licenses this file to you under
            // Replace the empty listener by a blocking listener in test
            final CountDownLatch latch = new CountDownLatch(1);
            // tag::create-repository-execute-async
    }
        RestHighLevelClient client = highLevelClient();
        assertThat(snapshotStatusesResponse.get(0).getSnapshot().getRepository(), equalTo(SnapshotClientDocumentationIT.repositoryName));
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
            // tag::create-repository-settings-map
            // Replace the empty listener by a blocking listener in test
        }
        // end::snapshots-status-request
        // end::restore-snapshot-request-waitForCompletion
    public void testSnapshotCreateRepositoryAsync() throws InterruptedException {
            // end::create-repository-settings-map
                        // <1>
    protected boolean waitForAllSnapshotsWiped() {
        // tag::get-repository-request-masterTimeout
import org.opensearch.action.LatchedActionListener;
            PutRepositoryRequest request = new PutRepositoryRequest(repositoryName);
        createSnapshot.setJsonEntity("{\"indices\":\"" + indexName + "\"}");
        createTestRepositories();
            listener = new LatchedActionListener<>(listener, latch);
 * license agreements. See the NOTICE file distributed with
        request.clusterManagerNodeTimeout("1m"); // <2>
                    @Override
            listener = new LatchedActionListener<>(listener, latch);
        assertThat(snapshotState.completed(), equalTo(true));
        RestHighLevelClient client = highLevelClient();
        assertTrue(acknowledged);
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        // tag::snapshots-status-request-masterTimeout
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
        // tag::create-snapshot-request-indices
        assertTrue(acknowledged);
        request.ignoreIndexSettings("index.refresh_interval", "index.search.idle.after"); // <2>
        PutRepositoryRequest request = new PutRepositoryRequest(repositoryName);
        String [] repositories = new String[] {repositoryName};
                        // <2>
        request.clusterManagerNodeTimeout("1m"); // <2>
        SnapshotsStatusResponse response = client.snapshot().status(request, RequestOptions.DEFAULT);
        // end::get-snapshots-response
        createTestSnapshots();
        client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
            // end::snapshots-status-execute-async
    }
    private void createTestSnapshots() throws IOException {
        request.renamePattern("test_(.+)"); // <1>
        String[] snapshots = { snapshotName };
                        // <1>
        // end::delete-repository-response
import org.opensearch.client.RequestOptions;
        {
                    @Override
 * this file be licensed under the Apache-2.0 license or a
        }
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
                @Override
        // end::get-repository-execute
                    @Override
        {
        createTestIndex();
 * --------------------------------------------------
}
    }
        List<String> indices = restoreInfo.indices(); // <1>
        // tag::delete-snapshot-request-masterTimeout
        RestHighLevelClient client = highLevelClient();
        // end::restore-snapshot-request-include-aliases
        }
import org.opensearch.snapshots.RestoreInfo;
        createSnapshot.addParameter("wait_for_completion", "true");
            // end::create-repository-execute-listener
                    @Override
                    }
import java.io.IOException;
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            // tag::create-snapshot-execute-async
        assertEquals(1, snapshotsInfos.size());
                    public void onResponse(CreateSnapshotResponse createSnapshotResponse) {
        RestStatus restStatus = snapshotInfo.status(); // <1>
        request.waitForCompletion(true); // <1>
        // tag::get-repository-request-repositories
        {
            // Replace the empty listener by a blocking listener in test
                        // <2>
                }
        request.clusterManagerNodeTimeout("1m"); // <2>
import org.opensearch.client.Response;
        {
            // tag::get-snapshots-execute-listener
        // tag::get-snapshots-execute
        // tag::create-snapshot-request-indicesOptions
        // tag::snapshots-status-response
        // tag::snapshots-status-execute
        assertThat(1, equalTo(repositoryMetadataResponse.size()));
        // end::create-repository-create-settings
        // end::snapshots-status-request-snapshots
        // tag::delete-repository-response
        long startTime = snapshotInfo.startTime(); // <5>
                    }
    public void testSnapshotSnapshotsStatusAsync() throws InterruptedException {
        request.clusterManagerNodeTimeout("1m"); // <2>
        GetSnapshotsResponse response = client.snapshot().get(request, RequestOptions.DEFAULT);
        // end::snapshots-status-request-masterTimeout
 * <p>
        final boolean async = Booleans.parseBoolean(System.getProperty("tests.rest.async", "false"));
            .put(compressKey, compressValue)
            // tag::restore-snapshot-execute-listener
            VerifyRepositoryRequest request = new VerifyRepositoryRequest(repositoryName);
        {
        // end::snapshots-status-execute
                    @Override
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStats;
                        // <1>
 * include-tagged::{doc-tests}/SnapshotClientDocumentationIT.java[example]
            DeleteRepositoryRequest request = new DeleteRepositoryRequest();
import java.util.concurrent.CountDownLatch;
        // tag::create-snapshot-request-snapshotName
        {
        // tag::get-snapshots-request-snapshots
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.core.action.ActionListener;
        assertThat(repositoryName, equalTo(repositoryMetadataResponse.get(0).name()));
            // tag::get-repository-execute-async
        {
                    }
                    @Override
        request.indices("test_index"); // <1>
        // tag::restore-snapshot-request-include-aliases
        Request createSnapshot = new Request("put", String.format(Locale.ROOT, "/_snapshot/%s/%s", repositoryName, snapshotName));
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
    }
        request.clusterManagerNodeTimeout("1m"); // <2>
            listener = new LatchedActionListener<>(listener, latch);
                    }
            // end::delete-repository-execute-async
            final CountDownLatch latch = new CountDownLatch(1);
        // end::verify-repository-execute
import java.util.List;
        // end::create-snapshot-request-partial
                };
            request.settings(map); // <1>
 * ["source","java",subs="attributes,callouts,macros"]
        boolean acknowledged = response.isAcknowledged(); // <1>
                };
    public void testSnapshotGetRepositoryAsync() throws InterruptedException {
            Settings.Builder settingsBuilder = Settings.builder()
                    }
        GetSnapshotsRequest request = new GetSnapshotsRequest();
        RestHighLevelClient client = highLevelClient();
            ActionListener<AcknowledgedResponse> listener =
        // end::get-snapshots-request-masterTimeout
        List<SnapshotStatus> snapshotStatusesResponse = response.getSnapshots();
        }
        }
        Response response = highLevelClient().getLowLevelClient().performRequest(createSnapshot);
                    }
                        // <1>
 * under the License.
        // tag::get-repository-execute
    private void createTestRepositories() throws IOException {
    public void testSnapshotCreate() throws IOException {
                    @Override
        // end::delete-snapshot-request
        List<VerifyRepositoryResponse.NodeView> repositoryMetadataResponse = response.getNodes();
        // end::snapshots-status-response
        // end::get-snapshots-request-snapshots
        // tag::delete-repository-request-masterTimeout
 * <p>
 * than 84, the line will be cut and a horizontal scroll bar will be displayed.
        // end::create-snapshot-request
import org.opensearch.common.Booleans;
        SnapshotId snapshotId = snapshotInfo.snapshotId(); // <2>
        // end::verify-repository-request-timeout
 *
    private void createTestIndex() throws IOException {
            .put(locationKey, locationValue)
                    @Override
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
            client.snapshot().deleteRepositoryAsync(request, RequestOptions.DEFAULT, listener); // <1>
        RestoreSnapshotRequest request = new RestoreSnapshotRequest(repositoryName, snapshotName);
        RestoreInfo restoreInfo = response.getRestoreInfo();
            CreateSnapshotRequest request = new CreateSnapshotRequest(repositoryName, snapshotName);
        // tag::restore-snapshot-request-rename
                    }
        request.snapshot(snapshotName); // <1>
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequest;
        if (async) {
    }
        request.snapshots(snapshots); // <1>
            // Replace the empty listener with a blocking listener in test
            GetSnapshotsRequest request = new GetSnapshotsRequest(repositoryName);
        VerifyRepositoryRequest request = new VerifyRepositoryRequest(repositoryName);
        request.snapshots(snapshots); // <1>
            // tag::restore-snapshot-execute-async
        // tag::create-repository-execute
    public void testSnapshotDeleteRepository() throws IOException {
        // tag::get-snapshots-request-ignore-unavailable
        SnapshotStatus snapshotStatus = snapshotStatusesResponse.get(0); // <1>
        }
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus;
        String locationValue = ".";
            final CountDownLatch latch = new CountDownLatch(1);
/*
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequest;
            ActionListener<VerifyRepositoryResponse> listener =
    }
            Map<String, Object> map = new HashMap<>();
            // end::delete-snapshot-execute-listener
        // end::get-snapshots-request
        // tag::snapshots-status-request-repository
        DeleteRepositoryRequest request = new DeleteRepositoryRequest(repositoryName);
                .build());
        createTestRepositories();
            // tag::create-repository-settings-builder
        // tag::create-snapshot-request-includeGlobalState
        {
        assertTrue(restoreInfo.successfulShards() > 0);
        RestoreSnapshotResponse response = client.snapshot().restore(request, RequestOptions.DEFAULT);
        createTestRepositories();
 * specific language governing permissions and limitations
        // end::snapshots-status-request-repository
            ActionListener<CreateSnapshotResponse> listener =
        // tag::restore-snapshot-request-partial
        // end::create-snapshot-execute
        request.timeout("1m"); // <2>
            // end::create-snapshot-execute-listener
            // tag::delete-snapshot-execute-listener
 * Licensed to Elasticsearch under one or more contributor
        // tag::delete-snapshot-response
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
                    public void onFailure(Exception e) {
        RestHighLevelClient client = highLevelClient();
        }
        return true;
        // end::delete-repository-execute
        request.renameReplacement("restored_$1"); // <2>
        // end::restore-snapshot-request-masterTimeout
                    @Override
        // tag::delete-snapshot-request
            DeleteSnapshotRequest request = new DeleteSnapshotRequest();
        assertThat(1, equalTo(repositoryMetadataResponse.size()));
    public void testSnapshotDeleteSnapshot() throws IOException {
import java.util.Locale;
        // tag::create-repository-request
        // end::create-repository-request-verify
            client.snapshot().statusAsync(request, RequestOptions.DEFAULT, listener); // <1>
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        RestHighLevelClient client = highLevelClient();
        List<SnapshotShardFailure> snapshotShardFailures = snapshotInfo.shardFailures(); // <4>
        // end::get-repository-response
        {
                    }
public class SnapshotClientDocumentationIT extends OpenSearchRestHighLevelClientTestCase {
                    public void onFailure(Exception e) {
        AcknowledgedResponse response = client.snapshot().delete(request, RequestOptions.DEFAULT);
 * // end::example
        // tag::get-repository-response
 * Modifications Copyright OpenSearch Contributors. See
        // end::restore-snapshot-request-rename
        // check that the request went ok without parsing JSON here. When using the high level client, check acknowledgement instead.
                        // <2>
            request.settings("{\"location\": \".\", \"compress\": \"true\"}",
        // tag::create-repository-request-timeout
                new ActionListener<AcknowledgedResponse>() {
    }
            // end::get-snapshots-execute-listener
        request.settings(settings); // <1>
                MediaTypeRegistry.JSON); // <1>
    }
        // tag::delete-repository-request
        // end::delete-snapshot-response
        // tag::restore-snapshot-execute
        // end::create-repository-execute
                .put(locationKey, locationValue)
import java.util.Map;
            // end::delete-snapshot-execute-async
        // end::get-snapshots-request-ignore-unavailable
        // tag::get-snapshots-request-repositoryName
        RestHighLevelClient client = highLevelClient();
        request.type(FsRepository.TYPE);
            // end::create-repository-settings-source
        // tag::verify-repository-request
        client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        // end::snapshots-status-request-ignoreUnavailable
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest;
            ActionListener<GetSnapshotsResponse> listener =
        String locationKey = FsRepository.LOCATION_SETTING.getKey();
            // end::create-repository-execute-async
        // end::get-snapshots-request-verbose
                };
            ActionListener<AcknowledgedResponse> listener =
        request.settings("{\"location\": \".\"}", MediaTypeRegistry.JSON);
            EnumSet.of(IndicesOptions.WildcardStates.OPEN)));
            // end::get-repository-execute-async
    private static final String indexName = "test_index";
import org.opensearch.snapshots.SnapshotShardFailure;
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        // tag::delete-repository-request-timeout
                    @Override
            ActionListener<AcknowledgedResponse> listener =
        request.repository(repositoryName); // <1>
    public void testRestoreSnapshotAsync() throws InterruptedException {
    private static final String snapshotName = "test_snapshot";
        request.ignoreUnavailable(true); // <1>
import org.opensearch.cluster.SnapshotsInProgress;
        assertThat(snapshotStatusesResponse.get(0).getSnapshot().getSnapshotId().getName(), equalTo(snapshotName));
        // end::create-snapshot-request-waitForCompletion
import org.opensearch.snapshots.SnapshotInfo;
        request.local(true); // <1>
 * You need to wrap your code between two tags like:
        request.repository(repositoryName); // <1>
        SnapshotStats shardStats = snapshotStatus.getIndices().get(indexName).getShards().get(0).getStats(); // <3>
            // tag::snapshots-status-execute-listener
        // tag::get-repository-request-local
            assertThat("asyncIntegTest-0", equalTo(repositoryMetadataResponse.get(0).getName()));
        RestHighLevelClient client = highLevelClient();
                };
        RestHighLevelClient client = highLevelClient();
        request.name(repositoryName); // <1>
        request.waitForCompletion(true); // <1>
            EnumSet.of(IndicesOptions.Option.IGNORE_UNAVAILABLE),
            ActionListener<SnapshotsStatusResponse> listener =
        createTestIndex();
        createIndexRequest = new CreateIndexRequest("test-index1");
        boolean acknowledged = response.isAcknowledged(); // <1>
        // end::restore-snapshot-request
        // end::restore-snapshot-request-include-global-state
                    @Override
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
            };
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
    }
        }
    }
        // end::create-snapshot-request-indices
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
import java.util.HashMap;
        String compressKey = FsRepository.COMPRESS_SETTING.getKey();
            request.settings(settingsBuilder); // <1>
        // tag::restore-snapshot-request-masterTimeout
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
    public void testRestoreSnapshot() throws IOException {
        request.clusterManagerNodeTimeout("1m"); // <2>
                        // <1>
            assertThat("integTest-0", equalTo(repositoryMetadataResponse.get(0).getName()));
            client.snapshot().getAsync(request, RequestOptions.DEFAULT, listener); // <1>
        }
            final CountDownLatch latch = new CountDownLatch(1);
 *
        // end::delete-snapshot-request-masterTimeout
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        RestHighLevelClient client = highLevelClient();
        RestHighLevelClient client = highLevelClient();
        createTestSnapshots();
    }
        // tag::create-snapshot-request
            // end::get-repository-execute-listener
        // tag::verify-repository-response
import org.opensearch.cluster.metadata.RepositoryMetadata;
            client.snapshot().createAsync(request, RequestOptions.DEFAULT, listener); // <1>
        SnapshotInfo snapshotInfo = response.getSnapshotInfo(); // <1>
    @SuppressWarnings("unused")
        long endTime = snapshotInfo.endTime(); // <6>
        List<RepositoryMetadata> repositoryMetadataResponse = response.repositories();
 * Then in the documentation, you can extract what is between tag and end tags with
    public void testSnapshotVerifyRepository() throws IOException {
import org.opensearch.common.unit.TimeValue;
        // tag::get-snapshots-response
 */
 * The column width of the code block is 84. If the code contains a line longer
        createIndex(indexName, Settings.EMPTY);
        // tag::get-snapshots-request-verbose
        PutRepositoryRequest request = new PutRepositoryRequest();
        // tag::verify-repository-execute
            // tag::create-repository-settings-source
        RestHighLevelClient client = highLevelClient();
        createTestRepositories();
        request.verbose(true); // <1>
            client.snapshot().restoreAsync(request, RequestOptions.DEFAULT, listener); // <1>
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryResponse;
        // tag::restore-snapshot-request-waitForCompletion
        createTestIndex();
                new ActionListener<AcknowledgedResponse>() {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("test-index0");
            // tag::get-repository-execute-listener
                };
        // tag::get-repository-request
            // end::create-repository-settings-builder
    public void testSnapshotDeleteSnapshotAsync() throws InterruptedException {
        VerifyRepositoryResponse response = client.snapshot().verifyRepository(request, RequestOptions.DEFAULT);
            // Replace the empty listener by a blocking listener in test
        request.timeout("1m"); // <2>
        // end::create-snapshot-request-repositoryName
        // end::create-snapshot-response
                    @Override
        // tag::restore-snapshot-request
 * compatible open source license.
        request.repositories(repositories); // <1>
 * this work for additional information regarding copyright
                        // <2>
        request.verify(true); // <1>
            map.put(compressKey, compressValue);
        SnapshotState snapshotState = snapshotInfo.state(); // <3>
import org.opensearch.client.Request;
 * Where example is your tag name.
    @Override
import org.opensearch.core.rest.RestStatus;
        request.partial(false); // <1>
    public void testSnapshotGetSnapshots() throws IOException {
                    public void onResponse(GetSnapshotsResponse getSnapshotsResponse) {
            final CountDownLatch latch = new CountDownLatch(1);
    public void testSnapshotGetRepository() throws IOException {
        // tag::create-snapshot-execute
                        // <1>
            // tag::verify-repository-execute-listener
        } else {
            ActionListener<GetRepositoriesResponse> listener =
        // end::verify-repository-request-masterTimeout
        // end::verify-repository-request
        }
        request.includeGlobalState(false); // <1>
        // tag::create-repository-create-settings
        Settings settings = Settings.builder()
        createTestSnapshots();
        // end::create-snapshot-request-indicesOptions
        // end::delete-repository-request-masterTimeout
                        // <2>
            .build(); // <1>
import java.util.concurrent.TimeUnit;
            RestoreSnapshotRequest request = new RestoreSnapshotRequest();
        // tag::create-snapshot-request-masterTimeout
        // tag::create-repository-request-verify
                    new ActionListener<GetRepositoriesResponse>() {
        request.clusterManagerNodeTimeout("1m"); // <2>
                };
        assertEquals(0, restoreInfo.failedShards());
        RestHighLevelClient client = highLevelClient();
        // end::delete-snapshot-execute
            // tag::delete-snapshot-execute-async
            // tag::create-repository-execute-listener
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
        }
            client.snapshot().verifyRepositoryAsync(request, RequestOptions.DEFAULT, listener); // <1>
        RestStatus status = response.status(); // <1>
            final CountDownLatch latch = new CountDownLatch(1);
                    public void onFailure(Exception e) {
 *
        assertTrue(acknowledged);
import org.opensearch.repositories.fs.FsRepository;
        // tag::get-snapshots-request
        // tag::snapshots-status-request-ignoreUnavailable
        createTestRepositories();
        createTestRepositories();
 * You may obtain a copy of the License at
        // tag::create-repository-request-masterTimeout
                    public void onResponse(AcknowledgedResponse deleteSnapshotResponse) {
        String [] snapshots = new String[] {snapshotName};
            SnapshotsStatusRequest request = new SnapshotsStatusRequest();
            listener = new LatchedActionListener<>(listener, latch);
        // end::get-repository-request-repositories
                new ActionListener<GetSnapshotsResponse>() {
        // end::create-repository-response
                    }
/*
            final CountDownLatch latch = new CountDownLatch(1);
        // end::restore-snapshot-response
        assertNotNull(snapshotInfo);
        // end::create-snapshot-request-snapshotName
                        // <2>
                    public void onFailure(Exception exception) {
                        // <2>
                    }
                    }
        String restoredIndexName = "restored_index";
        // end::get-snapshots-execute
    public void testSnapshotCreateAsync() throws InterruptedException {
        // end::delete-repository-request-timeout
                    public void onResponse(SnapshotsStatusResponse snapshotsStatusResponse) {
 * <p>
        // tag::create-repository-request-type
            // tag::create-snapshot-execute-listener
        // tag::verify-repository-request-masterTimeout
            // end::restore-snapshot-execute-async
                    public void onResponse(AcknowledgedResponse putRepositoryResponse) {
            // tag::verify-repository-execute-async
            // end::create-snapshot-execute-async
        request.indicesOptions(new IndicesOptions( // <3>
            // tag::get-snapshots-execute-async
        CreateSnapshotRequest request = new CreateSnapshotRequest();
        // tag::create-repository-request-repository-settings
