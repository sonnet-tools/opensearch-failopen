        );
 * this work for additional information regarding copyright
    }
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
}
            .build();  
 * KIND, either express or implied.  See the License for the
         * unnecessarily, so this test verifies a consistent routing even as other shards are created/relocated/removed.
                // this test needs at least a replica to make sure two consecutive searches go to two different copies of the same data
        assertThat(hitNodes.size(), greaterThan(1));  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
 * You may obtain a copy of the License at  
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 2)
            allNodeIds.add(node.getNode().getId());
        ArrayList<String> allNodeNames = new ArrayList<>();
 * SPDX-License-Identifier: Apache-2.0
            .getShard()
        for (int i = 0; i < 10; i++) {
                )  
    }
        // Mix of valid and invalid nodes
            "_prefer_nodes:server2",
        );  
        node_expr = "_only_nodes:" + Strings.arrayToCommaDelimitedString(allNodeNames.toArray());
            assertThat(searchResponse.getHits().getHits().length, greaterThan(0));  
 * compatible open source license.
    @Override
                .prepareUpdateSettings("test2")
/*  
        assertSearchOnRandomNodes(request);
                .indices()  
import org.opensearch.cluster.health.ClusterHealthStatus;
 * Licensed to Elasticsearch under one or more contributor  
        ensureGreen();
        }
import org.opensearch.cluster.metadata.IndexMetadata;
        assertAcked(
        }
        SearchResponse searchResponse = dataNodeClient().prepareSearch().setSize(0).setPreference("_only_local").get();  
    public SearchPreferenceIT(Settings staticSettings) {
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
            .setPreference(customPreference)
        client().admin().indices().prepareCreate("test").setSettings("{\"number_of_replicas\": 1}", MediaTypeRegistry.JSON).get();
        assertAcked(client().admin().indices().prepareDelete("test2"));
 */  
    private static void assertSearchesSpecificNode(String index, String customPreference, String nodeId) {  
        for (NodeStats node : nodeStats.getNodes()) {
        assertThat(searchResponse.getHits().getAt(0).getShard().getNodeId(), equalTo(nodeId));  
        request = client.prepareSearch("test").setQuery(matchAllQuery()).setPreference(node_expr);
                .indices()  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.Strings;  
            "_prefer_nodes:somenode",
    private void assertSearchOnRandomNodes(SearchRequestBuilder request) {
    public void testSimplePreference() throws InterruptedException {  
                        )
    }  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Set;  
        );  
import org.opensearch.common.settings.Settings;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
         * is rarely touched and can be dropped from the filesystem cache. This works best if the set of shards searched doesn't change
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setPreference("_replica_first").execute().actionGet();
            "_primary_first",  
         */  
 * GitHub history for details.
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setPreference("1234").execute().actionGet();
        final SearchResponse searchResponse = client().prepareSearch(index).setQuery(matchAllQuery()).setPreference(customPreference).get();
                        .put(
            .getAt(0)
        searchResponse = dataNodeClient().prepareSearch().setPreference("_only_local").get();  
        assertSearchesSpecificNode("test", customPreference, nodeId);  
    }
        refresh();
        final Client client = internalCluster().smartClient();  
        assertSearchesSpecificNode("test", customPreference, nodeId);
        } catch (IllegalArgumentException e) {
        String secondNodeId = searchResponse.getHits().getAt(0).getShard().getNodeId();
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        refresh();  
            client().prepareIndex("test").setId("" + i).setSource("field1", "value1").get();  
    public void testThatSpecifyingNonExistingNodesReturnsUsefulError() {
        super(staticSettings);
        );
        client().prepareIndex("test").setSource("field1", "value1").get();
    }
                    .put(indexSettings())
            .setQuery(matchAllQuery())  
            prepareCreate("test").setSettings(
            assertThat(pref, searchResponse.getFailedShards(), greaterThanOrEqualTo(0));
                .prepareUpdateSettings("test2")
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
        );
        ensureGreen();  
    }
 * Unless required by applicable law or agreed to in writing,
        request = client.prepareSearch("test").setQuery(matchAllQuery()).setPreference(node_expr);  
        request = client.prepareSearch("test").setQuery(matchAllQuery()).setPreference(node_expr);
