                .setIfSeqNo(staleSeqNo)
    }
            .setMapping("name", "type=keyword", "value", "type=integer")
    public void testDeleteVersionConflict() {
import org.opensearch.action.get.GetResponse;  
        for (int i = 0; i <= updates; i += 3) {
        assertEquals(2L, version(newRow));
        assertFalse("deleted doc hidden", client().prepareGet(INDEX, "x").setRealtime(false).get().isExists());  
                .setIfSeqNo(staleSeqNo)  
        assertEquals(label + ": " + VALUE, value, ((Number) row.get(VALUE)).longValue());
        flushIndex(INDEX);  
     * drains to the parent before the next {@code addIndexes} folds the new segment, so the second  
    public void testDeleteFullyEmptiesSegmentDropsGeneration() throws IOException {  
        refreshIndex(INDEX);
    private List<Map<String, Object>> readParquetRows() throws IOException {
        assertEquals(3L, get.getVersion());  
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), false)  
                }
        indexDoc("k2", "anchor", 99);  
    /** Verifies that a partial delete hides the document without dropping its segment. */
        }  
 * SPDX-License-Identifier: Apache-2.0
    private static long version(Map<String, Object> row) {
        assertTrue("doc must survive a conflicting delete", realtime.isExists());
        assertTrue("post-refresh row get must see the update on a sorted index", rows.isExists());
        assertEquals(DocWriteResponse.Result.UPDATED, ok.getResult());
        long staleSeqNo = created.getSeqNo();
        GetResponse after = client().prepareGet(INDEX, "k1").setRealtime(true).get();  
        refreshIndex(INDEX);
        refreshIndex(INDEX);
        assertEquals(2L, realtime.getVersion());
            () -> client().prepareUpdate(INDEX, "k1")  
        assertTrue("sibling survives", client().prepareGet(INDEX, "y").setRealtime(false).get().isExists());
            () -> client().prepareUpdate(INDEX, "k1")
            assertEquals("both copies must sit in the same generation", oldRow.get("__generation__"), newRow.get("__generation__"));
     */
        for (int i = 1; i <= updates; i++) {  
            () -> client().prepareIndex(INDEX)
     * "within refresh window" vs "across refresh" cases stay deterministic across the refresh boundary.
        assertEquals(42, value(after));
    /** Verifies that deleting a segment's only document drops that generation from the catalog. */
        assertEquals(updates, value(rows));
        // rather than being answered from the version map.
        if (oldRow != null) {
        assertEquals(RestStatus.OK, updated.status());  
     */
        return client().prepareIndex(INDEX).setId(id).setSource(NAME, name, TITLE, title, VALUE, value, PRICE, price, ACTIVE, active).get();
        assertEquals(label + ": " + TITLE, title, row.get(TITLE));  
     */
        // The document now lives in the primary store, so the update's get must fall through to it
                        @SuppressWarnings("unchecked")  
            .get();
        GetResponse rows = client().prepareGet(INDEX, "k1").setRealtime(false).get();  
            if (i % 3 == 0) {
            .putList("index.composite.secondary_data_formats", "lucene")
        Settings settings = Settings.builder()
        assertEquals(DocWriteResponse.Result.CREATED, indexDoc("k1", "v_old", 1).getResult());  
        Path parquetDir = getPrimaryShard(INDEX).shardPath().getDataPath().resolve("parquet");
     * An {@code _update} carrying a stale {@code if_seq_no} must be rejected once the document has
                .setId("k1")
        GetResponse beforeUpdate = client().prepareGet(INDEX, "k1").setRealtime(false).get();  
        assertFields("get after same-generation full update", get.getSourceAsMap(), "new", "new title", 2L, 2.5, false);
import org.opensearch.index.engine.VersionConflictEngineException;
        ensureGreen(INDEX);  
        Settings settings = Settings.builder()
        refreshIndex(INDEX);  
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        DeleteResponse del = deleteDoc("solo");
     * <p>Distinct from {@link #testUpdateVersionConflict}, which issues an {@code _index} (the
        GetResponse realtime = client().prepareGet(INDEX, "k1").setRealtime(true).get();
                continue;  
        ensureGreen(INDEX);  
        Map<String, Object> oldRow = rowAtSeqNoIfPresent(rows, created.getSeqNo());
        assertEquals(2, value(rows));  
        deleteDoc("x");  
        refreshIndex(INDEX);
        assertEquals(2L, version(newRow));  
     * A full-document reindex of an existing id across a refresh appends a complete new parquet row  
import org.opensearch.parquet.bridge.RustBridge;
        boolean active  
        refreshIndex(INDEX);
        long term = created.getPrimaryTerm();
        }
                .setRetryOnConflict(0)
            assertFields("row after first partial update", afterFirst, "keep", "keep title", 10L, 1.5, true);
                indexDoc("anchor_" + i, "anchor", i);  
    }  
                    XContentParser parser = JsonXContent.jsonXContent.createParser(
        long term = created.getPrimaryTerm();  
        Map<String, Object> newRow = rowAtSeqNo(rows, updated.getSeqNo());  
        indexMultiField("k1", "keep", "keep title", 1L, 1.5, true);  
        }
            .putList("index.sort.field", "value")
    }
        List<Map<String, Object>> rows = readParquetRows();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        IndexResponse updated = indexMultiField("k1", "new", "new title", 2L, 2.5, false);
     */
        assertTrue("realtime get must see the update", realtime.isExists());  
import org.opensearch.action.delete.DeleteResponse;
    }  
                .setDoc("name", "v_conflict")
    }
     * without {@code UpdateHelper} in between.
        createManualRefreshIndex();  
    private static int value(GetResponse r) {  
    public void testUpdateAcrossRefresh() {  
        assertEquals("partial delete must not drop the segment", 4L, getTotalRowCount(acquireAndGetSnapshot(INDEX)));
import org.opensearch.core.xcontent.NamedXContentRegistry;  
    }
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), false)  
            .indices()
    /**  
            .prepareCreate(INDEX)
    /** The one parquet row written by the operation that was assigned {@code seqNo}. */
        indexDoc("k1", "v1", 1);  
