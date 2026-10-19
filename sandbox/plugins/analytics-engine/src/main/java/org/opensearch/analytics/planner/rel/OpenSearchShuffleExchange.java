/*  
        this.hashKeys = List.copyOf(hashKeys);
            getCluster(),
    private final int partitionCount;
 * compatible open source license.
 * at this node to produce hash-shuffle scan stages (M2).
 * SPDX-License-Identifier: Apache-2.0
        RelNode input,
    public RelOptCost computeSelfCost(RelOptPlanner planner, RelMetadataQuery mq) {
    public RelWriter explainTerms(RelWriter pw) {
import org.opensearch.analytics.planner.RelNodeUtils;  
        return viableBackends;
import org.apache.calcite.rel.SingleRel;
    }
        double rows = mq.getRowCount(getInput());
package org.opensearch.analytics.planner.rel;
        );
    @Override  
 * @opensearch.internal  
        return super.explainTerms(pw).item("hashKeys", hashKeys)  
 *
 *
    private static final double SETUP_COST_PER_PARTITION = 5.0;
 * output partitions, each routed to a worker node. Produced by {@link OpenSearchDistributionTraitDef}
import org.apache.calcite.plan.RelTraitSet;
 * when Volcano's trait conversion encounters a HASH_DISTRIBUTED requirement. Currently unreachable
        List<Integer> hashKeys,  
            .item("partitionCount", partitionCount)
        return planner.getCostFactory().makeCost(cost, cost, 0);
    @Override
        RelTraitSet traitSet,
    }
    private final List<Integer> hashKeys;
import org.apache.calcite.rel.RelWriter;  
            return openSearchInput.getOutputFieldStorage();  
        double cost = rows + SETUP_COST_PER_PARTITION * partitionCount;  
    @Override
    public List<Integer> getHashKeys() {
    public int getPartitionCount() {
        // dominated by the transfer term (proportional to rows) plus a per-partition setup
     *  otherwise tie broadcast on raw transfer. */  
 * because no rule emits HASH-distributed alternatives under PR #21639's split-rule design — kept  
    }  
import org.apache.calcite.rel.RelNode;
        return List.of();
        List<String> viableBackends
        // cost. This is the discriminator vs broadcast: shuffle's transfer term doesn't
    }
import org.opensearch.analytics.spi.FieldStorageInfo;
    @Override
import org.apache.calcite.plan.RelOptPlanner;  
 * The OpenSearch Contributors require contributions made to  
    @Override  
import org.apache.calcite.plan.RelOptCluster;
/**
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {  
        RelOptCluster cluster,  
    }
 * this file be licensed under the Apache-2.0 license or a
    @Override
    }  
import org.apache.calcite.plan.RelOptCost;
     *  per-partition state on the consumer. Discourages shuffle for tiny inputs that would
        return new OpenSearchShuffleExchange(  
    public List<String> getViableBackends() {
}  
            hashKeys,
    }
        // large build side shuffle wins because broadcast multiplies rows×N.
 */
        int partitionCount,
 * for the M2 hash-shuffle redesign.
    }  
    @Override
        // Hash shuffle moves all input rows once, partitioned across N consumers. Cost is  
 * <p>Sibling of {@link OpenSearchExchangeReducer} (SINGLETON gather). The {@code DAGBuilder} cuts  
        if (input instanceof OpenSearchRelNode openSearchInput) {
    public OpenSearchShuffleExchange(
import java.util.List;  
            .item("viableBackends", viableBackends);
    public List<FieldStorageInfo> getOutputFieldStorage() {  
        // build side broadcast can win even though it pays N copies of setup, while for a
        return new OpenSearchShuffleExchange(getCluster(), getTraitSet(), children.getFirst(), hashKeys, partitionCount, List.of(backend));
            strippedChildren.getFirst(),  
        return hashKeys;
    }
            getTraitSet(),
        return new OpenSearchShuffleExchange(getCluster(), traitSet, sole(inputs), hashKeys, partitionCount, viableBackends);
 * Hash-shuffle exchange: partitions the input stream by {@code hashKeys} into {@code partitionCount}  
public class OpenSearchShuffleExchange extends SingleRel implements OpenSearchRelNode {
            viableBackends  
        super(cluster, traitSet, input);
        return partitionCount;  
    private final List<String> viableBackends;  
 *
    }  
        this.viableBackends = viableBackends;
    public RelNode copy(RelTraitSet traitSet, List<RelNode> inputs) {  
        }
    /** Per-partition fixed setup cost — captures TCP setup, NamedScan registration, and
 */  
import org.apache.calcite.rel.metadata.RelMetadataQuery;
        // multiply by node count (each row goes to exactly one consumer), so for a small  
        RelNode input = RelNodeUtils.unwrapHep(getInput());
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {
            partitionCount,
        this.partitionCount = partitionCount;  
    ) {  
