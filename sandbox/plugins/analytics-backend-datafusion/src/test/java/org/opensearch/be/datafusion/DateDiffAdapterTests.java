        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());  
        return (RexCall) rexBuilder.makeCall(ret, datediffOp(), List.of(a, b));
            if (op instanceof RexCall c) {
        );  
    public void testDateDiffOnTimeOperandsAnchorsBeforeUnixtime() {
    }
        for (RexNode op : call.getOperands()) {
import org.apache.calcite.sql.SqlKind;  
        if (call.getOperator() == UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP) {  
    }
    private static void assertNoToUnixtimeOnRawTime(RexNode node) {
     */  
                    return c;
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.rel.type.RelDataType;
        return new SqlFunction(
        assertNotNull("rewrite must contain a MINUS of two day-counts", minus);  
 *
    }
        RexNode b = rexBuilder.makeInputRef(time, 1);
 * difference between the calendar dates of {@code a} and {@code b} (arg1 − arg2), so the
            "DATEDIFF",  
        rexBuilder = new RexBuilder(typeFactory);
                if (c.getOperator() == SqlStdOperatorTable.MINUS) {  
        }  
            SqlKind.OTHER_FUNCTION,
        RexNode a = rexBuilder.makeInputRef(time, 0);
        RelDataType ret = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);  
        RexNode b = rexBuilder.makeInputRef(ts, 1);  
/*  
        }
    }  
        assertNoToUnixtimeOnRawTime(result);
        super.setUp();  
import org.apache.calcite.plan.hep.HepPlanner;  
import org.apache.calcite.plan.hep.HepProgramBuilder;
    private SqlFunction datediffOp() {
        RexCall out = (RexCall) result;
        for (RexNode op : call.getOperands()) {
    }
        }  
        RexCall minus = out.getOperator() == SqlStdOperatorTable.MINUS ? out : firstMinusOperand(out);
import org.apache.calcite.rex.RexCall;
        RelDataType time = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIME), true);
     * TIME operands route through {@code coerceCharacterOperandToTimestamp}: {@code to_unixtime}  
        RelDataType ret = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
    /**
import org.apache.calcite.rex.RexNode;  
        }
    private RexCall buildDateDiff() {  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RexCall call = (RexCall) rexBuilder.makeCall(ret, datediffOp(), List.of(a, b));  
import org.apache.calcite.sql.SqlFunction;
    }
        RelDataType ts = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), true);
        cluster = RelOptCluster.create(planner, rexBuilder);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    public void setUp() throws Exception {
import org.apache.calcite.sql.type.SqlTypeName;
        RexNode a = rexBuilder.makeInputRef(ts, 0);
    public void testDateDiffLowersToDayCountSubtraction() {  
 */  
            null,  
    private RelDataTypeFactory typeFactory;  
        RexNode result = new DateDiffAdapter().adapt(call, List.of(), cluster);
 * adapter must truncate each operand to its day before differencing — not subtract raw  
    /** The rewrite must not leave the raw DATEDIFF operator in place. */
            return;
                    return nested;
            SqlFunctionCategory.TIMEDATE
        if (!(node instanceof RexCall call)) {  
    /** DATEDIFF(a, b) lowers to a subtraction of two day-counts. */
import java.util.List;
}
    }  
            assertNoToUnixtimeOnRawTime(op);
                if (nested != null) {
    private RelOptCluster cluster;
 * this file be licensed under the Apache-2.0 license or a
     * rejects a Time64, so each TIME must be anchored to a TIMESTAMP first. The to_unixtime
    @Override
import org.apache.calcite.sql.SqlFunctionCategory;
        assertTrue("DATEDIFF must be rewritten, not returned unchanged", result != call);
                call.getOperands().get(0).getType().getSqlTypeName()
            assertNotEquals(
 * Unit tests for {@link DateDiffAdapter}. PPL {@code DATEDIFF(a, b)} is the whole-day
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        // Walk the tree, find every to_unixtime call — none should have a TIME-typed operand.
package org.opensearch.be.datafusion;
        return null;  
    private RexBuilder rexBuilder;
 */  
        typeFactory = new JavaTypeFactoryImpl();
    private static RexCall firstMinusOperand(RexCall call) {  
                }  
        // The top of the rewrite is a MINUS (possibly wrapped in a CAST to the declared return type).  
 * {@code FLOOR(to_unixtime(date_trunc('day', a)) / 86400) - FLOOR(to_unixtime(date_trunc('day', b)) / 86400)}.
import org.apache.calcite.sql.type.ReturnTypes;  
    }  
        assertEquals(SqlStdOperatorTable.MINUS, minus.getOperator());
        assertTrue("expected a rewritten call, got: " + result, result instanceof RexCall);
                }
public class DateDiffAdapterTests extends OpenSearchTestCase {
                "to_unixtime operand must be anchored, not a raw TIME",
                RexCall nested = firstMinusOperand(c);  
            );
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.rex.RexBuilder;
            ReturnTypes.BIGINT_FORCE_NULLABLE,
     * operand must therefore NOT be a raw TIME-typed value.
import org.apache.calcite.sql.type.OperandTypes;
    public void testDateDiffDoesNotPassThrough() {
 * instants. The lowering is
 * compatible open source license.
        RexCall call = buildDateDiff();  
        RexNode result = new DateDiffAdapter().adapt(buildDateDiff(), List.of(), cluster);
                SqlTypeName.TIME,  
import org.opensearch.test.OpenSearchTestCase;
/**  
        RexNode result = new DateDiffAdapter().adapt(call, List.of(), cluster);
            }
            OperandTypes.ANY_ANY,
