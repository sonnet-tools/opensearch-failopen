        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(1));
        RoutingTable updatedRoutingTable = RoutingTable.builder(clusterState.routingTable())
                    break;
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 3)
        assertThat(indexRouting.shardsWithState(INITIALIZING).size(), equalTo(newIndexInitializingAfterReroute));
    public void testRecoveryCounts() {
    private static class TestSnapshotsInfoService implements SnapshotsInfoService {
                assertEquals(Decision.Type.THROTTLE, decision.type());
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node3"), equalTo(0));
        logger.info("start another node, replicas should start being allocated");
import org.opensearch.cluster.routing.ShardRoutingHelper;
import java.util.stream.Collectors;
        clusterState = strategy.reroute(clusterState, "reroute");
            true,
                primary ? RecoverySource.EmptyStoreRecoverySource.INSTANCE : RecoverySource.PeerRecoverySource.INSTANCE,
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(4));
            new AllocationCommands(new MoveAllocationCommand("test", 0, "node2", "node4")),
        clusterState = strategy.reroute(clusterState, "reroute");
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
            gatewayAllocator,
import org.opensearch.cluster.node.DiscoveryNode;
            gatewayAllocator,
            .build();
            final boolean primary = randomBoolean();
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 0);
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node1"), equalTo(1));
            )
    private ClusterState increaseReplicaCountAndTriggerReroute(
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(6));
        int newIndexReplicas,
            restores.put(RestoreInProgress.TYPE, new RestoreInProgress.Builder().add(restore).build());
            }
                .put("cluster.routing.allocation.node_concurrent_outgoing_recoveries", 1)
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(1));
            gatewayAllocator,
        assertEquals(commandsResult.explanations().explanations().size(), 1);
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(0));
        verifyNewIndexReplicaAllocation(5, 1, 2, 3, 1, true);
        String[] indices,
            }
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node3"), equalTo(0));
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(10));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(10).numberOfReplicas(1))
                        new SnapshotRecoverySource(
                        indexMetadata,
        assertThat(clusterState.routingTable().index("new_index").shardsWithState(UNASSIGNED).size(), equalTo(0));
 * this work for additional information regarding copyright
            replicasConcurrentRecoveries,
        AllocationService strategy = createAllocationService(
        TestGatewayAllocator gatewayAllocator = new TestGatewayAllocator();
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(0));
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node2"), equalTo(0));
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node2"), 0);
        logger.info("start initializing, another 2 should initialize");
            .build();
        String[] indices = { "test1", "test2" };
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(2));
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(3));
import org.opensearch.common.UUIDs;
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 1);
        );
        assertEquals(clusterState.getRoutingNodes().getIncomingRecoveries("node2"), 0);
            .build();
            .build();
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(),
            .build();
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(2));
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node2"), equalTo(1));
            .persistentSettings(settings)
                        new SnapshotRecoverySource(
        ClusterState clusterState = createRecoveryStateAndInitializeAllocations(metadata, gatewayAllocator, snapshotsInfoService, 5);
        clusterState = strategy.reroute(clusterState, "reroute");
        Metadata.Builder metadataBuilder = new Metadata.Builder(metadata);
        AllocationService.CommandsResult commandsResult = strategy.reroute(
 *
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 5)
        clusterState = strategy.reroute(clusterState, "reroute");
        synchronized void addSnapshotShardSize(Snapshot snapshot, IndexId index, ShardId shard, Long size) {
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node4"), equalTo(0));
                case 2:
        AllocationService strategy = createAllocationService(settings, gatewayAllocator);
            assert added : "cannot add snapshot shard size twice";
                )
import static org.hamcrest.Matchers.equalTo;
    }
