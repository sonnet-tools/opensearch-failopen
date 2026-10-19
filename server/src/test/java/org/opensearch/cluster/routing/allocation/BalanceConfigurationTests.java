            for (ShardRouting shardRouting : routingNode) {  
    /**
    ) {  
            )
        for (int i = 0; i < 4; i++) {
     * This test mimics a cluster state which can not be rebalanced due to  
        strategy = createAllocationService(settings.build(), new TestGatewayAllocator());  
import org.opensearch.core.index.shard.ShardId;
                new ClusterSettings(Settings.Builder.EMPTY_SETTINGS, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                assertThat(node.shardsWithState(index, STARTED).size(), Matchers.greaterThanOrEqualTo(minAvgNumberOfShards));
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)  
        RoutingNodes nodes = clusterState.getRoutingNodes();
            clusterState.getRoutingNodes(),  
            ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
        );
            numberOfReplicas,
                .numberOfReplicas(numberOfReplicas);
            .numberOfReplicas(1);  
        IndexMetadata indexMetadata = getIndexMetadata("test", 2, 1);  
        clusterState = strategy.reroute(clusterState, "reroute");
            discoBuilder = discoBuilder.add(node);  
 * Licensed to Elasticsearch under one or more contributor  
    private final Logger logger = LogManager.getLogger(BalanceConfigurationTests.class);
 * SPDX-License-Identifier: Apache-2.0
            randomAllocationDeciders(  
        for (int i = 0; i < numberOfRuns; i++) {
        assertTrue(replicaShards.get(0).started());
 * not use this file except in compliance with the License.
        );
        AllocationService strategy,
import org.opensearch.Version;
        stateBuilder.routingTable(routingTable.build());
            nodesList.add(node.getId());
        return getSettingsBuilderForPrimaryBalance(true, true);
        clusterState = strategy.reroute(clusterState, "reroute");  
        settings.put(BalancedShardsAllocator.THRESHOLD_SETTING.getKey(), balanceThreshold);
        final int numberOfRuns = 5;  
        int numberOfReplicas,
        RoutingNodes nodes,
                                    allocation.routingNodes().initializeShard(sr, "node0", null, -1, allocation.changes());
        // move initializing to started
        IndexMetadata indexMetadata = getIndexMetadata("test", 3, 1);
            .numberOfShards(numberOfShards)  
import org.apache.lucene.util.ArrayUtil;  
        ClusterState clusterState = initCluster(strategy);
        AllocationService strategy,
     * (node0). Final shard allocation state.
                    .put(SETTING_NUMBER_OF_REPLICAS, replicaCount)
     * This test verifies global balance by creating indices iteratively and verify primary shards do not pile up on one
                assertThat(shardRouting.state(), Matchers.equalTo(ShardRoutingState.STARTED));
        ClusterState clusterState = stateBuilder.build();
                @Override
                                break;
        AllocationService strategy = createAllocationService(settings.build(), new TestGatewayAllocator());  
        final int numberOfRuns = 5;
        for (int i = 0; i < numberOfRuns; i++) {
        routingTableBuilder.addAsNew(index.build());
            .routingTable(initialRoutingTable)  
        settings.put(BalancedShardsAllocator.THRESHOLD_SETTING.getKey(), balanceThreshold);  
     * --------[test0][0], node[node_1], [R], s[STARTED], a[id=E85-jhiEQwuB43u5Wq1mAw]
            }
            numberOfReplicas,
            .routingTable(routingTable)
                /*
    }
     * constraints chosen for allocation.
     * This test verifies primary shard balance is not attained without PREFER_PRIMARY_SHARD_BALANCE setting.
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;  
     -----node_id[node2][V]
        IndexShardRoutingTable.Builder indexShardRoutingBuilder_1 = new IndexShardRoutingTable.Builder(shardId_1);
    public void testGlobalPrimaryBalanceWithNodeDrops() throws Exception {
        assertThat(allocator.getIndexBalance(), Matchers.equalTo(0.2f));  
    private ClusterState applyAllocationUntilNoChange(ClusterState clusterState, AllocationService strategy) {
        clusterState = applyAllocationUntilNoChange(clusterState, strategy);
                                    allocation.routingNodes().initializeShard(sr, "node3", null, -1, allocation.changes());
        // The cluster is balanced when considering indices individually not balanced when considering global state  
        Metadata.Builder metadataBuilder = Metadata.builder();
        routingTable = startInitializingShardsAndReroute(strategy, clusterState).routingTable();
        for (RoutingNode node : nodes) {
        final int numberOfShards = 25;  
                    --------[test][3], node[3], [P], s[STARTED]
        int numberOfNodes,  
                random()  
        assertIndexBalance(  
                unassignedInfo  
    /**  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
                public ShardAllocationDecision decideShardAllocation(ShardRouting shard, RoutingAllocation allocation) {  
            ClusterRebalanceAllocationDecider.ClusterRebalanceType.ALWAYS.toString()
        final int numberOfIndices = 4;
            .metadata(metadata)
     */
            logger.info(ShardAllocations.printShardDistribution(clusterState));
            numberOfIndices,  
        settings.put(BalancedShardsAllocator.PREFER_PRIMARY_SHARD_REBALANCE.getKey(), preferPrimaryRebalance);
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).build();
     * --------[test1][0], node[node_1], [R], s[STARTED], a[id=TDqbfvAfSFK6lnv3aOU9bA]
            IndexMetadata.Builder index = IndexMetadata.builder("test" + i)
        final int avgPrimaryShardsPerNode = (int) Math.ceil(totalPrimaryShards * 1f / clusterState.getRoutingNodes().size());  
        clusterState = addIndex(clusterState, strategy, "test-index1", 1, 1);
     * <p>  
        indexShardRoutingBuilder_0.addShard(TestShardRouting.newShardRouting(shardId_0, nodesList.get(0), true, ShardRoutingState.STARTED));  
        for (RoutingNode routingNode : routingNodes) {
            clusterState.getRoutingNodes(),
        try {
        }
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
        AllocationService strategy = createAllocationService(settingsBuilder.build(), new TestGatewayAllocator());
                                break;  
        discoBuilder.clusterManagerNodeId(newNode("node_0").getId());
    final int numberOfNodes = 25;
        final float shardBalance = 0.45f;
     * the new primary shard assignment lands on the node breaching one constraint(node1), while replica land on the other
            .routingTable(routingTableBuilder.build())  
        settings.put(BalancedShardsAllocator.THRESHOLD_SETTING.getKey(), 2.0);
        clusterState = ClusterState.builder(clusterState)
                .collect(Collectors.toMap(ShardRouting::shardId, s -> 1, (a, b) -> a + b))
        List<String> nodesList = new ArrayList<>(nodes);
            (numberOfNodes + 1) - (numberOfNodes + 1) / 2,
    /**  
    }
     */
        for (int i = 0; i < numberOfNodes; i++) {  
    public void testPrimaryBalance_NotSolved_2() {
        clusterState = removeNodes(clusterState, strategy);  
        AllocationService strategy = createAllocationService(getSettingsBuilderForPrimaryBalance().build(), new TestGatewayAllocator());  
                Settings.builder()
                    .size();  
            }
import org.apache.logging.log4j.LogManager;
        clusterState = ClusterState.builder(clusterState)
    public void testPrimaryBalance_NotSolved_1() {
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
            .build();
            assertThat(node.shardsWithState(STARTED).size(), Matchers.lessThanOrEqualTo(maxAvgNumberOfShards));
        }
    public void testShardBalance() {
        clusterState = addNodes(clusterState, strategy, 5);
                logger.info("Unexpected assertion failure");  
            .build();  
        settings.put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), indexBalance);
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();  
        }
        Settings.Builder settings = Settings.builder();  
            new TestGatewayAllocator()
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());
            balanceThreshold  
     * P1       R1  
        }
                                if (sr.primary()) {  
    }  
            TestShardRouting.newShardRouting(shardId_0, nodesList.get(1), false, ShardRoutingState.STARTED)
            for (RoutingNode node : nodes) {
        AllocationService strategy = createAllocationService(getSettingsBuilderForPrimaryBalance().build(), new TestGatewayAllocator());  
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.getMetadata());
     * ------  --------
                                if (sr.primary()) {
            numberOfReplicas,
                null,
        settings = Settings.builder();
        ShardId shardId_2 = new ShardId(indexMetadata.getIndex(), 2);  
        stateBuilder.routingTable(routingTable.build());
    }  
            ClusterRebalanceAllocationDecider.ClusterRebalanceType.ALWAYS.toString()
        indexRoutingTable_1.addIndexShard(indexShardRoutingBuilder_1.build());
        settings.put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 0.2);
        indexShardRoutingBuilder_1.addShard(
        ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName("test"));
        routingNodes = clusterState.getRoutingNodes();  
        final int numberOfNodes = 4;
            nodes.add(node);
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder();
            clusterState = removeOneNode(clusterState, strategy);  
        final float shardBalance = 0.0f;  
                    ArrayUtil.timSort(drain, (a, b) -> { return a.primary() ? -1 : 1; }); // we have to allocate primaries first
        ClusterState clusterState = stateBuilder.build();
        ClusterSettings service = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        final int maxAvgNumberOfShards = Math.round(Math.round(Math.ceil(avgNumShards + threshold)));
     * logic which applies at index level i.e. balance shards single index across all nodes. This will be solved when
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder();
                    --------[test][1], node[1], [P], s[STARTED]
            .nodes(nodes)
        final int numberOfReplicas = 1;
    }
        routingTable.add(indexRoutingTable);  
        }
            metadataBuilder = metadataBuilder.put(index);  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(clusterState.routingTable());
            numberOfShards,
     * -----node_id[node_1][V]
        int numberOfShards,
                        switch (sr.id()) {  
        stateBuilder.routingTable(routingTable.build());
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.cluster.routing.RoutingNodes;
        indexRoutingTable.addIndexShard(indexShardRoutingBuilder_1.build());
            numberOfIndices,
import org.opensearch.test.gateway.TestGatewayAllocator;  
     * There are two nodes (N1, N2) where all primaries land on N1 while replicas on N2.
                assertThat(shardRouting.state(), Matchers.equalTo(ShardRoutingState.STARTED));
        AllocationService strategy = createAllocationService(getSettingsBuilderForPrimaryBalance().build(), new TestGatewayAllocator());
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            for (ShardRouting shardRouting : routingNode) {
    }
            )  
    public void testPrimaryBalanceSolvedWithPreferPrimaryRebalanceSetting() {  
            .settings(settings(Version.CURRENT))
    }
        // Update settings & apply
        return applyAllocationUntilNoChange(clusterState, strategy);
        clusterState = strategy.reroute(clusterState, "reroute");
                settings.build(),
        // Build index routing table
 */
        stateBuilder.metadata(metadata.generateClusterUuidIfNeeded().build());  
            )
