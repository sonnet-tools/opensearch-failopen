            "rule should produce OpenSearchJoin for theta joins too, got " + unwrapped.getClass().getSimpleName(),
            right instanceof OpenSearchExchangeReducer
    }
            "right input wrapped in OpenSearchExchangeReducer, got " + right.getClass().getSimpleName(),
        assertTrue(
        return false;
        if (unwrapped instanceof OpenSearchExchangeReducer wrapper) {
        if (unwrapped instanceof OpenSearchExchangeReducer wrapper) {
        // FULL OUTER is needed by PPL's `appendcol` lowering (ROW_NUMBER pairing via a
        assertEquals(RelDistribution.Type.SINGLETON, leftReducer.getExchangeInfo().distributionType());
        }
     * marker rule produces an {@link OpenSearchJoin} regardless of equi-ness. At execution,
        RelOptTable table = mockTable("test_index", "k", "v");
    }
import org.apache.calcite.rel.core.JoinRelType;
}
    }
        assertEquals(RelDistribution.Type.SINGLETON, leftReducer.getExchangeInfo().distributionType());
        }
import org.apache.calcite.plan.RelOptTable;
            SqlStdOperatorTable.EQUALS,
import org.apache.logging.log4j.LogManager;
        }
 */
    }
        assertTrue(
            "rule should produce OpenSearchJoin for cross joins, got " + unwrapped.getClass().getSimpleName(),
 * Tests for {@link org.opensearch.analytics.planner.rules.OpenSearchJoinRule}: matches
import org.apache.calcite.sql.type.SqlTypeName;
        OpenSearchExchangeReducer leftReducer = (OpenSearchExchangeReducer) RelNodeUtils.unwrapHep(osJoin.getLeft());
 * (i.e. wrapped in {@link OpenSearchExchangeReducer} by Volcano), and rejects join types
        );
    public void testInnerEquiJoinMatchesAndProducesOpenSearchJoin() {
        // the expected outcome; the contract we verify is that our rule did NOT match.
import java.util.List;
        } catch (RuntimeException expected) {
        OpenSearchJoin osJoin = (OpenSearchJoin) unwrapped;
        RelNode unwrapped = RelNodeUtils.unwrapHep(root);
        RelNode right = RelNodeUtils.unwrapHep(osJoin.getRight());
        RelNode right = RelNodeUtils.unwrapHep(osJoin.getRight());
        assertEquals("inner join type preserved", JoinRelType.INNER, osJoin.getJoinType());
        RelNode left = RelNodeUtils.unwrapHep(osJoin.getLeft());
        try {
        RelNode result = runJoin(JoinRelType.INNER, equiJoinCondition());
        // distribution trait def can't bridge from NONE convention. The planner failure is
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
        RelNode result = runJoin(joinType, equiJoinCondition());
        // because no rule converts LogicalJoin → OpenSearchJoin for non-inner types and the
            RelNode result = runJoin(joinType, equiJoinCondition());
     * isthmus serializes the non-equi predicate and DataFusion picks NestedLoopJoinExec.
     */
        // leftKeys, empty nonEquiConditions → JoinInfo.isEqui()=true. The rule must accept
        RelNode result = runJoin(JoinRelType.INNER, trueCondition);
            unwrapped = RelNodeUtils.unwrapHep(wrapper.getInput());
            left instanceof OpenSearchExchangeReducer
    }
        // rule we're testing doesn't care about table identity — it only inspects the join
import org.apache.logging.log4j.Logger;
        PlannerContext context = buildContext("parquet", 2, Map.of("k", Map.of("type", "integer"), "v", Map.of("type", "integer")));
        OpenSearchJoin osJoin = (OpenSearchJoin) unwrapped;
        LogicalJoin join = LogicalJoin.create(left, right, List.of(), condition, Set.of(), joinType);
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
            left instanceof OpenSearchExchangeReducer
            "rule should produce OpenSearchJoin for " + joinType + ", got " + unwrapped.getClass().getSimpleName(),
        );
