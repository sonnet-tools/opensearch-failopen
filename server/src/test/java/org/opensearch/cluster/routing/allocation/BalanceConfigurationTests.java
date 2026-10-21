        clusterState = strategy.disassociateDeadNodes(clusterState, randomBoolean(), "removed nodes");
    private ClusterState addNodes(ClusterState clusterState, AllocationService strategy, int numberOfNodes) {
import java.util.HashSet;
                                break;
 * this work for additional information regarding copyright
        final float indexBalance = 1.0f;
        for (int i = 0; i < numberOfRuns; i++) {
                null,
            numberOfReplicas,
                    }
        ShardId shardId_0 = new ShardId(indexMetadata.getIndex(), 0);
        stateBuilder.metadata(metadata.generateClusterUuidIfNeeded().build());
        RoutingTable routingTable,
            numberOfShards,
            .metadata(metadataBuilder.build())
        List<String> nodesList = new ArrayList<>();
        assertEquals("node1", primaryShard.currentNodeId());
            final int avgPrimaryShardsPerNode = (int) Math.ceil(totalPrimaryShards * 1f / currentState.getRoutingNodes().size());
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder();
     * (node0). Final shard allocation state.
        Metadata.Builder metadata = Metadata.builder();
    }
    public void testPrimaryBalanceWithContrainstBreaching() {
        }
        AllocationService strategy = createAllocationService(
import java.util.Map;
            } catch (AssertionError e) {
    }
        indexShardRoutingBuilder_0.addShard(
                                } else {
    /**
        indexShardRoutingBuilder_2.addShard(
            ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
import org.opensearch.cluster.routing.IndexRoutingTable;
    }
            )
 * license agreements. See the NOTICE file distributed with
     * ------  --------
     * N1        N2
                balanceFailed++;
        assertThat(allocator.getShardBalance(), Matchers.equalTo(0.3f));
        assertThat(allocator.getThreshold(), Matchers.equalTo(2.0f));
                .stream()
    final int numberOfShards = 2;
/*
        RoutingTable.Builder routingTable = RoutingTable.builder();
        ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName("test"));
     --------[test][0], node[node1], [R], s[STARTED], a[id=5Adc5JteQ8-lY2xfsHUg-Q]
        AllocationService strategy = createAllocationService(
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(settings.build(), service);
    /**
        // build index metadata
        // The cluster is balanced when considering indices individually not balanced when considering global state
                */
                 *  // triggered solely by the primary overload on node [1] where a shard
}
        settings.put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), shardBalance);
        /* Tests balance over replicas only */
                .settings(settings(Version.CURRENT))
        final float buffer = 0.10f;
        strategy = createAllocationService(settings.build(), new TestGatewayAllocator());
            nodes.add(node.getId());
 * specific language governing permissions and limitations
    }
        final int maxAvgNumberOfShards = Math.round(Math.round(Math.ceil(avgNumShards + threshold)));
        IndexShardRoutingTable.Builder indexShardRoutingBuilder_0 = new IndexShardRoutingTable.Builder(shardId_0);
                                if (sr.primary()) {
     * P1       R1
            balanceThreshold
            discoBuilder = discoBuilder.add(node);
     * P1        R1
        final int numberOfRuns = 5;
            clusterState = removeOneNode(clusterState, strategy);
        for (int i = 0; i < 2; i++) {
    }
            clusterState.getRoutingNodes(),
/*
                            case 4:
        );
        clusterState = ClusterState.builder(clusterState).nodes(nodes.build()).build();
        IndexMetadata.Builder indexMetaDataBuilder = IndexMetadata.builder(indexMetadata);
                null,
 * KIND, either express or implied.  See the License for the
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        final int numberOfIndices = 5;
            try {
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
import org.opensearch.cluster.EmptyClusterInfoService;
                        }
     * <p>
        settings.put(BalancedShardsAllocator.THRESHOLD_SETTING.getKey(), 3.0);
        logger.info("rebalancing");
        );
        final float shardBalance = 0.45f;
        final int numberOfRuns = 5;
        for (RoutingNode routingNode : routingNodes) {
        settings.put(BalancedShardsAllocator.PREFER_PRIMARY_SHARD_BALANCE.getKey(), preferPrimaryBalance);
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        }
     */
                            case 1:
        final float balanceThreshold = 1.0f;
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
        IndexMetadata indexMetadata_1 = getIndexMetadata("test1", 1, 1);
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).build();
            }
        for (int i = 0; i < numberOfRuns; i++) {
import org.opensearch.cluster.metadata.Metadata;
                null,
        String indexName,
            numberOfIndices,
    // TODO maybe we can randomize these numbers somehow
            nodes.add(node);
        assertThat(allocator.getThreshold(), Matchers.equalTo(3.0f));
            .metadata(metadata)
        for (RoutingNode routingNode : routingNodes) {
            logger.info(ShardAllocations.printShardDistribution(clusterState));
        routingTable.add(indexRoutingTable_0);
            verifyPerIndexPrimaryBalance(clusterState);
        final int numberOfShards = 4;
    private Settings.Builder getSettingsBuilderForPrimaryBalance() {
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.getMetadata());
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
     * allocation decider which prevents shard relocation, leaving cluster unbalanced on primaries.
    }
        final int numberOfNodes = 4;
            clusterState.getRoutingNodes(),
                            case 3:
        settings.put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), indexBalance);
        return applyStartedShardsUntilNoChange(clusterState, strategy);
            // (i.e. unassigned count is always [replicas] + 1 for each shard unassigned shardId)
            clusterState = removeOneNode(clusterState, strategy);
        indexShardRoutingBuilder_0.addShard(
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
                assertTrue(primaryCount <= avgPrimaryShardsPerNode);
     * <p>
        verifyPerIndexPrimaryBalance(clusterState);
            (numberOfNodes + 1) - (numberOfNodes + 1) / 2,
            .build();
    private ClusterState addIndex(
                    .filter(ShardRouting::primary)
        for (RoutingNode node : nodes) {
            final int totalPrimaryShards = index.getValue().primaryShardsActive();
            ClusterRebalanceAllocationDecider.ClusterRebalanceType.ALWAYS.toString()
        metadata.put(indexMetaDataBuilder.build(), false);
        final int minAvgNumberOfShards = Math.round(Math.round(Math.floor(avgNumShards - threshold)));
        logger.info("start the replica shards");
                    for (ShardRouting sr : drain) {
            discoBuilder = discoBuilder.add(node);
                .size();
        AllocationService strategy = createAllocationService(getSettingsBuilderForPrimaryReBalance().build(), new TestGatewayAllocator());
     */
            clusterState = removeOneNode(clusterState, strategy);
    public void testPrimaryBalanceNotSolvedForNodeDropWithPreferPrimaryBalanceSetting() {
        routingTable.add(indexRoutingTable);
            clusterState = removeOneNode(clusterState, strategy);
        int numberOfReplicas
        final int numberOfNodes = 4;
        settings.put(BalancedShardsAllocator.THRESHOLD_SETTING.getKey(), balanceThreshold);
 * this file be licensed under the Apache-2.0 license or a
        settings.put(
        int numberOfShards,
        Metadata.Builder metadata = Metadata.builder();
                                break;
        indexMetaDataBuilder.putInSyncAllocationIds(0, indexShardRoutingTable_0.getAllAllocationIds());
        indexRoutingTable.addIndexShard(indexShardRoutingBuilder_0.build());
    }
                verifyPerIndexPrimaryBalance(clusterState);
    public void testPrimaryBalanceSolvedWithPreferPrimaryRebalanceSetting() {
            .metadata(metadataBuilder.build())
     * This test verifies the allocation logic when nodes breach multiple constraints and ensure node breaching min
        AllocationService strategy = createAllocationService(getSettingsBuilderForPrimaryBalance().build(), new TestGatewayAllocator());
        if (unassigned > 0) {
            ClusterState clusterState = initCluster(strategy, numberOfIndices, numberOfNodes, numberOfShards, numberOfReplicas);
        logger.info("rebalancing");
        metadataBuilder = metadataBuilder.put(indexMeta);
     * Please note, P1, P2 belongs to different index
        settings.put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), shardBalance);
     * There are two nodes (N1, N2) where all primaries land on N1 while replicas on N2.
                assertThat(shardRouting.state(), Matchers.equalTo(ShardRoutingState.STARTED));
                shardId_2,
        }
            settings,
        );
        IndexRoutingTable.Builder indexRoutingTable_0 = IndexRoutingTable.builder(indexMetadata_0.getIndex());
        ShardId shardId_0 = new ShardId(indexMetadata_0.getIndex(), 0);
        float threshold
                logger.info("Unexpected assertion failure");
 *
                .filter(ShardRouting::primary)
        for (RoutingNode node : nodes) {
                    .put(SETTING_NUMBER_OF_REPLICAS, replicaCount)
        ShardId shardId_1 = new ShardId(indexMetadata_1.getIndex(), 0);
    }
                public ShardAllocationDecision decideShardAllocation(ShardRouting shard, RoutingAllocation allocation) {
            nodes.add(node.getId());
        clusterState = addNode(clusterState, strategy);
    }
        settings.put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), indexBalance);
            numberOfShards,
        assertIndexBalance(
                    --------[test][2], node[2], [R], s[STARTED]
        Metadata.Builder metadataBuilder = Metadata.builder();
        final int numberOfNodes = 5;
        metadata.put(indexMetadata, false);
            clusterState.getRoutingTable(),
     * <p>
            numberOfShards,
        settings.put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 0.2);
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        AllocationService strategy,
    public void testNoRebalanceOnPrimaryOverload() {
        metadata.persistentSettings(settingsBuilder.build());
            try {
                    throw new UnsupportedOperationException("explain not supported");
        indexShardRoutingBuilder_0.addShard(TestShardRouting.newShardRouting(shardId_0, nodesList.get(0), true, ShardRoutingState.STARTED));
     * N1        N2
                assertThat(node.shardsWithState(index, STARTED).size(), Matchers.lessThanOrEqualTo(maxAvgNumberOfShards));
     */
            clusterState.getRoutingNodes(),
            final DiscoveryNode node = newNode("node_" + i);
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.getMetadata());
    ) {
            numberOfIndices,
     * --------[test0][0], node[node_0], [P], s[STARTED], a[id=BQrLSo6sQyGlcLdVvGgqLQ]
        AllocationService strategy = createAllocationService(settings.build(), new TestGatewayAllocator());
            ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
    public void testPrimaryBalanceWithoutPreferPrimaryBalanceSetting() {
            .build();
    /**
        Metadata.Builder metadata = Metadata.builder();
public class BalanceConfigurationTests extends OpenSearchAllocationTestCase {
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
            for (ShardRouting shardRouting : routingNode) {
        int numberOfNodes = clusterState.getRoutingNodes().size();
            EmptySnapshotsInfoService.INSTANCE
        );
            ClusterState clusterState = initCluster(strategy, numberOfIndices, numberOfNodes, numberOfShards, numberOfReplicas);
     --------[test][2], node[node0], [R], s[STARTED], a[id=pB3iuLKZSC--2yNS0trbgA]
                }
                .numberOfReplicas(numberOfReplicas);
        indexRoutingTable_0.addIndexShard(indexShardRoutingBuilder_0.build());
        return applyAllocationUntilNoChange(clusterState, strategy);
 * Modifications Copyright OpenSearch Contributors. See
        final float indexBalance = 0.55f;
    ) {
        return applyAllocationUntilNoChange(clusterState, strategy);
import org.opensearch.test.gateway.TestGatewayAllocator;
        return applyAllocationUntilNoChange(clusterState, strategy);
            }
        indexRoutingTable.addIndexShard(indexShardRoutingBuilder_1.build());
        metadata.put(indexMetadata_1, false);
        for (int i = 0; i < 4; i++) {
     * --------[test][0], node[node_0], [P], s[STARTED], a[id=VGjOeBGdSmu3pJR6T7v29A]
        assertShardBalance(
    private ClusterState initCluster(AllocationService strategy) {
            .routingTable(routingTable)
        ).build();
        stateBuilder.metadata(metadata.generateClusterUuidIfNeeded().build());
    private IndexMetadata getIndexMetadata(String indexName, int shardCount, int replicaCount) {
        }
        final int avgPrimaryShardsPerNode = (int) Math.ceil(totalPrimaryShards * 1f / clusterState.getRoutingNodes().size());
        }
        );
        indexShardRoutingBuilder_2.addShard(
            for (ShardRouting shardRouting : routingNode) {
            discoBuilder = discoBuilder.add(node);
            } catch (AssertionError | Exception e) {
 * the Apache License, Version 2.0 (the "License"); you may
            } catch (AssertionError e) {
            } catch (AssertionError | Exception e) {
        settings.put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 0.1);
        return IndexMetadata.builder(indexName)
        assertShardBalance(
    private static void verifyPrimaryBalance(ClusterState clusterState, float buffer) {
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();
        }
            nodes.add(newNode("node" + (clusterState.nodes().getSize() + i)));
                .numberOfShards(numberOfShards)
        assertThat(allocator.getIndexBalance(), Matchers.equalTo(0.2f));
    }
        IndexRoutingTable.Builder indexRoutingTable_1 = IndexRoutingTable.builder(indexMetadata_1.getIndex());
    public void testPersistedSettings() {
        settings.put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), indexBalance);
                    --------[test][1], node[1], [P], s[STARTED]
     * -----node_id[node_1][V]
            nodes.shardsWithState(UNASSIGNED)
    }
            ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
import org.opensearch.Version;
                false,
        final int numberOfShards = 4;
        final int numShards = numberOfIndices * numberOfShards * (numberOfReplicas + 1) - unassigned;
import org.opensearch.cluster.metadata.IndexMetadata;
        return applyAllocationUntilNoChange(clusterState, strategy);
        return settings;
                verifyPerIndexPrimaryBalance(clusterState);
            numberOfIndices,
import org.apache.lucene.util.ArrayUtil;
        }
        assertTrue(balanceFailed >= 4);
                balanceFailed++;
     */
                    --------[test][1], node[2], [R], s[STARTED]
    }
        final float shardBalance = 1.0f;
                                }
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                                }
import org.opensearch.cluster.routing.ShardRoutingState;
        int numberOfReplicas,
                                if (sr.primary()) {
                null,
        ShardId shardId_1 = new ShardId(indexMetadata.getIndex(), 1);
                UNASSIGNED,
     * {@link org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider}
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
        List<ShardRouting> replicaShards = clusterState.routingTable().shardRoutingTable(shardId_2).replicaShards();
        RoutingTable initialRoutingTable = routingTableBuilder.build();
    ) {
        settings.put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), shardBalance);
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(clusterState.routingTable());
        // build index metadata
        settings.put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 0.3);
