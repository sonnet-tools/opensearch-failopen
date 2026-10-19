import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.sql.type.OperandTypes;
import org.opensearch.test.OpenSearchTestCase;
 * {@link SqlStdOperatorTable} operator so Isthmus's {@code FunctionMappings.SCALAR_SIGS}  
 * this file be licensed under the Apache-2.0 license or a
        // Adapter registered for DIVIDE; call is for a differently-named UDF.
        StdOperatorRewriteAdapter adapter = new StdOperatorRewriteAdapter("DIVIDE", SqlStdOperatorTable.DIVIDE);
import org.apache.calcite.sql.type.ReturnTypes;  
package org.opensearch.analytics.spi;
        RexNode b = rexBuilder.makeLiteral(4L, typeFactory.createSqlType(SqlTypeName.BIGINT), false);
            SqlKind.OTHER_FUNCTION,  
import org.apache.calcite.sql.SqlOperator;  
        SqlFunction pplMod = pplUdf("MOD");
import org.apache.calcite.sql.SqlKind;
    private final RelOptCluster cluster = RelOptCluster.create(new VolcanoPlanner(), rexBuilder);
        assertTrue("Adapter should return a RexCall", adapted instanceof RexCall);
        assertTrue("Adapter should return a RexCall", adapted instanceof RexCall);
        assertSame("Already-std call should be returned unchanged", original, adapted);
        assertSame("Operator should be SqlStdOperatorTable.DIVIDE", SqlStdOperatorTable.DIVIDE, rewrite.getOperator());
    private final RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        RexCall original = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.DIVIDE, List.of(a, b));
        RexNode a = rexBuilder.makeLiteral(2L, typeFactory.createSqlType(SqlTypeName.BIGINT), false);
import java.util.List;
        SqlOperator target = SqlStdOperatorTable.DIVIDE;
 */  
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
            null,
        assertEquals("First operand preserved", 2L, ((RexLiteral) rewrite.getOperands().get(0)).getValueAs(Long.class).longValue());  
import org.apache.calcite.rex.RexLiteral;
        RexNode b = rexBuilder.makeLiteral(4L, typeFactory.createSqlType(SqlTypeName.BIGINT), false);
    public void testRewritesPplDivideToSqlStdDivide() {
import org.apache.calcite.plan.volcano.VolcanoPlanner;  
        StdOperatorRewriteAdapter adapter = new StdOperatorRewriteAdapter("DIVIDE", target);  
        assertSame("Non-matching names should be returned unchanged", original, adapted);  
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        RexNode b = rexBuilder.makeLiteral(4L, typeFactory.createSqlType(SqlTypeName.BIGINT), false);
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.rel.type.RelDataTypeFactory;
 * (e.g. a {@code SqlFunction} named "DIVIDE") are rewritten to the matching
        StdOperatorRewriteAdapter adapter = new StdOperatorRewriteAdapter("MOD", SqlStdOperatorTable.MOD);
        RexNode b = rexBuilder.makeLiteral(3L, typeFactory.createSqlType(SqlTypeName.BIGINT), false);
 */
import org.apache.calcite.sql.type.SqlTypeName;
        RexNode a = rexBuilder.makeLiteral(2L, typeFactory.createSqlType(SqlTypeName.BIGINT), false);
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        SqlFunction other = pplUdf("SOMETHING_ELSE");  
        RexCall rewrite = (RexCall) adapted;  
        RexCall original = (RexCall) rexBuilder.makeCall(other, List.of(a, b));  
import org.apache.calcite.rex.RexCall;  
        RexNode adapted = adapter.adapt(original, List.of(), cluster);  
        return new SqlFunction(
        RexCall original = (RexCall) rexBuilder.makeCall(pplMod, List.of(a, b));
    }  
import org.apache.calcite.sql.SqlFunctionCategory;
 * can map them to the Substrait default extension catalog.
import org.apache.calcite.sql.SqlFunction;  
 *
            SqlFunctionCategory.USER_DEFINED_FUNCTION
    private final RexBuilder rexBuilder = new RexBuilder(typeFactory);  
 * SPDX-License-Identifier: Apache-2.0
    public void testNoRewriteWhenOperatorNameMismatches() {
        assertSame("Operator should be SqlStdOperatorTable.MOD", SqlStdOperatorTable.MOD, ((RexCall) adapted).getOperator());
/*  
    }
            name,
 * Unit tests for {@link StdOperatorRewriteAdapter} — verifies that PPL-emitted UDF calls
        assertEquals("Operand count preserved", 2, rewrite.getOperands().size());
    }
        );
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    }
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
import org.apache.calcite.rex.RexBuilder;
        RexNode a = rexBuilder.makeLiteral(2L, typeFactory.createSqlType(SqlTypeName.BIGINT), false);  
    }  
            ReturnTypes.ARG0_NULLABLE,
        RexNode a = rexBuilder.makeLiteral(10L, typeFactory.createSqlType(SqlTypeName.BIGINT), false);  
    public void testRewritesPplModToSqlStdMod() {
        StdOperatorRewriteAdapter adapter = new StdOperatorRewriteAdapter("DIVIDE", SqlStdOperatorTable.DIVIDE);
    public void testNoRewriteWhenAlreadyStdOperator() {
        assertEquals("Second operand preserved", 4L, ((RexLiteral) rewrite.getOperands().get(1)).getValueAs(Long.class).longValue());
        SqlFunction pplDivide = pplUdf("DIVIDE");  
 * compatible open source license.
import org.apache.calcite.rex.RexNode;
            OperandTypes.NUMERIC_NUMERIC,  
        RexCall original = (RexCall) rexBuilder.makeCall(pplDivide, List.of(a, b));  
public class StdOperatorRewriteAdapterTests extends OpenSearchTestCase {  
    private SqlFunction pplUdf(String name) {  
/**  
}
