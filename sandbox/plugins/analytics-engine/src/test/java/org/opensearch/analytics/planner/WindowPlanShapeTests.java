                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
     */
        AggregateCallOnWindowedProject sizeAgg = aggCallOver(windowedProject, /* size */ 1, "total_size");
        RelOptTable right = mockTable("right_idx", "status", "size");
            RexWindowBounds.CURRENT_ROW,
            RexWindowBounds.UNBOUNDED_FOLLOWING
 * compatible open source license.
        );
    public void testSumOverRunningFrame_2shard() {
            SqlStdOperatorTable.EQUALS,
            """, result);
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
    /**
    }
        assertPlanShape(
            input,
            List.of(rb.makeInputRef(union, 1)),
        RelNode plan = makeAggregate(filter, countStarCall(filter), sizeAgg.aggCall);
        RelNode result = runPlanner(plan, multiShardContext());
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            scan,
            ImmutableList.of(),
        );
 * {@link LogicalProject} (the shape PPL {@code eventstats} / {@code appendcol} emit).  
            SqlTypeName.BIGINT,
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RelNode project = LogicalProject.create(
                OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], mode=[SINGLE], viableBackends=[[mock-parquet]])
            OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-parquet], =($2, 100))], viableBackends=[[mock-parquet]])
        );
            """
        RelOptTable table = mockTable("test_index", "status", "size");  
                """,  
import org.apache.calcite.rel.core.CorrelationId;  
                StubTableScan(table=[[test_index]])
        RexNode over = makeOver(  
     * Window after a shard-side Filter (multi-shard). Filter is single-input passthrough,  
                      OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], mode=[PARTIAL], viableBackends=[[mock-parquet]])
            result
        RelNode result = runPlanner(plan, multiShardContext());
        RelNode scan = stubScan(table);  
        RelNode plan = projectWithCountOverEmpty();  
                """,
        RelNode plan = LogicalProject.create(
                """,  
            ImmutableList.of(new RexFieldCollation(rb.makeInputRef(scan, 1), Set.of())),  // ORDER BY size
        RelNode result = runPlanner(plan, multiShardContext());
        );
    }
            List.of(rb.makeInputRef(filter, 1)),
        assertPlanShape(
     * recognized by {@code WindowFunction.resolveFunction} and advertised by the DataFusion backend.
        RelNode scan = stubScan(table);
        );
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            List.of(rb.makeInputRef(scan, 1)),  
        );
 * Plan-shape tests for window functions, expressed as {@code RexOver} inside a
     * w = sum(..) over () | stats ...}). The split rule must treat each aggregate independently:
        return LogicalJoin.create(stubScan(left), stubScan(right), List.of(), cond, java.util.Set.<CorrelationId>of(), JoinRelType.INNER);  
        RelNode plan = LogicalProject.create(
    }  
    private PlannerContext unionContext(String indexName, int shardCount) {
            """
            SqlStdOperatorTable.SUM,
import org.apache.calcite.rex.RexWindowBound;
     * PARTIAL + ER + FINAL. FINAL emits {@code COORDINATOR+SINGLETON}, which the windowed
import org.apache.calcite.rel.RelFieldCollation;
        RexNode over = makeOver(
        RelNode plan = projectWithCountOverEmpty();
     * Non-default frame: SUM(x) OVER (ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) —
     * CURRENT ROW)} as a helper sequence column. ROW_NUMBER joined the WindowFunction enum in
        // gather (childGatheredByWindow) and keeps the aggregate SINGLE — no redundant PARTIAL/FINAL
        RelNode windowedProject = projectWithSumOverEmpty();  
    }
                LogicalAggregate(group=[{0}], total_size=[SUM($1)])
    /** Same as {@link #projectWithSumOverEmpty()} but stacked on a caller-supplied input
     * Build a LogicalProject that passes through every scan column and adds one RexOver
                StubTableScan(table=[[test_index]])
        RelNode scan = stubScan(table);
        RexBuilder rb = filter.getCluster().getRexBuilder();  
                  OpenSearchSort(sort0=[$0], dir0=[ASC], viableBackends=[[mock-parquet]])  
        return aggCallOver(input, sumFieldIndex, alias, SqlTypeName.INTEGER);  
            rb,  
            LogicalSort(sort0=[$0], dir0=[ASC])  
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        RelOptTable table = mockTable("test_index", "status", "size");  
              LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
            scan,  
        // the aggregate's input is already on one node. The split rule detects the window-induced  
    private static final class UnionCapableBackend extends MockDataFusionBackend {
     * aggregate stays SINGLE.
            List.of(rb.makeInputRef(agg, 0), rb.makeInputRef(agg, 1), over),
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            filter,  
    /** Different-tables equi-join — used by {@link #testWindowAfterJoin_2shard} so the  
            SqlTypeName.BIGINT,  
                    OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
            fn,  
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
     * so no ER is inserted. The whole pipeline runs on the single shard's node.  
        assertPlanShape("""
            false,
            List.of(),  
     * already SINGLETON, so we get one ER for the whole pipeline instead of a redundant
     * keys are encoded inside the RexOver expression and don't affect the surrounding
     */
    public void testRowNumberOverEmpty_2shard() {
        RelNode plan = LogicalProject.create(
     * sequence pinned by an ORDER BY. The existing tests cover ROW_NUMBER OVER () alone and
        LogicalAggregate agg = makeAggregate(stubScan(mockTable("test_index", "status", "size")), sumCall());  
     */
        RexNode runningSum = makeOver(  
            join,
              LogicalAggregate(group=[{0}], total_size=[SUM($1)])
        RelNode lowerAgg = makeAggregate(stubScan(mockTable("test_index", "status", "size")), countStarCall());
            false,  
    public void testWindowAfterUnion_2shard() {
            RexWindowBounds.UNBOUNDED_PRECEDING,
        RelNode plan = makeAggregate(windowed, countStarCall(windowed), cntAgg.aggCall, sAgg.aggCall);  
        );
        RexNode over = makeOver(
        RelNode scan = stubScan(table);
     * shape here keeps both changes regression-safe.  
        // Upper aggregate stays SINGLE (its input is gathered by the window); lower aggregate splits
 */  
        assertPlanShape(
    public void testCountOverEmpty_2shard() {  
     * stays at SHARD; the RexOver Project's cost gate forces COORDINATOR input, so an ER
    ) {  
     * a running aggregate. The frame bounds change the OVER() rendering but not the plan  
        );
                    OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200))], viableBackends=[[mock-parquet]])  
        RelNode plan = LogicalProject.create(
        RelOptTable table = mockTable("test_index", "status", "size");  
        RelNode result = runPlanner(plan, multiShardContext());
    /**
    }
    /**
    public void testAggregateWindowAggregate_2shard_onlyLowerSplits() {  
            SqlStdOperatorTable.COUNT,  
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RexNode checkedSumOver = makeOver(
        );  
            List.of("status", "size", "s")  
        );
                OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])  
    public void testWindowAfterJoin_1shard() {  
    /**
     */
        SqlTypeName outType,  
            true,
            true,  
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
import org.apache.calcite.rex.RexWindowBounds;
            false
     * matters for streamstats … by … reachability.
            false,
     * 1-shard: aggregate stays SINGLE (no split), Filter and Project layer above without ER.
     * gate forces an ER above the Join. Documented here so future planner work — making Join  
            """  
        RelOptTable table = mockTable("test_index", "status", "size");
     * resolve the subset (getBestOrOriginal) to still find the window below the Filter; otherwise the  
    public void testAggregateAfterWindowBehindFilter_2shard_staysSingle() {
import org.apache.calcite.rex.RexNode;  
            """
            List.of(),
            RexWindowBounds.UNBOUNDED_FOLLOWING
            SqlStdOperatorTable.SUM,  
            List.of(),
            OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], total_s=[SUM($2)], mode=[SINGLE], viableBackends=[[mock-parquet]])
        RelNode windowed = projectWithSumOverEmpty(lowerAgg);
        RelNode result = runPlanner(plan, singleShardContext());
                OpenSearchProject(status=[$0], size=[$1], rn_per_status=[ROW_NUMBER() OVER (PARTITION BY $0 ORDER BY $1)], viableBackends=[[mock-parquet]])  
            """  
        RelOptTable right = mockTable("test_index", "status", "size");  
            LogicalProject(status=[$0], total_size=[$1], grand_total=[SUM($1) OVER ()])  
                OpenSearchProject(status=[$0], total_size=[$1], grand_total=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
        assertPlanShape("""
        @Override
        RexBuilder rb = agg.getCluster().getRexBuilder();
            false,
    }  
    private record AggregateCallOnWindowedProject(org.apache.calcite.rel.core.AggregateCall aggCall) {
import java.util.Map;
    }
     */
              LogicalFilter(condition=[=($1, 100)])  
        RelNode scan = stubScan(table);
    public void testRowNumberOverPartitionByOrderBy_2shard() {  
        AggregateCallOnWindowedProject sizeAgg = aggCallOver(windowedProject, /* size */ 1, "total_size");  
            filter,
            operands,
        );
        RexNode sumOver = makeOver(  
        );
                """,
            RexWindowBounds.UNBOUNDED_PRECEDING,
    }
import org.apache.calcite.rel.logical.LogicalJoin;  
    }  
            RexWindowBounds.CURRENT_ROW,
        RexBuilder rb = scan.getCluster().getRexBuilder();
        RelNode plan = LogicalProject.create(  
        );
        assertPlanShape(
                """,
            false,  
        assertPlanShape(  
     * HAVING-like Filter above a windowed Project (2-shard). The Project's RexOver gate forces  
        );  
            SqlStdOperatorTable.SUM,  
