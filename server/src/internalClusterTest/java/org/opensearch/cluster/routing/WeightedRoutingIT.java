        ensureGreen();  
    }
import java.util.stream.Collectors;
            .admin()
            .get();
                .get()  
            internalCluster().client(nodes_in_zone_a.get(0))
        );
        }, 13, TimeUnit.SECONDS);
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());  
                .cluster()
            .setRequestLocal(true)  
        );
        Settings commonSettings = Settings.builder()
        assertBusy(() -> {
        logger.info("--> waiting for nodes to form a cluster");
        );
        logger.info("--> waiting for nodes to form a cluster");
    }
            .cluster()  
        logger.info("--> shard to node mappings: {}", shardToNodes);
        List<String> nodes_in_zone_b = internalCluster().startDataOnlyNodes(  
            nodeCountPerAZ,  
    @Override
            .cluster()  
            .prepareWeightedRouting()
        Settings commonSettings = Settings.builder()
            .get();
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingResponse;
                .cluster()
        logger.info("--> waiting for nodes to form a cluster");  
        WeightedRouting weightedRouting1 = new WeightedRouting("zone", weights);  
        then there was a regression in the custom preference string.
import java.util.Set;
        internalCluster().startClusterManagerOnlyNode(Settings.builder().put(commonSettings).build());
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
            .prepareWeightedRouting()
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        String clusterManager = internalCluster().startClusterManagerOnlyNode(Settings.builder().put(commonSettings).build());
            .setAwarenessAttribute("zone")
        // get weights call
            internalCluster().client(nodes_in_zone_b.get(0))
        Settings commonSettings = Settings.builder()  
        internalCluster().startNodes(
        Map<String, Double> weights = Map.of("a", 1.0, "b", 2.0, "c", 3.0);
            .put("cluster.search.ignore_awareness_attributes", false)
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());
import org.opensearch.common.settings.Settings;  
        // put api call to set weights  
            // Check local cluster health  
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()  
import java.util.HashMap;
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
            .put("cluster.fault_detection.leader_check.retry_count", 1)
            assertFalse(clusterHealthResponse.isTimedOut());
        logger.info("--> setting shard routing weights for weighted round robin");
        );
        logger.info("--> starting 1 nodes on zones 'a' & 'b' & 'c'");
                .getState()
        ensureGreen();
        );  
            .setVersion(-1)
                .get()
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()
        assertFalse(nodeLocalHealth.isTimedOut());
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
        assertThat(health.isTimedOut(), equalTo(false));
        UnsupportedWeightedRoutingStateException exception = expectThrows(
    public void testPutWeightedRouting_InvalidAwarenessAttribute() {
        // delete weighted routing metadata
        response = internalCluster().client(randomFrom(nodes_in_zone_a.get(0), nodes_in_zone_a.get(1)))
        assertEquals(3, internalCluster().clusterService().state().nodes().getDataNodes().size());  
            .get();  
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());  
import org.opensearch.test.disruption.NetworkDisruption;
            NetworkDisruption.DISCONNECT
        logger.info("--> setting shard routing weights for weighted round robin");  
        // make sure restarted node joins the cluster
        ensureGreen();
        weights = Map.of("a", 1.0, "b", 2.0, "c", 6.0);  
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("3").execute().actionGet();
        ensureGreen("test_index");
            nodeCountPerAZ,
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()
        internalCluster().startClusterManagerOnlyNode(Settings.builder().put(commonSettings).build());
        logger.info("--> setting shard routing weights for weighted round robin");  
            .prepareGetWeightedRouting()  
        // Check cluster health for weighed in node, health check should return a response with 200 status code  
        logger.info("--> setting shard routing weights for weighted round robin");  
    public void testReadWriteWeightedRoutingMetadataOnNodeRestart() throws Exception {  
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("4").execute().actionGet();  
                .cluster()
        assertThat(health.isTimedOut(), equalTo(false));
        assertThat(health.isTimedOut(), equalTo(false));
        assertEquals(response.isAcknowledged(), true);
        /*
        internalCluster().restartRandomDataNode();
            // Check cluster health for weighed in node when cluster manager is not discovered, health check should
        List<String> nodes_in_zone_a = internalCluster().startDataOnlyNodes(
        );  
        internalCluster().startDataOnlyNodes(nodeCountPerAZ, Settings.builder().put(commonSettings).put("node.attr.zone", "b").build());  
        );
        List<String> nodes_in_zone_b = internalCluster().startDataOnlyNodes(  
        List<String> nodes_in_zone_c = internalCluster().startDataOnlyNodes(
            .collect(Collectors.toCollection(HashSet::new));
        Set<String> nodesInOneSide = Stream.of(nodes_in_zone_a.get(0), nodes_in_zone_b.get(0), nodes_in_zone_c.get(0))
import java.util.List;  
import java.util.HashSet;
        Settings commonSettings = Settings.builder()  
                .getState()
        internalCluster().restartNode(internalCluster().getClusterManagerName(), new InternalTestCluster.RestartCallback());
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")  
        for (int i = 0; i < 20; i++) {
            nodeCountPerAZ,
                .get()  
        ensureGreen();  
        ClusterGetWeightedRoutingResponse weightedRoutingResponse = client().admin()
            .admin()
        ClusterPutWeightedRoutingResponse response = client().admin()  
        assertTrue(weightedRoutingResponse.getDiscoveredClusterManager());
            .get();
            .prepareWeightedRouting()
        );
            .put("cluster.routing.allocation.awareness.attributes", "zone")  
            .setVersion(-1)
            .put("cluster.fault_detection.leader_check.timeout", 10000 + "ms")
        ClusterPutWeightedRoutingResponse response = client().admin()
        List<String> nodes_in_zone_a = internalCluster().startDataOnlyNodes(  
        ClusterHealthResponse healthResponse = client(nodes_in_zone_c.get(0)).admin()
import org.opensearch.core.rest.RestStatus;
        List<String> nodes_in_zone_b = internalCluster().startDataOnlyNodes(
        );
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("7").execute().actionGet();
            .cluster()  
        // routing weights are set in cluster metadata
        ClusterDeleteWeightedRoutingResponse deleteResponse = client().admin().cluster().prepareDeleteWeightedRouting().setVersion(0).get();
        // delete weights  
        weights = Map.of("a", 1.0, "b", 2.0, "c", 4.0);
        ensureGreen();
        NetworkDisruption networkDisruption = new NetworkDisruption(  
        logger.info("--> starting a dedicated cluster manager node");
        List<String> nodes_in_zone_b = internalCluster().startDataOnlyNodes(
    public void testGetWeightedRouting_WeightsAreSet() throws IOException {
        weightedRoutingResponse = internalCluster().client(randomFrom(nodes_in_zone_b.get(0), nodes_in_zone_b.get(1)))  
        List<String> nodes_in_zone_b = internalCluster().startDataOnlyNodes(  
        }, 1, TimeUnit.MINUTES);  
        ensureGreen();
            .setVersion(-1)  
            assertEquals(weightedRouting, weightedRoutingResponse.weights());  
        // delete weights by awareness attribute
        Settings commonSettings = Settings.builder()
        ensureStableCluster(3);
            .setRequestLocal(true)
        );  
        logger.info("--> setting shard routing weights for weighted round robin");
        // Configure cluster with awareness attributes  
            .cluster()  
        internalCluster().startClusterManagerOnlyNode(Settings.builder().put(commonSettings).build());  
                .get();  
            .get();
        );
        assertTrue(deleteResponse.isAcknowledged());
            nodeCountPerAZ,  
                .weightedRoutingMetadata()
        assertThat(health.isTimedOut(), equalTo(false));
        ClusterPutWeightedRoutingResponse response = client().admin()
            .cluster()
            prepareCreate("test_index").setSettings(  
        ensureGreen();
    public void testClusterHealthResponseWithEnsureNodeWeighedInParam() throws Exception {  
            .setWeightedRouting(weightedRouting)  
        internalCluster().restartRandomDataNode();  
        ensureGreen();
            .admin()
            .prepareWeightedRouting()  
    }  
        // delete weighted routing metadata
        /*  
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("3").execute().actionGet();  
            SearchResponse response = client().prepareSearch("test_index")  
            assertFalse(weightedRoutingResponse.getDiscoveredClusterManager());
                .metadata()
            .collect(Collectors.toCollection(HashSet::new));  
        internalCluster().startDataOnlyNodes(2, Settings.builder().put(commonSettings).put("node.attr.rack", "rack1").build());
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());  
            .cluster()
        assertEquals(response.isAcknowledged(), true);
            .cluster()
 * SPDX-License-Identifier: Apache-2.0
        ensureGreen();  
        for (Map.Entry<String, Set<String>> entry : shardToNodes.entrySet()) {
                .cluster()
                .cluster()
                .cluster()
            .setRequestLocal(true)
        NodeWeighedAwayException ex = expectThrows(
            ClusterGetWeightedRoutingResponse weightedRoutingResponse = internalCluster().client(  
                .cluster()  
            .execute()
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()  
        Map<String, Double> weights = Map.of("a", 1.0, "b", 2.0, "c", 3.0);  
import java.util.concurrent.TimeUnit;  
                .weightedRoutingMetadata()
                .setPreference("test_preference_123")
                .getState()
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("4").execute().actionGet();
                .get()  
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        assertThat(health.isTimedOut(), equalTo(false));
    public void testWeightedRoutingOnOSProcessRestartAfterWeightDelete() throws Exception {  
        assertThat(health.isTimedOut(), equalTo(false));  
            .build();
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("3").execute().actionGet();
            .build();  
        internalCluster().startNodes(  
        logger.info("--> waiting for nodes to form a cluster");  
        Map<String, Double> weights = Map.of("a", 1.0, "b", 2.0, "c", 3.0);
            assertThrows(  
     * For regression in custom string query preference with awareness attributes enabled.
        // put api call to set weights
        assertTrue(response.isAcknowledged());
        assertEquals(response.isAcknowledged(), true);  
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("3").execute().actionGet();  
            .put("cluster.routing.allocation.awareness.attributes", "zone")
    }  
        ensureStableCluster(3);  
        Execute the same match all query with custom string preference.
        );
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),  
            .setAwarenessAttribute("zone")
            .get();  
        ClusterGetWeightedRoutingResponse weightedRoutingResponse = client().admin()
        response = client().admin()
            .setWeightedRouting(weightedRouting)
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
    }  
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        logger.info("--> setting shard routing weights for weighted round robin");  
            for (int j = 0; j < response.getHits().getHits().length; j++) {
            ).admin().cluster().prepareGetWeightedRouting().setAwarenessAttribute("zone").setRequestLocal(true).get();
        For each search and each shard in the response we record the node on which the shard was located.  
                String shardId = response.getHits().getAt(j).getShard().getShardId().toString();  
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
        ensureGreen();  
            .get();  
        weights = Map.of("a", 1.0, "b", 2.0, "c", 5.0);  
        ClusterHealthResponse nodeLocalHealth = client(nodes_in_zone_a.get(0)).admin()
            .put("cluster.routing.allocation.awareness.attributes", "rack")
            .admin()  
package org.opensearch.cluster.routing;
            .put("cluster.routing.allocation.awareness.attributes", "zone")  
    }
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);  
            .cluster()
        }
                .weightedRoutingMetadata()  
    }  
            }  
import org.opensearch.test.transport.MockTransportService;
            .get();  
            () -> client().admin().cluster().prepareDeleteWeightedRouting().setVersion(7).get()
            .put("cluster.routing.allocation.awareness.attributes", "zone")
                () -> client(nodes_in_zone_c.get(0)).admin().cluster().prepareHealth().setLocal(true).setEnsureNodeWeighedIn(true).get()  
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
/*  
        );  
            .get();
        logger.info("--> starting a dedicated cluster manager node");
        internalCluster().restartNode(nodes_in_zone_a.get(0), new InternalTestCluster.RestartCallback());
public class WeightedRoutingIT extends OpenSearchIntegTestCase {  
        Map<String, Double> weights = Map.of("a", 1.0, "b", 2.0, "c", 3.0);
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),  
        ClusterPutWeightedRoutingResponse response = client().admin()
        logger.info("--> waiting for nodes to form a cluster");  
            .prepareGetWeightedRouting()  
                .cluster()
            .prepareHealth()  
                .admin()  
            internalCluster().client(nodes_in_zone_c.get(0))
            .put("cluster.routing.allocation.awareness.attributes", "zone")
                .metadata()  
        ClusterDeleteWeightedRoutingResponse deleteResponse = client().admin().cluster().prepareDeleteWeightedRouting().setVersion(0).get();
            .prepareWeightedRouting()  
        Settings commonSettings = Settings.builder()
            assertTrue(deleteResponse.isAcknowledged());
        // get api to fetch local weighted routing for a node in zone a or b
import org.opensearch.snapshots.mockstore.MockRepository;
        Map<String, Double> weights = Map.of("a", 1.0, "b", 0.0, "c", 0.0);
    public void testDeleteWeightedRouting_WeightsNotSet() {
                .state(new ClusterStateRequest().local(true))
    }
        // make sure restarted node joins the cluster  
            );
            .cluster()
        assertTrue(response.isAcknowledged());  
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),
 * The OpenSearch Contributors require contributions made to  
        // Create index with specific shard configuration
        // update weights api call with incorrect version number
            .setWeightedRouting(weightedRouting)
                shardToNodes.computeIfAbsent(shardId, k -> new HashSet<>()).add(nodeId);
            .get();  
        );
        assertTrue(response.isAcknowledged());
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("3").execute().actionGet();  
        assertTrue(deleteResponse.isAcknowledged());
        );  
            IllegalArgumentException.class,
            .setWeightedRouting(weightedRouting)
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, minNumDataNodes = 3)
            .setWeightedRouting(weightedRouting)
            .put("cluster.routing.allocation.awareness.attributes", "zone")
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")  
        ensureGreen();  
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")  
        Map<String, Double> weights = Map.of("a", 1.0, "b", 2.0, "c", 3.0);
        assertNotNull(  
        networkDisruption.startDisrupting();
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),
        internalCluster().startClusterManagerOnlyNode(Settings.builder().put(commonSettings).build());
        logger.info("--> network disruption is started");  
            assertThat("Shard " + entry.getKey() + " should consistently route to the same node", entry.getValue().size(), equalTo(1));  
            () -> client().admin().cluster().prepareWeightedRouting().setWeightedRouting(weightedRouting1).setVersion(100).get()  
         */  
                .get()
            // return a response with 503 status code  
                ClusterManagerNotDiscoveredException.class,
        refreshAndWaitForReplication("test_index");
                .state(new ClusterStateRequest().local(true))  
            nodeCountPerAZ,  
        assertThat(health.isTimedOut(), equalTo(false));  
        If more than one node was responsible for serving a request for a given shard,
        logger.info("--> waiting for nodes to form a cluster");  
        logger.info("--> setting shard routing weights for weighted round robin");  
        assertTrue(deleteResponse.isAcknowledged());  
        List<String> nodes_in_zone_c = internalCluster().startDataOnlyNodes(
        ClusterPutWeightedRoutingResponse response = client().admin()  
    public void testPutWeightedRouting_MoreThanOneZoneHasZeroWeight() {  
        logger.info("--> waiting for nodes to form a cluster");  
        assertTrue(deleteResponse.isAcknowledged());
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("4").execute().actionGet();
import java.io.IOException;
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        );  
            .setLocal(true)
            .cluster()
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),  
        );  
            UnsupportedWeightedRoutingStateException.class,  
            client().prepareIndex("test_index").setId(String.valueOf(i)).setSource("field", "value" + i).get();  
    }  
        logger.info("--> starting 2 nodes on zones 'a' & 'b' & 'c'");
            .setWeightedRouting(weightedRouting)  
        assertThat(health.isTimedOut(), equalTo(false));
        ensureGreen();
        // get api to fetch local weighted routing for a node in zone a  
            .get();
        weightedRouting = new WeightedRouting("zone", weights);  
