    private static RexNode liftToTimestamp(
            }
 *
        );
                return original;
            return null;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            daysExpr
        try {
            // Non-literal integer days (e.g. `bin span=Nday`): see adaptNonLiteralIntegerDays.
        return null;
        } else if (baseSqlType != SqlTypeName.DATE
import java.util.List;
            return shifted;
            return null;
            case DAY -> {
    }
            case QUARTER -> {
        return rexBuilder.makeAbstractCast(original.getType(), shifted);
        }
        if (intervalLiteral == null) {
            }
    }
 * @opensearch.internal
 * {@code INTERVAL 90 day}), but Substrait/DataFusion expect day-time intervals in milliseconds and
import org.apache.calcite.sql.type.SqlTypeName;
            return original;
}
                baseUnit = TimeUnit.DAY;
        RexNode baseSec = rexBuilder.makeApproxLiteral(BigDecimal.valueOf(baseEpochSeconds), doubleType);
        RexNode deltaSec = rexBuilder.makeCall(SqlStdOperatorTable.MULTIPLY, daysAsDouble, secPerDayLit);
            case MONTH -> {
        RexNode base = original.getOperands().get(0);
                baseUnit = TimeUnit.DAY;
            }
        // the UDT) so isthmus sees precision_timestamp.
        while (node instanceof OperatorAnnotation annotation && annotation.unwrap() != null) {
            // Non-literal base — leave the call unchanged so the UDF path raises a
    DateAddSubAdapter(boolean isAdd) {
            && baseSqlType != SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE
        RexNode shifted = rexBuilder.makeCall(SqlStdOperatorTable.DATETIME_PLUS, baseTimestamp, interval);
    private static RexNode stripOperatorAnnotation(RexNode node) {
 * (and the alias forms {@code ADDDATE} / {@code SUBDATE}) into
 * intervals can't be represented in Arrow's millisecond IntervalDayTime; the call is returned
            // MICROSECOND and unknown units fall through to the UDF path — see class javadoc.
            SqlTypeName tn = lit.getType().getSqlTypeName();
            RexNode timeAsVarchar = rexBuilder.makeCast(nullableVarchar, base);
        if (qualifier == null || leadingValue == null) {
 * The OpenSearch Contributors require contributions made to
            case WEEK -> {
 * Rewrites PPL {@code DATE_ADD(base, INTERVAL n unit)} / {@code DATE_SUB(base, INTERVAL n unit)}
            new SqlIntervalQualifier(baseUnit, null, SqlParserPos.ZERO)
 * <p>DATE / TIMESTAMP / TIME / character bases are all lowered. TIME anchors to today-UTC at plan
 * <p>Also handles ADDDATE/SUBDATE's integer form: {@code ADDDATE(base, N)} is treated as
        // ADDDATE/SUBDATE accept INTEGER days; rebuild as INTERVAL n DAY so the interval path runs.
        }
            }
        long signedSecPerDay = isAdd ? 86_400L : -86_400L;
                return millis / 1_000L;
        SqlTypeName baseSqlType,
     * {@code Int64 * Interval(DayTime)} at runtime, so lower to
        }
                baseValue = signedLeading * MILLIS_PER_WEEK;
        if (shifted.getType().equals(original.getType())) {
            }
                if (s.length() == 10) {
 * unchanged so the UDF path raises a loud error rather than mis-lowering.
            return original;
            RelDataType nullableVarchar = rexBuilder.getTypeFactory().createTypeWithNullability(varchar, base.getType().isNullable());
        switch (qualifier.getUnit()) {
            default -> {
        }
            }
        long signedLeading = (isAdd ? 1L : -1L) * leadingValue.longValueExact();
import org.apache.calcite.rel.type.RelDataType;
    private static Long tryFoldBaseToEpochSeconds(RexNode base) {
        if (baseSqlType == SqlTypeName.TIME) {
    /**
class DateAddSubAdapter implements ScalarFunctionAdapter {
            }
 * <p>PPL's interval literal carries the leading-field value (e.g. {@code 90} for
            List.of(totalSec)
            if (SqlTypeName.INTERVAL_TYPES.contains(lit.getType().getSqlTypeName())) {
                baseUnit = TimeUnit.DAY;
    /**
            base = DatePartAdapters.coerceCharacterOperandToTimestamp(base, cluster);
        if (characterBase) {
                return adaptNonLiteralIntegerDays(original, base, rawSecond, cluster);
 */
    }
            if (tn == SqlTypeName.TIMESTAMP || tn == SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE) {
    private static final long MILLIS_PER_DAY = 86_400_000L;
        RexBuilder rexBuilder = cluster.getRexBuilder();
            return ts;
     * {@code from_unixtime(baseEpochSec + daysExpr * 86400.0)}; base must be a foldable literal.
        RexNode base,
        if (baseEpochSeconds == null) {
                baseValue = signedLeading * MILLIS_PER_MINUTE;
    }
                }
                baseValue = signedLeading * 12L;
        }
        Long baseEpochSeconds = tryFoldBaseToEpochSeconds(base);
        if (ts.getType().equals(original.getType())) {
        return rexBuilder.makeAbstractCast(targetType, base);
    private RexNode adaptNonLiteralIntegerDays(RexCall original, RexNode base, RexNode daysExpr, RelOptCluster cluster) {
            case YEAR -> {
        } catch (RuntimeException ignored) {
                return null;
        long baseValue;
            typeFactory.createTypeWithNullability(doubleType, daysExpr.getType().isNullable()),
            case MILLISECOND -> {
            RexNode concat = rexBuilder.makeCall(nullableVarchar, SqlStdOperatorTable.CONCAT, List.of(prefixLit, timeAsVarchar));
import org.apache.calcite.rel.type.RelDataTypeFactory;
            node = annotation.unwrap();
            if (rawSecond != null && SqlTypeName.INT_TYPES.contains(rawSecond.getType().getSqlTypeName())) {
        RexBuilder rexBuilder
 */
     */
 * {@code DATETIME_PLUS(CAST(base AS TIMESTAMP), interval)}, which lowers to Substrait's
            return rexBuilder.makeAbstractCast(targetType, concat);
    private static final long MILLIS_PER_MINUTE = 60_000L;
        RexLiteral intervalLiteral = asIntervalLiteral(rawSecond, rexBuilder);
            }
    private static final long MILLIS_PER_WEEK = 7L * MILLIS_PER_DAY;
        RexNode daysAsDouble = rexBuilder.makeAbstractCast(
                return lit;
 * {@code add(timestamp, interval)} that DataFusion executes natively. The raw PPL UDFs have no
     * Returns null when {@code base} is not such a literal.
        );
 * time, which can drift from the PPL UDF's query-start anchor across UTC midnight or cached plans
                baseValue = signedLeading;
            }
import java.time.LocalDate;
 *
 * SPDX-License-Identifier: Apache-2.0
        RexNode interval = rexBuilder.makeIntervalLiteral(
        Object value = lit.getValue2();
import org.apache.calcite.rex.RexLiteral;
            return base;
        if (!(base instanceof RexLiteral lit)) {
                }
            case MINUTE -> {
            }
                return days * 86_400L;
        TimeUnit baseUnit;
 * the same way {@link EarliestLatestAdapter} does.
 * interval path runs. This matches the SQL plugin's {@code AddSubDateFunction} semantics.
    /** Lift the base to the call's TIMESTAMP type. TIME prepends today-UTC; character base passes through. */
            RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP,
            case SECOND -> {
/**
                baseUnit = TimeUnit.DAY;
            && baseSqlType != SqlTypeName.TIME) {
 * integer second operand is rebuilt as an {@code INTERVAL n DAY} literal before the standard
                if (days == null) {
        if (original.getOperands().size() != 2) {
        boolean characterBase = SqlTypeFamily.CHARACTER.contains(base.getType());
import org.apache.calcite.rex.RexCall;
    ) {
        }
import org.opensearch.analytics.planner.rel.OperatorAnnotation;
    private final boolean isAdd;
            case HOUR -> {
                baseValue = signedLeading * MILLIS_PER_DAY;
        return null;
import org.apache.calcite.sql.parser.SqlParserPos;
 * Substrait binding, so isthmus rejects them.
     * Returns {@code node} when it's already an interval literal; for an integer literal returns a
     */
 * <p>{@code ADDDATE(base, n_days)} / {@code SUBDATE(base, n_days)} share the same lowering: the
    }
            }
        RexBuilder rexBuilder = cluster.getRexBuilder();
     * Non-literal integer-days form (e.g. {@code bin span=Nday}). DataFusion can't evaluate
import org.apache.calcite.rex.RexNode;
        RelDataTypeFactory typeFactory = rexBuilder.getTypeFactory();
        return rexBuilder.makeAbstractCast(original.getType(), ts);
        RexNode secPerDayLit = rexBuilder.makeApproxLiteral(BigDecimal.valueOf(signedSecPerDay), doubleType);
import java.time.ZoneOffset;
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
import org.apache.calcite.rex.RexBuilder;
        RexNode totalSec = rexBuilder.makeCall(SqlStdOperatorTable.PLUS, baseSec, deltaSec);
        if (node instanceof RexLiteral lit) {
            RelDataType varchar = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
 *
            if (SqlTypeName.INT_TYPES.contains(lit.getType().getSqlTypeName())) {
 * day-interval literal before the standard lowering proceeds.
            RexNode prefixLit = rexBuilder.makeLiteral(LocalDate.now(ZoneOffset.UTC) + " ", varchar, false);
                baseUnit = TimeUnit.MONTH;
            }
                baseValue = signedLeading * MILLIS_PER_HOUR;
        boolean characterBase,
    private static final long MILLIS_PER_SECOND = 1_000L;
                baseValue = signedLeading * MILLIS_PER_SECOND;
                BigDecimal days = lit.getValueAs(BigDecimal.class);
package org.opensearch.be.datafusion;
import java.math.BigDecimal;
                return rexBuilder.makeIntervalLiteral(days, new SqlIntervalQualifier(TimeUnit.DAY, null, SqlParserPos.ZERO));
            if (tn == SqlTypeName.DATE) {
 * (TODO: thread {@code FunctionProperties#getQueryStartClock} through to adapters). MICROSECOND
        RelDataType targetType,
import org.apache.calcite.sql.type.SqlTypeFamily;
            BigDecimal.valueOf(baseValue),
    private static final long MILLIS_PER_HOUR = 3_600_000L;
                baseUnit = TimeUnit.MONTH;
            }
            }
import org.opensearch.analytics.spi.FieldStorageInfo;
        RexNode ts = rexBuilder.makeCall(
import org.apache.calcite.sql.SqlIntervalQualifier;
            }
            && baseSqlType != SqlTypeName.TIMESTAMP
        BigDecimal leadingValue = intervalLiteral.getValueAs(BigDecimal.class);
                    return null;
                baseUnit = TimeUnit.MONTH;
                long millis = ((Number) value).longValue();
            }
        }
     * synthetic {@code INTERVAL n DAY} literal (the ADDDATE/SUBDATE integer-days form). Anything
        RexNode rawSecond = stripOperatorAnnotation(original.getOperands().get(1));
            return original;
        RelDataType doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);
            typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 3), daysExpr.getType().isNullable()),
    private static RexLiteral asIntervalLiteral(RexNode node, RexBuilder rexBuilder) {
        if (characterBase) {
        }
 *
        );
            }
                baseUnit = TimeUnit.DAY;
        // Character base appears post-decorrelation when the PPL DATE() wrapper is folded off a
                baseValue = signedLeading;
        return node;
 * compatible open source license.
                baseUnit = TimeUnit.DAY;
        // literal inside EXISTS/IN/scalar subqueries — coerce back to plain Calcite TIMESTAMP (not
        SqlTypeName baseSqlType = base.getType().getSqlTypeName();
                return original;
import org.apache.calcite.plan.RelOptCluster;
    @Override
     * Folds a CHAR ({@code YYYY-MM-DD}) / DATE / TIMESTAMP literal to epoch-seconds at midnight UTC.
 * year-month intervals in months. This adapter rebuilds the interval in those base units (under a
                    return LocalDate.parse(s).atStartOfDay(ZoneOffset.UTC).toEpochSecond();
                int days = ((Number) value).intValue();
 * {@code INTERVAL N DAY} per MySQL semantics — the integer second operand is normalized to a
/*
import org.apache.calcite.avatica.util.TimeUnit;
        SqlIntervalQualifier qualifier = intervalLiteral.getType().getIntervalQualifier();
        }
        // daysExpr * 86400.0 → DOUBLE epoch-seconds delta.
    /**
 *
        }
    }
        this.isAdd = isAdd;
 *
     */
    }
        RexNode baseTimestamp = liftToTimestamp(base, baseSqlType, characterBase, original.getType(), rexBuilder);
            // clearer error than a downstream DF planner failure.
        }
        }
        }
 * this file be licensed under the Apache-2.0 license or a
            return original;
        if (value == null) {
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        }
                String s = value.toString().trim();
     * else returns null so the caller can pass the call through to the UDF path.
            return null;
 * {@link TimeUnit#DAY} or {@link TimeUnit#MONTH} qualifier) and folds the {@code DATE_SUB} sign in,
            if (SqlTypeFamily.CHARACTER.contains(lit.getType())) {
                baseValue = signedLeading * 3L;
