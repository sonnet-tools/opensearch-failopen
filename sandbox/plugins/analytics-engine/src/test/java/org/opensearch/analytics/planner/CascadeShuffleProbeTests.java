            rexBuilder.makeInputRef(intType, leftCols)
    }
        );
        );
        List<RexNode> midProjects = new java.util.ArrayList<>();
            "total"
        OpenSearchJoin topJoin = findAll(enforced, OpenSearchJoin.class).stream()
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
            -1,
            CLUSTER_DATA_NODES,
        assertEquals(
        RelNode ab = LogicalJoin.create(aScan, bScan, List.of(), abCond, Set.of(), JoinRelType.INNER);
     */
        // The PARTIAL must sit DIRECTLY over the join (no group-key re-shuffle between them) — Variant A.
            "total"
        long singles = aggs.stream().filter(a -> a.getMode() == org.opensearch.analytics.planner.rel.AggregateMode.SINGLE).count();
        // columns are gone: scan shuffles carry only the referenced column, the join shuffle only
        assertTrue("no shuffle for a join below the row floor", findAll(enforced, OpenSearchShuffleExchange.class).isEmpty());
    /**
        // CROSS JOIN(a, b): condition=[true] → empty equi-keys.
    private RelNode makeThreeWayJoinTopType(PlannerContext context, JoinRelType topType) {
            .filter(
     * wrong for a global sort). Asserts PARTIAL on the worker tier and the Sort on the coordinator root.
        OpenSearchJoin innerJoin = findAll(enforced2, OpenSearchJoin.class).get(0);
        return ids;
        assertFalse("the sorted agg-over-join must still distribute", levels.isEmpty());
    public void testEnforcementPass_emptyGroupAggOverJoinDistributes() {
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);
import java.util.HashMap;
            );
     */
        org.opensearch.analytics.planner.rel.OpenSearchAggregate finalAgg = aggOfMode(
    private GeneralShuffleDAGRewriter.Structure enforceAndPromote(RelNode logical, PlannerContext context) {
            enforced,
    }
     * The enforced 3-way join DAG, promoted by {@link GeneralShuffleDAGRewriter}. Binary-tier lowering
        ShuffleEnrichment.WorkerLevel wl = levels.get(0);
    }
    }
            join,
        RelNode cbo = runPlanner(makeAggregateOverThreeWayJoin(context), context);
     * {@code COUNT() by g} over a distributed join must split so the PARTIAL keeps COUNT but the FINAL
     * coordinator-centric — the pass distributes nothing (no ShuffleExchange), matching CBO's cheap
        );
        );
    }
        );
            context.getCapabilityRegistry(),
import org.apache.calcite.rel.core.JoinRelType;
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE);
    ) {
            "a broadcast-under-cascade plan must preserve BOTH the broadcast and a shuffle (mixed shape):\n"
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);
            unwrap(topJoin.getInput(1)) instanceof OpenSearchShuffleExchange
     * avoid an un-runnable shape), the unified dispatcher now COMPOSES broadcast-under-shuffle, so the pass
     * {@link OpenSearchExchangeReducer} (gathered), and the cascade still formed below it.
            CLUSTER_DATA_NODES,
