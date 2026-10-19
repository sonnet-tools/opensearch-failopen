        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(4));
        // placed and stays UNASSIGNED. If zone a had been wrongly dropped, the cap would be ceil(4/1) = 4 and all
        final Metadata metadata = Metadata.builder().put(metadataBuilder).build();  
        assertThat(clusterState.getRoutingNodes().node("node4").size(), equalTo(5));  
        logger.info("--> adding two nodes on same rack and do rerouting");
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(4))
 * SPDX-License-Identifier: Apache-2.0
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(5));
            .metadata(metadata)  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(4));
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
        logger.info("--> do another reroute, make sure nothing moves");
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        );
            .build();
        // With nothing excluded, awareness counts all three zones {a, b, c}, so the per-zone cap is ceil(3/3) = 1.
                .nodes(nodes)  
            .build();  
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(1)); // Unassigned shard is expected.
            .build();
            .add(newNode("b2", singletonMap("zone", "b")))
        );  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
            .build();
        assertThat(newState, equalTo(clusterState));  
            )  
import static org.hamcrest.Matchers.equalTo;
            .build();
        Metadata metadata = Metadata.builder()  
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("A-1", singletonMap("zone", "a"))))
            true,
    }
        final RoutingAllocation allocation = new RoutingAllocation(
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(1));
                .build()
        clusterState = ClusterState.builder(clusterState)  
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))  
            .build();
            .build();
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)  
                        + " total attribute values, expected the allocated shard count per attribute [2] to"
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(10));  
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
    }  
    }
            .build();  
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        clusterState = strategy.reroute(clusterState, "reroute");  
            .build();
                    .add(newNode("node1", singletonMap("rack_id", "1")))
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testUnbalancedZones() {
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
    }  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
    }
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                .build()
                DiscoveryNodes.builder()
                .build()  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
    private final Logger logger = LogManager.getLogger(AwarenessAllocationTests.class);
            if (routing.primary()) {
            .add(newNode("b1", singletonMap("zone", "b")))  
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
                    .put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-all")  
        final Settings settings = Settings.builder()
        AllocationService strategy = createAllocationService(
            .routingTable(initialRoutingTable)
        logger.info("--> start the shards (primaries)");
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));  
            .metadata(metadata)
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).get(0).relocatingNodeId(),  
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(8));
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            Settings.builder()
            .nodes(
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(1));
            .put("cluster.routing.allocation.exclude._id", "a1")
            )  
    }  
        }  
        clusterState = strategy.reroute(clusterState, "reroute");
            .build();
                .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone, rack")
        Metadata metadata = Metadata.builder()
 */  
        logger.info("--> start the shards (replicas)");
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(10));  
        final RoutingAllocation allocation = new RoutingAllocation(
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
        AllocationService strategy = createAllocationService(
                        + " [zone], there are [3] total configured shard copies for this shard id and [3]"
        AllocationService strategy = createAllocationService(settings);
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));  
                DiscoveryNodes.builder()
            .build();
import org.opensearch.cluster.routing.allocation.decider.Decision;  
                DiscoveryNodes.builder()
import static org.hamcrest.Matchers.greaterThan;
            // with zero attribute values left, awareness must not veto (and must not divide by zero) ...
            // ... leaving FilterAllocationDecider as the decider that keeps shards off the excluded nodes  
            Settings.builder()
            equalTo("node3")
