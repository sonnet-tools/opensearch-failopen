        IllegalArgumentException e = expectThrows(
            .put("parquet.type_bloom_filter.int64.enabled", "false")
    }  
                ParquetSettings.MAX_ROWS_PER_VSR_CEIL
        Settings settings = Settings.builder().put("parquet.type_compression.utf8.compression", "ZSTD").build();
        Settings settings = Settings.builder()
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ParquetSettings.getTypeEncodings(settings));
    public void testSortInMemoryThresholdFallsBackToBaseWhenRamUnavailable() {
    }
        Schema schema = new Schema(List.of(new Field("name", FieldType.nullable(ArrowType.Utf8.INSTANCE), null)));  
        );
            IllegalArgumentException.class,  
    }  
        Settings settings = Settings.builder()
            .putList("index.parquet.compression.value", "snappy")
        assertEquals(0.01, result.get("name"), 0.0001);
    public void testTypeBloomFilterInvalidEnabledValueThrows() {  
    public void testTypeCompressionValidTypeAndCompression() {  
    }  
    // --- Encoding-type compatibility tests ---  
        int vsrFloor = ParquetSettings.MAX_ROWS_PER_VSR_FLOOR;
    }
        assertEquals(100_000, ParquetSettings.deriveBatchSizeDefault(256 * GIB, base, floor, ceil)); // capped  
    public void testTypeBloomFilterMultipleTypes() {  
            ParquetSettings.SORT_IN_MEMORY_THRESHOLD_BASE_MB,  
        assertEquals(Boolean.TRUE, enabled.get("utf8"));
    public void testEncodingCompatibilityRleValidForBoolean() {  
        assertTrue(e.getMessage().contains("foobar"));
    }
            List.of(new Field("score", FieldType.nullable(new ArrowType.FloatingPoint(FloatingPointPrecision.DOUBLE)), null))  
        Settings settings = Settings.builder().put("parquet.type_compression.foobar.compression", "SNAPPY").build();
            .putList("index.parquet.compression.field", "name")
        int mrgFloor = ParquetSettings.MERGE_BATCH_SIZE_FLOOR;  
    }  
            .put("parquet.type_bloom_filter.utf8.ndv", "100000")
            ParquetSettings.DEFAULT_MERGE_BATCH_SIZE,  
        assertEquals(Long.valueOf(50000L), result.get("name"));
        assertTrue(e.getMessage().contains("Invalid compression"));
        assertEquals(vsrFloor, ParquetSettings.deriveBatchSizeDefault(2 * GIB, vsrBase, vsrFloor, vsrCeil));
        Map<String, Long> result = ParquetSettings.getFieldBloomFilterNdv(settings);
    }
        Settings settings = Settings.builder().put("parquet.type_encoding.int64.encoding", "INVALID").build();
        assertEquals(0.01, fpp.get("utf8"), 0.0001);  
        assertEquals(0.05, fpp.get("utf8"), 0.0001);
    public void testTypeBloomFilterInvalidArrowTypeThrows() {  
    public void testFieldBloomFilterNdv() {
    public void testTypeEncodingValidTypeAndEncoding() {
        );
            Map<String, String> encodings = ParquetSettings.getTypeEncodings(settings);
        assertEquals(
    }
public class ParquetSettingsTests extends OpenSearchTestCase {  
        Map<String, String> encodings = ParquetSettings.getFieldEncodings(settings);
    public void testAllValidArrowTypesAccepted() {
        assertEquals(
 * SPDX-License-Identifier: Apache-2.0
        );
        ParquetSettings.validateFieldConfigurations(encodings, Map.of(), Map.of(), schema);
        assertEquals(32, ParquetSettings.deriveBatchSizeDefault(64 * GIB, base, floor, ceil));  // anchor
        assertEquals(16, ParquetSettings.deriveBatchSizeDefault(32 * GIB, base, floor, ceil));  // 16
        Settings settings = Settings.builder().put("parquet.type_encoding.banana.encoding", "PLAIN").build();  
        Settings settings = Settings.builder()  
        assertTrue(e.getMessage().contains("Invalid encoding"));  
            .putList("index.parquet.compression.field", "name")
        );
        Map<String, String> encodings = Map.of("score", "BYTE_STREAM_SPLIT");
    public void testTypeBloomFilterInvalidNdvThrows() {  
    public void testTypeCompressionInvalidArrowTypeThrows() {  
import org.apache.arrow.vector.types.pojo.ArrowType;
            )  
    }
        IllegalArgumentException e = expectThrows(  
 * compatible open source license.
        assertEquals("SNAPPY", compressions.get("name"));
                ParquetSettings.MAX_ROWS_PER_VSR_FLOOR,
    }
    public void testFieldSettingsValidCompression() {
        Map<String, Boolean> result = ParquetSettings.getFieldBloomFilterEnabled(settings);  
        assertEquals("ZSTD", compressions.get("utf8"));  
            .build();  
import org.apache.arrow.vector.types.pojo.FieldType;
                -1,
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ParquetSettings.getTypeBloomFilterNdv(settings));
        ParquetSettings.validateFieldConfigurations(encodings, Map.of(), Map.of(), schema);  
            .putList("index.parquet.encoding.value", "INVALID")
            IllegalArgumentException.class,
        assertTrue(e.getMessage().contains("Invalid arrow type"));  
        Map<String, String> encodings = Map.of("name", "DELTA_BINARY_PACKED");
        for (String type : ParquetSettings.VALID_ARROW_TYPES) {
        // (total RAM -> sort threshold, in MiB)
        assertEquals(65_536, ParquetSettings.deriveBatchSizeDefault(64 * GIB, base, floor, ceil)); // anchor
        assertEquals(Boolean.TRUE, result.get("name"));
    private static final long GIB = 1024L * 1024 * 1024;  
    public void testFieldBloomFilterEnabled() {
            assertEquals("PLAIN", encodings.get(type));
import org.opensearch.common.settings.Settings;  
        Settings settings = Settings.builder().put("parquet.type_bloom_filter.banana.enabled", "true").build();
        Settings settings = Settings.builder().put("parquet.type_bloom_filter.utf8.fpp", "1.5").build();
    public void testCompressionCaseInsensitive() {
        assertTrue(e.getMessage().contains("Invalid encoding"));
            .build();  
                ParquetSettings.SORT_IN_MEMORY_THRESHOLD_CEIL_MB
    public void testBatchSizeDefaultFallsBackToBaseWhenRamUnavailable() {
            IllegalArgumentException.class,
    }
    }
                -1,
        );
        assertEquals(64, ParquetSettings.deriveBatchSizeDefault(256 * GIB, base, floor, ceil)); // capped
    }
        Settings settings = Settings.builder()
    }
        assertTrue(e.getMessage().contains("not compatible"));
    // --- TYPE_COMPRESSION_SETTINGS validation tests ---
    public void testSortInMemoryThresholdDefaultScalesWithRam() {  
        Schema schema = new Schema(List.of(new Field("name", FieldType.nullable(ArrowType.Utf8.INSTANCE), null)));
        Settings settings = Settings.builder().put("parquet.type_bloom_filter.utf8.ndv", "-1").build();
            .put("parquet.type_bloom_filter.utf8.enabled", "true")  
        assertEquals(Boolean.FALSE, result.get("value"));
/*  
        Schema schema = new Schema(
        assertTrue(e.getMessage().contains("INVALID"));
        Map<String, String> encodings = Map.of("flag", "RLE");
            .putList("index.parquet.compression.value", "INVALID")
        assertEquals(Boolean.FALSE, enabled.get("int64"));
        assertEquals(32_768, ParquetSettings.deriveBatchSizeDefault(32 * GIB, base, floor, ceil));  
        Map<String, String> compressions = ParquetSettings.getFieldCompressions(settings);
            .put("parquet.type_bloom_filter.int64.ndv", "50000")
        int vsrCeil = ParquetSettings.MAX_ROWS_PER_VSR_CEIL;  
            .putList("index.parquet.compression.field", "name")
    // --- RAM-scaled batch-size default tests ---
            .put("parquet.type_bloom_filter.utf8.fpp", "0.05")
            () -> ParquetSettings.validateFieldConfigurations(encodings, Map.of(), Map.of(), schema)  
    public void testEncodingCompatibilityDeltaBinaryPackedValidForInt() {
    public void testFieldBloomFilterFpp() {
 * The OpenSearch Contributors require contributions made to  
        assertEquals(Long.valueOf(100000L), ndv.get("utf8"));  
        Map<String, String> compressions = ParquetSettings.getFieldCompressions(settings);
            .build();  
        assertEquals("DELTA_BYTE_ARRAY", encodings.get("name"));
    public void testEncodingCompatibilityDictionaryInvalidForBoolean() {
    }  
        assertEquals(mrgCeil, ParquetSettings.deriveBatchSizeDefault(1024 * GIB, mrgBase, mrgFloor, mrgCeil));  
    // --- FIELD_SETTINGS validation tests ---
        Schema schema = new Schema(List.of(new Field("count", FieldType.nullable(new ArrowType.Int(32, true)), null)));
        Map<String, Double> fpp = ParquetSettings.getTypeBloomFilterFpp(settings);
            Settings settings = Settings.builder().put("parquet.type_encoding." + type + ".encoding", "PLAIN").build();  
        assertEquals(16_384, ParquetSettings.deriveBatchSizeDefault(16 * GIB, base, floor, ceil));
        Map<String, Long> ndv = ParquetSettings.getTypeBloomFilterNdv(settings);  
import org.apache.arrow.vector.types.FloatingPointPrecision;
                ParquetSettings.DEFAULT_MAX_ROWS_PER_VSR,  
            IllegalArgumentException.class,  
        Settings settings = Settings.builder()  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ParquetSettings.getTypeBloomFilterFpp(settings));
    }
            ParquetSettings.deriveBatchSizeDefault(
            .build();
        Map<String, String> encodings = ParquetSettings.getFieldEncodings(settings);  
    public void testBatchSizeDefaultsClampToFloorAndCeiling() {  
    }  
        int floor = ParquetSettings.SORT_IN_MEMORY_THRESHOLD_FLOOR_MB; // 16 MiB
        assertEquals(64, ParquetSettings.deriveBatchSizeDefault(128 * GIB, base, floor, ceil)); // 64 (ceil)  
        assertEquals("DELTA_BYTE_ARRAY", encodings.get("name"));
        assertEquals(mrgFloor, ParquetSettings.deriveBatchSizeDefault(2 * GIB, mrgBase, mrgFloor, mrgCeil));
    public void testEncodingCompatibilityByteStreamSplitValidForFloat() {
import org.apache.arrow.vector.types.pojo.Schema;
                ParquetSettings.SORT_IN_MEMORY_THRESHOLD_BASE_MB,  
        assertEquals(16, ParquetSettings.deriveBatchSizeDefault(16 * GIB, base, floor, ceil));  // 8 -> floor  
        }  
        assertEquals(
        int base = ParquetSettings.DEFAULT_MAX_ROWS_PER_VSR;       // 65,536 @ 64 GiB  
    public void testEncodingCompatibilityFieldNotInSchemaThrows() {
                ParquetSettings.SORT_IN_MEMORY_THRESHOLD_FLOOR_MB,
        assertEquals(100_000, ParquetSettings.deriveBatchSizeDefault(128 * GIB, base, floor, ceil)); // capped
    // --- Field-level bloom filter tests ---
            .putList("index.parquet.encoding.value", "delta_byte_array")
        assertTrue(e.getMessage().contains("Invalid arrow type"));  
    }
 */  
        assertTrue(e.getMessage().contains("Invalid compression"));
    }
        assertEquals(25_000, ParquetSettings.deriveBatchSizeDefault(16 * GIB, base, floor, ceil));
 * this file be licensed under the Apache-2.0 license or a
        Map<String, String> encodings = Map.of("nonexistent", "PLAIN");
            )  
        Settings settings = Settings.builder().put("index.parquet.field.name.bloom_filter_fpp", "0.01").build();  
        assertTrue(e.getMessage().contains("banana"));  
    public void testTypeEncodingInvalidEncodingValueThrows() {  
        assertEquals(131_072, ParquetSettings.deriveBatchSizeDefault(256 * GIB, base, floor, ceil)); // capped  
            IllegalArgumentException.class,  
        Settings settings = Settings.builder().put("parquet.type_encoding.int64.encoding", "DELTA_BINARY_PACKED").build();  
        assertTrue(e.getMessage().contains("INVALID"));  
        ParquetSettings.validateFieldConfigurations(encodings, Map.of(), Map.of(), schema);  
 *
            .build();
        assertEquals(100_000, ParquetSettings.deriveBatchSizeDefault(64 * GIB, base, floor, ceil)); // anchor (== ceil)
        Map<String, String> encodings = ParquetSettings.getTypeEncodings(settings);
            .putList("index.parquet.compression.value", "SNAPPY")
            .putList("index.parquet.bloom_filter_enabled.field", "name", "value")  
    // --- Case insensitivity tests ---  
    }
import org.opensearch.test.OpenSearchTestCase;
        );
    // --- All valid arrow types accepted ---
    }
    public void testEncodingCompatibilityRleInvalidForInt() {  
        int floor = ParquetSettings.MERGE_BATCH_SIZE_FLOOR;        // 12,500
        assertTrue(e.getMessage().contains("fpp"));  
        // Below anchor/8 -> clamps to floor; far above -> clamps to ceiling.
        assertEquals(50_000, ParquetSettings.deriveBatchSizeDefault(32 * GIB, base, floor, ceil));  
    }
        Map<String, Double> result = ParquetSettings.getFieldBloomFilterFpp(settings);
            IllegalArgumentException.class,  
            () -> ParquetSettings.validateFieldConfigurations(encodings, Map.of(), Map.of(), schema)
    public void testFieldSettingsInvalidCompressionThrows() {
        assertEquals(8_192, ParquetSettings.deriveBatchSizeDefault(8 * GIB, base, floor, ceil));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ParquetSettings.getTypeCompressions(settings));
        assertTrue(e.getMessage().contains("does not exist in mappings"));  
        Settings settings = Settings.builder()  
        Map<String, String> encodings = Map.of("age", "DELTA_BINARY_PACKED");
        );
    public void testEncodingCompatibilityDeltaBinaryPackedInvalidForUtf8() {
    }
            () -> ParquetSettings.validateFieldConfigurations(encodings, Map.of(), Map.of(), schema)
        Map<String, Boolean> enabled = ParquetSettings.getTypeBloomFilterEnabled(settings);
        Settings settings = Settings.builder().put("parquet.type_bloom_filter.utf8.enabled", "maybe").build();
    public void testEncodingCompatibilityByteStreamSplitInvalidForUtf8() {  
        assertEquals(Boolean.TRUE, enabled.get("utf8"));
                ParquetSettings.MERGE_BATCH_SIZE_FLOOR,
import java.util.Map;
            )  
        Map<String, String> encodings = Map.of("flag", "RLE_DICTIONARY");  
        IllegalArgumentException e = expectThrows(
            IllegalArgumentException.class,
        IllegalArgumentException e = expectThrows(  
            .put("parquet.type_bloom_filter.utf8.fpp", "0.01")  
    }
        assertEquals("SNAPPY", compressions.get("name"));
    // --- Type-level bloom filter validation tests ---
        assertTrue(e.getMessage().contains("not compatible"));  
        assertEquals(131_072, ParquetSettings.deriveBatchSizeDefault(128 * GIB, base, floor, ceil));
        int floor = ParquetSettings.MAX_ROWS_PER_VSR_FLOOR;        // 8,192
    public void testTypeEncodingInvalidArrowTypeThrows() {
    public void testMergeBatchSizeDefaultScalesWithRam() {  
        Map<String, String> encodings = Map.of("name", "BYTE_STREAM_SPLIT");
            ParquetSettings.DEFAULT_MAX_ROWS_PER_VSR,  
    public void testTypeBloomFilterValidSettings() {
import java.util.List;  
        Map<String, Long> ndv = ParquetSettings.getTypeBloomFilterNdv(settings);  
        int vsrBase = ParquetSettings.DEFAULT_MAX_ROWS_PER_VSR;
        // Matrix (total RAM -> VSR rows)  
            () -> ParquetSettings.getTypeBloomFilterEnabled(settings)
    }  
        Schema schema = new Schema(List.of(new Field("flag", FieldType.nullable(ArrowType.Bool.INSTANCE), null)));
            .putList("index.parquet.encoding.value", "DELTA_BYTE_ARRAY")
        int mrgBase = ParquetSettings.DEFAULT_MERGE_BATCH_SIZE;
        assertEquals(vsrCeil, ParquetSettings.deriveBatchSizeDefault(1024 * GIB, vsrBase, vsrFloor, vsrCeil));  
        Map<String, String> compressions = ParquetSettings.getTypeCompressions(settings);
        Schema schema = new Schema(List.of(new Field("age", FieldType.nullable(new ArrowType.Int(32, true)), null)));  
        int base = ParquetSettings.SORT_IN_MEMORY_THRESHOLD_BASE_MB;   // 32 MiB @ 64 GiB
    public void testEncodingCaseInsensitive() {
    // --- TYPE_ENCODING_SETTINGS validation tests ---  
        IllegalArgumentException e = expectThrows(
        assertEquals(12_500, ParquetSettings.deriveBatchSizeDefault(8 * GIB, base, floor, ceil));
        Settings settings = Settings.builder()
}  
        int ceil = ParquetSettings.SORT_IN_MEMORY_THRESHOLD_CEIL_MB;  // 64 MiB  
            ParquetSettings.deriveBatchSizeDefault(
        Schema schema = new Schema(List.of(new Field("flag", FieldType.nullable(ArrowType.Bool.INSTANCE), null)));
        IllegalArgumentException e = expectThrows(
            .build();  
        Settings settings = Settings.builder()  
        );  
            .putList("index.parquet.encoding.field", "name")  
        Map<String, Boolean> enabled = ParquetSettings.getTypeBloomFilterEnabled(settings);
        assertTrue(e.getMessage().contains("INVALID"));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ParquetSettings.getTypeCompressions(settings));  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ParquetSettings.getFieldCompressions(settings));
    }
    public void testFieldSettingsValidEncoding() {
    }  
        Map<String, String> encodings = Map.of("count", "RLE");
        );  
        int ceil = ParquetSettings.MAX_ROWS_PER_VSR_CEIL;         // 131,072
            .build();
    public void testTypeCompressionInvalidCompressionValueThrows() {
    }
    }  
        int ceil = ParquetSettings.MERGE_BATCH_SIZE_CEIL;         // 100,000  
                ParquetSettings.DEFAULT_MERGE_BATCH_SIZE,  
        Schema schema = new Schema(List.of(new Field("age", FieldType.nullable(new ArrowType.Int(32, true)), null)));  
        );
                ParquetSettings.MERGE_BATCH_SIZE_CEIL
        IllegalArgumentException e = expectThrows(
    }  
        int base = ParquetSettings.DEFAULT_MERGE_BATCH_SIZE;       // 100,000 @ 64 GiB
        assertTrue(e.getMessage().contains("not compatible"));
        assertTrue(e.getMessage().contains("Invalid arrow type"));
    }
        Settings settings = Settings.builder()
            () -> ParquetSettings.getTypeBloomFilterEnabled(settings)
        assertEquals(Long.valueOf(50000L), ndv.get("int64"));
        Settings settings = Settings.builder().put("parquet.type_compression.utf8.compression", "INVALID").build();
            () -> ParquetSettings.validateFieldConfigurations(encodings, Map.of(), Map.of(), schema)
    }
        Settings settings = Settings.builder().put("index.parquet.field.name.bloom_filter_ndv", "50000").build();  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ParquetSettings.getTypeEncodings(settings));
        Map<String, Double> fpp = ParquetSettings.getTypeBloomFilterFpp(settings);
    public void testTypeBloomFilterInvalidFppThrows() {  
        assertTrue(e.getMessage().contains("ndv"));  
    public void testMaxRowsPerVsrDefaultScalesWithRam() {
        assertEquals(16, ParquetSettings.deriveBatchSizeDefault(8 * GIB, base, floor, ceil));   // 4 -> floor
            .build();  
                0,
        int mrgCeil = ParquetSettings.MERGE_BATCH_SIZE_CEIL;
            () -> ParquetSettings.validateFieldConfigurations(encodings, Map.of(), Map.of(), schema)
            .putList("index.parquet.encoding.field", "name")
        );
    }
        assertTrue(e.getMessage().contains("enabled"));  
            .build();  
        assertTrue(e.getMessage().contains("INVALID"));
            ParquetSettings.deriveBatchSizeDefault(
            .putList("index.parquet.bloom_filter_enabled.value", "true", "false")
        assertTrue(e.getMessage().contains("not compatible"));
            .put("parquet.type_bloom_filter.utf8.enabled", "true")
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ParquetSettings.getFieldEncodings(settings));  
    public void testFieldSettingsInvalidEncodingThrows() {
            .putList("index.parquet.encoding.field", "name")  
package org.opensearch.parquet;
        assertEquals("DELTA_BINARY_PACKED", encodings.get("int64"));
    }  
import org.apache.arrow.vector.types.pojo.Field;  
