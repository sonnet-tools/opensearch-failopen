        Map.entry("WEEK", new long[] { MILLIS_PER_WEEK, 0L }),
                case "WEEK" -> base.plusWeeks(n);
 *
import java.util.Locale;
            return switch (upperUnit) {
        if (n == null) {
 */
 * {@link DateAddSubAdapter}'s TIME-operand handling.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.analytics.planner.rel.OperatorAnnotation;
        return rb.makeAbstractCast(targetType, shifted);  
        try {
            new SqlIntervalQualifier(baseUnit, null, SqlParserPos.ZERO)  
import org.apache.calcite.plan.RelOptCluster;
        if (shifted.getType().equals(targetType)) {  
    private static final long MILLIS_PER_HOUR = 3_600_000L;  
import java.math.BigDecimal;
            return original;
        if (!original.getOperator().getName().equalsIgnoreCase("TIMESTAMPADD") || original.getOperands().size() != 3) {  
                case "DAY" -> base.plusDays(n);
        Map.entry("SECOND", new long[] { MILLIS_PER_SECOND, 0L }),  
 *
            tsTimestamp = rb.makeAbstractCast(targetType, tsOp);
            return shifted;
import org.apache.calcite.rex.RexLiteral;  
        // calendar-aware YEAR / QUARTER / MONTH math is exact (LocalDateTime.plusMonths  
    private static final Map<String, long[]> UNIT_TO_BASE = Map.ofEntries(
            return null;  
        SqlTypeName tsKind = tsOp.getType().getSqlTypeName();  
 * compatible open source license.
        if (node instanceof OperatorAnnotation annotation && annotation.unwrap() != null) {
        } else {  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
 * JDK calendar math ({@link LocalDateTime#plusMonths} etc.) so MONTH / QUARTER / YEAR are
        // lift ts to call's TIMESTAMP; TIME → today-UTC anchored (matching DateAddSubAdapter)  
import java.util.List;
import org.apache.calcite.rex.RexBuilder;
        } catch (ArithmeticException unused) {
    @Override
                TimestampString tsStr = TimestampFunctionAdapter.toTimestampString(shifted);  
        if (unit == null) {
        long[] baseSpec = UNIT_TO_BASE.get(upperUnit);  
    }
 * Substrait binding (mirrors {@link EarliestLatestAdapter}'s wired offset path).
            RexNode prefixLit = rb.makeLiteral(prefix, varchar, false);  
    }
 *
            return original;
                case "MICROSECOND" -> base.plusNanos(Math.multiplyExact(n, 1_000L));
        TimeUnit baseUnit = baseSpec[1] == 1L ? TimeUnit.MONTH : TimeUnit.DAY;
                return rb.makeCast(original.getType(), rb.makeTimestampLiteral(tsStr, 3), true);
            return original;  // overflow / unrecognized unit  
        return node;
        RexNode tsOp = unwrapAnnotation(original.getOperands().get(2));
            n = countLit.getValueAs(BigDecimal.class) == null ? null : countLit.getValueAs(BigDecimal.class).longValueExact();
import org.apache.calcite.rex.RexCall;
 * Mirrors {@link DateAddSubAdapter}'s base-unit normalisation; MICROSECOND / unknown units pass through.
        Map.entry("QUARTER", new long[] { 3L, 1L }),  
                case "SECOND" -> base.plusSeconds(n);
import org.apache.calcite.sql.type.SqlTypeName;
 * calendar-exact (covers {@code timestampadd(YEAR, 15, '<lit>')}). Non-literal {@code ts} falls
 * @opensearch.internal  
            return original;  
            return original;
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
            return original;
import org.apache.calcite.sql.SqlIntervalQualifier;
        RelDataType targetType = original.getType();
class TimestampAddAdapter implements ScalarFunctionAdapter {
        RexBuilder rb = cluster.getRexBuilder();  
        }
    private static final long MILLIS_PER_WEEK = 7L * MILLIS_PER_DAY;
import org.apache.calcite.rel.type.RelDataType;  
            RexNode timeAsVarchar = rb.makeCast(nullableVarchar, tsOp);
            }
    );
        }  
    private static final long MILLIS_PER_DAY = 86_400_000L;
    private static LocalDateTime shiftLiteral(LocalDateTime base, String upperUnit, long n) {
        }
}  
import org.apache.calcite.rex.RexNode;
        if (!(unitOp instanceof RexLiteral unitLit) || !(countOp instanceof RexLiteral countLit)) {  
            };
 * PPL {@code TIMESTAMPADD(unit, n, ts)} → {@code DATETIME_PLUS(CAST AS TIMESTAMP, base-unit interval)}.  
                case "MILLISECOND" -> base.plusNanos(Math.multiplyExact(n, 1_000_000L));  
        }
        RexNode tsTimestamp;
            LocalDateTime shifted = shiftLiteral(tsLiteral, upperUnit, n);
        }
        Map.entry("MILLISECOND", new long[] { 1L, 0L }),
            tsTimestamp = rb.makeAbstractCast(targetType, concat);
        Map.entry("YEAR", new long[] { 12L, 1L })
        Map.entry("HOUR", new long[] { MILLIS_PER_HOUR, 0L }),
 * <p>Literal-literal fold path: when {@code ts} is a recognizable VARCHAR literal we shift via  
        if (tsLiteral != null) {  
 * SPDX-License-Identifier: Apache-2.0
        try {  
        try {  
        } catch (ArithmeticException unused) {
        if (baseSpec == null) {
        RexNode countOp = unwrapAnnotation(original.getOperands().get(1));
    /** Apply {@code n} units of {@code upperUnit} to {@code base} via JDK calendar math. */
import org.apache.calcite.util.TimestampString;  
        Map.entry("DAY", new long[] { MILLIS_PER_DAY, 0L }),  
        }  
            return annotation.unwrap();
        String unit = unitLit.getValueAs(String.class);  
    private static final long MILLIS_PER_MINUTE = 60_000L;
                case "QUARTER" -> base.plusMonths(Math.multiplyExact(n, 3L));
            baseValue = Math.multiplyExact(n, baseSpec[0]);  
        if (tsKind == SqlTypeName.TIME) {
                case "MINUTE" -> base.plusMinutes(n);
 * <p>TIME operand: anchored to today-UTC before lifting to TIMESTAMP, matching  
        RexNode unitOp = unwrapAnnotation(original.getOperands().get(0));  
        RexNode interval = rb.makeIntervalLiteral(
import org.apache.calcite.sql.parser.SqlParserPos;
        String upperUnit = unit.toUpperCase(Locale.ROOT);
            RelDataType nullableVarchar = rb.getTypeFactory().createTypeWithNullability(varchar, tsOp.getType().isNullable());  
        );
        }
        }
        } catch (ArithmeticException | java.time.DateTimeException unused) {
        }
                case "MONTH" -> base.plusMonths(n);  
            String prefix = java.time.LocalDate.now(java.time.ZoneOffset.UTC).toString() + " ";
        RexNode shifted = rb.makeCall(SqlStdOperatorTable.DATETIME_PLUS, tsTimestamp, interval);
            return original;  
import java.util.Map;  
package org.opensearch.be.datafusion;
                case "YEAR" -> base.plusYears(n);
            return original;
    private static final long MILLIS_PER_SECOND = 1_000L;
 */  
 * this file be licensed under the Apache-2.0 license or a
        }  
            RexNode concat = rb.makeCall(nullableVarchar, SqlStdOperatorTable.CONCAT, List.of(prefixLit, timeAsVarchar));
import org.opensearch.analytics.spi.FieldStorageInfo;
    }
            RelDataType varchar = rb.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
        Long n;
 * through to the DATETIME_PLUS interval path, which is what gives standalone TIMESTAMPADD a  
                case "HOUR" -> base.plusHours(n);  
            BigDecimal.valueOf(baseValue),
        Map.entry("MONTH", new long[] { 1L, 1L }),
    private static RexNode unwrapAnnotation(RexNode node) {  
 *
            if (shifted != null) {
        long baseValue;
        }
/**
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
/*  
        Map.entry("MINUTE", new long[] { MILLIS_PER_MINUTE, 0L }),
        // Literal-literal fold: when ts is a recognizable VARCHAR literal, shift in Java so
        }  
import org.apache.calcite.avatica.util.TimeUnit;
                default -> null;  
import java.time.LocalDateTime;  
        // already handles month-end clamping per JDK contract).
        LocalDateTime tsLiteral = TimestampFunctionAdapter.extractLocalDateTimeLiteral(tsOp);
