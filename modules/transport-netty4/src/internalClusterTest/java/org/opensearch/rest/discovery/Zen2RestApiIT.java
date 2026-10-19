        assertThat(response.getStatusLine().getStatusCode(), is(200));
                    Response deleteResponse = restClient.performRequest(new Request("DELETE", "/_cluster/voting_config_exclusions"));  
                    assertThat(deleteResponse.getStatusLine().getStatusCode(), is(200));
            fail("Invalid node name should throw.");
import org.opensearch.http.HttpServerTransport;
        RestClient restClient = getRestClient();
        ensureGreen("test");
                            new Node(
        List<String> nodes = internalCluster().startNodes(3);  
        internalCluster().rollingRestart(new InternalTestCluster.RestartCallback() {
                        .setWaitForYellowStatus()  
                .build()
// These tests are here today so they have access to a proper REST client. They cannot be in :server:integTest since the REST client needs a  
        );
        }  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;  
 * specific language governing permissions and limitations
import org.opensearch.client.Node;
                                )
    public void testRemoveTwoNodesAtOnce() throws Exception {  
    }
                        .cluster()
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
import java.util.Collections;
    public void testClearVotingTombstonesNotWaitingForRemoval() throws Exception {
// should be able to move these tests to run against a proper cluster instead. TODO do this.
        });
        internalCluster().setBootstrapClusterManagerNodeIndex(2);
        } catch (ResponseException e) {  
        assertThat(response.getStatusLine().getStatusCode(), is(200));
 * license agreements. See the NOTICE file distributed with
        RestClient restClient = getRestClient();
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        final List<String> nodes = internalCluster().startNodes(2);
        );  
 * You may obtain a copy of the License at  
                                    internalCluster().getInstance(HttpServerTransport.class, viaNode)
                    );
import org.opensearch.common.Priority;
        ensureStableCluster(3);
        assertThat(internalCluster().size(), is(2));
                                HttpHost.create(  
            Settings.builder()
            restClient.performRequest(new Request("POST", "/_cluster/voting_config_exclusions/invalid"));
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.client.ResponseException;
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodes.get(2)));
    }
        internalCluster().setBootstrapClusterManagerNodeIndex(2);
        RestClient restClient = getRestClient();
import org.opensearch.common.settings.Settings;  
                    return Settings.EMPTY;  
 * Licensed to Elasticsearch under one or more contributor  
            }  
 * under the License.  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, autoManageMasterNodes = false)  
import org.opensearch.client.RestClient;
                Matchers.containsString("add voting config exclusions request for [invalid] matched no cluster-manager-eligible nodes")
            public void doAfterNodes(int n, Client client) throws IOException {
    }  
            public Settings onNodeStopped(String nodeName) throws IOException {
                    new Request("POST", "/_cluster/voting_config_exclusions/" + internalCluster().getNodeNames()[n])
        List<String> nodes = internalCluster().startNodes(3);  
        internalCluster().setBootstrapClusterManagerNodeIndex(1);  
 * software distributed under the License is distributed on an
                } catch (final URISyntaxException ex) {
            new Request("DELETE", "/_cluster/voting_config_exclusions/?wait_for_removal=false")
 * this file be licensed under the Apache-2.0 license or a
/*  
    public void testClearVotingTombstonesWaitingForRemoval() throws Exception {
                        )
                List<Node> allNodes = restClient.getNodes();
import java.io.IOException;
        try {  
/*
                e.getMessage(),  
import org.opensearch.common.unit.TimeValue;
                                        .toString()
import org.opensearch.test.InternalTestCluster;  
        ensureStableCluster(3);
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.OpenSearchNetty4IntegTestCase;
 * GitHub history for details.
                        .prepareHealth()
import java.util.List;
                }
        assertThat(deleteResponse.getEntity().getContentLength(), is(0L));
            assertThat(
            new Request("POST", "/_cluster/voting_config_exclusions/" + nodes.get(2) + "," + nodes.get(0))  
    }
        ensureStableCluster(2);
        RestClient restClient = getRestClient();
                        .setWaitForNodes(Integer.toString(1))
                String viaNode = randomValueOtherThan(nodeName, () -> randomFrom(nodes));
}
        internalCluster().startNodes(3);  
                Response response = restClient.performRequest(  
        assertThat(response.getEntity().getContentLength(), is(0L));  
    public void testRollingRestartOfTwoNodeCluster() throws Exception {
                );
        assertThat(response.getEntity().getContentLength(), is(0L));
                    assertFalse(nodeName, clusterHealthResponse.isTimedOut());
 */  
 * The OpenSearch Contributors require contributions made to  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2) // causes rebalancing  
            @Override  
                        .get();
        assertThat(deleteResponse.getStatusLine().getStatusCode(), is(200));  
            @Override  
