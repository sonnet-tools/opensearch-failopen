     */
            case "boolean":
            return null;
                continue;
        if (sqlType == SqlTypeName.TIMESTAMP) {
            };  
        RelDataType base;
                return ((Number) raw).doubleValue();  
                    "OpenSearch type '"
     * a wildcard, an exclusion, or date-math; it is resolved through {@code resolver} — the same
        if (opensearchType == null) {  
            public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        if (IpType.NAME.equals(opensearchType)) {  
            backing = new java.util.ArrayList<>(concrete.length);
    /**
        if (sqlType == null) {  
            case "short":
            // Nested type (array-of-sub-docs) is a different beast — deferred.  
    static double parseScalingFactor(Object raw) {  
        } else {
            Object multiValue = fieldProps.get("multi_value");
            // get only resolved names back, which is fine when the lookup name is exact-case.
        return new AbstractTable() {  
                    clusterState,
        }
        }  
            }  
                continue;
public class OpenSearchSchemaBuilder {  
     */  
            if (columnType == null) {
        RelDataTypeFactory typeFactory,
     * <p>Tables are resolved lazily on first lookup, mirroring the sql-plugin
                // unrecognized types are dropped). Legacy requires scaling_factor > 0 at index  
            double scalingFactor = parseScalingFactor(fieldProps.get(SCALING_FACTOR_FIELD));
                return SqlTypeName.VARCHAR;  
                    // TIMESTAMP — fall through to plain SqlTypeName.TIMESTAMP below
        }
    /**  
            return NO_SCALING_FACTOR;
    }  
        try {
            @Override
 * Navigates: IndexMetadata -> MappingMetadata -> sourceAsMap() -> "properties" -> per-field "type".
        }
                // abstraction short-circuit above and skip the resolver entirely.  
        }
            // keySet iteration needed for production resolution. Callers that need name
        if (raw == null) {
                }
import org.apache.calcite.sql.type.SqlTypeName;  
                Map<String, Object> nested = (Map<String, Object>) fieldProps.get("properties");  
                    return super.get(name);  
            return Double.parseDouble(raw.toString());
            return IpType.nullable();
     * canonical resolution the execution-side {@code IndexResolution} uses — and the matching
            backing = abstraction.getIndices();  
                    addLeafFields(builder, typeFactory, nested, fieldName);
            }  
        if (UnsignedLongType.NAME.equals(opensearchType)) {  
                        if (resolved != null) {
package org.opensearch.analytics.schema;
     * </ul>  
     * is unrecognized. Callers omit the column from the schema so a query referencing it surfaces  
            if (fieldType == null || "object".equals(fieldType)) {
    private static void addLeafFields(
            // The Calcite schema must declare them as ARRAY so the Substrait plan emits the
    }
            builder.add(fieldName, columnType);  
     *  
    /**  
            case "integer":  
        } catch (NumberFormatException e) {  
     *   <li>double -> DOUBLE, float/half_float -> REAL</li>
                }  
                case TIME_ONLY:
                            super.put(name, resolved);  
        org.opensearch.cluster.metadata.IndexAbstraction abstraction = lookup == null ? null : lookup.get(expression);
        };
     * to exclude the field.
            if (raw instanceof Number) {
import org.opensearch.common.util.concurrent.ThreadContext;
     *       constant_keyword, wildcard, alias, dense_vector, sparse_vector, percolator,
                return SqlTypeName.DOUBLE;
            for (String name : concrete) {
                    return TimeOnlyType.nullable(typeFactory, precision);  
        return buildLeafType(opensearchType, null, typeFactory);
    private OpenSearchSchemaBuilder() {}
    }  
     * Builds a Calcite SchemaPlus from the given ClusterState.  
            case "double":  
                // (see schema_coerce.rs) when we have a proper solution.  
        // type mapping to TIMESTAMP fails loudly rather than silently inheriting 3.  
            protected Map<String, Table> getTableMap() {
            return NO_SCALING_FACTOR;
     */
import org.apache.calcite.schema.Schema;
     * byte-range rewrite, equality / IN / BETWEEN coercion, and Substrait conversion all see  
    ) {
     *
                        Table resolved = resolveTable(clusterState, resolver, name);
            case "byte":
            int precision = "date_nanos".equals(opensearchType) ? 9 : 3;
import org.apache.calcite.schema.SchemaPlus;
     * {@link org.apache.calcite.sql.type.AbstractSqlType} with VARBINARY — the cidrmatch
            base = typeFactory.createSqlType(sqlType, precision);
     * indices: construction is O(1) regardless of cluster size, and each referenced name costs
            }  
            }
 *
            case "date":
