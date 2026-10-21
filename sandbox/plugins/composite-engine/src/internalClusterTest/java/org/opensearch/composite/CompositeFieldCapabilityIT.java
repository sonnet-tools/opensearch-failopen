 * this file be licensed under the Apache-2.0 license or a
        }
        IndexShard shard = getPrimaryShard(indexName);
                json
        List<Map<String, Object>> parquetRows = readAllParquetRows(parquetDir, shard);
import org.apache.lucene.index.DirectoryReader;
                    "hello world",
        startCluster();
            .get();
        assertTrue("Lucene should have field 'id_field'", luceneFields.contains("id_field"));
import java.nio.file.Path;
        assertIndexCreationSucceeds("test-binary", "field", "type=binary,store=true");
        String mapping = "{\n"
import org.opensearch.core.xcontent.DeprecationHandler;
        assertIndexCreationSucceeds("test-doc-values-only", "field", "type=keyword,index=false,doc_values=true");
import org.opensearch.cluster.metadata.IndexMetadata;
            client().prepareIndex(indexName)
        assertIndexCreationSucceeds("test-keyword", "field", "type=keyword");
            .putList("index.analysis.normalizer.my_lower.filter", "lowercase")
        client().admin().indices().prepareRefresh(indexName).get();
        assertEquals(3, parquetRows.stream().filter(r -> r.containsKey("id_field")).count());
     */
        assertIndexCreationSucceeds("test-unsigned-long", "field", "type=unsigned_long");
        // refuses to assign capabilities at FieldScope.NESTED until its formats implement
                    "f_long",
import org.opensearch.core.rest.RestStatus;
        startCluster();
    public void testShortFieldSupported() {
import org.opensearch.test.OpenSearchIntegTestCase;
                .get()
            .setSettings(dfaSettings())
    public void testMappingUpdateFailsWithUnsupportedField() throws Exception {
            + "}";
    }
        assertDocCount(indexName, 3);
    private void startCluster() {
            .prepareCreate(indexName)
        assertTrue("f_ip in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_ip")));
     * Tests that a keyword field with a normalizer stores the raw value in sourceKeywordFieldType
        assertDocCount(indexName, 1);
import org.opensearch.parquet.bridge.RustBridge;
        Map<String, Object> doc1Row = parquetRows.stream().filter(r -> "doc1".equals(r.get("id_field1"))).findFirst().orElseThrow();
        assertEquals("Hello", doc1Row.get("_ignored_source.field"));
    public void testBinaryFieldSupported() {
        // Verify both docs exist
        List<Map<String, Object>> parquetRows = readAllParquetRows(parquetDir, shard);
            .indices()
    }
        startCluster();
        List<Map<String, Object>> parquetRows = readAllParquetRows(parquetDir, shard);
            .setMapping(mapping)
                .setSource("{\"properties\":{\"unsupported_geo\":{\"type\":\"geo_point\"}}}", MediaTypeRegistry.JSON)
    @Override
        assertTrue("f_half_float in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_half_float")));
                    true,
        MapperParsingException ex = expectThrows(
            .prepareCreate("test-multiple-fields")
            client().prepareIndex(indexName).setSource("field", "dynamic", "id_field", "doc3", "new_dynamic_field", "hello").get().status()
        startCluster();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }
        startCluster();
import org.opensearch.index.shard.IndexShard;
            return parser.list().stream().map(o -> (Map<String, Object>) o).collect(Collectors.toList());
        startCluster();
    public void testDateNanosFieldSupported() {
            RestStatus.CREATED,
        IndexShard shard = getPrimaryShard(indexName);
    }
        );
