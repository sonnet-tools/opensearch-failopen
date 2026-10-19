        Object value = lit.getValue();
    /** {@code N * unit_seconds} when {@code N} is a positive integer literal; {@code null} otherwise. */
import org.apache.calcite.sql.fun.SqlLibraryOperators;
    private static final Map<String, String> SUB_SECOND_UNIT_TO_DATE_BIN_STRIDE = Map.of("us", "microseconds", "ms", "milliseconds");  
                // calendar multi-unit (M/q/y): date_bin with month-aligned origin '1970-01-01T00:00:00Z'
                e  
        RexNode unit = original.getOperands().get(2);
                        return rexBuilder.makeCall(original.getType(), LOCAL_DATE_BIN_OP, List.of(stride, field, origin));
    /** Positive whole-number Long from a numeric literal; null otherwise. */  
    private static RexNode rewriteFixedLengthTimeBucket(RexBuilder rexBuilder, RexNode field, long bucketSeconds, RelDataType resultType) {
        }  
                if (dateTruncUnit != null && isUnitInterval(interval)) {  
        Object value = lit.getValue();
    }  
            if (!isIntegralDouble(num.doubleValue())) {  
import org.apache.calcite.rex.RexLiteral;
                Long unitSeconds = FIXED_UNIT_SECONDS.get(unitText);
 * this file be licensed under the Apache-2.0 license or a
            || resultTypeName == SqlTypeName.TINYINT;  
    /** Sub-second PPL units → date_bin stride suffix (multi-unit path; N=1 uses date_trunc). */
        // substrait fns
        return rexBuilder.makeCast(resultType, product, true);
 * <p>Numeric span (unit = typed-NULL): {@code (field / interval) * interval} (FLOOR for non-integer).
        RexBuilder rexBuilder = cluster.getRexBuilder();  
 */  
        RexNode product = rexBuilder.makeCall(SqlStdOperatorTable.MULTIPLY, bucket, interval);  
        } catch (ArithmeticException e) {  
        }
        ReturnTypes.ARG1_NULLABLE,  
        }
        long n;  
        // i64/i64 already truncates toward zero; FLOOR would force fp64 (substrait floor is fp-only)  
                Long bucketSeconds = bucketSecondsIfPositiveInteger(interval, unitSeconds);  
import org.apache.calcite.sql.SqlKind;  
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.sql.SqlOperator;
            return bd.compareTo(BigDecimal.ONE) == 0;  
        }
    );
        if (value instanceof BigDecimal bd) {
    /** Single-letter PPL span unit → DataFusion {@code date_trunc} unit name. */  
    }
        if (value instanceof Number n) {
        Map.entry("M", "month"),  
        if (!original.getOperator().getName().equalsIgnoreCase("SPAN")) {  
                String calendarStrideUnit = CALENDAR_UNIT_TO_DATE_BIN_STRIDE.get(unitText);
        Map.entry("w", "week"),
package org.opensearch.be.datafusion;
import org.apache.calcite.sql.type.ReturnTypes;
        return rexBuilder.makeCast(resultType, asTimestamp, true);
        Map.entry("y", "year")
                }  
 * Rewrites PPL {@code SPAN(field, interval, unit)} into a Substrait-friendly tree.  
        RexNode bucketSizeLit = rexBuilder.makeBigintLiteral(BigDecimal.valueOf(bucketSeconds));
        RexNode interval = original.getOperands().get(1);
    );  
        RexNode bucketStart = rexBuilder.makeCall(SqlStdOperatorTable.MULTIPLY, bucketIndex, bucketSizeLit);
    }  
 * compatible open source license.
        // pin to call's declared type — Calcite's mul-precision inference can widen the DECIMAL
            // stripTrailingZeros: `1`, `1.0`, `1E2` collapse to scale ≤ 0; fractional → scale > 0
