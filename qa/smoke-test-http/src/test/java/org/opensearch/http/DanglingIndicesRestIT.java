     * @return a mapping from each created index name to its UUID
 * The OpenSearch Contributors require contributions made to
                + "        \"allocation\": {"
            request.setJsonEntity(indexSettings);
        internalCluster().setBootstrapClusterManagerNodeIndex(1);
 *
        assertThat(mapView.get("_nodes.total"), equalTo(3));
        internalCluster().setBootstrapClusterManagerNodeIndex(1);
package org.opensearch.http;
        final XContentTestUtils.JsonMapView mapView = createJsonMapView(listResponse.getEntity().getContent());
    }
        for (String nodeLine : Streams.readAllLines(catResponse.getEntity().getContent())) {
        }
import java.util.ArrayList;
        assertThat(listDanglingIndexIds(), is(empty()));
import org.opensearch.client.Response;
import org.opensearch.client.Request;
                + "      \"number_of_shards\": 1,"
            // Limit the indices kept in the graveyard. This can be set to zero, so that
        DanglingIndexDetails(String stoppedNodeName, Map<String, String> indexToUUID) {
        final XContentTestUtils.JsonMapView mapView = createJsonMapView(response.getEntity().getContent());
     * that each index has a primary or replica shard on every node, and if
                + "  \"settings\": {"
        assertThat("Expected to find as many index UUIDs as created indices", createdIndexIDs.size(), equalTo(indices.length));
        Response deleteResponse = getRestClient().performRequest(new Request("DELETE", "/" + indexName));
/**
     * greater than 1. To test deletes, we set the index graveyard size to
     * a node is stopped prematurely, this assumption is broken.
        deleteRequest.addParameter("timeout", "20s");
                + "      }"
import static org.hamcrest.Matchers.hasSize;
        final RestClient restClient = getRestClient();
        internalCluster().startNodes(3, buildSettings(0));
        createDanglingIndices(INDEX_NAME);
            if (elements[1].equals(nodeName)) {
            .put(AUTO_IMPORT_DANGLING_INDICES_SETTING.getKey(), false)
            () -> internalCluster().getInstances(IndicesService.class)
        for (String indexLine : Streams.readAllLines(catResponse.getEntity().getContent())) {
        assertThat(importResponse.getStatusLine().getStatusCode(), equalTo(ACCEPTED.getStatus()));
            String[] elements = nodeLine.split(" ");
            .put(WRITE_DANGLING_INDICES_INFO_SETTING.getKey(), true)
        // Ensure these parameters is accepted
import static org.hamcrest.Matchers.empty;
 * under the License.
        return Settings.builder()
 *
import java.util.concurrent.atomic.AtomicReference;
     * 1, then create two indices and delete them both while one node in
     */
 * You may obtain a copy of the License at
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        final Response response = getRestClient().performRequest(new Request("GET", "/_dangling"));
        assertThat(danglingIndexIds, hasSize(1));
        assertOK(listResponse);
        final Request importRequest = new Request("POST", "/_dangling/" + danglingIndexIds.get(0));
import org.opensearch.test.InternalTestCluster;
            @Override
 * compatible open source license.
import org.opensearch.test.XContentTestUtils;
    private static final String OTHER_INDEX_NAME = INDEX_NAME + "-other";
import java.util.Map;
     * Check that when dangling indices are discovered, then they can be listed via the REST API.
     * Check that dangling indices can be deleted. Since this requires that
        final Response listResponse = restClient.performRequest(new Request("GET", "/_dangling"));
     * will be considered dangling, and can therefore be listed and
            String[] elements = indexLine.split(" +");
import static org.opensearch.cluster.metadata.IndexGraveyard.SETTING_MAX_TOMBSTONES;
        ensureStableCluster(3);
public class DanglingIndicesRestIT extends HttpSmokeTestCase {
                + "          \"total_shards_per_node\": 1"
 * @see org.opensearch.action.admin.indices.dangling
 * KIND, either express or implied.  See the License for the
    private DanglingIndexDetails createDanglingIndices(String... indices) throws Exception {
    }
        assert indices.length > 0;
    private Map<String, String> createIndices(String... indices) throws IOException {
        assertThat(mapView.get("acknowledged"), equalTo(true));
import static org.opensearch.indices.IndicesService.WRITE_DANGLING_INDICES_INFO_SETTING;
import java.util.List;
    }
import static org.hamcrest.Matchers.equalTo;
     * Check that dangling indices can be imported.
            this.stoppedNodeName = stoppedNodeName;
        assertThat(mapView.get("dangling_indices.0.node_ids.0"), equalTo(stoppedNodeId));
        }
            }