/*  
import org.opensearch.test.OpenSearchIntegTestCase;  
        VersionConflictEngineException ex = expectThrows(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            () -> client().prepareDelete(INDEX, "k1").setIfSeqNo(staleSeqNo).setIfPrimaryTerm(term).get()
import org.opensearch.core.xcontent.XContentParser;
        assertEquals(DocWriteResponse.Result.CREATED, created.getResult());  
        long term = created.getPrimaryTerm();  
     * Two partial updates to different fields across a refresh. The second update's merge input is
                ) {
        assertFalse("realtime get must not see the deleted doc", client().prepareGet(INDEX, "k1").setRealtime(true).get().isExists());
    }
    }
        client().admin()  
        refreshIndex(INDEX);
            .build();
    private static final String NAME = "name";  
        createManualRefreshIndex();
    private static long seqNo(Map<String, Object> row) {  
        assertEquals(label + ": " + ACTIVE, active, row.get(ACTIVE));  
        assertEquals(2L, get.getVersion());  
    private static Map<String, Object> rowAtSeqNoIfPresent(List<Map<String, Object>> rows, long seqNo) {
 * End-to-end update/delete coverage for {@link org.opensearch.index.engine.DataFormatAwareEngine}
        refreshIndex(INDEX);
import org.opensearch.action.update.UpdateResponse;
     * write-side check, in a different code path) and never refreshes, so it only covers the version
     * active writer. The realtime (version-map) GET must return the new doc immediately, and after a  
        assertEquals(DocWriteResponse.Result.UPDATED, updated.getResult());
            assertEquals("update " + i + " must be reported as an update", DocWriteResponse.Result.UPDATED, r.getResult());
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
    ) {
        assertEquals("v_new", name(realtime));
     * Composite index (Lucene secondary for {@code _id} resolution) with auto-refresh disabled so the
        assertEquals("v_new", name(rows));
import org.opensearch.index.engine.exec.Segment;  
        assertEquals(DocWriteResponse.Result.UPDATED, indexDoc("k1", "v_new", 2).getResult());
                String json = RustBridge.readAsJson(parquetDir.resolve(file).toString());  
        refreshIndex(INDEX);  
        createManualRefreshMultiFieldIndex();  
        assertEquals(2, value(realtime));
 */  
    private static final String VALUE = "value";
        GetResponse get = client().prepareGet(INDEX, "k1").setRealtime(false).get();
        List<Map<String, Object>> rows = readParquetRows();
        ensureGreen(INDEX);
        );  
        assertTrue("expected a version-conflict message, got: " + ex.getMessage(), ex.getMessage().contains("version conflict"));
        client().admin()
            }  
        assertEquals(DocWriteResponse.Result.CREATED, created.getResult());
            .putList("index.composite.secondary_data_formats", "lucene")
    private IndexResponse indexMultiField(String id, String name, String title, long value, double price, boolean active) {  
        assertEquals(2L, rows.getVersion());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
     */
            .put("index.composite.primary_data_format", "parquet")
     */
            .get();  
    }  
        assertFields("parquet row after partial update", newRow, "keep", "keep title", 42L, 1.5, true);
        assertEquals(3L, second.getVersion());
        assertEquals(DocWriteResponse.Result.CREATED, created.getResult());
        assertEquals("exactly one parquet row must carry _seq_no=" + seqNo + " in " + rows, 1, matches.size());
