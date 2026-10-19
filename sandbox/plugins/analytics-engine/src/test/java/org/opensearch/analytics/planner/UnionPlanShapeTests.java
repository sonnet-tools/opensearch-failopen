        return buildContextPerIndex("parquet", shardsByIndex, intFields(), List.of(new UnionCapableBackend(), LUCENE));
 * compatible open source license.
            OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])  
/**
        RelNode union = LogicalUnion.create(
            /* all */ true
            OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
        );  
                OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[SINGLE], viableBackends=[[mock-parquet]])  
        );  
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    private PlannerContext unionContextSingleIndex(String indexName, int shardCount) {  
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
        assertPlanShape("""
        assertPlanShape(
            """  
                """,  
                stubScan(mockTable("a", "status", "size")),
        assertPlanShape(  
            List.of(stubScan(mockTable("test_index", "status", "size")), stubScan(mockTable("test_index", "status", "size"))),
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        // each arm gathered to coord, Union at coord.
            """
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
    public void testUnion_oneEmptyArm_collapsed() {
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                """,
        // Different tables. tableIds differ → general path.  
                    OpenSearchTableScan(table=[[a]], viableBackends=[[mock-parquet]])  
        assertPlanShape("""
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            return caps;
        RelNode result = runPlanner(union, unionContextTwoIndices(Map.of("a", 1, "b", 1)));
            caps.add(EngineCapability.UNION);
            OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(union, unionContextTwoIndices(Map.of("left_idx", 1, "right_idx", 1)));
    public void testUnion_differentTables_1shard() {
                    OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])  
    private PlannerContext unionContextTwoIndices(Map<String, Integer> shardsByIndex) {
            /* all */ true
            List.of(stubScan(mockTable("left_idx", "status", "size")), stubScan(mockTable("right_idx", "status", "size"))),
    private static final class UnionCapableBackend extends MockDataFusionBackend {  
        );
 */  
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RelNode result = runPlanner(union, unionContextTwoIndices(Map.of("left_idx", 2, "right_idx", 2)));
        RelNode plan = makeAggregate(union, ImmutableBitSet.of(0), countStarCall(union));
        );
            List.of(stubScan(mockTable("test_index", "status", "size")), stubScan(mockTable("test_index", "status", "size"))),
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RelNode union = LogicalUnion.create(List.of(stubScan(mockTable("test_index", "status", "size")), emptyArm), /* all */ true);  
                """,
                """,
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            Set<EngineCapability> caps = new HashSet<>(super.supportedEngineCapabilities());  
            result  
    }  
import java.util.Map;
        );
        assertPlanShape(  
                stubScan(mockTable("test_index", "status", "size")),
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
    }
        RelNode union = LogicalUnion.create(
    public void testUnion_threeArms_mixedTables_1shard() {  
            result
        );
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            /* all */ true  
        // 2-shard inputs fail the co-location predicate (shardCount > 1). General path:
    }
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
        RelNode union = LogicalUnion.create(
                      OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])  
 *
    public void testUnion_differentTables_2shard() {  
    public void testAggregateOverUnion_2shard_doesNotSplit() {
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
        }  
 */
            /* all */ true
                    OpenSearchTableScan(table=[[a]], viableBackends=[[mock-parquet]])
        );  
import java.util.Set;  
import org.opensearch.analytics.spi.EngineCapability;
                stubScan(mockTable("test_index", "status", "size")),  
            List.of(stubScan(mockTable("test_index", "status", "size")), stubScan(mockTable("test_index", "status", "size"))),
            ),  
public class UnionPlanShapeTests extends PlanShapeTestBase {  
                OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])
        );
    }
        RelNode result = runPlanner(union, unionContextSingleIndex("test_index", 2));
        RelDataType rowType = typeFactory.builder()
                      OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])  
            /* all */ true  
                    OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])  
        );  
    public void testUnion_sameTable_2shard() {  
        return buildContextPerIndex("parquet", Map.of(indexName, shardCount), intFields(), List.of(new UnionCapableBackend(), LUCENE));
        @Override
import org.apache.calcite.rel.logical.LogicalUnion;
 * Plan-shape tests for {@link org.opensearch.analytics.planner.rel.OpenSearchUnion}.  
            List.of(stubScan(mockTable("left_idx", "status", "size")), stubScan(mockTable("right_idx", "status", "size"))),
        // a, b, a — three 1-shard arms but two distinct tableIds → general path.
    public void testUnion_sameTable_1shard() {
 * Union runs at the shard, no per-arm ER, single ER above for the root demand. Otherwise  
        );
        RelNode emptyArm = LogicalValues.createEmpty(cluster, rowType);
                """,
                    OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
                  OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])
        RelNode union = LogicalUnion.create(  
                OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])
        assertPlanShape(
    }
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
        assertPlanShape("""
            .build();
import org.apache.calcite.rel.type.RelDataType;
            result  
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
}
        );  
            List.of(  
            .add("status", typeFactory.createSqlType(SqlTypeName.INTEGER))
 * each arm is gathered to {@code COORDINATOR+SINGLETON} via {@code TraitDef.convert}.
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
import org.apache.calcite.util.ImmutableBitSet;  
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
    public void testUnion_threeArms_sameTable_1shard() {  
        RelNode union = LogicalUnion.create(  
    }
            """, result);
        // Aggregate over a Union must NOT split into PARTIAL/FINAL: the Union gathers its arms to
import java.util.List;
    }
 * this file be licensed under the Apache-2.0 license or a
            """
            """
            /* all */ true
        protected Set<EngineCapability> supportedEngineCapabilities() {
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])
 * The OpenSearch Contributors require contributions made to  
            List.of(
        RelNode result = runPlanner(union, unionContextSingleIndex("test_index", 1));
    }
        RelNode result = runPlanner(union, unionContextSingleIndex("test_index", 1));
            .add("size", typeFactory.createSqlType(SqlTypeName.INTEGER))  
            result
 * <p>Co-location fast path applies when every arm is a 1-shard scan of the same table —
            """, result);  
package org.opensearch.analytics.planner;
            ),
    /** Mock DF backend with EngineCapability.UNION — needed because UNION is opt-in. */
            """, result);  
    }  
        // Empty Values arm should be dropped — UnionRule collapses to a single non-empty
                    OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
        assertPlanShape(
        );  
        RelNode result = runPlanner(plan, unionContextSingleIndex("test_index", 2));
                OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
 * SPDX-License-Identifier: Apache-2.0
import java.util.HashSet;  
    }
        // Field trimming inserts Project(status) above each arm's scan — count-by-key needs only the group key.  
            result
                stubScan(mockTable("b", "status", "size")),
        // the coordinator (each arm forced to SINGLETON), so the aggregate's input is already  
    // ── Context helpers ───────────────────────────────────────────────────────
import org.apache.calcite.rel.logical.LogicalValues;  
/*  
        RelNode result = runPlanner(union, unionContextSingleIndex("test_index", 1));  
        RelNode union = LogicalUnion.create(  
                    OpenSearchTableScan(table=[[b]], viableBackends=[[mock-parquet]])
                stubScan(mockTable("test_index", "status", "size"))
        // OpenSearchAggregateSplitRule.childForcesGather stops at the Union → single SINGLE aggregate.
        // arm (just the scan) when only one input remains.  
    }
 *
import org.apache.calcite.sql.type.SqlTypeName;
            """  
                stubScan(mockTable("a", "status", "size"))  
        // gathered — a shard-side PARTIAL would have nothing partitioned to pre-aggregate.
            /* all */ true
        RelNode union = LogicalUnion.create(
import org.apache.calcite.rel.RelNode;