import org.opensearch.core.xcontent.MediaTypeRegistry;
        Settings settings = Settings.builder()
            + "    }\n"
        assertTrue(response.isAcknowledged());
    public void testDynamicMappingNumericField() throws Exception {
                .setSource("f_long", 200L, "f_keyword", "beta", "f_date", "2024-06-15", "f_text", "more text")
            }
            .build();
    /**
            "sourceKeywordFieldType should store raw value for doc2",
        assertEquals("hello", doc1Row.get("field"));
     */
    }
                    "f_unsigned_long",
        CreateIndexResponse response = client().admin()
        // Index initial docs
        // Index doc with dynamic numeric field
     * Tests indexing and dynamic mapping for ALL supported field types.
        Map<String, Object> doc2Row = parquetRows.stream().filter(r -> "doc2".equals(r.get("id_field2"))).findFirst().orElseThrow();
        return allRows;
                    "f_text",
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("field", "Hello", "id_field1", "doc1").get().status());
        client().admin().indices().prepareFlush(indexName).get();
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
                    "2024-01-15",
}
                    "f_integer",
                .indices()
     * Tests that a keyword field with ignore_above can be indexed and the sourceKeywordFieldType
        Map<String, Object> doc2Row = parquetRows.stream().filter(r -> "doc2".equals(r.get("id_field"))).findFirst().orElseThrow();
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("field", "value1").get().status());
        assertTrue("Lucene should have 'dynamic_new_field'", luceneFields.contains("dynamic_new_field"));
     * Tests multi-field text+keyword indexing and verifies both parquet and lucene structures.
        startCluster();
            + "}";
        assertEquals(3, parquetRows.size());
                        allRows.addAll(parseJsonRows(RustBridge.readAsJson(filePath.toString())));
        client().admin().indices().prepareFlush(indexName).get();
        );
        assertTrue("Lucene should have 'tag'", luceneFields.contains("tag"));
                .get()
                    42,
    }
    }
    }
            .put(dfaSettings())
        // Dynamic field should appear
                .status()
        // Index doc — value is within any ignore_above but normalizer transforms it
                    "f_float",
        // and the shard is not left in an unrecoverable state.
        // The index remains healthy and the original data is intact.
        String indexName = "test-keyword-ignore-above-verify";
                    for (String file : wfs.files()) {
        // Verify lucene has expected indexed fields
                    99,
                    "f_double",
    }
 * Verifies that supported field types create successfully, documents can be indexed,
        assertDocCount(indexName, 2);
            )
        // doc1: value within ignore_above — field is stored, no source keyword field needed
        // Main field stores the normalized (lowercased) value
     * even when the value is within ignore_above. The normalized value goes into the main field,
                }
     * and the original un-normalized value is stored separately for source derivation.
            .put("index.composite.primary_data_format", "parquet")
            .setSettings(dfaSettings())
            RestStatus.CREATED,
            .setSettings(dfaSettings())
        startCluster();
                )
        assertIndexCreationSucceeds("test-double", "field", "type=double");
    /**
            + "      \"fields\": {\n"
        assertTrue("Lucene should have 'f_keyword'", luceneFields.contains("f_keyword"));
    public void testGeoShapeFieldUnsupported() {
            + "  \"properties\": {\n"
        Path luceneDir = shard.shardPath().resolveIndex();
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
        String mapping = "{\n"
        // doc2: value exceeds ignore_above — field is null (ignored), source keyword stores raw value
        assertEquals(
                .status()
        assertTrue(response.isAcknowledged());
            RestStatus.CREATED,
        // Verify parquet
    @SuppressForbidden(reason = "JSON parsing for test verification of parquet output")
    // === INDEXING + STRUCTURE VERIFICATION TESTS ===
        assertEquals(
 * Integration tests validating field capability assignment for composite indices.
        startCluster();
    }
        }
    /**
        try (GatedCloseable<CatalogSnapshot> snapshot = shard.getCatalogSnapshot()) {
import java.util.List;
        );
            .put("index.pluggable.dataformat.enabled", true)
            + "    \"f_long\": { \"type\": \"long\" },\n"
        assertTrue(response.isAcknowledged());
            .setMapping(mapping)
        assertNull("field should be null for doc2 (exceeds ignore_above)", doc2Row.get("field"));
            for (LeafReaderContext ctx : reader.leaves()) {
        );
    // ══════════════════════════════════════════════════════════════════════
        assertEquals("WORLD", doc2Row.get("_ignored_source.field"));
        // Index second doc with some fields
        startCluster();
import java.util.ArrayList;
            + "    \"f_date\": { \"type\": \"date\" },\n"
        startCluster();
import org.opensearch.common.settings.Settings;
    public void testKeywordFieldSupportedWithIgnoreAbove() {
                .get()
        // but _ignored_source.field should store the raw text value
        assertIndexCreationFails("test-geo-shape", "field", "type=geo_shape");
import org.apache.lucene.store.Directory;
                    "beta",
        // Verify ignore_above behavior:
    public void testWildcardFieldUnsupported() {
                .setSource("f_long", 300L, "f_keyword", "gamma", "f_date", "2024-12-31", "f_text", "final", "dyn_bool", true)
        assertTrue("f_keyword_ignore in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_keyword_ignore")));
     * Tests dynamic mapping with a numeric field and verifies old+new docs coexist.
        CreateIndexResponse response = client().admin()
                    1,
        assertDocCount(indexName, 2);
        String indexName = "test-multi-field-verify";
                .status()
            .setSettings(dfaSettings())
        // Dynamic mapping: add new field
                    9999999999L,
            RestStatus.CREATED,
        ensureGreen(indexName);
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
        assertIndexCreationSucceeds(indexName, "field", "type=keyword");
        startCluster();
        return Settings.builder()
            () -> client().admin().indices().prepareCreate(indexName).setSettings(dfaSettings()).setMapping(fieldName, mappingType).get()
        // Rejection happens per leaf declared inside the nested scope: the composite plugin
                    "f_keyword",
            .prepareCreate("test-multi-field")
        assertTrue("Lucene should have dynamic field 'new_dynamic_field'", luceneFields.contains("new_dynamic_field"));
        // Index a document successfully
        startCluster();
                .get()
        assertTrue(ex.getMessage(), ex.getMessage().contains("not supported by the [composite] data format"));
        assertIndexCreationSucceeds("test-ip", "field", "type=ip");
        startCluster();
                        Path filePath = parquetDir.resolve(file);
    }
                    "second doc",
    /**
        assertEquals(
        ensureGreen("test-multiple-fields");
     * Also verifies dynamic mapping works and old+new docs coexist.
            client().prepareIndex(indexName)
    public void testFlatObjectFieldUnsupported() {
            + "    \"f_float\": { \"type\": \"float\" },\n"
import org.opensearch.core.xcontent.NamedXContentRegistry;
        assertIndexCreationFails("test-all-disabled", "field", "type=keyword,index=false,doc_values=false,store=false");
    }
        ensureGreen(indexName);
        Set<String> allFields = new HashSet<>();
            .prepareCreate(indexName)
            + "    \"f_byte\": { \"type\": \"byte\" },\n"
        List<Map<String, Object>> allRows = new ArrayList<>();
            client().prepareIndex(indexName)
        assertTrue(response.isAcknowledged());
        List<Map<String, Object>> parquetRows = readAllParquetRows(parquetDir, shard);
     * Also adds a dynamic field and verifies old+new docs coexist.
            + "    \"f_ip\": { \"type\": \"ip\" },\n"
        assertTrue("f_date in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_date")));
    public void testGeoPointFieldUnsupported() {
                    3.14,
            + "    \"field\": { \"type\": \"keyword\", \"normalizer\": \"my_lower\" },\n"
            RestStatus.CREATED,
    /**
    // === SUPPORTED FIELDS (expect 200) ===
        client().admin().indices().prepareFlush(indexName).get();
        assertDocCount(indexName, 3);
        ) {
        CreateIndexResponse response = client().admin()
        // Index doc with value exceeding ignore_above (value ignored, sourceKeywordFieldType stores raw)
        );
        String mapping = "{\n"
    /**
        assertTrue("f_byte in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_byte")));
    }
        // Index doc — value is within any ignore_above but normalizer transforms it
        // by the cluster-manager during capability validation, so the mapping is never published
            + "    \"f_boolean\": { \"type\": \"boolean\", \"index\": false },\n"
            client().prepareIndex(indexName)
        assertEquals(3, parquetRows.size());
        // sourceKeywordFieldType stores the original un-normalized value for source derivation
            .setSettings(dfaSettings())
        String indexName = "test-multi-types-verify";
        assertEquals(
        startCluster();
    }
                    "f_ip",
        );
        // Verify doc count
        // new_dynamic_field should appear in parquet (at least 1 row has it)
            XContentParser parser = JsonXContent.jsonXContent.createParser(
                .get()
    public void testLongFieldSupported() {
                .prepareCreate("test-nested")
        startCluster();
            + "}";
                .indices()
        String indexName = "test-keyword-normalizer-verify";
                    "f_keyword_ignore",
    public void testNestedFieldUnsupported() {
        // Verify all 3 docs exist
        assertTrue(ex.getMessage(), ex.getMessage().contains("inside a nested object"));
 *
    }
        startCluster();
        assertTrue(parquetRows.stream().anyMatch(r -> r.containsKey("new_dynamic_field")));
        String indexName = "test-all-types-index";
        expectThrows(
    /**
import org.opensearch.common.xcontent.json.JsonXContent;
        return allFields;
    // === MAPPING UPDATE FAILURE TEST ===
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("name", "second", "dynamic_num", 42).get().status());
        List<Map<String, Object>> parquetRows = readAllParquetRows(parquetDir, shard);
                    "searchable text"
        // Verify doc was indexed
import java.util.Map;
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
            + "    \"f_short\": { \"type\": \"short\" },\n"
        // - doc2 ("this_exceeds_ignore_above_limit", len=32 > 10): field should be null/absent,
        client().admin().indices().prepareRefresh(indexName).get();
    public void testFloatFieldSupported() {
     */
            .prepareCreate(indexName)
    }
                .status()
            .indices()
        assertIndexCreationFails("test-wildcard", "field", "type=wildcard");
        startCluster();
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
import java.nio.file.Files;
    public void testByteFieldSupported() {
        ensureGreen(indexName);
            .indices()
import org.opensearch.index.engine.exec.Segment;
    }
    public void testTextFieldSupported() {
        client().admin().indices().prepareRefresh(indexName).get();
            + "  }\n"
            + "    \"field\": { \"type\": \"keyword\", \"normalizer\": \"my_lower\" }\n"
        assertTrue("Lucene should have 'content'", luceneFields.contains("content"));
    }
        startCluster();
                    "f_boolean",
        // id_field should be in all rows
        Map<String, Object> doc1Row = parquetRows.stream().filter(r -> "doc1".equals(r.get("id_field"))).findFirst().orElseThrow();
                    "192.168.1.1",
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
            + "    \"tag\": { \"type\": \"keyword\" }\n"
        assertDocCount(indexName, 3);
    }
        IndexShard shard = getPrimaryShard(indexName);
            client().prepareIndex(indexName)
