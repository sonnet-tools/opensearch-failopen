import org.apache.calcite.sql.type.OperandTypes;
import java.util.List;
 * <p>1-shard: no exchange is needed; the planner leaves a (harmless) stacked Project — DataFusion's physical
            OpenSearchAggregate(group=[{}], PERCENTILE_APPROX=[PERCENTILE_APPROX($0, $1)], mode=[SINGLE], viableBackends=[[mock-parquet]])
            -1,
/*  
 * compatible open source license.
            false,
}
 * with the aggregate) over an unpinned lower copy (physical-only), with the CBO-inserted ExchangeReducer
import org.apache.calcite.rex.RexNode;  
import org.apache.calcite.sql.type.ReturnTypes;
        // upper copy's SINGLETON requirement is trivially met), leaving a stacked Project that DataFusion
import org.apache.calcite.sql.SqlAggFunction;
    }
        return LogicalAggregate.create(project, List.of(), ImmutableBitSet.of(), null, List.of(call));  
            SqlFunctionCategory.USER_DEFINED_FUNCTION,
            .add("status", typeFactory.createSqlType(SqlTypeName.INTEGER))
        LogicalProject project = (LogicalProject) LogicalProject.create(scan, List.of(), List.of(statusRef, fifty), projectType);
            """, result);
        // SINGLE percentile over a PINNED upper Project (literal $f1=50) over the ER over the
        };  
    }
                OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])  
import org.apache.calcite.sql.SqlKind;  
        ) {
            aggName
            false,
        // 1-shard: SINGLETON already satisfied, no ER. The rule still duplicates the Project (the pinned  
                OpenSearchAggregate(group=[{}], PERCENTILE_APPROX=[PERCENTILE_APPROX($0, $1)], mode=[SINGLE], viableBackends=[[mock-parquet]])  
public class AggLiteralArgProjectSplitPlanShapeTests extends PlanShapeTestBase {
import org.apache.calcite.rel.logical.LogicalAggregate;  
                  OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            .add("$f1", typeFactory.createSqlType(SqlTypeName.INTEGER))
    }  
            """
    public void testPercentileLiteralArg_1shard_noExchangeNoSplit() {
            null,
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    private static SqlAggFunction udaf(String name) {
 * Plan-shape tests for {@link org.opensearch.analytics.planner.rules.OpenSearchAggLiteralArgProjectSplitRule}.
        );
                """,
import org.apache.calcite.util.ImmutableBitSet;
            SqlKind.OTHER_FUNCTION,  
            typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true),  
            List.of(0, 1),  
            project,
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.logical.LogicalProject;
              OpenSearchProject(status=[$0], $f1=[50], viableBackends=[[mock-parquet]])
                  OpenSearchProject(status=[$0], $f1=[50], viableBackends=[[mock-parquet]])
        );
            result  
        assertPlanShape(
            false,  
 *
            """
                      OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])  
            false,  
 */  
                      OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])  
            null,
            result  
            OperandTypes.ANY_ANY,  
        RelNode result = runPlanner(aggOverLiteralProject("PERCENTILE_APPROX"), singleShardContext());
        RelNode result = runPlanner(aggOverLiteralProject("PERCENTILE_APPROX"), multiShardContext());
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            false,
/**
                """,
 * <p>Multi-shard: the literal-bearing Project is duplicated into a pinned upper copy (keeping the literal
        return new SqlAggFunction(  
        AggregateCall call = AggregateCall.create(  
    }
import org.apache.calcite.rel.core.AggregateCall;
            null,
    private RelNode aggOverLiteralProject(String aggName) {
        RelNode result = runPlanner(aggOverLiteralProject("TAKE"), multiShardContext());  
    }
            udaf(aggName),
                  OpenSearchProject(status=[$0], $f1=[50], viableBackends=[[mock-parquet]])
 * The OpenSearch Contributors require contributions made to  
        RexNode statusRef = rexBuilder.makeInputRef(scan, 0);
import java.math.BigDecimal;
 *
        RexNode fifty = rexBuilder.makeLiteral(BigDecimal.valueOf(50), typeFactory.createSqlType(SqlTypeName.INTEGER), true);
 * this file be licensed under the Apache-2.0 license or a
            Optionality.FORBIDDEN
 * SPDX-License-Identifier: Apache-2.0
            .build();  
            0,
 */
        assertPlanShape(
    public void testPercentileLiteralArg_2shard_splitsWithErBetween() {  
import org.apache.calcite.util.Optionality;
package org.opensearch.analytics.planner;
        // folds at execution.
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));  
            List.of(),
 * landing between them — so the literal stays coordinator-side while the scan narrows.  
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        assertPlanShape("""  
        // physical-only lower Project (status) over the scan.  
            name,
import org.apache.calcite.sql.SqlFunctionCategory;
    /** A minimal user-defined agg function named {@code name} (two ANY operands), resolved by the SPI by name. */
                OpenSearchAggregate(group=[{}], TAKE=[TAKE($0, $1)], mode=[SINGLE], viableBackends=[[mock-parquet]])  
    /** {@code Aggregate(<aggName>($0,$1)) over Project(status=$0, $f1=50) over scan(status,size)}. */
import org.apache.calcite.sql.type.SqlTypeName;  
        );
            ReturnTypes.ARG0_FORCE_NULLABLE,
        RelDataType projectType = typeFactory.builder()  
    public void testTakeLiteralArg_2shard_splitsWithErBetween() {
 *  
 * optimizer folds it at execution (verified separately on a live node).  
            org.apache.calcite.rel.RelCollations.EMPTY,  
import org.apache.calcite.rel.type.RelDataType;
