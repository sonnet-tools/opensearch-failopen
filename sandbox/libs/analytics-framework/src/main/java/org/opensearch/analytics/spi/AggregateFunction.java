    PERCENTILE_APPROX(Type.STATE_EXPANDING, SqlKind.OTHER),
        throw new IllegalStateException("No AggregateFunction mapping for SqlAggFunction [" + op.getName() + "]");
    /**
    PATTERN(Type.STATE_EXPANDING, SqlKind.OTHER);
     * Returns true if the given aggregate call uses engine-native merge (single intermediate
    }
import org.apache.arrow.vector.types.pojo.ArrowType;
        if (byKind != null) {
import org.apache.calcite.sql.SqlFunction;
import org.apache.calcite.sql.type.SqlTypeName;
    /** Category of aggregate function; affects execution strategy (shuffle vs map-reduce). */
        STATISTICAL,
    STDDEV_SAMP(Type.STATISTICAL, SqlKind.STDDEV_SAMP),
    PERCENTILE_DISC(Type.STATE_EXPANDING, SqlKind.PERCENTILE_DISC),
 * The OpenSearch Contributors require contributions made to
                return func;
    }
            case APPROX_COUNT_DISTINCT -> SqlStdOperatorTable.APPROX_COUNT_DISTINCT;
            case MAX -> SqlStdOperatorTable.MAX;
        return fields != null && fields.size() == 1 && fields.get(0).reducer() == func;
    APPROX_COUNT_DISTINCT(Type.APPROXIMATE, SqlKind.OTHER, fields(IF("hll_registers", new ArrowType.Binary(), null))),
    }
        }
        AggregateFunction func;
            };
        STATE_EXPANDING,
