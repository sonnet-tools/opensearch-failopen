        ClusterState newState = addNodes(clusterState, strategy, "zone3", "node11", "node12", "node13", "node14", "node15");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        // add back node2 when skewness is still breached
import org.opensearch.cluster.routing.UnassignedInfo;
import org.opensearch.cluster.ClusterState;
    private Settings buildSettings(Map<String, Object> settingsValue) {
        return createAllocationService(buildSettings(settingsValue));
        newState = ClusterState.builder(newState).metadata(metadata).routingTable(updatedRoutingTable).build();  
                IndexMetadata.builder("test3")
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey(), 20)
        }  
    }
        newState = startInitializingShardsAndReroute(strategy, newState);
                    .settings(  
                    )  
        clusterState = strategy.reroute(clusterState, "reroute");  
        metadata = Metadata.builder(newState.metadata())
        newState = strategy.reroute(newState, "reroute");
                0,  
            .routingTable(initialRoutingTable)
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        strategy = createAllocationServiceWithAdditionalSettings(
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(30).numberOfReplicas(1))
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        Metadata metadata = Metadata.builder()
            )
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(20));
            assertEquals(shard.unassignedInfo().getReason(), UnassignedInfo.Reason.NODE_LEFT);  
            newState.getRoutingNodes()  
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING.getKey(),
        // add back node2 when skewness is still breached
            .build();
                5,
            .metadata(metadata)
            )
    }
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(30).numberOfReplicas(1))
    }  
            .build();  
 * this file be licensed under the Apache-2.0 license or a
        newState = strategy.reroute(newState, "reroute");
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        Metadata metadata = Metadata.builder()
        logger.info("Building initial routing table for 'testExistingPrimariesAllocationOnOverload'");
            )
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            Map.of(
        // Each node can now have 5 shards each
            .metadata(metadata)
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(20));
        // add the removed node  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                20
            )
        assertThat(newState.getRoutingNodes().node("node12").size(), equalTo(5));
        );
        }
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(20));
                20,
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 5)
            .build();
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node14", singletonMap("zone", "zone3"))))
            .build();
 * The OpenSearch Contributors require contributions made to  
        );  
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));  
        }
            assertEquals(shard.unassignedInfo().getReason(), UnassignedInfo.Reason.NODE_LEFT);  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(20));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(20));  
        newState = ClusterState.builder(newState)
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(126));  
            newState = startInitializingShardsAndReroute(strategy, newState);
                .stream()
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(30));  
        logger.info("Building initial routing table for 'testNewUnassignedPrimaryAllocationOnOverload'");
        // Each node can take 7 shards each now (2 + ceil(4*1.2))  
            .build();  
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
 */  
            .build();  
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),  
                "zone_1,zone_2,zone_3"  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertEquals(
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    }  
            assertEquals(shard.unassignedInfo().getReason(), UnassignedInfo.Reason.INDEX_CREATED);
            .build();  
        // add the removed node
                .shardsWithState(UNASSIGNED)
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node11", singletonMap("zone", "zone3"))))
        }
        newState = ClusterState.builder(newState)
            0L,
        newState = strategy.reroute(newState, "reroute");  
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(14));  
        assertThat(newState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(6));
        }
        // add back node3
            .metadata(metadata)
            newState = startInitializingShardsAndReroute(strategy, newState);
            .build();
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node2", singletonMap("zone", "zone_1"))))  
        clusterState = addNodes(clusterState, strategy, "zone2", "node6", "node7", "node8", "node9", "node10");
            .build();  
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
        logger.info("--> start the shards (primaries)");
        clusterState = removeNodes(clusterState, strategy, randomFrom("node1", "node2", "node3"));
            .build();  
            .build();
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 60)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            ),
        newState = addNodes(newState, strategy, "zone3", "node13");
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(9));
        }  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(20));  
        // ensure all shards are assigned
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),  
            .build();
            .routingTable(initialRoutingTable)
        logger.info("--> replica will not start because we have only one zone value");  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(40));  
        assertThat(newState.getRoutingNodes().node("node14").size(), equalTo(4));
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(61));  
        // remove one nodes in one zone to cause distribution zone1->2 , zone2->3, zone3->2
                "cluster.routing.allocation.awareness.force.zone.values",
    public void testSingleZoneOneReplicaLimitsShardAllocationOnOverload() {
        assertThat(newState.getRoutingNodes().node("node13").size(), equalTo(4));
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(20));  
            newState = startInitializingShardsAndReroute(strategy, newState);
