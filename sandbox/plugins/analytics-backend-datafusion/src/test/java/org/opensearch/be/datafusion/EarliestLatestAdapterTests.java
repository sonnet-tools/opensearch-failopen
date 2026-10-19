    private final EarliestLatestAdapter.LatestAdapter latestAdapter = new EarliestLatestAdapter.LatestAdapter();
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        RexNode result = earliestAdapter.adapt(buildEarliest("@w0"), List.of(), cluster);
    // ── 'now' / 'now()': just now() symbolic ──────────────────────────────────
    }
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        RexNode result = latestAdapter.adapt(buildLatest("now()"), List.of(), cluster);
        RexCall outer = (RexCall) ((RexCall) result).getOperands().get(1);
    private static void assertCmp(RexNode result, SqlKind expected) {
        RexCall rhs = (RexCall) ((RexCall) result).getOperands().get(1);
    private RelOptCluster cluster;
        RelDataType boolType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BOOLEAN), true);
    }
 * rewrites {@code EARLIEST(literal, ts)} / {@code LATEST(literal, ts)} into the
    private static boolean isNowCall(RexNode node) {
import org.apache.calcite.rex.RexBuilder;
        RexNode lit = rexBuilder.makeLiteral(dsl);
        assertEquals("month", ((RexLiteral) rhs.getOperands().get(0)).getValueAs(String.class));
        timestampType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 3), true);
 * side a now()-symbolic expression (or a TIMESTAMP_LITERAL for absolute-time
        );
import org.apache.calcite.rex.RexCall;
 */
        assertEquals("result must be the bare >= comparison, not a CAST", SqlKind.GREATER_THAN_OR_EQUAL, result.getKind());
        RexNode result = earliestAdapter.adapt(buildEarliest("@y"), List.of(), cluster);
import org.apache.calcite.sql.SqlKind;
        // or DATETIME_PLUS(date_trunc('day', now()), INTERVAL_DAY -N) for some N.
        RexCall inner = (RexCall) outer.getOperands().get(0);
import org.apache.calcite.sql.type.ReturnTypes;
        earliestUdf = makeUdf("EARLIEST");
            typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true),
     * rejects. The adapter must return the bare comparison; result type equals call type modulo
    // ── Weekday snap: date_trunc('day', now()) - <diff> days ──────────────────
        RelDataType boolType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BOOLEAN), true);
     * {@code makeCast} would emit a pure-nullability cast, which Calcite's {@code Filter.isValid}
                return;
    }
        );
        typeFactory = new JavaTypeFactoryImpl();
 * this file be licensed under the Apache-2.0 license or a
            1
     */
    // ── Pure offset: DATETIME_PLUS(now(), INTERVAL ...) ───────────────────────
                "inner of weekday snap must be date_trunc('day', now())",
        // RexInputRef ($0) typed as TIMESTAMP — stand-in for the @timestamp column.
        assertCmp(result, SqlKind.GREATER_THAN_OR_EQUAL);
    }
        RexNode result = earliestAdapter.adapt(call, List.of(), cluster);
        RexNode rhs = ((RexCall) result).getOperands().get(1);
        RexNode result = earliestAdapter.adapt(buildEarliest("now"), List.of(), cluster);
    }
    }
    private RexBuilder rexBuilder;
        RexNode result = earliestAdapter.adapt(buildEarliest("2024-01-15"), List.of(), cluster);
    }
        assertTrue(rhs instanceof RexLiteral);
        assertWeekdaySnapShape(rhs);
        RexNode result = earliestAdapter.adapt(buildEarliest("-1mon"), List.of(), cluster);
import java.util.List;
            "inner RHS must be INTERVAL literal",
        super.setUp();
        // -1q == -3 months, emitted as INTERVAL_MONTH literal of value -3.
 * Unit tests for {@link EarliestLatestAdapter}. Verifies the adapter
        RexNode result = earliestAdapter.adapt(original, List.of(), cluster);
    public void testNegativeOffsetDays() {
    }
            return;
    // ── Mixed: chunks compose ─────────────────────────────────────────────────
        assertTrue("expected RexCall, got " + result, result instanceof RexCall);
                // diff == 0 case
