     * rejects the runtime batch (declared schema is missing {@code ___ugsi}).
            overrideStorage  
     */  
    ) {  
     * on the ER's output (e.g. {@code ___ugsi} appended at runtime by  
            List.of(backend),  
    // values made the LEFT outer path tie too closely with coord-centric on the per-ER row
 * this file be licensed under the Apache-2.0 license or a
        this.overrideRowType = overrideRowType;
     * True when this reducer carries a QTF-declared {@link #overrideRowType} (the coord-side
            viableBackends,
        return planner.getCostFactory().makeCost(SETUP_COST + rows + widthCost, SETUP_COST + rows + widthCost, 0);
        return new OpenSearchExchangeReducer(
    @Override
     * so the {@code ___ugsi} column it declares has a corresponding {@link FieldStorageInfo}. Null
            viableBackends,
    /**  
            return openSearchInput.getOutputFieldStorage();
    }
     * e.g. {@code Union(SHARD) ← 1 ER above} (one ER moving 20 rows) is cheaper than
        // below the ER carry the SAME row count (a Project is 1:1), so only a width term lets CBO
    public OpenSearchExchangeReducer(RelOptCluster cluster, RelTraitSet traitSet, RelNode input, List<String> viableBackends) {
    // Per-ER setup cost (TCP, gRPC handshake, schema negotiation, allocator init). Tuned to  
 */  
        );
}
import org.apache.calcite.plan.RelOptPlanner;  
        List<String> viableBackends,  
     * {@code overrideRowType} and is returned verbatim by {@link #getOutputFieldStorage()}. QTF
            overrideRowType,  
    public OpenSearchExchangeReducer(
        RelNode input = RelNodeUtils.unwrapHep(getInput());  
        // ADDITIVE width satisfies both: it breaks the equal-row project-placement tie, but stays a
    public RelWriter explainTerms(RelWriter pw) {
    public boolean hasOverrideRowType() {
 *  
    @Override
        RelTraitSet traitSet,  
        RelNode input,
            sole(inputs),  
        double rows = mq.getRowCount(getInput());
    @Override
public class OpenSearchExchangeReducer extends ConverterImpl implements OpenSearchRelNode {  
        );  
    }
     * declaration here lets the reduce sink's schema-validation pass.
    @Override
     * rebuild it via {@code buildReducer()}: that goes through the 4-arg constructor and drops both the  
        return exchangeInfo;  
    @Override
    }
    }
    @Override  
     *  which differ by tens of rows) — that race must be decided on rows. */
            getCluster(),
import org.apache.calcite.plan.RelOptCost;
 */
 * @opensearch.internal
        ExchangeInfo exchangeInfo
        RelOptCluster cluster,
        // upstream merge introduced) inflated the 2×ER plan and made CBO stop picking BROADCAST  
     * prefers fewer ERs over more ERs even when the total row count shipped is identical:
    private final ExchangeInfo exchangeInfo;  
            return overrideStorage;
import org.apache.calcite.plan.RelOptCluster;
        RelDataType overrideRowType
        }  
        return super.explainTerms(pw).item("viableBackends", viableBackends).item("exchange", exchangeInfo);  
    }
        List<String> viableBackends,
        // 2. Broadcast vs coordinator-centric (BroadcastJoinIT): coord-centric pays 2× ER, broadcast
        // ExchangeReducer is an infrastructure node — strip children but keep the node itself.  
        return new OpenSearchExchangeReducer(  
        RelOptCluster cluster,
     *  TIE-BREAKER for equal-row decisions — chiefly project placement below the ER
    public RelNode copy(RelTraitSet traitSet, List<RelNode> inputs) {
        // matching overrideStorage so rowType and FSI stay aligned 1:1. Otherwise delegate to input.
        // race. WIDTH_COST weights each gathered column. Keep broadcast/shuffle width-agnostic — the
     * Full constructor. {@code overrideStorage}, when non-null, must align 1:1 with
     * {@code ShardFragmentStageExecution.responseListenerFor}). Null in the default case
    // arithmetic and Volcano picked the wrong shape; higher values would over-penalize
    public OpenSearchExchangeReducer(
        // ConverterImpl makes this a Calcite-recognized trait converter — inserted by
    /** Convenience constructor — defaults to {@link ExchangeInfo#singleton()}. */
    private static final double WIDTH_COST = 0.1;  
    public ExchangeInfo getExchangeInfo() {
            overrideStorage
    }
            getCluster(),
    // 25 so the coord-centric plan's 2×ER setup outweighs the broadcast plan's 1×ER setup
    }
    private final List<FieldStorageInfo> overrideStorage;
     * override row type and its {@code overrideStorage}, after which the reduce sink's schema validation
        );
 * {@code DAGBuilder} reads the ExchangeInfo directly off the reducer when cutting.
import org.apache.calcite.plan.RelTraitSet;
            strippedChildren.getFirst(),
    /**  
    public List<String> getViableBackends() {  
        // 1. Project placement (OpenSearchAggLiteralArgProjectSplitRule): the narrow vs wide project
    /** Per-gathered-column weight, added (not row-multiplied) to the gather cost. Purely a  
     *  ({@link org.opensearch.analytics.planner.rules.OpenSearchAggLiteralArgProjectSplitRule}),
import org.apache.calcite.rel.metadata.RelMetadataQuery;
        return overrideRowType != null;
            getTraitSet(),
        return viableBackends;
        }
import org.apache.calcite.rel.type.RelDataType;  
            overrideStorage
        RelTraitSet traitSet,
        RelOptCluster cluster,  
    public List<FieldStorageInfo> getOutputFieldStorage() {  
    @Override
    public RelOptCost computeSelfCost(RelOptPlanner planner, RelMetadataQuery mq) {  
     */  
