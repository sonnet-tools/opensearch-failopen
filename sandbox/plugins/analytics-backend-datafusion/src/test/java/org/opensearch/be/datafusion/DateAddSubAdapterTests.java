        SqlFunctionCategory.TIMEDATE
 * compatible open source license.
            BigDecimal.valueOf(500),
        assertEquals(86_400.0, ((org.apache.calcite.rex.RexLiteral) plus.getOperands().get(0)).getValueAs(Double.class), 0.0);
        if (node instanceof RexCall call && call.getKind() == SqlKind.CAST) {
import org.apache.calcite.sql.type.ReturnTypes;
        "ADDDATE",
        RelDataType timeType = typeFactory.createSqlType(SqlTypeName.TIME);
        RexCall plus = (RexCall) fromUnixtime.getOperands().get(0);
        RexNode dateCol = rexBuilder.makeInputRef(dateType, 0);
        OperandTypes.VARIADIC,
import java.math.BigDecimal;
        // Inner expr: PLUS(baseSec=0.0, MULTIPLY(CAST(daysExpr AS DOUBLE), 86400.0))
    private static final SqlFunction SUBDATE_OP = new SqlFunction(
    /** Unwrap an outer CAST around the from_unixtime call (return-type alignment). */
        RelDataType i64 = typeFactory.createSqlType(SqlTypeName.BIGINT);
    }
    }
        assertEquals(0.0, ((org.apache.calcite.rex.RexLiteral) plus.getOperands().get(0)).getValueAs(Double.class), 0.0);
        SqlKind.OTHER_FUNCTION,
        RexCall fromUnixtime = unwrapCast(adapted);
        ReturnTypes.TIMESTAMP,
        RexNode interval = rexBuilder.makeIntervalLiteral(
        RexCall multiply = (RexCall) plus.getOperands().get(1);
    }
        RexCall fromUnixtime = unwrapCast(adapted);
        RexNode oneInt = rexBuilder.makeLiteral(1, typeFactory.createSqlType(SqlTypeName.INTEGER), false);
    );
        RexNode adapted = new DateAddSubAdapter(true).adapt(original, List.of(), cluster);
        RexCall outer = adapted instanceof RexCall && ((RexCall) adapted).getKind() == SqlKind.CAST
    public void testAddDateDateLiteralBaseFoldsViaDaysTimes86400() {
        RexNode adapted = new DateAddSubAdapter(true).adapt(original, List.of(), cluster);
        assertSame(SqlStdOperatorTable.DATETIME_PLUS, outer.getOperator());
        RexCall original = (RexCall) rexBuilder.makeCall(ADDDATE_OP, List.of(epochCharLit, daysExpr));
     */
            new SqlIntervalQualifier(TimeUnit.MICROSECOND, null, SqlParserPos.ZERO)
        assertEquals(TimeUnit.DAY, shiftedInterval.getType().getIntervalQualifier().getUnit());
        RexCall plus = (RexCall) fromUnixtime.getOperands().get(0);
        long signed = ((org.apache.calcite.rex.RexLiteral) shiftedInterval).getValueAs(Long.class);
            : (RexCall) adapted;
        null,
        RelDataType dateType = typeFactory.createSqlType(SqlTypeName.DATE);
        RexNode adapted = new DateAddSubAdapter(true).adapt(original, List.of(), cluster);
    public void testSubDateCharLiteralBaseWithI64DaysFlipsMultiplierSign() {
        assertEquals("from_unixtime", fromUnixtime.getOperator().getName());
    );
 * The OpenSearch Contributors require contributions made to
import org.apache.calcite.sql.SqlFunctionCategory;
        RexCall castNode = (RexCall) outer.getOperands().get(0);
        RexNode dateLit = rexBuilder.makeDateLiteral(new org.apache.calcite.util.DateString("1970-01-02"));
        RexCall outer = adapted instanceof RexCall && ((RexCall) adapted).getKind() == SqlKind.CAST
        RexNode mod = rexBuilder.makeCall(SqlStdOperatorTable.MOD, daysCol, rexBuilder.makeLiteral(7, i64, false));
        SqlKind.OTHER_FUNCTION,
        RexCall original = (RexCall) rexBuilder.makeCall(ADDDATE_OP, List.of(dateLit, daysCol));
import org.apache.calcite.rex.RexNode;
        assertEquals(1.0, ((org.apache.calcite.rex.RexLiteral) plus.getOperands().get(0)).getValueAs(Double.class), 0.0);
/*
        // INTERVAL DAY values are stored in millis after the unit-rebuild step; +1 day = +86400000.
            ? (RexCall) ((RexCall) adapted).getOperands().get(0)
    /** SUBDATE('1970-01-01', i64Expr) — sign-flipped multiplier (-86400). */
import org.apache.calcite.avatica.util.TimeUnit;
    /**
        RexCall concat = (RexCall) castNode.getOperands().get(0);
import org.apache.calcite.sql.type.SqlTypeName;
    /** TIMESTAMP-literal base folds via millis ÷ 1000. */
        // 1970-01-01 00:00:01 UTC → baseSec = 1.
 * SPDX-License-Identifier: Apache-2.0
     */
        assertEquals("||", concat.getOperator().getName());
public class DateAddSubAdapterTests extends OpenSearchTestCase {
            ? (RexCall) ((RexCall) adapted).getOperands().get(0)
        assertSame("non-literal second operand must leave the call unchanged", original, adapted);
 * this file be licensed under the Apache-2.0 license or a
        );
        RexCall plus = (RexCall) fromUnixtime.getOperands().get(0);
        RexNode daysExpr = rexBuilder.makeCall(SqlStdOperatorTable.MINUS, daysCol, mod);
        assertEquals("from_unixtime", fromUnixtime.getOperator().getName());
import java.util.List;
        RexCall multiply = (RexCall) plus.getOperands().get(1);
        assertTrue(SqlTypeName.INTERVAL_TYPES.contains(shiftedInterval.getType().getSqlTypeName()));
    public void testAddDateIntegerDaysOnDateRebuiltAsIntervalDay() {
import org.apache.calcite.sql.SqlFunction;
 *
    public void testAddDateTimestampLiteralBaseFoldsViaMillisDiv1000() {
        RexCall plus = (RexCall) fromUnixtime.getOperands().get(0);
    }
        }
        RexCall original = (RexCall) rexBuilder.makeCall(ADDDATE_OP, List.of(dateCol, daysCol));
     * INTERVAL by {@code asIntervalLiteral} — the adapter must pass the call through unchanged so
        RexNode daysCol = rexBuilder.makeInputRef(i64, 0);
        RexNode daysCol = rexBuilder.makeInputRef(i64, 0);
    public void testAddDateCharLiteralBaseWithComputedI64DaysLowersToFromUnixtime() {
        RexCall original = (RexCall) rexBuilder.makeCall(ADDDATE_OP, List.of(tsLit, daysCol));
 */
        assertEquals("from_unixtime", fromUnixtime.getOperator().getName());
    );
        assertSame(SqlStdOperatorTable.PLUS, plus.getOperator());
        // Outer DATETIME_PLUS (or CAST wrapping it).
        SqlKind.OTHER_FUNCTION,
    private final RelOptCluster cluster = RelOptCluster.create(new VolcanoPlanner(), rexBuilder);
        RexNode dateCol = rexBuilder.makeInputRef(dateType, 0);
import org.apache.calcite.sql.SqlKind;
        assertEquals(86_400_000L, signed);
import org.apache.calcite.rex.RexBuilder;
        RexCall outer = adapted instanceof RexCall && ((RexCall) adapted).getKind() == SqlKind.CAST
        assertSame(SqlStdOperatorTable.DATETIME_PLUS, outer.getOperator());
        RexNode adapted = new DateAddSubAdapter(false).adapt(original, List.of(), cluster);
        RexCall original = (RexCall) rexBuilder.makeCall(DATE_ADD_OP, List.of(tsCol, microInterval));
    /**
        assertEquals("from_unixtime", fromUnixtime.getOperator().getName());
        RexCall original = (RexCall) rexBuilder.makeCall(SUBDATE_OP, List.of(epochCharLit, daysCol));
import org.apache.calcite.rel.type.RelDataTypeFactory;
        RexCall original = (RexCall) rexBuilder.makeCall(SUBDATE_OP, List.of(tsCol, fiveInt));
        SqlFunctionCategory.TIMEDATE
    }
import org.apache.calcite.plan.RelOptCluster;
        assertEquals(86_400.0, ((org.apache.calcite.rex.RexLiteral) multiply.getOperands().get(1)).getValueAs(Double.class), 0.0);
        RelDataType i64 = typeFactory.createSqlType(SqlTypeName.BIGINT);
        RexNode daysCol = rexBuilder.makeInputRef(i64, 0);
        RexNode tsLit = rexBuilder.makeTimestampLiteral(new org.apache.calcite.util.TimestampString("1970-01-01 00:00:01"), 0);
        "SUBDATE",
    public void testSubDateIntegerDaysFoldsSign() {
/** Covers {@link DateAddSubAdapter}: TIME base anchors to today UTC; integer-days form rebuilds as INTERVAL DAY. */
        "DATE_ADD",
     * the original call so the engine surfaces a loud error rather than silently truncating.
        RexNode adapted = new DateAddSubAdapter(true).adapt(original, List.of(), cluster);
        return (RexCall) node;
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        assertEquals(SqlKind.CAST, castNode.getKind());
    }
    }
        RexNode timeCol = rexBuilder.makeInputRef(timeType, 0);
            ? (RexCall) ((RexCall) adapted).getOperands().get(0)
        // First operand is CAST(CONCAT(today,' ',CAST(time AS VARCHAR)) AS TIMESTAMP).
     * ADDDATE('1970-01-01', daysExpr) — bin span=Nday lowering shape. Second operand is computed
        ReturnTypes.TIMESTAMP,
        RelDataType dateType = typeFactory.createSqlType(SqlTypeName.DATE);
