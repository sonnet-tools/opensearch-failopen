        /** Plan-time fold of DATETIME(value-literal, tz-literal). Returns a typed TIMESTAMP literal or NULL on invalid input. */
            RexBuilder rexBuilder = cluster.getRexBuilder();  
            if (literal.getType().equals(original.getType())) {  
            try {
                RexNode replacement = rexBuilder.makeLiteral("");
        "current_date",
                RexNode replacement = rexBuilder.makeLiteral("");  
                targetTz = tz;
    );
import org.apache.calcite.plan.RelOptCluster;
        @Override
                }
            RexNode asTimestamp = rexBuilder.makeCall(original.getType(), LOCAL_TO_TIMESTAMP_OP, List.of(strippedValue));
        SqlFunctionCategory.TIMEDATE  
            RexCall niladic = (RexCall) cluster.getRexBuilder().makeCall(original.getType(), original.getOperator(), List.of());  
                return rexBuilder.makeNullLiteral(original.getType());  
            }
                RexNode arg = operands.get(0);  
        }
            }
        OperandTypes.family(org.apache.calcite.sql.type.SqlTypeFamily.CHARACTER, org.apache.calcite.sql.type.SqlTypeFamily.TIMESTAMP),  
        OperandTypes.ANY,
    );
                    arg.getType(),
            RexNode value = original.getOperands().get(0);
            java.util.regex.Matcher m = OFFSET_SUFFIX_REGEX.matcher(value);
 */
    }
        }  
        SqlFunctionCategory.TIMEDATE  
            java.time.ZonedDateTime targetZoned;  
        CurrentTimeAdapter() {  
            }
                ts = ts.withNanos(nanos);
            }  
                result.getYear(),
