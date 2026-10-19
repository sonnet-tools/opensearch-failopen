                    OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
        RelNode join = buildEquiJoin("left_idx", "right_idx", JoinRelType.INNER);
        assertPlanShape(  
    }  
    }
        RelNode result = runPlanner(join, context);
        assertPlanShape(
        );  
                    OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])  
 *       side, Join runs at coord.</li>  
        RelNode result = runPlanner(join, context);
                    OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])
            result
        );  
        assertPlanShape("""
                OpenSearchJoin(condition=[=($0, $2)], joinType=[__JOIN_TYPE__], viableBackends=[[mock-parquet]])  
                    OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])  
        PlannerContext context = perIndexContext(Map.of("left_idx", 1, "right_idx", 1));  
            JoinRelType.INNER  
import java.util.Map;
            """
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.sql.type.SqlTypeName;
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
        assertPlanShape(
    public void testLeftJoin_2shard() {  
 *   <li><b>General path</b> — different tables or any non-1-shard input. Each side is
import java.util.List;
/**
        RelNode join = buildEquiJoin("test_index", "test_index", JoinRelType.INNER);  
        RelNode result = runPlanner(join, context);  
                OpenSearchJoin(condition=[true], joinType=[inner], viableBackends=[[mock-parquet]])
        RelOptTable right = mockTable("right_idx", "status", "size");
            """, result);  
        RelNode join = buildEquiJoin("left_idx", "right_idx", JoinRelType.INNER);
package org.opensearch.analytics.planner;
 *       gathered to {@code COORDINATOR+SINGLETON} via {@code TraitDef.convert}. ER per
    }
        assertPlanShape(  
    private void runJoinKindShape(JoinRelType joinType, String label) {  
        // the predicate requires shardCount=1 on both sides — general path.  
            """
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
 *
    public void testCrossJoin_2shard() {  
            List.of(),  
    public void testFullJoin_2shard() {
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
        );  
            stubScan(right),
        RelOptTable left = mockTable(leftTable, "status", "size");  
                OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])  
 * compatible open source license.
                    OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])
        // the shard, and root demand (locality-agnostic SINGLETON) is satisfied directly.
            result
    public void testInnerJoin_selfJoin_1shard() {
        // Mirror of testInnerJoin_mixedShards.
 *       {@code SHARD+SINGLETON+t=X+s=1}; root demand triggers a single ER above.</li>  
        RelOptTable left = mockTable("left_idx", "status", "size");  
    private RelNode buildEquiJoin(String leftTable, String rightTable, JoinRelType joinType) {
public class JoinPlanShapeTests extends PlanShapeTestBase {  
                OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
        // ON 1 = 1 — Calcite folds to TRUE: empty leftKeys, empty nonEqui, JoinInfo.isEqui true.
        );
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
                """,
    public void testInnerJoin_mixedShards() {
            trueCondition,
import java.util.Set;  
            OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])  
        assertPlanShape(  
                    OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        runJoinKindShape(JoinRelType.FULL, "full");  
import org.apache.calcite.plan.RelOptTable;
 * Plan-shape tests for {@link org.opensearch.analytics.planner.rel.OpenSearchJoin}.  
        assertPlanShape(
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.rex.RexNode;  
        PlannerContext context = perIndexContext(Map.of("left_idx", 1, "right_idx", 2));
        );
 *       Whole subtree resolves at the shard, no per-side ER. Output is
 *   <li><b>Co-location fast path</b> — both sides are 1-shard scans of the same table.
                .replace("__JOIN_TYPE__", label),  
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            stubScan(left),
                """,
                """
 */
    }
        RexNode cond = rexBuilder.makeCall(
        RelNode result = runPlanner(join, context);
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
    public void testInnerJoin_mixedShards_leftMulti_rightSingle() {
        // left 1-shard, right 2-shard. Even if tableIds matched (which they don't here)
/*  
                    OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
    }
            result  
        RexNode trueCondition = rexBuilder.makeLiteral(true);
        RelNode join = LogicalJoin.create(  
    public void testInnerJoin_2shard() {  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
        // tableIds). General path: ER per side, Join at coord.
        RelNode join = buildEquiJoin("left_idx", "right_idx", JoinRelType.INNER);
 * SPDX-License-Identifier: Apache-2.0
            """
        PlannerContext context = perIndexContext(Map.of("left_idx", 2, "right_idx", 2));
    }
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            SqlStdOperatorTable.EQUALS,  
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
 */  
    }
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
            result  
 * </ul>
                    OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
        RelNode join = buildEquiJoin("left_idx", "right_idx", JoinRelType.INNER);
            """
                    OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])  
                    OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
        return LogicalJoin.create(stubScan(left), stubScan(right), List.of(), cond, Set.<CorrelationId>of(), joinType);
            Set.<CorrelationId>of(),
 * <p>Two execution strategies, both via {@code OpenSearchJoinSplitRule}:
    public void testInnerJoin_differentTables_1shard() {  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
        );
 * this file be licensed under the Apache-2.0 license or a
    }
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        runJoinKindShape(JoinRelType.LEFT, "left");
        // Different tables, even at 1 shard each — co-location predicate fails (different
import org.apache.calcite.rel.logical.LogicalJoin;
        RelNode result = runPlanner(join, context);  
        RelOptTable right = mockTable(rightTable, "status", "size");
    public void testRightJoin_2shard() {
}  
        );
                OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])  
                """,
            """
        PlannerContext context = perIndexContext(Map.of("left_idx", 2, "right_idx", 2));
                OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
import org.apache.calcite.rel.core.JoinRelType;
        PlannerContext context = perIndexContext(Map.of("left_idx", 2, "right_idx", 2));
    }
    }
        RelNode join = buildEquiJoin("left_idx", "right_idx", joinType);
        PlannerContext context = perIndexContext(Map.of("left_idx", 2, "right_idx", 1));  
            result
                """,
 * <ul>  
                """,
 *
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
import org.apache.calcite.rel.core.CorrelationId;  
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                    OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
            """
                    OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])
        // Self-join on a single 1-shard table — co-location fast path applies. The Join runs at  
        RelNode result = runPlanner(join, context);
        );  
    }  
        PlannerContext context = perIndexContext(Map.of("test_index", 1));
        RelNode result = runPlanner(join, context);  
        runJoinKindShape(JoinRelType.RIGHT, "right");
            result
