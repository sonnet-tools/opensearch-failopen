        PlannerContext context = multiShardContext();
 * <p>These two run back-to-back in {@code DefaultPlanExecutor}: {@code PlannerImpl.createPlan} ends with
        }
 * re-gathers the child and thereby HOISTS the shard Sort above the ER — leaving the shard fragment a bare
            out.add(sort);
    }
        );
     * the enforcement pass must LEAVE IT THERE. If the pass hoists it above the gather, the shard fragment
     */
     * Counting Sorts is NOT enough — the regression kept both Sorts but HOISTED the shard-local one above
        RelNode enforced = enforce(runPlanner(collatedSortWithFetch(scan, 10), context), context);
import org.apache.calcite.plan.RelOptUtil;
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
            input,
/**
        );
 * an aggregate. Non-aggregate top-N under MPP was untested.
            rexBuilder.makeLiteral(fetch, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
import org.apache.calcite.rel.logical.LogicalSort;
    }
     */
}
            "the pushed-down shard Sort must survive the enforcement pass:\n" + RelOptUtil.toString(enforced),
 * Interaction tests for {@link org.opensearch.analytics.planner.rules.OpenSearchSortPushdownRewriter}
 * local top-N), and then, when {@code analytics.mpp.enabled} is set, the enforcement pass walks that
    }
    /**
            null,
     * The enforcement pass must not multiply gathers either: a single-scan top-N needs exactly ONE
        assertEquals("exactly one gather for a single-scan top-N:\n" + RelOptUtil.toString(enforced), 1L, reducers);
        );
            hasSortBelowReducer(enforced)
     */
     * {@code sort field | head 10} over 2 shards: the rewriter pushes a shard-local Sort below the ER, and
            "the shard Sort must remain BELOW the gather — hoisting it above the ER leaves the shard "
            return sorts(reducer.getInput(0)).isEmpty() == false;
        PlannerContext context = multiShardContext();
/*
        collectSorts(plan, found);
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
    public void testCollatedTopN_singleGather() {
        for (RelNode input : plan.getInputs()) {
        assertEquals(
        RelNode planned = runPlanner(bareLimit(scan, 10), context);
        assertTrue(
 * the sort-pushdown rewrite (a shard-local {@code Sort+fetch} below the ER, so each shard ships only its
        for (RelNode input : node.getInputs()) {
            "at least one Sort must still carry fetch=10 below the gather:\n" + RelOptUtil.toString(enforced),
 */
import org.apache.calcite.rel.RelCollations;
    private static void collectSorts(RelNode node, List<OpenSearchSort> out) {
            /* minRows */ 1L,
            input,
     * BELOW the ExchangeReducer, i.e. inside the shard fragment.
import org.apache.calcite.rel.RelFieldCollation;
            "the pushed-down shard fetch must survive the enforcement pass:\n" + RelOptUtil.toString(enforced),
        return false;
        RelNode planned = runPlanner(collatedSortWithFetch(scan, 10), context);
 *
     * ExchangeReducer. A second gather would add a redundant coordinator round-trip.
            2,
        RelNode enforced = enforce(runPlanner(collatedSortWithFetch(scan, 10), context), context);
import org.opensearch.analytics.planner.rel.OpenSearchSort;
 * this file be licensed under the Apache-2.0 license or a
    public void testBareLimit_shardFetchStaysBelowGather() {
     */
import java.util.ArrayList;
        );
import org.opensearch.analytics.exec.join.DistributionEnforcementPass;
                return true;
            2,
        );
    public void testCollatedTopN_shardSortKeepsFetch() {
        }
        assertEquals("rewriter pushed a shard-local Sort below the ER", 2, sorts(planned).size());
     * every shard row and ships all of them — the same regression with the collation intact.
        assertTrue(
 * runs the enforcement pass, and {@code CascadeShuffleProbeTests}'s only Sort case is a global sort ABOVE
        assertEquals("rewriter pushed a shard-local fetch below the ER", 2, sorts(planned).size());
            null,
            /* shuffleAggregateEnabled */ true
        PlannerContext context = multiShardContext();
            sorts(enforced).size()
            }
    }
