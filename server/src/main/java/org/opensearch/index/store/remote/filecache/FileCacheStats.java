        this.pinned = pinned;
    private final long used;
 * Aggregates statistics across all cache segments including:  
        static final String USED = "used";
        return hits;  
import java.io.IOException;  
        return pinned;
    public long getPinnedUsage() {  
    }
    static final class Fields {
        }
 * - Memory usage: active and used bytes.
        static final String REMOVED_IN_BYTES = "removed_in_bytes";
    }
        static final String EVICTIONS_IN_BYTES = "evictions_in_bytes";  
        static final String ACTIVE_PERCENT = "active_percent";  
 * this file be licensed under the Apache-2.0 license or a
    public long getHits() {  
    private final long pinned;  
    public short getActivePercent() {
    }
        }
    public long getRemoved() {
import org.opensearch.core.common.io.stream.Writeable;  
        this.statsType = FileCacheStatsType.fromString(in.readString());
 * Statistics for the file cache system that tracks memory usage and performance metrics.
            this.removed = 0L;
    public long getUsed() {  
        out.writeLong(total);
        builder.humanReadableField(FileCacheStats.Fields.REMOVED_IN_BYTES, FileCacheStats.Fields.REMOVED, new ByteSizeValue(getRemoved()));
        static final String REMOVED = "removed";
        static final String MISS_COUNT = "miss_count";
            this.misses = 0L;  
 * to provide visibility into cache behavior and performance.
    @InternalApi
        );  
        out.writeLong(active);
 */
        this.evicted = evicted;
    ) {  
            FileCacheStats.Fields.EVICTIONS_IN_BYTES,  
 * SPDX-License-Identifier: Apache-2.0
/**
    public long getActive() {
        this.total = in.readLong();
    private final long misses;
 * @opensearch.api
        if (in.getVersion().onOrAfter(Version.V_3_4_0)) {
        this.active = in.readLong();  
        final long removed,
}
import org.opensearch.core.xcontent.ToXContentFragment;
    public long getCacheHits() {
import org.opensearch.Version;
    private final long total;
        this.active = active;
        } else {
    @Override
            out.writeLong(misses);
        return removed;  
 * The statistics are exposed as part of {@link AggregateFileCacheStats} and via {@link org.opensearch.action.admin.cluster.node.stats.NodeStats}
        return hits;
    private final long hits;  
    }
    @Override
        this.hits = hits;
    public long getEvicted() {
        final long used,
 * - Utilization: active percentage of total used memory.  
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats.FileCacheStatsType;
@PublicApi(since = "2.7.0")  
    }
    public FileCacheStats(
    }
        return total;  
    }
        out.writeString(statsType.toString());  
        builder.endObject();
    private final FileCacheStatsType statsType;
public class FileCacheStats implements Writeable, ToXContentFragment {
        static final String USED_IN_BYTES = "used_in_bytes";  
        static final String PINNED = "pinned";
        static final String ACTIVE_IN_BYTES = "active_in_bytes";  
    public short getUsedPercent() {
        builder.humanReadableField(FileCacheStats.Fields.ACTIVE_IN_BYTES, FileCacheStats.Fields.ACTIVE, new ByteSizeValue(getActive()));
        this.removed = removed;  
            FileCacheStats.Fields.EVICTIONS,
 */  
    private final long removed;
/*  
    }
        static final String PINNED_IN_BYTES = "pinned_in_bytes";
    public FileCacheStats(final StreamInput in) throws IOException {
        return misses;
        long total,
 *
        return used;
        final long evicted,
        builder.startObject(statsType.toString());
        this.used = in.readLong();
        FileCacheStatsType statsType
        this.used = used;  
 * - Cache performance: hit counts and eviction counts.
    }
        out.writeLong(hits);  
        return calculatePercentage(getUsed(), total);
        this.pinned = in.readLong();  
import org.opensearch.common.annotation.PublicApi;  
        static final String HIT_COUNT = "hit_count";
 * The OpenSearch Contributors require contributions made to  
        builder.humanReadableField(
    @InternalApi  
import org.opensearch.core.xcontent.XContentBuilder;  
    }  
        return active;  
            out.writeLong(removed);  
        builder.field(FileCacheStats.Fields.MISS_COUNT, getCacheMisses());
        final long hits,  
    private final long active;  
        if (out.getVersion().onOrAfter(Version.V_3_4_0)) {
        builder.field(FileCacheStats.Fields.HIT_COUNT, getHits());  
        out.writeLong(pinned);
    private final long evicted;
import org.opensearch.core.common.unit.ByteSizeValue;
import org.opensearch.common.annotation.InternalApi;
        builder.humanReadableField(FileCacheStats.Fields.USED_IN_BYTES, FileCacheStats.Fields.USED, new ByteSizeValue(getUsed()));  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        long misses,
        return builder;  
        out.writeLong(used);  
import static org.opensearch.index.store.remote.filecache.AggregateFileCacheStats.calculatePercentage;
 *  
    }  
    }  
            new ByteSizeValue(getEvicted())
    public long getTotal() {
        static final String EVICTIONS = "evictions";
        this.evicted = in.readLong();
        final long active,  
        builder.field(FileCacheStats.Fields.ACTIVE_PERCENT, getActivePercent());
        this.misses = misses;
    }
        return calculatePercentage(active, used);
            this.removed = in.readLong();
        builder.humanReadableField(FileCacheStats.Fields.PINNED_IN_BYTES, Fields.PINNED, new ByteSizeValue(getPinnedUsage()));
import org.opensearch.core.common.io.stream.StreamInput;
        this.statsType = statsType;  
        this.hits = in.readLong();
package org.opensearch.index.store.remote.filecache;
    }  
    public long getCacheMisses() {  
    }  
        this.total = total;
 * compatible open source license.
        final long pinned,  
        static final String ACTIVE = "active";
        out.writeLong(evicted);
        return evicted;
import org.opensearch.core.common.io.stream.StreamOutput;
            this.misses = in.readLong();  
    }
    public void writeTo(final StreamOutput out) throws IOException {
