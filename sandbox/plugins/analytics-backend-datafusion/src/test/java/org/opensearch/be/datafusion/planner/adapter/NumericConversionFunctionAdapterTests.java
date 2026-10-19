        RelDataType type = cluster.getTypeFactory().createSqlType(operandType);  
        RexCall original = callWithOperandType(cluster, SqlTypeName.INTEGER);
import org.apache.calcite.plan.RelOptCluster;
        assertRewritesTo(NumericConversionFunctionAdapter.DUR2SEC, "dur2sec");
        assertRewritesTo(NumericConversionFunctionAdapter.MEMK, "memk");
        RexNode rewritten = new NumericConversionFunctionAdapter(NumericConversionFunctionAdapter.NUM).adapt(original, List.of(), cluster);  
        assertSame(twoArg, rewritten);  
        assertTrue("numeric operand must be wrapped in a CAST, got " + arg, arg instanceof RexCall);
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        RelDataType varcharType = cluster.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
    }
 * compatible open source license.
import org.apache.calcite.rex.RexCall;
     *  cache (see AbstractNameMappingAdapter javadoc) stays consistent. */
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
    /** Arity mismatch pass through */
    public void testWrongArityPassesThrough() {  
    }
        RexCall out = (RexCall) rewritten;  
/*  
import org.apache.calcite.sql.type.ReturnTypes;  
 * Unit tests for {@link NumericConversionFunctionAdapter}. Verifies that the PPL
        RexNode arg1 = new RexInputRef(0, varcharType);  
        RexNode rewritten = new NumericConversionFunctionAdapter(target).adapt(original, List.of(), cluster);  
    }
    }
    }
    private void assertRewritesTo(SqlFunction target, String expectedName) {
    private RelOptCluster cluster() {  
import java.util.List;
        "ppl_call",
import org.apache.calcite.sql.SqlFunction;
import org.apache.calcite.sql.SqlKind;
    public void testMemkRewrites() {  
        SqlFunctionCategory.USER_DEFINED_FUNCTION  
        assertEquals(original.getType(), rewritten.getType());
        // Operand already VARCHAR — no CAST should be layered on top.  
        RelOptCluster cluster = cluster();  
        assertEquals("num", out.getOperator().getName());
        assertEquals(expectedName, out.getOperator().getName());
import org.apache.calcite.sql.type.OperandTypes;
    }
    /** Numeric input should be wrapped in a CAST AS VARCHAR so the Rust UDF sees a string. */
    public void testRmcommaRewrites() {
        assertRewritesTo(NumericConversionFunctionAdapter.RMCOMMA, "rmcomma");
        RexNode arg2 = new RexInputRef(1, varcharType);
import org.apache.calcite.plan.hep.HepProgramBuilder;
    public void testRmunitRewrites() {
        ReturnTypes.DOUBLE_NULLABLE,  
        RelOptCluster cluster = cluster();  
        assertEquals(SqlKind.CAST, ((RexCall) arg).getKind());
        assertTrue("adapter must emit a RexCall, got " + rewritten, rewritten instanceof RexCall);
        RexNode rewritten = new NumericConversionFunctionAdapter(NumericConversionFunctionAdapter.NUM).adapt(twoArg, List.of(), cluster);
}
/**  
        RexNode rewritten = new NumericConversionFunctionAdapter(NumericConversionFunctionAdapter.NUM).adapt(original, List.of(), cluster);
        OperandTypes.family(),
        SqlKind.OTHER_FUNCTION,
    }  
import org.apache.calcite.sql.type.SqlTypeName;
 * to VARCHAR, and that the return type is preserved.
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        return RelOptCluster.create(planner, rexBuilder);
import org.apache.calcite.rel.type.RelDataType;
        assertTrue("VARCHAR input must pass through unchanged", out.getOperands().get(0) instanceof RexInputRef);
    }  
        RelOptCluster cluster = cluster();
        assertRewritesTo(NumericConversionFunctionAdapter.RMUNIT, "rmunit");  
        // makeCast produces a SqlKind.CAST call when the source / target types differ.  
package org.opensearch.be.datafusion.planner.adapter;
        assertEquals(1, out.getOperands().size());
 */
    public void testReturnTypePreserved() {
import org.apache.calcite.rex.RexNode;
    }  
        RexCall original = callWithOperandType(cluster, SqlTypeName.VARCHAR);
        RexCall original = callWithOperandType(cluster, SqlTypeName.VARCHAR);
 * corresponding synthetic {@link SqlFunction} constants, that the input operand is coerced  
    /** Synthetic PPL-side operator used to build the "original" call feeding the adapter. */
import org.apache.calcite.plan.hep.HepPlanner;  
 */  
 * this file be licensed under the Apache-2.0 license or a
 * {@code num / auto / memk / rmcomma / rmunit} unary calls are rewritten to their
    public void testMstimeRewrites() {
    private static final SqlFunction PPL_CALL = new SqlFunction(  
    }
        RexNode arg = out.getOperands().get(0);
    /** The original call's return type must be preserved so the enclosing Project's rowType  
        assertRewritesTo(NumericConversionFunctionAdapter.NUM, "num");
        null,
import org.apache.calcite.rex.RexBuilder;
    public void testNumRewrites() {
    public void testDur2secRewrites() {  
        RexNode operand = new RexInputRef(0, type);
    }
    private RexCall callWithOperandType(RelOptCluster cluster, SqlTypeName operandType) {
        assertEquals(SqlTypeName.VARCHAR, arg.getType().getSqlTypeName());  
    public void testAutoRewrites() {
        RexBuilder rexBuilder = new RexBuilder(typeFactory);  
    );
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.apache.calcite.sql.SqlFunctionCategory;  
 * SPDX-License-Identifier: Apache-2.0
        RexCall out = (RexCall) rewritten;  
    }  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
        assertRewritesTo(NumericConversionFunctionAdapter.AUTO, "auto");  
import org.apache.calcite.rex.RexInputRef;  
        RelOptCluster cluster = cluster();
    public void testNumericInputIsCoercedToVarchar() {  
        assertRewritesTo(NumericConversionFunctionAdapter.MSTIME, "mstime");
        RexCall twoArg = (RexCall) cluster.getRexBuilder().makeCall(PPL_CALL, List.of(arg1, arg2));
    /** Builds a one-operand RexCall with the given argument type, wrapped in PPL_CALL. */
 *
public class NumericConversionFunctionAdapterTests extends OpenSearchTestCase {  
        return (RexCall) cluster.getRexBuilder().makeCall(PPL_CALL, List.of(operand));
    }  
