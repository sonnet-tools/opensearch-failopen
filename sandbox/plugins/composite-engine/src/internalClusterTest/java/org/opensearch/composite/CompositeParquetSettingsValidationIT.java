    /**
        );
            )
    // --- Helpers ---
            Settings.builder()
                for (String file : wfs.files()) {
    private String getFirstFileColumnMetadata(String indexName) throws IOException {
        return Arrays.asList(
    public void testIncompatibleEncodingForFieldTypeRejected() {
        Map<String, Object> nameMeta = getColumnInfo(INDEX_NAME, "name");
                .putList("index.parquet.encoding.value", "DELTA_BYTE_ARRAY")
    }
    }
                    assertTrue(
import java.util.Map;
    public void testFieldLevelEncodingApplied() throws IOException {
    // --- Encoding/compression exhaustive combination tests ---
        );
import org.opensearch.cluster.metadata.IndexMetadata;
                .putList("index.parquet.compression.field", "name", "value")
            IllegalArgumentException.class,
        }
                    Path filePath = parquetDir.resolve(file);
            Settings.builder()
        );
                    .putList("index.parquet.encoding.value", "DELTA_BINARY_PACKED")
            .setSettings(builder)
     * when no field-level or type-level config is set.
        for (String arrowType : ParquetSettings.VALID_ARROW_TYPES) {
                .build()
    public void testInvalidFieldEncodingRejected() {
    public void testFieldLevelCompressionAllCombinations() {
package org.opensearch.composite;
        int start = json.indexOf(key);
        assertEquals(Boolean.FALSE, valueMeta.get("bloom_filter"));
        String colJson = json.substring(braceStart, braceEnd + 1);
                .build()
                        IllegalArgumentException.class,
                // All combos valid — must not throw
            Settings.builder()
    }
 */
                .putList("index.parquet.compression.field", "value")
        );
