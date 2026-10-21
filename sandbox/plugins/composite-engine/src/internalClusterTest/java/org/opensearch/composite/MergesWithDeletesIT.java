            assertTrue("survivor must resolve after concurrent churn + merge: " + id, exists(id));
    private void createIndex(boolean sorted) {
                    }
                long expected = 0;
        assertCrossFormatRowAligned(survivors);
        }
import org.opensearch.action.index.IndexResponse;
    /** Merged parquet rows must be sorted by value DESC. */
    private void assertCrossFormatRowAligned(int expectedRows) throws IOException {
        client().admin()
                assertEquals(DocWriteResponse.Result.DELETED, deleteDoc(id).getResult());
        assertEquals("only generation B rows remain physically", 2L, parquetRows());
            assertEquals(RestStatus.CREATED, indexDoc("d" + i, i).status());
            }
            .put("index.pluggable.dataformat", "composite")
            .setMapping("name", "type=keyword", "value", "type=integer")
 * End-to-end merges-with-deletes coverage for the composite (parquet primary + lucene secondary)
        Path luceneDir = luceneIndexDir();
        assertTrue("merged lucene dir must exist", Files.exists(luceneDir));
                if (rowId == null) {
                String id = allIds.get(idx);
     * a reordering merge with deletes).
            final int threadId = t;
        assertParquetFileRowCountsMatchCatalog();
    }
        }
            }));
     * Heavy same-id update churn across segments (each update = internal delete-old + index-new),
                assertEquals(DocWriteResponse.Result.DELETED, deleteDoc(id).getResult());
    }
                rows.add(row);
        }
    // ══════════════════════════════════════════════════════════════════════
    @SuppressForbidden(reason = "enable pluggable dataformat merge for integration testing")
            f.get(60, java.util.concurrent.TimeUnit.SECONDS);
            refresh();
        Path dir = parquetDir();
        for (int i = 6; i < 12; i++) {
            .indices()
    /**
import java.nio.file.Files;
     * a subsequent generation) is physically removed by a following merge: once its {@code .liv} is in
import java.io.IOException;
                continue;
        List<String> allIds = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            )
import org.opensearch.common.xcontent.json.JsonXContent;
                String id = "seg" + s + "_" + i;
            }
                continue;
    // Verification helpers
    }
        assertTrue(exists("d100"));
        assertParquetFileRowCountsMatchCatalog();
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        }
            ingest.add(pool.submit(() -> {
            // distinct values so sort order is unambiguous
    }
            for (int i = 1; i < perSegment; i++) {
     * physically drop the deletes, and keep parquet↔lucene row-aligned (RowIdMapping correct through
        }
        for (String id : ids) {
        assertCrossFormatRowAligned(keys);
        }
            long fileRows = 0;
                SortedNumericDocValues rowId = ctx.reader().getSortedNumericDocValues(DocumentInput.ROW_ID_FIELD);
    /**
 * compatible open source license.
        createIndex();
     * retained forever.
     */
    // ══════════════════════════════════════════════════════════════════════
        pool.shutdown();
import org.opensearch.cluster.metadata.IndexMetadata;
            for (int k = 0; k < keys; k++) {
    private static final String MERGE_ENABLED_PROPERTY = "opensearch.pluggable.dataformat.merge.enabled";
     * Deleting every document of a generation, then merging, drops that generation entirely while
        assertParquetFileRowCountsMatchCatalog();
                }
    // Index setup
            .setMapping("name", "type=keyword", "value", "type=integer")
        client().admin().indices().prepareRefresh(INDEX).get();
        // Phase 2: delete a disjoint subset of each thread's (now-committed) docs, asserting each delete
        }
        ensureGreen(INDEX);
            for (LeafReaderContext ctx : reader.leaves()) {
            GetResponse g = client().prepareGet(INDEX, "k" + k).setRealtime(false).get();
                deletedIds.add(id);
    }
                    continue;
                IndexResponse resp = indexDoc("k" + k, r);
 * the merged lucene segment, not just that doc counts look right.
        for (int s = 0; s < segments; s++) {
    private boolean exists(String id) {
            .put("index.composite.primary_data_format", "parquet")
    private long parquetRows() throws IOException {
            deleted.add("d" + i);
    }
                ParquetFileMetadata md = RustBridge.getFileMetadata(fp.toString());
import org.apache.lucene.index.SortedNumericDocValues;
    }
            }
        assertTrue(pool.awaitTermination(30, java.util.concurrent.TimeUnit.SECONDS));
        }
        return client().admin().indices().prepareForceMerge(INDEX).setMaxNumSegments(1).setFlush(true).get();
