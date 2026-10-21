            /* mppEnabled */ true
            SqlStdOperatorTable.EQUALS,
     * Symmetric guard: a PURE-theta join (no equi key at all) must still route COORDINATOR-CENTRIC —
 *
        CapabilityRegistry registry = new CapabilityRegistry(List.of(shuffleAware, LUCENE), fieldStorageFactory);
/*
     *  PlannerImpl. The join condition is either an equi (col0 == col0) or theta (col0 LT col0)
    /**
        ToLongFunction<String> rowCountLookup = name -> rowCounts.getOrDefault(name, PlannerContext.UNKNOWN_ROW_COUNT);
import static org.mockito.Mockito.mock;
            Map.of("fact_large", LARGE, "dim_small", SMALL),
     * DIAGNOSTIC (#32): a large-fact × small-dim INNER equi-join FEEDING an aggregate
        for (RelNode input : unwrapped.getInputs()) {
        // Even with mpp.enabled=true, theta routes coord-centric — broadcast and hash rules
     * (vs the 2-way above) is what stops the bottom join distributing on the cluster.
     *  {@code defaultShuffleParallelism} to return the cluster's data-node count. */
        boolean broadcast = containsNodeOfType(result, OpenSearchBroadcastExchange.class);
import org.opensearch.cluster.metadata.IndexMetadata;
    // ── Contract: theta join ───────────────────────────────────────────────
 *   <li>Plain {@code OpenSearchExchangeReducer} above each side → COORDINATOR_CENTRIC won.</li>
        }
    private static class ShuffleAwareDataFusionBackend extends MockDataFusionBackend {
        RelNode rightScan = stubScan(mockTable(rightIdx, "status", "size"));
            when(indexMetadata.getNumberOfShards()).thenReturn(shardCount);
    }
    // ── helpers ────────────────────────────────────────────────────────────
            "agg over large×small join must distribute the join (broadcast or shuffle), not gather the fact:\n"
    /**
        assertDoesNotContainShuffleExchange("modest asymmetry must not shuffle a tiny dim", result);
    }
            ? rexBuilder.makeCall(
     *  metadata for the requested shard counts. */
        when(nodes.getDataNodes()).thenReturn(dataNodes);
    /**
            )
     */
            /* mppEnabled */ true
            if (containsNodeOfType(input, type)) return true;
            Map.of("fact_large", LARGE, "dim_a", SMALL, "dim_b", SMALL),
        PlannerContext context = buildMppContext(
/**
    // ── Scenario 2: large × large ──────────────────────────────────────────
 */
    public void testAggregateOverThreeWayJoin_strategy() {
                SqlStdOperatorTable.EQUALS,
        );
     * ratio scenarios above passed throughout (broadcast wins by orders of magnitude regardless), so
     *  via PlannerContext.tableRowCounts; the cluster nodes feed broadcast probe-count
        );
    public void testHighlyAsymmetricFavorsBroadcast() {
 *   <li>small × large, mpp.enabled=true → BROADCAST (small as build).</li>
}
            return parallelism;
    public void testThetaJoinAlwaysCoordCentric() {
        );
    }
            dataNodes.put("node-" + i, mock(DiscoveryNode.class));
    private static boolean containsNodeOfType(RelNode node, Class<? extends RelNode> type) {
            Map.of("fact_large", 3, "dim_a", 3, "dim_b", 3),
            /* mppEnabled */ true
     *  {@code AND(left.col0 = right.col0, left.col1 < right.col1)}. This is the TPC-H q14 shape
     * correct: each preserved-side row and its matches land in one partition, so null-fill is
import org.apache.calcite.rel.core.JoinRelType;
            /* mppEnabled */ true
    /** Build a ClusterState with multiple stubbed data nodes (so probeNodes > 1) and per-index
    public void testLeftOuterJoinLargeLargeShuffles() {
     * A LEFT OUTER equi-join over two large sides must hash-shuffle, NOT gather to the coordinator
        assertDoesNotContainBroadcastExchange("mpp.enabled=false must NOT produce broadcast", result);
     */
        RexNode cond1 = rexBuilder.makeCall(
    private static void assertContainsBroadcastExchange(String message, RelNode tree) {
    private PlannerContext buildMppContext(Map<String, Integer> shardCounts, Map<String, Long> rowCounts, boolean mppEnabled) {
     * coordinator-centric for the small-dim × large-fact join. With widthFactor applied uniformly
            Map.of("small_idx", 3, "large_idx", 3),
        int leftCols = leftScan.getRowType().getFieldCount();
    /** Subclass of MockDataFusionBackend that opts into MPP shuffle by overriding
        RelNode result = runPlanner(aggOverJoin, context);
import org.opensearch.analytics.planner.rel.OpenSearchShuffleExchange;
     * they did NOT catch this — this modest-ratio case is the guard.
        // what the mock cluster state's index mappings declare.
            SqlStdOperatorTable.LESS_THAN,
     * A join with an equi key AND a residual non-equi predicate (q14: l_partkey=p_partkey AND
        // assertion because the choice depends on cost-coefficient tuning rather than
    // ── Contract: mpp.enabled=false ────────────────────────────────────────
        @Override
        RelNode aggOverJoin = makeAggregate(join, sumCall(join));
            /* mppEnabled */ true
 * SPDX-License-Identifier: Apache-2.0
     * filter.
     */
            Map.of("dim_idx", 3, "fact_idx", 3),
            Map.of("big_left", 3, "big_right", 3),
            Map.of("big_left", 3, "big_right", 3),
            );
            when(indexMetadata.mapping()).thenReturn(mappingMetadata);
    public void testMppDisabledForcesCoordCentric() {
    /**
            Map.of("big_left", LARGE, "big_right", LARGE),
        Function<IndexMetadata, FieldStorageResolver> fieldStorageFactory = FieldStorageResolver::new;
 * <ol>
        //
        return LogicalJoin.create(leftScan, rightScan, List.of(), condition, Set.of(), joinType);
        assertContainsBroadcastExchange("dim (small) × fact (large) must pick BROADCAST", result);
        RexNode condition = equi
        );
        );
    }
        private final int parallelism;
        RelNode leftScan = stubScan(mockTable(leftIdx, "status", "size"));
            message + "\nactual plan:\n" + org.apache.calcite.plan.RelOptUtil.toString(tree),
        }
            rexBuilder.makeInputRef(intType, 1),
    }
            message + "\nactual plan:\n" + org.apache.calcite.plan.RelOptUtil.toString(tree),
        // wins because replicating the small side costs less than shuffling both sides. This
        );
    private static final long SMALL = 1_000L;
            rexBuilder.makeInputRef(intType, j1Cols)
        RelNode dimB = stubScan(mockTable("dim_b", "status", "size"));
        when(state.nodes()).thenReturn(nodes);
    /**
    }
        RelNode result = runPlanner(makeMixedEquiResidualJoin(context, "small_idx", "large_idx"), context);
     * split rules carry no INNER-only gate, and hash-partitioning a LEFT equi-join on the join key is
        );
        assertDoesNotContainShuffleExchange("pure theta must NOT shuffle (no equi key)", result);
    }
        RelNode dimA = stubScan(mockTable("dim_a", "status", "size"));
        );
import org.apache.calcite.rel.type.RelDataType;
        // broadcast ≈ 3k vs hash ≈ 10M+1k → broadcast wins decisively.
                    .build()
        RelNode result = runPlanner(makeJoin(context, "big_left", "big_right", JoinRelType.INNER, /* equi */ false), context);
            "agg over 3-way (fact×dim×dim) join must distribute, not gather the fact to coordinator:\n"
            SqlStdOperatorTable.EQUALS,
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
        assertDoesNotContainBroadcastExchange("large × large must not broadcast (would replicate 10M rows × 3 nodes)", result);
        // Quantitative: broadcast cost ≈ small_rows × N; hash cost ≈ small_rows + large_rows.
    // ── Aggregate ABOVE a join (TPC-H q2/q11 shape) ───────────────────────
     * upstream merge added {@code widthFactor} to {@code OpenSearchExchangeReducer.computeSelfCost}
     * partition-local (standard Spark/Presto behavior). The worker join keeps joinType=LEFT verbatim;
        RelNode result = runPlanner(makeJoin(context, "big_left", "big_right", JoinRelType.INNER, /* equi */ true), context);
            Map.of("big_left", LARGE, "big_right", LARGE),
    }
            "modest 6x asymmetry (dim=5 × fact=30, the BroadcastJoinIT shape) must still pick BROADCAST",
        RexNode equi = rexBuilder.makeCall(
        if (type.isInstance(unwrapped)) {
        RexNode residual = rexBuilder.makeCall(
    /** Recursively walk the result tree to find any node of the given type. */
        Map<String, DiscoveryNode> dataNodes = new HashMap<>();
    private RelNode makeMixedEquiResidualJoin(PlannerContext context, String leftIdx, String rightIdx) {
        );
        PlannerContext context = buildMppContext(
 *   <li>any equi, mpp.enabled=false → COORDINATOR_CENTRIC.</li>
            broadcast || shuffle
        assertTrue(
     *  (l_partkey=p_partkey AND l_shipdate BETWEEN …). JoinInfo.analyzeCondition() yields non-empty
            Map.of("dim_small", 1, "fact_large", 5),
        PlannerContext context = buildMppContext(
        assertTrue(
        RexNode condition = rexBuilder.makeCall(SqlStdOperatorTable.AND, equi, residual);
        assertTrue(
        );
            broadcast || shuffle
        assertFalse(
    }
        return LogicalJoin.create(leftScan, rightScan, List.of(), condition, Set.of(), JoinRelType.INNER);
    // ── Scenario 3: asymmetric sizes ───────────────────────────────────────
    private static void assertDoesNotContainBroadcastExchange(String message, RelNode tree) {
    }
        return new PlannerContext(registry, state, settings, rowCountLookup, /* profiling */ false);
            this.parallelism = parallelism;
    /** Build a LogicalJoin between two indices with the given join shape, filtered through
    // ── Mixed equi + residual non-equi (TPC-H q14 shape) ───────────────────
                rexBuilder.makeInputRef(intType, 0),
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
 * compatible open source license.
            containsNodeOfType(tree, OpenSearchShuffleExchange.class)
        assertTrue(
        RelNode result = runPlanner(makeJoin(context, "dim_idx", "fact_idx", JoinRelType.INNER, /* equi */ true), context);
    }
        PlannerContext context = buildMppContext(
     */
            containsNodeOfType(tree, OpenSearchBroadcastExchange.class)
            Map.of("dim_idx", SMALL, "fact_idx", LARGE),
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        boolean broadcast = containsNodeOfType(result, OpenSearchBroadcastExchange.class);
            /* mppEnabled */ false
    }
            rexBuilder.makeInputRef(intType, 0),
        // shuffle exchange anywhere.
 * row counts, runs the full {@link PlannerImpl#runAllOptimizations} pipeline (HEP marking
        int factCols = fact.getRowType().getFieldCount();
        }
    private static final int CLUSTER_DATA_NODES = 3;
    public void testMixedEquiResidualJoinStillUsesMpp() {
     * MODEST asymmetry (the {@code BroadcastJoinIT} shape: dim≈5 rows, fact≈30 rows — only a ~6×
            when(mappingMetadata.sourceAsMap()).thenReturn(Map.of("properties", intFields()));
        int j1Cols = j1.getRowType().getFieldCount();
 * <p>The 3 scenarios + 2 contract enforcers map to M2's strategy table:
public class JoinStrategyCBOSelectionTests extends BasePlannerRulesTests {
 *
        RelNode rightScan = stubScan(mockTable(rightIdx, "status", "size"));
        return false;
     * across all three exchanges the pre-merge ratio is restored and BROADCAST wins again. The big-
        //
     * ({@code … join … | stats sum(x) by key}) — the TPC-H q11 bottom-join shape. At sf=10 this
        PlannerContext context = buildMppContext(
    }
    public void testModestAsymmetryStillPicksBroadcast() {
 *   <li>{@link OpenSearchBroadcastExchange} above the build side → BROADCAST won.</li>
            MappingMetadata mappingMetadata = mock(MappingMetadata.class);
    private static final long LARGE = 10_000_000L;
            rexBuilder.makeInputRef(intType, leftCols + 1)
        );
        }
        return state;
        // architectural correctness. Either pick is defensible at that scale.
 * this file be licensed under the Apache-2.0 license or a
        );
package org.opensearch.analytics.planner;
            rexBuilder.makeInputRef(intType, 0),
     * gathers the 8M-row fact to the coordinator (ReduceSizeExceeded). The bare join (no agg) picks
import org.opensearch.cluster.metadata.Metadata;
 *   <li>{@link OpenSearchShuffleExchange} above each side → HASH_SHUFFLE won.</li>
 */
    public void testSmallByLargeMppEnabledPicksBroadcast() {
            Map.of("small_idx", 3, "large_idx", 3),
        );
        RelNode unwrapped = RelNodeUtils.unwrapHep(node);
        RelNode result = runPlanner(makeJoin(context, "big_left", "big_right", JoinRelType.INNER, /* equi */ true), context);
     * ratio, not the 10,000× of the other scenarios). This is the case that regressed when the
        ShuffleAwareDataFusionBackend(int parallelism) {
import java.util.HashMap;
    }
        );
    }
            Map.of("big_left", LARGE, "big_right", LARGE),
        // The "small × small" case (1k vs 1k) is intentionally NOT tested as a strategy
            rexBuilder.makeInputRef(intType, factCols)
        // refuse to fire on non-equi predicates.
        // is the canonical fact-dim join shape (small dim, large fact).
        ClusterState state = mock(ClusterState.class);
import java.util.List;
                rexBuilder.makeInputRef(intType, 0),
        boolean broadcast = containsNodeOfType(result, OpenSearchBroadcastExchange.class);
     *  rule's probeNodes > 1 gate pass. */
                rexBuilder.makeInputRef(intType, leftCols)
        RelNode join = makeJoin(context, "fact_large", "dim_small", JoinRelType.INNER, /* equi */ true);
        assertTrue(
        );
import org.opensearch.cluster.metadata.MappingMetadata;
 *   <li>large × large, mpp.enabled=true → HASH_SHUFFLE.</li>
                    .putList("index.composite.secondary_data_formats", "lucene")
            /* mppEnabled */ true
import org.opensearch.cluster.node.DiscoveryNode;
    }
        int leftCols = leftScan.getRowType().getFieldCount();
import java.util.function.ToLongFunction;
                SqlStdOperatorTable.LESS_THAN,
        assertContainsBroadcastExchange("small × large with mpp.enabled must pick BROADCAST", result);
        boolean shuffle = containsNodeOfType(result, OpenSearchShuffleExchange.class);
        PlannerContext context = buildMppContext(
     * at scale. small × large picks BROADCAST; the equi key partitions, the residual rides as a join
        assertContainsShuffleExchange("large LEFT OUTER equi-join must hash-shuffle, not gather to coordinator", result);
            Map.of("fact_large", 3, "dim_small", 3),
     */
     * structure (partsupp ⋈ supplier ⋈ nation | stats sum by key). Checks whether the multi-way shape
    private static void assertContainsShuffleExchange(String message, RelNode tree) {
            when(metadata.index(indexName)).thenReturn(indexMetadata);
        // The cost-model contract: when one side is ≪ N× smaller than the other, BROADCAST
            Map.of("dim_small", 5L, "fact_large", 30L),
        );
    private static void assertDoesNotContainShuffleExchange(String message, RelNode tree) {
            Map.of("big_left", LARGE, "big_right", LARGE),
        RelNode leftScan = stubScan(mockTable(leftIdx, "status", "size"));
            containsNodeOfType(tree, OpenSearchShuffleExchange.class)
            /* mppEnabled */ true
 * <p>Each scenario constructs an {@link OpenSearchJoin} over two indices with explicit
        for (int i = 0; i < CLUSTER_DATA_NODES; i++) {
            IndexMetadata indexMetadata = mock(IndexMetadata.class);
import java.util.function.Function;
        );
     * to coordinator-centric. Before the fix the split rules gated on {@code !info.isEqui()}, so the
import static org.mockito.Mockito.when;
 * → CBO), then walks the result tree to find which exchange type Volcano materialized:
import org.apache.calcite.rex.RexNode;
    // ── Scenario 1: small × large ──────────────────────────────────────────
 *   <li>small × small, mpp.enabled=true → BROADCAST (small build cheap to replicate).</li>
            /* mppEnabled */ true
     * BROADCAST; this test checks whether the aggregate ABOVE the join suppresses that.
     *  estimation; the shuffle-aware backend's defaultShuffleParallelism makes the hash
        );
        }
        RelNode j1 = LogicalJoin.create(fact, dimA, List.of(), cond1, Set.of(), JoinRelType.INNER);
                Settings.builder()
     * residual predicate forced the whole (large) join to gather to the coordinator → ReduceSizeExceeded
        assertDoesNotContainBroadcastExchange("theta join must NOT broadcast (only coord-centric is legal)", result);
 * <ul>
        assertDoesNotContainBroadcastExchange("pure theta must NOT broadcast (no equi key)", result);
            result
        RelNode result = runPlanner(makeJoin(context, "big_left", "big_right", JoinRelType.INNER, /* equi */ false), context);
        RelNode result = runPlanner(makeJoin(context, "small_idx", "large_idx", JoinRelType.INNER, /* equi */ true), context);
            : rexBuilder.makeCall(
    public void testPureThetaStillCoordCentricAfterRelax() {
        boolean shuffle = containsNodeOfType(result, OpenSearchShuffleExchange.class);
        when(state.metadata()).thenReturn(metadata);
            rexBuilder.makeInputRef(intType, 0),
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
            Map.of("big_left", 3, "big_right", 3),
        boolean shuffle = containsNodeOfType(result, OpenSearchShuffleExchange.class);
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
    }
 *
     *  leftKeys but isEqui()=false; the MPP split rules must still fire on the equi key. */
     *  shuffle-aware backend. The row counts feed {@code IndexNameTable.getRowCount()}
        );
        assertFalse(
    }
 * The load-bearing spike validator: does Volcano pick the right join strategy from row
        RelNode result = runPlanner(makeJoin(context, "dim_small", "fact_large", JoinRelType.INNER, /* equi */ true), context);
        );
