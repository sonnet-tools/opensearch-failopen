import java.util.List;
        return partitionCount;  
import org.apache.calcite.plan.RelTrait;
            return false;  
        }
    }
    private final OpenSearchDistributionTraitDef traitDef;  
            if (other.locality == null) return true;
    }  
    public Integer getTableId() {  
    @Override
        }
                return new OpenSearchDistribution(traitDef, null, Type.ANY, List.of(), null, null, null);
        this.type = type;
            return this.locality == other.locality;  
    OpenSearchDistribution(
import org.apache.calcite.plan.RelTraitDef;  
            }
    }  
 *       hash-shuffled and is being processed on data-node workers (post-shuffle Join/Agg).</li>
    }  
 * this file be licensed under the Apache-2.0 license or a
    }
        StringBuilder sb = new StringBuilder(base);  
 *       the planner can reason about when two SHARD streams belong to the same physical
            case HASH_DISTRIBUTED -> "HASH" + keys;
        }
            case RANDOM_DISTRIBUTED -> "RANDOM";  
    }
            && locality == other.locality
        }
 * SINGLETON demand with null locality accepts either SHARD or COORDINATOR (used by callers
            if (target < 0) {  
        return traitDef;  
 *       Null for non-HASH distributions and for HASH demands that don't yet know the count
        return tableId;
        // Calcite's contract on RelDistribution.apply (RelDistribution.java:53-67) is to
        this.keys = keys;
    ) {
        return Objects.hash(type, locality, keys, tableId, shardCount, partitionCount);
    @Override  
            // the two classes of "on one node" distinguishable during plan search.
        return true;  
 *
        List<Integer> newKeys = new ArrayList<>(keys.size());  
    public RelTraitDef<? extends RelTrait> getTraitDef() {
    }
import org.apache.calcite.util.mapping.Mappings;
 *   <li>{@code tableId} — for {@code SHARD} distributions, identifies the source table so
            }
                sb.append(":t=").append(tableId);
        if (this.type == Type.BROADCAST_DISTRIBUTED) {
                sb.append(":p=").append(partitionCount);
        }
 *
 *
            && Objects.equals(keys, other.keys)  
    }
        return this.keys.equals(other.keys);  
    @Override
 *       layout (future: co-located joins). Null on COORDINATOR / WORKER distributions.</li>  
 * SPDX-License-Identifier: Apache-2.0
        /** Data has been replicated to every probe-side worker — the broadcast distribution.
    }  
            case SINGLETON -> "SINGLETON";
                return false;  
        if (prefix.size() > list.size()) return false;
        /** Data has been gathered to the coordinator. */  
import org.apache.calcite.plan.RelOptPlanner;
        if (other instanceof OpenSearchDistribution otherDist) {  
        return sb.toString();
import org.apache.calcite.rel.RelDistribution;
            case ANY -> "ANY";
        this.shardCount = shardCount;
    private final Type type;
    }  
            sb.append('(').append(locality);
        List<Integer> keys,  
    public List<Integer> getKeys() {  
 *   <li>{@link Type} — Calcite's partitioning model (SINGLETON / RANDOM / HASH / ANY).</li>  
 * <ul>  
        // Mappings.apply2 throws on an unmapped key, which is the wrong behavior here — fall
        this.locality = locality;  
        if (this.type == Type.SINGLETON) {
        Integer shardCount,
            if (other.partitionCount != null && !other.partitionCount.equals(this.partitionCount)) {
        if (this == obj) return true;
 *
    /** Where the rows physically live. */
 *       aggregate output, Join/Union output). {@code WORKER} means data has been
    }
 *       {@code COORDINATOR} means data has been gathered to the coord (ER output, FINAL  
            if (!Objects.equals(prefix.get(i), list.get(i))) return false;
            return this.locality == other.locality;
        // silently degrade to ANY if any HASH key cannot be mapped through the projection.  
        }
        SHARD,
        /** Data sits at shard storage nodes. */
    }  
 *   <li>{@link Locality} — where the rows physically live. {@code SHARD} means data sits
            && Objects.equals(partitionCount, other.partitionCount);  
    public void register(RelOptPlanner planner) {}
            // Locality: WORKER produced data satisfies a WORKER demand. A null demanded
    @Override  
        // back to ANY when the mapping drops a key we depend on.
    public Type getType() {
        Type type,
            // no keys (broadcast doesn't partition on anything). Locality must match: broadcast  
        return type;
        }
            // produced data satisfies a REPLICATED demand only. A null demanded locality
            if (tableId != null) {  
    /** Returns true iff {@code prefix} is a prefix of {@code list}. */  
            // Partition counts must match exactly: HASH(k, 4) and HASH(k, 8) place rows in
            && Objects.equals(shardCount, other.shardCount)
    }
 * <p><b>Satisfies semantics.</b> For {@code SINGLETON}, the same locality satisfies; a  
        return locality;  
    @Override  
 * that don't care whether data is shard-local or gathered). For {@code HASH_DISTRIBUTED},
 * <p>Carries five pieces of information:
 *       (caller resolves to a concrete number before stamping on a producer).</li>  
                sb.append(":s=").append(shardCount);