import java.util.Collections;  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(5));  
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4", singletonMap("rack_id", "2"))))
        Metadata metadata = Metadata.builder()
            .add(newNode("A-0", singletonMap("zone", "a")))  
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
        assertEquals(commandsResult.explanations().explanations().size(), 1);  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));  
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.get(Settings.EMPTY))
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(4)); // +1 for relocating shard.
            .metadata(metadata)  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        clusterState = strategy.reroute(clusterState, "reroute");
        // One Shard is unassigned due to forced zone awareness  
 *
    public void testUnassignedShardsWithUnbalancedZones() {  
import static org.hamcrest.Matchers.sameInstance;  
        assertThat(  
        clusterState = ClusterState.builder(clusterState)
            .addAsNew(metadata.index("test2"))
 * software distributed under the License is distributed on an
        logger.info("--> complete initializing");
        nodeAAttributes.put("rack", "c");
    public void testFullAwareness2() {
            .getDecisions()  
            .build();
                .build()
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(1));
        logger.info("Building initial routing table for 'testAllocationExplainForUnassignedShardsWithUnbalancedZones'");
                    .add(newNode("A-0", singletonMap("zone", "a")))
        clusterState = strategy.reroute(clusterState, "reroute");  
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;  
        logger.info("--> add a new node with a new rack and reroute");
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
                .put("cluster.routing.allocation.awareness.force.zone.values", "a,b")
        final AllocationService strategy = createAllocationService(settings);  
        clusterState = strategy.reroute(clusterState, "reroute");  
        logger.info("--> do another reroute, make sure nothing moves");
        logger.info("--> do another reroute, make sure nothing moves");
                .build(),
            .metadata(metadata)
        // 1 primary + 3 replicas = 4 copies of the shard  
        logger.info("--> adding two nodes on same zone and do rerouting");  
        assertThat(newState, equalTo(clusterState));
        final DiscoveryNodes nodes = DiscoveryNodes.builder()
        logger.info("--> complete relocation");  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(5));
        final RoutingNodes routingNodes = clusterState.getRoutingNodes();
        assertThat(  
        Metadata metadata = Metadata.builder()
        clusterState = ClusterState.builder(clusterState)  
        logger.info("--> add a new node with a new rack and reroute");
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        // Zone a keeps counting because a2 is not excluded, so awareness sees zones {a, b} and the per-zone cap is
            equalTo("node4")
        clusterState = ClusterState.builder(clusterState)
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4", singletonMap("rack_id", "3"))))  
        clusterState = ClusterState.builder(clusterState)
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.get(Settings.EMPTY))
            .routingTable(initialRoutingTable)
            .put("cluster.routing.allocation.awareness.attributes", "zone")
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.get(Settings.EMPTY))  
            strategy
        clusterState = ClusterState.builder(clusterState)  
        );
        AllocationService strategy = createAllocationService(  
    public void testMultipleAwarenessAttributes() {
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        assertThat(routingNodes.shardsWithState(UNASSIGNED).size(), equalTo(0));  
        // 1 primary + 2 replicas = 3 copies of the shard  
                DiscoveryNodes.builder()
            .metadata(metadata)  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4", singletonMap("rack_id", "2"))))  
            .build();  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(20));
            .build();
        logger.info("--> start the shards (primaries)");
                primaryNode = routing.currentNodeId();
                    .add(newNode("node3", singletonMap("rack_id", "1")))
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(5));
            .build();
            .build();
        final ShardRouting primary = clusterState.getRoutingTable().shardsWithState(UNASSIGNED).get(0);
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));  
                .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())  
            .build();
                .put("cluster.routing.allocation.awareness.attributes", "rack_id")  
        logger.info("Building initial routing table for 'fullAwareness3'");  
        logger.info("--> start the shards (primaries)");
                .put("cluster.routing.allocation.awareness.force.rack_id.values", "1,2")
    }
        logger.info("--> start the shards (primaries)");  
        logger.info("--> make sure another reroute does not move things");
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        // ceil(3/2) = 2. All three copies allocate onto the two remaining zones and nothing is left unassigned.
        logger.info("--> add another node with a new rack, make sure nothing moves");
        clusterState = ClusterState.builder(clusterState)
            .routingTable(initialRoutingTable)
                .nodes(nodes)  
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
        assertThat(routingNodes.shardsWithState(UNASSIGNED).size(), equalTo(1));
        logger.info("--> complete relocation");
            .build();
package org.opensearch.cluster.routing.allocation;
                .build()
        logger.info("--> adding two nodes on same rack and do rerouting");
        logger.info("--> do another reroute, make sure nothing moves");
        logger.info("--> complete relocation");
 * license agreements. See the NOTICE file distributed with
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(4));
        }
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .routingTable(initialRoutingTable)
            .add(newNode("b1", singletonMap("zone", "b")))
            .add(newNode("a2", singletonMap("zone", "a")))  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            Settings.builder()
                    decision.getExplanation(),
                .metadata(metadata)
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(10));
                    .add(newNode("node1", singletonMap("rack_id", "1")))  
        logger.info("--> do another reroute, make sure nothing moves");
        assertThat(routingNodes.node("a1").size() + routingNodes.node("a2").size(), equalTo(1));
        clusterState = ClusterState.builder(clusterState)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;  
            .explanations()  
                DiscoveryNodes.builder()
        logger.info("--> add another node with a new rack, some more relocation should happen");  
        clusterState = strategy.reroute(clusterState, "reroute");
import org.apache.logging.log4j.LogManager;
        List<ShardRouting> unassignedShards = clusterState.getRoutingTable().shardsWithState(UNASSIGNED);  
 * You may obtain a copy of the License at  
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        Metadata metadata = Metadata.builder()  
        AllocationService strategy = createAllocationService(  
        // every node in every zone is excluded, so no awareness attribute values remain to balance across  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(0));
            .addAsNew(metadata.index("test1"))
            new AllocationCommands(new MoveAllocationCommand("test", 0, "node2", "node3")),
        logger.info("--> adding two nodes on same rack and do rerouting");
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(10));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
        // four copies would fit, so this asserts we drop a value only when every one of its nodes is excluded.
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)  
                DiscoveryNodes.builder()
                .put("cluster.routing.allocation.awareness.attributes", "rack_id")
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        );  
                DiscoveryNodes.builder()
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)  
        logger.info("--> start the shards (replicas)");
