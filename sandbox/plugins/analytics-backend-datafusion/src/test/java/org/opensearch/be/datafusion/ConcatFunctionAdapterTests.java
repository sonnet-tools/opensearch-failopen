 * this file be licensed under the Apache-2.0 license or a
    private RexBuilder rexBuilder;
    /** Builds {@code ||(field0, field1)} — Calcite's binary string concat operator. */
        assertEquals(SqlKind.OR, condition.getKind());
 * Unit tests for {@link ConcatFunctionAdapter}. The adapter rewrites Calcite's binary
    private RelDataType varcharType;
 * The OpenSearch Contributors require contributions made to
import org.apache.calcite.sql.fun.SqlLibraryOperators;
    }
        RexCall singleOperand = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.CONCAT_FUNCTION, field0);
        assertEquals("condition must be OR(IS_NULL(a), IS_NULL(b))", SqlKind.OR, condition.getKind());
/*
        // Substrait conversion downstream relies on seeing the same object the resolver annotated.
        assertEquals(SqlKind.IS_NULL, innerOr.getOperands().get(1).getKind());
            // Each IS_NULL must wrap the corresponding original operand — order matters for the
 * the CASE wrapper, mis-orders the IS_NULL operands, or swaps the THEN/ELSE branches
    public void testAdaptNaryConcatChainsIsNullChecksLeftAssociative() {
        assertSame("else branch must be the original CONCAT call", concat, caseCall.getOperands().get(2));
                concat.getOperands().get(i),
 *
    // ── pass-through guard ─────────────────────────────────────────────────
    private RelDataTypeFactory typeFactory;
    private final ConcatFunctionAdapter adapter = new ConcatFunctionAdapter();
            RexNode disjunct = orCall.getOperands().get(i);
 * function deviates from.
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RexCall concat = buildBinaryConcat();
    private RexCall buildTernaryConcat() {
        RexNode adapted = adapter.adapt(concat, List.of(), cluster);
package org.opensearch.be.datafusion;
        // Right child is IS_NULL(c) — the most recently appended operand in the fold.
        RexNode leftChild = outerOr.getOperands().get(0);
public class ConcatFunctionAdapterTests extends OpenSearchTestCase {
 * SQL-standard null semantics that DataFusion's substrait-mapped {@code concat()}
        // Left child is OR(IS_NULL(a), IS_NULL(b)) — the previously folded prefix.
    }
        assertTrue("then branch must be a literal", thenBranch instanceof RexLiteral);
import org.opensearch.test.OpenSearchTestCase;
        RexNode field1 = rexBuilder.makeInputRef(varcharType, 1);
    public void testAdaptPreservesReturnType() {
import org.apache.calcite.rex.RexNode;
        RexNode condition = caseCall.getOperands().get(0);
        RexNode adapted = adapter.adapt(concat, List.of(), cluster);
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.sql.type.SqlTypeName;
        }
            literal.getType().getSqlTypeName()
    private RexCall buildBinaryConcat() {
    }
    public void testAdaptSingleOperandConcatPassesThroughUnchanged() {
        // RexBuilder.makeNullLiteral promotes nullability on the literal's type even when the
        assertEquals(SqlKind.IS_NULL, rightChild.getKind());
import org.apache.calcite.rex.RexBuilder;
        RexCall outerOr = (RexCall) condition;
        assertSame(concat.getOperands().get(2), ((RexCall) rightChild).getOperands().get(0));
}
        RexNode thenBranch = caseCall.getOperands().get(1);
    @Override
        RexCall concat = buildBinaryConcat();
            assertSame(
        varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        assertTrue("expected RexCall, got " + adapted.getClass().getSimpleName(), adapted instanceof RexCall);
import org.apache.calcite.sql.SqlKind;
        RexNode field2 = rexBuilder.makeInputRef(varcharType, 2);
        assertNull("then branch literal must be NULL-valued", literal.getValue());
            concat.getType().getSqlTypeName(),
        assertEquals(SqlKind.OR, leftChild.getKind());
        RexCall concat = buildTernaryConcat();
import org.apache.calcite.plan.hep.HepPlanner;
    }
 */
            );
 * {@code CASE WHEN IS_NULL(a) OR IS_NULL(b) THEN NULL ELSE ||(a, b) END}, restoring
        return (RexCall) rexBuilder.makeCall(SqlLibraryOperators.CONCAT_FUNCTION, field0, field1, field2);
        // can't represent a single-operand call. The adapter's contract is that a 1-operand call
        RexCall caseCall = (RexCall) adapted;
        RexNode field0 = rexBuilder.makeInputRef(varcharType, 0);
        assertEquals("CASE must have exactly three operands [condition, then, else]", 3, caseCall.getOperands().size());
        RexNode field0 = rexBuilder.makeInputRef(varcharType, 0);
        assertEquals(2, outerOr.getOperands().size());
        RexNode rightChild = outerOr.getOperands().get(1);
        RexNode field0 = rexBuilder.makeInputRef(varcharType, 0);
        assertEquals(2, orCall.getOperands().size());
        // original isn't nullable, so the full RelDataType objects differ. The SQL type name
            assertEquals("OR operand " + i + " must be IS_NULL", SqlKind.IS_NULL, disjunct.getKind());
        assertSame(concat.getOperands().get(1), ((RexCall) innerOr.getOperands().get(1)).getOperands().get(0));
        RexCall orCall = (RexCall) condition;
    }
 *
                ((RexCall) disjunct).getOperands().get(0)
