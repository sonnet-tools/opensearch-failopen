            && prefetchWaitCount == that.prefetchWaitCount
    public final long prefetchWaitCount;
        builder.field("object_store_read_time_ms", objectStoreReadTimeMs);
    ) {
            && objectStoreReadTimeMs == that.objectStoreReadTimeMs;
 */
        this.rgSkipped = in.readVLong();
        builder.field("parquet_processing_time_ms", parquetProcessingTimeMs);
 * this file be licensed under the Apache-2.0 license or a
            && filterRecordBatchTimeMs == that.filterRecordBatchTimeMs
        this.prefetchWaitTimeMs = prefetchWaitTimeMs;
        long buildMaskTimeMs,
        this.onBatchMaskTimeMs = onBatchMaskTimeMs;
    public final long onBatchMaskTimeMs;
        builder.field("elapsed_compute_ms", elapsedComputeMs);
import org.opensearch.core.common.io.stream.StreamInput;
            && rgProcessed == that.rgProcessed
        builder.field("parquet_bytes_scanned", parquetBytesScanned);
    public final long elapsedComputeMs;
        this.buildMaskTimeMs = buildMaskTimeMs;
        builder.field("prefetch_wait_time_ms", prefetchWaitTimeMs);
        out.writeVLong(buildMaskTimeMs);
    }
 * reset between calls.
            rgProcessed,
 * {@code search_stats} key. Each field is a process-global running total
        SearchStats that = (SearchStats) o;
    }
        builder.field("bitmap_tree_scan", bitmapTreeScan);
    public final long buildMaskTimeMs;
    public final long filterRecordBatchTimeMs;
        return listingTableScan == that.listingTableScan
            bitmapTreeScan,
        this.rgSkipped = rgSkipped;
        out.writeVLong(parquetProcessingTimeMs);
            && parquetScanTotalTimeMs == that.parquetScanTotalTimeMs
    public final long listingTableScan;
    }
            delegationCalls,
        this.filterRecordBatchTimeMs = filterRecordBatchTimeMs;
        out.writeVLong(objectStoreReadTimeMs);
        return Objects.hash(
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        out.writeVLong(rgProcessed);
            buildMaskTimeMs,
            && rgSkipped == that.rgSkipped
        this.bitmapTreeScan = bitmapTreeScan;
        builder.field("rg_processed", rgProcessed);
        out.writeVLong(elapsedComputeMs);
        this.delegationCalls = delegationCalls;
            onBatchMaskTimeMs,
        out.writeVLong(onBatchMaskTimeMs);
            elapsedComputeMs,
        long prefetchWaitTimeMs,
        out.writeVLong(parquetScanTotalTimeMs);
        this.listingTableScan = in.readVLong();
            objectStoreReadTimeMs
        builder.field("filter_record_batch_time_ms", filterRecordBatchTimeMs);
        builder.field("parquet_scan_total_time_ms", parquetScanTotalTimeMs);
        out.writeVLong(filterRecordBatchTimeMs);
/*
    public final long delegationCalls;
        long listingTableScan,
    public void writeTo(StreamOutput out) throws IOException {
            rgSkipped,
            && parquetBytesScanned == that.parquetBytesScanned
        builder.startObject("search_stats");
        long rgSkipped,
        long elapsedComputeMs,
        this.buildMaskTimeMs = in.readVLong();
        this.objectStoreReadTimeMs = objectStoreReadTimeMs;
        this.filterRecordBatchTimeMs = in.readVLong();
        this.rgProcessed = rgProcessed;
        long delegationCalls,
        if (o == null || getClass() != o.getClass()) return false;
        builder.field("delegation_calls", delegationCalls);
        this.prefetchWaitTimeMs = in.readVLong();
            singleCollectorScan,
    public final long rgProcessed;
    }
        long prefetchWaitCount,
        out.writeVLong(parquetScanUntilDataTimeMs);
        out.writeVLong(prefetchWaitCount);
        out.writeVLong(parquetBytesScanned);
        this.bitmapTreeScan = in.readVLong();
        builder.field("on_batch_mask_time_ms", onBatchMaskTimeMs);
        builder.field("prefetch_wait_count", prefetchWaitCount);
        out.writeVLong(prefetchWaitTimeMs);
            && parquetProcessingTimeMs == that.parquetProcessingTimeMs
            && prefetchWaitTimeMs == that.prefetchWaitTimeMs
        long singleCollectorScan,
        long parquetScanUntilDataTimeMs,
        this.parquetScanTotalTimeMs = parquetScanTotalTimeMs;
 * summed across all partitions and queries since startup; values are never
import org.opensearch.core.xcontent.ToXContentFragment;
    public int hashCode() {
 * The OpenSearch Contributors require contributions made to
        if (this == o) return true;
        this.rgProcessed = in.readVLong();
    }
        long bitmapTreeScan,
        builder.field("listing_table_scan", listingTableScan);
        return builder;
package org.opensearch.be.datafusion.stats;
        this.elapsedComputeMs = in.readVLong();
 * Node-level cumulative search execution counters exposed under the
            && elapsedComputeMs == that.elapsedComputeMs
            prefetchWaitCount,
 * compatible open source license.
        this.objectStoreReadTimeMs = in.readVLong();
}
            parquetBytesScanned,
    @Override
        out.writeVLong(bitmapTreeScan);
            && bitmapTreeScan == that.bitmapTreeScan
        this.parquetProcessingTimeMs = in.readVLong();
    public final long rgSkipped;
            && delegationCalls == that.delegationCalls
 */
        this.singleCollectorScan = in.readVLong();
        long rgProcessed,
        builder.endObject();
    @Override
        out.writeVLong(rgSkipped);
            filterRecordBatchTimeMs,
    public final long singleCollectorScan;
            && singleCollectorScan == that.singleCollectorScan
            && onBatchMaskTimeMs == that.onBatchMaskTimeMs
/**
        builder.field("single_collector_scan", singleCollectorScan);
            parquetProcessingTimeMs,
        long objectStoreReadTimeMs
        long parquetBytesScanned,
    public SearchStats(
        builder.field("build_mask_time_ms", buildMaskTimeMs);
 * SPDX-License-Identifier: Apache-2.0
        this.elapsedComputeMs = elapsedComputeMs;
import java.io.IOException;
    public final long prefetchWaitTimeMs;
    }
    @Override
            parquetScanUntilDataTimeMs,
        this.prefetchWaitCount = in.readVLong();
        builder.field("parquet_scan_until_data_time_ms", parquetScanUntilDataTimeMs);
        long parquetScanTotalTimeMs,
    public final long parquetProcessingTimeMs;
    @Override
            && buildMaskTimeMs == that.buildMaskTimeMs
    public boolean equals(Object o) {
    public final long parquetBytesScanned;
        builder.field("rg_skipped", rgSkipped);
        long onBatchMaskTimeMs,
        this.parquetBytesScanned = parquetBytesScanned;
        out.writeVLong(listingTableScan);
        this.onBatchMaskTimeMs = in.readVLong();
public class SearchStats implements Writeable, ToXContentFragment {
    public final long bitmapTreeScan;
        this.prefetchWaitCount = prefetchWaitCount;
        out.writeVLong(singleCollectorScan);
        this.delegationCalls = in.readVLong();
        this.parquetScanTotalTimeMs = in.readVLong();
        this.parquetBytesScanned = in.readVLong();
import java.util.Objects;
        this.parquetScanUntilDataTimeMs = in.readVLong();
        long parquetProcessingTimeMs,
import org.opensearch.core.common.io.stream.StreamOutput;
            prefetchWaitTimeMs,
            && parquetScanUntilDataTimeMs == that.parquetScanUntilDataTimeMs
            parquetScanTotalTimeMs,
 *
import org.opensearch.core.xcontent.XContentBuilder;
            listingTableScan,
    public SearchStats(StreamInput in) throws IOException {
        this.parquetScanUntilDataTimeMs = parquetScanUntilDataTimeMs;
import org.opensearch.core.common.io.stream.Writeable;
        this.listingTableScan = listingTableScan;
    public final long parquetScanUntilDataTimeMs;
        );
        long filterRecordBatchTimeMs,
    public final long objectStoreReadTimeMs;
    public final long parquetScanTotalTimeMs;
        out.writeVLong(delegationCalls);
        this.singleCollectorScan = singleCollectorScan;
        this.parquetProcessingTimeMs = parquetProcessingTimeMs;