import org.opensearch.cluster.metadata.IndexMetadata;
        // Each node can take 11 shards each (2 + ceil(8*1.1)), hence 2 replicas will also start
        assertThat(newState.getRoutingNodes().node("node13").size(), equalTo(4));
        // Each node can take 6 shards max (2 + ceil(4*1.0)), so all shards should be assigned
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(14));
            .build();
                5,
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            assertEquals(shard.unassignedInfo().getReason(), UnassignedInfo.Reason.NODE_LEFT);
import org.opensearch.test.gateway.TestGatewayAllocator;
        // add back node3
        // add the removed node  
        newState = strategy.reroute(newState, "reroute");
    public void testThreeZoneOneReplicaWithSkewFactorZeroAllShardsAssignedAfterRecovery() {
        logger.info("--> Add back node4 and ensure existing primaries are assigned");  
        // add the removed node  
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        newState = strategy.reroute(newState, "reroute");  
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
        logger.info("Building initial routing table for 'testNoAllocationLimitsOnOverloadForDisabledLoadFactor'");
        assertThat(newState.getRoutingNodes().node("node15").size(), equalTo(5));  
            .metadata(metadata)
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        );
            newState = startInitializingShardsAndReroute(strategy, newState);  
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(12));
                IndexMetadata.builder("test1")
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(20));  
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        for (ShardRouting shard : clusterState.getRoutingNodes().shardsWithState(UNASSIGNED)) {  
                .filter(r -> r.unassignedInfo().getReason() == UnassignedInfo.Reason.NODE_LEFT)  
        for (ShardRouting shard : clusterState.getRoutingNodes().shardsWithState(UNASSIGNED)) {
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                5,
    }  
        logger.info("--> adding three nodes on same rack and do rerouting");
        logger.info("--> do another reroute, make sure nothing moves");  
            Map.of(
        newState = ClusterState.builder(newState)
        // add the removed node
import org.opensearch.Version;  
        for (RoutingNode node : newState.getRoutingNodes()) {
        }
            Map.of(
        return allocationService.disassociateDeadNodes(ClusterState.builder(clusterState).nodes(nodeBuilder).build(), true, "reroute");
        for (RoutingNode node : newState.getRoutingNodes()) {
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        newState = ClusterState.builder(newState)  
            .build();  
        return createAllocationService(buildSettings(settingsValue), gatewayAllocator);
        for (ShardRouting shard : newState.getRoutingNodes().shardsWithState(UNASSIGNED)) {
        assertThat(newState.getRoutingNodes().node("node15").size(), equalTo(4));  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(20));
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        assertThat(newState.getRoutingNodes().node("node15").size(), equalTo(4));  
        );
        logger.info("no limits should be applied on newly created primaries");
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(12));  
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(32));
    public void testSingleZoneTwoReplicaLimitsReplicaAllocationOnOverload() {
                    .settings(
        newState = ClusterState.builder(newState)  
        }
        }
                "zone_1,zone_2,zone_3"  
            .build();
            )
            .build();
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        }  
        ClusterState newState = addNodes(clusterState, strategy, "zone_3", "node7", "node8", "node9");  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(3));
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(  
            .routingTable(initialRoutingTable)
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node1", singletonMap("zone", "zone_1"))))
        RoutingTable updatedRoutingTable = RoutingTable.builder(newState.routingTable()).addAsNew(metadata.index("test1")).build();  
        logger.info("add another index with 20 shards");
                5,
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
        logger.info("add another index with 20 shards");  
        // 4 existing shards from this node's local store get started
        logger.info("--> start the shards (primaries)");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                -1,
        newState = startInitializingShardsAndReroute(strategy, newState);  
                20,  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        logger.info("--> add another node with a new rack, make sure nothing moves");
                .count()
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));  
            newState = startInitializingShardsAndReroute(strategy, newState);
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        assertThat(newState.getRoutingNodes().node("node14").size(), equalTo(7));
        assertThat(newState.getRoutingNodes().node("node13").size(), equalTo(4));  
            gatewayAllocator
                    .settings(
        logger.info("--> start the shards (primaries)");  
        logger.info("--> Remove node2 when the limit of overload is reached");  
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(  
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        assertThat(newState.getRoutingNodes().node("node11").size(), equalTo(4));
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(
        metadata = Metadata.builder(newState.metadata())
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING.getKey(),
                15,  
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).stream().filter(ShardRouting::primary).count(), equalTo(5L));
        }  
                    )  
            .build();
        newState = strategy.reroute(newState, "reroute");
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(21));
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {  
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(36));  
        logger.info("Building initial routing table for 'testThreeZoneOneReplicaWithSkewFactorZeroAllShardsAssignedAfterRecovery'");
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
    ) {
        metadata = Metadata.builder(newState.metadata())
        for (RoutingNode node : clusterState.getRoutingNodes()) {  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
        });  
            newState = startInitializingShardsAndReroute(strategy, newState);
        clusterState = addNodes(clusterState, strategy, "zone1", "node1", "node2");