import org.opensearch.Version;  
        Map<String, String> nodeBAttributes = new HashMap<>();
            )
            .nodes(DiscoveryNodes.builder().add(newNode("a1", singletonMap("zone", "a"))).add(newNode("b1", singletonMap("zone", "b"))))
        final ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.get(Settings.EMPTY))
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(1)); // Still 1 unassigned.
            0L
        logger.info("--> adding two nodes on same rack and do rerouting");
        logger.info("--> replica will not start because we have only one rack value");
            Settings.builder()  
        logger.info("--> complete relocation");
                .build()  
        assertThat(newState, equalTo(clusterState));  
            clusterState,
            .routingTable(initialRoutingTable)
        logger.info("--> adding two nodes on same rack and do rerouting");
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
            .metadata(metadata)  
            .addAsNew(metadata.index("test1"))
    public void testAllocationExplainForUnassignedShardsWithUnbalancedZones() {
            }
        logger.info("--> add another node with a new rack, some more relocation should happen");
            if (node.nodeId().equals("A-0")) {
            .routingTable(initialRoutingTable)
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
                    .add(newNode("node3", singletonMap("rack_id", "1")))
            )
    public void testAwarenessDoesNotVetoWhenEveryZoneIsExcluded() {
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
        for (int i = 0; i < 2; i++) {  
            clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).get(0).relocatingNodeId(),
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))
                DiscoveryNodes.builder()
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
            .routingTable(initialRoutingTable)
        logger.info("--> adding two nodes in different zones and do rerouting");  
            .get(0)
        );
 * Unless required by applicable law or agreed to in writing,
        assertThat(routingNodes.node("b1").size() + routingNodes.node("b2").size() + routingNodes.node("b3").size(), equalTo(2));
            .build();  
            .build();
            )
        );
            .add(newNode("b1", singletonMap("zone", "b")))
            null,
            .routingTable(initialRoutingTable)
        Decision decision = null;
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                    .add(newNode("node1", singletonMap("rack_id", "1")))  
                    .add(newNode("node1", singletonMap("rack_id", "1")))
        logger.info("--> start the shards (primaries)");
            .add(newNode("c1", singletonMap("zone", "c")))  
        logger.info("--> start the shards (replicas)");
        final DiscoveryNodes nodes = DiscoveryNodes.builder()  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(10));
        AllocationService.CommandsResult commandsResult = strategy.reroute(
        AllocationService strategy = createAllocationService(Settings.builder().build());
            .settings(  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(3))
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
        );  
        assertThat(routingNodes.node("a2").size(), equalTo(1));
                    .add(newNode("node2", singletonMap("rack_id", "1")))  
        final IndexMetadata.Builder metadataBuilder = IndexMetadata.builder("test")
        );  
        clusterState = strategy.reroute(clusterState, "reroute");
            Settings.builder()
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
            .build();  
            .build();
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3", singletonMap("rack_id", "2"))))
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        logger.info("--> add a new node with a new rack and reroute");
 *     http://www.apache.org/licenses/LICENSE-2.0
            Settings.builder()  
        Metadata metadata = Metadata.builder()  
    }
                .build()  
        // zone a: a1 (excluded) and a2 (usable); zone b: three usable nodes
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))
        logger.info("--> add another node with a new rack, make sure nothing moves");
        clusterState = ClusterState.builder(clusterState)
            clusterState.getRoutingNodes(),
        clusterState = strategy.reroute(clusterState, "reroute");
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(), equalTo("node3"));
 * specific language governing permissions and limitations
        logger.info("--> add another node with a new rack, make sure nothing moves");
        // Previously all three zones were counted (ceil(3/3) = 1) and the third copy would stay UNASSIGNED.  
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            .build();  
                assertEquals(Decision.Type.NO, decision.type());  
            .stream()
        // zone a has two nodes, zone c has one, and the excluded zone b has one
        );
            // Try to allocate unassigned shard to A-0, fails because of forced zone awareness  
            logger.info("--> complete initializing round: [{}]", i);
        logger.info("--> all replicas are allocated and started since we have on node in each zone");
        final AllocationService strategy = createAllocationService(settings);
                settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));  
        logger.info("Initializing shards: {}", clusterState.getRoutingNodes().shardsWithState(INITIALIZING));  
            .nodes(
            .metadata(metadata)
    }
            clusterState.getRoutingNodes(),  
        // exclude a single node in zone a by id; zone a still has a non-excluded node, so zone a must keep counting
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        for (RoutingNode node : clusterState.getRoutingNodes()) {  
            .build();
}
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3", singletonMap("rack_id", "2"))))
        Metadata metadata = Metadata.builder()
            strategy
        );  
    public void testMoveShardOnceNewNodeWithAttributeAdded5() {
        logger.info("--> do another reroute, make sure nothing moves");
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        logger.info("--> do another reroute, make sure nothing moves");  
        logger.info("--> complete relocation");  
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(2));  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(3));  
            .build();
        clusterState = ClusterState.builder(clusterState)
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
                .put("cluster.routing.allocation.awareness.attributes", "zone")  
                .put("cluster.routing.allocation.awareness.attributes", "rack_id")
            equalTo("node4")
        logger.info("--> add a new node with a new rack and reroute");
                .put("cluster.routing.allocation.balance.replica", 1.0f)
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("C-0", singletonMap("zone", "c"))))
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")  
        clusterState = strategy.reroute(clusterState, "reroute");
        assertEquals(commandsResult.explanations().explanations().get(0).decisions().type(), Decision.Type.YES);
            null,  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(), equalTo("A-1"));
        logger.info("--> add a new node with a new rack and reroute");
        Metadata metadata = Metadata.builder()
                    .add(newNode("A-2", singletonMap("zone", "a")))
            Settings.builder()
        for (RoutingNode node : nodes) {
                .put("cluster.routing.allocation.balance.index", 0.0f)  
                .build(),  
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(20));
            Settings.builder()
        logger.info("--> start the shards (primaries)");  
                .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
        final Metadata metadata = Metadata.builder()  
        logger.info("--> start the shard (primary)");
        clusterState = ClusterState.builder(clusterState)  
                .metadata(metadata)
        clusterState = ClusterState.builder(clusterState)
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
        final FilterAllocationDecider filterDecider = new FilterAllocationDecider(settings, clusterSettings);
        );
            .put("cluster.routing.allocation.exclude.zone", "b")
        final AwarenessAllocationDecider awarenessDecider = new AwarenessAllocationDecider(settings, clusterSettings);  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));  
            .metadata(metadata)  
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));  
                    .add(newNode("node2", singletonMap("rack_id", "1")))
            .add(newNode("b3", singletonMap("zone", "b")))
            clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).get(0).relocatingNodeId(),
