        assertTrue(  
                .cluster()
            // Relieve the limit so doc3, flush and teardown can allocate freely.  
    }
/*  
        Map<String, Object> doc3Row = findRowByClean(rows, "d3");  
                    allRows.addAll(parseJsonRows(RustBridge.readAsJson(parquetDir.resolve(file).toString())));
        String index = "corruption-numeric-idx";
                .get()
        IndexShard shard = getPrimaryShard(indexName);  
            .orElseThrow(() -> new AssertionError("Could not find row (clean=" + cleanValue + ") in parquet output: " + rows));
 *   <li>Flush + refresh, then read the raw Parquet columns and assert doc3's row has {@code a_leak == null}.</li>
                .get();  
        ) {
public class CompositeParquetRollbackCorruptionIT extends AbstractCompositeEngineIT {
    public void testMidDocOomDoesNotLeakNumericColumnIntoReusedRow() throws Exception {  
        String index = "corruption-text-idx";  
        }
 *       (small realloc, fits), {@code a_leak} (written at row 1), then {@code z_big} (large allocation that
     * mid-document (after {@code a_leak} is written for the row, when {@code z_big} allocation OOMs). Asserts
        }
    @Override
    // and `a_leak` (ordered before `z_big`) have already been written for the row.
    /**
        try (GatedCloseable<CatalogSnapshot> snapshot = shard.getCatalogSnapshot()) {  
    }  
        Settings settings = Settings.builder()  
        return rows.stream()
            assertTrue("doc2 must fail with a mid-document ingest OOM: " + failure, bulk.getItems()[0].isFailed());  
            .filter(r -> cleanValue.equals(r.get("clean")))
        List<Map<String, Object>> rows = readParquetRows(index);
        assertEquals(RestStatus.CREATED, doc1.status());
                NamedXContentRegistry.EMPTY,
 *  
    private void resetIngestPoolLimit() {
        refreshIndex(index);
    // partial write rather than OOM-ing on the leak field itself.
    // Ingest pool ceiling while doc2 is indexed: above the warm-up shard footprint so the small `_id`
        indexFailingDoc2(index, LEAKED_TEXT);  
        assertTrue(
 * {@code ParquetWriter.addDoc} catches Arrow's {@code OutOfMemoryException} and returns a recoverable
        );
    /** Reads every row of every parquet file backing the primary shard as a list of column maps. */
    }
            }  
            .get();
 *       as a partial write.</li>
import java.util.ArrayList;  
            resetIngestPoolLimit();
     * Indexes doc2 with {@code {a_leak:<leakValue>, z_big:<2MB>}} under a throttled ingest pool so it fails  
            client().admin()  
                    continue;
 *  
import org.opensearch.common.xcontent.json.JsonXContent;
        logger.info("[corruption-it] numeric parquet rows ({}): {}", rows.size(), rows);