import org.opensearch.cluster.routing.ShardRoutingState;
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(3));
        ClusterState newState = removeNodes(clusterState, strategy, "node1");  
        newState = ClusterState.builder(newState)
        // add the removed node
        for (ShardRouting shard : newState.getRoutingNodes().shardsWithState(UNASSIGNED)) {
        assertThat(newState.getRoutingNodes().node("node12").size(), equalTo(4));  
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
    public void testNewUnassignedPrimaryAllocationOnOverload() {
        logger.info("--> start the shards (replicas)");
            .build();  
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
            assertThat(node.size(), equalTo(42));
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(60));
            newState = startInitializingShardsAndReroute(strategy, newState);  
import org.opensearch.gateway.GatewayAllocator;  
        assertThat(newState.getRoutingNodes().node("node11").size(), equalTo(4));
                3,  
        clusterState = addNodes(clusterState, strategy, "zone1", "node1", "node2", "node3", "node4", "node5");  
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
        // increases avg shard per node to 140/5 = 28, overload factor 1.2, total allowed 34 per node but still ALL primaries get assigned
            .build();  
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),  
    }
        ClusterState newState = addNodes(clusterState, strategy, "zone3", "node11", "node12", "node13", "node14", "node15");
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 30)
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(3));
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node12", singletonMap("zone", "zone3"))))  
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(32));
            newState = startInitializingShardsAndReroute(strategy, newState);
        logger.info("--> do another reroute, make sure nothing moves");
            }
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node3", singletonMap("zone", "zone_1"))))
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(40));  
        for (RoutingNode node : newState.getRoutingNodes()) {
            )  
        GatewayAllocator gatewayAllocator = new TestGatewayAllocator();  
    }
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(60));  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(), equalTo("node4"));  
        newState = ClusterState.builder(newState).metadata(metadata).routingTable(updatedRoutingTable).build();
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING.getKey(),  
        newState = ClusterState.builder(newState)  
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node1", singletonMap("zone", "zone_1"))))  
        logger.info("--> adding three nodes on same zone and do rerouting");
                true
        // 28 shards should be assigned (14 on each node -> 8 * 1.5 + 2)
                "cluster.routing.allocation.awareness.force.zone.values",
        }  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(66));
        assertThat(newState.getRoutingNodes().node("node13").size(), equalTo(4));
        newState = strategy.reroute(newState, "reroute");
        clusterState = addNodes(clusterState, strategy, "zone2", "node6", "node7", "node8", "node9", "node10");  
        newState = addNodes(newState, strategy, "zone3", "node12");
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(20).numberOfReplicas(0))
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(6));  
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
            assertFalse(shard.primary());
            .metadata(metadata)
        logger.info("--> 2 replicas are initializing");
        }  
            .metadata(metadata)  
                "cluster.routing.allocation.awareness.force.zone.values",
    }  
        logger.info("--> add five new node in new zone and reroute");  
        Settings.Builder settingsBuilder = Settings.builder()  
        logger.info("--> adding five nodes on same zone and do rerouting");
        logger.info("--> add another five node in new zone and reroute");  
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node4", singletonMap("zone", "zone_1"))))
        newState = ClusterState.builder(newState)
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 20)
        }  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        logger.info("--> add five new node in new zone and reroute");  
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 20)  
        logger.info("--> replicas are initializing");  
        newState = strategy.reroute(newState, "reroute");
            .build();
    public void testSingleZoneOneReplicaLimitsReplicaAllocationOnOverload() {  
            .routingTable(initialRoutingTable)
        }
        logger.info("Building initial routing table for 'testSingleZoneOneReplicaLimitsShardAllocationOnOverload'");
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(20));
        newState = ClusterState.builder(newState)
        logger.info("--> complete relocation");
            assertEquals(shard.unassignedInfo().getReason(), UnassignedInfo.Reason.NODE_LEFT);
        logger.info("--> add five new node in new zone and reroute");
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(40));
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(36));  
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(2));
import org.apache.logging.log4j.LogManager;
        // 4 existing shards from this node's local store get started and cluster rebalances  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(21));
                9,
        assertThat(newState.getRoutingNodes().node("node12").size(), equalTo(4));
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(28));
                    )
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        newState = ClusterState.builder(newState)
        ClusterState newState = addNodes(clusterState, strategy, "zone3", "node11", "node12", "node13", "node14", "node15");  
        List.of(nodeIds).forEach(nodeId -> nodeBuilder.add(newNode(nodeId, singletonMap("zone", zone))));
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(60));  
        );
        Metadata metadata = Metadata.builder()
        newState = strategy.reroute(newState, "reroute");  
                5,  
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(  
        GatewayAllocator gatewayAllocator = new TestGatewayAllocator();
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
            newState = startInitializingShardsAndReroute(strategy, newState);
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
            .metadata(metadata)
                50,
            newState = startInitializingShardsAndReroute(strategy, newState);
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(28));
            newState = startInitializingShardsAndReroute(strategy, newState);
                    )
                    .add(newNode("node7", singletonMap("zone", "zone_3")))  
            .routingTable(initialRoutingTable)
        // increases avg shard per node to 145/5 = 29, overload factor 1.2, total allowed 35+2=37 per node and NO primaries get assigned
        // ensure all shards are assigned  
        clusterState = addNodes(clusterState, strategy, "zone_1", "node1", "node2", "node3");  
        }
            assertThat(node.size(), equalTo(10));  
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
        Metadata metadata = Metadata.builder()  
