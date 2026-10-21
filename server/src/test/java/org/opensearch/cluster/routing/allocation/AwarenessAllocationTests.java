                assertEquals(
            clusterState,
                assertEquals(Decision.Type.NO, decision.type());
        );
        AllocationService strategy = createAllocationService(
        // 1 primary + 3 replicas = 4 copies of the shard
        clusterState = ClusterState.builder(clusterState)
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
            .build();
            .filter(item -> item.getExplanation().startsWith("allocation awareness is not enabled"))
                    .add(newNode("node2", singletonMap("rack_id", "1")))
        // One Shard is unassigned due to forced zone awareness
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
        clusterState = ClusterState.builder(clusterState)
                        + " be less than or equal to the upper bound of the required number of shards per attribute [1]"
import java.util.List;
                .build()
            .nodes(DiscoveryNodes.builder().add(newNode("A-0", nodeAAttributes)).add(newNode("B-0", nodeBAttributes)))
    }
        logger.info("--> start the shard (primary)");
            .nodes(
        logger.info("--> complete relocation");
 *
import org.opensearch.cluster.metadata.Metadata;
            clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).get(0).relocatingNodeId(),
        );
        clusterState = strategy.reroute(clusterState, "reroute");
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
                .build()
            .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        logger.info("--> start the shards (replicas)");
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
        assertThat(routingNodes.node("a1").size(), equalTo(0));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(4)); // +1 for relocating shard.
            .metadata(metadata)
        logger.info("Building initial routing table for 'fullAwareness2'");
            .build();
            .put("cluster.routing.allocation.exclude._id", "a1")
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(1));
        logger.info("--> complete relocation");
    public void testMoveShardOnceNewNodeWithAttributeAdded2() {
        logger.info("--> all replicas are allocated and started since we have on node in each zone");
        Metadata metadata = Metadata.builder()
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4", singletonMap("rack_id", "3"))))
        for (int i = 0; i < 2; i++) {
        for (RoutingNode node : nodes) {
            .build();
            .add(newNode("A-2", singletonMap("zone", "a")))
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(5));
        final FilterAllocationDecider filterDecider = new FilterAllocationDecider(settings, clusterSettings);
                    .add(newNode("node1", singletonMap("rack_id", "1")))
                    .add(newNode("A-4", singletonMap("zone", "a")))
 * under the License.
                    .add(newNode("node3", singletonMap("rack_id", "1")))
            .add(newNode("b2", singletonMap("zone", "b")))
                        + " total attribute values, expected the allocated shard count per attribute [2] to"
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
                .put("cluster.routing.allocation.awareness.attributes", "rack_id")
        Metadata metadata = Metadata.builder()
        AllocationService.CommandsResult commandsResult = strategy.reroute(
            // Try to allocate unassigned shard to A-0, fails because of forced zone awareness
                .put("cluster.routing.allocation.awareness.attributes", "rack_id")
            .build();
            if (node.nodeId().equals("A-0")) {
        clusterState = ClusterState.builder(clusterState)
    }
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(10));
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(routingNodes.node("c1").size(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(10));
                .build()
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
        assertThat(
    public void testZoneStillCountedWhenOnlySomeOfItsNodesExcluded() {
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(), equalTo("A-1"));
                .put("cluster.routing.allocation.awareness.attributes", "zone")
        logger.info("--> adding two nodes on same rack and do rerouting");
            .build();
        Metadata metadata = Metadata.builder()
                .build()
            .add(newNode("a1", singletonMap("zone", "a")))
        clusterState = strategy.reroute(clusterState, "reroute");
            .metadata(metadata)
        final Settings settings = Settings.builder()
        logger.info("--> start the shards (primaries)");
            );
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(1));
        AllocationService strategy = createAllocationService(
        );
                    .add(newNode("node1", singletonMap("rack_id", "1")))
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.get(Settings.EMPTY))
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(3));
            )
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        clusterState = ClusterState.builder(clusterState)
            .build();
                decision = decider.canAllocate(unassignedShards.get(0), node, allocation);
            .routingTable(initialRoutingTable)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .nodes(
        );
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(10));
        clusterState = ClusterState.builder(clusterState)
 * specific language governing permissions and limitations
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
 * this work for additional information regarding copyright
                    .add(newNode("node2", singletonMap("rack_id", "1")))
            .metadata(metadata)
            .build();
            0L
        clusterState = strategy.reroute(clusterState, "reroute");
            .build();
        logger.info("--> start the shards (replicas)");
        clusterState = strategy.reroute(clusterState, "reroute");
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(1));
            .build();
        logger.info("Building initial routing table for 'moveShardOnceNewNodeWithAttributeAdded3'");
        Metadata metadata = Metadata.builder()
        logger.info("--> do another reroute, make sure nothing moves");
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        assertThat(routingNodes.node("a1").size() + routingNodes.node("a2").size(), equalTo(1));
        logger.info("--> adding two nodes on same rack and do rerouting");
        // With nothing excluded, awareness counts all three zones {a, b, c}, so the per-zone cap is ceil(3/3) = 1.
            .addAsNew(metadata.index("test1"))
            .nodes(DiscoveryNodes.builder().add(newNode("A-0", singletonMap("zone", "a"))).add(newNode("B-0", singletonMap("zone", "b"))))
                    .add(newNode("node2", singletonMap("rack_id", "1")))
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(3));
        );
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
            .add(newNode("a1", singletonMap("zone", "a")))
    }
        logger.info("--> adding two nodes on same zone and do rerouting");
        logger.info("--> add another node with a new rack, some more relocation should happen");
        logger.info("Building initial routing table for 'testAllocationExplainForUnassignedShardsWithUnbalancedZones'");
        final DiscoveryNodes nodes = DiscoveryNodes.builder()
        logger.info("--> start the shards (primaries)");
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
        clusterState = ClusterState.builder(clusterState)
        );
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            strategy
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(1));
        assertThat(
import org.opensearch.cluster.ClusterState;
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        AllocationService strategy = createAllocationService(
        }
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(1)); // Unassigned shard is expected.
 * ownership. Elasticsearch licenses this file to you under
 * Unless required by applicable law or agreed to in writing,
    }
    private final Logger logger = LogManager.getLogger(AwarenessAllocationTests.class);
                .put("cluster.routing.allocation.awareness.force.rack_id.values", "1,2")
        logger.info("Building initial routing table for 'testUnbalancedZones'");
        assertThat(newState, equalTo(clusterState));
        for (RoutingNode node : clusterState.getRoutingNodes()) {
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .build();
            .build();
        final RoutingAllocation allocation = new RoutingAllocation(
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
                    .put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-all")
        logger.info("Building initial routing table for 'testUnbalancedZones'");
            .routingTable(initialRoutingTable)
        ClusterSettings EMPTY_CLUSTER_SETTINGS = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .add(newNode("A-1", singletonMap("zone", "a")))
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(5));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        // zone awareness is enabled and zone "b" is fully excluded from allocation via the cluster exclude filter
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.get(Settings.EMPTY))
        // four copies would fit, so this asserts we drop a value only when every one of its nodes is excluded.
            .stream()
        nodeAAttributes.put("rack", "c");
        assertThat(clusterState.getRoutingNodes().node("A-0").size(), equalTo(3));
            .metadata(metadata)
    }
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
                .build()
        logger.info("--> add another node with a new rack, make sure nothing moves");
                    .add(newNode("A-1", singletonMap("zone", "a")))
            decisions.get(0).getExplanation()
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(10));
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
                .put("cluster.routing.allocation.awareness.attributes", "rack_id")
        final ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.get(Settings.EMPTY))
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .metadata(metadata)
        );
        clusterState = strategy.reroute(clusterState, "reroute");
 * license agreements. See the NOTICE file distributed with
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            new AllocationDeciders(Collections.singleton(decider)),
        logger.info("Relocating shards: {}", clusterState.getRoutingNodes().shardsWithState(RELOCATING));
                    "there are too many copies of the shard allocated to nodes with attribute"
        clusterState = strategy.reroute(clusterState, commands, false, false).getClusterState();
 *
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            .build();
            .build();
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        logger.info("--> do another reroute, make sure nothing moves");
        clusterState = ClusterState.builder(clusterState)
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
        logger.info("--> replica will not start because we have only one rack value");
            .addAsNew(metadata.index("test2"))
        );
        logger.info("--> adding two nodes on same rack and do rerouting");
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        RoutingNodes nodes = clusterState.getRoutingNodes();
 * SPDX-License-Identifier: Apache-2.0
            .nodes(
import static org.hamcrest.Matchers.equalTo;
            clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).get(0).relocatingNodeId(),
            .addAsNew(metadata.index("test1"))
        clusterState = ClusterState.builder(clusterState)
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(20));
        Metadata metadata = Metadata.builder()
        logger.info("--> add a new node with a new rack and reroute");
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
 * compatible open source license.
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            .add(newNode("a2", singletonMap("zone", "a")))
                .put("cluster.routing.allocation.awareness.attributes", "rack_id")
        clusterState = ClusterState.builder(clusterState)
        clusterState = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
 * not use this file except in compliance with the License.
        );
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .nodes(
            new AllocationCommands(new MoveAllocationCommand("test", 0, "node2", "node3")),
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(1));
            .build();
        // zone a has two nodes, zone c has one, and the excluded zone b has one
        );
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3", singletonMap("rack_id", "2"))))
    }
            .build();
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
        );
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
 */
            .build();
            .build();
                    .add(newNode("B-0", singletonMap("zone", "b")))
        clusterState = strategy.reroute(clusterState, "reroute");
        AllocationService strategy = createAllocationService(
                .build()
            .build();
        Metadata metadata = Metadata.builder()
            .build();
            .add(newNode("a2", singletonMap("zone", "a")))
        allocation.debugDecision(true);
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(3));
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 100)
        clusterState = strategy.reroute(clusterState, "reroute");
                    .add(newNode("A-0", singletonMap("zone", "a")))
                .metadata(metadata)
        clusterState = ClusterState.builder(clusterState)
                .put("cluster.routing.allocation.awareness.force.zone.values", "a,b")
            )
    public void testAllZonesCountedWhenNothingExcluded() {
        String primaryNode = null;
                .build(),
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(0));
        logger.info("--> do another reroute, make sure nothing moves");
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        final RoutingNodes routingNodes = clusterState.getRoutingNodes();
    public void testAllocationAwarenessWhenNotEnabled() {
                    .add(newNode("node3", singletonMap("rack_id", "1")))
            null,
            .routingTable(initialRoutingTable)
            .put("cluster.routing.allocation.exclude.zone", "b")
import org.opensearch.cluster.routing.ShardRoutingState;
        clusterState = ClusterState.builder(clusterState)
            )
            .build();
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
        logger.info("--> start the shards (primaries)");
            .build();
        clusterState = ClusterState.builder(clusterState)
            .build();
            .build();
        clusterState = strategy.reroute(clusterState, "reroute");
                settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                        + " [zone], there are [3] total configured shard copies for this shard id and [3]"
        Metadata metadata = Metadata.builder()
        clusterState = ClusterState.builder(clusterState)
            .build();
            .persistentSettings(settings)
            .build();
