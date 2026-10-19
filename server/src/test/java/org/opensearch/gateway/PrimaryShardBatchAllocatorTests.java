import org.opensearch.env.Environment;
        UnassignedInfo.Reason reason,
                node1,
    private RoutingAllocation routingAllocationWithOnePrimary(  
                    routingTableBuilder.addAsNew(metadata.index(shardIdFromBatch.getIndex()));  
            ReplicationCheckpoint replicationCheckpoint  
    @Before  
                    routingTableBuilder.addAsFromCloseToOpen(metadata.index(shardIdFromBatch.getIndex()));  
                break;
        assertEquals(1, ignoredShards.size());  
                "allocId-0",
    private void allocateAllUnassignedBatch(final RoutingAllocation allocation) {
        assertEquals(1, unassignedShards.size());  
        UnassignedInfo.Reason reason,  
    }  
        public TestBatchAllocator addData(
                shardId,  
            ShardId shardId = new ShardId("test", "_na_", shardNumber);
        for (ShardRouting shardRouting : shards) {
        setUpShards(2);
                new ReplicationCheckpoint(shardId, 20, 101, 1, Codec.getDefault().getName()),
import java.util.Collections;
    }  
import org.opensearch.test.IndexSettingsModule;  
        }
            DiscoveryNode node,  
    public void buildTestAllocator() {
        for (ShardRouting shardRouting : replicaShards) {
        }  
                    .settings(settings(Version.CURRENT))  
        }  
                    break;
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            switch (reason) {
        assertEquals(AllocationDecision.AWAITING_INFO, allocateUnassignedDecision.getAllocationDecision());  
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;  
                    .numberOfReplicas(replicas)
            List<ShardRouting> inEligibleShards,
        shardIds.add(shardRouting.shardId());
                new GatewayStartedShard(allocationId, primary, replicationCheckpoint, storeException)
        List<ShardRouting> ignoredShards = routingAllocation.routingNodes().unassigned().ignored();
import org.opensearch.cluster.routing.RoutingTable;
                node1,
        }  
            RoutingAllocation allocation  
                throw new IllegalArgumentException("can't do " + reason + " for you. teach me");  
                ReplicationCheckpoint.empty(shardId, new CodecService(null, indexSettings, null, List.of()).codec("default").getName()),  
                shardsToBatch.add(unassignedShardRouting);
                primary,
        AllocationDeciders deciders,
            }  
            Settings.builder()
        }
    private final DiscoveryNode node2 = newNode("node2");  
            boolean primary,
