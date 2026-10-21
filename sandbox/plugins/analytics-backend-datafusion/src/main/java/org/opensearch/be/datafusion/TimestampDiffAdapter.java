                    RexNode rewritten = rewriteVariableInner(rb, startArg, inValue, innerMonths, outUnit, original.getType());
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
import org.apache.calcite.sql.SqlIntervalQualifier;
            );
     * recognizable literal — caller falls through to the non-literal rewrite.
    /** Variable inner unit → months for the {@code INTERVAL n*m MONTH} literal. */
        // Standalone TIMESTAMPDIFF(out_unit, t1, t2): rewrite via to_unixtime delta + scale.
    /** Variable out unit → seconds approximation (legacy SQL plugin parity). */
    private static Long literalDiff(String upperOut, LocalDateTime t1, LocalDateTime t2) {
        // INTERVAL (inValue * innerMonths) MONTH, mirroring EarliestLatestAdapter#makeIntervalAdd
        if (startLiteral != null && endLiteral != null) {
        RexNode addedTs = rexBuilder.makeCall(SqlStdOperatorTable.DATETIME_PLUS, startArg, intervalLit);
    }
            scaled = rb.makeCall(SqlStdOperatorTable.DIVIDE, diffSeconds, divLit);
        RexNode endSeconds = rb.makeCall(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, t2);
            return null;
    /** Fixed-length PPL unit → ms (MICROSECOND=0 means sub-ms; handled separately). */
     * Legacy {@code TIMESTAMPDIFF} semantics for two literal timestamps. For variable-length
    }
        // Literal-literal fold via JDK calendar math — calendar-exact for YEAR/QUARTER/MONTH
        return rb.makeCast(original.getType(), scaled, true);
        1L
        long totalMs = Math.multiplyExact(inValue, inMs);
            return null;
        }
 *
