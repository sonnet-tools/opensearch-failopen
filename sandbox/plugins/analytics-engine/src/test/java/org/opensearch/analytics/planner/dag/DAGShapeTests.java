            List.of(),
        RelNode leftProject = LogicalProject.create(
                  OpenSearchAggregate(group=[{}], cnt=[COUNT()], sum_left_size=[SUM($1)], sum_right_size=[SUM($3)], mode=[SINGLE], viableBackends=[[mock-parquet]])  
            false,
        );
        return LogicalProject.create(
            typeFactory.createSqlType(SqlTypeName.BIGINT),  
        RelNode rightProject = LogicalProject.create(  
        RelNode leftScan = stubScan(left);
                    OpenSearchJoin(condition=[=($0, $2)], joinType=[left], viableBackends=[[mock-parquet]])
            typeFactory.createSqlType(SqlTypeName.BIGINT),  
    public void testJoinDag_case4_multiShardDifferentTables() {
                    OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
            RelCollations.EMPTY,
 * PPL shapes. String-based assertions give reviewers the full DAG (stages, fragments,
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            """, dag);
                          OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                        OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])
                QueryDAG(queryId=<random>)
            List.of(),
                Stage 2
import java.util.List;
 *
    private static String stripQueryId(String dagStr) {  
    // Case 1 (1-shard same table) — co-location fast path. Both inputs scan the same 1-shard
     * trailing whitespace and strips the randomized {@code queryId} so tests are stable.
    //
                  Stage 1 exchange=SINGLETON
import org.apache.calcite.rel.RelCollations;  
            "cnt"
        AggregateCall sumRight = AggregateCall.create(SqlStdOperatorTable.SUM, false, List.of(3), -1, join, intType, "sum_right_size");
                    OpenSearchSort(fetch=[50000], viableBackends=[[mock-parquet]])  
        return sb.toString();  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)  
        QueryDAG dag = buildDAG(context, buildJoinWithStatsShape("left_idx", "right_idx"));
        );
            org.apache.calcite.util.ImmutableBitSet.of(0),  
            """  
     *  collapses into a single stage. */
                """,  
                          OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
 * SPDX-License-Identifier: Apache-2.0
 */
                """,
            rexBuilder.makeLiteral(2, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
                        OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            List.of("cnt", "k")
            dag
        RelNode agg = org.apache.calcite.rel.logical.LogicalAggregate.create(  
        }
 * exchange info propagation) stay in {@link DAGBuilderTests}.
            """  
                    OpenSearchJoin(condition=[=($0, $2)], joinType=[left], viableBackends=[[mock-parquet]])
            org.apache.calcite.util.ImmutableBitSet.of(),
        assertDagShape(
    private QueryDAG buildDAG(PlannerContext context, RelNode logicalPlan) {  
                  Stage 0 exchange=SINGLETON
        );
    private RelNode buildTopKAfterStats() {
            List.of(),  
    // ── Join DAG shapes ──────────────────────────────────────────────────────  
        );  
            null,  
        );  
    }
              OpenSearchProject(k=[$1], cnt=[$0], viableBackends=[[mock-parquet]])
        );  
     * Asserts the {@link QueryDAG#toString()} matches the expected string. Normalizes
        );
            innerSort,
            agg,
    // Cases 2-4 — general path. Each input is gathered to coord via a per-side ER → 3 stages.  
            QueryDAG(queryId=<random>)  
                    OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])  
            dag
    }
            List.of("status", "size")
    /** Multi-shard: PARTIAL on shards, FINAL at coord; Sort(fetch=2) above FINAL. */
                        OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])
    }
    // ── Builders ─────────────────────────────────────────────────────────────
        assertDagShape(
            List.of(),
    private RelNode buildJoinWithStatsShape(String leftTable, String rightTable) {
import org.apache.calcite.rel.core.JoinRelType;
    }  
        return dag;  
import org.apache.calcite.plan.RelOptTable;
        );  
        QueryDAG dag = DAGBuilder.build(cboOutput, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
        return buildDAG(context, logicalPlan);  
                          OpenSearchStageInputScan(childStageId=[0], viableBackends=[[mock-parquet]])
            List.of(rexBuilder.makeInputRef(rightScan, 0), rexBuilder.makeInputRef(rightScan, 1)),  
                        OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])
            false,
                      OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])
                        OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])  
    // index; Join runs at SHARD with no per-side ER. The aggregate above demands SINGLETON,  
        RelOptTable left = mockTable(leftTable, "status", "size");
                end--;  
import org.apache.logging.log4j.Logger;
            sb.setLength(sb.length() - 1);
    /** Single-shard: data already on one node (SINGLETON(SCAN)) satisfies root's SINGLETON  
            null,
    public void testJoinDag_case3_singleShardDifferentTables() {
            innerSwap,
    }
                QueryDAG(queryId=<random>)
        );
                Stage 1
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
    //
        QueryDAG dag = buildDAG(context, buildJoinWithStatsShape("left_idx", "right_idx"));  
                          OpenSearchStageInputScan(childStageId=[0], viableBackends=[[mock-parquet]])
        PlannerContext context = buildContextPerIndex("parquet", Map.of("left_idx", 3, "right_idx", 3));  
                QueryDAG(queryId=<random>)
        RexNode cond = rexBuilder.makeCall(  
    private static final Logger LOGGER = LogManager.getLogger(DAGShapeTests.class);
        );  
                    OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
            null,
            rightProject,
        RelNode rightScan = stubScan(right);
            dag
            stubScan(mockTable("test_index", "status", "size")),
                """,
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),  
                        OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
            List.of(countCall)
 *
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        LOGGER.info("Input RelNode:\n{}", RelOptUtil.toString(logicalPlan));
        AggregateCall sumLeft = AggregateCall.create(SqlStdOperatorTable.SUM, false, List.of(1), -1, join, intType, "sum_left_size");  
        assertDagShape(  
import org.apache.logging.log4j.LogManager;  
                      OpenSearchProject(cnt=[$1], k=[$0], viableBackends=[[mock-parquet]])
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            List.of(countCall, sumLeft, sumRight)
import org.apache.calcite.rel.logical.LogicalSort;
     *  demand without a gather — AggregateSplit doesn't fire, no ER inserted, whole tree
            List.of(rexBuilder.makeInputRef(innerSort, 1), rexBuilder.makeInputRef(innerSort, 0)),
                  OpenSearchAggregate(group=[{}], cnt=[COUNT()], sum_left_size=[SUM($1)], sum_right_size=[SUM($3)], mode=[SINGLE], viableBackends=[[mock-parquet]])
                  OpenSearchAggregate(group=[{}], cnt=[COUNT()], sum_left_size=[SUM($1)], sum_right_size=[SUM($3)], mode=[SINGLE], viableBackends=[[mock-parquet]])  
/**  
        for (String line : s.split("\n", -1)) {  
 * this file be licensed under the Apache-2.0 license or a
        var context = buildContext("parquet", shardCount, intFields());
        StringBuilder sb = new StringBuilder();
                      OpenSearchStageInputScan(childStageId=[0], viableBackends=[[mock-parquet]])
 */  
                OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[2], viableBackends=[[mock-parquet]])  
            List.of(rexBuilder.makeInputRef(agg, 1), rexBuilder.makeInputRef(agg, 0)),
                        OpenSearchStageInputScan(childStageId=[0], viableBackends=[[mock-parquet]])
package org.opensearch.analytics.planner.dag;
                      OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
        AggregateCall countCall = AggregateCall.create(  
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
}  
        RelNode join = LogicalJoin.create(leftProject, rightSorted, List.of(), cond, Set.of(), JoinRelType.LEFT);
    public void testJoinDag_case1_singleShardSameTable() {
    }  
                  Stage 0 exchange=SINGLETON  
                  Stage 0 exchange=SINGLETON  
    }  
import org.opensearch.analytics.planner.PlannerContext;  
        QueryDAG dag = buildDAG(1, buildTopKAfterStats());
                      OpenSearchSort(fetch=[50000], viableBackends=[[mock-parquet]])
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
        return dagStr.replaceFirst("queryId=[0-9a-fA-F-]+", "queryId=<random>");
        );  
            join,
            SqlStdOperatorTable.COUNT,
                            OpenSearchStageInputScan(childStageId=[1], viableBackends=[[mock-parquet]])  
        AggregateCall countCall = AggregateCall.create(  
        RelNode innerSort = LogicalSort.create(
        );
                      OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])  
    }
            List.of(),  
                      OpenSearchSort(fetch=[50000], viableBackends=[[mock-parquet]])  
    // gathered via one ER between Aggregate and Join → 2 stages total.
                        OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])  
                  Stage 0 exchange=SINGLETON
