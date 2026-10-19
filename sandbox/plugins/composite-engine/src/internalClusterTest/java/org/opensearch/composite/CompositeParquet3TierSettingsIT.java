        createIndex(Settings.EMPTY);
        assertEquals(Boolean.TRUE, getColumnInfo(INDEX_NAME, "name").get("bloom_filter"));  
    private String getFirstFileColumnMetadata(String indexName) throws IOException {
        createIndex(Settings.EMPTY);
        createIndex(Settings.EMPTY);
                    "col_utf8",  
    }
     * Type-level encoding for int32 applies to integer columns.  
            WriterFileSet wfs = segment.dfGroupedSearchableFiles().get("parquet");
     */
                    Path filePath = parquetDir.resolve(file);
        if (encStart != -1 && encEnd != -1) {
                .put("parquet.type_encoding.int32.encoding", "DELTA_BINARY_PACKED")
            compression.startsWith(expectedPrefix)
        assertEquals(Boolean.FALSE, getColumnInfo(INDEX_NAME, "name").get("bloom_filter"));  
        }  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        int compStart = colJson.indexOf(compKey);
            .put("index.composite.primary_data_format", "parquet")
                    "BYTE_STREAM_SPLIT",  
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_boolean"), "RLE");  
    }  
        createIndex(
}
        // Global is LZ4_RAW (default)
        if (bfStart != -1) {  
        assertHasEncoding(getColumnInfo(INDEX_NAME, "value"), "PLAIN");
        assertCompression(getColumnInfo(INDEX_NAME, "name"), "SNAPPY");
        indexAndFlush();  
        String key = "\"" + columnName + "\":{";
 * The OpenSearch Contributors require contributions made to  
        String compKey = "\"compression\":\"";  
     * Type-level encoding for utf8 applies to keyword columns.  
        );
    public void testFullThreeTierCompression() throws IOException {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_float32"), "BYTE_STREAM_SPLIT");
    public void testTypeLevelEncodingAllValidCombinations() throws IOException {
     */
        assertEquals(Boolean.FALSE, getColumnInfo(INDEX_NAME, "value").get("bloom_filter"));
     */
                .put("parquet.type_encoding.float32.encoding", "BYTE_STREAM_SPLIT")
                    "val_" + i,  
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_int32"), "DELTA_BINARY_PACKED");
 * Uses numDataNodes=0 so nodes can be started with static type-level node settings.  
    /**
        indexAndFlush();
                )
import java.util.ArrayList;  
            }
            Settings.builder()  
        assertCompression(getColumnInfo(INDEX_NAME, "col_boolean"), "SNAPPY");  
            .putList("index.composite.secondary_data_formats", "lucene")
        assertCompression(getColumnInfo(INDEX_NAME, "col_boolean"), "SNAPPY");
                "col_boolean",
        );  
                .putList(
    /**  
        indexAndFlush();
            .indices()
    // --- Compression 3-tier tests ---
    @Override
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
                .put("parquet.type_compression.int32.compression", "ZSTD")
    public void testTypeLevelCompressionOverridesGlobal() throws IOException {
     */  
        indexAllTypeDocs();
        flushIndex(INDEX_NAME);  
                .putList("index.parquet.bloom_filter_enabled.field", "name")
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_float64"), "BYTE_STREAM_SPLIT");  
            Settings.builder().putList("index.parquet.encoding.field", "value").putList("index.parquet.encoding.value", "PLAIN").build()  
            Settings.builder().putList("index.parquet.compression.field", "name").putList("index.parquet.compression.value", "ZSTD").build()  
 * SPDX-License-Identifier: Apache-2.0
    public void testTypeLevelCompressionApplied() throws IOException {  
                "type=binary,store=true",
        indexAndFlush();
                    "BYTE_STREAM_SPLIT",
                    "2024-01-0" + (i + 1)  
        return null;  
                }
        // Parse bloom_filter
            Settings.builder()  
        List<String> encodings = (List<String>) colMeta.get("encodings");
            .put(extraIndexSettings);
                for (String file : wfs.files()) {  
        // Field-level sets PLAIN for "value"
                "col_timestamp",
        // Field-level overrides with ZSTD for "name", global is LZ4_RAW
            .get();
        startCluster(Settings.builder().put("parquet.type_bloom_filter.utf8.enabled", "true").build());  
 */  
        assertCompression(getColumnInfo(INDEX_NAME, "col_binary"), "ZSTD");
     * Type-level compression for utf8 applies to keyword columns.
                .build()  
        createIndex(
import java.util.HashMap;  
                .build()  
                    "col_boolean",  
     * Field-level encoding set per column for all types simultaneously.
            Settings.builder().putList("index.parquet.compression.field", "name").putList("index.parquet.compression.value", "ZSTD").build()
            client().prepareIndex()
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        startCluster(Settings.builder().put("parquet.type_encoding.utf8.encoding", "DELTA_BYTE_ARRAY").build());  
        return result;  
    /**  
                    "col_binary",  
                "type=double",  
        assertEquals(Boolean.TRUE, getColumnInfo(INDEX_NAME, "name").get("bloom_filter"));
        int encStart = colJson.indexOf('[');  
    }  
                    }
    }
    // --- Bloom filter 3-tier tests ---  
        assertCompression(getColumnInfo(INDEX_NAME, "col_utf8"), "SNAPPY");
     * Type-level compression overrides global compression.  
                .put("parquet.type_encoding.utf8.encoding", "DELTA_BYTE_ARRAY")
            .setSettings(builder)  
    }
import org.opensearch.index.engine.exec.WriterFileSet;
        Settings.Builder builder = Settings.builder()  
            .put(extraNodeSettings)
import org.opensearch.cluster.metadata.IndexMetadata;
        // Parse encodings list
        String json = getFirstFileColumnMetadata(indexName);
                    "col_int32",
                .put("parquet.type_compression.binary.compression", "ZSTD")  
        createIndex(
            ArrowBasePlugin.class,
        startCluster(Settings.EMPTY);
                encodings.add(enc.trim().replace("\"", ""));  
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_boolean"), "RLE");
 *
                    "DELTA_BYTE_ARRAY",  
        );  
import java.util.Collection;
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
            List<String> encodings = new ArrayList<>();
            compStart += compKey.length();  
    }  
        assertHasEncoding(getColumnInfo(INDEX_NAME, "value"), "DELTA_BINARY_PACKED");
        int braceStart = json.indexOf('{', start + key.length() - 1);
import java.util.Arrays;
            .put("index.pluggable.dataformat.enabled", true)  
     * Field-level compression overrides type-level compression.  
     * Field-level encoding overrides type-level encoding.
        startCluster(Settings.builder().put("parquet.type_compression.utf8.compression", "SNAPPY").build());
        createIndex(
        }
        startCluster(Settings.builder().put("parquet.type_compression.utf8.compression", "SNAPPY").build());
            .put(extraIndexSettings);
        createIndex(  
        ensureGreen(INDEX_NAME);  
        startCluster(Settings.builder().put("parquet.type_encoding.int32.encoding", "DELTA_BINARY_PACKED").build());  
            DataFusionPlugin.class
    }  
    private void assertHasEncoding(Map<String, Object> colMeta, String expectedEncoding) {
    }
    // --- Helpers ---  
import org.opensearch.be.datafusion.DataFusionPlugin;
    }
        }  
import java.nio.file.Path;
        Settings nodeSettings = Settings.builder()  
    }  
 */
     * Type-level encoding set for all arrow types simultaneously.
     * Type-level compression set for all arrow types simultaneously.  
            if (wfs != null) {
            Settings.builder()
            .setMapping(
        assertCompression(getColumnInfo(INDEX_NAME, "col_int64"), "GZIP");
        assertFalse("Did not expect encoding '" + encoding + "' in " + encodings, encodings.contains(encoding));  
                "type=float",
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    if (Files.exists(filePath)) {
        indexAndFlush();  
                    "col_binary",
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_utf8"), "DELTA_BYTE_ARRAY");
                .put("parquet.type_encoding.int64.encoding", "DELTA_BINARY_PACKED")  
            }  
            LucenePlugin.class,
    private void assertDoesNotHaveEncoding(Map<String, Object> colMeta, String encoding) {
                    "col_timestamp",
        internalCluster().startDataOnlyNode(nodeSettings);
    }
    public void testTypeLevelCompressionAllCombinations() throws IOException {  
        );
        indexAndFlush();
                .putList("index.parquet.bloom_filter_enabled.value", "false")
        );
        assertDoesNotHaveEncoding(getColumnInfo(INDEX_NAME, "value"), "DELTA_BINARY_PACKED");
                    i % 2 == 0,
        for (Segment segment : snapshot.getSegments()) {  
    /**
        startCluster(Settings.builder().put("parquet.type_compression.utf8.compression", "SNAPPY").build());  
 * compatible open source license.
        int encEnd = colJson.indexOf(']');
        client().admin()
                .putList(
        assertCompression(getColumnInfo(INDEX_NAME, "col_int64"), "GZIP");  
                    "DELTA_BINARY_PACKED",
     */
            .build();  
     * Verifies each column has the expected compression in the parquet file.
        assertEquals(Boolean.TRUE, getColumnInfo(INDEX_NAME, "name").get("bloom_filter"));
        return Arrays.asList(  
    private void createIndex(Settings extraIndexSettings) {
                "col_binary",  
    public void testTypeLevelBloomFilterEnabled() throws IOException {
     */
        assertCompression(getColumnInfo(INDEX_NAME, "col_timestamp"), "GZIP");
            CompositeDataFormatPlugin.class,  
                .setIndex(INDEX_NAME)  
        indexAllTypeDocs();
    }  
                .putList("index.parquet.compression.value", "SNAPPY", "ZSTD", "GZIP", "BROTLI", "LZ4_RAW", "SNAPPY", "ZSTD", "GZIP")  
    public void testFieldLevelBloomFilterOverridesGlobal() throws IOException {  
            for (String enc : encodingsStr.split(",")) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        result.put("bloom_filter", hasBloomFilter);
        Path parquetDir = getPrimaryShard(indexName).shardPath().getDataPath().resolve("parquet");
        startCluster(Settings.builder().put("parquet.type_bloom_filter.utf8.enabled", "true").build());  
                "type=keyword,index=false",
        fail("No parquet file found for index: " + indexName);
                    "index.parquet.encoding.field",  
                    "col_timestamp"
    private void indexAllTypeDocs() {  
        );  
            .setMapping("name", "type=keyword", "value", "type=integer")
import org.opensearch.plugins.Plugin;  
        assertTrue("Expected encoding '" + expectedEncoding + "' in " + encodings, encodings.contains(expectedEncoding));  
                    "col_int32",
                "type=date"  
                    "col_int64",  
        assertCompression(getColumnInfo(INDEX_NAME, "col_utf8"), "SNAPPY");
        refreshIndex(INDEX_NAME);
                .setSource(
    /**
        indexAndFlush();
            int compEnd = colJson.indexOf('"', compStart);
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_int32"), "DELTA_BINARY_PACKED");  
                    "col_float32",  
     */
                .build()
    }
        startCluster(Settings.builder().put("parquet.type_bloom_filter.int32.enabled", "true").build());  
     */
        createIndex(Settings.EMPTY);
        assertCompression(getColumnInfo(INDEX_NAME, "col_float64"), "LZ4_RAW");
        }  
     */  
                    (long) i,
    }
    public void testFieldLevelCompressionAllCombinations() throws IOException {  
    public void testTypeLevelEncodingApplied() throws IOException {
                .put("parquet.type_compression.float32.compression", "BROTLI")  
                .put("parquet.type_compression.int64.compression", "GZIP")
                    "col_boolean",
                    "index.parquet.compression.field",
            "Expected compression starting with '" + expectedPrefix + "', got: " + compression,  
     */  
        indexAllTypeDocs();  
        indexAndFlush();
     */  
    /**
                .putList("index.parquet.bloom_filter_enabled.value", "true")
                    "RLE",
        createAllTypeIndex(  
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_utf8"), "DELTA_BYTE_ARRAY");
        // Type-level sets DELTA_BINARY_PACKED for int32
    @SuppressWarnings("unchecked")  
        for (int i = 0; i < 5; i++) {
    }
        boolean hasBloomFilter = false;
    public void testTypeLevelEncodingForUtf8() throws IOException {
    }
        assertCompression(getColumnInfo(INDEX_NAME, "col_float32"), "BROTLI");
import java.util.Map;
            Settings.builder()
        indexAndFlush();  
    /**
     * Verifies each column has the expected compression in the parquet file.
                    "col_float64",
        assertCompression(getColumnInfo(INDEX_NAME, "col_float64"), "LZ4_RAW");  
                    "col_float32",
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_binary"), "DELTA_BYTE_ARRAY");
        startCluster(
        String bfKey = "\"bloom_filter\":";  
                    (double) i,
                .put("parquet.type_encoding.timestamp.encoding", "PLAIN")
        // Type-level sets SNAPPY for utf8  
            .get();
        assertCompression(getColumnInfo(INDEX_NAME, "name"), "ZSTD");
    private void assertCompression(Map<String, Object> colMeta, String expectedPrefix) {  
                .putList("index.parquet.bloom_filter_enabled.field", "name")  
     * Verifies each column in the parquet file has the expected encoding.
        int start = json.indexOf(key);  
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_float32"), "BYTE_STREAM_SPLIT");
import java.util.List;
    /**
        // Field-level sets ZSTD for "name"
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_timestamp"), "PLAIN");  
    /**
    @SuppressWarnings("unchecked")
    public void testFieldLevelCompressionOverridesTypeLevel() throws IOException {
        indexAndFlush();
package org.opensearch.composite;
    }  
                "type=long",
                "col_float32",  
                "col_float64",
import java.nio.file.Files;
    /**
                    "col_int64",
    }  
    public void testTypeLevelBloomFilterOverridesGlobal() throws IOException {
            )
        startCluster(Settings.EMPTY);
        // "name" (utf8) uses ZSTD as the default for utf8/binary types  
                .putList(
    }
            .put("index.composite.primary_data_format", "parquet")  
                .build()
public class CompositeParquet3TierSettingsIT extends AbstractCompositeEngineIT {  
/*  
     * Field-level bloom_filter_enabled=false overrides type-level enabled=true.  
        startCluster(Settings.builder().put("parquet.type_encoding.int32.encoding", "DELTA_BINARY_PACKED").build());  
     * Field-level compression set per column for all types simultaneously.  
        );
            .indices()
            .put("index.pluggable.dataformat", "composite")
        Settings.Builder builder = Settings.builder()
    }  
                )
        // Parse compression
     */
                    "col_int32",
import org.opensearch.parquet.ParquetDataFormatPlugin;
    }
    @SuppressWarnings("unchecked")  
                .put("parquet.type_compression.timestamp.compression", "GZIP")
    /**
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
                .build()
                    "col_utf8",
            Settings.builder()
                    "col_boolean",  
        String colJson = json.substring(braceStart, braceEnd + 1);
                    "col_timestamp"
    }
                    "col_float64",
                "col_utf8",  
            String encodingsStr = colJson.substring(encStart + 1, encEnd);  
        indexAndFlush();
                "col_int64",
import org.opensearch.common.util.FeatureFlags;  
        assertCompression(getColumnInfo(INDEX_NAME, "name"), "ZSTD");
    }
        assertTrue(
        }  
            Settings.builder()  
                .put("parquet.type_compression.float64.compression", "LZ4_RAW")
    /**
import java.io.IOException;  
                .put("parquet.type_compression.utf8.compression", "SNAPPY")  
        createIndex(Settings.EMPTY);
    /**  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
     * Type-level bloom filter enabled for utf8 enables bloom on keyword columns only.  
                "col_int32",
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_timestamp"), "PLAIN");
     * Full 3-tier: field=true overrides type=false overrides global=false.  
        // Type-level sets SNAPPY for utf8
                .build()
        indexDocs(INDEX_NAME, 5, 0);
            .prepareCreate(INDEX_NAME)  
            .prepareCreate(INDEX_NAME)
import org.opensearch.parquet.bridge.RustBridge;
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_int64"), "DELTA_BINARY_PACKED");
    private void indexAndFlush() {  
                    "PLAIN"
        assertCompression(getColumnInfo(INDEX_NAME, "col_int32"), "ZSTD");  
                .put("parquet.type_encoding.boolean.encoding", "RLE")  
                )  
     */
                    "index.parquet.encoding.value",
        assertEquals(Boolean.FALSE, getColumnInfo(INDEX_NAME, "value").get("bloom_filter"));
                .putList("index.parquet.bloom_filter_enabled.field", "name")  
        if (compStart != -1) {
                    "col_int64",  
    }
        assertEquals(Boolean.FALSE, getColumnInfo(INDEX_NAME, "name").get("bloom_filter"));
                .build()  
import org.opensearch.index.engine.exec.Segment;
    }
        List<String> encodings = (List<String>) colMeta.get("encodings");
        startCluster(
/**
    /**
     */
                        return RustBridge.getColumnMetadata(filePath.toString());  
                    "DELTA_BINARY_PACKED",
                "type=integer",  
        );
    private static final String INDEX_NAME = "test-3tier";
     * Field-level bloom_filter_enabled=true overrides global disabled (default).
        );
        assertFalse("Column '" + columnName + "' not found in metadata: " + json, start == -1);
        assertCompression(getColumnInfo(INDEX_NAME, "col_float32"), "BROTLI");
                    "DELTA_BYTE_ARRAY",  
        createAllTypeIndex(
            .putList("index.composite.secondary_data_formats", "lucene")  
     * Type-level enabled=true overrides global disabled (default) for int32.  
        flushIndex(INDEX_NAME);
            result.put("compression", colJson.substring(compStart, compEnd));
    }  
        ensureGreen(INDEX_NAME);  
                .putList("index.parquet.bloom_filter_enabled.value", "true")
            result.put("encodings", encodings);
    public void testFieldLevelEncodingOverridesTypeLevel() throws IOException {
        int braceEnd = json.indexOf('}', braceStart);  
            Settings.builder()
    private Map<String, Object> getColumnInfo(String indexName, String columnName) throws IOException {  
     */
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .put("index.pluggable.dataformat.enabled", true)
            .setSettings(builder)
        startCluster(Settings.EMPTY);
import org.opensearch.common.settings.Settings;
                "type=boolean,index=false",
                .put("parquet.type_compression.boolean.compression", "SNAPPY")
     * Verifies each column in the parquet file has the expected encoding.
    private void startCluster(Settings extraNodeSettings) {
                    i,
        indexAndFlush();
        indexAllTypeDocs();  
        assertHasEncoding(getColumnInfo(INDEX_NAME, "name"), "DELTA_BYTE_ARRAY");
        createIndex(Settings.EMPTY);
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_int64"), "DELTA_BINARY_PACKED");  
        assertEquals(Boolean.TRUE, getColumnInfo(INDEX_NAME, "value").get("bloom_filter"));
    private void createAllTypeIndex(Settings extraIndexSettings) {  
 * Integration tests verifying 3-tier settings priority: field-level > type-level > global.
        assertCompression(getColumnInfo(INDEX_NAME, "col_int32"), "ZSTD");
    // --- All-type encoding/compression exhaustive tests ---
        );
        CatalogSnapshot snapshot = acquireAndGetSnapshot(indexName);  
        );  
                )
        createAllTypeIndex(Settings.EMPTY);
 * this file be licensed under the Apache-2.0 license or a
        startCluster(Settings.builder().put("parquet.type_bloom_filter.utf8.enabled", "false").build());  
                .put("parquet.type_encoding.float64.encoding", "BYTE_STREAM_SPLIT")
            .put("index.pluggable.dataformat", "composite")
                    (float) i,  
                .get();
        createAllTypeIndex(Settings.EMPTY);
        int bfStart = colJson.indexOf(bfKey);
        assertCompression(getColumnInfo(INDEX_NAME, "col_binary"), "ZSTD");
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_binary"), "DELTA_BYTE_ARRAY");
            ParquetDataFormatPlugin.class,
        assertHasEncoding(getColumnInfo(INDEX_NAME, "col_float64"), "BYTE_STREAM_SPLIT");
    // --- Encoding 3-tier tests ---  
        assertCompression(getColumnInfo(INDEX_NAME, "value"), "ZSTD");
        startCluster(Settings.builder().put("parquet.type_compression.int32.compression", "ZSTD").build());  
        Map<String, Object> result = new HashMap<>();  
                .put("parquet.type_encoding.binary.encoding", "DELTA_BYTE_ARRAY")
        assertCompression(getColumnInfo(INDEX_NAME, "col_timestamp"), "GZIP");  
                    "col_float32",
        assertCompression(getColumnInfo(INDEX_NAME, "name"), "ZSTD");
        );
    /**  
            String bfVal = colJson.substring(bfStart + bfKey.length()).split("[,}]")[0].trim();
            hasBloomFilter = "true".equals(bfVal);
    public void testFullThreeTierBloomFilter() throws IOException {
        String compression = (String) colMeta.get("compression");
        createIndex(
                    "col_utf8",
    /**
    public void testFieldLevelEncodingAllValidCombinations() throws IOException {
        refreshIndex(INDEX_NAME);
     * Full 3-tier compression: field > type > global.
     */
                    "col_float64",
        client().admin()  
import org.opensearch.test.OpenSearchIntegTestCase;
    public void testFieldLevelBloomFilterOverridesTypeLevel() throws IOException {
    }  
import org.opensearch.be.lucene.LucenePlugin;  