package org.opensearch.analytics.planner;
import org.apache.calcite.rel.logical.LogicalJoin;
            "left input wrapped in OpenSearchExchangeReducer, got " + left.getClass().getSimpleName(),
 *
import org.apache.calcite.rel.RelNode;
    }
        );
import java.util.Map;
     * only accepts SINGLETON inputs, so Volcano inserts an ER on each side.
    public void testRuleGathersBothSidesSingletonToCoordinator() {
    }
        );
            unwrapped = RelNodeUtils.unwrapHep(wrapper.getInput());
        assertEquiJoinMatches(JoinRelType.LEFT);
        }
            unwrapped instanceof OpenSearchJoin
/**
        if (unwrapped instanceof OpenSearchJoin) return true;
        assertEquals(RelDistribution.Type.SINGLETON, rightReducer.getExchangeInfo().distributionType());
     * The downstream {@link org.opensearch.analytics.planner.rules.OpenSearchJoinSplitRule}
        assertTrue(
            "right input wrapped in OpenSearchExchangeReducer, got " + right.getClass().getSimpleName(),
        return result;
    }
    private void assertEquiJoinMatches(JoinRelType joinType) {
 * predicates, produces an {@link OpenSearchJoin} with both inputs SINGLETON-converted
    public void testPureNonEquiJoinAlsoMatchesAndProducesOpenSearchJoin() {
     * Surfaces in RelDecorrelator output for correlated subqueries with non-equi correlation
    public void testRightEquiJoinMatchesAndProducesOpenSearchJoin() {
 */
        assertEquiJoinMatches(JoinRelType.FULL);
     */
            unwrapped = RelNodeUtils.unwrapHep(wrapper.getInput());
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
        }
        );
            if (containsOpenSearchJoin(input)) return true;
        );
        RelNode left = RelNodeUtils.unwrapHep(osJoin.getLeft());
        OpenSearchExchangeReducer rightReducer = (OpenSearchExchangeReducer) RelNodeUtils.unwrapHep(osJoin.getRight());
    private RelNode runJoin(JoinRelType joinType, RexNode condition) {
        // state by qualified name, and the test fixture only mocks "test_index"). The join
    }
            unwrapped instanceof OpenSearchJoin
        if (unwrapped instanceof OpenSearchExchangeReducer wrapper) {
        assertTrue(
    /**
        // full outer join on the row numbers). DataFusion's substrait consumer handles
        assertTrue(
            unwrapped = RelNodeUtils.unwrapHep(wrapper.getInput());
    // ── Helpers ──────────────────────────────────────────────────────────
        // shape and condition.
            right instanceof OpenSearchExchangeReducer
        OpenSearchExchangeReducer rightReducer = (OpenSearchExchangeReducer) RelNodeUtils.unwrapHep(osJoin.getRight());
        // Both sides use the same mocked index (the planner's table-mark step looks up cluster
 * The OpenSearch Contributors require contributions made to
        // ON 1 = 1 — literal-only condition. Calcite folds this to condition=TRUE: empty
            "left input wrapped in OpenSearchExchangeReducer, got " + left.getClass().getSimpleName(),
    private void assertNonInnerJoinDoesNotMatch(JoinRelType joinType) {
    public void testFullOuterJoinMatches() {
        RelNode unwrapped = RelNodeUtils.unwrapHep(result);
        );
        assertEquals(RelDistribution.Type.SINGLETON, rightReducer.getExchangeInfo().distributionType());
        }
        return rexBuilder.makeCall(
        RelNode result = runJoin(JoinRelType.INNER, equiJoinCondition());
    }
        );
import org.apache.calcite.plan.RelOptUtil;
            SqlStdOperatorTable.LESS_THAN,
 * the engine doesn't support.
        // left.k = right.k — left field 0 = right field 0 (offset by left fieldCount=2).
            unwrapped = RelNodeUtils.unwrapHep(wrapper.getInput());
        // FULL OUTER end-to-end so the rule marks it like INNER/LEFT/RIGHT.
 * INNER / LEFT / RIGHT / FULL / SEMI / ANTI joins for both equi and non-equi (theta)
        // this shape so the downstream OpenSearchAggregateRule finds a marked child. Isthmus
import java.util.Set;
        RelNode result = runPlanner(join, context);
        if (unwrapped instanceof OpenSearchExchangeReducer wrapper) {
    public void testCrossJoinMatchesAndProducesOpenSearchJoin() {
    private RexNode equiJoinCondition() {
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
 * SPDX-License-Identifier: Apache-2.0
            unwrapped instanceof OpenSearchJoin
    private static final Logger LOGGER = LogManager.getLogger(JoinRuleTests.class);
        LOGGER.info("Input join:\n{}", RelOptUtil.toString(join));
 * this file be licensed under the Apache-2.0 license or a
        RelNode unwrapped = RelNodeUtils.unwrapHep(result);
        // emits it as a substrait Cross rel, which DataFusion executes as NestedLoopJoin.
        RelNode result = runJoin(JoinRelType.INNER, lt);
    public void testLeftEquiJoinMatchesAndProducesOpenSearchJoin() {
        );
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
            // Acceptable — see above.
        RexNode trueCondition = rexBuilder.makeLiteral(true);
     * Theta (non-equi) joins flow through the same SINGLETON+SINGLETON path as equi joins.
     * doesn't inspect the join condition — it gates only on distribution traits — so the
        // OpenSearchExchangeReducer when satisfying the root's required SINGLETON trait —
        RelNode left = stubScan(table);
    /**
        RelNode right = stubScan(table);
        OpenSearchJoin osJoin = (OpenSearchJoin) unwrapped;
        }
     * predicates (e.g. WHERE outer.id > inner.uid).
        if (unwrapped instanceof OpenSearchExchangeReducer wrapper) {
import org.apache.calcite.rel.RelDistribution;
        // unchanged for theta. NestedLoopJoinExec will run there at execution time.
        // Volcano may wrap the SINGLETON-producing OpenSearchJoin in a redundant top-level
    }
        // unwrap one layer if so.
        RelNode unwrapped = RelNodeUtils.unwrapHep(result);
        LOGGER.info("Marked+CBO output:\n{}", RelOptUtil.toString(result));
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
    private static boolean containsOpenSearchJoin(RelNode root) {
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
 * compatible open source license.
        RelNode unwrapped = RelNodeUtils.unwrapHep(result);
        assertTrue(
     * Both inputs gather SINGLETON to the coordinator — the cost gate on OpenSearchJoin
        OpenSearchExchangeReducer leftReducer = (OpenSearchExchangeReducer) RelNodeUtils.unwrapHep(osJoin.getLeft());
        assertEquiJoinMatches(JoinRelType.RIGHT);
        assertTrue("rule should produce OpenSearchJoin, got " + unwrapped.getClass().getSimpleName(), unwrapped instanceof OpenSearchJoin);
        // Both sides still gather SINGLETON to the coordinator — the cost gate behavior is
        OpenSearchJoin osJoin = (OpenSearchJoin) unwrapped;
        for (RelNode input : unwrapped.getInputs()) {
public class JoinRuleTests extends BasePlannerRulesTests {
        assertTrue(
        // left.k < right.k — no equi-condition, the rule's analyzeCondition().leftKeys is empty.
import org.apache.calcite.rex.RexNode;
        RelNode unwrapped = RelNodeUtils.unwrapHep(result);
        RexNode lt = rexBuilder.makeCall(
        assertEquals(joinType + " join type preserved", joinType, osJoin.getJoinType());
        // Volcano can't produce a SINGLETON-distributed plan for a non-inner LogicalJoin
            assertFalse("rule must not match non-inner joins (joinType=" + joinType + ")", containsOpenSearchJoin(result));
    }
/*
