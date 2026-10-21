import org.apache.calcite.sql.type.OperandTypes;
            if (value == null) {
                ? rexBuilder.makeCast(varchar, tzArg, true)
/**
     * 2-arg DATETIME(string, tz): extract source offset (default UTC), route through convert_tz.
 * The OpenSearch Contributors require contributions made to
            }
                }
            // Same workaround TimeFormatAdapter / DatePartAdapters use.
 * Adapters for PPL datetime functions that map 1:1 to a DataFusion builtin; signatures
                return adaptTwoArg(original, cluster);
            // Column input with no embedded TZ in the value: tz arg is the SOURCE zone (MySQL
        SqlKind.OTHER_FUNCTION,
                }
                RexNode anchored = DatePartAdapters.coerceCharacterOperandToTimestamp(operands.get(0), cluster);
    }
        OperandTypes.NILADIC,
import org.opensearch.analytics.spi.FieldStorageInfo;
        "to_time",
            if (operands.size() == 2 && "DATETIME".equalsIgnoreCase(original.getOperator().getName())) {
            super(LOCAL_NOW_OP, List.of(), List.of());
    }
        OperandTypes.ANY,
            if (value instanceof org.apache.calcite.rex.RexLiteral valLit
                targetTz = "+00:00";
                RexNode pattern = rexBuilder.makeLiteral(DATE_PREFIX_PATTERN);
        null,
            String targetTz;
        }
        }
            }
            RexNode literal = rexBuilder.makeTimestampLiteral(ts, precision);
            if (SqlTypeName.CHAR_TYPES.contains(value.getType().getSqlTypeName())) {
            if (!(operand instanceof RexLiteral literal)) {
            String canonicalTo;
 *
            RexNode strippedValue;
        null,
            java.time.ZonedDateTime targetZoned;
                stripped = value.substring(0, m.start());
    }
                return literal;
        ReturnTypes.DATE,
        private static final String DATE_PREFIX_PATTERN = "^[0-9]{4}-[0-9]{2}-[0-9]{2}[T ]";
                return rexBuilder.makeNullLiteral(original.getType());
            List<RexNode> operands = original.getOperands();
                DatetimeLiteralValidator.validate(arg, DatetimeLiteralValidator.Kind.TIME);
        SqlFunctionCategory.TIMEDATE
        CurrentTimeAdapter() {
            RexBuilder rexBuilder = cluster.getRexBuilder();
                canonicalTo = ConvertTzAdapter.canonicalizeTz(targetTz);
            // MySQL DATETIME semantics: when value has an embedded offset, that's the source zone
            String stripped = value;
                RexNode replacement = rexBuilder.makeLiteral("");
        /** Non-full-datetime string literal -> NULL TIMESTAMP. */
            RexBuilder rexBuilder = cluster.getRexBuilder();
            RexNode asTimestamp = rexBuilder.makeCall(original.getType(), LOCAL_TO_TIMESTAMP_OP, List.of(strippedValue));
        /** MySQL DATETIME tz bound [-13:59, +14:00] in seconds = [-50340, +50400]. */
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
}
                return rexBuilder.makeCall(original.getType(), LOCAL_TIME_OP, List.of(stripped));
            try {
    static final SqlOperator LOCAL_TO_TIMESTAMP_OP = new SqlFunction(
    /** PPL {@code TIME(string)} accepts a datetime-string; strip the date prefix so {@code to_time} parses. */
                LocalDateTime.parse(stripped.replace(' ', 'T'));
                targetTz = tz;
                RexNode foldedNull = tryFoldInvalidLiteralToNull(arg, original, cluster);
        OperandTypes.ANY,
            // literal/literal → typed TIMESTAMP literal (or NULL)
        SqlFunctionCategory.TIMEDATE
    static final SqlOperator LOCAL_CURRENT_TIME_OP = new SqlFunction(
        /** Plan-time fold of DATETIME(value-literal, tz-literal). Returns a typed TIMESTAMP literal or NULL on invalid input. */
    );
            List<RexNode> operands = original.getOperands();
            }
            );
            // canonicalize tzs (invalid → NULL); enforce MySQL DATETIME bound [-13:59, +14:00]
            }
        }
