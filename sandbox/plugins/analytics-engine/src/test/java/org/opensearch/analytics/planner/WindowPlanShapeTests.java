        assertPlanShape(
     * Window after a shard-side Filter (multi-shard). Filter is single-input passthrough,
            scan,
     * {@code ROW_NUMBER() OVER (PARTITION BY $0 ORDER BY $1)} on a 2-shard scan. This is the
            typeFactory.createSqlType(outType),
                """,
        );
    }
                OpenSearchProject(status=[$0], size=[$1], rn_per_status=[ROW_NUMBER() OVER (PARTITION BY $0 ORDER BY $1)], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(plan, perIndexContext(Map.of("test_index", 1)));
        );
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        );
    public void testWindowAfterJoin_1shard() {
            """, plan);
                OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-parquet], =($2, 100))], viableBackends=[[mock-parquet]])
     */
        RelNode scan = stubScan(table);
                OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
     * Each Union arm gathers to COORDINATOR via the Union split rule; the Union itself is at
 *
 * expression is a RexOver.
    }
            filter,
        );
            false,
    public void testRexOverPartitionBy_2shard() {
import org.apache.calcite.sql.type.SqlTypeName;
        RexNode countOver = makeOver(
            SqlTypeName.BIGINT,
    }
        );
                OpenSearchProject(status=[$0], total_size=[$1], grand_total=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
        RelNode result = runPlanner(plan, multiShardContext());
        RexBuilder rb = scan.getCluster().getRexBuilder();
            List.of(rb.makeInputRef(agg, 1)),
                  OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), rank),
        RelNode plan = LogicalProject.create(
            false,
    /**
                          OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            List.of(rb.makeInputRef(union, 0), rb.makeInputRef(union, 1), sumOver),
        assertPlanShape("""
     * ER below Project; Filter's input is the windowed Project (COORDINATOR+SINGLETON) and
        }
     */
            rb,
        return buildContextPerIndex("parquet", Map.of(indexName, shardCount), intFields(), List.of(new UnionCapableBackend(), LUCENE));
        assertPlanShape(
                OpenSearchProject(status=[$0], size=[$1], running_sum=[SUM($1) OVER (PARTITION BY $0 ORDER BY $1)], viableBackends=[[mock-parquet]])
            RexWindowBounds.UNBOUNDED_PRECEDING,
    }
        );
    /**
            SqlTypeName.BIGINT,
            scan,
     * UNBOUNDED PRECEDING TO CURRENT ROW (cumulative). DataFusion's WindowAggExec handles it
    /**
              StubTableScan(table=[[test_index]])
        );
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RexBuilder rb = agg.getCluster().getRexBuilder();
    public void testAggregateAfterWindow_1shard() {
    /**
        @Override
     * Window, then an intermediate {@code where}, then {@code stats} (PPL:
                LogicalAggregate(group=[{0}], total_size=[SUM($1)])
                    OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
                OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
            RexWindowBounds.UNBOUNDED_PRECEDING,
        assertPlanShape("""
                StubTableScan(table=[[test_index]])
        );
    private RelNode makeDifferentTablesJoin() {
            """
            RexWindowBounds.CURRENT_ROW,
        );
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
     */
     * between. Filter sits above FINAL (already COORDINATOR+SINGLETON, no ER); windowed
                OpenSearchProject(status=[$0], total_size=[$1], grand_total=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
                    OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200))], viableBackends=[[mock-parquet]])
     * separate axis from PARTITION BY in {@code RexOver} — the relaxation in
     * upward, satisfying the Project's RexOver cost gate without an ER. Pipeline stays
            List.of("status", "size", "dense_rank_per_status")
        RelNode scan = stubScan(table);
     * aggregate stays SINGLE.
    public void testAggregateAfterWindowBehindFilter_2shard_staysSingle() {
     */
     * shape here keeps both changes regression-safe.
        RelNode result = runPlanner(plan, multiShardContext());
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        );
     * so no ER is inserted. The whole pipeline runs on the single shard's node.
        RelNode plan = makeAggregate(windowed, countStarCall(windowed), cntAgg.aggCall, sAgg.aggCall);
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RexBuilder rb = union.getCluster().getRexBuilder();
                  StubTableScan(table=[[test_index]])
            """
    public void testMultipleRexOver_2shard() {
            result
            false,
        );
        );
     * Window after a collated Sort (multi-shard). Sort already gathers to SINGLETON via
            RexWindowBounds.UNBOUNDED_FOLLOWING
            List.of(rb.makeInputRef(join, 0), rb.makeInputRef(join, 1), over),
        );
            false,
        RelNode plan = LogicalProject.create(
                """,
        assertPlanShape("""
        // Upper aggregate stays SINGLE (its input is gathered by the window); lower aggregate splits
        RelNode scan = stubScan(table);
        RelNode plan = LogicalProject.create(
     * shape PPL's {@code streamstats … by str0 | sort key} produces: a per-partition row
    }
        RelNode plan = projectWithCountOverEmpty();
     * Window above a Join (1-shard self-join). Co-location keeps Join on the shard with no
        );
              OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
    // ── Builders ──────────────────────────────────────────────────────────
     * window Project and the aggregate forces the {@code childGatheredByWindow} walk to take a
            LogicalProject(status=[$0], size=[$1], cnt=[COUNT() OVER ()])
    }
        RexBuilder rb = input.getCluster().getRexBuilder();
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
import java.util.HashSet;
        assertPlanShape(
              LogicalJoin(condition=[=($0, $2)], joinType=[inner])
    /**
        assertPlanShape("""
            filter,
            RexWindowBounds.UNBOUNDED_FOLLOWING
            RexWindowBounds.UNBOUNDED_PRECEDING,
            join,
            SqlStdOperatorTable.SUM,
            LogicalFilter(condition=[=($2, 100)])
     */
            LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            upperBound,
     * no ER above either. Filter on the windowed column ($2) is derived — viable backends
        RexBuilder rb = scan.getCluster().getRexBuilder();
    /** SUM over {@code sumFieldIndex} with an explicit return type — needed when summing a BIGINT
            List.of("status", "size", "cnt", "s")
     */
        RelNode plan = projectWithSumOverEmpty(
     * SortSplitRule, so the Project's RexOver cost gate is satisfied without a second ER —
import org.apache.calcite.rel.logical.LogicalJoin;
                        OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
        RelNode join = makeSelfJoin();
            true,
            false,
                """,
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
     * {@code ROW_NUMBER() OVER ()} on a 2-shard scan. PPL's {@code streamstats … by …} lowers
            """, plan);
    public void testWindowAfterUnion_2shard() {
        );
import org.apache.calcite.rel.RelCollations;
                OpenSearchProject(status=[$0], size=[$1], cnt=[COUNT() OVER ()], viableBackends=[[mock-parquet]])
    private RelNode makeSelfJoin() {
        );
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
     */
        );
    public void testAggregateWindowAggregate_2shard_onlyLowerSplits() {
            RexWindowBounds.UNBOUNDED_FOLLOWING
            LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
            ImmutableList.of(rb.makeInputRef(scan, 0)),    // PARTITION BY status
     * w = sum(..) over () | stats ...}). The split rule must treat each aggregate independently:
            RexWindowBounds.CURRENT_ROW,
            ImmutableList.of(rb.makeInputRef(scan, 0)),      // PARTITION BY status
            false,
            true,
        assertPlanShape(
        );
                      OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
    private RelNode buildProjectWithOver(SqlAggFunction fn, List<RexNode> operands, String outName, SqlTypeName outType) {
            List.of(),
        assertPlanShape(
        RelNode scan = stubScan(table);
        SqlTypeName outType,
import org.apache.calcite.rex.RexBuilder;
    }
            LogicalProject(status=[$0], total_size=[$1], grand_total=[SUM($1) OVER ()])
import java.util.Set;
            LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
                StubTableScan(table=[[test_index]])
    /**
            LogicalProject(status=[$0], size=[$1], running_s=[SUM($1) OVER (ROWS UNBOUNDED PRECEDING)])
            List.of("status", "total_size", "grand_total")
            """
        RelNode result = runPlanner(plan, multiShardContext());
        assertPlanShape("""
            (SqlAggFunction) SqlStdOperatorTable.ROW_NUMBER,
     * shape here keeps the wiring regression-safe and confirms the backend stays viable.
     *  so the Union marker rule accepts the Union shape. */
        RexNode rank = rb.makeOver(
            List.of("status", "size", "rn_per_status")
import org.apache.calcite.plan.RelOptTable;
    }
                    OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
            RexWindowBounds.UNBOUNDED_PRECEDING,
                OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
package org.opensearch.analytics.planner;
            """, plan);
     * the same way once SINGLETON-gathered.
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), over),
        );
 * compatible open source license.
            scan,
            LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
            List.of(),
     * the LOWER aggregate scans partitioned shard data → splits PARTIAL/FINAL; the UPPER aggregate
            RexWindowBounds.UNBOUNDED_FOLLOWING
        RelNode filter = makeFilter(agg, makeEquals(1, SqlTypeName.INTEGER, 100));
    /**
            caps.add(EngineCapability.UNION);
     * does not duplicate the ER per RexOver.
    public void testSumOverEmpty_afterFilter_1shard() {
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            RexWindowBounds.UNBOUNDED_PRECEDING,
     * would reach the lower split's exchange). Proves the window-skip is per-aggregate, not global.
     * the same commit that relaxed PARTITION BY — pinning the cost-gate-then-WindowAggExec
     */
    }
            result
              StubTableScan(table=[[test_index]])
            agg,
     * {@code Aggregate(group=[$0], total=SUM($1))} (multi-shard). The aggregate splits into
                """,
                """,
        );
     * coordinator then groups by the partition key and computes the window correctly.
    /**
        return LogicalJoin.create(stubScan(left), stubScan(right), List.of(), cond, java.util.Set.<CorrelationId>of(), JoinRelType.INNER);
     */
        RelNode leftScan = stubScan(mockTable("test_index", "status", "size"));
     * Two RexOver expressions in the same Project — both empty OVER() — share one ER.
            scan,
     *  column (e.g. a window output) where the inferred type differs from the INTEGER default. */
            """, result);
        RelNode plan = makeAggregate(windowedProject, sizeAgg.aggCall, sAgg.aggCall);
     * PARTIAL + ER + FINAL. FINAL emits {@code COORDINATOR+SINGLETON}, which the windowed
     */
                    OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
            filter,
            result
        RelNode windowedProject = projectWithSumOverEmpty();
    }
        RelOptTable right = mockTable("test_index", "status", "size");
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            rb,
              LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
                """,
        RelOptTable table = mockTable("test_index", "status", "size");
        RelNode windowedProject = projectWithSumOverEmpty();
            ImmutableList.of(new RexFieldCollation(rb.makeInputRef(scan, 1), Set.of())),  // ORDER BY size
     * Window after a Filter on a 1-shard input. Filter propagates Scan's SHARD+SINGLETON
        RelNode result = runPlanner(plan, multiShardContext());
     * route emits this frame ({@code streamstats} isn't wired here), but the planner must
        );
        return rb.makeOver(
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        assertPlanShape("""
}
            OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], total_s=[SUM($2)], mode=[SINGLE], viableBackends=[[mock-parquet]])
     * Window after a Union: {@code Project(SUM(col) OVER ())} over a Union of two scans.
     * Project on top also needs no additional ER. Single ER total for the whole pipeline.
        );
    public void testRowNumberOverPartitionByOrderBy_2shard() {
    private static final class UnionCapableBackend extends MockDataFusionBackend {
     *  co-location predicate fails and per-arm ER kicks in. */
    }
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), sumOver),
            ImmutableList.of(),
     * the cost gate on {@link org.opensearch.analytics.planner.rel.OpenSearchProject} forces
        RelNode plan = makeAggregate(filter, countStarCall(filter), sizeAgg.aggCall);
        RexNode sumOver = makeOver(
            """, result);
     * doesn't add a second gather because its input is already SINGLETON.
        );
    }
            """
        RelNode windowed = projectWithSumOverEmpty(lowerAgg);
     * needs no ER.
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), runningSum),
            fn,
    /** Different-tables equi-join — used by {@link #testWindowAfterJoin_2shard} so the
    /**
        RexNode over = makeOver(
        AggregateCallOnWindowedProject sAgg = aggCallOver(windowed, /* window col */ 2, "total_s", SqlTypeName.BIGINT);
    public void testDenseRankOverPartitionByOrderBy_2shard() {
                  OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
                  OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
    public void testWindowAfterAggregateWithHaving_2shard() {
        );
        RexNode sumOver = makeOver(
        );
        );
        List<RexNode> operands,
        return buildProjectWithOver(SqlStdOperatorTable.COUNT, List.of(), "cnt", SqlTypeName.BIGINT);
    }
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
     * still handle it correctly because Calcite can construct it directly.
     */
        return projectWithSumOverEmpty(scan);
     * aggregate would split PARTIAL/FINAL redundantly over already-gathered rows. Asserts the
