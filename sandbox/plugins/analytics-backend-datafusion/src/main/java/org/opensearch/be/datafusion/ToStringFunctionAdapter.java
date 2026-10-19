        /**
        if (operands.size() == 1) {
        }  
            return operand;
            original.getType().isNullable()
    private static boolean isFractional(SqlTypeName type) {
import org.apache.calcite.rex.RexCall;
class ToStringFunctionAdapter implements ScalarFunctionAdapter {
        return cluster.getRexBuilder().makeCall(original.getType(), TOSTRING, List.of(normalized, formatLit));
 *       CAST.
         */  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
    /**
            return isFractional(source) ? SqlTypeName.DOUBLE : SqlTypeName.BIGINT;
import org.opensearch.analytics.spi.ScalarFunction;  
    /**
                SqlStdOperatorTable.CASE,  
}
            if (mode != null) {  
        List<RexNode> operands = original.getOperands();  
        return sqlType == SqlTypeName.CHAR || sqlType == SqlTypeName.VARCHAR;
        OperandTypes.family(),  
 * </ol>  
import org.apache.calcite.sql.SqlFunctionCategory;
 * Rewrites PPL {@code tostring(value[, format])} into a DataFusion-compatible expression.
 *       We treat it as the single-arg {@code tostring} shape and lower it to a plain VARCHAR  
        SqlTypeName sqlType = literal.getType().getSqlTypeName();  
import org.apache.calcite.rex.RexLiteral;
            );
        if (operand.getType().getSqlTypeName() == target) {
 * <p>Handles two arrival shapes:
        if (operands.size() == 2 && operands.get(1) instanceof RexLiteral formatLit && isStringLiteral(formatLit)) {
 *
        SqlFunctionCategory.USER_DEFINED_FUNCTION
        ReturnTypes.VARCHAR,
        RelDataType varcharType = factory.createTypeWithNullability(
    }
     * gives the isthmus name-based resolver a deterministic hook; we don't have to rely on the
            for (Format f : values()) {
        RexNode falseLit = cluster.getRexBuilder().makeLiteral("FALSE");
        RelDataTypeFactory factory = cluster.getTypeFactory();
    /**
                return fixedTarget;  
        if (ScalarFunction.NUMBER_TO_STRING.name().equalsIgnoreCase(original.getOperator().getName())) {  
/**  
        HEX("hex", SqlTypeName.BIGINT),
    private static RexNode makeVarcharCast(RexCall original, RexNode value, RelOptCluster cluster) {  
 */  
     * shape of the PPL operator but is keyed on the literal name {@code "tostring"} — which is
        }  
            original.getType().isNullable()
    }  
            if (modeLiteral == null) return null;  
        RexNode trueLit = cluster.getRexBuilder().makeLiteral("TRUE");  
        }  
         * fractional types by routing through DOUBLE and widens integers to BIGINT.
                if (f.literal.equals(lower)) return f;  
 *  
        final String literal;
         * picks BIGINT vs DOUBLE based on the source type.
     * the format literal is forwarded verbatim so the UDF's per-row dispatch sees the exact
    }
     */  
    private enum Format {  
        // a known mode; otherwise pass the call through so the downstream planner fails loudly.  
     * operand unchanged when it's already the target type so we don't layer redundant CASTs.
        RexNode normalized = castTo(value, target, cluster);
     * the name the Rust UDF registers under and the YAML extension declares. A dedicated operator  
            }