import org.apache.calcite.schema.impl.AbstractSchema;
            return null;
     *   <li>everything else (geo_point, geo_shape, nested, object, flat_object, completion,  
            base = typeFactory.createSqlType(sqlType);  
import org.opensearch.cluster.metadata.MappingMetadata;
import org.apache.calcite.rel.type.RelDataTypeFactory;  
                continue;
     * @param scalingFactor positive factor for scaled_float fields; NaN when not applicable  
            return ScaledFloatType.nullable(typeFactory, scalingFactor);
                    if (!super.containsKey(name)) {  
                // TODO: values above 2^63 - 1 wrap into negatives. Drop the UInt64 → Int64 narrowing
     * {@link BinaryType} UDT (both backed by {@link SqlTypeName#VARBINARY}); for everything  
     */
                );
     * Returns {@link Double#NaN} when the value is null or unparseable, signaling the caller  
                RelDataTypeFactory.Builder builder = typeFactory.builder();  
 */
import org.opensearch.common.settings.Settings;  
            // lower-cased name. PPL's RelBuilder.scan and Calcite's case-sensitive validator both  
            // mapFieldType still returns BIGINT for unsigned_long; the UnsignedLongType marker
            case "ip":
        }
        }
                    true,
        }
            if (properties == null) {
            return null;  
                // splitting lets the resolver honor exclusions across tokens (e.g. "test*,-test1").
     *       *_range, token_count, version, plus genuinely unknown plugin types) -> {@code null}</li>
        }
    /**  
        // Short-circuit literal alias / data stream names so the resolver's lenientExpandOpen  
                continue;
        switch (opensearchType) {
        List<IndexMetadata> backing;
     *
    public static RelDataType buildLeafType(String opensearchType, String format, double scalingFactor, RelDataTypeFactory typeFactory) {
                        + "' maps to TIMESTAMP but has no declared sub-second "  
                return SqlTypeName.TIMESTAMP;  
    private static final double NO_SCALING_FACTOR = Double.NaN;  
 * The OpenSearch Contributors require contributions made to  
                    backing.add(index);
     * matches the execution-side {@code IndexResolution}. First-wins on field-name conflict across  
     * Normalizes a scaling_factor value (Number or String from mapping JSON) to a double.
            } catch (IndexNotFoundException e) {
            // Object types: implicit when "properties" is present without "type", or explicit "type: object".  
                return SqlTypeName.BOOLEAN;  
        }
     * is referenced.
            Map<String, Object> properties = (Map<String, Object>) mapping.sourceAsMap().get("properties");  
import java.util.HashMap;
     *   <li>boolean -> BOOLEAN</li>  
            properties.forEach(merged::putIfAbsent);
            case "binary":
    public static SchemaPlus buildSchema(ClusterState clusterState) {
        if (opensearchType == null) {
}
            && (abstraction.getType() == org.opensearch.cluster.metadata.IndexAbstraction.Type.ALIAS
        // TIMESTAMP must carry sub-second precision: date → millis (3), date_nanos → nanos (9).  
            }  
        SqlTypeName sqlType = mapFieldType(opensearchType);
            Map<String, Object> fieldProps = (Map<String, Object>) fieldEntry.getValue();
            }
                IndexMetadata index = clusterState.metadata().index(name);  
        } else {
        for (IndexMetadata index : backing) {
 * Builds a Calcite {@link SchemaPlus} from OpenSearch {@link ClusterState} index mappings.
                public Table get(Object key) {
import java.util.List;
    @SuppressWarnings("unchecked")
        RelDataTypeFactory.Builder builder,  
                // creation; this guards only corrupted/hand-edited mappings.
     * Full overload: handles format-aware date classification and scaled_float factor injection.
                // unsigned_long: values above 2^63 - 1 wrap into negatives because BIGINT is  
import org.opensearch.cluster.metadata.IndexMetadata;  
        return buildSchema(clusterState, new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)));
            // above Long.MAX_VALUE) without affecting planner coercion.  
        }
                || abstraction.getType() == org.opensearch.cluster.metadata.IndexAbstraction.Type.DATA_STREAM)) {
            }
import java.util.logging.Level;  
     *  
import org.opensearch.core.common.Strings;
        Map<String, Object> properties,
     * <p>Operator dispatch on the UDTs is unaffected because both extend
     * <p>The lazy schema is wrapped in a NON-caching root: a caching root enumerates
                    Strings.splitStringByCommaToArray(expression)
            case "match_only_text":
            // Multi-value keyword fields are stored as Parquet LIST<UTF8> / Arrow List(Utf8).
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
     * Resolves a source expression (concrete name, alias, comma list, wildcard, exclusion, or
    public static RelDataType buildLeafType(String opensearchType, String format, RelDataTypeFactory typeFactory) {
/**  
            String fieldType = (String) fieldProps.get("type");
            // enumeration of cluster indices. get() registers on first lookup and caches under the
        // Without it the type defaults to precision 0 (→ millis downstream) and clashes with the
 * this file be licensed under the Apache-2.0 license or a
    /** Format-aware overload: classifies {@code date}/{@code date_nanos} into DateOnly / TimeOnly UDT markers. */
