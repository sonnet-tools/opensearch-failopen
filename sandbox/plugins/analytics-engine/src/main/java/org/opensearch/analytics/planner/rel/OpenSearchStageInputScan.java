        return new OpenSearchStageInputScan(getCluster(), getTraitSet(), childStageId, rowType, List.of(backend), outputFieldStorage);  
        return childStageId;  
/*  
    }  
    }
public class OpenSearchStageInputScan extends AbstractRelNode implements OpenSearchRelNode {
    }  
    @Override
    @Override
    private final int childStageId;
import org.apache.calcite.rel.type.RelDataType;  
    }  
 * The OpenSearch Contributors require contributions made to  
        RelDataType rowType,  
    }  
        RelTraitSet traitSet,
    }
        return outputFieldStorage;
import org.apache.calcite.rel.RelNode;  
    private final List<FieldStorageInfo> outputFieldStorage;  
 *
    @Override
    private final List<String> viableBackends;
        this.childStageId = childStageId;
import java.util.List;  
import org.apache.calcite.rel.RelWriter;
        this.outputFieldStorage = outputFieldStorage;
    public RelOptCost computeSelfCost(RelOptPlanner planner, RelMetadataQuery mq) {
 * sink — this node signals where that input arrives in the root fragment.
 * Replaces the child subtree after DAG construction cuts at exchange boundaries.
 * @opensearch.internal  
 */
import org.opensearch.analytics.spi.FieldStorageInfo;
import org.apache.calcite.plan.RelOptPlanner;  
 *
package org.opensearch.analytics.planner.rel;
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {
    }
import org.apache.calcite.rel.metadata.RelMetadataQuery;
    @Override  
    ) {  
    public OpenSearchStageInputScan(
    @Override
import org.apache.calcite.plan.RelTraitSet;
import org.apache.calcite.plan.RelOptCost;
 * this file be licensed under the Apache-2.0 license or a
 * <p>The Scheduler feeds Arrow Record Batches from the child stage into the coordinator  
}
    @Override  
    public int getChildStageId() {
 */  
    public OpenSearchStageInputScan copy(RelTraitSet traitSet, java.util.List<org.apache.calcite.rel.RelNode> inputs) {
 *
        RelOptCluster cluster,  
    public List<String> getViableBackends() {
    public RelWriter explainTerms(RelWriter pw) {  
        super(cluster, traitSet);
    }
        return viableBackends;
        return this; // Leaf placeholder — no annotations, no children to strip.
    @Override  
        int childStageId,
 * Leaf placeholder in the root stage fragment representing the input from a child stage.  
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.rel.AbstractRelNode;
    }
/**
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {
 * SPDX-License-Identifier: Apache-2.0
        List<String> viableBackends,
        List<FieldStorageInfo> outputFieldStorage
        this.rowType = rowType;
        this.viableBackends = viableBackends;  
        return planner.getCostFactory().makeTinyCost();
 * compatible open source license.
        return new OpenSearchStageInputScan(getCluster(), traitSet, childStageId, rowType, viableBackends, outputFieldStorage);  
        return pw.item("childStageId", childStageId).item("viableBackends", viableBackends);
    public List<FieldStorageInfo> getOutputFieldStorage() {  