public class DAGShapeTests extends BasePlannerRulesTests {  
                    OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])  
        // Consume left.size ($1) and right.size ($3) so neither join arm is trimmed below  
                Stage 2
     */
        QueryDAG dag = buildDAG(context, buildJoinWithStatsShape("test_index", "test_index"));
    }
                          OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
    // ── Top-K DAG shapes ─────────────────────────────────────────────────────  
import org.opensearch.analytics.planner.BasePlannerRulesTests;
        LOGGER.info("QueryDAG:\n{}", dag);
        assertDagShape(
        );
    public void testTopKAfterStatsDag_singleShard() {  
            int end = line.length();
        }
                QueryDAG(queryId=<random>)
            """
import org.apache.calcite.plan.RelOptUtil;
        return org.apache.calcite.rel.logical.LogicalAggregate.create(
            stubScan(mockTable("test_index", "status", "size")),
        );  
import org.apache.calcite.rel.RelNode;
    }
                      OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            """
                """,
    private QueryDAG buildDAG(int shardCount, RelNode logicalPlan) {
                      OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
                  Stage 1 exchange=SINGLETON  
    }
            SqlStdOperatorTable.COUNT,
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
import org.apache.calcite.rel.logical.LogicalJoin;
                      OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])
                  Stage 0 exchange=SINGLETON  
    /**  
            List.of(),  
                      OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
            List.of("status", "size")  
 * stageInputScan placeholders) at a glance — a regression that shuffles Sort placement,  
        assertEquals("DAG shape mismatch — actual:\n" + actual, normalizedExpected, normalizedActual);  
                QueryDAG(queryId=<random>)  
                """,
            Stage 0
            null,  
 * DAG-shape tests that lock in the exact {@link QueryDAG#toString()} output for representative
     * On mismatch, the full actual output is shown so reviewers see the DAG shape.  
import org.apache.calcite.rel.core.AggregateCall;  
        // [status, size] — keeps the arm Projects and the join condition at =($0, $2).
    private static String normalizeLines(String s) {
 * compatible open source license.
            rexBuilder.makeLiteral(50000, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
                      OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])  
        assertDagShape("""
            List.of("k", "cnt")
            while (end > 0 && (line.charAt(end - 1) == ' ' || line.charAt(end - 1) == '\t'))
            List.of(),  
            dag  
                  OpenSearchProject(cnt=[$1], k=[$0], viableBackends=[[mock-parquet]])
            "cnt"
            join,  
            -1,
        );
            List.of(rexBuilder.makeInputRef(leftScan, 0), rexBuilder.makeInputRef(leftScan, 1)),
            -1,
        String actual = stripQueryId(dag.toString());  
                    OpenSearchJoin(condition=[=($0, $2)], joinType=[left], viableBackends=[[mock-parquet]])  
        QueryDAG dag = buildDAG(3, buildTopKAfterStats());
        PlannerContext context = buildContext("parquet", 1, intFields());  
            dag
                      OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])
                        OpenSearchStageInputScan(childStageId=[1], viableBackends=[[mock-parquet]])
        assertDagShape(
                          OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
                    OpenSearchJoin(condition=[=($0, $2)], joinType=[left], viableBackends=[[mock-parquet]])
 * <p>Structural invariants that don't depend on exact output shape (targetResolver presence,  
        RelNode rightSorted = LogicalSort.create(  
import java.util.Set;
        RelNode cboOutput = runPlanner(logicalPlan, context);
        RelOptTable right = mockTable(rightTable, "status", "size");  
 * The OpenSearch Contributors require contributions made to  
        PlannerContext context = buildContext("parquet", 3, intFields());
/*  
                            OpenSearchStageInputScan(childStageId=[0], viableBackends=[[mock-parquet]])
                            OpenSearchStageInputScan(childStageId=[1], viableBackends=[[mock-parquet]])
        QueryDAG dag = buildDAG(context, buildJoinWithStatsShape("test_index", "test_index"));
            leftScan,  
 * misplaces an ER, or changes stage cuts shows up as a clean diff.
import org.apache.calcite.rel.RelFieldCollation;
import java.util.Map;  
import org.apache.calcite.rex.RexNode;  
                Stage 1
    public void testTopKAfterStatsDag_multiShard() {  
    }
        PlannerContext context = buildContextPerIndex("parquet", Map.of("left_idx", 1, "right_idx", 1));
        String normalizedExpected = normalizeLines(expected);
        while (sb.length() >= 2 && sb.charAt(sb.length() - 1) == '\n' && sb.charAt(sb.length() - 2) == '\n') {  
        RelDataType intType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true);
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                  OpenSearchProject(k=[$1], cnt=[$0], viableBackends=[[mock-parquet]])  
import org.apache.calcite.rel.type.RelDataType;
            SqlStdOperatorTable.EQUALS,
                  Stage 1 exchange=SINGLETON
        String normalizedActual = normalizeLines(actual);
import org.apache.calcite.sql.type.SqlTypeName;
                    OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[2], viableBackends=[[mock-parquet]])
            List.of(),
import org.apache.calcite.rel.logical.LogicalProject;  
    public void testJoinDag_case2_multiShardSameTable() {  
        RelNode innerSwap = LogicalProject.create(
            """  
    private static void assertDagShape(String expected, QueryDAG dag) {
            sb.append(line, 0, end).append('\n');
            rightScan,
        );
    }
                      OpenSearchSort(fetch=[50000], viableBackends=[[mock-parquet]])
                Stage 2  
        LOGGER.info("Marked+CBO RelNode:\n{}", RelOptUtil.toString(cboOutput));  
                    OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[SINGLE], viableBackends=[[mock-parquet]])
                  OpenSearchAggregate(group=[{}], cnt=[COUNT()], sum_left_size=[SUM($1)], sum_right_size=[SUM($3)], mode=[SINGLE], viableBackends=[[mock-parquet]])
