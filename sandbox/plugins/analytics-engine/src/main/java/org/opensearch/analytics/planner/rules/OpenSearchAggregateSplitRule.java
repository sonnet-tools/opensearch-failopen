     *       PARTIAL's output. When an input column at index {@code k >= groupCount} is a group
        if (!partitioned || childForcesGather(child) || shouldSkipPartialFinalSplit(aggregate)) {  
                    call.getArgList(),
     * can call it.
     * correctness.  
            }  
            child,
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
     *       and materializes {@code SPAN(@timestamp)} at a later position; the agg result at
            } else {
     */  
                continue;
     *       the Aggregate keeps the raw {@code @timestamp} (DATETIME family) at position 0  
        }  
     *       equiv rowtype: RecordType(INTEGER bucket, BIGINT p50)"}. Other aggCalls in the  
        return false;
                projects.add(rexBuilder.makeCast(targetType, ref));  
 * SPDX-License-Identifier: Apache-2.0
        return false;  
        RelTraitSet partialTraits = child.getTraitSet().replace(OpenSearchConvention.INSTANCE);  
     * semantics. In those cases {@link #onMatch} still produces the SINGLE+SINGLETON
     * window sitting behind an intermediate op (e.g. a {@code where} Filter). Unwrap the HEP vertex,
            RelDataType columnType = actualType.getFieldList().get(idx).getType();  
                    repaired,  
                literals.add(lit);
     * Projects (no {@code RexOver}) and Filters; stops at the first gather-forcing op or a terminal.  
     *   <li>{@link OpenSearchJoin} and {@link OpenSearchUnion} (coordinator-gathered today);</li>
            finalAggCalls,
    public static boolean shouldSkipPartialFinalSplit(OpenSearchAggregate aggregate) {
        if (!(RelNodeUtils.unwrapHep(child) instanceof Project project)) {  
     * Pass-through Project / Filter are walked past; scans/values and anything else end the walk
/** Splits an {@link OpenSearchAggregate} into PARTIAL + FINAL when the input is partitioned. */
import java.util.Map;  
 * compatible open source license.
     *       cases (e.g. {@code group={1}} with both columns INTEGER + a NUMERIC agg) pass
            aggregate.getGroupSet().isEmpty()
            AggregateCall call = aggCalls.get(i);
            finalAggregate.getTraitSet(),
        Map<Integer, List<RexLiteral>> captured = new LinkedHashMap<>();
            if (cur instanceof OpenSearchProject project) {
            }  
            rebuilt.set(  
            singletonTraits,
     * {@code getInputs()} is empty, which would end the walk one hop below the aggregate and miss a  
            aggregate.getGroupSet().cardinality(),
        // gather-everything alternative. Volcano has nothing to cost-compare — placement is fixed.
     * Rebuild any LIST/VALUES aggCall to declare {@code ARRAY<actual-arg0>} instead of
            projects,
                i,
            if (call.getArgList().isEmpty()) continue;
            int aggIdx = k - groupCount;
            return false;
            aggregate.getCallAnnotations()
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.rex.RexInputRef;  
     * <p>Public so the general post-CBO distribution-enforcement pass ({@code DistributionEnforcementPass})
        RelNode child = call.rel(1);
        // Exchange placement is deterministic on partitioning, not cost: a SINGLE aggregate over
     * Resolves a node to its concrete rel for the {@link #childForcesGather} walk. During
        Map<Integer, List<RexLiteral>> finalExtraLiterals = captureLiteralArgsForFinal(aggregate.getAggCallList(), child);
            if (cur instanceof OpenSearchSort sort) {
    private static boolean childForcesGather(RelNode node) {
                AggregateCall.create(
            expectedType,
            aggregate.getCallAnnotations(),
        );  
import org.opensearch.analytics.planner.rel.OpenSearchSort;
        }
     * trait is present yet (Volcano still exploring — the cost gate on SINGLE is the backstop).
    /**
            aggregate.getGroupSet(),  
        return false;
            }
                    call.isApproximate(),
    public void onMatch(RelOptRuleCall call) {
            if (fn == null || fn.getType() != AggregateFunction.Type.STATE_EXPANDING) continue;
            AggregateMode.SINGLE,  
            aggregate.getViableBackends(),  
        boolean anyTypeDiffers = false;
     *       same Aggregate (SUM, AVG, etc.) inherit the single-stage execution.</li>
import org.apache.calcite.plan.RelOptRule;
        );
                projects.add(ref);
     * PPL's lossy {@code ARRAY<VARCHAR>}. Pass-through for every other call. Used on the  
     * involved. Returns false for SINGLETON (1 shard / already gathered) or when no distribution  
        }
            aggregate.getViableBackends(),
                continue;  
        RelNode finalAlternative = wrapWithCastIfNeeded(finalAggregate, aggregate);
                if (project.containsOver()) return true;      // window → gathered input
            if (!"LIST".equalsIgnoreCase(name) && !"VALUES".equalsIgnoreCase(name)) continue;  
            aggregate.getCluster(),  
     *   <li>a {@code RexOver}-bearing {@link OpenSearchProject} (window needs gathered input);</li>  
    private static AggregateFunction.Type aggregateType(SqlAggFunction op) {
        // Partitioned + splittable: the split is the only correct plan, so don't register the  
        }
            singletonChild,
import org.apache.calcite.rel.type.RelDataType;
    }
     * Volcano, {@code getInput(0)} returns a {@link RelSubset}, not a concrete rel — its
     * <p>Public so the general post-CBO distribution-enforcement pass ({@code DistributionEnforcementPass})
public class OpenSearchAggregateSplitRule extends RelOptRule {  
    private static boolean isPartitioned(RelNode input) {  
import org.opensearch.analytics.planner.rel.OpenSearchConvention;
import org.apache.calcite.rex.RexBuilder;
            if (rebuilt == null) rebuilt = new ArrayList<>(aggCalls);
        super(operand(OpenSearchAggregate.class, operand(RelNode.class, any())), "OpenSearchAggregateSplitRule");
    /** Wraps FINAL in a CAST-projection when any column type drifts from {@code expected}'s row type; type-only check, name differences pass through. */  
            if (k < groupCount) {
import org.opensearch.analytics.planner.dag.DistributedAggregateRewriter.FinalAggCallBuilder;
    /**  
     * PARTIAL side only — the FINAL keeps the original call list so Volcano's parent
                    call.isDistinct(),
            if (repaired.equals(call.getType())) continue;
     */  
import org.apache.calcite.rel.core.Project;  
     * pass ({@code DistributionEnforcementPass}) shares the exact capture the coord-centric split uses
            org.apache.calcite.rel.type.RelDataType repaired = input.getCluster().getTypeFactory().createArrayType(arg0Type, -1);  
            aggregate.getAggCallList(),  
        OpenSearchAggregate aggregate = call.rel(0);
        );
        for (int i = 0; i < aggCalls.size(); i++) {  
     *       that later position is {@code DOUBLE} (NUMERIC family) → cross-family mismatch
                int colIdx = args.get(a);
import org.opensearch.analytics.planner.rel.OpenSearchDistribution;  
        List<AggregateCall> finalAggCalls = FinalAggCallBuilder.buildFinalCalls(
            aggregate.getCluster(),
        }  
        // streamed the whole table to the coordinator, and biasing it back via row-count estimates
            if (type == AggregateFunction.Type.STATE_EXPANDING) {
import org.apache.calcite.plan.RelTraitSet;
        if (!anyTypeDiffers) return finalAggregate;
            RexNode ref = new RexInputRef(idx, columnType);
     *  
import org.opensearch.analytics.planner.rel.AggregateMode;  
            return null;  
        return captured;
     *   <li><b>percentile_approx</b> is a 2-arg aggregate (field, percent) whose FINAL phase
                }  
        for (int i = 0; i < aggCalls.size(); i++) {
        List<RexNode> projects = project.getProjects();  
     */  
     *       {@code PlanShapeTests.testJoinWithDifferentGroupKeys_multiShard}.</li>  
     *       that agg-result's {@link SqlTypeFamily} differs from the ORIGINAL input column's
     */
        RelNode gathered = convert(partial, finalTraits);
            if (trait instanceof OpenSearchDistribution dist) {  
            }
            intermediateFields  
        // splittable, emit ONLY the PARTIAL/FINAL split; don't also register the gather-everything
     * shares the same correctness gates as this coord-centric split — both use an identical PARTIAL/FINAL  
            if (inputFamily != aggFamily) {
                cur = unwrapForWalk(cur.getInput(0));
     * PARTIAL is unsatisfiable). Walks the single-input chain, descending past pass-through
import org.apache.calcite.rex.RexNode;
            if (args.size() < 2) continue;
        // Split into PARTIAL/FINAL only when the input is genuinely partitioned AND no operator
            String name = call.getAggregation().getName();
            }
    private final PlannerContext context;
import org.apache.calcite.sql.SqlAggFunction;  
        // results would never merge. So when the input is partitioned and the aggregate is
     * (percentile_approx) and ORIGINAL→FINAL groupSet remapping (cross-family non-prefix),
     * </ul>  
     *   <li>a nested {@link OpenSearchAggregate} (its FINAL/SINGLE output is gathered).</li>
                    call.filterArg,  
            return false;
        // singleOnSingleton alternative for Volcano to cost-compare against (that comparison is what  
     * True when a gather-forcing operator sits between this aggregate and its scan, so the
        call.transformTo(finalAlternative);
        // perturbs the global cost model for unrelated query shapes). For unpartitioned input
        List<RelDataType> inputFields = aggregate.getInput().getRowType().getFieldList().stream().map(f -> f.getType()).toList();
            if (cur instanceof OpenSearchFilter) {
import org.opensearch.analytics.planner.RelNodeUtils;
     *
                return true;
        // Build FINAL's aggCalls against gathered's row type so typeMatchesInferred passes.
            return;
import org.opensearch.analytics.spi.AggregateFunction;  
import org.apache.calcite.util.ImmutableBitSet;
                return true;  
        // Classify ORIGINAL aggCalls once and stash on FINAL for post-Volcano transformers.
import java.util.LinkedHashMap;
    public boolean matches(RelOptRuleCall call) {
     * aggregate over it would be incorrect. Reads the input's distribution trait directly — the
        // correct and only choice.
            }
    }
 *
     * True when the input is partitioned across shards (distribution type RANDOM), i.e. a SINGLE  
            );  
     * <ul>
    private static RelNode unwrapForWalk(RelNode node) {
     *       family. PPL {@code timechart}'s no-{@code by} form trips this: the Project below
            // own computeSelfCost (verified: Sort-collated/limited, RexOver-Project, Join, Union,
     * <p>Two cases are unsafe today:  
            aggregate.getGroupSets(),  
            if (aggIdx >= aggCalls.size() || k >= inputFields.size()) {
     *   <li>collated or limited {@link OpenSearchSort} (global order/limit can't run per-shard);</li>
            if (columnType.equals(targetType)) {  
        OpenSearchAggregate singleOnSingleton = new OpenSearchAggregate(
 * The OpenSearch Contributors require contributions made to  
            aggregate.getGroupSets(),  
    public OpenSearchAggregateSplitRule(PlannerContext context) {
     *       {@code "Type mismatch: rel rowtype: RecordType(BIGINT p50, BIGINT p50_0) NOT NULL,
                    call.rexList,
    /**
     * <ul>
            RelTrait trait = input.getTraitSet().getTrait(i);
        RelDataType actualType = finalAggregate.getRowType();
            for (int a = 1; a < args.size(); a++) {
        try {  
                    call.collation,
     *       positions {@code [0..groupCount)}. FINAL reuses ORIGINAL's groupSet against  
                    call.ignoreNulls(),  
            }
        return rebuilt != null ? rebuilt : aggCalls;
        );
import org.opensearch.analytics.planner.rel.OpenSearchProject;  
                return true;  
     * as not-gather-forcing (split allowed).
            // wired at DistributedAggregateRewriter.overrideExchangeType.  
                    call.getAggregation(),  
                    break;
import org.apache.calcite.rex.RexLiteral;
     *       Calcite's relaxed numeric type check and don't need the skip — see
        OpenSearchAggregate finalAggregate = new OpenSearchAggregate(
        List<AggregateCall> rebuilt = null;
        }
            List<Integer> args = call.getArgList();  
                    call.distinctKeys,
    }
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
            }
/*  
import org.opensearch.analytics.planner.PlannerContext;  
            }
            partialAggCalls,
    }  
            if (aggCall.isDistinct()) {
     *       key (e.g. {@code groupSet={2}, groupCount=1}), PARTIAL's output at index {@code k}
            aggregate.getViableBackends(),  
            aggregate.getGroupSets(),
            }
        );
     * in every path.
                anyTypeDiffers = true;
    public static RelNode wrapWithCastIfNeeded(OpenSearchAggregate finalAggregate, OpenSearchAggregate expected) {
    }
                    allLiteral = false;
            finalTraits,  
    public static Map<Integer, List<RexLiteral>> captureLiteralArgsForFinal(List<AggregateCall> aggCalls, RelNode child) {
        } catch (IllegalStateException ignored) {
    }  
     *       single-field rewrite paths only produce a single-arg FINAL call, yielding
    /**
            if (cur instanceof OpenSearchJoin || cur instanceof OpenSearchUnion || cur instanceof OpenSearchAggregate) {
     */
import org.apache.calcite.plan.RelTrait;  
            aggregate.getCluster(),
        }  
        RelNode unwrapped = RelNodeUtils.unwrapHep(node);
     *   <li><b>Cross-family non-prefix groupSet</b>: PARTIAL's output places group keys at
import org.apache.calcite.plan.RelOptRuleCall;
        while (cur != null) {  
                    call.getName()
            finalAggregate,  
        RelTraitSet finalTraits = partial.getTraitSet().replace(context.getDistributionTraitDef().coordSingleton());  
            intermediateFields,
            aggregate.getCallAnnotations()
     * True when PARTIAL/FINAL split would yield a malformed row type or invalid aggregate
            org.apache.calcite.rel.type.RelDataType arg0Type = input.getRowType().getFieldList().get(call.getArgList().get(0)).getType();
            RelDataType targetType = expectedType.getFieldList().get(idx).getType();
        List<AggregateCall> aggCalls = aggregate.getAggCallList();
                captured.put(i, List.copyOf(literals));
     * {@code computeSelfCost}, so Volcano gathers below them):  
            finalExtraLiterals,
                continue;
            call.transformTo(singleOnSingleton);
import java.util.List;
     *       needs (tdigest_state, percent_literal). {@code AggregateDecompositionResolver}'s  
        OpenSearchAggregate partial = new OpenSearchAggregate(
            SqlTypeFamily inputFamily = inputFields.get(k).getSqlTypeName().getFamily();
            }  
        }  
        // Non-prefix groupSet: a group-key at k >= groupCount lands on PARTIAL's agg-output slot.  
     * PARTIAL/FINAL is invalid (the PARTIAL would sit over SINGLETON input, and the shard-side
import org.apache.calcite.rel.core.AggregateCall;
import org.apache.calcite.sql.type.SqlTypeFamily;
     * alternative (so the planner can route shard input through a coordinator gather), but  
        RelTraitSet singletonTraits = aggregate.getTraitSet().replace(context.getDistributionTraitDef().coordSingleton());  
import org.apache.calcite.rel.RelNode;
    }
        RelDataType expectedType = expected.getRowType();  
            gathered,
            aggregate.getGroupSet(),
        List<IntermediateField> intermediateFields = FinalAggCallBuilder.classify(aggregate.getAggCallList());
    @Override
                return !sort.getCollation().getFieldCollations().isEmpty() || sort.fetch != null || sort.offset != null;
    }
            }  
     *       is an agg-result instead, and Calcite's row-type equivalence check fires only if  
        for (int i = 0; i < input.getTraitSet().size(); i++) {
        // (1 shard / already gathered) or a non-splittable aggregate, the single-stage plan is the  
}  
            gathered,  
            // nested Aggregate), so Volcano gathers below them → our input is already singleton.  
            if (allLiteral && !literals.isEmpty()) {  
     *
import org.opensearch.analytics.spi.AggregateFunction.IntermediateField;
        this.context = context;  
            // Residual DISTINCT (e.g. multi-arg COUNT(DISTINCT a, b) that didn't match the
    }  
        return aggregate.getMode() == AggregateMode.SINGLE;  
            // can't decompose into per-shard partials reduced additively. APPROXIMATE goes through
            // other shape we don't explicitly treat as gather-forcing. Conservative: allow split.  
        // would be invalid). Otherwise emit the single coordinator aggregate.
            AggregateCall call = aggCalls.get(i);  
        RexBuilder rexBuilder = finalAggregate.getCluster().getRexBuilder();
     * safety check, so STATE_EXPANDING / DISTINCT / cross-family-non-prefix shapes stay coordinator-centric
        boolean partitioned = isPartitioned(child);
        RelNode cur = unwrapForWalk(node);
        // partitioned (RANDOM) input is incorrect — each shard would aggregate in isolation and the  
        List<RexNode> projects = new ArrayList<>(actualType.getFieldCount());  
 */  
     * <p>Gather-forcing operators (each returns infinite cost over non-SINGLETON input in its own
            // Terminals that do not force a gather: TableScan / StageInputScan / Values, or any
    public static List<AggregateCall> repairLossyReturnTypes(List<AggregateCall> aggCalls, RelNode input) {
            SqlTypeFamily aggFamily = aggCalls.get(aggIdx).getType().getSqlTypeName().getFamily();  
import org.apache.calcite.rel.RelDistribution;  
                cur = unwrapForWalk(cur.getInput(0));          // pass-through project → keep walking  
     * {@code Project} so FINAL can re-project them. Public so the general post-CBO distribution-enforcement
                )
    @Override  
import org.apache.calcite.plan.volcano.RelSubset;
     *
            // Pass-through, non-gathering: Filter (q37's split must still happen) → keep walking.  
            // OpenSearchDistinctCountRule single-arg rewrite) gathers to the coordinator.  
        }
                return true;
        return unwrapped instanceof RelSubset subset ? subset.getBestOrOriginal() : unwrapped;  
     * row-type check on transformTo passes.
     * <p>Until {@code AggregateDecompositionResolver} gains engine-native merge support  
     */  
            finalAggregate.getViableBackends()  
            // STATE_EXPANDING aggregates (TAKE/FIRST/LAST/LIST/VALUES/PERCENTILE_APPROX/PATTERN)  
    }
            // Gather-forcing operators: each returns infinite cost over non-SINGLETON input in its
     * then resolve a subset to its representative rel via {@code getBestOrOriginal()}.
     * skips the PARTIAL+ER+FINAL alternative.
        RelNode singletonChild = convert(child, singletonTraits);
     * (keeps PARTIAL/FINAL literal handling identical).  
            boolean allLiteral = true;  
        for (int k : aggregate.getGroupSet().toArray()) {  
            AggregateFunction fn = AggregateFunction.fromSqlAggFunction(call.getAggregation());
        if (aggregate.getGroupSet().equals(ImmutableBitSet.range(groupCount))) {  
            List<RexLiteral> literals = new ArrayList<>(args.size() - 1);
     * same deterministic, shard-count-driven signal the Join/Union split rules use, no cost model
            return AggregateFunction.fromSqlAggFunction(op).getType();
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
     * Captures the literal config args (e.g. TAKE's N) of STATE_EXPANDING aggregates from the child  
                if (colIdx < 0 || colIdx >= projects.size() || !(projects.get(colIdx) instanceof RexLiteral lit)) {  
        // Empty-group nullability gap (COUNT→SUM swap): wrap FINAL so its row type matches SINGLE's.  
                return true;
import java.util.ArrayList;  
            AggregateFunction.Type type = aggregateType(aggCall.getAggregation());
            aggregate.getGroupSet(),
        int groupCount = aggregate.getGroupSet().cardinality();
    /**
        }
     *
            return Map.of();
        for (AggregateCall aggCall : aggregate.getAggCallList()) {
     * aggregate's input is already (or will be) gathered to one node — splitting it into  
package org.opensearch.analytics.planner.rules;
     *       ({@code "Type mismatch ... DOUBLE -> TIMESTAMP(0)"}). Same-family non-prefix  
     * the split is conservative in those shapes — distributed parallelism is traded for
        List<AggregateCall> partialAggCalls = repairLossyReturnTypes(aggregate.getAggCallList(), child);
            partialTraits,  
                return dist.getType() == RelDistribution.Type.RANDOM_DISTRIBUTED;
    /**  
            aggregate.getAggCallList(),
        return new OpenSearchProject(  
        OpenSearchAggregate aggregate = call.rel(0);  
     * </ul>
        // below forces a gather (a gather-forced input is already singleton — a PARTIAL over it  
            }  
    }
import org.opensearch.analytics.planner.rel.OpenSearchUnion;
            AggregateMode.FINAL,
            AggregateMode.PARTIAL,
            finalAggregate.getCluster(),
        }
            // the structural split — its engine-native merge (sketch state, reducer == self) is
        for (int idx = 0; idx < actualType.getFieldCount(); idx++) {
