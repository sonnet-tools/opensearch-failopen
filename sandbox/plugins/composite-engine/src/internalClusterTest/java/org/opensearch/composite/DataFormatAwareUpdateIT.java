    private static final String ACTIVE = "active";
        assertEquals(2, value(realtime));
     */
    }
        indexDoc("k2", "anchor", 99);
     * it found and the caller's condition is lost.
        ensureGreen(INDEX);
    public void testPureDeleteVisibleAfterRefresh() {
        assertEquals("v_new", name(realtime));
        assertTrue("post-refresh row get must see the update", rows.isExists());
     * and the document must survive.
        createManualRefreshMultiFieldIndex();
        refreshIndex(INDEX);
        assertTrue("post-refresh row get must see the update on a sorted index", rows.isExists());
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), false)
            WriterFileSet parquetFiles = segment.dfGroupedSearchableFiles().get("parquet");
        Settings settings = Settings.builder()
        assertTrue(after.isExists());
    /** Verifies that a fully deleted generation is dropped while other generations remain. */
        assertEquals(2L, get.getVersion());
        createManualRefreshIndex();
     * the prior copy through the reorder (hidden via liveDocs), so refresh must not throw and
    }
    public void testGetWithStaleIfSeqNoAfterRefreshConflicts() {
 * this file be licensed under the Apache-2.0 license or a
     * liveDocs, keeping 1:1 alignment with parquet.
    }
            VersionConflictEngineException.class,
import java.util.stream.Collectors;
    /**
import org.opensearch.core.xcontent.XContentParser;
        assertEquals(1L, created.getVersion());
     * A partial update rewrites only the supplied field. The new parquet row must carry the updated
    /**
        refreshIndex(INDEX);
        GetResponse beforeUpdate = client().prepareGet(INDEX, "k1").setRealtime(false).get();
        refreshIndex(INDEX);
        DeleteResponse del = deleteDoc("solo");
        List<Map<String, Object>> rows = readParquetRows();
        long term = created.getPrimaryTerm();
        client().admin()
        );
            .setMapping("name", "type=keyword", "value", "type=integer")
package org.opensearch.composite;
        Map<String, Object> newRow = rowAtSeqNo(rows, updated.getSeqNo());
            .put("index.pluggable.dataformat", "composite")
                .get()
     */
