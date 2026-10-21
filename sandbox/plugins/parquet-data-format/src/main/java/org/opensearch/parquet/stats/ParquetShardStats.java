    @Nullable
    private final long docsIndexedTotal;
        out.writeVLong(docsIndexedTotal);
            this.mergeTotal + other.mergeTotal,
        this.rowIdMappingMax = in.readVLong();
        long docsIndexedTotal,
        this.backgroundWriteFailures = in.readVLong();
        out.writeVLong(nativeFinalizeTotal);
package org.opensearch.parquet.stats;
    private final long mergeTotal;
        long nativeWriteTotal,
    }
        long nativeFinalizeTotal,
            backgroundWriteWaitMillis,
        builder.startObject("native_write");
            nativeWriteTotal,
        builder.endObject();
        long backgroundWriteTimeouts,
        this.mergeOutputRowsTotal = mergeOutputRowsTotal;
        long nativeWriteTimeMillis,
            this.nativeWriteTimeMillis + other.nativeWriteTimeMillis,
        builder.endObject();
    private final long vsrRotationsTotal;
        this.nativeFinalizeTimeMillis = in.readVLong();
        this.flushAndSortChunkTotal = flushAndSortChunkTotal;
        this.backgroundWriteTimeouts = in.readVLong();
    @Override
            Math.max(this.rowIdMappingMax, other.rowIdMappingMax),
            flushAndSortChunkTotal,
        long mergeFailures,
        long flushAndSortChunkTotal,
        long mergeInputFilesTotal,
    private final long mergeTimeMillis;
            nativeRuntime.toXContent(builder, params);
        this.nativeRuntime = in.readOptionalWriteable(ParquetNativeRuntimeStats::new);
        long nativeWriteTotal,
            nativeFinalizeTotal,
            docsIndexedTotal,
            flushAndSortChunkTotal,
            this.mergeFailures + other.mergeFailures,
        long backgroundWriteTimeouts,
        long indexTimeMillis,
        out.writeVLong(flushAndSortChunkTotal);
import org.opensearch.plugin.stats.DataFormatShardStats;
    public static ParquetShardStats empty() {
 * Immutable point-in-time snapshot of shard-level Parquet statistics.
    }
        @Nullable ParquetIngestPoolStats ingestPool
import org.opensearch.common.Nullable;
     */
        builder.field("background_write_failures", backgroundWriteFailures);
    // Native Runtime (node-level only, null on shard trackers and cross-node aggregation)
            vsrRotationsTotal,
    private final long nativeWriteTimeMillis;
        // Indexing
        long vsrRotationsTotal,
            backgroundWriteTimeouts,
    private final long nativeFinalizeTotal;
        builder.field("native_write_failures", nativeWriteFailures);
            this.flushAndSortChunkTotal + other.flushAndSortChunkTotal,
        // Merge
        out.writeVLong(nativeWriteTotal);
}
        builder.field("row_id_mapping_max", rowIdMappingMax);
            mergeInputFilesTotal,
    private final long nativeWriteRejections;
        return new ParquetShardStats(
            rowIdMappingMax,
        // Native Write
            this.nativeFinalizeFailures + other.nativeFinalizeFailures,
        this.nativeWriteFailures = nativeWriteFailures;
        this.mergeOutputRowsTotal = in.readVLong();
        this.mergeTotal = in.readVLong();
            mergeOutputRowsTotal,
     * Constructs a snapshot with all values including optional native runtime stats.
     * Returns a new snapshot that is the sum of this snapshot and another.
import org.opensearch.core.common.io.stream.StreamInput;
    }
        this.mergeFailures = mergeFailures;
            this.mergeInputFilesTotal + other.mergeInputFilesTotal,
     */
        @Nullable ParquetNativeRuntimeStats nativeRuntime,
