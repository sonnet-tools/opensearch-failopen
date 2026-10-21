            getRowType(),
    @Override
    }
        );
        OpenSearchDistributionTraitDef traitDef
import java.util.LinkedHashMap;
                result.add(inputStorage.get(ref.getIndex()));
            List.of(backend),
            }
        }
 */
            @Override
        RexShuttle rewriter = new RexShuttle() {
        for (int i = 0; i < getProjects().size(); i++) {
    @Override
import org.apache.calcite.rel.RelDistribution;
        RexShuttle collector = new RexShuttle() {
        Project lifted = liftNestedRexOver(strippedChildren.getFirst(), strippedExprs);
     * <p>Plain projects (neither) have no ordering requirement — tiny cost unconditionally.
        org.apache.calcite.util.mapping.Mappings.TargetMapping mapping = Project.getPartialMapping(
     * input column {@code k} moves to wherever the projection places {@code k} (and degrades to ANY if the
    @Override
        // both data_range operand and max_value operand of width_bucket) is hoisted once
            return null;
        }
            overIndex.put(entry.getKey(), nextSlot++);
        return planner.getCostFactory().makeTinyCost();
            return traitDef.coordSingleton();
        // the same RexOver from multiple expressions (e.g. MAX(f) OVER () appearing as
    ) {
        // Top-level baseline operators (BASELINE_SCALAR_OPS — COALESCE, CASE, CAST, arithmetic,
import java.util.ArrayList;
        for (RexNode expr : getProjects()) {
/*
import org.apache.calcite.plan.RelOptPlanner;
        // width_bucket(f, N, MAX(f) OVER () - MIN(f) OVER (), MAX(f) OVER ())
            RelTrait trait = getInput().getTraitSet().getTrait(i);
     *
            }
        }
        //
                RexNode resolved = annotationResolver.apply(annotated);
     * {@code getPartialMapping}. A window/pinned project gathered its input to SINGLETON, so its output is
                // resolve. Running the shuttle is defensive and idempotent — atomic nodes
            expr.accept(collector);
    @Override
        super(cluster, traitSet, List.of(), input, projects, rowType);
                return over;
        List<String> viableBackends
        this.viableBackends = viableBackends;
        };
     * SINGLETON. Returns {@code null} when the child distribution is unknown.
        // Build the lower-Project expressions: passthrough every input field as RexInputRef,
        );
        this(cluster, traitSet, input, projects, rowType, viableBackends, false);
     * sits under this project.
     * return infinite cost unless input is SINGLETON/ANY — Volcano then picks the plan where an ER
    public List<OperatorAnnotation> getAnnotations() {
                resolvedExprs.add((RexNode) resolvedAnnotations.get(annotationIndex++));
            }
import java.util.List;
    private Project liftNestedRexOver(RelNode input, List<RexNode> outerExprs) {
import java.util.Map;
import org.apache.calcite.rex.RexInputRef;
import org.apache.calcite.rex.RexNode;
            return planner.getCostFactory().makeTinyCost();
        // wrapper is unwrapped (defaults to OperatorAnnotation::unwrap, returning the original
        Map<String, Integer> overIndex = new LinkedHashMap<>();
import org.apache.calcite.rex.RexShuttle;
import org.opensearch.analytics.planner.RelNodeUtils;
    public boolean isPinAboveExchange() {
    public RelNode stripAnnotations(List<RelNode> strippedChildren, Function<OperatorAnnotation, RexNode> annotationResolver) {
        // DataFusion's substrait consumer auto-lifts *top-level* WindowFunction project
        // with "Physical plan does not support logical expression WindowFunction(...)".
            if (expr instanceof AnnotatedProjectExpression annotation) {
        }
        List<FieldStorageInfo> result = new ArrayList<>(getProjects().size());
            @Override
        // overIndex maps "over digest" → its column index in the lower Project's output.
        // nested wrappers. Substrait conversion only recognizes the underlying RexCall shape,
                    return nested.getOriginal().accept(this);
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {
        // so every wrapper at every depth must be removed before the plan is handed to a
        Project lowerProject = LogicalProject.create(input, List.of(), lowerExprs, (List<String>) null);
        // Collect unique RexOvers from the expression trees. LinkedHashMap by digest so
            lowerExprs.add(entry.getValue());
                result.add(FieldStorageInfo.derivedColumn(fieldName, getRowType().getFieldList().get(i).getType().getSqlTypeName(), deps));
        RelNode input,
            getInput().getRowType().getFieldCount(),
        }
    private final List<String> viableBackends;
            if (expr instanceof AnnotatedProjectExpression) {
     * {@link #computeSelfCost} returns infinite cost unless its input is already gathered
        int annotationIndex = 0;
    /** See {@link #pinAboveExchange}. */
    public OpenSearchProject(
                if (slot == null) {
import java.util.function.Function;
    }
     * Projects containing {@code RexOver} (window functions) need fully-gathered input so the
        RelOptCluster cluster,
    public Project copy(RelTraitSet traitSet, RelNode input, List<RexNode> projects, RelDataType rowType) {
}
        List<RexNode> lowerExprs = new ArrayList<>(inputFieldCount + uniqueOvers.size());
        // where they are and reach DataFusion's physical planner — which then errors
    @Override
        for (int i = 0; i < inputFieldCount; i++) {
 * compatible open source license.
import java.util.LinkedHashSet;
     * A plain project passes the child's distribution through, REMAPPED to output columns: a hash key at
        return stripAnnotations(strippedChildren, OperatorAnnotation::unwrap);
        // Rewrite outer expressions: replace each RexOver with a RexInputRef into the
     * unpinned, physical-only Project pushes below the gather for projection-pushdown. Mirrors the
    public OpenSearchProject(
        }
        // and shares a single column slot.
        // lower Project's output. Field names of the lower Project are anonymous (Calcite
        // wraps them in a LogicalWindow as expected.
import org.apache.calcite.plan.RelOptCluster;
    }
        // RexNode); a RexShuttle then sweeps the resolver's result to strip any remaining
    }
    }
     * window's global frame semantics are correct. Projects flagged {@link #pinAboveExchange} must
        if (lifted != null) {
            @Override
    public List<FieldStorageInfo> getOutputFieldStorage() {
        }
     */
        return LogicalProject.create(strippedChildren.getFirst(), List.of(), strippedExprs, getRowType());
        if (uniqueOvers.isEmpty()) {
        org.apache.calcite.rel.RelDistribution remapped = childDist.apply(mapping);
    }
        return viableBackends;
        RexShuttle nestedAnnotationStripper = new RexShuttle() {
        RelDataType rowType,
    public RelOptCost computeSelfCost(RelOptPlanner planner, RelMetadataQuery mq) {
            getProjects()
        return annotations;
        LinkedHashMap<String, RexOver> uniqueOvers = new LinkedHashMap<>();
        if (!(input instanceof OpenSearchRelNode openSearchChild)) {
        return remapped instanceof OpenSearchDistribution osDist ? osDist : null;
        return traitDef.coordSingleton();
     */
                // Pass-through expressions (RexInputRef, RexLiteral) have no annotation to
        // IS_NULL, …) bypass the AnnotatedProjectExpression wrap at the call site, but their
    }
import org.apache.calcite.rex.RexBuilder;
        for (RexNode expr : outerExprs) {
     * likewise stay in the coordinator fragment (they carry an aggregate's literal config arg). Both
        };
                    return planner.getCostFactory().makeInfiniteCost();
    }
    // ---- DistributionAware (Option B post-CBO enforcement pass) ----
                boolean singletonOrAny = distribution.getType() == RelDistribution.Type.SINGLETON
import org.apache.calcite.plan.RelTrait;
        // and the outer Project's expressions reference those new columns by index.
        for (int i = 0; i < getInput().getTraitSet().size(); i++) {
import org.opensearch.analytics.spi.FieldStorageInfo;
public class OpenSearchProject extends Project implements OpenSearchRelNode, DistributionAware {
                String fieldName = getRowType().getFieldList().get(i).getName();
            getCluster(),
        // baseline-op root.
 * The OpenSearch Contributors require contributions made to
        return new OpenSearchProject(
                return rexBuilder.makeInputRef(lowerProject, slot);
 * SPDX-License-Identifier: Apache-2.0
        List<? extends RexNode> projects,
            if (trait instanceof OpenSearchDistribution distribution) {
/**
            getTraitSet(),
                if (!singletonOrAny) {
        }
        // Lift nested RexOver expressions out of scalar calls into a child LogicalProject.
    public OpenSearchDistribution requiredInputDistribution(int inputIndex, int partitionCount, OpenSearchDistributionTraitDef traitDef) {
     * {@link LogicalProject} sitting on top of {@code input}. Returns {@code null} if no
                strippedExprs.add(expr.accept(nestedAnnotationStripper));
            if (expr instanceof RexInputRef ref && ref.getIndex() < inputStorage.size()) {
import org.apache.calcite.rel.core.Project;
import org.apache.calcite.rel.logical.LogicalProject;
            throw new IllegalStateException("Project child is not OpenSearchRelNode: " + input.getClass().getSimpleName());
import org.apache.calcite.rel.RelWriter;
            }
        // top-level scalar call whose operands embed RexOver: e.g.
            } else {
     * window-bearing project ({@code RexOver}) or a {@code pinAboveExchange} project needs fully-gathered
 *
        // becomes:
        if (childDistributions.size() != 1 || childDistributions.get(0) == null) {
        return pinAboveExchange;
     * (SINGLETON/ANY), forcing Volcano to place an ER below it. Used to keep an aggregate's literal
    @Override
    }
 * this file be licensed under the Apache-2.0 license or a
        // into a child Project as its own top-level expression, and rewrite the original
                return super.visitCall(call);
import org.apache.calcite.rex.RexCall;
        if (!containsOver() && !pinAboveExchange) {
 *
package org.opensearch.analytics.planner.rel;
 */
                strippedExprs.add(resolved.accept(nestedAnnotationStripper));
                    return super.visitOver(over);
        List<OperatorAnnotation> annotations = new ArrayList<>();
        int inputFieldCount = input.getRowType().getFieldCount();
    ) {
                    || distribution.getType() == RelDistribution.Type.ANY;
        }
        // then append each unique RexOver as its own top-level expression. The lower-Project's
        boolean pinAboveExchange
            return null;
        RelNode input,
            lowerExprs.add(rexBuilder.makeInputRef(input, i));
        this.pinAboveExchange = pinAboveExchange;
        List<? extends RexNode> projects,
                    // Should not happen — collector found every RexOver.
        // auto-generates) — that's fine, we reference by index.
import org.apache.calcite.plan.RelTraitSet;
     * projection drops it) — exactly {@link OpenSearchDistribution#apply} over the project's
        // PPL's `bin` command lowers `bins=N` / `minspan=N` / `start=… end=…` to a single
                if (call instanceof AnnotatedProjectExpression nested) {
                // contain no nested AnnotatedProjectExpression to strip.
        return super.explainTerms(pw).item("viableBackends", viableBackends);
        // backend's FragmentConvertor.
        List<String> viableBackends,
    @Override
        // Pre-substrait fix: walk every project expression, hoist each unique RexOver
            }
    }
        if (!containsOver() && !pinAboveExchange) {
            } else {
        OpenSearchDistribution childDist = childDistributions.get(0);
                LinkedHashSet<String> deps = RelNodeUtils.resolvePhysicalDeps(expr, inputStorage);
    @Override
        List<FieldStorageInfo> inputStorage = openSearchChild.getOutputFieldStorage();
     */
            if (expr instanceof AnnotatedProjectExpression annotated) {
    @Override
        List<RexNode> strippedExprs = new ArrayList<>();
            return null;
    /**
        // [input_field_0, input_field_1, ..., input_field_(n-1), MAX(f) OVER (), MIN(f) OVER ()]
                }
     */
    }
        }
                Integer slot = overIndex.get(over.toString());
    }
    public List<String> getViableBackends() {
     * A row-wise project imposes no partitioning requirement on its input (it neither needs nor breaks a
        List<RexNode> resolvedExprs = new ArrayList<>();
                annotations.add(annotation);
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {
            return lifted;
     * RexOver was found (caller should emit a single-level Project as before).
        // DataFusion sees the WindowFunctions at the top level of the inner Project and
        // CEIL also wrapped. The supplied annotationResolver controls how each top-level
        // expressions into a LogicalWindow (datafusion-substrait
        List<RexNode> rewrittenOuter = new ArrayList<>(outerExprs.size());
        // `from_project_rel`), but the nested RexOvers inside `width_bucket(...)` stay
    @Override
            }
        RelNode input = RelNodeUtils.unwrapHep(getInput());
            children.getFirst(),
                resolvedExprs.add(expr);
            pinAboveExchange
            }
    public OpenSearchDistribution deriveOutputDistribution(
    }
            } else {
    private final boolean pinAboveExchange;
     * config arg (e.g. percentile's {@code 50}) adjacent to the aggregate while a duplicate,
        }
        // expression to reference the hoisted column via RexInputRef. The child Project
        }
        // containsOver() is Calcite's own — inherited from Project.
        return LogicalProject.create(lowerProject, List.of(), rewrittenOuter, getRowType());
            RexNode expr = getProjects().get(i);
import org.apache.calcite.plan.RelOptCost;
            }
     */
        RelOptCluster cluster,
            return null;
    /**
                uniqueOvers.putIfAbsent(over.toString(), over);
                }
        RelTraitSet traitSet,
            public RexNode visitOver(RexOver over) {
        //
        if (containsOver() || pinAboveExchange) {
 * @opensearch.internal
     * distribution) — returns {@code null} so the input keeps whatever distribution it derived. A
        // backends, so a top-level call like COALESCE(num0, CEIL(num1)) ends up with the inner
        }
        for (RexNode expr : getProjects()) {
        if (inputIndex != 0) {
        int nextSlot = inputFieldCount;
            public RexNode visitCall(RexCall call) {
     * When true, this Project must stay ABOVE the ExchangeReducer (in the coordinator fragment) —
    /**
            resolvedExprs,
    @Override
import org.apache.calcite.rel.metadata.RelMetadataQuery;
 * OpenSearch custom Project carrying viable backend list and per-expression annotations.
        for (RexNode expr : outerExprs) {
    /**
        return result;
    /**
        // OpenSearchProjectRule.annotateExpr recurses into operands when validating viable
                }
        }
        }
import org.apache.calcite.rel.type.RelDataType;
        RexBuilder rexBuilder = getCluster().getRexBuilder();
        }
    }
        RelDataType rowType,
     * Hoists nested {@link RexOver} expressions out of {@code outerExprs} into a child
        // operands still go through annotation. The shuttle therefore runs on every project
        }
        // expression — including plain ones — to catch annotated operands nested inside a
            rewrittenOuter.add(expr.accept(rewriter));
        RelTraitSet traitSet,
        return new OpenSearchProject(getCluster(), traitSet, input, projects, rowType, viableBackends, pinAboveExchange);
        for (RexNode expr : getProjects()) {
     * input (global window frame / coordinator-pinned literal), so it requires {@code COORDINATOR+SINGLETON}.
            public RexNode visitOver(RexOver over) {
    public RelWriter explainTerms(RelWriter pw) {
        // row type matches: input fields followed by appended window-output columns.
import org.apache.calcite.rex.RexOver;
    }
        };
        for (Map.Entry<String, RexOver> entry : uniqueOvers.entrySet()) {
        List<OpenSearchDistribution> childDistributions,
    ) {
                // Plain expressions (field refs, literals, scalar calls) have no annotation — pass through.
     * RexOver gate, which has the same coordinator-side requirement.
import org.apache.calcite.rel.RelNode;