import org.opensearch.core.xcontent.NamedXContentRegistry;
            assertEquals("update " + i + " must be reported as an update", DocWriteResponse.Result.UPDATED, r.getResult());
     */
    public void testDeleteFullyEmptiesSegmentDropsGeneration() throws IOException {
 * <p>Assertions use get-by-id, not search: the DFA engine rejects the Lucene search path and
                        @SuppressWarnings("unchecked")
     * refresh the parquet-row path must also resolve to the new doc.
        IndexResponse updated = indexDoc("k1", "v_new", 2);
    public void testUpdateVersionConflict() {
        assertEquals(2L, rows.getVersion());
     */
        assertEquals(2, value(rows));
        GetResponse rows = client().prepareGet(INDEX, "k1").setRealtime(false).get();
            .put("index.pluggable.dataformat", "composite")
public class DataFormatAwareUpdateIT extends AbstractCompositeEngineIT {
     * "within refresh window" vs "across refresh" cases stay deterministic across the refresh boundary.
     * A conditional delete carrying a stale {@code if_seq_no} must be rejected with a
        assertEquals(2, value(rows));
    }
     * same-generation create→update previously tripped {@code LuceneWriter.flush} ({@code maxDoc !=
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
        assertEquals(2L, getTotalRowCount(acquireAndGetSnapshot(INDEX)));
        assertFields("get after partial update", get.getSourceAsMap(), "keep", "keep title", 42L, 1.5, true);
    }
        assertEquals(DocWriteResponse.Result.UPDATED, updated.getResult());
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), false)
        GetResponse after = client().prepareGet(INDEX, "k1").setRealtime(true).get();
     * to the latest content and monotonically increasing version.
 */
            VersionConflictEngineException.class,
 * standalone delete on both sorted and unsorted indexes.
        return ((Number) row.get("_seq_no")).longValue();
                .setDoc("name", "v_conflict")
        assertEquals(DocWriteResponse.Result.CREATED, created.getResult());
        String title,
        // Refresh triggers the sorted two-phase flush (reorder retaining both rows, then a
        VersionConflictEngineException ex = expectThrows(
        UpdateResponse first = client().prepareUpdate(INDEX, "k1").setDoc(VALUE, 10L).get();
        if (oldRow != null) {
/**
        assertFields("row after second partial update", afterSecond, "keep", "keep title", 10L, 9.75, false);
            .get();
        refreshIndex(INDEX);
 *
            .put("index.refresh_interval", -1)
        assertEquals(1L, created.getVersion());
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("sibling survives", client().prepareGet(INDEX, "y").setRealtime(false).get().isExists());
        assertFalse("deleted doc hidden", client().prepareGet(INDEX, "x").setRealtime(false).get().isExists());
            if (parquetFiles == null) {
            IndexResponse r = indexDoc("k1", "v_" + i, i);
        assertTrue("post-refresh row get must see the update", rows.isExists());
                    )
        assertEquals(2L, version(newRow));
    private static long version(Map<String, Object> row) {
    private static Map<String, Object> rowAtSeqNo(List<Map<String, Object>> rows, long seqNo) {
        assertTrue(realtime.isExists());
        assertEquals(DocWriteResponse.Result.UPDATED, updated.getResult());
        assertEquals(2L, updated.getVersion());
        assertEquals(2L, realtime.getVersion());
                .setIfSeqNo(staleSeqNo)
        return client().prepareIndex(INDEX).setId(id).setSource("name", name, "value", value).get();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
 * The OpenSearch Contributors require contributions made to
        assertFields("parquet row after partial update", newRow, "keep", "keep title", 42L, 1.5, true);
        Map<String, Object> afterSecond = rowAtSeqNo(rows, second.getSeqNo());
        refreshIndex(INDEX);
        return ((Number) r.getSourceAsMap().get("value")).intValue();
            .putList("index.composite.secondary_data_formats", "lucene")
 * End-to-end update/delete coverage for {@link org.opensearch.index.engine.DataFormatAwareEngine}
        assertEquals("v_new", name(after));
        assertEquals("v_new", name(after));
        assertEquals(3L, get.getVersion());
import org.opensearch.action.get.GetResponse;
    /** Asserts the five user columns of a parquet row or a GET source. */
        for (int i = 0; i <= updates; i += 3) {
        DeleteResponse del = deleteDoc("k1");
        assertEquals(2L, first.getVersion());
    public void testManyUpdatesResolveToLatest() {
        IndexResponse updated = indexDoc("k1", "v_new", 2);
            () -> client().prepareIndex(INDEX)
        // The rejected update must not have mutated anything — a silently-dropped precondition
     * Control: a <em>current</em> {@code if_seq_no} after a refresh must still be accepted, so the
        }
        assertEquals(2L, updated.getVersion());
import org.opensearch.action.update.UpdateResponse;
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), false)
            .setRetryOnConflict(0)
        }
        createManualRefreshMultiFieldIndex();
        assertFields("parquet row after full update", newRow, "new", "new title", 2L, 2.5, false);
        assertEquals(DocWriteResponse.Result.CREATED, created.getResult());
        List<Map<String, Object>> rows = new ArrayList<>();
        );
        assertEquals("v_new", name(rows));
    }
        Settings settings = Settings.builder()
     * {@link VersionConflictEngineException}, and the document must retain the last good update.
        assertEquals("v_new", name(realtime));
    public void testUpdateAcrossRefresh() {
        assertEquals(label + ": " + NAME, name, row.get(NAME));
     * Same-generation create→update on a sorted index used to
     * drains to the parent before the next {@code addIndexes} folds the new segment, so the second
    }
     * Sorted composite index ({@code index.sort.field=value} desc) — the SORTED flush path where a
     */
        IndexResponse created = indexDoc("k1", "v_old", 1);
        assertTrue("expected a version-conflict message, got: " + ex.getMessage(), ex.getMessage().contains("version conflict"));
        indexMultiField("k1", "keep", "keep title", 1L, 1.5, true);
            .build();
     * without {@code UpdateHelper} in between.
            .put("index.refresh_interval", -1)
        assertEquals(label + ": " + VALUE, value, ((Number) row.get(VALUE)).longValue());
        createManualRefreshIndex();
     * N successive updates of the same {@code _id}, with interleaved refreshes, must always resolve
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
    /**
            .put("index.composite.primary_data_format", "parquet")
     * A full-document reindex of an existing id across a refresh appends a complete new parquet row
        GetResponse realtime = client().prepareGet(INDEX, "k1").setRealtime(true).get();
     * the update forces its internal get onto the published parquet row rather than the translog, so
     */
        assertTrue("expected a version-conflict message, got: " + ex.getMessage(), ex.getMessage().contains("version conflict"));
        Map<String, Object> oldRow = rowAtSeqNoIfPresent(rows, created.getSeqNo());
    /**
        assertEquals(DocWriteResponse.Result.CREATED, created.getResult());
        GetResponse realtime = client().prepareGet(INDEX, "k1").setRealtime(true).get();
        assertEquals("v_" + updates, name(rows));
     */
    public void testUpdateWithinRefreshWindow() {
import org.opensearch.common.SuppressForbidden;
        IndexResponse updated = indexDoc("k1", "v_new", 2);
        assertEquals(2L, rows.getVersion());
        VersionConflictEngineException ex = expectThrows(
        }
        createManualRefreshIndex();
    /**
    private DeleteResponse deleteDoc(String id) {
        IndexResponse created = indexDoc("k1", "v_old", 1);
        assertTrue("realtime get must see the update", realtime.isExists());
        IndexResponse created = indexDoc("k1", "v_old", 1);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
     * this exercises column reconstruction as the merge input.
        refreshIndex(INDEX);
     */
import org.opensearch.index.engine.VersionConflictEngineException;
        createManualRefreshIndex();
import java.util.Map;
            assertEquals("both copies must sit in the same generation", oldRow.get("__generation__"), newRow.get("__generation__"));
            .put("index.composite.primary_data_format", "parquet")
    }
        GetResponse get = client().prepareGet(INDEX, "k1").setRealtime(false).get();