import org.apache.calcite.sql.type.SqlTypeName;
                return rebuildCall(original, value, formatLit, mode, cluster);
            this.fixedTarget = fixedTarget;
        // tostring renders booleans as the uppercase literals TRUE / FALSE (format arg is ignored for booleans).
 *   only used when {@code value} is a number and is ignored for Booleans.
            }
 *   <li>Native {@code tostring(value[, format])} — dispatched as-is.</li>
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.rex.RexNode;  
     * their output is defined on the integer part of the value (cf. PPL docs: binary/hex/duration  
    private static RexNode castTo(RexNode operand, SqlTypeName target, RelOptCluster cluster) {  
import org.opensearch.analytics.spi.FieldStorageInfo;
/*  
            return makeVarcharCast(original, value, cluster);
        RelDataTypeFactory factory = cluster.getTypeFactory();
        return cluster.getRexBuilder().makeCast(varcharType, value);  
 */  
package org.opensearch.be.datafusion;
        }
        RelDataType varcharType = factory.createTypeWithNullability(
     * incoming RexCall's operator being correctly named.
 *
        static Format from(String modeLiteral) {
            .makeCall(
        DURATION("duration", SqlTypeName.BIGINT),
        // 2-arg: tostring(x, format). Only rewrite when the format arg is a string literal with
 * @opensearch.internal
        /**
        if (value.getType().getSqlTypeName() == SqlTypeName.BOOLEAN) {
    }
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        /** Case-insensitive lookup matching the PPL spec. Returns {@code null} when unknown. */
        DURATION_MILLIS("duration_millis", SqlTypeName.BIGINT);
import java.util.List;  
import org.apache.calcite.sql.type.ReturnTypes;  
     * Rebuild the 2-arg call as {@code tostring(CAST(value AS <target>), formatLit)}. The CAST  
 * <ol>  
            factory.createSqlType(SqlTypeName.VARCHAR),  
 * </blockquote>  
import org.apache.calcite.rel.type.RelDataType;
        return original;
            }
            return null;
     * Lower a BOOLEAN-valued {@code tostring} call to  
import java.util.Locale;
     * Target numeric type for a given PPL format mode. {@link #COMMAS} preserves fractional
 *   </li>
            this.literal = literal;  
        // 1-arg: tostring(x) → CAST(x AS VARCHAR)  
        return cluster.getRexBuilder().makeCast(targetType, operand);  
 *   <li>{@code NUMBER_TO_STRING(num)} — PPL's {@code ExtendedRexBuilder.makeCast} override
 *   values, converts to {@code TRUE} or {@code FALSE}. The {@code format} parameter is
        SqlTypeName targetFor(SqlTypeName source) {
        // the 1-arg tostring shape: lower to a plain CAST(value AS VARCHAR) that isthmus /
     */
        return cluster.getRexBuilder()  
        // NUMBER_TO_STRING is PPL's intercepted numeric-to-varchar cast. Treat it identically to  
    /**  
        );
 *
        RelDataType targetType = factory.createTypeWithNullability(factory.createSqlType(target), operand.getType().isNullable());
            return original;
     * are integer conversions).
     * precision because it renders rounded to 2 decimals. All other modes fold to BIGINT because
        }
    private static RexNode makeBooleanToString(RexCall original, RexNode value, RelOptCluster cluster) {  
         * Target type for the numeric argument, or {@code null} for {@link #COMMAS} which  
 * PPL {@code tostring} docs</a>:
 *   If a format is provided, converts numbers to the specified format type. For Boolean  
                varcharType,
         */
                List.of(value, trueLit, notValue, falseLit, cluster.getRexBuilder().makeNullLiteral(varcharType))
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RelDataTypeFactory factory = cluster.getTypeFactory();
     */
 *       intercepts {@code CAST(num AS VARCHAR)} for approximate-numeric / decimal source types  
     */
    /**  
        // DataFusion can serialise.
    }
        SqlKind.OTHER_FUNCTION,  
    }  
        Format(String literal, SqlTypeName fixedTarget) {
 * compatible open source license.
    private static boolean isStringLiteral(RexLiteral literal) {
    @Override
     * ensures the numeric argument matches the Rust UDF's declared BIGINT/FLOAT64 signatures;
        BINARY("binary", SqlTypeName.BIGINT),
 * <blockquote>
        final SqlTypeName fixedTarget;  
     * Synthetic {@code tostring} operator used when we rebuild the 2-arg call. It mirrors the
import org.apache.calcite.rel.type.RelDataTypeFactory;  
import org.apache.calcite.sql.SqlFunction;
            return makeVarcharCast(original, value, cluster);
        "tostring",
 *       PPL-plugin-defined UDF isn't in any Substrait catalog, so isthmus cannot resolve it.
import org.apache.calcite.sql.SqlKind;  
    );
     * {@code CASE WHEN value THEN 'TRUE' WHEN NOT value THEN 'FALSE' END}.
        );
    static final SqlFunction TOSTRING = new SqlFunction(
            if (fixedTarget != null) {
 * <a href="https://docs.opensearch.org/latest/sql-and-ppl/ppl/functions/conversion/#tostring">
        }  
            return makeBooleanToString(original, value, cluster);  
        }
            Format mode = Format.from(formatLit.getValueAs(String.class));
    }  
            String lower = modeLiteral.toLowerCase(Locale.ROOT);
         * Choose the target type for the numeric argument given the source RexNode type.  
        }  
        COMMAS("commas", /* preserveFractional */null),  
 * The OpenSearch Contributors require contributions made to  
            factory.createSqlType(SqlTypeName.VARCHAR),  
        RexNode notValue = cluster.getRexBuilder().makeCall(SqlStdOperatorTable.NOT, value);
    }  
     */
     * mode string the caller supplied.  
    private static RexNode rebuildCall(RexCall original, RexNode value, RexLiteral formatLit, Format mode, RelOptCluster cluster) {
        if (operands.isEmpty()) {
import org.apache.calcite.plan.RelOptCluster;
     * Casts {@code operand} to {@code target} while preserving its nullability. Returns the  
        }  
        null,
 *   {@code tostring(value[, format])} — converts the value to a string representation.
        SqlTypeName target = mode.targetFor(value.getType().getSqlTypeName());  
 * SPDX-License-Identifier: Apache-2.0
        return type == SqlTypeName.FLOAT || type == SqlTypeName.DOUBLE || type == SqlTypeName.REAL || type == SqlTypeName.DECIMAL;
        RexNode value = operands.get(0);
         * For every mode except {@link #COMMAS} this is a fixed BIGINT; COMMAS preserves
 * <p>Per the  
 *       and rewrites it into a call to {@code PPLBuiltinOperators.NUMBER_TO_STRING}. That
 *
import org.apache.calcite.sql.type.OperandTypes;
