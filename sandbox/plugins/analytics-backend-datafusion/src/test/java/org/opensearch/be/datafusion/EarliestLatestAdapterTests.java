import org.apache.calcite.rex.RexCall;
    @Override  
            SqlKind.OTHER_FUNCTION,  
        RexCall call = (RexCall) rexBuilder.makeCall(nullableBool, earliestUdf, List.of(rexBuilder.makeLiteral("now"), notNullTsRef));
    }
 * rewrites {@code EARLIEST(literal, ts)} / {@code LATEST(literal, ts)} into the  
    }
     */
        RexNode result = earliestAdapter.adapt(buildEarliest("-1mon-2d"), List.of(), cluster);
        assertCmp(result, SqlKind.GREATER_THAN_OR_EQUAL);  
    }  
        assertEquals("quarter", ((RexLiteral) rhs.getOperands().get(0)).getValueAs(String.class));
        assertTrue(isNowCall(rhs.getOperands().get(0)));
    public void testWeekdaySnapWBareIsSundayShape() {
        assertEquals("day", ((RexLiteral) rhs.getOperands().get(0)).getValueAs(String.class));  
 * The OpenSearch Contributors require contributions made to  
            null
        assertEquals(SqlKind.PLUS, outer.getKind());  
        assertEquals("year", ((RexLiteral) rhs.getOperands().get(0)).getValueAs(String.class));  
        RexCall rhs = (RexCall) ((RexCall) result).getOperands().get(1);
        super.setUp();
    }  
 * compatible open source license.
    }
        RexNode result = earliestAdapter.adapt(buildEarliest("@w0"), List.of(), cluster);  
            null,  
     * nullability.
        assertSame("parse failure must short-circuit to the original call", original, result);
        assertTrue("expected TIMESTAMP_LITERAL on RHS, got " + rhs, rhs instanceof RexLiteral);
    private static boolean isNowCall(RexNode node) {  
        assertEquals("date_trunc", rhs.getOperator().getName());
        // @w1 (Monday). Either date_trunc('day', now()) directly (if today is Monday)
        cluster = RelOptCluster.create(planner, rexBuilder);  
        RexNode interval = rhs.getOperands().get(1);
import org.apache.calcite.rex.RexBuilder;
        RexNode result = earliestAdapter.adapt(buildEarliest("-1mon"), List.of(), cluster);
import org.apache.calcite.rex.RexLiteral;  
                // diff == 0 case  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(SqlTypeName.INTERVAL_MONTH, interval.getType().getSqlTypeName());
    }  
        RexNode rhs = ((RexCall) result).getOperands().get(1);
        earliestUdf = makeUdf("EARLIEST");
    // ── Defensive: malformed first arg ────────────────────────────────────────
    // ── Mixed: chunks compose ─────────────────────────────────────────────────
