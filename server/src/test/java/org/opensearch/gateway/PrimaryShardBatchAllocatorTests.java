            Settings.builder()
        }
        List<ShardRouting> unassignedShards = routingAllocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED);
                node1,
            @Nullable Exception storeException
        assertTrue(initializingShards.get(0).primary());
            .build();
            noAllocationDeciders(),
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertTrue(!unassignedShards.get(0).primary());
import org.opensearch.cluster.ClusterState;
        batchAllocator.allocateUnassignedBatchOnTimeout(shardIds, routingAllocation, true);
    private RoutingAllocation routingAllocationWithOnePrimary(
import org.opensearch.test.IndexSettingsModule;
                routingTableBuilder.addAsRecovery(metadata.index(shardId.getIndex()));
            data.put(node, new TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch(node, shardData));
        }
            IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", nodeSettings);
    class TestBatchAllocator extends PrimaryShardBatchAllocator {
        setUpShards(2);
    public void testInitializeOnlyPrimaryUnassignedShardsIgnoreReplicaShards() {
import java.util.ArrayList;
                new ReplicationCheckpoint(shardId, 20, 101, 1, Codec.getDefault().getName()),
        setUpShards(2);
                    routingTableBuilder.addAsFromCloseToOpen(metadata.index(shardIdFromBatch.getIndex()));
import org.opensearch.common.Nullable;
        AllocationDeciders allocationDeciders = randomAllocationDeciders(Settings.builder().build(), clusterSettings, random());
        List<ShardRouting> ignoredShards = routingAllocation.routingNodes().unassigned().ignored();
        Set<ShardId> shardIds = new HashSet<>();
                new GatewayStartedShard(allocationId, primary, replicationCheckpoint, storeException)
        );
        }
                    .numberOfReplicas(replicas)
        final RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();
