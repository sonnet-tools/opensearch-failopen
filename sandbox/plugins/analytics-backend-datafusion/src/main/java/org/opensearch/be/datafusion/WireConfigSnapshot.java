            return this;
    private final int targetPartitions;
    }
     * matching the Rust {@code DatafusionQueryConfig::default()}.
        segment.set(ValueLayout.JAVA_INT, 40, forceStrategy);  
        private int targetPartitions = 4;  
     */  
        private Builder() {}
    public static final long BYTE_SIZE = 56;
        private boolean listingTablePushdownFilters = false;
     * Builder for {@link WireConfigSnapshot}. All fields have sensible defaults
     * Offset  Size  Field                                Type     Source
        return new Builder().batchSize(current.batchSize)
        // Offset 16: min_skip_run_default (i64)  
        }
     * Total: 56 bytes
     * 40      4     force_strategy                       i32      from snapshot (-1/0/1)  
        segment.set(ValueLayout.JAVA_INT, 48, 10);
     * {@code optimizer.prefer_hash_join}). Only consulted on hash-shuffle worker sessions; the
            this.forceStrategy = forceStrategy;  
        /** @param forceStrategy -1 = None (heuristic), 0 = RowSelection, 1 = BooleanMask. */
        return indexedPushdownFilters;  
    }  
            return new WireConfigSnapshot(this);
        return minSkipRunDefault;
        this.listingTablePushdownFilters = builder.listingTablePushdownFilters;  
    }
 * {@code #[repr(C)]} layout.  
            .forceStrategy(current.forceStrategy)
 * Immutable snapshot of the dynamic indexed query settings, ready to be written
    }
     * Creates a builder pre-populated with all values from an existing snapshot.
     *
     * </pre>  
     * Useful for rebuilding a snapshot with a single field changed.
            return this;
    public int minSkipRunDefault() {  
    private final int batchSize;  
        // Offset 36: indexed_pushdown_filters (i32) — 0 = false, 1 = true  
    }  
            .minSkipRunSelectivityThreshold(current.minSkipRunSelectivityThreshold)  
        public Builder minSkipRunDefault(int minSkipRunDefault) {
            return this;
     * Writes this snapshot into a {@code MemorySegment} matching the
        }
 * into a {@code MemorySegment} matching the Rust {@code WireDatafusionQueryConfig}
    }
            return this;