import org.apache.calcite.sql.SqlFunctionCategory;
    /** Calendar PPL units → date_bin stride suffix; bucketed against month-aligned epoch (1970-01-01). */
        RexNode bucket = integerResult ? quotient : rexBuilder.makeCall(SqlStdOperatorTable.FLOOR, quotient);
        if (value instanceof BigDecimal bd) {
        return Double.isFinite(d) && d == Math.floor(d);
        OperandTypes.VARIADIC,
        RexNode field = original.getOperands().get(0);  
import org.apache.calcite.plan.RelOptCluster;
        SqlTypeName resultTypeName = resultType.getSqlTypeName();
 * Time span (unit = single letter): {@code interval == 1} → {@code DATE_TRUNC}; fixed-length s/m/h/d/w  
    private static Long extractPositiveInteger(RexNode interval) {
        RexNode epochSeconds = rexBuilder.makeCall(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, field);
    /** Fixed-length PPL span units → seconds (M/q/y excluded — calendar-dependent). */
            }
            return rewriteNumericSpan(rexBuilder, field, interval, original.getType());
        // Time span: unit operand is a string literal.
            if (unitText != null) {
        RexNode bucketIndex = rexBuilder.makeCall(SqlStdOperatorTable.DIVIDE, epochSeconds, bucketSizeLit);
                if (dateBinStrideUnit != null) {  
                        RexNode origin = rexBuilder.makeLiteral("1970-01-01T00:00:00Z");
        Map.entry("w", 604800L)
        Map.entry("m", 60L),
                    if (n != null) {
            if (bd.stripTrailingZeros().scale() > 0) {  
    }
                    Long n = extractPositiveInteger(interval);
        RelDataType fp64 = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.DOUBLE);
        if (unitSeconds == null) {  
                }
        Map.entry("us", "microsecond"),
import java.util.List;
                }  
        RexNode bucketStartDouble = rexBuilder.makeCast(fp64, bucketStart, true);
                        return rexBuilder.makeCall(original.getType(), LOCAL_DATE_BIN_OP, List.of(stride, field));
 * M/q/y → {@code date_bin("<N> <unit>", t, '1970-01-01T00:00:00Z')}.
    private static boolean isUnitInterval(RexNode interval) {  
    /** True when the interval RexNode is a numeric literal exactly equal to 1. */
                    return rewriteFixedLengthTimeBucket(rexBuilder, field, bucketSeconds, original.getType());
            return original;
    }
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
    }  
        Map.entry("s", 1L),
        RexNode quotient = rexBuilder.makeCall(SqlStdOperatorTable.DIVIDE, field, interval);
        Map.entry("m", "minute"),
import org.apache.calcite.rex.RexBuilder;  
import org.apache.calcite.sql.type.SqlTypeName;  
            }
        return original;  
        if (n == null) {
        if (!(interval instanceof RexLiteral lit)) {
        Map.entry("h", 3600L),  
import java.util.Map;  
        RexNode asTimestamp = rexBuilder.makeCall(RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP, bucketStartDouble);  
        boolean integerResult = resultTypeName == SqlTypeName.INTEGER  
        Long n = extractPositiveInteger(interval);  
/**
            return null;
                    return rexBuilder.makeCall(original.getType(), SqlLibraryOperators.DATE_TRUNC, List.of(unitArg, field));
    private static boolean isIntegralDouble(double d) {  
 * SPDX-License-Identifier: Apache-2.0
            return original;
                if (calendarStrideUnit != null) {  
        }  
        if (unit instanceof RexLiteral lit && lit.getValue() != null) {
        if (!(interval instanceof RexLiteral lit)) {
            return false;
    static final SqlOperator LOCAL_DATE_BIN_OP = new SqlFunction(  
    private static final Map<String, String> UNIT_TO_DATE_TRUNC = Map.ofEntries(
                    }
                    if (n != null) {
                return null;
        SqlFunctionCategory.TIMEDATE  
    /** True when {@code d} is finite and integral. */
            n = (long) num.doubleValue();  
        Map.entry("d", "day"),
 */  
        Map.entry("ms", "millisecond"),  
            return null;
        Map.entry("h", "hour"),  
            || resultTypeName == SqlTypeName.SMALLINT
        Map.entry("s", "second"),
                // multi-unit fixed-length time span: bucket via integer seconds since epoch (B = N * unit_seconds)
import org.apache.calcite.rex.RexNode;  
                "SPAN interval is too large: " + n + " * " + unitSeconds + " seconds exceeds the long range",
            || resultTypeName == SqlTypeName.BIGINT
import org.opensearch.analytics.spi.FieldStorageInfo;
    private static RexNode rewriteNumericSpan(RexBuilder rexBuilder, RexNode field, RexNode interval, RelDataType resultType) {
        SqlKind.OTHER_FUNCTION,
                if (bucketSeconds != null && bucketSeconds > 0L) {
import org.apache.calcite.sql.type.OperandTypes;
    @Override
        "date_bin",
            }
            return Math.multiplyExact(n, unitSeconds);
                String dateBinStrideUnit = SUB_SECOND_UNIT_TO_DATE_BIN_STRIDE.get(unitText);
                    Long n = extractPositiveInteger(interval);
            String unitText = lit.getValueAs(String.class);  
        if (unit.getType().getSqlTypeName() == SqlTypeName.NULL || (unit instanceof RexLiteral lit && lit.isNull())) {  
        }  
import org.apache.calcite.rex.RexCall;
                n = bd.longValueExact();
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
        }
/*  
 * Unit letters: us/ms/s/m/h/d/w/M/q/y → microsecond/millisecond/second/minute/hour/day/week/month/quarter/year.  
        return false;
    // TODO: replace with a backend-neutral bucketing primitive emitted upstream so this adapter can go.  
    );  
    }
            try {  
import org.apache.calcite.sql.SqlFunction;
        if (original.getOperands().size() != 3) {  
                }  
                    RexNode unitArg = rexBuilder.makeLiteral(dateTruncUnit);
        }
            return n.doubleValue() == 1.0;  
            return null;  
        // route through LOCAL_TO_UNIXTIME_OP / LOCAL_FROM_UNIXTIME_OP — Calcite stdlib's UNIX/TIMESTAMP_SECONDS bind BigQuery-named  
 *
                        RexNode stride = rexBuilder.makeLiteral(n + " " + dateBinStrideUnit);  
    private static final Map<String, Long> FIXED_UNIT_SECONDS = Map.ofEntries(  
 *
                // sub-second multi-unit (us/ms): date_bin with string stride preserves precision
    private static final Map<String, String> CALENDAR_UNIT_TO_DATE_BIN_STRIDE = Map.of("M", "month", "q", "quarter", "y", "year");  
                return null;  
            return null;
        }  
                        RexNode stride = rexBuilder.makeLiteral(n + " " + calendarStrideUnit);  
                return null;
}
    private static Long bucketSecondsIfPositiveInteger(RexNode interval, Long unitSeconds) {
import org.apache.calcite.rel.type.RelDataType;
        null,
class SpanAdapter implements ScalarFunctionAdapter {
        // Anything else falls through unchanged.
        // from_unixtime sig is (fp64) → precision_timestamp<6>  
                String dateTruncUnit = UNIT_TO_DATE_TRUNC.get(unitText);
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
 *
        try {
        return n > 0 ? n : null;
            throw new IllegalArgumentException(
    /** date_bin target — name matches DataFusion native; ARG1_NULLABLE return preserves the source timestamp type. */
        }
            }
        }
            );
        } else if (value instanceof Number num) {
        Map.entry("d", 86400L),
        Map.entry("q", "quarter"),
 * with N&gt;1 → integer-seconds arithmetic; sub-second us/ms → {@code date_bin("<N> <unit>", t)}; calendar
        // Numeric span: unit operand is typed-NULL.
            } catch (ArithmeticException e) {
                    }  
 * @opensearch.internal
        } else {
        }
import java.math.BigDecimal;
