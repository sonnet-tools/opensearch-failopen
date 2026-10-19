    public final long filterRecordBatchTimeMs;  
 * SPDX-License-Identifier: Apache-2.0
    public SearchStats(StreamInput in) throws IOException {
        this.prefetchWaitCount = in.readVLong();
        builder.field("elapsed_compute_ms", elapsedComputeMs);
        out.writeVLong(elapsedComputeMs);  
        long delegationCalls,
            objectStoreReadTimeMs
 */  
    public final long parquetProcessingTimeMs;
        this.rgSkipped = in.readVLong();
        return listingTableScan == that.listingTableScan  
public class SearchStats implements Writeable, ToXContentFragment {
        long parquetBytesScanned,
 */  
/*  
        this.elapsedComputeMs = elapsedComputeMs;
        builder.field("filter_record_batch_time_ms", filterRecordBatchTimeMs);
            elapsedComputeMs,
            parquetScanTotalTimeMs,
        builder.field("prefetch_wait_count", prefetchWaitCount);  
        this.prefetchWaitCount = prefetchWaitCount;  
            && rgSkipped == that.rgSkipped
        this.delegationCalls = delegationCalls;
    public int hashCode() {
        this.buildMaskTimeMs = buildMaskTimeMs;
 * compatible open source license.
            prefetchWaitTimeMs,
        long buildMaskTimeMs,
    @Override
            && buildMaskTimeMs == that.buildMaskTimeMs
        long filterRecordBatchTimeMs,
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public final long delegationCalls;  
        this.objectStoreReadTimeMs = in.readVLong();
        long rgProcessed,
            && delegationCalls == that.delegationCalls  
            && parquetProcessingTimeMs == that.parquetProcessingTimeMs
 * The OpenSearch Contributors require contributions made to  
    public final long prefetchWaitTimeMs;
        builder.field("prefetch_wait_time_ms", prefetchWaitTimeMs);
        builder.endObject();  
        builder.field("rg_skipped", rgSkipped);  
        builder.field("single_collector_scan", singleCollectorScan);
        out.writeVLong(prefetchWaitTimeMs);
        out.writeVLong(objectStoreReadTimeMs);
            && onBatchMaskTimeMs == that.onBatchMaskTimeMs
        this.listingTableScan = in.readVLong();  
            listingTableScan,
        this.onBatchMaskTimeMs = in.readVLong();
    }
        this.parquetScanTotalTimeMs = in.readVLong();  
        this.listingTableScan = listingTableScan;
        out.writeVLong(onBatchMaskTimeMs);
import org.opensearch.core.xcontent.XContentBuilder;
        out.writeVLong(parquetProcessingTimeMs);
        this.elapsedComputeMs = in.readVLong();  
        builder.field("listing_table_scan", listingTableScan);
        this.filterRecordBatchTimeMs = filterRecordBatchTimeMs;
            delegationCalls,
        return Objects.hash(  
        builder.field("parquet_scan_total_time_ms", parquetScanTotalTimeMs);
        builder.field("rg_processed", rgProcessed);
            parquetBytesScanned,
    public final long onBatchMaskTimeMs;
        builder.field("delegation_calls", delegationCalls);
        out.writeVLong(listingTableScan);  
            && singleCollectorScan == that.singleCollectorScan
            singleCollectorScan,
import org.opensearch.core.xcontent.ToXContentFragment;
        this.rgSkipped = rgSkipped;  
        );  
        out.writeVLong(parquetBytesScanned);  
        this.parquetScanUntilDataTimeMs = parquetScanUntilDataTimeMs;
            rgSkipped,  
            filterRecordBatchTimeMs,
 * {@code search_stats} key. Each field is a process-global running total  
    @Override
        out.writeVLong(bitmapTreeScan);
        out.writeVLong(rgSkipped);
        out.writeVLong(filterRecordBatchTimeMs);  
    }  
        builder.field("parquet_bytes_scanned", parquetBytesScanned);
    public final long listingTableScan;  
        this.buildMaskTimeMs = in.readVLong();
 * this file be licensed under the Apache-2.0 license or a
        builder.field("build_mask_time_ms", buildMaskTimeMs);
        builder.field("bitmap_tree_scan", bitmapTreeScan);  
        long objectStoreReadTimeMs
 * Node-level cumulative search execution counters exposed under the
    }
        long parquetScanUntilDataTimeMs,
        long prefetchWaitCount,  
        long onBatchMaskTimeMs,  
        long rgSkipped,  
        out.writeVLong(parquetScanUntilDataTimeMs);
            && rgProcessed == that.rgProcessed
    }
            parquetScanUntilDataTimeMs,
            && prefetchWaitCount == that.prefetchWaitCount
        this.parquetProcessingTimeMs = in.readVLong();
        out.writeVLong(singleCollectorScan);
        out.writeVLong(buildMaskTimeMs);
        builder.field("parquet_processing_time_ms", parquetProcessingTimeMs);  
        long bitmapTreeScan,  
    public final long rgProcessed;
import java.io.IOException;
            && bitmapTreeScan == that.bitmapTreeScan
            && elapsedComputeMs == that.elapsedComputeMs  
        this.bitmapTreeScan = bitmapTreeScan;  
        long parquetScanTotalTimeMs,
        this.objectStoreReadTimeMs = objectStoreReadTimeMs;
        builder.field("parquet_scan_until_data_time_ms", parquetScanUntilDataTimeMs);
        builder.field("on_batch_mask_time_ms", onBatchMaskTimeMs);  
import java.util.Objects;
    public SearchStats(  
    public final long parquetScanUntilDataTimeMs;
 * reset between calls.
            && prefetchWaitTimeMs == that.prefetchWaitTimeMs
        out.writeVLong(rgProcessed);
        this.onBatchMaskTimeMs = onBatchMaskTimeMs;  
            rgProcessed,
        if (o == null || getClass() != o.getClass()) return false;
        return builder;
        builder.startObject("search_stats");  
        long elapsedComputeMs,
import org.opensearch.core.common.io.stream.Writeable;  
        this.bitmapTreeScan = in.readVLong();
        this.rgProcessed = in.readVLong();
        out.writeVLong(parquetScanTotalTimeMs);  
        this.parquetScanUntilDataTimeMs = in.readVLong();
        long parquetProcessingTimeMs,  
    public final long singleCollectorScan;
            bitmapTreeScan,  
        long singleCollectorScan,
}
            && parquetBytesScanned == that.parquetBytesScanned  
        this.filterRecordBatchTimeMs = in.readVLong();  
        out.writeVLong(prefetchWaitCount);
    public final long parquetScanTotalTimeMs;  
            && filterRecordBatchTimeMs == that.filterRecordBatchTimeMs  
        this.prefetchWaitTimeMs = prefetchWaitTimeMs;
            && objectStoreReadTimeMs == that.objectStoreReadTimeMs;
    }
    public final long objectStoreReadTimeMs;
    @Override
package org.opensearch.be.datafusion.stats;
        this.prefetchWaitTimeMs = in.readVLong();
            prefetchWaitCount,  
    @Override
    public final long buildMaskTimeMs;
        this.parquetScanTotalTimeMs = parquetScanTotalTimeMs;
    public final long elapsedComputeMs;  
 *
        long prefetchWaitTimeMs,
    public final long rgSkipped;
        this.rgProcessed = rgProcessed;
    public final long bitmapTreeScan;
            parquetProcessingTimeMs,  
        builder.field("object_store_read_time_ms", objectStoreReadTimeMs);
    public void writeTo(StreamOutput out) throws IOException {
            && parquetScanTotalTimeMs == that.parquetScanTotalTimeMs  
        this.parquetBytesScanned = parquetBytesScanned;
import org.opensearch.core.common.io.stream.StreamOutput;
 * summed across all partitions and queries since startup; values are never
/**
        this.singleCollectorScan = in.readVLong();
        out.writeVLong(delegationCalls);  
        long listingTableScan,
        SearchStats that = (SearchStats) o;
        this.parquetBytesScanned = in.readVLong();  
    }
import org.opensearch.core.common.io.stream.StreamInput;
        this.singleCollectorScan = singleCollectorScan;
    public boolean equals(Object o) {
        this.delegationCalls = in.readVLong();  
    ) {  
    public final long prefetchWaitCount;
        this.parquetProcessingTimeMs = parquetProcessingTimeMs;  
            buildMaskTimeMs,
            && parquetScanUntilDataTimeMs == that.parquetScanUntilDataTimeMs
            onBatchMaskTimeMs,  
        if (this == o) return true;  
    public final long parquetBytesScanned;  