import org.opensearch.snapshots.EmptySnapshotsInfoService;
        IndexShardRoutingTable.Builder indexShardRoutingBuilder_2 = new IndexShardRoutingTable.Builder(shardId_2);
            numberOfNodes,
            TestShardRouting.newShardRouting(
                                    allocation.routingNodes().initializeShard(sr, "node2", null, -1, allocation.changes());
    public void testNoRebalanceOnPrimaryOverload() {  
                    -----node_id[1][V]  
        final float indexBalance = 1.0f;
import java.util.ArrayList;  
        int numberOfNodes = clusterState.getRoutingNodes().size();  
            TestShardRouting.newShardRouting(shardId_1, nodesList.get(1), false, ShardRoutingState.STARTED)
        Settings updatedSettings = getSettingsBuilderForPrimaryBalance().put(  
        final int numberOfReplicas = 1;
        clusterState = addNode(clusterState, strategy);
        // build index metadata  
        return applyAllocationUntilNoChange(clusterState, strategy);
import org.opensearch.cluster.routing.IndexRoutingTable;
            numberOfNodes + 1,
        Metadata metadata = metadataBuilder.build();
            SNAPSHOT_INFO_SERVICE_WITH_NO_SHARD_SIZES
        return getSettingsBuilderForPrimaryBalance(true, false);
            ),
        final int unassigned = nodes.unassigned().size();  
    private ClusterState addIndex(  
        }
        RoutingTable.Builder routingTable = RoutingTable.builder();  
            removed = true;
        ClusterState clusterState,  
        for (int i = 0; i < numberOfIndices; i++) {  
        IndexShardRoutingTable.Builder indexShardRoutingBuilder_1 = new IndexShardRoutingTable.Builder(shardId_1);
            } catch (AssertionError e) {
    private IndexMetadata getIndexMetadata(String indexName, int shardCount, int replicaCount) {
                RecoverySource.PeerRecoverySource.INSTANCE,
    }
        settings.put(BalancedShardsAllocator.THRESHOLD_SETTING.getKey(), 3.0);
    }
     * This test mimics cluster state where re-balancing is not possible due to existing limitation of re-balancing
        }
            .metadata(metadata)  
     * This test mimics a cluster state containing four nodes, where one node breaches two constraints while one breaches
        RoutingTable routingTable = strategy.reroute(clusterState, "reroute").routingTable();
        float threshold
 * KIND, either express or implied.  See the License for the
            settings,
            new TestGatewayAllocator(),
package org.opensearch.cluster.routing.allocation;
        IndexShardRoutingTable.Builder indexShardRoutingBuilder_0 = new IndexShardRoutingTable.Builder(shardId_0);  
        List<ShardRouting> replicaShards = clusterState.routingTable().shardRoutingTable(shardId_2).replicaShards();
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        logger.info("start " + numberOfNodes + " nodes");
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(settings.build(), service);
        logger.info("use the new allocator and check if it moves shards");
     */
                .settings(settings(Version.CURRENT).build())  
    }
        final float shardBalance = 1.0f;
            TestShardRouting.newShardRouting(shardId_0, nodesList.get(1), false, ShardRoutingState.STARTED)  
            clusterState.getRoutingNodes(),
        assertShardBalance(  
            numberOfNodes + 1 - (numberOfNodes + 1) / 2,  
    /**
        IndexMetadata indexMetadata_0 = getIndexMetadata("test0", 1, 1);  
        Settings.Builder settings = Settings.builder();
     * <p>  
        assertThat(allocator.getIndexBalance(), Matchers.equalTo(0.5f));
        }
     * N1        N2
            .build();
     --------[test][1], node[node0], [P], s[STARTED], a[id=7B4dVsrjSoC6imBHO60mrQ]
     * @throws Exception generic exception
        clusterState = strategy.reroute(clusterState, "reroute");
    // TODO maybe we can randomize these numbers somehow  
            routingTableBuilder.addAsNew(cursor);
        final int numShards = numberOfIndices * numberOfShards * (numberOfReplicas + 1) - unassigned;
            logger.info(ShardAllocations.printShardDistribution(clusterState));
        Set<String> nodes = new HashSet<>();  
     * <p>
                .settings(settings(Version.CURRENT))
        assertFalse(balanced);  
        logger.info("rebalancing");  
                 *  // this allocator tries to rebuild this scenario where a rebalance is
    }
 * Unless required by applicable law or agreed to in writing,
            numberOfIndices,
            for (ShardRouting shardRouting : routingNode) {
        for (final IndexMetadata cursor : metadata.indices().values()) {  
        verifyPrimaryBalance(clusterState, buffer);
        );  
            numberOfNodes,  
            clusterSettings,  
        settings.put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 0.3);  
            } catch (AssertionError | Exception e) {
     * P2        R2
        final float balanceThreshold = 1.0f;  
        int numberOfIndices
import org.opensearch.cluster.ClusterName;
        }
        return applyStartedShardsUntilNoChange(clusterState, strategy);  
            balanceThreshold
                UNASSIGNED,
        AllocationService strategy = createAllocationService(getSettingsBuilderForPrimaryBalance().build(), new TestGatewayAllocator());  
        assertThat(allocator.getShardBalance(), Matchers.equalTo(0.3f));
        assertEquals("node0", replicaShards.get(0).currentNodeId());  
        AllocationService strategy = createAllocationService(settings.build(), new TestGatewayAllocator());
                    -----node_id[0][V]  
                                } else {
        final float balanceThreshold = 1.0f;
        assertEquals("node1", primaryShard.currentNodeId());
        clusterState = removeOneNode(clusterState, strategy);  
        // Double check primary shard balance should still work  
            ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),  
        metadata.put(indexMetadata_0, false);  
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());
        for (RoutingNode routingNode : routingNodes) {
                .numberOfReplicas(numberOfReplicas);
        IndexRoutingTable.Builder indexRoutingTable_1 = IndexRoutingTable.builder(indexMetadata_1.getIndex());  
                    --------[test][4], node[0], [R], s[STARTED]
        RoutingTable.Builder routingTable = RoutingTable.builder();
        indexShardRoutingBuilder_1.addShard(
    }  
                balanceFailed++;
            numberOfShards,
        if (removed) {
            clusterState = removeOneNode(clusterState, strategy);  
        );
     * --------[test1][0], node[node_0], [P], s[STARTED], a[id=u7qtyy5AR42hgEa-JpeArg]
        IndexShardRoutingTable.Builder indexShardRoutingBuilder_0 = new IndexShardRoutingTable.Builder(shardId_0);
                                break;
     */  
            clusterState.getRoutingNodes(),
    }  
        int numberOfReplicas,  
