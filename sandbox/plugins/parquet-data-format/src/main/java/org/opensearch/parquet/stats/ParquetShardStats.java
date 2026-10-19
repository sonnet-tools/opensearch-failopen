    private final long nativeWriteRejections;
    public ParquetShardStats(
        // Background Write
        long backgroundWriteTimeouts,
    }  
    public ParquetShardStats(StreamInput in) throws IOException {  
        this.backgroundWriteFailures = in.readVLong();
        this.indexTimeMillis = in.readVLong();  
            this.nativeWriteFailures + other.nativeWriteFailures,
        long backgroundWriteWaitMillis,  
        // Ingest thread-pool (only present at node-level aggregate)  
        this.docsIndexedTotal = in.readVLong();
     * Returns a new snapshot that is the sum of this snapshot and another.  
        builder.field("index_time_millis", indexTimeMillis);
        builder.startObject("vsr");
    /**
            this.backgroundWriteTotal + other.backgroundWriteTotal,
    @Nullable
 * this file be licensed under the Apache-2.0 license or a
    @Override
        this.nativeFinalizeTimeMillis = nativeFinalizeTimeMillis;  
     */
            nativeFinalizeTotal,  
        this.nativeRuntime = nativeRuntime;
        long backgroundWriteWaitMillis,
    private final long nativeWriteTimeMillis;
        long nativeWriteRejections,  
        this.nativeWriteTimeMillis = in.readVLong();
        out.writeVLong(nativeFinalizeTimeMillis);
        builder.field("row_id_mapping_max", rowIdMappingMax);
            this.vsrRotationsTotal + other.vsrRotationsTotal,
            indexTimeMillis,  
        this.mergeOutputRowsTotal = in.readVLong();
        out.writeVLong(docsIndexedTotal);
    private final long vsrRotationsTotal;  
     * Used for aggregation across shards.
        return new ParquetShardStats(  
        builder.field("merge_failures", mergeFailures);  
        out.writeVLong(nativeFinalizeTotal);
        this.backgroundWriteTotal = in.readVLong();
    // VSR Pipeline
import org.opensearch.common.annotation.ExperimentalApi;
     * Returns a copy of this with the node-level runtime and ingest-pool stats attached. Used by
        this.flushAndSortChunkTimeMillis = flushAndSortChunkTimeMillis;
        out.writeVLong(nativeWriteFailures);
     * Used by transport actions when a shard does not have a Parquet primary delegate.
        this.vsrRotationsTotal = vsrRotationsTotal;  
     */
        long nativeWriteRejections,
    private final long nativeWriteTotal;  
        long mergeTotal,  
        long vsrRotationsTotal,
            backgroundWriteTimeouts,  
        long nativeFinalizeFailures,
import org.opensearch.core.common.io.stream.Writeable;
    /**
        builder.field("background_write_total", backgroundWriteTotal);
        long nativeWriteFailures,
            rowIdMappingMax,  
        builder.startObject("merge");  
        builder.field("flush_and_sort_chunk_time_millis", flushAndSortChunkTimeMillis);
        }  
    private final long flushAndSortChunkTimeMillis;
    private final ParquetNativeRuntimeStats nativeRuntime;
            this.mergeInputFilesTotal + other.mergeInputFilesTotal,
    // Per-merge: cumulative count + millis for the flush+sort+chunk pass that runs inside each merge.  
        }
        out.writeVLong(mergeInputFilesTotal);  
            this.nativeWriteRejections + other.nativeWriteRejections,  
        this.rowIdMappingMax = in.readVLong();
        // VSR
        @Nullable ParquetIngestPoolStats ingestPool
        out.writeOptionalWriteable(ingestPool);
 * The OpenSearch Contributors require contributions made to  
        out.writeVLong(nativeWriteTimeMillis);
            mergeOutputRowsTotal,  
        this.nativeWriteTimeMillis = nativeWriteTimeMillis;
            ingestPool.toXContent(builder, params);
            backgroundWriteTotal,
            backgroundWriteWaitMillis,
        out.writeVLong(mergeTimeMillis);
        if (nativeRuntime != null) {
 */  
     * Constructs a snapshot with all values.
        builder.startObject("native_write");
    private final long nativeFinalizeTotal;
        long nativeFinalizeTotal,  
        this.flushAndSortChunkTotal = in.readVLong();
        builder.field("native_write_rejections", nativeWriteRejections);
        builder.field("native_write_time_millis", nativeWriteTimeMillis);  
        this.nativeFinalizeTotal = in.readVLong();
        out.writeVLong(mergeOutputRowsTotal);
            this.mergeTimeMillis + other.mergeTimeMillis,
import org.opensearch.core.xcontent.XContentBuilder;
            nativeFinalizeTimeMillis,  
        this.backgroundWriteFailures = backgroundWriteFailures;
     * {@link ParquetStatsProvider} to decorate the per-node aggregate; either argument may be null.  
    private final long nativeFinalizeFailures;
    }  
        builder.endObject();  
            this.nativeWriteTimeMillis + other.nativeWriteTimeMillis,
        builder.field("merge_total", mergeTotal);
        builder.field("background_write_timeouts", backgroundWriteTimeouts);  
            this.backgroundWriteWaitMillis + other.backgroundWriteWaitMillis,
        builder.field("native_write_total", nativeWriteTotal);
        long mergeOutputRowsTotal,
        this.nativeWriteRejections = nativeWriteRejections;
        long mergeTimeMillis,
        this.mergeInputFilesTotal = in.readVLong();  
        this.docsIndexedTotal = docsIndexedTotal;
            pool  
    private final long mergeInputFilesTotal;
    /**
 *
        this.nativeFinalizeFailures = nativeFinalizeFailures;
    public void writeTo(StreamOutput out) throws IOException {  
        out.writeVLong(backgroundWriteTotal);
        long rowIdMappingMax,
        this.nativeWriteFailures = nativeWriteFailures;  
        long flushAndSortChunkTimeMillis,
        this.nativeWriteFailures = in.readVLong();
     * Returns an empty ParquetShardStats snapshot with all zero counters.  
            this.nativeFinalizeTimeMillis + other.nativeFinalizeTimeMillis,
            this.flushAndSortChunkTimeMillis + other.flushAndSortChunkTimeMillis,
            vsrRotationsTotal,  
            docsIndexedTotal,
        // Indexing
        long mergeFailures,
            nativeWriteRejections,
        // Indexing
            nativeFinalizeFailures,
            mergeFailures,
    private final long rowIdMappingMax;
            this.backgroundWriteFailures + other.backgroundWriteFailures,
        builder.field("merge_input_files_total", mergeInputFilesTotal);
    // Ingest thread-pool snapshot (node-level only, null on shard trackers and cross-node aggregation)
            this.flushAndSortChunkTotal + other.flushAndSortChunkTotal,  
        this.backgroundWriteTimeouts = backgroundWriteTimeouts;  
    @Nullable
import org.opensearch.core.xcontent.ToXContentFragment;  
        out.writeVLong(nativeWriteRejections);  
    }
        this.mergeOutputRowsTotal = mergeOutputRowsTotal;  
            this.mergeOutputRowsTotal + other.mergeOutputRowsTotal,
            this.mergeFailures + other.mergeFailures,  
import org.opensearch.core.common.io.stream.StreamOutput;
        long mergeFailures,  
/**  
        // VSR
            Math.max(this.rowIdMappingMax, other.rowIdMappingMax),  
        out.writeVLong(mergeTotal);  
        out.writeVLong(backgroundWriteTimeouts);  
    // Native Runtime (node-level only, null on shard trackers and cross-node aggregation)  
            backgroundWriteWaitMillis,  
    }
    public ParquetShardStats add(ParquetShardStats other) {
            this.indexTimeMillis + other.indexTimeMillis,
    private final long docsIndexedTotal;
}  
    private final long mergeTimeMillis;
        out.writeVLong(indexTimeMillis);  
        // Merge
        builder.startObject("indexing");
        builder.field("merge_output_rows_total", mergeOutputRowsTotal);
            mergeTotal,  
            vsrRotationsTotal,
        long mergeTotal,
        out.writeVLong(flushAndSortChunkTotal);
            this.nativeFinalizeTotal + other.nativeFinalizeTotal,
    }
            nativeFinalizeTotal,
        out.writeOptionalWriteable(nativeRuntime);
        long indexTimeMillis,
    // Background Write  
        // Native Runtime  
        this.flushAndSortChunkTimeMillis = in.readVLong();  
    // Highest row_id assigned during any merge of this shard (max-of-maxes when cross-aggregated).  
        @Nullable ParquetNativeRuntimeStats nativeRuntime,
            rowIdMappingMax,
        out.writeVLong(nativeFinalizeFailures);  
    private final ParquetIngestPoolStats ingestPool;  
        long docsIndexedTotal,
            mergeOutputRowsTotal,
        this.ingestPool = in.readOptionalWriteable(ParquetIngestPoolStats::new);
        long nativeWriteTotal,
    }  
 * Supports serialization via {@link Writeable} and REST rendering via {@link ToXContentFragment}.  
            backgroundWriteTotal,
        // Native Write
        this.nativeFinalizeTotal = nativeFinalizeTotal;
        this.nativeRuntime = in.readOptionalWriteable(ParquetNativeRuntimeStats::new);
        return builder;
    private final long nativeFinalizeTimeMillis;  
        this.mergeInputFilesTotal = mergeInputFilesTotal;
    public ParquetShardStats(
        this.mergeFailures = mergeFailures;
        long flushAndSortChunkTimeMillis,  
    // Writes rejected by the parquet_native_write pool when its bounded queue is full.  
        this.nativeFinalizeTimeMillis = in.readVLong();
        // VSR
    // Indexing
            docsIndexedTotal,
            flushAndSortChunkTimeMillis,
            mergeTimeMillis,
        long backgroundWriteTotal,  
        this.rowIdMappingMax = rowIdMappingMax;  
package org.opensearch.parquet.stats;
        this.nativeFinalizeFailures = in.readVLong();  
            backgroundWriteFailures,
            nativeWriteFailures,  
 * SPDX-License-Identifier: Apache-2.0
    /**
    @Override
            null
    ) {  
        out.writeVLong(backgroundWriteFailures);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            indexTimeMillis,
        this.nativeWriteTotal = nativeWriteTotal;
    }  
    private final long mergeOutputRowsTotal;
        this.backgroundWriteWaitMillis = in.readVLong();
            mergeInputFilesTotal,  
        long nativeFinalizeTimeMillis,
        this.backgroundWriteTotal = backgroundWriteTotal;
    private final long nativeWriteFailures;
        long rowIdMappingMax,
            nativeWriteTimeMillis,  
            // row_id_mapping_max composes as max-of-maxes (sum is meaningless for a max).
        this.mergeTimeMillis = mergeTimeMillis;  
            nativeRuntime.toXContent(builder, params);  
     * Constructs a snapshot with all values including optional native runtime stats.  
            mergeTimeMillis,  
        this.mergeTimeMillis = in.readVLong();
        long indexTimeMillis,  
    private final long mergeFailures;  
    private final long mergeTotal;
        long backgroundWriteFailures
    private final long backgroundWriteTotal;
 *
 * @opensearch.experimental
        this.indexTimeMillis = indexTimeMillis;
        );
 * compatible open source license.
    }
        // Native Write  
        // Background Write  
    private final long backgroundWriteTimeouts;  
import java.io.IOException;
        long vsrRotationsTotal,
        this.backgroundWriteWaitMillis = backgroundWriteWaitMillis;
    // Native Write
        long backgroundWriteTotal,
     */  
        );
        long flushAndSortChunkTotal,  
            nativeFinalizeFailures,
 */  
        long mergeOutputRowsTotal,
        // Indexing
            flushAndSortChunkTotal,
        return new ParquetShardStats(
        builder.field("merge_time_millis", mergeTimeMillis);
            nativeWriteFailures,
        long nativeWriteTimeMillis,  
        builder.field("native_finalize_total", nativeFinalizeTotal);  
        builder.field("native_finalize_failures", nativeFinalizeFailures);
        this(
        out.writeVLong(flushAndSortChunkTimeMillis);  
        long nativeFinalizeTimeMillis,
        long mergeInputFilesTotal,
 * Immutable point-in-time snapshot of shard-level Parquet statistics.
            this.nativeWriteTotal + other.nativeWriteTotal,  
            flushAndSortChunkTimeMillis,  
        builder.field("background_write_wait_millis", backgroundWriteWaitMillis);
        long mergeTimeMillis,
        out.writeVLong(nativeWriteTotal);  
            nativeFinalizeTimeMillis,
            null,  // drop nativeRuntime on cross-node aggregation
        this.mergeTotal = in.readVLong();  
        builder.endObject();
        // Merge
        // Native Write
        // Background Write  
        long nativeWriteFailures,
        this.flushAndSortChunkTotal = flushAndSortChunkTotal;
        out.writeVLong(rowIdMappingMax);
        this.nativeWriteTotal = in.readVLong();  
    ) {  
import org.opensearch.plugin.stats.DataFormatShardStats;
            this.backgroundWriteTimeouts + other.backgroundWriteTimeouts,  
    @Override  
        long nativeWriteTimeMillis,
        this.ingestPool = ingestPool;  
        builder.field("native_finalize_time_millis", nativeFinalizeTimeMillis);
        builder.field("background_write_failures", backgroundWriteFailures);
            mergeFailures,
    private final long indexTimeMillis;  
        // Native Runtime (only present at node-level aggregate)
            nativeWriteTotal,
            backgroundWriteTimeouts,
            this.mergeTotal + other.mergeTotal,
            runtime,
        long nativeFinalizeTotal,
        out.writeVLong(mergeFailures);
        long flushAndSortChunkTotal,
        if (ingestPool != null) {
        long nativeFinalizeFailures,  
        long backgroundWriteFailures,  
            flushAndSortChunkTotal,
        return new ParquetShardStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    // Merge  
@ExperimentalApi
     */
            nativeWriteRejections,
    public static ParquetShardStats empty() {  
        );
        out.writeVLong(vsrRotationsTotal);  
    /**
        builder.endObject();
        builder.startObject("background_write");  
        this.mergeTotal = mergeTotal;
        out.writeVLong(backgroundWriteWaitMillis);
/*  
public class ParquetShardStats implements DataFormatShardStats<ParquetShardStats> {
    private final long flushAndSortChunkTotal;
            this.docsIndexedTotal + other.docsIndexedTotal,  
        builder.endObject();  
            nativeWriteTotal,
        // Merge
        // Native Runtime  
    private final long backgroundWriteWaitMillis;
            mergeInputFilesTotal,
        this.nativeWriteRejections = in.readVLong();  
        long nativeWriteTotal,  
            mergeTotal,
        builder.field("docs_indexed_total", docsIndexedTotal);  
    public ParquetShardStats withNodeStats(ParquetNativeRuntimeStats runtime, ParquetIngestPoolStats pool) {
            this.nativeFinalizeFailures + other.nativeFinalizeFailures,  
        long backgroundWriteTimeouts,
import org.opensearch.core.common.io.stream.StreamInput;  
        builder.field("flush_and_sort_chunk_total", flushAndSortChunkTotal);  
        builder.field("native_write_failures", nativeWriteFailures);
            null,  
            backgroundWriteFailures,
import org.opensearch.common.Nullable;
    private final long backgroundWriteFailures;
        this.mergeFailures = in.readVLong();
        builder.field("vsr_rotations_total", vsrRotationsTotal);  
 * Produced by {@link ParquetShardStatsTracker#stats()}.
            nativeWriteTimeMillis,
            null   // drop ingestPool on cross-node aggregation  
     */
        this.backgroundWriteTimeouts = in.readVLong();  
        long mergeInputFilesTotal,  
        builder.endObject();
        this.vsrRotationsTotal = in.readVLong();  
        long docsIndexedTotal,  
