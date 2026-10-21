            return original;
import java.time.LocalDateTime;
import java.util.List;
 * Mirrors {@link DateAddSubAdapter}'s base-unit normalisation; MICROSECOND / unknown units pass through.
        // already handles month-end clamping per JDK contract).
            return original;  // overflow / unrecognized unit
        String unit = unitLit.getValueAs(String.class);
        RexBuilder rb = cluster.getRexBuilder();
    }
            RelDataType varchar = rb.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
    private static final Map<String, long[]> UNIT_TO_BASE = Map.ofEntries(
        Map.entry("HOUR", new long[] { MILLIS_PER_HOUR, 0L }),
    );
        Map.entry("MILLISECOND", new long[] { 1L, 0L }),
        if (!(unitOp instanceof RexLiteral unitLit) || !(countOp instanceof RexLiteral countLit)) {
        if (unit == null) {
            if (shifted != null) {
        if (n == null) {
    private static RexNode unwrapAnnotation(RexNode node) {
 * JDK calendar math ({@link LocalDateTime#plusMonths} etc.) so MONTH / QUARTER / YEAR are
 * @opensearch.internal
            return shifted;
        if (shifted.getType().equals(targetType)) {
        }
            return switch (upperUnit) {
        if (node instanceof OperatorAnnotation annotation && annotation.unwrap() != null) {
import org.opensearch.analytics.planner.rel.OperatorAnnotation;
                case "MICROSECOND" -> base.plusNanos(Math.multiplyExact(n, 1_000L));
 * this file be licensed under the Apache-2.0 license or a
 */
        if (tsKind == SqlTypeName.TIME) {
import org.apache.calcite.rex.RexBuilder;
        return rb.makeAbstractCast(targetType, shifted);
        }
                case "YEAR" -> base.plusYears(n);
            RexNode prefixLit = rb.makeLiteral(prefix, varchar, false);
import org.apache.calcite.sql.SqlIntervalQualifier;
            tsTimestamp = rb.makeAbstractCast(targetType, tsOp);
        TimeUnit baseUnit = baseSpec[1] == 1L ? TimeUnit.MONTH : TimeUnit.DAY;
 *
import java.math.BigDecimal;
        }
 * through to the DATETIME_PLUS interval path, which is what gives standalone TIMESTAMPADD a
        try {
        RexNode unitOp = unwrapAnnotation(original.getOperands().get(0));
                case "MINUTE" -> base.plusMinutes(n);
 * PPL {@code TIMESTAMPADD(unit, n, ts)} → {@code DATETIME_PLUS(CAST AS TIMESTAMP, base-unit interval)}.
import org.apache.calcite.sql.type.SqlTypeName;
package org.opensearch.be.datafusion;
        RexNode interval = rb.makeIntervalLiteral(
 *
    private static final long MILLIS_PER_WEEK = 7L * MILLIS_PER_DAY;
        RexNode tsTimestamp;
        String upperUnit = unit.toUpperCase(Locale.ROOT);
/*
import java.util.Map;
                default -> null;
        if (tsLiteral != null) {
        LocalDateTime tsLiteral = TimestampFunctionAdapter.extractLocalDateTimeLiteral(tsOp);
import java.util.Locale;
        try {
            return original;
                case "QUARTER" -> base.plusMonths(Math.multiplyExact(n, 3L));
import org.apache.calcite.rex.RexNode;
class TimestampAddAdapter implements ScalarFunctionAdapter {
 *
            return annotation.unwrap();
        Map.entry("MONTH", new long[] { 1L, 1L }),
        RexNode shifted = rb.makeCall(SqlStdOperatorTable.DATETIME_PLUS, tsTimestamp, interval);
        } else {
                case "HOUR" -> base.plusHours(n);
    private static LocalDateTime shiftLiteral(LocalDateTime base, String upperUnit, long n) {
    }
        }
        try {
        long[] baseSpec = UNIT_TO_BASE.get(upperUnit);
            String prefix = java.time.LocalDate.now(java.time.ZoneOffset.UTC).toString() + " ";
    /** Apply {@code n} units of {@code upperUnit} to {@code base} via JDK calendar math. */
            return null;
        } catch (ArithmeticException unused) {
        }
        // calendar-aware YEAR / QUARTER / MONTH math is exact (LocalDateTime.plusMonths
 */
import org.apache.calcite.plan.RelOptCluster;
 * <p>Literal-literal fold path: when {@code ts} is a recognizable VARCHAR literal we shift via
                case "DAY" -> base.plusDays(n);
        Long n;
 * <p>TIME operand: anchored to today-UTC before lifting to TIMESTAMP, matching
            RexNode timeAsVarchar = rb.makeCast(nullableVarchar, tsOp);
        Map.entry("MINUTE", new long[] { MILLIS_PER_MINUTE, 0L }),
        Map.entry("DAY", new long[] { MILLIS_PER_DAY, 0L }),
            new SqlIntervalQualifier(baseUnit, null, SqlParserPos.ZERO)
 * Substrait binding (mirrors {@link EarliestLatestAdapter}'s wired offset path).
import org.apache.calcite.sql.parser.SqlParserPos;
import org.apache.calcite.rel.type.RelDataType;
        // lift ts to call's TIMESTAMP; TIME → today-UTC anchored (matching DateAddSubAdapter)
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        );
                case "SECOND" -> base.plusSeconds(n);
import org.apache.calcite.rex.RexLiteral;
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
    @Override
        } catch (ArithmeticException | java.time.DateTimeException unused) {
 * calendar-exact (covers {@code timestampadd(YEAR, 15, '<lit>')}). Non-literal {@code ts} falls
            BigDecimal.valueOf(baseValue),
        }
        if (baseSpec == null) {
    private static final long MILLIS_PER_SECOND = 1_000L;
                return rb.makeCast(original.getType(), rb.makeTimestampLiteral(tsStr, 3), true);
            LocalDateTime shifted = shiftLiteral(tsLiteral, upperUnit, n);
            return original;
        }
    private static final long MILLIS_PER_MINUTE = 60_000L;
        }
            RelDataType nullableVarchar = rb.getTypeFactory().createTypeWithNullability(varchar, tsOp.getType().isNullable());
 * {@link DateAddSubAdapter}'s TIME-operand handling.
}
                case "WEEK" -> base.plusWeeks(n);
        }
        } catch (ArithmeticException unused) {
            return original;
    }
        return node;
        Map.entry("WEEK", new long[] { MILLIS_PER_WEEK, 0L }),
import org.apache.calcite.rex.RexCall;
        RexNode tsOp = unwrapAnnotation(original.getOperands().get(2));
            baseValue = Math.multiplyExact(n, baseSpec[0]);
            }
                case "MILLISECOND" -> base.plusNanos(Math.multiplyExact(n, 1_000_000L));
            return original;
        long baseValue;
import org.opensearch.analytics.spi.FieldStorageInfo;
/**
import org.apache.calcite.avatica.util.TimeUnit;
            RexNode concat = rb.makeCall(nullableVarchar, SqlStdOperatorTable.CONCAT, List.of(prefixLit, timeAsVarchar));
    private static final long MILLIS_PER_HOUR = 3_600_000L;
            };
        Map.entry("QUARTER", new long[] { 3L, 1L }),
import org.apache.calcite.util.TimestampString;
                case "MONTH" -> base.plusMonths(n);
            n = countLit.getValueAs(BigDecimal.class) == null ? null : countLit.getValueAs(BigDecimal.class).longValueExact();
        }
        // Literal-literal fold: when ts is a recognizable VARCHAR literal, shift in Java so
 * SPDX-License-Identifier: Apache-2.0
        if (!original.getOperator().getName().equalsIgnoreCase("TIMESTAMPADD") || original.getOperands().size() != 3) {
        Map.entry("SECOND", new long[] { MILLIS_PER_SECOND, 0L }),
        RelDataType targetType = original.getType();
            return original;
        Map.entry("YEAR", new long[] { 12L, 1L })
        }
 *
    private static final long MILLIS_PER_DAY = 86_400_000L;
 * compatible open source license.
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            return original;
            tsTimestamp = rb.makeAbstractCast(targetType, concat);
        RexNode countOp = unwrapAnnotation(original.getOperands().get(1));
 * The OpenSearch Contributors require contributions made to
        SqlTypeName tsKind = tsOp.getType().getSqlTypeName();
                TimestampString tsStr = TimestampFunctionAdapter.toTimestampString(shifted);
        }