import java.util.Map;
            when(indexMetadata.getIndex()).thenReturn(new Index(indexName, indexName + "-uuid"));
            int shardCount = entry.getValue();
    }
        // produces an alternative. The result has plain ER over each side, no broadcast or
            Map.of("big_left", LARGE, "big_right", LARGE),
    private static ClusterState mockClusterStateWithDataNodes(Map<String, Integer> shardCounts) {
import org.opensearch.cluster.ClusterState;
        // With mpp.enabled=false, neither broadcast nor hash rule fires; only coord-centric
        public int defaultShuffleParallelism(ClusterState state) {
 * counts and cluster topology? This is what answers M2's go/no-go question.
            when(indexMetadata.getSettings()).thenReturn(
 * </ol>
        RelNode fact = stubScan(mockTable("fact_large", "status", "size"));
    /** Build an INNER join whose condition is an equi key AND a residual non-equi predicate:
 * </ul>
        // Diagnostic assertion: an agg over a large×small join should STILL distribute the join
        Metadata metadata = mock(Metadata.class);
import org.apache.calcite.sql.type.SqlTypeName;
        assertContainsBroadcastExchange(
        RexNode cond2 = rexBuilder.makeCall(
        assertDoesNotContainShuffleExchange("theta join must NOT shuffle (only coord-centric is legal)", result);
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        // (broadcast the dim, or shuffle) — not gather the 8M fact to the coordinator.
    public void testAggregateOverLargeSmallJoin_strategy() {
        PlannerContext context = buildMppContext(
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RelNode result = runPlanner(makeJoin(context, "big_left", "big_right", JoinRelType.LEFT, /* equi */ true), context);
     *  predicate. */
        );
        ClusterState state = mockClusterStateWithDataNodes(shardCounts);
        RelNode result = runPlanner(aggOverJoin, context);
        // > 1 gate passes.
        );
                rexBuilder.makeInputRef(intType, leftCols)
        PlannerContext context = buildMppContext(
        assertContainsShuffleExchange("large × large with mpp.enabled must pick HASH_SHUFFLE", result);
 * The OpenSearch Contributors require contributions made to
    }
        RelNode aggOverJoin = makeAggregate(j2, sumCall(j2));
        assertDoesNotContainShuffleExchange("small × large must not shuffle", result);
        // Field names must match BasePlannerRulesTests.intFields() ("status", "size") — that's
        PlannerContext context = buildMppContext(
            message + "\nactual plan:\n" + org.apache.calcite.plan.RelOptUtil.toString(tree),
    /** Row counts that should make the cost model pick each strategy clearly. */
                + org.apache.calcite.plan.RelOptUtil.toString(result),
import org.opensearch.analytics.planner.rel.OpenSearchBroadcastExchange;
            );
    /**
                + org.apache.calcite.plan.RelOptUtil.toString(result),
     * l_shipdate BETWEEN …) must STILL route through an MPP strategy on its equi key — NOT fall back
            rexBuilder.makeInputRef(intType, leftCols)
    private RelNode makeJoin(PlannerContext context, String leftIdx, String rightIdx, JoinRelType joinType, boolean equi) {
        AnalyticsSearchBackendPlugin shuffleAware = new ShuffleAwareDataFusionBackend(CLUSTER_DATA_NODES);
import org.opensearch.cluster.node.DiscoveryNodes;
        );
            "mixed equi+residual join must route via an MPP strategy (broadcast or shuffle), not coord-centric:\n"
     * (TPC-H q13: customer LEFT JOIN orders → ReduceSizeExceeded when coord-centric at scale). The
        Settings settings = Settings.builder().put("analytics.mpp.enabled", mppEnabled).build();
            Map.of("big_left", 3, "big_right", 3),
                + org.apache.calcite.plan.RelOptUtil.toString(result),
    /** Build a planner context with explicit row counts + multi-data-node cluster + custom
     * DataFusion's HashJoinExec does the partition-local null-fill.
            String indexName = entry.getKey();
     * DIAGNOSTIC (#32): a 3-way fact ⋈ dim1 ⋈ dim2 INNER join feeding an aggregate — the TPC-H q11
            Map.of("small_idx", SMALL, "large_idx", LARGE),
import org.apache.calcite.rel.RelNode;
            containsNodeOfType(tree, OpenSearchBroadcastExchange.class)
            Map.of("big_left", 3, "big_right", 3),
 *   <li>theta, any setting → COORDINATOR_CENTRIC.</li>
    }
        // Use a shuffle-aware DataFusion backend so OpenSearchHashJoinSplitRule's partitionCount
        // Broadcast wins iff small_rows × (N - 1) < large_rows. With small=1k, large=10M, N=3:
            /* mppEnabled */ true
            Map.of("small_idx", SMALL, "large_idx", LARGE),
        PlannerContext context = buildMppContext(
     * hash-partition / no key for the broadcast probe, so neither MPP rule may fire.
import org.apache.calcite.rel.logical.LogicalJoin;
import org.opensearch.core.index.Index;
            return true;
            /* mppEnabled */ true
        RelNode j2 = LogicalJoin.create(j1, dimB, List.of(), cond2, Set.of(), JoinRelType.INNER);
            broadcast || shuffle
import org.opensearch.common.settings.Settings;
            message + "\nactual plan:\n" + org.apache.calcite.plan.RelOptUtil.toString(tree),
    public void testLargeByLargeMppEnabledPicksHashShuffle() {
import java.util.Set;
        assertDoesNotContainShuffleExchange("mpp.enabled=false must NOT produce shuffle", result);
                    .put("index.composite.primary_data_format", "parquet")
        PlannerContext context = buildMppContext(
            SqlStdOperatorTable.EQUALS,
     */
        for (Map.Entry<String, Integer> entry : shardCounts.entrySet()) {
     * but NOT to the broadcast/shuffle exchanges: the distorted cost ratio made CBO fall back to
    // ── Outer joins (TPC-H q13 shape) ──────────────────────────────────────
        }
     * the relaxation only admits joins that HAVE an equi key. Without an equi key there is nothing to