import org.apache.calcite.sql.type.ReturnTypes;
            java.time.LocalDateTime result = targetZoned.toLocalDateTime();
                    SqlLibraryOperators.REGEXP_REPLACE_3,
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.rex.RexBuilder;
                    DatetimeLiteralValidator.validate(operand, DatetimeLiteralValidator.Kind.DATE);
        @Override
                RexNode operand = original.getOperands().get(0);
    /** PPL {@code now()} / {@code sysdate([fsp])}: drop FSP arg — DataFusion {@code now()} is niladic. */
            RexNode tzArgVarchar = SqlTypeName.CHAR_TYPES.contains(tzArg.getType().getSqlTypeName())
    static final class CurrentTimeAdapter extends AbstractNameMappingAdapter {
            // convert_tz yaml binds tz operands as unbounded `string`; cast both away from CHAR(N).
            }
                result.getMinute(),
        @Override
                result.getMonthValue(),
    );
                );
            try {
 * SPDX-License-Identifier: Apache-2.0
            return rexBuilder.makeCall(original.getType(), LOCAL_TIME_OP, operands);
import org.apache.calcite.sql.SqlKind;
                result.getHour(),
                result.getYear(),
                RexNode stripped = rexBuilder.makeCall(
                result.getSecond()
            if (original.getOperands().size() == 1) {
                return rexBuilder.makeCall(original.getType(), LOCAL_TO_TIMESTAMP_OP, List.of(stripped));
                if (foldedNull != null) {
        }
            // 2-arg DATETIME(s, tz); guard the name so TIMESTAMP(ts, time) fall-through stays 1-arg
            RelDataType varchar = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
            // first via the shared coercion path so isthmus binds the precision_timestamp<P> arm.
    static final class DatetimeAdapter implements ScalarFunctionAdapter {
            if (operands.size() == 1 && operands.get(0).getType().getSqlTypeName() == SqlTypeName.TIME) {
            super(LOCAL_CURRENT_DATE_OP, List.of(), List.of());
        SqlFunctionCategory.TIMEDATE
    static final SqlOperator LOCAL_DATE_OP = new SqlFunction(
                targetZoned = java.time.ZonedDateTime.ofInstant(ldt.toInstant(validOffsets.get(0)), toZone);
            RexNode toTz = rexBuilder.makeLiteral("+00:00", varchar, true);
import org.apache.calcite.sql.type.SqlTypeName;
                );
            try {
        SqlFunctionCategory.TIMEDATE
            if (literal.getType().equals(original.getType())) {
            // arg is the SOURCE (value is interpreted AT that tz) and the target is UTC.
            }
                java.time.ZoneId toZone = java.time.ZoneId.of(canonicalTo);
            }
    static final SqlOperator LOCAL_NOW_OP = new SqlFunction(
            }
        null,
import org.apache.calcite.sql.fun.SqlLibraryOperators;
        "to_timestamp",
        OperandTypes.NILADIC,
        }
    static final class TimeAdapter implements ScalarFunctionAdapter {
        }
        SqlKind.OTHER_FUNCTION,
            } else {
        private static final java.util.regex.Pattern OFFSET_SUFFIX_REGEX = java.util.regex.Pattern.compile(OFFSET_SUFFIX_PATTERN);
            return rexBuilder.makeCall(original.getType(), ConvertTzAdapter.LOCAL_CONVERT_TZ_OP, List.of(asTimestamp, tzArgVarchar, toTz));
            if (m.find()) {
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        }
                RexNode arg = operands.get(0);
    );
        "now",
import org.apache.calcite.rel.type.RelDataType;
 * compatible open source license.
            if (nanos > 0) {
        ReturnTypes.TIME,
        null,
        OperandTypes.ANY,
                    List.of(value, pattern, replacement)
                );
            java.time.LocalDateTime ldt;
                return null;
        "to_date",
                sourceTz = tz;
                ldt = java.time.LocalDateTime.parse(stripped.replace(' ', 'T'));
        /** 2-arg DATETIME(s, tz): all-literal -> typed TIMESTAMP (or NULL); else rewrite to convert_tz. */
            } catch (java.time.format.DateTimeParseException e) {
            if (original.getOperands().isEmpty()) {
                RexNode arg = operands.get(0);
        SqlFunctionCategory.TIMEDATE
        "date_trunc",
            }
    );
                    SqlLibraryOperators.REGEXP_REPLACE_3,
            }
                return foldTwoArgLiteral(valLit.getValueAs(String.class), tzLit.getValueAs(String.class), original, cluster);
                return false;
                return totalSeconds >= -50340 && totalSeconds <= 50400;
                && SqlTypeName.CHAR_TYPES.contains(tzLit.getType().getSqlTypeName())) {
        null,
        SqlKind.OTHER_FUNCTION,
                RexNode pattern = rexBuilder.makeLiteral(OFFSET_SUFFIX_PATTERN);
    );
            }
