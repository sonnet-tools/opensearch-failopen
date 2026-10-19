    public void testNodeReplacement() {
 * compatible open source license.
     * During moveShards(), shards are picked from across indexes in an interleaved manner.
        setupInitialCluster(5, 1, 5, 1);  
        addNodesWithoutIndexing(1, "new_node_");  
    }  
        assertForIndexShardHotSpots(false, 4);
        buildAllocationService();  
 * this file be licensed under the Apache-2.0 license or a
     */
        allocateAndCheckIndexShardHotSpots(false, 4, "new_node_0");
        terminateNodes("node_1");
     */
    }
        buildAllocationService("node_0,node_1");
import org.opensearch.cluster.OpenSearchAllocationWithConstraintsTestCase;
    public void testUnderReplicatedClusterScaleOut() {
    /**
    public void testClusterScaleInWithSkew() {  
    public void testClusterScaleIn() {
 *
    /**
        allocateAndCheckIndexShardHotSpots(false, 5, "new_node_0");
    /**
        buildAllocationService();
        addNodesWithoutIndexing(1, "new_node_");
    public void testSkewedClusterScaleOut() {
        allocateAndCheckIndexShardHotSpots(false, 2, "node_2", "node_3");
        allocateAndCheckIndexShardHotSpots(false, 3, "node_2", "node_3", "new_node_0");
     * Test single node replacement with active indexing.
/*  
     */  
        addNodesWithIndexing(1, "new_node_", 8, 10, 1);
    }
 */  
        allocateAndCheckIndexShardHotSpots(false, 4, "new_node_0");  
        buildAllocationService("node_0,node_1");
     * in subsequent runs.  
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/2063")
     * This prevents hot spots by evenly picking up shards. Since shard order can change
     * Test cluster scale in scenario, when nodes are gracefully excluded from
    /**  
package org.opensearch.cluster.routing.allocation;
 * The OpenSearch Contributors require contributions made to  
        setupInitialCluster(3, 30, 10, 1);
public class IndexShardHotSpotTests extends OpenSearchAllocationWithConstraintsTestCase {  
        addNodesWithIndexing(1, "new_node_", 3, 20, 1);  
     */
        setupInitialCluster(5, 30, 5, 1);
     * Test cluster scale in scenario with skewed shard distribution in remaining nodes.  
     * Test under replicated yellow cluster scale out to green.  
        addNodesWithoutIndexing(1, "new_node_");  
        setupInitialCluster(3, 30, 10, 3);  
     */
    /**
     * Test single node replacement without active indexing.  
}  
        assertForIndexShardHotSpots(false, 4);
    }
        setupInitialCluster(4, 30, 10, 1);  
    /**
     */  
    public void testNodeReplacementWithIndexing() {
        terminateNodes("node_1");
     * cluster before termination.
        setupInitialCluster(4, 100, 5, 1);
     * <p>  
        allocateAndCheckIndexShardHotSpots(false, 5, "new_node_0");
    }  
 * SPDX-License-Identifier: Apache-2.0
     * Test skewed cluster scale out via single node addition during active indexing.
    }
        buildAllocationService();  
