/**
    }
                OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
    public void testProjectWithScalarExpression_2shard() {  
public class ProjectPlanShapeTests extends PlanShapeTestBase {  
            List.of("status", "size")
 * compatible open source license.
package org.opensearch.analytics.planner;
 * Plan-shape tests for {@link org.opensearch.analytics.planner.rel.OpenSearchProject} —  
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));  
            List.of(rexBuilder.makeInputRef(scan, 0), rexBuilder.makeInputRef(scan, 1)),
    }  
import java.util.List;  
                OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
        RelNode plan = identityFieldsProject();  
        RelNode result = runPlanner(plan, singleShardContext());
        RelNode plan = identityFieldsProject();  
            OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])  
                """,  
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
import org.apache.calcite.rel.logical.LogicalProject;
                """,
 *
    public void testFieldsProject_2shard() {
        assertPlanShape(
 * passthrough projection (field refs only) and {@code eval}-style scalar expressions.
        );
                  OpenSearchProject(status=[$0], size=[$1], viableBackends=[[mock-parquet]])
            List.of(),  
                  OpenSearchProject(status=[$0], sum=[ANNOTATED_PROJECT_EXPR(id=0, backends=[mock-parquet], +($0, $1))], viableBackends=[[mock-parquet]])
 * this file be licensed under the Apache-2.0 license or a
 */
    private RelNode identityFieldsProject() {
 */  
        RexNode plus = rexBuilder.makeCall(SqlStdOperatorTable.PLUS, rexBuilder.makeInputRef(scan, 0), rexBuilder.makeInputRef(scan, 1));
            """, result);
            scan,
    }
        );  
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));  
        RelNode plan = LogicalProject.create(scan, List.of(), List.of(rexBuilder.makeInputRef(scan, 0), plus), List.of("status", "sum"));
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            """  
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
        assertPlanShape("""
 * SPDX-License-Identifier: Apache-2.0
        assertPlanShape(
        RelNode result = runPlanner(plan, multiShardContext());  
    public void testFieldsProject_1shard() {
/*  
            """
 * The OpenSearch Contributors require contributions made to  
        );  
import org.apache.calcite.rex.RexNode;  
            result
        // registry so it gets wrapped in ANNOTATED_PROJECT_EXPR.
}
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
import org.apache.calcite.rel.RelNode;
        // status + size — primitive arithmetic. PLUS now goes through the capability
            result
        RelNode result = runPlanner(plan, multiShardContext());
    }  
        return LogicalProject.create(
