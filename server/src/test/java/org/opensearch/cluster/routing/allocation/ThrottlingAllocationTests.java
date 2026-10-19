                IndexMetadata.builder("new_index")  
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        indexRouting = clusterState.routingTable().index("new_index");
/*
            replicasConcurrentRecoveries,
                if (shard.primary() && shard.recoverySource().getType() == RecoverySource.Type.SNAPSHOT) {
            IndexMetadata indexMetadata = indexMetadataBuilder.build();  
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 2)
                            Version.CURRENT,
        }  
        Metadata metadata = Metadata.builder().persistentSettings(settings).build();
        }
        assertThat(totalIncomingRecoveriesNewIndex, equalTo(newIndexInitializingAfterReroute));
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node3"), equalTo(2));
            clusterState.routingTable()  
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(1));  
                .put("cluster.routing.allocation.concurrent_source_recoveries", 3)
        Settings settings = Settings.builder()
        logger.info(  
        final TestGatewayAllocator gatewayAllocator,  
        assertEquals(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node1"), 1);
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node3"), equalTo(2));
        int replicasConcurrentRecoveries = primaries * newIndexReplicas + randomIntBetween(1, 10);
        clusterState = ClusterState.builder(clusterState).metadata(metadata).routingTable(updatedRoutingTable).build();  
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node3"), equalTo(0));  
        logger.info("start initializing");
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(0));  
            snapshotsInfoService
import org.opensearch.cluster.RestoreInProgress;  
        logger.info("start initializing, all primaries should be started");  
        return ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(8));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                snapshot,
                    routingTableBuilder.addAsNew(indexMetadata);
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(0));
import org.opensearch.common.UUIDs;
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node1"), equalTo(0));
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(2));  
        }
        }
            gatewayAllocator,  
            .put(
        while (!clusterState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty()) {
    public void testNewIndexReplicaAllocationOutgoingLimitBreachedIncomingNotBreached() {  
import org.apache.logging.log4j.Logger;
            Index index = cursor.getIndex();
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node1"), equalTo(0));
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(2));
    private ClusterState createRecoveryStateAndInitializeAllocations(
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node2"), equalTo(1));  
        TestGatewayAllocator gatewayAllocator = new TestGatewayAllocator();  
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(3));
        );  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 3)  
                .put("cluster.routing.allocation.node_concurrent_outgoing_recoveries", 1)
                .index("new_index")
                .collect(Collectors.toList())
        final Metadata metadata,
                );
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node2"), equalTo(0));  
import org.opensearch.cluster.node.DiscoveryNodes;
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node3"), equalTo(0));
                .shardsWithState(INITIALIZING)
                        ),  
 * You may obtain a copy of the License at  
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(0));
                .put("cluster.routing.allocation.node_concurrent_recoveries", 3)  
            final int recoveryType = inputRecoveryType == null ? randomInt(5) : inputRecoveryType.intValue();
        Metadata metaData;
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node2"), equalTo(1));
        public SnapshotShardSizeInfo snapshotShardSizes() {
    public void testPrimaryRecoveryThrottling() {
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(2));
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(1));
                    .numberOfShards(newIndexPrimaries)
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(17));
import org.apache.logging.log4j.LogManager;
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 2);  
                    .settings(settings(Version.CURRENT))
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 1);  
        assertThat(clusterState.routingTable().index("new_index").shardsWithState(INITIALIZING).size(), equalTo(4));  
        AllocationService strategy,  
            }
            gatewayAllocator,
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(4));  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(0));
            Settings.builder()
        for (final IndexMetadata cursor : metadata.indices().values()) {
                    .numberOfReplicas(newIndexReplicas)  
                    );
                    ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(),  
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node2"), equalTo(2));  
            .put("cluster.routing.allocation.node_initial_primaries_recoveries", 20)
        int primaries = randomIntBetween(5, 30);
            .metadata(metadataBuilder.build())
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node2"), equalTo(0));
import org.opensearch.core.index.Index;  
        assertEquals(commandsResult.explanations().explanations().size(), 1);
    }
            IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(cursor);  
import org.opensearch.core.index.shard.ShardId;
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node3"), equalTo(0));
import java.util.stream.Collectors;
        String[] indices = { "test1", "test2" };
import static org.hamcrest.Matchers.equalTo;
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node1"), equalTo(1));  
                            snapshot,  
            true,
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 1)
        clusterState = strategy.reroute(clusterState, "reroute");  
        TestGatewayAllocator gatewayAllocator = new TestGatewayAllocator();  
                .filter(routing -> routing.primary() && routing.isRelocationTarget())
                .build(),
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(0))  
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), equalTo(0));  
/*  
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(3));
            )
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node3"), equalTo(0));  
        assertEquals(clusterState.getRoutingNodes().getIncomingRecoveries("node1"), 0);
        assertThat(clusterState.routingTable().index("new_index").shardsWithState(INITIALIZING).size(), equalTo(5));  
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey(), 1)
                    restoreShards.put(shardId, new RestoreInProgress.ShardRestoreStatus(node1.getId(), RestoreInProgress.State.INIT));  
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node3"), equalTo(0));
        logger.info("Building initial routing table");
    }
                    "reached the limit of outgoing shard recoveries [1] on the node [node1] which holds the primary, "
import org.opensearch.snapshots.InternalSnapshotsInfoService;  
        clusterState = strategy.applyStartedShards(
import java.util.Collections;
import java.util.Map;
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(1));  
        );  
        int newIndexPrimaries,
        clusterState = strategy.reroute(clusterState, "reroute");  
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node4"), equalTo(0));  
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(0));  
        AllocationService strategy = createAllocationService(
 * this work for additional information regarding copyright
    public void testNewIndexReplicaAllocationLimitNotBreached() {
            .routingTable(initialRoutingTable)  
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(0));
            RestoreInProgress.Entry restore = new RestoreInProgress.Entry(
import org.opensearch.snapshots.SnapshotId;
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4"))).build();
    ) {  
        assertThat(indexRouting.shardsWithState(UNASSIGNED).size(), equalTo(newIndexUnassignedAfterReroute));  
    }
            .metadata(metaData)
        final Metadata metadata,
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 2)
            .put("cluster.routing.allocation.node_concurrent_recoveries", 1)  
                assertEquals(  
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(10));
    public void testReplicaAndPrimaryRecoveryThrottling() {
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node2"), equalTo(0));
                    routingTableBuilder.addAsFromDangling(indexMetadata);
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        TestSnapshotsInfoService snapshotsInfoService = new TestSnapshotsInfoService();
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 0);  
        final TestGatewayAllocator gatewayAllocator,  
            boolean added = newSnapshotShardSizes.put(new InternalSnapshotsInfoService.SnapshotShard(snapshot, index, shard), size) == null;
    }
 */
        assertThat(clusterState.routingTable().shardsWithState(RELOCATING).size(), equalTo(5));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
        AllocationService strategy = createAllocationService(settings, gatewayAllocator);  
            .nodes(DiscoveryNodes.builder().add(node1))
        ClusterState clusterState = createPrimaryAndWaitForAllocation(strategy, node1, node2, settings);  
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node2"), 0);
        );  
 * Unless required by applicable law or agreed to in writing,
            .put("cluster.routing.allocation.exclude._id", "node1")
                    // Also set the snapshot shard size
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node2"), equalTo(0));  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        DiscoveryNode node1  
import java.util.HashMap;  
            indexMetadata.putInSyncAllocationIds(shard, Collections.singleton(started.allocationId().getId()));  
        clusterState = strategy.reroute(clusterState, "reroute");
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
        logger.info("start one more node, initializing second non-primary");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
    }  
        Settings settings  
    }  
                case 2:  
            clusterState,
            .build();  
        for (int shard = 0; shard < indexMetadata.numberOfShards(); shard++) {
        logger.info("start initializing non-primary");  
import java.util.HashSet;
 * SPDX-License-Identifier: Apache-2.0
            .build();
                addInSyncAllocationIds(index, indexMetadataBuilder, gatewayAllocator, node1);
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 0);
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node3"), equalTo(0));
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;  
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(0));
                primary ? RecoverySource.EmptyStoreRecoverySource.INSTANCE : RecoverySource.PeerRecoverySource.INSTANCE,
 * compatible open source license.
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(0));
            .put("cluster.routing.allocation.node_initial_primaries_recoveries", 5)
        DiscoveryNode node1 = newNode("node1");
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node2"), equalTo(1));
        assertThat(indexRouting.shardsWithState(INITIALIZING).size(), equalTo(newIndexInitializingAfterReroute));
            for (ShardRouting shard : routingTable.allShards()) {  
                            new IndexId(indexMetadata.getIndex().getName(), UUIDs.randomBase64UUID(random()))
        assertEquals(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node1"), 1);
        Settings settings = Settings.builder()
import org.opensearch.test.gateway.TestGatewayAllocator;
                    snapshotIndices.add(index.getName());
        assertEquals(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node1"), 1);
            snapshotsInfoService
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(1));  
        logger.info("Building initial routing table");
        logger.info("start initializing, another 3 should initialize");  
            true,
        logger.info("increasing the number of replicas to 1, and perform a reroute (to get the replicas allocation going)");
        logger.info("start one more node, first non-primary should start being allocated");
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node1"), equalTo(1));
            final ShardRouting unassigned = ShardRouting.newUnassigned(
            );
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(1));
        logger.info("start initializing replicas");
        assertThat(clusterState.routingTable().shardsWithState(RELOCATING).size(), equalTo(1));  
                RestoreInProgress.State.INIT,
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 5);
        logger.info("start one more node");  
        Metadata metadata = Metadata.builder()  
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node3"), equalTo(0));
            .build();
        int replicas = randomIntBetween(1, 2);
 */  