import org.opensearch.snapshots.Snapshot;
    ) {
        Set<String> snapshotIndices = new HashSet<>();
        logger.info(
import org.opensearch.cluster.routing.RoutingTable;
import org.opensearch.core.index.Index;
        logger.info("start initializing non-primary");
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(2));
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(14));
                .put("cluster.routing.allocation.concurrent_source_recoveries", 3)
    }
        logger.info("start initializing, all primaries should be started");
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node2"), equalTo(0));
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(5));
        private volatile Map<InternalSnapshotsInfoService.SnapshotShard, Long> snapshotShardSizes = Map.of();
        assertEquals(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node1"), 0);
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node2"), equalTo(0));
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(5));
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 3)
import java.util.HashMap;
        int primaries = randomIntBetween(5, 30);
        int newIndexPrimaries,
                );
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(5));
        final TestSnapshotsInfoService snapshotsInfoService
        boolean foundThrottledMessage = false;
        logger.info("start initializing, all primaries should be started");
                    final SnapshotRecoverySource recoverySource = (SnapshotRecoverySource) shard.recoverySource();
        }
        clusterState = strategy.reroute(clusterState, "reroute");
                            snapshot,
        logger.info("start one node, do reroute, only 3 should initialize");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertEquals(clusterState.getRoutingNodes().getInitialPrimariesIncomingRecoveries("node1"), 5);
                    snapshotsInfoService.addSnapshotShardSize(recoverySource.snapshot(), recoverySource.index(), shardId, shardSize);
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(0));
        int newIndexReplicas,
        logger.info("start the relocating shards, one more shard should relocate away from node1");
    public void testNewIndexReplicaAllocationOutgoingLimitBreachedIncomingNotBreached() {
        clusterState = strategy.reroute(clusterState, "reroute");
    ) {
                    final ShardId shardId = shard.shardId();
        ClusterState clusterState = createRecoveryStateAndInitializeAllocations(metadata, gatewayAllocator, snapshotsInfoService);
        ClusterState clusterState = createRecoveryStateAndInitializeAllocations(metadata, gatewayAllocator, snapshotsInfoService);
        ClusterState clusterState
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(1));
        TestSnapshotsInfoService snapshotsInfoService = new TestSnapshotsInfoService();
            .updateNumberOfReplicas(replicaCount, indices)
        logger.info("start one more node");
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node2"), equalTo(2));
        clusterState = ClusterState.builder(clusterState)
        logger.info("start initializing, another 1 should initialize");
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2")).add(newNode("node3")))
 * Unless required by applicable law or agreed to in writing,
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(2));
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(0));
        clusterState = strategy.reroute(clusterState, "reroute");
        assertThat(totalIncomingRecoveriesNewIndex, equalTo(newIndexInitializingAfterReroute));
        logger.info("start initializing, all primaries should be started");
            );
