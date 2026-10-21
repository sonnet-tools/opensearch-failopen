            );
        try {
        // __row_id__ present in all docs
 * Requires JDK 25 and sandbox enabled. Run with:
    public void testAdaptiveKeywordPromotionRetiresActiveScalarWriterWithoutRefresh() throws Exception {
    public void testConcurrentDynamicUpdatesWithLuceneSecondary() throws Throwable {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 1)
                "Expected type conflict error but got: " + e.getMessage(),
        // Verify that the lucene index has the expected indexed fields (inverted index)
        for (int i = 0; i < numThreads; i++) {
            fail("Indexing request should have failed!");
                    error.compareAndSet(null, t);
        assertEquals(
            }
    // Private helpers: index settings
            .indices()
        Map<String, Object> initialFieldMapping = clusterStateFieldMapping(indexName, "tags");
        long rowsWithRowId = luceneRows.stream().filter(r -> r.containsKey("__row_id__")).count();
            RestStatus.CREATED,
    private static final String INDEX_NAME = "test-dynamic-mapping";
                        } else if (fi.getDocValuesType() == DocValuesType.SORTED_SET) {
            CompositeDataFormatPlugin.class,
     * Verifies the complete AUTO promotion path: the first scalar row is committed with a scalar
                    // forceMerge throws if background merges are active — retry
    }
import org.opensearch.core.xcontent.NamedXContentRegistry;
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
 * --tests "*.CompositeDynamicMappingIT" \
        assertEquals(2, rows.size());
        assertEquals("Lucene doc count should be 64", 64, luceneRows.size());
        }
        List<Path> paths = new ArrayList<>();
        List<Map<String, Object>> luceneRows = readAllLuceneDocs(luceneDir);
     * The Lucene secondary stores inverted indexes for search but not doc values for field values.
        assertTrue("every document must persist as a LIST", rows.stream().allMatch(row -> isListColumn(row.get("tags"))));
                .get();
    /**
import org.opensearch.index.engine.exec.WriterFileSet;
                    }
        return Arrays.asList(
            assertNotNull("Parquet file metadata should not be null: " + pf, meta);
        assertTrue(createResponse.isAcknowledged());
                    allFields.contains(expected)
    private List<Map<String, Object>> refreshFlushAndReadParquetRows(String indexName) throws IOException {
                    error.compareAndSet(null, e);
        assertTrue(createResponse.isAcknowledged());
        return (Map<String, Object>) properties.get(fieldName);
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
                } catch (Throwable t) {
                for (FieldInfo fi : ctx.reader().getFieldInfos()) {
    // ══════════════════════════════════════════════════════════════════════
    }
                .indices()
import org.opensearch.arrow.allocator.ArrowBasePlugin;
/**
        for (Map<String, Object> row : rows) {
        assertTrue(createResponse.isAcknowledged());
import org.opensearch.test.OpenSearchIntegTestCase;
import org.apache.lucene.index.SortedSetDocValues;
    private void assertMappingsContain(String indexName, String... expectedFields) throws Exception {
            allRows.addAll(parseJsonRows(RustBridge.readAsJson(pf.toString())));
        }
    public void testConcurrentAutoPromotionAcrossIndices() throws Throwable {
import org.opensearch.be.lucene.LucenePlugin;
                }
        CreateIndexResponse createResponse = client().admin()
            assertEquals(Boolean.TRUE, clusterStateFieldMapping(indexName, "tags").get("multi_value"));
            .get();
    }
                    "dynamic_value_" + i,
            indexNames.add(indexName);
 * this file be licensed under the Apache-2.0 license or a
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
     * the physical Parquet column is LIST, and the element values are asserted directly by callers.
    // ══════════════════════════════════════════════════════════════════════
            assertTrue(
        String indexName = "test-adaptive-active-writer";
        });
 * <p>
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
     * indexing request is retried and persisted as a LIST row.
                        Object tags = ((threadId * 31 + operation * 17) & 3) == 0 ? List.of(value, "shared") : value;
        ensureGreen(indexName);
        assertEquals("All 32 fieldB values should be present", numThreads, foundB.size());
                    assertEquals("Segment count after force merge should be 1", 1, cs.get().getSegments().size());
                    (long) i * 1000
    // ══════════════════════════════════════════════════════════════════════
            assertConcurrentFieldValues(parquetRows, numThreads);
        client().admin().indices().prepareRefresh(indexName).get();
            assertEquals(RestStatus.CREATED, response.status());
        List<Map<String, Object>> allRows = new ArrayList<>();
        String indexName = "test-adaptive-keyword";
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
    // ══════════════════════════════════════════════════════════════════════
            .setSettings(parquetPrimaryLuceneSecondarySettings())
                .prepareCreate(indexName)
    }
            Set<String> allFields = new HashSet<>();
    }
import org.apache.lucene.index.LeafReader;
            .get();
import java.util.Collection;
            client().prepareIndex(indexName).setSource("tags", List.of("prod", "error", "prod")).get().status()
    }
            for (String expected : expectedFields) {
    private Settings parquetOnlySettings() {
import org.opensearch.common.util.FeatureFlags;
    /**
        Map<String, Object> properties = (Map<String, Object>) mappingSource.get("properties");
        String indexName = "test-scalar-keyword";
     * Asserts that the given fields exist in the Lucene index as indexed fields (inverted index).
            .put(super.nodeSettings(nodeOrdinal))
                    startLatch.await();
                .get();
        assertEquals("Lucene should have 10 docs", 10, luceneRows.size());
            threads[i].start();
        // Index docs with dynamic fields
    // Private helpers: lucene verification
                                if (ord >= 0) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        ) {
                }
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
import org.apache.lucene.index.DirectoryReader;
     */
 */
import java.util.ArrayList;
        // Verify parquet
                        }
        assertBusy(() -> {
        final int indexCount = 3;
        Settings settings = Settings.builder().put(parquetPrimaryLuceneSecondarySettings()).put("index.refresh_interval", "-1").build();
import org.apache.lucene.index.LeafReaderContext;
     * scalar column reads back as its primitive value. Matching a {@link List} therefore verifies
        assertEquals(2, rows.size());
 * and the resulting Parquet files should contain all fields including dynamically added ones.
    /**
import java.nio.file.Path;
        assertTrue(createResponse.isAcknowledged());
    private void assertDynamicFieldCount(List<Map<String, Object>> rows, String fieldName, long expectedCount) {
     * flush occurs between the scalar and LIST documents, so the second write must reconcile the
            @SuppressWarnings("unchecked")
        }
        indexDocsWithDynamicFields(indexName, 5, 10);
            threads[i] = new Thread(() -> {
        }
     * <p>
        for (Segment segment : snapshot.get().getSegments()) {
    }
    }
        String indexName = "test-concurrent-composite";
            );
    }
    /**
            .prepareCreate(indexName)
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
    // ══════════════════════════════════════════════════════════════════════
        }
        try (GatedCloseable<List<Path>> parquetFilesRef = listParquetFiles(parquetDir, shard)) {
import java.util.List;
        refreshAndFlush(indexName);
            .indices()
        assertBusy(() -> {
        assertEquals(Boolean.FALSE, clusterStateFieldMapping(indexName, "tags").get("multi_value"));
                    IndexResponse respA = client().prepareIndex(indexName).setSource("fieldA_" + threadId, "valueA_" + threadId).get();
        return Settings.builder()
import java.io.IOException;
    /**
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.index.shard.ShardId;
                                }
        long count = rows.stream().filter(row -> row.containsKey(fieldName) && row.get(fieldName) != null).count();
        );
     */
            rows.stream().anyMatch(row -> List.of("one", "two", "one").equals(row.get("tags")))
    private void refreshAndFlush(String indexName) {
            return parser.list().stream().map(o -> (Map<String, Object>) o).collect(Collectors.toList());
        );
    }
        assertEquals(Boolean.FALSE, clusterStateFieldMapping(indexName, "tags").get("multi_value"));
                try (GatedCloseable<CatalogSnapshot> cs = getIndexShard(indexName).getCatalogSnapshot()) {
        IndexShard shard = getIndexShard(indexName);
        assertEquals(mappingVersion, getClusterState().metadata().index(indexName).getMappingVersion());
        client().admin().indices().prepareFlush(indexName).get();
        GatedCloseable<CatalogSnapshot> snapshot = shard.getCatalogSnapshot();
    }
            .indices()
                    client().admin().indices().prepareRefresh(indexName).get();
    }
            assertEquals("Parquet should have 10 rows", 10, parquetRows.size());
                .setSettings(settings)
        }
     * and writer rotations race with other writes.
        List<Map<String, Object>> luceneRows = readAllLuceneDocs(luceneDir);
     */
 * compatible open source license.
    private Map<String, Object> clusterStateFieldMapping(String indexName, String fieldName) {
                if (("valueB_" + i).equals(row.get("fieldB_" + i))) foundB.add("fieldB_" + i);
    // ══════════════════════════════════════════════════════════════════════
            totalRows += meta.numRows();
        AtomicReference<Throwable> error = new AtomicReference<>();
    // Private helpers: indexing
import org.opensearch.parquet.bridge.RustBridge;
            }
