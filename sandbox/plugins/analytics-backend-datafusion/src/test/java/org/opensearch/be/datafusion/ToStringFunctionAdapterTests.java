        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
    public void testBooleanOneArgLowersToCase() {  
        Cluster cluster = newCluster();  
    public void testCommasFormatOnDoublePreservesFractionalPrecision() {  
        assertEquals("boolean tostring lowers to CASE", SqlKind.CASE, out.getKind());
        null,
        RexNode intInput = cluster.intLiteral(12345);
        assertTrue("expected a RexCall, got " + out.getClass(), out instanceof RexCall);
    // ── NUMBER_TO_STRING: PPL's intercepted numeric-to-varchar cast ───────────  
    public void testBinaryFormatOnBigintDoesNotReinsertCast() {  
    /**  
            this.typeFactory = typeFactory;
        Cluster cluster = newCluster();
        RexCall outCall = assertTostringCall(out);
        Cluster cluster = newCluster();  
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
    /**
            return rexBuilder.makeExactLiteral(BigDecimal.valueOf(value), intType);
    /**
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
            RelDataType boolType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.BOOLEAN), true);
import org.apache.calcite.plan.hep.HepPlanner;  
import org.apache.calcite.rex.RexLiteral;  
    private final ToStringFunctionAdapter adapter = new ToStringFunctionAdapter();  
    private static RexCall assertTostringCall(RexNode out) {  
     * {@code tostring(BOOLEAN, '<any_format>')} ignores the format  
            SqlTypeName.DOUBLE,
        RexNode booleanLiteral(boolean value) {  
    public void testSingleArgRewritesToVarcharCast() {
        assertSame(decimalInput, castCall.getOperands().get(0));
            "double kept as DOUBLE — 2-decimal rounding happens inside the UDF",
     * {@code NUMBER_TO_STRING(num)} call. That PPL-plugin UDF isn't in any Substrait catalog,
        return new Cluster(cluster, typeFactory, rexBuilder);
        Cluster cluster = newCluster();  
     */
    /** {@code tostring(x)} rewrites to {@code CAST(x AS VARCHAR)}. */  
        assertSame("bigint operand is used directly — no redundant CAST", bigintInput, outCall.getOperands().get(0));
        }
 * this file be licensed under the Apache-2.0 license or a
    }  
    public void testBooleanTwoArgIgnoresFormat() {
        RexCall castCall = (RexCall) out;
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        RexNode boolInput = cluster.booleanLiteral(true);
     * paths both route identically.
        final RelOptCluster cluster;
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);  
        "NUMBER_TO_STRING",
        assertEquals("single operand", 1, castCall.getOperands().size());  
    }
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(TOSTRING, cluster.intLiteral(42), cluster.stringLiteral("xyzzy"));
import org.apache.calcite.rex.RexNode;
        assertEquals(
            ((RexLiteral) caseCall.getOperands().get(3)).getValueAs(String.class)
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);  
        assertEquals("CASE has two WHEN branches plus ELSE — 5 operands total", 5, caseCall.getOperands().size());
            cluster.typeFactory.createSqlType(SqlTypeName.BIGINT)
    }
        return outCall;
        assertSame("numeric operand preserved by identity", doubleInput, castCall.getOperands().get(0));
import org.apache.calcite.plan.RelOptCluster;
        assertEquals("decimal NUMBER_TO_STRING also lowers to CAST", SqlKind.CAST, out.getKind());
        assertEquals("CASE returns VARCHAR", SqlTypeName.VARCHAR, out.getType().getSqlTypeName());
 *
    /** {@code tostring(bigint, 'binary')} — no CAST needed because the operand is already BIGINT. */
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(TOSTRING, input);
    }
     * Assert that the rewrite produced a {@code tostring(...)} call routed through  
    /**
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
            "FALSE",  
        );
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(NUMBER_TO_STRING, doubleInput);
    private static final SqlFunction TOSTRING = new SqlFunction(  
import org.apache.calcite.plan.hep.HepProgramBuilder;
        assertEquals("result type is VARCHAR", SqlTypeName.VARCHAR, out.getType().getSqlTypeName());  
    /** Synthetic {@code NUMBER_TO_STRING} operator — the PPL plugin's
     */  
        );
            cluster.typeFactory.createSqlType(SqlTypeName.DOUBLE)  
        final RexBuilder rexBuilder;
    public void testNumberToStringOnDecimalLowersToVarcharCast() {  
    }  
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
    public void testUnsupportedFormatPassesThrough() {
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);  
        );
            BigDecimal.valueOf(100L),  
    }  
        assertEquals("single operand", 1, castCall.getOperands().size());
 */  
            return rexBuilder.makeLiteral(value);  
            "second THEN literal is uppercase FALSE",
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(TOSTRING, intInput, cluster.stringLiteral("commas"));
        RexNode operand = outCall.getOperands().get(0);
        RelDataType decimalType = cluster.typeFactory.createSqlType(SqlTypeName.DECIMAL, 10, 2);
