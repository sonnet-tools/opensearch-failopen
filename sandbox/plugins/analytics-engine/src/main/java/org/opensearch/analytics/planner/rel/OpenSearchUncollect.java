    }
        return viableBackends;  
import org.opensearch.analytics.spi.FieldStorageInfo;  
            getTraitSet(),  
    @Override  
        RelTraitSet traitSet,  
 *
            .map(field -> FieldStorageInfo.derivedColumn(field.getName(), field.getType().getSqlTypeName(), dependencies))
        if (input instanceof OpenSearchRelNode openSearchInput) {
            .stream()
        RelNode input,
            for (FieldStorageInfo field : openSearchInput.getOutputFieldStorage()) {
import org.apache.calcite.rel.core.Uncollect;
    public List<FieldStorageInfo> getOutputFieldStorage() {
            withOrdinality,
    }
        boolean withOrdinality,
            children.getFirst(),
            getItemAliases(),  
    @Override
    @Override  
    @Override
            }
    }  
import org.apache.calcite.plan.RelTraitSet;
    }
        RelNode input = RelNodeUtils.unwrapHep(getInput());
    }  
        RelOptCluster cluster,
            .toList();  
        List<String> itemAliases,  
            getCluster(),
            List.of(backend)
        List<String> viableBackends
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        return new OpenSearchUncollect(getCluster(), traitSet, input, withOrdinality, getItemAliases(), viableBackends);
    ) {
import java.util.List;  
        }
public class OpenSearchUncollect extends Uncollect implements OpenSearchRelNode {  
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {  
        LinkedHashSet<String> dependencies = new LinkedHashSet<>();  
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {  
import org.apache.calcite.rel.RelNode;  
import org.opensearch.analytics.planner.RelNodeUtils;
        );
        return new OpenSearchUncollect(
    public RelNode copy(RelTraitSet traitSet, RelNode input) {
                dependencies.add(field.getFieldName());  
        this.viableBackends = viableBackends;
import java.util.LinkedHashSet;
/** Marked Uncollect used by multi-value row expansion. */
        super(cluster, traitSet, input, withOrdinality, itemAliases);  
    private final List<String> viableBackends;
import org.apache.calcite.plan.RelOptCluster;
package org.opensearch.analytics.planner.rel;
 * this file to be licensed under the Apache-2.0 license or a
 */  
    @Override
/*  
    public List<String> getViableBackends() {
 * SPDX-License-Identifier: Apache-2.0
    }
    public OpenSearchUncollect(
}  
        return Uncollect.create(getTraitSet(), strippedChildren.getFirst(), withOrdinality, getItemAliases());
        return getRowType().getFieldList()  
