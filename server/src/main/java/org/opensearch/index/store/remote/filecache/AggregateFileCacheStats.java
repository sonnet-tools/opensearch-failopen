@ExperimentalApi
        final FileCacheStats fullFileCacheStats,
    public FileCacheStats getOverallFileCacheStats() {
 * SPDX-License-Identifier: Apache-2.0
        public static FileCacheStatsType fromString(String fileCacheStatsType) {
            return fileCacheStatsType;
    }
        pinnedFileCacheStats.writeTo(out);
                .orElseThrow(() -> new IllegalArgumentException("Found invalid fileCacheStatsType."));
    @Override
        builder.humanReadableField(Fields.ACTIVE_IN_BYTES, Fields.ACTIVE, getActive());
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return new ByteSizeValue(overallFileCacheStats.getUsed());
 */
        }
        builder.field(Fields.USED_PERCENT, getUsedPercent());
                .stream()
        return max <= 0 ? 0 : (short) (Math.round((100d * used) / max));
        builder.field(Fields.ACTIVE_PERCENT, getActivePercent());
    }
import java.io.IOException;
package org.opensearch.index.store.remote.filecache;
    public FileCacheStats getFullFileCacheStats() {
        static final String TOTAL_IN_BYTES = "total_in_bytes";
        return builder;
        static final String MISS_COUNT = "miss_count";
        return new ByteSizeValue(overallFileCacheStats.getActive());
    public static double calculatePercentageWithDecimals(long used, long max) {
        static final String ACTIVE_IN_BYTES = "active_in_bytes";
     *  File Cache Stats Type.
import java.util.EnumSet;
    @ExperimentalApi
    public FileCacheStats getPinnedFileCacheStats() {
        return new ByteSizeValue(overallFileCacheStats.getTotal());
    }
        FileCacheStats pinnedFileCacheStats
        return overallFileCacheStats;
        return new ByteSizeValue(overallFileCacheStats.getEvicted());
 * Statistics for the file cache system that tracks memory usage and performance metrics.
    // visible for testing.
    }
    }
/*
        blockFileCacheStats.toXContent(builder, params);
import org.opensearch.common.annotation.ExperimentalApi;
    }
import org.opensearch.core.common.unit.ByteSizeValue;
            return EnumSet.allOf(FileCacheStatsType.class)
        this.overallFileCacheStats = new FileCacheStats(in);
        builder.field(Fields.HIT_COUNT, getCacheHits());
        builder.field(Fields.MISS_COUNT, getCacheMisses());
import org.opensearch.core.common.io.stream.StreamInput;
    public ByteSizeValue getEvicted() {
 * The OpenSearch Contributors require contributions made to
 * - Utilization percentages
        public String toString() {
    }
    }
        this.timestamp = timestamp;
        }
    private final FileCacheStats blockFileCacheStats;
        return new ByteSizeValue(overallFileCacheStats.getPinnedUsage());
        static final String EVICTIONS = "evictions";
    @Override
 * - Memory usage (total, active, used)
        fullFileCacheStats.writeTo(out);
        static final String USED = "used";
        return calculatePercentageWithDecimals(overallFileCacheStats.getActive(), overallFileCacheStats.getTotal());
    }
                .filter(f -> f.fileCacheStatsType.equals(fileCacheStatsType))
        return calculatePercentage(overallFileCacheStats.getActive(), overallFileCacheStats.getUsed());
     */
        pinnedFileCacheStats.toXContent(builder, params);
