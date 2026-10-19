 * <p>Numeric span (unit = typed-NULL): {@code (field / interval) * interval} (FLOOR for non-integer).
                        return rexBuilder.makeCall(original.getType(), LOCAL_DATE_BIN_OP, List.of(stride, field, origin));
                    if (n != null) {
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
 * M/q/y → {@code date_bin("<N> <unit>", t, '1970-01-01T00:00:00Z')}.
        if (!(interval instanceof RexLiteral lit)) {
    private static RexNode rewriteNumericSpan(RexBuilder rexBuilder, RexNode field, RexNode interval, RelDataType resultType) {
        boolean integerResult = resultTypeName == SqlTypeName.INTEGER
    }
        }
            return null;
 * SPDX-License-Identifier: Apache-2.0
 */
            }
import org.apache.calcite.plan.RelOptCluster;
            || resultTypeName == SqlTypeName.SMALLINT
            }
        Object value = lit.getValue();
        }
        }
        null,
        OperandTypes.VARIADIC,
    }
        long n;
        if (original.getOperands().size() != 3) {
        } catch (ArithmeticException e) {
        if (value instanceof Number n) {
        }
        Map.entry("d", "day"),
        return rexBuilder.makeCast(resultType, asTimestamp, true);
        }
        }
            }
        Object value = lit.getValue();
            return null;
                        RexNode stride = rexBuilder.makeLiteral(n + " " + calendarStrideUnit);
            n = (long) num.doubleValue();
    static final SqlOperator LOCAL_DATE_BIN_OP = new SqlFunction(
            throw new IllegalArgumentException(
                if (calendarStrideUnit != null) {
import org.apache.calcite.sql.SqlKind;
        RexNode bucketIndex = rexBuilder.makeCall(SqlStdOperatorTable.DIVIDE, epochSeconds, bucketSizeLit);
import org.apache.calcite.sql.SqlFunctionCategory;
        Map.entry("s", "second"),
import org.apache.calcite.rex.RexNode;
            return original;
            return bd.compareTo(BigDecimal.ONE) == 0;
/*
import org.apache.calcite.sql.type.SqlTypeName;
        "date_bin",
            if (unitText != null) {
        Map.entry("us", "microsecond"),
                }
        }
import org.apache.calcite.sql.type.ReturnTypes;
 * Unit letters: us/ms/s/m/h/d/w/M/q/y → microsecond/millisecond/second/minute/hour/day/week/month/quarter/year.
            try {
import org.apache.calcite.sql.SqlOperator;
        Map.entry("s", 1L),
        RexNode epochSeconds = rexBuilder.makeCall(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, field);
                if (bucketSeconds != null && bucketSeconds > 0L) {
/**
import java.math.BigDecimal;
        RexNode bucket = integerResult ? quotient : rexBuilder.makeCall(SqlStdOperatorTable.FLOOR, quotient);
        Map.entry("y", "year")
import org.apache.calcite.rex.RexLiteral;
        RexNode bucketStart = rexBuilder.makeCall(SqlStdOperatorTable.MULTIPLY, bucketIndex, bucketSizeLit);
        // i64/i64 already truncates toward zero; FLOOR would force fp64 (substrait floor is fp-only)
class SpanAdapter implements ScalarFunctionAdapter {
        Map.entry("w", "week"),
                        RexNode stride = rexBuilder.makeLiteral(n + " " + dateBinStrideUnit);
        try {
        }
            return null;
    /** Single-letter PPL span unit → DataFusion {@code date_trunc} unit name. */
        } else {
        if (unitSeconds == null) {
import org.opensearch.analytics.spi.FieldStorageInfo;
                e
import java.util.Map;
                    RexNode unitArg = rexBuilder.makeLiteral(dateTruncUnit);
        }
        RexNode bucketStartDouble = rexBuilder.makeCast(fp64, bucketStart, true);
            return null;
import org.apache.calcite.sql.type.OperandTypes;
        Map.entry("w", 604800L)
                "SPAN interval is too large: " + n + " * " + unitSeconds + " seconds exceeds the long range",
        Map.entry("M", "month"),
 * Rewrites PPL {@code SPAN(field, interval, unit)} into a Substrait-friendly tree.
    }
                    Long n = extractPositiveInteger(interval);
 *
                if (dateBinStrideUnit != null) {
        if (unit.getType().getSqlTypeName() == SqlTypeName.NULL || (unit instanceof RexLiteral lit && lit.isNull())) {
    /** Fixed-length PPL span units → seconds (M/q/y excluded — calendar-dependent). */
            || resultTypeName == SqlTypeName.BIGINT
                    }
 */
        if (value instanceof BigDecimal bd) {
package org.opensearch.be.datafusion;
        RexNode interval = original.getOperands().get(1);
            return rewriteNumericSpan(rexBuilder, field, interval, original.getType());
        return n > 0 ? n : null;
                }
import java.util.List;
        SqlKind.OTHER_FUNCTION,
 * @opensearch.internal
    private static RexNode rewriteFixedLengthTimeBucket(RexBuilder rexBuilder, RexNode field, long bucketSeconds, RelDataType resultType) {
    }
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
        Map.entry("ms", "millisecond"),
            String unitText = lit.getValueAs(String.class);
    /** date_bin target — name matches DataFusion native; ARG1_NULLABLE return preserves the source timestamp type. */
        // from_unixtime sig is (fp64) → precision_timestamp<6>
                    }
        RexNode bucketSizeLit = rexBuilder.makeBigintLiteral(BigDecimal.valueOf(bucketSeconds));
                if (dateTruncUnit != null && isUnitInterval(interval)) {
        Map.entry("q", "quarter"),
            || resultTypeName == SqlTypeName.TINYINT;
import org.apache.calcite.sql.fun.SqlLibraryOperators;
            return Math.multiplyExact(n, unitSeconds);
                // calendar multi-unit (M/q/y): date_bin with month-aligned origin '1970-01-01T00:00:00Z'
        return rexBuilder.makeCast(resultType, product, true);
 * with N&gt;1 → integer-seconds arithmetic; sub-second us/ms → {@code date_bin("<N> <unit>", t)}; calendar
                }
                return null;
        Map.entry("h", 3600L),
 * Time span (unit = single letter): {@code interval == 1} → {@code DATE_TRUNC}; fixed-length s/m/h/d/w
                        return rexBuilder.makeCall(original.getType(), LOCAL_DATE_BIN_OP, List.of(stride, field));
                    return rewriteFixedLengthTimeBucket(rexBuilder, field, bucketSeconds, original.getType());
                String dateTruncUnit = UNIT_TO_DATE_TRUNC.get(unitText);
import org.apache.calcite.sql.SqlFunction;
 * this file be licensed under the Apache-2.0 license or a
                return null;
 *
import org.apache.calcite.rex.RexCall;
                // multi-unit fixed-length time span: bucket via integer seconds since epoch (B = N * unit_seconds)
        RexNode asTimestamp = rexBuilder.makeCall(RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP, bucketStartDouble);
        return original;
            return false;
    private static boolean isUnitInterval(RexNode interval) {
        Map.entry("d", 86400L),
            if (bd.stripTrailingZeros().scale() > 0) {
        RexNode product = rexBuilder.makeCall(SqlStdOperatorTable.MULTIPLY, bucket, interval);
        // Anything else falls through unchanged.
        Map.entry("h", "hour"),
    );
                Long unitSeconds = FIXED_UNIT_SECONDS.get(unitText);
        Long n = extractPositiveInteger(interval);
    );
    @Override
        return Double.isFinite(d) && d == Math.floor(d);
        RexNode unit = original.getOperands().get(2);
                    if (n != null) {
        if (unit instanceof RexLiteral lit && lit.getValue() != null) {
        }
            } catch (ArithmeticException e) {
        RexNode quotient = rexBuilder.makeCall(SqlStdOperatorTable.DIVIDE, field, interval);
    /** Calendar PPL units → date_bin stride suffix; bucketed against month-aligned epoch (1970-01-01). */
        // Numeric span: unit operand is typed-NULL.
            return n.doubleValue() == 1.0;
                    Long n = extractPositiveInteger(interval);
    private static Long extractPositiveInteger(RexNode interval) {
        RexNode field = original.getOperands().get(0);
        Map.entry("m", "minute"),
            }
    /** Positive whole-number Long from a numeric literal; null otherwise. */
    /** True when {@code d} is finite and integral. */
                Long bucketSeconds = bucketSecondsIfPositiveInteger(interval, unitSeconds);
        }
        ReturnTypes.ARG1_NULLABLE,
}
    private static final Map<String, String> UNIT_TO_DATE_TRUNC = Map.ofEntries(
    }
    }
        SqlTypeName resultTypeName = resultType.getSqlTypeName();
    private static final Map<String, String> CALENDAR_UNIT_TO_DATE_BIN_STRIDE = Map.of("M", "month", "q", "quarter", "y", "year");
                    return rexBuilder.makeCall(original.getType(), SqlLibraryOperators.DATE_TRUNC, List.of(unitArg, field));
    private static Long bucketSecondsIfPositiveInteger(RexNode interval, Long unitSeconds) {
    private static final Map<String, Long> FIXED_UNIT_SECONDS = Map.ofEntries(
        return false;
import org.apache.calcite.rex.RexBuilder;
 * The OpenSearch Contributors require contributions made to
                }
                n = bd.longValueExact();
        Map.entry("m", 60L),
    /** True when the interval RexNode is a numeric literal exactly equal to 1. */
                String dateBinStrideUnit = SUB_SECOND_UNIT_TO_DATE_BIN_STRIDE.get(unitText);
        }
            if (!isIntegralDouble(num.doubleValue())) {
        if (n == null) {
        } else if (value instanceof Number num) {
        RelDataType fp64 = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.DOUBLE);
    }
        SqlFunctionCategory.TIMEDATE
