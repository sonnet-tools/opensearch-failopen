        @Override  
            String indexName = entry.getKey();
        assertNotNull("hash-shuffle DAG must have a SHUFFLE_SCAN_RIGHT stage", right);
            when(mappingMetadata.sourceAsMap()).thenReturn(Map.of("properties", intFields()));
import java.util.function.ToLongFunction;
        return MppStrategy.COORDINATOR_CENTRIC;
        assertTrue(MppStrategy.containsJoin(dag));
 * appears, no broadcast), and theta / mpp-off / scan-only to COORDINATOR_CENTRIC (no broadcast, no shuffle).
 * output). The general path no longer has a per-strategy advisor; instead {@link DistributionEnforcementPass}  
        RelNode plan = PlannerImpl.createPlan(logical, context);
    }  
                rexBuilder.makeInputRef(intType, 0),
        QueryDAG dag = buildEnforcedDag(makeInnerEquiJoin("dim", "fact"), context);
            dataNodes.put("node-" + i, mock(DiscoveryNode.class));
        return LogicalJoin.create(left, right, List.of(), condition, Set.of(), JoinRelType.INNER);  
 * Validates the strategy a join query resolves to under the GENERAL post-CBO scheduler — ported from the
     *  cost competition has real inputs (mirrors CascadeShuffleProbeTests#buildMppContext). */
public class MppStrategyObservationTests extends BasePlannerRulesTests {
        if (context.getSettings().getAsBoolean("analytics.mpp.enabled", false)) {  
            if (found != null) {
    private RelNode makeJoin(String leftIdx, String rightIdx, boolean equi) {
        assertTrue("probe stage must list the build stage as a child", probe.getChildStages().contains(build));  
        ClusterState state = mockClusterStateWithDataNodes(shardCounts);  
        }
        QueryDAG dag = buildEnforcedDag(makeThetaJoin("a", "b"), context);
        if (stage.getRole() == role) {  
 * BROADCAST_BUILD stage appears), a large×large equi-join to HASH_SHUFFLE (a SHUFFLE_SCAN_LEFT/RIGHT pair
        assertNotEquals("left and right producer stages must be distinct", left.getStageId(), right.getStageId());  
 * deleted {@code JoinStrategyAdvisorTests} (the {@code JoinStrategyAdvisor.observe()} read of CBO+DAGBuilder
                context.getDistributionTraitDef(),  
        Map<String, DiscoveryNode> dataNodes = new HashMap<>();  
    private static final long LARGE = 10_000_000L;
    }
                CLUSTER_DATA_NODES,
                /* minRows */ 1L,
import static org.mockito.Mockito.when;
        Stage left = findStageByRole(dag.rootStage(), Stage.StageRole.SHUFFLE_SCAN_LEFT);
 * <p>The contract is the same as the deleted advisor's: a small×large join resolves to BROADCAST (a  
                    .put("index.composite.primary_data_format", "parquet")
    }
                    .putList("index.composite.secondary_data_formats", "lucene")  
            return MppStrategy.HASH_SHUFFLE;
        int leftCols = left.getRowType().getFieldCount();
        when(nodes.getDataNodes()).thenReturn(dataNodes);
                /* shuffleAggregateEnabled */ true  
    private PlannerContext buildMppContext(Map<String, Integer> shardCounts, Map<String, Long> rowCounts, boolean mppEnabled) {
    }  
    }
        // must be distinct stages (one left, one right) so the binary shuffle transport binds both inputs.
    /** Reads the strategy CBO + the enforcement pass + DAGBuilder produced: BROADCAST when a BROADCAST_BUILD
        assertEquals(MppStrategy.COORDINATOR_CENTRIC, observe(dag));
import org.apache.calcite.rel.type.RelDataType;
 * "observed" strategy is read directly off the resulting DAG via {@link MppStrategy#containsJoin} +
        assertNull(MppStrategy.findBroadcastBuild(dag));  
                SqlStdOperatorTable.EQUALS,  
    public void testNonJoinQueryReturnsCoordinatorCentric() {
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        }  
import org.opensearch.analytics.planner.PlannerContext;  
    public void testThetaJoinReportsCoordinatorCentric() {  
        }
        public int defaultShuffleParallelism(ClusterState state) {
        PlannerContext context = buildMppContext(Map.of("idx", 1), Map.of("idx", SMALL), /* mppEnabled */ true);
    public void testLargeByLargeJoinReportsHashShuffle() {
                plan,
                rexBuilder.makeInputRef(intType, leftCols)
    private static ClusterState mockClusterStateWithDataNodes(Map<String, Integer> shardCounts) {
import static org.mockito.Mockito.mock;  
        assertTrue(MppStrategy.containsJoin(dag));
import org.opensearch.common.settings.Settings;  
        assertTrue("a broadcast plan must NOT introduce a hash shuffle", !hasHashShuffle(dag));
        Stage right = findStageByRole(dag.rootStage(), Stage.StageRole.SHUFFLE_SCAN_RIGHT);  
        RelNode left = stubScan(mockTable(leftIdx, "status", "size"));  
        assertEquals(MppStrategy.HASH_SHUFFLE, observe(dag));  
        return makeJoin(leftIdx, rightIdx, /* equi */ true);
        return makeJoin(leftIdx, rightIdx, /* equi */ false);
    }
        assertTrue(MppStrategy.containsJoin(dag));
 * {@link MppStrategy#findBroadcastBuild} + a hash-exchange scan (the same signals {@code DefaultPlanExecutor}  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
    private RelNode makeThetaJoin(String leftIdx, String rightIdx) {
        private final int parallelism;  
            }
        Stage probe = findStageByRole(dag.rootStage(), Stage.StageRole.BROADCAST_PROBE);
        PlannerContext context = buildMppContext(Map.of("a", 3, "b", 3), Map.of("a", LARGE, "b", LARGE), /* mppEnabled */ true);
import org.opensearch.analytics.planner.dag.Stage;
            ? rexBuilder.makeCall(
import org.opensearch.analytics.planner.dag.DAGBuilder;
import java.util.Map;
import java.util.Set;  
        ShuffleAwareDataFusionBackend(int parallelism) {
            )  
            );
            when(indexMetadata.getSettings()).thenReturn(  
 */  
        // mpp.enabled=false → the enforcement pass is skipped entirely; only the coord-centric gather
        // A theta (non-equi) condition has no hash key, so neither broadcast nor shuffle is shippable; even
            IndexMetadata indexMetadata = mock(IndexMetadata.class);  
import org.opensearch.cluster.metadata.Metadata;  
        Stage build = MppStrategy.findBroadcastBuild(dag);
import org.opensearch.cluster.node.DiscoveryNodes;
    public void testJoinWithMppDisabledReportsCoordinatorCentric() {
            return MppStrategy.BROADCAST;
import org.opensearch.analytics.planner.BasePlannerRulesTests;
        assertNotNull("broadcast DAG must have a BROADCAST_PROBE stage", probe);
        when(state.metadata()).thenReturn(metadata);
    private static MppStrategy observe(QueryDAG dag) {  
            : rexBuilder.makeCall(
            || findStageByRole(dag.rootStage(), Stage.StageRole.SHUFFLE_SCAN_AGG) != null
    private static Stage findStageByRole(Stage stage, Stage.StageRole role) {
    /** CBO → DistributionEnforcementPass (only when MPP is on) → DAGBuilder — the production formation
        return null;  
    private static final long SMALL = 1_000L;  
    }  
                rexBuilder.makeInputRef(intType, leftCols)
                    .build()
     *  pipeline, so the resulting roles reflect what the general scheduler would dispatch. */  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.index.Index;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
        assertEquals(Stage.StageRole.BROADCAST_BUILD, build.getRole());  
    private static boolean hasHashShuffle(QueryDAG dag) {
import org.opensearch.cluster.metadata.MappingMetadata;
        Settings settings = Settings.builder().put("analytics.mpp.enabled", mppEnabled).build();
    // ── strategy observation (mirrors the deleted JoinStrategyAdvisor.observe contract) ─────────
        ToLongFunction<String> rowCountLookup = name -> rowCounts.getOrDefault(name, PlannerContext.UNKNOWN_ROW_COUNT);
            || findStageByRole(dag.rootStage(), Stage.StageRole.SHUFFLE_WORKER) != null;
        CapabilityRegistry registry = new CapabilityRegistry(List.of(shuffleAware, LUCENE), FieldStorageResolver::new);
        return findStageByRole(dag.rootStage(), Stage.StageRole.SHUFFLE_SCAN_LEFT) != null
import java.util.HashMap;  
        // with mpp.enabled=true and LARGE×LARGE inputs, the pass must gather and run coord-centric.
import org.opensearch.analytics.planner.MockDataFusionBackend;
        Metadata metadata = mock(Metadata.class);
        return state;
    }  
 *
import org.apache.calcite.rel.logical.LogicalJoin;  
            when(indexMetadata.mapping()).thenReturn(mappingMetadata);
                rexBuilder.makeInputRef(intType, 0),  
import org.opensearch.cluster.node.DiscoveryNode;
        return new PlannerContext(registry, state, settings, rowCountLookup, /* profiling */ false);
import org.opensearch.analytics.planner.dag.QueryDAG;  
        }
 *
 * decides placement post-CBO and {@code DAGBuilder} tags each stage's {@link Stage.StageRole}, so the
        }
        assertFalse("scan-only DAG must not be counted as a join", MppStrategy.containsJoin(dag));
        }  
        assertNotNull("broadcast DAG must have a BROADCAST_BUILD stage", build);
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);  
        PlannerContext context = buildMppContext(Map.of("dim", 3, "fact", 3), Map.of("dim", SMALL, "fact", LARGE), /* mppEnabled */ true);
    private QueryDAG buildEnforcedDag(RelNode logical, PlannerContext context) {
    }
        QueryDAG dag = buildEnforcedDag(makeInnerEquiJoin("a", "b"), context);  
        QueryDAG dag = buildEnforcedDag(stubScan(mockTable("idx", "status", "size")), context);  
import org.opensearch.analytics.planner.PlannerImpl;
                Settings.builder()
            || findStageByRole(dag.rootStage(), Stage.StageRole.SHUFFLE_SCAN_RIGHT) != null  
import org.opensearch.cluster.ClusterState;  
        if (stage == null) {  
/**  
        assertNotNull("hash-shuffle DAG must have a SHUFFLE_SCAN_LEFT stage", left);
    }
    }
            plan = DistributionEnforcementPass.enforce(
        PlannerContext context = buildMppContext(Map.of("a", 3, "b", 3), Map.of("a", LARGE, "b", LARGE), /* mppEnabled */ false);
        RexNode condition = equi
    }
    /** Multi-data-node cluster + per-index row-count lookup + shuffle-aware backend so the broadcast / hash  
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
        AnalyticsSearchBackendPlugin shuffleAware = new ShuffleAwareDataFusionBackend(CLUSTER_DATA_NODES);  
                return found;  
        // DAGBuilder.cutShuffle role-tags each child stage by which join input it feeds; the two producers  
        assertNull(MppStrategy.findBroadcastBuild(dag));
            return stage;
            when(metadata.index(indexName)).thenReturn(indexMetadata);  
        }  
    }
        assertNull(MppStrategy.findBroadcastBuild(dag));
import org.opensearch.analytics.planner.FieldStorageResolver;
        assertEquals(MppStrategy.COORDINATOR_CENTRIC, observe(dag));  
        return DAGBuilder.build(plan, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);  
        assertEquals(MppStrategy.BROADCAST, observe(dag));
        QueryDAG dag = buildEnforcedDag(makeInnerEquiJoin("a", "b"), context);
        }
            when(indexMetadata.getIndex()).thenReturn(new Index(indexName, indexName + "-uuid"));
        if (MppStrategy.findBroadcastBuild(dag) != null) {
        when(state.nodes()).thenReturn(nodes);
/*  
            return parallelism;
 */  
     *  stage exists, HASH_SHUFFLE when a SHUFFLE_SCAN_* producer exists, else COORDINATOR_CENTRIC. */
        assertTrue(MppStrategy.containsJoin(dag));  
import org.apache.calcite.rex.RexNode;
        }  
    private static class ShuffleAwareDataFusionBackend extends MockDataFusionBackend {
    // ── helpers ──────────────────────────────────────────────────────────────────  
    }
        }
            return null;
        assertEquals(MppStrategy.COORDINATOR_CENTRIC, observe(dag));
import java.util.List;
        assertNull("hash-shuffle DAG must NOT have a BROADCAST_BUILD stage", MppStrategy.findBroadcastBuild(dag));
import org.apache.calcite.rel.RelNode;
import org.opensearch.analytics.planner.CapabilityRegistry;  
            Stage found = findStageByRole(child, role);
        if (hasHashShuffle(dag)) {
            );
package org.opensearch.analytics.exec.join;
        PlannerContext context = buildMppContext(Map.of("a", 3, "b", 3), Map.of("a", LARGE, "b", LARGE), /* mppEnabled */ true);  
        ClusterState state = mock(ClusterState.class);  
    public void testSmallByLargeJoinReportsBroadcast() {  
        // survives. The DAG must carry neither a broadcast nor a shuffle.  
        for (Stage child : stage.getChildStages()) {  
    private RelNode makeInnerEquiJoin(String leftIdx, String rightIdx) {  
            this.parallelism = parallelism;  
            int shardCount = entry.getValue();
        for (Map.Entry<String, Integer> entry : shardCounts.entrySet()) {  
        for (int i = 0; i < CLUSTER_DATA_NODES; i++) {
    }  
        RelNode right = stubScan(mockTable(rightIdx, "status", "size"));
import org.apache.calcite.rel.core.JoinRelType;
            when(indexMetadata.getNumberOfShards()).thenReturn(shardCount);
}
import org.opensearch.cluster.metadata.IndexMetadata;
 * uses to pick the {@code /_analytics/_strategies} counter).
    private static final int CLUSTER_DATA_NODES = 3;
                SqlStdOperatorTable.LESS_THAN,
            );
            MappingMetadata mappingMetadata = mock(MappingMetadata.class);  
import org.apache.calcite.sql.type.SqlTypeName;
