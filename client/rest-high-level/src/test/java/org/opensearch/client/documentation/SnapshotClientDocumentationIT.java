    }
    }  
        Request createSnapshot = new Request("put", String.format(Locale.ROOT, "/_snapshot/%s/%s", repositoryName, snapshotName));
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
import java.util.List;
                    }
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>  
            RestoreSnapshotRequest request = new RestoreSnapshotRequest();
        RestoreInfo restoreInfo = response.getRestoreInfo();
        // tag::get-repository-request  
        assertThat(snapshotState.completed(), equalTo(true));  
            final CountDownLatch latch = new CountDownLatch(1);  
        // tag::get-snapshots-request-ignore-unavailable
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>  
        // tag::restore-snapshot-request-waitForCompletion
        // tag::restore-snapshot-request-index-settings  
    public void testSnapshotGetRepository() throws IOException {
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryRequest;  
        String[] snapshots = { snapshotName };
        // end::verify-repository-request-masterTimeout
    public void testSnapshotCreateAsync() throws InterruptedException {  
        // tag::create-snapshot-execute
 */  
        // tag::restore-snapshot-request  
                    public void onFailure(Exception exception) {
        // end::create-snapshot-request-masterTimeout
        // tag::restore-snapshot-request-include-global-state  
    public void testSnapshotDeleteRepository() throws IOException {  
                new ActionListener<GetSnapshotsResponse>() {  
        // end::restore-snapshot-execute
            ActionListener<AcknowledgedResponse> listener =
            // end::create-snapshot-execute-async
    public void testSnapshotGetSnapshotsAsync() throws InterruptedException {
    public void testSnapshotCreate() throws IOException {
                public void onFailure(Exception e) {
        // tag::verify-repository-request-timeout  
            final CountDownLatch latch = new CountDownLatch(1);
        {
                        // <1>
            // end::delete-repository-execute-listener
        // tag::delete-snapshot-response
                    public void onResponse(GetSnapshotsResponse getSnapshotsResponse) {
        RestHighLevelClient client = highLevelClient();
        assertTrue(acknowledged);
        List<RepositoryMetadata> repositoryMetadataResponse = response.repositories();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // tag::restore-snapshot-execute  
        request.repository(repositoryName); // <1>  
        // end::delete-repository-response  
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>  
    }
                    @Override  
        // end::restore-snapshot-request-indices
        // tag::verify-repository-response  
 * ["source","java",subs="attributes,callouts,macros"]  
        GetRepositoriesRequest request = new GetRepositoriesRequest();
 * Unless required by applicable law or agreed to in writing,
    }  
 *
        AcknowledgedResponse response = client.snapshot().createRepository(request, RequestOptions.DEFAULT);
        // end::delete-snapshot-request-masterTimeout
        request.includeGlobalState(true); // <1>
        request.indices("test_index"); // <1>  
        request.snapshots(snapshotName);
            assertThat("integTest-0", equalTo(repositoryMetadataResponse.get(0).getName()));
        createIndex(indexName, Settings.EMPTY);  
        // tag::create-snapshot-request-indicesOptions
        // tag::create-repository-create-settings  
        // end::create-snapshot-request-indicesOptions  
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStats;  
        request.clusterManagerNodeTimeout("1m"); // <2>
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;  
            GetRepositoriesRequest request = new GetRepositoriesRequest();  
        // tag::restore-snapshot-request-rename
 * <p>
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;  
import org.opensearch.core.action.ActionListener;
        // end::create-repository-request-masterTimeout
        request.clusterManagerNodeTimeout("1m"); // <2>
                };  
            assertTrue(latch.await(30L, TimeUnit.SECONDS));  
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
        String restoredIndexName = "restored_index";  
                        // <1>
        // tag::create-repository-request-timeout
        {
 * GitHub history for details.
            // tag::create-repository-settings-map
        // end::create-repository-request-name
            assertTrue(latch.await(30L, TimeUnit.SECONDS));  
        // end::create-snapshot-request-partial  
        // end::create-snapshot-execute  
        request.repository(repositoryName); // <1>  
            listener = new LatchedActionListener<>(listener, latch);  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        request.renameReplacement("restored_$1"); // <2>  
            // end::get-snapshots-execute-async
            // Replace the empty listener with a blocking listener in test
        // tag::get-snapshots-request
        request.clusterManagerNodeTimeout("1m"); // <2>
                    }  
        GetRepositoriesResponse response = client.snapshot().getRepository(request, RequestOptions.DEFAULT);
/*  
 * under the License.  
        // tag::get-repository-request-repositories
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus;
            Settings.builder()
        // end::restore-snapshot-response
        createTestRepositories();  
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
                    @Override
            ActionListener<AcknowledgedResponse> listener =
            // end::verify-repository-execute-listener  
    public void testSnapshotGetSnapshots() throws IOException {  
            // end::create-repository-execute-async
        // tag::get-snapshots-response
        PutRepositoryRequest request = new PutRepositoryRequest();  
            request.settings("{\"location\": \".\", \"compress\": \"true\"}",
                        // <1>  
            listener = new LatchedActionListener<>(listener, latch);
 * (the code indentation of the tag is not included in the width)
        // tag::snapshots-status-execute
            // tag::snapshots-status-execute-listener
        }
            DeleteRepositoryRequest request = new DeleteRepositoryRequest();
        SnapshotId snapshotId = snapshotInfo.snapshotId(); // <2>
        CreateSnapshotResponse response = client.snapshot().create(request, RequestOptions.DEFAULT);
        Settings settings = Settings.builder()  
        assertEquals(Collections.singletonList(restoredIndexName), indices);
    }  
        // end::delete-repository-request
        RestHighLevelClient client = highLevelClient();
    private static final String indexName = "test_index";
    public void testSnapshotDeleteRepositoryAsync() throws InterruptedException {
            client.snapshot().deleteAsync(request, RequestOptions.DEFAULT, listener); // <1>  
    }
                new ActionListener<AcknowledgedResponse>() {  
        // tag::verify-repository-request
        // we need to restore as a different index name  
            ActionListener<AcknowledgedResponse> listener =
        // end::create-snapshot-request-repositoryName  
                    public void onResponse(AcknowledgedResponse deleteSnapshotResponse) {
        GetSnapshotsResponse response = client.snapshot().get(request, RequestOptions.DEFAULT);
            final CountDownLatch latch = new CountDownLatch(1);  
        // end::get-snapshots-request-masterTimeout
            // tag::get-snapshots-execute-async
        RestHighLevelClient client = highLevelClient();
        request.clusterManagerNodeTimeout("1m"); // <2>
            map.put(locationKey, locationValue);  
            listener = new LatchedActionListener<>(listener, latch);
        // end::delete-repository-execute
        // end::verify-repository-response
        request.snapshots(snapshots); // <1>
                    }
        request.renamePattern("test_(.+)"); // <1>
        {  
        assertNotNull(snapshotInfo);  
    @Override  
        // tag::get-repository-request-local
        }
            // tag::delete-repository-execute-async
        RestHighLevelClient client = highLevelClient();  
        }
            // end::snapshots-status-execute-async
        assertThat(snapshotStatusesResponse.get(0).getSnapshot().getRepository(), equalTo(SnapshotClientDocumentationIT.repositoryName));
        // tag::get-snapshots-execute  
        // tag::create-snapshot-request-includeGlobalState
        request.verify(true); // <1>
            listener = new LatchedActionListener<>(listener, latch);
        List<VerifyRepositoryResponse.NodeView> repositoryMetadataResponse = response.getNodes();
            // Replace the empty listener by a blocking listener in test
        createIndexRequest = new CreateIndexRequest("test-index1");
        {  
        if (async) {
    }  
            // end::get-snapshots-execute-listener
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.EnumSet;
 */
        // end::create-snapshot-request-waitForCompletion
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        createSnapshot.addParameter("wait_for_completion", "true");
                    @Override
 * specific language governing permissions and limitations
        // end::get-snapshots-response
            ActionListener<CreateSnapshotResponse> listener =  
                new ActionListener<AcknowledgedResponse>() {
        // end::create-snapshot-response
        createTestSnapshots();
    }
            .put(locationKey, locationValue)
            client.snapshot().verifyRepositoryAsync(request, RequestOptions.DEFAULT, listener); // <1>
    }
                    public void onFailure(Exception e) {  
        // end::snapshots-status-request-masterTimeout  
 * include-tagged::{doc-tests}/SnapshotClientDocumentationIT.java[example]
        // end::create-snapshot-request-indices  
 *  
        client.indices().create(createIndexRequest, RequestOptions.DEFAULT);  
        SnapshotsStatusRequest request = new SnapshotsStatusRequest();
        request.clusterManagerNodeTimeout("1m"); // <2>  
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        // tag::create-snapshot-response-snapshot-info
            listener = new LatchedActionListener<>(listener, latch);
            // tag::create-snapshot-execute-async  
/**  
    public void testSnapshotVerifyRepositoryAsync() throws InterruptedException {  
        }  
import org.opensearch.action.support.IndicesOptions;
        createTestRepositories();  
        RestHighLevelClient client = highLevelClient();
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
        // end::verify-repository-request  
            .put("index.number_of_replicas", 0)  
            PutRepositoryRequest request = new PutRepositoryRequest(repositoryName);
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;  
            GetSnapshotsRequest request = new GetSnapshotsRequest(repositoryName);
        request.ignoreIndexSettings("index.refresh_interval", "index.search.idle.after"); // <2>  
        // end::get-repository-request-repositories
        SnapshotInfo snapshotInfo = snapshotsInfos.get(0);  
        request.includeAliases(false); // <1>
            request.settings(map); // <1>
            // tag::restore-snapshot-execute-async
import org.opensearch.snapshots.SnapshotInfo;
import java.util.Map;  
        SnapshotsStatusResponse response = client.snapshot().status(request, RequestOptions.DEFAULT);  
    public void testRestoreSnapshotAsync() throws InterruptedException {
    public void testSnapshotSnapshotsStatusAsync() throws InterruptedException {  
        // tag::delete-repository-execute  
import java.io.IOException;  
        // end::get-snapshots-request-repositoryName
    public void testSnapshotCreateRepository() throws IOException {
                new ActionListener<RestoreSnapshotResponse>() {
import org.opensearch.action.LatchedActionListener;
        // tag::create-repository-request-name  
            // tag::restore-snapshot-execute-listener  
        // end::snapshots-status-request-ignoreUnavailable
                    }  
        // tag::get-repository-response
 * than 84, the line will be cut and a horizontal scroll bar will be displayed.  
        client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        // end::create-snapshot-request
                .build());
        createTestSnapshots();
        // tag::get-snapshots-request-snapshots  
        }  
                    }
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>  
                        // <2>  
        }
        } else {
                    }
            listener = new LatchedActionListener<>(listener, latch);
                        // <1>  
 * Licensed to Elasticsearch under one or more contributor  
                    @Override
        List<SnapshotShardFailure> snapshotShardFailures = snapshotInfo.shardFailures(); // <4>
        // tag::create-snapshot-request-snapshotName
            ActionListener<GetSnapshotsResponse> listener =
    public void testSnapshotSnapshotsStatus() throws IOException {
 * KIND, either express or implied.  See the License for the
            VerifyRepositoryRequest request = new VerifyRepositoryRequest(repositoryName);  
        // end::restore-snapshot-request-masterTimeout
/*  
    private static final String snapshotName = "test_snapshot";  
            Map<String, Object> map = new HashMap<>();
    public void testSnapshotCreateRepositoryAsync() throws InterruptedException {
 * license agreements. See the NOTICE file distributed with
                .put(compressKey, compressValue);
 * --------------------------------------------------
                    }
                        // <2>
                    }  
        // end::restore-snapshot-request-include-aliases  
            DeleteSnapshotRequest request = new DeleteSnapshotRequest();
 * software distributed under the License is distributed on an
        createTestSnapshots();
                    public void onFailure(Exception e) {
    public void testSnapshotVerifyRepository() throws IOException {  
                    @Override
        assertEquals(1, snapshotsInfos.size());
        request.repository(repositoryName); // <1>
    public void testSnapshotGetRepositoryAsync() throws InterruptedException {  
        // end::create-repository-request-verify
                new ActionListener<SnapshotsStatusResponse>() {
        }  
            final CountDownLatch latch = new CountDownLatch(1);  
import org.opensearch.common.Booleans;
        boolean compressValue = true;
        // end::snapshots-status-response
        String locationKey = FsRepository.LOCATION_SETTING.getKey();
            request.settings(settingsBuilder); // <1>  
        // tag::snapshots-status-request-masterTimeout  
        VerifyRepositoryResponse response = client.snapshot().verifyRepository(request, RequestOptions.DEFAULT);  
import java.util.concurrent.TimeUnit;
        request.timeout(TimeValue.timeValueMinutes(1)); // <1>  
            client.snapshot().restoreAsync(request, RequestOptions.DEFAULT, listener); // <1>
                    public void onResponse(SnapshotsStatusResponse snapshotsStatusResponse) {  
        // tag::create-snapshot-request-waitForCompletion  
        // end::create-repository-request-repository-settings
 * You need to wrap your code between two tags like:
                    public void onResponse(AcknowledgedResponse putRepositoryResponse) {
        List<String> indices = restoreInfo.indices(); // <1>  
            // end::create-repository-settings-builder
    }
        RestHighLevelClient client = highLevelClient();
        // end::delete-snapshot-response
                };
        createTestRepositories();
        SnapshotInfo snapshotInfo = response.getSnapshotInfo(); // <1>  
                        // <2>
            // Replace the empty listener by a blocking listener in test
                    public void onFailure(Exception e) {
 * // tag::example  
        // end::create-repository-create-settings
        // tag::create-repository-response
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequest;
            // tag::create-repository-settings-builder
    public void testSnapshotDeleteSnapshot() throws IOException {
                    public void onResponse(CreateSnapshotResponse createSnapshotResponse) {  
            // end::delete-snapshot-execute-async
                public void onResponse(GetRepositoriesResponse getRepositoriesResponse) {  
        // end::create-repository-response
                        // <1>  
                        // <1>
 * Then in the documentation, you can extract what is between tag and end tags with
        request.waitForCompletion(true); // <1>
            client.snapshot().getAsync(request, RequestOptions.DEFAULT, listener); // <1>  
        // tag::delete-repository-request-masterTimeout  
import org.opensearch.cluster.metadata.RepositoryMetadata;
        RestHighLevelClient client = highLevelClient();  
import org.opensearch.common.unit.TimeValue;
        assertTrue(acknowledged);
        {
        // tag::restore-snapshot-request-partial
        request.type(FsRepository.TYPE); // <1>
                        // <2>
        String [] repositories = new String[] {repositoryName};
        createTestSnapshots();
 * compatible open source license.
        SnapshotStatus snapshotStatus = snapshotStatusesResponse.get(0); // <1>
        assertThat(snapshotStatusesResponse.size(), equalTo(1));  
 * You may obtain a copy of the License at  
        // tag::get-repository-execute
            // tag::get-repository-execute-listener
        // tag::create-snapshot-request-indices
public class SnapshotClientDocumentationIT extends OpenSearchRestHighLevelClientTestCase {  
            // tag::create-repository-settings-source  
                    @Override
            SnapshotsStatusRequest request = new SnapshotsStatusRequest();  
        SnapshotsInProgress.State snapshotState = snapshotStatus.getState(); // <2>  
        // end::create-snapshot-request-snapshotName  
        DeleteRepositoryRequest request = new DeleteRepositoryRequest(repositoryName);  
        request.ignoreUnavailable(false); // <1>  
 * this file be licensed under the Apache-2.0 license or a
        // end::snapshots-status-request-repository
        RestHighLevelClient client = highLevelClient();
                        // <1>
            // tag::snapshots-status-execute-async  
        assertTrue(restoreInfo.successfulShards() > 0);
        return true;
        // tag::snapshots-status-request-ignoreUnavailable  
                };
            client.snapshot().createRepositoryAsync(request, RequestOptions.DEFAULT, listener); // <1>  
                    public void onResponse(RestoreSnapshotResponse restoreSnapshotResponse) {
            EnumSet.of(IndicesOptions.Option.IGNORE_UNAVAILABLE),
    }
 *
            ActionListener<GetRepositoriesResponse> listener =  
 * The OpenSearch Contributors require contributions made to  
        // end::delete-repository-request-masterTimeout  
    private static final String repositoryName = "test_repository";
 * The column width of the code block is 84. If the code contains a line longer
        assertThat(1, equalTo(repositoryMetadataResponse.size()));
                };
        RestStatus restStatus = snapshotInfo.status(); // <1>
                new ActionListener<AcknowledgedResponse>() {  
        // end::delete-repository-request-timeout
            CreateSnapshotRequest request = new CreateSnapshotRequest(repositoryName, snapshotName);  
        // tag::snapshots-status-response  
        String compressKey = FsRepository.COMPRESS_SETTING.getKey();  
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>  
        request.settings("{\"location\": \".\"}", MediaTypeRegistry.JSON);
                    @Override  
        // tag::delete-snapshot-request  
            client.snapshot().getRepositoryAsync(request, RequestOptions.DEFAULT, listener); // <1>
        request.timeout(TimeValue.timeValueMinutes(1)); // <1>
        // tag::create-repository-request-repository-settings  
                        // <2>
        assertThat(snapshotStatusesResponse.get(0).getSnapshot().getSnapshotId().getName(), equalTo(snapshotName));
        assertEquals(0, restoreInfo.failedShards());  
        {
            // Replace the empty listener by a blocking listener in test
                    public void onResponse(AcknowledgedResponse deleteRepositoryResponse) {
        AcknowledgedResponse response = client.snapshot().deleteRepository(request, RequestOptions.DEFAULT);
        assertThat(repositoryName, equalTo(repositoryMetadataResponse.get(0).name()));  
    }
        // tag::delete-repository-response
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;  
        // end::create-repository-request-timeout
 * --------------------------------------------------  
    private void createTestSnapshots() throws IOException {  
            // tag::create-repository-execute-async
        // end::create-repository-request
                .put(locationKey, locationValue)
        // end::create-repository-request-type
                    @Override
        request.timeout("1m"); // <2>
        request.timeout("1m"); // <2>
        request.clusterManagerNodeTimeout("1m"); // <2>
        // end::restore-snapshot-request-index-settings
        SnapshotState snapshotState = snapshotInfo.state(); // <3>  
 */
            Settings.Builder settingsBuilder = Settings.builder()  
        request.partial(false); // <1>  
        // tag::create-repository-request-verify  
                    @Override  
        request.settings(settings); // <1>
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>  
                        // <1>
        {
        request.indexSettings(  // <1>
                    @Override  
        // tag::create-snapshot-response
            assertThat("asyncIntegTest-0", equalTo(repositoryMetadataResponse.get(0).getName()));  
import java.util.Locale;
        // tag::restore-snapshot-request-indices
            ActionListener<RestoreSnapshotResponse> listener =
            // tag::create-repository-execute-listener
    public void testSnapshotDeleteSnapshotAsync() throws InterruptedException {
            // Replace the empty listener by a blocking listener in test
}
                    }  
            final CountDownLatch latch = new CountDownLatch(1);
        // end::restore-snapshot-request-rename
                    new ActionListener<GetRepositoriesResponse>() {
        List<SnapshotStatus> snapshotStatusesResponse = response.getSnapshots();
        request.indices("test-index0", "test-index1"); // <1>
/*
import org.opensearch.snapshots.RestoreInfo;  
                    // <1>
        // end::snapshots-status-execute
        // end::get-snapshots-request-ignore-unavailable
                    public void onFailure(Exception e) {  
 * Where example is your tag name.  
    @SuppressWarnings("unused")
import org.opensearch.snapshots.SnapshotState;
        request.local(true); // <1>  
        // tag::delete-snapshot-request-masterTimeout
            final CountDownLatch latch = new CountDownLatch(1);
        request.timeout(TimeValue.timeValueMinutes(1)); // <1>
        GetSnapshotsRequest request = new GetSnapshotsRequest();
 * the Apache License, Version 2.0 (the "License"); you may
            EnumSet.of(IndicesOptions.WildcardStates.OPEN)));  
            // Replace the empty listener by a blocking listener in test
import org.opensearch.common.settings.Settings;  
        {
            client.snapshot().createAsync(request, RequestOptions.DEFAULT, listener); // <1>
            client.snapshot().deleteRepositoryAsync(request, RequestOptions.DEFAULT, listener); // <1>
import org.opensearch.client.indices.CreateIndexRequest;
        request.waitForCompletion(true); // <1>
import org.opensearch.core.rest.RestStatus;  
import java.util.concurrent.CountDownLatch;
        request.timeout("1m"); // <2>  
    }
                };
            // end::restore-snapshot-execute-listener
            // tag::get-snapshots-execute-listener
 * Modifications Copyright OpenSearch Contributors. See
        VerifyRepositoryRequest request = new VerifyRepositoryRequest(repositoryName);
        RestHighLevelClient client = highLevelClient();  
        // tag::get-snapshots-request-masterTimeout
    private void createTestIndex() throws IOException {
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
                    @Override  
        // end::verify-repository-execute
            // tag::create-snapshot-execute-listener
        createTestRepositories();
 */  
    }
        // tag::verify-repository-request-masterTimeout
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
        // tag::snapshots-status-request
        // end::delete-snapshot-request  
        RestHighLevelClient client = highLevelClient();
        {
import org.opensearch.client.Response;  
        // end::restore-snapshot-request
        // tag::snapshots-status-request-snapshots
        // check that the request went ok without parsing JSON here. When using the high level client, check acknowledgement instead.
            // end::create-repository-execute-listener
            // end::create-repository-settings-map  
        boolean acknowledged = response.isAcknowledged(); // <1>  
        // tag::delete-repository-request
        String locationValue = ".";
                        // <2>
        assertTrue(acknowledged);
                };
            // Replace the empty listener by a blocking listener in test  
            final CountDownLatch latch = new CountDownLatch(1);
        }
        // tag::restore-snapshot-response
        RestHighLevelClient client = highLevelClient();  
        request.repositories(repositories); // <1>  
        PutRepositoryRequest request = new PutRepositoryRequest(repositoryName);
        request.indicesOptions(new IndicesOptions( // <3>
        RestHighLevelClient client = highLevelClient();
        SnapshotStats shardStats = snapshotStatus.getIndices().get(indexName).getShards().get(0).getStats(); // <3>
        // tag::restore-snapshot-request-include-aliases
        // tag::get-repository-request-masterTimeout
            map.put(compressKey, compressValue);
                    }
        }
        long endTime = snapshotInfo.endTime(); // <6>  
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryResponse;
        request.ignoreUnavailable(true); // <1>
 * // end::example
        assertTrue(highLevelClient().snapshot().createRepository(request, RequestOptions.DEFAULT).isAcknowledged());
                    @Override
        RestHighLevelClient client = highLevelClient();
        // tag::restore-snapshot-request-masterTimeout
        // end::snapshots-status-request  
    private void createTestRepositories() throws IOException {
        // tag::create-repository-request
        AcknowledgedResponse response = client.snapshot().delete(request, RequestOptions.DEFAULT);
        {
            // tag::delete-repository-execute-listener  
            // tag::verify-repository-execute-async  
        List<SnapshotInfo> snapshotsInfos = response.getSnapshots();
                    public void onFailure(Exception e) {
        // end::restore-snapshot-request-partial
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
 * <p>
import org.opensearch.client.RequestOptions;
        createTestRepositories();
 * <p>
    public void testRestoreSnapshot() throws IOException {
import org.opensearch.snapshots.SnapshotId;
                    @Override
                        // <2>  
        RestHighLevelClient client = highLevelClient();
        RestHighLevelClient client = highLevelClient();  
            listener = new LatchedActionListener<>(listener, latch);  
                };
        createTestIndex();
        createTestRepositories();  
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
                        // <2>  
    }
        }
        CreateSnapshotRequest request = new CreateSnapshotRequest();
        // tag::delete-snapshot-execute
        // end::get-repository-request-local
        }
        // tag::create-repository-request-type  
        DeleteSnapshotRequest request = new DeleteSnapshotRequest(repositoryName);
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("test-index0");
import static org.hamcrest.Matchers.equalTo;
            // end::verify-repository-execute-async
        RestoreSnapshotRequest request = new RestoreSnapshotRequest(repositoryName, snapshotName);
import org.opensearch.cluster.SnapshotsInProgress;  
        // tag::delete-repository-request-timeout
        createTestIndex();
import java.util.HashMap;  
        Response response = highLevelClient().getLowLevelClient().performRequest(createSnapshot);
                    }
        // end::get-snapshots-request-verbose  
        createTestIndex();  
        // tag::create-snapshot-request-repositoryName
        boolean acknowledged = response.isAcknowledged(); // <1>  
        request.snapshot(snapshotName); // <1>
            // end::get-repository-execute-listener  
                    @Override
            .put(compressKey, compressValue)
            // Replace the empty listener by a blocking listener in test  
        boolean acknowledged = response.isAcknowledged(); // <1>
            // end::snapshots-status-execute-listener  
 * this work for additional information regarding copyright
        // end::get-repository-request-masterTimeout
            final CountDownLatch latch = new CountDownLatch(1);  
        request.name(repositoryName); // <1>
            };
            // end::delete-repository-execute-async  
        // tag::create-repository-request-masterTimeout
        createTestIndex();  
        {  
        // end::get-repository-execute  
                    }  
        // end::snapshots-status-request-snapshots
    }  
package org.opensearch.client.documentation;
        // end::restore-snapshot-request-waitForCompletion  
        request.clusterManagerNodeTimeout("1m"); // <2>
import org.opensearch.repositories.fs.FsRepository;
        // end::create-snapshot-response-snapshot-info
        // tag::snapshots-status-request-repository
    }
            // Replace the empty listener by a blocking listener in test
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
            ActionListener<SnapshotsStatusResponse> listener =  
            // tag::get-repository-execute-async  
    }  
        // end::create-snapshot-request-includeGlobalState  
        long startTime = snapshotInfo.startTime(); // <5>
        // tag::create-snapshot-request-masterTimeout
        // tag::get-snapshots-request-repositoryName
        assertEquals(200, response.getStatusLine().getStatusCode());  
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;
        assertEquals(RestStatus.OK, status);  
        // tag::create-snapshot-request-partial
    }  
        request.clusterManagerNodeTimeout("1m"); // <2>
        // end::verify-repository-request-timeout  
                    public void onFailure(Exception e) {
        RestoreSnapshotResponse response = client.snapshot().restore(request, RequestOptions.DEFAULT);
            assertTrue(latch.await(30L, TimeUnit.SECONDS));  
        request.verbose(true); // <1>
        // end::get-snapshots-execute
        request.indicesOptions(IndicesOptions.fromOptions(false, false, true, true)); // <1>
            .build(); // <1>  
        // end::restore-snapshot-request-include-global-state
            // end::get-repository-execute-async
            // end::delete-snapshot-execute-listener
        assertThat(1, equalTo(repositoryMetadataResponse.size()));  
            // end::restore-snapshot-execute-async  
                new ActionListener<VerifyRepositoryResponse>() {
        request.includeGlobalState(false); // <1>
import org.opensearch.snapshots.SnapshotShardFailure;  
        request.snapshots(snapshots); // <1>
        // end::get-repository-response
            // tag::verify-repository-execute-listener
                }
            listener = new LatchedActionListener<>(listener, latch);
        String [] snapshots = new String[] {snapshotName};  
        }
            // end::create-snapshot-execute-listener  
                    }
                @Override
            // end::create-repository-settings-source  
    }