import org.apache.logging.log4j.Logger;
            numberOfNodes + 1,
                UNASSIGNED,  
        service.applySettings(settings.build());  
        assertThat(allocator.getShardBalance(), Matchers.equalTo(0.1f));
    }
                                if (sr.primary()) {  
    ) {
        );
/*
        AllocationService strategy,
            numberOfIndices,
        assertTrue(balanceFailed <= 1);  
    }
     * N1        N2
     * This test verifies global balance by creating indices iteratively and verify primary shards do not pile up on one
            ClusterState clusterState = initCluster(strategy, numberOfIndices, numberOfNodes, numberOfShards, numberOfReplicas);
            balanced = false;
            try {
        final int numberOfNodes = 4;
    /**  
        }
     * --------[test][1], node[node_1], [R], s[STARTED], a[id=zZI0R8FBQkWMNndEZt9d8w]
        ClusterState clusterState = initCluster(strategy);
        metadata.put(indexMetaDataBuilder.build(), false);
        indexShardRoutingBuilder_0.addShard(TestShardRouting.newShardRouting(shardId_0, nodesList.get(0), true, ShardRoutingState.STARTED));
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
            }
        ShardId shardId_0 = new ShardId(indexMetadata.getIndex(), 0);
                assertTrue(primaryCount <= avgPrimaryShardsPerNode);
        int numberOfReplicas
                                    allocation.routingNodes().initializeShard(sr, "node1", null, -1, allocation.changes());  
    private Settings.Builder getSettingsBuilderForPrimaryBalance(boolean preferPrimaryBalance, boolean preferPrimaryRebalance) {
        }  
            nodes.add(node.getId());
        assertShardBalance(
        for (RoutingNode routingNode : routingNodes) {
        logger.info("rebalancing");
        IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(indexMetadata.getIndex());  
        final int numberOfReplicas = 1;
            discoBuilder = discoBuilder.add(node);  
        assertThat(allocator.getThreshold(), Matchers.equalTo(2.0f));  
        boolean balanced = true;
        }
     -----node_id[node0][V]
        IndexShardRoutingTable indexShardRoutingTable_0 = indexShardRoutingBuilder_0.build();  
        ClusterState clusterState,
    private void assertShardBalance(
                                break;
        return IndexMetadata.builder(indexName)  
    private ClusterState removeOneNode(ClusterState clusterState, AllocationService strategy) {  
    }
        clusterState = addNode(clusterState, strategy);
            ClusterState clusterState = initCluster(strategy, numberOfIndices, numberOfNodes, numberOfShards, numberOfReplicas);
import org.opensearch.cluster.EmptyClusterInfoService;
            balanceThreshold
        boolean removed = false;
            nodes.remove("node" + i);  
            IndexMetadata.Builder index = IndexMetadata.builder("test" + i)
                            case 0:
        int numberOfNodes,  
            discoBuilder = discoBuilder.add(node);  
        logger.info("complete rebalancing");  
            .build();
            ClusterRebalanceAllocationDecider.ClusterRebalanceType.ALWAYS.toString()
        clusterState = applyAllocationUntilNoChange(clusterState, strategy);
            } catch (AssertionError e) {
    public void testPrimaryBalance() {
        final int numberOfIndices = 5;
        final int numberOfNodes = 5;
            clusterState = strategy.disassociateDeadNodes(clusterState, randomBoolean(), "removed nodes");  
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
     * This test verifies primary shard balance is attained  setting.
        assertThat(allocator.getIndexBalance(), Matchers.equalTo(0.2f));
    private ClusterState initCluster(  
     */
        assertTrue(balanceFailed <= 1);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
        settings.put(BalancedShardsAllocator.THRESHOLD_SETTING.getKey(), 2.0);  
        AllocationService strategy = createAllocationService(getSettingsBuilderForPrimaryBalance().build(), new TestGatewayAllocator());  
            .numberOfShards(5)
        discoBuilder.localNodeId(newNode("node_0").getId());  
        int numberOfReplicas
                assertThat(shardRouting.state(), Matchers.equalTo(ShardRoutingState.INITIALIZING));  
        RoutingTable.Builder routingTable = RoutingTable.builder();  
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
            numberOfShards,
            DiscoveryNode node = newNode("node" + i);  
        AllocationService strategy = createAllocationService(getSettingsBuilderForPrimaryReBalance().build(), new TestGatewayAllocator());  
    private ClusterState removeNodes(ClusterState clusterState, AllocationService strategy) {
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            .metadata(metadataBuilder.build())
            totalPrimaryShards += index.primaryShardsActive();
    /**  
     * Please note, P1, P2 belongs to different index
        settings = Settings.builder();
        verifyPerIndexPrimaryBalance(clusterState);  
        );  
        // build index metadata
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
 * software distributed under the License is distributed on an
        routingNodes = clusterState.getRoutingNodes();
        indexShardRoutingBuilder_0.addShard(TestShardRouting.newShardRouting(shardId_0, nodesList.get(0), true, ShardRoutingState.STARTED));
        settings.put(BalancedShardsAllocator.PREFER_PRIMARY_SHARD_BALANCE.getKey(), preferPrimaryBalance);
                final int primaryCount = node.shardsWithState(index.getKey(), STARTED)
import org.hamcrest.Matchers;
            EmptyClusterInfoService.INSTANCE,
            logger.info(ShardAllocations.printShardDistribution(clusterState));
        clusterState = addIndex(clusterState, strategy, "test-index3", 1, 1);  
        indexShardRoutingBuilder_1.addShard(TestShardRouting.newShardRouting(shardId_1, nodesList.get(0), true, ShardRoutingState.STARTED));  
    public void testPrimaryBalanceWithContrainstBreaching() {
            try {
        int totalPrimaryShards = 0;
                                break;
        for (int i = 0; i < numberOfRuns; i++) {
        routingNodes = clusterState.getRoutingNodes();
    }  
 * The OpenSearch Contributors require contributions made to  
        Settings.Builder settingsBuilder = getSettingsBuilderForPrimaryBalance();
            }
            metadataBuilder = metadataBuilder.put(index);  
 *     http://www.apache.org/licenses/LICENSE-2.0
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
                                }  
import static org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING;
                    routing_nodes:
        for (int i = 0; i < 4; i++) {
    /**  
        for (final IndexRoutingTable index : clusterState.getRoutingTable().indicesRouting().values()) {  
            try {
        int numberOfShards,
        return applyStartedShardsUntilNoChange(clusterState, strategy);
        int numberOfShards,  
            TestShardRouting.newShardRouting(shardId_1, nodesList.get(1), false, ShardRoutingState.STARTED)
        );
            clusterState.getRoutingTable(),  
        metadata.put(indexMetadata_1, false);
        final int numShards = numberOfShards * (numberOfReplicas + 1);
     -----node_id[node3][V]  
        }
        discoBuilder.clusterManagerNodeId(newNode("node_0").getId());
                assertThat(node.shardsWithState(index, STARTED).size(), Matchers.lessThanOrEqualTo(maxAvgNumberOfShards));  
     * primary shard count across indices, constraint is added.  
            ClusterState clusterState = initCluster(strategy, numberOfIndices, numberOfNodes, numberOfShards, numberOfReplicas);
        List<String> nodesList = new ArrayList<>();  
import org.opensearch.common.settings.ClusterSettings;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        settings.put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), shardBalance);  
        logger.info(ShardAllocations.printShardDistribution(clusterState));
        final float avgNumShards = (float) (numShards) / (float) (numberOfNodes);
        Settings.Builder settings = Settings.builder();
                balanceFailed++;
        ShardId shardId_0 = new ShardId(indexMetadata.getIndex(), 0);
        ShardId shardId_0 = new ShardId(indexMetadata_0.getIndex(), 0);
        clusterState = strategy.reroute(clusterState, "reroute");
            }
            }
        settings.put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 0.3);
        settings.put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 0.5);  
        for (final Map.Entry<String, IndexRoutingTable> index : currentState.getRoutingTable().indicesRouting().entrySet()) {  
                    -----node_id[2][V]
            TestShardRouting.newShardRouting(shardId_0, nodesList.get(1), false, ShardRoutingState.STARTED)
        settings.put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 0.2);
     * @throws Exception generic exception
        indexRoutingTable.addIndexShard(indexShardRoutingBuilder_0.build());
     * ------  --------  
                                } else {
        ).build();  
                null,
        metadata.persistentSettings(settingsBuilder.build());
    }
import org.opensearch.cluster.node.DiscoveryNode;
        routingTable.add(indexRoutingTable);
import org.opensearch.cluster.metadata.IndexMetadata;  
import org.opensearch.cluster.routing.ShardRoutingState;
        final int numberOfRuns = 5;
        Set<String> nodes = new HashSet<>();  
    }  
     * that other two nodes (node0, node1) have all shards assignments resulting in constraints breach. Test asserts that  
        assertTrue(primaryShard.started());
        int numberOfNodes,  
        }
     * This test verifies primary shard balance is attained with PREFER_PRIMARY_SHARD_BALANCE setting.
        final float avgNumShards = (float) (numShards) / (float) (numberOfNodes);
import org.opensearch.cluster.ClusterState;  
        clusterState = strategy.disassociateDeadNodes(clusterState, randomBoolean(), "removed nodes");
public class BalanceConfigurationTests extends OpenSearchAllocationTestCase {  
    }
                            case 1:
        }
        Metadata.Builder metadata = Metadata.builder();
            }  
import org.opensearch.cluster.routing.TestShardRouting;  
    ) {  
import org.opensearch.cluster.routing.allocation.allocator.ShardsAllocator;  
                RecoverySource.EmptyStoreRecoverySource.INSTANCE,
                    ShardRouting[] drain = unassigned.drain();  
            final int primaryCount = node.shardsWithState(STARTED)
            }
     * -----node_id[node_1][V]  
    private ClusterState addIndices(
            // (i.e. unassigned count is always [replicas] + 1 for each shard unassigned shardId)
            clusterState.getRoutingTable(),
        for (int i = 0; i < 2; i++) {
                                    allocation.routingNodes().initializeShard(sr, "node0", null, -1, allocation.changes());  
                    --------[test][3], node[1], [R], s[STARTED]  
     * This test verifies primary shard balance is attained with PREFER_PRIMARY_SHARD_BALANCE setting.
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
        for (int i = (numberOfNodes + 1) / 2; i <= numberOfNodes; i++) {
        }
        assertShardBalance(
        clusterState = strategy.reroute(clusterState, "indices-created");
        );  
    private Settings.Builder getSettingsBuilderForPrimaryReBalance() {
        IndexMetadata indexMetadata_1 = getIndexMetadata("test1", 1, 1);
        routingTable.add(indexRoutingTable_0);
                    --------[test][4], node[2], [P], s[STARTED]
                .stream()  
        ClusterState clusterState = stateBuilder.build();
        for (int i = 0; i < numberOfNodes; i++) {  
        final float indexBalance = 0.55f;  
     * --------[test][1], node[node_0], [P], s[STARTED], a[id=xqfZSToVSQaff2xvuxh_yA]
     *  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            final int avgPrimaryShardsPerNode = (int) Math.ceil(totalPrimaryShards * 1f / currentState.getRoutingNodes().size());
                assertThat(shardRouting.state(), Matchers.equalTo(ShardRoutingState.STARTED));  
        indexMetaDataBuilder.putInSyncAllocationIds(1, indexShardRoutingTable_1.getAllAllocationIds());
            }
            numberOfShards,
                                if (sr.primary()) {
                verifyPerIndexPrimaryBalance(clusterState);  
import java.util.HashSet;
import java.util.Map;  
        settings.put(  
        indexShardRoutingBuilder_0.addShard(
                balanceFailed++;
        IndexShardRoutingTable.Builder indexShardRoutingBuilder_0 = new IndexShardRoutingTable.Builder(shardId_0);
     */  
        );  
                verifyPrimaryBalance(clusterState, buffer);  
        routingTable = startInitializingShardsAndReroute(strategy, clusterState).routingTable();  
                logger.info("Expected assertion failure");  
                .forEach(count -> assertEquals(numberOfReplicas + 1, count.longValue()));  
                false,
        stateBuilder.nodes(discoBuilder);
            nodes.add(newNode("node" + (clusterState.nodes().getSize() + i)));
        AllocationService strategy = createAllocationService(getSettingsBuilderForPrimaryReBalance().build(), new TestGatewayAllocator());  
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            for (RoutingNode node : nodes) {
        for (final IndexMetadata cursor : metadata.indices().values()) {
        } catch (AssertionError e) {  
        ShardId shardId_1 = new ShardId(indexMetadata.getIndex(), 1);  
        metadataBuilder = metadataBuilder.put(indexMeta);
     *  
                unassignedInfo
        settings.put(
        assertIndexBalance(
        }
            .build();
     * <p>  
 *  
        final int numberOfNodes = 5;
        ClusterState clusterState = initCluster(strategy);
    ) {
        final int numberOfRuns = 5;
    final int numberOfIndices = 12;
     * P1        R1
        );
                 *  // triggered solely by the primary overload on node [1] where a shard  
        indexShardRoutingBuilder_0.addShard(
                            case 2:  
    private ClusterState addNodes(ClusterState clusterState, AllocationService strategy, int numberOfNodes) {  
                */  
        assertEquals(1, replicaShards.size());
        assertTrue(balanceFailed >= 4);  
        settings.put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), shardBalance);
        nodes.remove("node0");
        indexShardRoutingBuilder_2.addShard(
        }  
        }
            routingTableBuilder.addAsNew(cursor);
        int numberOfIndices,
                logger.info("Unexpected assertion failure");  
        logger.info(ShardAllocations.printShardDistribution(clusterState));  
}
     */
                shardId_2,
            numberOfReplicas,  
    private ClusterState addNode(ClusterState clusterState, AllocationService strategy) {
        }  
        RoutingNodes nodes,
        settings.put(
                .size();  
        logger.info("now, start 1 more node, check that rebalancing will happen because we set it to always");  
                true,  
        return applyAllocationUntilNoChange(clusterState, strategy);
        for (int i = 0; i < numberOfIndices; i++) {
    final int numberOfShards = 2;  
     * --------[test0][0], node[node_0], [P], s[STARTED], a[id=BQrLSo6sQyGlcLdVvGgqLQ]
                                if (sr.primary()) {
                    .collect(Collectors.toList())
                                }  
     * -----node_id[node_0][V]
                                    allocation.routingNodes().initializeShard(sr, "node2", null, -1, allocation.changes());
        settings.put(BalancedShardsAllocator.THRESHOLD_SETTING.getKey(), balanceThreshold);
        AllocationService strategy = new AllocationService(
                    for (ShardRouting sr : drain) {
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());
            clusterState.getRoutingNodes(),
        int balanceFailed = 0;  
            new TestGatewayAllocator(),
        stateBuilder.nodes(discoBuilder);
        /* Tests balance over indices only */
    public void testPersistedSettings() {
 * specific language governing permissions and limitations
        final int numberOfShards = 25;  
        Settings.Builder settings = Settings.builder();
        int numberOfReplicas,
        final float balanceThreshold = 1.0f;
    private static void verifyPrimaryBalance(ClusterState clusterState, float buffer) {  
    }
        );  
        logger.info(ShardAllocations.printShardDistribution(clusterState));
        assertThat(allocator.getThreshold(), Matchers.equalTo(2.0f));
        indexMetaDataBuilder.putInSyncAllocationIds(0, indexShardRoutingTable_0.getAllAllocationIds());  
            new ShardsAllocator() {  
                                }
     */
import org.opensearch.cluster.routing.RoutingTable;  
            final DiscoveryNode node = newNode("node_" + i);
 * Modifications Copyright OpenSearch Contributors. See
                balanceFailed++;
        UnassignedInfo unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null);
        Metadata.Builder metadataBuilder = Metadata.builder();
 * this file be licensed under the Apache-2.0 license or a
        return applyAllocationUntilNoChange(clusterState, strategy);  
            numberOfShards,  
    }
        metadata.put(indexMetadata, false);
            final DiscoveryNode node = newNode("node_" + i);
            numberOfIndices,
import java.util.Set;
    }  
            getSettingsBuilderForPrimaryBalance(false, false).build(),
    final int numberOfReplicas = 2;
        int balanceFailed = 0;
        ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName("test"));
        }
        }
            nodes.shardsWithState(UNASSIGNED)
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        for (int i = 0; i < numberOfRuns; i++) {
        int numberOfShards,  
import java.util.List;
 * the Apache License, Version 2.0 (the "License"); you may
                .values()
     --------[test][1], node[node1], [R], s[STARTED], a[id=ChWdQiOdSdKrTPxwceIu1w]
 * this work for additional information regarding copyright
            assertTrue(primaryCount <= (avgPrimaryShardsPerNode * (1 + buffer)));
/*  
        clusterState = addIndex(clusterState, strategy, "test-index2", 1, 1);
                    --------[test][1], node[2], [R], s[STARTED]
            ClusterState clusterState = initCluster(strategy, numberOfIndices, numberOfNodes, numberOfShards, numberOfReplicas);
 * under the License.  
            // Ensure that if there any unassigned shards, all of their replicas are unassigned as well  
        clusterState = addNode(clusterState, strategy);
            } catch (AssertionError | Exception e) {
        verifyPerIndexPrimaryBalance(clusterState);  
     * This test verifies the allocation logic when nodes breach multiple constraints and ensure node breaching min
        for (RoutingNode routingNode : routingNodes) {  
                            case 4:
     */
        if (unassigned > 0) {
    public void testPrimaryBalanceWithPreferPrimaryBalanceSetting() {  
        );
        ShardId shardId_1 = new ShardId(indexMetadata_1.getIndex(), 0);
        IndexMetadata.Builder indexMeta = IndexMetadata.builder("test")  
     * --------[test][0], node[node_1], [R], s[STARTED], a[id=8IpwEMQ2QEuj5rQOxBagSA]  
        metadataBuilder = metadataBuilder.put(index);  
     * -----node_id[node_0][V]  
     */
        ShardId shardId_1 = new ShardId(indexMetadata.getIndex(), 1);
            verifyPerIndexPrimaryBalance(clusterState);
    private ClusterState initCluster(AllocationService strategy) {
        clusterState = ClusterState.builder(clusterState)  
        int numberOfIndices,
            final int totalPrimaryShards = index.getValue().primaryShardsActive();
        final int maxAvgNumberOfShards = Math.round(Math.round(Math.ceil(avgNumShards + threshold)));
            .settings(
    }
/*  
        settings.put(
        stateBuilder.nodes(discoBuilder);
    private void verifyPerIndexPrimaryBalance(ClusterState currentState) {
                logger.info("Unexpected assertion failure");  
        }
     * <p>
        clusterState = strategy.reroute(clusterState, "index-created");
    public void testGlobalPrimaryBalance() throws Exception {
        return applyAllocationUntilNoChange(clusterState, strategy);  
        IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(indexMetadata.getIndex());
                shardId_2,  
        // Mark node2, node 3 excluded (FilterAllocationDecider) so that all allocations land on node 0, node 1  
     -----node_id[node1][V]
import org.opensearch.cluster.routing.RoutingNode;
        int numberOfIndices,
        indexRoutingTable.addIndexShard(indexShardRoutingBuilder_2.build());
            EmptySnapshotsInfoService.INSTANCE
                .filter(ShardRouting::primary)
                                    allocation.routingNodes().initializeShard(sr, "node2", null, -1, allocation.changes());  
        );  
        RoutingTable routingTable = routingTableBuilder.build();  
        Settings.Builder settings = Settings.builder();  
     routing_nodes:
                    --------[test][2], node[3], [P], s[STARTED]  
                    }
                                    allocation.routingNodes().initializeShard(sr, "node1", null, -1, allocation.changes());
        Metadata metadata = metadataBuilder.build();  
    }  
        stateBuilder.metadata(metadata.generateClusterUuidIfNeeded().build());  
                .stream()  
        logger.info("start the replica shards");  
            balanceThreshold
        }
 *
        IndexShardRoutingTable.Builder indexShardRoutingBuilder_1 = new IndexShardRoutingTable.Builder(shardId_1);  
            BalancedShardsAllocator.PRIMARY_SHARD_REBALANCE_BUFFER.get(settings) + 0.01f
        return initCluster(strategy, numberOfIndices, numberOfNodes, numberOfShards, numberOfReplicas);  
        );
        logger.info("start all the primary shards, replicas will start initializing");  
            try {
    }
                    --------[test][0], node[1], [P], s[STARTED]
        return applyStartedShardsUntilNoChange(clusterState, strategy);
     --------[test][2], node[node1], [P], s[STARTED], a[id=QWN_T6xpQiWGSD8GJnX-bQ]  
        final int minAvgNumberOfShards = Math.round(Math.round(Math.floor(avgNumShards - threshold)));  
     * <p>  
        settingsBuilder.put("cluster.routing.allocation.exclude._id", "node2,node3");
        }
                    .stream()  
        );  
    /**  
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
                null,
                    ---- unassigned
        );  
            .nodes(nodes)
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).build();  
                verifyPerIndexPrimaryBalance(clusterState);  
        assertEquals(numberOfNodes, nodes.size());
        clusterState = addNode(clusterState, strategy);
        return settings;
        for (int i = 0; i < numberOfRuns; i++) {
 */  
 */  
        assertTrue(balanceFailed <= 1);  
import org.opensearch.cluster.node.DiscoveryNodes;  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(clusterState.routingTable());
                                }
 * compatible open source license.
import org.opensearch.cluster.routing.ShardRouting;
        Metadata.Builder metadata = Metadata.builder();  
        indexShardRoutingBuilder_1.addShard(
            .build();  
        int numberOfShards,
    ) {
        service.applySettings(settings.build());  
            clusterState.getRoutingNodes(),  
        );
        final int minAvgNumberOfShards = Math.round(Math.round(Math.floor(avgNumShards - threshold)));  
        clusterState = ClusterState.builder(clusterState).nodes(nodes.build()).build();
        clusterSettings.applySettings(updatedSettings);
            .metadata(metadataBuilder.build())
        }
            ClusterState clusterState = initCluster(strategy, numberOfIndices, numberOfNodes, numberOfShards, numberOfReplicas);
            TestShardRouting.newShardRouting(
            }
    }  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
     * <p>  