import org.opensearch.cluster.routing.RoutingTable;
        }
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(60));
        logger.info("--> start the shards (primaries)");  
        newState = ClusterState.builder(newState).metadata(metadata).routingTable(updatedRoutingTable).build();
        GatewayAllocator gatewayAllocator  
        newState = removeNodes(newState, strategy, "node7", "node2");
        assertThat(newState.getRoutingNodes().node("node11").size(), equalTo(4));
            newState = startInitializingShardsAndReroute(strategy, newState);
        newState = strategy.reroute(newState, "reroute");
            .build();  
        while (clusterState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        newState = startInitializingShardsAndReroute(strategy, newState);
            assertThat(node.size(), equalTo(6));
            assertThat(node.size(), equalTo(7));
        logger.info("--> complete relocation");
import static java.util.Collections.singletonMap;  
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {  
        assertThat(newState.getRoutingNodes().node("node13").size(), equalTo(4));
    public void testExistingPrimariesAllocationOnOverload() {  
        logger.info("add another index with 60 shards");
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node12", singletonMap("zone", "zone3"))))  
                15,  
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
    }  
import java.util.List;  
        logger.info("change settings to allow unassigned primaries");  
        logger.info("--> start the shards (replicas)");
            newState = startInitializingShardsAndReroute(strategy, newState);  
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
            .build();
            Map.of(
            )  
            ),  
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(63));
        logger.info("--> add five new node in new zone and reroute");  
        logger.info("--> start the shards (primaries)");
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(20));
        assertThat(newState.getRoutingNodes().node("node12").size(), equalTo(4));  
        Metadata metadata = Metadata.builder()  
        assertThat(newState.getRoutingNodes().node("node5").size(), equalTo(14));
            .build();
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(40));  
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node2", singletonMap("zone", "zone_1"))))
        Metadata metadata = Metadata.builder()  
        // add the removed node  
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
            newState = startInitializingShardsAndReroute(strategy, newState);
            assertThat(node.size(), equalTo(8));
    private AllocationService createAllocationServiceWithAdditionalSettings(Map<String, Object> settingsValue) {  
        newState = strategy.reroute(newState, "reroute");
        assertThat(newState.getRoutingNodes().node("node14").size(), equalTo(5));
        clusterState = addNodes(clusterState, strategy, "zone1", "node5");
            newState = startInitializingShardsAndReroute(strategy, newState);
            .build();
            .build();
            else {  
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .build();
        // skewness limit doesn't apply to primary  
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(36));  
                10,  
        Metadata metadata = Metadata.builder()  
            .metadata(metadata)  
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
            newState = startInitializingShardsAndReroute(strategy, newState);
        }
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node1", singletonMap("zone", "zone_1"))))
        for (RoutingNode node : newState.getRoutingNodes()) {
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
            newState = startInitializingShardsAndReroute(strategy, newState);
    private ClusterState removeNodes(ClusterState clusterState, AllocationService allocationService, String... nodeIds) {
        }
            )
                IndexMetadata.builder("test1")
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
        }
    private ClusterState addNodes(ClusterState clusterState, AllocationService allocationService, String zone, String... nodeIds) {
                    .settings(  
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
        assertThat(newState.getRoutingNodes().node("node11").size(), equalTo(4));
            assertFalse(shard.primary());
 * compatible open source license.
            gatewayAllocator
            Map.of(  
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(32));  
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(28));
            gatewayAllocator
            Map.of(
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING.getKey(),
        newState = ClusterState.builder(newState).metadata(metadata).routingTable(updatedRoutingTable).build();
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    public void testNoAllocationLimitsOnOverloadForDisabledLoadFactor() {
        newState = strategy.reroute(newState, "reroute");
            12L,
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(60));
        }  
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
        List.of(nodeIds).forEach(nodeId -> nodeBuilder.remove(nodeId));
                    .settings(  
                IndexMetadata.builder("test1")  
        );
        newState = ClusterState.builder(newState).metadata(metadata).routingTable(updatedRoutingTable).build();  
        newState = startInitializingShardsAndReroute(strategy, newState);  
        strategy = createAllocationServiceWithAdditionalSettings(
        logger.info("--> Remove complete zone3 holding primary and replicas");
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(40));  
        }  
        newState = strategy.reroute(newState, "reroute");  
            .build();
        // increases avg shard per node to 80/5 = 16, overload factor 1.2, total allowed 20  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));  
        }
            .build();
            Map.of(  
                IndexMetadata.builder("test1")
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
        clusterState = addNodes(clusterState, strategy, "zone_1", "node1", "node2", "node3", "node4", "node5");
            assertEquals(shard.unassignedInfo().getReason(), UnassignedInfo.Reason.INDEX_CREATED);  
        logger.info("add another index with 20 shards");
            )
                false
        }
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),  
            )
        }  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(60));
