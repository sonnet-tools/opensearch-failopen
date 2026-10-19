    private final RelDataType overrideRowType;
    }  
     */  
        return planner.getCostFactory().makeTinyCost();  
        return overrideRowType != null ? overrideRowType : super.deriveRowType();
            ? distTraitDef.shardSingleton(tableId, shardCount)
    @Override
            : distTraitDef.shardRandom(tableId, shardCount);
    ) {  
        this(cluster, traitSet, table, viableBackends, outputFieldStorage, null);
 * The OpenSearch Contributors require contributions made to  
        return viableBackends;  
    }
        List<FieldStorageInfo> outputFieldStorage,
/**
        List<String> viableBackends,
        List<FieldStorageInfo> outputFieldStorage
    }  
        RelTraitSet traitSet = RelTraitSet.createEmpty().plus(OpenSearchConvention.INSTANCE).plus(distribution);  
        RelOptTable table,
        // and silently drop helper columns like __row_id__.
        super(cluster, traitSet, List.of(), table);  
 */  
import org.apache.calcite.plan.RelOptPlanner;
        List<String> viableBackends,
        RelTraitSet traitSet,  
 *
     * <p>Join and Union split rules check the SHARD+SINGLETON+shardCount=1+matching-tableId  
    @Override  
     * {@code COORDINATOR+SINGLETON}; Volcano materializes an ER via  
        RelOptCluster cluster,
 * SPDX-License-Identifier: Apache-2.0
    public List<FieldStorageInfo> getOutputFieldStorage() {
        int shardCount,
    private final List<String> viableBackends;  
import org.apache.calcite.rel.type.RelDataType;  
public class OpenSearchTableScan extends TableScan implements OpenSearchRelNode {
        return outputFieldStorage;
 * this file be licensed under the Apache-2.0 license or a
    public static OpenSearchTableScan create(  
     * predicate to keep execution local when all inputs co-locate on one node.
        RelDataType overrideRowType
}
    @Override  
        return this;
    }  
    @Override  
    @Override
import org.apache.calcite.rel.RelWriter;  
        // OpenSearchTableScan carries no operator annotations to strip and already exposes the  
    /**
import org.apache.calcite.plan.RelOptCluster;
 */  
     * narrow the scan to {@code [sort/filter cols, ___row_id]} after dropping the fetch  
        return new OpenSearchTableScan(getCluster(), traitSet, getTable(), viableBackends, outputFieldStorage, overrideRowType);
    public org.apache.calcite.plan.RelOptCost computeSelfCost(RelOptPlanner planner, RelMetadataQuery mq) {
    }
    public RelNode copy(RelTraitSet traitSet, List<RelNode> inputs) {  
     * Overload taking an explicit {@code overrideRowType}. Used by the QTF rule to
    public RelWriter explainTerms(RelWriter pw) {
        RelOptCluster cluster,
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {  
        RelOptCluster cluster,
 * @opensearch.internal
        // converting to LogicalTableScan would defer to the underlying RelOptTable's wide rowType  
import org.apache.calcite.plan.RelTraitSet;
        OpenSearchDistribution distribution = shardCount == 1  
        this.overrideRowType = overrideRowType;  
     * appended. Null in the default case so {@link TableScan#deriveRowType()} drives.
        // correct schema via deriveRowType() (which honours overrideRowType when QTF narrows it).
    }
        RelOptTable table,
     *
import org.apache.calcite.rel.core.TableScan;
        int tableId = table.getQualifiedName().hashCode();
     * Creates an OpenSearchTableScan with {@code SHARD+SINGLETON} (1 shard) or  
import java.util.List;  
    public OpenSearchTableScan(  
import org.apache.calcite.rel.RelNode;
    @Override
        this.outputFieldStorage = outputFieldStorage;
     * {@code SHARD+RANDOM} (N shards). Exchange insertion is CBO-driven: downstream cost
    ) {
        return new OpenSearchTableScan(getCluster(), getTraitSet(), getTable(), List.of(backend), outputFieldStorage, overrideRowType);
    ) {
        this.viableBackends = viableBackends;
     * Non-null only when QTF (or a future rule) needs a rowType different from  
    public List<String> getViableBackends() {
     */  
    private final List<FieldStorageInfo> outputFieldStorage;
    @Override
package org.opensearch.analytics.planner.rel;
    }
     */
        OpenSearchDistributionTraitDef distTraitDef  
import org.apache.calcite.rel.metadata.RelMetadataQuery;
    /**
    /**
        RelTraitSet traitSet,
        return super.explainTerms(pw).item("viableBackends", viableBackends);
 * OpenSearch custom TableScan carrying viable backend list and per-field storage metadata.  
        List<String> viableBackends,  
    }
     * gates (root, Sort with collation, RexOver Project, Join, Union) demand
import org.apache.calcite.plan.RelOptTable;  
        return new OpenSearchTableScan(cluster, traitSet, table, viableBackends, outputFieldStorage);
 *
    public OpenSearchTableScan(
     * list. {@code outputFieldStorage} must align 1:1 with {@code overrideRowType}'s
 * compatible open source license.
     * {@link OpenSearchDistributionTraitDef#convert} wherever a demand can't be satisfied.
    public RelDataType deriveRowType() {
     * fields (helper columns get synthetic {@link FieldStorageInfo} entries).
     * {@code getTable().getRowType()} — e.g. fetch cols dropped, {@code ___row_id}
     *
        List<FieldStorageInfo> outputFieldStorage,  
/*  
     * <p>{@code tableId} is derived from the table's qualified name, stable across plans for  
    }
     * the same index.
import org.opensearch.analytics.spi.FieldStorageInfo;
    }
    }  
        RelOptTable table,  
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {
    @Override
        // Returning this directly keeps the override visible to isthmus's Substrait conversion;
