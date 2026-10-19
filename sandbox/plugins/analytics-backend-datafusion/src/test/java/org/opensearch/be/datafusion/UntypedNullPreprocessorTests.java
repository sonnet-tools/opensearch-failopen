    public void testCaseWithThenNullIsAlsoRewritten() {  
    private RelOptCluster cluster;
        RexNode untypedNull = rexBuilder.constantNull();  
 * compatible open source license.
        RexNode oneLit = rexBuilder.makeExactLiteral(java.math.BigDecimal.ONE, nullableInt);
            List.of(0),  
        RelDataType boolType = typeFactory.createSqlType(SqlTypeName.BOOLEAN);
     * End-to-end shape: the Project that motivates the rewrite usually feeds an Aggregate  
import org.apache.calcite.rel.type.RelDataTypeFactory;
            SqlTypeName.INTEGER,
        RexNode boolLit = rexBuilder.makeLiteral(true, boolType);  
        // Walk the rewritten Project's only expression: the CASE's ELSE arm must now be a  
        RexNode untypedNull = rexBuilder.constantNull();  
        LogicalProject rewrittenProj = (LogicalProject) rewrittenAgg.getInput();
        RexNode caseExpr = rexBuilder.makeCall(SqlStdOperatorTable.CASE, boolLit, oneLit, untypedNull);
        RelDataType nullableInt = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);
        // Calcite resolves the CASE return type to the leastRestrictive of {INT, NULL} — so  
    /**
            "THEN arm null must also be widened to the CASE return type",  
            rewrittenElse.getType().getSqlTypeName()  
        assertEquals(  
        assertTrue("ELSE arm must still be null", ((RexLiteral) rewrittenElse).isNull());
     * THEN-arm null is rewritten the same way (the operand layout treats odd-indexed  
        RelNode values = LogicalValues.createOneRow(cluster);
        RexCall rewrittenCase = (RexCall) rewrittenProj.getProjects().get(0);
        RelDataType nullableInt = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);
     * (e.g. {@code COUNT(case_col)}). Verify the Aggregate over a rewritten Project
    }
 * SPDX-License-Identifier: Apache-2.0
        RexNode rewrittenThen = rewrittenCase.getOperands().get(1);
import org.apache.calcite.rex.RexBuilder;  
        RexNode caseExpr = rexBuilder.makeCall(SqlStdOperatorTable.CASE, boolLit, oneLit, untypedNull);  
        LogicalProject rewrittenProj = (LogicalProject) rewritten;
        assertTrue("ELSE arm must remain a literal", rewrittenElse instanceof RexLiteral);
     */
        RelDataType nullableInt = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);
        RexNode boolLit = rexBuilder.makeLiteral(true, boolType);
        // Untyped NULL — RexBuilder.constantNull() returns a literal whose type is NULL.
        RexNode twoLit = rexBuilder.makeExactLiteral(java.math.BigDecimal.valueOf(2), nullableInt);  
        RelNode values = LogicalValues.createOneRow(cluster);  
    }  
    /**  
 */  
            SqlTypeName.INTEGER,  
    public void testCountOverRewrittenCaseProjectionTypechecks() {
import org.apache.calcite.rex.RexCall;
        assertEquals("CASE expression should be unchanged when no untyped null is present", caseExpr.toString(), rewrittenCase.toString());
        cluster = RelOptCluster.create(planner, rexBuilder);
import org.apache.calcite.rel.logical.LogicalAggregate;
        RexNode boolLit = rexBuilder.makeLiteral(true, boolType);
    public void testCountEvalCaseRewritesElseNullToTypedNull() {  
        LogicalProject rewrittenProj = (LogicalProject) rewritten;
 * The OpenSearch Contributors require contributions made to  
            SqlTypeName.INTEGER,
        RelNode rewritten = UntypedNullPreprocessor.rewrite(agg);
     */
        // the CASE itself is already a nullable INT, but its untyped-NULL child operand is
 * Tests for {@link UntypedNullPreprocessor}. Constructs Calcite RelNode trees that contain  
        RelNode project = LogicalProject.create(values, List.of(), List.of(caseExpr), List.of("col"), java.util.Set.of());
        RexNode caseExpr = rexBuilder.makeCall(SqlStdOperatorTable.CASE, boolLit, untypedNull, oneLit);
            SqlStdOperatorTable.COUNT,
 * {@code SqlTypeName.NULL} literals in CASE branches and asserts the rewriter widens those
import java.util.List;  
        // CASE WHEN true THEN 1 ELSE 2 END — no untyped nulls; rewriter must be a no-op.
        assertEquals(SqlTypeName.NULL, untypedNull.getType().getSqlTypeName());
        RexNode oneLit = rexBuilder.makeExactLiteral(java.math.BigDecimal.ONE, nullableInt);
import org.apache.calcite.plan.hep.HepProgramBuilder;
import org.apache.calcite.rel.core.AggregateCall;  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.apache.calcite.plan.hep.HepPlanner;  
    private RexBuilder rexBuilder;
        // The aggregate's input is the rewritten project; the project's CASE ELSE arm must
        RexNode boolLit = rexBuilder.makeLiteral(true, boolType);  
/*  
/**
import org.apache.calcite.rel.RelNode;
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        RexCall rewrittenCase = (RexCall) rewrittenProj.getProjects().get(0);  
        // — the rewriter only fires on SqlTypeName.NULL operands.
import org.apache.calcite.rel.logical.LogicalValues;  
        RelDataType caseType = caseExpr.getType();
import org.apache.calcite.rex.RexNode;  
import org.opensearch.test.OpenSearchTestCase;
    }  
        RelDataType nullableInt = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);  
        assertEquals(SqlTypeName.BIGINT, rewrittenAgg.getRowType().getFieldList().get(0).getType().getSqlTypeName());
        RelDataType boolType = typeFactory.createSqlType(SqlTypeName.BOOLEAN);
        LogicalAggregate agg = LogicalAggregate.create(project, List.of(), ImmutableBitSet.of(), null, List.of(countCall));
        RelDataType boolType = typeFactory.createSqlType(SqlTypeName.BOOLEAN);  
            "ELSE arm type must be widened to the CASE return type, not NULL",
    }  
    public void testCaseConditionOperandUnchanged() {
            -1,
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());  
        assertEquals(
     * After rewrite the ELSE literal must carry the CASE's resolved return type.
        RexNode oneLit = rexBuilder.makeExactLiteral(java.math.BigDecimal.ONE, nullableInt);
        RelNode values = LogicalValues.createOneRow(cluster);
import org.apache.calcite.rel.logical.LogicalProject;
            rewrittenThen.getType().getSqlTypeName()
        // Build: VALUES(true) → Project(CASE WHEN $0 THEN 1 ELSE null END as col)
        // CASE WHEN cond THEN <untyped null> ELSE 1 END — value-arm at index 1.  
     */
        );
        // Whole CASE expression is structurally unchanged when no untyped nulls are present  
            "After Aggregate→Project recursion, the CASE's ELSE arm null must be typed",
    }
        // Sanity: the source literal is genuinely SqlTypeName.NULL.
