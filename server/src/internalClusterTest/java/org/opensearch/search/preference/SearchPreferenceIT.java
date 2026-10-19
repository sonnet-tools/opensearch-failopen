                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, replicasInNewIndex - 1))
            client().prepareSearch().setQuery(matchAllQuery()).setPreference("_only_nodes:DOES-NOT-EXIST").get();
                .prepareUpdateSettings("test2")
        assertAcked(
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().get();
        ensureGreen();
            "_primary",
        client().admin().cluster().prepareHealth().setWaitForStatus(ClusterHealthStatus.RED).get();
        assertAcked(
        assertAcked(
import org.opensearch.action.search.SearchResponse;
        }
import static org.hamcrest.Matchers.equalTo;
            .get()
        assertSearchOnRandomNodes(request);
        String[] preferences = new String[] {
        node_expr = "_only_nodes:" + Strings.arrayToCommaDelimitedString(allNodeNames.toArray());
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        );
            client().admin()
        Set<String> hitNodes = new HashSet<>();
            prepareCreate("test").setSettings(
            SearchResponse searchResponse = client().prepareSearch().setSize(0).setPreference(pref).get();
        assertAcked(
        searchResponse = client.prepareSearch("test").setQuery(matchAllQuery()).get();
    }
        indexRandomForConcurrentSearch("test2");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import static org.hamcrest.CoreMatchers.containsString;
        );
    }
        final Client client = internalCluster().smartClient();
    }
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
        ArrayList<String> allNodeNames = new ArrayList<>();
        assertSearchesSpecificNode("test", customPreference, nodeId);
        client().prepareIndex("test").setSource("field1", "value1").get();
        node_expr = "_only_nodes:*,invalidnode";
        refresh();
        refresh();
    }
            SearchResponse searchResponse = request.get();
            allNodeHosts.add(node.getHostname());
 */
            "_prefer_nodes:somenode,server2" };
                Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_REPLICAS, between(1, maximumNumberOfReplicas()))
    }
            .getShard()
    }
import static org.hamcrest.Matchers.greaterThan;
                Settings.builder()
            assertThat(e, hasToString(containsString("no data nodes with criteria [DOES-NOT-EXIST] found for shard: [test][")));
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * KIND, either express or implied.  See the License for the
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setPreference("_primary_first").execute().actionGet();
        ArrayList<String> allNodeIds = new ArrayList<>();
            allNodeNames.add(node.getNode().getName());
        refresh();
import java.util.Set;
        assertSearchesSpecificNode("test", customPreference, nodeId);
        }
