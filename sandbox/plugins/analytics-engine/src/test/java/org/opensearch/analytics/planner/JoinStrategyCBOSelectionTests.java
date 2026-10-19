 * this file be licensed under the Apache-2.0 license or a
                rexBuilder.makeInputRef(intType, 0),  
        RelNode result = runPlanner(makeJoin(context, "big_left", "big_right", JoinRelType.LEFT, /* equi */ true), context);
 *   <li>small × large, mpp.enabled=true → BROADCAST (small as build).</li>
        assertDoesNotContainBroadcastExchange("theta join must NOT broadcast (only coord-centric is legal)", result);  
        boolean shuffle = containsNodeOfType(result, OpenSearchShuffleExchange.class);
        }
    }
    private static final int CLUSTER_DATA_NODES = 3;
     *  (l_partkey=p_partkey AND l_shipdate BETWEEN …). JoinInfo.analyzeCondition() yields non-empty
     */
            Map.of("big_left", LARGE, "big_right", LARGE),  
        // (broadcast the dim, or shuffle) — not gather the 8M fact to the coordinator.
     */
    // ── Contract: theta join ───────────────────────────────────────────────  
            "agg over large×small join must distribute the join (broadcast or shuffle), not gather the fact:\n"  
            Map.of("dim_small", 5L, "fact_large", 30L),
            );
            Map.of("big_left", LARGE, "big_right", LARGE),
            rexBuilder.makeInputRef(intType, 0),  
    }
    /** Row counts that should make the cost model pick each strategy clearly. */
     *  leftKeys but isEqui()=false; the MPP split rules must still fire on the equi key. */  
            Map.of("small_idx", SMALL, "large_idx", LARGE),  
     * at scale. small × large picks BROADCAST; the equi key partitions, the residual rides as a join  
    // ── Scenario 3: asymmetric sizes ───────────────────────────────────────
        // Quantitative: broadcast cost ≈ small_rows × N; hash cost ≈ small_rows + large_rows.
 *   <li>{@link OpenSearchBroadcastExchange} above the build side → BROADCAST won.</li>  
     *  PlannerImpl. The join condition is either an equi (col0 == col0) or theta (col0 LT col0)