import org.opensearch.cluster.routing.allocation.decider.Decision;
        );
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(4));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(5));
    public void testIgnoredByAutoExpandReplicasToAll() {
        clusterState = strategy.reroute(clusterState, "reroute");
            )
import org.opensearch.cluster.metadata.IndexMetadata;
    }
            .build();
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(3));
        logger.info("--> complete relocation");
 * this file be licensed under the Apache-2.0 license or a
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
        clusterState = strategy.reroute(clusterState, "reroute");
            Settings.builder()
                    .add(newNode("node4", singletonMap("rack_id", "1")))
            equalTo("node3")
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        logger.info("Initializing shards: {}", clusterState.getRoutingNodes().shardsWithState(INITIALIZING));
import static org.hamcrest.Matchers.sameInstance;
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
            logger.info("--> complete initializing round: [{}]", i);
        Metadata metadata = Metadata.builder()
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        logger.info("--> complete initializing");
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
            Settings.builder()
        // exclude a single node in zone a by id; zone a still has a non-excluded node, so zone a must keep counting
        final Metadata metadata = Metadata.builder()
        assertThat(clusterState.getRoutingNodes().shardsWithState(RELOCATING).size(), greaterThan(0));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            Settings.builder()
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        logger.info("--> do another reroute, make sure nothing moves");
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(5));
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
                .metadata(metadata)