import org.opensearch.ResourceNotFoundException;
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        ClusterDeleteWeightedRoutingResponse deleteResponse = client().admin().cluster().prepareDeleteWeightedRouting().setVersion(0).get();  
                .getState()
        internalCluster().startNodes(  
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
    }
                .execute()
            .setWeightedRouting(weightedRouting)
        assertThat(healthResponse.getIndices().isEmpty(), equalTo(true));  
                .prepareHealth()  
            NetworkDisruption.DISCONNECT  
            .build();
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("3").execute().actionGet();
        assertEquals(weightedRouting, weightedRoutingResponse.weights());
            .prepareHealth("test1")
                .get()
        ClusterGetWeightedRoutingResponse weightedRoutingResponse = client().admin()
            ResourceNotFoundException.class,  
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
     * We expect preference will consistently route to the same shard replica. However, when awareness attributes
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        );  
            // Check cluster health for weighed away node when cluster manager is not discovered, health check should
            .put("cluster.routing.allocation.awareness.force.rack.values", "rack1,rack2")  
        // update weights again and make sure that version number got updated on delete
        ensureGreen();
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        response = client().admin().cluster().prepareWeightedRouting().setWeightedRouting(weightedRouting).setVersion(0).get();
            () -> client().admin().cluster().prepareDeleteWeightedRouting().setVersion(-1).get()
        int nodeCountPerAZ = 2;
        ClusterPutWeightedRoutingResponse response = client().admin()
        Map<String, Double> weights = Map.of("a", 1.0, "b", 2.0, "c", 3.0);
        networkDisruption.stopDisrupting();
            .put("cluster.routing.use_adaptive_replica_selection", false)
                Settings.builder().put("index.number_of_shards", 6).put("index.number_of_replicas", 1).build()
        );
            .put("cluster.routing.allocation.awareness.attributes", "zone")
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
            nodeCountPerAZ,
                .setVersion(0)  
            .setVersion(2)
        List<String> nodes_in_zone_c = internalCluster().startDataOnlyNodes(
        ensureGreen();
        ensureGreen();
                () -> client(nodes_in_zone_a.get(0)).admin().cluster().prepareHealth().setLocal(true).setEnsureNodeWeighedIn(true).get()
            UnsupportedWeightedRoutingStateException.class,
            .build();
            // return a response with 503 status code
            nodeCountPerAZ,
        return Arrays.asList(MockTransportService.TestPlugin.class, MockRepository.Plugin.class);
        }
        assertNotNull(
        internalCluster().startDataOnlyNodes(nodeCountPerAZ, Settings.builder().put(commonSettings).put("node.attr.zone", "c").build());
        weightedRouting = new WeightedRouting("zone", weights);
        assertEquals(response.isAcknowledged(), true);
            .prepareWeightedRouting()
        assertEquals(RestStatus.NOT_FOUND, exception.status());  
            nodeCountPerAZ,
import org.opensearch.discovery.ClusterManagerNotDiscoveredException;
 */  
        );  
         */  
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")  
            .cluster()  
        weightedRoutingResponse = internalCluster().client(randomFrom(nodes_in_zone_c.get(0), nodes_in_zone_c.get(1)))
        logger.info("--> waiting for nodes to form a cluster");
            nodeCountPerAZ,  
        logger.info("--> waiting for nodes to form a cluster");  
        assertThat(health.isTimedOut(), equalTo(false));
            .prepareGetWeightedRouting()
        assertThat(healthResponse.getStatus(), equalTo(ClusterHealthStatus.RED));
