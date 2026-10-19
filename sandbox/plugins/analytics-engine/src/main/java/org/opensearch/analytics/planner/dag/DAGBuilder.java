        parentChildStages.add(buildStage);
        // (e.g. a Join below a top-level gather Reducer) are also cut into their own child
        // the shards and ships its hash partition, EVEN when it also has a grandchild stage feeding it — the  
     * {@code Join(BroadcastScan, TableScan)}, where the TableScan sits on input 1.
            ExchangeInfo.hashDistributed(shuffle.getHashKeys(), shuffle.getPartitionCount()),
        IndexNameExpressionResolver indexNameExpressionResolver
     */
 * compatible open source license.
    }
            shuffle.getCluster(),
        // count alone (the same rule cutBroadcast uses). A shuffle producer that scans a shard table runs on
     *       {@code Wrapper ← StageInputScan(reduce-child)}. Returned to the caller
            cutAtLateMaterialization(lm, counter, childStages, registry, clusterService, indexNameExpressionResolver);
    ) {
     * post-LM ops sit above the wrapper on top of the returned StageInputScan. Those ops
        int[] counter,  
            lmFragment.getRowType(),
        // Tag join-side role when the shuffle feeds an OpenSearchJoin's left or right input.  
        TargetResolver rootTargetResolver = needsShardResolver  
        // Recurse into the child fragment with full sever() so any nested ExchangeReducers
            lm.getAboveAnchorPhysicalFieldStorage()
            : null;
        );  
            reduceStageId,
        RelNode childFragment = sever(broadcast.getInput(), counter, grandchildren, registry, clusterService, indexNameExpressionResolver);
            List<String> reduceViable = CapabilityResolutionUtils.filterByReduceCapability(registry, reducer.getViableBackends());
            RelNode input = rawInputs.get(inputIndex);
     * to root in that case to avoid a degenerate empty COORDINATOR_REDUCE wrapper.
        IndexNameExpressionResolver indexNameExpressionResolver
 * separation of concerns: PlanForker does backend resolution, DAGBuilder does  
        // ShardScanInstructionHandler fails casting it to ShardScanExecutionContext.
     * Cuts at an {@link OpenSearchLateMaterialization} wrapper. Two cuts happen:
        // QTF's ___ugsi entry). No-op for non-QTF reducers.
        // Replace the broadcast exchange in the parent fragment with a BroadcastScan placeholder
     * random UUID v4 is statistically safe but doesn't coordinate with task / context-id
        Stage childStage = new Stage(
        OpenSearchStageInputScan stageInput = new OpenSearchStageInputScan(
     * join-side semantics to encode.
        int childStageId = counter[0]++;
            reducer.getOutputFieldStorage()
import org.opensearch.analytics.planner.CapabilityRegistry;  
     */  
     * Mints a per-DAG queryId. TODO revisit if uniqueness is relied upon for correctness —  
            shuffle.getPartitionCount(),  
    private static RelNode cutAtLateMaterialization(
        // Source both rowType and FSI from the reducer so they stay aligned 1:1 (its input lacks  
            if (newInputs.get(i) != node.getInputs().get(i)) {
        // fragment without a TableScan runs at the coordinator and consumes grandchildren via  
        RelNode childFragment = sever(reducer.getInput(), counter, grandchildren, registry, clusterService, indexNameExpressionResolver);
    ) {
    private static RelNode sever(
     * <p>The caller (the {@link #sever} walk for the wrapper's parent) attaches whatever  
        );
        ExchangeSinkProvider childSinkProvider = null;
        // the probe's join takes a TableScan plus a child BROADCAST_BUILD stage's output. A
    /**
        // Decide the build's locality by whether its fragment has a shard scan, NOT by grandchild count —
    private static boolean containsAnyInput(RelNode root, Class<? extends RelNode> type) {  
        if (parent instanceof OpenSearchJoin) {
        RelNode parent,
            childFragment,  
            shuffle.getCluster(),  
                ((OpenSearchRelNode) cboOutput).getViableBackends()  
        ClusterService clusterService,
            List<String> reduceViable = CapabilityResolutionUtils.filterByReduceCapability(
     *
        // output via an OpenSearchBroadcastScan placeholder. Other shard fragments stay at the
        List<Stage> childStages = new ArrayList<>();
        // Decide the producer's locality by whether its fragment has a shard scan — NOT by child-stage
        IndexNameExpressionResolver indexNameExpressionResolver  
import org.opensearch.analytics.planner.rel.OpenSearchBroadcastExchange;
        if (reduceChildren.isEmpty()) {  
        );
        ClusterService clusterService,  
        List<String> reduceViable = CapabilityResolutionUtils.filterByReduceCapability(registry, lm.getViableBackends());
     */  
    private static RelNode cutShuffle(
import org.opensearch.analytics.planner.rel.OpenSearchBroadcastScan;
     *       slots in a schema-bearing placeholder.</li>  
/*  
            childStageId,  
        // memtable for Camp-B (Sort/TopN/global Aggregate). Detect post-LM op shape here and
        // count alone. A fragment with a TableScan runs on shards (ShardTargetResolver) — even  
    public static QueryDAG build(  
     *       below) becomes the LM stage's child stage — a {@code COORDINATOR_REDUCE}
        int[] counter,
        } else {
        }
        ClusterService clusterService,
        }  
import java.util.List;
        List<Stage> parentChildStages,
    private static RelNode cutAtExchange(
/**
 */
            stageInput,
            lm.getAboveAnchorPhysicalFields(),
     * stage; the parent fragment's view of the shuffle is preserved with its input replaced by  
            ExchangeInfo.singleton(),  
        // the distribution intent set by whichever rule introduced it.  
        int parentInputIndex,
        // ShuffleEnrichment reads this to assemble the {@code side="left"|"right"} label on
     * like {@link org.opensearch.analytics.planner.rel.OpenSearchJoin}) is an instance of
        if (node.getInputs().isEmpty()) return node;
            shuffle.getTraitSet(),
        OpenSearchRelNode lmInput = (OpenSearchRelNode) lm.getInput();
     * allocation elsewhere in the engine.
import org.opensearch.analytics.planner.CapabilityResolutionUtils;
        return new OpenSearchShuffleExchange(
            : null;
        if (!childStages.isEmpty() || hasComputeLeaf) {  
        // TODO Stage 3 sink mode. The COORDINATOR_REDUCE that wraps the post-LM ops currently
        // so streaming buys nothing and the eager-scheduling deadlock-avoidance the streaming
 * the parent stage's input wiring. Stage IDs are assigned bottom-up.
        int childStageId = counter[0]++;  
        // stages. M2 today only composes shuffle over a shard scan, but the recursion makes the
        ClusterService clusterService,  
        parentChildStages.add(childStage);
     *       short-circuits in the rewriter), so the reduce child always has
        IndexNameExpressionResolver indexNameExpressionResolver
     * Cut at a {@link OpenSearchShuffleExchange}. The subtree below the shuffle becomes a child
            /*targetResolver=*/ null
        // ExchangeInfo comes from the reducer — the reducer is the exchange and carries
            List<String> reduceViable = CapabilityResolutionUtils.filterByReduceCapability(registry, shuffle.getViableBackends());
            reduceFragment,
                newInputs.add(sever(input, counter, childStages, registry, clusterService, indexNameExpressionResolver));
        );  
        List<Stage> grandchildren = new ArrayList<>();
            ? new ShardTargetResolver(childFragment, clusterService, indexNameExpressionResolver)
            ? new ShardTargetResolver(childFragment, clusterService, indexNameExpressionResolver)  
            }
            childStage.setRole(Stage.StageRole.BROADCAST_PROBE);
        OpenSearchLateMaterialization lmFragment = new OpenSearchLateMaterialization(
        // 3. Hand back StageInputScan(LM) so post-LM ops end up in their own COORDINATOR_REDUCE.
 * CBO output may carry multiple viable backends per operator, so the cut helpers
        RelNode childFragment = sever(shuffle.getInput(), counter, grandchildren, registry, clusterService, indexNameExpressionResolver);
     * Cut at an {@link OpenSearchBroadcastExchange}. The subtree below the exchange becomes a  
            childSinkProvider = registry.getBackend(reduceViable.getFirst()).getExchangeSinkProvider();
    /**
        return new OpenSearchExchangeReducer(
        // keyed by build-stage id. The probe-side handler chain looks up the registered memtable
     *
        parentChildStages.add(lmStage);  
import org.apache.calcite.rel.RelNode;
     * {@code cutShuffle} decide it, by inspecting the fragment rather than by counting grandchildren. A build  
     * carries the shuffle keys and partition count so the dispatcher can size partition buffers
            childStageId,
     *   <li><b>LM stage itself:</b> a fresh {@link Stage} with fragment  
import java.util.ArrayList;  
            lm.getAboveAnchorPhysicalFieldStorage(),  
            if (containsAnyInput(input, type)) return true;  
     * cutter tags the child stage {@link Stage.StageRole#SHUFFLE_SCAN_LEFT} or  
            return new QueryDAG(newQueryId(), childStages.getFirst());  
 * list to fetch an {@code ExchangeSinkProvider} — at this point the sink-provider
        // and consumes its grandchildren via an ExchangeSinkProvider.  
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;  
            broadcast.getViableBackends()  
        );
     * and in the data-node-side memtable registration name.
        );
            reduceSinkProvider,
     * scatter/gather/stitch.
 * stage cuts.
        // two NamedScans (one per side).  
            } else if (input instanceof OpenSearchBroadcastExchange broadcast) {
        // Schema is the wrapper's output rowType (= aboveAnchorPhysicalFields).  
        OpenSearchLateMaterialization lm,
    }  
        List<Stage> parentChildStages,
        );
            lm.getCluster(),
            stageInput,
        RelNode rootFragment;  
        }
            } else {  
     * the right side of a join — for example a broadcast-probe fragment is  
    ) {
            sinkProvider = registry.getBackend(reduceViable.getFirst()).getExchangeSinkProvider();
            broadcast.getCluster(),
            : null;
        buildStage.setRole(Stage.StageRole.BROADCAST_BUILD);
     * fragment will just BE this StageInputScan. {@link #build} promotes the LM stage
        ExchangeSinkProvider sinkProvider = null;
 * @opensearch.internal  
        return UUID.randomUUID().toString();
    private static RelNode cutBroadcast(
 *
        return new OpenSearchBroadcastScan(
            shuffle.getTraitSet(),  
     * standalone build stage tagged {@link Stage.StageRole#BROADCAST_BUILD}. The parent fragment's
            /*targetResolver=*/ null  
            childSinkProvider,  
        // build child is stripped at dispatch (its output is injected), became a childless COORDINATOR_REDUCE
        RelNode reduceFragment = sever(lm.getInput(), counter, reduceChildren, registry, clusterService, indexNameExpressionResolver);
        ExchangeSinkProvider childSinkProvider = null;  
 * (e.g. {@code cutAtLateMaterialization}) have to pick a backend from the viable  
        if (cboOutput instanceof OpenSearchExchangeReducer reducer) {
        List<RelNode> rawInputs = node.getInputs();
        // when it also has a grandchild stage feeding it, as in the broadcast-probe case where
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
     * <p>When the parent is an {@link org.opensearch.analytics.planner.rel.OpenSearchJoin} the
            reducer.getViableBackends(),
        return false;
        // dispatch tags COORDINATOR_REDUCE explicitly when needed).  
        List<Stage> reduceChildren = new ArrayList<>();
        // shuffle (e.g. a partial-aggregate that itself reduces) are also cut into their own  
            reducer.getExchangeInfo()  
        CapabilityRegistry registry,
    /**
            // wrap a bare StageInputScan placeholder.  
        }  
        } else if (parent instanceof OpenSearchAggregate) {
        }
        );
            targetResolver
                break;  
                newInputs.add(cutAtExchange(reducer, counter, childStages, registry, clusterService, indexNameExpressionResolver));  
                    + "single-shard collapse should have short-circuited the rewriter."  
 * Builds a {@link QueryDAG} from the CBO output by cutting at exchange boundaries.
        ClusterService clusterService,  
        ClusterService clusterService,  
            // No left/right semantics — just one input stream per partition. The agg dispatcher  
        TargetResolver targetResolver = fragmentHasShardScan
 * throw an exception if not, instead of silently picking the first. Cleaner
        // broadcast-under-shuffle case: the producer fragment is Join(BroadcastScan, shardScan) whose only
    /**  
        // Reducer feeds the LM stage. Stamp every shard's batches with their target.ordinal()
            targetResolver
     * end up in a vanilla {@code COORDINATOR_REDUCE} stage that runs them via Substrait
            );
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;  
            // promote the LM stage to rootStage and skip the synthetic post-LM stage that would
        // Root needs a shard target only if its fragment actually contains a TableScan.
     * <p>If the wrapper has no parent ops (the no-above-ops case), the caller's parent  
    }
            reduceStageInput,
        CapabilityRegistry registry,
     * </ol>
        reduceStage.setInputSinkDecorator(
        OpenSearchRelNode shuffleInput = (OpenSearchRelNode) shuffle.getInput();
            } else if (input instanceof OpenSearchShuffleExchange shuffle) {
import java.util.UUID;
        Stage buildStage = new Stage(
            reducer.getTraitSet(),
     *       gathering shard scans. QTF only fires multi-shard (single-shard collapse  
            reducer.getTraitSet(),  
        Stage childStage = new Stage(
    }
            reducer.getExchangeInfo(),
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
        // stages rather than being left intact inside the shard-local fragment.  
        } else if (cboOutput instanceof OpenSearchLateMaterialization lm) {  
            childStageId,
                    cutShuffle(shuffle, counter, childStages, registry, clusterService, node, inputIndex, indexNameExpressionResolver)  
        CapabilityRegistry registry,
                newInputs.add(cutBroadcast(broadcast, counter, childStages, registry, clusterService, indexNameExpressionResolver));  
     *
        );  
        );
        IndexNameExpressionResolver indexNameExpressionResolver
        parentChildStages.add(childStage);
            childFragment,
    private static String newQueryId() {
            : null;
        ExchangeSinkProvider reduceSinkProvider = registry.getBackend(reduceViable.getFirst()).getExchangeSinkProvider();
public class DAGBuilder {
     * <p>A build stage runs on shards when its fragment scans a shard table, and at the coordinator
        // hand a per-stage hint to the sink-provider selection.  
        List<Stage> childStages,
        OpenSearchBroadcastExchange broadcast,
        OpenSearchShuffleExchange shuffle,
            } else if (parentInputIndex == 1) {
     * side label on each producer's instruction. For other parents (Aggregate, intermediate Project)  
            }
        // the same rule cutReducer and cutShuffle use. A build fragment can BOTH scan a shard table and have
        return new OpenSearchStageInputScan(
            // M3 hash-shuffle aggregate: single producer feeding a FINAL aggregate worker.
        // off grandchildren alone then leaves it with no ShardTargetResolver and an ExchangeSinkProvider
        // inherits whatever sink the cluster setting selects (streaming vs memtable). For QTF  
        // each producer's ShuffleProducerInstructionNode and to compose the worker fragment's
        for (int inputIndex = 0; inputIndex < rawInputs.size(); inputIndex++) {  
        List<Stage> grandchildren = new ArrayList<>();  
                newInputs.add(cutAtLateMaterialization(lm, counter, childStages, registry, clusterService, indexNameExpressionResolver));
            lm.getCluster(),
        }
            ? new ShardTargetResolver(childFragment, clusterService, indexNameExpressionResolver)
 *
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;  
        if (!grandchildren.isEmpty() && !fragmentHasShardScan) {
            shuffle.getViableBackends()
        int reduceStageId = counter[0]++;  
    }  
        if (!grandchildren.isEmpty() && !fragmentHasShardScan) {
        }
            lmFragment,  
        OpenSearchExchangeReducer reducer,  
        // cutter robust to future plan shapes.
        // instead, so Stage classifies it COORDINATOR_REDUCE while its instruction list still carries a shard
        TargetResolver targetResolver = fragmentHasShardScan  
            lm.getViableBackends(),  
        // scan; ReduceStageExecutionFactory hands that instruction an ExchangeSinkContext and  
import org.opensearch.analytics.planner.RelNodeUtils;
            shuffle.getViableBackends(),
     * {@link Stage.StageRole#SHUFFLE_SCAN_RIGHT} based on whether the shuffle feeds input 0 or 1
        // it should be memtable: LM emits a single VSR after full stitch (see Stitcher TODO),
     * otherwise (e.g. broadcast over an aggregate result) — decided the same way {@code cutReducer} and
 * alternative; the cut helpers could then assert exactly one viable backend and
                changed = true;
        boolean fragmentHasShardScan = containsAnyInput(childFragment, OpenSearchTableScan.class);
        return new QueryDAG(newQueryId(), rootStage);
 * choice is technically ambiguous. Running DAGBuilder after PlanForker would
     * True iff any node in {@code root}'s tree (including all inputs of multi-input nodes  
     *       grandchildren and always gets a sink provider.</li>
            shuffle.getInput().getRowType(),  
        OpenSearchStageInputScan reduceStageInput = new OpenSearchStageInputScan(
        ExchangeSinkProvider childSinkProvider = null;  
        // 2. LM stage itself — fragment is the wrapper rooted at StageInputScan(reduceStage).  
            } else if (input instanceof OpenSearchLateMaterialization lm) {
        int childStageId = counter[0]++;  
            /*exchangeInfo=*/ null,
     *       as a {@link OpenSearchStageInputScan} so the caller's parent fragment
            List.of(reduceStage),
        // a grandchild stage: that is NESTED BROADCAST, where this build is itself a broadcast probe. Keying  
            childSinkProvider = registry.getBackend(reduceViable.getFirst()).getExchangeSinkProvider();  
            }  
        // either because it gathers child output (COORDINATOR_REDUCE) or because it's a  
            reducer.getViableBackends(),
        // source shard for fan-out fetches.
        boolean changed = false;
        // don't need a backend sink.  
     */  
        // Recurse into the shuffle's input with full sever() so any nested exchanges below the
     * an {@link OpenSearchStageInputScan} placeholder. Exchange metadata on the child stage
        );
        }  
            assert childStages.size() == 1 : "cutAtLateMaterialization must add exactly one child (the LM stage)";
        // Tag broadcast-probe role when the fragment runs on shards AND consumes a build stage's  
            lm.getViableBackends(),
            reducer.getCluster(),  
            grandchildren,
            shuffleInput.getOutputFieldStorage()
            rootFragment = cutAtExchange(reducer, counter, childStages, registry, clusterService, indexNameExpressionResolver);
            lmStageId,
            // Cut directly: child stage is the subtree below, root fragment is  
        Stage lmStage = new Stage(
        List<Stage> grandchildren = new ArrayList<>();  
    ) {
            childStage.setRole(Stage.StageRole.SHUFFLE_SCAN_AGG);  
 * collapse each operator's viable list to a single resolved backend per  
            lmStageId,
            reduceStageId,
     * org.opensearch.analytics.spi.BroadcastInjectionInstructionNode} attached at dispatch time
import org.opensearch.analytics.spi.ExchangeSinkProvider;
            grandchildren,
        );
     * matches by build-stage id — the same id used in the {@link  
    /**
     * and ship per-partition output to the right consumer node.  
            // ShuffleScan instruction (vs the join's two).
     * view of the broadcast is replaced by an {@link OpenSearchBroadcastScan} placeholder that
        for (int i = 0; i < newInputs.size(); i++) {  
    }  
            // reads this role to lift the FINAL into a worker stage and attach a single
        Stage rootStage = new Stage(counter[0]++, rootFragment, childStages, null, sinkProvider, rootTargetResolver);
            broadcast.getTraitSet(),  
            shuffle.getHashKeys(),
     * — {@code ShuffleEnrichment} consumes that tag to assign the {@code "left"} / {@code "right"}
        // sink is designed for doesn't apply. Once Stitcher supports incremental emission, we  
        // an ExchangeSinkProvider.
            // LM at root, no above-ops (e.g. `source = t | where ... | sort col | head N`):
        // can pick streaming for Camp-A post-LM ops (Filter/Project/hash Aggregate) and keep
        // (single-stage scan) and pure pass-through root (no children, no compute leaf)
            reducer.getCluster(),
 * <p>TODO move DAGBuilder AFTER PlanForker. Today this runs pre-fork while the
import org.opensearch.analytics.exec.OrdinalAppendingSink;
 * SPDX-License-Identifier: Apache-2.0
            reducer.getRowType(),  
            childStageId,
        int[] counter,  
    private DAGBuilder() {}
            if (input instanceof OpenSearchExchangeReducer reducer) {
    }  
        }  
    ) {  
 * Each {@link OpenSearchExchangeReducer} becomes a stage boundary; the subtree  
        int[] counter = { 0 };  
            lm.getTraitSet(),
 */  
                "QTF rewriter fired but the wrapper's input has no ExchangeReducer below it — "
            childSinkProvider,
            throw new IllegalStateException(
        CapabilityRegistry registry,  
                );
            lmInput.getOutputFieldStorage()
        int lmStageId = counter[0]++;  
        if (!grandchildren.isEmpty() && !fragmentHasShardScan) {  
            /*sinkProvider=*/ null,  
     * child, which {@code UnifiedDispatch} captures in an earlier wave and strips before this one runs.
        // default SHARD_SOURCE; coord-only fragments stay default too (DefaultPlanExecutor's
    ) {  
            lm.getTraitSet(),  
     * the role stays at the default {@link Stage.StageRole#SHARD_SOURCE} since there is no
            /*exchangeInfo=*/ null,
    }  
        );
        // and run as LOCAL_COMPUTE on the coordinator.
     * <ol>  
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;  
        }
        if (fragmentHasShardScan && containsAnyInput(childFragment, OpenSearchBroadcastScan.class)) {
            lm.getTraitSet(),  
import org.opensearch.analytics.planner.rel.OpenSearchStageInputScan;
            lm.getCluster(),  
                childStage.setRole(Stage.StageRole.SHUFFLE_SCAN_LEFT);  
        List<Stage> parentChildStages,
        }  
            );
        List<RelNode> newInputs = new ArrayList<>();
            reduceChildren,  
            childFragment,  
            ? new ShardTargetResolver(rootFragment, clusterService, indexNameExpressionResolver)
            childStageId,
        );  
            lm.getViableBackends()
 * below becomes a child stage and the reducer's own {@link ExchangeInfo} drives
     * {@code type}. {@link RelNodeUtils#findNode} only walks the first input, which misses
            (sink, allocator) -> new OrdinalAppendingSink(sink, allocator, OpenSearchLateMaterialization.UGSI_FIELD)  
        // Sink provider is needed whenever the root stage runs a backend plan locally —
     * over the LM stage's stitched output. The LM stage itself runs Java-only  
            childStageId,
        CapabilityRegistry registry,  
        boolean fragmentHasShardScan = containsAnyInput(childFragment, OpenSearchTableScan.class);
            targetResolver
            broadcast.getInput().getRowType(),
        boolean hasComputeLeaf = RelNodeUtils.findNode(rootFragment, OpenSearchValues.class) != null;
        boolean fragmentHasShardScan = containsAnyInput(childFragment, OpenSearchTableScan.class);
        RelNode cboOutput,
        RelNode node,  
        // Without this, such a producer fell into the `grandchildren non-empty → reduce` branch and, once the  
     * is NOT necessarily a leaf: under nested broadcast it is itself a broadcast probe and has its own build
import org.opensearch.analytics.planner.rel.OpenSearchShuffleExchange;
 * this file be licensed under the Apache-2.0 license or a
            childSinkProvider,  
        // ("expected at least one child"). A fragment with no shard scan genuinely runs at the coordinator
        // 1. Reduce child — Sort+Limit reduce above shard scans. Multi-shard QTF only.  
     *  
     *   <li><b>Reduce child:</b> the wrapper's input subtree (Sort+Limit + ER + scans
        OpenSearchStageInputScan stageInput = new OpenSearchStageInputScan(
        TargetResolver targetResolver = fragmentHasShardScan  
            rootFragment = sever(cboOutput, counter, childStages, registry, clusterService, indexNameExpressionResolver);
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;
 *  
        for (RelNode input : root.getInputs()) {
            lm.getInput().getRowType(),  
        // by namedInputId="broadcast-<buildStageId>" at execution time.  
        CapabilityRegistry registry,
        int[] counter,  
     *
        return changed ? node.copy(node.getTraitSet(), newInputs) : node;  
        //
        int[] counter,
}  
                childStage.setRole(Stage.StageRole.SHUFFLE_SCAN_RIGHT);
import org.opensearch.cluster.service.ClusterService;
            // Root IS an ExchangeReducer — pure gather (no compute above the exchange).
     */  
        // as ___ugsi BEFORE the backend's reduce sees them so the LM stage can group rows by  
import org.opensearch.analytics.planner.rel.OpenSearchValues;
                newInputs.add(
        IndexNameExpressionResolver indexNameExpressionResolver
        // coord-only compute leaf like LogicalValues (LOCAL_COMPUTE). Pure shard root
        List<Stage> parentChildStages,
            grandchildren,
        // Stage execution location is decided by the fragment's contents, not the grandchild
package org.opensearch.analytics.planner.dag;
        boolean needsShardResolver = childStages.isEmpty() && RelNodeUtils.findNode(rootFragment, OpenSearchTableScan.class) != null;
            if (parentInputIndex == 0) {
            // ExchangeReducer → StageInputScan.
                registry,
        if (type.isInstance(root)) return true;
        // OpenSearchValues (literal-row source) and other coord-only leaves have no scan  
            List<String> reduceViable = CapabilityResolutionUtils.filterByReduceCapability(registry, broadcast.getViableBackends());
            childSinkProvider = registry.getBackend(reduceViable.getFirst()).getExchangeSinkProvider();  
 * The OpenSearch Contributors require contributions made to  
        // grandchild is the BROADCAST_BUILD side-input (injected as an instruction, not a streamed child).
        Stage reduceStage = new Stage(  
