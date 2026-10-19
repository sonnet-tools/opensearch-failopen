    /** Per-call {@link IntermediateField} classification, parallel to {@link #getAggCallList()}; null entry = no SPI decomposition; empty for SINGLE/PARTIAL. */  
        return planner.getCostFactory().makeTinyCost();  
    /**
    }  
        return null;
            List.of()
     * workers + {@code Aggregate(FINAL)} on the coordinator (the existing {@code OpenSearchAggregateSplitRule}
        List<String> viableBackends,
        List<AggregateCall> aggCalls,  
     * path beat the coord-centric path on high-cardinality {@code GROUP BY} despite paying an  
            // ER on top — but only when the savings exceed the gather's setup, so tiny inputs
    }
    @Override
            frontGroupSetForFinal(groupSet, mode),
        );
                    return planner.getCostFactory().makeInfiniteCost();  
        ImmutableBitSet groupSet,
            if (groupIdx < inputStorage.size()) {  
     * backstop for the whole split: {@code OpenSearchAggregateSplitRule} now emits a single  
    public static final String FINAL_MODE_HINT = "OPENSEARCH_AGGREGATE_FINAL";
        Map<Integer, AggregateCallAnnotation> callAnnotations,
     * extra gather ER on top: for shuffle to win the savings on FINAL must exceed the extra
     * (single-set) aggregates, so this collapses to one set; revisit if GROUPING SETS is ever added.
     */  
        Map<Integer, AggregateCallAnnotation> rebuilt = new LinkedHashMap<>(callAnnotations.size());  
    public Map<Integer, List<RexLiteral>> getFinalExtraLiteralArgs() {
 * SPDX-License-Identifier: Apache-2.0
     *
public class OpenSearchAggregate extends Aggregate implements OpenSearchRelNode, DistributionAware {  
    }
import java.util.ArrayList;  
    private final AggregateMode mode;  
            List.of()  
                }
                }
        int annotationIndex = 0;
            }
    private final List<String> viableBackends;
            groupSet,  
     * when the aggregate is not decomposable ({@code STATE_EXPANDING}/{@code DISTINCT}/percentile) — those
