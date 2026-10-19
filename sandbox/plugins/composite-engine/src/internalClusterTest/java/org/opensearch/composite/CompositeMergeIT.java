        // age/name values.
                            fail("name nulls should be last, but found null at " + (i - 1) + " and non-null at " + i);
        ensureGreen(INDEX_NAME);
            new Object[] { "value_float", "type=float", (Supplier<Object>) () -> randomBoolean() ? null : randomFloat() * 1000 },
                }
                        randomDoubleBetween(-1000, 1000, true),
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;  
            .setMapping("name", "type=keyword", "age", "type=integer")
    @Override
            Supplier<Object> valueSupplier = (Supplier<Object>) spec[2];  
            }
                            assertEquals("Name mismatch at row_id=" + luceneRowId, parquetName.toString(), luceneName);
    }
                            + " fields="
            new Object[] {
                    if (currAge == null) {  
            for (int i = 0; i < docsPerCycle; i++) {
     * When multiple writers flush in the same refresh cycle, the primary (Parquet) merges
        client().admin()
                    );  
            mergeStats.getUnreferencedFileCleanUpsPerformed()
                Map<Long, Map<String, Object>> matchingSegment = null;  
     * segments, then verifies that for each row in parquet (identified by __row_id__),
        waitForMerge(refreshCycles);  
        for (int cycle = 0; cycle < refreshCycles; cycle++) {  
                    );
            .setMerge(true)
        int docsPerCycle = 10;
    private DataformatAwareCatalogSnapshot getCatalogSnapshot() throws IOException {
                    }
    }  
        );  
        for (Segment segment : snapshot.getSegments()) {
                            .putList("index.sort.field", fieldName)
        int totalDocs = refreshCycles * docsPerCycle;
            .build();
     */
    }
            ArrowBasePlugin.class,  
        int docsPerCycle = 5;  
    }
        // verify every row_id in the leaf resolves to a row in that segment with matching  
        if (prev instanceof Number && curr instanceof Number) {  
                        "val_float",
            new Object[] {  
            for (String file : wfs.files()) {
        for (int t = 0; t < numThreads; t++) {  
            .setSettings(unsortedSettings())
import org.opensearch.index.shard.IndexShard;
    // ══════════════════════════════════════════════════════════════════════  
                    response = client().prepareIndex().setIndex(INDEX_NAME).setSource(fieldName, value).get();
     */  
                    Map<String, Object> parquetRow = matchingSegment.get(luceneRowId);
        // Verify total row count
        String[] missings = { randomFrom("_first", "_last"), randomFrom("_first", "_last"), randomFrom("_first", "_last") };
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");  
                        randomLongBetween(-100000, 100000),  
        ensureGreen(INDEX_NAME);
            .indices()
     * map would silently overwrite rows from segments that happen to share row_ids.  
     *  
                            + sortMissing,  
        }
                            + file
        org.opensearch.action.admin.indices.stats.IndicesStatsResponse statsResponse = client().admin()
import org.opensearch.index.engine.dataformat.DocumentInput;
                        assertEquals("Age mismatch at row_id=" + luceneRowId, ((Number) parquetAge).longValue(), luceneAge);
                    int cmp = compareRows(rows.get(i - 1), rows.get(i), sortFields, sortOrders, sortMissing);  
            assertEquals("All lucene docs should have matching parquet rows", totalLuceneDocs, matchedDocs);
        Path luceneDir = getLuceneDir();
                        Settings settings = Settings.builder()
 * SPDX-License-Identifier: Apache-2.0
     */
            .put("index.pluggable.dataformat", "composite")
                        DataformatAwareCatalogSnapshot snapshot = waitForMerge(refreshCycles);
                IndexResponse response = client().prepareIndex().setIndex(INDEX_NAME).setSource(source).get();
import org.apache.lucene.store.Directory;
import java.util.HashSet;
                        indexRandomDocs(refreshCycles, docsPerCycle, fieldName, valueSupplier);
        try {  
     * Sequential (not just monotonic) is required because the RowIdMapping produces
            return DataformatAwareCatalogSnapshot.deserializeFromString(snapshot.get().serializeToString(), Function.identity());
                        "val_keyword",
        enableMerge();  
            .putList("index.composite.secondary_data_formats", "lucene")
     *   <li>Cross-format consistency: parquet rows match lucene docs by row_id</li>
        org.opensearch.index.merge.MergeStats mergeStats = statsResponse.getIndex(INDEX_NAME).getShards()[0].getStats().getMerge();
        }
        List<String> sortFields,
            .indices()
    @SuppressForbidden(reason = "JSON parsing for test verification of parquet output")
        int totalDocs = refreshCycles * docsPerCycle;  
                        );  
    }  
        return sortFields.stream().map(row::get).toList();  
        DataformatAwareCatalogSnapshot snapshot = getCatalogSnapshot();  
    // ══════════════════════════════════════════════════════════════════════
        assertTrue("Catalog should contain 'lucene'", formats.contains("lucene"));
                    if (candidate.size() == leafDocs) {
        } else {
                    for (Object obj : parser.list()) {
        indexDocsAcrossMultipleRefreshes(refreshCycles, docsPerCycle);
    // ══════════════════════════════════════════════════════════════════════  
                IndexResponse response;
                    .setIndex(INDEX_NAME)
        ensureGreen(INDEX_NAME);
                    }).toList();
                        parquetRow
                assertEquals(RestStatus.CREATED, response.status());
                    }
                        .setIndex(INDEX_NAME)
     *  
     * Verifies that merged parquet files have age in DESC order with nulls first,
            });  
                "val_float",
    private void indexDocsWithNullsAcrossRefreshes(int refreshCycles, int docsPerCycle) {
            .put(unsortedSettings())
import java.util.Arrays;  
                Object value = valueSupplier.get();
            .put("index.composite.primary_data_format", "parquet")  
                        long rowId = ((Number) row.get(DocumentInput.ROW_ID_FIELD)).longValue();
                        Map<String, Object> m = (Map<String, Object>) o;
                }
    private Path getLuceneDir() {  
                            + " in file "
            DataFusionPlugin.class
            assertEquals(RestStatus.OK, refreshResponse.getStatus());
            @SuppressWarnings("unchecked")
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeNameResolved);
                Path filePath = parquetDir.resolve(file);
                            "Parquet row at " + DocumentInput.ROW_ID_FIELD + "=" + luceneRowId + " should have 'age' field",
        waitForMerge(refreshCycles);
    // ══════════════════════════════════════════════════════════════════════
    }
                } else {  
import java.io.IOException;  
        // Both formats must be present in the catalog
                        randomFloat() * 200 - 100,
     * the same reordering via the mapping.
        List<String> sortMissing
        indexDocsAcrossMultipleRefreshes(refreshCycles, docsPerCycle);  
                        "Sort order violated at row "
                    // Compare age field
            .setMapping("name", "type=keyword", "age", "type=integer")  
    private List<Object> extractSortValues(Map<String, Object> row, List<String> sortFields) {
        verifyRowCount(snapshot, totalDocs);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                        Map<String, Object> m = (Map<String, Object>) o;
            cmp = ((String) prev).compareTo((String) curr);  
            .putList("index.sort.field", fields)  
    // ── Helpers for randomized tests ──  
            boolean desc = "desc".equals(sortOrders.get(f));
                assertTrue("Orphan parquet file on disk not referenced by catalog: " + diskFile, referencedFiles.contains(diskFile));
import org.opensearch.be.datafusion.DataFusionPlugin;  
    }
        return Settings.builder()  
                }
            }  
                    )  
        Path parquetDir = getParquetDir();  
