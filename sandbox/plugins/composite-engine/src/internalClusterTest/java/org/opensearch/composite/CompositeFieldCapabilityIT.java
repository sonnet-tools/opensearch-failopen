        assertTrue(parquetRows.stream().anyMatch(r -> r.containsKey("extra_field")));
            .get();
        ensureGreen(indexName);
                        Path filePath = parquetDir.resolve(file);
        IndexShard shard = getPrimaryShard(indexName);  
        assertTrue("f_keyword_ignore in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_keyword_ignore")));
                    99,
                .preparePutMapping(indexName)
                .setSource("f_long", 300L, "f_keyword", "gamma", "f_text", "third with dynamic", "dynamic_new_field", "dynamic_value")
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
    }
            + "        \"raw\": { \"type\": \"keyword\" }\n"  
        startCluster();
        MapperParsingException ex = expectThrows(
import org.opensearch.core.xcontent.NamedXContentRegistry;
        assertTrue(ex.getMessage(), ex.getMessage().contains("not supported by the [composite] data format"));
            .prepareCreate(indexName)  
        assertTrue(parquetRows.stream().anyMatch(r -> r.containsKey("f_text")));
        // Main field stores the normalized (lowercased) value  
            + "    \"field\": {\n"  
    }
        client().admin().indices().prepareFlush(indexName).get();
     * Tests dynamic mapping with a numeric field and verifies old+new docs coexist.  
        String mapping = "{\n"  
                .get()  
            .prepareCreate(indexName)
        Path luceneDir = shard.shardPath().resolveIndex();
        Settings settings = Settings.builder()
    private Settings dfaSettings() {
                    "f_text",
            + "}";
        }
        client().admin().indices().prepareFlush(indexName).get();  
        // Verify all 3 docs exist
import java.io.IOException;
        CreateIndexResponse response = client().admin()  
        assertEquals(3, parquetRows.stream().filter(r -> r.containsKey("id_field")).count());
        Map<String, Object> doc2Row = parquetRows.stream().filter(r -> "doc2".equals(r.get("id_field2"))).findFirst().orElseThrow();
import org.opensearch.common.xcontent.json.JsonXContent;  
package org.opensearch.composite;
import java.util.Set;  
            .putList("index.analysis.normalizer.my_lower.filter", "lowercase")
        String mapping = "{\n"
    public void testFlatObjectFieldUnsupported() {
            + "}";
        assertTrue("f_match_only_text in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_match_only_text")));
        assertIndexCreationSucceeds("test-date", "field", "type=date");
        startCluster();  
            client().prepareIndex(indexName)
    }
        assertIndexCreationFails("test-completion", "field", "type=completion");
    // ══════════════════════════════════════════════════════════════════════  
        IndexShard shard = getPrimaryShard(indexName);  
        assertTrue("Lucene should have field 'field'", luceneFields.contains("field"));  
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        assertIndexCreationFails("test-all-disabled", "field", "type=keyword,index=false,doc_values=false,store=false");  
        );
        assertTrue("f_date_nanos in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_date_nanos")));
import java.nio.file.Path;
        Map<String, Object> doc2Row = parquetRows.stream().filter(r -> "doc2".equals(r.get("id_field"))).findFirst().orElseThrow();
        startCluster();
    }  
        startCluster();  
     */  
    }  
        startCluster();
        try (GatedCloseable<CatalogSnapshot> snapshot = shard.getCatalogSnapshot()) {
     * Also verifies dynamic mapping works and old+new docs coexist.
            .prepareCreate("test-multi-field")
        assertEquals(3, parquetRows.size());  
            MapperParsingException.class,  
        startCluster();
        );
            + "    \"f_half_float\": { \"type\": \"half_float\" },\n"  
    public void testTextFieldSupported() {  
        assertTrue("f_date in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_date")));
     * Tests that multiple supported field types can be indexed together and verified.
                .get()
    }
        CreateIndexResponse response = client().admin().indices().prepareCreate(indexName).setSettings(settings).setMapping(mapping).get();  
        internalCluster().startClusterManagerOnlyNode();
        assertEquals(
        assertEquals(2, parquetRows.size());
                .status()
                )
        assertTrue(parquetRows.stream().anyMatch(r -> r.containsKey("f_date")));  
            .get();
            + "    \"field\": { \"type\": \"keyword\", \"normalizer\": \"my_lower\" }\n"
        // Main field stores the normalized (lowercased) value  
