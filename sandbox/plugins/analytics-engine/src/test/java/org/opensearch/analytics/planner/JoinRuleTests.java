        if (unwrapped instanceof OpenSearchJoin) return true;  
        // the expected outcome; the contract we verify is that our rule did NOT match.
        LOGGER.info("Input join:\n{}", RelOptUtil.toString(join));
        try {
     * Both inputs gather SINGLETON to the coordinator — the cost gate on OpenSearchJoin
            left instanceof OpenSearchExchangeReducer  
        );
            "left input wrapped in OpenSearchExchangeReducer, got " + left.getClass().getSimpleName(),
     * predicates (e.g. WHERE outer.id > inner.uid).
        );
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
    public void testFullOuterJoinMatches() {
    private RexNode equiJoinCondition() {
        }
            "right input wrapped in OpenSearchExchangeReducer, got " + right.getClass().getSimpleName(),
    }
            SqlStdOperatorTable.EQUALS,
        assertTrue(  
import org.apache.calcite.plan.RelOptUtil;
        RelNode unwrapped = RelNodeUtils.unwrapHep(result);
        return result;
        // Volcano may wrap the SINGLETON-producing OpenSearchJoin in a redundant top-level  
        OpenSearchJoin osJoin = (OpenSearchJoin) unwrapped;  
        OpenSearchJoin osJoin = (OpenSearchJoin) unwrapped;
     * Theta (non-equi) joins flow through the same SINGLETON+SINGLETON path as equi joins.
            left instanceof OpenSearchExchangeReducer
    }
import org.apache.calcite.rex.RexNode;
import org.apache.logging.log4j.LogManager;
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
        assertTrue(  
        // full outer join on the row numbers). DataFusion's substrait consumer handles  
        assertTrue(
        RelNode unwrapped = RelNodeUtils.unwrapHep(result);  
 * (i.e. wrapped in {@link OpenSearchExchangeReducer} by Volcano), and rejects join types
     * doesn't inspect the join condition — it gates only on distribution traits — so the  
        RelNode result = runJoin(joinType, equiJoinCondition());  
        assertEquals(RelDistribution.Type.SINGLETON, leftReducer.getExchangeInfo().distributionType());
        // leftKeys, empty nonEquiConditions → JoinInfo.isEqui()=true. The rule must accept
        RelNode right = RelNodeUtils.unwrapHep(osJoin.getRight());  
 * this file be licensed under the Apache-2.0 license or a
        OpenSearchJoin osJoin = (OpenSearchJoin) unwrapped;  
        }
        LogicalJoin join = LogicalJoin.create(left, right, List.of(), condition, Set.of(), joinType);  
    }
        return false;
import org.apache.calcite.rel.logical.LogicalJoin;  
        assertEquiJoinMatches(JoinRelType.RIGHT);
    private RelNode runJoin(JoinRelType joinType, RexNode condition) {  
            "rule should produce OpenSearchJoin for cross joins, got " + unwrapped.getClass().getSimpleName(),
    // ── Helpers ──────────────────────────────────────────────────────────
            right instanceof OpenSearchExchangeReducer  
        // this shape so the downstream OpenSearchAggregateRule finds a marked child. Isthmus  
        if (unwrapped instanceof OpenSearchExchangeReducer wrapper) {
        assertTrue("rule should produce OpenSearchJoin, got " + unwrapped.getClass().getSimpleName(), unwrapped instanceof OpenSearchJoin);
            unwrapped instanceof OpenSearchJoin  
    private static boolean containsOpenSearchJoin(RelNode root) {
        );  
    }
        RelNode left = RelNodeUtils.unwrapHep(osJoin.getLeft());
     * Surfaces in RelDecorrelator output for correlated subqueries with non-equi correlation  
        // Both sides still gather SINGLETON to the coordinator — the cost gate behavior is  
        } catch (RuntimeException expected) {
        assertTrue(
        assertEquals("inner join type preserved", JoinRelType.INNER, osJoin.getJoinType());
    public void testPureNonEquiJoinAlsoMatchesAndProducesOpenSearchJoin() {  
    public void testLeftEquiJoinMatchesAndProducesOpenSearchJoin() {
            unwrapped = RelNodeUtils.unwrapHep(wrapper.getInput());
        if (unwrapped instanceof OpenSearchExchangeReducer wrapper) {  
            unwrapped = RelNodeUtils.unwrapHep(wrapper.getInput());
        );  
}
        }
    private void assertEquiJoinMatches(JoinRelType joinType) {
    }  
        // unchanged for theta. NestedLoopJoinExec will run there at execution time.
        );  
     * marker rule produces an {@link OpenSearchJoin} regardless of equi-ness. At execution,
    }  
        // because no rule converts LogicalJoin → OpenSearchJoin for non-inner types and the
        // FULL OUTER end-to-end so the rule marks it like INNER/LEFT/RIGHT.
