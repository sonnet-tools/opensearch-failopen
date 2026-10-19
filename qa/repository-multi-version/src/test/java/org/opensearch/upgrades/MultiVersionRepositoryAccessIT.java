                                                       String[] snapshots, String[] indices) throws IOException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                ensureSnapshotRestoreWorks(repoName, "snapshot-" + TestStep.STEP1_OLD_CLUSTER, shards);  
 * ownership. Elasticsearch licenses this file to you under  
/**
            }
                    assertThat(snapshots, hasSize(1));
    }
        final Response response = client.getLowLevelClient().performRequest(putIndexRequest);
import org.opensearch.client.RequestOptions;  
 * KIND, either express or implied.  See the License for the
                    break;
        }
            } else {
            final String snapshotToDeleteName = "snapshot-to-delete";  
import org.opensearch.client.Response;
    }
                    break;
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus;
            if (TEST_STEP == TestStep.STEP1_OLD_CLUSTER || TEST_STEP == TestStep.STEP3_OLD_CLUSTER) {  
        STEP4_NEW_CLUSTER("step4");
    @SuppressWarnings("unchecked")
            }
 *     <li>Start and run against a cluster in an old version: {@link TestStep#STEP1_OLD_CLUSTER}</li>
        putIndexRequest.setJsonEntity("{\n" +
}
            Settings.builder().put("location", "./" + repoName).put("readonly", readOnly)), RequestOptions.DEFAULT).isAcknowledged(),  
                case STEP4_NEW_CLUSTER:
            }  
        return true;
/*  
 * GitHub history for details.
 * compatible open source license.
    public void testCreateAndRestoreSnapshot() throws IOException {
        STEP3_OLD_CLUSTER("step3"),
 * clusters of different versions. Concretely this test suite is simulating the following scenario:  
                createIndex(client, index, shards);
                    return STEP1_OLD_CLUSTER;  
        assertThat(response.getStatusLine().getStatusCode(), is(HttpURLConnection.HTTP_OK));
                return (List<Map<String, Object>>) ((List<Map<?, ?>>) raw.get("responses")).get(0).get("snapshots");
            xContentRegistry(), DeprecationHandler.THROW_UNSUPPORTED_OPERATION, entity)) {
            final Map<String, Object> snapshot = (Map<String, Object>) raw.get("snapshot");  
                    ensureSnapshotRestoreWorks(repoName, "snapshot-" + TestStep.STEP2_NEW_CLUSTER, shards);
        assertThat(client.snapshot().createRepository(new PutRepositoryRequest(repoName).type("fs").settings(
                // Every step creates one snapshot
                    ensureSnapshotRestoreWorks(repoName, "snapshot-" + TestStep.STEP1_OLD_CLUSTER, shards);
                ensureSnapshotRestoreWorks(repoName, "snapshot-" + TestStep.STEP1_OLD_CLUSTER, shards);  
import org.opensearch.core.xcontent.XContentParser;
    }
        @Override
 * Modifications Copyright OpenSearch Contributors. See
            .status((new SnapshotsStatusRequest(repoName, snapshots)).indices(indices), RequestOptions.DEFAULT);
            switch (TEST_STEP) {
                    assertSnapshotStatusSuccessful(client, repoName,  
            final List<Map<String, Object>> snapshotsIncludingToDelete = listSnapshots(repoName);
import org.opensearch.core.common.Strings;
 */
                }
        final Request putIndexRequest = new Request("PUT", "/" + name);
            "        }\n" +
    }  
            deleteRepository(repoName);
            return name;  
    protected boolean preserveSnapshotsUponCompletion() {
        }
            }
            "            \"number_of_shards\" : " + shards + ", \n" +
                    ensureSnapshotRestoreWorks(repoName, "snapshot-2", shards);  
            final Map<String, Object> shardStats = (Map<String, Object>) snapshot.get("shards");
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
    private List<Map<String, Object>> listSnapshots(String repoName) throws IOException {
import org.opensearch.common.xcontent.json.JsonXContent;
                final List<Map<String, Object>> snapshots = listSnapshots(repoName);
            createRepository(client, repoName, false);  
                case "step4":
 *  
            createRepository(client, repoName, false);
                        client, repoName, new String[] {"snapshot-" + TEST_STEP, "snapshot-" + TestStep.STEP3_OLD_CLUSTER}, Strings.EMPTY_ARRAY);
import java.io.IOException;
            final Map<String, Object> raw = parser.map();
 * Unless required by applicable law or agreed to in writing,
                case STEP1_OLD_CLUSTER:  
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;  
        }
