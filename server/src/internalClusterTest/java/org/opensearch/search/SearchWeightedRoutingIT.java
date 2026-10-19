                assertNotNull(aggregations);
            .filter(shard -> {
        NodeStats nodeStatsC = stats.get(nodeIDMap.get(nodeMap.get("c").get(0)));  
        int nodeCountPerAZ = 1;
    }  
        }
        String C_1 = nodes.get(5);
            .put("cluster.routing.weighted.strict", false)  
            } catch (Exception t) {  
        Set<String> nodesInOtherSide = Stream.of(clusterManagerNode1, nodeMap.get("b").get(0), nodeMap.get("c").get(0))
        logger.info("--> creating indices for test");
            responses[i] = internalCluster().smartClient().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).execute();
            try {
import static org.hamcrest.Matchers.greaterThan;  
            .build();
        NetworkDisruption networkDisruption = new NetworkDisruption(
        internalCluster().setDisruptionScheme(networkDisruption);
        // making search requests
        }  
import org.opensearch.core.index.shard.ShardId;
    }  
    }  
        ensureStableCluster(2);
                return dataNodes.get(shard.currentNodeId()).getAttributes().getOrDefault("zone", "").equals("c");  
            .collect(Collectors.toCollection(HashSet::new));
                Settings.builder().put("index.number_of_shards", numShards).put("index.number_of_replicas", numReplicas)
        for (NodeStats stat : nodeStats.getNodes()) {  
                break;
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("4").execute().actionGet();  
        logger.info("--> setting shard routing weights for weighted round robin");  
        SearchResponse searchResponse = internalCluster().client(nodeMap.get("b").get(0))
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()
import java.util.Iterator;
                .setPreference(customPreference)  
            TimeUnit.SECONDS
        assertThrows(
     * which makes node in zone-a unresponsive.
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);  
                }  
        setShardRoutingWeights(weights);
     * @throws IOException throws exception
        for (Iterator<DiscoveryNode> it = dataNodes.values().iterator(); it.hasNext();) {  
import org.opensearch.cluster.routing.PreferenceBasedSearchNotAllowedException;
        );
    }  
                dataNodeId = node.getId();  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeMap.get("b").get(0)));
        }
                assertNotEquals(searchResponse.getHits().getTotalHits().value(), 0);  
        client().admin()  
        assertSearchInAZ("b");  
        Assert.assertTrue(failedCount > 0);  
import org.opensearch.cluster.node.DiscoveryNodes;  
        assertEquals(response.isAcknowledged(), true);
        );
        }
                .add(new MultiGetRequest.Item("test", "" + index2))
        Map<String, String> nodeIDMap = new HashMap<>();
        logger.info("--> making search requests");
        setUpIndexing(numShards, numReplicas);  
 * SPDX-License-Identifier: Apache-2.0
        return Arrays.asList(MockTransportService.TestPlugin.class, MockRepository.Plugin.class);
        setUpIndexing(numShards, numReplicas);
        Set<String> hitNodes = new HashSet<>();
        }
        Future<SearchResponse>[] responses = new Future[50];  
     * MultiGet with fail open enabled. No request failure on network disruption  
        String customPreference = randomAlphaOfLength(10);
            .build();
            .findFirst()
                assertThat(
        setUpIndexing(numShards, numReplicas);
                coordNumber += 1;
            num++;
            () -> assertThat(client().admin().indices().prepareStats().get().getTotal().getSearch().getOpenContexts(), equalTo(0L)),
            }
                hitNodes.add(searchResponse.getHits().getAt(j).getShard().getNodeId());
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
                .prepareSearch("test")
     */
                assertThat(
import java.util.ArrayList;
     * assertions are put to make sure shard search requests do not fail.
        assertThrows(
                .setQuery(QueryBuilders.matchAllQuery())  
                assertThat(multiGetResponse.getResponses().length, equalTo(2));
                throw new AssertionError("search should not fail", t);  
        int numReplicas = 1;
                "_only_nodes:" + nodeIDMap.get(nodeInZoneA) + "," + nodeIDMap.get(nodeInZoneB) + "," + nodeIDMap.get(nodeInZoneC)
     * Since there are two copies of a shard, there can be few shards for which copy doesn't exist in zone b.
        assertThat(coordNumber, greaterThan(0));
    public void testMultiGetWithNetworkDisruption_FailOpenDisabled() throws Exception {  
        ensureGreen();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        refresh("index");
        logger.info("--> starting 1 nodes on zones 'a' & 'b' & 'c'");
                SearchResponse searchResponse = responses[i].get();  
            .build();
        // disable strict weighed routing
    }  
        // making search requests
                hitNodes.add(searchResponse.getHits().getAt(j).getShard().getNodeId());  
        int nodeCountPerAZ = 1;  
        Set<String> nodesInOneSide = Stream.of(clusterManagerNode1, nodeMap.get("b").get(0)).collect(Collectors.toCollection(HashSet::new));
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);  
        assertThat(health.isTimedOut(), equalTo(false));
     * Assert that preference based search with preference type is not allowed with strict weighted shard routing  
    }
        }
                throw new AssertionError("search should not fail", t);
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        Set<String> hitNodes = new HashSet<>();
        String nodeInZoneB = nodeMap.get("b").get(0);
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
        for (int i = 0; i < 50; i++) {  
        // make search requests with custom string  
                throw new AssertionError("search should not fail", t);  
        for (int i = 0; i < 50; i++) {  
        }
        int nodeCountPerAZ = 1;
        String customPreference = randomAlphaOfLength(10);
        internalCluster().client(nodeMap.get("a").get(0))
        }
            .put("cluster.routing.weighted.strict", true)
        int numReplicas = 1;
        ensureStableCluster(2);  
import org.opensearch.test.InternalTestCluster;
        final String clusterManagerNode1 = internalCluster().getClusterManagerName();
                assertThat(  
                SearchResponse searchResponse = responses[i].get();
        assertEquals(RestStatus.OK.getStatus(), searchResponse.status().getStatus());
        ensureGreen();
        try {
                .setPreference("_only_nodes:" + nodeInZoneA)  
     * Shard routing request is served by data nodes in az with weight set as 0,
            .setSize(0)
                .setSize(100)  
     */
        }
        assertNoSearchInAZ("a");
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/10755")  
        }
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        int numReplicas = 2;
        assertEquals(deleteResponse.isAcknowledged(), true);
            .build();
        setUpIndexing(numShards, numReplicas);  
        internalCluster().setDisruptionScheme(networkDisruption);
        int numShards = 1;  
