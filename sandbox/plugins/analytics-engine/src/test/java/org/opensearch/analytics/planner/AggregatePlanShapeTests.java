     */
                """,
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
    public void testStatsCountStarByKey_1shard() {
        // AVG → SUM/COUNT primitives plus a Project for the quotient; SINGLE only.
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        RelOptTable table = mockTable("test_index", "status", "size");
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            """, result);
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        assertPlanShape(
import org.apache.calcite.plan.RelOptTable;
        );
     */
    // ---- grouped on the partial-state column and produced spurious un-coalesced buckets. ----
        assertPlanShape("""
 *
        RelNode result = runPlanner(plan, singleShardContext());
 * <p>1-shard inputs: {@code Aggregate(SINGLE)} runs at the shard, ER above.
    public void testCountDistinct_2shard() {
 * The OpenSearch Contributors require contributions made to
        String plan = result.explain();
            OpenSearchAggregate(group=[{0}], dc=[APPROX_COUNT_DISTINCT($1)], mode=[SINGLE], viableBackends=[[mock-parquet]])
    }
        // Field trimming inserts Project(status) above the scan — count-by-key needs only the group key.
                """,
     * {@code OpenSearchAggregateSplitRule.wrapWithCastIfNeeded} — without it, Volcano rejects
/**
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
    }
                  OpenSearchAggregate(group=[{}], cnt=[SUM($0)], mode=[FINAL], viableBackends=[[mock-parquet]])
            """
    // ---- hash-partitioning, group key and sort. AGGREGATE_PROJECT_PULL_UP_CONSTANTS drops it ----
                OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
import org.apache.calcite.sql.type.SqlTypeName;
                    OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], mode=[PARTIAL], viableBackends=[[mock-parquet]])
     * keeps the {@code APPROX_COUNT_DISTINCT} operator (engine-native merge: reducer == self), reads
        RelNode plan = makeAggregate(scan, countDistinctCall(scan));
        assertTrue(
        );
                """,
            """
            result
                OpenSearchProject(status=[$0], avg_size=[ANNOTATED_PROJECT_EXPR(id=3, backends=[mock-parquet], CAST(ANNOTATED_PROJECT_EXPR(id=2, backends=[mock-parquet], /($1, $2))):INTEGER NOT NULL)], viableBackends=[[mock-parquet]])
            result
                OpenSearchProject(status=[$0], checked_total_size=[ANNOTATED_PROJECT_EXPR(id=1, backends=[mock-parquet], CAST($1):BIGINT)], viableBackends=[[mock-parquet]])
                    OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
     */
        );
        );
    public void testStatsAvgByKey_1shard() {
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
                """,
 */
        RelNode result = runPlanner(plan, multiShardContext());
    public void testNativeAndCheckedLongSumOnSameField_2shard() {
            """, result);
        AggregateCall count = AggregateCall.create(
    /**
        AggregateCall sum = AggregateCall.create(
                OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
import org.apache.calcite.rel.RelNode;
        // carried {1} and grouped on the SUM column instead of the key.
 * SPDX-License-Identifier: Apache-2.0
        );
    public void testNonPrefixGroupSet_2shard() {
              OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(plan, multiShardContext());
                  OpenSearchAggregate(group=[{0}], checked_total_size=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
    public void testConstantGroupKeyIsPulledUp() {
                """,
    public void testStatsSumCountByKey_1shard() {
        assertFalse("constant must not remain a group key:\n" + plan, plan.contains("group=[{0, 1}]"));
            result
        assertPlanShape("""
 * ER in between.
            result
        RelNode scan = stubScan(table);
            """
            result
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
    /** Empty-group count(), single-shard. SINGLE alternative; no split, no wrap. */
        RelNode result = runPlanner(plan, singleShardContext());
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                  OpenSearchAggregate(group=[{0}], agg#0=[SUM($1)], agg#1=[COUNT()], mode=[SINGLE], viableBackends=[[mock-parquet]])
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            result
            List.of(rexBuilder.makeExactLiteral(java.math.BigDecimal.ONE, intType), rexBuilder.makeInputRef(intType, 0)),
     * {@code APPROX_COUNT_DISTINCT(x)}, then no split (single shard). SINGLE at the shard.
                OpenSearchProject(status=[$0], avg_size=[ANNOTATED_PROJECT_EXPR(id=3, backends=[mock-parquet], CAST(ANNOTATED_PROJECT_EXPR(id=2, backends=[mock-parquet], /($1, $2))):INTEGER NOT NULL)], viableBackends=[[mock-parquet]])
    }
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        RelNode plan = makeAggregate(scan, countDistinctCall(scan));
    public void testStatsSumByKey_2shard() {
            List.of(),
        );
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
            OpenSearchAggregate(group=[{1}], total_status=[SUM($0)], mode=[SINGLE], viableBackends=[[mock-parquet]])
            """, result);
        RelNode plan = makeAggregate(scan, countStarCall(scan));
package org.opensearch.analytics.planner;
     * 1-shard {@code COUNT(DISTINCT x)} — the HEP {@code OpenSearchDistinctCountRule} rewrites to
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(plan, singleShardContext());
        // Project(const=1, status) — mirrors `eval const = 1 | stats count() by const, status`
                      OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
    // ---- DataFusion can no longer tell it is constant. The literal then rides through the ----
                      OpenSearchAggregate(group=[{0}], checked_total_size=[SUM($1)], mode=[PARTIAL], viableBackends=[[mock-parquet]])
    }
        RelNode result = runPlanner(plan, multiShardContext());
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                """,
    // ---- Non-prefix groupSet: agg arg projected BEFORE the group key (the `avg(x) by span(y,5)` ----
    // ---- from the group set and re-attaches it above. ClickBench q35: 3.07s -> see report. ----
        // FINAL groups on {0} (key fronted by PARTIAL), NOT the original {1}. Before the fix FINAL
                    OpenSearchAggregate(group=[{0}], dc=[APPROX_COUNT_DISTINCT($1)], mode=[PARTIAL], viableBackends=[[mock-parquet]])
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
            List.of(0),
    public void testStatsCountStar_emptyGroup_1shard() {
 *
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            """, result);
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            "aggregate should group on the non-constant key only:\n" + plan,
    }
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        );
                OpenSearchAggregate(group=[{0}], total_status=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
            List.of(),
        RelNode plan = makeAggregate(scan, ImmutableBitSet.of(0), sumCall(scan), countStarCall(scan));
        RelNode plan = makeAggregate(scan, ImmutableBitSet.of(0), avgCall(scan));
        );
    // ---- shape). PARTIAL fronts the key per Calcite's contract, so FINAL must group on the prefix ----
            typeFactory.createSqlType(SqlTypeName.BIGINT),
    }
            SqlStdOperatorTable.SUM,
 * compatible open source license.
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                  OpenSearchAggregate(group=[{0}], checked_total_size=[SUM($1)], mode=[SINGLE], viableBackends=[[mock-parquet]])
        assertPlanShape(
import org.apache.calcite.rel.type.RelDataType;
            List.of("const", "status")
        RelNode plan = makeAggregate(scan, sumCall(scan));
        RelNode plan = makeAggregate(scan, sumCall(scan));
        assertPlanShape(
    /**
        assertPlanShape("""
            """
                      OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], checked_total_size=[SUM($1)], mode=[PARTIAL], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(plan, singleShardContext());
    public void testStatsSumCountByKey_2shard() {
    }
    public void testNonPrefixGroupSet_1shard() {
                """,
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            false,
        RelNode plan = makeAggregate(scan, checkedLongSumCall(scan));
        );
        RelNode result = runPlanner(plan, singleShardContext());
    }