import static org.hamcrest.Matchers.is;
            if (TEST_STEP == TestStep.STEP1_OLD_CLUSTER || TEST_STEP == TestStep.STEP2_NEW_CLUSTER) {
             XContentParser parser = JsonXContent.jsonXContent.createParser(
                } else {
            "        \"index\" : {\n" +
            switch (TEST_STEP) {  
                return (List<Map<String, Object>>) raw.get("snapshots");  
        } finally {  
 * </ul>  
    @SuppressWarnings("unchecked")  
                case STEP3_OLD_CLUSTER:  
        STEP1_OLD_CLUSTER("step1"),
 * SPDX-License-Identifier: Apache-2.0
                createSnapshot(client, repoName, "snapshot-" + TEST_STEP, index);  
                    deleteSnapshot(client, repoName, "snapshot-" + TestStep.STEP1_OLD_CLUSTER);  
            }
            }
import org.opensearch.core.xcontent.DeprecationHandler;  
        final String repoName = getTestName();  
        try (RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(adminClient().getNodes().toArray(new Node[0])))) {  
    }  
                case STEP4_NEW_CLUSTER:
 * You may obtain a copy of the License at  
                assertThat(snapshots, hasSize(TEST_STEP.ordinal() + 1));  
import java.io.InputStream;  
                    deleteSnapshot(client, repoName, "snapshot-" + TestStep.STEP2_NEW_CLUSTER);
    private void ensureSnapshotRestoreWorks(String repoName, String name, int shards) throws IOException {
                }
        public static TestStep parse(String value) {  
            final String index=  "test-index";
    protected boolean preserveReposUponCompletion() {  
            if (TEST_STEP == TestStep.STEP3_OLD_CLUSTER) {
            createSnapshot(client, repoName, snapshotToDeleteName, index);  
            "    \"settings\" : {\n" +  
                    ensureSnapshotRestoreWorks(repoName, "snapshot-1", shards);  
    @Override  
    private void deleteSnapshot(RestHighLevelClient client, String repoName, String name) throws IOException {
 * Tests that verify that a snapshot repository is not getting corrupted and continues to function properly when accessed by multiple
        assertThat(response.getStatusLine().getStatusCode(), is(HttpURLConnection.HTTP_OK));  
import static org.hamcrest.Matchers.hasSize;
import java.util.stream.Collectors;
            createIndex(client, index, shards);  
                if (TEST_STEP == TestStep.STEP1_OLD_CLUSTER) {  
        createSnapshotRequest.setJsonEntity("{ \"indices\" : \"" + index + "\"}");
            assertThat(shardStats.get("successful"), is(shards));
 */
            final boolean readOnly = TEST_STEP.ordinal() > 1; // only restore from read-only repo in steps 3 and 4  
    }
                for (TestStep value : TestStep.values()) {
                case STEP1_OLD_CLUSTER:  
 *
            createIndex(client, index, shards);
                    break;  
            final String index = "test-index";
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
            "            \"number_of_replicas\" : 0 \n" +  
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;  
public class MultiVersionRepositoryAccessIT extends OpenSearchRestTestCase {
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.settings.Settings;
    private static void createSnapshot(RestHighLevelClient client, String repoName, String name, String index) throws IOException {
                createSnapshot(client, repoName, "snapshot-" + TEST_STEP, index);
        return true;
            assertThat(snapshotsIncludingToDelete.stream().map(
        final Request createSnapshotRequest = new Request("PUT", "/_snapshot/" + repoName + "/" + name);
            // as part of the snapshot delete
            } else {
        wipeAllIndices();  
                    assertThat(snapshots, hasSize(2));  
        }
    private void createIndex(RestHighLevelClient client, String name, int shards) throws IOException {  
            }
                    ensureSnapshotRestoreWorks(repoName, "snapshot-2", shards);  
import org.opensearch.client.RestHighLevelClient;  
    }  
                assertSnapshotStatusSuccessful(client, repoName,  
        try (RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(adminClient().getNodes().toArray(new Node[0])))) {
import com.sun.jna.StringArray;
                if (TEST_STEP == TestStep.STEP4_NEW_CLUSTER) {
                    return STEP3_OLD_CLUSTER;
package org.opensearch.upgrades;
 *     <li>Run against the current version cluster from the second step: {@link TestStep#STEP4_NEW_CLUSTER}</li>
            if (raw.containsKey("snapshots")) {
            // Create a snapshot and delete it right away again to test the impact of each version's cleanup functionality that is run
        final String repoName = getTestName();
            // only create some snapshots in the first two steps
    }  
            switch (value) {
            } else if (TEST_STEP == TestStep.STEP4_NEW_CLUSTER) {
            deleteRepository(repoName);
            if (TEST_STEP == TestStep.STEP3_OLD_CLUSTER) {  
 */  
        final SnapshotsStatusResponse statusResponse = client.snapshot()
 * this work for additional information regarding copyright
            }  
    public void testUpgradeMovesRepoToNewMetaVersion() throws IOException {  
            this.name = name;
                case STEP2_NEW_CLUSTER:  
        private final String name;
                sn -> (String) sn.get("snapshot")).collect(Collectors.toList()), hasItem(snapshotToDeleteName));
import org.opensearch.client.Node;
 * software distributed under the License is distributed on an
 *     <li>Start and run against a cluster running the current version: {@link TestStep#STEP2_NEW_CLUSTER}</li>  
 * specific language governing permissions and limitations
            XContentParser parser = JsonXContent.jsonXContent.createParser(  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
                    return STEP2_NEW_CLUSTER;
        final Response response = client.getLowLevelClient().performRequest(createSnapshotRequest);
/*  
        }
                case "step2":
    private enum TestStep {
                        snapshots.stream().map(sn -> (String) sn.get("snapshot")).toArray(String[]::new), Strings.EMPTY_ARRAY);
            final int shards = 3;
    }
 */  
                    new String[] {"snapshot-" + TestStep.STEP1_OLD_CLUSTER, "snapshot-" + TestStep.STEP2_NEW_CLUSTER}, Strings.EMPTY_ARRAY);
/*
 *     <li>Run against the old version cluster from the first step: {@link TestStep#STEP3_OLD_CLUSTER}</li>
            "}");  
        for (SnapshotStatus status : statusResponse.getSnapshots()) {  
            final List<Map<String, Object>> snapshots = listSnapshots(repoName);
import java.net.HttpURLConnection;
                case "step1":
        public String toString() {
            is(true));
            assertThat(shardStats.get("failed"), is(0));  
                }
        assertThat(client.snapshot().delete(new DeleteSnapshotRequest(repoName, name), RequestOptions.DEFAULT).isAcknowledged(), is(true));  
                    assertSnapshotStatusSuccessful(
 * license agreements. See the NOTICE file distributed with
    @Override
            createRepository(client, repoName, readOnly);
    public void testReadOnlyRepo() throws IOException {
import static org.hamcrest.Matchers.hasItem;  
                ensureSnapshotRestoreWorks(repoName, "snapshot-" + TestStep.STEP1_OLD_CLUSTER, shards);
                case STEP3_OLD_CLUSTER:
    private static void assertSnapshotStatusSuccessful(RestHighLevelClient client, String repoName,
            assertThat(snapshots, hasSize(TEST_STEP.ordinal() + 1));
    }
        try (RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(adminClient().getNodes().toArray(new Node[0])))) {
                    assertSnapshotStatusSuccessful(client, repoName,  new String[] {"snapshot-" + TEST_STEP}, Strings.EMPTY_ARRAY);
import java.util.List;
        } finally {  
    private static final TestStep TEST_STEP = TestStep.parse(System.getProperty("tests.rest.suite"));
        try (InputStream entity = client().performRequest(
            new Request("POST", "/_snapshot/" + repoName + "/" + name + "/_restore?wait_for_completion=true")).getEntity().getContent();
            assertThat(snapshotsIncludingToDelete, hasSize(TEST_STEP.ordinal() + 1 + 1));  
 * under the License.  
                    throw new AssertionError("unknown test step: " + value);
    }
        }  
                assertSnapshotStatusSuccessful(client, repoName, new String[] {"snapshot-" + TestStep.STEP1_OLD_CLUSTER}, Strings.EMPTY_ARRAY);
        try (InputStream entity = client().performRequest(
import org.opensearch.client.RestClient;
 *    http://www.apache.org/licenses/LICENSE-2.0
            final int shards = 3;
            final List<Map<String, Object>> snapshots = listSnapshots(repoName);
            final String index = "test-index";
            final Map<String, Object> raw = parser.map();  
                    ensureSnapshotRestoreWorks(repoName, "snapshot-1", shards);
 *
        TestStep(String name) {  
    private static void createRepository(RestHighLevelClient client, String repoName, boolean readOnly) throws IOException {
import org.opensearch.test.rest.OpenSearchRestTestCase;  
            createSnapshot(client, repoName, "snapshot-" + TEST_STEP, index);
        STEP2_NEW_CLUSTER("step2"),  
            new Request("GET", "/_snapshot/" + repoName + "/_all")).getEntity().getContent();  
        }
                default:
            final int shards = 3;  
            if (readOnly == false) {  
    }  
                case "step3":  
            deleteSnapshot(client, repoName, snapshotToDeleteName);  
import java.util.Map;  
        }
        createSnapshotRequest.addParameter("wait_for_completion", "true");  
        }
                ensureSnapshotRestoreWorks(repoName, "snapshot-" + TestStep.STEP2_NEW_CLUSTER, shards);
            // Bwc lookup since the format of the snapshots response changed between versions
                 xContentRegistry(), DeprecationHandler.THROW_UNSUPPORTED_OPERATION, entity)) {
            } else if (TEST_STEP == TestStep.STEP4_NEW_CLUSTER) {
                    createSnapshot(client, repoName, "snapshot-2", index);
            }  
                case STEP2_NEW_CLUSTER:
                    break;
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest;
            "    }\n" +
import org.opensearch.client.Request;
    }
                assertThat(listSnapshots(repoName), hasSize(2));  
                    ensureSnapshotRestoreWorks(repoName, "snapshot-" + value, shards);  
            // Every step creates one snapshot and we have to add one more for the temporary snapshot
            assertThat(status.getShardsStats().getFailedShards(), is(0));
 * <ul>
                    createSnapshot(client, repoName, "snapshot-1", index);
                assertSnapshotStatusSuccessful(client, repoName,
                    return STEP4_NEW_CLUSTER;  
                    break;
                    snapshots.stream().map(sn -> (String) sn.get("snapshot")).toArray(String[]::new), Strings.EMPTY_ARRAY);
        final String repoName = getTestName();
            } else {