import java.util.ArrayList;
            if (partitionCount != null) {  
            // coarser). Demanded keys must therefore be a prefix of produced keys.
        if (other.type == Type.ANY) {
        this.partitionCount = partitionCount;
        for (int i = 0; i < prefix.size(); i++) {  
        return shardCount;
            if (other.locality == null) return true;  
            // Otherwise the locality must match exactly — this is what prevents an ER over a
        return keys;
        REPLICATED  
    public int compareTo(org.apache.calcite.plan.RelMultipleTrait other) {
public class OpenSearchDistribution implements RelDistribution {  
            // SINGLETON demand with null locality accepts either SHARD or COORDINATOR.
            newKeys.add(target);  
            if (other.locality == null) return true;
package org.opensearch.analytics.planner.rel;
import java.util.Objects;  
        OpenSearchDistributionTraitDef traitDef,  
    private final Integer partitionCount;  
/*  
        Integer partitionCount  
        return type == Type.ANY;
    private final Integer tableId;
            if (!isPrefix(other.keys, this.keys)) return false;  
 *       different partition counts are <em>not</em> compatible (data isn't physically aligned).
        this.tableId = tableId;  
        }  
    @Override
    public Integer getPartitionCount() {
 * (finer satisfies coarser) AND the partition counts match exactly.
    @Override  
            return type.compareTo(otherDist.type);
        if (this.type != other.type) {
            }
    public int hashCode() {
            // A hash partitioning on keys K is also a hash partitioning on any prefix of K  
            // SHARD scan from dedup-ing into a COORDINATOR-producing sibling subset, and keeps  
        if (locality != null) {
        if (!(trait instanceof OpenSearchDistribution other)) {
    public boolean equals(Object obj) {
            if (!this.keys.equals(other.keys)) return false;  
 *       of post-shuffle output partitions. Two HASH distributions with the same keys but  
         *  every node; worker+hash has 1/N of rows on each. */
    public RelDistribution apply(Mappings.TargetMapping mapping) {
            // Broadcast = full-row-set replicated to every probe-side node. The demand carries
        return 0;  
        }
@SuppressWarnings("unchecked")
    public boolean isTop() {  
            return this;  
            return this.locality == other.locality;
            && Objects.equals(tableId, other.tableId)
         *  because the row set per node is different in shape: replicated has all rows on
 *   <li>{@code shardCount} — for {@code SHARD} distributions only.</li>
}
 * The OpenSearch Contributors require contributions made to  
        this.traitDef = traitDef;
        if (type == Type.ANY) return base;
    @Override  
        /** Data has been hash-shuffled to data-node workers (post-shuffle execution locale).
        if (!(obj instanceof OpenSearchDistribution other)) return false;  
    private static boolean isPrefix(List<Integer> prefix, List<Integer> list) {
    public Integer getShardCount() {
 * the produced trait satisfies the demand iff the keys are a superset of the demanded keys  
            // accepts either (rare; broadcast demands always carry REPLICATED today).
        }
        return type == other.type
        Integer tableId,
 * @opensearch.internal  
            // A null demanded partitionCount accepts any (used while the rule is still  
    }
        if (type != Type.HASH_DISTRIBUTED || keys.isEmpty()) {
 */
            // locality accepts either (rare; HASH demands always carry WORKER today).  
    @Override
            default -> type.shortName;  
        return new OpenSearchDistribution(traitDef, locality, Type.HASH_DISTRIBUTED, newKeys, tableId, shardCount, partitionCount);
 * compatible open source license.
        String base = switch (type) {
    private final List<Integer> keys;  
    @Override  
 *   <li>{@code partitionCount} — for {@code HASH_DISTRIBUTED} distributions only; the number
            return false;  
    public Locality getLocality() {
    @Override
        if (this.type == Type.HASH_DISTRIBUTED) {
         *  Each worker holds 1/N of the rows, partitioned by hash key. */  
    }
            sb.append(')');  
            }
        };
        WORKER,
    public String toString() {  
    private final Integer shardCount;
         *  Every worker holds the full row set (small build side). Distinct from {@link #WORKER}  
            // resolving the count); a concrete demand requires equality.
    }
    }
 * </ul>
            // entirely different buckets, so neither satisfies the other regardless of keys.
        COORDINATOR,
            }
            // (rows colocated by hash(k1,k2) are also colocated by hash(k1) — finer satisfies
            return true;  
    private final Locality locality;
            if (shardCount != null) {  
/**
 */  
        for (int key : keys) {
        Locality locality,
    public enum Locality {  
        }
    public boolean satisfies(RelTrait trait) {
 *       at its storage location (TableScan output, shard-local Filter/Project/PARTIAL agg).
            int target = mapping.getTargetOpt(key);
 * Distribution trait for OpenSearch Analytics operators.  