import org.apache.calcite.rel.core.AggregateCall;
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                      OpenSearchAggregate(group=[{}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        RelNode plan = makeAggregate(scan, ImmutableBitSet.of(0), sumCall(scan), checkedLongSumCall(scan));
    // ---- range {0}, NOT the original {1}. Regression guard for the multi-shard span bug where FINAL ----
            """, result);
                OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], cnt=[SUM($2)], mode=[FINAL], viableBackends=[[mock-parquet]])
                      OpenSearchAggregate(group=[{0}], agg#0=[SUM($1)], agg#1=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
     * column to {@code VARBINARY} (HLL sketch state) downstream during DAG-cut + fragment conversion.
    }
    }
}
            OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], cnt=[COUNT()], mode=[SINGLE], viableBackends=[[mock-parquet]])
            SqlStdOperatorTable.COUNT,
            """
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        // AVG decomposes pre-split; FINAL receives the reduced primitives.
        RelNode plan = makeAggregate(scan, ImmutableBitSet.of(), countStarCall(scan));
    // ---- literal into a Project column, so the aggregate groups on a column *reference* and ----
                """,
            "c"
            -1,
                OpenSearchProject(status=[$0], total_size=[$1], checked_total_size=[ANNOTATED_PROJECT_EXPR(id=2, backends=[mock-parquet], CAST($2):BIGINT)], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(plan, singleShardContext());
            """
public class AggregatePlanShapeTests extends PlanShapeTestBase {
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
import java.util.List;
            """
            "total_status"
        RelNode plan = makeAggregate(scan, ImmutableBitSet.of(0), avgCall(scan));
    public void testStatsAvgByKey_2shard() {
        RelNode plan = makeAggregate(scan, countStarCall(scan));
            scan,
                """,
        assertPlanShape("""
            """
        // FINAL's COUNT is rebuilt as SUM($1) by the COUNT→SUM swap in FinalAggCallBuilder.
        RelNode result = runPlanner(agg, singleShardContext());
            project,
        assertPlanShape(
            """
    public void testCountDistinct_1shard() {
        return makeAggregate(scan, ImmutableBitSet.of(1), sum);
                  OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], checked_total_size=[SUM($2)], mode=[FINAL], viableBackends=[[mock-parquet]])
        assertPlanShape("""
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        LogicalProject project = LogicalProject.create(
        RelNode agg = makeAggregate(project, ImmutableBitSet.of(0, 1), count);
    public void testCheckedLongSumRewrittenBeforeMarking_1shard() {
    }
     * split via {@link org.opensearch.analytics.planner.rules.OpenSearchAggregateSplitRule}. FINAL
        assertPlanShape(
        RelNode result = runPlanner(plan, multiShardContext());
            result
                    OpenSearchAggregate(group=[{1}], total_status=[SUM($0)], mode=[PARTIAL], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(nonPrefixGroupedSum(), singleShardContext());
    // ---- COUNT(DISTINCT x) → APPROX_COUNT_DISTINCT(x) (engine-native HLL sketch merge) ----
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        );
                OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
     * Empty-group count(), multi-shard. The Project on top is the CAST-wrap from
        RelNode plan = makeAggregate(scan, checkedLongSumCall(scan));
        );
        RelNode plan = makeAggregate(scan, ImmutableBitSet.of(0), sumCall(scan), countStarCall(scan));
            -1,
        assertPlanShape(
        assertPlanShape("""
        assertPlanShape(
        );
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
                OpenSearchProject(status=[$0], checked_total_size=[ANNOTATED_PROJECT_EXPR(id=1, backends=[mock-parquet], CAST($1):BIGINT)], viableBackends=[[mock-parquet]])
                  OpenSearchAggregate(group=[{0}], $f1=[SUM($1)], $f2=[SUM($2)], mode=[FINAL], viableBackends=[[mock-parquet]])
    /**
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
            """, result);
 */
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                """,
        );
            result
    public void testCheckedLongSumRewrittenBeforeSplit_2shard() {
    }
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
import org.apache.calcite.util.ImmutableBitSet;
 * this file be licensed under the Apache-2.0 license or a
        RelNode result = runPlanner(plan, multiShardContext());
 * <p>Multi-shard: {@code OpenSearchAggregateSplitRule} splits into PARTIAL/FINAL with an
        RelNode result = runPlanner(nonPrefixGroupedSum(), multiShardContext());
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            OpenSearchAggregate(group=[{}], cnt=[COUNT()], mode=[SINGLE], viableBackends=[[mock-parquet]])
    }
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RelNode scan = stubScan(mockNullableTable("test_index", "status", "size"));
                OpenSearchProject(cnt=[CAST($0):BIGINT NOT NULL], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(plan, multiShardContext());
        RelNode result = runPlanner(plan, multiShardContext());
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            result
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], mode=[SINGLE], viableBackends=[[mock-parquet]])
        // SINGLE aggregate carries both calls; no split, no rebase.
            """
     * column $1 of the gathered exchange. {@code DistributedAggregateRewriter} retypes the exchange
            result
    }
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
 * Plan-shape tests for {@link org.opensearch.analytics.planner.rel.OpenSearchAggregate}.
        assertPlanShape(
            scan,
                OpenSearchAggregate(group=[{0}], dc=[APPROX_COUNT_DISTINCT($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
            OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[SINGLE], viableBackends=[[mock-parquet]])
    /** Builds sum(col0) grouped by col1 → non-prefix groupSet {1}. */
    public void testStatsCountStar_emptyGroup_2shard() {
    }
    }
        );
        );
        assertPlanShape(
        RelNode scan = stubScan(mockNullableTable("test_index", "status", "size"));
    public void testStatsCountStarByKey_2shard() {
    private RelNode nonPrefixGroupedSum() {
                """,
        assertPlanShape(
            """
                    OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(plan, singleShardContext());
        RelNode plan = makeAggregate(scan, ImmutableBitSet.of(), countStarCall(scan));
    public void testStatsSumByKey_1shard() {
     * Multi-shard {@code COUNT(DISTINCT x)} — rewritten to {@code APPROX_COUNT_DISTINCT(x)} and then
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            plan.contains("group=[{0}]") || plan.contains("group=[{1}]")
            false,
            typeFactory.createSqlType(SqlTypeName.INTEGER),
        // FINAL: SUM stays (engine-native merge), COUNT→SUM($2) via FinalAggCallBuilder.
import org.apache.calcite.rel.logical.LogicalProject;
    }
        assertPlanShape(
        RelNode scan = stubScan(mockNullableTable("test_index", "status", "size"));
    }
            result
    }
     * FINAL's nullable BIGINT against SINGLE's BIGINT NOT NULL.
        RelNode result = runPlanner(plan, multiShardContext());
    // ---- Constant group keys: PPL's `eval c = 1 | stats count() by c, URL` materialises the ----
        // Field trimming inserts Project(status) above the scan — count-by-key needs only the group key.
/*
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