import java.util.List;
        assertSame("unknown format mode should leave the RexCall untouched so downstream planning fails loudly", call, out);
    /** {@code tostring(x, 'xyzzy')} is an unsupported format; the call is returned unchanged. */
     */
        assertEquals("integer widened to BIGINT to match the UDF signature", SqlTypeName.BIGINT, operand.getType().getSqlTypeName());
            operand.getType().getSqlTypeName()  
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(NUMBER_TO_STRING, decimalInput);
            cluster.typeFactory.createSqlType(SqlTypeName.DOUBLE)
    }
        RexNode operand = outCall.getOperands().get(0);
    }  
        }
     * PPL's {@code ExtendedRexBuilder.makeCast} rewrites {@code CAST(num AS VARCHAR)} into a  
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);  
    /** {@code tostring(int, 'commas')} widens integer sources to BIGINT, same as every other mode. */
        RexCall outCall = assertTostringCall(out);
        }
    }  
import org.apache.calcite.sql.SqlFunction;
        SqlKind.OTHER_FUNCTION,
import org.apache.calcite.sql.type.SqlTypeName;
     *  declare a same-named clone that the adapter will match by
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(TOSTRING, intInput, cluster.stringLiteral("hex"));
 * compatible open source license.
    }
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
import org.apache.calcite.rex.RexCall;
     */
            return rexBuilder.makeInputRef(boolType, index);  
     * adapter branches on operator name, not operand type, so decimal and approximate-numeric  
            outCall.getOperator()  
    private static Cluster newCluster() {
        assertEquals(SqlTypeName.VARCHAR, out.getType().getSqlTypeName());  
        RexNode decimalInput = cluster.rexBuilder.makeExactLiteral(BigDecimal.valueOf(12.3), decimalType);  
        Cluster cluster = newCluster();
    public void testHexFormatKeepsTostringCallAndWidensToBigint() {
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(TOSTRING, doubleInput, cluster.stringLiteral("commas"));  
        RexNode doubleInput = cluster.rexBuilder.makeApproxLiteral(
        RexNode input = cluster.intLiteral(39225);  
import org.apache.calcite.sql.type.OperandTypes;
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);  
        RexNode intInput = cluster.intLiteral(255);  
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(TOSTRING, boolInput, cluster.stringLiteral("hex"));
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
        RexCall caseCall = (RexCall) out;
        assertSame(  
        Cluster cluster = newCluster();
        // CASE shape: WHEN value THEN 'TRUE' WHEN NOT value THEN 'FALSE' ELSE NULL.
        assertEquals(SqlTypeName.BIGINT, outCall.getOperands().get(0).getType().getSqlTypeName());
        SqlKind.OTHER_FUNCTION,
        );
     */
        assertEquals("result type is VARCHAR", SqlTypeName.VARCHAR, out.getType().getSqlTypeName());
        assertEquals("NUMBER_TO_STRING lowers to CAST", SqlKind.CAST, out.getKind());  
     *  {@code PPLBuiltinOperators.NUMBER_TO_STRING} isn't reachable from this module, so we  
        RexNode boolInput = cluster.nullableBooleanInputRef(0);
    );
    /**
    }
        RexCall outCall = (RexCall) out;
import java.math.BigDecimal;
     * name the Rust UDF registers under) with the numeric argument widened to BIGINT.
        RexCall caseCall = (RexCall) out;  
            BigDecimal.valueOf(12.5),  
     * {@code tostring(x, 'hex')} stays a {@code tostring} call (operator rebound to the
        SqlFunctionCategory.USER_DEFINED_FUNCTION  
        null,
     * {@code 'TRUE'} / {@code 'FALSE'}
        Cluster(RelOptCluster cluster, RelDataTypeFactory typeFactory, RexBuilder rexBuilder) {  
     * so the adapter must lower it back to a plain VARCHAR cast for DataFusion — DataFusion's
        RexNode nullableBooleanInputRef(int index) {
        assertEquals(  
        }
        assertEquals("two operands — value + format literal", 2, outCall.getOperands().size());  
            BigDecimal.valueOf(12.3),
/*  
        RexCall castCall = (RexCall) out;
        "tostring",
import org.apache.calcite.sql.SqlFunctionCategory;  
     */
        RexNode stringLiteral(String value) {
    }  
        Cluster cluster = newCluster();
        assertEquals("kind=CAST", SqlKind.CAST, out.getKind());
        final RelDataTypeFactory typeFactory;  
            this.cluster = cluster;
        Cluster cluster = newCluster();  
        assertEquals("FALSE", ((RexLiteral) caseCall.getOperands().get(3)).getValueAs(String.class));  
import org.apache.calcite.rel.type.RelDataType;
            ToStringFunctionAdapter.TOSTRING,
        OperandTypes.ANY_ANY,
import org.apache.calcite.rex.RexBuilder;
    /** {@code tostring(double, 'commas')} preserves fractional precision by routing through DOUBLE. */
 * The OpenSearch Contributors require contributions made to  
     * {@code tostring(BOOLEAN)} lowers to a {@code CASE} that emits the uppercase  
        assertEquals("TRUE", ((RexLiteral) caseCall.getOperands().get(1)).getValueAs(String.class));
        RexCall outCall = assertTostringCall(out);
    // ── Helpers ───────────────────────────────────────────────────────────────  
    );
        ReturnTypes.VARCHAR,  
        RexCall castCall = (RexCall) out;
        assertEquals("boolean tostring(x, fmt) lowers to CASE regardless of format", SqlKind.CASE, out.getKind());  
     * {@link ToStringFunctionAdapter#TOSTRING}. Returns the RexCall for further assertions.
            this.rexBuilder = rexBuilder;  
        SqlFunctionCategory.USER_DEFINED_FUNCTION  
    public void testCommasFormatOnIntegerWidensToBigint() {
            RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        RexNode intLiteral(int value) {  
        );
    }
     * native numeric-to-string formatting is used in place of Java's {@code Number.toString}.  
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
        RexNode bigintInput = cluster.rexBuilder.makeExactLiteral(
     *  {@link org.apache.calcite.sql.SqlOperator#getName()}. */
        RexNode doubleInput = cluster.rexBuilder.makeApproxLiteral(
import org.apache.calcite.sql.type.ReturnTypes;  
        Cluster cluster = newCluster();
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(TOSTRING, boolInput);  
        RexNode out = adapter.adapt(call, List.of(), cluster.cluster);
        assertEquals("first THEN literal is uppercase TRUE", "TRUE", ((RexLiteral) caseCall.getOperands().get(1)).getValueAs(String.class));  
        RexCall call = (RexCall) cluster.rexBuilder.makeCall(TOSTRING, bigintInput, cluster.stringLiteral("binary"));  
     * {@code NUMBER_TO_STRING} over a DECIMAL source — still lowers to a VARCHAR cast. The
}  
        }  
    /** Synthetic tostring operator used to build input RexCalls. */
        OperandTypes.NUMERIC,
            return rexBuilder.makeLiteral(value);
import org.opensearch.test.OpenSearchTestCase;
    public void testNumberToStringLowersToVarcharCast() {
    private static final SqlFunction NUMBER_TO_STRING = new SqlFunction(  
        ReturnTypes.VARCHAR,  
public class ToStringFunctionAdapterTests extends OpenSearchTestCase {
        RexCall outCall = assertTostringCall(out);  
    private static final class Cluster {
            "operator is the synthetic `tostring` that resolves to the Rust UDF",
        Cluster cluster = newCluster();
import org.apache.calcite.sql.SqlKind;
 * SPDX-License-Identifier: Apache-2.0
        );
package org.opensearch.be.datafusion;
    /**
        assertSame("operand preserved by identity", input, castCall.getOperands().get(0));  