import org.apache.calcite.sql.SqlAggFunction;  
            List.of("status", "size", "rn_per_status")
        RelNode result = runPlanner(plan, multiShardContext());
        RelOptTable left = mockTable("left_idx", "status", "size");  
     * {@code OpenSearchProjectRule.collectWindowFunctions} drops the partition-key check but
            join,
            null  
        assertPlanShape(
        );  
     * {@code getInput(0)} hop — which in Volcano is a RelSubset, not a concrete rel. The walk must
        RelNode plan = projectWithSumOverEmpty(
    }  
            LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])  
        AggregateCallOnWindowedProject sAgg = aggCallOver(windowed, /* window col */ 2, "total_s", SqlTypeName.BIGINT);
    /**
        RelNode join = makeDifferentTablesJoin();
    }  
            LogicalProject(status=[$0], size=[$1], cnt=[COUNT() OVER ()])
        );
            List.of(sumFieldIndex),  
            result
    private RelNode projectWithSumOverEmpty(RelNode input) {
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), over),
    }
     * GROUP BY + HAVING + window: {@code Project(SUM($1) OVER (), Filter(=$1,100, Aggregate))}.  
            SqlTypeName.BIGINT,
            scan,  
     *  so the Union marker rule accepts the Union shape. */
              LogicalFilter(condition=[=($1, 100)])  
        RelNode plan = LogicalProject.create(  
            """, plan);
        );
                OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-parquet], =($2, 100))], viableBackends=[[mock-parquet]])
     * Project's cost gate accepts without a second ER. Mirrors the PPL pattern
     * on the single shard's node.
                  OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
        RelOptTable table = mockTable("test_index", "status", "size");
/*  
        RelNode plan = LogicalProject.create(  
            SqlStdOperatorTable.SUM,
            operands,
    /**
            ImmutableList.of(),
    }  
    private AggregateCallOnWindowedProject aggCallOver(RelNode input, int sumFieldIndex, String alias) {
            RexWindowBounds.UNBOUNDED_FOLLOWING,
     * SUM OVER (PARTITION BY ORDER BY) alone — this one combines them and is the one that  
            List.of("status", "total_size", "grand_total")  
        );
     * window Project and the aggregate forces the {@code childGatheredByWindow} walk to take a
 * SPDX-License-Identifier: Apache-2.0
    public void testSumOverEmpty_afterFilter_2shard() {
     * (empty OVER clause) as the final projected expression.  
     */
import java.util.Set;
            """, plan);
            RexWindowBounds.UNBOUNDED_PRECEDING,
    }
        );
        assertPlanShape("""
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
    public void testHavingAfterWindow_1shard() {
                StubTableScan(table=[[test_index]])
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), checkedSumOver),
            result
            RexWindowBounds.UNBOUNDED_PRECEDING,  
        );
            LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
        assertPlanShape("""  
    public void testSumOverAfterAggregate_2shard() {
                    OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])  
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), sumOver),
                        OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], mode=[PARTIAL], viableBackends=[[mock-parquet]])
        RexNode over = makeOver(  
                StubTableScan(table=[[test_index]])  
        return LogicalJoin.create(stubScan(left), stubScan(right), List.of(), cond, java.util.Set.<CorrelationId>of(), JoinRelType.INNER);
            LogicalProject(status=[$0], total_size=[$1], grand_total=[SUM($1) OVER ()])
     * propagate SHARD+SINGLETON the same way Scan does — has a regression target.
     * does not duplicate the ER per RexOver.
        RelNode result = runPlanner(plan, multiShardContext());
    public void testCountOverEmpty_1shard() {
            RexWindowBounds.UNBOUNDED_PRECEDING,
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            true,  
            scan,
            result  
 * this file be licensed under the Apache-2.0 license or a
            """, result);
    }  
                """,
        assertPlanShape("""  
import java.util.List;  
            List.of(),
        RelNode plan = projectWithSumOverEmpty(makeSort(stubScan(mockTable("test_index", "status", "size")), -1));
            (SqlAggFunction) SqlStdOperatorTable.RANK,
        RelNode result = runPlanner(plan, singleShardContext());  
        RexNode sumOver = makeOver(  
            List.of(rb.makeInputRef(join, 0), rb.makeInputRef(join, 1), over),
            scan,
            null,
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    private RexNode makeOver(
            SqlTypeName.BIGINT,
            RexWindowBounds.UNBOUNDED_FOLLOWING  
            LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
                StubTableScan(table=[[test_index]])  
        RexBuilder rb = scan.getCluster().getRexBuilder();  
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            RexWindowBounds.UNBOUNDED_PRECEDING,  
     */
            SqlStdOperatorTable.SUM,  
            SqlTypeName.BIGINT,
        RelNode plan = LogicalProject.create(  
            LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
            RexWindowBounds.UNBOUNDED_PRECEDING,  
        RelNode scan = stubScan(table);  
                StubTableScan(table=[[test_index]])
        return new AggregateCallOnWindowedProject(call);  
                OpenSearchAggregate(group=[{0}], cnt=[COUNT()], total_cnt=[SUM($1)], total_s=[SUM($2)], mode=[SINGLE], viableBackends=[[mock-parquet]])
        RelNode plan = projectWithSumOverEmpty();
        RexBuilder rb = join.getCluster().getRexBuilder();  
            makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200))
     * sits between Filter and Project.
              StubTableScan(table=[[test_index]])
     * GROUP BY + HAVING + window (2-shard). Aggregate splits to PARTIAL+FINAL with one ER
            scan,
/**
        );  
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
     * {@code ROW_NUMBER() OVER (PARTITION BY $0 ORDER BY $1)} on a 2-shard scan. This is the  
        );
            List.of("status", "size", "rn")
     */
     * RexOver cost gate (type=SINGLETON) AND the root's locality-agnostic SINGLETON demand,
            List.of("status", "total_size", "grand_total")
    }  
            true,
     * the same way once SINGLETON-gathered.
            List.of(rb.makeInputRef(scan, 1)),
        RelNode result = runPlanner(plan, multiShardContext());
     * WindowFunction enum alongside DENSE_RANK; like ROW_NUMBER it needs no adapter and passes
            scan,
            """
            SqlStdOperatorTable.SUM,
            scan,
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            rb,
        AggregateCallOnWindowedProject sAgg = aggCallOver(windowedProject, /* window col */ 2, "total_s", SqlTypeName.BIGINT);
     *
            makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200))  
        assertPlanShape(
                """,  
                """,
    /**
        return LogicalProject.create(  
                        OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
            false
        assertPlanShape(
    }
        RelOptTable table = mockTable("test_index", "status", "size");
            RexWindowBounds.UNBOUNDED_PRECEDING,  
            result
import org.apache.calcite.rel.logical.LogicalUnion;  
        );
            checkedLongSumOperator(),
                LogicalAggregate(group=[{0}], total_size=[SUM($1)])
                """,
                """,
            List.of(rb.makeInputRef(scan, 1)),
        );
            List.of(),  
            false,
        RelNode rightScan = stubScan(mockTable("test_index", "status", "size"));  
            result
                StubTableScan(table=[[test_index]])
                  OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
            SqlStdOperatorTable.SUM,
                      OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
    public void testDenseRankOverPartitionByOrderBy_2shard() {  
        assertPlanShape("""
     * SINGLETON input on any RexOver-bearing project, so all rows in a partition arrive on the
            scan,
     * upward, satisfying the Project's RexOver cost gate without an ER. Pipeline stays  
              StubTableScan(table=[[test_index]])
                StubTableScan(table=[[test_index]])
            """
    /**
     * Two aggregates with a global window between them (PPL: {@code stats count() by k | eval  
            """, plan);  
            result
            List.of("status", "size", "running_s")
            filter,
        RelOptTable table = mockTable("test_index", "status", "size");
                """,
            List.of(rb.makeInputRef(scan, 1)),  
        RelNode filter = makeFilter(agg, makeEquals(1, SqlTypeName.INTEGER, 100));
     * COORDINATOR+SINGLETON, which satisfies the windowed Project's cost gate without an
        RelNode join = makeSelfJoin();
     * aggregate would split PARTIAL/FINAL redundantly over already-gathered rows. Asserts the
            """, plan);  
            List.of("status", "size", "s")
                OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], total_s=[SUM($2)], mode=[SINGLE], viableBackends=[[mock-parquet]])
    }  
        assertPlanShape(
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        );
        RelNode scan = stubScan(table);
                """,  
            SqlStdOperatorTable.EQUALS,  
     * HAVING-like Filter sits ABOVE a windowed Project (1-shard). The Project's cost gate is  
    private RelNode makeSelfJoin() {
            """  
     * leaves order-by passthrough; this case pins both axes simultaneously.  
        RelNode result = runPlanner(plan, unionContext("test_index", 2));  
            RexWindowBounds.UNBOUNDED_FOLLOWING
                  OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])  
        RexNode cond = rexBuilder.makeCall(
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RexWindowBound upperBound
        assertPlanShape(
    public void testAggregateAfterWindow_2shard() {
    }  
                OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
        assertPlanShape(  
        );
            """
              OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=1, backends=[mock-parquet], =($1, 100))], viableBackends=[[mock-parquet]])
     *  column (e.g. a window output) where the inferred type differs from the INTEGER default. */
 *
        RexBuilder rb = scan.getCluster().getRexBuilder();  
        );  
            result  
        RexNode rank = rb.makeOver(  
            """, result);
            ImmutableList.of(),
    }  
            rb,
        LogicalAggregate agg = makeAggregate(stubScan(mockTable("test_index", "status", "size")), sumCall());
        RelNode plan = LogicalSort.create(
            RexWindowBounds.CURRENT_ROW
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), countOver, sumOver),
     * Window above a Join (1-shard self-join). Co-location keeps Join on the shard with no
                StubTableScan(table=[[test_index]])
                """,  
            ImmutableList.of(),  
     * {@code RANK() OVER (PARTITION BY $0 ORDER BY $1)} on a 2-shard scan. RANK joined the  
        // Aggregate BOTH size ($1) and window col s ($2) so neither is dead — keeps the window live.
    }  
        RelNode plan = LogicalProject.create(
            rb,
        RelNode result = runPlanner(plan, multiShardContext());  
     */  
            rb,
                OpenSearchProject(status=[$0], total_size=[$1], grand_total=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
                OpenSearchProject(status=[$0], size=[$1], running_s=[SUM($1) OVER (ROWS UNBOUNDED PRECEDING)], viableBackends=[[mock-parquet]])
            LogicalAggregate(group=[{0}], total_size=[SUM($1)], total_s=[SUM($2)])
            true,
}
    }
     */  
        );
     * Window after a Filter on a 1-shard input. Filter propagates Scan's SHARD+SINGLETON
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            """, plan);  
     */  
    }
     * Sort placed after a windowed Project: {@code Sort(Project(scan, SUM($1) OVER ()))}.  
              StubTableScan(table=[[test_index]])  
     */
            List.of(),  
    public void testCheckedLongSumOverRewrittenBeforeMarking_2shard() {  
            true,  
        RexBuilder rb = scan.getCluster().getRexBuilder();
            scan,  
            """
    public void testHavingAfterWindow_2shard() {
            agg,
        );
        );
        RelNode result = runPlanner(plan, multiShardContext());
     */
            """
            result
            RexWindowBounds.UNBOUNDED_FOLLOWING
            List.of("status", "total_size", "grand_total")
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    }
        RexBuilder rb = scan.getCluster().getRexBuilder();  
            false  
        RexBuilder rb = scan.getCluster().getRexBuilder();
              OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
            filter,  
    private RelNode projectWithCountOverEmpty() {
        );
        RelNode result = runPlanner(plan, singleShardContext());
        assertPlanShape("""  
            typeFactory.createSqlType(SqlTypeName.BIGINT),
     * UNBOUNDED PRECEDING TO CURRENT ROW (cumulative). DataFusion's WindowAggExec handles it  
    /** Mock DF backend with EngineCapability.UNION — needed because UNION is opt-in. */  
        );
            RexWindowBounds.CURRENT_ROW,
            List.of(rb.makeInputRef(union, 0), rb.makeInputRef(union, 1), sumOver),  
    private RelNode makeDifferentTablesJoin() {
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                      OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        );
            lowerBound,
        );  
     * Window, then an intermediate {@code where}, then {@code stats} (PPL:
            false,
            """
                OpenSearchProject(status=[$0], size=[$1], running_sum=[SUM($1) OVER (PARTITION BY $0 ORDER BY $1)], viableBackends=[[mock-parquet]])  
    private AggregateCallOnWindowedProject aggCallOver(RelNode input, int sumFieldIndex, String alias, SqlTypeName returnType) {
            upperBound,
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
        return projectWithSumOverEmpty(scan);
            scan,
            input,
        RexBuilder rb,
              LogicalSort(sort0=[$0], dir0=[ASC])
        );  
    /**
            List.of("status", "size", "running_sum")
        assertPlanShape("""
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            result  
     * sits above the window's gather → stays SINGLE (childGatheredByWindow stops the walk before it  
     * already-gathered input and stays SINGLE — split rule skips because the child is
    public void testRexOverPartitionBy_2shard() {
     * no second ER above Join.
            List.of(rb.makeInputRef(join, 0), rb.makeInputRef(join, 1), over),  
     * Each Union arm gathers to COORDINATOR via the Union split rule; the Union itself is at  
     * route emits this frame ({@code streamstats} isn't wired here), but the planner must
        RelNode result = runPlanner(plan, multiShardContext());  
            """, plan);  
                OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            List.of(),  
            result  
            rb,
            typeFactory.createSqlType(SqlTypeName.BIGINT),
    /**
                  OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
     * {@link #testRankOverPartitionByOrderBy_2shard} — confirms DENSE_RANK is independently  
        );
                  OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=1, backends=[mock-parquet], =($1, 100))], viableBackends=[[mock-parquet]])
    }  
            false,
    public void testSumOverEmpty_afterSort_2shard() {
    /** Build a {@code RexOver} with the given function, operands, output type, and frame bounds.
        );
            typeFactory.createSqlType(returnType),  
     * still handle it correctly because Calcite can construct it directly.  
            scan,
            RexWindowBounds.UNBOUNDED_FOLLOWING
     * would reach the lower split's exchange). Proves the window-skip is per-aggregate, not global.
            LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
import org.apache.calcite.rel.logical.LogicalSort;
            LogicalProject(status=[$0], total_size=[$1], grand_total=[SUM($1) OVER ()])
                """,  
     * the cost gate on {@link org.opensearch.analytics.planner.rel.OpenSearchProject} forces
     * per-arm ER, but unlike a windowed Project directly above a Scan, the Project's cost
     */
     * {@code ROW_NUMBER() OVER ()} on a 2-shard scan. PPL's {@code streamstats … by …} lowers
            LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
        assertPlanShape(
        RelNode plan = LogicalProject.create(  
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            agg,  
            SqlTypeName.BIGINT,
            List.of(),
            """
            result
        RelNode result = runPlanner(plan, singleShardContext());  
            RexWindowBounds.UNBOUNDED_PRECEDING,  
            result  
            List.of(rb.makeInputRef(filter, 0), rb.makeInputRef(filter, 1), over),
            union,
        assertPlanShape(
                OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
        RexWindowBound lowerBound,
                          OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])  
            RexWindowBounds.CURRENT_ROW
            RexWindowBounds.CURRENT_ROW,
            RexWindowBounds.UNBOUNDED_PRECEDING,
            List.of("status", "size", "s")
                StubTableScan(table=[[test_index]])  
     * {@code SUM($1) OVER (PARTITION BY $0)} on a 2-shard scan. PARTITION BY is now accepted —  
 * backends by {@link org.opensearch.analytics.spi.WindowCapability}, and applies a cost  
            false,                                          // rangeBased: range-by-default-when-ORDER-BY  
                OpenSearchProject(status=[$0], size=[$1], running_sum=[SUM($1) OVER (ROWS UNBOUNDED PRECEDING)], viableBackends=[[mock-parquet]])  
    public void testWindowThenSort_2shard() {
              LogicalFilter(condition=[=($0, 200)])
        );  
        RelNode plan = LogicalProject.create(
            true,  
            result
        AggregateCallOnWindowedProject sizeAgg = aggCallOver(filter, /* size */ 1, "total_size");
        );  
        );
        RelNode result = runPlanner(plan, multiShardContext());  
        RelNode result = runPlanner(plan, perIndexContext(Map.of("left_idx", 2, "right_idx", 2)));
                """,  
    public void testWindowAfterAggregateWithHaving_2shard() {  
    /**
     * PARTIAL+FINAL pair.  
     * Window above a Join (2-shard different tables). Each Join arm needs SINGLETON, so per-arm  
        // The window's global frame (SUM OVER ()) forces a gather (ER) directly below the Project, so
        // Aggregate BOTH size ($1) and window col s ($2) so neither is dead.
        // Aggregate consumes size ($1) so it stays in the Project output (else trimmed); the filter
        // pass over already-gathered rows.
            scan,
            LogicalProject(status=[$0], size=[$1], cnt=[COUNT() OVER ()])  
                OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
            ImmutableList.of(rb.makeInputRef(scan, 0)),    // PARTITION BY status
            (SqlAggFunction) SqlStdOperatorTable.ROW_NUMBER,  
     * {@code DENSE_RANK() OVER (PARTITION BY $0 ORDER BY $1)} on a 2-shard scan. The companion to
        RexNode sumOver = makeOver(
              LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), denseRank),  
        return buildProjectWithOver(SqlStdOperatorTable.COUNT, List.of(), "cnt", SqlTypeName.BIGINT);
     * <p>The plan shape is identical to the empty-OVER case (gather then project) — partition  
     * The Project's RexOver cost gate forces an ER below the Project; Sort is collated and
        );
                """,  
            OpenSearchProject(status=[$0], size=[$1], cnt=[COUNT() OVER ()], viableBackends=[[mock-parquet]])
                OpenSearchProject(status=[$0], size=[$1], cnt=[COUNT() OVER ()], viableBackends=[[mock-parquet]])  
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
            List.of("status", "size", "s")
            List.of(rb.makeInputRef(input, 0), rb.makeInputRef(input, 1), over),  
            """, plan);
        assertPlanShape(
        assertPlanShape("""
            """, result);  
              LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            SqlTypeName.BIGINT,  
                OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])  
        );
     */
     * Verifies the rule emits exactly one OpenSearchProject wrapping both windows and
    public void testSumOverEmpty_2shard() {
        RelNode result = runPlanner(plan, multiShardContext());
        // Outer agg consumes BOTH cnt ($1) and window col s ($2) so neither is dead.  
        RexBuilder rb = scan.getCluster().getRexBuilder();
            (SqlAggFunction) SqlStdOperatorTable.ROW_NUMBER,  
        RelNode result = runPlanner(plan, multiShardContext());
        return buildContextPerIndex("parquet", Map.of(indexName, shardCount), intFields(), List.of(new UnionCapableBackend(), LUCENE));  
                            OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), rank),
                """,  
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
              StubTableScan(table=[[test_index]])  
            """, plan);
            result
                          OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
     * Verifies an Aggregate atop a window doesn't re-split into PARTIAL+FINAL.
            """
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            SqlStdOperatorTable.SUM,  
     */
    /** Self-join on test_index — used by {@link #testWindowAfterJoin_1shard} for the
        );
                StubTableScan(table=[[left_idx]])
    /**
            false,
            project,  
            typeFactory.createSqlType(outType),
     * ER below Project; Filter's input is the windowed Project (COORDINATOR+SINGLETON) and
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),  
        RelOptTable table = mockTable("test_index", "status", "size");
    /**
    public void testWindowAfterJoin_2shard() {
 *
        RexBuilder rb = input.getCluster().getRexBuilder();
                OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
            OpenSearchProject(status=[$0], total_size=[$1], grand_total=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])  
                        OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])
        // lower FINAL's coordinator output, so no extra exchange is inserted below the window.
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
     * <p>SQL semantics: with ORDER BY but no explicit frame, the implicit frame is RANGE
     * Project on top also needs no additional ER. Single ER total for the whole pipeline.
            RexWindowBounds.UNBOUNDED_PRECEDING,  
            List.of(rb.makeInputRef(scan, 1)),
            SqlTypeName.BIGINT,  
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
import java.util.HashSet;
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            -1,
import org.apache.calcite.rel.RelCollations;  
            """
        );  
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        RexNode over = rb.makeOver(
        assertPlanShape("""  
    }
        assertPlanShape(
        protected Set<EngineCapability> supportedEngineCapabilities() {  
        assertPlanShape(  
            ImmutableList.of(rb.makeInputRef(scan, 0)),      // PARTITION BY status
    }  
            join,  
        SqlAggFunction fn,
        RexNode over = makeOver(
        );
                    OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
        assertPlanShape("""  
            caps.add(EngineCapability.UNION);
        assertPlanShape(  
     * to a {@code projectPlus} of {@code ROW_NUMBER() OVER (ROWS UNBOUNDED PRECEDING TO  
     * narrow to {@code mock-parquet} only.  
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])  
        RelNode scan = stubScan(table);
import org.apache.calcite.rel.core.JoinRelType;
            false
        );
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
            ImmutableList.of(new RexFieldCollation(rb.makeInputRef(scan, 1), Set.of())),  // ORDER BY size  
                OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
            List.of(),
            join,
                  OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200))], viableBackends=[[mock-parquet]])
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), runningSum),
        );
            RexWindowBounds.UNBOUNDED_FOLLOWING
        RelNode plan = LogicalProject.create(  
            """
        RelNode result = runPlanner(plan, multiShardContext());
     */  
        );
                OpenSearchProject(status=[$0], size=[$1], rn=[ROW_NUMBER() OVER ()], viableBackends=[[mock-parquet]])  
     * Aggregate stacked on top of a windowed Project (1-shard). The Project's cost gate accepts
        );
            List.of(rb.makeInputRef(agg, 1)),  
    private RelNode buildProjectWithOver(SqlAggFunction fn, List<RexNode> operands, String outName, SqlTypeName outType) {
            """  
    public void testSumOverEmpty_afterFilter_1shard() {  
     * Aggregate stacked on top of a windowed Project (2-shard). The Project's cost gate forces
    }
                """,  
            result
        );
    }
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
            List.of(rb.makeInputRef(scan, 1)),
                  StubTableScan(table=[[test_index]])
    /**
 * gate that requires {@code COORDINATOR+SINGLETON} input on the project when any
        return LogicalProject.create(
              LogicalJoin(condition=[=($0, $2)], joinType=[inner])
        RelNode result = runPlanner(plan, multiShardContext());
                      OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])  
        RexNode countOver = makeOver(  
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
            (SqlAggFunction) SqlStdOperatorTable.SUM,  
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        assertPlanShape(
     * ER. Join emits COORDINATOR+SINGLETON which satisfies the windowed Project's cost gate —
     * coordinator then groups by the partition key and computes the window correctly.
            """
     */  
            List.of(),
            scan,
            fn,  
        // PARTIAL/FINAL over the partitioned scan. The window's SINGLETON demand is already met by the  
    /** Holder for the AggregateCall used by {@link #testAggregateAfterWindow_1shard}/_2shard. */
        List<RexNode> operands,
            Set<EngineCapability> caps = new HashSet<>(super.supportedEngineCapabilities());
            rb,
                      OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
            rb,
            """, plan);  
            rb,
            List.of("status", "size", "dense_rank_per_status")
        RelNode result = runPlanner(plan, perIndexContext(Map.of("test_index", 1)));  
     * 1-shard with empty OVER(). Scan emits SHARD+SINGLETON which satisfies the Project's
        );  
import org.apache.calcite.rex.RexBuilder;
            RexWindowBounds.UNBOUNDED_FOLLOWING  
            typeFactory.createSqlType(SqlTypeName.BIGINT),
            (SqlAggFunction) SqlStdOperatorTable.DENSE_RANK,  
    }  
              LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])  
        RelNode plan = makeFilter(projectWithSumOverEmpty(), makeEquals(2, SqlTypeName.BIGINT, 100L));  
public class WindowPlanShapeTests extends PlanShapeTestBase {
              LogicalUnion(all=[true])
     */  
        RelNode scan = stubScan(table);
        assertPlanShape("""
            List.of(),
            true,
        assertPlanShape("""
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            rb,
            true,  
            LogicalFilter(condition=[=($2, 100)])
     * Window after an Aggregate: {@code Project(group, total, SUM(total) OVER ())} over
        RelNode scan = stubScan(table);
                  OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])
            union,
            """, plan);  
        LogicalAggregate agg = makeAggregate(stubScan(mockTable("test_index", "status", "size")), sumCall());
            List.of("status", "size", "cnt", "s")
        assertPlanShape("""
            typeFactory.createSqlType(outType),
     *  Empty PARTITION BY and empty ORDER BY. */  
            input,
        RexBuilder rb = scan.getCluster().getRexBuilder();
     * extra ER. Mirrors PPL {@code source=t | stats count() as c | append [ source=t | stats count() ] | eventstats sum(c)}.
        RexNode over = rb.makeOver(  
                      OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            SqlTypeName.BIGINT,
            RexWindowBounds.UNBOUNDED_FOLLOWING
                OpenSearchSort(sort0=[$0], dir0=[ASC], viableBackends=[[mock-parquet]])
            result  
            List.of(),
        );
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), over),  
                  OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])  
     * doesn't add a second gather because its input is already SINGLETON.
    /**
            SqlTypeName.BIGINT,
              StubTableScan(table=[[test_index]])  
        assertPlanShape("""  
              LogicalFilter(condition=[=($0, 200)])  
    }
import org.opensearch.analytics.spi.EngineCapability;  
     * separate axis from PARTITION BY in {@code RexOver} — the relaxation in
            List.of(),  
    public void testMultipleRexOver_2shard() {
        RexNode denseRank = rb.makeOver(
            """
            RexWindowBounds.UNBOUNDED_PRECEDING,  
     */  
    }
     * Sort's output IS the SINGLETON the Project demands.
        AggregateCallOnWindowedProject cntAgg = aggCallOver(windowed, /* cnt */ 1, "total_cnt", SqlTypeName.BIGINT);
        );
            SqlTypeName.BIGINT,
     *
     * SortSplitRule, so the Project's RexOver cost gate is satisfied without a second ER —
    }
     * {@code SUM($1) OVER (PARTITION BY $0 ORDER BY $1)} on a 2-shard scan. ORDER BY is a  
            List.of(),  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
            result  
            List.of(),
            alias
            rb,
     * no ER above either. Filter on the windowed column ($2) is derived — viable backends
                OpenSearchAggregate(group=[{0}], cnt=[COUNT()], total_size=[SUM($1)], mode=[SINGLE], viableBackends=[[mock-parquet]])  
import com.google.common.collect.ImmutableList;
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        );  
    public void testRankOverPartitionByOrderBy_2shard() {
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), over),
    }
            false
        assertPlanShape("""
            List.of(rb.makeInputRef(join, 1)),
            """
            List.of(),  
                    OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])  
     * shape here keeps the wiring regression-safe and confirms the backend stays viable.  
            true,
            SqlStdOperatorTable.SUM,  
            true,                                            // rowBased  
        assertPlanShape("""  
     */
            rb,  
    /**
        assertPlanShape("""
        assertPlanShape("""
            false  
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    // ── Builders ──────────────────────────────────────────────────────────
     */
            RexWindowBounds.UNBOUNDED_PRECEDING,
            false,
            List.of("status", "size", "running_sum")
            List.of(),
            false,  
     * {@code stats sum(size) by status | eventstats sum(total)}.  
        assertPlanShape(  
    /**
     * satisfied by Scan's SHARD+SINGLETON, so no ER. Filter's input is already SINGLETON, so
        assertPlanShape("""
import org.apache.calcite.rex.RexFieldCollation;
                OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER (PARTITION BY $0)], viableBackends=[[mock-parquet]])
            ImmutableList.of(new RexFieldCollation(rb.makeInputRef(scan, 1), Set.of())),  // ORDER BY size  
    /**
            LogicalAggregate(group=[{0}], total_size=[SUM($1)], total_s=[SUM($2)])  
     *  co-location predicate fails and per-arm ER kicks in. */
        );
        );
        RexBuilder rb = scan.getCluster().getRexBuilder();
    /**
        );
        RelOptTable table = mockTable("test_index", "status", "size");  
        RexNode over = rb.makeOver(
     * coordinator regardless of whether partition keys span shards. WindowAggExec on the  
                  OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
            ImmutableList.of(rb.makeInputRef(scan, 0)),      // PARTITION BY status
     * shape (still ER under Project, same backend narrowing). Today no PPL command on this
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            RexWindowBounds.UNBOUNDED_PRECEDING,
    }  
            ImmutableList.of(),  
     * Window after a collated Sort (multi-shard). Sort already gathers to SINGLETON via  
import org.apache.calcite.rel.logical.LogicalAggregate;
        );
            result  
            """
            """, plan);
                """,
            LogicalProject(status=[$0], size=[$1], cnt=[COUNT() OVER ()], s=[SUM($1) OVER ()])
              LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
            result
     */  
            ImmutableList.of(rb.makeInputRef(scan, 0)),      // PARTITION BY status
            """, plan);
        );
     */
            List.of(),
        RelNode leftScan = stubScan(mockTable("test_index", "status", "size"));
                  OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-parquet], =($2, 0))], viableBackends=[[mock-parquet]])
     *  co-location fast path on 1-shard. */  
                StubTableScan(table=[[right_idx]])
    public void testAggregateAfterWindow_1shard() {  
     * {@code Aggregate(group=[$0], total=SUM($1))} (multi-shard). The aggregate splits into  
        RexBuilder rb = filter.getCluster().getRexBuilder();  
              LogicalJoin(condition=[=($0, $2)], joinType=[inner])  
        RelNode result = runPlanner(plan, singleShardContext());
        );  
            scan,
            """  
                """,
            List.of(rb.makeInputRef(filter, 0), rb.makeInputRef(filter, 1), over),
    /**  
        assertPlanShape(  
            scan,
     * Two RexOver expressions in the same Project — both empty OVER() — share one ER.  
            LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
        RelNode plan = LogicalProject.create(
        );
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), rowNumber),  
    /**
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
    /**  
                  StubTableScan(table=[[test_index]])
        RelNode plan = LogicalProject.create(
    /**
            RexWindowBounds.UNBOUNDED_PRECEDING,
        );
        assertPlanShape("""
            List.of(),  
            List.of(),
            RexWindowBounds.UNBOUNDED_PRECEDING,  
        RelOptTable left = mockTable("test_index", "status", "size");
        AggregateCallOnWindowedProject sAgg = aggCallOver(windowedProject, /* window col */ 2, "total_s", SqlTypeName.BIGINT);  
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RelNode windowedProject = projectWithSumOverEmpty();
import org.apache.calcite.rel.RelNode;
        RelNode scan,  
        );
    /**
     * an ER below the Project; output is COORDINATOR+SINGLETON. The Aggregate sees an  
        RelOptTable table = mockNullableTable("test_index", "status", "size");
        RelNode result = runPlanner(plan, multiShardContext());  
            result
            """, plan);  
 */  
                      OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
        assertPlanShape(
     * {@code eventstats sum(x) as w | where w > 0 | stats count() by k}). The Filter between the  
            """, plan);
        RelNode plan = LogicalProject.create(
            """, plan);
                OpenSearchProject(status=[$0], size=[$1], rank_per_status=[RANK() OVER (PARTITION BY $0 ORDER BY $1)], viableBackends=[[mock-parquet]])
        RexBuilder rb = scan.getCluster().getRexBuilder();
     *  (Filter, Sort, etc.). Input must have at least 2 fields ($0 status, $1 size). */  
 * The OpenSearch Contributors require contributions made to  
            """, plan);
            RexWindowBounds.UNBOUNDED_PRECEDING,
            """, plan);  
            return caps;  
        RelNode scan = stubScan(table);  
            RexWindowBounds.UNBOUNDED_PRECEDING,
        }
     * needs no ER.
 * expression is a RexOver.
        );
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), rowNumber),  
     * the LOWER aggregate scans partitioned shard data → splits PARTIAL/FINAL; the UPPER aggregate
            false,
        RelNode plan = projectWithSumOverEmpty(
    /** Multi-shard context whose only DF backend declares {@link EngineCapability#UNION},  
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
                """,  
            false
                StubTableScan(table=[[test_index]])  
        assertPlanShape("""
            List.of(rb.makeInputRef(filter, 1)),
    /**
                """,  
            ImmutableList.of(rb.makeInputRef(scan, 0)),     // PARTITION BY status
     * between. Filter sits above FINAL (already COORDINATOR+SINGLETON, no ER); windowed  
    public void testSumOverPartitionByOrderBy_2shard() {  
     * shape PPL's {@code streamstats … by str0 | sort key} produces: a per-partition row
    private RelNode projectWithSumOverEmpty() {
    public void testWindowAfterAggregateWithHaving_1shard() {  
        RelNode windowed = projectWithSumOverEmpty();
import org.apache.calcite.sql.type.SqlTypeName;
            result  
            RexWindowBounds.CURRENT_ROW
package org.opensearch.analytics.planner;
     * SHARD+SINGLETON Scan; the follow-on Aggregate stays SINGLE (input is already SINGLETON).  
        org.apache.calcite.rel.core.AggregateCall call = org.apache.calcite.rel.core.AggregateCall.create(  
            List.of("status", "size", outName)
        RexNode rowNumber = rb.makeOver(
        RexNode cond = rexBuilder.makeCall(
    }  
        );  
            List.of(),
        RexBuilder rb = scan.getCluster().getRexBuilder();  
        );  
            List.of("status", "size", "s")  
        RelNode result = runPlanner(plan, multiShardContext());
            """  
    /** SUM over {@code sumFieldIndex} with an explicit return type — needed when summing a BIGINT  
            RexWindowBounds.UNBOUNDED_FOLLOWING
        assertPlanShape(
    }
        RexBuilder rb = join.getCluster().getRexBuilder();
     */  
                """,  
        RelNode filter = makeFilter(windowed, makeEquals(2, SqlTypeName.BIGINT, 0));
            true,
            List.of("status", "size", "rank_per_status")  
            SqlStdOperatorTable.SUM,
        RelNode filter = makeFilter(agg, makeEquals(1, SqlTypeName.INTEGER, 100));
        RexNode over = makeOver(
            result
        return rb.makeOver(
        );
    }  
            List.of(rb.makeInputRef(input, 1)),
        // already keeps the window col s live.  
            true,
            """, plan);
     */
        RelNode result = runPlanner(plan, multiShardContext());  
            LogicalFilter(condition=[=($2, 100)])
        RelOptTable table = mockTable("test_index", "status", "size");
