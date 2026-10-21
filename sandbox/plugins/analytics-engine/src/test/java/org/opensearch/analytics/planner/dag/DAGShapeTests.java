            -1,
 *
            dag
                Stage 2
        PlannerContext context = buildContext("parquet", 1, intFields());
        );
            sb.setLength(sb.length() - 1);
            List.of(),
import java.util.List;
        RelNode cboOutput = runPlanner(logicalPlan, context);
            null,
                      OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
import org.apache.logging.log4j.LogManager;
        LOGGER.info("Marked+CBO RelNode:\n{}", RelOptUtil.toString(cboOutput));
        StringBuilder sb = new StringBuilder();
import org.apache.calcite.sql.type.SqlTypeName;
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
import org.apache.calcite.rel.logical.LogicalProject;
        // Consume left.size ($1) and right.size ($3) so neither join arm is trimmed below
    }
            RelCollations.EMPTY,
                  Stage 1 exchange=SINGLETON
    // Case 1 (1-shard same table) — co-location fast path. Both inputs scan the same 1-shard
 * DAG-shape tests that lock in the exact {@link QueryDAG#toString()} output for representative
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
                Stage 2
                      OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])
        );
        return dagStr.replaceFirst("queryId=[0-9a-fA-F-]+", "queryId=<random>");
                    OpenSearchJoin(condition=[=($0, $2)], joinType=[left], viableBackends=[[mock-parquet]])
                  Stage 1 exchange=SINGLETON
    /** Multi-shard: PARTIAL on shards, FINAL at coord; Sort(fetch=2) above FINAL. */
                    OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[SINGLE], viableBackends=[[mock-parquet]])
                        OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])
import org.apache.calcite.rel.logical.LogicalJoin;
            List.of("status", "size")
                    OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[2], viableBackends=[[mock-parquet]])
 */
                  Stage 0 exchange=SINGLETON
        PlannerContext context = buildContextPerIndex("parquet", Map.of("left_idx", 3, "right_idx", 3));
        );
            org.apache.calcite.util.ImmutableBitSet.of(0),
