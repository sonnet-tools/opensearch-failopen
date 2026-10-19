        RexNode start = cluster.intLiteral(3);  
            substringCall.getOperator()
            RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        RexCall outCall = assertStrposCall(adapter.adapt(call, List.of(), cluster.cluster));  
        assertEquals("CASE shape — WHEN cond THEN 0 ELSE adjusted", 3, caseCall.getOperands().size());
 * </ul>
            return rexBuilder.makeExactLiteral(BigDecimal.valueOf(value), intType);  
        RexNode start = cluster.intLiteral(3);
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
            ((org.apache.calcite.rex.RexLiteral) caseCall.getOperands().get(1)).getValueAs(Integer.class).intValue()  
import java.math.BigDecimal;
            cluster.stringLiteral("a"),
    /**
    /** Assert the adapted call is a 2-arg {@code strpos} call routed through the shared operator. */  
        RexNode substr = cluster.stringLiteral("a");
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
        RexNode str = cluster.stringLiteral("abc");  
import org.apache.calcite.plan.RelOptCluster;
        Cluster cluster = newCluster();  
        assertSame("4-arg POSITION is malformed and must pass through", call, out);
        RexCall caseCall = (RexCall) adapter.adapt(call, List.of(), cluster.cluster);  
    private static final class Cluster {
        }
        assertEquals("WHEN is an equality test", SqlKind.EQUALS, whenCond.getKind());  
        RexNode str = cluster.stringLiteral("FURNITURE");  
            "strpos",  
        ReturnTypes.INTEGER,
 *   <li>3-arg form: {@code POSITION(substr, str, start)} decomposes into a CASE
        SqlKind.POSITION,
    }  
    private static Cluster newCluster() {  
    private static RexCall assertStrposCall(RexNode out) {
    public void testAdaptedStrposIsTheSharedOperatorInstance() {  
            PositionAdapter.STRPOS.getName()
import org.apache.calcite.rex.RexNode;  
        RexNode substr = cluster.stringLiteral("U");
 * <ul>
    }
        assertSame(str, substringInWhen.getOperands().get(0));
        RexNode str = cluster.stringLiteral("FURNITURE");
        );
    }
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    }
    }
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(POSITION, substr, str, start);
        final RexBuilder rexBuilder;
            return rexBuilder.makeLiteral(value);
        Cluster cluster = newCluster();  
    /** {@code POSITION('U', 'FURNITURE')} → {@code strpos('FURNITURE', 'U')}. */
 *       {@code strpos(str, substr)}.</li>
    }  
        RexNode stringLiteral(String value) {  
 * Unit tests for {@link PositionAdapter}.
        // ELSE shape: MINUS(PLUS(strpos(substring(str, start), substr), start), 1)
        assertSame("ELSE arm's strpos reuses the shared operator", PositionAdapter.STRPOS, strposInElse.getOperator());
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.rex.RexBuilder;
 * <p>Coverage:
}
        // operand[2]: the ELSE arm is strpos(...) + start - 1.  
