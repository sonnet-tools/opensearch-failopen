        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
        logger.info("--> try to move the replica to node without zone attribute");  
import org.opensearch.cluster.routing.allocation.AllocationService;  
import org.opensearch.common.settings.Settings;  
    }
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        );
        logger.info("--> adding four nodes on same zone and do rerouting");  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(4));  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));  
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        logger.info("--> Building initial routing table'");  
            .put(  
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
            )
                .put("cluster.routing.allocation.awareness.attributes", "zone")
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
        logger.info("--> one search replica will not start because we have only one zone value");
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node7", Map.of("zone", "c"))))
import java.util.Map;
        clusterState = strategy.reroute(clusterState, "reroute");
                IndexMetadata.builder("test")
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newSearchNode("node3", Map.of("searchonly", "true"))))  
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
                    .add(newNode("node2", Map.of("zone", "a")))
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(3));
    private final Logger logger = LogManager.getLogger(SearchReplicaAwarenessAllocationTests.class);
            .nodes(
    }
                IndexMetadata.builder("test")  
        );
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4", singletonMap("zone", "c"))))  
        logger.info("--> adding four nodes on same zone and do rerouting");
import org.apache.logging.log4j.Logger;
            .build();
        logger.info("--> complete relocation");
                DiscoveryNodes.builder()  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
        logger.info("Building initial routing table");  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(4));
        shardRoutings.sort(Comparator.comparing(ShardRouting::currentNodeId));
                    .numberOfShards(1)  
            .build();  
        logger.info("--> adding three nodes on same rack and do rerouting");  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(2));
}  
            .routingTable(initialRoutingTable)  
 * SPDX-License-Identifier: Apache-2.0
            .put(
import org.opensearch.cluster.node.DiscoveryNodes;
            .get(0)  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
            )  
            .build();  
 *
            new AllocationCommands(new MoveAllocationCommand("test", 0, "node2", "node3")),  
 * compatible open source license.
        logger.info("--> start the shards (replicas)");  
            )
                    .numberOfSearchReplicas(1)
        Metadata metadata = Metadata.builder()
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
            )
                .build()  
            Settings.builder().put("cluster.routing.allocation.awareness.attributes", "zone").build()  
        logger.info("--> add a new node with a new zome and reroute");
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(1));
            .explanations()
        Metadata metadata = Metadata.builder()
        );
    }
