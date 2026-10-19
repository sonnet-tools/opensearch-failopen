 *       own output.</li>
    private final PlannerContext context;
            shuffledLeft,
 * HASH-localized alternative that {@code OpenSearchJoin}'s cost gate accepts when both inputs
        OpenSearchDistribution ld = distributionOf(join.getLeft());
        // COORDINATOR_CENTRIC as appropriate.
    private final OpenSearchDistributionTraitDef distTraitDef;
    }
            if (trait instanceof OpenSearchDistribution dist) return dist;
            join.getCondition(),
        return isShardScan(join.getLeft()) && isShardScan(join.getRight());
        if (joinDist == null) return false;
            && rd.getType() == RelDistribution.Type.HASH_DISTRIBUTED
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
    }
 * {@link org.opensearch.analytics.planner.rel.OpenSearchShuffleExchange} on each input via
            context.getCapabilityRegistry(),
 *
            joinTraits,
            if (best == null || best == rel) return false;
 * <p>The rule competes with {@link OpenSearchJoinSplitRule} via Volcano's cost model. The chosen
        // materializes an OpenSearchShuffleExchange on any input not already so distributed.
        if (rel instanceof RelSubset subset) {
 */
        RelTraitSet coordTraits = join.getTraitSet().replace(distTraitDef.coordSingleton());
        if (dist.getLocality() != OpenSearchDistribution.Locality.SHARD) return false;
        JoinInfo info = join.analyzeCondition();
        if (info.leftKeys.isEmpty()) {
    public void onMatch(RelOptRuleCall call) {
        // through OpenSearchJoinSplitRule's coord-centric path; this rule must stay out of that.
        RelTraitSet rightTraits = join.getRight().getTraitSet().replace(rightHash);
    }
 * that runs on data-node workers in parallel, with Volcano materializing
        // The master MPP kill switch must be on. With MPP disabled cluster-wide, the join routes
        // it, distTraitDef.hash() would receive an empty key list and produce a partitioning that
    public boolean matches(RelOptRuleCall call) {
    }
public class OpenSearchHashJoinSplitRule extends RelOptRule {
import org.opensearch.analytics.AnalyticsSettings;
        // ER above. The transformTo target carries WORKER traits; Volcano's enforcement will
    /** True when this join already carries a WORKER+HASH trait — i.e. this rule has already
            return isPureShardScanShape(best);
 *
            context.getSettings(),
            RelTrait trait = rel.getTraitSet().getTrait(i);
            return false;
        int partitionCount = MppShufflePartitions.resolve(
        OpenSearchDistribution rd = distributionOf(join.getRight());
 *   <li>{@code JoinInfo.isEqui()} must be true. Hash partitioning requires equality predicates;
    private static boolean isPureShardScanShape(RelNode rel) {
 *   <li>{@code analytics.mpp.enabled} must be true (the master kill switch covers all MPP
 *       strategies; with MPP disabled this rule must stay out of CBO).</li>
     *  above an {@code Aggregate(FINAL)} that itself sits above an {@code ExchangeReducer}, the
/**
 * ({@code DistributionEnforcementPass}) promotes into a worker tier; below the size floor the join
     *  pure shard-scan shape (no Aggregate, no Join, no other reducer between the shuffle
        if (joinDist.getType() != RelDistribution.Type.HASH_DISTRIBUTED) return false;
        if (rel instanceof OpenSearchTableScan) return true;
            join.getJoinType(),
    /** Walks the subtree to make sure no Aggregate / Join sits between this rel and its
        convert(workerJoin, coordTraits);
        for (int i = 0; i < rel.getTraitSet().size(); i++) {
            if (!isPureShardScanShape(input)) return false;
        OpenSearchDistribution dist = distributionOf(rel);
     *  hash-shuffle ({@link org.opensearch.analytics.exec.AnalyticsSearchService#startFragment})
 * {@link OpenSearchJoinSplitRule}. Both fire on the same operand; this one emits a
    private static boolean joinAlreadyResolvedAsHash(OpenSearchJoin join) {
        // We hash-partition on info.leftKeys only; onMatch copies the FULL join condition (equi +
 * </ul>
        this.distTraitDef = context.getDistributionTraitDef();
        if (rel instanceof OpenSearchAggregate) return false;
    }
            && ld.getType() == RelDistribution.Type.HASH_DISTRIBUTED
        call.transformTo(workerJoin);
        OpenSearchJoin join = call.rel(0);
            return false;
 * @opensearch.internal
import org.opensearch.analytics.exec.join.MppShufflePartitions;
import org.apache.calcite.rel.RelDistribution;
        }
        OpenSearchDistribution rightHash = distTraitDef.hash(info.rightKeys, partitionCount);
            RelNode best = subset.getBestOrOriginal();
        RelNode workerJoin = join.copy(
    }
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
import org.apache.calcite.plan.RelTraitSet;
     *  builds the framework {@code ShuffleSender} only on shard-fragment dispatches, not on
            return false;
 *       of 1 means no viable backend supports shuffle (or the cluster has only one node), in
            return;
        return isPureShardScanShape(rel);
    public OpenSearchHashJoinSplitRule(PlannerContext context) {
            context.getClusterState(),
        if (dist == null) return false;
import org.apache.calcite.plan.RelOptRule;
 *
        // keys as the join's own hash key marker (the cost gate validates each input's HASH
 * deliver matching {@code WORKER+HASH(keys, partitionCount)} traits. The result is a join
        }
        }
        for (RelNode input : rel.getInputs()) {
 * the trait converter.
        // No backend opts in (or single-node cluster); leave the alternative space to
    }
import org.apache.calcite.plan.RelOptRuleCall;
     *  fired on it and the alternative is registered. Prevents a memo loop. */
import org.opensearch.analytics.planner.PlannerContext;
        OpenSearchJoin join = call.rel(0);
            join.getViableBackends()
        // The hash-join itself runs at WORKER+HASH(leftKeys, N). Convention: use the left
import org.apache.calcite.rel.RelNode;
 * stays coordinator-centric.
 * <p>Gates:
        // filter after the equi-partition match. A PURE-theta join (no equi key) still bails here
     *  producer would be a coordinator-reduce stage with no partitioned-sink hookup — the
        // ShardTargetResolver can't find a TableScan and bails out.
 * compatible open source license.
        super(operand(OpenSearchJoin.class, any()), "OpenSearchHashJoinSplitRule");
import org.apache.calcite.rel.core.JoinInfo;
        }
        // Both inputs must be vanilla SHARD-distributed scans. Without this gate the rule fires
        // residual non-equi predicate (e.g. TPC-H q14: l_partkey=p_partkey AND l_shipdate BETWEEN …).
            && rd.getLocality() == OpenSearchDistribution.Locality.WORKER;
        RelNode shuffledLeft = convert(join.getLeft(), leftTraits);
import org.apache.calcite.plan.volcano.RelSubset;
 *       theta joins flow through {@link OpenSearchJoinSplitRule}'s coordinator-centric path.</li>
     *  worker waits forever on senders that never ship. */
    @Override
            && ld.getLocality() == OpenSearchDistribution.Locality.WORKER
}
        this.context = context;
            && rd != null
        return null;
     *  underlying TableScan. Project / Filter are allowed (they run on the shard). Anything
        OpenSearchDistribution leftHash = distTraitDef.hash(info.leftKeys, partitionCount);
        JoinInfo info = join.analyzeCondition();
        // (empty leftKeys) and routes coord-centric, since it can't be hash-partitioned.
        if (joinAlreadyResolvedAsHash(join)) {
        }
        if (joinDist.getLocality() != OpenSearchDistribution.Locality.WORKER) return false;
 * SPDX-License-Identifier: Apache-2.0
 *   <li>The resolved partition count (cluster setting → engine default) must be ≥ 2. A count
 * this file be licensed under the Apache-2.0 license or a
        );
        return !rel.getInputs().isEmpty();
        if (!AnalyticsSettings.MPP_ENABLED.get(context.getSettings())) {
        OpenSearchDistribution joinDist = distributionOf(join);
        RelTraitSet leftTraits = join.getLeft().getTraitSet().replace(leftHash);
        RelNode shuffledRight = convert(join.getRight(), rightTraits);
        // residual) onto the worker join, so DataFusion's HashJoinExec applies the residual as a join
        // Hash-shuffle requires at least one EQUI key to define the partitioning expression — without
    @Override
        // OpenSearchShuffleExchange wraps a non-scan input, and DAGBuilder.cutShuffle's
        if (rel instanceof OpenSearchJoin) return false;
/*
     *  else (or no scan reachable) returns false. */
            shuffledRight,
        }
        // OpenSearchJoinSplitRule. The advisor will route this query through BROADCAST or
