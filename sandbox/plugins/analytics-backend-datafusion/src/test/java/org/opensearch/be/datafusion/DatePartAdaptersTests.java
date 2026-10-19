            ReturnTypes.INTEGER_NULLABLE,
import java.util.List;
    private final RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(field));
        RexCall cast = (RexCall) wrapped;
        RexNode field = rexBuilder.makeInputRef(timeType, 0);
        RexNode ts = rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), 0);  
        // Inside the CAST: a CONCAT wrapping the original TIME (cast to VARCHAR).
     * Invalid string literals (month 13, second 61, garbage) must throw at plan time so the
        RexCall adapted = (RexCall) DatePartAdapters.day().adapt(original, List.of(), cluster);
 * compatible open source license.
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(field));  
    public void testBareTimeStringAnchoredToToday() {  
import org.apache.calcite.rex.RexBuilder;  
        );
        assertEquals(SqlTypeName.INTEGER, adapted.getType().getSqlTypeName());
    /** DATE operand passes through unchanged — the {@code (string, date)} impl handles it. */
    /** PPL-style nullary-arg DAY operator stand-in; the adapter only inspects the operand types. */
import org.apache.calcite.sql.fun.SqlLibraryOperators;
        assertSame(SqlLibraryOperators.DATE_PART, adapted.getOperator());
    /** TIMESTAMP operand passes through unchanged — the original two-arg shape from the parent. */
    /** VARCHAR operand is wrapped in {@code CAST(_ AS TIMESTAMP)}. */  
        );  
 * The OpenSearch Contributors require contributions made to  
        // Must not throw despite the value being unknown at plan time.
            SqlKind.OTHER_FUNCTION,  
import org.apache.calcite.sql.SqlKind;  
    /**  
    }
 * Unit tests for {@link DatePartAdapters}. Covers the VARCHAR-operand coercion
        RexNode literal = rexBuilder.makeLiteral("17:30:00", varcharType, true);
        assertEquals(SqlKind.CAST, ((RexCall) wrapped).getKind());
     */
            "message must contain 'unsupported format' for input [" + value + "], got: " + e.getMessage(),
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(date));
    /** PPL-style nullary-arg HOUR operator stand-in. */
    public void testHourOfTimeLiteralFoldsToInt() {  
import org.apache.calcite.rel.type.RelDataTypeFactory;
        assertEquals("day", ((RexLiteral) adapted.getOperands().get(0)).getValueAs(String.class));
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        assertEquals("||", castedExpr.getOperator().getName());
    /** NULL literal passes through — column-value semantics handle null at runtime. */  
import org.apache.calcite.sql.type.OperandTypes;
    }
        RexCall innerToTime = (RexCall) rexBuilder.makeCall(toTimeOp, List.of(strLit));  
        assertEquals("rewrite must use CAST", SqlKind.CAST, cast.getKind());
        SqlFunction toTimeOp = new SqlFunction(  
/**  
    public void testNullVarcharLiteralPassesThrough() {
        // Outer node: CAST(_ AS TIMESTAMP).
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
 * SPDX-License-Identifier: Apache-2.0
        RelDataType nullableVarchar = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
        RexNode date = rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.DATE), 0);
        RexCall adapted = (RexCall) DatePartAdapters.day().adapt(original, List.of(), cluster);
public class DatePartAdaptersTests extends OpenSearchTestCase {
            "HOUR",
        );
        IllegalArgumentException e = expectThrows(
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(literal));
        RexNode literal = rexBuilder.makeLiteral(value, varcharType, true);
        assertEquals(SqlKind.CAST, ((RexCall) wrapped).getKind());  
        RexNode wrapped = adapted.getOperands().get(1);
        assertInvalidLiteralRejected("not-a-date");  
     * legacy "unsupported format" wording reaches the HTTP body. The Arrow CAST kernel error
/*  
        assertEquals(SqlKind.CAST, ((RexCall) adapted.getOperands().get(1)).getKind());
        RexNode wrapped = adapted.getOperands().get(1);
            IllegalArgumentException.class,  
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
            null,
        // Result: date_part('hour', CAST(CONCAT(today, s) AS TIMESTAMP)).
import org.apache.calcite.rel.type.RelDataType;
package org.opensearch.be.datafusion;
    public void testDateOperandPassesThrough() {  
            ReturnTypes.explicit(timeType),  
 * {@code opensearch_scalar_functions.yaml}.
        RexCall original = (RexCall) rexBuilder.makeCall(pplHour(), List.of(innerToTime));
        RexCall adapted = (RexCall) DatePartAdapters.day().adapt(original, List.of(), cluster);  
            SqlFunctionCategory.TIMEDATE
        assertSame("TIMESTAMP operand must not be wrapped in CAST", ts, adapted.getOperands().get(1));
 */  
import org.apache.calcite.sql.SqlFunction;
            () -> DatePartAdapters.day().adapt(original, List.of(), cluster)
        return new SqlFunction(  
    }
        );
        RexCall adaptedQuarter = (RexCall) DatePartAdapters.quarter().adapt(original, List.of(), cluster);
        RexCall castedExpr = (RexCall) ((RexCall) wrapped).getOperands().get(0);  
        RexCall adapted = (RexCall) DatePartAdapters.hour().adapt(original, List.of(), cluster);  
        assertSame("inner operand of CAST must be the original literal", literal, cast.getOperands().get(0));
