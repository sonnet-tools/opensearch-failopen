        }  
        assertEquals("All 32 fieldA values should be present", numThreads, foundA.size());
            .prepareCreate(indexName)  
        assertEquals("Lucene doc count should be 64", 64, luceneRows.size());
                    "dynamic_long",
        Path luceneDir = shard.shardPath().resolveIndex();
                assertTrue("Mapping should contain field '" + field + "'", properties.containsKey(field));  
    // non new documents are ingested
            return readAllParquetRows(parquetFilesRef.get());
                .prepareCreate(indexName)
     * serialized as JSON arrays, so a nested (LIST) column reads back as a {@link List} while a
            List<Map<String, Object>> parquetRows = readAllParquetRows(parquetFiles);
        for (int i = from; i < to; i++) {
    private void assertLuceneIndexedFieldsPresent(Path luceneDir, Set<String> expectedFields) throws IOException {  
import org.opensearch.parquet.bridge.ParquetFileMetadata;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
     * to account for the cluster-manager applying its own cluster state after publication completes.  
        ensureGreen(indexName);
            assertDynamicFieldCount(parquetRows, "dynamic_long", 5);
                for (int doc = 0; doc < leaf.maxDoc(); doc++) {
    /** Verifies that explicit SCALAR state rejects an array without publishing a mapping update. */
        List<Map<String, Object>> luceneRows = readAllLuceneDocs(luceneDir);
                "each index must contain LIST-backed rows",
        String indexName = "test-dynamic-composite";
            .putList("index.composite.secondary_data_formats")
                    client().admin().indices().prepareRefresh(indexName).get();
        runConcurrentIndexing(indexName, numThreads);
            thread.join();  
        long count = rows.stream().filter(row -> row.containsKey(fieldName) && row.get(fieldName) != null).count();  
            });
            final int threadId = i;
        for (int i = 0; i < numThreads; i++) {  
     * (for search) and __row_id__ as doc values (for cross-format correlation).
        );
    // The best way to do so is to trigger a force merge to single segment and ensure it completes so that no merges will happen again until  
    }  
        assertEquals(2, rows.size());  
     */
import org.opensearch.action.admin.indices.create.CreateIndexResponse;  
        assertEquals(1, rows.size());
        for (int i = 0; i < indexCount; i++) {  
    // ══════════════════════════════════════════════════════════════════════  
            totalRows += meta.numRows();  
        if (error.get() != null) {
     */
        }
public class CompositeDynamicMappingIT extends OpenSearchIntegTestCase {  
    }
package org.opensearch.composite;
            assertNotNull("Parquet file metadata should not be null: " + pf, meta);
    /** Verifies that explicit LIST state writes scalar input as a singleton list and arrays unchanged. */  
            .build();  
        assertEquals(RestStatus.CREATED, listResponse.status());
            .setMapping("field_keyword", "type=keyword", "field_number", "type=integer")
        startLatch.countDown();  
            .prepareCreate(indexName)
    }  
