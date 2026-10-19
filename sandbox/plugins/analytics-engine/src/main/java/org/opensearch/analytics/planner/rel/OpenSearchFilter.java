        super(cluster, traitSet, input, RelNodeUtils.deepFlatten(cluster.getRexBuilder(), condition));
import java.util.ListIterator;
        return super.explainTerms(pw).item("viableBackends", viableBackends);
 * @opensearch.internal
            return openSearchInput.getOutputFieldStorage();  
        return new OpenSearchFilter(getCluster(), getTraitSet(), children.getFirst(), resolvedCondition, List.of(backend));
/*  
                if (replaced != operand) changed = true;
        if (node instanceof AnnotatedPredicate predicate) return annotationResolver.apply(predicate);
    public RelOptCost computeSelfCost(RelOptPlanner planner, RelMetadataQuery mq) {
    }  
    }
        // LogicalFilter.<init> asserts isFlat on the condition: an AND must not contain an  
    }
import org.opensearch.analytics.spi.FieldStorageInfo;
        return stripAnnotations(strippedChildren, OperatorAnnotation::unwrap);  
    @Override
    }  
    @Override  
    }
import org.apache.calcite.plan.RelOptCost;
import org.apache.calcite.plan.RelOptCluster;
    }
        }
        return new OpenSearchFilter(getCluster(), traitSet, input, condition, viableBackends);
        }
                RexNode replaced = replaceAnnotations(operand, annotationIterator);  
import org.apache.calcite.rex.RexNode;
        return childDistributions.size() == 1 ? childDistributions.get(0) : null;
 * SPDX-License-Identifier: Apache-2.0
                newOperands.add(replaced);
        if (input instanceof OpenSearchRelNode openSearchInput) {
            result.add(predicate);
    @Override  
                if (resolved != operand) changed = true;  
    public Filter copy(RelTraitSet traitSet, RelNode input, RexNode condition) {  
        // SEARCH into AND(>=, <=) under a parent AND). Flatten canonicalizes the tree.  
        RexNode resolved = resolveCondition(getCondition(), annotationResolver);
        } else if (node instanceof RexCall call) {
    ) {
        RexNode flattened = RelNodeUtils.deepFlatten(getCluster().getRexBuilder(), resolved);
        return LogicalFilter.create(strippedChildren.getFirst(), flattened);  
        if (node instanceof RexCall call) {
        RexNode resolvedCondition = replaceAnnotations(getCondition(), resolvedAnnotations.listIterator());  
    public RelNode stripAnnotations(List<RelNode> strippedChildren, Function<OperatorAnnotation, RexNode> annotationResolver) {
}  
    public OpenSearchFilter(RelOptCluster cluster, RelTraitSet traitSet, RelNode input, RexNode condition, List<String> viableBackends) {
 * this file be licensed under the Apache-2.0 license or a
    /** Filter is fully transparent to distribution: it imposes no partitioning requirement on its input. */
 * OpenSearch custom Filter carrying viable backend list and per-predicate annotations.  
    public List<OperatorAnnotation> getAnnotations() {
        // stripAnnotations(), and in FragmentConversionDriver.strip()). Revisit whether this can
    // ---- DistributionAware (Option B post-CBO enforcement pass) ----  
import org.opensearch.analytics.planner.RelNodeUtils;  
            List<RexNode> newOperands = new ArrayList<>();  
    public OpenSearchDistribution requiredInputDistribution(int inputIndex, int partitionCount, OpenSearchDistributionTraitDef traitDef) {
                newOperands.add(resolved);
        RelNode input = RelNodeUtils.unwrapHep(getInput());
    }  
import org.apache.calcite.rel.core.Filter;
        // BackendPlanAdapter.adaptRex can introduce that nesting (e.g. SargAdapter expands
        return annotations;
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {
            }
    }
 *
        // Leaf nodes (RexInputRef, RexLiteral, etc.) have no annotations — skip.
        // be enforced centrally at a single chokepoint so multiple flatten call sites aren't needed.  
import org.apache.calcite.rel.RelNode;
            boolean changed = false;
            }  
        if (node instanceof AnnotatedPredicate) return (RexNode) annotationIterator.next();
import java.util.ArrayList;  
    }  
import org.apache.calcite.rel.RelWriter;  
    }
        // TODO: the condition is currently deep-flattened in multiple places (here, in
 *
    @Override
        return List.of();
 */  
            for (RexNode operand : call.getOperands()) {  
        if (node instanceof RexCall call) {  
import org.apache.calcite.rel.logical.LogicalFilter;
        List<OpenSearchDistribution> childDistributions,
        return null;
        }  
    @Override
    }
    @Override
    }
                RexNode resolved = resolveCondition(operand, annotationResolver);
        OpenSearchDistributionTraitDef traitDef  
            List<RexNode> newOperands = new ArrayList<>();
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {
    public OpenSearchDistribution deriveOutputDistribution(
        return planner.getCostFactory().makeTinyCost();  
    }
    private RexNode resolveCondition(RexNode node, Function<OperatorAnnotation, RexNode> annotationResolver) {
import java.util.function.Function;  
/**
 * compatible open source license.
    }  
            }
    /** Filter doesn't change schema — pass through child's field storage. */
            for (RexNode operand : call.getOperands()) {  
    public RelWriter explainTerms(RelWriter pw) {  
    @Override
        // Filter.<init> asserts RexUtil.isFlat — deep-flatten any nested AND/OR before super().  
        // AND child, and an OR must not contain an OR child. Adapter substitutions in
package org.opensearch.analytics.planner.rel;
import org.apache.calcite.plan.RelTraitSet;
import org.apache.calcite.rex.RexCall;
        if (node instanceof AnnotatedPredicate predicate) {  
        this.viableBackends = viableBackends;
                collectAnnotations(operand, result);
    @Override
        List<OperatorAnnotation> annotations = new ArrayList<>();  
    }
    public List<String> getViableBackends() {  
    /** Filter doesn't change schema or partitioning — output distribution = the child's, verbatim. */
            for (RexNode operand : call.getOperands()) {
        return node;
import org.apache.calcite.plan.RelOptPlanner;  
    @Override  
    @Override
    private RexNode replaceAnnotations(RexNode node, ListIterator<OperatorAnnotation> annotationIterator) {  
            return changed ? call.clone(call.getType(), newOperands) : call;
    public List<FieldStorageInfo> getOutputFieldStorage() {  
    private final List<String> viableBackends;  
            return changed ? call.clone(call.getType(), newOperands) : call;
 * The OpenSearch Contributors require contributions made to  
    @Override
import java.util.List;
        // TODO: see the constructor — revisit centralizing this flatten so multiple sites aren't needed.
            boolean changed = false;
        }  
public class OpenSearchFilter extends Filter implements OpenSearchRelNode, DistributionAware {
import org.apache.calcite.rel.metadata.RelMetadataQuery;  
        return viableBackends;
        return node;
        collectAnnotations(getCondition(), annotations);
    private void collectAnnotations(RexNode node, List<OperatorAnnotation> result) {
        // Leaf node (RexInputRef, RexLiteral, etc.) — no annotation, pass through.  
 */  
