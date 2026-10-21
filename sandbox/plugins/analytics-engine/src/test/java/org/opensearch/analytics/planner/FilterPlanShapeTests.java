    public void testFilter_2shard() {
        RelNode plan = makeFilter(scan, makeEquals(0, SqlTypeName.INTEGER, 200));
        assertPlanShape(
            result
            result
import java.util.List;
            List.of(rexBuilder.makeInputRef(intType, 0)),
            """
    public void testFilter_1shard() {
        assertPlanShape(
                """,
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            List.of(),
            """, result);
        );
        RelNode plan = makeFilter(aggregate, makeEquals(0, SqlTypeName.INTEGER, 200));
            scan,
        );
 * is {@code ER ← Filter ← Scan} regardless of shard count, with the Filter executed at
        assertPlanShape(
            JoinRelType.INNER
                  OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200))], viableBackends=[[mock-parquet]])
                OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200))], viableBackends=[[mock-parquet]])
    // ---- Filter pushdown via Calcite core transposes ----
    public void testFilterPastAggregateOnGroupKey_pushed() {
                """,
import org.apache.calcite.rel.type.RelDataType;
    /**
        RexNode joinCond = rexBuilder.makeCall(
    }
        // Filter on $0 — references only the left side; rule should push into left input.
        RelNode result = runPlanner(plan, singleShardContext());
        AggregateCall sum = sumCall();
                  OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
 * SPDX-License-Identifier: Apache-2.0
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RexNode andExpr = rexBuilder.makeCall(SqlStdOperatorTable.AND, equalsStatus, equalsSize);
/**
        assertPlanShape(
            """
 * Plan-shape tests for {@link org.opensearch.analytics.planner.rel.OpenSearchFilter}.
        // Filter on $0 — the group-by column, not the agg result.
                  OpenSearchFilter(condition=[AND(ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200)), ANNOTATED_PREDICATE(id=1, backends=[mock-lucene, mock-parquet], =($1, 1024)))], viableBackends=[[mock-parquet]])
        RelOptTable table = mockTable("test_index", "status", "size");
import org.apache.calcite.rel.core.AggregateCall;
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        );
            List.of(),
        );
    public void testFilterPastAggregateOnAggResult_notPushed() {
        RelOptTable leftTable = mockTable("left_idx", "status", "size");
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
     */
            """
                  OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200))], viableBackends=[[mock-parquet]])
    /**
        assertPlanShape(
            joinCond,
                """,
package org.opensearch.analytics.planner;
    /**
            SqlStdOperatorTable.EQUALS,
        RelNode aggregate = makeAggregate(sum);
        RexNode equalsStatus = makeEquals(0, SqlTypeName.INTEGER, 200);
 * Filter is single-input passthrough — its trait equals its child's, so the plan shape
     */
            List.of("status_out")
        assertPlanShape("""
     * Filter referencing a column on the left side of a Join — {@code FilterIntoJoinRule}
                OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
}
            rexBuilder.makeInputRef(intType, 2)
                OpenSearchProject(status_out=[$0], viableBackends=[[mock-parquet]])
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.rel.logical.LogicalProject;
 * the shard.
        );
            """
    public void testFilterWithAnd_2shard() {
    }
        );
        RelNode plan = makeFilter(project, makeEquals(0, SqlTypeName.INTEGER, 200));
            OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=1, backends=[mock-parquet], =($1, 1000))], viableBackends=[[mock-parquet]])
            Set.<CorrelationId>of(),
                OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
    /**
     * Aggregate via {@code FilterAggregateTransposeRule}, ending below it.
            result
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            """
            stubScan(leftTable),
    }
                """,
            """
            result
        RelNode result = runPlanner(plan, singleShardContext());
              OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], mode=[SINGLE], viableBackends=[[mock-parquet]])
    public void testFilterPastJoin_pushed() {
import org.apache.calcite.rel.core.JoinRelType;
     * should push the Filter into the left input of the Join.
        RelNode result = runPlanner(plan, multiShardContext());
 */
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
import org.apache.calcite.plan.RelOptTable;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        // Both predicates collapse into the same shard-side OpenSearchFilter; one ER above
        RelNode scan = stubScan(table);
 * The OpenSearch Contributors require contributions made to
public class FilterPlanShapeTests extends PlanShapeTestBase {
            stubScan(rightTable),
            result
        AggregateCall sum = sumCall();
        RelNode result = runPlanner(plan, multiShardContext());
        RelNode result = runPlanner(plan, singleShardContext());
     * Filter sitting above a Project — {@code FilterProjectTransposeRule} should push
        // Filter on $1 — the SUM(size) result column, which the rule cannot push below the agg.
 * this file be licensed under the Apache-2.0 license or a
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
     * the Filter through the Project so it sits adjacent to the Scan.
        );
import java.util.Set;
    }
                OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], mode=[SINGLE], viableBackends=[[mock-parquet]])
        );
import org.apache.calcite.rel.RelNode;
        RelNode result = runPlanner(plan, perIndexContext(java.util.Map.of("left_idx", 1, "right_idx", 1)));
        RelNode plan = makeFilter(join, makeEquals(0, SqlTypeName.INTEGER, 200));
        RelOptTable rightTable = mockTable("right_idx", "status", "size");
            rexBuilder.makeInputRef(intType, 0),
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
import org.apache.calcite.rel.logical.LogicalJoin;
     */
                OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        LogicalProject project = LogicalProject.create(
                  OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200))], viableBackends=[[mock-parquet]])
/*
 */
                    OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200))], viableBackends=[[mock-parquet]])
        RelNode aggregate = makeAggregate(sum);
            result
import org.apache.calcite.rel.core.CorrelationId;
        RelNode result = runPlanner(plan, singleShardContext());
                OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RelNode plan = makeFilter(aggregate, makeEquals(1, SqlTypeName.INTEGER, 1000));
    }
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
    public void testFilterPastProject_pushed() {
        RelNode plan = makeFilter(scan, andExpr);
        RelNode plan = makeFilter(scan, makeEquals(0, SqlTypeName.INTEGER, 200));
    }
                    OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])
        // gathers to coord. Annotation IDs are stable because there's exactly one filter rel.
     * HAVING-style Filter on an aggregate result above an Aggregate — must NOT push, since
 * compatible open source license.
 *
        );
    }
     */
        RexNode equalsSize = makeEquals(1, SqlTypeName.INTEGER, 1024);
                      OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
                """,
        RelNode join = LogicalJoin.create(
import org.apache.calcite.sql.type.SqlTypeName;
     * the predicate references the agg output. Filter stays above Aggregate.
                """,
        assertPlanShape(
     * HAVING-style Filter on a group-by column above an Aggregate — should push past the
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
