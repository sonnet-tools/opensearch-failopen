        assertPlanShape("""
            ),
            result
            Set<EngineCapability> caps = new HashSet<>(super.supportedEngineCapabilities());
        assertPlanShape(
            OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            /* all */ true
 * each arm is gathered to {@code COORDINATOR+SINGLETON} via {@code TraitDef.convert}.
        // Different tables. tableIds differ → general path.
            /* all */ true
import org.apache.calcite.util.ImmutableBitSet;
        assertPlanShape("""
        RelNode result = runPlanner(plan, unionContextSingleIndex("test_index", 2));
                stubScan(mockTable("test_index", "status", "size"))
 * this file be licensed under the Apache-2.0 license or a
            result
                """,
        );
            result
    public void testUnion_differentTables_1shard() {
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    }
        assertPlanShape(
        RelNode result = runPlanner(union, unionContextSingleIndex("test_index", 1));
    }
        );
        // the coordinator (each arm forced to SINGLETON), so the aggregate's input is already
            /* all */ true
        // a, b, a — three 1-shard arms but two distinct tableIds → general path.
            OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])
                """,
        RelNode union = LogicalUnion.create(List.of(stubScan(mockTable("test_index", "status", "size")), emptyArm), /* all */ true);
        );
        assertPlanShape("""
        );
            List.of(
        RelNode union = LogicalUnion.create(
                stubScan(mockTable("a", "status", "size")),
import org.apache.calcite.rel.logical.LogicalUnion;
                """,
                    OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
            .add("size", typeFactory.createSqlType(SqlTypeName.INTEGER))
        // OpenSearchAggregateSplitRule.childForcesGather stops at the Union → single SINGLE aggregate.
import org.apache.calcite.rel.type.RelDataType;
        RelNode union = LogicalUnion.create(
            return caps;
import java.util.Set;
    private PlannerContext unionContextSingleIndex(String indexName, int shardCount) {
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                      OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
            """
                stubScan(mockTable("b", "status", "size")),
                    OpenSearchTableScan(table=[[a]], viableBackends=[[mock-parquet]])
        // Aggregate over a Union must NOT split into PARTIAL/FINAL: the Union gathers its arms to
import java.util.List;
                stubScan(mockTable("test_index", "status", "size")),
                stubScan(mockTable("test_index", "status", "size")),
        RelNode result = runPlanner(union, unionContextSingleIndex("test_index", 2));
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        // gathered — a shard-side PARTIAL would have nothing partitioned to pre-aggregate.
                stubScan(mockTable("a", "status", "size"))
            """, result);
        // arm (just the scan) when only one input remains.
    public void testUnion_differentTables_2shard() {
                OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])
}
        );
        // 2-shard inputs fail the co-location predicate (shardCount > 1). General path:
import org.apache.calcite.rel.RelNode;
 * compatible open source license.
        );
        assertPlanShape(
            List.of(stubScan(mockTable("test_index", "status", "size")), stubScan(mockTable("test_index", "status", "size"))),
        RelNode union = LogicalUnion.create(
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
    }
    }
            List.of(
        RelNode union = LogicalUnion.create(
                """,
            """
                OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])
            .add("status", typeFactory.createSqlType(SqlTypeName.INTEGER))
    public void testUnion_sameTable_2shard() {
/**
        // each arm gathered to coord, Union at coord.
    }
        RelNode result = runPlanner(union, unionContextTwoIndices(Map.of("left_idx", 1, "right_idx", 1)));
        RelNode result = runPlanner(union, unionContextSingleIndex("test_index", 1));
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        );
import java.util.Map;
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
import org.opensearch.analytics.spi.EngineCapability;
            /* all */ true
            """, result);
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    /** Mock DF backend with EngineCapability.UNION — needed because UNION is opt-in. */
            result
 */
                    OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
import org.apache.calcite.sql.type.SqlTypeName;
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        );
        return buildContextPerIndex("parquet", shardsByIndex, intFields(), List.of(new UnionCapableBackend(), LUCENE));
                    OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
    }
                    OpenSearchTableScan(table=[[b]], viableBackends=[[mock-parquet]])
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RelNode result = runPlanner(union, unionContextTwoIndices(Map.of("left_idx", 2, "right_idx", 2)));
        RelNode union = LogicalUnion.create(
            """
            result
 * Union runs at the shard, no per-arm ER, single ER above for the root demand. Otherwise
    public void testAggregateOverUnion_2shard_doesNotSplit() {
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RelNode result = runPlanner(union, unionContextTwoIndices(Map.of("a", 1, "b", 1)));
/*
    public void testUnion_threeArms_mixedTables_1shard() {
import java.util.HashSet;
        assertPlanShape(
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RelNode plan = makeAggregate(union, ImmutableBitSet.of(0), countStarCall(union));
    private PlannerContext unionContextTwoIndices(Map<String, Integer> shardsByIndex) {
            ),
            List.of(stubScan(mockTable("left_idx", "status", "size")), stubScan(mockTable("right_idx", "status", "size"))),
            """
        @Override
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
    private static final class UnionCapableBackend extends MockDataFusionBackend {
        RelNode union = LogicalUnion.create(
            /* all */ true
 * The OpenSearch Contributors require contributions made to
        RelNode emptyArm = LogicalValues.createEmpty(cluster, rowType);
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        );
            List.of(stubScan(mockTable("left_idx", "status", "size")), stubScan(mockTable("right_idx", "status", "size"))),
        );
            List.of(stubScan(mockTable("test_index", "status", "size")), stubScan(mockTable("test_index", "status", "size"))),
        }
                """,
    }
                OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])
    }
    }
 *
            .build();
                OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])
public class UnionPlanShapeTests extends PlanShapeTestBase {
                OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[SINGLE], viableBackends=[[mock-parquet]])
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        );
    }
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                    OpenSearchTableScan(table=[[a]], viableBackends=[[mock-parquet]])
        assertPlanShape(
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    }
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.rel.logical.LogicalValues;
            /* all */ true
    public void testUnion_threeArms_sameTable_1shard() {
            """, result);
            List.of(stubScan(mockTable("test_index", "status", "size")), stubScan(mockTable("test_index", "status", "size"))),
                    OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
 */
                      OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
 * Plan-shape tests for {@link org.opensearch.analytics.planner.rel.OpenSearchUnion}.
        RelDataType rowType = typeFactory.builder()
    public void testUnion_sameTable_1shard() {
        // Empty Values arm should be dropped — UnionRule collapses to a single non-empty
            caps.add(EngineCapability.UNION);
            /* all */ true
 * <p>Co-location fast path applies when every arm is a 1-shard scan of the same table —
    // ── Context helpers ───────────────────────────────────────────────────────
        RelNode union = LogicalUnion.create(
 *
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            """
    public void testUnion_oneEmptyArm_collapsed() {
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        protected Set<EngineCapability> supportedEngineCapabilities() {
                  OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])
        );
        RelNode result = runPlanner(union, unionContextSingleIndex("test_index", 1));
        // Field trimming inserts Project(status) above each arm's scan — count-by-key needs only the group key.
        return buildContextPerIndex("parquet", Map.of(indexName, shardCount), intFields(), List.of(new UnionCapableBackend(), LUCENE));
package org.opensearch.analytics.planner;
            OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])
