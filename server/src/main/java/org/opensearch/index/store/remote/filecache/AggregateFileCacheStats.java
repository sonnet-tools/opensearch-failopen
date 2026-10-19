    }
    }
        static final String USED = "used";  
        this.pinnedFileCacheStats = pinnedFileCacheStats;  
        return overallFileCacheStats.getCacheHits();  
        static final String ACTIVE = "active";
import org.opensearch.core.common.io.stream.Writeable;
        return blockFileCacheStats;  
                .orElseThrow(() -> new IllegalArgumentException("Found invalid fileCacheStatsType."));
import org.opensearch.core.common.unit.ByteSizeValue;
            return fileCacheStatsType;  
 */  
        builder.humanReadableField(Fields.EVICTIONS_IN_BYTES, Fields.EVICTIONS, getEvicted());
import java.util.EnumSet;
        return fullFileCacheStats;
import java.io.IOException;  
    private final FileCacheStats fullFileCacheStats;  
        out.writeLong(timestamp);  
        BLOCK_FILE_STATS("block_file_stats"),  
                .filter(f -> f.fileCacheStatsType.equals(fileCacheStatsType))  
                .stream()
        return new ByteSizeValue(overallFileCacheStats.getEvicted());
    private final long timestamp;
/*  
        return builder;
        builder.humanReadableField(Fields.REMOVED_IN_BYTES, Fields.REMOVED, getRemoved());  
    }  
        OVER_ALL_STATS("over_all_stats"),
 * This class aggregates statistics across all cache segments including:
    }  
        static final String ACTIVE_IN_BYTES = "active_in_bytes";
        return calculatePercentage(overallFileCacheStats.getActive(), overallFileCacheStats.getUsed());
    public ByteSizeValue getEvicted() {  
 * - Utilization percentages
    public long getCacheHits() {
     */
    private final FileCacheStats pinnedFileCacheStats;
        return timestamp;
        static final String REMOVED = "removed";  
    @Override
    }
        static final String EVICTIONS_IN_BYTES = "evictions_in_bytes";
        static final String TOTAL_IN_BYTES = "total_in_bytes";  
        builder.field(Fields.USED_PERCENT, getUsedPercent());
        final long timestamp,
        this.overallFileCacheStats = overallFileCacheStats;  
        public static FileCacheStatsType fromString(String fileCacheStatsType) {  
 * this file be licensed under the Apache-2.0 license or a
    public FileCacheStats getOverallFileCacheStats() {  
        return new ByteSizeValue(overallFileCacheStats.getUsed());
    }
        this.pinnedFileCacheStats = new FileCacheStats(in);
        this.overallFileCacheStats = new FileCacheStats(in);
 * SPDX-License-Identifier: Apache-2.0
    }
        static final String AGGREGATE_FILE_CACHE = "aggregate_file_cache";
    public ByteSizeValue getTotal() {
 * - Cache performance (hits, misses, evictions)  
        builder.field(Fields.TIMESTAMP, getTimestamp());  
 */  
import org.opensearch.core.common.io.stream.StreamOutput;  
    public long getCacheMisses() {  
@ExperimentalApi
import org.opensearch.core.common.io.stream.StreamInput;
        builder.startObject(Fields.AGGREGATE_FILE_CACHE);
        blockFileCacheStats.toXContent(builder, params);
    }  
 * {@link FileCache} internally uses a {@link org.opensearch.index.store.remote.utils.cache.SegmentedCache}
 * The statistics are exposed via {@link org.opensearch.action.admin.cluster.node.stats.NodeStats}
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
    public long getTimestamp() {
    static final class Fields {
                .findFirst()
    public void writeTo(final StreamOutput out) throws IOException {
        return new ByteSizeValue(overallFileCacheStats.getActive());
        static final String USED_IN_BYTES = "used_in_bytes";
    public ByteSizeValue getPinnedUsage() {
        }  
    public static double calculatePercentageWithDecimals(long used, long max) {  
     *  File Cache Stats Type.
public class AggregateFileCacheStats implements Writeable, ToXContentFragment {
        static final String TIMESTAMP = "timestamp";  
        this.fullFileCacheStats = new FileCacheStats(in);  
        builder.field(Fields.ACTIVE_PERCENT, getActivePercent());
        pinnedFileCacheStats.toXContent(builder, params);
        final FileCacheStats blockFileCacheStats,
    public ByteSizeValue getRemoved() {
        builder.humanReadableField(Fields.ACTIVE_IN_BYTES, Fields.ACTIVE, getActive());
        static final String REMOVED_IN_BYTES = "removed_in_bytes";
    }
    private final FileCacheStats blockFileCacheStats;
    }
    }  
        static final String PINNED_IN_BYTES = "pinned_in_bytes";  
        static final String MISS_COUNT = "miss_count";  
        public String toString() {
        fullFileCacheStats.writeTo(out);
        }
 * - Memory usage (total, active, used)
    private final FileCacheStats overallFileCacheStats;
        this.fullFileCacheStats = fullFileCacheStats;
package org.opensearch.index.store.remote.filecache;
    public FileCacheStats getBlockFileCacheStats() {
    }
    }
        builder.humanReadableField(Fields.TOTAL_IN_BYTES, Fields.TOTAL, getTotal());
        final FileCacheStats overallFileCacheStats,  
        return pinnedFileCacheStats;  
        builder.humanReadableField(Fields.PINNED_IN_BYTES, Fields.PINNED, getPinnedUsage());
    }  
        private final String fileCacheStatsType;
        PINNED_FILE_STATS("pinned_file_stats");
    public short getActivePercent() {
}
 * to provide visibility into cache behavior and performance.  
        fullFileCacheStats.toXContent(builder, params);  
    @ExperimentalApi  
        overallFileCacheStats.writeTo(out);
        this.blockFileCacheStats = new FileCacheStats(in);
 * The OpenSearch Contributors require contributions made to  
        return overallFileCacheStats.getCacheMisses();
 * compatible open source license.
    // visible for testing.
    }  
        final FileCacheStats fullFileCacheStats,
/**  
    ) {
            return EnumSet.allOf(FileCacheStatsType.class)
    public ByteSizeValue getActive() {  
import org.opensearch.common.annotation.ExperimentalApi;
    @Override  
        @Override
        static final String EVICTIONS = "evictions";
    public AggregateFileCacheStats(final StreamInput in) throws IOException {  
        overallFileCacheStats.toXContent(builder, params);
        return new ByteSizeValue(overallFileCacheStats.getPinnedUsage());
        return overallFileCacheStats;
    }
        builder.humanReadableField(Fields.USED_IN_BYTES, Fields.USED, getUsed());  
        return new ByteSizeValue(overallFileCacheStats.getRemoved());
    public FileCacheStats getFullFileCacheStats() {
    }
    }
        this.timestamp = timestamp;
        blockFileCacheStats.writeTo(out);  
        return calculatePercentage(getUsed().getBytes(), getTotal().getBytes());  
        static final String PINNED = "pinned";
 * Statistics for the file cache system that tracks memory usage and performance metrics.
 *
        static final String ACTIVE_PERCENT = "active_percent";
    }
 *
        FileCacheStats pinnedFileCacheStats  
        return max <= 0 ? 0 : (short) (Math.round((100d * used) / max));  
        FileCacheStatsType(String fileCacheStatsType) {  
    public FileCacheStats getPinnedFileCacheStats() {
        pinnedFileCacheStats.writeTo(out);
        this.blockFileCacheStats = blockFileCacheStats;
    public enum FileCacheStatsType {
    }
        builder.field(Fields.HIT_COUNT, getCacheHits());  
import org.opensearch.core.xcontent.ToXContentFragment;  
        return calculatePercentageWithDecimals(overallFileCacheStats.getActive(), overallFileCacheStats.getTotal());  
            this.fileCacheStatsType = fileCacheStatsType;
    public double getOverallActivePercent() {
    public short getUsedPercent() {
        return new ByteSizeValue(overallFileCacheStats.getTotal());  
    }
import org.opensearch.core.xcontent.XContentBuilder;
    }
    public static short calculatePercentage(long used, long max) {
    public ByteSizeValue getUsed() {  
        }
        static final String TOTAL = "total";
 * @opensearch.api
    }
        FULL_FILE_STATS("full_file_stats"),
        builder.field(Fields.MISS_COUNT, getCacheMisses());
        builder.endObject();  
    /**  
        static final String HIT_COUNT = "hit_count";
 * to manage cached file data in memory segments.  
        return max <= 0 ? 0.0 : Math.round((100d * used) / max * 100.0) / 100.0;
        this.timestamp = in.readLong();
    public AggregateFileCacheStats(
        static final String USED_PERCENT = "used_percent";  