import java.util.Set;
                    "field_keyword",
    }
     * Note: The Lucene secondary writer stores inverted indexes for text/keyword fields
    /**
            assertEquals("every successful request must be persisted", expectedDocumentsPerIndex, rows.size());
            .indices()
        assertEquals("All 32 fieldA values should be present", numThreads, foundA.size());
            .indices()
     * Tests dynamic mapping with parquet primary + lucene secondary.
                .setIndex(indexName)
        for (Path pf : parquetFiles) {
        client().admin().indices().prepareRefresh(indexName).get();
    public void testAdaptiveKeywordPromotionUpdatesClusterStateAndRetriesDocument() throws Exception {
     * (for search) and __row_id__ as doc values (for cross-format correlation).
            for (int i = 0; i < numThreads; i++) {
        // Refresh + flush
        if (error.get() != null) {
import java.util.Map;
            }
                    paths.add(parquetDir.resolve(file));
            .put("index.pluggable.dataformat", "composite")
        // Verify parquet
        }
import org.apache.lucene.store.NIOFSDirectory;
            .prepareCreate(indexName)
    private GatedCloseable<List<Path>> listParquetFiles(Path parquetDir, IndexShard shard) throws IOException {
                    "dynamic_long",
            .get();
     * serialized as JSON arrays, so a nested (LIST) column reads back as a {@link List} while a
    private List<Map<String, Object>> readAllParquetRows(List<Path> parquetFiles) throws IOException {
        final AtomicReference<Throwable> error = new AtomicReference<>();
        client().prepareIndex(indexName).setSource("foo", 3).get();
        );
            assertBusy(() -> assertEquals(Boolean.TRUE, clusterStateFieldMapping(indexName, "tags").get("multi_value")));
                    startLatch.await();
            () -> client().prepareIndex(indexName).setSource("tags", List.of("one", "two")).get()
        String indexName = "test-dynamic-composite";
    private void indexDocsWithDynamicFields(String indexName, int from, int to) {
                if (("valueA_" + i).equals(row.get("fieldA_" + i))) foundA.add("fieldA_" + i);
        client().admin().indices().prepareRefresh(indexName).get();
    // The best way to do so is to trigger a force merge to single segment and ensure it completes so that no merges will happen again until
            expectedFields[i * 2] = "fieldA_" + i;
        Set<String> foundB = new HashSet<>();
import org.opensearch.parquet.ParquetDataFormatPlugin;
        String indexName = "test-list-keyword";
     * Asserts that the given fields are present in the index mapping, polling with assertBusy
    /** Verifies that explicit LIST state writes scalar input as a singleton list and arrays unchanged. */
            .build();
            assertEquals("Parquet total rows should be 64", 64, getParquetRowCount(parquetFiles));
        // Verify all dynamic fieldA_*/fieldB_* are indexed in Lucene
            .indices()
                    "dynamic_text",
            if (wfs != null) {
        for (int i = 0; i < numThreads; i++) {
package org.opensearch.composite;
                } catch (Exception e) {
        for (int i = 0; i < indexCount; i++) {
        try (GatedCloseable<List<Path>> parquetFilesRef = listParquetFiles(parquetDir, shard)) {
import java.util.concurrent.CountDownLatch;
    public void testExplicitListKeywordPersistsListShapeForEveryDocument() throws Exception {
        ensureGreen(indexName);
        }
            thread.join();
            .setSettings(parquetPrimaryLuceneSecondarySettings())
     * active writer, preserve its scalar row, and retry against a new LIST writer.
        assertEquals(expectedCount + " rows should have " + fieldName + " field populated", expectedCount, count);
     * Reads all documents from a Lucene index directory, extracting doc values fields
        assertEquals(1, rows.size());
            assertDynamicFieldCount(parquetRows, "dynamic_long", 5);
            .setSettings(parquetPrimaryLuceneSecondarySettings())
                }
        List<Map<String, Object>> rows = refreshFlushAndReadParquetRows(indexName);
                .setMapping("tags", "type=keyword")
                        int indexOrdinal = (threadId + operation) % indexCount;
    // ══════════════════════════════════════════════════════════════════════
                            throw new AssertionError("concurrent index request failed with " + response.status());
        }
        assertThat(
    }
import org.apache.lucene.store.Directory;
        startLatch.countDown();
            ParquetDataFormatPlugin.class,
        IndexResponse listResponse = client().prepareIndex(indexName).setSource("tags", List.of("prod", "error", "prod")).get();
                    rows.add(row);
 * Integration test validating dynamic mapping support with composite parquet index.
            .prepareCreate(indexName)
     * Verifies that promotion retires a scalar writer that still holds buffered rows. No refresh or
        long initialMappingVersion = getClusterState().metadata().index(indexName).getMappingVersion();
            assertTrue(
                    "value_" + i,
                )
     */
        Exception error = expectThrows(
                    client().admin().indices().prepareForceMerge(indexName).setMaxNumSegments(1).get();
    }
                    IndexResponse respB = client().prepareIndex(indexName).setSource("fieldB_" + threadId, "valueB_" + threadId).get();
        assertMappingsContain(indexName, expectedFields);
                try {
                            }
     * Verifies both formats contain all dynamically created fields.
        Set<String> foundA = new HashSet<>();
        List<Map<String, Object>> rows = refreshFlushAndReadParquetRows(indexName);
            rows.stream().anyMatch(row -> List.of("prod", "error", "prod").equals(row.get("tags")))
        }
import org.opensearch.core.xcontent.XContentParser;
        // Verify lucene secondary: doc count + all dynamic fields indexed
        );
                .setSource("field_keyword", "value_" + i, "field_number", i)
        return value instanceof List;
        assertEquals("solo", rows.get(0).get("tags"));
                }
        CreateIndexResponse createResponse = client().admin()
    private boolean isListColumn(Object value) {
        }
        Path luceneDir = shard.shardPath().resolveIndex();
                    || e.getMessage().contains("mapper [foo] cannot be changed from type [long] to [text]")
    }
        return getIndexShard(internalCluster().getDataNodeNames().iterator().next(), new ShardId(resolveIndex(indexName), 0), indexName);