import org.apache.calcite.rex.RexWindowBounds;
    }
                OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
        RexNode over = makeOver(
        RelNode scan = stubScan(table);
    }
    /**
        assertPlanShape(
        assertPlanShape("""
        RelOptTable table = mockTable("test_index", "status", "size");
    private AggregateCallOnWindowedProject aggCallOver(RelNode input, int sumFieldIndex, String alias, SqlTypeName returnType) {
import java.util.Map;
        );
    private AggregateCallOnWindowedProject aggCallOver(RelNode input, int sumFieldIndex, String alias) {
     */
            scan,
            SqlStdOperatorTable.SUM,
        RelNode scan = stubScan(table);
              LogicalSort(sort0=[$0], dir0=[ASC])
                StubTableScan(table=[[test_index]])
            """
            List.of(),
            List.of(),
            checkedLongSumOperator(),
        RexNode cond = rexBuilder.makeCall(
                StubTableScan(table=[[test_index]])
    }
            rb,
            List.of("status", "size", "s")
     * extra ER. Mirrors PPL {@code source=t | stats count() as c | append [ source=t | stats count() ] | eventstats sum(c)}.
            SqlStdOperatorTable.COUNT,
    public void testHavingAfterWindow_1shard() {
            LogicalAggregate(group=[{0}], total_size=[SUM($1)], total_s=[SUM($2)])
import org.apache.calcite.rel.logical.LogicalUnion;
     * a running aggregate. The frame bounds change the OVER() rendering but not the plan
            typeFactory.createSqlType(returnType),
                StubTableScan(table=[[test_index]])
            rb,
     * gate forces an ER above the Join. Documented here so future planner work — making Join
    }
            scan,
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            LogicalProject(status=[$0], total_size=[$1], grand_total=[SUM($1) OVER ()])
        protected Set<EngineCapability> supportedEngineCapabilities() {
        RelNode result = runPlanner(plan, multiShardContext());
            LogicalSort(sort0=[$0], dir0=[ASC])
            result
            SqlStdOperatorTable.SUM,
                OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], total_s=[SUM($2)], mode=[SINGLE], viableBackends=[[mock-parquet]])
     * COORDINATOR+SINGLETON, which satisfies the windowed Project's cost gate without an
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
            List.of(rb.makeInputRef(filter, 1)),
            """, plan);
        );
        RelOptTable table = mockTable("test_index", "status", "size");
        // Aggregate consumes size ($1) so it stays in the Project output (else trimmed); the filter
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), rowNumber),
     * Window after an Aggregate: {@code Project(group, total, SUM(total) OVER ())} over
        RelNode plan = LogicalProject.create(
        RexBuilder rb = filter.getCluster().getRexBuilder();
        assertPlanShape(
        LogicalAggregate agg = makeAggregate(stubScan(mockTable("test_index", "status", "size")), sumCall());
        RelNode result = runPlanner(plan, multiShardContext());
                      OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
    /**
            """
            rb,
            SqlStdOperatorTable.SUM,
                  OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=1, backends=[mock-parquet], =($1, 100))], viableBackends=[[mock-parquet]])
            SqlStdOperatorTable.SUM,
     * per-arm ER, but unlike a windowed Project directly above a Scan, the Project's cost
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            result
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
     * already SINGLETON, so we get one ER for the whole pipeline instead of a redundant
              StubTableScan(table=[[test_index]])
        assertPlanShape("""
        AggregateCallOnWindowedProject sAgg = aggCallOver(windowedProject, /* window col */ 2, "total_s", SqlTypeName.BIGINT);
            scan,
     * shape (still ER under Project, same backend narrowing). Today no PPL command on this
            result
              LogicalJoin(condition=[=($0, $2)], joinType=[inner])
        SqlAggFunction fn,
                  OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200))], viableBackends=[[mock-parquet]])
                  OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])
            join,
        assertPlanShape("""
            List.of(rb.makeInputRef(join, 1)),
                """,
        assertPlanShape(
            null,
              LogicalFilter(condition=[=($1, 100)])
     * Aggregate stacked on top of a windowed Project (2-shard). The Project's cost gate forces
            SqlStdOperatorTable.SUM,
        RelNode plan = LogicalSort.create(
                OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER (PARTITION BY $0)], viableBackends=[[mock-parquet]])
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), over),
    public void testSumOverEmpty_afterFilter_2shard() {
                """,
     * {@code DENSE_RANK() OVER (PARTITION BY $0 ORDER BY $1)} on a 2-shard scan. The companion to
        // pass over already-gathered rows.
     * <p>The plan shape is identical to the empty-OVER case (gather then project) — partition
        );
        );
 *
     * (empty OVER clause) as the final projected expression.
    private RelNode projectWithCountOverEmpty() {
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            true,
                """,
            false
            RexWindowBounds.UNBOUNDED_FOLLOWING
            RexWindowBounds.UNBOUNDED_FOLLOWING
    }
     * {@code SUM($1) OVER (PARTITION BY $0 ORDER BY $1)} on a 2-shard scan. ORDER BY is a
        // the aggregate's input is already on one node. The split rule detects the window-induced
        RexNode denseRank = rb.makeOver(
     */
        AggregateCallOnWindowedProject sizeAgg = aggCallOver(windowedProject, /* size */ 1, "total_size");
            SqlTypeName.BIGINT,
                StubTableScan(table=[[test_index]])
            result
                LogicalAggregate(group=[{0}], total_size=[SUM($1)])
        assertPlanShape(
            (SqlAggFunction) SqlStdOperatorTable.SUM,
        );
            false,
     * Aggregate stacked on top of a windowed Project (1-shard). The Project's cost gate accepts
     * HAVING-like Filter above a windowed Project (2-shard). The Project's RexOver gate forces
        );
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    }
            RexWindowBounds.UNBOUNDED_PRECEDING,
            fn,
     * SINGLETON input on any RexOver-bearing project, so all rows in a partition arrive on the
            """
     * an ER below the Project; output is COORDINATOR+SINGLETON. The Aggregate sees an
    /**
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            Set<EngineCapability> caps = new HashSet<>(super.supportedEngineCapabilities());
 * The OpenSearch Contributors require contributions made to
            rb,
     *
            agg,
 */
                OpenSearchAggregate(group=[{0}], cnt=[COUNT()], total_size=[SUM($1)], mode=[SINGLE], viableBackends=[[mock-parquet]])
    private record AggregateCallOnWindowedProject(org.apache.calcite.rel.core.AggregateCall aggCall) {
        // The window's global frame (SUM OVER ()) forces a gather (ER) directly below the Project, so
                OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
            SqlStdOperatorTable.SUM,
        RexNode over = makeOver(
            List.of(),
        RexBuilder rb = scan.getCluster().getRexBuilder();
    }
        assertPlanShape("""
