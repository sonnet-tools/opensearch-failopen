/*
        runJoinKindShape(JoinRelType.RIGHT, "right");
        );
        PlannerContext context = perIndexContext(Map.of("left_idx", 2, "right_idx", 2));
        assertPlanShape("""
            result
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            List.of(),
                    OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])
    }
        // Self-join on a single 1-shard table — co-location fast path applies. The Join runs at
        PlannerContext context = perIndexContext(Map.of("left_idx", 2, "right_idx", 2));
        // ON 1 = 1 — Calcite folds to TRUE: empty leftKeys, empty nonEqui, JoinInfo.isEqui true.
    public void testInnerJoin_mixedShards() {
        return LogicalJoin.create(stubScan(left), stubScan(right), List.of(), cond, Set.<CorrelationId>of(), joinType);
        RelOptTable right = mockTable("right_idx", "status", "size");
            result
    }
        RelOptTable right = mockTable(rightTable, "status", "size");
    }
import org.apache.calcite.rel.logical.LogicalJoin;
        // tableIds). General path: ER per side, Join at coord.
import org.apache.calcite.rex.RexNode;
                    OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
 * Plan-shape tests for {@link org.opensearch.analytics.planner.rel.OpenSearchJoin}.
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
        PlannerContext context = perIndexContext(Map.of("test_index", 1));
                    OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
    public void testCrossJoin_2shard() {
        assertPlanShape(
        RelNode result = runPlanner(join, context);
        RelNode result = runPlanner(join, context);
        PlannerContext context = perIndexContext(Map.of("left_idx", 1, "right_idx", 1));
            stubScan(right),
            result
                OpenSearchJoin(condition=[true], joinType=[inner], viableBackends=[[mock-parquet]])
        // Different tables, even at 1 shard each — co-location predicate fails (different
        RelOptTable left = mockTable("left_idx", "status", "size");
        RelNode join = buildEquiJoin("left_idx", "right_idx", JoinRelType.INNER);
    }
 *
 */
    public void testFullJoin_2shard() {
 * <p>Two execution strategies, both via {@code OpenSearchJoinSplitRule}:
                    OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])
            Set.<CorrelationId>of(),
    public void testInnerJoin_mixedShards_leftMulti_rightSingle() {
import java.util.List;
/**
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
    }
                OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
 */
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
            """
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        assertPlanShape(
        // the predicate requires shardCount=1 on both sides — general path.
            trueCondition,
        // the shard, and root demand (locality-agnostic SINGLETON) is satisfied directly.
    public void testRightJoin_2shard() {
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            JoinRelType.INNER
        );
                .replace("__JOIN_TYPE__", label),
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
    }
    }
    private void runJoinKindShape(JoinRelType joinType, String label) {
        runJoinKindShape(JoinRelType.FULL, "full");
import java.util.Map;
 *       side, Join runs at coord.</li>
    private RelNode buildEquiJoin(String leftTable, String rightTable, JoinRelType joinType) {
    public void testInnerJoin_2shard() {
 *       gathered to {@code COORDINATOR+SINGLETON} via {@code TraitDef.convert}. ER per
                    OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])
                """,
            """
        );
import org.apache.calcite.sql.type.SqlTypeName;
        RelNode join = buildEquiJoin("test_index", "test_index", JoinRelType.INNER);
 * </ul>
                    OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])
                """
            """
    public void testInnerJoin_differentTables_1shard() {
            result
        assertPlanShape(
                """,
            """
        RelNode join = buildEquiJoin("left_idx", "right_idx", JoinRelType.INNER);
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        );
 * compatible open source license.
        assertPlanShape(
        // left 1-shard, right 2-shard. Even if tableIds matched (which they don't here)
            """
    }
            result
        RelNode result = runPlanner(join, context);
        PlannerContext context = perIndexContext(Map.of("left_idx", 2, "right_idx", 1));
}
                    OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])
            SqlStdOperatorTable.EQUALS,
import org.apache.calcite.rel.core.CorrelationId;
        );
        // Mirror of testInnerJoin_mixedShards.
                    OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
        runJoinKindShape(JoinRelType.LEFT, "left");
 * this file be licensed under the Apache-2.0 license or a
            """, result);
                    OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
import java.util.Set;
    public void testLeftJoin_2shard() {
import org.apache.calcite.rel.core.JoinRelType;
        RelOptTable left = mockTable(leftTable, "status", "size");
public class JoinPlanShapeTests extends PlanShapeTestBase {
 *   <li><b>Co-location fast path</b> — both sides are 1-shard scans of the same table.
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            """
        RelNode join = buildEquiJoin("left_idx", "right_idx", JoinRelType.INNER);
        RelNode join = buildEquiJoin("left_idx", "right_idx", joinType);
import org.apache.calcite.plan.RelOptTable;
                    OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
    public void testInnerJoin_selfJoin_1shard() {
        RelNode result = runPlanner(join, context);
        RelNode join = buildEquiJoin("left_idx", "right_idx", JoinRelType.INNER);
import org.apache.calcite.rel.RelNode;
 * <ul>
            OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
            result
 *       Whole subtree resolves at the shard, no per-side ER. Output is
    }
        PlannerContext context = perIndexContext(Map.of("left_idx", 1, "right_idx", 2));
                OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
        );
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        assertPlanShape(
        PlannerContext context = perIndexContext(Map.of("left_idx", 2, "right_idx", 2));
                """,
                    OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(join, context);
        RelNode join = LogicalJoin.create(
                """,
                OpenSearchJoin(condition=[=($0, $2)], joinType=[__JOIN_TYPE__], viableBackends=[[mock-parquet]])
 *       {@code SHARD+SINGLETON+t=X+s=1}; root demand triggers a single ER above.</li>
 * SPDX-License-Identifier: Apache-2.0
    }
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RelNode result = runPlanner(join, context);
                OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    }
        );
                """,
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
package org.opensearch.analytics.planner;
            stubScan(left),
        RexNode trueCondition = rexBuilder.makeLiteral(true);
        assertPlanShape(
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                    OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])
 * The OpenSearch Contributors require contributions made to
        RelNode result = runPlanner(join, context);
                OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
 *   <li><b>General path</b> — different tables or any non-1-shard input. Each side is
        );
 *
        RexNode cond = rexBuilder.makeCall(
