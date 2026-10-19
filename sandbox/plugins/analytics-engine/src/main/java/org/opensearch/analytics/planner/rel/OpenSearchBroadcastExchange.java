    private final int probeNodeEstimate;
        return new OpenSearchBroadcastExchange(getCluster(), getTraitSet(), children.getFirst(), probeNodeEstimate, List.of(backend));
 * SPDX-License-Identifier: Apache-2.0
        double rows = mq.getRowCount(getInput());
}
    }
 *
 *
        // also pays a fixed setup cost (TCP setup + NamedScan registration on each probe).
import org.apache.calcite.plan.RelOptPlanner;  
 * Sibling of {@link OpenSearchExchangeReducer} (SINGLETON gather) and  
 * {@code analytics.mpp.broadcast.probe_estimate}, defaulting to the cluster's data-node count.  
    ) {
 * top-down migration ({@code setTopDownOpt} + Calcite {@code PhysicalNode}) folds the broadcast COST
import org.apache.calcite.plan.RelOptCost;
        // The transfer term is what Volcano uses to discriminate broadcast-vs-shuffle: a
import org.opensearch.analytics.planner.RelNodeUtils;  
import org.apache.calcite.rel.RelWriter;  
    }
    @Override
        RelTraitSet traitSet,  
        this.probeNodeEstimate = probeNodeEstimate;  
 * {@link OpenSearchShuffleExchange} (HASH partition).
        // tiny build side dominates with the setup term (broadcast cheap), a fat build side  
 * this file be licensed under the Apache-2.0 license or a
    }
    public List<FieldStorageInfo> getOutputFieldStorage() {
public class OpenSearchBroadcastExchange extends SingleRel implements OpenSearchRelNode {
    @Override
    public RelOptCost computeSelfCost(RelOptPlanner planner, RelMetadataQuery mq) {
 * <p><b>Cost model.</b> Broadcast moves one copy of the input rows to each probe node. Cost is  
        List<String> viableBackends  
     *  remains the only non-row-proportional term in the plan total. */
 */  
        // Broadcast moves N copies of the row set, where N = probe-node count. Each copy  
 * Broadcast exchange: replicates the input stream's full row set to every probe-side worker.  
     *  losing the cost race against the coord-centric 2×ER plan for small build × medium
 * gets expensive (rows × N grows fast), so HASH wins when both sides are large.  
 * {@code BROADCAST_BUILD} fragment with its own transport (distinct from a shuffle edge). If a future
        return probeNodeEstimate;
 * The OpenSearch Contributors require contributions made to  
        return super.explainTerms(pw).item("probeNodeEstimate", probeNodeEstimate).item("viableBackends", viableBackends);
    public RelWriter explainTerms(RelWriter pw) {
    private static final double SETUP_COST_PER_REPLICA = 0.0;
     *  but with the post-join gather cost (~SETUP_COST_PER_ER + join_rows) added by
        return new OpenSearchBroadcastExchange(getCluster(), getTraitSet(), strippedChildren.getFirst(), probeNodeEstimate, viableBackends);  
import org.apache.calcite.rel.RelNode;
    @Override  
 * into {@link OpenSearchJoin}'s derived distribution trait, this boundary node must still exist for the  
    @Override
/**
     *  probe shapes (5×30 in BroadcastJoinIT). Drop to 0 so the broadcast plan's transfer
        return planner.getCostFactory().makeCost(cost, cost, 0);  
import org.opensearch.analytics.spi.FieldStorageInfo;
 * <p>{@code probeNodeEstimate} is resolved at split-rule time from the cluster setting
 *
    @Override
 * @opensearch.internal  
    }  
    public List<String> getViableBackends() {  
    /** Per-replica fixed setup cost. Originally 5 to discourage broadcast for tiny tables,
 * DAG builder to cut on — a trait on the join alone gives the executor no stage to schedule.
        RelOptCluster cluster,
            return openSearchInput.getOutputFieldStorage();
import java.util.List;  
 *
        }  
    public RelNode copy(RelTraitSet traitSet, List<RelNode> inputs) {
import org.apache.calcite.rel.metadata.RelMetadataQuery;
    }  
     *  cost reflects raw build_rows×probeNodes; the +10 ER setup above the worker join  
        return viableBackends;
    private final List<String> viableBackends;
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {
package org.opensearch.analytics.planner.rel;
/*  
 * {@code Stage} at each exchange, so it is also the physical stage boundary that becomes a  
     *  {@link OpenSearchExchangeReducer} above the worker-join, the total broadcast plan was  
 * HASH_SHUFFLE during CBO: a small build side broadcasts cheaply (small × N), but a large build
 * <p>TODO(trait-propagation): this node is NOT only a cost holder — {@code DAGBuilder} cuts a child
        return List.of();
        if (input instanceof OpenSearchRelNode openSearchInput) {
    }
        int probeNodeEstimate,
import org.apache.calcite.plan.RelTraitSet;
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {  
        double cost = (rows + SETUP_COST_PER_REPLICA) * probeNodeEstimate;
        RelNode input = RelNodeUtils.unwrapHep(getInput());  
 * compatible open source license.
        // dominates with the transfer term and grows linearly with the cluster.
 */
        return new OpenSearchBroadcastExchange(getCluster(), traitSet, sole(inputs), probeNodeEstimate, viableBackends);  
 * roughly {@code inputRowCount × probeNodeEstimate} — this is what discriminates BROADCAST from
    public OpenSearchBroadcastExchange(
    @Override
 * Produced by {@link OpenSearchDistributionTraitDef} when Volcano's trait conversion encounters
    public int getProbeNodeEstimate() {
import org.apache.calcite.rel.SingleRel;
 * a {@code BROADCAST_DISTRIBUTED + REPLICATED} requirement on the build side of an MPP join.
    }
        this.viableBackends = viableBackends;
    }
    @Override  
    }
        super(cluster, traitSet, input);
        RelNode input,
 *
import org.apache.calcite.plan.RelOptCluster;
