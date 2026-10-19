/*  
            return null;
                case "MILLISECOND" -> t1.until(t2, ChronoUnit.MILLIS);
                return rb.makeCast(original.getType(), literal, true);  
 * @opensearch.internal
        }
        "MILLISECOND",
    );  
        if (value instanceof Number n) {
        1_000_000L,
            scaled = rexBuilder.makeCall(SqlStdOperatorTable.MULTIPLY, diffSeconds, multLit);
import org.apache.calcite.rex.RexLiteral;
            return null;  
            } catch (ArithmeticException unused) {  
 */  
            RexNode addedBase = unwrapAnnotation(endCall.getOperands().get(2));
        Long outMultiplier = OUT_UNIT_MULTIPLIER_FROM_SECONDS.get(upperOut);
                    if (rewritten != null) {
        RexNode endSeconds = rb.makeCall(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, t2);
 *       constant-folds to a BIGINT literal; variable-length {@code in_unit} (MONTH/QUARTER/YEAR)
        } else {
import java.util.Locale;
        "MONTH",
            return annotation.unwrap();
import java.util.List;  
                if (foldedDiff != null) {  
        }  
    /** Variable inner unit → months for the {@code INTERVAL n*m MONTH} literal. */
        return TimestampFunctionAdapter.extractLocalDateTimeLiteral(node);
        if (outMultiplier != null && outMultiplier > 1L) {  
        3_600L,
        "HOUR",  
        if (!(node instanceof RexLiteral lit)) {
                        return rewritten;
        90L * 86_400L,
        } else if (outDivisor != null && outDivisor > 1L) {  
        RexNode diffSeconds = rexBuilder.makeCall(SqlStdOperatorTable.MINUS, endSeconds, startSeconds);
        Long inMs = UNIT_TO_MILLIS.get(inUnit.toUpperCase(Locale.ROOT));
    private static LocalDateTime parseTimestampLiteral(RexNode node) {  
        return rb.makeCast(original.getType(), scaled, true);
    private static Long literalDiff(String upperOut, LocalDateTime t1, LocalDateTime t2) {
                case "YEAR" -> t1.until(t2, ChronoUnit.YEARS);
import org.apache.calcite.rex.RexBuilder;  
    /** Fixed out-unit → divisor on unix-seconds-diff. */
import org.apache.calcite.sql.parser.SqlParserPos;  
        }
import java.time.LocalDateTime;
        return rewriteStandaloneDiff(cluster, original, outUnit, startArg, endArg);  
     * units (YEAR / QUARTER / MONTH), uses {@link LocalDateTime#until(java.time.temporal.Temporal,  
        } catch (ArithmeticException unused) {
            return null;  
        }  
     */
    private static final Map<String, Long> VARIABLE_OUT_APPROX_SECONDS = Map.of(  
        RexNode endArg = unwrapAnnotation(original.getOperands().get(2));
        "MINUTE",
        if (endArg instanceof RexCall endCall  
                return bd.longValueExact();
        } else if (div != null && div > 1L) {  
        SqlIntervalQualifier monthQualifier = new SqlIntervalQualifier(TimeUnit.MONTH, null, SqlParserPos.ZERO);
import org.apache.calcite.rex.RexNode;  
 *   <li>Peephole {@code TIMESTAMPDIFF(out, t, TIMESTAMPADD(in, n, t))}: fixed/fixed unit pair
        60L,
                Long foldedDiff = constantFold(outUnit, inUnit, inValue);
            scaled = diffSeconds;
                if (innerMonths != null) {
        long inValue,
                operand.getType().isNullable() || resultType.isNullable()  
    private static Long integerLiteralValue(RexNode node) {
        if (outUnit == null) {
    }
class TimestampDiffAdapter implements ScalarFunctionAdapter {  
        if (operand.getType().getSqlTypeName() == SqlTypeName.TIMESTAMP) {  
        if (outMultiplier == null && outDivisor == null) {
    ) {  
        1_000L,  
                case "DAY" -> t1.until(t2, ChronoUnit.DAYS);  
        Long div = mult == null ? OUT_UNIT_DIVISOR_FROM_SECONDS.get(upperOut) : null;  
    private static RexNode liftToTimestamp(RexBuilder rb, RexNode operand, org.apache.calcite.rel.type.RelDataType resultType) {
            return operand;
        Map.entry("MILLISECOND", 1L),
        // Standalone TIMESTAMPDIFF(out_unit, t1, t2): rewrite via to_unixtime delta + scale.
        Map.entry("SECOND", 1_000L),  
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
    /** Peel a single OperatorAnnotation wrapper if present. */
    }  
            if (inUnit != null && inValue != null && addedBase.equals(startArg)) {  
            return original;  
        }
        RexNode intervalLit = rexBuilder.makeIntervalLiteral(BigDecimal.valueOf(totalMonths), monthQualifier);
            return n.longValue();
            // out MONTH/QUARTER/YEAR — variable on both sides; pass through, isthmus surfaces the failure
        // scale to out-unit; ×1000 for MILLISECOND (timechart per_*), ÷ for coarser units
        // Literal-literal fold via JDK calendar math — calendar-exact for YEAR/QUARTER/MONTH
import java.time.temporal.ChronoUnit;
            RexNode multLit = rb.makeBigintLiteral(BigDecimal.valueOf(mult));
            }
        RexNode outUnitArg = unwrapAnnotation(original.getOperands().get(0));
        "DAY",
        if (node instanceof OperatorAnnotation annotation && annotation.unwrap() != null) {  
import org.apache.calcite.rex.RexCall;
        RexBuilder rb = cluster.getRexBuilder();
                    RexNode literal = rb.makeBigintLiteral(BigDecimal.valueOf(foldedDiff));
            scaled = rb.makeCall(SqlStdOperatorTable.MULTIPLY, diffSeconds, multLit);
                case "MINUTE" -> t1.until(t2, ChronoUnit.MINUTES);
        } else if (approxSeconds != null) {  
        if (mult != null && mult > 1L) {  
        try {
            }
        RexNode startArg,
        "MICROSECOND",  
        String outUnit = stringLiteralValue(outUnitArg);  
        String upperOut = outUnit.toUpperCase(Locale.ROOT);  
    /** Fold {@code n * in_ms / out_ms} for fixed/fixed unit pairs; null if non-integral or variable-length. */  
            try {
    @Override  
                case "MONTH" -> t1.until(t2, ChronoUnit.MONTHS);
        Long mult = OUT_UNIT_MULTIPLIER_FROM_SECONDS.get(upperOut);
import java.util.Map;
    /** Fixed out-unit → multiplier on unix-seconds-diff (sub-minute units). */
                }  
        RexNode startSeconds = rb.makeCall(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, t1);  
        }  
                case "HOUR" -> t1.until(t2, ChronoUnit.HOURS);
        RexNode endSeconds = rexBuilder.makeCall(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, addedTs);  
        Map.entry("MINUTE", 60_000L),
        "SECOND",
                }
 * SPDX-License-Identifier: Apache-2.0
            // variable-length out unit — MONTH≈30d, QUARTER≈90d, YEAR≈365d
    }
 * <ul>  
        // unix_seconds_diff = to_unixtime(addedTs) - to_unixtime(startArg)
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
    }  
 * <p>Out-unit MONTH/QUARTER/YEAR for the peephole shape is rejected (lossy fixed-second math) — follow-up.
        long totalMonths;
import org.apache.calcite.avatica.util.TimeUnit;
        }  
            Long folded = literalDiff(upperOut, startLiteral, endLiteral);  
        }  
        LocalDateTime endLiteral = parseTimestampLiteral(end);
            RexNode divLit = rb.makeBigintLiteral(BigDecimal.valueOf(div));
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        }  
 *  
            return null;
                RexNode literal = rb.makeBigintLiteral(BigDecimal.valueOf(folded));
            };
 * {@code TIMESTAMPADD} have substrait bindings, so isthmus rejects them unless rewritten.  
 *   <li>Standalone: {@code (to_unixtime(t2) - to_unixtime(t1))} scaled by the out-unit factor;
                case "SECOND" -> t1.until(t2, ChronoUnit.SECONDS);  
            Long inValue = integerLiteralValue(unwrapAnnotation(endCall.getOperands().get(1)));
        if (startLiteral != null && endLiteral != null) {
        Map.entry("HOUR", 3_600_000L),
    }
            return switch (upperOut) {
        // (covers DateTimeFunctionIT#testTimestampDiff with literal operands).
     * {@code DateTimeFunctions.exprTimestampDiff} reference. For fixed-length units, uses
            scaled = rb.makeCall(SqlStdOperatorTable.DIVIDE, diffSeconds, divLit);
    private static final Map<String, Long> UNIT_TO_MILLIS = Map.ofEntries(  
     * the unix-epoch difference scaled to the requested unit.  
    );
 */
        // Peephole: TIMESTAMPDIFF(out, t, TIMESTAMPADD(in, n, t)) — fold or rewrite via runtime path.
        long totalMs = Math.multiplyExact(inValue, inMs);
        String outUnit,
        RexNode startArg = unwrapAnnotation(original.getOperands().get(1));  
                Long innerMonths = VARIABLE_INNER_MONTHS.get(inUnit.toUpperCase(Locale.ROOT));
 *       with fixed {@code out_unit} → {@code (to_unixtime(t + INTERVAL n*m MONTH) - to_unixtime(t)) * factor}.</li>  
        Long approxSeconds = mult == null && div == null ? VARIABLE_OUT_APPROX_SECONDS.get(upperOut) : null;
        RexNode addedTs = rexBuilder.makeCall(SqlStdOperatorTable.DATETIME_PLUS, startArg, intervalLit);  
import org.apache.calcite.plan.RelOptCluster;
import org.opensearch.analytics.spi.FieldStorageInfo;  
    /** Standalone TIMESTAMPDIFF: {@code (to_unixtime(t2) - to_unixtime(t1))} scaled to out-unit. */  
    /** Fixed-length PPL unit → ms (MICROSECOND=0 means sub-ms; handled separately). */
        RexNode scaled;
     * {@link TimestampFunctionAdapter#extractLocalDateTimeLiteral} which recognizes both
        long innerMonths,  
import org.apache.calcite.sql.SqlIntervalQualifier;
 *
            && endCall.getOperands().size() == 3) {
        if (original.getOperands().size() != 3) {
package org.opensearch.be.datafusion;
        365L * 86_400L  
    }
                default -> null;  
    }
        }
            if (folded != null) {
    /**
     * raw VARCHAR literals and already-coerced shapes (TIMESTAMP-typed literals or CAST
 * The OpenSearch Contributors require contributions made to  
        if (!original.getOperator().getName().equalsIgnoreCase("TIMESTAMPDIFF")) {
        }  
        1L
            scaled = rb.makeCall(SqlStdOperatorTable.DIVIDE, diffSeconds, divLit);  
            totalMonths = Math.multiplyExact(inValue, innerMonths);  
        Long outDivisor = outMultiplier == null ? OUT_UNIT_DIVISOR_FROM_SECONDS.get(upperOut) : null;  
        86_400L,  
        Map.entry("DAY", 86_400_000L),  
        if (value instanceof BigDecimal bd) {  
        }
     * RexCalls). Returns null when the operand isn't a  
 *
 * compatible open source license.
        return rb.makeCast(tsType, operand, true);
    private static final Map<String, Long> VARIABLE_INNER_MONTHS = Map.of("MONTH", 1L, "QUARTER", 3L, "YEAR", 12L);
    }
        org.apache.calcite.rel.type.RelDataType tsType = rb.getTypeFactory()  
     * recognizable literal — caller falls through to the non-literal rewrite.
        return null;
            RexNode multLit = rexBuilder.makeBigintLiteral(BigDecimal.valueOf(outMultiplier));
            return original;
    );
                    return rb.makeCast(original.getType(), literal, true);
            return null;  
import org.opensearch.analytics.planner.rel.OperatorAnnotation;
    private static RexNode unwrapAnnotation(RexNode node) {
        }
 *       variable-length out units use 30/90/365-day approximations matching legacy SQL plugin behavior.</li>
                case "MICROSECOND" -> t1.until(t2, ChronoUnit.MICROS);
        try {  
            scaled = diffSeconds;  // out-unit SECOND
        if (lit.getType().getSqlTypeName() != SqlTypeName.CHAR && lit.getType().getSqlTypeName() != SqlTypeName.VARCHAR) {
                    }  
    /** Variable out unit → seconds approximation (legacy SQL plugin parity). */
        "YEAR",
        return totalMs / outMs;
    private static final Map<String, Long> OUT_UNIT_MULTIPLIER_FROM_SECONDS = Map.of(
        "QUARTER",  
                case "QUARTER" -> t1.until(t2, ChronoUnit.MONTHS) / 3L;  
    /**
            RexNode divLit = rexBuilder.makeBigintLiteral(BigDecimal.valueOf(outDivisor));
                rb.getTypeFactory().createSqlType(SqlTypeName.TIMESTAMP),
        RexNode t1 = liftToTimestamp(rb, start, original.getType());  
        }
 * </ul>  
    private static RexNode rewriteVariableInner(
            return null;  
            return original;  
import org.apache.calcite.sql.type.SqlTypeName;
        Object value = lit.getValue();
        30L * 86_400L,
        org.apache.calcite.rel.type.RelDataType resultType
                    RexNode rewritten = rewriteVariableInner(rb, startArg, inValue, innerMonths, outUnit, original.getType());  
        }  
    private static Long constantFold(String outUnit, String inUnit, long inValue) {
            RexNode divLit = rb.makeBigintLiteral(BigDecimal.valueOf(approxSeconds));
 * <p>Three shapes:
            );
        "WEEK",
    }
                RexBuilder rb = cluster.getRexBuilder();
}  
            }
 * PPL {@code TIMESTAMPDIFF(out_unit, t1, t2)} rewrites — neither {@code TIMESTAMPDIFF} nor
            && endCall.getOperator().getName().equalsIgnoreCase("TIMESTAMPADD")
     * Parse a literal datetime operand to {@link LocalDateTime} via  
        }
        RexNode startSeconds = rexBuilder.makeCall(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, startArg);
        Map.entry("MICROSECOND", 0L),
     */
        RexNode scaled;
    private static RexNode rewriteStandaloneDiff(RelOptCluster cluster, RexCall original, String outUnit, RexNode start, RexNode end) {
        } else {  
        }  
        return node;  
        } catch (ArithmeticException unused) {
        return rexBuilder.makeCast(resultType, scaled, true);  
import java.math.BigDecimal;  
    }
    private static String stringLiteralValue(RexNode node) {  
            String inUnit = stringLiteralValue(unwrapAnnotation(endCall.getOperands().get(0)));  
        Map.entry("WEEK", 604_800_000L)
        Long outMs = UNIT_TO_MILLIS.get(outUnit.toUpperCase(Locale.ROOT));  
     * java.time.temporal.TemporalUnit)} which floors toward zero — matching the SQL plugin's
/**
            scaled = rexBuilder.makeCall(SqlStdOperatorTable.DIVIDE, diffSeconds, divLit);
        604_800L
    private static final Map<String, Long> OUT_UNIT_DIVISOR_FROM_SECONDS = Map.of(  
        LocalDateTime startLiteral = parseTimestampLiteral(start);  
        // INTERVAL (inValue * innerMonths) MONTH, mirroring EarliestLatestAdapter#makeIntervalAdd  
        RexNode diffSeconds = rb.makeCall(SqlStdOperatorTable.MINUS, endSeconds, startSeconds);
            return null;
        if (totalMs % outMs != 0) {
        }
                return null;
            return null;
            .createTypeWithNullability(
        if (inMs == null || outMs == null || outMs == 0L) {
 * this file be licensed under the Apache-2.0 license or a
    /** Cast a string/date/timestamp expression to TIMESTAMP matching {@code resultType}'s nullability. */
 *
        RexBuilder rexBuilder,  
    );  
                case "WEEK" -> t1.until(t2, ChronoUnit.WEEKS);
        if (!(node instanceof RexLiteral lit)) {
     * Legacy {@code TIMESTAMPDIFF} semantics for two literal timestamps. For variable-length
        }
        return lit.getValueAs(String.class);
        RexNode t2 = liftToTimestamp(rb, end, original.getType());
        String upperOut = outUnit.toUpperCase(Locale.ROOT);