import org.opensearch.snapshots.SnapshotShardSizeInfo;
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(5));
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(0));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();
            // Some indices are restored from snapshot, the RestoreInProgress must be set accordingly
            clusterState = strategy.reroute(clusterState, "reroute");
    }
        logger.info("Building initial routing table");
                    throw new IndexOutOfBoundsException();
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(1));
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(0));
                }
            boolean added = newSnapshotShardSizes.put(new InternalSnapshotsInfoService.SnapshotShard(snapshot, index, shard), size) == null;
        clusterState = strategy.applyStartedShards(
    ) {
import org.opensearch.common.settings.Settings;
        DiscoveryNode node1
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            metadataBuilder.put(indexMetadata, false);
        metaData = Metadata.builder(clusterState.metadata()).updateNumberOfReplicas(replicaCount, indices).build();
                RestoreInProgress.State.INIT,
        assertEquals(clusterState.getRoutingNodes().getIncomingRecoveries("node3"), 2);
import org.apache.logging.log4j.LogManager;
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node2"), equalTo(1));
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), equalTo(1));
        clusterState = commandsResult.getClusterState();
            Settings.builder()
                + "non initial replica recoveries are impacted"
            .put(
        int replicasConcurrentRecoveries = randomIntBetween(1, 2);
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                    routingTableBuilder.addAsRecovery(indexMetadata);
                    break;
        assertThat(clusterState.routingTable().index("new_index").shardsWithState(UNASSIGNED).size(), equalTo(0));
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node1"), equalTo(0));
    private ClusterState createRecoveryStateAndInitializeAllocations(
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(indexRouting.shardsWithState(UNASSIGNED).size(), equalTo(newIndexUnassignedAfterReroute));
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(1));
        final Metadata metadata,
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node2"), 0);
            Settings.builder()
    }
                        )
        TestGatewayAllocator gatewayAllocator,
        clusterState = strategy.reroute(clusterState, "reroute");
            .nodes(DiscoveryNodes.builder().add(node1))
            .addAsNew(metaData.index("test1"))
            .put("cluster.routing.allocation.node_concurrent_recoveries", 1)
        assertThat(clusterState.routingTable().shardsWithState(RELOCATING).size(), equalTo(1));
        logger.info("start initializing replicas");
        Settings settings = Settings.builder()
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(11));
            snapshotsInfoService
        TestSnapshotsInfoService snapshotsInfoService = new TestSnapshotsInfoService();
    }
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(0));
        clusterState = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node3"), equalTo(2));
 */
        assertThat(clusterState.routingTable().index("new_index").shardsWithState(RELOCATING).size(), equalTo(1));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            clusterState.routingTable().index("new_index").shardsWithState(INITIALIZING)
            IndexMetadata indexMetadata = indexMetadataBuilder.build();
    }
        clusterState = strategy.reroute(clusterState, "reroute");
    public void testThrottleIncomingAndOutgoing() {
import org.opensearch.repositories.IndexId;
        logger.info("increasing the number of replicas to 1, and perform a reroute (to get the replicas allocation going)");
                            new IndexId(indexMetadata.getIndex().getName(), UUIDs.randomBase64UUID(random()))
            clusterState,
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(0));
        AllocationService strategy = createAllocationService(
        logger.info("start one more node");
        indexRouting = clusterState.routingTable().index("new_index");
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(2));
                    );
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(3));
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(2));
        assertEquals(commandsResult.explanations().explanations().get(0).decisions().type(), Decision.Type.YES);
        }
        logger.info("with one node, do reroute, only 1 should initialize");
    public void testNewIndexReplicaAllocationIncomingAndOutgoingLimitBreached() {
            clusterState,
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(0));
            primaries * replicas - newIndexInitializingAfterReroute,
                snapshot,
        int newIndexInitializingAfterReroute,
        Metadata metadata = Metadata.builder().persistentSettings(settings).build();
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node4"), equalTo(0));
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(4));
                    decision.getExplanation()
            .build();
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 3)
                        + "(can also be set via [cluster.routing.allocation.node_concurrent_recoveries])",
        );
        assertEquals(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node1"), 1);
        TestGatewayAllocator gatewayAllocator = new TestGatewayAllocator();
                            Version.CURRENT,
                primary,
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(0));
        TestSnapshotsInfoService snapshotsInfoService = new TestSnapshotsInfoService();
        assertEquals(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node1"), 1);
        logger.info("start one more node, first non-primary should start being allocated");
            .addAsNew(metaData.index("test2"))
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node2"), equalTo(0));
        assertThat(clusterState.routingTable().index("new_index").shardsWithState(RELOCATING).size(), equalTo(0));
        int totalIncomingRecoveriesNewIndex = clusterState.getRoutingNodes().getInitialIncomingRecoveries("node1") + clusterState
        for (Decision decision : commandsResult.explanations().explanations().get(0).decisions().getDecisions()) {
/*
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(0));
                    break;
        logger.info("start initializing non-primary");
                case 1:
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node4"), equalTo(0));
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 0);
    }
            .put("cluster.routing.allocation.exclude._id", "node1")
        logger.info("with one node, do reroute, only 5 should initialize");
                    "reached the limit of outgoing shard recoveries [1] on the node [node1] which holds the primary, "
import java.util.Map;
/*
        int newIndexPrimaries,
        clusterState = strategy.reroute(clusterState, "reroute");
                    routingTableBuilder.addAsFromCloseToOpen(indexMetadata);
        Settings settings = Settings.builder()
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(1));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(9).numberOfReplicas(0))
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        }
                            restoreUUID,
        assertThat(clusterState.routingTable().shardsWithState(RELOCATING).size(), equalTo(1));
            false
        TestGatewayAllocator gatewayAllocator = new TestGatewayAllocator();
                restoreUUID,
            .build();
import org.opensearch.Version;
        );
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(5));
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 2)
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node2"), equalTo(0));
 * specific language governing permissions and limitations
            final Map<InternalSnapshotsInfoService.SnapshotShard, Long> newSnapshotShardSizes = new HashMap<>(snapshotShardSizes);
            .build();
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node4"), equalTo(2));
        AllocationService strategy = createAllocationService(settings, gatewayAllocator, snapshotsInfoService);
 *
                .build(),
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        DiscoveryNode node2 = newNode("node2");
            .metadata(metadataBuilder.build())
        Metadata metadata = Metadata.builder()
        logger.info("start another 2 nodes, 5 shards should be relocating - at most 5 are allowed per node");
        return ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        ClusterState clusterState = createRecoveryStateAndInitializeAllocations(metadata, gatewayAllocator, snapshotsInfoService);
import org.opensearch.cluster.node.DiscoveryNodes;
    }
                    .numberOfReplicas(newIndexReplicas)
                case 5:
    }
        final Metadata metadata,
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
                    routingTableBuilder.addAsNew(indexMetadata);
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 1);
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(2));
import org.opensearch.cluster.RestoreInProgress;
        RoutingTable initialRoutingTable = RoutingTable.builder()
                .collect(Collectors.toList())
        logger.info("reroute, verify that primaries for the new index primary shards are allocated");
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node3"), equalTo(0));
            )
                    restoreShards.put(shardId, new RestoreInProgress.ShardRestoreStatus(node1.getId(), RestoreInProgress.State.INIT));
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(0));
    private final Logger logger = LogManager.getLogger(ThrottlingAllocationTests.class);
        DiscoveryNode node1 = newNode("node1");
            .getInitialIncomingRecoveries("node2") + clusterState.getRoutingNodes().getInitialIncomingRecoveries("node3");
import org.apache.logging.log4j.Logger;
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(2));
}
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        AllocationService strategy = createAllocationService(
 * KIND, either express or implied.  See the License for the
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node4"), equalTo(0));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        logger.info("start one more node, first non-primary should start being allocated");
        TestGatewayAllocator gatewayAllocator = new TestGatewayAllocator();
                .shardsWithState(INITIALIZING)
import org.opensearch.snapshots.SnapshotsInfoService;
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(7));
        for (int shard = 0; shard < indexMetadata.numberOfShards(); shard++) {
    ) {
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(0));
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(3));
            if (recoveryType <= 4) {
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
                new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "test")
        Settings settings = Settings.builder()
        logger.info("adding two nodes and performing rerouting till all are allocated");
 * The OpenSearch Contributors require contributions made to
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
            clusterState = ClusterState.builder(clusterState)
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(0));
        boolean additionalNodeAfterPrimaryAssignment
        assertThat(clusterState.routingTable().shardsWithState(RELOCATING).size(), equalTo(1));
 * You may obtain a copy of the License at
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(1));
                .put("cluster.routing.allocation.node_concurrent_recoveries", 3)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                case 4:
        RoutingTable updatedRoutingTable = RoutingTable.builder(clusterState.routingTable()).addAsNew(metadata.index("new_index")).build();
            RestoreInProgress.Entry restore = new RestoreInProgress.Entry(
    public void testNewIndexReplicaAllocationLimitNotBreached() {
                    routingTableBuilder.addAsNewRestore(
                    // Also set the snapshot shard size
                    randomIntBetween(3, 10)
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 0);
            Settings.builder()
        }
            .put(
        clusterState = strategy.applyStartedShards(
            .getRoutingNodes()
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node3"), equalTo(0));
        assertThat(clusterState.routingTable().shardsWithState(RELOCATING).size(), equalTo(5));
                    .numberOfShards(newIndexPrimaries)
        int newIndexInitializingAfterReroute = replicasConcurrentRecoveries * 2;
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(10));
            this.snapshotShardSizes = Collections.unmodifiableMap(newSnapshotShardSizes);
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();
        final Map<String, ClusterState.Custom> restores = new HashMap<>();
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
    private void verifyNewIndexReplicaAllocation(
                    break;
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node1"), equalTo(0));
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(0));
        TestGatewayAllocator gatewayAllocator = new TestGatewayAllocator();
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node3"), equalTo(0));
    public void testOutgoingThrottlesAllocationOldIndex() {
                IndexMetadata.builder("new_index")
            .put("cluster.routing.allocation.node_initial_primaries_recoveries", 20)
            final ShardRouting unassigned = ShardRouting.newUnassigned(
                    snapshotIndices.add(index.getName());
        int newIndexUnassignedAfterReroute,
        logger.info("Apply started shards for new index");
        logger.info("create a new index and start all primaries");
            Settings.builder()
 * under the License.
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(5));
        );
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 0);
                            new IndexId(indexMetadata.getIndex().getName(), UUIDs.randomBase64UUID(random()))
                addInSyncAllocationIds(index, indexMetadataBuilder, gatewayAllocator, node1);
        final TestSnapshotsInfoService snapshotsInfoService,
            snapshotsInfoService
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 1);
        final TestGatewayAllocator gatewayAllocator,
import java.util.HashSet;
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node2"), equalTo(0));
        ClusterState clusterState = createRecoveryStateAndInitializeAllocations(metadata, gatewayAllocator, snapshotsInfoService, 1);
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey(), 1)
        logger.info("Building initial routing table");
                    routingTableBuilder.addAsFromDangling(indexMetadata);
                        + "cluster setting [cluster.routing.allocation.node_concurrent_outgoing_recoveries=1] "
            final int recoveryType = inputRecoveryType == null ? randomInt(5) : inputRecoveryType.intValue();
                case 3:
            }
        clusterState = commandsResult.getClusterState();
        AllocationService strategy = createAllocationService(
            .build();
            .build();
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node3"), equalTo(0));
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node3"), equalTo(0));
            clusterState.routingTable()
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node4"), equalTo(0));
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING.getKey(), 20)
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node1"), equalTo(0));
        logger.info("with one node, do reroute, only 3 should initialize");
import org.opensearch.core.index.shard.ShardId;
        final TestGatewayAllocator gatewayAllocator,
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 5);
                foundThrottledMessage = true;
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4"))).build();
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(1));
            .routingTable(initialRoutingTable)
        clusterState = ClusterState.builder(clusterState).routingTable(updatedRoutingTable).metadata(metaData).build();
        assertEquals(commandsResult.explanations().explanations().size(), 1);
                .filter(routing -> routing.primary() && routing.isRelocationTarget())
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(3));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                .build();
 *
            clusterState,
        logger.info("1 replica should be initializing now for the existing indices (we throttle to 1) on each node");
            .put("cluster.routing.allocation.node_concurrent_recoveries", 5)
        assertEquals(commandsResult.explanations().explanations().get(0).decisions().type(), Decision.Type.THROTTLE);
        clusterState = increaseReplicaCountAndTriggerReroute(strategy, clusterState, indices, 1);
            clusterState,
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(10));
        ClusterState clusterState,
 *     http://www.apache.org/licenses/LICENSE-2.0
            gatewayAllocator,
        TestGatewayAllocator gatewayAllocator = new TestGatewayAllocator();
        Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap", "randomId"));
            .build();
    }
import java.util.ArrayList;
        int replicasConcurrentRecoveries = primaries * newIndexReplicas + randomIntBetween(1, 10);
        // even though it is throttled, move command still forces allocation
        Metadata metaData;
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));
                assertEquals(
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(0))
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(1));
        assertEquals(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node1"), 1);
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node1"), equalTo(0));
        logger.info("move started non-primary to new node");
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(1));
        );
        DiscoveryNode node1 = newNode("node1");
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4"))).build();
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node2"), equalTo(2));
        }
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 1);
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node3"), equalTo(2));
        }
        return clusterState;
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node3"), equalTo(0));
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(17));
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
                new ArrayList<>(snapshotIndices),
        int replicas = randomIntBetween(1, 2);
        clusterState = strategy.reroute(clusterState, "reroute");
            gatewayAllocator.addKnownAllocation(started);
        assertEquals(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node1"), 0);
        Metadata metadata = Metadata.builder()
            );
 * ownership. Elasticsearch licenses this file to you under
        Metadata metadata = Metadata.builder(clusterState.metadata())
    }
            final Map<ShardId, RestoreInProgress.ShardRestoreStatus> restoreShards = new HashMap<>();
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(1));
                        ),
        assertThat(clusterState.routingTable().index("new_index").shardsWithState(INITIALIZING).size(), equalTo(4));
        logger.info("start initializing");
import org.opensearch.cluster.metadata.IndexMetadata;
        clusterState = createNewIndexAndStartAllPrimaries(newIndexPrimaries, newIndexReplicas, strategy, clusterState);
        Metadata metadata = Metadata.builder()
    public void testPrimaryRecoveryThrottling() {
    }
        AllocationService strategy,
    }
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(1));
            false
                    );
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        clusterState = ClusterState.builder(clusterState).metadata(metadata).routingTable(updatedRoutingTable).build();
        ClusterState clusterState = createPrimaryAndWaitForAllocation(strategy, node1, node2, settings);
            .build();
import java.util.Set;
import org.opensearch.cluster.routing.ShardRouting;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node2"), equalTo(2));
                    routingTableBuilder.addAsRestore(
                case 0:
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(3));
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        @Override
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), equalTo(0));
                    .settings(settings(Version.CURRENT))
        assertEquals(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node2"), 0);
            new AllocationCommands(new MoveAllocationCommand("test", 0, "node2", "node4")),
        for (final IndexMetadata cursor : metadata.indices().values()) {
 * not use this file except in compliance with the License.
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(node1).add(node2)).build();
                            Version.CURRENT,
        DiscoveryNode node2,
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(0));
        Metadata metadata = Metadata.builder()
    }
        int newIndexReplicas = 1;
                replicaConcurrentRecoveriesLimit
        clusterState = strategy.reroute(clusterState, "reroute");
            .build();
 * this file be licensed under the Apache-2.0 license or a
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .build();
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(0));
import org.opensearch.cluster.routing.RecoverySource;
                .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3")))
                            restoreUUID,
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 2);
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(0));
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 1);
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node1"), equalTo(1));
            replicas,
        verifyNewIndexReplicaAllocation(
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node1"), equalTo(2));
        assertEquals(clusterState.getRoutingNodes().getIncomingRecoveries("node1"), 0);
        Metadata metadata = Metadata.builder()
            .build();
        logger.info("Add a new node for all replica assignment. 4 replicas move to INIT after reroute.");
            return new SnapshotShardSizeInfo(snapshotShardSizes);
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 1)
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node1"), equalTo(0));
            .build();
            snapshotsInfoService
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 2)
                restoreShards
        assertThat(indexRouting.shardsWithState(INITIALIZING).size(), equalTo(newIndexInitializingAfterReroute));
                .index("new_index")
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node3"), equalTo(0));
        return createRecoveryStateAndInitializeAllocations(metadata, gatewayAllocator, snapshotsInfoService, null);
        clusterState = strategy.reroute(clusterState, "reroute");
        );
        int primaries = randomIntBetween(5, 30);
        }
            .routingTable(routingTable)
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 1)
 * GitHub history for details.
            indexMetadata.putInSyncAllocationIds(shard, Collections.singleton(started.allocationId().getId()));
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node3"), equalTo(0));
        logger.info("start one more node, initializing second non-primary");
        assertThat(clusterState.routingTable().index("new_index").shardsWithState(INITIALIZING).size(), equalTo(4));
                    snapshotIndices.add(index.getName());
import org.opensearch.cluster.metadata.Metadata;
        logger.info("start initializing, another 3 should initialize");
import org.opensearch.cluster.routing.IndexRoutingTable;
        AllocationService strategy,
            .build();
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey(), 1)
 * compatible open source license.
        if (additionalNodeAfterPrimaryAssignment) {
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node2"), equalTo(1));
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING.getKey(), 20)
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(0));
        Metadata metaData = Metadata.builder()
                new ShardId(index, shard),
                    final long shardSize = randomNonNegativeLong();
        clusterState = strategy.reroute(clusterState, "reroute");
package org.opensearch.cluster.routing.allocation;
                .build(),
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(8));
            "Exclude node1 and add node4. After this, primary shard on node1 moves to RELOCATING state and only "
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        assertThat(clusterState.routingTable().index("new_index").shardsWithState(UNASSIGNED).size(), equalTo(0));
import static org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING;
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(0))
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(10));
        AllocationService.CommandsResult commandsResult = strategy.reroute(
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node1"), equalTo(1));
    }
        assertThat(clusterState.routingTable().index("new_index").shardsWithState(INITIALIZING).size(), equalTo(5));
        DiscoveryNode node1,
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4"))).build();
        TestSnapshotsInfoService snapshotsInfoService = new TestSnapshotsInfoService();
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(0));
/*
        );
            ShardRouting started = ShardRoutingHelper.moveToStarted(ShardRoutingHelper.initialize(unassigned, node1.getId()));
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(1));
                .build(),
                        new HashSet<>()
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(1));
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(1));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            Index index = cursor.getIndex();
        settings = Settings.builder()
            switch (recoveryType) {
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        logger.info("move started non-primary to new node");
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 0);
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node2"), equalTo(0));
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node4"), equalTo(1));
        logger.info("start initializing, another 3 should initialize");
                            snapshot,
import org.opensearch.snapshots.SnapshotId;
            .metadata(metaData)
 */
        int replicaConcurrentRecoveriesLimit,
        );
    }
        clusterState = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(8));
    ) {
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(2));
        clusterState = strategy.reroute(clusterState, "reroute");
