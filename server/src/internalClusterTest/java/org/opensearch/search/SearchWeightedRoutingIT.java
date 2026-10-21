import java.util.Arrays;
        String customPreference = randomAlphaOfLength(10);
     * which makes data node in zone-a unresponsive.
                .setQuery(QueryBuilders.matchAllQuery())
    }
        setShardRoutingWeights(weights);
     * Weighted shard routing weight is set as 0 for az-c.
            .stream()
            .getRoutingNodes()
                SearchResponse searchResponse = responses[i].get();
        Set<String> nodesInOneSide = Stream.of(clusterManagerNode1, nodeMap.get("b").get(0)).collect(Collectors.toCollection(HashSet::new));
        Future<SearchResponse> response = internalCluster().client(nodeMap.get("b").get(0))
            .state()
        Set<String> nodesInOneSide = Stream.of(clusterManagerNode1, nodeMap.get("b").get(0)).collect(Collectors.toCollection(HashSet::new));
            .get();
            NetworkDisruption.UNRESPONSIVE
import org.opensearch.index.query.QueryBuilders;
        internalCluster().setDisruptionScheme(networkDisruption);
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),
        logger.info("--> creating network partition disruption");
            index1 = randomIntBetween(0, 9);
        internalCluster().setDisruptionScheme(networkDisruption);
        int nodeCountPerAZ = 1;
        logger.info("--> making search requests");
        Assert.assertTrue(failedCount > 0);
            .build();
            try {
            .setPreference(randomFrom("_local", "_prefer_nodes:" + "zone:a", customPreference))
                for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {
        logger.info("--> network disruption is started");
import org.opensearch.cluster.node.DiscoveryNodes;
            try {
        int nodeCountPerAZ = 1;
            } catch (Exception t) {
        assertSearchInAZ("b");
        List<String> nodeIdsFromZoneWithWeightZero = new ArrayList<>();
                }
    /**
        for (DiscoveryNode node : dataNodes) {
                expectedHotNodes.add(node.getId());
            prepareCreate("test").setSettings(Settings.builder().put("index.number_of_shards", 10).put("index.number_of_replicas", 2))
        assertEquals(failOpenShardCount, nodeStatsC.getWeightedRoutingStats().getFailOpenCount());
                .setSize(20)
        setUpIndexing(numShards, numReplicas);
            }
        internalCluster().setDisruptionScheme(networkDisruption);
            responses[i] = client().prepareMultiGet()
        logger.info("--> data nodes in zone a and b are stopped");
     *  Assert that preference based search works with non-strict weighted shard routing
        );
        Settings commonSettings = Settings.builder()
        WeightedRoutingStats.getInstance().resetFailOpenCount();
                for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {
        client().admin()
    }
        String C_1 = nodes.get(5);
        for (int i = 0; i < 50; i++) {
                coordNumber += 1;
     * Shard routing request with fail open enabled is served by data nodes in az with weight set as 0,
import java.util.HashSet;
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        ClusterPutWeightedRoutingResponse response = client().admin()
import java.util.List;
        hitNodes = new HashSet<>();
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
    }
            .cluster()
        Set<String> hitNodes = new HashSet<>();
    }
        for (NodeStats stat : nodeStats.getNodes()) {
            index2 = randomIntBetween(0, 9);
            })
                }
            .index("test")
                if (stat.getNode().getId().equals(dataNodeId)) {
                throw new AssertionError("search should not fail", t);
        String customPreference = randomAlphaOfLength(10);
            .get();
            .state()
            assertSearchInAZ("c");
        }
            .shardsWithState(ShardRoutingState.STARTED);
        setUpIndexing(numShards, numReplicas);
                .prepareSearch()
        }
            .put("cluster.routing.weighted.strict", true)
            .setTransientSettings(Settings.builder().put("cluster.routing.weighted.strict", false))
            .setSize(100)
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        setShardRoutingWeights(weights);
                }
                .prepareSearch()
        logger.info("--> setting shard routing weights for weighted round robin");
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),
            .setSize(0)
        final String clusterManagerNode1 = internalCluster().getClusterManagerName();
        );
        for (DiscoveryNode node : dataNodes) {
            .cluster()
    }
        String customPreference = randomAlphaOfLength(10);
            responses[i] = internalCluster().client(nodeMap.get("b").get(0))
        Set<String> hitNodes = new HashSet<>();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeMap.get("a").get(0)));
        for (DiscoveryNode node : dataNodes) {
        int numReplicas = 1;
        logger.info("--> network disruption is started");
            }
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        assertNoSearchInAZ("a");
        nodeStats = client().admin().cluster().prepareNodesStats().execute().actionGet();
            .put("cluster.routing.allocation.awareness.attributes", "zone")
                assertThat(multiGetResponse.getResponses()[1].isFailed(), equalTo(false));
        logger.info("--> setting shard routing weights for weighted round robin");
import org.opensearch.common.settings.Settings;
        int numShards = 1;
    public void testStrictWeightedRouting() {
        Set<String> hitNodes = new HashSet<>();
            for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {
        try {
                .prepareSearch("index")
     * Shard routing request with fail open disabled is not served by data nodes in az with weight set as 0,
                assertEquals(0, searchStats.getFetchCount());
        String customPreference = randomAlphaOfLength(10);
                    greaterThan(0L)
            .collect(Collectors.toCollection(HashSet::new));
        logger.info("--> setting shard routing weights for weighted round robin");
        Set<String> hitNodes = new HashSet<>();
            }
        logger.info("--> network disruption is started");
        logger.info("--> network disruption is stopped");
        }
                    failedCount++;
        int num = 0;
        int numShards = 10;
            .filter(shard -> {
    }
        networkDisruption.stopDisrupting();
        }
                Aggregations aggregations = searchResponse.getAggregations();
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
        logger.info("--> creating network partition disruption");
                .execute();
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/10673")
        setUpIndexing(numShards, numReplicas);
        // make search requests with custom string
        setUpIndexing(numShards, numReplicas);
        setShardRoutingWeights(weights);
        NetworkDisruption networkDisruption = new NetworkDisruption(
                assertThat(
     */
import static org.opensearch.action.search.SearchRequestStats.SEARCH_REQUEST_STATS_ENABLED_KEY;
        logger.info("--> network disruption is stopped");
                if (stat.getNode().getId().equals(dataNodeId)) {
        logger.info("--> creating indices for test");
        networkDisruption.startDisrupting();
        for (int i = 0; i < 50; i++) {
     * Assert that preference based search with preference type is not allowed with strict weighted shard routing
        int numReplicas = 1;
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        }
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
    /**
        setShardRoutingWeights(weights);
        final String clusterManagerNode1 = internalCluster().getClusterManagerName();
        }
        int nodeCountPerAZ = 1;
        int numReplicas = 1;
        assertNoSearchInAZ("a");
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
                    hitNodes.add(searchResponse.getHits().getAt(j).getShard().getNodeId());
        logger.info("--> creating network partition disruption");
            assertEquals(searchResponse.getFailedShards(), 0);
    public void testShardRoutingByStoppingDataNodes_FailOpenEnabled() throws Exception {
            } catch (Exception t) {
            .put("cluster.routing.allocation.awareness.attributes", "zone")
            .setPreference(customPreference)
            .build();
            .put("cluster.routing.weighted.fail_open", true)
        int numReplicas = 2;
                throw new AssertionError("search should not fail", t);
        searchResponse = internalCluster().client(nodeMap.get("b").get(0))
            .prepareSearch()
     * Weighted shard routing weight is set as 0 for az-c.
        assertEquals(RestStatus.OK.getStatus(), searchResponse.status().getStatus());
        setUpIndexing(numShards, numReplicas);
     */
                failedCount++;
                for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
        logger.info("--> setting shard routing weights for weighted round robin");
import org.opensearch.test.InternalTestCluster;
            DiscoveryNode node = it.next();
        Future<SearchResponse>[] responses = new Future[50];
            .setSize(20)
        // Make Search Requests
import org.opensearch.plugins.Plugin;
     * Weighted shard routing weight is set as 0 for az-c.
                    searchStats.getRequestStatsLongHolder().getRequestStatsHolder().get(SearchPhaseName.FETCH.getName()).getTotal(),
     * This is tested by setting up a 3 node cluster with one data node per az.
        );
                .add(new MultiGetRequest.Item("test", "" + index1))
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
                    hitNodes.add(searchResponse.getHits().getAt(j).getShard().getNodeId());
            .stream()
            () -> assertThat(client().admin().indices().prepareStats().get().getTotal().getSearch().getOpenContexts(), equalTo(0L)),
        Future<SearchResponse>[] responses = new Future[51];
        searchResponse = internalCluster().client(nodeMap.get("a").get(0))
     * @throws IOException throws exception
        int nodeCountPerAZ = 1;
            SearchResponse searchResponse = internalCluster().client(randomFrom(A_0, A_1, B_0, B_1))
            .build();
        // Check shard routing requests hit data nodes in zone c
        logger.info("--> network disruption is stopped");
        }
        Settings commonSettings = Settings.builder()
            .setVersion(-1)
                .getTimeInMillis() > 0) {
                    assertEquals(0, searchStats.getQueryCount());
        // shard copies are available in other zones
     * in case shard copies are not available in other azs.
        logger.info("--> making search requests");
            nodeIDMap.put(node.getName(), node.getId());
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
     * @throws IOException throws exception
            .setPreference(
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
            .put("cluster.routing.allocation.awareness.attributes", "zone")
                .setPreference(String.format(Locale.ROOT, "_shards:%s", shardId.getId()))
            .setPreference(randomFrom("_local", "_prefer_nodes:" + "zone:a", customPreference))
        // disable strict weighed routing
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        int numShards = 10;
        );
        assertEquals(RestStatus.OK.getStatus(), searchResponse.status().getStatus());
        int numShards = 10;
            throw new AssertionError("search should not fail", t);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        // assert that no search request goes to az with weight zero
            .build();
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        assertThrows(
            .put("cluster.routing.weighted.strict", false)
            } catch (Exception t) {
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        logger.info("--> network disruption is stopped");
            SearchStats.Stats searchStats = stat.getIndices().getSearch().getTotal();
import org.opensearch.cluster.routing.PreferenceBasedSearchNotAllowedException;
        logger.info("--> network disruption is started");
        setShardRoutingWeights(weights);
            .setQuery(QueryBuilders.matchAllQuery())
import org.opensearch.test.disruption.NetworkDisruption;
                assertEquals(searchResponse.getFailedShards(), 0);
                assertThat(multiGetResponse.getResponses().length, equalTo(2));
    public void testSearchAggregationWithNetworkDisruption_FailOpenEnabled() throws Exception {
        List<String> nodes_in_zone_b = internalCluster().startDataOnlyNodes(
        assertBusy(
        Map<String, String> nodeIDMap = new HashMap<>();
        );
        int nodeCountPerAZ = 1;
        SearchResponse searchResponse = internalCluster().client(nodeMap.get("b").get(0))
        );
        int numShards = 10;
        logger.info("--> network disruption is started");
            Assert.assertTrue(searchStats.getQueryCount() > 0L);
import org.opensearch.test.OpenSearchIntegTestCase;
                    searchStats.getRequestStatsLongHolder().getRequestStatsHolder().get(SearchPhaseName.FETCH.getName()).getTimeInMillis(),
        ensureGreen();
            .get();
        assertThat(health.isTimedOut(), equalTo(false));
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
                }
        assertEquals(expectedHotNodes, hitNodes);
        setShardRoutingWeights(weights);
            NetworkDisruption.UNRESPONSIVE
                .prepareSearch("test")
     * @throws IOException throws exception
            .build();
        } catch (AssertionError ae) {
        Future<MultiGetResponse>[] responses = new Future[50];
import java.util.Collection;
        String A_1 = nodes.get(3);
            assertSearchInAZ("b");
     * in case shard copies are not available in other azs (with fail open enabled)
                .setQuery(QueryBuilders.matchAllQuery())
        }
            .setPreference("_local:" + nodeInZoneA)
        final Map<String, DiscoveryNode> dataNodes = internalCluster().clusterService().state().nodes().getDataNodes();
        logger.info("--> creating network partition disruption");
     * Data nodes in zone a and b are stopped,
     */
                    searchStats.getRequestStatsLongHolder().getRequestStatsHolder().get(SearchPhaseName.EXPAND.getName()).getTotal(),
        assertEquals(response.isAcknowledged(), true);
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        logger.info("--> network disruption is started");
            .get();
        }
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
            responses[i] = internalCluster().smartClient().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).execute();