import java.util.Set;
        );  
     * Indices are created with one replica copy and network disruption is introduced,
     */  
        List<IndexRequestBuilder> docs = new ArrayList<>();
            .put("cluster.routing.allocation.awareness.attributes", "zone")
            .setPreference(randomFrom("_local", "_prefer_nodes:" + "zone:a", customPreference))  
        setShardRoutingWeights(weights);  
        }
        String nodeInZoneC = nodeMap.get("c").get(0);  
            try {
            60,  
        networkDisruption.startDisrupting();  
        setShardRoutingWeights(weights);
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
        List<ShardRouting> shardInNodeA = internalCluster().clusterService()  
        logger.info("--> network disruption is stopped");  
        int numReplicas = 1;
            .build();
        }
            try {
     * Asserts on fail open stats which captures number of times fail open is executed
        assertEquals(RestStatus.OK.getStatus(), searchResponse.status().getStatus());
    }  
        logger.info("--> network disruption is stopped");
                failedCount++;  
        }  
            Assert.assertTrue(searchStats.getQueryCount() > 0L);  
            .build();
import org.opensearch.action.search.SearchPhaseName;  
            .index("test")
    /**
        logger.info("--> setting shard routing weights for weighted round robin");
        );
                for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {
        setUpIndexing(numShards, numReplicas);  
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/8030")
                assertThat(multiGetResponse.getResponses()[1].isFailed(), equalTo(false));
        int numShards = 10;  
            responses[i] = internalCluster().client(nodeMap.get("c").get(0))
        logger.info("--> setting shard routing weights for weighted round robin");
            } catch (Exception t) {
        int nodeCountPerAZ = 1;
                throw new AssertionError("search should not fail", t);
            .put(SEARCH_REQUEST_STATS_ENABLED_KEY, true)
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
                .get();
        }
        setShardRoutingWeights(weights);
            .put("cluster.routing.allocation.awareness.attributes", "zone")  
        );
        int numReplicas = 1;
            assertFalse(hitNodes.contains(nodeId));  
                    assertEquals(0, searchStats.getQueryCount());
            }
        }
        );
            nodeCountPerAZ,  
        logger.info("--> deleted shard routing weights for weighted round robin");
            .put("cluster.routing.weighted.fail_open", false)
        networkDisruption.startDisrupting();  
                .prepareSearch("test")  
            .put("cluster.routing.weighted.strict", true)
import java.util.concurrent.Future;  
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
        int numReplicas = 2;
            } catch (Exception t) {
        Future<SearchResponse>[] responses = new Future[50];
        for (String nodeId : nodeIdsFromZoneWithWeightZero) {
        Set<String> nodesInOtherSide = Stream.of(nodeMap.get("a").get(0)).collect(Collectors.toCollection(HashSet::new));
        networkDisruption.stopDisrupting();
                    hitNodes.add(searchResponse.getHits().getAt(j).getShard().getNodeId());  
                for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {  
            .put("cluster.routing.weighted.strict", true)
            } catch (Exception t) {
            assertEquals(searchResponse.getFailedShards(), 0);
                .prepareSearch("test")
        }  
import org.opensearch.search.aggregations.bucket.terms.Terms;
        assertThat(hitNodes.size(), lessThanOrEqualTo(4));  
            .setSize(20)  
        for (int i = 0; i < 50; i++) {  
        NetworkDisruption networkDisruption = new NetworkDisruption(
    /**
     * Shard routing request with fail open disabled is not served by data nodes in az with weight set as 0,  
            NetworkDisruption.UNRESPONSIVE
            .collect(Collectors.toCollection(HashSet::new));
            try {  
        logger.info("--> making search requests");
        int failOpenShardCount = 0;
        logger.info("--> making search requests");
            .setSize(20)  
                .setQuery(QueryBuilders.matchAllQuery())  
        String dataNodeId = null;
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
        Settings commonSettings = Settings.builder()
            .get();
        nodeMap.put("a", nodes_in_zone_a);
        int numReplicas = 1;  
        String dataNodeId = null;
        logger.info("--> network disruption is started");
        // Check shard routing requests hit data nodes in zone c
        for (int i = 0; i < 50; i++) {
        Settings commonSettings = Settings.builder()
            .getRoutingNodes()
                .prepareSearch("test")
        setUpIndexing(numShards, numReplicas);
            .get();
    private void setShardRoutingWeights(Map<String, Double> weights) {
                break;
            .build();
     * Since there are two copies of a shard, there can be few shards for which copy doesn't exist in zone b.  
            } catch (Exception t) {
        for (int i = 0; i < 50; i++) {
        networkDisruption.stopDisrupting();  
     */
        logger.info("--> making search requests");
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
                assertEquals(searchResponse.getFailedShards(), 0);  
        int numReplicas = 2;
                SearchResponse searchResponse = responses[i].get();  
        Set<String> nodesInOneSide = Stream.of(clusterManagerNode1, nodeMap.get("b").get(0), nodeMap.get("c").get(0))
