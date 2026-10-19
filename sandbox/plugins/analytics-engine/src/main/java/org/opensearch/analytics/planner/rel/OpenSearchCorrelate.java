    public OpenSearchCorrelate(  
        RelOptCluster cluster,
        return result;  
/** Marked Correlate used for the frontend's {@code mvexpand} Correlate+Uncollect shape. */
            requiredColumns,
        LinkedHashSet<String> dependencies = new LinkedHashSet<>();
}  
        RelNode right,
    @Override  
            List.of(backend)
 *
            getCluster(),  
    }
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {  
            getTraitSet(),
        ImmutableBitSet requiredColumns,  
    }  
    @Override  
    @Override
            children.get(0),
        return new OpenSearchCorrelate(getCluster(), traitSet, left, right, correlationId, requiredColumns, joinType, viableBackends);  
    @Override
        RelNode left,  
    private final List<String> viableBackends;
import org.apache.calcite.util.ImmutableBitSet;
        CorrelationId correlationId,
    ) {
public class OpenSearchCorrelate extends Correlate implements OpenSearchRelNode {
        for (int index = left.getRowType().getFieldCount(); index < getRowType().getFieldCount(); index++) {
    }
        this.viableBackends = viableBackends;
        super(cluster, traitSet, List.of(), left, right, correlationId, requiredColumns, joinType);
            children.get(1),  
            var field = getRowType().getFieldList().get(index);  
        List<FieldStorageInfo> result = new ArrayList<>();
import org.apache.calcite.plan.RelTraitSet;
 * The OpenSearch Contributors require contributions made to  
            if (index < left.getRowType().getFieldCount()) {
        }
        );
            correlationId,
import org.apache.calcite.rel.core.Correlate;
    public List<String> getViableBackends() {  
        ImmutableBitSet requiredColumns,  
package org.opensearch.analytics.planner.rel;
        JoinRelType joinType,
 * SPDX-License-Identifier: Apache-2.0
import java.util.LinkedHashSet;
            result.add(FieldStorageInfo.derivedColumn(field.getName(), field.getType().getSqlTypeName(), dependencies));
import org.opensearch.analytics.planner.RelNodeUtils;  
    }  
import java.util.ArrayList;  
import org.apache.calcite.plan.RelOptCluster;
        RelTraitSet traitSet,
 * compatible open source license.
        RelNode left = RelNodeUtils.unwrapHep(getLeft());  
import java.util.List;
/*  
        return viableBackends;
import org.apache.calcite.rel.RelNode;  
            joinType,  
    ) {  
        List<String> viableBackends
        RelTraitSet traitSet,
import org.apache.calcite.rel.core.JoinRelType;  
        }
        return new OpenSearchCorrelate(
    public Correlate copy(
 */  
import org.apache.calcite.rel.logical.LogicalCorrelate;
            result.addAll(openSearchLeft.getOutputFieldStorage());  
        if (left instanceof OpenSearchRelNode openSearchLeft) {
        for (int index : requiredColumns) {  
        RelNode right,
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {
import org.opensearch.analytics.spi.FieldStorageInfo;
    }
                dependencies.add(left.getRowType().getFieldList().get(index).getName());
            }  
        return LogicalCorrelate.create(strippedChildren.get(0), strippedChildren.get(1), correlationId, requiredColumns, joinType);
import org.apache.calcite.rel.core.CorrelationId;
        RelNode left,  
    @Override
 * this file to be licensed under the Apache-2.0 license or a
    }
        }
        CorrelationId correlationId,
        JoinRelType joinType
    public List<FieldStorageInfo> getOutputFieldStorage() {