import org.apache.calcite.rel.type.RelDataTypeFactory;  
import org.apache.calcite.sql.validate.SqlUserDefinedFunction;
        // @w (no number) is the same as @w0/@w7 (Sunday).  
        RexLiteral interval = (RexLiteral) rhs.getOperands().get(1);
        RexNode result = earliestAdapter.adapt(call, List.of(), cluster);
        RexNode rhs = ((RexCall) result).getOperands().get(1);  
    public void testNowEmitsBareNow() {  
    public void testMonthOffsetUsesMonthInterval() {
        assertCmp(result, SqlKind.GREATER_THAN_OR_EQUAL);
        RelDataType boolType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BOOLEAN), true);
 * this file be licensed under the Apache-2.0 license or a
     */
    // ── Snap: date_trunc(unit, now()) ─────────────────────────────────────────  
            "inner RHS must be INTERVAL literal",
    }
        RexNode rhs = ((RexCall) result).getOperands().get(1);
        );
    private static void assertCmp(RexNode result, SqlKind expected) {
        assertEquals("result must be the bare >= comparison, not a CAST", SqlKind.GREATER_THAN_OR_EQUAL, result.getKind());  
        assertTrue("inner LHS must be now()", isNowCall(rhs.getOperands().get(0)));
            assertTrue(
        // RexInputRef ($0) typed as TIMESTAMP — stand-in for the @timestamp column.
            new SqlIdentifier(name, SqlParserPos.ZERO),
        assertEquals(SqlKind.PLUS, inner.getKind());
    }
        assertWeekdaySnapShape(rhs);
 */  
        assertTrue(rhs instanceof RexLiteral);
        tsRef = rexBuilder.makeInputRef(timestampType, 0);  
        RexNode result = latestAdapter.adapt(buildLatest("now()"), List.of(), cluster);
        RexNode result = earliestAdapter.adapt(buildEarliest("@mon"), List.of(), cluster);
        RexCall inner = (RexCall) outer.getOperands().get(0);
    // ── Pure offset: DATETIME_PLUS(now(), INTERVAL ...) ───────────────────────
    public void testWeekdaySnapW1IsDayTruncOrShifted() {  
        // call unchanged (defensive; PPL grammar doesn't actually allow this).  
    }  
    public void testSnapYearUsesDateTrunc() {
import org.apache.calcite.plan.RelOptCluster;
 * expected RexNode shape — the comparison operator on the outside, the right-hand
        assertEquals(SqlKind.PLUS, inner.getKind());
 */
        assertTrue(isNowCall(inner.getOperands().get(0)));
        RexCall outer = (RexCall) ((RexCall) result).getOperands().get(1);
    private SqlUserDefinedFunction makeUdf(String name) {  
        rexBuilder = new RexBuilder(typeFactory);
            1  
        RexNode result = earliestAdapter.adapt(buildEarliest("@w1"), List.of(), cluster);  
            );
        }
    }
import org.apache.calcite.plan.hep.HepPlanner;  
        RexNode rhs = ((RexCall) result).getOperands().get(1);
    }
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        // -1h@d → date_trunc('day', DATETIME_PLUS(now(), INTERVAL -1 HOUR))
        RexNode result = earliestAdapter.adapt(buildEarliest("@q"), List.of(), cluster);
    public void testNegativeOffsetDays() {  
    }  
        assertEquals("date_trunc", rhs.getOperator().getName());