import java.util.List;
            .build();
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node5", singletonMap("rack_id", "3"))))  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(3));  
                .put("cluster.routing.allocation.awareness.attributes", "rack_id")  
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(5));
            .build();
            .nodes(  
            .build();  
            clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).get(0).relocatingNodeId(),  
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
        RoutingTable initialRoutingTable = RoutingTable.builder()  
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4", singletonMap("rack_id", "3"))))
        assertThat(
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(20));
 * not use this file except in compliance with the License.
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(20));  
    }
        clusterState = ClusterState.builder(clusterState)
        clusterState = ClusterState.builder(clusterState)
                    .add(newNode("A-1", singletonMap("zone", "a")))
        Metadata metadata = Metadata.builder()
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            "allocation awareness is not enabled, set cluster setting " + "[cluster.routing.allocation.awareness.attributes] to enable it",
        final Metadata metadata = Metadata.builder()
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(3))  
            assertEquals(Decision.Type.YES, awarenessDecider.canAllocate(primary, node, allocation).type());
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(), equalTo("node4"));
        logger.info("--> adding two nodes on same rack and do rerouting");
            .routingTable(initialRoutingTable)
            .build();  
    }
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
        clusterState = ClusterState.builder(clusterState)
                .put("cluster.routing.allocation.awareness.attributes", "zone")
        // Add a new node in zone c  
            .build();
                    .add(newNode("node2", singletonMap("rack_id", "1")))
        final Settings settings = Settings.builder()
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(1));
        clusterState = strategy.reroute(clusterState, "reroute");
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")  
        clusterState = strategy.reroute(clusterState, "reroute");
                .put("cluster.routing.allocation.awareness.attributes", "rack_id")  
            Settings.builder()  
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
        );
        );  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(10));
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3", singletonMap("rack_id", "2"))))
        assertThat(routingNodes.shardsWithState(STARTED).size(), equalTo(3));
        clusterState = strategy.reroute(clusterState, "reroute");  
    }  
        clusterState = strategy.reroute(clusterState, commands, false, false).getClusterState();  
        logger.info("--> add another node with a new rack, we will have another relocation");
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(10));
            .metadata(metadata)
            strategy  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(
                .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
        logger.info("Building initial routing table for 'moveShardOnceNewNodeWithAttributeAdded1'");
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(10));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            new AllocationDeciders(Collections.singleton(decider)),
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
            equalTo("node3")
        assertThat(clusterState.getRoutingNodes().shardsWithState(RELOCATING).size(), equalTo(1));  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(1));  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
            .add(newNode("a1", singletonMap("zone", "a")))
        clusterState = strategy.reroute(clusterState, "reroute");  
    }  
        ClusterState newState = strategy.reroute(clusterState, "reroute");
        logger.info("--> do another reroute, make sure nothing moves");  
            .build();
                DiscoveryNodes.builder()
        logger.info("--> do another reroute, make sure nothing moves");
        logger.info("--> try to move the replica to new node");
            )
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
            logger.info("--> complete initializing round: [{}]", i);  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
        final RoutingNodes routingNodes = clusterState.getRoutingNodes();
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(clusterState.getRoutingNodes().node("A-1").size(), equalTo(2));
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node6", singletonMap("rack_id", "3"))))  
                .nodes(nodes)
 * GitHub history for details.
    public void testZoneStillCountedWhenOnlySomeOfItsNodesExcluded() {  
            .build();  
            clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).get(0).relocatingNodeId(),  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(5));
                .build()  
            .add(newNode("B-0", singletonMap("zone", "b")))  
                    .add(newNode("A-4", singletonMap("zone", "a")))
        clusterState = strategy.reroute(clusterState, "reroute");  
                .build()
            .routingTable(initialRoutingTable)  
        final DiscoveryNodes nodes = DiscoveryNodes.builder()
            .build();
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3", singletonMap("rack_id", "2"))))  
        assertThat(routingNodes.node("c1").size(), equalTo(1));
                .put("cluster.routing.allocation.awareness.attributes", "rack_id")
            )
 * the Apache License, Version 2.0 (the "License"); you may
        logger.info("--> do another reroute, make sure nothing moves");
        assertThat(routingNodes.node("a2").size(), equalTo(1));  
            .add(newNode("A-2", singletonMap("zone", "a")))
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))
        logger.info("--> start the shards (primaries)");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        logger.info("Building initial routing table for 'fullAwareness1'");  
