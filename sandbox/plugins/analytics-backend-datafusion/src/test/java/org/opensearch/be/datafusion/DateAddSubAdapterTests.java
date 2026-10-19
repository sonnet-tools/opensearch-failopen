    private static final SqlFunction SUBDATE_OP = new SqlFunction(
        RexCall original = (RexCall) rexBuilder.makeCall(ADDDATE_OP, List.of(dateLit, daysCol));
        assertTrue(SqlTypeName.INTERVAL_TYPES.contains(shiftedInterval.getType().getSqlTypeName()));  
        RexCall original = (RexCall) rexBuilder.makeCall(ADDDATE_OP, List.of(dateCol, intCol));
        RexCall original = (RexCall) rexBuilder.makeCall(DATE_ADD_OP, List.of(tsCol, microInterval));  
package org.opensearch.be.datafusion;
        RexNode timeCol = rexBuilder.makeInputRef(timeType, 0);
        RexCall original = (RexCall) rexBuilder.makeCall(ADDDATE_OP, List.of(tsLit, daysCol));
    private final RexBuilder rexBuilder = new RexBuilder(typeFactory);
        RexCall fromUnixtime = unwrapCast(adapted);  
        RexNode daysCol = rexBuilder.makeInputRef(i64, 0);  
    private final RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
public class DateAddSubAdapterTests extends OpenSearchTestCase {
    private static final SqlFunction DATE_ADD_OP = new SqlFunction(
    );
    private final RelOptCluster cluster = RelOptCluster.create(new VolcanoPlanner(), rexBuilder);
    /** ADDDATE(DATE-col, 1) → DATETIME_PLUS(CAST(date AS …), INTERVAL 1 DAY). The integer 1 is rebuilt as a DAY interval. */
    );
            BigDecimal.valueOf(1L),  
        RexCall original = (RexCall) rexBuilder.makeCall(SUBDATE_OP, List.of(epochCharLit, daysCol));
    public void testAddDateCharLiteralBaseWithComputedI64DaysLowersToFromUnixtime() {  
            : (RexCall) adapted;
        RexCall castNode = (RexCall) outer.getOperands().get(0);
    }
        RexNode mod = rexBuilder.makeCall(SqlStdOperatorTable.MOD, daysCol, rexBuilder.makeLiteral(7, i64, false));
            : (RexCall) adapted;  
    private static RexCall unwrapCast(RexNode node) {
            new SqlIntervalQualifier(TimeUnit.MICROSECOND, null, SqlParserPos.ZERO)
        RexNode adapted = new DateAddSubAdapter(false).adapt(original, List.of(), cluster);
        RelDataType i64 = typeFactory.createSqlType(SqlTypeName.BIGINT);  
        assertEquals(86_400.0, ((org.apache.calcite.rex.RexLiteral) plus.getOperands().get(0)).getValueAs(Double.class), 0.0);
    );
        RexNode microInterval = rexBuilder.makeIntervalLiteral(
        RexCall plus = (RexCall) fromUnixtime.getOperands().get(0);
        assertEquals("||", concat.getOperator().getName());
import org.apache.calcite.rex.RexCall;
import org.opensearch.test.OpenSearchTestCase;
        // First operand is CAST(CONCAT(today,' ',CAST(time AS VARCHAR)) AS TIMESTAMP).  
        assertSame(SqlStdOperatorTable.PLUS, plus.getOperator());
        SqlKind.OTHER_FUNCTION,  
        // INTERVAL DAY values are stored in millis after the unit-rebuild step; +1 day = +86400000.
        RexNode adapted = new DateAddSubAdapter(true).adapt(original, List.of(), cluster);
        assertSame(SqlStdOperatorTable.DATETIME_PLUS, outer.getOperator());
            ? (RexCall) ((RexCall) adapted).getOperands().get(0)
    public void testAddDateNonLiteralBaseWithI64DaysPassesThrough() {
        "ADDDATE",
 * SPDX-License-Identifier: Apache-2.0
     * ADDDATE('1970-01-01', daysExpr) — bin span=Nday lowering shape. Second operand is computed
    /**
        RexCall fromUnixtime = unwrapCast(adapted);
 *
    /** SUBDATE('1970-01-01', i64Expr) — sign-flipped multiplier (-86400). */  
    public void testSubDateIntegerDaysFoldsSign() {
        RelDataType i64 = typeFactory.createSqlType(SqlTypeName.BIGINT);
        RelDataType dateType = typeFactory.createSqlType(SqlTypeName.DATE);
    /**  
        OperandTypes.VARIADIC,  
        long signed = ((org.apache.calcite.rex.RexLiteral) shiftedInterval).getValueAs(Long.class);  
        RelDataType i64 = typeFactory.createSqlType(SqlTypeName.BIGINT);
     * {@code from_unixtime(baseEpochSec + daysExpr * 86400.0)} where baseEpochSec=0.
     * millisecond-resolution so the adapter cannot represent a µs increment. The adapter returns
        RexNode adapted = new DateAddSubAdapter(true).adapt(original, List.of(), cluster);
     */
        SqlKind.OTHER_FUNCTION,  
        RexNode daysExpr = rexBuilder.makeCall(SqlStdOperatorTable.MINUS, daysCol, mod);
 * The OpenSearch Contributors require contributions made to  
        null,
    private static final SqlFunction ADDDATE_OP = new SqlFunction(
        assertSame(SqlStdOperatorTable.MULTIPLY, multiply.getOperator());
    /** DATE_ADD(TIME-col, INTERVAL 1 DAY) → DATETIME_PLUS(CAST(CONCAT(today,' ',CAST time AS VARCHAR)) AS TIMESTAMP), 86400000 millis). */
     * Non-literal second operand (an integer column ref, not a literal) cannot be normalized to an
    public void testAddDateNonLiteralSecondOperandPassesThrough() {  
        ReturnTypes.TIMESTAMP,
        RexNode tsCol = rexBuilder.makeInputRef(tsType, 0);
        RexCall fromUnixtime = unwrapCast(adapted);
        RelDataType dateType = typeFactory.createSqlType(SqlTypeName.DATE);
    }
import org.apache.calcite.rel.type.RelDataType;
    }
import org.apache.calcite.rel.type.RelDataTypeFactory;  
 */  
import org.apache.calcite.plan.volcano.VolcanoPlanner;
import java.math.BigDecimal;  
        RexCall plus = (RexCall) fromUnixtime.getOperands().get(0);
    }
        RexCall plus = (RexCall) fromUnixtime.getOperands().get(0);
        long signed = ((org.apache.calcite.rex.RexLiteral) outer.getOperands().get(1)).getValueAs(Long.class);
     * the original call so the engine surfaces a loud error rather than silently truncating.  
        RexCall outer = adapted instanceof RexCall && ((RexCall) adapted).getKind() == SqlKind.CAST
        RexNode oneInt = rexBuilder.makeLiteral(1, typeFactory.createSqlType(SqlTypeName.INTEGER), false);
        null,
        RexNode adapted = new DateAddSubAdapter(true).adapt(original, List.of(), cluster);
        RexCall plus = (RexCall) fromUnixtime.getOperands().get(0);
        // Inner expr: PLUS(baseSec=0.0, MULTIPLY(CAST(daysExpr AS DOUBLE), 86400.0))  
    public void testAddDateTimestampLiteralBaseFoldsViaMillisDiv1000() {  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        RelDataType tsType = typeFactory.createSqlType(SqlTypeName.TIMESTAMP);  
        RexNode adapted = new DateAddSubAdapter(true).adapt(original, List.of(), cluster);
/** Covers {@link DateAddSubAdapter}: TIME base anchors to today UTC; integer-days form rebuilds as INTERVAL DAY. */  
import org.apache.calcite.rex.RexBuilder;
        assertEquals(86_400_000L, signed);
import org.apache.calcite.sql.type.OperandTypes;
        ReturnTypes.TIMESTAMP,
    /** TIMESTAMP-literal base folds via millis ÷ 1000. */
    /** Unwrap an outer CAST around the from_unixtime call (return-type alignment). */
        RexNode daysCol = rexBuilder.makeInputRef(i64, 0);  
        SqlKind.OTHER_FUNCTION,  
        RexCall concat = (RexCall) castNode.getOperands().get(0);  
    /** Non-foldable base (column ref, not literal) with computed i64 days passes through. */  
        RexNode adapted = new DateAddSubAdapter(true).adapt(original, List.of(), cluster);
        RexNode dateLit = rexBuilder.makeDateLiteral(new org.apache.calcite.util.DateString("1970-01-02"));
        "DATE_ADD",
     * (MOD-based subtract on an integer column ref), not a literal. Adapter must lower to  
}
        RexNode daysCol = rexBuilder.makeInputRef(i64, 0);
        RexNode dateCol = rexBuilder.makeInputRef(dateType, 0);  
        RelDataType i64 = typeFactory.createSqlType(SqlTypeName.BIGINT);
        // Outer DATETIME_PLUS (or CAST wrapping it).
     * INTERVAL by {@code asIntervalLiteral} — the adapter must pass the call through unchanged so  
        ReturnTypes.TIMESTAMP,
/*  
        RelDataType i64 = typeFactory.createSqlType(SqlTypeName.BIGINT);  
        assertEquals("from_unixtime", fromUnixtime.getOperator().getName());
        RexCall multiply = (RexCall) plus.getOperands().get(1);  
        assertSame(SqlStdOperatorTable.DATETIME_PLUS, outer.getOperator());
import org.apache.calcite.sql.SqlFunctionCategory;
    }
        SqlFunctionCategory.TIMEDATE
        assertEquals(1.0, ((org.apache.calcite.rex.RexLiteral) plus.getOperands().get(0)).getValueAs(Double.class), 0.0);  
            ? (RexCall) ((RexCall) adapted).getOperands().get(0)
        assertEquals("from_unixtime", fromUnixtime.getOperator().getName());  
        assertEquals(86_400.0, ((org.apache.calcite.rex.RexLiteral) multiply.getOperands().get(1)).getValueAs(Double.class), 0.0);  
        if (node instanceof RexCall call && call.getKind() == SqlKind.CAST) {  
    }
    public void testAddDateIntegerDaysOnDateRebuiltAsIntervalDay() {
        null,
        RexCall original = (RexCall) rexBuilder.makeCall(SUBDATE_OP, List.of(tsCol, fiveInt));  
    /**
            ? (RexCall) ((RexCall) adapted).getOperands().get(0)  
        RexNode epochCharLit = rexBuilder.makeLiteral("1970-01-01");  
        RexNode tsCol = rexBuilder.makeInputRef(tsType, 0);
        RelDataType timeType = typeFactory.createSqlType(SqlTypeName.TIME);  
        RelDataType dateType = typeFactory.createSqlType(SqlTypeName.DATE);  
        assertEquals("from_unixtime", fromUnixtime.getOperator().getName());
        RexCall original = (RexCall) rexBuilder.makeCall(DATE_ADD_OP, List.of(timeCol, interval));  
     * isthmus surfaces a binding failure rather than producing a malformed interval.
     */
import org.apache.calcite.sql.SqlKind;
import org.apache.calcite.sql.parser.SqlParserPos;  
    public void testDateAddTimeOperandAnchoredToToday() {
        // 5 days in millis, negated for SUB.  
        RexCall original = (RexCall) rexBuilder.makeCall(ADDDATE_OP, List.of(epochCharLit, daysExpr));  
        RexCall outer = adapted instanceof RexCall && ((RexCall) adapted).getKind() == SqlKind.CAST
        RexNode adapted = new DateAddSubAdapter(true).adapt(original, List.of(), cluster);  
        RexNode adapted = new DateAddSubAdapter(false).adapt(original, List.of(), cluster);
import org.apache.calcite.sql.SqlFunction;
        OperandTypes.VARIADIC,  
        SqlFunctionCategory.TIMEDATE
        }
        RexCall original = (RexCall) rexBuilder.makeCall(ADDDATE_OP, List.of(dateCol, oneInt));  
        RexCall multiply = (RexCall) plus.getOperands().get(1);
        assertEquals(0.0, ((org.apache.calcite.rex.RexLiteral) plus.getOperands().get(0)).getValueAs(Double.class), 0.0);  
     */
        RexNode tsLit = rexBuilder.makeTimestampLiteral(new org.apache.calcite.util.TimestampString("1970-01-01 00:00:01"), 0);  
        RexNode adapted = new DateAddSubAdapter(true).adapt(original, List.of(), cluster);
        assertSame("MICROSECOND interval must leave the call unchanged", original, adapted);
        RexNode dateCol = rexBuilder.makeInputRef(dateType, 0);
            : (RexCall) adapted;  
            BigDecimal.valueOf(500),  
 * compatible open source license.
            return (RexCall) call.getOperands().get(0);
import org.apache.calcite.rex.RexNode;  
        return (RexCall) node;  
        RexCall outer = adapted instanceof RexCall && ((RexCall) adapted).getKind() == SqlKind.CAST
import org.apache.calcite.plan.RelOptCluster;  
    }
        RexNode daysCol = rexBuilder.makeInputRef(i64, 0);
        RexCall original = (RexCall) rexBuilder.makeCall(ADDDATE_OP, List.of(dateCol, daysCol));  
import java.util.List;
        RexNode adapted = new DateAddSubAdapter(true).adapt(original, List.of(), cluster);
import org.apache.calcite.sql.type.SqlTypeName;  
        RexNode fiveInt = rexBuilder.makeLiteral(5, typeFactory.createSqlType(SqlTypeName.INTEGER), false);
    public void testSubDateCharLiteralBaseWithI64DaysFlipsMultiplierSign() {
    }  
        assertEquals(-86_400.0, ((org.apache.calcite.rex.RexLiteral) multiply.getOperands().get(1)).getValueAs(Double.class), 0.0);
        // 1970-01-02 = 1 day after epoch → baseSec = 86400.
        assertEquals(-5L * 86_400_000L, signed);
        RexNode daysCol = rexBuilder.makeInputRef(i64, 1);
    public void testDateAddMicrosecondIntervalPassesThrough() {
        SqlFunctionCategory.TIMEDATE
        RelDataType tsType = typeFactory.createSqlType(SqlTypeName.TIMESTAMP);  
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        RexNode shiftedInterval = outer.getOperands().get(1);
        assertEquals("from_unixtime", fromUnixtime.getOperator().getName());
        RexNode dateCol = rexBuilder.makeInputRef(dateType, 0);
        assertEquals(SqlKind.CAST, castNode.getKind());
        OperandTypes.VARIADIC,  
    }
            new SqlIntervalQualifier(TimeUnit.DAY, null, SqlParserPos.ZERO)
        assertSame(SqlStdOperatorTable.DATETIME_PLUS, outer.getOperator());
        RexCall fromUnixtime = unwrapCast(adapted);  
        "SUBDATE",
    public void testAddDateDateLiteralBaseFoldsViaDaysTimes86400() {
        assertEquals(TimeUnit.DAY, shiftedInterval.getType().getIntervalQualifier().getUnit());
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RexNode interval = rexBuilder.makeIntervalLiteral(
import org.apache.calcite.sql.type.ReturnTypes;
        assertSame("non-literal second operand must leave the call unchanged", original, adapted);  
    /** DATE-literal base folds to epoch-seconds via days × 86400. */
     * MICROSECOND interval falls through to the UDF path — Arrow's IntervalDayTime is
import org.apache.calcite.avatica.util.TimeUnit;
        RexNode intCol = rexBuilder.makeInputRef(intType, 1);
    }
    }
        assertSame("non-foldable base must leave the call unchanged", original, adapted);
        );
        // 1970-01-01 00:00:01 UTC → baseSec = 1.
        RexNode epochCharLit = rexBuilder.makeLiteral("1970-01-01");
 * this file be licensed under the Apache-2.0 license or a
    /** SUBDATE(TIMESTAMP-col, 5) → DATETIME_PLUS(ts, INTERVAL -5 DAY). Sign folded for SUB. */
import org.apache.calcite.sql.SqlIntervalQualifier;  
        );
