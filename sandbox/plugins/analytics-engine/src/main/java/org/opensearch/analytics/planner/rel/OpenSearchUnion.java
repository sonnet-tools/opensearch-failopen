            }
        for (RelNode input : getInputs()) {
        return new OpenSearchUnion(getCluster(), getTraitSet(), children, all, List.of(backend));  
     *       OpenSearchUnionSplitRule's general path inserts ERs to satisfy this.</li>  
        OpenSearchDistribution selfDist = distributionOf(this);
        this.viableBackends = viableBackends;
     *       {@code SHARD+SINGLETON} with the union's {@code tableId} and {@code shardCount=1}.</li>
import org.apache.calcite.plan.RelTrait;
                }  
        return viableBackends;  
     *   <li>{@code COORDINATOR+SINGLETON} union → every arm must be {@code COORDINATOR+SINGLETON}.
            if (inputDist.getType() != RelDistribution.Type.SINGLETON) {  
import org.apache.calcite.rel.logical.LogicalUnion;
     *   <li>{@code SHARD+SINGLETON} union (co-location fast path) → every arm must be
 * compatible open source license.
                for (int i = 1; i < perInputStorage.size(); i++) {
 * field reference) collapses to a derived column. Downstream rules that push down
        if (selfDist == null || selfDist.getType() != RelDistribution.Type.SINGLETON) {
                        || !other.getDocValueFormats().equals(first.getDocValueFormats())
            if (trait instanceof OpenSearchDistribution dist) return dist;  
package org.opensearch.analytics.planner.rel;
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {
     * </ul>  
import org.apache.calcite.rel.core.Union;  
    @Override
            boolean allMatch = first != null && !first.isDerived();  
import org.apache.calcite.rel.metadata.RelMetadataQuery;
                throw new IllegalStateException("Union input is not OpenSearchRelNode: " + unwrapped.getClass().getSimpleName());  
    }  
 * derived unless every branch agrees.  
 *
 */  
public class OpenSearchUnion extends Union implements OpenSearchRelNode {
 * @opensearch.internal
        }
        }
                    }  
import org.opensearch.analytics.planner.RelNodeUtils;
        for (int i = 0; i < rel.getTraitSet().size(); i++) {
                        break;  
     */
        }
 * positional index — when all inputs report identical storage we keep it; any
    public OpenSearchUnion(RelOptCluster cluster, RelTraitSet traitSet, List<RelNode> inputs, boolean all, List<String> viableBackends) {
import org.apache.calcite.rel.RelWriter;
                    if (branch.size() <= col) {
    /**
            }
 * SPDX-License-Identifier: Apache-2.0
            perInputStorage.add(openSearchInput.getOutputFieldStorage());
                }
        return null;
    public RelWriter explainTerms(RelWriter pw) {  
            if (inputDist == null) continue;
 * <p>Per-column output storage is the intersection of inputs' storage at the same
                }  
/*  
     * <ul>
    @Override
            if (!(unwrapped instanceof OpenSearchRelNode openSearchInput)) {
    private final List<String> viableBackends;  
            if (selfDist.getLocality() != inputDist.getLocality()) {  
        return LogicalUnion.create(strippedChildren, all);
        List<List<FieldStorageInfo>> perInputStorage = new ArrayList<>(getInputs().size());
            FieldStorageInfo first = perInputStorage.getFirst().size() > col ? perInputStorage.getFirst().get(col) : null;
 * divergence (e.g. one branch has a derived literal column, another has a real  
     * Cost gate. Locality of the union must match its arms:  
}
            if (inputDist.getType() == RelDistribution.Type.ANY) continue;
            }
    @Override
                if (selfDist.getTableId() == null || !selfDist.getTableId().equals(inputDist.getTableId())) {
    }  
import org.apache.calcite.rel.RelNode;
        for (RelNode input : getInputs()) {  
            RelNode unwrapped = RelNodeUtils.unwrapHep(input);
        return result;  
/**
                    return planner.getCostFactory().makeInfiniteCost();
        int columnCount = getRowType().getFieldCount();
                        allMatch = false;
    private static OpenSearchDistribution distributionOf(RelNode rel) {  
 * to physical storage (Filter, Aggregate) therefore treat post-Union columns as
    }
    public Union copy(RelTraitSet traitSet, List<RelNode> inputs, boolean all) {
                    return planner.getCostFactory().makeInfiniteCost();
 * this file be licensed under the Apache-2.0 license or a
            }
 * The OpenSearch Contributors require contributions made to  
 *
            if (selfDist.getLocality() == OpenSearchDistribution.Locality.SHARD) {  
    @Override  
                        || !other.getIndexFormats().equals(first.getIndexFormats())) {  
            RelTrait trait = rel.getTraitSet().getTrait(i);
        }
                    }
    @Override
                    FieldStorageInfo other = branch.get(col);
import org.apache.calcite.sql.type.SqlTypeName;  
 * OpenSearch custom Union carrying viable backend list.
    public RelOptCost computeSelfCost(RelOptPlanner planner, RelMetadataQuery mq) {  
            SqlTypeName sqlType = getRowType().getFieldList().get(col).getType().getSqlTypeName();  
                return planner.getCostFactory().makeInfiniteCost();
                return planner.getCostFactory().makeInfiniteCost();
    }  
        List<FieldStorageInfo> result = new ArrayList<>(columnCount);  
import java.util.List;
            return planner.getCostFactory().makeInfiniteCost();  
        super(cluster, traitSet, List.of(), inputs, all);  
                        allMatch = false;
            String fieldName = getRowType().getFieldList().get(col).getName();
                    List<FieldStorageInfo> branch = perInputStorage.get(i);  
    public List<FieldStorageInfo> getOutputFieldStorage() {
 *  
            }
                    if (other.isDerived()  
    public List<String> getViableBackends() {
import org.apache.calcite.plan.RelOptPlanner;  
    }
    @Override  
                        break;
        return new OpenSearchUnion(getCluster(), traitSet, inputs, all, viableBackends);
import org.apache.calcite.plan.RelOptCost;
            if (allMatch) {
import org.apache.calcite.plan.RelOptCluster;
    }
import java.util.ArrayList;
        }  
    }
        for (int col = 0; col < columnCount; col++) {
import org.apache.calcite.plan.RelTraitSet;
import org.opensearch.analytics.spi.FieldStorageInfo;
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {
        return super.explainTerms(pw).item("viableBackends", viableBackends);
    }
import org.apache.calcite.rel.RelDistribution;  
    @Override  
                        || other.getFieldType() != first.getFieldType()
            result.add(allMatch ? first : FieldStorageInfo.derivedColumn(fieldName, sqlType));
 */  
        return planner.getCostFactory().makeTinyCost();  
    }
            OpenSearchDistribution inputDist = distributionOf(input);  
                if (!Integer.valueOf(1).equals(inputDist.getShardCount())) {