import org.opensearch.snapshots.Snapshot;
import static org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING;  
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 0);  
    ) {
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
    ) {
        logger.info("with one node, do reroute, only 1 should initialize");  
        TestGatewayAllocator gatewayAllocator,
    public void testOutgoingThrottlesAllocationOldIndex() {
            .customs(restores)
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
        clusterState = commandsResult.getClusterState();
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node2"), equalTo(2));  
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 0);  
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(5));
import org.opensearch.cluster.ClusterState;
    }
import org.opensearch.cluster.routing.ShardRoutingHelper;
 *
            .build();
        int replicasConcurrentRecoveries = randomIntBetween(1, 2);  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();  
        return createRecoveryStateAndInitializeAllocations(metadata, gatewayAllocator, snapshotsInfoService, null);  
        logger.info("start the relocating shards, one more shard should relocate away from node1");  
                .build();
            .build();
        clusterState = increaseReplicaCountAndTriggerReroute(strategy, clusterState, indices, 1);  
            clusterState,
        logger.info("Building initial routing table");
                }
 * KIND, either express or implied.  See the License for the
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(10));
        TestGatewayAllocator gatewayAllocator = new TestGatewayAllocator();
        settings = Settings.builder()
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 1);
        AllocationService strategy = createAllocationService(
        assertThat(indexRouting.shardsWithState(UNASSIGNED).size(), equalTo(newIndexUnassignedAfterReroute));  
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(2));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
        logger.info("create a new index");  
        ClusterState clusterState
    }  
        logger.info("start one node, do reroute, only 3 should initialize");
                case 1:  
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node1"), equalTo(0));
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(9));
        ClusterState clusterState = createRecoveryStateAndInitializeAllocations(metadata, gatewayAllocator, snapshotsInfoService);
        logger.info("Building initial routing table");  
        TestSnapshotsInfoService snapshotsInfoService = new TestSnapshotsInfoService();  
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(0));
        logger.info("with one node, do reroute, only 1 should initialize");
            if (recoveryType <= 4) {  
            Settings.builder()
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(3));
        RoutingTable updatedRoutingTable = RoutingTable.builder(clusterState.routingTable()).addAsNew(metadata.index("new_index")).build();
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(3));  
        assertThat(clusterState.routingTable().shardsWithState(RELOCATING).size(), equalTo(1));
                    routingTableBuilder.addAsNewRestore(
            primaries,  
                case 3:  
    public void testOutgoingThrottlesAllocationNewIndex() {
import org.opensearch.cluster.routing.RoutingTable;
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(),  
        IndexMetadata.Builder indexMetadata,
import org.opensearch.cluster.routing.RecoverySource;  
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(2));
                        indexMetadata,
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .metadata(metadata)
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node1"), equalTo(1));
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2")).add(newNode("node3")))  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        );  
            // Some indices are restored from snapshot, the RestoreInProgress must be set accordingly
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node3"), equalTo(0));
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node4"), equalTo(0));  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
        final TestSnapshotsInfoService snapshotsInfoService,
 *     http://www.apache.org/licenses/LICENSE-2.0
                    break;
        clusterState = strategy.reroute(clusterState, "reroute");
            gatewayAllocator,
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();
    private ClusterState increaseReplicaCountAndTriggerReroute(
        ClusterState clusterState = createRecoveryStateAndInitializeAllocations(metadata, gatewayAllocator, snapshotsInfoService, 5);
            clusterState = strategy.reroute(clusterState, "reroute");
        logger.info("Start primary on node4. Now all replicas for that primary start getting accounted for from node4.");
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4"))).build();
        clusterState = strategy.applyStartedShards(  
    public void testThrottleIncomingAndOutgoing() {
/*  
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node1"), equalTo(0));  
                )
        clusterState = strategy.reroute(clusterState, "reroute");  
        logger.info("start initializing, another 1 should initialize");
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), equalTo(0));
        // even though it is throttled, move command still forces allocation
import org.opensearch.repositories.IndexId;
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node1"), equalTo(1));
            .build();  
        final Integer inputRecoveryType
        clusterState = strategy.reroute(clusterState, "reroute");  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                .build(),  
        assertEquals(commandsResult.explanations().explanations().get(0).decisions().type(), Decision.Type.YES);
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(11));  
        RoutingTable updatedRoutingTable = RoutingTable.builder(clusterState.routingTable())  
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(1));  
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node2"), equalTo(0));
        Metadata metadata = Metadata.builder()
        int newIndexReplicas,  
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(10));  
            .put("cluster.routing.allocation.cluster_concurrent_rebalance", 5)
            .build();
 * software distributed under the License is distributed on an
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(5));
        AllocationService strategy,
                    break;  
            .build();  
                    final ShardId shardId = shard.shardId();
        );  
                case 0:  
        if (additionalNodeAfterPrimaryAssignment) {  
        );  
                new ShardId(index, shard),  
                            new IndexId(indexMetadata.getIndex().getName(), UUIDs.randomBase64UUID(random()))  
    }
            .build();
            clusterState,
import org.opensearch.snapshots.SnapshotShardSizeInfo;  
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(5));
        TestSnapshotsInfoService snapshotsInfoService = new TestSnapshotsInfoService();
        assertThat(clusterState.routingTable().index("new_index").shardsWithState(RELOCATING).size(), equalTo(1));
            .build();
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), equalTo(1));
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(1));
 *
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(1));
import java.util.Set;  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))
    private final Logger logger = LogManager.getLogger(ThrottlingAllocationTests.class);
        int newIndexInitializingAfterReroute = replicasConcurrentRecoveries * 2;
    }
            .build();
        assertEquals(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node1"), 0);
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(1));  
        assertEquals(clusterState.getRoutingNodes().getIncomingRecoveries("node2"), 3);
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 1);
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(1));
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING.getKey(), 20)  
            Settings.builder()  
                    decision.getExplanation()
        ClusterState clusterState,  
    }  
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node3"), equalTo(0));
        logger.info("create a new index and start all primaries");  
        TestGatewayAllocator gatewayAllocator = new TestGatewayAllocator();
            .put("cluster.routing.allocation.node_concurrent_recoveries", 5)  
    ) {  
                    snapshotsInfoService.addSnapshotShardSize(recoverySource.snapshot(), recoverySource.index(), shardId, shardSize);
        }  
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(2));  
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(2));  
                            Version.CURRENT,
        logger.info("start another 2 nodes, 5 shards should be relocating - at most 5 are allowed per node");
    private ClusterState createPrimaryAndWaitForAllocation(
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;  
                .build(),  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
            false
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(3));  
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(8));
        AllocationService.CommandsResult commandsResult = strategy.reroute(
        logger.info("1 replica should be initializing now for the existing indices (we throttle to 1) on each node");
        clusterState = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node1"), equalTo(1));
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(0));
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(4));
 */  
import org.opensearch.cluster.routing.ShardRouting;  
        return clusterState;
                    throw new IndexOutOfBoundsException();
        String restoreUUID = UUIDs.randomBase64UUID();  
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(0));
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(0));
        clusterState = ClusterState.builder(clusterState)
    private ClusterState createNewIndexAndStartAllPrimaries(
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                        + "(can also be set via [cluster.routing.allocation.node_concurrent_recoveries])",  
        ClusterState clusterState = createRecoveryStateAndInitializeAllocations(metadata, gatewayAllocator, snapshotsInfoService);
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
            replicas,
        Metadata metadata = Metadata.builder()
        logger.info("move started non-primary to new node");  
        assertThat(clusterState.routingTable().index("new_index").shardsWithState(UNASSIGNED).size(), equalTo(0));
        Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap", "randomId"));
                        new SnapshotRecoverySource(
        clusterState = commandsResult.getClusterState();
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(0));
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node2"), 0);
            .build();
    private void verifyNewIndexReplicaAllocation(
        clusterState = strategy.reroute(clusterState, "reroute");
                            restoreUUID,
            .routingTable(routingTable)  
                    );
        clusterState = createNewIndexAndStartAllPrimaries(2, 2, strategy, clusterState);
 * The OpenSearch Contributors require contributions made to  
            .build();
        assertEquals(clusterState.getRoutingNodes().getIncomingRecoveries("node3"), 1);  
        logger.info("start one more node");
        assertEquals(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node2"), 0);  
        clusterState = strategy.reroute(clusterState, "reroute");
            this.snapshotShardSizes = Collections.unmodifiableMap(newSnapshotShardSizes);
            ShardRouting started = ShardRoutingHelper.moveToStarted(ShardRoutingHelper.initialize(unassigned, node1.getId()));
                            restoreUUID,  
                    break;
        assertEquals(clusterState.getRoutingNodes().getIncomingRecoveries("node1"), 0);
}  
        assertThat(clusterState.routingTable().index("new_index").shardsWithState(UNASSIGNED).size(), equalTo(0));
        clusterState = strategy.reroute(clusterState, "reroute");  
        assertThat(clusterState.routingTable().shardsWithState(RELOCATING).size(), equalTo(1));  
        return clusterState;
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey(), 1)
                foundThrottledMessage = true;
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(0));
        );  
        logger.info("start initializing non-primary");
                .put("cluster.routing.allocation.node_concurrent_outgoing_recoveries", 1)  
        assertEquals(clusterState.getRoutingNodes().getIncomingRecoveries("node3"), 2);  
        clusterState = strategy.reroute(clusterState, "reroute");  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
                restoreShards
        Metadata metadata = Metadata.builder(clusterState.metadata())
            primaries * replicas - newIndexInitializingAfterReroute,  
            }  
                + "non initial replica recoveries are impacted"
        String[] indices,
            .build();  
        }
        DiscoveryNode node1 = newNode("node1");  
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;  
        final Map<String, ClusterState.Custom> restores = new HashMap<>();
                        new SnapshotRecoverySource(
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING.getKey(), 20)  
        clusterState = strategy.reroute(clusterState, "reroute");
        logger.info("Apply started shards for new index");
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(4));
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node1"), equalTo(2));
            snapshotsInfoService
        assertEquals(commandsResult.explanations().explanations().get(0).decisions().type(), Decision.Type.THROTTLE);
        Set<String> snapshotIndices = new HashSet<>();
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node1"), equalTo(0));  
                    snapshotIndices.add(index.getName());
        int replicaConcurrentRecoveriesLimit,
    }
        metaData = Metadata.builder(clusterState.metadata()).updateNumberOfReplicas(replicaCount, indices).build();  
            final boolean primary = randomBoolean();
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node3"), equalTo(2));  
            return new SnapshotShardSizeInfo(snapshotShardSizes);  
        int newIndexInitializingAfterReroute,
        assertEquals(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node1"), 1);  
        logger.info("Building initial routing table");
        AllocationService strategy = createAllocationService(
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4"))).build();  
        assertThat(clusterState.routingTable().index("new_index").shardsWithState(UNASSIGNED).size(), equalTo(0));
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 0);
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(0));
    public void testRecoveryCounts() {
            false
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                    break;  
            }  
            clusterState = strategy.applyStartedShards(clusterState, clusterState.routingTable().shardsWithState(INITIALIZING));
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node2"), equalTo(0));
            .getRoutingNodes()
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(10));  
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node2"), equalTo(1));
        logger.info("with one node, do reroute, only 3 should initialize");  
        final TestSnapshotsInfoService snapshotsInfoService
            .build();
    }
