 * this file be licensed under the Apache-2.0 license or a
    private final long minRows;
     * Splits a {@code SINGLE} aggregate over a (now-distributed) input into
                if (RelNodeUtils.unwrapHep(n.getInput(i)) instanceof OpenSearchBroadcastExchange) {
     * Visit carrying {@code demand} (the parent's required distribution for this subtree, top-down) and
        }
     * Keeping the Project with its consumer reproduces the single-fragment shape the coordinator-centric /
     * {@code rel}'s stale CBO trait and would skip the ER for a rel the pass actually left partitioned.
        // 3a-pre. Row-transparent passthrough (Project/Filter with no requirement of its own): pass the
        }
        // `sort SearchPhrase | head 10` over 10M rows, 51ms (mpp off) vs 5391ms (mpp on).
     * Gathers {@code rel} to SINGLETON like {@link #gatherIfNeeded}, but sinks the reducer BELOW any leading
        // DistributionAware, so without this branch it falls to the step-3 non-aware handling, which
            // no requirement and has no derivable output distribution — a parent that needs partitioning will
                RelNode landed = gatherIfNeeded(childContent, childDist);
            AggregateMode.FINAL,
        // broadcast alternative for this join, one input arrives wrapped in an OpenSearchBroadcastExchange
            finalExtraLiterals,
                Visited child = visit(n.getInput(0), null);
public final class DistributionEnforcementPass {
        // Force the ER between PARTIAL and FINAL. buildReducer (not buildEnforcer): the PARTIAL was built
     * Places the gather reducer below any leading row-transparent {@link OpenSearchProject} chain (see
        // came back partitioned this isn't the broadcast-probe shape — fall through to normal shuffle handling.
 * gathers and runs coordinator-centric while distributed JOINS are unaffected.
                LOGGER.debug("enforce: {} input {} → SINGLETON gather", n.getRelTypeName(), i);
    private final OpenSearchDistributionTraitDef traitDef;
                }
    }
                int probeIdx = buildIdx == 0 ? 1 : 0;
        // "reduce-then-shuffle" producer, so if EITHER join input is non-shippable we do NOT distribute
            return visit(((RelNode) n).getInput(0), demand);
            // own parallel split is suppressed. Default true → byte-identical to the split path (q5/q10).
            partialCalls,
        if (partitionCount <= 1) {
        // `where … | sort … | head N`. Keep the QTF ER intact and report SINGLETON.
 * The OpenSearch Contributors require contributions made to
        // (The transparent-passthrough Project/Filter ride is handled BEFORE the child loop, in step 3a-pre,
 *
        return dist != null && dist.getLocality() == OpenSearchDistribution.Locality.SHARD;
        return traitDef.buildReducer(root.rel);
        // 2. Leaf scan: its trait carries the actual (SHARD) distribution; nothing to enforce below.
        boolean shuffleAggregateEnabled
 * re-makes: it recurses into the exchange's input to recover the input's CONTENT and derived distribution,
        // content runs as a SHARD_FRAGMENT (shard-local scan/filter/project chain) or is itself an
            // requiredInputDistribution is null) keeps its literal-arg Projects in its own fragment: sink the
 * the child returns. This is why a filtered scan feeding a join stays shard-local and an intermediate
        // - A PARTIAL aggregate RIDES its child's distribution (runs shard-local on the partitioned input),
            if (shuffleAggregateEnabled && isPartitioned(childDist)) {
     * consumer (the aggregate / sort / window that triggered the gather), rather than being stranded in the
            // Calcite-declared type may differ from the backend runtime type) stays with this op in the reduce
            Visited child = visit(reducer.getInput(0), demand);
 * does not {@code satisfy()} it. A co-partitioned child needs no exchange — so the multi-tier cascade,
        // 3. Recurse into children. Each child's demand is derived below per operator; for the recursion
    }
                if (!isPartitioned(cd) && !isShardLocal(cd)) {
        List<AggregateCall> finalCalls = FinalAggCallBuilder.buildFinalCalls(
     */
import org.opensearch.analytics.planner.rules.OpenSearchAggregateSplitRule;
        // INCOMING demand straight down to the child and RIDE whatever the child returns. This is the
        // Project/Filter — so it correctly falls through to step 3b's gather → coordinator-centric.)
     * gathered to {@code COORDINATOR+SINGLETON} (the query result lands on the coordinator). When the pass
     * reusing an already-HASH child in place would collapse N joins into one fragment with N shuffle leaves,
     * reducer via {@code buildReducer} — NOT {@code buildEnforcer}, whose satisfies() check trusts
        // and count-state index errors).
        // join) also falls through to the non-aware handling.
        OpenSearchDistributionTraitDef traitDef,
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
            for (int i = 0; i < n.getInputs().size(); i++) {
        return null;
        // the coordinator. This is the right shape — the bottom-up walk must NOT relocate that exchange.
     * gathers the partials to the coordinator, so the result is SINGLETON.
                        ? gatherSinkingProjects(childContents.get(i), childDists.get(i))
        // input whose tracked distribution is COORDINATOR+SINGLETON is a GATHERED sub-stage (a
        // coordinator-centric) so small joins/aggregates keep CBO's cheap coord-centric choice — the same
            OpenSearchDistribution required = aware.requiredInputDistribution(i, partitionCount, traitDef);
     * Returns {@code plan} with exchanges re-placed by the distribution algebra. The root's result is
            return rel;
        }
 */
            RelNode rebuilt = copyWithInputs(n, regathered);
 * "is the child partitioned or shard-local?" heuristic. Only transparent ops and the root gather consume
            }
            }
     */
        }
        long max = 0L;
        boolean changed = newInputs.size() != node.getInputs().size();
        }
        RelNode plan,
                RelNode enforced = forceShuffle(isTierBoundary, childContent, required);
        // exactly TWO named shuffle inputs per worker (left/right buffer slices — ShuffleScanInstructionNode
        // Peeling it and letting a parent re-gather via buildReducer() (which uses the 4-arg ctor) drops
        List<OpenSearchDistribution> childDists = new ArrayList<>(n.getInputs().size());
            agg.getAggCallList(),
 * <p><b>Demand flows DOWN, actual flows UP (the Presto {@code AddExchanges} shape).</b> {@link #visit} is a
            if (!isTierBoundary && childDist != null && childDist.satisfies(required)) {
                enforcedChildDists.add(landed == childContent ? childDist : traitDef.coordSingleton());
 * {@code FinalAggCallBuilder} machinery): when an aggregate's child is already distributed, PARTIAL rides
     */
        // late-materialization rewriter rebuilt it to DECLARE the coord-side `___ugsi` column that
import java.util.List;
    }
            }
                }
        );
        // cost model picked the two-phase aggregate, it emits FINAL(ExchangeReducer(PARTIAL(input))): the
     */
     * q3 fix: a filtered scan feeding a join must remain a shard producer, not become a coordinator reduce.)
            partialInput
    /**
     *       arg as a plain {@code StageInputScan} column, not a literal → "APPROX_PERCENTILE_CONT must be a
        if (actual != null && actual.satisfies(traitDef.coordSingleton())) {
        return sinkReducerBelowProjects(rel);
        // (the common case — its top op gathered), no enforcer is added; otherwise gather it.
     *
     *                       same gate the legacy rewriters apply). {@code <= 0} disables the floor.
    }
        // top-down demand-flow; a transparent op directly under the root passes it through so its child
        }
                enforcedChildDists.add(landed == childContent ? childDist : traitDef.coordSingleton());
        // EXCEPTION: an ER carrying a QTF overrideRowType is NOT a plain CBO enforcement decision — the
                // fully-gathered input) over a distributed child must be GATHERED. Force buildReducer from the
        OpenSearchDistributionTraitDef traitDef,
     *       backend's runtime type (e.g. {@code eval r = round(int)} — Calcite infers INTEGER, DataFusion's
            agg.getCallAnnotations(),
     * {@code buildEnforcer} so a genuinely co-partitioned unary child rides on its child's worker with no
 *
        // this join — gather both inputs and run it coordinator-centric (correct, the legacy fallback).
        // sink and CANNOT ship a shuffle → the worker awaits a producer that never fires
    private static final Logger LOGGER = LogManager.getLogger(DistributionEnforcementPass.class);
        // A NON-decomposable SINGLE aggregate never reaches that branch — it is an OpenSearchAggregate, not a
import org.opensearch.analytics.planner.rel.OpenSearchProject;
        return new Visited(rebuilt, out);
        // derived from the algebra, not a special case: a transparent op preserves rows, so its child's
                // HASH only in Visited), so buildEnforcer sees from=coordSingleton ⊭ HASH and inserts the
    }
        // - child NOT distributed (bare scan) → distributing the aggregate itself would need a group-key
        }
                // PARTITIONED child was already handled by the step-3a fast path, which rides on the child's
            int buildIdx = -1;
        // whose consumer is the PARTIAL — a NON-join shuffle edge that GeneralShuffleDAGRewriter (joins-only)
        if (n instanceof OpenSearchTableScan) {
            // stage instead of being stranded below the cut, where its declared StageInputScan type would
            return new Visited(copyWithInputs(n, List.of(gathered)), traitDef.coordSingleton());
            // Not distribution-aware (e.g. OpenSearchSort): rebuild over the (peeled) children, but it imposes
        OpenSearchAggregate finalAgg = new OpenSearchAggregate(
     *       {@code round} returns FLOAT64) is fine within one fragment, but once it crosses a cut the
                newInputs.add(enforced);
        // decide on the child's tracked partitioning before the generic per-input enforcement, and it never
        // consumer fragment. There is NO willFeedJoin / shape gate: UnifiedDispatch resolves broadcast by
                // Join input (always) or a non-co-partitioned unary input with a HASH requirement:
        // producer subtree (q17) both run — the broadcast is just an instruction, never a second stage role.
        // shuffle + a single-input agg worker tier, which the general dispatch does NOT yet drive. Rather
 * then the parent re-enforces its own requirement on that content. The root keeps its final SINGLETON
        // 3a-agg. PRESERVE a CBO-emitted PARTIAL/FINAL split that is already correctly placed. When CBO's
            OpenSearchDistribution childDist = childDists.get(0);
        // the generic step-4 enforcement so its shuffle is preserved, not collapsed to a reducer here.
import java.util.ArrayList;
        // that consumes this node will re-enforce its own requirement, re-inserting an exchange only if
     * satisfies the required hash (a lower join CBO itself shuffled, so its traitSet carries HASH) — so
            // demand its own exchange. Re-gather each child to SINGLETON so a non-aware op still sees
        boolean rowTransparent = (n instanceof OpenSearchProject || n instanceof OpenSearchFilter) && n.getInputs().size() == 1;
                regathered.add(gatherSinkingProjects(childContents.get(i), childDists.get(i)));
                // TRACKED distribution — NOT buildEnforcer/forceShuffle, whose satisfies() check trusts the
        // filtered-scan-stays-shard-local case (demand flows to the scan, which stays SHARD) AND the
                List<RelNode> regathered = new ArrayList<>(childContents.size());
            for (int i = 0; i < newInputs.size(); i++) {
     *   <li><b>Computed-column type drift.</b> A Project column whose Calcite-declared type differs from the
        // 3c. SINGLE decomposable aggregate — Variant A (NO group-key shuffle), mirroring the legacy
        // re-gathers its peeled PARTIAL to SINGLETON, re-inserting the reducer BETWEEN them so DAGBuilder
            // operators gather their inputs plainly.
            for (int i = 0; i < childContents.size(); i++) {
        boolean isTierBoundary = n instanceof OpenSearchJoin;
        // gate the legacy rewriters apply. A distributable op with no requirement on any input (pure-theta
            boolean allInputsShippable = true;
     * above the reducer, and inserts the reducer at the first non-Project node.
        for (RelNode input : n.getInputs()) {
     */
            return new Visited(rebuilt, traitDef.coordSingleton());
                return dist;
        boolean imposesRequirement = false;
    public static RelNode enforce(
                return splitAggregate(agg, childContent);
    private static OpenSearchDistribution distributionOf(RelNode rel) {
     * {@link DistributionAware} operator, derives each input's own demand and enforces it. A row-transparent
 * @opensearch.internal
            return root.rel;
        OpenSearchAggregate partial = new OpenSearchAggregate(
                    allInputsShippable = false;
        // 4. DistributionAware: enforce each input's required distribution.
            }
            }
    /**
                return new Visited(rebuilt, child.actualDistribution);
        }
        long minRows,
            Visited child = visit(n.getInput(0), demand);
        // (ANY) demand to recover each child's content + actual distribution, then enforce per-input demands
import org.opensearch.analytics.planner.rel.DistributionAware;
        // sees the SINGLETON demand (matching the prior behavior where the root gather handled it).
        // trusts root.rel's stale CBO coordSingleton trait and would wrongly insert no ER (e.g. a top join
            RelNode child = RelNodeUtils.unwrapHep(project.getInput(0));
     * DAGBuilder cuts the child into its own binary producer stage. The binary shuffle transport delivers
        OpenSearchDistribution coordSingleton = traitDef.coordSingleton();
        if (n instanceof OpenSearchAggregate cboAgg) {
    private static boolean isShardLocal(OpenSearchDistribution dist) {
        // (`ShuffleScanHandler timed out for input-N`). The general dispatch does not yet drive a
        // - child already distributed (a join/cascade below) → split: PARTIAL rides on the child's worker
        // shape DistributedAggregateRewriter expects to retype the HLL state column). The FINAL branch is
            agg.getGroupSets(),
import org.apache.logging.log4j.Logger;
     * <p>Two failures this prevents, both from a Project landing below the cut while its consumer lands above:
            OpenSearchDistribution childDist = childDists.get(i);
            gathered.getTraitSet().replace(traitDef.coordSingleton()),
import java.util.Map;
                return new Visited(rebuilt, traitDef.coordSingleton());
                    break;
        if (actual != null && actual.satisfies(traitDef.coordSingleton())) {
 * the incoming demand; joins/aggregates derive their children's demands internally.
                }
        return traitDef.buildReducer(rel);
                    return new Visited(rebuilt, childDists.get(probeIdx));
        // that declaration, so DatafusionReduceSink's schema validation then rejects the batch:
            for (int i = 0; i < childContents.size(); i++) {
     * mpp-off path produces, where neither mismatch can arise.
        if (n instanceof OpenSearchSort perPartitionSort && perPartitionSort.isPerPartition()) {
    /**
                    regathered.add(gatherIfNeeded(childContents.get(i), childDists.get(i)));
     * coordinator is semantically identical and merely ships a few extra columns). The descent stops at the
            List<RelNode> regathered = new ArrayList<>(childContents.size());
                enforcedChildDists.add(required);
        // (no exchange), FINAL gathers. This is the q5/q10 shape and works for group-key == OR != the
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
     * @param minRows        size floor: an operator is distributed only when its larger scan subtree
        RelNode rebuilt = copyWithInputs(n, newInputs);
 * depth / key pattern / tree shape, with no per-shape code.
            && agg.getMode() == AggregateMode.SINGLE
import org.opensearch.analytics.planner.rel.AggregateMode;
                // inputs, so a plain gather is correct.)
     * True iff {@code dist} is SHARD-resident (a table scan or shard-local filter/project output, before any
                RelNode rebuilt = copyWithInputs(n, List.of(gatheredPartial));
     * than gathering — so a parent join can hash-ship it from the shards via a SHARD-FRAGMENT producer. (The
                RelNode rebuilt = copyWithInputs(n, List.of(child.rel));
 * (its cost gate knows only 3 fixed localities), so the CBO output is the degenerate "gather everything"
        for (int i = 0; i < childContents.size(); i++) {
    /** Result of visiting a node: the (possibly rewritten) rel and the distribution it actually outputs. */
    /**
            agg.getCluster(),
        // broadcast whose output feeds a shuffle join (q3/q8/q9) and a broadcast build that is itself a
    private Visited splitAggregate(OpenSearchAggregate agg, RelNode partialInput) {
            Visited v = visit(input, null);
            return new Visited(rebuilt, traitDef.coordSingleton());
                LOGGER.debug("enforce: join {} has a non-shippable (gathered sub-stage) input → coord-centric", n.getRelTypeName());
                        : gatherIfNeeded(childContents.get(i), childDists.get(i))
     * makes no change (no distributable operator), the original plan is returned.
        if (n instanceof OpenSearchTableScan scan) {
        List<AggregateCall> partialCalls = OpenSearchAggregateSplitRule.repairLossyReturnTypes(agg.getAggCallList(), partialInput);
import org.opensearch.analytics.planner.RelNodeUtils;
 * Replaces the enumerated shape-matchers ({@code CascadeShufflePlanRewriter},
        RelNode n = RelNodeUtils.unwrapHep(node);
            RelNode rebuilt = copyWithInputs(reducer, List.of(child.rel));
     * exchange). A transparent op over a shard-local child rides on the shards (stays shard-local) rather
/**
        // consumes it (shard leaf, shuffle producer, or worker), then dispatches the broadcast-free DAG. So a
}
    }
        // Binary-tier lowering: a JOIN is a worker-tier boundary. The hash-shuffle transport delivers
import org.opensearch.analytics.planner.dag.DistributedAggregateRewriter.FinalAggCallBuilder;
        // distribution IS its output, and its child's demand IS its own incoming demand. Covers BOTH the q3
        OpenSearchDistribution out = aware.deriveOutputDistribution(enforcedChildDists, traitDef);
            if (cboAgg.getMode() == AggregateMode.FINAL && RelNodeUtils.unwrapHep(n.getInput(0)) instanceof OpenSearchExchangeReducer) {
        // (OpenSearchSortPushdownRewriter for the non-aggregate `sort … | head N`, OpenSearchTopKRewriter
        // decomposable PARTIAL doesn't care whether rows are partitioned by join-key or group-key — only the
                    joinInputs.add(buildIdx == 0 ? newBuild : childContents.get(probeIdx));
            agg.getViableBackends(),
     * first non-Project — a Filter, scan, join, or exchange — placing the reducer there; a Filter thus stays
            RelNode rebuilt = copyWithInputs(n, List.of(child.rel));
            }
            boolean isAggregate = n instanceof OpenSearchAggregate;
     * @param partitionCount resolved shuffle partition count; {@code <= 1} disables the pass (returns plan)
        // rides-the-lower-worker cases without the old "is the child partitioned-or-shard-local?" heuristic.
        // HASH(groupKeys) requirement here. Doing so (the bug codex found) inserts a group-key re-shuffle
     * which the transport cannot run. For a non-tier (unary) input we go through the satisfies-gated
    private RelNode gatherSinkingProjects(RelNode rel, OpenSearchDistribution actual) {
        );
            }
        //
            max = Math.max(max, subtreeMaxScanRows(input));
 * the child's worker and FINAL gathers to the coordinator (the q5/q10 shape). This split is the sole
        }
        // stage — DAGBuilder then never cuts the worker boundary.
                for (int i = 0; i < childContents.size(); i++) {
                    List<RelNode> joinInputs = new ArrayList<>(2);
 * agg-over-join, and scalar-subquery shapes all emerge from the {@code satisfies()} algebra, for any join
        // scoped to a child ExchangeReducer ON PURPOSE: a FINAL over a SHUFFLE exchange (a worker-tier
            // An aggregate that gathers here (e.g. a non-decomposable percentile, whose
                    isAggregate
 * plan. This pass walks that plan and, for each {@link DistributionAware} operator, asks each
        for (int i = 0; i < rel.getTraitSet().size(); i++) {
        // ShardFragmentStageExecution appends at runtime, together with the matching FieldStorageInfo.
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
                    break;
        }
                // Calcite-declared type may differ from the backend's runtime type) stays in the consumer's
        }
        }
     * child stage when {@code DAGBuilder} cuts at the reducer.
                // inter-tier shuffle.
import org.opensearch.analytics.planner.rel.OpenSearchSort;
     * returning the rewritten subtree plus the distribution it actually outputs (bottom-up). Peels a CBO
     */
            agg.getGroupSets(),
    ) {
        Visited root = pass.visit(plan, traitDef.coordSingleton());
            AggregateMode.PARTIAL,
        // exactly like a row-transparent op: do not gather its input (that would defeat the split and
            RelNode childContent = childContents.get(i);
    /**
        );
import org.opensearch.analytics.planner.rel.OpenSearchBroadcastExchange;
        // honors the aggregate's HASH(groupKeys) requirement. See step 3c.)
                    changed = true;
        RelNode n = RelNodeUtils.unwrapHep(node);
    private final boolean shuffleAggregateEnabled;
        int partitionCount,
package org.opensearch.analytics.exec.join;
     * — the same {@link OpenSearchAggregateSplitRule#repairLossyReturnTypes} on PARTIAL, the same
 * <p><b>Why this generalizes.</b> Bottom-up Volcano gathers every join to {@code COORDINATOR+SINGLETON}
        // Gated to a SHARD-local probe: a CBO broadcast plan always keeps the probe SHARD-local; if the probe
    }
        }
        return changed ? node.copy(node.getTraitSet(), newInputs) : node;
 * Presto's {@code InternalPlanVisitor<PlanWithProperties, PreferredProperties>}. A {@code DistributionAware}
                newInputs.add(landed);
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
                // when the child is genuinely already SINGLETON. The reducer is sunk BELOW any leading
        if (!imposesRequirement || (!anyChildDistributed && !aboveFloor)) {
                // would clash with the gathered data (the round() Int32-vs-Float64 substrait mismatch).
        // distributed (a deeper op cleared the floor; keep the cascade going), or this operator's own scan
        if (n instanceof OpenSearchJoin) {
     *       {@code StageInputScan} declares the stale Calcite type while the gathered data carries the
     */
import org.opensearch.analytics.spi.AggregateFunction.IntermediateField;
                break;
        // SINGLETON requirement (requiredInputDistribution != null), so it is handled by the generic step 4.
    }
     * Enforces {@code required} (a WORKER+HASH demand) on {@code childContent}. At a JOIN tier boundary the
            RelNode rebuilt = copyWithInputs(n, regathered);
            && aware.requiredInputDistribution(0, partitionCount, traitDef) != null) {
        if (n instanceof OpenSearchExchangeReducer || n instanceof OpenSearchShuffleExchange || n instanceof OpenSearchBroadcastExchange) {
        // inner content. Re-emit the SAME Join(BroadcastExchange(build), probe) shape rather than peeling it
            agg.getViableBackends(),
        // never promotes/wires → hang. Instead:
            return copyWithInputs(project, List.of(sinkReducerBelowProjects(child)));
        Map<Integer, List<RexLiteral>> finalExtraLiterals = OpenSearchAggregateSplitRule.captureLiteralArgsForFinal(
            childDists.add(v.actualDistribution);
        }
    }
 * <p><b>Aggregate split.</b> Besides placing exchanges, the pass performs the {@code Aggregate}
            RelNode childContent = childContents.get(0);
 *
        // leave the FINAL reading raw rows where it expects partial state → the HLL Utf8View→Binary cast
        // fragment a bare scan streaming EVERY row to the coordinator. Measured cost of getting this wrong:
    private record Visited(RelNode rel, OpenSearchDistribution actualDistribution) {
     *       directly below the aggregate. Stranding that Project makes the reduce fragment see the percentile
        List<OpenSearchDistribution> enforcedChildDists = new ArrayList<>(childContents.size());
     * The cascade-continuation signal is specifically a worker-side hash distribution flowing up.
        // cuts the PARTIAL into its own shard stage and the FINAL's input becomes a StageInputScan (the
                LOGGER.debug("enforce: {} input {} → {}{}", n.getRelTypeName(), i, required, isTierBoundary ? " (tier boundary)" : "");
        // no extra shuffle). Eliminating the inter-tier shuffle for genuinely co-partitioned tiers is a
            intermediateFields,
    }
            }
        // Root demand is SINGLETON — the query result must land on the coordinator. This seeds the
                    // parent gathers it to the coordinator (the legacy broadcast plan's shape).
        // join input: even when a lower join's output already satisfies the required hash, we insert a
    /**
        boolean shuffleAggregateEnabled
 * {@code DistributedAggOverJoinRewriter}, …) with ONE pass that places exchanges generically, the way
    /** Largest {@link OpenSearchTableScan} row count in {@code node}'s subtree (0 when no scan / unknown). */
        RelNode gathered = traitDef.buildReducer(partial);
     *       literal".</li>
     * distributed (a shuffle/cascade level below). NOT a bare {@code SHARD+RANDOM} scan: that's just
