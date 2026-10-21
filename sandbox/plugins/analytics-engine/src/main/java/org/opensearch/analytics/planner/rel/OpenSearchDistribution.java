            return false;
        }
        this.tableId = tableId;
         *  Each worker holds 1/N of the rows, partitioned by hash key. */
        WORKER,
            }
        if (this == obj) return true;
            newKeys.add(target);
    public Integer getTableId() {
            return this.locality == other.locality;
public class OpenSearchDistribution implements RelDistribution {
 *       layout (future: co-located joins). Null on COORDINATOR / WORKER distributions.</li>
    private static boolean isPrefix(List<Integer> prefix, List<Integer> list) {
            return this.locality == other.locality;
 * The OpenSearch Contributors require contributions made to
        return tableId;
            if (shardCount != null) {
import org.apache.calcite.util.mapping.Mappings;
 *   <li>{@code partitionCount} — for {@code HASH_DISTRIBUTED} distributions only; the number
    public String toString() {
}
        COORDINATOR,
    @Override
        for (int i = 0; i < prefix.size(); i++) {
            // the two classes of "on one node" distinguishable during plan search.
    @Override
 *       aggregate output, Join/Union output). {@code WORKER} means data has been
                sb.append(":t=").append(tableId);
    @Override
 *       at its storage location (TableScan output, shard-local Filter/Project/PARTIAL agg).
import org.apache.calcite.plan.RelTraitDef;
    public RelTraitDef<? extends RelTrait> getTraitDef() {
    }
 * the produced trait satisfies the demand iff the keys are a superset of the demanded keys
            && locality == other.locality
        /** Data has been hash-shuffled to data-node workers (post-shuffle execution locale).
            return type.compareTo(otherDist.type);
 * compatible open source license.
    @Override
        /** Data has been replicated to every probe-side worker — the broadcast distribution.
            // Partition counts must match exactly: HASH(k, 4) and HASH(k, 8) place rows in
        if (other.type == Type.ANY) {
            return this;
         *  because the row set per node is different in shape: replicated has all rows on
 *   <li>{@code tableId} — for {@code SHARD} distributions, identifies the source table so
 *   <li>{@link Type} — Calcite's partitioning model (SINGLETON / RANDOM / HASH / ANY).</li>
    }
 *       Null for non-HASH distributions and for HASH demands that don't yet know the count
        if (this.type == Type.HASH_DISTRIBUTED) {
        for (int key : keys) {
    }
    public boolean satisfies(RelTrait trait) {
            // Broadcast = full-row-set replicated to every probe-side node. The demand carries
        this.locality = locality;
    @Override
            if (!this.keys.equals(other.keys)) return false;
    }
         *  every node; worker+hash has 1/N of rows on each. */
        }
    public void register(RelOptPlanner planner) {}
        return 0;
            return false;
    public Locality getLocality() {
            case SINGLETON -> "SINGLETON";
        Integer tableId,
        this.traitDef = traitDef;
    @Override
        this.shardCount = shardCount;
        REPLICATED
 * <p><b>Satisfies semantics.</b> For {@code SINGLETON}, the same locality satisfies; a
            // locality accepts either (rare; HASH demands always carry WORKER today).
        return sb.toString();
 * SINGLETON demand with null locality accepts either SHARD or COORDINATOR (used by callers
    }
            if (partitionCount != null) {
        return locality;
        Locality locality,
        }
 *       hash-shuffled and is being processed on data-node workers (post-shuffle Join/Agg).</li>
        /** Data has been gathered to the coordinator. */
        // Mappings.apply2 throws on an unmapped key, which is the wrong behavior here — fall
        if (!(obj instanceof OpenSearchDistribution other)) return false;
            // (rows colocated by hash(k1,k2) are also colocated by hash(k1) — finer satisfies
    @Override
            }
        }
    @Override
    /** Returns true iff {@code prefix} is a prefix of {@code list}. */
            if (!Objects.equals(prefix.get(i), list.get(i))) return false;
    public Integer getShardCount() {
        return traitDef;
            // A hash partitioning on keys K is also a hash partitioning on any prefix of K
        List<Integer> newKeys = new ArrayList<>(keys.size());
    private final Integer shardCount;
 *       {@code COORDINATOR} means data has been gathered to the coord (ER output, FINAL
            // SINGLETON demand with null locality accepts either SHARD or COORDINATOR.
            && Objects.equals(keys, other.keys)
        if (this.type == Type.SINGLETON) {
import org.apache.calcite.plan.RelOptPlanner;
        if (prefix.size() > list.size()) return false;
 *
 * </ul>
            // A null demanded partitionCount accepts any (used while the rule is still
            if (other.locality == null) return true;
    public Type getType() {
        SHARD,
    public boolean equals(Object obj) {
    }
        this.type = type;
    private final List<Integer> keys;
        }
package org.opensearch.analytics.planner.rel;
 * <ul>
    @Override
            // entirely different buckets, so neither satisfies the other regardless of keys.
 * SPDX-License-Identifier: Apache-2.0
    private final Integer tableId;
        if (type != Type.HASH_DISTRIBUTED || keys.isEmpty()) {
import org.apache.calcite.plan.RelTrait;
                return false;
                sb.append(":s=").append(shardCount);
        }
 */
            case HASH_DISTRIBUTED -> "HASH" + keys;
        // Calcite's contract on RelDistribution.apply (RelDistribution.java:53-67) is to
            && Objects.equals(shardCount, other.shardCount)
                return new OpenSearchDistribution(traitDef, null, Type.ANY, List.of(), null, null, null);
 * @opensearch.internal
        Type type,
            // SHARD scan from dedup-ing into a COORDINATOR-producing sibling subset, and keeps
        }
 *
        Integer partitionCount
 * this file be licensed under the Apache-2.0 license or a
    }
    /** Where the rows physically live. */
        return type == Type.ANY;
        }
            }
import org.apache.calcite.rel.RelDistribution;
        return keys;
    }