/*
 *
import org.opensearch.test.OpenSearchIntegTestCase;
        } catch (IllegalArgumentException e) {
            "_local",
    }
        super(staticSettings);
 * SPDX-License-Identifier: Apache-2.0
            assertThat(pref, searchResponse.getFailedShards(), greaterThanOrEqualTo(0));
 * not use this file except in compliance with the License.
                .prepareUpdateSettings("test2")
package org.opensearch.search.preference;
            fail("Expected IllegalArgumentException");
        assertSearchOnRandomNodes(request);
            )
 * GitHub history for details.
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
import org.opensearch.core.rest.RestStatus;
        SearchRequestBuilder request = client.prepareSearch("test").setQuery(matchAllQuery()).setPreference("_only_nodes:*,nodes*");
 * Modifications Copyright OpenSearch Contributors. See
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 2)
        SearchResponse searchResponse = dataNodeClient().prepareSearch().setSize(0).setPreference("_only_local").get();
    public Settings nodeSettings(int nodeOrdinal) {
            .put(OperationRouting.USE_ADAPTIVE_REPLICA_SELECTION_SETTING.getKey(), false)
        for (int i = 0; i < 2; i++) {
        ensureGreen();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        return Settings.builder()
    }
        try {
 * compatible open source license.
        assertAcked(
        client().prepareIndex("test").setSource("field1", "value1").get();
                        .put(
        String secondNodeId = searchResponse.getHits().getAt(0).getShard().getNodeId();
                    .put(indexSettings())
 * this work for additional information regarding copyright
    public static Collection<Object[]> parameters() {
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        ensureGreen();
import org.opensearch.node.Node;
        request = client.prepareSearch("test").setQuery(matchAllQuery()).setPreference(node_expr);
        assertSearchOnRandomNodes(request);
        indexRandomForConcurrentSearch("test");
        node_expr = "_only_nodes:" + Strings.arrayToCommaDelimitedString(allNodeHosts.toArray());
        assertSearchOnRandomNodes(request);
        );
        final String nodeId = client().prepareSearch("test")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        indexRandomForConcurrentSearch("test");
                    .put(SETTING_NUMBER_OF_REPLICAS, between(1, maximumNumberOfReplicas()))
    public void testSimplePreference() throws InterruptedException {
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                        )
                .indices()
        client().prepareIndex("test").setSource("field1", "value1").get();
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setPreference("_primary").execute().actionGet();
            logger.info("--> Testing out preference={}", pref);
import java.util.Arrays;
        ArrayList<String> allNodeHosts = new ArrayList<>();
        assertAcked(client().admin().indices().prepareDelete("test2"));
        for (String pref : preferences) {
            "_prefer_nodes:server2",
         * Custom preferences can be used to encourage searches to go to a consistent set of shard copies, meaning that other copies' data
        String node_expr = "_only_nodes:" + Strings.arrayToCommaDelimitedString(allNodeIds.toArray());
            assertThat(RestStatus.OK, equalTo(searchResponse.status()));
        indexRandomForConcurrentSearch("test");
            )
        final Client client = internalCluster().smartClient();
 * The OpenSearch Contributors require contributions made to
        assertAcked(
                        .put(SETTING_NUMBER_OF_REPLICAS, 0)
                .indices()
import org.opensearch.common.settings.Settings;
    // see #2896
                Settings.builder().put("index.number_of_shards", cluster().numDataNodes() + 2).put("index.number_of_replicas", 0)
            allNodeIds.add(node.getNode().getId());
import org.opensearch.core.common.Strings;
        assertSearchOnRandomNodes(request);
public class SearchPreferenceIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    private void assertSearchOnRandomNodes(SearchRequestBuilder request) {
        }
        refresh();
            prepareCreate("test2").setSettings(Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_REPLICAS, replicasInNewIndex))
        ensureGreen();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setPreference("_replica_first").execute().actionGet();
 * this file be licensed under the Apache-2.0 license or a
            .getHits()
        ensureGreen();
        request = client.prepareSearch("test").setQuery(matchAllQuery()).setPreference(node_expr);
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            hitNodes.add(searchResponse.getHits().getAt(0).getShard().getNodeId());
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setPreference("1234").execute().actionGet();
import org.opensearch.action.search.SearchRequestBuilder;
    }
 * Licensed to Elasticsearch under one or more contributor
        assertSearchesSpecificNode("test", customPreference, nodeId);
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setPreference("_replica").execute().actionGet();
 *    http://www.apache.org/licenses/LICENSE-2.0
        // multiple wildchar to cover multi-param usecase
        assertThat("_only_local", searchResponse.getFailedShards(), greaterThanOrEqualTo(0));
                            internalCluster().getDataNodeInstance(Node.class).settings().get(Node.NODE_NAME_SETTING.getKey())
 *
            prepareCreate("test").setSettings(
        final String customPreference = randomAlphaOfLength(10);
         * is rarely touched and can be dropped from the filesystem cache. This works best if the set of shards searched doesn't change
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import static org.hamcrest.Matchers.not;
            .build();
        return Arrays.asList(
    }
                            IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_PREFIX + "._name",
        assertThat("_only_local", searchResponse.getFailedShards(), greaterThanOrEqualTo(0));
        assertSearchOnRandomNodes(request);
        assertSearchesSpecificNode("test", customPreference, nodeId);
        );
        client().prepareIndex("test").setSource("field1", "value1").get();
        final SearchResponse searchResponse = client().prepareSearch(index).setQuery(matchAllQuery()).setPreference(customPreference).get();
import org.opensearch.cluster.health.ClusterHealthStatus;
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
        for (NodeStats node : nodeStats.getNodes()) {
    @Override
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
         * unnecessarily, so this test verifies a consistent routing even as other shards are created/relocated/removed.
 * Unless required by applicable law or agreed to in writing,
                )
import java.util.HashSet;
 * under the License.
        }
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setPreference("_local").execute().actionGet();
                    Settings.builder()
            client().prepareIndex("test").setId("" + i).setSource("field1", "value1").get();
            )
import org.opensearch.transport.client.Client;
    @ParametersFactory
import java.util.ArrayList;
    public void testNoPreferenceRandom() throws Exception {
            )
        ensureGreen();
 */
        assertThat(RestStatus.OK, equalTo(searchResponse.status()));
        request = client.prepareSearch("test").setQuery(matchAllQuery()).setPreference(node_expr);
            "_prefer_nodes:somenode",
            .put(super.nodeSettings(nodeOrdinal))
        SearchResponse searchResponse = client().prepareSearch().setQuery(matchAllQuery()).get();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
                // this test needs at least a replica to make sure two consecutive searches go to two different copies of the same data
}
        for (int i = 0; i < 10; i++) {
            client().admin()
    public void testThatSpecifyingNonExistingNodesReturnsUsefulError() {
        assertSearchesSpecificNode("test", customPreference, nodeId);
/*
        // Mix of valid and invalid nodes
        request = client.prepareSearch("test").setQuery(matchAllQuery()).setPreference(node_expr);
            "_primary_first",
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        // _only_local is a stricter preference, we need to send the request to a data node
 * ownership. Elasticsearch licenses this file to you under
/*
                Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_REPLICAS, between(1, maximumNumberOfReplicas()))
        SearchResponse searchResponse = client.prepareSearch("test").setQuery(matchAllQuery()).get();
            searchResponse = client().prepareSearch().setPreference(pref).get();
    }
        node_expr = "_only_nodes:" + Strings.arrayToCommaDelimitedString(allNodeHosts.toArray());
            .setPreference(customPreference)
        indexRandomForConcurrentSearch("test");
            assertThat(pref, searchResponse.getFailedShards(), greaterThanOrEqualTo(0));
            prepareCreate("test").setSettings(
                    .put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)
        );
import static org.hamcrest.Matchers.hasToString;
        searchResponse = dataNodeClient().prepareSearch().setPreference("_only_local").get();
            assertThat(searchResponse.getHits().getHits().length, greaterThan(0));
        ensureGreen();
import java.util.Collection;
    public void testStopOneNodePreferenceWithRedState() throws Exception {
    private static void assertSearchesSpecificNode(String index, String customPreference, String nodeId) {
        assertAcked(
 * software distributed under the License is distributed on an
import org.opensearch.cluster.routing.OperationRouting;
        assertThat(RestStatus.OK, equalTo(searchResponse.status()));
 * You may obtain a copy of the License at
            .getAt(0)
        );
        request = client.prepareSearch("test").setQuery(matchAllQuery()).setPreference("_only_nodes:*");
    public void testCustomPreferenceUnaffectedByOtherShardMovements() throws InterruptedException {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        assertSearchOnRandomNodes(request);
            .setQuery(matchAllQuery())
                // this test needs at least a replica to make sure two consecutive searches go to two different copies of the same data
        refresh();
        );
 */
    public SearchPreferenceIT(Settings staticSettings) {
         */
        internalCluster().stopRandomDataNode();
        final int replicasInNewIndex = between(1, maximumNumberOfReplicas());
            .getNodeId();
 * specific language governing permissions and limitations
        ensureGreen();
        indexRandomForConcurrentSearch("test");
        assertThat(hitNodes.size(), greaterThan(1));
    public void testNodesOnlyRandom() throws Exception {
        /*
        String firstNodeId = searchResponse.getHits().getAt(0).getShard().getNodeId();
        assertThat(firstNodeId, not(equalTo(secondNodeId)));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        );
        }
        request = client.prepareSearch("test").setQuery(matchAllQuery()).setPreference(node_expr);
        createIndex("test");
        client().admin().indices().prepareCreate("test").setSettings("{\"number_of_replicas\": 1}", MediaTypeRegistry.JSON).get();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            assertThat(RestStatus.OK, equalTo(searchResponse.status()));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                .setSettings(
import org.opensearch.cluster.metadata.IndexMetadata;
            prepareCreate("test").setSettings(
        assertThat(searchResponse.getHits().getAt(0).getShard().getNodeId(), equalTo(nodeId));
 *