import org.opensearch.search.aggregations.bucket.terms.Terms;
        logger.info("--> network disruption is stopped");
        internalCluster().setDisruptionScheme(networkDisruption);
        }
                dataNodeId = node.getId();
import java.util.Set;
        int numShards = 10;
        );
    /**
                .execute();
        Set<ShardId> result = new HashSet<>();
     * Since there are two copies of a shard, there can be few shards for which copy doesn't exist in zone b.
        for (int i = 0; i < 50; i++) {
import static org.hamcrest.Matchers.equalTo;
        SearchResponse searchResponse = internalCluster().client(nodeMap.get("b").get(0))
                return dataNodes.get(shard.currentNodeId()).getAttributes().getOrDefault("zone", "").equals("c");
        final String clusterManagerNode1 = internalCluster().getClusterManagerName();
            .findFirst()
                .get()
        assertEquals(RestStatus.OK.getStatus(), searchResponse.status().getStatus());
            )
    }
            responses[i] = internalCluster().client(nodeMap.get("b").get(0))
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
                );
                    searchStats.getRequestStatsLongHolder().getRequestStatsHolder().get(SearchPhaseName.QUERY.getName()).getTotal(),
            }
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
        assertNoSearchInAZ("c");
                );
                .setSize(0)
            .put("cluster.routing.weighted.fail_open", true)
        NetworkDisruption networkDisruption = new NetworkDisruption(
            .prepareSearch("test")
        }
    }
                .prepareSearch("test")
        Settings commonSettings = Settings.builder()
        setShardRoutingWeights(weights);
                throw new AssertionError("search should not fail", t);
        for (int i = 0; i < numDocs; ++i) {
        assertSearchInAZ("a");
            }
                throw new AssertionError("search should not fail", t);
        int numReplicas = 1;
            }
                    assertEquals(0, searchStats.getFetchCount());
            .shardId();
            nodeIDMap.put(node.getName(), node.getId());
            .build();
    }
            )
        for (int i = 0; i < 50; i++) {
        Settings commonSettings = Settings.builder()
        }
            assertFalse(hitNodes.contains(nodeId));
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeMap.get("b").get(0)));
public class SearchWeightedRoutingIT extends OpenSearchIntegTestCase {
        // fail open will be called for shards in zone-a data node with replica in zone-c data node
        return nodeMap;
        int nodeCountPerAZ = 1;
     * @throws Exception throws Exception
                }
        }
            }
        assertAcked(
            .build();
            } catch (Exception t) {
                );
            assertSearchInAZ("a");
                MultiGetResponse multiGetResponse = responses[i].get();
            client().prepareIndex("test_" + i).setId("" + i).setSource("field_" + i, "value_" + i).get();
                .prepareSearch("test")
            .put("cluster.routing.weighted.fail_open", false)
    /**
                    hitNodes.add(searchResponse.getHits().getAt(j).getShard().getNodeId());
        WeightedRoutingStats.getInstance().resetFailOpenCount();
                    greaterThan(0L)
    public void testPreferenceSearchWithWeightedRouting() {
        int nodeCountPerAZ = 1;
                .setQuery(QueryBuilders.matchAllQuery())
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
                dataNodeId = node.getId();
        assertAcked(
            .randomAllActiveShardsIt()
    /**
                MultiGetResponse multiGetResponse = responses[i].get();
import static org.hamcrest.Matchers.greaterThan;
                SearchResponse searchResponse = responses[i].get();
    }
                    greaterThan(0L)
                .setQuery(QueryBuilders.matchAllQuery())
        NetworkDisruption networkDisruption = new NetworkDisruption(
     * This is tested by setting up a 3 node cluster with one data node per az.
        networkDisruption.stopDisrupting();
            if (node.getAttributes().get("zone").equals(az)) {
            .put("cluster.routing.weighted.fail_open", false)
import java.util.ArrayList;
        for (int i = 0; i < 100; i++) {
    public void testStrictWeightedRoutingWithCustomString_FailOpenEnabled() throws Exception {
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
     * @throws IOException throws exception
        Future<SearchResponse>[] responses = new Future[50];
        int numShards = 10;
            }
            NetworkDisruption.UNRESPONSIVE
        assertSearchInAZ("c");
            }
        }
            .build();
                    greaterThan(0L)
            try {
                    Assert.assertTrue(searchStats.getFetchCount() > 0L || searchStats.getQueryCount() > 0L);
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        // Make Search Requests
     * which makes data node in zone-a unresponsive.
        }
    @Override
    }
            .prepareSearch()
                SearchResponse searchResponse = responses[i].get();
            .setWeightedRouting(weightedRouting)
        logger.info("--> setting shard routing weights for weighted round robin");
        logger.info("--> creating indices for test");
        Assert.assertTrue(failedCount == 0);
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingResponse;
            .get()
            DiscoveryNode node = it.next();
        List<String> nodes_in_zone_a = internalCluster().startDataOnlyNodes(
    /**
        setUpIndexing(numShards, numReplicas);
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
    private void setUpIndexing(int numShards, int numReplicas) {
                assertEquals(0, searchStats.getQueryCount());
            .put("cluster.routing.allocation.awareness.attributes", "zone")
import org.opensearch.action.get.MultiGetRequest;
            responses[i] = internalCluster().client(nodeMap.get("b").get(0))
        int numShards = 10;
        Set<String> nodesInOneSide = Stream.of(clusterManagerNode1, nodeMap.get("b").get(0), nodeMap.get("c").get(0))
        // making search requests
            prepareCreate("test").setSettings(
        for (ShardRouting shardRouting : shardInNodeC) {
            .state()
        int numReplicas = 2;
    public void testShardRoutingByStoppingDataNodes_FailOpenDisabled() throws Exception {
        assertThat(hitNodes.size(), lessThanOrEqualTo(4));
        logger.info("--> starting 1 nodes on zones 'a' & 'b' & 'c'");
        logger.info("--> making search requests");
        int coordNumber = 0;
            .put("cluster.routing.allocation.awareness.attributes", "zone")
                .setQuery(QueryBuilders.matchAllQuery())
            .put("cluster.routing.weighted.fail_open", true)
            index1 = randomIntBetween(0, 9);
                .add(new MultiGetRequest.Item("test", "" + index2))
        } catch (Exception t) {
            prepareCreate("index").setMapping("f", "type=keyword")
    public void testStrictWeightedRoutingWithCustomString() {
                SearchResponse searchResponse = responses[i].get();
            () -> assertThat(client().admin().indices().prepareStats().get().getTotal().getSearch().getOpenContexts(), equalTo(0L)),
            .prepareUpdateSettings()
        for (int i = 0; i < 50; i++) {
            .put("cluster.routing.weighted.fail_open", true)
        try {
        }
        logger.info("--> network disruption is stopped");
     * Assertions are put to make sure such shard search requests are served by data node in zone c.
            }
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("4").execute().actionGet();
        Set<String> hitNodes = new HashSet<>();
            .getRoutingTable()
                .get();
        String customPreference = randomAlphaOfLength(10);
        logger.info("--> setting shard routing weights for weighted round robin");
        }
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        logger.info("--> network disruption is started");
        }
        logger.info("--> setting shard routing weights for weighted round robin");
            try {
        setUpIndexing(numShards, numReplicas);
                nodeIdsFromZoneWithWeightZero.add(node.getId());
            60,
        String A_0 = nodes.get(0);
        setUpIndexing(numShards, numReplicas);
                .setSize(100)
        DiscoveryNodes dataNodes = internalCluster().clusterService().state().nodes();
import org.opensearch.core.index.shard.ShardId;
            .getShardRoutings()
            .put("cluster.routing.allocation.awareness.attributes", "zone")
 * this file be licensed under the Apache-2.0 license or a
        int nodeCountPerAZ = 1;
            }
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
                .add(new MultiGetRequest.Item("test", "" + index2))
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
            .collect(Collectors.toCollection(HashSet::new));
        }
            if (node.getAttributes().get("zone").equals("c")) {
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
            TimeUnit.SECONDS
        assertThat(health.isTimedOut(), equalTo(false));
        ClusterPutWeightedRoutingResponse response = client().admin()
                .prepareSearch("test")
            .prepareSearch()
        int nodeCountPerAZ = 1;
        int size = 17;
            NetworkDisruption.UNRESPONSIVE
                .setSize(100)
     */
     * Shard routing request is served by data nodes in az with weight set as 0,
                assertNotEquals(searchResponse.getFailedShards(), 0);
        }
        // assert search on data nodes on az c (weighed away az)
            }
    private Map<String, List<String>> setupCluster(int nodeCountPerAZ, Settings commonSettings) {
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
    public void testShardRoutingWithNetworkDisruption_FailOpenDisabled() throws Exception {
        );
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
        setShardRoutingWeights(weights);
        );
        List<IndexRequestBuilder> docs = new ArrayList<>();
            if (searchStats.getRequestStatsLongHolder()
        String B_1 = nodes.get(2);
            docs.add(client().prepareIndex("index").setSource("f", Integer.toString(i / 3)));
            .get();
        assertNoSearchInAZ("c");
        for (int i = 0; i < 50; i++) {
        internalCluster().startClusterManagerOnlyNode(Settings.builder().put(commonSettings).build());
        Set<String> nodesInOtherSide = Stream.of(nodeMap.get("a").get(0)).collect(Collectors.toCollection(HashSet::new));
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
        logger.info("--> network disruption is stopped");
            .build();
            } catch (Exception t) {
        assertEquals(response.isAcknowledged(), true);
        setShardRoutingWeights(weights);
            assertEquals(searchResponse.getFailedShards(), 0);
import org.opensearch.cluster.routing.ShardRoutingState;
            index2 = randomIntBetween(0, 9);
        }
        setUpIndexing(numShards, numReplicas);
        logger.info("--> making search requests");
        logger.info("--> waiting for nodes to form a cluster");
        Settings commonSettings = Settings.builder()
            }
        assertNoSearchInAZ("a");
            client().prepareIndex("test").setId("" + i).setSource("field_" + i, "value_" + i).get();
