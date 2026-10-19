            e.getMessage().contains("unsupported format")
        RexCall inner = (RexCall) ((RexCall) wrapped).getOperands().get(0);
        RexCall adapted = (RexCall) DatePartAdapters.day().adapt(original, List.of(), cluster);
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(literal));
        RexNode wrapped = adapted.getOperands().get(1);
    /** Coerced CAST preserves operand nullability so the outer call's nullable return type stays consistent. */
            OperandTypes.ANY,
        assertInvalidLiteralRejected("16:00:61"); // bare time, second out of range
    }
            "HOUR",
        assertEquals(SqlKind.CAST, ((RexCall) wrapped).getKind());
        assertEquals("doy", ((RexLiteral) adaptedDoy.getOperands().get(0)).getValueAs(String.class));
        assertEquals(SqlKind.CAST, ((RexCall) wrapped).getKind());
        assertEquals("||", inner.getOperator().getName());
        RexNode literal = rexBuilder.makeLiteral("17:30:00", varcharType, true);
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
            null,
    }
    }
        RexCall adapted = (RexCall) DatePartAdapters.hour().adapt(original, List.of(), cluster);
        RexCall adapted = (RexCall) DatePartAdapters.day().adapt(original, List.of(), cluster);
        assertEquals("year", ((RexLiteral) adaptedYear.getOperands().get(0)).getValueAs(String.class));
public class DatePartAdaptersTests extends OpenSearchTestCase {
        assertEquals(SqlKind.CAST, ((RexCall) adapted.getOperands().get(1)).getKind());
        );
/*
import org.apache.calcite.sql.fun.SqlLibraryOperators;
        RexCall cast = (RexCall) wrapped;
     */
    }
        RexNode ts = rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), 0);
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(field));
     * does not survive Flight RPC serialization on the worker→coordinator hop.
        assertEquals(2, adapted.getOperands().size());
    /** VARCHAR operand is wrapped in {@code CAST(_ AS TIMESTAMP)}. */
 * the rewritten {@code date_part('day', CAST(_ AS TIMESTAMP))} resolves against
            null,
        IllegalArgumentException e = expectThrows(
        RelDataType timeType = typeFactory.createSqlType(SqlTypeName.TIME);
import java.util.List;
        RexNode adapted = DatePartAdapters.hour().adapt(original, List.of(), cluster);
    public void testCastPreservesNullability() {
    }
        RexCall adaptedQuarter = (RexCall) DatePartAdapters.quarter().adapt(original, List.of(), cluster);
import org.apache.calcite.rex.RexCall;
    /** Cluster B: TIME column → CONCAT(today,' ',CAST AS VARCHAR) → CAST AS TIMESTAMP. */
 *
            SqlFunctionCategory.TIMEDATE
     * Invalid string literals (month 13, second 61, garbage) must throw at plan time so the
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(literal));
    public void testCharOperandIsCastToTimestamp() {
    /** PPL-style nullary-arg DAY operator stand-in; the adapter only inspects the operand types. */
    public void testNullVarcharLiteralPassesThrough() {
            null,
            SqlKind.OTHER_FUNCTION,
        assertInvalidLiteralRejected("not-a-date");
        assertInvalidLiteralRejected("2025-12-01 15:02:61"); // second out of range
        // Must not throw despite the value being unknown at plan time.
 * that wraps bare-string PPL call shapes (e.g. {@code DAY('2020-09-16')}) so
import org.apache.calcite.sql.type.OperandTypes;
    }
import org.opensearch.test.OpenSearchTestCase;
            OperandTypes.ANY,
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(literal));
 * compatible open source license.
    public void testHourOfTimeLiteralFoldsToInt() {
    /** PPL-style nullary-arg HOUR operator stand-in. */
        RexNode ts = rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), 0);
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(ts));
        assertTrue("VARCHAR operand must be wrapped", wrapped instanceof RexCall);
            ReturnTypes.explicit(timeType),
        RelDataType timeType = typeFactory.createSqlType(SqlTypeName.TIME);
            ReturnTypes.INTEGER_NULLABLE,