package org.opensearch.analytics.planner.rel;
            getCluster(),  
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {
     * Non-null only when QTF (or a future rule) declares additional coord-side columns
 * upstream stages via Analytics Core transport. Carries an {@link ExchangeInfo}  
            children.getFirst(),
            overrideRowType,
        return List.of();
        this.exchangeInfo = exchangeInfo;
        RelNode input,  
    }  
     */
import org.opensearch.analytics.planner.dag.ExchangeInfo;
 * describing the distribution (defaults to SINGLETON; HASH/RANGE not wired yet).
     *  well below 1 row so it can NEVER flip a row-dominated decision (e.g. broadcast-vs-coord-centric,
     * {@code Union(COORDINATOR) ← 2 ERs below} (two ERs moving 10 rows each, same total  
    public RelDataType deriveRowType() {
     * so {@link ConverterImpl#deriveRowType()} drives.
     */
    // coord-centric on small queries where it's actually optimal.  
    /**
    }
            getTraitSet(),  
     *  where narrow-vs-wide projects carry identical row counts so only column count differs. Kept  
     * {@code ___ugsi} column). {@code DistributionEnforcementPass} must NOT peel such a reducer and
    }
            exchangeInfo,
    /**  
        super(cluster, null, traitSet, input);
     * uses it to pair the {@code ___ugsi} column it declares with a matching {@link FieldStorageInfo}.  
    private final List<String> viableBackends;
    // small-dim × large-fact LEFT/RIGHT outer cases that BroadcastJoinIT exercises. Lower  
            exchangeInfo,  
        this(cluster, traitSet, input, viableBackends, exchangeInfo, null);
    // plus build replication, which lets the cost model pick BROADCAST for the canonical
    ) {
     * Field storage matching {@link #overrideRowType} 1:1, supplied by QTF alongside the override
        this.viableBackends = viableBackends;  
        // Width term is ADDITIVE (per-column overhead), NOT rows × width. Two competing decisions key
import org.apache.calcite.rel.RelNode;
        double widthCost = WIDTH_COST * getRowType().getFieldCount();  
        this(cluster, traitSet, input, viableBackends, ExchangeInfo.singleton(), null);  
        RelNode input,
    /**
            overrideRowType,
        if (input instanceof OpenSearchRelNode openSearchInput) {
        // small constant when row counts differ, so it can't flip the row-dominated join-strategy  
    private static final double SETUP_COST = 25.0;
        ExchangeInfo exchangeInfo,  
     * Cost = setup overhead + transport per row. The fixed overhead per ER ensures Volcano  
import org.opensearch.analytics.planner.RelNodeUtils;
        RelDataType overrideRowType,
/*  
        // for modest size asymmetries (dim=5 × fact=30) — the regression.
import org.opensearch.analytics.spi.FieldStorageInfo;  
    @Override  
        return overrideRowType != null ? overrideRowType : super.deriveRowType();
        return new OpenSearchExchangeReducer(
    ) {
    public OpenSearchExchangeReducer(  
import java.util.List;
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {
 * The OpenSearch Contributors require contributions made to  
        RelTraitSet traitSet,
        List<String> viableBackends,
    /** Distribution this reducer represents — read by DAGBuilder when cutting child stages. */
 *
        List<FieldStorageInfo> overrideStorage  
            traitSet,
     */
        if (overrideStorage != null) {  
     * whenever {@code overrideRowType} is null; non-null only on QTF-rebuilt ERs.  
        // pays 1× ER + a width-agnostic broadcast exchange. A rows × width ER term (what an
    }  
 * Coordinator-side reducer for exchanges. Receives streaming Arrow batches from
            exchangeInfo,
        // Volcano via OpenSearchDistributionTraitDef.convert when a downstream operator  
        ExchangeInfo exchangeInfo,
        // demands SINGLETON input and the child delivers RANDOM.
        // off this ER cost and pull in opposite directions:  
 * SPDX-License-Identifier: Apache-2.0
/**
        // prefer gathering fewer columns — pushing the narrow project below the ER.  
     * {@code ___ugsi} on the ER's output schema — the column is appended coord-side at  
        // join-strategy race must be decided on rows, not width.
        // When QTF rebuilds this ER with an overrideRowType (declaring ___ugsi), it supplies the
    private final RelDataType overrideRowType;
     * runtime in {@code ShardFragmentStageExecution.responseListenerFor} per task. Schema
import org.apache.calcite.rel.RelWriter;  
     */  
    }  
    /**
import org.apache.calcite.rel.convert.ConverterImpl;
    }
        this(cluster, traitSet, input, viableBackends, exchangeInfo, overrideRowType, null);  
     * transport but double the setup).
        this.overrideStorage = overrideStorage;  
    }
     * Overload taking an explicit {@code overrideRowType}. Used by the QTF rule to declare
 * compatible open source license.