import java.util.Map;  
        logger.info("Building initial routing table for 'moveShardOnceNewNodeWithAttributeAdded5'");  
    public void testAllZonesCountedWhenNothingExcluded() {
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
            .build();
            .toList();  
        Settings settings = Settings.builder()  
            .add(newNode("a2", singletonMap("zone", "a")))
        List<Decision> decisions = commandsResult.explanations()
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        logger.info("--> start the shard (primary)");  
            .build();  
        );  
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.get(Settings.EMPTY))  
        );
        logger.info("--> add a a nodes without zone and reroute");
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
 *
    public void testMoveShardOnceNewNodeWithAttributeAdded1() {  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
            .build();  
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
            .add(newNode("a2", singletonMap("zone", "a")))
        logger.info("--> complete relocation");
            )
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
        Metadata metadata = Metadata.builder()
    public void testExcludedZoneIsIgnoredInAwarenessCount() {  
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
            false  
        logger.info("--> Building initial routing table");
            .build();  
        ClusterSettings EMPTY_CLUSTER_SETTINGS = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(), equalTo("node3"));
            .build();  
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
            0L
import org.opensearch.common.settings.ClusterSettings;  
            .filter(item -> item.getExplanation().startsWith("allocation awareness is not enabled"))
            .nodes(  
        AllocationService strategy = createAllocationService(
                .put("cluster.routing.allocation.balance.replica", 1.0f)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(5));
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(0));  
                    .add(newNode("node2", singletonMap("rack_id", "1")))  
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
/*  
                commands.add(new CancelAllocationCommand(routing.shardId().getIndexName(), routing.id(), routing.currentNodeId(), false));
        }  
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3", singletonMap("rack_id", "2"))))
        logger.info("--> start the shards (primaries)");  
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)  
                    .add(newNode("node1", singletonMap("rack_id", "1")))
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")  
        clusterState = strategy.reroute(clusterState, "reroute");
            Settings.builder()  
        logger.info("Building initial routing table for 'testUnassignedShardsWithUnbalancedZones'");
        final AllocationService strategy = createAllocationService(settings);
        clusterState = ClusterState.builder(clusterState)  
        AllocationService strategy = createAllocationService(  
            .build();
    public void testMoveShardOnceNewNodeWithAttributeAdded6() {
    }  
        logger.info("Relocating shards: {}", clusterState.getRoutingNodes().shardsWithState(RELOCATING));
            .persistentSettings(settings)
            .build();
        logger.info("--> make sure another reroute does not move things");  
 * this work for additional information regarding copyright
            .metadata(metadata)  
                );
        logger.info("--> complete initializing");
            .put("cluster.routing.allocation.exclude.zone", "a,b")  
            }
        logger.info("Started shards: {}", clusterState.getRoutingNodes().shardsWithState(STARTED));
            .build();  
        commands.add(new MoveAllocationCommand("test", 0, primaryNode, "A-4"));
                .put("cluster.routing.allocation.awareness.force.rack_id.values", "1,2")
        clusterState = ClusterState.builder(clusterState)
        final Metadata metadata = Metadata.builder()
        logger.info("--> do another reroute, make sure nothing moves");  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(3));  
import org.opensearch.cluster.metadata.IndexMetadata;
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));  
        clusterState = ClusterState.builder(clusterState)  
        AllocationService strategy = createAllocationService(
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
            .decisions()
        AllocationService strategy = createAllocationService(  
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4", singletonMap("rack_id", "3"))))  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .build();  
            .build();
        );
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        clusterState = ClusterState.builder(clusterState)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(10));  
        AllocationService strategy = createAllocationService(  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        logger.info("--> adding two nodes in different zones and do rerouting");
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        logger.info("--> add a new node with a new rack and reroute");  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
                .build()  
import org.opensearch.common.settings.Settings;
        logger.info("--> complete relocation");
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
            .build();
import java.util.HashMap;
                    .add(newNode("A-3", singletonMap("zone", "a")))  
        clusterState = ClusterState.builder(clusterState)  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(10));
 * under the License.  
            .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")  
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)  
            } else if (routing.initializing()) {  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            );
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));  
 * KIND, either express or implied.  See the License for the
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(1));
        );  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(1));
        );
            .build();
                .put("cluster.routing.allocation.balance.index", 0.0f)
        logger.info("--> start the shards (replicas)");
                .put("cluster.routing.allocation.awareness.attributes", "rack_id")
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        logger.info("--> adding 3 nodes in different zones and do rerouting");
            .build();
                .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a, b")  
        assertThat(routingNodes.node("a1").size(), equalTo(1));
        logger.info("--> adding two nodes on same rack and do rerouting");
    public void testAllocationAwarenessWhenNotEnabled() {
import static java.util.Collections.singletonMap;
                .build(),
 */  
        final AwarenessAllocationDecider decider = new AwarenessAllocationDecider(settings, EMPTY_CLUSTER_SETTINGS);
            .build();  
            .build();  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(0));
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(10));
            )  
