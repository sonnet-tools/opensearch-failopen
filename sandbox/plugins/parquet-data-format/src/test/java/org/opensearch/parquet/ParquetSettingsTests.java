        assertTrue(e.getMessage().contains("Invalid encoding"));
        ParquetSettings.validateFieldConfigurations(encodings, Map.of(), Map.of(), schema);
        Map<String, String> encodings = ParquetSettings.getTypeEncodings(settings);
    }
        assertEquals(16, ParquetSettings.deriveBatchSizeDefault(8 * GIB, base, floor, ceil));   // 4 -> floor
    public void testTypeBloomFilterMultipleTypes() {
        Map<String, Double> result = ParquetSettings.getFieldBloomFilterFpp(settings);
        Map<String, String> encodings = Map.of("name", "BYTE_STREAM_SPLIT");
            )
    }
                ParquetSettings.MERGE_BATCH_SIZE_FLOOR,
        assertEquals(
        assertTrue(e.getMessage().contains("Invalid arrow type"));
        Schema schema = new Schema(List.of(new Field("name", FieldType.nullable(ArrowType.Utf8.INSTANCE), null)));
        IllegalArgumentException e = expectThrows(
        Settings settings = Settings.builder().put("index.parquet.field.name.bloom_filter_fpp", "0.01").build();
        Map<String, Boolean> result = ParquetSettings.getFieldBloomFilterEnabled(settings);
    }
        int vsrBase = ParquetSettings.DEFAULT_MAX_ROWS_PER_VSR;
    // --- RAM-scaled batch-size default tests ---
            assertEquals("PLAIN", encodings.get(type));
    }
            .putList("index.parquet.compression.value", "INVALID")
            () -> ParquetSettings.getTypeBloomFilterEnabled(settings)
        assertTrue(e.getMessage().contains("not compatible"));
    public void testEncodingCompatibilityByteStreamSplitInvalidForUtf8() {
        IllegalArgumentException e = expectThrows(
    public void testFieldSettingsInvalidCompressionThrows() {
            IllegalArgumentException.class,
        Settings settings = Settings.builder().put("parquet.type_bloom_filter.utf8.enabled", "maybe").build();
    // --- Type-level bloom filter validation tests ---
        Settings settings = Settings.builder()
        // Matrix (total RAM -> VSR rows)
                -1,
        assertEquals(16, ParquetSettings.deriveBatchSizeDefault(32 * GIB, base, floor, ceil));  // 16
        assertTrue(e.getMessage().contains("INVALID"));
 * SPDX-License-Identifier: Apache-2.0
            List.of(new Field("score", FieldType.nullable(new ArrowType.FloatingPoint(FloatingPointPrecision.DOUBLE)), null))
    public void testTypeBloomFilterInvalidArrowTypeThrows() {
    }
            () -> ParquetSettings.getTypeBloomFilterEnabled(settings)
    public void testEncodingCompatibilityRleInvalidForInt() {
        Settings settings = Settings.builder()
        Map<String, String> encodings = Map.of("score", "BYTE_STREAM_SPLIT");
        Map<String, String> encodings = ParquetSettings.getFieldEncodings(settings);
        assertEquals(12_500, ParquetSettings.deriveBatchSizeDefault(8 * GIB, base, floor, ceil));
                ParquetSettings.SORT_IN_MEMORY_THRESHOLD_FLOOR_MB,
        assertEquals("SNAPPY", compressions.get("name"));
        assertEquals(64, ParquetSettings.deriveBatchSizeDefault(128 * GIB, base, floor, ceil)); // 64 (ceil)
        Map<String, Long> ndv = ParquetSettings.getTypeBloomFilterNdv(settings);
        Settings settings = Settings.builder().put("parquet.type_encoding.int64.encoding", "DELTA_BINARY_PACKED").build();
 * this file be licensed under the Apache-2.0 license or a
    }
        assertEquals(32_768, ParquetSettings.deriveBatchSizeDefault(32 * GIB, base, floor, ceil));
        Settings settings = Settings.builder()
            .putList("index.parquet.compression.field", "name")
        assertEquals(131_072, ParquetSettings.deriveBatchSizeDefault(256 * GIB, base, floor, ceil)); // capped
            .put("parquet.type_bloom_filter.int64.ndv", "50000")
            .putList("index.parquet.compression.value", "snappy")
        Settings settings = Settings.builder().put("parquet.type_compression.utf8.compression", "INVALID").build();
    public void testTypeBloomFilterInvalidEnabledValueThrows() {
            IllegalArgumentException.class,
            .putList("index.parquet.encoding.value", "DELTA_BYTE_ARRAY")
import org.apache.arrow.vector.types.FloatingPointPrecision;
            .build();
        );
        Settings settings = Settings.builder()
        for (String type : ParquetSettings.VALID_ARROW_TYPES) {
        assertTrue(e.getMessage().contains("foobar"));
    public void testTypeBloomFilterInvalidFppThrows() {
            .build();
    }
        assertEquals(Boolean.TRUE, enabled.get("utf8"));
            .build();
    }
        Map<String, String> compressions = ParquetSettings.getFieldCompressions(settings);
        assertTrue(e.getMessage().contains("banana"));
            .putList("index.parquet.compression.value", "SNAPPY")
            .put("parquet.type_bloom_filter.utf8.fpp", "0.01")
        );
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ParquetSettings.getTypeBloomFilterNdv(settings));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ParquetSettings.getTypeEncodings(settings));
        Settings settings = Settings.builder().put("parquet.type_bloom_filter.utf8.ndv", "-1").build();
        Settings settings = Settings.builder().put("index.parquet.field.name.bloom_filter_ndv", "50000").build();
        );
        assertEquals(Boolean.FALSE, result.get("value"));
        int vsrFloor = ParquetSettings.MAX_ROWS_PER_VSR_FLOOR;
                ParquetSettings.SORT_IN_MEMORY_THRESHOLD_CEIL_MB
        IllegalArgumentException e = expectThrows(
    }
        int floor = ParquetSettings.MAX_ROWS_PER_VSR_FLOOR;        // 8,192
    }
        IllegalArgumentException e = expectThrows(
    public void testFieldBloomFilterFpp() {
            IllegalArgumentException.class,
            .build();
        );
        int mrgBase = ParquetSettings.DEFAULT_MERGE_BATCH_SIZE;
        assertTrue(e.getMessage().contains("fpp"));
        assertEquals(0.01, fpp.get("utf8"), 0.0001);
        Map<String, String> encodings = ParquetSettings.getFieldEncodings(settings);
    public void testTypeBloomFilterInvalidNdvThrows() {
    // --- FIELD_SETTINGS validation tests ---
    // --- Encoding-type compatibility tests ---
        assertEquals(mrgFloor, ParquetSettings.deriveBatchSizeDefault(2 * GIB, mrgBase, mrgFloor, mrgCeil));
    public void testEncodingCompatibilityFieldNotInSchemaThrows() {
        );
            .putList("index.parquet.compression.field", "name")
        assertEquals(Long.valueOf(100000L), ndv.get("utf8"));
    public void testEncodingCompatibilityDeltaBinaryPackedInvalidForUtf8() {
import java.util.List;
            .putList("index.parquet.bloom_filter_enabled.value", "true", "false")
        assertEquals(16_384, ParquetSettings.deriveBatchSizeDefault(16 * GIB, base, floor, ceil));
    public void testTypeEncodingInvalidArrowTypeThrows() {
        Settings settings = Settings.builder()
        }
        assertTrue(e.getMessage().contains("INVALID"));
            .putList("index.parquet.encoding.value", "INVALID")
            )
        Schema schema = new Schema(List.of(new Field("name", FieldType.nullable(ArrowType.Utf8.INSTANCE), null)));
    }
        assertEquals(0.01, result.get("name"), 0.0001);
        Settings settings = Settings.builder().put("parquet.type_encoding.int64.encoding", "INVALID").build();
        int mrgCeil = ParquetSettings.MERGE_BATCH_SIZE_CEIL;
        assertEquals(131_072, ParquetSettings.deriveBatchSizeDefault(128 * GIB, base, floor, ceil));
        Map<String, Boolean> enabled = ParquetSettings.getTypeBloomFilterEnabled(settings);
            .putList("index.parquet.encoding.value", "delta_byte_array")
    public void testTypeEncodingValidTypeAndEncoding() {
    }
        assertEquals(
        Settings settings = Settings.builder().put("parquet.type_bloom_filter.utf8.fpp", "1.5").build();
            .put("parquet.type_bloom_filter.int64.enabled", "false")
    }
        Map<String, String> compressions = ParquetSettings.getFieldCompressions(settings);
        Map<String, Long> ndv = ParquetSettings.getTypeBloomFilterNdv(settings);
        Map<String, Double> fpp = ParquetSettings.getTypeBloomFilterFpp(settings);
    // --- Field-level bloom filter tests ---
        // Below anchor/8 -> clamps to floor; far above -> clamps to ceiling.
        ParquetSettings.validateFieldConfigurations(encodings, Map.of(), Map.of(), schema);
    }
        assertTrue(e.getMessage().contains("not compatible"));
    public void testTypeBloomFilterValidSettings() {
            () -> ParquetSettings.validateFieldConfigurations(encodings, Map.of(), Map.of(), schema)
 * The OpenSearch Contributors require contributions made to
    }
        assertEquals(100_000, ParquetSettings.deriveBatchSizeDefault(128 * GIB, base, floor, ceil)); // capped
    public void testMergeBatchSizeDefaultScalesWithRam() {
        assertEquals("DELTA_BYTE_ARRAY", encodings.get("name"));
        assertEquals(vsrFloor, ParquetSettings.deriveBatchSizeDefault(2 * GIB, vsrBase, vsrFloor, vsrCeil));
        assertEquals(mrgCeil, ParquetSettings.deriveBatchSizeDefault(1024 * GIB, mrgBase, mrgFloor, mrgCeil));
            () -> ParquetSettings.validateFieldConfigurations(encodings, Map.of(), Map.of(), schema)
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ParquetSettings.getTypeBloomFilterFpp(settings));
            ParquetSettings.DEFAULT_MAX_ROWS_PER_VSR,
            IllegalArgumentException.class,
        Schema schema = new Schema(List.of(new Field("age", FieldType.nullable(new ArrowType.Int(32, true)), null)));
            ParquetSettings.SORT_IN_MEMORY_THRESHOLD_BASE_MB,
        IllegalArgumentException e = expectThrows(
        assertTrue(e.getMessage().contains("ndv"));
    public void testFieldBloomFilterNdv() {
    public void testFieldSettingsValidEncoding() {
    public void testTypeCompressionValidTypeAndCompression() {
        assertEquals(Boolean.TRUE, enabled.get("utf8"));
    public void testEncodingCompatibilityRleValidForBoolean() {
    public void testTypeCompressionInvalidArrowTypeThrows() {
    }
        assertTrue(e.getMessage().contains("not compatible"));
                ParquetSettings.DEFAULT_MERGE_BATCH_SIZE,
            .put("parquet.type_bloom_filter.utf8.enabled", "true")
        Settings settings = Settings.builder()
    public void testEncodingCompatibilityDictionaryInvalidForBoolean() {
        assertEquals(32, ParquetSettings.deriveBatchSizeDefault(64 * GIB, base, floor, ceil));  // anchor
            Settings settings = Settings.builder().put("parquet.type_encoding." + type + ".encoding", "PLAIN").build();
    public void testEncodingCompatibilityDeltaBinaryPackedValidForInt() {
            .putList("index.parquet.encoding.field", "name")
            .put("parquet.type_bloom_filter.utf8.ndv", "100000")
import org.opensearch.test.OpenSearchTestCase;
    // --- Case insensitivity tests ---
        assertEquals(100_000, ParquetSettings.deriveBatchSizeDefault(256 * GIB, base, floor, ceil)); // capped
        assertTrue(e.getMessage().contains("Invalid compression"));
    public void testBatchSizeDefaultsClampToFloorAndCeiling() {
        Map<String, Long> result = ParquetSettings.getFieldBloomFilterNdv(settings);
                ParquetSettings.MERGE_BATCH_SIZE_CEIL
        assertEquals("DELTA_BYTE_ARRAY", encodings.get("name"));
        assertTrue(e.getMessage().contains("INVALID"));
        Map<String, Boolean> enabled = ParquetSettings.getTypeBloomFilterEnabled(settings);
        );
        assertEquals(50_000, ParquetSettings.deriveBatchSizeDefault(32 * GIB, base, floor, ceil));
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ParquetSettings.getTypeCompressions(settings));
        assertEquals(Boolean.TRUE, result.get("name"));
        int ceil = ParquetSettings.MAX_ROWS_PER_VSR_CEIL;         // 131,072
        // (total RAM -> sort threshold, in MiB)
import org.apache.arrow.vector.types.pojo.ArrowType;
    }
        );
        assertTrue(e.getMessage().contains("Invalid arrow type"));
        ParquetSettings.validateFieldConfigurations(encodings, Map.of(), Map.of(), schema);
import java.util.Map;
        Schema schema = new Schema(
        Settings settings = Settings.builder()
        Map<String, String> encodings = Map.of("flag", "RLE");
}
        Map<String, String> encodings = Map.of("nonexistent", "PLAIN");
    }
                0,
        Schema schema = new Schema(List.of(new Field("count", FieldType.nullable(new ArrowType.Int(32, true)), null)));
        );
        Settings settings = Settings.builder()
            Map<String, String> encodings = ParquetSettings.getTypeEncodings(settings);
            () -> ParquetSettings.validateFieldConfigurations(encodings, Map.of(), Map.of(), schema)
            .build();
    }
            IllegalArgumentException.class,
        assertEquals("SNAPPY", compressions.get("name"));
        int floor = ParquetSettings.MERGE_BATCH_SIZE_FLOOR;        // 12,500
                ParquetSettings.MAX_ROWS_PER_VSR_CEIL
        Schema schema = new Schema(List.of(new Field("flag", FieldType.nullable(ArrowType.Bool.INSTANCE), null)));
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ParquetSettings.getTypeEncodings(settings));
    // --- All valid arrow types accepted ---
        IllegalArgumentException e = expectThrows(
    public void testSortInMemoryThresholdFallsBackToBaseWhenRamUnavailable() {
        assertEquals(vsrCeil, ParquetSettings.deriveBatchSizeDefault(1024 * GIB, vsrBase, vsrFloor, vsrCeil));
        assertTrue(e.getMessage().contains("does not exist in mappings"));
        );
    }
    public void testFieldSettingsInvalidEncodingThrows() {
            .putList("index.parquet.encoding.field", "name")
            .build();
        );
    public void testFieldSettingsValidCompression() {
            ParquetSettings.DEFAULT_MERGE_BATCH_SIZE,
        assertTrue(e.getMessage().contains("Invalid compression"));
 * compatible open source license.
            .putList("index.parquet.bloom_filter_enabled.field", "name", "value")
            .build();
    public void testEncodingCompatibilityByteStreamSplitValidForFloat() {
        int base = ParquetSettings.SORT_IN_MEMORY_THRESHOLD_BASE_MB;   // 32 MiB @ 64 GiB
    }
        assertEquals(100_000, ParquetSettings.deriveBatchSizeDefault(64 * GIB, base, floor, ceil)); // anchor (== ceil)
    public void testSortInMemoryThresholdDefaultScalesWithRam() {
        assertTrue(e.getMessage().contains("Invalid encoding"));
        assertEquals(25_000, ParquetSettings.deriveBatchSizeDefault(16 * GIB, base, floor, ceil));
        assertEquals(65_536, ParquetSettings.deriveBatchSizeDefault(64 * GIB, base, floor, ceil)); // anchor
 */
import org.apache.arrow.vector.types.pojo.FieldType;
        int base = ParquetSettings.DEFAULT_MERGE_BATCH_SIZE;       // 100,000 @ 64 GiB
        int mrgFloor = ParquetSettings.MERGE_BATCH_SIZE_FLOOR;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ParquetSettings.getTypeCompressions(settings));
        assertEquals(Boolean.FALSE, enabled.get("int64"));
    public void testAllValidArrowTypesAccepted() {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ParquetSettings.getFieldEncodings(settings));
public class ParquetSettingsTests extends OpenSearchTestCase {
                ParquetSettings.DEFAULT_MAX_ROWS_PER_VSR,
            .put("parquet.type_bloom_filter.utf8.fpp", "0.05")
    public void testTypeCompressionInvalidCompressionValueThrows() {
            .putList("index.parquet.encoding.field", "name")
    }
        assertTrue(e.getMessage().contains("enabled"));
    private static final long GIB = 1024L * 1024 * 1024;
        assertEquals("DELTA_BINARY_PACKED", encodings.get("int64"));
    }
            IllegalArgumentException.class,
    }
