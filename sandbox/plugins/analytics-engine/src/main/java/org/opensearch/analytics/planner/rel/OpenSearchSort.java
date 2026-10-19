        RelCollation collation,  
        RelOptCluster cluster,  
    public Sort copy(RelTraitSet traitSet, RelNode input, RelCollation collation, RexNode offset, RexNode fetch) {
import org.apache.calcite.plan.RelTrait;
        List<String> viableBackends,  
    }
 *
 */
     * {@link org.opensearch.analytics.planner.rules.OpenSearchSortSplitRule} alternative
    }  
     * is a concat gather (not a merge exchange), so per-partition sort + ER produces
package org.opensearch.analytics.planner.rel;
     *  
import org.apache.calcite.plan.RelOptCost;
    }
    @Override
    @Override
    /**  
     * inner Sort's RelSet to SINGLETON. We don't use Calcite's collation-trait enforcement,  
        return perPartition;
    @Override  
        RexNode fetch,
        List<String> viableBackends  
        RelTraitSet traitSet,
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {  
import org.apache.calcite.rel.RelWriter;  
        super(cluster, traitSet, input, collation, offset, fetch);  
     *
        }
        boolean perPartition
                    boolean singletonOrAny = distribution.getType() == RelDistribution.Type.SINGLETON
        RelTraitSet traitSet,
 * compatible open source license.
                    }
import org.opensearch.analytics.planner.RelNodeUtils;
     * <p>A Sort with no collation AND no fetch/offset is a no-op — skip the gate.
    /** True when this Sort runs per-shard (shard-bucket oversampling). */
        return false;
     */  
        if (input instanceof OpenSearchRelNode openSearchInput) {
     * (ER below the Sort, Sort sees a fully-gathered input).
        this.viableBackends = viableBackends;
        RexNode offset,
        this(cluster, traitSet, input, collation, offset, fetch, viableBackends, false);
            for (int i = 0; i < input.getTraitSet().size(); i++) {
        return new OpenSearchSort(getCluster(), getTraitSet(), children.getFirst(), getCollation(), offset, fetch, List.of(backend));
        return List.of();
/**
        for (RelNode input : getInputs()) {  
     * infinite cost unless the input is EXECUTION(SINGLETON) forces Volcano to pick the  
            return openSearchInput.getOutputFieldStorage();
    }  
     */
        }  
 */  
    ) {
    @Override
    public RelWriter explainTerms(RelWriter pw) {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.analytics.spi.FieldStorageInfo;  
        return LogicalSort.create(strippedChildren.getFirst(), getCollation(), offset, fetch);  
            }
    /** Sort doesn't change schema — pass through child's field storage. */  
}
        }
import org.apache.calcite.plan.RelOptCluster;
     * confuses the gather-rule path, which looks for delivered subsets when converting an
     * partition-locally ordered rows concatenated in arrival order — wrong. Returning
import org.apache.calcite.rel.logical.LogicalSort;
    ) {
    }
    public OpenSearchSort(
import org.apache.calcite.rel.RelCollation;  
import org.apache.calcite.rel.core.Sort;
    }
        RelNode input,
import java.util.List;
        RexNode fetch,
    }  
                RelTrait trait = input.getTraitSet().getTrait(i);
     * A collated Sort needs globally-ordered input. Our {@link OpenSearchExchangeReducer}  
    }
                        || distribution.getType() == RelDistribution.Type.ANY;
 * SPDX-License-Identifier: Apache-2.0
        if (getCollation().getFieldCollations().isEmpty() && fetch == null && offset == null) {  
    private final List<String> viableBackends;
    private final boolean perPartition;  
public class OpenSearchSort extends Sort implements OpenSearchRelNode {  
    }
    public List<String> getViableBackends() {
                        return planner.getCostFactory().makeInfiniteCost();
import org.apache.calcite.rex.RexNode;
        RexNode offset,
    public RelOptCost computeSelfCost(RelOptPlanner planner, RelMetadataQuery mq) {
    }
            return planner.getCostFactory().makeTinyCost();
    public boolean isPerPartition() {  
    public boolean isEnforcer() {
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {
 * OpenSearch custom Sort carrying viable backend list.
        return super.explainTerms(pw).item("viableBackends", viableBackends);
        RelNode input,
    @Override  
    @Override
import org.apache.calcite.plan.RelOptPlanner;  
        return planner.getCostFactory().makeTinyCost();  
 * @opensearch.internal
    /**
 *  
    public OpenSearchSort(
import org.apache.calcite.rel.metadata.RelMetadataQuery;  
     * <p>Calcite's default classifies a Sort with collation as an enforcer — Volcano then  
        RelOptCluster cluster,  
import org.apache.calcite.rel.RelDistribution;
    }  
        RelCollation collation,  
     * Treat our Sort as a concrete physical operator, not a Calcite collation enforcer.
        RelNode input = RelNodeUtils.unwrapHep(getInput());  
     * registers it into a {@code required=true} subset that's never marked delivered. That
    public List<FieldStorageInfo> getOutputFieldStorage() {
                    if (!singletonOrAny) {  
        return viableBackends;  
     * A pure LIMIT (fetch != null, no collation) still needs gathering so it applies globally.
                }  
import org.apache.calcite.rel.RelNode;
    @Override
                if (trait instanceof OpenSearchDistribution distribution) {  
     * so mark the Sort delivered like any other operator.
import org.apache.calcite.plan.RelTraitSet;
/*  
        return new OpenSearchSort(getCluster(), traitSet, input, collation, offset, fetch, viableBackends, perPartition);  
        this.perPartition = perPartition;
    @Override
 * this file be licensed under the Apache-2.0 license or a