/**
    /**
        assertTrue(parquetRows.stream().anyMatch(r -> r.containsKey("dyn_bool")));
    public void testUnsignedLongFieldSupported() {
            .setMapping("field", "type=keyword,ignore_above=10", "id_field", "type=keyword")
        startCluster();
        assertEquals(3, parquetRows.size());
        assertTrue(parquetRows.stream().anyMatch(r -> r.containsKey("f_date")));
        assertEquals(
        assertIndexCreationSucceeds("test-boolean", "field", "type=boolean,index=false");
                    "alpha",
        assertIndexCreationFails("test-completion", "field", "type=completion");
        assertTrue("Lucene should have field 'field'", luceneFields.contains("field"));
            .indices()
        startCluster();
        assertTrue("dynamic_new_field in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("dynamic_new_field")));
    @SuppressWarnings("unchecked")
                .preparePutMapping(indexName)
        // pluggable indices was removed by the pluggable-format seams change.)
        assertEquals(
        ensureGreen("test-multi-field");
        assertTrue("Parquet directory should exist", Files.isDirectory(parquetDir));
        startCluster();
        assertDocCount(indexName, 2);
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("field", "short", "id_field", "doc1").get().status());
            + "    \"field\": {\n"
        assertTrue(parquetRows.stream().anyMatch(r -> r.containsKey("dynamic_num")));
            .get();
        client().admin().indices().prepareRefresh(indexName).get();
        // All original fields should appear in at least one row
import org.opensearch.common.SuppressForbidden;
     * and verifies parquet/lucene structures contain expected fields and all docs coexist.
    public void testDoubleFieldSupported() {
    public void testAllSupportedFieldTypesIndexAndVerify() throws Exception {
        assertEquals("world", doc2Row.get("field"));
                    1.5f,
package org.opensearch.composite;
        ensureGreen(indexName);
            + "  }\n"
        assertIndexCreationFails("test-geo-point", "field", "type=geo_point");
            .setSettings(dfaSettings())
        assertEquals(
        assertTrue("f_text in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_text")));
    public void testBooleanFieldSupported() {
                .setSettings(dfaSettings())
        String indexName = "test-keyword-normalizer-verify-dynamic-field";
            .setMapping("f_long", "type=long", "f_keyword", "type=keyword", "f_date", "type=date", "f_text", "type=text")
     */