import java.util.Comparator;
            .build();  
            .filter(item -> item.type() == Decision.Type.NO)
                + "required attributes cluster setting [cluster.routing.allocation.awareness.attributes=zone]",
        logger.info("--> do another reroute, make sure nothing moves");  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(), equalTo("node3"));  
        AllocationService strategy = createAllocationService(
                    .settings(settings(Version.CURRENT))
        clusterState = ClusterState.builder(clusterState)
public class SearchReplicaAwarenessAllocationTests extends OpenSearchAllocationTestCase {  
                    .numberOfReplicas(0)  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        clusterState = ClusterState.builder(clusterState)
        assertThat(shardRoutings.get(0).relocatingNodeId(), equalTo("node5"));
                    .add(newNode("node5", Map.of("zone", "b")))  
    public void testFullAwarenessWithSearchReplica() {
        logger.info("--> start the shards (replicas)");
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
        Metadata metadata = Metadata.builder()
        );
        logger.info("--> add a two nodes with a new zone and reroute");
            .build();  
            .build();
        assertEquals(commandsResult.explanations().explanations().get(0).decisions().type(), Decision.Type.NO);  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                    .add(newSearchNode("node4", Map.of("zone", "a")))
        logger.info("--> add a search node without zone and reroute");
import static org.hamcrest.Matchers.equalTo;  
                    .add(newSearchNode("node3", Map.of("zone", "a")))  
                .put("cluster.routing.allocation.awareness.force.zone.values", "a,b")
        logger.info("--> add a new node with a new zone and reroute");  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(4));
            .build();
        logger.info("--> do another reroute, make sure nothing moves");
/*  
            .getDecisions()
        );  
            "node does not contain the awareness attribute [zone]; "
            .routingTable(initialRoutingTable)
                    .numberOfShards(1)
            .build();
        clusterState = ClusterState.builder(clusterState)
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
                    .add(newNode("node1", Map.of("zone", "a")))
 * The OpenSearch Contributors require contributions made to  
        logger.info("--> start the shards (primaries)");
import org.apache.logging.log4j.LogManager;
            .stream()  
            .routingTable(initialRoutingTable)  
import org.opensearch.cluster.routing.ShardRoutingState;
        logger.info("--> start the shards (primaries)");  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
import java.util.List;  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(3));
        clusterState = strategy.reroute(clusterState, "reroute");
                    .settings(settings(Version.CURRENT))
            clusterState,
package org.opensearch.cluster.routing.allocation.decider;
            Settings.builder()  
            .build();  
        logger.info("--> Building initial routing table");  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
    public void testAllocationAwarenessForIndexWithSearchReplica() {
import org.opensearch.cluster.metadata.IndexMetadata;  
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newSearchNode("node3", Map.of("zone", "2"))))  
        AllocationService.CommandsResult commandsResult = strategy.reroute(
        clusterState = strategy.reroute(clusterState, "reroute");  
            .metadata(metadata)
            .toList();
        assertThat(newState, equalTo(clusterState));  
        assertEquals(commandsResult.explanations().explanations().size(), 1);
            .build();  
        AllocationService strategy = createAllocationService(
            .nodes(DiscoveryNodes.builder().add(newNode("node1", Map.of("zone", "a"))).add(newSearchNode("node2", Map.of("zone", "a"))))
import org.opensearch.cluster.OpenSearchAllocationTestCase;
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        clusterState = strategy.reroute(clusterState, "reroute");
        logger.info("--> complete relocation");
            .build();  
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
            decisions.get(0).getExplanation()  
        clusterState = ClusterState.builder(clusterState)
            .put(
            .build();
            .nodes(
    public void testMoveShardOnceNewNodeWithOutAwarenessAttributeAdded() {
            )
            .decisions()
            .metadata(metadata)
import static org.hamcrest.Matchers.sameInstance;
 */  
                    .settings(settings(Version.CURRENT))
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
        clusterState = ClusterState.builder(clusterState)  
        clusterState = ClusterState.builder(clusterState)  
        assertThat(newState, equalTo(clusterState));  
        logger.info("--> add another node with a new zone, make sure nothing moves");
                    .numberOfReplicas(1)
                    .add(newSearchNode("node6", Map.of("zone", "b")))
            .build();
import org.opensearch.cluster.metadata.Metadata;
                    .numberOfReplicas(0)  
                    .numberOfShards(1)
                    .numberOfSearchReplicas(2)
                IndexMetadata.builder("test")  
        logger.info("--> start the shards (replicas)");
        clusterState = ClusterState.builder(clusterState)
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
        assertThat(shardRoutings.get(1).relocatingNodeId(), equalTo("node6"));  
            Settings.builder().put("cluster.routing.allocation.awareness.attributes", "zone").build()  
import org.opensearch.cluster.ClusterState;
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .build();
import org.opensearch.cluster.routing.ShardRouting;
        ClusterState newState = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));  
            true,
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));  
        ClusterState newState = strategy.reroute(clusterState, "reroute");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        logger.info("--> do another reroute, make sure nothing moves");  
        clusterState = ClusterState.builder(clusterState)
        List<ShardRouting> shardRoutings = clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING);  
        assertEquals(  
        AllocationService strategy = createAllocationService(
import org.opensearch.Version;  
        logger.info("--> start the shards (primaries)");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
            .nodes(DiscoveryNodes.builder().add(newNode("node1", Map.of("zone", "a"))).add(newSearchNode("node2", Map.of("zone", "a"))))
        clusterState = strategy.reroute(clusterState, "reroute");
        List<Decision> decisions = commandsResult.explanations()
import org.opensearch.cluster.routing.RoutingTable;  
                DiscoveryNodes.builder(clusterState.nodes())
                    .numberOfSearchReplicas(2)
            .metadata(metadata)
import static java.util.Collections.singletonMap;  
            false
