        RexCall call = unaryCall("WEEKDAY", typeFactory.createSqlType(SqlTypeName.INTEGER), SqlTypeName.TIMESTAMP);  
            ReturnTypes.explicit(returnType),  
        assertNotNull("expected date_part('dow', ...)", findOp(result, SqlLibraryOperators.DATE_PART));  
    }
            if (call.getOperator() == operator) {
    }
 * The OpenSearch Contributors require contributions made to  
        if (node instanceof RexCall call) {  
    }  
        assertNotNull("expected MINUS (monthIndex(p1) - monthIndex(p2))", findOp(result, SqlStdOperatorTable.MINUS));  
    private RexBuilder rexBuilder;
 * compatible open source license.
    }  
 *
        typeFactory = new JavaTypeFactoryImpl();
        return typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.TIME), true);
 */
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
            name,  
            OperandTypes.ANY,
    public void setUp() throws Exception {  
import org.apache.calcite.sql.fun.SqlLibraryOperators;
        return typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BIGINT), true);
                if (found != null) {  
    }
        );
            SqlFunctionCategory.TIMEDATE  
        assertNotNull("expected maketime(h,m,s)", findOp(result, RustUdfDateTimeAdapters.LOCAL_MAKETIME_OP));
        super.setUp();
            null,
 * this file be licensed under the Apache-2.0 license or a
        assertTrue("WEEKDAY must be rewritten", result != call);
        }
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
                RexCall found = findOp(op, operator);
            SqlKind.OTHER_FUNCTION,
        RelDataType arg = typeFactory.createTypeWithNullability(typeFactory.createSqlType(operandType), true);
        SqlFunction op = new SqlFunction(  
import org.apache.calcite.sql.SqlKind;  
        cluster = RelOptCluster.create(planner, rexBuilder);
    }
 */  
import org.opensearch.test.OpenSearchTestCase;
    public void testPeriodDiffLowersToSubtraction() {
    private RelDataType time() {
        assertNotNull("expected DIVIDE (month index / 12)", findOp(result, SqlStdOperatorTable.DIVIDE));
import org.apache.calcite.sql.type.OperandTypes;
                }
                return call;
        SqlFunction op = new SqlFunction(
    private RelOptCluster cluster;  
import java.math.BigDecimal;  
        assertTrue(result != call);
}
import org.apache.calcite.sql.type.ReturnTypes;
        RexNode b = rexBuilder.makeExactLiteral(BigDecimal.valueOf(2), typeFactory.createSqlType(SqlTypeName.INTEGER));
 * They assert the rewrite <em>shape</em> (raw PPL op replaced, expected primitives present); exact
                    return found;
import org.apache.calcite.plan.RelOptCluster;
        RexNode result = new PeriodArithmeticAdapters.PeriodAddAdapter().adapt(call, List.of(), cluster);
        RexNode result = new PeriodArithmeticAdapters.PeriodDiffAdapter().adapt(call, List.of(), cluster);
            name,
    public void testWeekdayRemapsDow() {
import org.apache.calcite.rex.RexNode;  
import org.apache.calcite.plan.hep.HepPlanner;  
import org.apache.calcite.sql.SqlOperator;
        RexCall call = unaryCall("SEC_TO_TIME", typeFactory.createSqlType(SqlTypeName.TIME), SqlTypeName.BIGINT);
            SqlKind.OTHER_FUNCTION,
        return null;
import org.apache.calcite.sql.SqlFunction;
import org.apache.calcite.rex.RexCall;
        assertTrue(result != call);  
    private RelDataType bigint() {  
            for (RexNode op : call.getOperands()) {
        assertNotNull("expected MOD 7 remap", findOp(result, SqlStdOperatorTable.MOD));
import org.apache.calcite.rel.type.RelDataType;
            OperandTypes.NUMERIC_NUMERIC,
public class PeriodWeekdaySecToTimeAdapterTests extends OpenSearchTestCase {
    }  
        RexCall call = binaryIntCall("PERIOD_ADD");
    private static RexCall findOp(RexNode node, SqlOperator operator) {
import java.util.List;
    }
        RexCall call = binaryIntCall("PERIOD_DIFF");  
        RelDataType intType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);
import org.apache.calcite.sql.type.SqlTypeName;  
        return (RexCall) rexBuilder.makeCall(intType, op, List.of(a, b));  
/**  
        rexBuilder = new RexBuilder(typeFactory);  
    @Override
            }  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
 * Unit tests for {@link WeekdayAdapter}, {@link SecToTimeAdapter}, and {@link PeriodArithmeticAdapters}.
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
            }  
    }
        RexNode a = rexBuilder.makeExactLiteral(BigDecimal.valueOf(200801), typeFactory.createSqlType(SqlTypeName.INTEGER));
    private RexCall unaryCall(String name, RelDataType returnType, SqlTypeName operandType) {
    private RexCall binaryIntCall(String name) {  
    private RelDataTypeFactory typeFactory;
/*  
import org.apache.calcite.sql.SqlFunctionCategory;
            ReturnTypes.INTEGER_NULLABLE,
            null,  
        assertTrue(result != call);
 * SPDX-License-Identifier: Apache-2.0
        RexNode result = new SecToTimeAdapter().adapt(call, List.of(), cluster);  
 * numeric values are covered by the QA ITs against a real DataFusion runtime.  
        return (RexCall) rexBuilder.makeCall(returnType, op, List.of(rexBuilder.makeInputRef(arg, 0)));  
package org.opensearch.be.datafusion;
        );  
        assertNotNull("expected MOD (month within year)", findOp(result, SqlStdOperatorTable.MOD));
            SqlFunctionCategory.TIMEDATE
        RexNode result = new WeekdayAdapter().adapt(call, List.of(), cluster);
        assertNotNull("expected MOD (wrap to a day / decompose)", findOp(result, SqlStdOperatorTable.MOD));  
import org.apache.calcite.rex.RexBuilder;
    }  
    public void testSecToTimeUsesMaketimeNotCast() {
import org.apache.calcite.plan.hep.HepProgramBuilder;
    public void testPeriodAddLowersToIntegerArithmetic() {  
