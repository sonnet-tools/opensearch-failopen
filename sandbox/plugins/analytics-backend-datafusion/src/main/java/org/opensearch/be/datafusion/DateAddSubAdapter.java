     */
            return shifted;
/*  
            RelDataType nullableVarchar = rexBuilder.getTypeFactory().createTypeWithNullability(varchar, base.getType().isNullable());  
     * {@code from_unixtime(baseEpochSec + daysExpr * 86400.0)}; base must be a foldable literal.  
                baseUnit = TimeUnit.DAY;  
                return lit;  
                baseUnit = TimeUnit.DAY;
                baseUnit = TimeUnit.MONTH;  
            case SECOND -> {  
    private static final long MILLIS_PER_DAY = 86_400_000L;  
            case DAY -> {  
 *  
                baseValue = signedLeading;  
            node = annotation.unwrap();
                baseValue = signedLeading * MILLIS_PER_HOUR;  
        if (node instanceof RexLiteral lit) {
import org.opensearch.analytics.planner.rel.OperatorAnnotation;
    private static final long MILLIS_PER_SECOND = 1_000L;  
        }  
                baseValue = signedLeading * 12L;
     * Folds a CHAR ({@code YYYY-MM-DD}) / DATE / TIMESTAMP literal to epoch-seconds at midnight UTC.
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
            }  
            case MILLISECOND -> {
 * {@link TimeUnit#DAY} or {@link TimeUnit#MONTH} qualifier) and folds the {@code DATE_SUB} sign in,
                return rexBuilder.makeIntervalLiteral(days, new SqlIntervalQualifier(TimeUnit.DAY, null, SqlParserPos.ZERO));
        SqlTypeName baseSqlType,
 *
        // daysExpr * 86400.0 → DOUBLE epoch-seconds delta.
        }
            return original;
            }
            BigDecimal.valueOf(baseValue),
                baseValue = signedLeading * MILLIS_PER_WEEK;
        RexBuilder rexBuilder = cluster.getRexBuilder();  
        }  
            RexNode prefixLit = rexBuilder.makeLiteral(LocalDate.now(ZoneOffset.UTC) + " ", varchar, false);
 * compatible open source license.
        RexNode shifted = rexBuilder.makeCall(SqlStdOperatorTable.DATETIME_PLUS, baseTimestamp, interval);
            return rexBuilder.makeAbstractCast(targetType, concat);
        if (ts.getType().equals(original.getType())) {  
    ) {  
                if (days == null) {
        return rexBuilder.makeAbstractCast(targetType, base);  
import org.apache.calcite.rex.RexCall;  
import org.opensearch.analytics.spi.FieldStorageInfo;  
                long millis = ((Number) value).longValue();
        RexBuilder rexBuilder = cluster.getRexBuilder();
            return base;
        }
                    return null;
        RexNode interval = rexBuilder.makeIntervalLiteral(  
        RexNode totalSec = rexBuilder.makeCall(SqlStdOperatorTable.PLUS, baseSec, deltaSec);  
                baseUnit = TimeUnit.MONTH;
            if (SqlTypeName.INTERVAL_TYPES.contains(lit.getType().getSqlTypeName())) {
        // Character base appears post-decorrelation when the PPL DATE() wrapper is folded off a
                return days * 86_400L;
    }
        if (baseSqlType == SqlTypeName.TIME) {
        }
    /**  
import org.apache.calcite.rex.RexNode;
            case HOUR -> {
        );
        );  
    private static final long MILLIS_PER_HOUR = 3_600_000L;
        RelDataType targetType,
        return null;
            }
    private final boolean isAdd;  
            default -> {  
    private static final long MILLIS_PER_MINUTE = 60_000L;
        SqlTypeName baseSqlType = base.getType().getSqlTypeName();
        RexNode base,
 *
        } catch (RuntimeException ignored) {
            }
            if (SqlTypeName.INT_TYPES.contains(lit.getType().getSqlTypeName())) {
    /** Lift the base to the call's TIMESTAMP type. TIME prepends today-UTC; character base passes through. */
        RelDataType doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);  
 */  
                return adaptNonLiteralIntegerDays(original, base, rawSecond, cluster);
            if (rawSecond != null && SqlTypeName.INT_TYPES.contains(rawSecond.getType().getSqlTypeName())) {  
        return node;
            }
        boolean characterBase,  
                return millis / 1_000L;  
                baseValue = signedLeading * MILLIS_PER_SECOND;
        }  
        long baseValue;
            return null;  
 * integer second operand is rebuilt as an {@code INTERVAL n DAY} literal before the standard
        RexNode baseTimestamp = liftToTimestamp(base, baseSqlType, characterBase, original.getType(), rexBuilder);
        if (baseEpochSeconds == null) {
 * <p>Also handles ADDDATE/SUBDATE's integer form: {@code ADDDATE(base, N)} is treated as  
    private static RexLiteral asIntervalLiteral(RexNode node, RexBuilder rexBuilder) {  
            // Non-literal base — leave the call unchanged so the UDF path raises a  
        RexNode secPerDayLit = rexBuilder.makeApproxLiteral(BigDecimal.valueOf(signedSecPerDay), doubleType);  
 * The OpenSearch Contributors require contributions made to  
        RexNode rawSecond = stripOperatorAnnotation(original.getOperands().get(1));
            typeFactory.createTypeWithNullability(doubleType, daysExpr.getType().isNullable()),
 * unchanged so the UDF path raises a loud error rather than mis-lowering.  
package org.opensearch.be.datafusion;
        if (characterBase) {
 * interval path runs. This matches the SQL plugin's {@code AddSubDateFunction} semantics.  
 * <p>PPL's interval literal carries the leading-field value (e.g. {@code 90} for
import org.apache.calcite.plan.RelOptCluster;
                baseValue = signedLeading * MILLIS_PER_MINUTE;
        // ADDDATE/SUBDATE accept INTEGER days; rebuild as INTERVAL n DAY so the interval path runs.
     * Non-literal integer-days form (e.g. {@code bin span=Nday}). DataFusion can't evaluate
 * the same way {@link EarliestLatestAdapter} does.
            typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 3), daysExpr.getType().isNullable()),
                baseValue = signedLeading * MILLIS_PER_DAY;
import org.apache.calcite.rex.RexBuilder;
     * {@code Int64 * Interval(DayTime)} at runtime, so lower to
    /**  
            return original;
        if (value == null) {  
            if (tn == SqlTypeName.TIMESTAMP || tn == SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE) {
 * intervals can't be represented in Arrow's millisecond IntervalDayTime; the call is returned
                return original;
        RexBuilder rexBuilder
            RexNode timeAsVarchar = rexBuilder.makeCast(nullableVarchar, base);
        if (original.getOperands().size() != 2) {
        );
        Long baseEpochSeconds = tryFoldBaseToEpochSeconds(base);
                baseUnit = TimeUnit.DAY;
            return ts;
                int days = ((Number) value).intValue();
            }
            && baseSqlType != SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE
        switch (qualifier.getUnit()) {
     */  
    private static RexNode liftToTimestamp(  
import java.util.List;  
     * Returns {@code node} when it's already an interval literal; for an integer literal returns a
            if (SqlTypeFamily.CHARACTER.contains(lit.getType())) {
            // Non-literal integer days (e.g. `bin span=Nday`): see adaptNonLiteralIntegerDays.
            // clearer error than a downstream DF planner failure.
import org.apache.calcite.sql.type.SqlTypeFamily;  
        Object value = lit.getValue2();
    }
 *
        RexNode ts = rexBuilder.makeCall(
                }  
        try {  
import java.math.BigDecimal;  
                BigDecimal days = lit.getValueAs(BigDecimal.class);  
            }
import org.apache.calcite.rel.type.RelDataType;  
            }
        RexNode base = original.getOperands().get(0);  
        RexNode deltaSec = rexBuilder.makeCall(SqlStdOperatorTable.MULTIPLY, daysAsDouble, secPerDayLit);
            && baseSqlType != SqlTypeName.TIMESTAMP
            daysExpr  
     * else returns null so the caller can pass the call through to the UDF path.
                baseUnit = TimeUnit.DAY;  
                baseUnit = TimeUnit.MONTH;
        BigDecimal leadingValue = intervalLiteral.getValueAs(BigDecimal.class);  
 * {@code add(timestamp, interval)} that DataFusion executes natively. The raw PPL UDFs have no  
        RelDataTypeFactory typeFactory = rexBuilder.getTypeFactory();
        boolean characterBase = SqlTypeFamily.CHARACTER.contains(base.getType());  
 * (and the alias forms {@code ADDDATE} / {@code SUBDATE}) into
import org.apache.calcite.avatica.util.TimeUnit;
        SqlIntervalQualifier qualifier = intervalLiteral.getType().getIntervalQualifier();
 *
        return null;
        }
            case QUARTER -> {  
 * {@code INTERVAL N DAY} per MySQL semantics — the integer second operand is normalized to a
     */
        this.isAdd = isAdd;  
    private static Long tryFoldBaseToEpochSeconds(RexNode base) {
            }
        if (!(base instanceof RexLiteral lit)) {
import org.apache.calcite.rex.RexLiteral;
        if (qualifier == null || leadingValue == null) {
        if (intervalLiteral == null) {
            case YEAR -> {
/**
    }
 *  
            }  
                    return LocalDate.parse(s).atStartOfDay(ZoneOffset.UTC).toEpochSecond();
        }  
            return original;  
        TimeUnit baseUnit;  
import org.apache.calcite.sql.parser.SqlParserPos;
    }  
            base = DatePartAdapters.coerceCharacterOperandToTimestamp(base, cluster);
                if (s.length() == 10) {  
 * <p>DATE / TIMESTAMP / TIME / character bases are all lowered. TIME anchors to today-UTC at plan
        return rexBuilder.makeAbstractCast(original.getType(), shifted);  
            new SqlIntervalQualifier(baseUnit, null, SqlParserPos.ZERO)
        }
import java.time.LocalDate;
    }
import org.apache.calcite.sql.type.SqlTypeName;
 * <p>{@code ADDDATE(base, n_days)} / {@code SUBDATE(base, n_days)} share the same lowering: the
        RexNode baseSec = rexBuilder.makeApproxLiteral(BigDecimal.valueOf(baseEpochSeconds), doubleType);
            case MINUTE -> {
    @Override  
class DateAddSubAdapter implements ScalarFunctionAdapter {
 */  
    private static final long MILLIS_PER_WEEK = 7L * MILLIS_PER_DAY;
        long signedSecPerDay = isAdd ? 86_400L : -86_400L;
        RexLiteral intervalLiteral = asIntervalLiteral(rawSecond, rexBuilder);  
     * Returns null when {@code base} is not such a literal.
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            return null;  
            }
        }
    /**
        }  
            RelDataType varchar = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
import java.time.ZoneOffset;
                baseValue = signedLeading;  
                baseValue = signedLeading * 3L;
 * Rewrites PPL {@code DATE_ADD(base, INTERVAL n unit)} / {@code DATE_SUB(base, INTERVAL n unit)}  
                baseUnit = TimeUnit.DAY;
            }
                return original;
 * year-month intervals in months. This adapter rebuilds the interval in those base units (under a  
        if (characterBase) {
 * @opensearch.internal
            && baseSqlType != SqlTypeName.TIME) {  
 * time, which can drift from the PPL UDF's query-start anchor across UTC midnight or cached plans  
        while (node instanceof OperatorAnnotation annotation && annotation.unwrap() != null) {
            }
            }  
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        if (shifted.getType().equals(original.getType())) {  
 * SPDX-License-Identifier: Apache-2.0
            RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP,  
                return null;  
                }
        // the UDT) so isthmus sees precision_timestamp.
            List.of(totalSec)
        }  
 * this file be licensed under the Apache-2.0 license or a
            SqlTypeName tn = lit.getType().getSqlTypeName();
            // MICROSECOND and unknown units fall through to the UDF path — see class javadoc.
 * day-interval literal before the standard lowering proceeds.
    }
 * Substrait binding, so isthmus rejects them.
        RexNode daysAsDouble = rexBuilder.makeAbstractCast(
            case MONTH -> {
            }  
        }
}  
            RexNode concat = rexBuilder.makeCall(nullableVarchar, SqlStdOperatorTable.CONCAT, List.of(prefixLit, timeAsVarchar));  
            }
            if (tn == SqlTypeName.DATE) {  
                String s = value.toString().trim();
            return original;  
        return rexBuilder.makeAbstractCast(original.getType(), ts);  
            }
            case WEEK -> {
 * {@code INTERVAL 90 day}), but Substrait/DataFusion expect day-time intervals in milliseconds and
                baseUnit = TimeUnit.DAY;
            return null;
import org.apache.calcite.sql.SqlIntervalQualifier;  
    DateAddSubAdapter(boolean isAdd) {
        } else if (baseSqlType != SqlTypeName.DATE  
    }
     * synthetic {@code INTERVAL n DAY} literal (the ADDDATE/SUBDATE integer-days form). Anything  
import org.apache.calcite.rel.type.RelDataTypeFactory;
    private static RexNode stripOperatorAnnotation(RexNode node) {  
 * (TODO: thread {@code FunctionProperties#getQueryStartClock} through to adapters). MICROSECOND
    private RexNode adaptNonLiteralIntegerDays(RexCall original, RexNode base, RexNode daysExpr, RelOptCluster cluster) {
 * {@code DATETIME_PLUS(CAST(base AS TIMESTAMP), interval)}, which lowers to Substrait's
        // literal inside EXISTS/IN/scalar subqueries — coerce back to plain Calcite TIMESTAMP (not  
        long signedLeading = (isAdd ? 1L : -1L) * leadingValue.longValueExact();  
        }
