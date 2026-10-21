            .metadata(metadata)
                    .settings(settings(Version.CURRENT))
        clusterState = ClusterState.builder(clusterState)
                    .add(newSearchNode("node4", Map.of("zone", "a")))
        clusterState = ClusterState.builder(clusterState)
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(3));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        );
    public void testMoveShardOnceNewNodeWithOutAwarenessAttributeAdded() {
        logger.info("--> start the shards (primaries)");
 */
 * The OpenSearch Contributors require contributions made to
                .build()
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        logger.info("--> adding three nodes on same rack and do rerouting");
        logger.info("--> Building initial routing table'");
        clusterState = ClusterState.builder(clusterState)
                    .numberOfShards(1)
        clusterState = strategy.reroute(clusterState, "reroute");
    private final Logger logger = LogManager.getLogger(SearchReplicaAwarenessAllocationTests.class);
                DiscoveryNodes.builder()
 * compatible open source license.
            Settings.builder().put("cluster.routing.allocation.awareness.attributes", "zone").build()
import org.opensearch.cluster.routing.allocation.AllocationService;
            .nodes(
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
        clusterState = ClusterState.builder(clusterState)
            .metadata(metadata)
        logger.info("Building initial routing table");
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
        assertThat(shardRoutings.get(1).relocatingNodeId(), equalTo("node6"));
 * this file be licensed under the Apache-2.0 license or a
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    public void testFullAwarenessWithSearchReplica() {
            true,
        logger.info("--> add a two nodes with a new zone and reroute");
        clusterState = strategy.reroute(clusterState, "reroute");
        logger.info("--> do another reroute, make sure nothing moves");
    }
}
            .build();
        logger.info("--> complete relocation");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        );
            .put(
            .filter(item -> item.type() == Decision.Type.NO)
            .nodes(
        Metadata metadata = Metadata.builder()
        assertEquals(commandsResult.explanations().explanations().get(0).decisions().type(), Decision.Type.NO);
            .metadata(metadata)
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                IndexMetadata.builder("test")
        logger.info("--> add a new node with a new zone and reroute");
                + "required attributes cluster setting [cluster.routing.allocation.awareness.attributes=zone]",
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
import org.opensearch.cluster.routing.ShardRoutingState;
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
        logger.info("--> do another reroute, make sure nothing moves");
            .toList();
package org.opensearch.cluster.routing.allocation.decider;
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            .build();
            .put(
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.cluster.routing.RoutingTable;
        logger.info("--> add a search node without zone and reroute");
            .build();
                    .add(newSearchNode("node6", Map.of("zone", "b")))
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
    }
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
        AllocationService strategy = createAllocationService(
        assertEquals(commandsResult.explanations().explanations().size(), 1);
import static org.hamcrest.Matchers.equalTo;
            new AllocationCommands(new MoveAllocationCommand("test", 0, "node2", "node3")),
import org.opensearch.cluster.routing.ShardRouting;
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
            "node does not contain the awareness attribute [zone]; "
import org.opensearch.cluster.metadata.IndexMetadata;
            .build();
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            )
            .getDecisions()
 * SPDX-License-Identifier: Apache-2.0
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = ClusterState.builder(clusterState)
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(4));
/*
            .get(0)
                    .add(newSearchNode("node3", Map.of("zone", "a")))
                    .numberOfReplicas(1)
            )
        clusterState = ClusterState.builder(clusterState)
                DiscoveryNodes.builder(clusterState.nodes())
                .put("cluster.routing.allocation.awareness.attributes", "zone")
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(), equalTo("node3"));
        logger.info("--> start the shards (replicas)");
            .build();
        logger.info("--> start the shards (primaries)");
import static org.hamcrest.Matchers.sameInstance;
            .build();
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
 *
        logger.info("--> Building initial routing table");
        shardRoutings.sort(Comparator.comparing(ShardRouting::currentNodeId));
            .build();
                    .add(newNode("node2", Map.of("zone", "a")))
import org.opensearch.Version;
import org.apache.logging.log4j.Logger;
                    .add(newNode("node1", Map.of("zone", "a")))
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node7", Map.of("zone", "c"))))
        ClusterState newState = strategy.reroute(clusterState, "reroute");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            )
            .explanations()
        assertThat(newState, equalTo(clusterState));
        Metadata metadata = Metadata.builder()
            .build();
        List<ShardRouting> shardRoutings = clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING);
    }
                    .settings(settings(Version.CURRENT))
            clusterState,
        );
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(3));
        AllocationService.CommandsResult commandsResult = strategy.reroute(
            )
import java.util.Map;
                    .add(newNode("node5", Map.of("zone", "b")))
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
                    .numberOfShards(1)
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(4));
                    .numberOfSearchReplicas(1)
        assertEquals(
            .nodes(DiscoveryNodes.builder().add(newNode("node1", Map.of("zone", "a"))).add(newSearchNode("node2", Map.of("zone", "a"))))
            .build();
                    .numberOfSearchReplicas(2)
        logger.info("--> start the shards (primaries)");
                    .numberOfShards(1)
            .build();
import org.opensearch.cluster.metadata.Metadata;
            decisions.get(0).getExplanation()
        logger.info("--> start the shards (replicas)");
import org.apache.logging.log4j.LogManager;
            .build();
        logger.info("--> start the shards (replicas)");
        logger.info("--> complete relocation");
            false
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
        AllocationService strategy = createAllocationService(
import java.util.List;
            .routingTable(initialRoutingTable)
        clusterState = ClusterState.builder(clusterState)
        Metadata metadata = Metadata.builder()
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        clusterState = ClusterState.builder(clusterState)
            .stream()
            Settings.builder()
        ClusterState newState = strategy.reroute(clusterState, "reroute");
        logger.info("--> one search replica will not start because we have only one zone value");
        logger.info("--> add a new node with a new zome and reroute");
    public void testAllocationAwarenessForIndexWithSearchReplica() {
            .put(
        logger.info("--> adding four nodes on same zone and do rerouting");
                    .settings(settings(Version.CURRENT))
        logger.info("--> try to move the replica to node without zone attribute");
import static java.util.Collections.singletonMap;
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newSearchNode("node3", Map.of("zone", "2"))))
        clusterState = strategy.reroute(clusterState, "reroute");
                .put("cluster.routing.allocation.awareness.force.zone.values", "a,b")
        logger.info("--> adding four nodes on same zone and do rerouting");
            .routingTable(initialRoutingTable)
        logger.info("--> add another node with a new zone, make sure nothing moves");
            Settings.builder().put("cluster.routing.allocation.awareness.attributes", "zone").build()
import org.opensearch.cluster.ClusterState;
            .nodes(DiscoveryNodes.builder().add(newNode("node1", Map.of("zone", "a"))).add(newSearchNode("node2", Map.of("zone", "a"))))
            .routingTable(initialRoutingTable)
public class SearchReplicaAwarenessAllocationTests extends OpenSearchAllocationTestCase {
        logger.info("--> do another reroute, make sure nothing moves");
        assertThat(newState, equalTo(clusterState));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        );
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
import java.util.Comparator;
        clusterState = strategy.reroute(clusterState, "reroute");
        AllocationService strategy = createAllocationService(
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        );
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(2));
        List<Decision> decisions = commandsResult.explanations()
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(4));
            .decisions()
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
            )
import org.opensearch.common.settings.Settings;
                IndexMetadata.builder("test")
        assertThat(shardRoutings.get(0).relocatingNodeId(), equalTo("node5"));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newSearchNode("node3", Map.of("searchonly", "true"))))
                IndexMetadata.builder("test")
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(1));
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                    .numberOfReplicas(0)
                    .numberOfSearchReplicas(2)
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4", singletonMap("zone", "c"))))
                    .numberOfReplicas(0)