/*
    public void testMakeAllocationDecisionDataFetchedMultipleShards() {
        for (ShardId shardId : shardsInBatch) {
            Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir()).build();
import org.opensearch.cluster.routing.RoutingTable;
            shards.add(shard);
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))
        for (ShardId shardIdFromBatch : shardsInBatch) {
        }
import org.opensearch.cluster.ClusterInfo;
        for (int shardNumber = 0; shardNumber < numberOfShards; shardNumber++) {
                true,
    private RoutingAllocation routingAllocationWithMultiplePrimaries(
        batchAllocator.allocateUnassignedBatch(shardsToBatch, allocation);
            List<ShardRouting> inEligibleShards,
package org.opensearch.gateway;
                shardId,
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
            batchAllocator.addShardData(
import java.util.HashSet;
        assertEquals(1, routingAllocation.routingNodes().getInitialPrimariesIncomingRecoveries(node1.getId()));
        AllocationDeciders allocationDeciders = randomAllocationDeciders(Settings.builder().build(), clusterSettings, random());
                    .numberOfShards(numberOfShards)
        shardIds.add(shardRouting.shardId());
                shardId,
                shardId,
                default:
            );
        public TestBatchAllocator addData(
    }
        assertEquals(2, initializingShards.size());
import java.util.List;
        final RoutingAllocation routingAllocation = routingAllocationWithMultiplePrimaries(
            return addData(
                    .numberOfReplicas(1)
import org.opensearch.Version;
            .put(
            0,
        AllocateUnassignedDecision allocateUnassignedDecision = batchAllocator.makeAllocationDecision(shard, allocation, logger);
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                shardId,
            List<ShardRouting> shardsEligibleForFetch,
                shardId,
            .build();
        }
        batchAllocator.addData(node1, "allocId1", true, new ReplicationCheckpoint(shardId, 20, 101, 1, Codec.getDefault().getName()));
            .build();
    }
    }
        setUpShards(1);
    public void testAllocateUnassignedBatchThrottlingAllocationDeciderIsHonoured() {
        final RoutingAllocation allocation = routingAllocationWithOnePrimary(noAllocationDeciders(), CLUSTER_RECOVERED, "allocId1");
            "allocId-1"
            case CLUSTER_RECOVERED:
        }
                    break;
                storeException
import org.opensearch.common.settings.ClusterSettings;
    }
        String... activeAllocationIds
import org.opensearch.common.settings.Settings;
                null
        return new RoutingAllocation(deciders, new RoutingNodes(state, false), state, ClusterInfo.EMPTY, null, System.nanoTime());
        Metadata metadata = Metadata.builder()
    public void testAllocateUnassignedBatchOnTimeoutSkipIgnoringNewPrimaryShards() {
                new ReplicationCheckpoint(shardId, 20, 101, 1, Codec.getDefault().getName()),
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        Iterator<ShardId> shardIterator = shardsInBatch.iterator();
        assertEquals(1, ignoredShards.size());
import java.util.Iterator;
        assertEquals(UnassignedInfo.AllocationStatus.DECIDERS_THROTTLED, ignoredShards.get(0).unassignedInfo().getLastAllocationStatus());
            "allocId-1"
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
}
            String allocationId,
            batchAllocator.addShardData(
        for (ShardId shardId : shardsInBatch) {
        Set<String> nodesWithInitialisingShards = initializingShards.stream().map(ShardRouting::currentNodeId).collect(Collectors.toSet());
                primary,
        }
        List<ShardRouting> ignoredShards = routingAllocation.routingNodes().unassigned().ignored();
        assertEquals(1, ignoredShards.size());
            .routingTable(routingTableBuilder.build())
    @Before
            data = null;
        AllocationDeciders allocationDeciders = randomAllocationDeciders(
        }
            boolean primary,
public class PrimaryShardBatchAllocatorTests extends OpenSearchAllocationTestCase {
                    .settings(settings(Version.CURRENT))
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        private Map<DiscoveryNode, TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch> data;
            );
        for (ShardRouting shardRouting : shards) {
        AllocateUnassignedDecision allocateUnassignedDecision = batchAllocator.makeAllocationDecision(shard, allocation, logger);
        assertEquals(AllocationDecision.YES, allocateUnassignedDecision.getAllocationDecision());
            }
                break;
        AllocationDeciders allocationDeciders = randomAllocationDeciders(Settings.builder().build(), clusterSettings, random());
            );
    private final DiscoveryNode node3 = newNode("node3");
        AllocationDeciders deciders,
        List<ShardRouting> ignoredShards = routingAllocation.routingNodes().unassigned().ignored();
import org.opensearch.cluster.routing.RoutingNodes;
        assertEquals(1, unassignedShards.size());
        }
        final RoutingAllocation allocation = routingAllocationWithOnePrimary(noAllocationDeciders(), CLUSTER_RECOVERED, "allocId1");
            return new AsyncShardFetch.FetchResult<>(data, Collections.<ShardId, Set<String>>emptyMap());
        // Verify the throttling decider was not throttled, recovering shards on node greater than initial concurrent recovery setting
                "allocId-" + shardId.id(),
import java.util.stream.Collectors;
        setUpShards(2);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.IndexMetadata;
    }
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
        ShardRouting shard = allocation.routingTable().getIndicesRouting().get("test").shard(shardId.id()).primaryShard();
            RoutingAllocation allocation
        }
                data = new HashMap<>();
                    routingTableBuilder.addAsRecovery(metadata.index(shardIdFromBatch.getIndex()));
        final RoutingAllocation routingAllocation = routingAllocationWithOnePrimary(allocationDeciders, INDEX_CREATED);
import org.opensearch.cluster.metadata.Metadata;
                    break;
            DiscoveryNode node,
        setUpShards(1);
        for (ShardId shardId : shardsInBatch) {
            ShardRouting shard = allocation.routingTable().getIndicesRouting().get("test").shard(shardId.id()).primaryShard();
                new ReplicationCheckpoint(shardId, 20, 101, 1, Codec.getDefault().getName()),
            switch (reason) {
            if (data == null) {
                case INDEX_CREATED:
            allocation.routingTable().getIndicesRouting().get("test").shard(shardId.id()).primaryShard().recoverySource();
            Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir()).build();
        }
        assertTrue(shardsInBatch.contains(initializingShards.get(1).shardId()));
        allocateAllUnassignedBatch(routingAllocation);
        Set<ShardId> shardIds = new HashSet<>();
                    .settings(settings(Version.CURRENT))
        assertEquals(UnassignedInfo.AllocationStatus.DECIDERS_THROTTLED, ignoredShards.get(0).unassignedInfo().getLastAllocationStatus());
        assertEquals(1, initializingShards.size());
        return new RoutingAllocation(deciders, new RoutingNodes(state, false), state, ClusterInfo.EMPTY, null, System.nanoTime());
            )
                true,
                case CLUSTER_RECOVERED:
            String allocationId,
        final RoutingAllocation routingAllocation = routingAllocationWithMultiplePrimaries(
        ) {
        );
                IndexMetadata.builder(shardId.getIndexName())
                allocationId,
import org.opensearch.cluster.ClusterName;
        List<ShardRouting> initializingShards = routingAllocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);
            String allocationId,
            "allocId-0",
    ) {
                node1,
                routingTableBuilder.addAsNew(metadata.index(shardId.getIndex()));
    private final DiscoveryNode node2 = newNode("node2");
            0,
            DiscoveryNode node,
        final RoutingAllocation routingAllocation = routingAllocationWithOnePrimary(allocationDeciders, CLUSTER_RECOVERED, "allocId-0");
            }
import org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.GatewayStartedShard;
    private void allocateAllUnassignedBatch(final RoutingAllocation allocation) {
        this.batchAllocator = new TestBatchAllocator();
        ) {
        int replicas,
        }
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
 * compatible open source license.
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
    public void testMakeAllocationDecisionForReplicaShard() {
        ShardRouting shardRouting = routingAllocation.routingTable().getIndicesRouting().get("test").shard(shardId.id()).primaryShard();
            Map<ShardId, GatewayStartedShard> shardData = new HashMap<>();
        batchAllocator.allocateUnassignedBatchOnTimeout(new HashSet<>(), routingAllocation, true);
            "allocId-0",
            if (unassignedShardRouting.primary()) {
        batchAllocator.allocateUnassignedBatchOnTimeout(shardIds, routingAllocation, true);
import org.opensearch.index.codec.CodecService;
            2,
import org.opensearch.cluster.node.DiscoveryNodes;
            .metadata(metadata)
            assertEquals(AllocationDecision.YES, allocateUnassignedDecision.getAllocationDecision());
import org.opensearch.common.util.set.Sets;
    }
        assertEquals(1, initializingShards.size());
        List<ShardRouting> shards = new ArrayList<>();
    }
            return addData(
                "allocId-" + shardId.id(),
            ReplicationCheckpoint replicationCheckpoint
                case INDEX_REOPENED:
import org.opensearch.cluster.routing.ShardRouting;
    public void buildTestAllocator() {
            .routingTable(routingTableBuilder.build())
                    .numberOfShards(1)
            "allocId-0",
    private static Set<ShardId> shardsInBatch;
            if (data.get(node) != null) shardData.putAll(data.get(node).getNodeGatewayStartedShardsBatch());
 * The OpenSearch Contributors require contributions made to
    public void testAllocateUnassignedBatchOnTimeoutWithMatchingPrimaryShards() {
        setUpShards(1);
        setUpShards(1);
            2,
        public TestBatchAllocator addData(DiscoveryNode node, String allocationId, boolean primary) {
                true,
import org.junit.Before;
                shardsToBatch.add(unassignedShardRouting);
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertEquals(AllocationDecision.AWAITING_INFO, allocateUnassignedDecision.getAllocationDecision());
                data = new HashMap<>();
    }
        assertEquals(1, routingAllocation.routingNodes().getInitialPrimariesIncomingRecoveries(node1.getId()));
                routingTableBuilder.addAsFromCloseToOpen(metadata.index(shardId.getIndex()));
        AllocationDeciders deciders,
            return this;
        for (ShardRouting shardRouting : replicaShards) {
            boolean primary,
            shardsInBatch.add(shardId);
                node,
        public TestBatchAllocator addShardData(
            return this;
            ShardRouting unassignedShardRouting = iterator.next();
            Map<ShardId, GatewayStartedShard> shardData = Map.of(
                "allocId-" + shardId.id(),
                ReplicationCheckpoint.empty(shardId, new CodecService(null, indexSettings, null, List.of()).codec("default").getName()),
    private final ShardId shardId = new ShardId("test", "_na_", 0);
    public void testInitializePrimaryShards() {
        protected AsyncShardFetch.FetchResult<TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch> fetchData(
        }
import java.util.Set;
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            ShardId shardId,
import static org.opensearch.cluster.routing.UnassignedInfo.Reason.CLUSTER_RECOVERED;
    }
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
                node1,
            DiscoveryNode node,
                IndexMetadata.builder(shardId.getIndexName())
        assertTrue(shardsInBatch.contains(initializingShards.get(0).shardId()));
            2,
import org.opensearch.cluster.routing.UnassignedInfo;
                    .putInSyncAllocationIds(shardIterator.next().id(), Sets.newHashSet(activeAllocationIds[1]))
    }
        int numberOfShards,
                    .putInSyncAllocationIds(shardIterator.next().id(), Sets.newHashSet(activeAllocationIds[0]))
    private TestBatchAllocator batchAllocator;
    }
                    routingTableBuilder.addAsNew(metadata.index(shardIdFromBatch.getIndex()));
                    throw new IllegalArgumentException("can't do " + reason + " for you. teach me");
                node1,
import static org.opensearch.cluster.routing.UnassignedInfo.Reason.INDEX_CREATED;
                ReplicationCheckpoint.empty(shardId, new CodecService(null, indexSettings, null, List.of()).codec("default").getName()),
            allocationDeciders,
            shardData.put(shardId, new GatewayStartedShard(allocationId, primary, replicationCheckpoint, storeException));
        ) {
import org.opensearch.cluster.routing.allocation.AllocationDecision;
        assertEquals(1, nodesWithInitialisingShards.size());
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(0, ignoredShards.size());
            allocationDeciders,
                null
            CLUSTER_RECOVERED,
            data.put(node, new TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch(node, shardData));
                null
                break;
        assertEquals(0, routingAllocation.routingNodes().unassigned().size());
    }
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        );
            AllocateUnassignedDecision allocateUnassignedDecision = batchAllocator.makeAllocationDecision(shardRouting, allocation, logger);
        ShardRouting shard = allocation.routingTable().getIndicesRouting().get("test").shard(shardId.id()).primaryShard();
                allocationId,
    }
        allocateAllUnassignedBatch(routingAllocation);
            }
                null
                true,
import org.opensearch.cluster.node.DiscoveryNode;
    public void testMakeAllocationDecisionDataFetched() {
            ReplicationCheckpoint replicationCheckpoint,
        final RoutingAllocation allocation = routingAllocationWithMultiplePrimaries(
                    .putInSyncAllocationIds(shardId.id(), Sets.newHashSet(activeAllocationIds))
    ) {
            batchAllocator.addShardData(
            .put(
        public TestBatchAllocator addData(
import org.opensearch.env.Environment;
        List<ShardRouting> ignoredShards = routingAllocation.routingNodes().unassigned().ignored();
                primary,
    private final DiscoveryNode node1 = newNode("node1");
            assertFalse(allocateUnassignedDecision.isDecisionTaken());
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING.getKey(), 1)
        String... activeAllocationIds
    public void testAllocateUnassignedBatchOnTimeoutWithNoMatchingPrimaryShards() {
                "allocId-0",
            if (data == null) {
        final RoutingAllocation routingAllocation = routingAllocationWithOnePrimary(allocationDeciders, CLUSTER_RECOVERED, "allocId-0");
            AllocateUnassignedDecision allocateUnassignedDecision = batchAllocator.makeAllocationDecision(shardRouting, allocation, logger);
            0,
        );
        }
                null
import org.opensearch.index.IndexSettings;
    public void testMakeAllocationDecisionDataFetching() {
    public static void setUpShards(int numberOfShards) {
        Metadata metadata = Metadata.builder()
        assertEquals(0, ignoredShards.size());
import java.util.HashMap;
            CLUSTER_RECOVERED,
        switch (reason) {
        allocateAllUnassignedBatch(routingAllocation);
            );
            case INDEX_CREATED:
                throw new IllegalArgumentException("can't do " + reason + " for you. teach me");
import org.apache.lucene.codecs.Codec;
        UnassignedInfo.Reason reason,
        }
        List<ShardRouting> initializingShards = routingAllocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);
                node,
            default:
    }
        assertEquals(2, routingAllocation.routingNodes().getInitialPrimariesIncomingRecoveries(node1.getId()));
        List<ShardRouting> initializingShards = routingAllocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);
        List<ShardRouting> replicaShards = allocation.routingTable().getIndicesRouting().get("test").shard(shardId.id()).replicaShards();
                    break;
            .build();
            ShardId shardId = new ShardId("test", "_na_", shardNumber);
            );
        }
import org.opensearch.core.index.shard.ShardId;
            boolean primary,
        public TestBatchAllocator clear() {
                .build(),
        shardIds.add(shardRouting.shardId());
            IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", nodeSettings);
 */
        List<ShardRouting> shardsToBatch = new ArrayList<>();
            random()
        }
            @Nullable Exception storeException
            return addData(node, allocationId, primary, replicationCheckpoint, null);
        @Override
            clusterSettings,
            )
            case INDEX_REOPENED:
        final RoutingAllocation routingAllocation = routingAllocationWithOnePrimary(allocationDeciders, CLUSTER_RECOVERED, "allocId-0");
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertEquals(Collections.singleton(node1.getId()), nodesWithInitialisingShards);
        shardsInBatch = new HashSet<>();
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        AllocationDeciders allocationDeciders = randomAllocationDeciders(Settings.builder().build(), clusterSettings, random());
            return this;
    }
import java.util.Collections;
        assertTrue(shardsInBatch.contains(initializingShards.get(0).shardId()));
        while (iterator.hasNext()) {
        ShardRouting shardRouting = routingAllocation.routingTable().getIndicesRouting().get("test").shard(shardId.id()).primaryShard();
            );
import org.opensearch.cluster.routing.ShardRoutingState;
        AllocationDeciders allocationDeciders = randomAllocationDeciders(Settings.builder().build(), clusterSettings, random());
        for (ShardId shardId : shardsInBatch) {
        final RoutingAllocation allocation = routingAllocationWithOnePrimary(noAllocationDeciders(), CLUSTER_RECOVERED, "allocId1");
            ReplicationCheckpoint replicationCheckpoint,
    }
 *
            CLUSTER_RECOVERED,
            batchAllocator.addShardData(
                new ReplicationCheckpoint(shardId, 20, 101, 1, Codec.getDefault().getName()),
        ) {
import java.util.Map;
        public TestBatchAllocator addData(DiscoveryNode node, String allocationId, boolean primary, @Nullable Exception storeException) {
            "allocId-1"
            );
        UnassignedInfo.Reason reason,
                break;
            .metadata(metadata)
            }