import java.time.LocalDateTime;
        null,
                java.time.ZoneId zone = java.time.ZoneId.of(canonical);
import org.apache.calcite.plan.RelOptCluster;
            if (value == null || tz == null) {
        }
        }
        ReturnTypes.TIME_NULLABLE,
                && SqlTypeName.CHAR_TYPES.contains(valLit.getType().getSqlTypeName())
            if (operands.size() == 1 && SqlTypeName.CHAR_TYPES.contains(operands.get(0).getType().getSqlTypeName())) {
                    return rexBuilder.makeNullLiteral(original.getType());
import org.apache.calcite.rex.RexLiteral;
        private static RexNode foldTwoArgLiteral(String value, String tz, RexCall original, RelOptCluster cluster) {
    static final class NowAdapter extends AbstractNameMappingAdapter {
                }
    );
        @Override
import org.apache.calcite.sql.SqlOperator;
            String stripped = value.replaceAll(OFFSET_SUFFIX_PATTERN, "");
    }
            // and the user's tz arg is the target. When value has NO embedded offset, the user's tz
            }
    static final SqlOperator LOCAL_DATE_TRUNC_OP = new SqlFunction(
import java.time.format.DateTimeParseException;
                strippedValue = rexBuilder.makeCall(
            } catch (java.time.DateTimeException e) {
        @Override
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        private static boolean isWithinMysqlDatetimeTzBounds(String canonical) {
final class DateTimeAdapters {
            }
            }
            // semantics — value is interpreted AT the given tz, then expressed in UTC). The legacy
            } else {
                    SqlLibraryOperators.REGEXP_REPLACE_3,
            }
    /**
        SqlFunctionCategory.TIMEDATE
        ReturnTypes.ARG1_NULLABLE,
        SqlKind.OTHER_FUNCTION,
package org.opensearch.be.datafusion;
                RexNode pattern = rexBuilder.makeLiteral(OFFSET_SUFFIX_PATTERN);
                    return foldedNull;
        CurrentDateAdapter() {
            return rexBuilder.makeCall(original.getType(), LOCAL_TO_TIMESTAMP_OP, operands);
        ReturnTypes.TIMESTAMP,
    static final class CurrentDateAdapter extends AbstractNameMappingAdapter {
 *
        ReturnTypes.DATE_NULLABLE,
            super(LOCAL_CURRENT_TIME_OP, List.of(), List.of());
            RexNode tzArg = original.getOperands().get(1);
        SqlFunctionCategory.TIMEDATE
    }
                    arg.getType(),
import org.apache.calcite.sql.SqlFunction;
                int totalSeconds = zone.getRules().getOffset(java.time.Instant.now()).getTotalSeconds();
            org.apache.calcite.util.TimestampString ts = new org.apache.calcite.util.TimestampString(
                    List.of(arg, pattern, replacement)
        OperandTypes.NILADIC,
            }
                    arg.getType(),
        }
        SqlKind.OTHER_FUNCTION,
                canonicalFrom = ConvertTzAdapter.canonicalizeTz(sourceTz);
                return rexBuilder.makeNullLiteral(original.getType());
            return cluster.getRexBuilder().makeCall(original.getType(), LOCAL_DATE_OP, original.getOperands());
 */
        null,
                return rexBuilder.makeCall(original.getType(), LOCAL_TO_TIMESTAMP_OP, List.of(anchored));
    /** 2-arg {@code date_trunc(granularity, ts)}; engine folds with {@code now()} at its plan time. */
                    List.of(arg, pattern, replacement)
        }
            } catch (java.time.DateTimeException invalid) {
        SqlKind.OTHER_FUNCTION,
                && tzArg instanceof org.apache.calcite.rex.RexLiteral tzLit
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
    }
        NowAdapter() {
                java.util.List<java.time.ZoneOffset> validOffsets = fromZone.getRules().getValidOffsets(ldt);
            } catch (DateTimeParseException ignored) {
            java.util.regex.Matcher m = OFFSET_SUFFIX_REGEX.matcher(value);
 * registered in {@link DataFusionFragmentConvertor#ADDITIONAL_SCALAR_SIGS}.
            try {
import org.apache.calcite.sql.SqlFunctionCategory;
            // precision_time<P>, which has no to_timestamp yaml binding. Anchor to a TIMESTAMP
        OperandTypes.family(org.apache.calcite.sql.type.SqlTypeFamily.CHARACTER, org.apache.calcite.sql.type.SqlTypeFamily.TIMESTAMP),
                result.getDayOfMonth(),
                if (SqlTypeName.CHAR_TYPES.contains(operand.getType().getSqlTypeName())) {
            String canonicalFrom;
    static final SqlOperator LOCAL_TIME_OP = new SqlFunction(
    );
                sourceTz = "Z".equals(m.group()) ? "+00:00" : m.group();
                return rexBuilder.makeNullLiteral(original.getType());
     * 1-arg DATETIME(string): strip trailing offset, fold invalid literals to NULL.
                return null;
/*
    static final class DateAdapter implements ScalarFunctionAdapter {
                return super.adapt(original, fieldStorage, cluster);
                return rexBuilder.makeNullLiteral(original.getType());
    static final SqlOperator LOCAL_CURRENT_DATE_OP = new SqlFunction(
                : tzArg;
    private DateTimeAdapters() {}
            if (operands.size() == 1 && SqlTypeName.CHAR_TYPES.contains(operands.get(0).getType().getSqlTypeName())) {
        private static final String OFFSET_SUFFIX_PATTERN = "([+-][0-9]{2}:?[0-9]{2}|Z)$";
import org.opensearch.analytics.spi.AbstractNameMappingAdapter;
            // 1-arg DATETIME with a TIME operand — Calcite emits stock TIME as substrait
            RexBuilder rexBuilder = cluster.getRexBuilder();
                java.time.ZoneId fromZone = java.time.ZoneId.of(canonicalFrom);
                return null;
        private static RexNode tryFoldInvalidLiteralToNull(RexNode operand, RexCall original, RelOptCluster cluster) {
            // first valid offset at canonicalFrom — DST gap is treated as NULL
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
        private RexNode adaptTwoArg(RexCall original, RelOptCluster cluster) {
            return rexBuilder.makeAbstractCast(original.getType(), literal);
            } catch (IllegalArgumentException invalidTz) {
            RexBuilder rexBuilder = cluster.getRexBuilder();
            }
            return super.adapt(niladic, fieldStorage, cluster);
 */
            }
            String sourceTz;
                strippedValue = value;
            try {
                return cluster.getRexBuilder().makeNullLiteral(original.getType());
 * this file be licensed under the Apache-2.0 license or a
        SqlKind.OTHER_FUNCTION,
                return rexBuilder.makeNullLiteral(original.getType());
            }
            RexNode value = original.getOperands().get(0);
                RexNode stripped = rexBuilder.makeCall(
        "current_date",
     */
import java.util.List;
 * @opensearch.internal
                if (validOffsets.isEmpty()) {
            int precision = original.getType().getPrecision() < 0 ? 6 : Math.min(original.getType().getPrecision(), 9);
            }
import org.apache.calcite.rex.RexCall;
                ts = ts.withNanos(nanos);
                RexNode replacement = rexBuilder.makeLiteral("");
            String value = literal.getValueAs(String.class);
        "current_time",
                    value.getType(),
                RexNode replacement = rexBuilder.makeLiteral("");
            if (!isWithinMysqlDatetimeTzBounds(canonicalFrom) || !isWithinMysqlDatetimeTzBounds(canonicalTo)) {
            int nanos = result.getNano();
        ReturnTypes.TIMESTAMP,
            // SQL plugin path treated tz as target, which inverted the offset direction.
            RexCall niladic = (RexCall) cluster.getRexBuilder().makeCall(original.getType(), original.getOperator(), List.of());