/*  
        assertEquals("date_trunc", rhs.getOperator().getName());
    }
        assertTrue(isNowCall(rhs.getOperands().get(1)));
        assertTrue(  
        RexNode rhs = ((RexCall) result).getOperands().get(1);
    public void testNonLiteralFirstArgIsLeftAlone() {
    // ── Weekday snap: date_trunc('day', now()) - <diff> days ──────────────────
    private RexNode tsRef;
            }
import java.util.List;
        assertTrue("precondition: call's declared type must be BOOLEAN NULLABLE", call.getType().isNullable());
    private RelDataTypeFactory typeFactory;
        RexNode result = earliestAdapter.adapt(buildEarliest("-1q"), List.of(), cluster);
    }  
     *   date_trunc('day', now())                              (if diff == 0)
        RexCall original = buildEarliest("???totally-bogus");  
                inner instanceof RexCall innerCall && innerCall.getOperator().getName().equals("date_trunc")
    private RelOptCluster cluster;  
        RexNode notNullTsRef = rexBuilder.makeInputRef(notNullTs, 0);
    private RexBuilder rexBuilder;
import org.apache.calcite.rex.RexNode;
                return;
        return node instanceof RexCall call && call.getOperator().getName().equals("now");
    public void testNotNullComparisonAgainstNullableCallReturnsBareComparison() {  
        RexCall original = (RexCall) rexBuilder.makeCall(boolType, earliestUdf, List.of(varcharRef, tsRef));  
        assertTrue("expected niladic now() on RHS, got " + rhs, isNowCall(rhs));
    // ── helpers ───────────────────────────────────────────────────────────────
            return;  
    public void testMixedOffsetThenSnap() {
     * rejects. The adapter must return the bare comparison; result type equals call type modulo  
        RexNode result = earliestAdapter.adapt(buildEarliest("now"), List.of(), cluster);
    // ── 'now' / 'now()': just now() symbolic ──────────────────────────────────
}  
        RexCall rhs = (RexCall) ((RexCall) result).getOperands().get(1);  
            RexNode inner = call.getOperands().get(0);
        assertWeekdaySnapShape(rhs);
        RexNode varcharRef = rexBuilder.makeInputRef(
        // First arg is a column reference, not a literal — adapter must return the
        RexNode lit = rexBuilder.makeLiteral(dsl);  
 * literals).  
        RexNode result = earliestAdapter.adapt(buildEarliest("-7d"), List.of(), cluster);
import org.apache.calcite.rel.type.RelDataType;
package org.opensearch.be.datafusion;
    private RelDataType timestampType;
        RexNode rhs = ((RexCall) result).getOperands().get(1);  
    private final EarliestLatestAdapter.EarliestAdapter earliestAdapter = new EarliestLatestAdapter.EarliestAdapter();  
    // ── Absolute literal: emits TIMESTAMP_LITERAL, no symbolic now() ───────────
    }  
        timestampType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 3), true);
    }  
    public void testNowParenthesesEmitsBareNow() {
        return (RexCall) rexBuilder.makeCall(boolType, earliestUdf, List.of(lit, tsRef));
    private RexCall buildEarliest(String dsl) {
        RelDataType boolType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BOOLEAN), true);
    }  
    public void testSnapDayUsesDateTrunc() {
        RelDataType boolType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BOOLEAN), true);
     * {@code BOOLEAN NOT NULL} but the call was declared {@code BOOLEAN NULLABLE}. Pinning back via
        RelDataType notNullTs = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 3), false);
        RexCall rhs = (RexCall) ((RexCall) result).getOperands().get(1);
            "result type must equal call type modulo nullability",  
            if (call.getOperator().getName().equals("date_trunc")) {
        RexNode lit = rexBuilder.makeLiteral(dsl);  
    }
        return (RexCall) rexBuilder.makeCall(boolType, latestUdf, List.of(lit, tsRef));
        RexNode result = earliestAdapter.adapt(buildEarliest("2024-01-15"), List.of(), cluster);
    public void testAbsoluteWithTimeEmitsTimestampLiteral() {  
        RexNode result = earliestAdapter.adapt(original, List.of(), cluster);
        RexCall rhs = (RexCall) ((RexCall) result).getOperands().get(1);  
    private static void assertWeekdaySnapShape(RexNode rhs) {  
    }  
        RexCall rhs = (RexCall) ((RexCall) result).getOperands().get(1);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
public class EarliestLatestAdapterTests extends OpenSearchTestCase {
        assertEquals("month", ((RexLiteral) rhs.getOperands().get(0)).getValueAs(String.class));
        RexNode result = earliestAdapter.adapt(buildEarliest("@w"), List.of(), cluster);
        assertTrue(isNowCall(inner.getOperands().get(0)));  
 * Unit tests for {@link EarliestLatestAdapter}. Verifies the adapter
        RexNode result = earliestAdapter.adapt(buildEarliest("+30m"), List.of(), cluster);
        typeFactory = new JavaTypeFactoryImpl();  
    public void testQuarterOffsetUsesMonthInterval() {  
    }
        );
        RexCall inner = (RexCall) rhs.getOperands().get(1);  
        assertCmp(result, SqlKind.LESS_THAN_OR_EQUAL);
    public void testMultipleOffsetChunksCompose() {
     * {@code makeCast} would emit a pure-nullability cast, which Calcite's {@code Filter.isValid}
    public void testSnapQuarterUsesDateTrunc() {  
        if (rhs instanceof RexCall call) {
            SqlTypeUtil.equalSansNullability(typeFactory, result.getType(), call.getType())
        assertTrue(isNowCall(rhs));
import org.apache.calcite.sql.SqlKind;  
        assertEquals("date_trunc", rhs.getOperator().getName());
    /**  
    }
     * A weekday snap RHS is either:
        RexCall rhs = (RexCall) ((RexCall) result).getOperands().get(1);  
     * Regression: with NOT NULL timestamp + NOT NULL folded RHS, the comparison's natural type is  
            ReturnTypes.BOOLEAN,
        assertFalse("comparison must be NOT NULL when both operands are NOT NULL", result.getType().isNullable());
    }
        // Month offsets cannot be expressed as millisecond INTERVAL_DAY (month length varies),  
    public void testPositiveOffsetMinutes() {
     * or  
        assertTrue("expected RexCall, got " + result, result instanceof RexCall);
    private RexCall buildLatest(String dsl) {
                "inner of weekday snap must be date_trunc('day', now())",  
    }
    public void testSnapMonthUsesDateTrunc() {
        assertEquals(SqlTypeName.TIMESTAMP, rhs.getType().getSqlTypeName());  
    private SqlUserDefinedFunction latestUdf;  
            assertEquals(SqlKind.PLUS, call.getKind());  
        fail("weekday snap RHS must be a RexCall, got " + rhs);
        RexNode rhs = ((RexCall) result).getOperands().get(1);  
/**
            typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true),
    }  
import org.apache.calcite.sql.parser.SqlParserPos;
        assertEquals(SqlTypeName.INTERVAL_MONTH, interval.getType().getSqlTypeName());  
        RexNode result = earliestAdapter.adapt(buildEarliest("@d"), List.of(), cluster);  
        RexCall rhs = (RexCall) ((RexCall) result).getOperands().get(1);  
        RexNode result = earliestAdapter.adapt(buildEarliest("-1h@d"), List.of(), cluster);  
                && rhs.getOperands().get(1).getType().getSqlTypeName().getName().startsWith("INTERVAL")  
        assertWeekdaySnapShape(rhs);  
            null,
        // so the adapter emits an INTERVAL_MONTH literal.
        );
        assertEquals(expected, result.getKind());  
        // or DATETIME_PLUS(date_trunc('day', now()), INTERVAL_DAY -N) for some N.
    }
 *
    private final EarliestLatestAdapter.LatestAdapter latestAdapter = new EarliestLatestAdapter.LatestAdapter();
        assertEquals(SqlKind.PLUS, rhs.getKind());
        RexCall rhs = (RexCall) ((RexCall) result).getOperands().get(1);  
    private SqlUserDefinedFunction earliestUdf;
    public void testWeekdaySnapW0SundayIsShifted() {
    public void testAbsoluteIsoDateEmitsTimestampLiteral() {
import org.apache.calcite.plan.hep.HepProgramBuilder;
    }  
        // -1mon-2d → DATETIME_PLUS(DATETIME_PLUS(now(), INTERVAL -1 MONTH), INTERVAL -2 DAY)  
import org.apache.calcite.sql.type.ReturnTypes;
        latestUdf = makeUdf("LATEST");  
        assertCmp(result, SqlKind.GREATER_THAN_OR_EQUAL);
    public void setUp() throws Exception {
            rhs.getOperands().get(1) instanceof RexLiteral
        assertEquals("date_trunc", rhs.getOperator().getName());  
import org.opensearch.test.OpenSearchTestCase;  
        RelDataType nullableBool = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BOOLEAN), true);  
import org.apache.calcite.sql.SqlIdentifier;
        return new SqlUserDefinedFunction(
        RexNode result = latestAdapter.adapt(buildLatest("2024-01-15 12:00:00"), List.of(), cluster);
        assertEquals(SqlKind.PLUS, rhs.getKind());
        // -1q == -3 months, emitted as INTERVAL_MONTH literal of value -3.
    public void testUnparseableLiteralFallsBack() {
     *   DATETIME_PLUS(date_trunc('day', now()), INTERVAL N DAY)
    /**
        RexNode result = earliestAdapter.adapt(original, List.of(), cluster);
 * side a now()-symbolic expression (or a TIMESTAMP_LITERAL for absolute-time
        RexCall rhs = (RexCall) ((RexCall) result).getOperands().get(1);
        );
        assertEquals(SqlKind.PLUS, rhs.getKind());
        RexNode result = earliestAdapter.adapt(buildEarliest("@y"), List.of(), cluster);  
import org.apache.calcite.sql.type.SqlTypeName;  
import org.apache.calcite.sql.type.SqlTypeUtil;
        assertSame("non-literal first arg must short-circuit to the original call", original, result);
    }  
        assertTrue(
