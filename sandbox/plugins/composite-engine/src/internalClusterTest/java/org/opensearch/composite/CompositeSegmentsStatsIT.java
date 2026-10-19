        ShardSegments[] shardSegments = indexSegments.getShards().values().iterator().next().getShards();
 * Validates:
            .setSegments(true)
    }
                    + "]="
                segments.get(i).getGeneration() >= segments.get(i - 1).getGeneration()
        refreshIndex(indexName);
        indexDocs(indexName, 5, 5);
                    + "]="
                    + segments.get(i - 1).getGeneration()
        flushIndex(indexName);
        assertFalse("Should have segments after second flush", segmentsAfterSecondFlush.isEmpty());
        ShardStats shardStats = statsResponse.getIndex(indexName).getShards()[0];
        assertTrue("Should have multiple segments", segments.size() >= 2);
        refreshIndex(indexName);
 * The OpenSearch Contributors require contributions made to
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 1)
        List<Segment> segments = getSegmentsFromApi(indexName);
        ensureGreen(indexName);
        dataNodeStats = getDataNodeStats();
            if (ns.getIndices() != null && ns.getIndices().getDocs().getCount() > 0) {
        flushIndex(indexName);
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
     * Tests that overall node stats (without any index-level filter) returns valid segment stats
        assertNotNull("Index segments should exist", indexSegments);
        assertTrue("Segment count should be > 0 after second refresh", segmentsStats.getCount() > 0);
            assertNotNull("Segment name should not be null", seg.getName());
        createCompositeIndex(indexName);
package org.opensearch.composite;
        Map<String, Long> fileSizes = stats.getFileSizes();
        fail("No data node found with indices stats");
 */
import java.util.List;
import org.opensearch.test.OpenSearchIntegTestCase;
        IndicesSegmentResponse response = client().admin().indices().prepareSegments(indexName).get();
    private List<Segment> getSegmentsFromApi(String indexName) {
        // Fallback to first node with indices stats
        for (Segment seg : segmentsAfterFlush) {
     * Tests that segments report correct docCount and sizeInBytes.
        }
    @Override
 * - segmentsStats() returns correct segment count and file sizes
        String indexName = "test-node-stats";
        assertNotNull("Segments stats from node stats should not be null", segmentsStats);
     * Tests committed state transitions: new docs after flush are not committed until next flush.
        // Index more + refresh (no flush)
    }
     * Tests that segments are sorted by generation when multiple refreshes create multiple segments.
        // Index + refresh + flush
        assertNotNull("SegmentsStats should not be null", stats);
        long totalSize = 0;
        // Before flush: segments should be searchable but NOT committed
            }
        }
        createCompositeIndex(indexName);
        assertEquals("Total docs across segments should equal indexed docs", 10, totalDocs);
    /**
            .get();
            );
/**
        flushIndex(indexName);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.engine.Segment;
        ensureGreen(indexName);
            assertTrue("Segments should be searchable after refresh", seg.search);
    public void testSegmentsStatsCount() {
    /**
        }
                    + i
        assertFalse("Should have segments", segments.isEmpty());
                    + " should be <= gen["
        List<Segment> segmentsAfterFirstFlush = getSegmentsFromApi(indexName);
            assertEquals("delDocCount should be 0", 0, seg.delDocCount);
        flushIndex(indexName);
        // Flush again
    /**
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
 * Integration tests for segments and segments stats APIs on DataFormatAwareEngine.
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        indexDocs(indexName, 10, 0);
        indexDocs(indexName, 5, 0);
        assertNotNull("SegmentsStats should not be null", stats);
    public void testCommittedStateTransitionsAcrossFlushes() {
        assertTrue("Segment count should be > 0", stats.getCount() > 0);
        for (NodeStats ns : nodesStats.getNodes()) {
        indexDocs(indexName, 10, 20);
 * this file be licensed under the Apache-2.0 license or a
        indexDocs(indexName, 10, 0);
        assertEquals("Segment count from stats should match segments API", segments.size(), stats.getCount());
        NodesStatsResponse nodesStats = client().admin().cluster().prepareNodesStats().all().get();
/*
        SegmentsStats stats = getSegmentsStats(indexName, false);
        refreshIndex(indexName);
        SegmentsStats stats = getSegmentsStats(indexName, true);
    public void testSegmentsStatsWithoutFileSizes() {
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).build();
    }
        // Index first batch and verify
    /**
    }
            .setIncludeSegmentFileSizes(includeFileSizes)
        assertEquals("Doc count should update after third batch and flush", 30L, docsStats.getCount());
    }
    protected Settings nodeSettings(int nodeOrdinal) {
                "Segments should be sorted by generation: gen["
     */
        Map<String, Long> fileSizes = stats.getFileSizes();
        createCompositeIndex(indexName);
        }
        return shardStats.getStats().getSegments();
}
        String indexName = "test-seg-committed-searchable";
        // Create multiple segments via multiple refresh cycles
        // Index another batch, flush, and verify again
 * - segments() returns correct docCount, sizeInBytes, generation ordering
            assertTrue("Segment should be searchable after flush", seg.search);
        indexDocs(indexName, 5, 5);
        assertFalse("Should have segments after first flush", segmentsAfterFirstFlush.isEmpty());
        assertFalse("Should have segments after flush", segmentsAfterFlush.isEmpty());
        int totalDocs = 0;
        refreshIndex(indexName);
            assertTrue(
    }
        IndicesStatsResponse statsResponse = client().admin()
        indexDocs(indexName, 10, 0);
    }
    public void testSegmentsStatsWithFileSizes() {
        for (Segment seg : segments) {
        for (Segment seg : afterSecondRefresh) {
        assertNotNull("SegmentsStats should not be null", stats);
            Segment seg = segmentsBeforeFlush.get(i);
    }
    public void testSegmentsDocCountAndSize() {
        List<Segment> segmentsBeforeFlush = getSegmentsFromApi(indexName);
        List<Segment> segments = getSegmentsFromApi(indexName);
        String indexName = "test-segstats-filesizes";
        List<Segment> segmentsAfterFlush = getSegmentsFromApi(indexName);
     */
            totalDocs += seg.docCount;
        // Verify we can access segments after second refresh
 */
import org.opensearch.common.settings.Settings;
 *
        indexDocs(indexName, 5, 0);
    }
     * and that stats are updated correctly as documents are indexed and refreshed.
    public void testNodeStatsIncludesSegmentStats() {
        assertEquals("Doc count should update after second refresh", 20L, docsStats.getCount());
        indexDocs(indexName, 5, 0);
        // Index more docs and refresh — verify counts update
        assertTrue("Should have segments", afterSecondRefresh.size() >= 1);
        assertEquals("Node-level doc count should match indexed docs", 10L, docsStats.getCount());
        assertTrue("File sizes should be empty when includeSegmentFileSizes=false", fileSizes == null || fileSizes.isEmpty());
            if (ns.getIndices() != null) {
        SegmentsStats stats = getSegmentsStats(indexName, false);
        createCompositeIndex(indexName);
            totalSize += seg.sizeInBytes;
        // Ensure all operations are complete before checking segments
            }
        String indexName = "test-segstats-no-filesizes";
    }
                    + (i - 1)
        for (NodeStats ns : nodesStats.getNodes()) {
        refreshIndex(indexName);
public class CompositeSegmentsStatsIT extends AbstractCompositeEngineIT {
        String indexName = "test-seg-commit-transitions";
        assertFalse("Should have segments after refresh", segmentsBeforeFlush.isEmpty());
            assertTrue("docCount should be > 0", seg.docCount > 0);
    // --- Helper methods ---
            assertTrue("sizeInBytes should be > 0", seg.sizeInBytes > 0);
import org.opensearch.action.admin.indices.stats.ShardStats;
        createCompositeIndex(indexName);
        List<Segment> afterSecondRefresh = getSegmentsFromApi(indexName);
        docsStats = dataNodeStats.getIndices().getDocs();
     * After flush, segments become committed.
        refreshIndex(indexName);
     * Tests that segmentsStats returns correct segment count matching the segments API.
        }
        refreshIndex(indexName);
 * compatible open source license.
                return ns;
     */
    }
        // All segments should be searchable
import org.opensearch.action.admin.indices.segments.IndexSegments;
    private NodeStats getDataNodeStats() {
        String indexName = "test-seg-doccount-size";
        indexDocs(indexName, 10, 0);
    public void testSegmentsSortedByGeneration() {
            assertTrue("Segment should be searchable before flush", seg.search);
        String indexName = "test-segstats-count";
        DocsStats docsStats = dataNodeStats.getIndices().getDocs();
        flushIndex(indexName);
        }
        return null;
        List<Segment> segmentsAfterSecondRefresh = getSegmentsFromApi(indexName);
        List<Segment> segments = getSegmentsFromApi(indexName);
     */
        String indexName = "test-seg-generation-order";
     */
        }
        refreshIndex(indexName);
        flushIndex(indexName);
        createCompositeIndex(indexName);
        SegmentsStats segmentsStats = dataNodeStats.getIndices().getSegments();
     * Tests that after refresh (no flush), segments are searchable but NOT committed.
import org.opensearch.index.shard.DocsStats;
        assertNotNull("Docs stats from node stats should not be null", docsStats);
        docsStats = dataNodeStats.getIndices().getDocs();
        for (int i = 1; i < segments.size(); i++) {
        List<Segment> segmentsAfterSecondFlush = getSegmentsFromApi(indexName);
     */
        assertTrue("Should have segments after second refresh", segmentsAfterSecondRefresh.size() >= 1);
                return ns;
        refreshIndex(indexName);
        client().admin().indices().prepareRefresh(indexName).get();
        // Verify data is accessible after first flush by checking segments
     * Note: Composite engines may handle committed state differently than pure Lucene engines.
                    + segments.get(i).getGeneration(),
    /**
        for (int i = 0; i < segmentsBeforeFlush.size(); i++) {
     * Tests that segmentsStats includes file sizes when requested.
        // After flush: segments should be searchable and committed
        createCompositeIndex(indexName);
        assertTrue("Total size should be > 0", totalSize > 0);
            assertTrue("Segment should be committed after flush", seg.committed);
    /**
import org.opensearch.action.admin.indices.segments.ShardSegments;
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        createCompositeIndex(indexName);
            .prepareStats(indexName)
     * Tests that segmentsStats without file sizes does not populate the file sizes map.
        assertNotNull("File sizes map should not be null", fileSizes);
        refreshIndex(indexName);
 * - segments() returns correct committed/searchable state before and after flush
        indexDocs(indexName, 5, 0);
        // Verify data is still accessible after second flush by checking segments
            assertTrue("File size for '" + entry.getKey() + "' should be >= 0", entry.getValue() >= 0);
        dataNodeStats = getDataNodeStats();
        assertFalse("File sizes should not be empty when includeSegmentFileSizes=true", fileSizes.isEmpty());
        refreshIndex(indexName);
        assertTrue("Node-level segment count should be > 0", segmentsStats.getCount() > 0);
    }
        indexDocs(indexName, 10, 10);
        for (Map.Entry<String, Long> entry : fileSizes.entrySet()) {
        }
    /**
        ensureGreen(indexName);
            .indices()
        NodeStats dataNodeStats = getDataNodeStats();
    public void testSegmentsCommittedAndSearchableState() {
            assertFalse("Segment should NOT be committed before flush", seg.committed);
        IndexSegments indexSegments = response.getIndices().get(indexName);
     */
import java.util.Map;
        assertTrue("Should have shard segments", shardSegments.length > 0);
        return shardSegments[0].getSegments();
 *
    private SegmentsStats getSegmentsStats(String indexName, boolean includeFileSizes) {
        refreshIndex(indexName);
     */
            .clear()
        assertNotNull("Node indices stats should not be null", dataNodeStats.getIndices());
import org.opensearch.index.engine.SegmentsStats;
        segmentsStats = dataNodeStats.getIndices().getSegments();
    /**
