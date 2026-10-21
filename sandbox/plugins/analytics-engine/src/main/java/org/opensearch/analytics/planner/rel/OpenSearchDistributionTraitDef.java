    }
        if (fromTrait != null && fromTrait.satisfies(toTrait)) {
import org.apache.calcite.plan.RelTraitDef;
        List<String> viableBackends = resolveViableBackendsFromRel(rel);
     * </ul>
     * <ul>
    /**
        }
            rel,
/*
/**
     *   <li>{@link OpenSearchConvention#enforce} (top-down): returns it for the planner to register.</li>
     * use {@link #hash(List, int)} with a concrete count.
    /**
     * UNCONDITIONALLY (no {@code satisfies()} short-circuit). The distribution enforcement pass (Option B)
        return new OpenSearchDistribution(this, null, RelDistribution.Type.SINGLETON, List.of(), null, null, null);
            null,
     * as "no exchange needed"), and never returns {@code null} today (an unenforceable demand throws).
    }
     * @param probeNodeEstimate replica count (= probe-side data-node estimate); carried verbatim from the
        // DataTransferCapability(PRODUCER) can do. Prune scan-only backends (e.g. Lucene, kept viable for a
            this,
            other.getType(),
            List<String> reduceViable = CapabilityResolutionUtils.filterByReduceCapability(registry, viableBackends);
     *  co-locate (same {@code tableId}, {@code shardCount=1}). */
        RelNode result = buildEnforcer(rel, toTrait);
package org.opensearch.analytics.planner.rel;
                viableBackends
        if (rel instanceof RelSubset subset) {
        // A shuffle producer must serialize + ship hash partitions, which only a backend that declares
            RelDistribution.Type.BROADCAST_DISTRIBUTED,
     * HASH_DISTRIBUTED demand without a concrete partition count or locality — accepts any
        return new OpenSearchExchangeReducer(rel.getCluster(), rel.getTraitSet().replace(coordSingleton()), rel, reduceViable);
     * scales its self-cost by this count. Used by {@code OpenSearchBroadcastJoinSplitRule} to
            throw new IllegalStateException(
     * Builds an {@link OpenSearchShuffleExchange} that hash-partitions {@code rel} per {@code toTrait}'s
     * Builds an {@link OpenSearchExchangeReducer} that gathers {@code rel} to {@code COORDINATOR+SINGLETON} —
 */
 * an {@link OpenSearchShuffleExchange} for HASH_DISTRIBUTED demands. RANGE exchanges
            );
                rel,
        // keyword scan under prefer_metadata_driver) so the producer never lands on a driver that throws
    private static final Logger LOGGER = LogManager.getLogger(OpenSearchDistributionTraitDef.class);
            return rel;
    /** COORDINATOR + SINGLETON — data gathered to coord. Stamped on ER output, FINAL
            rel.getId(),
                "HASH_DISTRIBUTED demand has null partitionCount; caller must resolve count "
     * bottom-up convert path; this is the explicit "force a shuffle here" primitive.
            fromTrait,
     *  ER is inserted; a multi-shard RANDOM subtree still mismatches and triggers ER insertion. */
    }
            // (root demand), stamp COORDINATOR so the resulting subset is well-typed.
        // setting → engine default) and embedded it in toTrait. A null demand is rejected — the caller
        );
        List<String> viableBackends = resolveViableBackendsFromRel(rel);
            return rel;
        );
     * calls this directly: a content node returned by its bottom-up visit still carries CBO's stale
            viableBackends
 * @opensearch.internal
        }
     * shape is identical to {@code OpenSearchBroadcastJoinSplitRule}'s, so {@code DAGBuilder.cutBroadcast} +
     * demand the build side be replicated; Volcano's trait converter materializes an
    public OpenSearchDistribution shardRandom(int tableId, int shardCount) {
    public Class<OpenSearchDistribution> getTraitClass() {
        }
    @Override
        this.plannerContext = plannerContext;
     */
            RelDistribution.Type.SINGLETON,
 */
        return new OpenSearchDistribution(
        if (toTrait.getType() == RelDistribution.Type.ANY) {
        CapabilityRegistry registry = plannerContext.getCapabilityRegistry();
            null,
    public OpenSearchDistribution hashAny(List<Integer> keys) {
            probeNodeEstimate,
    // ---- RelTraitDef ----
            viableBackends
     * broadcast exchange (rather than peeling it and re-driving the join through the shuffle algebra, which
    /** Copies a distribution from another trait def — preserves all fields. */
        // SHUFFLE_PRODUCER UOE at execution.
     *  {@code UnionSplitRule} / {@code JoinSplitRule} skip inserting an ER when all inputs
            // ER output always lives at the coordinator. Even if the demand is null-locality
     * in its own {@code Visited} record), so the satisfies-gated {@link #buildEnforcer} would wrongly treat
     * {@link OpenSearchExchangeReducer} for SINGLETON, {@link OpenSearchShuffleExchange} for
     * enforcement pass (Option B) calls this directly at a join tier boundary: the binary shuffle transport
            other.getShardCount(),
                    + toTrait
     * for the bottom-up convert path; this is the explicit "replicate here" primitive.
import org.apache.logging.log4j.Logger;
     * UNCONDITIONALLY (no {@code satisfies()} short-circuit). The distribution enforcement pass (Option B)
            OpenSearchDistribution.Locality.WORKER,
    public OpenSearchDistribution hash(List<Integer> keys, int partitionCount) {
    public OpenSearchDistribution shardSingleton(int tableId, int shardCount) {
     * Builds an {@link OpenSearchBroadcastExchange} that replicates {@code rel} to every probe-side worker —
    }
        OpenSearchDistribution fromTrait = rel.getTraitSet().getTrait(this);
                toTrait.getPartitionCount(),
        );
        );
            List.of(),
            rel = subset.getBestOrOriginal();
     * binary transport cannot run that). {@link #buildEnforcer} keeps the satisfies-gated behavior for the
    /** SHARD + RANDOM — multi-shard TableScan output, and also the shape for shard-local
     * needs every distributed join input to be its OWN producer stage, so even an input already HASH on the
    public OpenSearchDistribution coordSingleton() {
            null,
        List<String> reduceViable = CapabilityResolutionUtils.filterByReduceCapability(
        return "dist";
    }
            // RANGE is still not implemented; never produced by analytics-engine rules today.
     *     ShuffleScan handlers index per-partition buffers and need a resolved count)
     *
        // probeNodeEstimate piggybacks onto the partitionCount field — semantically distinct
        } else if (toTrait.getType() == RelDistribution.Type.HASH_DISTRIBUTED) {
     *  Filter/Project/PARTIAL aggregate that pass through the scan's trait. */
    @Override
        return new OpenSearchDistribution(
            other.getKeys(),
            rel.getTraitSet().replace(toTrait),
    }
        return any();
        );
 * The OpenSearch Contributors require contributions made to
import org.apache.calcite.plan.RelOptPlanner;
        return new OpenSearchShuffleExchange(
        return new OpenSearchDistribution(this, null, RelDistribution.Type.HASH_DISTRIBUTED, keys, null, null, null);
        }
            OpenSearchDistribution.Locality.COORDINATOR,
            return rel;
            plannerContext.getCapabilityRegistry(),
 *
            null
        );
     * COORDINATOR+SINGLETON trait on its {@code traitSet} (the pass tracks the REAL distribution separately,
    }
            shardCount,
    public boolean canConvert(RelOptPlanner planner, OpenSearchDistribution fromTrait, OpenSearchDistribution toTrait) {
}
        return new OpenSearchDistribution(this, null, type, keys, null, null, null);
        // must resolve a concrete count, otherwise the exchange is incoherent with downstream ShuffleScan
    @Override
    }
            // ANY demand or already satisfied — no exchange inserted, nothing to register.
        return new OpenSearchDistribution(
        return new OpenSearchDistribution(
    }
        return true;
    public OpenSearchDistribution getDefault() {
     *     CBO exchange so the cost/transport semantics match the legacy broadcast plan.
            shardCount,
            OpenSearchDistribution.Locality.SHARD,
            this,
    /**
        List<String> shuffleViable = CapabilityResolutionUtils.filterByShuffleProducerCapability(
 * is detected. Produces an {@link OpenSearchExchangeReducer} for SINGLETON demands and
            // and stashed it in partitionCount. The exchange reads it for its cost function.
import org.apache.calcite.rel.RelDistribution;
                rel.getCluster(),
import org.opensearch.analytics.planner.CapabilityResolutionUtils;
    /**
            );
            RelDistribution.Type.HASH_DISTRIBUTED,
        if (toTrait.getPartitionCount() == null) {
        if (result == rel) {
                throw new IllegalStateException(
    private static List<String> resolveViableBackendsFromRel(RelNode rel) {
                    + "via OpenSearchDistributionTraitDef.hash(keys, partitionCount). toTrait="
    public OpenSearchBroadcastExchange buildBroadcastExchange(RelNode rel, int probeNodeEstimate) {
        // trait. The broadcast exchange reads it from the trait at convert() time.
            "buildEnforcer(): rel={}#{}, fromTrait={}, toTrait={}, backend={}",
        return planner.register(result, rel);
            return null;
    // ---- Factory methods ----
            OpenSearchDistribution stamp = toTrait.getLocality() == null ? coordSingleton() : toTrait;
                rel.getTraitSet().replace(toTrait),
     * the unified dispatcher execute it unchanged. {@link #buildEnforcer} keeps the satisfies-gated behavior
        );
            probeNodeEstimate
            return new OpenSearchExchangeReducer(rel.getCluster(), rel.getTraitSet().replace(stamp), rel, reduceViable);
    }
            if (toTrait.getPartitionCount() == null) {
            other.getLocality(),
    @Override
import org.apache.logging.log4j.LogManager;
    }
            null,
    public OpenSearchShuffleExchange buildShuffleExchange(RelNode rel, OpenSearchDistribution toTrait) {
     * The pass therefore decides "gather needed" from its tracked distribution and calls this to force the
    }
            // Broadcast demand: the build side gets replicated to every probe node. The split
            List.of(),
     *  Used as the root demand: a 1-shard SHARD+SINGLETON subtree already satisfies, so no top
            rel,
 *
    @Override
     */
import org.opensearch.analytics.planner.CapabilityRegistry;
     */
    /** SINGLETON with null locality — accepts either SHARD+SINGLETON or COORDINATOR+SINGLETON.
            null
    public OpenSearchDistribution from(OpenSearchDistribution other) {
    public RelNode buildEnforcer(RelNode rel, OpenSearchDistribution toTrait) {
 *
     * would lose the broadcast optimization). The resulting {@code Join(BroadcastExchange(build), probe)}
    public OpenSearchDistributionTraitDef(PlannerContext plannerContext) {
    public String getSimpleName() {
        LOGGER.debug(
        if (toTrait.getType() == RelDistribution.Type.SINGLETON) {
            rel.getTraitSet().replace(broadcast(probeNodeEstimate)),
        } else if (toTrait.getType() == RelDistribution.Type.BROADCAST_DISTRIBUTED) {
     */
        );
     * being reused in place (which would collapse N joins into one fragment with N shuffle leaves — the
        return OpenSearchDistribution.class;
     * BROADCAST_DISTRIBUTED + REPLICATED demand — full row set replicated to every probe-side
 * Trait definition for OpenSearch distribution.
    }
            this,
            return new OpenSearchBroadcastExchange(
import org.apache.calcite.plan.volcano.RelSubset;
            RelDistribution.Type.RANDOM_DISTRIBUTED,
                );
    }
 * compatible open source license.
        return new OpenSearchBroadcastExchange(
     * @throws IllegalStateException if {@code toTrait} carries no concrete partition count (downstream
    public OpenSearchDistribution anySingleton() {
        if (result == null) {
     */
     */
            List.of(),
        }
     * hash partitioning compatible with the join keys. The trait converter materializes
            rel.getCluster(),
     * Used by {@code OpenSearchHashJoinSplitRule} to demand both join inputs deliver a
    private final PlannerContext plannerContext;
        // from HASH's partitionCount but uses the same record slot for transit through the
            viableBackends
     * registering it with any planner. Shared by:
            rel.getClass().getSimpleName(),
            other.getTableId(),
    /**
            partitionCount
     * keys + partition count — UNCONDITIONALLY (no {@code satisfies()} short-circuit). The distribution
    public OpenSearchDistribution fromType(RelDistribution.Type type, List<Integer> keys) {
                        + toTrait
    }
        // The split rule / pass that issued the demand resolved the concrete partition count (cluster
 * SPDX-License-Identifier: Apache-2.0
     *   <li>{@link #convert} (bottom-up): registers the returned rel via {@code planner.register};</li>
            return buildShuffleExchange(rel, toTrait);
            OpenSearchDistribution.Locality.REPLICATED,
            null,
            RelDistribution.Type.SINGLETON,
import org.apache.calcite.rel.RelNode;
 * <p>One instance per query — created by {@link PlannerContext}.
    public OpenSearchExchangeReducer buildReducer(RelNode rel) {
            plannerContext.getCapabilityRegistry(),
    }
     * Builds the exchange rel that enforces {@code toTrait} over {@code rel} — an
            keys,
    }
    /**
     *  aggregate output, Join/Union output; demanded by cost gates on collated Sort /
    }
                    "BROADCAST_DISTRIBUTED demand has null probe-node estimate; rule must "
            this,
    }
        }
     * {@link OpenSearchBroadcastExchange} on any input not already so distributed.
     * where the trait IS reliable.
    /** ANY — universal sink; any distribution satisfies it. Used as {@link #getDefault}. */
            OpenSearchDistribution.Locality.SHARD,
            toTrait.getKeys(),
        return new OpenSearchDistribution(
            viableBackends.getFirst()
        throw new IllegalStateException("Expected OpenSearchRelNode but got [" + rel.getClass().getSimpleName() + "#" + rel.getId() + "]");
    }
    /**
    public RelNode convert(RelOptPlanner planner, RelNode rel, OpenSearchDistribution toTrait, boolean allowInfiniteCostConverters) {
     * Returns {@code rel} unchanged when {@code toTrait} is ANY or already satisfied (caller treats that
     * worker. {@code probeNodeEstimate} feeds the cost model: {@link OpenSearchBroadcastExchange}
    }
            tableId,
            toTrait,
     * required keys (e.g. a lower join CBO already shuffled) gets a same-key inter-tier shuffle rather than
    /** SHARD + SINGLETON — single-shard TableScan output. {@code shardCount=1} is what lets
        );
        if (rel instanceof OpenSearchRelNode openSearchRel) {
            List.of(),
     * calls this directly to PRESERVE a broadcast decision CBO already made: when CBO's cost model picked the
            shuffleViable
     * not yet resolved (e.g. early planner exploration). Production-side rules should always
public class OpenSearchDistributionTraitDef extends RelTraitDef<OpenSearchDistribution> {
import org.opensearch.analytics.planner.PlannerContext;
 * are not implemented.
 * <p>Called by Volcano via ExpandConversionRule when a distribution trait mismatch
        }
 * this file be licensed under the Apache-2.0 license or a
            throw new UnsupportedOperationException("RANGE exchange not yet implemented [toTrait=" + toTrait + "]");
            rel.getCluster(),
        );
     * an already-{@code coordSingleton}-tagged-but-actually-HASH rel as "already gathered" and insert no ER.
            null,
 *
                        + "resolve via OpenSearchDistributionTraitDef.broadcast(probeNodes). toTrait="
    public OpenSearchDistribution any() {
     * One factory so the two planner modes produce identical exchanges.
        return new OpenSearchDistribution(this, null, RelDistribution.Type.ANY, List.of(), null, null, null);
        // ER output always lives at the coordinator.
        );
     * an {@link OpenSearchShuffleExchange} when the demand isn't already satisfied.
     * HASH_DISTRIBUTED, {@link OpenSearchBroadcastExchange} for BROADCAST_DISTRIBUTED — WITHOUT
        // handlers that index per-partition buffers.
            tableId,
        } else {
     * broadcast alternative for a small-build join, the pass re-wraps the visited build content in a fresh
        List<String> viableBackends = resolveViableBackendsFromRel(rel);
     * HASH_DISTRIBUTED demand on the given keys, partition count, and WORKER locality.
     * reducer. {@link #buildEnforcer} keeps the satisfies-gated behavior for the bottom-up convert path,
            }
            other.getPartitionCount()
     * upstream HASH on the same keys. Used in narrow contexts where the partition count is
        }
            this,
        return new OpenSearchDistribution(
            return openSearchRel.getViableBackends();
        List<String> viableBackends = resolveViableBackendsFromRel(rel);
     *  RexOver Project / Join / Union. */
import java.util.List;
     */
            // rule resolved probeNodeEstimate (cluster setting → cluster's data-node count)
    public OpenSearchDistribution broadcast(int probeNodeEstimate) {
            null
            this,
     *
            toTrait.getPartitionCount(),