import static org.hamcrest.Matchers.equalTo;
                10,
            Map.of(
        newState = ClusterState.builder(newState)  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(20));
            newState = startInitializingShardsAndReroute(strategy, newState);  
        assertThat(newState.getRoutingNodes().node("node12").size(), equalTo(4));  
        logger.info("--> Remove node4 from zone holding primaries");  
            .build();
            .metadata(metadata)
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
        newState = removeNodes(newState, strategy, "node11", "node12", "node13", "node14", "node15");  
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node13", singletonMap("zone", "zone3"))))
        logger.info("--> start the shards (primaries)");
        while (clusterState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        logger.info("--> complete relocation");  
            Map.of(
                "cluster.routing.allocation.awareness.force.zone.values",  
        assertThat(newState.getRoutingNodes().node("node14").size(), equalTo(4));
        while (clusterState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
                5,
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 20)  
                true
            assertFalse(shard.primary());
        logger.info("--> Remove two nodes from zones");  
        // each node can take 10 shards each (2 + ceil(7*1.1))
        }
        // ensure all shards are assigned  
        );  
        newState = ClusterState.builder(newState)
            newState = startInitializingShardsAndReroute(strategy, newState);
            .metadata(metadata)  
/*  
        logger.info("--> adding five nodes on same zone and do rerouting");
        }
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {  
    }  
        newState = ClusterState.builder(newState)
import org.opensearch.cluster.metadata.Metadata;
        newState = strategy.reroute(newState, "reroute");
        assertEquals(
        logger.info("--> complete relocation");  
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node15", singletonMap("zone", "zone3"))))
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(42));
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node11", singletonMap("zone", "zone3"))))
        RoutingTable updatedRoutingTable = RoutingTable.builder(newState.routingTable()).addAsNew(metadata.index("test1")).build();
    public void testThreeZoneTwoReplicaLimitsShardAllocationOnOverload() {
        // add the removed node  
                true
        // Each node can take 12 shards each (2 + ceil(8*1.2))
        newState = removeNodes(newState, strategy, "node2");
        ClusterState newState = removeNodes(clusterState, strategy, "node1", "node2", "node3");
        }  
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        // add back node2 when skewness is still breached
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        clusterState = addNodes(clusterState, strategy, "zone_2", "node4", "node5", "node6");
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING.getKey(),
        return allocationService.reroute(clusterState, "reroute");  
        logger.info("--> do another reroute, make sure nothing moves");
                20,
        logger.info("--> do another reroute, make sure nothing moves");
            .put(  
        }
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .build();  
        newState = strategy.reroute(newState, "reroute");
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(30));
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(12));
        logger.info("--> start the shards (primaries)");  
    }
            .put(
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(newState.getRoutingNodes().node("node11").size(), equalTo(4));
        logger.info("--> Remove nodes from zone holding primaries");
            .build();
        logger.info("Building initial routing table for 'testThreeZoneOneReplicaLimitsShardAllocationOnOverload'");
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING.getKey(),  
            )
            newState = startInitializingShardsAndReroute(strategy, newState);
            .routingTable(initialRoutingTable)
        // add the third and fourth node  
        logger.info("add another index with 5 shards");
            )  
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(19));  
        logger.info("Building initial routing table for 'testThreeZoneTwoReplicaLimitsShardAllocationOnOverload'");
        newState = strategy.reroute(newState, "reroute");  
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING.getKey(), 20)
import org.opensearch.cluster.routing.allocation.decider.NodeLoadAwareAllocationDecider;  
        for (ShardRouting shard : newState.getRoutingNodes().shardsWithState(UNASSIGNED)) {
            .build();
                IndexMetadata.builder("test2")
            .routingTable(initialRoutingTable)  
        for (ShardRouting shard : newState.getRoutingNodes().shardsWithState(UNASSIGNED)) {
                DiscoveryNodes.builder(newState.nodes())
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(40));  
        newState = removeNodes(newState, strategy, "node11", "node12", "node13");
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(36));
            .routingTable(initialRoutingTable)  
        clusterState = addNodes(clusterState, strategy, "zone1", "node1", "node2", "node3", "node4", "node5");
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node2", singletonMap("zone", "zone_1"))))  
            .build();  
        // since total owning shards are 42 per node already
        clusterState = addNodes(clusterState, strategy, "zone_1", "node1", "node2", "node3", "node4", "node5");  
        RoutingTable updatedRoutingTable = RoutingTable.builder(newState.routingTable()).addAsNew(metadata.index("test1")).build();
        );
            Map.of(  
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {  
        for (ShardRouting shard : clusterState.getRoutingNodes().shardsWithState(UNASSIGNED)) {  
            .build();
        logger.info("--> adding five nodes on same zone and do rerouting");  
        logger.info("--> replicas are started");  
        }
import org.opensearch.cluster.ClusterName;
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
        logger.info("--> adding five nodes on same zone and do rerouting");
            newState = startInitializingShardsAndReroute(strategy, newState);  
            newState = startInitializingShardsAndReroute(strategy, newState);  
            .nodes(
        logger.info("--> start the shards (primaries)");  
        }  
                .stream()
            )  
        // add the removed nodes
import org.opensearch.cluster.routing.RoutingNode;
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(8));
            else if (v instanceof String) settingsBuilder.put(k, (String) (v));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
            Map.of(
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(20));
        metadata = Metadata.builder(newState.metadata())  
            newState = startInitializingShardsAndReroute(strategy, newState);
        ClusterState newState = removeNodes(clusterState, strategy, "node1", "node2", "node3");  
        while (!newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty()) {
        assertThat(strategy.reroute(newState, "reroute").routingTable(), sameInstance(newState.routingTable()));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(6));
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(
                false
            Map.of(
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(20));  
        );
        newState = ClusterState.builder(newState).metadata(metadata).routingTable(updatedRoutingTable).build();  
        newState = strategy.reroute(newState, "reroute");
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
            .routingTable(initialRoutingTable)
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        assertThat(newState.getRoutingNodes().node("node13").size(), equalTo(4));  
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
        logger.info("--> Remove nodes from zone holding primaries");
            .build();  
        newState = strategy.reroute(newState, "reroute");
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(2))  
        assertThat(newState.getRoutingNodes().node("node12").size(), equalTo(4));
        assertThat(newState.getRoutingNodes().node("node15").size(), equalTo(4));
                20,  
        logger.info("add another index with 30 primary 1 replica");  
            newState = startInitializingShardsAndReroute(strategy, newState);  
                .count()
        newState = startInitializingShardsAndReroute(strategy, newState);  
        newState = strategy.reroute(newState, "reroute");  
        }  
        }
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(30));
        newState = ClusterState.builder(newState).metadata(metadata).routingTable(updatedRoutingTable).build();
        newState = ClusterState.builder(newState)  
            )
        updatedRoutingTable = RoutingTable.builder(newState.routingTable()).addAsNew(metadata.index("test3")).build();  
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(  
 *
        metadata = Metadata.builder(newState.metadata())
        newState = removeNodes(newState, strategy, "node11", "node12", "node13");
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(60));  
            )
        clusterState = addNodes(clusterState, strategy, "zone1", "node1", "node2", "node3", "node4", "node5");  
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;  
    }  
        logger.info("--> adding five nodes on same zone and do rerouting");  
        newState = strategy.reroute(newState, "reroute");
        // replicas are unassigned  
        Metadata metadata = Metadata.builder()  
                20,
        clusterState = addNodes(clusterState, strategy, "zone2", "node6", "node7", "node8", "node9", "node10");
        assertThat(newState.getRoutingNodes().node("node4").size(), equalTo(14));
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
        logger.info("--> add another five node in new zone and reroute");
        newState = addNodes(clusterState, strategy, "zone3", "node11", "node12", "node13");  
                5,  
        }
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(
            .build();
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(60));
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(20).numberOfReplicas(0))
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
                false  
        Map<String, Object> settingsValue,
        // replicas are unassigned  
public class NodeLoadAwareAllocationTests extends OpenSearchAllocationTestCase {
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {  
            .build();
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
        assertThat(newState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
            assertFalse(shard.primary());
    }  
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {  
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(  
            newState = startInitializingShardsAndReroute(strategy, newState);  
        assertThat(newState.getRoutingNodes().node("node14").size(), equalTo(4));
        assertThat(newState.getRoutingNodes().node("node14").size(), equalTo(4));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(20).numberOfReplicas(1))
        newState = strategy.reroute(newState, "reroute");
        logger.info("--> all shards are started");
            assertEquals(shard.unassignedInfo().getReason(), UnassignedInfo.Reason.NODE_LEFT);  
        logger.info("--> change the overload load factor to zero and verify if unassigned primaries on disk get assigned despite overload");  
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {  
            newState.getRoutingNodes()  
            .put(
        logger.info("--> Removing three nodes from zone3");
        );  
            .build();
        logger.info("--> adding five nodes on same zone and do rerouting");
        clusterState = addNodes(clusterState, strategy, "zone2", "node6", "node7", "node8", "node9", "node10");
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {  
        newState = strategy.reroute(newState, "reroute");
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING.getKey(),  
            .put(  
package org.opensearch.cluster.routing.allocation;
        RoutingTable updatedRoutingTable = RoutingTable.builder(newState.routingTable()).addAsNew(metadata.index("test1")).build();
import org.opensearch.cluster.node.DiscoveryNodes;  
    }
    private AllocationService createAllocationServiceWithAdditionalSettings(
        assertThat(newState.getRoutingNodes().node("node12").size(), equalTo(4));  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(20).numberOfReplicas(0))
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
            .put("cluster.routing.allocation.awareness.attributes", "zone");
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.getNodes());  
                0,
        logger.info("--> adding five nodes on same zone and do rerouting");
        logger.info("--> start the shards (primaries)");  
        ClusterState newState = addNodes(clusterState, strategy, "zone3", "node11", "node12", "node13", "node14", "node15");
            .build();
        }  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(40));
        logger.info("limits should be applied on newly create primaries");  
        AllocationService strategy = createAllocationServiceWithAdditionalSettings(  
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),  
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
    }
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
                    .settings(
        logger.info("Building initial routing table for 'testThreeZoneTwoReplicaLimitsUnderFullZoneFailure'");  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(20).numberOfReplicas(1))  
        );
        }
        );
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        logger.info("Building initial routing table for 'testSingleZoneTwoReplicaLimitsReplicaAllocationOnOverload'");  
                    .add(newNode("node2", singletonMap("zone", "zone_1")))
            ),  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(30));
import org.apache.logging.log4j.Logger;
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(20));  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
}  
        assertThat(newState.getRoutingNodes().node("node4").size(), equalTo(14));
            .routingTable(initialRoutingTable)  
import org.opensearch.common.settings.Settings;
        logger.info("--> replica will not start because we have only one rack value");  
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder(clusterState.nodes());  
        );
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
        newState = startInitializingShardsAndReroute(strategy, newState);
        newState = strategy.reroute(newState, "reroute");
        newState = removeNodes(newState, strategy, "node11", "node12", "node13");
        }
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {  
        logger.info("--> add three new node with a new rack and reroute");
        );  
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
            .build();
        newState = ClusterState.builder(newState)
        newState = addNodes(newState, strategy, "zone3", "node11");
            ),  
        // add the removed node
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(120));
        assertThat(newState.getRoutingNodes().node("node11").size(), equalTo(8));
        );
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),
        }
        newState = ClusterState.builder(newState)  
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 20)  
        logger.info("no limits should be applied on newly created primaries");
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),  
        // ensure all shards are assigned  
import static org.hamcrest.Matchers.sameInstance;
        newState = startInitializingShardsAndReroute(strategy, newState);
            .build();
        assertThat(newState.getRoutingNodes().node("node12").size(), equalTo(8));
            .build();  
        newState = strategy.reroute(newState, "reroute");
                IndexMetadata.builder("test1")  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(21));
        }
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(63));
        updatedRoutingTable = RoutingTable.builder(newState.routingTable()).addAsNew(metadata.index("test2")).build();  
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(40));
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(30));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(20).numberOfReplicas(2))  
        Metadata metadata = Metadata.builder()
        clusterState = addNodes(clusterState, strategy, "zone_1", "node1", "node2", "node3", "node4", "node5");
        // Each node can take 7 shards max ( 2 + ceil(4*1.2))  
                true,
        }
            gatewayAllocator
        logger.info("--> Remove three node from zone3");
        logger.info("--> Remove three node from zone3 holding primary and replicas");
        clusterState = addNodes(clusterState, strategy, "zone1", "node1", "node2", "node3");
        }
        assertThat(newState.getRoutingNodes().node("node15").size(), equalTo(4));  
        }
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(40));
            .metadata(metadata)
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING.getKey(),
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        metadata = Metadata.builder(newState.metadata())  
        logger.info("--> start the shards (primaries)");  
        Metadata metadata = Metadata.builder()
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(28));  
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {  
    public void testThreeZoneTwoReplicaLimitsShardAllocationOnOverloadAcrossZones() {
            )
        assertThat(newState.getRoutingNodes().node("node11").size(), equalTo(4));
        logger.info("add another index with 20 shards");
        logger.info("--> Remove node1 from zone");
        logger.info("--> do another reroute, make sure nothing moves");  
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            .build();
            if (v instanceof Integer) settingsBuilder.put(k, (Integer) (v));  
import java.util.Map;
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node13", singletonMap("zone", "zone3"))))
            newState = startInitializingShardsAndReroute(strategy, newState);
        // add the removed node
            .routingTable(initialRoutingTable)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        settingsValue.forEach((k, v) -> {
        newState = strategy.reroute(newState, "reroute");
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(21).numberOfReplicas(2))
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node3", singletonMap("zone", "zone_1"))))
        }  
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(126));
import org.opensearch.cluster.routing.ShardRouting;  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(30));
            )  
        assertThat(newState.getRoutingNodes().node("node11").size(), equalTo(4));
            .nodes(DiscoveryNodes.builder(newState.nodes()).add(newNode("node3", singletonMap("zone", "zone_1"))))
            newState = startInitializingShardsAndReroute(strategy, newState);
        newState = removeNodes(newState, strategy, "node4");
        clusterState = strategy.reroute(clusterState, "reroute");
        while (newState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {  
        clusterState = addNodes(clusterState, strategy, "zone1", "node1", "node2", "node3", "node4", "node5");
        }
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(20));
                .filter(r -> r.unassignedInfo().getReason() == UnassignedInfo.Reason.INDEX_CREATED)  
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
        metadata = Metadata.builder(newState.metadata())  
        logger.info("--> complete relocation");
            newState = startInitializingShardsAndReroute(strategy, newState);  
                    )
                10
                    )
        logger.info("Building initial routing table for 'testSingleZoneOneReplicaLimitsReplicaAllocationOnOverload'");  
                false
                15,  
        newState = strategy.reroute(newState, "reroute");
        RoutingTable updatedRoutingTable = RoutingTable.builder(newState.routingTable()).addAsNew(metadata.index("test1")).build();
        newState = strategy.reroute(newState, "reroute");
        Metadata metadata = Metadata.builder()
                    )  
    public void testThreeZoneTwoReplicaLimitsReplicaAllocationUnderFullZoneFailure() {
            .put(
                .shardsWithState(UNASSIGNED)
        ClusterState newState = removeNodes(clusterState, strategy, "node1", "node2", "node3");  
        logger.info("--> Remove nodes from zone holding primaries");  
    }  
        assertThat(newState.getRoutingNodes().node("node15").size(), equalTo(7));
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING.getKey(),  
    public void testThreeZoneOneReplicaLimitsShardAllocationOnOverload() {
        clusterState = addNodes(clusterState, strategy, "zone_1", "node1", "node2", "node3", "node4", "node5");  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(20).numberOfReplicas(2))
            newState = startInitializingShardsAndReroute(strategy, newState);  
            .build();  
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(60));
        // remove one node to make zone1 skewed
        // add back node3  
            else if (v instanceof Boolean) settingsBuilder.put(k, (Boolean) (v));
        return settingsBuilder.build();
        }  
        }
        logger.info("--> start the shards (primaries)");  
        logger.info("--> replica will not start because we have only one zone value");  
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
        assertThat(newState.getRoutingNodes().node("node13").size(), equalTo(4));  
        assertThat(strategy.reroute(clusterState, "reroute").routingTable(), sameInstance(clusterState.routingTable()));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(18));  
        logger.info("--> do another reroute, make sure nothing moves");
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(60));  
                    .settings(
            .build();  
                "zone_1,zone_2,zone_3"  
            newState = startInitializingShardsAndReroute(strategy, newState);
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(21));
        newState = ClusterState.builder(newState)
        while (clusterState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty() == false) {
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .put(
 * SPDX-License-Identifier: Apache-2.0
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING.getKey(),
            newState = startInitializingShardsAndReroute(strategy, newState);
        clusterState = addNodes(clusterState, strategy, "zone1", "node3", "node4");
        newState = strategy.reroute(newState, "reroute");  
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 20)
        assertThat(newState.getRoutingNodes().node("node13").size(), equalTo(8));  
        assertThat(newState.getRoutingNodes().node("node12").size(), equalTo(4));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        }  
        newState = ClusterState.builder(newState)  
            newState = startInitializingShardsAndReroute(strategy, newState);
        // ensure minority zone doesn't get overloaded
        assertThat(newState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(60));
        logger.info("--> adding two nodes on same rack and do rerouting");
                throw new UnsupportedOperationException("Unsupported type for key :" + k);
        newState = startInitializingShardsAndReroute(strategy, newState);
            Map.of(
    private final Logger logger = LogManager.getLogger(NodeLoadAwareAllocationTests.class);  
        // add the removed node
                "zone1,zone2,zone3"
                15,
        }
            .build();  
        logger.info("Building initial routing table for 'testThreeZoneTwoReplicaLimitsShardAllocationOnOverloadAcrossZones'");
            .put(
        logger.info("--> adding five nodes on same zone and do rerouting");  
        newState = ClusterState.builder(newState)  
