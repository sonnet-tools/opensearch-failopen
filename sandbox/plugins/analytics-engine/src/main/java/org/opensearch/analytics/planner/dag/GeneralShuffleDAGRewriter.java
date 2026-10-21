            );
    public record Rewritten(QueryDAG dag, List<WorkerLevel> levels) {
import org.opensearch.analytics.planner.rel.OpenSearchShuffleExchange;
        if (leftShuffle.getPartitionCount() != rightShuffle.getPartitionCount()) {
            collectJoinShuffleStages(child, out);
        }
     */
            return;
    }
            stage.getExchangeInfo(),
        QueryDAG rewrittenDag = structure.dag();
        // original id, so the lookup returns its worker version.
        for (Stage s : joinShuffleStages) {
     * shuffle must be partitioned on THIS join's equi keys, and both sides must agree on the partition count
    }
        OpenSearchShuffleExchange leftShuffle = asShuffle(join.getInput(0), stage.getStageId(), "left");
                    + " join's two shuffle inputs resolve to the SAME producer stage "
    }
        return new JoinShuffleInfo(leftId, rightId, leftShuffle.getHashKeys(), rightShuffle.getHashKeys(), leftShuffle.getPartitionCount());
     * as a {@link Stage.StageRole#SHUFFLE_WORKER} with a {@link WorkerTargetResolver} — keeping its fragment
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
        return !stages.isEmpty();
        RelNode n = RelNodeUtils.unwrapHep(input);
        }
    }
 */
        BackendPlanAdapter.adaptAll(rewrittenDag, registry);
            rebuiltChildren.add(rebuild(child, workerIds, nodesByStageId, backend));
 * keeps the PARTIAL on the worker for free (it runs per-partition, ships {@code SINGLETON} to the FINAL).
    private static String workerBackendId(Stage joinShuffleStage) {
                    + ")"
        collect(RelNodeUtils.unwrapHep(fragment), found);
    private static OpenSearchJoin findJoinOverTwoShuffles(RelNode fragment) {
                // Vestigial: the worker SHIPS via its appended ShuffleProducer instruction (intermediate
     * Extracts the join's two shuffle inputs' producer stage ids + keys. Defense-in-depth: each side's
    public static Rewritten rewrite(
import org.opensearch.analytics.exec.join.ShuffleEnrichment;
        OpenSearchJoin join = findJoinOverTwoShuffles(stage.getFragment());
     * future DAG-shape change must not silently promote a mis-keyed shuffle into a worker.
        if (!leftShuffle.getHashKeys().equals(info.leftKeys) || !rightShuffle.getHashKeys().equals(info.rightKeys)) {
        // Per-stage join analysis (keys + producer child ids + partition count), resolved once.
                // not drive shipping. SINGLETON matches the cascade rewriter's intermediate-worker choice.
            throw new IllegalStateException("GeneralShuffleDAGRewriter: no join-shuffle stage found in DAG");
        // The binary shuffle transport gives each worker TWO independent producer streams (one sink per
        Set<Integer> workerIds,
import org.opensearch.analytics.exec.join.DistributionEnforcementPass;
            }
        copy.setRole(stage.getRole());
            );
     *  resolved plan alternatives). */
import org.apache.calcite.rel.core.JoinInfo;
                    + " — the binary shuffle transport requires two distinct producer stages per worker (one sink per side)."
        }
        return copy;
        // shared id would make enrichLevels enrich one producer as BOTH "left" and "right" against a single
            return false;
        PlanForker.forkAll(rewrittenDag, registry);
     * pipeline. Returns the new DAG plus a deferred level builder. Split out so unit tests can validate the
     * (the join, plus any PARTIAL aggregate above it) and its children (the producers). Every other stage is
     * fragment in the enforced DAG; the uniqueness guard rejects a malformed multi-join fragment rather than
     */
        Collections.reverse(bottomUp);
            out.add(join);
        collectJoinShuffleStages(root, joinShuffleStages);
     * tier in place, rebuilds the DAG, re-runs the full {@code forkAll → adaptAll → selectAll → convertAll}
