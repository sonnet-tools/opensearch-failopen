            RelNode shardJoin = join.copy(
        // Resolve partition count via the same helper OpenSearchHashJoinSplitRule uses.
                join.getJoinType(),
                join.getRight(),
            RelTrait trait = rel.getTraitSet().getTrait(i);
        }
    /** Broadcast emits at least one alternative when probeNodes > 1 AND the join type has at
     *  assume SHARD-fragment dispatch, not coordinator-reduce. If an input is post-aggregate
            if (best != rel) return originalDistribution(best);
            context.getClusterState(),
            call.transformTo(shardJoin);
            return false;
     *  (e.g. {@code stats by str0 | join …}), neither MPP rule fires, so coord-rule must
            }
 *
    public OpenSearchJoinSplitRule(PlannerContext context) {
    private static boolean isPureShardScanShape(RelNode rel) {
 * side. Volcano materializes an ER on any non-{@code COORDINATOR+SINGLETON} input via
        // - join is equi (theta is structurally ineligible for both MPP rules)
        }
    }
        }
import java.util.List;
            return false;
            context.getSettings(),
 * this file be licensed under the Apache-2.0 license or a
        if (rel instanceof org.apache.calcite.plan.volcano.RelSubset subset) {
            if (state == null || state.nodes() == null) {
     *  and the underlying TableScan). Both broadcast and hash split rules require this:
        //
    private static boolean isPureShardScanInput(RelNode rel) {
                probeNodes = 1;
        for (int i = 0; i < rel.getTraitSet().size(); i++) {
     *  the producer-side wiring for shuffle and the build-side capture for broadcast both
        // setting override (positive) wins; otherwise data-node count.
 *       fire. Specifically, coord-centric SUPPRESSES itself iff broadcast OR hash would emit
        Integer override = AnalyticsSettings.MPP_BROADCAST_PROBE_ESTIMATE.get(context.getSettings());
import org.apache.calcite.plan.RelOptRule;
 * <ul>
            } else {
        // per-side ERs are unavoidable. Demand COORDINATOR+SINGLETON on each side.
        if (dist == null) return false;
    private static Integer commonColocatedTableId(List<RelNode> inputs) {
        // Not co-located: one side originates from a different table or shard layout, so
        return !rel.getInputs().isEmpty();
     *  least one eligible build side. FULL OUTER has no eligible side (broadcast can't
            return;
        // Contract: this rule produces COORDINATOR_CENTRIC. Suppress it only when at least
        }
    private static boolean bothInputsCouldBeMppShardScans(OpenSearchJoin join) {
            osRel.getViableBackends()
        Integer commonId = null;
        JoinRelType jt = join.getJoinType();
        return false;
                && rd.getLocality() == OpenSearchDistribution.Locality.COORDINATOR
    }
        }
        if (info.leftKeys.isEmpty()) {
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;
 *       inputs), coord-centric must still fire so Volcano has a plan to satisfy the root
        }
            );
            if (!Integer.valueOf(1).equals(dist.getShardCount())) return null;
    private static OpenSearchDistribution distributionOf(RelNode rel) {
        if (!shouldSuppressCoord(join)) {
     *  replicate either side without breaking row-preservation semantics). */
            org.opensearch.cluster.ClusterState state = context.getClusterState();
 * <p><b>General path.</b> Otherwise, request {@code COORDINATOR+SINGLETON} on each
                join.isSemiJoinDone()