import org.apache.calcite.rel.core.JoinRelType;
        RelNode result = runJoin(JoinRelType.INNER, lt);
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),  
        // Both sides use the same mocked index (the planner's table-mark step looks up cluster
            SqlStdOperatorTable.LESS_THAN,  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
    }
            unwrapped = RelNodeUtils.unwrapHep(wrapper.getInput());
    public void testRuleGathersBothSidesSingletonToCoordinator() {
        assertEquals(RelDistribution.Type.SINGLETON, rightReducer.getExchangeInfo().distributionType());  
    }  
        RelNode left = RelNodeUtils.unwrapHep(osJoin.getLeft());
        }  
        );
        RelNode unwrapped = RelNodeUtils.unwrapHep(result);
        assertEquals(joinType + " join type preserved", joinType, osJoin.getJoinType());  
            RelNode result = runJoin(joinType, equiJoinCondition());  
        // FULL OUTER is needed by PPL's `appendcol` lowering (ROW_NUMBER pairing via a
        RelOptTable table = mockTable("test_index", "k", "v");  
    private static final Logger LOGGER = LogManager.getLogger(JoinRuleTests.class);
import org.apache.calcite.sql.type.SqlTypeName;  
 * Tests for {@link org.opensearch.analytics.planner.rules.OpenSearchJoinRule}: matches
import java.util.Set;
        // Volcano can't produce a SINGLETON-distributed plan for a non-inner LogicalJoin
     */
            unwrapped instanceof OpenSearchJoin
package org.opensearch.analytics.planner;
        OpenSearchExchangeReducer rightReducer = (OpenSearchExchangeReducer) RelNodeUtils.unwrapHep(osJoin.getRight());
        // ON 1 = 1 — literal-only condition. Calcite folds this to condition=TRUE: empty
        assertEquiJoinMatches(JoinRelType.FULL);
            if (containsOpenSearchJoin(input)) return true;
