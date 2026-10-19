import org.apache.calcite.rex.RexCall;
import org.apache.calcite.rex.RexBuilder;  
    }
        RexCall original = call(SqlStdOperatorTable.LESS_THAN, field(0, SqlTypeName.INTEGER), field(1, SqlTypeName.INTEGER));
/**  
    public void testNumericComparisonPassesThrough() {  
        assertRewritesTo("LTE_IP", SqlKind.LESS_THAN_OR_EQUAL, SqlStdOperatorTable.LESS_THAN_OR_EQUAL);
        RelDataType boolType = typeFactory.createSqlType(SqlTypeName.BOOLEAN);  
        assertEquals("result type must be preserved", original.getType(), adapted.getType());
public class IpComparisonNormalizationAdapterTests extends OpenSearchTestCase {  
            SqlFunctionCategory.USER_DEFINED_FUNCTION  
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
     * Delegation is preserved: the wrapped {@link ComparisonTemporalCoercionAdapter} still coerces a
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.sql.SqlFunction;  
 */
}
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    public void testTemporalCoercionStillDelegated() {
import java.util.List;
            OperandTypes.ANY_ANY,
        assertRewritesTo("LESS_IP", SqlKind.LESS_THAN, SqlStdOperatorTable.LESS_THAN);  
            name,
 */  
 * Unit tests for {@link IpComparisonNormalizationAdapter}: PPL IP-comparison UDFs over VARBINARY
    private final RexBuilder rexBuilder = new RexBuilder(typeFactory);  
     * The VARBINARY guard: a UDF-form comparison whose operands are not both VARBINARY is not
            ReturnTypes.BOOLEAN_FORCE_NULLABLE,  
        RexNode left = field(0, SqlTypeName.VARBINARY);  
import org.apache.calcite.sql.type.OperandTypes;
 * comparisons pass through untouched, and the wrapped {@link ComparisonTemporalCoercionAdapter}  
        assertRewritesTo("NOT_EQUALS_IP", SqlKind.NOT_EQUALS, SqlStdOperatorTable.NOT_EQUALS);
        assertRewritesTo("GREATER_IP", SqlKind.GREATER_THAN, SqlStdOperatorTable.GREATER_THAN);
    /** A plain native comparator over VARBINARY (the post-BinaryFunctionAdapter shape) is left as-is. */  
        assertSame(original.getOperator(), ((RexCall) adapted).getOperator());
        RexNode ts = field(1, SqlTypeName.TIMESTAMP);
import org.apache.calcite.rel.type.RelDataType;
import org.opensearch.test.OpenSearchTestCase;
import org.apache.calcite.sql.SqlFunctionCategory;
import org.apache.calcite.rel.type.RelDataTypeFactory;
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        assertRewritesTo("GTE_IP", SqlKind.GREATER_THAN_OR_EQUAL, SqlStdOperatorTable.GREATER_THAN_OR_EQUAL);  
        RexCall original = call(ipCompareUdf("EQUALS_IP", SqlKind.EQUALS), left, right);
import org.apache.calcite.rex.RexNode;
        assertNotSame("temporal coercion must still fire through the wrapper", original, adapted);  
    }  
    private RexNode field(int index, SqlTypeName name) {
        RexCall original = call(ipCompareUdf("EQUALS_IP", SqlKind.EQUALS), field(0, SqlTypeName.VARBINARY), field(1, SqlTypeName.VARCHAR));
    public void testEqualsIpOverVarbinaryRewritesToNativeEquals() {
    }
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
package org.opensearch.be.datafusion;
        RexNode right = field(1, SqlTypeName.VARBINARY);
    private RexCall call(SqlOperator op, RexNode left, RexNode right) {
        assertSame(SqlTypeName.TIMESTAMP, adapted.getOperands().get(0).getType().getSqlTypeName());
    /**  
    public void testAllSixIpComparatorsRewrite() {  
        assertSame(original, adapted);
    private final RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        RexNode varchar = field(0, SqlTypeName.VARCHAR);  
    /** EQUALS_IP over two VARBINARY operands → native SqlStdOperatorTable.EQUALS, operands + type preserved. */
        assertSame(udfName + " must rewrite to its native comparator", expectedNative, adapted.getOperator());  
    /** Numeric native comparison — neither rewritten nor temporally coerced; unchanged. */
    /**
        return (RexCall) rexBuilder.makeCall(boolType, op, List.of(left, right));
        return rexBuilder.makeInputRef(typeFactory.createSqlType(name), index);
     * carrying a comparison {@link SqlKind}, distinct from the {@code SqlStdOperatorTable} singleton.  
/*  
     * rewritten (the IP-UDF path only ever produces VARBINARY operands on the analytics route).
        RexCall original = call(ipCompareUdf(udfName, kind), field(0, SqlTypeName.VARBINARY), field(1, SqlTypeName.VARBINARY));
    private final RelOptCluster cluster = RelOptCluster.create(new VolcanoPlanner(), rexBuilder);
 * SPDX-License-Identifier: Apache-2.0
        RexCall original = call(SqlStdOperatorTable.EQUALS, varchar, ts);
 * compatible open source license.
        return new SqlFunction(  
import org.apache.calcite.sql.SqlKind;
     * char-vs-timestamp comparison (the shared comparison slots must keep their temporal behavior).  
    }  
        );
import org.apache.calcite.plan.RelOptCluster;
    }
import org.apache.calcite.sql.SqlOperator;  
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
            kind,
        assertSame(original, adapted);  
     */  
        // Operator preserved (not swapped to a native comparator).  
 *
import org.apache.calcite.sql.type.ReturnTypes;  
        assertSame(SqlStdOperatorTable.EQUALS, adapted.getOperator());  
    }
        RexCall original = call(SqlStdOperatorTable.EQUALS, field(0, SqlTypeName.VARBINARY), field(1, SqlTypeName.VARBINARY));
    private void assertRewritesTo(String udfName, SqlKind kind, SqlOperator expectedNative) {  
import org.apache.calcite.sql.type.SqlTypeName;
     */
    public void testUdfComparisonWithNonVarbinaryOperandNotRewritten() {
    }  
        assertRewritesTo("EQUALS_IP", SqlKind.EQUALS, SqlStdOperatorTable.EQUALS);
 * operands are rewritten to native {@code SqlStdOperatorTable} comparators, native/non-VARBINARY
import org.apache.calcite.plan.volcano.VolcanoPlanner;  
        assertSame(ts, adapted.getOperands().get(1));
            null,
 * is still invoked.
        RexNode adapted = adapter.adapt(original, List.of(), cluster);  
        assertEquals(List.of(left, right), adapted.getOperands());
    /** All six IP-comparison UDFs map to the matching native comparator. */
    }  
    }
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    private final IpComparisonNormalizationAdapter adapter = new IpComparisonNormalizationAdapter(new ComparisonTemporalCoercionAdapter());
    public void testNativeEqualsOverVarbinaryPassesThrough() {
 * The OpenSearch Contributors require contributions made to  
    /**
     */
     * Stand-in for an SQL-plugin IP-comparison UDF (e.g. {@code EQUALS_IP}): a UDF-category operator
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
    private static SqlOperator ipCompareUdf(String name, SqlKind kind) {
    }
