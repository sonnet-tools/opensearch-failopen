        );  
    public void testRewrite_pplShape_largeFetch_shardFetchCorrect() {
    public void testRewrite_twoSorts_onlyBottomModified() {
                OpenSearchSort(sort0=[$0], dir0=[DESC], fetch=[10000], viableBackends=[[mock-parquet]])
            agg,
    /** AVG is decomposed into SUM/COUNT with a divide Project — rewriter bails. */
        );
import org.apache.calcite.rex.RexNode;
                AggregateCall.create(
        long sortCount = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();  
        assertTrue("shard Sort must be sized off the inner fetch (30), got plan:\n" + plan, plan.contains("fetch=[30]"));
     */
            rexBuilder.makeLiteral(Integer.MAX_VALUE - 5, typeFactory.createSqlType(SqlTypeName.INTEGER), true),
    }  
            null,  
/**
     * Collated outer system-limit over a collated inner head: oversampling must honor the INNER  
                    typeFactory.createSqlType(SqlTypeName.BIGINT),
        assertTrue("bare LIMIT should not produce a per-partition Sort", sortCount <= 1);
            innerSort,
            innerSort,
        RelNode sort = LogicalSort.create(  
     * PPL: {@code stats count() as c by X, Y | stats sum(c) as total by X | sort - total | head 5}  
        long count = 0;
        );
                              OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
        RelOptTable table = mockTable("test_index", "status", "size");  
    }
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));
            List.of(),  
    public void testDetection_avgByGroup_noTopK() {  
            null,
                continue;
        RelNode scan = stubScan(table);
        String plan = RelOptUtil.toString(result);  
        long sortCount = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();  
            buildPplSwapPlan(ImmutableBitSet.of(0, 1), List.of(countStarCall(stubScan(mockTable("test_index", "status", "size")))), 10),  
        String[] lines = plan.split("\n");
    /**  
            result
        RelNode result = runPlanner(buildSortHeadOverGroupedCount(), contextWithOversampling(2.0));
        RelNode scan = stubScan(table);
        assertPlanShape(
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));  
     * formula applied to that coord limit: {@code ceil(coordLimit * factor) + coordLimit}.  
            List.of(  
                      OpenSearchAggregate(group=[{0}], dc=[APPROX_COUNT_DISTINCT($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
     *
        );
        long sortCount = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();
        for (String line : lines) {
            rexBuilder.makeLiteral(fetch, typeFactory.createSqlType(SqlTypeName.INTEGER), true)  
                return line.contains("sort0=[" + expectedField + "]");
        String plan = RelOptUtil.toString(result);
        // SystemLimit(no collation) → Sort(collation) → Aggregate
                          OpenSearchProject(status=[$0], dc=[$1], __reduce_eval_1=[reduce_eval('approx_distinct', $1)], viableBackends=[[mock-parquet]])
     * then creates a Sort on $0 (the first measure in swapped output).
     * rewriter used {@code coordLimit = fetch = 10}, so each shard shipped 30 rows, the  
        RelNode result = runPlanner(outerLimit, contextWithOversampling(2.0));  
            contextWithOversampling(2.0)
    // ── Rewrite: PPL swap Project shapes ────────────────────────────────────────
            ImmutableBitSet.of(0),
        assertEquals("expected 2 Sorts (coord + per-partition)", 2, sortCount);
import org.apache.calcite.rel.logical.LogicalAggregate;
     */
            }  
                """,
    // ── Detection: rewriter should NOT fire ──────────────────────────────────
        );
        RelOptTable table = mockTable("test_index", "status", "size");
            null,
        String plan = RelOptUtil.toString(result);
        // and validates the sort key at the first seenProject — TopK still fires correctly.
            List.of("cnt", "status")
            rexBuilder.makeLiteral(10000, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
    /** Large fetch (head 1000) with swap: shard fetch = ceil(1000*2)+1000 = 3000. */  
        RelNode outerLimit = LogicalSort.create(  
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),
            swapNames.add(agg.getRowType().getFieldNames().get(groupCount + i));
            List.of(),
     */  
            null,
        return ctx;
                              OpenSearchProject(status=[$0], dc=[$1], __reduce_eval_1=[reduce_eval('approx_distinct', $1)], viableBackends=[[mock-parquet]])
        // Inner agg: count() by (status, size)  
    }
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));
     * Non-literal offset (parameterized expression): rewriter bails to no-pushdown rather than
    public void testDetection_noGroupBy_skipped() {
                      OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
        RelNode scan = stubScan(table);
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));
                        OpenSearchAggregate(group=[{0, 1}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
    }  
        );  
            result
    public void testRewrite_pplShape_sortByGroupKey_remapsCorrectly() {  
            List.of(rexBuilder.makeInputRef(agg, 0), rexBuilder.makeInputRef(agg, 1)),
        RelNode scan = stubScan(table);  
    }
        RelNode innerSort = LogicalSort.create(
            null,  
            proj1,  
    }
            null,
    /** Factor=0 → no per-partition Sort inserted. */
    public void testDetection_multipleProjects_topKStillFires() {
     */
    /** Computed expression (literal) in Project between Sort and Aggregate — rewriter bails. */  
        RelOptTable table = mockTable("test_index", "status", "size");
        // Pre-fix bug: shard Sort sized off bare fetch (30) — coordinator's skip-1000 would have emptied the result.
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        RelOptTable table = mockTable("test_index", "status", "size");
    // ── Helpers ──────────────────────────────────────────────────────────────
     * RBO so TopK normally fires. If for any reason two projects survive (PROJECT_MERGE removed or
     * factor=1.0 with offset: oversampling collapses to {@code 2 * coordLimit}. For  
            null,
        LogicalAggregate outerAgg = LogicalAggregate.create(
        RelNode scan = stubScan(table);
            List.of(rexBuilder.makeInputRef(proj1, 0), rexBuilder.makeInputRef(proj1, 1)),
        );  
    public void testRewrite_pplShape_sumWithSwap_sortKeyRemapped() {
        RelNode inner = buildSortHeadOverGroupedCount(); // Sort(collation $1 DESC, fetch 10) over grouped count
            result
                """,
    public void testDetection_chainedStats_topKBails() {
     * negative or wrong fetch literal.
            ImmutableBitSet.of(0),
        // Outer agg: sum(count) by status — groups over the inner agg result  
     * <p>PPL always puts measures first in output. This builder reorders the Aggregate's
            swapExprs.add(rexBuilder.makeInputRef(agg, i));
 * SPDX-License-Identifier: Apache-2.0
            if (line.contains("ExchangeReducer")) {
            contextWithOversampling(2.0)  
        RelNode result = runPlanner(buildPplSwapPlan(ImmutableBitSet.of(0), List.of(countStarCall()), 10), contextWithOversampling(2.0));
     * Two coordinator Sorts (fetch=10000 + fetch=10) survive because this planner does not  
        String plan = RelOptUtil.toString(result);
        RelNode outer = LogicalSort.create(  
    public void testRewrite_multiGroupByCount_splitAndTopK() {
    private RelNode buildSortHeadOverGroupedCount() {  
    }
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));
            rexBuilder.makeLiteral(10000, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            RelCollations.of(new RelFieldCollation(2, RelFieldCollation.Direction.DESCENDING)),
    }
            null,
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),
            swapProject,  
            null,  
            """  
        RelNode result = runPlanner(buildPplSwapPlan(ImmutableBitSet.of(0), List.of(countStarCall()), 1000), contextWithOversampling(2.0));
                OpenSearchSort(sort0=[$0], dir0=[DESC], fetch=[10000], viableBackends=[[mock-parquet]])
        RelOptTable table = mockTable("test_index", "status", "size");
    /**  
            swapNames.add(agg.getRowType().getFieldNames().get(i));
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));
     * coordinator skips 1000 then takes 10, so its merged stream must contain the global top-1010
        assertTrue("a per-partition Sort must be inserted", sortCount >= 2);  
        assertTrue("shard fetch must be 330, plan:\n" + plan, plan.contains("fetch=[330]"));  
    /** Two Sorts in plan: only the bottommost (with collation above FINAL) triggers TopK. */  
     */
        }
        RelNode scan = stubScan(table);
        );  
        // Sort on $0 which is the literal — cannot be remapped
        assertTrue("shard sort must use $1", planHasShardSortOn(plan, "$1"));
        RelNode result = runPlanner(
     * SystemLimit($0 DESC, 10000) → Sort($0 DESC, fetch) → Project(measures..., keys...) → Agg  
     * could carry window functions or other expressions that make TopK incorrect.
            List.of("cnt", "status")
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        RelNode scan = stubScan(table);
                    OpenSearchProject(cnt=[$1], status=[$0], viableBackends=[[mock-parquet]])  
                      OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
        );  
        long sortCount = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();
    public void testRewrite_pplShape_q13_sortKeyRemappedThroughProject() {  
     * The per-partition shard Sort fetch must derive from 10 (→ ceil(10*2)+10 = 30), not from the  
        RelNode sort = LogicalSort.create(  
                    false,
    private RelNode buildPplSwapPlan(ImmutableBitSet groupSet, List<AggregateCall> aggCalls, int fetch) {  
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),  
    public void testRewrite_pplShape_ascDirection_preserved() {
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)  
        RexNode lit10 = rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true);
                            OpenSearchAggregate(group=[{0, 1}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
            RelCollations.EMPTY,
    }  
            rexBuilder.makeLiteral(5, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
     * blocked), the rewriter now safely bails — accepting the second project is unsafe since it  
                belowER = true;  
     * q11: {@code stats dc(UserID) as u by MobilePhoneModel | sort - u | head 10}.
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
 */  
        return false;
        for (int i = 0; i < measureCount; i++) {
                continue;
        assertEquals("chained stats — TopK must not insert a shard Sort", 0, countShardSortsBelowER(plan));  
    /**
        RelNode outerLimit = LogicalSort.create(  
                    List.of(),  
    public void testRewrite_pplShape_q15_multiGroup_sortKeyRemappedThroughProject() {
            if (line.contains("ExchangeReducer")) {  
        String plan = RelOptUtil.toString(result);
            RelCollations.EMPTY,  
                          OpenSearchProject(status=[$0], dc=[$1], viableBackends=[[mock-parquet]])  
            agg,
     * in practice, so this is a defensive check.
            """  
        );
        RelNode scan = stubScan(table);
        RelOptTable table = mockTable("test_index", "status", "size");  
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.DESCENDING)),
        String plan = RelOptUtil.toString(result);
            buildPplSwapPlan(ImmutableBitSet.of(0), List.of(approxCountDistinctCall(scan)), 10),
            """
        // First Project: identity (no swap)  
        RelOptTable table = mockTable("test_index", "status", "size");  
                        OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            proj,
/*  
                        OpenSearchSort(sort0=[$2], dir0=[DESC], fetch=[30], viableBackends=[[mock-parquet]])
            null,  
    public void testRewrite_dcByGroup_splitAndTopK() {
            rexBuilder.makeLiteral(5, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        long sortCount = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();  
                    false,
        String plan = RelOptUtil.toString(result);  
                    SqlStdOperatorTable.SUM,
        LogicalAggregate agg = LogicalAggregate.create(
import org.apache.calcite.rel.RelCollations;  
                    null,  
    // ── Detection: AVG does NOT get TopK (reduce decomposition inserts computed Project) ──  
     */  
        );  
import org.apache.calcite.plan.RelOptUtil;
            scan,
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));  
                            OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
                """,  
        RelOptTable table = mockTable("test_index", "status", "size");
    }
    private static boolean planHasShardSortOn(String plan, String expectedField) {
        RelNode sort = LogicalSort.create(
        return LogicalSort.create(
    /**  
    }
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            )
        assertFalse("shard Sort must NOT be sized off the 10000 system cap (30000)", plan.contains("fetch=[30000]"));  
    }
            null,  
        assertTrue("shard sort must use $1 ASC", planHasShardSortOn(plan, "$1") && plan.contains("dir0=[ASC]"));
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.DESCENDING)),
import org.apache.calcite.plan.RelOptTable;
    public void testRewrite_sortWithOffset_shardFetchHonorsOffset() {  
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
    }
        long sortCount = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();
        RelNode scan = stubScan(table);  
        }
        RelNode scan = stubScan(table);
                    "total"  
                    OpenSearchProject(cnt=[$1], status=[$0], viableBackends=[[mock-parquet]])  
     */
                  OpenSearchSort(sort0=[$0], dir0=[DESC], fetch=[10], viableBackends=[[mock-parquet]])  
        RelNode scan = stubScan(table);  
import org.apache.calcite.sql.type.SqlTypeName;  
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));  
            """
                    typeFactory.createSqlType(SqlTypeName.INTEGER),
                    false,
                  OpenSearchAggregate(group=[{0}], dc=[APPROX_COUNT_DISTINCT($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.DESCENDING)),
            List.of(),  
        RelNode sort = LogicalSort.create(
                """,
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
     */
                              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            )
        // Second Project: also identity
        RelNode outerLimit = LogicalSort.create(
                        OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));  
        assertEquals("Computed expression in Project — TopK must bail", 0, countShardSortsBelowER(plan));
    }
        RexNode nonLiteralOffset = rexBuilder.makeCall(SqlStdOperatorTable.PLUS, lit5, lit10);  
        RelNode result = runPlanner(buildBareLimitOverGroupedCount(), contextWithOversampling(2.0));
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),
        for (String line : lines) {
                OpenSearchSort(sort0=[$0], dir0=[DESC], fetch=[10000], viableBackends=[[mock-parquet]])
        assertTrue("factor=1 → shard fetch = 2 * (offset+fetch) = 2020, got plan:\n" + plan, plan.contains("fetch=[2020]"));
            List.of(),  
            List.of(rexBuilder.makeInputRef(agg, 1), rexBuilder.makeInputRef(agg, 0)),  
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),
        String plan = RelOptUtil.toString(result);
        RelNode scan = stubScan(table);
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));  
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));  
        );  
                AggregateCall.create(
        return LogicalSort.create(
    public void testDetection_factorZero_skipped() {
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        RelNode sort = LogicalSort.create(  
        );
        assertPlanShape(
            }
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));  
import org.apache.calcite.rel.logical.LogicalProject;
    public void testRewrite_pplShape_q11_dcWithSwap_sortKeyRemapped() {
        );
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            rexBuilder.makeLiteral(10000, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
     * post-project schema. Remapping should produce shard sort on $0 (the group key at  
                  OpenSearchSort(sort0=[$1], dir0=[DESC], fetch=[10], viableBackends=[[mock-parquet]])
            null,
        RelNode result = runPlanner(buildPplSwapPlan(ImmutableBitSet.of(0), List.of(sumCall(scan)), 10), contextWithOversampling(2.0));
        // Shard Sort fetch = offset + ceil(fetch * factor) + fetch = 0 + ceil(10*2) + 10 = 30.
            }  
import org.apache.calcite.rel.core.AggregateCall;  
        // Sort on $1 (which is status/group-key in the swapped schema)
            nonLiteralOffset,
        RelNode scan = stubScan(table);
    /** SUM aggregate: partial SUM is directly sortable, no reduce_eval needed. */  
        RelOptTable table = mockTable("test_index", "status", "size");
     * fetch, not the outer cap. PPL {@code ... | sort - c | head 10} arrives as
            List.of(),
    public void testRewrite_pplShape_factor1_5_shardFetchCorrect() {  
            List.of("status", "cnt")  
            innerSort,
                    List.of(1),
        PlannerContext ctx = buildContext("parquet", 2, intFields());
     */  
                )
        assertPlanShape(
                    "s"  
 * The OpenSearch Contributors require contributions made to  
     * TopK on the inner agg would truncate (X, Y) groups before the outer sum sees all of them,
    /**
                OpenSearchSort(sort0=[$1], dir0=[DESC], fetch=[10], viableBackends=[[mock-parquet]])  
            agg,
    /** Factor=1.5 with swap: verifies arithmetic (ceil(10*1.5)+10 = 25). */
    public void testRewrite_countByGroup_sortInserted() {
            agg,
    public void testRewrite_pplShape_swapWithOffset_shardFetchHonorsOffset() {
        String plan = RelOptUtil.toString(result);
        assertTrue("TopK should fire with multiple plain-column projects", sortCount >= 2);  
    }
import org.opensearch.analytics.settings.PlannerSettings;  
        // PPL swap: (cnt=$1, status=$0)
import org.apache.calcite.rel.RelFieldCollation;
        );
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            if (belowER && line.contains("OpenSearchSort")) {  
                """,
        String plan = RelOptUtil.toString(result);  
            agg,
                    -1,
            outerAgg,
                                OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),
        assertEquals("AVG decomposition prevents TopK — no shard Sort", 0, countShardSortsBelowER(plan));  
                belowER = true;
    /**
    /** Swap with offset: shard fetch must honor offset. */
        RelOptTable table = mockTable("test_index", "status", "size");
     * Multiple adjacent Projects between Sort and Aggregate: PROJECT_MERGE collapses them during
        RelNode result = runPlanner(outerLimit, contextWithOversampling(2.0));  
    }
                              OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
            rexBuilder.makeLiteral(10000, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        RelOptTable table = mockTable("test_index", "status", "size");  
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.DESCENDING)),
     * Single group-by, single COUNT, sort on measure. Shard sort must use $1.
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),  
        // Sort on total DESC, head 5
        RelNode scan = stubScan(table);
                        OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
            List.of("cnt", "status")
     * The outer aggregate's PARTIAL input subtree contains another aggregate, so TopK must bail.
                  OpenSearchAggregate(group=[{0, 1}], cnt=[SUM($2)], mode=[FINAL], viableBackends=[[mock-parquet]])
    /**  
        RelOptTable table = mockTable("test_index", "status", "size");
                      OpenSearchProject(status=[$0], dc=[$1], viableBackends=[[mock-parquet]])  
     * {@code head 10 from 1000}: PPL emits {@code Sort(collation, offset=1000, fetch=10)}. The  
            agg,
     * factor=1 just removes the per-coord-row padding multiplier.
    // ── PPL column-swap tests: Sort key remapped through intermediate Project ──
        RelNode proj = LogicalProject.create(
            null,  
        );
        );
        RelNode innerSort = LogicalSort.create(  
                    RelCollations.EMPTY,
        assertEquals("expected 2 Sorts (coord + per-partition)", 2, sortCount);
            null,  
        );  
        );
     * q15: {@code stats count() as c by X, Y | sort - c | head 10}.
        );
        // Even without PROJECT_MERGE, the rewriter passes through multiple plain-column projects
        String plan = RelOptUtil.toString(result);  
        // Build swap project: measures first, then keys
            rexBuilder.makeLiteral(10000, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        );
        ctx.setPlannerSettings(PlannerSettings.of(factor, DelegationBlockList.empty()));  
        RelNode outerLimit = LogicalSort.create(  
        assertTrue("at least 2 OpenSearchSort nodes expected", sortCount >= 2);
                            OpenSearchAggregate(group=[{0}], dc=[APPROX_COUNT_DISTINCT($1)], mode=[PARTIAL], viableBackends=[[mock-parquet]])  
     * dc() with column swap — combines reduce_eval logic with the Project remapping.
        long sortCount = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();  
            contextWithOversampling(2.0)
                    OpenSearchProject(cnt=[$2], status=[$0], size=[$1], viableBackends=[[mock-parquet]])
                OpenSearchSort(sort0=[$1], dir0=[DESC], fetch=[10000], viableBackends=[[mock-parquet]])
        RelNode scan = stubScan(table);  
        String plan = RelOptUtil.toString(result);
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.DESCENDING)),  
        assertEquals("overflow → no per-partition Sort inserted", 1, sortCount);
 * this file be licensed under the Apache-2.0 license or a
                """,
    }
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countDistinctCall(scan)));
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),  
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));
                    List.of(2),
            List.of(rexBuilder.makeInputRef(agg, 1), rexBuilder.makeInputRef(agg, 0)),  
        RelNode sort = LogicalSort.create(  
        RelNode sort = LogicalSort.create(
                    List.of(),  
        long sortCount = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();
    public void testRewrite_pplShape_multiGroupDcWithSwap_sortKeyRemapped() {
        }  
        for (int i = 0; i < groupCount; i++) {  
        RelNode scan = stubScan(table);  
        String plan = RelOptUtil.toString(result);
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));
        );  
            agg,  
                    RelCollations.EMPTY,
                      OpenSearchSort(sort0=[$2], dir0=[DESC], fetch=[30], viableBackends=[[mock-parquet]])  
            List.of(rexBuilder.makeInputRef(agg, 1), rexBuilder.makeInputRef(agg, 0)),  
        RelNode innerSort = LogicalSort.create(
     * {@code SystemLimit(fetch=10000, sort0=$1 DESC) → Sort(fetch=10, sort0=$1 DESC) → ... → FINAL}.
                              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
            innerPlan,
import java.util.List;  
    /** Basic: Sort(collation, fetch) above grouped COUNT → per-partition Sort inserted. */  
                  OpenSearchSort(sort0=[$0], dir0=[DESC], fetch=[10], viableBackends=[[mock-parquet]])
    /**
        List<String> swapNames = new ArrayList<>();
            rexBuilder.makeLiteral(100, typeFactory.createSqlType(SqlTypeName.INTEGER), true),  
            innerSort,
     * This test verifies the safe-bail behavior when two projects reach the rewriter.
            List.of(),
            swapExprs.add(rexBuilder.makeInputRef(agg, groupCount + i));  
        String plan = RelOptUtil.toString(result);
        // PROJECT_MERGE collapses the two adjacent identity projects, so TopK fires.  
                    OpenSearchProject(dc=[$1], status=[$0], viableBackends=[[mock-parquet]])  
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        );
        assertTrue("shard sort must use $1", planHasShardSortOn(plan, "$1"));
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
        boolean belowER = false;  
        );  
                    false,
            "shard Sort must be sized as ceil((offset+fetch)*factor) + (offset+fetch) = 3030, got plan:\n" + plan,
        LogicalAggregate innerAgg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0, 1), null, List.of(countStarCall()));
        );
        long sortCount = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();
            buildPplSwapPlan(ImmutableBitSet.of(0, 1), List.of(approxCountDistinctCall(scan)), 10),  
            List.of(  
        RelOptTable table = mockTable("test_index", "status", "size");
     */
        assertFalse("shard Sort must NOT be sized off fetch alone (30)", plan.contains("fetch=[30]"));
 * Plan shape tests for the TopK rewriter. Grouped into Detection (skip cases)  
        );
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),
        RelNode innerSort = LogicalSort.create(  
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),  
        );  
        RelNode result = runPlanner(outerLimit, contextWithOversampling(2.0));
        // Project with a literal expression (not a column reference)  
        String plan = RelOptUtil.toString(result);
            """
    public void testRewrite_factorOne_twiceCoordLimit() {
        RelNode sort = LogicalSort.create(
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
    }
 * compatible open source license.
        RelOptTable table = mockTable("test_index", "status", "size");
            """  
        );
        );
        );  
        RelNode result = runPlanner(outer, contextWithOversampling(2.0));  
        RelNode result = runPlanner(
            scan,
        );
            null,  
        assertEquals("expected 1 Sort (coord only)", 1, sortCount);  
    public void testRewrite_sumByGroup_sortInserted() {
        );
        String plan = RelOptUtil.toString(result);  
            null,  
            List.of(),  
        RelOptTable table = mockTable("test_index", "status", "size");
                          OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                    -1,
     * bail (no per-partition Sort inserted). Without the bail an int overflow would produce a  
        // coordLimit = 100+10 = 110, shardSize = ceil(110*2)+110 = 330
    }
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.DESCENDING)),
     * output (keys first, measures second) into (measures first, keys second) via a Project,  
            rexBuilder.makeLiteral(10000, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            null,  
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        RelOptTable table = mockTable("test_index", "status", "size");  
        RelNode sort = LogicalSort.create(
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));  
            result  
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),  
            null,
    }
        );  
     * — i.e. {@code coordLimit = offset + fetch}. Shard fetch is then the usual oversampling
            plan.contains("fetch=[3030]")
        assertPlanShape(
    /**
import org.apache.calcite.util.ImmutableBitSet;
                          OpenSearchSort(sort0=[$1], dir0=[DESC], fetch=[30], viableBackends=[[mock-parquet]])  
        return count;
        );
        RelNode swapProject = LogicalProject.create(  
            rexBuilder.makeLiteral(1000, typeFactory.createSqlType(SqlTypeName.INTEGER), true),
        RelNode swapProject = LogicalProject.create(agg, List.of(), swapExprs, swapNames);
        RelNode scan = stubScan(table);
    private PlannerContext contextWithOversampling(double factor) {
    }  
        RelOptTable table = mockTable("test_index", "status", "size");  
        RelNode proj1 = LogicalProject.create(
                    false,  
            result  
            agg,  
                  OpenSearchSort(sort0=[$0], dir0=[DESC], fetch=[10], viableBackends=[[mock-parquet]])
                            OpenSearchSort(sort0=[$2], dir0=[DESC], fetch=[30], viableBackends=[[mock-parquet]])
    }
    /** Multi-group dc() with swap: shard sort must use $3 (reduce_eval appended column). */
                                OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
        // itself is redundant over a 1-row scalar agg and SORT_REMOVE_REDUNDANT drops it, so the  
            agg,
            null,  
    /**
            swapProject,
                      OpenSearchAggregate(group=[{0, 1}], cnt=[SUM($2)], mode=[FINAL], viableBackends=[[mock-parquet]])
        );
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0, 1), null, List.of(countStarCall(scan)));
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)  
    }
            List.of("const", "status")
            agg,
        );
     * guessing a value. Each shard ships everything; correct but slow. PPL emits literal offsets  
    /**
        );  
        String plan = RelOptUtil.toString(result);
                            OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
            swapProject,  
        RelOptTable table = mockTable("test_index", "status", "size");
    }
    /** ASC sort direction with swap: direction must be preserved in shard sort. */
            null,
    // ── Detection: chained stats (nested aggregation) must NOT get TopK ─────────  
    }  
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));  
        RelOptTable table = mockTable("test_index", "status", "size");
