    }  
     */
    FIRST(Type.STATE_EXPANDING, SqlKind.OTHER, fields(IF("first_state", IntermediateTypeResolver.passThroughArg0(), null))),
    public static final SqlOperator REDUCE_EVAL_OP = new SqlFunction(
        }  
        try {  
        List<IntermediateField> fields = func.intermediateFields();
     * Returns true if the given aggregate call uses engine-native merge (single intermediate
import org.apache.calcite.sql.SqlAggFunction;
    public SqlAggFunction toSqlAggFunction() {
        SqlKind.OTHER_FUNCTION,  
            case AVG -> SqlStdOperatorTable.AVG;
                case ArrowType.Int i when i.getBitWidth() == 64 -> f.createSqlType(SqlTypeName.BIGINT);  
        return intermediateFields.stream()
    /** Category of aggregate function; affects execution strategy (shuffle vs map-reduce). */
            return (argTypes, typeFactory) -> ArrowToCalciteTypeMapper.toCalcite(arrowType, typeFactory);
        if (byKind != null) {  
        return null;
            default -> throw new IllegalStateException("No SqlAggFunction mapping for: " + this);
                default -> throw new IllegalArgumentException("Unsupported fixed Arrow type for IntermediateField: " + t);
import org.apache.calcite.sql.type.SqlTypeName;  
        static IntermediateTypeResolver passThroughArg0() {
    /** Intermediate field of a partial aggregate; {@code null} reducer means "self". */
    VAR_POP(Type.STATISTICAL, SqlKind.VAR_POP),  
    PERCENTILE_CONT(Type.STATE_EXPANDING, SqlKind.PERCENTILE_CONT),  
/*  
package org.opensearch.analytics.spi;
        }  
                return func;
import org.apache.calcite.sql.SqlOperator;
/** Aggregate functions a backend may support, categorized by {@link Type}. */
            .map(f -> f.reducer() == null ? new IntermediateField(f.name(), f.typeResolver(), this) : f)
    APPROX_COUNT_DISTINCT(Type.APPROXIMATE, SqlKind.OTHER, fields(IF("hll_registers", new ArrowType.Binary(), null))),  
    private final Type type;
        "reduce_eval",
            return (argTypes, typeFactory) -> {  
    }
    }
    public record IntermediateField(String name, IntermediateTypeResolver typeResolver, AggregateFunction reducer) {
    MAX(Type.SIMPLE, SqlKind.MAX),  
            default -> throw new IllegalStateException(this + " has no reduce_eval mapping");  
        return fields != null && fields.size() == 1 && fields.get(0).reducer() == func;  
    private static final class ArrowToCalciteTypeMapper {  
    STDDEV_SAMP(Type.STATISTICAL, SqlKind.STDDEV_SAMP),
            case MAX -> SqlStdOperatorTable.MAX;  
 * compatible open source license.
    }
            case SUM0 -> SqlStdOperatorTable.SUM0;
        return switch (this) {
    }
        } catch (IllegalStateException e) {
    VAR_SAMP(Type.STATISTICAL, SqlKind.VAR_SAMP),
    PATTERN(Type.STATE_EXPANDING, SqlKind.OTHER);  
    private final List<IntermediateField> intermediateFields;  
        }
        SIMPLE,
                if (argTypes.isEmpty()) {
     * field whose reducer is the function itself — e.g. APPROX_COUNT_DISTINCT with HLL sketches).  
            return valueOf(name.toUpperCase(java.util.Locale.ROOT));
    public static boolean isEngineNativeMerge(org.apache.calcite.rel.core.AggregateCall call) {
    public Type getType() {  
 * this file be licensed under the Apache-2.0 license or a
    public interface IntermediateTypeResolver {
        null,
import org.apache.calcite.sql.SqlFunction;
    STDDEV_POP(Type.STATISTICAL, SqlKind.STDDEV_POP),
    AggregateFunction(Type type, SqlKind sqlKind) {
        };
        static RelDataType toCalcite(ArrowType t, RelDataTypeFactory f) {
        STATE_EXPANDING,  
    }
    }
    }  
import org.apache.calcite.sql.type.OperandTypes;
                case ArrowType.Binary b -> f.createSqlType(SqlTypeName.VARBINARY, Integer.MAX_VALUE);
 *
    COLLECT(Type.STATE_EXPANDING, SqlKind.COLLECT),  
            case SUM -> SqlStdOperatorTable.SUM;  
import org.apache.calcite.sql.type.ReturnTypes;
        }
        } catch (IllegalStateException ignored) {
        }
            throw new IllegalStateException("Unrecognized aggregate function [" + name + "]", e);  
    TAKE(Type.STATE_EXPANDING, SqlKind.OTHER, fields(IF("take_state", IntermediateTypeResolver.passThroughArg0(), null))),
    LAST(Type.STATE_EXPANDING, SqlKind.OTHER, fields(IF("last_state", IntermediateTypeResolver.passThroughArg0(), null))),  
    LIST(Type.STATE_EXPANDING, SqlKind.OTHER, fields(IF("list_state", IntermediateTypeResolver.passThroughArg0(), null))),
    private static IntermediateField IF(String name, ArrowType arrowType, AggregateFunction reducer) {
import org.apache.calcite.rel.type.RelDataType;
    // earliest(value, ts) / latest(value, ts); rewritten to first_value/last_value by PplAggregateCallRewriter.
    VALUES(Type.STATE_EXPANDING, SqlKind.OTHER, fields(IF("values_state", IntermediateTypeResolver.passThroughArg0(), null))),
    COUNT(Type.SIMPLE, SqlKind.COUNT, fields(IF("count", new ArrowType.Int(64, true), SUM))),
        if (intermediateFields == null) return null;  
        OperandTypes.ANY_ANY,  
    /** Case-insensitive name lookup; throws if not recognized. */
    /**
    ARG_MAX(Type.STATE_EXPANDING, SqlKind.ARG_MAX, fields(IF("arg_max_state", IntermediateTypeResolver.passThroughArg0(), null))),  
    public static AggregateFunction fromNameOrError(String name) {
    MIN(Type.SIMPLE, SqlKind.MIN),
    }
        return type;
        this(type, sqlKind, null);  
 * SPDX-License-Identifier: Apache-2.0
            .toList();  
import java.util.List;
    SUM(Type.SIMPLE, SqlKind.SUM),  
    public static AggregateFunction fromSqlKind(SqlKind kind) {
    ARG_MIN(Type.STATE_EXPANDING, SqlKind.ARG_MIN, fields(IF("arg_min_state", IntermediateTypeResolver.passThroughArg0(), null))),
    }  
        }
    /** Resolves the Calcite type of an intermediate field from a FINAL aggregate's arg types. */
        }
        try {  
    /** Evaluates opaque engine-native-merge state to a sortable scalar (used by TopK). */  
            func = fromSqlAggFunction(call.getAggregation());
            case APPROX_COUNT_DISTINCT -> SqlStdOperatorTable.APPROX_COUNT_DISTINCT;  
    private static IntermediateField IF(String name, IntermediateTypeResolver typeResolver, AggregateFunction reducer) {
    /** Returns the UDAF name used by the reduce_eval UDF to evaluate partial state to a scalar. */
    public static AggregateFunction fromSqlAggFunction(SqlAggFunction op) {
            }
            };  
 * The OpenSearch Contributors require contributions made to  
        for (AggregateFunction func : values()) {
        SqlFunctionCategory.USER_DEFINED_FUNCTION
        throw new IllegalStateException("No AggregateFunction mapping for SqlAggFunction [" + op.getName() + "]");  
}
    }
            return fromNameOrError(op.getName());
    private final SqlKind sqlKind;
        }  
    SUM0(Type.SIMPLE, SqlKind.SUM0),
    }
            case COUNT -> SqlStdOperatorTable.COUNT;
            return byKind;
        return new IntermediateField(name, IntermediateTypeResolver.fixed(arrowType), reducer);
            if (func.sqlKind == kind && func.sqlKind != SqlKind.OTHER) {  
    LISTAGG(Type.STATE_EXPANDING, SqlKind.LISTAGG),
        return List.of(fs);
        static IntermediateTypeResolver fixed(ArrowType arrowType) {
        };
    private static List<IntermediateField> fields(IntermediateField... fs) {  
        STATISTICAL,
            // fall through  
        ReturnTypes.BIGINT_NULLABLE,
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        return sqlKind;
    public String reduceEvalName() {  
        this.sqlKind = sqlKind;
        AggregateFunction func;
        return new IntermediateField(name, typeResolver, reducer);  
    }
            };
            return switch (t) {
        try {  
    }
    PERCENTILE_APPROX(Type.STATE_EXPANDING, SqlKind.OTHER),
        AggregateFunction byKind = fromSqlKind(op.getKind());
public enum AggregateFunction {
    );
            case APPROX_COUNT_DISTINCT -> "approx_distinct";
import org.apache.calcite.sql.SqlFunctionCategory;  
        } catch (IllegalArgumentException e) {
        this.intermediateFields = intermediateFields;  
    PERCENTILE_DISC(Type.STATE_EXPANDING, SqlKind.PERCENTILE_DISC),
            return false;  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
    }  
    }
            case MIN -> SqlStdOperatorTable.MIN;
                }  
    public boolean hasDecomposition() {  
                    throw new IllegalStateException("passThroughArg0 resolver requires at least one arg type");
 */  
        return switch (this) {
        this.type = type;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.calcite.sql.SqlKind;
    }
    }
    public SqlKind getSqlKind() {
        APPROXIMATE
                return argTypes.get(0);
        return intermediateFields != null;
    public enum Type {  
    public List<IntermediateField> intermediateFields() {
    AggregateFunction(Type type, SqlKind sqlKind, List<IntermediateField> intermediateFields) {  
    }
        RelDataType resolve(List<RelDataType> argTypes, RelDataTypeFactory typeFactory);
    AVG(Type.SIMPLE, SqlKind.AVG),
    @FunctionalInterface  
