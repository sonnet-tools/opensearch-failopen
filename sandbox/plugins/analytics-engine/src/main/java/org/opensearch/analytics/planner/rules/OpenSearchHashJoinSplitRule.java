    }
            shuffledLeft,  
        call.transformTo(workerJoin);
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;  
        // on shapes like Join(Scan, Values) — Values has no shard distribution, so the resulting
 * SPDX-License-Identifier: Apache-2.0
 *   <li>The resolved partition count (cluster setting → engine default) must be ≥ 2. A count  
        if (joinDist.getLocality() != OpenSearchDistribution.Locality.WORKER) return false;
        // The hash-join itself runs at WORKER+HASH(leftKeys, N). Convention: use the left
        RelTraitSet rightTraits = join.getRight().getTraitSet().replace(rightHash);  
    public boolean matches(RelOptRuleCall call) {
        super(operand(OpenSearchJoin.class, any()), "OpenSearchHashJoinSplitRule");
            return false;
 *   <li>{@code joinAlreadyResolvedAsHash(...)} must be false to avoid re-firing on the rule's  
 * HASH-localized alternative that {@code OpenSearchJoin}'s cost gate accepts when both inputs  
 * </ul>
    private static boolean isShardScan(RelNode rel) {
        // ER above. The transformTo target carries WORKER traits; Volcano's enforcement will
        // independently — it doesn't compare the join's keys to inputs').  
        // it, distTraitDef.hash() would receive an empty key list and produce a partitioning that
        if (info.leftKeys.isEmpty()) {  
 * The OpenSearch Contributors require contributions made to  
    private static boolean joinAlreadyResolvedAsHash(OpenSearchJoin join) {
        if (!AnalyticsSettings.MPP_ENABLED.get(context.getSettings())) {
        }
        if (joinDist == null) return false;  
import org.opensearch.analytics.AnalyticsSettings;  
        if (rel instanceof OpenSearchTableScan) return true;
     *  producer would be a coordinator-reduce stage with no partitioned-sink hookup — the
        convert(workerJoin, coordTraits);
     *  worker waits forever on senders that never ship. */  
 *   <li>{@code analytics.mpp.enabled} must be true (the master kill switch covers all MPP
        // residual non-equi predicate (e.g. TPC-H q14: l_partkey=p_partkey AND l_shipdate BETWEEN …).
    /** True when {@code rel}'s OpenSearchDistribution is SHARD-localized AND its subtree is a
        // wrap with an ER when a SINGLETON consumer demands it.
        // ShardTargetResolver can't find a TableScan and bails out.  
public class OpenSearchHashJoinSplitRule extends RelOptRule {
        return isPureShardScanShape(rel);
 *   <li>{@code JoinInfo.isEqui()} must be true. Hash partitioning requires equality predicates;
        // doesn't actually partition. We do NOT require info.isEqui(): a join may carry equi keys AND a  
        }
 *
 *       of 1 means no viable backend supports shuffle (or the cluster has only one node), in
        if (dist.getLocality() != OpenSearchDistribution.Locality.SHARD) return false;
     *  fired on it and the alternative is registered. Prevents a memo loop. */  
        this.distTraitDef = context.getDistributionTraitDef();
            context.getSettings(),
        RelTraitSet coordTraits = join.getTraitSet().replace(distTraitDef.coordSingleton());  
 * stays coordinator-centric.
        // The master MPP kill switch must be on. With MPP disabled cluster-wide, the join routes  
            && ld.getLocality() == OpenSearchDistribution.Locality.WORKER
 *       own output.</li>
            join.getJoinType(),
     *  exchange we'd insert and the underlying TableScan). The producer-side wiring for  
        for (int i = 0; i < rel.getTraitSet().size(); i++) {
    private final OpenSearchDistributionTraitDef distTraitDef;
            join.isSemiJoinDone()  
        // Hash-shuffle requires at least one EQUI key to define the partitioning expression — without
     *  underlying TableScan. Project / Filter are allowed (they run on the shard). Anything  
        );
import org.apache.calcite.plan.volcano.RelSubset;
        // filter after the equi-partition match. A PURE-theta join (no equi key) still bails here
    @Override
/*  
            return false;  
     *  pure shard-scan shape (no Aggregate, no Join, no other reducer between the shuffle
    @Override
    }  
        RelNode workerJoin = join.copy(  
        }
     *  above an {@code Aggregate(FINAL)} that itself sits above an {@code ExchangeReducer}, the
        // We hash-partition on info.leftKeys only; onMatch copies the FULL join condition (equi +
 * compatible open source license.
import org.opensearch.analytics.planner.PlannerContext;
        // Coord still needs the result; convert WORKER → COORDINATOR registers a final gather  
 * {@link OpenSearchJoinSplitRule}. Both fire on the same operand; this one emits a
        RelNode shuffledLeft = convert(join.getLeft(), leftTraits);
        for (RelNode input : rel.getInputs()) {
        }
    /** Walks the subtree to make sure no Aggregate / Join sits between this rel and its
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
import org.apache.calcite.plan.RelTrait;  
        // COORDINATOR_CENTRIC as appropriate.
    private static boolean isPureShardScanShape(RelNode rel) {
        if (rel instanceof OpenSearchJoin) return false;
        if (partitionCount <= 1) {  
    private static OpenSearchDistribution distributionOf(RelNode rel) {
        // OpenSearchJoinSplitRule. The advisor will route this query through BROADCAST or
        OpenSearchDistribution rd = distributionOf(join.getRight());
     *  coordinator-reduce stages. If a hash-shuffle plan tried to put a {@code ShuffleExchange}  
        if (rel instanceof RelSubset subset) {  
import org.apache.calcite.rel.RelNode;
    public OpenSearchHashJoinSplitRule(PlannerContext context) {
            && rd.getType() == RelDistribution.Type.HASH_DISTRIBUTED  
        OpenSearchDistribution joinHash = distTraitDef.hash(info.leftKeys, partitionCount);
        // Both inputs must be vanilla SHARD-distributed scans. Without this gate the rule fires  
    }
     *  builds the framework {@code ShuffleSender} only on shard-fragment dispatches, not on
        return null;  
     *  else (or no scan reachable) returns false. */
        }
        if (dist == null) return false;  
    /** True when this join already carries a WORKER+HASH trait — i.e. this rule has already
        this.context = context;  
import org.apache.calcite.rel.core.JoinInfo;
        OpenSearchDistribution leftHash = distTraitDef.hash(info.leftKeys, partitionCount);  
        return !rel.getInputs().isEmpty();
        RelTraitSet leftTraits = join.getLeft().getTraitSet().replace(leftHash);
        JoinInfo info = join.analyzeCondition();
        }
        OpenSearchDistribution ld = distributionOf(join.getLeft());  
 *       strategies; with MPP disabled this rule must stay out of CBO).</li>  
 * <p>Gates:  
    public void onMatch(RelOptRuleCall call) {  
            return false;
    }  
        OpenSearchDistribution dist = distributionOf(rel);
import org.opensearch.analytics.planner.rel.OpenSearchJoin;  
        }
        OpenSearchDistribution rightHash = distTraitDef.hash(info.rightKeys, partitionCount);
     *  hash-shuffle ({@link org.opensearch.analytics.exec.AnalyticsSearchService#startFragment})
        // residual) onto the worker join, so DataFusion's HashJoinExec applies the residual as a join  
 * alternative becomes a {@code OpenSearchShuffleExchange} the post-CBO distribution-enforcement pass
            if (trait instanceof OpenSearchDistribution dist) return dist;
import org.apache.calcite.plan.RelOptRuleCall;
        // keys as the join's own hash key marker (the cost gate validates each input's HASH
 *
 * @opensearch.internal  
        int partitionCount = MppShufflePartitions.resolve(  
    private final PlannerContext context;
 * <ul>
import org.apache.calcite.plan.RelTraitSet;
        if (joinDist.getType() != RelDistribution.Type.HASH_DISTRIBUTED) return false;
 * <p>The rule competes with {@link OpenSearchJoinSplitRule} via Volcano's cost model. The chosen
        OpenSearchJoin join = call.rel(0);
    }  
        return ld != null
            && ld.getType() == RelDistribution.Type.HASH_DISTRIBUTED  
import org.opensearch.analytics.exec.join.MppShufflePartitions;
            join.getCondition(),
import org.apache.calcite.plan.RelOptRule;
            && rd.getLocality() == OpenSearchDistribution.Locality.WORKER;
 * deliver matching {@code WORKER+HASH(keys, partitionCount)} traits. The result is a join
            if (!isPureShardScanShape(input)) return false;  
        JoinInfo info = join.analyzeCondition();  
            context.getCapabilityRegistry(),  
        // No backend opts in (or single-node cluster); leave the alternative space to  
        // OpenSearchShuffleExchange wraps a non-scan input, and DAGBuilder.cutShuffle's
            context.getClusterState(),
}
 * this file be licensed under the Apache-2.0 license or a
            RelTrait trait = rel.getTraitSet().getTrait(i);  
        // materializes an OpenSearchShuffleExchange on any input not already so distributed.
 * Hash-shuffle split rule for {@link OpenSearchJoin} (M2). Sibling of
        if (rel instanceof OpenSearchAggregate) return false;  
 * the trait converter.
import org.apache.calcite.rel.RelDistribution;  
package org.opensearch.analytics.planner.rules;
        // through OpenSearchJoinSplitRule's coord-centric path; this rule must stay out of that.
        if (joinAlreadyResolvedAsHash(join)) {  
/**  
            RelNode best = subset.getBestOrOriginal();
            shuffledRight,
        OpenSearchJoin join = call.rel(0);
        return isShardScan(join.getLeft()) && isShardScan(join.getRight());
 */  
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;
    }
 *
            joinTraits,
 *       which case BROADCAST or COORDINATOR_CENTRIC is the right strategy instead.</li>
 * ({@code DistributionEnforcementPass}) promotes into a worker tier; below the size floor the join  
        // (empty leftKeys) and routes coord-centric, since it can't be hash-partitioned.
            return isPureShardScanShape(best);  
        RelTraitSet joinTraits = join.getTraitSet().replace(joinHash);
 *  
        RelNode shuffledRight = convert(join.getRight(), rightTraits);
            && rd != null
    }
import org.opensearch.analytics.planner.rel.OpenSearchDistribution;
        // Demand a HASH partitioning on the per-side keys. Volcano's trait converter
 * that runs on data-node workers in parallel, with Volcano materializing
            if (best == null || best == rel) return false;
            return;
 *       theta joins flow through {@link OpenSearchJoinSplitRule}'s coordinator-centric path.</li>
        );
        OpenSearchDistribution joinDist = distributionOf(join);
 */
            join.getViableBackends()
 * {@link org.opensearch.analytics.planner.rel.OpenSearchShuffleExchange} on each input via  
