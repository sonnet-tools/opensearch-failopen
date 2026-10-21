            .findFirst()
            .indices()
 * </ol>
import java.util.Map;
        return allRows;
        try {
 *   <li>Reset the ingest pool limit.</li>
public class CompositeParquetRollbackCorruptionIT extends AbstractCompositeEngineIT {
    private static final String WARMUP_TEXT = "w".repeat(4096);
     * Indexes doc2 with {@code {a_leak:<leakValue>, z_big:<2MB>}} under a throttled ingest pool so it fails
import org.opensearch.common.xcontent.json.JsonXContent;
import java.io.IOException;
        } finally {
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .get();
 *
    }
     * the doc was rejected.
            for (Segment segment : snapshot.get().getSegments()) {
        return Settings.builder()
import org.opensearch.test.OpenSearchIntegTestCase;
                .isAcknowledged()
        List<Map<String, Object>> allRows = new ArrayList<>();
/**
        assertEquals(RestStatus.CREATED, doc1.status());
    private void createCorruptionIndex(String index, String leakField, String leakMapping) {
                .cluster()
            .orElseThrow(() -> new AssertionError("Could not find row (clean=" + cleanValue + ") in parquet output: " + rows));
                    allRows.addAll(parseJsonRows(RustBridge.readAsJson(parquetDir.resolve(file).toString())));
import org.opensearch.index.shard.IndexShard;
 * against the VSR (the row count never advanced), the writer stays ACTIVE, and the same VSR is reused. Before
        Map<String, Object> doc3Row = findRowByClean(rows, "d3");
 * that lands on that same row index and does not overwrite them inherited the stale value.
    /** Variable-width column: a mid-document OOM must not leak the failed doc's {@code text} into the reused row. */
 * partially wrote into the next document that reuses the same VSR row slot.
 * Regression guard for issue #22417: a document that fails partway through {@code VSRManager.addDocument}
        IndexShard shard = getPrimaryShard(indexName);
            .prepareCreate(index)
import org.opensearch.core.xcontent.NamedXContentRegistry;
 *
                .cluster()
import org.opensearch.common.settings.Settings;
            .build();
import org.opensearch.core.rest.RestStatus;
    }
        List<Map<String, Object>> rows = readParquetRows(index);
            logger.info("[corruption-it] doc2 failure message: {}", failure);
import org.opensearch.core.xcontent.XContentParser;
        );
package org.opensearch.composite;
    private static final String BIG_VALUE = "x".repeat(2 * 1024 * 1024);
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
        List<Map<String, Object>> rows = readParquetRows(index);
 * <ol>
    @Override
        IndexResponse doc3 = client().prepareIndex(index).setSource("clean", "d3").get();
            resetIngestPoolLimit();
        assertEquals(RestStatus.CREATED, doc3.status());
    }
 * <p>The rebalancer is disabled so the ingest pool limit stays exactly where the test sets it.
    private static Map<String, Object> findRowByClean(List<Map<String, Object>> rows, String cleanValue) {
import org.opensearch.action.index.IndexResponse;
                    continue;
        indexFailingDoc2(index, LEAKED_TEXT);
            assertEquals(1, bulk.getItems().length);
import org.opensearch.index.engine.exec.WriterFileSet;
            assertTrue("doc2 must fail with a mid-document ingest OOM: " + failure, bulk.getItems()[0].isFailed());
                NamedXContentRegistry.EMPTY,
            .put("index.pluggable.dataformat", "composite")
            )
        assertNull("doc3 never set a_leak; the OOM-failed doc2's text value must not leak into the reused row", doc3Row.get("a_leak"));
    /** Fixed-width column: a mid-document OOM must not leak the failed doc's {@code long} into the reused row. */
 * <p>The fix makes {@code addDocument} all-or-nothing: on a mid-document failure it scrubs the partially
    // partial write rather than OOM-ing on the leak field itself.
        refreshIndex(index);
            return parser.list().stream().map(o -> (Map<String, Object>) o).collect(Collectors.toList());
        // Engine must still be open — an ingest OOM is a recoverable per-doc failure, not a tragic event.
        }
                .get();
        String index = "corruption-numeric-idx";
