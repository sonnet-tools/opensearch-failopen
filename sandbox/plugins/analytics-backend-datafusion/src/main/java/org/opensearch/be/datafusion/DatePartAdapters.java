            return super.adapt(original, fieldStorage, cluster);
import org.opensearch.analytics.spi.FieldStorageInfo;
                return null;
    }
            case "minute":
 * The OpenSearch Contributors require contributions made to  
        }
        while (node instanceof OperatorAnnotation ann && ann.unwrap() != null) {
                } catch (DateTimeParseException ignored) {  
}
    static DatePartAdapters quarter() {
        RexBuilder rexBuilder = cluster.getRexBuilder();
            return null;
 * Character-family operands cast to TIMESTAMP so substrait binds the (string, precision_timestamp&lt;P&gt;) sig;
    }  
        for (RexNode operand : original.getOperands()) {
        if (TIME_ONLY_UNITS.contains(unit)) {
            );
    /** Date-portion units (year/month/day/...) don't apply to a TIME value — return null. */
            return null;
        List<RexNode> args = new ArrayList<>(coerced.size() + 1);
        return new DatePartAdapters("minute");
    static DatePartAdapters dayOfYear() {
        if (!isBareTimeString(operand)) {
        return new DatePartAdapters("microsecond");
    /** bare-time string ({@code '17:30:00'}) → CONCAT(today-UTC, ' ', s) → CAST TIMESTAMP. */
 * Date-part extractor adapters — rewrite {@code FN(ts)} to {@code date_part('<unit>', ts)}.
import org.apache.calcite.rel.type.RelDataType;
            return;  
import java.time.format.DateTimeParseException;  
        super(SqlLibraryOperators.DATE_PART, List.of(unit), List.of());
    }
            org.apache.calcite.util.TimeString ts = lit.getValueAs(org.apache.calcite.util.TimeString.class);
        }  
        return new DatePartAdapters("quarter");
import java.util.Set;
    static DatePartAdapters year() {  
            LocalTime.parse(value);
        RexNode concat = rexBuilder.makeCall(varchar, org.apache.calcite.sql.fun.SqlStdOperatorTable.CONCAT, List.of(prefixLit, operand));
    }
        RexBuilder rexBuilder = cluster.getRexBuilder();
import org.apache.calcite.rex.RexBuilder;
    private static LocalTime extractTimeLiteral(RexNode operand) {
            DatetimeLiteralValidator.validate(operand, DatetimeLiteralValidator.Kind.TIME);
        try {  
                if (value == null) return null;  
        if (!isCharacterOperand(operand)) {
        args.add(rexBuilder.makeLiteral(unit, unitType, true));
import org.apache.calcite.sql.type.SqlTypeName;
        String value = literal.getValueAs(String.class);
    }
            RexNode folded = tryFoldTimeLiteralOperand(original.getOperands().get(0), original, cluster);
    private static final Set<String> DATE_ONLY_UNITS = Set.of("year", "quarter", "month", "day", "week", "doy", "dow");
 * SPDX-License-Identifier: Apache-2.0
    /** Shared coercion for sibling adapters: TIME → today-anchored TIMESTAMP, VARCHAR → validated CAST. */  
        }
        }
    private static boolean isBareTimeString(RexNode operand) {
    }  
        RelDataType timestampType = factory.createTypeWithNullability(
        }
import java.time.LocalDate;  
    static DatePartAdapters day() {  
import org.apache.calcite.rex.RexCall;
            }  
                    return LocalTime.parse(value);
        String prefix = LocalDate.now(java.time.ZoneOffset.UTC).toString() + " ";
    /** Date-part units reject bare-time literals (DAY('12:00:00') must throw, not silent-fail). */  
        }
import java.time.LocalDateTime;
                coerced.add(operand);  
 * we synthesize a TIMESTAMP literal pinned to 1970-01-01 via  
    private static boolean isTimeOperand(RexNode operand) {
        } catch (DateTimeParseException ignored) {}  
            org.apache.calcite.sql.fun.SqlStdOperatorTable.CONCAT,  
            case "second":  
                return (long) time.getSecond();
 * yaml (declaring that sig directly triggers a runtime
            }
        this.unit = unit;  
        if (value == null) {  
            }
    }
 */
 * PPL semantics: bare TIME = LocalDateTime.of(epoch, time)). Non-literal TIME
