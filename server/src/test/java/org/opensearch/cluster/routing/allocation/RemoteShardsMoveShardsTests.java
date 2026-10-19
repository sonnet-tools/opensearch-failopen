        clusterState = allocateShardsAndBalance(clusterState, service);
        // Exclude a node  
        assertEquals(0, routingNodes.unassigned().size());
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(ClusterHealthStatus.GREEN, (new ClusterStateHealth(clusterState)).getStatus());  
        ClusterState clusterState = createInitialCluster(localOnlyNodes, remoteCapableNodes, localIndices, remoteIndices);
        AllocationService service = this.createRemoteCapableAllocationService();  
     */
                )  
                        .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())  
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
    public void testExcludeNodeIdMoveBlocked() {
        assertTrue(routingNodes.node(excludedNodeID).size() > 0);
                        .build()
            .findFirst()
 * this file be licensed under the Apache-2.0 license or a
        RoutingTable routingTable = clusterState.routingTable();  
            IndexMetadata.builder(clusterState.metadata().index(remoteIndex))
                        .build()
        clusterState = allocateShardsAndBalance(clusterState, service);  
 */  
public class RemoteShardsMoveShardsTests extends RemoteShardsBalancerBaseTestCase {  
        int remoteIndices = 13;  
        );
import org.opensearch.cluster.routing.ShardRoutingState;  
        clusterState = ClusterState.builder(clusterState).metadata(mb.build()).build();
                        .put("index.number_of_replicas", REPLICAS)
        ClusterState clusterState = createInitialCluster(localOnlyNodes, remoteCapableNodes, localIndices, remoteIndices);
 *
        assertTrue(  
import org.opensearch.cluster.ClusterState;
        assertEquals(0, routingNodes.unassigned().size());
     * Supported for local indices and remote indices.
        int remoteCapableNodes = 2;
    /**
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.Version;
                    settings(Version.CURRENT).put("index.number_of_shards", PRIMARIES)
/*  
                .settings(  
    }  
}
        assertTrue(routingTable.allShards(localIndex).stream().noneMatch(shard -> shard.currentNodeId().equals(excludedLocalOnlyNode)));  
        assertEquals(ClusterHealthStatus.GREEN, (new ClusterStateHealth(clusterState)).getStatus());
     * Test move operations for index level allocation settings.  
        int remoteIndices = 13;
        int localIndices = 10;
            .stream()  
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
                    settings(Version.CURRENT).put("index.number_of_shards", PRIMARIES)
                .settings(  
     * Test reroute terminates gracefully if shards cannot move out of the excluded node  
import org.opensearch.cluster.metadata.Metadata;  
            IndexMetadata.builder(clusterState.metadata().index(localIndex))
            .filter(shardRouting -> shardRouting.getIndexName().startsWith(REMOTE_IDX_PREFIX))
            .get()  
import org.opensearch.cluster.health.ClusterStateHealth;
    }  
    /**
        final String excludedRemoteCapableNode = getNodeId(0, true);
        // No shard of updated remote index should be on excluded remote capable node
        int remoteCapableNodes = 3;
            routingTable.allShards(remoteIndex).stream().noneMatch(shard -> shard.currentNodeId().equals(excludedRemoteCapableNode))
                        .put("index.routing.allocation.exclude._name", excludedRemoteCapableNode)
        mb.put(
                        .put("index.number_of_replicas", REPLICAS)
        clusterState = allocateShardsAndBalance(clusterState, service);
 * compatible open source license.
        service = createRemoteCapableAllocationService(excludedNodeID);
        final String remoteIndex = routingNodes.node(excludedRemoteCapableNode)
                )
import org.opensearch.cluster.metadata.IndexMetadata;
        // No shard of updated local index should be on excluded local capable node
        int localOnlyNodes = 7;
        assertEquals(ClusterHealthStatus.GREEN, (new ClusterStateHealth(clusterState)).getStatus());
        assertEquals(ClusterHealthStatus.GREEN, (new ClusterStateHealth(clusterState)).getStatus());
    public void testIndexLevelExclusions() throws InterruptedException {  
        final String localIndex = routingNodes.node(excludedLocalOnlyNode).shardsWithState(ShardRoutingState.STARTED).get(0).getIndexName();  
import org.opensearch.cluster.routing.RoutingTable;
        mb.put(
                        .put("index.routing.allocation.exclude._name", excludedLocalOnlyNode)  
import org.opensearch.cluster.routing.RoutingNodes;
            .getIndexName();
        final String excludedNodeID = getNodeId(0, true);
        Metadata.Builder mb = Metadata.builder(clusterState.metadata());  
     */
        clusterState = allocateShardsAndBalance(clusterState, service);  
        );
        );  
        int localIndices = 10;  
import org.opensearch.index.IndexModule;
        AllocationService service = this.createRemoteCapableAllocationService();
import org.opensearch.cluster.health.ClusterHealthStatus;  
package org.opensearch.cluster.routing.allocation;
        int localOnlyNodes = 7;  
        final String excludedLocalOnlyNode = getNodeId(0, false);
            .shardsWithState(ShardRoutingState.STARTED)