import org.opensearch.action.get.MultiGetResponse;
            try {
            for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {
import org.opensearch.snapshots.mockstore.MockRepository;
        String nodeInZoneC = nodeMap.get("c").get(0);
     * Shard routing request fail without fail-open if there are no healthy nodes in active az to serve request
        for (int i = 0; i < 50; i++) {
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),
        );
        assertEquals(RestStatus.OK.getStatus(), searchResponse.status().getStatus());
            }
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
                .prepareSearch("test")
        );
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
                return dataNodes.get(shard.currentNodeId()).getAttributes().getOrDefault("zone", "").equals("c");
            try {
        for (int i = 0; i < 100; i++) {
        for (int i = 0; i < 50; i++) {
        logger.info("--> making search requests");
            .node(nodeIDMap.get(nodeMap.get("c").get(0)))
            NetworkDisruption.UNRESPONSIVE
import java.util.Map;
            SearchStats.Stats searchStats = stat.getIndices().getSearch().getTotal();
        int numShards = 10;
        for (ShardRouting shardRouting : shardInNodeA) {
        }
        }
        List<ShardRouting> shardInNodeA = internalCluster().clusterService()
    }
        internalCluster().client(nodeMap.get("a").get(0))
     * Shard routing request is served by data nodes in az with weight set as 0,
        DiscoveryNodes dataNodes = internalCluster().clusterService().state().nodes();
        DiscoveryNodes dataNodes = internalCluster().clusterService().state().nodes();
            .put(SEARCH_REQUEST_STATS_ENABLED_KEY, true)
     * in case shard copies are not available in other azs.(with fail open enabled)
        Set<String> nodesInOtherSide = Stream.of(nodeMap.get("a").get(0)).collect(Collectors.toCollection(HashSet::new));
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
        assertEquals(RestStatus.OK.getStatus(), searchResponse.status().getStatus());
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
            .get();
     * which makes data node in zone-a unresponsive.
            SearchResponse searchResponse = response.get();
    }
        int numShards = 10;
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("6").execute().actionGet();
     * Indices are created with one replica copy and network disruption is introduced,
        assertBusy(
        networkDisruption.startDisrupting();
        int numReplicas = 2;
            .setPreference(
        Settings commonSettings = Settings.builder()
        int nodeCountPerAZ = 1;
                .setPreference(customPreference)
 * SPDX-License-Identifier: Apache-2.0
        Future<SearchResponse>[] responses = new Future[50];
        Set<String> nodesInOtherSide = Stream.of(nodeMap.get("a").get(0)).collect(Collectors.toCollection(HashSet::new));
            .prepareSearch()
        int numReplicas = 1;
        logger.info("--> setting shard routing weights for weighted round robin");
                hitNodes.add(searchResponse.getHits().getAt(j).getShard().getNodeId());
        assertSearchInAZ("c");
            })
        final String clusterManagerNode1 = internalCluster().getClusterManagerName();
     * MultiGet with fail open enabled. No request failure on network disruption
        NetworkDisruption networkDisruption = new NetworkDisruption(
        networkDisruption.startDisrupting();
        logger.info("--> waiting for nodes to form a cluster");
        );
        assertNoSearchInAZ("a");
        String nodeInZoneB = nodeMap.get("b").get(0);
        Settings commonSettings = Settings.builder()
            .build();
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        logger.info("--> starting a dedicated cluster manager node");
            .prepareSearch()
            .put("cluster.routing.weighted.strict", true)
        }
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
                assertEquals(searchResponse.getFailedShards(), 0);
     * which makes node in zone-a unresponsive.
                }
        String nodeInZoneB = nodeMap.get("b").get(0);
        );
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),
        networkDisruption.startDisrupting();
            .get();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeMap.get("b").get(0)));
        int numReplicas = 1;
                    hitNodes.add(searchResponse.getHits().getAt(j).getShard().getNodeId());
            result.add(shardRouting.shardId());
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
            }
        ensureStableCluster(2);
     */
        internalCluster().setDisruptionScheme(networkDisruption);
        logger.info("--> creating network partition disruption");
        Future<SearchResponse>[] responses = new Future[50];
     * in case shard copies are not available in other azs.(with fail open enabled)
        try {
        for (Iterator<DiscoveryNode> it = dataNodes.values().iterator(); it.hasNext();) {
            .randomAllActiveShardsIt()
            } else {
        logger.info("--> making search requests");
        DiscoveryNodes dataNodes = internalCluster().clusterService().state().nodes();
     * Assertions are put to make sure such shard search requests are not served by data node in zone c.
     * Weighted shard routing weight is set as 0 for az-c.
        }
                .get();
            .build();
    public void testShardRoutingWithNetworkDisruption_FailOpenEnabled() throws Exception {
        }
                throw new AssertionError("search should not fail", t);
        int failOpenShardCount = 0;
import java.util.Locale;
        int numReplicas = 2;
            num++;
            60,
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),
            .shardId();