import java.util.Collections;
            listener = new LatchedActionListener<>(listener, latch);  
        // tag::create-repository-execute
                    public void onResponse(VerifyRepositoryResponse verifyRepositoryRestResponse) {  
            final CountDownLatch latch = new CountDownLatch(1);
    }  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
        RestHighLevelClient client = highLevelClient();  
        createSnapshot.setJsonEntity("{\"indices\":\"" + indexName + "\"}");  
        }
        createTestRepositories();
                new ActionListener<CreateSnapshotResponse>() {
        createTestRepositories();
            ActionListener<VerifyRepositoryResponse> listener =  
        // tag::verify-repository-execute
        // end::create-repository-execute  
        // tag::create-snapshot-request  
                    @Override
            // tag::delete-snapshot-execute-listener
        // end::get-repository-request
        // tag::get-snapshots-request-verbose
                @Override
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            client.snapshot().statusAsync(request, RequestOptions.DEFAULT, listener); // <1>
 * ownership. Elasticsearch licenses this file to you under  
        RestHighLevelClient client = highLevelClient();  
        // end::get-snapshots-request-snapshots  
        request.type(FsRepository.TYPE);  
                    }
        RestHighLevelClient client = highLevelClient();
import org.opensearch.client.Request;
                MediaTypeRegistry.JSON); // <1>
        request.clusterManagerNodeTimeout("1m"); // <2>
        request.partial(false); // <1>
 * This class is used to generate the Java Snapshot API documentation.
                }
import org.opensearch.client.RestHighLevelClient;
                    }
        // end::get-snapshots-request  
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest;
    protected boolean waitForAllSnapshotsWiped() {
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
                };  
        RestStatus status = response.status(); // <1>  
                    public void onFailure(Exception e) {
            // tag::delete-snapshot-execute-async
                    }
        final boolean async = Booleans.parseBoolean(System.getProperty("tests.rest.async", "false"));
                    // <2>  
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
                    @Override
    }  
        {
        request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
import org.opensearch.client.OpenSearchRestHighLevelClientTestCase;  
        // end::delete-snapshot-execute  
