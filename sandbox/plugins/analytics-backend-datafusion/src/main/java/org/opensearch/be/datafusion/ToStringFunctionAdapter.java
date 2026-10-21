 * </ol>
        DURATION("duration", SqlTypeName.BIGINT),
        if (operands.size() == 1) {
     */
            if (modeLiteral == null) return null;
        );
 *
    /**
         * Target type for the numeric argument, or {@code null} for {@link #COMMAS} which
    }
    /**
        // a known mode; otherwise pass the call through so the downstream planner fails loudly.
        if (ScalarFunction.NUMBER_TO_STRING.name().equalsIgnoreCase(original.getOperator().getName())) {
 *   <li>Native {@code tostring(value[, format])} — dispatched as-is.</li>
 *
     * Casts {@code operand} to {@code target} while preserving its nullability. Returns the
import org.apache.calcite.sql.type.SqlTypeName;
        }
 */
        return cluster.getRexBuilder().makeCast(targetType, operand);
     * the name the Rust UDF registers under and the YAML extension declares. A dedicated operator
        // the 1-arg tostring shape: lower to a plain CAST(value AS VARCHAR) that isthmus /
                varcharType,
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
            Format mode = Format.from(formatLit.getValueAs(String.class));
 * SPDX-License-Identifier: Apache-2.0
         * picks BIGINT vs DOUBLE based on the source type.
    private static boolean isFractional(SqlTypeName type) {
        }
 * <ol>
         * Choose the target type for the numeric argument given the source RexNode type.
 */
                if (f.literal.equals(lower)) return f;
