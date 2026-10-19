    private CidrMatchFunctionAdapter adapter;
        return (RexCall) rexBuilder.makeCall(boolType, CIDRMATCH_OP, List.of(ip, cidr));
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        RexNode dynamicCidr = new RexInputRef(1, varchar);  
        assertTrue(result instanceof RexLiteral);
import org.opensearch.test.OpenSearchTestCase;
        RelDataType boolType = typeFactory.createSqlType(SqlTypeName.BOOLEAN);  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
}
        RexNode column = new RexInputRef(0, varbinary);  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        typeFactory = new JavaTypeFactoryImpl();
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
    public void testBothLiteralsInRangeFoldsToTrue() {
    }  
        RexNode result = adapter.adapt(call, List.of(), cluster);  
import org.apache.calcite.rex.RexLiteral;
import org.apache.calcite.rex.RexCall;
        RexCall andCall = (RexCall) result;  
import org.apache.calcite.sql.type.SqlTypeName;  
        RexCall call = makeCall(column, dynamicCidr);
        ReturnTypes.BOOLEAN_FORCE_NULLABLE,
 *   <li>both args literal &rarr; const-fold to a Boolean {@link RexLiteral}  
        assertEquals(Boolean.TRUE, ((RexLiteral) result).getValueAs(Boolean.class));
import org.apache.calcite.sql.type.ReturnTypes;
        assertEquals(SqlTypeName.BOOLEAN, result.getType().getSqlTypeName());  
    }
    private RelDataTypeFactory typeFactory;
        RexNode result = adapter.adapt(call, List.of(), cluster);
    }
public class CidrMatchFunctionAdapterTests extends OpenSearchTestCase {
import org.apache.calcite.sql.SqlFunctionCategory;
        assertTrue("expected RexCall (AND of two comparisons), got " + result.getClass(), result instanceof RexCall);
    public void testBothLiteralsOutOfRangeFoldsToFalse() {
 */  
import java.util.List;  
    }  
    );
    private RexLiteral varcharLiteral(String value) {
        SqlFunctionCategory.USER_DEFINED_FUNCTION
        RelDataType varbinary = typeFactory.createSqlType(SqlTypeName.VARBINARY);  
        rexBuilder = new RexBuilder(typeFactory);
    private RelOptCluster cluster;  
    }
        assertSame("dynamic cidr must fall through unchanged", call, result);
/**
        // Pure IPv6 literal in pure IPv6 range.  
        RexCall call = makeCall(varcharLiteral("2003:0db8::"), varcharLiteral("2003:db8::/32"));
    public void setUp() throws Exception {
package org.opensearch.be.datafusion;
        super.setUp();  
    private static final SqlFunction CIDRMATCH_OP = new SqlFunction(
        // Garbage input on either side: don't claim to know better than DataFusion.
import org.apache.calcite.rex.RexInputRef;  
    }  
        null,
import org.apache.calcite.sql.SqlFunction;  
    }  
    private RexBuilder rexBuilder;
        assertEquals(Boolean.FALSE, ((RexLiteral) result).getValueAs(Boolean.class));
/*  
        RelDataType varbinary = typeFactory.createSqlType(SqlTypeName.VARBINARY);
        assertTrue(result instanceof RexLiteral);  
        cluster = RelOptCluster.create(planner, rexBuilder);
    public void testIpv6LiteralFoldsCorrectly() {
        RexCall call = makeCall(column, varcharLiteral("1.2.3.0/24"));
    }
        RexNode result = adapter.adapt(call, List.of(), cluster);
    private RexCall makeCall(RexNode ip, RexNode cidr) {
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
 *
        "CIDRMATCH",
        return (RexLiteral) rexBuilder.makeLiteral(value, typeFactory.createSqlType(SqlTypeName.VARCHAR), false);
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());  
    @Override
        assertTrue(result instanceof RexLiteral);
    public void testDynamicCidrFallsThrough() {
import org.apache.calcite.plan.RelOptCluster;
 * The OpenSearch Contributors require contributions made to  
        assertSame(SqlStdOperatorTable.AND, andCall.getOperator());
import org.apache.calcite.sql.SqlKind;
 */
        assertSame(SqlStdOperatorTable.GREATER_THAN_OR_EQUAL, ((RexCall) andCall.getOperands().get(0)).getOperator());  
        adapter = new CidrMatchFunctionAdapter();
        RexNode result = adapter.adapt(call, List.of(), cluster);  
import org.apache.calcite.plan.hep.HepProgramBuilder;
 * Verifies the three-tier dispatch in {@link CidrMatchFunctionAdapter}:  
        SqlKind.OTHER_FUNCTION,  
        assertEquals(Boolean.TRUE, ((RexLiteral) result).getValueAs(Boolean.class));
    public void testUnparseableIpFallsThrough() {
 * </ol>  
import org.apache.calcite.sql.type.OperandTypes;
        // Non-literal cidr (a column reference) — should not be folded or rewritten.
import org.apache.calcite.rex.RexNode;
        RexCall call = makeCall(varcharLiteral("1.2.3.4"), varcharLiteral("1.2.3.0/24"));  
 * <ol>
    /** Stand-in for PPL's CIDRMATCH function — only operand shape + return type matter. */  
 *   <li>else &rarr; return original unchanged (DataFusion will fail loudly)
        assertSame(SqlStdOperatorTable.LESS_THAN_OR_EQUAL, ((RexCall) andCall.getOperands().get(1)).getOperator());
        RexNode result = adapter.adapt(call, List.of(), cluster);
        assertEquals(2, andCall.getOperands().size());
        OperandTypes.ANY_ANY,  
    public void testVarbinaryColumnWithCidrLiteralRewritesToByteRange() {
        RexCall call = makeCall(varcharLiteral("9.9.9.9"), varcharLiteral("1.2.3.0/24"));
        assertSame(call, result);
        RexCall call = makeCall(varcharLiteral("not-an-ip"), varcharLiteral("1.2.3.0/24"));  
import org.apache.calcite.plan.hep.HepPlanner;  
    }
import org.apache.calcite.rex.RexBuilder;
 *   <li>VARBINARY column + cidr literal &rarr; byte-range AND comparison
 *
        RexNode column = new RexInputRef(0, varbinary);
        RexNode result = adapter.adapt(call, List.of(), cluster);  
import org.apache.calcite.rel.type.RelDataType;