import java.util.Collections;
            indexStages(child, out);
                    + " shuffle keys do not match join equi keys (leftShuffle="
        }
        }
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
            throw new IllegalStateException(
                backend.getExchangeSinkProvider(),
        Stage stage,
        public List<WorkerLevel> buildLevels() {
     * keep their alternatives (the pipeline re-forks everything anyway, but this matches the cascade
     *  over two {@link OpenSearchShuffleExchange} inputs. */
    }
    /** Collects join-shuffle stages top-down (parent before child) — a stage whose fragment contains a join
        RelNode inner = RelNodeUtils.unwrapHep(shuffle.getInput());
 * Promotes the join-over-two-shuffles stages of the DAG that {@link DistributionEnforcementPass} produces
        if (joinShuffleStage.getPlanAlternatives().isEmpty()) {
            descriptors.put(s.getStageId(), analyze(s));
    @FunctionalInterface
        List<String> resolve(int levelIndex, int partitionCount);
        if (workerIds.contains(stage.getStageId())) {
        // side). The two shuffle inputs MUST therefore be distinct producer stages — DAGBuilder.cutShuffle
     * Promotes every join-over-two-shuffles stage in {@code dag} to a {@link Stage.StageRole#SHUFFLE_WORKER}
        final Map<Integer, List<String>> nodesRef = nodesByStageId;
                // tier) or via the worker sink to the coordinator (top tier); the exchange info itself does
    public record Structure(QueryDAG dag, Supplier<List<WorkerLevel>> levelBuilder) {
     * {@link OpenSearchShuffleExchange}, or {@code null} if there is none / more than one. Accepts ANY join
        Map<Integer, Integer> levelIndex = new HashMap<>();
        }
            return shuffle;
        }
/**
    ) {
    /**
public final class GeneralShuffleDAGRewriter {
 *
    }
                    + stage.getStageId()
 * So by the time {@code DAGBuilder} cuts at the exchanges, EVERY shuffle-fed join is ALREADY its own stage
        // two diverging on a cluster-state change (the "resolve once" rule).
        }
        if (leftId == rightId) {
            indexStages(rewrittenDag.rootStage(), rewrittenById);
 * into worker tiers.
    private record JoinShuffleInfo(int leftProducerId, int rightProducerId, List<Integer> leftKeys, List<Integer> rightKeys,
        // worker's WorkerTargetResolver AND the producer instructions' targets — resolving twice risks the
        }
                    + rightShuffle.getPartitionCount()
 * distributed join input (even a co-partitioned one — the binary shuffle transport delivers exactly two
import org.apache.calcite.rel.RelNode;
    private static void collectJoinShuffleStages(Stage stage, List<Stage> out) {
        }
     * pipeline, and returns the worker levels for instruction enrichment.
        if (stage == null) {
            return;
import java.util.HashMap;
            stage.getExchangeSinkProvider(),
import org.opensearch.analytics.exec.join.UnifiedDispatch;
        Stage root = dag.rootStage();
            Map<Integer, Stage> rewrittenById = new HashMap<>();
            JoinShuffleInfo d = descriptors.get(s.getStageId());
        if (fragment == null) {
        for (int i = 0; i < bottomUp.size(); i++) {
            );
            // The shuffle inputs are StageInputScan leaves — no deeper join-over-two-shuffles in THIS
            for (Stage s : bottomUpRef) {
        Set<Integer> workerIds = descriptors.keySet();
            return levelBuilder.get();
    }
 * aggregate (if any) already sitting above it in the SAME stage fragment. Worker promotion is therefore
                ExchangeInfo.singleton(),
            Stage worker = new Stage(
 *
        int leftId = childStageId(leftShuffle);
                stage.getStageId(),
 * established that a hash-partitioned outer/semi/anti join's null-fill / existence test is partition-local
            return worker;
            return levels;
     * their plan alternatives re-forked by the convert pipeline, so we leave them empty; pass-through stages
        AnalyticsSearchBackendPlugin backend = registry.getBackend(workerBackendId(joinShuffleStages.get(0)));
            levelIndex.put(bottomUp.get(i).getStageId(), i);
        if (dag == null || dag.rootStage() == null) {
        final List<Stage> bottomUpRef = bottomUp;
        out.put(stage.getStageId(), stage);
    /**
        CapabilityRegistry registry,
        int rightId = childStageId(rightShuffle);
                    + stage.getStageId()
                    + " vs "
                    + stage.getStageId()
        }
                Stage rightProducer = rewrittenById.get(d.rightProducerId());
 * <p>Produces {@link ShuffleEnrichment.WorkerLevel} descriptors; {@link UnifiedDispatch} then calls
import java.util.Map;
            rebuiltChildren,
            throw new IllegalStateException(
    private static void indexStages(Stage stage, Map<Integer, Stage> out) {
        }
     * coordinator-centric has none and is dispatched as a plain coordinator query.
            // fragment (lower tiers are separate child stages).
        Map<Integer, JoinShuffleInfo> descriptors = new HashMap<>();
            worker.setInstructionHandlerFactory(backend.getInstructionHandlerFactory());
                rebuiltChildren,
     */
    /**
import org.opensearch.analytics.planner.RelNodeUtils;
        QueryDAG dag,
import org.opensearch.analytics.planner.CapabilityRegistry;
 * (standard Spark/Presto). Worker-side execution of non-INNER tiered hash joins is validated at sf=10.
        if (stage.getInstructionHandlerFactory() != null) {
import java.util.ArrayList;
        Stage copy = new Stage(
        List<Stage> rebuiltChildren = new ArrayList<>(stage.getChildStages().size());
        // Resolve each level's target node list EXACTLY ONCE, keyed by stage id, and reuse it for BOTH the
        // are looked up from the rewritten DAG by stage id; an intermediate-worker producer keeps its
 *
        }
        // than hang if a future DAG-shape change ever collapses them. (codex round-3 review.)
        int partitionCount) {
            worker.setRole(Stage.StageRole.SHUFFLE_WORKER);
     *  worker descriptors (built after the caller runs the convert pipeline so non-top stages carry
     * Rebuilds {@code stage}'s subtree bottom-up. A join-shuffle stage (id in {@code workerIds}) is rebuilt
import java.util.Set;
        final Map<Integer, JoinShuffleInfo> descRef = descriptors;
     * — the enforcement pass guarantees this (it builds each shuffle from the join's per-side keys), but a
        // re-run the FULL pipeline" gotcha). adaptAll re-applies scalar-function adaptation forkAll wiped.
        Map<Integer, List<String>> nodesByStageId = new HashMap<>();
    /**
        }
 * named inputs per worker), and it pre-splits a distributed aggregate into {@code FINAL(ER(PARTIAL(...)))}.
    ) {
        // Collect every join-shuffle stage top-down; the order is irrelevant for in-place conversion but we
 * The OpenSearch Contributors require contributions made to
                    + " rightJoin="
        );
        JoinInfo info = join.analyzeCondition();
     * type (the enforcement pass co-partitions outer/semi/anti too). A join-over-two-shuffles' inputs are
    }
        }
 * SPDX-License-Identifier: Apache-2.0
            "GeneralShuffleDAGRewriter: stage " + stageId + " join " + side + " input is not a shuffle: " + n.getRelTypeName()
    private static Stage rebuild(
                Stage worker = rewrittenById.get(s.getStageId());
                    + leftId
 * factory, keeping its fragment and children unchanged — with no top-lift and no agg-split surgery. That
    public static Structure rewriteStructure(QueryDAG dag, CapabilityRegistry registry, NodeListResolver nodeResolver) {
        AnalyticsSearchBackendPlugin backend
        for (Stage child : stage.getChildStages()) {
                new WorkerTargetResolver(nodesByStageId.get(stage.getStageId()))
        }
            collect(RelNodeUtils.unwrapHep(input), out);
    }
 * <p><b>Outer joins.</b> Promotes a join of ANY type over two shuffles — the enforcement pass already
            stage.getTargetResolver()
    /** Full result of {@link #rewrite}: the rewritten DAG plus the per-level worker descriptors. */
                    + info.rightKeys
        );
        if (join == null) {
    private static JoinShuffleInfo analyze(Stage stage) {
        // mints a fresh stage id per shuffle-input cut, so even a self-join (a ⋈ a) yields two stages. A
                    + info.leftKeys
        FragmentConversionDriver.convertAll(rewrittenDag, registry);
        return new Rewritten(rewrittenDag, structure.buildLevels());
     * Returns the UNIQUE {@link OpenSearchJoin} in {@code fragment} whose two inputs are both
        List<Stage> stages = new ArrayList<>();
        if (inner instanceof OpenSearchStageInputScan sis) {
        });
import org.opensearch.analytics.planner.rel.OpenSearchStageInputScan;
     */
        for (Stage s : joinShuffleStages) {
     * True iff the (enforcement-pass) DAG has at least one join-over-two-shuffles stage — i.e. the pass
                "GeneralShuffleDAGRewriter: stage "
            return sis.getChildStageId();
                "GeneralShuffleDAGRewriter: stage "
                    + " left/right shuffle partition counts disagree ("
    }
            && RelNodeUtils.unwrapHep(join.getInput(1)) instanceof OpenSearchShuffleExchange) {
package org.opensearch.analytics.planner.dag;
    }
            );
        // index levels bottom-up so the node resolver can hand a distinct list per tier.
            List<WorkerLevel> levels = new ArrayList<>();
            throw new IllegalStateException(
        }
            throw new IllegalStateException("GeneralShuffleDAGRewriter: stage " + stage.getStageId() + " has no join over two shuffles");
        Set<OpenSearchJoin> found = Collections.newSetFromMap(new IdentityHashMap<>());
    /** Result of {@link #rewriteStructure}: the rewritten DAG plus a deferred builder for the per-level
        return found.size() == 1 ? found.iterator().next() : null;
    }
                Stage leftProducer = rewrittenById.get(d.leftProducerId());
 * @opensearch.internal
    /**
    /** Supplies target node ids for a given worker level (one per partition). */
        }
                    + ")"
     * The structural half of {@link #rewrite}: in-place worker promotion + DAG rebuild WITHOUT the convert
        }
        // before children), so reverse for bottom-up indexing.
        if (node instanceof OpenSearchJoin join
        QueryDAG rewrittenDag = new QueryDAG(dag.queryId(), newRoot);
        }
        for (Stage child : stage.getChildStages()) {
        // Bottom-up level index (deepest = level 0). joinShuffleStages is top-down (collect visits parent
    }
    /** Backend id to drive worker promotion + the convert pipeline. Reads the first join-shuffle stage's
        List<Stage> joinShuffleStages = new ArrayList<>();
import java.util.IdentityHashMap;
    }
 * <p><b>In-place worker promotion.</b> The enforcement pass does binary-tier lowering: it shuffles every
     */
        for (RelNode input : node.getInputs()) {
            return null;
        // parent-backend constraint MUST re-run or a child keeps a stray backend (the "DAG rewriters must
            nodesByStageId.put(s.getStageId(), nodeResolver.resolve(levelIndex.get(s.getStageId()), d.partitionCount()));
 * compatible open source license.
            copy.setInstructionHandlerFactory(stage.getInstructionHandlerFactory());
        Stage newRoot = rebuild(root, workerIds, nodesByStageId, backend);
     * distributed at least one join, so this rewriter applies. A DAG the size-floor kept fully
                    + " leftJoin="
        // sink → the worker's awaitReady never completes for one side → hang. Fail loud (tripwire) rather
        if (joinShuffleStages.isEmpty()) {
        }
     *  resolved alternative (the DAG was forked before dispatch). */
 * {@link ShuffleEnrichment#enrichLevels} to attach each level's shuffle producer/scan/worker instructions.
import java.util.function.Supplier;
                    + joinShuffleStage.getStageId()
                List<String> nodes = nodesRef.get(s.getStageId());
        NodeListResolver nodeResolver
        PlanAlternativeSelector.selectAll(rewrittenDag, registry, preferMetadataDriver);
import java.util.List;
                    + ", rightShuffle="
    }
 * below a coordinator reduce (the root ER, or {@code FINAL_Agg(ER(...))}), with its {@code PARTIAL}
        }
     * worker-tier shape against a mock backend that has no fragment convertor.
 */
        throw new IllegalStateException("GeneralShuffleDAGRewriter: shuffle input is not a StageInputScan: " + inner.getRelTypeName());
        }
        boolean preferMetadataDriver,
        if (findJoinOverTwoShuffles(stage.getFragment()) != null) {
        }
                "GeneralShuffleDAGRewriter: join-shuffle stage "
        if (stage == null) {
}
    }
        throw new IllegalStateException(
        OpenSearchShuffleExchange rightShuffle = asShuffle(join.getInput(1), stage.getStageId(), "right");
        for (Stage child : stage.getChildStages()) {
     */
            stage.getFragment(),
        copy.setPlanAlternatives(stage.getPlanAlternatives());
/*
                stage.getFragment(),
 *
 * this file be licensed under the Apache-2.0 license or a
    private static int childStageId(OpenSearchShuffleExchange shuffle) {
        List<Stage> bottomUp = new ArrayList<>(joinShuffleStages);
 * DAG rewriter for the GENERAL post-CBO scheduler (Option B — see {@code MPP-GENERAL-SCHEDULING-DESIGN.md}).
                JoinShuffleInfo d = descRef.get(s.getStageId());
    public interface NodeListResolver {
            return;
                levels.add(new WorkerLevel(worker, leftProducer, rightProducer, d.leftKeys(), d.rightKeys(), d.partitionCount(), nodes));
                    + " has no plan alternatives (the DAG must be forked/selected before rewrite)"
        return new Structure(rewrittenDag, () -> {
    private static OpenSearchShuffleExchange asShuffle(RelNode input, int stageId, String side) {
            && RelNodeUtils.unwrapHep(join.getInput(0)) instanceof OpenSearchShuffleExchange
                    + leftShuffle.getHashKeys()
            stage.getStageId(),
     * silently promoting one arbitrarily.
    public static boolean hasDistributedJoin(QueryDAG dag) {
                    + rightShuffle.getHashKeys()
     * rewriter's conservatism).
    /** Per-join-shuffle-stage analysis: producer child stage ids + per-side hash keys + partition count. */
        Structure structure = rewriteStructure(dag, registry, nodeResolver);
    /**
            );
import org.opensearch.analytics.exec.join.ShuffleEnrichment.WorkerLevel;
                "GeneralShuffleDAGRewriter: stage "
            out.add(stage);
        // Deferred level builder — run after the convert pipeline re-creates non-worker stages. Producers
        return joinShuffleStage.getPlanAlternatives().getFirst().backendId();
 *
     * copied with rebuilt children, preserving its role / exchange info / sink / resolver. Worker stages get
        Map<Integer, List<String>> nodesByStageId,
        collectJoinShuffleStages(dag.rootStage(), stages);
     * StageInputScan leaves (lower tiers are separate stages), so there is at most one such join per
        // forkAll re-expands alternatives from each fragment (discarding prior selection); selectAll's
    private static void collect(RelNode node, Set<OpenSearchJoin> out) {
 * IN-PLACE — rebuild each such stage with a {@link WorkerTargetResolver} + worker sink + instruction-handler
        if (n instanceof OpenSearchShuffleExchange shuffle) {
            throw new IllegalStateException(
    private GeneralShuffleDAGRewriter() {}
                    + leftShuffle.getPartitionCount()