import static org.opensearch.cluster.routing.UnassignedInfo.Reason.CLUSTER_RECOVERED;
                    routingTableBuilder.addAsRecovery(metadata.index(shardIdFromBatch.getIndex()));  
        setUpShards(1);  
                    .settings(settings(Version.CURRENT))
        ShardRouting shardRouting = routingAllocation.routingTable().getIndicesRouting().get("test").shard(shardId.id()).primaryShard();
            .metadata(metadata)  
        AllocationDeciders allocationDeciders = randomAllocationDeciders(Settings.builder().build(), clusterSettings, random());
            }  
            clusterSettings,
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
import org.opensearch.cluster.ClusterName;  
        for (ShardId shardIdFromBatch : shardsInBatch) {  
            .routingTable(routingTableBuilder.build())
        Set<ShardId> shardIds = new HashSet<>();
        assertTrue(shardsInBatch.contains(initializingShards.get(0).shardId()));  
        final RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();  
}
                break;
        assertEquals(2, initializingShards.size());
    public void testAllocateUnassignedBatchOnTimeoutWithMatchingPrimaryShards() {  
            return this;
        }
        assertEquals(0, routingAllocation.routingNodes().unassigned().size());  
            2,
                data = new HashMap<>();
    public void testMakeAllocationDecisionDataFetching() {
            @Nullable Exception storeException
            data = null;
        this.batchAllocator = new TestBatchAllocator();
            "allocId-0",
        assertEquals(1, initializingShards.size());
/*  
    }
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))
        AllocationDeciders deciders,
        final RoutingAllocation routingAllocation = routingAllocationWithOnePrimary(allocationDeciders, INDEX_CREATED);
                primary,
        );  
                null  
            case INDEX_CREATED:
import org.opensearch.cluster.routing.RoutingNodes;
        }  
        ShardRouting shard = allocation.routingTable().getIndicesRouting().get("test").shard(shardId.id()).primaryShard();
                allocationId,
            0,  
import org.opensearch.Version;
            CLUSTER_RECOVERED,
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        Iterator<ShardId> shardIterator = shardsInBatch.iterator();
            DiscoveryNode node,  
            @Nullable Exception storeException
import org.opensearch.cluster.routing.allocation.AllocationDecision;
        List<ShardRouting> ignoredShards = routingAllocation.routingNodes().unassigned().ignored();
            return addData(
        allocateAllUnassignedBatch(routingAllocation);
        assertEquals(1, nodesWithInitialisingShards.size());
                IndexMetadata.builder(shardId.getIndexName())
            return this;
                IndexMetadata.builder(shardId.getIndexName())
            IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", nodeSettings);
            );
        }
        List<ShardRouting> initializingShards = routingAllocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);
        List<ShardRouting> initializingShards = routingAllocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);
        }  
                null  
            random()
import org.opensearch.common.util.set.Sets;
        for (ShardId shardId : shardsInBatch) {
            "allocId-1"  
            IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", nodeSettings);
    }
        allocateAllUnassignedBatch(routingAllocation);
            return addData(
                node,  
            ShardRouting unassignedShardRouting = iterator.next();  
            List<ShardRouting> shardsEligibleForFetch,
                case CLUSTER_RECOVERED:
            );
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        batchAllocator.allocateUnassignedBatch(shardsToBatch, allocation);
        AllocationDeciders allocationDeciders = randomAllocationDeciders(Settings.builder().build(), clusterSettings, random());
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        @Override
            Map<ShardId, GatewayStartedShard> shardData = Map.of(  
        List<ShardRouting> initializingShards = routingAllocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);  
    private TestBatchAllocator batchAllocator;
        }  
    }
public class PrimaryShardBatchAllocatorTests extends OpenSearchAllocationTestCase {
        AllocationDeciders allocationDeciders = randomAllocationDeciders(  
                new ReplicationCheckpoint(shardId, 20, 101, 1, Codec.getDefault().getName()),  
        public TestBatchAllocator addData(
        Metadata metadata = Metadata.builder()  
import org.opensearch.cluster.metadata.IndexMetadata;  
            batchAllocator.addShardData(  
            allocation.routingTable().getIndicesRouting().get("test").shard(shardId.id()).primaryShard().recoverySource();
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
import org.opensearch.cluster.ClusterState;
            "allocId-0",
        List<ShardRouting> ignoredShards = routingAllocation.routingNodes().unassigned().ignored();
                    break;
        List<ShardRouting> replicaShards = allocation.routingTable().getIndicesRouting().get("test").shard(shardId.id()).replicaShards();  
        final RoutingAllocation routingAllocation = routingAllocationWithOnePrimary(allocationDeciders, CLUSTER_RECOVERED, "allocId-0");
        return new RoutingAllocation(deciders, new RoutingNodes(state, false), state, ClusterInfo.EMPTY, null, System.nanoTime());
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;  
                    .numberOfReplicas(1)
        assertEquals(1, routingAllocation.routingNodes().getInitialPrimariesIncomingRecoveries(node1.getId()));
            .metadata(metadata)
            Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir()).build();  
    private static Set<ShardId> shardsInBatch;
            String allocationId,
            shardData.put(shardId, new GatewayStartedShard(allocationId, primary, replicationCheckpoint, storeException));
        final RoutingAllocation allocation = routingAllocationWithOnePrimary(noAllocationDeciders(), CLUSTER_RECOVERED, "allocId1");  
        Set<ShardId> shardIds = new HashSet<>();
                default:
        final RoutingAllocation routingAllocation = routingAllocationWithOnePrimary(allocationDeciders, CLUSTER_RECOVERED, "allocId-0");  
        setUpShards(1);  
    public void testInitializeOnlyPrimaryUnassignedShardsIgnoreReplicaShards() {
        assertEquals(0, ignoredShards.size());  
 * The OpenSearch Contributors require contributions made to  
        switch (reason) {  
            .build();  
        }
        assertEquals(UnassignedInfo.AllocationStatus.DECIDERS_THROTTLED, ignoredShards.get(0).unassignedInfo().getLastAllocationStatus());
        assertTrue(shardsInBatch.contains(initializingShards.get(1).shardId()));
        allocateAllUnassignedBatch(routingAllocation);
        }
import org.opensearch.common.Nullable;
import org.junit.Before;
            ReplicationCheckpoint replicationCheckpoint,
        assertEquals(Collections.singleton(node1.getId()), nodesWithInitialisingShards);  
    }
                node1,
import static org.opensearch.cluster.routing.UnassignedInfo.Reason.INDEX_CREATED;
        for (ShardId shardId : shardsInBatch) {  
            case INDEX_REOPENED:
        public TestBatchAllocator clear() {  
            data.put(node, new TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch(node, shardData));
    public void testAllocateUnassignedBatchOnTimeoutWithNoMatchingPrimaryShards() {
import org.opensearch.core.index.shard.ShardId;  
                routingTableBuilder.addAsFromCloseToOpen(metadata.index(shardId.getIndex()));  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                null
        for (int shardNumber = 0; shardNumber < numberOfShards; shardNumber++) {  
                "allocId-" + shardId.id(),  
        setUpShards(1);
            default:
        }
            String allocationId,
        shardIds.add(shardRouting.shardId());
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        Metadata metadata = Metadata.builder()
            2,
import java.util.Set;
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING.getKey(), 1)
        String... activeAllocationIds  
import org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.GatewayStartedShard;
        List<ShardRouting> shards = new ArrayList<>();
        return new RoutingAllocation(deciders, new RoutingNodes(state, false), state, ClusterInfo.EMPTY, null, System.nanoTime());
            );
    public void testAllocateUnassignedBatchThrottlingAllocationDeciderIsHonoured() {
        ) {
        List<ShardRouting> ignoredShards = routingAllocation.routingNodes().unassigned().ignored();
            return addData(node, allocationId, primary, replicationCheckpoint, null);
    }
            if (unassignedShardRouting.primary()) {
                    .putInSyncAllocationIds(shardIterator.next().id(), Sets.newHashSet(activeAllocationIds[0]))  
                    .numberOfShards(numberOfShards)
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
    }
    }
            "allocId-1"
            boolean primary,
            assertEquals(AllocationDecision.YES, allocateUnassignedDecision.getAllocationDecision());  
            }
            assertFalse(allocateUnassignedDecision.isDecisionTaken());  
                "allocId-" + shardId.id(),
        public TestBatchAllocator addData(DiscoveryNode node, String allocationId, boolean primary) {
            );
import java.util.HashMap;
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))  
    public void testMakeAllocationDecisionDataFetchedMultipleShards() {
        assertEquals(1, initializingShards.size());  
        AllocateUnassignedDecision allocateUnassignedDecision = batchAllocator.makeAllocationDecision(shard, allocation, logger);
                break;
                storeException
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        assertEquals(UnassignedInfo.AllocationStatus.DECIDERS_THROTTLED, ignoredShards.get(0).unassignedInfo().getLastAllocationStatus());  
        for (ShardId shardId : shardsInBatch) {
                    .numberOfShards(1)  
        public TestBatchAllocator addShardData(
                case INDEX_CREATED:
                shardId,
            CLUSTER_RECOVERED,
    }
                shardId,  
    private final ShardId shardId = new ShardId("test", "_na_", 0);  
            return this;
        assertTrue(initializingShards.get(0).primary());  
    ) {
import org.opensearch.cluster.node.DiscoveryNode;
        Set<String> nodesWithInitialisingShards = initializingShards.stream().map(ShardRouting::currentNodeId).collect(Collectors.toSet());
 */  
        List<ShardRouting> shardsToBatch = new ArrayList<>();
        assertTrue(shardsInBatch.contains(initializingShards.get(0).shardId()));
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    private final DiscoveryNode node3 = newNode("node3");
        batchAllocator.allocateUnassignedBatchOnTimeout(new HashSet<>(), routingAllocation, true);  
import org.opensearch.index.IndexSettings;  
        final RoutingAllocation routingAllocation = routingAllocationWithMultiplePrimaries(
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        while (iterator.hasNext()) {
            data.put(node, new TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch(node, shardData));
    }
                routingTableBuilder.addAsRecovery(metadata.index(shardId.getIndex()));  
                data = new HashMap<>();
            0,  
                shardId,  
        protected AsyncShardFetch.FetchResult<TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch> fetchData(  
            .put(  
import org.apache.lucene.codecs.Codec;  
        ) {
                allocationId,
    }
        assertEquals(1, ignoredShards.size());
        }  
    public void testMakeAllocationDecisionForReplicaShard() {  
import java.util.stream.Collectors;
    class TestBatchAllocator extends PrimaryShardBatchAllocator {
        );  
            noAllocationDeciders(),
        assertTrue(!unassignedShards.get(0).primary());
                null
            "allocId-0",
                true,
        );  
            allocationDeciders,  
            ShardId shardId,
            batchAllocator.addShardData(  
            allocationDeciders,  
            boolean primary,  
            Map<ShardId, GatewayStartedShard> shardData = new HashMap<>();
        final RoutingAllocation allocation = routingAllocationWithMultiplePrimaries(  
                node,  
        setUpShards(1);
            return new AsyncShardFetch.FetchResult<>(data, Collections.<ShardId, Set<String>>emptyMap());
        private Map<DiscoveryNode, TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch> data;
        batchAllocator.allocateUnassignedBatchOnTimeout(shardIds, routingAllocation, true);  
import java.util.List;
        assertEquals(AllocationDecision.YES, allocateUnassignedDecision.getAllocationDecision());
            ReplicationCheckpoint replicationCheckpoint,  
            shards.add(shard);  
import org.opensearch.cluster.routing.ShardRouting;  
        }  
                shardId,
            AllocateUnassignedDecision allocateUnassignedDecision = batchAllocator.makeAllocationDecision(shardRouting, allocation, logger);
        assertEquals(1, routingAllocation.routingNodes().getInitialPrimariesIncomingRecoveries(node1.getId()));
            0,
    public void testMakeAllocationDecisionDataFetched() {
        }  
        assertEquals(2, routingAllocation.routingNodes().getInitialPrimariesIncomingRecoveries(node1.getId()));
            .put(
            batchAllocator.addShardData(  
import org.opensearch.cluster.ClusterInfo;
                "allocId-" + shardId.id(),
            if (data.get(node) != null) shardData.putAll(data.get(node).getNodeGatewayStartedShardsBatch());  
    public void testAllocateUnassignedBatchOnTimeoutSkipIgnoringNewPrimaryShards() {  
            if (data == null) {  
    public void testInitializePrimaryShards() {
            .routingTable(routingTableBuilder.build())
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            if (data == null) {
    private final DiscoveryNode node1 = newNode("node1");
    ) {
            ShardRouting shard = allocation.routingTable().getIndicesRouting().get("test").shard(shardId.id()).primaryShard();
    }  
                    break;
                true,
            shardsInBatch.add(shardId);
            );
        AllocationDeciders allocationDeciders = randomAllocationDeciders(Settings.builder().build(), clusterSettings, random());  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.routing.UnassignedInfo;
        final RoutingAllocation routingAllocation = routingAllocationWithOnePrimary(allocationDeciders, CLUSTER_RECOVERED, "allocId-0");
 *
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
        ShardRouting shard = allocation.routingTable().getIndicesRouting().get("test").shard(shardId.id()).primaryShard();
        ) {  
        final RoutingAllocation allocation = routingAllocationWithOnePrimary(noAllocationDeciders(), CLUSTER_RECOVERED, "allocId1");
    }  
        ) {
            .build();
        batchAllocator.addData(node1, "allocId1", true, new ReplicationCheckpoint(shardId, 20, 101, 1, Codec.getDefault().getName()));
            CLUSTER_RECOVERED,
import org.opensearch.common.settings.Settings;
        int numberOfShards,
            .build();
            .build();  
    private RoutingAllocation routingAllocationWithMultiplePrimaries(
            batchAllocator.addShardData(
        final RoutingAllocation allocation = routingAllocationWithOnePrimary(noAllocationDeciders(), CLUSTER_RECOVERED, "allocId1");
                true,
        setUpShards(2);
import java.util.Map;  
        batchAllocator.allocateUnassignedBatchOnTimeout(shardIds, routingAllocation, true);  
        );
            );  
import java.util.HashSet;  
import org.opensearch.index.codec.CodecService;
        ShardRouting shardRouting = routingAllocation.routingTable().getIndicesRouting().get("test").shard(shardId.id()).primaryShard();
                new ReplicationCheckpoint(shardId, 20, 101, 1, Codec.getDefault().getName()),
                routingTableBuilder.addAsNew(metadata.index(shardId.getIndex()));  
    }
        String... activeAllocationIds  
import org.opensearch.cluster.routing.ShardRoutingState;
            DiscoveryNode node,  
            Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir()).build();  
                    .putInSyncAllocationIds(shardIterator.next().id(), Sets.newHashSet(activeAllocationIds[1]))
                .build(),  
import java.util.ArrayList;  
        assertEquals(0, ignoredShards.size());  
            case CLUSTER_RECOVERED:
        int replicas,
import org.opensearch.common.settings.ClusterSettings;  
            AllocateUnassignedDecision allocateUnassignedDecision = batchAllocator.makeAllocationDecision(shardRouting, allocation, logger);
            2,  
                new ReplicationCheckpoint(shardId, 20, 101, 1, Codec.getDefault().getName()),
                node1,
import org.opensearch.cluster.metadata.Metadata;
package org.opensearch.gateway;
        List<ShardRouting> unassignedShards = routingAllocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED);
            String allocationId,
        setUpShards(2);
import org.opensearch.cluster.node.DiscoveryNodes;  
                    .putInSyncAllocationIds(shardId.id(), Sets.newHashSet(activeAllocationIds))
        }
        AllocateUnassignedDecision allocateUnassignedDecision = batchAllocator.makeAllocationDecision(shard, allocation, logger);  
                true,
        final RoutingAllocation routingAllocation = routingAllocationWithMultiplePrimaries(
        AllocationDeciders allocationDeciders = randomAllocationDeciders(Settings.builder().build(), clusterSettings, random());
            }
            )
        public TestBatchAllocator addData(DiscoveryNode node, String allocationId, boolean primary, @Nullable Exception storeException) {
 * compatible open source license.
            )  
        // Verify the throttling decider was not throttled, recovering shards on node greater than initial concurrent recovery setting  
            );
            "allocId-1"
        shardsInBatch = new HashSet<>();
                case INDEX_REOPENED:
    public static void setUpShards(int numberOfShards) {
                ReplicationCheckpoint.empty(shardId, new CodecService(null, indexSettings, null, List.of()).codec("default").getName()),  
                null  
    }
        for (ShardId shardId : shardsInBatch) {
                    throw new IllegalArgumentException("can't do " + reason + " for you. teach me");  
        AllocationDeciders allocationDeciders = randomAllocationDeciders(Settings.builder().build(), clusterSettings, random());  
import java.util.Iterator;