package org.opensearch.be.datafusion;
        assertTrue(
    }
    public void testSnapQuarterUsesDateTrunc() {
 * expected RexNode shape — the comparison operator on the outside, the right-hand
     * Regression: with NOT NULL timestamp + NOT NULL folded RHS, the comparison's natural type is
     * {@code BOOLEAN NOT NULL} but the call was declared {@code BOOLEAN NULLABLE}. Pinning back via
    public void testPositiveOffsetMinutes() {
        assertEquals(SqlKind.PLUS, rhs.getKind());
        tsRef = rexBuilder.makeInputRef(timestampType, 0);
        assertSame("parse failure must short-circuit to the original call", original, result);
            if (call.getOperator().getName().equals("date_trunc")) {
            SqlKind.OTHER_FUNCTION,
    public void testWeekdaySnapWBareIsSundayShape() {
    @Override
        RexNode result = earliestAdapter.adapt(buildEarliest("@mon"), List.of(), cluster);
    public void setUp() throws Exception {
        RexNode result = latestAdapter.adapt(buildLatest("2024-01-15 12:00:00"), List.of(), cluster);
        assertEquals("day", ((RexLiteral) rhs.getOperands().get(0)).getValueAs(String.class));
        RexNode result = earliestAdapter.adapt(buildEarliest("-1mon-2d"), List.of(), cluster);
        RexCall original = (RexCall) rexBuilder.makeCall(boolType, earliestUdf, List.of(varcharRef, tsRef));
     *   DATETIME_PLUS(date_trunc('day', now()), INTERVAL N DAY)
        assertTrue(isNowCall(inner.getOperands().get(0)));
    public void testUnparseableLiteralFallsBack() {
        assertSame("non-literal first arg must short-circuit to the original call", original, result);
        assertTrue("expected niladic now() on RHS, got " + rhs, isNowCall(rhs));
    private RexCall buildLatest(String dsl) {
    // ── Absolute literal: emits TIMESTAMP_LITERAL, no symbolic now() ───────────
    }
    }
    }
import org.apache.calcite.sql.type.SqlTypeUtil;
    }
    }
import org.apache.calcite.rel.type.RelDataTypeFactory;
        assertEquals("year", ((RexLiteral) rhs.getOperands().get(0)).getValueAs(String.class));
        RelDataType notNullTs = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 3), false);
    }
        assertTrue(isNowCall(rhs.getOperands().get(0)));
    }