import org.apache.calcite.sql.type.ReturnTypes;
            return fromNameOrError(op.getName());
        ReturnTypes.BIGINT_NULLABLE,
        try {
        null,
    FIRST(Type.STATE_EXPANDING, SqlKind.OTHER, fields(IF("first_state", IntermediateTypeResolver.passThroughArg0(), null))),
            if (func.sqlKind == kind && func.sqlKind != SqlKind.OTHER) {
        } catch (IllegalArgumentException e) {
    AggregateFunction(Type type, SqlKind sqlKind, List<IntermediateField> intermediateFields) {
    public SqlKind getSqlKind() {
    public static AggregateFunction fromSqlKind(SqlKind kind) {
        return switch (this) {
        "reduce_eval",
            case AVG -> SqlStdOperatorTable.AVG;
    /** Returns the UDAF name used by the reduce_eval UDF to evaluate partial state to a scalar. */
        List<IntermediateField> fields = func.intermediateFields();
    }
            return valueOf(name.toUpperCase(java.util.Locale.ROOT));
        SIMPLE,
        }
        static IntermediateTypeResolver fixed(ArrowType arrowType) {
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            // fall through
    }
    }
            case SUM -> SqlStdOperatorTable.SUM;
    public static AggregateFunction fromNameOrError(String name) {
            case COUNT -> SqlStdOperatorTable.COUNT;
 */
    VALUES(Type.STATE_EXPANDING, SqlKind.OTHER, fields(IF("values_state", IntermediateTypeResolver.passThroughArg0(), null))),
    MAX(Type.SIMPLE, SqlKind.MAX),
        };
    SUM0(Type.SIMPLE, SqlKind.SUM0),
        if (intermediateFields == null) return null;
        SqlKind.OTHER_FUNCTION,
            return switch (t) {
    private final Type type;
    private final List<IntermediateField> intermediateFields;
    /** Case-insensitive name lookup; throws if not recognized. */
/*
    public interface IntermediateTypeResolver {
    LIST(Type.STATE_EXPANDING, SqlKind.OTHER, fields(IF("list_state", IntermediateTypeResolver.passThroughArg0(), null))),
 * SPDX-License-Identifier: Apache-2.0
        OperandTypes.ANY_ANY,
        return intermediateFields.stream()
    AVG(Type.SIMPLE, SqlKind.AVG),
            throw new IllegalStateException("Unrecognized aggregate function [" + name + "]", e);
package org.opensearch.analytics.spi;
        } catch (IllegalStateException ignored) {
                case ArrowType.Binary b -> f.createSqlType(SqlTypeName.VARBINARY, Integer.MAX_VALUE);
            .toList();
    }
    ARG_MIN(Type.STATE_EXPANDING, SqlKind.ARG_MIN, fields(IF("arg_min_state", IntermediateTypeResolver.passThroughArg0(), null))),
            case MIN -> SqlStdOperatorTable.MIN;
        static RelDataType toCalcite(ArrowType t, RelDataTypeFactory f) {
            return false;
        }
                return argTypes.get(0);
        return sqlKind;
    private static IntermediateField IF(String name, IntermediateTypeResolver typeResolver, AggregateFunction reducer) {
            return byKind;
    );
    public static boolean isEngineNativeMerge(org.apache.calcite.rel.core.AggregateCall call) {
    STDDEV_POP(Type.STATISTICAL, SqlKind.STDDEV_POP),
            }
            func = fromSqlAggFunction(call.getAggregation());
/** Aggregate functions a backend may support, categorized by {@link Type}. */
 * this file be licensed under the Apache-2.0 license or a
        this.intermediateFields = intermediateFields;
    public List<IntermediateField> intermediateFields() {
import org.apache.calcite.sql.SqlOperator;
        AggregateFunction byKind = fromSqlKind(op.getKind());
    private static IntermediateField IF(String name, ArrowType arrowType, AggregateFunction reducer) {
    ARG_MAX(Type.STATE_EXPANDING, SqlKind.ARG_MAX, fields(IF("arg_max_state", IntermediateTypeResolver.passThroughArg0(), null))),
        };
        }
        APPROXIMATE
    public static AggregateFunction fromSqlAggFunction(SqlAggFunction op) {
        this.type = type;
    }
    }
    AggregateFunction(Type type, SqlKind sqlKind) {
    // earliest(value, ts) / latest(value, ts); rewritten to first_value/last_value by PplAggregateCallRewriter.
    }
        return new IntermediateField(name, typeResolver, reducer);
        }
    /** Evaluates opaque engine-native-merge state to a sortable scalar (used by TopK). */
    }
    public static final SqlOperator REDUCE_EVAL_OP = new SqlFunction(
        return switch (this) {
        try {
    TAKE(Type.STATE_EXPANDING, SqlKind.OTHER, fields(IF("take_state", IntermediateTypeResolver.passThroughArg0(), null))),
    }
        return type;
    }
     * field whose reducer is the function itself — e.g. APPROX_COUNT_DISTINCT with HLL sketches).
                if (argTypes.isEmpty()) {
    private final SqlKind sqlKind;
        static IntermediateTypeResolver passThroughArg0() {
import org.apache.calcite.sql.SqlKind;
public enum AggregateFunction {
 * compatible open source license.
        return List.of(fs);
    COLLECT(Type.STATE_EXPANDING, SqlKind.COLLECT),
            return (argTypes, typeFactory) -> ArrowToCalciteTypeMapper.toCalcite(arrowType, typeFactory);
    LISTAGG(Type.STATE_EXPANDING, SqlKind.LISTAGG),
    public SqlAggFunction toSqlAggFunction() {
import org.apache.calcite.rel.type.RelDataType;
    PERCENTILE_CONT(Type.STATE_EXPANDING, SqlKind.PERCENTILE_CONT),
        SqlFunctionCategory.USER_DEFINED_FUNCTION
    private static final class ArrowToCalciteTypeMapper {
                    throw new IllegalStateException("passThroughArg0 resolver requires at least one arg type");
        this.sqlKind = sqlKind;
    public Type getType() {
            .map(f -> f.reducer() == null ? new IntermediateField(f.name(), f.typeResolver(), this) : f)
        this(type, sqlKind, null);
    /** Intermediate field of a partial aggregate; {@code null} reducer means "self". */
import java.util.List;
    }
    COUNT(Type.SIMPLE, SqlKind.COUNT, fields(IF("count", new ArrowType.Int(64, true), SUM))),
    }
        return intermediateFields != null;
        }
                }
    private static List<IntermediateField> fields(IntermediateField... fs) {
    @FunctionalInterface
    }
import org.apache.calcite.sql.SqlFunctionCategory;
    LAST(Type.STATE_EXPANDING, SqlKind.OTHER, fields(IF("last_state", IntermediateTypeResolver.passThroughArg0(), null))),
 *
    public enum Type {
    /** Resolves the Calcite type of an intermediate field from a FINAL aggregate's arg types. */
    public record IntermediateField(String name, IntermediateTypeResolver typeResolver, AggregateFunction reducer) {
        return new IntermediateField(name, IntermediateTypeResolver.fixed(arrowType), reducer);
    }
            case SUM0 -> SqlStdOperatorTable.SUM0;
     */
        RelDataType resolve(List<RelDataType> argTypes, RelDataTypeFactory typeFactory);
import org.apache.calcite.sql.type.OperandTypes;
        for (AggregateFunction func : values()) {
        try {
    MIN(Type.SIMPLE, SqlKind.MIN),
    SUM(Type.SIMPLE, SqlKind.SUM),
            default -> throw new IllegalStateException(this + " has no reduce_eval mapping");
                default -> throw new IllegalArgumentException("Unsupported fixed Arrow type for IntermediateField: " + t);
    public boolean hasDecomposition() {
        }
            };
            return (argTypes, typeFactory) -> {
    }
    public String reduceEvalName() {
    VAR_SAMP(Type.STATISTICAL, SqlKind.VAR_SAMP),
    }
                case ArrowType.Int i when i.getBitWidth() == 64 -> f.createSqlType(SqlTypeName.BIGINT);
        } catch (IllegalStateException e) {
        }
        return null;
import org.apache.calcite.sql.SqlAggFunction;
            case APPROX_COUNT_DISTINCT -> "approx_distinct";
            default -> throw new IllegalStateException("No SqlAggFunction mapping for: " + this);
}
import org.apache.calcite.rel.type.RelDataTypeFactory;
    VAR_POP(Type.STATISTICAL, SqlKind.VAR_POP),