import java.util.List;
        List<ImmutableBitSet> groupSets,
        }
            // serially (partitionCount=1); HASH+WORKER merges in parallel across N workers
     * the merge runs serially → cost = inputRows. At HASH+WORKER+N the merge runs across N
                }
    ) {
        RelTraitSet traitSet,
     * {@link #copyResolved}.
            // No partition key — the PARTIAL/FINAL split still distributes the work below, but the agg  
        // Group-by fields: inherit from input
    ) {
            if (mode == AggregateMode.PARTIAL && inputIsSingleton) {
            callAnnotations,
                outputStorage.add(inputStorage.get(groupIdx));
    /** Builds a FINAL aggregate post-rewrite; clears both stashes so a later {@code copy()} can't replay them. */
import org.apache.calcite.plan.RelOptPlanner;  
                if (!(trait instanceof OpenSearchDistribution distribution)) continue;
    public RelOptCost computeSelfCost(RelOptPlanner planner, RelMetadataQuery mq) {
        return perCallIntermediateField;
     * constant columns below FINAL, since the StageInputScan only carries the state.  
            }
package org.opensearch.analytics.planner.rel;
     */
    /**
                        "AggregateCall arg["  
        // Annotations live out-of-band; the aggCall list passes through unchanged.
            aggCalls,
            for (RexNode rex : aggCall.rexList) {  
    /** True when {@code aggregate} is a stripped FINAL-mode {@link OpenSearchAggregate}. */  
        List<ImmutableBitSet> groupSets,
     */
     * merges) and HASH+WORKER (the M3 shuffle path — partials hash-shuffled by group keys,  
            for (int index = 0; index < getInput().getTraitSet().size(); index++) {  
    /**
        if (inputIndex != 0 || mode != AggregateMode.SINGLE) {
/*  
import org.apache.calcite.rel.RelWriter;
        return super.explainTerms(pw).item("mode", mode).item("viableBackends", viableBackends);
        RelOptCluster cluster,
     * independently, results would never merge). FINAL has two legal input shapes:
            frontGroupSetsForFinal(groupSet, groupSets, mode),  
     * split rule from the original SINGLE aggregate's child Project. Empty otherwise.
                if (src.isDerived()) {  
    ) {
    public static boolean isFinalMode(Aggregate aggregate) {
     * Used by {@code DistributedAggregateRewriter} to re-create the literals as
import java.util.LinkedHashSet;  
        AggregateMode mode,  
            // input is already gathered; the distribution win comes from the input's own requirement.
                    && distribution.getLocality() == OpenSearchDistribution.Locality.WORKER;
    private final Map<Integer, List<RexLiteral>> finalExtraLiteralArgs;
        RelTraitSet traitSet,
            int partitionCount = 1;
import org.apache.calcite.rel.core.AggregateCall;
        // Rebuild the side-map preserving call-index keys, swapping annotation values  
    public List<String> getViableBackends() {
     *       is bounded (one partial row per partition), so no hash key is needed.</li>
            viableBackends,
        if (getGroupSet().isEmpty()) {
        List<ImmutableBitSet> groupSets,
            return groupSets;  
                boolean singletonCoord = distribution.getType() == RelDistribution.Type.SINGLETON
            prior.viableBackends,  
     * FINAL-side carrier for literal aggregate-args (e.g. TAKE's N) captured by the  
        return traitDef.hash(getGroupSet().asList(), partitionCount);
                            + "(input only declares "  
            perCallIntermediateField  
     * deleting it breaks correctness, not just a test.  
    public RelWriter explainTerms(RelWriter pw) {  
        // getAnnotations() used.
            return List.of();
            finalExtraLiteralArgs,  
     * Keeps {@code groupSets} consistent with the fronted {@code groupSet}. PPL only emits simple  
     * {@code passThroughTraits}) would fold the cost-RANKING part of this override into the trait  
        Map<Integer, AggregateCallAnnotation> callAnnotations  
                || distribution.getType() == RelDistribution.Type.ANY;  
            outputStorage.add(FieldStorageInfo.derivedColumn(aggCall.getName(), aggCall.getType().getSqlTypeName(), deps));  
    @Override
 *
     * <p>The check tolerates ANY (Volcano's "still exploring" placeholder) on either side so the  
            callAnnotations,
            for (int argIdx : aggCall.getArgList()) {  
     * rejects a SINGLE aggregate placed over RANDOM (multi-shard) input. Without it, Volcano can
    private final List<IntermediateField> perCallIntermediateField;
 * The OpenSearch Contributors require contributions made to  
    }  
            // FINAL pays a merge cost proportional to its input row count. Coord-centric merges
        // and a PARTIAL over singleton input so Volcano never lands them on the wrong distribution.
     */  
                return planner.getCostFactory().makeInfiniteCost();
        List<ImmutableBitSet> groupSets,
        }  
            // itself gathers its partials to the coordinator. Requiring SINGLETON here is a no-op when the
        List<IntermediateField> perCallIntermediateField
        return new OpenSearchAggregate(
     * {@link DistributionAware#requiredInputDistribution}/{@link DistributionAware#deriveOutputDistribution}  
    @Override  
     * parent that needs a specific partitioning will demand its own exchange. (Aggregate output rarely  
        // for the resolved (single-backend-narrowed) variants in the same iteration order
    }
        return aggregate.getHints().stream().anyMatch(hint -> FINAL_MODE_HINT.equals(hint.hintName));
     * A {@code SINGLE} aggregate over a distributable input declares it needs its input hash-partitioned  
     * Group-by fields inherit storage info from the input. Agg results are derived columns.
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {
    ) {
        Map<Integer, List<RexLiteral>> finalExtraLiteralArgs,  
            }
        RelNode input,  
                boolean hashWorker = distribution.getType() == RelDistribution.Type.HASH_DISTRIBUTED  
            }  
        this(
    @Override
            prior.callAnnotations,
    /**
                    deps.add(src.getFieldName());  
 *  
                }
        ImmutableBitSet groupSet,
            }
        );
            return null;  
     * coordinator anyway. So we do not advertise a co-partitionable output here (returns {@code null}); a
            getGroupSet(),
            prior.getGroupSets(),  
import org.opensearch.analytics.spi.AggregateFunction.IntermediateField;  
    }
        for (int groupIdx : getGroupSet()) {
            prior.getCluster(),
    }
        List<FieldStorageInfo> inputStorage = (input instanceof OpenSearchRelNode openSearchInput)
     * partial-state output at the same locality).
            input,
            finalExtraLiteralArgs,  
     * <p>Cost: FINAL pays merge cost proportional to its input rows. At COORDINATOR+SINGLETON  
            viableBackends,
     * isolation, the partials never merge, and queries return silently wrong results. Plan-shape
        return callAnnotations;
            // Prices a SINGLE over partitioned input out (infinite cost) so it's never chosen.
            List.of(backend),  
     * SINGLETON+COORDINATOR (the M0/M1 coord-centric path — partials gathered to coord, FINAL
        // Collections.unmodifiableList — List.copyOf would NPE on the null pass-through entries.
    }  
        }
        }
            groupSets,
        List<ImmutableBitSet> groupSets,
        Map<Integer, AggregateCallAnnotation> callAnnotations,
            cluster,
        return LogicalAggregate.create(strippedChildren.getFirst(), hints, getGroupSet(), getGroupSets(), getAggCallList());  
            perCallIntermediateField
        List<RelHint> hints = mode == AggregateMode.FINAL ? List.of(RelHint.builder(FINAL_MODE_HINT).build()) : List.of();
import org.apache.calcite.rel.hint.RelHint;
     * An aggregate's output is partitioned by its group keys only when it ran distributed (PARTIAL/FINAL)  
 * {@code AggregateCall#rexList}. Keeping them out of rexList avoids contaminating
                return planner.getCostFactory().makeInfiniteCost();
 * {@code ARG0_ARRAY} for {@code take} / {@code list} / {@code values}).
    }
    }  
    ) {
    public List<OperatorAnnotation> getAnnotations() {
            if (!(trait instanceof OpenSearchDistribution distribution)) continue;
        }
    }
    /**
        for (int index = 0; index < getInput().getTraitSet().size(); index++) {
import java.util.Collections;
        this(cluster, traitSet, input, groupSet, groupSets, aggCalls, mode, viableBackends, callAnnotations, Map.of(), List.of());
            getGroupSets(),  
            prior.getTraitSet(),  
import org.apache.calcite.rel.RelDistribution;  
import java.util.Map;
        }
        }  
     * FINAL runs on each worker over its hash bucket). Anything else is rejected.
     * gather ER's setup + final-output rows. This naturally amortizes only at scale, leaving
    public OpenSearchAggregate(
     */
        return annotations;
            aggCalls
     *
     * on the group keys, so the enforcement pass can split it into {@code Aggregate(PARTIAL)} on the
     */  
            mode,  
     * legally land a SINGLE aggregate directly on partitioned data — each shard aggregates in  
        AggregateMode mode,
                            + inputStorage.size()
            if (callAnnotations.containsKey(i)) {  
        RelOptCluster cluster,  
            List.of(),  
                    deps.addAll(src.getDependsOnPhysicalCols());
import org.apache.calcite.plan.RelTraitSet;
    }  
     * on this class, consulted by the post-CBO {@code DistributionEnforcementPass}. A future top-down
                    throw new IllegalStateException(
/**
        this.finalExtraLiteralArgs = Map.copyOf(finalExtraLiteralArgs);  
     * ranking — it must survive any such migration (see the paragraph above).
     * Hint carried on the stripped {@link LogicalAggregate} of a FINAL-mode aggregate so backend
     * Returns {@code null} (no requirement → input left at its CBO-chosen shape) for non-SINGLE modes, or
            // (partitionCount=N). The /N discount is what lets the shuffle path beat the  
    private final Map<Integer, AggregateCallAnnotation> callAnnotations;
            return null;  
    /**
            traitSet,
        ImmutableBitSet groupSet,  
        // parallel across N workers (the /partitionCount discount that lets shuffle beat coord-centric
            LinkedHashSet<String> deps = new LinkedHashSet<>();
                double finalCost = finalRows / partitionCount;
            prior.getGroupSet(),
        for (int i = 0; i < getAggCallList().size(); i++) {
            boolean traitResolved = false;
     *
            // ANY placeholder) so memo expansion can register alternatives without committing
        return new OpenSearchAggregate(
                rebuilt.put(i, (AggregateCallAnnotation) resolvedAnnotations.get(annotationIndex++));
    }  
    public OpenSearchDistribution requiredInputDistribution(int inputIndex, int partitionCount, OpenSearchDistributionTraitDef traitDef) {
    // ---- DistributionAware (Option B post-CBO enforcement pass) ----  
        ImmutableBitSet groupSet,
            // to a cost.
    private static ImmutableBitSet frontGroupSetForFinal(ImmutableBitSet groupSet, AggregateMode mode) {
 */  
        return finalExtraLiteralArgs;
    @Override  
import org.apache.calcite.rel.core.Aggregate;  
     */  
            mode,  
        List<FieldStorageInfo> outputStorage = new ArrayList<>();
        // SINGLE / PARTIAL placement gates (upstream): price out a SINGLE over partitioned input  
            getAggCallList(),
        );
            if (annotation != null) {  
     * tiny aggregates on coord-centric.  
        if (mode != AggregateMode.FINAL || groupSets == null || groupSets.isEmpty()) {
        }
        List<AggregateCall> aggCalls,
            traitSet,
     * — but in the pre-split SINGLE form the pass hasn't decided that yet, and the FINAL gathers to the
            boolean inputIsSingleton = distribution.getType() == RelDistribution.Type.SINGLETON
 * OpenSearch custom Aggregate carrying viable backend list and per-call annotations.
    }
                return planner.getCostFactory().makeCost(finalCost, finalCost, 0);  
     * tests happen to catch the current shapes, but they are not a substitute for this gate;
            // Prices a PARTIAL above the Exchange out (infinite cost) so it's never chosen.  
    }
            }  
    public List<FieldStorageInfo> getOutputFieldStorage() {
    public Aggregate copy(
            input,
     * the aggregate has no annotations yet (pre-marking) or when copied from a Calcite-internal  
    private static List<ImmutableBitSet> frontGroupSetsForFinal(  
        RelTraitSet traitSet,
        return viableBackends;  
    public AggregateMode getMode() {
                RelTrait trait = getInput().getTraitSet().getTrait(index);
 * compatible open source license.
        Map<Integer, List<RexLiteral>> finalExtraLiteralArgs  
        if (callAnnotations.isEmpty()) {  
 * inferReturnType for functions that read {@code getOperandType(0)} (PPL's
        RelNode input,
    @Override
import org.apache.calcite.plan.RelOptCluster;
     * <p><b>DO NOT REMOVE the SINGLE-mode infinite-cost branch below.</b> It is the correctness
            getCluster(),
import org.opensearch.analytics.spi.FieldStorageInfo;
                    && distribution.getLocality() == OpenSearchDistribution.Locality.COORDINATOR;
                if (hashWorker && distribution.getPartitionCount() != null) {  
            Map.of(),
import org.apache.calcite.rel.logical.LogicalAggregate;  
            getCluster(),  
     * / {@code DistributedAggregateRewriter} machinery the pass reuses):  
                } else {
     * stay coordinator-centric. The {@code groupSet} of a SINGLE aggregate indexes INPUT columns, so the  
        );
     *
    @Override
     *   <li>non-empty group set → require {@code WORKER+HASH(groupKeys, N)} on the input;</li>
 * @opensearch.internal
    @Override
        for (int i = 0; i < getAggCallList().size(); i++) {
            traitSet,
     * read as an agg-state column. No-op for SINGLE/PARTIAL (raw input) and already-fronted sets.
    /**
    public OpenSearchAggregate(
     * rule that doesn't preserve them. Order is stable for {@link #getAnnotations()} /
        }
        return mode;
    }  
        if (mode == AggregateMode.FINAL) {  
            cluster,  
     * <p>PARTIAL is unconstrained (it consumes whatever the child distribution is and emits  
 * <p>Per-call annotations are kept in a side-map keyed by call index — NOT in
        this.callAnnotations = Map.copyOf(callAnnotations);
     *   <li>empty group set (e.g. {@code stats sum(x)} no {@code by}) → require {@code COORDINATOR+SINGLETON}:  
        this.viableBackends = viableBackends;
                traitResolved = true;
        return mode == AggregateMode.FINAL ? ImmutableBitSet.range(groupSet.cardinality()) : groupSet;
            // coord-centric path on high-cardinality GROUP BY despite paying an extra gather
    /** Returns the per-call annotation map (keyed by call index). */
        List<String> viableBackends,
        RelNode input = RelNodeUtils.unwrapHep(getInput());  
    @Override  
    /**  
            finalExtraLiteralArgs,
import org.apache.calcite.util.ImmutableBitSet;
            aggCalls,
import org.apache.calcite.rex.RexLiteral;
        super(  
     * on the prefix range so a non-prefix key (e.g. {@code avg(x) by span(y,5)} → {@code {1}}) isn't
            return traitDef.coordSingleton();  
            children.getFirst(),
                    );  
     * Per-call annotations keyed by call index in {@link #getAggCallList()}. May be empty when
    public static OpenSearchAggregate finalAfterRewrite(OpenSearchAggregate prior, RelNode newInput, List<AggregateCall> rebuiltCalls) {  
            groupSets,
     */  
            // still route coord-centric. Use tinyCost while the trait is unresolved (Volcano's  
        AggregateMode mode  
        List<AggregateCall> aggCalls,
    }  
            }
            mode,
     * <p>TODO(trait-propagation): PARTIAL/FINAL split PLACEMENT is already a trait algebra — see
        // FINAL placement + parallel-merge cost (our hash-shuffle feature): FINAL is legal only over
     */
                deps.addAll(RelNodeUtils.resolvePhysicalDeps(rex, inputStorage));
     * migration ({@code setTopDownOpt} + Calcite {@code PhysicalNode} {@code deriveTraits}/
        this.mode = mode;  
     *       PARTIAL runs wherever the input is, FINAL merges the ≤N partials at the coordinator. The gather
            if (traitResolved) {  
            newInput,
    }
        for (AggregateCall aggCall : getAggCallList()) {
            if (mode == AggregateMode.SINGLE && !inputIsSingleton) {  
 * this file be licensed under the Apache-2.0 license or a
 */
        }
        List<String> viableBackends,
    /** See {@link #perCallIntermediateField}. */
        // (preserving first-seen order across argList, then rexList).  
     * is a pure side-channel for the fragment convertor.
            ? openSearchInput.getOutputFieldStorage()
import org.opensearch.analytics.planner.RelNodeUtils;
     * FINAL reads PARTIAL's output, where Calcite has fronted the group keys to {@code 0..n-1}; group  
        AggregateMode mode,  
                if (!singletonCoord && !hashWorker) {
        OpenSearchDistributionTraitDef traitDef  
        // a COORDINATOR+SINGLETON gather or a WORKER+HASH shuffle, and the HASH case merges in  
        List<AggregateCall> aggCalls  
        List<OperatorAnnotation> annotations = new ArrayList<>(callAnnotations.size());  
                    partitionCount = Math.max(1, distribution.getPartitionCount());
import java.util.LinkedHashMap;
import org.apache.calcite.plan.RelTrait;
     *
        }  
            getTraitSet(),  
import org.apache.calcite.rel.metadata.RelMetadataQuery;
import org.apache.calcite.plan.RelOptCost;
    @Override
     * alternative deterministically (no cost comparison), so this gate is the ONLY thing that
     * SINGLE-mode aggregate over partitioned input is incorrect (each shard would aggregate  
     * machinery. NOTE: the SINGLE-mode infinite-cost gate below is a CORRECTNESS backstop, not cost
        RelOptCluster cluster,  
}
        return new OpenSearchAggregate(
    }  
     * </ul>  
            rebuilt,
 * Calcite's {@code AggCallBinding.preOperands}, which would otherwise corrupt  
     * hash keys are the group-set bits directly.
     * workers in parallel → cost = inputRows / N. The parallelism win is what makes the shuffle
    public OpenSearchDistribution deriveOutputDistribution(
    ) {
        );
    }  
        RelNode input,
    public Map<Integer, AggregateCallAnnotation> getCallAnnotations() {  
     * Aggregate output: group-by fields first (inherited from input), then agg results (derived).
import org.apache.calcite.rel.RelNode;
            : List.of();  
    /**
            AggregateCallAnnotation annotation = callAnnotations.get(i);
                double finalRows = mq.getRowCount(getInput());
        this.perCallIntermediateField = Collections.unmodifiableList(new ArrayList<>(perCallIntermediateField));
     * the PARTIAL half. Hints are not part of the Calcite digest and survive {@code copy}, so this
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {  
                            + "] has no matching FieldStorageInfo entry "
            input,
        RelNode input,  
        // Agg results: derived columns whose physical-deps are the union of arg refs' deps
     * planner can register alternatives during memo expansion before the trait is finalized.
                annotations.add(annotation);
    public List<IntermediateField> getIntermediateFields() {  
                if (argIdx >= inputStorage.size()) {
        if (org.opensearch.analytics.planner.rules.OpenSearchAggregateSplitRule.shouldSkipPartialFinalSplit(this)) {
            }
        List<OpenSearchDistribution> childDistributions,
    public OpenSearchAggregate(  
 *  
            rebuiltCalls,
     * rewriters that run after stripping can still tell the coordinator-side merge half apart from  
            AggregateMode.FINAL,
                            + " columns)"
        return outputStorage;  
                if (distribution.getType() == RelDistribution.Type.ANY) continue;  
                FieldStorageInfo src = inputStorage.get(argIdx);
                            + argIdx
            groupSet,  
     * <ul>
            }
        RelTraitSet traitSet,
        // for high-cardinality GROUP BY).
import org.apache.calcite.rex.RexNode;  
     * feeds a co-partition-sensitive parent in PPL; revisit if a join-on-agg-output shape needs it.)
        return List.of(ImmutableBitSet.range(groupSet.cardinality()));
        ImmutableBitSet groupSet,  
    }  
            RelTrait trait = getInput().getTraitSet().getTrait(index);  
