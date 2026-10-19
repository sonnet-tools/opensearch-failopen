            "operator is the synthetic `tostring` that resolves to the Rust UDF",
            RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        assertSame(
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
        }
        return new Cluster(cluster, typeFactory, rexBuilder);
     *  {@code PPLBuiltinOperators.NUMBER_TO_STRING} isn't reachable from this module, so we
        assertEquals("result type is VARCHAR", SqlTypeName.VARCHAR, out.getType().getSqlTypeName());
    private static final class Cluster {
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(TOSTRING, boolInput, cluster.stringLiteral("hex"));
    private static final SqlFunction TOSTRING = new SqlFunction(
        Cluster(RelOptCluster cluster, RelDataTypeFactory typeFactory, RexBuilder rexBuilder) {
        );
     * Assert that the rewrite produced a {@code tostring(...)} call routed through
        RexCall caseCall = (RexCall) out;
        SqlFunctionCategory.USER_DEFINED_FUNCTION
import org.apache.calcite.sql.type.SqlTypeName;
    public void testUnsupportedFormatPassesThrough() {
        RexCall castCall = (RexCall) out;
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
        SqlKind.OTHER_FUNCTION,
            operand.getType().getSqlTypeName()
     *  declare a same-named clone that the adapter will match by
 * SPDX-License-Identifier: Apache-2.0
            this.typeFactory = typeFactory;
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
    /**
    public void testCommasFormatOnIntegerWidensToBigint() {
     * {@link ToStringFunctionAdapter#TOSTRING}. Returns the RexCall for further assertions.
import org.apache.calcite.plan.hep.HepPlanner;
    }
        ReturnTypes.VARCHAR,
    }
    }
        RexCall castCall = (RexCall) out;
            BigDecimal.valueOf(100L),
        final RexBuilder rexBuilder;
     * paths both route identically.
        assertSame("numeric operand preserved by identity", doubleInput, castCall.getOperands().get(0));
import org.opensearch.test.OpenSearchTestCase;
    private static Cluster newCluster() {
        assertEquals(SqlTypeName.VARCHAR, out.getType().getSqlTypeName());
        );
        assertEquals("NUMBER_TO_STRING lowers to CAST", SqlKind.CAST, out.getKind());
        Cluster cluster = newCluster();
    /** {@code tostring(double, 'commas')} preserves fractional precision by routing through DOUBLE. */
     * name the Rust UDF registers under) with the numeric argument widened to BIGINT.
    /** {@code tostring(x, 'xyzzy')} is an unsupported format; the call is returned unchanged. */
            ((RexLiteral) caseCall.getOperands().get(3)).getValueAs(String.class)
    public void testBooleanOneArgLowersToCase() {
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
        assertEquals("FALSE", ((RexLiteral) caseCall.getOperands().get(3)).getValueAs(String.class));
        final RelOptCluster cluster;
package org.opensearch.be.datafusion;
import org.apache.calcite.sql.type.OperandTypes;
    /** {@code tostring(int, 'commas')} widens integer sources to BIGINT, same as every other mode. */
 */
        assertEquals("TRUE", ((RexLiteral) caseCall.getOperands().get(1)).getValueAs(String.class));
        assertEquals("single operand", 1, castCall.getOperands().size());
        RexCall outCall = assertTostringCall(out);
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(TOSTRING, intInput, cluster.stringLiteral("commas"));
    }
        assertEquals("first THEN literal is uppercase TRUE", "TRUE", ((RexLiteral) caseCall.getOperands().get(1)).getValueAs(String.class));
    );
        assertEquals("integer widened to BIGINT to match the UDF signature", SqlTypeName.BIGINT, operand.getType().getSqlTypeName());
import org.apache.calcite.rex.RexBuilder;
    }
     * {@code NUMBER_TO_STRING(num)} call. That PPL-plugin UDF isn't in any Substrait catalog,
            return rexBuilder.makeLiteral(value);
        }
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
        RexNode intLiteral(int value) {
/*
            outCall.getOperator()
        SqlKind.OTHER_FUNCTION,
            cluster.typeFactory.createSqlType(SqlTypeName.DOUBLE)
 * this file be licensed under the Apache-2.0 license or a
    }
        assertEquals("kind=CAST", SqlKind.CAST, out.getKind());
    }
    /** {@code tostring(bigint, 'binary')} — no CAST needed because the operand is already BIGINT. */
     * {@code tostring(BOOLEAN, '<any_format>')} ignores the format
    private final ToStringFunctionAdapter adapter = new ToStringFunctionAdapter();
    // ── Helpers ───────────────────────────────────────────────────────────────
        Cluster cluster = newCluster();
        assertSame(decimalInput, castCall.getOperands().get(0));
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(NUMBER_TO_STRING, doubleInput);
    public void testNumberToStringLowersToVarcharCast() {
            "FALSE",
 * compatible open source license.
import org.apache.calcite.rel.type.RelDataType;
        );
        );
    public void testBinaryFormatOnBigintDoesNotReinsertCast() {
            "double kept as DOUBLE — 2-decimal rounding happens inside the UDF",
}
        RexNode booleanLiteral(boolean value) {
        // CASE shape: WHEN value THEN 'TRUE' WHEN NOT value THEN 'FALSE' ELSE NULL.
        RelDataType decimalType = cluster.typeFactory.createSqlType(SqlTypeName.DECIMAL, 10, 2);
            "second THEN literal is uppercase FALSE",
        assertEquals("boolean tostring lowers to CASE", SqlKind.CASE, out.getKind());
import org.apache.calcite.rex.RexNode;
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
        }