import org.opensearch.cluster.routing.OperationRouting;  
import org.opensearch.node.Node;  
        assertSearchOnRandomNodes(request);
            )  
    public Settings nodeSettings(int nodeOrdinal) {
        indexRandomForConcurrentSearch("test");
        node_expr = "_only_nodes:*,invalidnode";  
            .get()
        client().prepareIndex("test").setSource("field1", "value1").get();  
            client().admin()
        createIndex("test");
                            IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_PREFIX + "._name",  
         * Custom preferences can be used to encourage searches to go to a consistent set of shard copies, meaning that other copies' data  
                    Settings.builder()  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        return Arrays.asList(
 */
/*  
            SearchResponse searchResponse = client().prepareSearch().setSize(0).setPreference(pref).get();  
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
                Settings.builder()
    // see #2896  
        ensureGreen();
import static org.hamcrest.Matchers.equalTo;
        node_expr = "_only_nodes:" + Strings.arrayToCommaDelimitedString(allNodeHosts.toArray());
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().get();  
            allNodeHosts.add(node.getHostname());
        ArrayList<String> allNodeIds = new ArrayList<>();  
        client().prepareIndex("test").setSource("field1", "value1").get();
        ensureGreen();
        searchResponse = client.prepareSearch("test").setQuery(matchAllQuery()).get();  
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, replicasInNewIndex - 1))
import org.opensearch.action.search.SearchRequestBuilder;
public class SearchPreferenceIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            assertThat(pref, searchResponse.getFailedShards(), greaterThanOrEqualTo(0));
            prepareCreate("test").setSettings(  
        assertSearchesSpecificNode("test", customPreference, nodeId);
        indexRandomForConcurrentSearch("test");
        request = client.prepareSearch("test").setQuery(matchAllQuery()).setPreference(node_expr);
            assertThat(RestStatus.OK, equalTo(searchResponse.status()));
import static org.hamcrest.Matchers.hasToString;
    public void testStopOneNodePreferenceWithRedState() throws Exception {
                Settings.builder().put("index.number_of_shards", cluster().numDataNodes() + 2).put("index.number_of_replicas", 0)
    }  
            logger.info("--> Testing out preference={}", pref);
        internalCluster().stopRandomDataNode();
        return Settings.builder()  
            assertThat(RestStatus.OK, equalTo(searchResponse.status()));
    public static Collection<Object[]> parameters() {  
        request = client.prepareSearch("test").setQuery(matchAllQuery()).setPreference("_only_nodes:*");  
            )
import static org.hamcrest.CoreMatchers.containsString;  
        assertSearchesSpecificNode("test", customPreference, nodeId);
        SearchRequestBuilder request = client.prepareSearch("test").setQuery(matchAllQuery()).setPreference("_only_nodes:*,nodes*");  
import org.opensearch.core.rest.RestStatus;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
        assertAcked(  
    }
            .put(OperationRouting.USE_ADAPTIVE_REPLICA_SELECTION_SETTING.getKey(), false)
import java.util.HashSet;
            client().admin()
        String firstNodeId = searchResponse.getHits().getAt(0).getShard().getNodeId();
            SearchResponse searchResponse = request.get();
        client().prepareIndex("test").setSource("field1", "value1").get();
            .put(super.nodeSettings(nodeOrdinal))
        node_expr = "_only_nodes:" + Strings.arrayToCommaDelimitedString(allNodeHosts.toArray());  
import org.opensearch.action.admin.cluster.node.stats.NodeStats;  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
 *
        assertAcked(
import java.util.Collection;
            hitNodes.add(searchResponse.getHits().getAt(0).getShard().getNodeId());
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
        refresh();
        );
            prepareCreate("test").setSettings(  
            searchResponse = client().prepareSearch().setPreference(pref).get();  
        assertAcked(
        }
import org.opensearch.test.OpenSearchIntegTestCase;
                .setSettings(
            fail("Expected IllegalArgumentException");
                    .put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setPreference("_primary_first").execute().actionGet();
        for (int i = 0; i < 2; i++) {
            .getHits()  
        request = client.prepareSearch("test").setQuery(matchAllQuery()).setPreference(node_expr);
 */  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        assertThat(RestStatus.OK, equalTo(searchResponse.status()));
import static org.hamcrest.Matchers.not;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
        String node_expr = "_only_nodes:" + Strings.arrayToCommaDelimitedString(allNodeIds.toArray());
        ArrayList<String> allNodeHosts = new ArrayList<>();
 *    http://www.apache.org/licenses/LICENSE-2.0
        final String nodeId = client().prepareSearch("test")
        indexRandomForConcurrentSearch("test");  
    @ParametersFactory
            assertThat(e, hasToString(containsString("no data nodes with criteria [DOES-NOT-EXIST] found for shard: [test][")));  
        for (String pref : preferences) {
            )
        final String customPreference = randomAlphaOfLength(10);  
        assertSearchesSpecificNode("test", customPreference, nodeId);
        try {
 * software distributed under the License is distributed on an
        client().admin().cluster().prepareHealth().setWaitForStatus(ClusterHealthStatus.RED).get();
        refresh();  
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setPreference("_primary").execute().actionGet();
        ensureGreen();  
        SearchResponse searchResponse = client().prepareSearch().setQuery(matchAllQuery()).get();
        assertThat("_only_local", searchResponse.getFailedShards(), greaterThanOrEqualTo(0));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 *  
    public void testCustomPreferenceUnaffectedByOtherShardMovements() throws InterruptedException {  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            "_primary",
 * The OpenSearch Contributors require contributions made to  
    }
        assertAcked(
        }
            .getNodeId();  
            "_prefer_nodes:somenode,server2" };  
        assertSearchOnRandomNodes(request);
import org.opensearch.action.search.SearchResponse;  
                        .put(SETTING_NUMBER_OF_REPLICAS, 0)
        assertSearchOnRandomNodes(request);  
                    .put(SETTING_NUMBER_OF_REPLICAS, between(1, maximumNumberOfReplicas()))  
        ensureGreen();  
        // _only_local is a stricter preference, we need to send the request to a data node
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.search.preference;
        assertAcked(
        refresh();
            "_local",
        );
        }  
 * not use this file except in compliance with the License.
        );  
                // this test needs at least a replica to make sure two consecutive searches go to two different copies of the same data