import org.opensearch.cluster.routing.UnassignedInfo;
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(0));
    }  
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(1));
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 5)  
            final Map<ShardId, RestoreInProgress.ShardRestoreStatus> restoreShards = new HashMap<>();
        assertThat(clusterState.routingTable().index("new_index").shardsWithState(INITIALIZING).size(), equalTo(4));
        assertThat(clusterState.routingTable().index("new_index").shardsWithState(RELOCATING).size(), equalTo(0));  
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(2));  
        RoutingTable initialRoutingTable = RoutingTable.builder()
    }  
        final RoutingTable routingTable = routingTableBuilder.build();  
        logger.info("start initializing, all primaries should be started");
        DiscoveryNode node2 = newNode("node2");
import org.opensearch.cluster.metadata.IndexMetadata;
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(3));
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.snapshots.SnapshotsInfoService;
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();  
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(2));  
import org.opensearch.cluster.OpenSearchAllocationTestCase;
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node4"), equalTo(2));
        private volatile Map<InternalSnapshotsInfoService.SnapshotShard, Long> snapshotShardSizes = Map.of();
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 1)
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(1));
    private void addInSyncAllocationIds(
                    randomIntBetween(3, 10)
                            snapshot,
            "Exclude node1 and add node4. After this, primary shard on node1 moves to RELOCATING state and only "
        Index index,  
                .put("cluster.routing.allocation.node_concurrent_recoveries", 3)
        logger.info("start one more node, first non-primary should start being allocated");  
 * ownership. Elasticsearch licenses this file to you under  
            gatewayAllocator.addKnownAllocation(started);
        AllocationService strategy = createAllocationService(
    }  
        );
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 3)
        IndexRoutingTable indexRouting = clusterState.routingTable().index("new_index");
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 1);  
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(14));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));  
        logger.info("start one more node, initializing second non-primary");
            newIndexInitializingAfterReroute,
        clusterState = strategy.reroute(clusterState, "reroute");  
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(6));
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(0));  
        synchronized void addSnapshotShardSize(Snapshot snapshot, IndexId index, ShardId shard, Long size) {  
 * not use this file except in compliance with the License.
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(2));  
                new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "test")  
        return clusterState;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node4"), equalTo(0));
        logger.info("start initializing");
        TestSnapshotsInfoService snapshotsInfoService = new TestSnapshotsInfoService();  
        clusterState = strategy.reroute(clusterState, "reroute");
            new AllocationCommands(new MoveAllocationCommand("test", 0, "node2", "node4")),  
 * GitHub history for details.
                new ArrayList<>(snapshotIndices),  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(9).numberOfReplicas(0))  
                        )
                        indexMetadata,  
            Settings.builder()  
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node2"), equalTo(1));  
            assert added : "cannot add snapshot shard size twice";  
        clusterState = createNewIndexAndStartAllPrimaries(newIndexPrimaries, newIndexReplicas, strategy, clusterState);
