import java.util.concurrent.atomic.AtomicReference;  
        assertOK(deleteResponse);
    }
        assertOK(response);
                + "      \"number_of_shards\": 1,"  
            .build();
        List<Object> indices = mapView.get("dangling_indices");
            if (elements[1].equals(nodeName)) {  
            .put(WRITE_DANGLING_INDICES_INFO_SETTING.getKey(), true)  
                + "}";  
public class DanglingIndicesRestIT extends HttpSmokeTestCase {  
        private final Map<String, String> indexToUUID;  
                }  
        assertThat(mapView.get("dangling_indices.0.index_uuid"), equalTo(danglingIndexDetails.indexToUUID.get(INDEX_NAME)));  
    private Settings buildSettings(int maxTombstones) {
     * the cluster is stopped. The deletion of the second pushes the deletion
        assertBusy(() -> assertThat("Expected dangling index to be deleted", listDanglingIndexIds(), hasSize(0)));  
        final String stoppedNodeId = mapNodeNameToId(danglingIndexDetails.stoppedNodeName);
import org.opensearch.test.OpenSearchIntegTestCase;
        final List<String> danglingIndexIds = listDanglingIndexIds();
import org.opensearch.client.RestClient;  
        assertThat(mapView.get("acknowledged"), equalTo(true));
 * Licensed to Elasticsearch under one or more contributor  
        createIndex("additional");  
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.core.rest.RestStatus.OK;  
 * @see org.opensearch.action.admin.indices.dangling  
        final XContentTestUtils.JsonMapView mapView = createJsonMapView(response.getEntity().getContent());  
/**
import java.util.HashMap;  
        for (int i = 0; i < indices.size(); i++) {
            String indexSettings = "{"  
     */
        final XContentTestUtils.JsonMapView mapView = createJsonMapView(deleteResponse.getEntity().getContent());  
 *
                return elements[0];
    /**
        assertThat(listDanglingIndexIds(), is(empty()));
 * software distributed under the License is distributed on an
            // Limit the indices kept in the graveyard. This can be set to zero, so that  
        assertThat(mapView.get("dangling_indices.0.creation_date_millis"), instanceOf(Long.class));
    private Map<String, String> createIndices(String... indices) throws IOException {
        internalCluster().setBootstrapClusterManagerNodeIndex(1);  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
     * will be considered dangling, and can therefore be listed and
import org.opensearch.common.io.Streams;
@ClusterScope(numDataNodes = 0, scope = OpenSearchIntegTestCase.Scope.TEST, autoManageMasterNodes = false)
            }
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
        }  
        deleteRequest.addParameter("timeout", "20s");
 * today so they have access to a proper REST client. They cannot be in
/*  
        assertThat(mapView.get("dangling_indices.0.node_ids.0"), equalTo(stoppedNodeId));
        return danglingIndexIds;
        importRequest.addParameter("timeout", "20s");
    /**  
        final AtomicReference<String> stoppedNodeName = new AtomicReference<>();
        }
                ensureClusterSizeConsistency();
            public Settings onNodeStopped(String nodeName) throws Exception {
        internalCluster().startNodes(3, buildSettings(0));
     */
                + "      \"routing\": {"
                + "          \"total_shards_per_node\": 1"
 *
        assertThat(mapView.get("_nodes.failed"), equalTo(0));  
    }  
     * only the second index will be found into the graveyard and the other
        internalCluster().setBootstrapClusterManagerNodeIndex(1);  
import org.opensearch.indices.IndicesService;  
                    deleteIndex(index);
     * 1, then create two indices and delete them both while one node in
     * Check that dangling indices can be imported.  
import static org.opensearch.test.XContentTestUtils.createJsonMapView;
import static org.hamcrest.Matchers.is;  
import static org.opensearch.gateway.DanglingIndicesState.AUTO_IMPORT_DANGLING_INDICES_SETTING;  
        assertThat(mapView.get("_nodes.successful"), equalTo(3));
        }  
        );
        assertThat("Expected to find as many index UUIDs as created indices", createdIndexIDs.size(), equalTo(indices.length));  
                for (String index : indices) {
        importRequest.addParameter("cluster_manager_timeout", "20s");
            String[] elements = indexLine.split(" +");  
     * Helper that creates one or more indices, and importantly,  
 * not use this file except in compliance with the License.
        final Request importRequest = new Request("POST", "/_dangling/" + danglingIndexIds.get(0));
        ensureGreen(indices);
        Response deleteResponse = getRestClient().performRequest(new Request("DELETE", "/" + indexName));  
     * greater than 1. To test deletes, we set the index graveyard size to  
        assert indices.length > 0;  
import java.io.IOException;  
        return Settings.builder()
 * this work for additional information regarding copyright
        List<String> danglingIndexIds = new ArrayList<>();
        final RestClient restClient = getRestClient();
        final Response catResponse = getRestClient().performRequest(new Request("GET", "/_cat/indices?h=index,uuid"));
        for (String nodeLine : Streams.readAllLines(catResponse.getEntity().getContent())) {
     * checks that they are green before proceeding. This is important
     * deleted through the API  
            // when we delete an index, it's definitely considered to be dangling.
        createDanglingIndices(INDEX_NAME);  
        assertOK(catResponse);
    private DanglingIndexDetails createDanglingIndices(String... indices) throws Exception {
    /**  
        final Response importResponse = restClient.performRequest(importRequest);  
                .forEach(indicesService -> assertTrue(indicesService.allPendingDanglingIndicesWritten()))  
        return new DanglingIndexDetails(stoppedNodeName.get(), indexToUUID);
        final List<String> indicesAsList = Arrays.asList(indices);  
    }  
import static org.opensearch.cluster.metadata.IndexGraveyard.SETTING_MAX_TOMBSTONES;
        importRequest.addParameter("accept_data_loss", "true");
    private void deleteIndex(String indexName) throws IOException {
        // not cause the deleted dangling index to be considered "live" again, just because its
            .put(SETTING_MAX_TOMBSTONES.getKey(), maxTombstones)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static final String OTHER_INDEX_NAME = INDEX_NAME + "-other";
    private static final String INDEX_NAME = "test-idx-1";
            }
        assertThat(indices, hasSize(1));  
            @Override  
     */
    private List<String> listDanglingIndexIds() throws IOException {
import org.opensearch.test.XContentTestUtils;
     * that each index has a primary or replica shard on every node, and if  
    /**
 */
        assertThat(response.getStatusLine().getStatusCode(), equalTo(OK.getStatus()));  
            .put(AUTO_IMPORT_DANGLING_INDICES_SETTING.getKey(), false)
        internalCluster().startNodes(3, buildSettings(0));
    }
        }
        final XContentTestUtils.JsonMapView mapView = createJsonMapView(importResponse.getEntity().getContent());  
        // creating and deleting another index, which creates a new tombstone entry, which should  
        final Map<String, String> createdIndexIDs = new HashMap<>();
    }  
        throw new AssertionError("Failed to map node name [" + nodeName + "] to node ID");
package org.opensearch.http;
            this.stoppedNodeName = stoppedNodeName;  
/*
 * SPDX-License-Identifier: Apache-2.0
        assertThat(mapView.get("_nodes.successful"), equalTo(3));  
                + "        }"
 * license agreements. See the NOTICE file distributed with
        deleteRequest.addParameter("accept_data_loss", "true");
import org.opensearch.client.Response;
import java.util.Arrays;
            Request request = new Request("PUT", "/" + index);
        private final String stoppedNodeName;
import java.util.ArrayList;
 * The OpenSearch Contributors require contributions made to  
        final Response response = getRestClient().performRequest(new Request("GET", "/_dangling"));  
        List<Object> indices = mapView.get("dangling_indices");  
 * under the License.  
        ensureStableCluster(3);
import org.opensearch.test.InternalTestCluster;  
                + "  \"settings\": {"
            danglingIndexIds.add(mapView.get("dangling_indices." + i + ".index_uuid"));
 * :server:integTest since the REST client needs a proper transport
 */  
import org.opensearch.common.settings.Settings;
                + "      \"number_of_replicas\": 2,"
 * implementation, and they cannot be REST tests today since they need to  
     *
                + "      }"  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
     * of the first out of the graveyard. When the stopped node is resumed,  
        return createdIndexIDs;
        assertThat(danglingIndexIds, hasSize(1));
    public void testDanglingIndicesCanBeListed() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
 *
        final XContentTestUtils.JsonMapView mapView = createJsonMapView(listResponse.getEntity().getContent());
            String[] elements = nodeLine.split(" ");
            request.setJsonEntity(indexSettings);
        internalCluster().startNodes(3, buildSettings(1));
     */
import org.opensearch.client.Request;
     * we add an entry to the index graveyard, the graveyard size must be
        assertOK(listResponse);  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testDanglingIndicesCanBeDeleted() throws Exception {
                stoppedNodeName.set(nodeName);  
        deleteRequest.addParameter("cluster_manager_timeout", "20s");
            }  
}
     * Check that dangling indices can be deleted. Since this requires that
        final Request deleteRequest = new Request("DELETE", "/_dangling/" + danglingIndexIds.get(0));
    private void assertOK(Response response) {
        final Response catResponse = getRestClient().performRequest(new Request("GET", "/_cat/nodes?full_id&h=id,name"));
    }  
     */
