     * needs every distributed join input to be its OWN producer stage, so even an input already HASH on the  
    private static List<String> resolveViableBackendsFromRel(RelNode rel) {
    public OpenSearchDistribution hashAny(List<Integer> keys) {
    /** SINGLETON with null locality — accepts either SHARD+SINGLETON or COORDINATOR+SINGLETON.
    public OpenSearchDistribution from(OpenSearchDistribution other) {
            );
 * The OpenSearch Contributors require contributions made to  
            List<String> reduceViable = CapabilityResolutionUtils.filterByReduceCapability(registry, viableBackends);
    }  
        // DataTransferCapability(PRODUCER) can do. Prune scan-only backends (e.g. Lucene, kept viable for a
            shardCount,  
            // ANY demand or already satisfied — no exchange inserted, nothing to register.
    }
     * Builds an {@link OpenSearchShuffleExchange} that hash-partitions {@code rel} per {@code toTrait}'s  
 * this file be licensed under the Apache-2.0 license or a
            return rel;
        }
            return new OpenSearchExchangeReducer(rel.getCluster(), rel.getTraitSet().replace(stamp), rel, reduceViable);
        );
        // SHUFFLE_PRODUCER UOE at execution.  
            rel,  
            this,
                "HASH_DISTRIBUTED demand has null partitionCount; caller must resolve count "
    }
            return null;
     * would lose the broadcast optimization). The resulting {@code Join(BroadcastExchange(build), probe)}
        List<String> reduceViable = CapabilityResolutionUtils.filterByReduceCapability(  
     * bottom-up convert path; this is the explicit "force a shuffle here" primitive.
     * calls this directly: a content node returned by its bottom-up visit still carries CBO's stale
     * for the bottom-up convert path; this is the explicit "replicate here" primitive.
     * <ul>
        // A shuffle producer must serialize + ship hash partitions, which only a backend that declares  
    public boolean canConvert(RelOptPlanner planner, OpenSearchDistribution fromTrait, OpenSearchDistribution toTrait) {  
    /** COORDINATOR + SINGLETON — data gathered to coord. Stamped on ER output, FINAL
 * compatible open source license.
        return any();
    @Override  
            toTrait.getKeys(),
 *
            // rule resolved probeNodeEstimate (cluster setting → cluster's data-node count)
     * {@link OpenSearchBroadcastExchange} on any input not already so distributed.
     *  Filter/Project/PARTIAL aggregate that pass through the scan's trait. */
    public OpenSearchDistribution shardRandom(int tableId, int shardCount) {
                    + toTrait  
 * Trait definition for OpenSearch distribution.  
        );
            List.of(),
            OpenSearchDistribution stamp = toTrait.getLocality() == null ? coordSingleton() : toTrait;
            "buildEnforcer(): rel={}#{}, fromTrait={}, toTrait={}, backend={}",
 */
     * BROADCAST_DISTRIBUTED + REPLICATED demand — full row set replicated to every probe-side  
            // and stashed it in partitionCount. The exchange reads it for its cost function.
            rel,
    /**
        );
import org.apache.calcite.rel.RelNode;
        // handlers that index per-partition buffers.
     * an {@link OpenSearchShuffleExchange} when the demand isn't already satisfied.
            // (root demand), stamp COORDINATOR so the resulting subset is well-typed.  
import org.apache.logging.log4j.Logger;
}
            OpenSearchDistribution.Locality.REPLICATED,  
     *  ER is inserted; a multi-shard RANDOM subtree still mismatches and triggers ER insertion. */
     * not yet resolved (e.g. early planner exploration). Production-side rules should always
     * where the trait IS reliable.
        if (toTrait.getType() == RelDistribution.Type.ANY) {  
            return rel;
    /**
    public OpenSearchDistribution fromType(RelDistribution.Type type, List<Integer> keys) {
            this,  
            null,  
            tableId,
            null
 * is detected. Produces an {@link OpenSearchExchangeReducer} for SINGLETON demands and  
    }
import org.opensearch.analytics.planner.PlannerContext;
            return buildShuffleExchange(rel, toTrait);
            List.of(),
            rel.getClass().getSimpleName(),  
import org.apache.calcite.plan.RelTraitDef;
            rel.getTraitSet().replace(broadcast(probeNodeEstimate)),
import org.apache.calcite.rel.RelDistribution;
            RelDistribution.Type.SINGLETON,
     */  
     * as "no exchange needed"), and never returns {@code null} today (an unenforceable demand throws).  
            this,
        }  
                    + "via OpenSearchDistributionTraitDef.hash(keys, partitionCount). toTrait="
    /**
            other.getTableId(),
 * <p>Called by Volcano via ExpandConversionRule when a distribution trait mismatch
            rel.getId(),
    public OpenSearchDistribution broadcast(int probeNodeEstimate) {  
 *  
     * being reused in place (which would collapse N joins into one fragment with N shuffle leaves — the
 *
        return OpenSearchDistribution.class;  
            return new OpenSearchBroadcastExchange(
        return new OpenSearchDistribution(
     * calls this directly to PRESERVE a broadcast decision CBO already made: when CBO's cost model picked the
        return new OpenSearchDistribution(  
    }  
        return new OpenSearchDistribution(this, null, RelDistribution.Type.SINGLETON, List.of(), null, null, null);  
            throw new IllegalStateException(  
        }
            // Broadcast demand: the build side gets replicated to every probe node. The split  
                rel.getCluster(),
     * COORDINATOR+SINGLETON trait on its {@code traitSet} (the pass tracks the REAL distribution separately,  
     */  
        );  
     * the unified dispatcher execute it unchanged. {@link #buildEnforcer} keeps the satisfies-gated behavior  
    @Override
    public RelNode convert(RelOptPlanner planner, RelNode rel, OpenSearchDistribution toTrait, boolean allowInfiniteCostConverters) {
     * worker. {@code probeNodeEstimate} feeds the cost model: {@link OpenSearchBroadcastExchange}
            plannerContext.getCapabilityRegistry(),  
     * in its own {@code Visited} record), so the satisfies-gated {@link #buildEnforcer} would wrongly treat
        return new OpenSearchDistribution(this, null, type, keys, null, null, null);
            tableId,  
            // RANGE is still not implemented; never produced by analytics-engine rules today.  
     * required keys (e.g. a lower join CBO already shuffled) gets a same-key inter-tier shuffle rather than
    /** Copies a distribution from another trait def — preserves all fields. */  
        if (rel instanceof RelSubset subset) {
    public RelNode buildEnforcer(RelNode rel, OpenSearchDistribution toTrait) {  
        // must resolve a concrete count, otherwise the exchange is incoherent with downstream ShuffleScan  
        // The split rule / pass that issued the demand resolved the concrete partition count (cluster
        }  
 * are not implemented.
     */
        );
            viableBackends
        } else if (toTrait.getType() == RelDistribution.Type.BROADCAST_DISTRIBUTED) {
        throw new IllegalStateException("Expected OpenSearchRelNode but got [" + rel.getClass().getSimpleName() + "#" + rel.getId() + "]");
            rel.getCluster(),
    /**
import org.opensearch.analytics.planner.CapabilityResolutionUtils;  
     * </ul>
        List<String> shuffleViable = CapabilityResolutionUtils.filterByShuffleProducerCapability(
            fromTrait,
            throw new UnsupportedOperationException("RANGE exchange not yet implemented [toTrait=" + toTrait + "]");
            RelDistribution.Type.RANDOM_DISTRIBUTED,  
        List<String> viableBackends = resolveViableBackendsFromRel(rel);
            if (toTrait.getPartitionCount() == null) {  
     * use {@link #hash(List, int)} with a concrete count.
        );
        if (rel instanceof OpenSearchRelNode openSearchRel) {
     * upstream HASH on the same keys. Used in narrow contexts where the partition count is  
 * an {@link OpenSearchShuffleExchange} for HASH_DISTRIBUTED demands. RANGE exchanges
        // ER output always lives at the coordinator.
            OpenSearchDistribution.Locality.WORKER,
    }
        } else {
    public OpenSearchDistributionTraitDef(PlannerContext plannerContext) {
            null,  
    }  
     */
                rel,
     */
            OpenSearchDistribution.Locality.COORDINATOR,
    @Override
            this,
     * {@link OpenSearchExchangeReducer} for SINGLETON, {@link OpenSearchShuffleExchange} for
            null
 * <p>One instance per query — created by {@link PlannerContext}.
    }
        return new OpenSearchBroadcastExchange(
        List<String> viableBackends = resolveViableBackendsFromRel(rel);
    public OpenSearchDistribution coordSingleton() {
     *  aggregate output, Join/Union output; demanded by cost gates on collated Sort /  
        );
            keys,  
    /**
    /** ANY — universal sink; any distribution satisfies it. Used as {@link #getDefault}. */
    }
                );
        }
            return openSearchRel.getViableBackends();  
    public OpenSearchDistribution shardSingleton(int tableId, int shardCount) {  
        if (toTrait.getType() == RelDistribution.Type.SINGLETON) {  
                viableBackends  
        );
        this.plannerContext = plannerContext;  
            viableBackends
     * shape is identical to {@code OpenSearchBroadcastJoinSplitRule}'s, so {@code DAGBuilder.cutBroadcast} +
    }
            probeNodeEstimate,  
     * broadcast exchange (rather than peeling it and re-driving the join through the shuffle algebra, which  
            rel.getTraitSet().replace(toTrait),
            RelDistribution.Type.SINGLETON,  
        return new OpenSearchDistribution(
     * scales its self-cost by this count. Used by {@code OpenSearchBroadcastJoinSplitRule} to
     */  
            other.getKeys(),  
     * reducer. {@link #buildEnforcer} keeps the satisfies-gated behavior for the bottom-up convert path,
            this,  
    public OpenSearchDistribution hash(List<Integer> keys, int partitionCount) {
    }
 */  
    public String getSimpleName() {
     * @param probeNodeEstimate replica count (= probe-side data-node estimate); carried verbatim from the  
     * HASH_DISTRIBUTED demand on the given keys, partition count, and WORKER locality.
            shuffleViable  
    }  
        // probeNodeEstimate piggybacks onto the partitionCount field — semantically distinct
     * Used by {@code OpenSearchHashJoinSplitRule} to demand both join inputs deliver a  
            this,
            rel.getCluster(),  
                toTrait.getPartitionCount(),
        return new OpenSearchDistribution(this, null, RelDistribution.Type.HASH_DISTRIBUTED, keys, null, null, null);
    }  
        LOGGER.debug(
                        + "resolve via OpenSearchDistributionTraitDef.broadcast(probeNodes). toTrait="  
            // ER output always lives at the coordinator. Even if the demand is null-locality
    }
                rel.getTraitSet().replace(toTrait),  
     * The pass therefore decides "gather needed" from its tracked distribution and calls this to force the  
    }  
            }  
            shardCount,
