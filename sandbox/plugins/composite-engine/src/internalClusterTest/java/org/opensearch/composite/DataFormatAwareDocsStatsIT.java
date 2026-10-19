        assertEquals("v1_updated", client().prepareGet(INDEX, "k1").setRealtime(false).get().getSourceAsMap().get("name"));
    private void assertSegmentCountsAgreeWithDocsStats(String context) {
 *
    }  
            assertLiveCountAndAccountedRows("after update " + i, 2L);  
            .put("index.pluggable.dataformat", "composite")
    }  
        assertDocsStats("after updating 2 of 5", 5L, 2L);  
        assertTrue("must have shard segments", shardSegments.length > 0);
        // Update two documents. Each appends a row and hides its predecessor: 7 rows on disk, still  
        for (int i = 1; i <= 5; i++) {
        assertEquals(context + ": summed segment deleted docs must equal docs.deleted", stats.getDeleted(), segmentDeleted);
        assertDocsStats("after flush", 7L, 2L);  
     * Composite index with a Lucene secondary (needed for {@code _id} resolution, and the only format
 * Doc-count coverage for deletes and updates on a composite (parquet primary + lucene secondary)  
        client().prepareDelete(INDEX, "k1").get();
/*  
        refreshIndex(INDEX);
        client().prepareDelete(INDEX, "k3").get();
    private void indexDoc(String id, String name, int value) {  
        flushIndex(INDEX);
        refreshIndex(INDEX);
    public void testCountsSurviveFlushAndForceMerge() {
        assertFalse("k1 must no longer resolve", client().prepareGet(INDEX, "k1").setRealtime(false).get().isExists());  
        assertEquals("v4", client().prepareGet(INDEX, "k1").setRealtime(false).get().getSourceAsMap().get("name"));
        // 5 reachable documents.
import org.opensearch.index.engine.Segment;
        );
        // Every copy of k1 is hidden now; only the anchor stays reachable.  
            indexDoc("k" + i, "v" + i, i);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
        assertTrue("the deleted doc's rows must be reported as deleted, not as live", docsStats().getDeleted() >= 1L);
     */
        indexDoc("k1", "v1_updated", 101);  
        createManualRefreshIndex();
        assertDocsStats("after indexing 10 docs", 10L, 0L);  
    private void createManualRefreshIndex() {
            segmentDocs += segment.getNumDocs();  
        for (Segment segment : segments()) {
            // reject both a custom _id and a delete. It is a final setting, so it must be set here.
        assertSegmentCountsAgreeWithDocsStats("after updating 2 of 5");
        assertDocsStats("after deleting 2 of 6 before any refresh", 4L, 2L);
        assertEquals(context + ": docs.deleted", expectedDeleted, stats.getDeleted());  
    }
     * test chose rather than wherever a background refresh landed.  
        }
 */  
            .put("index.refresh_interval", -1)
    /**  
    }
 * index.
        assertSegmentCountsAgreeWithDocsStats("after deleting 2 of 6 before any refresh");  
            .indices()
            .putList("index.composite.secondary_data_formats", "lucene")  
        refreshIndex(INDEX);
        assertSegmentCountsAgreeWithDocsStats("after indexing 10 docs");
            .put("index.pluggable.dataformat.enabled", true)  
        }
            // Enabling the pluggable data format switches append-only on by default, which would
            .setSettings(settings)  
        assertDocsStats("after deleting 3 of 10", 7L, 3L);
        refreshIndex(INDEX);
        DocsStats stats = docsStats();  
        }  
package org.opensearch.composite;
    private static final String INDEX = "dfae_docs_stats";
import org.opensearch.index.shard.DocsStats;
 * compatible open source license.
            indexDoc("k1", "v" + i, i);
        refreshIndex(INDEX);  
        createManualRefreshIndex();
        assertDocsStats("after 1 update and 1 delete of 8", 7L, 2L);  
import java.util.List;  
        long rowsInCatalog = acquireAndGetSnapshot(INDEX).getNumDocs();  
        IndexSegments indexSegments = response.getIndices().get(INDEX);
        // Each update appends a row and hides its predecessor, so the two documents stay reachable no
        assertSegmentCountsAgreeWithDocsStats("after deleting 3 of 10");  
    }
    private void assertDocsStats(String context, long expectedCount, long expectedDeleted) {  
        indexDoc("anchor", "anchor", 0);  
    public void testDeleteWithinRefreshWindowMovesDocsToDeleted() {  
    public void testUpdateKeepsCountAndRaisesDeleted() {  
            context + ": docs.count + docs.deleted must account for every row the catalog holds",
        assertSegmentCountsAgreeWithDocsStats("after force merge");  
        }
    private DocsStats docsStats() {
        ShardSegments[] shardSegments = indexSegments.getShards().values().iterator().next().getShards();
        DocsStats stats = docsStats();
        ensureGreen(INDEX);  
        assertEquals(context + ": summed segment docs must equal docs.count", stats.getCount(), segmentDocs);
    }
        assertEquals(context + ": docs.count", expectedCount, stats.getCount());
        // by id rather than by search: this engine rejects the Lucene search path.
        long segmentDocs = 0;  
    }
        }
            .put("index.composite.primary_data_format", "parquet")
        // The counted documents must be the ones a reader resolves to, and to their new content. Read  
 * this file be licensed under the Apache-2.0 license or a
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), false)  
import org.opensearch.test.OpenSearchIntegTestCase;  
        client().prepareDelete(INDEX, "k1").get();
        refreshIndex(INDEX);  
import java.io.IOException;
 *
            indexDoc("k" + i, "v" + i, i);
        client().admin().indices().prepareForceMerge(INDEX).setMaxNumSegments(1).get();
        assertTrue("force merge must not invent deleted docs, but reported " + afterMerge.getDeleted(), afterMerge.getDeleted() <= 2L);
        }
        indexDoc("k1", "v0", 0);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        for (int i = 1; i <= 4; i++) {  
        client().prepareDelete(INDEX, "k2").get();
 * The OpenSearch Contributors require contributions made to  
        long segmentDeleted = 0;
        for (int i = 1; i <= 5; i++) {  
    private void assertLiveCountAndAccountedRows(String context, long expectedCount) throws IOException {  
            indexDoc("k" + i, "v" + i, i);
    }
        // matter how many copies of k1 accumulate — and no matter whether a merge reclaims some of them.
        indexDoc("k1", "v1_updated", 101);
        createManualRefreshIndex();  
import org.opensearch.cluster.metadata.IndexMetadata;
        assertEquals(
import org.opensearch.common.settings.Settings;  
        client().prepareDelete(INDEX, "k2").get();
        DocsStats stats = docsStats();
public class DataFormatAwareDocsStatsIT extends AbstractCompositeEngineIT {
            assertTrue("k" + i + " must still be reachable", client().prepareGet(INDEX, "k" + i).setRealtime(false).get().isExists());  
            .get();
        createManualRefreshIndex();  
            .build();
        assertLiveCountAndAccountedRows("after deleting the updated doc", 1L);
        return response.getIndex(INDEX).getShards()[0].getStats().getDocs();  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertEquals("force merge must not change the reachable count", 7L, afterMerge.getCount());
        assertEquals(context + ": docs.count", expectedCount, stats.getCount());
        return shardSegments[0].getSegments();  
import org.opensearch.action.admin.indices.segments.ShardSegments;  
        indexDoc("k2", "v2_updated", 102);  
            refreshIndex(INDEX);
    }
        createManualRefreshIndex();
 * SPDX-License-Identifier: Apache-2.0
        client().prepareDelete(INDEX, "k1").get();  
        for (int i = 1; i <= 6; i++) {  
     * that tracks liveness) and auto-refresh off, so every measurement below happens at a point the
        }
import org.opensearch.action.admin.indices.segments.IndexSegments;
        client().admin()  
        assertNotNull("index segments must exist", indexSegments);  
    public void testDeleteAcrossRefreshMovesDocsToDeleted() {
        DocsStats afterMerge = docsStats();  
    }
            rowsInCatalog,  
        // No refresh yet — these deletes hit rows the active writer has not flushed.  
        client().prepareDelete(INDEX, "k2").get();
    }
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
        refreshIndex(INDEX);
    public void testRepeatedUpdatesThenDelete() throws IOException {
 */  
        for (int i = 1; i <= 8; i++) {
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        IndicesSegmentResponse response = client().admin().indices().prepareSegments(INDEX).get();
            .prepareCreate(INDEX)
        for (int i = 1; i <= 10; i++) {
        assertDocsStats("after indexing 5 docs", 5L, 0L);
        refreshIndex(INDEX);  
        assertSegmentCountsAgreeWithDocsStats("after deleting the updated doc");
        refreshIndex(INDEX);
        IndicesStatsResponse response = client().admin().indices().prepareStats(INDEX).clear().setDocs(true).get();
    }  
            .setMapping("name", "type=keyword", "value", "type=integer")
/**
        Settings settings = Settings.builder()  
        assertDocsStats("after indexing 2 docs", 2L, 0L);
            indexDoc("k" + i, "v" + i, i);  
    private List<Segment> segments() {  
            segmentDeleted += segment.getDeletedDocs();
            stats.getCount() + stats.getDeleted()
}
        client().prepareIndex(INDEX).setId(id).setSource("name", name, "value", value).get();