import org.apache.calcite.sql.type.OperandTypes;
        OperandTypes.VARIADIC,
    private static RexCall unwrapCast(RexNode node) {
        RexNode adapted = new DateAddSubAdapter(false).adapt(original, List.of(), cluster);
import org.apache.calcite.plan.volcano.VolcanoPlanner;
package org.opensearch.be.datafusion;
    public void testAddDateNonLiteralBaseWithI64DaysPassesThrough() {
    public void testDateAddMicrosecondIntervalPassesThrough() {
        RexNode dateCol = rexBuilder.makeInputRef(dateType, 0);
     * Non-literal second operand (an integer column ref, not a literal) cannot be normalized to an
        RexNode adapted = new DateAddSubAdapter(true).adapt(original, List.of(), cluster);
import org.apache.calcite.rel.type.RelDataType;
            BigDecimal.valueOf(1L),
    private static final SqlFunction ADDDATE_OP = new SqlFunction(
        assertSame("non-foldable base must leave the call unchanged", original, adapted);
     * (MOD-based subtract on an integer column ref), not a literal. Adapter must lower to
        long signed = ((org.apache.calcite.rex.RexLiteral) outer.getOperands().get(1)).getValueAs(Long.class);
import org.apache.calcite.sql.parser.SqlParserPos;
     * {@code from_unixtime(baseEpochSec + daysExpr * 86400.0)} where baseEpochSec=0.
    private final RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        RexNode daysCol = rexBuilder.makeInputRef(i64, 0);
        assertSame(SqlStdOperatorTable.MULTIPLY, multiply.getOperator());
    }
    /** ADDDATE(DATE-col, 1) → DATETIME_PLUS(CAST(date AS …), INTERVAL 1 DAY). The integer 1 is rebuilt as a DAY interval. */
        RexNode shiftedInterval = outer.getOperands().get(1);
    /** DATE_ADD(TIME-col, INTERVAL 1 DAY) → DATETIME_PLUS(CAST(CONCAT(today,' ',CAST time AS VARCHAR)) AS TIMESTAMP), 86400000 millis). */
        RexNode intCol = rexBuilder.makeInputRef(intType, 1);
    private static final SqlFunction DATE_ADD_OP = new SqlFunction(
        RexNode adapted = new DateAddSubAdapter(true).adapt(original, List.of(), cluster);
        RelDataType i64 = typeFactory.createSqlType(SqlTypeName.BIGINT);
            : (RexCall) adapted;
        RexNode epochCharLit = rexBuilder.makeLiteral("1970-01-01");
            return (RexCall) call.getOperands().get(0);
        assertSame("MICROSECOND interval must leave the call unchanged", original, adapted);
import org.apache.calcite.rex.RexCall;
    /** DATE-literal base folds to epoch-seconds via days × 86400. */
        assertSame(SqlStdOperatorTable.DATETIME_PLUS, outer.getOperator());
        RexNode fiveInt = rexBuilder.makeLiteral(5, typeFactory.createSqlType(SqlTypeName.INTEGER), false);
    public void testAddDateNonLiteralSecondOperandPassesThrough() {
        RexCall original = (RexCall) rexBuilder.makeCall(ADDDATE_OP, List.of(dateCol, intCol));
    }
     * MICROSECOND interval falls through to the UDF path — Arrow's IntervalDayTime is
            new SqlIntervalQualifier(TimeUnit.DAY, null, SqlParserPos.ZERO)
        RelDataType i64 = typeFactory.createSqlType(SqlTypeName.BIGINT);
    public void testDateAddTimeOperandAnchoredToToday() {
        RexCall fromUnixtime = unwrapCast(adapted);
        RelDataType i64 = typeFactory.createSqlType(SqlTypeName.BIGINT);
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RelDataType tsType = typeFactory.createSqlType(SqlTypeName.TIMESTAMP);
    /** SUBDATE(TIMESTAMP-col, 5) → DATETIME_PLUS(ts, INTERVAL -5 DAY). Sign folded for SUB. */
        ReturnTypes.TIMESTAMP,
        null,
        RelDataType tsType = typeFactory.createSqlType(SqlTypeName.TIMESTAMP);
        SqlFunctionCategory.TIMEDATE
        RexCall fromUnixtime = unwrapCast(adapted);
    /** Non-foldable base (column ref, not literal) with computed i64 days passes through. */
        null,
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        RexNode epochCharLit = rexBuilder.makeLiteral("1970-01-01");
        // 5 days in millis, negated for SUB.
}
        OperandTypes.VARIADIC,
        RexNode microInterval = rexBuilder.makeIntervalLiteral(
     * isthmus surfaces a binding failure rather than producing a malformed interval.
import org.apache.calcite.sql.SqlIntervalQualifier;
        assertEquals(-5L * 86_400_000L, signed);
        RexNode daysCol = rexBuilder.makeInputRef(i64, 1);
        RexNode tsCol = rexBuilder.makeInputRef(tsType, 0);
        RexNode tsCol = rexBuilder.makeInputRef(tsType, 0);
    /**
        RexNode adapted = new DateAddSubAdapter(true).adapt(original, List.of(), cluster);
        assertEquals(-86_400.0, ((org.apache.calcite.rex.RexLiteral) multiply.getOperands().get(1)).getValueAs(Double.class), 0.0);
        RexCall original = (RexCall) rexBuilder.makeCall(ADDDATE_OP, List.of(dateCol, oneInt));
     * millisecond-resolution so the adapter cannot represent a µs increment. The adapter returns
        RelDataType dateType = typeFactory.createSqlType(SqlTypeName.DATE);
    }
    }
        // 1970-01-02 = 1 day after epoch → baseSec = 86400.
     */
import org.opensearch.test.OpenSearchTestCase;
        RexNode adapted = new DateAddSubAdapter(true).adapt(original, List.of(), cluster);
        );
        RexCall original = (RexCall) rexBuilder.makeCall(DATE_ADD_OP, List.of(timeCol, interval));
    private final RexBuilder rexBuilder = new RexBuilder(typeFactory);
            : (RexCall) adapted;