import java.util.Map;
    }
     * The downstream {@link org.opensearch.analytics.planner.rules.OpenSearchJoinSplitRule}
        for (RelNode input : unwrapped.getInputs()) {
        RelNode unwrapped = RelNodeUtils.unwrapHep(result);
 * compatible open source license.
    }
        assertEquals(RelDistribution.Type.SINGLETON, leftReducer.getExchangeInfo().distributionType());
        // emits it as a substrait Cross rel, which DataFusion executes as NestedLoopJoin.
        RexNode trueCondition = rexBuilder.makeLiteral(true);
    public void testRightEquiJoinMatchesAndProducesOpenSearchJoin() {  
    public void testInnerEquiJoinMatchesAndProducesOpenSearchJoin() {  
        RelNode result = runJoin(JoinRelType.INNER, trueCondition);  
    }  
     */
 *
            assertFalse("rule must not match non-inner joins (joinType=" + joinType + ")", containsOpenSearchJoin(result));
            "rule should produce OpenSearchJoin for " + joinType + ", got " + unwrapped.getClass().getSimpleName(),
        RelNode result = runPlanner(join, context);  
        PlannerContext context = buildContext("parquet", 2, Map.of("k", Map.of("type", "integer"), "v", Map.of("type", "integer")));
        // OpenSearchExchangeReducer when satisfying the root's required SINGLETON trait —
        if (unwrapped instanceof OpenSearchExchangeReducer wrapper) {  
        );
        RelNode unwrapped = RelNodeUtils.unwrapHep(root);
        }
        // state by qualified name, and the test fixture only mocks "test_index"). The join
        // left.k < right.k — no equi-condition, the rule's analyzeCondition().leftKeys is empty.
        );
        RelNode unwrapped = RelNodeUtils.unwrapHep(result);  
 */
        // distribution trait def can't bridge from NONE convention. The planner failure is  
        );  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    /**  
 * INNER / LEFT / RIGHT / FULL / SEMI / ANTI joins for both equi and non-equi (theta)  
            "rule should produce OpenSearchJoin for theta joins too, got " + unwrapped.getClass().getSimpleName(),
    /**
        assertTrue(
     * only accepts SINGLETON inputs, so Volcano inserts an ER on each side.  
import org.apache.logging.log4j.Logger;
        assertTrue(
            "left input wrapped in OpenSearchExchangeReducer, got " + left.getClass().getSimpleName(),
/**
    public void testCrossJoinMatchesAndProducesOpenSearchJoin() {  
        // shape and condition.
    private void assertNonInnerJoinDoesNotMatch(JoinRelType joinType) {  
        RelNode result = runJoin(JoinRelType.INNER, equiJoinCondition());  
        LOGGER.info("Marked+CBO output:\n{}", RelOptUtil.toString(result));
import java.util.List;  
        }  
        OpenSearchExchangeReducer leftReducer = (OpenSearchExchangeReducer) RelNodeUtils.unwrapHep(osJoin.getLeft());
        RelNode right = RelNodeUtils.unwrapHep(osJoin.getRight());
import org.apache.calcite.rel.RelDistribution;  
 */  
        // left.k = right.k — left field 0 = right field 0 (offset by left fieldCount=2).  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
    }
        assertEquiJoinMatches(JoinRelType.LEFT);  
            "right input wrapped in OpenSearchExchangeReducer, got " + right.getClass().getSimpleName(),  
        // rule we're testing doesn't care about table identity — it only inspects the join  
        RelNode result = runJoin(JoinRelType.INNER, equiJoinCondition());
        OpenSearchExchangeReducer leftReducer = (OpenSearchExchangeReducer) RelNodeUtils.unwrapHep(osJoin.getLeft());  
        RexNode lt = rexBuilder.makeCall(
        if (unwrapped instanceof OpenSearchExchangeReducer wrapper) {  
        return rexBuilder.makeCall(
 * predicates, produces an {@link OpenSearchJoin} with both inputs SINGLETON-converted
     * isthmus serializes the non-equi predicate and DataFusion picks NestedLoopJoinExec.
        OpenSearchJoin osJoin = (OpenSearchJoin) unwrapped;
        OpenSearchExchangeReducer rightReducer = (OpenSearchExchangeReducer) RelNodeUtils.unwrapHep(osJoin.getRight());  
public class JoinRuleTests extends BasePlannerRulesTests {
 * the engine doesn't support.  
/*  
import org.apache.calcite.plan.RelOptTable;
        if (unwrapped instanceof OpenSearchExchangeReducer wrapper) {
        RelNode right = stubScan(table);
            unwrapped = RelNodeUtils.unwrapHep(wrapper.getInput());
            // Acceptable — see above.  
 * The OpenSearch Contributors require contributions made to  
        }  
        assertTrue(  
import org.apache.calcite.rel.RelNode;
        RelNode left = stubScan(table);
            unwrapped instanceof OpenSearchJoin
            unwrapped = RelNodeUtils.unwrapHep(wrapper.getInput());
        // unwrap one layer if so.
        assertEquals(RelDistribution.Type.SINGLETON, rightReducer.getExchangeInfo().distributionType());  
            right instanceof OpenSearchExchangeReducer
 * SPDX-License-Identifier: Apache-2.0
