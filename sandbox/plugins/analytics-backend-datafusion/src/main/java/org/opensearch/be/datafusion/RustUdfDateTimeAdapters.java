        }
 * The OpenSearch Contributors require contributions made to
                    rexBuilder.getTypeFactory().createSqlType(SqlTypeName.TIMESTAMP),
    private static void rejectOutOfRangeMonthOrDay(RexCall original) {
import org.opensearch.analytics.spi.NumericToDoubleAdapter;
            // can't even declare one). Anchor a TIME first operand to a TIMESTAMP via the shared
    }
        /** True if the unit is a literal naming a date-part (the only case we can specialize). */
    static final class MaketimeAdapter extends NumericToDoubleAdapter {
import org.apache.calcite.rex.RexBuilder;
package org.opensearch.be.datafusion;
            RexBuilder rexBuilder = cluster.getRexBuilder();
    static final class OsYearweekAdapter extends AbstractNameMappingAdapter {
        DatetimeLiteralValidator.validate(firstArg, kind);
import org.apache.calcite.sql.SqlFunctionCategory;
            RexNode unit = original.getOperands().get(0);
/*
            }
    }
            RexNode ts = rexBuilder.makeCall(tsType, LOCAL_FROM_UNIXTIME_OP, List.of(epoch));
    private static SqlOperator udf(String name, SqlReturnTypeInference ret, SqlOperandTypeChecker operands) {
        FromUnixtimeAdapter() {
        }
            "QUARTER",
    static final class FromUnixtimeAdapter extends NumericToDoubleAdapter {
    static final class MakedateAdapter extends NumericToDoubleAdapter {
import org.apache.calcite.rex.RexLiteral;
        @Override
    /**
        }
                return super.adapt(original, fieldStorage, cluster);
        );
            super(LOCAL_STR_TO_DATE_OP, List.of(), List.of());
        }
            return super.adapt(original, fieldStorage, cluster);
        OperandTypes.family(SqlTypeFamily.ANY, SqlTypeFamily.ANY, SqlTypeFamily.ANY)
        java.util.regex.Matcher valMatcher = VALUE_NUMBER.matcher(value);
            RexNode value = original.getOperands().get(1);
        MaketimeAdapter() {
     * rather than the 1970 epoch implied by Arrow's TIME representation.
            RelDataType nonNullVarchar = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
                coerced.add(original.getOperands().get(i));
     * UTC date at plan time before the VARCHAR cast — matches SQL plugin's {@code FunctionProperties
                coerced.add(DatePartAdapters.coerceCharacterOperandToTimestamp(original.getOperands().get(0), cluster));
    );
            RexNode timeAsVarchar = rexBuilder.makeCast(varcharType, value);
            RexCall toAdapt = isTimeValueOperand(original) ? rewriteTimeOperand(original, cluster) : original;
                List<RexNode> coerced = new java.util.ArrayList<>(original.getOperands().size());
 *
    // MONTHNAME(x) → date_format(x, '%M'). %M renders full month name (e.g. "September").
            if (original.getOperands().size() != 2) {
                throw outOfRange("day", n, 1, 31, value, format);
            super(LOCAL_MAKETIME_OP);
            for (int i = 1; i < original.getOperands().size(); i++) {
        "maketime",
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        StrToDateAdapter() {
            RelDataType tsType = rexBuilder.getTypeFactory()
        if (original.getOperands().isEmpty()) {
 * Substrait sigs live in {@code opensearch_scalar_functions.yaml} +
     * {@link DatePartAdapters#coerceCharacterOperandToTimestamp} helper (handling character/TIME forms
import java.util.Set;
            return;
    static final SqlOperator LOCAL_FROM_UNIXTIME_OP = udf("from_unixtime", ReturnTypes.TIMESTAMP_NULLABLE, OperandTypes.ANY);
 * compatible open source license.
            super(LOCAL_DATE_FORMAT_OP, List.of(), List.of("%W"));
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
    static final class TimeFormatAdapter extends AbstractNameMappingAdapter {
    }
    // via mysql_format::weekday_full — matches legacy PPL DAYNAME semantics.
    private static IllegalArgumentException outOfRange(String component, int n, int lo, int hi, String value, String format) {
    /**
                for (int i = 1; i < original.getOperands().size(); i++) {
        }
        @Override
     * <p>For TIME(p) operands, CASTs to VARCHAR so the call binds to the {@code (string, string)}
        }
            return call.getOperands().size() == 2 && call.getOperands().get(1).getType().getSqlTypeName() == SqlTypeName.TIME;
        if (value == null || format == null) {
        }
        }
            )
        }
 */
        }
        OsYearweekAdapter() {
            if (!original.getOperands().isEmpty() && original.getOperands().get(0).getType().getSqlTypeName() == SqlTypeName.TIME) {
     * Adapter for PPL {@code extract(<unit> FROM <expr>)}.
    static final SqlOperator LOCAL_MAKEDATE_OP = udf("makedate", ReturnTypes.DATE_NULLABLE, OperandTypes.ANY_ANY);
import org.opensearch.analytics.spi.FieldStorageInfo;
     * with MySQL year-boundary semantics). The first operand is coerced to TIMESTAMP via the shared
            RexNode prefix = rexBuilder.makeLiteral(todayPrefix, nonNullVarchar, false);
            String token = fmtMatcher.group();
            }
            rejectOutOfRangeMonthOrDay(original);
        DateFormatAdapter() {
import org.apache.calcite.rex.RexCall;
            return super.adapt(original, fieldStorage, cluster);
        ReturnTypes.TIME_NULLABLE,
    /**
            if (("%d".equals(token) || "%e".equals(token)) && (n < 1 || n > 31)) {
            super(LOCAL_OS_WEEK_OP, List.of(), List.of());
                    coerced.add(original.getOperands().get(i));
    }
        }
            }
    }
        }
    }
        DaynameAdapter() {
    static final class StrToDateAdapter extends AbstractNameMappingAdapter {
            String.format(
        OsWeekAdapter() {
            }
        while (fmtMatcher.find() && valMatcher.find()) {
    static final SqlOperator LOCAL_TIME_FORMAT_OP = udf("time_format", ReturnTypes.VARCHAR_NULLABLE, OperandTypes.ANY_ANY);
        private static final Set<String> DATE_PART_UNITS = Set.of(
                continue;
        private static RexCall rewriteTimeOperand(RexCall original, RelOptCluster cluster) {
            if (original.getOperands().isEmpty()) {
 * {@link DataFusionFragmentConvertor#ADDITIONAL_SCALAR_SIGS}.
            for (int i = 1; i < originalOperands.size(); i++) {
        @Override
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
            return super.adapt(original, fieldStorage, cluster);
 * @opensearch.internal
    static final class ExtractAdapter extends AbstractNameMappingAdapter {
     * PPL {@code YEARWEEK(date[, mode])} — routes to the {@code os_yearweek} Rust UDF (year*100+week
        );
            List<RexNode> coerced = new java.util.ArrayList<>(originalOperands.size());
        MakedateAdapter() {
            }
    static final SqlOperator LOCAL_MAKETIME_OP = udf(
        }
            RexNode format = original.getOperands().get(1);
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
            return raw != null && DATE_PART_UNITS.contains(raw.toString().toUpperCase(Locale.ROOT));
                n = Integer.parseInt(valMatcher.group());
            "DOW",
import org.apache.calcite.sql.type.SqlOperandTypeChecker;
        MonthnameAdapter() {
                coerced.add(originalOperands.get(i));
                    originalOperands.get(0).getType().isNullable()
        @Override
    }
import org.apache.calcite.sql.type.OperandTypes;
 * names a Calcite {@link SqlFunction} matching a UDF in {@code rust/src/udf/mod.rs};
        }
        RexNode firstArg = original.getOperands().get(0);
 */
    private static final java.util.regex.Pattern VALUE_NUMBER = java.util.regex.Pattern.compile("\\d+");
                hi,
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.plan.RelOptCluster;
            Object raw = ((RexLiteral) unit).getValue2();
import org.apache.calcite.sql.type.ReturnTypes;
import org.apache.calcite.sql.type.SqlReturnTypeInference;
        private static boolean needsDateContext(RexNode unit) {
    static final class OsWeekAdapter extends AbstractNameMappingAdapter {
        }
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
            DatePartAdapters.validateDatetimeLiteral(originalOperands.get(0));
                return false;
            validateFirstArgIfStringLiteral(original, DatetimeLiteralValidator.Kind.TIMESTAMP);
            }
            "DAY_SECOND",
        }
            RelDataType timestampType = rexBuilder.getTypeFactory()
            }
            return rexBuilder.makeCall(varcharType, SqlStdOperatorTable.CONCAT, List.of(prefix, timeAsVarchar));
            return super.adapt(toAdapt, fieldStorage, cluster);
    static final SqlOperator LOCAL_DATE_FORMAT_OP = udf("date_format", ReturnTypes.VARCHAR_NULLABLE, OperandTypes.ANY_ANY);
            RexBuilder rexBuilder = cluster.getRexBuilder();
     * the same way {@code WEEKDAY}/{@code os_week} do) so it binds the yaml {@code precision_timestamp<P>}
                return super.adapt(original, fieldStorage, cluster);
            }
    /** YEARWEEK(date [, mode]) target — routes to the Rust {@code os_yearweek} UDF. */
        /** Returns {@code "<today> " || cast(time as varchar)}; today snapshotted at plan time. */
            String todayPrefix = LocalDate.now(ZoneOffset.UTC).toString() + " ";
        }
        }
    static final SqlOperator LOCAL_OS_WEEK_OP = udf("os_week", ReturnTypes.INTEGER_NULLABLE, OperandTypes.VARIADIC);
 *