import org.opensearch.cluster.node.DiscoveryNode;
            if (node.getAttributes().get("zone").equals(az)) {
        internalCluster().startClusterManagerOnlyNode(Settings.builder().put(commonSettings).build());
        int nodeCountPerAZ = 1;
import java.util.concurrent.TimeUnit;
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
                    hitNodes.add(searchResponse.getHits().getAt(j).getShard().getNodeId());  
                throw new AssertionError("search should not fail", t);  
                    failedCount++;  
        internalCluster().setDisruptionScheme(networkDisruption);  
            .put("cluster.routing.weighted.fail_open", false)
        ClusterPutWeightedRoutingResponse response = client().admin()
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),  
     * Indices are created with one replica copy and network disruption is introduced,  
            .put("cluster.routing.weighted.fail_open", true)  
                "_only_nodes:" + nodeIDMap.get(nodeInZoneA) + "," + nodeIDMap.get(nodeInZoneB) + "," + nodeIDMap.get(nodeInZoneC)
                failedCount++;
            SearchStats.Stats searchStats = stat.getIndices().getSearch().getTotal();
            NetworkDisruption.UNRESPONSIVE
            responses[i] = internalCluster().client(nodeMap.get("b").get(0))  
        for (int i = 0; i < 50; i++) {
        int size = 17;
            nodeIDMap.put(node.getName(), node.getId());
            }
    /**
        logger.info("--> setting shard routing weights for weighted round robin");
            .setQuery(QueryBuilders.matchAllQuery())  
        String nodeInZoneB = nodeMap.get("b").get(0);
        );
        Set<String> expectedHotNodes = new HashSet<>();  
        Settings commonSettings = Settings.builder()  
            () -> internalCluster().client(nodeMap.get("b").get(0))  
     * in case shard copies are not available in other azs (with fail open enabled)
        }
     * Weighted shard routing weight is set as 0 for az-c.
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")  
        SearchResponse searchResponse = internalCluster().client(nodeMap.get("b").get(0))
            } catch (Exception t) {
        Set<String> hitNodes = new HashSet<>();
import java.util.stream.Stream;  
import org.opensearch.action.index.IndexRequestBuilder;
        setShardRoutingWeights(weights);
            }
    public void testStrictWeightedRoutingAllowedForSomeSearchPrefs() {
        int numReplicas = 1;
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().execute().actionGet();
                    assertEquals(0, searchStats.getFetchCount());
            .prepareWeightedRouting()
            .setQuery(QueryBuilders.matchAllQuery())
        logger.info("--> network disruption is started");  
        int nodeCountPerAZ = 1;
            }
    }  
        }
     * @throws IOException throws exception
        int nodeCountPerAZ = 1;
            TimeUnit.SECONDS  
        final String clusterManagerNode1 = internalCluster().getClusterManagerName();
        networkDisruption.startDisrupting();  
import org.junit.Assert;
        for (int i = 0; i < 50; i++) {  
        logger.info("--> setting shard routing weights for weighted round robin");
        }
        logger.info("--> failed request count is [()]", failedCount);
                assertEquals(0, searchResponse.getFailedShards());  
            .shardId();
            .prepareSearch()
        assertEquals(RestStatus.OK.getStatus(), searchResponse.status().getStatus());
        return nodeMap;
        setShardRoutingWeights(weights);  
        setUpIndexing(numShards, numReplicas);  
        int numShards = 10;
        int numShards = 10;
        int numShards = 10;  
        );
            .build();  
import java.util.Collection;
        int numReplicas = 1;
            } catch (Exception t) {
        int numDocs = 10;
        } catch (Exception t) {  
        networkDisruption.stopDisrupting();
        int numShards = 10;
            .state()
            .put("cluster.routing.ignore_weighted_routing", true)
            assertSearchInAZ("c");  
            } catch (Exception t) {  
        String nodeInZoneA = nodeMap.get("a").get(0);
        setShardRoutingWeights(weights);  
        assertNoSearchInAZ("c");
        int failedCount = 0;  
    public void testStrictWeightedRoutingWithShardPref() throws Exception {
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);  
        assertSearchInAZ("c");
        assertBusy(
        for (int i = 0; i < 50; i++) {
        internalCluster().setDisruptionScheme(networkDisruption);  
            .get();
            }
     * Weighted shard routing weight is set as 0 for az-c.
        assertNoSearchInAZ("c");
                if (stat.getNode().getId().equals(dataNodeId)) {  
        setShardRoutingWeights(weights);  
            .get();  
     * @throws IOException throws exception  
            .cluster()
        );
            .put("cluster.routing.weighted.fail_open", true)  
    public void testStrictWeightedRoutingWithShardPrefNetworkDisruption_FailOpenEnabled() throws Exception {
            TimeUnit.SECONDS
            nodeIDMap.put(node.getName(), node.getId());  
        DiscoveryNodes dataNodes = internalCluster().clusterService().state().nodes();
    }
                    greaterThan(0L)
            if (node.getAttributes().get("zone").equals(az)) {
            responses[i] = internalCluster().client(nodeMap.get("b").get(0))
     * Data nodes in zone a and b are stopped,  
        for (DiscoveryNode node : dataNodes) {  
import org.opensearch.action.get.MultiGetResponse;
    }  
            .prepareSearch()  
        String B_1 = nodes.get(2);
        logger.info("--> creating network partition disruption");
            if (result.contains(shardRouting.shardId())) {
            nodeIDMap.put(node.getName(), node.getId());
            DiscoveryNode node = it.next();
        assertSearchInAZ("b");  
     * Weighted shard routing weight is set as 0 for az-c.
            .cluster()  
            NetworkDisruption.UNRESPONSIVE  
        NetworkDisruption networkDisruption = new NetworkDisruption(
        }
            .build();  
                .get(SearchPhaseName.QUERY.getName())
        for (int i = 0; i < 50; i++) {  
        NetworkDisruption networkDisruption = new NetworkDisruption(
    }
                .add(new MultiGetRequest.Item("test", "" + index1))  
import java.io.IOException;
            index2 = randomIntBetween(0, 9);
                for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {
        setShardRoutingWeights(weights);
        logger.info("--> network disruption is started");
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),  
    }  
        int nodeCountPerAZ = 1;
        int nodeCountPerAZ = 1;
            .findFirst()
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
        Future<SearchResponse>[] responses = new Future[50];
                    searchStats.getRequestStatsLongHolder().getRequestStatsHolder().get(SearchPhaseName.FETCH.getName()).getTotal(),  
            60,
                assertEquals(searchResponse.getFailedShards(), 0);
            .put("cluster.routing.weighted.strict", true)
        logger.info("--> setting shard routing weights for weighted round robin");
        assertEquals(RestStatus.OK.getStatus(), searchResponse.status().getStatus());
            .filter(shard -> {
                assertEquals(0, searchStats.getFetchCount());
        Set<String> hitNodes = new HashSet<>();
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);  
        assertNoSearchInAZ("c");
        Set<String> nodesInOneSide = Stream.of(clusterManagerNode1, nodeMap.get("b").get(0), nodeMap.get("c").get(0))
                assertThat(  
            .prepareSearch()
        logger.info("--> setting shard routing weights for weighted round robin");
        setUpIndexing(numShards, numReplicas);  
            .put("cluster.routing.allocation.awareness.attributes", "zone")  
                .setSize(100)
        for (int i = 0; i < 50; i++) {
                .setPreference(customPreference)
import static org.opensearch.action.search.SearchRequestStats.SEARCH_REQUEST_STATS_ENABLED_KEY;
            .getShardRoutings()  
            }
     * Weighted shard routing weight is set as 0 for az-c.  
        }
            try {  
    }  
        String A_0 = nodes.get(0);
            .collect(Collectors.toCollection(HashSet::new));
        logger.info("--> making search requests");
        }
        Set<String> nodesInOneSide = Stream.of(clusterManagerNode1, nodeMap.get("c").get(0)).collect(Collectors.toCollection(HashSet::new));
                .execute();  
        setUpIndexing(numShards, numReplicas);  
        try {  
        // Make Search Requests  
        String customPreference = randomAlphaOfLength(10);  
                }  
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
            .put("cluster.routing.weighted.fail_open", true)
        int index1, index2;  
                throw new AssertionError("search should not fail", t);
            .state()
        logger.info("--> setting shard routing weights for weighted round robin");
        int numShards = 10;  
                return dataNodes.get(shard.currentNodeId()).getAttributes().getOrDefault("zone", "").equals("c");  
        List<String> nodes = internalCluster().startNodes(
            .setPreference(customPreference)
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
     * Shard routing request fail without fail-open if there are no healthy nodes in active az to serve request  
    public void testWeightedRoutingFailOpenStats() throws Exception {
                .setQuery(QueryBuilders.matchAllQuery())
            .setSize(100)
        int numReplicas = 1;  
        internalCluster().setDisruptionScheme(networkDisruption);  
import java.util.Locale;  
            .put("cluster.routing.weighted.fail_open", true)  
        logger.info("--> creating indices for test");
        assertNoSearchInAZ("a");
     * Assertions are put to make sure such shard search requests are served by data node in zone c.  
                );
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
            SearchStats.Stats searchStats = stat.getIndices().getSearch().getTotal();
     * Data nodes in zone a and b are stopped,
            .build();
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingResponse;
            }  
    public void testSearchAggregationWithNetworkDisruption_FailOpenEnabled() throws Exception {  
            .prepareWeightedRouting()
    }  
            .collect(Collectors.toCollection(HashSet::new));
        assertEquals(expectedHotNodes, hitNodes);
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        }
        final String clusterManagerNode1 = internalCluster().getClusterManagerName();  
        logger.info("--> setting shard routing weights for weighted round robin");
            .index("test")
        Map<String, NodeStats> stats = nodeStats.getNodesMap();
        String C_0 = nodes.get(4);  
        final String clusterManagerNode1 = internalCluster().getClusterManagerName();  
        Future<SearchResponse>[] responses = new Future[51];  
    /**
    public void testStrictWeightedRoutingWithCustomString() {
     */  
            index1 = randomIntBetween(0, 9);  
    public void testShardRoutingByStoppingDataNodes_FailOpenEnabled() throws Exception {
            .put("cluster.routing.weighted.fail_open", true)  
            .setPreference("_only_local:" + nodeInZoneA)
import org.opensearch.test.OpenSearchIntegTestCase;
                .getRequestStatsHolder()  
    public void testSearchWithWRRShardRouting() throws IOException {
import org.opensearch.cluster.routing.WeightedRoutingStats;
            .get();
     * MultiGet with fail open disabled. Assert that some requests do fail.  
        }
        }  
            })
                SearchResponse searchResponse = responses[i].get();
            nodeCountPerAZ,
                }
    }  
            SearchResponse searchResponse = internalCluster().client(randomFrom(A_0, A_1, B_0, B_1))  
        assertAcked(
     * Should failopen shards even if failopen enabled with custom search preference.  
        networkDisruption.stopDisrupting();
        Future<SearchResponse> response = internalCluster().client(nodeMap.get("b").get(0))  
        Map<String, String> nodeIDMap = new HashMap<>();
        for (ShardRouting shardRouting : shardInNodeC) {  
        networkDisruption.stopDisrupting();
        Set<String> nodesInOtherSide = Stream.of(nodeMap.get("a").get(0)).collect(Collectors.toCollection(HashSet::new));  
package org.opensearch.search;
            .getRoutingTable()  
        logger.info("--> network disruption is stopped");  
        Settings commonSettings = Settings.builder()
            for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {  
                for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {  
        }
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
        nodeMap.put("c", nodes_in_zone_c);  
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),  
        nodeStats = client().admin().cluster().prepareNodesStats().execute().actionGet();
        Settings commonSettings = Settings.builder()  
     *  Assert that preference based search works with non-strict weighted shard routing
     * which makes data node in zone-a unresponsive.  
        }
        for (int i = 0; i < 100; i++) {
                }
            }
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
            .setPreference(
        setShardRoutingWeights(weights);
        Settings commonSettings = Settings.builder()  
     * Shard routing request is served by data nodes in az with weight set as 0,  
            .put("cluster.routing.weighted.fail_open", false)  
            .shardId();
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/10673")
            .build();
        Set<String> hitNodes = new HashSet<>();  
        Set<String> nodesInOtherSide = Stream.of(nodeMap.get("a").get(0)).collect(Collectors.toCollection(HashSet::new));
        assertBusy(  
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.test.disruption.NetworkDisruption;  
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),
        assertEquals(failOpenShardCount, nodeStatsC.getWeightedRoutingStats().getFailOpenCount());
        logger.info("--> waiting for nodes to form a cluster");  
            assertEquals(searchResponse.getFailedShards(), 0);
            nodeCountPerAZ,  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, minNumDataNodes = 3)  
            .get();
        List<String> nodes_in_zone_b = internalCluster().startDataOnlyNodes(
     * Indices are created with one replica copy and network disruption is introduced,
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
                assertEquals(Math.min(numDocs, 3L), terms.getBucketByKey("0").getDocCount());
        Future<MultiGetResponse>[] responses = new Future[50];
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
            .prepareSearch()  
            NetworkDisruption.UNRESPONSIVE
        assertSearchInAZ("a");
        DiscoveryNodes dataNodes = internalCluster().clusterService().state().nodes();  
            .node(nodeIDMap.get(nodeMap.get("a").get(0)))  
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
                Assert.assertTrue(searchStats.getQueryCount() > 0L);
        }  
            PreferenceBasedSearchNotAllowedException.class,
            responses[i] = internalCluster().client(nodeMap.get("b").get(0))
        Set<String> hitNodes = new HashSet<>();
        for (NodeStats stat : nodeStats.getNodes()) {
            .put("cluster.routing.allocation.awareness.attributes", "zone")
                }
    public void testShardRoutingByStoppingDataNodes_FailOpenDisabled() throws Exception {
        Settings commonSettings = Settings.builder()  
    }  
    public void testStrictWeightedRouting() {
                    greaterThan(0L)  
        List<String> nodes_in_zone_a = internalCluster().startDataOnlyNodes(  
            .setPreference(customPreference)
        assertNoSearchInAZ("a");  
                for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {
        setShardRoutingWeights(weights);
    /**
     * Assert that preference search with custom string doesn't hit a node in weighed away az
}
                }
            .setSize(0)
            () -> assertThat(client().admin().indices().prepareStats().get().getTotal().getSearch().getOpenContexts(), equalTo(0L)),
        for (DiscoveryNode node : dataNodes) {
/*  
                    greaterThan(0L)
            .build();  
            .get()  
            index2 = randomIntBetween(0, 9);  
            .node(nodeIDMap.get(nodeMap.get("c").get(0)))  
    public void testShardRoutingWithNetworkDisruption_FailOpenDisabled() throws Exception {
            for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {
        setShardRoutingWeights(weights);  
            .build();
        Future<SearchResponse>[] responses = new Future[50];
import org.opensearch.search.aggregations.Aggregations;
                    hitNodes.add(searchResponse.getHits().getAt(j).getShard().getNodeId());
        }  
            if (stat.getNode().getAttributes().get("zone").equals("c")) {  
            client().prepareIndex("test_" + i).setId("" + i).setSource("field_" + i, "value_" + i).get();
            60,  
        int nodeCountPerAZ = 1;
            SearchStats.Stats searchStats = stat.getIndices().getSearch().getTotal();
import java.util.List;
        setShardRoutingWeights(weights);  
        setUpIndexing(numShards, numReplicas);
            } catch (Exception t) {
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().addMetric("weighted_routing").execute().actionGet();
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),  
        );
    private void assertNoSearchInAZ(String az) {
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
                SearchResponse searchResponse = responses[i].get();
                assertEquals(searchResponse.getFailedShards(), 0);
     * in case shard copies are not available in other azs.(with fail open enabled)
        Set<String> hitNodes = new HashSet<>();
        hitNodes = new HashSet<>();  
        int num = 0;  
        // fail open will be called for shards in zone-a data node with replica in zone-c data node  
        String nodeInZoneA = nodeMap.get("a").get(0);
                .execute();  
            .build();
        assertSearchInAZ("c");
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        logger.info("--> creating network partition disruption");
        int coordNumber = 0;
        logger.info("--> creating network partition disruption");
        int numShards = 10;
        int numShards = 10;  
        int numReplicas = 1;  
                .getTimeInMillis() > 0) {
        NetworkDisruption networkDisruption = new NetworkDisruption(
                throw new AssertionError("search should not fail", t);
                .setPreference(String.format(Locale.ROOT, "_shards:%s", shardId.getId()))
import static org.hamcrest.Matchers.equalTo;
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
                .setQuery(QueryBuilders.matchAllQuery())
            DiscoveryNode node = it.next();
     * Since there are two copies of a shard, there can be few shards for which copy doesn't exist in zone b.  
    /**  
    }  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone" + ".values", "a,b,c")
                .setPreference(String.format(Locale.ROOT, "_shards:%s", shardId.getId()))  
                assertThat(multiGetResponse.getResponses().length, equalTo(2));
            .put("cluster.routing.weighted.fail_open", false)  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;  
        Settings commonSettings = Settings.builder()
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().execute().actionGet();
     * in case shard copies are not available in other azs.  
            index1 = randomIntBetween(0, 9);
        Settings commonSettings = Settings.builder()  
            .put("cluster.routing.allocation.awareness.attributes", "zone")
                    searchStats.getRequestStatsLongHolder().getRequestStatsHolder().get(SearchPhaseName.EXPAND.getName()).getTotal(),
        logger.info("--> network disruption is stopped");  
        WeightedRoutingStats.getInstance().resetFailOpenCount();
            responses[i] = client().prepareMultiGet()
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
            .put("cluster.routing.weighted.fail_open", false)  
        for (ShardRouting shardRouting : shardInNodeA) {  
        Set<String> hitNodes = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            .collect(Collectors.toCollection(HashSet::new));
                if (stat.getNode().getId().equals(dataNodeId)) {  
            .state()
            client().prepareIndex("test").setId("" + i).setSource("field_" + i, "value_" + i).get();  
                assertEquals(0, searchResponse.getFailedShards());
            SearchStats.Stats searchStats = stat.getIndices().getSearch().getTotal();
            .put("cluster.routing.weighted.fail_open", true)  
import org.opensearch.snapshots.mockstore.MockRepository;  
        assertNoSearchInAZ("c");  
                .setSettings(Settings.builder().put("index" + ".number_of_shards", 10).put("index" + ".number_of_replicas", 1))
        Set<String> nodesInOneSide = Stream.of(clusterManagerNode1, nodeMap.get("b").get(0)).collect(Collectors.toCollection(HashSet::new));
            assertSearchInAZ("c");
        for (int i = 0; i < 50; i++) {
            })
            }  
     * @throws IOException throws exception  
        Future<SearchResponse>[] responses = new Future[50];
                }  
        searchResponse = internalCluster().client(nodeMap.get("b").get(0))  
        setShardRoutingWeights(weights);  
        logger.info("--> setting shard routing weights for weighted round robin");
        logger.info("--> creating network partition disruption");  
     * in case shard copies are not available in other azs.(with fail open enabled)
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        int failedShardCount = 0;  
        final Map<String, DiscoveryNode> dataNodes = internalCluster().clusterService().state().nodes().getDataNodes();  
        logger.info("--> setting shard routing weights for weighted round robin");
                MultiGetResponse multiGetResponse = responses[i].get();
                .execute();
    public void testShardRoutingWithNetworkDisruption_FailOpenEnabled() throws Exception {  
            .get();
        String B_0 = nodes.get(1);  
            .randomAllActiveShardsIt()
            .put("cluster.routing.allocation.awareness.attributes", "zone")
            responses[i] = internalCluster().client(nodeMap.get("b").get(0))  
        WeightedRoutingStats.getInstance().resetFailOpenCount();
            () -> assertThat(client().admin().indices().prepareStats().get().getTotal().getSearch().getOpenContexts(), equalTo(0L)),
                .setQuery(QueryBuilders.matchAllQuery())
            responses[i] = client().prepareMultiGet()
            .setVersion(-1)  
            .put("cluster.routing.weighted.fail_open", true)
        setUpIndexing(numShards, numReplicas);  
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
            .cluster()  
public class SearchWeightedRoutingIT extends OpenSearchIntegTestCase {
        internalCluster().setDisruptionScheme(networkDisruption);  
        logger.info("--> setting shard routing weights for weighted round robin");
import org.opensearch.cluster.routing.ShardRoutingState;  
    private void setUpIndexing(int numShards, int numReplicas) {
            }
        DiscoveryNodes dataNodes = internalCluster().clusterService().state().nodes();  
        }
            .getShardRoutings()  
        int nodeCountPerAZ = 1;  
        logger.info("--> setting shard routing weights for weighted round robin");  
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);  
        }
            try {
     * Assertions are put to make sure such shard search requests are served by data node in zone c.
        logger.info("--> network disruption is started");
        for (Iterator<DiscoveryNode> it = dataNodes.values().iterator(); it.hasNext();) {  
            .put("cluster.routing.weighted.fail_open", true)  
        Set<String> nodesInOneSide = Stream.of(clusterManagerNode1, nodeMap.get("b").get(0), nodeMap.get("c").get(0))  
     * Shard routing request is served by data nodes in az with weight set as 0,
        logger.info("--> creating network partition disruption");  
        Settings commonSettings = Settings.builder()  
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
        assertAcked(  
                .setSize(100)
        logger.info("--> network disruption is started");
                }
                }
        Set<String> hitNodes = new HashSet<>();  
        internalCluster().setDisruptionScheme(networkDisruption);  
            .put("cluster.routing.allocation.awareness.attributes", "zone")  
    }
        logger.info("--> waiting for nodes to form a cluster");
                .execute();
import java.util.Map;
        String nodeInZoneA = nodeMap.get("a").get(0);  
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
            responses[i] = internalCluster().client(nodeMap.get("b").get(0))
                .setQuery(QueryBuilders.matchAllQuery())
        Settings commonSettings = Settings.builder()  
import org.opensearch.index.query.QueryBuilders;
                assertEquals(searchResponse.getFailedShards(), 0);  
            docs.add(client().prepareIndex("index").setSource("f", Integer.toString(i / 3)));
 *
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);  
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
    }
            .get()  
    /**
            .prepareSearch()
            .stream()
                .setSize(0)
                .prepareSearch()
        Set<String> nodesInOtherSide = Stream.of(nodeMap.get("a").get(0)).collect(Collectors.toCollection(HashSet::new));
            .put("cluster.routing.weighted.fail_open", true)  
     */
        int numShards = 10;
        assertSearchInAZ("b");  
        } catch (AssertionError ae) {  
 * this file be licensed under the Apache-2.0 license or a
        logger.info("--> setting shard routing weights for weighted round robin");
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);  
     * This is tested by setting up a 3 node cluster with one data node per az.
        networkDisruption.stopDisrupting();
        logger.info("--> setting shard routing weights for weighted round robin");
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);  
    /**
        networkDisruption.startDisrupting();
        SearchResponse searchResponse = internalCluster().client(nodeMap.get("b").get(0))
    public void testStrictWeightedRoutingWithCustomString_FailOpenEnabled() throws Exception {
            if (searchStats.getRequestStatsLongHolder()
                .prepareSearch("index")
        logger.info("--> network disruption is stopped");
                .setSize(0)
        try {
        for (int i = 0; i < 50; i++) {
        for (int i = 0; i < 50; i++) {
                .get();  
        networkDisruption.startDisrupting();
        final String clusterManagerNode1 = internalCluster().getClusterManagerName();
            assertEquals(searchResponse.getFailedShards(), 0);
            for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {  
        setUpIndexing(numShards, numReplicas);
            assertSearchInAZ("b");
        String customPreference = randomAlphaOfLength(10);  
        assertThat(num, greaterThan(0));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        );
        logger.info("--> setting shard routing weights for weighted round robin");
            prepareCreate("index").setMapping("f", "type=keyword")  
                throw new AssertionError("search should not fail", t);
        logger.info("--> network disruption is stopped");
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);  
            .get();
        String customPreference = randomAlphaOfLength(10);
import org.opensearch.index.search.stats.SearchStats;
        }  
                .add(new MultiGetRequest.Item("test", "" + index1))
import java.util.stream.Collectors;
            try {  
            .setTransientSettings(Settings.builder().put("cluster.routing.weighted.strict", false))  
 * compatible open source license.
            }  
            .put("cluster.routing.weighted.strict", true)
            NetworkDisruption.UNRESPONSIVE
        assertNoSearchInAZ("a");
            .prepareUpdateSettings()
                    hitNodes.add(searchResponse.getHits().getAt(j).getShard().getNodeId());
        }
            responses[i] = internalCluster().smartClient().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).execute();  
                );  
        assertBusy(
     * in case shard copies are not available in other azs.
                failOpenShardCount++;
                .prepareSearch("test")  
        assertSearchInAZ("b");  
            .put("cluster.routing.weighted.strict", true)
                .setSize(100)
        // shard copies are available in other zones
        NetworkDisruption networkDisruption = new NetworkDisruption(
        int numShards = 10;
                for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {  
     * @throws IOException throws exception  
 * The OpenSearch Contributors require contributions made to  
        List<String> nodes_in_zone_c = internalCluster().startDataOnlyNodes(
            }
        assertThat(health.isTimedOut(), equalTo(false));
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("6").execute().actionGet();
        try {
                if (multiGetResponse.getResponses()[0].isFailed() || multiGetResponse.getResponses()[1].isFailed()) {
            .prepareSearch()
                .setPreference("_prefer_nodes:" + nodeInZoneA)  
        searchResponse = internalCluster().client(nodeMap.get("a").get(0))
        refresh("test");
        Future<SearchResponse>[] responses = new Future[50];
     * Assertions are put to make sure such shard search requests are served by data node in zone c.
        logger.info("--> setting shard routing weights for weighted round robin");
        networkDisruption.startDisrupting();  
    @Override  
     * Weighted shard routing weight is set as 0 for az-c.  
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);  
            assertSearchInAZ("b");
        Set<String> nodesInOtherSide = Stream.of(nodeMap.get("a").get(0)).collect(Collectors.toCollection(HashSet::new));  
        );  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeMap.get("b").get(0)));
     * @throws IOException throws exception
            .getRoutingTable()  
        internalCluster().setDisruptionScheme(networkDisruption);  
        assertSearchInAZ("b");  
            .getRoutingNodes()
        String A_1 = nodes.get(3);
            } catch (Exception t) {  
            .setWeightedRouting(weightedRouting)
                .execute();
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        setShardRoutingWeights(weights);  
        logger.info("--> making search requests");  
            } catch (Exception t) {
            .put("cluster.routing.allocation.awareness.attributes", "zone")  
            .setPreference(  
        int nodeCountPerAZ = 1;  
    /**
        );  
            .randomAllActiveShardsIt()
    /**
        Settings commonSettings = Settings.builder()  
        for (int i = 0; i < 50; i++) {  
        DiscoveryNodes dataNodes = internalCluster().clusterService().state().nodes();
        Set<String> nodesInOtherSide = Stream.of(nodeMap.get("a").get(0)).collect(Collectors.toCollection(HashSet::new));  
            try {
    }  
        SearchResponse searchResponse = internalCluster().client(nodeMap.get("b").get(0))
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),  
        logger.info("--> shards should fail due to network disruption");
        int failedCount = 0;
            .put("cluster.routing.weighted.fail_open", true)
        Future<SearchResponse>[] responses = new Future[50];  
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
     * This is tested by setting up a 3 node cluster with one data node per az.
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
     * @throws IOException throws exception
        for (int i = 0; i < 50; i++) {  
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);  
        Future<SearchResponse>[] responses = new Future[50];  
        Set<ShardId> result = new HashSet<>();
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        }
        ShardId shardId = internalCluster().clusterService()
        Set<String> nodesInOneSide = Stream.of(nodeMap.get("a").get(0)).collect(Collectors.toCollection(HashSet::new));  
            }
            .put("cluster.routing.allocation.awareness.attributes", "zone")  
            responses[i] = internalCluster().client(nodeMap.get("b").get(0))
            SearchResponse searchResponse = response.get();
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),  
            .put("cluster.routing.weighted.fail_open", true)  
import java.util.Arrays;  
                .execute();
            () -> internalCluster().client(nodeMap.get("b").get(0))  
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
    }  
                    hitNodes.add(searchResponse.getHits().getAt(j).getShard().getNodeId());
                SearchResponse searchResponse = responses[i].get();
            .shardsWithState(ShardRoutingState.STARTED);
     */
            .get();
        for (int i = 0; i < 50; i++) {
    public void testPreferenceSearchWithWeightedRouting() {
        Assert.assertTrue(failedShardCount > 0);
import java.util.HashMap;
        Assert.assertTrue(failedCount == 0);
        assertNoSearchInAZ("c");
        );
     * Weighted shard routing weight is set as 0 for az-c.  
     * @throws Exception throws Exception
    private void assertSearchInAZ(String az) {
        }
        Settings commonSettings = Settings.builder()
                    Assert.assertTrue(searchStats.getFetchCount() > 0L || searchStats.getQueryCount() > 0L);
        }
            .setPreference(randomFrom("_local", "_prefer_nodes:" + "zone:a", customPreference))
        }
                throw new AssertionError("search should not fail", t);
        assertEquals(RestStatus.OK.getStatus(), searchResponse.status().getStatus());  
        Set<String> nodesInOneSide = Stream.of(clusterManagerNode1, nodeMap.get("b").get(0)).collect(Collectors.toCollection(HashSet::new));