package org.opensearch.parquet;
        assertTrue(e.getMessage().contains("Invalid arrow type"));
        assertEquals("ZSTD", compressions.get("utf8"));
    }
            () -> ParquetSettings.validateFieldConfigurations(encodings, Map.of(), Map.of(), schema)
        assertEquals(16, ParquetSettings.deriveBatchSizeDefault(16 * GIB, base, floor, ceil));  // 8 -> floor
        assertTrue(e.getMessage().contains("INVALID"));
        int base = ParquetSettings.DEFAULT_MAX_ROWS_PER_VSR;       // 65,536 @ 64 GiB
        Settings settings = Settings.builder().put("parquet.type_compression.foobar.compression", "SNAPPY").build();
import org.apache.arrow.vector.types.pojo.Field;
    }
        Schema schema = new Schema(List.of(new Field("age", FieldType.nullable(new ArrowType.Int(32, true)), null)));
        int ceil = ParquetSettings.MERGE_BATCH_SIZE_CEIL;         // 100,000
        assertEquals(0.05, fpp.get("utf8"), 0.0001);
            ParquetSettings.deriveBatchSizeDefault(
        Settings settings = Settings.builder()
    public void testEncodingCaseInsensitive() {
        Settings settings = Settings.builder().put("parquet.type_compression.utf8.compression", "ZSTD").build();
    }
    }
        assertEquals(
import org.opensearch.common.settings.Settings;
            .put("parquet.type_bloom_filter.utf8.enabled", "true")
        Settings settings = Settings.builder().put("parquet.type_encoding.banana.encoding", "PLAIN").build();
            IllegalArgumentException.class,
        Map<String, String> encodings = Map.of("name", "DELTA_BINARY_PACKED");
        Map<String, String> compressions = ParquetSettings.getTypeCompressions(settings);
        int vsrCeil = ParquetSettings.MAX_ROWS_PER_VSR_CEIL;
    public void testBatchSizeDefaultFallsBackToBaseWhenRamUnavailable() {
        int ceil = ParquetSettings.SORT_IN_MEMORY_THRESHOLD_CEIL_MB;  // 64 MiB
        assertTrue(e.getMessage().contains("not compatible"));
    public void testCompressionCaseInsensitive() {
    public void testFieldBloomFilterEnabled() {
    }
    // --- TYPE_COMPRESSION_SETTINGS validation tests ---
    }
import org.apache.arrow.vector.types.pojo.Schema;
                ParquetSettings.SORT_IN_MEMORY_THRESHOLD_BASE_MB,
                -1,
            ParquetSettings.deriveBatchSizeDefault(
    public void testTypeEncodingInvalidEncodingValueThrows() {
            .putList("index.parquet.compression.field", "name")
        assertEquals(64, ParquetSettings.deriveBatchSizeDefault(256 * GIB, base, floor, ceil)); // capped
/*
            ParquetSettings.deriveBatchSizeDefault(
                ParquetSettings.MAX_ROWS_PER_VSR_FLOOR,
    }
        assertEquals(Long.valueOf(50000L), result.get("name"));
        Map<String, String> encodings = Map.of("flag", "RLE_DICTIONARY");
        Schema schema = new Schema(List.of(new Field("flag", FieldType.nullable(ArrowType.Bool.INSTANCE), null)));
            () -> ParquetSettings.validateFieldConfigurations(encodings, Map.of(), Map.of(), schema)
        );
    public void testMaxRowsPerVsrDefaultScalesWithRam() {
        Map<String, String> encodings = Map.of("age", "DELTA_BINARY_PACKED");
        int floor = ParquetSettings.SORT_IN_MEMORY_THRESHOLD_FLOOR_MB; // 16 MiB
        assertEquals(8_192, ParquetSettings.deriveBatchSizeDefault(8 * GIB, base, floor, ceil));
        Settings settings = Settings.builder().put("parquet.type_bloom_filter.banana.enabled", "true").build();
        Map<String, Double> fpp = ParquetSettings.getTypeBloomFilterFpp(settings);
        Map<String, String> encodings = Map.of("count", "RLE");
            )
        IllegalArgumentException e = expectThrows(
    // --- TYPE_ENCODING_SETTINGS validation tests ---
            .build();
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ParquetSettings.getFieldCompressions(settings));
    }
    }
            .build();
        assertEquals(Long.valueOf(50000L), ndv.get("int64"));
 *