/*  
                }
        startCluster();
            }
    /**
        startCluster();
        startCluster();  
    public void testFieldWithOnlyStored() {
                    "short_val",  
     * Also adds a dynamic field and verifies old+new docs coexist.
        String indexName = "test-multi-field-verify";  
        startCluster();  
            )  
            + "}";
        assertIndexCreationSucceeds("test-integer", "field", "type=integer");
import java.util.List;
        startCluster();  
        Settings settings = Settings.builder()  
        assertEquals(
                        allRows.addAll(parseJsonRows(RustBridge.readAsJson(filePath.toString())));
            RestStatus.CREATED,
                    "f_integer",
    }
        CreateIndexResponse response = client().admin()  
                for (FieldInfo fi : ctx.reader().getFieldInfos()) {
                json
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("field", "short", "id_field", "doc1").get().status());
    }  
import org.opensearch.core.rest.RestStatus;
                    "f_ip",  
        assertTrue(parquetRows.stream().anyMatch(r -> r.containsKey("f_keyword")));
                    allFields.add(fi.name);
        assertIndexCreationSucceeds("test-binary", "field", "type=binary,store=true");  
        // Verify doc count
            () -> client().admin().indices().prepareCreate(indexName).setSettings(dfaSettings()).setMapping(fieldName, mappingType).get()
     * Tests that index creation succeeds, a document can be added, but a mapping update
        assertTrue(response.isAcknowledged());  
        startCluster();
        assertTrue("f_unsigned_long in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_unsigned_long")));  
            client().prepareIndex(indexName).setSource("content", "dynamic doc", "tag", "new", "extra_field", 42).get().status()
        client().admin().indices().prepareFlush(indexName).get();  
        assertIndexCreationFails("test-wildcard", "field", "type=wildcard");  
    public void testMultiFieldTextWithKeywordSubfield() throws Exception {
        assertEquals("Hello", doc1Row.get("_ignored_source.field"));
import org.opensearch.parquet.bridge.RustBridge;
        IndexShard shard = getPrimaryShard(indexName);
    // === SUPPORTED FIELDS (expect 200) ===
        assertTrue("f_half_float in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_half_float")));
            .indices()
            "this_exceeds_ignore_above_limit",
                    "f_keyword",  
    /**
        // id_field should be in all rows  
        assertIndexCreationFails("test-geo-point", "field", "type=geo_point");  
        startCluster();
     * Tests that a keyword field with a normalizer stores the raw value in sourceKeywordFieldType  
     * even when the value is within ignore_above. The normalized value goes into the main field,
            .prepareCreate(indexName)  
    public void testMultipleFieldsAllSupported() {  
        assertIndexCreationSucceeds("test-keyword", "field", "type=keyword");
 *
        Map<String, Object> doc2Row = parquetRows.stream().filter(r -> "doc2".equals(r.get("id_field"))).findFirst().orElseThrow();
        startCluster();  
        // Index initial doc
    public void testByteFieldSupported() {
        assertIndexCreationSucceeds("test-boolean", "field", "type=boolean,index=false");
        Map<String, Object> doc1Row = parquetRows.stream().filter(r -> "doc1".equals(r.get("id_field"))).findFirst().orElseThrow();
    public void testGeoPointFieldUnsupported() {
        assertTrue(parquetRows.stream().anyMatch(r -> r.containsKey("dynamic_num")));
                .get()
    // === SPECIAL CASES ===  
        assertTrue("Lucene should have field 'id_field'", luceneFields.contains("id_field"));
    }
    /**  
    }  
    public void testIpFieldSupported() {
    public void testFieldWithAllDisabled() {
        Path luceneDir = shard.shardPath().resolveIndex();
            + "  }\n"  
        // Rejection happens per leaf declared inside the nested scope: the composite plugin  
    }  
import java.util.ArrayList;
import org.opensearch.index.mapper.MapperParsingException;  
            .get();  
    public void testBinaryFieldSupported() {
    // ══════════════════════════════════════════════════════════════════════
            .setSettings(dfaSettings())
                .setSource("f_long", 100L, "f_keyword", "alpha", "f_date", "2024-01-01", "f_text", "some text")
        // Verify parquet
        assertTrue("f_ip in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_ip")));
    @Override
        ensureGreen(indexName);
        assertEquals("world", doc2Row.get("field"));
        // refuses to assign capabilities at FieldScope.NESTED until its formats implement
                    100L,  
                    "f_float",  
    public void testLongFieldSupported() {
            + "      \"type\": \"text\",\n"
        // Verify ignore_above behavior:  
        // Index initial docs
        ) {
            + "      \"fields\": {\n"
    public void testKeywordNormalizerStoresSourceSeparatelyWhenDynamicFieldIsPresent() throws Exception {
        // Index doc with value exceeding ignore_above (value ignored, sourceKeywordFieldType stores raw)  
            .indices()
        startCluster();
                    "2024-01-15",
                    "2024-06-01"
        Set<String> luceneFields = getLuceneFields(luceneDir);  
            + "      \"fields\": {\n"
        assertTrue(parquetRows.stream().anyMatch(r -> r.containsKey("content")));  
        assertTrue("f_boolean in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_boolean")));  
        assertTrue(response.isAcknowledged());
    @SuppressWarnings("unchecked")
            }
        assertEquals(
            + "  }\n"  
        assertDocCount(indexName, 2);
        assertTrue(parquetRows.stream().anyMatch(r -> r.containsKey("tag")));
            client().prepareIndex(indexName).setSource("field", "dynamic", "id_field", "doc3", "new_dynamic_field", "hello").get().status()  
                .setSource("f_long", 200L, "f_keyword", "beta", "f_date", "2024-06-15", "f_text", "more text")  
            client().prepareIndex(indexName)
            .indices()
            + "  }\n"  
            .setMapping("f_long", "type=long", "f_keyword", "type=keyword", "f_date", "type=date", "f_text", "type=text")  
        // Verify parquet
        assertIndexCreationFails("test-flat-object", "field", "type=flat_object");
        // All original fields should appear in at least one row
                .indices()  
        startCluster();
                    7,
import org.apache.lucene.index.FieldInfo;
                    true,
            .setSettings(dfaSettings())
        client().admin().indices().prepareFlush(indexName).get();  
            .build();  
        assertIndexCreationFails("test-geo-shape", "field", "type=geo_shape");
        try (Directory dir = NIOFSDirectory.open(luceneDir); DirectoryReader reader = DirectoryReader.open(dir)) {
        assertTrue("f_keyword in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_keyword")));
            + "    \"f_double\": { \"type\": \"double\" },\n"
        List<Map<String, Object>> parquetRows = readAllParquetRows(parquetDir, shard);
            RestStatus.CREATED,  
                .status()
                    "f_text",
        );
        assertEquals("hello", doc1Row.get("field"));
    public void testGeoShapeFieldUnsupported() {  
    @SuppressForbidden(reason = "JSON parsing for test verification of parquet output")
    public void testDoubleFieldSupported() {  
        assertEquals(expectedCount, stats.getIndex(indexName).getPrimaries().getDocs().getCount());
            .get();
                    "f_long",
import org.opensearch.index.shard.IndexShard;
    }
                    "2024-01-15T10:30:00.123456789Z",  
        expectThrows(
        );
        // sourceKeywordFieldType stores the original un-normalized value for source derivation
        startCluster();  
        return allRows;
        // Dynamic mapping: add a new field not in original mapping
        CreateIndexResponse response = client().admin()
            for (Segment segment : snapshot.get().getSegments()) {  
    private void startCluster() {  
        assertTrue(ex.getMessage(), ex.getMessage().contains("inside a nested object"));
    }  
        assertIndexCreationSucceeds("test-match-only-text", "field", "type=match_only_text");
            + "}";
            return parser.list().stream().map(o -> (Map<String, Object>) o).collect(Collectors.toList());
            + "    \"tag\": { \"type\": \"keyword\" }\n"  
        assertEquals("WORLD", doc2Row.get("_ignored_source.field"));  
            + "    }\n"
 */  
    }
        String indexName = "test-all-types-index";  
     */  
    }
    }
                    "second doc",  
                    "192.168.1.1",
            .put("index.composite.primary_data_format", "parquet")
            .indices()  
        startCluster();
    public void testNestedFieldUnsupported() {
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(response.isAcknowledged());  
        ensureGreen(indexName);  
    }
        assertEquals(  
    }
            + "    \"f_unsigned_long\": { \"type\": \"unsigned_long\" },\n"
        List<Map<String, Object>> parquetRows = readAllParquetRows(parquetDir, shard);  
        assertTrue("Lucene should have 'content.raw'", luceneFields.contains("content.raw"));
            client().prepareIndex(indexName)  
     * with an unsupported field type causes the shard to fail when applying the mapping.  
            .put("index.analysis.normalizer.my_lower.type", "custom")
            doc2Row.get("_ignored_source.field")  
        // Verify doc count via stats  
                    "f_half_float",
