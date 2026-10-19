    /** {@code tonumber(x)} rewrites to {@code CAST(x AS DOUBLE)}. */
    /** Arities above 2 aren't declared in the PPL spec — pass through so planning fails loudly. */  
        RexNode baseArg = outCall.getOperands().get(1);
        return outCall;
            cluster.intLiteral(0)
    }
    private static final class Cluster {  
        }  
        Cluster cluster = newCluster();
        assertSame(
    /**
import org.apache.calcite.sql.type.OperandTypes;
        final RelDataTypeFactory typeFactory;
import java.math.BigDecimal;  
    }
        assertEquals("kind=SAFE_CAST", SqlKind.SAFE_CAST, out.getKind());
            this.cluster = cluster;  
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(  
/*  
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
        assertSame(call, out);  
        Cluster cluster = newCluster();  
    private static RexCall assertTonumberCall(RexNode out) {
import org.apache.calcite.sql.SqlFunctionCategory;
 * The OpenSearch Contributors require contributions made to  
 *
        SqlFunctionCategory.USER_DEFINED_FUNCTION  
        assertSame("INTEGER literal kept as-is", base, outCall.getOperands().get(1));
    public void testThreeArgPassesThrough() {
            cluster.stringLiteral("10"),
import org.apache.calcite.rex.RexBuilder;
        Cluster cluster = newCluster();
        RexNode input = cluster.varcharInputRef(0);  
            this.rexBuilder = rexBuilder;
import org.apache.calcite.sql.type.ReturnTypes;
        RexNode valueArg = outCall.getOperands().get(0);  
        final RelOptCluster cluster;
import java.util.List;
            ToNumberFunctionAdapter.TONUMBER,
            return rexBuilder.makeInputRef(varcharType, index);
    /** Synthetic tonumber operator used to build input RexCalls */
import org.apache.calcite.rel.type.RelDataType;
        RexCall outCall = (RexCall) out;
    private final ToNumberFunctionAdapter adapter = new ToNumberFunctionAdapter();  
        }
        }  
        SqlKind.OTHER_FUNCTION,
        assertEquals("two operands — value + base", 2, outCall.getOperands().size());
        RexCall outCall = assertTonumberCall(out);
 */  
        Cluster cluster = newCluster();
        RexBuilder rexBuilder = new RexBuilder(typeFactory);  
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(TONUMBER);
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
}
    );
        assertEquals("value arg normalized to VARCHAR", SqlTypeName.VARCHAR, valueArg.getType().getSqlTypeName());
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(TONUMBER, input);  
    private static final SqlFunction TONUMBER = new SqlFunction(  
    public void testSingleArgRewritesToDoubleCast() {  
        assertSame("VARCHAR operand kept as-is", input, outCall.getOperands().get(0));
        return new Cluster(cluster, typeFactory, rexBuilder);  
import org.apache.calcite.plan.hep.HepPlanner;  
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        assertSame("operand preserved by identity", input, castCall.getOperands().get(0));
import org.apache.calcite.sql.type.SqlTypeName;  
    // ── Helpers ───────────────────────────────────────────────────────────────  
    public void testTwoArgOnMatchingTypesSkipsRedundantCast() {
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
     */
        RexNode stringLiteral(String value) {
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        RexNode base = cluster.intLiteral(2);
        RexNode base = cluster.intLiteral(16);
    public void testTwoArgKeepsTonumberCallAndNormalizesOperands() {
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(TONUMBER, input, base);
import org.opensearch.test.OpenSearchTestCase;
        RexNode intLiteral(int value) {
            cluster.intLiteral(10),  
 * this file be licensed under the Apache-2.0 license or a
     * {@code tonumber(x, base)} stays a {@code tonumber}  
public class ToNumberFunctionAdapterTests extends OpenSearchTestCase {  
        RexCall outCall = assertTonumberCall(out);  
        RexNode varcharInputRef(int index) {
        ReturnTypes.DOUBLE,  
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        );
    /** Zero-operand {@code tonumber} is degenerate; adapter should pass it through unchanged. */
import org.apache.calcite.plan.hep.HepProgramBuilder;
        Cluster cluster = newCluster();
            return rexBuilder.makeExactLiteral(BigDecimal.valueOf(value), intType);
        OperandTypes.ANY_ANY,
    }  
import org.apache.calcite.sql.SqlFunction;
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
    }
    }  
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(TONUMBER, input, base);  
 * compatible open source license.
    }  
        RexNode input = cluster.stringLiteral("FA34");
import org.apache.calcite.sql.SqlKind;  
            RelDataType varcharType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);  
import org.apache.calcite.plan.RelOptCluster;
        final RexBuilder rexBuilder;  
    private static Cluster newCluster() {
            "operator is the synthetic `tonumber` that resolves to the Rust UDF",  
        assertEquals("single operand", 1, castCall.getOperands().size());
import org.apache.calcite.rex.RexCall;
            this.typeFactory = typeFactory;
    /** {@code tonumber(VARCHAR, INTEGER)} — already-normalized operands don't get redundant CASTs. */  
import org.apache.calcite.rex.RexNode;  
        assertEquals("base arg normalized to INTEGER", SqlTypeName.INTEGER, baseArg.getType().getSqlTypeName());  
package org.opensearch.be.datafusion;
 * SPDX-License-Identifier: Apache-2.0
        null,
        "tonumber",
        assertTrue("expected a RexCall, got " + out.getClass(), out instanceof RexCall);  
        Cluster(RelOptCluster cluster, RelDataTypeFactory typeFactory, RexBuilder rexBuilder) {
    }
        RexCall castCall = (RexCall) out;  
        RexNode input = cluster.stringLiteral("4598.678");
            RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);  
    }
        assertEquals("result type is DOUBLE", SqlTypeName.DOUBLE, out.getType().getSqlTypeName());
            outCall.getOperator()
            return rexBuilder.makeLiteral(value);
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
        );  
    public void testZeroArgPassesThrough() {  
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);
        assertSame(call, out);  
            TONUMBER,
        }
