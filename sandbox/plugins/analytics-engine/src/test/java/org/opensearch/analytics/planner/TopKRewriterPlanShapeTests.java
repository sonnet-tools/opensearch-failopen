        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));
            null,
                    typeFactory.createSqlType(SqlTypeName.BIGINT),
                            OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
     */
            scan,
    /** Factor=0 → no per-partition Sort inserted. */
        for (int i = 0; i < measureCount; i++) {
     * PPL: {@code stats count() as c by X, Y | stats sum(c) as total by X | sort - total | head 5}
        return LogicalSort.create(
        );
    private static long countShardSortsBelowER(String plan) {
        );
                    null,
     */
    }
        );
        RelNode swapProject = LogicalProject.create(
            List.of(),
    }
        RelNode scan = stubScan(table);
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),
    // ── Detection: AVG does NOT get TopK (reduce decomposition inserts computed Project) ──
            agg,
            contextWithOversampling(2.0)
                """,
            innerAgg,
                    List.of(),
            null,
            agg,
        assertTrue("no per-partition Sort for scalar aggregate", sortCount <= 1);
        long sortCount = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();
     * Multi-group-by, single COUNT, sort on measure. Shard sort must use $2.
    /**
import org.apache.calcite.rex.RexNode;
    /** Aggregate without group-by (scalar agg) → skip. */
        RexNode lit10 = rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true);
                AggregateCall.create(
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));
            swapProject,
     * post-project schema. Remapping should produce shard sort on $0 (the group key at
     *
        );
    public void testRewrite_multiGroupByCount_splitAndTopK() {
    public void testRewrite_pplShape_ascDirection_preserved() {
        RelNode result = runPlanner(outerLimit, contextWithOversampling(2.0));
            rexBuilder.makeLiteral(1000, typeFactory.createSqlType(SqlTypeName.INTEGER), true),
    /** AVG is decomposed into SUM/COUNT with a divide Project — rewriter bails. */
            agg,
        RelNode inner = buildSortHeadOverGroupedCount(); // Sort(collation $1 DESC, fetch 10) over grouped count
            if (belowER && line.contains("OpenSearchSort")) {
        RelNode outerLimit = LogicalSort.create(
import org.opensearch.analytics.settings.DelegationBlockList;
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
    }
    /** Large fetch (head 1000) with swap: shard fetch = ceil(1000*2)+1000 = 3000. */
            proj,
        String plan = RelOptUtil.toString(result);
import org.apache.calcite.util.ImmutableBitSet;
        assertPlanShape(
            agg,
     * partial agg level). Ensures the fix doesn't break sort-by-key queries.
    public void testRewrite_twoSorts_onlyBottomModified() {
        RelOptTable table = mockTable("test_index", "status", "size");
        );
        LogicalAggregate outerAgg = LogicalAggregate.create(
                            OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        assertEquals("Computed expression in Project — TopK must bail", 0, countShardSortsBelowER(plan));
                      OpenSearchProject(status=[$0], dc=[$1], viableBackends=[[mock-parquet]])
        for (String line : lines) {
    }
            outerAgg,
        );
    /**
                return line.contains("sort0=[" + expectedField + "]");
            null,
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),
     * Non-literal offset (parameterized expression): rewriter bails to no-pushdown rather than
            null,
                          OpenSearchSort(sort0=[$1], dir0=[DESC], fetch=[30], viableBackends=[[mock-parquet]])
        return LogicalSort.create(
            inner,
            swapProject,
                    RelCollations.EMPTY,
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            }
            innerSort,
            swapExprs.add(rexBuilder.makeInputRef(agg, groupCount + i));
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),
 */
        assertTrue("shard fetch must be 330, plan:\n" + plan, plan.contains("fetch=[330]"));
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),
     * Single group-by, single COUNT, sort on measure. Shard sort must use $1.
    public void testRewrite_nonLiteralOffset_bails() {
            agg,
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            List.of("cnt", "status")
            null,
            agg,
     * register SORT_REMOVE_REDUNDANT. DF collapses them in the physical plan.
        // Sort on $1 (which is status/group-key in the swapped schema)
import org.apache.calcite.rel.logical.LogicalProject;
        RelNode sort = LogicalSort.create(
        assertPlanShape(
                      OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
    }
            """
        RelNode swapProject = LogicalProject.create(
        assertTrue("shard fetch must be 25, plan:\n" + plan, plan.contains("fetch=[25]"));
        RelNode scan = stubScan(table);
                  OpenSearchSort(sort0=[$1], dir0=[DESC], fetch=[10], viableBackends=[[mock-parquet]])
                OpenSearchSort(sort0=[$0], dir0=[DESC], fetch=[10000], viableBackends=[[mock-parquet]])
            innerSort,
        );
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));
     */
        List<String> swapNames = new ArrayList<>();
        );
     * The outer aggregate's PARTIAL input subtree contains another aggregate, so TopK must bail.
        RelOptTable table = mockTable("test_index", "status", "size");
        );
                                OpenSearchAggregate(group=[{0}], dc=[APPROX_COUNT_DISTINCT($1)], mode=[PARTIAL], viableBackends=[[mock-parquet]])
    public void testDetection_bareLimitNoCollation_skipped() {
    private static boolean planHasShardSortOn(String plan, String expectedField) {
        }
            buildPplSwapPlan(ImmutableBitSet.of(0, 1), List.of(countStarCall(stubScan(mockTable("test_index", "status", "size")))), 10),
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));
            rexBuilder.makeLiteral(1000, typeFactory.createSqlType(SqlTypeName.INTEGER), true),
 */
                              OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
        String plan = RelOptUtil.toString(result);
                """,
        // Inner agg: count() by (status, size)
        RelOptTable table = mockTable("test_index", "status", "size");
        );
                              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RelOptTable table = mockTable("test_index", "status", "size");
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));
     * SystemLimit($0 DESC, 10000) → Sort($0 DESC, fetch) → Project(measures..., keys...) → Agg
        RelNode result = runPlanner(buildSortHeadOverGroupedCount(), contextWithOversampling(2.0));
     * output (keys first, measures second) into (measures first, keys second) via a Project,
                OpenSearchSort(sort0=[$2], dir0=[DESC], fetch=[10], viableBackends=[[mock-parquet]])
    }
        );
        );
        RelNode scan = stubScan(table);
        String plan = RelOptUtil.toString(result);
    public void testDetection_factorZero_skipped() {
        RelOptTable table = mockTable("test_index", "status", "size");
            swapProject,
        // Sort on $0 (first measure in swapped output)
                          OpenSearchSort(sort0=[$0], dir0=[DESC], fetch=[30], viableBackends=[[mock-parquet]])
            List.of(rexBuilder.makeLiteral(42, typeFactory.createSqlType(SqlTypeName.INTEGER), true), rexBuilder.makeInputRef(agg, 0)),
            List.of(),
        );
     */
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));
     * <p>Expected shard fetch: {@code ceil(1010*2) + 1010 = 3030}. Without offset handling the
            List.of(rexBuilder.makeInputRef(agg, 1), rexBuilder.makeInputRef(agg, 0)),
                    OpenSearchProject(cnt=[$1], status=[$0], viableBackends=[[mock-parquet]])
            List.of(
import java.util.List;
        );
                      OpenSearchSort(sort0=[$2], dir0=[DESC], fetch=[30], viableBackends=[[mock-parquet]])
        long sortCount = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();
            buildPplSwapPlan(ImmutableBitSet.of(0, 1), List.of(approxCountDistinctCall(scan)), 10),
        );
        LogicalAggregate agg = LogicalAggregate.create(
            rexBuilder.makeLiteral(Integer.MAX_VALUE - 5, typeFactory.createSqlType(SqlTypeName.INTEGER), true),
        String plan = RelOptUtil.toString(result);
        RelNode outerLimit = LogicalSort.create(
     */
                    false,
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
    public void testRewrite_dcByGroup_splitAndTopK() {
                belowER = true;
    /** Computed expression (literal) in Project between Sort and Aggregate — rewriter bails. */
            swapExprs.add(rexBuilder.makeInputRef(agg, i));
    public void testRewrite_pplShape_q15_multiGroup_sortKeyRemappedThroughProject() {
            List.of("const", "status")
    }
        RelNode result = runPlanner(buildPplSwapPlan(ImmutableBitSet.of(0), List.of(countStarCall()), 1000), contextWithOversampling(2.0));
    }
        RelNode result = runPlanner(sort, contextWithOversampling(1.0));
        );
        RelNode sort = LogicalSort.create(
        RelNode sort = LogicalSort.create(
        String[] lines = plan.split("\n");
        );
            innerSort,
            }
        );
        long sortCount = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();
        String plan = RelOptUtil.toString(result);
                                  OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    }
    /** Two Sorts in plan: only the bottommost (with collation above FINAL) triggers TopK. */
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));
            "shard Sort must be sized as ceil((offset+fetch)*factor) + (offset+fetch) = 3030, got plan:\n" + plan,
     * guessing a value. Each shard ships everything; correct but slow. PPL emits literal offsets
            swapNames.add(agg.getRowType().getFieldNames().get(groupCount + i));
        );
    // ── Rewrite: per-partition Sort IS inserted ──────────────────────────────
     * negative or wrong fetch literal.
                    List.of(),
                        OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
    }
        // Even without PROJECT_MERGE, the rewriter passes through multiple plain-column projects
                )
        );
        String plan = RelOptUtil.toString(result);
        RelNode swapProject = LogicalProject.create(
        assertEquals("non-literal offset → no per-partition Sort inserted", 1, sortCount);
        assertEquals("expected 1 Sort (coord only)", 1, sortCount);
            result
        assertTrue("bare LIMIT should not produce a per-partition Sort", sortCount <= 1);
        long count = 0;
     * TopK on the inner agg would truncate (X, Y) groups before the outer sum sees all of them,
            List.of(),
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.DESCENDING)),
            """
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));
                  OpenSearchSort(sort0=[$0], dir0=[DESC], fetch=[10], viableBackends=[[mock-parquet]])
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.DESCENDING)),
        );
        for (int i = 0; i < groupCount; i++) {
            rexBuilder.makeLiteral(10000, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            agg,
     * in practice, so this is a defensive check.
        RelNode scan = stubScan(table);
    }
        assertPlanShape(
    public void testDetection_computedProjectExpression_topKBails() {
        RelNode scan = stubScan(table);
    /** No aggregate in plan → TopK must not fire (sort-pushdown may add a shard Sort, which is fine). */
            rexBuilder.makeLiteral(5, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        RelNode outerLimit = LogicalSort.create(
        assertTrue("shard sort must use $1", planHasShardSortOn(plan, "$1"));
        );
                    -1,
    private RelNode buildBareLimitOverGroupedCount() {
            rexBuilder.makeLiteral(10000, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        RelOptTable table = mockTable("test_index", "status", "size");
            swapNames.add(agg.getRowType().getFieldNames().get(i));
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            List.of(rexBuilder.makeInputRef(proj1, 0), rexBuilder.makeInputRef(proj1, 1)),
package org.opensearch.analytics.planner;
    /** SUM aggregate: partial SUM is directly sortable, no reduce_eval needed. */
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countDistinctCall(scan)));
        // PROJECT_MERGE collapses the two adjacent identity projects, so TopK fires.
                    RelCollations.EMPTY,
     * — i.e. {@code coordLimit = offset + fetch}. Shard fetch is then the usual oversampling
    }
                              OpenSearchProject(status=[$0], dc=[$1], __reduce_eval_1=[reduce_eval('approx_distinct', $1)], viableBackends=[[mock-parquet]])
        assertTrue("shard fetch must be 3000, plan:\n" + plan, plan.contains("fetch=[3000]"));
                                OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        int groupCount = groupSet.cardinality();
                                OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RelNode scan = stubScan(table);
            null,
    public void testDetection_noGroupBy_skipped() {
            null,
        return ctx;
        RexNode lit5 = rexBuilder.makeLiteral(5, typeFactory.createSqlType(SqlTypeName.INTEGER), true);
        );
 * The OpenSearch Contributors require contributions made to
    private RelNode buildSortHeadOverGroupedCount() {
        assertFalse("shard Sort must NOT be sized off fetch alone (30)", plan.contains("fetch=[30]"));
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));
     * Collated outer system-limit over a collated inner head: oversampling must honor the INNER
        assertEquals("expected 2 Sorts (coord + per-partition)", 2, sortCount);
            null,
        assertTrue("factor=1 → shard fetch = 2 * (offset+fetch) = 2020, got plan:\n" + plan, plan.contains("fetch=[2020]"));
    public void testRewrite_sumByGroup_sortInserted() {
        for (String line : lines) {
        List<RexNode> swapExprs = new ArrayList<>();
        RelOptTable table = mockTable("test_index", "status", "size");
                              OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
     */
 * SPDX-License-Identifier: Apache-2.0
                            OpenSearchAggregate(group=[{0, 1}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(outerLimit, contextWithOversampling(2.0));
     * This test verifies the safe-bail behavior when two projects reach the rewriter.
        RelNode sort = LogicalSort.create(
     */
     * then creates a Sort on $0 (the first measure in swapped output).
import org.apache.calcite.rel.logical.LogicalAggregate;
import org.apache.calcite.plan.RelOptTable;
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                """,
            agg,
        RelOptTable table = mockTable("test_index", "status", "size");
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            swapProject,
                OpenSearchSort(sort0=[$1], dir0=[DESC], fetch=[10], viableBackends=[[mock-parquet]])
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.rel.RelCollations;
        // Shard Sort fetch = offset + ceil(fetch * factor) + fetch = 0 + ceil(10*2) + 10 = 30.
        // Bare LIMIT: empty collation, just fetch
     *
                    false,
     * Offset close to {@code Integer.MAX_VALUE} pushes shardSize past int range — rewriter must
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));
            agg,
        RelNode result = runPlanner(outerLimit, contextWithOversampling(2.0));
            List.of("status", "cnt")
    public void testRewrite_pplShape_largeFetch_shardFetchCorrect() {
        RelNode innerSort = LogicalSort.create(
            plan.contains("ExchangeReducer") && plan.indexOf("ExchangeReducer") < plan.lastIndexOf("OpenSearchSort")
                    SqlStdOperatorTable.SUM,
    public void testRewrite_pplShape_q11_dcWithSwap_sortKeyRemapped() {
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        RelNode sort = LogicalSort.create(
/*
    /** dc(x) by group + sort + head: APPROX_COUNT_DISTINCT splits with TopK reduce_eval. */
                OpenSearchSort(sort0=[$0], dir0=[DESC], fetch=[10000], viableBackends=[[mock-parquet]])
     * formula applied to that coord limit: {@code ceil(coordLimit * factor) + coordLimit}.
    public void testRewrite_offsetOverflow_bails() {
     * <p>PPL always puts measures first in output. This builder reorders the Aggregate's
        );
        RelNode scan = stubScan(table);
            contextWithOversampling(2.0)
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));
    }
                        OpenSearchSort(sort0=[$2], dir0=[DESC], fetch=[30], viableBackends=[[mock-parquet]])
    public void testRewrite_collatedOuterLimit_honorsInnerFetch() {
        return count;
    }
        );
        RelNode scan = stubScan(table);
        String plan = RelOptUtil.toString(result);
        RelNode scan = stubScan(table);
 * and Rewrite (insertion cases).
        RelOptTable table = mockTable("test_index", "status", "size");
        RelNode scan = stubScan(table);
                    -1,
        RelNode sort = LogicalSort.create(
    public void testDetection_avgByGroup_noTopK() {
            scan,
                belowER = true;
                    typeFactory.createSqlType(SqlTypeName.INTEGER),
                        OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                    false,
    /** Swap with offset: shard fetch must honor offset. */
        RelOptTable table = mockTable("test_index", "status", "size");
}
        RelOptTable table = mockTable("test_index", "status", "size");
        RelNode innerSort = LogicalSort.create(
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),
            agg,
    public void testDetection_chainedStats_topKBails() {
     */
        long sortCount = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();
        long sortCount = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();
            ImmutableBitSet.of(0),
            null,
        RelOptTable table = mockTable("test_index", "status", "size");
        RelNode result = runPlanner(
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.DESCENDING)),
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), groupSet, null, aggCalls);
                    false,
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            nonLiteralOffset,
        String plan = RelOptUtil.toString(result);
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        RelOptTable table = mockTable("test_index", "status", "size");
            rexBuilder.makeLiteral(10000, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            RelCollations.EMPTY,
    }
        // Second Project: also identity
            )
            null,
import org.opensearch.analytics.settings.PlannerSettings;
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
     * blocked), the rewriter now safely bails — accepting the second project is unsafe since it
                    "total"
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),
        RelOptTable table = mockTable("test_index", "status", "size");
        );
     */
            """
        assertEquals("AVG decomposition prevents TopK — no shard Sort", 0, countShardSortsBelowER(plan));
     */
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));
        RelNode result = runPlanner(buildSortHeadOverGroupedCount(), contextWithOversampling(0.0));
            List.of(rexBuilder.makeInputRef(agg, 0), rexBuilder.makeInputRef(agg, 1)),
                count++;
        // itself is redundant over a 1-row scalar agg and SORT_REMOVE_REDUNDANT drops it, so the
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.DESCENDING)),
        String plan = RelOptUtil.toString(result);
public class TopKRewriterPlanShapeTests extends PlanShapeTestBase {
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));
        String plan = RelOptUtil.toString(result);
     * fetch, not the outer cap. PPL {@code ... | sort - c | head 10} arrives as
 * Plan shape tests for the TopK rewriter. Grouped into Detection (skip cases)
    }
        // and validates the sort key at the first seenProject — TopK still fires correctly.
            null,
        RelNode scan = stubScan(table);
            result
        RelOptTable table = mockTable("test_index", "status", "size");
                continue;
    public void testRewrite_factorOne_twiceCoordLimit() {
            rexBuilder.makeLiteral(10000, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        boolean belowER = false;
        RelNode proj2 = LogicalProject.create(
        assertFalse("shard Sort must NOT be sized off the 10000 system cap (30000)", plan.contains("fetch=[30000]"));
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        RelNode result = runPlanner(sort, contextWithOversampling(1.5));
            )
                    false,
    }
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.DESCENDING)),
            List.of(),
        );
     * rewriter used {@code coordLimit = fetch = 10}, so each shard shipped 30 rows, the
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0, 1), null, List.of(countStarCall(scan)));
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));
        // Build swap project: measures first, then keys
        RelNode result = runPlanner(outer, contextWithOversampling(2.0));
        assertPlanShape(
    /**
            null,
        String plan = RelOptUtil.toString(result);
        );
     * Builds the PPL-style plan shape with a column-swapping Project:
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),
     * The per-partition shard Sort fetch must derive from 10 (→ ceil(10*2)+10 = 30), not from the
        assertEquals("overflow → no per-partition Sort inserted", 1, sortCount);
        }
        RelNode scan = stubScan(table);
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),
            List.of("status", "cnt")
        RelNode outerLimit = LogicalSort.create(
            RelCollations.EMPTY,
        RelNode sort = LogicalSort.create(
     * factor=1.0 with offset: oversampling collapses to {@code 2 * coordLimit}. For
            proj1,
 *
        );
            """
                        OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            List.of("cnt", "status")
            null,
            contextWithOversampling(2.0)
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));
        assertTrue(
     * dc() with column swap — combines reduce_eval logic with the Project remapping.
        String plan = RelOptUtil.toString(result);
            rexBuilder.makeLiteral(100, typeFactory.createSqlType(SqlTypeName.INTEGER), true),
            agg,
                  OpenSearchSort(sort0=[$0], dir0=[DESC], fetch=[10], viableBackends=[[mock-parquet]])
            innerSort,
    }
            List.of(),
                    null,
        String plan = RelOptUtil.toString(result);
        }
    // ── Helpers ──────────────────────────────────────────────────────────────
        RelOptTable table = mockTable("test_index", "status", "size");
    }
    public void testRewrite_pplShape_factor1_5_shardFetchCorrect() {
     * {@code SystemLimit(fetch=10000, sort0=$1 DESC) → Sort(fetch=10, sort0=$1 DESC) → ... → FINAL}.
    // ── PPL swap plan builder ───────────────────────────────────────────────────
        RelNode scan = stubScan(table);
        assertTrue("at least 2 OpenSearchSort nodes expected", sortCount >= 2);
        assertFalse("no aggregate → TopK must not fire", plan.contains("OpenSearchAggregate"));
        RelNode result = runPlanner(buildBareLimitOverGroupedCount(), contextWithOversampling(2.0));
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.DESCENDING)),
                """,
            null,
        assertPlanShape(
            null,
        assertTrue("TopK should fire with multiple plain-column projects", sortCount >= 2);
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
                            OpenSearchAggregate(group=[{0}], dc=[APPROX_COUNT_DISTINCT($1)], mode=[PARTIAL], viableBackends=[[mock-parquet]])
    /** SUM with swap Project: shard sort must use $1 (the SUM measure). */
        RelNode sort = LogicalSort.create(
                """,
        // Sort on total DESC, head 5
                          OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        // SystemLimit(no collation) → Sort(collation) → Aggregate
        assertEquals("expected 2 Sorts (coord + per-partition)", 2, sortCount);
        assertTrue("shard Sort must be sized off the inner fetch (30), got plan:\n" + plan, plan.contains("fetch=[30]"));
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));
    /** Multi-group-by COUNT + TopK: verifies PARTIAL/FINAL split fires. */
    public void testRewrite_pplShape_sortByGroupKey_remapsCorrectly() {
        RelOptTable table = mockTable("test_index", "status", "size");
        // count is 0; the point is that no extra (per-partition) Sort was inserted.
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
import org.apache.calcite.rel.logical.LogicalSort;
        String plan = RelOptUtil.toString(result);
        RelNode result = runPlanner(buildPplSwapPlan(ImmutableBitSet.of(0), List.of(countStarCall()), 10), contextWithOversampling(1.5));
        RelNode sort = LogicalSort.create(
    /** Basic: Sort(collation, fetch) above grouped COUNT → per-partition Sort inserted. */
            agg,
 * compatible open source license.
        assertTrue("a per-partition Sort must be inserted", sortCount >= 2);
    /** Sort without collation (bare LIMIT) → skip. */
        // Outer system size-limit with the SAME collation and a large cap (what QueryService wraps).
                          OpenSearchSort(sort0=[$2], dir0=[DESC], fetch=[30], viableBackends=[[mock-parquet]])
        );
        );
                  OpenSearchAggregate(group=[{0}], dc=[APPROX_COUNT_DISTINCT($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
            List.of(rexBuilder.makeInputRef(agg, 1), rexBuilder.makeInputRef(agg, 0)),
                      OpenSearchAggregate(group=[{0}], dc=[APPROX_COUNT_DISTINCT($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
            List.of(),
        String plan = RelOptUtil.toString(result);
        RelOptTable table = mockTable("test_index", "status", "size");
    public void testRewrite_countByGroup_sortInserted() {
    // ── PPL column-swap tests: Sort key remapped through intermediate Project ──
        RelNode proj = LogicalProject.create(
        assertEquals("chained stats — TopK must not insert a shard Sort", 0, countShardSortsBelowER(plan));
        RelNode scan = stubScan(table);
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));
        // Project with a literal expression (not a column reference)
            result
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),
        RelNode sort = LogicalSort.create(
                          OpenSearchProject(status=[$0], dc=[$1], viableBackends=[[mock-parquet]])
        assertTrue(
        int measureCount = aggCalls.size();
            List.of(),
import org.apache.calcite.rel.core.AggregateCall;
    /** Factor=1.5 with swap: verifies arithmetic (ceil(10*1.5)+10 = 25). */
    public void testRewrite_pplShape_sumWithSwap_sortKeyRemapped() {
            rexBuilder.makeLiteral(10000, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),
        );
    }
                    OpenSearchProject(cnt=[$2], status=[$0], size=[$1], viableBackends=[[mock-parquet]])
                  OpenSearchAggregate(group=[{0, 1}], cnt=[SUM($2)], mode=[FINAL], viableBackends=[[mock-parquet]])
        String plan = RelOptUtil.toString(result);
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),
    }
    private RelNode buildPplSwapPlan(ImmutableBitSet groupSet, List<AggregateCall> aggCalls, int fetch) {
            null,
    /**
        return false;
        RelOptTable table = mockTable("test_index", "status", "size");
        RelNode result = runPlanner(
import org.apache.calcite.rel.RelFieldCollation;
            rexBuilder.makeLiteral(5, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        RelNode result = runPlanner(buildPplSwapPlan(ImmutableBitSet.of(0), List.of(sumCall(scan)), 10), contextWithOversampling(2.0));
        String[] lines = plan.split("\n");
     */
     */
        boolean belowER = false;
        );
        );
        RelNode result = runPlanner(
                    SqlStdOperatorTable.SUM,
            result
            if (line.contains("ExchangeReducer")) {
            RelCollations.of(new RelFieldCollation(2, RelFieldCollation.Direction.DESCENDING)),
    }
            """
        RelNode scan = stubScan(table);
        RelNode result = runPlanner(outerLimit, contextWithOversampling(2.0));
        RelNode sort = LogicalSort.create(
        );
                            OpenSearchSort(sort0=[$2], dir0=[DESC], fetch=[30], viableBackends=[[mock-parquet]])
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));
        RelNode innerPlan = buildSortHeadOverGroupedCount();
            List.of(
     * Two coordinator Sorts (fetch=10000 + fetch=10) survive because this planner does not
        RelNode scan = stubScan(table);
     * q15: {@code stats count() as c by X, Y | sort - c | head 10}.
 * this file be licensed under the Apache-2.0 license or a
    public void testDetection_multipleProjects_topKStillFires() {
        RelOptTable table = mockTable("test_index", "status", "size");
        );
     * could carry window functions or other expressions that make TopK incorrect.
        // Outer agg: sum(count) by status — groups over the inner agg result
                        OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            List.of(),
        ctx.setPlannerSettings(PlannerSettings.of(factor, DelegationBlockList.empty()));
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
import org.apache.calcite.rel.RelNode;
            null,
            rexBuilder.makeLiteral(10000, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
    /**
    // ── Rewrite: PPL swap Project shapes ────────────────────────────────────────
        RelNode proj1 = LogicalProject.create(
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.DESCENDING)),
                AggregateCall.create(
    }
                      OpenSearchAggregate(group=[{0, 1}], cnt=[SUM($2)], mode=[FINAL], viableBackends=[[mock-parquet]])
        assertTrue("multi-group dc shard sort must use $3 (reduce_eval column), plan:\n" + plan, planHasShardSortOn(plan, "$3"));
                          OpenSearchProject(status=[$0], dc=[$1], __reduce_eval_1=[reduce_eval('approx_distinct', $1)], viableBackends=[[mock-parquet]])
        RelNode sort = LogicalSort.create(
                continue;
                    List.of(2),
            agg,
    }
                    "s"
    }
import java.util.ArrayList;
        RelNode swapProject = LogicalProject.create(agg, List.of(), swapExprs, swapNames);
            innerPlan,
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),
            null,
     * producing catastrophically wrong totals.
            if (line.contains("ExchangeReducer")) {
        String plan = RelOptUtil.toString(result);
        LogicalAggregate innerAgg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0, 1), null, List.of(countStarCall()));
        String plan = RelOptUtil.toString(result);
                OpenSearchSort(sort0=[$0], dir0=[DESC], fetch=[10000], viableBackends=[[mock-parquet]])
        assertPlanShape(
    private PlannerContext contextWithOversampling(double factor) {
            agg,
            null,
    public void testRewrite_pplShape_multiGroupDcWithSwap_sortKeyRemapped() {
            null,
     * {@code head 10 from 1000}: PPL emits {@code Sort(collation, offset=1000, fetch=10)}. The
            agg,
        String plan = RelOptUtil.toString(result);
    /**
     * Multiple adjacent Projects between Sort and Aggregate: PROJECT_MERGE collapses them during
        long sortCount = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();
        assertTrue("shard sort must use $1 ASC", planHasShardSortOn(plan, "$1") && plan.contains("dir0=[ASC]"));
            null,
        long sortCount = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();
                              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        // coordLimit = 100+10 = 110, shardSize = ceil(110*2)+110 = 330
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));
    // ── Detection: chained stats (nested aggregation) must NOT get TopK ─────────
        );
            agg,
        RelNode result = runPlanner(buildPplSwapPlan(ImmutableBitSet.of(0), List.of(countStarCall()), 10), contextWithOversampling(2.0));
    /**
        RelNode scan = stubScan(table);
        String plan = RelOptUtil.toString(result);
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            }
            result
        RelNode innerSort = LogicalSort.create(
            buildPplSwapPlan(ImmutableBitSet.of(0), List.of(approxCountDistinctCall(scan)), 10),
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(avgCall(scan)));
        RelNode scan = stubScan(table);
     * coordinator skips 1000 then takes 10, so its merged stream must contain the global top-1010
                        OpenSearchAggregate(group=[{0, 1}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
    }
    /**
    /** ASC sort direction with swap: direction must be preserved in shard sort. */
        RelNode scan = stubScan(table);
    }
        // 2 = coord collated sort + per-partition sort (outer limit may merge or stay as 3rd)
    }
        );
    public void testDetection_noAggregate_skipped() {
     * RBO so TopK normally fires. If for any reason two projects survive (PROJECT_MERGE removed or
    // ── Detection: rewriter should NOT fire ──────────────────────────────────
                    List.of(1),
        RelOptTable table = mockTable("test_index", "status", "size");
    /**
        String plan = RelOptUtil.toString(result);
        RelNode innerSort = LogicalSort.create(
    public void testRewrite_pplShape_swapWithOffset_shardFetchHonorsOffset() {
            plan.contains("fetch=[3030]")
        RelNode scan = stubScan(table);
        RelOptTable table = mockTable("test_index", "status", "size");
        long sortCount = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();
        );
        );
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));
            List.of("cnt", "status")
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
     * factor=1 just removes the per-coord-row padding multiplier.
        assertTrue("shard sort must use $1", planHasShardSortOn(plan, "$1"));
    }
    }
            """
            rexBuilder.makeLiteral(fetch, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        );
                """,
/**
     * {@code head 10 from 1000} → 2*1010 = 2020. coordLimit = offset+fetch is still honored;
        // First Project: identity (no swap)
        String plan = RelOptUtil.toString(result);
        long sortCount = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            result
            null,
        }
        long sortCount = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();
            if (belowER && line.contains("OpenSearchSort")) {
            proj2,
        // TopK must not add a per-partition Sort for a scalar aggregate. The coordinator Sort
    }
import org.apache.calcite.plan.RelOptUtil;
        );
     * q13: {@code stats count() as c by SearchPhrase | sort - c | head 10}.
            List.of(rexBuilder.makeInputRef(agg, 1), rexBuilder.makeInputRef(agg, 0)),
                    OpenSearchProject(cnt=[$1], status=[$0], viableBackends=[[mock-parquet]])
        RelNode sort = LogicalSort.create(
        RelNode outer = LogicalSort.create(
        );
    /** Multi-group dc() with swap: shard sort must use $3 (reduce_eval appended column). */
                    false,
        );
                )
        PlannerContext ctx = buildContext("parquet", 2, intFields());
     * bail (no per-partition Sort inserted). Without the bail an int overflow would produce a
        return LogicalSort.create(
            }
     * 10000 system cap (which would over-fetch 30000 rows/shard).
                      OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
    }
    }
                  OpenSearchSort(sort0=[$0], dir0=[DESC], fetch=[10], viableBackends=[[mock-parquet]])
        RelNode scan = stubScan(table);
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(), null, List.of(countStarCall()));
     * coordinator skipped 1000, and the result was empty.
        // PPL swap: (cnt=$1, status=$0)
        RexNode nonLiteralOffset = rexBuilder.makeCall(SqlStdOperatorTable.PLUS, lit5, lit10);
                    OpenSearchProject(dc=[$1], status=[$0], viableBackends=[[mock-parquet]])
        // Sort on $0 which is the literal — cannot be remapped
        RelNode scan = stubScan(table);
     * q11: {@code stats dc(UserID) as u by MobilePhoneModel | sort - u | head 10}.
    /**
    public void testRewrite_pplShape_q13_sortKeyRemappedThroughProject() {
    }
            "per-partition Sort must be below ER",
            ImmutableBitSet.of(0),
    public void testRewrite_sortWithOffset_shardFetchHonorsOffset() {
                OpenSearchSort(sort0=[$1], dir0=[DESC], fetch=[10000], viableBackends=[[mock-parquet]])
        // Pre-fix bug: shard Sort sized off bare fetch (30) — coordinator's skip-1000 would have emptied the result.
     * Sort by group key (not measure) with swap Project: the swap puts the key at $1 in
    /**
    /**
