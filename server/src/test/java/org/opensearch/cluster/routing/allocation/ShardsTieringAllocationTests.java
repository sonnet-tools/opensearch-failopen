            RoutingPool nodePool = RoutingPool.getNodePool(node);
            assertEquals(LOCAL_ONLY, shardPool);
            assertEquals(REMOTE_CAPABLE, nodePool);
        String index = "test-index";
            IndexModule.TieringState.HOT_TO_WARM.name(),
        int remoteIndices = 10; // 5 primary, 1 replica
        clusterState = allocateShardsAndBalance(clusterState, service);
        ClusterState clusterState = createInitialCluster(localOnlyNodes, remoteCapableNodes, localIndices, remoteIndices);
            assertFalse(shard.unassigned());
    }
        ClusterState clusterState = createInitialCluster(localOnlyNodes, remoteCapableNodes, localIndices, remoteIndices);
        }
            assertBusy(() -> { assertFalse(shard.unassigned()); });
        IndexMetadata indexMetadata = IndexMetadata.builder(index)
import static org.opensearch.cluster.routing.RoutingPool.getIndexPool;
        int localIndices = 10;
    public void testShardsWithTiering() {
        IndexMetadata indexMetadata = IndexMetadata.builder(index)
            RoutingPool shardPool = RoutingPool.getShardPool(shard, allocation);
        clusterState = allocateShardsAndBalance(clusterState, service);
 * The OpenSearch Contributors require contributions made to
            assertEquals(REMOTE_CAPABLE, shardPool);
    public void testShardsInRemotePool() {
            localIndices,
            clusterState,
        assertEquals(LOCAL_ONLY, indexPool);
            RoutingPool shardPool = RoutingPool.getShardPool(shard, allocation);
            assertEquals(nodePool, shardPool);
        int remoteCapableNodes = 13;
        clusterState = allocateShardsAndBalance(clusterState, service);
        int localOnlyNodes = 60;
        allocation = getRoutingAllocation(clusterState, routingNodes);
        clusterState = allocateShardsAndBalance(clusterState, service);
            RoutingPool shardPool = RoutingPool.getShardPool(shard, allocation);
            remoteIndices,
    }
import static org.opensearch.cluster.routing.RoutingPool.REMOTE_CAPABLE;
            assertEquals(RoutingPool.REMOTE_CAPABLE, shardPool);
        assertEquals(0, routingNodes.unassigned().size());
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        assertEquals(0, routingNodes.unassigned().size());
        RoutingAllocation allocation = getRoutingAllocation(clusterState, routingNodes);
            assertTrue(shard.relocating() || shard.started());
    public void testShardsInLocalPool() {
            .build();
            RoutingPool shardPool = RoutingPool.getShardPool(shard, allocation);
    @LockFeatureFlag(WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)
            RoutingNode node = routingNodes.node(shard.currentNodeId());
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
    public void testShardsWithWarmToHotTiering() throws Exception {
            assertEquals(nodePool, shardPool);
        // trigger shard relocation
        // assign shards to respective nodes
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        assertEquals(0, routingNodes.unassigned().size());
        clusterState = allocateShardsAndBalance(clusterState, service);
        AllocationService service = this.createRemoteCapableAllocationService();
 *
 * SPDX-License-Identifier: Apache-2.0
 */
    public void testShardPoolForPartialIndices() {
            remoteIndices,
            localIndices,
import org.opensearch.cluster.routing.RoutingPool;
        int localIndices = 5;
import static org.opensearch.cluster.routing.RoutingPool.LOCAL_ONLY;
        int localOnlyNodes = 7;
            false
            .settings(settings(Version.CURRENT).put(IS_WARM_INDEX_SETTING.getKey(), false))
        clusterState = updateIndexMetadataForTiering(
        // trigger shard relocation
import org.opensearch.cluster.routing.ShardRouting;
        int remoteIndices = 0;
    @LockFeatureFlag(WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)
        int localOnlyNodes = 15;
        }
        for (ShardRouting shard : clusterState.getRoutingTable().allShards()) {
        }
        for (ShardRouting shard : clusterState.getRoutingTable().allShards()) {
        int localIndices = 0;
        int remoteCapableNodes = 13;
            assertFalse(shard.unassigned());
 * this file be licensed under the Apache-2.0 license or a
    }
            assertEquals(LOCAL_ONLY, shardPool);
        assertEquals(0, routingNodes.unassigned().size());
        RoutingPool indexPool = getIndexPool(indexMetadata);
import org.opensearch.cluster.metadata.IndexMetadata;
            true
    }
            RoutingPool shardPool = RoutingPool.getShardPool(shard, allocation);
import org.opensearch.cluster.routing.RoutingNodes;
        AllocationService service = this.createRemoteCapableAllocationService();
    @LockFeatureFlag(WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)
 * compatible open source license.
        int remoteIndices = 13;
        for (ShardRouting shard : clusterState.getRoutingTable().allShards()) {
        clusterState = allocateShardsAndBalance(clusterState, service);
        AllocationService service = this.createRemoteCapableAllocationService();
            .numberOfShards(PRIMARIES)
        AllocationService service = this.createRemoteCapableAllocationService();
            assertFalse(shard.unassigned());
        int remoteIndices = 0;
        assertEquals(0, routingNodes.unassigned().size());
            .settings(settings(Version.CURRENT).put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true))
        ClusterState clusterState = createInitialCluster(localOnlyNodes, remoteCapableNodes, true, localIndices, remoteIndices, true);
        clusterState = updateIndexMetadataForTiering(
        );
        ClusterState clusterState = createInitialCluster(localOnlyNodes, remoteCapableNodes, localIndices, remoteIndices);
        RoutingAllocation allocation = getRoutingAllocation(clusterState, routingNodes);
}
            .numberOfReplicas(REPLICAS)
        // put indices in the hot to warm tiering state
        // assign shards to respective nodes
package org.opensearch.cluster.routing.allocation;
        RoutingAllocation allocation = getRoutingAllocation(clusterState, routingNodes);
        RoutingPool indexPool = getIndexPool(indexMetadata);
        int localIndices = 0;
        int remoteCapableNodes = 3;
        // assign shards to respective nodes
        }
        int localOnlyNodes = 5;
        // put indices in the hot to warm tiering state
            .build();
import static org.opensearch.index.IndexModule.IS_WARM_INDEX_SETTING;
import org.opensearch.cluster.routing.RoutingNode;
            assertEquals(REMOTE_CAPABLE, shardPool);
            .numberOfShards(PRIMARIES)
        routingNodes = clusterState.getRoutingNodes();
            .numberOfReplicas(REPLICAS)
            IndexModule.TieringState.WARM_TO_HOT.name(),
        for (ShardRouting shard : clusterState.getRoutingTable().allShards()) {
import org.opensearch.cluster.ClusterState;
            RoutingPool nodePool = RoutingPool.getNodePool(node);
import org.opensearch.Version;
            RoutingNode node = routingNodes.node(shard.currentNodeId());
    }
            RoutingNode node = routingNodes.node(shard.currentNodeId());
        );
        assertEquals(REMOTE_CAPABLE, indexPool);
    @LockFeatureFlag(WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)
        // assign shards to respective nodes
    }
import org.opensearch.index.IndexModule;
        RoutingAllocation allocation = getRoutingAllocation(clusterState, routingNodes);
        int remoteCapableNodes = 3;
public class ShardsTieringAllocationTests extends TieringAllocationBaseTestCase {
/*
    @LockFeatureFlag(WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
    @LockFeatureFlag(WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)
        }
    public void testShardPoolForFullIndices() {
        for (ShardRouting shard : clusterState.getRoutingTable().allShards()) {
            clusterState,
        String index = "test-index";
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG;
            RoutingPool nodePool = RoutingPool.getNodePool(node);
        // Create a cluster with warm only roles (dedicated setup) and remote index is of type warm only.
