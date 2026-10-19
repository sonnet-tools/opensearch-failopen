import org.opensearch.test.OpenSearchIntegTestCase;
            .putList("index.composite.secondary_data_formats", "lucene")
        refreshIndex(INDEX);
        client().admin().indices().prepareForceMerge(INDEX).setMaxNumSegments(1).get();
        refreshIndex(INDEX);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
        for (int i = 1; i <= 4; i++) {
    }
        assertDocsStats("after 1 update and 1 delete of 8", 7L, 2L);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        ShardSegments[] shardSegments = indexSegments.getShards().values().iterator().next().getShards();
 *
        for (int i = 1; i <= 6; i++) {
 * index.
        assertSegmentCountsAgreeWithDocsStats("after indexing 10 docs");
    }
    public void testCountsSurviveFlushAndForceMerge() {
        indexDoc("k1", "v1_updated", 101);
        IndexSegments indexSegments = response.getIndices().get(INDEX);
        assertEquals(context + ": summed segment deleted docs must equal docs.deleted", stats.getDeleted(), segmentDeleted);
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
        client().prepareDelete(INDEX, "k1").get();
    }
    }
            .setMapping("name", "type=keyword", "value", "type=integer")
        }
        flushIndex(INDEX);
        createManualRefreshIndex();
        assertEquals(context + ": docs.count", expectedCount, stats.getCount());
    private static final String INDEX = "dfae_docs_stats";
