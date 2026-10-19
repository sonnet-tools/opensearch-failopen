            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        }
                .putList("index.parquet.compression.field", "name", "value")
                    assertTrue(
        String encodingsStr = colJson.substring(encStart + 1, encEnd);  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        assertTrue(e.getMessage().contains("Invalid arrow type"));
     */  
import java.util.ArrayList;
     */
            }
 *
            .setSettings(builder)  
    /**
            CompositeDataFormatPlugin.class,
                .putList("index.parquet.encoding.field", "name", "value")
        createCompositeIndexWithSettings(
                    IllegalArgumentException e = expectThrows(
        assertTrue(e.getMessage().contains("not compatible") || e.getMessage().contains("not supported"));
                    .build();
    }  
                    .putList("index.parquet.encoding.field", "name")  
            () -> createCompositeIndexWithNodeSettings(
    // --- Helpers ---  
        Map<String, Object> valueMeta = getColumnInfo(INDEX_NAME, "value");  
    @SuppressWarnings("unchecked")
import java.nio.file.Path;  
    // --- 3-tier precedence tests (field > type > global) ---
    // --- Encoding/compression exhaustive combination tests ---  
        assertCompression(valueMeta, "ZSTD");
    }  
                .putList("index.parquet.encoding.value", "DELTA_BYTE_ARRAY")
                    // Should be accepted — no exception
        );  
    /**
            encodings.add(enc.trim().replace("\"", ""));  
        result.put("encodings", encodings);
                boolean compatible = ParquetSettings.isEncodingValidForArrowType(encoding, arrowType);
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
    /**
     * Loops over every (field, compression) pair for field-level settings.
            IllegalArgumentException.class,
        refreshIndex(INDEX_NAME);  
        assertTrue(e.getMessage().contains("Invalid compression"));
                Settings nodeSettings = Settings.builder()  
        ensureGreen(INDEX_NAME);
        ensureGreen(INDEX_NAME);
                    createCompositeIndexWithSettings(indexSettings);
            () -> createCompositeIndexWithNodeSettings(Settings.builder().put("parquet.type_encoding.int64.encoding", "INVALID").build())  
     * Loops over every (field, encoding) pair for field-level settings.  
                    .build();
        }
            .putList("index.composite.secondary_data_formats")  
        Map<String, Object> colMeta = getColumnInfo(INDEX_NAME, "name");
     */  
                    .putList("index.parquet.compression.field", "value")
     * Loops over every (arrow_type, encoding) pair for type-level settings.  
    }
        ensureGreen(INDEX_NAME);
        ensureGreen(INDEX_NAME);
        Map<String, Object> nameMeta = getColumnInfo(INDEX_NAME, "name");
            IllegalArgumentException.class,  
        ensureGreen(INDEX_NAME);
     * All compressions are valid for all types — every combo must be accepted.
    /**
                .build()  
    }
                .putList("index.parquet.encoding.value", "delta_binary_packed")
            .put("index.composite.primary_data_format", "parquet")
        );
        ensureGreen(INDEX_NAME);
        createCompositeIndexWithSettings(
            .get();
        Map<String, Object> valueMeta = getColumnInfo(INDEX_NAME, "value");
        createCompositeIndexWithSettings(
     * Verifies that field-level encoding is applied and visible in parquet metadata.
    public void testMultipleFieldLevelSettings() throws IOException {
            () -> createCompositeIndexWithSettings(
                .putList("index.parquet.compression.value", "ZSTD")
        }  
        IllegalArgumentException e = expectThrows(
        Settings.Builder builder = Settings.builder()  
                    IllegalArgumentException e = expectThrows(
        );  
    public void testValidTypeCompressionAccepted() {  
            for (String compression : ParquetSettings.VALID_COMPRESSIONS) {
import java.util.Collection;  
        assertCompression(nameMeta, "ZSTD");  
    }  
        );
        ensureGreen(INDEX_NAME);  
            DataFusionPlugin.class  
        createCompositeIndexWithSettings(Settings.builder().build());
import org.opensearch.composite.framework.ParquetOnlyDataFormatPlugin;
        boolean hasBloomFilter = false;  
        assertEquals(Boolean.TRUE, nameMeta.get("bloom_filter"));
                    .putList("index.parquet.encoding.field", field)  
                    .build();
                client().admin().cluster().prepareUpdateSettings().setTransientSettings(nodeSettings).get();
        flushIndex(INDEX_NAME);
            IllegalArgumentException.class,
    }
            .indices()
                Settings indexSettings = Settings.builder()
            IllegalArgumentException.class,  
        );  
     */
    // --- Field-level compression validation ---
        String json = getFirstFileColumnMetadata(indexName);  
        // Parse compression  
                .putList("index.parquet.encoding.field", "name")
                client().admin().indices().prepareDelete(INDEX_NAME).get();
     */  
    }
        return Arrays.asList(
 * SPDX-License-Identifier: Apache-2.0
                    .build()  
    @Override
    public void testTypeLevelCompressionAllCombinations() {  
        createCompositeIndexWithSettings(
                } else {  
            for (String encoding : ParquetSettings.VALID_ENCODINGS) {  
        );  
            Settings.builder()
        );
        indexDocs(INDEX_NAME, 5, 0);
            .putList("index.composite.secondary_data_formats");
        IllegalArgumentException e = expectThrows(  
            }
     */
    public void testInvalidArrowTypeInTypeEncodingRejected() {  
            .indices()
    // --- Encoding-type compatibility validation ---
        String compKey = "\"compression\":\"";
        ensureGreen(INDEX_NAME);
        assertHasEncoding(colMeta, "DELTA_BYTE_ARRAY");
    public void testEncodingCaseInsensitive() {  
        result.put("bloom_filter", hasBloomFilter);  
import org.apache.arrow.vector.types.pojo.ArrowType;
        flushIndex(INDEX_NAME);
        ensureGreen(INDEX_NAME);
 */  
import org.opensearch.parquet.ParquetSettings;
            .setMapping("name", "type=keyword,index=false", "value", "type=integer")
            Settings.builder()  
    }
    }  
        assertTrue(  
                .put("index.parquet.compression_type", "SNAPPY")  
    }
        );
import java.util.List;
        );
        assertCompression(colMeta, "ZSTD");  