import org.opensearch.core.xcontent.ToXContentFragment;
        long mergeTimeMillis,
        builder.endObject();
            mergeFailures,
            runtime,
    private final long flushAndSortChunkTimeMillis;
        out.writeVLong(nativeFinalizeFailures);
        // Background Write
        this.nativeWriteTotal = in.readVLong();
            this.nativeWriteRejections + other.nativeWriteRejections,
        long backgroundWriteWaitMillis,
        builder.field("native_write_rejections", nativeWriteRejections);
        this.nativeWriteTotal = nativeWriteTotal;
    private final long backgroundWriteTotal;
            this.nativeFinalizeTotal + other.nativeFinalizeTotal,
    private final long backgroundWriteTimeouts;
     */
    }
    private final long nativeWriteTotal;
    // Indexing
        this.nativeFinalizeFailures = nativeFinalizeFailures;
        long rowIdMappingMax,
        this.indexTimeMillis = indexTimeMillis;
        this.nativeFinalizeTotal = in.readVLong();
        builder.startObject("vsr");
            backgroundWriteWaitMillis,
        out.writeVLong(vsrRotationsTotal);
        return new ParquetShardStats(
        out.writeVLong(mergeTotal);
    /**
        long flushAndSortChunkTotal,
    private final long rowIdMappingMax;
    }
    /**
        builder.startObject("indexing");
        long backgroundWriteFailures
        out.writeVLong(backgroundWriteTimeouts);
    private final long mergeFailures;
            mergeTimeMillis,
        }
        this.nativeWriteTimeMillis = nativeWriteTimeMillis;
        out.writeVLong(backgroundWriteWaitMillis);
        // Native Runtime
     * {@link ParquetStatsProvider} to decorate the per-node aggregate; either argument may be null.
 */
    // Writes rejected by the parquet_native_write pool when its bounded queue is full.
        builder.field("background_write_timeouts", backgroundWriteTimeouts);
    private final ParquetNativeRuntimeStats nativeRuntime;
        // Background Write
            this.nativeWriteTotal + other.nativeWriteTotal,
     * Constructs a snapshot with all values.
            nativeWriteRejections,
            nativeWriteTotal,
            this.nativeWriteFailures + other.nativeWriteFailures,
            this.backgroundWriteFailures + other.backgroundWriteFailures,
        long nativeWriteTimeMillis,
        this.nativeWriteTimeMillis = in.readVLong();
        long mergeTotal,
        this.mergeInputFilesTotal = in.readVLong();
        out.writeVLong(mergeInputFilesTotal);
            nativeWriteTimeMillis,
public class ParquetShardStats implements DataFormatShardStats<ParquetShardStats> {
        this.rowIdMappingMax = rowIdMappingMax;
            ingestPool.toXContent(builder, params);
        builder.field("native_write_total", nativeWriteTotal);
            this.backgroundWriteTotal + other.backgroundWriteTotal,
/**
    private final long backgroundWriteWaitMillis;
            this.docsIndexedTotal + other.docsIndexedTotal,
        out.writeVLong(mergeFailures);
        long flushAndSortChunkTimeMillis,
        this.nativeRuntime = nativeRuntime;
        out.writeVLong(flushAndSortChunkTimeMillis);
    private final long backgroundWriteFailures;
            vsrRotationsTotal,
        long backgroundWriteTotal,
            nativeWriteFailures,
        if (nativeRuntime != null) {
        long mergeTotal,
        long nativeFinalizeFailures,
 * Supports serialization via {@link Writeable} and REST rendering via {@link ToXContentFragment}.
        this.nativeWriteRejections = in.readVLong();
        out.writeVLong(nativeWriteTimeMillis);
            this.flushAndSortChunkTimeMillis + other.flushAndSortChunkTimeMillis,
        this.backgroundWriteFailures = backgroundWriteFailures;
        this.mergeTotal = mergeTotal;
        long nativeWriteRejections,
        builder.field("native_finalize_failures", nativeFinalizeFailures);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        builder.field("flush_and_sort_chunk_time_millis", flushAndSortChunkTimeMillis);
            nativeWriteFailures,
        builder.field("merge_failures", mergeFailures);
        long nativeFinalizeTimeMillis,
        this.backgroundWriteWaitMillis = in.readVLong();
    @Nullable
            nativeFinalizeFailures,
        builder.field("merge_input_files_total", mergeInputFilesTotal);
        out.writeVLong(indexTimeMillis);
        this.mergeTimeMillis = in.readVLong();
    /**
        if (ingestPool != null) {
    private final long mergeOutputRowsTotal;
            mergeFailures,
            this.mergeOutputRowsTotal + other.mergeOutputRowsTotal,
            nativeWriteTimeMillis,
 * The OpenSearch Contributors require contributions made to
            this.mergeTimeMillis + other.mergeTimeMillis,
        builder.field("merge_output_rows_total", mergeOutputRowsTotal);
        long mergeOutputRowsTotal,
        builder.field("background_write_wait_millis", backgroundWriteWaitMillis);
        long mergeTimeMillis,
        builder.field("merge_total", mergeTotal);
 * compatible open source license.
        this.vsrRotationsTotal = vsrRotationsTotal;
        this.nativeFinalizeFailures = in.readVLong();
        out.writeVLong(mergeOutputRowsTotal);
 * SPDX-License-Identifier: Apache-2.0
        // Native Runtime
     */
        long mergeFailures,
        long flushAndSortChunkTimeMillis,
        out.writeVLong(backgroundWriteFailures);
import java.io.IOException;
        this.mergeTimeMillis = mergeTimeMillis;
        long backgroundWriteTotal,
        this.backgroundWriteTotal = backgroundWriteTotal;
            mergeInputFilesTotal,
    }
            nativeFinalizeTimeMillis,
        builder.startObject("merge");
     * Used by transport actions when a shard does not have a Parquet primary delegate.
            backgroundWriteTotal,
        out.writeVLong(nativeFinalizeTimeMillis);
            rowIdMappingMax,
            mergeOutputRowsTotal,
        // Background Write
        this.ingestPool = in.readOptionalWriteable(ParquetIngestPoolStats::new);
            nativeFinalizeFailures,
        out.writeVLong(nativeWriteFailures);
            null
        builder.field("merge_time_millis", mergeTimeMillis);
            null,
 *
        builder.field("index_time_millis", indexTimeMillis);
        );
    public ParquetShardStats(
    private final long mergeInputFilesTotal;
import org.opensearch.core.common.io.stream.StreamOutput;
        this.mergeFailures = in.readVLong();
        long mergeInputFilesTotal,
    private final long nativeWriteFailures;
        builder.field("background_write_total", backgroundWriteTotal);
        out.writeVLong(nativeWriteRejections);
        long mergeOutputRowsTotal,
            null   // drop ingestPool on cross-node aggregation
        // VSR
    /**
        long nativeFinalizeTimeMillis,
        this.mergeInputFilesTotal = mergeInputFilesTotal;
        builder.field("native_write_time_millis", nativeWriteTimeMillis);
            docsIndexedTotal,
        long indexTimeMillis,
    // Highest row_id assigned during any merge of this shard (max-of-maxes when cross-aggregated).
    public ParquetShardStats(StreamInput in) throws IOException {
        long rowIdMappingMax,
            this.nativeFinalizeTimeMillis + other.nativeFinalizeTimeMillis,
        // VSR
            // row_id_mapping_max composes as max-of-maxes (sum is meaningless for a max).
            nativeWriteRejections,
        this.flushAndSortChunkTimeMillis = flushAndSortChunkTimeMillis;
            this.backgroundWriteTimeouts + other.backgroundWriteTimeouts,
    }
    // Per-merge: cumulative count + millis for the flush+sort+chunk pass that runs inside each merge.
        out.writeVLong(backgroundWriteTotal);
 */
 * @opensearch.experimental
     * Returns an empty ParquetShardStats snapshot with all zero counters.
            mergeTimeMillis,
     */
        long nativeFinalizeFailures,
import org.opensearch.core.common.io.stream.Writeable;
            this.vsrRotationsTotal + other.vsrRotationsTotal,
        this.backgroundWriteTotal = in.readVLong();
    private final long flushAndSortChunkTotal;
        out.writeOptionalWriteable(nativeRuntime);
            this.indexTimeMillis + other.indexTimeMillis,
        return builder;
        builder.field("flush_and_sort_chunk_total", flushAndSortChunkTotal);
 *
import org.opensearch.common.annotation.ExperimentalApi;
            pool
        this.flushAndSortChunkTotal = in.readVLong();
    // Native Write
     * Returns a copy of this with the node-level runtime and ingest-pool stats attached. Used by
    private final ParquetIngestPoolStats ingestPool;
        long backgroundWriteFailures,
            indexTimeMillis,
    private final long nativeFinalizeFailures;
            indexTimeMillis,
        }
        // Native Write
    public ParquetShardStats(
        out.writeVLong(rowIdMappingMax);
        return new ParquetShardStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    public ParquetShardStats add(ParquetShardStats other) {
    @Override
/*
        );
        this.flushAndSortChunkTimeMillis = in.readVLong();
        this.nativeWriteRejections = nativeWriteRejections;
    private final long indexTimeMillis;
        // Ingest thread-pool (only present at node-level aggregate)
        this.docsIndexedTotal = docsIndexedTotal;
        long nativeWriteFailures,
    public void writeTo(StreamOutput out) throws IOException {
        long nativeFinalizeTotal,
    @Override
        builder.endObject();
        builder.startObject("background_write");
        builder.field("native_finalize_total", nativeFinalizeTotal);
            backgroundWriteTotal,
            this.backgroundWriteWaitMillis + other.backgroundWriteWaitMillis,
        this.ingestPool = ingestPool;
    ) {
        long vsrRotationsTotal,
        builder.field("vsr_rotations_total", vsrRotationsTotal);
        long docsIndexedTotal,
        // Merge
    }
        builder.field("native_finalize_time_millis", nativeFinalizeTimeMillis);
            backgroundWriteTimeouts,
            flushAndSortChunkTimeMillis,
        this.indexTimeMillis = in.readVLong();
        builder.endObject();
            nativeFinalizeTimeMillis,
        // Indexing
     * Used for aggregation across shards.
        // Indexing
    // Background Write
        this.nativeFinalizeTotal = nativeFinalizeTotal;
        this.backgroundWriteWaitMillis = backgroundWriteWaitMillis;
    /**
        this(
import org.opensearch.core.xcontent.XContentBuilder;
        this.nativeFinalizeTimeMillis = nativeFinalizeTimeMillis;
            nativeFinalizeTotal,
@ExperimentalApi
    private final long nativeFinalizeTimeMillis;
        // Native Write
            backgroundWriteFailures,
        this.vsrRotationsTotal = in.readVLong();
 * Produced by {@link ParquetShardStatsTracker#stats()}.
        out.writeOptionalWriteable(ingestPool);
            backgroundWriteFailures,
        this.backgroundWriteTimeouts = backgroundWriteTimeouts;
        out.writeVLong(mergeTimeMillis);
        this.docsIndexedTotal = in.readVLong();
 * this file be licensed under the Apache-2.0 license or a
    // VSR Pipeline
            null,  // drop nativeRuntime on cross-node aggregation
            flushAndSortChunkTimeMillis,
            mergeTotal,
        long backgroundWriteWaitMillis,
    ) {
    // Merge
    public ParquetShardStats withNodeStats(ParquetNativeRuntimeStats runtime, ParquetIngestPoolStats pool) {
        // Merge
        // Native Runtime (only present at node-level aggregate)
        builder.field("docs_indexed_total", docsIndexedTotal);
        long nativeWriteFailures,
        );
    // Ingest thread-pool snapshot (node-level only, null on shard trackers and cross-node aggregation)
            mergeTotal,
        long nativeWriteRejections,
        // VSR
        this.nativeWriteFailures = in.readVLong();