import org.opensearch.cluster.routing.ShardRouting;
 * Licensed to Elasticsearch under one or more contributor  
        clusterState = ClusterState.builder(clusterState)
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        clusterState = ClusterState.builder(clusterState)  
            .metadata(metadata)  
        final Settings settings = Settings.builder()
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
            .metadata(metadata)  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(10));  
 * this file be licensed under the Apache-2.0 license or a
    }
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
        );
    }
import org.opensearch.cluster.routing.allocation.decider.FilterAllocationDecider;
                .build()  
        );
                    .add(newNode("node2", singletonMap("rack_id", "1")))  
        Metadata metadata = Metadata.builder()  
                assertEquals(
            .build();
import org.opensearch.cluster.routing.RoutingTable;  
        assertThat(routingNodes.node("a1").size(), equalTo(0));  
            .build();
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).get(0).relocatingNodeId(),
        logger.info("--> all replicas are allocated and started since we have one node in each zone and rack");  
                    .add(newNode("node2", singletonMap("rack_id", "1")))
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(3));
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
                    .add(newNode("node3", singletonMap("rack_id", "1")))
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
                .metadata(metadata)  
        logger.info("--> add another node with a new rack, some more relocation should happen");
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));  
        // Cancel all initializing shards and move started primary to another node.  
            .build();  
        assertThat(clusterState.getRoutingNodes().shardsWithState(RELOCATING).size(), greaterThan(0));  
        assertThat(clusterState.getRoutingNodes().node("B-0").size(), equalTo(5));  
        logger.info("--> start the shards (replicas)");  
                .put("cluster.routing.allocation.balance.primary", 0.0f)  
        assertThat(clusterState.getRoutingNodes().shardsWithState(RELOCATING).size(), greaterThan(0));
            clusterState,  
                    .add(newNode("node1", singletonMap("rack_id", "1")))
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
                    "there are too many copies of the shard allocated to nodes with attribute"  
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = strategy.reroute(clusterState, "reroute");  
        logger.info("Building initial routing table for 'testUnbalancedZones'");  
        clusterState = ClusterState.builder(clusterState)
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(0));  
        final RoutingNodes routingNodes = clusterState.getRoutingNodes();  
                        + " be less than or equal to the upper bound of the required number of shards per attribute [1]"  
            .build();
    public void testMoveShardOnceNewNodeWithAttributeAdded3() {
            strategy
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        logger.info("--> adding two nodes on same rack and do rerouting");
                .build()
import org.opensearch.cluster.routing.RoutingNode;
                    .add(newNode("B-0", singletonMap("zone", "b")))
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(0));
            .build();
            .nodes(DiscoveryNodes.builder().add(newNode("A-0", nodeAAttributes)).add(newNode("B-0", nodeBAttributes)))  
            .build();  
            decisions.get(0).getExplanation()  
import org.opensearch.cluster.routing.RoutingNodes;
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        logger.info("Building initial routing table for 'moveShardOnceNewNodeWithAttributeAdded6'");  
            .build();
                    .add(newNode("A-0", singletonMap("zone", "a")))  
                    .add(newNode("B-0", singletonMap("zone", "b")))
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            equalTo("node5")
        ClusterState newState = strategy.reroute(clusterState, "reroute");
            .routingTable(initialRoutingTable)
                .put("cluster.routing.allocation.concurrent_recoveries", 10)  
        assertThat(routingNodes.shardsWithState(STARTED).size(), equalTo(3));
