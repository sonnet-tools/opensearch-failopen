            Settings.builder()
            .filter(ShardRouting::assignedToNode)
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testSearchReplicaAllocatedToDedicatedSearchNode() {
    }
        createIndex(  
        assertEquals(1, routingTable.searchOnlyReplicas().stream().filter(ShardRouting::unassigned).count());  
        final String node_1 = internalCluster().startSearchOnlyNode();
import org.opensearch.cluster.routing.ShardRouting;  
            "test",
import org.opensearch.test.OpenSearchIntegTestCase;
    private String getNodeName(String id) {
        internalCluster().startNodes(2);
        assertEquals(1, assignedSearchShards.size());
    }  
}
                .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
 * SPDX-License-Identifier: Apache-2.0
        ensureGreen("test");
        assertNull(routingTable.searchOnlyReplicas().get(0).currentNodeId());  
/*  
        ensureYellowAndNoInitializingShards("test");  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        IndexShardRoutingTable routingTable = getRoutingTable();
        return getClusterState().nodes().get(id).getName();
import org.opensearch.common.settings.Settings;
        ensureYellowAndNoInitializingShards("test");
            "test",
        assertEquals(node_1, getNodeName(assignedSearchShards.get(0).currentNodeId()));
        assertEquals(2, routingTable.searchOnlyReplicas().size());
        createIndex(  
            .collect(Collectors.toList());  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;  
        logger.info("--> creating an index with no replicas");
        );
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertEquals(2, cluster().size());
        String primaryNode = internalCluster().startDataOnlyNode();
 * compatible open source license.
            Settings.builder()
                .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
    }
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }
                .build()
package org.opensearch.cluster.allocation;
import org.opensearch.indices.replication.common.ReplicationType;
        IndexShardRoutingTable routingTable = getRoutingTable();
        assertEquals(searchNode, getNodeName(getRoutingTable().searchOnlyReplicas().get(0).currentNodeId()));  
        );  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
    }
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertEquals(3, cluster().size());
            .stream()
        assertEquals(3, cluster().size());  
        );
    private IndexShardRoutingTable getRoutingTable() {  
 *
    public void testSearchReplicaDedicatedIncludes_WhenNotSetDoNotAssign() {  
import java.util.stream.Collectors;
 * The OpenSearch Contributors require contributions made to  
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 2)
        return getClusterState().routingTable().index("test").getShards().get(0);
        final String searchNode = internalCluster().startSearchOnlyNode();  
        // ensure primary is not on searchNode
            Settings.builder()  
        internalCluster().startClusterManagerOnlyNode();  
                .build()
        assertEquals(primaryNode, getNodeName(routingTable.primaryShard().currentNodeId()));  
        IndexShardRoutingTable routingTable = getRoutingTable();
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;  
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)  
        // Add a search node
public class SearchReplicaAllocationIT extends RemoteStoreBaseIntegTestCase {  
        internalCluster().startSearchOnlyNode();
                .build()
        internalCluster().startNodes(2);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;  
    public void testSearchReplicaDedicatedIncludes_DoNotAssignToOtherNodes() {  
            "test",
 */  
        List<ShardRouting> assignedSearchShards = routingTable.searchOnlyReplicas()  
                .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
        createIndex(
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        ensureGreen("test");  