import org.apache.calcite.sql.SqlFunctionCategory;
 * the {@code (string, precision_timestamp<P>)} signature in
            null,
        RexCall adapted = (RexCall) DatePartAdapters.day().adapt(original, List.of(), cluster);  
            SqlFunctionCategory.TIMEDATE  
        assertSame(SqlTypeName.TIMESTAMP, cast.getType().getSqlTypeName());  
        RexCall inner = (RexCall) ((RexCall) wrapped).getOperands().get(0);
        RexNode nullLit = rexBuilder.makeNullLiteral(nullableVarchar);  
            null,
        assertInvalidLiteralRejected("2025-12-01 15:02:61"); // second out of range
    }
        assertNotSame(original, adapted);  
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(literal));  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        assertEquals("doy", ((RexLiteral) adaptedDoy.getOperands().get(0)).getValueAs(String.class));  
        RexNode field = rexBuilder.makeInputRef(nullableVarchar, 0);
    private SqlFunction pplHour() {  
    private final RexBuilder rexBuilder = new RexBuilder(typeFactory);
    }  
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(columnRef));  
    }  
    public void testInvalidDateLiteralRejectedAtPlanTime() {
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(nullLit));
            OperandTypes.ANY,
        RexCall adapted = (RexCall) DatePartAdapters.hour().adapt(original, List.of(), cluster);  
    private void assertInvalidLiteralRejected(String value) {  
        RelDataType charType = typeFactory.createSqlType(SqlTypeName.CHAR, 10);  
        assertEquals(SqlKind.CAST, ((RexCall) wrapped).getKind());  
        assertEquals("||", inner.getOperator().getName());
            OperandTypes.ANY,  
 * that wraps bare-string PPL call shapes (e.g. {@code DAY('2020-09-16')}) so
    /** Coerced CAST preserves operand nullability so the outer call's nullable return type stays consistent. */
    public void testCharOperandIsCastToTimestamp() {
        );
        assertInvalidLiteralRejected("2025-13-02"); // month out of range  
    public void testCastPreservesNullability() {  
            SqlFunctionCategory.TIMEDATE  
    public void testUnitLiteralPropagatedFromFactory() {
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
            SqlKind.OTHER_FUNCTION,
    }
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(field));  
        assertSame(date, adapted.getOperands().get(1));  
        assertEquals(SqlKind.CAST, ((RexCall) adapted.getOperands().get(1)).getKind());  
        assertTrue("VARCHAR operand must be wrapped", wrapped instanceof RexCall);  
            SqlKind.OTHER_FUNCTION,
import org.apache.calcite.sql.type.SqlTypeName;
        RelDataType timeType = typeFactory.createSqlType(SqlTypeName.TIME);
        RexCall adapted = (RexCall) DatePartAdapters.day().adapt(original, List.of(), cluster);  
        RexNode columnRef = rexBuilder.makeInputRef(varcharType, 0);
        RexCall adapted = (RexCall) DatePartAdapters.day().adapt(original, List.of(), cluster);
import org.apache.calcite.rex.RexCall;
import org.apache.calcite.plan.volcano.VolcanoPlanner;  
        RexNode literal = rexBuilder.makeLiteral("2020-09-16 17:30:00", varcharType, true);  
    private final RelOptCluster cluster = RelOptCluster.create(new VolcanoPlanner(), rexBuilder);
    public void testTimestampOperandPassesThrough() {
import org.apache.calcite.rex.RexNode;  
        RelDataType timeType = typeFactory.createSqlType(SqlTypeName.TIME);
        assertSame(SqlTypeName.TIMESTAMP, wrapped.getType().getSqlTypeName());
    }
        RexNode strLit = rexBuilder.makeLiteral("17:30:00", varcharType, true);
        RexCall adapted = (RexCall) DatePartAdapters.day().adapt(original, List.of(), cluster);  
            e.getMessage().contains("unsupported format")
        return new SqlFunction(
    }  
    }
        RexNode wrapped = adapted.getOperands().get(1);
    /** Each unit factory threads through its own prepended literal. */
    public void testVarcharLiteralOperandIsCastToTimestamp() {
        RexCall adapted = (RexCall) DatePartAdapters.day().adapt(original, List.of(), cluster);
    /** Non-literal VARCHAR (column ref) is not eagerly validated — only literals are. */
        RexCall adaptedDoy = (RexCall) DatePartAdapters.dayOfYear().adapt(original, List.of(), cluster);
        assertSame(SqlLibraryOperators.DATE_PART, adapted.getOperator());
        RexNode adapted = DatePartAdapters.hour().adapt(original, List.of(), cluster);  
    /** Coercion path also works when invoked through the unit factory for a non-default unit. */  
 *
import org.apache.calcite.rex.RexLiteral;
    }  
        assertTrue("message must echo the offending input [" + value + "]", e.getMessage().contains(value));
        RexCall adaptedYear = (RexCall) DatePartAdapters.year().adapt(original, List.of(), cluster);  
        RexNode wrapped = adapted.getOperands().get(1);  
     * does not survive Flight RPC serialization on the worker→coordinator hop.  
        assertTrue(  
        assertInvalidLiteralRejected("16:00:61"); // bare time, second out of range
    }  
    }
    /** Cluster B: bare-time string {@code '17:30:00'} → CONCAT(today,' ',s) → CAST AS TIMESTAMP. */
        RexNode ts = rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), 0);  
        RexNode literal = rexBuilder.makeLiteral("2020-09-16", varcharType, true);  
        assertEquals("year", ((RexLiteral) adaptedYear.getOperands().get(0)).getValueAs(String.class));
    public void testVarcharCoercionWithHourUnit() {
import org.apache.calcite.sql.type.ReturnTypes;  
        assertEquals("hour", ((RexLiteral) adapted.getOperands().get(0)).getValueAs(String.class));
 */  
    public void testVarcharColumnRefNotValidated() {  
    /** HOUR(TIME('17:30:00')) folds to a BIGINT literal at plan time (no substrait sig for (string, precision_time)). */
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        RexNode field = rexBuilder.makeInputRef(charType, 0);
}  
            "to_time",
 * the rewritten {@code date_part('day', CAST(_ AS TIMESTAMP))} resolves against  
import org.opensearch.test.OpenSearchTestCase;
            ReturnTypes.INTEGER_NULLABLE,  
 * this file be licensed under the Apache-2.0 license or a
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(ts));
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(ts));
    }  
        assertTrue("CAST output must remain nullable", adapted.getOperands().get(1).getType().isNullable());
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(literal));  
    /** Cluster B: TIME column → CONCAT(today,' ',CAST AS VARCHAR) → CAST AS TIMESTAMP. */
    public void testTimeOperandAnchoredToToday() {  
        RelDataType nullableVarchar = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
        assertSame(SqlTypeName.TIMESTAMP, wrapped.getType().getSqlTypeName());
        assertEquals(2, adapted.getOperands().size());  
        assertEquals(SqlKind.OTHER, castedExpr.getKind());
    private SqlFunction pplDay() {
            "DAY",
import org.apache.calcite.plan.RelOptCluster;
    }  
            OperandTypes.ANY,
        RexCall original = (RexCall) rexBuilder.makeCall(pplDay(), List.of(literal));
    /** CHAR (fixed-width) operand is also coerced — both are SqlTypeFamily.CHARACTER. */
        assertEquals("quarter", ((RexLiteral) adaptedQuarter.getOperands().get(0)).getValueAs(String.class));
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
    }
