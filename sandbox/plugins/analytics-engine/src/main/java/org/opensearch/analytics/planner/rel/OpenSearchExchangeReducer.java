    }
        RelTraitSet traitSet,
    }
        ExchangeInfo exchangeInfo,
     * prefers fewer ERs over more ERs even when the total row count shipped is identical:
    /** Distribution this reducer represents — read by DAGBuilder when cutting child stages. */
    /** Per-gathered-column weight, added (not row-multiplied) to the gather cost. Purely a
 * The OpenSearch Contributors require contributions made to
        // demands SINGLETON input and the child delivers RANDOM.
            getTraitSet(),
        );
        return planner.getCostFactory().makeCost(SETUP_COST + rows + widthCost, SETUP_COST + rows + widthCost, 0);
     * Non-null only when QTF (or a future rule) declares additional coord-side columns
    // Per-ER setup cost (TCP, gRPC handshake, schema negotiation, allocator init). Tuned to
import org.apache.calcite.plan.RelOptCluster;
    }
        ExchangeInfo exchangeInfo,
    private final List<FieldStorageInfo> overrideStorage;
     */
import org.opensearch.analytics.planner.dag.ExchangeInfo;
    public OpenSearchExchangeReducer(RelOptCluster cluster, RelTraitSet traitSet, RelNode input, List<String> viableBackends) {
    public RelDataType deriveRowType() {
     * e.g. {@code Union(SHARD) ← 1 ER above} (one ER moving 20 rows) is cheaper than
    private final List<String> viableBackends;
    }
            viableBackends,
     * {@code ShardFragmentStageExecution.responseListenerFor}). Null in the default case
    /**
     */
            return overrideStorage;
        RelOptCluster cluster,
     */
     * on the ER's output (e.g. {@code ___ugsi} appended at runtime by
        this(cluster, traitSet, input, viableBackends, exchangeInfo, overrideRowType, null);
        return viableBackends;
        );
    }
        return overrideRowType != null;
        this(cluster, traitSet, input, viableBackends, exchangeInfo, null);
            traitSet,
    @Override
    @Override
            sole(inputs),
        RelNode input = RelNodeUtils.unwrapHep(getInput());
    @Override
        // matching overrideStorage so rowType and FSI stay aligned 1:1. Otherwise delegate to input.
    }
        RelNode input,
     *  well below 1 row so it can NEVER flip a row-dominated decision (e.g. broadcast-vs-coord-centric,
        // Width term is ADDITIVE (per-column overhead), NOT rows × width. Two competing decisions key
import org.opensearch.analytics.planner.RelNodeUtils;
    private static final double SETUP_COST = 25.0;
        return new OpenSearchExchangeReducer(
 *
    }
            exchangeInfo,
 * Coordinator-side reducer for exchanges. Receives streaming Arrow batches from
        return new OpenSearchExchangeReducer(
            return openSearchInput.getOutputFieldStorage();
            overrideRowType,
        this.viableBackends = viableBackends;
            getTraitSet(),
            List.of(backend),
        this.overrideRowType = overrideRowType;
            overrideStorage
        );
            children.getFirst(),
        double widthCost = WIDTH_COST * getRowType().getFieldCount();
    }
     * True when this reducer carries a QTF-declared {@link #overrideRowType} (the coord-side
        return new OpenSearchExchangeReducer(
 * SPDX-License-Identifier: Apache-2.0
    // plus build replication, which lets the cost model pick BROADCAST for the canonical
 * describing the distribution (defaults to SINGLETON; HASH/RANGE not wired yet).
        return exchangeInfo;
        List<String> viableBackends,
    public RelNode copy(RelTraitSet traitSet, List<RelNode> inputs) {
            strippedChildren.getFirst(),
            getCluster(),
     *  ({@link org.opensearch.analytics.planner.rules.OpenSearchAggLiteralArgProjectSplitRule}),
import org.apache.calcite.plan.RelTraitSet;
import org.apache.calcite.rel.metadata.RelMetadataQuery;
        this(cluster, traitSet, input, viableBackends, ExchangeInfo.singleton(), null);
     * rebuild it via {@code buildReducer()}: that goes through the 4-arg constructor and drops both the
     * so {@link ConverterImpl#deriveRowType()} drives.
import org.opensearch.analytics.spi.FieldStorageInfo;
}
    // arithmetic and Volcano picked the wrong shape; higher values would over-penalize
    ) {
     * runtime in {@code ShardFragmentStageExecution.responseListenerFor} per task. Schema
    @Override
    public OpenSearchExchangeReducer(
     */
            getCluster(),
     */
     * declaration here lets the reduce sink's schema-validation pass.
     * Overload taking an explicit {@code overrideRowType}. Used by the QTF rule to declare
     * {@code overrideRowType} and is returned verbatim by {@link #getOutputFieldStorage()}. QTF
/*
     * transport but double the setup).
 * this file be licensed under the Apache-2.0 license or a
     * {@code Union(COORDINATOR) ← 2 ERs below} (two ERs moving 10 rows each, same total
        return super.explainTerms(pw).item("viableBackends", viableBackends).item("exchange", exchangeInfo);
     * so the {@code ___ugsi} column it declares has a corresponding {@link FieldStorageInfo}. Null
    }
    /**
        RelOptCluster cluster,
     *  where narrow-vs-wide projects carry identical row counts so only column count differs. Kept
            overrideStorage
        ExchangeInfo exchangeInfo
     * override row type and its {@code overrideStorage}, after which the reduce sink's schema validation
    public RelOptCost computeSelfCost(RelOptPlanner planner, RelMetadataQuery mq) {
    ) {
     * rejects the runtime batch (declared schema is missing {@code ___ugsi}).
        List<FieldStorageInfo> overrideStorage
        RelNode input,
    public List<FieldStorageInfo> getOutputFieldStorage() {
            overrideRowType,
            overrideRowType,
import org.apache.calcite.plan.RelOptCost;
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {
    private final ExchangeInfo exchangeInfo;
     * uses it to pair the {@code ___ugsi} column it declares with a matching {@link FieldStorageInfo}.
        if (input instanceof OpenSearchRelNode openSearchInput) {
            exchangeInfo,
        // ConverterImpl makes this a Calcite-recognized trait converter — inserted by
    public List<String> getViableBackends() {
        // upstream merge introduced) inflated the 2×ER plan and made CBO stop picking BROADCAST
    /**
 */
        RelDataType overrideRowType
        // 2. Broadcast vs coordinator-centric (BroadcastJoinIT): coord-centric pays 2× ER, broadcast
        RelNode input,
        if (overrideStorage != null) {
     *  which differ by tens of rows) — that race must be decided on rows. */
    // small-dim × large-fact LEFT/RIGHT outer cases that BroadcastJoinIT exercises. Lower
    // 25 so the coord-centric plan's 2×ER setup outweighs the broadcast plan's 1×ER setup
 * @opensearch.internal
import org.apache.calcite.rel.convert.ConverterImpl;
 *
        List<String> viableBackends,
    /** Convenience constructor — defaults to {@link ExchangeInfo#singleton()}. */
import org.apache.calcite.rel.RelWriter;
    // coord-centric on small queries where it's actually optimal.
        // 1. Project placement (OpenSearchAggLiteralArgProjectSplitRule): the narrow vs wide project
        // ExchangeReducer is an infrastructure node — strip children but keep the node itself.
        // ADDITIVE width satisfies both: it breaks the equal-row project-placement tie, but stays a
import java.util.List;
    }
    private final RelDataType overrideRowType;
 * {@code DAGBuilder} reads the ExchangeInfo directly off the reducer when cutting.
        RelTraitSet traitSet,
        List<String> viableBackends,
    // values made the LEFT outer path tie too closely with coord-centric on the per-ER row
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {
    }
        // small constant when row counts differ, so it can't flip the row-dominated join-strategy
    @Override
        // prefer gathering fewer columns — pushing the narrow project below the ER.
    /**
     * Field storage matching {@link #overrideRowType} 1:1, supplied by QTF alongside the override
            viableBackends,
        }
     * Full constructor. {@code overrideStorage}, when non-null, must align 1:1 with
    }
    /**
        this.overrideStorage = overrideStorage;
 * upstream stages via Analytics Core transport. Carries an {@link ExchangeInfo}
        RelOptCluster cluster,
    @Override
        // pays 1× ER + a width-agnostic broadcast exchange. A rows × width ER term (what an
        // race. WIDTH_COST weights each gathered column. Keep broadcast/shuffle width-agnostic — the
        // for modest size asymmetries (dim=5 × fact=30) — the regression.
        RelTraitSet traitSet,
        // join-strategy race must be decided on rows, not width.
     *  TIE-BREAKER for equal-row decisions — chiefly project placement below the ER
/**
        return List.of();
package org.opensearch.analytics.planner.rel;
        // off this ER cost and pull in opposite directions:
        // below the ER carry the SAME row count (a Project is 1:1), so only a width term lets CBO
        double rows = mq.getRowCount(getInput());
            exchangeInfo,
        RelDataType overrideRowType,
     * Cost = setup overhead + transport per row. The fixed overhead per ER ensures Volcano
    }
     * whenever {@code overrideRowType} is null; non-null only on QTF-rebuilt ERs.
        // When QTF rebuilds this ER with an overrideRowType (declaring ___ugsi), it supplies the
    public boolean hasOverrideRowType() {
    /**
    @Override
import org.apache.calcite.plan.RelOptPlanner;
        // Volcano via OpenSearchDistributionTraitDef.convert when a downstream operator
    @Override
    public OpenSearchExchangeReducer(
        this.exchangeInfo = exchangeInfo;
            getCluster(),
        }
     * {@code ___ugsi} on the ER's output schema — the column is appended coord-side at
    }
 */
        super(cluster, null, traitSet, input);
            overrideStorage
    ) {
    public ExchangeInfo getExchangeInfo() {
        return overrideRowType != null ? overrideRowType : super.deriveRowType();
public class OpenSearchExchangeReducer extends ConverterImpl implements OpenSearchRelNode {
    private static final double WIDTH_COST = 0.1;
 * compatible open source license.
     * {@code ___ugsi} column). {@code DistributionEnforcementPass} must NOT peel such a reducer and
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.type.RelDataType;
    public RelWriter explainTerms(RelWriter pw) {
     */
    public OpenSearchExchangeReducer(
