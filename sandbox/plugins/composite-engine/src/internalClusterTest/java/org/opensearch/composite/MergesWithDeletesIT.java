        // Phase 2: delete a disjoint subset of each thread's (now-committed) docs, asserting each delete
        }
import org.opensearch.core.xcontent.DeprecationHandler;
     */  
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), false)  
    // ══════════════════════════════════════════════════════════════════════  
        ensureGreen(INDEX);  
        }
    }
    // ══════════════════════════════════════════════════════════════════════
    /**
     * so the merged parquet must not physically contain it: merged row count == survivors, the deleted  
    }  
            assertEquals(DocWriteResponse.Result.CREATED, indexDoc("k" + k, 0).getResult());  
        Settings settings = Settings.builder()
            refresh();
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
    }  
 * this file be licensed under the Apache-2.0 license or a
     * physically drop the deletes, and keep parquet↔lucene row-aligned (RowIdMapping correct through
            .prepareCreate(INDEX)
        assertFalse(exists("a1"));
        for (int s = 0; s < segments; s++) {
     * A doc deleted after a merge (so it is dead-but-present at the point of that merge's snapshot in
        assertEquals(4L, parquetRows());
        assertParquetFileRowCountsMatchCatalog();  
        refresh();
        System.setProperty(MERGE_ENABLED_PROPERTY, "true");
        Path dir = parquetDir();
            // index may not exist if the test failed before creating it
        }  
            .get();
            .putList("index.composite.secondary_data_formats", "lucene")
        assertEquals("parquet rows must match expected survivors", expectedRows, (int) actualParquetRows);
        createIndex();  
                    }  
                for (int i = 0; i < docsPerThread; i++) {
     */
        for (int r = 1; r <= rounds; r++) {  
        assertCrossFormatRowAligned(11);  
     */
    // Index setup  
    private void refresh() {  
    // Scenario 4 — every doc in a generation deleted → generation dropped on merge
        return client().admin().indices().prepareForceMerge(INDEX).setMaxNumSegments(1).setFlush(true).get();
    }
            if (wfs == null) {
import org.opensearch.action.index.IndexResponse;
        // Generation B — survives.  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertEquals("merged parquet must physically drop pre-merge deletes", survivors, (int) parquetRows());
            .put("index.composite.primary_data_format", "parquet")
        int total = perSegment * segments;
package org.opensearch.composite;
        ForceMergeResponse fm = forceMergeToOne();
        return client().prepareIndex(INDEX).setId(id).setSource("name", "doc_" + id, "value", value).get();
        assertEquals(survivors, (int) parquetRows());  
        for (String id : deleted) {
    private static final String INDEX = "merges_with_deletes";
     * full cross-format row alignment.
        assertParquetFileRowCountsMatchCatalog();  
            assertEquals(RestStatus.CREATED, indexDoc(id, i).status());  
            deleted.add(id);  
        assertEquals(12L, parquetRows());  
        }
                assertFalse("deleted doc must be gone: " + id, exists(id));
     * a reordering merge with deletes).
     */
        // Each key updated several times, interleaved with refreshes so copies land across generations.
        assertTrue("merged lucene dir must exist", Files.exists(luceneDir));
                    if (rowId.advanceExact(doc)) {
        return primary().shardPath().resolveIndex();  
                Path fp = dir.resolve(file);
    /** Every catalog parquet WriterFileSet's numRows must equal the actual on-disk file metadata. */  
        // Generation A — will be fully deleted.
            if (idx % 8 == 0) {
            }));
            for (String file : wfs.files()) {  
                assertTrue("survivor must resolve after merge", exists("s" + s + "_d" + i));
            assertTrue("key must resolve after churn+merge", g.isExists());
        // takes effect, while a force-merge is fired concurrently to race the deletes against a merge.  
import org.apache.lucene.index.SortedNumericDocValues;  
    public void testDeletedDocDroppedOnNextMerge() throws Exception {
import java.util.Set;
            assertEquals(DocWriteResponse.Result.DELETED, deleteDoc(id).getResult());
    /**
 * End-to-end merges-with-deletes coverage for the composite (parquet primary + lucene secondary)
                String id = "t" + t + "_d" + (base + i);
        int segments = 4;
        int docsPerThread = 50;
        assertEquals(0, forceMergeToOne().getFailedShards());
        return acquireAndGetSnapshot(INDEX).getSearchableFiles("parquet").stream().mapToLong(WriterFileSet::numRows).sum();  
        assertParquetFileRowCountsMatchCatalog();
    private Path parquetDir() {
     * deleted id must not — no lost or resurrected docs under concurrent ingest + delete + merge.
    /** Manual-refresh composite index (lucene secondary for _id resolution), unsorted. */  
        refresh();  
    }
            .put("index.pluggable.dataformat", "composite")  
                }
    /** merged parquet rows == merged lucene docs (numDocs), and row_id sequential per leaf. */
        // physical parquet row count is not asserted here: a force-merge racing the deletes can collapse the  
        assertEquals(0, fm.getFailedShards());
            for (int i = 0; i < perSegment; i++) {
        }  
            }  
        indexDoc("a1", 1);
            for (LeafReaderContext ctx : reader.leaves()) {
                int base = threadId * docsPerThread;  
            }
        assertCrossFormatRowAligned(survivors);  
    }  
        } catch (Exception ignored) {
        for (String id : survivorIds) {  
                // a merge racing with in-flight deletes may no-op; the final merge below is authoritative
     * A doc deleted and refreshed <em>before</em> a force-merge is excluded from the frozen snapshot,
                String id = "seg" + s + "_" + i;  
    // ══════════════════════════════════════════════════════════════════════
                        expected++;
import org.opensearch.common.xcontent.json.JsonXContent;
        }  
import org.opensearch.action.delete.DeleteResponse;
            refresh();
    // ══════════════════════════════════════════════════════════════════════
        for (int s = 0; s < segments; s++) {  
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), false)
            assertEquals("latest value must win", rounds, ((Number) g.getSourceAsMap().get("value")).intValue());  
            if (wfs == null) {  
        // segments before the deletes commit, leaving them logically applied but not yet physically reclaimed
                Map<String, Object> row = (Map<String, Object>) o;  
            .setMapping("name", "type=keyword", "value", "type=integer")
 * compatible open source license.
            for (int i = 1; i < perSegment; i++) {  
        }
     * runs concurrently. Correctness is verified by get-by-id: every survivor must resolve and every
        refresh();
        for (java.util.concurrent.Future<?> f : ingest) {  
        assertEquals(0, forceMergeToOne().getFailedShards());
                        assertEquals("row_id must be sequential (RowIdMapping applied) at doc " + doc, expected, v);
        refresh();  
        int keys = 20;
        List<String> ids = new ArrayList<>();
    }
import java.io.IOException;  
                long expected = 0;  
    @SuppressForbidden(reason = "restore pluggable dataformat merge property after test")  
    @Override
                refresh();  
        for (int i = 6; i < 12; i++) {
            }
        assertCrossFormatRowAligned(keys);  
        // Physical parquet truth: exactly `survivors` rows across all merged segments.  
            assertEquals("lucene numDocs must equal parquet rows (row-aligned)", expectedRows, reader.numDocs());  
     * refresh commits those rows, a disjoint subset of each thread's docs is deleted while a force-merge  
            for (int i = deletesPerThread; i < docsPerThread; i++) {  
    }
        // until a later multi-segment merge. Physical reclamation is covered by the sequential scenarios.
            ids.add(id);
        int survivors = total - deleted.size();
        assertEquals(0, forceMergeToOne().getFailedShards());  
 * the merged lucene segment, not just that doc counts look right.
    // ══════════════════════════════════════════════════════════════════════
        for (int s = 0; s < segments; s++) {  
        int survivors = total - deleted.size();
import org.opensearch.action.DocWriteResponse;  
    }
     * Deleting every document of a generation, then merging, drops that generation entirely while
    // Verification helpers  
        List<String> survivorIds = java.util.Collections.synchronizedList(new ArrayList<>());
        for (int t = 0; t < threads; t++) {  
    private IndexResponse indexDoc(String id, int value) {  
            // distinct values so sort order is unambiguous
                    indexDoc("t" + threadId + "_d" + (base + i), base + i);
        }
import java.nio.file.Path;
 * SPDX-License-Identifier: Apache-2.0
            }
/**  
    }
                String json = RustBridge.readAsJson(dir.resolve(file).toString());
    @SuppressForbidden(reason = "JSON parsing for test verification of parquet output")  
        int deletesPerThread = 10;         // delete the first 10 of each thread's 50  
                forceMergeToOne();  
    public void tearDown() throws Exception {
                rows.add(row);
    private List<Map<String, Object>> parseRows(String json) throws IOException {
     */
        int rounds = 5;
     * Deletes ~12% of docs spread deterministically across many segments, then force-merges to a
    @SuppressForbidden(reason = "enable pluggable dataformat merge for integration testing")
                SortedNumericDocValues rowId = ctx.reader().getSortedNumericDocValues(DocumentInput.ROW_ID_FIELD);
 * reconcile deletes and superseded update copies lazily, so these tests verify that after a merge  
        assertEquals("physical survivor row count after ~12% delete + merge", survivors, (int) parquetRows());  
/*  
            }  
            }
        System.clearProperty(MERGE_ENABLED_PROPERTY);
                    int prev = ((Number) rows.get(i - 1).get("value")).intValue();
        for (Segment segment : acquireAndGetSnapshot(INDEX).getSegments()) {
    /**
import org.apache.lucene.store.NIOFSDirectory;
        long actualParquetRows = parquetRows();  
        // Delete deterministically: every 8th doc ≈ 12.5%.
            }
        refresh();
    private ForceMergeResponse forceMergeToOne() {
import org.opensearch.core.xcontent.XContentParser;  
        for (int i = 0; i < total; i++) {  
        }  
            assertTrue("survivor must resolve after concurrent churn + merge: " + id, exists(id));
            refresh();
        try {
            .put("index.pluggable.dataformat", "composite")
            client().admin().indices().prepareDelete(INDEX).get();  
        for (int k = 0; k < keys; k++) {
            long fileRows = 0;
        int total = perSegment * segments;
        assertEquals("merged output must hold exactly one row per key", keys, (int) parquetRows());
            deleted.add("d" + i);
        createIndex();
    public void testUpdateChurnThenMergeResolvesToLatest() throws Exception {
        assertEquals(DocWriteResponse.Result.DELETED, deleteDoc("d9").getResult());
        }  
import org.opensearch.parquet.bridge.ParquetFileMetadata;
    // ══════════════════════════════════════════════════════════════════════
        // survivor must resolve — no lost or resurrected docs under concurrent ingest + delete + merge. The
            .setSettings(settings)  
    public void setUp() throws Exception {  
     * other generations survive.  
            final int threadId = t;
        }  
     * version/value — no stale superseded copies survive the merge.
        assertFalse(exists("d3"));  
        assertTrue(exists("b1"));
        refresh();
                json
     */  
    }
            for (int i = 0; i < perSegment; i++) {
                assertEquals(RestStatus.CREATED, indexDoc(id, s * perSegment + i).status());
    private void createIndex() {
        int expectedSurvivors = threads * (docsPerThread - deletesPerThread);
    /**
    // Scenario 2 — ~12% deletes spread across many segments, then force-merge to one
     * id is unresolvable, and merged parquet row count == merged lucene doc count (formats aligned).
            XContentParser parser = JsonXContent.jsonXContent.createParser(
    /**
        refresh();
        client().admin().indices().prepareRefresh(INDEX).get();
    // Scenario 7 — concurrent multi-shard ingestion + deletion under merges
        List<java.util.concurrent.Future<?>> ingest = new ArrayList<>();
        // Exactly one physical row per key must survive the merge (all stale copies compacted away).
                assertTrue("survivor must resolve: " + id, exists(id));
    private void assertParquetFileRowCountsMatchCatalog() throws IOException {
        for (int k = 0; k < keys; k++) {  
        return getPrimaryShard(INDEX);
        }  
            .put("index.pluggable.dataformat.enabled", true)  
        assertEquals(DocWriteResponse.Result.DELETED, deleteDoc("a0").getResult());
    }
    /**
    private void assertCrossFormatRowAligned(int expectedRows) throws IOException {
    public void testSortedIndexDeleteThenMergePreservesSortAndAlignment() throws Exception {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                for (int doc = 0; doc < ctx.reader().maxDoc(); doc++) {
        // Every deleted id is unresolvable; every survivor resolves.
        return client().prepareDelete(INDEX, id).get();
                assertEquals(DocWriteResponse.Result.UPDATED, resp.getResult());  
            } else {  
            for (int i = 0; i < deletesPerThread; i++) {
    }
    // ══════════════════════════════════════════════════════════════════════  
import org.opensearch.common.settings.Settings;
        }
        }
            }
    public void testConcurrentIngestAndDeleteUnderMerge() throws Exception {
        return rows;
        createIndex();
     * whose footer numRows is the authoritative source.  
    }
                    assertTrue("value must be DESC, found " + prev + " before " + curr, prev >= curr);  
        List<String> deletedIds = java.util.Collections.synchronizedList(new ArrayList<>());  
        // Cross-format alignment: merged parquet rows == merged lucene docs, row_id sequential.
            }
        assertParquetFileRowCountsMatchCatalog();
    }
    // ══════════════════════════════════════════════════════════════════════  
            .indices()
import org.opensearch.cluster.metadata.IndexMetadata;
        for (Segment segment : acquireAndGetSnapshot(INDEX).getSegments()) {  
        createIndex(false);
    }
            } catch (Exception ignored) {
            .get();
        }
                deletedIds.add(id);
        for (String id : ids) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
            assertFalse("concurrently-deleted doc must not resolve: " + id, exists(id));
            }  
            assertEquals(RestStatus.CREATED, indexDoc("d" + i, i).status());  
    // ══════════════════════════════════════════════════════════════════════
        refresh();  
        assertEquals(0, forceMergeToOne().getFailedShards());  
        java.util.concurrent.ExecutorService pool = java.util.concurrent.Executors.newFixedThreadPool(threads);
                }
    // ══════════════════════════════════════════════════════════════════════
import org.opensearch.core.rest.RestStatus;  
        // Phase 1: all threads ingest their disjoint id ranges concurrently, then a barrier + refresh  
    /** Merged parquet rows must be sorted by value DESC. */  
        return primary().shardPath().getDataPath().resolve("parquet");
    }  
        int threads = 4;
            assertEquals("resolution after sorted merge: " + id, deleted.contains(id) == false, exists(id));  
        super.setUp();
import java.util.Map;  
            }
                assertEquals(DocWriteResponse.Result.DELETED, deleteDoc(id).getResult());  
            .put("index.refresh_interval", -1);
            for (int k = 0; k < keys; k++) {
     * index it returns 2× the logical rows; here we sum only the parquet ("primary") writer file sets,
     * Physical parquet row count — the logical live-row truth. The inherited {@code getTotalRowCount}  
            .prepareCreate(INDEX)
            assertFalse("deleted-before-merge doc must be physically gone: " + id, exists(id));  
    private void createIndex(boolean sorted) {
        createIndex(true);
        createIndex();
        refresh();  
        refresh();  
                survivorIds.add("t" + t + "_d" + (base + i));
        // First merge — no deletes yet; all 12 rows present.
import org.apache.lucene.index.LeafReaderContext;
        assertEquals("survivor bookkeeping sanity", expectedSurvivors, survivorIds.size());
        client().admin()  
                continue;  
        assertEquals(0, forceMergeToOne().getFailedShards());
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
        client().admin()  
        }
     * On a sorted index, deleting a subset then merging must keep merged parquet sorted by value DESC,  
        refresh();
     * single segment. Asserts the exact survivor count physically, every survivor/deleted id, and  
                fileRows += md.numRows();
    private IndexShard primary() {  
            .build();
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
     * sums numRows across <em>every</em> format in each segment (parquet + lucene), so on a composite
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shards)  
        super.tearDown();
import java.nio.file.Files;
    private Path luceneIndexDir() {
    // Scenario 3 — heavy update churn then merge resolves to exactly one latest row per id
        assertEquals(0, forceMergeToOne().getFailedShards());
            assertEquals("version reflects all updates", (long) (rounds + 1), g.getVersion());
            .put("index.refresh_interval", -1)
    // Scenario 5 — sorted index: delete then merge preserves sort AND alignment
        ) {  
            String id = "d" + i;
    @Override
        assertEquals(DocWriteResponse.Result.DELETED, deleteDoc("d3").getResult());  
        assertCrossFormatRowAligned(survivors);
        assertTrue(exists("d100"));
        createIndex();
import org.opensearch.index.engine.exec.WriterFileSet;  
import java.util.HashSet;
                continue;
                    int curr = ((Number) rows.get(i).get("value")).intValue();
    // ══════════════════════════════════════════════════════════════════════
    private DeleteResponse deleteDoc(String id) {
    }
 */  
     */  
    }
        List<Map<String, Object>> rows = new ArrayList<>();
                assertEquals(RestStatus.CREATED, indexDoc("s" + s + "_d" + i, s * perSegment + i).status());
     * retained forever.
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
        pool.shutdown();
        for (int i = 0; i < total; i += 5) {  
        }
        }
        }  
            settings.putList("index.sort.field", "value").putList("index.sort.order", "desc");
    private long parquetRows() throws IOException {
        }  
        Set<String> deleted = new HashSet<>();
                assertTrue("catalog parquet file must exist on disk: " + fp, Files.exists(fp));
                if (rowId == null) {  
            }
            .put("index.composite.primary_data_format", "parquet")