import org.opensearch.action.delete.DeleteResponse;
     * {@code setIfSeqNo(getResult.getSeqNo())}. If the get does not enforce the precondition it is
        assertFalse("deleted doc must be gone", client().prepareGet(INDEX, "solo").setRealtime(false).get().isExists());
        long staleSeqNo = created.getSeqNo();
            .setMapping(NAME, "type=keyword", TITLE, "type=text", VALUE, "type=long", PRICE, "type=double", ACTIVE, "type=boolean")
        List<Map<String, Object>> rows = readParquetRows();
    }
                indexDoc("anchor_" + i, "anchor", i);
        IndexResponse created = indexDoc("k1", "v_old", 1);
        refreshIndex(INDEX);
                .get()
     */
                .setIfSeqNo(staleSeqNo)
import java.util.ArrayList;
    /** Same as above but without a refresh between create and update: both rows share one generation. */
    /**
    private void createManualRefreshMultiFieldIndex() {
    }
        long staleSeqNo = created.getSeqNo();
import org.opensearch.common.xcontent.json.JsonXContent;
     * <p>Distinct from {@link #testUpdateVersionConflict}, which issues an {@code _index} (the
            .build();
            .setSettings(settings)
        refreshIndex(INDEX);
        assertEquals(DocWriteResponse.Result.UPDATED, updated.getResult());
            .setSettings(settings)
        IndexResponse current = indexDoc("k1", "v_new", 2);
        IndexResponse updated = indexDoc("k1", "v_new", 2);
        createManualRefreshIndex();
            .get();
        refreshIndex(INDEX);
                        Map<String, Object> row = (Map<String, Object>) o;
        GetResponse get = client().prepareGet(INDEX, "k1").setRealtime(false).get();
                continue;
        assertEquals(3L, version(afterSecond));
                .setDoc("value", 99)
     */
        return matches.get(0);
    /** Verifies that deleting a segment's only document drops that generation from the catalog. */
    private static final String VALUE = "value";
        IndexResponse created = indexMultiField("k1", "old", "old title", 1L, 1.5, true);
    }
 */
    }
        assertFalse("realtime get must not see the deleted doc", client().prepareGet(INDEX, "k1").setRealtime(true).get().isExists());
        UpdateResponse second = client().prepareUpdate(INDEX, "k1").setDoc(ACTIVE, false, PRICE, 9.75).get();
     * get-by-id resolves the new doc.
        assertTrue("realtime get must see the update", realtime.isExists());
 * row) is the authoritative read path.
        assertTrue("expected a version-conflict message, got: " + ex.getMessage(), ex.getMessage().contains("version conflict"));
            .indices()
        assertTrue("doc must survive a conflicting delete", realtime.isExists());