import org.apache.calcite.rex.RexLiteral;
            SqlTypeUtil.equalSansNullability(typeFactory, result.getType(), call.getType())
        assertEquals("date_trunc", rhs.getOperator().getName());
        RexNode rhs = ((RexCall) result).getOperands().get(1);
        cluster = RelOptCluster.create(planner, rexBuilder);
 *
        assertFalse("comparison must be NOT NULL when both operands are NOT NULL", result.getType().isNullable());
            assertTrue(
    public void testNowEmitsBareNow() {
 */
    public void testNonLiteralFirstArgIsLeftAlone() {
        return (RexCall) rexBuilder.makeCall(boolType, earliestUdf, List.of(lit, tsRef));
            new SqlIdentifier(name, SqlParserPos.ZERO),
    private SqlUserDefinedFunction makeUdf(String name) {
        return new SqlUserDefinedFunction(
        RexNode result = earliestAdapter.adapt(buildEarliest("-1q"), List.of(), cluster);
        RexNode result = earliestAdapter.adapt(buildEarliest("@w"), List.of(), cluster);
        // @w1 (Monday). Either date_trunc('day', now()) directly (if today is Monday)
        assertEquals(SqlTypeName.TIMESTAMP, rhs.getType().getSqlTypeName());
        assertTrue("inner LHS must be now()", isNowCall(rhs.getOperands().get(0)));
        assertCmp(result, SqlKind.LESS_THAN_OR_EQUAL);
        // so the adapter emits an INTERVAL_MONTH literal.
    public void testMultipleOffsetChunksCompose() {
import org.apache.calcite.sql.parser.SqlParserPos;
                && rhs.getOperands().get(1).getType().getSqlTypeName().getName().startsWith("INTERVAL")
        assertTrue("expected TIMESTAMP_LITERAL on RHS, got " + rhs, rhs instanceof RexLiteral);
                inner instanceof RexCall innerCall && innerCall.getOperator().getName().equals("date_trunc")
            "result type must equal call type modulo nullability",
        assertEquals(expected, result.getKind());
    private static void assertWeekdaySnapShape(RexNode rhs) {
        // call unchanged (defensive; PPL grammar doesn't actually allow this).
        RexNode rhs = ((RexCall) result).getOperands().get(1);
            }
        }
        RexCall rhs = (RexCall) ((RexCall) result).getOperands().get(1);
import org.apache.calcite.sql.validate.SqlUserDefinedFunction;
 * The OpenSearch Contributors require contributions made to
        RexNode result = earliestAdapter.adapt(buildEarliest("-1h@d"), List.of(), cluster);
    public void testSnapDayUsesDateTrunc() {
        RexCall rhs = (RexCall) ((RexCall) result).getOperands().get(1);
        rexBuilder = new RexBuilder(typeFactory);
        assertEquals("quarter", ((RexLiteral) rhs.getOperands().get(0)).getValueAs(String.class));
        RexNode result = earliestAdapter.adapt(buildEarliest("@q"), List.of(), cluster);
        RexNode lit = rexBuilder.makeLiteral(dsl);
        assertEquals(SqlTypeName.INTERVAL_MONTH, interval.getType().getSqlTypeName());
    private RexCall buildEarliest(String dsl) {
 * SPDX-License-Identifier: Apache-2.0
        // -1mon-2d → DATETIME_PLUS(DATETIME_PLUS(now(), INTERVAL -1 MONTH), INTERVAL -2 DAY)
        RexNode rhs = ((RexCall) result).getOperands().get(1);
        assertEquals(SqlTypeName.INTERVAL_MONTH, interval.getType().getSqlTypeName());
        fail("weekday snap RHS must be a RexCall, got " + rhs);
        );
    }
        RexNode result = earliestAdapter.adapt(buildEarliest("@w1"), List.of(), cluster);
            null
        // First arg is a column reference, not a literal — adapter must return the
     */
     * nullability.
        latestUdf = makeUdf("LATEST");
        RexNode notNullTsRef = rexBuilder.makeInputRef(notNullTs, 0);
/**
    public void testMonthOffsetUsesMonthInterval() {
    public void testSnapYearUsesDateTrunc() {
    public void testWeekdaySnapW0SundayIsShifted() {
        assertTrue(
import org.apache.calcite.sql.SqlIdentifier;
        RexNode rhs = ((RexCall) result).getOperands().get(1);
import org.apache.calcite.sql.type.SqlTypeName;
    }
            RexNode inner = call.getOperands().get(0);
    }
    // ── helpers ───────────────────────────────────────────────────────────────
        RexCall inner = (RexCall) rhs.getOperands().get(1);
        assertTrue("precondition: call's declared type must be BOOLEAN NULLABLE", call.getType().isNullable());
            ReturnTypes.BOOLEAN,
/*
    /**
}
            rhs.getOperands().get(1) instanceof RexLiteral
        RexLiteral interval = (RexLiteral) rhs.getOperands().get(1);
        RexCall original = buildEarliest("???totally-bogus");
        RexNode result = earliestAdapter.adapt(buildEarliest("-7d"), List.of(), cluster);
    }
    }
            null,
        assertEquals(SqlKind.PLUS, rhs.getKind());
    public void testQuarterOffsetUsesMonthInterval() {
import org.apache.calcite.rel.type.RelDataType;
    private SqlUserDefinedFunction latestUdf;
        RexNode rhs = ((RexCall) result).getOperands().get(1);
import org.apache.calcite.plan.hep.HepProgramBuilder;
        RelDataType nullableBool = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BOOLEAN), true);
        assertTrue(isNowCall(inner.getOperands().get(0)));
        assertTrue(isNowCall(rhs));
        assertEquals("date_trunc", rhs.getOperator().getName());
 * compatible open source license.
import org.apache.calcite.rex.RexNode;
        assertCmp(result, SqlKind.GREATER_THAN_OR_EQUAL);
    public void testNotNullComparisonAgainstNullableCallReturnsBareComparison() {
        assertWeekdaySnapShape(rhs);
    public void testNowParenthesesEmitsBareNow() {
    /**
        RexCall rhs = (RexCall) ((RexCall) result).getOperands().get(1);
public class EarliestLatestAdapterTests extends OpenSearchTestCase {
            assertEquals(SqlKind.PLUS, call.getKind());
    public void testAbsoluteWithTimeEmitsTimestampLiteral() {
    private final EarliestLatestAdapter.EarliestAdapter earliestAdapter = new EarliestLatestAdapter.EarliestAdapter();
     *   date_trunc('day', now())                              (if diff == 0)
        RelDataType boolType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BOOLEAN), true);
        RexNode interval = rhs.getOperands().get(1);
        // -1h@d → date_trunc('day', DATETIME_PLUS(now(), INTERVAL -1 HOUR))
        RexCall rhs = (RexCall) ((RexCall) result).getOperands().get(1);
    private SqlUserDefinedFunction earliestUdf;
     * or
        RexNode result = earliestAdapter.adapt(original, List.of(), cluster);
    // ── Snap: date_trunc(unit, now()) ─────────────────────────────────────────
     * A weekday snap RHS is either:
        RexCall call = (RexCall) rexBuilder.makeCall(nullableBool, earliestUdf, List.of(rexBuilder.makeLiteral("now"), notNullTsRef));
        assertCmp(result, SqlKind.GREATER_THAN_OR_EQUAL);
    // ── Defensive: malformed first arg ────────────────────────────────────────
    }
    private RelDataTypeFactory typeFactory;
        return node instanceof RexCall call && call.getOperator().getName().equals("now");
    private RelDataType timestampType;
        RexCall rhs = (RexCall) ((RexCall) result).getOperands().get(1);
        assertEquals(SqlKind.PLUS, outer.getKind());
        // @w (no number) is the same as @w0/@w7 (Sunday).
            );
        assertTrue(isNowCall(rhs.getOperands().get(1)));
    }
        );
        RexCall rhs = (RexCall) ((RexCall) result).getOperands().get(1);
    public void testSnapMonthUsesDateTrunc() {
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(SqlKind.PLUS, inner.getKind());
 * literals).
        RexNode result = earliestAdapter.adapt(buildEarliest("@d"), List.of(), cluster);
        RexNode result = earliestAdapter.adapt(buildEarliest("+30m"), List.of(), cluster);
    private RexNode tsRef;
    public void testWeekdaySnapW1IsDayTruncOrShifted() {
        assertEquals("date_trunc", rhs.getOperator().getName());
        RexCall rhs = (RexCall) ((RexCall) result).getOperands().get(1);
    }
        assertEquals(SqlKind.PLUS, rhs.getKind());
    public void testMixedOffsetThenSnap() {
        assertWeekdaySnapShape(rhs);
        if (rhs instanceof RexCall call) {
import org.apache.calcite.plan.RelOptCluster;
    }
        RexNode varcharRef = rexBuilder.makeInputRef(
        assertEquals(SqlKind.PLUS, inner.getKind());
import org.apache.calcite.plan.hep.HepPlanner;
        assertEquals("date_trunc", rhs.getOperator().getName());
        // Month offsets cannot be expressed as millisecond INTERVAL_DAY (month length varies),
        return (RexCall) rexBuilder.makeCall(boolType, latestUdf, List.of(lit, tsRef));
    }
        assertEquals("date_trunc", rhs.getOperator().getName());
    public void testAbsoluteIsoDateEmitsTimestampLiteral() {
        RexNode rhs = ((RexCall) result).getOperands().get(1);
        RexCall rhs = (RexCall) ((RexCall) result).getOperands().get(1);
    }
            null,
