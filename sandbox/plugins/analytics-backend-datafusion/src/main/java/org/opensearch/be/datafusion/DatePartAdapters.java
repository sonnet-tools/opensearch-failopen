        return new DatePartAdapters("day");
            return false;
            return;
        validateDatetimeLiteral(operand);
        Long part = extractFromTime(time);
            LocalDateTime.parse(value.replace(' ', 'T'));
    }
 * avoids the simplifier-folded {@code CAST(time AS TIMESTAMP)} path Arrow rejects —
        String prefix = LocalDate.now(java.time.ZoneOffset.UTC).toString() + " ";
    private static LocalTime extractTimeLiteral(RexNode operand) {
    private static final Set<String> DATE_ONLY_UNITS = Set.of("year", "quarter", "month", "day", "week", "doy", "dow");
import org.apache.calcite.rex.RexBuilder;
            return false;
    }
        List<RexNode> args = new ArrayList<>(coerced.size() + 1);
        args.add(rexBuilder.makeLiteral(unit, unitType, true));
    static DatePartAdapters dayOfYear() {
            return false;
    static DatePartAdapters hour() {
            org.apache.calcite.sql.fun.SqlStdOperatorTable.CONCAT,
                validateDatetimeLiteralForUnit(operand, unit);
            RexNode inner = stripOperatorAnnotation(call.getOperands().get(0));
        );
        return operand.getType().getSqlTypeName() == SqlTypeName.TIME;
            return null;
        super(SqlLibraryOperators.DATE_PART, List.of(unit), List.of());
    private static boolean isCharacterOperand(RexNode operand) {
    private final String unit;
        return rexBuilder.makeCall(original.getType(), SqlLibraryOperators.DATE_PART, args);
    }
    private static RexNode castToTimestampWithTodayPrefixForBareTime(RexNode operand, RelOptCluster cluster) {
        if (value == null) {
    }
                } catch (DateTimeParseException ignored) {
    static RexNode coerceCharacterOperandToTimestamp(RexNode operand, RelOptCluster cluster) {
    /** Fold a 1-arg call when the operand is a TIME literal (or {@code to_time('<lit>')}). */
    static void validateDatetimeLiteral(RexNode operand) {
    /** Date-part units reject bare-time literals (DAY('12:00:00') must throw, not silent-fail). */
import java.util.Set;
        }
        RexNode prefixLit = rexBuilder.makeLiteral(prefix, varchar, false);
    /** TIME → CONCAT(today-UTC, ' ', CAST AS VARCHAR) → CAST AS TIMESTAMP. */
        switch (unit) {
        try {
    private static RexNode castTimeToTimestamp(RexNode operand, RelOptCluster cluster) {
            }
                return LocalTime.ofNanoOfDay(millisOfDay.longValue() * 1_000_000L);
            nullableVarchar,
            factory.createSqlType(SqlTypeName.TIMESTAMP),
        if (!(operand instanceof RexLiteral literal)) {
    static DatePartAdapters week() {
            if (folded != null) {
        }
            return castTimeToTimestamp(operand, cluster);
        String value = literal.getValueAs(String.class);
            if (isCharacterOperand(operand)) {
            return;
        if (time == null) {
        return new DatePartAdapters("minute");
        if (!(operand instanceof RexLiteral literal)) {
    }
                if (value == null) return null;
    /** Time-only units reject bare-date literals (HOUR('2020-08-26') must throw, not return 0). */
 * The OpenSearch Contributors require contributions made to
            return;
 * <p>TIME operand handling: isthmus emits Calcite's TIME as Substrait
        return castToTimestamp(concat, cluster);
    static void validateDatetimeLiteralForUnit(RexNode operand, String unit) {
            return true;
            return;
            LocalTime.parse(value);
        return cluster.getRexBuilder().makeCast(timestampType, operand);
        RexBuilder rexBuilder = cluster.getRexBuilder();
import java.time.LocalDate;
 * {@link DatetimeLiteralHelper#unwrapTimeLiteralToTimestamp} (matching reference
        if (DATE_ONLY_UNITS.contains(unit)) {
            case "second":
            if (inner instanceof RexLiteral innerLit && SqlTypeFamily.CHARACTER.contains(innerLit.getType())) {
 *
import org.opensearch.analytics.planner.rel.OperatorAnnotation;
}
            return null;
            default:
            } else {
    }
        try {
        RexNode concat = rexBuilder.makeCall(
                    return null;
import org.apache.calcite.rex.RexNode;
        }
        try {
        }
        RelDataType nullableVarchar = rexBuilder.getTypeFactory().createTypeWithNullability(varchar, operand.getType().isNullable());
    /** Shared coercion for sibling adapters: TIME → today-anchored TIMESTAMP, VARCHAR → validated CAST. */
import org.apache.calcite.sql.type.SqlTypeFamily;
            return super.adapt(original, fieldStorage, cluster);
    }
            operand.getType().isNullable()
import org.apache.calcite.sql.type.SqlTypeName;
    /** bare-time string ({@code '17:30:00'}) → CONCAT(today-UTC, ' ', s) → CAST TIMESTAMP. */
        return new DatePartAdapters("week");
                try {
    /** Date-portion units (year/month/day/...) don't apply to a TIME value — return null. */
    }
                return folded;
        // to_time('<lit>') call wrapping a VARCHAR literal.
            LocalDate.parse(value);
        List<RexNode> coerced = new ArrayList<>(original.getOperands().size());
        }
        }
        }
import java.util.List;
    }
    }
            }
    private static final Set<String> TIME_ONLY_UNITS = Set.of("hour", "minute", "second", "microsecond");
        RelDataType timestampType = factory.createTypeWithNullability(
            DatetimeLiteralValidator.validate(operand, DatetimeLiteralValidator.Kind.TIME);
import org.apache.calcite.sql.fun.SqlLibraryOperators;
    }
        return new DatePartAdapters("microsecond");
        }
                return time.getNano() / 1_000L;
    }
        return new DatePartAdapters("month");
            return;
        }
            List.of(prefixLit, timeAsVarchar)
    DatePartAdapters(String unit) {
    private RexNode tryFoldTimeLiteralOperand(RexNode operand, RexCall original, RelOptCluster cluster) {
 * {@code precision_time<P>?}, which binds to no {@code date_part} sig in our
 * landing on the yaml's {@code precision_timestamp<P>} sig.
    }
    /** True for a string {@link RexLiteral} that parses as bare time only (HH:mm:ss[.SSSSSSSSS]). */
 * Date-part extractor adapters — rewrite {@code FN(ts)} to {@code date_part('<unit>', ts)}.
            return null;
                return (long) time.getSecond();
            }
 * PPL semantics: bare TIME = LocalDateTime.of(epoch, time)). Non-literal TIME
        if (operand instanceof RexCall call && call.getOperands().size() == 1 && call.getType().getSqlTypeName() == SqlTypeName.TIME) {
            throw new IllegalArgumentException(
import org.apache.calcite.rel.type.RelDataType;
        RexNode concat = rexBuilder.makeCall(varchar, org.apache.calcite.sql.fun.SqlStdOperatorTable.CONCAT, List.of(prefixLit, operand));
    }
        } catch (DateTimeParseException ignored) {}
        if (original.getOperands().stream().noneMatch(DatePartAdapters::needsCoercion)) {
        return null;
        this.unit = unit;
    }
            Integer millisOfDay = lit.getValueAs(Integer.class);
 * TIME and bare-time strings get today-UTC anchored first.
final class DatePartAdapters extends AbstractNameMappingAdapter {
                coerced.add(castToTimestampWithTodayPrefixForBareTime(operand, cluster));
        if (operand.getType().getSqlTypeName() == SqlTypeName.TIME) {
                String.format(Locale.ROOT, "timestamp:%s in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", value)
        } catch (DateTimeParseException ignored) {
        RelDataType varchar = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
 */
                return (long) time.getHour();
    private static boolean isBareTimeString(RexNode operand) {
                String value = innerLit.getValueAs(String.class);
        while (node instanceof OperatorAnnotation ann && ann.unwrap() != null) {
        }
        }
        String value = literal.getValueAs(String.class);
import java.util.ArrayList;
        RexNode prefixLit = rexBuilder.makeLiteral(prefix, varchar, false);
 * emits {@code CAST(CAST(time AS VARCHAR) AS TIMESTAMP)} — routing through VARCHAR
        RexNode timeAsVarchar = rexBuilder.makeCast(nullableVarchar, operand);
        } catch (DateTimeParseException ignored) {}
                return null;
import org.apache.calcite.rel.type.RelDataTypeFactory;
 * {@code ParameterizedTypeThrowsVisitor} error on every call). For TIME literals
            LocalTime.parse(value);
        if (value == null) {
        if (operand instanceof RexLiteral lit && lit.getType().getSqlTypeName() == SqlTypeName.TIME) {
    }
            }
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
    private static boolean needsCoercion(RexNode operand) {
    private Long extractFromTime(LocalTime time) {
        return new DatePartAdapters("doy");
    /** Plan-time validation for string-literal operands; accepts datetime / date / time, rejects garbage. */
        return isCharacterOperand(operand) || operand.getType().getSqlTypeName() == SqlTypeName.TIME;
        );
import org.apache.calcite.plan.RelOptCluster;
            if (ts != null) {
import org.opensearch.analytics.spi.FieldStorageInfo;
        }
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    }
        return SqlTypeFamily.CHARACTER.contains(operand.getType());
        // HOUR(TIME('lit')) etc. — (string, precision_time) has no substrait sig, fold here.
        RelDataTypeFactory factory = cluster.getTypeFactory();
        args.addAll(coerced);
    private static RexNode castToTimestamp(RexNode operand, RelOptCluster cluster) {
        if (TIME_ONLY_UNITS.contains(unit)) {
    }
        if (original.getOperands().size() == 1) {
            node = ann.unwrap();
import org.apache.calcite.rex.RexCall;
                coerced.add(castTimeToTimestamp(operand, cluster));
            return operand;
/**
        } catch (DateTimeParseException ignored) {
        if (!isCharacterOperand(operand)) {
    }
        LocalTime time = extractTimeLiteral(operand);
    private static boolean isTimeOperand(RexNode operand) {
            // causeless — see DatetimeLiteralValidator#fail.
        return castToTimestampWithTodayPrefixForBareTime(operand, cluster);
            case "hour":
 * yaml (declaring that sig directly triggers a runtime
        }
 * Character-family operands cast to TIMESTAMP so substrait binds the (string, precision_timestamp&lt;P&gt;) sig;
        }
        for (RexNode operand : original.getOperands()) {
        operand = stripOperatorAnnotation(operand);
    private static RexNode stripOperatorAnnotation(RexNode node) {
        if (part == null) {
    }
        RelDataType unitType = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
    /** Operand needs coercion if it is a character or TIME — TIMESTAMP/DATE bind directly. */
        validateDatetimeLiteral(operand);
        return new DatePartAdapters("hour");
    static DatePartAdapters year() {
 *
        RelDataType varchar = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
                coerced.add(operand);
                try {
                    return LocalTime.parse(value);
    static DatePartAdapters minute() {
            } else if (operand.getType().getSqlTypeName() == SqlTypeName.TIME) {
        RexBuilder rexBuilder = cluster.getRexBuilder();
        return new DatePartAdapters("year");
                return (long) time.getMinute();
import org.apache.calcite.rex.RexLiteral;
    static DatePartAdapters microsecond() {
    @Override
                }
import org.opensearch.analytics.spi.AbstractNameMappingAdapter;
            if (millisOfDay != null) {
            case "microsecond":
        return new DatePartAdapters("quarter");
    static DatePartAdapters day() {
        }
import java.time.LocalTime;
    }
    }
        RexNode lit = rexBuilder.makeBigintLiteral(java.math.BigDecimal.valueOf(part));
import java.time.LocalDateTime;
                } catch (DateTimeParseException ignored) {}
        }
        }
        RexBuilder rexBuilder = cluster.getRexBuilder();
        if (!isBareTimeString(operand)) {
    }
        }
            case "minute":
    }
            }
package org.opensearch.be.datafusion;
        String prefix = LocalDate.now(java.time.ZoneOffset.UTC).toString() + " ";
import java.util.Locale;
    }
        try {
    static DatePartAdapters month() {
 * @opensearch.internal
            return;
        }
            return;
        RexBuilder rexBuilder = cluster.getRexBuilder();
/*
            RexNode folded = tryFoldTimeLiteralOperand(original.getOperands().get(0), original, cluster);
            org.apache.calcite.util.TimeString ts = lit.getValueAs(org.apache.calcite.util.TimeString.class);
import java.time.format.DateTimeParseException;
 * SPDX-License-Identifier: Apache-2.0
            return castToTimestamp(operand, cluster);
                    return LocalTime.parse(ts.toString());
 * we synthesize a TIMESTAMP literal pinned to 1970-01-01 via
    static DatePartAdapters quarter() {
 */
 *
        return castToTimestamp(concat, cluster);
            );
        return node;
        return rexBuilder.makeCast(original.getType(), lit, true);
        }
            DatetimeLiteralValidator.validate(operand, DatetimeLiteralValidator.Kind.DATE);