import org.apache.calcite.rex.RexBuilder;
        Object value = lit.getValue();
    );
        long innerMonths,
    @Override
        }
        return rexBuilder.makeCast(resultType, scaled, true);
        String upperOut = outUnit.toUpperCase(Locale.ROOT);
        } else {
            }
                Long foldedDiff = constantFold(outUnit, inUnit, inValue);
     */
    private static final Map<String, Long> OUT_UNIT_DIVISOR_FROM_SECONDS = Map.of(
                    if (rewritten != null) {
        1_000_000L,
        } else if (approxSeconds != null) {
    private static Long integerLiteralValue(RexNode node) {
            RexNode multLit = rb.makeBigintLiteral(BigDecimal.valueOf(mult));
            .createTypeWithNullability(
        }
 * <p>Three shapes:
                case "MONTH" -> t1.until(t2, ChronoUnit.MONTHS);
 * @opensearch.internal
        }
    );
            return null;
                if (innerMonths != null) {
import org.apache.calcite.sql.parser.SqlParserPos;
            RexNode multLit = rexBuilder.makeBigintLiteral(BigDecimal.valueOf(outMultiplier));
        String outUnit = stringLiteralValue(outUnitArg);
        return null;
        Map.entry("WEEK", 604_800_000L)
            && endCall.getOperator().getName().equalsIgnoreCase("TIMESTAMPADD")
        Map.entry("MILLISECOND", 1L),
        }
        }
        90L * 86_400L,
                return null;
    private static Long constantFold(String outUnit, String inUnit, long inValue) {
        return TimestampFunctionAdapter.extractLocalDateTimeLiteral(node);
            scaled = rexBuilder.makeCall(SqlStdOperatorTable.MULTIPLY, diffSeconds, multLit);
        604_800L
        }
    private static RexNode liftToTimestamp(RexBuilder rb, RexNode operand, org.apache.calcite.rel.type.RelDataType resultType) {
        } else if (div != null && div > 1L) {
            try {
    private static RexNode rewriteStandaloneDiff(RelOptCluster cluster, RexCall original, String outUnit, RexNode start, RexNode end) {
        try {
    }
            // variable-length out unit — MONTH≈30d, QUARTER≈90d, YEAR≈365d
 *
        } catch (ArithmeticException unused) {
/*
import org.opensearch.analytics.planner.rel.OperatorAnnotation;
                        return rewritten;
    /** Fold {@code n * in_ms / out_ms} for fixed/fixed unit pairs; null if non-integral or variable-length. */
        "DAY",
        if (mult != null && mult > 1L) {
        RexNode t1 = liftToTimestamp(rb, start, original.getType());
            return null;
        }
        Map.entry("MICROSECOND", 0L),
     * Parse a literal datetime operand to {@link LocalDateTime} via
                    return rb.makeCast(original.getType(), literal, true);
import java.util.List;
        }
        Map.entry("HOUR", 3_600_000L),
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        try {
        RexNode scaled;
        return totalMs / outMs;
    }
        } else {
 *       variable-length out units use 30/90/365-day approximations matching legacy SQL plugin behavior.</li>
import org.opensearch.analytics.spi.FieldStorageInfo;
        "MINUTE",
import java.time.temporal.ChronoUnit;
     * the unix-epoch difference scaled to the requested unit.
        }
 * PPL {@code TIMESTAMPDIFF(out_unit, t1, t2)} rewrites — neither {@code TIMESTAMPDIFF} nor
     * raw VARCHAR literals and already-coerced shapes (TIMESTAMP-typed literals or CAST
        // Peephole: TIMESTAMPDIFF(out, t, TIMESTAMPADD(in, n, t)) — fold or rewrite via runtime path.
                RexBuilder rb = cluster.getRexBuilder();
        3_600L,
    /** Cast a string/date/timestamp expression to TIMESTAMP matching {@code resultType}'s nullability. */
 *   <li>Standalone: {@code (to_unixtime(t2) - to_unixtime(t1))} scaled by the out-unit factor;
    }
        if (inMs == null || outMs == null || outMs == 0L) {
class TimestampDiffAdapter implements ScalarFunctionAdapter {
                case "MICROSECOND" -> t1.until(t2, ChronoUnit.MICROS);
                    RexNode literal = rb.makeBigintLiteral(BigDecimal.valueOf(foldedDiff));
                case "MINUTE" -> t1.until(t2, ChronoUnit.MINUTES);
        RexNode outUnitArg = unwrapAnnotation(original.getOperands().get(0));
    /** Peel a single OperatorAnnotation wrapper if present. */
                return bd.longValueExact();
        Map.entry("MINUTE", 60_000L),
            RexNode divLit = rb.makeBigintLiteral(BigDecimal.valueOf(approxSeconds));
 * </ul>
 *       with fixed {@code out_unit} → {@code (to_unixtime(t + INTERVAL n*m MONTH) - to_unixtime(t)) * factor}.</li>
            }
                default -> null;
 */
        RexBuilder rexBuilder,
            String inUnit = stringLiteralValue(unwrapAnnotation(endCall.getOperands().get(0)));
    }
        if (original.getOperands().size() != 3) {
            RexNode divLit = rexBuilder.makeBigintLiteral(BigDecimal.valueOf(outDivisor));
import org.apache.calcite.sql.type.SqlTypeName;
        RexNode scaled;
        long totalMonths;
                case "MILLISECOND" -> t1.until(t2, ChronoUnit.MILLIS);
        RexNode startArg,
        RexNode t2 = liftToTimestamp(rb, end, original.getType());
}
    /** Fixed out-unit → divisor on unix-seconds-diff. */
    /**
import org.apache.calcite.avatica.util.TimeUnit;
        if (value instanceof Number n) {
    /** Standalone TIMESTAMPDIFF: {@code (to_unixtime(t2) - to_unixtime(t1))} scaled to out-unit. */
        RexNode startArg = unwrapAnnotation(original.getOperands().get(1));
        RexNode startSeconds = rexBuilder.makeCall(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, startArg);
    ) {
        }
