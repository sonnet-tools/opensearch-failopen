import java.util.concurrent.TimeUnit;
        Map<String, Double> weights = Map.of("a", 1.0, "b", 2.0, "c", 3.0);
            clusterHealthResponse = client(nodes_in_zone_c.get(0)).admin()
                .cluster()
        Settings commonSettings = Settings.builder()
        ensureStableCluster(3);
            () -> client().admin().cluster().prepareWeightedRouting().setWeightedRouting(weightedRouting).get()
        logger.info("--> waiting for nodes to form a cluster");
        logger.info("--> stop network disruption");
import java.util.HashSet;
            .get();
                .metadata()
        assertThat(healthResponse.getStatus(), equalTo(ClusterHealthStatus.RED));
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        response = client().admin()
        for (int i = 0; i < 30; i++) {
            .setWeightedRouting(weightedRouting)
        ensureGreen();
                .get();
        ClusterGetWeightedRoutingResponse weightedRoutingResponse = client().admin()
import java.util.List;
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());
        );
        internalCluster().startDataOnlyNodes(2, Settings.builder().put(commonSettings).put("node.attr.rack", "rack1").build());
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
        assertThat(health.isTimedOut(), equalTo(false));
                .setVersion(0)
        Map<String, Double> weights = Map.of("a", 1.0, "b", 2.0, "c", 3.0);
        internalCluster().startDataOnlyNodes(nodeCountPerAZ, Settings.builder().put(commonSettings).put("node.attr.zone", "a").build());
            .prepareWeightedRouting()
            .put("cluster.routing.allocation.awareness.attributes", "zone")
            .build();
            .build();
import static org.hamcrest.Matchers.equalTo;
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("7").execute().actionGet();
            .cluster()
        // make sure restarted node joins the cluster
            .prepareWeightedRouting()
        logger.info("--> waiting for nodes to form a cluster");
        for (int i = 0; i < 20; i++) {
        // update weights again and make sure that version number got updated on delete
    public void testDeleteWeightedRouting_WeightsNotSet() {
        assertNotNull(
        assertNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());
            .setRequestLocal(true)
            assertEquals(weightedRouting, weightedRoutingResponse.weights());
        ensureGreen();
            NetworkDisruption.DISCONNECT
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        List<String> nodes_in_zone_c = internalCluster().startDataOnlyNodes(
        );
            internalCluster().client(nodes_in_zone_c.get(0))
        UnsupportedWeightedRoutingStateException deleteException = expectThrows(
                .cluster()
        Settings commonSettings = Settings.builder()
            .prepareGetWeightedRouting()
        // delete weights call, incorrect version number
        // update weights call using version returned by get api call
            .setWeightedRouting(weightedRouting)
                .get();
        internalCluster().restartRandomDataNode();
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingResponse;
        );
                .metadata()
        // put api call to set weights
                .weightedRoutingMetadata()
        internalCluster().restartNode(internalCluster().getClusterManagerName(), new InternalTestCluster.RestartCallback());
 * The OpenSearch Contributors require contributions made to
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
            () -> client().admin().cluster().prepareWeightedRouting().setWeightedRouting(weightedRouting1).setVersion(100).get()
            .get();
        // get api to fetch local weighted routing for a node in zone c
            .cluster()
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        int nodeCountPerAZ = 2;
        ensureGreen();
        weightedRoutingResponse = internalCluster().client(randomFrom(nodes_in_zone_a.get(0), nodes_in_zone_a.get(1)))
        );
        ClusterGetWeightedRoutingResponse weightedRoutingResponse = client().admin()
            UnsupportedWeightedRoutingStateException.class,
            .cluster()
    }
import java.io.IOException;
            .setVersion(2)
        );
        ResourceNotFoundException exception = expectThrows(
        networkDisruption.startDisrupting();
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());
        NetworkDisruption networkDisruption = new NetworkDisruption(
                .cluster()
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        assertEquals(response.isAcknowledged(), true);
                .state(new ClusterStateRequest().local(true))
        logger.info("--> setting shard routing weights for weighted round robin");
        assertTrue(weightedRoutingResponse.getDiscoveredClusterManager());
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
            internalCluster().client(nodes_in_zone_c.get(0))
                .actionGet();
        );
            .get();
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
            nodeCountPerAZ,
