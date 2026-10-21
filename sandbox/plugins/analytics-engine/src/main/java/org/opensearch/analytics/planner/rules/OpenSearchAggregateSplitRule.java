            for (int a = 1; a < args.size(); a++) {
 */
            // STATE_EXPANDING aggregates (TAKE/FIRST/LAST/LIST/VALUES/PERCENTILE_APPROX/PATTERN)
        if (aggregate.getGroupSet().equals(ImmutableBitSet.range(groupCount))) {
            if (type == AggregateFunction.Type.STATE_EXPANDING) {
 * compatible open source license.
            aggregate.getGroupSet(),
            // nested Aggregate), so Volcano gathers below them → our input is already singleton.
        super(operand(OpenSearchAggregate.class, operand(RelNode.class, any())), "OpenSearchAggregateSplitRule");
     * {@code computeSelfCost}, so Volcano gathers below them):
        // Non-prefix groupSet: a group-key at k >= groupCount lands on PARTIAL's agg-output slot.
        }
            // Residual DISTINCT (e.g. multi-arg COUNT(DISTINCT a, b) that didn't match the
     * <p>Public so the general post-CBO distribution-enforcement pass ({@code DistributionEnforcementPass})
     * PARTIAL/FINAL is invalid (the PARTIAL would sit over SINGLETON input, and the shard-side
            org.apache.calcite.rel.type.RelDataType repaired = input.getCluster().getTypeFactory().createArrayType(arg0Type, -1);
                    call.collation,
            if (aggIdx >= aggCalls.size() || k >= inputFields.size()) {
import org.opensearch.analytics.planner.rel.AggregateMode;
    public OpenSearchAggregateSplitRule(PlannerContext context) {
        boolean partitioned = isPartitioned(child);
            }
            } else {
        return aggregate.getMode() == AggregateMode.SINGLE;
import java.util.LinkedHashMap;
            finalAggCalls,
            }
     *       {@code "Type mismatch: rel rowtype: RecordType(BIGINT p50, BIGINT p50_0) NOT NULL,
            aggregate.getViableBackends(),
                return true;
            int aggIdx = k - groupCount;
     *   <li>a nested {@link OpenSearchAggregate} (its FINAL/SINGLE output is gathered).</li>
    public static Map<Integer, List<RexLiteral>> captureLiteralArgsForFinal(List<AggregateCall> aggCalls, RelNode child) {
     *       is an agg-result instead, and Calcite's row-type equivalence check fires only if
    /**
        for (int idx = 0; idx < actualType.getFieldCount(); idx++) {
        while (cur != null) {
            expectedType,
            RelTrait trait = input.getTraitSet().getTrait(i);
import org.opensearch.analytics.planner.RelNodeUtils;
        OpenSearchAggregate singleOnSingleton = new OpenSearchAggregate(
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
        if (!(RelNodeUtils.unwrapHep(child) instanceof Project project)) {
        RelNode gathered = convert(partial, finalTraits);
            partialAggCalls,
     *       Calcite's relaxed numeric type check and don't need the skip — see
    }
     *       same Aggregate (SUM, AVG, etc.) inherit the single-stage execution.</li>
import org.apache.calcite.plan.RelTrait;
                    allLiteral = false;
            if (call.getArgList().isEmpty()) continue;
        return rebuilt != null ? rebuilt : aggCalls;
    public static List<AggregateCall> repairLossyReturnTypes(List<AggregateCall> aggCalls, RelNode input) {
     * <p>Until {@code AggregateDecompositionResolver} gains engine-native merge support
            String name = call.getAggregation().getName();
            if (cur instanceof OpenSearchProject project) {
/*
     *       cases (e.g. {@code group={1}} with both columns INTEGER + a NUMERIC agg) pass
            SqlTypeFamily aggFamily = aggCalls.get(aggIdx).getType().getSqlTypeName().getFamily();
        }
            // Pass-through, non-gathering: Filter (q37's split must still happen) → keep walking.
                if (colIdx < 0 || colIdx >= projects.size() || !(projects.get(colIdx) instanceof RexLiteral lit)) {
     * Projects (no {@code RexOver}) and Filters; stops at the first gather-forcing op or a terminal.
        // results would never merge. So when the input is partitioned and the aggregate is
        }
public class OpenSearchAggregateSplitRule extends RelOptRule {
     *       positions {@code [0..groupCount)}. FINAL reuses ORIGINAL's groupSet against
            singletonChild,
            aggregate.getGroupSet(),
     *       PARTIAL's output. When an input column at index {@code k >= groupCount} is a group
     * row-type check on transformTo passes.
     */
        RelTraitSet finalTraits = partial.getTraitSet().replace(context.getDistributionTraitDef().coordSingleton());
     *
            return false;
     * <p>Gather-forcing operators (each returns infinite cost over non-SINGLETON input in its own
     *   <li>{@link OpenSearchJoin} and {@link OpenSearchUnion} (coordinator-gathered today);</li>
     *       that later position is {@code DOUBLE} (NUMERIC family) → cross-family mismatch
            if (allLiteral && !literals.isEmpty()) {
     * <p>Two cases are unsafe today:
     * PARTIAL is unsatisfiable). Walks the single-input chain, descending past pass-through
            if (cur instanceof OpenSearchJoin || cur instanceof OpenSearchUnion || cur instanceof OpenSearchAggregate) {
                projects.add(ref);
import org.apache.calcite.plan.RelOptRuleCall;
     * same deterministic, shard-count-driven signal the Join/Union split rules use, no cost model
     * the split is conservative in those shapes — distributed parallelism is traded for
            aggregate.getAggCallList(),
    public boolean matches(RelOptRuleCall call) {
     * Rebuild any LIST/VALUES aggCall to declare {@code ARRAY<actual-arg0>} instead of
            AggregateCall call = aggCalls.get(i);
            finalAggregate.getViableBackends()
     */
                projects.add(rexBuilder.makeCast(targetType, ref));
     * Resolves a node to its concrete rel for the {@link #childForcesGather} walk. During
import org.opensearch.analytics.planner.rel.OpenSearchUnion;
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
}
            if (columnType.equals(targetType)) {
    public static boolean shouldSkipPartialFinalSplit(OpenSearchAggregate aggregate) {
        }
            finalAggregate,
            child,
        // Exchange placement is deterministic on partitioning, not cost: a SINGLE aggregate over
            org.apache.calcite.rel.type.RelDataType arg0Type = input.getRowType().getFieldList().get(call.getArgList().get(0)).getType();
import java.util.List;
            finalTraits,
            // own computeSelfCost (verified: Sort-collated/limited, RexOver-Project, Join, Union,
        // would be invalid). Otherwise emit the single coordinator aggregate.
     *       single-field rewrite paths only produce a single-arg FINAL call, yielding
                i,
            return null;
                    call.isDistinct(),
        RelNode child = call.rel(1);
import org.apache.calcite.util.ImmutableBitSet;
        RelNode unwrapped = RelNodeUtils.unwrapHep(node);
                    call.ignoreNulls(),
    /**
        );
     */
        }
            aggregate.getGroupSet().cardinality(),
        RelNode singletonChild = convert(child, singletonTraits);
        return false;
        }
import org.apache.calcite.plan.RelTraitSet;
        try {
     *       ({@code "Type mismatch ... DOUBLE -> TIMESTAMP(0)"}). Same-family non-prefix
    /**
        List<RexNode> projects = new ArrayList<>(actualType.getFieldCount());
            }
    /**
    public static RelNode wrapWithCastIfNeeded(OpenSearchAggregate finalAggregate, OpenSearchAggregate expected) {
                    call.getAggregation(),
            }
import org.apache.calcite.plan.volcano.RelSubset;
    @Override
        List<AggregateCall> rebuilt = null;
     * in every path.
    @Override
        for (int i = 0; i < aggCalls.size(); i++) {
            // Gather-forcing operators: each returns infinite cost over non-SINGLETON input in its
        OpenSearchAggregate finalAggregate = new OpenSearchAggregate(
                AggregateCall.create(
                    call.isApproximate(),
            }
        return captured;
     * {@code getInputs()} is empty, which would end the walk one hop below the aggregate and miss a
    private static boolean childForcesGather(RelNode node) {
     * as not-gather-forcing (split allowed).
            aggregate.getCluster(),
        Map<Integer, List<RexLiteral>> captured = new LinkedHashMap<>();
     *   <li>a {@code RexOver}-bearing {@link OpenSearchProject} (window needs gathered input);</li>
    }
        return false;
                continue;
                }
     * </ul>
     */
            // OpenSearchDistinctCountRule single-arg rewrite) gathers to the coordinator.
    }
        for (int k : aggregate.getGroupSet().toArray()) {
import org.apache.calcite.sql.SqlAggFunction;
            aggregate.getGroupSet(),
            }
                cur = unwrapForWalk(cur.getInput(0));          // pass-through project → keep walking
        // below forces a gather (a gather-forced input is already singleton — a PARTIAL over it
     * aggregate over it would be incorrect. Reads the input's distribution trait directly — the
            if (aggCall.isDistinct()) {
                continue;
            }
     *
            finalExtraLiterals,
            if (cur instanceof OpenSearchSort sort) {
    }
import org.opensearch.analytics.spi.AggregateFunction;
        call.transformTo(finalAlternative);
import org.opensearch.analytics.planner.rel.OpenSearchProject;
            projects,
        List<IntermediateField> intermediateFields = FinalAggCallBuilder.classify(aggregate.getAggCallList());
            }
import org.apache.calcite.rex.RexLiteral;
            aggregate.getCluster(),
    /** Wraps FINAL in a CAST-projection when any column type drifts from {@code expected}'s row type; type-only check, name differences pass through. */
import org.opensearch.analytics.planner.rel.OpenSearchDistribution;
            AggregateMode.FINAL,
            if (k < groupCount) {
        }
        List<AggregateCall> aggCalls = aggregate.getAggCallList();
     * then resolve a subset to its representative rel via {@code getBestOrOriginal()}.
        }
     * shares the same correctness gates as this coord-centric split — both use an identical PARTIAL/FINAL
            // can't decompose into per-shard partials reduced additively. APPROXIMATE goes through
        boolean anyTypeDiffers = false;
            // the structural split — its engine-native merge (sketch state, reducer == self) is
            return AggregateFunction.fromSqlAggFunction(op).getType();
        for (int i = 0; i < aggCalls.size(); i++) {
    }
     *
            if (rebuilt == null) rebuilt = new ArrayList<>(aggCalls);
     * {@code Project} so FINAL can re-project them. Public so the general post-CBO distribution-enforcement
            aggregate.getCallAnnotations()
            return Map.of();
 *
        );
        OpenSearchAggregate aggregate = call.rel(0);
                return dist.getType() == RelDistribution.Type.RANDOM_DISTRIBUTED;
            RelDataType targetType = expectedType.getFieldList().get(idx).getType();
import org.apache.calcite.sql.type.SqlTypeFamily;
        );
     * window sitting behind an intermediate op (e.g. a {@code where} Filter). Unwrap the HEP vertex,
        );
            RelDataType columnType = actualType.getFieldList().get(idx).getType();
                    repaired,
            aggregate.getAggCallList(),
            aggregate.getGroupSet().isEmpty()
                    call.rexList,
                if (project.containsOver()) return true;      // window → gathered input
     */
        RexBuilder rexBuilder = finalAggregate.getCluster().getRexBuilder();
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
            // Terminals that do not force a gather: TableScan / StageInputScan / Values, or any
     * trait is present yet (Volcano still exploring — the cost gate on SINGLE is the backstop).
                return true;
                continue;
        RelNode finalAlternative = wrapWithCastIfNeeded(finalAggregate, aggregate);
        // Partitioned + splittable: the split is the only correct plan, so don't register the
import org.apache.calcite.rex.RexNode;
import org.opensearch.analytics.planner.PlannerContext;
     *       key (e.g. {@code groupSet={2}, groupCount=1}), PARTIAL's output at index {@code k}
                return true;
        RelDataType actualType = finalAggregate.getRowType();
    private static AggregateFunction.Type aggregateType(SqlAggFunction op) {
    public void onMatch(RelOptRuleCall call) {
            boolean allLiteral = true;
            if (inputFamily != aggFamily) {
            return;
            gathered,
        // (1 shard / already gathered) or a non-splittable aggregate, the single-stage plan is the
     * aggregate's input is already (or will be) gathered to one node — splitting it into
                captured.put(i, List.copyOf(literals));
     * (percentile_approx) and ORIGINAL→FINAL groupSet remapping (cross-family non-prefix),
        return new OpenSearchProject(
     * True when PARTIAL/FINAL split would yield a malformed row type or invalid aggregate
     * </ul>
import org.apache.calcite.rel.RelNode;
            aggregate.getViableBackends(),
            AggregateMode.SINGLE,
                    call.filterArg,
 * The OpenSearch Contributors require contributions made to
        }
    }
     * Pass-through Project / Filter are walked past; scans/values and anything else end the walk
     *       and materializes {@code SPAN(@timestamp)} at a later position; the agg result at
     *       needs (tdigest_state, percent_literal). {@code AggregateDecompositionResolver}'s
                    call.distinctKeys,
        int groupCount = aggregate.getGroupSet().cardinality();
import org.apache.calcite.plan.RelOptRule;
            List<RexLiteral> literals = new ArrayList<>(args.size() - 1);
     * skips the PARTIAL+ER+FINAL alternative.
        } catch (IllegalStateException ignored) {
        for (AggregateCall aggCall : aggregate.getAggCallList()) {
import org.opensearch.analytics.spi.AggregateFunction.IntermediateField;
        if (!partitioned || childForcesGather(child) || shouldSkipPartialFinalSplit(aggregate)) {
/** Splits an {@link OpenSearchAggregate} into PARTIAL + FINAL when the input is partitioned. */
    private static boolean isPartitioned(RelNode input) {
            List<Integer> args = call.getArgList();
        List<AggregateCall> finalAggCalls = FinalAggCallBuilder.buildFinalCalls(
            aggregate.getViableBackends(),
     * PARTIAL side only — the FINAL keeps the original call list so Volcano's parent
    /**
                    break;
import org.apache.calcite.rel.core.AggregateCall;
        }
            aggregate.getGroupSets(),
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
            SqlTypeFamily inputFamily = inputFields.get(k).getSqlTypeName().getFamily();
import org.opensearch.analytics.planner.dag.DistributedAggregateRewriter.FinalAggCallBuilder;
import org.apache.calcite.rel.type.RelDataType;
     * PPL's lossy {@code ARRAY<VARCHAR>}. Pass-through for every other call. Used on the
    }
            aggregate.getGroupSets(),
        // splittable, emit ONLY the PARTIAL/FINAL split; don't also register the gather-everything
            finalAggregate.getTraitSet(),
            }
            RexNode ref = new RexInputRef(idx, columnType);
     *       family. PPL {@code timechart}'s no-{@code by} form trips this: the Project below
            aggregate.getGroupSets(),
        return false;
     *   <li>collated or limited {@link OpenSearchSort} (global order/limit can't run per-shard);</li>
            // other shape we don't explicitly treat as gather-forcing. Conservative: allow split.
            }
        // Empty-group nullability gap (COUNT→SUM swap): wrap FINAL so its row type matches SINGLE's.
     * semantics. In those cases {@link #onMatch} still produces the SINGLE+SINGLETON
            if (cur instanceof OpenSearchFilter) {
    /**
                return !sort.getCollation().getFieldCollations().isEmpty() || sort.fetch != null || sort.offset != null;
        // singleOnSingleton alternative for Volcano to cost-compare against (that comparison is what
            call.transformTo(singleOnSingleton);
            if (trait instanceof OpenSearchDistribution dist) {
                    call.getName()
            AggregateCall call = aggCalls.get(i);
                return true;
        return unwrapped instanceof RelSubset subset ? subset.getBestOrOriginal() : unwrapped;
                cur = unwrapForWalk(cur.getInput(0));
        RelNode cur = unwrapForWalk(node);
            intermediateFields
    }
     * Volcano, {@code getInput(0)} returns a {@link RelSubset}, not a concrete rel — its
            singletonTraits,
     * <ul>
            aggregate.getCallAnnotations()
                int colIdx = args.get(a);
        );
        // Classify ORIGINAL aggCalls once and stash on FINAL for post-Volcano transformers.
     * True when the input is partitioned across shards (distribution type RANDOM), i.e. a SINGLE
     *       that agg-result's {@link SqlTypeFamily} differs from the ORIGINAL input column's
            partialTraits,
import org.apache.calcite.rex.RexBuilder;
                    call.getArgList(),
     *       {@code PlanShapeTests.testJoinWithDifferentGroupKeys_multiShard}.</li>
import org.opensearch.analytics.planner.rel.OpenSearchSort;
            if (!"LIST".equalsIgnoreCase(name) && !"VALUES".equalsIgnoreCase(name)) continue;
     * pass ({@code DistributionEnforcementPass}) shares the exact capture the coord-centric split uses
     * <p>Public so the general post-CBO distribution-enforcement pass ({@code DistributionEnforcementPass})
            AggregateMode.PARTIAL,
package org.opensearch.analytics.planner.rules;
     * True when a gather-forcing operator sits between this aggregate and its scan, so the
            }
            AggregateFunction fn = AggregateFunction.fromSqlAggFunction(call.getAggregation());
import org.apache.calcite.rex.RexInputRef;
            if (repaired.equals(call.getType())) continue;
import org.apache.calcite.rel.RelDistribution;
            finalAggregate.getCluster(),
        }
     * correctness.
     *       the Aggregate keeps the raw {@code @timestamp} (DATETIME family) at position 0
     */
            gathered,
    }
        OpenSearchAggregate partial = new OpenSearchAggregate(
            }
     *
     * safety check, so STATE_EXPANDING / DISTINCT / cross-family-non-prefix shapes stay coordinator-centric
     * Captures the literal config args (e.g. TAKE's N) of STATE_EXPANDING aggregates from the child
            AggregateFunction.Type type = aggregateType(aggCall.getAggregation());
        // correct and only choice.
     * <ul>
     * alternative (so the planner can route shard input through a coordinator gather), but
        // Build FINAL's aggCalls against gathered's row type so typeMatchesInferred passes.
                )
            rebuilt.set(
    private static RelNode unwrapForWalk(RelNode node) {
        // streamed the whole table to the coordinator, and biasing it back via row-count estimates
            );
import org.apache.calcite.rel.core.Project;
     *   <li><b>Cross-family non-prefix groupSet</b>: PARTIAL's output places group keys at
            if (args.size() < 2) continue;
        if (!anyTypeDiffers) return finalAggregate;
     * (keeps PARTIAL/FINAL literal handling identical).
        OpenSearchAggregate aggregate = call.rel(0);
            // wired at DistributedAggregateRewriter.overrideExchangeType.
            }
     *   <li><b>percentile_approx</b> is a 2-arg aggregate (field, percent) whose FINAL phase
     * involved. Returns false for SINGLETON (1 shard / already gathered) or when no distribution
     *
    private final PlannerContext context;
 * SPDX-License-Identifier: Apache-2.0
        List<RexNode> projects = project.getProjects();
        // gather-everything alternative. Volcano has nothing to cost-compare — placement is fixed.
     *       equiv rowtype: RecordType(INTEGER bucket, BIGINT p50)"}. Other aggCalls in the
            if (fn == null || fn.getType() != AggregateFunction.Type.STATE_EXPANDING) continue;
        // Split into PARTIAL/FINAL only when the input is genuinely partitioned AND no operator
            aggregate.getCallAnnotations(),
        List<RelDataType> inputFields = aggregate.getInput().getRowType().getFieldList().stream().map(f -> f.getType()).toList();
import org.opensearch.analytics.planner.rel.OpenSearchConvention;
                return true;
import java.util.ArrayList;
        this.context = context;
            intermediateFields,
                anyTypeDiffers = true;
            aggregate.getCluster(),
            return false;
    }
                literals.add(lit);
        // perturbs the global cost model for unrelated query shapes). For unpartitioned input
        RelDataType expectedType = expected.getRowType();
        RelTraitSet partialTraits = child.getTraitSet().replace(OpenSearchConvention.INSTANCE);
    }
        // partitioned (RANDOM) input is incorrect — each shard would aggregate in isolation and the
     * can call it.
        for (int i = 0; i < input.getTraitSet().size(); i++) {
        Map<Integer, List<RexLiteral>> finalExtraLiterals = captureLiteralArgsForFinal(aggregate.getAggCallList(), child);
        RelTraitSet singletonTraits = aggregate.getTraitSet().replace(context.getDistributionTraitDef().coordSingleton());
        List<AggregateCall> partialAggCalls = repairLossyReturnTypes(aggregate.getAggCallList(), child);
