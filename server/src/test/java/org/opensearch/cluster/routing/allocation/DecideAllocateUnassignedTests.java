        // one node initially so that all primary shards get allocated to the same node.
import org.opensearch.cluster.node.DiscoveryNode;
        DiscoveryNode discoveryNode = newNode("node_" + nodeId);
                .build()
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
                .add(IndexRoutingTable.builder(indexMetadata.getIndex()).addIndexShard(indexShardRoutingTable))
        Settings build = Settings.builder().put(IGNORE_THROTTLE_FOR_REMOTE_RESTORE.getKey(), false).build();
        IndexMetadata.Builder indexMetadataBuilder = new IndexMetadata.Builder(indexMetadata);
            )
    }
        // Allocation Deciders to throttle on `node_1`
        // When we add 1 more 1 index with 1 started primary shard and 1 more node , if the new node throttles the recovery
                return Decision.YES;
 * this file be licensed under the Apache-2.0 license or a
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(clusterState.nodes());
        clusterState = addNodesToClusterState(clusterState, 1);
        // Create a cluster state with 1 indices, each with 1 started primary shard, and only
                if (throttleNodes.contains(node.nodeId())) {
import org.opensearch.cluster.routing.RoutingTable;
        UnassignedInfo unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.EXISTING_INDEX_RESTORED, null);
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
        // shard should get assigned on the older node if IgnoreThrottle is set to true
import org.opensearch.cluster.metadata.IndexMetadata;
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(build);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
import java.util.HashSet;
import org.opensearch.cluster.routing.ShardRoutingState;
        assertTrue(routingAllocation.routingNodes().hasUnassignedPrimaries());
    }
        clusterState = addNodesToClusterState(clusterState, 1);
        assertFalse(routingAllocation.routingNodes().hasUnassignedPrimaries());
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        // shard should remain unassigned if IgnoreThrottle is set to false
        List<AllocationDecider> allocationDeciders = getAllocationDecidersThrottleOnNode1();
        assertEquals(routingAllocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).getIndexName(), "idx2");
        clusterState = addRestoringIndexToClusterState(clusterState, "idx2");
import java.util.stream.Collectors;
        Settings build = Settings.builder().put(IGNORE_THROTTLE_FOR_REMOTE_RESTORE.getKey(), true).build();
        //
        final ShardId shardId = new ShardId(index, "_na_", 0);
        allocator.allocate(routingAllocation);
        ClusterState clusterState = ClusterStateCreationUtils.state(1, indices, 1);
    private ClusterState addRestoringIndexToClusterState(ClusterState clusterState, String index) {
            }
import org.opensearch.common.settings.Settings;
        final int primaryTerm = 1 + randomInt(200);
import java.util.List;
        // allocate and get the node that is now relocating
import org.opensearch.cluster.node.DiscoveryNodes;
        throttleNodes.add("node_1");
            @Override
        final IndexShardRoutingTable indexShardRoutingTable = indexShardRoutingBuilder.build();
                    .put(SETTING_NUMBER_OF_SHARDS, 1)
        clusterState = addRestoringIndexToClusterState(clusterState, "idx2");
        indexShardRoutingBuilder.addShard(
            .settings(
import org.opensearch.cluster.routing.UnassignedInfo;
}
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
 * SPDX-License-Identifier: Apache-2.0
            public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
        ClusterState.Builder state = ClusterState.builder(clusterState);
        state.routingTable(
 */
        assertEquals(routingAllocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(), "node_0");
        final String[] indices = { "idx1" };
        return ClusterState.builder(clusterState).nodes(nodesBuilder).build();
                .stream()
import org.opensearch.cluster.routing.ShardRouting;
        assertEquals(routingAllocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), 0);
        List<AllocationDecider> allocationDeciders = Arrays.asList(allocationDecider);
        RoutingAllocation routingAllocation = newRoutingAllocation(new AllocationDeciders(allocationDeciders), clusterState);
import org.opensearch.cluster.ClusterState;
/*
import org.opensearch.cluster.routing.IndexRoutingTable;
            .build();
import org.opensearch.cluster.routing.AllocationId;
import org.opensearch.cluster.OpenSearchAllocationTestCase;
                }
            RoutingTable.builder(clusterState.routingTable())
import org.opensearch.Version;
    public void testAllocateUnassignedRemoteRestore() {
        IndexMetadata indexMetadata = IndexMetadata.builder(index)
import org.opensearch.cluster.metadata.Metadata;
        RoutingAllocation routingAllocation = newRoutingAllocation(new AllocationDeciders(allocationDeciders), clusterState);
import java.util.Set;
import java.util.Arrays;
    private static List<AllocationDecider> getAllocationDecidersThrottleOnNode1() {
    public void testAllocateUnassignedRemoteRestore_IgnoreThrottle() {
import org.opensearch.cluster.routing.RoutingNode;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        // Create a cluster state with 1 indices, each with 1 started primary shard, and only
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
    }
import org.opensearch.cluster.routing.TestShardRouting;
        // allocate and get the node that is now relocating
import static org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator.IGNORE_THROTTLE_FOR_REMOTE_RESTORE;
 *
import org.opensearch.cluster.routing.allocation.decider.Decision;
            0,
            indexShardRoutingTable.activeShards()
        ClusterState clusterState = ClusterStateCreationUtils.state(1, indices, 1);
                .map(AllocationId::getId)
        // When we add 1 more 1 index with 1 started primary shard and 1 more node , if the new node throttles the recovery
        };
public class DecideAllocateUnassignedTests extends OpenSearchAllocationTestCase {
            .primaryTerm(0, primaryTerm)
        final String[] indices = { "idx1" };
                .map(ShardRouting::allocationId)
 * The OpenSearch Contributors require contributions made to
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
    }
    private ClusterState addNodesToClusterState(ClusterState clusterState, int nodeId) {
            TestShardRouting.newShardRoutingRemoteRestore(index, shardId, null, null, true, ShardRoutingState.UNASSIGNED, unassignedInfo)
        nodesBuilder.add(discoveryNode);
        return allocationDeciders;
        );
        indexMetadataBuilder.putInSyncAllocationIds(
package org.opensearch.cluster.routing.allocation;
 * compatible open source license.
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
                .collect(Collectors.toSet())
        final Set<String> throttleNodes = new HashSet<>();
                    return Decision.THROTTLE;
        return state.build();
        List<AllocationDecider> allocationDeciders = getAllocationDecidersThrottleOnNode1();
        state.metadata(Metadata.builder(clusterState.metadata()).put(indexMetadataBuilder.build(), false).generateClusterUuidIfNeeded());
        );
                    .put(SETTING_NUMBER_OF_REPLICAS, 0)
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
        //
        // one node initially so that all primary shards get allocated to the same node.
    }
                Settings.builder()
        allocator.allocate(routingAllocation);
        );
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(build);
        AllocationDecider allocationDecider = new AllocationDecider() {