import org.opensearch.common.settings.Settings;
            .put("index.pluggable.dataformat", "composite")  
    /**
        assertEquals("v_old", name(beforeUpdate));
    @SuppressForbidden(reason = "JSON parsing for test verification of parquet output")  
     * refresh the parquet-row path must also resolve to the new doc.
     * Update after the prior copy is committed to the parent. The old copy's buffered delete
        assertEquals("v_new", name(after));
 * standalone delete on both sorted and unsorted indexes.
        assertEquals(2L, rows.getVersion());  
     * this exercises column reconstruction as the merge input.  
 * {@code getNumDocs()} is still a stub, so get-by-id (realtime version map + post-refresh parquet
    }
    private static final String PRICE = "price";  
        long value,
        List<Map<String, Object>> rows = readParquetRows();
                        NamedXContentRegistry.EMPTY,  
    /** Verifies that a fully deleted generation is dropped while other generations remain. */
     * A partial update rewrites only the supplied field. The new parquet row must carry the updated  
     * enforcement above cannot be satisfied by rejecting everything.
     * N successive updates of the same {@code _id}, with interleaved refreshes, must always resolve
        assertFields("parquet row after full update", newRow, "new", "new title", 2L, 2.5, false);
            .put("index.refresh_interval", -1)  
        IndexResponse created = indexDoc("k1", "v_old", 1);  
        assertEquals(2, value(rows));  
        createManualRefreshIndex();
     * {@link VersionConflictEngineException}, and the document must retain the last good update.
        );
        long staleSeqNo = created.getSeqNo();
        assertEquals(2L, updated.getVersion());
    /**  
            .setDoc("value", 42)
            .put("index.composite.primary_data_format", "parquet")
        IndexResponse created = indexDoc("k1", "v_old", 1);  
    }
        }
            assertTrue("anchor_" + i + " must survive the update/drain stream", anchor.isExists());
            .put("index.pluggable.dataformat", "composite")
 * <p>Assertions use get-by-id, not search: the DFA engine rejects the Lucene search path and  
        IndexResponse created = indexDoc("k1", "v_old", 1);
        UpdateResponse ok = client().prepareUpdate(INDEX, "k1")
        GetResponse rows = client().prepareGet(INDEX, "k1").setRealtime(false).get();
        UpdateResponse second = client().prepareUpdate(INDEX, "k1").setDoc(ACTIVE, false, PRICE, 9.75).get();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        createManualRefreshSortedIndex();
        Settings settings = Settings.builder()
            .put("index.refresh_interval", -1)
        indexDoc("y", "yy", 2);  
        assertEquals("v_new", name(realtime));
        assertEquals(DocWriteResponse.Result.UPDATED, updated.getResult());
        refreshIndex(INDEX);
        indexDoc("a", "aa", 1);
            VersionConflictEngineException.class,
        assertFalse("post-refresh get must not see the deleted doc", client().prepareGet(INDEX, "k1").setRealtime(false).get().isExists());
     * it found and the caller's condition is lost.
     */
        return client().prepareIndex(INDEX).setId(id).setSource("name", name, "value", value).get();
            .indices()
        GetResponse after = client().prepareGet(INDEX, "k1").setRealtime(true).get();  
            .put("index.refresh_interval", -1)
        return client().prepareDelete(INDEX, id).get();  
                .setSource("name", "v_conflict", "value", 3)  
    private static Map<String, Object> rowAtSeqNo(List<Map<String, Object>> rows, long seqNo) {  
 * on a composite (parquet primary + lucene secondary) index: same-generation update (Case 3),
    }  
     * docCount}). The two-phase flush retains the prior copy through the reorder and hides it via  
            .setMapping(NAME, "type=keyword", TITLE, "type=text", VALUE, "type=long", PRICE, "type=double", ACTIVE, "type=boolean")
        assertTrue("other-generation doc must survive", client().prepareGet(INDEX, "b").setRealtime(false).get().isExists());