import org.opensearch.cluster.metadata.IndexMetadata;
}
    public void testConflictingDynamicMappings() {
        assertBusy(() -> assertEquals(Boolean.TRUE, clusterStateFieldMapping(indexName, "tags").get("multi_value")));
        assertEquals(Boolean.TRUE, clusterStateFieldMapping(indexName, "tags").get("multi_value"));
            .setSettings(parquetPrimaryLuceneSecondarySettings())
            .setMapping("tags", "type=keyword")
            .prepareCreate(indexName)
                        if (fi.getDocValuesType() == DocValuesType.SORTED_NUMERIC) {
            .get();
                .get();
        }
    private IndexShard getIndexShard(String indexName) {
        } catch (Exception e) {
            .get();
        long totalRows = 0;
            .prepareCreate(indexName)
        return Settings.builder()
    }
            IndexResponse response = client().prepareIndex()
     */
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("tags", "solo").get().status());
        assertTrue(createResponse.isAcknowledged());
        assertTrue("Parquet directory should exist", Files.isDirectory(parquetDir));
        }
                                row.put(fi.name, dv.nextValue());
            Map<String, Object> properties = (Map<String, Object>) mappingSource.get("properties");
            return readAllParquetRows(parquetFilesRef.get());
                );
            ArrowBasePlugin.class,
            .get();
        String[] expectedFields = new String[numThreads * 2];
            ensureGreen(indexName);
                }
        assertTrue(rows.stream().anyMatch(row -> List.of("prod", "error", "prod").equals(row.get("tags"))));
                } catch (Exception e) {
    // Wait for any in-flight merges to complete to avoid file handle leaks when the cluster shuts down while merge threads still hold open
                    Map<String, Object> row = new HashMap<>();
            thread.join();
import java.util.stream.Collectors;
        return totalRows;
            .build();
        // Verify lucene secondary: doc count + indexed fields present
        CountDownLatch startLatch = new CountDownLatch(1);
    }
     * to account for the cluster-manager applying its own cluster state after publication completes.
        CreateIndexResponse createResponse = client().admin()
            .put("index.composite.primary_data_format", "parquet")
        IndexResponse scalarResponse = client().prepareIndex(indexName).setSource("tags", "solo").get();
    }
        // Index docs with initial schema
            List<Path> parquetFiles = parquetFilesRef.get();
            indexThreads[i] = new Thread(() -> {
import org.opensearch.common.xcontent.json.JsonXContent;
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
import org.opensearch.core.xcontent.DeprecationHandler;
        List<Map<String, Object>> rows = refreshFlushAndReadParquetRows(indexName);
    /**
            .indices()
        assertEquals("All 10 Lucene docs should have __row_id__", 10, rowsWithRowId);
            .setMapping("tags", "type=keyword")
        for (Thread thread : threads) {
        }
        assertTrue(
                        IndexResponse response = client().prepareIndex(indexNames.get(indexOrdinal)).setSource("tags", tags).get();
    @SuppressWarnings("unchecked")
                    }
    private void assertLuceneIndexedFieldsPresent(Path luceneDir, Set<String> expectedFields) throws IOException {
        String indexName = "test-conflict";
                try {
            });
                    i,
        assertEquals(RestStatus.CREATED, scalarResponse.status());
            });
        );
        }
        client().admin().indices().prepareFlush(indexName).get();
            .setSettings(parquetPrimaryLuceneSecondarySettings())
public class CompositeDynamicMappingIT extends OpenSearchIntegTestCase {
     */
        assertTrue("the buffered scalar row must survive writer retirement", rows.stream().anyMatch(row -> "solo".equals(row.get("tags"))));
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .setSource(
    }
        });
            .build();
        for (Thread thread : indexThreads) {
        return rows;
        startLatch.countDown();
        runConcurrentIndexing(indexName, numThreads);
                assertTrue("Mapping should contain field '" + field + "'", properties.containsKey(field));
        // Verify mappings
            assertTrue(createResponse.isAcknowledged());
        assertTrue("scalar input persists as a singleton list", rows.stream().anyMatch(row -> List.of("solo").equals(row.get("tags"))));
            String indexName = "test-auto-concurrent-" + i;
        ensureNoActiveMerges(indexName);
import org.apache.lucene.index.SortedNumericDocValues;
        assertEquals(RestStatus.CREATED, scalarResponse.status());
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
     * Parses a {@code tags} cell decoded by RustBridge's test-only JSON renderer. LIST columns are
        Set<String> expectedFields = new HashSet<>();
     * and each index receives a deterministic mix of scalar and LIST values while mapping updates
        }
            final int threadId = i;
        final int numThreads = 32;
        ensureGreen(indexName);
        // __row_id__ should be present in all docs (only doc values field in lucene secondary)
        for (Path pf : parquetFiles) {
            org.opensearch.ExceptionsHelper.stackTrace(error),
        assertTrue(createResponse.isAcknowledged());
import org.opensearch.parquet.bridge.ParquetFileMetadata;
            List<Path> parquetFiles = parquetFilesRef.get();
        );
                LeafReader leaf = ctx.reader();
     */
        IndexShard shard = getIndexShard(indexName);
            "array input persists in source order",
    // readers.
                        }
        // Second doc: foo as text — should fail