import java.io.IOException;
            .put("index.analysis.normalizer.my_lower.type", "custom")
        // Verify doc count via stats
            + "  \"properties\": {\n"
            .get();
import org.opensearch.common.concurrent.GatedCloseable;
    public void testKeywordNormalizerStoresSourceSeparatelyWhenDynamicFieldIsPresent() throws Exception {
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        // Index initial doc
        assertIndexCreationSucceeds("test-date-nanos", "field", "type=date_nanos");
        // Index doc with all field types populated
        assertDocCount(indexName, 1);
                    "f_boolean",
            .setMapping(fieldName, mappingType)
                if (wfs != null) {
                NamedXContentRegistry.EMPTY,
            }
        startCluster();
        );
        assertTrue("f_unsigned_long in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_unsigned_long")));
     * Creates an index with every supported type, indexes documents, adds a dynamic field,
        assertTrue("Lucene should have 'f_keyword_ignore'", luceneFields.contains("f_keyword_ignore"));
    private Settings dfaSettings() {
        // nested storage. (The former server-side blanket rejection of the nested type on
import org.opensearch.index.mapper.MapperParsingException;
     */
                    "f_match_only_text",
        // Dynamic mapping: add new field
    // === UNSUPPORTED FIELDS (expect 400 MapperParsingException) ===
    }
        CreateIndexResponse response = client().admin().indices().prepareCreate(indexName).setSettings(settings).setMapping(mapping).get();
            + "    \"id_field\": { \"type\": \"keyword\" }\n"
        // Verify lucene
 */
                .setSource("f_long", 300L, "f_keyword", "gamma", "f_text", "third with dynamic", "dynamic_new_field", "dynamic_value")
        assertTrue("f_match_only_text in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_match_only_text")));
        Set<String> luceneFields = getLuceneFields(luceneDir);
            .get();
        assertEquals(2, parquetRows.size());
    }
        Set<String> luceneFields = getLuceneFields(luceneDir);
        startCluster();
        assertTrue("f_boolean in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_boolean")));
        IndicesStatsResponse stats = client().admin().indices().prepareStats(indexName).clear().setDocs(true).get();
                )
        assertTrue("Lucene should have 'content.raw'", luceneFields.contains("content.raw"));
        assertEquals("short", doc1Row.get("field"));
        Map<String, Object> doc2Row = parquetRows.stream().filter(r -> "doc2".equals(r.get("id_field"))).findFirst().orElseThrow();
        startCluster();
