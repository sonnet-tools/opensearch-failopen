        );
        );
        RexNode untypedNull = rexBuilder.constantNull();
        assertEquals("CASE expression should be unchanged when no untyped null is present", caseExpr.toString(), rewrittenCase.toString());
        RexNode caseExpr = rexBuilder.makeCall(SqlStdOperatorTable.CASE, boolLit, oneLit, untypedNull);
        assertEquals(SqlTypeName.NULL, untypedNull.getType().getSqlTypeName());
        RelNode values = LogicalValues.createOneRow(cluster);
import org.apache.calcite.rel.type.RelDataTypeFactory;
        // The aggregate's input is the rewritten project; the project's CASE ELSE arm must
 * {@code SqlTypeName.NULL} literals in CASE branches and asserts the rewriter widens those
            "THEN arm null must also be widened to the CASE return type",
            "After Aggregate→Project recursion, the CASE's ELSE arm null must be typed",
        RexNode rewrittenElse = rewrittenCase.getOperands().get(2);
            rewrittenElse.getType().getSqlTypeName()
            false,
        RelNode project = LogicalProject.create(values, List.of(), List.of(caseExpr), List.of("col"), java.util.Set.of());
            List.of(0),
        // Sanity: the source literal is genuinely SqlTypeName.NULL.
        RelNode project = LogicalProject.create(values, List.of(), List.of(caseExpr), List.of("col"), java.util.Set.of());
 * Tests for {@link UntypedNullPreprocessor}. Constructs Calcite RelNode trees that contain
        // CASE WHEN true THEN 1 ELSE 2 END — no untyped nulls; rewriter must be a no-op.
        assertEquals(
 * this file be licensed under the Apache-2.0 license or a
        RexNode untypedNull = rexBuilder.constantNull();
    private RelDataTypeFactory typeFactory;
        RexCall rewrittenCase = (RexCall) rewrittenProj.getProjects().get(0);
            SqlTypeName.INTEGER,
    /**
        RelNode values = LogicalValues.createOneRow(cluster);
        RelNode values = LogicalValues.createOneRow(cluster);
import org.apache.calcite.sql.type.SqlTypeName;
        LogicalAggregate agg = LogicalAggregate.create(project, List.of(), ImmutableBitSet.of(), null, List.of(countCall));
        RexNode caseExpr = rexBuilder.makeCall(SqlStdOperatorTable.CASE, boolLit, oneLit, twoLit);
     */
    private RexBuilder rexBuilder;
        LogicalProject rewrittenProj = (LogicalProject) rewritten;
        // now have a typed null. Walk one level down to verify.
        LogicalProject rewrittenProj = (LogicalProject) rewritten;
        );
import java.util.List;
            "good_count"
     * leaves the implicit ELSE arm as {@link SqlTypeName#NULL}, which isthmus rejects.
            typeFactory.createSqlType(SqlTypeName.BIGINT),
     * End-to-end shape: the Project that motivates the rewrite usually feeds an Aggregate
import org.opensearch.test.OpenSearchTestCase;
            -1,
        // Build: VALUES(true) → Project(CASE WHEN $0 THEN 1 ELSE null END as col)
    @Override
 * to typed nulls matching the CASE's resolved return type.
    public void testCaseConditionOperandUnchanged() {
        // — the rewriter only fires on SqlTypeName.NULL operands.
    private RelOptCluster cluster;
        LogicalProject rewrittenProj = (LogicalProject) rewritten;
     * classifier should not touch even-index operands regardless.)
        LogicalProject rewrittenProj = (LogicalProject) rewrittenAgg.getInput();
        RelDataType nullableInt = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);
     */
    }
import org.apache.calcite.plan.hep.HepPlanner;
        assertTrue("ELSE arm must still be null", ((RexLiteral) rewrittenElse).isNull());
