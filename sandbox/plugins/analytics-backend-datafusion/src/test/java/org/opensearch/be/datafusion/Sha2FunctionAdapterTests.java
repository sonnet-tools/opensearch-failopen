        RelOptCluster cluster = cluster();  
    }  
    /** Arity mismatches (1-arg or 3-arg calls that somehow reach the adapter) fall through. */
import org.apache.calcite.plan.hep.HepPlanner;  
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
    }  
            () -> new Sha2FunctionAdapter().adapt(original, List.of(), cluster)
     * "Unable to convert call SHA2(string, i32)".  
import org.apache.calcite.sql.SqlFunctionCategory;
        RexCall single = (RexCall) cluster.getRexBuilder().makeCall(SHA2_FN, List.of(stringInputRef(cluster)));
        assertTrue("message should name the unsupported algorithm", e.getMessage().contains("128"));
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
            assertEquals(2, inner.getOperands().size());  
    private RexCall sha2(RelOptCluster cluster, int bitLen) {
            IllegalArgumentException.class,
    private static final SqlFunction SHA2_FN = new SqlFunction(
            RexLiteral algoLit = (RexLiteral) inner.getOperands().get(1);
    private RelOptCluster cluster() {
    /** Non-literal bit-length operand (e.g. a column reference) can't be rewritten; pass through. */
        }
        RexNode rewritten = new Sha2FunctionAdapter().adapt(original, List.of(), cluster);
import org.apache.calcite.rel.type.RelDataTypeFactory;  
    public void testUnsupportedBitLengthThrowsClearError() {
            RexCall original = sha2(cluster, bitLen);  
 */
        RelDataType stringType = cluster.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
 * compatible open source license.
import org.apache.calcite.sql.SqlKind;
        RexNode rewritten = new Sha2FunctionAdapter().adapt(original, List.of(), cluster);  
    private RexNode stringInputRef(RelOptCluster cluster) {
import org.apache.calcite.plan.hep.HepProgramBuilder;
        RexNode dynamicBitLen = new RexInputRef(1, intType);
import org.apache.calcite.sql.type.ReturnTypes;
    /**
            assertTrue("expected RexCall for bitLen=" + bitLen, rewritten instanceof RexCall);
        assertSame(single, rewritten);
            assertEquals("sha" + bitLen, algoLit.getValueAs(String.class));  
    public void testReturnTypePreserved() {
            // Inner call must be digest(x, 'shaN').  
        RelOptCluster cluster = cluster();  
        RelOptCluster cluster = cluster();
        RexNode rewritten = new Sha2FunctionAdapter().adapt(single, List.of(), cluster);  
/**
    public void testAllSupportedBitLengthsLowerToDigestEncode() {  
        IllegalArgumentException e = expectThrows(  
            RexNode rewritten = new Sha2FunctionAdapter().adapt(original, List.of(), cluster);
 * {@code sha2(input, bitLen)} rewrites to {@code encode(digest(input, 'shaN'), 'hex')}
public class Sha2FunctionAdapterTests extends OpenSearchTestCase {
        RexCall original = (RexCall) cluster.getRexBuilder().makeCall(SHA2_FN, List.of(input, dynamicBitLen));  
        OperandTypes.family(),  
        RelOptCluster cluster = cluster();  
    );
        "sha2",
import org.apache.calcite.rex.RexInputRef;  
            RelOptCluster cluster = cluster();
        return (RexCall) call;
            RexCall inner = (RexCall) outer.getOperands().get(0);
 * Unit tests for {@link Sha2FunctionAdapter}. Verifies that  
        RexLiteral bitLenLit = rexBuilder.makeExactLiteral(BigDecimal.valueOf(bitLen));  
import org.apache.calcite.plan.RelOptCluster;
import org.opensearch.test.OpenSearchTestCase;  
 * SPDX-License-Identifier: Apache-2.0
    public void testWrongArityPassesThrough() {
            RexCall outer = (RexCall) rewritten;  
    }  
import org.apache.calcite.rex.RexCall;
        null,
        return new RexInputRef(0, stringType);
 * The OpenSearch Contributors require contributions made to  
        RexBuilder rexBuilder = cluster.getRexBuilder();
 * or non-literal bit-length arguments.  
            // Outer call must be encode(..., 'hex').
        RexNode call = rexBuilder.makeCall(SHA2_FN, List.of(stringInputRef(cluster), bitLenLit));
    public void testNonLiteralBitLengthPassesThrough() {  
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.sql.type.OperandTypes;  
            assertEquals("encode", outer.getOperator().getName());
 * this file be licensed under the Apache-2.0 license or a
        ReturnTypes.VARCHAR,
            assertEquals(2, outer.getOperands().size());
        RelDataType intType = cluster.getTypeFactory().createSqlType(SqlTypeName.INTEGER);  
            assertEquals("hex", hexLit.getValueAs(String.class));
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        RelDataType stringType = cluster.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);  
        assertEquals(original.getType(), rewritten.getType());
    /** The original call's return type must be preserved so the enclosing Project's rowType stays consistent. */
    /** Rewrites sha2(x, N) → encode(digest(x, 'shaN'), 'hex') for every supported bit length. */
import org.apache.calcite.rex.RexLiteral;
    }  
import org.apache.calcite.rex.RexBuilder;
        );  
 *
     * clear, user-actionable error rather than passed through — otherwise the raw
        RexCall original = sha2(cluster, 256);
 * for the four supported bit lengths and passes the original call through on invalid
 */  
    }
    }
/*  
package org.opensearch.be.datafusion;
import org.apache.calcite.sql.SqlFunction;  
        RexCall original = sha2(cluster, 128); // not in {224, 256, 384, 512}
import java.math.BigDecimal;
     * A concrete, unsupported literal bit length (e.g. SHA2(x, 128)) is rejected here with a  
    }  
        assertSame(original, rewritten);
        RexNode input = new RexInputRef(0, stringType);
import java.util.List;  
            assertEquals("digest", inner.getOperator().getName());
        SqlFunctionCategory.USER_DEFINED_FUNCTION
        for (int bitLen : new int[] { 224, 256, 384, 512 }) {
        return RelOptCluster.create(planner, rexBuilder);
    }
import org.apache.calcite.sql.type.SqlTypeName;
            RexLiteral hexLit = (RexLiteral) outer.getOperands().get(1);  
            assertTrue(inner.getOperands().get(0) instanceof RexInputRef);
        assertTrue("message should list the supported bit lengths", e.getMessage().contains("224, 256, 384, 512"));
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
     */
}
     * SHA2(string, i32) reaches Substrait conversion and surfaces the cryptic
        SqlKind.OTHER_FUNCTION,  