public class Zen2RestApiIT extends OpenSearchNetty4IntegTestCase {
    }
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.ZERO) // assign shards
import org.opensearch.cluster.routing.UnassignedInfo;
        List<String> nodes = internalCluster().startNodes(3);
    @Override  
import org.opensearch.transport.client.Client;
// proper transport implementation, and they cannot be REST tests today since they need to restart nodes. When #35599 and friends land we
import org.opensearch.cluster.metadata.IndexMetadata;  
                    restClient.setNodes(  
        assertThat(deleteResponse.getEntity().getContentLength(), is(0L));
import java.net.URISyntaxException;  
                assertThat(response.getStatusLine().getStatusCode(), is(200));  
            }
 * Modifications Copyright OpenSearch Contributors. See
        RestClient restClient = getRestClient();  
            );
        Response deleteResponse = restClient.performRequest(  
        Response response = restClient.performRequest(new Request("POST", "/_cluster/voting_config_exclusions/" + nodeToWithdraw));
import org.hamcrest.Matchers;  
    }
        assertThat(response.getEntity().getContentLength(), is(0L));  
            "test",  
        String nodeToWithdraw = nodes.get(randomIntBetween(0, 2));  
                                        .publishAddress()  
        assertThat(response.getStatusLine().getStatusCode(), is(200));
                        .setWaitForEvents(Priority.LANGUID)  
                    ClusterHealthResponse clusterHealthResponse = client(viaNode).admin()  
                    restClient.setNodes(allNodes);
import org.opensearch.client.Request;
        ensureStableCluster(3);
        );
 *
        internalCluster().setBootstrapClusterManagerNodeIndex(2);
        assertThat(deleteResponse.getStatusLine().getStatusCode(), is(200));  
        return false; // enable http
            assertThat(e.getResponse().getStatusLine().getStatusCode(), is(400));
        createIndex(
                        Collections.singletonList(
 *
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testFailsOnUnknownNode() throws Exception {
    protected boolean addMockHttpTransport() {
        ensureStableCluster(3);  
/*  
                try {
                    throw new IOException(ex);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeToWithdraw));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
                        .setTimeout(TimeValue.timeValueSeconds(30L))
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodes.get(0)));
import static org.hamcrest.core.Is.is;
        Response deleteResponse = restClient.performRequest(new Request("DELETE", "/_cluster/voting_config_exclusions"));
        Response response = restClient.performRequest(
        Response response = restClient.performRequest(new Request("POST", "/_cluster/voting_config_exclusions/" + nodes.get(2)));  
import org.opensearch.client.Response;  
                                        .boundAddress()
import org.apache.hc.core5.http.HttpHost;
        ensureStableCluster(1);  
                ensureGreen("test");
                } finally {  
 * SPDX-License-Identifier: Apache-2.0
 *  
 * this work for additional information regarding copyright
        internalCluster().setBootstrapClusterManagerNodeIndex(2);
                            )  
package org.opensearch.rest.discovery;
 * KIND, either express or implied.  See the License for the
        ensureGreen("test");  
 */  
