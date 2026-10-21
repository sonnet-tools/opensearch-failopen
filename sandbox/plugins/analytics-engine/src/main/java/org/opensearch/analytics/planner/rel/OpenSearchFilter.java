    @Override
/**
import org.apache.calcite.plan.RelTraitSet;
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {
        }
    @Override
        // TODO: the condition is currently deep-flattened in multiple places (here, in
    public RelWriter explainTerms(RelWriter pw) {
        // Leaf nodes (RexInputRef, RexLiteral, etc.) have no annotations — skip.
    @Override
        return new OpenSearchFilter(getCluster(), traitSet, input, condition, viableBackends);
        // AND child, and an OR must not contain an OR child. Adapter substitutions in
import org.apache.calcite.rel.logical.LogicalFilter;
    @Override
        // SEARCH into AND(>=, <=) under a parent AND). Flatten canonicalizes the tree.
        }
    /** Filter doesn't change schema or partitioning — output distribution = the child's, verbatim. */
            }
    private final List<String> viableBackends;
import java.util.List;
        return LogicalFilter.create(strippedChildren.getFirst(), flattened);
    public Filter copy(RelTraitSet traitSet, RelNode input, RexNode condition) {
    private RexNode resolveCondition(RexNode node, Function<OperatorAnnotation, RexNode> annotationResolver) {
        if (node instanceof RexCall call) {
    }
    // ---- DistributionAware (Option B post-CBO enforcement pass) ----
import org.apache.calcite.plan.RelOptPlanner;
    }
    public OpenSearchDistribution deriveOutputDistribution(
        return annotations;
        }
 * SPDX-License-Identifier: Apache-2.0
        if (node instanceof AnnotatedPredicate) return (RexNode) annotationIterator.next();
import java.util.function.Function;
        OpenSearchDistributionTraitDef traitDef
    private void collectAnnotations(RexNode node, List<OperatorAnnotation> result) {
            boolean changed = false;
 * @opensearch.internal
        List<OpenSearchDistribution> childDistributions,
import org.opensearch.analytics.spi.FieldStorageInfo;
                RexNode replaced = replaceAnnotations(operand, annotationIterator);
 *
    public OpenSearchFilter(RelOptCluster cluster, RelTraitSet traitSet, RelNode input, RexNode condition, List<String> viableBackends) {
            List<RexNode> newOperands = new ArrayList<>();
        return node;
    }
        return stripAnnotations(strippedChildren, OperatorAnnotation::unwrap);
    @Override
    }
        // TODO: see the constructor — revisit centralizing this flatten so multiple sites aren't needed.
    }
        return node;
        // be enforced centrally at a single chokepoint so multiple flatten call sites aren't needed.
    }
        if (node instanceof AnnotatedPredicate predicate) return annotationResolver.apply(predicate);
        if (node instanceof AnnotatedPredicate predicate) {
                newOperands.add(replaced);
        RelNode input = RelNodeUtils.unwrapHep(getInput());
            result.add(predicate);
        // BackendPlanAdapter.adaptRex can introduce that nesting (e.g. SargAdapter expands
    /** Filter doesn't change schema — pass through child's field storage. */
    /** Filter is fully transparent to distribution: it imposes no partitioning requirement on its input. */
        if (node instanceof RexCall call) {
        return new OpenSearchFilter(getCluster(), getTraitSet(), children.getFirst(), resolvedCondition, List.of(backend));
}
    @Override
 *
import org.apache.calcite.plan.RelOptCluster;
        } else if (node instanceof RexCall call) {
public class OpenSearchFilter extends Filter implements OpenSearchRelNode, DistributionAware {
        RexNode resolved = resolveCondition(getCondition(), annotationResolver);
        // Leaf node (RexInputRef, RexLiteral, etc.) — no annotation, pass through.
            for (RexNode operand : call.getOperands()) {
    @Override
import org.apache.calcite.plan.RelOptCost;
import org.apache.calcite.rel.RelNode;
        RexNode flattened = RelNodeUtils.deepFlatten(getCluster().getRexBuilder(), resolved);
    @Override
                RexNode resolved = resolveCondition(operand, annotationResolver);
        super(cluster, traitSet, input, RelNodeUtils.deepFlatten(cluster.getRexBuilder(), condition));
import org.apache.calcite.rex.RexCall;
import java.util.ListIterator;
import org.apache.calcite.rex.RexNode;
/*
        // Filter.<init> asserts RexUtil.isFlat — deep-flatten any nested AND/OR before super().
    @Override
    }
import org.opensearch.analytics.planner.RelNodeUtils;
    }
        }
        this.viableBackends = viableBackends;
                collectAnnotations(operand, result);
 * this file be licensed under the Apache-2.0 license or a
        // LogicalFilter.<init> asserts isFlat on the condition: an AND must not contain an
        return viableBackends;
        return List.of();
 * The OpenSearch Contributors require contributions made to
    }
        return childDistributions.size() == 1 ? childDistributions.get(0) : null;
import java.util.ArrayList;
        collectAnnotations(getCondition(), annotations);
    private RexNode replaceAnnotations(RexNode node, ListIterator<OperatorAnnotation> annotationIterator) {
 * compatible open source license.
    }
    @Override
    @Override
            return openSearchInput.getOutputFieldStorage();
            }
    public RelOptCost computeSelfCost(RelOptPlanner planner, RelMetadataQuery mq) {
import org.apache.calcite.rel.metadata.RelMetadataQuery;
        List<OperatorAnnotation> annotations = new ArrayList<>();
        if (input instanceof OpenSearchRelNode openSearchInput) {
 */
            for (RexNode operand : call.getOperands()) {
    public List<FieldStorageInfo> getOutputFieldStorage() {
        return super.explainTerms(pw).item("viableBackends", viableBackends);
    public List<String> getViableBackends() {
    }
            }
package org.opensearch.analytics.planner.rel;
                newOperands.add(resolved);
            return changed ? call.clone(call.getType(), newOperands) : call;
    }
        return null;
            for (RexNode operand : call.getOperands()) {
            boolean changed = false;
    ) {
 * OpenSearch custom Filter carrying viable backend list and per-predicate annotations.
            List<RexNode> newOperands = new ArrayList<>();
        RexNode resolvedCondition = replaceAnnotations(getCondition(), resolvedAnnotations.listIterator());
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {
    public RelNode stripAnnotations(List<RelNode> strippedChildren, Function<OperatorAnnotation, RexNode> annotationResolver) {
 */
                if (resolved != operand) changed = true;
import org.apache.calcite.rel.RelWriter;
    }
        return planner.getCostFactory().makeTinyCost();
        // stripAnnotations(), and in FragmentConversionDriver.strip()). Revisit whether this can
    public List<OperatorAnnotation> getAnnotations() {
    public OpenSearchDistribution requiredInputDistribution(int inputIndex, int partitionCount, OpenSearchDistributionTraitDef traitDef) {
import org.apache.calcite.rel.core.Filter;
    }
            return changed ? call.clone(call.getType(), newOperands) : call;
    }
                if (replaced != operand) changed = true;