import java.util.HashSet;  
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
    }  
     */  
        logger.info("--> creating network partition disruption");
        logger.info("--> network disruption is stopped");
                );  
                .addAggregation(terms("f").field("f"))
        for (NodeStats stat : nodeStats.getNodes()) {  
        // Make Search Requests
                .prepareSearch("test")
        setUpIndexing(numShards, numReplicas);  
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);  
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
                );
        for (int i = 0; i < 100; i++) {  
     * This is tested by setting up a 3 node cluster with one data node per az.
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingResponse;
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        ClusterPutWeightedRoutingResponse response = client().admin()
            .get();  
        logger.info("--> making search requests");  
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
     */
        String nodeInZoneA = nodeMap.get("a").get(0);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeMap.get("a").get(0)));  
        final String clusterManagerNode1 = internalCluster().getClusterManagerName();  
        internalCluster().setDisruptionScheme(networkDisruption);
        for (int i = 0; i < 50; i++) {
        setUpIndexing(numShards, numReplicas);
        setUpIndexing(numShards, numReplicas);
        final String clusterManagerNode1 = internalCluster().getClusterManagerName();  
                .setSize(20)  
        NetworkDisruption networkDisruption = new NetworkDisruption(
                nodeIdsFromZoneWithWeightZero.add(node.getId());
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
        );
     * which makes data node in zone-a unresponsive.
        assertEquals(RestStatus.OK.getStatus(), searchResponse.status().getStatus());  
        networkDisruption.stopDisrupting();
        }  
        );  
    public void testStrictWeightedRoutingWithCustomString_FailOpenDisabled() throws Exception {  
     * Assertions are put to make sure such shard search requests are not served by data node in zone c.
        // assert that no search request goes to az with weight zero
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),
                    hitNodes.add(searchResponse.getHits().getAt(j).getShard().getNodeId());
                .get()
                .execute();  
    private Map<String, List<String>> setupCluster(int nodeCountPerAZ, Settings commonSettings) {
        final Map<String, DiscoveryNode> dataNodes = internalCluster().clusterService().state().nodes().getDataNodes();  
import org.opensearch.plugins.Plugin;  
        nodeMap.put("b", nodes_in_zone_b);  
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),
            .build();
            assertSearchInAZ("a");
        int numShards = 10;
        assertNoSearchInAZ("a");  
        logger.info("--> data nodes in zone a and b are stopped");  