import org.opensearch.cluster.ClusterName;
        }
            new TestGatewayAllocator()
                        switch (sr.id()) {
        clusterState = strategy.reroute(clusterState, "reroute");
    public void testPrimaryBalance_NotSolved_1() {
            balanceThreshold
    /**
        routingNodes = clusterState.getRoutingNodes();
import org.opensearch.cluster.routing.RoutingNode;
     * -----node_id[node_1][V]
        final float indexBalance = 0.0f;
     */
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public void testPrimaryBalance_NotSolved_2() {
            .settings(settings(Version.CURRENT))
            BalancedShardsAllocator.PRIMARY_SHARD_REBALANCE_BUFFER.getKey(),
    }
                verifyPrimaryBalance(clusterState, buffer);
        metadataBuilder = metadataBuilder.put(index);
                                    allocation.routingNodes().initializeShard(sr, "node2", null, -1, allocation.changes());
            .build();
        clusterSettings.applySettings(updatedSettings);
        return applyStartedShardsUntilNoChange(clusterState, strategy);
            for (ShardRouting shardRouting : routingNode) {
                                    allocation.routingNodes().initializeShard(sr, "node1", null, -1, allocation.changes());
        List<String> nodesList = new ArrayList<>(nodes);
                                    allocation.routingNodes().initializeShard(sr, "node1", null, -1, allocation.changes());
            DiscoveryNode node = newNode("node" + i);
        IndexShardRoutingTable.Builder indexShardRoutingBuilder_2 = new IndexShardRoutingTable.Builder(shardId_2);
        IndexShardRoutingTable.Builder indexShardRoutingBuilder_0 = new IndexShardRoutingTable.Builder(shardId_0);
        // build index metadata
        int balanceFailed = 0;
            ClusterRebalanceAllocationDecider.ClusterRebalanceType.ALWAYS.toString()
                balanceFailed++;
            routingTableBuilder.addAsNew(cursor);
                .values()
        int numberOfShards,
import org.opensearch.cluster.routing.UnassignedInfo;
        final float buffer = 0.10f;
        int numberOfShards,
        clusterState = strategy.reroute(clusterState, "reroute");
        verifyPerIndexPrimaryBalance(clusterState);
        logger.info("Removing half the nodes (" + (numberOfNodes + 1) / 2 + ")");
        routingTable.add(indexRoutingTable_1);
        ClusterSettings service = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                    .put(SETTING_NUMBER_OF_SHARDS, shardCount)
                .numberOfShards(numberOfShards)
            clusterState.getRoutingNodes(),
        AllocationService strategy,
        }
        AllocationService strategy = createAllocationService(settingsBuilder.build(), new TestGatewayAllocator());
    public void testShardBalance() {
    private Settings.Builder getSettingsBuilderForPrimaryReBalance() {
        for (final IndexMetadata cursor : metadata.indices().values()) {
    private void assertIndexBalance(
        ClusterState clusterState = stateBuilder.build();
            clusterSettings,
        final float avgNumShards = (float) (numShards) / (float) (numberOfNodes);
                @Override
import static org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING;
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        logger.info(ShardAllocations.printShardDistribution(clusterState));
     */
        verifyPrimaryBalance(clusterState, buffer);
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
            )
    public void testPrimaryBalanceWithPreferPrimaryBalanceSetting() {
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder();
            .build();
            getSettingsBuilderForPrimaryBalance(false, false).build(),
        int numberOfNodes,
                balanceFailed++;
        return applyStartedShardsUntilNoChange(clusterState, strategy);
    private Settings.Builder getSettingsBuilderForPrimaryBalance(boolean preferPrimaryBalance, boolean preferPrimaryRebalance) {
                    .stream()
        for (final Map.Entry<String, IndexRoutingTable> index : currentState.getRoutingTable().indicesRouting().entrySet()) {
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                                break;
        final int unassigned = nodes.unassigned().size();
     --------[test][2], node[node1], [P], s[STARTED], a[id=QWN_T6xpQiWGSD8GJnX-bQ]
            balanceThreshold
import org.opensearch.common.settings.ClusterSettings;
        final int numberOfIndices = 4;
/*
        settings = Settings.builder();
 * GitHub history for details.
    public void testPrimaryBalance() {
                                if (sr.primary()) {
        List<String> nodesList = new ArrayList<>(nodes);
            for (RoutingNode node : nodes) {
            clusterState = strategy.disassociateDeadNodes(clusterState, randomBoolean(), "removed nodes");
        clusterState = addIndex(clusterState, strategy, "test-index3", 1, 1);
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(clusterState.routingTable());
        int balanceFailed = 0;
    }
import org.opensearch.cluster.routing.allocation.allocator.ShardsAllocator;
        clusterState = removeOneNode(clusterState, strategy);
                                    allocation.routingNodes().initializeShard(sr, "node1", null, -1, allocation.changes());
        for (int i = 0; i < numberOfRuns; i++) {
        settings = Settings.builder();
            .routingTable(initialRoutingTable)
            routingTableBuilder.addAsNew(cursor);
     -----node_id[node3][V]
                    routing_nodes:
    }
                                    allocation.routingNodes().initializeShard(sr, "node0", null, -1, allocation.changes());
        clusterState = removeNodes(clusterState, strategy);
        ShardId shardId_0 = new ShardId(indexMetadata.getIndex(), 0);
        logger.info("use the new allocator and check if it moves shards");
        float threshold
                            case 0:
        RoutingNodes nodes,
                assertThat(shardRouting.state(), Matchers.equalTo(ShardRoutingState.STARTED));
            }
        }
 * Licensed to Elasticsearch under one or more contributor
        UnassignedInfo unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null);
        logger.info(ShardAllocations.printShardDistribution(clusterState));
     * P2        R2
        verifyPerIndexPrimaryBalance(clusterState);
     * logic which applies at index level i.e. balance shards single index across all nodes. This will be solved when
        RoutingNodes nodes,
        indexShardRoutingBuilder_1.addShard(
        ClusterState clusterState,
                verifyPrimaryBalance(clusterState, buffer);
     -----node_id[node0][V]
        logger.info("start " + numberOfNodes + " nodes");
        assertThat(allocator.getIndexBalance(), Matchers.equalTo(0.5f));
            assertTrue(primaryCount <= (avgPrimaryShardsPerNode * (1 + buffer)));
        indexShardRoutingBuilder_1.addShard(
        metadata.put(indexMetadata_0, false);
            numberOfReplicas,
     * <p>
                    --------[test][4], node[2], [P], s[STARTED]
        final int numberOfShards = 25;
        Settings.Builder settings = Settings.builder();
        int numberOfReplicas,
            final DiscoveryNode node = newNode("node" + i);
        final int numShards = numberOfShards * (numberOfReplicas + 1);
            metadataBuilder = metadataBuilder.put(index);
                                } else {
            numberOfShards,
     * --------[test0][0], node[node_1], [R], s[STARTED], a[id=E85-jhiEQwuB43u5Wq1mAw]
        AllocationService strategy = createAllocationService(getSettingsBuilderForPrimaryReBalance().build(), new TestGatewayAllocator());
            assertThat(node.shardsWithState(STARTED).size(), Matchers.greaterThanOrEqualTo(minAvgNumberOfShards));
    }
     * ------  --------
        IndexMetadata.Builder index = IndexMetadata.builder(indexName)
        IndexMetadata indexMetadata = getIndexMetadata("test", 2, 1);
            // Ensure that if there any unassigned shards, all of their replicas are unassigned as well
        indexRoutingTable.addIndexShard(indexShardRoutingBuilder_2.build());
        indexMetaDataBuilder.putInSyncAllocationIds(1, indexShardRoutingTable_1.getAllAllocationIds());
            try {
        ClusterState clusterState = initCluster(strategy);
                public void allocate(RoutingAllocation allocation) {
                new ClusterSettings(Settings.Builder.EMPTY_SETTINGS, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            totalPrimaryShards += index.primaryShardsActive();
     * This test verifies primary shard balance is attained with PREFER_PRIMARY_SHARD_BALANCE setting.
            }
     * --------[test1][0], node[node_1], [R], s[STARTED], a[id=TDqbfvAfSFK6lnv3aOU9bA]
        indexShardRoutingBuilder_0.addShard(
        logger.info(ShardAllocations.printShardDistribution(clusterState));
        assertEquals("node0", replicaShards.get(0).currentNodeId());
            }
        for (RoutingNode routingNode : routingNodes) {
     -----node_id[node1][V]
            numberOfNodes + 1,
     * P2       R2
        );
        settingsBuilder.put("cluster.routing.allocation.exclude._id", "node2,node3");
        int numberOfIndices,
import org.opensearch.cluster.node.DiscoveryNodes;
            numberOfNodes,
        IndexShardRoutingTable indexShardRoutingTable_0 = indexShardRoutingBuilder_0.build();
    }
        ClusterState clusterState = initCluster(strategy);
                 *  // is rebalanced to node 0
                                }
        // Build index routing table
        final float buffer = 0.10f;
        final int minAvgNumberOfShards = Math.round(Math.round(Math.floor(avgNumShards - threshold)));
import java.util.Set;
        clusterState = strategy.reroute(clusterState, "indices-created");
        for (int i = 0; i < numberOfRuns; i++) {
        clusterState = addNodes(clusterState, strategy, 5);
        ClusterState clusterState = stateBuilder.build();
                            case 2:
        indexShardRoutingBuilder_1.addShard(
        logger.info(ShardAllocations.printShardDistribution(clusterState));
        AllocationService strategy = createAllocationService(getSettingsBuilderForPrimaryBalance().build(), new TestGatewayAllocator());
        clusterState = addIndices(clusterState, strategy, 5, 1, 8);
                .stream()
import org.opensearch.cluster.routing.RoutingTable;
                shardId_2,
                random()
        clusterState = applyAllocationUntilNoChange(clusterState, strategy);
            clusterState.getRoutingTable(),
                assertThat(shardRouting.state(), Matchers.equalTo(ShardRoutingState.STARTED));
        );
            ),
     * This test mimics cluster state where re-balancing is not possible due to existing limitation of re-balancing
     * constraints chosen for allocation.
import java.util.List;
        indexRoutingTable_1.addIndexShard(indexShardRoutingBuilder_1.build());
        clusterState = strategy.reroute(clusterState, "reroute");
        settings.put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 0.3);
        }
        return initCluster(strategy, numberOfIndices, numberOfNodes, numberOfShards, numberOfReplicas);
import org.opensearch.cluster.routing.TestShardRouting;
            } catch (AssertionError e) {
            )
        Settings settings = getSettingsBuilderForPrimaryBalance().build();
            numberOfIndices,
import org.hamcrest.Matchers;
                true,
    }
        Metadata metadata = metadataBuilder.build();
            }
            balanceThreshold
        AllocationService strategy = createAllocationService(getSettingsBuilderForPrimaryBalance().build(), new TestGatewayAllocator());
        IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(indexMetadata.getIndex());
            .settings(settings(Version.CURRENT))
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());
        routingTableBuilder.addAsNew(index.build());
        clusterState = removeNodes(clusterState, strategy);
     -----node_id[node2][V]
    }
        clusterState = ClusterState.builder(clusterState)
        }
    private ClusterState addIndices(
        final float shardBalance = 0.0f;
        clusterState = ClusterState.builder(clusterState)
        Settings.Builder settings = Settings.builder();
                RecoverySource.EmptyStoreRecoverySource.INSTANCE,
        service.applySettings(settings.build());
                                } else {
            numberOfReplicas,
 */
            .build();
        }
                    .size();
        assertTrue(balanceFailed <= 1);
                assertThat(shardRouting.state(), Matchers.equalTo(ShardRoutingState.INITIALIZING));
        service.applySettings(settings.build());
        assertTrue(balanceFailed <= 1);
                                break;
            new ShardsAllocator() {
            numberOfReplicas,
        }
    ) {
    private ClusterState initCluster(
        for (int i = 0; i < numberOfNodes; i++) {
            balanceThreshold
                    --------[test][4], node[0], [R], s[STARTED]
                                }
        discoBuilder.localNodeId(newNode("node_0").getId());
                    -----node_id[1][V]
            numberOfShards,
     * This test verifies primary shard balance is not attained without PREFER_PRIMARY_SHARD_BALANCE setting.
            .numberOfShards(numberOfShards)
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());
        }
        for (final String index : routingTable.indicesRouting().keySet()) {
    }
        RoutingTable.Builder routingTable = RoutingTable.builder();
                .collect(Collectors.toList())
        clusterState = applyAllocationUntilNoChange(clusterState, strategy);
        for (int i = (numberOfNodes + 1) / 2; i <= numberOfNodes; i++) {
            nodes.remove("node" + i);
            TestShardRouting.newShardRouting(
     * -----node_id[node_0][V]
            .numberOfShards(5)
    }
            numberOfShards,
            TestShardRouting.newShardRouting(shardId_0, nodesList.get(1), false, ShardRoutingState.STARTED)
            IndexMetadata.Builder index = IndexMetadata.builder("test" + i)
                .forEach(count -> assertEquals(numberOfReplicas + 1, count.longValue()));
                settings.build(),
                .numberOfReplicas(numberOfReplicas);
            logger.info(ShardAllocations.printShardDistribution(clusterState));
        }
import org.opensearch.cluster.ClusterState;
            .nodes(nodes)
            TestShardRouting.newShardRouting(shardId_0, nodesList.get(1), false, ShardRoutingState.STARTED)
                assertThat(node.shardsWithState(index, STARTED).size(), Matchers.greaterThanOrEqualTo(minAvgNumberOfShards));
            randomAllocationDeciders(
        if (removed) {
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
import org.opensearch.common.settings.Settings;
        }
        clusterState = strategy.reroute(clusterState, "reroute");
     * primary shard count across indices, constraint is added.
                unassignedInfo
        AllocationService strategy,
                final int primaryCount = node.shardsWithState(index.getKey(), STARTED)
        final float balanceThreshold = 1.0f;
     * This test mimics a cluster state containing four nodes, where one node breaches two constraints while one breaches
        discoBuilder.clusterManagerNodeId(newNode("node_0").getId());
            logger.info(ShardAllocations.printShardDistribution(clusterState));
        IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(indexMetadata.getIndex());
    private final Logger logger = LogManager.getLogger(BalanceConfigurationTests.class);
            }
        for (int i = 0; i < numberOfNodes; i++) {
        settings.put(
                    --------[test][0], node[1], [P], s[STARTED]
        assertFalse(balanced);
        // move initializing to started
        } catch (AssertionError e) {
            }
            clusterState.getRoutingNodes(),
            nodesList.add(node.getId());
        settings.put(BalancedShardsAllocator.THRESHOLD_SETTING.getKey(), balanceThreshold);
    /**
            .numberOfReplicas(1);
        logger.info("start all the primary shards, replicas will start initializing");
    /**
                logger.info("Expected assertion failure");
            .settings(
        logger.info(ShardAllocations.printShardDistribution(clusterState));
    }
            TestShardRouting.newShardRouting(
     * This test mimics a cluster state which can not be rebalanced due to
        );
     * only one. In order to have nodes breach constraints, test excludes two nodes (node2, node3) from allocation so
        IndexShardRoutingTable.Builder indexShardRoutingBuilder_1 = new IndexShardRoutingTable.Builder(shardId_1);
        logger.info("start the replica shards");
            TestShardRouting.newShardRouting(shardId_1, nodesList.get(1), false, ShardRoutingState.STARTED)
                /*
            for (RoutingNode node : nodes) {
        assertTrue(primaryShard.started());
        int numberOfNodes,
        RoutingTable.Builder routingTable = RoutingTable.builder();
        return getSettingsBuilderForPrimaryBalance(true, false);
import java.util.stream.Collectors;
            ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
        );
        ShardId shardId_1 = new ShardId(indexMetadata.getIndex(), 1);
        );
        final float avgNumShards = (float) (numShards) / (float) (numberOfNodes);
    }
        verifyPerIndexPrimaryBalance(clusterState);
        clusterState = addNode(clusterState, strategy);
 * under the License.
     * @throws Exception generic exception
        for (int i = 0; i < 4; i++) {
 *
        indexShardRoutingBuilder_1.addShard(TestShardRouting.newShardRouting(shardId_1, nodesList.get(0), true, ShardRoutingState.STARTED));
            numberOfNodes + 1 - (numberOfNodes + 1) / 2,
        discoBuilder.localNodeId(newNode("node_0").getId());
    final int numberOfNodes = 25;
        IndexMetadata.Builder indexMeta = IndexMetadata.builder("test")
    public void testIndexBalance() {
        logger.info("now, start [{}] more node, check that rebalancing will happen because we set it to always", numberOfNodes);
        AllocationService strategy = createAllocationService(settings.build(), new TestGatewayAllocator());
                logger.info("Unexpected assertion failure");
     * --------[test][0], node[node_1], [R], s[STARTED], a[id=8IpwEMQ2QEuj5rQOxBagSA]
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            try {
            final int primaryCount = node.shardsWithState(STARTED)
        clusterState = addIndex(clusterState, strategy, "test-index2", 1, 1);
    private void assertShardBalance(
        Set<String> nodes = new HashSet<>();
            EmptyClusterInfoService.INSTANCE,
        RoutingTable routingTable = routingTableBuilder.build();
            balanceThreshold
    }
        }
        final int numberOfReplicas = 1;
                    ArrayUtil.timSort(drain, (a, b) -> { return a.primary() ? -1 : 1; }); // we have to allocate primaries first
                .settings(settings(Version.CURRENT).build())
        stateBuilder.nodes(discoBuilder);
        clusterState = strategy.reroute(clusterState, "reroute");
        }
        int numberOfShards,
        settings.put(BalancedShardsAllocator.THRESHOLD_SETTING.getKey(), 2.0);
                UNASSIGNED,
        Settings updatedSettings = getSettingsBuilderForPrimaryBalance().put(
    }
            IndexMetadata.Builder index = IndexMetadata.builder("test" + i)
     * the new primary shard assignment lands on the node breaching one constraint(node1), while replica land on the other
        int numberOfReplicas
            removed = true;
            clusterState.getRoutingNodes(),
                                break;
            TestShardRouting.newShardRouting(shardId_0, nodesList.get(1), false, ShardRoutingState.STARTED)
        }
        indexShardRoutingBuilder_0.addShard(TestShardRouting.newShardRouting(shardId_0, nodesList.get(0), true, ShardRoutingState.STARTED));
    final int numberOfIndices = 12;
        ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName("test"));
        clusterState = ClusterState.builder(clusterState)
        clusterState = addNode(clusterState, strategy);
            try {
            for (ShardRouting shardRouting : routingNode) {
            numberOfIndices,
import org.opensearch.snapshots.EmptySnapshotsInfoService;
                                    allocation.routingNodes().initializeShard(sr, "node0", null, -1, allocation.changes());
        settings.put(BalancedShardsAllocator.THRESHOLD_SETTING.getKey(), 2.0);
        routingNodes = clusterState.getRoutingNodes();
        assertThat(allocator.getShardBalance(), Matchers.equalTo(0.1f));
        indexShardRoutingBuilder_1.addShard(TestShardRouting.newShardRouting(shardId_1, nodesList.get(0), true, ShardRoutingState.STARTED));
            final DiscoveryNode node = newNode("node_" + i);
        stateBuilder.nodes(discoBuilder);
    }
        int totalPrimaryShards = 0;
     * --------[test][1], node[node_0], [P], s[STARTED], a[id=xqfZSToVSQaff2xvuxh_yA]
     * This test verifies primary shard balance is attained with PREFER_PRIMARY_SHARD_BALANCE setting.
import org.opensearch.core.index.shard.ShardId;
        final int numberOfIndices = 5;
        assertThat(allocator.getThreshold(), Matchers.equalTo(2.0f));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
        int balanceFailed = 0;
            numberOfReplicas,
     * This test verifies that with only primary shard balance, the primary shard distribution per index is balanced.
        final float balanceThreshold = 1.0f;
        final int numberOfShards = 25;
                    --------[test][3], node[1], [R], s[STARTED]
        stateBuilder.routingTable(routingTable.build());
                                    allocation.routingNodes().initializeShard(sr, "node2", null, -1, allocation.changes());
        int numberOfNodes,
            ClusterState clusterState = initCluster(strategy, numberOfIndices, numberOfNodes, numberOfShards, numberOfReplicas);
        assertTrue(balanceFailed >= 4);
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).build();
        int numberOfIndices
        int numberOfIndices,
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
        assertEquals(numberOfNodes, nodes.size());
        Settings.Builder settings = Settings.builder();
package org.opensearch.cluster.routing.allocation;
                                    allocation.routingNodes().initializeShard(sr, "node3", null, -1, allocation.changes());
        final int numberOfReplicas = 1;
        }
        // Update settings & apply
            logger.info(ShardAllocations.printShardDistribution(clusterState));
                                } else {
                                if (sr.primary()) {
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        );
                                } else {
    }
        RoutingNodes nodes = clusterState.getRoutingNodes();
        clusterState = removeNodes(clusterState, strategy);
        }
        indexShardRoutingBuilder_0.addShard(TestShardRouting.newShardRouting(shardId_0, nodesList.get(0), true, ShardRoutingState.STARTED));
                    -----node_id[2][V]
        assertIndexBalance(
    /**
                    RoutingNodes.UnassignedShards unassigned = allocation.routingNodes().unassigned();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
     * --------[test1][0], node[node_0], [P], s[STARTED], a[id=u7qtyy5AR42hgEa-JpeArg]
            metadataBuilder = metadataBuilder.put(index);
        final int maxAvgNumberOfShards = Math.round(Math.round(Math.ceil(avgNumShards + threshold)));
     */
            new TestGatewayAllocator(),
        RoutingTable routingTable = strategy.reroute(clusterState, "reroute").routingTable();
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node" + clusterState.getRoutingNodes().size())))
        }
    /**
        settings.put(
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();
        clusterState = addNode(clusterState, strategy);
    }
     * @throws Exception generic exception
        clusterState = ClusterState.builder(clusterState).nodes(nodes.build()).build();
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
    ) {
            logger.info(ShardAllocations.printShardDistribution(clusterState));
                RecoverySource.PeerRecoverySource.INSTANCE,
                }
        AllocationService strategy = new AllocationService(
    }
        for (int i = 0; i < numberOfRuns; i++) {
        );
        );
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
    }
        }
        Metadata metadata = metadataBuilder.build();
            }
     */
        routingNodes = clusterState.getRoutingNodes();
        verifyPrimaryBalance(clusterState, 0.0f);
            clusterState = removeOneNode(clusterState, strategy);
import org.opensearch.cluster.routing.RoutingNodes;
        clusterState = addNode(clusterState, strategy);
        try {
        IndexShardRoutingTable indexShardRoutingTable_1 = indexShardRoutingBuilder_1.build();
        stateBuilder.nodes(discoBuilder);
        clusterState = ClusterState.builder(clusterState).nodes(nodes.build()).build();
        );
import org.apache.logging.log4j.LogManager;
                verifyPerIndexPrimaryBalance(clusterState);
    /**
        assertShardBalance(
                balanceFailed++;
                    ---- unassigned
                    --------[test][3], node[3], [P], s[STARTED]
     --------[test][1], node[node1], [R], s[STARTED], a[id=ChWdQiOdSdKrTPxwceIu1w]
        settings.put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 0.5);
            numberOfNodes,
                    -----node_id[3][V]
        assertThat(allocator.getIndexBalance(), Matchers.equalTo(0.2f));
import org.opensearch.cluster.routing.ShardRouting;
        IndexMetadata indexMetadata = getIndexMetadata("test", 3, 1);
        discoBuilder.localNodeId(newNode("node_0").getId());
     */
        discoBuilder.clusterManagerNodeId(newNode("node_0").getId());
        IndexShardRoutingTable.Builder indexShardRoutingBuilder_0 = new IndexShardRoutingTable.Builder(shardId_0);
        final int numberOfRuns = 5;
        settings.put(BalancedShardsAllocator.PREFER_PRIMARY_SHARD_REBALANCE.getKey(), preferPrimaryRebalance);
        for (final IndexRoutingTable index : clusterState.getRoutingTable().indicesRouting().values()) {
     * This test verifies global balance by creating indices iteratively and verify primary shards do not pile up on one
        AllocationService strategy = createAllocationService(getSettingsBuilderForPrimaryBalance().build(), new TestGatewayAllocator());
                    -----node_id[0][V]
     * <p>
    /**
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
    private void verifyPerIndexPrimaryBalance(ClusterState currentState) {
            numberOfIndices,
                    --------[test][0], node[0], [R], s[STARTED]
        discoBuilder.clusterManagerNodeId(newNode("node_0").getId());
 * ownership. Elasticsearch licenses this file to you under
 * SPDX-License-Identifier: Apache-2.0
        IndexMetadata indexMetadata_0 = getIndexMetadata("test0", 1, 1);
     * This test verifies primary shard balance is attained  setting.
            numberOfReplicas,
                                    allocation.routingNodes().initializeShard(sr, "node3", null, -1, allocation.changes());
            .build();
        Metadata.Builder metadataBuilder = Metadata.builder();
                    ShardRouting[] drain = unassigned.drain();
            new TestGatewayAllocator(),
        AllocationService strategy = createAllocationService(getSettingsBuilderForPrimaryBalance().build(), new TestGatewayAllocator());
            ClusterState clusterState = initCluster(strategy, numberOfIndices, numberOfNodes, numberOfShards, numberOfReplicas);
import org.opensearch.cluster.node.DiscoveryNode;
        }
        routingTable = startInitializingShardsAndReroute(strategy, clusterState).routingTable();
     * -----node_id[node_0][V]
                    --------[test][2], node[3], [P], s[STARTED]
            }
        return getSettingsBuilderForPrimaryBalance(true, true);
        /* Tests balance over indices only */
        );
    private ClusterState removeNodes(ClusterState clusterState, AllocationService strategy) {
                logger.info("Unexpected assertion failure");
        int numberOfReplicas,
        ClusterState clusterState = initCluster(strategy);
        nodes.remove("node0");
        ClusterState clusterState = stateBuilder.build();
    public void testGlobalPrimaryBalance() throws Exception {
        stateBuilder.routingTable(routingTable.build());
        settings.put(
        }
        boolean removed = false;
            .numberOfReplicas(numberOfReplicas);
        ShardId shardId_2 = new ShardId(indexMetadata.getIndex(), 2);
                                    allocation.routingNodes().initializeShard(sr, "node2", null, -1, allocation.changes());
        Settings.Builder settings = Settings.builder();
        );
        Set<String> nodes = new HashSet<>();
            balanced = false;
     --------[test][0], node[node0], [P], s[STARTED], a[id=0HySaPcyRhiKrH6QLA3evw]
        indexShardRoutingBuilder_1.addShard(TestShardRouting.newShardRouting(shardId_1, nodesList.get(0), true, ShardRoutingState.STARTED));
        for (int i = 0; i < numberOfIndices; i++) {
        routingTable.add(indexRoutingTable);
        for (final IndexMetadata cursor : metadata.indices().values()) {
        );
        logger.info("complete rebalancing");
        );
     *
            .metadata(metadata)
        indexRoutingTable.addIndexShard(indexShardRoutingBuilder_1.build());
        int numberOfIndices,
            TestShardRouting.newShardRouting(shardId_1, nodesList.get(1), false, ShardRoutingState.STARTED)
     * --------[test][1], node[node_1], [R], s[STARTED], a[id=zZI0R8FBQkWMNndEZt9d8w]
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        settings.put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 0.2);
        logger.info("now, start 1 more node, check that rebalancing will happen because we set it to always");
     *
                                }
    private ClusterState addNode(ClusterState clusterState, AllocationService strategy) {
        );
 * compatible open source license.
 * software distributed under the License is distributed on an
import java.util.ArrayList;
        ShardRouting primaryShard = clusterState.routingTable().shardRoutingTable(shardId_2).primaryShard();
        }
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
        int balanceFailed = 0;
        indexRoutingTable.addIndexShard(indexShardRoutingBuilder_0.build());
        clusterState = strategy.reroute(clusterState, "reroute");
        ClusterState clusterState,
            ClusterRebalanceAllocationDecider.ClusterRebalanceType.ALWAYS.toString()
            ClusterRebalanceAllocationDecider.ClusterRebalanceType.ALWAYS.toString()
            routingTableBuilder.addAsNew(index.build());
        }
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
     * that other two nodes (node0, node1) have all shards assignments resulting in constraints breach. Test asserts that
            numberOfNodes + 1,
    private ClusterState applyAllocationUntilNoChange(ClusterState clusterState, AllocationService strategy) {
     * <p>
 *
        Settings.Builder settings = Settings.builder();
 * You may obtain a copy of the License at
        assertTrue(balanceFailed <= 1);
        clusterState = addIndex(clusterState, strategy, "test-index1", 1, 1);
    final int numberOfReplicas = 2;
            SNAPSHOT_INFO_SERVICE_WITH_NO_SHARD_SIZES
        settings.put(BalancedShardsAllocator.THRESHOLD_SETTING.getKey(), balanceThreshold);
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
                .collect(Collectors.toMap(ShardRouting::shardId, s -> 1, (a, b) -> a + b))
        RoutingNodes nodes = currentState.getRoutingNodes();
        final int numberOfReplicas = 1;
        ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName("test"));
        stateBuilder.routingTable(routingTable.build());
        int numberOfShards,
        clusterState = strategy.reroute(clusterState, "index-created");
 * The OpenSearch Contributors require contributions made to
 */
        stateBuilder.metadata(metadata.generateClusterUuidIfNeeded().build());
                    .collect(Collectors.toList())
        assertTrue(replicaShards.get(0).started());
        boolean balanced = true;
import org.opensearch.cluster.routing.RecoverySource;
            .routingTable(routingTableBuilder.build())
     */
            BalancedShardsAllocator.PRIMARY_SHARD_REBALANCE_BUFFER.get(settings) + 0.01f
        final int numberOfIndices = 4;
            assertThat(node.shardsWithState(STARTED).size(), Matchers.lessThanOrEqualTo(maxAvgNumberOfShards));
        verifyPrimaryBalance(clusterState, buffer);
        logger.info(ShardAllocations.printShardDistribution(clusterState));
        return applyAllocationUntilNoChange(clusterState, strategy);
        final int numberOfNodes = 5;
 * Unless required by applicable law or agreed to in writing,
        final int numberOfRuns = 5;
                Settings.builder()
        );
        IndexShardRoutingTable.Builder indexShardRoutingBuilder_1 = new IndexShardRoutingTable.Builder(shardId_1);
            TestShardRouting.newShardRouting(shardId_1, nodesList.get(1), false, ShardRoutingState.STARTED)
        assertEquals(1, replicaShards.size());
 * not use this file except in compliance with the License.
            },
 */
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            }
            clusterState.getRoutingTable(),
     routing_nodes:
        assertIndexBalance(
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
     * <p>
    public void testGlobalPrimaryBalanceWithNodeDrops() throws Exception {
     --------[test][1], node[node0], [P], s[STARTED], a[id=7B4dVsrjSoC6imBHO60mrQ]
                 *  // this allocator tries to rebuild this scenario where a rebalance is
        routingTable = startInitializingShardsAndReroute(strategy, clusterState).routingTable();
        // Mark node2, node 3 excluded (FilterAllocationDecider) so that all allocations land on node 0, node 1
        Settings.Builder settingsBuilder = getSettingsBuilderForPrimaryBalance();
            ClusterState clusterState = initCluster(strategy, numberOfIndices, numberOfNodes, numberOfShards, numberOfReplicas);
            .nodes(nodes)
            .routingTable(routingTableBuilder.build())
                logger.info("Unexpected assertion failure");
     * This test verifies global balance by creating indices iteratively and verify primary shards do not pile up on one
        IndexShardRoutingTable.Builder indexShardRoutingBuilder_1 = new IndexShardRoutingTable.Builder(shardId_1);
        // Double check primary shard balance should still work
        final int numberOfReplicas = 1;
import org.apache.logging.log4j.Logger;
        assertThat(allocator.getShardBalance(), Matchers.equalTo(0.3f));
        for (RoutingNode routingNode : routingNodes) {
                unassignedInfo
                                if (sr.primary()) {
    private ClusterState removeOneNode(ClusterState clusterState, AllocationService strategy) {
        for (int i = 0; i < numberOfIndices; i++) {
            nodes.add(newNode("node" + i));
        for (int i = 0; i < 2; i++) {
        );