/*  
     *  RexOver Project / Join / Union. */
     * hash partitioning compatible with the join keys. The trait converter materializes
     * demand the build side be replicated; Volcano's trait converter materializes an  
    public OpenSearchDistribution anySingleton() {
     * Returns {@code rel} unchanged when {@code toTrait} is ANY or already satisfied (caller treats that
    }  
     * Builds the exchange rel that enforces {@code toTrait} over {@code rel} — an  
     *
        return new OpenSearchShuffleExchange(  
     * HASH_DISTRIBUTED demand without a concrete partition count or locality — accepts any
            null,
        return new OpenSearchDistribution(
        if (result == null) {
        // trait. The broadcast exchange reads it from the trait at convert() time.  
            toTrait,  
import java.util.List;  
        );  
    public Class<OpenSearchDistribution> getTraitClass() {
    // ---- RelTraitDef ----
    }
                throw new IllegalStateException(
package org.opensearch.analytics.planner.rel;
    @Override
     *   <li>{@link OpenSearchConvention#enforce} (top-down): returns it for the planner to register.</li>  
        CapabilityRegistry registry = plannerContext.getCapabilityRegistry();
    }
    }  
    private final PlannerContext plannerContext;  
            List.of(),
        return new OpenSearchDistribution(
            rel = subset.getBestOrOriginal();  
 * @opensearch.internal  
            RelDistribution.Type.BROADCAST_DISTRIBUTED,
     *     CBO exchange so the cost/transport semantics match the legacy broadcast plan.
     * UNCONDITIONALLY (no {@code satisfies()} short-circuit). The distribution enforcement pass (Option B)  
            );
            viableBackends
        } else if (toTrait.getType() == RelDistribution.Type.HASH_DISTRIBUTED) {  
            other.getLocality(),
            viableBackends.getFirst()
    /** SHARD + RANDOM — multi-shard TableScan output, and also the shape for shard-local  
            OpenSearchDistribution.Locality.SHARD,  
     * HASH_DISTRIBUTED, {@link OpenSearchBroadcastExchange} for BROADCAST_DISTRIBUTED — WITHOUT
            RelDistribution.Type.HASH_DISTRIBUTED,
        return true;
        return new OpenSearchDistribution(  
    public OpenSearchExchangeReducer buildReducer(RelNode rel) {
            probeNodeEstimate
            other.getShardCount(),
    private static final Logger LOGGER = LogManager.getLogger(OpenSearchDistributionTraitDef.class);
     *
     * keys + partition count — UNCONDITIONALLY (no {@code satisfies()} short-circuit). The distribution
        }
import org.opensearch.analytics.planner.CapabilityRegistry;
        return "dist";
    }  
            other.getType(),
            other.getPartitionCount()  
        List<String> viableBackends = resolveViableBackendsFromRel(rel);
import org.apache.logging.log4j.LogManager;  
import org.apache.calcite.plan.RelOptPlanner;
     *   <li>{@link #convert} (bottom-up): registers the returned rel via {@code planner.register};</li>
     * registering it with any planner. Shared by:  
     * enforcement pass (Option B) calls this directly at a join tier boundary: the binary shuffle transport
     * UNCONDITIONALLY (no {@code satisfies()} short-circuit). The distribution enforcement pass (Option B)
     *  {@code UnionSplitRule} / {@code JoinSplitRule} skip inserting an ER when all inputs
    /**
     * binary transport cannot run that). {@link #buildEnforcer} keeps the satisfies-gated behavior for the  
     * Builds an {@link OpenSearchBroadcastExchange} that replicates {@code rel} to every probe-side worker —
        if (fromTrait != null && fromTrait.satisfies(toTrait)) {
            null,
                        + toTrait
    public OpenSearchDistribution any() {  
        return planner.register(result, rel);
 *
/**
        );  
     */
            List.of(),
        return new OpenSearchExchangeReducer(rel.getCluster(), rel.getTraitSet().replace(coordSingleton()), rel, reduceViable);
import org.apache.calcite.plan.volcano.RelSubset;  
     *     ShuffleScan handlers index per-partition buffers and need a resolved count)
            null,
            toTrait.getPartitionCount(),
     *  co-locate (same {@code tableId}, {@code shardCount=1}). */
     * @throws IllegalStateException if {@code toTrait} carries no concrete partition count (downstream  
    public OpenSearchDistribution getDefault() {  
    /** SHARD + SINGLETON — single-shard TableScan output. {@code shardCount=1} is what lets  
    @Override
     * One factory so the two planner modes produce identical exchanges.
        if (toTrait.getPartitionCount() == null) {
        }
    // ---- Factory methods ----  
            null
        // from HASH's partitionCount but uses the same record slot for transit through the
        List<String> viableBackends = resolveViableBackendsFromRel(rel);
    /**
    public OpenSearchBroadcastExchange buildBroadcastExchange(RelNode rel, int probeNodeEstimate) {  
public class OpenSearchDistributionTraitDef extends RelTraitDef<OpenSearchDistribution> {
     * Builds an {@link OpenSearchExchangeReducer} that gathers {@code rel} to {@code COORDINATOR+SINGLETON} —  
    }  
        return new OpenSearchDistribution(this, null, RelDistribution.Type.ANY, List.of(), null, null, null);
     *  Used as the root demand: a 1-shard SHARD+SINGLETON subtree already satisfies, so no top  
            plannerContext.getCapabilityRegistry(),
        RelNode result = buildEnforcer(rel, toTrait);  
        OpenSearchDistribution fromTrait = rel.getTraitSet().getTrait(this);
            OpenSearchDistribution.Locality.SHARD,
            partitionCount  
        if (result == rel) {
        }
                    "BROADCAST_DISTRIBUTED demand has null probe-node estimate; rule must "
            null,
        );
    public OpenSearchShuffleExchange buildShuffleExchange(RelNode rel, OpenSearchDistribution toTrait) {  
        // setting → engine default) and embedded it in toTrait. A null demand is rejected — the caller
     * an already-{@code coordSingleton}-tagged-but-actually-HASH rel as "already gathered" and insert no ER.
 * SPDX-License-Identifier: Apache-2.0
            return rel;  
        // keyword scan under prefer_metadata_driver) so the producer never lands on a driver that throws
     * broadcast alternative for a small-build join, the pass re-wraps the visited build content in a fresh