import org.apache.calcite.rex.RexNode;
    public void testVarcharCoercionWithHourUnit() {
            "message must contain 'unsupported format' for input [" + value + "], got: " + e.getMessage(),
    private void assertInvalidLiteralRejected(String value) {
        assertInvalidLiteralRejected("2025-13-02"); // month out of range
        SqlFunction toTimeOp = new SqlFunction(
        assertEquals("||", castedExpr.getOperator().getName());
        RexNode strLit = rexBuilder.makeLiteral("17:30:00", varcharType, true);
            SqlFunctionCategory.TIMEDATE
        RexCall adapted = (RexCall) DatePartAdapters.day().adapt(original, List.of(), cluster);
        assertEquals("rewrite must use CAST", SqlKind.CAST, cast.getKind());
        RexNode nullLit = rexBuilder.makeNullLiteral(nullableVarchar);
import org.apache.calcite.rel.type.RelDataType;
        RexNode literal = rexBuilder.makeLiteral("2020-09-16", varcharType, true);
        assertTrue("message must echo the offending input [" + value + "]", e.getMessage().contains(value));
        RexNode field = rexBuilder.makeInputRef(nullableVarchar, 0);
        assertSame(SqlLibraryOperators.DATE_PART, adapted.getOperator());
import org.apache.calcite.sql.SqlFunction;
        );
        return new SqlFunction(
package org.opensearch.be.datafusion;
        assertSame("TIMESTAMP operand must not be wrapped in CAST", ts, adapted.getOperands().get(1));
        assertSame(SqlTypeName.TIMESTAMP, cast.getType().getSqlTypeName());
        RexCall adaptedDoy = (RexCall) DatePartAdapters.dayOfYear().adapt(original, List.of(), cluster);
            ReturnTypes.INTEGER_NULLABLE,
        assertTrue("CAST output must remain nullable", adapted.getOperands().get(1).getType().isNullable());
    /** Cluster B: bare-time string {@code '17:30:00'} → CONCAT(today,' ',s) → CAST AS TIMESTAMP. */
        // Inside the CAST: a CONCAT wrapping the original TIME (cast to VARCHAR).
import org.apache.calcite.sql.SqlKind;
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(field));
    public void testTimestampOperandPassesThrough() {
            SqlKind.OTHER_FUNCTION,
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.sql.type.ReturnTypes;
    }
        RexCall adapted = (RexCall) DatePartAdapters.day().adapt(original, List.of(), cluster);
import org.apache.calcite.sql.type.SqlTypeName;
    }
        RelDataType nullableVarchar = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
 * the {@code (string, precision_timestamp<P>)} signature in
        RexCall adapted = (RexCall) DatePartAdapters.day().adapt(original, List.of(), cluster);
        assertSame(SqlLibraryOperators.DATE_PART, adapted.getOperator());
    public void testBareTimeStringAnchoredToToday() {
            IllegalArgumentException.class,
import org.apache.calcite.rel.type.RelDataTypeFactory;
        RexNode wrapped = adapted.getOperands().get(1);
        assertEquals("day", ((RexLiteral) adapted.getOperands().get(0)).getValueAs(String.class));
    }
import org.apache.calcite.rex.RexBuilder;
    private final RexBuilder rexBuilder = new RexBuilder(typeFactory);
    public void testDateOperandPassesThrough() {
    /** Coercion path also works when invoked through the unit factory for a non-default unit. */
 */
    /** TIMESTAMP operand passes through unchanged — the original two-arg shape from the parent. */
/**
    /** DATE operand passes through unchanged — the {@code (string, date)} impl handles it. */
        RexNode literal = rexBuilder.makeLiteral("2020-09-16 17:30:00", varcharType, true);
    }
        assertSame(SqlTypeName.TIMESTAMP, wrapped.getType().getSqlTypeName());
 * SPDX-License-Identifier: Apache-2.0
            SqlKind.OTHER_FUNCTION,
        RexCall adaptedYear = (RexCall) DatePartAdapters.year().adapt(original, List.of(), cluster);
 * Unit tests for {@link DatePartAdapters}. Covers the VARCHAR-operand coercion
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(nullLit));
        RexCall adapted = (RexCall) DatePartAdapters.day().adapt(original, List.of(), cluster);
    private SqlFunction pplDay() {
        assertEquals(SqlTypeName.INTEGER, adapted.getType().getSqlTypeName());
    private SqlFunction pplHour() {
    /** CHAR (fixed-width) operand is also coerced — both are SqlTypeFamily.CHARACTER. */
        RexNode wrapped = adapted.getOperands().get(1);
        RexCall adapted = (RexCall) DatePartAdapters.hour().adapt(original, List.of(), cluster);
        );
        assertEquals("quarter", ((RexLiteral) adaptedQuarter.getOperands().get(0)).getValueAs(String.class));
        );
        assertEquals("hour", ((RexLiteral) adapted.getOperands().get(0)).getValueAs(String.class));
            () -> DatePartAdapters.day().adapt(original, List.of(), cluster)
        RexCall innerToTime = (RexCall) rexBuilder.makeCall(toTimeOp, List.of(strLit));
        RexNode field = rexBuilder.makeInputRef(charType, 0);
    /** HOUR(TIME('17:30:00')) folds to a BIGINT literal at plan time (no substrait sig for (string, precision_time)). */
    }
        RexNode wrapped = adapted.getOperands().get(1);
        RexNode date = rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.DATE), 0);
    public void testInvalidDateLiteralRejectedAtPlanTime() {
            SqlFunctionCategory.TIMEDATE
import org.apache.calcite.rex.RexLiteral;
        RexNode field = rexBuilder.makeInputRef(timeType, 0);
 */
        assertEquals(SqlKind.CAST, ((RexCall) adapted.getOperands().get(1)).getKind());
        RexCall adapted = (RexCall) DatePartAdapters.day().adapt(original, List.of(), cluster);
        assertSame(date, adapted.getOperands().get(1));
        assertEquals(SqlKind.CAST, ((RexCall) wrapped).getKind());
    }
