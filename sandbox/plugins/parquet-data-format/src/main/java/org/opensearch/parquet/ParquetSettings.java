            String encoding = entry.getValue();
        Setting.Property.IndexScope,
        for (Field field : schema.getFields()) {
    static final int MERGE_BATCH_SIZE_CEIL = 100_000;
        Map.entry("int64", new ArrowType.Int(64, true)),
     * Returns a map of field name to the resolved value of the given mapping parameter, for fields that expose it.
     * Anchor used to scale the batch/sort defaults with machine memory. The tuned base values
     * Returns 0 when AC is unconfigured (unlike max which returns Long.MAX_VALUE).
        return result;
    }, Setting.Property.NodeScope, Setting.Property.Dynamic);
     * OS probe throws.
package org.opensearch.parquet;
    public static final Setting<List<Boolean>> BLOOM_FILTER_ENABLED_VALUE_SETTING = Setting.listSetting(
            VALID_ARROW_TYPES,
            return v;
    /**
        ),
    }
     * each chunk flush transiently reserves ~2× this on the write pool.
        Setting.Property.IndexScope,
    public static Map<String, Long> getFieldBloomFilterNdv(Settings settings) {
     */
     */
            SORT_IN_MEMORY_THRESHOLD_FLOOR_MB,
    /** Maximum bytes the native merge pool can burst to. Default is 3% of node.native_memory.limit. */
     * Reads all keys under "parquet.type_compression.{arrow_type}.compression".
     * {@code index.parquet.sort_in_memory_threshold} default. Governs the sorted-write chunk size;
        Setting.Property.NodeScope,
    public static final Setting<Integer> ROW_GROUP_MAX_ROWS = Setting.intSetting(
        Setting.Property.Final
        Map.entry("float64", new ArrowType.FloatingPoint(FloatingPointPrecision.DOUBLE)),
    }
    );
    }
    static final int SORT_IN_MEMORY_THRESHOLD_FLOOR_MB = 16;
            return -1L;
                        + typeName
