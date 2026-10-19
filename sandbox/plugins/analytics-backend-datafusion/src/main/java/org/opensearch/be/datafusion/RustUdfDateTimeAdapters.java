        );
                "%s value %d is out of range (%d..%d) in str_to_date('%s', '%s')",  
            super(LOCAL_FROM_UNIXTIME_OP);  
                .createTypeWithNullability(rexBuilder.getTypeFactory().createSqlType(SqlTypeName.TIMESTAMP), true);  
                }
        }  
        @Override  
        }
import java.util.Set;
            return;
            return rexBuilder.makeCall(varcharType, SqlStdOperatorTable.CONCAT, List.of(prefix, timeAsVarchar));
            return;
        DateFormatAdapter() {
            RexNode value = original.getOperands().get(1);
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
    static final SqlOperator LOCAL_FROM_UNIXTIME_OP = udf("from_unixtime", ReturnTypes.TIMESTAMP_NULLABLE, OperandTypes.ANY);  
        }
        /** Returns {@code "<today> " || cast(time as varchar)}; today snapshotted at plan time. */  
            String todayPrefix = LocalDate.now(ZoneOffset.UTC).toString() + " ";
            return rexBuilder.makeCall(original.getType(), LOCAL_OS_WEEK_OP, coerced);
         * UTC date to the time string so Rust parses it as a full timestamp; otherwise just casts
        private static RexCall rewriteTimeOperand(RexCall original, RelOptCluster cluster) {
            return super.adapt(original, fieldStorage, cluster);
    static final class FromUnixtimeAdapter extends NumericToDoubleAdapter {
            "DAY_HOUR",  
                Locale.ROOT,
    static final SqlOperator LOCAL_TIME_FORMAT_OP = udf("time_format", ReturnTypes.VARCHAR_NULLABLE, OperandTypes.ANY_ANY);
     * UTC date at plan time before the VARCHAR cast — matches SQL plugin's {@code FunctionProperties
                .createTypeWithNullability(rexBuilder.getTypeFactory().createSqlType(SqlTypeName.VARCHAR), value.getType().isNullable());  
        StrToDateAdapter() {
final class RustUdfDateTimeAdapters {  
    static final class StrToDateAdapter extends AbstractNameMappingAdapter {  
            }
            RexBuilder rexBuilder = cluster.getRexBuilder();
            "YEAR",
        );
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
            if (originalOperands.isEmpty() || !SqlTypeFamily.CHARACTER.contains(originalOperands.get(0).getType())) {
        if (!(original.getOperands().get(0) instanceof RexLiteral valueLit)
            DatePartAdapters.validateDatetimeLiteral(originalOperands.get(0));  
            "DOW",  
     * PPL {@code YEARWEEK(date[, mode])} — routes to the {@code os_yearweek} Rust UDF (year*100+week
        "maketime",
    static final class OsYearweekAdapter extends AbstractNameMappingAdapter {
            )
import java.time.ZoneOffset;
            "DAY_SECOND",
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
    /** YEARWEEK(date [, mode]) target — routes to the Rust {@code os_yearweek} UDF. */
     * rather than the 1970 epoch implied by Arrow's TIME representation.  
import org.apache.calcite.rex.RexLiteral;
        @Override  
        }  
/**
        }  
        @Override
                return super.adapt(original, fieldStorage, cluster);  
    /**
     * with MySQL year-boundary semantics). The first operand is coerced to TIMESTAMP via the shared
            super(LOCAL_EXTRACT_OP, List.of(), List.of());
    private RustUdfDateTimeAdapters() {}
        return new IllegalArgumentException(  
            // DatePartAdapters uses for hour/minute/second.  
            coerced.add(rexBuilder.makeCast(timestampType, originalOperands.get(0)));
                component,
                value,
            }
            validateFirstArgIfStringLiteral(original, DatetimeLiteralValidator.Kind.TIMESTAMP);
    static final SqlOperator LOCAL_OS_WEEK_OP = udf("os_week", ReturnTypes.INTEGER_NULLABLE, OperandTypes.VARIADIC);  
            rejectOutOfRangeMonthOrDay(original);
            List<RexNode> originalOperands = original.getOperands();
            }
     */
            super(LOCAL_MAKETIME_OP);
            try {  
        MonthnameAdapter() {
        }
import org.apache.calcite.sql.SqlOperator;
    }  
    }
            Object raw = ((RexLiteral) unit).getValue2();
import java.util.Locale;
 * SPDX-License-Identifier: Apache-2.0
            RexBuilder rexBuilder = cluster.getRexBuilder();
        /** True if the unit is a literal naming a date-part (the only case we can specialize). */  
    }
            if (("%d".equals(token) || "%e".equals(token)) && (n < 1 || n > 31)) {
import org.apache.calcite.sql.SqlKind;  
        }
import org.apache.calcite.sql.type.SqlOperandTypeChecker;
        }
    private static final java.util.regex.Pattern FORMAT_TOKEN = java.util.regex.Pattern.compile("%[a-zA-Z]");
                continue;  
            // can't even declare one). Anchor a TIME first operand to a TIMESTAMP via the shared
        }  
            "DOY",
        }  
                return false;  
 * this file be licensed under the Apache-2.0 license or a
            }
        RexNode firstArg = original.getOperands().get(0);
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        private static final Set<String> DATE_PART_UNITS = Set.of(  
     * <p>For TIME(p) operands, CASTs to VARCHAR so the call binds to the {@code (string, string)}
            } catch (NumberFormatException ignored) {
                    coerced.add(original.getOperands().get(i));  
 * {@link DataFusionFragmentConvertor#ADDITIONAL_SCALAR_SIGS}.
            super(LOCAL_OS_WEEK_OP, List.of(), List.of());
        if (!SqlTypeFamily.CHARACTER.contains(firstArg.getType())) {
     */  
import java.time.LocalDate;
}
        }  
     * Rewrites WEEK(date [, mode]) to os_week(...). String operands cast to TIMESTAMP because the  
import org.apache.calcite.sql.type.SqlTypeFamily;
    /**
            return raw != null && DATE_PART_UNITS.contains(raw.toString().toUpperCase(Locale.ROOT));  
    }
            "DAY_MICROSECOND"  
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
            List<RexNode> coerced = new java.util.ArrayList<>(original.getOperands().size());  
        MaketimeAdapter() {
                    originalOperands.get(0).getType().isNullable()
            super(LOCAL_DATE_FORMAT_OP, List.of(), List.of("%M"));
     * Other operand types (DATE / TIMESTAMP / VARCHAR) pass through unchanged.
        }  
            RelDataType varcharType = rexBuilder.getTypeFactory()
            "DAY",  
        @Override
            super(LOCAL_OS_YEARWEEK_OP, List.of(), List.of());  
        TimeFormatAdapter() {
            RexNode unit = original.getOperands().get(0);  
        return new SqlFunction(name, SqlKind.OTHER_FUNCTION, ret, null, operands, SqlFunctionCategory.TIMEDATE);
                coerced.add(DatePartAdapters.coerceCharacterOperandToTimestamp(original.getOperands().get(0), cluster));
        OsYearweekAdapter() {
        }
                n,
        java.util.regex.Matcher valMatcher = VALUE_NUMBER.matcher(value);
    static final SqlOperator LOCAL_MAKEDATE_OP = udf("makedate", ReturnTypes.DATE_NULLABLE, OperandTypes.ANY_ANY);  
        }  
 * The OpenSearch Contributors require contributions made to  
            RexNode prefix = rexBuilder.makeLiteral(todayPrefix, nonNullVarchar, false);
            "QUARTER",
     * Adapter for PPL {@code extract(<unit> FROM <expr>)}.  
        }
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    static final class DateFormatAdapter extends AbstractNameMappingAdapter {  
            if (!(unit instanceof RexLiteral)) {
    /** Mirrors legacy DateTimeFormatterUtil: reject %m/%c values outside 1..12 and %d/%e values outside 1..31. */
            for (int i = 1; i < original.getOperands().size(); i++) {
 * compatible open source license.
     * yaml overload — substrait-java 0.89.1 can't emit a {@code precision_time<P>} signature.
        }  
            if (("%m".equals(token) || "%c".equals(token)) && (n < 1 || n > 12)) {
import org.apache.calcite.sql.SqlFunction;
            "YEAR_MONTH",
    }  
            "MONTH",
                return super.adapt(original, fieldStorage, cluster);  
            return super.adapt(toAdapt, fieldStorage, cluster);
            }
    }
        private static boolean isTimeValueOperand(RexCall call) {
    static final class ExtractAdapter extends AbstractNameMappingAdapter {  
            RexBuilder rexBuilder = cluster.getRexBuilder();
            RexCall toAdapt = isTimeValueOperand(original) ? rewriteTimeOperand(original, cluster) : original;  
            validateFirstArgIfStringLiteral(original, DatetimeLiteralValidator.Kind.TIMESTAMP);  
 * @opensearch.internal
        /**
    static final SqlOperator LOCAL_OS_YEARWEEK_OP = udf("os_yearweek", ReturnTypes.INTEGER_NULLABLE, OperandTypes.VARIADIC);  
import org.apache.calcite.sql.type.OperandTypes;  
package org.opensearch.be.datafusion;
            return rexBuilder.makeCall(original.getType(), LOCAL_DATE_FORMAT_OP, List.of(ts, format));
    private static IllegalArgumentException outOfRange(String component, int n, int lo, int hi, String value, String format) {
        java.util.regex.Matcher fmtMatcher = FORMAT_TOKEN.matcher(format);
            return;
        if (value == null || format == null) {
            super(LOCAL_DATE_FORMAT_OP, List.of(), List.of("%W"));
            }  
            RelDataType timestampType = rexBuilder.getTypeFactory()
         * Builds the rewritten call for a TIME value operand. For date-part units, prepends today's  
            return super.adapt(original, fieldStorage, cluster);
    private static SqlOperator udf(String name, SqlReturnTypeInference ret, SqlOperandTypeChecker operands) {
            validateFirstArgIfStringLiteral(original, DatetimeLiteralValidator.Kind.TIMESTAMP);
                RexBuilder rexBuilder = cluster.getRexBuilder();
            int n;
    }  
        while (fmtMatcher.find() && valMatcher.find()) {  
    }  
        @Override
     */
import org.apache.calcite.rex.RexBuilder;  
        }  
            return rexBuilder.makeCall(original.getType(), LOCAL_OS_YEARWEEK_OP, coerced);
    /** PPL FROM_UNIXTIME(epoch [, format]); 2-arg → date_format(from_unixtime(epoch), format). */  
    }
    }  
     * .getQueryStartClock()} snapshot semantics so date-parts on TIME values yield the current date
    /** PPL str_to_date returns NULL on parse failure; invalid month/day values still need to error rather than silent-null. */
        ReturnTypes.TIME_NULLABLE,  
            RelDataType nonNullVarchar = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);  
            RexNode epoch = NumericToDoubleAdapter.widenToDoubleIfNumeric(original.getOperands().get(0), cluster);  
     * {@link DatePartAdapters#coerceCharacterOperandToTimestamp} helper (handling character/TIME forms  
                hi,
                throw outOfRange("month", n, 1, 12, value, format);  
                lo,  
import org.opensearch.analytics.spi.FieldStorageInfo;
            RelDataType tsType = rexBuilder.getTypeFactory()
    }
        }
    }
        if (original.getOperands().size() != 2) {
            // coercion path so isthmus binds the precision_timestamp<P> arm — same workaround
                .createTypeWithNullability(
            String token = fmtMatcher.group();
        OperandTypes.family(SqlTypeFamily.ANY, SqlTypeFamily.ANY, SqlTypeFamily.ANY)
        String value = valueLit.getValueAs(String.class);
    static final SqlOperator LOCAL_STR_TO_DATE_OP = udf("str_to_date", ReturnTypes.TIMESTAMP_NULLABLE, OperandTypes.ANY_ANY);  
            validateFirstArgIfStringLiteral(original, DatetimeLiteralValidator.Kind.TIMESTAMP);
        if (original.getOperands().isEmpty()) {
         */  
            }
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
import org.apache.calcite.plan.RelOptCluster;
        }
        FromUnixtimeAdapter() {
/*  
    /**  
     * substrait resolver rejects VARCHAR for the YAML date/timestamp impls.
     * the same way {@code WEEKDAY}/{@code os_week} do) so it binds the yaml {@code precision_timestamp<P>}
    static final class TimeFormatAdapter extends AbstractNameMappingAdapter {  
         * TIME→VARCHAR.
            return;  
    // DAYNAME(x) → date_format(x, '%W'). %W renders full weekday name (e.g. "Monday")  
        }  
                );
            RexNode rewrittenValue = needsDateContext(unit) ? prependTodayLiteral(rexBuilder, varcharType, timeAsVarchar) : timeAsVarchar;
            "DAY_MINUTE",
        String format = fmtLit.getValueAs(String.class);  
 *  
        private static boolean needsDateContext(RexNode unit) {
    static final class MaketimeAdapter extends NumericToDoubleAdapter {  
    private static void rejectOutOfRangeMonthOrDay(RexCall original) {  
import org.apache.calcite.sql.type.SqlReturnTypeInference;  
        private static RexNode prependTodayLiteral(RexBuilder rexBuilder, RelDataType varcharType, RexNode timeAsVarchar) {
    // via mysql_format::weekday_full — matches legacy PPL DAYNAME semantics.
        }
            return;  
    private static final java.util.regex.Pattern VALUE_NUMBER = java.util.regex.Pattern.compile("\\d+");  
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
            super(LOCAL_TIME_FORMAT_OP, List.of(), List.of());
            }
            }
        @Override
                coerced.add(originalOperands.get(i));  
                return rexBuilder.makeCall(original.getType(), LOCAL_TIME_FORMAT_OP, coerced);
        }  
                coerced.add(original.getOperands().get(i));  
    /** WEEK(date [, mode]) target — MySQL semantics, accepts 1- and 2-arg forms. */
        }  
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        }  
 *
                format  
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
                    rexBuilder.getTypeFactory().createSqlType(SqlTypeName.TIMESTAMP),  
    static final class OsWeekAdapter extends AbstractNameMappingAdapter {  
import org.opensearch.analytics.spi.NumericToDoubleAdapter;
            if (original.getOperands().isEmpty()) {
        }
            for (int i = 1; i < originalOperands.size(); i++) {
    static final class MonthnameAdapter extends AbstractNameMappingAdapter {  
                return super.adapt(original, fieldStorage, cluster);  
    private static void validateFirstArgIfStringLiteral(RexCall original, DatetimeLiteralValidator.Kind kind) {  
    static final class DaynameAdapter extends AbstractNameMappingAdapter {
        @Override
 * Substrait sigs live in {@code opensearch_scalar_functions.yaml} +
import java.util.List;  
 */
        }  
            super(LOCAL_MAKEDATE_OP);
import org.apache.calcite.rel.type.RelDataType;
            RexNode ts = rexBuilder.makeCall(tsType, LOCAL_FROM_UNIXTIME_OP, List.of(epoch));
                List<RexNode> coerced = new java.util.ArrayList<>(original.getOperands().size());  
        DaynameAdapter() {  
import org.apache.calcite.rex.RexCall;
import org.apache.calcite.sql.type.ReturnTypes;
        }  
            }
import org.apache.calcite.sql.type.SqlTypeName;
        }  
        }  
            List<RexNode> coerced = new java.util.ArrayList<>(originalOperands.size());  
 * names a Calcite {@link SqlFunction} matching a UDF in {@code rust/src/udf/mod.rs};  
        OsWeekAdapter() {
            RexBuilder rexBuilder = cluster.getRexBuilder();
        DatetimeLiteralValidator.validate(firstArg, kind);
    static final SqlOperator LOCAL_EXTRACT_OP = udf("opensearch_extract", ReturnTypes.BIGINT_NULLABLE, OperandTypes.ANY_ANY);
    static final SqlOperator LOCAL_DATE_FORMAT_OP = udf("date_format", ReturnTypes.VARCHAR_NULLABLE, OperandTypes.ANY_ANY);
                n = Integer.parseInt(valMatcher.group());
            return super.adapt(original, fieldStorage, cluster);
 * Adapters for PPL datetime functions routed to Rust UDFs. Each {@code LOCAL_*_OP}
import org.opensearch.analytics.spi.AbstractNameMappingAdapter;  
            return super.adapt(original, fieldStorage, cluster);
        /** Units that need a date context; pure time-parts (HOUR/MINUTE/...) are absent. */
    }
            || !(original.getOperands().get(1) instanceof RexLiteral fmtLit)) {
    }  
    );
            coerced.add(DatePartAdapters.coerceCharacterOperandToTimestamp(original.getOperands().get(0), cluster));
            RexNode format = original.getOperands().get(1);
        MakedateAdapter() {
 */  
            super(LOCAL_DATE_FORMAT_OP, List.of(), List.of());
            String.format(
            RexNode timeAsVarchar = rexBuilder.makeCast(varcharType, value);
        }
    }
            // signature (substrait-java 0.89.1 lacks ToTypeString for PrecisionTime, so the yaml  
     * <p>When the unit is a known date-part (YEAR/MONTH/DAY/...), the value is anchored to today's  
            if (!original.getOperands().isEmpty() && original.getOperands().get(0).getType().getSqlTypeName() == SqlTypeName.TIME) {
            return super.adapt(original, fieldStorage, cluster);
        @Override
            "WEEK",
     * signature; an optional {@code mode} operand passes through unchanged.
                throw outOfRange("day", n, 1, 31, value, format);  
import org.apache.calcite.rex.RexNode;  
            super(LOCAL_STR_TO_DATE_OP, List.of(), List.of());
            if (original.getOperands().size() != 2) {
    // MONTHNAME(x) → date_format(x, '%M'). %M renders full month name (e.g. "September").
            // Calcite-stock TIME serialises to substrait precision_time<P>, which has no yaml
import org.apache.calcite.sql.SqlFunctionCategory;
    static final SqlOperator LOCAL_MAKETIME_OP = udf(
    static final class MakedateAdapter extends NumericToDoubleAdapter {  
                for (int i = 1; i < original.getOperands().size(); i++) {
        @Override
            return (RexCall) rexBuilder.makeCall(original.getType(), original.getOperator(), List.of(unit, rewrittenValue));  
            return call.getOperands().size() == 2 && call.getOperands().get(1).getType().getSqlTypeName() == SqlTypeName.TIME;
        ExtractAdapter() {  