public class ToStringFunctionAdapterTests extends OpenSearchTestCase {
import java.util.List;
        assertSame("operand preserved by identity", input, castCall.getOperands().get(0));
        RexNode intInput = cluster.intLiteral(255);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.apache.calcite.plan.hep.HepProgramBuilder;
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        OperandTypes.ANY_ANY,
import org.apache.calcite.rex.RexLiteral;
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(NUMBER_TO_STRING, decimalInput);
     */
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
        RexCall outCall = assertTostringCall(out);
    /** Synthetic {@code NUMBER_TO_STRING} operator — the PPL plugin's
        return outCall;
     */
    /** {@code tostring(x)} rewrites to {@code CAST(x AS VARCHAR)}. */
        RexNode decimalInput = cluster.rexBuilder.makeExactLiteral(BigDecimal.valueOf(12.3), decimalType);
            cluster.typeFactory.createSqlType(SqlTypeName.DOUBLE)
        Cluster cluster = newCluster();
            this.rexBuilder = rexBuilder;
     * {@code tostring(x, 'hex')} stays a {@code tostring} call (operator rebound to the
        Cluster cluster = newCluster();
        "tostring",
    /** Synthetic tostring operator used to build input RexCalls. */
     */
     * {@code tostring(BOOLEAN)} lowers to a {@code CASE} that emits the uppercase
            BigDecimal.valueOf(12.5),
     */
    public void testCommasFormatOnDoublePreservesFractionalPrecision() {
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
     * so the adapter must lower it back to a plain VARCHAR cast for DataFusion — DataFusion's
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(TOSTRING, intInput, cluster.stringLiteral("hex"));
        assertEquals(
        final RelDataTypeFactory typeFactory;
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(TOSTRING, boolInput);
     * adapter branches on operator name, not operand type, so decimal and approximate-numeric
import org.apache.calcite.sql.SqlKind;
    }
        OperandTypes.NUMERIC,
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        assertSame("unknown format mode should leave the RexCall untouched so downstream planning fails loudly", call, out);
import org.apache.calcite.sql.SqlFunctionCategory;
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
            cluster.typeFactory.createSqlType(SqlTypeName.BIGINT)
    private static RexCall assertTostringCall(RexNode out) {
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
        assertEquals("single operand", 1, castCall.getOperands().size());
    /**
     */
        assertTrue("expected a RexCall, got " + out.getClass(), out instanceof RexCall);
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);
        RexNode operand = outCall.getOperands().get(0);
        RexNode intInput = cluster.intLiteral(12345);
        assertSame("bigint operand is used directly — no redundant CAST", bigintInput, outCall.getOperands().get(0));
        assertEquals("decimal NUMBER_TO_STRING also lowers to CAST", SqlKind.CAST, out.getKind());
        RexNode doubleInput = cluster.rexBuilder.makeApproxLiteral(
        RexNode bigintInput = cluster.rexBuilder.makeExactLiteral(
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(TOSTRING, doubleInput, cluster.stringLiteral("commas"));
    // ── NUMBER_TO_STRING: PPL's intercepted numeric-to-varchar cast ───────────
        "NUMBER_TO_STRING",
        ReturnTypes.VARCHAR,
import org.apache.calcite.plan.RelOptCluster;
        RexNode boolInput = cluster.nullableBooleanInputRef(0);
        }
            return rexBuilder.makeExactLiteral(BigDecimal.valueOf(value), intType);
            return rexBuilder.makeInputRef(boolType, index);
        Cluster cluster = newCluster();
        RexNode input = cluster.intLiteral(39225);
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
        Cluster cluster = newCluster();
    }
     * PPL's {@code ExtendedRexBuilder.makeCast} rewrites {@code CAST(num AS VARCHAR)} into a
        assertEquals("boolean tostring(x, fmt) lowers to CASE regardless of format", SqlKind.CASE, out.getKind());
            RelDataType boolType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BOOLEAN), true);
        Cluster cluster = newCluster();
    public void testBooleanTwoArgIgnoresFormat() {
import org.apache.calcite.rex.RexCall;
    }
import org.apache.calcite.sql.SqlFunction;
        RexNode boolInput = cluster.booleanLiteral(true);
        assertEquals("result type is VARCHAR", SqlTypeName.VARCHAR, out.getType().getSqlTypeName());
    }
        assertEquals("CASE has two WHEN branches plus ELSE — 5 operands total", 5, caseCall.getOperands().size());
        }
    public void testSingleArgRewritesToVarcharCast() {
    /**
        null,
        Cluster cluster = newCluster();
            return rexBuilder.makeLiteral(value);
        assertEquals(
        RexCall outCall = assertTostringCall(out);
    public void testHexFormatKeepsTostringCallAndWidensToBigint() {
    /**
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(TOSTRING, bigintInput, cluster.stringLiteral("binary"));
            SqlTypeName.DOUBLE,
        assertEquals("two operands — value + format literal", 2, outCall.getOperands().size());
        RexNode stringLiteral(String value) {
        RexNode nullableBooleanInputRef(int index) {
 * The OpenSearch Contributors require contributions made to
        Cluster cluster = newCluster();
     * {@code NUMBER_TO_STRING} over a DECIMAL source — still lowers to a VARCHAR cast. The
        SqlFunctionCategory.USER_DEFINED_FUNCTION
        );
        assertEquals(SqlTypeName.BIGINT, outCall.getOperands().get(0).getType().getSqlTypeName());
    /**
    );
    }
        Cluster cluster = newCluster();
import org.apache.calcite.sql.type.ReturnTypes;
 *
            BigDecimal.valueOf(12.3),
    /**
        RexCall outCall = (RexCall) out;
        null,
import java.math.BigDecimal;
        RexNode doubleInput = cluster.rexBuilder.makeApproxLiteral(
import org.apache.calcite.rel.type.RelDataTypeFactory;
        RexCall outCall = assertTostringCall(out);
     */
            ToStringFunctionAdapter.TOSTRING,
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(TOSTRING, cluster.intLiteral(42), cluster.stringLiteral("xyzzy"));
        RexCall castCall = (RexCall) out;
     * {@code 'TRUE'} / {@code 'FALSE'}
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(TOSTRING, input);
        assertEquals("CASE returns VARCHAR", SqlTypeName.VARCHAR, out.getType().getSqlTypeName());
     * native numeric-to-string formatting is used in place of Java's {@code Number.toString}.
        RexCall caseCall = (RexCall) out;
    }
    public void testNumberToStringOnDecimalLowersToVarcharCast() {
    private static final SqlFunction NUMBER_TO_STRING = new SqlFunction(
        );
     *  {@link org.apache.calcite.sql.SqlOperator#getName()}. */
            this.cluster = cluster;
        RexNode operand = outCall.getOperands().get(0);