import org.apache.calcite.rel.RelCollations;
    public void testJoinDag_case4_multiShardDifferentTables() {
            null,
    public void testTopKAfterStatsDag_multiShard() {
            SqlStdOperatorTable.EQUALS,
import org.apache.calcite.rel.type.RelDataType;
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                  OpenSearchAggregate(group=[{}], cnt=[COUNT()], sum_left_size=[SUM($1)], sum_right_size=[SUM($3)], mode=[SINGLE], viableBackends=[[mock-parquet]])
    // index; Join runs at SHARD with no per-side ER. The aggregate above demands SINGLETON,
                  Stage 0 exchange=SINGLETON
    }
import org.apache.calcite.rex.RexNode;
        );
            List.of(),
                  Stage 1 exchange=SINGLETON
              OpenSearchProject(k=[$1], cnt=[$0], viableBackends=[[mock-parquet]])
            """
        );
                Stage 1
        String normalizedActual = normalizeLines(actual);
     */
            dag
    }
                            OpenSearchStageInputScan(childStageId=[1], viableBackends=[[mock-parquet]])
import org.apache.calcite.rel.RelFieldCollation;
import org.apache.calcite.rel.core.JoinRelType;
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
                    OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])
            while (end > 0 && (line.charAt(end - 1) == ' ' || line.charAt(end - 1) == '\t'))
        assertDagShape(
            "cnt"
            innerSwap,
                      OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])
                QueryDAG(queryId=<random>)
import java.util.Map;
        RexNode cond = rexBuilder.makeCall(
        AggregateCall sumLeft = AggregateCall.create(SqlStdOperatorTable.SUM, false, List.of(1), -1, join, intType, "sum_left_size");
            List.of(rexBuilder.makeInputRef(rightScan, 0), rexBuilder.makeInputRef(rightScan, 1)),
            int end = line.length();
                      OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
            List.of("cnt", "k")
    /**
        return dag;
            List.of(rexBuilder.makeInputRef(leftScan, 0), rexBuilder.makeInputRef(leftScan, 1)),
                          OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
     * On mismatch, the full actual output is shown so reviewers see the DAG shape.
 * exchange info propagation) stay in {@link DAGBuilderTests}.
    //
            """
            Stage 0
    }
            rexBuilder.makeLiteral(2, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            agg,
}
        PlannerContext context = buildContext("parquet", 3, intFields());
     * Asserts the {@link QueryDAG#toString()} matches the expected string. Normalizes
                      OpenSearchSort(fetch=[50000], viableBackends=[[mock-parquet]])
package org.opensearch.analytics.planner.dag;
            SqlStdOperatorTable.COUNT,
    }
                        OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])
 * compatible open source license.
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
    }
                  Stage 0 exchange=SINGLETON
        QueryDAG dag = buildDAG(context, buildJoinWithStatsShape("left_idx", "right_idx"));
            """
                    OpenSearchJoin(condition=[=($0, $2)], joinType=[left], viableBackends=[[mock-parquet]])
    // Cases 2-4 — general path. Each input is gathered to coord via a per-side ER → 3 stages.
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        );
        assertEquals("DAG shape mismatch — actual:\n" + actual, normalizedExpected, normalizedActual);
            List.of(),
        LOGGER.info("QueryDAG:\n{}", dag);
                        OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
        return LogicalProject.create(
            "cnt"
    // ── Builders ─────────────────────────────────────────────────────────────
                      OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])
        AggregateCall countCall = AggregateCall.create(
    // ── Join DAG shapes ──────────────────────────────────────────────────────
                """,
        );
                    OpenSearchSort(fetch=[50000], viableBackends=[[mock-parquet]])
    }
                      OpenSearchSort(fetch=[50000], viableBackends=[[mock-parquet]])
        RelNode innerSort = LogicalSort.create(
    public void testJoinDag_case1_singleShardSameTable() {
            List.of(countCall, sumLeft, sumRight)
        while (sb.length() >= 2 && sb.charAt(sb.length() - 1) == '\n' && sb.charAt(sb.length() - 2) == '\n') {
            join,
        );
    //
                QueryDAG(queryId=<random>)
    }
            false,
            List.of("status", "size")
     *  collapses into a single stage. */
            stubScan(mockTable("test_index", "status", "size")),
            false,
            typeFactory.createSqlType(SqlTypeName.BIGINT),
    }
 * The OpenSearch Contributors require contributions made to
            stubScan(mockTable("test_index", "status", "size")),
            dag
                      OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                        OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])
            List.of(rexBuilder.makeInputRef(agg, 1), rexBuilder.makeInputRef(agg, 0)),
        QueryDAG dag = buildDAG(3, buildTopKAfterStats());
                          OpenSearchStageInputScan(childStageId=[0], viableBackends=[[mock-parquet]])
        AggregateCall countCall = AggregateCall.create(
            null,
        assertDagShape(
        QueryDAG dag = buildDAG(context, buildJoinWithStatsShape("test_index", "test_index"));
                      OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])
    // gathered via one ER between Aggregate and Join → 2 stages total.
                      OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
        );
        }
    public void testTopKAfterStatsDag_singleShard() {
/**
            List.of(rexBuilder.makeInputRef(innerSort, 1), rexBuilder.makeInputRef(innerSort, 0)),
                        OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            -1,
        );
        QueryDAG dag = buildDAG(1, buildTopKAfterStats());
    private RelNode buildTopKAfterStats() {
            sb.append(line, 0, end).append('\n');
                  OpenSearchAggregate(group=[{}], cnt=[COUNT()], sum_left_size=[SUM($1)], sum_right_size=[SUM($3)], mode=[SINGLE], viableBackends=[[mock-parquet]])
        );
    }
                  OpenSearchAggregate(group=[{}], cnt=[COUNT()], sum_left_size=[SUM($1)], sum_right_size=[SUM($3)], mode=[SINGLE], viableBackends=[[mock-parquet]])
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
 *
    private static final Logger LOGGER = LogManager.getLogger(DAGShapeTests.class);
                QueryDAG(queryId=<random>)
    // ── Top-K DAG shapes ─────────────────────────────────────────────────────
            dag
        RelNode innerSwap = LogicalProject.create(
        RelOptTable left = mockTable(leftTable, "status", "size");
import org.apache.calcite.rel.logical.LogicalSort;
            List.of(),
                QueryDAG(queryId=<random>)
    private static String stripQueryId(String dagStr) {
                    OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
 * misplaces an ER, or changes stage cuts shows up as a clean diff.
                    OpenSearchJoin(condition=[=($0, $2)], joinType=[left], viableBackends=[[mock-parquet]])
        assertDagShape(
            """, dag);
        RelNode agg = org.apache.calcite.rel.logical.LogicalAggregate.create(
        LOGGER.info("Input RelNode:\n{}", RelOptUtil.toString(logicalPlan));
        PlannerContext context = buildContextPerIndex("parquet", Map.of("left_idx", 1, "right_idx", 1));
    private static void assertDagShape(String expected, QueryDAG dag) {
            dag
import java.util.Set;
        assertDagShape(
        for (String line : s.split("\n", -1)) {
        // [status, size] — keeps the arm Projects and the join condition at =($0, $2).
                      OpenSearchStageInputScan(childStageId=[0], viableBackends=[[mock-parquet]])
                """,
            SqlStdOperatorTable.COUNT,
    public void testJoinDag_case2_multiShardSameTable() {
 * stageInputScan placeholders) at a glance — a regression that shuffles Sort placement,
     *  demand without a gather — AggregateSplit doesn't fire, no ER inserted, whole tree
    }
                QueryDAG(queryId=<random>)
        AggregateCall sumRight = AggregateCall.create(SqlStdOperatorTable.SUM, false, List.of(3), -1, join, intType, "sum_right_size");
            List.of(countCall)
import org.opensearch.analytics.planner.BasePlannerRulesTests;
                    OpenSearchJoin(condition=[=($0, $2)], joinType=[left], viableBackends=[[mock-parquet]])
            """
        var context = buildContext("parquet", shardCount, intFields());
                end--;
    public void testJoinDag_case3_singleShardDifferentTables() {
                """,
                          OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        );
import org.apache.calcite.rel.core.AggregateCall;
 * PPL shapes. String-based assertions give reviewers the full DAG (stages, fragments,
            null,
        );
            List.of(),
            """
            typeFactory.createSqlType(SqlTypeName.BIGINT),
/*
                  OpenSearchProject(k=[$1], cnt=[$0], viableBackends=[[mock-parquet]])
                          OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            List.of(),
        QueryDAG dag = buildDAG(context, buildJoinWithStatsShape("test_index", "test_index"));
                    OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
            rightProject,
                      OpenSearchProject(cnt=[$1], k=[$0], viableBackends=[[mock-parquet]])
                            OpenSearchStageInputScan(childStageId=[1], viableBackends=[[mock-parquet]])
import org.opensearch.analytics.planner.PlannerContext;
        RelNode rightProject = LogicalProject.create(
    private RelNode buildJoinWithStatsShape(String leftTable, String rightTable) {
                Stage 1
        QueryDAG dag = buildDAG(context, buildJoinWithStatsShape("left_idx", "right_idx"));
        String normalizedExpected = normalizeLines(expected);
    private QueryDAG buildDAG(int shardCount, RelNode logicalPlan) {
                      OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RelNode leftProject = LogicalProject.create(
            rightScan,
import org.apache.calcite.plan.RelOptUtil;
        RelOptTable right = mockTable(rightTable, "status", "size");
                      OpenSearchSort(fetch=[50000], viableBackends=[[mock-parquet]])
import org.apache.calcite.rel.RelNode;
            join,
                        OpenSearchStageInputScan(childStageId=[0], viableBackends=[[mock-parquet]])
import org.apache.calcite.plan.RelOptTable;
        return org.apache.calcite.rel.logical.LogicalAggregate.create(
                """,
import org.apache.logging.log4j.Logger;
        return sb.toString();
    /** Single-shard: data already on one node (SINGLETON(SCAN)) satisfies root's SINGLETON
 * this file be licensed under the Apache-2.0 license or a
 */
            List.of(),
        RelDataType intType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);
                  OpenSearchProject(cnt=[$1], k=[$0], viableBackends=[[mock-parquet]])
            rexBuilder.makeLiteral(50000, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            org.apache.calcite.util.ImmutableBitSet.of(),
        }
                  Stage 0 exchange=SINGLETON
 * <p>Structural invariants that don't depend on exact output shape (targetResolver presence,
                OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[2], viableBackends=[[mock-parquet]])
 * SPDX-License-Identifier: Apache-2.0
            List.of(),
                    OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])
            leftScan,
    }
                          OpenSearchStageInputScan(childStageId=[0], viableBackends=[[mock-parquet]])
        );
                """,
        assertDagShape("""
    private static String normalizeLines(String s) {
     * trailing whitespace and strips the randomized {@code queryId} so tests are stable.
            List.of("k", "cnt")
                        OpenSearchStageInputScan(childStageId=[1], viableBackends=[[mock-parquet]])
        RelNode join = LogicalJoin.create(leftProject, rightSorted, List.of(), cond, Set.of(), JoinRelType.LEFT);
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        String actual = stripQueryId(dag.toString());
        );
            innerSort,
        assertDagShape(
        RelNode rightSorted = LogicalSort.create(
        );
                        OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])
        RelNode rightScan = stubScan(right);
        RelNode leftScan = stubScan(left);
                            OpenSearchStageInputScan(childStageId=[0], viableBackends=[[mock-parquet]])
                          OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
    }
                        OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
    private QueryDAG buildDAG(PlannerContext context, RelNode logicalPlan) {
                Stage 2
                  Stage 0 exchange=SINGLETON
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
public class DAGShapeTests extends BasePlannerRulesTests {
                  OpenSearchAggregate(group=[{}], cnt=[COUNT()], sum_left_size=[SUM($1)], sum_right_size=[SUM($3)], mode=[SINGLE], viableBackends=[[mock-parquet]])
        return buildDAG(context, logicalPlan);
            QueryDAG(queryId=<random>)