import org.opensearch.cluster.routing.allocation.decider.Decision;
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node3"), equalTo(2));
        TestGatewayAllocator gatewayAllocator = new TestGatewayAllocator();
        assertEquals(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node1"), 1);
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(3));
        logger.info("start initializing replicas, all should be started");
                    break;
    private ClusterState createRecoveryStateAndInitializeAllocations(
        public SnapshotShardSizeInfo snapshotShardSizes() {
        assertEquals(clusterState.getRoutingNodes().getIncomingRecoveries("node2"), 3);
                .put(
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(1));
 * license agreements. See the NOTICE file distributed with
        logger.info("Building initial routing table");
        IndexRoutingTable indexRouting = clusterState.routingTable().index("new_index");
        strategy = createAllocationService(settings, gatewayAllocator);
            .customs(restores)
import org.opensearch.cluster.ClusterState;
 */
    ) {
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node1"), equalTo(1));
        AllocationService strategy = createAllocationService(settings, gatewayAllocator);
                .put("cluster.routing.allocation.node_concurrent_outgoing_recoveries", 1)
        TestSnapshotsInfoService snapshotsInfoService = new TestSnapshotsInfoService();
                .put("cluster.routing.allocation.node_concurrent_recoveries", 3)
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node1"), equalTo(2));
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(1));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node2"), equalTo(1));
            }
        verifyNewIndexReplicaAllocation(primaries, newIndexReplicas, primaries * newIndexReplicas, 0, replicasConcurrentRecoveries, false);
        return clusterState;
        assertThat(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), equalTo(0));
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(5));
        int replicaCount
        logger.info("Building initial routing table");
        while (!clusterState.getRoutingNodes().shardsWithState(INITIALIZING).isEmpty()) {
                        indexMetadata,
            for (ShardRouting shard : routingTable.allShards()) {
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(3));
        final RoutingTable routingTable = routingTableBuilder.build();
        logger.info("Building initial routing table");
                default:
        AllocationService strategy,
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))
 * software distributed under the License is distributed on an
        }
    ) {
 * SPDX-License-Identifier: Apache-2.0
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(4));
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
            .metadata(metadata)
            if (decision.label().equals(ThrottlingAllocationDecider.NAME)) {
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(2));
            true,
