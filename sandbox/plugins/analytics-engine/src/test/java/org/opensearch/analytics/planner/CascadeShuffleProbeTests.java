import static org.mockito.Mockito.when;
        RelNode cbo = runPlanner(makeAggregateOverThreeWayJoin(context), context);  
        );
        // worker (its producer) + a leaf scan.  
import org.apache.calcite.rel.logical.LogicalJoin;  
    public void testGeneralShuffle_threeWayJoinPromotesTwoWorkerTiers() {  
     * but it must NOT ride on the join worker per-partition (that would compute per-partition distinct
        long shuffleJoins = joins.stream()
            org.opensearch.analytics.planner.rel.OpenSearchAggregate.class
     * producer stage must be cut as a {@link StageExecutionType#SHARD_FRAGMENT} with a  
        }, broadcastProducers);
                "broadcast-under-shuffle producer must have a ShardTargetResolver",
        Metadata metadata = mock(Metadata.class);  
            workerAggs.get(0).getMode()  
 *   <li>{@link GeneralShuffleDAGRewriter#rewriteStructure} promotes each join level into its own worker
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
     * {@link Stage} then classifies it {@code COORDINATOR_REDUCE} while its instruction list still carries a
     * two worker tiers, the PARTIAL on the top worker's fragment, the FINAL on the coordinator root.  
        public int defaultShuffleParallelism(ClusterState state) {  
import org.apache.calcite.rel.logical.LogicalProject;
import org.opensearch.core.index.Index;
        for (OpenSearchShuffleExchange sx : shuffles) {
    public void testGeneralShuffle_intermediateProjectRidesOnWorker() {
        ShuffleEnrichment.WorkerLevel top = levels.get(2);
        assertEquals("two joins in the 3-way plan", 2, joins.size());  
            typeFactory.createSqlType(SqlTypeName.BIGINT),
            groupCount,  
            midProjects.add(rexBuilder.makeInputRef(ab, i));  
        );
     */
            hasDummyRewrite
    }
            rexBuilder.makeInputRef(intType, 0),
        RexNode abcCond = rexBuilder.makeCall(
        RelNode logical = makeDistinctCountOverThreeWayJoin(context);
     * scan shuffles; the top worker consumes the deepest worker (as a producer) + a leaf scan shuffle.
        );  
        RelNode filtered = org.apache.calcite.rel.logical.LogicalFilter.create(aScan, filterCond);  
        private final int parallelism;
            findAll(root.getFragment(), org.opensearch.analytics.planner.rel.OpenSearchSort.class).isEmpty()
        RexNode abCond = rexBuilder.makeCall(
            false,  
        assertEquals("one worker tier for the self-join", 1, levels.size());
     * ({@code shouldSkipPartialFinalSplit} true for DISTINCT) so {@code requiredInputDistribution} is null —  
     */
            assertFalse(
            runPlanner(makeThreeWayJoin(context), context),
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
            out.add(stage);
import org.opensearch.common.settings.Settings;  
        // on CBO's per-join choice; the contract is that broadcast is NOT stripped and shuffle still forms.)
     * counts with no FINAL merge → silently wrong). The pass must GATHER the join output and run the SINGLE
        assertEquals(
            this.parallelism = parallelism;
     * {@code COUNT() GROUP BY col0} over a 3-way join of 2-col tables the aggregate needs only col0,
import java.util.Map;
        for (Stage child : stage.getChildStages()) {
        int abCols = crossAb.getRowType().getFieldCount();  
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3);
        }
        GeneralShuffleDAGRewriter.Structure structure = enforceAndPromote(makeBushyFourWayJoin(context), context);
        List<Stage> broadcastProducers = new java.util.ArrayList<>();
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);  
        );  
 * SPDX-License-Identifier: Apache-2.0
     */
        // The cascade still forms below the PARTIAL: 2 joins, each a binary tier (over two shuffles).
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
            enforced,
    /**  
     * Codex BLOCKER 1 regression: a window function ({@code RexOver}) over a distributed multi-way join.  
        List<org.opensearch.analytics.planner.rel.OpenSearchAggregate> aggs = findAll(
            /* filterArg */ -1,
    /**
     * subquery's aggregate — TPC-H q4 `exists`→SEMI, q22 `not exists`→ANTI, q2/q15 scalar subqueries) must  
        int cCols = cScan.getRowType().getFieldCount();
            org.opensearch.analytics.planner.rel.AggregateMode.PARTIAL,
            finalAgg.getAggCallList().get(0).getAggregation().getName().toUpperCase(java.util.Locale.ROOT)  
        );
    public void testEnforcementPass_windowOverJoinGathersBeforeWindow() {
        RexNode joinCond = rexBuilder.makeCall(
        RelNode enforced = DistributionEnforcementPass.enforce(  
        // shouldSkipPartialFinalSplit returns true (aggCall.isDistinct()) → non-decomposable → must gather.
 *       hash-shuffle inputs so {@code DAGBuilder} cuts a nested-shuffle DAG.</li>  
        long finals = aggs.stream().filter(a -> a.getMode() == org.opensearch.analytics.planner.rel.AggregateMode.FINAL).count();
        RelNode outerJoin = innerJoin.copy(innerJoin.getTraitSet(), cond, outerBuild, cScan, JoinRelType.INNER, false);
        RexNode abCond = rexBuilder.makeCall(
        RelNode bScan = stubScan(mockTable("b_idx", "status", "size"));  
                Settings.builder()  
     * handed to a {@code ShardScanExecutionContext}.  
            assertEquals("worker role SHUFFLE_WORKER", Stage.StageRole.SHUFFLE_WORKER, level.worker().getRole());  
    }
    private <T> void collect(RelNode node, Class<T> type, List<T> out) {
            cbo,  
public class CascadeShuffleProbeTests extends BasePlannerRulesTests {  
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
     * {@code DAGBuilder.cutBroadcast} must decide the build stage's locality by {@code fragmentHasShardScan}  
                producer.getExecutionType()
     * while the top join shuffles. Unlike the earlier reverted attempt (which GATED broadcast off here to
     * window running per-partition (silently wrong). Asserts the window Project's input is an
            /* minRows */ 1_000_000L,  
     * aggregate rides on the top worker (runs per-partition), and the FINAL stays on the coordinator. Asserts
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
            }
            when(mappingMetadata.sourceAsMap()).thenReturn(Map.of("properties", intFields()));  
     */
     * Coverage the legacy cascade CANNOT do: a BUSHY (non-left-deep) tree {@code (A⋈B) ⋈ (C⋈D)} on a
    private static final int CLUSTER_DATA_NODES = 3;
            || top.rightProducer().getStageId() == deepest.worker().getStageId();
    public void testEnforcementPass_leftOuterThreeWayJoinCascades() {  
        RexNode abCond = rexBuilder.makeCall(  
        assertEquals("two joins", 2, joins.size());  
import org.opensearch.analytics.planner.dag.GeneralShuffleDAGRewriter;
            org.opensearch.analytics.planner.rel.OpenSearchRelNode.class  
        List<OpenSearchJoin> joins = findAll(enforced, OpenSearchJoin.class);
            findAll(enforced, OpenSearchBroadcastExchange.class).size()  
            assertEquals(
            join,  
            context.getDistributionTraitDef(),
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
        org.opensearch.analytics.planner.rel.OpenSearchAggregate partial = aggs.stream()
        assertNotNull("empty-group SUM over a large join must produce a FINAL on the coordinator", finalAgg);  
     * sits inside the bottom worker's fragment.  
        collectStages(dag.rootStage(), s -> {
            "COUNT",  
     * producer stage, exactly as the legacy cascade does (intermediate worker → shuffle → parent worker).  
        RexNode aggcCond = rexBuilder.makeCall(
     *  RexOver above the join, which requires fully-gathered (SINGLETON) input. */  
    }  
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);  
        assertEquals("two joins distributed below the window gather", 2, joins.size());
     * enrichLevels would enrich as both left and right → only one sink → hang). Verifies the binary shuffle
            "a plan containing a CROSS JOIN must NOT be column-trimmed — found a DUMMY-literal Project, "
    }
    /**  
            .filter(
            assertEquals("each tier is a WORKER_FRAGMENT", StageExecutionType.WORKER_FRAGMENT, level.worker().getExecutionType());  
     */  
        Settings.Builder settingsBuilder = Settings.builder().put("analytics.mpp.enabled", true);
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        return LogicalAggregate.create(join, List.of(), ImmutableBitSet.of(0), null, List.of(countCall));
            org.opensearch.analytics.planner.rel.AggregateMode.PARTIAL,
            "SUM",  
            -1,
            );  
            /* minRows */ 1L,  
     * FINAL, the PARTIAL's input is the join directly (NO ShuffleExchange between the PARTIAL and the join),
        long partials = aggs.stream().filter(a -> a.getMode() == org.opensearch.analytics.planner.rel.AggregateMode.PARTIAL).count();  
        when(nodes.getDataNodes()).thenReturn(dataNodes);  
            when(indexMetadata.mapping()).thenReturn(mappingMetadata);
            SqlStdOperatorTable.EQUALS,  
        if (pred.test(stage)) {
     * Column-prune-before-shuffle (opt #2c): the pre-marking {@code RelFieldTrimmer} must drop columns  
        org.opensearch.analytics.planner.rel.OpenSearchAggregate agg = aggs.get(0);
        return LogicalAggregate.create(join, List.of(), ImmutableBitSet.of(0), null, List.of(sumCall));  
        );  
        // Outer join: agg's group-key column (output index 0) = c.col0.
    }
        org.opensearch.analytics.planner.rel.OpenSearchAggregate finalAgg = aggOfMode(  
     *
        RelNode cScan = stubScan(mockTable("c_idx", "status", "size"));
import org.opensearch.analytics.planner.rel.OpenSearchShuffleExchange;  
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
        for (ShuffleEnrichment.WorkerLevel level : levels) {
     * buildEnforcer, which trusted the join's stale CBO coordSingleton trait and skipped the ER, leaving the
        }
    public void testEnforcementPass_nonDecomposableAggOverJoinGathers() {  
        RelNode join = makeThreeWayJoin(context);
        // (anyMatch) gate firing is RelFieldTrimmer rewriting the cross-join's unreferenced input into a  
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);  
        }
            newRoot.getFragment(),
            .filter(j -> !findAll(j, org.opensearch.analytics.planner.rel.OpenSearchAggregate.class).isEmpty())
        long binaryTiers = joins.stream()
     * bottom join into a separate reduce-fed stage that never ships its shuffle, so the top worker times out
        boolean topConsumesDeepest = top.leftProducer().getStageId() == deepest.worker().getStageId()
        OpenSearchJoin top = joins.stream()
            RelNode f = s.getFragment();  
        Map<String, Long> rowCounts = Map.of("a_idx", SMALL, "b_idx", LARGE, "c_idx", LARGE);
        GeneralShuffleDAGRewriter.Structure structure = enforceAndPromote(makeThreeWayJoin(context), context);
            typeFactory.createSqlType(SqlTypeName.BIGINT),
     * A global Sort above the aggregate is a coordinator post-aggregate op: it must stay on the coordinator
            List.of(),
        RelNode enforced = DistributionEnforcementPass.enforce(  
     */
     * coordinator reduce. CBO gathers the scan (ER) under the filter; the pass peels that ER, and the filter
            /* minRows */ 1L,
     * made BOTH joins their own join-over-two-shuffles stage, so the rewriter promotes TWO worker tiers in
        RelNode cScan = stubScan(mockTable("c_idx", "status", "size"));  
    }
        assertEquals("two binary join tiers → two worker tiers", 2, levels.size());  
            int shardCount = entry.getValue();
            "total"
            -1,  
                "shuffle input must not carry the unreferenced 'size' column after trimming (got " + fields + ")",
        assertFalse(
        );  
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
            rexBuilder.makeInputRef(intType, cCols)
        );  
     */
     *  between the two join levels (the real PPL plan shape; each join's output is renamed). Shared key col0. */
     * had zero children and threw "COORDINATOR_REDUCE stage N expected at least one child, got zero".  
        // its producers — the bushy signature (vs the left-deep cascade, where only the left producer is an  
        assertEquals("exactly one PARTIAL aggregate (pushed below the gather)", 1, partials);
     *  TPC-H q3 shape). The agg runs on the coordinator after the worker join, so cascade detection  
            cbo,
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
        RelNode cbo = runPlanner(makeThreeWayJoin(context), context);
            "non-decomposable agg must GATHER its distributed-join input (ER), NOT ride per-partition on the worker",
            rexBuilder.makeInputRef(intType, aCols)
        RelNode bScan = stubScan(mockTable("b_idx", "status", "size"));  
            when(metadata.index(indexName)).thenReturn(indexMetadata);
    public void testEnforcementPass_broadcastUnderCascadeIsPreserved() {
    /**
            "deepest worker left producer is a shard fragment",
     * the aggregate sub-toggle OFF. The pass must NOT split the aggregate (no PARTIAL/FINAL) — it stays a
import org.apache.calcite.rex.RexWindowBounds;
        // COUNT is a mock-backend-supported function (unlike COLLECT/LISTAGG), so the planner admits it.  
     * partial-state column (groupCount + 0), not the original input ordinal. Ported from  
            true  
        // The window-bearing project must sit over a gather, not a partitioned join.
            SqlStdOperatorTable.EQUALS,  
        Map<String, Integer> shardCounts = Map.of("small_idx", 3, "large_idx", 3);  
        List<RexNode> midProjects = new java.util.ArrayList<>();
import org.opensearch.analytics.planner.dag.Stage;
        // The filter feeding the join must sit DIRECTLY over the scan under its shuffle — no ER between them.
        RelNode ab = LogicalJoin.create(aScan, bScan, List.of(), abCond, Set.of(), JoinRelType.INNER);  
     */
            .count();  
    }  
            1L,
            settingsBuilder.put("analytics.mpp.broadcast.max_bytes", maxBroadcastBytes + "b");  
            typeFactory.createSqlType(SqlTypeName.BIGINT),
            org.opensearch.analytics.planner.rel.OpenSearchAggregate.class  
            "dc"
        RelNode join = makeThreeWayJoin(context);  
                && !RelNodeUtils.findNodes(f, OpenSearchTableScan.class).isEmpty();  
        );
        }
            join,  
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);
     * agg-over-join plan must report one {@code FieldStorageInfo} per output column. The original bug was a  
            rexBuilder.makeInputRef(intType, abCols)
    }
     * CROSS JOIN ({@code condition=[true]}). The mixed plan must NOT be trimmed — so the otherwise-dead
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
        for (int i = 0; i < abCols; i++) {
            /* minRows */ 1L,
    /** {@code COUNT() GROUP BY col0} over {@code equiJoin( crossJoin(a,b), c )} — mixes a cross-join with  
                "promoted join tier must be a WORKER_FRAGMENT",
            assertEquals(  
     * no operator references so they never reach the hash-shuffle wire. For
            ab,
            .filter(j -> findAll(j, OpenSearchJoin.class).size() == 2) // the one containing the other join
        int leftCols = leftScan.getRowType().getFieldCount();
    /**  
        RelNode cbo = runPlanner(makeEmptyGroupSumOverThreeWayJoin(context), context);
        List<org.opensearch.analytics.planner.rel.OpenSearchAggregate> workerAggs = findAll(
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
            finalAgg.getAggCallList().get(0).getAggregation().getName().toUpperCase(java.util.Locale.ROOT)
    }
        long finals = aggs.stream().filter(a -> a.getMode() == org.opensearch.analytics.planner.rel.AggregateMode.FINAL).count();
        RelNode bScan = stubScan(mockTable("b_idx", "status", "size"));
            when(indexMetadata.getIndex()).thenReturn(new Index(indexName, indexName + "-uuid"));  
            );
            RelNodeUtils.findNodes(nestedBuild.getFragment(), OpenSearchTableScan.class).isEmpty()  
    }
            List<String> fields = sx.getInput().getRowType().getFieldNames();  
                    || unwrap(j.getInput(1)) instanceof OpenSearchShuffleExchange
     * BROADCAST under a shuffle cascade (E1): a 3-way where CBO broadcasts a small build at the BOTTOM join
        );
        RelNode enforced2 = DistributionEnforcementPass.enforce(
        boolean hasDummyRewrite = projects.stream()
        );  
    }  
        // Top join: ab.col0 = cd.col0 (cd's col0 is at offset abCols in the joined row).
        for (RelNode input : node.getInputs()) {
        Stage newRoot = structure.dag().rootStage();
        GeneralShuffleDAGRewriter.Structure structure = enforceAndPromote(makeSortedSumByGroupOverThreeWayJoin(context), context);
                level.leftProducer().getExecutionType() != StageExecutionType.COORDINATOR_REDUCE
                StageExecutionType.SHARD_FRAGMENT,  
     * {@code COUNT() by g} over a distributed join must split so the PARTIAL keeps COUNT but the FINAL
    }
        org.opensearch.analytics.planner.rel.OpenSearchFilter filter = findAll(  
        RelNode underTopLeftShuffle = unwrap(((OpenSearchShuffleExchange) unwrap(top.getInput(0))).getInput());
            )
        AggregateCall sumCall = AggregateCall.create(  
            .count();  
        RelNode l = stubScan(mockTable("a_idx", "status", "size"));  
     */  
     * hash-partitioned outer join). Asserts the cascade still forms over a LEFT top join.
            org.opensearch.analytics.planner.rel.OpenSearchAggregate.class
        RelNode join = makeThreeWayJoin(context);  
        // Sort by the aggregate output column (index 1 = "total") descending.
                + "(dropping b's rows). The gate must require ALL joins to be equi-joins.",
        assertEquals("root stays coordinator reduce", StageExecutionType.COORDINATOR_REDUCE, newRoot.getExecutionType());
            SqlStdOperatorTable.EQUALS,  
     * {@code COORDINATOR_REDUCE}. {@code DAGBuilder.cutShuffle} decides this by {@code fragmentHasShardScan},
        return org.opensearch.analytics.planner.RelNodeUtils.unwrapHep(node);
        assertFalse(
     * {@code DistributedAggOverJoinTests#testDistributedAggOverJoin_sumPreservedThroughSplit}.
                    + dag,
     * worker (propagate its HASH partitioning), NOT gather it to the coordinator — gathering would cut the  
        RelNode cScan = stubScan(mockTable("c_idx", "status", "size"));
     */
        OpenSearchJoin top = joins.stream().filter(j -> findAll(j, OpenSearchJoin.class).size() == 2).findFirst().orElseThrow();
        return state;
    /**
    /**
    public void testDagCut_nestedBroadcastBuildIsShardFragment() {
            .filter(
        List<OpenSearchProject> projects = findAll(cbo, OpenSearchProject.class);
        }  
    /**  
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);  
import org.opensearch.cluster.ClusterState;  
        return LogicalJoin.create(ab, cd, List.of(), topCond, Set.of(), JoinRelType.INNER);
        );
        assertStorageComplete("empty-group enforced plan", enforced);  
     * gate requires ALL joins to be equi-joins — a single CROSS JOIN anywhere (e.g. PPL {@code transpose}
     * catches it. Ported from {@code DistributedAggOverJoinTests#…everyNodeReportsCompleteFieldStorage}.  
        List<ShuffleEnrichment.WorkerLevel> levels = structure.buildLevels();
                cols,  
        assertEquals(  
     *  {@code … | stats sum(...) by n_name | sort - revenue}. The Sort is a coordinator post-agg op. */
        org.apache.calcite.rel.RelCollation collation = org.apache.calcite.rel.RelCollations.of(  
            cbo,
        // rewrite to decomposable APPROX_COUNT_DISTINCT does NOT apply to multi-arg), so
        PlanAlternativeSelector.selectAll(dag, context.getCapabilityRegistry(), false);
        Settings settings = settingsBuilder.build();
        RexNode abcCond = rexBuilder.makeCall(
        return LogicalJoin.create(midProject, cScan, List.of(), abcCond, Set.of(), JoinRelType.INNER);
            "top join's left input (the gathered aggregate sub-stage) must NOT be shuffled",  
        when(state.metadata()).thenReturn(metadata);
        RelNode dScan = stubScan(mockTable("d_idx", "status", "size"));
    ) {
    /**
            rexBuilder.makeInputRef(intType, abCols)  
        );
            rexBuilder.makeInputRef(intType, 0),  
        // a_idx (small build) ⋈ b_idx (large) at the bottom → broadcast-eligible; ⋈ c_idx (large) on top → shuffle.  
    public void testEnforcementPass_emptyGroupAggOverJoinDistributes() {  
        RelNode logical = LogicalJoin.create(filtered, bScan, List.of(), joinCond, Set.of(), JoinRelType.INNER);
        assertTrue("no shuffle for a join below the row floor", findAll(enforced, OpenSearchShuffleExchange.class).isEmpty());
        );
     * is {@code Join(BroadcastScan(build), shardScan)} — a broadcast nested under a shuffle tier — the
    }  
}
        List<ShuffleEnrichment.WorkerLevel> levels = structure.buildLevels();  
        // Multi-arg COUNT(DISTINCT col1, col2): residual DISTINCT (the single-arg OpenSearchDistinctCountRule  
            cbo,  
        // The mixed shape: a preserved broadcast AND a shuffle in the same enforced DAG. (Exact counts depend
        // Row-wise identity Project over the bottom join (preserves col0 at position 0 so the top join keys
    /**  
        }
        RelNode cbo = runPlanner(makeAggregateOverThreeWayJoin(context), context); // COUNT() by col0
    }
            midProjects,
            "SUM",
        List<OpenSearchJoin> joins = findAll(enforced, OpenSearchJoin.class);
import org.opensearch.analytics.planner.dag.QueryDAG;
        Map<String, Long> rowCounts = Map.of("a_idx", SMALL, "b_idx", LARGE, "c_idx", LARGE);  
     * enforcement pass PRESERVES that decision (step 3b-bcast) — re-emitting  
        RexNode abcCond = rexBuilder.makeCall(  
            List.of(),
        );
     * Per-strategy sub-toggle ({@code analytics.mpp.shuffle.aggregate.enabled=false}): the SAME  
            unwrap(agg.getInput(0)) instanceof OpenSearchExchangeReducer  
            context.getDistributionTraitDef(),
        );
     * input is an {@link OpenSearchExchangeReducer} (gathered), not a partitioned join.
            rexBuilder.makeInputRef(intType, 0),  
            SqlStdOperatorTable.EQUALS,
            "FINAL SUM arg rebased to the partial-state column",
            typeFactory.createSqlType(SqlTypeName.BIGINT),
            SqlStdOperatorTable.GREATER_THAN,
        PlannerContext context = buildMppContext(shardCounts, rowCounts);  
    /**
        int aCols = aScan.getRowType().getFieldCount();  
            rexBuilder.makeInputRef(intType, abCols)  
        );
            .findFirst()  
    private <T> List<T> findAll(RelNode root, Class<T> type) {  
            SqlStdOperatorTable.COUNT,
            workerAggs.get(0).getMode()  
            unwrap(innerJoin.getInput(0)) instanceof OpenSearchBroadcastExchange
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
            assertEquals(
        List<ShuffleEnrichment.WorkerLevel> levels = s.buildLevels();  
     * top join. {@link GeneralShuffleDAGRewriter} promotes that stage to a worker IN PLACE — so the PARTIAL
                    && unwrap(j.getInput(1)) instanceof OpenSearchShuffleExchange
            enforced,
        assertTrue(
            rexBuilder.makeInputRef(intType, aggCols)
            unwrap(topJoin.getInput(0)) instanceof OpenSearchShuffleExchange
        );
        assertEquals("top tier's two producers are the two sub-join workers", java.util.Set.of(l0, l1), topProducers);  
        // And the DAG still promotes two join worker tiers (the un-wireable agg-shuffle bug would have left
     *  "RexInputRef[N] has no matching FieldStorageInfo entry" at fragment conversion. */
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);  
        ShuffleEnrichment.WorkerLevel wl = levels.get(0);
        // a_idx (small build) ⋈ b_idx (large) at the bottom → broadcast-eligible; ⋈ c_idx (large) on top → shuffle.
        RelNode cbo = runPlanner(logical, context);  
     * Option B coverage the rewriters struggle with (2): a MIXED-KEY 3-way join — a⋈b on col0, then ⋈c
                fields.stream().anyMatch(f -> f.startsWith("size"))  
    }
        assertEquals(  
            .orElseThrow();
        RexNode abCond = rexBuilder.makeCall(
                "shuffle input must still carry the join/group key 'status' (got " + fields + ")",  
        // Without trimming the scan shuffles ship [status, size] (width 2) and the inter-tier join
            assertTrue("worker resolver is WorkerTargetResolver", level.worker().getTargetResolver() instanceof WorkerTargetResolver);
     * window frame can't run per-partition). Over a distributed join the pass MUST insert a gather (ER)
        org.opensearch.analytics.planner.rel.OpenSearchAggregate partial = aggOfMode(
            rexBuilder.makeInputRef(intType, 0),  
     * filter was gathered (step 3b), producing {@code Shuffle(Filter(ER(scan)))} → DAGBuilder cut a
            rexBuilder.makeInputRef(intType, aCols)
        PlannerContext context = buildMppContext(shardCounts, rowCounts);  
            false,
        assertTrue("the bottom join sits under the top join's left inter-tier shuffle", underTopLeftShuffle instanceof OpenSearchJoin);  
        // Deepest worker (level 0) consumes two leaf shard scans; top worker (level 1) consumes the deepest
            /* argList */ List.of(1, 2),
        assertNotNull("a decomposable agg over a distributed join must split (FINAL present)", finalAgg);
                + org.apache.calcite.plan.RelOptUtil.toString(enforced),
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
import org.opensearch.analytics.planner.rel.OpenSearchBroadcastScan;
 *       shuffle producers).</li>  
        Stage nestedBuild = builds.stream().filter(b -> b.getChildStages().isEmpty() == false).findFirst().orElseThrow();  
            SqlStdOperatorTable.COUNT,
     * left shuffle sits the bottom join (itself over two scan shuffles). Eliminating the same-key inter-tier
     */
                StageExecutionType.SHARD_FRAGMENT,
        assertTrue("top join right input shuffled", unwrap(top.getInput(1)) instanceof OpenSearchShuffleExchange);  
        }
    /**
    }
 * without the convert pipeline (the mock backend has no fragment convertor; conversion + actual  
            CLUSTER_DATA_NODES,  
        RelNode crossAb = LogicalJoin.create(aScan, bScan, List.of(), rexBuilder.makeLiteral(true), Set.of(), JoinRelType.INNER);
        for (ShuffleEnrichment.WorkerLevel level : levels) {
            rexBuilder.makeInputRef(intType, 0),  
            -1,
        RelNode bScan = stubScan(mockTable("b_idx", "status", "size"));
    public void testGeneralShuffle_selfJoinHasDistinctProducerStages() {
        );
            /* minRows */ 1L,
            org.opensearch.analytics.planner.rel.AggregateMode.FINAL,
        assertEquals(  
    /** {@code SUM(size) by status} over the 3-way join — SUM is its own reducer (PARTIAL=FINAL=SUM). */  
            "precondition: a broadcast nested under a shuffle producer must exist in the enforced DAG\n" + dag,  
     * (transparent, shard-local child) must RIDE on the shards — so the join's shuffle wraps
        );
        );
            List.of(),
        RelNode cbo = runPlanner(makeThreeWayJoin(context), context);
        boolean rightBroadcast = unwrap(join.getInput(1)) instanceof OpenSearchBroadcastExchange;
            CLUSTER_DATA_NODES,
    }
     * The top join thus sits over TWO shuffles (re-shuffled bottom-join output + shuffled c), and under its
        Map<String, Integer> shardCounts = Map.of("a_idx", 3);  
            true  
        ShuffleEnrichment.WorkerLevel top = levels.get(1);
        ToLongFunction<String> rowCountLookup = name -> rowCounts.getOrDefault(name, PlannerContext.UNKNOWN_ROW_COUNT);  
        List<T> out = new java.util.ArrayList<>();
        PlannerContext context = buildMppContext(shardCounts, rowCounts);  
            .filter(a -> a.getMode() == mode)
        );  
        // The JOIN cascade below is still distributed — only the aggregate split is suppressed.
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
        PlannerContext context = buildMppContext(shardCounts, rowCounts);  
        for (org.opensearch.analytics.planner.rel.OpenSearchRelNode osRel : findAll(
            assertTrue(  
            SqlStdOperatorTable.EQUALS,
    public void testColumnPruneNarrowsShuffleInputs() {
            context.getDistributionTraitDef(),  
        assertTrue("PARTIAL keeps the empty group set", partial.getGroupSet().isEmpty());
     */
            .count();
            org.opensearch.analytics.planner.rel.AggregateMode.FINAL
        return LogicalJoin.create(ab, cScan, List.of(), abcCond, Set.of(), topType);  
            top.worker().getFragment(),
            CLUSTER_DATA_NODES,
     * {@code status0}). Guards the trimmer wiring + index remapping (a join above a narrowed shuffle
            context.getCapabilityRegistry(),  
        GeneralShuffleDAGRewriter.Structure structure = enforceAndPromote(makeThreeWayJoinWithMidProject(context), context);
        long binaryTierJoins = joins.stream()
        RelNode leftScan = stubScan(mockTable(leftIdx, "status", "size"));
        RelNode aScan = stubScan(mockTable("a_idx", "status", "size"));
            CLUSTER_DATA_NODES,  
     * broadcast exchange is present AND at least one shuffle is present (the mixed shape).
            -1,
/*  
        assertTrue(
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
        );
     * shard scan, and {@code ShardScanInstructionHandler} fails casting the {@code ExchangeSinkContext} it is
import org.opensearch.analytics.exec.join.DistributionEnforcementPass;
        assertEquals(  
            assertEquals("each tier role SHUFFLE_WORKER", Stage.StageRole.SHUFFLE_WORKER, level.worker().getRole());  
        RelNode cScan = stubScan(mockTable("c_idx", "status", "size"));  
        long finals = aggs.stream().filter(a -> a.getMode() == org.opensearch.analytics.planner.rel.AggregateMode.FINAL).count();
            org.opensearch.analytics.planner.rel.OpenSearchAggregate.class
        // The coordinator root carries the FINAL aggregate (and gathers the top worker).  
        RelNode cbo = runPlanner(makeAggregateOverThreeWayJoin(context), context);
                + "which means RelFieldTrimmer wrongly fired and silently rewrote the cross-join branch "  
            List.of(),  
        RelNode ab = LogicalJoin.create(aScan, bScan, List.of(), abCond, Set.of(), JoinRelType.INNER);
        org.opensearch.analytics.planner.rel.OpenSearchAggregate finalAgg = aggOfMode(  
                    && unwrap(j.getInput(1)) instanceof OpenSearchShuffleExchange
    private RelNode makeWindowOverThreeWayJoin(PlannerContext context) {
        return LogicalJoin.create(leftScan, rightScan, List.of(), condition, Set.of(), JoinRelType.INNER);
    private org.opensearch.analytics.planner.rel.OpenSearchAggregate aggOfMode(
import org.apache.calcite.rel.RelNode;
            "window project must gather (ER) its distributed-join input before running the global window frame",
        return LogicalAggregate.create(join, List.of(), ImmutableBitSet.of(0), null, List.of(countCall));
     * join's output already satisfies the top join's hash requirement (shared key), the pass inserts a
        QueryDAG dag = DAGBuilder.build(enforced, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);  
        // GROUP BY col0, COUNT() — collapses A⋈B to one row per group key.
     * SUM is its own reducer: PARTIAL and FINAL are both SUM, but FINAL's arg must still be rebased to the
        for (int p = 0; p < partitionCount; p++) {
        OpenSearchJoin innerJoin = findAll(enforced2, OpenSearchJoin.class).get(0);
                j -> unwrap(j.getInput(0)) instanceof OpenSearchShuffleExchange
            "no Sort on the worker (per-partition sort + merge would be wrong for a global sort)",  
        RelNode logical = makeAggregateGroupedOnNonJoinKey(context);
import static org.mockito.Mockito.mock;
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
        assertEquals("two joins in the 3-way cascade", 2, joins.size());  
        org.apache.calcite.rex.RexBuilder rb = join.getCluster().getRexBuilder();  
        assertEquals(
    /**
        PlanAlternativeSelector.selectAll(dag, context.getCapabilityRegistry(), false);
                    && unwrap(join.getInput(1)) instanceof OpenSearchShuffleExchange
        int groupCount = finalAgg.getGroupSet().cardinality();
        );
        assertEquals("joins still distribute when only the agg sub-toggle is off", 2, binaryTierJoins);
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);  
     * delivers exactly two named inputs per worker (left/right buffer slices). So even though the bottom  
        assertEquals("exactly one FINAL aggregate (on the coordinator)", 1, finals);  
import org.apache.calcite.rex.RexNode;  
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3, "d_idx", 3);  
     *  cascade-probe pipeline (no convertAll — the mock backend has no fragment convertor). */
            SqlStdOperatorTable.EQUALS,
     */
     * rides on the top-join worker partitioned by the JOIN key (Variant A: a decomposable PARTIAL is  
    private GeneralShuffleDAGRewriter.Structure enforceAndPromote(RelNode logical, PlannerContext context) {  
     *     the production default (64 MiB).  
        }
        OpenSearchJoin join = findAll(enforced, OpenSearchJoin.class).get(0);  
            /* shuffleAggregateEnabled */ true
        );
import org.apache.calcite.rel.logical.LogicalAggregate;
            "general pass must preserve the CBO broadcast exchange (1):\n" + org.apache.calcite.plan.RelOptUtil.toString(enforced),
import java.util.Set;  
            rexBuilder.makeInputRef(intType, abCols + 1)  
        RelNode cd = LogicalJoin.create(cScan, dScan, List.of(), cdCond, Set.of(), JoinRelType.INNER);
        int aCols = aScan.getRowType().getFieldCount();  
            root,
                StageExecutionType.WORKER_FRAGMENT,
     * preserves BOTH: the bottom broadcast AND the top shuffle survive in one enforced DAG. Asserts a
     * RE-SHUFFLE exactly at the key change (the bottom join's output does NOT satisfy the top's  
            .findFirst()
        );  
     * correct under any partitioning; the FINAL gathers + re-merges). Asserts: exactly one PARTIAL + one
     * the coordinator over already-counted partial rows would count ROWS, not sum the partials, double/under-
        RelNode cbo = runPlanner(logical, context);
     * join with an explicit row-wise Project BETWEEN the two join levels — the real PPL plan shape, where
        for (ShuffleEnrichment.WorkerLevel level : levels) {
        if (type.isInstance(node)) {
        // by the precondition).  
     * <p>The nested shape is constructed directly rather than planned: this planner's CBO does not choose
                break;  
            false,
            top.worker().getFragment(),
        Map<String, Long> rowCounts = Map.of("small_idx", SMALL, "large_idx", LARGE);
 * compatible open source license.
     * {@link OpenSearchExchangeReducer} (gathered), and the cascade still formed below it.  
            SqlStdOperatorTable.EQUALS,
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
        }
/**
            SqlStdOperatorTable.EQUALS,
            .anyMatch(p -> p.getRowType().getFieldNames().stream().anyMatch(f -> f.contains("DUMMY")));  
        );  
        return LogicalProject.create(join, List.of(), List.of(rb.makeInputRef(join, 0), countOver), List.of("status", "cnt"));  
        assertFalse(
        int groupCount = finalAgg.getGroupSet().cardinality();  
        for (Map.Entry<String, Integer> entry : shardCounts.entrySet()) {
        );
     * Option B coverage the rewriters CANNOT do (1): a LEFT-outer 3-way join. The current cascade is
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
        int aCols = filtered.getRowType().getFieldCount();
    /**  
     * NOT be distributed. {@code Join(Aggregate(Join(A,B)), C)} — the top join's left input is an aggregate
     * cutting a hand-built plan exercises it exactly.
     * coordinator ReduceStageExecution as the shuffle producer, which never ships → worker timeout.
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
        );
        assertEquals("coordinator root carries exactly the FINAL aggregate", 1, rootAggs.size());
            "cnt"
        assertEquals("two joins in the 3-way cascade", 2, joins.size());
        PlanForker.forkAll(dag, context.getCapabilityRegistry());  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        assertEquals("top worker carries the PARTIAL", 1, workerAggs.size());
            aggOfMode(root.getFragment(), org.opensearch.analytics.planner.rel.AggregateMode.FINAL).getMode()  
            "worker aggregate is PARTIAL",
        )) {
        }  
        List<OpenSearchJoin> joins = findAll(enforced, OpenSearchJoin.class);  
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);
     * multi-way join ({@code A⋈B⋈C on col0 | stats count() by col1}). The aggregate's group key (col1)  
        RelNode logical = makeWindowOverThreeWayJoin(context);
        // A real CBO broadcast plan: Join(BroadcastExchange(a_small), b_large), SHARD-local.  
    /** Builds the BUSHY tree {@code (A⋈B on col0) ⋈ (C⋈D on col0) on col0} — both sides contain a join, so
        RelNode enforced = DistributionEnforcementPass.enforce(  
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);
        long binaryTierJoins = joins.stream()
    }  
            dag,
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
        RelNode cScan = stubScan(mockTable("c_idx", "status", "size"));
    }
        boolean filterUnderShuffle = findAll(enforced, OpenSearchShuffleExchange.class).stream()  
     * Empty-group aggregate over a large join must STILL distribute (the TPC-H q2/q11 scalar-subquery shape:  
            "coordinator carries the FINAL",
            org.opensearch.analytics.planner.rel.OpenSearchFilter.class
            enforced,  
     *  a real equi-join in one tree (the Codex Q4 shape). */
     * {@code COORDINATOR_REDUCE} that — once {@code UnifiedDispatch} strips the captured build child —
        List<ShuffleEnrichment.WorkerLevel> levels = structure.buildLevels();  
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
            "precondition: the nested build's fragment must scan a shard table:\n" + dag,
        // a_idx | where status > 5 | join on status = b.status b_idx  
        // Storage-completeness invariant for the empty-group FINAL (possibly wrapped in a cast Project).
import java.util.function.Function;
    private RelNode makeBushyFourWayJoin(PlannerContext context) {
            "precondition: CBO must pick BROADCAST for small×large (else the probe is vacuous)",  
                unwrap(join.getInput(0)) instanceof OpenSearchShuffleExchange
        );  
        );  
            collectStages(child, pred, out);
            )
        for (ShuffleEnrichment.WorkerLevel level : levels) {
                "each join level must sit over two shuffle inputs (binary tier)",  
        return GeneralShuffleDAGRewriter.rewriteStructure(
        return LogicalAggregate.create(join, List.of(), ImmutableBitSet.of(0), null, List.of(distinctMultiArg));
     * Regression (the q3 intermediate-Project worker-timeout, found at sf-scale on the cluster): a 3-way  
        );  
        RexNode countOver = rb.makeOver(
    public void testEnforcementPass_broadcastWinnerIsPreserved() {
    }
    }
     * bottom join.
            assertEquals(  
        // synthetic DUMMY literal Project (it prunes ALL of b's real columns since nothing references them
        return LogicalJoin.create(ab, cScan, List.of(), abcCond, Set.of(), JoinRelType.INNER);
     */
        // the bottom join (which was keyed on col0), because HASH(col0) does NOT satisfy HASH(col1).  
        ShuffleEnrichment.WorkerLevel top = levels.get(levels.size() - 1);  
        );
        PlannerContext context = buildMppContext(shardCounts, rowCounts);  
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);  
        org.opensearch.analytics.planner.rel.AggregateMode mode
        assertFalse(
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
        // The top join's left shuffle re-partitions the bottom join's output (same-key inter-tier shuffle);
        RexNode abcCond = rexBuilder.makeCall(  
        );
            SqlStdOperatorTable.SUM,
        // And under the left re-shuffle sits the bottom join (which itself shuffled its two scans).
import org.opensearch.analytics.planner.dag.PlanAlternativeSelector;  
        );
        RelNode aScan = stubScan(mockTable("a_idx", "status", "size"));
        assertTrue(  
        }  
    /** Builds {@code Project(status, COUNT() OVER ())} over a 3-way INNER join — a global-window-frame
    public void testGeneralShuffle_bushyTreePromotesThreeWorkerTiers() {
        PlannerContext context = buildMppContext(shardCounts, rowCounts);  
        RelNode enforced = DistributionEnforcementPass.enforce(
     * Codex-review MUST-FIX (correctness): {@code RelFieldTrimmer} rewrites the WHOLE plan, so the trim
     * distributes BOTH sub-joins and the top join with no special code → THREE binary worker tiers, the top
     *     that wants the SHUFFLE filtered-scan-producer path uses this so the broadcast-preserve branch
        Map<String, Long> rowCounts = Map.of("a_idx", 1_000L, "b_idx", 1_000L, "c_idx", 1_000L);
        AggregateCall countCall = AggregateCall.create(
            List.of(),
            .filter(  
     * sf=10 q3 BLOCKER regression: a filtered scan feeding a join must stay a SHARD producer, not become a  
    public void testEnforcementPass_aggOverJoinSumRebasedThroughSplit() {  
        );
     * The enforced agg-over-3-way DAG. The pass pre-split the aggregate into
    /** Builds {@code Aggregate(COLLECT(col1) by col0)} over a 3-way join — COLLECT is STATE_EXPANDING, so  
        );  
            ImmutableList.of(),
        return LogicalAggregate.create(join, List.of(), ImmutableBitSet.of(1), null, List.of(countCall));
    }  
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);  
        AggregateCall countCall = AggregateCall.create(
    }
        assertEquals("non-decomposable agg stays a single SINGLE aggregate (no PARTIAL/FINAL split)", 1, aggs.size());
        org.opensearch.analytics.planner.rel.OpenSearchAggregate finalAgg = aggOfMode(  
        RelNode cbo = runPlanner(makeSumByGroupOverThreeWayJoin(context), context);
            RexWindowBounds.UNBOUNDED_PRECEDING,
import org.apache.calcite.rel.type.RelDataType;
            deepest.leftProducer().getExecutionType()
     * to width 1 ({@code status}), the inter-tier join shuffle to the two join keys ({@code status},
        RelNode bScan = stubScan(mockTable("b_idx", "status", "size"));
        assertNotNull("SUM by g over a distributed join must split", finalAgg);
        );
    }
                level.worker().getExecutionType()  
    }  
        // GROUP BY col1 (size) — a DIFFERENT column than the join key col0.  
        );
        java.util.Set<Integer> topProducers = java.util.Set.of(top.leftProducer().getStageId(), top.rightProducer().getStageId());
    private RelNode makeSumByGroupOverThreeWayJoin(PlannerContext context) {
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
    private RelNode makeAggregateOverCrossThenEquiJoin(PlannerContext context) {
        // on it). This is the transparent op that must ride on the bottom worker.
        int aCols = aScan.getRowType().getFieldCount();  
        assertEquals(  
            "cnt"
     * so every shuffle's input must be narrowed to just the referenced column(s) — scan-level shuffles  
    /** Asserts every {@link org.opensearch.analytics.planner.rel.OpenSearchRelNode} in {@code root}'s tree  
    /**  
        );
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
    /**
        );  
        RelNode underLeftShuffle = unwrap(((OpenSearchShuffleExchange) unwrap(top.getInput(0))).getInput());
     * nested broadcast (it emits at most one broadcast per plan), so the shape is grafted by broadcasting a  
            (levelIndex, partitionCount) -> nodeIds(partitionCount)
        org.opensearch.analytics.planner.rel.OpenSearchAggregate partial = aggOfMode(
    }
        boolean hasShuffle = !findAll(enforced, OpenSearchShuffleExchange.class).isEmpty();
            "empty-group SUM over a large join must distribute (the join-output gather is what OOMs, not the "
        assertTrue(  
            /* minRows */ 1L,  
        return out;  
     * SAME-KEY inter-tier shuffle on the top join's left input — the bottom join becomes its own binary
import org.opensearch.cluster.metadata.MappingMetadata;
 *   <li>{@link DistributionEnforcementPass} co-partitions each join level (post-CBO), inserting the
     * and still distributes. Guards the "disable distributed aggregation, keep MPP joins" contract.
import org.opensearch.analytics.planner.dag.ShardTargetResolver;  
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);  
            rexBuilder.makeInputRef(intType, aCols)
            org.opensearch.analytics.planner.rel.OpenSearchAggregate.class
     * would leave its worker awaiting a producer that never fires (`ShuffleScanHandler timed out`). The
    }
        // did NOT cut a gather stage between the bottom join and its scans.  
    private RelNode makeAggregateOverThreeWayJoin(PlannerContext context) {
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE);
            enforced,
    /**  
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE, "d_idx", LARGE);
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
        RelNode cbo = runPlanner(makeSumByGroupOverThreeWayJoin(context), context);
                    .putList("index.composite.secondary_data_formats", "lucene")
    private static RelNode unwrap(RelNode node) {
            SqlStdOperatorTable.EQUALS,
        PlannerContext context = buildMppContext(shardCounts, rowCounts);  
            context.getDistributionTraitDef(),
            runPlanner(makeTwoWayJoin(context, "a_idx", "b_idx"), context),
    public void testEnforcementPass_threeWayJoinFormsCascade() {
        );
            .orElse(null);  
        boolean topConsumesDeepest = top.leftProducer().getStageId() == deepest.worker().getStageId()
        RelNode cbo = runPlanner(logical, context);
        assertEquals("bushy (A⋈B)⋈(C⋈D) → three binary worker tiers", 3, levels.size());  
            typeFactory.createSqlType(SqlTypeName.INTEGER),  
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);
import org.apache.calcite.rel.core.AggregateCall;  
     *     (which legitimately fires for a small filtered build) doesn't take the plan. {@code < 0} leaves
    public void testEnforcementPass_aggOverJoinEveryNodeReportsCompleteFieldStorage() {
        );
    /** Builds Join(Join(a,b) on a.0=b.0, c) on (join.0 = c.0), all INNER equi. */
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
        assertTrue(
            .filter(  
        RexNode abCond = rexBuilder.makeCall(
        assertNotNull("a decomposable agg over a distributed join must split (PARTIAL present)", partial);
            org.opensearch.analytics.planner.rel.AggregateMode.PARTIAL
    public void testEnforcementPass_aggSubToggleOffKeepsAggCoordCentricButJoinsDistribute() {  
        // top join keyed on col1 (size), a DIFFERENT column than the bottom (col0/status)
     * — the rule {@code cutReducer} and {@code cutShuffle} already use — NOT by {@code grandchildren.isEmpty()}.
    public void testDagCut_broadcastUnderShuffleProducerIsShardFragment() {
     * of 2 joins, and the FINAL gathers (ER above PARTIAL).
        RelNode cbo = runPlanner(makeTwoWayJoin(context, "small_idx", "large_idx"), context);
            findAll(top.worker().getFragment(), org.opensearch.analytics.planner.rel.OpenSearchSort.class).isEmpty()
            rexBuilder.makeInputRef(intType, abCols)
            "PARTIAL rides directly on the join worker — NO group-key ShuffleExchange between PARTIAL and join",
     */
        return org.apache.calcite.rel.logical.LogicalSort.create(agg, collation, null, null);  
    }
        ClusterState state = mock(ClusterState.class);
        assertFalse("the sorted agg-over-join must still distribute", levels.isEmpty());
            SqlStdOperatorTable.EQUALS,  
        for (int i = 0; i < CLUSTER_DATA_NODES; i++) {  
            CLUSTER_DATA_NODES,
    /** {@code stats sum(size)} (empty group) over the 3-way join — the q2/q11 scalar-subquery shape. SUM  
     * Codex round-3 BLOCKER (a SELF-JOIN must produce TWO distinct producer stages, not one shared id that  
            assertTrue("such a build must carry a ShardTargetResolver:\n" + dag, build.getTargetResolver() instanceof ShardTargetResolver);
        int abCols = ab.getRowType().getFieldCount();  
        );  
     */
            enforced,
        }  
     *  over an empty group infers NULLABLE (no rows → null), unlike the grouped case. */
        );
    /**  
        ShuffleEnrichment.WorkerLevel deepest = levels.get(0);
            List.of(1),  
import org.opensearch.analytics.exec.join.ShuffleEnrichment;  
            "FINAL re-merges COUNT via SUM (FinalAggCallBuilder swap — else cross-partition counts are wrong)",
            org.opensearch.analytics.planner.rel.AggregateMode.FINAL
package org.opensearch.analytics.planner;
     * one probe per level) and bails on a bushy tree; the general pass is a plain bottom-up visitor, so it
     * sf=10 bucket-A BLOCKER regression: a JOIN whose input is a GATHERED sub-stage (a decorrelated
import java.util.HashMap;  
                    && unwrap(j.getInput(1)) instanceof OpenSearchShuffleExchange
            1,
            .orElseThrow();
                    .build()  
        Function<IndexMetadata, FieldStorageResolver> fieldStorageFactory = FieldStorageResolver::new;
import org.apache.calcite.rel.core.JoinRelType;
     * re-merges via SUM over the partial-count state column. COUNT is NOT its own reducer — running COUNT on  
        RelNode cbo = runPlanner(logical, context);
        );
     * Ported from {@code DistributedAggOverJoinTests#…sortAboveAggregateReplayedOnCoordinator}.
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);  
        );
            enforced,  
            "filtered-scan join input must stay shard-local: Filter directly over the scan (no gather ER between)",
            rexBuilder.makeInputRef(intType, 0),
        );
    }  
        // cap, so CBO would otherwise pick BROADCAST (and the pass now legitimately preserves it). A tiny cap
            findAll(cbo, OpenSearchBroadcastExchange.class).isEmpty()
        return findAll(root, org.opensearch.analytics.planner.rel.OpenSearchAggregate.class).stream()  
            -1,
    private RelNode makeJoinOverAggregateOverJoin(PlannerContext context) {  
            .findFirst()  
            assertTrue(
            "self-join's two shuffle producers MUST be distinct stages (else one sink serves both sides → hang)",
     * A nested build BOTH scans a shard table and has a grandchild (its own captured build), so keying off
        RelNode join = LogicalJoin.create(crossAb, cScan, List.of(), abcCond, Set.of(), JoinRelType.INNER);
     *  Models PPL {@code a join b | stats count() by g | join c}. */
    private RelNode makeSortedSumByGroupOverThreeWayJoin(PlannerContext context) {  
            partial.getAggCallList().get(0).getAggregation().getName().toUpperCase(java.util.Locale.ROOT)
            rexBuilder.makeInputRef(intType, 0),  
            rexBuilder.makeInputRef(intType, aCols)
    }  
            (levelIndex, partitionCount) -> nodeIds(partitionCount)  
        assertEquals(
        // TWO worker tiers — NOT three (a spurious gather stage from the mid-Project would break promotion).  
        );
        );  
import org.opensearch.analytics.planner.rel.OpenSearchBroadcastExchange;
        AnalyticsSearchBackendPlugin shuffleAware = new ShuffleAwareDataFusionBackend(CLUSTER_DATA_NODES);
        assertEquals("two binary join tiers → two worker tiers", 2, levels.size());
     * {@link ShardTargetResolver} (it scans a shard table and ships its hash partition), NOT a
    private RelNode makeMixedKeyThreeWayJoin(PlannerContext context) {
        RelNode ab = LogicalJoin.create(aScan, bScan, List.of(), abCond, Set.of(), JoinRelType.INNER);  
            /* shuffleAggregateEnabled */ true  
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
     * Option B (general enforcement pass): a 3-way shared-key join scheduled by the general
        // CROSS JOIN(a, b): condition=[true] → empty equi-keys.
        assertNotNull("need a c_idx scan for the outer probe", cScan);  
            org.opensearch.analytics.planner.rel.OpenSearchAggregate.class
        PlannerContext context = buildMppContext(shardCounts, rowCounts);  
    /**  
        assertEquals(StageExecutionType.COORDINATOR_REDUCE, newRoot.getExecutionType());
        PlanForker.forkAll(dag, context.getCapabilityRegistry());
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);  
    }
        // The top tier (level 2, last bottom-up) consumes the two sub-join workers (levels 0 and 1) as BOTH
     * child, so its presence must not flip the producer to a reduce. Before the fix, such a producer became a
    /** Builds Join(Aggregate(Join(a,b) by col0, count), c) — an Aggregate between the join levels.
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
            ids.add("node-" + (p % CLUSTER_DATA_NODES));
    public void testGeneralShuffle_sortAboveAggOverJoinStaysOnCoordinator() {  
        GeneralShuffleDAGRewriter.Structure structure = GeneralShuffleDAGRewriter.rewriteStructure(  
     * over a distributed multi-way join. A non-decomposable aggregate is split-ineligible
            context.getDistributionTraitDef(),
        RelNode agg = LogicalAggregate.create(ab, List.of(), ImmutableBitSet.of(0), null, List.of(countCall));  
     */
            SqlStdOperatorTable.EQUALS,
        RelNode aScan = stubScan(mockTable("a_idx", "status", "size"));
            SqlStdOperatorTable.EQUALS,
    /** Recursively collects stages whose predicate holds (test helper for DAG-shape assertions). */
            rexBuilder.makeInputRef(intType, 0),
            assertEquals("each tier is a WORKER_FRAGMENT", StageExecutionType.WORKER_FRAGMENT, level.worker().getExecutionType());
        }
 */
        );  
        for (Stage build : builds) {
                "no worker producer may be a COORDINATOR_REDUCE (that would never ship a shuffle → timeout)",  
    /** a⋈b on col0, then (ab)⋈c on col1 — the cascade re-keys at the top level. */  
        QueryDAG dag = DAGBuilder.build(enforced, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);  
     */
    }
    /**  
    }
            true,  
        if (maxBroadcastBytes >= 0) {
    public void testEnforcementPass_mixedKeyCascadeReshufflesAtKeyChange() {
     * Shape assertions miss this — only a per-node {@code getOutputFieldStorage().size() == fieldCount} check
        OpenSearchProject windowProject = findAll(enforced, OpenSearchProject.class).stream()  
            "FINAL re-merges SUM via SUM",
        PlanAlternativeSelector.selectAll(dag, context.getCapabilityRegistry(), false);
        RelNode agg = makeSumByGroupOverThreeWayJoin(context);
 */  
            (lvl, pc) -> nodeIds(pc)
        // preserved a broadcast under a shuffle; if CBO declined broadcast this test is vacuous, guarded
     * over a join, which the pass gathers to COORDINATOR+SINGLETON (a ReduceStageExecution at DAG time). A
    public void testEnforcementPass_aggOverThreeWayJoinSplitsAndCascades() {  
     * differs from the join partitioning (col0). The pass must NOT insert a group-key re-shuffle (that
        // The plan contains a CROSS JOIN, so the trim must be SKIPPED. The tell-tale of the buggy
import org.apache.calcite.sql.type.SqlTypeName;  
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        );
    }
        RexNode filterCond = rexBuilder.makeCall(
                    .put("index.composite.primary_data_format", "parquet")
        );
        RelNode cbo = runPlanner(makeThreeWayJoinTopType(context, JoinRelType.LEFT), context);
import org.opensearch.analytics.planner.dag.DAGBuilder;
     * DAG-cut regression for broadcast-under-shuffle (the q3/q8/q9 fix): when a shuffle producer's fragment
        );
        RexNode cond = rexBuilder.makeCall(  
        // The top join (keyed on col1) must have BOTH inputs shuffled — its left input is a re-shuffle of
        // agg-over-3-way-join qualifies. Validates the trimmer wiring + index remapping (a join above a
     */
        org.opensearch.analytics.planner.rel.OpenSearchAggregate partial = aggOfMode(
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.analytics.planner.dag.StageExecutionType;
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);  
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
    private static void collectStages(Stage stage, java.util.function.Predicate<Stage> pred, List<Stage> out) {  
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
    }
        RelNode aScan = stubScan(mockTable("a_idx", "status", "size"));
    private void assertStorageComplete(String where, RelNode root) {  
 * row-count parity are exercised on the live cluster).
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
     * entry" crash): every {@link org.opensearch.analytics.planner.rel.OpenSearchRelNode} in the enforced
 * Validates the structure (worker count, execution types, producer wiring, coordinator gather)
import java.util.function.ToLongFunction;
        );
     */  
            rexBuilder.makeInputRef(intType, 0),  
                where + ": " + ((RelNode) osRel).getRelTypeName() + " must report FieldStorageInfo for every output column",
        RexNode cdCond = rexBuilder.makeCall(
        assertEquals(  
        // the PARTIAL stage consuming an un-promoted shuffle).
        // The PARTIAL must sit DIRECTLY over the join (no group-key re-shuffle between them) — Variant A.
     * must still resolve its keys).  
        }
        // The top worker consumes the bottom worker as one of its two producers (the inter-tier shuffle), not
        // The top worker fragment carries the PARTIAL aggregate above its join.
        // fix it was the only stage that came back COORDINATOR_REDUCE.
    private RelNode makeThreeWayJoinWithMidProject(PlannerContext context) {  
    public void testGeneralShuffle_aggOverJoinKeepsPartialOnWorker() {
            CLUSTER_DATA_NODES,
        }  
        RelNode cbo = runPlanner(logical, context);
        RelNode aScan = stubScan(mockTable("a_idx", "status", "size"));  
    private RelNode makeThreeWayJoinTopType(PlannerContext context, JoinRelType topType) {  
        RelNode r = stubScan(mockTable("a_idx", "status", "size"));
     */
     * Option B: agg over a 3-way cascade (q5/q10 class). The enforcement pass must split the SINGLE
        RexNode abcCond = rexBuilder.makeCall(  
    @SuppressWarnings("unchecked")  
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
            rexBuilder.makeInputRef(intType, 1),
        // The root stays a coordinator reduce gathering the top worker's SINGLETON output.
     */
            "PARTIAL keeps COUNT",
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
            /* shuffleAggregateEnabled */ true
            .orElseThrow(() -> new AssertionError("no join-over-aggregate found"));
                || unwrap(innerJoin.getInput(1)) instanceof OpenSearchBroadcastExchange  
                fields.stream().anyMatch(f -> f.startsWith("status"))
     * place (each {@code SHUFFLE_WORKER} + {@code WORKER_FRAGMENT}). The deepest worker consumes two leaf  
            );  
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
            "general pass must NOT introduce a shuffle for a broadcast-winner:\n" + org.apache.calcite.plan.RelOptUtil.toString(enforced),  
        RexNode abCond = rexBuilder.makeCall(  
            partial
     * avoid an un-runnable shape), the unified dispatcher now COMPOSES broadcast-under-shuffle, so the pass  
        );  
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
        long partials = aggs.stream().filter(a -> a.getMode() == org.opensearch.analytics.planner.rel.AggregateMode.PARTIAL).count();  
            enforced,
            org.opensearch.analytics.planner.rel.OpenSearchAggregate.class  
        // shuffle ships [status, size, status0, size0] (width 4). With trimming, the dead `size`
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
        int aCols = aScan.getRowType().getFieldCount();
            )  
                j -> unwrap(j.getInput(0)) instanceof OpenSearchShuffleExchange  
        );  
            (int) finalAgg.getAggCallList().get(0).getArgList().get(0)  
            SqlStdOperatorTable.EQUALS,
        RelNode ab = LogicalJoin.create(aScan, bScan, List.of(), abCond, Set.of(), JoinRelType.INNER);  
            /* shuffleAggregateEnabled */ true
            new org.apache.calcite.rel.RelFieldCollation(1, org.apache.calcite.rel.RelFieldCollation.Direction.DESCENDING)
        assertFalse(  
            enforced,  
     * counting across partitions. The split rule pre-decomposes via {@code FinalAggCallBuilder.buildFinalCalls},
    /** Two-way INNER equi-join on col0 over two scans (mirrors JoinStrategyCBOSelectionTests.makeJoin). */  
        assertEquals("nested broadcast must cut TWO BROADCAST_BUILD stages (outer build + its own build):\n" + dag, 2, builds.size());
        RelNode logical = makeJoinOverAggregateOverJoin(context); // Join(Aggregate(Join(A,B)), C)
        return LogicalJoin.create(ab, cScan, List.of(), abcCond, Set.of(), JoinRelType.INNER);
            RexWindowBounds.UNBOUNDED_FOLLOWING,
        for (OpenSearchTableScan scan : findAll(enforced3, OpenSearchTableScan.class)) {  
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
     * {@code FINAL(ER(PARTIAL(...)))}; DAGBuilder cut the ER, so the PARTIAL sits in the SAME stage as the  
            unwrap(filter.getInput(0)) instanceof org.opensearch.analytics.planner.rel.OpenSearchTableScan  
        OpenSearchTableScan cScan = null;
        int l1 = levels.get(1).worker().getStageId();
            rexBuilder.makeInputRef(intType, 0),  
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
     * aggregate coordinator-centric. Asserts: exactly one SINGLE aggregate (no PARTIAL/FINAL split), and its  
        ShuffleEnrichment.WorkerLevel top = levels.get(1);  
                + "one-row aggregate output)",  
            String indexName = entry.getKey();  
            SqlStdOperatorTable.COUNT,
        );
    public void testEnforcementPass_aggOverJoinDecomposesCountToSumOnFinal() {  
import org.opensearch.analytics.planner.dag.WorkerTargetResolver;  
        RelNode aScan = stubScan(mockTable("a_idx", "status", "size"));
        );
                    + dag,  
        // A c_idx shard scan to serve as the outer probe.  
        long singles = aggs.stream().filter(a -> a.getMode() == org.opensearch.analytics.planner.rel.AggregateMode.SINGLE).count();
            /* shuffleAggregateEnabled */ false
     * beside a real join) must DISABLE the trim, because the trimmer would silently mis-rewrite the  
            org.opensearch.analytics.planner.rel.AggregateMode.PARTIAL
                build.getExecutionType()
        );
                storage
            unwrap(partial.getInput(0)) instanceof OpenSearchJoin
     */
     * coord-centric choice for small joins. Guards against the pass force-distributing every join.  
        );
            typeFactory.createSqlType(SqlTypeName.BIGINT),
            wl.leftProducer().getStageId() != wl.rightProducer().getStageId()
    }
        }  
        RelNode cScan = stubScan(mockTable("c_idx", "status", "size"));  
                "broadcast-under-shuffle producer must be a SHARD_FRAGMENT (scans shards, ships its partition), "  
        RelNode join = makeThreeWayJoin(context);
            /* minRows */ 1L,
    }  
            SqlStdOperatorTable.COUNT,
                && !RelNodeUtils.findNodes(f, OpenSearchBroadcastScan.class).isEmpty()
    private PlannerContext buildMppContext(Map<String, Integer> shardCounts, Map<String, Long> rowCounts) {  
            true,
        AggregateCall countCall = AggregateCall.create(
     *
            );
            SqlStdOperatorTable.EQUALS,
        RelNode aScan = stubScan(mockTable("a_idx", "status", "size"));
        RelNode cbo = runPlanner(logical, context);  
        // narrowed shuffle must still resolve its keys).
        // a coordinator-reduce stage.
            "total"
            context.getDistributionTraitDef(),
        for (OpenSearchJoin join : joins) {
     * The enforced 3-way join DAG, promoted by {@link GeneralShuffleDAGRewriter}. Binary-tier lowering
            enforced,  
        int aggCols = agg.getRowType().getFieldCount();  
        assertEquals("sub-toggle off: the SINGLE aggregate stays whole on the coordinator", 1, singles);
        for (Stage producer : broadcastProducers) {
        // The TOP join (the one whose left input is the aggregate) must have NEITHER input shuffled — it
        RelNode cbo = runPlanner(makeThreeWayJoin(context), context);
     * Storage-completeness regression (the sf=10 q5/q10 "RexInputRef[N] has no matching FieldStorageInfo
        );
        List<ShuffleEnrichment.WorkerLevel> levels = structure.buildLevels();
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
        @Override
     * {@code Join(OpenSearchBroadcastExchange(build), probe)} rather than re-driving the join through the
import org.opensearch.cluster.node.DiscoveryNodes;
        // columns are gone: scan shuffles carry only the referenced column, the join shuffle only  
        RelNode logical = LogicalJoin.create(l, r, List.of(), cond, Set.of(), JoinRelType.INNER);
        AggregateCall sumCall = AggregateCall.create(
            assertTrue(
            rexBuilder.makeInputRef(intType, 0),
        RelNode ab = LogicalJoin.create(aScan, bScan, List.of(), abCond, Set.of(), JoinRelType.INNER);  
            ab.getRowType().getFieldNames()  
    public void testEnforcementPass_filteredScanJoinInputStaysShardProducer() {
                "a broadcast build whose fragment scans a shard table must be a SHARD_FRAGMENT, not a "
            );
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
            );
            SqlStdOperatorTable.COUNT,  
        assertEquals("top worker fragment carries exactly the PARTIAL aggregate", 1, workerAggs.size());
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);  
        RelNode enforced = DistributionEnforcementPass.enforce(
    private static ClusterState mockClusterStateWithDataNodes(Map<String, Integer> shardCounts) {
            rexBuilder.makeInputRef(intType, 0),
            "cnt"  
     */
        PlannerContext context = buildMppContext(shardCounts, rowCounts);  
        // Column-prune (PlannerImpl.trimUnusedFields) is ON by default and scoped to join plans — this  
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);  
            .filter(p -> !findAll(p, OpenSearchJoin.class).isEmpty()) // the project above the join
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);  
    public void testColumnPruneSkipsPlanWithCrossJoin() {  
 *
            .anyMatch(sh -> !findAll(sh, org.opensearch.analytics.planner.rel.OpenSearchFilter.class).isEmpty());
        );
        );  
 * this file be licensed under the Apache-2.0 license or a
     */  
        );
    private RelNode makeThreeWayJoin(PlannerContext context) {  
        List<OpenSearchJoin> joins = findAll(enforced, OpenSearchJoin.class);
        );  
            SqlStdOperatorTable.EQUALS,
        );
        );  
            org.opensearch.analytics.planner.rel.AggregateMode.FINAL,
    }
     * before the window — the bug was that the SINGLETON requirement went through the satisfies()-gated  
     * {@link #testColumnPruneNarrowsShuffleInputs} is the positive control (all-equi → trims).
            false,  
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);  
                j -> unwrap(j.getInput(0)) instanceof OpenSearchShuffleExchange
                    + "not a COORDINATOR_REDUCE:\n"
        return ids;
            "the global Sort must stay on the coordinator (above FINAL)",  
    private static final long LARGE = 10_000_000L;  
            /* shuffleAggregateEnabled */ true