import org.opensearch.be.lucene.LucenePlugin;
    }
        for (String arrowType : ParquetSettings.VALID_ARROW_TYPES) {
    /**
/**
        String bfKey = "\"bloom_filter\":";
                        IllegalArgumentException.class,
                } else {  
    public void testBloomFilterDisabledByDefault() throws IOException {  
    /**  
            String field = fieldEntry.getKey();
    public void testValidFieldCompressionAccepted() {
                .putList("index.parquet.encoding.field", "name")
    public void testCompressionCaseInsensitive() {
                .build()
            for (String compression : ParquetSettings.VALID_COMPRESSIONS) {  
                .putList("index.parquet.compression.value", "snappy")
            () -> createCompositeIndexWithNodeSettings(  
        fail("No parquet file found for index: " + indexName);  
                        "Expected incompatibility error for type=" + arrowType + " encoding=" + encoding + ", got: " + e.getMessage(),  
        );
            LucenePlugin.class,
    public void testTypeLevelEncodingAllCombinations() {  
                .putList("index.parquet.compression.value", "ZSTD")  
            hasBloomFilter = "true".equals(bfVal);  
        );  
    }
        List<String> encodings = new ArrayList<>();
        String key = "\"" + columnName + "\":{";
        createCompositeIndexWithSettings(
        assertHasEncoding(valueMeta, "DELTA_BINARY_PACKED");  
        flushIndex(INDEX_NAME);
                .build()  
    public void testValidFieldEncodingAccepted() {  
        );
    /**  
        for (Segment segment : snapshot.getSegments()) {
     */
        IllegalArgumentException e = expectThrows(
        indexDocs(INDEX_NAME, 5, 0);  
                    );
            ParquetSettings.ARROW_TYPE_NAME_TO_INSTANCE.get("int32")
        IllegalArgumentException e = expectThrows(
    public void testGlobalCompressionApplied() throws IOException {
 * The OpenSearch Contributors require contributions made to  
            ParquetOnlyDataFormatPlugin.class,  
    }
    public void testInvalidFieldEncodingRejected() {
     */
        ensureGreen(INDEX_NAME);
        ensureGreen(INDEX_NAME);
import org.opensearch.common.settings.Settings;  
     */  
    }  
            ParquetSettings.ARROW_TYPE_NAME_TO_INSTANCE.get("utf8"),
        assertCompression(colMeta, "SNAPPY");
        Map<String, Object> nameMeta = getColumnInfo(INDEX_NAME, "name");  
        String compression = (String) colMeta.get("compression");
                .putList("index.parquet.encoding.value", "DELTA_BYTE_ARRAY")
        createCompositeIndexWithNodeSettings(Settings.builder().put("parquet.type_compression.utf8.compression", "ZSTD").build());
    }  
        assertTrue(e.getMessage().contains("foobar"));  
public class CompositeParquetSettingsValidationIT extends AbstractCompositeEngineIT {
        createCompositeIndexWithSettings(  
        indexDocs(INDEX_NAME, 5, 0);
        flushIndex(INDEX_NAME);
                        return RustBridge.getColumnMetadata(filePath.toString());
        );
                    Path filePath = parquetDir.resolve(file);
                    );
            () -> createCompositeIndexWithNodeSettings(Settings.builder().put("parquet.type_encoding.banana.encoding", "PLAIN").build())  
        assertTrue("Expected encoding '" + expectedEncoding + "' in " + encodings, encodings.contains(expectedEncoding));
     * Verifies field-level compression overrides global compression for a specific column.
                Settings.builder()
        String colJson = json.substring(braceStart, braceEnd + 1);
        refreshIndex(INDEX_NAME);
    }
        assertHasEncoding(nameMeta, "DELTA_BYTE_ARRAY");
                .putList("index.parquet.compression.field", "value")