/*
        ensureStableCluster(3);
                .cluster()
    }
            nodeCountPerAZ,
        // delete weighted routing metadata
        assertEquals(3, internalCluster().clusterService().state().nodes().getDataNodes().size());
        logger.info("--> setting shard routing weights for weighted round robin");
        assertTrue(deleteResponse.isAcknowledged());
            nodeCountPerAZ,
            .actionGet();
        assertTrue(response.isAcknowledged());
                .metadata()
                .metadata()
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        assertEquals(response.isAcknowledged(), true);
        }, 1, TimeUnit.MINUTES);
                .execute()
        Map<String, Double> weights = Map.of("a", 1.0, "b", 0.0, "c", 0.0);
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());
            .prepareWeightedRouting()
        logger.info("--> waiting for nodes to form a cluster");
            client().prepareIndex("test_index").setId(String.valueOf(i)).setSource("field", "value" + i).get();
    }
            .cluster()
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
            .put("cluster.routing.allocation.awareness.attributes", "zone")
                .admin()
        assertNotNull(
                .getState()
            .cluster()
            // Check local cluster health
        assertNotNull(
        // check weighted routing metadata after node restart, ensure node comes healthy after restart
            .put("cluster.fault_detection.leader_check.retry_count", 1)
        assertThat(health.isTimedOut(), equalTo(false));
        Settings commonSettings = Settings.builder()
            .cluster()
            1,
        ensureGreen();
            .get();
            .setLocal(true)
        }, 1, TimeUnit.MINUTES);
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
            .cluster()
        logger.info("--> starting 2 nodes on zones 'a' & 'b' & 'c'");
        ensureGreen();
         */
            .prepareWeightedRouting()
        // Create index with specific shard configuration
            .setWeightedRouting(weightedRouting)
        List<String> nodes_in_zone_c = internalCluster().startDataOnlyNodes(
        ClusterDeleteWeightedRoutingResponse deleteResponse = client().admin().cluster().prepareDeleteWeightedRouting().setVersion(0).get();
            .cluster()
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
        List<String> nodes_in_zone_b = internalCluster().startDataOnlyNodes(
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),
            .put("cluster.routing.allocation.awareness.force.rack.values", "rack1,rack2")
            .admin()
    public void testPutWeightedRouting_MoreThanOneZoneHasZeroWeight() {
            .cluster()
            .put("cluster.routing.use_adaptive_replica_selection", false)
        assertBusy(() -> {
 * compatible open source license.
        // put api call to set weights
        ClusterPutWeightedRoutingResponse response = client().admin()
            assertTrue(deleteResponse.isAcknowledged());
        }
        List<String> nodes_in_zone_a = internalCluster().startDataOnlyNodes(
                .admin()
            nodeCountPerAZ,
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        ClusterHealthResponse healthResponse = client(nodes_in_zone_c.get(0)).admin()
        assertTrue(weightedRoutingResponse.getDiscoveredClusterManager());
            () -> client().admin().cluster().prepareDeleteWeightedRouting().setVersion(-1).get()
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
        internalCluster().restartRandomDataNode();
        );
                .admin()
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
                .weightedRoutingMetadata()
            .setAwarenessAttribute("zone")
        // get api to fetch local weighted routing for a node in zone a or b
            // return a response with 503 status code
        assertNotNull(
        // Configure cluster with awareness attributes
            SearchResponse response = client().prepareSearch("test_index")
            .admin()
        internalCluster().setDisruptionScheme(networkDisruption);
        Settings commonSettings = Settings.builder()
        // routing weights are set in cluster metadata
        ensureGreen();
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        assertFalse(nodeLocalHealth.isTimedOut());
        ClusterGetWeightedRoutingResponse weightedRoutingResponse = client().admin()
            new NetworkDisruption.TwoPartitions(nodesInOneSide, nodesInOtherSide),
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
            nodeCountPerAZ,
        );
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
        ensureGreen();
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());
            .prepareWeightedRouting()
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        Map<String, Double> weights = Map.of("a", 1.0, "b", 2.0, "c", 3.0);
            assertFalse(weightedRoutingResponse.getDiscoveredClusterManager());
            );
            .setTimeout("1s")
            .setWeightedRouting(weightedRouting)
                shardToNodes.computeIfAbsent(shardId, k -> new HashSet<>()).add(nodeId);
        ensureGreen();
        assertBusy(() -> {
        ensureStableCluster(5);
 * SPDX-License-Identifier: Apache-2.0
            .put("cluster.routing.allocation.awareness.attributes", "zone")
    public void testPutAndDeleteWithVersioning() throws Exception {
            // return a response with 503 status code
                .get()
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("3").execute().actionGet();
        internalCluster().startClusterManagerOnlyNode(commonSettings);
        Set<String> nodesInOneSide = Stream.of(nodes_in_zone_a.get(0), nodes_in_zone_b.get(0), nodes_in_zone_c.get(0))
     * are configured this does not hold.
        ClusterPutWeightedRoutingResponse response = client().admin()
            .admin()
        assertEquals(weightedRouting, weightedRoutingResponse.weights());
        );
            .prepareDeleteWeightedRouting()
            .put("cluster.routing.allocation.awareness.attributes", "rack")
        ClusterPutWeightedRoutingResponse response = client().admin()
        );
        logger.info("--> setting shard routing weights for weighted round robin");
        assertTrue(response.isAcknowledged());
        weights = Map.of("a", 1.0, "b", 2.0, "c", 6.0);
            .cluster()
            .get();
                .get()
            .setRequestLocal(true)
    public void testClusterHealthResponseWithEnsureNodeWeighedInParam() throws Exception {
    }
     * https://github.com/opensearch-project/OpenSearch/issues/18817
            .setVersion(-1)
        // routing weights are set in cluster metadata
        Execute the same match all query with custom string preference.
        internalCluster().startDataOnlyNodes(nodeCountPerAZ, Settings.builder().put(commonSettings).put("node.attr.zone", "c").build());
     * We expect preference will consistently route to the same shard replica. However, when awareness attributes
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
            .setWeightedRouting(weightedRouting)
                .weightedRoutingMetadata()
        For each search and each shard in the response we record the node on which the shard was located.
            1,
        assertThat(health.isTimedOut(), equalTo(false));
            .build();
            nodeCountPerAZ,
        assertThrows(
import org.opensearch.test.InternalTestCluster;
        );
    public void testPutWeightedRouting() {
        logger.info("--> starting a dedicated cluster manager node");
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        assertTrue(deleteResponse.isAcknowledged());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        ensureGreen();
            .prepareWeightedRouting()
        assertNotNull(
import java.util.HashMap;
    public void testReadWriteWeightedRoutingMetadataOnNodeRestart() throws Exception {
                .cluster()
    }
            .setLocal(true)
        assertTrue(response.isAcknowledged());
                .getState()
        weights = Map.of("a", 1.0, "b", 2.0, "c", 5.0);
        If more than one node was responsible for serving a request for a given shard,
            .prepareWeightedRouting()
        weightedRouting = new WeightedRouting("zone", weights);
            .cluster()
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()
        // get weights call
        Settings commonSettings = Settings.builder()
        List<String> nodes_in_zone_b = internalCluster().startDataOnlyNodes(
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());
        logger.info("--> setting shard routing weights for weighted round robin");
                randomFrom(nodes_in_zone_a.get(0), nodes_in_zone_b.get(0))
        internalCluster().startNodes(
        assertTrue(response.isAcknowledged());
        Settings commonSettings = Settings.builder()
import java.util.stream.Collectors;
                .cluster()
        ClusterPutWeightedRoutingResponse response = client().admin()
        );
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
                .weightedRoutingMetadata()
            .build();
        WeightedRouting weightedRouting = new WeightedRouting("zone1", weights);
                .state(new ClusterStateRequest().local(true))
            .get();
        /*
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
            .cluster()
            .put("cluster.fault_detection.leader_check.timeout", 10000 + "ms")
                .getState()
        // Index test documents
                .cluster()
        assertThrows(
        assertTrue(deleteResponse.isAcknowledged());
                .cluster()
            .setAwarenessAttribute("zone")
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("7").execute().actionGet();
    }
        logger.info("--> waiting for nodes to form a cluster");
        int nodeCountPerAZ = 1;
        assertEquals(exception.status(), RestStatus.CONFLICT);
    public void testCustomPreferenceShardIdCombination() {
        assertTrue(weightedRoutingResponse.getDiscoveredClusterManager());
    }
            ClusterHealthResponse clusterHealthResponse = client().admin()
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
        String clusterManager = internalCluster().startClusterManagerOnlyNode(Settings.builder().put(commonSettings).build());
        assertEquals(response.isAcknowledged(), true);
        // get api to fetch local weighted routing for a node in zone a
        );
            )
        ensureGreen();
            .setWeightedRouting(weightedRouting)
        );
        // get api to fetch local weighted routing for a node in zone b
            .cluster()
                .admin()
            .cluster()
        assertThat(health.isTimedOut(), equalTo(false));
                .weightedRoutingMetadata()
            ResourceNotFoundException.class,
        response = client().admin().cluster().prepareWeightedRouting().setWeightedRouting(weightedRouting).setVersion(3).get();
        logger.info("--> waiting for nodes to form a cluster");
            internalCluster().client(internalCluster().getClusterManagerName())
                .state(new ClusterStateRequest().local(true))
            () -> client(nodes_in_zone_c.get(0)).admin().cluster().prepareHealth().setLocal(true).setEnsureNodeWeighedIn(true).get()
            nodeCountPerAZ,
        );
                ClusterManagerNotDiscoveredException.class,
        Settings commonSettings = Settings.builder()
    }
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
            .setVersion(weightedRoutingResponse.getVersion())
                ClusterManagerNotDiscoveredException.class,
        weightedRoutingResponse = internalCluster().client(randomFrom(nodes_in_zone_c.get(0), nodes_in_zone_c.get(1)))
    }
}
            .put("cluster.routing.allocation.awareness.attributes", "zone")
            .build();
        assertNotNull(
            assertThat("Shard " + entry.getKey() + " should consistently route to the same node", entry.getValue().size(), equalTo(1));
        );
public class WeightedRoutingIT extends OpenSearchIntegTestCase {
        String clusterManager = internalCluster().startClusterManagerOnlyNode(Settings.builder().put(commonSettings).build());
        weightedRoutingResponse = internalCluster().client(randomFrom(nodes_in_zone_b.get(0), nodes_in_zone_b.get(1)))
        );
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        logger.info("--> network disruption is started");
            .prepareGetWeightedRouting()
        assertEquals(RestStatus.CONFLICT, deleteException.status());
            .build();
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("4").execute().actionGet();
        logger.info("--> setting shard routing weights for weighted round robin");
        List<String> nodes_in_zone_a = internalCluster().startDataOnlyNodes(
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingResponse;
        Settings commonSettings = Settings.builder()
            .put("cluster.routing.allocation.awareness.attributes", "zone")
                .setSize(30)
        );
            NetworkDisruption.DISCONNECT
            .cluster()
        logger.info("--> starting 1 nodes on zones 'a' & 'b' & 'c'");
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
import org.opensearch.action.search.SearchResponse;
    @Override
            .get();
        ClusterPutWeightedRoutingResponse response = client().admin()
        // get api call to fetch weights
    public void testPutWeightedRouting_InvalidAwarenessAttribute() {
        List<String> nodes_in_zone_a = internalCluster().startDataOnlyNodes(
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
        assertEquals(3, internalCluster().clusterService().state().nodes().getDataNodes().size());
            IllegalArgumentException.class,
            .build();
        );
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
            .get();
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
        // update weights api call with incorrect version number
        then there was a regression in the custom preference string.
        logger.info("--> starting 6 nodes on different zones");
            .setEnsureNodeWeighedIn(true)
        Set<String> nodesInOtherSide = Stream.of(clusterManager).collect(Collectors.toCollection(HashSet::new));
        List<String> nodes_in_zone_b = internalCluster().startDataOnlyNodes(
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());
import java.util.Map;
        logger.info("--> setting shard routing weights for weighted round robin");
            assertTrue(clusterHealthResponse.hasDiscoveredClusterManager());
        logger.info("--> waiting for nodes to form a cluster");
        }
        // put api call to set weights
            .build();
                .metadata()
        assertThat(health.isTimedOut(), equalTo(false));
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Double> weights = Map.of("a", 1.0, "b", 1.0, "c", 0.0);
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        Settings commonSettings = Settings.builder()
        logger.info("--> waiting for nodes to form a cluster");
        weights = Map.of("a", 1.0, "b", 2.0, "c", 4.0);
import java.util.stream.Stream;
            .build();
        // delete weighted routing metadata
        internalCluster().startNodes(
                .admin()
        // delete weights by awareness attribute
    public void testGetWeightedRouting_WeightsNotSet() {
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("3").execute().actionGet();
            nodeCountPerAZ,
        logger.info("--> setting shard routing weights for weighted round robin");
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        );
        // Check cluster health for weighed in node, health check should return a response with 200 status code
        List<String> nodes_in_zone_b = internalCluster().startDataOnlyNodes(
            .get();
import org.opensearch.test.OpenSearchIntegTestCase;
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("4").execute().actionGet();
        Map<String, Double> weights = Map.of("a", 1.0, "b", 2.0, "c", 3.0);
        ensureGreen();
        ClusterPutWeightedRoutingResponse response = client().admin()
                .get()
        List<String> nodes_in_zone_c = internalCluster().startDataOnlyNodes(
            nodeCountPerAZ,
        assertNull(weightedRoutingResponse.getDiscoveredClusterManager());
                () -> client(nodes_in_zone_a.get(0)).admin().cluster().prepareHealth().setLocal(true).setEnsureNodeWeighedIn(true).get()
import org.opensearch.core.rest.RestStatus;
        Settings commonSettings = Settings.builder()
        assertTrue(ex.getMessage().contains("local node is weighed away"));
        Given the custom string preference, we expect each shard or each search should report the exact same node id.
        ClusterPutWeightedRoutingResponse response = client().admin()
        return Arrays.asList(MockTransportService.TestPlugin.class, MockRepository.Plugin.class);
        Map<String, Double> weights = Map.of("a", 1.0, "b", 2.0, "c", 3.0);
        List<String> nodes_in_zone_a = internalCluster().startDataOnlyNodes(
            .setAwarenessAttribute("zone")
import java.util.Arrays;
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
        logger.info("--> setting shard routing weights for weighted round robin");
        // Restart a random data node and check that OS process comes healthy
            .cluster()
import org.opensearch.discovery.ClusterManagerNotDiscoveredException;
        logger.info("--> starting 6 nodes on different zones");
        assertNull(weightedRoutingResponse.weights());
            .build();
        );
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("3").execute().actionGet();
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build()
        response = internalCluster().client(randomFrom(nodes_in_zone_a.get(0), nodes_in_zone_a.get(1)))
            internalCluster().client(internalCluster().getClusterManagerName())
            .setAwarenessAttribute("zone")
            .cluster()
        }
            .setVersion(-1)
            .setAwarenessAttribute("zone")
                .admin()
        );
        networkDisruption.startDisrupting();
    }
            .setVersion(-1)
        );
        );
        internalCluster().startClusterManagerOnlyNode(Settings.builder().put(commonSettings).build());
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
        logger.info("--> shard to node mappings: {}", shardToNodes);
            IllegalArgumentException.class,
         */
import java.util.Set;
                .state(new ClusterStateRequest().local(true))
                .prepareHealth()
        assertTrue(response.isAcknowledged());
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("3").execute().actionGet();
        WeightedRouting weightedRouting1 = new WeightedRouting("zone", weights);
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
            .prepareGetWeightedRouting()
        /*
        Otherwise, the custom string pref is not producing consistent shard routing.
        assertThat(health.isTimedOut(), equalTo(false));
        assertEquals(weightedRouting, weightedRoutingResponse.weights());
            nodeCountPerAZ,
        );
        assertNotNull(
            .setVersion(-1)
        internalCluster().startClusterManagerOnlyNode(Settings.builder().put(commonSettings).build());
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingResponse;
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()
        assertThat(health.isTimedOut(), equalTo(false));
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()
        internalCluster().startNodes(
        networkDisruption.stopDisrupting();
                .getState()
        Map<String, Double> weights = Map.of("a", 1.0, "b", 2.0, "c", 3.0);
        assertBusy(() -> {
            .setWeightedRouting(weightedRouting)
        Map<String, Set<String>> shardToNodes = new HashMap<>();
    public void testWeightedRoutingMetadataOnOSProcessRestart() throws Exception {
        // Restart a random data node and check that OS process comes healthy
        logger.info("--> waiting for nodes to form a cluster");
                .get()
        logger.info("--> setting shard routing weights for weighted round robin");
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("3").execute().actionGet();
            1,
                .admin()
        );
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, minNumDataNodes = 3)
        List<String> nodes_in_zone_b = internalCluster().startDataOnlyNodes(
            .collect(Collectors.toCollection(HashSet::new));
        assertAcked(
        );
            .prepareWeightedRouting()
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
        );
                .admin()
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build(),
                .get();
        ensureGreen();
                .cluster()
        Settings commonSettings = Settings.builder()
        List<String> nodes_in_zone_c = internalCluster().startDataOnlyNodes(
        // Start cluster
        Map<String, Double> weights = Map.of("a", 1.0, "b", 2.0, "c", 3.0);
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()
        // put api call to set weights
            .setWeightedRouting(weightedRouting)
import org.opensearch.common.settings.Settings;
            assertFalse(clusterHealthResponse.isTimedOut());
        // delete weighted routing metadata
        ensureGreen();
            .setVersion(-1)
        );
                .metadata()
        weights = Map.of("a", 1.0, "b", 2.0, "c", 4.0);
        deleteResponse = client().admin().cluster().prepareDeleteWeightedRouting().setVersion(4).get();
                .weightedRoutingMetadata()
                .setLocal(true)
        NetworkDisruption networkDisruption = new NetworkDisruption(
            () -> client().admin().cluster().prepareDeleteWeightedRouting().setVersion(7).get()
        logger.info("--> running cluster health on an index that does not exists");
        ClusterDeleteWeightedRoutingResponse deleteResponse = client().admin()
        Settings commonSettings = Settings.builder()
        WeightedRouting weightedRouting = new WeightedRouting("zone", weights);
        // put call made on a data node in zone a
                .get()
        logger.info("--> setting shard routing weights for weighted round robin");
            Settings.builder().put(commonSettings).put("node.attr.zone", "b").build()
        List<String> nodes_in_zone_a = internalCluster().startDataOnlyNodes(
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
import org.opensearch.cluster.health.ClusterHealthStatus;
                .cluster()
                .setQuery(matchAllQuery())
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("7").execute().actionGet();
        );
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
                String shardId = response.getHits().getAt(j).getShard().getShardId().toString();
            .setAwarenessAttribute("zone")
        assertThat(health.isTimedOut(), equalTo(false));
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("3").execute().actionGet();
import org.opensearch.test.transport.MockTransportService;
        assertThat(health.isTimedOut(), equalTo(false));
        ClusterPutWeightedRoutingResponse response = client().admin()
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());
            .build();
import org.opensearch.test.disruption.NetworkDisruption;
import org.opensearch.snapshots.mockstore.MockRepository;
        weightedRouting = new WeightedRouting("zone", weights);
            prepareCreate("test_index").setSettings(
            .setVersion(-1)
            nodeCountPerAZ,
            .prepareWeightedRouting()
        ensureGreen("test_index");
            internalCluster().client(nodes_in_zone_b.get(0))
    }
            .get();
        assertThat(health.isTimedOut(), equalTo(false));
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());
    public void testGetWeightedRouting_ClusterManagerNotDiscovered() throws Exception {
            .put("cluster.routing.allocation.awareness.attributes", "zone")
                .state(new ClusterStateRequest().local(true))
        // make sure restarted node joins the cluster
        assertThat(healthResponse.getIndices().isEmpty(), equalTo(true));
            .put("cluster.search.ignore_awareness_attributes", false)
        refreshAndWaitForReplication("test_index");
        ensureGreen();
        logger.info("--> starting a dedicated cluster manager node");
            .setVersion(-1)
package org.opensearch.cluster.routing;
        // Check cluster health for weighed away node, health check should respond with an exception
        Settings commonSettings = Settings.builder()
        internalCluster().restartNode(nodes_in_zone_a.get(0), new InternalTestCluster.RestartCallback());
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        internalCluster().startNodes(
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
                .metadata()
        WeightedRouting weightedRouting = new WeightedRouting("zone1", weights);
        assertTrue(deleteResponse.isAcknowledged());
            ).admin().cluster().prepareGetWeightedRouting().setAwarenessAttribute("zone").setRequestLocal(true).get();
     * For regression in custom string query preference with awareness attributes enabled.
import org.opensearch.plugins.Plugin;
        response = client().admin().cluster().prepareWeightedRouting().setWeightedRouting(weightedRouting).setVersion(0).get();
                .getState()
    }
            internalCluster().client(nodes_in_zone_b.get(0))
        ensureGreen();
            for (int j = 0; j < response.getHits().getHits().length; j++) {
                .prepareDeleteWeightedRouting()
            .cluster()
            .setVersion(-1)
                .get()
        ensureGreen();
    }
        Map<String, Double> weights = Map.of("a", 1.0, "b", 2.0, "c", 3.0);
            .cluster()
                Settings.builder().put("index.number_of_shards", 6).put("index.number_of_replicas", 1).build()
                .state(new ClusterStateRequest().local(true))
        logger.info("--> waiting for nodes to form a cluster");
        ClusterPutWeightedRoutingResponse response = client().admin()
            .prepareWeightedRouting()
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("4").execute().actionGet();
            .prepareGetWeightedRouting()
            ClusterDeleteWeightedRoutingResponse deleteResponse = client().admin()
                .getState()
            .prepareGetWeightedRouting()
            .get();
                .setPreference("test_preference_123")
        NodeWeighedAwayException ex = expectThrows(
            .get();
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("3").execute().actionGet();
            .prepareWeightedRouting()
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());
        internalCluster().startClusterManagerOnlyNode(Settings.builder().put(commonSettings).build());
        );
        );
    /**
    public void testWeightedRoutingOnOSProcessRestartAfterWeightDelete() throws Exception {
        logger.info("--> starting 2 nodes on zones 'a' & 'b' & 'c'");
        );
        internalCluster().startClusterManagerOnlyNode(Settings.builder().put(commonSettings).build());
            );
        assertThat(health.isTimedOut(), equalTo(false));
            assertThrows(
        List<String> nodes_in_zone_c = internalCluster().startDataOnlyNodes(
        );
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        );
        logger.info("--> waiting for nodes to form a cluster");
        ensureGreen();
        logger.info("--> starting 3 nodes on different zones");
    }
        internalCluster().startDataOnlyNodes(2, Settings.builder().put(commonSettings).put("node.attr.rack", "rack2").build());
                .setEnsureNodeWeighedIn(true)
                .cluster()
            .setAwarenessAttribute("zone")
        assertEquals(response.isAcknowledged(), true);
            .setVersion(0)
            UnsupportedWeightedRoutingStateException.class,
        internalCluster().startNodes(
        assertThat(healthResponse.isTimedOut(), equalTo(true));
        for (Map.Entry<String, Set<String>> entry : shardToNodes.entrySet()) {
                .setWaitForNodes("4")
            () -> client().admin().cluster().prepareWeightedRouting().setWeightedRouting(weightedRouting).get()
            .build();
        logger.info("--> starting 2 nodes on zones 'a' & 'b' & 'c'");
        internalCluster().startNodes(
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                .weightedRoutingMetadata()
import java.util.Collection;
            .get();
        );
     */
        ensureGreen();
        assertNotNull(internalCluster().clusterService().state().metadata().weightedRoutingMetadata());
 */
        assertEquals(weightedRouting, weightedRoutingResponse.weights());
            .prepareHealth("test1")
        assertThat(health.isTimedOut(), equalTo(false));
        assertEquals(RestStatus.NOT_FOUND, exception.status());
            .put("cluster.routing.allocation.awareness.attributes", "zone")
            .setEnsureNodeWeighedIn(true)
        );
                .state(new ClusterStateRequest().local(true))
        assertTrue(response.isAcknowledged());
            .build();
        logger.info("--> starting a dedicated cluster manager node");
        Set<String> nodesInOtherSide = Stream.of(clusterManager).collect(Collectors.toCollection(HashSet::new));
        logger.info("--> waiting for nodes to form a cluster");
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
            .get();
            .get();
        UnsupportedWeightedRoutingStateException exception = expectThrows(
        assertTrue(weightedRoutingResponse.getDiscoveredClusterManager());
            .setRequestLocal(true)
                .getState()
            .admin()
        int nodeCountPerAZ = 2;
            // delete weights
            .put("cluster.routing.allocation.awareness.attributes", "zone")
                .prepareHealth()
            nodeCountPerAZ,
        ClusterDeleteWeightedRoutingResponse deleteResponse = client().admin().cluster().prepareDeleteWeightedRouting().setVersion(0).get();
            assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
        int nodeCountPerAZ = 2;
                String nodeId = response.getHits().getAt(j).getShard().getNodeId();
            .cluster()
        internalCluster().startNodes(
            .setWeightedRouting(weightedRouting)
            assertThrows(
            .put("cluster.routing.allocation.awareness.attributes", "zone")
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
        ClusterDeleteWeightedRoutingResponse deleteResponse = client().admin().cluster().prepareDeleteWeightedRouting().setVersion(0).get();
                .get()
        weightedRouting = new WeightedRouting("zone", weights);
            }
        );
            .get();
        }, 13, TimeUnit.SECONDS);
                .get()
            internalCluster().client(nodes_in_zone_a.get(0))
                .metadata()
        ClusterHealthResponse nodeLocalHealth = client(nodes_in_zone_a.get(0)).admin()
        logger.info("--> starting 1 nodes on zones 'a' & 'b' & 'c'");
            .setWeightedRouting(weightedRouting)
        internalCluster().setDisruptionScheme(networkDisruption);
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
            .prepareGetWeightedRouting()
        logger.info("--> starting 1 nodes on zones 'a' & 'b' & 'c'");
                () -> client(nodes_in_zone_c.get(0)).admin().cluster().prepareHealth().setLocal(true).setEnsureNodeWeighedIn(true).get()
            .get();
    public void testGetWeightedRouting_WeightsAreSet() throws IOException {
        networkDisruption.stopDisrupting();
        assertEquals(weightedRouting, weightedRoutingResponse.weights());
            .setVersion(-1)
                .weightedRoutingMetadata()
            internalCluster().client(nodes_in_zone_a.get(0))
            ClusterGetWeightedRoutingResponse weightedRoutingResponse = internalCluster().client(
            Settings.builder().put(commonSettings).put("node.attr.zone", "a").build(),
            // Check cluster health for weighed in node when cluster manager is not discovered, health check should
        logger.info("--> setting shard routing weights for weighted round robin");
        // delete weights
        ensureGreen();
        logger.info("--> network disruption is stopped");
        logger.info("--> waiting for nodes to form a cluster");
        internalCluster().startDataOnlyNodes(nodeCountPerAZ, Settings.builder().put(commonSettings).put("node.attr.zone", "b").build());
        logger.info("--> waiting for nodes to form a cluster");
        logger.info("--> starting a dedicated cluster manager node");
        Set<String> nodesInOneSide = Stream.of(nodes_in_zone_a.get(0), nodes_in_zone_b.get(0), nodes_in_zone_c.get(0))
    }
            .get();
        // update weights api call with correct version number
        assertTrue(deleteResponse.isAcknowledged());
                .getState()
            // Check cluster health for weighed away node when cluster manager is not discovered, health check should
            .get();
        assertEquals(response.isAcknowledged(), true);
        assertThat(health.isTimedOut(), equalTo(false));
        Map<String, Double> weights = Map.of("a", 1.0, "b", 2.0, "c", 3.0);
        Settings commonSettings = Settings.builder()
            .prepareHealth()
    public void testDeleteWeightedRouting_WeightsAreSet() throws IOException {
        // put api call to set weights
                .state(new ClusterStateRequest().local(true))
        logger.info("--> starting a dedicated cluster manager node");
 *
        int nodeCountPerAZ = 1;
            Settings.builder().put(commonSettings).put("node.attr.zone", "c").build()
            .setWeightedRouting(weightedRouting)
import org.opensearch.ResourceNotFoundException;
        assertNotNull(
        ensureGreen();
            .build();
        assertEquals(response.isAcknowledged(), true);
        );
            .execute()
        logger.info("--> network disruption is started");
        assertEquals(response.isAcknowledged(), true);
            NodeWeighedAwayException.class,
            .collect(Collectors.toCollection(HashSet::new));
