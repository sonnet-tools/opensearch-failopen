     *  not suppress itself or Volcano can't plan. */
            osRel.getViableBackends()  
    private boolean hashWillFire(OpenSearchJoin join) {
     *  and the underlying TableScan). Both broadcast and hash split rules require this:
        // and throws CannotPlanException.  
 */
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
        if (override != null && override > 0) {  
        }
    }  
        }
            if (dist.getType() != RelDistribution.Type.SINGLETON) return null;
 * {@link OpenSearchDistributionTraitDef#convert}.
        if (joinDist.getLocality() == OpenSearchDistribution.Locality.SHARD && joinDist.getType() == RelDistribution.Type.SINGLETON) {  
            if (commonId == null) commonId = tid;
        // Mirror the MPP rules' eligibility EXACTLY: they require at least one equi key (non-empty  
        // build side; broadcast emits zero alternatives)
        );
        Integer override = AnalyticsSettings.MPP_BROADCAST_PROBE_ESTIMATE.get(context.getSettings());
        OpenSearchJoin join = call.rel(0);
        Integer commonId = null;
import org.opensearch.analytics.AnalyticsSettings;  
    public OpenSearchJoinSplitRule(PlannerContext context) {
        }
        RelNode gatheredLeft = convert(join.getLeft(), coordTraits);  
        boolean leftAsBuild = jt == JoinRelType.INNER || jt == JoinRelType.RIGHT;
        // least one of broadcast or hash will actually fire.  
    @Override
        // shardCount can be null on synthetic subtrees; treat that as "not multi-shard" so
     *  replicate either side without breaking row-preservation semantics). */  
 * <ul>
        // setting override (positive) wins; otherwise data-node count.  
package org.opensearch.analytics.planner.rules;
        // broadcast bails on probeNodes <= 1, and hash bails on partitionCount <= 1 (a
     *  least one eligible build side. FULL OUTER has no eligible side (broadcast can't
        // Both MPP rules need multi-shard SHARD scans on both sides. Single-shard or non-  
        if (rel instanceof OpenSearchJoin) return false;
        OpenSearchJoin join = call.rel(0);
 */  
        // Single-node clusters (probeNodes=1) still get coord-centric for all equi joins:  
        OpenSearchDistribution dist = originalDistribution(rel);
import org.apache.calcite.rel.RelNode;  
        }
 * downstream operator (or the root) can insert a single gather ER above it.
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
        }
            return false;
        return isPureShardScanShape(rel);
 * compatible open source license.
                join.getLeft(),
    @Override
        // — e.g. TPC-H q14: l_partkey=p_partkey AND l_shipdate BETWEEN …). So coord suppresses itself
        }  
        }
            );
            OpenSearchDistribution dist = distributionOf(input);
import org.apache.calcite.rel.core.JoinInfo;
            if (!isPureShardScanShape(input)) return false;
