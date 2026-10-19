    private RexNode varcharInputRef(int index) {
import org.apache.calcite.sql.type.SqlTypeName;  
        RexNode arg0 = rexBuilder.makeLiteral("literal_rhs");
import org.apache.calcite.sql.SqlKind;  
import org.apache.calcite.rex.RexNode;  
import org.apache.calcite.rel.type.RelDataType;
    public void setUp() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(SqlKind.LESS_THAN, lessThan.getKind());
import org.apache.calcite.sql.type.OperandTypes;
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    /** Arguments are swapped — arg1 becomes 'a' (lhs) and arg0 becomes 'b' (rhs) in the comparisons. */
    public void testSingleArgPassesThrough() {  
 * Unit tests for {@link StrcmpFunctionAdapter}.  
    private final StrcmpFunctionAdapter adapter = new StrcmpFunctionAdapter();
        RexNode arg0 = rexBuilder.makeLiteral("Amber");  
        RexNode out = adapter.adapt(call, List.of(), cluster);
 * frontend's reversal. These tests verify the CASE shape and argument swap.
 */  
}
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.sql.SqlFunctionCategory;
/**
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.rex.RexBuilder;
        RexNode arg1 = varcharInputRef(0); // column — should become lhs after swap
import org.apache.calcite.sql.type.ReturnTypes;
    private RexBuilder rexBuilder;
        RelDataType varcharType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);  
import org.apache.calcite.plan.hep.HepProgramBuilder;
        RexCall call = (RexCall) rexBuilder.makeCall(STRCMP, arg0, arg1);  
 */
import org.apache.calcite.rel.type.RelDataTypeFactory;  
    /** Non-standard arity (e.g. 1 arg) passes through unchanged. */
        null,  
        assertSame("lhs of < is the column (original arg1)", arg1, lessThan.getOperands().get(0));
 *
    }  
        RexNode out = adapter.adapt(call, List.of(), cluster);  
        OperandTypes.family(),
    public void testArgumentsAreSwapped() {  
        RexCall lessThan = (RexCall) caseCall.getOperands().get(2);
    }  
public class StrcmpFunctionAdapterTests extends OpenSearchTestCase {  
 *
package org.opensearch.be.datafusion;
        typeFactory = new JavaTypeFactoryImpl();
import org.apache.calcite.rex.RexCall;
    private RelDataTypeFactory typeFactory;
    private static final SqlFunction STRCMP = new SqlFunction(
import java.util.List;  
        // The LESS_THAN comparison is at operand index 2: WHEN a < b THEN -1
        // lhs of < should be the column (arg1), rhs should be the literal (arg0)  
        RexCall outCall = (RexCall) out;
        return rexBuilder.makeInputRef(varcharType, index);
        assertTrue("result must be a RexCall", out instanceof RexCall);  
        assertSame("non-2-arg call passes through unchanged", call, out);
 * comparison operators ({@code <}, {@code =}) and swaps the arguments to undo the PPL  
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        RexCall call = (RexCall) rexBuilder.makeCall(STRCMP, arg0, arg1);
        assertEquals("return type is INTEGER", SqlTypeName.INTEGER, outCall.getType().getSqlTypeName());  
    }  
    /** The adapter produces a CASE expression with INTEGER return type. */
    private RelOptCluster cluster;  
        assertEquals("CASE has 7 operands (3 WHEN/THEN pairs + ELSE)", 7, outCall.getOperands().size());
        SqlKind.OTHER_FUNCTION,
    );  
        RexNode out = adapter.adapt(call, List.of(), cluster);
        RexCall caseCall = (RexCall) out;
        RexCall call = (RexCall) rexBuilder.makeCall(STRCMP, varcharInputRef(0));
    @Override
        rexBuilder = new RexBuilder(typeFactory);  
        cluster = RelOptCluster.create(planner, rexBuilder);
    }  
    }
        "STRCMP",  
import org.apache.calcite.plan.hep.HepPlanner;  
    public void testTwoArgProducesCaseExpression() {
import org.apache.calcite.sql.SqlFunction;
        assertEquals("decomposed to CASE", SqlKind.CASE, outCall.getKind());
        SqlFunctionCategory.USER_DEFINED_FUNCTION
/*  
        ReturnTypes.INTEGER,
        super.setUp();
        // CASE has 7 operands: (anyNull, nullLit, lessThan, neg1, equalTo, zero, one)
        // After swap: a = arg1 (inputRef), b = arg0 (literal)  
 * <p>The adapter decomposes {@code strcmp(a, b)} into a CASE expression using built-in
        RexNode arg1 = varcharInputRef(0);
        assertSame("rhs of < is the literal (original arg0)", arg0, lessThan.getOperands().get(1));