import org.apache.calcite.sql.type.SqlTypeName;
 */
     * The surviving shard-local Sort must keep its {@code fetch}. A Sort that loses its limit still sorts
        assertEquals(
 * pushed-down Sort {@code perPartition} and the pass rides it on its child's distribution.
        if (node instanceof OpenSearchSort sort) {
        return LogicalSort.create(
    /**
import java.util.List;
            "BOTH the shard-local and coordinator Sort carry the fetch:\n" + RelOptUtil.toString(enforced),
        List<OpenSearchSort> found = new ArrayList<>();
                + "fragment a bare scan streaming every row:\n"
            sorts(enforced).stream().anyMatch(s -> s.fetch != null)
        RelNode enforced = enforce(planned, context);
            collectSorts(input, out);
 * output. {@code OpenSearchSort} is NOT {@link org.opensearch.analytics.planner.rel.DistributionAware},
 * so without the {@code perPartition} marker it would land in the pass's non-aware branch, which
        assertTrue("precondition: the rewriter's Sort is below the ER", hasSortBelowReducer(planned));
            context.getDistributionTraitDef(),
            rexBuilder.makeLiteral(fetch, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            CLUSTER_DATA_NODES,
 * compatible open source license.
            2,
        );
 *
    }
    private RelNode bareLimit(RelNode input, int fetch) {
        }
        assertEquals(
        RelNode enforced = enforce(planned, context);
                + RelOptUtil.toString(enforced),
     * degenerates to a bare scan that ships every row (51ms → 5391ms on 10M ClickBench rows).
 * (`sort … | head 10` over 10M rows: 51ms mpp-off vs 5391ms mpp-on); the rewriter now marks the
            sorts(enforced).stream().filter(s -> s.fetch != null).count()
        if (plan instanceof org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer reducer) {
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
            RelCollations.EMPTY,
    }
    }
    }
        return found;
    }
    /**
public class SortPushdownEnforcementTests extends PlanShapeTestBase {
        long reducers = RelOptUtil.toString(enforced).lines().filter(l -> l.contains("OpenSearchExchangeReducer")).count();
            plan,
package org.opensearch.analytics.planner;
    private RelNode collatedSortWithFetch(RelNode input, int fetch) {
            sorts(enforced).size()
    private RelNode enforce(RelNode plan, PlannerContext context) {
    /** Matches the shuffle partition count the general scheduler is given in the other MPP tests. */
    /**
 * scan that streams its entire scan to the coordinator. That was a measured ClickBench regression
     * 47ms mpp-on. The shard-local fetch must survive enforcement too.
     * the gather, leaving the shard fragment a bare scan. What matters is that a Sort remains strictly
    }
        );
 * The OpenSearch Contributors require contributions made to
 * SPDX-License-Identifier: Apache-2.0
        );
        assertTrue("the shard-local fetch must remain BELOW the gather:\n" + RelOptUtil.toString(enforced), hasSortBelowReducer(enforced));
 * and {@link DistributionEnforcementPass} on NON-aggregate top-N (`sort … | head N`).
 * <p>Coverage gap this closes: {@code SortPushdownPlanShapeTests} asserts the rewriter's output but never
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        PlannerContext context = multiShardContext();
    public void testCollatedTopN_shardSortStaysBelowGather() {
        return DistributionEnforcementPass.enforce(
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
     */
     * Bare {@code head 10} (no ORDER BY) — the cheapest shape, and the one measured at 15ms mpp-off vs
        return LogicalSort.create(
    /**
    private static final int CLUSTER_DATA_NODES = 3;
import org.apache.calcite.rel.RelNode;
            if (hasSortBelowReducer(input)) {
    private static boolean hasSortBelowReducer(RelNode plan) {
 *
        }
    private static List<OpenSearchSort> sorts(RelNode plan) {
