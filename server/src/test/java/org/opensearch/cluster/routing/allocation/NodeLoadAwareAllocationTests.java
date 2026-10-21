    public void testThreeZoneTwoReplicaLimitsReplicaAllocationUnderFullZoneFailure() {
        );
        newState = strategy.reroute(newState, "reroute");
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        logger.info("--> Remove node2 when the limit of overload is reached");
        logger.info("--> start the shards (primaries)");
        );
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        clusterState = addNodes(clusterState, strategy, "zone_1", "node1", "node2", "node3", "node4", "node5");
        assertThat(newState.getRoutingNodes().node("node14").size(), equalTo(4));
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(20));
    public void testExistingPrimariesAllocationOnOverload() {
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        // add the third and fourth node
        clusterState = addNodes(clusterState, strategy, "zone_1", "node1", "node2", "node3", "node4", "node5");
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
        logger.info("--> adding five nodes on same zone and do rerouting");
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(20));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            newState = startInitializingShardsAndReroute(strategy, newState);
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(20));
        newState = startInitializingShardsAndReroute(strategy, newState);
                DiscoveryNodes.builder(newState.nodes())
        newState = removeNodes(newState, strategy, "node2");
import org.opensearch.gateway.GatewayAllocator;
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
            newState = startInitializingShardsAndReroute(strategy, newState);
                5,
                false
                50,
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(30));
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(20));
            assertEquals(shard.unassignedInfo().getReason(), UnassignedInfo.Reason.INDEX_CREATED);
        logger.info("--> adding five nodes on same zone and do rerouting");
        }
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
package org.opensearch.cluster.routing.allocation;
        metadata = Metadata.builder(newState.metadata())
        newState = startInitializingShardsAndReroute(strategy, newState);
            .build();
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(
            assertThat(node.size(), equalTo(7));
            .build();
public class NodeLoadAwareAllocationTests extends OpenSearchAllocationTestCase {
        logger.info("Building initial routing table for 'testExistingPrimariesAllocationOnOverload'");
        Metadata metadata = Metadata.builder()
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            else {
                    )
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(36));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        });
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        assertThat(newState.getRoutingNodes().node("node12").size(), equalTo(4));
                "zone_1,zone_2,zone_3"
 *
        GatewayAllocator gatewayAllocator = new TestGatewayAllocator();
        assertThat(newState.getRoutingNodes().node("node12").size(), equalTo(4));
        newState = strategy.reroute(newState, "reroute");
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(40));
            newState = startInitializingShardsAndReroute(strategy, newState);
        assertThat(newState.getRoutingNodes().node("node13").size(), equalTo(4));
            newState = startInitializingShardsAndReroute(strategy, newState);
        newState = ClusterState.builder(newState)
        }
        assertThat(newState.getRoutingNodes().node("node11").size(), equalTo(4));
                5,
        // add the removed node
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(60));
        assertThat(newState.getRoutingNodes().node("node11").size(), equalTo(4));
            newState = startInitializingShardsAndReroute(strategy, newState);
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
            .routingTable(initialRoutingTable)
        List.of(nodeIds).forEach(nodeId -> nodeBuilder.remove(nodeId));
        newState = startInitializingShardsAndReroute(strategy, newState);
        newState = startInitializingShardsAndReroute(strategy, newState);
        ClusterState newState = addNodes(clusterState, strategy, "zone3", "node11", "node12", "node13", "node14", "node15");
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
        newState = ClusterState.builder(newState)
        clusterState = addNodes(clusterState, strategy, "zone1", "node1", "node2");
        }
        newState = ClusterState.builder(newState)
        logger.info("--> adding two nodes on same rack and do rerouting");
        clusterState = addNodes(clusterState, strategy, "zone1", "node1", "node2", "node3", "node4", "node5");
        for (RoutingNode node : newState.getRoutingNodes()) {
/*
        logger.info("--> 2 replicas are initializing");
            newState = startInitializingShardsAndReroute(strategy, newState);
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(60));
            .build();
                IndexMetadata.builder("test1")
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        Metadata metadata = Metadata.builder()
            )
            .metadata(metadata)
        }
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(40));
        newState = strategy.reroute(newState, "reroute");
        assertThat(newState.getRoutingNodes().node("node15").size(), equalTo(4));
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(60));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        // increases avg shard per node to 145/5 = 29, overload factor 1.2, total allowed 35+2=37 per node and NO primaries get assigned
        logger.info("--> add five new node in new zone and reroute");
                20,
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        }
            .build();
import org.opensearch.cluster.ClusterName;
            Map.of(
import org.opensearch.cluster.routing.UnassignedInfo;
        newState = ClusterState.builder(newState)
                    .settings(
    }
            )
        Metadata metadata = Metadata.builder()
        for (RoutingNode node : newState.getRoutingNodes()) {
        logger.info("--> Remove nodes from zone holding primaries");
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(3));
        assertThat(newState.getRoutingNodes().node("node14").size(), equalTo(4));
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        newState = ClusterState.builder(newState)
        logger.info("--> start the shards (primaries)");
            .routingTable(initialRoutingTable)
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.routing.allocation.decider.NodeLoadAwareAllocationDecider;
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node3", singletonMap("zone", "zone_1"))))
                    )
            .build();
        for (ShardRouting shard : clusterState.getRoutingNodes().shardsWithState(UNASSIGNED)) {
        logger.info("--> replica will not start because we have only one rack value");
    public void testThreeZoneOneReplicaWithSkewFactorZeroAllShardsAssignedAfterRecovery() {
        newState = ClusterState.builder(newState).metadata(metadata).routingTable(updatedRoutingTable).build();
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(20));
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node1", singletonMap("zone", "zone_1"))))
        // since total owning shards are 42 per node already
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
                -1,
            .build();
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 20)
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(3));
            .put("cluster.routing.allocation.awareness.attributes", "zone");
            .routingTable(initialRoutingTable)
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
        newState = ClusterState.builder(newState).metadata(metadata).routingTable(updatedRoutingTable).build();
        }
        logger.info("--> Remove node4 from zone holding primaries");
                true
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
        logger.info("--> adding three nodes on same zone and do rerouting");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        // ensure all shards are assigned
 * compatible open source license.
    }
        // add back node2 when skewness is still breached
                    )
        logger.info("--> complete relocation");
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(20));
        // add back node3
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                5,
        assertThat(newState.getRoutingNodes().node("node13").size(), equalTo(8));
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .build();
            .build();
        // 4 existing shards from this node's local store get started and cluster rebalances
        }
        assertThat(newState.getRoutingNodes().node("node13").size(), equalTo(4));
        assertThat(newState.getRoutingNodes().node("node11").size(), equalTo(4));
    }
        metadata = Metadata.builder(newState.metadata())
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(20).numberOfReplicas(1))
            .routingTable(initialRoutingTable)
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(21));
            newState = startInitializingShardsAndReroute(strategy, newState);
    public void testThreeZoneOneReplicaLimitsShardAllocationOnOverload() {
            .build();
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
import org.opensearch.Version;
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
            newState = startInitializingShardsAndReroute(strategy, newState);
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node11", singletonMap("zone", "zone3"))))
            .build();
        }
                20,
                .shardsWithState(UNASSIGNED)
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        assertThat(newState.getRoutingNodes().node("node12").size(), equalTo(5));
        newState = strategy.reroute(newState, "reroute");
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
                    )
                true
            assertFalse(shard.primary());
            newState = startInitializingShardsAndReroute(strategy, newState);
            .metadata(metadata)
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(9));
        newState = removeNodes(newState, strategy, "node4");
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.cluster.routing.RoutingTable;
        newState = strategy.reroute(newState, "reroute");
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node2", singletonMap("zone", "zone_1"))))
                    .add(newNode("node2", singletonMap("zone", "zone_1")))
            newState = startInitializingShardsAndReroute(strategy, newState);
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
            .build();
        );
        }
        while (clusterState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node15", singletonMap("zone", "zone3"))))
            .build();
            )
        );
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(12));
        logger.info("--> add five new node in new zone and reroute");
        }
            )
        metadata = Metadata.builder(newState.metadata())
                15,
            newState = startInitializingShardsAndReroute(strategy, newState);
                "zone1,zone2,zone3"
        }
        logger.info("--> start the shards (primaries)");
        for (RoutingNode node : clusterState.getRoutingNodes()) {
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node14", singletonMap("zone", "zone3"))))
            12L,
        newState = ClusterState.builder(newState)
        logger.info("limits should be applied on newly create primaries");
        newState = strategy.reroute(newState, "reroute");
        assertThat(newState.getRoutingNodes().node("node14").size(), equalTo(4));
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
        newState = startInitializingShardsAndReroute(strategy, newState);
        }
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(20).numberOfReplicas(2))
            .metadata(metadata)
        assertThat(newState.getRoutingNodes().node("node4").size(), equalTo(14));
            newState = startInitializingShardsAndReroute(strategy, newState);
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(60));
        newState = strategy.reroute(newState, "reroute");
                .count()
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node11", singletonMap("zone", "zone3"))))
                20,
        logger.info("--> complete relocation");
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey(), 20)
        logger.info("--> adding five nodes on same zone and do rerouting");
            .routingTable(initialRoutingTable)
        logger.info("no limits should be applied on newly created primaries");
        newState = ClusterState.builder(newState)
        settingsValue.forEach((k, v) -> {
            assertFalse(shard.primary());
            newState = startInitializingShardsAndReroute(strategy, newState);
                true
        }
            .build();
            newState = startInitializingShardsAndReroute(strategy, newState);
            .build();
        // add back node3
            }
        // add the removed node
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node2", singletonMap("zone", "zone_1"))))
        logger.info("--> start the shards (replicas)");
                false
        newState = strategy.reroute(newState, "reroute");
        clusterState = addNodes(clusterState, strategy, "zone1", "node1", "node2", "node3");
            ),
        logger.info("add another index with 20 shards");
        }
            )
        logger.info("Building initial routing table for 'testNewUnassignedPrimaryAllocationOnOverload'");
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING.getKey(),
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING.getKey(),
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(20));
                "cluster.routing.allocation.awareness.force.zone.values",
            .routingTable(initialRoutingTable)
                    .settings(
            assertFalse(shard.primary());
            Map.of(
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(126));
        newState = strategy.reroute(newState, "reroute");
            .routingTable(initialRoutingTable)
        logger.info("add another index with 20 shards");
        newState = removeNodes(newState, strategy, "node11", "node12", "node13");
        return allocationService.disassociateDeadNodes(ClusterState.builder(clusterState).nodes(nodeBuilder).build(), true, "reroute");
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(28));
            .build();
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        clusterState = addNodes(clusterState, strategy, "zone_2", "node4", "node5", "node6");
        // Each node can now have 5 shards each
import static org.hamcrest.Matchers.equalTo;
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(28));
            Map.of(
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
            gatewayAllocator
        );
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(60));
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(61));
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
    }
    private AllocationService createAllocationServiceWithAdditionalSettings(Map<String, Object> settingsValue) {
            Map.of(
        // add the removed node
        }
        ClusterState newState = addNodes(clusterState, strategy, "zone3", "node11", "node12", "node13", "node14", "node15");
        // add the removed node
            newState = startInitializingShardsAndReroute(strategy, newState);
        // 28 shards should be assigned (14 on each node -> 8 * 1.5 + 2)
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
            if (v instanceof Integer) settingsBuilder.put(k, (Integer) (v));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(20).numberOfReplicas(1))
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(28));
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node12", singletonMap("zone", "zone3"))))
            newState = startInitializingShardsAndReroute(strategy, newState);
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(60));
import java.util.Map;
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        newState = ClusterState.builder(newState)
            .build();
        newState = ClusterState.builder(newState)
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.getNodes());
        Metadata metadata = Metadata.builder()
            ),
            assertFalse(shard.primary());
        assertThat(newState.getRoutingNodes().node("node11").size(), equalTo(4));
        }
            .put(
        assertThat(newState.getRoutingNodes().node("node12").size(), equalTo(4));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(20));
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 20)
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            .put(
        // ensure all shards are assigned
    public void testSingleZoneOneReplicaLimitsReplicaAllocationOnOverload() {
        assertThat(newState.getRoutingNodes().node("node11").size(), equalTo(4));
        logger.info("--> complete relocation");
        logger.info("--> adding five nodes on same zone and do rerouting");
        logger.info("--> add five new node in new zone and reroute");
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(), equalTo("node4"));
        assertThat(newState.getRoutingNodes().node("node15").size(), equalTo(7));
                IndexMetadata.builder("test3")
        logger.info("add another index with 30 primary 1 replica");
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node4", singletonMap("zone", "zone_1"))))
            .put(
            .put(
        );
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 5)
    }
        newState = strategy.reroute(newState, "reroute");
            Map.of(
                "cluster.routing.allocation.awareness.force.zone.values",
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(36));
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(40));
                .stream()
import java.util.List;
            gatewayAllocator
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
        // add the removed node
                "cluster.routing.allocation.awareness.force.zone.values",
    private final Logger logger = LogManager.getLogger(NodeLoadAwareAllocationTests.class);
        assertEquals(
        newState = ClusterState.builder(newState)
        logger.info("Building initial routing table for 'testThreeZoneTwoReplicaLimitsShardAllocationOnOverload'");
        clusterState = addNodes(clusterState, strategy, "zone1", "node5");
            .build();
        );
            .build();
        RoutingTable updatedRoutingTable = RoutingTable.builder(newState.routingTable()).addAsNew(metadata.index("test1")).build();
import org.opensearch.cluster.metadata.Metadata;
                "cluster.routing.allocation.awareness.force.zone.values",
        logger.info("--> adding five nodes on same zone and do rerouting");
        newState = strategy.reroute(newState, "reroute");
        logger.info("add another index with 5 shards");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        newState = strategy.reroute(newState, "reroute");
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
        newState = removeNodes(newState, strategy, "node11", "node12", "node13");
        logger.info("Building initial routing table for 'testSingleZoneOneReplicaLimitsReplicaAllocationOnOverload'");
            Map.of(
        logger.info("add another index with 20 shards");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                10
            Map.of(
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(
                .filter(r -> r.unassignedInfo().getReason() == UnassignedInfo.Reason.NODE_LEFT)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        newState = startInitializingShardsAndReroute(strategy, newState);
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(
        }
                true,
            .metadata(metadata)
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        // skewness limit doesn't apply to primary
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node13", singletonMap("zone", "zone3"))))
                .filter(r -> r.unassignedInfo().getReason() == UnassignedInfo.Reason.INDEX_CREATED)
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        newState = strategy.reroute(newState, "reroute");
        }
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(3));
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        );
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(8));
            newState = startInitializingShardsAndReroute(strategy, newState);
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(21));
        newState = strategy.reroute(newState, "reroute");
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
            .metadata(metadata)
    }
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
        logger.info("Building initial routing table for 'testThreeZoneOneReplicaLimitsShardAllocationOnOverload'");
            .build();
        clusterState = addNodes(clusterState, strategy, "zone2", "node6", "node7", "node8", "node9", "node10");
        }
        newState = ClusterState.builder(newState)
        ClusterState newState = removeNodes(clusterState, strategy, "node1", "node2", "node3");
        List.of(nodeIds).forEach(nodeId -> nodeBuilder.add(newNode(nodeId, singletonMap("zone", zone))));
        logger.info("--> Remove nodes from zone holding primaries");
        while (!newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty()) {
        newState = removeNodes(newState, strategy, "node7", "node2");
import org.apache.logging.log4j.Logger;
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
            .metadata(metadata)
            newState = startInitializingShardsAndReroute(strategy, newState);
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        );
            .routingTable(initialRoutingTable)
        assertThat(newState.getRoutingNodes().node("node11").size(), equalTo(4));
        }
        Settings.Builder settingsBuilder = Settings.builder()
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(20).numberOfReplicas(0))
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(63));
    }
        newState = ClusterState.builder(newState).metadata(metadata).routingTable(updatedRoutingTable).build();
                    .settings(
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        newState = addNodes(newState, strategy, "zone3", "node13");
        // add the removed node
    public void testSingleZoneOneReplicaLimitsShardAllocationOnOverload() {
                5,
            newState = startInitializingShardsAndReroute(strategy, newState);
                3,
        newState = ClusterState.builder(newState).metadata(metadata).routingTable(updatedRoutingTable).build();
            assertThat(node.size(), equalTo(6));
        assertThat(newState.getRoutingNodes().node("node15").size(), equalTo(5));
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
        assertThat(newState.getRoutingNodes().node("node12").size(), equalTo(4));
        // Each node can take 11 shards each (2 + ceil(8*1.1)), hence 2 replicas will also start
            .metadata(metadata)
                    .settings(
        newState = strategy.reroute(newState, "reroute");
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(30));
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        ClusterState newState = addNodes(clusterState, strategy, "zone3", "node11", "node12", "node13", "node14", "node15");
        logger.info("--> add five new node in new zone and reroute");
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        // add the removed node
        logger.info("--> Remove complete zone3 holding primary and replicas");
    }
            newState = startInitializingShardsAndReroute(strategy, newState);
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(40));
        for (ShardRouting shard : clusterState.getRoutingNodes().shardsWithState(UNASSIGNED)) {
            else if (v instanceof String) settingsBuilder.put(k, (String) (v));
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING.getKey(),
    public void testThreeZoneTwoReplicaLimitsShardAllocationOnOverload() {
            assertEquals(shard.unassignedInfo().getReason(), UnassignedInfo.Reason.NODE_LEFT);
        assertThat(newState.getRoutingNodes().node("node15").size(), equalTo(4));
    public void testSingleZoneTwoReplicaLimitsReplicaAllocationOnOverload() {
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
        newState = removeNodes(newState, strategy, "node11", "node12", "node13");
        logger.info("--> start the shards (primaries)");
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node13", singletonMap("zone", "zone3"))))
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());
        logger.info("--> adding five nodes on same zone and do rerouting");
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(19));
        }
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        }
        // increases avg shard per node to 140/5 = 28, overload factor 1.2, total allowed 34 per node but still ALL primaries get assigned
            )
            assertThat(node.size(), equalTo(8));
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(21));
        assertEquals(
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
    }
        logger.info("--> replica will not start because we have only one zone value");
            newState = startInitializingShardsAndReroute(strategy, newState);
        metadata = Metadata.builder(newState.metadata())
            ),
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                .stream()
        // ensure all shards are assigned
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        logger.info("--> start the shards (primaries)");
        newState = startInitializingShardsAndReroute(strategy, newState);
                0,
            Map.of(
                5,
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(28));
            .build();
        metadata = Metadata.builder(newState.metadata())
        GatewayAllocator gatewayAllocator = new TestGatewayAllocator();
        RoutingTable updatedRoutingTable = RoutingTable.builder(newState.routingTable()).addAsNew(metadata.index("test1")).build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(20));
            )
        return createAllocationService(buildSettings(settingsValue), gatewayAllocator);
                    .settings(
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(20));
        logger.info("Building initial routing table for 'testSingleZoneTwoReplicaLimitsReplicaAllocationOnOverload'");
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
import org.opensearch.cluster.metadata.IndexMetadata;
    }
        assertThat(newState.getRoutingNodes().node("node15").size(), equalTo(4));
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 20)
    }
        );
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(20));
        assertThat(newState.getRoutingNodes().node("node13").size(), equalTo(4));
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node1", singletonMap("zone", "zone_1"))))
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
        assertThat(newState.getRoutingNodes().node("node11").size(), equalTo(4));
            assertThat(node.size(), equalTo(42));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(20).numberOfReplicas(0))
            .build();
        newState = ClusterState.builder(newState)
        logger.info("--> all shards are started");
            )
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(30));
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
                5,
        }
        }
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(20).numberOfReplicas(0))
        // increases avg shard per node to 80/5 = 16, overload factor 1.2, total allowed 20
            newState = startInitializingShardsAndReroute(strategy, newState);
            Map.of(
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
                    .settings(
        logger.info("--> start the shards (primaries)");
    }
        logger.info("--> complete relocation");
        }
            newState.getRoutingNodes()
import org.opensearch.cluster.routing.ShardRoutingState;
            .put(
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node12", singletonMap("zone", "zone3"))))
            )
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
        }
                "zone_1,zone_2,zone_3"
        logger.info("add another index with 20 shards");
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(60));
        clusterState = strategy.reroute(clusterState, "reroute");
            gatewayAllocator
        newState = addNodes(clusterState, strategy, "zone3", "node11", "node12", "node13");
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(12));
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            newState = startInitializingShardsAndReroute(strategy, newState);
            .nodes(
            assertThat(node.size(), equalTo(10));
        logger.info("no limits should be applied on newly created primaries");
                5,
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING.getKey(), 20)
        logger.info("--> Remove three node from zone3 holding primary and replicas");
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        logger.info("--> start the shards (primaries)");
        newState = strategy.reroute(newState, "reroute");
        ClusterState newState = addNodes(clusterState, strategy, "zone3", "node11", "node12", "node13", "node14", "node15");
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        newState = ClusterState.builder(newState)
        }
        logger.info("--> add another node with a new rack, make sure nothing moves");
            newState.getRoutingNodes()
            .build();
        logger.info("--> start the shards (primaries)");
        newState = strategy.reroute(newState, "reroute");
        }
        logger.info("--> Remove nodes from zone holding primaries");
            .build();
        }
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 20)
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(63));
        newState = ClusterState.builder(newState)
            .build();
        assertThat(newState.getRoutingNodes().node("node12").size(), equalTo(4));
            assertEquals(shard.unassignedInfo().getReason(), UnassignedInfo.Reason.NODE_LEFT);
            newState = startInitializingShardsAndReroute(strategy, newState);
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        updatedRoutingTable = RoutingTable.builder(newState.routingTable()).addAsNew(metadata.index("test3")).build();
            )
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING.getKey(),
            )
import static org.hamcrest.Matchers.sameInstance;
            .build();
        }
            .build();
                    )
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        // replicas are unassigned
                15,
            )
        // remove one node to make zone1 skewed
            .build();
        }
            Map.of(
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(32));
    public void testNoAllocationLimitsOnOverloadForDisabledLoadFactor() {
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            assertEquals(shard.unassignedInfo().getReason(), UnassignedInfo.Reason.NODE_LEFT);
        ClusterState newState = removeNodes(clusterState, strategy, "node1", "node2", "node3");
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
                15,
            newState = startInitializingShardsAndReroute(strategy, newState);
        assertThat(newState.getRoutingNodes().node("node12").size(), equalTo(4));
        newState = ClusterState.builder(newState)
        logger.info("change settings to allow unassigned primaries");
        newState = ClusterState.builder(newState).metadata(metadata).routingTable(updatedRoutingTable).build();
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
                "zone_1,zone_2,zone_3"
            )
        // Each node can take 12 shards each (2 + ceil(8*1.2))
        assertThat(newState.getRoutingNodes().node("node13").size(), equalTo(4));
        assertThat(newState.getRoutingNodes().node("node13").size(), equalTo(4));
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(36));
            .build();
            .build();
    public void testThreeZoneTwoReplicaLimitsShardAllocationOnOverloadAcrossZones() {
        // remove one nodes in one zone to cause distribution zone1->2 , zone2->3, zone3->2
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(20));
            )
        assertThat(newState.getRoutingNodes().node("node15").size(), equalTo(4));
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        Metadata metadata = Metadata.builder()
        logger.info("--> adding three nodes on same rack and do rerouting");
            assertEquals(shard.unassignedInfo().getReason(), UnassignedInfo.Reason.INDEX_CREATED);
    }
        return allocationService.reroute(clusterState, "reroute");
            .build();
        Metadata metadata = Metadata.builder()
        clusterState = addNodes(clusterState, strategy, "zone2", "node6", "node7", "node8", "node9", "node10");
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(
        ClusterState newState = removeNodes(clusterState, strategy, "node1");
            )
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        newState = addNodes(newState, strategy, "zone3", "node12");
        logger.info("add another index with 60 shards");
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node2", singletonMap("zone", "zone_1"))))
            .build();
            .routingTable(initialRoutingTable)
 * The OpenSearch Contributors require contributions made to
            .metadata(metadata)
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        clusterState = removeNodes(clusterState, strategy, randomFrom("node1", "node2", "node3"));
                IndexMetadata.builder("test1")
            .build();
    private AllocationService createAllocationServiceWithAdditionalSettings(
            0L,
        metadata = Metadata.builder(newState.metadata())
        }
        logger.info("--> add another five node in new zone and reroute");
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING.getKey(),
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(20));
            gatewayAllocator
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        }
        }
            .metadata(metadata)
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
        newState = strategy.reroute(newState, "reroute");
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node3", singletonMap("zone", "zone_1"))))
        logger.info("--> change the overload load factor to zero and verify if unassigned primaries on disk get assigned despite overload");
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(
import static java.util.Collections.singletonMap;
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(60));
                    .settings(
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(40));
        GatewayAllocator gatewayAllocator
        clusterState = addNodes(clusterState, strategy, "zone_1", "node1", "node2", "node3");
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(21));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(20).numberOfReplicas(2))
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
            assertEquals(shard.unassignedInfo().getReason(), UnassignedInfo.Reason.NODE_LEFT);
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        }
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
        assertThat(newState.getRoutingNodes().node("node11").size(), equalTo(8));
import org.apache.logging.log4j.LogManager;
                IndexMetadata.builder("test1")
        logger.info("Building initial routing table for 'testSingleZoneOneReplicaLimitsShardAllocationOnOverload'");
        Metadata metadata = Metadata.builder()
            .build();
            else if (v instanceof Boolean) settingsBuilder.put(k, (Boolean) (v));
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
import org.opensearch.test.gateway.TestGatewayAllocator;
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        // each node can take 10 shards each (2 + ceil(7*1.1))
        // ensure minority zone doesn't get overloaded
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(40));
            )
        for (RoutingNode node : newState.getRoutingNodes()) {
        newState = startInitializingShardsAndReroute(strategy, newState);
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        logger.info("Building initial routing table for 'testThreeZoneTwoReplicaLimitsUnderFullZoneFailure'");
        }
            .build();
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).stream().filter(ShardRouting::primary).count(), equalTo(5L));
}
        logger.info("--> start the shards (primaries)");
        logger.info("--> replicas are started");
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
        while (clusterState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
            .build();
                9,
            .routingTable(initialRoutingTable)
                10,
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
        logger.info("--> do another reroute, make sure nothing moves");
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        clusterState = addNodes(clusterState, strategy, "zone2", "node6", "node7", "node8", "node9", "node10");
                    )
            .build();
    private ClusterState removeNodes(ClusterState clusterState, AllocationService allocationService, String... nodeIds) {
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(60));
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        while (clusterState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        logger.info("--> replica will not start because we have only one zone value");
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
        }
        logger.info("--> add three new node with a new rack and reroute");
                IndexMetadata.builder("test1")
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(30));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
            .put(
        return createAllocationService(buildSettings(settingsValue));
        strategy = createAllocationServiceWithAdditionalSettings(
        for (ShardRouting shard : newState.getRoutingNodes().shardsWithState(UNASSIGNED)) {
            newState = startInitializingShardsAndReroute(strategy, newState);
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(126));
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(12));
            newState = startInitializingShardsAndReroute(strategy, newState);
            .build();
        logger.info("--> replicas are initializing");
            .build();
        // ensure all shards are assigned
        newState = ClusterState.builder(newState).metadata(metadata).routingTable(updatedRoutingTable).build();
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
                .shardsWithState(UNASSIGNED)
    private ClusterState addNodes(ClusterState clusterState, AllocationService allocationService, String zone, String... nodeIds) {
import org.opensearch.cluster.routing.ShardRouting;
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(60));
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
import org.opensearch.cluster.ClusterState;
        newState = strategy.reroute(newState, "reroute");
                IndexMetadata.builder("test2")
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(30).numberOfReplicas(1))
        for (ShardRouting shard : clusterState.getRoutingNodes().shardsWithState(UNASSIGNED)) {
                15,
        logger.info("--> add another five node in new zone and reroute");
        newState = strategy.reroute(newState, "reroute");
        logger.info("--> adding five nodes on same zone and do rerouting");
    ) {
        logger.info("--> Remove two nodes from zones");
                    .add(newNode("node7", singletonMap("zone", "zone_3")))
            .metadata(metadata)
            .metadata(metadata)
        }
        // add the removed node
        assertThat(strategy.reroute(newState, "reroute").routingTable(), sameInstance(newState.routingTable()));
    }
                    )
        newState = strategy.reroute(newState, "reroute");
        );
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
        newState = ClusterState.builder(newState).metadata(metadata).routingTable(updatedRoutingTable).build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(40));
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(32));
        // Each node can take 6 shards max (2 + ceil(4*1.0)), so all shards should be assigned
        Map<String, Object> settingsValue,
        logger.info("--> do another reroute, make sure nothing moves");
    }
        // Each node can take 7 shards each now (2 + ceil(4*1.2))
        Metadata metadata = Metadata.builder()
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING.getKey(),
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(36));
        newState = strategy.reroute(newState, "reroute");
        assertThat(newState.getRoutingNodes().node("node14").size(), equalTo(7));
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(32));
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING.getKey(),
        }
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(20));
            ),
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(6));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(18));
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(120));
            .put(
        metadata = Metadata.builder(newState.metadata())
        clusterState = addNodes(clusterState, strategy, "zone_1", "node1", "node2", "node3", "node4", "node5");
            Map.of(
        RoutingTable updatedRoutingTable = RoutingTable.builder(newState.routingTable()).addAsNew(metadata.index("test1")).build();
        }
        }
        assertThat(newState.getRoutingNodes().node("node14").size(), equalTo(5));
        logger.info("--> do another reroute, make sure nothing moves");
        for (ShardRouting shard : newState.getRoutingNodes().shardsWithState(UNASSIGNED)) {
            .build();
        logger.info("--> do another reroute, make sure nothing moves");
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            .build();
        );
import org.opensearch.cluster.node.DiscoveryNodes;
        }
        logger.info("--> Remove three node from zone3");
        clusterState = addNodes(clusterState, strategy, "zone1", "node1", "node2", "node3", "node4", "node5");
                20,
    }
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        // add the removed nodes
        // add back node2 when skewness is still breached
        // Each node can take 7 shards max ( 2 + ceil(4*1.2))
        while (clusterState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        );
        }
        logger.info("--> start the shards (primaries)");
        clusterState = addNodes(clusterState, strategy, "zone_1", "node1", "node2", "node3", "node4", "node5");
        );
                .count()
        newState = strategy.reroute(newState, "reroute");
        logger.info("--> start the shards (replicas)");
                10,
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
            Map.of(
        for (RoutingNode node : newState.getRoutingNodes()) {
            .build();
        newState = ClusterState.builder(newState)
        logger.info("--> Removing three nodes from zone3");
        newState = strategy.reroute(newState, "reroute");
    private Settings buildSettings(Map<String, Object> settingsValue) {
    public void testNewUnassignedPrimaryAllocationOnOverload() {
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(6));
        }
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 20)
 */
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node3", singletonMap("zone", "zone_1"))))
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 30)
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(14));
        assertThat(newState.getRoutingNodes().node("node12").size(), equalTo(4));
                0,
        strategy = createAllocationServiceWithAdditionalSettings(
        // add the removed node
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));
        Metadata metadata = Metadata.builder()
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        clusterState = addNodes(clusterState, strategy, "zone1", "node1", "node2", "node3", "node4", "node5");
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
            .build();
            .build();
        logger.info("--> complete relocation");
        logger.info("Building initial routing table for 'testNoAllocationLimitsOnOverloadForDisabledLoadFactor'");
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(20));
        }
        RoutingTable updatedRoutingTable = RoutingTable.builder(newState.routingTable()).addAsNew(metadata.index("test1")).build();
            .build();
                false
        newState = strategy.reroute(newState, "reroute");
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(21).numberOfReplicas(2))
        // add back node3
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(30));
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(
        // add the removed node
        );
        assertThat(newState.getRoutingNodes().node("node5").size(), equalTo(14));
        updatedRoutingTable = RoutingTable.builder(newState.routingTable()).addAsNew(metadata.index("test2")).build();
        assertThat(newState.getRoutingNodes().node("node14").size(), equalTo(4));
        Metadata metadata = Metadata.builder()
        clusterState = addNodes(clusterState, strategy, "zone2", "node6", "node7", "node8", "node9", "node10");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
        newState = ClusterState.builder(newState)
            Map.of(
        clusterState = addNodes(clusterState, strategy, "zone1", "node3", "node4");
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
            newState = startInitializingShardsAndReroute(strategy, newState);
                20,
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node1", singletonMap("zone", "zone_1"))))
            .build();
        assertThat(newState.getRoutingNodes().node("node12").size(), equalTo(8));
        logger.info("--> start the shards (primaries)");
        }
        // replicas are unassigned
        logger.info("--> Remove node1 from zone");
        ClusterState newState = addNodes(clusterState, strategy, "zone_3", "node7", "node8", "node9");
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(2));
        // add the removed node
        }
        for (ShardRouting shard : newState.getRoutingNodes().shardsWithState(UNASSIGNED)) {
        newState = strategy.reroute(newState, "reroute");
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(2))
                false
            .build();
        // add back node2 when skewness is still breached
            newState = startInitializingShardsAndReroute(strategy, newState);
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(14));
        newState = removeNodes(newState, strategy, "node11", "node12", "node13", "node14", "node15");
                IndexMetadata.builder("test1")
        ClusterState newState = removeNodes(clusterState, strategy, "node1", "node2", "node3");
            .build();
                20
        clusterState = strategy.reroute(clusterState, "reroute");
            .routingTable(initialRoutingTable)
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(42));
        newState = ClusterState.builder(newState)
        for (ShardRouting shard : newState.getRoutingNodes().shardsWithState(UNASSIGNED)) {
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(
        assertThat(newState.getRoutingNodes().node("node13").size(), equalTo(4));
        logger.info("--> do another reroute, make sure nothing moves");
        assertThat(newState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(6));
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING.getKey(),
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(30));
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        Metadata metadata = Metadata.builder()
            newState = startInitializingShardsAndReroute(strategy, newState);
            newState = startInitializingShardsAndReroute(strategy, newState);
        newState = strategy.reroute(newState, "reroute");
                throw new UnsupportedOperationException("Unsupported type for key :" + k);
        logger.info("Building initial routing table for 'testThreeZoneTwoReplicaLimitsShardAllocationOnOverloadAcrossZones'");
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(40));
        logger.info("--> Add back node4 and ensure existing primaries are assigned");