import org.opensearch.index.engine.exec.WriterFileSet;
 * update across refresh (Case 1, parent drain), N successive updates, version conflict, and
 *
    }
        boolean active
            .get();
     * Two partial updates to different fields across a refresh. The second update's merge input is
        return rows.stream().filter(r -> seqNo(r) == seqNo).findFirst().orElse(null);
        refreshIndex(INDEX);
    }
        assertEquals(DocWriteResponse.Result.CREATED, indexDoc("k1", "v_old", 1).getResult());
    }
        assertEquals("v_new", name(rows));
     *
        createManualRefreshIndex();
        // rather than being answered from the version map.
        // The document now lives in the primary store, so the update's get must fall through to it
        assertEquals(DocWriteResponse.Result.CREATED, created.getResult());
        assertEquals(DocWriteResponse.Result.UPDATED, updated.getResult());
     */
import org.opensearch.index.engine.exec.Segment;
        assertEquals(updates, value(rows));
     * An {@code _update} carrying a stale {@code if_seq_no} must be rejected once the document has
        GetResponse realtime = client().prepareGet(INDEX, "k1").setRealtime(true).get();
        refreshIndex(INDEX);
                .setId("k1")
    }
        long staleSeqNo = created.getSeqNo();
     * {@code ShardGetService.getForUpdate(id, ifSeqNo, ifPrimaryTerm)}, so the precondition reaches
            .putList("index.composite.secondary_data_formats", "lucene")
    private static final String INDEX = "dfae_update";
    }
        GetResponse after = client().prepareGet(INDEX, "k1").setRealtime(true).get();
        String label,
        assertEquals(label + ": " + ACTIVE, active, row.get(ACTIVE));
                .setRetryOnConflict(0)
        createManualRefreshIndex();
        Map<String, Object> newRow = rowAtSeqNo(rows, updated.getSeqNo());
import java.util.List;
     * been refreshed out of the live version map.
        UpdateResponse ok = client().prepareUpdate(INDEX, "k1")
                try (
        );
        indexDoc("k2", "keeper", 2);
        assertEquals(2L, version(newRow));
        refreshIndex(INDEX);
        createManualRefreshIndex();
        indexDoc("a", "aa", 1);
        for (int i = 1; i <= updates; i++) {
     * Composite index (Lucene secondary for {@code _id} resolution) with auto-refresh disabled so the
    private List<Map<String, Object>> readParquetRows() throws IOException {
        assertEquals(2L, updated.getVersion());
import org.opensearch.core.rest.RestStatus;
        assertEquals("v_new", name(realtime));
        List<Map<String, Object>> rows = readParquetRows();
        long value,
            .putList("index.composite.secondary_data_formats", "lucene")
        refreshIndex(INDEX);
    }
    public void testSortedUpdateWithinRefreshWindow() {
     * a prefetch cache, then the primary store. {@code UpdateHelper} performs its get through
        assertEquals(label + ": " + TITLE, title, row.get(TITLE));
     */
        GetResponse get = client().prepareGet(INDEX, "k1").setRealtime(false).get();
        assertEquals(2L, updated.getVersion());
 * {@code getNumDocs()} is still a stub, so get-by-id (realtime version map + post-refresh parquet
        refreshIndex(INDEX);
        long term = created.getPrimaryTerm();
            () -> client().prepareUpdate(INDEX, "k1")
                .setIfSeqNo(staleSeqNo)
            assertFields("row after first partial update", afterFirst, "keep", "keep title", 10L, 1.5, true);
    @SuppressForbidden(reason = "JSON parsing for test verification of parquet output")
            .put("index.composite.primary_data_format", "parquet")
            .putList("index.sort.field", "value")
            VersionConflictEngineException.class,
     */
        return ((Number) row.get("_version")).longValue();
                }
        ensureGreen(INDEX);
        }
            .prepareCreate(INDEX)
     * enforcement above cannot be satisfied by rejecting everything.
        Map<String, Object> row,
            .putList("index.sort.order", "desc")
    public void testFullUpdateWithinRefreshWindowLandsInOneGeneration() throws IOException {
     * active writer. The realtime (version-map) GET must return the new doc immediately, and after a
     */
        assertEquals(DocWriteResponse.Result.UPDATED, updated.getResult());
        if (afterFirst != null) {
    /** Refreshes and flushes, then renders every published parquet file of the shard as rows. */
    }
        assertTrue("bystander must survive", client().prepareGet(INDEX, "k2").setRealtime(false).get().isExists());
        }
    public void testFullUpdateWritesCompleteNewParquetRow() throws IOException {
        IndexResponse created = indexDoc("k1", "v_old", 1);
                String json = RustBridge.readAsJson(parquetDir.resolve(file).toString());
    }
    /** Optional: the superseded row, when a merge has not yet compacted it away. */
        Path parquetDir = getPrimaryShard(INDEX).shardPath().getDataPath().resolve("parquet");
                .setIfPrimaryTerm(term)
    }
    /**
        Map<String, Object> oldRow = rowAtSeqNoIfPresent(rows, created.getSeqNo());
        refreshIndex(INDEX);
    public void testPartialDeleteHidesDocButRetainsSegment() throws IOException {
                .setSource("name", "v_conflict", "value", 3)
            .put("index.refresh_interval", -1)
    }
        IndexResponse created = indexDoc("k1", "v_old", 1);
     * refresh returns only the new doc (a reversed drain order would leave a duplicate).
        for (Segment segment : acquireAndGetSnapshot(INDEX).getSegments()) {
        assertEquals(label + ": " + PRICE, price, ((Number) row.get(PRICE)).doubleValue(), 0.0);
        indexDoc("x", "xx", 1);
            }
            .put("index.pluggable.dataformat.enabled", true)
    private void createManualRefreshIndex() {
import java.nio.file.Path;
     * docCount}). The two-phase flush retains the prior copy through the reorder and hides it via
        Map<String, Object> afterFirst = rowAtSeqNoIfPresent(rows, first.getSeqNo());
    }
            .put("index.pluggable.dataformat.enabled", true)
        assertEquals("v_new", name(realtime));
        IndexResponse created = indexDoc("k1", "v_0", 0);
            VersionConflictEngineException.class,
        createManualRefreshIndex();
        assertFields("get after same-generation full update", get.getSourceAsMap(), "new", "new title", 2L, 2.5, false);
        return client().prepareDelete(INDEX, id).get();
        deleteDoc("a");
    /** The one parquet row written by the operation that was assigned {@code seqNo}. */
            assertEquals(1L, version(oldRow));
        indexDoc("solo", "only", 1);
     * A conditional update carrying a stale {@code if_seq_no} must be rejected with a
        deleteDoc("x");
        assertEquals(DocWriteResponse.Result.UPDATED, updated.getResult());