import org.apache.calcite.rex.RexCall;
        );
        );
    public void testThreeArgElseArmBuildsSubstringAndStrpos() {
        final RelOptCluster cluster;  
import org.apache.calcite.sql.type.OperandTypes;
import org.apache.calcite.sql.SqlFunction;
        return outCall;  
 *       expression around {@code substring(str, start)} + {@code strpos} + offset  
            this.typeFactory = typeFactory;  
     * {@code CASE WHEN strpos(substring(str, start), substr) = 0 THEN 0 ELSE strpos(...) + start - 1 END}.  
        assertEquals(  
            outCall.getOperator()
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(POSITION, substr, str, start);
    }  
        Cluster cluster = newCluster();
        Cluster cluster = newCluster();
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
            "THEN returns 0 when substring didn't contain substr",
        return new Cluster(cluster, typeFactory, rexBuilder);
        RexNode start = cluster.intLiteral(3);  
        RexCall elseArm = (RexCall) caseCall.getOperands().get(2);
    private static final SqlFunction POSITION = new SqlFunction(
        assertSame("1-arg POSITION is malformed and must pass through", call, out);  
        assertEquals("strpos must be (str, substr) — 2 operands", 2, outCall.getOperands().size());
        assertEquals("3-arg POSITION lowers to CASE", SqlKind.CASE, out.getKind());  
    );  
        RexNode str = cluster.stringLiteral("FURNITURE");
 *   <li>Malformed arity passes through unchanged (no 0, 1, or 4-arg rewrite).</li>  
        RexNode substr = cluster.stringLiteral("U");
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(POSITION, substr, str, start);
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
 *
    public void testThreeArgDecomposesToCaseOfSubstringStrpos() {  
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);  
        Cluster cluster = newCluster();  
        RexCall caseCall = (RexCall) adapter.adapt(call, List.of(), cluster.cluster);  
/**
            this.rexBuilder = rexBuilder;
import org.apache.calcite.plan.hep.HepPlanner;  
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());  
        final RelDataTypeFactory typeFactory;
public class PositionAdapterTests extends OpenSearchTestCase {  
            cluster.stringLiteral("abc"),
            cluster.intLiteral(1)
            this.cluster = cluster;
 */
    }  
        );  
            outCall.getOperator()
        assertSame(SqlStdOperatorTable.SUBSTRING, substringInWhen.getOperator());
        Cluster cluster = newCluster();  
 *   <li>2-arg form: {@code POSITION(substr, str)} swaps operands to  
        // operand[0]: strpos(substring(str, start), substr) = 0
        // WHEN: strpos(substring(str, start), substr) = 0  
            0,
        RexCall minusCall = (RexCall) caseCall.getOperands().get(2);  
            "operator is the shared strpos registered against the FunctionMappings.Sig",
        assertEquals(SqlKind.PLUS, plusCall.getKind());
        // operand[1]: the THEN value is the literal 0.
        RexCall strposInElse = (RexCall) plusCall.getOperands().get(0);  
    public void testFourArgPassesThrough() {  
        assertEquals(
import org.apache.calcite.rel.type.RelDataType;
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(
        Cluster cluster = newCluster();
        RexCall outCall = assertStrposCall(out);
        assertSame("first operand is str (was the second POSITION arg)", str, outCall.getOperands().get(0));  
        RexCall substringInWhen = (RexCall) strposInWhen.getOperands().get(0);  
import org.apache.calcite.sql.SqlFunctionCategory;
import org.apache.calcite.plan.hep.HepProgramBuilder;
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(POSITION, substr, str);  
        assertSame(
        assertEquals("ELSE performs the final offset subtraction", SqlKind.MINUS, elseArm.getKind());
 *       "{@code 0} on not found" contract both hold.</li>
 * SPDX-License-Identifier: Apache-2.0
    }  
            SqlStdOperatorTable.SUBSTRING,  
        RexNode substr = cluster.stringLiteral("U");
        assertSame(
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(POSITION, cluster.stringLiteral("a"));
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
     * This test asserts the outer CASE shape; the inner sub-calls are validated separately.
            POSITION,  
    public void testThreeArgWhenConditionMirrorsElseStrpos() {
/*  
        RexCall plusCall = (RexCall) minusCall.getOperands().get(0);
import org.opensearch.test.OpenSearchTestCase;
        assertSame("substring(str, start) — str is the original second POSITION operand", str, substringCall.getOperands().get(0));  
    }
        assertSame(
import java.util.List;
        null,  
        RexNode str = cluster.stringLiteral("FURNITURE");
 * this file be licensed under the Apache-2.0 license or a
        RexNode substr = cluster.stringLiteral("U");
            cluster.intLiteral(1),  
import org.apache.calcite.sql.SqlKind;  
        assertSame("substring(str, start) — start is the original third POSITION operand", start, substringCall.getOperands().get(1));
     * {@code POSITION('U', 'FURNITURE', 3)} decomposes to
        RexCall outCall = (RexCall) out;  
        RexCall whenCond = (RexCall) caseCall.getOperands().get(0);
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(POSITION, substr, str);
    // ── Helpers ───────────────────────────────────────────────────────────────
        RexCall whenCond = (RexCall) caseCall.getOperands().get(0);
        RexCall caseCall = (RexCall) out;
        assertSame("strpos substr is the original first POSITION operand", substr, strposInElse.getOperands().get(1));
 *  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        }
        assertSame("second operand is substr (was the first POSITION arg)", substr, outCall.getOperands().get(1));
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        }
        );
            PositionAdapter.STRPOS,  
    public void testTwoArgSwapsOperands() {
        RexNode intLiteral(int value) {
        assertSame(start, substringInWhen.getOperands().get(1));  
        Cluster(RelOptCluster cluster, RelDataTypeFactory typeFactory, RexBuilder rexBuilder) {
     */
 */  
        assertTrue("expected a RexCall, got " + out.getClass(), out instanceof RexCall);
        RexCall substringCall = (RexCall) strposInElse.getOperands().get(0);  
        OperandTypes.family(),
    private final PositionAdapter adapter = new PositionAdapter();
        SqlFunctionCategory.STRING
            PositionAdapter.STRPOS,
    public void testOneArgPassesThrough() {
            "substring call uses the standard SqlStdOperatorTable.SUBSTRING",
        "POSITION",  
import org.apache.calcite.sql.type.ReturnTypes;  
package org.opensearch.be.datafusion;
            "operator name is 'strpos' — what DataFusion's substrait consumer expects",
 *       arithmetic so the 1-indexed {@code start} parameter and the
        RexCall strposInWhen = (RexCall) whenCond.getOperands().get(0);
            "adapter must emit the shared PositionAdapter.STRPOS instance, not a clone",  
        );
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
        assertSame("WHEN condition's strpos is the shared operator", PositionAdapter.STRPOS, strposInWhen.getOperator());
