}
    }
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
    }
import org.opensearch.action.admin.indices.stats.ShardStats;
 * - _stats/docs reports correct doc count  
        long totalSegmentCount = 0;
    /**  
            .setIndices(new CommonStatsFlags(CommonStatsFlags.Flag.Segments))
            .clear()  
 * Validates:  
        NodesStatsResponse nodesStats = client().admin()
        createCompositeIndex(indexName);
            .sum();
        assertTrue("Node stats should report at least one segment after flush", totalSegmentCount > 0);
        flushIndex(indexName);
        String indexName = "test-nodestats-seg-count";
        for (NodeStats nodeStats : nodesStats.getNodes()) {  
            if (nodeStats.getIndices() != null && nodeStats.getIndices().getSegments() != null) {  
        indexDocs(indexName, 10, 0);  
        for (NodeStats nodeStats : nodesStats.getNodes()) {
    }
    public void testNodeStatsAndIndexStatsSegmentCountConsistency() {  
import org.opensearch.index.engine.SegmentsStats;  
        indexDocs(indexName, 10, 0);  
 * Integration tests verifying index stats API and node stats API for DataFormatAwareEngine.
        createCompositeIndex(indexName);
     * Tests that index stats API reports correct doc count after indexing.  
            }
    public void testIndexStatsDocCount() {
        refreshIndex(indexName);
            .cluster()
    }  
        indexDocs(indexName, 10, 0);  
        NodesStatsResponse nodesStats = client().admin()  
            }  
     * Tests that node stats API reports segment count > 0 after flush.
     * Tests that node stats and index stats report consistent segment counts.
        ShardStats shardStats = indexStats.getIndex(indexName).getShards()[0];
        String indexName = "test-consistency-seg-count";
    public void testNodeStatsSegmentsCount() {  
    public void testNodeStatsSegmentsAfterFlush() {  
            .mapToLong(n -> n.getIndices().getSegments().getCount())  
 * compatible open source license.
            .cluster()
 * - _nodes/stats/indices/segments (node stats API) reports segment count and file sizes
 */  
        indexDocs(indexName, docCount, 0);  
    /**  
            .clear()  
     * Note: node stats API does not support includeSegmentFileSizes (only index stats API does),  
 * SPDX-License-Identifier: Apache-2.0
        refreshIndex(indexName);
        long indexStatsSegmentCount = indexSegmentsStats.getCount();
/*  
        long totalDocs = statsResponse.getIndex(indexName).getTotal().getDocs().getCount();
        SegmentsStats indexSegmentsStats = shardStats.getStats().getSegments();
        createCompositeIndex(indexName);
        }
        IndicesStatsResponse indexStats = client().admin().indices().prepareStats(indexName).clear().setSegments(true).get();  
        long totalSegmentCount = 0;
     */
import org.opensearch.test.OpenSearchIntegTestCase;
        assertNotNull("Index stats segments should not be null", indexSegmentsStats);  
 *
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;  
     */
            .cluster()
        assertEquals("Index stats doc count should match indexed docs", docCount, totalDocs);  
        int docCount = 15;
            .get();  
        long nodeStatsSegmentCount = nodesStats.getNodes()  
     * Tests that node stats API reports segment count > 0 after indexing and refresh.
        String indexName = "test-indexstats-docs";  
     */
 * The OpenSearch Contributors require contributions made to  
 *
            .prepareNodesStats()
 */
            .prepareNodesStats()
        NodesStatsResponse nodesStats = client().admin()  
 * this file be licensed under the Apache-2.0 license or a
        createCompositeIndex(indexName);
        String indexName = "test-nodestats-seg-flush";
            .stream()
 * - _stats/segments (index stats API) reports correct segment count and file sizes
            .filter(n -> n.getIndices() != null && n.getIndices().getSegments() != null)
        IndicesStatsResponse statsResponse = client().admin().indices().prepareStats(indexName).clear().setDocs(true).get();  
            .get();
            .setIndices(new CommonStatsFlags(CommonStatsFlags.Flag.Segments))
            .setIndices(new CommonStatsFlags(CommonStatsFlags.Flag.Segments))
    /**
        assertEquals("Segment count from node stats and index stats should be consistent", indexStatsSegmentCount, nodeStatsSegmentCount);  
        refreshIndex(indexName);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 1)  
package org.opensearch.composite;
     */
        assertTrue("Node stats should report at least one segment after refresh", totalSegmentCount > 0);
            .prepareNodesStats()  
    /**
        }  
            .clear()
/**  
                totalSegmentCount += nodeStats.getIndices().getSegments().getCount();
            .get();
        refreshIndex(indexName);
     * so file sizes are always empty via this path.
                totalSegmentCount += nodeStats.getIndices().getSegments().getCount();
            if (nodeStats.getIndices() != null && nodeStats.getIndices().getSegments() != null) {
public class CompositeStatsApiIT extends AbstractCompositeEngineIT {
 * - node stats and index stats segment counts are consistent