import java.io.IOException;
    public void testFieldLevelEncodingApplied() throws IOException {
     * Verifies that global compression (index.parquet.compression_type) is applied
        int braceStart = json.indexOf('{', start + key.length() - 1);
                .putList("index.parquet.encoding.value", "DELTA_BINARY_PACKED")
    // --- Type-level encoding validation ---  
        assertEquals(Boolean.TRUE, valueMeta.get("bloom_filter"));
                    assertTrue(
        // Parse bloom_filter  
                .build()  
 */
                    .putList("index.parquet.encoding.value", encoding)
        // DELTA_BINARY_PACKED is only valid for integer types, not keyword (utf8)
            .setSettings(builder)
     * Valid combos must be accepted; incompatible combos must throw IllegalArgumentException.
            }
        // DELTA_BINARY_PACKED is only valid for integer types, not utf8  
        Map<String, Object> nameMeta = getColumnInfo(INDEX_NAME, "name");
        return result;
    public void testIncompatibleTypeLevelEncodingRejected() {
            .put(extraSettings);
                Settings indexSettings = Settings.builder()
/*  
            .prepareCreate(INDEX_NAME)  
        );
        int start = json.indexOf(key);  
                .putList("index.parquet.compression.value", "SNAPPY")
                .putList("index.parquet.compression.field", "value")
                // All combos valid — must not throw
        createCompositeIndexWithSettings(Settings.builder().put("index.parquet.bloom_filter_enabled", "true").build());  
    @SuppressWarnings("unchecked")
            "value",  
        flushIndex(INDEX_NAME);
    // --- Case insensitivity ---
            .put("index.pluggable.dataformat.enabled", true)
    }
import java.util.HashMap;
        refreshIndex(INDEX_NAME);
        indexDocs(INDEX_NAME, 5, 0);
 * and type-level encoding/compression validations are enforced at index creation time.
    }
    public void testInvalidArrowTypeInTypeCompressionRejected() {
        indexDocs(INDEX_NAME, 5, 0);  
        Map<String, Object> nameMeta = getColumnInfo(INDEX_NAME, "name");
        indexDocs(INDEX_NAME, 5, 0);  
        createCompositeIndexWithSettings(
    public void testGlobalBloomFilterEnabled() throws IOException {
            .put("index.pluggable.dataformat", "composite")
            ArrowType arrowType = fieldEntry.getValue();
        for (String field : List.of("name", "value")) {
    }
            Settings.builder()
        );
    private void createCompositeIndexWithNodeSettings(Settings nodeSettings) {
            compression.startsWith(expectedPrefix)
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
                .putList("index.parquet.encoding.field", "value")  
    private void createCompositeIndexWithSettings(Settings extraSettings) {
    /**
    public void testInvalidFieldCompressionRejected() {
     * Verifies that global bloom_filter_enabled=true enables bloom filters for all columns.  
        );
    }
                .putList("index.parquet.encoding.value", "DELTA_BYTE_ARRAY", "DELTA_BINARY_PACKED")  
        createCompositeIndexWithSettings(Settings.builder().put("index.parquet.compression_type", "SNAPPY").build());  
        }  
            .put("index.pluggable.dataformat.enabled", true)  
                createCompositeIndexWithSettings(indexSettings);  
        indexDocs(INDEX_NAME, 5, 0);  
        assertCompression(valueMeta, "ZSTD");
 * this file be licensed under the Apache-2.0 license or a
        int bfStart = colJson.indexOf(bfKey);
            .prepareCreate(INDEX_NAME)
     * Verifies that field-level compression is applied and visible in parquet metadata.  
                    );
        Map<String, Object> nameMeta = getColumnInfo(INDEX_NAME, "name");
     */
    private static final String INDEX_NAME = "test-settings-validation";  
        Path parquetDir = getPrimaryShard(indexName).shardPath().getDataPath().resolve("parquet");
                .putList("index.parquet.encoding.field", "value")  
        assertTrue(e.getMessage().contains("not compatible") || e.getMessage().contains("not supported"));
    }
                .build()
        int encEnd = colJson.indexOf(']');
        );
            }
                    }
    // --- Bloom filter tests ---
    /**
                        IllegalArgumentException.class,
        // DELTA_BINARY_PACKED is valid for integer types  
        }
        int encStart = colJson.indexOf('[');
            String bfVal = colJson.substring(bfStart + bfKey.length()).split("[,}]")[0].trim();
    /**
                Settings.builder().put("parquet.type_encoding.utf8.encoding", "DELTA_BINARY_PACKED").build()
                    if (Files.exists(filePath)) {  
                Settings.builder().put("parquet.type_compression.utf8.compression", "INVALID").build()
                boolean compatible = arrowTypeInstance == null || ParquetSettings.isEncodingValidForArrowType(encoding, arrowTypeInstance);
import org.opensearch.arrow.allocator.ArrowBasePlugin;
                }  
import org.opensearch.cluster.metadata.IndexMetadata;
                        e.getMessage().contains("not compatible") || e.getMessage().contains("not supported")
    }  
    public void testInvalidEncodingValueInTypeEncodingRejected() {  
            Settings.builder()  
            .get();  
    }
import org.opensearch.parquet.bridge.RustBridge;  
        createCompositeIndexWithNodeSettings(Settings.builder().put("parquet.type_encoding.int64.encoding", "DELTA_BINARY_PACKED").build());  
        client().admin()
    }
            "name",
     * Verifies multiple field-level settings can coexist on different columns.  
        indexDocs(INDEX_NAME, 5, 0);  
    public void testFieldLevelCompressionAllCombinations() {
 * Integration tests verifying that Parquet field-level encoding/compression  
        );
                for (String file : wfs.files()) {
                if (compatible) {  
            for (String encoding : ParquetSettings.VALID_ENCODINGS) {
            Settings.builder()
    }
        assertEquals(Boolean.FALSE, nameMeta.get("bloom_filter"));
     * Valid combos must be accepted at index creation; incompatible combos must throw IllegalArgumentException.
            Settings.builder()  
                .build()  
        assertCompression(nameMeta, "ZSTD");
                        () -> client().admin().cluster().prepareUpdateSettings().setTransientSettings(nodeSettings).get()  
        assertTrue(e.getMessage().contains("Invalid compression"));  
        );  
        createCompositeIndexWithSettings(
    public void testFieldLevelCompressionOverridesGlobal() throws IOException {  
            }
    private Map<String, Object> getColumnInfo(String indexName, String columnName) throws IOException {
            IllegalArgumentException.class,  
        IllegalArgumentException e = expectThrows(
                .putList("index.parquet.compression.field", "value")
        Map<String, Object> colMeta = getColumnInfo(INDEX_NAME, "value");
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    public void testFieldLevelBloomFilterEnabled() throws IOException {
                        () -> createCompositeIndexWithSettings(indexSettings)  
                    .putList("index.parquet.compression.value", compression)  
        flushIndex(INDEX_NAME);
        Map<String, Object> valueMeta = getColumnInfo(INDEX_NAME, "value");
        for (String arrowType : ParquetSettings.VALID_ARROW_TYPES) {
        assertTrue(e.getMessage().contains("Invalid arrow type"));
}  
    }
        assertTrue(e.getMessage().contains("Invalid encoding"));
                .putList("index.parquet.bloom_filter_enabled.field", "name")
        for (Map.Entry<String, ArrowType> fieldEntry : fieldToArrowType.entrySet()) {  
    /**
                    );
        client().admin()  
                        "Expected incompatibility error for field=" + field + " encoding=" + encoding + ", got: " + e.getMessage(),  
        // Parse encodings list  
        createCompositeIndexWithSettings(  
        if (bfStart != -1) {
        refreshIndex(INDEX_NAME);  
        CatalogSnapshot snapshot = acquireAndGetSnapshot(indexName);
        indexDocs(INDEX_NAME, 5, 0);  
            .put("index.pluggable.dataformat", "composite")  
            () -> createCompositeIndexWithNodeSettings(  
                }  
            Settings.builder()  
        // Other columns should still have no bloom filter (global default is disabled)
            Settings.builder()
            () -> createCompositeIndexWithSettings(
        Map<String, Object> result = new HashMap<>();  
        flushIndex(INDEX_NAME);
    public void testFieldLevelEncodingWithGlobalCompression() throws IOException {  
    public void testInvalidCompressionValueInTypeCompressionRejected() {  
    }  
    public void testIncompatibleEncodingForFieldTypeRejected() {  
        flushIndex(INDEX_NAME);  
            ArrowBasePlugin.class,
        createCompositeIndexWithSettings(
        assertFalse("Column '" + columnName + "' not found in metadata: " + json, start == -1);
            .setMapping("name", "type=keyword,index=false", "value", "type=integer")
        IllegalArgumentException e = expectThrows(
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)  
                .putList("index.parquet.compression.value", "SNAPPY", "ZSTD")
        Map<String, ArrowType> fieldToArrowType = Map.of(  
                    .putList("index.parquet.compression.value", "INVALID_COMPRESSION")
    // --- Type-level compression validation ---
        List<String> encodings = (List<String>) colMeta.get("encodings");  
                ArrowType arrowTypeInstance = ParquetSettings.ARROW_TYPE_NAME_TO_INSTANCE.get(arrowType);  
import org.opensearch.index.engine.exec.Segment;
            IllegalArgumentException.class,
        return null;
        refreshIndex(INDEX_NAME);
    }  
        IllegalArgumentException e = expectThrows(
        int compStart = colJson.indexOf(compKey) + compKey.length();
        ensureGreen(INDEX_NAME);
        );
     * All compressions are valid for all field types — every combo must be accepted.
    public void testValidTypeEncodingAccepted() {
import org.opensearch.test.OpenSearchIntegTestCase;
     * Verifies that bloom filters are disabled by default for all columns.
     * Uses keyword (utf8) and integer (int32) fields to cover string and numeric types.
    // --- Field-level encoding validation ---
                .build()  
                Settings.builder()  
    }  
        );
     * Verifies field-level encoding with global compression.
            Settings.builder()
    }
    public void testFieldLevelEncodingAllCombinations() {
    public void testCompatibleEncodingForFieldTypeAccepted() {
 * compatible open source license.
            )  
                    .build()
import org.opensearch.plugins.Plugin;
        // field -> arrow type instance for compatibility check
     */
            () -> createCompositeIndexWithSettings(
        // Extract the JSON object for the specific column
        for (String enc : encodingsStr.split(",")) {
        assertEquals(Boolean.FALSE, valueMeta.get("bloom_filter"));  
import java.util.Arrays;
        result.put("compression", compression);
    private String getFirstFileColumnMetadata(String indexName) throws IOException {  
        flushIndex(INDEX_NAME);
     * Verifies that field-level bloom_filter_enabled=true enables bloom filter for that column only.
    /**  
    }
            Settings.builder()
     * when no field-level or type-level config is set.  
        Map<String, Object> valueMeta = getColumnInfo(INDEX_NAME, "value");
    }
package org.opensearch.composite;
import org.opensearch.index.engine.exec.WriterFileSet;  
                .build()  
        int braceEnd = json.indexOf('}', braceStart);  
            )  
        IllegalArgumentException e = expectThrows(
            .put("index.composite.primary_data_format", "parquet")
        }
                    client().admin().indices().prepareDelete(INDEX_NAME).get();
        assertEquals(Boolean.TRUE, nameMeta.get("bloom_filter"));
     */
        createCompositeIndexWithSettings(
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
            IllegalArgumentException.class,
            )
                        e.getMessage().contains("not compatible")
        assertTrue(e.getMessage().contains("banana"));  
            Settings.builder()
            IllegalArgumentException.class,
        Settings.Builder builder = Settings.builder()
                .putList("index.parquet.bloom_filter_enabled.value", "true")
            )
        refreshIndex(INDEX_NAME);
import org.opensearch.be.datafusion.DataFusionPlugin;  
        String compression = colJson.substring(compStart, compEnd);
                .putList("index.parquet.encoding.field", "value")  
                if (compatible) {  
                // All combos valid — must not throw  
                    client().admin().cluster().prepareUpdateSettings().setTransientSettings(nodeSettings).get();
    private void assertHasEncoding(Map<String, Object> colMeta, String expectedEncoding) {
     * Loops over every (arrow_type, compression) pair for type-level settings.  
                .putList("index.parquet.encoding.value", "DELTA_BINARY_PACKED")
            )  
                .build()
                .putList("index.parquet.compression.field", "value")
import java.util.Map;  
                }  
        int compEnd = colJson.indexOf('"', compStart);  
                    .putList("index.parquet.encoding.field", "value")  
        ensureGreen(INDEX_NAME);
                Settings.builder().put("parquet.type_compression.foobar.compression", "SNAPPY").build()
    /**  
        refreshIndex(INDEX_NAME);
        refreshIndex(INDEX_NAME);
        refreshIndex(INDEX_NAME);
                Settings nodeSettings = Settings.builder().put("parquet.type_encoding." + arrowType + ".encoding", encoding).build();
    }  
                    .put("parquet.type_compression." + arrowType + ".compression", compression)
        assertTrue(e.getMessage().contains("Invalid encoding"));
        assertEquals(Boolean.FALSE, valueMeta.get("bloom_filter"));
                Settings.builder()
        ensureGreen(INDEX_NAME);
        }
                    .putList("index.parquet.encoding.value", "INVALID_ENCODING")
        );
                .build()  
            "Expected compression starting with '" + expectedPrefix + "', got: " + compression,
import java.nio.file.Files;
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(nodeSettings).get();  
        Map<String, Object> nameMeta = getColumnInfo(INDEX_NAME, "name");
                    .putList("index.parquet.compression.field", field)
                .put("index.parquet.compression_type", "LZ4_RAW")  
                    .putList("index.parquet.encoding.value", "DELTA_BINARY_PACKED")
        Map<String, Object> colMeta = getColumnInfo(INDEX_NAME, "value");  
    }
        Map<String, Object> valueMeta = getColumnInfo(INDEX_NAME, "value");
     */
            if (wfs != null) {  
        ensureGreen(INDEX_NAME);
        assertCompression(nameMeta, "SNAPPY");  
            )
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertHasEncoding(nameMeta, "DELTA_BYTE_ARRAY");
    private void assertCompression(Map<String, Object> colMeta, String expectedPrefix) {
                    .build()
    public void testFieldLevelCompressionApplied() throws IOException {
    }
                .build()