import java.util.ArrayList;
        // multiple wildchar to cover multi-param usecase
                            internalCluster().getDataNodeInstance(Node.class).settings().get(Node.NODE_NAME_SETTING.getKey())
        final Client client = internalCluster().smartClient();
        ensureGreen();
    }
            prepareCreate("test").setSettings(  
        Set<String> hitNodes = new HashSet<>();  
import org.opensearch.transport.client.Client;  
        indexRandomForConcurrentSearch("test2");  
                Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_REPLICAS, between(1, maximumNumberOfReplicas()))
        assertSearchOnRandomNodes(request);
        /*
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setPreference("_replica").execute().actionGet();
        String[] preferences = new String[] {  
        indexRandomForConcurrentSearch("test");  
            client().prepareSearch().setQuery(matchAllQuery()).setPreference("_only_nodes:DOES-NOT-EXIST").get();  
        assertSearchOnRandomNodes(request);
                Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_REPLICAS, between(1, maximumNumberOfReplicas()))  
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setPreference("_local").execute().actionGet();
 * under the License.  
import java.util.Arrays;  
        indexRandomForConcurrentSearch("test");
 * the Apache License, Version 2.0 (the "License"); you may
            allNodeNames.add(node.getNode().getName());  
import static org.hamcrest.Matchers.greaterThan;
    public void testNoPreferenceRandom() throws Exception {
        assertThat(firstNodeId, not(equalTo(secondNodeId)));  
        assertThat(RestStatus.OK, equalTo(searchResponse.status()));
 * ownership. Elasticsearch licenses this file to you under  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertSearchOnRandomNodes(request);  
            prepareCreate("test2").setSettings(Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_REPLICAS, replicasInNewIndex))  
 * specific language governing permissions and limitations
        assertAcked(
/*
        assertThat("_only_local", searchResponse.getFailedShards(), greaterThanOrEqualTo(0));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final int replicasInNewIndex = between(1, maximumNumberOfReplicas());
        ensureGreen();
 *
            )
        SearchResponse searchResponse = client.prepareSearch("test").setQuery(matchAllQuery()).get();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
    }  
    public void testNodesOnlyRandom() throws Exception {