import org.opensearch.cluster.routing.WeightedRoutingStats;
                SearchResponse searchResponse = responses[i].get();
                .setQuery(QueryBuilders.matchAllQuery())
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        for (Iterator<DiscoveryNode> it = dataNodes.values().iterator(); it.hasNext();) {
        );
                    hitNodes.add(searchResponse.getHits().getAt(j).getShard().getNodeId());
    }
            .build();
            .setPreference("_only_local:" + nodeInZoneA)
        }
                .get(SearchPhaseName.QUERY.getName())
                .getRequestStatsHolder()
        Settings commonSettings = Settings.builder()
        logger.info("--> setting shard routing weights for weighted round robin");
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/10755")
                throw new AssertionError("search should not fail", t);
        int nodeCountPerAZ = 1;
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
            .put("cluster.routing.ignore_weighted_routing", true)
        logger.info("--> making search requests");
     * Asserts on fail open stats which captures number of times fail open is executed
    /**
        assertEquals(RestStatus.OK.getStatus(), searchResponse.status().getStatus());
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
                "_only_nodes:" + nodeIDMap.get(nodeInZoneA) + "," + nodeIDMap.get(nodeInZoneB) + "," + nodeIDMap.get(nodeInZoneC)
            responses[i] = internalCluster().client(nodeMap.get("b").get(0))
    public void testStrictWeightedRoutingWithShardPrefNetworkDisruption_FailOpenEnabled() throws Exception {
        } catch (AssertionError ae) {
        } catch (AssertionError ae) {
        return Arrays.asList(MockTransportService.TestPlugin.class, MockRepository.Plugin.class);
        setShardRoutingWeights(weights);
        Set<String> nodesInOneSide = Stream.of(nodeMap.get("a").get(0)).collect(Collectors.toCollection(HashSet::new));
        assertEquals(RestStatus.OK.getStatus(), searchResponse.status().getStatus());
    }
        Set<String> hitNodes = new HashSet<>();
        setShardRoutingWeights(weights);
        for (int i = 0; i < 50; i++) {
            .setSize(0)
            .node(nodeIDMap.get(nodeMap.get("a").get(0)))
            .state()
        ensureStableCluster(2);
        int numShards = 10;
                Terms terms = aggregations.get("f");
            nodeCountPerAZ,
    }
                .get()
        Future<SearchResponse>[] responses = new Future[50];
        networkDisruption.startDisrupting();
    }
        indexRandom(true, docs);
            .getShardRoutings()
        logger.info("--> shards should fail due to network disruption");
            .get();
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
            assertEquals(searchResponse.getFailedShards(), 0);
        setShardRoutingWeights(weights);
            .put("cluster.routing.weighted.strict", true)
        Assert.assertTrue(failedShardCount > 0);
            .prepareSearch()
    }
            () -> internalCluster().client(nodeMap.get("b").get(0))
        }
        }
        Future<SearchResponse>[] responses = new Future[50];
        Map<String, NodeStats> stats = nodeStats.getNodesMap();
            }
        setShardRoutingWeights(weights);
        logger.info("--> making search requests");
        List<String> nodes = internalCluster().startNodes(
                .setSize(100)
        NetworkDisruption networkDisruption = new NetworkDisruption(
                assertEquals(0, searchResponse.getFailedShards());
        assertThat(coordNumber, greaterThan(0));
    private void setShardRoutingWeights(Map<String, Double> weights) {
            .put("cluster.routing.weighted.fail_open", true)
        Future<SearchResponse>[] responses = new Future[50];
 */