package org.opensearch.analytics.planner.rules;
        // leftKeys) but tolerate a residual non-equi predicate (they no longer require info.isEqui()
 *   <li>Theta (non-equi) joins: ALWAYS. Theta has no broadcast or hash alternative; this rule
        if (!AnalyticsSettings.MPP_ENABLED.get(context.getSettings())) {
 *       eligible build side (broadcast), OR partition count {@literal > 1} (hash). When
}
import org.apache.calcite.rel.core.JoinRelType;
    }
            join.copy(coordTraits, join.getCondition(), gatheredLeft, gatheredRight, join.getJoinType(), join.isSemiJoinDone())
            convert(shardJoin, coordTraits);
        // whenever there is ≥1 equi key (then a broadcast/hash alternative will be produced). With NO
                shardTraits,
        // one MPP rule (broadcast or hash) will actually produce a viable alternative for
 * downstream operator (or the root) can insert a single gather ER above it.
    }
            RelTraitSet shardTraits = join.getTraitSet().replace(distTraitDef.shardSingleton(commonTableId, 1));
            OpenSearchDistribution ld = distributionOf(join.getLeft());
        // broadcast: probeNodes > 1 AND joinType not FULL OUTER (FULL has no eligible
    /** True when both inputs originate from SHARD-distributed scans with shardCount > 1 AND
        }
        boolean rightAsBuild = jt == JoinRelType.INNER || jt == JoinRelType.LEFT || jt == JoinRelType.SEMI || jt == JoinRelType.ANTI;
            if (dist.getType() != RelDistribution.Type.SINGLETON) return null;
            if (dist.getLocality() != OpenSearchDistribution.Locality.SHARD) return null;
    }
        if (joinDist.getLocality() == OpenSearchDistribution.Locality.SHARD && joinDist.getType() == RelDistribution.Type.SINGLETON) {
            return false;
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
        if (!isMultiShard(dist)) return false;
        // eligible side; FULL has none.
 * The OpenSearch Contributors require contributions made to
            // COORDINATOR) so a parent demanding COORDINATOR sees a single gather ER above
import org.apache.calcite.rel.RelDistribution;
        OpenSearchDistribution dist = originalDistribution(rel);
    private boolean shouldSuppressCoord(OpenSearchJoin join) {
        return commonId;
        }
        // - both inputs are multi-shard SHARD scans (the structural check both MPP rules
            probeNodes = override;
                && rd.getType() == RelDistribution.Type.SINGLETON;
    }
        return null;
            context.getCapabilityRegistry(),
        if (rel instanceof OpenSearchJoin) return false;
        }
        // OK, the structural shape can support an MPP alternative. Now check whether at
    }
    }
        // Both MPP rules need multi-shard SHARD scans on both sides. Single-shard or non-
    }
 *       coord-centric for all joins.</li>
        this.distTraitDef = context.getDistributionTraitDef();
            return isPureShardScanShape(best);
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
        // single-node cluster's defaultShuffleParallelism is 1). With neither MPP rule
 * {@code shardCount=1} and the same {@code tableId} (self-join on a 1-shard table),
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
 * </ul>
        int probeNodes;
    @Override
    private static boolean isMultiShard(OpenSearchDistribution dist) {
        for (RelNode input : inputs) {
        return false;
import org.opensearch.analytics.planner.PlannerContext;
 * {@link OpenSearchDistributionTraitDef#convert}.
        if (commonTableId != null) {
        }
        call.transformTo(
        if (joinAlreadyResolved(join)) return false;
    /** Hash-shuffle emits an alternative when a viable backend reports a partition count > 1. */
    public boolean matches(RelOptRuleCall call) {
                probeNodes = Math.max(state.nodes().getDataNodes().size(), 1);
    }
    private boolean hashWillFire(OpenSearchJoin join) {
 *
        // equi key (pure theta / cross), neither MPP rule fires, so coord must stay enabled or Volcano
        // hash: partitionCount > 1
        // — e.g. TPC-H q14: l_partkey=p_partkey AND l_shipdate BETWEEN …). So coord suppresses itself
        RelNode gatheredRight = convert(join.getRight(), coordTraits);
            if (best == null || best == rel) return false;
 *       a viable alternative — meaning {@code probeNodes > 1} and the join type has an
        // can't satisfy the root SINGLETON demand.
                join.getCondition(),
import org.apache.calcite.plan.RelOptRuleCall;
        }
    /** Walks the subtree to make sure no Aggregate / Join sits between this rel and its
        if (joinDist == null) return false;
    private static boolean joinAlreadyResolved(OpenSearchJoin join) {
     *  the input subtree is a "pure" shard scan shape (no Aggregate/Join between the input
     *  fires so Volcano has a plan. */
        // right-as-build must be eligible. INNER, LEFT, RIGHT, SEMI, ANTI all have an
        this.context = context;
 * Coord-centric split rule for {@link OpenSearchJoin}. Produces the COORDINATOR_CENTRIC
     *  underlying TableScan. Project / Filter are allowed (they run on the shard). */
        // build side; broadcast emits zero alternatives)
        // we route through coord-centric rather than risking a CannotPlan.
        );
        if (joinDist.getLocality() == OpenSearchDistribution.Locality.COORDINATOR && joinDist.getType() == RelDistribution.Type.SINGLETON) {
 *       is the only legal path.</li>
            if (tid == null) return null;
/*
                && ld.getType() == RelDistribution.Type.SINGLETON
        if (probeNodes <= 1) {
     *  matches what {@link OpenSearchHashJoinSplitRule} and
        } else {
            // (one transport instead of two).
            return true;
public class OpenSearchJoinSplitRule extends RelOptRule {
            if (trait instanceof OpenSearchDistribution dist) return dist;
    }
        Integer commonTableId = commonColocatedTableId(List.of(join.getLeft(), join.getRight()));
 *   <li>Equi joins with {@code analytics.mpp.enabled=true}: only when neither MPP rule will
            if (dist == null) return null;
        }
        return broadcastWillFire(join) || hashWillFire(join);
    public void onMatch(RelOptRuleCall call) {
        // Mirror OpenSearchBroadcastJoinSplitRule.onMatch: at least one of left-as-build or
import org.opensearch.analytics.exec.join.MppShufflePartitions;
        return isPureShardScanInput(join.getLeft()) && isPureShardScanInput(join.getRight());
 */
 *
        RelTraitSet coordTraits = join.getTraitSet().replace(distTraitDef.coordSingleton());
 * SPDX-License-Identifier: Apache-2.0
        return distributionOf(rel);
 *       neither MPP rule can produce (single-node cluster, FULL OUTER equi join, single-shard
 * <p><b>Co-location fast path.</b> When both sides are SHARD+SINGLETON scans with
    private boolean broadcastWillFire(OpenSearchJoin join) {
 */
        // - AND at least one of broadcast/hash will fire and produce a non-empty alt:
            // Co-location applies: both sides are 1-shard scans of the same table. Build
     *  for this join. Coord rule suppresses itself only when this returns true; otherwise it
            Integer tid = dist.getTableId();
        if (!(join instanceof OpenSearchRelNode osRel)) {
        boolean leftAsBuild = jt == JoinRelType.INNER || jt == JoinRelType.RIGHT;
 * <p><b>Firing contract</b> (from M2's strategy table):
        // Single-node clusters (probeNodes=1) still get coord-centric for all equi joins:
        );
     *  not suppress itself or Volcano can't plan. */
        super(operand(OpenSearchJoin.class, any()), "OpenSearchJoinSplitRule");
            // the Join at SHARD with no ER on either input, then call convert(shardJoin,
 *
        return leftAsBuild || rightAsBuild;
        // Concretely we suppress coord only if:
 * compatible open source license.
            return true;
/**
                && rd != null
        // least one of broadcast or hash will actually fire.
                && ld.getLocality() == OpenSearchDistribution.Locality.COORDINATOR
        OpenSearchJoin join = call.rel(0);
        if (rel instanceof OpenSearchTableScan) return true;
        // this join — otherwise Volcano has no plan to satisfy the root SINGLETON demand
    /** Combines the multi-shard distribution check with the pure-shard-scan-shape walk that
 * the join runs at the shard node without any ER. Output preserves that trait so a
    private final OpenSearchDistributionTraitDef distTraitDef;
    }
    }
        // and throws CannotPlanException.
        //
    /** True iff at least one MPP rule (broadcast or hash) will produce a viable alternative
        }
        if (rel instanceof OpenSearchAggregate) return false;
    private static OpenSearchDistribution originalDistribution(RelNode rel) {
    @Override
            if (commonId == null) commonId = tid;
            return false;
        // Need viableBackends from the OpenSearchJoin to feed into the resolver.
        OpenSearchJoin join = call.rel(0);
        return shardCount != null && shardCount > 1;
        if (!bothInputsCouldBeMppShardScans(join)) {
        if (override != null && override > 0) {
        // Resolve probe-node estimate the same way OpenSearchBroadcastJoinSplitRule does:
 *   <li>Equi joins with {@code analytics.mpp.enabled=false}: ALWAYS. The kill switch forces
        // shardCount can be null on synthetic subtrees; treat that as "not multi-shard" so
        }
            return ld != null
        return isPureShardScanShape(rel);
 *       SINGLETON demand.</li>
        int partitionCount = MppShufflePartitions.resolve(
        // scan inputs (Values, Aggregate, Project(Aggregate(...))) make both rules dormant.
        if (dist.getLocality() != OpenSearchDistribution.Locality.SHARD) return false;
            OpenSearchDistribution dist = distributionOf(input);
 * strategy alternative — both inputs gather to the coordinator; the join runs there.
        OpenSearchDistribution joinDist = distributionOf(join);
import org.opensearch.analytics.planner.rel.OpenSearchDistribution;
        return partitionCount > 1;
import org.apache.calcite.plan.RelTrait;
            RelTraitSet coordTraits = join.getTraitSet().replace(distTraitDef.coordSingleton());
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
        // - mpp.enabled=true (gate on broadcast + hash rules)
        for (RelNode input : rel.getInputs()) {
import org.apache.calcite.plan.RelTraitSet;
            if (!isPureShardScanShape(input)) return false;
        JoinInfo info = join.analyzeCondition();
        // broadcast bails on probeNodes <= 1, and hash bails on partitionCount <= 1 (a
import org.apache.calcite.rel.core.JoinInfo;
     *  {@link OpenSearchBroadcastJoinSplitRule} actually require. */
        // impose; otherwise neither fires)
        }
            RelNode best = subset.getBestOrOriginal();
            return false;
            else if (!commonId.equals(tid)) return null;
    private final PlannerContext context;
    }
        RelNode gatheredLeft = convert(join.getLeft(), coordTraits);
        // Mirror the MPP rules' eligibility EXACTLY: they require at least one equi key (non-empty
                join.getLeft(),
        Integer shardCount = dist.getShardCount();
import org.apache.calcite.rel.RelNode;
 * @opensearch.internal
        // viable, coord-rule suppression doesn't kick in.
            RelNode best = subset.getBestOrOriginal();
        if (rel instanceof org.apache.calcite.plan.volcano.RelSubset subset) {
 *
import org.opensearch.analytics.AnalyticsSettings;
            OpenSearchDistribution rd = distributionOf(join.getRight());