/**  
                refreshIndex(INDEX);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        indexDoc("solo", "only", 1);
        assertEquals(DocWriteResponse.Result.DELETED, del.getResult());
        );  
            .setSettings(settings)  
        IndexResponse updated = indexDoc("k1", "v_new", 2);
        assertFalse("deleted doc gone", client().prepareGet(INDEX, "a").setRealtime(false).get().isExists());  
            .prepareCreate(INDEX)  
    public void testPartialDeleteHidesDocButRetainsSegment() throws IOException {  
        assertEquals(2L, updated.getVersion());  
        IndexResponse created = indexMultiField("k1", "old", "old title", 1L, 1.5, true);
        int updates = 10;
     *  
    public void testUpdateVersionConflict() {  
        IndexResponse created = indexDoc("k1", "v_old", 1);  
        refreshIndex(INDEX);
        refreshIndex(INDEX);
     * <p>{@code getById} resolves in three tiers: the version map, then (on engines that read ahead)
     * the update forces its internal get onto the published parquet row rather than the translog, so
        refreshIndex(INDEX);  
                .get()  
            assertFields("superseded parquet row must be untouched", oldRow, "old", "old title", 1L, 1.5, true);  
        assertEquals("v_new", name(realtime));  
        refreshIndex(INDEX);  
    /** Asserts the five user columns of a parquet row or a GET source. */
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), false)
 *
        // liveDocs-only delete of the prior copy). Pre-fix this threw at LuceneWriter.flush.
        assertTrue("realtime get must see the update", realtime.isExists());
import org.opensearch.core.xcontent.DeprecationHandler;
        return ((Number) row.get("_version")).longValue();
        assertEquals(2L, updated.getVersion());  
        assertTrue(realtime.isExists());
     * carrying every new value; the original row is never rewritten in place.
        assertEquals("only the emptied generation is dropped", 2L, getTotalRowCount(acquireAndGetSnapshot(INDEX)));  
            .build();
     * to the latest content and monotonically increasing version.  
        refreshIndex(INDEX);  
            WriterFileSet parquetFiles = segment.dfGroupedSearchableFiles().get("parquet");
        indexDoc("k2", "keeper", 2);
     * Update the same {@code _id} before any refresh — the prior copy lives in the same
 * row) is the authoritative read path.
     * get-by-id resolves the new doc.
        IndexResponse updated = indexDoc("k1", "v_new", 2);  