import java.util.stream.Collectors;
        // Index initial docs
            .putList("index.analysis.normalizer.my_lower.filter", "lowercase")
    @SuppressForbidden(reason = "JSON parsing for test verification of parquet output")
        );
        // Verify lucene has text field and keyword sub-field
            () -> client().admin()
        CreateIndexResponse response = client().admin()
    }
        // Main field stores the normalized (lowercased) value
        assertTrue(response.isAcknowledged());
                .setMapping("{\"properties\": {\"field\": {\"type\": \"nested\", \"properties\": {\"name\": {\"type\": \"keyword\"}}}}}")
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
    public void testIpFieldSupported() {
                .get()
        );
            .get();
            client().prepareIndex(indexName).setSource("field", "this_exceeds_ignore_above_limit", "id_field", "doc2").get().status()
    public void testHalfFloatFieldSupported() {
            .setSettings(dfaSettings())
    public void testFieldWithOnlyDocValues() {
 * and both parquet and lucene structures contain expected fields.
            .indices()
        assertIndexCreationSucceeds("test-byte", "field", "type=byte");
        assertTrue(parquetRows.stream().anyMatch(r -> r.containsKey("tag")));
    }
                .status()
        List<Map<String, Object>> parquetRows = readAllParquetRows(parquetDir, shard);
            MapperParsingException.class,
        assertIndexCreationSucceeds("test-half-float", "field", "type=half_float");
        Settings settings = Settings.builder()
                .status()
    }
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("field", "Hello", "id_field", "doc1").get().status());
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            RestStatus.CREATED,
            + "      \"type\": \"text\",\n"
        startCluster();
                    "f_text",
    // Private helpers
            for (Segment segment : snapshot.get().getSegments()) {
        assertTrue(response.isAcknowledged());
        );
     */
        client().admin().indices().prepareFlush(indexName).get();
            + "    \"f_double\": { \"type\": \"double\" },\n"
        assertTrue("f_float in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_float")));
            doc2Row.get("_ignored_source.field")
        CreateIndexResponse response = client().admin().indices().prepareCreate(indexName).setSettings(settings).setMapping(mapping).get();
                    2.5f,
    public void testKeywordFieldSupported() {
    }
            client().prepareIndex(indexName)
    }
            + "      }\n"
    }
     * Also adds a dynamic field and verifies old+new docs coexist.
        ensureGreen(indexName);
        assertTrue(response.isAcknowledged());
        // A mapping update adding an unsupported field type (geo_point) is now rejected up front