import org.apache.calcite.plan.RelOptTable;
            scan,  
                OpenSearchProject(status=[$0], size=[$1], cnt=[COUNT() OVER ()], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
    /**
            List.of(),
            (SqlAggFunction) SqlStdOperatorTable.SUM,
        RelNode plan = makeAggregate(windowedProject, sizeAgg.aggCall, sAgg.aggCall);
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            RexWindowBounds.UNBOUNDED_PRECEDING,  
        RelNode scan = stubScan(table);
                """,
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
 * <p>The planner detects RexOver inside {@code OpenSearchProjectRule}, narrows viable
            """, plan);
     * the same commit that relaxed PARTITION BY — pinning the cost-gate-then-WindowAggExec
                StubTableScan(table=[[test_index]])  
            SqlTypeName.BIGINT,  
        RelNode plan = makeFilter(projectWithSumOverEmpty(), makeEquals(2, SqlTypeName.BIGINT, 100L));
            RexWindowBounds.UNBOUNDED_FOLLOWING,
        RelNode plan = makeAggregate(windowedProject, sizeAgg.aggCall, sAgg.aggCall);
        RelNode result = runPlanner(plan, multiShardContext());  
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            List.of(),
            result
            rb,
            """  
            false,  
            false,  
        RelNode union = LogicalUnion.create(List.of(leftScan, rightScan), /* all */ true);
            LogicalProject(status=[$0], size=[$1], running_s=[SUM($1) OVER (ROWS UNBOUNDED PRECEDING)])
        assertPlanShape("""  
    }  
            List.of(rb.makeInputRef(join, 1)),
            SqlStdOperatorTable.SUM,
                OpenSearchProject(status=[$0], size=[$1], dense_rank_per_status=[DENSE_RANK() OVER (PARTITION BY $0 ORDER BY $1)], viableBackends=[[mock-parquet]])  
              OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])  
            false,
        RexBuilder rb = union.getCluster().getRexBuilder();
                  OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
import org.apache.calcite.rel.logical.LogicalProject;
                StubTableScan(table=[[test_index]])
            SqlTypeName.BIGINT,
        RelNode result = runPlanner(plan, multiShardContext());
        RelOptTable table = mockTable("test_index", "status", "size");  
            List.of("status", "size", "s")
            ImmutableList.of(new RexFieldCollation(rb.makeInputRef(scan, 1), Set.of())),  
     * through to DataFusion's native {@code rank()}. Pinning the cost-gate → SINGLETON-gather
     * exchange shape.
    }
     * Window after a Union: {@code Project(SUM(col) OVER ())} over a Union of two scans.
        assertPlanShape(
        );
        RexNode rowNumber = makeOver(  
        assertPlanShape(  
        // where s > 0 — s is the window output at column index 2.  
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
