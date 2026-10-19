        if (mapperService == null || mapperService.documentMapper() == null || mapperService.documentMapper().mappers() == null) {  
        Collections.emptyList(),
     */  
     * Minimum number of variable-width (string/binary) non-sort columns required to activate
    public static Map<String, String> getTypeEncodings(Settings nodeSettings) {
        "parquet.native.pool.merge.max",  
        "DELTA_BINARY_PACKED",
    ) {
     * that do not yet have a MapperService reference.  
            if (result.containsKey(fields.get(i))) {
                        "Invalid bloom_filter enabled value '" + s.get(key) + "' for type '" + typeName + "'. Must be true or false"  
import org.apache.arrow.vector.types.pojo.Schema;  
        Map<String, Long> result = new HashMap<>();  
    static String derivePoolMaxDefault(Settings settings, int percent) {  
    }  
            if (typeName != null && VALID_ARROW_TYPES.contains(typeName) == false) {
     * validating against {@code ArrowType.List} would wrongly accept every encoding.
    }
     * Usage: parquet.type_compression.{arrow_type}.compression=SNAPPY
    /** Whether bloom filters are enabled for Parquet columns (default false). */  
    public static Map<String, Long> getFieldBloomFilterNdv(Settings settings) {
            return "0";
                if (validValues.contains(value) == false) {  
    public static final Setting<Integer> MERGE_DEFERRED_COLUMN_THRESHOLD = Setting.intSetting(
        for (String key : groupSettings.keySet()) {
        "parquet.max_rows_per_vsr",  
     * @param totalRamBytes total physical RAM in bytes (e.g. {@code OsProbe.getTotalPhysicalMemorySize()})
        "BYTE_STREAM_SPLIT",  
        SORT_IN_MEMORY_THRESHOLD_DEFAULT,
                    + "Fields: "
            }
                }
        return normalized;  
    );
    private static <V> Map<String, V> buildFieldMap(List<String> fields, List<V> values, String configType) {
    /** Data page size limit in bytes (default 1MB). */
                result.put(fieldName, settings.getAsDouble(key, null));
    public static final Setting<Settings> TYPE_BLOOM_FILTER_SETTINGS = Setting.groupSetting("parquet.type_bloom_filter.", s -> {
        s -> {
     * Works for any parameter type the plugin contributes via {@link ParquetDataFormatPlugin#getPluginMappingParameters}.  
                        throw new IllegalArgumentException(
            BLOOM_FILTER_ENABLED_FIELD_SETTING,  
    private static Map<String, String> extractConfigMap(
            ROW_GROUP_MAX_ROWS,
        Map.entry("uint32", new ArrowType.Int(32, false)),  
        ByteSizeValue nativeLimit = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings);  
    public static final Setting<Settings> TYPE_COMPRESSION_SETTINGS = Setting.groupSetting("parquet.type_compression.", s -> {
    public static final Setting<Long> MERGE_POOL_MAX = new Setting<>(
     * [{@value #MAX_ROWS_PER_VSR_FLOOR}, {@value #MAX_ROWS_PER_VSR_CEIL}].  
        Map.entry("boolean", new ArrowType.Bool()),
    /**
        if (fields.size() != values.size()) {
import java.util.Locale;  
    private static String validateEncoding(String encoding) {
            }
        "boolean",
            PAGE_ROW_LIMIT,
     * Returns the type that encoding and compression settings apply to for a field. For a LIST  
    public static final Setting<Long> MERGE_POOL_MIN = new Setting<>(
                    throw new IllegalArgumentException("Invalid bloom_filter ndv value '" + s.get(key) + "' for type '" + typeName + "'");
                String typeName = key.substring(0, key.length() - ".compression".length());
            }  
    }
            throw new IllegalArgumentException("Invalid encoding: " + encoding + ". Valid values: " + VALID_ENCODINGS);
        for (String key : groupSettings.keySet()) {
        safeTotalRamBytes(),
        Set.of(ArrowType.Int.class, ArrowType.Timestamp.class, ArrowType.Date.class, ArrowType.Time.class, ArrowType.Duration.class),
        Setting.Property.NodeScope,  
        s -> derivePoolMinDefault(s, 1),
                    throw new IllegalArgumentException("Invalid " + nameLabel + " '" + name + "'. Valid values: " + validNames);  
            SORT_IN_MEMORY_THRESHOLD,  
package org.opensearch.parquet;
        Setting.Property.IndexScope,
            } else if (key.endsWith(".fpp")) {  
     *        parquet.type_bloom_filter.{arrow_type}.ndv=50000
            VALID_ENCODINGS,
     * Computes the default for a pool max as a percentage of
 * this file be licensed under the Apache-2.0 license or a
                if (VALID_ARROW_TYPES.contains(typeName) == false) {
            if (Boolean.TRUE.equals(entry.getValue())) {  
import org.apache.arrow.vector.types.FloatingPointPrecision;
            ArrowType arrowType = arrowTypes.get(fieldName);
        "float32",  
                }
     *  (anchor 32 MiB @ 64 GiB), clamped to [16 MiB, 64 MiB]. */
     * Group setting for per-type compression configuration (cluster-level fallback).
            if (key.startsWith("index.parquet.field.") && key.endsWith(".bloom_filter_fpp")) {  
                    }
            ArrowType.FixedSizeBinary.class
    public static void validateFieldConfigurations(  
        Set<String> enabled = new java.util.HashSet<>();
        Collections.emptyList(),  
        Map<String, String> fieldCompressions,
        "timestamp"  
    }
                } catch (NumberFormatException e) {  
    public static boolean isEncodingValidForArrowType(String encoding, ArrowType arrowType) {
        Set<String> validNames,
        Setting.Property.IndexScope,  
                            + "'. Valid values: "
        "index.parquet.page_row_limit",
            COMPRESSION_TYPE,  
        "RLE",  
                }
        "index.parquet.encoding.value",
            String typeName = mappedFieldType.typeName();  
    public static List<Setting<?>> getSettings() {
        Collections.emptyList(),
        Setting.Property.NodeScope  
        }  
        Setting.Property.IndexScope
                throw new IllegalArgumentException("Field '" + fieldName + "' in encoding configuration does not exist in mappings");
        Set<String> lowCardinalityEnabledFields,
            if (key.endsWith(keySuffix)) {  
            SORT_IN_MEMORY_THRESHOLD_BASE_MB,  
        0.1,
     */
    public static Map<String, String> getFieldCompressions(Settings settings) {
    private static <T> Map<String, T> extractConfigMap(Settings groupSettings, String keySuffix, Function<String, T> valueParser) {  
        Setting.Property.Dynamic
        if (!VALID_COMPRESSIONS.contains(normalized)) {  
            MERGE_POOL_MIN,  
    static final long BATCH_SIZE_ANCHOR_RAM_BYTES = 64L * 1024 * 1024 * 1024;
        "utf8",  
                    throw new IllegalArgumentException("Invalid arrow type '" + typeName + "'. Valid values: " + VALID_ARROW_TYPES);
        "int8",
        return Long.toString(pool);  
                throw new IllegalArgumentException(
        Set<String> validValues,
        "DELTA",  
     * Group setting for per-type bloom filter configuration (cluster-level fallback).
            TYPE_COMPRESSION_SETTINGS,  
    }  
        for (String key : s.keySet()) {
import org.apache.arrow.vector.types.TimeUnit;  
    /** Dictionary page size limit in bytes (default 2MB). */
        }
                }
        if (fields.isEmpty() && values.isEmpty()) {  
    public static Map<String, String> getTypeCompressions(Settings nodeSettings) {
import java.util.Set;
    private static ArrowType elementTypeOf(Field field) {
        "index.parquet.dict_size_bytes",  
    }
        "index.parquet.bloom_filter_enabled",
        "int64",
            if (key.endsWith(".compression")) {
                            "bloom_filter fpp for type '" + typeName + "' must be between 0.0 and 1.0 exclusive, got: " + fpp  
                    "Field '" + fieldName + "' in bloom_filter_enabled configuration does not exist in mappings"  
            BLOOM_FILTER_FPP,  
    public static final Setting<List<String>> BLOOM_FILTER_ENABLED_FIELD_SETTING = Setting.listSetting(  
        "index.parquet.compression.field",
        if (field.getType() instanceof ArrowType.List && field.getChildren().isEmpty() == false) {
        Function.identity(),
     */
        for (String key : s.keySet()) {  
     */
    }  
    }
        }  
        Set.of(ArrowType.Utf8.class, ArrowType.LargeUtf8.class, ArrowType.Binary.class, ArrowType.LargeBinary.class),  
import org.opensearch.common.settings.Settings;  
                if (arrowType != null && isEncodingValidForArrowType(value, arrowType) == false) {
        "uint16",  
        } catch (Exception e) {
        "index.parquet.bloom_filter_fpp",  
     */
    public static final Set<String> VALID_ENCODINGS = Set.of(
        safeTotalRamBytes(),
                );
                    + ", Values: "
                String name = key.substring(0, key.length() - keySuffix.length());
     * @param floor         fixed lower bound
        "LZ4_RAW",
    );
        return Collections.unmodifiableMap(result);  
                enabled.add(entry.getKey());
    static final int SORT_IN_MEMORY_THRESHOLD_BASE_MB = 32;
    /** Maximum bytes the native merge pool can burst to. Default is 3% of node.native_memory.limit. */
    );  
        s -> {
        }
            }
        Setting.Property.IndexScope  
                String value = s.get(key).toUpperCase(Locale.ROOT);  
        MAX_ROWS_PER_VSR_CEIL
        return result;
                        "Invalid encoding '" + s.get(key) + "' for type '" + typeName + "'. Valid values: " + VALID_ENCODINGS
        },
                }  
     * deferred data loading during merge. Below this threshold, all columns are decoded eagerly
    public static final Setting<List<String>> COMPRESSION_VALUE_SETTING = Setting.listSetting(  
    );
    public static final Setting<Long> WRITE_POOL_MAX = new Setting<>(
     *             {@code mapperService} to enable full validation.  
            throw new IllegalArgumentException("Invalid boolean value: " + value + ". Must be true or false");
 * compatible open source license.
    );
        "parquet.native.pool.write.min",  
    static int deriveBatchSizeDefault(long totalRamBytes, int base, int floor, int ceil) {
    }  
            }  
     * Tuned base (64 GiB anchor) and fixed bounds, in MiB, for the RAM-scaled  
    static final int SORT_IN_MEMORY_THRESHOLD_CEIL_MB = 64;  
        "DELTA",
        Collections.emptyList(),
        if ("PLAIN".equals(encoding)) {  
    );
            return v;
        return Collections.unmodifiableSet(enabled);
     * @deprecated Use the overload that accepts {@code lowCardinalityEnabledFields} and
                    throw new IllegalArgumentException(
    /**
    );
        );
    );
    public static final Setting<ByteSizeValue> SORT_IN_MEMORY_THRESHOLD = Setting.byteSizeSetting(
     * Only keyword and text field types are accepted for low_cardinality_enable.
        Setting.Property.Dynamic
    public static final Setting<Integer> MERGE_IO_THREADS = Setting.intSetting(
                throw new IllegalArgumentException("Setting [parquet.native.pool.merge.min] must be >= 0, got " + v);
        MapperService mapperService  
     */
            return false;
            "arrow type",
        Set<Class<? extends ArrowType>> validTypes = ENCODING_TO_VALID_TYPES.get(encoding);  
    }  
     * Maps each encoding to the set of ArrowType classes it supports.
            TYPE_COMPRESSION_SETTINGS.get(nodeSettings),
                if (VALID_COMPRESSIONS.contains(value) == false) {
    /**  
            ENCODING_VALUE_SETTING,  
        for (String fieldName : fieldBloomFilterEnabled.keySet()) {  
import org.opensearch.monitor.os.OsProbe;  
        Map.entry("int64", new ArrowType.Int(64, true)),  
    /** Fixed bounds for the RAM-scaled {@code parquet.max_rows_per_vsr} default (user-set values are unbounded). */
    static final int MERGE_BATCH_SIZE_CEIL = 100_000;  
     * Extracts per-type encoding map from node settings.
        }
            safeTotalRamBytes(),
     */
                        "Invalid "
                    double fpp = Double.parseDouble(s.get(key));  
        String keySuffix,
        }  
import org.opensearch.index.mapper.ParametrizedFieldMapper;
    /**
    public static final Setting<Integer> ROW_GROUP_MAX_ROWS = Setting.intSetting(  
    /** Compression level for the chosen codec (default 2, range 1–9). */  
            "encoding"  
        return buildFieldMap(ENCODING_FIELD_SETTING.get(settings), ENCODING_VALUE_SETTING.get(settings), "encoding");
    public static Map<String, Long> getTypeBloomFilterNdv(Settings nodeSettings) {  
        Map<String, Boolean> fieldBloomFilterEnabled,  
        Setting.Property.IndexScope
        if ("true".equals(normalized)) {
     * Group setting for per-type encoding configuration (cluster-level fallback).
     * (linearly, anchored at 64 GiB → {@value #DEFAULT_MAX_ROWS_PER_VSR}), clamped to
                typeName = key.substring(0, key.length() - ".ndv".length());
        Setting.Property.Final
                    + configType
            return v;
    );
    );
     */
 * Settings for Parquet data format.  
        deriveBatchSizeDefault(
     * Overload that omits low_cardinality validation — kept for backward compatibility with callers
        Set.of(
    );  
    public static final Setting<Integer> MERGE_RAYON_THREADS = Setting.intSetting(  
                    "Field '" + fieldName + "' in low_cardinality_enable configuration does not exist in mappings"  
    );
        1,  
     */  
            if (!"keyword".equals(typeName) && !"text".equals(typeName)) {
            long v = Long.parseLong(s);  
    /**  
     * RAM-scaled defaults, computed once at class load (total RAM is constant per node).  
    /** Number of Tokio IO threads for async disk writes during merge (default num_cores/2, min 1). */
                );
    }
    public static final Setting<ByteSizeValue> DICT_SIZE_BYTES = Setting.byteSizeSetting(
                    + fields  
    public static final Setting<ByteSizeValue> PAGE_SIZE_BYTES = Setting.byteSizeSetting(
    /** Returns the field names whose {@code low_cardinality} mapping parameter resolves to {@code true}, read from the mapping. */
            ArrowType.Binary.class,
        }
     */
        },
            if (key.endsWith(keySuffix)) {  
            if (!isEncodingValidForArrowType(encoding, arrowType)) {  
            SORT_IN_MEMORY_THRESHOLD_CEIL_MB
    /** Tuned base (64 GiB anchor) and fixed bounds for the RAM-scaled {@code index.parquet.merge_batch_size} default. */  
        s -> derivePoolMaxDefault(s, DiscoveryNode.isWarmNode(s) ? 4 : 8),
                    }  
                        + "' has type '"
        Map.entry("float32", new ArrowType.FloatingPoint(FloatingPointPrecision.SINGLE)),
            }
                        throw new IllegalArgumentException("bloom_filter ndv for type '" + typeName + "' must be >= 1, got: " + ndv);
        }
    );
     * and validating the value against a set of valid values.  
    /** Maximum number of rows per row group (default 1000000). */
     */
import org.opensearch.cluster.node.DiscoveryNode;
                    + values
                    );
        s -> {
            MAX_ROWS_PER_VSR,
        Schema schema,
        Map<String, String> result = new HashMap<>();
        return result;
     * Returns a map of field name to the resolved value of the given mapping parameter, for fields that expose it.
            BLOOM_FILTER_ENABLED_FIELD_SETTING.get(settings),
        s -> {
        }
                String fieldName = key.substring("index.parquet.field.".length(), key.length() - ".bloom_filter_fpp".length());
        s -> derivePoolMinDefault(s, DiscoveryNode.isWarmNode(s) ? 2 : 4),
            }  
    public static Map<String, String> getFieldEncodings(Settings settings) {
            if (mapper instanceof ParametrizedFieldMapper) {
                            + " '"
            }  
                throw new IllegalArgumentException("Setting [parquet.native.pool.write.min] must be >= 0, got " + v);
        "uint64",
                );  
    /**
    );  
            if (mappedFieldType == null) {
     * (original behavior). Set to 0 to always defer; set very high to disable deferral.  
    public static final String LOW_CARDINALITY_PARAM = "low_cardinality";  
     * (settings sync, index creation). If called on the write path, cache the result by mapping version.  
        DEFAULT_MERGE_BATCH_SIZE,
                throw new IllegalArgumentException("Setting [parquet.native.pool.merge.max] must be >= 0, got " + v);
            VALID_ARROW_TYPES,  
import java.util.Collections;  
            WRITE_POOL_MAX,
     * with no scaling/clamping applied.  
     */
    }  
    }
import java.util.function.Function;  
        MERGE_BATCH_SIZE_DEFAULT,  
                result.put(name, valueParser.apply(groupSettings.get(key)));
        Math.max(1, Runtime.getRuntime().availableProcessors() / 2),
            if (v < 0) {
     */
        Map.entry("int32", new ArrowType.Int(32, true)),
            return true;  
    /**  
        "DELTA_BINARY_PACKED",  
                String name = key.substring(0, key.length() - keySuffix.length());
     * each chunk flush transiently reserves ~2× this on the write pool.
     * Any failure reading RAM falls back to the tuned base value (see {@link #safeTotalRamBytes()}).
            return field.getChildren().get(0).getType();  
        "index.parquet.row_group_max_rows",
                }
    public static final String POOL_WRITE = "write";  
     * settings always resolve to a sane value (and class initialization never fails) even if the
        ),  
        }
     * Returns total physical RAM in bytes, or {@code -1} if it cannot be read for any reason.  
            BLOOM_FILTER_ENABLED,
            String typeName = null;  
                typeName = key.substring(0, key.length() - ".fpp".length());
            return Long.toString(Long.MAX_VALUE);  
            long v = Long.parseLong(s);  
        Setting.Property.NodeScope,  
            }
        Map.entry("uint64", new ArrowType.Int(64, false)),
            return Collections.emptyMap();
                Object value = ((ParametrizedFieldMapper) mapper).mappingPluginParameterValues().get(parameterName);  
    public static final Setting<Integer> MERGE_BATCH_SIZE = Setting.intSetting(
        // Validate encoding configurations
        }
        Setting.Property.IndexScope  
    private static final Map<String, Set<Class<? extends ArrowType>>> ENCODING_TO_VALID_TYPES = Map.of(
    public static void validateFieldConfigurations(  
            }
        return buildFieldMap(
        0.0,
            if (v < 0) {
                        + typeName  
        for (Mapper mapper : mapperService.documentMapper().mappers()) {
                            + " '"
    }
            return Collections.emptyMap();
    public static final Set<String> VALID_COMPRESSIONS = Set.of("ZSTD", "SNAPPY", "GZIP", "BROTLI", "LZ4_RAW", "UNCOMPRESSED");
            }  
                if ("true".equals(val) == false && "false".equals(val) == false) {
        return result;
            TYPE_BLOOM_FILTER_SETTINGS
        Map.entry("uint8", new ArrowType.Int(8, false)),
            }  
                    throw new IllegalArgumentException("Invalid bloom_filter fpp value '" + s.get(key) + "' for type '" + typeName + "'");
            MERGE_BATCH_SIZE,  
        for (String key : settings.keySet()) {
     *        parquet.type_bloom_filter.{arrow_type}.fpp=0.01
        "index.parquet.bloom_filter_enabled.field",
            throw new IllegalArgumentException(
            }  
        Setting.Property.Dynamic
     */
     * Validates that field-level configurations are compatible with their Arrow types in the schema.  
        "DELTA_LENGTH_BYTE_ARRAY",
        }
        "index.parquet.page_size_bytes",  
        Setting.Property.IndexScope
                result.put(name, value);
import org.apache.arrow.vector.types.pojo.ArrowType;
            ROW_GROUP_MAX_BYTES,
        ByteSizeUnit.MB
     * machine ({@link #BATCH_SIZE_ANCHOR_RAM_BYTES}), and clamps the result to [{@code floor}, {@code ceil}].  
    /**
        "uint8",
            COMPRESSION_FIELD_SETTING,
        ByteSizeValue nativeLimit = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings);
            // Memory unavailable — fall back to the tuned default, no calculation.  
        1L,
    private static final int MERGE_BATCH_SIZE_DEFAULT = deriveBatchSizeDefault(  
            ArrowType.LargeUtf8.class,
    /**
        "parquet.native.pool.merge.min",  
            ENCODING_FIELD_SETTING,
                String val = s.get(key).toLowerCase(Locale.ROOT);  
    );
            org.opensearch.index.mapper.MappedFieldType mappedFieldType = mapperService.fieldType(fieldName);  
                    throw new IllegalArgumentException("Encoding '" + value + "' is not compatible with arrow type '" + typeName + "'");  
        Map<String, T> result = new HashMap<>();
     * If RAM is unavailable ({@code totalRamBytes <= 0}), falls back to the tuned default {@code base}
    );
        },
        long scaled = Math.round((double) base * factor);
                            + name  
            "bloom_filter_enabled"
            DICT_SIZE_BYTES,
    }
    public static Set<String> getFieldsWithParameterEnabled(MapperService mapperService, String parameterName) {
     * Batch size for reading records during merge. Default scales with total RAM  
    );
            long v = Long.parseLong(s);  
                String fieldName = key.substring("index.parquet.field.".length(), key.length() - ".bloom_filter_ndv".length());  
            long v = Long.parseLong(s);  
        MAX_ROWS_PER_VSR_DEFAULT,
    /**
     * Extracts a config map from group settings by matching keys with a given suffix,
                String value = groupSettings.get(key).toUpperCase(Locale.ROOT);
        }
}
            if (v < 0) {
        for (String key : s.keySet()) {
        "RLE",
                String typeName = key.substring(0, key.length() - ".encoding".length());  
            if (key.endsWith(".enabled")) {
        Math.max(1, Runtime.getRuntime().availableProcessors() / 2),
            ArrowType.LargeBinary.class,  
            }
     */  
    public static Map<String, Object> getFieldParameterValues(MapperService mapperService, String parameterName) {
            return v;
    );  
        "DELTA_BYTE_ARRAY",
                            + validValues
                            + "' for "  
    }
            BLOOM_FILTER_ENABLED_VALUE_SETTING.get(settings),  
                String value = s.get(key).toUpperCase(Locale.ROOT);
        for (String fieldName : lowCardinalityEnabledFields) {  
        s -> derivePoolMaxDefault(s, 3),
            }
    /** Number of Rayon threads for parallel column encoding during merge (default num_cores/2, min 1). */
    // Field-level bloom filter enabled configuration (parallel arrays)
        Map.entry("int16", new ArrowType.Int(16, true)),
        }
    ) {  
        Setting.Property.NodeScope
                throw new IllegalArgumentException("Field '" + fieldName + "' in compression configuration does not exist in mappings");
        "PLAIN",
        }
        Schema schema
        if (totalRamBytes <= 0) {
        },
        return validTypes.contains(arrowType.getClass());
    );  
import org.apache.arrow.vector.types.pojo.Field;
    /** Bloom filter number of distinct values hint (default 100000). */
     * The base value is the default tuned on the anchor machine, and {@code factor = totalRamBytes / anchor}.
            TYPE_ENCODING_SETTINGS.get(nodeSettings),
    /** Maximum byte size per row group (default 128MB). */
        "index.parquet.bloom_filter_enabled.value",  
        "float64",
    }  
            return OsProbe.getInstance().getTotalPhysicalMemorySize();
        Map.entry("uint16", new ArrowType.Int(16, false)),
    );
                throw new IllegalArgumentException(
        "index.parquet.compression_level",
        ParquetSettings::validateCompression,  
    }  
        for (int i = 0; i < fields.size(); i++) {
                throw new IllegalArgumentException("Duplicate field '" + fields.get(i) + "' in index.parquet." + configType + ".field");  
        "index.parquet.row_group_max_bytes",  
        );
            "arrow type",
    /** Returns all settings defined by the Parquet plugin. */  
    public static Map<String, Double> getTypeBloomFilterFpp(Settings nodeSettings) {
    );  
    );
        String valueLabel
    }, Setting.Property.NodeScope, Setting.Property.Dynamic);
        Map.entry("date", new ArrowType.Date(DateUnit.DAY)),
        for (String key : settings.keySet()) {
    static String derivePoolMinDefault(Settings settings, int percent) {
     * [{@value #MERGE_BATCH_SIZE_FLOOR}, {@value #MERGE_BATCH_SIZE_CEIL}].
        try {  
     * Reads all keys under "parquet.type_compression.{arrow_type}.compression".  
    }, Setting.Property.NodeScope, Setting.Property.Dynamic);
                    + configType  
            return -1L;  
            MERGE_RAYON_THREADS,
    );
    }
     */
        Setting.Property.IndexScope,  
    }
import org.opensearch.common.settings.Setting;
    public static final Setting<Integer> MAX_ROWS_PER_VSR = Setting.intSetting(
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
    );
    public static Map<String, Boolean> getFieldBloomFilterEnabled(Settings settings) {  
        9,
 *
    /**
                );
     * A negative result drives {@link #deriveBatchSizeDefault} to the tuned base default, ensuring
        Set.of(ArrowType.Int.class, ArrowType.Timestamp.class, ArrowType.Date.class, ArrowType.Time.class, ArrowType.Duration.class),
        if (validTypes == null) {
            ArrowType.Utf8.class,  
        Collections.emptyList(),  
/**
    /**
    );
    static final int MAX_ROWS_PER_VSR_CEIL = 131_072;
        );
        "RLE_DICTIONARY",
        DEFAULT_MAX_ROWS_PER_VSR,
    }  
     * OS probe throws.  
        if (nativeLimit.getBytes() <= 0) {
        Setting.Property.IndexScope
        for (Map.Entry<String, Object> entry : values.entrySet()) {
        return buildFieldMap(COMPRESSION_FIELD_SETTING.get(settings), COMPRESSION_VALUE_SETTING.get(settings), "compression");  
    public static final int DEFAULT_MAX_ROWS_PER_VSR = 65_536;
     * @param base          tuned default at the 64 GiB anchor (also the fallback value)  
        ),
        1.0,  
        Setting.Property.Final
                    result.put(mapper.name(), value);
            return v;
        Setting.Property.IndexScope,
        Function.identity(),  
        if (nativeLimit.getBytes() <= 0) {
        "parquet.merge_io_threads",  
        Setting.Property.NodeScope,  
        }
    private static String validateCompression(String compression) {
            if (!arrowTypes.containsKey(fieldName)) {  
        Setting.Property.NodeScope,  
        Map<String, V> result = new HashMap<>();  
        }  
            COMPRESSION_VALUE_SETTING,
        Setting.Property.Final  
    public static final Setting<Integer> PAGE_ROW_LIMIT = Setting.intSetting(  
        Map<String, ArrowType> arrowTypes = new HashMap<>();
    /**
            WRITE_POOL_MIN,
     * @param ceil          fixed upper bound
        Map<String, String> fieldCompressions,
    public static final Set<String> VALID_ARROW_TYPES = Set.of(  
                if (VALID_ENCODINGS.contains(value) == false) {
        ParquetSettings::validateEncoding,
    );  
    static final int MERGE_BATCH_SIZE_FLOOR = 12_500;
    );
    private static long safeTotalRamBytes() {
    public static final int DEFAULT_MERGE_BATCH_SIZE = 100_000;
        "parquet.merge_rayon_threads",
    public static final String POOL_MERGE = "merge";
    static final int MAX_ROWS_PER_VSR_FLOOR = 8_192;  
                typeName = key.substring(0, key.length() - ".enabled".length());
            String fieldName = entry.getKey();  
        0,
        Setting.Property.IndexScope  
    /**  
        Map<String, Object> values = getFieldParameterValues(mapperService, parameterName);  
    public static Map<String, Double> getFieldBloomFilterFpp(Settings settings) {  
     * Maximum rows per VectorSchemaRoot before rotation is triggered. Default scales with total RAM
        Map.entry("utf8", new ArrowType.Utf8()),
        if (!VALID_ENCODINGS.contains(normalized)) {
        for (Field field : schema.getFields()) {  
        }
        String normalized = value.toLowerCase(Locale.ROOT);
                            + groupSettings.get(key)
        Map.entry("int8", new ArrowType.Int(8, true)),  
                throw new IllegalArgumentException("Setting [parquet.native.pool.write.max] must be >= 0, got " + v);
     * Usage: parquet.type_encoding.{arrow_type}.encoding=DELTA_BINARY_PACKED  
        100_000L,
        // Validate low_cardinality_enable fields: must exist and be keyword or text type
     */
            }
        "DELTA_LENGTH_BYTE_ARRAY",
 */  
    /** Maximum number of rows per data page (default 20000). */
        return List.of(
    private static final ByteSizeValue SORT_IN_MEMORY_THRESHOLD_DEFAULT = new ByteSizeValue(  
        }
        "binary",
    public static Map<String, Boolean> getTypeBloomFilterEnabled(Settings nodeSettings) {
                    );
    /**
        ParquetSettings::validateBoolean,
            TYPE_ENCODING_SETTINGS,
        Setting.Property.Dynamic
    // Field-level compression configuration (parallel arrays)  
        if ("RLE_DICTIONARY".equals(encoding) || "DICTIONARY".equals(encoding)) {  
        Set.of(ArrowType.Int.class, ArrowType.FloatingPoint.class, ArrowType.FixedSizeBinary.class)
     * {@link ResourceTrackerSettings#NODE_NATIVE_MEMORY_LIMIT_SETTING}.
        new ByteSizeValue(1, ByteSizeUnit.MB),
                "index.parquet."  
                        );
        Map<String, String> fieldEncodings,
                if (VALID_ARROW_TYPES.contains(typeName) == false) {  
    /**
            SORT_IN_MEMORY_THRESHOLD_FLOOR_MB,
        "index.parquet.bloom_filter_ndv",  
                ArrowType arrowType = ARROW_TYPE_NAME_TO_INSTANCE.get(typeName);
                    if (ndv < 1) {
        }  
     *
            );  
     * e.g. parquet.type_compression.utf8.compression=SNAPPY  
    /**  
    }, Setting.Property.NodeScope, Setting.Property.Dynamic);  
     * Scales a batch-size default linearly with total physical RAM, anchored at the 64 GiB benchmark
        String nameLabel,  
import org.opensearch.core.common.unit.ByteSizeUnit;
    public static final Map<String, ArrowType> ARROW_TYPE_NAME_TO_INSTANCE = Map.ofEntries(
     * Extracts a typed config map from group settings by matching keys with a given suffix  
        Setting.Property.IndexScope
            if (!arrowTypes.containsKey(fieldName)) {
    /**
    }
        20000,
        Setting.Property.IndexScope
        Map<String, Object> result = new HashMap<>();  
                    );
        Setting.Property.Final  
    );
        return extractConfigMap(TYPE_BLOOM_FILTER_SETTINGS.get(nodeSettings), ".enabled", Boolean::parseBoolean);
        "int32",  
    /** Maps arrow type name strings to representative ArrowType instances for compatibility checks. */
        }  
    /** Maximum bytes the native write pool can burst to. Default is 4% of budget on warm nodes, 8% otherwise. */
     * Computes the default for a pool min as a percentage of
        0,
        1,
    );
    /**
        Map<String, Double> result = new HashMap<>();
     * e.g. parquet.type_encoding.int64.encoding=DELTA_BINARY_PACKED
    public static final Setting<List<String>> ENCODING_VALUE_SETTING = Setting.listSetting(
        Setting.Property.Final
        "index.parquet.sort_in_memory_threshold",  
                }  
        Map.entry("float64", new ArrowType.FloatingPoint(FloatingPointPrecision.DOUBLE)),  
                        + fieldName
        Setting.Property.IndexScope
    public static final Setting<Integer> COMPRESSION_LEVEL = Setting.intSetting(
        1,  
     * (VSR rows, merge rows, and sort-threshold MiB) were measured on a 64 GiB machine; defaults
import org.opensearch.index.mapper.Mapper;  
                    if (fpp <= 0.0 || fpp >= 1.0) {
        1,
    public static final Setting<List<String>> ENCODING_FIELD_SETTING = Setting.listSetting(
    public static final Setting<Settings> TYPE_ENCODING_SETTINGS = Setting.groupSetting("parquet.type_encoding.", s -> {  
     * Reads all keys under "parquet.type_encoding.{arrow_type}.encoding".  
        MERGE_BATCH_SIZE_CEIL
        } else {  
    public static final Setting<Long> WRITE_POOL_MIN = new Setting<>(
                );
        MAX_ROWS_PER_VSR_FLOOR,  
                }  
    }
    }
        );
     * Anchor used to scale the batch/sort defaults with machine memory. The tuned base values
                    "low_cardinality_enable is only supported for keyword and text fields, but field '"  
            MERGE_POOL_MAX,
    public static final Setting<List<String>> COMPRESSION_FIELD_SETTING = Setting.listSetting(
        Map.entry("timestamp", new ArrowType.Timestamp(TimeUnit.MILLISECOND, null))
            return true;
                }
        return (int) Math.max(floor, Math.min(ceil, scaled));
    public static final Setting<String> COMPRESSION_TYPE = Setting.simpleString(  
        }
                    long ndv = Long.parseLong(s.get(key));  
        String normalized = compression.toUpperCase(Locale.ROOT);
            return true;
            throw new IllegalArgumentException("Invalid compression: " + compression + ". Valid values: " + VALID_COMPRESSIONS);
    public static final Setting<Boolean> BLOOM_FILTER_ENABLED = Setting.boolSetting(
import org.opensearch.core.common.unit.ByteSizeValue;
        Setting.Property.IndexScope
        "BYTE_STREAM_SPLIT"
     * column that is the element type, because Parquet encodes the leaf, not the list wrapper —
        false,  
        Setting.Property.Final
        Setting.Property.IndexScope,
    /** Compression codec for Parquet files, e.g. ZSTD, SNAPPY, LZ4_RAW (default LZ4_RAW). */
        Setting.Property.Dynamic
    /** Minimum guaranteed bytes for the native write pool. Default is 2% of budget on warm nodes, 4% otherwise. */
    private static Boolean validateBoolean(String value) {  
     * Extracts per-type compression map from node settings.
    /** Minimum guaranteed bytes for the native merge pool. Default is half of merge max (1% of budget). */
        return extractConfigMap(  
    }
                    throw new IllegalArgumentException("Invalid arrow type '" + typeName + "'. Valid values: " + VALID_ARROW_TYPES);
        Setting.Property.IndexScope
        new ByteSizeValue(2, ByteSizeUnit.MB),
     * Builds a field configuration map from parallel arrays.  
    // Field-level encoding configuration (parallel arrays)
                result.put(fieldName, settings.getAsLong(key, null));
            if (!arrowTypes.containsKey(fieldName)) {
    /**
public final class ParquetSettings {
     * Falls back to {@link Long#MAX_VALUE} when AC is unconfigured.
                throw new IllegalArgumentException("Invalid arrow type '" + typeName + "'. Valid values: " + VALID_ARROW_TYPES);  
import java.util.HashMap;
            }
     * and converting the raw string value using the provided parser.
     *
    }
                if (validNames != null && validNames.contains(name) == false) {
    /**  
        for (Map.Entry<String, String> entry : fieldEncodings.entrySet()) {
        Map<String, String> fieldEncodings,
                    throw new IllegalArgumentException(
    );
     * <p>This performs a linear scan of the document mapper's fields and is intended for cold paths
    private ParquetSettings() {}
    public static final Setting<Long> BLOOM_FILTER_NDV = Setting.longSetting(
        "index.parquet.compression_type",
 * The OpenSearch Contributors require contributions made to  
        }  
     */  
        "index.parquet.compression.value",
    /** Bloom filter false positive probability (default 0.1). */
                            + valueLabel  
        }  
        "index.parquet.encoding.field",  
        Settings groupSettings,  
        return extractConfigMap(TYPE_BLOOM_FILTER_SETTINGS.get(nodeSettings), ".ndv", Long::parseLong);
        1,  
                    + ".field and index.parquet."
    }
                throw new IllegalArgumentException(
        return result;
            ".encoding",
     */
                        "Invalid compression '" + s.get(key) + "' for type '" + typeName + "'. Valid values: " + VALID_COMPRESSIONS  
    private static final int MAX_ROWS_PER_VSR_DEFAULT = deriveBatchSizeDefault(  
        1,
    }  
                    "Field '" + fieldName + "' in low_cardinality_enable configuration does not exist in mappings"  
                throw new IllegalArgumentException(
                            + nameLabel
import org.opensearch.index.mapper.MapperService;
     */
        return getFieldsWithParameterEnabled(mapperService, LOW_CARDINALITY_PARAM);
        Map.entry("binary", new ArrowType.Binary()),  
    /** File size threshold for in-memory sort vs streaming merge sort. Default scales with total RAM  
     * Returns 0 when AC is unconfigured (unlike max which returns Long.MAX_VALUE).  
    );
 * SPDX-License-Identifier: Apache-2.0
     *
        "parquet.native.pool.write.max",  
        return extractConfigMap(TYPE_BLOOM_FILTER_SETTINGS.get(nodeSettings), ".fpp", Double::parseDouble);  
        1_000_000,
            return base;
            } else if (key.endsWith(".ndv")) {  
     */
                    throw new IllegalArgumentException(  
    /**
    );
    public static final Setting<ByteSizeValue> ROW_GROUP_MAX_BYTES = Setting.byteSizeSetting(
    ) {
        "int16",
            return DICTIONARY_INCOMPATIBLE_TYPES.contains(arrowType.getClass()) == false;
            MERGE_DEFERRED_COLUMN_THRESHOLD,  
            }  
        Map<String, Boolean> fieldBloomFilterEnabled,  
        1,
    /**
        return Long.toString(Math.max(0L, nativeLimit.getBytes() * percent / 100));
     * PLAIN and unknown encodings are valid for all types (handled separately).
        Set.of(ArrowType.Bool.class),  
                    );  
        "index.parquet.merge_deferred_column_threshold",  
        // Validate bloom filter field existence
            MERGE_IO_THREADS,
            }
        return result;
        double factor = (double) totalRamBytes / BATCH_SIZE_ANCHOR_RAM_BYTES;  
import java.util.Map;
import org.apache.arrow.vector.types.DateUnit;
        "DELTA_BYTE_ARRAY",  
    /** Set of ArrowType classes that do NOT support dictionary encoding. */
    private static final Set<Class<? extends ArrowType>> DICTIONARY_INCOMPATIBLE_TYPES = Set.of(ArrowType.Bool.class);
            BLOOM_FILTER_ENABLED_VALUE_SETTING,
        Setting.Property.NodeScope  
                }  
    public static Set<String> getLowCardinalityEnabledFields(MapperService mapperService) {  
        }
            arrowTypes.put(field.getName(), elementTypeOf(field));
     */  
            if (arrowType == null) {  
        } else if ("false".equals(normalized)) {
     */
        "date",
        Setting.Property.IndexScope,  
        "uint32",
     */  
        }
        // Validate compression field existence
        long pool = Math.max(0L, nativeLimit.getBytes() * percent / 100);
    );  
                try {
            String encoding = entry.getValue();
        return field.getType();
        2,  
     * Returns the field names whose given boolean mapping parameter resolves to {@code true}, read from the mapping.
        "index.parquet.merge_batch_size",
            PAGE_SIZE_BYTES,  
        }
        }  
                if (value != null) {
            VALID_ARROW_TYPES,  
import java.util.List;
    /** Name of the {@code low_cardinality} mapping parameter, which suppresses Lucene indexing and enables a Parquet column bloom filter. */
        String normalized = encoding.toUpperCase(Locale.ROOT);  
    public static final Setting<List<Boolean>> BLOOM_FILTER_ENABLED_VALUE_SETTING = Setting.listSetting(
     * {@link ResourceTrackerSettings#NODE_NATIVE_MEMORY_LIMIT_SETTING}.  
    public static final Setting<Double> BLOOM_FILTER_FPP = Setting.doubleSetting(
                }
        for (String fieldName : fieldCompressions.keySet()) {
                try {
     * Usage: parquet.type_bloom_filter.{arrow_type}.enabled=true  
 */
     * scale linearly with total RAM relative to this anchor.  
     * {@code index.parquet.sort_in_memory_threshold} default. Governs the sorted-write chunk size;
            }  
                    "Encoding '" + encoding + "' is not compatible with field '" + fieldName + "' of type '" + arrowType + "'"
        Collections.emptyList(),
        "DICTIONARY",
            if (key.endsWith(".encoding")) {
    /**
                    throw new IllegalArgumentException(
    static final int SORT_IN_MEMORY_THRESHOLD_FLOOR_MB = 16;
        return extractConfigMap(  
            COMPRESSION_LEVEL,
            }
                    + ".value must have the same size. "
                } catch (NumberFormatException e) {
            ".compression",
            VALID_COMPRESSIONS,
        MERGE_BATCH_SIZE_FLOOR,  
        }
            "compression"  
                        + "'"
/*  
        return normalized;
     * (linearly, anchored at 64 GiB → {@value #DEFAULT_MERGE_BATCH_SIZE}), clamped to
        Setting.Property.IndexScope,
     * Applies to any boolean parameter the plugin contributes via {@link ParquetDataFormatPlugin#getPluginMappingParameters}.  
                throw new IllegalArgumentException(
    @Deprecated
            result.put(fields.get(i), values.get(i));
        new ByteSizeValue(128, ByteSizeUnit.MB),
            BLOOM_FILTER_NDV,
            }
        validateFieldConfigurations(fieldEncodings, fieldCompressions, fieldBloomFilterEnabled, Collections.emptySet(), schema, null);  
        Function.identity(),
            if (key.startsWith("index.parquet.field.") && key.endsWith(".bloom_filter_ndv")) {
            if (v < 0) {