import java.util.Map;
        DanglingIndexDetails(String stoppedNodeName, Map<String, String> indexToUUID) {
 */
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
     * a node is stopped prematurely, this assumption is broken.
    }  
 * You may obtain a copy of the License at  
     * Check that when dangling indices are discovered, then they can be listed via the REST API.  
        assertThat(mapView.get("_nodes.total"), equalTo(3));
                createdIndexIDs.put(elements[0], elements[1]);
    private String mapNodeNameToId(String nodeName) throws IOException {  
import static org.opensearch.core.rest.RestStatus.ACCEPTED;
            () -> internalCluster().getInstances(IndicesService.class)
        internalCluster().setBootstrapClusterManagerNodeIndex(1);  
import static org.hamcrest.Matchers.empty;
        });  
        assertThat(danglingIndexIds, hasSize(1));
import static org.opensearch.indices.IndicesService.WRITE_DANGLING_INDICES_INFO_SETTING;
        createDanglingIndices(INDEX_NAME, OTHER_INDEX_NAME);  
     * Given a node name, finds the corresponding node ID.
        // Ensure these parameters is accepted  
        for (String index : indices) {
    /**
    }
 */  
        assertBusy(
 * This class tests the dangling indices REST API.  These tests are here  
                + "    }"
        assertThat(mapView.get("acknowledged"), equalTo(true));
                + "        \"allocation\": {"  
        ensureStableCluster(3);
    private static class DanglingIndexDetails {
     * @return a mapping from each created index name to its UUID  
        for (String indexLine : Streams.readAllLines(catResponse.getEntity().getContent())) {
        // Restart node, deleting the index in its absence, so that there is a dangling index to recover  
    }
        final DanglingIndexDetails danglingIndexDetails = createDanglingIndices(INDEX_NAME);  
        final List<String> danglingIndexIds = listDanglingIndexIds();
        final Response deleteResponse = restClient.performRequest(deleteRequest);  
            if (indicesAsList.contains(elements[0])) {
        }
        deleteIndex("additional");
import java.util.List;
        assertThat(mapView.get("_nodes.total"), equalTo(3));
                + "    \"index\": {"
        assertTrue("Expected dangling index " + INDEX_NAME + " to be recovered", indexExists(INDEX_NAME));  
 * restart nodes. Really, though, this test should live elsewhere.
        assertThat(deleteResponse.getStatusLine().getStatusCode(), equalTo(ACCEPTED.getStatus()));
        final RestClient restClient = getRestClient();
    }  
        final RestClient restClient = getRestClient();  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
        assertThat(mapView.get("dangling_indices.0.index_name"), equalTo(INDEX_NAME));
    public void testDanglingIndicesCanBeImported() throws Exception {
     * because the tests in this class stop and restart nodes, assuming
        // Ensure this parameter is accepted  
        final Map<String, String> indexToUUID = createIndices(indices);  
import static org.hamcrest.Matchers.equalTo;  
 * GitHub history for details.
            this.indexToUUID = indexToUUID;
import static org.hamcrest.Matchers.hasSize;
                + "  }"
            assertOK(getRestClient().performRequest(request));  
        assertThat(importResponse.getStatusLine().getStatusCode(), equalTo(ACCEPTED.getStatus()));
                return super.onNodeStopped(nodeName);
import static org.hamcrest.Matchers.instanceOf;
        assertOK(catResponse);
        // tombstone has been pushed out of the graveyard.
        assertThat(mapView.get("_nodes.failed"), equalTo(0));
    }  
        // The dangling index that we deleted ought to have been removed from disk. Check by
        final Response listResponse = restClient.performRequest(new Request("GET", "/_dangling"));
 *  
