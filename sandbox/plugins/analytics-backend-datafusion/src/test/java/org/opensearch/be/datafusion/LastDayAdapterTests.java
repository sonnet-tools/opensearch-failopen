        assertLastDayShape(result);
        );
    }
        );  
        RexNode result = new LastDayAdapter().adapt(call, List.of(), cluster);  
            if (call.getOperator() == operator) {  
 */  
     * VARCHAR / TIME bases must route through {@code coerceCharacterOperandToTimestamp} so the  
        if (node instanceof RexCall call) {
import org.apache.calcite.plan.hep.HepProgramBuilder;
        assertLastDayShape(result);
    private RexCall lastDayCall(SqlTypeName operandType) {
 * SPDX-License-Identifier: Apache-2.0
public class LastDayAdapterTests extends OpenSearchTestCase {
        assertLastDayShape(result);  
        assertNotNull("expected DATETIME_PLUS (+1 month, -1 day)", findOp(result, SqlStdOperatorTable.DATETIME_PLUS));  
    public void testLastDayOnVarcharAnchorsViaCoercion() {
                return call;
        SqlFunction op = new SqlFunction(
            "date_trunc value operand must be TIMESTAMP after VARCHAR coercion",
    }
        );
                if (found != null) {
        return (RexCall) rexBuilder.makeCall(dateType, op, List.of(rexBuilder.makeInputRef(arg, 0)));  
import org.apache.calcite.sql.SqlKind;  
     * operand handed to {@code date_trunc} is TIMESTAMP-typed (a direct CAST(time→timestamp) would
        RexCall call = lastDayCall(SqlTypeName.TIMESTAMP);
    }
import org.apache.calcite.sql.SqlFunctionCategory;
            "date_trunc value operand must be TIMESTAMP after TIME coercion",  
    private void assertLastDayShape(RexNode result) {
        RexNode result = new LastDayAdapter().adapt(call, List.of(), cluster);
        typeFactory = new JavaTypeFactoryImpl();
     * The invariant we pin: the date_trunc call's value operand is TIMESTAMP, not the source type.  
        assertEquals(  
 * this file be licensed under the Apache-2.0 license or a
    }
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());  
 */  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
                    return found;  
        }  
import org.apache.calcite.plan.hep.HepPlanner;  
        RelDataType dateType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DATE), true);
import org.apache.calcite.sql.SqlFunction;
import org.apache.calcite.rel.type.RelDataTypeFactory;  
            dateTrunc.getOperands().get(1).getType().getSqlTypeName()
        assertNotNull(dateTrunc);
    }
    public void setUp() throws Exception {
 * rewrite contains both the {@code date_trunc} call and two {@code DATETIME_PLUS} layers — exact
package org.opensearch.be.datafusion;
 * The OpenSearch Contributors require contributions made to  
        // is the load-bearing marker that the TIME-anchoring branch ran (vs the no-op DATE branch).  
            ReturnTypes.DATE_NULLABLE,
            }
    /** Wrong-arity input (zero or two operands) must pass through unchanged so the engine surfaces it. */  
        return null;
}
        assertTrue("LAST_DAY must be rewritten", result != call);  
        rexBuilder = new RexBuilder(typeFactory);
import org.apache.calcite.sql.type.ReturnTypes;
        RexNode result = new LastDayAdapter().adapt(call, List.of(), cluster);  
            SqlFunctionCategory.TIMEDATE
        assertTrue(result != call);
        RelDataType ts = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), true);
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RexCall twoArg = (RexCall) rexBuilder.makeCall(  
    private RexBuilder rexBuilder;
     */
    }
 * {@code date_trunc('month', x) + INTERVAL 1 MONTH - INTERVAL 1 DAY}, so each test asserts the  
        );  
     * be rejected by DataFusion's optimizer; the helper uses today-date prefix + CONCAT instead).
            }
    }  
        );  
        SqlFunction op = new SqlFunction(
import org.apache.calcite.rex.RexCall;
        RexCall call = lastDayCall(SqlTypeName.TIME);
        assertSame("two-arg LAST_DAY must pass through unchanged", twoArg, result);  
            ReturnTypes.DATE_NULLABLE,
        RexCall dateTrunc = findOp(result, DateTimeAdapters.LOCAL_DATE_TRUNC_OP);
    }
    /** date_trunc + 2× DATETIME_PLUS appears for every operand type. */  
    private RelDataTypeFactory typeFactory;  
import org.apache.calcite.rex.RexNode;  
    public void testLastDayOnDateLowersWithoutAnchor() {  
import org.apache.calcite.plan.RelOptCluster;
 * compatible open source license.
            "LAST_DAY",  
import java.util.List;
        assertTrue(result != call);
import org.apache.calcite.rex.RexBuilder;
            null,  
import org.apache.calcite.sql.SqlOperator;
            OperandTypes.ANY_ANY,
import org.apache.calcite.sql.type.OperandTypes;  
            SqlFunctionCategory.TIMEDATE
        assertEquals(
 * Unit tests for {@link LastDayAdapter}. The lowering is
    public void testLastDayOnTimeAnchorsViaCoercion() {
        RexCall dateTrunc = findOp(result, DateTimeAdapters.LOCAL_DATE_TRUNC_OP);  
 * date values are covered by the QA IT against a real DataFusion runtime.
                }
            SqlTypeName.TIMESTAMP,
            OperandTypes.ANY,
        assertTrue(result != call);
    public void testLastDayWrongArityPassesThrough() {
        assertNotNull("expected date_trunc('month', ...)", findOp(result, DateTimeAdapters.LOCAL_DATE_TRUNC_OP));
            SqlKind.OTHER_FUNCTION,
        assertNotNull("TIME operand must route through CONCAT-anchor", findOp(result, SqlStdOperatorTable.CONCAT));
    }
/**
            null,  
 *
    private RelOptCluster cluster;
            List.of(rexBuilder.makeInputRef(ts, 0), rexBuilder.makeInputRef(ts, 1))  
    private static RexCall findOp(RexNode node, SqlOperator operator) {
        RexCall call = lastDayCall(SqlTypeName.DATE);
            dateType,
        RexNode result = new LastDayAdapter().adapt(call, List.of(), cluster);
            SqlKind.OTHER_FUNCTION,
        assertNotNull(dateTrunc);
        RelDataType dateType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DATE), true);
            SqlTypeName.TIMESTAMP,
        // TIME path uses CONCAT(today, ' ', CAST(time AS VARCHAR)) → CAST TIMESTAMP — that CONCAT
            dateTrunc.getOperands().get(1).getType().getSqlTypeName()  
/*  
import org.apache.calcite.sql.type.SqlTypeName;
    /**
import org.apache.calcite.rel.type.RelDataType;
    public void testLastDayOnTimestampLowersWithoutAnchor() {
            op,
            "LAST_DAY",  
import org.opensearch.test.OpenSearchTestCase;  
        RelDataType arg = typeFactory.createTypeWithNullability(typeFactory.createSqlType(operandType), true);
        cluster = RelOptCluster.create(planner, rexBuilder);
        RexNode result = new LastDayAdapter().adapt(twoArg, List.of(), cluster);
        RexCall call = lastDayCall(SqlTypeName.VARCHAR);  
                RexCall found = findOp(op, operator);
            for (RexNode op : call.getOperands()) {  
        super.setUp();  
    @Override
        assertLastDayShape(result);
