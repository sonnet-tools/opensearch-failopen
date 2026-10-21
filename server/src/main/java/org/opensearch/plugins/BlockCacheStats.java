 *       (bandwidth actually saved by the cache).</li>
import org.opensearch.common.annotation.ExperimentalApi;
 *
    private void renderBlockCacheSubStats(XContentBuilder builder, String name) throws IOException {
 * The OpenSearch Contributors require contributions made to
    @Override
 *
        this(
        out.writeLong(evictions);
            null
        builder.field("active_in_bytes", 0);
        long evictions,
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        builder.field("active_in_bytes", 0);
 *   <li>{@code hitBytes}        — cumulative bytes served from cache hits
        long hitBytes,
        out.writeLong(hitBytes);
    }
        builder.field("hit_count", hits);
 *       {@code total_in_bytes} in the REST output.</li>
 *   <li>{@code totalBytes}      — configured total capacity (memory + disk).
            out.writeOptionalWriteable(tieredStats);
            tieredStats.toXContent(builder, params);
 * this file be licensed under the Apache-2.0 license or a
 *   <li>{@code removedBytes}    — cumulative bytes explicitly removed.
 *
            in.readLong(),
 *       Mirrors the {@code removed} field in {@code FileCacheStats}.</li>
        return builder;
        out.writeLong(evictionBytes);
        builder.field("removed_in_bytes", 0);
 * SPDX-License-Identifier: Apache-2.0
 *       {@code evictions_in_bytes} in the REST output.</li>
            activeInBytes,
        long misses,
package org.opensearch.plugins;
            in.readLong(),
        if (out.getVersion().onOrAfter(org.opensearch.Version.V_3_8_0)) {
            in.readLong(),
            in.readLong(),
        );
        }
        Writeable,
        builder.field("pinned_in_bytes", 0);
            memoryBytesUsed,
            misses,
import org.opensearch.core.common.io.stream.StreamOutput;
            totalBytes,
        builder.startObject(name);
 * implementations that do not track a particular metric should return zero for
        builder.startObject(name);
        ToXContentFragment {
    }
        builder.field("miss_count", 0);
import java.io.IOException;
        builder.endObject();
        builder.field("active_percent", 0);
        builder.endObject();
        long diskBytesUsed,
 *       Represents the byte volume of cache lookups currently executing concurrently.
        long missBytes,
        builder.field("active_in_bytes", activeInBytes);
    public BlockCacheStats(StreamInput in) throws IOException {
            evictionBytes,
 */
/*
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
 *   <li>{@code activeInBytes}   — current bytes of reads in-flight (gauge, not cumulative).
 *   <li>{@code memoryBytesUsed} — current bytes occupied in the in-memory tier
        renderPinnedSubStats(builder, "pinned_file_stats");
import org.opensearch.core.xcontent.XContentBuilder;
    public BlockCacheStats(
    }
            hits,
            removedBytes,
    private static void renderPinnedSubStats(XContentBuilder builder, String name) throws IOException {
 * <p><b>Field semantics:</b></p>
 * compatible open source license.
 *   <li>{@code removed}         — cumulative count of explicit invalidations
 *       {@code removed_in_bytes} in the REST output.</li>
    @Override
 *   <li>{@code evictions}       — cumulative count of LRU / capacity-driven eviction events.</li>
 * </ul>
        out.writeLong(removed);
        long activeInBytes
        out.writeLong(diskBytesUsed);
        builder.field("active_percent", 0);
        builder.field("removed_in_bytes", 0);
        out.writeLong(removedBytes);
        }
    }
        long evictionBytes,
    private static void renderFullFileSubStats(XContentBuilder builder, String name) throws IOException {
 * that field rather than throwing.
        renderFullFileSubStats(builder, "full_file_stats");
 *   <li>{@code diskBytesUsed}   — current bytes occupied in the on-disk tier
        builder.field("hit_count", 0);
    }
        builder.endObject();
        if (tieredStats != null) {
 * Point-in-time snapshot of {@link BlockCache} counters.
        builder.field("active_percent", 0);
        renderBlockCacheSubStats(builder, "block_file_stats");
        long memoryBytesUsed,
import org.opensearch.core.common.io.stream.Writeable;
 *   <li>{@code missBytes}       — cumulative bytes fetched on cache misses
        builder.field("used_in_bytes", 0);
 *       (e.g. delete-index, segment rename, merge completion).
        );
    }
        builder.field("miss_count", 0);
        out.writeLong(misses);
 * <ul>
        builder.field("evictions_in_bytes", evictionBytes);
            in.readLong(),
        builder.endObject();
            removed,
        long removed,
        long totalBytes,
        out.writeLong(totalBytes);
        builder.field("evictions_in_bytes", 0);
    ) {
            in.readLong(),
 *
        builder.field("hit_count", 0);
            in.readLong(),
        long removedBytes,
 * {@link org.opensearch.index.store.remote.filecache.AggregateFileCacheStats}.
    implements
 * @opensearch.experimental
            in.readLong(),
            in.readLong(),
 */
 * <p>Values are a snapshot at construction time and are not guaranteed to be
        builder.startObject(name);
    }
        builder.field("removed_in_bytes", removedBytes);
        long hits,
            missBytes,
        builder.field("used_in_bytes", diskBytesUsed + memoryBytesUsed);
        this(
 *       Used by {@code NodeCacheService.mergeStats()} to populate
 *       Used by {@code NodeCacheService.mergeStats()} to populate
            diskBytesUsed,
            in.getVersion().onOrAfter(org.opensearch.Version.V_3_8_0) ? in.readOptionalWriteable(BlockCacheTieredStats::new) : null
        builder.startObject("block_cache");
            hitBytes,
            in.readLong(),
 *   <li>{@code evictionBytes}   — cumulative bytes displaced by evictions.
}
 * <p>Emitted for node-stats reporting and merging into
            evictions,
        out.writeLong(memoryBytesUsed);
        renderBlockCacheSubStats(builder, "over_all_stats");
 *   <li>{@code hits}            — cumulative count of lookups served from the cache.</li>
public record BlockCacheStats(long hits, long misses, long hitBytes, long missBytes, long evictions, long evictionBytes, long removed,
 *       Used by {@code NodeCacheService.mergeStats()} to populate
    long removedBytes, long memoryBytesUsed, long diskBytesUsed, long totalBytes, long activeInBytes, BlockCacheTieredStats tieredStats)
@ExperimentalApi
/**
 * Every {@code BlockCache} implementation is expected to surface all counters;
 *
        out.writeLong(hits);
 *       (bytes that had to be read from the backing store).</li>
import org.opensearch.core.xcontent.ToXContentFragment;
 *       (zero for disk-only implementations such as Foyer).</li>
        builder.field("pinned_in_bytes", 0);
            in.readLong(),
        out.writeLong(activeInBytes);
        builder.field("used_in_bytes", 0);
 * internally consistent across concurrent cache activity.
        builder.field("pinned_in_bytes", 0);
 *       (zero for memory-only implementations).</li>
        builder.field("miss_count", misses);
            in.readLong(),
 *   <li>{@code misses}          — cumulative count of lookups that did not find an entry.</li>
        out.writeLong(missBytes);
        builder.field("evictions_in_bytes", 0);