import org.opensearch.common.settings.Settings;
        assertThat(routingNodes.node("c1").size(), equalTo(1));
            .metadata(metadata)
                .put("cluster.routing.allocation.awareness.attributes", "rack_id")
            .build();
    }
        assertEquals(commandsResult.explanations().explanations().get(0).decisions().type(), Decision.Type.YES);
        // ceil(3/2) = 2. All three copies allocate onto the two remaining zones and nothing is left unassigned.
        AllocationCommands commands = new AllocationCommands();
    public void testExcludedZoneIsIgnoredInAwarenessCount() {
            .build();
            )
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(3));
            .add(newNode("a1", singletonMap("zone", "a")))
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
    public void testMoveShardOnceNewNodeWithAttributeAdded4() {
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(10));
    }
        ClusterState newState = strategy.reroute(clusterState, "reroute");
            .put("cluster.routing.allocation.exclude.zone", "a,b")
        final Settings settings = Settings.builder()
            // with zero attribute values left, awareness must not veto (and must not divide by zero) ...
        logger.info("--> complete relocation");
        assertThat(newState, equalTo(clusterState));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            equalTo("node3")
            true,
        logger.info("--> add a new node with a new rack and reroute");
        clusterState = ClusterState.builder(clusterState)
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
            .get(0)
            clusterState,
        }
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(0));
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
                .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
            Settings.builder()
                primaryNode = routing.currentNodeId();
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
            .build();
        clusterState = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.getRoutingNodes().node("node4").size(), equalTo(5));
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
        logger.info("--> adding two nodes on same rack and do rerouting");
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            .build();
        clusterState = strategy.reroute(clusterState, "reroute");
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))
                .build()
            )
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(10));
            .build();
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
}
 * GitHub history for details.
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
    public void testAwarenessDoesNotVetoWhenEveryZoneIsExcluded() {
            .add(newNode("a2", singletonMap("zone", "a")))
            .put("cluster.routing.allocation.awareness.force.zone.values", "a,b,c")
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(10));
        // every node in every zone is excluded, so no awareness attribute values remain to balance across
            )
        }
        logger.info("--> start the shards (replicas)");