import java.util.Set;
    }
            assertEquals(RestStatus.CREATED, indexDoc(id, i).status());
    private IndexShard primary() {
import org.apache.lucene.index.DirectoryReader;
        assertCrossFormatRowAligned(2);
 */
    private void createIndex() {
            assertEquals("resolution after sorted merge: " + id, deleted.contains(id) == false, exists(id));
                for (int doc = 0; doc < ctx.reader().maxDoc(); doc++) {
        int survivors = total - deleted.size();
                assertEquals(DocWriteResponse.Result.UPDATED, resp.getResult());
        super.tearDown();
                assertEquals(RestStatus.CREATED, indexDoc(id, s * perSegment + i).status());
 */
            for (Object o : parser.list()) {
    }
        for (int t = 0; t < threads; t++) {
        for (String id : allIds) {
        long actualParquetRows = parquetRows();
package org.opensearch.composite;
        assertEquals(DocWriteResponse.Result.DELETED, deleteDoc("a0").getResult());
        for (int i = 0; i < 6; i++) {
                for (int i = 0; i < docsPerThread; i++) {
        assertFalse(exists("a1"));
                fileRows += md.numRows();
        }
            String id = "s" + s + "_d0";
    // Scenario 2 — ~12% deletes spread across many segments, then force-merge to one
            .get();
     * Concurrency in two phases: multiple threads first ingest disjoint id ranges in parallel; after a
        return client().prepareIndex(INDEX).setId(id).setSource("name", "doc_" + id, "value", value).get();
        refresh();
     */
    // Scenario 1 — delete BEFORE the merge: row must be physically gone from merged parquet
                    int curr = ((Number) rows.get(i).get("value")).intValue();
/*
            for (String file : wfs.files()) {
    // Scenario 5 — sorted index: delete then merge preserves sort AND alignment
            .get();
    @SuppressForbidden(reason = "JSON parsing for test verification of parquet output")
        for (int idx = 0; idx < allIds.size(); idx++) {
    // Scenario 3 — heavy update churn then merge resolves to exactly one latest row per id
 * SPDX-License-Identifier: Apache-2.0
            assertEquals("lucene numDocs must equal parquet rows (row-aligned)", expectedRows, reader.numDocs());
     * single segment. Asserts the exact survivor count physically, every survivor/deleted id, and
    // ══════════════════════════════════════════════════════════════════════
    // ══════════════════════════════════════════════════════════════════════
        for (int s = 0; s < segments; s++) {
            .put("index.refresh_interval", -1);
        assertEquals(4L, parquetRows());
        refresh();
    }
        // Authoritative final state: refresh, then a final force-merge so all deletes are reconciled.
            .indices()
        // Each key updated several times, interleaved with refreshes so copies land across generations.
        for (String id : survivorIds) {
    public void testPartialDeletesAcrossSegmentsThenForceMerge() throws Exception {
        int rounds = 5;
        refresh();
}
        super.setUp();
            assertEquals(DocWriteResponse.Result.CREATED, indexDoc("k" + k, 0).getResult());
            .putList("index.composite.secondary_data_formats", "lucene")
     */
            .put("index.pluggable.dataformat.enabled", true)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            }
    private IndexResponse indexDoc(String id, int value) {
        assertEquals(0, forceMergeToOne().getFailedShards());
    /** Manual-refresh composite index (lucene secondary for _id resolution), unsorted. */
/**
        int keys = 20;
        refresh();
        return acquireAndGetSnapshot(INDEX).getSearchableFiles("parquet").stream().mapToLong(WriterFileSet::numRows).sum();
    // Scenario 7 — concurrent multi-shard ingestion + deletion under merges
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        }
            settings.putList("index.sort.field", "value").putList("index.sort.order", "desc");
        refresh();
     * Physical parquet row count — the logical live-row truth. The inherited {@code getTotalRowCount}
                Path fp = dir.resolve(file);
     * sums numRows across <em>every</em> format in each segment (parquet + lucene), so on a composite
        refresh();
        indexDoc("a1", 1);
        createIndex();
import org.opensearch.index.engine.exec.Segment;
        assertTrue(exists("b0"));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        }
        List<String> ids = new ArrayList<>();
        Set<String> deleted = new HashSet<>();
            }
        indexDoc("d100", 100);
                    int prev = ((Number) rows.get(i - 1).get("value")).intValue();
    // ══════════════════════════════════════════════════════════════════════
import org.apache.lucene.index.LeafReaderContext;
import org.opensearch.parquet.bridge.ParquetFileMetadata;
import org.opensearch.parquet.bridge.RustBridge;
     */
            int base = t * docsPerThread;
     */
        assertEquals("survivor bookkeeping sanity", expectedSurvivors, survivorIds.size());
        assertTrue(exists("b1"));
    // ══════════════════════════════════════════════════════════════════════
                refresh();
        client().admin()
    // Scenario 6 — deleted doc that survives one merge is physically dropped on the NEXT merge
import org.opensearch.index.engine.dataformat.DocumentInput;
    }
                deleted.add(id);
        int expectedSurvivors = threads * (docsPerThread - deletesPerThread);
     * the next frozen snapshot, the merge drops the row. Proves deletes are eventually reclaimed, not
import org.opensearch.core.xcontent.XContentParser;
        java.util.concurrent.Future<?> merger = pool.submit(() -> {
    }
            assertEquals("latest value must win", rounds, ((Number) g.getSourceAsMap().get("value")).intValue());
        int survivors = total - deleted.size();
            }
        // Delete two docs and add a fresh segment so a second force-merge has something to merge.
            }
    private List<Map<String, Object>> parseRows(String json) throws IOException {
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
        // Generation A — will be fully deleted.
     */
        return getPrimaryShard(INDEX);
                }
        assertParquetFileRowCountsMatchCatalog();
        int threads = 4;
     * A doc deleted and refreshed <em>before</em> a force-merge is excluded from the frozen snapshot,
        indexDoc("b1", 3);
    }
    // ══════════════════════════════════════════════════════════════════════
            .putList("index.composite.secondary_data_formats", "lucene")
        assertEquals("deletes must be physically reclaimed by the next merge", 11L, parquetRows());
        assertCrossFormatRowAligned(survivors);
                int base = threadId * docsPerThread;
        // Generation B — survives.
            }
import java.util.List;
            assertEquals(RestStatus.CREATED, indexDoc("d" + i, i).status());
            assertFalse("deleted-before-merge doc must be physically gone: " + id, exists(id));
        return primary().shardPath().getDataPath().resolve("parquet");
        }
    // ══════════════════════════════════════════════════════════════════════
    }
            assertEquals(DocWriteResponse.Result.DELETED, deleteDoc(id).getResult());
    /**
 * The OpenSearch Contributors require contributions made to
import org.opensearch.action.get.GetResponse;
        int perSegment = 10;
            } else {
        assertEquals(0, forceMergeToOne().getFailedShards());
        assertEquals(0, forceMergeToOne().getFailedShards());
        refresh();
import java.util.HashSet;
        // Exactly one physical row per key must survive the merge (all stale copies compacted away).
        // Second merge — the two deletes are now in the frozen snapshot and must be physically dropped.
    // ══════════════════════════════════════════════════════════════════════
        // until a later multi-segment merge. Physical reclamation is covered by the sequential scenarios.
        // Correctness is verified by get-by-id: every concurrently-deleted id must be unresolvable and every
        createIndex(false);
     */
        }
            try {
        for (String id : deletedIds) {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
    private void assertParquetFileRowCountsMatchCatalog() throws IOException {
            .put("index.refresh_interval", -1)
    private static final String INDEX = "merges_with_deletes";
                forceMergeToOne();
        for (int i = 0; i < total; i += 5) {
    private void refresh() {
        List<Map<String, Object>> rows = new ArrayList<>();
import java.nio.file.Path;
                Map<String, Object> row = (Map<String, Object>) o;
import org.opensearch.action.DocWriteResponse;
        // Cross-format alignment: merged parquet rows == merged lucene docs, row_id sequential.
    private Path parquetDir() {
        refresh();
    }
import org.opensearch.common.settings.Settings;
        // Delete deterministically: every 8th doc ≈ 12.5%.
 * reconcile deletes and superseded update copies lazily, so these tests verify that after a merge
        assertEquals(0, forceMergeToOne().getFailedShards());
        }
        assertEquals("physical survivor row count after ~12% delete + merge", survivors, (int) parquetRows());
        return client().prepareDelete(INDEX, id).get();
        merger.get(60, java.util.concurrent.TimeUnit.SECONDS);
            .build();
        List<String> deletedIds = java.util.Collections.synchronizedList(new ArrayList<>());
            } catch (Exception ignored) {
    // ══════════════════════════════════════════════════════════════════════
        assertEquals(DocWriteResponse.Result.DELETED, deleteDoc("d3").getResult());
        }
        // Every key resolves to the latest value and version.
                }
import java.util.Map;
                List<Map<String, Object>> rows = parseRows(json);
                assertFalse("deleted doc must be gone: " + id, exists(id));
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
                survivorIds.add("t" + t + "_d" + (base + i));
        int segments = 4;
import org.opensearch.common.SuppressForbidden;
     * full cross-format row alignment.
    }
            }