import org.opensearch.common.concurrent.GatedCloseable;
            }
            DataFusionPlugin.class
    @Override
            indexThreads[i].start();
    public void testDynamicMappingWithParquetPrimaryLuceneSecondary() throws Exception {
        return new GatedCloseable<>(paths, snapshot::close);
            assertEquals(RestStatus.CREATED, response.status());
    private void runConcurrentIndexing(String indexName, int numThreads) throws Throwable {
        return Settings.builder()
    private long getParquetRowCount(List<Path> parquetFiles) throws IOException {
        for (String indexName : indexNames) {
                    for (int operation = 0; operation < operationsPerThread; operation++) {
        final int operationsPerThread = 24;
        CreateIndexResponse createResponse = client().admin()
/*
    }
    }
        long rowsWithRowId = luceneRows.stream().filter(r -> r.containsKey("__row_id__")).count();
            .setSettings(Settings.builder().put(parquetPrimaryLuceneSecondarySettings()).put("index.refresh_interval", "-1"))
        assertTrue(createResponse.isAcknowledged());
        CreateIndexResponse createResponse = client().admin()
        assertFalse(initialFieldMapping.containsKey("multi_value"));
import org.opensearch.index.engine.exec.Segment;
    }
        Map<String, Object> mappingSource = getClusterState().metadata().index(indexName).mapping().sourceAsMap();
    // Private helpers: shard access
        ensureGreen(indexName);
import org.opensearch.action.index.IndexResponse;
    @Override
            throw error.get();
                assertTrue(
        assertEquals(RestStatus.CREATED, listResponse.status());
        ensureNoActiveMerges(indexName);
            .put("index.composite.primary_data_format", "parquet")
        if (error.get() != null) {
        }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertEquals(2, rows.size());
                    Thread.sleep(1000);
            .prepareCreate(indexName)
    // ══════════════════════════════════════════════════════════════════════
        }
        assertTrue(rows.stream().anyMatch(row -> "solo".equals(row.get("tags"))));
    }
        assertConcurrentMappings(indexName, numThreads);
            org.hamcrest.Matchers.containsString("locked scalar by [multi_value: false]")
            assertDynamicFieldCount(parquetRows, "dynamic_text", 5);
                .setIndex(indexName)
import org.opensearch.core.rest.RestStatus;
     * Tests concurrent dynamic mapping updates with parquet primary + lucene secondary.
            .setMapping("field_keyword", "type=keyword", "field_number", "type=integer")
    private void assertConcurrentMappings(String indexName, int numThreads) throws Exception {
            .put("index.pluggable.dataformat.enabled", true)
        try (GatedCloseable<List<Path>> parquetFilesRef = listParquetFiles(parquetDir, shard)) {
        CreateIndexResponse createResponse = client().admin()
        for (int i = 0; i < numThreads; i++) {
        }
        ensureGreen(indexName);
    }
        List<Map<String, Object>> rows = new ArrayList<>();
            Exception.class,
            .put("index.pluggable.dataformat", "composite")
                for (int doc = 0; doc < leaf.maxDoc(); doc++) {
        ensureGreen(indexName);
                            SortedSetDocValues dv = leaf.getSortedSetDocValues(fi.name);
import java.util.Arrays;
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
        try {
            LucenePlugin.class,
    /**
    }
            .setMapping("tags", "type=keyword,multi_value=false")
    private void ensureNoActiveMerges(String indexName) throws IOException {
            .get();
    // ══════════════════════════════════════════════════════════════════════
            GetMappingsResponse mappings = client().admin().indices().prepareGetMappings(indexName).get();
        final CountDownLatch startLatch = new CountDownLatch(1);
     * Verifies concurrent AUTO promotion across independent indices. Every request has a unique ID,
            }, "auto-promotion-" + i);
        for (int i = 0; i < 5; i++) {
        assertTrue(
            "the retried array document must use LIST storage",
 * -Dsandbox.enabled=true
    /**
    // ══════════════════════════════════════════════════════════════════════
            )
        }
                json
            throw new IOException("Timed out waiting for merges to complete", e);
    public void testExplicitScalarKeywordRejectsArrayWithoutUpdatingClusterState() throws Exception {
 *
        refreshAndFlush(indexName);
                        if (response.status() != RestStatus.CREATED) {
        final int threadCount = 8;
        Thread[] threads = new Thread[threadCount];
    /** Verifies that explicit SCALAR state rejects an array without publishing a mapping update. */
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        final Thread[] indexThreads = new Thread[numThreads];
    // non new documents are ingested
        } catch (Exception e) {
            .setMapping("tags", "type=keyword,multi_value=true")
        for (int i = from; i < to; i++) {
     * into a list of maps (one map per document).
            .setSettings(parquetPrimaryLuceneSecondarySettings())
            List<Map<String, Object>> rows = refreshFlushAndReadParquetRows(indexName);
                "each index must contain LIST-backed rows",
import org.opensearch.plugins.Plugin;
import java.util.HashMap;
                        String value = "tag-" + threadId + "-" + operation;
    // ══════════════════════════════════════════════════════════════════════
            Map<String, Object> mappingSource = mappings.getMappings().get(indexName).sourceAsMap();
import org.opensearch.index.shard.IndexShard;
                            if (dv != null && dv.advanceExact(doc)) {
            assertBusy(() -> {
                    "field_number",
    }
    }
        }
            IndexResponse response = client().prepareIndex()
            List<Map<String, Object>> parquetRows = readAllParquetRows(parquetFiles);
            for (LeafReaderContext ctx : reader.leaves()) {
                e.getMessage().contains("failed to parse field [foo] of type [long]")
    private List<Map<String, Object>> parseJsonRows(String json) throws IOException {
                    "Lucene index should contain field '" + expected + "', found fields: " + allFields,
                try {
import org.opensearch.common.settings.Settings;
                    Thread.sleep(1000);
        assertLuceneIndexedFieldsPresent(luceneDir, expectedFields);
            throw error.get();
            }
     */
            ParquetFileMetadata meta = RustBridge.getFileMetadata(pf.toString());
                    assert respB.status() == RestStatus.CREATED : "index b_" + threadId + " failed: " + respB.status();
        }
                NamedXContentRegistry.EMPTY,
     */
        IndexResponse scalarResponse = client().prepareIndex(indexName).setSource("tags", "solo").get();
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
            assertTrue(getClusterState().metadata().index(indexName).getMappingVersion() > initialMappingVersion);
                    allFields.add(fi.name);
import org.opensearch.be.datafusion.DataFusionPlugin;
     * Numeric fields and field values are only in Parquet.
        final int expectedDocumentsPerIndex = threadCount * operationsPerThread / indexCount;
        }
import java.util.concurrent.atomic.AtomicReference;
    }
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        // First doc: foo inferred as long
                            SortedNumericDocValues dv = leaf.getSortedNumericDocValues(fi.name);
        }
                rows.stream().anyMatch(row -> row.get("tags") instanceof List<?> tags && tags.contains("shared"))
            assertEquals(64, parquetRows.size());
                    for (FieldInfo fi : leaf.getFieldInfos()) {
 * ./gradlew :sandbox:plugins:composite-engine:internalClusterTest \
        try (
            .prepareCreate(indexName)
                for (String file : wfs.files()) {
        for (int i = 0; i < threadCount; i++) {
            .put("index.pluggable.dataformat.enabled", true)
    private Settings parquetPrimaryLuceneSecondarySettings() {
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("tags", "solo").get().status());
    // Private helpers: parquet verification
            for (LeafReaderContext ctx : reader.leaves()) {
     * Verifies that dynamically added fields appear in both formats.
    @SuppressForbidden(reason = "JSON parsing for test verification of parquet output")
import java.util.HashSet;
        Path luceneDir = shard.shardPath().resolveIndex();
    @SuppressWarnings("unchecked")
            }
        final List<String> indexNames = new ArrayList<>(indexCount);
            CreateIndexResponse createResponse = client().admin()
 * SPDX-License-Identifier: Apache-2.0
                }
            List<Map<String, Object>> parquetRows = readAllParquetRows(parquetFiles);
                                long ord = dv.nextOrd();
import org.apache.lucene.index.FieldInfo;
            client().prepareIndex(indexName).setSource("foo", "bar").get();
            .putList("index.composite.secondary_data_formats", "lucene")
 * Documents with new fields (not in the original mapping) should be indexed successfully,
import java.nio.file.Files;
            expectedFields[i * 2 + 1] = "fieldB_" + i;
            expectedFields.add("fieldB_" + i);
                }
            final int threadId = i;
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
        return allRows;
        assertLuceneIndexedFieldsPresent(luceneDir, Set.of("field_keyword", "dynamic_text"));
        long mappingVersion = getClusterState().metadata().index(indexName).getMappingVersion();
    }
    private List<Map<String, Object>> readAllLuceneDocs(Path luceneDir) throws IOException {
        List<Map<String, Object>> rows = refreshFlushAndReadParquetRows(indexName);
        // Final refresh + flush
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("tags", List.of("one", "two", "one")).get().status());
            expectedFields.add("fieldA_" + i);
    @SuppressForbidden(reason = "JSON parsing for test verification of parquet output")
    private void assertConcurrentFieldValues(List<Map<String, Object>> rows, int numThreads) {
        ensureGreen(indexName);
    // Private helpers: assertions
            .putList("index.composite.secondary_data_formats")
    // ══════════════════════════════════════════════════════════════════════
                    assert respA.status() == RestStatus.CREATED : "index a_" + threadId + " failed: " + respA.status();
        CreateIndexResponse createResponse = client().admin()
import org.opensearch.common.SuppressForbidden;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
     * schema, a later array publishes {@code multi_value: true} into IndexMetadata, and the same
        assertEquals("All 64 Lucene docs should have __row_id__", 64, rowsWithRowId);
        IndexShard shard = getIndexShard(indexName);
            for (String field : expectedFields) {
            XContentParser parser = JsonXContent.jsonXContent.createParser(
                            if (dv != null && dv.advanceExact(doc)) {
 */
                            }
import org.apache.lucene.index.DocValuesType;
                                    row.put(fi.name, dv.lookupOrd(ord).utf8ToString());