public class ThrottlingAllocationTests extends OpenSearchAllocationTestCase {
import org.opensearch.cluster.routing.UnassignedInfo;
        String restoreUUID = UUIDs.randomBase64UUID();
        assertThat(indexRouting.shardsWithState(UNASSIGNED).size(), equalTo(newIndexUnassignedAfterReroute));
        assertEquals(clusterState.getRoutingNodes().getIncomingRecoveries("node3"), 1);
        return clusterState;
                    ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(),
        );
        clusterState = strategy.reroute(clusterState, "reroute");
import java.util.Collections;
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(2));
            .put("cluster.routing.allocation.cluster_concurrent_rebalance", 5)
        Settings settings
                .build(),
    private void addInSyncAllocationIds(
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(9));
                if (shard.primary() && shard.recoverySource().getType() == RecoverySource.Type.SNAPSHOT) {
import org.opensearch.test.gateway.TestGatewayAllocator;
    public void testOutgoingThrottlesAllocationNewIndex() {
        assertThat(clusterState.routingTable().shardsWithState(INITIALIZING).size(), equalTo(0));
        assertEquals(clusterState.getRoutingNodes().getIncomingRecoveries("node1"), 0);
        clusterState = createNewIndexAndStartAllPrimaries(2, 2, strategy, clusterState);
            snapshotsInfoService
        logger.info("start one more node, initializing second non-primary");
        );
        logger.info("start initializing");
            .put("cluster.routing.allocation.node_initial_primaries_recoveries", 5)
            newIndexInitializingAfterReroute,
    private ClusterState createNewIndexAndStartAllPrimaries(
    public void testReplicaAndPrimaryRecoveryThrottling() {
            clusterState = strategy.applyStartedShards(clusterState, clusterState.routingTable().shardsWithState(INITIALIZING));
            false
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(clusterState.routingTable().shardsWithState(UNASSIGNED).size(), equalTo(2));
            IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(cursor);
        assertThat(clusterState.getRoutingNodes().getIncomingRecoveries("node1"), equalTo(1));
        IndexMetadata.Builder indexMetadata,
        assertEquals(clusterState.getRoutingNodes().getIncomingRecoveries("node1"), 0);
        assertTrue(foundThrottledMessage);
    }
 * Licensed to Elasticsearch under one or more contributor
        assertThat(clusterState.getRoutingNodes().getInitialOutgoingRecoveries("node4"), equalTo(0));
        if (snapshotIndices.isEmpty() == false) {
        final Integer inputRecoveryType
            primaries,
        clusterState = strategy.reroute(clusterState, "reroute");
import org.opensearch.snapshots.InternalSnapshotsInfoService;
        Index index,
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        logger.info("Start primary on node4. Now all replicas for that primary start getting accounted for from node4.");
        assertThat(clusterState.getRoutingNodes().getInitialIncomingRecoveries("node2"), equalTo(1));
        logger.info("with one node, do reroute, only 1 should initialize");
    private ClusterState createPrimaryAndWaitForAllocation(
                .stream()
        logger.info("create a new index");
                    break;
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(2));
