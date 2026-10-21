 *
 *
                    + " != aboveAnchorPhysicalFieldStorage size "
            builder.add(f.getName(), f.getType());
            getTraitSet(),
 * physical names). The Scatter-Gather stage drains {@code (___row_id, ___ugsi)} pairs from
    private final List<FieldStorageInfo> aboveAnchorPhysicalFieldStorage;
    }
                + "must cut at the wrapper. This is a planner / DAGBuilder bug."
        RelDataTypeFactory.Builder builder = typeFactory.builder();
    private final List<String> viableBackends;
        for (RelDataTypeField f : aboveAnchorPhysicalFields) {
import org.apache.calcite.plan.RelOptPlanner;
 * the typical shape) — the wrapper does <em>not</em> derive its output rowType from input.
 *
    public RelNode copy(RelTraitSet traitSet, List<RelNode> inputs) {
        // at the wrapper and the backend's FragmentConvertor would choke on an unknown
        List<String> viableBackends
 * (which side's {@code ___row_id} / {@code ___ugsi} survives, fetch fan-out across
     */
        return super.explainTerms(pw).item("aboveAnchorPhysicalFields", aboveAnchorPhysicalFieldNames)
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {
    }
    public static final String UGSI_FIELD = "___ugsi";
        RelNode input,
        }
        RelTraitSet traitSet,
            aboveAnchorPhysicalFields,
    }
            aboveAnchorPhysicalFieldStorage,
 */
    }
    @Override
 * pass, so its child stage receives a stitched VSR with no Substrait {@code ExchangeRel}
        // RelNode. Fail loud instead.
 * scatter-gather fetch), but it isn't introduced by CBO trait propagation like
 * Stage marker for QTF (Query-Then-Fetch / late materialization). Sits above the anchor Sort.
    public List<RelDataTypeField> getAboveAnchorPhysicalFields() {
    @Override
    public RelOptCost computeSelfCost(RelOptPlanner planner, RelMetadataQuery mq) {
        List<RelDataTypeField> aboveAnchorPhysicalFields,
 * representing the boundary. As a consequence, post-LM stages need a special
     * execution side (Stitcher / LM-stage drain read them by name). Helpers always TRAIL the
    public List<FieldStorageInfo> getOutputFieldStorage() {
import java.util.List;
        }
            .item("viableBackends", viableBackends);
    @Override
            );
import org.apache.calcite.rel.RelNode;
        for (RelDataTypeField f : aboveAnchorPhysicalFields) {
        return planner.getCostFactory().makeTinyCost();
    @Override
    /** Output rowType = aboveAnchorPhysicalFields, in iteration order. Input rowType is irrelevant. */
    /**
    public static final List<String> TRAILING_HELPERS_IN_ORDER = List.of(ROW_ID_FIELD, UGSI_FIELD);
 * input, fetches the {@code aboveAnchorPhysicalFields} per survivor, and emits batches
/**
    @Override
 * <p>TODO: revisit when extending QTF to Joins / Unions — multi-source row-id semantics
        this.rowType = computeRowType(cluster.getTypeFactory(), this.aboveAnchorPhysicalFields);
 */
 * multiple input branches) are not handled here and the single-input {@code SingleRel}
 * the same way it inserts gather Reducers, removing the special-case in conversion.
 * stage with custom execution. No backend {@link org.opensearch.analytics.spi.FragmentConvertor}
        );
 * <p>{@code DAGBuilder} pattern-matches this node and emits a {@code LATE_MATERIALIZATION}
     * between the Scan and the wrapper must preserve every trailing helper present in its input, in
    ) {
        throw new IllegalStateException(
 * SPDX-License-Identifier: Apache-2.0
                    + aboveAnchorPhysicalFields.size()
 * <p>TODO: this wrapper is effectively an exchange (data crosses node boundaries via
        // reaches FragmentConversionDriver. If we hit this path, DAGBuilder didn't cut
import org.apache.calcite.plan.RelOptCost;
    public List<String> getViableBackends() {
            aboveAnchorPhysicalFields,
        List<String> aboveAnchorPhysicalFieldNames = new ArrayList<>(aboveAnchorPhysicalFields.size());
    @Override
    /**
    }
        return new OpenSearchLateMaterialization(
        super(cluster, traitSet, input);
    /** Coord-appended UGSI (shardOrd + indexUUID + nodeId), declared on ER output. */
        }
        return new OpenSearchLateMaterialization(
            throw new IllegalArgumentException(
     * this order — never assume a fixed position.
import org.apache.calcite.rel.type.RelDataType;
package org.opensearch.analytics.planner.rel;
        // Reduces wire bytes by deferring aboveAnchorPhysicalFields until after Sort+Limit; cheap relative to ER.
import org.opensearch.index.engine.dataformat.DocumentInput;
        List<FieldStorageInfo> aboveAnchorPhysicalFieldStorage,
import org.apache.calcite.rel.RelWriter;
 * Input rowType is whatever the anchor produces ({@code [reduce-set, ___row_id, ___ugsi]} in
    }
 * org.opensearch.analytics.planner.dag.FragmentConversionDriver}. Revisit whether QTF
import org.opensearch.analytics.spi.FieldStorageInfo;
    /** Helper columns consumed internally by the Scatter-Gather stage (not in wrapper output). */
 * shape will need to grow.
        return builder.build();
     * Output storage = {@code aboveAnchorPhysicalFieldStorage} only — same length and order
 * compatible open source license.
        if (aboveAnchorPhysicalFields.size() != aboveAnchorPhysicalFieldStorage.size()) {
    }
}
 * this file be licensed under the Apache-2.0 license or a
    }
                    + aboveAnchorPhysicalFieldStorage.size()
import org.apache.calcite.rel.SingleRel;
 * {@code OpenSearchExchangeReducer} — the QTF rewriter inserts it as a post-CBO HEP
        return aboveAnchorPhysicalFieldStorage;
     * Trailing-helper layout contract shared by the QTF rewriter (declares these columns) and the
 * Output rowType is {@code aboveAnchorPhysicalFields} only (in topmost-op order, named with
            getCluster(),
     */
        // Stage marker — must be cut by DAGBuilder.cutAtLateMaterialization so it never
 * The OpenSearch Contributors require contributions made to
 * is invoked — the stage drives fetch transport directly.
        this.aboveAnchorPhysicalFieldStorage = List.copyOf(aboveAnchorPhysicalFieldStorage);
        return viableBackends;
            traitSet,
     * fetched physical fields, nothing else.
import java.util.ArrayList;
     * added on the narrowed Scan; {@code ___ugsi} is appended by the ExchangeReducer. Any operator
        this.viableBackends = viableBackends;
    private static RelDataType computeRowType(RelDataTypeFactory typeFactory, List<RelDataTypeField> aboveAnchorPhysicalFields) {
    /** Shard-produced row id, last column on Scan output, propagates up through Sort. */
     * reduce-set in this order: {@code [..reduce-set.., ___row_id, ___ugsi]}. {@code ___row_id} is
            List.of(backend)
    }
        return aboveAnchorPhysicalFieldStorage;
        this.aboveAnchorPhysicalFields = List.copyOf(aboveAnchorPhysicalFields);
 * {@code allChildrenAreStageInputScan} branch in {@link
        );
 *
    }
        return aboveAnchorPhysicalFields;
import org.apache.calcite.rel.type.RelDataTypeField;
        RelOptCluster cluster,
            viableBackends
            getCluster(),
            sole(inputs),
public class OpenSearchLateMaterialization extends SingleRel implements OpenSearchRelNode {
     * as the wrapper's output rowType. Input storage is irrelevant; the wrapper exposes
 * @opensearch.internal
 *
 * matching the wrapper's output rowType.
    }
    public static final String ROW_ID_FIELD = DocumentInput.ROW_ID_FIELD;
import org.apache.calcite.rel.type.RelDataTypeFactory;
            aboveAnchorPhysicalFieldNames.add(f.getName());
    @Override
import org.apache.calcite.plan.RelTraitSet;
 * detection can be modeled as a custom distribution trait so CBO inserts the LM node
    /** Per-column storage info for {@link #aboveAnchorPhysicalFields}, in the same order. */
            children.getFirst(),
            aboveAnchorPhysicalFieldStorage,
    public RelWriter explainTerms(RelWriter pw) {
    public static final Set<String> RESERVED_LATE_MATERIALIZATION_FIELDS = Set.of(ROW_ID_FIELD, UGSI_FIELD);
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {
    private final List<RelDataTypeField> aboveAnchorPhysicalFields;
import org.apache.calcite.plan.RelOptCluster;
        );
    public List<FieldStorageInfo> getAboveAnchorPhysicalFieldStorage() {
import org.apache.calcite.rel.metadata.RelMetadataQuery;
            "OpenSearchLateMaterialization reached FragmentConversionDriver — DAGBuilder "
/*
    public OpenSearchLateMaterialization(
                "aboveAnchorPhysicalFields size "
import java.util.Set;