import org.apache.calcite.rel.core.JoinRelType;
            List.of(),
        AggregateCallOnWindowedProject sizeAgg = aggCallOver(windowedProject, /* size */ 1, "total_size");
    }
            List.of(rb.makeInputRef(scan, 1)),
    }
    ) {
        RexBuilder rb = join.getCluster().getRexBuilder();
            List.of(),
     * sits above the window's gather → stays SINGLE (childGatheredByWindow stops the walk before it
                OpenSearchProject(status=[$0], size=[$1], running_s=[SUM($1) OVER (ROWS UNBOUNDED PRECEDING)], viableBackends=[[mock-parquet]])
        RexBuilder rb = scan.getCluster().getRexBuilder();
    /** Build a {@code RexOver} with the given function, operands, output type, and frame bounds.
 * gate that requires {@code COORDINATOR+SINGLETON} input on the project when any
        RelNode scan = stubScan(table);
            result
            """, plan);
            rb,
            """, plan);
            ImmutableList.of(rb.makeInputRef(scan, 0)),      // PARTITION BY status
        // where s > 0 — s is the window output at column index 2.
            rb,
            LogicalProject(status=[$0], size=[$1], cnt=[COUNT() OVER ()])
        );
        RexNode checkedSumOver = makeOver(
            false,                                          // rangeBased: range-by-default-when-ORDER-BY
        RelNode scan = stubScan(table);
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), denseRank),
            rb,
    public void testWindowThenSort_2shard() {
            List.of(rb.makeInputRef(input, 0), rb.makeInputRef(input, 1), over),
            typeFactory.createSqlType(SqlTypeName.BIGINT),
            SqlStdOperatorTable.EQUALS,
            List.of(rb.makeInputRef(filter, 0), rb.makeInputRef(filter, 1), over),
            RexWindowBounds.UNBOUNDED_PRECEDING,
            LogicalProject(status=[$0], size=[$1], cnt=[COUNT() OVER ()], s=[SUM($1) OVER ()])
                      OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RexBuilder rb = scan.getCluster().getRexBuilder();
 * {@link LogicalProject} (the shape PPL {@code eventstats} / {@code appendcol} emit).
     * propagate SHARD+SINGLETON the same way Scan does — has a regression target.
                StubTableScan(table=[[test_index]])
     * on the single shard's node.
            typeFactory.createSqlType(outType),
        RexNode over = makeOver(
    public void testSumOverPartitionByOrderBy_2shard() {
        );
            scan,
            List.of(rb.makeInputRef(scan, 1)),
            List.of(rb.makeInputRef(join, 0), rb.makeInputRef(join, 1), over),
                  OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
            project,
                """,
        RexNode rowNumber = makeOver(
            result
            result
            """, plan);
import org.apache.calcite.sql.SqlAggFunction;
            LogicalFilter(condition=[=($2, 100)])
        assertPlanShape("""
        assertPlanShape(
            List.of(),
            true,
     * Project's cost gate accepts without a second ER. Mirrors the PPL pattern
        RelOptTable table = mockTable("test_index", "status", "size");
                """,
        assertPlanShape(
            result
            """
    }
            true,
            true,
        assertPlanShape(
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), rowNumber),
            false,
            operands,
            true,                                            // rowBased
     * Verifies the rule emits exactly one OpenSearchProject wrapping both windows and
        RelNode scan = stubScan(table);
        assertPlanShape("""
     */
            """, plan);
    /**
            union,
        LogicalAggregate agg = makeAggregate(stubScan(mockTable("test_index", "status", "size")), sumCall());
     * sits between Filter and Project.
    /** Multi-shard context whose only DF backend declares {@link EngineCapability#UNION},
                      OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RexNode over = makeOver(
            operands,
            """
            scan,
     */
                OpenSearchProject(status=[$0], size=[$1], rn=[ROW_NUMBER() OVER ()], viableBackends=[[mock-parquet]])
     * through to DataFusion's native {@code rank()}. Pinning the cost-gate → SINGLETON-gather
            """
        RelOptTable table = mockNullableTable("test_index", "status", "size");
            ImmutableList.of(),
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
    }
            result
            List.of(),
              OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=1, backends=[mock-parquet], =($1, 100))], viableBackends=[[mock-parquet]])
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RelNode plan = LogicalProject.create(
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            false,
            RexWindowBounds.UNBOUNDED_FOLLOWING
    public void testSumOverEmpty_afterSort_2shard() {
        // Aggregate BOTH size ($1) and window col s ($2) so neither is dead.
        RexNode sumOver = makeOver(
     *
            ImmutableList.of(),
    /**
            SqlStdOperatorTable.SUM,
        RelOptTable table = mockTable("test_index", "status", "size");
        RelNode scan,
        // lower FINAL's coordinator output, so no extra exchange is inserted below the window.
     * SUM OVER (PARTITION BY ORDER BY) alone — this one combines them and is the one that
        assertPlanShape(
            true,
            result
                  OpenSearchSort(sort0=[$0], dir0=[ASC], viableBackends=[[mock-parquet]])
        );
     * {@link #testRankOverPartitionByOrderBy_2shard} — confirms DENSE_RANK is independently
        RelNode plan = LogicalProject.create(
            result
            """, plan);
        RexNode over = makeOver(
     */
        RelNode result = runPlanner(plan, multiShardContext());
        RelNode result = runPlanner(plan, multiShardContext());
            List.of(),
    public void testSumOverAfterAggregate_2shard() {
        assertPlanShape(
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), checkedSumOver),
                """,
            result
     */
        );
        RelNode plan = projectWithSumOverEmpty(
            List.of(rb.makeInputRef(filter, 1)),
        RelNode scan = stubScan(table);
import org.apache.calcite.rex.RexWindowBound;
        RelNode plan = projectWithSumOverEmpty(makeSort(stubScan(mockTable("test_index", "status", "size")), -1));
     */
    }
              OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        return LogicalProject.create(
    public void testCountOverEmpty_1shard() {
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), over),
            LogicalAggregate(group=[{0}], total_size=[SUM($1)], total_s=[SUM($2)])
        );
     */
            """
     * already-gathered input and stays SINGLE — split rule skips because the child is
                OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
                """,
            List.of("status", "size", "s")
     * satisfied by Scan's SHARD+SINGLETON, so no ER. Filter's input is already SINGLETON, so
            -1,
            """, result);
                StubTableScan(table=[[right_idx]])
            SqlTypeName.BIGINT,
                  OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
        assertPlanShape("""
                StubTableScan(table=[[test_index]])
            SqlStdOperatorTable.EQUALS,
            SqlStdOperatorTable.SUM,
    /**
        // already keeps the window col s live.
        );
     * recognized by {@code WindowFunction.resolveFunction} and advertised by the DataFusion backend.
    /**
        RexNode rowNumber = rb.makeOver(
            result
     * coordinator regardless of whether partition keys span shards. WindowAggExec on the
            List.of("status", "size", "running_sum")
            RexWindowBounds.UNBOUNDED_FOLLOWING
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            typeFactory.createSqlType(SqlTypeName.BIGINT),
            RexWindowBounds.UNBOUNDED_FOLLOWING,
            List.of("status", "size", "s")
/**
        assertPlanShape(
            scan,
            SqlTypeName.BIGINT,
              LogicalFilter(condition=[=($0, 200)])
    /**
        assertPlanShape(
import org.apache.calcite.rex.RexFieldCollation;
                """,
            null
        return LogicalProject.create(
            SqlTypeName.BIGINT,
        org.apache.calcite.rel.core.AggregateCall call = org.apache.calcite.rel.core.AggregateCall.create(
            """, plan);
    }
            OpenSearchProject(status=[$0], size=[$1], cnt=[COUNT() OVER ()], viableBackends=[[mock-parquet]])
        RelNode plan = makeFilter(projectWithSumOverEmpty(), makeEquals(2, SqlTypeName.BIGINT, 100L));
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            SqlTypeName.BIGINT,
        assertPlanShape(
        RelOptTable left = mockTable("test_index", "status", "size");
            input,
        RexBuilder rb = scan.getCluster().getRexBuilder();
            LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
        );
        RelNode project = LogicalProject.create(
            (SqlAggFunction) SqlStdOperatorTable.DENSE_RANK,
            RexWindowBounds.UNBOUNDED_PRECEDING,
            RexWindowBounds.CURRENT_ROW
        RelNode result = runPlanner(plan, multiShardContext());
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                """,
        RexBuilder rb = scan.getCluster().getRexBuilder();
            result
        );
            SqlTypeName.BIGINT,
            List.of("status", "size", "rn")
            """
import org.apache.calcite.rel.logical.LogicalSort;
        assertPlanShape("""
            result
            """, plan);
        );
                            OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
     * Build a LogicalProject that passes through every scan column and adds one RexOver
 * <p>The planner detects RexOver inside {@code OpenSearchProjectRule}, narrows viable
        return new AggregateCallOnWindowedProject(call);
            """
            """
                  OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
     * {@code SUM($1) OVER (PARTITION BY $0)} on a 2-shard scan. PARTITION BY is now accepted —
    /**
                """,
        RelNode plan = projectWithSumOverEmpty();
            """
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RelOptTable table = mockTable("test_index", "status", "size");
            """, plan);
        RelNode result = runPlanner(plan, multiShardContext());
     * Window above a Join (2-shard different tables). Each Join arm needs SINGLETON, so per-arm
        assertPlanShape(
        RelNode result = runPlanner(plan, multiShardContext());
        RexNode over = rb.makeOver(
import com.google.common.collect.ImmutableList;
            false
        // Aggregate BOTH size ($1) and window col s ($2) so neither is dead — keeps the window live.
        );
            """, plan);
            SqlTypeName.BIGINT,
                      OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
import org.apache.calcite.rel.RelFieldCollation;
        RelNode result = runPlanner(plan, perIndexContext(Map.of("left_idx", 2, "right_idx", 2)));
            List.of(rb.makeInputRef(scan, 1)),
        );
    /**
            RexWindowBounds.UNBOUNDED_PRECEDING,
            (SqlAggFunction) SqlStdOperatorTable.RANK,
            join,
            SqlStdOperatorTable.SUM,
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(plan, multiShardContext());
        assertPlanShape("""
    }
        RelOptTable table = mockTable("test_index", "status", "size");
            return caps;
        assertPlanShape("""
            scan,
            """
        );
        RelNode result = runPlanner(plan, multiShardContext());
            join,
                OpenSearchSort(sort0=[$0], dir0=[ASC], viableBackends=[[mock-parquet]])
            RexWindowBounds.UNBOUNDED_PRECEDING,
            """, plan);
     */
        assertPlanShape(
            RexWindowBounds.UNBOUNDED_PRECEDING,
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            (SqlAggFunction) SqlStdOperatorTable.SUM,
     */
            List.of(rb.makeInputRef(scan, 1)),
import org.apache.calcite.rex.RexNode;
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        );
        RexBuilder rb = scan.getCluster().getRexBuilder();
            List.of(rb.makeInputRef(scan, 1)),
            scan,
        RelNode filter = makeFilter(agg, makeEquals(1, SqlTypeName.INTEGER, 100));
            List.of(),
            result
        RexBuilder rb = scan.getCluster().getRexBuilder();
 * Plan-shape tests for window functions, expressed as {@code RexOver} inside a
            filter,
        RelNode plan = LogicalProject.create(
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            SqlTypeName.BIGINT,
        RelNode lowerAgg = makeAggregate(stubScan(mockTable("test_index", "status", "size")), countStarCall());
            List.of("status", "size", "s")
    }
        AggregateCallOnWindowedProject cntAgg = aggCallOver(windowed, /* cnt */ 1, "total_cnt", SqlTypeName.BIGINT);
            input,
    public void testRankOverPartitionByOrderBy_2shard() {
        );
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        return aggCallOver(input, sumFieldIndex, alias, SqlTypeName.INTEGER);
            makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200))
            rb,
            scan,
            true,
        RexNode over = rb.makeOver(
     * Sort placed after a windowed Project: {@code Sort(Project(scan, SUM($1) OVER ()))}.
        RelNode result = runPlanner(plan, multiShardContext());
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                          OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
    public void testWindowAfterJoin_2shard() {
     */
            """, plan);
                StubTableScan(table=[[test_index]])
    public void testCountOverEmpty_2shard() {
     * stays at SHARD; the RexOver Project's cost gate forces COORDINATOR input, so an ER
                OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], mode=[SINGLE], viableBackends=[[mock-parquet]])
            List.of("status", "total_size", "grand_total")
            RexWindowBounds.UNBOUNDED_PRECEDING,
                OpenSearchProject(status=[$0], size=[$1], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
     * 1-shard: aggregate stays SINGLE (no split), Filter and Project layer above without ER.
     */
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RelOptTable table = mockTable("test_index", "status", "size");
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
     * GROUP BY + HAVING + window (2-shard). Aggregate splits to PARTIAL+FINAL with one ER
        RelNode result = runPlanner(plan, singleShardContext());
            List.of(rb.makeInputRef(filter, 0), rb.makeInputRef(filter, 1), over),
        assertPlanShape(
                      OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
    }
            List.of(),
            List.of("status", "size", outName)
            scan,
            List.of(rb.makeInputRef(agg, 0), rb.makeInputRef(agg, 1), over),
            false,
            """, result);
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            scan,
    public void testCheckedLongSumOverRewrittenBeforeMarking_2shard() {
                """,
            List.of(rb.makeInputRef(join, 1)),
    }
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
    /**
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            """, plan);
        RelNode scan = stubScan(table);
            true,
        RelNode result = runPlanner(plan, multiShardContext());
        RelOptTable left = mockTable("left_idx", "status", "size");
    }
            List.of(),
        RexBuilder rb = scan.getCluster().getRexBuilder();
            typeFactory.createSqlType(SqlTypeName.BIGINT),
              LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
            ImmutableList.of(),
        );
                OpenSearchProject(status=[$0], size=[$1], cnt=[COUNT() OVER ()], s=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
            List.of(),
            RexWindowBounds.UNBOUNDED_FOLLOWING
    }
        RexWindowBound lowerBound,
        );
        );
        RelNode plan = LogicalProject.create(
        );
     * RexOver cost gate (type=SINGLETON) AND the root's locality-agnostic SINGLETON demand,
        );
    }
        // PARTIAL/FINAL over the partitioned scan. The window's SINGLETON demand is already met by the
     * {@code stats sum(size) by status | eventstats sum(total)}.
     * narrow to {@code mock-parquet} only.
        RelNode scan = stubScan(table);
        assertPlanShape("""
    public void testRowNumberOverEmpty_2shard() {
                """,
/*
            ImmutableList.of(new RexFieldCollation(rb.makeInputRef(scan, 1), Set.of())),
    public void testHavingAfterWindow_2shard() {
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                OpenSearchAggregate(group=[{0}], cnt=[COUNT()], total_cnt=[SUM($1)], total_s=[SUM($2)], mode=[SINGLE], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(plan, singleShardContext());
            RexWindowBounds.UNBOUNDED_PRECEDING,
            true,
            ImmutableList.of(new RexFieldCollation(rb.makeInputRef(scan, 1), Set.of())),  // ORDER BY size
            """
     * WindowFunction enum alongside DENSE_RANK; like ROW_NUMBER it needs no adapter and passes
                    OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
            RexWindowBounds.UNBOUNDED_PRECEDING,
            """
              StubTableScan(table=[[test_index]])
            List.of(),
            false,
            List.of("status", "size", "running_sum")
            List.of(),
import org.apache.calcite.rel.logical.LogicalAggregate;
              LogicalUnion(all=[true])
            ImmutableList.of(new RexFieldCollation(rb.makeInputRef(scan, 1), Set.of())),  // ORDER BY size
        RelNode filter = makeFilter(windowed, makeEquals(2, SqlTypeName.BIGINT, 0));
        );
        RelOptTable table = mockTable("test_index", "status", "size");
                  OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
              LogicalAggregate(group=[{0}], total_size=[SUM($1)])
            input,
            false
            RexWindowBounds.UNBOUNDED_PRECEDING,
        assertPlanShape("""
                StubTableScan(table=[[test_index]])
            """
                """,
                OpenSearchProject(status=[$0], size=[$1], rank_per_status=[RANK() OVER (PARTITION BY $0 ORDER BY $1)], viableBackends=[[mock-parquet]])
    public void testWindowAfterAggregateWithHaving_1shard() {
        );
            """
            makeFilter(stubScan(mockTable("test_index", "status", "size")), makeEquals(0, SqlTypeName.INTEGER, 200))
    /**
        RelNode result = runPlanner(plan, multiShardContext());
            List.of(rb.makeInputRef(scan, 1)),
        RelNode plan = makeFilter(projectWithSumOverEmpty(), makeEquals(2, SqlTypeName.BIGINT, 100L));
                StubTableScan(table=[[test_index]])
            false,
            RexWindowBounds.CURRENT_ROW,
        // gather (childGatheredByWindow) and keeps the aggregate SINGLE — no redundant PARTIAL/FINAL
     * {@code OpenSearchProjectRule.collectWindowFunctions} drops the partition-key check but
        );
        );
    private RelNode projectWithSumOverEmpty(RelNode input) {
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        );
        RexBuilder rb,
 * this file be licensed under the Apache-2.0 license or a
            """, plan);
import org.apache.calcite.rel.RelNode;
              LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
                OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
     */
    }
        RexWindowBound upperBound
     * {@code eventstats sum(x) as w | where w > 0 | stats count() by k}). The Filter between the
                OpenSearchProject(status=[$0], size=[$1], dense_rank_per_status=[DENSE_RANK() OVER (PARTITION BY $0 ORDER BY $1)], viableBackends=[[mock-parquet]])
            ImmutableList.of(rb.makeInputRef(scan, 0)),      // PARTITION BY status
        assertPlanShape(
        RelNode result = runPlanner(plan, singleShardContext());
     *  co-location fast path on 1-shard. */
            OpenSearchProject(status=[$0], total_size=[$1], grand_total=[SUM($1) OVER ()], viableBackends=[[mock-parquet]])
     * keys are encoded inside the RexOver expression and don't affect the surrounding
     */
        RelNode plan = LogicalProject.create(
        );
            false,
    public void testSumOverRunningFrame_2shard() {
            RexWindowBounds.CURRENT_ROW
    /**
            ImmutableList.of(rb.makeInputRef(scan, 0)),     // PARTITION BY status
        );
            (SqlAggFunction) SqlStdOperatorTable.ROW_NUMBER,
        RelNode plan = projectWithCountOverEmpty();
import org.apache.calcite.rel.logical.LogicalProject;
            SqlTypeName.BIGINT,
            List.of(),
    }
            result
                  OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-parquet], =($2, 0))], viableBackends=[[mock-parquet]])
 * backends by {@link org.opensearch.analytics.spi.WindowCapability}, and applies a cost
    }
            RexWindowBounds.CURRENT_ROW,
    private RelNode projectWithSumOverEmpty() {
    /** Mock DF backend with EngineCapability.UNION — needed because UNION is opt-in. */
            rb,
            List.of(),
        RexBuilder rb = scan.getCluster().getRexBuilder();
        RelNode result = runPlanner(plan, singleShardContext());
                        OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], mode=[PARTIAL], viableBackends=[[mock-parquet]])
