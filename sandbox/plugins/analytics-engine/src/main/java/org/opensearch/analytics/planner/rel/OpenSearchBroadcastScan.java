     * <p>Reporting real per-column storage (not an empty list) is REQUIRED: when a Project or PARTIAL
                    List.of(),
                )  
    public List<FieldStorageInfo> getOutputFieldStorage() {
            );
    public static String namedInputIdFor(int buildStageId) {  
    public OpenSearchBroadcastScan copy(RelTraitSet traitSet, List<RelNode> inputs) {  
 *  
import org.opensearch.analytics.spi.FieldType;  
     * conversion (observed on TPC-H q5/q10). Use {@link #OpenSearchBroadcastScan(RelOptCluster,
        RelOptCluster cluster,
    }
        List<FieldStorageInfo> storage = new ArrayList<>(rowType.getFieldCount());  
                new FieldStorageInfo(  
     * aggregate sits above a join that has a broadcast scan as one input (the distributed-agg-over-join  
    ) {
import org.apache.calcite.rel.metadata.RelMetadataQuery;
            storage.add(
    @Override
 * Leaf placeholder representing a broadcast-build input on the probe side of an M1 broadcast
    }
        RelTraitSet traitSet,  
        for (RelDataTypeField field : rowType.getFieldList()) {
    }
    }  
     */  
        return "broadcast-" + buildStageId;
    /** Canonical name used by both sides of the wire — matches what the handler registers. */
 * {@code "broadcast-&lt;buildStageId&gt;"}. Both the coordinator (when constructing the
 * join. Analogous to {@link OpenSearchStageInputScan} but for the broadcast-injection path:
    private static List<FieldStorageInfo> synthesizeStorage(RelDataType rowType) {
 *
        this(cluster, traitSet, buildStageId, rowType, viableBackends, synthesizeStorage(rowType));
public class OpenSearchBroadcastScan extends AbstractRelNode implements OpenSearchRelNode {
        RelDataType rowType,  
        this.viableBackends = viableBackends;  
    private final List<FieldStorageInfo> outputFieldStorage;  
     * {@code getOutputFieldStorage()}. An empty list here truncates that union, so a ref to a column
 * @opensearch.internal  
     *  authority for a fully-materialized broadcast leaf). */
                    List.of(),  
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {
        this.buildStageId = buildStageId;
import java.util.ArrayList;
/*  
    }  
                    field.getType().getSqlTypeName().getName(),
        RelTraitSet traitSet,
    public RelWriter explainTerms(RelWriter pw) {
        return this; // Leaf placeholder — no annotations, no children to strip.  
    private final int buildStageId;
     * RelTraitSet, int, RelDataType, List, List)} to pass the build subtree's exact storage instead.
 */  
                    new LinkedHashSet<>()
import org.apache.calcite.rel.type.RelDataType;  
import org.opensearch.analytics.spi.FieldStorageInfo;
        List<FieldStorageInfo> outputFieldStorage
 * SPDX-License-Identifier: Apache-2.0
    }
        int buildStageId,
        this.rowType = rowType;
 * (when registering the memtable) agree on the string.
     *  the caller has no upstream storage to thread through (the build subtree's own row type is the  
    ) {  
import org.apache.calcite.plan.RelOptCost;
    }  
    @Override
        super(cluster, traitSet);
        return viableBackends;  
    @Override  
import org.apache.calcite.rel.RelNode;  
        return pw.item("buildStageId", buildStageId).item("namedInputId", getNamedInputId()).item("viableBackends", viableBackends);
    }
        return buildStageId;
        return namedInputIdFor(buildStageId);  
import java.util.List;
    @Override
import org.apache.calcite.plan.RelOptCluster;
        return outputFieldStorage;
 * this file be licensed under the Apache-2.0 license or a
    private final List<String> viableBackends;
        return new OpenSearchBroadcastScan(getCluster(), getTraitSet(), buildStageId, rowType, List.of(backend), outputFieldStorage);
     * path), the consuming operator resolves {@code RexInputRef}s against the union of its inputs'
 * satisfy this scan at execution time.
    @Override  
                    FieldType.fromSqlTypeName(field.getType().getSqlTypeName()),  
    }  
     * non-derived, materialized physical column per output field). A broadcast scan is a leaf whose
 */
}
    public int getBuildStageId() {  
/**  
 * rather than signalling where a child-stage's partition stream feeds in, it signals where the  
                    /* derived */ false,
        return planner.getCostFactory().makeTinyCost();  
import org.apache.calcite.plan.RelOptPlanner;  
    @Override
    /**
 * compatible open source license.
import org.apache.calcite.rel.type.RelDataTypeField;
     * field identified by its own name — there are no derived columns and no upstream physical deps.  
import org.apache.calcite.plan.RelTraitSet;
import java.util.LinkedHashSet;  
 *
    public OpenSearchBroadcastScan(
 * {@link org.opensearch.analytics.spi.BroadcastInjectionInstructionNode}) and the data node  
     * Convenience ctor: SYNTHESIZES per-column {@link FieldStorageInfo} from {@code rowType} (one  
    public OpenSearchBroadcastScan(
        List<String> viableBackends,
        return new OpenSearchBroadcastScan(getCluster(), traitSet, buildStageId, rowType, viableBackends, outputFieldStorage);
        }
        return storage;  
    public RelOptCost computeSelfCost(RelOptPlanner planner, RelMetadataQuery mq) {
    }
import org.apache.calcite.rel.AbstractRelNode;
    @Override
    }
     * rows arrive fully materialized from the injected memtable, so each output column is a physical
import org.apache.calcite.rel.RelWriter;
        RelDataType rowType,
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {  
        this.outputFieldStorage = outputFieldStorage;
 * The OpenSearch Contributors require contributions made to  
        int buildStageId,
package org.opensearch.analytics.planner.rel;
 * probe-side {@code BroadcastInjectionHandler} has registered a {@code MemTable} that should
     *
                    field.getName(),
        RelOptCluster cluster,  
    /** One non-derived (physical, materialized) {@link FieldStorageInfo} per output field — used when
 * <p>The build stage id determines the name used on the wire and in the Substrait plan —
    }
    public String getNamedInputId() {
        List<String> viableBackends  
                    List.of(),
    }
    public List<String> getViableBackends() {
     * past the truncation throws "RexInputRef[N] has no matching FieldStorageInfo entry" at fragment  