import org.opensearch.common.concurrent.GatedCloseable;
                "timestamp",
                    } finally {
    }  
     * them and produces a RowIdMapping via fileMappings. The secondary (Lucene) then applies  
                long expectedRowId = 0;
        ensureGreen(INDEX_NAME);
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
        if (prev == null) return nullsFirst ? -1 : 1;
    }  
import java.nio.file.Path;
    private void indexRandomDocs(int refreshCycles, int docsPerCycle, String fieldName, Supplier<Object> valueSupplier) {
// singleton that persists after tests complete. It polls for new async IO tasks between merges.
     * <ol>
            }  
            int threadId = t;
    /**  
        assertNotNull("MergeStats from API should not be null", mergeStats);  
                assertEquals(RestStatus.CREATED, response.status());  
                    }
                "value_long",
        System.clearProperty(MERGE_ENABLED_PROPERTY);
            if (wfs != null) {
    public void testBackgroundMerge() throws Exception {  
        assertEquals("Total rows across all segments should match ingested docs", expectedTotalDocs, totalRows);  
    }
                    }
            .setMapping("name", "type=keyword", "age", "type=integer")
     *  
        client().admin()
            WriterFileSet parquetWfs = segment.dfGroupedSearchableFiles().get("parquet");  
            .indices()
                (Supplier<Object>) () -> randomBoolean() ? null : now - randomLongBetween(0, 86400000L * 365) },
                }
        assertTrue("Lucene directory should exist: " + luceneDir, Files.exists(luceneDir));
                        rowsInSegment.put(rowId, row);  
            for (int i = 0; i < docsPerCycle; i++) {
        }
        }
    @Override
        assertTrue("Catalog should contain 'parquet'", formats.contains("parquet"));
        Path luceneDir = getLuceneDir();  
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
                    .setSource("name", randomAlphaOfLength(10), "age", randomIntBetween(1, 1000))
import org.opensearch.core.xcontent.DeprecationHandler;  
            .build();
    }
public class CompositeMergeIT extends OpenSearchIntegTestCase {
        assertEquals(
     *       (confirms RowIdMapping was applied during secondary merge)</li>  
            assertNotNull("Segment should have parquet files", wfs);  
        // Cross-format validation: for each segment, parquet rows == lucene segment docs
        // Single refresh flushes all writers — triggers inline consolidation via fileMappings
        int cmp;
                        @SuppressWarnings("unchecked")
        client().admin().indices().prepareRefresh(INDEX_NAME).get();  
import org.opensearch.index.engine.DataFormatAwareEngine;
     */
                        int docId = threadId * docsPerThread + i;  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                        int totalDocs = refreshCycles * docsPerCycle;  
            .put("index.refresh_interval", "-1")  
     * with correct row count and source files cleaned up.
                if (rows.size() <= 1) continue;  
                        int refreshCycles = 15;
                for (Map<Long, Map<String, Object>> candidate : parquetSegments) {
        IndexShard shard = getPrimaryShard();
package org.opensearch.composite;
        verifyCrossFormatConsistency(snapshot);
                        "val_date",
    // Merge stats tests
                    rows = parser.list().stream().map(o -> {  
        ensureGreen(INDEX_NAME);
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
        int totalDocs = refreshCycles * docsPerCycle;  
            throw error.get();
            .setMapping("age", types[0], "score", types[1], "tag", types[2])  
            .setSettings(unsortedSettings())
        verifySegmentGenerationUniqueness(snapshot);  
        IndexShard shard = getPrimaryShard();
    }
        int refreshCycles = 15;
import org.opensearch.plugins.Plugin;  
            .putList("index.sort.order", orders)
            .putList("index.sort.order", "desc", "asc")  
        String[] fields = { "age", "score", "tag" };
        DataformatAwareCatalogSnapshot snapshot = getCatalogSnapshot();
     *   <li>Lucene documents have monotonically increasing __row_id__ doc values
        Set<String> formats = snapshot.getDataFormats();
        Set<String> referencedFiles = new HashSet<>();
    public void testMergeOnRefresh() throws Exception {  
                String json = RustBridge.readAsJson(filePath.toString());  
     */
        Map<String, Object> prev,  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                "type=date",  
     *   <li>Merged parquet files have correct total row count</li>  
            List<String> diskFiles = stream.filter(Files::isRegularFile)  
    }  
                                + rowId
    /**
        }
            .setSettings(unsortedSettings())
                        "Lucene doc with " + DocumentInput.ROW_ID_FIELD + "=" + luceneRowId + " should have a matching parquet row",
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
import org.opensearch.common.SuppressForbidden;  
        // cascaded merge before the first one commits.  
    // Private helpers: verification
            threads[t].start();
                assertNotNull("No parquet segment found with matching row count " + leafDocs, matchingSegment);
                for (int doc = 0; doc < leafDocs; doc++) {
                            String luceneName = nameDV.lookupOrd(ord).utf8ToString();
        verifyLuceneDocCount(totalDocs);
        }, 30, java.util.concurrent.TimeUnit.SECONDS);
                        NamedXContentRegistry.EMPTY,  
                SortedNumericDocValues ageDV = ctx.reader().getSortedNumericDocValues("age");
        ensureGreen(INDEX_NAME);
            assertEquals("Total lucene docs should match ingested docs", expectedTotalDocs, reader.numDocs());
        Path luceneDir = getLuceneDir();  
        }  
     * Verifies sorted composite merge with Parquet primary (sorted) + Lucene secondary:  
        DataformatAwareCatalogSnapshot snapshot,
            new Object[] { "tag", "type=keyword", (Supplier<Object>) () -> randomBoolean() ? null : randomAlphaOfLengthBetween(3, 8) }
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
                            .put(unsortedSettings())  
                if (Files.exists(filePath) == false) continue;
        int refreshCycles = 15;
                        @SuppressWarnings("unchecked")  
        int docsPerCycle = 10;  
            .prepareCreate(INDEX_NAME)  
        for (int cycle = 0; cycle < refreshCycles; cycle++) {  
    // Private helpers: indexing  
    private void verifyLuceneDocCount(int expectedTotalDocs) throws IOException {  
                if (rowIdDV == null) continue;
        if (error.get() != null) {
        return Settings.builder()  
        for (Segment segment : snapshot.getSegments()) {
            cmp = prev.toString().compareTo(curr.toString());
                "type=long",  
        client().admin()
    // ══════════════════════════════════════════════════════════════════════
            assertEquals(RestStatus.OK, refreshResponse.getStatus());
        int docsPerCycle = 5;
                    .get();  
import java.util.Map;
        String[] types = { "type=integer", "type=long", "type=keyword" };  
                        }
    }
                    )
            }
        }  
                String json = RustBridge.readAsJson(filePath.toString());  
                        now - randomLongBetween(0, 86400000L * 30),  
                    .get();
            for (String diskFile : diskFiles) {
import org.opensearch.action.admin.indices.refresh.RefreshResponse;  
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
     * Verifies composite merge with Parquet as primary and Lucene as secondary:
            boolean nullsFirst = "_first".equals(sortMissing.get(f));  
        DataformatAwareCatalogSnapshot snapshot = waitForMerge(refreshCycles);
                    startLatch.await();
                assertEquals("WriterFileSet numRows should match actual file metadata for " + file, wfs.numRows(), metadata.numRows());
import org.opensearch.common.util.FeatureFlags;  
        verifySortOrderGeneric(snapshot, List.of(fields), List.of(orders), List.of(missings));  
    }  
        waitForMerge(refreshCycles);
        flush(INDEX_NAME);  
                        );  
        assertBusy(() -> {
    private void verifyCrossFormatConsistency(DataformatAwareCatalogSnapshot snapshot) throws Exception {
    }  
     * Verifies that __row_id__ doc values in merged lucene segments are sequential
            .indices()  
                        prevAgeVal >= currAgeVal  
            .indices()
                                + doc,  
            for (String file : wfs.files()) {
        List<Object[]> fieldSpecs = List.of(  
        client().admin()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .prepareCreate(INDEX_NAME)  
        for (int cycle = 0; cycle < refreshCycles; cycle++) {
            new Object[] {
import org.opensearch.indices.IndicesService;
import org.apache.lucene.index.SortedNumericDocValues;
                        .get();  
                (Supplier<Object>) () -> randomBoolean() ? null : randomLongBetween(-1_000_000L, 1_000_000L) },
        );
            0,
        for (Thread t : threads) {
        }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                for (String missing : List.of("_first", "_last")) {  
            Object currVal = curr.get(field);  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
                        NamedXContentRegistry.EMPTY,
     * Verifies that after a merge, getMergeStats() reports at least one completed merge  
    }
            .prepareCreate(INDEX_NAME)
                } catch (Exception e) {  
        } catch (Exception e) {
            .get();  
                "val_date",
    private void verifySegmentGenerationUniqueness(DataformatAwareCatalogSnapshot snapshot) {  
                if (i % 5 == 0) {  
        client().admin()
    /**
            .put("index.refresh_interval", "-1")  
import org.opensearch.be.lucene.LucenePlugin;
            .prepareCreate(INDEX_NAME)  
        client().admin()
        }
                }
    /**
    private static final String MERGE_ENABLED_PROPERTY = "opensearch.pluggable.dataformat.merge.enabled";
                ParquetFileMetadata metadata = RustBridge.getFileMetadata(filePath.toString());
                    // When age is equal, verify name ASC (nulls last)  
                assertEquals(RestStatus.CREATED, response.status());
                    assertTrue(
            )  
        java.util.concurrent.atomic.AtomicReference<Exception> error = new java.util.concurrent.atomic.AtomicReference<>();  
                        cmp <= 0
            LucenePlugin.class,  
                source.put("age", randomBoolean() ? null : randomIntBetween(0, 100));  
                            .putList("index.sort.order", order)
        int docsPerThread = 5;  
        return desc ? -cmp : cmp;
        Path parquetDir = getParquetDir();
        indexDocsAcrossMultipleRefreshes(refreshCycles, docsPerCycle);
     * correctly synchronized the two formats during merge.
    private void verifyLuceneRowIdSequential() throws IOException {
     *   <li>Merged lucene directory has correct total document count</li>
            .put("index.composite.primary_data_format", "parquet")  
                        assertEquals(
                try (
        // (only unique within a segment, so a per-segment map is required).  
        assertTrue("Catalog should contain 'parquet' format, got: " + formats, formats.contains("parquet"));
            RefreshResponse refreshResponse = client().admin().indices().prepareRefresh(INDEX_NAME).get();
            .prepareCreate(INDEX_NAME)  
        long cleanups = engine.unreferencedFileCleanUpsPerformed();
    @SuppressWarnings("unchecked")
        // Verify parquet merged files have correct row count
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
                    try {
                "val_int",  
            .setMapping("name", "type=keyword", "age", "type=integer")
            .get();
        verifyNoOrphanFiles(snapshot);
            t.join();
     * the same mapping. This test uses concurrent indexing to fill multiple writers, then
        int docsPerCycle = 5;  
                                "Parquet row at " + DocumentInput.ROW_ID_FIELD + "=" + luceneRowId + " should have 'name' field",
                "type=keyword"
                    rows = parser.list().stream().map(o -> {  
                                ((String) prevName).compareTo((String) currName) <= 0  
                    if (nameDV != null && nameDV.advanceExact(doc)) {
                "val_long",
        DataFormatAwareEngine engine = (DataFormatAwareEngine) org.opensearch.index.shard.IndexShardTestCase.getIndexer(shard);
        System.setProperty(MERGE_ENABLED_PROPERTY, "true");
        for (Segment segment : snapshot.getSegments()) {
                        if (prevName == null && currName != null) {  
            assertTrue(  
        return getCatalogSnapshot();
                if (rows.size() <= 1) continue;  
                    + refreshCycles
            if (rowsInSegment.isEmpty() == false) {
                    response = client().prepareIndex().setIndex(INDEX_NAME).setSource(java.util.Collections.emptyMap()).get();
    /**  
        if (curr == null) return nullsFirst ? 1 : -1;  
 * The OpenSearch Contributors require contributions made to  
                        long luceneAge = ageDV.nextValue();
                        "val_int",  
            CompositeDataFormatPlugin.class,
        );  
import org.apache.lucene.index.LeafReaderContext;
    }
                        Object prevName = rows.get(i - 1).get("name");
                            parquetAge
        assertTrue("Should have parquet rows to compare", parquetSegments.isEmpty() == false);  
import org.apache.lucene.index.DirectoryReader;  
        return 0;
        assertTrue("Catalog should contain 'parquet'", formats.contains("parquet"));
                IndexResponse response;  
                    }).toList();
                if (value == null) {
                        long ord = nameDV.nextOrd();  
                }
                        if (prevName != null && currName == null) continue; // non-null before null is correct for nulls last
            .putList("index.sort.field", "age", "name")
    }  
                List<Map<String, Object>> rows;
            String fieldName = (String) spec[0];  
            .putList("index.sort.missing", "_first", "_last")
                        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(settings).setMapping(fieldName, fieldType).get();  
        verifyLuceneDocCount(totalDocs);
            .clear()
                        Object currName = rows.get(i).get("name");  
     *   <li>Lucene __row_id__ values are sequential (RowIdMapping applied)</li>
        waitForMerge(refreshCycles);
                            + " missing="
                    if (rowIdDV.advanceExact(doc)) {  
                    XContentParser parser = JsonXContent.jsonXContent.createParser(  
        super.tearDown();
            .indices()  
    ) {
            .build();
            .put("index.refresh_interval", "-1")  
            .prepareCreate(INDEX_NAME)
                                parquetName  
        }  
import java.nio.file.Files;
    /**  
        java.util.concurrent.CountDownLatch startLatch = new java.util.concurrent.CountDownLatch(1);
     * Validates inline consolidation at refresh with fileMappings:
                    int prevAgeVal = ((Number) prevAge).intValue();
        return Settings.builder()
     * the corresponding Lucene document (sorted by __row_id__) has matching field values.
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
            assertTrue("Should have matched at least some docs across formats", matchedDocs > 0);
                            );
        } else if (prev instanceof String && curr instanceof String) {
            .indices()  
            client().admin().indices().prepareDelete(INDEX_NAME).get();
                // Remove null entries so they appear as missing in the doc  
            for (int i = 0; i < docsPerCycle; i++) {
import org.opensearch.test.OpenSearchIntegTestCase;
            Object prevVal = prev.get(field);
import org.opensearch.core.xcontent.NamedXContentRegistry;
            .indices()
    }
        for (Segment segment : snapshot.getSegments()) {
                        break;
                (Supplier<Object>) () -> randomBoolean() ? null : randomDoubleBetween(-1e6, 1e6, true) },  
        assertTrue("Catalog should contain 'lucene' format, got: " + formats, formats.contains("lucene"));
                    if (prevAge == null) continue; // null before non-null is correct
        // Accept: segment count <= refreshCycles (inline consolidation working correctly).  
import org.opensearch.core.xcontent.XContentParser;
                        "age should be DESC but found " + prevAgeVal + " before " + currAgeVal + " at row " + i,
            .build();
    // ══════════════════════════════════════════════════════════════════════
                parquetSegments.add(rowsInSegment);
                        fail("age null should come before non-null, but found non-null at " + (i - 1) + " and null at " + i);
     */
        return indexService.getShard(0);
        verifyRowCount(snapshot, totalDocs);
     *   <li>Merge reduces segment count</li>
     */
     * Correctness criteria:
            String field = sortFields.get(f);
        verifyCrossFormatConsistency(snapshot);
        int refreshCycles = 15;
        client().admin()
        // Index documents to create multiple segments. Using 15 cycles keeps the workload
            .get();
        // Merged lucene segments live in the shard's standard index folder (ShardPath.resolveIndex()),
    // ══════════════════════════════════════════════════════════════════════  
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(INDEX_NAME));  
                        ensureGreen(INDEX_NAME);
    private Settings parquetPrimaryLuceneSecondarySettings() {
     *   <li>After refresh, catalog has 1 segment (consolidated) instead of N per-writer segments</li>  
        client().admin()
            .setSettings(unsortedSettings())
                                + " but got "  
        // RowIdMapping correctness: __row_id__ must be sequential within each segment
    private void verifyRowCount(DataformatAwareCatalogSnapshot snapshot, int expectedTotalDocs) throws IOException {
                            expectedRowId,
     * a single refresh to trigger consolidation.
            if (cmp != 0) return cmp;  
            Map<Long, Map<String, Object>> rowsInSegment = new java.util.HashMap<>();
        startLatch.countDown();  
                }
                Path filePath = parquetDir.resolve(file);
     * Verifies background merge produces a valid merged parquet file and lucene segment  
        Thread[] threads = new Thread[numThreads];
        List<Long> generations = snapshot.getSegments().stream().map(Segment::generation).toList();
                            .putList("index.sort.missing", missing)  
import org.opensearch.action.index.IndexResponse;
import org.opensearch.parquet.bridge.RustBridge;
                "type=double",
        Map<String, Object> curr,
                        int docsPerCycle = 10;  
        verifyLuceneRowIdSequential();
     *   <li>Both parquet and lucene formats are present</li>
        }  
        verifyCrossFormatConsistency(snapshot);  
        for (Segment segment : snapshot.getSegments()) {
                                + " at doc "
     * Each Lucene leaf is matched to its parquet segment by row count.
     * a dense mapping — every position from 0..N-1 must be covered.  
            DataformatAwareCatalogSnapshot snap = getCatalogSnapshot();
        indexDocsAcrossMultipleRefreshes(refreshCycles, docsPerCycle);  
            .putList("index.sort.missing", missings)
                }
        long now = System.currentTimeMillis();
    private int compareValues(Object prev, Object curr, boolean desc, boolean nullsFirst) {  
                SortedSetDocValues nameDV = ctx.reader().getSortedSetDocValues("name");  
                    if (prevAge == null && currAge == null) continue;
        String nodeName = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();  
    private void verifySortOrder(DataformatAwareCatalogSnapshot snapshot) throws Exception {  
                            + extractSortValues(rows.get(i - 1), sortFields)
    public void testUnsortedMergeWithAllTypes() throws Exception {  
                source.put("tag", randomBoolean() ? null : randomAlphaOfLengthBetween(3, 6));
            .get();
                    if (prevAgeVal == currAgeVal) {
                    if (rowIdDV.advanceExact(doc) == false) continue;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
}  
        }
     * and unreferencedFileCleanUpsPerformed > 0 (old segment files were cleaned up).
        }
            }
    private void verifyNoOrphanFiles(DataformatAwareCatalogSnapshot snapshot) throws IOException {
     * unreferenced_file_cleanups_performed after a merge.
            for (String order : List.of("asc", "desc")) {
    }
                                "name should be ASC but found '" + prevName + "' before '" + currName + "' at row " + i,
            for (String file : wfs.files()) {
                SortedNumericDocValues rowIdDV = ctx.reader().getSortedNumericDocValues(DocumentInput.ROW_ID_FIELD);
        long totalRows = 0;  
    }
    public void testSortedParquetPrimaryLuceneSecondaryMerge() throws Exception {  
                "type=float",
    public void testSortedMergeMultiColumnRandomized() throws Exception {
                Path filePath = parquetDir.resolve(file);
        int docsPerCycle = 5;
                } else {
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
                        randomAlphaOfLength(6)
        Set<String> formats = snapshot.getDataFormats();  
    }
                }
        indexDocsWithNullsAcrossRefreshes(refreshCycles, docsPerCycle);
     * </ol>  
                        expectedRowId++;
     * and within same age, name in ASC order with nulls last.  
import java.util.Collection;
// The Tokio IO runtime worker thread (used by the Rust merge k-way merge sort) is a process-lifetime  
                "val_keyword",
        for (int cycle = 0; cycle < refreshCycles; cycle++) {  
import org.opensearch.common.xcontent.json.JsonXContent;
        return Settings.builder()  
                referencedFiles.addAll(wfs.files());
        }
 * compatible open source license.
     * (0, 1, 2, ...) within each leaf. This confirms the RowIdMapping from the primary
    }
                try {  
        DataformatAwareCatalogSnapshot snapshot = waitForMerge(refreshCycles);  
        }  
        for (int f = 0; f < sortFields.size(); f++) {  
                    // Compare name field (keyword stored as sorted set doc values)
        int refreshCycles = 15;
        // With refresh_interval=-1 and no explicit refresh, all docs land in the writer pool.
            .setSettings(parquetPrimaryLuceneSecondarySettings())
    private IndexShard getPrimaryShard() {
    }
        List<Map<Long, Map<String, Object>>> parquetSegments = new java.util.ArrayList<>();
     * Cross-format data comparison: reads merged parquet file content and merged lucene  
    private DataformatAwareCatalogSnapshot waitForMerge(int refreshCycles) throws Exception {
        try (GatedCloseable<CatalogSnapshot> snapshot = shard.getCatalogSnapshot()) {  
            .indices()
            String fieldType = (String) spec[1];
            .put(super.nodeSettings(nodeOrdinal))
                            + sortOrders
                IndexResponse response = client().prepareIndex()  
        String[] orders = { randomFrom("asc", "desc"), randomFrom("asc", "desc"), randomFrom("asc", "desc") };
                    )
            .put("index.pluggable.dataformat.enabled", true)
        if (prev == null && curr == null) return 0;
        assertEquals("All segment generations must be unique", generations.size(), generations.stream().distinct().count());
     *   <li>Cross-format validation: parquet row count == lucene doc count for each merged segment</li>
                "value_double",
            .prepareCreate(INDEX_NAME)
        // Verify lucene merged directory has correct doc count
    // Private helpers: index settings
        DataformatAwareCatalogSnapshot snapshot = waitForMerge(refreshCycles);
                source.values().removeIf(java.util.Objects::isNull);
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
 * this file be licensed under the Apache-2.0 license or a
        verifyRowCount(snapshot, totalDocs);
     * <ol>  
    /**
    }
                        @SuppressWarnings("unchecked")
                }  
                    response = client().prepareIndex().setIndex(INDEX_NAME).setSource("name", randomAlphaOfLength(10)).get();
import org.opensearch.cluster.metadata.IndexMetadata;
    // ══════════════════════════════════════════════════════════════════════
        }  
     *   <li>Merged parquet files are sorted by age DESC (nulls first), name ASC (nulls last)</li>  
                "type=double",
                .filter(f -> f.endsWith(".parquet"))
    // ══════════════════════════════════════════════════════════════════════
                        if (prevName != null && currName != null) {  
        IndexShard shard = getPrimaryShard();  
        // in line with the other stable composite-merge tests and avoids triggering a second
        }  
import java.util.Set;
                parquetSegments.remove(matchingSegment);
        assertEquals(Set.of("parquet", "lucene"), snapshot.getDataFormats());  
        List<String> sortOrders,  
        verifySortOrder(snapshot);  
    @Override
        int docsPerCycle = 8;
            .put("index.pluggable.dataformat.enabled", true)
            for (LeafReaderContext ctx : reader.leaves()) {  
        return shard.shardPath().resolveIndex();
                    long luceneRowId = rowIdDV.nextValue();  
        assertNotNull("MergeStats should not be null", mergeStats);
    // ══════════════════════════════════════════════════════════════════════
                        json
                        "val_long",
                var source = new java.util.HashMap<String, Object>();
            for (LeafReaderContext ctx : reader.leaves()) {
            }
    @SuppressForbidden(reason = "restore pluggable dataformat merge property after test")
                if (rowIdDV == null) continue;
        org.opensearch.index.merge.MergeStats mergeStats = engine.getMergeStats();  
                        return m;  
            }
            // index may not exist if test failed before creation  
        Path parquetDir = getParquetDir();
                    }
        // For each Lucene leaf, find the parquet segment whose row count matches and
                totalRows += metadata.numRows();  
                "type=integer",
                "type=long",  
            "unreferencedFileCleanUpsPerformed via API should be 0 after successful merge (only tracks merge failure cleanups)",  
                    int currAgeVal = ((Number) currAge).intValue();
    // ── Randomized sort tests across data types ──
            .get();  
                    )  
     *   <li>Merge reduces segment count (merge actually happened)</li>
    @SuppressForbidden(reason = "JSON parsing for cross-format data comparison")  
                        long rowId = rowIdDV.nextValue();
                ) {
            .get();  
    private static final String INDEX_NAME = "test-composite-merge";  
                    + snap.getSegments().size(),
            .put("index.pluggable.dataformat", "composite")
        assertEquals(
        int totalDocs = refreshCycles * docsPerCycle;  
                            + sortFields
                    XContentParser parser = JsonXContent.jsonXContent.createParser(  
     * (each segment starts row_ids at 0), so rows must be grouped per segment — a global
        List<String> sortFields,  
                SortedNumericDocValues rowIdDV = ctx.reader().getSortedNumericDocValues(DocumentInput.ROW_ID_FIELD);
                            DocumentInput.ROW_ID_FIELD  
                            );
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
     *   <li>Both "parquet" and "lucene" entries exist in the catalog snapshot</li>
        String nodeNameResolved = getClusterState().nodes().get(nodeName).getName();
        // Collect parquet rows grouped per catalog segment, indexed by __row_id__
                    .setSource(
                }  
    // ══════════════════════════════════════════════════════════════════════
        // With inline merge at refresh, each cycle already produces 1 consolidated segment.
    private void verifySortOrderGeneric(
    protected Settings nodeSettings(int nodeOrdinal) {  
    // Tests
            for (int i = 0; i < docsPerCycle; i++) {
                        Object parquetAge = parquetRow.get("age");
                    Object currAge = rows.get(i).get("age");
    // Framework lifecycle & configuration
                        client().prepareIndex(INDEX_NAME).setSource("name", "doc_" + docId, "age", randomIntBetween(0, 100)).get();
                totalLuceneDocs += leafDocs;
                        NamedXContentRegistry.EMPTY,
/*  
 */  
                                + expectedRowId
            }  
     * <ol>
            .setMapping(
            }  
            .prepareStats(INDEX_NAME)  
    public void testParquetPrimaryLuceneSecondaryMerge() throws Exception {
                String json = RustBridge.readAsJson(filePath.toString());  
            }
    private Settings unsortedSettings() {
    private int compareRows(
     */
        }  
                            + " curr="
import org.opensearch.core.rest.RestStatus;
                    assertNotNull(  
                ) {
            threads[t] = new Thread(() -> {
    }  
        assertTrue("Total merges should be > 0 after merge", mergeStats.getTotal() > 0);
            .put("index.composite.primary_data_format", "parquet")  
                                + " should be sequential within segment, expected "
                assertTrue("Parquet file should exist: " + filePath, Files.exists(filePath));  
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
                try (
        // which resolves to "<shardDataPath>/index". The "<shardDataPath>/lucene" folder is only used
import java.util.function.Function;  
                "val_double",  
        List<String> sortMissing
                    for (int i = 0; i < docsPerThread; i++) {
        for (int cycle = 0; cycle < refreshCycles; cycle++) {
        int refreshCycles = 15;
                    response = client().prepareIndex()  
    }
                        assertNotNull(  
                    }
     *   <li>Cross-format consistency: parquet row data matches lucene data at same row_id</li>  
            RefreshResponse refreshResponse = client().admin().indices().prepareRefresh(INDEX_NAME).get();  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)  
    public void tearDown() throws Exception {
        // Cross-format field value consistency
            .putList("index.composite.secondary_data_formats", "lucene")
            .get();  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            }
                            + ": prev="  
        for (Object[] spec : fieldSpecs) {
        verifyRowCount(snapshot, totalDocs);
     * Compares both numeric (age) and keyword (name) fields to ensure the RowIdMapping
                        Map<String, Object> row = (Map<String, Object>) obj;
                    XContentParser parser = JsonXContent.jsonXContent.createParser(
        try (var stream = Files.list(parquetDir)) {
                .map(p -> p.getFileName().toString())
            int totalLuceneDocs = 0;
            for (int i = 0; i < docsPerCycle; i++) {
    }
                    }
            }
                source.put("score", randomBoolean() ? null : randomLongBetween(0, 10000));
    }  
                            assertTrue(
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");  
    private Path getParquetDir() {
                }  
                        matchingSegment = candidate;  
                        json  
import org.opensearch.parquet.ParquetDataFormatPlugin;  
import org.opensearch.index.IndexService;  
        );  
    }  
     * </ol>
     * Verifies that merge stats via the indices stats API (_stats/merge) reflects
    // ══════════════════════════════════════════════════════════════════════
    ) throws Exception {  
    }  
        DataformatAwareCatalogSnapshot snapshot = getCatalogSnapshot();  
            .putList("index.composite.secondary_data_formats", "lucene")
                assertEquals(RestStatus.CREATED, response.status());  
        assertTrue("Total merges via API should be > 0", mergeStats.getTotal() > 0);
    public void testMergeStatsViaApi() throws Exception {
            .prepareCreate(INDEX_NAME)  
                    assertTrue(
            int matchedDocs = 0;  
        IndexShard shard = getPrimaryShard();
        disableMerge();  
    private void indexDocsAcrossMultipleRefreshes(int refreshCycles, int docsPerCycle) {  
     * <p>Note: {@code __row_id__} is only unique <em>within</em> a catalog segment
    // Private helpers: shard/cluster accessors
                    error.compareAndSet(null, e);
                            Object parquetName = parquetRow.get("name");  
                            + i  
        // Use concurrent threads to fill multiple writers in a single refresh cycle.  
    public void testMergeStatsAfterMerge() throws Exception {  
    // ══════════════════════════════════════════════════════════════════════  
                Path filePath = parquetDir.resolve(file);
                        if (ord >= 0) {
        int numThreads = 8;
                            .build();
        }
     *   <li>Lucene __row_id__ values are sequential (RowIdMapping correctly applied)</li>
     *
            }  
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        long now = System.currentTimeMillis();  
        // Background merge may further reduce, but for small segments it may not fire.
    // ══════════════════════════════════════════════════════════════════════
                for (int i = 1; i < rows.size(); i++) {
                int leafDocs = ctx.reader().maxDoc();  
     * the primary format reorders rows during merge, and the secondary must apply  
     * (Parquet) merge was correctly applied to reorder Lucene documents.  
            .put("index.pluggable.dataformat", "composite")
                try (
        Settings settings = Settings.builder()
    /**
        return shard.shardPath().getDataPath().resolve("parquet");  
        int refreshCycles = 15;
        verifyLuceneRowIdSequential();
        int totalDocs = refreshCycles * docsPerCycle;
    public void setUp() throws Exception {
            cmp = Double.compare(((Number) prev).doubleValue(), ((Number) curr).doubleValue());
        super.setUp();
import org.apache.lucene.store.NIOFSDirectory;
                        verifyRowCount(snapshot, totalDocs);  
    }  
                .toList();  
        verifyLuceneRowIdSequential();
                    matchedDocs++;  
        List<String> sortOrders,
        }
     */  
                snap.getSegments().size() <= refreshCycles
            int cmp = compareValues(prevVal, currVal, desc, nullsFirst);
                "Expected segment count <= "
            ParquetDataFormatPlugin.class,
        Path parquetDir = getParquetDir();
        verifyRowCount(snapshot, totalDocs);
            .build();  
        }  
                        .setSource("name", randomAlphaOfLength(10), "age", randomIntBetween(0, 100))
                        client().admin().indices().prepareDelete(INDEX_NAME).get();  
                        json  
    @SuppressForbidden(reason = "JSON parsing for generic sort verification")  
            .setSettings(settings)
            if (parquetWfs == null) continue;
    // Private helpers: merge feature flag  
                        "val_double",  
        int totalDocs = numThreads * docsPerThread;
     *
     * </ol>
            .setMapping("name", "type=keyword", "age", "type=integer")  
                    Object prevAge = rows.get(i - 1).get("age");  
                        verifySortOrderGeneric(snapshot, List.of(fieldName), List.of(order), List.of(missing));
                    );
import org.opensearch.index.engine.exec.Segment;  
                    }
            .setSettings(sortedParquetPrimaryLuceneSecondarySettings())
    private static void disableMerge() {  
import org.opensearch.arrow.allocator.ArrowBasePlugin;
            for (String file : parquetWfs.files()) {  
        // Verify lucene doc count
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
    private Settings sortedParquetPrimaryLuceneSecondarySettings() {
                        }  
        assertTrue("Catalog should contain 'lucene'", formats.contains("lucene"));  
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");  
        verifyLuceneDocCount(totalDocs);
                ) {
            cleanups
    // ══════════════════════════════════════════════════════════════════════  
    }
import java.util.List;  
    @Override  
    }  
    // ══════════════════════════════════════════════════════════════════════  
                            assertNotNull(
     * This is the critical test for RowIdMapping correctness in sorted merges —
            "unreferencedFileCleanUpsPerformed should be 0 after successful merge (only tracks merge failure cleanups)",  
        // for per-writer temporary staging directories (lucene_gen_*), not for the committed merged index.  
        int refreshCycles = 15;
                assertEquals(RestStatus.CREATED, response.status());
        verifyRowCount(snapshot, totalDocs);
    /**
                List<Map<String, Object>> rows;
    @SuppressForbidden(reason = "enable pluggable dataformat merge for integration testing")  
                    + " (inline consolidation or background merge), but got: "  
import org.opensearch.index.engine.exec.WriterFileSet;
            .setSettings(sortedParquetPrimaryLuceneSecondarySettings())
                    if (ageDV != null && ageDV.advanceExact(doc)) {  
        ensureGreen(INDEX_NAME);
                    // nulls first for age  
            );  
 *
                "type=date",  
    private static void enableMerge() {
                        return m;  
                        }
        }
            .setMapping("name", "type=keyword", "age", "type=integer")
    }  
import org.opensearch.parquet.bridge.ParquetFileMetadata;
                for (int doc = 0; doc < ctx.reader().maxDoc(); doc++) {
                            + " orders="  
import org.opensearch.common.settings.Settings;
                    .setIndex(INDEX_NAME)
                IndexResponse response = client().prepareIndex()  
                for (int i = 1; i < rows.size(); i++) {
                        randomIntBetween(-100, 100),
    public void testSortedMergeBySingleField() throws Exception {
            }  
            .put("index.pluggable.dataformat.enabled", true)
            .get();
        ensureGreen(INDEX_NAME);
        return Arrays.asList(
            0,
                            + extractSortValues(rows.get(i), sortFields)  
        Path parquetDir = getParquetDir();
                            rowId
                    }  
        // Verify lucene __row_id__ values are monotonically increasing (RowIdMapping applied)
    }  
import java.util.function.Supplier;
        // Both formats must be present in the single consolidated segment
        Set<String> formats = snapshot.getDataFormats();  
            }  
import org.apache.lucene.index.SortedSetDocValues;  
            .get();  
