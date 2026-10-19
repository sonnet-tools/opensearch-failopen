        out.writeLong(misses);
 *       Represents the byte volume of cache lookups currently executing concurrently.  
 *   <li>{@code removedBytes}    — cumulative bytes explicitly removed.
 *       (zero for memory-only implementations).</li>
        );
 *       (bandwidth actually saved by the cache).</li>  
    }
        builder.startObject("block_cache");
 *   <li>{@code evictions}       — cumulative count of LRU / capacity-driven eviction events.</li>  
        builder.field("active_in_bytes", activeInBytes);  
/*  
            tieredStats.toXContent(builder, params);
        out.writeLong(missBytes);  
 */  
        builder.field("active_percent", 0);  
 *
            in.readLong(),
@ExperimentalApi
        builder.field("pinned_in_bytes", 0);
        builder.field("miss_count", misses);
        builder.field("hit_count", 0);
        if (tieredStats != null) {  
import org.opensearch.core.common.io.stream.StreamInput;
        builder.field("hit_count", hits);  
 * implementations that do not track a particular metric should return zero for
 *       Mirrors the {@code removed} field in {@code FileCacheStats}.</li>  
        }
    public void writeTo(StreamOutput out) throws IOException {
 * Point-in-time snapshot of {@link BlockCache} counters.
            in.readLong(),
/**
        builder.field("active_percent", 0);
        out.writeLong(activeInBytes);
        builder.field("active_in_bytes", 0);
        builder.endObject();
 *       Used by {@code NodeCacheService.mergeStats()} to populate
        builder.field("evictions_in_bytes", 0);
        long missBytes,
            in.readLong(),
            evictionBytes,
        builder.field("used_in_bytes", 0);
            in.readLong(),
 *  
        builder.field("active_in_bytes", 0);
        if (out.getVersion().onOrAfter(org.opensearch.Version.V_3_8_0)) {  
        out.writeLong(memoryBytesUsed);
            memoryBytesUsed,
    }
        long misses,
        long hitBytes,  
        out.writeLong(hitBytes);
        return builder;
            activeInBytes,
 * <p><b>Field semantics:</b></p>
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        builder.field("evictions_in_bytes", evictionBytes);  
        builder.startObject(name);
    implements
    }
        long removed,
 * <p>Values are a snapshot at construction time and are not guaranteed to be  
 *   <li>{@code hits}            — cumulative count of lookups served from the cache.</li>  
        out.writeLong(evictions);
 * internally consistent across concurrent cache activity.
        builder.field("used_in_bytes", 0);  
        builder.field("pinned_in_bytes", 0);
        long hits,
        renderBlockCacheSubStats(builder, "over_all_stats");
    ) {
            in.readLong(),
import java.io.IOException;
        long totalBytes,
        builder.endObject();  
            in.readLong(),
        builder.field("used_in_bytes", diskBytesUsed + memoryBytesUsed);
            in.getVersion().onOrAfter(org.opensearch.Version.V_3_8_0) ? in.readOptionalWriteable(BlockCacheTieredStats::new) : null  
            in.readLong(),  
        out.writeLong(totalBytes);
        builder.field("pinned_in_bytes", 0);  
 *   <li>{@code hitBytes}        — cumulative bytes served from cache hits
 *       {@code removed_in_bytes} in the REST output.</li>  
        out.writeLong(diskBytesUsed);  
 * SPDX-License-Identifier: Apache-2.0
            misses,
        builder.field("active_percent", 0);
 * <p>Emitted for node-stats reporting and merging into
        builder.field("removed_in_bytes", 0);  
        this(
 *
 *  
            in.readLong(),  
 *       {@code total_in_bytes} in the REST output.</li>
            missBytes,  
        builder.endObject();  
 *   <li>{@code memoryBytesUsed} — current bytes occupied in the in-memory tier
            removed,  
 */
            null  
        out.writeLong(hits);  
        renderBlockCacheSubStats(builder, "block_file_stats");
            diskBytesUsed,  
        out.writeLong(removedBytes);
 * <ul>
 * @opensearch.experimental  
    private void renderBlockCacheSubStats(XContentBuilder builder, String name) throws IOException {
    private static void renderFullFileSubStats(XContentBuilder builder, String name) throws IOException {
        builder.field("removed_in_bytes", removedBytes);
 *       Used by {@code NodeCacheService.mergeStats()} to populate  
    private static void renderPinnedSubStats(XContentBuilder builder, String name) throws IOException {  
 *   <li>{@code evictionBytes}   — cumulative bytes displaced by evictions.
            totalBytes,
        long evictions,
    }
 * compatible open source license.
 *       (e.g. delete-index, segment rename, merge completion).
    public BlockCacheStats(StreamInput in) throws IOException {
        long removedBytes,
    }  
        out.writeLong(evictionBytes);
        long evictionBytes,  
        builder.field("removed_in_bytes", 0);
        builder.startObject(name);  
        }
 *   <li>{@code totalBytes}      — configured total capacity (memory + disk).
    public BlockCacheStats(  
    @Override
 * that field rather than throwing.
        long activeInBytes  
        builder.startObject(name);
 * this file be licensed under the Apache-2.0 license or a
 *       {@code evictions_in_bytes} in the REST output.</li>  
            hitBytes,
            out.writeOptionalWriteable(tieredStats);
    }
import org.opensearch.core.xcontent.ToXContentFragment;
 *   <li>{@code removed}         — cumulative count of explicit invalidations
            in.readLong(),  
import org.opensearch.core.xcontent.XContentBuilder;  
        long diskBytesUsed,
 * {@link org.opensearch.index.store.remote.filecache.AggregateFileCacheStats}.
    }  
        ToXContentFragment {
 *   <li>{@code diskBytesUsed}   — current bytes occupied in the on-disk tier  
        Writeable,  
        renderFullFileSubStats(builder, "full_file_stats");  
 *   <li>{@code activeInBytes}   — current bytes of reads in-flight (gauge, not cumulative).
 *
 *   <li>{@code missBytes}       — cumulative bytes fetched on cache misses
        builder.field("miss_count", 0);  
import org.opensearch.common.annotation.ExperimentalApi;
public record BlockCacheStats(long hits, long misses, long hitBytes, long missBytes, long evictions, long evictionBytes, long removed,  
 *       Used by {@code NodeCacheService.mergeStats()} to populate
}  
        renderPinnedSubStats(builder, "pinned_file_stats");
            in.readLong(),  
        out.writeLong(removed);  
import org.opensearch.core.common.io.stream.Writeable;
 *       (zero for disk-only implementations such as Foyer).</li>
package org.opensearch.plugins;
        builder.field("evictions_in_bytes", 0);
 *   <li>{@code misses}          — cumulative count of lookups that did not find an entry.</li>
        long memoryBytesUsed,  
            in.readLong(),
 * Every {@code BlockCache} implementation is expected to surface all counters;  
        this(
            evictions,
            in.readLong(),
 * The OpenSearch Contributors require contributions made to  
    @Override
        builder.field("miss_count", 0);
            hits,  
import org.opensearch.core.common.io.stream.StreamOutput;  
 *       (bytes that had to be read from the backing store).</li>
        );
        builder.field("hit_count", 0);
            removedBytes,
 * </ul>
    long removedBytes, long memoryBytesUsed, long diskBytesUsed, long totalBytes, long activeInBytes, BlockCacheTieredStats tieredStats)
        builder.endObject();
