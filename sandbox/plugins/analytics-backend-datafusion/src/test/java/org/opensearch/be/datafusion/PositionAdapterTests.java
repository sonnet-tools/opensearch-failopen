        Cluster cluster = newCluster();
        }
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
        assertSame("WHEN condition's strpos is the shared operator", PositionAdapter.STRPOS, strposInWhen.getOperator());
        // WHEN: strpos(substring(str, start), substr) = 0
        // operand[0]: strpos(substring(str, start), substr) = 0
import org.apache.calcite.rex.RexCall;
            cluster.intLiteral(1)
    /** Assert the adapted call is a 2-arg {@code strpos} call routed through the shared operator. */
        RexNode start = cluster.intLiteral(3);
import org.apache.calcite.sql.SqlFunctionCategory;
            "substring call uses the standard SqlStdOperatorTable.SUBSTRING",
    public void testAdaptedStrposIsTheSharedOperatorInstance() {
        assertEquals("strpos must be (str, substr) — 2 operands", 2, outCall.getOperands().size());
        assertEquals("CASE shape — WHEN cond THEN 0 ELSE adjusted", 3, caseCall.getOperands().size());
    }
        RexNode str = cluster.stringLiteral("FURNITURE");
        assertSame(
import java.util.List;
            RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        final RexBuilder rexBuilder;
 * SPDX-License-Identifier: Apache-2.0
 *       arithmetic so the 1-indexed {@code start} parameter and the
        assertEquals("WHEN is an equality test", SqlKind.EQUALS, whenCond.getKind());
        RexNode intLiteral(int value) {
        final RelDataTypeFactory typeFactory;
    }
        RexNode str = cluster.stringLiteral("FURNITURE");
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
    // ── Helpers ───────────────────────────────────────────────────────────────
            "adapter must emit the shared PositionAdapter.STRPOS instance, not a clone",
        RexNode substr = cluster.stringLiteral("U");
        RexNode str = cluster.stringLiteral("FURNITURE");
import org.apache.calcite.sql.type.SqlTypeName;
        );
import org.apache.calcite.sql.SqlKind;
        Cluster(RelOptCluster cluster, RelDataTypeFactory typeFactory, RexBuilder rexBuilder) {
        return outCall;
        assertSame(str, substringInWhen.getOperands().get(0));
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        Cluster cluster = newCluster();
        }
import org.apache.calcite.rex.RexNode;
            return rexBuilder.makeLiteral(value);
}
 *       expression around {@code substring(str, start)} + {@code strpos} + offset
        assertSame("strpos substr is the original first POSITION operand", substr, strposInElse.getOperands().get(1));
import org.apache.calcite.sql.type.ReturnTypes;
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(POSITION, substr, str, start);
 *
    }