import java.util.Map;
            + "    \"f_keyword_ignore\": { \"type\": \"keyword\", \"ignore_above\": 256 },\n"  
            + "        \"raw\": { \"type\": \"keyword\" }\n"  
        );
            + "    \"f_long\": { \"type\": \"long\" },\n"  
    }
    }
                    "f_integer",
        CreateIndexResponse response = client().admin()
    public void testMatchOnlyTextFieldSupported() {  
            .putList("index.composite.secondary_data_formats", "lucene")
        client().admin().indices().prepareRefresh(indexName).get();
            + "    \"f_date_nanos\": { \"type\": \"date_nanos\" },\n"  
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
    /**  
        // Verify both docs exist
     * Tests that a keyword field with a normalizer stores the raw value in sourceKeywordFieldType
        // A mapping update adding an unsupported field type (geo_point) is now rejected up front  
            .put("index.analysis.normalizer.my_lower.type", "custom")
        assertTrue("f_text in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_text")));  
        CreateIndexResponse response = client().admin()
            "sourceKeywordFieldType should store raw value for doc2",
    public void testMappingUpdateFailsWithUnsupportedField() throws Exception {
    private void assertIndexCreationFails(String indexName, String fieldName, String mappingType) {
                    false,
import org.apache.lucene.store.NIOFSDirectory;
    private Set<String> getLuceneFields(Path luceneDir) throws IOException {  
        // Index doc — value is within any ignore_above but normalizer transforms it
        client().admin().indices().prepareFlush(indexName).get();  
import org.opensearch.index.engine.exec.Segment;  
        assertTrue("f_long in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_long")));
        assertIndexCreationSucceeds("test-unsigned-long", "field", "type=unsigned_long");
import org.apache.lucene.store.Directory;
        // nested storage. (The former server-side blanket rejection of the nested type on
        // Dynamic field should appear
    }
            RestStatus.CREATED,
 * and both parquet and lucene structures contain expected fields.  
            client().prepareIndex(indexName).setSource("field", "this_exceeds_ignore_above_limit", "id_field", "doc2").get().status()  
        assertEquals(2, parquetRows.size());  
            .setSettings(dfaSettings())  
import java.util.HashSet;  
            .get();  
import org.opensearch.action.admin.indices.create.CreateIndexResponse;  
        assertTrue("Lucene should have 'f_keyword_ignore'", luceneFields.contains("f_keyword_ignore"));
            RestStatus.CREATED,  
        // new_dynamic_field should appear in parquet (at least 1 row has it)  
                    "f_date_nanos",
        assertDocCount(indexName, 1);
        assertTrue(parquetRows.stream().anyMatch(r -> r.containsKey("dyn_bool")));
        // but _ignored_source.field should store the raw text value  
        assertEquals("WORLD", doc2Row.get("_ignored_source.field"));  
                .get()  
        // pluggable indices was removed by the pluggable-format seams change.)  
        assertTrue("Lucene should have 'content'", luceneFields.contains("content"));
                    "f_byte",
        // Index doc with dynamic numeric field
        IndexShard shard = getPrimaryShard(indexName);
import org.opensearch.index.engine.exec.WriterFileSet;
        startCluster();
        startCluster();
        // Dynamic mapping: add new field
     * even when the value is within ignore_above. The normalized value goes into the main field,
        // - doc1 ("short", len=5 <= 10): field should have the normalized value
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");  
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("name", "first").get().status());  
                .indices()
        assertEquals(  
        // Verify lucene has expected indexed fields  
            .setSettings(dfaSettings())
        // Dynamic mapping: add new field
            .putList("index.analysis.normalizer.my_lower.filter", "lowercase")  
        Path luceneDir = shard.shardPath().resolveIndex();
            client().prepareIndex(indexName).setSource("content", "hello world", "tag", "greeting").get().status()  
    public void testIntegerFieldSupported() {  
        assertEquals(
    protected Settings nodeSettings(int nodeOrdinal) {  
    }  
        ensureGreen(indexName);
    public void testKeywordNormalizerStoresSourceSeparately() throws Exception {
 * Integration tests validating field capability assignment for composite indices.
            .setSettings(dfaSettings())
            .get();
    }
        assertTrue(response.isAcknowledged());
                    42,
    }  
        assertIndexCreationSucceeds("test-stored-only", "field", "type=keyword,index=false,doc_values=false,store=true");
        assertTrue(response.isAcknowledged());
import org.opensearch.test.OpenSearchIntegTestCase;  
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("field", "Hello", "id_field1", "doc1").get().status());
        assertIndexCreationSucceeds("test-short", "field", "type=short");
            + "  \"properties\": {\n"
            .build();
    }  
        Set<String> allFields = new HashSet<>();
        String indexName = "test-keyword-ignore-above-verify";  
import org.opensearch.core.xcontent.DeprecationHandler;
        assertTrue(response.isAcknowledged());
        );
        assertTrue(response.isAcknowledged());
            .indices()
        startCluster();
            + "    \"content\": {\n"  
        );  
                .setSource(
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            .setMapping(mapping)
        String indexName = "test-dynamic-mapping";
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).build();
        String indexName = "test-mapping-update-fail";
            () -> client().admin()
                    "alpha",
        startCluster();
        assertTrue(parquetRows.stream().anyMatch(r -> r.containsKey("new_dynamic_field")));
        // Verify lucene
        assertIndexCreationSucceeds("test-byte", "field", "type=byte");  
                if (wfs != null) {
        Map<String, Object> doc1Row = parquetRows.stream().filter(r -> "doc1".equals(r.get("id_field"))).findFirst().orElseThrow();  
        startCluster();
    public void testFloatFieldSupported() {
    }
        assertTrue("f_byte in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_byte")));
                .prepareCreate("test-nested")
     */  
            + "  \"properties\": {\n"
    /**
        assertTrue("f_float in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_float")));
        assertTrue(response.isAcknowledged());  
        startCluster();  
            + "    \"f_short\": { \"type\": \"short\" },\n"
        // - doc2 ("this_exceeds_ignore_above_limit", len=32 > 10): field should be null/absent,
            .indices()
        assertTrue(response.isAcknowledged());
        startCluster();
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        startCluster();
        // sourceKeywordFieldType stores the original un-normalized value for source derivation
                )
                    9999999999L,
            .setMapping("f_long", "type=long", "f_keyword", "type=keyword", "f_date", "type=date", "f_text", "type=text")
            + "      }\n"
                    3.14,
                WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
    @SuppressForbidden(reason = "JSON parsing for test verification of parquet output")
        assertDocCount(indexName, 3);
        assertEquals("hello", doc1Row.get("field"));
            RestStatus.CREATED,
            + "  \"properties\": {\n"  
                .get()  
                    1.5f,  
import org.opensearch.common.concurrent.GatedCloseable;
                    "searchable text"  
    }
                    200L,  
            + "      }\n"
        expectThrows(  
        startCluster();
            .setMapping(mapping)
            MapperParsingException.class,
     * and the original un-normalized value is stored separately for source derivation.
            + "    \"id_field\": { \"type\": \"keyword\" }\n"
    public void testUnsignedLongFieldSupported() {  
    /**  
    public void testMultiFieldIndexAndVerify() throws Exception {
        startCluster();
            + "    \"f_match_only_text\": { \"type\": \"match_only_text\" }\n"  
        String mapping = "{\n"
        // The index remains healthy and the original data is intact.  
            + "  \"properties\": {\n"
                .setSource(
            .indices()  
        try (
    public void testDynamicMappingNumericField() throws Exception {
                    2.5f,
            .setMapping("name", "type=keyword")  
    public void testDateFieldSupported() {
        );
     * Also adds a dynamic field and verifies old+new docs coexist.
            .setSettings(dfaSettings())  
        client().admin().indices().prepareRefresh(indexName).get();
        );
            + "    \"f_float\": { \"type\": \"float\" },\n"
        startCluster();
        assertIndexCreationSucceeds(indexName, "field", "type=keyword");
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
    // === UNSUPPORTED FIELDS (expect 400 MapperParsingException) ===
        String mapping = "{\n"
        ensureGreen(indexName);
            () -> client().admin()  
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("field", "WORLD", "id_field2", "doc2").get().status());  
            + "    \"f_ip\": { \"type\": \"ip\" },\n"
        ensureGreen(indexName);
/**  
        IndicesStatsResponse stats = client().admin().indices().prepareStats(indexName).clear().setDocs(true).get();  
        IndexShard shard = getPrimaryShard(indexName);
            XContentParser parser = JsonXContent.jsonXContent.createParser(
                    "f_long",
    }  
     * and verifies parquet/lucene structures contain expected fields and all docs coexist.
import java.nio.file.Files;  
            RestStatus.CREATED,  
    public void testKeywordIgnoreAboveIndexAndVerify() throws Exception {
    public void testKeywordFieldSupportedWithIgnoreAbove() {
            + "      \"type\": \"text\",\n"
            + "    \"f_byte\": { \"type\": \"byte\" },\n"  
 */
        CreateIndexResponse response = client().admin()
        assertTrue("Lucene should have dynamic field 'new_dynamic_field'", luceneFields.contains("new_dynamic_field"));
        client().admin().indices().prepareRefresh(indexName).get();
        assertTrue("Lucene should have 'dynamic_new_field'", luceneFields.contains("dynamic_new_field"));
                    "f_keyword_ignore",
        assertTrue("dynamic_new_field in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("dynamic_new_field")));
        List<Map<String, Object>> parquetRows = readAllParquetRows(parquetDir, shard);
        assertTrue("Lucene should have 'f_text'", luceneFields.contains("f_text"));  
        assertIndexCreationSucceeds("test-float", "field", "type=float");
        assertTrue("f_double in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_double")));  
        internalCluster().startDataOnlyNode();
        // Index second doc with some fields  
        assertDocCount(indexName, 2);
        ensureGreen("test-multi-field");  
            + "    \"f_boolean\": { \"type\": \"boolean\", \"index\": false },\n"
        assertEquals(
                .get()  
        assertTrue("Lucene should have 'f_keyword'", luceneFields.contains("f_keyword"));
    }
     * Tests indexing and dynamic mapping for ALL supported field types.  
                .get()
        assertEquals(  
        String indexName = "test-multi-types-verify";  
            + "    \"f_keyword\": { \"type\": \"keyword\" },\n"
            .prepareCreate(indexName)
    public void testHalfFloatFieldSupported() {
        assertIndexCreationSucceeds("test-keyword", "field", "type=keyword,ignore_above=256");  
        // Index doc with all field types populated  
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
            .put("index.pluggable.dataformat.enabled", true)
                .status()  
    }
        );
    }
    // Private helpers
        Set<String> luceneFields = getLuceneFields(luceneDir);  
                    "beta",
                    "f_keyword",  
            client().prepareIndex(indexName)
        // by the cluster-manager during capability validation, so the mapping is never published
        ensureGreen("test-multiple-fields");  