public class DataFormatAwareDocsStatsIT extends AbstractCompositeEngineIT {
            indexDoc("k" + i, "v" + i, i);
        DocsStats stats = docsStats();
            .build();
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        return shardSegments[0].getSegments();
import org.opensearch.common.settings.Settings;
            .put("index.pluggable.dataformat.enabled", true)
        assertDocsStats("after deleting 3 of 10", 7L, 3L);
    private DocsStats docsStats() {
        // Each update appends a row and hides its predecessor, so the two documents stay reachable no
        refreshIndex(INDEX);
        long rowsInCatalog = acquireAndGetSnapshot(INDEX).getNumDocs();
        }
        assertDocsStats("after flush", 7L, 2L);
 * Doc-count coverage for deletes and updates on a composite (parquet primary + lucene secondary)
        refreshIndex(INDEX);
        Settings settings = Settings.builder()
        // Update two documents. Each appends a row and hides its predecessor: 7 rows on disk, still
        assertDocsStats("after updating 2 of 5", 5L, 2L);
    public void testDeleteAcrossRefreshMovesDocsToDeleted() {
        indexDoc("anchor", "anchor", 0);
        assertDocsStats("after indexing 10 docs", 10L, 0L);
            stats.getCount() + stats.getDeleted()
        assertDocsStats("after indexing 5 docs", 5L, 0L);
    private void assertSegmentCountsAgreeWithDocsStats(String context) {
        IndicesSegmentResponse response = client().admin().indices().prepareSegments(INDEX).get();
        client().prepareIndex(INDEX).setId(id).setSource("name", name, "value", value).get();
    public void testDeleteWithinRefreshWindowMovesDocsToDeleted() {
package org.opensearch.composite;
            .put("index.refresh_interval", -1)
        // by id rather than by search: this engine rejects the Lucene search path.
        assertDocsStats("after deleting 2 of 6 before any refresh", 4L, 2L);
        }
        assertSegmentCountsAgreeWithDocsStats("after updating 2 of 5");
        refreshIndex(INDEX);
        long segmentDocs = 0;
            segmentDeleted += segment.getDeletedDocs();
        assertSegmentCountsAgreeWithDocsStats("after deleting 2 of 6 before any refresh");
 * The OpenSearch Contributors require contributions made to
        for (int i = 1; i <= 5; i++) {
    }
    private void createManualRefreshIndex() {
        assertEquals(context + ": docs.deleted", expectedDeleted, stats.getDeleted());
     * Composite index with a Lucene secondary (needed for {@code _id} resolution, and the only format
        DocsStats stats = docsStats();
            context + ": docs.count + docs.deleted must account for every row the catalog holds",
            // Enabling the pluggable data format switches append-only on by default, which would
        for (int i = 1; i <= 10; i++) {
        refreshIndex(INDEX);
 */
    public void testUpdateKeepsCountAndRaisesDeleted() {
        assertLiveCountAndAccountedRows("after deleting the updated doc", 1L);
        client().admin()
            indexDoc("k1", "v" + i, i);
    }
import java.util.List;
        assertSegmentCountsAgreeWithDocsStats("after force merge");
        refreshIndex(INDEX);
        }
 *
        createManualRefreshIndex();
        assertTrue("force merge must not invent deleted docs, but reported " + afterMerge.getDeleted(), afterMerge.getDeleted() <= 2L);
        assertDocsStats("after indexing 2 docs", 2L, 0L);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }
            .setSettings(settings)
        refreshIndex(INDEX);
            .prepareCreate(INDEX)
     * test chose rather than wherever a background refresh landed.
 */
        indexDoc("k1", "v1_updated", 101);
        refreshIndex(INDEX);
        ensureGreen(INDEX);
import org.opensearch.cluster.metadata.IndexMetadata;
import java.io.IOException;
import org.opensearch.index.shard.DocsStats;
        }
}
    private void assertDocsStats(String context, long expectedCount, long expectedDeleted) {
    }
    public void testRepeatedUpdatesThenDelete() throws IOException {
        // Every copy of k1 is hidden now; only the anchor stays reachable.
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), false)
    private void assertLiveCountAndAccountedRows(String context, long expectedCount) throws IOException {
        // The counted documents must be the ones a reader resolves to, and to their new content. Read
            // reject both a custom _id and a delete. It is a final setting, so it must be set here.
import org.opensearch.action.admin.indices.segments.IndexSegments;
        assertNotNull("index segments must exist", indexSegments);
        // matter how many copies of k1 accumulate — and no matter whether a merge reclaims some of them.
import org.opensearch.index.engine.Segment;
    }
        assertTrue("must have shard segments", shardSegments.length > 0);
        assertEquals("v1_updated", client().prepareGet(INDEX, "k1").setRealtime(false).get().getSourceAsMap().get("name"));
        // 5 reachable documents.
/**
        IndicesStatsResponse response = client().admin().indices().prepareStats(INDEX).clear().setDocs(true).get();
    private void indexDoc(String id, String name, int value) {
        createManualRefreshIndex();
        createManualRefreshIndex();
 * compatible open source license.
        // No refresh yet — these deletes hit rows the active writer has not flushed.
/*
        assertEquals(
        assertEquals(context + ": summed segment docs must equal docs.count", stats.getCount(), segmentDocs);
    private List<Segment> segments() {
        return response.getIndex(INDEX).getShards()[0].getStats().getDocs();
        client().prepareDelete(INDEX, "k2").get();
            assertTrue("k" + i + " must still be reachable", client().prepareGet(INDEX, "k" + i).setRealtime(false).get().isExists());
        for (Segment segment : segments()) {
    }
    }
        DocsStats afterMerge = docsStats();
        client().prepareDelete(INDEX, "k2").get();
        assertTrue("the deleted doc's rows must be reported as deleted, not as live", docsStats().getDeleted() >= 1L);
        DocsStats stats = docsStats();
        long segmentDeleted = 0;
        assertEquals("v4", client().prepareGet(INDEX, "k1").setRealtime(false).get().getSourceAsMap().get("name"));
            indexDoc("k" + i, "v" + i, i);
    }
        );
            rowsInCatalog,
            indexDoc("k" + i, "v" + i, i);
        assertEquals("force merge must not change the reachable count", 7L, afterMerge.getCount());
        for (int i = 1; i <= 8; i++) {
        assertSegmentCountsAgreeWithDocsStats("after deleting the updated doc");
        }
        for (int i = 1; i <= 5; i++) {
            .put("index.pluggable.dataformat", "composite")
        assertSegmentCountsAgreeWithDocsStats("after deleting 3 of 10");
     * that tracks liveness) and auto-refresh off, so every measurement below happens at a point the
        indexDoc("k1", "v0", 0);
import org.opensearch.action.admin.indices.segments.ShardSegments;
        createManualRefreshIndex();
        client().prepareDelete(INDEX, "k3").get();
        }
        assertFalse("k1 must no longer resolve", client().prepareGet(INDEX, "k1").setRealtime(false).get().isExists());
 * SPDX-License-Identifier: Apache-2.0
        client().prepareDelete(INDEX, "k2").get();
        client().prepareDelete(INDEX, "k1").get();
        indexDoc("k2", "v2_updated", 102);
            refreshIndex(INDEX);
            segmentDocs += segment.getNumDocs();
        assertEquals(context + ": docs.count", expectedCount, stats.getCount());
            indexDoc("k" + i, "v" + i, i);
            .indices()
            .get();
    /**
 * this file be licensed under the Apache-2.0 license or a
        client().prepareDelete(INDEX, "k1").get();
            .put("index.composite.primary_data_format", "parquet")
     */
            assertLiveCountAndAccountedRows("after update " + i, 2L);