/*
            equalTo("node6")
        assertThat(clusterState.getRoutingNodes().shardsWithState(RELOCATING).size(), greaterThan(0));  
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node5", singletonMap("rack_id", "2"))))  
        String primaryNode = null;
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4", singletonMap("rack_id", "3"))))
        Metadata metadata = Metadata.builder()
                .put("cluster.routing.allocation.awareness.force.rack_id.values", "1,2")
import org.opensearch.cluster.routing.ShardRoutingState;
        for (int i = 0; i < 2; i++) {
            .routingTable(initialRoutingTable)
        // The three copies spread one per zone: zone a receives a single copy (not two), and zone b is used.  
        final DiscoveryNodes nodes = DiscoveryNodes.builder()  
        clusterState = ClusterState.builder(clusterState)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        logger.info("--> add another node with a new rack, we will have another relocation");
        // Because every node in zone b is excluded, awareness counts only zones {a, c}, so the per-zone cap is
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
        // same topology as the excluded-zone test but with no exclude filter: all three zones must still count
            .build();
            .nodes(  
        clusterState = strategy.reroute(clusterState, "reroute");
    public void testMoveShardOnceNewNodeWithAttributeAdded2() {  
        logger.info("--> complete relocation");
        nodeBAttributes.put("rack", "d");
        clusterState = ClusterState.builder(clusterState)
public class AwarenessAllocationTests extends OpenSearchAllocationTestCase {
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
        logger.info("--> add a new node with a new rack and reroute");
        logger.info("--> start the shards (primaries)");  
        clusterState = ClusterState.builder(clusterState)
            clusterState,
            .build();  
            )
        final Settings settings = Settings.builder()
            .build();
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
                DiscoveryNodes.builder()
        logger.info("--> starting initializing shards on the new node");
        assertThat(
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
import org.apache.logging.log4j.Logger;
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
            .add(newNode("a1", singletonMap("zone", "a")))
/*  
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node5", singletonMap("rack_id", "3"))))
            Settings.builder()
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(), equalTo("node3"));  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
            .build();  
        clusterState = ClusterState.builder(clusterState)
        );  
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        );
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .nodes(
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)  
        logger.info("--> complete initializing");
        logger.info("Building initial routing table for 'moveShardOnceNewNodeWithAttributeAdded4'");
 */
        assertThat(  
                .build(),
        logger.info("--> start the shards (primaries)");  
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(20));
import org.opensearch.cluster.ClusterName;
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(5));
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)  
            .add(newNode("c1", singletonMap("zone", "c")))
        assertThat(routingNodes.node("b1").size(), equalTo(1));
            clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).get(0).relocatingNodeId(),
        clusterState = strategy.reroute(clusterState, "reroute");
                    .add(newNode("node2", singletonMap("rack_id", "1")))  
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)
import org.opensearch.cluster.node.DiscoveryNodes;  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        AllocationService strategy = createAllocationService(
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));  
                decision = decider.canAllocate(unassignedShards.get(0), node, allocation);
            .build();  
        Metadata metadata = Metadata.builder()
        assertThat(routingNodes.node("c1").size(), equalTo(1));  
            .nodes(
        clusterState = ClusterState.builder(clusterState)
        );
            .add(newNode("a1", singletonMap("zone", "a")))
                .put("cluster.routing.allocation.balance.primary", 0.0f)
        AllocationCommands commands = new AllocationCommands();
            .routingTable(initialRoutingTable)  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))  
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
                    .add(newNode("node4", singletonMap("rack_id", "1")))
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))  
                    .add(newNode("node1", singletonMap("rack_id", "1")))
        logger.info("--> run it again, since we still might have relocation");
                .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "rack.values", "c, d")
        Map<String, String> nodeAAttributes = new HashMap<>();
        Metadata metadata = Metadata.builder()
            .build();
        }
        assertThat(routingNodes.node("b1").size(), equalTo(0));
import org.opensearch.cluster.ClusterState;
                .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));  
        }
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(3));
        logger.info("--> start the shards (replicas)");  
            .build();
        allocation.debugDecision(true);  
                DiscoveryNodes.builder()
        // ceil(4/2) = 2. Only a2 is usable in zone a (1 copy) and zone b is capped at 2, so a fourth copy cannot be  
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
            assertEquals(Decision.Type.NO, filterDecider.canAllocate(primary, node, allocation).type());
            .build();  
            .build();
        logger.info("--> do another reroute, make sure nothing moves");
            .build();  
            .add(newNode("A-1", singletonMap("zone", "a")))
            .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        logger.info("Building initial routing table for 'moveShardOnceNewNodeWithAttributeAdded3'");
            .nodes(  
            Settings.builder()
        clusterState = strategy.reroute(clusterState, "reroute");
        logger.info("--> complete relocation");
        );
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            .nodes(
        clusterState = strategy.reroute(clusterState, "reroute");
        logger.info("Building initial routing table for 'moveShardOnceNewNodeWithAttributeAdded2'");
                .put("cluster.routing.allocation.awareness.attributes", "rack_id")
            .nodes(  
 * compatible open source license.
        clusterState = ClusterState.builder(clusterState)
        // zone awareness is enabled and zone "b" is fully excluded from allocation via the cluster exclude filter
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
        logger.info("--> start the shards (primaries)");
        clusterState = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(10));  
            null,
        clusterState = ClusterState.builder(clusterState)  
        logger.info("--> complete relocation");
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(5));
        nodeBAttributes.put("zone", "b");  
                    .add(newNode("A-1", singletonMap("zone", "a")))  