import static org.hamcrest.Matchers.greaterThan;
            assertEquals(Decision.Type.NO, filterDecider.canAllocate(primary, node, allocation).type());
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node5", singletonMap("rack_id", "3"))))
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        final DiscoveryNodes nodes = DiscoveryNodes.builder()
        logger.info("--> make sure another reroute does not move things");
        // placed and stays UNASSIGNED. If zone a had been wrongly dropped, the cap would be ceil(4/1) = 4 and all
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                .nodes(nodes)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                    .add(newNode("node1", singletonMap("rack_id", "1")))
        clusterState = strategy.reroute(clusterState, "reroute");
            .routingTable(initialRoutingTable)
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
            .add(newNode("B-0", singletonMap("zone", "b")))
            }
            .build();
        logger.info("--> complete relocation");
        logger.info("--> complete initializing");
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            null,
            Settings.builder()
        logger.info("--> do another reroute, make sure nothing moves");
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
 * KIND, either express or implied.  See the License for the
            )
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(20));
    }
        Map<String, String> nodeAAttributes = new HashMap<>();
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
            .add(newNode("b1", singletonMap("zone", "b")))
                .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "rack.values", "c, d")
                DiscoveryNodes.builder()
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(5));
            0L
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(10));
        assertThat(clusterState.getRoutingNodes().node("A-1").size(), equalTo(2));
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
                .build()
            )
        ClusterState newState = strategy.reroute(clusterState, "reroute");
        assertThat(newState, equalTo(clusterState));
            .addAsNew(metadata.index("test2"))
            equalTo("node6")
        AllocationService strategy = createAllocationService(
        assertThat(
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
/*
        assertThat(routingNodes.node("b1").size() + routingNodes.node("b2").size() + routingNodes.node("b3").size(), equalTo(2));
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(2));
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))
        assertThat(routingNodes.shardsWithState(STARTED).size(), equalTo(3));
    }
            equalTo("node4")
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(10));
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))
        final RoutingNodes routingNodes = clusterState.getRoutingNodes();
        logger.info("--> adding two nodes on same rack and do rerouting");
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        );
            .nodes(
        final RoutingNodes routingNodes = clusterState.getRoutingNodes();
            .nodes(
        AllocationService strategy = createAllocationService(
        );
            .nodes(
            .routingTable(initialRoutingTable)
                .put("cluster.routing.allocation.balance.replica", 1.0f)
import org.opensearch.cluster.routing.ShardRouting;
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(20));
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
                    .add(newNode("node2", singletonMap("rack_id", "1")))
                DiscoveryNodes.builder()
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3", singletonMap("rack_id", "2"))))
import org.opensearch.cluster.routing.RoutingNodes;
        final IndexMetadata.Builder metadataBuilder = IndexMetadata.builder("test")
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3", singletonMap("rack_id", "2"))))
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
            Settings.builder()
        clusterState = ClusterState.builder(clusterState)
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
        logger.info("--> complete initializing");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        final ShardRouting primary = clusterState.getRoutingTable().shardsWithState(UNASSIGNED).get(0);
            .build();
        logger.info("--> add another node with a new rack, some more relocation should happen");
                );
            .nodes(
        logger.info("--> start the shards (primaries)");
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
                .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
            Settings.builder()
                .put("cluster.routing.allocation.awareness.attributes", "rack_id")
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            )
    }
    }
        assertThat(
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(), equalTo("node3"));
                commands.add(new CancelAllocationCommand(routing.shardId().getIndexName(), routing.id(), routing.currentNodeId(), false));
            .routingTable(initialRoutingTable)
        // The three copies spread one per zone: zone a receives a single copy (not two), and zone b is used.
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
 *
            .build();
            .metadata(metadata)
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        assertThat(routingNodes.node("a2").size(), equalTo(1));
                .nodes(nodes)
/*
        final DiscoveryNodes nodes = DiscoveryNodes.builder()
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(1));
                .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
        Metadata metadata = Metadata.builder()
        Settings settings = Settings.builder()
        }
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
            Settings.builder()
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
                    .add(newNode("A-2", singletonMap("zone", "a")))
        commands.add(new MoveAllocationCommand("test", 0, primaryNode, "A-4"));
        logger.info("--> do another reroute, make sure nothing moves");
    public void testMoveShardOnceNewNodeWithAttributeAdded3() {
        logger.info("--> do another reroute, make sure nothing moves");
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4", singletonMap("rack_id", "3"))))
        ClusterState newState = strategy.reroute(clusterState, "reroute");
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(commandsResult.explanations().explanations().size(), 1);
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            .nodes(
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4", singletonMap("rack_id", "3"))))
            .build();
        final Settings settings = Settings.builder()
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
            )
        final AwarenessAllocationDecider decider = new AwarenessAllocationDecider(settings, EMPTY_CLUSTER_SETTINGS);
        clusterState = ClusterState.builder(clusterState)
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        AllocationService strategy = createAllocationService(
        logger.info("--> add a new node with a new rack and reroute");
        Decision decision = null;
        clusterState = ClusterState.builder(clusterState)
            clusterState.getRoutingNodes(),
                    .add(newNode("A-1", singletonMap("zone", "a")))
            .add(newNode("b3", singletonMap("zone", "b")))
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                .build(),
            .build();
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(5));
        logger.info("--> complete relocation");
                .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
        logger.info("--> add a new node with a new rack and reroute");
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
                    .add(newNode("node1", singletonMap("rack_id", "1")))
    public void testFullAwareness1() {
                    .add(newNode("node1", singletonMap("rack_id", "1")))
        final RoutingAllocation allocation = new RoutingAllocation(
        );
 * the Apache License, Version 2.0 (the "License"); you may
            .build();
        logger.info("--> start the shards (primaries)");
        logger.info("--> add another node with a new rack, make sure nothing moves");
        );
            .routingTable(initialRoutingTable)
import org.opensearch.cluster.routing.allocation.command.CancelAllocationCommand;
        Map<String, String> nodeBAttributes = new HashMap<>();
            .build();
                .build(),
            .routingTable(initialRoutingTable)
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(20));
            }
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
import java.util.Map;
        logger.info("--> add a new node with a new rack and reroute");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        // zone a: a1 (excluded) and a2 (usable); zone b: three usable nodes
            .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        ClusterState newState = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
                    decision.getExplanation(),
        logger.info("--> complete relocation");
        logger.info("--> add a new node with a new rack and reroute");
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node5", singletonMap("rack_id", "3"))))
            .build();
        // Add a new node in zone c
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4", singletonMap("rack_id", "2"))))
import org.apache.logging.log4j.Logger;
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
    public void testFullAwareness3() {
            null,
        final Metadata metadata = Metadata.builder()
            .metadata(metadata)
            .build();
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
import org.opensearch.cluster.routing.RoutingNode;
        assertThat(routingNodes.shardsWithState(UNASSIGNED).size(), equalTo(0));
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4", singletonMap("rack_id", "3"))))
        List<ShardRouting> unassignedShards = clusterState.getRoutingTable().shardsWithState(UNASSIGNED);
        logger.info("--> Building initial routing table");
        logger.info("--> add a new node with a new rack and reroute");
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(), equalTo("node4"));
                .build()
            .routingTable(initialRoutingTable)
        clusterState = ClusterState.builder(clusterState)
 * The OpenSearch Contributors require contributions made to
            .build();
        logger.info("--> complete relocation");
                    .add(newNode("node2", singletonMap("rack_id", "1")))
        logger.info("--> complete relocation");
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
                .build(),
        logger.info("--> do another reroute, make sure nothing moves");
 * You may obtain a copy of the License at
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        logger.info("--> add a a nodes without zone and reroute");
        clusterState = ClusterState.builder(clusterState)
        clusterState = ClusterState.builder(clusterState)
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        logger.info("--> do another reroute, make sure nothing moves");
                    .add(newNode("node1", singletonMap("rack_id", "1")))
        assertThat(routingNodes.node("a1").size(), equalTo(1));
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(RELOCATING).size(), greaterThan(0));
        clusterState = strategy.reroute(clusterState, "reroute");
        RoutingTable initialRoutingTable = RoutingTable.builder()
        );
            strategy
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .build();
                .nodes(nodes)
                DiscoveryNodes.builder()
        clusterState = ClusterState.builder(clusterState)
        // 1 primary + 2 replicas = 3 copies of the shard
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)
            .build();
        );
                DiscoveryNodes.builder()
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(4));
        assertThat(clusterState.getRoutingNodes().shardsWithState(RELOCATING).size(), greaterThan(0));
                    .add(newNode("A-0", singletonMap("zone", "a")))
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))
            .routingTable(initialRoutingTable)
                    .add(newNode("node2", singletonMap("rack_id", "1")))
        final ClusterState clusterState = applyStartedShardsUntilNoChange(
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(3))
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3", singletonMap("rack_id", "2"))))
        List<Decision> decisions = commandsResult.explanations()
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        logger.info("--> do another reroute, make sure nothing moves");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            logger.info("--> complete initializing round: [{}]", i);
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
            .build();
        logger.info("--> make sure another reroute does not move things");
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
                .put("cluster.routing.allocation.awareness.attributes", "rack_id")
        );
import org.opensearch.cluster.routing.allocation.decider.FilterAllocationDecider;
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(10));
        clusterState = strategy.reroute(clusterState, "reroute");
            .build();
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
        logger.info("--> adding two nodes in different zones and do rerouting");
                DiscoveryNodes.builder()
        clusterState = strategy.reroute(clusterState, "reroute");
        assertThat(
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(5));
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .nodes(DiscoveryNodes.builder().add(newNode("a1", singletonMap("zone", "a"))).add(newNode("b1", singletonMap("zone", "b"))))
                .put("cluster.routing.allocation.balance.index", 0.0f)
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
        logger.info("--> complete relocation");
        logger.info("--> add another node with a new rack, make sure nothing moves");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        clusterState = ClusterState.builder(clusterState)
        logger.info("Building initial routing table for 'fullAwareness3'");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(4));
                .put("cluster.routing.allocation.balance.index", 0.0f)
        logger.info("--> start the shards (primaries)");
        logger.info("--> start the shards (replicas)");
import static java.util.Collections.singletonMap;
        clusterState = ClusterState.builder(clusterState)
            clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).get(0).relocatingNodeId(),
    }
import org.opensearch.Version;
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.get(Settings.EMPTY))
        // Because every node in zone b is excluded, awareness counts only zones {a, c}, so the per-zone cap is
            .metadata(metadata)
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
                    .add(newNode("node2", singletonMap("rack_id", "1")))
        }
        clusterState = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(3))
            .put("cluster.routing.allocation.awareness.attributes", "zone")
        );
import org.apache.logging.log4j.LogManager;
            clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).get(0).relocatingNodeId(),
            .add(newNode("b1", singletonMap("zone", "b")))
        logger.info("--> add another node with a new rack, we will have another relocation");
        logger.info("--> try to move the replica to new node");
import org.opensearch.cluster.ClusterName;
        clusterState = strategy.reroute(clusterState, "reroute");
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
            assertEquals(Decision.Type.YES, awarenessDecider.canAllocate(primary, node, allocation).type());
        final AllocationService strategy = createAllocationService(settings);
            .build();
            clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).get(0).relocatingNodeId(),
            equalTo("node3")
package org.opensearch.cluster.routing.allocation;
                .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone, rack")
        assertEquals(
        logger.info("--> start the shards (primaries)");
import java.util.Collections;
        logger.info("--> start the shards (replicas)");
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                    .add(newNode("node3", singletonMap("rack_id", "1")))
                .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a, b")
    public void testMoveShardOnceNewNodeWithAttributeAdded6() {
                .put("cluster.routing.allocation.balance.primary", 0.0f)
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("C-0", singletonMap("zone", "c"))))
    public void testMoveShardOnceNewNodeWithAttributeAdded1() {
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(5));
                .put("cluster.routing.allocation.awareness.attributes", "zone")
        AllocationService strategy = createAllocationService(settings);
        // same topology as the excluded-zone test but with no exclude filter: all three zones must still count
        // Previously all three zones were counted (ceil(3/3) = 1) and the third copy would stay UNASSIGNED.
            .getDecisions()
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(10));
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
        logger.info("--> replica will not start because we have only one rack value");
            clusterState,
    }
        clusterState = strategy.reroute(clusterState, "reroute");
            )
            .metadata(metadata)
    public void testMultipleAwarenessAttributes() {
                .metadata(metadata)
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        logger.info("--> start the shards (primaries)");
        logger.info("--> add a new node in zone 'a' and reroute");
            clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).get(0).relocatingNodeId(),
        Metadata metadata = Metadata.builder()
        logger.info("--> add another node with a new rack, make sure nothing moves");
        Metadata metadata = Metadata.builder()
        RoutingTable initialRoutingTable = RoutingTable.builder()
        final AllocationService strategy = createAllocationService(settings);
            equalTo("node5")
        nodeBAttributes.put("rack", "d");
            .build();
            .build();
            .build();
import org.opensearch.cluster.routing.RoutingTable;
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                .build()
            .add(newNode("c1", singletonMap("zone", "c")))
            ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.get(Settings.EMPTY))
            "allocation awareness is not enabled, set cluster setting " + "[cluster.routing.allocation.awareness.attributes] to enable it",
                    .add(newNode("B-0", singletonMap("zone", "b")))
        clusterState = strategy.reroute(clusterState, "reroute");
            strategy
        logger.info("--> start the shards (primaries)");
            .metadata(metadata)
        logger.info("Started shards: {}", clusterState.getRoutingNodes().shardsWithState(STARTED));
        logger.info("--> start the shards (primaries)");
                .nodes(nodes)
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
public class AwarenessAllocationTests extends OpenSearchAllocationTestCase {
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        nodeAAttributes.put("zone", "a");
            .build();
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
            .metadata(metadata)
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(1)); // Still 1 unassigned.
    public void testAllocationExplainForUnassignedShardsWithUnbalancedZones() {
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)
        assertThat(routingNodes.node("a2").size(), equalTo(1));
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(1));
                .put("cluster.routing.allocation.balance.primary", 0.0f)
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(0));
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(10));
        AllocationService strategy = createAllocationService(
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                .put("cluster.routing.allocation.awareness.force.rack_id.values", "1,2")
/*
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(4))
                .put("cluster.routing.allocation.awareness.attributes", "rack_id")
        assertThat(newState, equalTo(clusterState));
    }
            Settings.builder()
 */
        assertThat(routingNodes.shardsWithState(STARTED).size(), equalTo(3));
            } else if (routing.initializing()) {
            .metadata(metadata)
                DiscoveryNodes.builder()
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(1));
        clusterState = strategy.reroute(clusterState, "reroute");
                    .add(newNode("node1", singletonMap("rack_id", "1")))
                .build()
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        clusterState = ClusterState.builder(clusterState)
        assertThat(routingNodes.shardsWithState(UNASSIGNED).size(), equalTo(0));
            .explanations()
                DiscoveryNodes.builder()
        logger.info("--> adding two nodes on same rack and do rerouting");
            .add(newNode("c1", singletonMap("zone", "c")))
        logger.info("--> add another node with a new rack, some more relocation should happen");
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        // ceil(4/2) = 2. Only a2 is usable in zone a (1 copy) and zone b is capped at 2, so a fourth copy cannot be
        logger.info("--> add a new node with a new rack and reroute");
                .put("cluster.routing.allocation.concurrent_recoveries", 10)
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4", singletonMap("rack_id", "3"))))
            .build();
        for (ShardRouting routing : clusterState.routingTable().allShards()) {
        assertThat(clusterState.getRoutingNodes().node("B-0").size(), equalTo(5));
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node5", singletonMap("rack_id", "2"))))
        assertThat(routingNodes.shardsWithState(UNASSIGNED).size(), equalTo(1));
        Metadata metadata = Metadata.builder()
        assertThat(
                .put("cluster.routing.allocation.balance.replica", 1.0f)
        clusterState = ClusterState.builder(clusterState)
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
        logger.info("--> adding two nodes on same rack and do rerouting");
        logger.info("--> start the shards (primaries)");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .build();
            clusterState.getRoutingNodes(),
        logger.info("Building initial routing table for 'fullAwareness1'");
    public void testMoveShardOnceNewNodeWithAttributeAdded5() {
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(5));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .add(newNode("b1", singletonMap("zone", "b")))
            .build();
        logger.info("--> run it again, since we still might have relocation");
            clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).get(0).relocatingNodeId(),
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
        AllocationService strategy = createAllocationService(Settings.builder().build());
        nodeBAttributes.put("zone", "b");
        clusterState = ClusterState.builder(clusterState)
        clusterState = ClusterState.builder(clusterState)
        logger.info("Building initial routing table for 'moveShardOnceNewNodeWithAttributeAdded2'");
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("A-1", singletonMap("zone", "a"))))
        logger.info("--> add a new node with a new rack and reroute");
            .metadata(metadata)
            .metadata(metadata)
        logger.info("Building initial routing table for 'moveShardOnceNewNodeWithAttributeAdded5'");
        assertThat(routingNodes.node("b1").size(), equalTo(0));
        );
        assertThat(routingNodes.shardsWithState(STARTED).size(), equalTo(3));
            .build();
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3", singletonMap("rack_id", "2"))))
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
            equalTo("node4")
            .build();
        logger.info("Building initial routing table for 'testUnassignedShardsWithUnbalancedZones'");
        clusterState = strategy.reroute(clusterState, "reroute");
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
            false
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
            .toList();
        logger.info("--> adding two nodes on same rack and do rerouting");
        Metadata metadata = Metadata.builder()
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
                DiscoveryNodes.builder()
            .build();
            .build();
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(5));
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        logger.info("--> starting initializing shards on the new node");
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
            .build();
        logger.info("--> add another node with a new rack, we will have another relocation");
                DiscoveryNodes.builder().add(newNode("node1", singletonMap("zone", "a"))).add(newNode("node2", singletonMap("zone", "a")))
        logger.info("--> adding 3 nodes in different zones and do rerouting");
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
        clusterState = strategy.reroute(clusterState, "reroute");
        logger.info("--> do another reroute, make sure nothing moves");
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
    }
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
            new AllocationDeciders(List.of(awarenessDecider, filterDecider)),
                .put("cluster.routing.allocation.awareness.attributes", "rack_id")
            Settings.builder()
            .routingTable(initialRoutingTable)
        for (int i = 0; i < 2; i++) {
                    .add(newNode("node1", singletonMap("rack_id", "1")))
        final Metadata metadata = Metadata.builder()
        logger.info("Building initial routing table for 'moveShardOnceNewNodeWithAttributeAdded6'");
        );
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
 * Licensed to Elasticsearch under one or more contributor
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .nodes(
import java.util.HashMap;
        clusterState = ClusterState.builder(clusterState)
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        logger.info("Unassigned shards: {}", clusterState.getRoutingNodes().shardsWithState(UNASSIGNED));
        assertThat(clusterState.getRoutingNodes().shardsWithState(RELOCATING).size(), equalTo(1));
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3", singletonMap("rack_id", "2"))))
            if (routing.primary()) {
            Settings.builder()
            .routingTable(initialRoutingTable)
        );
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(), equalTo("node3"));
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
        );
        final Settings settings = Settings.builder()
                    .add(newNode("node2", singletonMap("rack_id", "1")))
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4", singletonMap("rack_id", "2"))))
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4", singletonMap("rack_id", "3"))))
        AllocationService strategy = createAllocationService(
        logger.info("--> adding two nodes in different zones and do rerouting");
            null,
            .add(newNode("A-0", singletonMap("zone", "a")))
        assertThat(
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(8));
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
        logger.info("--> start the shards (replicas)");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        final AllocationService strategy = createAllocationService(settings);
            .routingTable(initialRoutingTable)
import org.opensearch.cluster.node.DiscoveryNodes;
        logger.info("--> run it again, since we still might have relocation");
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
                .put("cluster.routing.allocation.awareness.force.rack_id.values", "1,2")
            .build();
        clusterState = strategy.reroute(clusterState, "reroute");
        logger.info("Building initial routing table for 'moveShardOnceNewNodeWithAttributeAdded1'");
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .build();
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(0));
            .build();
    }
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
        final Metadata metadata = Metadata.builder().put(metadataBuilder).build();
        final DiscoveryNodes nodes = DiscoveryNodes.builder()
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(10));
            .build();
        logger.info("--> adding 5 nodes in different zones and do rerouting");
        final Metadata metadata = Metadata.builder()