import org.opensearch.cluster.routing.RoutingNode;
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(30).numberOfReplicas(1))
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(40));
        clusterState = addNodes(clusterState, strategy, "zone1", "node1", "node2", "node3", "node4", "node5");
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(newState.getRoutingNodes().node("node4").size(), equalTo(14));
        newState = strategy.reroute(newState, "reroute");
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(60));
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(20));
            assertEquals(shard.unassignedInfo().getReason(), UnassignedInfo.Reason.NODE_LEFT);
        newState = ClusterState.builder(newState)
        // 4 existing shards from this node's local store get started
        }
        return settingsBuilder.build();
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(66));
import org.opensearch.common.settings.Settings;
        logger.info("--> adding five nodes on same zone and do rerouting");
            )
        RoutingTable updatedRoutingTable = RoutingTable.builder(newState.routingTable()).addAsNew(metadata.index("test1")).build();
        logger.info("--> do another reroute, make sure nothing moves");
 * SPDX-License-Identifier: Apache-2.0
        logger.info("Building initial routing table for 'testThreeZoneOneReplicaWithSkewFactorZeroAllShardsAssignedAfterRecovery'");
            newState = startInitializingShardsAndReroute(strategy, newState);
        newState = addNodes(newState, strategy, "zone3", "node11");
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 60)
        assertThat(newState.getRoutingNodes().node("node13").size(), equalTo(4));
