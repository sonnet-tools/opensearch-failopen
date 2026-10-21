     * matches Calcite's join row type ordering (left fields first, then right).
    public OpenSearchJoin(
        if (info.leftKeys.isEmpty()) {
        return new OpenSearchJoin(getCluster(), traitSet, left, right, conditionExpr, joinType, viableBackends);
        for (RelNode input : getInputs()) {
            List.of(backend)
 * Join rel carrying viable backends. Both sides are gathered SINGLETON to the
                    continue;
            } else {
                if (inputDist.getType() == org.apache.calcite.rel.RelDistribution.Type.BROADCAST_DISTRIBUTED
        appendChildStorage(getLeft(), result);
    public RelWriter explainTerms(RelWriter pw) {
     * When the left input is hash-partitioned on this join's left equi keys, the join output is
     * An equi-join co-partitions on its equi keys: input 0 (left) must deliver
     *       an {@link OpenSearchShuffleExchange} on any input not already so distributed.</li>
            if (trait instanceof OpenSearchDistribution dist) return dist;
    // ---- DistributionAware (Option B post-CBO enforcement pass) ----
                    broadcastBuildSeen++;
        RelTraitSet traitSet,
            List.of(),
    }
            if (inputDist == null) continue;
        return null;
                    && inputDist.getLocality() == OpenSearchDistribution.Locality.REPLICATED) {
 * build side (matches substrait {@code JoinRel.right}).
    public OpenSearchDistribution deriveOutputDistribution(
    @Override
     *   <li>If the join is at {@code WORKER+HASH(keys, N)} (post-shuffle hash join), every
        if (!isSingleton && !isHashWorker && !isBroadcastShape) {
                return planner.getCostFactory().makeInfiniteCost();
        org.apache.calcite.rel.metadata.RelMetadataQuery mq
                if (!Integer.valueOf(selfDist.getPartitionCount() == null ? -1 : selfDist.getPartitionCount())
    }
                    && inputDist.getLocality() == OpenSearchDistribution.Locality.SHARD
    private static OpenSearchDistribution distributionOf(RelNode rel) {
 */
    private static void appendChildStorage(RelNode child, List<FieldStorageInfo> out) {
        );
    @Override
        int broadcastBuildSeen = 0;
        if (n == null) {
    /**
        return LogicalJoin.create(
        if (unwrapped instanceof OpenSearchRelNode os) {
        if (inputIndex == 1) {
        RelNode left,
/**
     * selection (broadcast/shuffle/coord) still rides this cost gate because Volcano runs bottom-up. A
        // 3. RANDOM+SHARD: broadcast. Inputs are one BROADCAST+REPLICATED (build) and one
     */
        return null;
    public List<FieldStorageInfo> getOutputFieldStorage() {
        }
     * {@link DistributionAware#requiredInputDistribution}/{@link DistributionAware#deriveOutputDistribution}
        }
     * hash-partitioned on exactly the left equi keys, or for a pure-theta join.
import java.util.List;
    @Override
    }
        boolean isSingleton = selfType == org.apache.calcite.rel.RelDistribution.Type.SINGLETON;
        }
        if (getJoinType().projectsRight()) {
        OpenSearchDistribution.Locality selfLocality = selfDist.getLocality();
        }
     *       wherever the input doesn't already deliver that.</li>
        // Left input must be hash-partitioned on exactly this join's left equi keys (order-sensitive)
     *   <li>If the join is at {@code SHARD+SINGLETON} (co-location fast path), every input
                    if (selfDist.getTableId() == null || !selfDist.getTableId().equals(inputDist.getTableId())) {
 * coordinator (enforced by {@link #computeSelfCost}). {@code right} is always the
                }
            return null;
            return planner.getCostFactory().makeInfiniteCost();
    public RelNode stripAnnotations(List<RelNode> strippedChildren) {
     * join (empty {@code leftKeys}) returns {@code null} — no key to hash-partition on, so it stays
     * live in the worker join operator, not the distribution.
                return planner.getCostFactory().makeInfiniteCost();
        JoinInfo info = analyzeCondition();
     *   <li>If the join is at {@code COORDINATOR+SINGLETON}, every input must also be
    public Join copy(RelTraitSet traitSet, RexNode conditionExpr, RelNode left, RelNode right, JoinRelType joinType, boolean semiJoinDone) {
        JoinRelType joinType,
 * ({@code DistributionEnforcementPass}), an INNER/LEFT/RIGHT/FULL/SEMI/ANTI equi-join can co-partition
            return null;
            return planner.getCostFactory().makeInfiniteCost();
            if (isBroadcastShape) {
            children.get(1),
    }
                // exchange's job at trait conversion.
     *       by calling {@code convert(input, COORDINATOR+SINGLETON)} which inserts an ER
import java.util.ArrayList;
 * {@code WORKER+HASH(rightKeys,N)} on the right, and outputs {@code WORKER+HASH(leftKeys,N)}. That lets a
        if (isBroadcastShape && (broadcastBuildSeen != 1 || probeShardSeen != 1)) {
            OpenSearchDistribution inputDist = distributionOf(input);
                    }
import org.apache.calcite.plan.RelTraitSet;
    /**
    ) {
            strippedChildren.get(1),
     * {@code passThroughTraits}/{@code deriveTraits} logic expressed as plain methods). Join-ALGORITHM
     *       {@code COORDINATOR+SINGLETON}. {@code OpenSearchJoinSplitRule} drives this
public class OpenSearchJoin extends Join implements OpenSearchRelNode, DistributionAware {
 * The OpenSearch Contributors require contributions made to
 */
        }
    public OpenSearchDistribution requiredInputDistribution(int inputIndex, int partitionCount, OpenSearchDistributionTraitDef traitDef) {
import java.util.Set;
    ) {
     * </ul>
            && selfLocality == OpenSearchDistribution.Locality.SHARD;
        return viableBackends;
            Set.<CorrelationId>of(),
            getTraitSet(),
        if (inputIndex == 0) {
    public RelNode copyResolved(String backend, List<RelNode> children, List<OperatorAnnotation> resolvedAnnotations) {
    ) {
 * on its equi keys — it requires {@code WORKER+HASH(leftKeys,N)} on the left input and
                }
        OpenSearchDistributionTraitDef traitDef
        List<FieldStorageInfo> result = new ArrayList<>();
        boolean isHashWorker = selfType == org.apache.calcite.rel.RelDistribution.Type.HASH_DISTRIBUTED
            strippedChildren.get(0),
import org.apache.calcite.rel.core.CorrelationId;
import org.apache.calcite.rel.RelNode;
     * with the same key land in the same partition (standard Spark/Presto). The per-row null semantics
                    continue;
        RelOptCluster cluster,
import org.apache.calcite.rel.core.Join;
        }
    }
import org.apache.calcite.rex.RexNode;
            }
     */
        }
 *
        org.apache.calcite.plan.RelOptPlanner planner,
                }
            if (isSingleton) {
        List<OpenSearchDistribution> childDistributions,
     * future migration to top-down mode ({@code setTopDownOpt} + Calcite {@code PhysicalNode} hooks)
     *       must also be {@code SHARD+SINGLETON} with the same {@code tableId} and
                    }
        RelNode unwrapped = RelNodeUtils.unwrapHep(child);
     * would fold this derivation into the trait machinery and let this override shrink; deferred as a
            org.apache.calcite.plan.RelTrait trait = rel.getTraitSet().getTrait(i);
        return traitDef.hash(info.leftKeys, n);
            if (inputDist.getType() != selfType) {
    }
                    return planner.getCostFactory().makeInfiniteCost();
     *
     * <p>SEMI / ANTI joins project only the left side — Calcite's {@code Join#getRowType}
            return null;
                return planner.getCostFactory().makeInfiniteCost();
     * coordinator-gathered. Co-partitioning is sound for all of INNER/LEFT/RIGHT/FULL/SEMI/ANTI: a
            if (inputDist.getType() == org.apache.calcite.rel.RelDistribution.Type.ANY) continue;
        if (selfDist == null) {
        }
        OpenSearchDistribution selfDist = distributionOf(this);
            return traitDef.hash(info.rightKeys, partitionCount);
            }
                // HASH+WORKER: partitionCount must agree on each input. Per-input keys may
        List<String> viableBackends
 * (stays coordinator-gathered).
    public org.apache.calcite.plan.RelOptCost computeSelfCost(
package org.opensearch.analytics.planner.rel;
     *       same partition count. {@code OpenSearchHashJoinSplitRule} drives this by
        }
        return new OpenSearchJoin(
            return traitDef.hash(info.leftKeys, partitionCount);
     * the cost gate). Returns {@code null} (output not co-partitionable) when the left input is not
    /**
     * on this class, which the post-CBO {@code DistributionEnforcementPass} consults (the
     * <ul>
 * multi-tier cascade emerges for any chain depth. A pure-theta join (no equi key) imposes no requirement
}
import org.opensearch.analytics.spi.FieldStorageInfo;
        }
import org.opensearch.analytics.planner.RelNodeUtils;
     * outer join) index past the row and pick up phantom formats from the right.
        return super.explainTerms(pw).item("viableBackends", viableBackends);
    @Override
                        return planner.getCostFactory().makeInfiniteCost();
    @Override
 * this file be licensed under the Apache-2.0 license or a
            return null;
                    if (!Integer.valueOf(1).equals(inputDist.getShardCount())) {
        RelNode right,
            if (selfDist.getLocality() != inputDist.getLocality()) {
 * @opensearch.internal
        if (!leftDist.getKeys().equals(info.leftKeys)) {
                }
                if (inputDist.getType() == org.apache.calcite.rel.RelDistribution.Type.RANDOM_DISTRIBUTED
        }
        Integer n = leftDist.getPartitionCount();
                if (selfDist.getLocality() == OpenSearchDistribution.Locality.SHARD) {
                    probeShardSeen++;
            return null;
            getCluster(),
        }
     *       input must also be {@code WORKER+HASH(keys, N)} with the same key set and the
        return planner.getCostFactory().makeTinyCost();
     * first in the join row type), so a parent keyed on the same column consumes it without a re-shuffle.
import org.apache.calcite.rel.RelWriter;
                    && selfDist.getTableId() != null
     * {@code WORKER+HASH(leftKeys, N)} — left key columns keep their output positions (left fields come
                    && selfDist.getTableId().equals(inputDist.getTableId())) {
    }
            getCondition(),
/*
            getJoinType()
            out.addAll(os.getOutputFieldStorage());
 *
        }
 * <p>Implements {@link DistributionAware}: under the post-CBO distribution-enforcement pass
            && selfLocality == OpenSearchDistribution.Locality.WORKER;
    }
        if (childDistributions.size() != 2) {
     * Output field storage is the concatenation of left and right input storage —
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.rel.core.JoinInfo;
     * separate refactor, not a correctness blocker.
 * parent join/aggregate keyed on the same column consume the output with no further exchange, so the
    }
        if (info.leftKeys.isEmpty()) {
            // Non-broadcast shapes: inputs must match join's distribution type.
            }
     * <p>TODO(trait-propagation): exchange PLACEMENT is already a trait algebra — see
        OpenSearchDistribution leftDist = childDistributions.get(0);
            getCondition(),
        boolean isBroadcastShape = selfType == org.apache.calcite.rel.RelDistribution.Type.RANDOM_DISTRIBUTED
                        return planner.getCostFactory().makeInfiniteCost();
    }
        );
    private final List<String> viableBackends;
        // co-location). Inputs match self exactly.
            return planner.getCostFactory().makeInfiniteCost();
        for (int i = 0; i < rel.getTraitSet().size(); i++) {
            }
     *       demanding the appropriate per-side HASH on each input; Volcano materializes
        // for the output-is-left-keys derivation to be sound.
                    .equals(inputDist.getPartitionCount())) {
        }
        // the other must be SHARD-localized matching the join's own SHARD+tableId.
    @Override
        // Three legal join shapes:
        org.apache.calcite.rel.RelDistribution.Type selfType = selfDist.getType();
     * exposes left fields only in those cases, so our storage metadata must mirror that or
        RexNode condition,
        if (leftDist == null || leftDist.getType() != org.apache.calcite.rel.RelDistribution.Type.HASH_DISTRIBUTED) {
        // 1. SINGLETON: COORDINATOR+SINGLETON (coord-centric) or SHARD+SINGLETON (1-shard
 * compatible open source license.
     * Cost gate. The join's locality must match its inputs' locality:
    /**
    public List<String> getViableBackends() {
    }
import org.apache.calcite.rel.core.JoinRelType;
import org.apache.calcite.rel.logical.LogicalJoin;
 *
    @Override
     *
     */
    @Override
            return null;
    }
     *       {@code shardCount=1}. Anything else is infinite cost.</li>
        JoinInfo info = analyzeCondition();
     */
            children.get(0),
        int probeShardSeen = 0;
        return result;
     * {@code WORKER+HASH(leftKeys, N)}, input 1 (right) {@code WORKER+HASH(rightKeys, N)}. A pure-theta
        super(cluster, traitSet, List.of(), left, right, condition, Set.of(), joinType);
            appendChildStorage(getRight(), result);
     * downstream walkers (e.g. {@code OpenSearchJoinRule.collectStorageFormats} on a wrapping
            getJoinType(),
    @Override
        // 2. HASH+WORKER: hash-shuffle. Inputs are both HASH+WORKER with the same N.
     * hash-partitioned outer/semi/anti join's null-fill / existence test is partition-local because rows
import org.apache.calcite.plan.RelOptCluster;
        }
     * Anchored on the LEFT side only (the engine convention used by {@code OpenSearchHashJoinSplitRule} and
        // For broadcast shape, exactly one input must be BROADCAST+REPLICATED (the build) and
                // differ (left.k1 = right.k2), so we don't compare keys here — that's the
        // SHARD-localized (probe); the join runs alongside the probe scan.
        this.viableBackends = viableBackends;
