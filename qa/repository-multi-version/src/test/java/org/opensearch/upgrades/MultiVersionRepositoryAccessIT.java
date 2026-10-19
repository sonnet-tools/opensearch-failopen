import org.opensearch.common.xcontent.json.JsonXContent;
             XContentParser parser = JsonXContent.jsonXContent.createParser(
                return (List<Map<String, Object>>) raw.get("snapshots");
                case STEP4_NEW_CLUSTER:
        private final String name;
        }
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
            }
                createSnapshot(client, repoName, "snapshot-" + TEST_STEP, index);
                    return STEP2_NEW_CLUSTER;
import org.opensearch.test.rest.OpenSearchRestTestCase;
            }
        } finally {
    private static void assertSnapshotStatusSuccessful(RestHighLevelClient client, String repoName,
            "        \"index\" : {\n" +
            if (readOnly == false) {
                final List<Map<String, Object>> snapshots = listSnapshots(repoName);
                    ensureSnapshotRestoreWorks(repoName, "snapshot-" + TestStep.STEP2_NEW_CLUSTER, shards);
    private void createIndex(RestHighLevelClient client, String name, int shards) throws IOException {
            } else if (TEST_STEP == TestStep.STEP4_NEW_CLUSTER) {
        final Request putIndexRequest = new Request("PUT", "/" + name);
        }
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
import java.net.HttpURLConnection;
                case STEP1_OLD_CLUSTER:
            if (TEST_STEP == TestStep.STEP1_OLD_CLUSTER || TEST_STEP == TestStep.STEP3_OLD_CLUSTER) {
                    ensureSnapshotRestoreWorks(repoName, "snapshot-" + TestStep.STEP1_OLD_CLUSTER, shards);
            createSnapshot(client, repoName, "snapshot-" + TEST_STEP, index);
            is(true));
 * Tests that verify that a snapshot repository is not getting corrupted and continues to function properly when accessed by multiple
                    assertSnapshotStatusSuccessful(
                    break;
import java.util.stream.Collectors;
 */
        STEP2_NEW_CLUSTER("step2"),
    private void deleteSnapshot(RestHighLevelClient client, String repoName, String name) throws IOException {
        } finally {
                } else {
                    assertThat(snapshots, hasSize(1));
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusRequest;
            createIndex(client, index, shards);
    protected boolean preserveReposUponCompletion() {
        }
import org.opensearch.client.RestClient;
                ensureSnapshotRestoreWorks(repoName, "snapshot-" + TestStep.STEP1_OLD_CLUSTER, shards);
        }
            final boolean readOnly = TEST_STEP.ordinal() > 1; // only restore from read-only repo in steps 3 and 4
                // Every step creates one snapshot
            this.name = name;
    @SuppressWarnings("unchecked")
                    new String[] {"snapshot-" + TestStep.STEP1_OLD_CLUSTER, "snapshot-" + TestStep.STEP2_NEW_CLUSTER}, Strings.EMPTY_ARRAY);
import static org.hamcrest.Matchers.hasItem;
            new Request("GET", "/_snapshot/" + repoName + "/_all")).getEntity().getContent();
 * this work for additional information regarding copyright
 * compatible open source license.
        STEP4_NEW_CLUSTER("step4");
                        snapshots.stream().map(sn -> (String) sn.get("snapshot")).toArray(String[]::new), Strings.EMPTY_ARRAY);
import org.opensearch.core.common.Strings;
 * not use this file except in compliance with the License.
            final String snapshotToDeleteName = "snapshot-to-delete";
                case "step4":
        final Response response = client.getLowLevelClient().performRequest(createSnapshotRequest);
 * Licensed to Elasticsearch under one or more contributor
    private static void createSnapshot(RestHighLevelClient client, String repoName, String name, String index) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
            deleteRepository(repoName);
            createRepository(client, repoName, readOnly);
        }
        assertThat(response.getStatusLine().getStatusCode(), is(HttpURLConnection.HTTP_OK));
        assertThat(response.getStatusLine().getStatusCode(), is(HttpURLConnection.HTTP_OK));
    private static void createRepository(RestHighLevelClient client, String repoName, boolean readOnly) throws IOException {
    @SuppressWarnings("unchecked")
            switch (TEST_STEP) {
        final SnapshotsStatusResponse statusResponse = client.snapshot()
            }
 * You may obtain a copy of the License at
import org.opensearch.client.RestHighLevelClient;
            assertThat(snapshots, hasSize(TEST_STEP.ordinal() + 1));
 * clusters of different versions. Concretely this test suite is simulating the following scenario:
    @Override
                case "step2":
            assertThat(status.getShardsStats().getFailedShards(), is(0));
                assertThat(listSnapshots(repoName), hasSize(2));
package org.opensearch.upgrades;
            XContentParser parser = JsonXContent.jsonXContent.createParser(
        try (InputStream entity = client().performRequest(
    }
                ensureSnapshotRestoreWorks(repoName, "snapshot-" + TestStep.STEP1_OLD_CLUSTER, shards);
            }
            final Map<String, Object> shardStats = (Map<String, Object>) snapshot.get("shards");
        final String repoName = getTestName();
 * GitHub history for details.
import static org.hamcrest.Matchers.hasSize;
    public void testUpgradeMovesRepoToNewMetaVersion() throws IOException {
    protected boolean preserveSnapshotsUponCompletion() {
 *
            assertThat(snapshotsIncludingToDelete, hasSize(TEST_STEP.ordinal() + 1 + 1));
        try (RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(adminClient().getNodes().toArray(new Node[0])))) {
 * the Apache License, Version 2.0 (the "License"); you may
            }
        assertThat(client.snapshot().delete(new DeleteSnapshotRequest(repoName, name), RequestOptions.DEFAULT).isAcknowledged(), is(true));
            // as part of the snapshot delete
                    return STEP3_OLD_CLUSTER;
import org.opensearch.core.xcontent.DeprecationHandler;
                case STEP4_NEW_CLUSTER:
                    ensureSnapshotRestoreWorks(repoName, "snapshot-2", shards);
                                                       String[] snapshots, String[] indices) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * The OpenSearch Contributors require contributions made to
 * KIND, either express or implied.  See the License for the
        STEP1_OLD_CLUSTER("step1"),
import java.io.IOException;
                    snapshots.stream().map(sn -> (String) sn.get("snapshot")).toArray(String[]::new), Strings.EMPTY_ARRAY);
    }
    public void testReadOnlyRepo() throws IOException {
                    ensureSnapshotRestoreWorks(repoName, "snapshot-" + value, shards);
        }