import org.apache.calcite.plan.volcano.VolcanoPlanner;
        RexCall adapted = (RexCall) DatePartAdapters.day().adapt(original, List.of(), cluster);
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        RelDataType charType = typeFactory.createSqlType(SqlTypeName.CHAR, 10);
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(date));
    public void testTimeOperandAnchoredToToday() {
 * The OpenSearch Contributors require contributions made to
        assertSame("inner operand of CAST must be the original literal", literal, cast.getOperands().get(0));
 * {@code opensearch_scalar_functions.yaml}.
        assertNotSame(original, adapted);
        assertTrue(
import org.apache.calcite.sql.SqlFunctionCategory;
        RexNode literal = rexBuilder.makeLiteral(value, varcharType, true);
        RexCall castedExpr = (RexCall) ((RexCall) wrapped).getOperands().get(0);
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
    /** NULL literal passes through — column-value semantics handle null at runtime. */
        assertEquals(SqlKind.OTHER, castedExpr.getKind());
    private final RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
     * legacy "unsupported format" wording reaches the HTTP body. The Arrow CAST kernel error
            OperandTypes.ANY,
}
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(ts));
import org.apache.calcite.plan.RelOptCluster;
        RelDataType nullableVarchar = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
    public void testUnitLiteralPropagatedFromFactory() {
        assertSame(SqlTypeName.TIMESTAMP, wrapped.getType().getSqlTypeName());
            "DAY",
            "to_time",
        return new SqlFunction(
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
    public void testVarcharColumnRefNotValidated() {
    }
    /**
    /** Non-literal VARCHAR (column ref) is not eagerly validated — only literals are. */
        RexNode columnRef = rexBuilder.makeInputRef(varcharType, 0);
    }
        RexCall original = (RexCall) rexBuilder.makeCall(pplHour(), List.of(innerToTime));
        );
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(field));
        // Result: date_part('hour', CAST(CONCAT(today, s) AS TIMESTAMP)).
    /** Each unit factory threads through its own prepended literal. */
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        // Outer node: CAST(_ AS TIMESTAMP).
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(columnRef));
    public void testVarcharLiteralOperandIsCastToTimestamp() {
    }
    }
    private final RelOptCluster cluster = RelOptCluster.create(new VolcanoPlanner(), rexBuilder);
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(literal));