import org.opensearch.index.shard.IndexShard;
                    error.compareAndSet(null, t);
        final CountDownLatch startLatch = new CountDownLatch(1);  
            }
                }  
     * Asserts that the given fields exist in the Lucene index as indexed fields (inverted index).  
    public void testConcurrentDynamicUpdatesWithLuceneSecondary() throws Throwable {
            .get();  
        String indexName = "test-adaptive-keyword";  
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");  
     * schema, a later array publishes {@code multi_value: true} into IndexMetadata, and the same
            .prepareCreate(indexName)  
        refreshAndFlush(indexName);
        CreateIndexResponse createResponse = client().admin()
import java.util.ArrayList;  
    public void testExplicitListKeywordPersistsListShapeForEveryDocument() throws Exception {
        assertEquals(RestStatus.CREATED, scalarResponse.status());  
 * The OpenSearch Contributors require contributions made to  
            assertEquals("Parquet total rows should be 64", 64, getParquetRowCount(parquetFiles));
            RestStatus.CREATED,
                    paths.add(parquetDir.resolve(file));  
        final List<String> indexNames = new ArrayList<>(indexCount);  
                try {  
                        }  
        assertTrue(
            List<Path> parquetFiles = parquetFilesRef.get();
        long totalRows = 0;
            DataFusionPlugin.class
            assertEquals(RestStatus.CREATED, response.status());  
            throw new IOException("Timed out waiting for merges to complete", e);  
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
        ensureGreen(indexName);
            ParquetDataFormatPlugin.class,
            .setSettings(parquetPrimaryLuceneSecondarySettings())
            .setMapping("tags", "type=keyword")
            client().prepareIndex(indexName).setSource("tags", List.of("prod", "error", "prod")).get().status()  
                    // forceMerge throws if background merges are active — retry
        }  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
        Set<String> foundB = new HashSet<>();  
        AtomicReference<Throwable> error = new AtomicReference<>();
                            if (dv != null && dv.advanceExact(doc)) {
                .setSource("field_keyword", "value_" + i, "field_number", i)
        assertTrue(createResponse.isAcknowledged());
            .setMapping("tags", "type=keyword,multi_value=true")
            client().prepareIndex(indexName).setSource("foo", "bar").get();
        for (Segment segment : snapshot.get().getSegments()) {
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        for (int i = 0; i < numThreads; i++) {  
            CompositeDataFormatPlugin.class,  
     * Asserts that the given fields are present in the index mapping, polling with assertBusy
                }
        List<Map<String, Object>> luceneRows = readAllLuceneDocs(luceneDir);  
            ensureGreen(indexName);  
        for (Thread thread : threads) {
        // Verify lucene secondary: doc count + all dynamic fields indexed
                LeafReader leaf = ctx.reader();
    private List<Map<String, Object>> readAllLuceneDocs(Path luceneDir) throws IOException {  
        return new GatedCloseable<>(paths, snapshot::close);
            .put("index.pluggable.dataformat", "composite")
    // Private helpers: lucene verification
        }  
                if (("valueA_" + i).equals(row.get("fieldA_" + i))) foundA.add("fieldA_" + i);  
     * and each index receives a deterministic mix of scalar and LIST values while mapping updates
import org.opensearch.core.xcontent.XContentParser;
     * active writer, preserve its scalar row, and retry against a new LIST writer.
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
                    || e.getMessage().contains("mapper [foo] cannot be changed from type [long] to [text]")
                "Expected type conflict error but got: " + e.getMessage(),
     * Tests concurrent dynamic mapping updates with parquet primary + lucene secondary.
    // ══════════════════════════════════════════════════════════════════════
            String indexName = "test-auto-concurrent-" + i;
    public void testConcurrentAutoPromotionAcrossIndices() throws Throwable {
        // __row_id__ should be present in all docs (only doc values field in lucene secondary)  
        CountDownLatch startLatch = new CountDownLatch(1);
        }  
    }
 *
            .put("index.pluggable.dataformat", "composite")  
    // Private helpers: assertions
        assertEquals(2, rows.size());  
            );
                .indices()  
                    allFields.contains(expected)
        // First doc: foo inferred as long
            indexThreads[i] = new Thread(() -> {
            .build();
 * this file be licensed under the Apache-2.0 license or a
        // Verify all dynamic fieldA_*/fieldB_* are indexed in Lucene
        assertEquals(Boolean.FALSE, clusterStateFieldMapping(indexName, "tags").get("multi_value"));
        for (Map<String, Object> row : rows) {
        ensureGreen(indexName);  
     * Parses a {@code tags} cell decoded by RustBridge's test-only JSON renderer. LIST columns are  
        assertEquals(
        assertEquals("All 10 Lucene docs should have __row_id__", 10, rowsWithRowId);
        String indexName = "test-conflict";
        client().admin().indices().prepareRefresh(indexName).get();
            .build();
            .indices()
                for (String file : wfs.files()) {
            .prepareCreate(indexName)
        return totalRows;
     * Verifies that dynamically added fields appear in both formats.
        // Index docs with dynamic fields
                .get();
    }
        CreateIndexResponse createResponse = client().admin()
        Map<String, Object> properties = (Map<String, Object>) mappingSource.get("properties");  
     * <p>
        try (
            .indices()
        refreshAndFlush(indexName);
        // Refresh + flush
        client().prepareIndex(indexName).setSource("foo", 3).get();  
        final int operationsPerThread = 24;
import org.apache.lucene.index.DirectoryReader;  
        }
    }  
import java.util.HashMap;  
        assertTrue(createResponse.isAcknowledged());
    // ══════════════════════════════════════════════════════════════════════
    }
        long initialMappingVersion = getClusterState().metadata().index(indexName).getMappingVersion();  
import org.apache.lucene.index.LeafReaderContext;
            expectedFields[i * 2] = "fieldA_" + i;
                    IndexResponse respB = client().prepareIndex(indexName).setSource("fieldB_" + threadId, "valueB_" + threadId).get();
    private void assertMappingsContain(String indexName, String... expectedFields) throws Exception {
    /**
    }
    @Override  
                rows.stream().anyMatch(row -> row.get("tags") instanceof List<?> tags && tags.contains("shared"))  
        assertTrue("every document must persist as a LIST", rows.stream().allMatch(row -> isListColumn(row.get("tags"))));  
        assertEquals(RestStatus.CREATED, scalarResponse.status());  
        final int threadCount = 8;  
        IndexResponse listResponse = client().prepareIndex(indexName).setSource("tags", List.of("prod", "error", "prod")).get();  
    }
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("tags", "solo").get().status());  
    }
        }
    }
        // Verify mappings  
    // ══════════════════════════════════════════════════════════════════════
        assertEquals("Lucene should have 10 docs", 10, luceneRows.size());
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
                    allFields.add(fi.name);
        assertTrue(createResponse.isAcknowledged());
            assertConcurrentFieldValues(parquetRows, numThreads);
    // Wait for any in-flight merges to complete to avoid file handle leaks when the cluster shuts down while merge threads still hold open
        assertThat(  
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("tags", List.of("one", "two", "one")).get().status());
            }
        }  
                .setSettings(settings)
        assertLuceneIndexedFieldsPresent(luceneDir, expectedFields);
    }
            throw error.get();
    }
                e.getMessage().contains("failed to parse field [foo] of type [long]")  
        IndexResponse scalarResponse = client().prepareIndex(indexName).setSource("tags", "solo").get();
        }
                        if (response.status() != RestStatus.CREATED) {
import org.apache.lucene.store.Directory;
                if (("valueB_" + i).equals(row.get("fieldB_" + i))) foundB.add("fieldB_" + i);
        CreateIndexResponse createResponse = client().admin()
        ensureGreen(indexName);  
            for (String expected : expectedFields) {
                }
                } catch (Throwable t) {  
            Exception.class,  
            assertDynamicFieldCount(parquetRows, "dynamic_text", 5);  
            }
        Settings settings = Settings.builder().put(parquetPrimaryLuceneSecondarySettings()).put("index.refresh_interval", "-1").build();
        final int indexCount = 3;
     * Numeric fields and field values are only in Parquet.
        for (String indexName : indexNames) {  
import org.opensearch.test.OpenSearchIntegTestCase;
        // Final refresh + flush
 * <p>
            .setMapping("tags", "type=keyword,multi_value=false")  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
     */  
                            SortedNumericDocValues dv = leaf.getSortedNumericDocValues(fi.name);  
        }
                    (long) i * 1000  
     */  
        assertTrue("the buffered scalar row must survive writer retirement", rows.stream().anyMatch(row -> "solo".equals(row.get("tags"))));
                            throw new AssertionError("concurrent index request failed with " + response.status());  
            .setMapping("tags", "type=keyword")
            Map<String, Object> mappingSource = mappings.getMappings().get(indexName).sourceAsMap();
        final AtomicReference<Throwable> error = new AtomicReference<>();
            LucenePlugin.class,
        // Verify lucene secondary: doc count + indexed fields present
        ensureGreen(indexName);
     * Tests dynamic mapping with parquet primary + lucene secondary.  
    // ══════════════════════════════════════════════════════════════════════  
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");  
                                row.put(fi.name, dv.nextValue());
            expectedFields.add("fieldA_" + i);
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
            indexThreads[i].start();
        );
        // Index docs with initial schema
        return getIndexShard(internalCluster().getDataNodeNames().iterator().next(), new ShardId(resolveIndex(indexName), 0), indexName);  
            threads[i].start();
     */
        // __row_id__ present in all docs
    private long getParquetRowCount(List<Path> parquetFiles) throws IOException {
            .put("index.composite.primary_data_format", "parquet")
                    IndexResponse respA = client().prepareIndex(indexName).setSource("fieldA_" + threadId, "valueA_" + threadId).get();
            .put("index.pluggable.dataformat.enabled", true)
                    Thread.sleep(1000);
        for (Path pf : parquetFiles) {  
                    "value_" + i,  
            org.hamcrest.Matchers.containsString("locked scalar by [multi_value: false]")
                }  
                } catch (Exception e) {  
            )
    }  
                        int indexOrdinal = (threadId + operation) % indexCount;
                        }
import java.io.IOException;  
    @SuppressWarnings("unchecked")
            for (String field : expectedFields) {
    private Map<String, Object> clusterStateFieldMapping(String indexName, String fieldName) {
 * and the resulting Parquet files should contain all fields including dynamically added ones.  
import java.util.List;
                    startLatch.await();
 * Integration test validating dynamic mapping support with composite parquet index.
            for (int i = 0; i < numThreads; i++) {
                } catch (Exception e) {
import org.opensearch.be.lucene.LucenePlugin;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
     * the physical Parquet column is LIST, and the element values are asserted directly by callers.  
        String indexName = "test-list-keyword";
            .get();
    }
    }  
        assertMappingsContain(indexName, expectedFields);
    }
     * indexing request is retried and persisted as a LIST row.  
import java.util.concurrent.CountDownLatch;
        for (int i = 0; i < 5; i++) {
            rows.stream().anyMatch(row -> List.of("one", "two", "one").equals(row.get("tags")))
    // Private helpers: index settings
                try {
            assertTrue(
        }
        assertEquals("All 32 fieldB values should be present", numThreads, foundB.size());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    /**
    /**  
    // ══════════════════════════════════════════════════════════════════════
                json  
    @SuppressForbidden(reason = "JSON parsing for test verification of parquet output")
    }  
     * and writer rotations race with other writes.
            .put("index.pluggable.dataformat.enabled", true)
        Thread[] threads = new Thread[threadCount];  
                        if (fi.getDocValuesType() == DocValuesType.SORTED_NUMERIC) {
                        } else if (fi.getDocValuesType() == DocValuesType.SORTED_SET) {
                NamedXContentRegistry.EMPTY,
 */  
    // Private helpers: parquet verification
        assertEquals(mappingVersion, getClusterState().metadata().index(indexName).getMappingVersion());
import java.util.Collection;
        // Verify parquet  
            for (LeafReaderContext ctx : reader.leaves()) {  
                    Thread.sleep(1000);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 1)
        CreateIndexResponse createResponse = client().admin()  
        CreateIndexResponse createResponse = client().admin()  
            .setSettings(parquetPrimaryLuceneSecondarySettings())  
import java.util.concurrent.atomic.AtomicReference;  
        // Verify that the lucene index has the expected indexed fields (inverted index)
    private void assertConcurrentFieldValues(List<Map<String, Object>> rows, int numThreads) {
        List<Map<String, Object>> rows = refreshFlushAndReadParquetRows(indexName);
    // readers.
        assertEquals(2, rows.size());
     * into a list of maps (one map per document).
            .get();
            org.opensearch.ExceptionsHelper.stackTrace(error),
import org.opensearch.common.concurrent.GatedCloseable;
    public void testAdaptiveKeywordPromotionUpdatesClusterStateAndRetriesDocument() throws Exception {
        client().admin().indices().prepareFlush(indexName).get();
                            }  
    private void assertDynamicFieldCount(List<Map<String, Object>> rows, String fieldName, long expectedCount) {
        assertLuceneIndexedFieldsPresent(luceneDir, Set.of("field_keyword", "dynamic_text"));
    private List<Map<String, Object>> refreshFlushAndReadParquetRows(String indexName) throws IOException {  
        startLatch.countDown();
    private void indexDocsWithDynamicFields(String indexName, int from, int to) {  
     */
        assertTrue("scalar input persists as a singleton list", rows.stream().anyMatch(row -> List.of("solo").equals(row.get("tags"))));
     * Verifies that promotion retires a scalar writer that still holds buffered rows. No refresh or  
                );  
        return Settings.builder()
        for (int i = 0; i < numThreads; i++) {
    public void testDynamicMappingWithParquetPrimaryLuceneSecondary() throws Exception {
    // ══════════════════════════════════════════════════════════════════════
            "array input persists in source order",  
        List<Map<String, Object>> rows = refreshFlushAndReadParquetRows(indexName);
        });  
        List<Map<String, Object>> rows = new ArrayList<>();
        assertFalse(initialFieldMapping.containsKey("multi_value"));
import java.nio.file.Path;
import java.nio.file.Files;
     * Verifies both formats contain all dynamically created fields.
    protected Settings nodeSettings(int nodeOrdinal) {
        IndexShard shard = getIndexShard(indexName);
                    rows.add(row);
    private Settings parquetOnlySettings() {
        if (error.get() != null) {
        ensureGreen(indexName);
import org.opensearch.core.rest.RestStatus;
import org.opensearch.cluster.metadata.IndexMetadata;  
        Exception error = expectThrows(
                                    row.put(fi.name, dv.lookupOrd(ord).utf8ToString());  
    // ══════════════════════════════════════════════════════════════════════
        IndexShard shard = getIndexShard(indexName);  
        Path luceneDir = shard.shardPath().resolveIndex();  
                try {
                try (GatedCloseable<CatalogSnapshot> cs = getIndexShard(indexName).getCatalogSnapshot()) {
            assertEquals(64, parquetRows.size());
        }
            IndexResponse response = client().prepareIndex()
     */
    /**  
            assertEquals("every successful request must be persisted", expectedDocumentsPerIndex, rows.size());  
            .get();
        return (Map<String, Object>) properties.get(fieldName);
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
            }
        assertTrue(createResponse.isAcknowledged());  
            GetMappingsResponse mappings = client().admin().indices().prepareGetMappings(indexName).get();
        Map<String, Object> mappingSource = getClusterState().metadata().index(indexName).mapping().sourceAsMap();
                .get();  
import org.opensearch.common.xcontent.json.JsonXContent;
import org.opensearch.parquet.ParquetDataFormatPlugin;  
            .indices()
    }
                for (FieldInfo fi : ctx.reader().getFieldInfos()) {
import org.opensearch.index.engine.exec.Segment;
    private List<Map<String, Object>> readAllParquetRows(List<Path> parquetFiles) throws IOException {  
 * --tests "*.CompositeDynamicMappingIT" \
            .put(super.nodeSettings(nodeOrdinal))  
            .putList("index.composite.secondary_data_formats", "lucene")
        assertEquals("solo", rows.get(0).get("tags"));  
            assertBusy(() -> assertEquals(Boolean.TRUE, clusterStateFieldMapping(indexName, "tags").get("multi_value")));
                    Map<String, Object> row = new HashMap<>();  
        List<Map<String, Object>> allRows = new ArrayList<>();
        final int expectedDocumentsPerIndex = threadCount * operationsPerThread / indexCount;
        String indexName = "test-scalar-keyword";
        IndexResponse scalarResponse = client().prepareIndex(indexName).setSource("tags", "solo").get();
    /**
                    "dynamic_text",  
        assertTrue(createResponse.isAcknowledged());
        }
        );
            List<Path> parquetFiles = parquetFilesRef.get();  
            .get();  
import java.util.Map;  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
import org.apache.lucene.index.SortedNumericDocValues;
            assertTrue(getClusterState().metadata().index(indexName).getMappingVersion() > initialMappingVersion);
            expectedFields[i * 2 + 1] = "fieldB_" + i;
        assertTrue(rows.stream().anyMatch(row -> "solo".equals(row.get("tags"))));
            List<Map<String, Object>> rows = refreshFlushAndReadParquetRows(indexName);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        return value instanceof List;  
            assertEquals(Boolean.TRUE, clusterStateFieldMapping(indexName, "tags").get("multi_value"));
                    i,
            ParquetFileMetadata meta = RustBridge.getFileMetadata(pf.toString());
            );
            .setSettings(parquetPrimaryLuceneSecondarySettings())
        }  
                        IndexResponse response = client().prepareIndex(indexNames.get(indexOrdinal)).setSource("tags", tags).get();
     * Reads all documents from a Lucene index directory, extracting doc values fields  
import org.opensearch.core.xcontent.DeprecationHandler;
                    startLatch.await();
        );  
            .indices()  
        try (GatedCloseable<List<Path>> parquetFilesRef = listParquetFiles(parquetDir, shard)) {  
import org.apache.lucene.store.NIOFSDirectory;
        }
        // Verify parquet
                    for (FieldInfo fi : leaf.getFieldInfos()) {
                    error.compareAndSet(null, e);
            .indices()
            throw error.get();  
                    for (int operation = 0; operation < operationsPerThread; operation++) {  
            .put("index.composite.primary_data_format", "parquet")  
            threads[i] = new Thread(() -> {  
        }
import java.util.HashSet;
            for (LeafReaderContext ctx : reader.leaves()) {  
        CreateIndexResponse createResponse = client().admin()  
import org.opensearch.action.index.IndexResponse;
        ensureGreen(indexName);
            CreateIndexResponse createResponse = client().admin()
        List<Map<String, Object>> rows = refreshFlushAndReadParquetRows(indexName);
            thread.join();
                assertTrue(  
    // ══════════════════════════════════════════════════════════════════════  
    /**
    private List<Map<String, Object>> parseJsonRows(String json) throws IOException {
            Map<String, Object> properties = (Map<String, Object>) mappingSource.get("properties");
        ) {
    private void runConcurrentIndexing(String indexName, int numThreads) throws Throwable {
 * compatible open source license.
            .setSettings(parquetPrimaryLuceneSecondarySettings())
 * SPDX-License-Identifier: Apache-2.0
        Set<String> foundA = new HashSet<>();
        long mappingVersion = getClusterState().metadata().index(indexName).getMappingVersion();  
            assertEquals("Parquet should have 10 rows", 10, parquetRows.size());
        for (Thread thread : indexThreads) {
    private Settings parquetPrimaryLuceneSecondarySettings() {  
    }
        } catch (Exception e) {  
        client().admin().indices().prepareRefresh(indexName).get();
        }
     * Verifies the complete AUTO promotion path: the first scalar row is committed with a scalar
            .setSettings(parquetPrimaryLuceneSecondarySettings())
            .prepareCreate(indexName)
                .setSource(
        assertBusy(() -> assertEquals(Boolean.TRUE, clusterStateFieldMapping(indexName, "tags").get("multi_value")));  
            .indices()
        return Arrays.asList(  
                    assertEquals("Segment count after force merge should be 1", 1, cs.get().getSegments().size());
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("tags", "solo").get().status());
    private void ensureNoActiveMerges(String indexName) throws IOException {
        final int numThreads = 32;  
                            SortedSetDocValues dv = leaf.getSortedSetDocValues(fi.name);
    }  
import java.util.Arrays;
    }  
     * Verifies concurrent AUTO promotion across independent indices. Every request has a unique ID,  
            return parser.list().stream().map(o -> (Map<String, Object>) o).collect(Collectors.toList());  
        Map<String, Object> initialFieldMapping = clusterStateFieldMapping(indexName, "tags");
            assertEquals(RestStatus.CREATED, response.status());
     * Note: The Lucene secondary writer stores inverted indexes for text/keyword fields  
 * Requires JDK 25 and sandbox enabled. Run with:
                    client().admin().indices().prepareForceMerge(indexName).setMaxNumSegments(1).get();  
        List<Path> paths = new ArrayList<>();
            IndexResponse response = client().prepareIndex()  
        assertTrue(rows.stream().anyMatch(row -> List.of("prod", "error", "prod").equals(row.get("tags"))));
        IndexShard shard = getIndexShard(indexName);
            .get();
        });
    // ══════════════════════════════════════════════════════════════════════  
    }  
        client().admin().indices().prepareFlush(indexName).get();  
    /**
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
        return Settings.builder()
import org.opensearch.plugins.Plugin;  
        assertEquals("All 64 Lucene docs should have __row_id__", 64, rowsWithRowId);  
            Set<String> allFields = new HashSet<>();
import java.util.Set;
            }
            .prepareCreate(indexName)
        assertTrue(createResponse.isAcknowledged());  
                                }
        try (GatedCloseable<List<Path>> parquetFilesRef = listParquetFiles(parquetDir, shard)) {
                    "field_number",
    private IndexShard getIndexShard(String indexName) {
        // Second doc: foo as text — should fail
            }
import org.apache.lucene.index.FieldInfo;
                )
import org.opensearch.parquet.bridge.RustBridge;
     * scalar column reads back as its primitive value. Matching a {@link List} therefore verifies
                .setMapping("tags", "type=keyword")  
    @Override
     * The Lucene secondary stores inverted indexes for search but not doc values for field values.
 * Documents with new fields (not in the original mapping) should be indexed successfully,
                    assert respB.status() == RestStatus.CREATED : "index b_" + threadId + " failed: " + respB.status();  
    // ══════════════════════════════════════════════════════════════════════
        }
    // Private helpers: shard access
        Set<String> expectedFields = new HashSet<>();  
        assertBusy(() -> {  
    }  
        client().admin().indices().prepareRefresh(indexName).get();  
import org.opensearch.be.datafusion.DataFusionPlugin;
        return allRows;
        client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();  
        String indexName = "test-adaptive-active-writer";
                .setIndex(indexName)
        }
        }  
        assertEquals(Boolean.TRUE, clusterStateFieldMapping(indexName, "tags").get("multi_value"));  
    // Private helpers: indexing  
            .prepareCreate(indexName)  
    private void refreshAndFlush(String indexName) {
                            }
                    "Lucene index should contain field '" + expected + "', found fields: " + allFields,
        assertEquals(expectedCount + " rows should have " + fieldName + " field populated", expectedCount, count);
                    "field_keyword",
                }  
    }
import org.apache.lucene.index.SortedSetDocValues;  
        assertConcurrentMappings(indexName, numThreads);
        ensureNoActiveMerges(indexName);  
import org.apache.lucene.index.DocValuesType;
import org.opensearch.common.settings.Settings;  
            .indices()
            .get();
    private GatedCloseable<List<Path>> listParquetFiles(Path parquetDir, IndexShard shard) throws IOException {
import org.opensearch.index.engine.exec.WriterFileSet;  
        for (Path pf : parquetFiles) {
            List<Map<String, Object>> parquetRows = readAllParquetRows(parquetFiles);  
        );
 * ./gradlew :sandbox:plugins:composite-engine:internalClusterTest \  
    private boolean isListColumn(Object value) {
        long rowsWithRowId = luceneRows.stream().filter(r -> r.containsKey("__row_id__")).count();
        return Settings.builder()
        assertTrue("Parquet directory should exist", Files.isDirectory(parquetDir));
        }  
            final int threadId = i;
    }
                            if (dv != null && dv.advanceExact(doc)) {  
        return rows;  
                                long ord = dv.nextOrd();
            if (wfs != null) {
            @SuppressWarnings("unchecked")  
/**  
                }  
                    }
        try {  
                }
            assertTrue(
    @SuppressForbidden(reason = "JSON parsing for test verification of parquet output")  
    public void testAdaptiveKeywordPromotionRetiresActiveScalarWriterWithoutRefresh() throws Exception {
        try (GatedCloseable<List<Path>> parquetFilesRef = listParquetFiles(parquetDir, shard)) {
            indexNames.add(indexName);
        String indexName = "test-concurrent-composite";
            "the retried array document must use LIST storage",  
                    assert respA.status() == RestStatus.CREATED : "index a_" + threadId + " failed: " + respA.status();  
            ArrowBasePlugin.class,
    }
    private void assertConcurrentMappings(String indexName, int numThreads) throws Exception {
 */  
            expectedFields.add("fieldB_" + i);  
    }
import org.opensearch.core.index.shard.ShardId;  
        CreateIndexResponse createResponse = client().admin()
                                if (ord >= 0) {
                .setIndex(indexName)  
        assertTrue(createResponse.isAcknowledged());  
        assertBusy(() -> {  
 * -Dsandbox.enabled=true
     */  
        } catch (Exception e) {
        assertTrue(
        );  
import java.util.stream.Collectors;
    /**
        try {  
    // ══════════════════════════════════════════════════════════════════════  
    public void testExplicitScalarKeywordRejectsArrayWithoutUpdatingClusterState() throws Exception {  
import org.apache.lucene.index.LeafReader;  
                .get();
                    "dynamic_value_" + i,
     * flush occurs between the scalar and LIST documents, so the second write must reconcile the
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            allRows.addAll(parseJsonRows(RustBridge.readAsJson(pf.toString())));  
            () -> client().prepareIndex(indexName).setSource("tags", List.of("one", "two")).get()
        }
            assertBusy(() -> {
        indexDocsWithDynamicFields(indexName, 5, 10);
            rows.stream().anyMatch(row -> List.of("prod", "error", "prod").equals(row.get("tags")))
        final Thread[] indexThreads = new Thread[numThreads];
        List<Map<String, Object>> rows = refreshFlushAndReadParquetRows(indexName);
    }  
        GatedCloseable<CatalogSnapshot> snapshot = shard.getCatalogSnapshot();  
        for (int i = 0; i < threadCount; i++) {
            .setSettings(Settings.builder().put(parquetPrimaryLuceneSecondarySettings()).put("index.refresh_interval", "-1"))  
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
import org.opensearch.common.util.FeatureFlags;
/*  
        long rowsWithRowId = luceneRows.stream().filter(r -> r.containsKey("__row_id__")).count();
    public void testConflictingDynamicMappings() {  
    private static final String INDEX_NAME = "test-dynamic-mapping";
}
        ensureNoActiveMerges(indexName);  
     */  
import org.opensearch.common.SuppressForbidden;
        }
                        Object tags = ((threadId * 31 + operation * 17) & 3) == 0 ? List.of(value, "shared") : value;  
        assertEquals(Boolean.FALSE, clusterStateFieldMapping(indexName, "tags").get("multi_value"));
    /**
        String[] expectedFields = new String[numThreads * 2];
            assertTrue(createResponse.isAcknowledged());
            fail("Indexing request should have failed!");
            });  
    }
        }
    @SuppressWarnings("unchecked")  
            .setSettings(parquetPrimaryLuceneSecondarySettings())  
                    }
            }, "auto-promotion-" + i);  
            XContentParser parser = JsonXContent.jsonXContent.createParser(  
                        String value = "tag-" + threadId + "-" + operation;
