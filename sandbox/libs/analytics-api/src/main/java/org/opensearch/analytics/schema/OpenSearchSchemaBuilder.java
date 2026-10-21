            backing = abstraction.getIndices();
                // abstraction short-circuit above and skip the resolver entirely.
                return null;
            }
            if (columnType == null) {
                || abstraction.getType() == org.opensearch.cluster.metadata.IndexAbstraction.Type.DATA_STREAM)) {
import org.apache.calcite.schema.SchemaPlus;
            }
     * date-math) to a single table whose row type unions the supported fields of all matching
     *
     * the same shape they did before.
                    // TIMESTAMP — fall through to plain SqlTypeName.TIMESTAMP below
                // half_float lands as Arrow Float16 on disk. Calcite has no fp16 type; widen to
import java.util.LinkedHashMap;
            case "half_float":
            return null;
        if (abstraction != null
    @SuppressWarnings("unchecked")
     * {@link BinaryType} UDT (both backed by {@link SqlTypeName#VARBINARY}); for everything
        RelDataType base;
import org.apache.calcite.sql.type.SqlTypeName;
    }
            // Multi-value keyword fields are stored as Parquet LIST<UTF8> / Arrow List(Utf8).
                        + "' maps to TIMESTAMP but has no declared sub-second "
        RelDataTypeFactory typeFactory,
     * {@code getTableNames()} and would never perform the implicit {@code getTable(name)} lookup
 * Navigates: IndexMetadata -> MappingMetadata -> sourceAsMap() -> "properties" -> per-field "type".
                    if (!super.containsKey(name)) {
import java.util.logging.Level;
import java.util.Map;
                continue;
            return UnsignedLongType.nullable(typeFactory);
            if (mapping == null) {
                columnType = typeFactory.createArrayType(columnType, -1);
            }
                public Table get(Object key) {
    public static RelDataType buildLeafType(String opensearchType, String format, RelDataTypeFactory typeFactory) {
                        + opensearchType
                return null;
    /**
 *
                // TODO: every record batch goes through a Float16 → Float32 cast (see
                return null;
        if (raw == null) {
                return SqlTypeName.BIGINT;
                @Override
            && (abstraction.getType() == org.opensearch.cluster.metadata.IndexAbstraction.Type.ALIAS
                concrete = resolver.concreteIndexNames(
            case "double":
 * this file be licensed under the Apache-2.0 license or a
                    backing.add(index);
                return SqlTypeName.BOOLEAN;
                // REAL so the planner sees the same shape as a regular float column. The parquet
                    true,
        for (IndexMetadata index : backing) {
            if (raw instanceof Number) {
                return ((Number) raw).doubleValue();
import org.apache.calcite.schema.Schema;
    private static void addLeafFields(
            String format = (String) fieldProps.get("format");
        LinkedHashMap<String, Object> merged = new LinkedHashMap<>();
 * compatible open source license.
        }
    private OpenSearchSchemaBuilder() {}
     * <p>Operator dispatch on the UDTs is unaffected because both extend
    }
                // unsigned_long: values above 2^63 - 1 wrap into negatives because BIGINT is
     *
    static double parseScalingFactor(Object raw) {
            String fieldName = pathPrefix.isEmpty() ? fieldEntry.getKey() : pathPrefix + "." + fieldEntry.getKey();
                addLeafFields(builder, typeFactory, properties, "");
 */
                case "date_nanos" -> 9;
            };
        return buildTable(merged);
            LOGGER.log(Level.WARNING, "Invalid scaling_factor value: " + raw, e);
            // enumeration of cluster indices. get() registers on first lookup and caches under the
                continue;
        String pathPrefix
        }
     * SQL type. Returns {@code null} for unrecognized / unsupported field types.
            Object multiValue = fieldProps.get("multi_value");
                }
    private static final String SCALING_FACTOR_FIELD = "scaling_factor";
            // mapFieldType still returns BIGINT for unsigned_long; the UnsignedLongType marker
    }
     *
            case "match_only_text":
     * a Calcite "column not found" via the validator rather than a planner-time crash.
                            super.put(name, resolved);
            case "boolean":
            // Nested type (array-of-sub-docs) is a different beast — deferred.
                RelDataTypeFactory.Builder builder = typeFactory.builder();
                // TODO: values above 2^63 - 1 wrap into negatives. Drop the UInt64 → Int64 narrowing
/**
            } catch (IndexNotFoundException e) {
    public static SqlTypeName mapFieldType(String opensearchType) {
 * SPDX-License-Identifier: Apache-2.0
        }
            return Double.parseDouble(raw.toString());
        };
        for (Map.Entry<String, Object> fieldEntry : properties.entrySet()) {
                );
import org.opensearch.action.support.IndicesOptions;
                    IndicesOptions.lenientExpandOpen(),
        return buildLeafType(opensearchType, format, NO_SCALING_FACTOR, typeFactory);
            for (String name : concrete) {
        java.util.SortedMap<String, org.opensearch.cluster.metadata.IndexAbstraction> lookup = clusterState.metadata().getIndicesLookup();
     * that drives lazy resolution of expressions.
            }
    public static RelDataType buildLeafType(String opensearchType, RelDataTypeFactory typeFactory) {
        if (UnsignedLongType.NAME.equals(opensearchType)) {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
     * Maps an OpenSearch field type string to a Calcite SqlTypeName, or {@code null} when the type
    public static SchemaPlus buildSchema(ClusterState clusterState, IndexNameExpressionResolver resolver) {
        return buildSchema(clusterState, new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)));
     * one {@code IndexNameExpressionResolver} call plus a single mapping union.
                if (index != null) {
                // expand to its backings (the resolver normally excludes data streams from
                    Strings.splitStringByCommaToArray(expression)
            int precision = "date_nanos".equals(opensearchType) ? 9 : 3;
import org.opensearch.cluster.metadata.MappingMetadata;
import org.apache.calcite.schema.impl.AbstractTable;
            String fieldType = (String) fieldProps.get("type");
     * <ul>
     * else it returns the {@link SqlTypeName} from {@link #mapFieldType} as a nullable basic
            Map<String, Object> properties = (Map<String, Object>) mapping.sourceAsMap().get("properties");
     * Normalizes a scaling_factor value (Number or String from mapping JSON) to a double.
        switch (opensearchType) {
     * byte-range rewrite, equality / IN / BETWEEN coercion, and Substrait conversion all see
        }
     * Resolves a source expression (concrete name, alias, comma list, wildcard, exclusion, or
            try {
     *
            }
     * indices: construction is O(1) regardless of cluster size, and each referenced name costs
        } catch (NumberFormatException e) {
            // enables translator guards (negative-bound clamping, overflow rejection for values
            switch (DateFormatClassifier.classify(format)) {
import org.apache.calcite.schema.impl.AbstractSchema;
        // (which does not include hidden backings) doesn't filter out data stream backings. The
                return SqlTypeName.VARCHAR;
        return buildLeafType(opensearchType, null, typeFactory);
                continue;
            // correct List type and DataFusion's schema validation passes.
            MappingMetadata mapping = index.mapping();
                        }
        if (opensearchType == null) {
            return null;
                // unrecognized types are dropped). Legacy requires scaling_factor > 0 at index
            }
     * Builds the Calcite {@link RelDataType} for a leaf column given the OpenSearch field-type
        // type mapping to TIMESTAMP fails loudly rather than silently inheriting 3.
     *   <li>ip/binary -> VARBINARY</li>
        return CalciteSchema.createRootSchema(true, false, "", lazySchema).plus();
     * concrete indices, or {@code null} when nothing matches (so Calcite reports a clean "table not
            case "binary":
    /**
        if (BinaryType.NAME.equals(opensearchType)) {
        Schema lazySchema = new AbstractSchema() {
     *   <li>integer -> INTEGER, short -> SMALLINT, byte -> TINYINT</li>
    private static Table resolveTable(ClusterState clusterState, IndexNameExpressionResolver resolver, String expression) {
            // keySet iteration needed for production resolution. Callers that need name
        }
            return null;
    }
    }
                // (see schema_coerce.rs) when we have a proper solution.
import org.opensearch.core.common.Strings;
        }
     * is unrecognized. Callers omit the column from the schema so a query referencing it surfaces
            backing = new java.util.ArrayList<>(concrete.length);
                return SqlTypeName.SMALLINT;
                // creation; this guards only corrupted/hand-edited mappings.
    private static final double NO_SCALING_FACTOR = Double.NaN;
        try {
     *
     * <p>Tables are resolved lazily on first lookup, mirroring the sql-plugin
            if ("nested".equals(fieldType)) {
                // wildcard expansion otherwise). Literal data stream / alias names take the
     */
import org.apache.calcite.rel.type.RelDataType;
     */
     * @param scalingFactor positive factor for scaled_float fields; NaN when not applicable
     * the union; the planner's scan rule validates cross-index mapping compatibility when the table
            RelDataType columnType = buildLeafType(fieldType, format, scalingFactor, typeFactory);
                    }
                }
    }
                // column; a query referencing it surfaces a Calcite "column not found" via the
     * Builds a Calcite SchemaPlus from the given ClusterState.
        org.opensearch.cluster.metadata.IndexAbstraction abstraction = lookup == null ? null : lookup.get(expression);
                    return TimeOnlyType.nullable(typeFactory, precision);
        if (merged.isEmpty()) {
        if (IpType.NAME.equals(opensearchType)) {
     * string. For {@code ip} and {@code binary} this returns an {@link IpType} or
import org.opensearch.cluster.metadata.IndexMetadata;
                // we have a proper solution.
                    clusterState,
            }
     *       *_range, token_count, version, plus genuinely unknown plugin types) -> {@code null}</li>
            // get only resolved names back, which is fine when the lookup name is exact-case.
        // TIMESTAMP must carry sub-second precision: date → millis (3), date_nanos → nanos (9).
                // validator rather than a planning-time IllegalArgumentException.
        }
     * <p>The lazy schema is wrapped in a NON-caching root: a caching root enumerates
     */
        } else {
                default -> throw new IllegalStateException(
        if ("scaled_float".equals(opensearchType)) {
        }
            // Object types: implicit when "properties" is present without "type", or explicit "type: object".
     *   <li>double -> DOUBLE, float/half_float -> REAL</li>
            double scalingFactor = parseScalingFactor(fieldProps.get(SCALING_FACTOR_FIELD));
                return tableMap;
                return SqlTypeName.VARBINARY;
                    String name = ((String) key).toLowerCase(java.util.Locale.ROOT);
    private static final Logger LOGGER = Logger.getLogger(OpenSearchSchemaBuilder.class.getName());
                return SqlTypeName.TINYINT;
     *   <li>boolean -> BOOLEAN</li>
import java.util.logging.Logger;
    /**
            protected Map<String, Table> getTableMap() {
                // schema_coerce.rs) and downstream operators see Float32. Drop the widening when
import org.apache.calcite.jdbc.CalciteSchema;
            if (Boolean.TRUE.equals(multiValue)) {
                    return DateOnlyType.nullable(typeFactory, precision);
 */
     */
    /**
     *   <li>date/date_nanos -> TIMESTAMP</li>
                case "date" -> 3;
                return SqlTypeName.REAL;
 * The OpenSearch Contributors require contributions made to
     * Returns {@link Double#NaN} when the value is null or unparseable, signaling the caller
import java.util.HashMap;
            }
     * indices' supported fields are unioned into one row type. No upfront enumeration of cluster
        if (opensearchType == null) {
import java.util.List;
package org.opensearch.analytics.schema;
            }
            }
            return ScaledFloatType.nullable(typeFactory, scalingFactor);
            return NO_SCALING_FACTOR;
     * Full overload: handles format-aware date classification and scaled_float factor injection.
        if (sqlType == null) {
 * <p>One Calcite table per index. Reads field types from index mapping properties.
     * {@code OpenSearchSchema}. A requested name may be a concrete index, an alias, a comma list,
                // includeDataStreams=true so wildcards / comma-lists that match a data stream NAME
            case "date_nanos":
import org.opensearch.index.IndexNotFoundException;
    ) {
        // Without it the type defaults to precision 0 (→ millis downstream) and clashes with the
        }
                    "OpenSearch type '"
            case "long":
 *
        }
                columnType = typeFactory.createTypeWithNullability(columnType, true);
     * found"). Resolution goes through {@link IndexNameExpressionResolver} so schema membership
    }
     */
                return SqlTypeName.TIMESTAMP;
import org.opensearch.common.settings.Settings;
                // Unsupported (geo_point/shape/completion/…) or unknown plugin type. Drop the
import org.apache.calcite.schema.Table;
/*
                default:
        // Short-circuit literal alias / data stream names so the resolver's lenientExpandOpen
     * matches the execution-side {@code IndexResolution}. First-wins on field-name conflict across
        RelDataTypeFactory.Builder builder,
            };
    /** Format-aware overload: classifies {@code date}/{@code date_nanos} into DateOnly / TimeOnly UDT markers. */
     * <p>Type mapping:
        }
                case TIME_ONLY:
            public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        if ("date".equals(opensearchType) || "date_nanos".equals(opensearchType)) {
        }
     *       constant_keyword, wildcard, alias, dense_vector, sparse_vector, percolator,
}
            return IpType.nullable();
                        Table resolved = resolveTable(clusterState, resolver, name);
        }
     *   <li>long/unsigned_long/scaled_float -> BIGINT</li>
            case "text":
            return NO_SCALING_FACTOR;
                        + "precision; add a case in buildLeafType"
            if (properties == null) {
            default:
                continue;
        Map<String, Object> properties,
            // lower-cased name. PPL's RelBuilder.scan and Calcite's case-sensitive validator both
    /**
            // enumeration (Calcite's withCaseSensitive(false) parser path used in some unit tests)
                case DATE_ONLY:
        }
     * canonical resolution the execution-side {@code IndexResolution} uses — and the matching
    private static AbstractTable buildTable(Map<String, Object> properties) {
            if (Double.isNaN(scalingFactor) || scalingFactor <= 0) {
    public static RelDataType buildLeafType(String opensearchType, String format, double scalingFactor, RelDataTypeFactory typeFactory) {
            int precision = switch (opensearchType) {
            case "date":
                );
                        if (resolved != null) {
            }
            @Override
     * is referenced.
        // parquet read's Timestamp(Nanosecond) for date_nanos. Switch (not default) so an unforeseen
            case "byte":
            case "unsigned_long":
                }
     * to exclude the field.
        return typeFactory.createTypeWithNullability(base, true);
    }
     * has no scalar Calcite representation here (geo_point, geo_shape, nested, completion, …) or
                // signed and Substrait has no unsigned integer types. Smaller values are safe.
            builder.add(fieldName, columnType);
            @Override
            base = typeFactory.createSqlType(sqlType, precision);
     *   <li>everything else (geo_point, geo_shape, nested, object, flat_object, completion,
                // reader's SchemaAdapter casts Float16 → Float32 per batch.
            properties.forEach(merged::putIfAbsent);
    public static SchemaPlus buildSchema(ClusterState clusterState) {
                continue;
                return SqlTypeName.INTEGER;
            // above Long.MAX_VALUE) without affecting planner coercion.
            private final Map<String, Table> tableMap = new HashMap<>() {
                Map<String, Object> nested = (Map<String, Object>) fieldProps.get("properties");
     * @param opensearchType the OpenSearch field type string
        }
            if (fieldType == null || "object".equals(fieldType)) {
     *
        return new AbstractTable() {
import org.opensearch.common.util.concurrent.ThreadContext;
            // Recurse into sub-properties so dotted leaf paths ("city.location.latitude") appear as flat columns.
                    addLeafFields(builder, typeFactory, nested, fieldName);
            return BinaryType.nullable();
     */
            String[] concrete;
                return builder.build();
 * Builds a Calcite {@link SchemaPlus} from OpenSearch {@link ClusterState} index mappings.
     * </ul>
    }
                // splitting lets the resolver honor exclusions across tokens (e.g. "test*,-test1").
                // Missing, zero, or negative factor — exclude field from schema (matches how
        // alias / data-stream abstraction already carries the full backing list — use it directly.
            }
        List<IndexMetadata> backing;
            // reach the schema via getTable(name), which routes here directly — no entrySet /
                    return super.get(name);
            case "ip":
     *   <li>keyword/text/match_only_text -> VARCHAR</li>
        } else {
                if (nested != null) {
    /**
     * a wildcard, an exclusion, or date-math; it is resolved through {@code resolver} — the same
        };
                IndexMetadata index = clusterState.metadata().index(name);
    }
                return SqlTypeName.DOUBLE;
import org.apache.calcite.rel.type.RelDataTypeFactory;
            base = typeFactory.createSqlType(sqlType);
public class OpenSearchSchemaBuilder {
        if (sqlType == SqlTypeName.TIMESTAMP) {
            case "keyword":
            // The Calcite schema must declare them as ARRAY so the Substrait plan emits the
        }
            case "integer":
    @SuppressWarnings("unchecked")
            // Truly lazy table map, mirroring sql-plugin's OpenSearchSchema pattern: no upfront
        SqlTypeName sqlType = mapFieldType(opensearchType);
                // Comma-split first: concreteIndexNames treats each vararg as one expression, and
            }
            return null;
            Map<String, Object> fieldProps = (Map<String, Object>) fieldEntry.getValue();
     * {@link org.apache.calcite.sql.type.AbstractSqlType} with VARBINARY — the cidrmatch
            case "scaled_float":
import org.opensearch.cluster.ClusterState;
            case "short":
            case "float":
