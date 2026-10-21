            if (found != null) {
import java.util.function.ToLongFunction;
import org.opensearch.analytics.planner.FieldStorageResolver;
import org.opensearch.cluster.node.DiscoveryNode;
    /** CBO → DistributionEnforcementPass (only when MPP is on) → DAGBuilder — the production formation
            }
            );
        when(state.metadata()).thenReturn(metadata);
        PlannerContext context = buildMppContext(Map.of("dim", 3, "fact", 3), Map.of("dim", SMALL, "fact", LARGE), /* mppEnabled */ true);
                CLUSTER_DATA_NODES,
                SqlStdOperatorTable.EQUALS,
        assertEquals(MppStrategy.HASH_SHUFFLE, observe(dag));
 */
        ToLongFunction<String> rowCountLookup = name -> rowCounts.getOrDefault(name, PlannerContext.UNKNOWN_ROW_COUNT);
    public void testThetaJoinReportsCoordinatorCentric() {
import java.util.Set;
        PlannerContext context = buildMppContext(Map.of("a", 3, "b", 3), Map.of("a", LARGE, "b", LARGE), /* mppEnabled */ true);
        assertNull("hash-shuffle DAG must NOT have a BROADCAST_BUILD stage", MppStrategy.findBroadcastBuild(dag));
                Settings.builder()
                plan,
import org.apache.calcite.rel.RelNode;
        assertNotEquals("left and right producer stages must be distinct", left.getStageId(), right.getStageId());
        Map<String, DiscoveryNode> dataNodes = new HashMap<>();
        assertTrue(MppStrategy.containsJoin(dag));
                return found;
     *  stage exists, HASH_SHUFFLE when a SHUFFLE_SCAN_* producer exists, else COORDINATOR_CENTRIC. */
        for (Map.Entry<String, Integer> entry : shardCounts.entrySet()) {
        assertEquals(MppStrategy.COORDINATOR_CENTRIC, observe(dag));
 */
        RelNode left = stubScan(mockTable(leftIdx, "status", "size"));
        for (Stage child : stage.getChildStages()) {
    private static boolean hasHashShuffle(QueryDAG dag) {
        if (stage == null) {
    private static ClusterState mockClusterStateWithDataNodes(Map<String, Integer> shardCounts) {
    }
     *  pipeline, so the resulting roles reflect what the general scheduler would dispatch. */
        if (context.getSettings().getAsBoolean("analytics.mpp.enabled", false)) {
}
        QueryDAG dag = buildEnforcedDag(makeInnerEquiJoin("a", "b"), context);
        assertTrue(MppStrategy.containsJoin(dag));
        assertNotNull("broadcast DAG must have a BROADCAST_BUILD stage", build);
        assertNull(MppStrategy.findBroadcastBuild(dag));
            );
import org.opensearch.analytics.planner.CapabilityRegistry;
 * appears, no broadcast), and theta / mpp-off / scan-only to COORDINATOR_CENTRIC (no broadcast, no shuffle).
    }
        AnalyticsSearchBackendPlugin shuffleAware = new ShuffleAwareDataFusionBackend(CLUSTER_DATA_NODES);
        Stage build = MppStrategy.findBroadcastBuild(dag);
 * "observed" strategy is read directly off the resulting DAG via {@link MppStrategy#containsJoin} +
            String indexName = entry.getKey();
 * deleted {@code JoinStrategyAdvisorTests} (the {@code JoinStrategyAdvisor.observe()} read of CBO+DAGBuilder
        public int defaultShuffleParallelism(ClusterState state) {
    private static final int CLUSTER_DATA_NODES = 3;
        return findStageByRole(dag.rootStage(), Stage.StageRole.SHUFFLE_SCAN_LEFT) != null
import org.apache.calcite.rel.core.JoinRelType;
        // with mpp.enabled=true and LARGE×LARGE inputs, the pass must gather and run coord-centric.
        assertFalse("scan-only DAG must not be counted as a join", MppStrategy.containsJoin(dag));
            return MppStrategy.HASH_SHUFFLE;
    private RelNode makeInnerEquiJoin(String leftIdx, String rightIdx) {
        private final int parallelism;
 * uses to pick the {@code /_analytics/_strategies} counter).
        return makeJoin(leftIdx, rightIdx, /* equi */ false);
        QueryDAG dag = buildEnforcedDag(stubScan(mockTable("idx", "status", "size")), context);
                rexBuilder.makeInputRef(intType, 0),
        PlannerContext context = buildMppContext(Map.of("a", 3, "b", 3), Map.of("a", LARGE, "b", LARGE), /* mppEnabled */ false);
    private static class ShuffleAwareDataFusionBackend extends MockDataFusionBackend {
 * decides placement post-CBO and {@code DAGBuilder} tags each stage's {@link Stage.StageRole}, so the
        Settings settings = Settings.builder().put("analytics.mpp.enabled", mppEnabled).build();
        // mpp.enabled=false → the enforcement pass is skipped entirely; only the coord-centric gather
        }
import org.opensearch.cluster.ClusterState;
import org.opensearch.common.settings.Settings;
            plan = DistributionEnforcementPass.enforce(
                /* shuffleAggregateEnabled */ true
            dataNodes.put("node-" + i, mock(DiscoveryNode.class));
                rexBuilder.makeInputRef(intType, leftCols)
        assertTrue(MppStrategy.containsJoin(dag));
     *  cost competition has real inputs (mirrors CascadeShuffleProbeTests#buildMppContext). */
    private static MppStrategy observe(QueryDAG dag) {
                    .put("index.composite.primary_data_format", "parquet")
        when(state.nodes()).thenReturn(nodes);
 *
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
            || findStageByRole(dag.rootStage(), Stage.StageRole.SHUFFLE_SCAN_AGG) != null
    }
        assertTrue("a broadcast plan must NOT introduce a hash shuffle", !hasHashShuffle(dag));
        return null;
            return MppStrategy.BROADCAST;
    }
    private PlannerContext buildMppContext(Map<String, Integer> shardCounts, Map<String, Long> rowCounts, boolean mppEnabled) {
            );
    private static Stage findStageByRole(Stage stage, Stage.StageRole role) {
        }
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
        RelNode plan = PlannerImpl.createPlan(logical, context);
                    .build()
    }
            ? rexBuilder.makeCall(
    }
            return null;
        QueryDAG dag = buildEnforcedDag(makeThetaJoin("a", "b"), context);
                rexBuilder.makeInputRef(intType, 0),
                /* minRows */ 1L,
        assertEquals(Stage.StageRole.BROADCAST_BUILD, build.getRole());
/*
import org.opensearch.analytics.planner.dag.DAGBuilder;
                rexBuilder.makeInputRef(intType, leftCols)
 * The OpenSearch Contributors require contributions made to
    }
    }
import org.opensearch.analytics.planner.PlannerContext;
 * {@link MppStrategy#findBroadcastBuild} + a hash-exchange scan (the same signals {@code DefaultPlanExecutor}
        Stage probe = findStageByRole(dag.rootStage(), Stage.StageRole.BROADCAST_PROBE);
import org.opensearch.analytics.planner.MockDataFusionBackend;
        int leftCols = left.getRowType().getFieldCount();
        QueryDAG dag = buildEnforcedDag(makeInnerEquiJoin("a", "b"), context);
        }
import org.opensearch.analytics.planner.dag.Stage;
        assertNotNull("hash-shuffle DAG must have a SHUFFLE_SCAN_LEFT stage", left);
            when(indexMetadata.getSettings()).thenReturn(
import org.opensearch.analytics.planner.dag.QueryDAG;
        return MppStrategy.COORDINATOR_CENTRIC;
        }
    private RelNode makeJoin(String leftIdx, String rightIdx, boolean equi) {
        assertEquals(MppStrategy.COORDINATOR_CENTRIC, observe(dag));
import org.opensearch.cluster.metadata.Metadata;
    }
        ClusterState state = mockClusterStateWithDataNodes(shardCounts);
    private QueryDAG buildEnforcedDag(RelNode logical, PlannerContext context) {
        Stage left = findStageByRole(dag.rootStage(), Stage.StageRole.SHUFFLE_SCAN_LEFT);
        }
        RelNode right = stubScan(mockTable(rightIdx, "status", "size"));
            IndexMetadata indexMetadata = mock(IndexMetadata.class);
        assertEquals(MppStrategy.COORDINATOR_CENTRIC, observe(dag));
            when(indexMetadata.mapping()).thenReturn(mappingMetadata);
    // ── strategy observation (mirrors the deleted JoinStrategyAdvisor.observe contract) ─────────
                context.getDistributionTraitDef(),
import java.util.HashMap;
        ShuffleAwareDataFusionBackend(int parallelism) {
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        if (MppStrategy.findBroadcastBuild(dag) != null) {
        }
    }
        for (int i = 0; i < CLUSTER_DATA_NODES; i++) {
import org.opensearch.core.index.Index;
 * compatible open source license.
            MappingMetadata mappingMetadata = mock(MappingMetadata.class);
    }
        return state;
            )
    }
public class MppStrategyObservationTests extends BasePlannerRulesTests {
    private static final long SMALL = 1_000L;
import java.util.List;
            || findStageByRole(dag.rootStage(), Stage.StageRole.SHUFFLE_WORKER) != null;
        }
        RexNode condition = equi
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
        PlannerContext context = buildMppContext(Map.of("idx", 1), Map.of("idx", SMALL), /* mppEnabled */ true);
        assertTrue("probe stage must list the build stage as a child", probe.getChildStages().contains(build));
        return makeJoin(leftIdx, rightIdx, /* equi */ true);
    public void testSmallByLargeJoinReportsBroadcast() {
    }
            : rexBuilder.makeCall(
                SqlStdOperatorTable.LESS_THAN,
                    .putList("index.composite.secondary_data_formats", "lucene")
        QueryDAG dag = buildEnforcedDag(makeInnerEquiJoin("dim", "fact"), context);
    /** Multi-data-node cluster + per-index row-count lookup + shuffle-aware backend so the broadcast / hash
        ClusterState state = mock(ClusterState.class);
        when(nodes.getDataNodes()).thenReturn(dataNodes);
        }
        Metadata metadata = mock(Metadata.class);
        return new PlannerContext(registry, state, settings, rowCountLookup, /* profiling */ false);
    }
package org.opensearch.analytics.exec.join;
        return LogicalJoin.create(left, right, List.of(), condition, Set.of(), JoinRelType.INNER);
        assertNull(MppStrategy.findBroadcastBuild(dag));
        assertTrue(MppStrategy.containsJoin(dag));
import java.util.Map;
 *
import org.opensearch.analytics.planner.PlannerImpl;
            int shardCount = entry.getValue();
    /** Reads the strategy CBO + the enforcement pass + DAGBuilder produced: BROADCAST when a BROADCAST_BUILD
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            when(indexMetadata.getIndex()).thenReturn(new Index(indexName, indexName + "-uuid"));
            return stage;
    public void testLargeByLargeJoinReportsHashShuffle() {
        assertNotNull("hash-shuffle DAG must have a SHUFFLE_SCAN_RIGHT stage", right);
            return parallelism;
 * BROADCAST_BUILD stage appears), a large×large equi-join to HASH_SHUFFLE (a SHUFFLE_SCAN_LEFT/RIGHT pair
import org.apache.calcite.rel.type.RelDataType;
        assertEquals(MppStrategy.BROADCAST, observe(dag));
    private RelNode makeThetaJoin(String leftIdx, String rightIdx) {
        assertNull(MppStrategy.findBroadcastBuild(dag));
        // survives. The DAG must carry neither a broadcast nor a shuffle.
import org.opensearch.cluster.metadata.IndexMetadata;
 * Validates the strategy a join query resolves to under the GENERAL post-CBO scheduler — ported from the
        PlannerContext context = buildMppContext(Map.of("a", 3, "b", 3), Map.of("a", LARGE, "b", LARGE), /* mppEnabled */ true);
            || findStageByRole(dag.rootStage(), Stage.StageRole.SHUFFLE_SCAN_RIGHT) != null
 * <p>The contract is the same as the deleted advisor's: a small×large join resolves to BROADCAST (a
            when(metadata.index(indexName)).thenReturn(indexMetadata);
        @Override
        if (stage.getRole() == role) {
/**
        Stage right = findStageByRole(dag.rootStage(), Stage.StageRole.SHUFFLE_SCAN_RIGHT);
            when(indexMetadata.getNumberOfShards()).thenReturn(shardCount);
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.rex.RexNode;
import org.opensearch.analytics.planner.BasePlannerRulesTests;
            Stage found = findStageByRole(child, role);
    }
import org.opensearch.cluster.node.DiscoveryNodes;
    private static final long LARGE = 10_000_000L;
            when(mappingMetadata.sourceAsMap()).thenReturn(Map.of("properties", intFields()));
    public void testNonJoinQueryReturnsCoordinatorCentric() {
        // DAGBuilder.cutShuffle role-tags each child stage by which join input it feeds; the two producers
        if (hasHashShuffle(dag)) {
        CapabilityRegistry registry = new CapabilityRegistry(List.of(shuffleAware, LUCENE), FieldStorageResolver::new);
        // must be distinct stages (one left, one right) so the binary shuffle transport binds both inputs.
        assertNotNull("broadcast DAG must have a BROADCAST_PROBE stage", probe);
 * output). The general path no longer has a per-strategy advisor; instead {@link DistributionEnforcementPass}
import org.apache.calcite.rel.logical.LogicalJoin;
        // A theta (non-equi) condition has no hash key, so neither broadcast nor shuffle is shippable; even
    public void testJoinWithMppDisabledReportsCoordinatorCentric() {
        }
import org.opensearch.cluster.metadata.MappingMetadata;
        return DAGBuilder.build(plan, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
        }
 * this file be licensed under the Apache-2.0 license or a
            this.parallelism = parallelism;
    // ── helpers ──────────────────────────────────────────────────────────────────