import org.opensearch.cluster.routing.IndexRoutingTable;
        }
 * specific language governing permissions and limitations
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node1"), equalTo(2));  
    public void testNewIndexReplicaAllocationIncomingAndOutgoingLimitBreached() {  
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(0));
                    final SnapshotRecoverySource recoverySource = (SnapshotRecoverySource) shard.recoverySource();
        Metadata metaData = Metadata.builder()
        AllocationService strategy = createAllocationService(settings, gatewayAllocator);
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(1));
        logger.info("start initializing, all primaries should be started");
        for (Decision decision : commandsResult.explanations().explanations().get(0).decisions().getDecisions()) {
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node4"), equalTo(1));  
                replicaConcurrentRecoveriesLimit
        logger.info("with one node, do reroute, only 5 should initialize");
        assertEquals(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node1"), 0);
            .persistentSettings(settings)
        assertEquals(clusterState.getRoutingNodes().getIncomingRecoveries("node1"), 0);
        int newIndexUnassignedAfterReroute,  
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(5));  
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(0));  
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node3"), equalTo(0));
    ) {  
import org.opensearch.Version;  
        verifyNewIndexReplicaAllocation(
            final Map<InternalSnapshotsInfoService.SnapshotShard, Long> newSnapshotShardSizes = new HashMap<>(snapshotShardSizes);
        TestSnapshotsInfoService snapshotsInfoService = new TestSnapshotsInfoService();
    private static class TestSnapshotsInfoService implements SnapshotsInfoService {
        assertEquals(clusterState.getRoutingNodes().getInitialPrimariesIncomingRecoveries("node1"), 5);
                .put(
                case 4:
                    routingTableBuilder.addAsRecovery(indexMetadata);
            );
        DiscoveryNode node2,
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(node1).add(node2)).build();
        logger.info("start initializing replicas, all should be started");  
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(2));
 * under the License.  
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(1));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();  
        assertThat(indexRouting.shardsWithState(INITIALIZING).size(), equalTo(newIndexInitializingAfterReroute));
                    routingTableBuilder.addAsRestore(  
            }
        int primaries = randomIntBetween(5, 30);
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(5));
 * this file be licensed under the Apache-2.0 license or a
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(1));
                case 5:
        TestGatewayAllocator gatewayAllocator = new TestGatewayAllocator();  
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(0))
        assertEquals(commandsResult.explanations().explanations().size(), 1);
