    /**
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        String bfKey = "\"bloom_filter\":";
                .putList("index.parquet.compression.value", "SNAPPY", "ZSTD", "GZIP", "BROTLI", "LZ4_RAW", "SNAPPY", "ZSTD", "GZIP")
                .put("parquet.type_compression.float64.compression", "LZ4_RAW")
            compStart += compKey.length();
        // Type-level sets SNAPPY for utf8
                    "col_utf8",
        assertEquals(Boolean.TRUE, getColumnInfo(INDEX_NAME, "value").get("bloom_filter"));
        createIndex(Settings.EMPTY);
    private Map<String, Object> getColumnInfo(String indexName, String columnName) throws IOException {
                    "col_int64",
 * compatible open source license.
        return Arrays.asList(
     * Type-level encoding set for all arrow types simultaneously.
 * Uses numDataNodes=0 so nodes can be started with static type-level node settings.
            String bfVal = colJson.substring(bfStart + bfKey.length()).split("[,}]")[0].trim();
    }
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
    }
        Path parquetDir = getPrimaryShard(indexName).shardPath().getDataPath().resolve("parquet");
        String compression = (String) colMeta.get("compression");
        // Type-level sets SNAPPY for utf8
        List<String> encodings = (List<String>) colMeta.get("encodings");
                    "col_float32",
            .build();
    /**
    }
     * Type-level encoding for utf8 applies to keyword columns.
        assertCompression(getColumnInfo(INDEX_NAME, "col_float64"), "LZ4_RAW");
        // "name" (utf8) uses ZSTD as the default for utf8/binary types
                    "col_float64",
        assertCompression(getColumnInfo(INDEX_NAME, "col_utf8"), "SNAPPY");
                    "col_float64",
        startCluster(Settings.EMPTY);
     */
import java.util.Map;
     * Field-level bloom_filter_enabled=false overrides type-level enabled=true.
    }
    @SuppressWarnings("unchecked")