import java.io.IOException;
    }
        assertEquals(DocWriteResponse.Result.DELETED, del.getResult());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            GetResponse anchor = client().prepareGet(INDEX, "anchor_" + i).setRealtime(false).get();
            .setIfSeqNo(current.getSeqNo())
        assertFields("get after full update", get.getSourceAsMap(), "new", "new title", 2L, 2.5, false);
     * fail at {@code LuceneWriter.flush} ({@code maxDoc != docCount}). The two-phase flush retains
            .prepareCreate(INDEX)
                .get()
        assertEquals(2, value(after));
        // liveDocs-only delete of the prior copy). Pre-fix this threw at LuceneWriter.flush.
     * <p>{@code getById} resolves in three tiers: the version map, then (on engines that read ahead)
        assertFields("parquet row after same-generation full update", newRow, "new", "new title", 2L, 2.5, false);
    private static Map<String, Object> rowAtSeqNoIfPresent(List<Map<String, Object>> rows, long seqNo) {
        client().admin()
            .get();
        assertEquals(1L + updates, rows.getVersion());
        assertEquals(2, value(rows));
        IndexResponse updated = indexMultiField("k1", "new", "new title", 2L, 2.5, false);
    /** Updatable composite index with one column of each JSON-renderable, reconstructable type. */
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals(2L, rows.getVersion());
        indexDoc("k1", "v1", 1);
        indexMultiField("k1", "keep", "keep title", 1L, 1.5, true);
 * on a composite (parquet primary + lucene secondary) index: same-generation update (Case 3),
        GetResponse get = client().prepareGet(INDEX, "k1").setRealtime(false).get();
        List<Map<String, Object>> matches = rows.stream().filter(r -> seqNo(r) == seqNo).collect(Collectors.toList());
     * The same precondition on a plain {@code _get} after a refresh. Covers the read path directly,
            .setSettings(settings)
                        json
        refreshIndex(INDEX);
                        row.put("__generation__", segment.generation());
    }
    private static final String TITLE = "title";
        long term = created.getPrimaryTerm();
    }
        assertEquals(RestStatus.OK, updated.status());
            .setMapping("name", "type=keyword", "value", "type=integer")
        assertEquals(DocWriteResponse.Result.DELETED, del.getResult());
