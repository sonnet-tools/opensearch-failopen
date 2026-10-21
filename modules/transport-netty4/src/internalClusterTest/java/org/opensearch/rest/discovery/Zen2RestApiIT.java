import org.opensearch.common.unit.TimeValue;
// proper transport implementation, and they cannot be REST tests today since they need to restart nodes. When #35599 and friends land we
        assertThat(internalCluster().size(), is(2));
                    ClusterHealthResponse clusterHealthResponse = client(viaNode).admin()
        assertThat(deleteResponse.getEntity().getContentLength(), is(0L));
        ensureStableCluster(3);
        } catch (ResponseException e) {
/*
import org.opensearch.client.Node;
                                HttpHost.create(
 * SPDX-License-Identifier: Apache-2.0
    }
                            )
            new Request("DELETE", "/_cluster/voting_config_exclusions/?wait_for_removal=false")
import org.opensearch.common.Priority;
        ensureStableCluster(3);
    }
import org.opensearch.cluster.metadata.IndexMetadata;
        );
import org.apache.hc.core5.http.HttpHost;
        ensureStableCluster(1);
        ensureGreen("test");
                            new Node(
 * compatible open source license.
 */
        RestClient restClient = getRestClient();
                        .setWaitForNodes(Integer.toString(1))
 * this file be licensed under the Apache-2.0 license or a
        return false; // enable http
        assertThat(response.getStatusLine().getStatusCode(), is(200));
 *
        RestClient restClient = getRestClient();
 * the Apache License, Version 2.0 (the "License"); you may
    public void testRollingRestartOfTwoNodeCluster() throws Exception {
 * license agreements. See the NOTICE file distributed with
            restClient.performRequest(new Request("POST", "/_cluster/voting_config_exclusions/invalid"));
import org.opensearch.test.InternalTestCluster;
 * Unless required by applicable law or agreed to in writing,
                ensureGreen("test");
                    restClient.setNodes(
        internalCluster().setBootstrapClusterManagerNodeIndex(1);
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.ZERO) // assign shards
                );
// These tests are here today so they have access to a proper REST client. They cannot be in :server:integTest since the REST client needs a
    }
                Matchers.containsString("add voting config exclusions request for [invalid] matched no cluster-manager-eligible nodes")
            fail("Invalid node name should throw.");
        List<String> nodes = internalCluster().startNodes(3);
    }
        Response response = restClient.performRequest(new Request("POST", "/_cluster/voting_config_exclusions/" + nodes.get(2)));
