        return DistributionEnforcementPass.enforce(
        List<OpenSearchSort> found = new ArrayList<>();
import org.apache.calcite.rel.RelCollations;
import org.apache.calcite.rel.RelFieldCollation;  
    /**
     */
            sorts(enforced).stream().filter(s -> s.fetch != null).count()
            collectSorts(input, out);  
    public void testCollatedTopN_shardSortStaysBelowGather() {
        collectSorts(plan, found);  
        }
    }
            hasSortBelowReducer(enforced)
/**
import org.apache.calcite.sql.type.SqlTypeName;  
        RelNode enforced = enforce(runPlanner(collatedSortWithFetch(scan, 10), context), context);  
     */
            out.add(sort);  
            /* shuffleAggregateEnabled */ true  
                + "fragment a bare scan streaming every row:\n"
 * the sort-pushdown rewrite (a shard-local {@code Sort+fetch} below the ER, so each shard ships only its  
    }
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
     * Bare {@code head 10} (no ORDER BY) — the cheapest shape, and the one measured at 15ms mpp-off vs
    private RelNode collatedSortWithFetch(RelNode input, int fetch) {  
 * so without the {@code perPartition} marker it would land in the pass's non-aware branch, which  
            if (hasSortBelowReducer(input)) {
    /** Matches the shuffle partition count the general scheduler is given in the other MPP tests. */  
            context.getDistributionTraitDef(),  
            CLUSTER_DATA_NODES,
        );  
        RelNode enforced = enforce(planned, context);
     * the gather, leaving the shard fragment a bare scan. What matters is that a Sort remains strictly  
        return false;  
            sorts(enforced).size()
        assertTrue("precondition: the rewriter's Sort is below the ER", hasSortBelowReducer(planned));
    public void testCollatedTopN_shardSortKeepsFetch() {  
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        PlannerContext context = multiShardContext();
            "the pushed-down shard fetch must survive the enforcement pass:\n" + RelOptUtil.toString(enforced),  
 * output. {@code OpenSearchSort} is NOT {@link org.opensearch.analytics.planner.rel.DistributionAware},
     * The surviving shard-local Sort must keep its {@code fetch}. A Sort that loses its limit still sorts  
 * Interaction tests for {@link org.opensearch.analytics.planner.rules.OpenSearchSortPushdownRewriter}
    public void testBareLimit_shardFetchStaysBelowGather() {
    private static boolean hasSortBelowReducer(RelNode plan) {  
}  
    }
            rexBuilder.makeLiteral(fetch, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
    public void testCollatedTopN_singleGather() {
            sorts(enforced).stream().anyMatch(s -> s.fetch != null)  
            /* minRows */ 1L,
 * (`sort … | head 10` over 10M rows: 51ms mpp-off vs 5391ms mpp-on); the rewriter now marks the  
            "at least one Sort must still carry fetch=10 below the gather:\n" + RelOptUtil.toString(enforced),
        assertTrue(  
import java.util.List;
        }
        PlannerContext context = multiShardContext();
     * {@code sort field | head 10} over 2 shards: the rewriter pushes a shard-local Sort below the ER, and
 * scan that streams its entire scan to the coordinator. That was a measured ClickBench regression
import org.opensearch.analytics.planner.rel.OpenSearchSort;
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),  
     * every shard row and ships all of them — the same regression with the collation intact.
        );
            "BOTH the shard-local and coordinator Sort carry the fetch:\n" + RelOptUtil.toString(enforced),  
    /**  
        return found;
            input,
                + RelOptUtil.toString(enforced),  
        return LogicalSort.create(
            "the pushed-down shard Sort must survive the enforcement pass:\n" + RelOptUtil.toString(enforced),
 * local top-N), and then, when {@code analytics.mpp.enabled} is set, the enforcement pass walks that
            "the shard Sort must remain BELOW the gather — hoisting it above the ER leaves the shard "
    }  
            2,
import org.apache.calcite.plan.RelOptUtil;
        );
        PlannerContext context = multiShardContext();  
 * <p>Coverage gap this closes: {@code SortPushdownPlanShapeTests} asserts the rewriter's output but never  
            input,
 * <p>These two run back-to-back in {@code DefaultPlanExecutor}: {@code PlannerImpl.createPlan} ends with
        for (RelNode input : node.getInputs()) {
    /**  
import org.apache.calcite.rel.logical.LogicalSort;
            null,
 * this file be licensed under the Apache-2.0 license or a
 * an aggregate. Non-aggregate top-N under MPP was untested.
    }
package org.opensearch.analytics.planner;
 * and {@link DistributionEnforcementPass} on NON-aggregate top-N (`sort … | head N`).  
    }
            2,  
    }
        assertEquals(
        assertEquals("rewriter pushed a shard-local fetch below the ER", 2, sorts(planned).size());
        }  
     */  
import org.opensearch.analytics.exec.join.DistributionEnforcementPass;
        assertEquals("exactly one gather for a single-scan top-N:\n" + RelOptUtil.toString(enforced), 1L, reducers);
    private static void collectSorts(RelNode node, List<OpenSearchSort> out) {
        }
        assertTrue("the shard-local fetch must remain BELOW the gather:\n" + RelOptUtil.toString(enforced), hasSortBelowReducer(enforced));
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));  
import org.apache.calcite.rel.RelNode;
        );  
        );
        PlannerContext context = multiShardContext();  
     * The enforcement pass must not multiply gathers either: a single-scan top-N needs exactly ONE
        assertEquals("rewriter pushed a shard-local Sort below the ER", 2, sorts(planned).size());  
        assertTrue(
    /**
            }
 * re-gathers the child and thereby HOISTS the shard Sort above the ER — leaving the shard fragment a bare
            rexBuilder.makeLiteral(fetch, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
 * compatible open source license.
    private RelNode bareLimit(RelNode input, int fetch) {  
     * 47ms mpp-on. The shard-local fetch must survive enforcement too.
     */
 * runs the enforcement pass, and {@code CascadeShuffleProbeTests}'s only Sort case is a global sort ABOVE
            null,
        if (node instanceof OpenSearchSort sort) {
     * ExchangeReducer. A second gather would add a redundant coordinator round-trip.  
            return sorts(reducer.getInput(0)).isEmpty() == false;
            2,
        );  
        long reducers = RelOptUtil.toString(enforced).lines().filter(l -> l.contains("OpenSearchExchangeReducer")).count();  
                return true;  
    private static List<OpenSearchSort> sorts(RelNode plan) {
            sorts(enforced).size()
        return LogicalSort.create(
 *
    /**
            RelCollations.EMPTY,  
    private static final int CLUSTER_DATA_NODES = 3;
 * pushed-down Sort {@code perPartition} and the pass rides it on its child's distribution.
    }
        RelNode enforced = enforce(planned, context);  
 * The OpenSearch Contributors require contributions made to  
public class SortPushdownEnforcementTests extends PlanShapeTestBase {
/*  
 *
 */  
        );
        for (RelNode input : plan.getInputs()) {
import java.util.ArrayList;
        RelNode planned = runPlanner(bareLimit(scan, 10), context);
        assertEquals(
    }
        assertEquals(
        );  
     * Counting Sorts is NOT enough — the regression kept both Sorts but HOISTED the shard-local one above
 *
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        if (plan instanceof org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer reducer) {
        RelNode enforced = enforce(runPlanner(collatedSortWithFetch(scan, 10), context), context);
     * degenerates to a bare scan that ships every row (51ms → 5391ms on 10M ClickBench rows).  
    private RelNode enforce(RelNode plan, PlannerContext context) {  
     * the enforcement pass must LEAVE IT THERE. If the pass hoists it above the gather, the shard fragment
     * BELOW the ExchangeReducer, i.e. inside the shard fragment.
        RelNode planned = runPlanner(collatedSortWithFetch(scan, 10), context);
            plan,
     */
    }
 * SPDX-License-Identifier: Apache-2.0
 */  