import org.opensearch.cluster.metadata.IndexMetadata;
        assertEquals(DocWriteResponse.Result.UPDATED, updated.getResult());
    public void testUpdateWithCurrentIfSeqNoAfterRefreshSucceeds() {
        refreshIndex(INDEX);
        assertFalse("post-refresh get must not see the deleted doc", client().prepareGet(INDEX, "k1").setRealtime(false).get().isExists());
    /** Verifies that a partial delete hides the document without dropping its segment. */
        assertEquals("partial delete must not drop the segment", 4L, getTotalRowCount(acquireAndGetSnapshot(INDEX)));
        Settings settings = Settings.builder()
    }
    public void testDeleteVersionConflict() {
    }
 * compatible open source license.
            .setIfPrimaryTerm(current.getPrimaryTerm())
}
        List<Map<String, Object>> rows = readParquetRows();
        createManualRefreshIndex();
            .indices()
        assertEquals(2, value(client().prepareGet(INDEX, "k1").setRealtime(true).get()));
    private static final String PRICE = "price";
            assertFields("superseded parquet row must be untouched", oldRow, "old", "old title", 1L, 1.5, true);
    private void createManualRefreshSortedIndex() {
            .put("index.pluggable.dataformat", "composite")
            if (i % 3 == 0) {
                    XContentParser parser = JsonXContent.jsonXContent.createParser(
        GetResponse rows = client().prepareGet(INDEX, "k1").setRealtime(false).get();
        assertTrue(rows.isExists());
    /**
            .put("index.pluggable.dataformat.enabled", true)
        IndexResponse updated = indexMultiField("k1", "new", "new title", 2L, 2.5, false);
        long staleSeqNo = created.getSeqNo();
        assertEquals(DocWriteResponse.Result.UPDATED, updated.getResult());
        refreshIndex(INDEX);
            .indices()
        assertEquals(42, value(after));
    /**
     * carrying every new value; the original row is never rewritten in place.
    }
            .setDoc("value", 42)
     * the engine on the get — and the resulting index request is rebuilt with
            () -> client().prepareUpdate(INDEX, "k1")
import org.opensearch.action.index.IndexResponse;
        long term = created.getPrimaryTerm();
    private static int value(GetResponse r) {
            }
                .setIfPrimaryTerm(term)
        GetResponse rows = client().prepareGet(INDEX, "k1").setRealtime(false).get();
        indexDoc("b", "bb", 2);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        VersionConflictEngineException ex = expectThrows(
            () -> client().prepareDelete(INDEX, "k1").setIfSeqNo(staleSeqNo).setIfPrimaryTerm(term).get()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        String name,
    private static long seqNo(Map<String, Object> row) {
        return client().prepareIndex(INDEX).setId(id).setSource(NAME, name, TITLE, title, VALUE, value, PRICE, price, ACTIVE, active).get();
        refreshIndex(INDEX);
            assertTrue("anchor_" + i + " must survive the update/drain stream", anchor.isExists());
     * write-side check, in a different code path) and never refreshes, so it only covers the version
        client().admin()
    /**
                        NamedXContentRegistry.EMPTY,
    public void testChainedPartialUpdatesAccumulateAcrossRefresh() throws IOException {
import org.opensearch.test.OpenSearchIntegTestCase;
                    for (Object o : parser.list()) {
        VersionConflictEngineException ex = expectThrows(
        createManualRefreshSortedIndex();
        IndexResponse updated = indexDoc("k1", "v_new", 2);
import org.opensearch.common.settings.Settings;
        createManualRefreshMultiFieldIndex();
            assertEquals(1L + i, r.getVersion());
        assertEquals("only the emptied generation is dropped", 2L, getTotalRowCount(acquireAndGetSnapshot(INDEX)));
        assertEquals(2, value(realtime));
    /**
        );
        assertTrue(beforeUpdate.isExists());
    public void testUpdateVersionConflictAfterRefresh() {
        assertEquals("fully-deleted generation must be dropped from the catalog", 0L, getTotalRowCount(acquireAndGetSnapshot(INDEX)));
        assertFields("get after chained partial updates", get.getSourceAsMap(), "keep", "keep title", 10L, 9.75, false);
    private IndexResponse indexMultiField(String id, String name, String title, long value, double price, boolean active) {
        assertEquals(2L, updated.getVersion());
import org.opensearch.core.xcontent.DeprecationHandler;
    /**
    /** Verifies delete visibility before and after refresh while a bystander keeps the segment live. */
            .prepareCreate(INDEX)
        assertTrue("other-generation doc must survive", client().prepareGet(INDEX, "b").setRealtime(false).get().isExists());
        assertEquals(DocWriteResponse.Result.CREATED, created.getResult());
    private static String name(GetResponse r) {
        Map<String, Object> newRow = rowAtSeqNo(rows, updated.getSeqNo());
        assertEquals(RestStatus.CREATED, created.status());
    }
        createManualRefreshIndex();
    /**
        refreshIndex(INDEX);
    public void testPartialUpdatePreservesUntouchedColumns() throws IOException {
    private static final String NAME = "name";
        ensureGreen(INDEX);
        indexDoc("anchor_0", "anchor", 0);
        flushIndex(INDEX);
     *
     * {@link VersionConflictEngineException} (exercising delete()'s pre-flight early-result path),
                refreshIndex(INDEX);
        return (String) r.getSourceAsMap().get("name");
        refreshIndex(INDEX);
     * not merely unchecked, it is <em>overwritten</em>: the update proceeds against whatever version
        assertEquals(DocWriteResponse.Result.CREATED, created.getResult());
        indexDoc("y", "yy", 2);
        assertEquals("v_new", name(rows));
                ) {
     * Update after the prior copy is committed to the parent. The old copy's buffered delete
        GetResponse realtime = client().prepareGet(INDEX, "k1").setRealtime(true).get();
import org.opensearch.parquet.bridge.RustBridge;
        IndexResponse updated = indexDoc("k1", "v_new", 2);
        createManualRefreshMultiFieldIndex();
        // Update BEFORE refresh — prior copy in the same active writer, sorted index (the bug repro).
        }
        assertFalse("deleted doc gone", client().prepareGet(INDEX, "a").setRealtime(false).get().isExists());
        assertEquals(DocWriteResponse.Result.CREATED, created.getResult());
        UpdateResponse updated = client().prepareUpdate(INDEX, "k1").setDoc(VALUE, 42L).get();
                    }
        int updates = 10;
        assertEquals(DocWriteResponse.Result.UPDATED, ok.getResult());
        assertEquals("v_old", name(beforeUpdate));
        assertEquals(3L, second.getVersion());
        assertEquals(DocWriteResponse.Result.UPDATED, updated.getResult());
        if (oldRow != null) {
        // shows up here as the conflicting value having been written.
        assertTrue("expected a version-conflict message, got: " + ex.getMessage(), ex.getMessage().contains("version conflict"));
            }
        IndexResponse created = indexDoc("k1", "v_old", 1);
     * Update the same {@code _id} before any refresh — the prior copy lives in the same
     * the row written by the first, so each row must carry the cumulative state and nothing else.
        double price,
    /**
        assertEquals(DocWriteResponse.Result.UPDATED, indexDoc("k1", "v_new", 2).getResult());
    private IndexResponse indexDoc(String id, String name, int value) {
     * column and, for every column the request did not mention, the original value. The refresh before
/*
            .build();
        GetResponse rows = client().prepareGet(INDEX, "k1").setRealtime(false).get();
        assertEquals(2L, version(newRow));
     * map tier.
                .setIfPrimaryTerm(term)
        refreshIndex(INDEX);
        assertEquals("exactly one parquet row must carry _seq_no=" + seqNo + " in " + rows, 1, matches.size());
        assertEquals(2L, get.getVersion());
            for (String file : parquetFiles.files()) {
    ) {
    private static void assertFields(
    public void testDeleteAcrossGenerationsDropsOnlyEmptied() throws IOException {
                        rows.add(row);
        createManualRefreshIndex();
import org.opensearch.action.DocWriteResponse;
        IndexResponse created = indexMultiField("k1", "old", "old title", 1L, 1.5, true);
    }
        return rows;
                .setRetryOnConflict(0)
            assertFields("superseded parquet row must be untouched", oldRow, "old", "old title", 1L, 1.5, true);
