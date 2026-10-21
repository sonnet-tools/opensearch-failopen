 * (e.g. {@code cutAtLateMaterialization}) have to pick a backend from the viable
import java.util.UUID;
        if (cboOutput instanceof OpenSearchExchangeReducer reducer) {
            // Root IS an ExchangeReducer — pure gather (no compute above the exchange).
        RelNode parent,
    /**
        List<String> reduceViable = CapabilityResolutionUtils.filterByReduceCapability(registry, lm.getViableBackends());
        RelNode childFragment = sever(shuffle.getInput(), counter, grandchildren, registry, clusterService, indexNameExpressionResolver);
            lm.getViableBackends()
 * throw an exception if not, instead of silently picking the first. Cleaner
            if (parentInputIndex == 0) {
        List<Stage> parentChildStages,
        // source shard for fan-out fetches.
        // Replace the broadcast exchange in the parent fragment with a BroadcastScan placeholder
import java.util.List;
        // OpenSearchValues (literal-row source) and other coord-only leaves have no scan
     *       gathering shard scans. QTF only fires multi-shard (single-shard collapse
        int childStageId = counter[0]++;
            childStage.setRole(Stage.StageRole.SHUFFLE_SCAN_AGG);
     *       {@code Wrapper ← StageInputScan(reduce-child)}. Returned to the caller
        // an ExchangeSinkProvider.
        if (type.isInstance(root)) return true;
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
     * to root in that case to avoid a degenerate empty COORDINATOR_REDUCE wrapper.
 *
            /*targetResolver=*/ null
        // as ___ugsi BEFORE the backend's reduce sees them so the LM stage can group rows by
        return new OpenSearchShuffleExchange(
            } else if (input instanceof OpenSearchLateMaterialization lm) {
        // Decide the build's locality by whether its fragment has a shard scan, NOT by grandchild count —
        return new OpenSearchExchangeReducer(
        return new OpenSearchBroadcastScan(
        List<Stage> grandchildren = new ArrayList<>();
/**
            lm.getTraitSet(),
            shuffle.getViableBackends(),
    ) {
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
     * post-LM ops sit above the wrapper on top of the returned StageInputScan. Those ops
        if (!grandchildren.isEmpty() && !fragmentHasShardScan) {
            shuffle.getViableBackends()
     * {@code type}. {@link RelNodeUtils#findNode} only walks the first input, which misses
            childStageId,
     * scatter/gather/stitch.
        TargetResolver targetResolver = fragmentHasShardScan
            ? new ShardTargetResolver(childFragment, clusterService, indexNameExpressionResolver)
            childSinkProvider,
     * {@link Stage.StageRole#SHUFFLE_SCAN_RIGHT} based on whether the shuffle feeds input 0 or 1
            reduceStageId,
        // either because it gathers child output (COORDINATOR_REDUCE) or because it's a
        // off grandchildren alone then leaves it with no ShardTargetResolver and an ExchangeSinkProvider
        // scan; ReduceStageExecutionFactory hands that instruction an ExchangeSinkContext and
        int parentInputIndex,
        );
        );
    ) {
            List<String> reduceViable = CapabilityResolutionUtils.filterByReduceCapability(
     * {@code Join(BroadcastScan, TableScan)}, where the TableScan sits on input 1.
        ClusterService clusterService,
        // Stage execution location is decided by the fragment's contents, not the grandchild
        CapabilityRegistry registry,
     * standalone build stage tagged {@link Stage.StageRole#BROADCAST_BUILD}. The parent fragment's
            rootFragment = sever(cboOutput, counter, childStages, registry, clusterService, indexNameExpressionResolver);
        }
        OpenSearchLateMaterialization lm,
        } else {
        }
            lm.getInput().getRowType(),
        for (int i = 0; i < newInputs.size(); i++) {
     * over the LM stage's stitched output. The LM stage itself runs Java-only
            reducer.getOutputFieldStorage()
        List<RelNode> rawInputs = node.getInputs();
        CapabilityRegistry registry,
import org.opensearch.analytics.planner.rel.OpenSearchStageInputScan;
            if (input instanceof OpenSearchExchangeReducer reducer) {
            shuffle.getHashKeys(),
 * the parent stage's input wiring. Stage IDs are assigned bottom-up.
        List<Stage> childStages = new ArrayList<>();
/*
     *       below) becomes the LM stage's child stage — a {@code COORDINATOR_REDUCE}
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                childStage.setRole(Stage.StageRole.SHUFFLE_SCAN_LEFT);
     */
                );
        // (e.g. a Join below a top-level gather Reducer) are also cut into their own child
        List<Stage> childStages,
    /**
            grandchildren,
import org.opensearch.analytics.planner.RelNodeUtils;
import org.opensearch.analytics.planner.CapabilityResolutionUtils;
        OpenSearchLateMaterialization lmFragment = new OpenSearchLateMaterialization(
                    + "single-shard collapse should have short-circuited the rewriter."
    private static RelNode cutBroadcast(
            lmInput.getOutputFieldStorage()
            } else if (input instanceof OpenSearchShuffleExchange shuffle) {
import org.opensearch.analytics.planner.CapabilityRegistry;
            }
        // Recurse into the child fragment with full sever() so any nested ExchangeReducers
        List<Stage> reduceChildren = new ArrayList<>();
            }
            } else if (input instanceof OpenSearchBroadcastExchange broadcast) {
        int childStageId = counter[0]++;
     * <p>A build stage runs on shards when its fragment scans a shard table, and at the coordinator
            assert childStages.size() == 1 : "cutAtLateMaterialization must add exactly one child (the LM stage)";
            );
        // Sink provider is needed whenever the root stage runs a backend plan locally —
        List<Stage> grandchildren = new ArrayList<>();
        TargetResolver targetResolver = fragmentHasShardScan
        // count alone. A fragment with a TableScan runs on shards (ShardTargetResolver) — even
 *
            return new QueryDAG(newQueryId(), childStages.getFirst());
        ClusterService clusterService,
            reduceStageInput,
    /**
            reducer.getTraitSet(),
     * join-side semantics to encode.
                ((OpenSearchRelNode) cboOutput).getViableBackends()
            reduceSinkProvider,
        );
     * <p>When the parent is an {@link org.opensearch.analytics.planner.rel.OpenSearchJoin} the
        // cutter robust to future plan shapes.
     *       as a {@link OpenSearchStageInputScan} so the caller's parent fragment
    }
        buildStage.setRole(Stage.StageRole.BROADCAST_BUILD);
            lm.getTraitSet(),
     * otherwise (e.g. broadcast over an aggregate result) — decided the same way {@code cutReducer} and
            // ExchangeReducer → StageInputScan.
            broadcast.getInput().getRowType(),
        ClusterService clusterService,
     * the role stays at the default {@link Stage.StageRole#SHARD_SOURCE} since there is no
        int reduceStageId = counter[0]++;
            : null;
import org.opensearch.analytics.spi.ExchangeSinkProvider;
        ExchangeSinkProvider childSinkProvider = null;
            rootFragment = cutAtExchange(reducer, counter, childStages, registry, clusterService, indexNameExpressionResolver);
        int[] counter,
                registry,
            broadcast.getTraitSet(),
     * — {@code ShuffleEnrichment} consumes that tag to assign the {@code "left"} / {@code "right"}
     */
        boolean needsShardResolver = childStages.isEmpty() && RelNodeUtils.findNode(rootFragment, OpenSearchTableScan.class) != null;
    /**
        // default SHARD_SOURCE; coord-only fragments stay default too (DefaultPlanExecutor's
 * choice is technically ambiguous. Running DAGBuilder after PlanForker would
            childStageId,
            : null;
            /*exchangeInfo=*/ null,
    private DAGBuilder() {}
     *
            (sink, allocator) -> new OrdinalAppendingSink(sink, allocator, OpenSearchLateMaterialization.UGSI_FIELD)
        parentChildStages.add(childStage);
     *       grandchildren and always gets a sink provider.</li>
        OpenSearchStageInputScan stageInput = new OpenSearchStageInputScan(
            lm.getCluster(),
        // can pick streaming for Camp-A post-LM ops (Filter/Project/hash Aggregate) and keep
            childFragment,
            // M3 hash-shuffle aggregate: single producer feeding a FINAL aggregate worker.
        if (node.getInputs().isEmpty()) return node;
            // reads this role to lift the FINAL into a worker stage and attach a single
    public static QueryDAG build(
 * list to fetch an {@code ExchangeSinkProvider} — at this point the sink-provider
 */
        if (!grandchildren.isEmpty() && !fragmentHasShardScan) {
        // the distribution intent set by whichever rule introduced it.
                newInputs.add(cutBroadcast(broadcast, counter, childStages, registry, clusterService, indexNameExpressionResolver));
        // the shards and ships its hash partition, EVEN when it also has a grandchild stage feeding it — the
     * and in the data-node-side memtable registration name.
    ) {
        OpenSearchRelNode lmInput = (OpenSearchRelNode) lm.getInput();
        return changed ? node.copy(node.getTraitSet(), newInputs) : node;
     *   <li><b>Reduce child:</b> the wrapper's input subtree (Sort+Limit + ER + scans
        CapabilityRegistry registry,
        if (fragmentHasShardScan && containsAnyInput(childFragment, OpenSearchBroadcastScan.class)) {
            List<String> reduceViable = CapabilityResolutionUtils.filterByReduceCapability(registry, shuffle.getViableBackends());
     *       short-circuits in the rewriter), so the reduce child always has
        }
        // fragment without a TableScan runs at the coordinator and consumes grandchildren via
        // Tag broadcast-probe role when the fragment runs on shards AND consumes a build stage's
        if (parent instanceof OpenSearchJoin) {
 * this file be licensed under the Apache-2.0 license or a
        // broadcast-under-shuffle case: the producer fragment is Join(BroadcastScan, shardScan) whose only
        OpenSearchBroadcastExchange broadcast,
     * end up in a vanilla {@code COORDINATOR_REDUCE} stage that runs them via Substrait
import org.opensearch.analytics.planner.rel.OpenSearchBroadcastScan;
                newInputs.add(
        );
            /*targetResolver=*/ null
        // QTF's ___ugsi entry). No-op for non-QTF reducers.
            shuffle.getTraitSet(),
        RelNode cboOutput,
        boolean hasComputeLeaf = RelNodeUtils.findNode(rootFragment, OpenSearchValues.class) != null;
     *
        // by namedInputId="broadcast-<buildStageId>" at execution time.
     * fragment will just BE this StageInputScan. {@link #build} promotes the LM stage
}
     * child, which {@code UnifiedDispatch} captures in an earlier wave and strips before this one runs.
     *       slots in a schema-bearing placeholder.</li>
            lm.getViableBackends(),
            shuffleInput.getOutputFieldStorage()
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
     * random UUID v4 is statistically safe but doesn't coordinate with task / context-id
 * Builds a {@link QueryDAG} from the CBO output by cutting at exchange boundaries.
        int[] counter,
            ExchangeInfo.hashDistributed(shuffle.getHashKeys(), shuffle.getPartitionCount()),
        IndexNameExpressionResolver indexNameExpressionResolver
        RelNode childFragment = sever(reducer.getInput(), counter, grandchildren, registry, clusterService, indexNameExpressionResolver);
        // output via an OpenSearchBroadcastScan placeholder. Other shard fragments stay at the
            shuffle.getCluster(),
            reducer.getCluster(),
        parentChildStages.add(buildStage);
        // two NamedScans (one per side).
        // the probe's join takes a TableScan plus a child BROADCAST_BUILD stage's output. A
            lm.getViableBackends(),
        ExchangeSinkProvider reduceSinkProvider = registry.getBackend(reduceViable.getFirst()).getExchangeSinkProvider();
            childStageId,
                changed = true;
        boolean changed = false;
        );
        Stage childStage = new Stage(
    private static RelNode cutShuffle(
            childSinkProvider = registry.getBackend(reduceViable.getFirst()).getExchangeSinkProvider();
     * the right side of a join — for example a broadcast-probe fragment is
        // when it also has a grandchild stage feeding it, as in the broadcast-probe case where
            stageInput,
    private static boolean containsAnyInput(RelNode root, Class<? extends RelNode> type) {
                    cutShuffle(shuffle, counter, childStages, registry, clusterService, node, inputIndex, indexNameExpressionResolver)
        Stage buildStage = new Stage(
            } else {
        } else if (cboOutput instanceof OpenSearchLateMaterialization lm) {
        RelNode node,
        RelNode reduceFragment = sever(lm.getInput(), counter, reduceChildren, registry, clusterService, indexNameExpressionResolver);
        int[] counter = { 0 };
     * cutter tags the child stage {@link Stage.StageRole#SHUFFLE_SCAN_LEFT} or
 * compatible open source license.
        reduceStage.setInputSinkDecorator(
            childFragment,
        );
        // keyed by build-stage id. The probe-side handler chain looks up the registered memtable
        ClusterService clusterService,
     */
                "QTF rewriter fired but the wrapper's input has no ExchangeReducer below it — "
 * alternative; the cut helpers could then assert exactly one viable backend and
            lm.getAboveAnchorPhysicalFieldStorage(),
            // ShuffleScan instruction (vs the join's two).
            childStageId,
            targetResolver
        // stages rather than being left intact inside the shard-local fragment.
        // grandchild is the BROADCAST_BUILD side-input (injected as an instruction, not a streamed child).
 * <p>TODO move DAGBuilder AFTER PlanForker. Today this runs pre-fork while the
            targetResolver
        // memtable for Camp-B (Sort/TopN/global Aggregate). Detect post-LM op shape here and
import org.opensearch.analytics.planner.rel.OpenSearchValues;
     * side label on each producer's instruction. For other parents (Aggregate, intermediate Project)
 * @opensearch.internal
        // stages. M2 today only composes shuffle over a shard scan, but the recursion makes the
     * like {@link org.opensearch.analytics.planner.rel.OpenSearchJoin}) is an instance of
        );
    ) {
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;
            lmStageId,
        List<Stage> grandchildren = new ArrayList<>();
        // and run as LOCAL_COMPUTE on the coordinator.
     * org.opensearch.analytics.spi.BroadcastInjectionInstructionNode} attached at dispatch time
     * an {@link OpenSearchStageInputScan} placeholder. Exchange metadata on the child stage
     * view of the broadcast is replaced by an {@link OpenSearchBroadcastScan} placeholder that
            grandchildren,
     * <ol>
        if (!childStages.isEmpty() || hasComputeLeaf) {
            } else if (parentInputIndex == 1) {
            ? new ShardTargetResolver(rootFragment, clusterService, indexNameExpressionResolver)
     * </ol>
 */
        // shuffle (e.g. a partial-aggregate that itself reduces) are also cut into their own
                childStage.setRole(Stage.StageRole.SHUFFLE_SCAN_RIGHT);
        List<Stage> parentChildStages,
            lm.getCluster(),
     * Cut at an {@link OpenSearchBroadcastExchange}. The subtree below the exchange becomes a
            // Cut directly: child stage is the subtree below, root fragment is
            /*sinkProvider=*/ null,
        // Reducer feeds the LM stage. Stamp every shard's batches with their target.ordinal()
            List<String> reduceViable = CapabilityResolutionUtils.filterByReduceCapability(registry, broadcast.getViableBackends());
            shuffle.getCluster(),
        }
        for (RelNode input : root.getInputs()) {
        IndexNameExpressionResolver indexNameExpressionResolver
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
        TargetResolver targetResolver = fragmentHasShardScan
        Stage reduceStage = new Stage(
import org.opensearch.analytics.exec.OrdinalAppendingSink;
        // build child is stripped at dispatch (its output is injected), became a childless COORDINATOR_REDUCE
            lmStageId,
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to
            broadcast.getViableBackends()
        //
            shuffle.getPartitionCount(),
        }
    ) {
        parentChildStages.add(childStage);
        if (reduceChildren.isEmpty()) {
        int lmStageId = counter[0]++;
    private static RelNode sever(
        return false;
        // 3. Hand back StageInputScan(LM) so post-LM ops end up in their own COORDINATOR_REDUCE.
    private static RelNode cutAtExchange(
        } else if (parent instanceof OpenSearchAggregate) {
     *
        // Schema is the wrapper's output rowType (= aboveAnchorPhysicalFields).
        }
 * collapse each operator's viable list to a single resolved backend per
        OpenSearchExchangeReducer reducer,
     *
     * Cut at a {@link OpenSearchShuffleExchange}. The subtree below the shuffle becomes a child
        ExchangeSinkProvider childSinkProvider = null;
     * stage; the parent fragment's view of the shuffle is preserved with its input replaced by
            );
                newInputs.add(sever(input, counter, childStages, registry, clusterService, indexNameExpressionResolver));
            lm.getAboveAnchorPhysicalFieldStorage()
        OpenSearchRelNode shuffleInput = (OpenSearchRelNode) shuffle.getInput();
        // Recurse into the shuffle's input with full sever() so any nested exchanges below the
            // wrap a bare StageInputScan placeholder.
        ClusterService clusterService,
        List<Stage> parentChildStages,
        );
            sinkProvider = registry.getBackend(reduceViable.getFirst()).getExchangeSinkProvider();
        // sink is designed for doesn't apply. Once Stitcher supports incremental emission, we
        // ShuffleEnrichment reads this to assemble the {@code side="left"|"right"} label on
     * Cuts at an {@link OpenSearchLateMaterialization} wrapper. Two cuts happen:
        ExchangeSinkProvider sinkProvider = null;
            childSinkProvider,
            lmFragment,
        return UUID.randomUUID().toString();
    }
                break;
            List<String> reduceViable = CapabilityResolutionUtils.filterByReduceCapability(registry, reducer.getViableBackends());
        boolean fragmentHasShardScan = containsAnyInput(childFragment, OpenSearchTableScan.class);
            ? new ShardTargetResolver(childFragment, clusterService, indexNameExpressionResolver)
        int childStageId = counter[0]++;
        return new OpenSearchStageInputScan(
        );
        int[] counter,
        );
     */
            reduceFragment,
            broadcast.getCluster(),
        // Root needs a shard target only if its fragment actually contains a TableScan.
        // (single-stage scan) and pure pass-through root (no children, no compute leaf)
        RelNode rootFragment;
            // promote the LM stage to rootStage and skip the synthetic post-LM stage that would
        boolean fragmentHasShardScan = containsAnyInput(childFragment, OpenSearchTableScan.class);
                newInputs.add(cutAtExchange(reducer, counter, childStages, registry, clusterService, indexNameExpressionResolver));
            childStageId,
        // Decide the producer's locality by whether its fragment has a shard scan — NOT by child-stage
        // ShardScanInstructionHandler fails casting it to ShardScanExecutionContext.
        CapabilityRegistry registry,
        // a grandchild stage: that is NESTED BROADCAST, where this build is itself a broadcast probe. Keying
        // dispatch tags COORDINATOR_REDUCE explicitly when needed).
            reducer.getViableBackends(),
        return new QueryDAG(newQueryId(), rootStage);
            childSinkProvider,
     * carries the shuffle keys and partition count so the dispatcher can size partition buffers
        for (int inputIndex = 0; inputIndex < rawInputs.size(); inputIndex++) {
     * Mints a per-DAG queryId. TODO revisit if uniqueness is relied upon for correctness —
        // don't need a backend sink.
        // TODO Stage 3 sink mode. The COORDINATOR_REDUCE that wraps the post-LM ops currently
    ) {
            if (containsAnyInput(input, type)) return true;
import org.opensearch.analytics.planner.rel.OpenSearchBroadcastExchange;
        // inherits whatever sink the cluster setting selects (streaming vs memtable). For QTF
     * matches by build-stage id — the same id used in the {@link
    }
package org.opensearch.analytics.planner.dag;
        // and consumes its grandchildren via an ExchangeSinkProvider.
            : null;
import java.util.ArrayList;
            lm.getTraitSet(),
import org.apache.calcite.rel.RelNode;
            reducer.getCluster(),
        OpenSearchShuffleExchange shuffle,
 * stage cuts.
            childSinkProvider = registry.getBackend(reduceViable.getFirst()).getExchangeSinkProvider();
        if (!grandchildren.isEmpty() && !fragmentHasShardScan) {
        IndexNameExpressionResolver indexNameExpressionResolver
            childStageId,
        }
        }
            }
        // coord-only compute leaf like LogicalValues (LOCAL_COMPUTE). Pure shard root
            childFragment,
            shuffle.getTraitSet(),
     * and ship per-partition output to the right consumer node.
        }
     * allocation elsewhere in the engine.
    private static RelNode cutAtLateMaterialization(
            /*exchangeInfo=*/ null,
            lmFragment.getRowType(),
            childSinkProvider = registry.getBackend(reduceViable.getFirst()).getExchangeSinkProvider();
        // 1. Reduce child — Sort+Limit reduce above shard scans. Multi-shard QTF only.
     * is NOT necessarily a leaf: under nested broadcast it is itself a broadcast probe and has its own build
 *
        // instead, so Stage classifies it COORDINATOR_REDUCE while its instruction list still carries a shard
        OpenSearchStageInputScan reduceStageInput = new OpenSearchStageInputScan(
        Stage childStage = new Stage(
        OpenSearchStageInputScan stageInput = new OpenSearchStageInputScan(
        IndexNameExpressionResolver indexNameExpressionResolver
        RelNode childFragment = sever(broadcast.getInput(), counter, grandchildren, registry, clusterService, indexNameExpressionResolver);
     *
 * CBO output may carry multiple viable backends per operator, so the cut helpers
        );
            if (newInputs.get(i) != node.getInputs().get(i)) {
 * separation of concerns: PlanForker does backend resolution, DAGBuilder does
        // each producer's ShuffleProducerInstructionNode and to compose the worker fragment's
            ? new ShardTargetResolver(childFragment, clusterService, indexNameExpressionResolver)
    private static String newQueryId() {
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
        // Source both rowType and FSI from the reducer so they stay aligned 1:1 (its input lacks
        IndexNameExpressionResolver indexNameExpressionResolver
        // hand a per-stage hint to the sink-provider selection.
        }
            reducer.getViableBackends(),
        );
        boolean fragmentHasShardScan = containsAnyInput(childFragment, OpenSearchTableScan.class);
            : null;
    }
        );
public class DAGBuilder {
    /**
import org.opensearch.analytics.planner.rel.OpenSearchShuffleExchange;
     * True iff any node in {@code root}'s tree (including all inputs of multi-input nodes
            reducer.getExchangeInfo()
     *   <li><b>LM stage itself:</b> a fresh {@link Stage} with fragment
        // ExchangeInfo comes from the reducer — the reducer is the exchange and carries
        // Tag join-side role when the shuffle feeds an OpenSearchJoin's left or right input.
            ExchangeInfo.singleton(),
        IndexNameExpressionResolver indexNameExpressionResolver
        List<Stage> parentChildStages,
            // No left/right semantics — just one input stream per partition. The agg dispatcher
    }
        int[] counter,
        // ("expected at least one child"). A fragment with no shard scan genuinely runs at the coordinator
    }
            targetResolver
        int[] counter,
        Stage lmStage = new Stage(
 * below becomes a child stage and the reducer's own {@link ExchangeInfo} drives
    }
        parentChildStages.add(lmStage);
     * <p>If the wrapper has no parent ops (the no-above-ops case), the caller's parent
            reducer.getRowType(),
     * <p>The caller (the {@link #sever} walk for the wrapper's parent) attaches whatever
            throw new IllegalStateException(
        // Without this, such a producer fell into the `grandchildren non-empty → reduce` branch and, once the
        // it should be memtable: LM emits a single VSR after full stitch (see Stitcher TODO),
        );
            cutAtLateMaterialization(lm, counter, childStages, registry, clusterService, indexNameExpressionResolver);
        CapabilityRegistry registry,
            stageInput,
 * Each {@link OpenSearchExchangeReducer} becomes a stage boundary; the subtree
        ClusterService clusterService,
            // LM at root, no above-ops (e.g. `source = t | where ... | sort col | head N`):
        Stage rootStage = new Stage(counter[0]++, rootFragment, childStages, null, sinkProvider, rootTargetResolver);
        // 2. LM stage itself — fragment is the wrapper rooted at StageInputScan(reduceStage).
        }
            reducer.getTraitSet(),
            reduceStageId,
    }
            reducer.getExchangeInfo(),
            RelNode input = rawInputs.get(inputIndex);
        CapabilityRegistry registry,
            shuffle.getInput().getRowType(),
            lm.getAboveAnchorPhysicalFields(),
        List<RelNode> newInputs = new ArrayList<>();
        // count alone (the same rule cutBroadcast uses). A shuffle producer that scans a shard table runs on
            reduceChildren,
     * {@code cutShuffle} decide it, by inspecting the fragment rather than by counting grandchildren. A build
     */
        ExchangeSinkProvider childSinkProvider = null;
                newInputs.add(cutAtLateMaterialization(lm, counter, childStages, registry, clusterService, indexNameExpressionResolver));
            childStage.setRole(Stage.StageRole.BROADCAST_PROBE);
        // the same rule cutReducer and cutShuffle use. A build fragment can BOTH scan a shard table and have
        // so streaming buys nothing and the eager-scheduling deadlock-avoidance the streaming
            List.of(reduceStage),
        TargetResolver rootTargetResolver = needsShardResolver
            grandchildren,
            lm.getCluster(),