import org.opensearch.analytics.planner.rel.OpenSearchProject;
    /**
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);  
     * The window-bearing {@code OpenSearchProject} requires {@code COORDINATOR+SINGLETON} input (a global
            SqlStdOperatorTable.EQUALS,
            dataNodes.put("node-" + i, mock(DiscoveryNode.class));
        assertEquals("PARTIAL SUM", "SUM", partial.getAggCallList().get(0).getAggregation().getName().toUpperCase(java.util.Locale.ROOT));  
        assertEquals("both join levels are binary tiers (each over two shuffles)", 2, binaryTierJoins);
            context.getDistributionTraitDef(),  
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);  
     * agg-over-3-way shape as {@link #testEnforcementPass_aggOverThreeWayJoinSplitsAndCascades}, but with
        // Binary-tier lowering: BOTH joins sit over two ShuffleExchange inputs (no N-ary collapse).
        long partials = aggs.stream().filter(a -> a.getMode() == org.opensearch.analytics.planner.rel.AggregateMode.PARTIAL).count();  
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
            .count();
        List<OpenSearchJoin> joins = findAll(enforced, OpenSearchJoin.class);  
            rexBuilder.makeInputRef(intType, l.getRowType().getFieldCount())  
    // ── GeneralShuffleDAGRewriter: in-place worker promotion of the enforced DAG ──────────────
            rexBuilder.makeInputRef(intType, aCols)  
            return parallelism;
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
        int abCols = ab.getRowType().getFieldCount();
        RelNode aScan = stubScan(mockTable("a_idx", "status", "size"));
            org.opensearch.analytics.planner.rel.AggregateMode.FINAL
        RelNode cbo = runPlanner(makeAggregateOverThreeWayJoin(context), context);
     * (The inner A⋈B join is shard-local on both sides, so it may still distribute — that's fine.)  
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);
        collect(unwrap(root), type, out);
            join,  
            context.getDistributionTraitDef(),  
            broadcastProducers.isEmpty()
        ShuffleAwareDataFusionBackend(int parallelism) {
            "FINAL arg rebased to the partial-state column (groupCount + 0), not the original input ordinal",
        RelNode join = makeThreeWayJoin(context); // joins on col0 (status)
        assertTrue(
        // suppresses the broadcast alternative so CBO shuffles — the producer path this test guards.  
        List<OpenSearchShuffleExchange> shuffles = findAll(enforced, OpenSearchShuffleExchange.class);
    /**  
        assertStorageComplete("enforced agg-over-join plan", enforced);  
        PlannerContext context = buildMppContext(shardCounts, rowCounts, /* maxBroadcastBytes */ 1L);
        when(state.nodes()).thenReturn(nodes);
     * join input is the broadcast (build) while the other stays bare (shard-local probe).  
        // The OUTER build is the nested one: it scans a shard table AND has its own build child. Before the
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);
            unwrap(windowProject.getInput(0)) instanceof OpenSearchExchangeReducer  
        );
        assertTrue("top join left input re-shuffled at the key change", unwrap(top.getInput(0)) instanceof OpenSearchShuffleExchange);
    }
        RelNode cbo = runPlanner(makeMixedKeyThreeWayJoin(context), context);  
            "cnt"
 * <ol>
            when(indexMetadata.getSettings()).thenReturn(
        assertTrue("bottom join sits under the top's left re-shuffle", underLeftShuffle instanceof OpenSearchJoin);  
        assertEquals("one FINAL aggregate", 1, finals);  
        // through condition=[true]) — a silently-wrong plan that drops b's rows. With the correct allMatch
        assertTrue(  
    /** Like makeThreeWayJoin but the TOP join uses the given type (INNER/LEFT/…). */
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);  
        int l0 = levels.get(0).worker().getStageId();  
     * INNER-only; the enforcement pass co-partitions outer joins too (null-fill is partition-local for a  
        QueryDAG dag = DAGBuilder.build(outerJoin, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
    }
            assertTrue(
        );
        assertEquals(
        QueryDAG dag = DAGBuilder.build(enforced, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
     * and two worker tiers still promote.  
        boolean hasBroadcast = !findAll(enforced, OpenSearchBroadcastExchange.class).isEmpty();  
            /* distinct */ true,  
        collectStages(dag.rootStage(), s -> s.getRole() == Stage.StageRole.BROADCAST_BUILD, builds);
    }
            rootAggs.get(0).getMode()
        assertTrue("top worker consumes the bottom worker directly (no gather between tiers)", topConsumesDeepest);  
            rexBuilder.makeInputRef(intType, abCols)
        assertEquals("two joins", 2, joins.size());
            (org.apache.calcite.sql.SqlAggFunction) SqlStdOperatorTable.COUNT,  
        // gathers and runs coord-centric. Identify it as the join that contains the OpenSearchAggregate.  
            );  
            List.of(1),
    /**
            )  
            "top join's right input must NOT be shuffled either (join stays coord-centric when a producer can't ship)",
     *  COUNT(DISTINCT) is NOT a valid example — it's rewritten to the decomposable APPROX_COUNT_DISTINCT.) */  
     * transport is safe for {@code a ⋈ a on k}: DAGBuilder cuts each shuffle input into its OWN stage (one
            hasBroadcast && hasShuffle
     * Option B size floor: a 3-way join whose scans are all BELOW the row floor must stay
        );
            List.of(),
        List<String> ids = new java.util.ArrayList<>(partitionCount);  
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;  
        RelNode enforced3 = DistributionEnforcementPass.enforce(
import org.opensearch.analytics.planner.dag.PlanForker;
        List<org.opensearch.analytics.planner.rel.OpenSearchAggregate> workerAggs = findAll(
    }
     * surface. So the pass must split: PARTIAL on the worker (per-partition), FINAL on the coordinator. Ported  
            1L,
     * DAG-cut regression for NESTED BROADCAST: a broadcast whose BUILD side is itself a broadcast probe.
                producer.getTargetResolver() instanceof ShardTargetResolver
        // And the filter is under a ShuffleExchange (the join shuffles it from the shards).
     * each join's output is renamed by a Project. The intermediate Project must RIDE on the bottom join's
        assertTrue("exactly one join input is a broadcast exchange (the build side)", leftBroadcast ^ rightBroadcast);  
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);  
        RelNode join = makeThreeWayJoin(context);
     * Codex re-review BLOCKER regression: a NON-decomposable SINGLE aggregate ({@code COUNT(DISTINCT col1)})
            SqlStdOperatorTable.EQUALS,
            false,  
     * shippable-producer gate (step 3d) must keep the TOP join coord-centric: its inputs are NOT shuffled.
     *     value suppresses the broadcast alternative (build can't fit the cap) so CBO must shuffle; a test  
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
     * {@code stats sum(x)} with NO {@code by}). The aggregate OUTPUT is one row, but the JOIN OUTPUT feeding
            typeFactory.createSqlType(SqlTypeName.BIGINT),  
            IndexMetadata indexMetadata = mock(IndexMetadata.class);
        );
        }  
        // The cascade still distributes BELOW the gather (the join itself is two binary tiers).
            || top.rightProducer().getStageId() == deepest.worker().getStageId();  
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
        RelNode enforced = DistributionEnforcementPass.enforce(
        ClusterState state = mockClusterStateWithDataNodes(shardCounts);  
        assertEquals("intermediate Project must not insert a gather tier → still two worker tiers", 2, levels.size());
            join,
        // Force the SHUFFLE path: the `status > 5` filter shrinks the build side under the 64 MiB broadcast
        GeneralShuffleDAGRewriter.Structure s = GeneralShuffleDAGRewriter.rewriteStructure(
        assertTrue("top worker consumes the deepest worker as one of its producers", topConsumesDeepest);
        assertEquals("both join levels are distributed (outer join co-partitions too)", 2, shuffleJoins);
    }  
        assertEquals("two join worker tiers promoted", 2, structure.buildLevels().size());
        );
        RelNode bScan = stubScan(mockTable("b_idx", "status", "size"));
        );
    }  
            rexBuilder.makeInputRef(intType, leftCols)  
            StageExecutionType.SHARD_FRAGMENT,
        assertEquals("sub-toggle off: NO PARTIAL aggregate (no split)", 0, partials);  
        assertNotNull(
            dag,
        // GRAFT: broadcast the broadcast-probe join as the BUILD of an outer join over c_idx.
            rexBuilder.makeInputRef(intType, 0),
        );
 *       tier in place; {@link ShuffleEnrichment.WorkerLevel} describes each tier (worker stage + its two
        assertEquals(  
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
            "the root aggregate is the FINAL",  
        RexNode cond = rexBuilder.makeCall(  
    }
        List<ShuffleEnrichment.WorkerLevel> levels = structure.buildLevels();
            false
     * <p><b>Binary-tier lowering.</b> A join is a worker-tier boundary: the hash-shuffle transport
     */
     * the cascade below must still form. Asserts: exactly one PARTIAL + one FINAL aggregate, a cascade  
     * @param maxBroadcastBytes when {@code >= 0}, sets {@code analytics.mpp.broadcast.max_bytes} — a tiny
        List<OpenSearchJoin> joins = findAll(enforced, OpenSearchJoin.class);  
            int cols = ((RelNode) osRel).getRowType().getFieldCount();
import com.google.common.collect.ImmutableList;
    /**
     * which {@code DistributionEnforcementPass.splitAggregate} reuses; this asserts the decomposition survives  
            rexBuilder.makeInputRef(intType, 0),
        RelNode bScan = stubScan(mockTable("b_idx", "status", "size"));
    }  
        RelNode root,  
            CLUSTER_DATA_NODES,  
            "bottom worker left producer is a shard fragment (no gather inserted by the mid-Project)",  
            false,  
 * {@code Join(Join(A,B), C)}), scheduled by the general distributed scheduler:  
            rexBuilder.makeInputRef(intType, leftCols)  
            .findFirst()
            cbo,  
     * grandchild count alone leaves it with no {@link ShardTargetResolver} and a sink provider instead:  
        // broadcast-probe-that-is-also-a-shuffle-producer. There must be at least one (the enforced plan
            .filter(a -> a.getMode() == org.opensearch.analytics.planner.rel.AggregateMode.PARTIAL)  
    }  
        Stage root = structure.dag().rootStage();
import org.opensearch.cluster.node.DiscoveryNode;
        );
        List<Stage> builds = new java.util.ArrayList<>();  
import org.apache.calcite.util.ImmutableBitSet;
    }
            dag,
     *  reports one {@code FieldStorageInfo} per output column — the invariant a short list violates with
    private RelNode makeAggregateGroupedOnNonJoinKey(PlannerContext context) {
import org.opensearch.cluster.metadata.IndexMetadata;
            return f != null
     * leaf returning {@code List.of()} that truncated the storage union, throwing at fragment conversion.
            CLUSTER_DATA_NODES,
     * BROADCAST coverage (E1): when CBO picks BROADCAST for a small×large INNER equi-join, the merged
            rexBuilder.makeInputRef(intType, 0),
     * shared key. The legacy {@code deepestInnerEquiJoin} walk assumes a left-deep chain (one bottom join,  
        Stage newRoot = structure.dag().rootStage();  
        PlannerContext context = buildMppContext(shardCounts, rowCounts);  
     * worker consuming the two sub-join workers as its producers.  
     * reduce stage emits to its parent sink and CANNOT ship a hash shuffle, so distributing the top join  
        // Find the stage whose fragment contains an OpenSearchBroadcastScan AND a shard TableScan — the  
        assertFalse("the agg-over-3-way-join must still distribute (shuffles present)", shuffles.isEmpty());  
            groupCount,
                    + "COORDINATOR_REDUCE — even when it has its own build grandchild (nested broadcast):\n"
     */
        PlannerContext context = buildMppContext(shardCounts, rowCounts);
        Map<String, DiscoveryNode> dataNodes = new HashMap<>();
     * aggregate into PARTIAL (over the distributed cascade) + FINAL (over a coordinator gather), and
        int abCols = ab.getRowType().getFieldCount();
            when(indexMetadata.getNumberOfShards()).thenReturn(shardCount);
        RelNode rightScan = stubScan(mockTable(rightIdx, "status", "size"));  
        RelNode cbo = runPlanner(logical, context);
    /** Enforce + cut + fork/select + promote, returning the GeneralShuffleDAGRewriter structure. Mirrors the
     * {@code size} columns SURVIVE into the plan (proving the trim declined). The sibling  
        assertTrue("self-join over two large scans distributes", GeneralShuffleDAGRewriter.hasDistributedJoin(dag));  
     * shuffle algebra. Asserts exactly one broadcast exchange survives, NO shuffle is introduced, and one
    private PlannerContext buildMppContext(Map<String, Integer> shardCounts, Map<String, Long> rowCounts, long maxBroadcastBytes) {
    }
                    && level.rightProducer().getExecutionType() != StageExecutionType.COORDINATOR_REDUCE
        return LogicalAggregate.create(join, List.of(), ImmutableBitSet.of(), null, List.of(sumCall));
        assertEquals("sub-toggle off: NO FINAL aggregate (no split)", 0, finals);
     * on col1. The bottom join's output is HASH(col0); the top join needs HASH(col1) → the pass inserts a
    private static List<String> nodeIds(int partitionCount) {
    /** {@code SUM(size) by status | sort total desc} over the 3-way join — models q5's
        }
        }
        RelNode outerBuild = context.getDistributionTraitDef().buildBroadcastExchange(innerJoin, CLUSTER_DATA_NODES);  
            StageExecutionType.SHARD_FRAGMENT,
    /** First {@link org.opensearch.analytics.planner.rel.OpenSearchAggregate} of the given mode in  
    /**
        int aCols = aScan.getRowType().getFieldCount();
        // its two keys. Assert NO shuffle carries an unreferenced `size`/`size0` column.
    /**
     * from {@code DistributedAggOverJoinTests#testEmptyGroupAggregateOverJoin_distributes}.
        assertFalse(
            );  
        RelNode ab = LogicalJoin.create(aScan, bScan, List.of(), abCond, Set.of(), JoinRelType.INNER);
     * into the enforced plan.
    }
        ShuffleEnrichment.WorkerLevel top = levels.get(levels.size() - 1);  
        assertNotNull("SUM by g over a distributed join must split", partial);
     *  partials additively), so the pass must gather, not split/ride-per-partition. (Single-arg
        assertEquals("both join levels are binary tiers below the gather", 2, binaryTiers);
            int storage = osRel.getOutputFieldStorage().size();  
            enforced,  
        );
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);  
        );
        );
     * would be a non-join shuffle edge GeneralShuffleDAGRewriter can't wire → hang) — instead the PARTIAL
     * single SINGLE aggregate on the coordinator over a gather — while the JOIN cascade below is unaffected  
            join,
    private RelNode makeEmptyGroupSumOverThreeWayJoin(PlannerContext context) {
        GeneralShuffleDAGRewriter.Structure structure = enforceAndPromote(makeAggregateOverThreeWayJoin(context), context);
            SqlStdOperatorTable.EQUALS,
        // gate the trim declines: no DUMMY Project, and the top equi-join keeps its wide-input index.  
     *  must NOT be blocked by it. */
            rexBuilder.makeInputRef(intType, 0),
        CapabilityRegistry registry = new CapabilityRegistry(List.of(shuffleAware, LUCENE), fieldStorageFactory);  
        OpenSearchJoin topJoin = findAll(enforced, OpenSearchJoin.class).stream()
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE, "c_idx", LARGE);
    }  
            context.getCapabilityRegistry(),
     * shuffle for genuinely co-partitioned tiers is a future N-ary-transport optimization.  
            deepest.leftProducer().getExecutionType()  
        boolean leftBroadcast = unwrap(join.getInput(0)) instanceof OpenSearchBroadcastExchange;
    private RelNode makeTwoWayJoin(PlannerContext context, String leftIdx, String rightIdx) {
     * it is huge — gathering the whole join to the coordinator before the SINGLE aggregate runs is the OOM
            cbo,
            "the worker aggregate is the PARTIAL",
    public void testEnforcementPass_joinOverGatheredAggregateStaysCoordCentric() {
     * Aggregate-decomposition regression (ported from the deleted {@code DistributedAggOverJoinTests}): a
        // EQUI-JOIN((a⨯b), c) on col0 == c.col0.
        assertEquals(
        assertEquals("one PARTIAL aggregate", 1, partials);
            findAll(enforced, OpenSearchShuffleExchange.class).isEmpty()
    public void testEnforcementPass_smallJoinBelowFloorStaysCoordCentric() {
            unwrap(topJoin.getInput(1)) instanceof OpenSearchShuffleExchange
            false,
                j -> unwrap(j.getInput(0)) instanceof OpenSearchShuffleExchange  
     * requirement). Asserts: the top join's left input is a ShuffleExchange (re-shuffled), not the bare
        assertTrue("enforced DAG has a distributed join to promote", GeneralShuffleDAGRewriter.hasDistributedJoin(dag));  
        assertEquals("the aggregate is SINGLE (not split)", org.opensearch.analytics.planner.rel.AggregateMode.SINGLE, agg.getMode());  
            CLUSTER_DATA_NODES,
        QueryDAG dag = DAGBuilder.build(enforced, context.getCapabilityRegistry(), mockClusterService(), TEST_RESOLVER);
    }
            false,
                cScan = scan;
            .orElseThrow(() -> new AssertionError("no window project found"));  
            /* shuffleAggregateEnabled */ true
        RelNode cScan = stubScan(mockTable("c_idx", "status", "size"));  
        );
        RelNode bScan = stubScan(mockTable("b_idx", "status", "size"));
            .findFirst()
        Map<String, Long> rowCounts = Map.of("a_idx", SMALL, "b_idx", LARGE, "c_idx", LARGE);
    /** Builds Aggregate(Join(Join(a,b), c) by col0, count) — an Aggregate ABOVE the top join (the
            -1,
        RexNode condition = rexBuilder.makeCall(  
            (int) finalAgg.getAggCallList().get(0).getArgList().get(0)
        assertTrue("the filtered scan is shuffled (join hash-ships it from the shards)", filterUnderShuffle);
            org.opensearch.analytics.planner.rel.AggregateMode.PARTIAL
     * id per shuffle-input cut), so the two producers have distinct ids even when both scan the same table.  
        ).stream().findFirst().orElseThrow(() -> new AssertionError("no filter in enforced plan"));  
            cbo,
     */
        int abCols = ab.getRowType().getFieldCount();  
            rexBuilder.makeLiteral(5, intType, false)
            "precondition: inner join must be a broadcast probe:\n" + org.apache.calcite.plan.RelOptUtil.toString(enforced2),
     * BOTH joins over two ShuffleExchange inputs.  
            rexBuilder.makeInputRef(intType, 0),
            ImmutableList.of(),  
        List<org.opensearch.analytics.planner.rel.OpenSearchAggregate> aggs = findAll(
        int abCols = ab.getRowType().getFieldCount();  
     * (above the rebuilt FINAL), NOT ride on the worker per-partition (sorting per partition then merging is
 * Locks in the general hash-shuffle plan shape for multi-way INNER equi-joins (e.g.
        );  
        List<org.opensearch.analytics.planner.rel.OpenSearchAggregate> aggs = findAll(
            context.getCapabilityRegistry(),  
        RelNode midProject = org.apache.calcite.rel.logical.LogicalProject.create(
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);  
    private RelNode makeDistinctCountOverThreeWayJoin(PlannerContext context) {
     * wrong for a global sort). Asserts PARTIAL on the worker tier and the Sort on the coordinator root.  
        int leftCols = outerBuild.getRowType().getFieldCount();
            out.add((T) node);  
        assertEquals(StageExecutionType.COORDINATOR_REDUCE, newRoot.getExecutionType());
        Stage newRoot = structure.dag().rootStage();
     * cross-join branch. Here: an aggregate (drops {@code size}) over an equi-join whose left input is a
            rexBuilder.makeInputRef(intType, aCols)  
        assertTrue(
     *  it is NOT left-deep. All joins share key col0 (status). */  
            context.getDistributionTraitDef(),
            SqlStdOperatorTable.SUM,
        RexNode topCond = rexBuilder.makeCall(
            join,  
        List<org.opensearch.analytics.planner.rel.OpenSearchAggregate> aggs = findAll(  
        }
     *  {@code shouldSkipPartialFinalSplit} is true (genuinely non-decomposable: it can't merge per-partition
    }
            );
        Map<String, Integer> shardCounts = Map.of("a_idx", 3, "b_idx", 3, "c_idx", 3);  
 * </ol>
            );
        RelNode enforced = DistributionEnforcementPass.enforce(
        RelNode enforced = DistributionEnforcementPass.enforce(cbo, context.getDistributionTraitDef(), CLUSTER_DATA_NODES, 1L, true);
     * not by child-stage count: the {@code BROADCAST_BUILD} grandchild is a side-input, not a streamed  
    public void testGeneralShuffle_aggGroupedOnNonJoinKey_noReshuffle() {
import java.util.List;
    private static class ShuffleAwareDataFusionBackend extends MockDataFusionBackend {
            "a broadcast-under-cascade plan must preserve BOTH the broadcast and a shuffle (mixed shape):\n"  
            ab,  
    private static final long SMALL = 1_000L;
     * {@code Shuffle(Filter(scan))} with NO ExchangeReducer between the filter and the scan. The bug: the  
        List<org.opensearch.analytics.planner.rel.OpenSearchAggregate> rootAggs = findAll(  
        boolean hasLeftJoin = joins.stream().anyMatch(j -> j.getJoinType() == JoinRelType.LEFT);
        RelNode cbo = runPlanner(makeAggregateOverCrossThenEquiJoin(context), context);
        assertTrue(
        return LogicalJoin.create(agg, cScan, List.of(), aggcCond, Set.of(), JoinRelType.INNER);  
        RelNode cbo = runPlanner(makeThreeWayJoin(context), context);
     * on its missing input. Asserts TWO worker tiers (not a gather between them) and the intermediate Project
            rexBuilder.makeInputRef(intType, 0),
        return buildMppContext(shardCounts, rowCounts, -1L);
    /**
        // The bottom worker (level 0) must consume two leaf shard scans directly — proving the mid-Project
        // under it sits the bottom join over its two scan shuffles.  
            enforced,  
        Map<String, Long> rowCounts = Map.of("a_idx", LARGE, "b_idx", LARGE);  
     * broadcast-probe join as the build of an outer join. The bug is in the DAG cutter, not the planner, so
        assertTrue("the top join stays LEFT (distribution doesn't change join semantics)", hasLeftJoin);  
        PlannerContext context = buildMppContext(shardCounts, rowCounts);  
            if (scan.getTable().getQualifiedName().toString().contains("c_idx")) {
        // intermediate worker).
     * coordinator-centric — the pass distributes nothing (no ShuffleExchange), matching CBO's cheap
        AggregateCall countCall = AggregateCall.create(  
     * Codex BLOCKER 2 regression: a decomposable aggregate grouped on a NON-join-key column over a
        );
        assertFalse(
     * {@link DistributionEnforcementPass}. The pass must produce a cascade of BINARY worker tiers —
    /** Builds {@code Project(Join(Project(Join(a,b)), c))} — a 3-way join with an explicit row-wise Project
    }
     *  {@code root}'s tree, or null. */
            typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true),
        );
        int aCols = aScan.getRowType().getFieldCount();  
import org.opensearch.cluster.metadata.Metadata;  
        AggregateCall distinctMultiArg = AggregateCall.create(
        }
            MappingMetadata mappingMetadata = mock(MappingMetadata.class);
    /**
            rexBuilder.makeInputRef(intType, aCols)
            collect(unwrap(input), type, out);  
        ShuffleEnrichment.WorkerLevel deepest = levels.get(0);
        return new PlannerContext(registry, state, settings, rowCountLookup, /* profiling */ false);