import org.opensearch.test.OpenSearchIntegTestCase;  
        List<String> nodes_in_zone_a = internalCluster().startDataOnlyNodes(
        logger.info("--> stop network disruption");
        // check weighted routing metadata after node restart, ensure node comes healthy after restart
                .metadata()
                .get();
            .setVersion(-1)  
                .weightedRoutingMetadata()
        List<String> nodes_in_zone_a = internalCluster().startDataOnlyNodes(
        // get api call to fetch weights  
        assertBusy(() -> {
                .metadata()
            .cluster()
        assertThat(health.isTimedOut(), equalTo(false));
    }
        Set<String> nodesInOneSide = Stream.of(nodes_in_zone_a.get(0), nodes_in_zone_b.get(0), nodes_in_zone_c.get(0))  
            .setWeightedRouting(weightedRouting)
        assertThat(healthResponse.isTimedOut(), equalTo(true));
        // put api call to set weights  
            .prepareGetWeightedRouting()
            nodeCountPerAZ,
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        ensureStableCluster(5);
    public void testGetWeightedRouting_ClusterManagerNotDiscovered() throws Exception {
    public void testGetWeightedRouting_WeightsNotSet() {
                .weightedRoutingMetadata()  
            .setVersion(0)  
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
        logger.info("--> setting shard routing weights for weighted round robin");
        );
                .state(new ClusterStateRequest().local(true))
        logger.info("--> setting shard routing weights for weighted round robin");  
        internalCluster().startNodes(  
        // put api call to set weights
                .setEnsureNodeWeighedIn(true)
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                .state(new ClusterStateRequest().local(true))
        assertTrue(weightedRoutingResponse.getDiscoveredClusterManager());
                .state(new ClusterStateRequest().local(true))  
            nodeCountPerAZ,
                .get();
        int nodeCountPerAZ = 2;
        assertNotNull(
            .prepareWeightedRouting()  
        // update weights api call with correct version number
    public void testPutWeightedRouting() {
        List<String> nodes_in_zone_a = internalCluster().startDataOnlyNodes(
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        assertTrue(ex.getMessage().contains("local node is weighed away"));
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()
        assertNotNull(
        // Check cluster health for weighed away node, health check should respond with an exception  
            .cluster()
            internalCluster().client(internalCluster().getClusterManagerName())
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
            .setVersion(weightedRoutingResponse.getVersion())  
    }
        int nodeCountPerAZ = 2;
        assertTrue(deleteResponse.isAcknowledged());  
            .setAwarenessAttribute("zone")
        logger.info("--> starting a dedicated cluster manager node");  
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
            IllegalArgumentException.class,
                .getState()  
            .setAwarenessAttribute("zone")  
        internalCluster().startClusterManagerOnlyNode(commonSettings);  
            .prepareWeightedRouting()
                .metadata()  
            .prepareDeleteWeightedRouting()
        internalCluster().setDisruptionScheme(networkDisruption);
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());  
                .admin()  
                randomFrom(nodes_in_zone_a.get(0), nodes_in_zone_b.get(0))
            ClusterDeleteWeightedRoutingResponse deleteResponse = client().admin()  
            .cluster()
        logger.info("--> setting shard routing weights for weighted round robin");
            .prepareGetWeightedRouting()  
        networkDisruption.stopDisrupting();
        assertEquals(weightedRouting, weightedRoutingResponse.weights());  
            .build();
                .getState()
            .setVersion(-1)
            .build();  
            .get();
                .state(new ClusterStateRequest().local(true))  
        weightedRoutingResponse = internalCluster().client(randomFrom(nodes_in_zone_a.get(0), nodes_in_zone_a.get(1)))
        // routing weights are set in cluster metadata
                .prepareDeleteWeightedRouting()
        logger.info("--> starting 3 nodes on different zones");  
        // Restart a random data node and check that OS process comes healthy  
        Settings commonSettings = Settings.builder()
        logger.info("--> network disruption is started");
import java.util.stream.Stream;
        assertTrue(response.isAcknowledged());  
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
        // Restart a random data node and check that OS process comes healthy
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingResponse;  
            internalCluster().client(nodes_in_zone_c.get(0))
            internalCluster().client(nodes_in_zone_b.get(0))  
        // get api to fetch local weighted routing for a node in zone b
            )
    public void testWeightedRoutingMetadataOnOSProcessRestart() throws Exception {
            .prepareGetWeightedRouting()
        ensureGreen();
        List<String> nodes_in_zone_c = internalCluster().startDataOnlyNodes(  
        logger.info("--> starting 6 nodes on different zones");
import java.util.Collection;  
        logger.info("--> running cluster health on an index that does not exists");
            .setAwarenessAttribute("zone")  
            1,
            .build();
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingResponse;
        );  
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()  
        logger.info("--> setting shard routing weights for weighted round robin");  
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),  
            .actionGet();  
        // get api to fetch local weighted routing for a node in zone c
        assertTrue(response.isAcknowledged());
            .build();
            .get();
            .get();  
            .prepareWeightedRouting()  
        );
            NodeWeighedAwayException.class,
            .cluster()
                .metadata()
                .admin()  
        ClusterDeleteWeightedRoutingResponse deleteResponse = client().admin()  
            // delete weights
        int nodeCountPerAZ = 1;
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("7").execute().actionGet();
        assertAcked(
        logger.info("--> starting 2 nodes on zones 'a' & 'b' & 'c'");
        assertNotNull(
        internalCluster().startNodes(
        for (int i = 0; i < 30; i++) {
                .cluster()
            internalCluster().client(nodes_in_zone_a.get(0))  
        Settings commonSettings = Settings.builder()  
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());
 * compatible open source license.
            clusterHealthResponse = client(nodes_in_zone_c.get(0)).admin()
     */
        logger.info("--> starting a dedicated cluster manager node");
        ensureGreen();
        deleteResponse = client().admin().cluster().prepareDeleteWeightedRouting().setVersion(4).get();
        Settings commonSettings = Settings.builder()
            .build();  
        internalCluster().startNodes(
        internalCluster().setDisruptionScheme(networkDisruption);
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
            internalCluster().client(internalCluster().getClusterManagerName())  
 * this file be licensed under the Apache-2.0 license or a
        weightedRouting = new WeightedRouting("zone", weights);
        internalCluster().startDataOnlyNodes(2, Settings.builder().put(commonSettings).put("node.attr.rack", "rack2").build());
        assertNotNull(  
        // put call made on a data node in zone a  
                .state(new ClusterStateRequest().local(true))
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
        assertBusy(() -> {  
        }, 1, TimeUnit.MINUTES);
                .prepareHealth()  
        // Index test documents
        Otherwise, the custom string pref is not producing consistent shard routing.
            .build();  
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;  
                .weightedRoutingMetadata()  
            assertThrows(
import org.opensearch.plugins.Plugin;  
        assertEquals(RestStatus.CONFLICT, deleteException.status());  
                ClusterManagerNotDiscoveredException.class,
     * are configured this does not hold.  
        internalCluster().startNodes(
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()  
        logger.info("--> starting 1 nodes on zones 'a' & 'b' & 'c'");
            .setEnsureNodeWeighedIn(true)
        // update weights call using version returned by get api call
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);  
        assertTrue(weightedRoutingResponse.getDiscoveredClusterManager());
        UnsupportedWeightedRoutingStateException deleteException = expectThrows(
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("7").execute().actionGet();
            .build();  
            .get();
        assertThat(health.isTimedOut(), equalTo(false));
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
        );
        );
        assertThat(health.isTimedOut(), equalTo(false));
        );  
        );
        );
            .setEnsureNodeWeighedIn(true)  
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()  
        assertEquals(response.isAcknowledged(), true);
        assertEquals(weightedRouting, weightedRoutingResponse.weights());
        internalCluster().startDataOnlyNodes(nodeCountPerAZ, Settings.builder().put(commonSettings).put("node.attr.zone", "a").build());
                .getState()
            .put("cluster.routing.allocation.awareness.attributes", "zone")
            .put("cluster.routing.allocation.awareness.attributes", "zone")
                .get()
            .setTimeout("1s")
            .setVersion(-1)
            .setWeightedRouting(weightedRouting)
        );
                .cluster()
        WeightedRouting weightedRouting = new WeightedRouting("zone1", weights);
        assertNull(weightedRoutingResponse.weights());  
        // delete weights call, incorrect version number
        Settings commonSettings = Settings.builder()
            ClusterHealthResponse clusterHealthResponse = client().admin()
            1,  
 *
            .prepareWeightedRouting()  
        ClusterPutWeightedRoutingResponse response = client().admin()
                .getState()  
            .setWeightedRouting(weightedRouting)
        );
        );  
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()  
        logger.info("--> starting 2 nodes on zones 'a' & 'b' & 'c'");  
            .build();
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
    }
        logger.info("--> waiting for nodes to form a cluster");
                .state(new ClusterStateRequest().local(true))
import java.util.Arrays;
        );
            1,
        int nodeCountPerAZ = 1;
        assertNull(weightedRoutingResponse.getDiscoveredClusterManager());
            .cluster()
            .setWeightedRouting(weightedRouting)
            .cluster()  
        Map<String, Double> weights = Map.of("a", 1.0, "b", 2.0, "c", 3.0);
        }
import org.opensearch.test.InternalTestCluster;
            );  
            .setAwarenessAttribute("zone")
        assertTrue(weightedRoutingResponse.getDiscoveredClusterManager());  
                .setSize(30)  
                .weightedRoutingMetadata()
        assertEquals(exception.status(), RestStatus.CONFLICT);
    public void testCustomPreferenceShardIdCombination() {
        ensureGreen();
import org.opensearch.action.search.SearchResponse;
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        Settings commonSettings = Settings.builder()
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("3").execute().actionGet();
                .setLocal(true)
            assertTrue(clusterHealthResponse.hasDiscoveredClusterManager());
            () -> client(nodes_in_zone_c.get(0)).admin().cluster().prepareHealth().setLocal(true).setEnsureNodeWeighedIn(true).get()  
            .get();  
            .cluster()
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    }
        logger.info("--> waiting for nodes to form a cluster");
                .admin()
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        NetworkDisruption networkDisruption = new NetworkDisruption(
        List<String> nodes_in_zone_c = internalCluster().startDataOnlyNodes(
            nodeCountPerAZ,
                .setWaitForNodes("4")
import org.opensearch.cluster.health.ClusterHealthStatus;
            .setVersion(-1)
        assertThrows(  
        Map<String, Set<String>> shardToNodes = new HashMap<>();
        response = client().admin().cluster().prepareWeightedRouting().setWeightedRouting(weightedRouting).setVersion(3).get();
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());
        // Start cluster
        assertNotNull(
        Map<String, Double> weights = Map.of("a", 1.0, "b", 2.0, "c", 3.0);  
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()  
        assertEquals(response.isAcknowledged(), true);
        ensureGreen();
                .admin()
                .admin()
        ResourceNotFoundException exception = expectThrows(
                .setQuery(matchAllQuery())
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());  
            .put("cluster.routing.allocation.awareness.attributes", "zone")
    public void testPutAndDeleteWithVersioning() throws Exception {
            .setVersion(-1)
            .setVersion(-1)
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());
        logger.info("--> waiting for nodes to form a cluster");
            .setLocal(true)
        assertTrue(response.isAcknowledged());
        logger.info("--> network disruption is stopped");  
                .actionGet();  
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
        Settings commonSettings = Settings.builder()
        assertThat(health.isTimedOut(), equalTo(false));
        logger.info("--> starting a dedicated cluster manager node");
        String clusterManager = internalCluster().startClusterManagerOnlyNode(Settings.builder().put(commonSettings).build());
        assertEquals(3, internalCluster().clusterService().state().nodes().getDataNodes().size());
    public void testDeleteWeightedRouting_WeightsAreSet() throws IOException {  
                .get()
        assertNotNull(
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()  
        );
                .metadata()
        ClusterPutWeightedRoutingResponse response = client().admin()
            .get();  
            .prepareWeightedRouting()
        );
            .get();
        Settings commonSettings = Settings.builder()
        logger.info("--> waiting for nodes to form a cluster");  
        );  
import java.util.Map;
        ensureGreen();
        Set<String> nodesInOtherSide = Stream.of(clusterManager).collect(Collectors.toCollection(HashSet::new));
            () -> client().admin().cluster().prepareWeightedRouting().setWeightedRouting(weightedRouting).get()  
        // put api call to set weights  
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
            () -> client().admin().cluster().prepareWeightedRouting().setWeightedRouting(weightedRouting).get()
                .admin()
        assertNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());
        WeightedRouting weightedRouting = new WeightedRouting("zone1", weights);
    /**
        Settings commonSettings = Settings.builder()  
            .cluster()
        );
        Set<String> nodesInOtherSide = Stream.of(clusterManager).collect(Collectors.toCollection(HashSet::new));
        logger.info("--> starting 1 nodes on zones 'a' & 'b' & 'c'");
                String nodeId = response.getHits().getAt(j).getShard().getNodeId();
        Given the custom string preference, we expect each shard or each search should report the exact same node id.
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
}  
     * https://github.com/opensearch-project/OpenSearch/issues/18817  
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")  
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")  
        );
        ClusterPutWeightedRoutingResponse response = client().admin()
            .setAwarenessAttribute("zone")
        assertEquals(response.isAcknowledged(), true);
            .put("cluster.routing.allocation.awareness.attributes", "zone")  
            .build();  
        assertEquals(weightedRouting, weightedRoutingResponse.weights());  
        );
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
        weights = Map.of("a", 1.0, "b", 2.0, "c", 4.0);
        // delete weighted routing metadata
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());
            .build();
        logger.info("--> starting 6 nodes on different zones");
        Map<String, Double> weights = Map.of("a", 1.0, "b", 2.0, "c", 3.0);
                .weightedRoutingMetadata()
    }
            .get();
        assertThrows(
            assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
                .admin()
        networkDisruption.startDisrupting();
import static org.hamcrest.Matchers.equalTo;  
        );
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
                .cluster()  
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
                .metadata()  
            .cluster()  
