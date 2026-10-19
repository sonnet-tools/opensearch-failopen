                .add(IndexRoutingTable.builder(indexMetadata.getIndex()).addIndexShard(indexShardRoutingTable))  
        IndexMetadata.Builder indexMetadataBuilder = new IndexMetadata.Builder(indexMetadata);
        state.metadata(Metadata.builder(clusterState.metadata()).put(indexMetadataBuilder.build(), false).generateClusterUuidIfNeeded());  
                .build()
            0,
    private ClusterState addRestoringIndexToClusterState(ClusterState clusterState, String index) {
        // allocate and get the node that is now relocating
        ClusterState.Builder state = ClusterState.builder(clusterState);
        final String[] indices = { "idx1" };  
                    .put(SETTING_NUMBER_OF_REPLICAS, 0)
        assertEquals(routingAllocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), 0);  
import java.util.Set;
 *
import org.opensearch.cluster.routing.allocation.decider.Decision;  
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
}  
        // one node initially so that all primary shards get allocated to the same node.
                    .put(SETTING_NUMBER_OF_SHARDS, 1)  
    public void testAllocateUnassignedRemoteRestore() {
        Settings build = Settings.builder().put(IGNORE_THROTTLE_FOR_REMOTE_RESTORE.getKey(), false).build();  
                if (throttleNodes.contains(node.nodeId())) {
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(build);
import org.opensearch.cluster.routing.UnassignedInfo;
 */  
        Settings build = Settings.builder().put(IGNORE_THROTTLE_FOR_REMOTE_RESTORE.getKey(), true).build();  
 * this file be licensed under the Apache-2.0 license or a
    }
    }
        assertFalse(routingAllocation.routingNodes().hasUnassignedPrimaries());
        DiscoveryNode discoveryNode = newNode("node_" + nodeId);
import java.util.stream.Collectors;
        // one node initially so that all primary shards get allocated to the same node.
        List<AllocationDecider> allocationDeciders = Arrays.asList(allocationDecider);
import org.opensearch.cluster.routing.IndexShardRoutingTable;
import org.opensearch.cluster.node.DiscoveryNode;
        return allocationDeciders;  
import org.opensearch.cluster.routing.RoutingTable;
    private static List<AllocationDecider> getAllocationDecidersThrottleOnNode1() {
import org.opensearch.core.index.shard.ShardId;
        ClusterState clusterState = ClusterStateCreationUtils.state(1, indices, 1);  
        RoutingAllocation routingAllocation = newRoutingAllocation(new AllocationDeciders(allocationDeciders), clusterState);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
        // allocate and get the node that is now relocating
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;  
                .map(AllocationId::getId)
                return Decision.YES;
            )  
        final int primaryTerm = 1 + randomInt(200);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        clusterState = addNodesToClusterState(clusterState, 1);
        // shard should remain unassigned if IgnoreThrottle is set to false
        RoutingAllocation routingAllocation = newRoutingAllocation(new AllocationDeciders(allocationDeciders), clusterState);
import org.opensearch.cluster.metadata.IndexMetadata;
    }
import org.opensearch.cluster.routing.IndexRoutingTable;
    public void testAllocateUnassignedRemoteRestore_IgnoreThrottle() {
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
        UnassignedInfo unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.EXISTING_INDEX_RESTORED, null);
        final ShardId shardId = new ShardId(index, "_na_", 0);  
            .primaryTerm(0, primaryTerm)
        final Set<String> throttleNodes = new HashSet<>();  
/*  
 * SPDX-License-Identifier: Apache-2.0
        indexMetadataBuilder.putInSyncAllocationIds(  
        clusterState = addRestoringIndexToClusterState(clusterState, "idx2");
        state.routingTable(
        );
        // Create a cluster state with 1 indices, each with 1 started primary shard, and only
                    return Decision.THROTTLE;  
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;  
        allocator.allocate(routingAllocation);
                .collect(Collectors.toSet())  
        // When we add 1 more 1 index with 1 started primary shard and 1 more node , if the new node throttles the recovery
import org.opensearch.cluster.OpenSearchAllocationTestCase;
                .map(ShardRouting::allocationId)
            public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
            @Override  
        assertEquals(routingAllocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).getIndexName(), "idx2");
public class DecideAllocateUnassignedTests extends OpenSearchAllocationTestCase {
    private ClusterState addNodesToClusterState(ClusterState clusterState, int nodeId) {  
import org.opensearch.cluster.ClusterState;  
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.cluster.routing.ShardRouting;
        // When we add 1 more 1 index with 1 started primary shard and 1 more node , if the new node throttles the recovery
        );
        ClusterState clusterState = ClusterStateCreationUtils.state(1, indices, 1);  
import static org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator.IGNORE_THROTTLE_FOR_REMOTE_RESTORE;
        // Create a cluster state with 1 indices, each with 1 started primary shard, and only
package org.opensearch.cluster.routing.allocation;
        throttleNodes.add("node_1");
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(clusterState.nodes());
import org.opensearch.common.settings.Settings;
import java.util.List;  
import java.util.HashSet;
import org.opensearch.Version;
            indexShardRoutingTable.activeShards()
        //  
 * compatible open source license.
        return ClusterState.builder(clusterState).nodes(nodesBuilder).build();
                Settings.builder()
        clusterState = addRestoringIndexToClusterState(clusterState, "idx2");
        allocator.allocate(routingAllocation);
        //  
        );
import org.opensearch.cluster.routing.ShardRoutingState;  
        assertTrue(routingAllocation.routingNodes().hasUnassignedPrimaries());
import org.opensearch.cluster.routing.AllocationId;  
import org.opensearch.cluster.routing.TestShardRouting;
        final IndexShardRoutingTable indexShardRoutingTable = indexShardRoutingBuilder.build();  
            .build();
            }  
        final String[] indices = { "idx1" };  
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
            .settings(  
        IndexMetadata indexMetadata = IndexMetadata.builder(index)
        AllocationDecider allocationDecider = new AllocationDecider() {
import org.opensearch.cluster.metadata.Metadata;  
    }
        List<AllocationDecider> allocationDeciders = getAllocationDecidersThrottleOnNode1();  
import org.opensearch.cluster.routing.RoutingNode;  
    }  
            TestShardRouting.newShardRoutingRemoteRestore(index, shardId, null, null, true, ShardRoutingState.UNASSIGNED, unassignedInfo)
        assertEquals(routingAllocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(), "node_0");  
        return state.build();  
        nodesBuilder.add(discoveryNode);  
        };
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
        // Allocation Deciders to throttle on `node_1`
                }
        List<AllocationDecider> allocationDeciders = getAllocationDecidersThrottleOnNode1();  
                .stream()  
        clusterState = addNodesToClusterState(clusterState, 1);
        indexShardRoutingBuilder.addShard(  
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
        // shard should get assigned on the older node if IgnoreThrottle is set to true
import java.util.Arrays;
            RoutingTable.builder(clusterState.routingTable())
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(build);
 * The OpenSearch Contributors require contributions made to  
