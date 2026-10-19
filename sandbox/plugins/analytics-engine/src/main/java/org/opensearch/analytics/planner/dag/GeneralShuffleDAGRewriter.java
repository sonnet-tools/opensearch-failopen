            }
 * <p><b>In-place worker promotion.</b> The enforcement pass does binary-tier lowering: it shuffles every
            throw new IllegalStateException(
            return;
        final Map<Integer, JoinShuffleInfo> descRef = descriptors;
package org.opensearch.analytics.planner.dag;
        // worker's WorkerTargetResolver AND the producer instructions' targets — resolving twice risks the  
    }
        RelNode n = RelNodeUtils.unwrapHep(input);  
 */
import org.opensearch.analytics.exec.join.ShuffleEnrichment.WorkerLevel;
     */
            throw new IllegalStateException(  
            "GeneralShuffleDAGRewriter: stage " + stageId + " join " + side + " input is not a shuffle: " + n.getRelTypeName()
 * distributed join input (even a co-partitioned one — the binary shuffle transport delivers exactly two
        }
            return shuffle;
     * keep their alternatives (the pipeline re-forks everything anyway, but this matches the cascade  
 * So by the time {@code DAGBuilder} cuts at the exchanges, EVERY shuffle-fed join is ALREADY its own stage
 *
 * <p><b>Outer joins.</b> Promotes a join of ANY type over two shuffles — the enforcement pass already
        throw new IllegalStateException(
    private static JoinShuffleInfo analyze(Stage stage) {
        PlanForker.forkAll(rewrittenDag, registry);
    }
                    + stage.getStageId()
                    + info.leftKeys
        // two diverging on a cluster-state change (the "resolve once" rule).
                new WorkerTargetResolver(nodesByStageId.get(stage.getStageId()))
            return;
                    + rightShuffle.getHashKeys()
     * {@link OpenSearchShuffleExchange}, or {@code null} if there is none / more than one. Accepts ANY join  
    private static OpenSearchJoin findJoinOverTwoShuffles(RelNode fragment) {  
        PlanAlternativeSelector.selectAll(rewrittenDag, registry, preferMetadataDriver);  
        final List<Stage> bottomUpRef = bottomUp;
    private static int childStageId(OpenSearchShuffleExchange shuffle) {  
            out.add(join);
    private static void collectJoinShuffleStages(Stage stage, List<Stage> out) {
    /** Per-join-shuffle-stage analysis: producer child stage ids + per-side hash keys + partition count. */  
 *  
     * StageInputScan leaves (lower tiers are separate stages), so there is at most one such join per
 * {@link ShuffleEnrichment#enrichLevels} to attach each level's shuffle producer/scan/worker instructions.  
            throw new IllegalStateException("GeneralShuffleDAGRewriter: stage " + stage.getStageId() + " has no join over two shuffles");
            collectJoinShuffleStages(child, out);  
        // mints a fresh stage id per shuffle-input cut, so even a self-join (a ⋈ a) yields two stages. A
import org.opensearch.analytics.planner.CapabilityRegistry;
 * SPDX-License-Identifier: Apache-2.0
            Stage worker = new Stage(
}  
 * compatible open source license.
     * copied with rebuilt children, preserving its role / exchange info / sink / resolver. Worker stages get
            );  
     * as a {@link Stage.StageRole#SHUFFLE_WORKER} with a {@link WorkerTargetResolver} — keeping its fragment
            throw new IllegalStateException(
    /**
    }
 * Promotes the join-over-two-shuffles stages of the DAG that {@link DistributionEnforcementPass} produces
        }  
    public static Structure rewriteStructure(QueryDAG dag, CapabilityRegistry registry, NodeListResolver nodeResolver) {
 * this file be licensed under the Apache-2.0 license or a
import java.util.ArrayList;
            && RelNodeUtils.unwrapHep(join.getInput(1)) instanceof OpenSearchShuffleExchange) {  
     *  resolved alternative (the DAG was forked before dispatch). */  
        boolean preferMetadataDriver,
     * distributed at least one join, so this rewriter applies. A DAG the size-floor kept fully  
        int rightId = childStageId(rightShuffle);
        copy.setRole(stage.getRole());
        if (dag == null || dag.rootStage() == null) {
        if (workerIds.contains(stage.getStageId())) {
    ) {
        for (Stage s : joinShuffleStages) {  
        if (stage == null) {
        QueryDAG rewrittenDag = structure.dag();  
public final class GeneralShuffleDAGRewriter {
        }
            collect(RelNodeUtils.unwrapHep(input), out);
                "GeneralShuffleDAGRewriter: join-shuffle stage "
        }  
     * Extracts the join's two shuffle inputs' producer stage ids + keys. Defense-in-depth: each side's  
        Structure structure = rewriteStructure(dag, registry, nodeResolver);
    private static Stage rebuild(  
        }
import org.opensearch.analytics.exec.join.DistributionEnforcementPass;  
        // re-run the FULL pipeline" gotcha). adaptAll re-applies scalar-function adaptation forkAll wiped.  
    }  
                    + stage.getStageId()
    }
        }
        }  
    private static void indexStages(Stage stage, Map<Integer, Stage> out) {  
        for (int i = 0; i < bottomUp.size(); i++) {
                    + ")"
import java.util.Collections;  
            worker.setInstructionHandlerFactory(backend.getInstructionHandlerFactory());
            rebuiltChildren,
        CapabilityRegistry registry,
            return levels;
     * worker-tier shape against a mock backend that has no fragment convertor.
    }  
        }
     *  over two {@link OpenSearchShuffleExchange} inputs. */  
                levels.add(new WorkerLevel(worker, leftProducer, rightProducer, d.leftKeys(), d.rightKeys(), d.partitionCount(), nodes));  
        for (Stage child : stage.getChildStages()) {
            stage.getTargetResolver()
        AnalyticsSearchBackendPlugin backend = registry.getBackend(workerBackendId(joinShuffleStages.get(0)));
            stage.getExchangeSinkProvider(),
     * pipeline, and returns the worker levels for instruction enrichment.  
    }
            // The shuffle inputs are StageInputScan leaves — no deeper join-over-two-shuffles in THIS
                Stage leftProducer = rewrittenById.get(d.leftProducerId());  
        if (stage.getInstructionHandlerFactory() != null) {  
        // Per-stage join analysis (keys + producer child ids + partition count), resolved once.
/**
 * IN-PLACE — rebuild each such stage with a {@link WorkerTargetResolver} + worker sink + instruction-handler
        Set<Integer> workerIds,
    }
        }  
            JoinShuffleInfo d = descriptors.get(s.getStageId());
                    + " join's two shuffle inputs resolve to the SAME producer stage "  
        return new JoinShuffleInfo(leftId, rightId, leftShuffle.getHashKeys(), rightShuffle.getHashKeys(), leftShuffle.getPartitionCount());
        Map<Integer, JoinShuffleInfo> descriptors = new HashMap<>();  
        return copy;  
    /** Full result of {@link #rewrite}: the rewritten DAG plus the per-level worker descriptors. */  
     */
            copy.setInstructionHandlerFactory(stage.getInstructionHandlerFactory());
 * named inputs per worker), and it pre-splits a distributed aggregate into {@code FINAL(ER(PARTIAL(...)))}.  
                backend.getExchangeSinkProvider(),
        }
        }
        }  
     * — the enforcement pass guarantees this (it builds each shuffle from the join's per-side keys), but a
            worker.setRole(Stage.StageRole.SHUFFLE_WORKER);
            );
    }  
                    + ", rightShuffle="  
     * True iff the (enforcement-pass) DAG has at least one join-over-two-shuffles stage — i.e. the pass
        );  
    /** Collects join-shuffle stages top-down (parent before child) — a stage whose fragment contains a join
 * established that a hash-partitioned outer/semi/anti join's null-fill / existence test is partition-local  
            return null;
            Map<Integer, Stage> rewrittenById = new HashMap<>();  
     * fragment in the enforced DAG; the uniqueness guard rejects a malformed multi-join fragment rather than  
                // tier) or via the worker sink to the coordinator (top tier); the exchange info itself does
        }  
        final Map<Integer, List<String>> nodesRef = nodesByStageId;  
    /** Result of {@link #rewriteStructure}: the rewritten DAG plus a deferred builder for the per-level  
            return worker;  
    }  
        // original id, so the lookup returns its worker version.
 * (standard Spark/Presto). Worker-side execution of non-INNER tiered hash joins is validated at sf=10.
        if (leftShuffle.getPartitionCount() != rightShuffle.getPartitionCount()) {
     * tier in place, rebuilds the DAG, re-runs the full {@code forkAll → adaptAll → selectAll → convertAll}
        if (node instanceof OpenSearchJoin join
     * Promotes every join-over-two-shuffles stage in {@code dag} to a {@link Stage.StageRole#SHUFFLE_WORKER}
        copy.setPlanAlternatives(stage.getPlanAlternatives());
     */
        }  
        collect(RelNodeUtils.unwrapHep(fragment), found);
 * aggregate (if any) already sitting above it in the SAME stage fragment. Worker promotion is therefore  
        }  
        Stage stage,
        QueryDAG dag,  
        List<Stage> bottomUp = new ArrayList<>(joinShuffleStages);
    private static OpenSearchShuffleExchange asShuffle(RelNode input, int stageId, String side) {
     * Rebuilds {@code stage}'s subtree bottom-up. A join-shuffle stage (id in {@code workerIds}) is rebuilt
        // parent-backend constraint MUST re-run or a child keeps a stray backend (the "DAG rewriters must
        if (!leftShuffle.getHashKeys().equals(info.leftKeys) || !rightShuffle.getHashKeys().equals(info.rightKeys)) {
        }
/*  
import org.opensearch.analytics.exec.join.ShuffleEnrichment;
     *  worker descriptors (built after the caller runs the convert pipeline so non-top stages carry
     */
    public record Rewritten(QueryDAG dag, List<WorkerLevel> levels) {
    /**
        }
        Stage newRoot = rebuild(root, workerIds, nodesByStageId, backend);
     */  
    @FunctionalInterface
        OpenSearchShuffleExchange rightShuffle = asShuffle(join.getInput(1), stage.getStageId(), "right");
    /**
        AnalyticsSearchBackendPlugin backend
        // The binary shuffle transport gives each worker TWO independent producer streams (one sink per
        out.put(stage.getStageId(), stage);
        // index levels bottom-up so the node resolver can hand a distinct list per tier.
        Set<OpenSearchJoin> found = Collections.newSetFromMap(new IdentityHashMap<>());
            out.add(stage);  
    /**  
    }
    ) {
        int partitionCount) {
        if (leftId == rightId) {
 *
     * Returns the UNIQUE {@link OpenSearchJoin} in {@code fragment} whose two inputs are both
                    + " vs "
                    + leftShuffle.getPartitionCount()  
        NodeListResolver nodeResolver  
import org.apache.calcite.rel.core.JoinInfo;
     * rewriter's conservatism).
        return joinShuffleStage.getPlanAlternatives().getFirst().backendId();  
        OpenSearchJoin join = findJoinOverTwoShuffles(stage.getFragment());  
            stage.getStageId(),  
        Map<Integer, List<String>> nodesByStageId = new HashMap<>();
                stage.getStageId(),  
        for (Stage child : stage.getChildStages()) {
import java.util.IdentityHashMap;
        }  
        BackendPlanAdapter.adaptAll(rewrittenDag, registry);
        // sink → the worker's awaitReady never completes for one side → hang. Fail loud (tripwire) rather  
        public List<WorkerLevel> buildLevels() {
            && RelNodeUtils.unwrapHep(join.getInput(0)) instanceof OpenSearchShuffleExchange
            throw new IllegalStateException("GeneralShuffleDAGRewriter: no join-shuffle stage found in DAG");
    private record JoinShuffleInfo(int leftProducerId, int rightProducerId, List<Integer> leftKeys, List<Integer> rightKeys,
        }
        // Resolve each level's target node list EXACTLY ONCE, keyed by stage id, and reuse it for BOTH the
    public record Structure(QueryDAG dag, Supplier<List<WorkerLevel>> levelBuilder) {  
                List<String> nodes = nodesRef.get(s.getStageId());
        // side). The two shuffle inputs MUST therefore be distinct producer stages — DAGBuilder.cutShuffle  
            rebuiltChildren.add(rebuild(child, workerIds, nodesByStageId, backend));
        List<Stage> joinShuffleStages = new ArrayList<>();
        List<Stage> stages = new ArrayList<>();
            return false;
                // not drive shipping. SINGLETON matches the cascade rewriter's intermediate-worker choice.
    private static String workerBackendId(Stage joinShuffleStage) {
import org.apache.calcite.rel.RelNode;
                "GeneralShuffleDAGRewriter: stage "  
 * below a coordinator reduce (the root ER, or {@code FINAL_Agg(ER(...))}), with its {@code PARTIAL}
    }
        Map<Integer, Integer> levelIndex = new HashMap<>();  
        // shared id would make enrichLevels enrich one producer as BOTH "left" and "right" against a single
        return !stages.isEmpty();  
    }
import org.opensearch.analytics.planner.rel.OpenSearchShuffleExchange;
import java.util.HashMap;
        if (stage == null) {
            levelIndex.put(bottomUp.get(i).getStageId(), i);
        // Collect every join-shuffle stage top-down; the order is irrelevant for in-place conversion but we  
                Stage rightProducer = rewrittenById.get(d.rightProducerId());
import java.util.function.Supplier;  
        List<String> resolve(int levelIndex, int partitionCount);  
                    + leftShuffle.getHashKeys()  
import org.opensearch.analytics.planner.RelNodeUtils;
            );
        List<Stage> rebuiltChildren = new ArrayList<>(stage.getChildStages().size());  
        return new Rewritten(rewrittenDag, structure.buildLevels());
        for (Stage child : stage.getChildStages()) {
     */
 *
        // forkAll re-expands alternatives from each fragment (discarding prior selection); selectAll's
        int leftId = childStageId(leftShuffle);  
     * type (the enforcement pass co-partitions outer/semi/anti too). A join-over-two-shuffles' inputs are
        if (join == null) {
     *  resolved plan alternatives). */
    /** Supplies target node ids for a given worker level (one per partition). */  
     * silently promoting one arbitrarily.
        }  
                stage.getFragment(),
        for (Stage s : joinShuffleStages) {
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;  
                rebuiltChildren,
import java.util.Set;
        if (inner instanceof OpenSearchStageInputScan sis) {
        if (joinShuffleStages.isEmpty()) {
        for (RelNode input : node.getInputs()) {  
 * <p>Produces {@link ShuffleEnrichment.WorkerLevel} descriptors; {@link UnifiedDispatch} then calls
 * DAG rewriter for the GENERAL post-CBO scheduler (Option B — see {@code MPP-GENERAL-SCHEDULING-DESIGN.md}).  
        collectJoinShuffleStages(root, joinShuffleStages);  
        Stage copy = new Stage(
            stage.getFragment(),
        // before children), so reverse for bottom-up indexing.  
                    + " rightJoin="
                    + " — the binary shuffle transport requires two distinct producer stages per worker (one sink per side)."
     * their plan alternatives re-forked by the convert pipeline, so we leave them empty; pass-through stages
 * factory, keeping its fragment and children unchanged — with no top-lift and no agg-split surgery. That
        JoinInfo info = join.analyzeCondition();  
    private GeneralShuffleDAGRewriter() {}
    public interface NodeListResolver {
import java.util.Map;
 * The OpenSearch Contributors require contributions made to  
            );
    private static void collect(RelNode node, Set<OpenSearchJoin> out) {  
    }  
        QueryDAG rewrittenDag = new QueryDAG(dag.queryId(), newRoot);  
            // fragment (lower tiers are separate child stages).  
 * keeps the PARTIAL on the worker for free (it runs per-partition, ships {@code SINGLETON} to the FINAL).  
                    + rightShuffle.getPartitionCount()
        return new Structure(rewrittenDag, () -> {
            return sis.getChildStageId();  
                    + ")"  
        Set<Integer> workerIds = descriptors.keySet();
                "GeneralShuffleDAGRewriter: stage "
     * coordinator-centric has none and is dispatched as a plain coordinator query.
        // than hang if a future DAG-shape change ever collapses them. (codex round-3 review.)
        FragmentConversionDriver.convertAll(rewrittenDag, registry);
 * @opensearch.internal  
            throw new IllegalStateException(  
        }
                ExchangeInfo.singleton(),  
                    + " has no plan alternatives (the DAG must be forked/selected before rewrite)"  
                    + stage.getStageId()
    public static Rewritten rewrite(
                // Vestigial: the worker SHIPS via its appended ShuffleProducer instruction (intermediate  
import org.opensearch.analytics.planner.rel.OpenSearchJoin;  
     * shuffle must be partitioned on THIS join's equi keys, and both sides must agree on the partition count
        // are looked up from the rewritten DAG by stage id; an intermediate-worker producer keeps its  
            stage.getExchangeInfo(),  
     * pipeline. Returns the new DAG plus a deferred level builder. Split out so unit tests can validate the
        }  
import org.opensearch.analytics.exec.join.UnifiedDispatch;  
                    + info.rightKeys  
                    + leftId
        throw new IllegalStateException("GeneralShuffleDAGRewriter: shuffle input is not a StageInputScan: " + inner.getRelTypeName());
        Collections.reverse(bottomUp);
            nodesByStageId.put(s.getStageId(), nodeResolver.resolve(levelIndex.get(s.getStageId()), d.partitionCount()));
    public static boolean hasDistributedJoin(QueryDAG dag) {  
        if (fragment == null) {
import org.opensearch.analytics.planner.rel.OpenSearchStageInputScan;
                    + " left/right shuffle partition counts disagree ("
 */  
                    + " leftJoin="
        // Bottom-up level index (deepest = level 0). joinShuffleStages is top-down (collect visits parent
            List<WorkerLevel> levels = new ArrayList<>();
    }
        OpenSearchShuffleExchange leftShuffle = asShuffle(join.getInput(0), stage.getStageId(), "left");
                Stage worker = rewrittenById.get(s.getStageId());
        collectJoinShuffleStages(dag.rootStage(), stages);
        // Deferred level builder — run after the convert pipeline re-creates non-worker stages. Producers
    /**
                JoinShuffleInfo d = descRef.get(s.getStageId());
        });  
 *
                    + " shuffle keys do not match join equi keys (leftShuffle="
        if (findJoinOverTwoShuffles(stage.getFragment()) != null) {
        Stage root = dag.rootStage();
        );  
            return levelBuilder.get();
     * (the join, plus any PARTIAL aggregate above it) and its children (the producers). Every other stage is  
                    + joinShuffleStage.getStageId()
    }
        if (n instanceof OpenSearchShuffleExchange shuffle) {
import java.util.List;  
            );  
            indexStages(rewrittenDag.rootStage(), rewrittenById);
    /** Backend id to drive worker promotion + the convert pipeline. Reads the first join-shuffle stage's
        RelNode inner = RelNodeUtils.unwrapHep(shuffle.getInput());
     * future DAG-shape change must not silently promote a mis-keyed shuffle into a worker.  
        }
            indexStages(child, out);  
 * into worker tiers.
    /**  
            return;  
            for (Stage s : bottomUpRef) {  
     * The structural half of {@link #rewrite}: in-place worker promotion + DAG rebuild WITHOUT the convert  
        return found.size() == 1 ? found.iterator().next() : null;  
        if (joinShuffleStage.getPlanAlternatives().isEmpty()) {
        }  
                "GeneralShuffleDAGRewriter: stage "  
        Map<Integer, List<String>> nodesByStageId,  
            descriptors.put(s.getStageId(), analyze(s));
