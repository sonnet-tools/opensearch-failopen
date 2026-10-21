        boolean[] found = { false };
        };
                + " 'Unrecognized filter operator [EXISTS / EXISTS]'.",
        assertContainsSubQuery("Pre-condition: parsed plan must carry the IN RexSubQuery", parsed);
    public void testCorrelatedExistsWithSubqueryLimitIsLowered() {
     * 1)}, leaving a {@code LogicalCorrelate} that marking rejects. {@code stripExistsSubqueryLimits}
        assertNoSubQuery(
                return found[0] ? node : super.visit(node);
     * frontend produces by injecting a {@code SUBSEARCH_MAXOUT} {@code Sort} inside the subsearch.
        RelNode result = runPlanner(parsed, singleShardContext());
        plan.accept(walker);
import org.apache.calcite.rex.RexSubQuery;
/**
            "subquery-remove phase must lower every RexSubQuery (EXISTS / IN / SOME / ANY) before"
    }
        RexShuttle rexFinder = new RexShuttle() {
    /**
        assertContainsSubQuery("Pre-condition: parsed plan must carry the EXISTS RexSubQuery", parsed);
            result
            "SELECT * FROM test_index t WHERE EXISTS" + " (SELECT 1 FROM test_index s WHERE s.status = t.status)",
        ClusterState parserState = SqlPlannerTestFixture.clusterStateWith("test_index", intFields());
    /** Correlated EXISTS: subquery references an outer-row column. */
}
                node.accept(rexFinder);
    // ---- Helpers ----
                found[0] = true;
 * SPDX-License-Identifier: Apache-2.0
                + " (no leftover RexSubQuery, no leftover LogicalCorrelate).",
            @Override
        ClusterState parserState = SqlPlannerTestFixture.clusterStateWith("test_index", intFields());
     * {@link org.apache.calcite.sql2rel.RelDecorrelator} bails on a correlated {@code Sort(fetch &gt;
        RelNode parsed = SqlPlannerTestFixture.parseSql(
        );
 *
        boolean[] found = { false };
 */
     * removes the existence-irrelevant limit so the EXISTS still fully decorrelates.
 */
    private static void assertNoCorrelate(String message, RelNode plan) {
                + " limit must be stripped so no LogicalCorrelate survives into marking.",
    private static void assertContainsSubQuery(String message, RelNode plan) {
        );
        };
    private static boolean findSubQuery(RelNode plan) {
        );
 * {@link PlannerImpl#runAllOptimizations}. The phase lowers {@link RexSubQuery}s
import org.opensearch.cluster.ClusterState;
            @Override
        RelNode parsed = SqlPlannerTestFixture.parseSql("SELECT * FROM test_index WHERE EXISTS (SELECT 1 FROM test_index)", parserState);
            throw new AssertionError(message + "\nPost-optimize plan:\n" + RelOptUtil.toString(plan));
 * doesn't include {@code EXISTS}) reject the plan.
        ClusterState parserState = SqlPlannerTestFixture.clusterStateWith("test_index", intFields());
import org.apache.calcite.rel.RelShuttle;
            public org.apache.calcite.rex.RexNode visitSubQuery(RexSubQuery sub) {
        assertNoSubQuery(
        return found[0];
            }
 * this file be licensed under the Apache-2.0 license or a
            }
        }
    public void testInSubqueryIsLowered() {
        ClusterState parserState = SqlPlannerTestFixture.clusterStateWith("test_index", intFields());
    }
     * Correlated EXISTS whose subquery carries a {@code LIMIT N} (N &gt; 1) — the shape the PPL
            }
 * which resolves leaf predicates through a {@code ScalarFunction} table that
     */
        RelNode parsed = SqlPlannerTestFixture.parseSql(
        assertContainsSubQuery("Pre-condition: parsed plan must carry the EXISTS RexSubQuery", parsed);
        );
import org.apache.calcite.rel.RelNode;
    }
                if (node instanceof org.apache.calcite.rel.core.Correlate) {
        assertNoSubQuery(
            "subquery-remove + decorrelate must convert a correlated EXISTS into a standard join"
        RelShuttle relWalker = new RelHomogeneousShuttle() {
        );
        RelNode result = runPlanner(parsed, singleShardContext());
        if (findSubQuery(plan)) {
/*
        );
            parserState
            "subquery-remove must cover IN subqueries in addition to EXISTS — both flow through"
        RelNode result = runPlanner(parsed, singleShardContext());
                }
        if (found[0]) {
            "SELECT * FROM test_index WHERE status IN (SELECT status FROM test_index)",
                if (found[0]) return node;
        );
 *
            parserState
        }
        assertNoCorrelate(
    }
 * {@code *_SUB_QUERY_TO_CORRELATE} rules, then decorrelates the result into a
 * <p>Tests parse real SQL through {@link SqlPlannerTestFixture}, run the full
                + " marking — otherwise OpenSearchFilterRule rejects the operator at runtime with"
        );
            public RelNode visit(RelNode node) {
package org.opensearch.analytics.planner;
        assertContainsSubQuery("Pre-condition: parsed plan must carry the EXISTS RexSubQuery", parsed);
        RelNode parsed = SqlPlannerTestFixture.parseSql(
    }
        RelNode result = runPlanner(parsed, singleShardContext());
    public void testUncorrelatedExistsSubqueryIsLowered() {
 * The OpenSearch Contributors require contributions made to
 * planner pipeline, and assert that no {@code RexSubQuery} remains anywhere in
            "SELECT * FROM test_index t WHERE EXISTS" + " (SELECT 1 FROM test_index s WHERE s.status = t.status LIMIT 10)",
                    found[0] = true;
                return super.visit(node);
            result
            throw new AssertionError(message + "\nPost-optimize plan:\n" + RelOptUtil.toString(plan));
            @Override
        };
import org.apache.calcite.rex.RexShuttle;
    /** Uncorrelated EXISTS: {@code SELECT * FROM test_index WHERE EXISTS (SELECT 1 FROM test_index)}. */
                return sub;
    private static void assertNoSubQuery(String message, RelNode plan) {
import org.apache.calcite.rel.RelHomogeneousShuttle;
 * Plan-shape coverage for the {@code subquery-remove} phase introduced in
                + " the same CoreRules.FILTER_SUB_QUERY_TO_CORRELATE rewrite.",
        if (!findSubQuery(plan)) {
            parserState
 * compatible open source license.
                    return node;
        assertNoSubQuery(
            "correlated EXISTS with a subquery LIMIT must still fully lower (no leftover" + " RexSubQuery / LogicalCorrelate).",
            result
    }
            throw new AssertionError(message + "\nPlan:\n" + RelOptUtil.toString(plan));
    }
 * straight join. Without it, downstream rules (e.g. {@code OpenSearchFilterRule}
 * (EXISTS / IN / SOME / ANY) into {@code LogicalCorrelate} via Calcite's three
    /** Uncorrelated IN-list: lowered through {@code FILTER_SUB_QUERY_TO_CORRELATE} too. */
            public RelNode visit(RelNode node) {
public class SubQueryPlanShapeTests extends PlanShapeTestBase {
            "RelDecorrelator cannot decorrelate a correlated Sort(fetch>1); the EXISTS subsearch"
        }
        plan.accept(relWalker);
            result
    }
 * the optimized tree — the strongest invariant the phase guarantees.
            result
        RelShuttle walker = new RelHomogeneousShuttle() {
import org.apache.calcite.plan.RelOptUtil;
    public void testCorrelatedExistsSubqueryIsLowered() {