import org.apache.calcite.rel.core.JoinRelType;
     *  (e.g. {@code stats by str0 | join …}), neither MPP rule fires, so coord-rule must
                join.getCondition(),  
     *  matches what {@link OpenSearchHashJoinSplitRule} and
        }
        }
        // viable, coord-rule suppression doesn't kick in.  
        // this join — otherwise Volcano has no plan to satisfy the root SINGLETON demand
        // one MPP rule (broadcast or hash) will actually produce a viable alternative for
            if (state == null || state.nodes() == null) {
    private final OpenSearchDistributionTraitDef distTraitDef;  
import org.apache.calcite.plan.RelOptRuleCall;
            RelNode best = subset.getBestOrOriginal();
        return leftAsBuild || rightAsBuild;
            convert(shardJoin, coordTraits);
        int probeNodes;
        // Mirror OpenSearchBroadcastJoinSplitRule.onMatch: at least one of left-as-build or
     *  fires so Volcano has a plan. */  
 * <p><b>General path.</b> Otherwise, request {@code COORDINATOR+SINGLETON} on each  
    /** Broadcast emits at least one alternative when probeNodes > 1 AND the join type has at
        boolean rightAsBuild = jt == JoinRelType.INNER || jt == JoinRelType.LEFT || jt == JoinRelType.SEMI || jt == JoinRelType.ANTI;  
 * strategy alternative — both inputs gather to the coordinator; the join runs there.
 * Coord-centric split rule for {@link OpenSearchJoin}. Produces the COORDINATOR_CENTRIC
import org.apache.calcite.rel.RelDistribution;
        // Concretely we suppress coord only if:
            RelNode best = subset.getBestOrOriginal();
 *  
        // impose; otherwise neither fires)
        if (!isMultiShard(dist)) return false;  
        // scan inputs (Values, Aggregate, Project(Aggregate(...))) make both rules dormant.
            if (best == null || best == rel) return false;  
 *       a viable alternative — meaning {@code probeNodes > 1} and the join type has an  
import org.opensearch.analytics.planner.PlannerContext;
        return commonId;
    }
    }
            Integer tid = dist.getTableId();  
        Integer shardCount = dist.getShardCount();  
            return false;  
        // - join is equi (theta is structurally ineligible for both MPP rules)
        for (int i = 0; i < rel.getTraitSet().size(); i++) {
            return true;
        RelNode gatheredRight = convert(join.getRight(), coordTraits);
        return false;  
            OpenSearchDistribution rd = distributionOf(join.getRight());
 *
        // Resolve partition count via the same helper OpenSearchHashJoinSplitRule uses.  
 * this file be licensed under the Apache-2.0 license or a
 *  
        }  
        if (probeNodes <= 1) {
    /** Walks the subtree to make sure no Aggregate / Join sits between this rel and its
        // Contract: this rule produces COORDINATOR_CENTRIC. Suppress it only when at least  
            context.getCapabilityRegistry(),
        this.distTraitDef = context.getDistributionTraitDef();
                probeNodes = Math.max(state.nodes().getDataNodes().size(), 1);
        if (dist.getLocality() != OpenSearchDistribution.Locality.SHARD) return false;
        this.context = context;
 *       is the only legal path.</li>
 * @opensearch.internal
            // COORDINATOR) so a parent demanding COORDINATOR sees a single gather ER above
        if (joinDist.getLocality() == OpenSearchDistribution.Locality.COORDINATOR && joinDist.getType() == RelDistribution.Type.SINGLETON) {
            if (best != rel) return originalDistribution(best);  
 * The OpenSearch Contributors require contributions made to  
            return false;  
        }
        if (!(join instanceof OpenSearchRelNode osRel)) {
     *  the input subtree is a "pure" shard scan shape (no Aggregate/Join between the input  
    public void onMatch(RelOptRuleCall call) {  
        // can't satisfy the root SINGLETON demand.
 *       coord-centric for all joins.</li>  
        if (info.leftKeys.isEmpty()) {  
    }  
            call.transformTo(shardJoin);
            return;  
import org.opensearch.analytics.planner.rel.OpenSearchDistribution;
import org.apache.calcite.plan.RelTrait;  
    private static Integer commonColocatedTableId(List<RelNode> inputs) {
 * the join runs at the shard node without any ER. Output preserves that trait so a  
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;  
    }  
            return isPureShardScanShape(best);
        return broadcastWillFire(join) || hashWillFire(join);
    private final PlannerContext context;
        call.transformTo(
        if (commonTableId != null) {
            return false;  
     *  underlying TableScan. Project / Filter are allowed (they run on the shard). */
        // single-node cluster's defaultShuffleParallelism is 1). With neither MPP rule
            if (tid == null) return null;
        return distributionOf(rel);
    }
        return isPureShardScanInput(join.getLeft()) && isPureShardScanInput(join.getRight());
}
        if (!bothInputsCouldBeMppShardScans(join)) {
        for (RelNode input : rel.getInputs()) {  
import org.apache.calcite.plan.RelOptRule;
        JoinInfo info = join.analyzeCondition();
        Integer commonTableId = commonColocatedTableId(List.of(join.getLeft(), join.getRight()));  
        if (!AnalyticsSettings.MPP_ENABLED.get(context.getSettings())) {
    private static boolean isPureShardScanShape(RelNode rel) {  
            if (dist.getLocality() != OpenSearchDistribution.Locality.SHARD) return null;  
        // eligible side; FULL has none.
            context.getClusterState(),
        // whenever there is ≥1 equi key (then a broadcast/hash alternative will be produced). With NO  
        if (rel instanceof org.apache.calcite.plan.volcano.RelSubset subset) {
     *  for this join. Coord rule suppresses itself only when this returns true; otherwise it
        }  
                && ld.getLocality() == OpenSearchDistribution.Locality.COORDINATOR  
 * side. Volcano materializes an ER on any non-{@code COORDINATOR+SINGLETON} input via
import org.apache.calcite.plan.RelTraitSet;
        }
        // leftKeys) but tolerate a residual non-equi predicate (they no longer require info.isEqui()
        // - AND at least one of broadcast/hash will fire and produce a non-empty alt:
            // the Join at SHARD with no ER on either input, then call convert(shardJoin,  
            org.opensearch.cluster.ClusterState state = context.getClusterState();  
            RelTrait trait = rel.getTraitSet().getTrait(i);
                probeNodes = 1;
import java.util.List;
    }
 *       inputs), coord-centric must still fire so Volcano has a plan to satisfy the root  
        int partitionCount = MppShufflePartitions.resolve(
                && ld.getType() == RelDistribution.Type.SINGLETON
        if (joinDist == null) return false;
        // - mpp.enabled=true (gate on broadcast + hash rules)  
        }
    private boolean shouldSuppressCoord(OpenSearchJoin join) {
/**  
    /** True iff at least one MPP rule (broadcast or hash) will produce a viable alternative
        JoinRelType jt = join.getJoinType();
     *  {@link OpenSearchBroadcastJoinSplitRule} actually require. */  
 *       SINGLETON demand.</li>
    private static boolean isPureShardScanInput(RelNode rel) {
        // hash: partitionCount > 1
            RelNode shardJoin = join.copy(
    private static boolean isMultiShard(OpenSearchDistribution dist) {  
 * SPDX-License-Identifier: Apache-2.0
        return null;
            RelTraitSet shardTraits = join.getTraitSet().replace(distTraitDef.shardSingleton(commonTableId, 1));  
     *  the producer-side wiring for shuffle and the build-side capture for broadcast both
        for (RelNode input : inputs) {  
    }
            probeNodes = override;
    }
                shardTraits,
        // right-as-build must be eligible. INNER, LEFT, RIGHT, SEMI, ANTI all have an  
        // Not co-located: one side originates from a different table or shard layout, so  
        return !rel.getInputs().isEmpty();  
        if (rel instanceof OpenSearchTableScan) return true;  
            return false;
        //
    }
/*  
            // Co-location applies: both sides are 1-shard scans of the same table. Build
    }
        if (!shouldSuppressCoord(join)) {
                join.getJoinType(),  
 *   <li>Equi joins with {@code analytics.mpp.enabled=false}: ALWAYS. The kill switch forces
 * </ul>
        return partitionCount > 1;
 * {@code shardCount=1} and the same {@code tableId} (self-join on a 1-shard table),
            } else {  
        return shardCount != null && shardCount > 1;  
                && rd != null
            context.getSettings(),  
 *  
 * <p><b>Co-location fast path.</b> When both sides are SHARD+SINGLETON scans with
    private boolean broadcastWillFire(OpenSearchJoin join) {
            if (trait instanceof OpenSearchDistribution dist) return dist;  
    }
 *   <li>Equi joins with {@code analytics.mpp.enabled=true}: only when neither MPP rule will
        // OK, the structural shape can support an MPP alternative. Now check whether at
 * <p><b>Firing contract</b> (from M2's strategy table):
                join.isSemiJoinDone()
        } else {
                && rd.getType() == RelDistribution.Type.SINGLETON;
            RelTraitSet coordTraits = join.getTraitSet().replace(distTraitDef.coordSingleton());  
        if (rel instanceof org.apache.calcite.plan.volcano.RelSubset subset) {
        // broadcast: probeNodes > 1 AND joinType not FULL OUTER (FULL has no eligible  
            return true;
    /** Combines the multi-shard distribution check with the pure-shard-scan-shape walk that
import org.opensearch.analytics.planner.rel.OpenSearchJoin;  
    /** True when both inputs originate from SHARD-distributed scans with shardCount > 1 AND
        OpenSearchDistribution joinDist = distributionOf(join);  
        if (joinAlreadyResolved(join)) return false;
            }
    private static OpenSearchDistribution distributionOf(RelNode rel) {  
    }  
        return false;
        super(operand(OpenSearchJoin.class, any()), "OpenSearchJoinSplitRule");  
 *       fire. Specifically, coord-centric SUPPRESSES itself iff broadcast OR hash would emit
        if (dist == null) return false;
                join.getRight(),
 *
            // (one transport instead of two).
 *       neither MPP rule can produce (single-node cluster, FULL OUTER equi join, single-shard
    }  
        RelTraitSet coordTraits = join.getTraitSet().replace(distTraitDef.coordSingleton());
        // - both inputs are multi-shard SHARD scans (the structural check both MPP rules  
 *   <li>Theta (non-equi) joins: ALWAYS. Theta has no broadcast or hash alternative; this rule  
        // equi key (pure theta / cross), neither MPP rule fires, so coord must stay enabled or Volcano
            else if (!commonId.equals(tid)) return null;  
            if (!Integer.valueOf(1).equals(dist.getShardCount())) return null;
        //
 *       eligible build side (broadcast), OR partition count {@literal > 1} (hash). When
        // Need viableBackends from the OpenSearchJoin to feed into the resolver.
        );
import org.opensearch.analytics.exec.join.MppShufflePartitions;
    private static boolean bothInputsCouldBeMppShardScans(OpenSearchJoin join) {  
public class OpenSearchJoinSplitRule extends RelOptRule {  
                && rd.getLocality() == OpenSearchDistribution.Locality.COORDINATOR  
    private static OpenSearchDistribution originalDistribution(RelNode rel) {  
        // we route through coord-centric rather than risking a CannotPlan.
            if (dist == null) return null;
     *  assume SHARD-fragment dispatch, not coordinator-reduce. If an input is post-aggregate  
        // per-side ERs are unavoidable. Demand COORDINATOR+SINGLETON on each side.
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;
        }
            join.copy(coordTraits, join.getCondition(), gatheredLeft, gatheredRight, join.getJoinType(), join.isSemiJoinDone())  
            OpenSearchDistribution ld = distributionOf(join.getLeft());  
            return ld != null
        if (rel instanceof OpenSearchAggregate) return false;
    /** Hash-shuffle emits an alternative when a viable backend reports a partition count > 1. */
    public boolean matches(RelOptRuleCall call) {  
        // Resolve probe-node estimate the same way OpenSearchBroadcastJoinSplitRule does:
    private static boolean joinAlreadyResolved(OpenSearchJoin join) {
