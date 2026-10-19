        }  
        return remapped instanceof OpenSearchDistribution osDist ? osDist : null;
        // both data_range operand and max_value operand of width_bucket) is hoisted once
                // Plain expressions (field refs, literals, scalar calls) have no annotation — pass through.
        for (RexNode expr : outerExprs) {  
                strippedExprs.add(expr.accept(nestedAnnotationStripper));
     */
import org.apache.calcite.plan.RelTrait;
    }  
    /**  
            }  
            overIndex.put(entry.getKey(), nextSlot++);  
    private final boolean pinAboveExchange;
                boolean singletonOrAny = distribution.getType() == RelDistribution.Type.SINGLETON
        }
    }
        );
            }
     * <p>Plain projects (neither) have no ordering requirement — tiny cost unconditionally.  
        return new OpenSearchProject(
    }
        return planner.getCostFactory().makeTinyCost();  
        // RexNode); a RexShuttle then sweeps the resolver's result to strip any remaining  
 * OpenSearch custom Project carrying viable backend list and per-expression annotations.  
import java.util.LinkedHashMap;
        List<OperatorAnnotation> annotations = new ArrayList<>();
 * compatible open source license.
    }
     * {@link LogicalProject} sitting on top of {@code input}. Returns {@code null} if no
            getCluster(),  
    @Override  
                    // Should not happen — collector found every RexOver.
                String fieldName = getRowType().getFieldList().get(i).getName();
    @Override
 * this file be licensed under the Apache-2.0 license or a
    }  
        RelOptCluster cluster,
    public OpenSearchProject(
        // Rewrite outer expressions: replace each RexOver with a RexInputRef into the
        if (!(input instanceof OpenSearchRelNode openSearchChild)) {
            if (expr instanceof AnnotatedProjectExpression) {
import org.apache.calcite.rel.type.RelDataType;  
        LinkedHashMap<String, RexOver> uniqueOvers = new LinkedHashMap<>();
    }
        return pinAboveExchange;
        OpenSearchDistribution childDist = childDistributions.get(0);
            throw new IllegalStateException("Project child is not OpenSearchRelNode: " + input.getClass().getSimpleName());  
        // DataFusion sees the WindowFunctions at the top level of the inner Project and  
            return planner.getCostFactory().makeTinyCost();
        this.viableBackends = viableBackends;  
    }
                return over;  
        if (childDistributions.size() != 1 || childDistributions.get(0) == null) {
 *
        };
            rewrittenOuter.add(expr.accept(rewriter));  
 * @opensearch.internal
        // expression to reference the hoisted column via RexInputRef. The child Project
        this.pinAboveExchange = pinAboveExchange;
                    return planner.getCostFactory().makeInfiniteCost();
                return super.visitCall(call);
    @Override
    /**
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {
            }
 * SPDX-License-Identifier: Apache-2.0
     * likewise stay in the coordinator fragment (they carry an aggregate's literal config arg). Both
     * input column {@code k} moves to wherever the projection places {@code k} (and degrades to ANY if the  
            if (expr instanceof AnnotatedProjectExpression annotated) {  
        // so every wrapper at every depth must be removed before the plan is handed to a
            return traitDef.coordSingleton();  
    @Override  
        for (int i = 0; i < getProjects().size(); i++) {
            pinAboveExchange  
    }
     */
    public List<OperatorAnnotation> getAnnotations() {
        // operands still go through annotation. The shuttle therefore runs on every project
    public RelNode stripAnnotations(List<RelNode> strippedChildren, Function<OperatorAnnotation, RexNode> annotationResolver) {
        // backends, so a top-level call like COALESCE(num0, CEIL(num1)) ends up with the inner  
    }
}
                RexNode resolved = annotationResolver.apply(annotated);
        if (inputIndex != 0) {
            return null;
        List<? extends RexNode> projects,
        List<RexNode> rewrittenOuter = new ArrayList<>(outerExprs.size());
                // resolve. Running the shuttle is defensive and idempotent — atomic nodes
                if (!singletonOrAny) {
        List<RexNode> lowerExprs = new ArrayList<>(inputFieldCount + uniqueOvers.size());
     * A plain project passes the child's distribution through, REMAPPED to output columns: a hash key at
     * distribution) — returns {@code null} so the input keeps whatever distribution it derived. A
        return result;  
     * projection drops it) — exactly {@link OpenSearchDistribution#apply} over the project's
    public List<String> getViableBackends() {
        for (RexNode expr : outerExprs) {
                strippedExprs.add(resolved.accept(nestedAnnotationStripper));
    public OpenSearchProject(  
     * sits under this project.
    @Override
            return null;
import org.apache.calcite.rel.RelWriter;
        RelDataType rowType,
        if (!containsOver() && !pinAboveExchange) {
     * When true, this Project must stay ABOVE the ExchangeReducer (in the coordinator fragment) —  
        // row type matches: input fields followed by appended window-output columns.  
            children.getFirst(),
/*  
    public OpenSearchDistribution requiredInputDistribution(int inputIndex, int partitionCount, OpenSearchDistributionTraitDef traitDef) {  
        return LogicalProject.create(strippedChildren.getFirst(), List.of(), strippedExprs, getRowType());  
        // Collect unique RexOvers from the expression trees. LinkedHashMap by digest so  
        // expression — including plain ones — to catch annotated operands nested inside a
        // width_bucket(f, N, MAX(f) OVER () - MIN(f) OVER (), MAX(f) OVER ())
            @Override  
        // wrapper is unwrapped (defaults to OperatorAnnotation::unwrap, returning the original
        // auto-generates) — that's fine, we reference by index.
                // contain no nested AnnotatedProjectExpression to strip.  
            if (trait instanceof OpenSearchDistribution distribution) {
        // containsOver() is Calcite's own — inherited from Project.
import org.apache.calcite.rex.RexOver;
     *
 * The OpenSearch Contributors require contributions made to  
        RexShuttle rewriter = new RexShuttle() {
        return super.explainTerms(pw).item("viableBackends", viableBackends);  
import org.apache.calcite.rel.metadata.RelMetadataQuery;
        // becomes:  
     * return infinite cost unless input is SINGLETON/ANY — Volcano then picks the plan where an ER  
        // with "Physical plan does not support logical expression WindowFunction(...)".
        );
    @Override
        };  
    public RelWriter explainTerms(RelWriter pw) {
                // Pass-through expressions (RexInputRef, RexLiteral) have no annotation to
        OpenSearchDistributionTraitDef traitDef
        int inputFieldCount = input.getRowType().getFieldCount();
    }
            } else {  
        RelOptCluster cluster,  
        // overIndex maps "over digest" → its column index in the lower Project's output.
        }
     */  
     * window's global frame semantics are correct. Projects flagged {@link #pinAboveExchange} must
        List<String> viableBackends,
import org.opensearch.analytics.planner.RelNodeUtils;
        }
import org.apache.calcite.plan.RelTraitSet;
        // into a child Project as its own top-level expression, and rewrite the original
            getInput().getRowType().getFieldCount(),  
 */  
     * SINGLETON. Returns {@code null} when the child distribution is unknown.  
import java.util.Map;
            return null;
                Integer slot = overIndex.get(over.toString());
        List<RexNode> resolvedExprs = new ArrayList<>();
     * unpinned, physical-only Project pushes below the gather for projection-pushdown. Mirrors the
        if (!containsOver() && !pinAboveExchange) {
            @Override
        for (int i = 0; i < inputFieldCount; i++) {
        org.apache.calcite.rel.RelDistribution remapped = childDist.apply(mapping);  
                result.add(inputStorage.get(ref.getIndex()));
    public List<FieldStorageInfo> getOutputFieldStorage() {  
     * {@link #computeSelfCost} returns infinite cost unless its input is already gathered
                resolvedExprs.add((RexNode) resolvedAnnotations.get(annotationIndex++));
     */
    ) {  
        // nested wrappers. Substrait conversion only recognizes the underlying RexCall shape,
        super(cluster, traitSet, List.of(), input, projects, rowType);
            }
        int annotationIndex = 0;
    public boolean isPinAboveExchange() {
        boolean pinAboveExchange  
                if (call instanceof AnnotatedProjectExpression nested) {
                result.add(FieldStorageInfo.derivedColumn(fieldName, getRowType().getFieldList().get(i).getType().getSqlTypeName(), deps));  
            public RexNode visitOver(RexOver over) {
                uniqueOvers.putIfAbsent(over.toString(), over);
            List.of(backend),
        // lower Project's output. Field names of the lower Project are anonymous (Calcite  
import org.apache.calcite.rex.RexBuilder;
                    || distribution.getType() == RelDistribution.Type.ANY;  
            }
            public RexNode visitOver(RexOver over) {
            return lifted;
                }  
    /**
            RelTrait trait = getInput().getTraitSet().getTrait(i);  
            if (expr instanceof AnnotatedProjectExpression annotation) {
import java.util.List;
    public OpenSearchDistribution deriveOutputDistribution(  
                    return nested.getOriginal().accept(this);
        // top-level scalar call whose operands embed RexOver: e.g.
import org.apache.calcite.rex.RexNode;
     * RexOver gate, which has the same coordinator-side requirement.
    /**
    @Override  
        List<? extends RexNode> projects,  
    /** See {@link #pinAboveExchange}. */  
                resolvedExprs.add(expr);
    }
     * input (global window frame / coordinator-pinned literal), so it requires {@code COORDINATOR+SINGLETON}.  
 *
        // and the outer Project's expressions reference those new columns by index.
     * (SINGLETON/ANY), forcing Volcano to place an ER below it. Used to keep an aggregate's literal
            public RexNode visitCall(RexCall call) {  
        // Lift nested RexOver expressions out of scalar calls into a child LogicalProject.
        }  
        for (Map.Entry<String, RexOver> entry : uniqueOvers.entrySet()) {
        Map<String, Integer> overIndex = new LinkedHashMap<>();  
        // expressions into a LogicalWindow (datafusion-substrait
        // CEIL also wrapped. The supplied annotationResolver controls how each top-level
                LinkedHashSet<String> deps = RelNodeUtils.resolvePhysicalDeps(expr, inputStorage);
                }  
    }  
        // PPL's `bin` command lowers `bins=N` / `minspan=N` / `start=… end=…` to a single  
        }
        }  
        for (RexNode expr : getProjects()) {
        }  
        org.apache.calcite.util.mapping.Mappings.TargetMapping mapping = Project.getPartialMapping(
        // and shares a single column slot.  
        }
            getRowType(),
public class OpenSearchProject extends Project implements OpenSearchRelNode, DistributionAware {
            }
        //
        if (uniqueOvers.isEmpty()) {  
        if (containsOver() || pinAboveExchange) {
                    return super.visitOver(over);
        // backend's FragmentConvertor.  
        RelTraitSet traitSet,
            getProjects()
        // Build the lower-Project expressions: passthrough every input field as RexInputRef,
        // Pre-substrait fix: walk every project expression, hoist each unique RexOver  
     * config arg (e.g. percentile's {@code 50}) adjacent to the aggregate while a duplicate,  
        List<FieldStorageInfo> result = new ArrayList<>(getProjects().size());
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {  
    // ---- DistributionAware (Option B post-CBO enforcement pass) ----  
    ) {
                }  
            lowerExprs.add(entry.getValue());
            RexNode expr = getProjects().get(i);  
        Project lifted = liftNestedRexOver(strippedChildren.getFirst(), strippedExprs);
        RelDataType rowType,
        if (lifted != null) {  
import org.apache.calcite.rel.RelNode;
    @Override
import java.util.ArrayList;
            expr.accept(collector);
        return annotations;
                annotations.add(annotation);
        RelNode input = RelNodeUtils.unwrapHep(getInput());
import org.apache.calcite.rex.RexCall;
import org.apache.calcite.plan.RelOptPlanner;  
        return new OpenSearchProject(getCluster(), traitSet, input, projects, rowType, viableBackends, pinAboveExchange);
import java.util.LinkedHashSet;  
        List<FieldStorageInfo> inputStorage = openSearchChild.getOutputFieldStorage();
        return stripAnnotations(strippedChildren, OperatorAnnotation::unwrap);  
        }
        }
        return LogicalProject.create(lowerProject, List.of(), rewrittenOuter, getRowType());  
     * window-bearing project ({@code RexOver}) or a {@code pinAboveExchange} project needs fully-gathered
        List<OpenSearchDistribution> childDistributions,
import org.apache.calcite.rel.logical.LogicalProject;
        // wraps them in a LogicalWindow as expected.
import org.apache.calcite.rex.RexInputRef;  
            } else {  
 */  
        this(cluster, traitSet, input, projects, rowType, viableBackends, false);
    }
        for (RexNode expr : getProjects()) {  
            @Override  
import org.apache.calcite.rel.RelDistribution;  
        // `from_project_rel`), but the nested RexOvers inside `width_bucket(...)` stay
        RexBuilder rexBuilder = getCluster().getRexBuilder();
        // baseline-op root.  
        // where they are and reach DataFusion's physical planner — which then errors  
        // [input_field_0, input_field_1, ..., input_field_(n-1), MAX(f) OVER (), MIN(f) OVER ()]
            if (expr instanceof RexInputRef ref && ref.getIndex() < inputStorage.size()) {
            }
        for (int i = 0; i < getInput().getTraitSet().size(); i++) {
     * A row-wise project imposes no partitioning requirement on its input (it neither needs nor breaks a  
    @Override
    }
    ) {
                if (slot == null) {  
     * RexOver was found (caller should emit a single-level Project as before).  
        // IS_NULL, …) bypass the AnnotatedProjectExpression wrap at the call site, but their  
        RelNode input,  
/**
        List<RexNode> strippedExprs = new ArrayList<>();
        }
            } else {  
        return viableBackends;  
    private Project liftNestedRexOver(RelNode input, List<RexNode> outerExprs) {
        int nextSlot = inputFieldCount;
    }  
        //
    private final List<String> viableBackends;  
        }
            getTraitSet(),
import org.apache.calcite.rex.RexShuttle;  
        RexShuttle nestedAnnotationStripper = new RexShuttle() {
import org.opensearch.analytics.spi.FieldStorageInfo;
    @Override
import java.util.function.Function;  
        Project lowerProject = LogicalProject.create(input, List.of(), lowerExprs, (List<String>) null);  
        };  
        RelNode input,
    public Project copy(RelTraitSet traitSet, RelNode input, List<RexNode> projects, RelDataType rowType) {
        RexShuttle collector = new RexShuttle() {
            return null;
        }
        List<String> viableBackends  
    /**
        // then append each unique RexOver as its own top-level expression. The lower-Project's
import org.apache.calcite.plan.RelOptCluster;
     * Hoists nested {@link RexOver} expressions out of {@code outerExprs} into a child
     */
        return traitDef.coordSingleton();
        }
        }
            lowerExprs.add(rexBuilder.makeInputRef(input, i));  
        RelTraitSet traitSet,
package org.opensearch.analytics.planner.rel;
     * {@code getPartialMapping}. A window/pinned project gathered its input to SINGLETON, so its output is
        // DataFusion's substrait consumer auto-lifts *top-level* WindowFunction project  
        // Top-level baseline operators (BASELINE_SCALAR_OPS — COALESCE, CASE, CAST, arithmetic,
        for (RexNode expr : getProjects()) {  
        }  
import org.apache.calcite.plan.RelOptCost;
    @Override
    public RelOptCost computeSelfCost(RelOptPlanner planner, RelMetadataQuery mq) {  
            }  
        // the same RexOver from multiple expressions (e.g. MAX(f) OVER () appearing as
                return rexBuilder.makeInputRef(lowerProject, slot);
        // OpenSearchProjectRule.annotateExpr recurses into operands when validating viable
            resolvedExprs,  
     * Projects containing {@code RexOver} (window functions) need fully-gathered input so the  
import org.apache.calcite.rel.core.Project;  