/**  
        public Builder targetPartitions(int targetPartitions) {  
            this.preferHashJoin = preferHashJoin;  
     */  
     *
    public boolean preferHashJoin() {
        this.minSkipRunDefault = builder.minSkipRunDefault;
        segment.set(ValueLayout.JAVA_INT, 32, listingTablePushdownFilters ? 1 : 0);
     * 8       8     target_partitions                    i64      from snapshot
        private boolean preferHashJoin = true;  
        public Builder minSkipRunSelectivityThreshold(double minSkipRunSelectivityThreshold) {  
    private WireConfigSnapshot(Builder builder) {  
        }  
        // Offset 52: prefer_hash_join (i32) — 0 = false (sort-merge join), 1 = true (hash join)
 *
    public double minSkipRunSelectivityThreshold() {
    private final boolean preferHashJoin;
        }  
        public Builder listingTablePushdownFilters(boolean listingTablePushdownFilters) {
            .minSkipRunDefault(current.minSkipRunDefault)
            this.listingTablePushdownFilters = listingTablePushdownFilters;  
            .indexedPushdownFilters(current.indexedPushdownFilters)
     * The segment must be at least {@link #BYTE_SIZE} bytes and allocated from
/*  
 * this file be licensed under the Apache-2.0 license or a
    private final boolean indexedPushdownFilters;
     * coordinator sets it {@code false} per worker stage for a large-build join so DataFusion emits a
}
     * a confined {@code Arena} scoped to the query lifetime. Fields that the Rust
        private int minSkipRunDefault = 1024;
        // Offset 44: cost_predicate (i32) — hardcoded 1
    public int forceStrategy() {
        return targetPartitions;
    private final int minSkipRunDefault;  
     * 52      4     prefer_hash_join                     i32      from snapshot (0/1)  
 * Use {@link #builder()} to construct instances.
     * <pre>  
        }
        // Offset 24: min_skip_run_selectivity_threshold (f64)
        /** @param preferHashJoin false → DataFusion emits a spillable sort-merge join for equi-joins. */
     */  
@ExperimentalApi  
            return this;  
            .preferHashJoin(current.preferHashJoin);  
        private int forceStrategy = -1;
        this.preferHashJoin = builder.preferHashJoin;
        }
import org.opensearch.common.annotation.ExperimentalApi;
        this.forceStrategy = builder.forceStrategy;
    /**  
     * <p>  
import java.lang.foreign.MemorySegment;  
 * SPDX-License-Identifier: Apache-2.0
     * ──────  ────
     * 24      8     min_skip_run_selectivity_threshold   f64      from snapshot  
        segment.set(ValueLayout.JAVA_LONG, 8, (long) targetPartitions);
        public Builder preferHashJoin(boolean preferHashJoin) {
            this.minSkipRunDefault = minSkipRunDefault;
        this.minSkipRunSelectivityThreshold = builder.minSkipRunSelectivityThreshold;
        // Offset 48: cost_collector (i32) — hardcoded 10  
 */
     * 44      4     cost_predicate                       i32      hardcoded 1
    }
        // Offset 32: listing_table_pushdown_filters (i32) — 0 = false, 1 = true
        }  
            .listingTablePushdownFilters(current.listingTablePushdownFilters)
     * 0       8     batch_size                           i64      from snapshot  
     * Whether the physical planner prefers a hash join over a sort-merge join (DataFusion's  
     * 36      4     indexed_pushdown_filters             i32      from snapshot (0/1)
        return preferHashJoin;  
        public Builder forceStrategy(int forceStrategy) {
    }
public final class WireConfigSnapshot {
        segment.set(ValueLayout.JAVA_INT, 52, preferHashJoin ? 1 : 0);  
        segment.set(ValueLayout.JAVA_INT, 44, 1);
     * ──────  ────  ─────────────────────────────────    ──────   ───────────
     * side no longer exposes as settings ({@code cost_predicate},  
        this.indexedPushdownFilters = builder.indexedPushdownFilters;  
    }  
        return batchSize;
        return new Builder();  
        return minSkipRunSelectivityThreshold;
     * 48      4     cost_collector                       i32      hardcoded 10
            this.indexedPushdownFilters = indexedPushdownFilters;  
        segment.set(ValueLayout.JAVA_LONG, 0, (long) batchSize);  
import java.lang.foreign.ValueLayout;
        }
    /**  
            return this;
        public WireConfigSnapshot build() {
    private final double minSkipRunSelectivityThreshold;
        this.targetPartitions = builder.targetPartitions;
        private double minSkipRunSelectivityThreshold = 0.03;  
     * spillable {@code SortMergeJoinExec}. Defaults {@code true} (hash-join default) everywhere else.  
            return this;
    /**  
package org.opensearch.be.datafusion;
    /** -1 = None (selectivity heuristic), 0 = RowSelection, 1 = BooleanMask. */  
    public static Builder builder(WireConfigSnapshot current) {
        // Offset 40: force_strategy (i32) — -1 = None, 0 = RowSelection, 1 = BooleanMask
    private final boolean listingTablePushdownFilters;
    public int batchSize() {  
        segment.set(ValueLayout.JAVA_INT, 36, indexedPushdownFilters ? 1 : 0);
 * @opensearch.experimental
    }
            this.targetPartitions = targetPartitions;
 * <p>
    public static final class Builder {
        }
     * 32      4     listing_table_pushdown_filters       i32      from snapshot (0/1)
        segment.set(ValueLayout.JAVA_DOUBLE, 24, minSkipRunSelectivityThreshold);  
    /**
        // Offset 0: batch_size (i64)
    /** Total byte size of the wire struct ({@code WireDatafusionQueryConfig}). */  
     * {@code cost_collector}) are written as their fixed hardcoded values.
 * compatible open source license.
    public static Builder builder() {
    }
        public Builder batchSize(int batchSize) {
    public int targetPartitions() {
 *  
        private int batchSize = 8192;
        public Builder indexedPushdownFilters(boolean indexedPushdownFilters) {
 * The OpenSearch Contributors require contributions made to  
     * 16      8     min_skip_run_default                 i64      from snapshot
        return listingTablePushdownFilters;  
     */
     * @param segment the target memory segment (at least {@link #BYTE_SIZE} bytes)
    }  
        private boolean indexedPushdownFilters = true;
    public boolean indexedPushdownFilters() {
 */  
        // Offset 8: target_partitions (i64)
            this.minSkipRunSelectivityThreshold = minSkipRunSelectivityThreshold;
    public boolean listingTablePushdownFilters() {
            return this;  
        segment.set(ValueLayout.JAVA_LONG, 16, (long) minSkipRunDefault);
            .targetPartitions(current.targetPartitions)  
    }
        this.batchSize = builder.batchSize;
    public void writeTo(MemorySegment segment) {
     * {@code WireDatafusionQueryConfig} {@code #[repr(C)]} layout.
    private final int forceStrategy;  
        return forceStrategy;
            this.batchSize = batchSize;