import org.opensearch.cluster.routing.allocation.command.CancelAllocationCommand;
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3", singletonMap("rack_id", "2"))))
        logger.info("--> add a new node with a new rack and reroute");  
            .metadata(metadata)
        assertEquals(
        logger.info("--> add another node with a new rack, make sure nothing moves");  
        clusterState = strategy.reroute(clusterState, "reroute");  
        logger.info("--> start the shards (replicas)");  
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
            .nodes(DiscoveryNodes.builder().add(newNode("A-0", singletonMap("zone", "a"))).add(newNode("B-0", singletonMap("zone", "b"))))
        logger.info("--> complete relocation");
 * The OpenSearch Contributors require contributions made to  
        assertThat(newState, equalTo(clusterState));
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
                    .add(newNode("node1", singletonMap("rack_id", "1")))  
        assertThat(  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
            .build();  
        final AllocationService strategy = createAllocationService(settings);
        );
                DiscoveryNodes.builder().add(newNode("node1", singletonMap("zone", "a"))).add(newNode("node2", singletonMap("zone", "a")))  
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(5));
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
    public void testMoveShardOnceNewNodeWithAttributeAdded4() {
        ClusterState newState = strategy.reroute(clusterState, "reroute");  
            .build();  
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
        clusterState = ClusterState.builder(clusterState)  
        clusterState = ClusterState.builder(clusterState)
            new AllocationDeciders(List.of(awarenessDecider, filterDecider)),  
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)  
            equalTo("node3")
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
            .nodes(
        assertThat(routingNodes.shardsWithState(STARTED).size(), equalTo(3));
        );
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
            .build();
            null,  
    public void testFullAwareness3() {
        clusterState = ClusterState.builder(clusterState)
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(5));  
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .build();  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
            .build();
            .nodes(  
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4", singletonMap("rack_id", "3"))))
        logger.info("--> add a new node in zone 'a' and reroute");  
                    .add(newNode("node1", singletonMap("rack_id", "1")))  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .build();
        logger.info("--> adding 5 nodes in different zones and do rerouting");
            .build();
                .nodes(nodes)
    }
        logger.info("Building initial routing table for 'testUnbalancedZones'");
        logger.info("Unassigned shards: {}", clusterState.getRoutingNodes().shardsWithState(UNASSIGNED));  
        );
                    .add(newNode("node2", singletonMap("rack_id", "1")))
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(5));
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
        AllocationService strategy = createAllocationService(
        logger.info("--> replica will not start because we have only one rack value");  
            .build();
                .metadata(metadata)
        logger.info("--> adding two nodes on same rack and do rerouting");
                    .add(newNode("node2", singletonMap("rack_id", "1")))  
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4", singletonMap("rack_id", "3"))))  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(routingNodes.shardsWithState(UNASSIGNED).size(), equalTo(0));  
    }  
        clusterState = ClusterState.builder(clusterState)
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
            .routingTable(initialRoutingTable)
        RoutingNodes nodes = clusterState.getRoutingNodes();  
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
    public void testFullAwareness1() {
        logger.info("--> run it again, since we still might have relocation");
        final Settings settings = Settings.builder()  
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")  
        for (ShardRouting routing : clusterState.routingTable().allShards()) {  
        assertThat(clusterState.getRoutingNodes().node("A-0").size(), equalTo(3));
        final ClusterState clusterState = applyStartedShardsUntilNoChange(  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
    public void testIgnoredByAutoExpandReplicasToAll() {
            .metadata(metadata)
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
        clusterState = strategy.reroute(clusterState, "reroute");
 * ownership. Elasticsearch licenses this file to you under  
            .addAsNew(metadata.index("test2"))  
        final Metadata metadata = Metadata.builder()  
        ClusterState newState = strategy.reroute(clusterState, "reroute");
    }  
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
        nodeAAttributes.put("zone", "a");  
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")  
        AllocationService strategy = createAllocationService(
            )
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 100)
        logger.info("Building initial routing table for 'fullAwareness2'");  
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;  
import org.opensearch.cluster.metadata.Metadata;
        clusterState = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
        logger.info("--> start the shards (primaries)");
        logger.info("--> add a new node with a new rack and reroute");  
            .metadata(metadata)
 *  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(10));
                .put("cluster.routing.allocation.awareness.attributes", "rack_id")
        RoutingTable initialRoutingTable = RoutingTable.builder()
            )