import java.math.BigDecimal;
import org.apache.calcite.sql.type.OperandTypes;
        RexCall whenCond = (RexCall) caseCall.getOperands().get(0);
        assertSame(
 * Unit tests for {@link PositionAdapter}.
    }
    }
            "operator name is 'strpos' — what DataFusion's substrait consumer expects",
 * <p>Coverage:
        RexCall elseArm = (RexCall) caseCall.getOperands().get(2);
        assertEquals("ELSE performs the final offset subtraction", SqlKind.MINUS, elseArm.getKind());
    public void testOneArgPassesThrough() {
        Cluster cluster = newCluster();
/**
     * This test asserts the outer CASE shape; the inner sub-calls are validated separately.
    private static RexCall assertStrposCall(RexNode out) {
    public void testThreeArgElseArmBuildsSubstringAndStrpos() {
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
            substringCall.getOperator()
        assertSame("substring(str, start) — str is the original second POSITION operand", str, substringCall.getOperands().get(0));
            "strpos",
        "POSITION",
import org.apache.calcite.sql.SqlFunction;
        RexCall caseCall = (RexCall) adapter.adapt(call, List.of(), cluster.cluster);
import org.apache.calcite.plan.RelOptCluster;
 * </ul>
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
            cluster.intLiteral(1),
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(POSITION, substr, str);
        Cluster cluster = newCluster();
        RexNode str = cluster.stringLiteral("abc");
            "THEN returns 0 when substring didn't contain substr",
        RexNode stringLiteral(String value) {
            0,
    }
        RexNode substr = cluster.stringLiteral("U");
 *   <li>3-arg form: {@code POSITION(substr, str, start)} decomposes into a CASE
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
     * {@code CASE WHEN strpos(substring(str, start), substr) = 0 THEN 0 ELSE strpos(...) + start - 1 END}.
/*
public class PositionAdapterTests extends OpenSearchTestCase {
        assertTrue("expected a RexCall, got " + out.getClass(), out instanceof RexCall);
        RexCall strposInElse = (RexCall) plusCall.getOperands().get(0);
        OperandTypes.family(),
        );
package org.opensearch.be.datafusion;
 *       {@code strpos(str, substr)}.</li>
import org.apache.calcite.rex.RexBuilder;
    public void testThreeArgDecomposesToCaseOfSubstringStrpos() {
            PositionAdapter.STRPOS,
        RexCall whenCond = (RexCall) caseCall.getOperands().get(0);
        RexNode substr = cluster.stringLiteral("a");
        RexCall strposInWhen = (RexCall) whenCond.getOperands().get(0);
 * The OpenSearch Contributors require contributions made to
        RexCall outCall = assertStrposCall(adapter.adapt(call, List.of(), cluster.cluster));
    }
import org.apache.calcite.rel.type.RelDataType;
 *       "{@code 0} on not found" contract both hold.</li>
        assertSame("ELSE arm's strpos reuses the shared operator", PositionAdapter.STRPOS, strposInElse.getOperator());
        RexNode substr = cluster.stringLiteral("U");
        assertEquals("3-arg POSITION lowers to CASE", SqlKind.CASE, out.getKind());
        // ELSE shape: MINUS(PLUS(strpos(substring(str, start), substr), start), 1)
    }
 * this file be licensed under the Apache-2.0 license or a
    public void testThreeArgWhenConditionMirrorsElseStrpos() {
        assertSame("4-arg POSITION is malformed and must pass through", call, out);
 *
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        );
        ReturnTypes.INTEGER,
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(POSITION, substr, str);
        // operand[2]: the ELSE arm is strpos(...) + start - 1.
        RexCall caseCall = (RexCall) adapter.adapt(call, List.of(), cluster.cluster);
        );
            cluster.stringLiteral("abc"),
    private static final SqlFunction POSITION = new SqlFunction(
        SqlKind.POSITION,
        RexNode start = cluster.intLiteral(3);
        RexCall outCall = assertStrposCall(out);
        RexNode start = cluster.intLiteral(3);
        SqlFunctionCategory.STRING
    private static final class Cluster {
        );
 *   <li>2-arg form: {@code POSITION(substr, str)} swaps operands to
     */
            cluster.stringLiteral("a"),
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(POSITION, substr, str, start);
        RexNode substr = cluster.stringLiteral("U");
        assertSame(SqlStdOperatorTable.SUBSTRING, substringInWhen.getOperator());
import org.apache.calcite.rel.type.RelDataTypeFactory;
    /** {@code POSITION('U', 'FURNITURE')} → {@code strpos('FURNITURE', 'U')}. */
 * compatible open source license.
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
    );
        assertSame("second operand is substr (was the first POSITION arg)", substr, outCall.getOperands().get(1));
    private static Cluster newCluster() {
    public void testFourArgPassesThrough() {
            PositionAdapter.STRPOS.getName()
            outCall.getOperator()
    }
        assertSame("substring(str, start) — start is the original third POSITION operand", start, substringCall.getOperands().get(1));
        assertEquals(SqlKind.PLUS, plusCall.getKind());
            this.cluster = cluster;
 * <ul>
import org.apache.calcite.plan.hep.HepProgramBuilder;
        assertEquals(
        RexCall caseCall = (RexCall) out;
 */
    public void testTwoArgSwapsOperands() {
     * {@code POSITION('U', 'FURNITURE', 3)} decomposes to
        RexNode str = cluster.stringLiteral("FURNITURE");
        assertSame(
            SqlStdOperatorTable.SUBSTRING,
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
        RexCall substringCall = (RexCall) strposInElse.getOperands().get(0);
            this.rexBuilder = rexBuilder;
        }
        assertSame("1-arg POSITION is malformed and must pass through", call, out);
        Cluster cluster = newCluster();
    private final PositionAdapter adapter = new PositionAdapter();
        assertSame(start, substringInWhen.getOperands().get(1));
        null,
        RexCall minusCall = (RexCall) caseCall.getOperands().get(2);
            return rexBuilder.makeExactLiteral(BigDecimal.valueOf(value), intType);
            PositionAdapter.STRPOS,
 *   <li>Malformed arity passes through unchanged (no 0, 1, or 4-arg rewrite).</li>
        final RelOptCluster cluster;
        RexCall outCall = (RexCall) out;
    /**
        assertSame("first operand is str (was the second POSITION arg)", str, outCall.getOperands().get(0));
        assertEquals(
        // operand[1]: the THEN value is the literal 0.
        RexCall substringInWhen = (RexCall) strposInWhen.getOperands().get(0);
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(POSITION, substr, str, start);
 */
        Cluster cluster = newCluster();
import org.apache.calcite.plan.hep.HepPlanner;
            POSITION,
            ((org.apache.calcite.rex.RexLiteral) caseCall.getOperands().get(1)).getValueAs(Integer.class).intValue()
        );
            "operator is the shared strpos registered against the FunctionMappings.Sig",
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(POSITION, cluster.stringLiteral("a"));
import org.opensearch.test.OpenSearchTestCase;
        return new Cluster(cluster, typeFactory, rexBuilder);
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);
    }
            outCall.getOperator()
        Cluster cluster = newCluster();
            this.typeFactory = typeFactory;
        RexCall plusCall = (RexCall) minusCall.getOperands().get(0);