public class CompositeFieldCapabilityIT extends AbstractCompositeEngineIT {  
        return Settings.builder()
        assertIndexCreationSucceeds("test-text", "field", "type=text");
        assertEquals(
        // Index doc — value is within any ignore_above but normalizer transforms it
            RestStatus.CREATED,
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("field", "Hello", "id_field", "doc1").get().status());
        client().admin().indices().prepareFlush(indexName).get();
        // Index initial docs  
     */  
                    "f_boolean",
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            client().prepareIndex(indexName)  
            .setSettings(dfaSettings())
        // doc2: value exceeds ignore_above — field is null (ignored), source keyword stores raw value
    // === INDEXING + STRUCTURE VERIFICATION TESTS ===  
 * The OpenSearch Contributors require contributions made to  
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
        assertIndexCreationSucceeds("test-doc-values-only", "field", "type=keyword,index=false,doc_values=true");
    }
    private void assertIndexCreationSucceeds(String indexName, String fieldName, String mappingType) {
        // Index a document successfully
                .status()
    }  
        assertDocCount(indexName, 3);  
        // and the shard is not left in an unrecoverable state.
                NamedXContentRegistry.EMPTY,  
        startCluster();  
                .setSource("{\"properties\":{\"unsupported_geo\":{\"type\":\"geo_point\"}}}", MediaTypeRegistry.JSON)
            RestStatus.CREATED,
            .setSettings(dfaSettings())  
        );
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("field", "WORLD", "id_field", "doc2").get().status());  
        startCluster();  
            .build();  
        String mapping = "{\n"
        client().admin().indices().prepareFlush(indexName).get();
    }
            + "  }\n"
        // Verify parquet contains expected fields
            RestStatus.CREATED,
        assertIndexCreationSucceeds("test-date-nanos", "field", "type=date_nanos");  
        assertEquals(2, parquetRows.size());
        CreateIndexResponse response = client().admin()  
                    "f_short",  
        assertEquals(
 * SPDX-License-Identifier: Apache-2.0
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .get()
    public void testDateNanosFieldSupported() {
    private List<Map<String, Object>> parseJsonRows(String json) throws IOException {  
        Path luceneDir = shard.shardPath().resolveIndex();
        assertEquals("Hello", doc1Row.get("_ignored_source.field"));
        startCluster();
                    "hello world",
     */
        // Dynamic mapping: add a new field  
        assertTrue("Lucene should have 'tag'", luceneFields.contains("tag"));  
        startCluster();  
        List<Map<String, Object>> parquetRows = readAllParquetRows(parquetDir, shard);
        client().admin().indices().prepareRefresh(indexName).get();
        List<Map<String, Object>> parquetRows = readAllParquetRows(parquetDir, shard);  
            .prepareCreate(indexName)
    }
    public void testBooleanFieldSupported() {  
    /**
    public void testWildcardFieldUnsupported() {
 * Verifies that supported field types create successfully, documents can be indexed,
        assertEquals(3, parquetRows.size());
    }
                    "f_double",
        // Verify parquet has both docs
            + "    \"f_integer\": { \"type\": \"integer\" },\n"
            .setMapping("field", "type=keyword,ignore_above=10", "id_field", "type=keyword")
}
        startCluster();  
            + "  \"properties\": {\n"
            RestStatus.CREATED,
    }  
            .indices()  
                    "f_boolean",
        // Verify lucene has expected indexed fields (inverted index: text/keyword types)
        // Verify doc was indexed  
    public void testAllSupportedFieldTypesIndexAndVerify() throws Exception {
     * is stored in parquet when the value exceeds ignore_above.
                .status()
        List<Map<String, Object>> allRows = new ArrayList<>();
        client().admin().indices().prepareRefresh(indexName).get();  
            for (LeafReaderContext ctx : reader.leaves()) {  
            MapperParsingException.class,
        // Verify doc count
     */
                }  
import org.opensearch.cluster.metadata.IndexMetadata;
        client().admin().indices().prepareRefresh(indexName).get();
import org.opensearch.core.xcontent.XContentParser;
        // doc1: value within ignore_above — field is stored, no source keyword field needed
        assertIndexCreationSucceeds("test-half-float", "field", "type=half_float");  
            + "    },\n"
                .status()
            .setMapping(fieldName, mappingType)
        assertDocCount(indexName, 3);
            + "    \"f_date\": { \"type\": \"date\" },\n"
        assertIndexCreationSucceeds("test-long", "field", "type=long");  
    }
        assertEquals("world", doc2Row.get("field"));
        assertDocCount(indexName, 3);
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("content", "foo bar", "tag", "test").get().status());
                    1,  
        assertIndexCreationSucceeds("test-double", "field", "type=double");
        assertEquals("short", doc1Row.get("field"));