final class DatePartAdapters extends AbstractNameMappingAdapter {  
    private Long extractFromTime(LocalTime time) {  
        } catch (DateTimeParseException ignored) {}
                }
        RelDataType varchar = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
        RexNode lit = rexBuilder.makeBigintLiteral(java.math.BigDecimal.valueOf(part));
            return false;
    static void validateDatetimeLiteral(RexNode operand) {
    static RexNode coerceCharacterOperandToTimestamp(RexNode operand, RelOptCluster cluster) {
    }  
        }
    private final String unit;
                } catch (DateTimeParseException ignored) {}
        if (DATE_ONLY_UNITS.contains(unit)) {
        } catch (DateTimeParseException ignored) {
            nullableVarchar,
    }  
                return (long) time.getHour();  
        RexNode timeAsVarchar = rexBuilder.makeCast(nullableVarchar, operand);
import org.apache.calcite.rex.RexNode;
        );
    }
            LocalDateTime.parse(value.replace(' ', 'T'));
        }
        RexNode prefixLit = rexBuilder.makeLiteral(prefix, varchar, false);  
                try {
                try {  
 *  
    static void validateDatetimeLiteralForUnit(RexNode operand, String unit) {  
        validateDatetimeLiteral(operand);
        }
        return new DatePartAdapters("day");
        args.addAll(coerced);  
            return;
            default:
            }
        return new DatePartAdapters("year");
        try {  
        }  
        );
