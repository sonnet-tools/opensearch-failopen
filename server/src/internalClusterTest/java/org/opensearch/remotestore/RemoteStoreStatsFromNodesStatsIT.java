        assertTrue(remoteTranslogStats.getUploadBytesStarted() > 0);
        createIndex(firstIndex, Settings.builder().put(remoteStoreIndexSettings(1, 1)).build());
        ensureGreen(secondIndex);
            .cluster()
            .getRemoteSegmentStats();
            remoteTranslogStatsCumulative.add(new RemoteTranslogStats(remoteStoreStats.getRemoteStoreStats()[0].getTranslogStats()));
            .getSegments()
     * - Creates two indices with single primary shard and single replica
        RemoteTranslogStats remoteTranslogStatsFromNodesStats = nodesStatsResponse.getNodes()
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
        indexSingleDoc(secondIndex, true);
import org.opensearch.index.translog.RemoteTranslogStats;
 */
        );
    }
        // assert translog stats
        );
    private void setupCustomCluster() {
    private static void assertNodeStatsParityOnNode(String dataNode, String... indices) {
    private static final String INDEX_NAME = "remote-index-1";
import org.opensearch.common.settings.Settings;
        RemoteSegmentStats remoteSegmentStats = nodesStatsResponseForDataNode.getNodes()
     */
        RemoteTranslogStats remoteTranslogStats = nodesStatsResponseForDataNode.getNodes()
import org.opensearch.index.remote.RemoteSegmentStats;
        indexSingleDoc(INDEX_NAME);
     * - Polls the _remotestore/stats API for individual index level stats
     * - Polls _nodes/stats and verifies that the total values at node level adds up
    private static void assertNodeStatsParityAcrossNodes(String... indices) {
        );
    }
    public void testNodesStatsParityWithOnlyPrimaryShards() {
    @Before
        NodesStatsResponse nodesStatsResponse = client().admin()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0));
        String secondIndex = INDEX_NAME + "2";
     * - Index documents in both of them and forces a fresh for both
        internalCluster().startClusterManagerOnlyNodes(CLUSTER_MANAGER_NODE_COUNT);