import java.util.stream.Collectors;
        verifyPerIndexPrimaryBalance(clusterState);  
        );
        final float indexBalance = 0.0f;
    /**  
        clusterState = ClusterState.builder(clusterState).nodes(nodes.build()).build();  
                                    allocation.routingNodes().initializeShard(sr, "node3", null, -1, allocation.changes());  
        discoBuilder.clusterManagerNodeId(newNode("node_0").getId());
            ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),  
            .routingTable(routingTableBuilder.build())
                 *  // is rebalanced to node 0
     * {@link org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider}
import org.opensearch.cluster.routing.RecoverySource;  
        clusterState = addIndices(clusterState, strategy, 5, 1, 8);
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            logger.info(ShardAllocations.printShardDistribution(clusterState));
        indexRoutingTable.addIndexShard(indexShardRoutingBuilder_1.build());  
     * P2       R2
            clusterState.getRoutingTable(),
            clusterState = removeOneNode(clusterState, strategy);  
                            case 3:
                }  
        float threshold
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.getMetadata());  
                    --------[test][2], node[2], [R], s[STARTED]  
        assertTrue(balanceFailed >= 4);  
import org.opensearch.common.settings.Settings;  
    public void testIndexBalance() {  
                                } else {
        logger.info(ShardAllocations.printShardDistribution(clusterState));  
                    .filter(ShardRouting::primary)
        final float buffer = 0.10f;  
        indexShardRoutingBuilder_2.addShard(  
    public void testPrimaryBalanceNotSolvedForNodeDropWithPreferPrimaryBalanceSetting() {  
            numberOfShards,  
 *
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        String indexName,  
 * You may obtain a copy of the License at  
            clusterState = removeOneNode(clusterState, strategy);  
    public void testPrimaryBalanceWithoutPreferPrimaryBalanceSetting() {  
                null,  
        final int numberOfReplicas = 1;
        for (int i = 0; i < 2; i++) {
import org.opensearch.cluster.routing.UnassignedInfo;
    /**  
        indexShardRoutingBuilder_0.addShard(
        settings.put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 0.1);
            numberOfIndices,  
        IndexShardRoutingTable indexShardRoutingTable_1 = indexShardRoutingBuilder_1.build();
        final int numberOfIndices = 4;
        RoutingTable initialRoutingTable = routingTableBuilder.build();
                }
            ClusterRebalanceAllocationDecider.ClusterRebalanceType.ALWAYS.toString()  
     --------[test][0], node[node1], [R], s[STARTED], a[id=5Adc5JteQ8-lY2xfsHUg-Q]
            ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
            final DiscoveryNode node = newNode("node" + i);
        );  
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();  
        clusterState = strategy.reroute(clusterState, "reroute");
            balanceThreshold
                                    allocation.routingNodes().initializeShard(sr, "node1", null, -1, allocation.changes());
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
        ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName("test"));
    }  
        assertIndexBalance(
        final int numberOfShards = 4;  
            logger.info(ShardAllocations.printShardDistribution(clusterState));
        stateBuilder.metadata(metadata.generateClusterUuidIfNeeded().build());  
        indexShardRoutingBuilder_1.addShard(TestShardRouting.newShardRouting(shardId_1, nodesList.get(0), true, ShardRoutingState.STARTED));  
        clusterState = ClusterState.builder(clusterState).nodes(nodes.build()).build();  
        final int numberOfIndices = 5;
                verifyPrimaryBalance(clusterState, buffer);  
            .numberOfReplicas(numberOfReplicas);
                .numberOfShards(numberOfShards)  
                                } else {  
            nodes.add(newNode("node" + i));
                    RoutingNodes.UnassignedShards unassigned = allocation.routingNodes().unassigned();
                                }
        for (final String index : routingTable.indicesRouting().keySet()) {  
        indexShardRoutingBuilder_1.addShard(TestShardRouting.newShardRouting(shardId_1, nodesList.get(0), true, ShardRoutingState.STARTED));
        AllocationService strategy = createAllocationService(  
            .settings(settings(Version.CURRENT))
        indexRoutingTable.addIndexShard(indexShardRoutingBuilder_0.build());  
            assertThat(node.shardsWithState(STARTED).size(), Matchers.greaterThanOrEqualTo(minAvgNumberOfShards));
                .collect(Collectors.toList())
                                } else {
        );  
        routingTable.add(indexRoutingTable_1);  
     --------[test][2], node[node0], [R], s[STARTED], a[id=pB3iuLKZSC--2yNS0trbgA]
        final int numberOfShards = 4;  
    private void assertIndexBalance(  
                    -----node_id[3][V]
            clusterState = removeOneNode(clusterState, strategy);  
        }
        IndexMetadata.Builder indexMetaDataBuilder = IndexMetadata.builder(indexMetadata);
     * --------[test][0], node[node_0], [P], s[STARTED], a[id=VGjOeBGdSmu3pJR6T7v29A]  
     * only one. In order to have nodes breach constraints, test excludes two nodes (node2, node3) from allocation so
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        IndexRoutingTable.Builder indexRoutingTable_0 = IndexRoutingTable.builder(indexMetadata_0.getIndex());
    }  
            TestShardRouting.newShardRouting(shardId_1, nodesList.get(1), false, ShardRoutingState.STARTED)  
        settings.put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), shardBalance);  
        clusterState = removeNodes(clusterState, strategy);
                    --------[test][0], node[0], [R], s[STARTED]
        clusterState = addNode(clusterState, strategy);
            for (ShardRouting shardRouting : routingNode) {
        indexRoutingTable_0.addIndexShard(indexShardRoutingBuilder_0.build());
    }
        ShardRouting primaryShard = clusterState.routingTable().shardRoutingTable(shardId_2).primaryShard();
        RoutingTable routingTable,
                verifyPerIndexPrimaryBalance(clusterState);  
            routingTableBuilder.addAsNew(index.build());
    private Settings.Builder getSettingsBuilderForPrimaryBalance() {  
 * GitHub history for details.
        Metadata.Builder metadata = Metadata.builder();
        discoBuilder.localNodeId(newNode("node_0").getId());  
     * This test verifies that with only primary shard balance, the primary shard distribution per index is balanced.  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
                .numberOfShards(numberOfShards)
        int balanceFailed = 0;
            numberOfReplicas,
            } catch (AssertionError e) {
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())  
        AllocationService strategy = createAllocationService(
        /* Tests balance over replicas only */  
                public void allocate(RoutingAllocation allocation) {
            },  
        IndexMetadata.Builder index = IndexMetadata.builder(indexName)
                    throw new UnsupportedOperationException("explain not supported");
     * allocation decider which prevents shard relocation, leaving cluster unbalanced on primaries.
        logger.info(ShardAllocations.printShardDistribution(clusterState));
        Settings settings = getSettingsBuilderForPrimaryBalance().build();
        settings.put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), indexBalance);
        );
        discoBuilder.localNodeId(newNode("node_0").getId());  
 * license agreements. See the NOTICE file distributed with
        assertThat(allocator.getShardBalance(), Matchers.equalTo(0.3f));
                        }  
            balanceThreshold  
        for (RoutingNode node : nodes) {  
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
        int balanceFailed = 0;
                    .put(SETTING_NUMBER_OF_SHARDS, shardCount)
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();  
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node" + clusterState.getRoutingNodes().size())))
        logger.info(ShardAllocations.printShardDistribution(clusterState));  
        logger.info("start the replica shards");  
        verifyPerIndexPrimaryBalance(clusterState);
            try {
        }  
    }  
            nodes.add(node.getId());
        // build index metadata
            BalancedShardsAllocator.PRIMARY_SHARD_REBALANCE_BUFFER.getKey(),
import org.opensearch.cluster.metadata.Metadata;
        verifyPrimaryBalance(clusterState, 0.0f);  
                balanceFailed++;
        RoutingNodes nodes = currentState.getRoutingNodes();
        clusterState = removeNodes(clusterState, strategy);  
        verifyPrimaryBalance(clusterState, buffer);
        final float buffer = 0.10f;  
     --------[test][0], node[node0], [P], s[STARTED], a[id=0HySaPcyRhiKrH6QLA3evw]  
        logger.info("now, start [{}] more node, check that rebalancing will happen because we set it to always", numberOfNodes);
        List<String> nodesList = new ArrayList<>(nodes);
        assertThat(allocator.getThreshold(), Matchers.equalTo(3.0f));  
        settings.put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), indexBalance);  
            numberOfReplicas,  
        final float buffer = 0.10f;
        logger.info("Removing half the nodes (" + (numberOfNodes + 1) / 2 + ")");
                logger.info("Unexpected assertion failure");  