import java.util.Objects;
    public int hashCode() {
            && Objects.equals(tableId, other.tableId)
 *
        String base = switch (type) {
    }
    }
 *   <li>{@code shardCount} — for {@code SHARD} distributions only.</li>
            // resolving the count); a concrete demand requires equality.
            // accepts either (rare; broadcast demands always carry REPLICATED today).
        // silently degrade to ANY if any HASH key cannot be mapped through the projection.
        return this.keys.equals(other.keys);
            }
    @Override
        }
        if (this.type == Type.BROADCAST_DISTRIBUTED) {
        /** Data sits at shard storage nodes. */
            && Objects.equals(partitionCount, other.partitionCount);
    }
        return partitionCount;
    private final Locality locality;
 *   <li>{@link Locality} — where the rows physically live. {@code SHARD} means data sits
        // back to ANY when the mapping drops a key we depend on.
            sb.append('(').append(locality);
 * that don't care whether data is shard-local or gathered). For {@code HASH_DISTRIBUTED},
            // Otherwise the locality must match exactly — this is what prevents an ER over a
        return new OpenSearchDistribution(traitDef, locality, Type.HASH_DISTRIBUTED, newKeys, tableId, shardCount, partitionCount);
 *       the planner can reason about when two SHARD streams belong to the same physical
        }
 * <p>Carries five pieces of information:
        this.partitionCount = partitionCount;
    public List<Integer> getKeys() {
    public boolean isTop() {
        if (!(trait instanceof OpenSearchDistribution other)) {
 *
            default -> type.shortName;
    }
        if (locality != null) {
    public Integer getPartitionCount() {
        StringBuilder sb = new StringBuilder(base);
    private final Type type;
 *       (caller resolves to a concrete number before stamping on a producer).</li>
    }
/*
            // Locality: WORKER produced data satisfies a WORKER demand. A null demanded
        if (other instanceof OpenSearchDistribution otherDist) {
        return shardCount;
        Integer shardCount,
import java.util.List;
            if (target < 0) {
    OpenSearchDistribution(
 * (finer satisfies coarser) AND the partition counts match exactly.
        };
            // coarser). Demanded keys must therefore be a prefix of produced keys.
 * Distribution trait for OpenSearch Analytics operators.
            }
            if (tableId != null) {
        OpenSearchDistributionTraitDef traitDef,
 *       of post-shuffle output partitions. Two HASH distributions with the same keys but
    private final Integer partitionCount;
 */
            // no keys (broadcast doesn't partition on anything). Locality must match: broadcast
            int target = mapping.getTargetOpt(key);
    @Override
            case RANDOM_DISTRIBUTED -> "RANDOM";
            case ANY -> "ANY";
        if (this.type != other.type) {
import java.util.ArrayList;
            // produced data satisfies a REPLICATED demand only. A null demanded locality
         *  Every worker holds the full row set (small build side). Distinct from {@link #WORKER}
            if (other.locality == null) return true;
        return true;
                sb.append(":p=").append(partitionCount);
            return true;
            return this.locality == other.locality;
    }
    private final OpenSearchDistributionTraitDef traitDef;
    public int compareTo(org.apache.calcite.plan.RelMultipleTrait other) {
    ) {
        if (type == Type.ANY) return base;
    public enum Locality {
        }
            sb.append(')');
    public RelDistribution apply(Mappings.TargetMapping mapping) {
            if (other.locality == null) return true;
        return type;
        this.keys = keys;
    }
            if (other.partitionCount != null && !other.partitionCount.equals(this.partitionCount)) {
            if (!isPrefix(other.keys, this.keys)) return false;
        List<Integer> keys,
 *       different partition counts are <em>not</em> compatible (data isn't physically aligned).
@SuppressWarnings("unchecked")
        return Objects.hash(type, locality, keys, tableId, shardCount, partitionCount);
/**
        return type == other.type
    }
    }