import org.opensearch.analytics.spi.AbstractNameMappingAdapter;  
    static DatePartAdapters minute() {  
            return operand;  
        if (original.getOperands().stream().noneMatch(DatePartAdapters::needsCoercion)) {  
            List.of(prefixLit, timeAsVarchar)
        RexNode concat = rexBuilder.makeCall(
    private static RexNode stripOperatorAnnotation(RexNode node) {  
        try {
import org.apache.calcite.plan.RelOptCluster;
    static DatePartAdapters hour() {
        return rexBuilder.makeCast(original.getType(), lit, true);
package org.opensearch.be.datafusion;
        return SqlTypeFamily.CHARACTER.contains(operand.getType());
    }  
    private RexNode tryFoldTimeLiteralOperand(RexNode operand, RexCall original, RelOptCluster cluster) {
        return isCharacterOperand(operand) || operand.getType().getSqlTypeName() == SqlTypeName.TIME;  
            case "hour":
        RelDataType nullableVarchar = rexBuilder.getTypeFactory().createTypeWithNullability(varchar, operand.getType().isNullable());  
    /** True for a string {@link RexLiteral} that parses as bare time only (HH:mm:ss[.SSSSSSSSS]). */  
        }
        }
    /** Operand needs coercion if it is a character or TIME — TIMESTAMP/DATE bind directly. */
            } else {
                return LocalTime.ofNanoOfDay(millisOfDay.longValue() * 1_000_000L);  
            return;  
 * landing on the yaml's {@code precision_timestamp<P>} sig.
            return true;
                    return null;
import org.apache.calcite.rex.RexLiteral;  
    /** Time-only units reject bare-date literals (HOUR('2020-08-26') must throw, not return 0). */  
 * emits {@code CAST(CAST(time AS VARCHAR) AS TIMESTAMP)} — routing through VARCHAR  
    private static RexNode castToTimestamp(RexNode operand, RelOptCluster cluster) {
                coerced.add(castToTimestampWithTodayPrefixForBareTime(operand, cluster));
            return castToTimestamp(operand, cluster);
    }  
        return castToTimestampWithTodayPrefixForBareTime(operand, cluster);  
            if (millisOfDay != null) {
                return time.getNano() / 1_000L;  
            } else if (operand.getType().getSqlTypeName() == SqlTypeName.TIME) {  
        if (!(operand instanceof RexLiteral literal)) {
    }
            return null;  
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        RelDataType varchar = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
        return new DatePartAdapters("week");  
        }
import org.apache.calcite.sql.type.SqlTypeFamily;  
    static DatePartAdapters month() {
            operand.getType().isNullable()  
    }
        }  
        if (value == null) {  
            throw new IllegalArgumentException(  
        return operand.getType().getSqlTypeName() == SqlTypeName.TIME;
                    return LocalTime.parse(ts.toString());
        return castToTimestamp(concat, cluster);  
    DatePartAdapters(String unit) {
                String value = innerLit.getValueAs(String.class);
    }
            return false;
        return null;
import java.util.Locale;  
    private static RexNode castToTimestampWithTodayPrefixForBareTime(RexNode operand, RelOptCluster cluster) {  
            return false;  
        // to_time('<lit>') call wrapping a VARCHAR literal.
                validateDatetimeLiteralForUnit(operand, unit);
            return castTimeToTimestamp(operand, cluster);  
        if (operand instanceof RexCall call && call.getOperands().size() == 1 && call.getType().getSqlTypeName() == SqlTypeName.TIME) {
 * TIME and bare-time strings get today-UTC anchored first.  
    }
        Long part = extractFromTime(time);
 *
    @Override  
        }
        }  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
import org.apache.calcite.sql.fun.SqlLibraryOperators;
        validateDatetimeLiteral(operand);  
    }
        try {
        RexBuilder rexBuilder = cluster.getRexBuilder();  
 * {@code precision_time<P>?}, which binds to no {@code date_part} sig in our  
    }
 * @opensearch.internal
        // HOUR(TIME('lit')) etc. — (string, precision_time) has no substrait sig, fold here.
        }
            Integer millisOfDay = lit.getValueAs(Integer.class);
            if (folded != null) {
import java.util.List;
 */  
        if (operand.getType().getSqlTypeName() == SqlTypeName.TIME) {
        RelDataType unitType = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);  
        if (original.getOperands().size() == 1) {  
            factory.createSqlType(SqlTypeName.TIMESTAMP),
        }
    static DatePartAdapters microsecond() {
        if (!(operand instanceof RexLiteral literal)) {
        return cluster.getRexBuilder().makeCast(timestampType, operand);
        RexBuilder rexBuilder = cluster.getRexBuilder();  
        String prefix = LocalDate.now(java.time.ZoneOffset.UTC).toString() + " ";  
            case "microsecond":
            LocalDate.parse(value);  
                coerced.add(castTimeToTimestamp(operand, cluster));
 * {@link DatetimeLiteralHelper#unwrapTimeLiteralToTimestamp} (matching reference
            return;
    /** TIME → CONCAT(today-UTC, ' ', CAST AS VARCHAR) → CAST AS TIMESTAMP. */
            DatetimeLiteralValidator.validate(operand, DatetimeLiteralValidator.Kind.DATE);  
        return rexBuilder.makeCall(original.getType(), SqlLibraryOperators.DATE_PART, args);
        switch (unit) {
 *
        if (part == null) {  
            return;
    }  
            return;  
import java.util.ArrayList;
            if (ts != null) {
        return new DatePartAdapters("month");  
        RexNode prefixLit = rexBuilder.makeLiteral(prefix, varchar, false);
            // causeless — see DatetimeLiteralValidator#fail.
    }  
    }
/**  
        RelDataTypeFactory factory = cluster.getTypeFactory();  
            LocalTime.parse(value);
        return new DatePartAdapters("hour");  
    private static boolean isCharacterOperand(RexNode operand) {  
        if (operand instanceof RexLiteral lit && lit.getType().getSqlTypeName() == SqlTypeName.TIME) {  
                String.format(Locale.ROOT, "timestamp:%s in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", value)
        } catch (DateTimeParseException ignored) {  
        }
        LocalTime time = extractTimeLiteral(operand);
            }  
    private static RexNode castTimeToTimestamp(RexNode operand, RelOptCluster cluster) {  
import java.time.LocalTime;
        if (time == null) {
    }
        return new DatePartAdapters("doy");
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * {@code ParameterizedTypeThrowsVisitor} error on every call). For TIME literals
        return castToTimestamp(concat, cluster);  
 * avoids the simplifier-folded {@code CAST(time AS TIMESTAMP)} path Arrow rejects —
    private static final Set<String> TIME_ONLY_UNITS = Set.of("hour", "minute", "second", "microsecond");
            if (isCharacterOperand(operand)) {  
    static DatePartAdapters week() {
        operand = stripOperatorAnnotation(operand);  
    /** Fold a 1-arg call when the operand is a TIME literal (or {@code to_time('<lit>')}). */
            if (inner instanceof RexLiteral innerLit && SqlTypeFamily.CHARACTER.contains(innerLit.getType())) {
        List<RexNode> coerced = new ArrayList<>(original.getOperands().size());
                return folded;  
        String value = literal.getValueAs(String.class);
    }
    }
        return node;
 * <p>TIME operand handling: isthmus emits Calcite's TIME as Substrait
    private static boolean needsCoercion(RexNode operand) {
                return (long) time.getMinute();
            node = ann.unwrap();
            return;
/*  
            RexNode inner = stripOperatorAnnotation(call.getOperands().get(0));  
        }  
    }
import org.opensearch.analytics.planner.rel.OperatorAnnotation;
    /** Plan-time validation for string-literal operands; accepts datetime / date / time, rejects garbage. */  