public class ThrottlingAllocationTests extends OpenSearchAllocationTestCase {
            .build();
                    break;  
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node4"), equalTo(0));
        TestGatewayAllocator gatewayAllocator = new TestGatewayAllocator();  
        clusterState = strategy.reroute(clusterState, "reroute");  
        Metadata.Builder metadataBuilder = new Metadata.Builder(metadata);
import org.opensearch.common.settings.Settings;
        logger.info("start initializing, another 3 should initialize");
        AllocationService.CommandsResult commandsResult = strategy.reroute(
 * the Apache License, Version 2.0 (the "License"); you may
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        Metadata metadata = Metadata.builder()
        boolean foundThrottledMessage = false;  
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(3));
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(0));  
            .build();  
            new AllocationCommands(new MoveAllocationCommand("test", 0, "node2", "node4")),  
        logger.info("adding two nodes and performing rerouting till all are allocated");  
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(5));  
        @Override
        AllocationService strategy = createAllocationService(settings, gatewayAllocator, snapshotsInfoService);
        if (snapshotIndices.isEmpty() == false) {  
        int totalIncomingRecoveriesNewIndex = clusterState.getRoutingNodes().getInitialIncomingRecoveries("node1") + clusterState  
                primary,
        }
        DiscoveryNode node1,
        ClusterState clusterState = createRecoveryStateAndInitializeAllocations(metadata, gatewayAllocator, snapshotsInfoService, 1);
    ) {
            )
        logger.info("move started non-primary to new node");  
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node4"), equalTo(0));
            if (decision.label().equals(ThrottlingAllocationDecider.NAME)) {
        boolean additionalNodeAfterPrimaryAssignment
            clusterState.routingTable().index("new_index").shardsWithState(INITIALIZING)
        TestGatewayAllocator gatewayAllocator = new TestGatewayAllocator();
                assertEquals(Decision.Type.THROTTLE, decision.type());  
        logger.info("start initializing, another 2 should initialize");
        strategy = createAllocationService(settings, gatewayAllocator);
        );  
            metadataBuilder.put(indexMetadata, false);
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(1));
                    routingTableBuilder.addAsFromCloseToOpen(indexMetadata);
            .addAsNew(metaData.index("test2"))
