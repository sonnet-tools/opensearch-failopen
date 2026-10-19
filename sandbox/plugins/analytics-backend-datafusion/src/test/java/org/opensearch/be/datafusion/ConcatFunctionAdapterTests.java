 * Unit tests for {@link ConcatFunctionAdapter}. The adapter rewrites Calcite's binary
            assertEquals("OR operand " + i + " must be IS_NULL", SqlKind.IS_NULL, disjunct.getKind());
            literal.getType().getSqlTypeName()
    private RelDataTypeFactory typeFactory;
    public void testAdaptedCaseElseBranchIsOriginalConcat() {
    }  
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
import org.apache.calcite.rel.type.RelDataType;
        assertEquals(SqlKind.OR, condition.getKind());
        RexNode field1 = rexBuilder.makeInputRef(varcharType, 1);  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
 *
        // Built via the variadic CONCAT_FUNCTION since SqlStdOperatorTable.CONCAT is binary and
            assertSame(
public class ConcatFunctionAdapterTests extends OpenSearchTestCase {  
            RexNode disjunct = orCall.getOperands().get(i);
        assertEquals(SqlKind.IS_NULL, innerOr.getOperands().get(1).getKind());  
 *
    public void testAdaptPreservesReturnType() {
        RexCall concat = buildBinaryConcat();
     * Builds an n-ary {@code CONCAT(field0, field1, field2)} via {@code SqlLibraryOperators.CONCAT_FUNCTION}  
/**
        assertTrue("then branch must be a literal", thenBranch instanceof RexLiteral);
        assertEquals(
package org.opensearch.be.datafusion;
        RexCall singleOperand = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.CONCAT_FUNCTION, field0);  
        RexCall outerOr = (RexCall) condition;
    }  
    }
        assertTrue("expected RexCall, got " + adapted.getClass().getSimpleName(), adapted instanceof RexCall);
 * surfaces here rather than at IT-level row-mismatch failures.
        assertEquals(SqlKind.IS_NULL, innerOr.getOperands().get(0).getKind());
/*  
 * the CASE wrapper, mis-orders the IS_NULL operands, or swaps the THEN/ELSE branches  
import org.apache.calcite.plan.hep.HepPlanner;  
        // Else branch must be the original RexCall, untouched — by reference, not just equal.  
                concat.getOperands().get(i),
    }
        RexNode field1 = rexBuilder.makeInputRef(varcharType, 1);
            );  
    // ── n-ary path ──────────────────────────────────────────────────────────
                "IS_NULL operand " + i + " must reference the original CONCAT operand " + i,  
        RexNode leftChild = outerOr.getOperands().get(0);
        for (int i = 0; i < orCall.getOperands().size(); i++) {  
        assertSame("single-operand call must pass through unmodified", singleOperand, adapted);
 * function deviates from.  
            "NULL literal SQL type must match the original CONCAT's SQL type",  
        RexNode condition = caseCall.getOperands().get(0);
    public void testAdaptedCaseThenBranchIsNullLiteralOfMatchingSqlType() {
 */  
        RexNode field2 = rexBuilder.makeInputRef(varcharType, 2);
        assertEquals(2, orCall.getOperands().size());
import org.apache.calcite.sql.SqlKind;
    private RexBuilder rexBuilder;  
        }
        cluster = RelOptCluster.create(planner, rexBuilder);  
        assertSame(concat.getOperands().get(0), ((RexCall) innerOr.getOperands().get(0)).getOperands().get(0));
        // can't represent a single-operand call. The adapter's contract is that a 1-operand call  
    // ── core rewrite shape ──────────────────────────────────────────────────
        RexNode adapted = adapter.adapt(concat, List.of(), cluster);  
import org.apache.calcite.rex.RexBuilder;
        RexCall concat = buildBinaryConcat();
import org.apache.calcite.rex.RexLiteral;  
            // null-propagation contract.
import org.apache.calcite.sql.type.SqlTypeName;
        RexNode adapted = adapter.adapt(concat, List.of(), cluster);  
        RexNode field0 = rexBuilder.makeInputRef(varcharType, 0);
    @Override  
    }
        // is a no-op — concat with one input equals that input, no null handling needed.
 * SQL-standard null semantics that DataFusion's substrait-mapped {@code concat()}
        assertEquals(2, outerOr.getOperands().size());
        // identity to the original is asserted in testAdaptPreservesReturnType.
            // Each IS_NULL must wrap the corresponding original operand — order matters for the  
        return (RexCall) rexBuilder.makeCall(SqlLibraryOperators.CONCAT_FUNCTION, field0, field1, field2);
     * to exercise the multi-operand IS_NULL chain path. The binary {@code ||} only ever appears with
    }  
        // Left child is OR(IS_NULL(a), IS_NULL(b)) — the previously folded prefix.
        RexNode field0 = rexBuilder.makeInputRef(varcharType, 0);  
 * <p>Each test pins one structural invariant of the rewrite — a regression that drops
                ((RexCall) disjunct).getOperands().get(0)
    private RexCall buildTernaryConcat() {
        RexLiteral literal = (RexLiteral) thenBranch;
        RexCall caseCall = (RexCall) adapter.adapt(concat, List.of(), cluster);
        RexCall concat = buildBinaryConcat();
        assertEquals("CASE return type must equal the original CONCAT return type", concat.getType(), adapted.getType());
    private RelDataType varcharType;
 * {@code ||(a, b)} (a.k.a. {@code SqlStdOperatorTable.CONCAT}) into a null-propagating  
        assertSame(concat.getOperands().get(1), ((RexCall) innerOr.getOperands().get(1)).getOperands().get(0));
        RexCall concat = buildBinaryConcat();  
        );  
    }  
        return (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.CONCAT, field0, field1);
    }
        varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
    // ── pass-through guard ─────────────────────────────────────────────────
    public void testAdaptedCaseConditionIsOrOfIsNullChecks() {  
        assertEquals("rewritten root must be CASE", SqlKind.CASE, caseCall.getKind());
import org.apache.calcite.rex.RexNode;
        RexCall orCall = (RexCall) condition;
    /** Builds {@code ||(field0, field1)} — Calcite's binary string concat operator. */
        assertEquals("condition must be OR(IS_NULL(a), IS_NULL(b))", SqlKind.OR, condition.getKind());
    }  
        // Condition shape: OR(OR(IS_NULL(a), IS_NULL(b)), IS_NULL(c)) — left-fold.
        RexCall caseCall = (RexCall) adapter.adapt(concat, List.of(), cluster);  
        RexCall concat = buildTernaryConcat();
        assertEquals("CASE must have exactly three operands [condition, then, else]", 3, caseCall.getOperands().size());
        assertEquals(SqlKind.OR, leftChild.getKind());  
    public void testAdaptNaryConcatChainsIsNullChecksLeftAssociative() {
        // (VARCHAR vs INTEGER vs ...) is the load-bearing invariant — overall CASE return type  
        super.setUp();
        // original isn't nullable, so the full RelDataType objects differ. The SQL type name
        typeFactory = new JavaTypeFactoryImpl();  
 */
        RexNode rightChild = outerOr.getOperands().get(1);  
 * SPDX-License-Identifier: Apache-2.0
        // Right child is IS_NULL(c) — the most recently appended operand in the fold.  
        RexCall caseCall = (RexCall) adapter.adapt(concat, List.of(), cluster);
 * compatible open source license.
    }  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        assertNull("then branch literal must be NULL-valued", literal.getValue());  
}  
        RexCall caseCall = (RexCall) adapted;  
            concat.getType().getSqlTypeName(),
        assertEquals(SqlKind.IS_NULL, rightChild.getKind());
    private RexCall buildBinaryConcat() {
import org.apache.calcite.plan.RelOptCluster;
        assertSame(concat.getOperands().get(2), ((RexCall) rightChild).getOperands().get(0));
    /**
     */  
        RexCall concat = buildBinaryConcat();  
    private final ConcatFunctionAdapter adapter = new ConcatFunctionAdapter();
 * {@code CASE WHEN IS_NULL(a) OR IS_NULL(b) THEN NULL ELSE ||(a, b) END}, restoring
import org.apache.calcite.sql.fun.SqlLibraryOperators;  
        RexNode thenBranch = caseCall.getOperands().get(1);  
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
        // RexBuilder.makeNullLiteral promotes nullability on the literal's type even when the
import org.apache.calcite.plan.hep.HepProgramBuilder;
        RexNode field0 = rexBuilder.makeInputRef(varcharType, 0);
        RexNode condition = caseCall.getOperands().get(0);  
    private RelOptCluster cluster;
     * arity 2 in production, but the adapter's loop handles N — this test guards that path.
        rexBuilder = new RexBuilder(typeFactory);
import org.opensearch.test.OpenSearchTestCase;  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        RexCall caseCall = (RexCall) adapter.adapt(concat, List.of(), cluster);
        RexNode adapted = adapter.adapt(singleOperand, List.of(), cluster);
    public void setUp() throws Exception {
        // Substrait conversion downstream relies on seeing the same object the resolver annotated.
        RexCall innerOr = (RexCall) leftChild;
import org.apache.calcite.rex.RexCall;
        assertSame("else branch must be the original CONCAT call", concat, caseCall.getOperands().get(2));
 * The OpenSearch Contributors require contributions made to  
    public void testAdaptBinaryConcatProducesCaseWrapper() {
    public void testAdaptSingleOperandConcatPassesThroughUnchanged() {