import org.opensearch.action.get.MultiGetRequest;  
import org.opensearch.action.search.SearchResponse;
        );
        }  
        int nodeCountPerAZ = 1;
        Map<String, String> nodeIDMap = new HashMap<>();
        int index1, index2;
        }  
        Settings commonSettings = Settings.builder()  
import org.opensearch.test.transport.MockTransportService;
        logger.info("--> network disruption is started");  
            try {
        for (DiscoveryNode node : dataNodes) {  
                failedShardCount += searchResponse.getFailedShards();
        } catch (AssertionError ae) {  
        for (DiscoveryNode node : dataNodes) {
     * Indices are created with one replica copy and network disruption is introduced,
        for (String nodeId : nodeIdsFromZoneWithWeightZero) {
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;  
        DiscoveryNodes dataNodes = internalCluster().clusterService().state().nodes();
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().execute().actionGet();  
        indexRandom(true, docs);  
        networkDisruption.startDisrupting();
            .build();
        logger.info("--> network disruption is started");
        for (int i = 0; i < 50; i++) {  
            .setWeightedRouting(weightedRouting)
        int failedCount = 0;  
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),  
        logger.info("--> network disruption is started");
        Map<String, List<String>> nodeMap = new HashMap<>();
        logger.info("--> starting a dedicated cluster manager node");
                .setQuery(QueryBuilders.matchAllQuery())
        List<ShardRouting> shardInNodeC = internalCluster().clusterService()  
            }  
     * assertions are put to check that search requests fail.
            .prepareSearch("test")
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        int nodeCountPerAZ = 1;  
import org.opensearch.common.settings.Settings;
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
                assertNotEquals(searchResponse.getFailedShards(), 0);
        final String clusterManagerNode1 = internalCluster().getClusterManagerName();  
        setUpIndexing(numShards, numReplicas);
        final String clusterManagerNode1 = internalCluster().getClusterManagerName();
        }
        );
            .shardsWithState(ShardRoutingState.STARTED);
                hitNodes.add(searchResponse.getHits().getAt(j).getShard().getNodeId());
            .put("cluster.routing.allocation.awareness.attributes", "zone")
            .setVersion(-1)  
        );
            .put("cluster.routing.allocation.awareness.attributes", "zone")
                SearchResponse searchResponse = responses[i].get();
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
    public void testMultiGetWithNetworkDisruption_FailOpenEnabled() throws Exception {
import org.opensearch.core.rest.RestStatus;  
            result.add(shardRouting.shardId());
        );
            .put("cluster.routing.weighted.fail_open", true)
            .build();
        assertEquals(RestStatus.OK.getStatus(), searchResponse.status().getStatus());
            SearchResponse searchResponse = internalCluster().client(randomFrom(A_0, A_1, B_0, B_1))
            NetworkDisruption.UNRESPONSIVE
        ClusterDeleteWeightedRoutingResponse deleteResponse = client().admin().cluster().prepareDeleteWeightedRouting().setVersion(0).get();  
            .prepareSearch()
        Future<MultiGetResponse>[] responses = new Future[50];
            NetworkDisruption.UNRESPONSIVE
        Settings commonSettings = Settings.builder()
        logger.info("--> setting shard routing weights for weighted round robin");
        }
            if (stat.getNode().isDataNode()) {
        for (int i = 0; i < 50; i++) {
        logger.info("--> making search requests");
        Settings commonSettings = Settings.builder()  
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build(),
                .add(new MultiGetRequest.Item("test", "" + index2))  
     */  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeMap.get("a").get(0)));
            NetworkDisruption.UNRESPONSIVE  
        int numShards = 20;
            prepareCreate("test").setSettings(Settings.builder().put("index.number_of_shards", 10).put("index.number_of_replicas", 2))
        logger.info("--> network disruption is started");
                SearchResponse searchResponse = responses[i].get();  
        searchResponse = internalCluster().client(nodeMap.get("a").get(0))
        int nodeCountPerAZ = 1;
        searchResponse = internalCluster().client(nodeMap.get("b").get(0)).prepareSearch().setSize(0).setPreference(customPreference).get();
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
        }
        DiscoveryNodes dataNodes = internalCluster().clusterService().state().nodes();  
        Settings commonSettings = Settings.builder()
        // search should not go to nodes in zone c with weight zero in case
     * which makes data node in zone-a unresponsive.
        Set<String> nodesInOtherSide = Stream.of(nodeMap.get("a").get(0)).collect(Collectors.toCollection(HashSet::new));  
        int numShards = 1;
    /**
        List<String> nodeIdsFromZoneWithWeightZero = new ArrayList<>();
        logger.info("--> creating network partition disruption");
        int nodeCountPerAZ = 1;  
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
            if (stat.getNode().isDataNode()) {
        setShardRoutingWeights(weights);
        for (NodeStats stat : nodeStats.getNodes()) {  
    public void testPreferenceSearchWithIgnoreWeightedRouting() {
        ensureGreen();  
        networkDisruption.startDisrupting();
        searchResponse = internalCluster().client(nodeMap.get("b").get(0)).prepareSearch().setSize(0).setPreference("_shards:1").get();
            assertFalse(!hitNodes.contains(nodeId));  
            )  
                expectedHotNodes.add(node.getId());  
                }
                for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {
        assertAcked(
        String customPreference = randomAlphaOfLength(10);
            .setPreference("_local:" + nodeInZoneA)  
        int nodeCountPerAZ = 1;
        logger.info("--> data nodes in zone a and b are stopped");
        int numShards = 10;
            prepareCreate("test").setSettings(
        assertEquals(RestStatus.OK.getStatus(), searchResponse.status().getStatus());
            .put("cluster.routing.weighted.fail_open", true)
        assertEquals(response.isAcknowledged(), true);
        int numReplicas = 2;
            .execute();
        int numReplicas = 1;
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),  
 */  
            .put("cluster.routing.allocation.awareness.attributes", "zone")
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")  
            .put("cluster.routing.weighted.strict", true)
        for (int i = 0; i < 100; i++) {
                .execute();
    }  
        logger.info("--> shards should fail due to network disruption");  
        String nodeInZoneC = nodeMap.get("c").get(0);
        } catch (AssertionError ae) {
                dataNodeId = node.getId();  
     */
        assertSearchInAZ("c");
                    greaterThan(0L)
                MultiGetResponse multiGetResponse = responses[i].get();  
     * Since there are two copies of a shard, there can be few shards for which copy doesn't exist in zone b.
            }
            }  
            }  
        );
            }
     * This is tested by setting up a 3 node cluster with one data node per az.
            }
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
                assertEquals(0, searchResponse.getFailedShards());
            .state()
        ensureGreen();
                assertThat(multiGetResponse.getResponses()[0].isFailed(), equalTo(false));  
                    hitNodes.add(searchResponse.getHits().getAt(j).getShard().getNodeId());
            try {
            if (node.getAttributes().getOrDefault("zone", "").equals("b")) {
    }
        setShardRoutingWeights(weights);
        ShardId shardId = internalCluster().clusterService()
                .prepareSearch()
        assertEquals(RestStatus.OK.getStatus(), searchResponse.status().getStatus());
                .prepareSearch()
                    searchStats.getRequestStatsLongHolder().getRequestStatsHolder().get(SearchPhaseName.QUERY.getName()).getTotal(),
            try {  
        int numReplicas = 1;
        Assert.assertTrue(failedCount > 0);
        for (int i = 0; i < 50; i++) {
        }  
            if (node.getAttributes().get("zone").equals("c")) {
        for (int i = 0; i < 50; i++) {
                .execute();  
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        int numShards = 10;
        for (DiscoveryNode node : dataNodes) {
                Terms terms = aggregations.get("f");  
                .setSize(100)
     * This is tested by setting up a 3 node cluster with one data node per az.  
import org.opensearch.cluster.routing.WeightedRouting;
        logger.info("--> making search requests");  
        Set<String> nodesInOneSide = Stream.of(clusterManagerNode1, nodeMap.get("b").get(0), nodeMap.get("c").get(0))
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
            } else {
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
            .get();  
                Assert.assertTrue(searchStats.getFetchCount() > 0L);  
        networkDisruption.stopDisrupting();
        logger.info("--> network disruption is stopped");  
        DiscoveryNodes dataNodes = internalCluster().clusterService().state().nodes();
        assertNoSearchInAZ("a");
     * Shard routing request with fail open enabled is served by data nodes in az with weight set as 0,  
            )
                .prepareSearch()
        for (int i = 0; i < numDocs; ++i) {  
        }  
        logger.info("--> creating network partition disruption");
            }
        NetworkDisruption networkDisruption = new NetworkDisruption(  
            .prepareSearch()  
                Aggregations aggregations = searchResponse.getAggregations();
     * This is tested by setting up a 3 node cluster with one data node per az.
            )  
     */
        // assert search on data nodes on az c (weighed away az)
        logger.info("--> creating network partition disruption");
        for (int i = 0; i < 50; i++) {
        assertSearchInAZ("c");
                    searchStats.getRequestStatsLongHolder().getRequestStatsHolder().get(SearchPhaseName.FETCH.getName()).getTimeInMillis(),
        NetworkDisruption networkDisruption = new NetworkDisruption(
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
                assertEquals(0, searchStats.getQueryCount());
                SearchResponse searchResponse = responses[i].get();
            PreferenceBasedSearchNotAllowedException.class,
        networkDisruption.startDisrupting();  
                .setQuery(QueryBuilders.matchAllQuery())
    /**
        logger.info("--> starting 6 nodes on different zones");
            }
        networkDisruption.stopDisrupting();
                .get()
        logger.info("--> network disruption is stopped");  
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
        Set<String> nodesInOtherSide = Stream.of(nodeMap.get("a").get(0)).collect(Collectors.toCollection(HashSet::new));  
            .put("cluster.routing.weighted.strict", false)  
            NetworkDisruption.UNRESPONSIVE
            Assert.assertTrue(searchStats.getFetchCount() > 0L);
            .build();  
            throw new AssertionError("search should not fail", t);
            .stream()
        }
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        Settings commonSettings = Settings.builder()  
        int numReplicas = 2;
            assertSearchInAZ("c");
            }  