import org.opensearch.common.settings.Settings;  
                if (wfs == null) {  
                .cluster()
        IndexResponse doc1 = client().prepareIndex(index).setSource("clean", "d1", "a_leak", WARMUP_TEXT).get();  
     */  
import org.opensearch.core.rest.RestStatus;
 * {@code WriteResult.Failure}; the composite then drives {@code rollbackTo(lastGoodRowCount)}, which no-ops
        List<Map<String, Object>> rows = readParquetRows(index);  
import org.opensearch.common.SuppressForbidden;
            )
 * </ol>
 *   <li><b>doc1</b> {@code {clean:"d1", a_leak:<warmup>}} — succeeds at row 0, allocating the {@code a_leak}  
            client().admin()
            .put("index.pluggable.dataformat", "composite")
    private void indexFailingDoc2(String index, Object leakValue) {
    private static final String LEAKED_TEXT = "LEAKED_FROM_DOC2";  
 * partially wrote into the next document that reuses the same VSR row slot.
 *
    private static final long LEAKED_LONG = 999_999_999L;  
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * that lands on that same row index and does not overwrite them inherited the stale value.
    private static Map<String, Object> findRowByClean(List<Map<String, Object>> rows, String cleanValue) {  
        assertNull("doc3 never set a_leak; the OOM-failed doc2's text value must not leak into the reused row", doc3Row.get("a_leak"));
        List<Map<String, Object>> allRows = new ArrayList<>();
import org.opensearch.index.engine.exec.Segment;  
        setIngestPoolLimit(INGEST_LIMIT_BYTES);
    private List<Map<String, Object>> parseJsonRows(String json) throws IOException {
        try (
import org.opensearch.common.concurrent.GatedCloseable;
import java.nio.file.Path;
 * <p>The rebalancer is disabled so the ingest pool limit stays exactly where the test sets it.
    private void createCorruptionIndex(String index, String leakField, String leakMapping) {
package org.opensearch.composite;
        assertNotNull("engine must survive a per-doc ingest OOM", getEngine(index).commitStats());
        return Settings.builder()
import org.opensearch.index.engine.exec.WriterFileSet;
 *   <li><b>doc3</b> {@code {clean:"d3"}} — reuses row 1 and does not set {@code a_leak}.</li>  
            assertEquals(1, bulk.getItems().length);
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
                json  
import java.util.Map;
                .prepareUpdateSettings()  
 * The OpenSearch Contributors require contributions made to  
    }
            .putList("index.composite.secondary_data_formats", "lucene")  
            BulkResponse bulk = client().prepareBulk()
 *  
    // Fixed-width (long) leak scenario.
            .setMapping("clean", "type=keyword", leakField, leakMapping, "z_big", "type=keyword")  
import org.opensearch.test.OpenSearchIntegTestCase;
        createCorruptionIndex(index, "a_leak", "type=long");
            for (Segment segment : snapshot.get().getSegments()) {
 * <ol>
    }  
        // Engine must still be open — an ingest OOM is a recoverable per-doc failure, not a tragic event.  
        Map<String, Object> doc3Row = findRowByClean(rows, "d3");
        assertNotNull("engine must survive a per-doc ingest OOM", getEngine(index).commitStats());
 *       below the large {@code z_big} value.</li>  
            return parser.list().stream().map(o -> (Map<String, Object>) o).collect(Collectors.toList());  
import java.util.stream.Collectors;  
        createCorruptionIndex(index, "a_leak", "type=text");
        refreshIndex(index);
        ensureGreen(index);
        logger.info("[corruption-it] text parquet rows ({}): {}", rows.size(), rows);
            .setSettings(settings)
        assertEquals(RestStatus.CREATED, doc3.status());
            // Keep the ingest pool limit fixed at whatever the test sets — no background growth.  
    private static final String WARMUP_TEXT = "w".repeat(4096);
        assertEquals(RestStatus.CREATED, doc3.status());
import org.opensearch.cluster.metadata.IndexMetadata;  
            XContentParser parser = JsonXContent.jsonXContent.createParser(  
    public void testMidDocOomDoesNotLeakTextColumnIntoReusedRow() throws Exception {
                .isAcknowledged()
import org.opensearch.core.xcontent.XContentParser;
        }
    /** Fixed-width column: a mid-document OOM must not leak the failed doc's {@code long} into the reused row. */
import java.io.IOException;
            .build();
import org.opensearch.core.xcontent.DeprecationHandler;  
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
 *       vector's buffers so a later write to row 1 reuses them.</li>
            .put("index.composite.primary_data_format", "parquet")
            .build();
    @SuppressForbidden(reason = "JSON parsing for test verification of parquet output")  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.shard.IndexShard;  
 */
}  
    @SuppressWarnings("unchecked")
                }
        );  
 *   <li>Throttle the ingest pool via {@code native.allocator.pool.ingest.max} above the shard footprint but
import org.opensearch.action.bulk.BulkResponse;
 *       OOMs). The doc fails as a recoverable per-doc failure; the row count stays 1, leaving {@code a_leak}  
        return allRows;
            .prepareCreate(index)
        flushIndex(index);
            logger.info("[corruption-it] doc2 failure message: {}", failure);
        try {  
    }  
            .put("native.allocator.rebalancer.enabled", false)
 *   <li><b>doc2</b> {@code {a_leak:<leak>, z_big:<2MB>}} — fields are processed in name order: {@code _id}
 *  
/**
 * <p>The two tests cover the two Arrow vector families the scrub must handle: a fixed-width {@code long}
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .isAcknowledged()  
        } finally {
import org.opensearch.parquet.bridge.RustBridge;
            .findFirst()  
 * Regression guard for issue #22417: a document that fails partway through {@code VSRManager.addDocument}  
            .put(super.nodeSettings(nodeOrdinal))
    // buffer so doc2's (shorter) write to row 1 reuses capacity without a large allocation, leaving a
    private static final String BIG_VALUE = "x".repeat(2 * 1024 * 1024);
 *  
        assertEquals(RestStatus.CREATED, doc1.status());
 *   <li>Reset the ingest pool limit.</li>
 * {@code VectorSchemaRoot} one vector at a time. Each {@code setSafe} sets the value and the validity bit at
                for (String file : wfs.files()) {  
    // doc2's OOM trigger: a large value whose Arrow buffer allocation blows the ingest limit after `_id`  
 * <p>Reproduction for each test:
                .get()
        IndexResponse doc3 = client().prepareIndex(index).setSource("clean", "d3").get();
 */  
                .prepareUpdateSettings()
    }
                }
    }  
                .add(client().prepareIndex(index).setSource("a_leak", leakValue, "z_big", BIG_VALUE))
    // realloc and the `a_leak` write succeed, but below `z_big` so the large allocation OOMs mid-document.
 * written row before rethrowing, so the reused row starts clean.
 * <p>The fix makes {@code addDocument} all-or-nothing: on a mid-document failure it scrubs the partially
 * (an Arrow {@link org.apache.arrow.memory.OutOfMemoryException} mid-admission) must not leak the columns it
 * <p>Background: {@code VSRManager.addDocument} writes a document's fields into the active Arrow
        indexFailingDoc2(index, LEAKED_LONG);
    private List<Map<String, Object>> readParquetRows(String indexName) throws IOException {
import org.opensearch.action.index.IndexResponse;
            String failure = bulk.getItems()[0].getFailureMessage();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    private void setIngestPoolLimit(String bytes) {
                .setTransientSettings(Settings.builder().putNull(INGEST_MAX_SETTING))  
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
     * the doc was rejected.
            .indices()  
        client().admin()
    private static final String INGEST_LIMIT_BYTES = Long.toString(1024 * 1024);  
    private static final String INGEST_MAX_SETTING = "native.allocator.pool.ingest.max";  
    protected Settings nodeSettings(int nodeOrdinal) {  
    private static final long WARMUP_LONG = 111L;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)  
                WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
    }  
 * this file be licensed under the Apache-2.0 license or a
    // Variable-width (text / VarCharVector) leak scenario. The warm-up value pre-grows the VarChar data  
 * against the VSR (the row count never advanced), the writer stays ACTIVE, and the same VSR is reused. Before  
 * ({@code BigIntVector}) and a variable-width {@code text} ({@code VarCharVector}).
import java.util.List;
        flushIndex(index);  
    }
        assertNull("doc3 never set a_leak; the OOM-failed doc2's value must not leak into the reused row", doc3Row.get("a_leak"));
 * the current uncommitted row index; the row is only "counted" after every field write succeeds.  
        IndexResponse doc3 = client().prepareIndex(index).setSource("clean", "d3").get();  
    /** Variable-width column: a mid-document OOM must not leak the failed doc's {@code text} into the reused row. */
            .put("index.pluggable.dataformat.enabled", true)  
 * the fix, the fields written before the failure survived with their validity bits set, so the next document
                .setTransientSettings(Settings.builder().put(INGEST_MAX_SETTING, bytes))
        IndexResponse doc1 = client().prepareIndex(index).setSource("clean", "d1", "a_leak", WARMUP_LONG).get();
 * compatible open source license.
