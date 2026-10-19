 * compatible open source license.
    }
    }  
    /**
        refresh(INDEX_NAME);
        RemoteTranslogStats remoteTranslogStats = nodesStatsResponseForDataNode.getNodes()  
    public void testNodesStatsParityWithOnlyPrimaryShards() {
     */  
            .getTranslog()  
    /**
    public void testZeroRemoteStatsOnNodesStatsForClusterManager() {
            remoteSegmentStatsCumulative.add(new RemoteSegmentStats(remoteStoreStats.getRemoteStoreStats()[0].getSegmentStats()));
        internalCluster().startDataOnlyNodes(DATA_NODE_COUNT);
        assertZeroRemoteSegmentStats(
        assertEquals(remoteTranslogStatsCumulative, remoteTranslogStatsFromNodesStats);
        // Create first index
        setupCustomCluster();
    public void setup() {
        String firstIndex = INDEX_NAME + "1";
        String randomDataNode = dataNodes[randomIntBetween(0, dataNodes.length - 1)];  
        RemoteTranslogStats remoteTranslogStatsFromNodesStats = nodesStatsResponse.getNodes()  
        String secondIndex = INDEX_NAME + "2";
            .get(0)  
        indexSingleDoc(firstIndex, true);
        String firstIndex = INDEX_NAME + "1";  
     * - Repeats the above 3 steps for the second node  
        RemoteSegmentStats remoteSegmentStatsFromNodesStats = nodesStatsResponse.getNodes()
            .setIndices(new CommonStatsFlags().set(CommonStatsFlags.Flag.Segments, true).set(CommonStatsFlags.Flag.Translog, true))  
        }
        assertEquals(new RemoteSegmentStats(), remoteSegmentStats);
        assertTrue(remoteTranslogStats.getUploadBytesSucceeded() > 0);  
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;  
        NodesStatsResponse nodesStatsResponseForDataNode = client().admin()  
            .setIndices(new CommonStatsFlags().set(CommonStatsFlags.Flag.Segments, true).set(CommonStatsFlags.Flag.Translog, true))
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0));
            .getRemoteTranslogStats();
        createIndex(
                .get();
    private void assertZeroRemoteSegmentStats(RemoteSegmentStats remoteSegmentStats) {  
 */  
    }  
        );
     * Ensures that node stats shows 0 values for dedicated cluster manager nodes
        assertTrue(remoteSegmentStats.getUploadBytesStarted() > 0);  
        indexSingleDoc(firstIndex, true);
 *
     */  
        RemoteTranslogStats remoteTranslogStatsCumulative = new RemoteTranslogStats();  
        ensureStableCluster(DATA_NODE_COUNT + CLUSTER_MANAGER_NODE_COUNT);
        assertNodeStatsParityOnNode(randomDataNode, firstIndex, secondIndex);
        createIndex(secondIndex, Settings.builder().put(remoteStoreIndexSettings(1, 1)).build());
            .get();
        internalCluster().startClusterManagerOnlyNodes(CLUSTER_MANAGER_NODE_COUNT);  
        if (remoteSegmentStatsCumulative.getDownloadBytesStarted() > 0) {
     * - Polls the _remotestore/stats API for individual index level stats
            .cluster()
        createIndex(firstIndex, Settings.builder().put(remoteStoreIndexSettings(1, 1)).build());  
            .prepareNodesStats(primaryNodeName(INDEX_NAME))
     * - Polls _nodes/stats and verifies that the total values at node level adds up
import org.opensearch.common.settings.Settings;
            .getTranslog()  
                .cluster()
     * to the values capture in the previous step
            .getRemoteTranslogStats();
            RemoteStoreStatsResponse remoteStoreStats = client(dataNode).admin()  
            .cluster()
     * - Polls the _remotestore/stats API for individual index level stats
        );
    private static final String INDEX_NAME = "remote-index-1";
            assertTrue(remoteSegmentStatsCumulative.getTotalDownloadTime() > 0);
            assertNodeStatsParityOnNode(dataNode, indices);  
        assertTrue(remoteTranslogStats.getUploadBytesStarted() > 0);
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
import org.junit.Before;
import java.util.concurrent.TimeUnit;
     * to the values capture in the previous step
            .get(0)
     */
            .prepareNodesStats(dataNode)  
        // Create second index  
        String secondIndex = INDEX_NAME + "2";
            .getSegments()
 * The OpenSearch Contributors require contributions made to  
        NodesStatsResponse nodesStatsResponseForClusterManager = client().admin()
            nodesStatsResponseForClusterManager.getNodes().get(0).getIndices().getTranslog().getRemoteTranslogStats()  
            .getRemoteSegmentStats();
}
        // Create second index
    private static final int DATA_NODE_COUNT = 2;  
        indexSingleDoc(secondIndex, true);
        assertBusy(() -> assertNodeStatsParityAcrossNodes(firstIndex, secondIndex), 15, TimeUnit.SECONDS);  
    }
    /**  
        if (remoteSegmentStatsCumulative.getUploadBytesStarted() > 0) {  
                .setLocal(true)  
            nodesStatsResponseForClusterManager.getNodes().get(0).getNode().isClusterManagerNode()
        // Compare with fresh object because all values default to 0 in default fresh object
        createIndex(
            secondIndex,
        assertTrue(
                && !nodesStatsResponseForClusterManager.getNodes().get(0).getNode().isDataNode()  
     * - Creates two indices with single primary shard and single replica  
            Settings.builder().put(remoteStoreIndexSettings(0, 1)).put("index.routing.allocation.require._name", randomDataNode).build()
package org.opensearch.remotestore;
    private static final int CLUSTER_MANAGER_NODE_COUNT = 3;
            .get(0)
        ensureGreen(firstIndex);  
        assertEquals(remoteSegmentStatsCumulative, remoteSegmentStatsFromNodesStats);
        }  
        // Ensure that total download time has non-zero value if there has been segments downloaded to the node  
        // Ensure that total upload time has non-zero value if there has been segments uploaded from the node
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsResponse;
        );
            .get();
        RemoteSegmentStats remoteSegmentStatsCumulative = new RemoteSegmentStats();
        ensureGreen(firstIndex);
    }
        // assert segment stats
        // Compare with fresh object because all values default to 0 in default fresh object  
        String[] dataNodes = internalCluster().getDataNodeNames().toArray(String[]::new);
        assertZeroRemoteTranslogStats(
            .getIndices()  
     * - Index documents in both of them and forces a fresh for both
            .getIndices()
     * - Polls _nodes/stats and verifies that the total values at node level adds up
            .getSegments()
            .getIndices()
        }
            .getRemoteSegmentStats();  
     * - Index documents in both of them and forces a fresh for both
        assertTrue(nodesStatsResponseForDataNode.getNodes().get(0).getNode().isDataNode());  
     * - Adds up requisite fields from the API output, repeats this for the 2nd index  
        assertTrue(remoteSegmentStats.getUploadBytesSucceeded() > 0);
        for (String index : indices) {
        // assert translog stats
        RemoteSegmentStats remoteSegmentStats = nodesStatsResponseForDataNode.getNodes()
     * since cluster manager nodes does not participate in indexing
        ensureGreen(secondIndex);
            Settings.builder().put(remoteStoreIndexSettings(0, 1)).put("index.routing.allocation.require._name", randomDataNode).build()  
            .cluster()
        assertEquals(new RemoteTranslogStats(), remoteTranslogStats);
    }  
        indexSingleDoc(INDEX_NAME);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
                .prepareRemoteStoreStats(index, "0")
import org.opensearch.index.remote.RemoteSegmentStats;
        );
        NodesStatsResponse nodesStatsResponse = client().admin()
    private static void assertNodeStatsParityAcrossNodes(String... indices) {
    @Before  
        );
 * SPDX-License-Identifier: Apache-2.0
        ensureGreen(INDEX_NAME);  
/*  
            // Fetch _remotestore/stats
            .getIndices()
    private static void assertNodeStatsParityOnNode(String dataNode, String... indices) {
            nodesStatsResponseForClusterManager.getNodes().get(0).getIndices().getSegments().getRemoteSegmentStats()  
    public void testNodesStatsParityWithReplicaShards() throws Exception {
        // Fetch _nodes/stats  
import org.opensearch.test.OpenSearchIntegTestCase;
        }
            .prepareNodesStats(internalCluster().getClusterManagerName())  
public class RemoteStoreStatsFromNodesStatsIT extends RemoteStoreBaseIntegTestCase {
        ensureGreen(secondIndex);  
            .setIndices(new CommonStatsFlags().set(CommonStatsFlags.Flag.Segments, true).set(CommonStatsFlags.Flag.Translog, true))
     * - Creates two indices with single primary shard, pinned to a single node.  
            remoteTranslogStatsCumulative.add(new RemoteTranslogStats(remoteStoreStats.getRemoteStoreStats()[0].getTranslogStats()));  
    }  
            .get();
            firstIndex,  
    }
            assertTrue(remoteSegmentStatsCumulative.getTotalUploadTime() > 0);
    private void assertZeroRemoteTranslogStats(RemoteTranslogStats remoteTranslogStats) {
        for (String dataNode : internalCluster().getDataNodeNames()) {
 * this file be licensed under the Apache-2.0 license or a
    }  
            .get(0)
    private void setupCustomCluster() {
     * - Adds up requisite fields from the API output for both indices  
        indexSingleDoc(secondIndex, true);  
import org.opensearch.index.translog.RemoteTranslogStats;  