import static org.opensearch.core.rest.RestStatus.OK;
import org.opensearch.common.io.Streams;
    }
import org.opensearch.indices.IndicesService;
            if (indicesAsList.contains(elements[0])) {
        final RestClient restClient = getRestClient();
        return createdIndexIDs;
        private final String stoppedNodeName;
            Request request = new Request("PUT", "/" + index);
import org.opensearch.common.settings.Settings;
        final List<String> danglingIndexIds = listDanglingIndexIds();
     */
        throw new AssertionError("Failed to map node name [" + nodeName + "] to node ID");
 * implementation, and they cannot be REST tests today since they need to
        assertThat(deleteResponse.getStatusLine().getStatusCode(), equalTo(ACCEPTED.getStatus()));
        assertBusy(
                + "}";
 */
 * GitHub history for details.
                + "      \"number_of_replicas\": 2,"
            .put(SETTING_MAX_TOMBSTONES.getKey(), maxTombstones)
            // when we delete an index, it's definitely considered to be dangling.
import org.opensearch.client.RestClient;
                return super.onNodeStopped(nodeName);
        internalCluster().startNodes(3, buildSettings(1));
 */
            public Settings onNodeStopped(String nodeName) throws Exception {
     * Given a node name, finds the corresponding node ID.
                for (String index : indices) {
 *
     * checks that they are green before proceeding. This is important
        assertThat(mapView.get("_nodes.failed"), equalTo(0));
        final XContentTestUtils.JsonMapView mapView = createJsonMapView(deleteResponse.getEntity().getContent());
        importRequest.addParameter("cluster_manager_timeout", "20s");
 * ownership. Elasticsearch licenses this file to you under
    }
                return elements[0];
 * not use this file except in compliance with the License.
        return danglingIndexIds;
    }
/*
 * specific language governing permissions and limitations
    public void testDanglingIndicesCanBeImported() throws Exception {
        assertOK(catResponse);
    }
            String indexSettings = "{"
        internalCluster().setBootstrapClusterManagerNodeIndex(1);
        ensureStableCluster(3);
        List<Object> indices = mapView.get("dangling_indices");
        assertThat(response.getStatusLine().getStatusCode(), equalTo(OK.getStatus()));
    private String mapNodeNameToId(String nodeName) throws IOException {
        assertThat(mapView.get("dangling_indices.0.creation_date_millis"), instanceOf(Long.class));
                + "    \"index\": {"
import java.util.HashMap;
import java.io.IOException;
     * because the tests in this class stop and restart nodes, assuming
    /**
        assertThat(mapView.get("_nodes.successful"), equalTo(3));
        // Ensure this parameter is accepted
     */
import static org.hamcrest.Matchers.is;
/*
    }
    /**
     * the cluster is stopped. The deletion of the second pushes the deletion
        final AtomicReference<String> stoppedNodeName = new AtomicReference<>();
        final Map<String, String> indexToUUID = createIndices(indices);
 * this work for additional information regarding copyright
        assertOK(catResponse);
/*
        for (int i = 0; i < indices.size(); i++) {
                    deleteIndex(index);
        final Map<String, String> createdIndexIDs = new HashMap<>();
                + "    }"
    private List<String> listDanglingIndexIds() throws IOException {
        }
        assertTrue("Expected dangling index " + INDEX_NAME + " to be recovered", indexExists(INDEX_NAME));
        // The dangling index that we deleted ought to have been removed from disk. Check by
    }
        internalCluster().startNodes(3, buildSettings(0));
     * we add an entry to the index graveyard, the graveyard size must be
 * Licensed to Elasticsearch under one or more contributor
        assertThat(mapView.get("_nodes.successful"), equalTo(3));
        deleteRequest.addParameter("accept_data_loss", "true");
                ensureClusterSizeConsistency();
    public void testDanglingIndicesCanBeDeleted() throws Exception {
    }
     */
        assertThat(mapView.get("acknowledged"), equalTo(true));
                + "        }"
            }
import static org.opensearch.gateway.DanglingIndicesState.AUTO_IMPORT_DANGLING_INDICES_SETTING;
        deleteRequest.addParameter("cluster_manager_timeout", "20s");
 * license agreements. See the NOTICE file distributed with
            .build();
                }
        importRequest.addParameter("accept_data_loss", "true");
        final Response catResponse = getRestClient().performRequest(new Request("GET", "/_cat/indices?h=index,uuid"));
        List<Object> indices = mapView.get("dangling_indices");
     *
 * today so they have access to a proper REST client. They cannot be in
        });
    private void assertOK(Response response) {
import static org.opensearch.core.rest.RestStatus.ACCEPTED;
@ClusterScope(numDataNodes = 0, scope = OpenSearchIntegTestCase.Scope.TEST, autoManageMasterNodes = false)
        for (String index : indices) {
 * software distributed under the License is distributed on an
        final List<String> danglingIndexIds = listDanglingIndexIds();
        }
        final XContentTestUtils.JsonMapView mapView = createJsonMapView(importResponse.getEntity().getContent());
            }
        // tombstone has been pushed out of the graveyard.
        assertThat(mapView.get("dangling_indices.0.index_name"), equalTo(INDEX_NAME));
     * only the second index will be found into the graveyard and the other
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
 * the Apache License, Version 2.0 (the "License"); you may
    private Settings buildSettings(int maxTombstones) {
        final Response deleteResponse = restClient.performRequest(deleteRequest);
    }
 * restart nodes. Really, though, this test should live elsewhere.
        return new DanglingIndexDetails(stoppedNodeName.get(), indexToUUID);