import org.apache.calcite.rel.RelNode;
     * BROADCAST; this test checks whether the aggregate ABOVE the join suppresses that.
     * MODEST asymmetry (the {@code BroadcastJoinIT} shape: dim≈5 rows, fact≈30 rows — only a ~6×
            when(indexMetadata.getNumberOfShards()).thenReturn(shardCount);
            containsNodeOfType(tree, OpenSearchBroadcastExchange.class)
    }  
        );
 * The load-bearing spike validator: does Volcano pick the right join strategy from row
        assertFalse(  
        int leftCols = leftScan.getRowType().getFieldCount();
            /* mppEnabled */ false
            message + "\nactual plan:\n" + org.apache.calcite.plan.RelOptUtil.toString(tree),  
     * DIAGNOSTIC (#32): a large-fact × small-dim INNER equi-join FEEDING an aggregate
        RelNode rightScan = stubScan(mockTable(rightIdx, "status", "size"));  
import org.apache.calcite.rex.RexNode;
     * gathers the 8M-row fact to the coordinator (ReduceSizeExceeded). The bare join (no agg) picks  
        // produces an alternative. The result has plain ER over each side, no broadcast or  
        // The "small × small" case (1k vs 1k) is intentionally NOT tested as a strategy  
     * A LEFT OUTER equi-join over two large sides must hash-shuffle, NOT gather to the coordinator
            when(indexMetadata.getSettings()).thenReturn(
    public void testMixedEquiResidualJoinStillUsesMpp() {  
    private static void assertDoesNotContainBroadcastExchange(String message, RelNode tree) {
        ClusterState state = mock(ClusterState.class);
 *
        RelNode result = runPlanner(makeJoin(context, "dim_idx", "fact_idx", JoinRelType.INNER, /* equi */ true), context);
            when(metadata.index(indexName)).thenReturn(indexMetadata);
            Map.of("big_left", 3, "big_right", 3),
    /**  
            IndexMetadata indexMetadata = mock(IndexMetadata.class);
        when(state.metadata()).thenReturn(metadata);
            Map.of("big_left", 3, "big_right", 3),
        // Diagnostic assertion: an agg over a large×small join should STILL distribute the join  
        private final int parallelism;
    /** Recursively walk the result tree to find any node of the given type. */
        // Field names must match BasePlannerRulesTests.intFields() ("status", "size") — that's
    private RelNode makeMixedEquiResidualJoin(PlannerContext context, String leftIdx, String rightIdx) {
     * (vs the 2-way above) is what stops the bottom join distributing on the cluster.  
            "modest 6x asymmetry (dim=5 × fact=30, the BroadcastJoinIT shape) must still pick BROADCAST",
        when(state.nodes()).thenReturn(nodes);
        AnalyticsSearchBackendPlugin shuffleAware = new ShuffleAwareDataFusionBackend(CLUSTER_DATA_NODES);
     *  metadata for the requested shard counts. */  
        assertDoesNotContainShuffleExchange("theta join must NOT shuffle (only coord-centric is legal)", result);
            Map.of("small_idx", 3, "large_idx", 3),
        boolean broadcast = containsNodeOfType(result, OpenSearchBroadcastExchange.class);
        return LogicalJoin.create(leftScan, rightScan, List.of(), condition, Set.of(), joinType);  
            /* mppEnabled */ true
        RelNode j2 = LogicalJoin.create(j1, dimB, List.of(), cond2, Set.of(), JoinRelType.INNER);
            Map.of("big_left", 3, "big_right", 3),  
        RexNode condition = rexBuilder.makeCall(SqlStdOperatorTable.AND, equi, residual);
     */
            ? rexBuilder.makeCall(
    }  
        PlannerContext context = buildMppContext(  
 * counts and cluster topology? This is what answers M2's go/no-go question.  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
 * </ul>  
            result  
    }  
 * <p>Each scenario constructs an {@link OpenSearchJoin} over two indices with explicit
        RexNode cond2 = rexBuilder.makeCall(
        //
        Map<String, DiscoveryNode> dataNodes = new HashMap<>();
    private static void assertContainsBroadcastExchange(String message, RelNode tree) {
            );
    /**
import org.opensearch.analytics.planner.rel.OpenSearchBroadcastExchange;
     * structure (partsupp ⋈ supplier ⋈ nation | stats sum by key). Checks whether the multi-way shape
        // Even with mpp.enabled=true, theta routes coord-centric — broadcast and hash rules  
            Map.of("big_left", LARGE, "big_right", LARGE),
        // architectural correctness. Either pick is defensible at that scale.
 * <ul>
    /** Build a planner context with explicit row counts + multi-data-node cluster + custom
        // > 1 gate passes.  
        RelNode result = runPlanner(aggOverJoin, context);
            Map.of("fact_large", 3, "dim_a", 3, "dim_b", 3),
            containsNodeOfType(tree, OpenSearchBroadcastExchange.class)
        RelNode leftScan = stubScan(mockTable(leftIdx, "status", "size"));
        PlannerContext context = buildMppContext(  
        assertTrue(
import org.opensearch.cluster.node.DiscoveryNodes;
     */  
            when(indexMetadata.getIndex()).thenReturn(new Index(indexName, indexName + "-uuid"));  
            Map.of("fact_large", LARGE, "dim_small", SMALL),  
    }
                    .putList("index.composite.secondary_data_formats", "lucene")
import java.util.function.Function;
        ToLongFunction<String> rowCountLookup = name -> rowCounts.getOrDefault(name, PlannerContext.UNKNOWN_ROW_COUNT);  
        RexNode condition = equi
            int shardCount = entry.getValue();
        Settings settings = Settings.builder().put("analytics.mpp.enabled", mppEnabled).build();
            rexBuilder.makeInputRef(intType, factCols)
        boolean shuffle = containsNodeOfType(result, OpenSearchShuffleExchange.class);  
 *   <li>Plain {@code OpenSearchExchangeReducer} above each side → COORDINATOR_CENTRIC won.</li>
     * ({@code … join … | stats sum(x) by key}) — the TPC-H q11 bottom-join shape. At sf=10 this
        PlannerContext context = buildMppContext(  
        );
        PlannerContext context = buildMppContext(
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
            /* mppEnabled */ true
import org.opensearch.common.settings.Settings;  
     * split rules carry no INNER-only gate, and hash-partitioning a LEFT equi-join on the join key is  
    private static void assertDoesNotContainShuffleExchange(String message, RelNode tree) {
import java.util.List;
        );
    }  
            rexBuilder.makeInputRef(intType, leftCols + 1)
        PlannerContext context = buildMppContext(
     * ratio, not the 10,000× of the other scenarios). This is the case that regressed when the  
        );
        // With mpp.enabled=false, neither broadcast nor hash rule fires; only coord-centric
            when(mappingMetadata.sourceAsMap()).thenReturn(Map.of("properties", intFields()));  
 */
        );
        PlannerContext context = buildMppContext(
        RelNode dimA = stubScan(mockTable("dim_a", "status", "size"));  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
    private PlannerContext buildMppContext(Map<String, Integer> shardCounts, Map<String, Long> rowCounts, boolean mppEnabled) {  
                    .build()  
        boolean broadcast = containsNodeOfType(result, OpenSearchBroadcastExchange.class);
        RelNode j1 = LogicalJoin.create(fact, dimA, List.of(), cond1, Set.of(), JoinRelType.INNER);  
     * but NOT to the broadcast/shuffle exchanges: the distorted cost ratio made CBO fall back to
        RelNode result = runPlanner(makeJoin(context, "big_left", "big_right", JoinRelType.INNER, /* equi */ false), context);
        );  
    // ── Scenario 2: large × large ──────────────────────────────────────────
            rexBuilder.makeInputRef(intType, 0),
            rexBuilder.makeInputRef(intType, j1Cols)
        ShuffleAwareDataFusionBackend(int parallelism) {
     * residual predicate forced the whole (large) join to gather to the coordinator → ReduceSizeExceeded
 * <ol>  
        RelNode result = runPlanner(makeMixedEquiResidualJoin(context, "small_idx", "large_idx"), context);  
        RelNode aggOverJoin = makeAggregate(j2, sumCall(j2));
    private static class ShuffleAwareDataFusionBackend extends MockDataFusionBackend {
            message + "\nactual plan:\n" + org.apache.calcite.plan.RelOptUtil.toString(tree),
import org.apache.calcite.sql.type.SqlTypeName;
        if (type.isInstance(unwrapped)) {
    // ── Outer joins (TPC-H q13 shape) ──────────────────────────────────────
                + org.apache.calcite.plan.RelOptUtil.toString(result),  
            SqlStdOperatorTable.EQUALS,
    }
        );  
     * hash-partition / no key for the broadcast probe, so neither MPP rule may fire.
            Map.of("big_left", 3, "big_right", 3),  
 *   <li>{@link OpenSearchShuffleExchange} above each side → HASH_SHUFFLE won.</li>
        RelNode result = runPlanner(aggOverJoin, context);  
        assertContainsShuffleExchange("large LEFT OUTER equi-join must hash-shuffle, not gather to coordinator", result);
    /** Subclass of MockDataFusionBackend that opts into MPP shuffle by overriding
     *  estimation; the shuffle-aware backend's defaultShuffleParallelism makes the hash
        // wins because replicating the small side costs less than shuffling both sides. This
        RelNode result = runPlanner(makeJoin(context, "big_left", "big_right", JoinRelType.INNER, /* equi */ true), context);  
        PlannerContext context = buildMppContext(
            containsNodeOfType(tree, OpenSearchShuffleExchange.class)
        }  
        );
     * (TPC-H q13: customer LEFT JOIN orders → ReduceSizeExceeded when coord-centric at scale). The
        assertDoesNotContainBroadcastExchange("pure theta must NOT broadcast (no equi key)", result);  
    // ── Contract: mpp.enabled=false ────────────────────────────────────────
            broadcast || shuffle
 * </ol>  
            broadcast || shuffle
        );
 *
    }  
    // ── Scenario 1: small × large ──────────────────────────────────────────  
    public void testMppDisabledForcesCoordCentric() {  
 * row counts, runs the full {@link PlannerImpl#runAllOptimizations} pipeline (HEP marking  
        assertTrue(
        RexNode residual = rexBuilder.makeCall(
            Map.of("big_left", LARGE, "big_right", LARGE),
    public void testAggregateOverLargeSmallJoin_strategy() {  
        RelNode result = runPlanner(makeJoin(context, "dim_small", "fact_large", JoinRelType.INNER, /* equi */ true), context);
        // Use a shuffle-aware DataFusion backend so OpenSearchHashJoinSplitRule's partitionCount
    /** Build an INNER join whose condition is an equi key AND a residual non-equi predicate:  
    private static boolean containsNodeOfType(RelNode node, Class<? extends RelNode> type) {
import org.apache.calcite.rel.logical.LogicalJoin;  
import static org.mockito.Mockito.when;
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        assertFalse(
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);  
        }  
import org.opensearch.cluster.metadata.Metadata;  
        Function<IndexMetadata, FieldStorageResolver> fieldStorageFactory = FieldStorageResolver::new;
                + org.apache.calcite.plan.RelOptUtil.toString(result),
    // ── Aggregate ABOVE a join (TPC-H q2/q11 shape) ───────────────────────
        return state;
    /**  
     * correct: each preserved-side row and its matches land in one partition, so null-fill is
/*  
        int j1Cols = j1.getRowType().getFieldCount();
import java.util.Set;  
            SqlStdOperatorTable.EQUALS,  
    }  
     *  rule's probeNodes > 1 gate pass. */
        );  
    }  
 *   <li>large × large, mpp.enabled=true → HASH_SHUFFLE.</li>
            Map.of("big_left", LARGE, "big_right", LARGE),
 *   <li>theta, any setting → COORDINATOR_CENTRIC.</li>
            this.parallelism = parallelism;
 * <p>The 3 scenarios + 2 contract enforcers map to M2's strategy table:
 *
                SqlStdOperatorTable.EQUALS,  
                rexBuilder.makeInputRef(intType, leftCols)
        );
    // ── Mixed equi + residual non-equi (TPC-H q14 shape) ───────────────────
        assertDoesNotContainShuffleExchange("mpp.enabled=false must NOT produce shuffle", result);  
        );  
     * DataFusion's HashJoinExec does the partition-local null-fill.  
        int leftCols = leftScan.getRowType().getFieldCount();
        return false;
    public void testLeftOuterJoinLargeLargeShuffles() {
 * → CBO), then walks the result tree to find which exchange type Volcano materialized:
        RelNode leftScan = stubScan(mockTable(leftIdx, "status", "size"));  
        );
    private RelNode makeJoin(PlannerContext context, String leftIdx, String rightIdx, JoinRelType joinType, boolean equi) {  
import org.opensearch.cluster.metadata.MappingMetadata;
            SqlStdOperatorTable.LESS_THAN,  
 * SPDX-License-Identifier: Apache-2.0
     * ratio scenarios above passed throughout (broadcast wins by orders of magnitude regardless), so
import org.opensearch.cluster.ClusterState;  
     * upstream merge added {@code widthFactor} to {@code OpenSearchExchangeReducer.computeSelfCost}
     * partition-local (standard Spark/Presto behavior). The worker join keeps joinType=LEFT verbatim;
            /* mppEnabled */ true  
            : rexBuilder.makeCall(
        public int defaultShuffleParallelism(ClusterState state) {  
        );
            Map.of("big_left", 3, "big_right", 3),  
        }  
        int factCols = fact.getRowType().getFieldCount();  
     *  predicate. */
import org.apache.calcite.rel.type.RelDataType;
        // Broadcast wins iff small_rows × (N - 1) < large_rows. With small=1k, large=10M, N=3:  
    public void testSmallByLargeMppEnabledPicksBroadcast() {
import org.opensearch.analytics.planner.rel.OpenSearchJoin;  
    // ── helpers ────────────────────────────────────────────────────────────
        PlannerContext context = buildMppContext(  
        // assertion because the choice depends on cost-coefficient tuning rather than
     *  via PlannerContext.tableRowCounts; the cluster nodes feed broadcast probe-count  
        );
        );
        assertContainsBroadcastExchange("dim (small) × fact (large) must pick BROADCAST", result);
        for (RelNode input : unwrapped.getInputs()) {
     *  {@code defaultShuffleParallelism} to return the cluster's data-node count. */  
        ClusterState state = mockClusterStateWithDataNodes(shardCounts);
        @Override
        // what the mock cluster state's index mappings declare.
            /* mppEnabled */ true
            broadcast || shuffle
    }
            Map.of("fact_large", LARGE, "dim_a", SMALL, "dim_b", SMALL),
            /* mppEnabled */ true  
        RelNode fact = stubScan(mockTable("fact_large", "status", "size"));
    }  
        // The cost-model contract: when one side is ≪ N× smaller than the other, BROADCAST
        CapabilityRegistry registry = new CapabilityRegistry(List.of(shuffleAware, LUCENE), fieldStorageFactory);
            Map.of("dim_idx", SMALL, "fact_idx", LARGE),
            MappingMetadata mappingMetadata = mock(MappingMetadata.class);
    }
        assertDoesNotContainShuffleExchange("pure theta must NOT shuffle (no equi key)", result);
        PlannerContext context = buildMppContext(
    private static ClusterState mockClusterStateWithDataNodes(Map<String, Integer> shardCounts) {
            /* mppEnabled */ true  
        );
        RexNode cond1 = rexBuilder.makeCall(
import org.opensearch.cluster.metadata.IndexMetadata;
     * across all three exchanges the pre-merge ratio is restored and BROADCAST wins again. The big-
    }
     * to coordinator-centric. Before the fix the split rules gated on {@code !info.isEqui()}, so the
            /* mppEnabled */ true
    }
    /**
            )  
            Map.of("fact_large", 3, "dim_small", 3),
public class JoinStrategyCBOSelectionTests extends BasePlannerRulesTests {
            rexBuilder.makeInputRef(intType, leftCols)  
            message + "\nactual plan:\n" + org.apache.calcite.plan.RelOptUtil.toString(tree),  
    /**  
     *  {@code AND(left.col0 = right.col0, left.col1 < right.col1)}. This is the TPC-H q14 shape
    public void testThetaJoinAlwaysCoordCentric() {
     */
 *   <li>any equi, mpp.enabled=false → COORDINATOR_CENTRIC.</li>
    public void testPureThetaStillCoordCentricAfterRelax() {
            SqlStdOperatorTable.EQUALS,
     * they did NOT catch this — this modest-ratio case is the guard.  
        return LogicalJoin.create(leftScan, rightScan, List.of(), condition, Set.of(), JoinRelType.INNER);
            rexBuilder.makeInputRef(intType, 1),
    }
        // broadcast ≈ 3k vs hash ≈ 10M+1k → broadcast wins decisively.
                rexBuilder.makeInputRef(intType, 0),
        );
            "mixed equi+residual join must route via an MPP strategy (broadcast or shuffle), not coord-centric:\n"
        return new PlannerContext(registry, state, settings, rowCountLookup, /* profiling */ false);  
            /* mppEnabled */ true
        );  
                + org.apache.calcite.plan.RelOptUtil.toString(result),  
    }
        Metadata metadata = mock(Metadata.class);  
        RelNode unwrapped = RelNodeUtils.unwrapHep(node);  
}
        // shuffle exchange anywhere.
            /* mppEnabled */ true  
            if (containsNodeOfType(input, type)) return true;
        );  