import org.apache.calcite.rex.RexNode;
            1,
    /**
        assertFalse(
     */
     * Storage-completeness regression (the sf=10 q5/q10 "RexInputRef[N] has no matching FieldStorageInfo
 * row-count parity are exercised on the live cluster).
        }
        GeneralShuffleDAGRewriter.Structure structure = GeneralShuffleDAGRewriter.rewriteStructure(
     * {@code Join(OpenSearchBroadcastExchange(build), probe)} rather than re-driving the join through the
            rexBuilder.makeInputRef(intType, aCols)
    }
                || unwrap(innerJoin.getInput(1)) instanceof OpenSearchBroadcastExchange
    private org.opensearch.analytics.planner.rel.OpenSearchAggregate aggOfMode(
        long finals = aggs.stream().filter(a -> a.getMode() == org.opensearch.analytics.planner.rel.AggregateMode.FINAL).count();
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        RelNode cbo = runPlanner(makeThreeWayJoin(context), context);
        ClusterState state = mock(ClusterState.class);
     *  {@code root}'s tree, or null. */
        RelNode cbo = runPlanner(makeAggregateOverThreeWayJoin(context), context); // COUNT() by col0
        return LogicalProject.create(join, List.of(), List.of(rb.makeInputRef(join, 0), countOver), List.of("status", "cnt"));
                + "one-row aggregate output)",
            -1,
            "worker aggregate is PARTIAL",
                producer.getTargetResolver() instanceof ShardTargetResolver
     *
            context.getDistributionTraitDef(),
        Stage nestedBuild = builds.stream().filter(b -> b.getChildStages().isEmpty() == false).findFirst().orElseThrow();
        List<OpenSearchJoin> joins = findAll(enforced, OpenSearchJoin.class);
            findAll(top.worker().getFragment(), org.opensearch.analytics.planner.rel.OpenSearchSort.class).isEmpty()
    }
            rexBuilder.makeInputRef(intType, 0),
        Function<IndexMetadata, FieldStorageResolver> fieldStorageFactory = FieldStorageResolver::new;
        assertEquals("two joins distributed below the window gather", 2, joins.size());
    /**
    }
        int abCols = ab.getRowType().getFieldCount();
        return state;
    }
            rexBuilder.makeInputRef(intType, 0),
        // worker (its producer) + a leaf scan.
        RelNode agg = LogicalAggregate.create(ab, List.of(), ImmutableBitSet.of(0), null, List.of(countCall));
        );
     * sf=10 q3 BLOCKER regression: a filtered scan feeding a join must stay a SHARD producer, not become a
            (int) finalAgg.getAggCallList().get(0).getArgList().get(0)
        RexNode abCond = rexBuilder.makeCall(
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);
        assertTrue(
        // a coordinator-reduce stage.
     * over a join, which the pass gathers to COORDINATOR+SINGLETON (a ReduceStageExecution at DAG time). A
        Stage root = structure.dag().rootStage();
        RelNode aScan = stubScan(mockTable("a_idx", "status", "size"));
        // And the DAG still promotes two join worker tiers (the un-wireable agg-shuffle bug would have left
     * producer stage must be cut as a {@link StageExecutionType#SHARD_FRAGMENT} with a
        int aCols = aScan.getRowType().getFieldCount();
    }
        for (int i = 0; i < abCols; i++) {
        RelNode cbo = runPlanner(logical, context);
     *  "RexInputRef[N] has no matching FieldStorageInfo entry" at fragment conversion. */
            (levelIndex, partitionCount) -> nodeIds(partitionCount)
            rexBuilder.makeInputRef(intType, 0),
    public void testEnforcementPass_smallJoinBelowFloorStaysCoordCentric() {
        RelNode cbo = runPlanner(logical, context);
        );
 *   <li>{@link GeneralShuffleDAGRewriter#rewriteStructure} promotes each join level into its own worker
     *  must NOT be blocked by it. */
                cScan = scan;
        assertEquals(
                    && level.rightProducer().getExecutionType() != StageExecutionType.COORDINATOR_REDUCE
    private RelNode makeAggregateGroupedOnNonJoinKey(PlannerContext context) {
            rexBuilder.makeInputRef(intType, aCols)
        RexNode abCond = rexBuilder.makeCall(
     * join's output already satisfies the top join's hash requirement (shared key), the pass inserts a
        );
        );
        assertEquals("bushy (A⋈B)⋈(C⋈D) → three binary worker tiers", 3, levels.size());
            SqlStdOperatorTable.EQUALS,
                "a broadcast build whose fragment scans a shard table must be a SHARD_FRAGMENT, not a "
            "FINAL re-merges SUM via SUM",
        assertTrue("PARTIAL keeps the empty group set", partial.getGroupSet().isEmpty());
            -1,
import org.opensearch.analytics.planner.dag.GeneralShuffleDAGRewriter;
            assertEquals(
        QueryDAG dag = DAGBuilder.build(enforced, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
            }
            rexBuilder.makeInputRef(intType, 1),
        RexNode cond = rexBuilder.makeCall(
            enforced,
        RelNode bScan = stubScan(mockTable("b_idx", "status", "size"));
 *
            SqlStdOperatorTable.EQUALS,
            SqlStdOperatorTable.EQUALS,
     * entry" crash): every {@link org.opensearch.analytics.planner.rel.OpenSearchRelNode} in the enforced
        }
import org.opensearch.analytics.planner.dag.QueryDAG;
        return LogicalAggregate.create(join, List.of(), ImmutableBitSet.of(0), null, List.of(distinctMultiArg));
import org.apache.calcite.rel.logical.LogicalAggregate;
    /** Builds {@code Aggregate(COLLECT(col1) by col0)} over a 3-way join — COLLECT is STATE_EXPANDING, so
 * Locks in the general hash-shuffle plan shape for multi-way INNER equi-joins (e.g.
     */
        java.util.Set<Integer> topProducers = java.util.Set.of(top.leftProducer().getStageId(), top.rightProducer().getStageId());
        Map<String, Long> rowCounts = Map.of("small_idx", SMALL, "large_idx", LARGE);
    private PlannerContext buildMppContext(Map<String, Integer> shardCounts, Map<String, Long> rowCounts, long maxBroadcastBytes) {
     * DAG-cut regression for NESTED BROADCAST: a broadcast whose BUILD side is itself a broadcast probe.
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
        RelNode r = stubScan(mockTable("a_idx", "status", "size"));
            RexWindowBounds.UNBOUNDED_PRECEDING,
        RexNode topCond = rexBuilder.makeCall(
            SqlStdOperatorTable.EQUALS,
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
    /**
        }
    /** {@code SUM(size) by status} over the 3-way join — SUM is its own reducer (PARTIAL=FINAL=SUM). */
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        List<org.opensearch.analytics.planner.rel.OpenSearchAggregate> aggs = findAll(
            rexBuilder.makeInputRef(intType, 0),
        RelNode aScan = stubScan(mockTable("a_idx", "status", "size"));
                j -> unwrap(j.getInput(0)) instanceof OpenSearchShuffleExchange
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
    /** Builds Join(Join(a,b) on a.0=b.0, c) on (join.0 = c.0), all INNER equi. */
            top.worker().getFragment(),
        RelNode enforced = DistributionEnforcementPass.enforce(
     * no operator references so they never reach the hash-shuffle wire. For
    }
     */
        RelNode cScan = stubScan(mockTable("c_idx", "status", "size"));
        assertNotNull("a decomposable agg over a distributed join must split (FINAL present)", finalAgg);
        );
    }
        assertEquals("both join levels are distributed (outer join co-partitions too)", 2, shuffleJoins);
     *  it is NOT left-deep. All joins share key col0 (status). */
        ).stream().findFirst().orElseThrow(() -> new AssertionError("no filter in enforced plan"));
     * Codex BLOCKER 2 regression: a decomposable aggregate grouped on a NON-join-key column over a
        RelNode ab = LogicalJoin.create(aScan, bScan, List.of(), abCond, Set.of(), JoinRelType.INNER);
            .filter(j -> !findAll(j, org.opensearch.analytics.planner.rel.OpenSearchAggregate.class).isEmpty())
                && !RelNodeUtils.findNodes(f, OpenSearchTableScan.class).isEmpty();
     * Codex round-3 BLOCKER (a SELF-JOIN must produce TWO distinct producer stages, not one shared id that
        return org.apache.calcite.rel.logical.LogicalSort.create(agg, collation, null, null);
     *  COUNT(DISTINCT) is NOT a valid example — it's rewritten to the decomposable APPROX_COUNT_DISTINCT.) */
    public void testEnforcementPass_broadcastWinnerIsPreserved() {
    private RelNode makeAggregateOverCrossThenEquiJoin(PlannerContext context) {
            assertTrue(
import org.apache.calcite.rel.type.RelDataType;
            /* argList */ List.of(1, 2),
        int l0 = levels.get(0).worker().getStageId();
    public void testEnforcementPass_aggSubToggleOffKeepsAggCoordCentricButJoinsDistribute() {
import java.util.function.ToLongFunction;
        }
        RelNode bScan = stubScan(mockTable("b_idx", "status", "size"));
     */
        int aggCols = agg.getRowType().getFieldCount();
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
     * not by child-stage count: the {@code BROADCAST_BUILD} grandchild is a side-input, not a streamed
        List<ShuffleEnrichment.WorkerLevel> levels = structure.buildLevels();
            .filter(a -> a.getMode() == mode)
            "top join's right input must NOT be shuffled either (join stays coord-centric when a producer can't ship)",
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
            org.opensearch.analytics.planner.rel.AggregateMode.FINAL
    }
        );
import org.opensearch.analytics.planner.dag.Stage;
        assertEquals(
     *  TPC-H q3 shape). The agg runs on the coordinator after the worker join, so cascade detection
    private RelNode makeThreeWayJoin(PlannerContext context) {
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
        assertEquals(
        RelNode aScan = stubScan(mockTable("a_idx", "status", "size"));
        GeneralShuffleDAGRewriter.Structure structure = enforceAndPromote(makeAggregateOverThreeWayJoin(context), context);
        // on it). This is the transparent op that must ride on the bottom worker.
        RelNode enforced = DistributionEnforcementPass.enforce(
            ImmutableList.of(),
            CLUSTER_DATA_NODES,
        );
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
                    .putList("index.composite.secondary_data_formats", "lucene")
            "top join's left input (the gathered aggregate sub-stage) must NOT be shuffled",
        return out;
     * input is an {@link OpenSearchExchangeReducer} (gathered), not a partitioned join.
            dataNodes.put("node-" + i, mock(DiscoveryNode.class));
            List.of(),
            cbo,
        RelNode midProject = org.apache.calcite.rel.logical.LogicalProject.create(
    /** {@code stats sum(size)} (empty group) over the 3-way join — the q2/q11 scalar-subquery shape. SUM
            .count();
            "SUM",
            org.opensearch.analytics.planner.rel.AggregateMode.FINAL,
        }
            deepest.leftProducer().getExecutionType()
    }
            true
        int abCols = ab.getRowType().getFieldCount();
    /**
        assertEquals(
            cbo,
            enforced,
        assertTrue(
        QueryDAG dag = DAGBuilder.build(enforced, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
            rexBuilder.makeInputRef(intType, abCols)
                StageExecutionType.WORKER_FRAGMENT,
     * Per-strategy sub-toggle ({@code analytics.mpp.shuffle.aggregate.enabled=false}): the SAME
        if (maxBroadcastBytes >= 0) {
        );
            );
            false,
        assertEquals("joins still distribute when only the agg sub-toggle is off", 2, binaryTierJoins);
        Settings.Builder settingsBuilder = Settings.builder().put("analytics.mpp.enabled", true);
    }
            cbo,
        for (int i = 0; i < CLUSTER_DATA_NODES; i++) {
        // through condition=[true]) — a silently-wrong plan that drops b's rows. With the correct allMatch
     * (above the rebuilt FINAL), NOT ride on the worker per-partition (sorting per partition then merging is
            .filter(
            dag,
    /**
        boolean hasDummyRewrite = projects.stream()
        assertFalse("the agg-over-3-way-join must still distribute (shuffles present)", shuffles.isEmpty());
        // The window-bearing project must sit over a gather, not a partitioned join.
        // Storage-completeness invariant for the empty-group FINAL (possibly wrapped in a cast Project).
        RelNode join = LogicalJoin.create(crossAb, cScan, List.of(), abcCond, Set.of(), JoinRelType.INNER);
            /* minRows */ 1L,
            RelNodeUtils.findNodes(nestedBuild.getFragment(), OpenSearchTableScan.class).isEmpty()
        public int defaultShuffleParallelism(ClusterState state) {
        assertNotNull("SUM by g over a distributed join must split", partial);
            org.opensearch.analytics.planner.rel.OpenSearchAggregate.class
        boolean rightBroadcast = unwrap(join.getInput(1)) instanceof OpenSearchBroadcastExchange;
            typeFactory.createSqlType(SqlTypeName.BIGINT),
import org.opensearch.analytics.planner.rel.OpenSearchBroadcastScan;
        );
        assertTrue(
     * Codex re-review BLOCKER regression: a NON-decomposable SINGLE aggregate ({@code COUNT(DISTINCT col1)})
            out.add((T) node);
     * surface. So the pass must split: PARTIAL on the worker (per-partition), FINAL on the coordinator. Ported
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);
import org.opensearch.cluster.node.DiscoveryNode;
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
        // agg-over-3-way-join qualifies. Validates the trimmer wiring + index remapping (a join above a
            unwrap(windowProject.getInput(0)) instanceof OpenSearchExchangeReducer
                    + dag,
     * {@code DistributedAggOverJoinTests#testDistributedAggOverJoin_sumPreservedThroughSplit}.
            /* minRows */ 1L,
    /**
        assertFalse(
    /** Two-way INNER equi-join on col0 over two scans (mirrors JoinStrategyCBOSelectionTests.makeJoin). */
    public void testEnforcementPass_mixedKeyCascadeReshufflesAtKeyChange() {
        // gathers and runs coord-centric. Identify it as the join that contains the OpenSearchAggregate.
 * SPDX-License-Identifier: Apache-2.0
        long shuffleJoins = joins.stream()
            (org.apache.calcite.sql.SqlAggFunction) SqlStdOperatorTable.COUNT,
/**
        RelNode ab = LogicalJoin.create(aScan, bScan, List.of(), abCond, Set.of(), JoinRelType.INNER);
     * the aggregate sub-toggle OFF. The pass must NOT split the aggregate (no PARTIAL/FINAL) — it stays a
        RelNode cbo = runPlanner(makeThreeWayJoin(context), context);
            .orElseThrow();
        RelNode agg = makeSumByGroupOverThreeWayJoin(context);
        );
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);
     * counts with no FINAL merge → silently wrong). The pass must GATHER the join output and run the SINGLE
            "cnt"
     * broadcast exchange is present AND at least one shuffle is present (the mixed shape).
                StageExecutionType.SHARD_FRAGMENT,
        // fix it was the only stage that came back COORDINATOR_REDUCE.
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);
        List<OpenSearchJoin> joins = findAll(enforced, OpenSearchJoin.class);
        RexNode cond = rexBuilder.makeCall(
     * left shuffle sits the bottom join (itself over two scan shuffles). Eliminating the same-key inter-tier
    /** First {@link org.opensearch.analytics.planner.rel.OpenSearchAggregate} of the given mode in
    }
    /**
        ShuffleEnrichment.WorkerLevel deepest = levels.get(0);
        for (OpenSearchJoin join : joins) {
            SqlStdOperatorTable.GREATER_THAN,
            /* minRows */ 1L,
        RelNode cScan = stubScan(mockTable("c_idx", "status", "size"));
     * broadcast-probe join as the build of an outer join. The bug is in the DAG cutter, not the planner, so
        // shuffle ships [status, size, status0, size0] (width 4). With trimming, the dead `size`
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
     * transport is safe for {@code a ⋈ a on k}: DAGBuilder cuts each shuffle input into its OWN stage (one
            SqlStdOperatorTable.SUM,
            SqlStdOperatorTable.COUNT,
                "each join level must sit over two shuffle inputs (binary tier)",
        assertEquals(
    private RelNode makeSortedSumByGroupOverThreeWayJoin(PlannerContext context) {
    public void testColumnPruneNarrowsShuffleInputs() {
     * top join. {@link GeneralShuffleDAGRewriter} promotes that stage to a worker IN PLACE — so the PARTIAL
import org.apache.calcite.rex.RexWindowBounds;
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);
        // The top join (keyed on col1) must have BOTH inputs shuffled — its left input is a re-shuffle of
     * agg-over-3-way shape as {@link #testEnforcementPass_aggOverThreeWayJoinSplitsAndCascades}, but with
            context.getCapabilityRegistry(),
import org.apache.calcite.util.ImmutableBitSet;
        );
            "PARTIAL rides directly on the join worker — NO group-key ShuffleExchange between PARTIAL and join",
        Map<String, Integer> shardCounts = Map.of("a_idx", 3);
            false,
    @SuppressWarnings("unchecked")
    /**
     *     that wants the SHUFFLE filtered-scan-producer path uses this so the broadcast-preserve branch
            cbo,
    }
        org.opensearch.analytics.planner.rel.OpenSearchFilter filter = findAll(
        AggregateCall countCall = AggregateCall.create(
            collect(unwrap(input), type, out);
        // And the filter is under a ShuffleExchange (the join shuffles it from the shards).
        Stage newRoot = structure.dag().rootStage();
        );
        org.opensearch.analytics.planner.rel.OpenSearchAggregate partial = aggs.stream()
    public void testGeneralShuffle_aggGroupedOnNonJoinKey_noReshuffle() {
    /**
        int aCols = aScan.getRowType().getFieldCount();
        );
        );
        return GeneralShuffleDAGRewriter.rewriteStructure(
            workerAggs.get(0).getMode()
            midProjects.add(rexBuilder.makeInputRef(ab, i));
            ab.getRowType().getFieldNames()
                "shuffle input must not carry the unreferenced 'size' column after trimming (got " + fields + ")",
        AggregateCall countCall = AggregateCall.create(
     * aggregate rides on the top worker (runs per-partition), and the FINAL stays on the coordinator. Asserts
            rexBuilder.makeInputRef(intType, aCols)
     * enrichLevels would enrich as both left and right → only one sink → hang). Verifies the binary shuffle
            false,
            /* filterArg */ -1,
            "filtered-scan join input must stay shard-local: Filter directly over the scan (no gather ER between)",
     */
            cbo,
            cbo,
            rexBuilder.makeInputRef(intType, l.getRowType().getFieldCount())
        // GRAFT: broadcast the broadcast-probe join as the BUILD of an outer join over c_idx.
        RelNode cd = LogicalJoin.create(cScan, dScan, List.of(), cdCond, Set.of(), JoinRelType.INNER);
        RelNode aScan = stubScan(mockTable("a_idx", "status", "size"));
            "cnt"
    /**
        return LogicalJoin.create(ab, cScan, List.of(), abcCond, Set.of(), JoinRelType.INNER);
    private <T> void collect(RelNode node, Class<T> type, List<T> out) {
        // EQUI-JOIN((a⨯b), c) on col0 == c.col0.
            enforced,
            rexBuilder.makeInputRef(intType, 0),
        RelNode cbo = runPlanner(logical, context);
        List<OpenSearchJoin> joins = findAll(enforced, OpenSearchJoin.class);
            unwrap(topJoin.getInput(0)) instanceof OpenSearchShuffleExchange
     * {@code stats sum(x)} with NO {@code by}). The aggregate OUTPUT is one row, but the JOIN OUTPUT feeding
     * {@link #testColumnPruneNarrowsShuffleInputs} is the positive control (all-equi → trims).
     * single SINGLE aggregate on the coordinator over a gather — while the JOIN cascade below is unaffected
    }
            "self-join's two shuffle producers MUST be distinct stages (else one sink serves both sides → hang)",
        assertNotNull("a decomposable agg over a distributed join must split (PARTIAL present)", partial);
        RelNode bScan = stubScan(mockTable("b_idx", "status", "size"));
            SqlStdOperatorTable.COUNT,
    private RelNode makeTwoWayJoin(PlannerContext context, String leftIdx, String rightIdx) {
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
        );
        org.apache.calcite.rel.RelCollation collation = org.apache.calcite.rel.RelCollations.of(
            "general pass must preserve the CBO broadcast exchange (1):\n" + org.apache.calcite.plan.RelOptUtil.toString(enforced),
        );
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
            assertEquals(
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
        ShuffleEnrichment.WorkerLevel top = levels.get(levels.size() - 1);
                fields.stream().anyMatch(f -> f.startsWith("status"))
     * <p>The nested shape is constructed directly rather than planned: this planner's CBO does not choose
        RelNode enforced = DistributionEnforcementPass.enforce(
            when(metadata.index(indexName)).thenReturn(indexMetadata);
            org.opensearch.analytics.planner.rel.OpenSearchAggregate.class
            assertTrue(
     *  a real equi-join in one tree (the Codex Q4 shape). */
     * {@link Stage} then classifies it {@code COORDINATOR_REDUCE} while its instruction list still carries a
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
    private RelNode makeDistinctCountOverThreeWayJoin(PlannerContext context) {
        List<OpenSearchJoin> joins = findAll(enforced, OpenSearchJoin.class);
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        List<ShuffleEnrichment.WorkerLevel> levels = structure.buildLevels();
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            RexWindowBounds.UNBOUNDED_FOLLOWING,
        long binaryTierJoins = joins.stream()
     */
        );
        }
            groupCount,
        // COUNT is a mock-backend-supported function (unlike COLLECT/LISTAGG), so the planner admits it.
    }
     */
        RelNode filtered = org.apache.calcite.rel.logical.LogicalFilter.create(aScan, filterCond);
        );
            String indexName = entry.getKey();
        int l1 = levels.get(1).worker().getStageId();
        GeneralShuffleDAGRewriter.Structure structure = enforceAndPromote(makeThreeWayJoin(context), context);
    public void testGeneralShuffle_intermediateProjectRidesOnWorker() {
        );
        int abCols = ab.getRowType().getFieldCount();
                    && unwrap(join.getInput(1)) instanceof OpenSearchShuffleExchange
    /**
            typeFactory.createSqlType(SqlTypeName.BIGINT),
                    + "not a COORDINATOR_REDUCE:\n"
        assertNotNull("SUM by g over a distributed join must split", finalAgg);
            List.of(1),
    private <T> List<T> findAll(RelNode root, Class<T> type) {
     * is {@code Join(BroadcastScan(build), shardScan)} — a broadcast nested under a shuffle tier — the
     * shard scan, and {@code ShardScanInstructionHandler} fails casting the {@code ExchangeSinkContext} it is
        }
        assertEquals(
     * {@code Shuffle(Filter(scan))} with NO ExchangeReducer between the filter and the scan. The bug: the
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
import org.opensearch.cluster.metadata.MappingMetadata;
            "a plan containing a CROSS JOIN must NOT be column-trimmed — found a DUMMY-literal Project, "
            "precondition: a broadcast nested under a shuffle producer must exist in the enforced DAG\n" + dag,
     * would be a non-join shuffle edge GeneralShuffleDAGRewriter can't wire → hang) — instead the PARTIAL
        RelNode cbo = runPlanner(makeSumByGroupOverThreeWayJoin(context), context);
 * </ol>
        when(state.metadata()).thenReturn(metadata);
        List<org.opensearch.analytics.planner.rel.OpenSearchAggregate> workerAggs = findAll(
        assertTrue("exactly one join input is a broadcast exchange (the build side)", leftBroadcast ^ rightBroadcast);
        assertEquals("both join levels are binary tiers below the gather", 2, binaryTiers);
            "FINAL arg rebased to the partial-state column (groupCount + 0), not the original input ordinal",
     */
        assertEquals("one PARTIAL aggregate", 1, partials);
    }
            int storage = osRel.getOutputFieldStorage().size();
     */
        for (Map.Entry<String, Integer> entry : shardCounts.entrySet()) {
            /* minRows */ 1L,
            RelNode f = s.getFragment();
        org.opensearch.analytics.planner.rel.OpenSearchAggregate partial = aggOfMode(
        long finals = aggs.stream().filter(a -> a.getMode() == org.opensearch.analytics.planner.rel.AggregateMode.FINAL).count();
import org.apache.calcite.rel.core.AggregateCall;
        List<org.opensearch.analytics.planner.rel.OpenSearchAggregate> workerAggs = findAll(
            "non-decomposable agg must GATHER its distributed-join input (ER), NOT ride per-partition on the worker",
        GeneralShuffleDAGRewriter.Structure structure = enforceAndPromote(makeBushyFourWayJoin(context), context);
     * SUM is its own reducer: PARTIAL and FINAL are both SUM, but FINAL's arg must still be rebased to the
                level.worker().getExecutionType()
        );
    /** Enforce + cut + fork/select + promote, returning the GeneralShuffleDAGRewriter structure. Mirrors the
     */
            .filter(a -> a.getMode() == org.opensearch.analytics.planner.rel.AggregateMode.PARTIAL)
    }
                StageExecutionType.SHARD_FRAGMENT,
        );
        // shouldSkipPartialFinalSplit returns true (aggCall.isDistinct()) → non-decomposable → must gather.
            context.getDistributionTraitDef(),
     * rides on the top-join worker partitioned by the JOIN key (Variant A: a decomposable PARTIAL is
    /**
            MappingMetadata mappingMetadata = mock(MappingMetadata.class);
        RelNode underTopLeftShuffle = unwrap(((OpenSearchShuffleExchange) unwrap(top.getInput(0))).getInput());
import static org.mockito.Mockito.mock;
     * (transparent, shard-local child) must RIDE on the shards — so the join's shuffle wraps
        for (Stage producer : broadcastProducers) {
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);
        // The OUTER build is the nested one: it scans a shard table AND has its own build child. Before the
            assertEquals(
            "precondition: the nested build's fragment must scan a shard table:\n" + dag,
        for (OpenSearchTableScan scan : findAll(enforced3, OpenSearchTableScan.class)) {
        );
            rootAggs.get(0).getMode()
     * coord-centric choice for small joins. Guards against the pass force-distributing every join.
     *     value suppresses the broadcast alternative (build can't fit the cap) so CBO must shuffle; a test
            -1,
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
        PlanAlternativeSelector.selectAll(dag, context.getCapabilityRegistry(), false);
        );
        assertFalse(
            rexBuilder.makeInputRef(intType, aCols)
            .findFirst()
        int aCols = aScan.getRowType().getFieldCount();
        List<OpenSearchJoin> joins = findAll(enforced, OpenSearchJoin.class);
            (levelIndex, partitionCount) -> nodeIds(partitionCount)
        RelNode logical = LogicalJoin.create(filtered, bScan, List.of(), joinCond, Set.of(), JoinRelType.INNER);
        );
        assertEquals("top worker fragment carries exactly the PARTIAL aggregate", 1, workerAggs.size());
     */
 * The OpenSearch Contributors require contributions made to
        );
        for (Stage child : stage.getChildStages()) {
            SqlStdOperatorTable.EQUALS,
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3);
        org.opensearch.analytics.planner.rel.AggregateMode mode
        RelNode ab = LogicalJoin.create(aScan, bScan, List.of(), abCond, Set.of(), JoinRelType.INNER);
    }
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
     * differs from the join partitioning (col0). The pass must NOT insert a group-key re-shuffle (that
            rexBuilder.makeInputRef(intType, cCols)
        int groupCount = finalAgg.getGroupSet().cardinality();
        AggregateCall sumCall = AggregateCall.create(
        );
     */
    private RelNode makeMixedKeyThreeWayJoin(PlannerContext context) {
        for (org.opensearch.analytics.planner.rel.OpenSearchRelNode osRel : findAll(
     * {@code status0}). Guards the trimmer wiring + index remapping (a join above a narrowed shuffle
            true,
        );
        RelNode cbo = runPlanner(makeAggregateOverCrossThenEquiJoin(context), context);
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
     * nested broadcast (it emits at most one broadcast per plan), so the shape is grafted by broadcasting a
        RelNode join = makeThreeWayJoin(context);
     * place (each {@code SHUFFLE_WORKER} + {@code WORKER_FRAGMENT}). The deepest worker consumes two leaf
        List<String> ids = new java.util.ArrayList<>(partitionCount);
    }
            .count();
    private RelNode makeThreeWayJoinWithMidProject(PlannerContext context) {
     * shuffle for genuinely co-partitioned tiers is a future N-ary-transport optimization.
    private RelNode makeWindowOverThreeWayJoin(PlannerContext context) {
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        assertEquals("intermediate Project must not insert a gather tier → still two worker tiers", 2, levels.size());
        RelNode l = stubScan(mockTable("a_idx", "status", "size"));
        );
        QueryDAG dag = DAGBuilder.build(outerJoin, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
            org.opensearch.analytics.planner.rel.AggregateMode.FINAL
            org.opensearch.analytics.planner.rel.AggregateMode.PARTIAL
     * on its missing input. Asserts TWO worker tiers (not a gather between them) and the intermediate Project
        );
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
        return org.opensearch.analytics.planner.RelNodeUtils.unwrapHep(node);
            workerAggs.get(0).getMode()
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
        // its two keys. Assert NO shuffle carries an unreferenced `size`/`size0` column.
    /**
        List<org.opensearch.analytics.planner.rel.OpenSearchAggregate> aggs = findAll(
            findAll(cbo, OpenSearchBroadcastExchange.class).isEmpty()
import org.opensearch.analytics.planner.dag.StageExecutionType;
                cols,
            root,
        boolean hasLeftJoin = joins.stream().anyMatch(j -> j.getJoinType() == JoinRelType.LEFT);
            false,
    }
        );
        RelNode ab = LogicalJoin.create(aScan, bScan, List.of(), abCond, Set.of(), JoinRelType.INNER);
import org.opensearch.analytics.planner.dag.WorkerTargetResolver;
                producer.getExecutionType()
            partial
        assertEquals("sub-toggle off: NO PARTIAL aggregate (no split)", 0, partials);
     * buildEnforcer, which trusted the join's stale CBO coordSingleton trait and skipped the ER, leaving the
            org.opensearch.analytics.planner.rel.AggregateMode.FINAL
        assertEquals("sub-toggle off: NO FINAL aggregate (no split)", 0, finals);
    /** Builds {@code Project(status, COUNT() OVER ())} over a 3-way INNER join — a global-window-frame
        RelNode cbo = runPlanner(makeAggregateOverThreeWayJoin(context), context);
        );
            assertEquals(
            join,
            top.worker().getFragment(),
        assertFalse(
     * The top join thus sits over TWO shuffles (re-shuffled bottom-join output + shuffled c), and under its
     * {@code COORDINATOR_REDUCE}. {@code DAGBuilder.cutShuffle} decides this by {@code fragmentHasShardScan},
     * Option B (general enforcement pass): a 3-way shared-key join scheduled by the general
        OpenSearchJoin join = findAll(enforced, OpenSearchJoin.class).get(0);
     * leaf returning {@code List.of()} that truncated the storage union, throwing at fragment conversion.
        assertTrue(
        long partials = aggs.stream().filter(a -> a.getMode() == org.opensearch.analytics.planner.rel.AggregateMode.PARTIAL).count();
        assertTrue("the bottom join sits under the top join's left inter-tier shuffle", underTopLeftShuffle instanceof OpenSearchJoin);
    public void testGeneralShuffle_aggOverJoinKeepsPartialOnWorker() {
        );
            context.getDistributionTraitDef(),
        assertTrue(
        return LogicalAggregate.create(join, List.of(), ImmutableBitSet.of(0), null, List.of(sumCall));
        // preserved a broadcast under a shuffle; if CBO declined broadcast this test is vacuous, guarded
     * Option B coverage the rewriters struggle with (2): a MIXED-KEY 3-way join — a⋈b on col0, then ⋈c
        Map<String, DiscoveryNode> dataNodes = new HashMap<>();
        RexNode abcCond = rexBuilder.makeCall(
        );
            SqlStdOperatorTable.EQUALS,
        assertNotNull("need a c_idx scan for the outer probe", cScan);
        assertTrue(
        return LogicalJoin.create(agg, cScan, List.of(), aggcCond, Set.of(), JoinRelType.INNER);
            dag,
            aggOfMode(root.getFragment(), org.opensearch.analytics.planner.rel.AggregateMode.FINAL).getMode()
 * this file be licensed under the Apache-2.0 license or a
            .count();
        org.opensearch.analytics.planner.rel.OpenSearchAggregate finalAgg = aggOfMode(
            CLUSTER_DATA_NODES,
            assertTrue(
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);
     * re-merges via SUM over the partial-count state column. COUNT is NOT its own reducer — running COUNT on
        );
        RelNode bScan = stubScan(mockTable("b_idx", "status", "size"));
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
        return LogicalJoin.create(midProject, cScan, List.of(), abcCond, Set.of(), JoinRelType.INNER);
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
     */
        if (pred.test(stage)) {
        );
        // (anyMatch) gate firing is RelFieldTrimmer rewriting the cross-join's unreferenced input into a
        RexNode abCond = rexBuilder.makeCall(
            rexBuilder.makeInputRef(intType, abCols)
            1L,
            );
            rexBuilder.makeInputRef(intType, 0),
import org.apache.calcite.rel.logical.LogicalProject;
        // Binary-tier lowering: BOTH joins sit over two ShuffleExchange inputs (no N-ary collapse).
            rexBuilder.makeInputRef(intType, aCols)
     * Shape assertions miss this — only a per-node {@code getOutputFieldStorage().size() == fieldCount} check
            "cnt"
     */
            deepest.leftProducer().getExecutionType()
     * must still resolve its keys).
        int abCols = crossAb.getRowType().getFieldCount();
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
            org.opensearch.analytics.planner.rel.OpenSearchAggregate.class
        // The cascade still forms below the PARTIAL: 2 joins, each a binary tier (over two shuffles).
        // The root stays a coordinator reduce gathering the top worker's SINGLETON output.
        // GROUP BY col1 (size) — a DIFFERENT column than the join key col0.
        }
    public void testEnforcementPass_aggOverThreeWayJoinSplitsAndCascades() {
     * handed to a {@code ShardScanExecutionContext}.
        assertStorageComplete("enforced agg-over-join plan", enforced);
     * worker (propagate its HASH partitioning), NOT gather it to the coordinator — gathering would cut the
     *  RexOver above the join, which requires fully-gathered (SINGLETON) input. */
        // Column-prune (PlannerImpl.trimUnusedFields) is ON by default and scoped to join plans — this
            dag,
     */
     * filter was gathered (step 3b), producing {@code Shuffle(Filter(ER(scan)))} → DAGBuilder cut a
        RelNode cbo = runPlanner(makeMixedKeyThreeWayJoin(context), context);
            CLUSTER_DATA_NODES,
     * cross-join branch. Here: an aggregate (drops {@code size}) over an equi-join whose left input is a
        if (type.isInstance(node)) {
            List.of(),
        assertStorageComplete("empty-group enforced plan", enforced);
    }
import org.opensearch.analytics.planner.rel.OpenSearchShuffleExchange;
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
            SqlStdOperatorTable.EQUALS,
        );
        private final int parallelism;
        List<OpenSearchJoin> joins = findAll(enforced, OpenSearchJoin.class);
     */
            when(indexMetadata.getNumberOfShards()).thenReturn(shardCount);
            enforced,
            "empty-group SUM over a large join must distribute (the join-output gather is what OOMs, not the "
        // The top worker fragment carries the PARTIAL aggregate above its join.
     * and two worker tiers still promote.
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
        // Row-wise identity Project over the bottom join (preserves col0 at position 0 so the top join keys
     * on col1. The bottom join's output is HASH(col0); the top join needs HASH(col1) → the pass inserts a
            ab,
            if (scan.getTable().getQualifiedName().toString().contains("c_idx")) {
    private static void collectStages(Stage stage, java.util.function.Predicate<Stage> pred, List<Stage> out) {
    /** {@code COUNT() GROUP BY col0} over {@code equiJoin( crossJoin(a,b), c )} — mixes a cross-join with
        return buildMppContext(shardCounts, rowCounts, -1L);
        RexNode abcCond = rexBuilder.makeCall(
    }
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
            List.of(),
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
        return LogicalAggregate.create(join, List.of(), ImmutableBitSet.of(0), null, List.of(countCall));
import org.opensearch.analytics.planner.dag.PlanForker;
    /**
    }
            context.getDistributionTraitDef(),
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
            "COUNT",
import org.opensearch.analytics.exec.join.DistributionEnforcementPass;
            org.opensearch.analytics.planner.rel.OpenSearchAggregate.class
    private static final long LARGE = 10_000_000L;
            );
        );
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
    private void assertStorageComplete(String where, RelNode root) {
            rexBuilder.makeInputRef(intType, 0),
        // The plan contains a CROSS JOIN, so the trim must be SKIPPED. The tell-tale of the buggy
        // Outer join: agg's group-key column (output index 0) = c.col0.
     * The enforced agg-over-3-way DAG. The pass pre-split the aggregate into
        Settings settings = settingsBuilder.build();
 */
import org.opensearch.analytics.planner.dag.PlanAlternativeSelector;
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
    private static ClusterState mockClusterStateWithDataNodes(Map<String, Integer> shardCounts) {
     *  cascade-probe pipeline (no convertAll — the mock backend has no fragment convertor). */
        );
     * would leave its worker awaiting a producer that never fires (`ShuffleScanHandler timed out`). The
            .orElse(null);
            rexBuilder.makeInputRef(intType, abCols)
            org.opensearch.analytics.planner.rel.AggregateMode.PARTIAL,
     * BOTH joins over two ShuffleExchange inputs.
        // the PARTIAL stage consuming an un-promoted shuffle).
    }
     * Option B size floor: a 3-way join whose scans are all BELOW the row floor must stay
        );
        RelNode logical = makeJoinOverAggregateOverJoin(context); // Join(Aggregate(Join(A,B)), C)
            org.opensearch.analytics.planner.rel.OpenSearchAggregate.class
    /**
        RexNode cdCond = rexBuilder.makeCall(
        ShuffleAwareDataFusionBackend(int parallelism) {
        );
        RexNode joinCond = rexBuilder.makeCall(
        RelNode cbo = runPlanner(makeThreeWayJoin(context), context);
        Stage newRoot = structure.dag().rootStage();
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
    // ── GeneralShuffleDAGRewriter: in-place worker promotion of the enforced DAG ──────────────
        return LogicalJoin.create(leftScan, rightScan, List.of(), condition, Set.of(), JoinRelType.INNER);
        assertEquals("exactly one PARTIAL aggregate (pushed below the gather)", 1, partials);
     * join with an explicit row-wise Project BETWEEN the two join levels — the real PPL plan shape, where
            rexBuilder.makeInputRef(intType, 0),
    }
        RelNode underLeftShuffle = unwrap(((OpenSearchShuffleExchange) unwrap(top.getInput(0))).getInput());
        );
            "the global Sort must stay on the coordinator (above FINAL)",
    private RelNode makeAggregateOverThreeWayJoin(PlannerContext context) {
        int aCols = aScan.getRowType().getFieldCount();
    public void testEnforcementPass_filteredScanJoinInputStaysShardProducer() {
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        // The bottom worker (level 0) must consume two leaf shard scans directly — proving the mid-Project
        assertTrue("the top join stays LEFT (distribution doesn't change join semantics)", hasLeftJoin);
            "dc"
        OpenSearchJoin top = joins.stream().filter(j -> findAll(j, OpenSearchJoin.class).size() == 2).findFirst().orElseThrow();
     * SAME-KEY inter-tier shuffle on the top join's left input — the bottom join becomes its own binary
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
            runPlanner(makeTwoWayJoin(context, "a_idx", "b_idx"), context),
        RelNode join = makeThreeWayJoin(context);
            CLUSTER_DATA_NODES,
    }
            rexBuilder.makeInputRef(intType, 0),
            false
        org.opensearch.analytics.planner.rel.OpenSearchAggregate partial = aggOfMode(
    private static final int CLUSTER_DATA_NODES = 3;
        );
        // GROUP BY col0, COUNT() — collapses A⋈B to one row per group key.
        QueryDAG dag = DAGBuilder.build(enforced, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
        );
        List<org.opensearch.analytics.planner.rel.OpenSearchAggregate> rootAggs = findAll(
            this.parallelism = parallelism;
     * {@link DistributionEnforcementPass}. The pass must produce a cascade of BINARY worker tiers —
            newRoot.getFragment(),
    /**
        }
            )
    /** Asserts every {@link org.opensearch.analytics.planner.rel.OpenSearchRelNode} in {@code root}'s tree
            true
        boolean leftBroadcast = unwrap(join.getInput(0)) instanceof OpenSearchBroadcastExchange;
    /**
    }
            rexBuilder.makeInputRef(intType, 0),
            true,
            org.opensearch.analytics.planner.rel.OpenSearchAggregate.class
            collectStages(child, pred, out);
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
            /* minRows */ 1_000_000L,
    private RelNode makeEmptyGroupSumOverThreeWayJoin(PlannerContext context) {
        for (RelNode input : node.getInputs()) {
        return findAll(root, org.opensearch.analytics.planner.rel.OpenSearchAggregate.class).stream()
    private static class ShuffleAwareDataFusionBackend extends MockDataFusionBackend {
        );
        }
        RexNode condition = rexBuilder.makeCall(
            cbo,
     * Coverage the legacy cascade CANNOT do: a BUSHY (non-left-deep) tree {@code (A⋈B) ⋈ (C⋈D)} on a
            .findFirst()
            when(mappingMetadata.sourceAsMap()).thenReturn(Map.of("properties", intFields()));
        );
            /* shuffleAggregateEnabled */ true
        assertEquals("top tier's two producers are the two sub-join workers", java.util.Set.of(l0, l1), topProducers);
        List<OpenSearchProject> projects = findAll(cbo, OpenSearchProject.class);
package org.opensearch.analytics.planner;
        assertEquals("PARTIAL SUM", "SUM", partial.getAggCallList().get(0).getAggregation().getName().toUpperCase(java.util.Locale.ROOT));
        RelNode rightScan = stubScan(mockTable(rightIdx, "status", "size"));
            .findFirst()
        CapabilityRegistry registry = new CapabilityRegistry(List.of(shuffleAware, LUCENE), fieldStorageFactory);
        RelNode cScan = stubScan(mockTable("c_idx", "status", "size"));
            typeFactory.createSqlType(SqlTypeName.BIGINT),
            .anyMatch(sh -> !findAll(sh, org.opensearch.analytics.planner.rel.OpenSearchFilter.class).isEmpty());
            false,
        RexNode abcCond = rexBuilder.makeCall(
            rexBuilder.makeInputRef(intType, 0),
        org.opensearch.analytics.planner.rel.OpenSearchAggregate finalAgg = aggOfMode(
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);
        }
        RelNode logical = makeDistinctCountOverThreeWayJoin(context);
        );
    /** Builds the BUSHY tree {@code (A⋈B on col0) ⋈ (C⋈D on col0) on col0} — both sides contain a join, so
            org.opensearch.analytics.planner.rel.OpenSearchAggregate.class
        for (OpenSearchShuffleExchange sx : shuffles) {
            unwrap(partial.getInput(0)) instanceof OpenSearchJoin
import org.opensearch.core.index.Index;
    }
            );
        collectStages(dag.rootStage(), s -> s.getRole() == Stage.StageRole.BROADCAST_BUILD, builds);
        assertFalse(
        assertFalse(
            rexBuilder.makeInputRef(intType, 0),
     * {@link ShardTargetResolver} (it scans a shard table and ships its hash partition), NOT a
import org.opensearch.cluster.metadata.Metadata;
    /**
        RelNode bScan = stubScan(mockTable("b_idx", "status", "size"));
        assertEquals("one FINAL aggregate", 1, finals);
            enforced,
            /* minRows */ 1L,
     *  partials additively), so the pass must gather, not split/ride-per-partition. (Single-arg
    /**
        assertEquals("two joins in the 3-way cascade", 2, joins.size());
        assertEquals("the aggregate is SINGLE (not split)", org.opensearch.analytics.planner.rel.AggregateMode.SINGLE, agg.getMode());
        RelNode cbo = runPlanner(makeEmptyGroupSumOverThreeWayJoin(context), context);
    /** Builds {@code Project(Join(Project(Join(a,b)), c))} — a 3-way join with an explicit row-wise Project
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
     * — the rule {@code cutReducer} and {@code cutShuffle} already use — NOT by {@code grandchildren.isEmpty()}.
            new org.apache.calcite.rel.RelFieldCollation(1, org.apache.calcite.rel.RelFieldCollation.Direction.DESCENDING)
 * Validates the structure (worker count, execution types, producer wiring, coordinator gather)
        assertEquals(
     */
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
            join,
            when(indexMetadata.getIndex()).thenReturn(new Index(indexName, indexName + "-uuid"));
            List.of(),
        // a_idx (small build) ⋈ b_idx (large) at the bottom → broadcast-eligible; ⋈ c_idx (large) on top → shuffle.
import org.opensearch.analytics.planner.rel.OpenSearchBroadcastExchange;
            "SUM",
            context.getDistributionTraitDef(),
        assertNotNull("empty-group SUM over a large join must produce a FINAL on the coordinator", finalAgg);
        // The coordinator root carries the FINAL aggregate (and gathers the top worker).
     *     the production default (64 MiB).
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);
        List<T> out = new java.util.ArrayList<>();
        RelNode cbo = runPlanner(makeThreeWayJoin(context), context);
        // cap, so CBO would otherwise pick BROADCAST (and the pass now legitimately preserves it). A tiny cap
                "shuffle input must still carry the join/group key 'status' (got " + fields + ")",
        // rewrite to decomposable APPROX_COUNT_DISTINCT does NOT apply to multi-arg), so
        AnalyticsSearchBackendPlugin shuffleAware = new ShuffleAwareDataFusionBackend(CLUSTER_DATA_NODES);
     *  {@code … | stats sum(...) by n_name | sort - revenue}. The Sort is a coordinator post-agg op. */
                    && unwrap(j.getInput(1)) instanceof OpenSearchShuffleExchange
        RelNode join = makeThreeWayJoin(context);
        assertEquals("two joins", 2, joins.size());
 * {@code Join(Join(A,B), C)}), scheduled by the general distributed scheduler:
        for (ShuffleEnrichment.WorkerLevel level : levels) {
        assertEquals(
        GeneralShuffleDAGRewriter.Structure structure = enforceAndPromote(makeThreeWayJoinWithMidProject(context), context);
                    + dag,
    }
        when(nodes.getDataNodes()).thenReturn(dataNodes);
    }
            );
/*
    /** a⋈b on col0, then (ab)⋈c on col1 — the cascade re-keys at the top level. */
        ShuffleEnrichment.WorkerLevel top = levels.get(1);
    private static List<String> nodeIds(int partitionCount) {
            /* shuffleAggregateEnabled */ true
        assertEquals("nested broadcast must cut TWO BROADCAST_BUILD stages (outer build + its own build):\n" + dag, 2, builds.size());
import org.opensearch.analytics.planner.rel.OpenSearchProject;
        RexNode abcCond = rexBuilder.makeCall(
        RelNode cbo = runPlanner(logical, context);
    }
     * shared key. The legacy {@code deepestInnerEquiJoin} walk assumes a left-deep chain (one bottom join,
     * coordinator reduce. CBO gathers the scan (ER) under the filter; the pass peels that ER, and the filter
        // Find the stage whose fragment contains an OpenSearchBroadcastScan AND a shard TableScan — the
            SqlStdOperatorTable.EQUALS,
        RelNode cScan = stubScan(mockTable("c_idx", "status", "size"));
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE);
    }
        Stage newRoot = structure.dag().rootStage();
            rexBuilder.makeInputRef(intType, 0),
            int cols = ((RelNode) osRel).getRowType().getFieldCount();
                    && unwrap(j.getInput(1)) instanceof OpenSearchShuffleExchange
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);
    private static RelNode unwrap(RelNode node) {
            SqlStdOperatorTable.SUM,
                + "(dropping b's rows). The gate must require ALL joins to be equi-joins.",
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        // the bottom join (which was keyed on col0), because HASH(col0) does NOT satisfy HASH(col1).
    }
        RelNode enforced = DistributionEnforcementPass.enforce(
     * hash-partitioned outer join). Asserts the cascade still forms over a LEFT top join.
     *  {@code shouldSkipPartialFinalSplit} is true (genuinely non-decomposable: it can't merge per-partition
                Settings.builder()
        RelNode aScan = stubScan(mockTable("a_idx", "status", "size"));
            );
     * aggregate into PARTIAL (over the distributed cascade) + FINAL (over a coordinator gather), and
        assertEquals("two joins in the 3-way cascade", 2, joins.size());
            typeFactory.createSqlType(SqlTypeName.BIGINT),
import org.apache.calcite.sql.type.SqlTypeName;
     * aggregate coordinator-centric. Asserts: exactly one SINGLE aggregate (no PARTIAL/FINAL split), and its
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
import org.opensearch.common.settings.Settings;
                + org.apache.calcite.plan.RelOptUtil.toString(enforced),
        RelNode cbo = runPlanner(logical, context);
     * RE-SHUFFLE exactly at the key change (the bottom join's output does NOT satisfy the top's
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
        assertTrue(
            settingsBuilder.put("analytics.mpp.broadcast.max_bytes", maxBroadcastBytes + "b");
     * {@code COUNT() GROUP BY col0} over a 3-way join of 2-col tables the aggregate needs only col0,
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
     * it is huge — gathering the whole join to the coordinator before the SINGLE aggregate runs is the OOM
        assertEquals("two binary join tiers → two worker tiers", 2, levels.size());
            rexBuilder.makeInputRef(intType, aCols)
     * scan shuffles; the top worker consumes the deepest worker (as a producer) + a leaf scan shuffle.
        RelNode aScan = stubScan(mockTable("a_idx", "status", "size"));
        return LogicalJoin.create(ab, cScan, List.of(), abcCond, Set.of(), topType);
            org.opensearch.analytics.planner.rel.AggregateMode.PARTIAL
            SqlStdOperatorTable.COUNT,
import org.opensearch.cluster.metadata.IndexMetadata;
        }
            when(indexMetadata.getSettings()).thenReturn(
        // A real CBO broadcast plan: Join(BroadcastExchange(a_small), b_large), SHARD-local.
            unwrap(innerJoin.getInput(0)) instanceof OpenSearchBroadcastExchange
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
     * grandchild count alone leaves it with no {@link ShardTargetResolver} and a sink provider instead:
            .count();
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
                    .build()
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
     * window running per-partition (silently wrong). Asserts the window Project's input is an
     * beside a real join) must DISABLE the trim, because the trimmer would silently mis-rewrite the
     * The window-bearing {@code OpenSearchProject} requires {@code COORDINATOR+SINGLETON} input (a global
            findAll(enforced, OpenSearchShuffleExchange.class).isEmpty()
            SqlStdOperatorTable.EQUALS,
        assertEquals("non-decomposable agg stays a single SINGLE aggregate (no PARTIAL/FINAL split)", 1, aggs.size());
        RelNode enforced2 = DistributionEnforcementPass.enforce(
     */
    }
        );
        }
    /**
     * requirement). Asserts: the top join's left input is a ShuffleExchange (re-shuffled), not the bare
     * over a distributed multi-way join. A non-decomposable aggregate is split-ineligible
        boolean topConsumesDeepest = top.leftProducer().getStageId() == deepest.worker().getStageId()
                where + ": " + ((RelNode) osRel).getRelTypeName() + " must report FieldStorageInfo for every output column",
        assertEquals("one worker tier for the self-join", 1, levels.size());
     * multi-way join ({@code A⋈B⋈C on col0 | stats count() by col1}). The aggregate's group key (col1)
                build.getExecutionType()
                break;
     * cutting a hand-built plan exercises it exactly.
     * BROADCAST under a shuffle cascade (E1): a 3-way where CBO broadcasts a small build at the BOTTOM join
        );
        Map<String, Long> rowCounts = Map.of("a_idx", SMALL, "b_idx", LARGE, "c_idx", LARGE);
     * each join's output is renamed by a Project. The intermediate Project must RIDE on the bottom join's
            "general pass must NOT introduce a shuffle for a broadcast-winner:\n" + org.apache.calcite.plan.RelOptUtil.toString(enforced),
        );
        assertEquals(
        List<Stage> broadcastProducers = new java.util.ArrayList<>();
            assertEquals("worker role SHUFFLE_WORKER", Stage.StageRole.SHUFFLE_WORKER, level.worker().getRole());
        assertTrue("self-join over two large scans distributes", GeneralShuffleDAGRewriter.hasDistributedJoin(dag));
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
     * Ported from {@code DistributedAggOverJoinTests#…sortAboveAggregateReplayedOnCoordinator}.
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
     * correct under any partitioning; the FINAL gathers + re-merges). Asserts: exactly one PARTIAL + one
     */
     * Aggregate-decomposition regression (ported from the deleted {@code DistributedAggOverJoinTests}): a
    }
            org.opensearch.analytics.planner.rel.AggregateMode.PARTIAL,
        // Force the SHUFFLE path: the `status > 5` filter shrinks the build side under the 64 MiB broadcast
            return f != null
        for (ShuffleEnrichment.WorkerLevel level : levels) {
            .anyMatch(p -> p.getRowType().getFieldNames().stream().anyMatch(f -> f.contains("DUMMY")));
            SqlStdOperatorTable.COUNT,
                storage
        collectStages(dag.rootStage(), s -> {
        for (int p = 0; p < partitionCount; p++) {
     * BROADCAST coverage (E1): when CBO picks BROADCAST for a small×large INNER equi-join, the merged
     * had zero children and threw "COORDINATOR_REDUCE stage N expected at least one child, got zero".
            false,
            rexBuilder.makeInputRef(intType, 0),
        @Override
        assertTrue(
        );
        // The cascade still distributes BELOW the gather (the join itself is two binary tiers).
            .findFirst()
            org.opensearch.analytics.planner.rel.OpenSearchRelNode.class
        RelNode aScan = stubScan(mockTable("a_idx", "status", "size"));
        assertTrue("top join left input re-shuffled at the key change", unwrap(top.getInput(0)) instanceof OpenSearchShuffleExchange);
            join,
        ShuffleEnrichment.WorkerLevel deepest = levels.get(0);
            1L,
            /* shuffleAggregateEnabled */ true
        collect(unwrap(root), type, out);
            "precondition: CBO must pick BROADCAST for small×large (else the probe is vacuous)",
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE, "d_idx", LARGE);
            assertEquals("each tier is a WORKER_FRAGMENT", StageExecutionType.WORKER_FRAGMENT, level.worker().getExecutionType());
     * window frame can't run per-partition). Over a distributed join the pass MUST insert a gather (ER)
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
import org.opensearch.cluster.node.DiscoveryNodes;
            enforced,
        // suppresses the broadcast alternative so CBO shuffles — the producer path this test guards.
 * compatible open source license.
    /**
import org.opensearch.analytics.exec.join.ShuffleEnrichment;
    public void testGeneralShuffle_selfJoinHasDistinctProducerStages() {
        // And under the left re-shuffle sits the bottom join (which itself shuffled its two scans).
     *  over an empty group infers NULLABLE (no rows → null), unlike the grouped case. */
        // broadcast-probe-that-is-also-a-shuffle-producer. There must be at least one (the enforced plan
    }
    /**
     * DAG-cut regression for broadcast-under-shuffle (the q3/q8/q9 fix): when a shuffle producer's fragment
        assertFalse(
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
        )) {
     * the coordinator over already-counted partial rows would count ROWS, not sum the partials, double/under-
    /**
        );
     * shippable-producer gate (step 3d) must keep the TOP join coord-centric: its inputs are NOT shuffled.
        Map<String, Long> rowCounts = Map.of("a_idx", SMALL, "b_idx", LARGE, "c_idx", LARGE);
    }
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
            StageExecutionType.SHARD_FRAGMENT,
     * Empty-group aggregate over a large join must STILL distribute (the TPC-H q2/q11 scalar-subquery shape:
            typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true),
            || top.rightProducer().getStageId() == deepest.worker().getStageId();
        Metadata metadata = mock(Metadata.class);
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
    }
        long binaryTiers = joins.stream()
        boolean filterUnderShuffle = findAll(enforced, OpenSearchShuffleExchange.class).stream()
    /**
     * Option B coverage the rewriters CANNOT do (1): a LEFT-outer 3-way join. The current cascade is
     * (The inner A⋈B join is shard-local on both sides, so it may still distribute — that's fine.)
        // narrowed shuffle must still resolve its keys).
        assertTrue("the filtered scan is shuffled (join hash-ships it from the shards)", filterUnderShuffle);
            join,
        int abCols = ab.getRowType().getFieldCount();
        );
            /* distinct */ true,
            );
        List<org.opensearch.analytics.planner.rel.OpenSearchAggregate> aggs = findAll(
        assertTrue("top worker consumes the deepest worker as one of its producers", topConsumesDeepest);
            "cnt"
            SqlStdOperatorTable.EQUALS,
            .findFirst()
     *
     * from {@code DistributedAggOverJoinTests#testEmptyGroupAggregateOverJoin_distributes}.
        );
        assertEquals(StageExecutionType.COORDINATOR_REDUCE, newRoot.getExecutionType());
        for (ShuffleEnrichment.WorkerLevel level : levels) {
        Map<String, Long> rowCounts = Map.of("a_idx", 1_000L, "b_idx", 1_000L, "c_idx", 1_000L);
                    .put("index.composite.primary_data_format", "parquet")
            List.of(),
     * distributes BOTH sub-joins and the top join with no special code → THREE binary worker tiers, the top
     * gate requires ALL joins to be equi-joins — a single CROSS JOIN anywhere (e.g. PPL {@code transpose}
            join,
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
        int aCols = filtered.getRowType().getFieldCount();
     * A global Sort above the aggregate is a coordinator post-aggregate op: it must stay on the coordinator
                "broadcast-under-shuffle producer must be a SHARD_FRAGMENT (scans shards, ships its partition), "
        RelNode leftScan = stubScan(mockTable(leftIdx, "status", "size"));
import com.google.common.collect.ImmutableList;
        ClusterState state = mockClusterStateWithDataNodes(shardCounts);
        // a_idx (small build) ⋈ b_idx (large) at the bottom → broadcast-eligible; ⋈ c_idx (large) on top → shuffle.
            partial.getAggCallList().get(0).getAggregation().getName().toUpperCase(java.util.Locale.ROOT)
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
import java.util.Set;
            StageExecutionType.SHARD_FRAGMENT,
                && !RelNodeUtils.findNodes(f, OpenSearchBroadcastScan.class).isEmpty()
            (lvl, pc) -> nodeIds(pc)
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
        RelNode aScan = stubScan(mockTable("a_idx", "status", "size"));
            SqlStdOperatorTable.EQUALS,
            "PARTIAL keeps COUNT",
        long partials = aggs.stream().filter(a -> a.getMode() == org.opensearch.analytics.planner.rel.AggregateMode.PARTIAL).count();
        );
    }
    }
    /** Builds Join(Aggregate(Join(a,b) by col0, count), c) — an Aggregate between the join levels.
    private static final long SMALL = 1_000L;
        return LogicalJoin.create(ab, cScan, List.of(), abcCond, Set.of(), JoinRelType.INNER);
            findAll(enforced, OpenSearchBroadcastExchange.class).size()
            assertTrue("such a build must carry a ShardTargetResolver:\n" + dag, build.getTargetResolver() instanceof ShardTargetResolver);
        // The top join's left shuffle re-partitions the bottom join's output (same-key inter-tier shuffle);
            hasBroadcast && hasShuffle
            ab,
            .filter(j -> findAll(j, OpenSearchJoin.class).size() == 2) // the one containing the other join
    public void testGeneralShuffle_sortAboveAggOverJoinStaysOnCoordinator() {
        GeneralShuffleDAGRewriter.Structure s = GeneralShuffleDAGRewriter.rewriteStructure(
    /**
        assertEquals("two join worker tiers promoted", 2, structure.buildLevels().size());
    public void testEnforcementPass_aggOverJoinSumRebasedThroughSplit() {
        );
     * Column-prune-before-shuffle (opt #2c): the pre-marking {@code RelFieldTrimmer} must drop columns
            List.of(1),
     * bottom join.
        );
     * before the window — the bug was that the SINGLETON requirement went through the satisfies()-gated
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
        RexNode abCond = rexBuilder.makeCall(
     * the cascade below must still form. Asserts: exactly one PARTIAL + one FINAL aggregate, a cascade
        org.apache.calcite.rex.RexBuilder rb = join.getCluster().getRexBuilder();
            context.getDistributionTraitDef(),
        assertTrue("top join right input shuffled", unwrap(top.getInput(1)) instanceof OpenSearchShuffleExchange);
            List<String> fields = sx.getInput().getRowType().getFieldNames();
 *       tier in place; {@link ShuffleEnrichment.WorkerLevel} describes each tier (worker stage + its two
        // Top join: ab.col0 = cd.col0 (cd's col0 is at offset abCols in the joined row).
     * sits inside the bottom worker's fragment.
        List<ShuffleEnrichment.WorkerLevel> levels = structure.buildLevels();
        // gate the trim declines: no DUMMY Project, and the top equi-join keeps its wide-input index.
        );
        assertEquals("two binary join tiers → two worker tiers", 2, levels.size());
        // by the precondition).
        int abCols = ab.getRowType().getFieldCount();
 *   <li>{@link DistributionEnforcementPass} co-partitions each join level (post-CBO), inserting the
        RelNode cScan = stubScan(mockTable("c_idx", "status", "size"));
        assertEquals("two joins", 2, joins.size());
                fields.stream().anyMatch(f -> f.startsWith("size"))
public class CascadeShuffleProbeTests extends BasePlannerRulesTests {
    }
            rexBuilder.makeInputRef(intType, aCols)
            unwrap(agg.getInput(0)) instanceof OpenSearchExchangeReducer
            typeFactory.createSqlType(SqlTypeName.INTEGER),
        );
        for (ShuffleEnrichment.WorkerLevel level : levels) {
            return parallelism;
            )
            context.getDistributionTraitDef(),
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3, "d_idx", 3);
     * Option B: agg over a 3-way cascade (q5/q10 class). The enforcement pass must split the SINGLE
        assertEquals("root stays coordinator reduce", StageExecutionType.COORDINATOR_REDUCE, newRoot.getExecutionType());
    private RelNode makeBushyFourWayJoin(PlannerContext context) {
            SqlStdOperatorTable.EQUALS,
        );
            assertFalse(
            "bottom worker left producer is a shard fragment (no gather inserted by the mid-Project)",
            SqlStdOperatorTable.EQUALS,
        List<ShuffleEnrichment.WorkerLevel> levels = s.buildLevels();
            org.opensearch.analytics.planner.rel.OpenSearchFilter.class
            rexBuilder.makeInputRef(intType, aggCols)
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
        );
        // Multi-arg COUNT(DISTINCT col1, col2): residual DISTINCT (the single-arg OpenSearchDistinctCountRule
        return LogicalAggregate.create(join, List.of(), ImmutableBitSet.of(1), null, List.of(countCall));
     * {@code FINAL(ER(PARTIAL(...)))}; DAGBuilder cut the ER, so the PARTIAL sits in the SAME stage as the
     * enforcement pass PRESERVES that decision (step 3b-bcast) — re-emitting
     *  Models PPL {@code a join b | stats count() by g | join c}. */
        // did NOT cut a gather stage between the bottom join and its scans.
            SqlStdOperatorTable.EQUALS,
            CLUSTER_DATA_NODES,
        }
        assertTrue("top worker consumes the bottom worker directly (no gather between tiers)", topConsumesDeepest);
        RelNode cbo = runPlanner(logical, context);
    public void testEnforcementPass_leftOuterThreeWayJoinCascades() {
            IndexMetadata indexMetadata = mock(IndexMetadata.class);
            rexBuilder.makeInputRef(intType, leftCols)
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
        boolean hasBroadcast = !findAll(enforced, OpenSearchBroadcastExchange.class).isEmpty();
     * agg-over-join plan must report one {@code FieldStorageInfo} per output column. The original bug was a
    public void testGeneralShuffle_bushyTreePromotesThreeWorkerTiers() {
        org.opensearch.analytics.planner.rel.OpenSearchAggregate agg = aggs.get(0);
            "FINAL re-merges COUNT via SUM (FinalAggCallBuilder swap — else cross-partition counts are wrong)",
    /** Builds Aggregate(Join(Join(a,b), c) by col0, count) — an Aggregate ABOVE the top join (the
                "broadcast-under-shuffle producer must have a ShardTargetResolver",
            /* shuffleAggregateEnabled */ true
            rexBuilder.makeInputRef(intType, 0),
            false,
                    || unwrap(j.getInput(1)) instanceof OpenSearchShuffleExchange
            SqlStdOperatorTable.COUNT,
        );
                    && unwrap(j.getInput(1)) instanceof OpenSearchShuffleExchange
     * to width 1 ({@code status}), the inter-tier join shuffle to the two join keys ({@code status},
            assertEquals("each tier role SHUFFLE_WORKER", Stage.StageRole.SHUFFLE_WORKER, level.worker().getRole());
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
            List.of(),
     * subquery's aggregate — TPC-H q4 `exists`→SEMI, q22 `not exists`→ANTI, q2/q15 scalar subqueries) must
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
            rexBuilder.makeInputRef(intType, 0),
        }
        RelNode dScan = stubScan(mockTable("d_idx", "status", "size"));
        RelNode logical = LogicalJoin.create(l, r, List.of(), cond, Set.of(), JoinRelType.INNER);
        PlanAlternativeSelector.selectAll(dag, context.getCapabilityRegistry(), false);
            context.getDistributionTraitDef(),
import java.util.List;
        return LogicalAggregate.create(join, List.of(), ImmutableBitSet.of(), null, List.of(sumCall));
        return LogicalAggregate.create(join, List.of(), ImmutableBitSet.of(0), null, List.of(countCall));
        );
        RelNode cScan = stubScan(mockTable("c_idx", "status", "size"));
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        RelNode join = makeThreeWayJoin(context); // joins on col0 (status)
        assertEquals(StageExecutionType.COORDINATOR_REDUCE, newRoot.getExecutionType());
        AggregateCall distinctMultiArg = AggregateCall.create(
        List<OpenSearchShuffleExchange> shuffles = findAll(enforced, OpenSearchShuffleExchange.class);
        int leftCols = leftScan.getRowType().getFieldCount();
import java.util.Map;
    public void testGeneralShuffle_threeWayJoinPromotesTwoWorkerTiers() {
        assertEquals("top worker carries the PARTIAL", 1, workerAggs.size());
            /* shuffleAggregateEnabled */ true
import org.apache.calcite.rel.logical.LogicalJoin;
        );
     * one probe per level) and bails on a bushy tree; the general pass is a plain bottom-up visitor, so it
        long partials = aggs.stream().filter(a -> a.getMode() == org.opensearch.analytics.planner.rel.AggregateMode.PARTIAL).count();
                + "which means RelFieldTrimmer wrongly fired and silently rewrote the cross-join branch "
        );
 */
    }
     */
            context.getDistributionTraitDef(),
            /* shuffleAggregateEnabled */ false
     *     (which legitimately fires for a small filtered build) doesn't take the plan. {@code < 0} leaves
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
    private PlannerContext buildMppContext(Map<String, Integer> shardCounts, Map<String, Long> rowCounts) {
        int cCols = cScan.getRowType().getFieldCount();
        RelNode cbo = runPlanner(logical, context);
     * id per shuffle-input cut), so the two producers have distinct ids even when both scan the same table.
            "no Sort on the worker (per-partition sort + merge would be wrong for a global sort)",
        RelNode bScan = stubScan(mockTable("b_idx", "status", "size"));
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
            rexBuilder.makeInputRef(intType, abCols)
        GeneralShuffleDAGRewriter.Structure structure = enforceAndPromote(makeSortedSumByGroupOverThreeWayJoin(context), context);
            out.add(stage);
    public void testDagCut_broadcastUnderShuffleProducerIsShardFragment() {
        List<Stage> builds = new java.util.ArrayList<>();
    }
            .orElseThrow(() -> new AssertionError("no join-over-aggregate found"));
        // The JOIN cascade below is still distributed — only the aggregate split is suppressed.
            )
     * shuffle algebra. Asserts exactly one broadcast exchange survives, NO shuffle is introduced, and one
        OpenSearchTableScan cScan = null;
        assertEquals("coordinator root carries exactly the FINAL aggregate", 1, rootAggs.size());
        );
    public void testColumnPruneSkipsPlanWithCrossJoin() {
                unwrap(join.getInput(0)) instanceof OpenSearchShuffleExchange
        RelNode enforced = DistributionEnforcementPass.enforce(
        assertNotNull(
    public void testEnforcementPass_nonDecomposableAggOverJoinGathers() {
     * but it must NOT ride on the join worker per-partition (that would compute per-partition distinct
     */
                j -> unwrap(j.getInput(0)) instanceof OpenSearchShuffleExchange
                level.leftProducer().getExecutionType() != StageExecutionType.COORDINATOR_REDUCE
    /** {@code SUM(size) by status | sort total desc} over the 3-way join — models q5's
            || top.rightProducer().getStageId() == deepest.worker().getStageId();
 * <ol>
        );
            SqlStdOperatorTable.EQUALS,
        PlanAlternativeSelector.selectAll(dag, context.getCapabilityRegistry(), false);
            -1,
            -1,
        AggregateCall countCall = AggregateCall.create(
     * while the top join shuffles. Unlike the earlier reverted attempt (which GATED broadcast off here to
}
        );
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
        RelNode logical = makeWindowOverThreeWayJoin(context);
        List<org.opensearch.analytics.planner.rel.OpenSearchAggregate> aggs = findAll(
            unwrap(filter.getInput(0)) instanceof org.opensearch.analytics.planner.rel.OpenSearchTableScan
    }
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
        org.opensearch.analytics.planner.rel.OpenSearchAggregate partial = aggOfMode(
        );
            "window project must gather (ER) its distributed-join input before running the global window frame",
            "FINAL SUM arg rebased to the partial-state column",
        );
    public void testEnforcementPass_broadcastUnderCascadeIsPreserved() {
        RelNode enforced = DistributionEnforcementPass.enforce(
        // top join keyed on col1 (size), a DIFFERENT column than the bottom (col0/status)
            "precondition: inner join must be a broadcast probe:\n" + org.apache.calcite.plan.RelOptUtil.toString(enforced2),
     * so every shuffle's input must be narrowed to just the referenced column(s) — scan-level shuffles
 * without the convert pipeline (the mock backend has no fragment convertor; conversion + actual
        );
        RelNode cbo = runPlanner(makeTwoWayJoin(context, "small_idx", "large_idx"), context);
        // The mixed shape: a preserved broadcast AND a shuffle in the same enforced DAG. (Exact counts depend
        AggregateCall sumCall = AggregateCall.create(
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
        RelNode cbo = runPlanner(makeAggregateOverThreeWayJoin(context), context);
    private RelNode makeJoinOverAggregateOverJoin(PlannerContext context) {
import java.util.function.Function;
        );
            );
            broadcastProducers.isEmpty()
            org.opensearch.analytics.planner.rel.AggregateMode.PARTIAL
            /* shuffleAggregateEnabled */ true
        QueryDAG dag = DAGBuilder.build(enforced, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
            "coordinator carries the FINAL",
            enforced,
     * partial-state column (groupCount + 0), not the original input ordinal. Ported from
        RelNode cbo = runPlanner(makeThreeWayJoinTopType(context, JoinRelType.LEFT), context);
        AggregateCall countCall = AggregateCall.create(
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
        RelNode enforced3 = DistributionEnforcementPass.enforce(
        ShuffleEnrichment.WorkerLevel top = levels.get(levels.size() - 1);
     * <p><b>Binary-tier lowering.</b> A join is a worker-tier boundary: the hash-shuffle transport
     * ({@code shouldSkipPartialFinalSplit} true for DISTINCT) so {@code requiredInputDistribution} is null —
            rexBuilder.makeInputRef(intType, abCols + 1)
            .filter(
        );
            hasDummyRewrite
        // The filter feeding the join must sit DIRECTLY over the scan under its shuffle — no ER between them.
import org.opensearch.analytics.planner.dag.ShardTargetResolver;
     * producer stage, exactly as the legacy cascade does (intermediate worker → shuffle → parent worker).
    /**
        ShuffleEnrichment.WorkerLevel top = levels.get(2);
     * child, so its presence must not flip the producer to a reduce. Before the fix, such a producer became a
        RelNode outerJoin = innerJoin.copy(innerJoin.getTraitSet(), cond, outerBuild, cScan, JoinRelType.INNER, false);
        RexNode filterCond = rexBuilder.makeCall(
    }
        assertEquals(
            rexBuilder.makeInputRef(intType, 0),
    }
     * reduce stage emits to its parent sink and CANNOT ship a hash shuffle, so distributing the top join
        OpenSearchJoin top = joins.stream()
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
            SqlStdOperatorTable.EQUALS,
     * join input is the broadcast (build) while the other stays bare (shard-local probe).
            enforced,
        RexNode aggcCond = rexBuilder.makeCall(
        assertEquals("two joins in the 3-way plan", 2, joins.size());
        int leftCols = outerBuild.getRowType().getFieldCount();
        assertTrue(
        when(state.nodes()).thenReturn(nodes);
        Map<String, Integer> shardCounts = Map.of("small_idx", 3, "large_idx", 3);
     * Codex BLOCKER 1 regression: a window function ({@code RexOver}) over a distributed multi-way join.
        int aCols = aScan.getRowType().getFieldCount();
            false,
            groupCount,
        RelNode join = makeThreeWayJoin(context);
        int aCols = aScan.getRowType().getFieldCount();
        RelNode outerBuild = context.getDistributionTraitDef().buildBroadcastExchange(innerJoin, CLUSTER_DATA_NODES);
            findAll(root.getFragment(), org.opensearch.analytics.planner.rel.OpenSearchSort.class).isEmpty()
            runPlanner(makeThreeWayJoin(context), context),
        // on CBO's per-join choice; the contract is that broadcast is NOT stripped and shuffle still forms.)
import org.opensearch.cluster.ClusterState;
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);
     * FINAL, the PARTIAL's input is the join directly (NO ShuffleExchange between the PARTIAL and the join),
        RelNode ab = LogicalJoin.create(aScan, bScan, List.of(), abCond, Set.of(), JoinRelType.INNER);
     * coordinator ReduceStageExecution as the shuffle producer, which never ships → worker timeout.
        RelNode join = makeThreeWayJoin(context);
        assertTrue("bottom join sits under the top's left re-shuffle", underLeftShuffle instanceof OpenSearchJoin);
        RelNode bScan = stubScan(mockTable("b_idx", "status", "size"));
            .filter(p -> !findAll(p, OpenSearchJoin.class).isEmpty()) // the project above the join
    /** Like makeThreeWayJoin but the TOP join uses the given type (INNER/LEFT/…). */
        RelNode root,
            int shardCount = entry.getValue();
            finalAgg.getAggCallList().get(0).getAggregation().getName().toUpperCase(java.util.Locale.ROOT)
            SqlStdOperatorTable.EQUALS,
        OpenSearchProject windowProject = findAll(enforced, OpenSearchProject.class).stream()
        // The top worker consumes the bottom worker as one of its two producers (the inter-tier shuffle), not
            .orElseThrow(() -> new AssertionError("no window project found"));
            wl.leftProducer().getStageId() != wl.rightProducer().getStageId()
        // under it sits the bottom join over its two scan shuffles.
     * {@code size} columns SURVIVE into the plan (proving the trim declined). The sibling
        RelNode crossAb = LogicalJoin.create(aScan, bScan, List.of(), rexBuilder.makeLiteral(true), Set.of(), JoinRelType.INNER);
import org.apache.calcite.rel.RelNode;
    }
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        PlannerContext context = buildMppContext(shardCounts, rowCounts, /* maxBroadcastBytes */ 1L);
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
     * CROSS JOIN ({@code condition=[true]}). The mixed plan must NOT be trimmed — so the otherwise-dead
        RexNode abcCond = rexBuilder.makeCall(
        int groupCount = finalAgg.getGroupSet().cardinality();
        // intermediate worker).
            );
            rexBuilder.makeInputRef(intType, 0),
        );
     * worker consuming the two sub-join workers as its producers.
    public void testEnforcementPass_aggOverJoinEveryNodeReportsCompleteFieldStorage() {
            assertTrue("worker resolver is WorkerTargetResolver", level.worker().getTargetResolver() instanceof WorkerTargetResolver);
     * two worker tiers, the PARTIAL on the top worker's fragment, the FINAL on the coordinator root.
        List<ShuffleEnrichment.WorkerLevel> levels = structure.buildLevels();
            "the root aggregate is the FINAL",
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
        }
            CLUSTER_DATA_NODES,
            "deepest worker left producer is a shard fragment",
        // The TOP join (the one whose left input is the aggregate) must have NEITHER input shuffled — it
        );
        }
        // synthetic DUMMY literal Project (it prunes ALL of b's real columns since nothing references them
        // Sort by the aggregate output column (index 1 = "total") descending.
        assertEquals("both join levels are binary tiers (each over two shuffles)", 2, binaryTierJoins);
            "the worker aggregate is the PARTIAL",
            midProjects,
        RelNode logical = makeAggregateGroupedOnNonJoinKey(context);
        // The top tier (level 2, last bottom-up) consumes the two sub-join workers (levels 0 and 1) as BOTH
        boolean topConsumesDeepest = top.leftProducer().getStageId() == deepest.worker().getStageId()
            enforced,
     * counting across partitions. The split rule pre-decomposes via {@code FinalAggCallBuilder.buildFinalCalls},
    }
     * which {@code DistributionEnforcementPass.splitAggregate} reuses; this asserts the decomposition survives
 *       hash-shuffle inputs so {@code DAGBuilder} cuts a nested-shuffle DAG.</li>
    public void testDagCut_nestedBroadcastBuildIsShardFragment() {
     * INNER-only; the enforcement pass co-partitions outer joins too (null-fill is partition-local for a
        long binaryTierJoins = joins.stream()
        }
            assertEquals("each tier is a WORKER_FRAGMENT", StageExecutionType.WORKER_FRAGMENT, level.worker().getExecutionType());
     * of 2 joins, and the FINAL gathers (ER above PARTIAL).
        long finals = aggs.stream().filter(a -> a.getMode() == org.opensearch.analytics.planner.rel.AggregateMode.FINAL).count();
    public void testEnforcementPass_windowOverJoinGathersBeforeWindow() {
        );
        // A c_idx shard scan to serve as the outer probe.
     * sf=10 bucket-A BLOCKER regression: a JOIN whose input is a GATHERED sub-stage (a decorrelated
            CLUSTER_DATA_NODES,
     */
        for (Stage build : builds) {
            when(indexMetadata.mapping()).thenReturn(mappingMetadata);
            rexBuilder.makeInputRef(intType, abCols)
     * delivers exactly two named inputs per worker (left/right buffer slices). So even though the bottom
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
        RexNode countOver = rb.makeOver(
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
            )
     * NOT be distributed. {@code Join(Aggregate(Join(A,B)), C)} — the top join's left input is an aggregate
    }
        RelNode cScan = stubScan(mockTable("c_idx", "status", "size"));
        return new PlannerContext(registry, state, settings, rowCountLookup, /* profiling */ false);
            /* minRows */ 1L,
     * bottom join into a separate reduce-fed stage that never ships its shuffle, so the top worker times out
    /** Recursively collects stages whose predicate holds (test helper for DAG-shape assertions). */
        );
        }, broadcastProducers);
            assertTrue(
        ShuffleEnrichment.WorkerLevel top = levels.get(1);
            finalAgg.getAggCallList().get(0).getAggregation().getName().toUpperCase(java.util.Locale.ROOT)
        }
     * {@code DAGBuilder.cutBroadcast} must decide the build stage's locality by {@code fragmentHasShardScan}
        }
        // a_idx | where status > 5 | join on status = b.status b_idx
        RexNode abCond = rexBuilder.makeCall(
        // TWO worker tiers — NOT three (a spurious gather stage from the mid-Project would break promotion).
     */
    public void testEnforcementPass_threeWayJoinFormsCascade() {
                "no worker producer may be a COORDINATOR_REDUCE (that would never ship a shuffle → timeout)",
        // Without trimming the scan shuffles ship [status, size] (width 2) and the inter-tier join
 *       shuffle producers).</li>
            .filter(
     * @param maxBroadcastBytes when {@code >= 0}, sets {@code analytics.mpp.broadcast.max_bytes} — a tiny
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
        );
        List<ShuffleEnrichment.WorkerLevel> levels = structure.buildLevels();
        RelNode cbo = runPlanner(makeSumByGroupOverThreeWayJoin(context), context);
                j -> unwrap(j.getInput(0)) instanceof OpenSearchShuffleExchange
            .orElseThrow();
        return LogicalJoin.create(ab, cd, List.of(), topCond, Set.of(), JoinRelType.INNER);
            ids.add("node-" + (p % CLUSTER_DATA_NODES));
    public void testEnforcementPass_joinOverGatheredAggregateStaysCoordCentric() {
        RexNode abCond = rexBuilder.makeCall(
                j -> unwrap(j.getInput(0)) instanceof OpenSearchShuffleExchange
                    + "COORDINATOR_REDUCE — even when it has its own build grandchild (nested broadcast):\n"
     * preserves BOTH: the bottom broadcast AND the top shuffle survive in one enforced DAG. Asserts a
        assertEquals(
        // Deepest worker (level 0) consumes two leaf shard scans; top worker (level 1) consumes the deepest
        // its producers — the bushy signature (vs the left-deep cascade, where only the left producer is an
     * into the enforced plan.
            context.getCapabilityRegistry(),
        }
        );
            SqlStdOperatorTable.EQUALS,
     * Codex-review MUST-FIX (correctness): {@code RelFieldTrimmer} rewrites the WHOLE plan, so the trim
import org.opensearch.analytics.planner.dag.DAGBuilder;
    /**
            enforced,
        RelNode enforced = DistributionEnforcementPass.enforce(
            ImmutableList.of(),
        assertEquals("sub-toggle off: the SINGLE aggregate stays whole on the coordinator", 1, singles);
        boolean hasShuffle = !findAll(enforced, OpenSearchShuffleExchange.class).isEmpty();
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
        ToLongFunction<String> rowCountLookup = name -> rowCounts.getOrDefault(name, PlannerContext.UNKNOWN_ROW_COUNT);
            rexBuilder.makeLiteral(5, intType, false)
     * {@code COORDINATOR_REDUCE} that — once {@code UnifiedDispatch} strips the captured build child —
                "promoted join tier must be a WORKER_FRAGMENT",
    private RelNode makeSumByGroupOverThreeWayJoin(PlannerContext context) {
    }
     * Regression (the q3 intermediate-Project worker-timeout, found at sf-scale on the cluster): a 3-way
            (int) finalAgg.getAggCallList().get(0).getArgList().get(0)
     */
    public void testEnforcementPass_aggOverJoinDecomposesCountToSumOnFinal() {
            org.opensearch.analytics.planner.rel.AggregateMode.FINAL,
import static org.mockito.Mockito.when;
     *  between the two join levels (the real PPL plan shape; each join's output is renamed). Shared key col0. */
     */
        Map<String, Long> rowCounts = Map.of("a_idx", SMALL, "b_idx", LARGE, "c_idx", LARGE);
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
     * A nested build BOTH scans a shard table and has a grandchild (its own captured build), so keying off
     * catches it. Ported from {@code DistributedAggOverJoinTests#…everyNodeReportsCompleteFieldStorage}.
        assertTrue("enforced DAG has a distributed join to promote", GeneralShuffleDAGRewriter.hasDistributedJoin(dag));
     * and still distributes. Guards the "disable distributed aggregation, keep MPP joins" contract.
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
     * made BOTH joins their own join-over-two-shuffles stage, so the rewriter promotes TWO worker tiers in
            typeFactory.createSqlType(SqlTypeName.BIGINT),
        assertEquals("exactly one FINAL aggregate (on the coordinator)", 1, finals);
        RelNode bScan = stubScan(mockTable("b_idx", "status", "size"));
     *  reports one {@code FieldStorageInfo} per output column — the invariant a short list violates with
     */