class ToStringFunctionAdapter implements ScalarFunctionAdapter {
        return original;
     * shape of the PPL operator but is keyed on the literal name {@code "tostring"} — which is
 *       intercepts {@code CAST(num AS VARCHAR)} for approximate-numeric / decimal source types
        RelDataType varcharType = factory.createTypeWithNullability(
         */
                SqlStdOperatorTable.CASE,
        RelDataTypeFactory factory = cluster.getTypeFactory();
    }
    private enum Format {
        List<RexNode> operands = original.getOperands();
    private static RexNode makeBooleanToString(RexCall original, RexNode value, RelOptCluster cluster) {
        }
            return makeBooleanToString(original, value, cluster);
 *       CAST.
        // NUMBER_TO_STRING is PPL's intercepted numeric-to-varchar cast. Treat it identically to
import org.apache.calcite.rel.type.RelDataType;
     */
 * @opensearch.internal
import org.apache.calcite.rel.type.RelDataTypeFactory;
    }
        // 2-arg: tostring(x, format). Only rewrite when the format arg is a string literal with
    private static RexNode makeVarcharCast(RexCall original, RexNode value, RelOptCluster cluster) {
import org.apache.calcite.rex.RexLiteral;
 *   <li>{@code NUMBER_TO_STRING(num)} — PPL's {@code ExtendedRexBuilder.makeCast} override
     * Rebuild the 2-arg call as {@code tostring(CAST(value AS <target>), formatLit)}. The CAST
        SqlKind.OTHER_FUNCTION,
            }
        RexNode notValue = cluster.getRexBuilder().makeCall(SqlStdOperatorTable.NOT, value);
        return cluster.getRexBuilder().makeCast(varcharType, value);
        /**
        static Format from(String modeLiteral) {
        if (operands.size() == 2 && operands.get(1) instanceof RexLiteral formatLit && isStringLiteral(formatLit)) {
            return original;
    /**
        RelDataTypeFactory factory = cluster.getTypeFactory();
}
            return isFractional(source) ? SqlTypeName.DOUBLE : SqlTypeName.BIGINT;
        }
     * their output is defined on the integer part of the value (cf. PPL docs: binary/hex/duration
        return cluster.getRexBuilder().makeCall(original.getType(), TOSTRING, List.of(normalized, formatLit));
            String lower = modeLiteral.toLowerCase(Locale.ROOT);
    }
import org.apache.calcite.sql.SqlFunctionCategory;
import java.util.Locale;
/*
 * compatible open source license.
        RexNode trueLit = cluster.getRexBuilder().makeLiteral("TRUE");
        final String literal;
 *   </li>
 *       PPL-plugin-defined UDF isn't in any Substrait catalog, so isthmus cannot resolve it.
     * Lower a BOOLEAN-valued {@code tostring} call to
        ReturnTypes.VARCHAR,
    private static boolean isStringLiteral(RexLiteral literal) {
 *   values, converts to {@code TRUE} or {@code FALSE}. The {@code format} parameter is
            original.getType().isNullable()
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
        SqlTypeName targetFor(SqlTypeName source) {
            for (Format f : values()) {
            return operand;
            .makeCall(
                return fixedTarget;
        RexNode falseLit = cluster.getRexBuilder().makeLiteral("FALSE");
     * operand unchanged when it's already the target type so we don't layer redundant CASTs.
     * Synthetic {@code tostring} operator used when we rebuild the 2-arg call. It mirrors the
 * Rewrites PPL {@code tostring(value[, format])} into a DataFusion-compatible expression.
     * precision because it renders rounded to 2 decimals. All other modes fold to BIGINT because
     */
 * <p>Per the
 * <p>Handles two arrival shapes:
         */
        DURATION_MILLIS("duration_millis", SqlTypeName.BIGINT);
        RelDataTypeFactory factory = cluster.getTypeFactory();
import org.apache.calcite.sql.SqlKind;
import org.apache.calcite.sql.SqlFunction;
        return type == SqlTypeName.FLOAT || type == SqlTypeName.DOUBLE || type == SqlTypeName.REAL || type == SqlTypeName.DECIMAL;
        SqlTypeName sqlType = literal.getType().getSqlTypeName();
 *       and rewrites it into a call to {@code PPLBuiltinOperators.NUMBER_TO_STRING}. That
    private static RexNode castTo(RexNode operand, SqlTypeName target, RelOptCluster cluster) {
import org.apache.calcite.plan.RelOptCluster;
        SqlFunctionCategory.USER_DEFINED_FUNCTION
import org.apache.calcite.rex.RexNode;
 *   {@code tostring(value[, format])} — converts the value to a string representation.
 * this file be licensed under the Apache-2.0 license or a
            if (mode != null) {
        }
            return null;
                return rebuildCall(original, value, formatLit, mode, cluster);
        if (operand.getType().getSqlTypeName() == target) {
        return sqlType == SqlTypeName.CHAR || sqlType == SqlTypeName.VARCHAR;
            this.literal = literal;
        }
 *
 *   only used when {@code value} is a number and is ignored for Booleans.
        RelDataType targetType = factory.createTypeWithNullability(factory.createSqlType(target), operand.getType().isNullable());
    }
    private static RexNode rebuildCall(RexCall original, RexNode value, RexLiteral formatLit, Format mode, RelOptCluster cluster) {
    }
        RexNode value = operands.get(0);
            return makeVarcharCast(original, value, cluster);
import org.opensearch.analytics.spi.FieldStorageInfo;
                List.of(value, trueLit, notValue, falseLit, cluster.getRexBuilder().makeNullLiteral(varcharType))
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
     * ensures the numeric argument matches the Rust UDF's declared BIGINT/FLOAT64 signatures;
     * the format literal is forwarded verbatim so the UDF's per-row dispatch sees the exact
     * Target numeric type for a given PPL format mode. {@link #COMMAS} preserves fractional
        SqlTypeName target = mode.targetFor(value.getType().getSqlTypeName());
 *   If a format is provided, converts numbers to the specified format type. For Boolean
        // 1-arg: tostring(x) → CAST(x AS VARCHAR)
        // DataFusion can serialise.
        if (value.getType().getSqlTypeName() == SqlTypeName.BOOLEAN) {
        RexNode normalized = castTo(value, target, cluster);
         * For every mode except {@link #COMMAS} this is a fixed BIGINT; COMMAS preserves
        if (operands.isEmpty()) {
 * </blockquote>
        OperandTypes.family(),
package org.opensearch.be.datafusion;
import org.apache.calcite.sql.type.ReturnTypes;
    static final SqlFunction TOSTRING = new SqlFunction(
        Format(String literal, SqlTypeName fixedTarget) {
    }
    }
            }
     * are integer conversions).
            if (fixedTarget != null) {
     * incoming RexCall's operator being correctly named.
import org.apache.calcite.sql.type.OperandTypes;
/**
 * <blockquote>
            factory.createSqlType(SqlTypeName.VARCHAR),
        }
import org.opensearch.analytics.spi.ScalarFunction;
        "tostring",
 *       We treat it as the single-arg {@code tostring} shape and lower it to a plain VARCHAR
        final SqlTypeName fixedTarget;
 *
        HEX("hex", SqlTypeName.BIGINT),
        null,
     * mode string the caller supplied.
    /**
            return makeVarcharCast(original, value, cluster);
        /**
        RelDataType varcharType = factory.createTypeWithNullability(
    @Override
     * {@code CASE WHEN value THEN 'TRUE' WHEN NOT value THEN 'FALSE' END}.
            }
            original.getType().isNullable()
 * <a href="https://docs.opensearch.org/latest/sql-and-ppl/ppl/functions/conversion/#tostring">
         * fractional types by routing through DOUBLE and widens integers to BIGINT.
        );
        }
        return cluster.getRexBuilder()
 * PPL {@code tostring} docs</a>:
            factory.createSqlType(SqlTypeName.VARCHAR),
        // tostring renders booleans as the uppercase literals TRUE / FALSE (format arg is ignored for booleans).
import java.util.List;
    );
            );
     */
     */
        COMMAS("commas", /* preserveFractional */null),
        /** Case-insensitive lookup matching the PPL spec. Returns {@code null} when unknown. */
            this.fixedTarget = fixedTarget;
        }
     * gives the isthmus name-based resolver a deterministic hook; we don't have to rely on the
        BINARY("binary", SqlTypeName.BIGINT),
import org.apache.calcite.rex.RexCall;
    /**
 * The OpenSearch Contributors require contributions made to
 *