import org.opensearch.core.xcontent.DeprecationHandler;
                .get()
import java.nio.file.Path;
 * <p>The two tests cover the two Arrow vector families the scrub must handle: a fixed-width {@code long}
 * ({@code BigIntVector}) and a variable-width {@code text} ({@code VarCharVector}).
                .setTransientSettings(Settings.builder().putNull(INGEST_MAX_SETTING))
        try (GatedCloseable<CatalogSnapshot> snapshot = shard.getCatalogSnapshot()) {
        );
    // doc2's OOM trigger: a large value whose Arrow buffer allocation blows the ingest limit after `_id`
 * compatible open source license.
import java.util.List;
import org.opensearch.parquet.bridge.RustBridge;
                if (wfs == null) {
                .prepareUpdateSettings()
            .build();
            .putList("index.composite.secondary_data_formats", "lucene")
 * {@code ParquetWriter.addDoc} catches Arrow's {@code OutOfMemoryException} and returns a recoverable
 * written row before rethrowing, so the reused row starts clean.
        ) {
 * the current uncommitted row index; the row is only "counted" after every field write succeeds.
    public void testMidDocOomDoesNotLeakTextColumnIntoReusedRow() throws Exception {
 *   <li>Flush + refresh, then read the raw Parquet columns and assert doc3's row has {@code a_leak == null}.</li>
    // Ingest pool ceiling while doc2 is indexed: above the warm-up shard footprint so the small `_id`
            client().admin()
 *       vector's buffers so a later write to row 1 reuses them.</li>
                WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
            .put("index.composite.primary_data_format", "parquet")
        try (
 *   <li><b>doc3</b> {@code {clean:"d3"}} — reuses row 1 and does not set {@code a_leak}.</li>
 * SPDX-License-Identifier: Apache-2.0
    @SuppressForbidden(reason = "JSON parsing for test verification of parquet output")
 */
    // buffer so doc2's (shorter) write to row 1 reuses capacity without a large allocation, leaving a
        }
        refreshIndex(index);
        assertTrue(
        assertTrue(
                for (String file : wfs.files()) {
            // Keep the ingest pool limit fixed at whatever the test sets — no background growth.
    }
        indexFailingDoc2(index, LEAKED_LONG);
    private static final long WARMUP_LONG = 111L;
import org.opensearch.action.bulk.BulkResponse;
    private static final long LEAKED_LONG = 999_999_999L;
        IndexResponse doc1 = client().prepareIndex(index).setSource("clean", "d1", "a_leak", WARMUP_TEXT).get();
    private void setIngestPoolLimit(String bytes) {
            // Relieve the limit so doc3, flush and teardown can allocate freely.
 *   <li><b>doc2</b> {@code {a_leak:<leak>, z_big:<2MB>}} — fields are processed in name order: {@code _id}
                }
    private List<Map<String, Object>> parseJsonRows(String json) throws IOException {
    private void resetIngestPoolLimit() {
/*
        flushIndex(index);
 *
    }
            .put("index.pluggable.dataformat.enabled", true)
        return rows.stream()
        IndexResponse doc1 = client().prepareIndex(index).setSource("clean", "d1", "a_leak", WARMUP_LONG).get();
            .put(super.nodeSettings(nodeOrdinal))
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
 *
                }
import java.util.stream.Collectors;
 *       as a partial write.</li>
 *   <li><b>doc1</b> {@code {clean:"d1", a_leak:<warmup>}} — succeeds at row 0, allocating the {@code a_leak}
        String index = "corruption-text-idx";
            }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
            .setSettings(settings)
 *
        Settings settings = Settings.builder()
        assertNotNull("engine must survive a per-doc ingest OOM", getEngine(index).commitStats());
     */
        assertEquals(RestStatus.CREATED, doc1.status());
import org.opensearch.common.concurrent.GatedCloseable;
                json
 * {@code VectorSchemaRoot} one vector at a time. Each {@code setSafe} sets the value and the validity bit at
        setIngestPoolLimit(INGEST_LIMIT_BYTES);
 * the fix, the fields written before the failure survived with their validity bits set, so the next document
 * this file be licensed under the Apache-2.0 license or a
            .setMapping("clean", "type=keyword", leakField, leakMapping, "z_big", "type=keyword")
 * <p>Reproduction for each test:
     * mid-document (after {@code a_leak} is written for the row, when {@code z_big} allocation OOMs). Asserts
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            client().admin()
    private List<Map<String, Object>> readParquetRows(String indexName) throws IOException {
        IndexResponse doc3 = client().prepareIndex(index).setSource("clean", "d3").get();
    }
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        assertNull("doc3 never set a_leak; the OOM-failed doc2's value must not leak into the reused row", doc3Row.get("a_leak"));
                .isAcknowledged()
 *       (small realloc, fits), {@code a_leak} (written at row 1), then {@code z_big} (large allocation that
        client().admin()
}
 * <p>Background: {@code VSRManager.addDocument} writes a document's fields into the active Arrow
    }
 */
                .prepareUpdateSettings()
    // Fixed-width (long) leak scenario.
    private static final String INGEST_LIMIT_BYTES = Long.toString(1024 * 1024);
 * (an Arrow {@link org.apache.arrow.memory.OutOfMemoryException} mid-admission) must not leak the columns it
    // realloc and the `a_leak` write succeed, but below `z_big` so the large allocation OOMs mid-document.
 *
 * {@code WriteResult.Failure}; the composite then drives {@code rollbackTo(lastGoodRowCount)}, which no-ops
import org.opensearch.cluster.metadata.IndexMetadata;
        logger.info("[corruption-it] numeric parquet rows ({}): {}", rows.size(), rows);
        assertNotNull("engine must survive a per-doc ingest OOM", getEngine(index).commitStats());
    }
                .setTransientSettings(Settings.builder().put(INGEST_MAX_SETTING, bytes))
                .add(client().prepareIndex(index).setSource("a_leak", leakValue, "z_big", BIG_VALUE))
        }
    // Variable-width (text / VarCharVector) leak scenario. The warm-up value pre-grows the VarChar data
    /** Reads every row of every parquet file backing the primary shard as a list of column maps. */
        logger.info("[corruption-it] text parquet rows ({}): {}", rows.size(), rows);
        flushIndex(index);
    private static final String LEAKED_TEXT = "LEAKED_FROM_DOC2";
 *   <li>Throttle the ingest pool via {@code native.allocator.pool.ingest.max} above the shard footprint but
    }
    // and `a_leak` (ordered before `z_big`) have already been written for the row.
    public void testMidDocOomDoesNotLeakNumericColumnIntoReusedRow() throws Exception {
        createCorruptionIndex(index, "a_leak", "type=long");
 * The OpenSearch Contributors require contributions made to
        createCorruptionIndex(index, "a_leak", "type=text");
            XContentParser parser = JsonXContent.jsonXContent.createParser(
    private static final String INGEST_MAX_SETTING = "native.allocator.pool.ingest.max";
            BulkResponse bulk = client().prepareBulk()
                .get()
            .filter(r -> cleanValue.equals(r.get("clean")))
    /**
import java.util.ArrayList;
            .put("native.allocator.rebalancer.enabled", false)
    protected Settings nodeSettings(int nodeOrdinal) {
    private void indexFailingDoc2(String index, Object leakValue) {
        Map<String, Object> doc3Row = findRowByClean(rows, "d3");
import org.opensearch.index.engine.exec.Segment;
    @SuppressWarnings("unchecked")
 *       OOMs). The doc fails as a recoverable per-doc failure; the row count stays 1, leaving {@code a_leak}
            String failure = bulk.getItems()[0].getFailureMessage();
        assertEquals(RestStatus.CREATED, doc3.status());
 *       below the large {@code z_big} value.</li>
        ensureGreen(index);
import org.opensearch.common.SuppressForbidden;
