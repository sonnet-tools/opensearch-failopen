            .setIncludeSegmentFileSizes(includeFileSizes)
        }
     * Tests that segments are sorted by generation when multiple refreshes create multiple segments.  
                    + segments.get(i).getGeneration(),  
                    + (i - 1)  
    /**  
    private SegmentsStats getSegmentsStats(String indexName, boolean includeFileSizes) {
        dataNodeStats = getDataNodeStats();
 * SPDX-License-Identifier: Apache-2.0
        List<Segment> segments = getSegmentsFromApi(indexName);  
    // --- Helper methods ---  
                return ns;
        return shardSegments[0].getSegments();
        }
    }
        refreshIndex(indexName);
            }  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 1)
        ensureGreen(indexName);  
        createCompositeIndex(indexName);
 */  
        List<Segment> afterSecondRefresh = getSegmentsFromApi(indexName);
        SegmentsStats stats = getSegmentsStats(indexName, false);
    public void testSegmentsStatsWithFileSizes() {
        // Index another batch, flush, and verify again  
        // Flush again
        for (int i = 1; i < segments.size(); i++) {  
     * After flush, segments become committed.
        // Create multiple segments via multiple refresh cycles  
        // Ensure all operations are complete before checking segments  
        refreshIndex(indexName);
        // Before flush: segments should be searchable but NOT committed
 *
        assertFalse("Should have segments after second flush", segmentsAfterSecondFlush.isEmpty());
 * - segments() returns correct committed/searchable state before and after flush  
    /**
        assertTrue("Should have segments after second refresh", segmentsAfterSecondRefresh.size() >= 1);
        NodesStatsResponse nodesStats = client().admin().cluster().prepareNodesStats().all().get();
            assertTrue(
        assertTrue("Should have segments", afterSecondRefresh.size() >= 1);
import java.util.Map;  
                    + "]="
            .prepareStats(indexName)
 * The OpenSearch Contributors require contributions made to  
        int totalDocs = 0;  
/*  
        List<Segment> segmentsAfterFlush = getSegmentsFromApi(indexName);
        String indexName = "test-seg-commit-transitions";
        assertEquals("Node-level doc count should match indexed docs", 10L, docsStats.getCount());
        indexDocs(indexName, 5, 5);
        // Fallback to first node with indices stats
        }  
    @Override
        assertTrue("Segment count should be > 0", stats.getCount() > 0);
package org.opensearch.composite;
    }
        // Index more docs and refresh — verify counts update
        createCompositeIndex(indexName);
        assertFalse("Should have segments after flush", segmentsAfterFlush.isEmpty());
     * Tests that segmentsStats without file sizes does not populate the file sizes map.  
        assertEquals("Segment count from stats should match segments API", segments.size(), stats.getCount());
        indexDocs(indexName, 5, 0);
     * Tests that segmentsStats includes file sizes when requested.
/**
        ShardSegments[] shardSegments = indexSegments.getShards().values().iterator().next().getShards();  
    }  
     */
        dataNodeStats = getDataNodeStats();
                return ns;
import org.opensearch.index.engine.Segment;  
        ensureGreen(indexName);  
        assertTrue("Node-level segment count should be > 0", segmentsStats.getCount() > 0);
        indexDocs(indexName, 5, 0);
    }  
        docsStats = dataNodeStats.getIndices().getDocs();  
            assertTrue("Segment should be searchable before flush", seg.search);
    /**
            if (ns.getIndices() != null && ns.getIndices().getDocs().getCount() > 0) {
        assertTrue("Total size should be > 0", totalSize > 0);
        // Verify data is accessible after first flush by checking segments
        List<Segment> segmentsAfterSecondFlush = getSegmentsFromApi(indexName);  
    /**
            assertTrue("File size for '" + entry.getKey() + "' should be >= 0", entry.getValue() >= 0);
            .indices()
        assertNotNull("Index segments should exist", indexSegments);
        for (Segment seg : segmentsAfterFlush) {  
    protected Settings nodeSettings(int nodeOrdinal) {
        createCompositeIndex(indexName);  
        long totalSize = 0;
     */
        assertFalse("Should have segments after refresh", segmentsBeforeFlush.isEmpty());
        assertNotNull("SegmentsStats should not be null", stats);  
                    + segments.get(i - 1).getGeneration()
        assertNotNull("Docs stats from node stats should not be null", docsStats);
    public void testSegmentsDocCountAndSize() {  
    public void testNodeStatsIncludesSegmentStats() {
        String indexName = "test-seg-generation-order";  
        }
import java.util.List;
        assertFalse("File sizes should not be empty when includeSegmentFileSizes=true", fileSizes.isEmpty());
        SegmentsStats stats = getSegmentsStats(indexName, false);
        assertTrue("Should have multiple segments", segments.size() >= 2);
        // Index first batch and verify  
import org.opensearch.common.settings.Settings;
     */  
                    + "]="
            totalSize += seg.sizeInBytes;
        Map<String, Long> fileSizes = stats.getFileSizes();  
        fail("No data node found with indices stats");
            .clear()  
    public void testSegmentsStatsCount() {  
        assertEquals("Doc count should update after third batch and flush", 30L, docsStats.getCount());
        assertNotNull("Segments stats from node stats should not be null", segmentsStats);  
        for (Map.Entry<String, Long> entry : fileSizes.entrySet()) {  
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).build();  
        NodeStats dataNodeStats = getDataNodeStats();
        List<Segment> segments = getSegmentsFromApi(indexName);  
            totalDocs += seg.docCount;
        indexDocs(indexName, 5, 5);  
        createCompositeIndex(indexName);
        refreshIndex(indexName);
     */
 * Integration tests for segments and segments stats APIs on DataFormatAwareEngine.  
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;  
        indexDocs(indexName, 10, 0);
            assertTrue("sizeInBytes should be > 0", seg.sizeInBytes > 0);
 * Validates:
        refreshIndex(indexName);
     */
import org.opensearch.action.admin.indices.segments.IndexSegments;  
        String indexName = "test-segstats-no-filesizes";  
     * Note: Composite engines may handle committed state differently than pure Lucene engines.  
        for (Segment seg : segments) {
        for (int i = 0; i < segmentsBeforeFlush.size(); i++) {  
            assertTrue("Segment should be committed after flush", seg.committed);
        assertNotNull("Node indices stats should not be null", dataNodeStats.getIndices());  
        createCompositeIndex(indexName);  
        refreshIndex(indexName);  
        assertEquals("Doc count should update after second refresh", 20L, docsStats.getCount());
        return shardStats.getStats().getSegments();
        SegmentsStats segmentsStats = dataNodeStats.getIndices().getSegments();
     * Tests committed state transitions: new docs after flush are not committed until next flush.
        // Verify we can access segments after second refresh  
                segments.get(i).getGeneration() >= segments.get(i - 1).getGeneration()
     * and that stats are updated correctly as documents are indexed and refreshed.  
 *
        assertFalse("Should have segments", segments.isEmpty());
 * - segmentsStats() returns correct segment count and file sizes
        assertNotNull("SegmentsStats should not be null", stats);  
    }
     */  
            assertNotNull("Segment name should not be null", seg.getName());  
}
 * - segments() returns correct docCount, sizeInBytes, generation ordering
            );
        assertTrue("Segment count should be > 0 after second refresh", segmentsStats.getCount() > 0);
     */
        // After flush: segments should be searchable and committed  
        }
 * this file be licensed under the Apache-2.0 license or a
            assertTrue("docCount should be > 0", seg.docCount > 0);  
    public void testSegmentsStatsWithoutFileSizes() {
     * Tests that overall node stats (without any index-level filter) returns valid segment stats
        flushIndex(indexName);
        String indexName = "test-segstats-filesizes";
        refreshIndex(indexName);
        indexDocs(indexName, 10, 0);  
            assertEquals("delDocCount should be 0", 0, seg.delDocCount);
            Segment seg = segmentsBeforeFlush.get(i);
                    + " should be <= gen["  
        Map<String, Long> fileSizes = stats.getFileSizes();
        indexDocs(indexName, 10, 20);
            }  
        segmentsStats = dataNodeStats.getIndices().getSegments();  
            assertTrue("Segment should be searchable after flush", seg.search);
        for (NodeStats ns : nodesStats.getNodes()) {  
    }
        createCompositeIndex(indexName);
        refreshIndex(indexName);  
        indexDocs(indexName, 10, 0);
 */  
        refreshIndex(indexName);
        indexDocs(indexName, 5, 0);
 * compatible open source license.
                    + i
        assertNotNull("SegmentsStats should not be null", stats);  
        SegmentsStats stats = getSegmentsStats(indexName, true);
import org.opensearch.test.OpenSearchIntegTestCase;  
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
            .get();  
        for (NodeStats ns : nodesStats.getNodes()) {  
        }
        indexDocs(indexName, 10, 0);  
                "Segments should be sorted by generation: gen["
        String indexName = "test-seg-committed-searchable";  
import org.opensearch.action.admin.indices.segments.ShardSegments;
        IndicesSegmentResponse response = client().admin().indices().prepareSegments(indexName).get();  
        indexDocs(indexName, 5, 0);  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
    public void testCommittedStateTransitionsAcrossFlushes() {
        refreshIndex(indexName);
    }
        docsStats = dataNodeStats.getIndices().getDocs();  
            assertTrue("Segments should be searchable after refresh", seg.search);  
    private List<Segment> getSegmentsFromApi(String indexName) {
        List<Segment> segmentsAfterSecondRefresh = getSegmentsFromApi(indexName);
        flushIndex(indexName);
        String indexName = "test-seg-doccount-size";
        assertTrue("Should have shard segments", shardSegments.length > 0);
        refreshIndex(indexName);
        client().admin().indices().prepareRefresh(indexName).get();
     * Tests that after refresh (no flush), segments are searchable but NOT committed.
        // Index + refresh + flush
        flushIndex(indexName);
        List<Segment> segments = getSegmentsFromApi(indexName);  
        for (Segment seg : afterSecondRefresh) {
        // Index more + refresh (no flush)  
    }  
        // Verify data is still accessible after second flush by checking segments
        createCompositeIndex(indexName);
        IndexSegments indexSegments = response.getIndices().get(indexName);
            assertFalse("Segment should NOT be committed before flush", seg.committed);  
        IndicesStatsResponse statsResponse = client().admin()  
    /**
        refreshIndex(indexName);
     * Tests that segmentsStats returns correct segment count matching the segments API.
        indexDocs(indexName, 10, 10);
    /**  
    }
    }
            if (ns.getIndices() != null) {
        flushIndex(indexName);  
        assertEquals("Total docs across segments should equal indexed docs", 10, totalDocs);
        }  
        ShardStats shardStats = statsResponse.getIndex(indexName).getShards()[0];
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        List<Segment> segmentsBeforeFlush = getSegmentsFromApi(indexName);  
        flushIndex(indexName);  
    public void testSegmentsCommittedAndSearchableState() {
     * Tests that segments report correct docCount and sizeInBytes.
    }  
public class CompositeSegmentsStatsIT extends AbstractCompositeEngineIT {
        return null;  
        assertFalse("Should have segments after first flush", segmentsAfterFirstFlush.isEmpty());
    }
import org.opensearch.action.admin.indices.stats.ShardStats;
        String indexName = "test-segstats-count";
    private NodeStats getDataNodeStats() {
    /**  
     */
import org.opensearch.index.shard.DocsStats;
        assertTrue("File sizes should be empty when includeSegmentFileSizes=false", fileSizes == null || fileSizes.isEmpty());
        assertNotNull("File sizes map should not be null", fileSizes);  
import org.opensearch.index.engine.SegmentsStats;
        createCompositeIndex(indexName);
    public void testSegmentsSortedByGeneration() {
        }  
        List<Segment> segmentsAfterFirstFlush = getSegmentsFromApi(indexName);  
        flushIndex(indexName);  
        String indexName = "test-node-stats";  
        DocsStats docsStats = dataNodeStats.getIndices().getDocs();  
            .setSegments(true)
        refreshIndex(indexName);  
        // All segments should be searchable
    /**
        ensureGreen(indexName);