import java.time.LocalDate;
     * yaml overload — substrait-java 0.89.1 can't emit a {@code precision_time<P>} signature.
    }
            // coercion path so isthmus binds the precision_timestamp<P> arm — same workaround
                value,
            return;
     * .getQueryStartClock()} snapshot semantics so date-parts on TIME values yield the current date
    static final class MonthnameAdapter extends AbstractNameMappingAdapter {
import java.util.Locale;
            "YEAR",
        }
            // Calcite-stock TIME serialises to substrait precision_time<P>, which has no yaml
import org.apache.calcite.sql.type.SqlTypeFamily;
        }
            "DAY_HOUR",
        if (original.getOperands().size() != 2) {
            RexNode epoch = NumericToDoubleAdapter.widenToDoubleIfNumeric(original.getOperands().get(0), cluster);
    /** PPL str_to_date returns NULL on parse failure; invalid month/day values still need to error rather than silent-null. */
        @Override
                format
        if (!SqlTypeFamily.CHARACTER.contains(firstArg.getType())) {
    static final class DaynameAdapter extends AbstractNameMappingAdapter {
        @Override
/**
                );
            super(LOCAL_FROM_UNIXTIME_OP);
    /** Mirrors legacy DateTimeFormatterUtil: reject %m/%c values outside 1..12 and %d/%e values outside 1..31. */
    }
            coerced.add(DatePartAdapters.coerceCharacterOperandToTimestamp(original.getOperands().get(0), cluster));
            try {
                component,
        ExtractAdapter() {
            RelDataType varcharType = rexBuilder.getTypeFactory()
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        }
final class RustUdfDateTimeAdapters {
            return;
            return super.adapt(original, fieldStorage, cluster);
            "MONTH",
            RexNode rewrittenValue = needsDateContext(unit) ? prependTodayLiteral(rexBuilder, varcharType, timeAsVarchar) : timeAsVarchar;
            }
            coerced.add(rexBuilder.makeCast(timestampType, originalOperands.get(0)));
                RexBuilder rexBuilder = cluster.getRexBuilder();
                throw outOfRange("month", n, 1, 12, value, format);
            RexBuilder rexBuilder = cluster.getRexBuilder();
            if (originalOperands.isEmpty() || !SqlTypeFamily.CHARACTER.contains(originalOperands.get(0).getType())) {
    // DAYNAME(x) → date_format(x, '%W'). %W renders full weekday name (e.g. "Monday")
    }
            "YEAR_MONTH",
            if (("%m".equals(token) || "%c".equals(token)) && (n < 1 || n > 12)) {
import java.time.ZoneOffset;
    /** WEEK(date [, mode]) target — MySQL semantics, accepts 1- and 2-arg forms. */
                .createTypeWithNullability(rexBuilder.getTypeFactory().createSqlType(SqlTypeName.VARCHAR), value.getType().isNullable());
            // DatePartAdapters uses for hour/minute/second.
                }
            super(LOCAL_DATE_FORMAT_OP, List.of(), List.of());
                "%s value %d is out of range (%d..%d) in str_to_date('%s', '%s')",
        TimeFormatAdapter() {
            "DAY_MICROSECOND"
                .createTypeWithNullability(rexBuilder.getTypeFactory().createSqlType(SqlTypeName.TIMESTAMP), true);
            super(LOCAL_OS_YEARWEEK_OP, List.of(), List.of());
        @Override
        @Override
     * substrait resolver rejects VARCHAR for the YAML date/timestamp impls.
        private static boolean isTimeValueOperand(RexCall call) {
        /**
    static final SqlOperator LOCAL_OS_YEARWEEK_OP = udf("os_yearweek", ReturnTypes.INTEGER_NULLABLE, OperandTypes.VARIADIC);
        /** Units that need a date context; pure time-parts (HOUR/MINUTE/...) are absent. */
        java.util.regex.Matcher fmtMatcher = FORMAT_TOKEN.matcher(format);
import org.apache.calcite.sql.SqlKind;
        }
                n,
     */
        }
         */
 * SPDX-License-Identifier: Apache-2.0
    /** PPL FROM_UNIXTIME(epoch [, format]); 2-arg → date_format(from_unixtime(epoch), format). */
        @Override
            super(LOCAL_EXTRACT_OP, List.of(), List.of());
    private RustUdfDateTimeAdapters() {}
     * Other operand types (DATE / TIMESTAMP / VARCHAR) pass through unchanged.
import org.apache.calcite.sql.SqlOperator;
            "WEEK",
            validateFirstArgIfStringLiteral(original, DatetimeLiteralValidator.Kind.TIMESTAMP);
import org.apache.calcite.sql.type.SqlTypeName;
        return new SqlFunction(name, SqlKind.OTHER_FUNCTION, ret, null, operands, SqlFunctionCategory.TIMEDATE);
            "DAY_MINUTE",
}
            "DOY",
        String format = fmtLit.getValueAs(String.class);
            int n;
    }
            // signature (substrait-java 0.89.1 lacks ToTypeString for PrecisionTime, so the yaml
import org.apache.calcite.rex.RexNode;
            if (!(unit instanceof RexLiteral)) {
        if (!(original.getOperands().get(0) instanceof RexLiteral valueLit)
        return new IllegalArgumentException(
        private static RexNode prependTodayLiteral(RexBuilder rexBuilder, RelDataType varcharType, RexNode timeAsVarchar) {
import java.util.List;
     */
 * Adapters for PPL datetime functions routed to Rust UDFs. Each {@code LOCAL_*_OP}
            return super.adapt(original, fieldStorage, cluster);
            || !(original.getOperands().get(1) instanceof RexLiteral fmtLit)) {
            List<RexNode> originalOperands = original.getOperands();
        }
                return rexBuilder.makeCall(original.getType(), LOCAL_TIME_FORMAT_OP, coerced);
                return super.adapt(original, fieldStorage, cluster);
            RexBuilder rexBuilder = cluster.getRexBuilder();
            return rexBuilder.makeCall(original.getType(), LOCAL_OS_YEARWEEK_OP, coerced);
         * UTC date to the time string so Rust parses it as a full timestamp; otherwise just casts
     * Rewrites WEEK(date [, mode]) to os_week(...). String operands cast to TIMESTAMP because the
    }
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
 * this file be licensed under the Apache-2.0 license or a
     */
        }
import org.opensearch.analytics.spi.AbstractNameMappingAdapter;
            return (RexCall) rexBuilder.makeCall(original.getType(), original.getOperator(), List.of(unit, rewrittenValue));
            super(LOCAL_DATE_FORMAT_OP, List.of(), List.of("%M"));
        String value = valueLit.getValueAs(String.class);
    static final SqlOperator LOCAL_EXTRACT_OP = udf("opensearch_extract", ReturnTypes.BIGINT_NULLABLE, OperandTypes.ANY_ANY);
            return;
                lo,
         * TIME→VARCHAR.
            return rexBuilder.makeCall(original.getType(), LOCAL_DATE_FORMAT_OP, List.of(ts, format));
        }
            return rexBuilder.makeCall(original.getType(), LOCAL_OS_WEEK_OP, coerced);
     * <p>When the unit is a known date-part (YEAR/MONTH/DAY/...), the value is anchored to today's
        }
        }
     * signature; an optional {@code mode} operand passes through unchanged.
            validateFirstArgIfStringLiteral(original, DatetimeLiteralValidator.Kind.TIMESTAMP);
import org.apache.calcite.sql.SqlFunction;
            } catch (NumberFormatException ignored) {
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
         * Builds the rewritten call for a TIME value operand. For date-part units, prepends today's
            }
    static final class DateFormatAdapter extends AbstractNameMappingAdapter {
        }
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        }
    static final SqlOperator LOCAL_STR_TO_DATE_OP = udf("str_to_date", ReturnTypes.TIMESTAMP_NULLABLE, OperandTypes.ANY_ANY);
    }
    }
    private static final java.util.regex.Pattern FORMAT_TOKEN = java.util.regex.Pattern.compile("%[a-zA-Z]");
            super(LOCAL_TIME_FORMAT_OP, List.of(), List.of());
            "DAY",
                Locale.ROOT,
            super(LOCAL_MAKEDATE_OP);
    private static void validateFirstArgIfStringLiteral(RexCall original, DatetimeLiteralValidator.Kind kind) {
            return;
            List<RexNode> coerced = new java.util.ArrayList<>(original.getOperands().size());
            validateFirstArgIfStringLiteral(original, DatetimeLiteralValidator.Kind.TIMESTAMP);
                .createTypeWithNullability(
    }