import org.opensearch.core.rest.RestStatus;
            for (int i = 0; i < perSegment; i++) {
        // Every deleted id is unresolvable; every survivor resolves.
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
        // Phase 1: all threads ingest their disjoint id ranges concurrently, then a barrier + refresh
        assertEquals(0, fm.getFailedShards());
        for (int s = 0; s < segments; s++) {
        refresh();
    /**
        assertMergedParquetSortedByValueDesc();
        createIndex();
        try (
            .put("index.pluggable.dataformat.enabled", true)
        Set<String> deleted = new HashSet<>();
                    indexDoc("t" + threadId + "_d" + (base + i), base + i);
        Set<String> deleted = new HashSet<>();
        });
        }
            if (idx % 8 == 0) {
        }
        // physical parquet row count is not asserted here: a force-merge racing the deletes can collapse the
    /**
        for (int r = 1; r <= rounds; r++) {
        for (Segment segment : acquireAndGetSnapshot(INDEX).getSegments()) {
        int total = perSegment * segments;
 * {@code DataFormatAwareEngine}, including concurrent multi-shard ingest/delete traffic. Merges
        }
    public void testSortedIndexDeleteThenMergePreservesSortAndAlignment() throws Exception {
            if (wfs == null) {
        assertParquetFileRowCountsMatchCatalog();
        indexDoc("b0", 2);
        return primary().shardPath().resolveIndex();
            for (String file : wfs.files()) {
     * id is unresolvable, and merged parquet row count == merged lucene doc count (formats aligned).
                assertTrue("survivor must resolve: " + id, exists(id));
    private DeleteResponse deleteDoc(String id) {
        for (int s = 0; s < segments; s++) {
        // First merge — no deletes yet; all 12 rows present.
        // commits every row before any delete is issued.
     * deleted id must not — no lost or resurrected docs under concurrent ingest + delete + merge.
                }
     * so the merged parquet must not physically contain it: merged row count == survivors, the deleted
        for (int k = 0; k < keys; k++) {
            if (deleted.contains(id)) {
            }
    /** Multi-shard composite index for concurrent-traffic tests. */
        Settings.Builder settings = Settings.builder()
        assertEquals("merged output must hold exactly one row per key", keys, (int) parquetRows());
        }
    }
    }
    // ══════════════════════════════════════════════════════════════════════
    }
        int perSegment = 25;
        // Physical parquet truth: exactly `survivors` rows across all merged segments.
            }
        if (sorted) {
        assertFalse(exists("a0"));
                allIds.add(id);
        System.clearProperty(MERGE_ENABLED_PROPERTY);
            String id = "d" + i;
     * other generations survive.
     * whose footer numRows is the authoritative source.
        assertEquals(0, forceMergeToOne().getFailedShards());
 *
            // index may not exist if the test failed before creating it
    public void testDeleteBeforeMergeIsPhysicallyDroppedFromMergedParquet() throws Exception {
        return client().prepareGet(INDEX, id).setRealtime(false).get().isExists();
        assertEquals("merged parquet must physically drop pre-merge deletes", survivors, (int) parquetRows());
    // Scenario 4 — every doc in a generation deleted → generation dropped on merge
     * index it returns 2× the logical rows; here we sum only the parquet ("primary") writer file sets,
            }
    }
                assertTrue("catalog parquet file must exist on disk: " + fp, Files.exists(fp));
        refresh();
                String json = RustBridge.readAsJson(dir.resolve(file).toString());
            .setSettings(settings)
            .put("index.pluggable.dataformat", "composite")
            XContentParser parser = JsonXContent.jsonXContent.createParser(
                // a merge racing with in-flight deletes may no-op; the final merge below is authoritative
        return rows;
     * refresh commits those rows, a disjoint subset of each thread's docs is deleted while a force-merge
        }
        assertFalse(exists("d3"));
        assertParquetFileRowCountsMatchCatalog();
                String id = "t" + t + "_d" + (base + i);
            client().admin().indices().prepareDelete(INDEX).get();
        for (int k = 0; k < keys; k++) {
     * On a sorted index, deleting a subset then merging must keep merged parquet sorted by value DESC,
    public void tearDown() throws Exception {
    /**
        ensureGreen(INDEX);
        assertCrossFormatRowAligned(11);
    @Override
            assertEquals(DocWriteResponse.Result.DELETED, deleteDoc("d" + i).getResult());
        ForceMergeResponse fm = forceMergeToOne();
     * A doc deleted after a merge (so it is dead-but-present at the point of that merge's snapshot in
    /** merged parquet rows == merged lucene docs (numDocs), and row_id sequential per leaf. */
    private Path luceneIndexDir() {
            .prepareCreate(INDEX)
            if (i % 10 == 9) {
            if (wfs == null) {
        // Delete a known subset (one per segment) and refresh so the deletes are in the committed state.
     * then a force-merge. The merged output must carry exactly one row per surviving id at the latest
        int docsPerThread = 50;
            assertEquals("catalog numRows must match on-disk parquet metadata for gen " + segment.generation(), wfs.numRows(), fileRows);
        Settings settings = Settings.builder()
        // segments before the deletes commit, leaving them logically applied but not yet physically reclaimed
        int total = perSegment * segments;
        assertFalse(exists("d9"));
            }
        assertCrossFormatRowAligned(survivors);
import org.opensearch.core.xcontent.DeprecationHandler;
        assertEquals(survivors, (int) parquetRows());
            refresh();
    // ══════════════════════════════════════════════════════════════════════
        assertEquals(12L, parquetRows());
    }
     * runs concurrently. Correctness is verified by get-by-id: every survivor must resolve and every
    public void testFullyDeletedGenerationDroppedOnMerge() throws Exception {
    /** Every catalog parquet WriterFileSet's numRows must equal the actual on-disk file metadata. */
            for (int i = deletesPerThread; i < docsPerThread; i++) {
    @SuppressForbidden(reason = "JSON parsing for test verification of parquet output")
            }
        }
    // ══════════════════════════════════════════════════════════════════════
    public void testConcurrentIngestAndDeleteUnderMerge() throws Exception {
    private void assertMergedParquetSortedByValueDesc() throws IOException {
import org.apache.lucene.store.Directory;
        refresh();
    // ══════════════════════════════════════════════════════════════════════
        // survivor must resolve — no lost or resurrected docs under concurrent ingest + delete + merge. The
            assertEquals("version reflects all updates", (long) (rounds + 1), g.getVersion());
                assertEquals(RestStatus.CREATED, indexDoc("s" + s + "_d" + i, s * perSegment + i).status());
                @SuppressWarnings("unchecked")
        }
import java.util.ArrayList;
            }
        List<java.util.concurrent.Future<?>> ingest = new ArrayList<>();
    @SuppressForbidden(reason = "restore pluggable dataformat merge property after test")
            deleted.add(id);
            for (int i = 0; i < perSegment; i++) {
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), false)
        createIndex(true);
        refresh();
                NamedXContentRegistry.EMPTY,
            }
        for (Segment segment : acquireAndGetSnapshot(INDEX).getSegments()) {
            assertFalse("concurrently-deleted doc must not resolve: " + id, exists(id));
    // ══════════════════════════════════════════════════════════════════════
    // ══════════════════════════════════════════════════════════════════════
 * the surviving rows are physically correct in the written parquet files and stay row-aligned with
        List<String> survivorIds = java.util.Collections.synchronizedList(new ArrayList<>());
                for (int i = 1; i < rows.size(); i++) {
        assertEquals(0, forceMergeToOne().getFailedShards());
        int survivors = total - deleted.size();
    // ══════════════════════════════════════════════════════════════════════
        int segments = 8;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shards)
            for (int i = 0; i < deletesPerThread; i++) {
        }
import org.opensearch.test.OpenSearchIntegTestCase;
        }
public class MergesWithDeletesIT extends AbstractCompositeEngineIT {
                        long v = rowId.nextValue();
    }
import org.apache.lucene.store.NIOFSDirectory;
    private void createConcurrentIndex(int shards) {
import org.opensearch.index.engine.exec.WriterFileSet;
        int deletesPerThread = 10;         // delete the first 10 of each thread's 50
    public void testUpdateChurnThenMergeResolvesToLatest() throws Exception {
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
        assertEquals(DocWriteResponse.Result.DELETED, deleteDoc("d9").getResult());
     */
            .prepareCreate(INDEX)
 * this file be licensed under the Apache-2.0 license or a
        for (int t = 0; t < threads; t++) {
            refresh();
                        expected++;
    }
    @Override
    public void testDeletedDocDroppedOnNextMerge() throws Exception {
        assertEquals(DocWriteResponse.Result.DELETED, deleteDoc("a1").getResult());
        createConcurrentIndex(1);
        System.setProperty(MERGE_ENABLED_PROPERTY, "true");
    public void setUp() throws Exception {
            .put("index.composite.primary_data_format", "parquet")
        assertEquals("parquet rows must match expected survivors", expectedRows, (int) actualParquetRows);
                assertTrue("survivor must resolve after merge", exists("s" + s + "_d" + i));
        }
    /**
                json
     * Deletes ~12% of docs spread deterministically across many segments, then force-merges to a
                    if (rowId.advanceExact(doc)) {
        assertEquals(0, forceMergeToOne().getFailedShards());
    }
        }
        int total = 40;
import org.opensearch.core.xcontent.NamedXContentRegistry;
        createIndex();
        refresh();
     * version/value — no stale superseded copies survive the merge.
        Path dir = parquetDir();
        createIndex();
            .setSettings(settings)
        ) {
        indexDoc("a0", 0);
        java.util.concurrent.ExecutorService pool = java.util.concurrent.Executors.newFixedThreadPool(threads);
    private ForceMergeResponse forceMergeToOne() {
        // takes effect, while a force-merge is fired concurrently to race the deletes against a merge.
    }
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), false)
                    assertTrue("value must be DESC, found " + prev + " before " + curr, prev >= curr);
import org.opensearch.action.delete.DeleteResponse;
import org.opensearch.index.shard.IndexShard;
        for (java.util.concurrent.Future<?> f : ingest) {
            ids.add(id);
            assertTrue("key must resolve after churn+merge", g.isExists());
        try {
        for (String id : deleted) {
        } catch (Exception ignored) {
                        assertEquals("row_id must be sequential (RowIdMapping applied) at doc " + doc, expected, v);
    /**
    // ══════════════════════════════════════════════════════════════════════
        refresh();
