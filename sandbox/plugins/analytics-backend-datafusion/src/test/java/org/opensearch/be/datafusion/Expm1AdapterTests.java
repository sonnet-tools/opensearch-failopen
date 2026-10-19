 * The OpenSearch Contributors require contributions made to  
        RexNode left = minus.getOperands().get(0);  
        RexCall expCall = (RexCall) left;
            null
        );  
import org.apache.calcite.plan.hep.HepPlanner;  
import org.apache.calcite.sql.type.SqlTypeName;  
        assertEquals(1, expCall.getOperands().size());
import org.apache.calcite.rex.RexBuilder;
        RexNode ref = rexBuilder.makeInputRef(doubleType, 0);
}
            SqlKind.OTHER_FUNCTION,
        rexBuilder = new RexBuilder(typeFactory);
        // Right operand must be numerically 1 (type may be DECIMAL or INTEGER depending on promotion)
 * expands the UDF to an explicit {@code MINUS(EXP(x), 1)} tree so the plan
 */  
        RexNode adapted = new Expm1Adapter().adapt(original, List.of(), cluster);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    private SqlUserDefinedFunction expm1Udf;
import org.apache.calcite.sql.type.ReturnTypes;
import org.apache.calcite.sql.parser.SqlParserPos;
 */  
        doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);
    @Override  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
    public void testExpm1RewrittenAsExpMinusOne() {  
package org.opensearch.be.datafusion;
 * serialises to native Substrait primitives.
import org.apache.calcite.plan.RelOptCluster;
        RexNode right = minus.getOperands().get(1);
import org.apache.calcite.plan.hep.HepProgramBuilder;
    public void setUp() throws Exception {
    private RexBuilder rexBuilder;
import org.opensearch.test.OpenSearchTestCase;
        typeFactory = new JavaTypeFactoryImpl();  
        assertSame("EXP operand must be the original arg", arg, expCall.getOperands().get(0));
        RexCall original = (RexCall) rexBuilder.makeCall(expm1Udf, List.of(arg));
            null,  
        RexCall minus = (RexCall) adapted;
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
    }
            null,
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
/**  
 * {@code exp(x) - 1}. DataFusion's substrait consumer has no {@code expm1} scalar
            ReturnTypes.DOUBLE_NULLABLE,
        assertTrue("right operand must be a literal", right instanceof org.apache.calcite.rex.RexLiteral);  
        assertSame("left operand must be EXP(...)", SqlStdOperatorTable.EXP, expCall.getOperator());  
import java.util.List;
    private RelDataType doubleType;  
        assertTrue("left operand of MINUS must be a RexCall", left instanceof RexCall);
        assertEquals(2, minus.getOperands().size());
            new SqlIdentifier("EXPM1", SqlParserPos.ZERO),  
    public void testAdaptPassesThroughUnrelatedCall() {  
        assertTrue("expected a MINUS RexCall", adapted instanceof RexCall);
        assertSame("outermost operator must be MINUS", SqlStdOperatorTable.MINUS, minus.getOperator());  
import org.apache.calcite.sql.SqlIdentifier;
        RexNode adapted = new Expm1Adapter().adapt(absCall, List.of(), cluster);
/*  
 * Unit tests for {@link Expm1Adapter}. PPL's {@code EXPM1(x)} UDF is defined as
 * SPDX-License-Identifier: Apache-2.0
        super.setUp();
import org.apache.calcite.sql.SqlKind;
import org.apache.calcite.rex.RexCall;
        expm1Udf = new SqlUserDefinedFunction(
public class Expm1AdapterTests extends OpenSearchTestCase {
 *
        cluster = RelOptCluster.create(planner, rexBuilder);  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.rel.type.RelDataType;
    private RelDataTypeFactory typeFactory;  
        RexCall absCall = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.ABS, List.of(ref));
    }
        assertSame(absCall, adapted);  
    }
        RexNode arg = rexBuilder.makeInputRef(doubleType, 0);
 * function, but it recognises {@code exp} and {@code subtract}; the adapter  
        // Expected tree: MINUS(EXP(arg), 1)  
    private RelOptCluster cluster;
import org.apache.calcite.rex.RexNode;  
import org.apache.calcite.sql.validate.SqlUserDefinedFunction;
 * compatible open source license.