import org.opensearch.common.settings.ClusterSettings;
        clusterState = strategy.reroute(clusterState, "reroute");
        final AllocationService strategy = createAllocationService(settings);
        );
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
            .nodes(
 * software distributed under the License is distributed on an
                DiscoveryNodes.builder()
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(1));
 */
        AllocationService strategy = createAllocationService(
        logger.info("--> all replicas are allocated and started since we have one node in each zone and rack");
                    .add(newNode("node1", singletonMap("rack_id", "1")))
        clusterState = ClusterState.builder(clusterState)
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
            .build();
            .nodes(
            .build();
                    .add(newNode("node2", singletonMap("rack_id", "1")))
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            Settings.builder()
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        clusterState = ClusterState.builder(clusterState)
        logger.info("--> start the shards (primaries)");
        );
        logger.info("Building initial routing table for 'moveShardOnceNewNodeWithAttributeAdded4'");
                .metadata(metadata)
        logger.info("--> start the shards (replicas)");
            .decisions()
        clusterState = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(10));
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        clusterState = ClusterState.builder(clusterState)
        AllocationService strategy = createAllocationService(
            .build();
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(5));
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            strategy
            .routingTable(initialRoutingTable)
    }
                    .add(newNode("A-3", singletonMap("zone", "a")))
            // ... leaving FilterAllocationDecider as the decider that keeps shards off the excluded nodes
                .build()
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        final AwarenessAllocationDecider awarenessDecider = new AwarenessAllocationDecider(settings, clusterSettings);
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node6", singletonMap("rack_id", "3"))))
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(), equalTo("node3"));
        clusterState = ClusterState.builder(clusterState)
            .settings(
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        clusterState = strategy.reroute(clusterState, "reroute");
    public void testUnbalancedZones() {
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(5));
 * Modifications Copyright OpenSearch Contributors. See
                DiscoveryNodes.builder()
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        // Zone a keeps counting because a2 is not excluded, so awareness sees zones {a, b} and the per-zone cap is
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        AllocationService strategy = createAllocationService(
        clusterState = ClusterState.builder(clusterState)
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(0));
            .build();
        final Settings settings = Settings.builder()
        );
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
        Metadata metadata = Metadata.builder()
        clusterState = ClusterState.builder(clusterState)
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
        logger.info("--> complete relocation");
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
                DiscoveryNodes.builder()
    public void testUnassignedShardsWithUnbalancedZones() {
        // Cancel all initializing shards and move started primary to another node.
        logger.info("--> adding two nodes on same rack and do rerouting");
        assertThat(routingNodes.node("b1").size(), equalTo(1));
    public void testFullAwareness2() {
            .build();
        logger.info("--> start the shard (primary)");
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(20));
        logger.info("--> do another reroute, make sure nothing moves");
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .build();
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
