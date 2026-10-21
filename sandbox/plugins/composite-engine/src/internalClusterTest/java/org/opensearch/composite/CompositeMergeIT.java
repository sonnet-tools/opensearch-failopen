// singleton that persists after tests complete. It polls for new async IO tasks between merges.
import org.opensearch.cluster.metadata.IndexMetadata;
                "type=date",
            for (String file : wfs.files()) {
import java.nio.file.Path;
        // Cross-format field value consistency
    public void setUp() throws Exception {
                }
        // Verify lucene __row_id__ values are monotonically increasing (RowIdMapping applied)
            .putList("index.composite.secondary_data_formats", "lucene")
        verifySegmentGenerationUniqueness(snapshot);
    public void testMergeStatsAfterMerge() throws Exception {
                        if (ord >= 0) {
        }
                parquetSegments.remove(matchingSegment);
            .setSettings(sortedParquetPrimaryLuceneSecondarySettings())
     *   <li>Both parquet and lucene formats are present</li>
            .put("index.pluggable.dataformat", "composite")
                    for (Object obj : parser.list()) {
     * the same reordering via the mapping.
                    try {
     *   <li>Lucene documents have monotonically increasing __row_id__ doc values
            .put("index.pluggable.dataformat.enabled", true)
        return getCatalogSnapshot();
        return Settings.builder()
                    + " (inline consolidation or background merge), but got: "
            Object currVal = curr.get(field);
                            .putList("index.sort.field", fieldName)
    // ══════════════════════════════════════════════════════════════════════
                ) {
                    startLatch.await();
     */
    /**
                Path filePath = parquetDir.resolve(file);
    /**
     */
        } else {
                referencedFiles.addAll(wfs.files());
        // Single refresh flushes all writers — triggers inline consolidation via fileMappings
            if (parquetWfs == null) continue;
        client().admin()
        assertTrue("Catalog should contain 'parquet' format, got: " + formats, formats.contains("parquet"));
            .indices()
import org.opensearch.parquet.ParquetDataFormatPlugin;
                Path filePath = parquetDir.resolve(file);
        assertEquals(
                    Object currAge = rows.get(i).get("age");
                assertTrue("Orphan parquet file on disk not referenced by catalog: " + diskFile, referencedFiles.contains(diskFile));
                    + refreshCycles
                        assertEquals("Age mismatch at row_id=" + luceneRowId, ((Number) parquetAge).longValue(), luceneAge);
    }
                "type=double",
        ensureGreen(INDEX_NAME);
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
import org.opensearch.parquet.bridge.RustBridge;
        int docsPerCycle = 10;
            for (int i = 0; i < docsPerCycle; i++) {
    private Path getLuceneDir() {
    }
                        Object prevName = rows.get(i - 1).get("name");
                    if (ageDV != null && ageDV.advanceExact(doc)) {
                assertNotNull("No parquet segment found with matching row count " + leafDocs, matchingSegment);
        System.setProperty(MERGE_ENABLED_PROPERTY, "true");
                        "age should be DESC but found " + prevAgeVal + " before " + currAgeVal + " at row " + i,
        indexDocsAcrossMultipleRefreshes(refreshCycles, docsPerCycle);
    /**
                assertEquals(RestStatus.CREATED, response.status());
            }
                snap.getSegments().size() <= refreshCycles
    }
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
     * <ol>
        int docsPerCycle = 5;
            .prepareCreate(INDEX_NAME)
            .get();
        flush(INDEX_NAME);
    }
                ParquetFileMetadata metadata = RustBridge.getFileMetadata(filePath.toString());
     *   <li>Merged parquet files have correct total row count</li>
    }
    @SuppressForbidden(reason = "enable pluggable dataformat merge for integration testing")
    }
            assertTrue(
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
    // Tests
            .get();
        int docsPerCycle = 5;
            cmp = Double.compare(((Number) prev).doubleValue(), ((Number) curr).doubleValue());
import org.opensearch.index.engine.exec.WriterFileSet;
     * Verifies sorted composite merge with Parquet primary (sorted) + Lucene secondary:
    }
                if (i % 5 == 0) {
import org.opensearch.index.shard.IndexShard;
        Map<String, Object> prev,
            int matchedDocs = 0;
                }
            .build();
     * Verifies that after a merge, getMergeStats() reports at least one completed merge
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(INDEX_NAME));
    }
        java.util.concurrent.CountDownLatch startLatch = new java.util.concurrent.CountDownLatch(1);
                        int refreshCycles = 15;
                    if (nameDV != null && nameDV.advanceExact(doc)) {
    private int compareValues(Object prev, Object curr, boolean desc, boolean nullsFirst) {
    // ══════════════════════════════════════════════════════════════════════
                                "Parquet row at " + DocumentInput.ROW_ID_FIELD + "=" + luceneRowId + " should have 'name' field",
        client().admin()
        // verify every row_id in the leaf resolves to a row in that segment with matching
     * Verifies that merge stats via the indices stats API (_stats/merge) reflects
        for (int cycle = 0; cycle < refreshCycles; cycle++) {
    @Override
    private void verifySegmentGenerationUniqueness(DataformatAwareCatalogSnapshot snapshot) {
        assertBusy(() -> {
            .clear()
                if (value == null) {
        int refreshCycles = 15;
     * correctly synchronized the two formats during merge.
        DataFormatAwareEngine engine = (DataFormatAwareEngine) org.opensearch.index.shard.IndexShardTestCase.getIndexer(shard);
     *   <li>Merged parquet files are sorted by age DESC (nulls first), name ASC (nulls last)</li>
        assertEquals("All segment generations must be unique", generations.size(), generations.stream().distinct().count());
        client().admin()
            .setMapping("name", "type=keyword", "age", "type=integer")
 *
                    response = client().prepareIndex()
    @Override
    private Settings parquetPrimaryLuceneSecondarySettings() {
            ParquetDataFormatPlugin.class,
                        @SuppressWarnings("unchecked")
        assertTrue("Total merges should be > 0 after merge", mergeStats.getTotal() > 0);
            return DataformatAwareCatalogSnapshot.deserializeFromString(snapshot.get().serializeToString(), Function.identity());
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                        "val_long",
        Path parquetDir = getParquetDir();
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
        DataformatAwareCatalogSnapshot snapshot = getCatalogSnapshot();
        // Verify total row count
                totalRows += metadata.numRows();
            .putList("index.sort.missing", "_first", "_last")
     * map would silently overwrite rows from segments that happen to share row_ids.
            0,
        Path luceneDir = getLuceneDir();
                            .putList("index.sort.missing", missing)
            .put("index.pluggable.dataformat", "composite")
            String fieldType = (String) spec[1];
    }
                    assertTrue(
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeNameResolved);
                    );
            .put("index.pluggable.dataformat.enabled", true)
    /**
        }
        Path luceneDir = getLuceneDir();
        if (prev == null && curr == null) return 0;
                        json
        // RowIdMapping correctness: __row_id__ must be sequential within each segment
                }
    }
            }
                            + ": prev="
                ) {
        DataformatAwareCatalogSnapshot snapshot,
    private void indexDocsWithNullsAcrossRefreshes(int refreshCycles, int docsPerCycle) {
            for (LeafReaderContext ctx : reader.leaves()) {
        // age/name values.
                        "val_date",
        try (GatedCloseable<CatalogSnapshot> snapshot = shard.getCatalogSnapshot()) {
        }
            cmp = prev.toString().compareTo(curr.toString());
                        ensureGreen(INDEX_NAME);
    }
 */
    /**
    @SuppressWarnings("unchecked")
            .setSettings(unsortedSettings())
            .indices()
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
     *   <li>Lucene __row_id__ values are sequential (RowIdMapping correctly applied)</li>
        for (Segment segment : snapshot.getSegments()) {
                    if (currAge == null) {
                        break;
import org.opensearch.arrow.allocator.ArrowBasePlugin;
            .indices()
    public void testSortedMergeBySingleField() throws Exception {
     * and unreferencedFileCleanUpsPerformed > 0 (old segment files were cleaned up).
    // ══════════════════════════════════════════════════════════════════════
                "type=long",
     * </ol>
                        NamedXContentRegistry.EMPTY,
    }
                    response = client().prepareIndex().setIndex(INDEX_NAME).setSource("name", randomAlphaOfLength(10)).get();
                "val_float",
     * and within same age, name in ASC order with nulls last.
                    );
    }
                if (rowIdDV == null) continue;
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
            Supplier<Object> valueSupplier = (Supplier<Object>) spec[2];
                            expectedRowId,
                        return m;
                        randomIntBetween(-100, 100),
                    }).toList();
// The Tokio IO runtime worker thread (used by the Rust merge k-way merge sort) is a process-lifetime
        DataformatAwareCatalogSnapshot snapshot = getCatalogSnapshot();
                        Settings settings = Settings.builder()
                        @SuppressWarnings("unchecked")
        if (prev == null) return nullsFirst ? -1 : 1;
                            + sortFields
        verifyRowCount(snapshot, totalDocs);
        }
                        }
     * When multiple writers flush in the same refresh cycle, the primary (Parquet) merges
        // Cross-format validation: for each segment, parquet rows == lucene segment docs
            throw error.get();
                .filter(f -> f.endsWith(".parquet"))
        Map<String, Object> curr,
        IndexShard shard = getPrimaryShard();
            .putList("index.sort.field", "age", "name")
        }
/*
        super.setUp();
        int docsPerCycle = 8;
        indexDocsAcrossMultipleRefreshes(refreshCycles, docsPerCycle);
    private IndexShard getPrimaryShard() {
                for (int doc = 0; doc < ctx.reader().maxDoc(); doc++) {
        int refreshCycles = 15;
                }
            mergeStats.getUnreferencedFileCleanUpsPerformed()
import java.util.Set;
                    )
    // ══════════════════════════════════════════════════════════════════════
import java.util.function.Supplier;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                        }
    public void testMergeStatsViaApi() throws Exception {
                                "name should be ASC but found '" + prevName + "' before '" + currName + "' at row " + i,
                assertEquals("WriterFileSet numRows should match actual file metadata for " + file, wfs.numRows(), metadata.numRows());
                    rows = parser.list().stream().map(o -> {
                        NamedXContentRegistry.EMPTY,
        int refreshCycles = 15;
        verifyLuceneRowIdSequential();
                            + sortMissing,
            .indices()
                            "Parquet row at " + DocumentInput.ROW_ID_FIELD + "=" + luceneRowId + " should have 'age' field",
            .setSettings(unsortedSettings())
                }
                assertEquals(RestStatus.CREATED, response.status());
     *   <li>Merge reduces segment count (merge actually happened)</li>
        long totalRows = 0;
    // ══════════════════════════════════════════════════════════════════════
    // Private helpers: shard/cluster accessors
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
                    }
                }
            .setMapping("name", "type=keyword", "age", "type=integer")
        }
                List<Map<String, Object>> rows;
            threads[t].start();
    private int compareRows(
        // For each Lucene leaf, find the parquet segment whose row count matches and
        ensureGreen(INDEX_NAME);
 * this file be licensed under the Apache-2.0 license or a
        verifyNoOrphanFiles(snapshot);
     *       (confirms RowIdMapping was applied during secondary merge)</li>
        // (only unique within a segment, so a per-segment map is required).
                    Object prevAge = rows.get(i - 1).get("age");
            .get();
                SortedNumericDocValues rowIdDV = ctx.reader().getSortedNumericDocValues(DocumentInput.ROW_ID_FIELD);
    }
                    .setSource("name", randomAlphaOfLength(10), "age", randomIntBetween(1, 1000))
                        randomFloat() * 200 - 100,
        String nodeName = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
            .indices()
            Object prevVal = prev.get(field);
                            rowId
    @Override
                        indexRandomDocs(refreshCycles, docsPerCycle, fieldName, valueSupplier);
        ensureGreen(INDEX_NAME);
                SortedSetDocValues nameDV = ctx.reader().getSortedSetDocValues("name");
    // ══════════════════════════════════════════════════════════════════════
                    )
                        long rowId = rowIdDV.nextValue();
        DataformatAwareCatalogSnapshot snapshot = getCatalogSnapshot();
        }
    public void testSortedMergeMultiColumnRandomized() throws Exception {
            }
        ensureGreen(INDEX_NAME);
        }
     * the primary format reorders rows during merge, and the secondary must apply
        int numThreads = 8;
        try (var stream = Files.list(parquetDir)) {
        int totalDocs = refreshCycles * docsPerCycle;
            .putList("index.sort.order", orders)
    // ══════════════════════════════════════════════════════════════════════
                            + i
                "type=integer",
        int docsPerThread = 5;
                            .put(unsortedSettings())
                            + " orders="
    }
    private void verifyNoOrphanFiles(DataformatAwareCatalogSnapshot snapshot) throws IOException {
                        Map<String, Object> m = (Map<String, Object>) o;
                    assertTrue(
                    }
                Object value = valueSupplier.get();
                try {
     * with correct row count and source files cleaned up.
        Path parquetDir = getParquetDir();
                totalLuceneDocs += leafDocs;
    }
 * compatible open source license.
            .get();
    // ── Helpers for randomized tests ──
     */
    // ── Randomized sort tests across data types ──
    }
     *   <li>Lucene __row_id__ values are sequential (RowIdMapping applied)</li>
            .indices()
     * </ol>
                        now - randomLongBetween(0, 86400000L * 30),
        Path parquetDir = getParquetDir();
        for (int cycle = 0; cycle < refreshCycles; cycle++) {
    @SuppressForbidden(reason = "JSON parsing for test verification of parquet output")
        Set<String> formats = snapshot.getDataFormats();
    public void testUnsortedMergeWithAllTypes() throws Exception {
                .map(p -> p.getFileName().toString())
    /**
        if (curr == null) return nullsFirst ? 1 : -1;
                                + doc,
        client().admin()
                            assertTrue(
                    if (prevAge == null) continue; // null before non-null is correct
import org.opensearch.index.engine.exec.Segment;
        // Both formats must be present in the single consolidated segment
    private DataformatAwareCatalogSnapshot getCatalogSnapshot() throws IOException {
            new Object[] { "value_float", "type=float", (Supplier<Object>) () -> randomBoolean() ? null : randomFloat() * 1000 },
        // Accept: segment count <= refreshCycles (inline consolidation working correctly).
                            parquetAge
            // index may not exist if test failed before creation
    }
        }
        // Use concurrent threads to fill multiple writers in a single refresh cycle.
                                + " but got "
            .prepareCreate(INDEX_NAME)
            }
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        );
                        "val_float",
        indexDocsAcrossMultipleRefreshes(refreshCycles, docsPerCycle);
            Map<Long, Map<String, Object>> rowsInSegment = new java.util.HashMap<>();
                    response = client().prepareIndex().setIndex(INDEX_NAME).setSource(fieldName, value).get();
            .put(super.nodeSettings(nodeOrdinal))
                IndexResponse response = client().prepareIndex().setIndex(INDEX_NAME).setSource(source).get();
        verifyRowCount(snapshot, totalDocs);
    public void testMergeOnRefresh() throws Exception {
            LucenePlugin.class,
            cmp = ((String) prev).compareTo((String) curr);
        IndexShard shard = getPrimaryShard();
            }
            assertEquals("All lucene docs should have matching parquet rows", totalLuceneDocs, matchedDocs);
        String[] orders = { randomFrom("asc", "desc"), randomFrom("asc", "desc"), randomFrom("asc", "desc") };
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
import java.io.IOException;
        waitForMerge(refreshCycles);
    }
        for (int f = 0; f < sortFields.size(); f++) {
                        "val_int",
            for (String diskFile : diskFiles) {
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
        try {
        waitForMerge(refreshCycles);
                    Map<String, Object> parquetRow = matchingSegment.get(luceneRowId);
            .prepareCreate(INDEX_NAME)
                String json = RustBridge.readAsJson(filePath.toString());
            }
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
    @SuppressForbidden(reason = "JSON parsing for cross-format data comparison")
    // Private helpers: indexing
            if (rowsInSegment.isEmpty() == false) {
     * the corresponding Lucene document (sorted by __row_id__) has matching field values.
     * Correctness criteria:
        ensureGreen(INDEX_NAME);
    // Framework lifecycle & configuration
            .setMapping("name", "type=keyword", "age", "type=integer")
                "val_date",
    // Private helpers: merge feature flag
    private Settings unsortedSettings() {
            .prepareCreate(INDEX_NAME)
        ensureGreen(INDEX_NAME);
        verifyRowCount(snapshot, totalDocs);
                        NamedXContentRegistry.EMPTY,
    private void indexRandomDocs(int refreshCycles, int docsPerCycle, String fieldName, Supplier<Object> valueSupplier) {
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
                            );
import org.opensearch.core.xcontent.NamedXContentRegistry;
                        json
                                parquetName
            .setMerge(true)
        int totalDocs = refreshCycles * docsPerCycle;
    @SuppressForbidden(reason = "restore pluggable dataformat merge property after test")
            boolean desc = "desc".equals(sortOrders.get(f));
                if (rows.size() <= 1) continue;
     * Verifies that merged parquet files have age in DESC order with nulls first,
            for (String file : wfs.files()) {
        assertTrue("Should have parquet rows to compare", parquetSegments.isEmpty() == false);
                (Supplier<Object>) () -> randomBoolean() ? null : randomLongBetween(-1_000_000L, 1_000_000L) },
            .prepareCreate(INDEX_NAME)
                    assertNotNull(
            for (int i = 0; i < docsPerCycle; i++) {
                    .get();
    private void verifyRowCount(DataformatAwareCatalogSnapshot snapshot, int expectedTotalDocs) throws IOException {
        int docsPerCycle = 5;
        enableMerge();
     */
            .setMapping("name", "type=keyword", "age", "type=integer")
     *
            .putList("index.sort.field", fields)
            t.join();
        assertTrue("Total merges via API should be > 0", mergeStats.getTotal() > 0);
        String[] missings = { randomFrom("_first", "_last"), randomFrom("_first", "_last"), randomFrom("_first", "_last") };
                        long rowId = ((Number) row.get(DocumentInput.ROW_ID_FIELD)).longValue();
        int refreshCycles = 15;
        for (Segment segment : snapshot.getSegments()) {
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            .put("index.refresh_interval", "-1")
                                + rowId
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
        } else if (prev instanceof String && curr instanceof String) {
     * This is the critical test for RowIdMapping correctness in sorted merges —
                var source = new java.util.HashMap<String, Object>();
    ) throws Exception {
        return shard.shardPath().getDataPath().resolve("parquet");
                        parquetRow
                "val_double",
        return Settings.builder()
        // Verify lucene merged directory has correct doc count
    }
                    }
                "type=double",
            }
        org.opensearch.index.merge.MergeStats mergeStats = statsResponse.getIndex(INDEX_NAME).getShards()[0].getStats().getMerge();
    }
import org.apache.lucene.index.LeafReaderContext;
     * Verifies composite merge with Parquet as primary and Lucene as secondary:
                        fail("age null should come before non-null, but found non-null at " + (i - 1) + " and null at " + i);
import org.opensearch.be.lucene.LucenePlugin;
                "type=date",
        int refreshCycles = 15;
import org.apache.lucene.index.DirectoryReader;
            .indices()
     * Sequential (not just monotonic) is required because the RowIdMapping produces
            .putList("index.sort.missing", missings)
                        rowsInSegment.put(rowId, row);
                        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(settings).setMapping(fieldName, fieldType).get();
     * (each segment starts row_ids at 0), so rows must be grouped per segment — a global
        List<String> sortMissing
        Settings settings = Settings.builder()
        return 0;
                    if (candidate.size() == leafDocs) {
                        cmp <= 0
                        Map<String, Object> row = (Map<String, Object>) obj;
     * a dense mapping — every position from 0..N-1 must be covered.
     * the same mapping. This test uses concurrent indexing to fill multiple writers, then
            .indices()
    // ══════════════════════════════════════════════════════════════════════
                        "val_double",
        for (int cycle = 0; cycle < refreshCycles; cycle++) {
            for (String order : List.of("asc", "desc")) {
        }
        assertTrue("Catalog should contain 'lucene' format, got: " + formats, formats.contains("lucene"));
     * <ol>
        Path luceneDir = getLuceneDir();
            String field = sortFields.get(f);
import java.util.Map;
                "value_long",
                int leafDocs = ctx.reader().maxDoc();
            if (wfs != null) {
    // ══════════════════════════════════════════════════════════════════════
        // Merged lucene segments live in the shard's standard index folder (ShardPath.resolveIndex()),
                "type=float",
import org.opensearch.indices.IndicesService;
                if (Files.exists(filePath) == false) continue;
                source.values().removeIf(java.util.Objects::isNull);
    private void verifySortOrder(DataformatAwareCatalogSnapshot snapshot) throws Exception {
    }
            .setSettings(unsortedSettings())
                if (rows.size() <= 1) continue;
                    XContentParser parser = JsonXContent.jsonXContent.createParser(
                            Object parquetName = parquetRow.get("name");
        for (int cycle = 0; cycle < refreshCycles; cycle++) {
    /**
        }
        // Verify lucene doc count
        // in line with the other stable composite-merge tests and avoids triggering a second
                        .setSource("name", randomAlphaOfLength(10), "age", randomIntBetween(0, 100))
    private void verifySortOrderGeneric(
            for (int i = 0; i < docsPerCycle; i++) {
        waitForMerge(refreshCycles);
     *   <li>Merged lucene directory has correct total document count</li>
                    }
                        Object currName = rows.get(i).get("name");
                    response = client().prepareIndex().setIndex(INDEX_NAME).setSource(java.util.Collections.emptyMap()).get();
            assertEquals(RestStatus.OK, refreshResponse.getStatus());
                            fail("name nulls should be last, but found null at " + (i - 1) + " and non-null at " + i);
            .put("index.pluggable.dataformat.enabled", true)
}
    private void verifyLuceneRowIdSequential() throws IOException {
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
                            + sortOrders
            @SuppressWarnings("unchecked")
        for (int cycle = 0; cycle < refreshCycles; cycle++) {
        return Settings.builder()
            assertEquals(RestStatus.OK, refreshResponse.getStatus());
        Path parquetDir = getParquetDir();
                        Map<String, Object> m = (Map<String, Object>) o;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            for (String file : wfs.files()) {
                IndexResponse response = client().prepareIndex()
        assertTrue("Catalog should contain 'parquet'", formats.contains("parquet"));
import org.opensearch.action.index.IndexResponse;
            });
            .setMapping("name", "type=keyword", "age", "type=integer")
                String json = RustBridge.readAsJson(filePath.toString());
            String fieldName = (String) spec[0];
                            + " fields="
                    XContentParser parser = JsonXContent.jsonXContent.createParser(
        int totalDocs = refreshCycles * docsPerCycle;
            .build();
            new Object[] {
        verifySortOrderGeneric(snapshot, List.of(fields), List.of(orders), List.of(missings));
                        long ord = nameDV.nextOrd();
                        json
                        .setIndex(INDEX_NAME)
import java.nio.file.Files;
        List<String> sortOrders,
            0,
import org.opensearch.core.rest.RestStatus;
     *   <li>After refresh, catalog has 1 segment (consolidated) instead of N per-writer segments</li>
            }
                        "val_keyword",
import org.opensearch.index.engine.dataformat.DocumentInput;
                        expectedRowId++;
        // Index documents to create multiple segments. Using 15 cycles keeps the workload
            }
        assertTrue("Lucene directory should exist: " + luceneDir, Files.exists(luceneDir));
                IndexResponse response;
        assertEquals(
        }, 30, java.util.concurrent.TimeUnit.SECONDS);
            .put("index.composite.primary_data_format", "parquet")
                            );
                    .get();
        assertEquals(Set.of("parquet", "lucene"), snapshot.getDataFormats());
                        int totalDocs = refreshCycles * docsPerCycle;
            .setSettings(unsortedSettings())
     * <ol>
        assertNotNull("MergeStats from API should not be null", mergeStats);
                        if (prevName == null && currName != null) {
        for (int t = 0; t < numThreads; t++) {
                        randomLongBetween(-100000, 100000),
        return Settings.builder()
                try (
            }
import java.util.function.Function;
        long now = System.currentTimeMillis();
                        int docsPerCycle = 10;
        int docsPerCycle = 5;
     */
        int refreshCycles = 15;
import org.opensearch.index.engine.DataFormatAwareEngine;
                    if (rowIdDV.advanceExact(doc) == false) continue;
                "value_double",
                }
            threads[t] = new Thread(() -> {
                source.put("age", randomBoolean() ? null : randomIntBetween(0, 100));
        }
    private static void disableMerge() {
import org.opensearch.common.util.FeatureFlags;
        System.clearProperty(MERGE_ENABLED_PROPERTY);
import org.opensearch.plugins.Plugin;
        }
    private Path getParquetDir() {
                    for (int i = 0; i < docsPerThread; i++) {
        Set<String> formats = snapshot.getDataFormats();
        List<String> sortMissing
        );
                    )
            boolean nullsFirst = "_first".equals(sortMissing.get(f));
                        if (prevName != null && currName != null) {
     * </ol>
            for (int i = 0; i < docsPerCycle; i++) {
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
                        if (prevName != null && currName == null) continue; // non-null before null is correct for nulls last
            .put("index.composite.primary_data_format", "parquet")
            .build();
        // Verify parquet merged files have correct row count
            );
                        int docId = threadId * docsPerThread + i;
                    }
            .indices()
                    }
    public void tearDown() throws Exception {
            }
    protected Settings nodeSettings(int nodeOrdinal) {
                List<Map<String, Object>> rows;
    }
                            + file
        List<Map<Long, Map<String, Object>>> parquetSegments = new java.util.ArrayList<>();
                                ((String) prevName).compareTo((String) currName) <= 0
                    // Compare age field
        for (Thread t : threads) {
        verifyLuceneDocCount(totalDocs);
            .put("index.refresh_interval", "-1")
        );
                    if (prevAge == null && currAge == null) continue;
     * <p>Note: {@code __row_id__} is only unique <em>within</em> a catalog segment
            assertTrue("Should have matched at least some docs across formats", matchedDocs > 0);
                                + " at doc "
            .put("index.refresh_interval", "-1")
    // ══════════════════════════════════════════════════════════════════════
                            DocumentInput.ROW_ID_FIELD
        }
    }
                        }
        return Arrays.asList(
    private static void enableMerge() {
                "type=keyword"
            .prepareStats(INDEX_NAME)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                SortedNumericDocValues rowIdDV = ctx.reader().getSortedNumericDocValues(DocumentInput.ROW_ID_FIELD);
        // for per-writer temporary staging directories (lucene_gen_*), not for the committed merged index.
                        );
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
     *
     * Verifies background merge produces a valid merged parquet file and lucene segment
     *   <li>Cross-format consistency: parquet rows match lucene docs by row_id</li>
                                + " should be sequential within segment, expected "
                IndexResponse response;
    // ══════════════════════════════════════════════════════════════════════
    // Private helpers: verification
                    // nulls first for age
        IndexShard shard = getPrimaryShard();
            new Object[] {
import java.util.List;
    public void testSortedParquetPrimaryLuceneSecondaryMerge() throws Exception {
                    if (prevAgeVal == currAgeVal) {
                // Remove null entries so they appear as missing in the doc
                try (
                } catch (Exception e) {
        for (Segment segment : snapshot.getSegments()) {
        } catch (Exception e) {
    private Settings sortedParquetPrimaryLuceneSecondarySettings() {
import org.apache.lucene.store.NIOFSDirectory;
                        @SuppressWarnings("unchecked")
                String json = RustBridge.readAsJson(filePath.toString());
        assertTrue("Catalog should contain 'lucene'", formats.contains("lucene"));
            .prepareCreate(INDEX_NAME)
     * them and produces a RowIdMapping via fileMappings. The secondary (Lucene) then applies
            CompositeDataFormatPlugin.class,
                "Expected segment count <= "
    }
import java.util.Collection;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    int prevAgeVal = ((Number) prevAge).intValue();
            .setSettings(sortedParquetPrimaryLuceneSecondarySettings())
        for (Segment segment : snapshot.getSegments()) {
import org.opensearch.be.datafusion.DataFusionPlugin;
                        return m;
        String nodeNameResolved = getClusterState().nodes().get(nodeName).getName();
        }
    }
            .put("index.composite.primary_data_format", "parquet")
        verifyCrossFormatConsistency(snapshot);
import org.opensearch.common.SuppressForbidden;
                "val_keyword",
                        prevAgeVal >= currAgeVal
                        );
        }
            int cmp = compareValues(prevVal, currVal, desc, nullsFirst);
        long cleanups = engine.unreferencedFileCleanUpsPerformed();
                            + " in file "
        verifyCrossFormatConsistency(snapshot);
import org.opensearch.common.xcontent.json.JsonXContent;
        // Background merge may further reduce, but for small segments it may not fire.
            .setMapping("age", types[0], "score", types[1], "tag", types[2])
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
            ArrowBasePlugin.class,
                Map<Long, Map<String, Object>> matchingSegment = null;
        assertTrue("Catalog should contain 'parquet'", formats.contains("parquet"));
     *   <li>Cross-format consistency: parquet row data matches lucene data at same row_id</li>
    // ══════════════════════════════════════════════════════════════════════
        DataformatAwareCatalogSnapshot snapshot = waitForMerge(refreshCycles);
                            .build();
     * unreferenced_file_cleanups_performed after a merge.
        client().admin()
    }
public class CompositeMergeIT extends OpenSearchIntegTestCase {
                assertEquals(RestStatus.CREATED, response.status());
        verifySortOrder(snapshot);
                    matchedDocs++;
     * a single refresh to trigger consolidation.
        client().admin()
     * Verifies that __row_id__ doc values in merged lucene segments are sequential
                            String luceneName = nameDV.lookupOrd(ord).utf8ToString();
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
                source.put("score", randomBoolean() ? null : randomLongBetween(0, 10000));
        verifyRowCount(snapshot, totalDocs);
        Set<String> referencedFiles = new HashSet<>();
            .get();
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
        DataformatAwareCatalogSnapshot snapshot = waitForMerge(refreshCycles);
        ensureGreen(INDEX_NAME);
                        assertEquals(
                source.put("tag", randomBoolean() ? null : randomAlphaOfLengthBetween(3, 6));
                    }
     * Validates inline consolidation at refresh with fileMappings:
    /**
                        "Lucene doc with " + DocumentInput.ROW_ID_FIELD + "=" + luceneRowId + " should have a matching parquet row",
            DataFusionPlugin.class
    @SuppressForbidden(reason = "JSON parsing for generic sort verification")
        ensureGreen(INDEX_NAME);
                parquetSegments.add(rowsInSegment);
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
        }
            client().admin().indices().prepareDelete(INDEX_NAME).get();
        for (Segment segment : snapshot.getSegments()) {
import org.opensearch.common.concurrent.GatedCloseable;
        Set<String> formats = snapshot.getDataFormats();
                assertEquals(RestStatus.CREATED, response.status());
import org.apache.lucene.index.SortedNumericDocValues;
                        client().admin().indices().prepareDelete(INDEX_NAME).get();
        org.opensearch.action.admin.indices.stats.IndicesStatsResponse statsResponse = client().admin()
    private void verifyCrossFormatConsistency(DataformatAwareCatalogSnapshot snapshot) throws Exception {
        Thread[] threads = new Thread[numThreads];
                        .get();
                    int cmp = compareRows(rows.get(i - 1), rows.get(i), sortFields, sortOrders, sortMissing);
                            + extractSortValues(rows.get(i), sortFields)
                "val_int",
                } else {
            .build();
                            assertEquals("Name mismatch at row_id=" + luceneRowId, parquetName.toString(), luceneName);
        return desc ? -cmp : cmp;
            .setMapping("name", "type=keyword", "age", "type=integer")
        waitForMerge(refreshCycles);
        long now = System.currentTimeMillis();
            RefreshResponse refreshResponse = client().admin().indices().prepareRefresh(INDEX_NAME).get();
    }
                        DataformatAwareCatalogSnapshot snapshot = waitForMerge(refreshCycles);
        IndexShard shard = getPrimaryShard();
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
import org.opensearch.test.OpenSearchIntegTestCase;
     *   <li>Both "parquet" and "lucene" entries exist in the catalog snapshot</li>
                assertTrue("Parquet file should exist: " + filePath, Files.exists(filePath));
                            .putList("index.sort.order", order)
                try (
        }
     * segments, then verifies that for each row in parquet (identified by __row_id__),
    }
        verifyCrossFormatConsistency(snapshot);
        Path parquetDir = getParquetDir();
    /**
                            + extractSortValues(rows.get(i - 1), sortFields)
        List<String> sortFields,
                ) {
import org.opensearch.index.IndexService;
            .put("index.pluggable.dataformat", "composite")
        client().admin()
            "unreferencedFileCleanUpsPerformed should be 0 after successful merge (only tracks merge failure cleanups)",
            .setSettings(settings)
            int threadId = t;
     */
                for (int i = 1; i < rows.size(); i++) {
                    .setIndex(INDEX_NAME)
                if (rowIdDV == null) continue;
                Path filePath = parquetDir.resolve(file);
            List<String> diskFiles = stream.filter(Files::isRegularFile)
    }
                    XContentParser parser = JsonXContent.jsonXContent.createParser(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            new Object[] { "tag", "type=keyword", (Supplier<Object>) () -> randomBoolean() ? null : randomAlphaOfLengthBetween(3, 8) }
                        matchingSegment = candidate;
            }
package org.opensearch.composite;
     * Compares both numeric (age) and keyword (name) fields to ensure the RowIdMapping
                .toList();
                    int currAgeVal = ((Number) currAge).intValue();
    }
import java.util.Arrays;
 * SPDX-License-Identifier: Apache-2.0
                    rows = parser.list().stream().map(o -> {
    }
                            assertNotNull(
            if (cmp != 0) return cmp;
                    }
            for (LeafReaderContext ctx : reader.leaves()) {
                }
        verifyLuceneRowIdSequential();
                            + " missing="
    }
    private static final String INDEX_NAME = "test-composite-merge";
        List<Long> generations = snapshot.getSegments().stream().map(Segment::generation).toList();
        verifyLuceneDocCount(totalDocs);
     * (Parquet) merge was correctly applied to reorder Lucene documents.
    }
            .putList("index.composite.secondary_data_formats", "lucene")
     */
    // Merge stats tests
        startLatch.countDown();
                        randomAlphaOfLength(6)
                    // Compare name field (keyword stored as sorted set doc values)
            .get();
        );
            .prepareCreate(INDEX_NAME)
        org.opensearch.index.merge.MergeStats mergeStats = engine.getMergeStats();
                }
                "timestamp",
        // With refresh_interval=-1 and no explicit refresh, all docs land in the writer pool.
        assertEquals("Total rows across all segments should match ingested docs", expectedTotalDocs, totalRows);
    ) {
        }
import org.opensearch.core.xcontent.XContentParser;
                        randomDoubleBetween(-1000, 1000, true),
        int totalDocs = refreshCycles * docsPerCycle;
import java.util.HashSet;
                        long luceneAge = ageDV.nextValue();
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
            .get();
import org.apache.lucene.index.SortedSetDocValues;
                (Supplier<Object>) () -> randomBoolean() ? null : now - randomLongBetween(0, 86400000L * 365) },
    private DataformatAwareCatalogSnapshot waitForMerge(int refreshCycles) throws Exception {
            .setMapping(
        int docsPerCycle = 10;
        verifyRowCount(snapshot, totalDocs);
                    .setIndex(INDEX_NAME)
            DataformatAwareCatalogSnapshot snap = getCatalogSnapshot();
    private void verifyLuceneDocCount(int expectedTotalDocs) throws IOException {
        List<String> sortFields,
    private static final String MERGE_ENABLED_PROPERTY = "opensearch.pluggable.dataformat.merge.enabled";
        int cmp;
        java.util.concurrent.atomic.AtomicReference<Exception> error = new java.util.concurrent.atomic.AtomicReference<>();
    }
            cleanups
            "unreferencedFileCleanUpsPerformed via API should be 0 after successful merge (only tracks merge failure cleanups)",
        return sortFields.stream().map(row::get).toList();
        assertNotNull("MergeStats should not be null", mergeStats);
        verifyLuceneDocCount(totalDocs);
    private void indexDocsAcrossMultipleRefreshes(int refreshCycles, int docsPerCycle) {
        int totalDocs = numThreads * docsPerThread;
    @Override
     * Each Lucene leaf is matched to its parquet segment by row count.
                } else {
            int totalLuceneDocs = 0;
        // Both formats must be present in the catalog
                for (int i = 1; i < rows.size(); i++) {
                "val_long",
            for (int i = 0; i < docsPerCycle; i++) {
            assertNotNull("Segment should have parquet files", wfs);
                                + expectedRowId
                SortedNumericDocValues ageDV = ctx.reader().getSortedNumericDocValues("age");
                Path filePath = parquetDir.resolve(file);
        return indexService.getShard(0);
                }
            }
        }
        if (prev instanceof Number && curr instanceof Number) {
    public void testParquetPrimaryLuceneSecondaryMerge() throws Exception {
        verifyRowCount(snapshot, totalDocs);
                    }).toList();
        int refreshCycles = 15;
                for (int doc = 0; doc < leafDocs; doc++) {
            .putList("index.sort.order", "desc", "asc")
                        "Sort order violated at row "
     */
                        assertNotNull(
            }
        client().admin()
     * Cross-format data comparison: reads merged parquet file content and merged lucene
        String[] types = { "type=integer", "type=long", "type=keyword" };
        return shard.shardPath().resolveIndex();
            }
    }
            .setSettings(parquetPrimaryLuceneSecondarySettings())
    // ══════════════════════════════════════════════════════════════════════
    }
        // With inline merge at refresh, each cycle already produces 1 consolidated segment.
        // Collect parquet rows grouped per catalog segment, indexed by __row_id__
                    if (rowIdDV.advanceExact(doc)) {
            .putList("index.composite.secondary_data_formats", "lucene")
                    )
     *   <li>Merge reduces segment count</li>
                assertEquals(RestStatus.CREATED, response.status());
        assertTrue("Catalog should contain 'lucene'", formats.contains("lucene"));
        DataformatAwareCatalogSnapshot snapshot = waitForMerge(refreshCycles);
        int totalDocs = refreshCycles * docsPerCycle;
        List<String> sortOrders,
        }
                    .setSource(
            )
                    }
                        verifyRowCount(snapshot, totalDocs);
                IndexResponse response = client().prepareIndex()
        List<Object[]> fieldSpecs = List.of(
    // Private helpers: index settings
        indexDocsAcrossMultipleRefreshes(refreshCycles, docsPerCycle);
                    // When age is equal, verify name ASC (nulls last)
                    );
        for (Object[] spec : fieldSpecs) {
                for (Map<Long, Map<String, Object>> candidate : parquetSegments) {
                (Supplier<Object>) () -> randomBoolean() ? null : randomDoubleBetween(-1e6, 1e6, true) },
                }
    private List<Object> extractSortValues(Map<String, Object> row, List<String> sortFields) {
            WriterFileSet parquetWfs = segment.dfGroupedSearchableFiles().get("parquet");
            for (String file : parquetWfs.files()) {
        // cascaded merge before the first one commits.
     *
        if (error.get() != null) {
     *   <li>Cross-format validation: parquet row count == lucene doc count for each merged segment</li>
                    } finally {
            RefreshResponse refreshResponse = client().admin().indices().prepareRefresh(INDEX_NAME).get();
        }
     */
        disableMerge();
    // ══════════════════════════════════════════════════════════════════════
            assertEquals("Total lucene docs should match ingested docs", expectedTotalDocs, reader.numDocs());
                        client().prepareIndex(INDEX_NAME).setSource("name", "doc_" + docId, "age", randomIntBetween(0, 100)).get();
                    error.compareAndSet(null, e);
            .prepareCreate(INDEX_NAME)
            .get();
     * (0, 1, 2, ...) within each leaf. This confirms the RowIdMapping from the primary
import org.apache.lucene.store.Directory;
                        Object parquetAge = parquetRow.get("age");
 * The OpenSearch Contributors require contributions made to
                long expectedRowId = 0;
            .build();
import org.opensearch.core.xcontent.DeprecationHandler;
                    long luceneRowId = rowIdDV.nextValue();
                for (String missing : List.of("_first", "_last")) {
    // ══════════════════════════════════════════════════════════════════════
        verifyLuceneRowIdSequential();
                }
                    + snap.getSegments().size(),
    public void testBackgroundMerge() throws Exception {
        // which resolves to "<shardDataPath>/index". The "<shardDataPath>/lucene" folder is only used
            .get();
                "type=long",
import org.opensearch.parquet.bridge.ParquetFileMetadata;
            .put(unsortedSettings())
        indexDocsWithNullsAcrossRefreshes(refreshCycles, docsPerCycle);
    // ══════════════════════════════════════════════════════════════════════
     *
                            + " curr="
                        verifySortOrderGeneric(snapshot, List.of(fieldName), List.of(order), List.of(missing));
import org.opensearch.common.settings.Settings;
            new Object[] {
        String[] fields = { "age", "score", "tag" };
        super.tearDown();
     *