import org.apache.calcite.sql.SqlOperator;
            if (value == null) {
            String sourceTz;
        ReturnTypes.ARG1_NULLABLE,
package org.opensearch.be.datafusion;
            RexBuilder rexBuilder = cluster.getRexBuilder();
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
                return null;  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
            String canonicalTo;
                    List.of(arg, pattern, replacement)
            RexNode literal = rexBuilder.makeTimestampLiteral(ts, precision);
    /**
            // Column input with no embedded TZ in the value: tz arg is the SOURCE zone (MySQL
                RexNode pattern = rexBuilder.makeLiteral(OFFSET_SUFFIX_PATTERN);  
                    value.getType(),  
            } else {
            // first valid offset at canonicalFrom — DST gap is treated as NULL
    /** PPL {@code now()} / {@code sysdate([fsp])}: drop FSP arg — DataFusion {@code now()} is niladic. */
            if (operands.size() == 1 && SqlTypeName.CHAR_TYPES.contains(operands.get(0).getType().getSqlTypeName())) {
                && SqlTypeName.CHAR_TYPES.contains(valLit.getType().getSqlTypeName())
            // semantics — value is interpreted AT the given tz, then expressed in UTC). The legacy
                    SqlLibraryOperators.REGEXP_REPLACE_3,  
            return rexBuilder.makeAbstractCast(original.getType(), literal);  
            if (value instanceof org.apache.calcite.rex.RexLiteral valLit  
                java.time.ZoneId toZone = java.time.ZoneId.of(canonicalTo);  
                RexNode arg = operands.get(0);
            if (m.find()) {  
 *
        OperandTypes.ANY,
            } catch (java.time.DateTimeException e) {  
                LocalDateTime.parse(stripped.replace(' ', 'T'));
final class DateTimeAdapters {
            if (SqlTypeName.CHAR_TYPES.contains(value.getType().getSqlTypeName())) {
 *
            RexNode tzArgVarchar = SqlTypeName.CHAR_TYPES.contains(tzArg.getType().getSqlTypeName())
                result.getDayOfMonth(),
            // precision_time<P>, which has no to_timestamp yaml binding. Anchor to a TIMESTAMP
 * registered in {@link DataFusionFragmentConvertor#ADDITIONAL_SCALAR_SIGS}.
                return rexBuilder.makeNullLiteral(original.getType());  
            if (original.getOperands().size() == 1) {  
        null,
                ldt = java.time.LocalDateTime.parse(stripped.replace(' ', 'T'));
        "to_date",
import org.apache.calcite.rex.RexCall;
        @Override
    static final class CurrentTimeAdapter extends AbstractNameMappingAdapter {
            List<RexNode> operands = original.getOperands();
import org.apache.calcite.sql.SqlFunctionCategory;
        }  
                }
        null,
        /** MySQL DATETIME tz bound [-13:59, +14:00] in seconds = [-50340, +50400]. */  
            if (value == null || tz == null) {
    static final SqlOperator LOCAL_TIME_OP = new SqlFunction(  
    static final class DateAdapter implements ScalarFunctionAdapter {  
            RexNode strippedValue;
            if (!(operand instanceof RexLiteral literal)) {
            super(LOCAL_NOW_OP, List.of(), List.of());
            } catch (DateTimeParseException ignored) {  
        "to_time",
                    List.of(value, pattern, replacement)
            // 2-arg DATETIME(s, tz); guard the name so TIMESTAMP(ts, time) fall-through stays 1-arg
            String stripped = value;
            if (operands.size() == 1 && SqlTypeName.CHAR_TYPES.contains(operands.get(0).getType().getSqlTypeName())) {  
    );
        }
                    arg.getType(),  
        null,
        null,
        null,
            }
            try {  
        null,
 * Adapters for PPL datetime functions that map 1:1 to a DataFusion builtin; signatures  
                && tzArg instanceof org.apache.calcite.rex.RexLiteral tzLit
                result.getHour(),
import java.time.format.DateTimeParseException;
                return totalSeconds >= -50340 && totalSeconds <= 50400;
            if (original.getOperands().isEmpty()) {  
            if (operands.size() == 1 && operands.get(0).getType().getSqlTypeName() == SqlTypeName.TIME) {
            int precision = original.getType().getPrecision() < 0 ? 6 : Math.min(original.getType().getPrecision(), 9);
            RexBuilder rexBuilder = cluster.getRexBuilder();  
            String targetTz;  
            } else {
                if (SqlTypeName.CHAR_TYPES.contains(operand.getType().getSqlTypeName())) {
     * 2-arg DATETIME(string, tz): extract source offset (default UTC), route through convert_tz.  
            return rexBuilder.makeCall(original.getType(), LOCAL_TIME_OP, operands);
                RexNode foldedNull = tryFoldInvalidLiteralToNull(arg, original, cluster);
    static final class TimeAdapter implements ScalarFunctionAdapter {  
        }
                    return rexBuilder.makeNullLiteral(original.getType());  
        SqlKind.OTHER_FUNCTION,
            java.time.LocalDateTime ldt;
        OperandTypes.ANY,
        private static final String OFFSET_SUFFIX_PATTERN = "([+-][0-9]{2}:?[0-9]{2}|Z)$";
}
        private RexNode adaptTwoArg(RexCall original, RelOptCluster cluster) {  
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
            org.apache.calcite.util.TimestampString ts = new org.apache.calcite.util.TimestampString(
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
    static final SqlOperator LOCAL_DATE_TRUNC_OP = new SqlFunction(
    static final class NowAdapter extends AbstractNameMappingAdapter {
        /** 2-arg DATETIME(s, tz): all-literal -> typed TIMESTAMP (or NULL); else rewrite to convert_tz. */
import java.util.List;  
    static final SqlOperator LOCAL_CURRENT_TIME_OP = new SqlFunction(  
                }
            }
            String stripped = value.replaceAll(OFFSET_SUFFIX_PATTERN, "");
                RexNode replacement = rexBuilder.makeLiteral("");
/**
            try {
import org.apache.calcite.sql.type.ReturnTypes;
    static final SqlOperator LOCAL_CURRENT_DATE_OP = new SqlFunction(  
                ? rexBuilder.makeCast(varchar, tzArg, true)
        SqlFunctionCategory.TIMEDATE  
            // convert_tz yaml binds tz operands as unbounded `string`; cast both away from CHAR(N).
        ReturnTypes.DATE_NULLABLE,  
        private static RexNode foldTwoArgLiteral(String value, String tz, RexCall original, RelOptCluster cluster) {  
            RelDataType varchar = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);  
            return cluster.getRexBuilder().makeCall(original.getType(), LOCAL_DATE_OP, original.getOperands());  
            RexBuilder rexBuilder = cluster.getRexBuilder();
            // literal/literal → typed TIMESTAMP literal (or NULL)
            }
                return null;
                sourceTz = "Z".equals(m.group()) ? "+00:00" : m.group();
            // 1-arg DATETIME with a TIME operand — Calcite emits stock TIME as substrait  
                strippedValue = rexBuilder.makeCall(
 * SPDX-License-Identifier: Apache-2.0
            }
                RexNode anchored = DatePartAdapters.coerceCharacterOperandToTimestamp(operands.get(0), cluster);
        }  
        SqlKind.OTHER_FUNCTION,  
            String canonicalFrom;  
                result.getSecond()
        SqlFunctionCategory.TIMEDATE  
                RexNode stripped = rexBuilder.makeCall(
            // arg is the SOURCE (value is interpreted AT that tz) and the target is UTC.
            }
            RexNode toTz = rexBuilder.makeLiteral("+00:00", varchar, true);
    );
    /** PPL {@code TIME(string)} accepts a datetime-string; strip the date prefix so {@code to_time} parses. */
import org.opensearch.analytics.spi.FieldStorageInfo;
                );
                strippedValue = value;
        }
        SqlFunctionCategory.TIMEDATE
        @Override
            }  
        SqlKind.OTHER_FUNCTION,
                RexNode operand = original.getOperands().get(0);
                return adaptTwoArg(original, cluster);
        private static final java.util.regex.Pattern OFFSET_SUFFIX_REGEX = java.util.regex.Pattern.compile(OFFSET_SUFFIX_PATTERN);
                return null;
                : tzArg;  
            );
                if (foldedNull != null) {  
                return false;
                canonicalTo = ConvertTzAdapter.canonicalizeTz(targetTz);
            if (!isWithinMysqlDatetimeTzBounds(canonicalFrom) || !isWithinMysqlDatetimeTzBounds(canonicalTo)) {
            String value = literal.getValueAs(String.class);
        SqlKind.OTHER_FUNCTION,
            }  
            // SQL plugin path treated tz as target, which inverted the offset direction.  
            // canonicalize tzs (invalid → NULL); enforce MySQL DATETIME bound [-13:59, +14:00]
                return foldTwoArgLiteral(valLit.getValueAs(String.class), tzLit.getValueAs(String.class), original, cluster);
                );  
            java.time.LocalDateTime result = targetZoned.toLocalDateTime();  
        "now",
                    SqlLibraryOperators.REGEXP_REPLACE_3,
        private static final String DATE_PREFIX_PATTERN = "^[0-9]{4}-[0-9]{2}-[0-9]{2}[T ]";
        private static RexNode tryFoldInvalidLiteralToNull(RexNode operand, RexCall original, RelOptCluster cluster) {  
    static final SqlOperator LOCAL_TO_TIMESTAMP_OP = new SqlFunction(  
                return super.adapt(original, fieldStorage, cluster);
        null,
        "to_timestamp",
            // and the user's tz arg is the target. When value has NO embedded offset, the user's tz  
        }  
            }
            // Same workaround TimeFormatAdapter / DatePartAdapters use.  
                return rexBuilder.makeNullLiteral(original.getType());  
        OperandTypes.NILADIC,
    static final SqlOperator LOCAL_DATE_OP = new SqlFunction(  
                targetZoned = java.time.ZonedDateTime.ofInstant(ldt.toInstant(validOffsets.get(0)), toZone);
                return rexBuilder.makeCall(original.getType(), LOCAL_TO_TIMESTAMP_OP, List.of(anchored));  
        }  
                result.getMonthValue(),  
                return rexBuilder.makeCall(original.getType(), LOCAL_TIME_OP, List.of(stripped));  
            }
            List<RexNode> operands = original.getOperands();
                RexNode pattern = rexBuilder.makeLiteral(OFFSET_SUFFIX_PATTERN);  
                    SqlLibraryOperators.REGEXP_REPLACE_3,
import org.apache.calcite.sql.type.OperandTypes;  
                );  
        SqlKind.OTHER_FUNCTION,
                java.util.List<java.time.ZoneOffset> validOffsets = fromZone.getRules().getValidOffsets(ldt);
        ReturnTypes.TIME,  
        ReturnTypes.TIME_NULLABLE,  
        /** Non-full-datetime string literal -> NULL TIMESTAMP. */
        ReturnTypes.DATE,  
 * compatible open source license.
import org.apache.calcite.rex.RexBuilder;  
            }
 * @opensearch.internal  
import org.opensearch.analytics.spi.AbstractNameMappingAdapter;  
                targetTz = "+00:00";  
/*  
            try {  
        ReturnTypes.TIMESTAMP,  
import java.time.LocalDateTime;
import org.apache.calcite.sql.fun.SqlLibraryOperators;
    );
    }  
            }
            } catch (IllegalArgumentException invalidTz) {
                    return foldedNull;
                int totalSeconds = zone.getRules().getOffset(java.time.Instant.now()).getTotalSeconds();
        OperandTypes.NILADIC,
        }
                canonicalFrom = ConvertTzAdapter.canonicalizeTz(sourceTz);  
        SqlFunctionCategory.TIMEDATE  
            int nanos = result.getNano();  
            return rexBuilder.makeCall(original.getType(), LOCAL_TO_TIMESTAMP_OP, operands);
import org.apache.calcite.sql.SqlFunction;
            return rexBuilder.makeCall(original.getType(), ConvertTzAdapter.LOCAL_CONVERT_TZ_OP, List.of(asTimestamp, tzArgVarchar, toTz));
    }
                return rexBuilder.makeNullLiteral(original.getType());  
                if (validOffsets.isEmpty()) {
        @Override
    );
            }
    }
            if (operands.size() == 2 && "DATETIME".equalsIgnoreCase(original.getOperator().getName())) {  
            }
        OperandTypes.NILADIC,
                return cluster.getRexBuilder().makeNullLiteral(original.getType());
    static final class CurrentDateAdapter extends AbstractNameMappingAdapter {
        "current_time",
            }
            // MySQL DATETIME semantics: when value has an embedded offset, that's the source zone
            // first via the shared coercion path so isthmus binds the precision_timestamp<P> arm.
                java.time.ZoneId fromZone = java.time.ZoneId.of(canonicalFrom);
import org.apache.calcite.sql.SqlKind;  
 * this file be licensed under the Apache-2.0 license or a
            } catch (java.time.format.DateTimeParseException e) {
            }
    static final class DatetimeAdapter implements ScalarFunctionAdapter {
        "date_trunc",
    /** 2-arg {@code date_trunc(granularity, ts)}; engine folds with {@code now()} at its plan time. */  
        CurrentDateAdapter() {  
        SqlFunctionCategory.TIMEDATE  
    }  
                sourceTz = tz;
    private DateTimeAdapters() {}
                RexNode stripped = rexBuilder.makeCall(
                return rexBuilder.makeCall(original.getType(), LOCAL_TO_TIMESTAMP_OP, List.of(stripped));
            return super.adapt(niladic, fieldStorage, cluster);
import org.apache.calcite.rex.RexLiteral;
                result.getMinute(),  
 * The OpenSearch Contributors require contributions made to  
        NowAdapter() {  
            super(LOCAL_CURRENT_DATE_OP, List.of(), List.of());
            super(LOCAL_CURRENT_TIME_OP, List.of(), List.of());
                return rexBuilder.makeNullLiteral(original.getType());
                return literal;
        SqlKind.OTHER_FUNCTION,
            }
                java.time.ZoneId zone = java.time.ZoneId.of(canonical);  
    }  
    );
            if (nanos > 0) {
                stripped = value.substring(0, m.start());  
                RexNode pattern = rexBuilder.makeLiteral(DATE_PREFIX_PATTERN);
            } catch (java.time.DateTimeException invalid) {  
                DatetimeLiteralValidator.validate(arg, DatetimeLiteralValidator.Kind.TIME);
                    List.of(arg, pattern, replacement)
import org.apache.calcite.rel.type.RelDataType;
            RexNode tzArg = original.getOperands().get(1);  
import org.apache.calcite.rex.RexNode;  
        ReturnTypes.TIMESTAMP,  
        SqlKind.OTHER_FUNCTION,
        private static boolean isWithinMysqlDatetimeTzBounds(String canonical) {
    static final SqlOperator LOCAL_NOW_OP = new SqlFunction(  
     * 1-arg DATETIME(string): strip trailing offset, fold invalid literals to NULL.
                    DatetimeLiteralValidator.validate(operand, DatetimeLiteralValidator.Kind.DATE);  
import org.apache.calcite.sql.type.SqlTypeName;
            try {
                && SqlTypeName.CHAR_TYPES.contains(tzLit.getType().getSqlTypeName())) {  
        }
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
 */  
     */