import org.apache.calcite.rel.RelNode;
    public void testDetection_noAggregate_skipped() {
            agg,
     * <p>Expected shard fetch: {@code ceil(1010*2) + 1010 = 3030}. Without offset handling the
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)  
    public void testDetection_bareLimitNoCollation_skipped() {  
     */  
            proj2,
     * 10000 system cap (which would over-fetch 30000 rows/shard).
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), groupSet, null, aggCalls);  
            swapProject,
            null,
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));  
    /** SUM with swap Project: shard sort must use $1 (the SUM measure). */
        // Bare LIMIT: empty collation, just fetch
    /** Sort without collation (bare LIMIT) → skip. */
        // Sort on $0 (first measure in swapped output)
            innerAgg,
            if (belowER && line.contains("OpenSearchSort")) {
            agg,
        RelNode result = runPlanner(outerLimit, contextWithOversampling(2.0));
        // count is 0; the point is that no extra (per-partition) Sort was inserted.
                        OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
import org.apache.calcite.rel.logical.LogicalSort;  
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));
        assertFalse("no aggregate → TopK must not fire", plan.contains("OpenSearchAggregate"));  
     * producing catastrophically wrong totals.  
    // ── PPL swap plan builder ───────────────────────────────────────────────────
        RelNode scan = stubScan(table);
    /** No aggregate in plan → TopK must not fire (sort-pushdown may add a shard Sort, which is fine). */  
        RelNode scan = stubScan(table);  
        RelOptTable table = mockTable("test_index", "status", "size");
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
        RelNode sort = LogicalSort.create(
    /** dc(x) by group + sort + head: APPROX_COUNT_DISTINCT splits with TopK reduce_eval. */
                    null,  
            result
    }  
}
        );
        );
    }
        String plan = RelOptUtil.toString(result);
        boolean belowER = false;  
                    SqlStdOperatorTable.SUM,
 *
     * {@code head 10 from 1000} → 2*1010 = 2020. coordLimit = offset+fetch is still honored;
        // 2 = coord collated sort + per-partition sort (outer limit may merge or stay as 3rd)
                                  OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    public void testRewrite_collatedOuterLimit_honorsInnerFetch() {  
        assertTrue("multi-group dc shard sort must use $3 (reduce_eval column), plan:\n" + plan, planHasShardSortOn(plan, "$3"));
        RelOptTable table = mockTable("test_index", "status", "size");  
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));
            agg,
        RelNode result = runPlanner(buildPplSwapPlan(ImmutableBitSet.of(0), List.of(countStarCall()), 10), contextWithOversampling(1.5));
        assertTrue("shard fetch must be 3000, plan:\n" + plan, plan.contains("fetch=[3000]"));
            }
        RelNode scan = stubScan(table);
            List.of(),
                          OpenSearchSort(sort0=[$2], dir0=[DESC], fetch=[30], viableBackends=[[mock-parquet]])
        RelNode swapProject = LogicalProject.create(  
    /** Multi-group-by COUNT + TopK: verifies PARTIAL/FINAL split fires. */
        );  
        RelNode sort = LogicalSort.create(
        RelNode scan = stubScan(table);  
                OpenSearchSort(sort0=[$2], dir0=[DESC], fetch=[10], viableBackends=[[mock-parquet]])  
import java.util.ArrayList;
public class TopKRewriterPlanShapeTests extends PlanShapeTestBase {  
                    false,  
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));
    }  
        RelNode swapProject = LogicalProject.create(  
        // Outer system size-limit with the SAME collation and a large cap (what QueryService wraps).
        );
    public void testDetection_computedProjectExpression_topKBails() {
            null,
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(avgCall(scan)));  
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),  
            rexBuilder.makeLiteral(1000, typeFactory.createSqlType(SqlTypeName.INTEGER), true),
 * and Rewrite (insertion cases).
            plan.contains("ExchangeReducer") && plan.indexOf("ExchangeReducer") < plan.lastIndexOf("OpenSearchSort")
    /** Aggregate without group-by (scalar agg) → skip. */  
        );
     * Builds the PPL-style plan shape with a column-swapping Project:
        String plan = RelOptUtil.toString(result);  
        assertTrue("shard fetch must be 25, plan:\n" + plan, plan.contains("fetch=[25]"));  
        );  
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)),
        }  
    }
     * coordinator skipped 1000, and the result was empty.
        RelNode result = runPlanner(buildSortHeadOverGroupedCount(), contextWithOversampling(0.0));  
    }
        String plan = RelOptUtil.toString(result);
     * partial agg level). Ensures the fix doesn't break sort-by-key queries.
    }
    /**
                )
     */
            "per-partition Sort must be below ER",
        RelNode sort = LogicalSort.create(  
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.DESCENDING)),
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
import org.opensearch.analytics.settings.DelegationBlockList;
    public void testRewrite_offsetOverflow_bails() {  
        RelNode proj2 = LogicalProject.create(
        );  
        RelNode result = runPlanner(sort, contextWithOversampling(2.0));
        // TopK must not add a per-partition Sort for a scalar aggregate. The coordinator Sort
            List.of("status", "cnt")
                count++;
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(), null, List.of(countStarCall()));
        return LogicalSort.create(  
                          OpenSearchSort(sort0=[$0], dir0=[DESC], fetch=[30], viableBackends=[[mock-parquet]])  
        int groupCount = groupSet.cardinality();
     *
            inner,
     * Multi-group-by, single COUNT, sort on measure. Shard sort must use $2.
        assertTrue("no per-partition Sort for scalar aggregate", sortCount <= 1);
package org.opensearch.analytics.planner;
        RelOptTable table = mockTable("test_index", "status", "size");
            List.of(rexBuilder.makeLiteral(42, typeFactory.createSqlType(SqlTypeName.INTEGER), true), rexBuilder.makeInputRef(agg, 0)),
        assertEquals("non-literal offset → no per-partition Sort inserted", 1, sortCount);
        assertTrue(  
        String plan = RelOptUtil.toString(result);
    public void testRewrite_nonLiteralOffset_bails() {  
     * Sort by group key (not measure) with swap Project: the swap puts the key at $1 in
     * Offset close to {@code Integer.MAX_VALUE} pushes shardSize past int range — rewriter must
    // ── Rewrite: per-partition Sort IS inserted ──────────────────────────────
 */
            agg,
        long sortCount = plan.lines().filter(l -> l.contains("OpenSearchSort")).count();  
        String plan = RelOptUtil.toString(result);
     * q13: {@code stats count() as c by SearchPhrase | sort - c | head 10}.
        LogicalAggregate agg = LogicalAggregate.create(scan, List.of(), ImmutableBitSet.of(0), null, List.of(countStarCall()));
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)  
        int measureCount = aggCalls.size();  
        RelNode innerPlan = buildSortHeadOverGroupedCount();  
    private RelNode buildBareLimitOverGroupedCount() {  
        RexNode lit5 = rexBuilder.makeLiteral(5, typeFactory.createSqlType(SqlTypeName.INTEGER), true);
        List<RexNode> swapExprs = new ArrayList<>();  
    }  
     * register SORT_REMOVE_REDUNDANT. DF collapses them in the physical plan.
    }
    private static long countShardSortsBelowER(String plan) {
        RelNode result = runPlanner(sort, contextWithOversampling(1.0));
        RelNode sort = LogicalSort.create(
        RelNode result = runPlanner(sort, contextWithOversampling(1.5));
                                OpenSearchAggregate(group=[{0}], dc=[APPROX_COUNT_DISTINCT($1)], mode=[PARTIAL], viableBackends=[[mock-parquet]])  
            agg,
        String[] lines = plan.split("\n");
        RelNode result = runPlanner(
        assertPlanShape(  
        assertPlanShape(
        assertTrue(  
    }
        RelNode scan = stubScan(table);
            agg,  