import org.apache.calcite.rel.type.RelDataType;
}
        // Calcite resolves the CASE return type to the leastRestrictive of {INT, NULL} — so
        RexNode untypedNull = rexBuilder.constantNull();
    public void setUp() throws Exception {
        RexNode rewrittenThen = rewrittenCase.getOperands().get(1);
        LogicalAggregate rewrittenAgg = (LogicalAggregate) rewritten;
        RexNode boolLit = rexBuilder.makeLiteral(true, boolType);
        RelDataType boolType = typeFactory.createSqlType(SqlTypeName.BOOLEAN);
public class UntypedNullPreprocessorTests extends OpenSearchTestCase {
            SqlTypeName.INTEGER,
 * The OpenSearch Contributors require contributions made to
     * After rewrite the ELSE literal must carry the CASE's resolved return type.
import org.apache.calcite.util.ImmutableBitSet;
        RelNode values = LogicalValues.createOneRow(cluster);
 *
    /**
     * The condition operand at even indices (except the trailing else) is *not* a value
        RexNode twoLit = rexBuilder.makeExactLiteral(java.math.BigDecimal.valueOf(2), nullableInt);
package org.opensearch.be.datafusion;
        super.setUp();
        RelDataType nullableInt = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);
import org.apache.calcite.rex.RexNode;
    public void testCaseWithThenNullIsAlsoRewritten() {
        RexCall rewrittenCase = (RexCall) rewrittenProj.getProjects().get(0);
        // typed null whose type matches the CASE's return type (nullable INT), not NULL.
        RelNode rewritten = UntypedNullPreprocessor.rewrite(project);
import org.apache.calcite.plan.RelOptCluster;
     */
     * arm — leave it alone. (We don't expect untyped NULLs as conditions, but the operand
        RexNode boolLit = rexBuilder.makeLiteral(true, boolType);
        RexNode oneLit = rexBuilder.makeExactLiteral(java.math.BigDecimal.ONE, nullableInt);
        RelDataType boolType = typeFactory.createSqlType(SqlTypeName.BOOLEAN);
     */
     * positions and the trailing operand as values; both can host an untyped NULL).
    }
    }
    }
        RelDataType boolType = typeFactory.createSqlType(SqlTypeName.BOOLEAN);
        AggregateCall countCall = AggregateCall.create(
        RelNode project = LogicalProject.create(values, List.of(), List.of(caseExpr), List.of("col"), java.util.Set.of());
        RexNode oneLit = rexBuilder.makeExactLiteral(java.math.BigDecimal.ONE, nullableInt);
        RelNode rewritten = UntypedNullPreprocessor.rewrite(agg);
            rewrittenThen.getType().getSqlTypeName()
        rexBuilder = new RexBuilder(typeFactory);
        );
        RelDataType nullableInt = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);
import org.apache.calcite.rel.core.AggregateCall;
import org.apache.calcite.rex.RexCall;
 * SPDX-License-Identifier: Apache-2.0
        // Untyped NULL — RexBuilder.constantNull() returns a literal whose type is NULL.
        assertEquals(SqlTypeName.INTEGER, caseType.getSqlTypeName());
        RelDataType boolType = typeFactory.createSqlType(SqlTypeName.BOOLEAN);
        RexCall rewrittenCase = (RexCall) rewrittenProj.getProjects().get(0);
 */
     * still type-checks and exposes the expected output schema.
import org.apache.calcite.rel.logical.LogicalValues;
     * (e.g. {@code COUNT(case_col)}). Verify the Aggregate over a rewritten Project
        // Walk the rewritten Project's only expression: the CASE's ELSE arm must now be a
        // Whole CASE expression is structurally unchanged when no untyped nulls are present
 */
import org.apache.calcite.rel.logical.LogicalAggregate;
        RexNode caseExpr = rexBuilder.makeCall(SqlStdOperatorTable.CASE, boolLit, oneLit, untypedNull);
    /**
    public void testCountOverRewrittenCaseProjectionTypechecks() {
        RelNode rewritten = UntypedNullPreprocessor.rewrite(project);
        cluster = RelOptCluster.create(planner, rexBuilder);
        // CASE WHEN cond THEN <untyped null> ELSE 1 END — value-arm at index 1.
        // what isthmus chokes on.
        RexNode boolLit = rexBuilder.makeLiteral(true, boolType);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    public void testCountEvalCaseRewritesElseNullToTypedNull() {
        RelNode project = LogicalProject.create(values, List.of(), List.of(caseExpr), List.of("case_col"), java.util.Set.of());
        assertEquals(1, rewrittenAgg.getRowType().getFieldCount());
        RexNode oneLit = rexBuilder.makeExactLiteral(java.math.BigDecimal.ONE, nullableInt);
        typeFactory = new JavaTypeFactoryImpl();
import org.apache.calcite.rex.RexBuilder;
        RelNode rewritten = UntypedNullPreprocessor.rewrite(project);
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.rex.RexLiteral;
import org.apache.calcite.rel.logical.LogicalProject;
import org.apache.calcite.plan.hep.HepProgramBuilder;
        assertEquals(
        RexNode caseExpr = rexBuilder.makeCall(SqlStdOperatorTable.CASE, boolLit, untypedNull, oneLit);
        RexNode oneLit = rexBuilder.makeExactLiteral(java.math.BigDecimal.ONE, nullableInt);
        // the CASE itself is already a nullable INT, but its untyped-NULL child operand is
        RexNode boolLit = rexBuilder.makeLiteral(true, boolType);
/**
        RelDataType caseType = caseExpr.getType();
            rewrittenCase.getOperands().get(2).getType().getSqlTypeName()
        // And the COUNT aggregate output schema should still be a single BIGINT column.
    /**
        assertEquals(SqlTypeName.BIGINT, rewrittenAgg.getRowType().getFieldList().get(0).getType().getSqlTypeName());
        assertTrue("ELSE arm must remain a literal", rewrittenElse instanceof RexLiteral);
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
     * The motivating shape: {@code COUNT(CASE WHEN cond THEN 1 ELSE NULL END)} — Calcite
/*
        assertEquals(
 * compatible open source license.
import org.apache.calcite.rel.RelNode;
     * THEN-arm null is rewritten the same way (the operand layout treats odd-indexed
    }
            SqlStdOperatorTable.COUNT,
        RelDataType nullableInt = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);
        RexCall rewrittenCase = (RexCall) rewrittenProj.getProjects().get(0);
            SqlTypeName.INTEGER,
            "ELSE arm type must be widened to the CASE return type, not NULL",