import java.io.IOException;
                .put("index.parquet.compression_type", "LZ4_RAW")
     * Verifies multiple field-level settings can coexist on different columns.
        refreshIndex(INDEX_NAME);
 * this file be licensed under the Apache-2.0 license or a
    public void testTypeLevelCompressionAllCombinations() {
        refreshIndex(INDEX_NAME);
    public void testCompatibleEncodingForFieldTypeAccepted() {
                .putList("index.parquet.encoding.field", "value")
        createCompositeIndexWithSettings(
                // All combos valid — must not throw
    // --- Type-level encoding validation ---
    }
    public void testValidTypeEncodingAccepted() {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertTrue(e.getMessage().contains("foobar"));
        Map<String, Object> valueMeta = getColumnInfo(INDEX_NAME, "value");
                }
                    .put("parquet.type_compression." + arrowType + ".compression", compression)
            }
                    .putList("index.parquet.encoding.field", field)
    // --- 3-tier precedence tests (field > type > global) ---
        assertEquals(Boolean.FALSE, valueMeta.get("bloom_filter"));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    .build()
                createCompositeIndexWithSettings(indexSettings);
        createCompositeIndexWithSettings(
                    );
/*
        int compStart = colJson.indexOf(compKey) + compKey.length();
                }
        assertCompression(colMeta, "ZSTD");
        int braceStart = json.indexOf('{', start + key.length() - 1);
        for (String arrowType : ParquetSettings.VALID_ARROW_TYPES) {
        ensureGreen(INDEX_NAME);
            .indices()
        String compression = (String) colMeta.get("compression");
                    IllegalArgumentException e = expectThrows(
            .setMapping("name", "type=keyword,index=false", "value", "type=integer")
            IllegalArgumentException.class,
        ensureGreen(INDEX_NAME);
    /**
    public void testIncompatibleTypeLevelEncodingRejected() {
        IllegalArgumentException e = expectThrows(
    public void testValidFieldEncodingAccepted() {
    public void testTypeLevelEncodingAllCombinations() {
        ensureGreen(INDEX_NAME);
    }
    }
        assertCompression(nameMeta, "SNAPPY");
        indexDocs(INDEX_NAME, 5, 0);
                .build()
    }
        );
        );
    // --- Encoding-type compatibility validation ---
                .putList("index.parquet.encoding.field", "value")
            () -> createCompositeIndexWithSettings(
            ParquetSettings.ARROW_TYPE_NAME_TO_INSTANCE.get("int32")
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
        ensureGreen(INDEX_NAME);
                Settings.builder()
        int bfStart = colJson.indexOf(bfKey);
                Settings indexSettings = Settings.builder()
                Settings indexSettings = Settings.builder()
        String bfKey = "\"bloom_filter\":";
                        IllegalArgumentException.class,
                    );
     * Valid combos must be accepted; incompatible combos must throw IllegalArgumentException.
        // DELTA_BINARY_PACKED is only valid for integer types, not utf8
        indexDocs(INDEX_NAME, 5, 0);
    }
        // Parse encodings list
    private void assertHasEncoding(Map<String, Object> colMeta, String expectedEncoding) {
        String encodingsStr = colJson.substring(encStart + 1, encEnd);
     */
                Settings.builder().put("parquet.type_encoding.utf8.encoding", "DELTA_BINARY_PACKED").build()
     */
        flushIndex(INDEX_NAME);
            .indices()
            .prepareCreate(INDEX_NAME)
    /**
        int encEnd = colJson.indexOf(']');
            String bfVal = colJson.substring(bfStart + bfKey.length()).split("[,}]")[0].trim();
        Map<String, Object> nameMeta = getColumnInfo(INDEX_NAME, "name");
                .putList("index.parquet.bloom_filter_enabled.value", "true")
        assertHasEncoding(nameMeta, "DELTA_BYTE_ARRAY");
     */
        createCompositeIndexWithSettings(
        refreshIndex(INDEX_NAME);
            hasBloomFilter = "true".equals(bfVal);
        Map<String, Object> valueMeta = getColumnInfo(INDEX_NAME, "value");
                    .putList("index.parquet.encoding.field", "name")
            ParquetSettings.ARROW_TYPE_NAME_TO_INSTANCE.get("utf8"),
        assertTrue(e.getMessage().contains("not compatible") || e.getMessage().contains("not supported"));
    }
import java.util.ArrayList;
     * All compressions are valid for all field types — every combo must be accepted.
        assertTrue(e.getMessage().contains("banana"));
 *
        client().admin()
                    .build();
        assertEquals(Boolean.FALSE, nameMeta.get("bloom_filter"));
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
                .putList("index.parquet.encoding.field", "name")
        ensureGreen(INDEX_NAME);
    }
     * Verifies field-level encoding with global compression.
        createCompositeIndexWithSettings(Settings.builder().put("index.parquet.compression_type", "SNAPPY").build());
                } else {
    @SuppressWarnings("unchecked")
            for (String encoding : ParquetSettings.VALID_ENCODINGS) {
                }
            .put("index.pluggable.dataformat", "composite")
 * compatible open source license.
    public void testInvalidCompressionValueInTypeCompressionRejected() {
        Map<String, Object> valueMeta = getColumnInfo(INDEX_NAME, "value");
        createCompositeIndexWithSettings(
        createCompositeIndexWithNodeSettings(Settings.builder().put("parquet.type_compression.utf8.compression", "ZSTD").build());
        flushIndex(INDEX_NAME);
            }
    public void testGlobalBloomFilterEnabled() throws IOException {
     */
        Map<String, Object> valueMeta = getColumnInfo(INDEX_NAME, "value");
            .put(extraSettings);
                        () -> client().admin().cluster().prepareUpdateSettings().setTransientSettings(nodeSettings).get()
                Settings.builder()
        int compEnd = colJson.indexOf('"', compStart);
        return null;
            () -> createCompositeIndexWithNodeSettings(
        client().admin()
        // Extract the JSON object for the specific column
     */
    }
import org.opensearch.be.datafusion.DataFusionPlugin;
        assertEquals(Boolean.TRUE, nameMeta.get("bloom_filter"));
        );
    // --- Field-level encoding validation ---
    private Map<String, Object> getColumnInfo(String indexName, String columnName) throws IOException {
        );
import org.opensearch.index.engine.exec.Segment;
        Map<String, Object> result = new HashMap<>();
     * Loops over every (field, compression) pair for field-level settings.
            () -> createCompositeIndexWithNodeSettings(
            .setSettings(builder)
    /**
            CompositeDataFormatPlugin.class,
                    .putList("index.parquet.encoding.value", encoding)
                if (compatible) {
            .put("index.composite.primary_data_format", "parquet")
        );
        flushIndex(INDEX_NAME);
        return result;
        assertTrue(e.getMessage().contains("Invalid encoding"));
                    }
    public void testMultipleFieldLevelSettings() throws IOException {
                    .build()
        IllegalArgumentException e = expectThrows(
                        return RustBridge.getColumnMetadata(filePath.toString());
        createCompositeIndexWithSettings(
    }
        createCompositeIndexWithSettings(Settings.builder().build());
            )
                client().admin().indices().prepareDelete(INDEX_NAME).get();
        for (String field : List.of("name", "value")) {
            IllegalArgumentException.class,
    /**
                    .build()
                    createCompositeIndexWithSettings(indexSettings);
                .putList("index.parquet.bloom_filter_enabled.field", "name")
                boolean compatible = ParquetSettings.isEncodingValidForArrowType(encoding, arrowType);
import org.opensearch.plugins.Plugin;
        assertCompression(valueMeta, "ZSTD");
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(nodeSettings).get();
    public void testInvalidEncodingValueInTypeEncodingRejected() {
        IllegalArgumentException e = expectThrows(
     */
            Settings.builder()
        assertTrue(e.getMessage().contains("not compatible") || e.getMessage().contains("not supported"));
                .putList("index.parquet.compression.value", "SNAPPY", "ZSTD")
        for (Map.Entry<String, ArrowType> fieldEntry : fieldToArrowType.entrySet()) {
import java.util.Arrays;
            Settings.builder()
    }
    }
        Map<String, Object> nameMeta = getColumnInfo(INDEX_NAME, "name");
     * Verifies that field-level compression is applied and visible in parquet metadata.
        // DELTA_BINARY_PACKED is only valid for integer types, not keyword (utf8)
            () -> createCompositeIndexWithSettings(
            Settings.builder()
            Settings.builder()
    // --- Case insensitivity ---
            DataFusionPlugin.class
        ensureGreen(INDEX_NAME);
    }
        if (bfStart != -1) {
            .get();
import java.util.Collection;
        ensureGreen(INDEX_NAME);
        indexDocs(INDEX_NAME, 5, 0);
        flushIndex(INDEX_NAME);
    public void testInvalidArrowTypeInTypeCompressionRejected() {
     * All compressions are valid for all types — every combo must be accepted.
        for (String enc : encodingsStr.split(",")) {
        result.put("compression", compression);
        createCompositeIndexWithSettings(
    // --- Bloom filter tests ---
            () -> createCompositeIndexWithSettings(
        indexDocs(INDEX_NAME, 5, 0);
    private static final String INDEX_NAME = "test-settings-validation";
        assertHasEncoding(colMeta, "DELTA_BYTE_ARRAY");
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        result.put("encodings", encodings);
                .putList("index.parquet.compression.value", "SNAPPY")
                .putList("index.parquet.compression.field", "value")
            LucenePlugin.class,
                .putList("index.parquet.encoding.value", "DELTA_BINARY_PACKED")
    public void testValidFieldCompressionAccepted() {
                    assertTrue(
                        "Expected incompatibility error for field=" + field + " encoding=" + encoding + ", got: " + e.getMessage(),
    }
    }
            Settings.builder()
    }
                .build()
        createCompositeIndexWithSettings(
     */
    public void testEncodingCaseInsensitive() {
            "name",
                .putList("index.parquet.compression.value", "ZSTD")
        createCompositeIndexWithSettings(
                        "Expected incompatibility error for type=" + arrowType + " encoding=" + encoding + ", got: " + e.getMessage(),
import java.nio.file.Path;
                .putList("index.parquet.encoding.value", "DELTA_BYTE_ARRAY")
    @SuppressWarnings("unchecked")
        assertTrue(
        refreshIndex(INDEX_NAME);
        }
            Settings.builder()
        ensureGreen(INDEX_NAME);
        int encStart = colJson.indexOf('[');
        result.put("bloom_filter", hasBloomFilter);
        );
        assertCompression(valueMeta, "ZSTD");
        IllegalArgumentException e = expectThrows(
        );
            for (String compression : ParquetSettings.VALID_COMPRESSIONS) {
        fail("No parquet file found for index: " + indexName);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        String key = "\"" + columnName + "\":{";
        flushIndex(INDEX_NAME);
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        Map<String, Object> nameMeta = getColumnInfo(INDEX_NAME, "name");
        Settings.Builder builder = Settings.builder()
            Settings.builder()
        indexDocs(INDEX_NAME, 5, 0);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        Settings.Builder builder = Settings.builder()
            Settings.builder()
    public void testFieldLevelEncodingWithGlobalCompression() throws IOException {
    }
        assertCompression(nameMeta, "ZSTD");
            encodings.add(enc.trim().replace("\"", ""));
        refreshIndex(INDEX_NAME);
        refreshIndex(INDEX_NAME);
                    // Should be accepted — no exception
            "Expected compression starting with '" + expectedPrefix + "', got: " + compression,
            ArrowType arrowType = fieldEntry.getValue();
            .get();
    }
        assertTrue(e.getMessage().contains("Invalid arrow type"));
        );
        );
    }
     */
        assertEquals(Boolean.TRUE, nameMeta.get("bloom_filter"));
public class CompositeParquetSettingsValidationIT extends AbstractCompositeEngineIT {
                .putList("index.parquet.compression.field", "value")
                    .putList("index.parquet.encoding.value", "INVALID_ENCODING")
import org.opensearch.parquet.bridge.RustBridge;
/**
        ensureGreen(INDEX_NAME);
        Map<String, Object> nameMeta = getColumnInfo(INDEX_NAME, "name");
    /**
    private void createCompositeIndexWithSettings(Settings extraSettings) {
                .putList("index.parquet.encoding.field", "value")
        String json = getFirstFileColumnMetadata(indexName);
import org.opensearch.test.OpenSearchIntegTestCase;
 * The OpenSearch Contributors require contributions made to
        IllegalArgumentException e = expectThrows(
    }
        Map<String, Object> colMeta = getColumnInfo(INDEX_NAME, "name");
                Settings.builder().put("parquet.type_compression.foobar.compression", "SNAPPY").build()
    }
        }
        indexDocs(INDEX_NAME, 5, 0);
                    .putList("index.parquet.encoding.field", "value")
            }
    }
import java.nio.file.Files;
     * Verifies that bloom filters are disabled by default for all columns.
        );
    /**
        );
                .putList("index.parquet.encoding.value", "delta_binary_packed")
        ensureGreen(INDEX_NAME);
                Settings.builder().put("parquet.type_compression.utf8.compression", "INVALID").build()
 * and type-level encoding/compression validations are enforced at index creation time.
            IllegalArgumentException.class,
    }
    public void testValidTypeCompressionAccepted() {
        Path parquetDir = getPrimaryShard(indexName).shardPath().getDataPath().resolve("parquet");
                Settings.builder()
        String compKey = "\"compression\":\"";
            () -> createCompositeIndexWithNodeSettings(Settings.builder().put("parquet.type_encoding.banana.encoding", "PLAIN").build())
        refreshIndex(INDEX_NAME);
                    client().admin().indices().prepareDelete(INDEX_NAME).get();
    public void testFieldLevelEncodingAllCombinations() {
    @Override
        );
            ParquetOnlyDataFormatPlugin.class,
                .build()
    }
        Map<String, Object> colMeta = getColumnInfo(INDEX_NAME, "value");
            "value",
        ensureGreen(INDEX_NAME);
                .putList("index.parquet.encoding.field", "name")
        IllegalArgumentException e = expectThrows(
    // --- Field-level compression validation ---
        assertEquals(Boolean.TRUE, valueMeta.get("bloom_filter"));
                ArrowType arrowTypeInstance = ParquetSettings.ARROW_TYPE_NAME_TO_INSTANCE.get(arrowType);
    public void testFieldLevelCompressionApplied() throws IOException {
            .put("index.pluggable.dataformat.enabled", true)
import org.opensearch.be.lucene.LucenePlugin;
        createCompositeIndexWithSettings(
                .build()
        assertCompression(colMeta, "SNAPPY");
                Settings nodeSettings = Settings.builder().put("parquet.type_encoding." + arrowType + ".encoding", encoding).build();
            }
                    .putList("index.parquet.compression.field", field)
        Map<String, Object> nameMeta = getColumnInfo(INDEX_NAME, "name");
        indexDocs(INDEX_NAME, 5, 0);
        flushIndex(INDEX_NAME);
        );
        assertHasEncoding(nameMeta, "DELTA_BYTE_ARRAY");
        );
        );
            IllegalArgumentException.class,
                Settings nodeSettings = Settings.builder()
    /**
        ensureGreen(INDEX_NAME);
        // Other columns should still have no bloom filter (global default is disabled)
        flushIndex(INDEX_NAME);
            .put("index.pluggable.dataformat", "composite")
                } else {
     */
     * Valid combos must be accepted at index creation; incompatible combos must throw IllegalArgumentException.
        ensureGreen(INDEX_NAME);
                .putList("index.parquet.encoding.value", "DELTA_BINARY_PACKED")
                    if (Files.exists(filePath)) {
        List<String> encodings = (List<String>) colMeta.get("encodings");
        assertTrue("Expected encoding '" + expectedEncoding + "' in " + encodings, encodings.contains(expectedEncoding));
        assertHasEncoding(valueMeta, "DELTA_BINARY_PACKED");
import org.opensearch.composite.framework.ParquetOnlyDataFormatPlugin;
                if (compatible) {
        assertTrue(e.getMessage().contains("Invalid compression"));
        IllegalArgumentException e = expectThrows(
    public void testFieldLevelCompressionOverridesGlobal() throws IOException {
        );
                .putList("index.parquet.encoding.value", "DELTA_BYTE_ARRAY", "DELTA_BINARY_PACKED")
     * Verifies that field-level encoding is applied and visible in parquet metadata.
        // Parse compression
        assertCompression(nameMeta, "ZSTD");
                .build()
    }
     * Verifies that field-level bloom_filter_enabled=true enables bloom filter for that column only.
            if (wfs != null) {
    /**
import org.opensearch.parquet.ParquetSettings;
        }
        createCompositeIndexWithSettings(
            ArrowBasePlugin.class,
    }
    }
                    .putList("index.parquet.compression.value", "INVALID_COMPRESSION")
            () -> createCompositeIndexWithNodeSettings(Settings.builder().put("parquet.type_encoding.int64.encoding", "INVALID").build())
            )
                .build()
            .put("index.pluggable.dataformat.enabled", true)
     * Loops over every (field, encoding) pair for field-level settings.
        indexDocs(INDEX_NAME, 5, 0);
        Map<String, ArrowType> fieldToArrowType = Map.of(
    private void assertCompression(Map<String, Object> colMeta, String expectedPrefix) {
     * Verifies that global compression (index.parquet.compression_type) is applied
    }
                .build()
        refreshIndex(INDEX_NAME);
        String compression = colJson.substring(compStart, compEnd);
            .putList("index.composite.secondary_data_formats")
        IllegalArgumentException e = expectThrows(
        assertTrue(e.getMessage().contains("Invalid arrow type"));
     * Loops over every (arrow_type, encoding) pair for type-level settings.
    }
    }
    public void testInvalidFieldCompressionRejected() {
                    .build();
                client().admin().cluster().prepareUpdateSettings().setTransientSettings(nodeSettings).get();
    // --- Type-level compression validation ---
            IllegalArgumentException.class,
        createCompositeIndexWithSettings(Settings.builder().put("index.parquet.bloom_filter_enabled", "true").build());
        Map<String, Object> valueMeta = getColumnInfo(INDEX_NAME, "value");
    public void testFieldLevelBloomFilterEnabled() throws IOException {
    /**
        }
 */
            .prepareCreate(INDEX_NAME)
    }
    /**
                        e.getMessage().contains("not compatible")
                    .putList("index.parquet.compression.value", compression)
                .putList("index.parquet.encoding.field", "name", "value")
    public void testCompressionCaseInsensitive() {
            .put("index.composite.primary_data_format", "parquet")
            )
        createCompositeIndexWithSettings(
        ensureGreen(INDEX_NAME);
     * Verifies field-level compression overrides global compression for a specific column.
        createCompositeIndexWithNodeSettings(Settings.builder().put("parquet.type_encoding.int64.encoding", "DELTA_BINARY_PACKED").build());
        assertFalse("Column '" + columnName + "' not found in metadata: " + json, start == -1);
            () -> createCompositeIndexWithNodeSettings(
            )
                        () -> createCompositeIndexWithSettings(indexSettings)
    public void testBloomFilterDisabledByDefault() throws IOException {
            .putList("index.composite.secondary_data_formats");
            String field = fieldEntry.getKey();
                .putList("index.parquet.compression.value", "ZSTD")
                    client().admin().cluster().prepareUpdateSettings().setTransientSettings(nodeSettings).get();
 * SPDX-License-Identifier: Apache-2.0
     * Verifies that global bloom_filter_enabled=true enables bloom filters for all columns.
            .setMapping("name", "type=keyword,index=false", "value", "type=integer")
    /**
                    );
        ensureGreen(INDEX_NAME);
        for (Segment segment : snapshot.getSegments()) {
        Map<String, Object> colMeta = getColumnInfo(INDEX_NAME, "value");
        assertTrue(e.getMessage().contains("Invalid encoding"));
        // Parse bloom_filter
                    .build();
            compression.startsWith(expectedPrefix)
                    .putList("index.parquet.compression.field", "value")
        refreshIndex(INDEX_NAME);
        assertTrue(e.getMessage().contains("Invalid compression"));
        }
        int braceEnd = json.indexOf('}', braceStart);
            }
    /**
        List<String> encodings = new ArrayList<>();
                .build()
                boolean compatible = arrowTypeInstance == null || ParquetSettings.isEncodingValidForArrowType(encoding, arrowTypeInstance);
import java.util.List;
        }
import org.opensearch.common.settings.Settings;
            IllegalArgumentException.class,
        flushIndex(INDEX_NAME);
     */
     * Loops over every (arrow_type, compression) pair for type-level settings.
        CatalogSnapshot snapshot = acquireAndGetSnapshot(indexName);
     * Uses keyword (utf8) and integer (int32) fields to cover string and numeric types.
            for (String compression : ParquetSettings.VALID_COMPRESSIONS) {
 * Integration tests verifying that Parquet field-level encoding/compression
     */
            IllegalArgumentException.class,
            )
        boolean hasBloomFilter = false;
    }
                .put("index.parquet.compression_type", "SNAPPY")
        );
    private void createCompositeIndexWithNodeSettings(Settings nodeSettings) {
import java.util.HashMap;
            for (String encoding : ParquetSettings.VALID_ENCODINGS) {
}
     */
import org.apache.arrow.vector.types.pojo.ArrowType;
                    );
        // field -> arrow type instance for compatibility check
import org.opensearch.index.engine.exec.WriterFileSet;
        indexDocs(INDEX_NAME, 5, 0);
                .putList("index.parquet.compression.field", "value")
import org.opensearch.arrow.allocator.ArrowBasePlugin;
    public void testInvalidArrowTypeInTypeEncodingRejected() {
                        e.getMessage().contains("not compatible") || e.getMessage().contains("not supported")
    }
                .putList("index.parquet.compression.value", "snappy")
    public void testGlobalCompressionApplied() throws IOException {
                .build()
        );
                    IllegalArgumentException e = expectThrows(
     */
        // DELTA_BINARY_PACKED is valid for integer types
        flushIndex(INDEX_NAME);