import java.util.Locale;
        }
        "HOUR",
            return switch (upperOut) {
        // scale to out-unit; ×1000 for MILLISECOND (timechart per_*), ÷ for coarser units
        return node;
        "SECOND",
    /** Fixed out-unit → multiplier on unix-seconds-diff (sub-minute units). */
import java.math.BigDecimal;
                    }
     * RexCalls). Returns null when the operand isn't a
            if (inUnit != null && inValue != null && addedBase.equals(startArg)) {
        if (outUnit == null) {
        Long inMs = UNIT_TO_MILLIS.get(inUnit.toUpperCase(Locale.ROOT));
        }
                case "QUARTER" -> t1.until(t2, ChronoUnit.MONTHS) / 3L;
        Long outDivisor = outMultiplier == null ? OUT_UNIT_DIVISOR_FROM_SECONDS.get(upperOut) : null;
        if (operand.getType().getSqlTypeName() == SqlTypeName.TIMESTAMP) {
 *
    );
        } catch (ArithmeticException unused) {
import org.apache.calcite.rex.RexNode;
    private static final Map<String, Long> VARIABLE_OUT_APPROX_SECONDS = Map.of(
     * {@code DateTimeFunctions.exprTimestampDiff} reference. For fixed-length units, uses
        // unix_seconds_diff = to_unixtime(addedTs) - to_unixtime(startArg)
            totalMonths = Math.multiplyExact(inValue, innerMonths);
            return original;
        Long mult = OUT_UNIT_MULTIPLIER_FROM_SECONDS.get(upperOut);
        Long approxSeconds = mult == null && div == null ? VARIABLE_OUT_APPROX_SECONDS.get(upperOut) : null;
        return rewriteStandaloneDiff(cluster, original, outUnit, startArg, endArg);
     * java.time.temporal.TemporalUnit)} which floors toward zero — matching the SQL plugin's
        if (!(node instanceof RexLiteral lit)) {
            return operand;
 * compatible open source license.
     * {@link TimestampFunctionAdapter#extractLocalDateTimeLiteral} which recognizes both
        Map.entry("SECOND", 1_000L),
        60L,
            }
    );
        "MICROSECOND",
        // (covers DateTimeFunctionIT#testTimestampDiff with literal operands).
                if (foldedDiff != null) {
        } else if (outDivisor != null && outDivisor > 1L) {
        Map.entry("DAY", 86_400_000L),
                case "WEEK" -> t1.until(t2, ChronoUnit.WEEKS);
        Long outMs = UNIT_TO_MILLIS.get(outUnit.toUpperCase(Locale.ROOT));
import org.apache.calcite.plan.RelOptCluster;
        if (outMultiplier != null && outMultiplier > 1L) {
        return rb.makeCast(tsType, operand, true);
        if (value instanceof BigDecimal bd) {
        if (!original.getOperator().getName().equalsIgnoreCase("TIMESTAMPDIFF")) {
 * {@code TIMESTAMPADD} have substrait bindings, so isthmus rejects them unless rewritten.
        Long outMultiplier = OUT_UNIT_MULTIPLIER_FROM_SECONDS.get(upperOut);
        30L * 86_400L,
    /**
        Long div = mult == null ? OUT_UNIT_DIVISOR_FROM_SECONDS.get(upperOut) : null;
                Long innerMonths = VARIABLE_INNER_MONTHS.get(inUnit.toUpperCase(Locale.ROOT));
    private static String stringLiteralValue(RexNode node) {
     * units (YEAR / QUARTER / MONTH), uses {@link LocalDateTime#until(java.time.temporal.Temporal,
        "MILLISECOND",
            scaled = rexBuilder.makeCall(SqlStdOperatorTable.DIVIDE, diffSeconds, divLit);
        SqlIntervalQualifier monthQualifier = new SqlIntervalQualifier(TimeUnit.MONTH, null, SqlParserPos.ZERO);
import org.apache.calcite.rex.RexLiteral;
            if (folded != null) {
        }
import org.apache.calcite.rex.RexCall;
 *
        "MONTH",
        "QUARTER",
                operand.getType().isNullable() || resultType.isNullable()
        1_000L,
        LocalDateTime endLiteral = parseTimestampLiteral(end);
            && endCall.getOperands().size() == 3) {
import java.util.Map;
                case "YEAR" -> t1.until(t2, ChronoUnit.YEARS);
    private static RexNode unwrapAnnotation(RexNode node) {
        RexNode startSeconds = rb.makeCall(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, t1);
            Long inValue = integerLiteralValue(unwrapAnnotation(endCall.getOperands().get(1)));
        }
                case "DAY" -> t1.until(t2, ChronoUnit.DAYS);
            RexNode addedBase = unwrapAnnotation(endCall.getOperands().get(2));
        RexNode diffSeconds = rb.makeCall(SqlStdOperatorTable.MINUS, endSeconds, startSeconds);
    private static final Map<String, Long> UNIT_TO_MILLIS = Map.ofEntries(
                }
            RexNode divLit = rb.makeBigintLiteral(BigDecimal.valueOf(div));
        if (!(node instanceof RexLiteral lit)) {
/**
            return original;
            return original;
        }
        if (endArg instanceof RexCall endCall
            scaled = diffSeconds;  // out-unit SECOND
    private static final Map<String, Long> VARIABLE_INNER_MONTHS = Map.of("MONTH", 1L, "QUARTER", 3L, "YEAR", 12L);
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
    }
 * <p>Out-unit MONTH/QUARTER/YEAR for the peephole shape is rejected (lossy fixed-second math) — follow-up.
    private static final Map<String, Long> OUT_UNIT_MULTIPLIER_FROM_SECONDS = Map.of(
 * this file be licensed under the Apache-2.0 license or a
                RexNode literal = rb.makeBigintLiteral(BigDecimal.valueOf(folded));
 * <ul>
            scaled = rb.makeCall(SqlStdOperatorTable.MULTIPLY, diffSeconds, multLit);
 */
    }
        long inValue,
                rb.getTypeFactory().createSqlType(SqlTypeName.TIMESTAMP),
            scaled = diffSeconds;
        String outUnit,
        "YEAR",
        if (totalMs % outMs != 0) {
        RexNode endArg = unwrapAnnotation(original.getOperands().get(2));
            return null;
 * The OpenSearch Contributors require contributions made to
    private static RexNode rewriteVariableInner(
        org.apache.calcite.rel.type.RelDataType resultType
                case "SECOND" -> t1.until(t2, ChronoUnit.SECONDS);
                return rb.makeCast(original.getType(), literal, true);
        }
            return annotation.unwrap();
package org.opensearch.be.datafusion;
        LocalDateTime startLiteral = parseTimestampLiteral(start);
        RexNode diffSeconds = rexBuilder.makeCall(SqlStdOperatorTable.MINUS, endSeconds, startSeconds);
        RexNode endSeconds = rexBuilder.makeCall(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, addedTs);
        org.apache.calcite.rel.type.RelDataType tsType = rb.getTypeFactory()
            return n.longValue();
 *   <li>Peephole {@code TIMESTAMPDIFF(out, t, TIMESTAMPADD(in, n, t))}: fixed/fixed unit pair
            return null;
    }
                }
            Long folded = literalDiff(upperOut, startLiteral, endLiteral);
        RexNode intervalLit = rexBuilder.makeIntervalLiteral(BigDecimal.valueOf(totalMonths), monthQualifier);
     */
 *       constant-folds to a BIGINT literal; variable-length {@code in_unit} (MONTH/QUARTER/YEAR)
        String upperOut = outUnit.toUpperCase(Locale.ROOT);
    }
            return null;
                case "HOUR" -> t1.until(t2, ChronoUnit.HOURS);
        "WEEK",
 * SPDX-License-Identifier: Apache-2.0
        }
        if (lit.getType().getSqlTypeName() != SqlTypeName.CHAR && lit.getType().getSqlTypeName() != SqlTypeName.VARCHAR) {
        86_400L,
            };
        RexBuilder rb = cluster.getRexBuilder();
    private static LocalDateTime parseTimestampLiteral(RexNode node) {
            // out MONTH/QUARTER/YEAR — variable on both sides; pass through, isthmus surfaces the failure
        if (outMultiplier == null && outDivisor == null) {
            return null;
            } catch (ArithmeticException unused) {
        }
        365L * 86_400L
import java.time.LocalDateTime;
        return lit.getValueAs(String.class);
            scaled = rb.makeCall(SqlStdOperatorTable.DIVIDE, diffSeconds, divLit);
        if (node instanceof OperatorAnnotation annotation && annotation.unwrap() != null) {
