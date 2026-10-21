 * Immutable snapshot of the dynamic indexed query settings, ready to be written
    private final boolean preferHashJoin;
            return this;
        segment.set(ValueLayout.JAVA_LONG, 0, (long) batchSize);
/**
     * Useful for rebuilding a snapshot with a single field changed.
        public WireConfigSnapshot build() {
    public boolean listingTablePushdownFilters() {
     * 32      4     listing_table_pushdown_filters       i32      from snapshot (0/1)
        private double minSkipRunSelectivityThreshold = 0.03;
        this.batchSize = builder.batchSize;
 * Use {@link #builder()} to construct instances.
        // Offset 44: cost_predicate (i32) — hardcoded 1
     * Offset  Size  Field                                Type     Source
        // Offset 0: batch_size (i64)
    public double minSkipRunSelectivityThreshold() {
     * Writes this snapshot into a {@code MemorySegment} matching the
    private final boolean listingTablePushdownFilters;
        return minSkipRunDefault;
import org.opensearch.common.annotation.ExperimentalApi;
    private final int minSkipRunDefault;
     * {@code WireDatafusionQueryConfig} {@code #[repr(C)]} layout.
    /**
        // Offset 32: listing_table_pushdown_filters (i32) — 0 = false, 1 = true
            this.minSkipRunSelectivityThreshold = minSkipRunSelectivityThreshold;
     * Whether the physical planner prefers a hash join over a sort-merge join (DataFusion's
        segment.set(ValueLayout.JAVA_INT, 36, indexedPushdownFilters ? 1 : 0);
 * {@code #[repr(C)]} layout.
            .minSkipRunSelectivityThreshold(current.minSkipRunSelectivityThreshold)
        segment.set(ValueLayout.JAVA_INT, 40, forceStrategy);
            this.forceStrategy = forceStrategy;
            .forceStrategy(current.forceStrategy)
            return this;
    public int batchSize() {
        return forceStrategy;
    }
        return listingTablePushdownFilters;
        public Builder forceStrategy(int forceStrategy) {
        // Offset 52: prefer_hash_join (i32) — 0 = false (sort-merge join), 1 = true (hash join)
        // Offset 48: cost_collector (i32) — hardcoded 10
    /** Total byte size of the wire struct ({@code WireDatafusionQueryConfig}). */
        public Builder indexedPushdownFilters(boolean indexedPushdownFilters) {
    private final boolean indexedPushdownFilters;
    public static Builder builder() {
 * <p>
/*
            return this;
        this.minSkipRunDefault = builder.minSkipRunDefault;
        return preferHashJoin;
        public Builder targetPartitions(int targetPartitions) {
            return this;
    }
        }
    private final int forceStrategy;
     */
    }
            this.targetPartitions = targetPartitions;
    private final double minSkipRunSelectivityThreshold;
        return new Builder().batchSize(current.batchSize)
        }
     * matching the Rust {@code DatafusionQueryConfig::default()}.
 *
        private int batchSize = 8192;
        this.minSkipRunSelectivityThreshold = builder.minSkipRunSelectivityThreshold;
     * The segment must be at least {@link #BYTE_SIZE} bytes and allocated from
     */
 * this file be licensed under the Apache-2.0 license or a
        segment.set(ValueLayout.JAVA_INT, 32, listingTablePushdownFilters ? 1 : 0);
        public Builder listingTablePushdownFilters(boolean listingTablePushdownFilters) {
            return this;
        this.preferHashJoin = builder.preferHashJoin;
        this.forceStrategy = builder.forceStrategy;
package org.opensearch.be.datafusion;
     * coordinator sets it {@code false} per worker stage for a large-build join so DataFusion emits a
import java.lang.foreign.ValueLayout;
        return indexedPushdownFilters;
        segment.set(ValueLayout.JAVA_INT, 44, 1);
    /**
    private WireConfigSnapshot(Builder builder) {
 * SPDX-License-Identifier: Apache-2.0
    }
     * 8       8     target_partitions                    i64      from snapshot
        }
 * into a {@code MemorySegment} matching the Rust {@code WireDatafusionQueryConfig}
    /**
 *
     * 16      8     min_skip_run_default                 i64      from snapshot
    public int forceStrategy() {
     * ──────  ────
        private Builder() {}
     * Builder for {@link WireConfigSnapshot}. All fields have sensible defaults
        public Builder minSkipRunSelectivityThreshold(double minSkipRunSelectivityThreshold) {
    }
        this.indexedPushdownFilters = builder.indexedPushdownFilters;
        this.listingTablePushdownFilters = builder.listingTablePushdownFilters;
     * 52      4     prefer_hash_join                     i32      from snapshot (0/1)
        // Offset 16: min_skip_run_default (i64)
        return new Builder();
    public static final long BYTE_SIZE = 56;
     * 36      4     indexed_pushdown_filters             i32      from snapshot (0/1)
        }
        segment.set(ValueLayout.JAVA_LONG, 8, (long) targetPartitions);
        public Builder preferHashJoin(boolean preferHashJoin) {
     */
    public static final class Builder {
 */
        }
    /** -1 = None (selectivity heuristic), 0 = RowSelection, 1 = BooleanMask. */
     * {@code optimizer.prefer_hash_join}). Only consulted on hash-shuffle worker sessions; the
    }
     */
    }
     * Total: 56 bytes
 * The OpenSearch Contributors require contributions made to
     * 44      4     cost_predicate                       i32      hardcoded 1
     *
            this.minSkipRunDefault = minSkipRunDefault;
     * 24      8     min_skip_run_selectivity_threshold   f64      from snapshot
            return new WireConfigSnapshot(this);
