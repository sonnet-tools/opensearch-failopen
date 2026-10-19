        int localIndices = 0;
        RoutingPool indexPool = getIndexPool(indexMetadata);
        for (ShardRouting shard : clusterState.getRoutingTable().allShards()) {  
            RoutingPool shardPool = RoutingPool.getShardPool(shard, allocation);
            .build();
        String index = "test-index";
}
            clusterState,  
        }  
        allocation = getRoutingAllocation(clusterState, routingNodes);
        clusterState = allocateShardsAndBalance(clusterState, service);  
        ClusterState clusterState = createInitialCluster(localOnlyNodes, remoteCapableNodes, localIndices, remoteIndices);  
        clusterState = allocateShardsAndBalance(clusterState, service);  
    }
        RoutingAllocation allocation = getRoutingAllocation(clusterState, routingNodes);  
            RoutingPool shardPool = RoutingPool.getShardPool(shard, allocation);
        int remoteIndices = 13;
        }  
        for (ShardRouting shard : clusterState.getRoutingTable().allShards()) {
        int localOnlyNodes = 7;
    public void testShardsInRemotePool() {
import static org.opensearch.cluster.routing.RoutingPool.REMOTE_CAPABLE;
            localIndices,  
            assertBusy(() -> { assertFalse(shard.unassigned()); });  
            remoteIndices,
            assertEquals(nodePool, shardPool);  
        // assign shards to respective nodes  
        int remoteCapableNodes = 13;
    @LockFeatureFlag(WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)  
            .numberOfShards(PRIMARIES)
            RoutingPool shardPool = RoutingPool.getShardPool(shard, allocation);
import org.opensearch.Version;
        assertEquals(0, routingNodes.unassigned().size());
        ClusterState clusterState = createInitialCluster(localOnlyNodes, remoteCapableNodes, localIndices, remoteIndices);  
        assertEquals(REMOTE_CAPABLE, indexPool);  
        // put indices in the hot to warm tiering state  
        for (ShardRouting shard : clusterState.getRoutingTable().allShards()) {  
            assertEquals(REMOTE_CAPABLE, nodePool);  
        }
 * compatible open source license.
            false  
        IndexMetadata indexMetadata = IndexMetadata.builder(index)  
    public void testShardPoolForPartialIndices() {
            RoutingPool shardPool = RoutingPool.getShardPool(shard, allocation);  
        RoutingPool indexPool = getIndexPool(indexMetadata);
        assertEquals(0, routingNodes.unassigned().size());  
        clusterState = allocateShardsAndBalance(clusterState, service);
            IndexModule.TieringState.HOT_TO_WARM.name(),  
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
            assertEquals(nodePool, shardPool);
    public void testShardPoolForFullIndices() {
            assertFalse(shard.unassigned());
            assertEquals(LOCAL_ONLY, shardPool);
            .numberOfShards(PRIMARIES)
        int localIndices = 0;
        // trigger shard relocation
            RoutingNode node = routingNodes.node(shard.currentNodeId());
        // assign shards to respective nodes
        AllocationService service = this.createRemoteCapableAllocationService();
        clusterState = updateIndexMetadataForTiering(
        );
            assertEquals(RoutingPool.REMOTE_CAPABLE, shardPool);
        RoutingAllocation allocation = getRoutingAllocation(clusterState, routingNodes);
 *
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
import static org.opensearch.cluster.routing.RoutingPool.getIndexPool;  
import org.opensearch.index.IndexModule;
        RoutingAllocation allocation = getRoutingAllocation(clusterState, routingNodes);
        String index = "test-index";
            .build();
        assertEquals(0, routingNodes.unassigned().size());
    }
        for (ShardRouting shard : clusterState.getRoutingTable().allShards()) {
    public void testShardsWithTiering() {
        // put indices in the hot to warm tiering state
        AllocationService service = this.createRemoteCapableAllocationService();
        int remoteIndices = 0;
        int localIndices = 10;
        for (ShardRouting shard : clusterState.getRoutingTable().allShards()) {
        // assign shards to respective nodes
        clusterState = updateIndexMetadataForTiering(
            .settings(settings(Version.CURRENT).put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true))
        int localIndices = 5;
    }
import org.opensearch.cluster.routing.RoutingPool;  
    }
        IndexMetadata indexMetadata = IndexMetadata.builder(index)  
            remoteIndices,
            assertEquals(REMOTE_CAPABLE, shardPool);
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG;
import org.opensearch.cluster.metadata.IndexMetadata;  
    public void testShardsWithWarmToHotTiering() throws Exception {
        clusterState = allocateShardsAndBalance(clusterState, service);
            assertFalse(shard.unassigned());  
            .settings(settings(Version.CURRENT).put(IS_WARM_INDEX_SETTING.getKey(), false))
    public void testShardsInLocalPool() {
    @LockFeatureFlag(WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)  
        int remoteIndices = 10; // 5 primary, 1 replica  
            assertEquals(REMOTE_CAPABLE, shardPool);
    }
        assertEquals(LOCAL_ONLY, indexPool);  
package org.opensearch.cluster.routing.allocation;
import static org.opensearch.index.IndexModule.IS_WARM_INDEX_SETTING;
        // Create a cluster with warm only roles (dedicated setup) and remote index is of type warm only.
import org.opensearch.cluster.routing.RoutingNodes;
            true
            clusterState,
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
            .numberOfReplicas(REPLICAS)  
 */  
        }
        }  
        clusterState = allocateShardsAndBalance(clusterState, service);  
        int remoteCapableNodes = 3;  
public class ShardsTieringAllocationTests extends TieringAllocationBaseTestCase {
            RoutingPool nodePool = RoutingPool.getNodePool(node);
import org.opensearch.cluster.routing.ShardRouting;
        int remoteIndices = 0;
    @LockFeatureFlag(WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)  
        int localOnlyNodes = 15;
            localIndices,
import static org.opensearch.cluster.routing.RoutingPool.LOCAL_ONLY;
        RoutingAllocation allocation = getRoutingAllocation(clusterState, routingNodes);  
            RoutingNode node = routingNodes.node(shard.currentNodeId());
    }
            IndexModule.TieringState.WARM_TO_HOT.name(),
        int localOnlyNodes = 60;  
        int remoteCapableNodes = 3;  
 * this file be licensed under the Apache-2.0 license or a
            assertTrue(shard.relocating() || shard.started());
        AllocationService service = this.createRemoteCapableAllocationService();
    @LockFeatureFlag(WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)  
    @LockFeatureFlag(WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)  
        clusterState = allocateShardsAndBalance(clusterState, service);  
        ClusterState clusterState = createInitialCluster(localOnlyNodes, remoteCapableNodes, true, localIndices, remoteIndices, true);  
        // trigger shard relocation  
        assertEquals(0, routingNodes.unassigned().size());  
 * The OpenSearch Contributors require contributions made to  
    @LockFeatureFlag(WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)
        assertEquals(0, routingNodes.unassigned().size());  
            assertFalse(shard.unassigned());  
        // assign shards to respective nodes
        );
/*  
            RoutingPool shardPool = RoutingPool.getShardPool(shard, allocation);
        ClusterState clusterState = createInitialCluster(localOnlyNodes, remoteCapableNodes, localIndices, remoteIndices);  
            .numberOfReplicas(REPLICAS)  
            RoutingNode node = routingNodes.node(shard.currentNodeId());  
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
            assertEquals(LOCAL_ONLY, shardPool);
import org.opensearch.cluster.ClusterState;
            RoutingPool nodePool = RoutingPool.getNodePool(node);
        AllocationService service = this.createRemoteCapableAllocationService();
        int localOnlyNodes = 5;
        routingNodes = clusterState.getRoutingNodes();
import org.opensearch.cluster.routing.RoutingNode;
        int remoteCapableNodes = 13;  
            RoutingPool nodePool = RoutingPool.getNodePool(node);  