import org.opensearch.core.xcontent.ToXContentFragment;
 *
        static final String AGGREGATE_FILE_CACHE = "aggregate_file_cache";
    private final FileCacheStats overallFileCacheStats;
    public AggregateFileCacheStats(final StreamInput in) throws IOException {
        builder.startObject(Fields.AGGREGATE_FILE_CACHE);
        static final String EVICTIONS_IN_BYTES = "evictions_in_bytes";
    public long getCacheHits() {
        private final String fileCacheStatsType;
        return max <= 0 ? 0.0 : Math.round((100d * used) / max * 100.0) / 100.0;
        this.fullFileCacheStats = new FileCacheStats(in);
        return overallFileCacheStats.getCacheHits();
        final FileCacheStats overallFileCacheStats,
        FileCacheStatsType(String fileCacheStatsType) {
        return pinnedFileCacheStats;
    public ByteSizeValue getPinnedUsage() {
    }
    public long getTimestamp() {
        return fullFileCacheStats;
    /**
    }
        this.blockFileCacheStats = blockFileCacheStats;
        static final String TOTAL = "total";
    public ByteSizeValue getTotal() {
 * This class aggregates statistics across all cache segments including:
        static final String REMOVED = "removed";
        builder.endObject();
        builder.humanReadableField(Fields.REMOVED_IN_BYTES, Fields.REMOVED, getRemoved());
    }
 */
        static final String REMOVED_IN_BYTES = "removed_in_bytes";
        builder.humanReadableField(Fields.TOTAL_IN_BYTES, Fields.TOTAL, getTotal());
        builder.field(Fields.TIMESTAMP, getTimestamp());
        this.blockFileCacheStats = new FileCacheStats(in);
import org.opensearch.core.xcontent.XContentBuilder;
    public static short calculatePercentage(long used, long max) {
        return blockFileCacheStats;
    public enum FileCacheStatsType {
    public ByteSizeValue getUsed() {
        static final String PINNED_IN_BYTES = "pinned_in_bytes";
        static final String USED_IN_BYTES = "used_in_bytes";
    private final long timestamp;
        return timestamp;
        builder.humanReadableField(Fields.PINNED_IN_BYTES, Fields.PINNED, getPinnedUsage());
        static final String HIT_COUNT = "hit_count";
    private final FileCacheStats pinnedFileCacheStats;
    public void writeTo(final StreamOutput out) throws IOException {
        static final String ACTIVE_PERCENT = "active_percent";
    }
public class AggregateFileCacheStats implements Writeable, ToXContentFragment {
        OVER_ALL_STATS("over_all_stats"),
        final long timestamp,
        out.writeLong(timestamp);
    static final class Fields {
        static final String ACTIVE = "active";
        builder.humanReadableField(Fields.EVICTIONS_IN_BYTES, Fields.EVICTIONS, getEvicted());
 * The statistics are exposed via {@link org.opensearch.action.admin.cluster.node.stats.NodeStats}
 * to provide visibility into cache behavior and performance.
        this.pinnedFileCacheStats = new FileCacheStats(in);
    public ByteSizeValue getActive() {
    }
    public double getOverallActivePercent() {
 *
    ) {
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        static final String PINNED = "pinned";
        static final String USED_PERCENT = "used_percent";
    }
    }
        overallFileCacheStats.toXContent(builder, params);
    public short getActivePercent() {
        FULL_FILE_STATS("full_file_stats"),
        this.overallFileCacheStats = overallFileCacheStats;
        blockFileCacheStats.writeTo(out);
    }
        return new ByteSizeValue(overallFileCacheStats.getRemoved());
        this.timestamp = in.readLong();
    }
        fullFileCacheStats.toXContent(builder, params);
        return overallFileCacheStats.getCacheMisses();
            this.fileCacheStatsType = fileCacheStatsType;
        @Override
        return calculatePercentage(getUsed().getBytes(), getTotal().getBytes());
        static final String TIMESTAMP = "timestamp";
import org.opensearch.core.common.io.stream.StreamOutput;
}
                .findFirst()
 * to manage cached file data in memory segments.
/**
    }
    }
    public long getCacheMisses() {
 * @opensearch.api
        }
    }
import org.opensearch.core.common.io.stream.Writeable;
 * {@link FileCache} internally uses a {@link org.opensearch.index.store.remote.utils.cache.SegmentedCache}
    public AggregateFileCacheStats(
    public ByteSizeValue getRemoved() {
    }
        this.pinnedFileCacheStats = pinnedFileCacheStats;
    public short getUsedPercent() {
        PINNED_FILE_STATS("pinned_file_stats");
        BLOCK_FILE_STATS("block_file_stats"),
        builder.humanReadableField(Fields.USED_IN_BYTES, Fields.USED, getUsed());
    private final FileCacheStats fullFileCacheStats;
        overallFileCacheStats.writeTo(out);
        final FileCacheStats blockFileCacheStats,
    }
 * - Cache performance (hits, misses, evictions)
        this.fullFileCacheStats = fullFileCacheStats;
    public FileCacheStats getBlockFileCacheStats() {