public class WindowPlanShapeTests extends PlanShapeTestBase {
            List.of("status", "size", "running_s")
    }
            scan,
        );
        RelNode result = runPlanner(plan, singleShardContext());
            union,
            RexWindowBounds.UNBOUNDED_PRECEDING,
            scan,
            RexWindowBounds.CURRENT_ROW
        assertPlanShape("""
     * Non-default frame: SUM(x) OVER (ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) —
            result
    }
            RexWindowBounds.UNBOUNDED_PRECEDING,
            """
import org.apache.calcite.rel.core.CorrelationId;
        LogicalAggregate agg = makeAggregate(stubScan(mockTable("test_index", "status", "size")), sumCall());
        RelNode result = runPlanner(plan, multiShardContext());
            """
        RelNode result = runPlanner(plan, multiShardContext());
     * Verifies an Aggregate atop a window doesn't re-split into PARTIAL+FINAL.
            List.of(),
            false,
     *  Empty PARTITION BY and empty ORDER BY. */
            List.of(rb.makeInputRef(union, 1)),
        assertPlanShape(
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            true,
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RexNode runningSum = makeOver(
        RelNode plan = LogicalProject.create(
     * <p>SQL semantics: with ORDER BY but no explicit frame, the implicit frame is RANGE
        RelOptTable right = mockTable("right_idx", "status", "size");
            List.of("status", "size", "s")
            ImmutableList.of(),
            true,
            LogicalProject(status=[$0], total_size=[$1], grand_total=[SUM($1) OVER ()])
        RexBuilder rb = filter.getCluster().getRexBuilder();
                      OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], mode=[PARTIAL], viableBackends=[[mock-parquet]])
        );
            List.of(rb.makeInputRef(scan, 0), rb.makeInputRef(scan, 1), countOver, sumOver),
        RexNode cond = rexBuilder.makeCall(
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RelNode plan = LogicalProject.create(
     * Sort's output IS the SINGLETON the Project demands.
              LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
     * exchange shape.
    /** Same as {@link #projectWithSumOverEmpty()} but stacked on a caller-supplied input
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RelNode join = makeDifferentTablesJoin();
     * leaves order-by passthrough; this case pins both axes simultaneously.
     * to a {@code projectPlus} of {@code ROW_NUMBER() OVER (ROWS UNBOUNDED PRECEDING TO
        return LogicalJoin.create(stubScan(left), stubScan(right), List.of(), cond, java.util.Set.<CorrelationId>of(), JoinRelType.INNER);
     */
        assertPlanShape("""
            result
            List.of("status", "size", "rank_per_status")
            LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
     *  (Filter, Sort, etc.). Input must have at least 2 fields ($0 status, $1 size). */
        );
            SqlTypeName.BIGINT,
    }
        RelNode plan = LogicalProject.create(
            alias
        assertPlanShape("""
    /**
            RexWindowBounds.UNBOUNDED_FOLLOWING
                OpenSearchProject(status=[$0], size=[$1], running_sum=[SUM($1) OVER (ROWS UNBOUNDED PRECEDING)], viableBackends=[[mock-parquet]])
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        assertPlanShape(
        // Outer agg consumes BOTH cnt ($1) and window col s ($2) so neither is dead.
            SqlTypeName.BIGINT,
        RelNode plan = LogicalProject.create(
        assertPlanShape(
                """,
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RexNode over = rb.makeOver(
        );
        );
        AggregateCallOnWindowedProject sizeAgg = aggCallOver(filter, /* size */ 1, "total_size");
            List.of("status", "size", "s")
     * 1-shard with empty OVER(). Scan emits SHARD+SINGLETON which satisfies the Project's
            false,
     * {@code getInput(0)} hop — which in Volcano is a RelSubset, not a concrete rel. The walk must
            """, plan);
            SqlStdOperatorTable.SUM,
              LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
     * matters for streamstats … by … reachability.
              StubTableScan(table=[[test_index]])
     * PARTIAL+FINAL pair.
                """,
     * ER. Join emits COORDINATOR+SINGLETON which satisfies the windowed Project's cost gate —
    public void testSumOverEmpty_2shard() {
     * Two aggregates with a global window between them (PPL: {@code stats count() by k | eval
    /** Self-join on test_index — used by {@link #testWindowAfterJoin_1shard} for the
     * HAVING-like Filter sits ABOVE a windowed Project (1-shard). The Project's cost gate is
            lowerBound,
     * no second ER above Join.
        RelNode result = runPlanner(plan, multiShardContext());
    }
        RelNode plan = makeAggregate(windowedProject, sizeAgg.aggCall, sAgg.aggCall);
            typeFactory.createSqlType(SqlTypeName.BIGINT),
            List.of(),
                """,
            RexWindowBounds.UNBOUNDED_PRECEDING,
            rb,
    /**
     * resolve the subset (getBestOrOriginal) to still find the window below the Filter; otherwise the
            OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-parquet], =($2, 100))], viableBackends=[[mock-parquet]])
            """
        RexBuilder rb = join.getCluster().getRexBuilder();
     * sequence pinned by an ORDER BY. The existing tests cover ROW_NUMBER OVER () alone and
    private RexNode makeOver(
        );
            List.of(sumFieldIndex),
 * SPDX-License-Identifier: Apache-2.0
     * SHARD+SINGLETON Scan; the follow-on Aggregate stays SINGLE (input is already SINGLETON).
        );
     * {@code RANK() OVER (PARTITION BY $0 ORDER BY $1)} on a 2-shard scan. RANK joined the
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                StubTableScan(table=[[test_index]])
 */
    public void testAggregateAfterWindow_2shard() {
        AggregateCallOnWindowedProject sAgg = aggCallOver(windowedProject, /* window col */ 2, "total_s", SqlTypeName.BIGINT);
                  StubTableScan(table=[[test_index]])
    /** Holder for the AggregateCall used by {@link #testAggregateAfterWindow_1shard}/_2shard. */
                StubTableScan(table=[[test_index]])
     * CURRENT ROW)} as a helper sequence column. ROW_NUMBER joined the WindowFunction enum in
                OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RelOptTable table = mockTable("test_index", "status", "size");
        RelNode windowed = projectWithSumOverEmpty();
            RexWindowBounds.UNBOUNDED_FOLLOWING,
            result
        );
        assertPlanShape("""
            false
                """,
        RelNode plan = LogicalProject.create(
import java.util.List;
            false
            LogicalProject(status=[$0], size=[$1], s=[SUM($1) OVER ()])
                """,
        );
        RelNode result = runPlanner(plan, multiShardContext());
            List.of(),
        RelNode plan = LogicalProject.create(
        assertPlanShape("""
    private PlannerContext unionContext(String indexName, int shardCount) {
        RelOptTable table = mockTable("test_index", "status", "size");
            """
            result
            List.of(),
        RelNode union = LogicalUnion.create(List.of(leftScan, rightScan), /* all */ true);
     * The Project's RexOver cost gate forces an ER below the Project; Sort is collated and
            List.of(),
            rb,
            RexWindowBounds.UNBOUNDED_PRECEDING,
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(plan, unionContext("test_index", 2));
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
                StubTableScan(table=[[left_idx]])
     * GROUP BY + HAVING + window: {@code Project(SUM($1) OVER (), Filter(=$1,100, Aggregate))}.
        RelNode rightScan = stubScan(mockTable("test_index", "status", "size"));
            false
                        OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])
import org.opensearch.analytics.spi.EngineCapability;
            List.of("status", "total_size", "grand_total")
              LogicalFilter(condition=[=($0, 200)])
        );
            false
            """, plan);
              LogicalFilter(condition=[=($1, 100)])
    /**
    /**
            List.of(rb.makeInputRef(input, 1)),