import org.apache.calcite.rel.core.AggregateCall;
 *
                    joinInputs.add(buildIdx == 0 ? childContents.get(probeIdx) : newBuild);
        // already-distributed WORKER tier — those execute a leaf fragment and ship partitions. A join
            agg.getAggCallList(),
 * input's {@link DistributionAware#requiredInputDistribution required} distribution and inserts an
        if (rel instanceof OpenSearchProject project && !project.containsOver() && project.getInputs().size() == 1) {
            childContents.add(v.rel);
     * extra shuffle.
                // worker; reaching here means the child is not partitioned, e.g. a theta join's gathered
        // Force the gather from the TRACKED distribution — not buildEnforcer, whose satisfies() check
                // fragment instead of being stranded below the cut, where its declared StageInputScan type
        }
        // 2b. A per-partition Sort RIDES its child's distribution. Both top-N rewriters place a shard-local
            if (required == null) {
     * shuffle is built UNCONDITIONALLY ({@code buildShuffleExchange}) — even when the child's trait already
    private RelNode forceShuffle(boolean isTierBoundary, RelNode childContent, OpenSearchDistribution required) {
            if (!allInputsShippable) {
 *
        // intermediate-Project-rides-the-lower-worker case (demand flows to the lower join's output, which
        // "declared=<…__row_id__> batch=<…__row_id__ not null, ___ugsi>" → HTTP 500 on a wide
            gathered,
     *
    public DistributionEnforcementPass(
        RelNode result = OpenSearchAggregateSplitRule.wrapWithCastIfNeeded(finalAgg, agg);
     * @param shuffleAggregateEnabled per-strategy sub-toggle ({@code analytics.mpp.shuffle.aggregate.enabled}):
     * {@link #gatherSinkingProjects}). Walks down single-input Projects (no {@code RexOver}), rebuilding them
                imposesRequirement = true;
        // inputs into binary shuffle PRODUCER stages. A producer can only SHIP a hash shuffle if its
        long minRows,
            agg.getCallAnnotations()
        // (rather than collapsing N joins into one fragment with N shuffle leaves, which the binary
                RelNode gatheredPartial = gatherIfNeeded(child.rel, child.actualDistribution);
     *   <li><b>Aggregate literal args.</b> The PPL frontend materializes an aggregate's literal config args
        boolean aboveFloor = minRows <= 0 || subtreeMaxScanRows(n) >= minRows;
        // documented future optimization (needs N-ary shuffle transport); see MPP-GENERAL-SCHEDULING-DESIGN.md.
import org.apache.calcite.rel.RelNode;
        // (coord-centric, correct). Generalizing dispatch to agg-consumer shuffle edges is the next step.
        return new Visited(result, traitDef.coordSingleton());
        for (RelNode input : n.getInputs()) {
            // reducer below them so DAGBuilder doesn't strand the percentile literal in the child stage. Other
        // FINAL needs all partials, and the FINAL gathers), so we do NOT honor the aggregate's
        // decorrelated subquery's aggregate — TPC-H q4 `exists`→SEMI, q22 `not exists`→ANTI, q2/q15
        List<IntermediateField> intermediateFields = FinalAggCallBuilder.classify(agg.getAggCallList());
        return dist.getType() == org.apache.calcite.rel.RelDistribution.Type.HASH_DISTRIBUTED
     *       backend type → Substrait "Field has a different type" mismatch.</li>
     * Project/Filter passes {@code demand} straight to its child and rides whatever the child returns.
 * Project/Filter (no requirement of its own) passes the parent's demand straight through and RIDES whatever
            intermediateFields
        // DAGBuilder.cutBroadcast tags the build BROADCAST_BUILD and emits an OpenSearchBroadcastScan in the
 * gather (the query result must land on the coordinator).
     * satisfies SINGLETON. Decides off {@code actual} (the pass's tracked distribution), then forces the
            return Math.max(0L, (long) scan.getTable().getRowCount());
        }
        // the optimization). The shape is identical to OpenSearchBroadcastJoinSplitRule's, so
        // 1. CBO exchange wrapper: peel it, recover the input's content + actual distribution. The parent
            agg.getGroupSet().isEmpty()
        }
 * compatible open source license.
        }
        // 3d. Shippable-producer gate for a JOIN tier boundary. Distributing a join shuffles BOTH its
                Visited child = visit(n.getInput(0), null);
                    LOGGER.debug("enforce: join {} preserves CBO broadcast (build input {})", n.getRelTypeName(), buildIdx);
        }
        // scalar subqueries): DAGBuilder cuts it as a ReduceStageExecution, which emits to its parent
                );
        // the pass distributed still carries coordSingleton on its traitSet).
        int partitionCount,
        // PARTIAL runs per-shard on the partitioned input, the ER gathers the partials, the FINAL merges on
        // child returns — covering both the q3 filtered-scan-stays-shard-local and the intermediate-Project-
        // The "only distribute what dispatch can run" discipline. (sf=10 bucket A.)
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;
        // so the satisfies()-gated buildEnforcer would skip the gather and collapse PARTIAL+FINAL into one
        //
        this.partitionCount = partitionCount;
    /**
 * distributed operator's inputs. The pass treats the CBO exchanges
     * Gathers {@code rel} to COORDINATOR+SINGLETON unless its TRACKED distribution {@code actual} already
                newInputs.add(landed);
        // demand-flow realization of the old "ride a partitioned-or-shard-local child" heuristic — but
        List<RelNode> newInputs = new ArrayList<>(childContents.size());
        boolean anyChildDistributed = childDists.stream().anyMatch(DistributionEnforcementPass::isPartitioned);
        }
            // aggregate PARTIAL/FINAL — gather the (possibly distributed) child and run the SINGLE aggregate
    private final int partitionCount;
        // 3b-bcast. PRESERVE a broadcast decision CBO already made. When CBO's cost model picked the
            if (buildIdx >= 0) {
                if (isShardLocal(childDists.get(probeIdx))) {
            // coordinator inputs (conservative: matches the CBO-gathered baseline). Sink the reducer below any
        }
        if (dist == null) {
     * <ul>
            return new Visited(rebuilt, traitDef.coordSingleton());
            agg.getGroupSet(),
            // coordinator-centric. This is the documented "disable distributed aggregation, keep MPP joins"
        }
    /**
                    // Worker join runs at the probe's SHARD distribution (alongside the probe scan); the
        if (n instanceof OpenSearchJoin) {
                // per-partition (silently wrong global result — the codex BLOCKER). gatherIfNeeded is a no-op
        // than emit an un-wireable agg-shuffle, GATHER and run the SINGLE aggregate on the coordinator
    }
    }
            if (cboAgg.getMode() == AggregateMode.PARTIAL) {
            for (OpenSearchDistribution cd : childDists) {
            Visited child = visit(n.getInput(0), demand);
 * SINGLE→PARTIAL/FINAL split a distributed aggregate needs (step 3c, {@link #splitAggregate} via the
 */
     * True iff {@code dist} is a {@code WORKER+HASH} partitioning — i.e. a child OPERATOR already ran
            return new Visited(rebuilt, child.actualDistribution);
        // Sort+fetch BELOW the gather so each shard ships only its local top-N
     * row-transparent {@link OpenSearchProject} chain so those Projects stay in the SAME fragment as their
    private static RelNode copyWithInputs(RelNode node, List<RelNode> newInputs) {
                return new Visited(rebuilt, traitDef.coordSingleton());
     *                       it gathers and runs coordinator-centric, leaving distributed JOINS unaffected.
            // leading row-transparent Project so a computed-column Project (e.g. `eval r = round(int)`, whose
            return new Visited(n, distributionOf(n));
     * {@code FinalAggCallBuilder} rebind on FINAL (argList → groupCount+i, COUNT→SUM), and the same
        // stays WORKER+HASH) with one rule. A window/pinned Project does NOT reach here — it imposes a
            && dist.getLocality() == OpenSearchDistribution.Locality.WORKER;
        // already does (each intermediate worker produces a shuffle to its parent worker). UNARY ops
        // 3b. Size floor: distribute this operator only when it is worth it — either a child is ALREADY
 * {@code demand} argument (top-down) and returns the subtree's derived distribution (bottom-up) — exactly
        // transport cannot run). This same-key inter-tier shuffle is exactly what the legacy cascade
                    RelNode newBuild = traitDef.buildBroadcastExchange(childContents.get(buildIdx), cboBuild.getProbeNodeEstimate());
        LOGGER.debug("enforce: split SINGLE aggregate {} → PARTIAL/FINAL", agg.getId());
     *
        }
     * <p>Only leading {@code Project}s are descended (row-wise, so running them above the gather on the
import org.opensearch.analytics.planner.rel.OpenSearchConvention;
            } else if (required.getType() == org.apache.calcite.rel.RelDistribution.Type.SINGLETON) {
                    RelNode rebuilt = copyWithInputs(n, joinInputs);
            gathered,
    private static long subtreeMaxScanRows(RelNode node) {
                regathered.add(
            }
 * Project between two join tiers rides the lower worker — both emerge from demand-flow, not a special-case
                // No requirement on this input — gather it to a coherent landing. (A transparent op over a
     * exactly two named inputs per worker, so each distributed join input must be its own producer stream;
 * exchange ONLY where the input's {@link DistributionAware#deriveOutputDistribution actual} distribution
            } else {
     * {@link OpenSearchAggregateSplitRule#wrapWithCastIfNeeded} empty-group nullability fix. The FINAL
     *                       exceeds this many rows (keeps small joins/aggregates coordinator-centric, the
            agg.getCluster(),
            // Per-strategy sub-toggle (analytics.mpp.shuffle.aggregate.enabled): when off, do NOT split the
        // hash-aggregate, were CBO ever to emit one) is NOT a coordinator gather and must fall through to
/*
        // via demand-flow: a transparent op passes the parent's demand to its child and rides whatever the
        // (the small build side); the step-3 child loop peeled it, so childContents[buildIdx] is the build's
        // CAPTURING each build and INJECTING it as a BroadcastInjectionInstructionNode on whatever stage
            RelNode gathered = gatherSinkingProjects(childContent, childDist);
    }
        // their child, so they keep the reuse shortcut (e.g. a PARTIAL agg sits on its join's worker with
     */
        // over partialInput, whose traitSet may carry a stale coordSingleton (a join the pass distributed),
 * distributed-aggregate path — the legacy {@code OpenSearchAggregateShuffleSplitRule} CBO alternative is
            }
        if (!changed) {
     * "data lives on shards", which is true of every multi-shard input and would defeat the size floor.
                // child's traitSet still carries the CBO coordSingleton trait (the pass tracks the derived
                continue;
 * gone. It honors the {@code analytics.mpp.shuffle.aggregate.enabled} sub-toggle: when off, the aggregate
        this.shuffleAggregateEnabled = shuffleAggregateEnabled;
        return max;
                newInputs.add(childContent);
        return isTierBoundary ? traitDef.buildShuffleExchange(childContent, required) : traitDef.buildEnforcer(childContent, required);
     * </ul>
            }
        // the recovered actual distribution doesn't satisfy it. The demand flows through the peel unchanged.
    private static boolean isPartitioned(OpenSearchDistribution dist) {
        // and re-driving the join through the shuffle algebra (which would repartition BOTH sides and lose
        for (int i = 0; i < n.getInputs().size(); i++) {
            return new Visited(rebuilt, child.actualDistribution);
        return traitDef.buildReducer(rel);
                // A SINGLETON requirement (a window / pinned OpenSearchProject / global Sort that needs
 * ({@code ExchangeReducer}/{@code ShuffleExchange}/{@code BroadcastExchange}) as enforcement decisions it
            RelNode rebuilt = copyWithInputs(n, List.of(child.rel));
        // (Project / Filter / PARTIAL aggregate) are NOT tier boundaries — they ride on the same worker as
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
    private Visited visit(RelNode node, OpenSearchDistribution demand) {
        // join key, and for the empty-group case.
 *
 * SPDX-License-Identifier: Apache-2.0
        DistributionEnforcementPass pass = new DistributionEnforcementPass(traitDef, partitionCount, minRows, shuffleAggregateEnabled);
            finalCalls,
        );
import org.apache.logging.log4j.LogManager;
 * Spark's {@code EnsureRequirements} and Presto's {@code AddExchanges} do.
        if (n instanceof OpenSearchAggregate agg
     *       (e.g. {@code percentile(x, 50)}'s {@code 50}, its type-flag) as constant columns in a Project
            }
    }
 * <p><b>Peel-then-re-enforce.</b> CBO already inserted an {@link OpenSearchExchangeReducer} gather on each
import org.opensearch.analytics.planner.rel.OpenSearchShuffleExchange;
        // re-gathers its input to SINGLETON — that hoists the shard Sort ABOVE the ER and leaves the shard
                    OpenSearchBroadcastExchange cboBuild = (OpenSearchBroadcastExchange) RelNodeUtils.unwrapHep(n.getInput(buildIdx));
     * exchange wrapper to recover the underlying content + distribution (the parent re-enforces). For a
        }
        // side ∈ {left,right}; the buffer has two slices), so every distributed join input must arrive as
import org.apache.calcite.rex.RexLiteral;
        if (rowTransparent && n instanceof DistributionAware ta && ta.requiredInputDistribution(0, partitionCount, traitDef) == null) {
            // semantics: a join BELOW still distributes (its worker tier is untouched); only the aggregate's
        // The query result must be SINGLETON at the coordinator. If the root already produces SINGLETON
        if (n instanceof OpenSearchExchangeReducer reducer && reducer.hasOverrideRowType()) {
                    buildIdx = i;
        List<RelNode> childContents = new ArrayList<>(n.getInputs().size());
            return false;
            if (aware.requiredInputDistribution(i, partitionCount, traitDef) != null) {
        // here we don't yet know it (joins/aggregates compute per-input demands), so we visit with a null
    private RelNode sinkReducerBelowProjects(RelNode rel) {
        // same-key inter-tier shuffle so DAGBuilder cuts the lower join into its own binary producer stage
        // in step 4. (A null demand means "no constraint" — the child still gathers/rides per ITS subtree.)
                    break;
            return rel;
        this.traitDef = traitDef;
                RelNode landed = gatherSinkingProjects(childContent, childDist);
        if (!(n instanceof DistributionAware aware)) {
                // child's stale CBO coordSingleton trait and would skip the ER, leaving the consumer running
    private RelNode gatherIfNeeded(RelNode rel, OpenSearchDistribution actual) {
            // clash with the gathered data (the round() Int32-vs-Float64 substrait mismatch).
            if (rel.getTraitSet().getTrait(i) instanceof OpenSearchDistribution dist) {
            agg.getGroupSet().cardinality(),
import org.opensearch.analytics.planner.rel.OpenSearchDistribution;
                // materialize the shuffle. For a join input whose child is a lower distributed join the
                // row-transparent Project so a computed-column Project (e.g. `eval r = round(x)`, whose
     *                       when {@code false}, a decomposable SINGLE aggregate is NOT split PARTIAL/FINAL —
                }
 * General post-CBO distribution-enforcement pass (Option B — see {@code MPP-GENERAL-SCHEDULING-DESIGN.md}).
        // DistributedAggOverJoinRewriter. The PARTIAL result is correct under ANY input partitioning (a
                }
 * single recursion that is BOTH directions at once: it takes the parent's required distribution as the
        // (The SINGLE-aggregate PARTIAL/FINAL split is handled earlier, in step 3c, NOT here — it must
            agg.getGroupSet(),
        // subtree exceeds minRows. Otherwise treat it as non-distributable (gather inputs, stay
                if (newInputs.get(i) != RelNodeUtils.unwrapHep(node.getInput(i))) {
            List<RelNode> regathered = new ArrayList<>(childContents.size());
     * BELOW the gather (runs shard-side, ships fewer rows).
            return plan;
            }
        // its OWN shuffle producer stream. We therefore do NOT take the co-partition-reuse shortcut on a
            partialInput,
     */
                enforcedChildDists.add(childDist);
    /**
                // Unary op already co-partitioned — no exchange (rides on its child's worker).
    ) {
 * operator passes each child {@code requiredInputDistribution(i)} as that child's demand; a row-transparent
            partialInput.getTraitSet().replace(OpenSearchConvention.INSTANCE),
        if (root.actualDistribution != null && root.actualDistribution.satisfies(coordSingleton)) {
        // for the aggregate path); both mark it perPartition. Sort is NOT
        this.minRows = minRows;
                RelNode rebuilt = copyWithInputs(n, regathered);
            }
        // - A FINAL aggregate sitting DIRECTLY over a CBO ExchangeReducer (the coordinator-gather split)
     * {@code FINAL( ER(SINGLETON)( PARTIAL(input) ) )}, mirroring {@code OpenSearchAggregateSplitRule.onMatch}
