                RelTrait trait = getInput().getTraitSet().getTrait(index);
        }
        }
            getCluster(),
     * on the prefix range so a non-prefix key (e.g. {@code avg(x) by span(y,5)} → {@code {1}}) isn't
     * workers + {@code Aggregate(FINAL)} on the coordinator (the existing {@code OpenSearchAggregateSplitRule}
        }
    }
            if (traitResolved) {
        this.viableBackends = viableBackends;
        AggregateMode mode
     *       PARTIAL runs wherever the input is, FINAL merges the ≤N partials at the coordinator. The gather
/**
    /** Returns the per-call annotation map (keyed by call index). */
     * Returns {@code null} (no requirement → input left at its CBO-chosen shape) for non-SINGLE modes, or
        return outputStorage;
     * <p>PARTIAL is unconstrained (it consumes whatever the child distribution is and emits
     * / {@code DistributedAggregateRewriter} machinery the pass reuses):
            frontGroupSetForFinal(groupSet, mode),
    public List<IntermediateField> getIntermediateFields() {
        return new OpenSearchAggregate(
            finalExtraLiteralArgs,
/*
            boolean traitResolved = false;
            }
    /**
                rebuilt.put(i, (AggregateCallAnnotation) resolvedAnnotations.get(annotationIndex++));
    private static List<ImmutableBitSet> frontGroupSetsForFinal(
import org.apache.calcite.rel.RelWriter;
    public Map<Integer, AggregateCallAnnotation> getCallAnnotations() {
     * <ul>
        List<String> viableBackends,
        if (mode != AggregateMode.FINAL || groupSets == null || groupSets.isEmpty()) {
            ? openSearchInput.getOutputFieldStorage()
            finalExtraLiteralArgs,
     * (single-set) aggregates, so this collapses to one set; revisit if GROUPING SETS is ever added.
        // Collections.unmodifiableList — List.copyOf would NPE on the null pass-through entries.
    public OpenSearchDistribution deriveOutputDistribution(
        RelTraitSet traitSet,
import org.apache.calcite.plan.RelOptCluster;
    /**
            // itself gathers its partials to the coordinator. Requiring SINGLETON here is a no-op when the
        for (AggregateCall aggCall : getAggCallList()) {
        // for high-cardinality GROUP BY).
     * extra gather ER on top: for shuffle to win the savings on FINAL must exceed the extra
        return annotations;
            if (mode == AggregateMode.SINGLE && !inputIsSingleton) {
    public Aggregate copy(
        // Rebuild the side-map preserving call-index keys, swapping annotation values
     * tests happen to catch the current shapes, but they are not a substitute for this gate;
     * Keeps {@code groupSets} consistent with the fronted {@code groupSet}. PPL only emits simple
    /**
     * merges) and HASH+WORKER (the M3 shuffle path — partials hash-shuffled by group keys,
public class OpenSearchAggregate extends Aggregate implements OpenSearchRelNode, DistributionAware {
                double finalCost = finalRows / partitionCount;
        );
     * An aggregate's output is partitioned by its group keys only when it ran distributed (PARTIAL/FINAL)
            AggregateCallAnnotation annotation = callAnnotations.get(i);
import java.util.Map;
     * workers in parallel → cost = inputRows / N. The parallelism win is what makes the shuffle
    @Override
     *   <li>empty group set (e.g. {@code stats sum(x)} no {@code by}) → require {@code COORDINATOR+SINGLETON}:
            traitSet,
                    return planner.getCostFactory().makeInfiniteCost();
import org.apache.calcite.util.ImmutableBitSet;
        return mode;
    private final Map<Integer, List<RexLiteral>> finalExtraLiteralArgs;
            // ER on top — but only when the savings exceed the gather's setup, so tiny inputs
        RelNode input,
 * The OpenSearch Contributors require contributions made to
            return List.of();
        List<String> viableBackends,
                boolean hashWorker = distribution.getType() == RelDistribution.Type.HASH_DISTRIBUTED
                            + inputStorage.size()
     * <p>TODO(trait-propagation): PARTIAL/FINAL split PLACEMENT is already a trait algebra — see
     * coordinator anyway. So we do not advertise a co-partitionable output here (returns {@code null}); a
        this(cluster, traitSet, input, groupSet, groupSets, aggCalls, mode, viableBackends, callAnnotations, Map.of(), List.of());
     */
        return traitDef.hash(getGroupSet().asList(), partitionCount);
    }
        for (int i = 0; i < getAggCallList().size(); i++) {
                }
    public List<OperatorAnnotation> getAnnotations() {
            newInput,
                    && distribution.getLocality() == OpenSearchDistribution.Locality.COORDINATOR;
            return null;
            if (annotation != null) {
        RelNode input,
    /** Per-call {@link IntermediateField} classification, parallel to {@link #getAggCallList()}; null entry = no SPI decomposition; empty for SINGLE/PARTIAL. */
     * </ul>
 * this file be licensed under the Apache-2.0 license or a
        if (callAnnotations.isEmpty()) {
     * {@code passThroughTraits}) would fold the cost-RANKING part of this override into the trait
import org.apache.calcite.rex.RexLiteral;
            frontGroupSetsForFinal(groupSet, groupSets, mode),
import org.opensearch.analytics.planner.RelNodeUtils;
     * on this class, consulted by the post-CBO {@code DistributionEnforcementPass}. A future top-down
        List<AggregateCall> aggCalls,
            viableBackends,
    /** Builds a FINAL aggregate post-rewrite; clears both stashes so a later {@code copy()} can't replay them. */
     * legally land a SINGLE aggregate directly on partitioned data — each shard aggregates in
        RelTraitSet traitSet,
                if (!(trait instanceof OpenSearchDistribution distribution)) continue;
import java.util.LinkedHashMap;
import org.apache.calcite.plan.RelTrait;
    }
    }
        Map<Integer, AggregateCallAnnotation> callAnnotations,
     * split rule from the original SINGLE aggregate's child Project. Empty otherwise.
    ) {
 */
    }
    private final List<IntermediateField> perCallIntermediateField;
        int annotationIndex = 0;
     * SINGLETON+COORDINATOR (the M0/M1 coord-centric path — partials gathered to coord, FINAL
     *
    ) {
        }
                return planner.getCostFactory().makeCost(finalCost, finalCost, 0);
     * SINGLE-mode aggregate over partitioned input is incorrect (each shard would aggregate
        RelOptCluster cluster,
    /**
import java.util.Collections;
        );
        List<AggregateCall> aggCalls,
            traitSet,
                    deps.add(src.getFieldName());
     * feeds a co-partition-sensitive parent in PPL; revisit if a join-on-agg-output shape needs it.)
        Map<Integer, AggregateCallAnnotation> callAnnotations
            callAnnotations,
     * <p>Cost: FINAL pays merge cost proportional to its input rows. At COORDINATOR+SINGLETON
                    deps.addAll(src.getDependsOnPhysicalCols());
     * ranking — it must survive any such migration (see the paragraph above).
package org.opensearch.analytics.planner.rel;
    ) {
        return new OpenSearchAggregate(
        );
        Map<Integer, List<RexLiteral>> finalExtraLiteralArgs
        return finalExtraLiteralArgs;
        RelOptCluster cluster,
     * path beat the coord-centric path on high-cardinality {@code GROUP BY} despite paying an
    private final List<String> viableBackends;
    }
     */
        return perCallIntermediateField;
            cluster,
            RelTrait trait = getInput().getTraitSet().getTrait(index);
     * {@link #copyResolved}.
            groupSet,
        }
 * Calcite's {@code AggCallBinding.preOperands}, which would otherwise corrupt
    ) {
        RelTraitSet traitSet,
import org.opensearch.analytics.spi.AggregateFunction.IntermediateField;
            // to a cost.
        RelNode input,
        return null;
     * stay coordinator-centric. The {@code groupSet} of a SINGLE aggregate indexes INPUT columns, so the
        // Group-by fields: inherit from input
    }
        RelTraitSet traitSet,
            prior.getCluster(),
    public OpenSearchAggregate(
        List<FieldStorageInfo> outputStorage = new ArrayList<>();
            mode,
 * {@code AggregateCall#rexList}. Keeping them out of rexList avoids contaminating
            mode,
        this.callAnnotations = Map.copyOf(callAnnotations);
            getCluster(),
            for (int argIdx : aggCall.getArgList()) {
    public AggregateMode getMode() {
    public Map<Integer, List<RexLiteral>> getFinalExtraLiteralArgs() {
    // ---- DistributionAware (Option B post-CBO enforcement pass) ----
import java.util.ArrayList;
        List<AggregateCall> aggCalls
        List<OperatorAnnotation> annotations = new ArrayList<>(callAnnotations.size());
            List.of()
import org.apache.calcite.plan.RelTraitSet;
     * independently, results would never merge). FINAL has two legal input shapes:
                traitResolved = true;
        // for the resolved (single-backend-narrowed) variants in the same iteration order
                            + "] has no matching FieldStorageInfo entry "
        List<RelHint> hints = mode == AggregateMode.FINAL ? List.of(RelHint.builder(FINAL_MODE_HINT).build()) : List.of();
        // getAnnotations() used.
            if (callAnnotations.containsKey(i)) {
            return traitDef.coordSingleton();
        List<ImmutableBitSet> groupSets,
import org.apache.calcite.rel.core.Aggregate;
        if (mode == AggregateMode.FINAL) {
        return super.explainTerms(pw).item("mode", mode).item("viableBackends", viableBackends);
    }
    }
                    partitionCount = Math.max(1, distribution.getPartitionCount());
     * the merge runs serially → cost = inputRows. At HASH+WORKER+N the merge runs across N
    @Override
    public List<FieldStorageInfo> getOutputFieldStorage() {
    }
            input,
    public static final String FINAL_MODE_HINT = "OPENSEARCH_AGGREGATE_FINAL";
     * Per-call annotations keyed by call index in {@link #getAggCallList()}. May be empty when
            prior.getGroupSet(),
            groupSets,
        RelNode input = RelNodeUtils.unwrapHep(getInput());
                return planner.getCostFactory().makeInfiniteCost();
 * <p>Per-call annotations are kept in a side-map keyed by call index — NOT in
            // Prices a SINGLE over partitioned input out (infinite cost) so it's never chosen.
    /**
    }
        return callAnnotations;
            LinkedHashSet<String> deps = new LinkedHashSet<>();
 * inferReturnType for functions that read {@code getOperandType(0)} (PPL's
    public OpenSearchAggregate(
                        "AggregateCall arg["
     * the PARTIAL half. Hints are not part of the Calcite digest and survive {@code copy}, so this
     *
    }
            getGroupSet(),
 *
            }
            getGroupSets(),
        // FINAL placement + parallel-merge cost (our hash-shuffle feature): FINAL is legal only over
            children.getFirst(),
            // FINAL pays a merge cost proportional to its input row count. Coord-centric merges
                return planner.getCostFactory().makeInfiniteCost();
    }
                }
    public OpenSearchDistribution requiredInputDistribution(int inputIndex, int partitionCount, OpenSearchDistributionTraitDef traitDef) {
        Map<Integer, List<RexLiteral>> finalExtraLiteralArgs,
    }
    /**
        ImmutableBitSet groupSet,
     * on the group keys, so the enforcement pass can split it into {@code Aggregate(PARTIAL)} on the
     * Used by {@code DistributedAggregateRewriter} to re-create the literals as
 * compatible open source license.
     * rejects a SINGLE aggregate placed over RANDOM (multi-shard) input. Without it, Volcano can
        Map<Integer, AggregateCallAnnotation> callAnnotations,
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {
        // Agg results: derived columns whose physical-deps are the union of arg refs' deps
            for (int index = 0; index < getInput().getTraitSet().size(); index++) {
    @Override
     * constant columns below FINAL, since the StageInputScan only carries the state.
     * Group-by fields inherit storage info from the input. Agg results are derived columns.
            prior.getTraitSet(),
    }
     * A {@code SINGLE} aggregate over a distributable input declares it needs its input hash-partitioned
     * parent that needs a specific partitioning will demand its own exchange. (Aggregate output rarely
 * @opensearch.internal
        List<AggregateCall> aggCalls,
     * gather ER's setup + final-output rows. This naturally amortizes only at scale, leaving
            prior.viableBackends,
     *
                            + "(input only declares "
        );
    /**
 */
     * alternative deterministically (no cost comparison), so this gate is the ONLY thing that
import org.apache.calcite.rel.core.AggregateCall;
     * <p><b>DO NOT REMOVE the SINGLE-mode infinite-cost branch below.</b> It is the correctness
        }
 * {@code ARG0_ARRAY} for {@code take} / {@code list} / {@code values}).
     * <p>The check tolerates ANY (Volcano's "still exploring" placeholder) on either side so the
     */
    }
     * planner can register alternatives during memo expansion before the trait is finalized.
            // Prices a PARTIAL above the Exchange out (infinite cost) so it's never chosen.
            rebuiltCalls,
import java.util.LinkedHashSet;
     * hash keys are the group-set bits directly.
     * Hint carried on the stripped {@link LogicalAggregate} of a FINAL-mode aggregate so backend
import org.apache.calcite.plan.RelOptPlanner;
    private final AggregateMode mode;
     * Aggregate output: group-by fields first (inherited from input), then agg results (derived).
                } else {
            // serially (partitionCount=1); HASH+WORKER merges in parallel across N workers
     * the aggregate has no annotations yet (pre-marking) or when copied from a Calcite-internal
     */
            }
        ImmutableBitSet groupSet,
    @Override
    @Override
            }
        AggregateMode mode,
        return planner.getCostFactory().makeTinyCost();
            if (mode == AggregateMode.PARTIAL && inputIsSingleton) {
            }
     * rule that doesn't preserve them. Order is stable for {@link #getAnnotations()} /
    }
     * FINAL runs on each worker over its hash bucket). Anything else is rejected.
    @Override
                double finalRows = mq.getRowCount(getInput());
            // coord-centric path on high-cardinality GROUP BY despite paying an extra gather
                if (!singletonCoord && !hashWorker) {
            finalExtraLiteralArgs,
     *   <li>non-empty group set → require {@code WORKER+HASH(groupKeys, N)} on the input;</li>
import org.apache.calcite.plan.RelOptCost;
    }
        return new OpenSearchAggregate(
        return viableBackends;
        // Annotations live out-of-band; the aggCall list passes through unchanged.
import org.apache.calcite.rel.metadata.RelMetadataQuery;
    @Override
        // and a PARTIAL over singleton input so Volcano never lands them on the wrong distribution.
    /**
     *
     * is a pure side-channel for the fragment convertor.
            getTraitSet(),
            cluster,
        AggregateMode mode,
        }
     */
     * — but in the pre-split SINGLE form the pass hasn't decided that yet, and the FINAL gathers to the
        List<String> viableBackends,
            // still route coord-centric. Use tinyCost while the trait is unresolved (Volcano's
                if (src.isDerived()) {
        for (int i = 0; i < getAggCallList().size(); i++) {
    public List<String> getViableBackends() {
 * OpenSearch custom Aggregate carrying viable backend list and per-call annotations.
import org.apache.calcite.rel.RelDistribution;
     * rewriters that run after stripping can still tell the coordinator-side merge half apart from
        List<ImmutableBitSet> groupSets,
            }
        super(
                    );
            // ANY placeholder) so memo expansion can register alternatives without committing
        // a COORDINATOR+SINGLETON gather or a WORKER+HASH shuffle, and the HASH case merges in
     * partial-state output at the same locality).
            aggCalls
                            + " columns)"
import java.util.List;
            // (partitionCount=N). The /N discount is what lets the shuffle path beat the
import org.opensearch.analytics.spi.FieldStorageInfo;
        }
        List<ImmutableBitSet> groupSets,
            viableBackends,
            traitSet,
    }
            outputStorage.add(FieldStorageInfo.derivedColumn(aggCall.getName(), aggCall.getType().getSqlTypeName(), deps));
        this(
                            + argIdx
            // No partition key — the PARTIAL/FINAL split still distributes the work below, but the agg
        this.mode = mode;
    public static boolean isFinalMode(Aggregate aggregate) {
            if (groupIdx < inputStorage.size()) {
    @Override
    /** True when {@code aggregate} is a stripped FINAL-mode {@link OpenSearchAggregate}. */
            input,
     * backstop for the whole split: {@code OpenSearchAggregateSplitRule} now emits a single
            : List.of();
        if (org.opensearch.analytics.planner.rules.OpenSearchAggregateSplitRule.shouldSkipPartialFinalSplit(this)) {
        this.finalExtraLiteralArgs = Map.copyOf(finalExtraLiteralArgs);
        List<IntermediateField> perCallIntermediateField
    /** See {@link #perCallIntermediateField}. */
import org.apache.calcite.rex.RexNode;
            aggCalls,
            input,
        return mode == AggregateMode.FINAL ? ImmutableBitSet.range(groupSet.cardinality()) : groupSet;
    public OpenSearchAggregate(
                    && distribution.getLocality() == OpenSearchDistribution.Locality.WORKER;
    private final Map<Integer, AggregateCallAnnotation> callAnnotations;
        return LogicalAggregate.create(strippedChildren.getFirst(), hints, getGroupSet(), getGroupSets(), getAggCallList());
            }
        // SINGLE / PARTIAL placement gates (upstream): price out a SINGLE over partitioned input
                if (distribution.getType() == RelDistribution.Type.ANY) continue;
        for (int index = 0; index < getInput().getTraitSet().size(); index++) {
            Map.of(),
 * SPDX-License-Identifier: Apache-2.0
        }
     * when the aggregate is not decomposable ({@code STATE_EXPANDING}/{@code DISTINCT}/percentile) — those
    ) {
                boolean singletonCoord = distribution.getType() == RelDistribution.Type.SINGLETON
        RelOptCluster cluster,
    /**
        ImmutableBitSet groupSet,
            aggCalls,
        List<FieldStorageInfo> inputStorage = (input instanceof OpenSearchRelNode openSearchInput)
            return groupSets;
            rebuilt,
     * FINAL-side carrier for literal aggregate-args (e.g. TAKE's N) captured by the
import org.apache.calcite.rel.hint.RelHint;
                if (argIdx >= inputStorage.size()) {
                if (hashWorker && distribution.getPartitionCount() != null) {
    @Override
        ImmutableBitSet groupSet,
            mode,
            AggregateMode.FINAL,
     */
            for (RexNode rex : aggCall.rexList) {
    public RelWriter explainTerms(RelWriter pw) {
     * deleting it breaks correctness, not just a test.
    }
     */
            groupSets,
            boolean inputIsSingleton = distribution.getType() == RelDistribution.Type.SINGLETON
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {
            perCallIntermediateField
     */
                annotations.add(annotation);
        if (getGroupSet().isEmpty()) {
        List<OpenSearchDistribution> childDistributions,
 *
            List.of(),
        List<ImmutableBitSet> groupSets,
     * isolation, the partials never merge, and queries return silently wrong results. Plan-shape
        OpenSearchDistributionTraitDef traitDef
            // input is already gathered; the distribution win comes from the input's own requirement.
 *
        }
                FieldStorageInfo src = inputStorage.get(argIdx);
            prior.callAnnotations,
            perCallIntermediateField
}
            List.of(backend),
                }
import org.apache.calcite.rel.RelNode;
                || distribution.getType() == RelDistribution.Type.ANY;
        );
    @Override
            if (!(trait instanceof OpenSearchDistribution distribution)) continue;
            groupSet,
    public static OpenSearchAggregate finalAfterRewrite(OpenSearchAggregate prior, RelNode newInput, List<AggregateCall> rebuiltCalls) {
     * read as an agg-state column. No-op for SINGLE/PARTIAL (raw input) and already-fronted sets.
     * tiny aggregates on coord-centric.
     * {@link DistributionAware#requiredInputDistribution}/{@link DistributionAware#deriveOutputDistribution}
        ImmutableBitSet groupSet,
                }
            }
    }
    ) {
     */
            callAnnotations,
            getAggCallList(),
        // parallel across N workers (the /partitionCount discount that lets shuffle beat coord-centric
            int partitionCount = 1;
                deps.addAll(RelNodeUtils.resolvePhysicalDeps(rex, inputStorage));
                outputStorage.add(inputStorage.get(groupIdx));
     * migration ({@code setTopDownOpt} + Calcite {@code PhysicalNode} {@code deriveTraits}/
        RelNode input,
     *       is bounded (one partial row per partition), so no hash key is needed.</li>
     * FINAL reads PARTIAL's output, where Calcite has fronted the group keys to {@code 0..n-1}; group
        }
        AggregateMode mode,
import org.apache.calcite.rel.logical.LogicalAggregate;
            return null;
        // (preserving first-seen order across argList, then rexList).
        for (int groupIdx : getGroupSet()) {
    private static ImmutableBitSet frontGroupSetForFinal(ImmutableBitSet groupSet, AggregateMode mode) {
        Map<Integer, AggregateCallAnnotation> rebuilt = new LinkedHashMap<>(callAnnotations.size());
        return List.of(ImmutableBitSet.range(groupSet.cardinality()));
            prior.getGroupSets(),
        if (inputIndex != 0 || mode != AggregateMode.SINGLE) {
        return aggregate.getHints().stream().anyMatch(hint -> FINAL_MODE_HINT.equals(hint.hintName));
            }
        this.perCallIntermediateField = Collections.unmodifiableList(new ArrayList<>(perCallIntermediateField));
        List<ImmutableBitSet> groupSets,
     *
                    throw new IllegalStateException(
    public RelOptCost computeSelfCost(RelOptPlanner planner, RelMetadataQuery mq) {
            List.of()
     * machinery. NOTE: the SINGLE-mode infinite-cost gate below is a CORRECTNESS backstop, not cost
