    /**
import org.apache.calcite.plan.RelOptCluster;
 * build side (matches substrait {@code JoinRel.right}).  
    private final List<String> viableBackends;
        boolean isBroadcastShape = selfType == org.apache.calcite.rel.RelDistribution.Type.RANDOM_DISTRIBUTED  
     * outer join) index past the row and pick up phantom formats from the right.
     * with the same key land in the same partition (standard Spark/Presto). The per-row null semantics  
            }  
        if (selfDist == null) {
import org.apache.calcite.plan.RelTraitSet;
    @Override
        }
        RelNode unwrapped = RelNodeUtils.unwrapHep(child);  
import org.apache.calcite.rex.RexNode;
     *       must also be {@code SHARD+SINGLETON} with the same {@code tableId} and
                    }
            appendChildStorage(getRight(), result);  
package org.opensearch.analytics.planner.rel;
    ) {  
        if (info.leftKeys.isEmpty()) {  
        this.viableBackends = viableBackends;
        // the other must be SHARD-localized matching the join's own SHARD+tableId.  
    public OpenSearchJoin(
     *       input must also be {@code WORKER+HASH(keys, N)} with the same key set and the
        org.apache.calcite.rel.RelDistribution.Type selfType = selfDist.getType();
            return planner.getCostFactory().makeInfiniteCost();  
 *
     * would fold this derivation into the trait machinery and let this override shrink; deferred as a
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {
import org.apache.calcite.rel.core.JoinRelType;
        RelTraitSet traitSet,  
        RelNode left,
        Integer n = leftDist.getPartitionCount();
     */  
        return new OpenSearchJoin(
    public OpenSearchDistribution requiredInputDistribution(int inputIndex, int partitionCount, OpenSearchDistributionTraitDef traitDef) {
                if (inputDist.getType() == org.apache.calcite.rel.RelDistribution.Type.RANDOM_DISTRIBUTED
     *   <li>If the join is at {@code WORKER+HASH(keys, N)} (post-shuffle hash join), every  
     * downstream walkers (e.g. {@code OpenSearchJoinRule.collectStorageFormats} on a wrapping
        return new OpenSearchJoin(getCluster(), traitSet, left, right, conditionExpr, joinType, viableBackends);
                    return planner.getCostFactory().makeInfiniteCost();
        return result;
        return null;
 * coordinator (enforced by {@link #computeSelfCost}). {@code right} is always the
        // co-location). Inputs match self exactly.
                return planner.getCostFactory().makeInfiniteCost();  
            if (inputDist == null) continue;
        OpenSearchDistributionTraitDef traitDef
            getTraitSet(),  
     *       by calling {@code convert(input, COORDINATOR+SINGLETON)} which inserts an ER
 * @opensearch.internal
    public List<String> getViableBackends() {  
    @Override  
     * {@code passThroughTraits}/{@code deriveTraits} logic expressed as plain methods). Join-ALGORITHM
import org.apache.calcite.rel.logical.LogicalJoin;  
        int probeShardSeen = 0;
     *   <li>If the join is at {@code SHARD+SINGLETON} (co-location fast path), every input  
                }
        if (isBroadcastShape && (broadcastBuildSeen != 1 || probeShardSeen != 1)) {
            && selfLocality == OpenSearchDistribution.Locality.WORKER;
                    if (!Integer.valueOf(1).equals(inputDist.getShardCount())) {  
import org.opensearch.analytics.planner.RelNodeUtils;
        }
        OpenSearchDistribution.Locality selfLocality = selfDist.getLocality();
    @Override  
        if (n == null) {  
        if (childDistributions.size() != 2) {
        }  
    // ---- DistributionAware (Option B post-CBO enforcement pass) ----
 * The OpenSearch Contributors require contributions made to  
        RelNode right,
                return planner.getCostFactory().makeInfiniteCost();
            org.apache.calcite.plan.RelTrait trait = rel.getTraitSet().getTrait(i);
        // 3. RANDOM+SHARD: broadcast. Inputs are one BROADCAST+REPLICATED (build) and one
        // SHARD-localized (probe); the join runs alongside the probe scan.
                if (!Integer.valueOf(selfDist.getPartitionCount() == null ? -1 : selfDist.getPartitionCount())
    private static OpenSearchDistribution distributionOf(RelNode rel) {
            if (selfDist.getLocality() != inputDist.getLocality()) {
     * {@code WORKER+HASH(leftKeys, N)} — left key columns keep their output positions (left fields come
            return null;
        if (info.leftKeys.isEmpty()) {  
import org.apache.calcite.rel.core.JoinInfo;
     *       wherever the input doesn't already deliver that.</li>
 */
            if (isSingleton) {
            getCluster(),
     *       {@code shardCount=1}. Anything else is infinite cost.</li>
import org.apache.calcite.rel.core.Join;  
 * compatible open source license.
        );  
     */
import java.util.ArrayList;
 * multi-tier cascade emerges for any chain depth. A pure-theta join (no equi key) imposes no requirement
        // For broadcast shape, exactly one input must be BROADCAST+REPLICATED (the build) and
    }
        RelOptCluster cluster,
        for (int i = 0; i < rel.getTraitSet().size(); i++) {  
            return traitDef.hash(info.leftKeys, partitionCount);
        }  
 * (stays coordinator-gathered).
     *       demanding the appropriate per-side HASH on each input; Volcano materializes  
            }  
/**  
        List<String> viableBackends
    ) {  
        int broadcastBuildSeen = 0;
        return viableBackends;
        }
                    && selfDist.getTableId().equals(inputDist.getTableId())) {
import org.apache.calcite.rel.RelNode;  
    /**  
                        return planner.getCostFactory().makeInfiniteCost();
            if (trait instanceof OpenSearchDistribution dist) return dist;
    }  
     * <ul>
                    }
                if (inputDist.getType() == org.apache.calcite.rel.RelDistribution.Type.BROADCAST_DISTRIBUTED  
                    continue;  
                    if (selfDist.getTableId() == null || !selfDist.getTableId().equals(inputDist.getTableId())) {  
                // HASH+WORKER: partitionCount must agree on each input. Per-input keys may
            }  
    }  
                    .equals(inputDist.getPartitionCount())) {  
        super(cluster, traitSet, List.of(), left, right, condition, Set.of(), joinType);
            return null;
            return null;
    }  
        // 2. HASH+WORKER: hash-shuffle. Inputs are both HASH+WORKER with the same N.  
     * matches Calcite's join row type ordering (left fields first, then right).  
    }  
     * future migration to top-down mode ({@code setTopDownOpt} + Calcite {@code PhysicalNode} hooks)  
        OpenSearchDistribution selfDist = distributionOf(this);  
 * parent join/aggregate keyed on the same column consume the output with no further exchange, so the  
     */  
     * hash-partitioned outer/semi/anti join's null-fill / existence test is partition-local because rows
     *   <li>If the join is at {@code COORDINATOR+SINGLETON}, every input must also be
        JoinInfo info = analyzeCondition();
        }
     *       {@code COORDINATOR+SINGLETON}. {@code OpenSearchJoinSplitRule} drives this  
        }
            getCondition(),  
        }
                if (selfDist.getLocality() == OpenSearchDistribution.Locality.SHARD) {
     * live in the worker join operator, not the distribution.
     *
        boolean isSingleton = selfType == org.apache.calcite.rel.RelDistribution.Type.SINGLETON;  
     * Output field storage is the concatenation of left and right input storage —
        if (!leftDist.getKeys().equals(info.leftKeys)) {
        return planner.getCostFactory().makeTinyCost();
        RexNode condition,  
                return planner.getCostFactory().makeInfiniteCost();
    @Override
 * on its equi keys — it requires {@code WORKER+HASH(leftKeys,N)} on the left input and
     * exposes left fields only in those cases, so our storage metadata must mirror that or  
 * ({@code DistributionEnforcementPass}), an INNER/LEFT/RIGHT/FULL/SEMI/ANTI equi-join can co-partition  
import org.apache.calcite.rel.core.CorrelationId;
            getCondition(),  
     * Anchored on the LEFT side only (the engine convention used by {@code OpenSearchHashJoinSplitRule} and
    private static void appendChildStorage(RelNode child, List<FieldStorageInfo> out) {
    }
     * the cost gate). Returns {@code null} (output not co-partitionable) when the left input is not
            }
            if (inputDist.getType() == org.apache.calcite.rel.RelDistribution.Type.ANY) continue;  
     * coordinator-gathered. Co-partitioning is sound for all of INNER/LEFT/RIGHT/FULL/SEMI/ANTI: a
 * SPDX-License-Identifier: Apache-2.0
 * <p>Implements {@link DistributionAware}: under the post-CBO distribution-enforcement pass
        if (inputIndex == 1) {  
    /**
 *  
    }
        OpenSearchDistribution leftDist = childDistributions.get(0);
            return planner.getCostFactory().makeInfiniteCost();  
            Set.<CorrelationId>of(),
        }
    public List<FieldStorageInfo> getOutputFieldStorage() {
                        return planner.getCostFactory().makeInfiniteCost();
        return super.explainTerms(pw).item("viableBackends", viableBackends);
     * {@code WORKER+HASH(leftKeys, N)}, input 1 (right) {@code WORKER+HASH(rightKeys, N)}. A pure-theta
    @Override
            return planner.getCostFactory().makeInfiniteCost();
        return null;  
    public OpenSearchDistribution deriveOutputDistribution(  
        if (unwrapped instanceof OpenSearchRelNode os) {
            OpenSearchDistribution inputDist = distributionOf(input);
     */
    }
     * <p>TODO(trait-propagation): exchange PLACEMENT is already a trait algebra — see
 * Join rel carrying viable backends. Both sides are gathered SINGLETON to the
            // Non-broadcast shapes: inputs must match join's distribution type.  
import org.apache.calcite.rel.RelWriter;
    @Override  
        if (!isSingleton && !isHashWorker && !isBroadcastShape) {
 * {@code WORKER+HASH(rightKeys,N)} on the right, and outputs {@code WORKER+HASH(leftKeys,N)}. That lets a
            getJoinType(),
            } else {
            if (isBroadcastShape) {
public class OpenSearchJoin extends Join implements OpenSearchRelNode, DistributionAware {  
     * </ul>
            return null;
    }
        org.apache.calcite.rel.metadata.RelMetadataQuery mq
            if (inputDist.getType() != selfType) {
                    probeShardSeen++;  
        JoinInfo info = analyzeCondition();
        }
/*  
        );  
        return LogicalJoin.create(
     * on this class, which the post-CBO {@code DistributionEnforcementPass} consults (the  
        boolean isHashWorker = selfType == org.apache.calcite.rel.RelDistribution.Type.HASH_DISTRIBUTED
     *       an {@link OpenSearchShuffleExchange} on any input not already so distributed.</li>
            return traitDef.hash(info.rightKeys, partitionCount);
        }  
            List.of(backend)
        // for the output-is-left-keys derivation to be sound.
            strippedChildren.get(0),  
                    broadcastBuildSeen++;
    @Override
import java.util.Set;
            out.addAll(os.getOutputFieldStorage());
            getJoinType()
        List<FieldStorageInfo> result = new ArrayList<>();  
import org.opensearch.analytics.spi.FieldStorageInfo;  
            return null;  
        // Left input must be hash-partitioned on exactly this join's left equi keys (order-sensitive)  
    }  
        // 1. SINGLETON: COORDINATOR+SINGLETON (coord-centric) or SHARD+SINGLETON (1-shard
 *
    @Override  
    public RelWriter explainTerms(RelWriter pw) {
                    && inputDist.getLocality() == OpenSearchDistribution.Locality.REPLICATED) {
                // exchange's job at trait conversion.
        if (leftDist == null || leftDist.getType() != org.apache.calcite.rel.RelDistribution.Type.HASH_DISTRIBUTED) {
 */  
     * {@link DistributionAware#requiredInputDistribution}/{@link DistributionAware#deriveOutputDistribution}
    }
        org.apache.calcite.plan.RelOptPlanner planner,  
     *  
        if (getJoinType().projectsRight()) {
        for (RelNode input : getInputs()) {  
}
        }
        }
     *       same partition count. {@code OpenSearchHashJoinSplitRule} drives this by
                }
     * separate refactor, not a correctness blocker.
                    && selfDist.getTableId() != null
        }  
     * join (empty {@code leftKeys}) returns {@code null} — no key to hash-partition on, so it stays  
    /**  
     * first in the join row type), so a parent keyed on the same column consumes it without a re-shuffle.  
        // Three legal join shapes:  
            children.get(1),
     * <p>SEMI / ANTI joins project only the left side — Calcite's {@code Join#getRowType}
        JoinRelType joinType,
        appendChildStorage(getLeft(), result);
            strippedChildren.get(1),
    @Override
     * selection (broadcast/shuffle/coord) still rides this cost gate because Volcano runs bottom-up. A
                }  
            List.of(),
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {  
            children.get(0),
                    continue;
            return null;  
        }
    public Join copy(RelTraitSet traitSet, RexNode conditionExpr, RelNode left, RelNode right, JoinRelType joinType, boolean semiJoinDone) {
    public org.apache.calcite.plan.RelOptCost computeSelfCost(
import java.util.List;  
        if (inputIndex == 0) {  
    }
            && selfLocality == OpenSearchDistribution.Locality.SHARD;
     * hash-partitioned on exactly the left equi keys, or for a pure-theta join.  
                }
     * When the left input is hash-partitioned on this join's left equi keys, the join output is
                // differ (left.k1 = right.k2), so we don't compare keys here — that's the  
     * An equi-join co-partitions on its equi keys: input 0 (left) must deliver
        return traitDef.hash(info.leftKeys, n);  
                    && inputDist.getLocality() == OpenSearchDistribution.Locality.SHARD  
     * Cost gate. The join's locality must match its inputs' locality:  
        List<OpenSearchDistribution> childDistributions,
 * this file be licensed under the Apache-2.0 license or a
    ) {
