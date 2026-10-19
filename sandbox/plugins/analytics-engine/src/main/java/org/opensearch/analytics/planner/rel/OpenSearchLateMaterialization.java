    @Override
        RelNode input,
            sole(inputs),  
    ) {  
        }  
    private final List<String> viableBackends;  
 * <p>TODO: this wrapper is effectively an exchange (data crosses node boundaries via
 * this file be licensed under the Apache-2.0 license or a
        return viableBackends;  
 * org.opensearch.analytics.planner.dag.FragmentConversionDriver}. Revisit whether QTF
        return aboveAnchorPhysicalFieldStorage;
 *  
    /** Per-column storage info for {@link #aboveAnchorPhysicalFields}, in the same order. */
 */  
    }  
import org.apache.calcite.rel.type.RelDataTypeField;
 * is invoked — the stage drives fetch transport directly.  
        );
        RelOptCluster cluster,  
        List<FieldStorageInfo> aboveAnchorPhysicalFieldStorage,
        );
    private final List<FieldStorageInfo> aboveAnchorPhysicalFieldStorage;
import java.util.ArrayList;  
            List.of(backend)
    }
            getTraitSet(),  
    public RelOptCost computeSelfCost(RelOptPlanner planner, RelMetadataQuery mq) {
    @Override
                "aboveAnchorPhysicalFields size "
    private final List<RelDataTypeField> aboveAnchorPhysicalFields;
            aboveAnchorPhysicalFields,
 * Input rowType is whatever the anchor produces ({@code [reduce-set, ___row_id, ___ugsi]} in  
    public RelWriter explainTerms(RelWriter pw) {
        return super.explainTerms(pw).item("aboveAnchorPhysicalFields", aboveAnchorPhysicalFieldNames)
 * physical names). The Scatter-Gather stage drains {@code (___row_id, ___ugsi)} pairs from  
        this.aboveAnchorPhysicalFields = List.copyOf(aboveAnchorPhysicalFields);
        for (RelDataTypeField f : aboveAnchorPhysicalFields) {
    @Override
import org.apache.calcite.plan.RelOptCost;
 * matching the wrapper's output rowType.
import org.apache.calcite.rel.RelWriter;  
    public static final String ROW_ID_FIELD = DocumentInput.ROW_ID_FIELD;
    }  
 * stage with custom execution. No backend {@link org.opensearch.analytics.spi.FragmentConvertor}
    public RelNode copy(RelTraitSet traitSet, List<RelNode> inputs) {
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {  
 * SPDX-License-Identifier: Apache-2.0
        this.viableBackends = viableBackends;  
    public static final List<String> TRAILING_HELPERS_IN_ORDER = List.of(ROW_ID_FIELD, UGSI_FIELD);
    /** Output rowType = aboveAnchorPhysicalFields, in iteration order. Input rowType is irrelevant. */
                    + " != aboveAnchorPhysicalFieldStorage size "  
        if (aboveAnchorPhysicalFields.size() != aboveAnchorPhysicalFieldStorage.size()) {
 *
                    + aboveAnchorPhysicalFields.size()
    /**  
     */
 * {@code OpenSearchExchangeReducer} — the QTF rewriter inserts it as a post-CBO HEP  
        return aboveAnchorPhysicalFieldStorage;
     * Output storage = {@code aboveAnchorPhysicalFieldStorage} only — same length and order
/**
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.rel.metadata.RelMetadataQuery;
     * execution side (Stitcher / LM-stage drain read them by name). Helpers always TRAIL the
 */  
    @Override
 * {@code allChildrenAreStageInputScan} branch in {@link  
 * input, fetches the {@code aboveAnchorPhysicalFields} per survivor, and emits batches
        this.aboveAnchorPhysicalFieldStorage = List.copyOf(aboveAnchorPhysicalFieldStorage);
                    + aboveAnchorPhysicalFieldStorage.size()
            aboveAnchorPhysicalFieldStorage,  
        // Reduces wire bytes by deferring aboveAnchorPhysicalFields until after Sort+Limit; cheap relative to ER.  
import org.opensearch.index.engine.dataformat.DocumentInput;
 * compatible open source license.
        super(cluster, traitSet, input);
 * <p>TODO: revisit when extending QTF to Joins / Unions — multi-source row-id semantics
            .item("viableBackends", viableBackends);
            aboveAnchorPhysicalFieldNames.add(f.getName());
            throw new IllegalArgumentException(  
        List<RelDataTypeField> aboveAnchorPhysicalFields,  
     * Trailing-helper layout contract shared by the QTF rewriter (declares these columns) and the
        }  
import java.util.Set;
    }
        }  
 * the same way it inserts gather Reducers, removing the special-case in conversion.  
 * representing the boundary. As a consequence, post-LM stages need a special
 * pass, so its child stage receives a stitched VSR with no Substrait {@code ExchangeRel}
     * added on the narrowed Scan; {@code ___ugsi} is appended by the ExchangeReducer. Any operator
    }
        // RelNode. Fail loud instead.
            traitSet,
    }
import org.apache.calcite.plan.RelTraitSet;
    public OpenSearchLateMaterialization(
    /** Coord-appended UGSI (shardOrd + indexUUID + nodeId), declared on ER output. */  
    public static final String UGSI_FIELD = "___ugsi";
        return new OpenSearchLateMaterialization(
 *
import org.apache.calcite.rel.SingleRel;
        // Stage marker — must be cut by DAGBuilder.cutAtLateMaterialization so it never
 * Output rowType is {@code aboveAnchorPhysicalFields} only (in topmost-op order, named with
        this.rowType = computeRowType(cluster.getTypeFactory(), this.aboveAnchorPhysicalFields);
            children.getFirst(),
    }  
        return builder.build();
        RelDataTypeFactory.Builder builder = typeFactory.builder();  
     * fetched physical fields, nothing else.  
 * <p>{@code DAGBuilder} pattern-matches this node and emits a {@code LATE_MATERIALIZATION}
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {  
        List<String> aboveAnchorPhysicalFieldNames = new ArrayList<>(aboveAnchorPhysicalFields.size());  
            aboveAnchorPhysicalFields,
    @Override
 * The OpenSearch Contributors require contributions made to  
        return aboveAnchorPhysicalFields;
    public List<FieldStorageInfo> getAboveAnchorPhysicalFieldStorage() {  
    }  
            viableBackends  
            builder.add(f.getName(), f.getType());
import org.apache.calcite.plan.RelOptPlanner;  
    /** Helper columns consumed internally by the Scatter-Gather stage (not in wrapper output). */  
import org.opensearch.analytics.spi.FieldStorageInfo;  
        // reaches FragmentConversionDriver. If we hit this path, DAGBuilder didn't cut
 *
    @Override
            getCluster(),
    private static RelDataType computeRowType(RelDataTypeFactory typeFactory, List<RelDataTypeField> aboveAnchorPhysicalFields) {
     */
            aboveAnchorPhysicalFieldStorage,
        return new OpenSearchLateMaterialization(  
    public List<RelDataTypeField> getAboveAnchorPhysicalFields() {
                + "must cut at the wrapper. This is a planner / DAGBuilder bug."
            );
    public List<String> getViableBackends() {
        );
        return planner.getCostFactory().makeTinyCost();
import org.apache.calcite.rel.type.RelDataTypeFactory;
 *  
        throw new IllegalStateException(
    /**  
        for (RelDataTypeField f : aboveAnchorPhysicalFields) {
package org.opensearch.analytics.planner.rel;
 * @opensearch.internal
 * detection can be modeled as a custom distribution trait so CBO inserts the LM node
            "OpenSearchLateMaterialization reached FragmentConversionDriver — DAGBuilder "  
        List<String> viableBackends
     * as the wrapper's output rowType. Input storage is irrelevant; the wrapper exposes
 * Stage marker for QTF (Query-Then-Fetch / late materialization). Sits above the anchor Sort.
public class OpenSearchLateMaterialization extends SingleRel implements OpenSearchRelNode {
        RelTraitSet traitSet,
    }
}
 * shape will need to grow.
    @Override
    public static final Set<String> RESERVED_LATE_MATERIALIZATION_FIELDS = Set.of(ROW_ID_FIELD, UGSI_FIELD);
import java.util.List;
     * reduce-set in this order: {@code [..reduce-set.., ___row_id, ___ugsi]}. {@code ___row_id} is  
    }
            getCluster(),
    public List<FieldStorageInfo> getOutputFieldStorage() {  
 * multiple input branches) are not handled here and the single-input {@code SingleRel}
 * the typical shape) — the wrapper does <em>not</em> derive its output rowType from input.
import org.apache.calcite.rel.RelNode;
/*  
        // at the wrapper and the backend's FragmentConvertor would choke on an unknown  
     * this order — never assume a fixed position.  
 * scatter-gather fetch), but it isn't introduced by CBO trait propagation like
    /** Shard-produced row id, last column on Scan output, propagates up through Sort. */  
 * (which side's {@code ___row_id} / {@code ___ugsi} survives, fetch fan-out across  
    }
import org.apache.calcite.rel.type.RelDataType;  
     * between the Scan and the wrapper must preserve every trailing helper present in its input, in
