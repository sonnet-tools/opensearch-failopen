    public RelOptCost computeSelfCost(RelOptPlanner planner, RelMetadataQuery mq) {
 * Used for {@code SELECT 1+1, NOW()} and similar source-less queries; planned at
    /** All output fields are derived — there's no physical storage behind a literal row. */  
    @Override
import org.apache.calcite.plan.RelOptPlanner;
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.analytics.planner.rel;
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {
    public RelNode copy(RelTraitSet traitSet, List<RelNode> inputs) {
    public OpenSearchValues(
    }
    @Override
        return planner.getCostFactory().makeTinyCost();
    @Override
    @Override  
    ) {
}
import org.apache.calcite.rel.RelWriter;
        return LogicalValues.create(getCluster(), getRowType(), getTuples());
        for (var field : getRowType().getFieldList()) {
import org.opensearch.analytics.spi.FieldStorageInfo;
 */  
import org.apache.calcite.rel.logical.LogicalValues;  
import org.apache.calcite.rex.RexLiteral;  
 * @opensearch.internal
import org.apache.calcite.plan.RelOptCluster;
    }
public class OpenSearchValues extends Values implements OpenSearchRelNode {
import org.apache.calcite.rel.metadata.RelMetadataQuery;
        return new OpenSearchValues(getCluster(), getTraitSet(), getRowType(), getTuples(), List.of(backend));  
    @Override
 */  
    }  
 * this file be licensed under the Apache-2.0 license or a
/**  
import java.util.ArrayList;  
 *
    }
        return out;
        return new OpenSearchValues(getCluster(), traitSet, getRowType(), getTuples(), viableBackends);  
 *
 * Constant-row source — emits a fixed list of literal tuples on the coordinator.
        this.viableBackends = viableBackends;
        return super.explainTerms(pw).item("viableBackends", viableBackends);
import org.apache.calcite.plan.RelOptCost;  
        RelDataType rowType,
        RelTraitSet traitSet,
    @Override  
    }
 * compatible open source license.
    private final List<String> viableBackends;  
 * {@code COORDINATOR+SINGLETON} with no shard scan and no exchange.  
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.plan.RelTraitSet;
import java.util.List;
        ImmutableList<ImmutableList<RexLiteral>> tuples,  
        }  
        List<String> viableBackends
    public RelWriter explainTerms(RelWriter pw) {  
import org.apache.calcite.rel.core.Values;
    }
    }
        RelOptCluster cluster,  
    public List<FieldStorageInfo> getOutputFieldStorage() {
    public List<String> getViableBackends() {
        return viableBackends;  
        List<FieldStorageInfo> out = new ArrayList<>(getRowType().getFieldCount());  
/*  
            out.add(FieldStorageInfo.derivedColumn(field.getName(), field.getType().getSqlTypeName()));
 * The OpenSearch Contributors require contributions made to  
    @Override
import com.google.common.collect.ImmutableList;
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {
import org.apache.calcite.rel.RelNode;  
        super(cluster, rowType, tuples, traitSet);  
    }  