import org.opensearch.core.index.Index;
        assertContainsShuffleExchange("large × large with mpp.enabled must pick HASH_SHUFFLE", result);  
    }
        assertDoesNotContainBroadcastExchange("large × large must not broadcast (would replicate 10M rows × 3 nodes)", result);
     */
        assertTrue(
import java.util.Map;
            containsNodeOfType(tree, OpenSearchShuffleExchange.class)  
            Map.of("dim_idx", 3, "fact_idx", 3),
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);  
import org.opensearch.cluster.node.DiscoveryNode;
     * filter.
        // is the canonical fact-dim join shape (small dim, large fact).  
        assertDoesNotContainShuffleExchange("modest asymmetry must not shuffle a tiny dim", result);
        }  
    private static void assertContainsShuffleExchange(String message, RelNode tree) {  
        RexNode equi = rexBuilder.makeCall(  
     *  shuffle-aware backend. The row counts feed {@code IndexNameTable.getRowCount()}
    /** Build a ClusterState with multiple stubbed data nodes (so probeNodes > 1) and per-index
        when(nodes.getDataNodes()).thenReturn(dataNodes);  
    /**
     * A join with an equi key AND a residual non-equi predicate (q14: l_partkey=p_partkey AND
            return true;
        boolean shuffle = containsNodeOfType(result, OpenSearchShuffleExchange.class);  
        assertDoesNotContainShuffleExchange("small × large must not shuffle", result);
            Map.of("dim_small", 1, "fact_large", 5),
        assertDoesNotContainBroadcastExchange("mpp.enabled=false must NOT produce broadcast", result);
import java.util.function.ToLongFunction;
        //
        RelNode aggOverJoin = makeAggregate(join, sumCall(join));
    private static final long LARGE = 10_000_000L;  
        RelNode dimB = stubScan(mockTable("dim_b", "status", "size"));
    public void testModestAsymmetryStillPicksBroadcast() {
            return parallelism;
        PlannerContext context = buildMppContext(  
     * coordinator-centric for the small-dim × large-fact join. With widthFactor applied uniformly  
            rexBuilder.makeInputRef(intType, 0),
                Settings.builder()  
 *   <li>small × small, mpp.enabled=true → BROADCAST (small build cheap to replicate).</li>  
            when(indexMetadata.mapping()).thenReturn(mappingMetadata);
import static org.mockito.Mockito.mock;
                SqlStdOperatorTable.LESS_THAN,
import org.apache.calcite.rel.core.JoinRelType;
        for (Map.Entry<String, Integer> entry : shardCounts.entrySet()) {
        );
    }
        );  
        assertContainsBroadcastExchange(
package org.opensearch.analytics.planner;
     * the relaxation only admits joins that HAVE an equi key. Without an equi key there is nothing to
import java.util.HashMap;  
 */  
                    .put("index.composite.primary_data_format", "parquet")
        );
            Map.of("small_idx", 3, "large_idx", 3),
        boolean broadcast = containsNodeOfType(result, OpenSearchBroadcastExchange.class);
    public void testHighlyAsymmetricFavorsBroadcast() {  
        RelNode rightScan = stubScan(mockTable(rightIdx, "status", "size"));
import org.opensearch.analytics.planner.rel.OpenSearchShuffleExchange;
            /* mppEnabled */ true  
            message + "\nactual plan:\n" + org.apache.calcite.plan.RelOptUtil.toString(tree),
        PlannerContext context = buildMppContext(
            Map.of("small_idx", SMALL, "large_idx", LARGE),
        assertContainsBroadcastExchange("small × large with mpp.enabled must pick BROADCAST", result);
 * compatible open source license.
    private static final long SMALL = 1_000L;
        RelNode result = runPlanner(makeJoin(context, "big_left", "big_right", JoinRelType.INNER, /* equi */ false), context);
     * l_shipdate BETWEEN …) must STILL route through an MPP strategy on its equi key — NOT fall back  
            String indexName = entry.getKey();  
    }
     * DIAGNOSTIC (#32): a 3-way fact ⋈ dim1 ⋈ dim2 INNER join feeding an aggregate — the TPC-H q11
        }
        assertTrue(
        RelNode result = runPlanner(makeJoin(context, "small_idx", "large_idx", JoinRelType.INNER, /* equi */ true), context);
                rexBuilder.makeInputRef(intType, leftCols)
    /** Build a LogicalJoin between two indices with the given join shape, filtered through  
     * Symmetric guard: a PURE-theta join (no equi key at all) must still route COORDINATOR-CENTRIC —  
        // refuse to fire on non-equi predicates.
        RelNode join = makeJoin(context, "fact_large", "dim_small", JoinRelType.INNER, /* equi */ true);  
            dataNodes.put("node-" + i, mock(DiscoveryNode.class));
            "agg over 3-way (fact×dim×dim) join must distribute, not gather the fact to coordinator:\n"
        for (int i = 0; i < CLUSTER_DATA_NODES; i++) {  
        assertTrue(
        RelNode result = runPlanner(makeJoin(context, "big_left", "big_right", JoinRelType.INNER, /* equi */ true), context);
/**
    public void testLargeByLargeMppEnabledPicksHashShuffle() {
    public void testAggregateOverThreeWayJoin_strategy() {