import java.util.Set;
        // Dynamic mapping: add a new field
        String mapping = "{\n"
        IndexShard shard = getPrimaryShard(indexName);
    }
        CreateIndexResponse response = client().admin()
        client().admin().indices().prepareRefresh(indexName).get();
            + "    \"f_text\": { \"type\": \"text\" },\n"
        IndexShard shard = getPrimaryShard(indexName);
                .get()
                    "2024-01-15T10:30:00.123456789Z",
            + "    },\n"
        ensureGreen(indexName);
                    "f_date",
        ensureGreen(indexName);
        assertTrue("Lucene should have 'f_text'", luceneFields.contains("f_text"));
                for (FieldInfo fi : ctx.reader().getFieldInfos()) {
        CreateIndexResponse response = client().admin()
                    false,
        Path luceneDir = shard.shardPath().resolveIndex();
                .get()
                    "f_long",
        client().admin().indices().prepareRefresh(indexName).get();
    public void testMultipleFieldsAllSupported() {
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        assertTrue("f_double in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_double")));
import org.opensearch.index.engine.exec.WriterFileSet;
            + "  }\n"
        assertTrue(response.isAcknowledged());
        );
            RestStatus.CREATED,
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
        // Verify parquet contains expected fields
            RestStatus.CREATED,
    private void assertIndexCreationSucceeds(String indexName, String fieldName, String mappingType) {
    }
    public void testMultipleFieldTypesIndexAndVerify() throws Exception {
                .setSource(
        assertEquals(2, parquetRows.size());
        assertTrue(parquetRows.stream().anyMatch(r -> r.containsKey("f_keyword")));
            .put("index.analysis.normalizer.my_lower.type", "custom")
        client().admin().indices().prepareFlush(indexName).get();
    }
            .prepareCreate(indexName)
            MapperParsingException.class,
        );
        startCluster();
            .indices()
    }
        CreateIndexResponse response = client().admin()
