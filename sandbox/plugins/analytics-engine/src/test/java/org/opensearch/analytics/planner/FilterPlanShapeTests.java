            """  
    public void testFilterPastJoin_pushed() {  
            List.of(),  
     * HAVING-style Filter on an aggregate result above an Aggregate — must NOT push, since
        RelNode join = LogicalJoin.create(  
 *
            rexBuilder.makeInputRef(intType, 2)
            """
    public void testFilter_2shard() {
 * the shard.
        );  
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
        assertPlanShape(  
                OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
import org.apache.calcite.rel.type.RelDataType;
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
 */  
            joinCond,
        RelNode result = runPlanner(plan, multiShardContext());  
                  OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200))], viableBackends=[[mock-parquet]])
        RelOptTable rightTable = mockTable("right_idx", "status", "size");
    // ---- Filter pushdown via Calcite core transposes ----  
        RelNode aggregate = makeAggregate(sum);  
                  OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200))], viableBackends=[[mock-parquet]])  
    public void testFilter_1shard() {  
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);  
    }
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);  
        RexNode equalsSize = makeEquals(1, SqlTypeName.INTEGER, 1024);  
/**
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
                """,
                OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], mode=[SINGLE], viableBackends=[[mock-parquet]])
     */
        );
            result
                  OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    public void testFilterPastProject_pushed() {  
    }
public class FilterPlanShapeTests extends PlanShapeTestBase {
            List.of("status_out")
            JoinRelType.INNER  
 * this file be licensed under the Apache-2.0 license or a
    }
     * HAVING-style Filter on a group-by column above an Aggregate — should push past the
import org.apache.calcite.plan.RelOptTable;
        RelNode aggregate = makeAggregate(sum);
 * Filter is single-input passthrough — its trait equals its child's, so the plan shape  
                """,
                    OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])  
        assertPlanShape(
        assertPlanShape(
import org.apache.calcite.rel.logical.LogicalProject;
     */
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
 * Plan-shape tests for {@link org.opensearch.analytics.planner.rel.OpenSearchFilter}.
        );
        RelNode result = runPlanner(plan, multiShardContext());
                  OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200))], viableBackends=[[mock-parquet]])
import org.apache.calcite.rel.RelNode;
            OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=1, backends=[mock-parquet], =($1, 1000))], viableBackends=[[mock-parquet]])
     * should push the Filter into the left input of the Join.
    /**
        );
import org.apache.calcite.rex.RexNode;  
                      OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
                  OpenSearchFilter(condition=[AND(ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200)), ANNOTATED_PREDICATE(id=1, backends=[mock-lucene, mock-parquet], =($1, 1024)))], viableBackends=[[mock-parquet]])  
    /**  
     * the predicate references the agg output. Filter stays above Aggregate.
        // Filter on $0 — the group-by column, not the agg result.
                OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
     * Filter sitting above a Project — {@code FilterProjectTransposeRule} should push  
 * compatible open source license.
            stubScan(leftTable),
     */
import org.apache.calcite.rel.core.AggregateCall;  
        RelOptTable table = mockTable("test_index", "status", "size");
import java.util.List;
        RelNode plan = makeFilter(scan, makeEquals(0, SqlTypeName.INTEGER, 200));
        RelNode plan = makeFilter(scan, andExpr);
    /**
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
            Set.<CorrelationId>of(),
        LogicalProject project = LogicalProject.create(
            List.of(rexBuilder.makeInputRef(intType, 0)),
        RelNode result = runPlanner(plan, singleShardContext());  
            stubScan(rightTable),
        // Filter on $0 — references only the left side; rule should push into left input.
    }
            """  
                OpenSearchProject(status_out=[$0], viableBackends=[[mock-parquet]])
import org.apache.calcite.rel.core.JoinRelType;
                """,
        );  
    /**
            List.of(),  
                OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        assertPlanShape("""
        );
        AggregateCall sum = sumCall();  
        RelNode result = runPlanner(plan, singleShardContext());
            SqlStdOperatorTable.EQUALS,
              OpenSearchAggregate(group=[{0}], total_size=[SUM($1)], mode=[SINGLE], viableBackends=[[mock-parquet]])  
        RelNode result = runPlanner(plan, singleShardContext());  
        assertPlanShape(
    }
    public void testFilterPastAggregateOnGroupKey_pushed() {
import org.apache.calcite.rel.core.CorrelationId;
            result
        RelNode plan = makeFilter(aggregate, makeEquals(1, SqlTypeName.INTEGER, 1000));
        );
     */  
            result  
        assertPlanShape(  
            """  
}  
            result  
                """,
 * is {@code ER ← Filter ← Scan} regardless of shard count, with the Filter executed at
            """
     * Filter referencing a column on the left side of a Join — {@code FilterIntoJoinRule}  
        RelNode scan = stubScan(table);
        // Filter on $1 — the SUM(size) result column, which the rule cannot push below the agg.
                OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200))], viableBackends=[[mock-parquet]])  
    }
        RelNode result = runPlanner(plan, perIndexContext(java.util.Map.of("left_idx", 1, "right_idx", 1)));
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            """
            result
import java.util.Set;
     * Aggregate via {@code FilterAggregateTransposeRule}, ending below it.  
                """,
        RelNode plan = makeFilter(scan, makeEquals(0, SqlTypeName.INTEGER, 200));  
     * the Filter through the Project so it sits adjacent to the Scan.
            result  
        RelNode plan = makeFilter(project, makeEquals(0, SqlTypeName.INTEGER, 200));
                    OpenSearchFilter(condition=[ANNOTATED_PREDICATE(id=0, backends=[mock-lucene, mock-parquet], =($0, 200))], viableBackends=[[mock-parquet]])  
        );  
        RelNode result = runPlanner(plan, singleShardContext());
        RexNode joinCond = rexBuilder.makeCall(
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        // gathers to coord. Annotation IDs are stable because there's exactly one filter rel.
        RexNode andExpr = rexBuilder.makeCall(SqlStdOperatorTable.AND, equalsStatus, equalsSize);
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
                """,
    }  
 */  
import org.apache.calcite.rel.logical.LogicalJoin;  
 * SPDX-License-Identifier: Apache-2.0
    public void testFilterPastAggregateOnAggResult_notPushed() {
        RelNode plan = makeFilter(aggregate, makeEquals(0, SqlTypeName.INTEGER, 200));  
        RelOptTable leftTable = mockTable("left_idx", "status", "size");
        // Both predicates collapse into the same shard-side OpenSearchFilter; one ER above
    public void testFilterWithAnd_2shard() {  
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        );  
/*  
        AggregateCall sum = sumCall();
        RexNode equalsStatus = makeEquals(0, SqlTypeName.INTEGER, 200);
import org.apache.calcite.sql.type.SqlTypeName;
        assertPlanShape(
            """, result);
package org.opensearch.analytics.planner;
        RelNode plan = makeFilter(join, makeEquals(0, SqlTypeName.INTEGER, 200));  
            rexBuilder.makeInputRef(intType, 0),  
 * The OpenSearch Contributors require contributions made to  
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
            scan,