import static org.hamcrest.Matchers.instanceOf;
     * Helper that creates one or more indices, and importantly,
        // Restart node, deleting the index in its absence, so that there is a dangling index to recover
                + "  }"
        private final Map<String, String> indexToUUID;
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
        createIndex("additional");
        assertThat(danglingIndexIds, hasSize(1));
    private static final String INDEX_NAME = "test-idx-1";
 * :server:integTest since the REST client needs a proper transport
        // creating and deleting another index, which creates a new tombstone entry, which should
        );
 */
}
 *
    /**
     */
 * This class tests the dangling indices REST API.  These tests are here
            this.indexToUUID = indexToUUID;
        List<String> danglingIndexIds = new ArrayList<>();
import static org.opensearch.test.XContentTestUtils.createJsonMapView;
     * of the first out of the graveyard. When the stopped node is resumed,
        assertThat(indices, hasSize(1));
import org.opensearch.test.OpenSearchIntegTestCase;
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(mapView.get("dangling_indices.0.index_uuid"), equalTo(danglingIndexDetails.indexToUUID.get(INDEX_NAME)));
        assertOK(deleteResponse);
        assertThat(mapView.get("_nodes.total"), equalTo(3));
            assertOK(getRestClient().performRequest(request));
        final Response catResponse = getRestClient().performRequest(new Request("GET", "/_cat/nodes?full_id&h=id,name"));
        final Response importResponse = restClient.performRequest(importRequest);
 * this file be licensed under the Apache-2.0 license or a
        assertBusy(() -> assertThat("Expected dangling index to be deleted", listDanglingIndexIds(), hasSize(0)));
    public void testDanglingIndicesCanBeListed() throws Exception {
                createdIndexIDs.put(elements[0], elements[1]);
        assertThat(mapView.get("_nodes.failed"), equalTo(0));
        createDanglingIndices(INDEX_NAME, OTHER_INDEX_NAME);
        final String stoppedNodeId = mapNodeNameToId(danglingIndexDetails.stoppedNodeName);
                + "      \"routing\": {"
     * deleted through the API
    private void deleteIndex(String indexName) throws IOException {
                stoppedNodeName.set(nodeName);
    /**
        final List<String> indicesAsList = Arrays.asList(indices);
 * Unless required by applicable law or agreed to in writing,
        final Request deleteRequest = new Request("DELETE", "/_dangling/" + danglingIndexIds.get(0));
    /**
        // not cause the deleted dangling index to be considered "live" again, just because its
            danglingIndexIds.add(mapView.get("dangling_indices." + i + ".index_uuid"));
        deleteIndex("additional");
        ensureGreen(indices);
import java.util.Arrays;
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private static class DanglingIndexDetails {
        final RestClient restClient = getRestClient();
 * SPDX-License-Identifier: Apache-2.0
                .forEach(indicesService -> assertTrue(indicesService.allPendingDanglingIndicesWritten()))
        final DanglingIndexDetails danglingIndexDetails = createDanglingIndices(INDEX_NAME);
        importRequest.addParameter("timeout", "20s");
        assertOK(response);