import org.opensearch.common.xcontent.json.JsonXContent;  
     * and the document must survive.
        UpdateResponse first = client().prepareUpdate(INDEX, "k1").setDoc(VALUE, 10L).get();  
    public void testFullUpdateWritesCompleteNewParquetRow() throws IOException {  
    }
     * Control: a <em>current</em> {@code if_seq_no} after a refresh must still be accepted, so the  
                        Map<String, Object> row = (Map<String, Object>) o;
 *
                .setRetryOnConflict(0)
    }
        IndexResponse current = indexDoc("k1", "v_new", 2);
     * the row written by the first, so each row must carry the cumulative state and nothing else.
    }
            .prepareCreate(INDEX)
    /**
        String label,  
 * this file be licensed under the Apache-2.0 license or a
            }
        // Refresh triggers the sorted two-phase flush (reorder retaining both rows, then a  
        assertFields("get after full update", get.getSourceAsMap(), "new", "new title", 2L, 2.5, false);  
        assertEquals(2L, updated.getVersion());  
    private void createManualRefreshSortedIndex() {  
     */
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        assertFields("get after chained partial updates", get.getSourceAsMap(), "keep", "keep title", 10L, 9.75, false);
            VersionConflictEngineException.class,  
        if (oldRow != null) {  
        assertEquals(2L, updated.getVersion());
        Map<String, Object> oldRow = rowAtSeqNoIfPresent(rows, created.getSeqNo());
import org.opensearch.common.SuppressForbidden;
    /**
                .get()  
 */  
     * fail at {@code LuceneWriter.flush} ({@code maxDoc != docCount}). The two-phase flush retains
        Map<String, Object> afterSecond = rowAtSeqNo(rows, second.getSeqNo());  
        Map<String, Object> row,
    }
        VersionConflictEngineException ex = expectThrows(
        assertEquals(2, value(client().prepareGet(INDEX, "k1").setRealtime(true).get()));
    public void testDeleteAcrossGenerationsDropsOnlyEmptied() throws IOException {
        GetResponse get = client().prepareGet(INDEX, "k1").setRealtime(false).get();
        createManualRefreshMultiFieldIndex();
import java.util.stream.Collectors;
    private static String name(GetResponse r) {
            VersionConflictEngineException.class,
        client().admin()  
package org.opensearch.composite;
        createManualRefreshIndex();
    public void testUpdateWithCurrentIfSeqNoAfterRefreshSucceeds() {  
        List<Map<String, Object>> rows = new ArrayList<>();
    }  
        refreshIndex(INDEX);
        GetResponse realtime = client().prepareGet(INDEX, "k1").setRealtime(true).get();  
        assertFalse("deleted doc must be gone", client().prepareGet(INDEX, "solo").setRealtime(false).get().isExists());  
                        json
        assertEquals(2L, first.getVersion());
                    for (Object o : parser.list()) {
    /** Updatable composite index with one column of each JSON-renderable, reconstructable type. */  
     * {@link VersionConflictEngineException} (exercising delete()'s pre-flight early-result path),
    public void testPureDeleteVisibleAfterRefresh() {
    /**
    public void testUpdateWithinRefreshWindow() {  
        GetResponse rows = client().prepareGet(INDEX, "k1").setRealtime(false).get();
        List<Map<String, Object>> rows = readParquetRows();  
            VersionConflictEngineException.class,  
        assertTrue(beforeUpdate.isExists());
     * refresh returns only the new doc (a reversed drain order would leave a duplicate).
     * been refreshed out of the live version map.  
     * Sorted composite index ({@code index.sort.field=value} desc) — the SORTED flush path where a
        }
    /** Optional: the superseded row, when a merge has not yet compacted it away. */  
     * Same-generation create→update on a sorted index used to
     * A conditional delete carrying a stale {@code if_seq_no} must be rejected with a  
    public void testManyUpdatesResolveToLatest() {
        GetResponse get = client().prepareGet(INDEX, "k1").setRealtime(false).get();
        assertTrue(after.isExists());
        assertEquals(label + ": " + PRICE, price, ((Number) row.get(PRICE)).doubleValue(), 0.0);
    }
        GetResponse get = client().prepareGet(INDEX, "k1").setRealtime(false).get();
        GetResponse rows = client().prepareGet(INDEX, "k1").setRealtime(false).get();  
        // The rejected update must not have mutated anything — a silently-dropped precondition
        assertTrue("expected a version-conflict message, got: " + ex.getMessage(), ex.getMessage().contains("version conflict"));
        assertTrue("post-refresh row get must see the update", rows.isExists());  
            assertEquals(1L + i, r.getVersion());  
        createManualRefreshMultiFieldIndex();  
            .setMapping("name", "type=keyword", "value", "type=integer")
        double price,
            .get();  
    }
        indexMultiField("k1", "keep", "keep title", 1L, 1.5, true);
        assertEquals("v_new", name(after));
        assertTrue("expected a version-conflict message, got: " + ex.getMessage(), ex.getMessage().contains("version conflict"));
        assertEquals(DocWriteResponse.Result.UPDATED, updated.getResult());
        assertEquals(RestStatus.CREATED, created.status());
import org.opensearch.core.rest.RestStatus;
        assertEquals(2L, rows.getVersion());
    public void testChainedPartialUpdatesAccumulateAcrossRefresh() throws IOException {
        indexDoc("x", "xx", 1);
     * a prefetch cache, then the primary store. {@code UpdateHelper} performs its get through  
        assertEquals("v_new", name(rows));
    }  
        assertEquals(DocWriteResponse.Result.UPDATED, updated.getResult());  
        Map<String, Object> newRow = rowAtSeqNo(rows, updated.getSeqNo());
        assertFields("get after partial update", get.getSourceAsMap(), "keep", "keep title", 42L, 1.5, true);
}
    private static void assertFields(
        List<Map<String, Object>> matches = rows.stream().filter(r -> seqNo(r) == seqNo).collect(Collectors.toList());
        assertEquals(2L, getTotalRowCount(acquireAndGetSnapshot(INDEX)));
        assertEquals(3L, version(afterSecond));
     *
        assertEquals(DocWriteResponse.Result.CREATED, created.getResult());
        createManualRefreshMultiFieldIndex();
        createManualRefreshIndex();  
        assertEquals(DocWriteResponse.Result.UPDATED, updated.getResult());
    }  
        // Update BEFORE refresh — prior copy in the same active writer, sorted index (the bug repro).  
    /** Verifies delete visibility before and after refresh while a bystander keeps the segment live. */  
    private static final String ACTIVE = "active";
        assertEquals(2, value(realtime));
            .setIfPrimaryTerm(current.getPrimaryTerm())
        refreshIndex(INDEX);
            .setSettings(settings)
        assertEquals("v_new", name(realtime));  
    /**
                        rows.add(row);  
        refreshIndex(INDEX);
        createManualRefreshIndex();
            if (parquetFiles == null) {
import java.util.ArrayList;
        IndexResponse updated = indexMultiField("k1", "new", "new title", 2L, 2.5, false);
    /**  
        IndexResponse created = indexDoc("k1", "v_old", 1);
        for (Segment segment : acquireAndGetSnapshot(INDEX).getSegments()) {  
        assertFields("parquet row after same-generation full update", newRow, "new", "new title", 2L, 2.5, false);
        if (afterFirst != null) {  
        assertEquals(DocWriteResponse.Result.UPDATED, updated.getResult());
        assertEquals(2, value(rows));
        return matches.get(0);  
     */  
        refreshIndex(INDEX);
            .putList("index.composite.secondary_data_formats", "lucene")
        createManualRefreshIndex();
    /**
import org.opensearch.action.DocWriteResponse;
        long staleSeqNo = created.getSeqNo();  
    /**
        long term = created.getPrimaryTerm();
        assertEquals(DocWriteResponse.Result.UPDATED, updated.getResult());  
    /** Same as above but without a refresh between create and update: both rows share one generation. */
        refreshIndex(INDEX);
     * same-generation create→update previously tripped {@code LuceneWriter.flush} ({@code maxDoc !=
            assertEquals(1L, version(oldRow));
        createManualRefreshIndex();  
    public void testFullUpdateWithinRefreshWindowLandsInOneGeneration() throws IOException {
        );
import org.opensearch.action.index.IndexResponse;
        assertEquals(1L, created.getVersion());  
            .setIfSeqNo(current.getSeqNo())  
        return ((Number) row.get("_seq_no")).longValue();
        assertEquals(1L, created.getVersion());  
                    }
        assertEquals(DocWriteResponse.Result.CREATED, created.getResult());
            .setRetryOnConflict(0)
                .setIfPrimaryTerm(term)
            for (String file : parquetFiles.files()) {
            IndexResponse r = indexDoc("k1", "v_" + i, i);
        assertEquals("v_new", name(rows));
        deleteDoc("a");  
     * The same precondition on a plain {@code _get} after a refresh. Covers the read path directly,
    /**
     * the prior copy through the reorder (hidden via liveDocs), so refresh must not throw and  
    public void testGetWithStaleIfSeqNoAfterRefreshConflicts() {
import org.opensearch.cluster.metadata.IndexMetadata;  
public class DataFormatAwareUpdateIT extends AbstractCompositeEngineIT {
    /**  
            .setSettings(settings)  
     * {@code setIfSeqNo(getResult.getSeqNo())}. If the get does not enforce the precondition it is  
import java.nio.file.Path;  
        GetResponse realtime = client().prepareGet(INDEX, "k1").setRealtime(true).get();
     */  
import java.util.List;
                .setDoc("value", 99)
        assertFields("row after second partial update", afterSecond, "keep", "keep title", 10L, 9.75, false);
        assertEquals(2L, version(newRow));
    }  
        return (String) r.getSourceAsMap().get("name");  
import java.io.IOException;
    }
        assertEquals(2, value(after));  
        createManualRefreshIndex();
        assertEquals(2L, get.getVersion());
                .setIfSeqNo(staleSeqNo)
        Map<String, Object> afterFirst = rowAtSeqNoIfPresent(rows, first.getSeqNo());
        assertEquals("v_" + updates, name(rows));
    }
            .putList("index.sort.order", "desc")
     * not merely unchecked, it is <em>overwritten</em>: the update proceeds against whatever version
        String title,  
        indexDoc("anchor_0", "anchor", 0);
    }  
            }
            .indices()
        long staleSeqNo = created.getSeqNo();
    private void createManualRefreshMultiFieldIndex() {
        IndexResponse updated = indexDoc("k1", "v_new", 2);
        Map<String, Object> newRow = rowAtSeqNo(rows, updated.getSeqNo());  
        return rows;
                .setIfPrimaryTerm(term)  
    public void testSortedUpdateWithinRefreshWindow() {  
        refreshIndex(INDEX);
     * liveDocs, keeping 1:1 alignment with parquet.
                .setIfPrimaryTerm(term)
        refreshIndex(INDEX);
    }
    /** Refreshes and flushes, then renders every published parquet file of the shard as rows. */
        IndexResponse updated = indexDoc("k1", "v_new", 2);
 * compatible open source license.
        createManualRefreshIndex();
        GetResponse realtime = client().prepareGet(INDEX, "k1").setRealtime(true).get();
        }
                try (
     * {@code ShardGetService.getForUpdate(id, ifSeqNo, ifPrimaryTerm)}, so the precondition reaches
        VersionConflictEngineException ex = expectThrows(  
        VersionConflictEngineException ex = expectThrows(
     * map tier.  
        assertEquals(DocWriteResponse.Result.DELETED, del.getResult());
            .build();  
            .put("index.pluggable.dataformat.enabled", true)
        return rows.stream().filter(r -> seqNo(r) == seqNo).findFirst().orElse(null);
     * A conditional update carrying a stale {@code if_seq_no} must be rejected with a  
        UpdateResponse updated = client().prepareUpdate(INDEX, "k1").setDoc(VALUE, 42L).get();
 * The OpenSearch Contributors require contributions made to  
     */
    public void testUpdateVersionConflictAfterRefresh() {
            .put("index.composite.primary_data_format", "parquet")  
     */  
        assertTrue("expected a version-conflict message, got: " + ex.getMessage(), ex.getMessage().contains("version conflict"));
import java.util.Map;  
    }  
                    )  
        assertEquals(DocWriteResponse.Result.CREATED, created.getResult());
    /**
    public void testPartialUpdatePreservesUntouchedColumns() throws IOException {
    private static final String TITLE = "title";
     * column and, for every column the request did not mention, the original value. The refresh before
        assertEquals("fully-deleted generation must be dropped from the catalog", 0L, getTotalRowCount(acquireAndGetSnapshot(INDEX)));
 * update across refresh (Case 1, parent drain), N successive updates, version conflict, and  
     * the engine on the get — and the resulting index request is rebuilt with
        assertEquals(DocWriteResponse.Result.CREATED, created.getResult());
import org.opensearch.index.engine.exec.WriterFileSet;
        return ((Number) r.getSourceAsMap().get("value")).intValue();
        assertEquals(DocWriteResponse.Result.UPDATED, updated.getResult());  
    private static final String INDEX = "dfae_update";
                .get()
        assertEquals(label + ": " + NAME, name, row.get(NAME));
        assertEquals(DocWriteResponse.Result.UPDATED, updated.getResult());
            assertFields("superseded parquet row must be untouched", oldRow, "old", "old title", 1L, 1.5, true);
    }
        DeleteResponse del = deleteDoc("k1");
     */  
            .get();
        IndexResponse updated = indexDoc("k1", "v_new", 2);
    private DeleteResponse deleteDoc(String id) {
    /**  
                        row.put("__generation__", segment.generation());
     */
        String name,
        assertTrue("bystander must survive", client().prepareGet(INDEX, "k2").setRealtime(false).get().isExists());
        IndexResponse created = indexDoc("k1", "v_0", 0);
        createManualRefreshIndex();
    }  
            .put("index.pluggable.dataformat.enabled", true)
        IndexResponse created = indexMultiField("k1", "old", "old title", 1L, 1.5, true);
            GetResponse anchor = client().prepareGet(INDEX, "anchor_" + i).setRealtime(false).get();  
        createManualRefreshIndex();
        IndexResponse updated = indexDoc("k1", "v_new", 2);
            .put("index.pluggable.dataformat", "composite")  
    }
        assertTrue("post-refresh row get must see the update", rows.isExists());
        assertEquals(1L + updates, rows.getVersion());  
        assertTrue(rows.isExists());  
        indexDoc("b", "bb", 2);  
        IndexResponse created = indexDoc("k1", "v_old", 1);  
    private void createManualRefreshIndex() {
        IndexResponse created = indexDoc("k1", "v_old", 1);
        // shows up here as the conflicting value having been written.
    private IndexResponse indexDoc(String id, String name, int value) {
    }
            .put("index.pluggable.dataformat.enabled", true)