import org.opensearch.parquet.bridge.RustBridge;
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
                .putList("index.parquet.bloom_filter_enabled.field", "name")
                .build()
                .build()
        for (int i = 0; i < 5; i++) {
     */
            .putList("index.composite.secondary_data_formats", "lucene")
        indexAndFlush();
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_int64"), "DELTA_BINARY_PACKED");
        indexAndFlush();
     * Full 3-tier compression: field > type > global.
        assertCompression(getColumnInfo(INDEX_NAME, "col_int64"), "GZIP");
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_int32"), "DELTA_BINARY_PACKED");
        String json = getFirstFileColumnMetadata(indexName);
                    "BYTE_STREAM_SPLIT",
            .get();
        client().admin()
                .put("parquet.type_compression.binary.compression", "ZSTD")
import java.util.Collection;
                    "index.parquet.compression.field",
import java.nio.file.Files;
                    "index.parquet.encoding.value",
    private void assertHasEncoding(Map<String, Object> colMeta, String expectedEncoding) {
            .put("index.composite.primary_data_format", "parquet")
        }
                .putList(
        String key = "\"" + columnName + "\":{";
                "type=boolean,index=false",
                "col_int32",
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_binary"), "DELTA_BYTE_ARRAY");
                    "2024-01-0" + (i + 1)
    /**
     */
                "col_float32",
import org.opensearch.test.OpenSearchIntegTestCase;
                "type=long",
    }
                "type=integer",
    // --- Helpers ---
    public void testTypeLevelCompressionOverridesGlobal() throws IOException {
                    "col_timestamp",
        startCluster(
                    }
                "type=keyword,index=false",
                .setSource(
     * Verifies each column in the parquet file has the expected encoding.
                .build()
                    "col_float32",
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_float32"), "BYTE_STREAM_SPLIT");
            .putList("index.composite.secondary_data_formats", "lucene")
        );
                .putList("index.parquet.bloom_filter_enabled.value", "true")
                    "col_int64",
        );
 * Integration tests verifying 3-tier settings priority: field-level > type-level > global.
            Settings.builder()
import java.nio.file.Path;
    public void testFullThreeTierCompression() throws IOException {
    public void testTypeLevelEncodingForUtf8() throws IOException {
    // --- All-type encoding/compression exhaustive tests ---
            )
    }
            .put(extraIndexSettings);
            .put("index.pluggable.dataformat", "composite")
    }
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_utf8"), "DELTA_BYTE_ARRAY");
    private String getFirstFileColumnMetadata(String indexName) throws IOException {
     */
import org.opensearch.index.engine.exec.WriterFileSet;
                .put("parquet.type_encoding.binary.encoding", "DELTA_BYTE_ARRAY")
        ensureGreen(INDEX_NAME);
                    "col_timestamp"
        // Field-level sets ZSTD for "name"
    private void createAllTypeIndex(Settings extraIndexSettings) {
                    "RLE",
    // --- Compression 3-tier tests ---
    /**
        String colJson = json.substring(braceStart, braceEnd + 1);
import java.util.List;
    public void testFullThreeTierBloomFilter() throws IOException {
        List<String> encodings = (List<String>) colMeta.get("encodings");
                    "col_boolean",
    /**
        assertCompression(getColumnInfo(INDEX_NAME, "col_float64"), "LZ4_RAW");
        startCluster(Settings.builder().put("parquet.type_compression.utf8.compression", "SNAPPY").build());
        int braceEnd = json.indexOf('}', braceStart);
                    "col_float32",
                .build()
        int encStart = colJson.indexOf('[');
    public void testTypeLevelEncodingAllValidCombinations() throws IOException {
            hasBloomFilter = "true".equals(bfVal);
        indexAndFlush();
        indexAndFlush();
    }
                    "PLAIN"
        startCluster(Settings.builder().put("parquet.type_encoding.utf8.encoding", "DELTA_BYTE_ARRAY").build());
import java.io.IOException;
        startCluster(Settings.EMPTY);
        createIndex(Settings.EMPTY);
        createIndex(Settings.EMPTY);
        assertEquals(Boolean.TRUE, getColumnInfo(INDEX_NAME, "name").get("bloom_filter"));
        // Global is LZ4_RAW (default)
    }
    /**
     */
    public void testFieldLevelCompressionOverridesTypeLevel() throws IOException {
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_float64"), "BYTE_STREAM_SPLIT");
}
     * Type-level compression set for all arrow types simultaneously.
        flushIndex(INDEX_NAME);
    }
    /**
                .putList("index.parquet.bloom_filter_enabled.value", "true")
    }
                    "BYTE_STREAM_SPLIT",
                .put("parquet.type_encoding.int32.encoding", "DELTA_BINARY_PACKED")
        assertCompression(getColumnInfo(INDEX_NAME, "col_int64"), "GZIP");
        assertCompression(getColumnInfo(INDEX_NAME, "name"), "ZSTD");
                "col_binary",
     */
            .put("index.pluggable.dataformat", "composite")
        startCluster(Settings.builder().put("parquet.type_bloom_filter.utf8.enabled", "true").build());
        startCluster(Settings.EMPTY);
                    "col_boolean",
                "type=date"
        assertCompression(getColumnInfo(INDEX_NAME, "name"), "ZSTD");
        assertEquals(Boolean.TRUE, getColumnInfo(INDEX_NAME, "name").get("bloom_filter"));
    }
    }
            .put("index.composite.primary_data_format", "parquet")
    /**
     * Type-level bloom filter enabled for utf8 enables bloom on keyword columns only.
    }
                    i,
                .put("parquet.type_encoding.int64.encoding", "DELTA_BINARY_PACKED")
    private void assertCompression(Map<String, Object> colMeta, String expectedPrefix) {
        createIndex(Settings.EMPTY);
        result.put("bloom_filter", hasBloomFilter);
     */
        startCluster(Settings.builder().put("parquet.type_bloom_filter.utf8.enabled", "true").build());
            "Expected compression starting with '" + expectedPrefix + "', got: " + compression,
        CatalogSnapshot snapshot = acquireAndGetSnapshot(indexName);
                .putList(
        assertCompression(getColumnInfo(INDEX_NAME, "name"), "ZSTD");
        if (bfStart != -1) {
        );
            .put(extraNodeSettings)
        assertCompression(getColumnInfo(INDEX_NAME, "value"), "ZSTD");
    private void indexAndFlush() {
        createIndex(
    public void testFieldLevelEncodingAllValidCombinations() throws IOException {
                    "col_utf8",
            Settings.builder().putList("index.parquet.encoding.field", "value").putList("index.parquet.encoding.value", "PLAIN").build()
import org.opensearch.be.datafusion.DataFusionPlugin;
        assertEquals(Boolean.FALSE, getColumnInfo(INDEX_NAME, "name").get("bloom_filter"));
                    (double) i,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .put("parquet.type_encoding.float64.encoding", "BYTE_STREAM_SPLIT")
        int start = json.indexOf(key);
        client().admin()
        Map<String, Object> result = new HashMap<>();
                )
                .put("parquet.type_encoding.timestamp.encoding", "PLAIN")
                .putList("index.parquet.bloom_filter_enabled.field", "name")
        );
                    "col_float64",
    /**
                "type=double",
                    if (Files.exists(filePath)) {
        }
        indexAllTypeDocs();
            Settings.builder()
        // Parse encodings list
                    "DELTA_BYTE_ARRAY",
        startCluster(Settings.builder().put("parquet.type_bloom_filter.int32.enabled", "true").build());
                .put("parquet.type_encoding.boolean.encoding", "RLE")
                .build()
     */
    /**
        createAllTypeIndex(Settings.EMPTY);
        if (compStart != -1) {
        );
    }
        indexAndFlush();
            .setSettings(builder)
    public void testTypeLevelEncodingApplied() throws IOException {
        assertCompression(getColumnInfo(INDEX_NAME, "name"), "SNAPPY");
    }
            Settings.builder()
        createAllTypeIndex(
        assertCompression(getColumnInfo(INDEX_NAME, "col_boolean"), "SNAPPY");
                    "col_boolean",
        Settings nodeSettings = Settings.builder()
    public void testTypeLevelBloomFilterEnabled() throws IOException {
                "col_utf8",
        assertFalse("Column '" + columnName + "' not found in metadata: " + json, start == -1);
                )
     * Type-level compression overrides global compression.
        );
                    "index.parquet.encoding.field",
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
        assertFalse("Did not expect encoding '" + encoding + "' in " + encodings, encodings.contains(encoding));
            .indices()
        assertCompression(getColumnInfo(INDEX_NAME, "col_int32"), "ZSTD");
    public void testFieldLevelBloomFilterOverridesTypeLevel() throws IOException {
        indexAllTypeDocs();
                .putList("index.parquet.bloom_filter_enabled.value", "false")
            Settings.builder().putList("index.parquet.compression.field", "name").putList("index.parquet.compression.value", "ZSTD").build()
            ParquetDataFormatPlugin.class,
        startCluster(Settings.builder().put("parquet.type_encoding.int32.encoding", "DELTA_BINARY_PACKED").build());
            String encodingsStr = colJson.substring(encStart + 1, encEnd);
    public void testFieldLevelEncodingOverridesTypeLevel() throws IOException {
                )
        startCluster(Settings.builder().put("parquet.type_bloom_filter.utf8.enabled", "false").build());
            if (wfs != null) {
            Settings.builder()
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_timestamp"), "PLAIN");
                "col_boolean",
                .put("parquet.type_compression.boolean.compression", "SNAPPY")
                .build()
     * Type-level enabled=true overrides global disabled (default) for int32.
        }
        indexAllTypeDocs();
            result.put("encodings", encodings);
                    "col_binary",
        assertCompression(getColumnInfo(INDEX_NAME, "col_boolean"), "SNAPPY");
import java.util.HashMap;
import org.opensearch.common.util.FeatureFlags;
        indexAndFlush();
                .setIndex(INDEX_NAME)
        indexAndFlush();
            compression.startsWith(expectedPrefix)
        indexAndFlush();
    public void testTypeLevelCompressionApplied() throws IOException {
        ensureGreen(INDEX_NAME);
        createAllTypeIndex(Settings.EMPTY);
    }
                "type=float",
     * Field-level encoding overrides type-level encoding.
import org.opensearch.plugins.Plugin;
        assertCompression(getColumnInfo(INDEX_NAME, "col_binary"), "ZSTD");
        assertEquals(Boolean.FALSE, getColumnInfo(INDEX_NAME, "name").get("bloom_filter"));
        // Field-level overrides with ZSTD for "name", global is LZ4_RAW
        Settings.Builder builder = Settings.builder()
        String compKey = "\"compression\":\"";
    // --- Encoding 3-tier tests ---
     * Verifies each column has the expected compression in the parquet file.
import org.opensearch.be.lucene.LucenePlugin;
     * Field-level encoding set per column for all types simultaneously.
            Settings.builder()
     * Verifies each column has the expected compression in the parquet file.
import org.opensearch.parquet.ParquetDataFormatPlugin;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    /**
                    "col_int64",
     */
            .setMapping(
import java.util.Arrays;
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_boolean"), "RLE");
import org.opensearch.index.engine.exec.Segment;
                "col_float64",
        assertCompression(getColumnInfo(INDEX_NAME, "col_timestamp"), "GZIP");
/**
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        assertCompression(getColumnInfo(INDEX_NAME, "col_float32"), "BROTLI");
                .put("parquet.type_compression.int32.compression", "ZSTD")
        if (encStart != -1 && encEnd != -1) {
                    (float) i,
     */
                    i % 2 == 0,
        createIndex(
 * SPDX-License-Identifier: Apache-2.0
    @SuppressWarnings("unchecked")
    }
            DataFusionPlugin.class
    }
            ArrowBasePlugin.class,
                    "col_timestamp"
        assertEquals(Boolean.TRUE, getColumnInfo(INDEX_NAME, "name").get("bloom_filter"));
                .putList("index.parquet.bloom_filter_enabled.field", "name")
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_utf8"), "DELTA_BYTE_ARRAY");
        Settings.Builder builder = Settings.builder()
     * Field-level bloom_filter_enabled=true overrides global disabled (default).
        startCluster(Settings.builder().put("parquet.type_compression.int32.compression", "ZSTD").build());
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                encodings.add(enc.trim().replace("\"", ""));
        assertDoesNotHaveEncoding(getColumnInfo(INDEX_NAME, "value"), "DELTA_BINARY_PACKED");
        int encEnd = colJson.indexOf(']');
        createIndex(Settings.EMPTY);
    private void indexAllTypeDocs() {
        boolean hasBloomFilter = false;
 */
            Settings.builder()
     * Full 3-tier: field=true overrides type=false overrides global=false.
        );
    /**
                        return RustBridge.getColumnMetadata(filePath.toString());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertCompression(getColumnInfo(INDEX_NAME, "col_float32"), "BROTLI");
                "type=binary,store=true",
        internalCluster().startDataOnlyNode(nodeSettings);
        createIndex(
 *
        refreshIndex(INDEX_NAME);
    }
        );
    }
        indexAllTypeDocs();
                "col_timestamp",
 */
        fail("No parquet file found for index: " + indexName);
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_binary"), "DELTA_BYTE_ARRAY");
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_timestamp"), "PLAIN");
            .prepareCreate(INDEX_NAME)
            LucenePlugin.class,
        );
    }
     */
     * Type-level encoding for int32 applies to integer columns.
     */
            .setSettings(builder)
                )
     * Verifies each column in the parquet file has the expected encoding.
            }
        assertTrue("Expected encoding '" + expectedEncoding + "' in " + encodings, encodings.contains(expectedEncoding));
        createIndex(Settings.EMPTY);
            .prepareCreate(INDEX_NAME)
    private void startCluster(Settings extraNodeSettings) {
                .put("parquet.type_compression.float32.compression", "BROTLI")
    /**
        // Parse compression
        startCluster(Settings.builder().put("parquet.type_compression.utf8.compression", "SNAPPY").build());
        assertHasEncoding(getColumnInfo(INDEX_NAME, "name"), "DELTA_BYTE_ARRAY");
                "col_int64",
        createIndex(
    }
            .get();
    @SuppressWarnings("unchecked")
 * this file be licensed under the Apache-2.0 license or a
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        startCluster(Settings.builder().put("parquet.type_encoding.int32.encoding", "DELTA_BINARY_PACKED").build());
package org.opensearch.composite;
        createAllTypeIndex(
        indexAndFlush();
    /**
                    "col_utf8",
        assertTrue(
        // Type-level sets DELTA_BINARY_PACKED for int32
            Settings.builder()
        int compStart = colJson.indexOf(compKey);
        indexAndFlush();
            Settings.builder().putList("index.parquet.compression.field", "name").putList("index.parquet.compression.value", "ZSTD").build()
            List<String> encodings = new ArrayList<>();
                .put("parquet.type_encoding.utf8.encoding", "DELTA_BYTE_ARRAY")
import org.opensearch.cluster.metadata.IndexMetadata;
                    "DELTA_BINARY_PACKED",
    }
import org.opensearch.common.settings.Settings;
    // --- Bloom filter 3-tier tests ---
        );
                    "val_" + i,
        indexAndFlush();
                    "col_int32",
public class CompositeParquet3TierSettingsIT extends AbstractCompositeEngineIT {
        startCluster(Settings.builder().put("parquet.type_compression.utf8.compression", "SNAPPY").build());
                    "col_int32",
        createIndex(
                    "DELTA_BYTE_ARRAY",
        assertEquals(Boolean.FALSE, getColumnInfo(INDEX_NAME, "value").get("bloom_filter"));
            .setMapping("name", "type=keyword", "value", "type=integer")
    }
    public void testTypeLevelCompressionAllCombinations() throws IOException {
            for (String enc : encodingsStr.split(",")) {
    }
        assertCompression(getColumnInfo(INDEX_NAME, "col_int32"), "ZSTD");
            int compEnd = colJson.indexOf('"', compStart);
    private static final String INDEX_NAME = "test-3tier";
        flushIndex(INDEX_NAME);
/*
                .get();
            CompositeDataFormatPlugin.class,
        startCluster(
     */
     * Field-level compression overrides type-level compression.
        for (Segment segment : snapshot.getSegments()) {
        assertCompression(getColumnInfo(INDEX_NAME, "col_timestamp"), "GZIP");
    public void testTypeLevelBloomFilterOverridesGlobal() throws IOException {
                .put("parquet.type_compression.timestamp.compression", "GZIP")
                    Path filePath = parquetDir.resolve(file);
        assertHasEncoding(getColumnInfo(INDEX_NAME, "value"), "DELTA_BINARY_PACKED");
        // Parse bloom_filter
                    "col_int32",
            .put(extraIndexSettings);
    /**
        assertCompression(getColumnInfo(INDEX_NAME, "col_binary"), "ZSTD");
                    (long) i,
        indexDocs(INDEX_NAME, 5, 0);
        );
                .build()
        // Field-level sets PLAIN for "value"
            .indices()
            client().prepareIndex()
                    "DELTA_BINARY_PACKED",
    }
                    "col_binary",
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_int32"), "DELTA_BINARY_PACKED");
                .put("parquet.type_compression.utf8.compression", "SNAPPY")
    /**
 * The OpenSearch Contributors require contributions made to
     */
    public void testFieldLevelBloomFilterOverridesGlobal() throws IOException {
        refreshIndex(INDEX_NAME);
        return null;
        indexAndFlush();
            .put("index.pluggable.dataformat.enabled", true)
    @Override
                .put("parquet.type_compression.int64.compression", "GZIP")
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_boolean"), "RLE");
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_float64"), "BYTE_STREAM_SPLIT");
        }
import org.opensearch.arrow.allocator.ArrowBasePlugin;
     * Field-level compression set per column for all types simultaneously.
    public void testFieldLevelCompressionAllCombinations() throws IOException {
        assertHasEncoding(getColumnInfo(INDEX_NAME, "value"), "PLAIN");
import java.util.ArrayList;
        createIndex(
                for (String file : wfs.files()) {
        int bfStart = colJson.indexOf(bfKey);
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_int64"), "DELTA_BINARY_PACKED");
                .putList(
            }
        return result;
    private void assertDoesNotHaveEncoding(Map<String, Object> colMeta, String encoding) {
     */
     * Type-level compression for utf8 applies to keyword columns.
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_float32"), "BYTE_STREAM_SPLIT");
                .put("parquet.type_encoding.float32.encoding", "BYTE_STREAM_SPLIT")
        }
        assertEquals(Boolean.FALSE, getColumnInfo(INDEX_NAME, "value").get("bloom_filter"));
        );
        assertCompression(getColumnInfo(INDEX_NAME, "col_utf8"), "SNAPPY");
    private void createIndex(Settings extraIndexSettings) {
        int braceStart = json.indexOf('{', start + key.length() - 1);
                }
            result.put("compression", colJson.substring(compStart, compEnd));
            .put("index.pluggable.dataformat.enabled", true)
     */