/*
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).build();
            + "  \"properties\": {\n"
    }
        startCluster();
    }
        // sourceKeywordFieldType stores the original un-normalized value for source derivation
        assertEquals(3, parquetRows.size());
        assertEquals(
                .setSource(
        startCluster();
        Map<String, Object> doc1Row = parquetRows.stream().filter(r -> "doc1".equals(r.get("id_field"))).findFirst().orElseThrow();
            + "    \"content\": {\n"
    private List<Map<String, Object>> parseJsonRows(String json) throws IOException {
            + "    \"f_keyword\": { \"type\": \"keyword\" },\n"
                    "f_byte",
                    "short_val",
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("field", "WORLD", "id_field2", "doc2").get().status());
            .prepareCreate(indexName)
        assertTrue("f_date_nanos in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_date_nanos")));
    // ══════════════════════════════════════════════════════════════════════
                    200L,
        expectThrows(
        assertIndexCreationSucceeds("test-long", "field", "type=long");
            RestStatus.CREATED,
        client().admin().indices().prepareFlush(indexName).get();
        assertIndexCreationSucceeds("test-keyword", "field", "type=keyword,ignore_above=256");
            + "      \"type\": \"text\",\n"
            MapperParsingException.class,
        // Verify parquet
    public void testFieldWithAllDisabled() {
        startCluster();
        String indexName = "test-dynamic-mapping";
     * with an unsupported field type causes the shard to fail when applying the mapping.
        ensureGreen(indexName);
        Path luceneDir = shard.shardPath().resolveIndex();
            .build();
        assertIndexCreationSucceeds("test-text", "field", "type=text");
        assertTrue(parquetRows.stream().anyMatch(r -> r.containsKey("content")));
            "this_exceeds_ignore_above_limit",
    }
                WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
        assertIndexCreationSucceeds("test-match-only-text", "field", "type=match_only_text");
            .get();
    public void testCompletionFieldUnsupported() {
        assertTrue(response.isAcknowledged());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("field", "WORLD", "id_field", "doc2").get().status());
            .indices()
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("content", "foo bar", "tag", "test").get().status());
    }
        // Verify parquet has both docs
        assertIndexCreationFails("test-flat-object", "field", "type=flat_object");
import org.apache.lucene.store.NIOFSDirectory;
    }
    private List<Map<String, Object>> readAllParquetRows(Path parquetDir, IndexShard shard) throws IOException {
            .setMapping("name", "type=keyword")
    }
     * even when the value is within ignore_above. The normalized value goes into the main field,
            () -> client().admin()
        assertTrue("Lucene should have 'f_keyword'", luceneFields.contains("f_keyword"));
        assertIndexCreationSucceeds("test-float", "field", "type=float");
    public void testKeywordNormalizerStoresSourceSeparately() throws Exception {
        assertEquals(
            .get();
 */
import org.opensearch.core.xcontent.XContentParser;
        }
            + "    \"f_date_nanos\": { \"type\": \"date_nanos\" },\n"
        client().admin().indices().prepareRefresh(indexName).get();
        startCluster();
            + "        \"raw\": { \"type\": \"keyword\" }\n"
        IndexShard shard = getPrimaryShard(indexName);
 * compatible open source license.
     * Tests that multiple supported field types can be indexed together and verified.
        internalCluster().startClusterManagerOnlyNode();
    }
        assertEquals(2, parquetRows.size());
    public void testMultiFieldIndexAndVerify() throws Exception {
        assertEquals("world", doc2Row.get("field"));
        assertTrue(response.isAcknowledged());
                    "f_half_float",
        internalCluster().startDataOnlyNode();
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("name", "first").get().status());
            .setMapping("f_long", "type=long", "f_keyword", "type=keyword", "f_date", "type=date", "f_text", "type=text")
            RestStatus.CREATED,
        assertEquals("Hello", doc1Row.get("_ignored_source.field"));
    }
        ensureGreen(indexName);
        // Verify doc count
        );
    // === SPECIAL CASES ===
     * is stored in parquet when the value exceeds ignore_above.
    }
        startCluster();
        startCluster();
            + "      \"fields\": {\n"
        startCluster();
 * The OpenSearch Contributors require contributions made to
        assertTrue(parquetRows.stream().anyMatch(r -> r.containsKey("f_long")));
        assertIndexCreationSucceeds("test-date", "field", "type=date");