import java.util.stream.Collectors;
        ensureGreen(indexName);
    }
            + "    \"f_text\": { \"type\": \"text\" },\n"
import org.opensearch.common.SuppressForbidden;  
        String indexName = "test-keyword-normalizer-verify-dynamic-field";
        return allFields;  
        );
            client().prepareIndex(indexName)
                    "f_date",  
 * compatible open source license.
        assertDocCount(indexName, 2);  
        assertTrue("Lucene should have 'f_match_only_text'", luceneFields.contains("f_match_only_text"));
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");  
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("field", "value1").get().status());
                    "f_date",  
        );  
            + "  }\n"
    private void assertDocCount(String indexName, long expectedCount) {
    }
        assertTrue(response.isAcknowledged());
     * and the original un-normalized value is stored separately for source derivation.  
        startCluster();
        client().admin().indices().prepareRefresh(indexName).get();
     * Tests multi-field text+keyword indexing and verifies both parquet and lucene structures.
        Set<String> luceneFields = getLuceneFields(luceneDir);  
        IndexShard shard = getPrimaryShard(indexName);
        }  
    }  
    }  
        List<Map<String, Object>> parquetRows = readAllParquetRows(parquetDir, shard);  
        assertTrue("f_short in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_short")));
    public void testCompletionFieldUnsupported() {
        assertNull("field should be null for doc2 (exceeds ignore_above)", doc2Row.get("field"));
    public void testMultipleFieldTypesIndexAndVerify() throws Exception {
import org.opensearch.common.settings.Settings;
            .put("index.pluggable.dataformat", "composite")  
            .get();
        }  
    public void testShortFieldSupported() {
        List<Map<String, Object>> parquetRows = readAllParquetRows(parquetDir, shard);
                    for (String file : wfs.files()) {  
        assertEquals(3, parquetRows.size());
        ensureGreen(indexName);
            .put(dfaSettings())  
        Map<String, Object> doc1Row = parquetRows.stream().filter(r -> "doc1".equals(r.get("id_field1"))).findFirst().orElseThrow();  
    }
    public void testKeywordFieldSupported() {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        // Verify parquet contains expected fields  
     */  
    public void testFieldWithOnlyDocValues() {  
            + "}";
        assertEquals(
        IndexShard shard = getPrimaryShard(indexName);
            .prepareCreate(indexName)
                .setMapping("{\"properties\": {\"field\": {\"type\": \"nested\", \"properties\": {\"name\": {\"type\": \"keyword\"}}}}}")
        assertTrue("Parquet directory should exist", Files.isDirectory(parquetDir));  
            .get();
                    "f_unsigned_long",
        assertTrue("Lucene should have 'f_text'", luceneFields.contains("f_text"));
    // === MAPPING UPDATE FAILURE TEST ===
        Path parquetDir = shard.shardPath().getDataPath().resolve("parquet");
        assertTrue(parquetRows.stream().anyMatch(r -> r.containsKey("f_long")));
     * Tests that a keyword field with ignore_above can be indexed and the sourceKeywordFieldType  
            .put(dfaSettings())
        Set<String> luceneFields = getLuceneFields(luceneDir);
                    }  
        assertEquals(RestStatus.CREATED, client().prepareIndex(indexName).setSource("name", "second", "dynamic_num", 42).get().status());  
            .prepareCreate("test-multiple-fields")
     * Creates an index with every supported type, indexes documents, adds a dynamic field,
     */
        assertDocCount(indexName, 1);
    }
        CreateIndexResponse response = client().admin()
        startCluster();
    }  
import org.apache.lucene.index.LeafReaderContext;  
    private List<Map<String, Object>> readAllParquetRows(Path parquetDir, IndexShard shard) throws IOException {
            .setMapping(mapping)  
import org.apache.lucene.index.DirectoryReader;
        client().admin().indices().prepareRefresh(indexName).get();
        );  
        ensureGreen(indexName);
                    "f_match_only_text",
        assertTrue("f_integer in parquet", parquetRows.stream().anyMatch(r -> r.containsKey("f_integer")));  
        String indexName = "test-keyword-normalizer-verify";  
                .setSettings(dfaSettings())  
        // Index doc with value within ignore_above
            + "    \"field\": { \"type\": \"keyword\", \"normalizer\": \"my_lower\" },\n"
        assertEquals(3, parquetRows.size());
                .setSource("f_long", 300L, "f_keyword", "gamma", "f_date", "2024-12-31", "f_text", "final", "dyn_bool", true)  
        assertTrue("Lucene should have 'f_keyword'", luceneFields.contains("f_keyword"));
        CreateIndexResponse response = client().admin().indices().prepareCreate(indexName).setSettings(settings).setMapping(mapping).get();  
        assertIndexCreationSucceeds("test-ip", "field", "type=ip");
        // Verify lucene has text field and keyword sub-field
    /**
