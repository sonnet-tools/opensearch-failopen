        boolean[] found = { false };
        RelNode parsed = SqlPlannerTestFixture.parseSql(
            result  
        return found[0];
        RelNode parsed = SqlPlannerTestFixture.parseSql(
        RelNode result = runPlanner(parsed, singleShardContext());  
        RelNode result = runPlanner(parsed, singleShardContext());
 * {@code *_SUB_QUERY_TO_CORRELATE} rules, then decorrelates the result into a
                + " 'Unrecognized filter operator [EXISTS / EXISTS]'.",
        );  
     * {@link org.apache.calcite.sql2rel.RelDecorrelator} bails on a correlated {@code Sort(fetch &gt;
        );
}  
    public void testCorrelatedExistsSubqueryIsLowered() {
            "correlated EXISTS with a subquery LIMIT must still fully lower (no leftover" + " RexSubQuery / LogicalCorrelate).",
 *
                return super.visit(node);
     * removes the existence-irrelevant limit so the EXISTS still fully decorrelates.  
        }
            }
            throw new AssertionError(message + "\nPlan:\n" + RelOptUtil.toString(plan));  
import org.apache.calcite.rel.RelShuttle;
        RelNode parsed = SqlPlannerTestFixture.parseSql(
        if (!findSubQuery(plan)) {
 * {@link PlannerImpl#runAllOptimizations}. The phase lowers {@link RexSubQuery}s
        );
 * which resolves leaf predicates through a {@code ScalarFunction} table that  
        assertNoSubQuery(
import org.apache.calcite.rel.RelHomogeneousShuttle;
    /**
 *
            result
import org.apache.calcite.rel.RelNode;  
            "subquery-remove must cover IN subqueries in addition to EXISTS — both flow through"
            parserState
        assertContainsSubQuery("Pre-condition: parsed plan must carry the EXISTS RexSubQuery", parsed);
            @Override
        RelNode parsed = SqlPlannerTestFixture.parseSql("SELECT * FROM test_index WHERE EXISTS (SELECT 1 FROM test_index)", parserState);  
        };
        assertContainsSubQuery("Pre-condition: parsed plan must carry the EXISTS RexSubQuery", parsed);
    }
 * The OpenSearch Contributors require contributions made to  
        assertContainsSubQuery("Pre-condition: parsed plan must carry the EXISTS RexSubQuery", parsed);
    }  
import org.apache.calcite.rex.RexShuttle;
        );
        if (found[0]) {
 * straight join. Without it, downstream rules (e.g. {@code OpenSearchFilterRule}
/**  
        };  
            "subquery-remove + decorrelate must convert a correlated EXISTS into a standard join"
        ClusterState parserState = SqlPlannerTestFixture.clusterStateWith("test_index", intFields());
        RexShuttle rexFinder = new RexShuttle() {  
    public void testInSubqueryIsLowered() {  
        ClusterState parserState = SqlPlannerTestFixture.clusterStateWith("test_index", intFields());  
public class SubQueryPlanShapeTests extends PlanShapeTestBase {
        plan.accept(relWalker);  
        assertNoSubQuery(  
            @Override
        boolean[] found = { false };
 * (EXISTS / IN / SOME / ANY) into {@code LogicalCorrelate} via Calcite's three  
 */  
                + " (no leftover RexSubQuery, no leftover LogicalCorrelate).",
                + " the same CoreRules.FILTER_SUB_QUERY_TO_CORRELATE rewrite.",  
    /** Correlated EXISTS: subquery references an outer-row column. */
        RelNode result = runPlanner(parsed, singleShardContext());
            "subquery-remove phase must lower every RexSubQuery (EXISTS / IN / SOME / ANY) before"  
            "SELECT * FROM test_index t WHERE EXISTS" + " (SELECT 1 FROM test_index s WHERE s.status = t.status LIMIT 10)",
        );
            public RelNode visit(RelNode node) {  
    public void testUncorrelatedExistsSubqueryIsLowered() {
            "RelDecorrelator cannot decorrelate a correlated Sort(fetch>1); the EXISTS subsearch"
 * the optimized tree — the strongest invariant the phase guarantees.
                found[0] = true;  
    }  
     * frontend produces by injecting a {@code SUBSEARCH_MAXOUT} {@code Sort} inside the subsearch.  
                + " marking — otherwise OpenSearchFilterRule rejects the operator at runtime with"
                if (found[0]) return node;
                }  
        RelShuttle walker = new RelHomogeneousShuttle() {  
            parserState  
        ClusterState parserState = SqlPlannerTestFixture.clusterStateWith("test_index", intFields());
    }
        if (findSubQuery(plan)) {
                return sub;
            @Override
        assertNoSubQuery(  
            throw new AssertionError(message + "\nPost-optimize plan:\n" + RelOptUtil.toString(plan));  
        };  
    }
                + " limit must be stripped so no LogicalCorrelate survives into marking.",  
        );
    public void testCorrelatedExistsWithSubqueryLimitIsLowered() {
        RelShuttle relWalker = new RelHomogeneousShuttle() {
 * SPDX-License-Identifier: Apache-2.0
            "SELECT * FROM test_index WHERE status IN (SELECT status FROM test_index)",  
                    return node;
            public org.apache.calcite.rex.RexNode visitSubQuery(RexSubQuery sub) {
        );
    }
            }
            parserState  
     */
            }
package org.opensearch.analytics.planner;
 * compatible open source license.
 * doesn't include {@code EXISTS}) reject the plan.
        }
            result
 * this file be licensed under the Apache-2.0 license or a
        ClusterState parserState = SqlPlannerTestFixture.clusterStateWith("test_index", intFields());  
            public RelNode visit(RelNode node) {
        assertNoSubQuery(
                    found[0] = true;
    private static void assertNoCorrelate(String message, RelNode plan) {
            result  
        RelNode result = runPlanner(parsed, singleShardContext());
                return found[0] ? node : super.visit(node);  
    // ---- Helpers ----
 */  
 * Plan-shape coverage for the {@code subquery-remove} phase introduced in
            throw new AssertionError(message + "\nPost-optimize plan:\n" + RelOptUtil.toString(plan));  
            result
import org.apache.calcite.rex.RexSubQuery;  
import org.opensearch.cluster.ClusterState;
        assertNoCorrelate(
        );
                node.accept(rexFinder);
            "SELECT * FROM test_index t WHERE EXISTS" + " (SELECT 1 FROM test_index s WHERE s.status = t.status)",
    }
                if (node instanceof org.apache.calcite.rel.core.Correlate) {  
 * planner pipeline, and assert that no {@code RexSubQuery} remains anywhere in
        }
import org.apache.calcite.plan.RelOptUtil;
    private static void assertNoSubQuery(String message, RelNode plan) {
        assertContainsSubQuery("Pre-condition: parsed plan must carry the IN RexSubQuery", parsed);  
    /** Uncorrelated EXISTS: {@code SELECT * FROM test_index WHERE EXISTS (SELECT 1 FROM test_index)}. */  
    private static void assertContainsSubQuery(String message, RelNode plan) {
     * Correlated EXISTS whose subquery carries a {@code LIMIT N} (N &gt; 1) — the shape the PPL
    /** Uncorrelated IN-list: lowered through {@code FILTER_SUB_QUERY_TO_CORRELATE} too. */
        plan.accept(walker);
    }
 * <p>Tests parse real SQL through {@link SqlPlannerTestFixture}, run the full  
/*  
    private static boolean findSubQuery(RelNode plan) {
     * 1)}, leaving a {@code LogicalCorrelate} that marking rejects. {@code stripExistsSubqueryLimits}
