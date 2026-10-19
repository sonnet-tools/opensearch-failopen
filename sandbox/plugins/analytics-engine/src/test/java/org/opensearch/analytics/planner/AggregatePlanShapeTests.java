                """,  
                OpenSearchProject(status=[$0], checked_total_size=[ANNOTATED_PROJECT_EXPR(id=1, backends=[mock-parquet], CAST($1):BIGINT)], viableBackends=[[mock-parquet]])
            result  
    }
    public void testNonPrefixGroupSet_2shard() {
        return makeAggregate(scan, ImmutableBitSet.of(1), sum);
                  OpenSearchAggregate(group=[{0}], checked_total_size=[SUM($1)], mode=[SINGLE], viableBackends=[[mock-parquet]])  
            -1,  
                  OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], checked_total_size=[SUM($2)], mode=[FINAL], viableBackends=[[mock-parquet]])  
        assertFalse("constant must not remain a group key:\n" + plan, plan.contains("group=[{0, 1}]"));
        assertPlanShape(  
                    OpenSearchAggregate(group=[{0}], dc=[APPROX_COUNT_DISTINCT($1)], mode=[PARTIAL], viableBackends=[[mock-parquet]])
            result
     * column $1 of the gathered exchange. {@code DistributedAggregateRewriter} retypes the exchange  
                OpenSearchProject(cnt=[CAST($0):BIGINT NOT NULL], viableBackends=[[mock-parquet]])  
 * ER in between.
                      OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])  
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
        RelNode result = runPlanner(plan, multiShardContext());  
            """, result);
            project,
        RelNode result = runPlanner(plan, singleShardContext());
                OpenSearchProject(status=[$0], avg_size=[ANNOTATED_PROJECT_EXPR(id=3, backends=[mock-parquet], CAST(ANNOTATED_PROJECT_EXPR(id=2, backends=[mock-parquet], /($1, $2))):INTEGER NOT NULL)], viableBackends=[[mock-parquet]])
        assertPlanShape("""
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        );  
    }
            """, result);
            List.of(rexBuilder.makeExactLiteral(java.math.BigDecimal.ONE, intType), rexBuilder.makeInputRef(intType, 0)),
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
    }
            "total_status"  
        assertPlanShape(
     * {@code APPROX_COUNT_DISTINCT(x)}, then no split (single shard). SINGLE at the shard.
        AggregateCall sum = AggregateCall.create(
    // ---- Constant group keys: PPL's `eval c = 1 | stats count() by c, URL` materialises the ----  
                """,
        String plan = result.explain();  
    /** Builds sum(col0) grouped by col1 → non-prefix groupSet {1}. */
            List.of("const", "status")  
            result
import org.apache.calcite.rel.core.AggregateCall;  
    // ---- DataFusion can no longer tell it is constant. The literal then rides through the ----
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
     * 1-shard {@code COUNT(DISTINCT x)} — the HEP {@code OpenSearchDistinctCountRule} rewrites to
            """, result);
            SqlStdOperatorTable.SUM,  
    public void testStatsSumCountByKey_2shard() {
        assertPlanShape("""
        RelNode plan = makeAggregate(scan, ImmutableBitSet.of(0), sumCall(scan), checkedLongSumCall(scan));
 * SPDX-License-Identifier: Apache-2.0
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                OpenSearchProject(status=[$0], total_size=[$1], checked_total_size=[ANNOTATED_PROJECT_EXPR(id=2, backends=[mock-parquet], CAST($2):BIGINT)], viableBackends=[[mock-parquet]])
            SqlStdOperatorTable.COUNT,  
            typeFactory.createSqlType(SqlTypeName.INTEGER),
            result
    }  
 */  
                OpenSearchProject(status=[$0], checked_total_size=[ANNOTATED_PROJECT_EXPR(id=1, backends=[mock-parquet], CAST($1):BIGINT)], viableBackends=[[mock-parquet]])
            """
        assertPlanShape("""
        // Project(const=1, status) — mirrors `eval const = 1 | stats count() by const, status`
        );  
    private RelNode nonPrefixGroupedSum() {  
    // ---- literal into a Project column, so the aggregate groups on a column *reference* and ----
            """
    }  
                      OpenSearchAggregate(group=[{0}], agg#0=[SUM($1)], agg#1=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
    // ---- COUNT(DISTINCT x) → APPROX_COUNT_DISTINCT(x) (engine-native HLL sketch merge) ----
        assertPlanShape(
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
            scan,  
        RelNode result = runPlanner(plan, singleShardContext());  
    /**
            OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], cnt=[COUNT()], mode=[SINGLE], viableBackends=[[mock-parquet]])
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(plan, multiShardContext());
            result
    /** Empty-group count(), single-shard. SINGLE alternative; no split, no wrap. */
    public void testStatsAvgByKey_2shard() {  
        assertPlanShape(  
import org.apache.calcite.plan.RelOptTable;
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
 * compatible open source license.
        assertPlanShape(
                """,
    // ---- shape). PARTIAL fronts the key per Calcite's contract, so FINAL must group on the prefix ----
                """,
                """,  
        );
        RelNode plan = makeAggregate(scan, countStarCall(scan));  
                """,
        // AVG → SUM/COUNT primitives plus a Project for the quotient; SINGLE only.
                      OpenSearchAggregate(group=[{0}], checked_total_size=[SUM($1)], mode=[PARTIAL], viableBackends=[[mock-parquet]])
        assertPlanShape("""
    public void testStatsSumByKey_2shard() {
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        // FINAL's COUNT is rebuilt as SUM($1) by the COUNT→SUM swap in FinalAggCallBuilder.
    // ---- grouped on the partial-state column and produced spurious un-coalesced buckets. ----  
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
        RelNode result = runPlanner(plan, singleShardContext());  
public class AggregatePlanShapeTests extends PlanShapeTestBase {
    public void testConstantGroupKeyIsPulledUp() {  
                OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])  
    public void testStatsAvgByKey_1shard() {  
    }  
                      OpenSearchAggregate(group=[{}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])  
    }
    }
                  OpenSearchAggregate(group=[{0}], agg#0=[SUM($1)], agg#1=[COUNT()], mode=[SINGLE], viableBackends=[[mock-parquet]])
     * column to {@code VARBINARY} (HLL sketch state) downstream during DAG-cut + fragment conversion.
        );
 *
        assertPlanShape(
                    OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
    public void testStatsCountStar_emptyGroup_2shard() {  
    public void testNativeAndCheckedLongSumOnSameField_2shard() {
            result
            """
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    public void testNonPrefixGroupSet_1shard() {
                OpenSearchAggregate(group=[{0}], total_status=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
        LogicalProject project = LogicalProject.create(
import org.apache.calcite.rel.logical.LogicalProject;
        RelNode plan = makeAggregate(scan, sumCall(scan));  
        RelNode result = runPlanner(nonPrefixGroupedSum(), multiShardContext());
        RelNode plan = makeAggregate(scan, ImmutableBitSet.of(0), avgCall(scan));  
        assertTrue(
     */  
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        );
 *
    public void testStatsSumCountByKey_1shard() {
        // FINAL: SUM stays (engine-native merge), COUNT→SUM($2) via FinalAggCallBuilder.
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
package org.opensearch.analytics.planner;
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));  
    }  
        RelNode result = runPlanner(plan, multiShardContext());
        );
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
import org.apache.calcite.rel.type.RelDataType;
        );
            OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[SINGLE], viableBackends=[[mock-parquet]])
            OpenSearchAggregate(group=[{}], cnt=[COUNT()], mode=[SINGLE], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(plan, singleShardContext());
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));  
        RelNode plan = makeAggregate(scan, ImmutableBitSet.of(), countStarCall(scan));
        assertPlanShape(  
        assertPlanShape("""  
                OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
        AggregateCall count = AggregateCall.create(
    public void testCheckedLongSumRewrittenBeforeSplit_2shard() {
     * Empty-group count(), multi-shard. The Project on top is the CAST-wrap from
                  OpenSearchAggregate(group=[{0}], $f1=[SUM($1)], $f2=[SUM($2)], mode=[FINAL], viableBackends=[[mock-parquet]])
/*  
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
    }
                    OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], mode=[PARTIAL], viableBackends=[[mock-parquet]])
            result  
        RelNode result = runPlanner(plan, multiShardContext());
    // ---- range {0}, NOT the original {1}. Regression guard for the multi-shard span bug where FINAL ----
    public void testCountDistinct_1shard() {
            """, result);
    // ---- hash-partitioning, group key and sort. AGGREGATE_PROJECT_PULL_UP_CONSTANTS drops it ----  
     * FINAL's nullable BIGINT against SINGLE's BIGINT NOT NULL.
        assertPlanShape("""
                    OpenSearchAggregate(group=[{1}], total_status=[SUM($0)], mode=[PARTIAL], viableBackends=[[mock-parquet]])  
 */  
            """  
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                """,
        RelNode plan = makeAggregate(scan, ImmutableBitSet.of(), countStarCall(scan));
        RelNode result = runPlanner(plan, singleShardContext());
        RelNode plan = makeAggregate(scan, ImmutableBitSet.of(0), sumCall(scan), countStarCall(scan));
        RelNode plan = makeAggregate(scan, countStarCall(scan));
        );
        // SINGLE aggregate carries both calls; no split, no rebase.  
        // Field trimming inserts Project(status) above the scan — count-by-key needs only the group key.
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            List.of(),
        RelNode scan = stubScan(mockNullableTable("test_index", "status", "size"));  
        RelNode result = runPlanner(plan, multiShardContext());
        // FINAL groups on {0} (key fronted by PARTIAL), NOT the original {1}. Before the fix FINAL
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);  
import org.apache.calcite.util.ImmutableBitSet;
        RelNode plan = makeAggregate(scan, ImmutableBitSet.of(0), sumCall(scan), countStarCall(scan));
        RelNode result = runPlanner(plan, multiShardContext());  
     */
            OpenSearchAggregate(group=[{1}], total_status=[SUM($0)], mode=[SINGLE], viableBackends=[[mock-parquet]])
            typeFactory.createSqlType(SqlTypeName.BIGINT),
                OpenSearchAggregate(group=[{0}], dc=[APPROX_COUNT_DISTINCT($1)], mode=[FINAL], viableBackends=[[mock-parquet]])  
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        );
    public void testStatsCountStarByKey_2shard() {
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
        RelNode scan = stubScan(mockNullableTable("test_index", "status", "size"));  
            result
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
            scan,
        RelNode plan = makeAggregate(scan, checkedLongSumCall(scan));
            result  
/**  
    // ---- from the group set and re-attaches it above. ClickBench q35: 3.07s -> see report. ----
import org.apache.calcite.rel.RelNode;
            result  
        RelNode plan = makeAggregate(scan, sumCall(scan));
 * <p>Multi-shard: {@code OpenSearchAggregateSplitRule} splits into PARTIAL/FINAL with an
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            List.of(),
    }  
                """,
        );
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        // AVG decomposes pre-split; FINAL receives the reduced primitives.
    public void testStatsCountStar_emptyGroup_1shard() {  
            """
            """
    /**
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));  
            """  
    public void testStatsSumByKey_1shard() {
                """,
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
            """, result);
}
                  OpenSearchAggregate(group=[{}], cnt=[SUM($0)], mode=[FINAL], viableBackends=[[mock-parquet]])
     * {@code OpenSearchAggregateSplitRule.wrapWithCastIfNeeded} — without it, Volcano rejects  
                OpenSearchProject(status=[$0], avg_size=[ANNOTATED_PROJECT_EXPR(id=3, backends=[mock-parquet], CAST(ANNOTATED_PROJECT_EXPR(id=2, backends=[mock-parquet], /($1, $2))):INTEGER NOT NULL)], viableBackends=[[mock-parquet]])
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        );
 * this file be licensed under the Apache-2.0 license or a
            result
        RelNode plan = makeAggregate(scan, countDistinctCall(scan));
 * The OpenSearch Contributors require contributions made to  
     * split via {@link org.opensearch.analytics.planner.rules.OpenSearchAggregateSplitRule}. FINAL
                """,  
            """
                """,  
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        RelNode plan = makeAggregate(scan, ImmutableBitSet.of(0), avgCall(scan));  
            -1,  
            """  
    }
    public void testCheckedLongSumRewrittenBeforeMarking_1shard() {
        RelNode result = runPlanner(plan, multiShardContext());
    }
            OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], mode=[SINGLE], viableBackends=[[mock-parquet]])  
        RelNode scan = stubScan(mockNullableTable("test_index", "status", "size"));
            "c"  
    }
        RelNode scan = stubScan(table);
    /**  
                    OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
    }  
import org.apache.calcite.sql.type.SqlTypeName;
        RelNode result = runPlanner(plan, singleShardContext());
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
              OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
        RelNode plan = makeAggregate(scan, checkedLongSumCall(scan));  
        );
        RelNode result = runPlanner(agg, singleShardContext());
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        assertPlanShape(
    public void testStatsCountStarByKey_1shard() {
        assertPlanShape(
            OpenSearchAggregate(group=[{0}], dc=[APPROX_COUNT_DISTINCT($1)], mode=[SINGLE], viableBackends=[[mock-parquet]])  
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
            """, result);
        );  
                OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], cnt=[SUM($2)], mode=[FINAL], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(nonPrefixGroupedSum(), singleShardContext());  
        // carried {1} and grouped on the SUM column instead of the key.  
        RelNode agg = makeAggregate(project, ImmutableBitSet.of(0, 1), count);
    }
        assertPlanShape(  
            false,
     */
            """
        // Field trimming inserts Project(status) above the scan — count-by-key needs only the group key.  
        RelNode result = runPlanner(plan, multiShardContext());
            false,
        RelNode plan = makeAggregate(scan, countDistinctCall(scan));  
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        );
    }  
        );
                OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(plan, singleShardContext());
 * Plan-shape tests for {@link org.opensearch.analytics.planner.rel.OpenSearchAggregate}.
                  OpenSearchAggregate(group=[{0}], checked_total_size=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
    }
                      OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], checked_total_size=[SUM($1)], mode=[PARTIAL], viableBackends=[[mock-parquet]])
            "aggregate should group on the non-constant key only:\n" + plan,  
    }  
        assertPlanShape(
    // ---- Non-prefix groupSet: agg arg projected BEFORE the group key (the `avg(x) by span(y,5)` ----  
    public void testCountDistinct_2shard() {  
            List.of(0),
        RelOptTable table = mockTable("test_index", "status", "size");
 * <p>1-shard inputs: {@code Aggregate(SINGLE)} runs at the shard, ER above.  
            plan.contains("group=[{0}]") || plan.contains("group=[{1}]")
import java.util.List;
            """  
     * Multi-shard {@code COUNT(DISTINCT x)} — rewritten to {@code APPROX_COUNT_DISTINCT(x)} and then  
     * keeps the {@code APPROX_COUNT_DISTINCT} operator (engine-native merge: reducer == self), reads