package org.opensearch.analytics.planner.rules;
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
        // independently — it doesn't compare the join's keys to inputs').
     *  exchange we'd insert and the underlying TableScan). The producer-side wiring for
 * <ul>
     *  coordinator-reduce stages. If a hash-shuffle plan tried to put a {@code ShuffleExchange}
        // wrap with an ER when a SINGLETON consumer demands it.
 *   <li>{@code joinAlreadyResolvedAsHash(...)} must be false to avoid re-firing on the rule's
            join.isSemiJoinDone()
        RelTraitSet joinTraits = join.getTraitSet().replace(joinHash);
        // doesn't actually partition. We do NOT require info.isEqui(): a join may carry equi keys AND a
import org.apache.calcite.plan.RelTrait;
    private static boolean isShardScan(RelNode rel) {
        // on shapes like Join(Scan, Values) — Values has no shard distribution, so the resulting
        // Demand a HASH partitioning on the per-side keys. Volcano's trait converter
        // Coord still needs the result; convert WORKER → COORDINATOR registers a final gather
        }
    private static OpenSearchDistribution distributionOf(RelNode rel) {
        OpenSearchDistribution joinHash = distTraitDef.hash(info.leftKeys, partitionCount);
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;
 * Hash-shuffle split rule for {@link OpenSearchJoin} (M2). Sibling of
 */
 *       which case BROADCAST or COORDINATOR_CENTRIC is the right strategy instead.</li>
import org.opensearch.analytics.planner.rel.OpenSearchDistribution;
 * The OpenSearch Contributors require contributions made to
 *
        if (partitionCount <= 1) {
 * alternative becomes a {@code OpenSearchShuffleExchange} the post-CBO distribution-enforcement pass
    /** True when {@code rel}'s OpenSearchDistribution is SHARD-localized AND its subtree is a
        return ld != null
        );