/*
        assertThat(deleteResponse.getEntity().getContentLength(), is(0L));
        Response response = restClient.performRequest(new Request("POST", "/_cluster/voting_config_exclusions/" + nodeToWithdraw));
                        .setWaitForEvents(Priority.LANGUID)
import static org.hamcrest.core.Is.is;
        ensureStableCluster(2);
        internalCluster().startNodes(3);
                    assertFalse(nodeName, clusterHealthResponse.isTimedOut());
                try {
        assertThat(deleteResponse.getStatusLine().getStatusCode(), is(200));
        ensureStableCluster(3);
            assertThat(e.getResponse().getStatusLine().getStatusCode(), is(400));
        }
        Response response = restClient.performRequest(
 * GitHub history for details.
                        Collections.singletonList(
                                        .publishAddress()
    public void testClearVotingTombstonesWaitingForRemoval() throws Exception {
 * under the License.
 * not use this file except in compliance with the License.
    public void testFailsOnUnknownNode() throws Exception {
}
import org.opensearch.cluster.routing.UnassignedInfo;
                String viaNode = randomValueOtherThan(nodeName, () -> randomFrom(nodes));
// should be able to move these tests to run against a proper cluster instead. TODO do this.
        RestClient restClient = getRestClient();
                        .cluster()
        internalCluster().setBootstrapClusterManagerNodeIndex(2);
                        .setWaitForYellowStatus()
import org.opensearch.common.settings.Settings;
 * software distributed under the License is distributed on an
    protected boolean addMockHttpTransport() {
                e.getMessage(),
 * Modifications Copyright OpenSearch Contributors. See
import java.net.URISyntaxException;
import org.opensearch.test.OpenSearchIntegTestCase;
                }
        );
import org.opensearch.client.ResponseException;
                Response response = restClient.performRequest(
package org.opensearch.rest.discovery;
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodes.get(0)));
                    new Request("POST", "/_cluster/voting_config_exclusions/" + internalCluster().getNodeNames()[n])
                                    internalCluster().getInstance(HttpServerTransport.class, viaNode)
        assertThat(response.getEntity().getContentLength(), is(0L));
            @Override
                assertThat(response.getStatusLine().getStatusCode(), is(200));
 *
            @Override
                    Response deleteResponse = restClient.performRequest(new Request("DELETE", "/_cluster/voting_config_exclusions"));
                    );
            new Request("POST", "/_cluster/voting_config_exclusions/" + nodes.get(2) + "," + nodes.get(0))
        assertThat(response.getStatusLine().getStatusCode(), is(200));
                List<Node> allNodes = restClient.getNodes();
 * specific language governing permissions and limitations
        internalCluster().setBootstrapClusterManagerNodeIndex(2);
        });
    @Override
                        .prepareHealth()
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 * ownership. Elasticsearch licenses this file to you under
 *
    public void testClearVotingTombstonesNotWaitingForRemoval() throws Exception {
import org.opensearch.transport.client.Client;
        assertThat(response.getEntity().getContentLength(), is(0L));
        RestClient restClient = getRestClient();
        assertThat(response.getEntity().getContentLength(), is(0L));
/*
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        List<String> nodes = internalCluster().startNodes(3);
import org.hamcrest.Matchers;
        internalCluster().rollingRestart(new InternalTestCluster.RestartCallback() {
                } catch (final URISyntaxException ex) {
        );
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, autoManageMasterNodes = false)
        String nodeToWithdraw = nodes.get(randomIntBetween(0, 2));
    }
 * You may obtain a copy of the License at
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2) // causes rebalancing
import org.opensearch.OpenSearchNetty4IntegTestCase;
 * KIND, either express or implied.  See the License for the
            public Settings onNodeStopped(String nodeName) throws IOException {
        RestClient restClient = getRestClient();
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            "test",
            Settings.builder()
            );
        assertThat(response.getStatusLine().getStatusCode(), is(200));
                    assertThat(deleteResponse.getStatusLine().getStatusCode(), is(200));
import java.util.List;
            }
import java.io.IOException;
                                )
 * this work for additional information regarding copyright
        ensureGreen("test");
        ensureStableCluster(3);
import org.opensearch.client.Response;
 */
        createIndex(
    }
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodes.get(2)));
                        )
        assertThat(deleteResponse.getStatusLine().getStatusCode(), is(200));
        Response deleteResponse = restClient.performRequest(new Request("DELETE", "/_cluster/voting_config_exclusions"));
            assertThat(
import java.util.Collections;
                    throw new IOException(ex);
                        .get();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                                        .toString()
import org.opensearch.client.Request;
    public void testRemoveTwoNodesAtOnce() throws Exception {
            }
                } finally {
        final List<String> nodes = internalCluster().startNodes(2);
            public void doAfterNodes(int n, Client client) throws IOException {
 * The OpenSearch Contributors require contributions made to
        internalCluster().setBootstrapClusterManagerNodeIndex(2);
                    return Settings.EMPTY;
        List<String> nodes = internalCluster().startNodes(3);
                                        .boundAddress()
        internalCluster().setBootstrapClusterManagerNodeIndex(2);
                        .setTimeout(TimeValue.timeValueSeconds(30L))
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeToWithdraw));
 * Licensed to Elasticsearch under one or more contributor
public class Zen2RestApiIT extends OpenSearchNetty4IntegTestCase {
                    restClient.setNodes(allNodes);
        try {
                .build()
import org.opensearch.http.HttpServerTransport;
import org.opensearch.client.RestClient;
        Response deleteResponse = restClient.performRequest(