public class CompositeFieldCapabilityIT extends AbstractCompositeEngineIT {
    public void testDateFieldSupported() {
            + "    \"f_unsigned_long\": { \"type\": \"unsigned_long\" },\n"
        Set<String> luceneFields = getLuceneFields(luceneDir);
        assertIndexCreationSucceeds("test-integer", "field", "type=integer");
    public void testFieldWithOnlyStored() {
            .put(dfaSettings())
        CreateIndexResponse response = client().admin()
                    "2024-06-01"
    public void testMatchOnlyTextFieldSupported() {
        );
        startCluster();
import org.apache.lucene.index.FieldInfo;
     */
            .put("index.pluggable.dataformat", "composite")
        assertTrue("Lucene should have 'f_text'", luceneFields.contains("f_text"));
        client().admin().indices().prepareRefresh(indexName).get();
        // - doc1 ("short", len=5 <= 10): field should have the normalized value
                    100L,
    public void testIntegerFieldSupported() {
        assertTrue("Lucene should have 'f_match_only_text'", luceneFields.contains("f_match_only_text"));
    private void assertDocCount(String indexName, long expectedCount) {
        String mapping = "{\n"
            .setSettings(dfaSettings())
        assertIndexCreationSucceeds("test-short", "field", "type=short");
            + "    \"f_keyword_ignore\": { \"type\": \"keyword\", \"ignore_above\": 256 },\n"
        assertEquals("hello", doc1Row.get("field"));
        client().admin().indices().prepareFlush(indexName).get();
            + "    \"f_half_float\": { \"type\": \"half_float\" },\n"
        assertDocCount(indexName, 3);
                    "f_keyword",
            + "    \"f_integer\": { \"type\": \"integer\" },\n"
        // Verify lucene has expected indexed fields (inverted index: text/keyword types)
        assertEquals(expectedCount, stats.getIndex(indexName).getPrimaries().getDocs().getCount());
    }
        assertTrue("f_integer in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_integer")));
            + "  \"properties\": {\n"
        assertTrue("f_long in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_long")));
    private void assertIndexCreationFails(String indexName, String fieldName, String mappingType) {
            + "        \"raw\": { \"type\": \"keyword\" }\n"
        assertEquals(
            .prepareCreate(indexName)
            .build();
            + "}";
        try (
        assertTrue(parquetRows.stream().anyMatch(r -> r.containsKey("f_text")));
                    7,
            .indices()
            client().prepareIndex(indexName).setSource("content", "hello world", "tag", "greeting").get().status()
     */
            + "}";
                    "f_short",
            .putList("index.composite.secondary_data_formats", "lucene")
import java.util.HashSet;
        assertTrue("f_keyword in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_keyword")));
            + "  }\n"
        assertTrue(parquetRows.stream().anyMatch(r -> r.containsKey("extra_field")));
            client().prepareIndex(indexName).setSource("content", "dynamic doc", "tag", "new", "extra_field", 42).get().status()
    }
            + "    \"f_match_only_text\": { \"type\": \"match_only_text\" }\n"
                    "f_integer",
            + "  \"properties\": {\n"
            + "      }\n"
                    }
    }
     * Tests that index creation succeeds, a document can be added, but a mapping update
        IndexShard shard = getPrimaryShard(indexName);
     * Tests that a keyword field with a normalizer stores the raw value in sourceKeywordFieldType
        List<Map<String, Object>> parquetRows = readAllParquetRows(parquetDir, shard);
        // Index doc with value within ignore_above
import org.apache.lucene.index.LeafReaderContext;
        String indexName = "test-mapping-update-fail";
     * and the original un-normalized value is stored separately for source derivation.
                    "f_date_nanos",
                .setSource("f_long", 100L, "f_keyword", "alpha", "f_date", "2024-01-01", "f_text", "some text")
        assertEquals("WORLD", doc2Row.get("_ignored_source.field"));
    }
 * SPDX-License-Identifier: Apache-2.0
        // Verify parquet contains expected fields
        assertTrue("f_short in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_short")));
        // Dynamic mapping: add a new field not in original mapping
    }
    public void testKeywordIgnoreAboveIndexAndVerify() throws Exception {
        Path luceneDir = shard.shardPath().resolveIndex();
            + "  }\n"
    public void testMultiFieldTextWithKeywordSubfield() throws Exception {
                }
        startCluster();
            .get();
            .setMapping(mapping)
                    allFields.add(fi.name);
        assertEquals(
        Set<String> luceneFields = getLuceneFields(luceneDir);
        assertIndexCreationSucceeds("test-stored-only", "field", "type=keyword,index=false,doc_values=false,store=true");
                    "f_date",
    private Set<String> getLuceneFields(Path luceneDir) throws IOException {
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