import java.util.concurrent.TimeUnit;
            .get()
                assertEquals(searchResponse.getFailedShards(), 0);
        int numReplicas = 1;
            .put("cluster.routing.weighted.fail_open", true)
            .put("cluster.routing.weighted.fail_open", false)
     * Assertions are put to make sure such shard search requests are served by data node in zone c.
            }
        assertThat(num, greaterThan(0));
    public void testMultiGetWithNetworkDisruption_FailOpenEnabled() throws Exception {
        }
        final String clusterManagerNode1 = internalCluster().getClusterManagerName();
        Set<String> nodesInOneSide = Stream.of(clusterManagerNode1, nodeMap.get("c").get(0)).collect(Collectors.toCollection(HashSet::new));
                for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {
    /**
        int nodeCountPerAZ = 1;
            .build();
            .collect(Collectors.toCollection(HashSet::new));
        }
                throw new AssertionError("search should not fail", t);
                assertEquals(searchResponse.getFailedShards(), 0);
}
            .get();
            .getRoutingNodes()
            .put("cluster.routing.weighted.fail_open", false)
        Set<String> nodesInOtherSide = Stream.of(nodeMap.get("a").get(0)).collect(Collectors.toCollection(HashSet::new));
            .setWeightedRouting(weightedRouting)
            NetworkDisruption.UNRESPONSIVE
            } catch (Exception t) {
            .index("test")
        assertEquals(deleteResponse.isAcknowledged(), true);
            .build();
        Settings commonSettings = Settings.builder()
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/8030")
                assertNotNull(aggregations);
        String customPreference = randomAlphaOfLength(10);
        int numDocs = 10;
        }
     * assertions are put to make sure shard search requests do not fail.
        networkDisruption.startDisrupting();
     * Data nodes in zone a and b are stopped,
        String dataNodeId = null;
        logger.info("--> shards should fail due to network disruption");
            }
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone" + ".values", "a,b,c")
            .collect(Collectors.toCollection(HashSet::new));
        String nodeInZoneA = nodeMap.get("a").get(0);
        ensureGreen();
            nodeCountPerAZ,
import org.opensearch.cluster.routing.ShardRouting;
        logger.info("--> failed request count is [()]", failedCount);
            Assert.assertTrue(searchStats.getFetchCount() > 0L);
            .put("cluster.routing.weighted.fail_open", true)
     */
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),
        int numReplicas = 1;
            }
            .put("cluster.routing.weighted.strict", true)
                .setPreference("_only_nodes:" + nodeInZoneA)
        }
        refresh("index");
        logger.info("--> setting shard routing weights for weighted round robin");
            nodeCountPerAZ,
        networkDisruption.stopDisrupting();
        for (int i = 0; i < 50; i++) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .setPreference(customPreference)
                assertEquals(0, searchResponse.getFailedShards());
     * assertions are put to check that search requests fail.
            } catch (Exception t) {
        Set<String> expectedHotNodes = new HashSet<>();
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
                SearchResponse searchResponse = responses[i].get();
        for (int i = 0; i < 50; i++) {
        ensureGreen();
     * @throws IOException throws exception
        );
                .execute();
    public void testStrictWeightedRoutingAllowedForSomeSearchPrefs() {
            .filter(shard -> {
        int numShards = 20;
        assertThrows(
        );
            )
        );
                .prepareSearch("test")
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
            if (stat.getNode().isDataNode()) {
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
        final String clusterManagerNode1 = internalCluster().getClusterManagerName();
                hitNodes.add(searchResponse.getHits().getAt(j).getShard().getNodeId());
        networkDisruption.stopDisrupting();
package org.opensearch.search;
        Map<String, String> nodeIDMap = new HashMap<>();
        int numShards = 10;
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().execute().actionGet();
        }
                break;
        int failedShardCount = 0;
        Settings commonSettings = Settings.builder()
        String nodeInZoneA = nodeMap.get("a").get(0);
        nodeMap.put("a", nodes_in_zone_a);
        final String clusterManagerNode1 = internalCluster().getClusterManagerName();
            .prepareWeightedRouting()
        assertNoSearchInAZ("a");
        setShardRoutingWeights(weights);
            if (node.getAttributes().get("zone").equals(az)) {
        for (int i = 0; i < 50; i++) {
                SearchResponse searchResponse = responses[i].get();
        }
        nodeMap.put("b", nodes_in_zone_b);
        for (DiscoveryNode node : dataNodes) {
        for (int i = 0; i < 100; i++) {
                assertThat(
    }
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().execute().actionGet();
        Set<String> nodesInOneSide = Stream.of(clusterManagerNode1, nodeMap.get("b").get(0), nodeMap.get("c").get(0))
     * @throws IOException throws exception
import org.opensearch.cluster.node.DiscoveryNode;
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
import java.util.concurrent.Future;
import org.opensearch.core.rest.RestStatus;
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
import org.opensearch.action.search.SearchResponse;
            if (stat.getNode().isDataNode()) {
        String B_0 = nodes.get(1);
                    hitNodes.add(searchResponse.getHits().getAt(j).getShard().getNodeId());
        int numShards = 10;
            for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {
        }
     */
            }
        internalCluster().setDisruptionScheme(networkDisruption);
        NetworkDisruption networkDisruption = new NetworkDisruption(
        // making search requests
import org.opensearch.cluster.routing.WeightedRouting;
                .setSize(100)
        int nodeCountPerAZ = 1;
        }
import org.opensearch.action.index.IndexRequestBuilder;
        logger.info("--> data nodes in zone a and b are stopped");
            } catch (Exception t) {
            .put("cluster.routing.weighted.fail_open", true)
        );
        for (int i = 0; i < 50; i++) {
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
        }
                for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {
        Settings commonSettings = Settings.builder()
            }
            } catch (Exception t) {
        final String clusterManagerNode1 = internalCluster().getClusterManagerName();
            responses[i] = client().prepareMultiGet()
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
     * Indices are created with one replica copy and network disruption is introduced,
                .prepareSearch()
        for (int i = 0; i < 50; i++) {
        Set<String> hitNodes = new HashSet<>();
            } catch (Exception t) {
            }
        NetworkDisruption networkDisruption = new NetworkDisruption(
            .setVersion(-1)
        Settings commonSettings = Settings.builder()
                SearchResponse searchResponse = responses[i].get();
        setShardRoutingWeights(weights);
        Set<String> nodesInOneSide = Stream.of(clusterManagerNode1, nodeMap.get("b").get(0)).collect(Collectors.toCollection(HashSet::new));
                    hitNodes.add(searchResponse.getHits().getAt(j).getShard().getNodeId());
        logger.info("--> setting shard routing weights for weighted round robin");
            PreferenceBasedSearchNotAllowedException.class,
                .execute();
                hitNodes.add(searchResponse.getHits().getAt(j).getShard().getNodeId());
            .setQuery(QueryBuilders.matchAllQuery())
     * Weighted shard routing weight is set as 0 for az-c.
                }
        networkDisruption.startDisrupting();
                "_only_nodes:" + nodeIDMap.get(nodeInZoneA) + "," + nodeIDMap.get(nodeInZoneB) + "," + nodeIDMap.get(nodeInZoneC)
        logger.info("--> creating network partition disruption");
        Map<String, List<String>> nodeMap = new HashMap<>();
        NetworkDisruption networkDisruption = new NetworkDisruption(
        setUpIndexing(numShards, numReplicas);
            .put("cluster.routing.weighted.fail_open", true)
        Set<String> nodesInOtherSide = Stream.of(clusterManagerNode1, nodeMap.get("b").get(0), nodeMap.get("c").get(0))
        );
            responses[i] = internalCluster().smartClient().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).execute();
        int numShards = 10;
     * @throws IOException throws exception
                break;
     */
    /**
        for (int i = 0; i < 50; i++) {
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
import org.opensearch.search.aggregations.Aggregations;
        }
            .execute();
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
            .getRoutingTable()
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingResponse;
import org.opensearch.index.search.stats.SearchStats;
                assertEquals(Math.min(numDocs, 3L), terms.getBucketByKey("0").getDocCount());
        String C_0 = nodes.get(4);
        String nodeInZoneA = nodeMap.get("a").get(0);
    public void testStrictWeightedRoutingWithShardPref() throws Exception {
            .put("cluster.routing.weighted.fail_open", false)
        setShardRoutingWeights(weights);
            .put("cluster.routing.weighted.strict", true)
        logger.info("--> starting 6 nodes on different zones");
                .setSize(0)
        for (int i = 0; i < 50; i++) {
        for (String nodeId : nodeIdsFromZoneWithWeightZero) {
        }
                .prepareSearch()
            .build();
    private void assertNoSearchInAZ(String az) {
        Set<String> nodesInOtherSide = Stream.of(nodeMap.get("a").get(0)).collect(Collectors.toCollection(HashSet::new));
        logger.info("--> setting shard routing weights for weighted round robin");
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),
            nodeIDMap.put(node.getName(), node.getId());
        Future<SearchResponse>[] responses = new Future[50];
                .setSize(100)
        for (int i = 0; i < 50; i++) {
        logger.info("--> setting shard routing weights for weighted round robin");
        for (int i = 0; i < 50; i++) {
                failOpenShardCount++;
        assertNoSearchInAZ("c");
        logger.info("--> network disruption is started");
 *
                .setPreference(String.format(Locale.ROOT, "_shards:%s", shardId.getId()))
        assertSearchInAZ("b");
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
        internalCluster().setDisruptionScheme(networkDisruption);
        Set<String> nodesInOneSide = Stream.of(clusterManagerNode1, nodeMap.get("b").get(0), nodeMap.get("c").get(0))
        Assert.assertTrue(failedCount > 0);
            .setPreference(customPreference)
        }
     */
        assertNoSearchInAZ("c");
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()
                Assert.assertTrue(searchStats.getQueryCount() > 0L);
        assertBusy(
        logger.info("--> setting shard routing weights for weighted round robin");
        }
                throw new AssertionError("search should not fail", t);
    public void testStrictWeightedRoutingWithCustomString_FailOpenDisabled() throws Exception {
        Set<String> hitNodes = new HashSet<>();
        networkDisruption.stopDisrupting();
    public void testSearchWithWRRShardRouting() throws IOException {
        for (DiscoveryNode node : dataNodes) {
        assertNoSearchInAZ("a");
            try {
        for (NodeStats stat : nodeStats.getNodes()) {
        int numReplicas = 1;
        setUpIndexing(numShards, numReplicas);
        Set<String> hitNodes = new HashSet<>();
    /**
        );
                }
        Set<String> nodesInOneSide = Stream.of(clusterManagerNode1, nodeMap.get("b").get(0), nodeMap.get("c").get(0))
        List<String> nodes_in_zone_c = internalCluster().startDataOnlyNodes(
        }
        logger.info("--> making search requests");
            }
/*
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
    }
        Settings commonSettings = Settings.builder()
            if (result.contains(shardRouting.shardId())) {
                );
            .prepareSearch()
 * The OpenSearch Contributors require contributions made to
                SearchResponse searchResponse = responses[i].get();
        NetworkDisruption networkDisruption = new NetworkDisruption(
            try {
            .put("cluster.routing.weighted.fail_open", true)
            responses[i] = internalCluster().client(nodeMap.get("c").get(0))
        logger.info("--> setting shard routing weights for weighted round robin");
        networkDisruption.startDisrupting();
import java.util.HashMap;
        Set<String> nodesInOtherSide = Stream.of(nodeMap.get("a").get(0)).collect(Collectors.toCollection(HashSet::new));
import org.junit.Assert;
            responses[i] = internalCluster().client(nodeMap.get("b").get(0))
        assertSearchInAZ("c");
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
            .get();
        for (int i = 0; i < 50; i++) {
        String dataNodeId = null;
            .findFirst()
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
            assertSearchInAZ("c");
                for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().addMetric("weighted_routing").execute().actionGet();
        }
                throw new AssertionError("search should not fail", t);
        logger.info("--> setting shard routing weights for weighted round robin");
                if (multiGetResponse.getResponses()[0].isFailed() || multiGetResponse.getResponses()[1].isFailed()) {
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
            SearchResponse searchResponse = internalCluster().client(randomFrom(A_0, A_1, B_0, B_1))
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().execute().actionGet();
                .setPreference("_prefer_nodes:" + nodeInZoneA)
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        }
                .execute();
        try {
            TimeUnit.SECONDS
import java.util.stream.Collectors;
                }
        searchResponse = internalCluster().client(nodeMap.get("b").get(0)).prepareSearch().setSize(0).setPreference("_shards:1").get();
import java.util.stream.Stream;
        Settings commonSettings = Settings.builder()
                assertThat(multiGetResponse.getResponses()[0].isFailed(), equalTo(false));
            responses[i] = internalCluster().client(nodeMap.get("b").get(0))
            .put("cluster.routing.weighted.strict", false)
            .put("cluster.routing.weighted.fail_open", true)
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
     * Indices are created with one replica copy and network disruption is introduced,
                .add(new MultiGetRequest.Item("test", "" + index1))
            .put("cluster.routing.weighted.fail_open", true)
     */
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeMap.get("a").get(0)));
        int numReplicas = 1;
        networkDisruption.startDisrupting();
    /**
            60,
        NodeStats nodeStatsC = stats.get(nodeIDMap.get(nodeMap.get("c").get(0)));
        setShardRoutingWeights(weights);
    public void testMultiGetWithNetworkDisruption_FailOpenDisabled() throws Exception {
     * in case shard copies are not available in other azs.
                .execute();
        searchResponse = internalCluster().client(nodeMap.get("a").get(0))
        assertSearchInAZ("b");
     * Assertions are put to make sure such shard search requests are served by data node in zone c.
     * This is tested by setting up a 3 node cluster with one data node per az.
import org.opensearch.test.transport.MockTransportService;
     */
                failedCount++;
            .put("cluster.routing.allocation.awareness.attributes", "zone")
            .put("cluster.routing.weighted.strict", true)
        for (NodeStats stat : nodeStats.getNodes()) {
        int numReplicas = 2;
            .prepareWeightedRouting()
        String nodeInZoneA = nodeMap.get("a").get(0);
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build(),
            SearchStats.Stats searchStats = stat.getIndices().getSearch().getTotal();
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
            assertSearchInAZ("c");
        );
     * Weighted shard routing weight is set as 0 for az-c.
        setUpIndexing(numShards, numReplicas);
        setUpIndexing(numShards, numReplicas);
            .put("cluster.routing.weighted.strict", true)
        Settings commonSettings = Settings.builder()
        assertNoSearchInAZ("c");
        refresh("test");
        nodeMap.put("c", nodes_in_zone_c);
        final Map<String, DiscoveryNode> dataNodes = internalCluster().clusterService().state().nodes().getDataNodes();
        assertEquals(RestStatus.OK.getStatus(), searchResponse.status().getStatus());
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
            .cluster()
                assertEquals(0, searchResponse.getFailedShards());
        for (int i = 0; i < 50; i++) {
                assertThat(
        searchResponse = internalCluster().client(nodeMap.get("b").get(0)).prepareSearch().setSize(0).setPreference(customPreference).get();
        assertAcked(
        int index1, index2;
        Settings commonSettings = Settings.builder()
     * Shard routing request is served by data nodes in az with weight set as 0,
import java.util.Iterator;
        for (int i = 0; i < 50; i++) {
            try {
        logger.info("--> creating network partition disruption");
                assertThat(
                .setQuery(QueryBuilders.matchAllQuery())
                assertThat(multiGetResponse.getResponses().length, equalTo(2));
            NetworkDisruption.UNRESPONSIVE
                .setSettings(Settings.builder().put("index" + ".number_of_shards", 10).put("index" + ".number_of_replicas", 1))
        for (String nodeId : nodeIdsFromZoneWithWeightZero) {
            NetworkDisruption.UNRESPONSIVE
    }
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
            assertSearchInAZ("b");
        int index1, index2;
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        ensureGreen();
        int nodeCountPerAZ = 1;
     * This is tested by setting up a 3 node cluster with one data node per az.
            } catch (Exception t) {
                Settings.builder().put("index.number_of_shards", numShards).put("index.number_of_replicas", numReplicas)
            .build();
        networkDisruption.stopDisrupting();
    }
            try {
    public void testWeightedRoutingFailOpenStats() throws Exception {
        int numShards = 1;
        for (int i = 0; i < 50; i++) {
        SearchResponse searchResponse = internalCluster().client(nodeMap.get("b").get(0))
        assertSearchInAZ("c");
        Future<MultiGetResponse>[] responses = new Future[50];
        // search should not go to nodes in zone c with weight zero in case
        internalCluster().setDisruptionScheme(networkDisruption);
 * compatible open source license.
     * This is tested by setting up a 3 node cluster with one data node per az.
            PreferenceBasedSearchNotAllowedException.class,
            .build();
     * Since there are two copies of a shard, there can be few shards for which copy doesn't exist in zone b.
        for (int i = 0; i < 50; i++) {
        Settings commonSettings = Settings.builder()
        logger.info("--> deleted shard routing weights for weighted round robin");
        int failedCount = 0;
     */
                assertNotEquals(searchResponse.getHits().getTotalHits().value(), 0);
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),
            .build();
     * Assert that preference search with custom string doesn't hit a node in weighed away az
            if (stat.getNode().getAttributes().get("zone").equals("c")) {
        assertSearchInAZ("b");
            .put("cluster.routing.weighted.fail_open", true)
        ShardId shardId = internalCluster().clusterService()
        DiscoveryNodes dataNodes = internalCluster().clusterService().state().nodes();
     * Since there are two copies of a shard, there can be few shards for which copy doesn't exist in zone b.
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
     * Indices are created with one replica copy and network disruption is introduced,
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, minNumDataNodes = 3)
        logger.info("--> creating network partition disruption");
        SearchResponse searchResponse = internalCluster().client(nodeMap.get("b").get(0))
        assertEquals(RestStatus.OK.getStatus(), searchResponse.status().getStatus());
    }
        Set<String> nodesInOtherSide = Stream.of(nodeMap.get("a").get(0)).collect(Collectors.toCollection(HashSet::new));
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        logger.info("--> network disruption is started");
                .execute();
            .setSize(20)
        int numReplicas = 1;
        int nodeCountPerAZ = 1;
        DiscoveryNodes dataNodes = internalCluster().clusterService().state().nodes();
            .prepareSearch()
            NetworkDisruption.UNRESPONSIVE
        networkDisruption.stopDisrupting();
        logger.info("--> network disruption is stopped");
     * Should failopen shards even if failopen enabled with custom search preference.
        String nodeInZoneC = nodeMap.get("c").get(0);
        logger.info("--> creating network partition disruption");
            () -> assertThat(client().admin().indices().prepareStats().get().getTotal().getSearch().getOpenContexts(), equalTo(0L)),
        int failedCount = 0;
                .addAggregation(terms("f").field("f"))
     * MultiGet with fail open disabled. Assert that some requests do fail.
     * Since there are two copies of a shard, there can be few shards for which copy doesn't exist in zone b.
                .execute();
            if (node.getAttributes().getOrDefault("zone", "").equals("b")) {
    }
    /**
        ClusterDeleteWeightedRoutingResponse deleteResponse = client().admin().cluster().prepareDeleteWeightedRouting().setVersion(0).get();
        setUpIndexing(numShards, numReplicas);
        int nodeCountPerAZ = 1;
        logger.info("--> setting shard routing weights for weighted round robin");
            .collect(Collectors.toCollection(HashSet::new));
                .setQuery(QueryBuilders.matchAllQuery())
        logger.info("--> setting shard routing weights for weighted round robin");
        DiscoveryNodes dataNodes = internalCluster().clusterService().state().nodes();
                Assert.assertTrue(searchStats.getFetchCount() > 0L);
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
        final String clusterManagerNode1 = internalCluster().getClusterManagerName();
            TimeUnit.SECONDS
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
     * This is tested by setting up a 3 node cluster with one data node per az.
        }
                }
            .get();
    private void assertSearchInAZ(String az) {
    public void testPreferenceSearchWithIgnoreWeightedRouting() {
        Map<String, String> nodeIDMap = new HashMap<>();
        Set<String> nodesInOtherSide = Stream.of(nodeMap.get("a").get(0)).collect(Collectors.toCollection(HashSet::new));
        int nodeCountPerAZ = 1;
        assertSearchInAZ("b");
            SearchStats.Stats searchStats = stat.getIndices().getSearch().getTotal();
            assertFalse(!hitNodes.contains(nodeId));
import java.io.IOException;
                .execute();
        logger.info("--> network disruption is stopped");
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
        int failedCount = 0;
        Map<String, List<String>> nodeMap = setupCluster(nodeCountPerAZ, commonSettings);
            () -> internalCluster().client(nodeMap.get("b").get(0))
        ShardId shardId = internalCluster().clusterService()
        List<ShardRouting> shardInNodeC = internalCluster().clusterService()
        networkDisruption.stopDisrupting();
            .put("cluster.routing.allocation.awareness.attributes", "zone")
            .shardsWithState(ShardRoutingState.STARTED);
                failedShardCount += searchResponse.getFailedShards();
            .put("cluster.routing.allocation.awareness.attributes", "zone")
                for (int j = 0; j < searchResponse.getHits().getHits().length; j++) {
            try {
        for (NodeStats stat : nodeStats.getNodes()) {
        internalCluster().setDisruptionScheme(networkDisruption);
import org.opensearch.action.search.SearchPhaseName;
        networkDisruption.stopDisrupting();
        setUpIndexing(numShards, numReplicas);
        setUpIndexing(numShards, numReplicas);
        Settings commonSettings = Settings.builder()