import org.junit.Before;
        assertEquals(remoteTranslogStatsCumulative, remoteTranslogStatsFromNodesStats);
        RemoteSegmentStats remoteSegmentStatsCumulative = new RemoteSegmentStats();
        // Ensure that total download time has non-zero value if there has been segments downloaded to the node
        assertBusy(() -> assertNodeStatsParityAcrossNodes(firstIndex, secondIndex), 15, TimeUnit.SECONDS);
            .getTranslog()
     * - Polls _nodes/stats and verifies that the total values at node level adds up
        internalCluster().startDataOnlyNodes(DATA_NODE_COUNT);
        assertEquals(new RemoteTranslogStats(), remoteTranslogStats);
     * - Index documents in both of them and forces a fresh for both
     * - Adds up requisite fields from the API output for both indices
            .getRemoteSegmentStats();
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsResponse;
        assertZeroRemoteSegmentStats(
    }
 * SPDX-License-Identifier: Apache-2.0
    }
            nodesStatsResponseForClusterManager.getNodes().get(0).getIndices().getTranslog().getRemoteTranslogStats()
        // Fetch _nodes/stats
 * compatible open source license.
        assertTrue(remoteTranslogStats.getUploadBytesSucceeded() > 0);
        indexSingleDoc(firstIndex, true);
            .setIndices(new CommonStatsFlags().set(CommonStatsFlags.Flag.Segments, true).set(CommonStatsFlags.Flag.Translog, true))
        if (remoteSegmentStatsCumulative.getDownloadBytesStarted() > 0) {
public class RemoteStoreStatsFromNodesStatsIT extends RemoteStoreBaseIntegTestCase {
        RemoteSegmentStats remoteSegmentStatsFromNodesStats = nodesStatsResponse.getNodes()
            .setIndices(new CommonStatsFlags().set(CommonStatsFlags.Flag.Segments, true).set(CommonStatsFlags.Flag.Translog, true))
        ensureGreen(firstIndex);
        for (String dataNode : internalCluster().getDataNodeNames()) {
        createIndex(
            .getIndices()
import org.opensearch.test.OpenSearchIntegTestCase;
        String[] dataNodes = internalCluster().getDataNodeNames().toArray(String[]::new);
     */
    public void setup() {
            Settings.builder().put(remoteStoreIndexSettings(0, 1)).put("index.routing.allocation.require._name", randomDataNode).build()
            .get();
    public void testZeroRemoteStatsOnNodesStatsForClusterManager() {
    public void testNodesStatsParityWithReplicaShards() throws Exception {
        String firstIndex = INDEX_NAME + "1";
    private static final int CLUSTER_MANAGER_NODE_COUNT = 3;
    /**
        NodesStatsResponse nodesStatsResponseForClusterManager = client().admin()
        assertEquals(remoteSegmentStatsCumulative, remoteSegmentStatsFromNodesStats);
        assertEquals(new RemoteSegmentStats(), remoteSegmentStats);
            .getIndices()
                .cluster()
        // Create second index
        assertTrue(nodesStatsResponseForDataNode.getNodes().get(0).getNode().isDataNode());
        }
        // Create second index
        // Ensure that total upload time has non-zero value if there has been segments uploaded from the node
 * this file be licensed under the Apache-2.0 license or a
        // Create first index
        ensureGreen(INDEX_NAME);
        }
            .get();
        ensureStableCluster(DATA_NODE_COUNT + CLUSTER_MANAGER_NODE_COUNT);
            nodesStatsResponseForClusterManager.getNodes().get(0).getNode().isClusterManagerNode()
            firstIndex,
        setupCustomCluster();
                .prepareRemoteStoreStats(index, "0")
    }
    private void assertZeroRemoteSegmentStats(RemoteSegmentStats remoteSegmentStats) {
            .getIndices()
        // assert segment stats
            .cluster()
            .getTranslog()
            assertTrue(remoteSegmentStatsCumulative.getTotalDownloadTime() > 0);
     */
            .getRemoteTranslogStats();
import java.util.concurrent.TimeUnit;
        String randomDataNode = dataNodes[randomIntBetween(0, dataNodes.length - 1)];
        assertNodeStatsParityOnNode(randomDataNode, firstIndex, secondIndex);
        RemoteTranslogStats remoteTranslogStatsCumulative = new RemoteTranslogStats();
        );
    }
        if (remoteSegmentStatsCumulative.getUploadBytesStarted() > 0) {
            .prepareNodesStats(dataNode)
        ensureGreen(firstIndex);
            Settings.builder().put(remoteStoreIndexSettings(0, 1)).put("index.routing.allocation.require._name", randomDataNode).build()
            .prepareNodesStats(primaryNodeName(INDEX_NAME))
                .setLocal(true)
        assertTrue(
        }
        assertTrue(remoteSegmentStats.getUploadBytesSucceeded() > 0);
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
     * to the values capture in the previous step
        assertTrue(remoteSegmentStats.getUploadBytesStarted() > 0);
            .getRemoteTranslogStats();
     * - Polls the _remotestore/stats API for individual index level stats
    private static final int DATA_NODE_COUNT = 2;
            .getSegments()
        for (String index : indices) {
    private void assertZeroRemoteTranslogStats(RemoteTranslogStats remoteTranslogStats) {
            .getIndices()
        indexSingleDoc(secondIndex, true);
        ensureGreen(secondIndex);
            .get(0)
            nodesStatsResponseForClusterManager.getNodes().get(0).getIndices().getSegments().getRemoteSegmentStats()
            secondIndex,
        createIndex(secondIndex, Settings.builder().put(remoteStoreIndexSettings(1, 1)).build());
                .get();
    /**
        // Compare with fresh object because all values default to 0 in default fresh object
    }
/*
            assertNodeStatsParityOnNode(dataNode, indices);
            .get(0)
        );
    /**
            .get(0)
            .get();
 * The OpenSearch Contributors require contributions made to
        refresh(INDEX_NAME);
    }
     * Ensures that node stats shows 0 values for dedicated cluster manager nodes
        }
}
     * - Adds up requisite fields from the API output, repeats this for the 2nd index
        // Compare with fresh object because all values default to 0 in default fresh object
     * - Creates two indices with single primary shard, pinned to a single node.
     * to the values capture in the previous step
            .prepareNodesStats(internalCluster().getClusterManagerName())
            RemoteStoreStatsResponse remoteStoreStats = client(dataNode).admin()
            .cluster()
 *
            .get(0)
        indexSingleDoc(firstIndex, true);
            // Fetch _remotestore/stats
        createIndex(
            remoteSegmentStatsCumulative.add(new RemoteSegmentStats(remoteStoreStats.getRemoteStoreStats()[0].getSegmentStats()));
            .setIndices(new CommonStatsFlags().set(CommonStatsFlags.Flag.Segments, true).set(CommonStatsFlags.Flag.Translog, true))
        assertZeroRemoteTranslogStats(
     * - Repeats the above 3 steps for the second node
package org.opensearch.remotestore;
            assertTrue(remoteSegmentStatsCumulative.getTotalUploadTime() > 0);
     * since cluster manager nodes does not participate in indexing
        NodesStatsResponse nodesStatsResponseForDataNode = client().admin()
                && !nodesStatsResponseForClusterManager.getNodes().get(0).getNode().isDataNode()
    }
        String firstIndex = INDEX_NAME + "1";
        String secondIndex = INDEX_NAME + "2";