import org.apache.calcite.rex.RexLiteral;
        RelNode project = LogicalProject.create(values, List.of(), List.of(caseExpr), List.of("case_col"), java.util.Set.of());
        // And the COUNT aggregate output schema should still be a single BIGINT column.  
     */  
        RelNode project = LogicalProject.create(values, List.of(), List.of(caseExpr), List.of("col"), java.util.Set.of());
        RexNode oneLit = rexBuilder.makeExactLiteral(java.math.BigDecimal.ONE, nullableInt);
package org.opensearch.be.datafusion;
    @Override
        // what isthmus chokes on.
     * leaves the implicit ELSE arm as {@link SqlTypeName#NULL}, which isthmus rejects.  
        RexCall rewrittenCase = (RexCall) rewrittenProj.getProjects().get(0);  
import org.apache.calcite.rel.type.RelDataType;
 *
        LogicalProject rewrittenProj = (LogicalProject) rewritten;
    /**
public class UntypedNullPreprocessorTests extends OpenSearchTestCase {
    private RelDataTypeFactory typeFactory;  
            false,
     * positions and the trailing operand as values; both can host an untyped NULL).
     * The motivating shape: {@code COUNT(CASE WHEN cond THEN 1 ELSE NULL END)} — Calcite
import org.apache.calcite.plan.RelOptCluster;
        assertEquals(
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
 */  
        );
        RexNode untypedNull = rexBuilder.constantNull();
import org.apache.calcite.sql.type.SqlTypeName;
            "good_count"  
    public void setUp() throws Exception {
            rewrittenCase.getOperands().get(2).getType().getSqlTypeName()
        RelDataType boolType = typeFactory.createSqlType(SqlTypeName.BOOLEAN);  
    /**
        RexNode caseExpr = rexBuilder.makeCall(SqlStdOperatorTable.CASE, boolLit, oneLit, twoLit);  
        super.setUp();  
        AggregateCall countCall = AggregateCall.create(  
        );  
        RelNode project = LogicalProject.create(values, List.of(), List.of(caseExpr), List.of("col"), java.util.Set.of());
        RexNode rewrittenElse = rewrittenCase.getOperands().get(2);
        // typed null whose type matches the CASE's return type (nullable INT), not NULL.
        assertEquals(SqlTypeName.INTEGER, caseType.getSqlTypeName());  
     * arm — leave it alone. (We don't expect untyped NULLs as conditions, but the operand
 * to typed nulls matching the CASE's resolved return type.
        assertEquals(1, rewrittenAgg.getRowType().getFieldCount());
        RelNode rewritten = UntypedNullPreprocessor.rewrite(project);
     * still type-checks and exposes the expected output schema.
}
        );
import org.apache.calcite.util.ImmutableBitSet;  
        RelNode rewritten = UntypedNullPreprocessor.rewrite(project);
        typeFactory = new JavaTypeFactoryImpl();
     * classifier should not touch even-index operands regardless.)  
        LogicalAggregate rewrittenAgg = (LogicalAggregate) rewritten;
        RelNode values = LogicalValues.createOneRow(cluster);
        rexBuilder = new RexBuilder(typeFactory);
 * this file be licensed under the Apache-2.0 license or a
        RelNode rewritten = UntypedNullPreprocessor.rewrite(project);  
        // now have a typed null. Walk one level down to verify.  
        RexCall rewrittenCase = (RexCall) rewrittenProj.getProjects().get(0);  
     * The condition operand at even indices (except the trailing else) is *not* a value