import org.apache.arrow.vector.types.FloatingPointPrecision;
    /**
            PAGE_SIZE_BYTES,
        Setting.Property.NodeScope
        for (String fieldName : fieldCompressions.keySet()) {
            if (v < 0) {
    /**
 * this file be licensed under the Apache-2.0 license or a
        Setting.Property.Dynamic
     * The base value is the default tuned on the anchor machine, and {@code factor = totalRamBytes / anchor}.
    }
        }
    private static final int MERGE_BATCH_SIZE_DEFAULT = deriveBatchSizeDefault(
    }
        Setting.Property.NodeScope
     */
        }
    );
    public static final Setting<Double> BLOOM_FILTER_FPP = Setting.doubleSetting(
            } else if (key.endsWith(".ndv")) {
        }
                        "Invalid compression '" + s.get(key) + "' for type '" + typeName + "'. Valid values: " + VALID_COMPRESSIONS
    public static final Setting<ByteSizeValue> DICT_SIZE_BYTES = Setting.byteSizeSetting(
        Setting.Property.Final
                    if (ndv < 1) {
    public static final Setting<String> COMPRESSION_TYPE = Setting.simpleString(
            if (key.endsWith(keySuffix)) {
        MERGE_BATCH_SIZE_DEFAULT,
        1,
        Set<String> validValues,
                }
    static String derivePoolMaxDefault(Settings settings, int percent) {
                if (validNames != null && validNames.contains(name) == false) {
        Set<String> enabled = new java.util.HashSet<>();
        "index.parquet.compression.field",
 * compatible open source license.
                );
        "RLE",
        MapperService mapperService
        }
        safeTotalRamBytes(),
        if (!VALID_COMPRESSIONS.contains(normalized)) {
     */
     * Batch size for reading records during merge. Default scales with total RAM
            BLOOM_FILTER_ENABLED_FIELD_SETTING,
            MERGE_DEFERRED_COLUMN_THRESHOLD,
        return buildFieldMap(
                }
import java.util.Set;
                if (value != null) {
        20000,
            if (key.endsWith(".enabled")) {
            if (result.containsKey(fields.get(i))) {
        2,
                throw new IllegalArgumentException(
    private static String validateEncoding(String encoding) {
                throw new IllegalArgumentException(
                            + validValues
            }
            BLOOM_FILTER_ENABLED_VALUE_SETTING.get(settings),
        MERGE_BATCH_SIZE_CEIL
        }
    /**
            MERGE_RAYON_THREADS,
        return buildFieldMap(ENCODING_FIELD_SETTING.get(settings), ENCODING_VALUE_SETTING.get(settings), "encoding");
        100_000L,
                throw new IllegalArgumentException("Duplicate field '" + fields.get(i) + "' in index.parquet." + configType + ".field");
            long v = Long.parseLong(s);
        Set<Class<? extends ArrowType>> validTypes = ENCODING_TO_VALID_TYPES.get(encoding);
        }
            }
                String name = key.substring(0, key.length() - keySuffix.length());
        1,
 * The OpenSearch Contributors require contributions made to
            return DICTIONARY_INCOMPATIBLE_TYPES.contains(arrowType.getClass()) == false;
        Setting.Property.IndexScope
        new ByteSizeValue(2, ByteSizeUnit.MB),
    public static final String POOL_MERGE = "merge";
                    + configType
            }
     * Returns total physical RAM in bytes, or {@code -1} if it cannot be read for any reason.
        MAX_ROWS_PER_VSR_DEFAULT,
            }
    }
        0.1,
 */
    }
            }
        "DICTIONARY",
    );
                throw new IllegalArgumentException("Field '" + fieldName + "' in encoding configuration does not exist in mappings");
        "RLE_DICTIONARY",
            }
     */
        "index.parquet.bloom_filter_enabled.field",
                throw new IllegalArgumentException("Field '" + fieldName + "' in compression configuration does not exist in mappings");
    public static final Setting<List<String>> ENCODING_FIELD_SETTING = Setting.listSetting(
    public static final int DEFAULT_MAX_ROWS_PER_VSR = 65_536;
        Collections.emptyList(),
    }
                String fieldName = key.substring("index.parquet.field.".length(), key.length() - ".bloom_filter_ndv".length());
        Setting.Property.IndexScope
            // Memory unavailable — fall back to the tuned default, no calculation.
                    throw new IllegalArgumentException("Invalid " + nameLabel + " '" + name + "'. Valid values: " + validNames);
                if (validValues.contains(value) == false) {
        "LZ4_RAW",
                    throw new IllegalArgumentException(
        }
        "index.parquet.compression_type",
    public static Map<String, Long> getTypeBloomFilterNdv(Settings nodeSettings) {
        }
        Setting.Property.Final
        long scaled = Math.round((double) base * factor);
    public static final Setting<Long> MERGE_POOL_MAX = new Setting<>(
    }
            safeTotalRamBytes(),
        "boolean",
            throw new IllegalArgumentException("Invalid boolean value: " + value + ". Must be true or false");
            if (key.endsWith(".compression")) {
            BLOOM_FILTER_FPP,
            if (!arrowTypes.containsKey(fieldName)) {
    );
 */
    public static final Map<String, ArrowType> ARROW_TYPE_NAME_TO_INSTANCE = Map.ofEntries(
    );
        safeTotalRamBytes(),
        Set.of(
            }
     *
import org.opensearch.cluster.node.DiscoveryNode;
            VALID_ENCODINGS,
    private static final Map<String, Set<Class<? extends ArrowType>>> ENCODING_TO_VALID_TYPES = Map.of(
        Collections.emptyList(),
        "index.parquet.encoding.value",
            return false;
import org.apache.arrow.vector.types.pojo.ArrowType;
                String value = s.get(key).toUpperCase(Locale.ROOT);
        Setting.Property.Dynamic
        );
                "index.parquet."
     */
     * Scales a batch-size default linearly with total physical RAM, anchored at the 64 GiB benchmark
            );
        String normalized = compression.toUpperCase(Locale.ROOT);
    /**
                    throw new IllegalArgumentException("Invalid bloom_filter ndv value '" + s.get(key) + "' for type '" + typeName + "'");
    public static final Setting<Integer> MERGE_DEFERRED_COLUMN_THRESHOLD = Setting.intSetting(
import java.util.HashMap;
        1L,
            MERGE_BATCH_SIZE,
            org.opensearch.index.mapper.MappedFieldType mappedFieldType = mapperService.fieldType(fieldName);
    ) {
        Map.entry("utf8", new ArrowType.Utf8()),
    }
            long v = Long.parseLong(s);
    /**
    );
     * machine ({@link #BATCH_SIZE_ANCHOR_RAM_BYTES}), and clamps the result to [{@code floor}, {@code ceil}].
     * e.g. parquet.type_compression.utf8.compression=SNAPPY
        s -> {
                    result.put(mapper.name(), value);
        "index.parquet.compression.value",
                }
    public static List<Setting<?>> getSettings() {
        for (String fieldName : lowCardinalityEnabledFields) {
                String val = s.get(key).toLowerCase(Locale.ROOT);
    /** Maximum byte size per row group (default 128MB). */
    private ParquetSettings() {}
    /** Maximum number of rows per row group (default 1000000). */
        "int16",
        return extractConfigMap(TYPE_BLOOM_FILTER_SETTINGS.get(nodeSettings), ".enabled", Boolean::parseBoolean);
        String nameLabel,
            ROW_GROUP_MAX_BYTES,
                            + groupSettings.get(key)
    ) {
        "DELTA_BINARY_PACKED",
    private static Map<String, String> extractConfigMap(
        Math.max(1, Runtime.getRuntime().availableProcessors() / 2),
        Set.of(ArrowType.Int.class, ArrowType.Timestamp.class, ArrowType.Date.class, ArrowType.Time.class, ArrowType.Duration.class),
     * @param ceil          fixed upper bound
                    "Encoding '" + encoding + "' is not compatible with field '" + fieldName + "' of type '" + arrowType + "'"
                            + " '"
        ),
        // Validate bloom filter field existence
        Set<String> validNames,
    /** Tuned base (64 GiB anchor) and fixed bounds for the RAM-scaled {@code index.parquet.merge_batch_size} default. */
     */
            MAX_ROWS_PER_VSR,
        9,
    /** Name of the {@code low_cardinality} mapping parameter, which suppresses Lucene indexing and enables a Parquet column bloom filter. */
        1,
        "int8",
        } else {
        }
        "DELTA",
                if (VALID_COMPRESSIONS.contains(value) == false) {
        return extractConfigMap(
        } catch (Exception e) {
    public static boolean isEncodingValidForArrowType(String encoding, ArrowType arrowType) {
     * (VSR rows, merge rows, and sort-threshold MiB) were measured on a 64 GiB machine; defaults
        Map.entry("uint8", new ArrowType.Int(8, false)),
            ArrowType.Binary.class,
        return normalized;
        String normalized = value.toLowerCase(Locale.ROOT);
    public static final Setting<Integer> MAX_ROWS_PER_VSR = Setting.intSetting(
                if (VALID_ARROW_TYPES.contains(typeName) == false) {
            if (!arrowTypes.containsKey(fieldName)) {
        );
        Function.identity(),
    public static final Setting<Integer> MERGE_IO_THREADS = Setting.intSetting(
            return "0";
        for (String key : groupSettings.keySet()) {
                    "Field '" + fieldName + "' in bloom_filter_enabled configuration does not exist in mappings"
            return OsProbe.getInstance().getTotalPhysicalMemorySize();
     * @param floor         fixed lower bound
    );
                if (VALID_ENCODINGS.contains(value) == false) {
    private static final ByteSizeValue SORT_IN_MEMORY_THRESHOLD_DEFAULT = new ByteSizeValue(
    /** Data page size limit in bytes (default 1MB). */
        Setting.Property.IndexScope,
                typeName = key.substring(0, key.length() - ".ndv".length());
        Setting.Property.NodeScope
        }
            ".compression",
                }
     *        parquet.type_bloom_filter.{arrow_type}.ndv=50000
        },
        "index.parquet.row_group_max_bytes",
                    );
        Map<String, String> result = new HashMap<>();
        Set.of(ArrowType.Utf8.class, ArrowType.LargeUtf8.class, ArrowType.Binary.class, ArrowType.LargeBinary.class),
        s -> derivePoolMinDefault(s, DiscoveryNode.isWarmNode(s) ? 2 : 4),
        "DELTA_LENGTH_BYTE_ARRAY",
            if (mapper instanceof ParametrizedFieldMapper) {
                    + ".field and index.parquet."
                typeName = key.substring(0, key.length() - ".enabled".length());
        return normalized;
    /**
        }
     * Group setting for per-type encoding configuration (cluster-level fallback).
            }
        false,
        Setting.Property.IndexScope,
            "bloom_filter_enabled"
            BLOOM_FILTER_ENABLED,
    static int deriveBatchSizeDefault(long totalRamBytes, int base, int floor, int ceil) {
        SORT_IN_MEMORY_THRESHOLD_DEFAULT,
        },
    }
                );
                try {
import org.apache.arrow.vector.types.pojo.Schema;
        Map.entry("float32", new ArrowType.FloatingPoint(FloatingPointPrecision.SINGLE)),
    }
    );
     * deferred data loading during merge. Below this threshold, all columns are decoded eagerly
import org.opensearch.monitor.os.OsProbe;
     * Maps each encoding to the set of ArrowType classes it supports.
        Set.of(ArrowType.Int.class, ArrowType.Timestamp.class, ArrowType.Date.class, ArrowType.Time.class, ArrowType.Duration.class),
            if (!isEncodingValidForArrowType(encoding, arrowType)) {
        try {
     * Usage: parquet.type_encoding.{arrow_type}.encoding=DELTA_BINARY_PACKED
     * {@link ResourceTrackerSettings#NODE_NATIVE_MEMORY_LIMIT_SETTING}.
        1_000_000,
                    );
                    }
                            + nameLabel
        "binary",
     *
        return (int) Math.max(floor, Math.min(ceil, scaled));
    /**
        MAX_ROWS_PER_VSR_FLOOR,
        for (Mapper mapper : mapperService.documentMapper().mappers()) {
    }
            String typeName = mappedFieldType.typeName();
     */
            SORT_IN_MEMORY_THRESHOLD,
        if (nativeLimit.getBytes() <= 0) {
        return Collections.unmodifiableMap(result);
        return getFieldsWithParameterEnabled(mapperService, LOW_CARDINALITY_PARAM);
                }
        Function.identity(),
     * Validates that field-level configurations are compatible with their Arrow types in the schema.
        ByteSizeValue nativeLimit = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings);
     */
    );
                        "Invalid encoding '" + s.get(key) + "' for type '" + typeName + "'. Valid values: " + VALID_ENCODINGS
        Map<String, String> fieldEncodings,
        "int64",
    /** File size threshold for in-memory sort vs streaming merge sort. Default scales with total RAM
                result.put(fieldName, settings.getAsLong(key, null));
    );
    static String derivePoolMinDefault(Settings settings, int percent) {
    /** Fixed bounds for the RAM-scaled {@code parquet.max_rows_per_vsr} default (user-set values are unbounded). */
        }
/*
        "parquet.merge_io_threads",
     * Extracts per-type encoding map from node settings.
                throw new IllegalArgumentException("Setting [parquet.native.pool.merge.max] must be >= 0, got " + v);
     * <p>This performs a linear scan of the document mapper's fields and is intended for cold paths
            throw new IllegalArgumentException("Invalid compression: " + compression + ". Valid values: " + VALID_COMPRESSIONS);
        "uint64",
        Map.entry("binary", new ArrowType.Binary()),
            }
                );
            String typeName = null;
            VALID_COMPRESSIONS,
        "index.parquet.page_size_bytes",
import org.opensearch.core.common.unit.ByteSizeUnit;
                enabled.add(entry.getKey());
        ParquetSettings::validateEncoding,
        "index.parquet.sort_in_memory_threshold",
     */
    }
     * Returns the field names whose given boolean mapping parameter resolves to {@code true}, read from the mapping.
    public static final int DEFAULT_MERGE_BATCH_SIZE = 100_000;
        "float32",
            return v;
        Map<String, String> fieldCompressions,
    }
    /** Bloom filter number of distinct values hint (default 100000). */
            if (mappedFieldType == null) {
        "PLAIN",
        String normalized = encoding.toUpperCase(Locale.ROOT);
    /**
    public static Set<String> getLowCardinalityEnabledFields(MapperService mapperService) {
        Setting.Property.IndexScope,
            BLOOM_FILTER_ENABLED_VALUE_SETTING,
    /**
    /** Compression codec for Parquet files, e.g. ZSTD, SNAPPY, LZ4_RAW (default LZ4_RAW). */
        Setting.Property.IndexScope
                    "Field '" + fieldName + "' in low_cardinality_enable configuration does not exist in mappings"
        1,
     * Minimum number of variable-width (string/binary) non-sort columns required to activate
                String typeName = key.substring(0, key.length() - ".encoding".length());
        "index.parquet.bloom_filter_fpp",
        Map.entry("int32", new ArrowType.Int(32, true)),
        String keySuffix,
            if (v < 0) {
        ParquetSettings::validateBoolean,
        "uint8",
                String fieldName = key.substring("index.parquet.field.".length(), key.length() - ".bloom_filter_fpp".length());
     */
        for (String key : groupSettings.keySet()) {
                    throw new IllegalArgumentException(
        new ByteSizeValue(1, ByteSizeUnit.MB),
import org.apache.arrow.vector.types.TimeUnit;
                    long ndv = Long.parseLong(s.get(key));
        MERGE_BATCH_SIZE_FLOOR,
        Map<String, String> fieldCompressions,
                    + ".value must have the same size. "
    /**
        Map.entry("uint32", new ArrowType.Int(32, false)),
    }
        Setting.Property.NodeScope,
    }
    public static Map<String, String> getTypeCompressions(Settings nodeSettings) {
        "DELTA_BINARY_PACKED",
            if (typeName != null && VALID_ARROW_TYPES.contains(typeName) == false) {
                    throw new IllegalArgumentException("Invalid arrow type '" + typeName + "'. Valid values: " + VALID_ARROW_TYPES);
        1.0,
        return extractConfigMap(TYPE_BLOOM_FILTER_SETTINGS.get(nodeSettings), ".fpp", Double::parseDouble);
            if (key.endsWith(keySuffix)) {
        ByteSizeValue nativeLimit = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings);
    public static Map<String, String> getFieldCompressions(Settings settings) {
            MERGE_IO_THREADS,
    public static final Setting<ByteSizeValue> ROW_GROUP_MAX_BYTES = Setting.byteSizeSetting(
import org.opensearch.index.mapper.ParametrizedFieldMapper;
        s -> {
        Collections.emptyList(),
        Map.entry("uint16", new ArrowType.Int(16, false)),
    }
                    + ", Values: "
            "compression"
            ArrowType.LargeUtf8.class,
        Setting.Property.Final
    public static Map<String, Boolean> getTypeBloomFilterEnabled(Settings nodeSettings) {
        }
        if ("RLE_DICTIONARY".equals(encoding) || "DICTIONARY".equals(encoding)) {
     */
            }
     * {@link ResourceTrackerSettings#NODE_NATIVE_MEMORY_LIMIT_SETTING}.
     * A negative result drives {@link #deriveBatchSizeDefault} to the tuned base default, ensuring
     * that do not yet have a MapperService reference.
     * scale linearly with total RAM relative to this anchor.
        Map.entry("timestamp", new ArrowType.Timestamp(TimeUnit.MILLISECOND, null))
        long pool = Math.max(0L, nativeLimit.getBytes() * percent / 100);
        Schema schema
        if (field.getType() instanceof ArrowType.List && field.getChildren().isEmpty() == false) {
            if (key.endsWith(".encoding")) {
     * Extracts per-type compression map from node settings.
import java.util.Locale;
            long v = Long.parseLong(s);
            ArrowType.Utf8.class,
     * validating against {@code ArrowType.List} would wrongly accept every encoding.
            }
        "DELTA",
    /**
                }
        return extractConfigMap(
                ArrowType arrowType = ARROW_TYPE_NAME_TO_INSTANCE.get(typeName);
        "index.parquet.bloom_filter_enabled",
        }
            if (key.startsWith("index.parquet.field.") && key.endsWith(".bloom_filter_ndv")) {
        Map<String, Object> result = new HashMap<>();
    }
        // Validate compression field existence
     *  (anchor 32 MiB @ 64 GiB), clamped to [16 MiB, 64 MiB]. */
            }
     * column that is the element type, because Parquet encodes the leaf, not the list wrapper —
     * (original behavior). Set to 0 to always defer; set very high to disable deferral.
        return result;
            }
            MERGE_POOL_MAX,
        s -> {
            TYPE_COMPRESSION_SETTINGS,
            SORT_IN_MEMORY_THRESHOLD_BASE_MB,
            arrowTypes.put(field.getName(), elementTypeOf(field));
    );
     */
import java.util.Map;
     */
     * [{@value #MERGE_BATCH_SIZE_FLOOR}, {@value #MERGE_BATCH_SIZE_CEIL}].
    public static final Set<String> VALID_ENCODINGS = Set.of(
            TYPE_ENCODING_SETTINGS,
        Collections.emptyList(),
    );
        Map.entry("int16", new ArrowType.Int(16, true)),
     * Any failure reading RAM falls back to the tuned base value (see {@link #safeTotalRamBytes()}).
                        throw new IllegalArgumentException("bloom_filter ndv for type '" + typeName + "' must be >= 1, got: " + ndv);
                throw new IllegalArgumentException(
                throw new IllegalArgumentException("Setting [parquet.native.pool.write.min] must be >= 0, got " + v);
    public static final Setting<ByteSizeValue> SORT_IN_MEMORY_THRESHOLD = Setting.byteSizeSetting(
            String fieldName = entry.getKey();
            ArrowType.FixedSizeBinary.class
            DICT_SIZE_BYTES,
    private static final Set<Class<? extends ArrowType>> DICTIONARY_INCOMPATIBLE_TYPES = Set.of(ArrowType.Bool.class);
        }
     */
        },
                String value = groupSettings.get(key).toUpperCase(Locale.ROOT);
        }
                        "Invalid "
    public static final Setting<List<String>> ENCODING_VALUE_SETTING = Setting.listSetting(
        // Validate low_cardinality_enable fields: must exist and be keyword or text type
        Set.of(ArrowType.Bool.class),
        "index.parquet.merge_deferred_column_threshold",
        for (String key : s.keySet()) {
            COMPRESSION_TYPE,
        for (String fieldName : fieldBloomFilterEnabled.keySet()) {
    private static <V> Map<String, V> buildFieldMap(List<String> fields, List<V> values, String configType) {
        for (Map.Entry<String, String> entry : fieldEncodings.entrySet()) {
    /** Maximum number of rows per data page (default 20000). */
            BLOOM_FILTER_ENABLED_FIELD_SETTING.get(settings),
    }
    );
    @Deprecated
     * @param base          tuned default at the 64 GiB anchor (also the fallback value)
        );
            }
                    double fpp = Double.parseDouble(s.get(key));
    );
import java.util.List;
        Setting.Property.IndexScope
                result.put(name, value);
    }
        if (fields.isEmpty() && values.isEmpty()) {
        String valueLabel
     * and validating the value against a set of valid values.
        }
                    throw new IllegalArgumentException(
        "parquet.max_rows_per_vsr",
    public static final Setting<Integer> PAGE_ROW_LIMIT = Setting.intSetting(
                    throw new IllegalArgumentException(
                            + name
     * Usage: parquet.type_compression.{arrow_type}.compression=SNAPPY
        for (Map.Entry<String, Object> entry : values.entrySet()) {
    }
        Map.entry("int8", new ArrowType.Int(8, true)),
    /**
                }
        if (validTypes == null) {
                throw new IllegalArgumentException("Invalid arrow type '" + typeName + "'. Valid values: " + VALID_ARROW_TYPES);
    public static final Setting<Settings> TYPE_BLOOM_FILTER_SETTINGS = Setting.groupSetting("parquet.type_bloom_filter.", s -> {
            return Collections.emptyMap();
            PAGE_ROW_LIMIT,
        Map.entry("date", new ArrowType.Date(DateUnit.DAY)),
    );
        Math.max(1, Runtime.getRuntime().availableProcessors() / 2),
        "index.parquet.bloom_filter_enabled.value",
     * Only keyword and text field types are accepted for low_cardinality_enable.
                );
        for (int i = 0; i < fields.size(); i++) {
    /** Number of Rayon threads for parallel column encoding during merge (default num_cores/2, min 1). */
                } catch (NumberFormatException e) {
import org.opensearch.index.mapper.MapperService;
    );
    public static Map<String, String> getTypeEncodings(Settings nodeSettings) {
            "arrow type",
        "float64",
    // Field-level bloom filter enabled configuration (parallel arrays)
        Map<String, Long> result = new HashMap<>();
     */
     */
        MAX_ROWS_PER_VSR_CEIL
        "parquet.merge_rayon_threads",
        return result;
        Map<String, Object> values = getFieldParameterValues(mapperService, parameterName);
        "index.parquet.row_group_max_rows",
    public static Map<String, Object> getFieldParameterValues(MapperService mapperService, String parameterName) {
    public static Map<String, Double> getFieldBloomFilterFpp(Settings settings) {
                            + "'. Valid values: "
     * Works for any parameter type the plugin contributes via {@link ParquetDataFormatPlugin#getPluginMappingParameters}.
     * [{@value #MAX_ROWS_PER_VSR_FLOOR}, {@value #MAX_ROWS_PER_VSR_CEIL}].
        "BYTE_STREAM_SPLIT",
        Setting.Property.Dynamic
                if (arrowType != null && isEncodingValidForArrowType(value, arrowType) == false) {
        }
            "encoding"
        Map.entry("boolean", new ArrowType.Bool()),
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
    public static final Setting<Long> BLOOM_FILTER_NDV = Setting.longSetting(
        Collections.emptyList(),
                }
     * Reads all keys under "parquet.type_encoding.{arrow_type}.encoding".
        } else if ("false".equals(normalized)) {
        }
            TYPE_BLOOM_FILTER_SETTINGS
        if (nativeLimit.getBytes() <= 0) {
                            + " '"
    public static final Setting<Integer> COMPRESSION_LEVEL = Setting.intSetting(
    }, Setting.Property.NodeScope, Setting.Property.Dynamic);
        }
     * If RAM is unavailable ({@code totalRamBytes <= 0}), falls back to the tuned default {@code base}
        Set.of(ArrowType.Int.class, ArrowType.FloatingPoint.class, ArrowType.FixedSizeBinary.class)
                            + "' for "
        Map<String, String> fieldEncodings,
        Function.identity(),
    /** Returns the field names whose {@code low_cardinality} mapping parameter resolves to {@code true}, read from the mapping. */
            ".encoding",
        Setting.Property.Final
        "RLE",
     * @param totalRamBytes total physical RAM in bytes (e.g. {@code OsProbe.getTotalPhysicalMemorySize()})
        "parquet.native.pool.merge.max",
     * with no scaling/clamping applied.
                    );
        }
        for (String key : s.keySet()) {
            return true;
    public static Map<String, String> getFieldEncodings(Settings settings) {
     * Extracts a config map from group settings by matching keys with a given suffix,
        }
     * and converting the raw string value using the provided parser.
        return validTypes.contains(arrowType.getClass());
    static final int MAX_ROWS_PER_VSR_FLOOR = 8_192;
                    );
                    throw new IllegalArgumentException("Invalid bloom_filter fpp value '" + s.get(key) + "' for type '" + typeName + "'");
    );
     * e.g. parquet.type_encoding.int64.encoding=DELTA_BINARY_PACKED
    public static final Set<String> VALID_COMPRESSIONS = Set.of("ZSTD", "SNAPPY", "GZIP", "BROTLI", "LZ4_RAW", "UNCOMPRESSED");
        "DELTA_LENGTH_BYTE_ARRAY",
    public static final Setting<List<String>> COMPRESSION_VALUE_SETTING = Setting.listSetting(
        1,
    }, Setting.Property.NodeScope, Setting.Property.Dynamic);
        );
     * Maximum rows per VectorSchemaRoot before rotation is triggered. Default scales with total RAM
                    throw new IllegalArgumentException("Encoding '" + value + "' is not compatible with arrow type '" + typeName + "'");
        Setting.Property.IndexScope
        Map<String, Double> result = new HashMap<>();
        Setting.Property.NodeScope,
                throw new IllegalArgumentException(
        return Long.toString(Math.max(0L, nativeLimit.getBytes() * percent / 100));
            if (!"keyword".equals(typeName) && !"text".equals(typeName)) {
    );
     * (settings sync, index creation). If called on the write path, cache the result by mapping version.
                }
            if (arrowType == null) {
        s -> derivePoolMaxDefault(s, DiscoveryNode.isWarmNode(s) ? 4 : 8),
            result.put(fields.get(i), values.get(i));
        1,
        Set<String> lowCardinalityEnabledFields,
            throw new IllegalArgumentException("Invalid encoding: " + encoding + ". Valid values: " + VALID_ENCODINGS);
     * Computes the default for a pool min as a percentage of
        Schema schema,
                        throw new IllegalArgumentException(
        if ("PLAIN".equals(encoding)) {
        Setting.Property.IndexScope
        if (mapperService == null || mapperService.documentMapper() == null || mapperService.documentMapper().mappers() == null) {
     */
        1,
            "arrow type",
    public static final Setting<Settings> TYPE_ENCODING_SETTINGS = Setting.groupSetting("parquet.type_encoding.", s -> {
        Setting.Property.Dynamic
    private static String validateCompression(String compression) {
        "DELTA_BYTE_ARRAY",
            return v;
        return field.getType();
        "timestamp"
    /**
    static final long BATCH_SIZE_ANCHOR_RAM_BYTES = 64L * 1024 * 1024 * 1024;
            }
                if ("true".equals(val) == false && "false".equals(val) == false) {
    // Field-level compression configuration (parallel arrays)
    private static long safeTotalRamBytes() {
     * PLAIN and unknown encodings are valid for all types (handled separately).
            COMPRESSION_LEVEL,
        Setting.Property.IndexScope
     * Overload that omits low_cardinality validation — kept for backward compatibility with callers
     *        parquet.type_bloom_filter.{arrow_type}.fpp=0.01
        return List.of(
        Setting.Property.IndexScope
    public static final String LOW_CARDINALITY_PARAM = "low_cardinality";
        DEFAULT_MAX_ROWS_PER_VSR,
        0.0,
            ROW_GROUP_MAX_ROWS,
                String value = s.get(key).toUpperCase(Locale.ROOT);
     */
        Map<String, T> result = new HashMap<>();
     * settings always resolve to a sane value (and class initialization never fails) even if the
        return Collections.unmodifiableSet(enabled);
        "index.parquet.dict_size_bytes",
    public static final String POOL_WRITE = "write";
                } catch (NumberFormatException e) {
                    + configType
                );
    );
        Map<String, Boolean> fieldBloomFilterEnabled,
        }
    /**
        }
        Setting.Property.Final
     * Returns the type that encoding and compression settings apply to for a field. For a LIST
        "index.parquet.encoding.field",
    private static final int MAX_ROWS_PER_VSR_DEFAULT = deriveBatchSizeDefault(
            } else if (key.endsWith(".fpp")) {
    public static final Setting<Settings> TYPE_COMPRESSION_SETTINGS = Setting.groupSetting("parquet.type_compression.", s -> {
    static final int SORT_IN_MEMORY_THRESHOLD_CEIL_MB = 64;
        "index.parquet.bloom_filter_ndv",
     * Builds a field configuration map from parallel arrays.
     */
import org.opensearch.index.mapper.Mapper;
    );
    public static final Setting<Integer> MERGE_BATCH_SIZE = Setting.intSetting(
    static final int MAX_ROWS_PER_VSR_CEIL = 131_072;
                typeName = key.substring(0, key.length() - ".fpp".length());
        s -> derivePoolMinDefault(s, 1),
            ENCODING_FIELD_SETTING,
            BLOOM_FILTER_NDV,
/**
                Object value = ((ParametrizedFieldMapper) mapper).mappingPluginParameterValues().get(parameterName);
     * Computes the default for a pool max as a percentage of
        Setting.Property.IndexScope,
    // Field-level encoding configuration (parallel arrays)
     * @deprecated Use the overload that accepts {@code lowCardinalityEnabledFields} and
        Map<String, V> result = new HashMap<>();
    /** Bloom filter false positive probability (default 0.1). */
import org.apache.arrow.vector.types.DateUnit;
        }
                if (VALID_ARROW_TYPES.contains(typeName) == false) {
            if (key.startsWith("index.parquet.field.") && key.endsWith(".bloom_filter_fpp")) {
            }
    );
    /** Compression level for the chosen codec (default 2, range 1–9). */
                throw new IllegalArgumentException("Setting [parquet.native.pool.write.max] must be >= 0, got " + v);
            if (v < 0) {
        return Long.toString(pool);
                    if (fpp <= 0.0 || fpp >= 1.0) {
        Setting.Property.IndexScope,
        s -> derivePoolMaxDefault(s, 3),
     */
    public static void validateFieldConfigurations(
    );
        double factor = (double) totalRamBytes / BATCH_SIZE_ANCHOR_RAM_BYTES;
        }
            TYPE_COMPRESSION_SETTINGS.get(nodeSettings),
    );
            return true;
    public static Map<String, Double> getTypeBloomFilterFpp(Settings nodeSettings) {
    /**
    /** Dictionary page size limit in bytes (default 2MB). */
        "parquet.native.pool.merge.min",
    public static final Setting<Long> WRITE_POOL_MIN = new Setting<>(
    private static <T> Map<String, T> extractConfigMap(Settings groupSettings, String keySuffix, Function<String, T> valueParser) {
                        + fieldName
        validateFieldConfigurations(fieldEncodings, fieldCompressions, fieldBloomFilterEnabled, Collections.emptySet(), schema, null);
            if (!arrowTypes.containsKey(fieldName)) {
    );
                    + values
            COMPRESSION_FIELD_SETTING,
    /**
                String typeName = key.substring(0, key.length() - ".compression".length());
        s -> {
            ENCODING_VALUE_SETTING,
            }
    }
}
                        + "' has type '"
    private static Boolean validateBoolean(String value) {
    static final int MERGE_BATCH_SIZE_FLOOR = 12_500;
        "utf8",
            return base;
            return field.getChildren().get(0).getType();
            WRITE_POOL_MAX,
        return buildFieldMap(COMPRESSION_FIELD_SETTING.get(settings), COMPRESSION_VALUE_SETTING.get(settings), "compression");
                            + valueLabel
    /** Maximum bytes the native write pool can burst to. Default is 4% of budget on warm nodes, 8% otherwise. */
    }
    );
     */
                try {
    /** Whether bloom filters are enabled for Parquet columns (default false). */
    public static final Setting<ByteSizeValue> PAGE_SIZE_BYTES = Setting.byteSizeSetting(
        "int32",
 *
import org.opensearch.common.settings.Settings;
        if (!VALID_ENCODINGS.contains(normalized)) {
        for (String key : settings.keySet()) {
    public static final Setting<List<String>> COMPRESSION_FIELD_SETTING = Setting.listSetting(
     * Applies to any boolean parameter the plugin contributes via {@link ParquetDataFormatPlugin#getPluginMappingParameters}.
            VALID_ARROW_TYPES,
            MERGE_POOL_MIN,
        ByteSizeUnit.MB
 * Settings for Parquet data format.
        Setting.Property.IndexScope
import org.opensearch.common.settings.Setting;
    );
import java.util.Collections;
        for (String key : s.keySet()) {
    /**
    public static final Set<String> VALID_ARROW_TYPES = Set.of(
    }
    /** Set of ArrowType classes that do NOT support dictionary encoding. */
        Setting.Property.Dynamic
        for (String key : settings.keySet()) {
     */
            }
        },
    );
    public static final Setting<Boolean> BLOOM_FILTER_ENABLED = Setting.boolSetting(
        if (totalRamBytes <= 0) {
    static final int SORT_IN_MEMORY_THRESHOLD_BASE_MB = 32;
    );
    private static ArrowType elementTypeOf(Field field) {
        "index.parquet.compression_level",
                throw new IllegalArgumentException(
        if (fields.size() != values.size()) {
     */
        "uint16",
    }
    public static final Setting<Long> WRITE_POOL_MAX = new Setting<>(
import org.apache.arrow.vector.types.pojo.Field;
                    "low_cardinality_enable is only supported for keyword and text fields, but field '"
            return v;
        "parquet.native.pool.write.min",
        "uint32",
            }
import java.util.function.Function;
        Setting.Property.IndexScope
        return extractConfigMap(TYPE_BLOOM_FILTER_SETTINGS.get(nodeSettings), ".ndv", Long::parseLong);
        "index.parquet.merge_batch_size",
    public static final Setting<List<String>> BLOOM_FILTER_ENABLED_FIELD_SETTING = Setting.listSetting(
     * Extracts a typed config map from group settings by matching keys with a given suffix
        }
        return result;
        Map<String, Boolean> fieldBloomFilterEnabled,
     * Falls back to {@link Long#MAX_VALUE} when AC is unconfigured.
                            "bloom_filter fpp for type '" + typeName + "' must be between 0.0 and 1.0 exclusive, got: " + fpp
        }
        new ByteSizeValue(128, ByteSizeUnit.MB),
    public static final Setting<Integer> MERGE_RAYON_THREADS = Setting.intSetting(
        "DELTA_BYTE_ARRAY",
        "parquet.native.pool.write.max",
    );
        return result;
                    "Field '" + fieldName + "' in low_cardinality_enable configuration does not exist in mappings"
            throw new IllegalArgumentException(
            TYPE_ENCODING_SETTINGS.get(nodeSettings),
     * Tuned base (64 GiB anchor) and fixed bounds, in MiB, for the RAM-scaled
 * SPDX-License-Identifier: Apache-2.0
        deriveBatchSizeDefault(
     * (linearly, anchored at 64 GiB → {@value #DEFAULT_MAX_ROWS_PER_VSR}), clamped to
    /** Returns all settings defined by the Parquet plugin. */
            }
            SORT_IN_MEMORY_THRESHOLD_CEIL_MB
                    + "Fields: "
    public static void validateFieldConfigurations(
                        + "'"
     * (linearly, anchored at 64 GiB → {@value #DEFAULT_MERGE_BATCH_SIZE}), clamped to
        0,
            ArrowType.LargeBinary.class,
    /**
    /** Maps arrow type name strings to representative ArrowType instances for compatibility checks. */
    /**
    ) {
        Setting.Property.IndexScope
    public static Map<String, Boolean> getFieldBloomFilterEnabled(Settings settings) {
        Collections.emptyList(),
     * RAM-scaled defaults, computed once at class load (total RAM is constant per node).
    /**
     * Group setting for per-type bloom filter configuration (cluster-level fallback).
        Map.entry("uint64", new ArrowType.Int(64, false)),
    public static Set<String> getFieldsWithParameterEnabled(MapperService mapperService, String parameterName) {
                result.put(name, valueParser.apply(groupSettings.get(key)));
                }
        "BYTE_STREAM_SPLIT"
            ArrowType arrowType = arrowTypes.get(fieldName);
                    throw new IllegalArgumentException("Invalid arrow type '" + typeName + "'. Valid values: " + VALID_ARROW_TYPES);
        0,
        DEFAULT_MERGE_BATCH_SIZE,
            COMPRESSION_VALUE_SETTING,
                }
    );
     *             {@code mapperService} to enable full validation.
                    + fields
    /**
        if ("true".equals(normalized)) {
            return Collections.emptyMap();
    /**
    /** Minimum guaranteed bytes for the native merge pool. Default is half of merge max (1% of budget). */
            if (v < 0) {
        "index.parquet.page_row_limit",
                        );
            WRITE_POOL_MIN,
    );
                    }
                        "Invalid bloom_filter enabled value '" + s.get(key) + "' for type '" + typeName + "'. Must be true or false"
            return true;
                String name = key.substring(0, key.length() - keySuffix.length());
        Settings groupSettings,
    }
     * Usage: parquet.type_bloom_filter.{arrow_type}.enabled=true
            }
    );
        Setting.Property.IndexScope
import org.opensearch.core.common.unit.ByteSizeValue;
    }
                throw new IllegalArgumentException("Setting [parquet.native.pool.merge.min] must be >= 0, got " + v);
            long v = Long.parseLong(s);
                result.put(fieldName, settings.getAsDouble(key, null));
     * Group setting for per-type compression configuration (cluster-level fallback).
    /** Number of Tokio IO threads for async disk writes during merge (default num_cores/2, min 1). */
        Setting.Property.NodeScope,
    public static final Setting<Long> MERGE_POOL_MIN = new Setting<>(
            return Long.toString(Long.MAX_VALUE);
public final class ParquetSettings {
            }
        }
        ParquetSettings::validateCompression,
    /**
        // Validate encoding configurations
            if (Boolean.TRUE.equals(entry.getValue())) {
    );
        Map<String, ArrowType> arrowTypes = new HashMap<>();
     *
        "date",
    /** Minimum guaranteed bytes for the native write pool. Default is 2% of budget on warm nodes, 4% otherwise. */