import org.opensearch.client.Request;
        TestStep(String name) {
        @Override
                    break;
        final String repoName = getTestName();
            // Every step creates one snapshot and we have to add one more for the temporary snapshot
            return name;
            final List<Map<String, Object>> snapshotsIncludingToDelete = listSnapshots(repoName);
    private enum TestStep {
        createSnapshotRequest.addParameter("wait_for_completion", "true");
    }
                    break;
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
    }
        createSnapshotRequest.setJsonEntity("{ \"indices\" : \"" + index + "\"}");
}
            // only create some snapshots in the first two steps
 *
 * Modifications Copyright OpenSearch Contributors. See
        final Request createSnapshotRequest = new Request("PUT", "/_snapshot/" + repoName + "/" + name);
                    ensureSnapshotRestoreWorks(repoName, "snapshot-1", shards);
            assertThat(shardStats.get("successful"), is(shards));
                return (List<Map<String, Object>>) ((List<Map<?, ?>>) raw.get("responses")).get(0).get("snapshots");
                    ensureSnapshotRestoreWorks(repoName, "snapshot-1", shards);
 * </ul>
            switch (TEST_STEP) {
/*
            xContentRegistry(), DeprecationHandler.THROW_UNSUPPORTED_OPERATION, entity)) {
        assertThat(client.snapshot().createRepository(new PutRepositoryRequest(repoName).type("fs").settings(
                case STEP3_OLD_CLUSTER:
            } else {
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus;
    }
    }
        }
            createSnapshot(client, repoName, snapshotToDeleteName, index);
            createIndex(client, index, shards);
        STEP3_OLD_CLUSTER("step3"),
            createRepository(client, repoName, false);
            new Request("POST", "/_snapshot/" + repoName + "/" + name + "/_restore?wait_for_completion=true")).getEntity().getContent();
        for (SnapshotStatus status : statusResponse.getSnapshots()) {
                assertThat(snapshots, hasSize(TEST_STEP.ordinal() + 1));
            if (TEST_STEP == TestStep.STEP1_OLD_CLUSTER || TEST_STEP == TestStep.STEP2_NEW_CLUSTER) {
            "}");
 */
        return true;
        wipeAllIndices();
                for (TestStep value : TestStep.values()) {
    private List<Map<String, Object>> listSnapshots(String repoName) throws IOException {
import org.opensearch.client.Node;
        return true;
                    createSnapshot(client, repoName, "snapshot-1", index);
            final Map<String, Object> snapshot = (Map<String, Object>) raw.get("snapshot");
                if (TEST_STEP == TestStep.STEP1_OLD_CLUSTER) {
        try (InputStream entity = client().performRequest(
        public String toString() {
 *     <li>Run against the old version cluster from the first step: {@link TestStep#STEP3_OLD_CLUSTER}</li>
                    createSnapshot(client, repoName, "snapshot-2", index);
                assertSnapshotStatusSuccessful(client, repoName, new String[] {"snapshot-" + TestStep.STEP1_OLD_CLUSTER}, Strings.EMPTY_ARRAY);
        final String repoName = getTestName();
                    break;
 *     <li>Start and run against a cluster running the current version: {@link TestStep#STEP2_NEW_CLUSTER}</li>
            "            \"number_of_shards\" : " + shards + ", \n" +
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
                }
            final Map<String, Object> raw = parser.map();
            createRepository(client, repoName, false);
/*
            // Create a snapshot and delete it right away again to test the impact of each version's cleanup functionality that is run
            deleteRepository(repoName);
                if (TEST_STEP == TestStep.STEP4_NEW_CLUSTER) {
                    assertSnapshotStatusSuccessful(client, repoName,
                case STEP2_NEW_CLUSTER:
            if (TEST_STEP == TestStep.STEP3_OLD_CLUSTER) {
                        client, repoName, new String[] {"snapshot-" + TEST_STEP, "snapshot-" + TestStep.STEP3_OLD_CLUSTER}, Strings.EMPTY_ARRAY);
import java.util.Map;
                createSnapshot(client, repoName, "snapshot-" + TEST_STEP, index);
    }
                case STEP2_NEW_CLUSTER:
    private void ensureSnapshotRestoreWorks(String repoName, String name, int shards) throws IOException {
 * under the License.
 *     <li>Run against the current version cluster from the second step: {@link TestStep#STEP4_NEW_CLUSTER}</li>
/*
            "    \"settings\" : {\n" +
            assertThat(shardStats.get("failed"), is(0));
            assertThat(snapshotsIncludingToDelete.stream().map(
            if (raw.containsKey("snapshots")) {
            Settings.builder().put("location", "./" + repoName).put("readonly", readOnly)), RequestOptions.DEFAULT).isAcknowledged(),
                default:
        try (RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(adminClient().getNodes().toArray(new Node[0])))) {
    }
    public void testCreateAndRestoreSnapshot() throws IOException {
            "    }\n" +
            final List<Map<String, Object>> snapshots = listSnapshots(repoName);
import org.opensearch.client.RequestOptions;
            final List<Map<String, Object>> snapshots = listSnapshots(repoName);
        putIndexRequest.setJsonEntity("{\n" +
                 xContentRegistry(), DeprecationHandler.THROW_UNSUPPORTED_OPERATION, entity)) {
            "            \"number_of_replicas\" : 0 \n" +
                ensureSnapshotRestoreWorks(repoName, "snapshot-" + TestStep.STEP1_OLD_CLUSTER, shards);
            final int shards = 3;
                    deleteSnapshot(client, repoName, "snapshot-" + TestStep.STEP1_OLD_CLUSTER);
import com.sun.jna.StringArray;
import org.opensearch.common.settings.Settings;
 */
                    assertThat(snapshots, hasSize(2));
            }
        }
                case STEP3_OLD_CLUSTER:
                case STEP1_OLD_CLUSTER:
import org.opensearch.client.Response;
            } else {
 * ownership. Elasticsearch licenses this file to you under
            } else {
    }
            } else if (TEST_STEP == TestStep.STEP4_NEW_CLUSTER) {
/**
                sn -> (String) sn.get("snapshot")).collect(Collectors.toList()), hasItem(snapshotToDeleteName));
public class MultiVersionRepositoryAccessIT extends OpenSearchRestTestCase {
            final String index=  "test-index";
            final int shards = 3;
import java.io.InputStream;
                    throw new AssertionError("unknown test step: " + value);
        try (RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(adminClient().getNodes().toArray(new Node[0])))) {
            }
import org.opensearch.core.xcontent.XContentParser;
 */
                }
    }
            switch (value) {
            "        }\n" +
 * specific language governing permissions and limitations
                case "step1":
            }
                    assertSnapshotStatusSuccessful(client, repoName,  new String[] {"snapshot-" + TEST_STEP}, Strings.EMPTY_ARRAY);
import static org.hamcrest.Matchers.is;
                assertSnapshotStatusSuccessful(client, repoName,
            if (TEST_STEP == TestStep.STEP3_OLD_CLUSTER) {
 *
                    return STEP4_NEW_CLUSTER;
                    deleteSnapshot(client, repoName, "snapshot-" + TestStep.STEP2_NEW_CLUSTER);
    }
                assertSnapshotStatusSuccessful(client, repoName,
                createIndex(client, index, shards);
 * <ul>
 *    http://www.apache.org/licenses/LICENSE-2.0
 *     <li>Start and run against a cluster in an old version: {@link TestStep#STEP1_OLD_CLUSTER}</li>
                case "step3":
    }
                    return STEP1_OLD_CLUSTER;
            final Map<String, Object> raw = parser.map();
                    ensureSnapshotRestoreWorks(repoName, "snapshot-2", shards);
                }
            // Bwc lookup since the format of the snapshots response changed between versions
 * license agreements. See the NOTICE file distributed with
                    break;
        public static TestStep parse(String value) {
            }
            final int shards = 3;
    private static final TestStep TEST_STEP = TestStep.parse(System.getProperty("tests.rest.suite"));
 * this file be licensed under the Apache-2.0 license or a
            deleteSnapshot(client, repoName, snapshotToDeleteName);
        final Response response = client.getLowLevelClient().performRequest(putIndexRequest);
    }
            final String index = "test-index";
        }
                ensureSnapshotRestoreWorks(repoName, "snapshot-" + TestStep.STEP2_NEW_CLUSTER, shards);
import java.util.List;
            final String index = "test-index";
            .status((new SnapshotsStatusRequest(repoName, snapshots)).indices(indices), RequestOptions.DEFAULT);
    @Override