import org.apache.calcite.rel.type.RelDataType;
        // pin to call's declared type — Calcite's mul-precision inference can widen the DECIMAL
        if (!(interval instanceof RexLiteral lit)) {
        if (!original.getOperator().getName().equalsIgnoreCase("SPAN")) {
        // route through LOCAL_TO_UNIXTIME_OP / LOCAL_FROM_UNIXTIME_OP — Calcite stdlib's UNIX/TIMESTAMP_SECONDS bind BigQuery-named
        // Time span: unit operand is a string literal.
    /** Sub-second PPL units → date_bin stride suffix (multi-unit path; N=1 uses date_trunc). */
 *
                        RexNode origin = rexBuilder.makeLiteral("1970-01-01T00:00:00Z");
 * compatible open source license.
    private static boolean isIntegralDouble(double d) {
                return null;
                // sub-second multi-unit (us/ms): date_bin with string stride preserves precision
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        if (value instanceof BigDecimal bd) {
    );
            // stripTrailingZeros: `1`, `1.0`, `1E2` collapse to scale ≤ 0; fractional → scale > 0
        RexBuilder rexBuilder = cluster.getRexBuilder();
    // TODO: replace with a backend-neutral bucketing primitive emitted upstream so this adapter can go.
        // substrait fns
    /** {@code N * unit_seconds} when {@code N} is a positive integer literal; {@code null} otherwise. */
    private static final Map<String, String> SUB_SECOND_UNIT_TO_DATE_BIN_STRIDE = Map.of("us", "microseconds", "ms", "milliseconds");
                String calendarStrideUnit = CALENDAR_UNIT_TO_DATE_BIN_STRIDE.get(unitText);
            );
            return original;