import org.apache.calcite.plan.RelOptCluster;
        RexLiteral literal = (RexLiteral) thenBranch;
        RexCall caseCall = (RexCall) adapter.adapt(concat, List.of(), cluster);
 */
import java.util.List;
            // null-propagation contract.
                "IS_NULL operand " + i + " must reference the original CONCAT operand " + i,
        // (VARCHAR vs INTEGER vs ...) is the load-bearing invariant — overall CASE return type
        assertEquals("CASE return type must equal the original CONCAT return type", concat.getType(), adapted.getType());
        // is a no-op — concat with one input equals that input, no null handling needed.
    public void testAdaptedCaseConditionIsOrOfIsNullChecks() {
    private RelOptCluster cluster;
    }
    public void testAdaptedCaseThenBranchIsNullLiteralOfMatchingSqlType() {
        assertEquals(
        RexCall innerOr = (RexCall) leftChild;
        RexNode condition = caseCall.getOperands().get(0);
        RexCall concat = buildBinaryConcat();
 * {@code ||(a, b)} (a.k.a. {@code SqlStdOperatorTable.CONCAT}) into a null-propagating
    }
    }
        RexNode adapted = adapter.adapt(singleOperand, List.of(), cluster);
        return (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.CONCAT, field0, field1);
     * arity 2 in production, but the adapter's loop handles N — this test guards that path.
import org.apache.calcite.rex.RexCall;
 * compatible open source license.
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        typeFactory = new JavaTypeFactoryImpl();
    public void testAdaptBinaryConcatProducesCaseWrapper() {
            "NULL literal SQL type must match the original CONCAT's SQL type",
        assertEquals("rewritten root must be CASE", SqlKind.CASE, caseCall.getKind());
        // identity to the original is asserted in testAdaptPreservesReturnType.
    }
        );
        rexBuilder = new RexBuilder(typeFactory);
     */
 * SPDX-License-Identifier: Apache-2.0
    // ── n-ary path ──────────────────────────────────────────────────────────
     * Builds an n-ary {@code CONCAT(field0, field1, field2)} via {@code SqlLibraryOperators.CONCAT_FUNCTION}
    }
        RexNode field1 = rexBuilder.makeInputRef(varcharType, 1);
    /**
        // Condition shape: OR(OR(IS_NULL(a), IS_NULL(b)), IS_NULL(c)) — left-fold.
        super.setUp();
import org.apache.calcite.rex.RexLiteral;
import org.apache.calcite.rel.type.RelDataTypeFactory;
        assertEquals(SqlKind.IS_NULL, innerOr.getOperands().get(0).getKind());
 * surfaces here rather than at IT-level row-mismatch failures.
        assertSame(concat.getOperands().get(0), ((RexCall) innerOr.getOperands().get(0)).getOperands().get(0));
        RexCall caseCall = (RexCall) adapter.adapt(concat, List.of(), cluster);
        RexCall caseCall = (RexCall) adapter.adapt(concat, List.of(), cluster);
        RexCall concat = buildBinaryConcat();
        RexCall caseCall = (RexCall) adapter.adapt(concat, List.of(), cluster);
    public void testAdaptedCaseElseBranchIsOriginalConcat() {
/**
        RexCall concat = buildBinaryConcat();
        // Else branch must be the original RexCall, untouched — by reference, not just equal.
        // Built via the variadic CONCAT_FUNCTION since SqlStdOperatorTable.CONCAT is binary and
    public void setUp() throws Exception {
        for (int i = 0; i < orCall.getOperands().size(); i++) {
 * <p>Each test pins one structural invariant of the rewrite — a regression that drops
     * to exercise the multi-operand IS_NULL chain path. The binary {@code ||} only ever appears with
        cluster = RelOptCluster.create(planner, rexBuilder);
    // ── core rewrite shape ──────────────────────────────────────────────────
import org.apache.calcite.plan.hep.HepProgramBuilder;
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        assertSame("single-operand call must pass through unmodified", singleOperand, adapted);