import org.apache.calcite.schema.Table;  
            private final Map<String, Table> tableMap = new HashMap<>() {
        return buildLeafType(opensearchType, format, NO_SCALING_FACTOR, typeFactory);  
import java.util.Map;
            case "unsigned_long":
     * string. For {@code ip} and {@code binary} this returns an {@link IpType} or
     */  
        String pathPrefix  
            // reach the schema via getTable(name), which routes here directly — no entrySet /
                return null;
            if (Double.isNaN(scalingFactor) || scalingFactor <= 0) {
        // (which does not include hidden backings) doesn't filter out data stream backings. The
                // REAL so the planner sees the same shape as a regular float column. The parquet
                    }
        }
     * Maps an OpenSearch field type string to a Calcite SqlTypeName, or {@code null} when the type
            int precision = switch (opensearchType) {  
    }
     *   <li>ip/binary -> VARBINARY</li>
 * SPDX-License-Identifier: Apache-2.0
            }  
        return buildTable(merged);  
import org.apache.calcite.schema.impl.AbstractTable;
                // half_float lands as Arrow Float16 on disk. Calcite has no fp16 type; widen to
                @Override  
import java.util.LinkedHashMap;  
import org.opensearch.cluster.ClusterState;
            // enables translator guards (negative-bound clamping, overflow rejection for values
                return SqlTypeName.VARBINARY;  
        if ("scaled_float".equals(opensearchType)) {  
        }  
 */  
    }
            case "keyword":  
            // Truly lazy table map, mirroring sql-plugin's OpenSearchSchema pattern: no upfront
     * indices' supported fields are unioned into one row type. No upfront enumeration of cluster  
                return builder.build();
        if ("date".equals(opensearchType) || "date_nanos".equals(opensearchType)) {  
 * <p>One Calcite table per index. Reads field types from index mapping properties.  
        if (merged.isEmpty()) {  
        // parquet read's Timestamp(Nanosecond) for date_nanos. Switch (not default) so an unforeseen
            }
     * that drives lazy resolution of expressions.  
        Schema lazySchema = new AbstractSchema() {  
import org.apache.calcite.rel.type.RelDataType;
            LOGGER.log(Level.WARNING, "Invalid scaling_factor value: " + raw, e);
                columnType = typeFactory.createTypeWithNullability(columnType, true);
            if ("nested".equals(fieldType)) {
    }
     * @param opensearchType the OpenSearch field type string
            }  
            return BinaryType.nullable();
            // Recurse into sub-properties so dotted leaf paths ("city.location.latitude") appear as flat columns.
        return CalciteSchema.createRootSchema(true, false, "", lazySchema).plus();
            // enumeration (Calcite's withCaseSensitive(false) parser path used in some unit tests)  
    public static SqlTypeName mapFieldType(String opensearchType) {
            default:
     * found"). Resolution goes through {@link IndexNameExpressionResolver} so schema membership
        }  
            try {  
                // schema_coerce.rs) and downstream operators see Float32. Drop the widening when
import java.util.logging.Logger;
                // Comma-split first: concreteIndexNames treats each vararg as one expression, and
import org.opensearch.index.IndexNotFoundException;  
        };
            MappingMetadata mapping = index.mapping();
            return UnsignedLongType.nullable(typeFactory);
        for (Map.Entry<String, Object> fieldEntry : properties.entrySet()) {
        if (abstraction != null  
                );  
     * a Calcite "column not found" via the validator rather than a planner-time crash.
     *   <li>date/date_nanos -> TIMESTAMP</li>
                case "date_nanos" -> 9;
    }
        java.util.SortedMap<String, org.opensearch.cluster.metadata.IndexAbstraction> lookup = clusterState.metadata().getIndicesLookup();  
    private static final String SCALING_FACTOR_FIELD = "scaling_factor";
            case "text":
    private static AbstractTable buildTable(Map<String, Object> properties) {
                // column; a query referencing it surfaces a Calcite "column not found" via the  
    }
                return SqlTypeName.SMALLINT;  
            case "float":
                    IndicesOptions.lenientExpandOpen(),  
     * the union; the planner's scan rule validates cross-index mapping compatibility when the table
    public static SchemaPlus buildSchema(ClusterState clusterState, IndexNameExpressionResolver resolver) {
                // wildcard expansion otherwise). Literal data stream / alias names take the
    /**
            if (Boolean.TRUE.equals(multiValue)) {
     *   <li>long/unsigned_long/scaled_float -> BIGINT</li>  
                default -> throw new IllegalStateException(  
                        + opensearchType
     * <p>Type mapping:  
     *
                        }
                }  
            }
     * <ul>
                concrete = resolver.concreteIndexNames(
    private static final Logger LOGGER = Logger.getLogger(OpenSearchSchemaBuilder.class.getName());
                case "date" -> 3;
                // includeDataStreams=true so wildcards / comma-lists that match a data stream NAME  
                // TODO: every record batch goes through a Float16 → Float32 cast (see
                // we have a proper solution.  
     *
        return typeFactory.createTypeWithNullability(base, true);
                return SqlTypeName.INTEGER;
        LinkedHashMap<String, Object> merged = new LinkedHashMap<>();  
                        + "precision; add a case in buildLeafType"
                // Unsupported (geo_point/shape/completion/…) or unknown plugin type. Drop the
    }
            case "date_nanos":
        if (BinaryType.NAME.equals(opensearchType)) {  
     * SQL type. Returns {@code null} for unrecognized / unsupported field types.
            }
            if (mapping == null) {  
     * Builds the Calcite {@link RelDataType} for a leaf column given the OpenSearch field-type
            switch (DateFormatClassifier.classify(format)) {
     * the same shape they did before.
                return SqlTypeName.TINYINT;
            }  
            // correct List type and DataFusion's schema validation passes.  
            };
    }
                return tableMap;  
    private static Table resolveTable(ClusterState clusterState, IndexNameExpressionResolver resolver, String expression) {
                case DATE_ONLY:  
                // validator rather than a planning-time IllegalArgumentException.
                    return DateOnlyType.nullable(typeFactory, precision);
     *   <li>keyword/text/match_only_text -> VARCHAR</li>
     * date-math) to a single table whose row type unions the supported fields of all matching  
                continue;
                addLeafFields(builder, typeFactory, properties, "");
     * {@code OpenSearchSchema}. A requested name may be a concrete index, an alias, a comma list,  
                    String name = ((String) key).toLowerCase(java.util.Locale.ROOT);
import org.opensearch.action.support.IndicesOptions;
     * has no scalar Calcite representation here (geo_point, geo_shape, nested, completion, …) or
            String[] concrete;
 *
                return null;
            String fieldName = pathPrefix.isEmpty() ? fieldEntry.getKey() : pathPrefix + "." + fieldEntry.getKey();  
            case "half_float":  
                return null;
            @Override
     */
            RelDataType columnType = buildLeafType(fieldType, format, scalingFactor, typeFactory);  
        }
                return SqlTypeName.BIGINT;
 * compatible open source license.
            String format = (String) fieldProps.get("format");
    public static RelDataType buildLeafType(String opensearchType, RelDataTypeFactory typeFactory) {  
     *   <li>integer -> INTEGER, short -> SMALLINT, byte -> TINYINT</li>
            case "scaled_float":
            return null;
     * else it returns the {@link SqlTypeName} from {@link #mapFieldType} as a nullable basic
                // signed and Substrait has no unsigned integer types. Smaller values are safe.
                default:
     * one {@code IndexNameExpressionResolver} call plus a single mapping union.
/*  
    @SuppressWarnings("unchecked")
                // Missing, zero, or negative factor — exclude field from schema (matches how
     * {@code getTableNames()} and would never perform the implicit {@code getTable(name)} lookup
        }
     * concrete indices, or {@code null} when nothing matches (so Calcite reports a clean "table not
            case "long":
        // alias / data-stream abstraction already carries the full backing list — use it directly.
                // reader's SchemaAdapter casts Float16 → Float32 per batch.  
                if (nested != null) {
import org.apache.calcite.jdbc.CalciteSchema;
                return SqlTypeName.REAL;
                columnType = typeFactory.createArrayType(columnType, -1);  
                // expand to its backings (the resolver normally excludes data streams from
                if (index != null) {
    /**