@ExperimentalApi
            .minSkipRunDefault(current.minSkipRunDefault)
     * @param segment the target memory segment (at least {@link #BYTE_SIZE} bytes)
            return this;
            this.preferHashJoin = preferHashJoin;
        this.targetPartitions = builder.targetPartitions;
        }
        private int minSkipRunDefault = 1024;
    public int targetPartitions() {
        /** @param preferHashJoin false → DataFusion emits a spillable sort-merge join for equi-joins. */
    }
     *
            .preferHashJoin(current.preferHashJoin);
     * spillable {@code SortMergeJoinExec}. Defaults {@code true} (hash-join default) everywhere else.
     * a confined {@code Arena} scoped to the query lifetime. Fields that the Rust
    private final int batchSize;
        return targetPartitions;
        private boolean listingTablePushdownFilters = false;
        segment.set(ValueLayout.JAVA_INT, 52, preferHashJoin ? 1 : 0);
 * @opensearch.experimental
     * Creates a builder pre-populated with all values from an existing snapshot.
            .listingTablePushdownFilters(current.listingTablePushdownFilters)
    public boolean indexedPushdownFilters() {
     * ──────  ────  ─────────────────────────────────    ──────   ───────────
    }
    /**
    public static Builder builder(WireConfigSnapshot current) {
     * <p>
    }
        segment.set(ValueLayout.JAVA_INT, 48, 10);
public final class WireConfigSnapshot {
        return minSkipRunSelectivityThreshold;
     * {@code cost_collector}) are written as their fixed hardcoded values.
        return batchSize;
     * </pre>
        }
        }
        public Builder minSkipRunDefault(int minSkipRunDefault) {
            return this;
     * <pre>
        segment.set(ValueLayout.JAVA_DOUBLE, 24, minSkipRunSelectivityThreshold);
        private int forceStrategy = -1;
     * side no longer exposes as settings ({@code cost_predicate},
import java.lang.foreign.MemorySegment;
            return this;
            .targetPartitions(current.targetPartitions)
     * 40      4     force_strategy                       i32      from snapshot (-1/0/1)
            this.listingTablePushdownFilters = listingTablePushdownFilters;
}
     * 0       8     batch_size                           i64      from snapshot
        }
     * 48      4     cost_collector                       i32      hardcoded 10
        // Offset 8: target_partitions (i64)
            this.batchSize = batchSize;
 * compatible open source license.
        // Offset 36: indexed_pushdown_filters (i32) — 0 = false, 1 = true
            .indexedPushdownFilters(current.indexedPushdownFilters)
        private int targetPartitions = 4;
        public Builder batchSize(int batchSize) {
            this.indexedPushdownFilters = indexedPushdownFilters;
        private boolean indexedPushdownFilters = true;
    }
    private final int targetPartitions;
        // Offset 24: min_skip_run_selectivity_threshold (f64)
    public void writeTo(MemorySegment segment) {
 */
    public boolean preferHashJoin() {
        segment.set(ValueLayout.JAVA_LONG, 16, (long) minSkipRunDefault);
    }
        private boolean preferHashJoin = true;
    public int minSkipRunDefault() {
    }
        // Offset 40: force_strategy (i32) — -1 = None, 0 = RowSelection, 1 = BooleanMask
        /** @param forceStrategy -1 = None (heuristic), 0 = RowSelection, 1 = BooleanMask. */