import java.util.ArrayList;  
    // ══════════════════════════════════════════════════════════════════════  
    private void assertMergedParquetSortedByValueDesc() throws IOException {
        // Delete a known subset (one per segment) and refresh so the deletes are in the committed state.
            }
                List<Map<String, Object>> rows = parseRows(json);
                allIds.add(id);
            .setSettings(settings)  
        if (sorted) {  
        refresh();
        List<String> allIds = new ArrayList<>();  
            }
        int total = 40;
    }
            .putList("index.composite.secondary_data_formats", "lucene")  
import org.apache.lucene.index.DirectoryReader;
    // ══════════════════════════════════════════════════════════════════════
                }  
        assertParquetFileRowCountsMatchCatalog();
            ingest.add(pool.submit(() -> {
import org.opensearch.index.engine.exec.Segment;
        }  
        Path dir = parquetDir();  
        }
            .indices()
        Set<String> deleted = new HashSet<>();
                ParquetFileMetadata md = RustBridge.getFileMetadata(fp.toString());  
        try (  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        Settings.Builder settings = Settings.builder()  
     */  
        assertEquals(DocWriteResponse.Result.DELETED, deleteDoc("a1").getResult());
        int perSegment = 25;  
        assertTrue(pool.awaitTermination(30, java.util.concurrent.TimeUnit.SECONDS));  
        for (String id : deletedIds) {  
        assertTrue(exists("b0"));  
    // Scenario 1 — delete BEFORE the merge: row must be physically gone from merged parquet
                for (int i = 1; i < rows.size(); i++) {  
 * The OpenSearch Contributors require contributions made to  
            String id = "s" + s + "_d0";
            f.get(60, java.util.concurrent.TimeUnit.SECONDS);
        // Authoritative final state: refresh, then a final force-merge so all deletes are reconciled.
    // ══════════════════════════════════════════════════════════════════════  
        Path luceneDir = luceneIndexDir();  
 */  
    public void testFullyDeletedGenerationDroppedOnMerge() throws Exception {
                String id = allIds.get(idx);
        // Every key resolves to the latest value and version.
    }  
        // Correctness is verified by get-by-id: every concurrently-deleted id must be unresolvable and every
import org.opensearch.test.OpenSearchIntegTestCase;
    private boolean exists(String id) {
        int perSegment = 10;  
        assertParquetFileRowCountsMatchCatalog();
        return client().prepareGet(INDEX, id).setRealtime(false).get().isExists();  
 * the surviving rows are physically correct in the written parquet files and stay row-aligned with
        // Delete two docs and add a fresh segment so a second force-merge has something to merge.
            .put("index.pluggable.dataformat.enabled", true)
        for (int t = 0; t < threads; t++) {
import java.util.List;
    // ══════════════════════════════════════════════════════════════════════
            assertEquals("catalog numRows must match on-disk parquet metadata for gen " + segment.generation(), wfs.numRows(), fileRows);  
import org.opensearch.parquet.bridge.RustBridge;  
        indexDoc("a0", 0);  
}  
public class MergesWithDeletesIT extends AbstractCompositeEngineIT {
        refresh();
        int survivors = total - deleted.size();
        }
        }
                }
    }  
        for (int idx = 0; idx < allIds.size(); idx++) {  
        indexDoc("b1", 3);
 *
 * {@code DataFormatAwareEngine}, including concurrent multi-shard ingest/delete traffic. Merges
            assertEquals(DocWriteResponse.Result.DELETED, deleteDoc("d" + i).getResult());
     * the next frozen snapshot, the merge drops the row. Proves deletes are eventually reclaimed, not
    private static final String MERGE_ENABLED_PROPERTY = "opensearch.pluggable.dataformat.merge.enabled";
    // ══════════════════════════════════════════════════════════════════════
        }  
        assertEquals(0, forceMergeToOne().getFailedShards());  
import org.opensearch.index.shard.IndexShard;
        for (String id : allIds) {  
        assertCrossFormatRowAligned(2);
        assertEquals("deletes must be physically reclaimed by the next merge", 11L, parquetRows());
                        long v = rowId.nextValue();  
        int segments = 8;
    // ══════════════════════════════════════════════════════════════════════  
        ensureGreen(INDEX);  
            .setMapping("name", "type=keyword", "value", "type=integer")
import org.opensearch.action.get.GetResponse;  
     * Concurrency in two phases: multiple threads first ingest disjoint id ranges in parallel; after a
        merger.get(60, java.util.concurrent.TimeUnit.SECONDS);
        assertEquals("only generation B rows remain physically", 2L, parquetRows());
    @SuppressForbidden(reason = "JSON parsing for test verification of parquet output")
    /** Multi-shard composite index for concurrent-traffic tests. */  
                NamedXContentRegistry.EMPTY,
            GetResponse g = client().prepareGet(INDEX, "k" + k).setRealtime(false).get();
                @SuppressWarnings("unchecked")
        assertFalse(exists("a0"));
        assertMergedParquetSortedByValueDesc();
            try {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
        assertFalse(exists("d9"));
        // commits every row before any delete is issued.
    // Scenario 6 — deleted doc that survives one merge is physically dropped on the NEXT merge
        java.util.concurrent.Future<?> merger = pool.submit(() -> {
            for (String file : wfs.files()) {  
    /**
                assertEquals(DocWriteResponse.Result.DELETED, deleteDoc(id).getResult());  
     * Heavy same-id update churn across segments (each update = internal delete-old + index-new),  
import org.opensearch.index.engine.dataformat.DocumentInput;
     * then a force-merge. The merged output must carry exactly one row per surviving id at the latest
        // Second merge — the two deletes are now in the frozen snapshot and must be physically dropped.
    public void testDeleteBeforeMergeIsPhysicallyDroppedFromMergedParquet() throws Exception {  
        for (int s = 0; s < segments; s++) {
        refresh();  
            }
                deleted.add(id);
        for (int i = 0; i < 6; i++) {
        });
import org.opensearch.common.SuppressForbidden;  
    /**
            if (deleted.contains(id)) {
            for (Object o : parser.list()) {
            int base = t * docsPerThread;  
    private void createConcurrentIndex(int shards) {
            assertEquals(RestStatus.CREATED, indexDoc("d" + i, i).status());
    public void testPartialDeletesAcrossSegmentsThenForceMerge() throws Exception {  
        indexDoc("d100", 100);
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
    }  
        createConcurrentIndex(1);
        indexDoc("b0", 2);
     * a subsequent generation) is physically removed by a following merge: once its {@code .liv} is in  
    }
        assertCrossFormatRowAligned(survivors);  
            if (i % 10 == 9) {
        }
        Set<String> deleted = new HashSet<>();
            }
                    continue;
            )
    }
import org.apache.lucene.store.Directory;
                IndexResponse resp = indexDoc("k" + k, r);
    // ══════════════════════════════════════════════════════════════════════  