import org.opensearch.cluster.node.DiscoveryNode;  
                    final long shardSize = randomNonNegativeLong();  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        clusterState = strategy.reroute(clusterState, "reroute");
        logger.info("start another node, replicas should start being allocated");  
        Metadata metadata = Metadata.builder()  
        );
                        new HashSet<>()
    ) {  
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(5));
                .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3")))  
        clusterState = ClusterState.builder(clusterState).routingTable(updatedRoutingTable).metadata(metaData).build();
                default:
        verifyNewIndexReplicaAllocation(primaries, newIndexReplicas, primaries * newIndexReplicas, 0, replicasConcurrentRecoveries, false);
                .build(),
            .getInitialIncomingRecoveries("node2") + clusterState.getRoutingNodes().getInitialIncomingRecoveries("node3");
                .stream()  
        clusterState = strategy.reroute(clusterState, "reroute");
            gatewayAllocator,  
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node2"), equalTo(2));
            false
 *  
        assertTrue(foundThrottledMessage);
        int replicaCount
        logger.info("reroute, verify that primaries for the new index primary shards are allocated");
                        + "cluster setting [cluster.routing.allocation.node_concurrent_outgoing_recoveries=1] "
package org.opensearch.cluster.routing.allocation;
                restoreUUID,  
            .addAsNew(metaData.index("test1"))  
        logger.info("Add a new node for all replica assignment. 4 replicas move to INIT after reroute.");  
import org.opensearch.cluster.routing.allocation.decider.Decision;
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node2"), equalTo(0));
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(0));  
        int newIndexReplicas = 1;  
        verifyNewIndexReplicaAllocation(5, 1, 2, 3, 1, true);
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 1);
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(10).numberOfReplicas(1))
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(2));
        AllocationService strategy,
            snapshotsInfoService
        int newIndexReplicas,
            clusterState,
    private ClusterState createRecoveryStateAndInitializeAllocations(
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(7));
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(1));
import java.util.ArrayList;
        int newIndexPrimaries,  
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 3)
        ClusterState clusterState = createRecoveryStateAndInitializeAllocations(metadata, gatewayAllocator, snapshotsInfoService);  
            .put(
        assertEquals(clusterState.getRoutingNodes().getIncomingRecoveries("node2"), 0);
    }  
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(2));
            .updateNumberOfReplicas(replicaCount, indices)
            clusterState = ClusterState.builder(clusterState)
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
        clusterState = strategy.reroute(clusterState, "reroute");
                    break;
            switch (recoveryType) {
        Settings settings = Settings.builder()
            restores.put(RestoreInProgress.TYPE, new RestoreInProgress.Builder().add(restore).build());  
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node4"), equalTo(0));
